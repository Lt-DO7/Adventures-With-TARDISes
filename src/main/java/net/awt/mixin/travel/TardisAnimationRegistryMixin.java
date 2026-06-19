package net.awt.mixin.travel;

import dev.amble.ait.core.tardis.animation.v2.TardisAnimation;
import dev.amble.ait.core.tardis.animation.v2.datapack.TardisAnimationRegistry;
import dev.amble.ait.core.tardis.handler.travel.TravelHandlerBase;
import net.awt.TARDIS.exterior.client.animation.bridge.ExteriorAnimationBridgeRegistry;
import net.awt.TARDIS.exterior.client.animation.bridge.RuntimeBridgeTardisAnimation;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TardisAnimationRegistry.class)
public abstract class TardisAnimationRegistryMixin {
    @Inject(method = "instantiate", at = @At("HEAD"), cancellable = true)
    private void awt$instantiateBridgeAnimation(Identifier id, CallbackInfoReturnable<TardisAnimation> cir) {
        ExteriorAnimationBridgeRegistry.BridgeRuntimeEntry entry = ExteriorAnimationBridgeRegistry.getByRuntimeId(id);
        if (entry == null) {
            return;
        }

        cir.setReturnValue(new RuntimeBridgeTardisAnimation(id, entry.definition(), entry.state()));
    }
}
