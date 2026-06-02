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
public class awtjakemouth extends DoorModel {
	private final ModelPart bone;
	private final ModelPart door;
	public awtjakemouth(ModelPart root) {
		this.bone = root.getChild("bone");
		this.door = this.bone.getChild("door");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bone = modelPartData.addChild("bone", ModelPartBuilder.create(), ModelTransform.pivot(0.1F, 24.0F, -7.0F));

		ModelPartData door = bone.addChild("door", ModelPartBuilder.create().uv(34, 48).cuboid(-7.0F, -27.0F, -0.8F, 14.0F, 27.0F, 1.0F, new Dilation(0.0F))
		.uv(109, 91).cuboid(-5.4667F, -26.0F, -0.1F, 12.0F, 23.0F, 0.0F, new Dilation(0.001F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 256, 256);
	}
	@Override
	public void renderWithAnimations(ClientTardis tardis, DoorBlockEntity doorEntity, ModelPart root, MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float pAlpha, float tickDelta) {
		if (!AITModClient.CONFIG.animateDoors) {
			DoorHandler door = doorEntity.tardis().get().door();
			bone.pitch = !door.isLeftOpen() && !door.isOpen() ? 0.0F : -5.0F;
		} else {
			float maxRot = 90.0F;
			door.pitch = (float)(Math.toRadians((double)(maxRot * doorEntity.tardis().get().door().getLeftRot())));
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