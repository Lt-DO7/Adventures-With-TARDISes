package net.awt.mixin.console;

import dev.amble.ait.data.schema.console.ClientConsoleVariantSchema;
import dev.amble.ait.registry.impl.console.variant.ClientConsoleVariantRegistry;
import dev.amble.lib.register.datapack.DatapackRegistry;
import net.awt.TARDIS.console.client.AWTClientConsoleVariantRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientConsoleVariantRegistry.class)
public abstract class ClientConsoleVariantRegistryMixin {

    @Shadow
    public static DatapackRegistry<ClientConsoleVariantSchema> getInstance() {
        return INSTANCE;
    }

    @Shadow private static ClientConsoleVariantRegistry INSTANCE;

    @Inject(method = "onClientInit", at = @At("HEAD"), remap = false)
    private void defaults(CallbackInfo ci) {
        AWTClientConsoleVariantRegistry.registerClientConsoleVariants(getInstance());
    }
}
