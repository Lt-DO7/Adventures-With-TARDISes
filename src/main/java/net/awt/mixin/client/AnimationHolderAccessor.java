package net.awt.mixin.client;

import dev.amble.ait.core.tardis.animation.v2.AnimationHolder;
import dev.amble.ait.core.tardis.animation.v2.TardisAnimation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(AnimationHolder.class)
public interface AnimationHolderAccessor {
    @Accessor("current")
    TardisAnimation awt$getCurrent();
}
