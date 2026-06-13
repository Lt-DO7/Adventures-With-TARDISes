package net.awt.TARDIS.exterior.client.model.exterior;

import dev.amble.ait.api.tardis.link.v2.Linkable;
import dev.amble.ait.client.models.exteriors.SimpleExteriorModel;
import dev.amble.ait.client.tardis.ClientTardis;
import dev.amble.ait.core.blockentities.ExteriorBlockEntity;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.RotationAxis;

public class SeigedOnion extends SimpleExteriorModel {
    private final ModelPart root;
    private final ModelPart body;
    private final ModelPart hat;

    public SeigedOnion(ModelPart root) {
        this.root = root.getChild("Root");
        this.body = this.root.getChild("Body");
        this.hat = this.body.getChild("Hat");
    }

    public SeigedOnion() {
        this(getTexturedModelData().createModel());
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData root = modelPartData.addChild(
            "Root",
            ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, 3.5F, -7.0F, 16.0F, 10.0F, 14.0F, new Dilation(0.0F)),
            ModelTransform.of(0.0F, 10.5F, 0.0F, 0.0F, 3.1416F, 0.0F)
        );

        root.addChild(
            "top_bottom_r1",
            ModelPartBuilder.create().uv(0, 48).cuboid(-2.0F, -7.0F, -7.0F, 12.0F, 14.0F, 14.0F, new Dilation(0.0F)),
            ModelTransform.of(0.0F, 12.5F, 0.0F, -1.5708F, 0.0F, -1.5708F)
        );

        root.addChild(
            "front_back_r1",
            ModelPartBuilder.create().uv(0, 24).cuboid(-8.0F, -9.0F, -7.0F, 16.0F, 10.0F, 14.0F, new Dilation(0.0F)),
            ModelTransform.of(0.0F, 12.5F, 0.0F, 0.0F, 1.5708F, 0.0F)
        );

        ModelPartData body = root.addChild("Body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 12.5F, 0.0F));
        ModelPartData hat = body.addChild("Hat", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.0F, 0.0F));

        hat.addChild(
            "Top_r1",
            ModelPartBuilder.create().uv(60, 44).cuboid(10.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)),
            ModelTransform.of(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, -1.5708F)
        );

        hat.addChild(
            "Mid_r1",
            ModelPartBuilder.create().uv(36, 76).cuboid(10.0F, -2.0F, -2.0F, 1.0F, 4.0F, 4.0F, new Dilation(0.0F)),
            ModelTransform.of(0.0F, 1.0F, 0.0F, -1.5708F, 0.0F, -1.5708F)
        );

        hat.addChild(
            "Low_r1",
            ModelPartBuilder.create().uv(52, 48).cuboid(10.0F, -5.0F, -5.0F, 1.0F, 10.0F, 10.0F, new Dilation(0.0F)),
            ModelTransform.of(0.0F, 2.0F, 0.0F, -1.5708F, 0.0F, -1.5708F)
        );

        return TexturedModelData.of(modelData, 128, 128);
    }

    @Override
    public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    @Override
    public void renderDoors(ClientTardis tardis, ExteriorBlockEntity exteriorBlockEntity, ModelPart modelPart, MatrixStack matrixStack, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha, boolean isBOTI) {
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        root.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public <T extends Entity & Linkable> void renderEntity(T falling, ModelPart root, MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        matrices.push();
        matrices.translate(0.0f, -1.5f, 0.0f);
        super.renderEntity(falling, root, matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        matrices.pop();
    }

    @Override
    public void renderWithAnimations(ClientTardis tardis, ExteriorBlockEntity exterior, ModelPart root, MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha, float tickDelta) {
        matrices.push();
        matrices.translate(0.5f, 1.5f, 0.5f);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180.0f));
        super.renderWithAnimations(tardis, exterior, root, matrices, vertices, light, overlay, red, green, blue, alpha, tickDelta);
        matrices.pop();
    }

    @Override
    public ModelPart getPart() {
        return root;
    }
}
