package net.awt.client.models.armor;

import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;

public class PrehistoricChestplateArmorModel extends BipedEntityModel<LivingEntity> {
    public PrehistoricChestplateArmorModel(ModelPart root) {
        super(root);
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();

        root.addChild("hat", ModelPartBuilder.create(), ModelTransform.NONE);
        root.addChild("head", ModelPartBuilder.create(), ModelTransform.NONE);
        root.addChild("right_leg", ModelPartBuilder.create(), ModelTransform.pivot(-1.9F, 12.0F, 0.0F));
        root.addChild("left_leg", ModelPartBuilder.create(), ModelTransform.pivot(1.9F, 12.0F, 0.0F));

        // body bone at (0,23,0) root - body pivot is (0,12,0) → offset (0,11,0)
        ModelPartData body = root.addChild("body", ModelPartBuilder.create(), ModelTransform.NONE);
        ModelPartData bodyBone = body.addChild("bodyBone", ModelPartBuilder.create()
                        .uv(0, 0).cuboid(-4.0F, -12.0F, -3.5F, 8.0F, 12.0F, 5.0F, new Dilation(0.0F))
                        .uv(0, 17).cuboid(-4.5F, -1.5F, -4.0F, 9.0F, 2.0F, 6.0F, new Dilation(0.0F))
                        .uv(20, 33).cuboid(-1.0F, -12.75F, 2.0F, 2.0F, 10.0F, 0.0F, new Dilation(0.0F))
                        .uv(38, 14).cuboid(-0.5F, -1.25F, -4.75F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)),
                ModelTransform.pivot(0.0F, 11.0F, 0.0F));

        bodyBone.addChild("cube_r1", ModelPartBuilder.create()
                        .uv(30, 33).cuboid(-2.0F, -2.0F, 1.0F, 3.0F, 6.0F, 0.0F, new Dilation(0.0F)),
                ModelTransform.of(2.9788F, 0.6786F, -5.0863F, -0.0436F, 0.0F, -0.3491F));
        bodyBone.addChild("cube_r2", ModelPartBuilder.create()
                        .uv(24, 33).cuboid(-2.0F, -2.0F, 1.0F, 3.0F, 6.0F, 0.0F, new Dilation(0.0F)),
                ModelTransform.of(-1.0391F, 1.0206F, -5.0863F, -0.0436F, 0.0F, 0.3491F));
        bodyBone.addChild("cube_r3", ModelPartBuilder.create()
                        .uv(36, 33).cuboid(-1.0F, -3.0F, -1.0F, 0.0F, 2.0F, 3.0F, new Dilation(0.0F)),
                ModelTransform.of(1.0F, -2.3585F, 1.6395F, -0.4363F, 0.0F, 0.0F));
        bodyBone.addChild("cube_r4", ModelPartBuilder.create()
                        .uv(36, 33).cuboid(-1.0F, -3.0F, -1.0F, 0.0F, 2.0F, 3.0F, new Dilation(0.0F)),
                ModelTransform.of(1.0F, 0.6415F, 1.6395F, -0.4363F, 0.0F, 0.0F));
        bodyBone.addChild("cube_r5", ModelPartBuilder.create()
                        .uv(30, 14).cuboid(-1.0F, -3.0F, -1.0F, 0.0F, 3.0F, 4.0F, new Dilation(0.0F)),
                ModelTransform.of(1.0F, -7.3585F, 1.6395F, -1.0908F, 0.0F, 0.0F));
        bodyBone.addChild("cube_r6", ModelPartBuilder.create()
                        .uv(30, 14).cuboid(-1.0F, -3.0F, -1.0F, 0.0F, 3.0F, 4.0F, new Dilation(0.0F)),
                ModelTransform.of(1.0F, -10.3585F, 1.6395F, -1.0908F, 0.0F, 0.0F));
        bodyBone.addChild("cube_r7", ModelPartBuilder.create()
                        .uv(8, 37).cuboid(-1.0F, -11.0F, -1.0F, 4.0F, 3.0F, 0.0F, new Dilation(0.0F)),
                ModelTransform.of(-4.1279F, -1.5F, 2.4639F, 0.0F, -0.1745F, 0.0F));
        bodyBone.addChild("cube_r8", ModelPartBuilder.create()
                        .uv(0, 37).cuboid(-1.0F, -11.0F, -1.0F, 4.0F, 3.0F, 0.0F, new Dilation(0.0F)),
                ModelTransform.of(2.1583F, -1.5F, 2.8112F, 0.0F, 0.1745F, 0.0F));
        bodyBone.addChild("cube_r9", ModelPartBuilder.create()
                        .uv(38, 17).cuboid(-1.0F, -13.0F, -1.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F)),
                ModelTransform.of(0.0F, 10.2692F, 1.2946F, -0.1309F, 0.0F, 0.0F));

        // right_arm at (0,0,0) relative to bone(0,23,0) = (0,23,0) root
        // rightArm pivot (-5,2,0) → offset (5,21,0)
        ModelPartData rightArm = root.addChild("right_arm", ModelPartBuilder.create(), ModelTransform.pivot(-5.0F, 2.0F, 0.0F));
        ModelPartData rightArmBone = rightArm.addChild("rightArmBone", ModelPartBuilder.create()
                        .uv(20, 25).cuboid(-9.01F, -12.5F, -3.5F, 5.0F, 3.0F, 5.0F, new Dilation(0.0F))
                        .uv(26, 0).cuboid(-9.0F, -1.5F, -3.5F, 2.0F, 2.0F, 5.0F, new Dilation(0.0F))
                        .uv(26, 7).cuboid(7.0F, -1.5F, -3.5F, 2.0F, 2.0F, 5.0F, new Dilation(0.0F))
                        .uv(30, 21).cuboid(-9.0F, -14.5F, -0.75F, 5.0F, 2.0F, 0.0F, new Dilation(0.0F))
                        .uv(30, 23).cuboid(-9.0F, -14.5F, -1.25F, 5.0F, 2.0F, 0.0F, new Dilation(0.0F)),
                ModelTransform.pivot(5.0F, 21.0F, 0.0F));
        rightArmBone.addChild("cube_r10", ModelPartBuilder.create()
                        .uv(26, 14).cuboid(-1.0F, -3.0F, 1.0F, 2.0F, 3.0F, 0.0F, new Dilation(0.0F)),
                ModelTransform.of(-5.0F, -12.25F, -2.0F, 0.0F, 0.0F, -0.4363F));
        rightArmBone.addChild("cube_r11", ModelPartBuilder.create()
                        .uv(16, 37).cuboid(-1.0F, -3.0F, 1.0F, 2.0F, 4.0F, 0.0F, new Dilation(0.0F)),
                ModelTransform.of(-8.0F, -12.5F, -2.0F, 0.0F, 0.0F, -0.4363F));

        // left_arm at (0,0,0) relative to bone(0,23,0) = (0,23,0) root
        // leftArm pivot (5,2,0) → offset (-5,21,0)
        ModelPartData leftArm = root.addChild("left_arm", ModelPartBuilder.create(), ModelTransform.pivot(5.0F, 2.0F, 0.0F));
        leftArm.addChild("leftArmBone", ModelPartBuilder.create()
                        .uv(0, 25).cuboid(4.01F, -12.5F, -3.5F, 5.0F, 7.0F, 5.0F, new Dilation(0.0F)),
                ModelTransform.pivot(-5.0F, 21.0F, 0.0F));

        return TexturedModelData.of(modelData, 64, 64);
    }
}
