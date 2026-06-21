package net.awt.entity.client;

import net.awt.entity.custom.LaserEntity;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class LaserModel<T extends LaserEntity> extends SinglePartEntityModel<T> {
    private final ModelPart root;

    public LaserModel(ModelPart root) {
        this.root = root.getChild("laser");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();

        root.addChild(
                "laser",
                ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -1.0F, -2.5F, 2.0F, 2.0F, 5.0F, new Dilation(0.0F)),
                ModelTransform.NONE
        );

        return TexturedModelData.of(modelData, 16, 16);
    }

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        this.root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart getPart() {
        return this.root;
    }
}
