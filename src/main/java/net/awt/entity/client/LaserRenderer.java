package net.awt.entity.client;

import net.awt.AdventuresWithTARDISes;
import net.awt.entity.custom.LaserEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Vector3f;

public class LaserRenderer extends EntityRenderer<LaserEntity> {
    private static final Identifier RED_TEXTURE = new Identifier(AdventuresWithTARDISes.MOD_ID, "textures/entity/laser/red.png");
    private static final Identifier YELLOW_TEXTURE = new Identifier(AdventuresWithTARDISes.MOD_ID, "textures/entity/laser/yellow.png");
    private static final Identifier BLUE_TEXTURE = new Identifier(AdventuresWithTARDISes.MOD_ID, "textures/entity/laser/blue.png");

    public LaserRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public void render(LaserEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(tickDelta, entity.prevYaw, entity.getYaw()) - 90.0F));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp(tickDelta, entity.prevPitch, entity.getPitch())));

        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(RenderLayer.getEntityTranslucent(this.getTexture(entity)));
        float[] color = this.getRenderColor(entity);
        this.renderBeam(matrices, vertexConsumer, 0.65F, 0.12F, color[0], color[1], color[2], 0.45F);
        this.renderBeam(matrices, vertexConsumer, 0.65F, 0.045F, 1.0F, 1.0F, 1.0F, 0.95F);
        matrices.pop();

        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }

    private void renderBeam(MatrixStack matrices, VertexConsumer vertexConsumer, float halfLength, float halfWidth,
                            float red, float green, float blue, float alpha) {
        MatrixStack.Entry entry = matrices.peek();
        Matrix4f positionMatrix = entry.getPositionMatrix();
        Matrix3f normalMatrix = entry.getNormalMatrix();

        this.renderPlaneXy(vertexConsumer, positionMatrix, normalMatrix, halfLength, halfWidth, red, green, blue, alpha);
        this.renderPlaneXz(vertexConsumer, positionMatrix, normalMatrix, halfLength, halfWidth, red, green, blue, alpha);
    }

    private void renderPlaneXy(VertexConsumer vertexConsumer, Matrix4f positionMatrix, Matrix3f normalMatrix,
                               float halfLength, float halfWidth, float red, float green, float blue, float alpha) {
        this.vertex(vertexConsumer, positionMatrix, normalMatrix, -halfLength, -halfWidth, 0.0F, 0.0F, 1.0F, red, green, blue, alpha);
        this.vertex(vertexConsumer, positionMatrix, normalMatrix, halfLength, -halfWidth, 0.0F, 1.0F, 1.0F, red, green, blue, alpha);
        this.vertex(vertexConsumer, positionMatrix, normalMatrix, halfLength, halfWidth, 0.0F, 1.0F, 0.0F, red, green, blue, alpha);
        this.vertex(vertexConsumer, positionMatrix, normalMatrix, -halfLength, halfWidth, 0.0F, 0.0F, 0.0F, red, green, blue, alpha);
    }

    private void renderPlaneXz(VertexConsumer vertexConsumer, Matrix4f positionMatrix, Matrix3f normalMatrix,
                               float halfLength, float halfWidth, float red, float green, float blue, float alpha) {
        this.vertex(vertexConsumer, positionMatrix, normalMatrix, -halfLength, 0.0F, -halfWidth, 0.0F, 1.0F, red, green, blue, alpha);
        this.vertex(vertexConsumer, positionMatrix, normalMatrix, halfLength, 0.0F, -halfWidth, 1.0F, 1.0F, red, green, blue, alpha);
        this.vertex(vertexConsumer, positionMatrix, normalMatrix, halfLength, 0.0F, halfWidth, 1.0F, 0.0F, red, green, blue, alpha);
        this.vertex(vertexConsumer, positionMatrix, normalMatrix, -halfLength, 0.0F, halfWidth, 0.0F, 0.0F, red, green, blue, alpha);
    }

    private void vertex(VertexConsumer vertexConsumer, Matrix4f positionMatrix, Matrix3f normalMatrix,
                        float x, float y, float z, float u, float v, float red, float green, float blue, float alpha) {
        vertexConsumer.vertex(positionMatrix, x, y, z)
                .color(red, green, blue, alpha)
                .texture(u, v)
                .overlay(OverlayTexture.DEFAULT_UV)
                .light(LightmapTextureManager.MAX_LIGHT_COORDINATE)
                .normal(normalMatrix, 0.0F, 1.0F, 0.0F)
                .next();
    }

    private float[] getRenderColor(LaserEntity entity) {
        Vector3f color = entity.getLaserColor().particleColor();
        return new float[]{color.x(), color.y(), color.z()};
    }

    @Override
    public Identifier getTexture(LaserEntity entity) {
        return switch (entity.getLaserColor()) {
            case YELLOW -> YELLOW_TEXTURE;
            case BLUE -> BLUE_TEXTURE;
            default -> RED_TEXTURE;
        };
    }
}
