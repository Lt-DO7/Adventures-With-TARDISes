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
public class classic_policebox_door extends DoorModel {
	private final ModelPart parent;
	private final ModelPart frame;
	private final ModelPart doorstop;
	private final ModelPart roof;
	private final ModelPart ls_1;
	private final ModelPart ls_2;
	private final ModelPart wheel1;
	private final ModelPart wheel2;
	private final ModelPart wheel3;
	private final ModelPart wheel4;
	private final ModelPart right_door;
	private final ModelPart left_door;
	public classic_policebox_door(ModelPart root) {
		this.parent = root.getChild("parent");
		this.frame = this.parent.getChild("frame");
		this.doorstop = this.frame.getChild("doorstop");
		this.roof = this.frame.getChild("roof");
		this.ls_1 = this.roof.getChild("ls_1");
		this.ls_2 = this.roof.getChild("ls_2");
		this.wheel1 = this.frame.getChild("wheel1");
		this.wheel2 = this.frame.getChild("wheel2");
		this.wheel3 = this.frame.getChild("wheel3");
		this.wheel4 = this.frame.getChild("wheel4");
		this.right_door = this.parent.getChild("right_door");
		this.left_door = this.parent.getChild("left_door");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData parent = modelPartData.addChild("parent", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 25.6F, 1.0F));

		ModelPartData frame = parent.addChild("frame", ModelPartBuilder.create().uv(72, 148).cuboid(7.875F, -37.875F, -9.375F, 2.25F, 36.75F, 1.5F, new Dilation(0.0F))
		.uv(80, 148).cuboid(-10.125F, -37.875F, -9.375F, 2.25F, 36.75F, 1.5F, new Dilation(0.0F))
		.uv(104, 148).cuboid(-8.625F, -36.75F, -10.125F, 17.25F, 2.25F, 1.5F, new Dilation(0.0F))
		.uv(154, 88).cuboid(-8.625F, -36.75F, -9.75F, 17.25F, 2.25F, 0.75F, new Dilation(0.0F))
		.uv(154, 94).cuboid(-7.875F, -34.5F, -8.625F, 15.75F, 1.5F, 0.75F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData doorstop = frame.addChild("doorstop", ModelPartBuilder.create(), ModelTransform.of(1.5F, -33.0F, -8.625F, 0.3927F, 0.0F, 0.0F));

		ModelPartData roof = frame.addChild("roof", ModelPartBuilder.create(), ModelTransform.of(0.0F, -37.875F, 0.0F, 0.0F, 0.0175F, 0.0F));

		ModelPartData ls_1 = roof.addChild("ls_1", ModelPartBuilder.create(), ModelTransform.of(0.0F, -1.5F, 0.0F, 0.0F, -0.7854F, 0.0F));

		ModelPartData ls_2 = roof.addChild("ls_2", ModelPartBuilder.create(), ModelTransform.of(0.0F, -1.5F, 0.0F, 0.0F, 0.7854F, 0.0F));

		ModelPartData wheel1 = frame.addChild("wheel1", ModelPartBuilder.create(), ModelTransform.of(9.0F, -0.375F, -9.0F, 0.0F, 0.7854F, 0.0F));

		ModelPartData wheel2 = frame.addChild("wheel2", ModelPartBuilder.create(), ModelTransform.of(-9.0F, -0.375F, -9.0F, 0.0F, -0.7854F, 0.0F));

		ModelPartData wheel3 = frame.addChild("wheel3", ModelPartBuilder.create(), ModelTransform.of(9.0F, -0.375F, 9.0F, 0.0F, -0.7854F, 0.0F));

		ModelPartData wheel4 = frame.addChild("wheel4", ModelPartBuilder.create(), ModelTransform.of(-9.0F, -0.375F, 9.0F, 0.0F, 0.7854F, 0.0F));

		ModelPartData right_door = parent.addChild("right_door", ModelPartBuilder.create().uv(146, 138).cuboid(-7.5F, -31.5F, -0.375F, 7.5F, 31.5F, 0.75F, new Dilation(0.0F))
		.uv(54, 148).cuboid(-7.5F, -31.5F, -0.75F, 7.5F, 31.5F, 0.75F, new Dilation(0.0F))
		.uv(60, 78).cuboid(-7.4208F, -20.3067F, -1.0767F, 0.75F, 2.5233F, 0.5F, new Dilation(0.0F)), ModelTransform.pivot(7.875F, -1.5F, -8.125F));

		ModelPartData left_door = parent.addChild("left_door", ModelPartBuilder.create().uv(136, 88).cuboid(0.0F, -31.5F, -0.375F, 8.25F, 31.5F, 0.75F, new Dilation(0.0F))
		.uv(80, 23).cuboid(7.5F, -31.5F, -1.125F, 0.75F, 31.5F, 0.375F, new Dilation(0.0F))
		.uv(36, 142).cuboid(0.0F, -31.5F, -0.75F, 8.25F, 31.5F, 0.75F, new Dilation(0.0F)), ModelTransform.pivot(-7.875F, -1.5F, -8.125F));

		return TexturedModelData.of(modelData, 256, 256);
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
		matrices.scale(1, 1, 1);
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