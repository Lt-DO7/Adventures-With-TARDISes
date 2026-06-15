package net.awt.TARDIS.exterior.client.animation;

import dev.amble.ait.client.tardis.ClientTardis;
import dev.amble.ait.core.tardis.animation.v2.AnimationHolder;
import dev.amble.ait.core.tardis.animation.v2.TardisAnimation;
import dev.amble.ait.core.tardis.handler.travel.TravelHandlerBase;
import net.awt.mixin.client.AnimationHolderAccessor;
import net.awt.mixin.client.TardisAnimationAccessor;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;
import net.minecraft.util.Identifier;
import org.joml.Vector3f;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ExteriorAnimationApplier {
    private static final Field MODEL_PART_CHILDREN_FIELD = awt$findChildrenField();

    private ExteriorAnimationApplier() {
    }

    public static void reset(ModelPart root) {
        root.traverse().forEach(ModelPart::resetTransform);
    }

    public static boolean apply(Identifier variantId, ClientTardis tardis, ModelPart root, float tickDelta) {
        ExteriorAnimationSet animationSet = ExteriorAnimationRegistry.get(variantId);
        if (animationSet == null) {
            return false;
        }

        Animation animation = switch (tardis.travel().getState()) {
            case DEMAT -> animationSet.takeoff();
            case MAT -> animationSet.landing();
            default -> null;
        };
        if (animation == null) {
            return false;
        }

        float durationTicks = awt$getCurrentDurationTicks(tardis.travel().getAnimations());
        float elapsedTicks = ((float) tardis.travel().getAnimations().getTicks()) + tickDelta;
        float elapsedSeconds = awt$resolveAnimationTime(animation, elapsedTicks, durationTicks);
        awt$applyAnimation(root, animation, elapsedSeconds, 1.0f);
        return true;
    }

    private static float awt$getCurrentDurationTicks(AnimationHolder holder) {
        TardisAnimation current = ((AnimationHolderAccessor) holder).awt$getCurrent();
        if (current == null) {
            return 0.0f;
        }

        return ((TardisAnimationAccessor) current).awt$getAlphaTracker().duration();
    }

    private static float awt$resolveAnimationTime(Animation animation, float elapsedTicks, float durationTicks) {
        float animationLength = animation.lengthInSeconds();
        if (durationTicks <= 0.0f) {
            return Math.min(elapsedTicks / 20.0f, animationLength);
        }

        float normalized = Math.max(0.0f, Math.min(1.0f, elapsedTicks / durationTicks));
        return normalized * animationLength;
    }

    private static void awt$applyAnimation(ModelPart root, Animation animation, float elapsedSeconds, float scale) {
        Vector3f cache = new Vector3f();
        Map<String, ModelPart> boneMap = new HashMap<>();
        awt$collectParts("Root", root, boneMap);

        for (Map.Entry<String, List<Transformation>> entry : animation.boneAnimations().entrySet()) {
            ModelPart part = boneMap.get(entry.getKey());
            if (part == null) {
                continue;
            }

            for (Transformation transformation : entry.getValue()) {
                awt$applyTransformation(elapsedSeconds, cache, scale, part, transformation);
            }
        }
    }

    private static void awt$applyTransformation(float elapsedSeconds, Vector3f cache, float scale, ModelPart part, Transformation transformation) {
        Keyframe[] keyframes = transformation.keyframes();
        int startIndex = Math.max(0, awt$binarySearch(elapsedSeconds, keyframes) - 1);
        int endIndex = Math.min(keyframes.length - 1, startIndex + 1);
        Keyframe start = keyframes[startIndex];
        Keyframe end = keyframes[endIndex];
        float delta = elapsedSeconds - start.timestamp();
        float progress = endIndex != startIndex
            ? Math.max(0.0f, Math.min(1.0f, delta / (end.timestamp() - start.timestamp())))
            : 0.0f;
        end.interpolation().apply(cache, progress, keyframes, startIndex, endIndex, scale);
        transformation.target().apply(part, cache);
    }

    private static int awt$binarySearch(float elapsedSeconds, Keyframe[] keyframes) {
        int low = 0;
        int high = keyframes.length;
        while (low < high) {
            int middle = (low + high) >>> 1;
            if (elapsedSeconds <= keyframes[middle].timestamp()) {
                high = middle;
            } else {
                low = middle + 1;
            }
        }
        return low;
    }

    @SuppressWarnings("unchecked")
    private static void awt$collectParts(String name, ModelPart part, Map<String, ModelPart> boneMap) {
        boneMap.put(name, part);
        try {
            Map<String, ModelPart> children = (Map<String, ModelPart>) MODEL_PART_CHILDREN_FIELD.get(part);
            for (Map.Entry<String, ModelPart> entry : children.entrySet()) {
                awt$collectParts(entry.getKey(), entry.getValue(), boneMap);
            }
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Unable to inspect model part children", e);
        }
    }

    private static Field awt$findChildrenField() {
        for (Field field : ModelPart.class.getDeclaredFields()) {
            if (!Map.class.isAssignableFrom(field.getType())) {
                continue;
            }

            Type genericType = field.getGenericType();
            if (!(genericType instanceof ParameterizedType parameterizedType)) {
                continue;
            }

            Type[] typeArguments = parameterizedType.getActualTypeArguments();
            if (typeArguments.length != 2) {
                continue;
            }

            if (typeArguments[0] != String.class || typeArguments[1] != ModelPart.class) {
                continue;
            }

            field.setAccessible(true);
            return field;
        }

        throw new IllegalStateException("Unable to locate ModelPart child map field");
    }
}
