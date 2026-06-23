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
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public class SkaroSecondSunMixin {

    private static final Identifier SUN_TEXTURE = new Identifier("textures/environment/sun.png");

    private static boolean awt$isSkaro() {
        MinecraftClient client = MinecraftClient.getInstance();
        return client.world != null && "skaro".equals(client.world.getRegistryKey().getValue().getPath());
    }

    @Inject(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/WorldRenderer;renderSky(Lnet/minecraft/client/util/math/MatrixStack;Lorg/joml/Matrix4f;FLnet/minecraft/client/render/Camera;ZLjava/lang/Runnable;)V", shift = At.Shift.AFTER))
    private void awt$renderSecondSun(MatrixStack matrices, float tickDelta, long limitTime, boolean renderBlockOutline, Camera camera, GameRenderer gameRenderer, LightmapTextureManager lightmapTextureManager, Matrix4f projectionMatrix, CallbackInfo ci) {
        if (!awt$isSkaro()) return;

        MinecraftClient client = MinecraftClient.getInstance();
        float celestialAngle = client.world.getSkyAngle(tickDelta);

        MatrixStack skyMatrices = new MatrixStack();
        skyMatrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-90.0F));
        skyMatrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(celestialAngle * 360.0F));
        skyMatrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(30.0F));

        Matrix4f modelMatrix = skyMatrices.peek().getPositionMatrix();
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
    }
}
