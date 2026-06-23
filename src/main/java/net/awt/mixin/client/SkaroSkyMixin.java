package net.awt.mixin.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public class SkaroSkyMixin {

    private static final Identifier SUN_TEXTURE = new Identifier("textures/environment/sun.png");

    private static boolean awt$isMondas() {
        MinecraftClient client = MinecraftClient.getInstance();
        return client.world != null && "mondas".equals(client.world.getRegistryKey().getValue().getPath());
    }

    private static boolean awt$isSkaro() {
        MinecraftClient client = MinecraftClient.getInstance();
        return client.world != null && "skaro".equals(client.world.getRegistryKey().getValue().getPath());
    }

    @Redirect(method = "renderSky", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;setShaderTexture(ILnet/minecraft/util/Identifier;)V", ordinal = 0))
    private void awt$redirectSunTexture(int unit, Identifier id) {
        if (awt$isMondas()) return;
        RenderSystem.setShaderTexture(unit, id);
    }

    @Redirect(method = "renderSky", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;setShaderTexture(ILnet/minecraft/util/Identifier;)V", ordinal = 1))
    private void awt$redirectMoonTexture(int unit, Identifier id) {
        if (awt$isMondas()) return;
        RenderSystem.setShaderTexture(unit, id);
    }

    @Inject(method = "renderSky", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;setShaderTexture(ILnet/minecraft/util/Identifier;)V", ordinal = 1, shift = At.Shift.BEFORE))
    private void awt$renderSecondSun(MatrixStack matrices, Matrix4f projectionMatrix, float tickDelta, Camera camera, boolean foggy, Runnable fogCallback, CallbackInfo ci) {
        if (!awt$isSkaro()) return;

        MinecraftClient client = MinecraftClient.getInstance();
        float celestialAngle = client.world.getSkyAngle(tickDelta);

        matrices.push();
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-90.0F));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(celestialAngle * 360.0F));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(30.0F));

        Matrix4f modelMatrix = matrices.peek().getPositionMatrix();
        float sunSize = 25.0F;

        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderTexture(0, SUN_TEXTURE);

        BufferBuilder bufferBuilder = Tessellator.getInstance().getBuffer();
        bufferBuilder.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);
        bufferBuilder.vertex(modelMatrix, -sunSize, -sunSize, -100.0F).texture(0.0F, 0.0F);
        bufferBuilder.vertex(modelMatrix, -sunSize, sunSize, -100.0F).texture(0.0F, 1.0F);
        bufferBuilder.vertex(modelMatrix, sunSize, sunSize, -100.0F).texture(1.0F, 1.0F);
        bufferBuilder.vertex(modelMatrix, sunSize, -sunSize, -100.0F).texture(1.0F, 0.0F);
        BufferRenderer.drawWithGlobalProgram(bufferBuilder.end());

        matrices.pop();
    }
}
