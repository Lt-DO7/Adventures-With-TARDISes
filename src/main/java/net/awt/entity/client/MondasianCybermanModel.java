package net.awt.entity.client;

import net.awt.entity.custom.MondasianCybermanEntity;
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

public class MondasianCybermanModel<T extends MondasianCybermanEntity> extends SinglePartEntityModel<T> {
    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart torso;
    private final ModelPart leftArm;
    private final ModelPart rightArm;
    private final ModelPart leftLeg;
    private final ModelPart rightLeg;

    public MondasianCybermanModel(ModelPart root) {
        this.root = root.getChild("mondasian_cyberman");
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
        ModelPartData cyberman = root.addChild("mondasian_cyberman", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 19.0F, 0.0F));

        ModelPartData head = cyberman.addChild("head", ModelPartBuilder.create()
                        .uv(0, 0).cuboid(-4.0F, -9.0F, -4.0F, 8.0F, 9.0F, 8.0F)
                        .uv(8, 49).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F),
                ModelTransform.pivot(0.0F, -19.0F, 0.0F));

        head.addChild("handlebars", ModelPartBuilder.create()
                        .uv(16, 49).cuboid(-1.0F, -10.0F, -1.0F, 2.0F, 2.0F, 2.0F)
                        .uv(32, 45).cuboid(-2.0F, -14.0F, -2.0F, 4.0F, 4.0F, 4.0F)
                        .uv(40, 29).cuboid(-6.25F, -5.0F, -1.0F, 3.0F, 2.0F, 2.0F)
                        .uv(48, 12).cuboid(3.25F, -5.0F, -1.0F, 3.0F, 2.0F, 2.0F)
                        .uv(0, 49).cuboid(5.0F, -12.75F, -0.5F, 1.0F, 9.0F, 1.0F)
                        .uv(4, 49).cuboid(-6.0F, -12.75F, -0.5F, 1.0F, 9.0F, 1.0F)
                        .uv(40, 27).cuboid(-5.0F, -12.75F, -0.5F, 10.0F, 1.0F, 1.0F),
                ModelTransform.NONE);

        ModelPartData torso = cyberman.addChild("torso", ModelPartBuilder.create()
                        .uv(0, 17).cuboid(-4.0F, -14.0F, -2.0F, 8.0F, 12.0F, 4.0F)
                        .uv(32, 33).cuboid(-9.0F, -14.25F, -2.5F, 6.0F, 1.0F, 5.0F)
                        .uv(32, 39).cuboid(3.0F, -14.25F, -2.5F, 6.0F, 1.0F, 5.0F)
                        .uv(40, 16).cuboid(-3.0F, -14.0F, -3.5F, 6.0F, 9.0F, 2.0F)
                        .uv(48, 0).cuboid(-2.0F, -5.5F, -4.25F, 4.0F, 3.0F, 3.0F),
                ModelTransform.pivot(0.0F, -5.0F, 0.0F));

        torso.addChild("chest_right", ModelPartBuilder.create()
                        .uv(48, 45).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 3.0F, 3.0F),
                ModelTransform.of(2.5F, -3.5F, -3.0F, 0.0F, -0.3927F, 0.0F));

        torso.addChild("chest_left", ModelPartBuilder.create()
                        .uv(48, 6).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 3.0F, 3.0F),
                ModelTransform.of(-2.5F, -3.5F, -3.0F, 0.0F, 0.3927F, 0.0F));

        ModelPartData rightArm = cyberman.addChild("right_arm", ModelPartBuilder.create(),
                ModelTransform.pivot(-5.0F, -16.0F, 0.0F));
        rightArm.addChild("right_arm_main", ModelPartBuilder.create()
                        .uv(24, 17).cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F),
                ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0524F));

        ModelPartData leftArm = cyberman.addChild("left_arm", ModelPartBuilder.create(),
                ModelTransform.pivot(5.0F, -16.0F, 0.0F));
        leftArm.addChild("left_arm_main", ModelPartBuilder.create()
                        .uv(32, 0).cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F),
                ModelTransform.of(2.0F, -1.0F, 0.0F, 0.0F, 0.0F, -0.0524F));

        cyberman.addChild("right_leg", ModelPartBuilder.create()
                        .uv(16, 33).cuboid(0.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F),
                ModelTransform.pivot(0.0F, -6.0F, 0.0F));

        cyberman.addChild("left_leg", ModelPartBuilder.create()
                        .uv(0, 33).cuboid(-4.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F),
                ModelTransform.pivot(0.0F, -6.0F, 0.0F));

        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        this.head.roll = 0.0F;
        this.leftArm.roll = 0.0F;
        this.rightArm.roll = 0.0F;
        this.head.yaw = headYaw * ((float) Math.PI / 180F);
        this.head.pitch = headPitch * ((float) Math.PI / 180F);
        this.leftLeg.pitch = MathHelper.cos(limbAngle * 0.6662F) * 1.1F * limbDistance;
        this.rightLeg.pitch = MathHelper.cos(limbAngle * 0.6662F + (float) Math.PI) * 1.1F * limbDistance;
        this.leftArm.pitch = MathHelper.cos(limbAngle * 0.6662F + (float) Math.PI) * 0.7F * limbDistance;
        this.rightArm.pitch = MathHelper.cos(limbAngle * 0.6662F) * 0.7F * limbDistance;
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
