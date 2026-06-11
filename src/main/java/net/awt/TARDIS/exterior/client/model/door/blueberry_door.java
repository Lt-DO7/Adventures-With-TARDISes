package net.awt.TARDIS.exterior.client.model.door;

import dev.amble.ait.client.AITModClient;
import dev.amble.ait.client.models.doors.DoorModel;
import dev.amble.ait.client.tardis.ClientTardis;
import dev.amble.ait.core.blockentities.DoorBlockEntity;
import dev.amble.ait.core.tardis.handler.DoorHandler;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.RotationAxis;

// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class blueberry_door extends DoorModel {
	private final ModelPart parent;
	private final ModelPart fade_value;
	private final ModelPart right_door;
	private final ModelPart left_door;
	private final ModelPart frame;
	private final ModelPart lampstruts_1;
	private final ModelPart lampstruts_2;
	private final ModelPart portal;
	public blueberry_door(ModelPart root) {
		this.parent = root.getChild("parent");
		this.fade_value = this.parent.getChild("fade_value");
		this.right_door = this.parent.getChild("right_door");
		this.left_door = this.parent.getChild("left_door");
		this.frame = this.parent.getChild("frame");
		this.lampstruts_1 = this.frame.getChild("lampstruts_1");
		this.lampstruts_2 = this.frame.getChild("lampstruts_2");
		this.portal = this.parent.getChild("portal");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData parent = modelPartData.addChild("parent", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 27.0F, 9.0F));

		ModelPartData fade_value = parent.addChild("fade_value", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData right_door = parent.addChild("right_door", ModelPartBuilder.create().uv(204, 208).cuboid(-12.0F, -52.0F, -0.5F, 12.0F, 52.0F, 0.0F, new Dilation(0.0F))
		.uv(152, 208).cuboid(-12.0F, -52.0F, -1.0F, 12.0F, 52.0F, 1.0F, new Dilation(0.0F))
		.uv(124, 64).cuboid(-11.5F, -30.0F, -3.0F, 0.0F, 5.0F, 2.0F, new Dilation(0.0F))
		.uv(132, 64).cuboid(-12.0F, -33.0F, -1.5F, 1.0F, 1.0F, 0.5F, new Dilation(0.0F)), ModelTransform.pivot(12.5F, -3.0F, -14.0F));

		ModelPartData left_door = parent.addChild("left_door", ModelPartBuilder.create().uv(178, 208).cuboid(0.0F, -52.0F, -1.0F, 12.0F, 52.0F, 1.0F, new Dilation(0.0F))
		.uv(228, 129).cuboid(12.0F, -52.0F, -1.5F, 1.0F, 52.0F, 0.5F, new Dilation(0.0F))
		.uv(128, 64).cuboid(10.46F, -34.5F, -3.0F, 0.0F, 4.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 210).cuboid(0.0F, -52.0F, -0.5F, 12.0F, 52.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-12.5F, -3.0F, -14.0F));

		ModelPartData frame = parent.addChild("frame", ModelPartBuilder.create().uv(28, 66).cuboid(-15.5F, -57.0F, -15.5F, 31.0F, 2.0F, 3.0F, new Dilation(0.0F))
		.uv(48, 218).cuboid(-15.5F, -55.0F, -15.5F, 3.0F, 52.0F, 3.0F, new Dilation(0.0F))
		.uv(84, 218).cuboid(12.5F, -55.0F, -15.5F, 3.0F, 52.0F, 3.0F, new Dilation(0.0F))
		.uv(216, 76).cuboid(13.5F, -62.0F, -16.5F, 3.0F, 59.0F, 3.0F, new Dilation(0.001F))
		.uv(190, 68).cuboid(-15.0F, -60.5F, -17.5F, 30.0F, 4.0F, 4.0F, new Dilation(0.0F))
		.uv(24, 218).cuboid(-16.5F, -62.0F, -16.5F, 3.0F, 59.0F, 3.0F, new Dilation(0.001F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData lampstruts_1 = frame.addChild("lampstruts_1", ModelPartBuilder.create(), ModelTransform.of(0.0F, -69.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		ModelPartData lampstruts_2 = frame.addChild("lampstruts_2", ModelPartBuilder.create(), ModelTransform.of(0.0F, -69.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		ModelPartData portal = parent.addChild("portal", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 512, 512);
	}
	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		parent.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public void renderWithAnimations(ClientTardis tardis, DoorBlockEntity doorEntity, ModelPart root, MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float pAlpha, float tickDelta) {
		if (!AITModClient.CONFIG.animateDoors) {
			DoorHandler door = doorEntity.tardis().get().door();
			right_door.yaw = !door.isLeftOpen() && !door.isOpen() ? 0.0F : -5.0F;
			left_door.yaw = !door.isRightOpen() && !door.areBothOpen() ? 0.0F : 5.0F;
		} else {
			float maxRot = 85.0F;
			right_door.yaw = (float)(Math.toRadians((double)(maxRot * doorEntity.tardis().get().door().getLeftRot())));
			left_door.yaw = (float)-Math.toRadians((double)(maxRot * doorEntity.tardis().get().door().getRightRot()));
		}

		matrices.push();
		matrices.scale(0.65f, 0.65f, 0.65f);
		matrices.translate(0.0F, -1.5F, 0.0F);
		matrices.multiply(RotationAxis.NEGATIVE_Y.rotationDegrees(180.0F));
		super.renderWithAnimations(tardis, doorEntity, root, matrices, vertices, light, overlay, red, green, blue, pAlpha, tickDelta);
		matrices.pop();
	}

	@Override
	public ModelPart getPart() {
		return parent;
	}
}