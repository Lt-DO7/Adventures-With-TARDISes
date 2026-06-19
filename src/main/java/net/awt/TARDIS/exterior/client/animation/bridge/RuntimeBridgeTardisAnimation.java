package net.awt.TARDIS.exterior.client.animation.bridge;

import dev.amble.ait.core.tardis.animation.v2.TardisAnimation;
import dev.amble.ait.core.tardis.animation.v2.keyframe.AnimationKeyframe;
import dev.amble.ait.core.tardis.animation.v2.keyframe.KeyframeTracker;
import dev.amble.ait.core.tardis.handler.travel.TravelHandlerBase;
import net.awt.TARDIS.exterior.client.animation.ExteriorAnimationApplier;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Identifier;
import org.joml.Vector3f;

import java.util.List;

public final class RuntimeBridgeTardisAnimation extends TardisAnimation {
    private final ExteriorAnimationBridgeDefinition definition;
    private final Animation sourceAnimation;
    private final TravelHandlerBase.State expectedState;
    private int elapsedTicks;

    public RuntimeBridgeTardisAnimation(Identifier id, ExteriorAnimationBridgeDefinition definition, TravelHandlerBase.State expectedState) {
        super(
            id,
            definition.soundFor(expectedState),
            awt$constantFloatTracker(awt$totalDurationTicks(definition.animationFor(expectedState)), 1.0f),
            awt$constantVectorTracker(awt$totalDurationTicks(definition.animationFor(expectedState)), new Vector3f(1.0f, 1.0f, 1.0f)),
            awt$constantVectorTracker(awt$totalDurationTicks(definition.animationFor(expectedState)), new Vector3f()),
            awt$constantVectorTracker(awt$totalDurationTicks(definition.animationFor(expectedState)), new Vector3f())
        );
        this.definition = definition;
        this.sourceAnimation = definition.animationFor(expectedState);
        this.expectedState = expectedState;
        this.elapsedTicks = 0;
    }

    public ExteriorAnimationBridgeDefinition definition() {
        return definition;
    }

    public Animation sourceAnimation() {
        return sourceAnimation;
    }

    public float elapsedSeconds(float tickDelta) {
        return Math.min((elapsedTicks + tickDelta) / 20.0f, sourceAnimation.lengthInSeconds());
    }

    @Override
    public void tick(MinecraftClient client) {
        super.tick(client);
        elapsedTicks++;
    }

    @Override
    public void tick(MinecraftServer server) {
        super.tick(server);
        elapsedTicks++;
    }

    @Override
    public boolean isAged() {
        return elapsedTicks >= awt$totalDurationTicks(sourceAnimation);
    }

    @Override
    public void age() {
        super.age();
        elapsedTicks = awt$totalDurationTicks(sourceAnimation);
    }

    @Override
    public void dispose() {
        super.dispose();
        elapsedTicks = 0;
    }

    @Override
    public Vector3f getPosition(float tickDelta) {
        return ExteriorAnimationApplier.evaluateVector(
            sourceAnimation,
            definition.rootBone(),
            net.minecraft.client.render.entity.animation.Transformation.Targets.TRANSLATE,
            elapsedSeconds(tickDelta),
            new Vector3f()
        );
    }

    @Override
    public Vector3f getRotation(float tickDelta) {
        return ExteriorAnimationApplier.evaluateVector(
            sourceAnimation,
            definition.rootBone(),
            net.minecraft.client.render.entity.animation.Transformation.Targets.ROTATE,
            elapsedSeconds(tickDelta),
            new Vector3f()
        );
    }

    @Override
    public TravelHandlerBase.State getExpectedState() {
        return expectedState;
    }

    @Override
    public String name() {
        return this.id().toString();
    }

    @Override
    public TardisAnimation instantiate() {
        return new RuntimeBridgeTardisAnimation(this.id(), definition, expectedState);
    }

    private static KeyframeTracker<Float> awt$constantFloatTracker(int durationTicks, float value) {
        return new KeyframeTracker<>(List.of(new AnimationKeyframe<>(
            Math.max(1, durationTicks),
            AnimationKeyframe.Interpolation.LINEAR,
            new AnimationKeyframe.InterpolatedFloat(value, value)
        )));
    }

    private static KeyframeTracker<Vector3f> awt$constantVectorTracker(int durationTicks, Vector3f value) {
        return new KeyframeTracker<>(List.of(new AnimationKeyframe<>(
            Math.max(1, durationTicks),
            AnimationKeyframe.Interpolation.LINEAR,
            new AnimationKeyframe.InterpolatedVector3f(new Vector3f(value), new Vector3f(value))
        )));
    }

    private static int awt$totalDurationTicks(Animation animation) {
        return Math.max(1, Math.round(animation.lengthInSeconds() * 20.0f));
    }
}
