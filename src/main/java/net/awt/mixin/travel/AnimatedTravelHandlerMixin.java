package net.awt.mixin.travel;

import dev.amble.ait.core.tardis.handler.travel.AnimatedTravelHandler;
import dev.amble.ait.core.tardis.handler.travel.TravelHandlerBase;
import net.awt.TARDIS.exterior.client.animation.bridge.ExteriorAnimationBridgeDefinition;
import net.awt.TARDIS.exterior.client.animation.bridge.ExteriorAnimationBridgeRegistry;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AnimatedTravelHandler.class)
public abstract class AnimatedTravelHandlerMixin {
    @Inject(method = "getAnimationIdFor", at = @At("HEAD"), cancellable = true)
    private void awt$useOnionAnimation(TravelHandlerBase.State state, CallbackInfoReturnable<Identifier> cir) {
        if (state != TravelHandlerBase.State.DEMAT && state != TravelHandlerBase.State.MAT) {
            return;
        }

        TravelHandlerBase handler = (TravelHandlerBase) (Object) this;
        var tardis = handler.tardis();
        if (tardis == null) {
            return;
        }

        Identifier variantId = tardis.getExterior().getVariant().id();
        ExteriorAnimationBridgeDefinition definition = ExteriorAnimationBridgeRegistry.getByVariant(variantId);
        if (definition == null) {
            return;
        }

        cir.setReturnValue(definition.idFor(state));
    }
}
