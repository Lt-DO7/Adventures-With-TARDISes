package net.awt.mixin.console;

import dev.amble.ait.registry.impl.console.variant.ConsoleVariantRegistry;
import net.awt.TARDIS.console.AWTConsoleVariantRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ConsoleVariantRegistry.class)
public class ConsoleVariantRegistryMixin {

    @Inject(method = "defaults", at = @At("HEAD"), remap = false)
    private void defaults(CallbackInfo ci) {
        AWTConsoleVariantRegistry.registerConsoleVariants();

    }
}
