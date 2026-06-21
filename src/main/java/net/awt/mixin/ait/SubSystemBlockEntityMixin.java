package net.awt.mixin.ait;

import dev.amble.ait.core.engine.block.SubSystemBlockEntity;
import dev.amble.ait.core.engine.block.generic.GenericStructureSystemBlockEntity;
import net.awt.amblekit.ait.integration.AWTSubsystemBridge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = SubSystemBlockEntity.class, remap = false)
public class SubSystemBlockEntityMixin {
    @Inject(method = "onGainFluid", at = @At("TAIL"))
    private void awt$onGainFluid(CallbackInfo ci) {
        if ((Object) this instanceof GenericStructureSystemBlockEntity generic) {
            AWTSubsystemBridge.onLinkStateChanged(generic, true);
        }
    }

    @Inject(method = "onLoseFluid", at = @At("TAIL"))
    private void awt$onLoseFluid(CallbackInfo ci) {
        if ((Object) this instanceof GenericStructureSystemBlockEntity generic) {
            AWTSubsystemBridge.onLinkStateChanged(generic, false);
        }
    }
}
