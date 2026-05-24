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
public class phoneboothdoor extends DoorModel {
	private final ModelPart Booth;
	private final ModelPart door;
	public phoneboothdoor(ModelPart root) {
		this.Booth = root.getChild("Booth");
		this.door = this.Booth.getChild("door");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData Booth = modelPartData.addChild("Booth", ModelPartBuilder.create().uv(142, 103).cuboid(-9.5F, -17.0F, -9.5F, 2.0F, 37.0F, 2.0F, new Dilation(0.0F))
		.uv(17, 92).cuboid(-9.5F, -18.0F, -9.5F, 19.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 4.0F, 2.0F));

		ModelPartData cube_r1 = Booth.addChild("cube_r1", ModelPartBuilder.create().uv(50, 133).cuboid(-9.5F, -17.0F, -9.5F, 2.0F, 37.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData door = Booth.addChild("door", ModelPartBuilder.create().uv(80, 67).cuboid(-14.0F, -2.5F, -1.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(76, 75).cuboid(-15.0F, -17.0F, -0.8F, 15.0F, 37.0F, 1.0F, new Dilation(0.0F))
		.uv(108, 81).cuboid(-13.4667F, -16.0F, -0.1F, 13.0F, 33.0F, 0.0F, new Dilation(0.001F)), ModelTransform.pivot(7.5F, 0.0F, -9.0F));
		return TexturedModelData.of(modelData, 256, 256);
	}
    @Override
    public void renderWithAnimations(ClientTardis tardis, DoorBlockEntity doorEntity, ModelPart root, MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float pAlpha, float tickDelta) {
        if (!AITModClient.CONFIG.animateDoors) {
            DoorHandler door = doorEntity.tardis().get().door();
            Booth.yaw = !door.isLeftOpen() && !door.isOpen() ? 0.0F : -5.0F;
        } else {
            float maxRot = 90.0F;
            door.yaw = (float)(Math.toRadians((double)(maxRot * doorEntity.tardis().get().door().getLeftRot())));
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
        return Booth;
    }
}