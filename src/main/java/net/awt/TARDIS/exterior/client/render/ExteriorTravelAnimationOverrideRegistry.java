package net.awt.TARDIS.exterior.client.render;

import dev.amble.ait.client.tardis.ClientTardis;
import net.awt.TARDIS.exterior.client.model.exterior.OnionExterior;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class ExteriorTravelAnimationOverrideRegistry {
    private static final Map<Identifier, TypedOverride<?>> ENTRIES = new HashMap<>();

    static {
        registerShared("awt", Set.of(
            "redonion",
            "yellowonion",
            "blueonion",
            "whiteonion",
            "purpleonion",
            "greyonion",
            "pinkonion",
            "lightblueonion",
            "limegreenonion"
        ), OnionExterior.class, OnionExterior::applyTravelAnimation);
    }

    private ExteriorTravelAnimationOverrideRegistry() {
    }

    public static <T> void register(Identifier variantId, Class<T> modelType, TravelAnimationOverride<T> override) {
        ENTRIES.put(variantId, new TypedOverride<>(modelType, override));
    }

    public static <T> void registerShared(String namespace, Set<String> paths, Class<T> modelType, TravelAnimationOverride<T> override) {
        for (String path : paths) {
            register(new Identifier(namespace, "exterior/" + path), modelType, override);
        }
    }

    public static boolean apply(Identifier variantId, Object model, ClientTardis tardis, float tickDelta) {
        TypedOverride<?> entry = ENTRIES.get(variantId);
        if (entry == null || !entry.modelType().isInstance(model)) {
            return false;
        }

        return applyTyped(entry, model, tardis, tickDelta);
    }

    @SuppressWarnings("unchecked")
    private static <T> boolean applyTyped(TypedOverride<?> entry, Object model, ClientTardis tardis, float tickDelta) {
        TypedOverride<T> typedEntry = (TypedOverride<T>) entry;
        typedEntry.override().apply(typedEntry.modelType().cast(model), tardis, tickDelta);
        return true;
    }

    @FunctionalInterface
    public interface TravelAnimationOverride<T> {
        void apply(T model, ClientTardis tardis, float tickDelta);
    }

    private record TypedOverride<T>(Class<T> modelType, TravelAnimationOverride<T> override) {
    }
}
