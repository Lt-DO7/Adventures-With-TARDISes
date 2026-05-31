package net.awt.mixin.console;

import dev.amble.ait.registry.impl.console.ConsoleRegistry;
import net.awt.TARDIS.console.AWTConsoleRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ConsoleRegistry.class)
public class ConsoleRegistryMixin {

    @Inject(method = "onCommonInit", at = @At("HEAD"), remap = false)
    private static void defaults(CallbackInfo ci) {
        AWTConsoleRegistry.registerConsoles();
    }
}
