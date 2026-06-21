package net.awt.mixin.client;

import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.client.render.Camera;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import com.mojang.blaze3d.systems.RenderSystem;

@Mixin(BackgroundRenderer.class)
public class MondasFogMixin {

    @Inject(method = "applyFog", at = @At("HEAD"), cancellable = true)
    private static void awt$mondasFog(Camera camera,
                                      BackgroundRenderer.FogType fogType,
                                      float viewDistance,
                                      boolean thickFog,
                                      float tickDelta,
                                      CallbackInfo ci) {

        if (camera.getFocusedEntity() == null) return;

        World world = camera.getFocusedEntity().getWorld();

        if (world.getRegistryKey().getValue().getPath().equals("mondas")) {

            RenderSystem.setShaderFogStart(1.0F);
            RenderSystem.setShaderFogEnd(16.0F);
            ci.cancel();
        }
    }
}