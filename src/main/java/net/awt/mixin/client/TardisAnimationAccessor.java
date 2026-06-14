package net.awt.mixin.client;

import dev.amble.ait.core.tardis.animation.v2.TardisAnimation;
import dev.amble.ait.core.tardis.animation.v2.keyframe.KeyframeTracker;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = TardisAnimation.class, remap = false)
public interface TardisAnimationAccessor {
    @Accessor("alpha")
    KeyframeTracker<Float> awt$getAlphaTracker();
}
