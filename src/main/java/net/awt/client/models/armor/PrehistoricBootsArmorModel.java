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

public class PrehistoricBootsArmorModel extends BipedEntityModel<LivingEntity> {
    public PrehistoricBootsArmorModel(ModelPart root) {
        super(root);
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();

        root.addChild("hat", ModelPartBuilder.create(), ModelTransform.NONE);
        root.addChild("head", ModelPartBuilder.create(), ModelTransform.NONE);
        root.addChild("body", ModelPartBuilder.create(), ModelTransform.NONE);
        root.addChild("right_arm", ModelPartBuilder.create(), ModelTransform.pivot(-5.0F, 2.0F, 0.0F));
        root.addChild("left_arm", ModelPartBuilder.create(), ModelTransform.pivot(5.0F, 2.0F, 0.0F));

        // bone2 at (-1,0,0) relative to bone(0,24,0) = (-1,24,0) root
        // rightLeg pivot (-1.9,12,0) → offset (0.9,12,0)
        ModelPartData rightLeg = root.addChild("right_leg", ModelPartBuilder.create(), ModelTransform.pivot(-1.9F, 12.0F, 0.0F));
        ModelPartData rightBoot = rightLeg.addChild("rightBoot", ModelPartBuilder.create()
                        .uv(0, 0).cuboid(-7.0F, -4.0F, -4.0F, 5.0F, 4.0F, 5.0F, new Dilation(0.0F))
                        .uv(0, 18).cuboid(-6.5F, -8.0F, -3.25F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F)),
                ModelTransform.pivot(0.9F, 12.0F, 0.0F));
        addRightBootDetails(rightBoot);

        // mirrored: bone2 at (1,24,0) root → leftLeg pivot (1.9,12,0) → offset (-0.9,12,0)
        ModelPartData leftLeg = root.addChild("left_leg", ModelPartBuilder.create(), ModelTransform.pivot(1.9F, 12.0F, 0.0F));
        ModelPartData leftBoot = leftLeg.addChild("leftBoot", ModelPartBuilder.create()
                        .uv(0, 0).cuboid(2.0F, -4.0F, -4.0F, 5.0F, 4.0F, 5.0F, new Dilation(0.0F))
                        .uv(0, 18).cuboid(2.5F, -8.0F, -3.25F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F)),
                ModelTransform.pivot(-0.9F, 12.0F, 0.0F));
        addLeftBootDetails(leftBoot);

        return TexturedModelData.of(modelData, 32, 32);
    }

    private static void addRightBootDetails(ModelPartData leg) {
        leg.addChild("strap_front_upper", ModelPartBuilder.create()
                        .uv(0, 9).cuboid(-1.0F, -2.0F, 1.0F, 4.0F, 2.0F, 0.0F, new Dilation(0.0F)),
                ModelTransform.of(-5.5F, -3.7786F, 0.4943F, 0.3491F, 0.0F, 0.0F));
        leg.addChild("strap_back_upper", ModelPartBuilder.create()
                        .uv(0, 9).cuboid(-1.0F, -2.0F, 1.0F, 4.0F, 2.0F, 0.0F, new Dilation(0.0F)),
                ModelTransform.of(-5.5F, -4.4626F, -4.8737F, -0.3491F, 0.0F, 0.0F));
        leg.addChild("strap_front_lower", ModelPartBuilder.create()
                        .uv(0, 11).cuboid(-1.0F, -2.0F, 1.0F, 4.0F, 2.0F, 0.0F, new Dilation(0.0F)),
                ModelTransform.of(-5.5F, -5.7786F, 0.4943F, 0.3491F, 0.0F, 0.0F));
        leg.addChild("strap_back_lower", ModelPartBuilder.create()
                        .uv(0, 11).cuboid(-1.0F, -2.0F, 1.0F, 4.0F, 2.0F, 0.0F, new Dilation(0.0F)),
                ModelTransform.of(-5.5F, -6.4626F, -4.8737F, -0.3491F, 0.0F, 0.0F));
        leg.addChild("side_blade_inner_upper", ModelPartBuilder.create()
                        .uv(0, 7).cuboid(1.0F, -2.0F, -3.0F, 0.0F, 2.0F, 4.0F, new Dilation(0.0F)),
                ModelTransform.of(-2.7547F, -5.7789F, -0.25F, 0.0F, 0.0F, -0.3491F));
        leg.addChild("side_blade_outer_upper", ModelPartBuilder.create()
                        .uv(0, 7).cuboid(1.0F, -2.0F, -3.0F, 0.0F, 2.0F, 4.0F, new Dilation(0.0F)),
                ModelTransform.of(-8.1228F, -6.4623F, -0.25F, 0.0F, 0.0F, 0.3491F));
        leg.addChild("side_blade_inner_lower", ModelPartBuilder.create()
                        .uv(0, 5).cuboid(1.0F, -2.0F, -3.0F, 0.0F, 2.0F, 4.0F, new Dilation(0.0F)),
                ModelTransform.of(-2.7547F, -3.7789F, -0.25F, 0.0F, 0.0F, -0.3491F));
        leg.addChild("side_blade_outer_lower", ModelPartBuilder.create()
                        .uv(0, 5).cuboid(1.0F, -2.0F, -3.0F, 0.0F, 2.0F, 4.0F, new Dilation(0.0F)),
                ModelTransform.of(-8.1228F, -4.4623F, -0.25F, 0.0F, 0.0F, 0.3491F));
        leg.addChild("toe_spike_right_top", ModelPartBuilder.create()
                        .uv(6, 26).cuboid(-1.0F, -3.0F, -2.0F, 0.0F, 3.0F, 3.0F, new Dilation(0.0F)),
                ModelTransform.of(-5.25F, 0.3257F, -4.4847F, 0.0886F, 0.1739F, 0.0154F));
        leg.addChild("toe_spike_right_bottom", ModelPartBuilder.create()
                        .uv(6, 26).cuboid(-1.0F, -3.0F, -2.0F, 0.0F, 3.0F, 3.0F, new Dilation(0.0F)),
                ModelTransform.of(-4.25F, 0.0757F, -4.4847F, 0.2214F, 0.1704F, 0.0381F));
        leg.addChild("toe_spike_left_top", ModelPartBuilder.create()
                        .uv(0, 26).cuboid(-1.0F, -3.0F, -2.0F, 0.0F, 3.0F, 3.0F, new Dilation(0.0F)),
                ModelTransform.of(-1.75F, 0.3257F, -4.2847F, 0.0873F, -0.0435F, -0.0038F));
        leg.addChild("toe_spike_left_bottom", ModelPartBuilder.create()
                        .uv(0, 26).cuboid(-1.0F, -3.0F, -2.0F, 0.0F, 3.0F, 3.0F, new Dilation(0.0F)),
                ModelTransform.of(-2.75F, 0.0757F, -4.2847F, 0.2214F, -0.1704F, -0.0381F));
        leg.addChild("heel_spike_top", ModelPartBuilder.create()
                        .uv(20, 3).cuboid(-1.0F, -3.0F, -3.0F, 0.0F, 3.0F, 4.0F, new Dilation(0.0F)),
                ModelTransform.of(-3.5F, 0.5757F, 3.2653F, -0.1222F, 0.0F, 0.0F));
        leg.addChild("heel_spike_bottom", ModelPartBuilder.create()
                        .uv(20, 0).cuboid(-1.0F, -3.0F, -3.0F, 0.0F, 3.0F, 4.0F, new Dilation(0.0F)),
                ModelTransform.of(-3.5F, -0.1743F, -4.4847F, 0.1222F, 0.0F, 0.0F));
    }

    private static void addLeftBootDetails(ModelPartData leg) {
        leg.addChild("strap_front_upper", ModelPartBuilder.create()
                        .uv(0, 9).cuboid(-1.0F, -2.0F, 1.0F, 4.0F, 2.0F, 0.0F, new Dilation(0.0F)),
                ModelTransform.of(5.5F, -3.7786F, 0.4943F, 0.3491F, 0.0F, 0.0F));
        leg.addChild("strap_back_upper", ModelPartBuilder.create()
                        .uv(0, 9).cuboid(-1.0F, -2.0F, 1.0F, 4.0F, 2.0F, 0.0F, new Dilation(0.0F)),
                ModelTransform.of(5.5F, -4.4626F, -4.8737F, -0.3491F, 0.0F, 0.0F));
        leg.addChild("strap_front_lower", ModelPartBuilder.create()
                        .uv(0, 11).cuboid(-1.0F, -2.0F, 1.0F, 4.0F, 2.0F, 0.0F, new Dilation(0.0F)),
                ModelTransform.of(5.5F, -5.7786F, 0.4943F, 0.3491F, 0.0F, 0.0F));
        leg.addChild("strap_back_lower", ModelPartBuilder.create()
                        .uv(0, 11).cuboid(-1.0F, -2.0F, 1.0F, 4.0F, 2.0F, 0.0F, new Dilation(0.0F)),
                ModelTransform.of(5.5F, -6.4626F, -4.8737F, -0.3491F, 0.0F, 0.0F));
        leg.addChild("side_blade_outer_upper", ModelPartBuilder.create()
                        .uv(0, 7).cuboid(1.0F, -2.0F, -3.0F, 0.0F, 2.0F, 4.0F, new Dilation(0.0F)),
                ModelTransform.of(8.1228F, -5.7789F, -0.25F, 0.0F, 0.0F, 0.3491F));
        leg.addChild("side_blade_inner_upper", ModelPartBuilder.create()
                        .uv(0, 7).cuboid(1.0F, -2.0F, -3.0F, 0.0F, 2.0F, 4.0F, new Dilation(0.0F)),
                ModelTransform.of(2.7547F, -6.4623F, -0.25F, 0.0F, 0.0F, -0.3491F));
        leg.addChild("side_blade_outer_lower", ModelPartBuilder.create()
                        .uv(0, 5).cuboid(1.0F, -2.0F, -3.0F, 0.0F, 2.0F, 4.0F, new Dilation(0.0F)),
                ModelTransform.of(8.1228F, -3.7789F, -0.25F, 0.0F, 0.0F, 0.3491F));
        leg.addChild("side_blade_inner_lower", ModelPartBuilder.create()
                        .uv(0, 5).cuboid(1.0F, -2.0F, -3.0F, 0.0F, 2.0F, 4.0F, new Dilation(0.0F)),
                ModelTransform.of(2.7547F, -4.4623F, -0.25F, 0.0F, 0.0F, -0.3491F));
        leg.addChild("toe_spike_right_top", ModelPartBuilder.create()
                        .uv(6, 26).cuboid(-1.0F, -3.0F, -2.0F, 0.0F, 3.0F, 3.0F, new Dilation(0.0F)),
                ModelTransform.of(5.25F, 0.3257F, -4.4847F, 0.0886F, -0.1739F, -0.0154F));
        leg.addChild("toe_spike_right_bottom", ModelPartBuilder.create()
                        .uv(6, 26).cuboid(-1.0F, -3.0F, -2.0F, 0.0F, 3.0F, 3.0F, new Dilation(0.0F)),
                ModelTransform.of(4.25F, 0.0757F, -4.4847F, 0.2214F, -0.1704F, -0.0381F));
        leg.addChild("toe_spike_left_top", ModelPartBuilder.create()
                        .uv(0, 26).cuboid(-1.0F, -3.0F, -2.0F, 0.0F, 3.0F, 3.0F, new Dilation(0.0F)),
                ModelTransform.of(1.75F, 0.3257F, -4.2847F, 0.0873F, 0.0435F, 0.0038F));
        leg.addChild("toe_spike_left_bottom", ModelPartBuilder.create()
                        .uv(0, 26).cuboid(-1.0F, -3.0F, -2.0F, 0.0F, 3.0F, 3.0F, new Dilation(0.0F)),
                ModelTransform.of(2.75F, 0.0757F, -4.2847F, 0.2214F, 0.1704F, 0.0381F));
        leg.addChild("heel_spike_top", ModelPartBuilder.create()
                        .uv(20, 3).cuboid(-1.0F, -3.0F, -3.0F, 0.0F, 3.0F, 4.0F, new Dilation(0.0F)),
                ModelTransform.of(3.5F, 0.5757F, 3.2653F, -0.1222F, 0.0F, 0.0F));
        leg.addChild("heel_spike_bottom", ModelPartBuilder.create()
                        .uv(20, 0).cuboid(-1.0F, -3.0F, -3.0F, 0.0F, 3.0F, 4.0F, new Dilation(0.0F)),
                ModelTransform.of(3.5F, -0.1743F, -4.4847F, 0.1222F, 0.0F, 0.0F));
    }
}
