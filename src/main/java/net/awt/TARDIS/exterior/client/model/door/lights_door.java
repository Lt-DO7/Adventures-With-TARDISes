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
public class lights_door extends DoorModel {
	private final ModelPart root;
	private final ModelPart door;
	private final ModelPart left_door;
	private final ModelPart right_door;
	private final ModelPart frame;
	public lights_door(ModelPart root) {
		this.root = root.getChild("root");
		this.door = this.root.getChild("door");
		this.left_door = this.door.getChild("left_door");
		this.right_door = this.door.getChild("right_door");
		this.frame = this.root.getChild("frame");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 25.4F, 2.0F));

		ModelPartData door = root.addChild("door", ModelPartBuilder.create(), ModelTransform.pivot(7.125F, -1.5F, -7.875F));

		ModelPartData left_door = door.addChild("left_door", ModelPartBuilder.create().uv(0, 104).cuboid(0.0F, -30.75F, -0.75F, 7.5F, 30.75F, 0.75F, new Dilation(0.0F))
		.uv(161, 96).cuboid(5.625F, -21.375F, -1.5F, 0.0F, 3.75F, 0.75F, new Dilation(0.0F))
		.uv(86, 107).cuboid(6.75F, -30.75F, -1.125F, 0.75F, 30.75F, 0.375F, new Dilation(0.0F)), ModelTransform.pivot(-14.25F, 0.0F, 0.0F));

		ModelPartData right_door = door.addChild("right_door", ModelPartBuilder.create().uv(158, 96).cuboid(-6.375F, -21.375F, -1.3933F, 0.0F, 3.75F, 0.75F, new Dilation(0.0F))
		.uv(96, 106).cuboid(-6.75F, -30.75F, -0.75F, 6.75F, 30.75F, 0.75F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData frame = root.addChild("frame", ModelPartBuilder.create().uv(68, 56).cuboid(-7.125F, -33.0F, -9.0F, 14.25F, 1.5F, 0.75F, new Dilation(0.0F))
		.uv(106, 53).cuboid(-8.25F, -35.25F, -10.125F, 16.5F, 2.25F, 1.5F, new Dilation(0.0F))
		.uv(34, 104).cuboid(-9.375F, -36.0F, -9.375F, 2.25F, 35.25F, 2.25F, new Dilation(0.0F))
		.uv(42, 104).cuboid(7.125F, -36.0F, -9.375F, 2.25F, 35.25F, 2.25F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -0.75F, 0.0F));
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
		return root;
	}
}