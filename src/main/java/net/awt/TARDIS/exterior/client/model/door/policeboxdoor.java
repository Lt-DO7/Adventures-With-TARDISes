package net.awt.TARDIS.exterior.client.model.door;

import dev.amble.ait.AITMod;
import dev.amble.ait.api.tardis.link.v2.block.AbstractLinkableBlockEntity;
import dev.amble.ait.client.AITModClient;
import dev.amble.ait.client.models.doors.DoorModel;
import dev.amble.ait.client.tardis.ClientTardis;
import dev.amble.ait.core.blockentities.DoorBlockEntity;
import dev.amble.ait.core.tardis.handler.DoorHandler;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.RotationAxis;

// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class policeboxdoor extends DoorModel {
	private final ModelPart bone;
	private final ModelPart front;
	private final ModelPart doors;
	private final ModelPart rightdoor;
	private final ModelPart phone;
	private final ModelPart leftdoor;
	public policeboxdoor(ModelPart root) {
		this.bone = root.getChild("bone");
		this.front = this.bone.getChild("front");
		this.doors = this.front.getChild("doors");
		this.rightdoor = this.doors.getChild("rightdoor");
		this.phone = this.rightdoor.getChild("phone");
		this.leftdoor = this.doors.getChild("leftdoor");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bone = modelPartData.addChild("bone", ModelPartBuilder.create(), ModelTransform.pivot(-1.3F, 26.0F, 6.0F));

		ModelPartData front = bone.addChild("front", ModelPartBuilder.create().uv(62, 135).cuboid(8.7187F, -33.0F, -13.2187F, 1.0F, 31.0F, 2.0F, new Dilation(0.0F))
		.uv(131, 136).cuboid(-7.0813F, -34.0F, -13.2187F, 17.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(68, 135).cuboid(-6.2813F, -33.0F, -13.2187F, 1.0F, 31.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 112).cuboid(-8.7349F, -36.9886F, -14.2651F, 21.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r1 = front.addChild("cube_r1", ModelPartBuilder.create().uv(0, 124).cuboid(-11.7651F, -38.6145F, -11.7651F, 3.0F, 36.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-18.0464F, 0.6145F, -1.9536F, 0.0F, -1.5708F, 0.0F));

		ModelPartData cube_r2 = front.addChild("cube_r2", ModelPartBuilder.create().uv(84, 118).cuboid(-11.7651F, -38.6145F, -11.7651F, 3.0F, 36.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.9536F, 0.6145F, -1.9536F, 0.0F, -1.5708F, 0.0F));

		ModelPartData doors = front.addChild("doors", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData rightdoor = doors.addChild("rightdoor", ModelPartBuilder.create().uv(126, 41).cuboid(5.9687F, -30.0F, -0.2687F, 2.0F, 30.0F, 0.0F, new Dilation(0.0F))
		.uv(134, 73).cuboid(-0.2813F, -30.0F, 0.0313F, 7.0F, 31.0F, 0.0F, new Dilation(0.0F))
		.uv(134, 41).cuboid(-0.2813F, -30.0F, 0.2813F, 7.0F, 31.0F, 1.0F, new Dilation(0.0F))
		.uv(80, 47).cuboid(5.6687F, -19.7071F, -0.6758F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F))
		.uv(80, 50).cuboid(1.6687F, -19.7071F, -0.6758F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.0F, -3.0F, -13.0F));

		ModelPartData cube_r3 = rightdoor.addChild("cube_r3", ModelPartBuilder.create().uv(82, 50).cuboid(-1.7187F, 2.9719F, -12.043F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F))
		.uv(82, 47).cuboid(2.2813F, 2.9719F, -12.043F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(3.3874F, -7.6642F, 4.2961F, -1.5708F, 0.0F, 0.0F));

		ModelPartData cube_r4 = rightdoor.addChild("cube_r4", ModelPartBuilder.create().uv(84, 49).cuboid(-1.7187F, -12.3358F, -5.679F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F))
		.uv(84, 46).cuboid(2.2813F, -12.3358F, -5.679F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(3.3874F, -23.3851F, 11.66F, 1.5708F, 0.0F, 0.0F));

		ModelPartData phone = rightdoor.addChild("phone", ModelPartBuilder.create().uv(88, 33).cuboid(-1.25F, -4.0F, -1.75F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(94, 80).cuboid(-2.75F, -4.0F, -1.75F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(56, 81).cuboid(-3.0F, -4.0F, -2.0F, 3.0F, 4.0F, 1.0F, new Dilation(0.0F))
		.uv(91, 98).cuboid(-3.5F, -4.75F, -1.75F, 4.0F, 5.0F, 2.0F, new Dilation(0.0F))
		.uv(1, 1).cuboid(-1.9F, -4.0F, -2.0F, 2.0F, 4.0F, 1.0F, new Dilation(0.0F))
		.uv(1, 1).cuboid(-3.15F, -4.0F, -2.0F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F))
		.uv(2, 7).cuboid(-1.45F, -3.5F, -1.7F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(2, 7).cuboid(-1.45F, -1.5F, -1.7F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(2, 2).cuboid(-2.65F, -3.4F, -1.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
		.uv(2, 2).cuboid(-2.65F, -1.4F, -1.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(4.7187F, -16.25F, 3.0313F));

		ModelPartData cube_r5 = phone.addChild("cube_r5", ModelPartBuilder.create().uv(95, 77).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.7929F, -0.7071F, -0.5F, 0.0F, 0.0F, -0.7854F));

		ModelPartData cube_r6 = phone.addChild("cube_r6", ModelPartBuilder.create().uv(76, 47).cuboid(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.5429F, -3.5F, -1.2071F, 0.0F, 0.7854F, 0.0F));

		ModelPartData cube_r7 = phone.addChild("cube_r7", ModelPartBuilder.create().uv(72, 47).cuboid(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.0429F, -3.5F, -1.2071F, 0.0F, 0.7854F, 0.0F));

		ModelPartData leftdoor = doors.addChild("leftdoor", ModelPartBuilder.create().uv(132, 104).cuboid(-7.2813F, -30.0F, -0.7187F, 7.0F, 31.0F, 1.0F, new Dilation(0.0F))
		.uv(36, 135).cuboid(-7.2813F, -30.0F, -0.9687F, 7.0F, 31.0F, 0.0F, new Dilation(0.0F))
		.uv(86, 46).cuboid(-6.8313F, -19.5071F, -1.6758F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(9.0F, -3.0F, -12.0F));

		ModelPartData cube_r8 = leftdoor.addChild("cube_r8", ModelPartBuilder.create().uv(86, 48).cuboid(-1.7187F, 3.9719F, -12.043F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-5.1126F, -7.2587F, 2.766F, -1.6144F, 0.0F, 0.0F));

		ModelPartData cube_r9 = leftdoor.addChild("cube_r9", ModelPartBuilder.create().uv(84, 48).cuboid(-1.7187F, -11.3358F, -5.679F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-5.1126F, -23.1851F, 9.66F, 1.5708F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 256, 256);
	}
    @Override
    public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        bone.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public void renderWithAnimations(ClientTardis tardis, DoorBlockEntity doorEntity, ModelPart root, MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float pAlpha, float tickDelta) {
        if (!AITModClient.CONFIG.animateDoors) {
            DoorHandler door = doorEntity.tardis().get().door();
            leftdoor.yaw = !door.isLeftOpen() && !door.isOpen() ? 0.0F : -5.0F;
            rightdoor.yaw = !door.isRightOpen() && !door.areBothOpen() ? 0.0F : 5.0F;
        } else {
            float maxRot = 85.0F;
            leftdoor.yaw = (float)(Math.toRadians((double)(maxRot * doorEntity.tardis().get().door().getLeftRot())));
            rightdoor.yaw = (float)-Math.toRadians((double)(maxRot * doorEntity.tardis().get().door().getRightRot()));
        }

        matrices.push();
        matrices.scale(1, 1, 1);
        matrices.translate(0.0F, -1.5F, 0.0F);
        matrices.multiply(RotationAxis.NEGATIVE_Y.rotationDegrees(180.0F));
        super.renderWithAnimations(tardis, doorEntity, root, matrices, vertices, light, overlay, red, green, blue, pAlpha, tickDelta);
        matrices.pop();
    }

    @Override
    public ModelPart getPart() {
        return bone;
    }
}