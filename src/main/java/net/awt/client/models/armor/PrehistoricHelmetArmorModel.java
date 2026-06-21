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

public class PrehistoricHelmetArmorModel extends BipedEntityModel<LivingEntity> {
    public PrehistoricHelmetArmorModel(ModelPart root) {
        super(root);
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();

        root.addChild("hat", ModelPartBuilder.create(), ModelTransform.NONE);
        root.addChild("body", ModelPartBuilder.create(), ModelTransform.NONE);
        root.addChild("right_arm", ModelPartBuilder.create(), ModelTransform.pivot(-5.0F, 2.0F, 0.0F));
        root.addChild("left_arm", ModelPartBuilder.create(), ModelTransform.pivot(5.0F, 2.0F, 0.0F));
        root.addChild("right_leg", ModelPartBuilder.create(), ModelTransform.pivot(-1.9F, 12.0F, 0.0F));
        root.addChild("left_leg", ModelPartBuilder.create(), ModelTransform.pivot(1.9F, 12.0F, 0.0F));

        ModelPartData head = root.addChild("head", ModelPartBuilder.create(), ModelTransform.NONE);

        ModelPartData bone = head.addChild("bone", ModelPartBuilder.create()
                        .uv(0, 18).cuboid(-2.5F, -5.0F, 5.0F, 6.0F, 4.0F, 5.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-4.0F, -9.0F, -4.0F, 9.0F, 9.0F, 9.0F, new Dilation(0.0F))
                        .uv(22, 18).cuboid(0.5F, -11.0F, -5.0F, 0.0F, 2.0F, 9.0F, new Dilation(0.0F)),
                ModelTransform.of(0.0F, -3.0F, 3.0F, 0.0F, 3.1416F, 0.0F));

        bone.addChild("cube_r1", ModelPartBuilder.create()
                        .uv(36, 0).cuboid(-0.75F, -2.0F, -1.25F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F))
                        .uv(0, 35).cuboid(-4.25F, -2.0F, -1.25F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)),
                ModelTransform.of(2.0F, 0.0F, 9.0F, -0.0873F, 0.0F, 0.0F));

        bone.addChild("cube_r2", ModelPartBuilder.create()
                        .uv(24, 36).cuboid(-2.0F, -7.0F, -1.0F, 3.0F, 7.0F, 0.0F, new Dilation(0.0F)),
                ModelTransform.of(7.1996F, -0.1735F, -0.4737F, 0.1745F, 0.3927F, 0.0F));

        bone.addChild("cube_r3", ModelPartBuilder.create()
                        .uv(36, 6).cuboid(-2.0F, -7.0F, -1.0F, 3.0F, 7.0F, 0.0F, new Dilation(0.0F)),
                ModelTransform.of(-5.3004F, -0.1735F, -0.2237F, 0.1745F, -0.3927F, 0.0F));

        ModelPartData bone2 = bone.addChild("bone2", ModelPartBuilder.create(), ModelTransform.pivot(-2.0F, -9.0F, -2.0F));
        bone2.addChild("cube_r4", ModelPartBuilder.create()
                        .uv(24, 29).cuboid(-1.0F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)),
                ModelTransform.of(0.0F, -1.0F, 0.0F, 0.6545F, 0.0F, -0.1745F));
        bone2.addChild("cube_r5", ModelPartBuilder.create()
                        .uv(0, 27).cuboid(-1.5F, -3.5F, -1.5F, 3.0F, 5.0F, 3.0F, new Dilation(0.0F)),
                ModelTransform.of(0.0F, 0.0F, 0.0F, 0.4363F, 0.0F, -0.1745F));

        ModelPartData bone3 = bone.addChild("bone3", ModelPartBuilder.create(), ModelTransform.pivot(3.0F, -9.0F, -2.0F));
        bone3.addChild("cube_r6", ModelPartBuilder.create()
                        .uv(12, 29).cuboid(-1.5F, -3.5F, -1.5F, 3.0F, 5.0F, 3.0F, new Dilation(0.0F)),
                ModelTransform.of(0.0F, 0.0F, 0.0F, 0.4305F, -0.0735F, 0.1585F));

        return TexturedModelData.of(modelData, 64, 64);
    }
}
