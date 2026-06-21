package net.awt.entity.client;

import net.awt.entity.custom.ProtoCybermanEntity;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class ProtoCybermanModel<T extends ProtoCybermanEntity> extends SinglePartEntityModel<T> {
    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart torso;
    private final ModelPart leftArm;
    private final ModelPart rightArm;
    private final ModelPart leftLeg;
    private final ModelPart rightLeg;

    public ProtoCybermanModel(ModelPart root) {
        this.root = root.getChild("proto_cyberman");
        this.head = this.root.getChild("head");
        this.torso = this.root.getChild("torso");
        this.leftArm = this.root.getChild("left_arm");
        this.rightArm = this.root.getChild("right_arm");
        this.leftLeg = this.root.getChild("left_leg");
        this.rightLeg = this.root.getChild("right_leg");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();
        ModelPartData proto = root.addChild("proto_cyberman", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 16.0F, -1.0F));

        ModelPartData head = proto.addChild("head", ModelPartBuilder.create()
                        .uv(40, 54).cuboid(-1.0F, -1.25F, -2.0F, 2.0F, 2.0F, 2.0F)
                        .uv(0, 0).cuboid(-4.0F, -8.25F, -4.75F, 8.0F, 8.0F, 8.0F),
                ModelTransform.pivot(0.0F, -15.0F, 1.0F));

        head.addChild("head_detail", ModelPartBuilder.create()
                        .uv(16, 54).cuboid(-13.0F, -28.0F, 7.0F, 2.0F, 3.0F, 3.0F)
                        .uv(26, 54).cuboid(-5.0F, -28.0F, 7.0F, 2.0F, 3.0F, 3.0F)
                        .uv(48, 54).cuboid(-3.0F, -33.0F, 8.0F, 1.0F, 7.0F, 1.0F)
                        .uv(0, 55).cuboid(-14.0F, -33.0F, 8.0F, 1.0F, 7.0F, 1.0F)
                        .uv(32, 14).cuboid(-13.0F, -33.0F, 8.0F, 10.0F, 1.0F, 1.0F)
                        .uv(20, 30).cuboid(-10.0F, -32.0F, 5.0F, 4.0F, 3.0F, 7.0F),
                ModelTransform.pivot(8.0F, 22.25F, -9.0F));

        ModelPartData torso = proto.addChild("torso", ModelPartBuilder.create()
                        .uv(0, 43).cuboid(-3.0F, -3.0F, -2.5F, 6.0F, 2.0F, 3.0F)
                        .uv(32, 0).cuboid(-4.0F, -5.5F, -3.0F, 8.0F, 3.0F, 4.0F)
                        .uv(0, 16).cuboid(-4.5F, -13.25F, -3.5F, 9.0F, 8.0F, 5.0F)
                        .uv(42, 37).cuboid(-1.0F, -5.25F, -3.5F, 2.0F, 1.0F, 2.0F)
                        .uv(4, 59).cuboid(-1.0F, -2.0F, -2.0F, 2.0F, 2.0F, 2.0F),
                ModelTransform.pivot(0.0F, -2.0F, 1.0F));

        torso.addChild("chestpiece", ModelPartBuilder.create()
                        .uv(52, 59).cuboid(-9.0F, -20.0F, 5.0F, 2.0F, 2.0F, 2.0F)
                        .uv(62, 26).cuboid(-10.0F, -20.0F, 5.0F, 1.0F, 2.0F, 2.0F)
                        .uv(62, 30).cuboid(-7.0F, -20.0F, 5.0F, 1.0F, 2.0F, 2.0F)
                        .uv(56, 4).cuboid(-9.0F, -18.0F, 5.0F, 2.0F, 1.0F, 2.0F)
                        .uv(62, 23).cuboid(-9.0F, -21.0F, 5.0F, 2.0F, 1.0F, 2.0F),
                ModelTransform.pivot(8.0F, 10.0F, -9.0F));

        ModelPartData leftArm = proto.addChild("left_arm", ModelPartBuilder.create()
                        .uv(16, 60).cuboid(-1.05F, -1.0F, -1.125F, 2.0F, 2.0F, 2.0F)
                        .uv(20, 40).cuboid(-0.55F, -2.0F, -2.125F, 4.0F, 10.0F, 4.0F)
                        .uv(52, 37).cuboid(0.45F, 8.0F, -2.125F, 3.0F, 1.0F, 4.0F),
                ModelTransform.pivot(5.0F, -13.0F, 0.0F));

        leftArm.addChild("left_arm_detail", ModelPartBuilder.create()
                        .uv(24, 60).cuboid(-1.05F, -16.25F, 7.125F, 2.0F, 2.0F, 2.0F)
                        .uv(60, 59).cuboid(-1.05F, -22.25F, 7.125F, 2.0F, 2.0F, 2.0F)
                        .uv(36, 54).cuboid(0.95F, -21.75F, 7.625F, 1.0F, 7.0F, 1.0F),
                ModelTransform.pivot(3.0F, 21.0F, -8.0F));

        ModelPartData rightArm = proto.addChild("right_arm", ModelPartBuilder.create()
                        .uv(4, 55).cuboid(-1.05F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F)
                        .uv(36, 40).cuboid(-3.55F, -2.0F, -2.0F, 4.0F, 10.0F, 4.0F)
                        .uv(52, 42).cuboid(-3.55F, 8.0F, -2.0F, 3.0F, 1.0F, 4.0F),
                ModelTransform.pivot(-5.0F, -13.0F, 0.0F));

        rightArm.addChild("right_arm_detail", ModelPartBuilder.create()
                        .uv(56, 0).cuboid(-17.05F, -16.25F, 6.75F, 2.0F, 2.0F, 2.0F)
                        .uv(40, 58).cuboid(-17.05F, -22.25F, 6.75F, 2.0F, 2.0F, 2.0F)
                        .uv(12, 55).cuboid(-18.05F, -21.75F, 7.25F, 1.0F, 7.0F, 1.0F),
                ModelTransform.pivot(13.0F, 21.0F, -8.0F));

        proto.addChild("left_leg", ModelPartBuilder.create()
                        .uv(32, 7).cuboid(0.75F, 10.0F, -5.25F, 4.0F, 1.0F, 6.0F)
                        .uv(28, 16).cuboid(0.25F, 1.0F, -3.5F, 5.0F, 9.0F, 5.0F)
                        .uv(0, 48).cuboid(0.5F, -0.75F, -3.0F, 4.0F, 3.0F, 4.0F)
                        .uv(48, 23).cuboid(3.25F, -1.0F, -3.5F, 2.0F, 2.0F, 5.0F)
                        .uv(52, 47).cuboid(2.25F, 0.0F, -3.5F, 1.0F, 1.0F, 5.0F),
                ModelTransform.pivot(0.0F, -3.0F, 1.0F));

        proto.addChild("right_leg", ModelPartBuilder.create()
                        .uv(42, 30).cuboid(-4.5F, 10.0F, -5.25F, 4.0F, 1.0F, 6.0F)
                        .uv(0, 29).cuboid(-5.25F, 1.0F, -3.5F, 5.0F, 9.0F, 5.0F)
                        .uv(48, 16).cuboid(-4.5F, -0.75F, -3.0F, 4.0F, 3.0F, 4.0F)
                        .uv(52, 7).cuboid(-5.25F, -1.0F, -3.5F, 2.0F, 2.0F, 5.0F)
                        .uv(52, 53).cuboid(-3.25F, 0.0F, -3.5F, 1.0F, 1.0F, 5.0F),
                ModelTransform.pivot(0.0F, -3.0F, 1.0F));

        return TexturedModelData.of(modelData, 128, 128);
    }

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        this.head.yaw = headYaw * ((float) Math.PI / 180F);
        this.head.pitch = headPitch * ((float) Math.PI / 180F);
        this.leftLeg.pitch = MathHelper.cos(limbAngle * 0.6662F) * 1.2F * limbDistance;
        this.rightLeg.pitch = MathHelper.cos(limbAngle * 0.6662F + (float) Math.PI) * 1.2F * limbDistance;
        this.leftArm.pitch = MathHelper.cos(limbAngle * 0.6662F + (float) Math.PI) * 0.9F * limbDistance;
        this.rightArm.pitch = MathHelper.cos(limbAngle * 0.6662F) * 0.9F * limbDistance;
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
