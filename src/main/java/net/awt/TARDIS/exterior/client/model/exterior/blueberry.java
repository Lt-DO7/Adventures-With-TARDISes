package net.awt.TARDIS.exterior.client.model.exterior;

import dev.amble.ait.api.tardis.link.v2.Linkable;
import dev.amble.ait.client.AITModClient;
import dev.amble.ait.client.models.exteriors.SimpleExteriorModel;
import dev.amble.ait.client.tardis.ClientTardis;
import dev.amble.ait.core.blockentities.ExteriorBlockEntity;
import dev.amble.ait.core.tardis.handler.DoorHandler;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class blueberry extends SimpleExteriorModel {
	private final ModelPart parent;
	private final ModelPart doors;
	private final ModelPart right_door;
	private final ModelPart left_door;
	private final ModelPart frame;
	private final ModelPart lampstruts_1;
	private final ModelPart lampstruts_2;
	private final ModelPart portal;
	public blueberry(ModelPart root) {
		this.parent = root.getChild("parent");
		this.doors = this.parent.getChild("doors");
		this.right_door = this.doors.getChild("right_door");
		this.left_door = this.doors.getChild("left_door");
		this.frame = this.parent.getChild("frame");
		this.lampstruts_1 = this.frame.getChild("lampstruts_1");
		this.lampstruts_2 = this.frame.getChild("lampstruts_2");
		this.portal = this.parent.getChild("portal");
	}
	public blueberry()  {
		this(getTexturedModelData().createModel());
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData parent = modelPartData.addChild("parent", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData doors = parent.addChild("doors", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData right_door = doors.addChild("right_door", ModelPartBuilder.create().uv(204, 208).cuboid(-12.0F, -52.0F, -0.5F, 12.0F, 52.0F, 0.0F, new Dilation(0.0F))
		.uv(152, 208).cuboid(-12.0F, -52.0F, -1.0F, 12.0F, 52.0F, 1.0F, new Dilation(0.0F))
		.uv(124, 64).cuboid(-11.5F, -30.0F, -3.0F, 0.0F, 5.0F, 2.0F, new Dilation(0.0F))
		.uv(132, 64).cuboid(-12.0F, -33.0F, -1.5F, 1.0F, 1.0F, 0.5F, new Dilation(0.0F)), ModelTransform.pivot(12.5F, -3.0F, -14.0F));

		ModelPartData left_door = doors.addChild("left_door", ModelPartBuilder.create().uv(178, 208).cuboid(0.0F, -52.0F, -1.0F, 12.0F, 52.0F, 1.0F, new Dilation(0.0F))
		.uv(228, 129).cuboid(12.0F, -52.0F, -1.5F, 1.0F, 52.0F, 0.5F, new Dilation(0.0F))
		.uv(128, 64).cuboid(10.46F, -34.5F, -3.0F, 0.0F, 4.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 210).cuboid(0.0F, -52.0F, -0.5F, 12.0F, 52.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-12.5F, -3.0F, -14.0F));

		ModelPartData frame = parent.addChild("frame", ModelPartBuilder.create().uv(108, 104).cuboid(-15.0F, -55.0F, -12.5F, 1.0F, 52.0F, 25.0F, new Dilation(0.0F))
		.uv(0, 38).cuboid(-15.5F, -57.0F, -15.5F, 31.0F, 2.0F, 31.0F, new Dilation(0.0F))
		.uv(96, 210).cuboid(14.5F, -55.0F, -0.5F, 1.0F, 52.0F, 1.0F, new Dilation(0.0F))
		.uv(212, 155).cuboid(-15.5F, -55.0F, -0.5F, 1.0F, 52.0F, 1.0F, new Dilation(0.0F))
		.uv(228, 76).cuboid(-0.5F, -55.0F, 14.5F, 1.0F, 52.0F, 1.0F, new Dilation(0.0F))
		.uv(48, 218).cuboid(-15.5F, -55.0F, -15.5F, 3.0F, 52.0F, 3.0F, new Dilation(0.0F))
		.uv(60, 218).cuboid(-15.5F, -55.0F, 12.5F, 3.0F, 52.0F, 3.0F, new Dilation(0.0F))
		.uv(72, 218).cuboid(12.5F, -55.0F, 12.5F, 3.0F, 52.0F, 3.0F, new Dilation(0.0F))
		.uv(84, 218).cuboid(12.5F, -55.0F, -15.5F, 3.0F, 52.0F, 3.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-17.5F, -3.0F, -17.5F, 35.0F, 3.0F, 35.0F, new Dilation(0.0F))
		.uv(0, 71).cuboid(-15.0F, -63.0F, -15.0F, 30.0F, 3.0F, 30.0F, new Dilation(0.0F))
		.uv(0, 104).cuboid(-13.5F, -64.5F, -13.5F, 27.0F, 2.0F, 27.0F, new Dilation(0.0F))
		.uv(120, 77).cuboid(-12.0F, -66.0F, -12.0F, 24.0F, 2.0F, 24.0F, new Dilation(0.0F))
		.uv(228, 182).cuboid(-4.0F, -67.0F, -4.0F, 8.0F, 1.0F, 8.0F, new Dilation(0.0F))
		.uv(120, 71).cuboid(-2.0F, -69.0F, -2.0F, 4.0F, 2.0F, 4.0F, new Dilation(0.0F))
		.uv(124, 44).cuboid(-1.5F, -72.0F, -1.5F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F))
		.uv(124, 38).cuboid(-2.0F, -74.0F, -2.0F, 4.0F, 2.0F, 4.0F, new Dilation(0.0F))
		.uv(124, 60).cuboid(-1.5F, -75.0F, -1.5F, 3.0F, 1.0F, 3.0F, new Dilation(0.0F))
		.uv(102, 181).cuboid(-12.5F, -55.0F, 14.5F, 25.0F, 52.0F, 0.0F, new Dilation(0.0F))
		.uv(216, 76).cuboid(13.5F, -62.0F, -16.5F, 3.0F, 59.0F, 3.0F, new Dilation(0.001F))
		.uv(190, 68).cuboid(-15.0F, -60.5F, -17.5F, 30.0F, 4.0F, 4.0F, new Dilation(0.0F))
		.uv(190, 0).cuboid(-17.5F, -60.5F, -15.0F, 4.0F, 4.0F, 30.0F, new Dilation(0.0F))
		.uv(24, 210).cuboid(-15.0F, -60.5F, 13.5F, 30.0F, 4.0F, 4.0F, new Dilation(0.0F))
		.uv(190, 34).cuboid(13.5F, -60.5F, -15.0F, 4.0F, 4.0F, 30.0F, new Dilation(0.0F))
		.uv(216, 138).cuboid(13.5F, -62.0F, 13.5F, 3.0F, 59.0F, 3.0F, new Dilation(0.0F))
		.uv(24, 218).cuboid(-16.5F, -62.0F, -16.5F, 3.0F, 59.0F, 3.0F, new Dilation(0.001F))
		.uv(36, 218).cuboid(-16.5F, -62.0F, 13.5F, 3.0F, 59.0F, 3.0F, new Dilation(0.0F))
		.uv(160, 155).cuboid(-12.5F, -55.0F, 14.0F, 25.0F, 52.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 133).cuboid(14.0F, -55.0F, -12.5F, 1.0F, 52.0F, 25.0F, new Dilation(0.0F))
		.uv(52, 133).cuboid(14.5F, -55.0F, -12.5F, 0.0F, 52.0F, 25.0F, new Dilation(0.0F))
		.uv(140, 0).cuboid(-14.5F, -55.0F, -12.5F, 0.0F, 52.0F, 25.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData lampstruts_1 = frame.addChild("lampstruts_1", ModelPartBuilder.create().uv(124, 50).cuboid(-3.0F, -4.0F, 0.0F, 6.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -69.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		ModelPartData lampstruts_2 = frame.addChild("lampstruts_2", ModelPartBuilder.create().uv(124, 55).cuboid(-3.0F, -4.0F, 0.0F, 6.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -69.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		ModelPartData portal = parent.addChild("portal", ModelPartBuilder.create().uv(160, 103).cuboid(-14.0F, -55.0F, 0.0F, 28.0F, 52.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 512, 512);
	}
	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		parent.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		matrices.push();
		matrices.scale(0f, 0f, 0f);
		matrices.pop();
	}

	@Override
	public void renderWithAnimations(ClientTardis tardis, ExteriorBlockEntity exterior, ModelPart root, MatrixStack matrices,
									 VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float pAlpha) {
		if (exterior.tardis().isEmpty())
			return;

		matrices.push();
		matrices.scale(0.65f, 0.65f, 0.65f);
		matrices.translate(0, -1.5f, 0);

		DoorHandler door = exterior.tardis().get().door();

		if (!AITModClient.CONFIG.animateDoors) {
			this.doors.getChild("right_door").yaw = (door.isLeftOpen() || door.isOpen()) ? -5.0F : 0.0F;
			this.doors.getChild("left_door").yaw = (door.isRightOpen() || door.areBothOpen())
					? 5.0F
					: 0.0F;
		} else {
			float maxRot = 85f;
			this.doors.getChild("right_door").yaw = (float) Math.toRadians(maxRot * door.getLeftRot());
			this.doors.getChild("left_door").yaw = (float) -Math.toRadians(maxRot * door.getRightRot());
		}

		super.renderWithAnimations(tardis, exterior, root, matrices, vertices, light, overlay, red, green, blue, pAlpha);
		matrices.pop();
	}

	@Override
	public <T extends Entity & Linkable> void renderEntity(T falling, ModelPart root, MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		matrices.scale(1, 1, 1);
		matrices.translate(0, -1f, 0);
		super.renderEntity(falling, root, matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}

	@Override
	public ModelPart getPart() {
		return parent;
	}


	@Override
	public void renderDoors(ClientTardis tardis, ExteriorBlockEntity exterior, ModelPart root, MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float pAlpha, boolean isBOTI) {

	}
}