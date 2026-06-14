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
public class scarfs_door extends DoorModel {
	private final ModelPart root;
	private final ModelPart frame;
	private final ModelPart left_door;
	private final ModelPart right_door;
	public scarfs_door(ModelPart root) {
		this.root = root.getChild("root");
		this.frame = this.root.getChild("frame");
		this.left_door = this.frame.getChild("left_door");
		this.right_door = this.frame.getChild("right_door");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 25.5F, 1.0F));

		ModelPartData frame = root.addChild("frame", ModelPartBuilder.create().uv(68, 56).cuboid(-7.125F, -33.0F, -9.0F, 14.25F, 1.5F, 0.75F, new Dilation(0.0F))
		.uv(106, 53).cuboid(-8.25F, -35.25F, -10.125F, 16.5F, 2.25F, 1.5F, new Dilation(0.0F))
		.uv(150, 91).cuboid(7.5F, -36.75F, -9.0F, 1.5F, 0.75F, 1.5F, new Dilation(0.0F))
		.uv(34, 104).cuboid(-9.375F, -36.0F, -9.375F, 2.25F, 35.25F, 2.25F, new Dilation(0.0F))
		.uv(42, 104).cuboid(7.125F, -36.0F, -9.375F, 2.25F, 35.25F, 2.25F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -0.75F, 0.0F));

		ModelPartData left_door = frame.addChild("left_door", ModelPartBuilder.create().uv(0, 104).cuboid(0.0F, -30.75F, -0.75F, 7.5F, 30.75F, 0.75F, new Dilation(0.0F))
		.uv(161, 96).cuboid(5.625F, -21.375F, -1.5F, 0.0F, 3.75F, 0.75F, new Dilation(0.0F))
		.uv(86, 107).cuboid(6.75F, -30.75F, -1.125F, 0.75F, 30.75F, 0.375F, new Dilation(0.0F)), ModelTransform.pivot(-7.125F, -0.75F, -7.875F));

		ModelPartData right_door = frame.addChild("right_door", ModelPartBuilder.create().uv(158, 96).cuboid(-6.375F, -21.375F, -1.3933F, 0.0F, 3.75F, 0.75F, new Dilation(0.0F))
		.uv(96, 106).cuboid(-6.75F, -30.75F, -0.75F, 6.75F, 30.75F, 0.75F, new Dilation(0.0F)), ModelTransform.pivot(7.125F, -0.75F, -7.875F));
		return TexturedModelData.of(modelData, 256, 256);
	}
	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		root.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public void renderWithAnimations(ClientTardis tardis, DoorBlockEntity doorEntity, ModelPart root, MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float pAlpha, float tickDelta) {
		if (!AITModClient.CONFIG.animateDoors) {
			DoorHandler door = doorEntity.tardis().get().door();
			left_door.yaw = !door.isLeftOpen() && !door.isOpen() ? 0.0F : -5.0F;
			right_door.yaw = !door.isRightOpen() && !door.areBothOpen() ? 0.0F : 5.0F;
		} else {
			float maxRot = 85.0F;
			left_door.yaw = (float)(Math.toRadians((double)(maxRot * doorEntity.tardis().get().door().getLeftRot())));
			right_door.yaw = (float)-Math.toRadians((double)(maxRot * doorEntity.tardis().get().door().getRightRot()));
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
		return root;
	}
}