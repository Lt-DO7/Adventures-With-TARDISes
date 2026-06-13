package net.awt.TARDIS.exterior.client.model.door;

import dev.amble.ait.client.AITModClient;
import dev.amble.ait.client.models.doors.DoorModel;
import dev.amble.ait.client.tardis.ClientTardis;
import dev.amble.ait.core.blockentities.DoorBlockEntity;
import dev.amble.ait.core.tardis.handler.DoorHandler;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;

// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class k2phonebooth_door extends DoorModel {
	private final ModelPart root;
	private final ModelPart door;
	private final ModelPart frame;
	public k2phonebooth_door(ModelPart root) {
		this.root = root.getChild("root");
		this.door = this.root.getChild("door");
		this.frame = this.root.getChild("frame");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 25.0F, 3.0F));

		ModelPartData door = root.addChild("door", ModelPartBuilder.create().uv(128, 143).cuboid(-0.5533F, -39.0F, -0.7067F, 15.0F, 38.0F, 1.0F, new Dilation(0.0F))
		.uv(16, 17).cuboid(-0.2333F, -39.0F, -0.6067F, 14.0F, 38.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-7.0F, 0.0F, -10.0F));

		ModelPartData frame = root.addChild("frame", ModelPartBuilder.create().uv(106, 157).cuboid(7.5F, -39.0F, -10.5F, 3.0F, 38.0F, 3.0F, new Dilation(0.0F))
		.uv(160, 128).cuboid(-10.5F, -39.0F, -10.5F, 3.0F, 38.0F, 3.0F, new Dilation(0.0F))
		.uv(82, 42).cuboid(-10.5F, -42.0F, -10.5F, 21.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 256, 256);
	}
	@Override
	public void renderWithAnimations(ClientTardis tardis, DoorBlockEntity doorEntity, ModelPart root, MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float pAlpha, float tickDelta) {
		if (!AITModClient.CONFIG.animateDoors) {
			DoorHandler door = doorEntity.tardis().get().door();
			root.yaw = !door.isLeftOpen() && !door.isOpen() ? 0.0F : -5.0F;
		} else {
			float maxRot = 90.0F;
			door.yaw = (float)(Math.toRadians((double)(maxRot * doorEntity.tardis().get().door().getLeftRot())));
		}

		matrices.push();
		matrices.scale(0.95f, 0.95f, 0.95f);
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