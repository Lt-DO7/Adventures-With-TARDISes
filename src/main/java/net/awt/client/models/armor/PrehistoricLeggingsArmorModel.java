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

public class PrehistoricLeggingsArmorModel extends BipedEntityModel<LivingEntity> {
    public PrehistoricLeggingsArmorModel(ModelPart root) {
        super(root);
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();

        root.addChild("hat", ModelPartBuilder.create(), ModelTransform.NONE);
        root.addChild("head", ModelPartBuilder.create(), ModelTransform.NONE);
        root.addChild("right_arm", ModelPartBuilder.create(), ModelTransform.pivot(-5.0F, 2.0F, 0.0F));
        root.addChild("left_arm", ModelPartBuilder.create(), ModelTransform.pivot(5.0F, 2.0F, 0.0F));

        // bone at (0,24,0) → body pivot (0,12,0) → offset (0,12,0)
        ModelPartData body = root.addChild("body", ModelPartBuilder.create(), ModelTransform.NONE);
        body.addChild("bodyBelt", ModelPartBuilder.create()
                        .uv(0, 0).cuboid(-4.0F, -14.0F, -3.0F, 8.0F, 5.0F, 4.0F, new Dilation(0.0F)),
                ModelTransform.pivot(0.0F, 12.0F, 0.0F));

        // right_leg at (-4,0,0) relative to bone(0,24,0) = (-4,24,0) root
        // rightLeg pivot (-1.9,12,0) → offset (-2.1,12,0)
        ModelPartData rightLeg = root.addChild("right_leg", ModelPartBuilder.create(), ModelTransform.pivot(-1.9F, 12.0F, 0.0F));
        ModelPartData rightLegArmor = rightLeg.addChild("rightLegArmor", ModelPartBuilder.create()
                        .uv(14, 22).cuboid(-3.5F, -8.0F, -3.25F, 3.0F, 4.0F, 0.0F, new Dilation(0.0F))
                        .uv(16, 9).cuboid(-4.0F, -10.0F, -3.0F, 4.0F, 9.0F, 4.0F, new Dilation(0.0F)),
                ModelTransform.pivot(-2.1F, 12.0F, 0.0F));
        rightLegArmor.addChild("cube_r1", ModelPartBuilder.create()
                        .uv(8, 26).cuboid(-1.0F, -3.0F, -1.0F, 0.0F, 3.0F, 2.0F, new Dilation(0.0F))
                        .uv(24, 0).cuboid(-1.5F, -4.0F, -1.0F, 0.0F, 4.0F, 2.0F, new Dilation(0.0F))
                        .uv(4, 26).cuboid(-2.0F, -3.0F, -1.0F, 0.0F, 3.0F, 2.0F, new Dilation(0.0F)),
                ModelTransform.of(-0.5F, -5.4226F, -2.5937F, 0.4363F, 0.0F, 0.0F));

        // left leg mirrored: child at (4,24,0) root → leftLeg pivot (1.9,12,0) → offset (2.1,12,0)
        ModelPartData leftLeg = root.addChild("left_leg", ModelPartBuilder.create(), ModelTransform.pivot(1.9F, 12.0F, 0.0F));
        ModelPartData leftLegArmor = leftLeg.addChild("leftLegArmor", ModelPartBuilder.create()
                        .uv(8, 22).cuboid(0.5F, -8.0F, -3.25F, 3.0F, 4.0F, 0.0F, new Dilation(0.0F))
                        .uv(0, 9).cuboid(0.0F, -10.0F, -3.0F, 4.0F, 9.0F, 4.0F, new Dilation(0.0F)),
                ModelTransform.pivot(2.1F, 12.0F, 0.0F));
        leftLegArmor.addChild("cube_r2", ModelPartBuilder.create()
                        .uv(0, 26).cuboid(1.0F, -3.0F, -1.0F, 0.0F, 3.0F, 2.0F, new Dilation(0.0F))
                        .uv(24, 22).cuboid(1.5F, -4.0F, -1.0F, 0.0F, 4.0F, 2.0F, new Dilation(0.0F))
                        .uv(20, 22).cuboid(2.0F, -3.0F, -1.0F, 0.0F, 3.0F, 2.0F, new Dilation(0.0F)),
                ModelTransform.of(0.5F, -5.4226F, -2.5937F, 0.4363F, 0.0F, 0.0F));

        return TexturedModelData.of(modelData, 32, 32);
    }
}
