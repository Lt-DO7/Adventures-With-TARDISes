package net.awt.TARDIS.exterior.client.model.exterior;

import dev.amble.ait.AITMod;
import dev.amble.ait.api.tardis.link.v2.Linkable;
import dev.amble.ait.client.AITModClient;
import dev.amble.ait.client.models.exteriors.ExteriorModel;
import dev.amble.ait.client.models.exteriors.SimpleExteriorModel;
import dev.amble.ait.client.tardis.ClientTardis;
import dev.amble.ait.core.blockentities.ExteriorBlockEntity;
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
public class lego_tardis_model extends SimpleExteriorModel {
	private final ModelPart LegoTARDIS;
	private final ModelPart Hinges;
	private final ModelPart back_wall;
	private final ModelPart right_wall;
	private final ModelPart left_wall;
	private final ModelPart right_door;
	private final ModelPart left_door;
	private final ModelPart lamp;
	private final ModelPart roof;
	public lego_tardis_model(ModelPart root) {
		this.LegoTARDIS = root.getChild("LegoTARDIS");
		this.Hinges = this.LegoTARDIS.getChild("Hinges");
		this.back_wall = this.LegoTARDIS.getChild("back_wall");
		this.right_wall = this.back_wall.getChild("right_wall");
		this.left_wall = this.back_wall.getChild("left_wall");
		this.right_door = this.LegoTARDIS.getChild("right_door");
		this.left_door = this.LegoTARDIS.getChild("left_door");
		this.lamp = this.LegoTARDIS.getChild("lamp");
		this.roof = this.LegoTARDIS.getChild("roof");
	}
	public lego_tardis_model()  {
		this(getTexturedModelData().createModel());
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData LegoTARDIS = modelPartData.addChild("LegoTARDIS", ModelPartBuilder.create().uv(0, 0).cuboid(-2.96F, -0.09F, -13.04F, 16.0F, 2.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(5.0F, 22.0F, 5.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData Hinges = LegoTARDIS.addChild("Hinges", ModelPartBuilder.create().uv(0, 125).cuboid(0.0F, 20.9F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 125).cuboid(0.0F, 20.9F, -15.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, -22.0F, 2.0F));

		ModelPartData back_wall = LegoTARDIS.addChild("back_wall", ModelPartBuilder.create(), ModelTransform.pivot(4.0F, -23.0F, 0.0F));

		ModelPartData BackWall_r1 = back_wall.addChild("BackWall_r1", ModelPartBuilder.create().uv(0, 52).cuboid(-6.0F, 0.0F, -2.01F, 12.0F, 23.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-6.0F, 0.0F, -5.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData right_wall = back_wall.addChild("right_wall", ModelPartBuilder.create().uv(70, 27).cuboid(0.0F, 0.0F, 5.0F, 4.0F, 23.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 77).cuboid(6.0F, 0.0F, 4.0F, 2.0F, 23.0F, 3.0F, new Dilation(0.0F))
		.uv(40, 80).cuboid(4.0F, 0.0F, 6.0F, 3.0F, 23.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 0.0F, -5.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData left_wall = back_wall.addChild("left_wall", ModelPartBuilder.create().uv(30, 80).cuboid(-6.0F, 0.0F, 1.0F, 3.0F, 23.0F, 2.0F, new Dilation(0.0F))
		.uv(10, 77).cuboid(-7.0F, 0.0F, -1.0F, 2.0F, 23.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData LeftWall1_r1 = left_wall.addChild("LeftWall1_r1", ModelPartBuilder.create().uv(64, 0).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 23.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 1.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData right_door = LegoTARDIS.addChild("right_door", ModelPartBuilder.create().uv(56, 36).cuboid(0.0F, -23.0F, 0.0F, 5.0F, 23.0F, 2.0F, new Dilation(0.0F))
		.uv(28, 52).cuboid(5.0F, -23.0F, 2.0F, 2.0F, 23.0F, 5.0F, new Dilation(0.0F))
		.uv(70, 78).cuboid(4.0F, -23.0F, -1.0F, 3.0F, 23.0F, 2.0F, new Dilation(0.0F))
		.uv(76, 0).cuboid(5.99F, -23.0F, 0.01F, 2.0F, 23.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(5.0F, 0.0F, -12.0F));

		ModelPartData left_door = LegoTARDIS.addChild("left_door", ModelPartBuilder.create().uv(42, 52).cuboid(5.0F, -23.0F, -7.0F, 2.0F, 23.0F, 5.0F, new Dilation(0.0F))
		.uv(54, 61).cuboid(0.0F, -23.0F, -2.01F, 6.0F, 23.0F, 2.0F, new Dilation(0.0F))
		.uv(20, 80).cuboid(4.0F, -23.0F, -1.0F, 3.0F, 23.0F, 2.0F, new Dilation(0.0F))
		.uv(76, 0).cuboid(6.0F, -23.0F, -3.0F, 2.0F, 23.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(5.0F, 0.0F, 2.0F));

		ModelPartData lamp = LegoTARDIS.addChild("lamp", ModelPartBuilder.create().uv(20, 77).cuboid(-1.0F, -2.5F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(5.0F, -29.0F, -5.0F));

		ModelPartData cube_r1 = lamp.addChild("cube_r1", ModelPartBuilder.create().uv(80, 65).cuboid(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		ModelPartData cube_r2 = lamp.addChild("cube_r2", ModelPartBuilder.create().uv(80, 61).cuboid(-1.5F, -1.5F, -1.5F, 3.0F, 1.0F, 3.0F, new Dilation(0.0F))
		.uv(80, 52).cuboid(-2.0F, -2.5F, -2.0F, 4.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		ModelPartData cube_r3 = lamp.addChild("cube_r3", ModelPartBuilder.create().uv(80, 57).cuboid(-1.5F, -1.0F, -1.5F, 3.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 2.0F, 0.0F, 0.0F, 0.7418F, 0.0F));

		ModelPartData roof = LegoTARDIS.addChild("roof", ModelPartBuilder.create().uv(0, 18).cuboid(-7.96F, -27.0F, -8.04F, 16.0F, 2.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(5.0F, 2.0F, -5.0F));

		ModelPartData UpperRoof_r1 = roof.addChild("UpperRoof_r1", ModelPartBuilder.create().uv(0, 36).cuboid(-6.96F, -2.0F, -6.99F, 14.0F, 2.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -27.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
		return TexturedModelData.of(modelData, 128, 128);
	}
	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		LegoTARDIS.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
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
		matrices.scale(1, 1, 1);
		matrices.translate(0, -1.5f, 0);

		DoorHandler door = exterior.tardis().get().door();

		if (!AITModClient.CONFIG.animateDoors) {
			this.LegoTARDIS.getChild("left_door").yaw = (door.isLeftOpen() || door.isOpen()) ? -5.0F : 0.0F;
			this.LegoTARDIS.getChild("right_door").yaw = (door.isRightOpen() || door.areBothOpen())
					? 5.0F
					: 0.0F;
		} else {
			float maxRot = -50.0F;
			this.LegoTARDIS.getChild("left_door").yaw = (float) Math.toRadians(maxRot * door.getLeftRot());
			this.LegoTARDIS.getChild("right_door").yaw = (float) -Math.toRadians(maxRot * door.getRightRot());
		}

		super.renderWithAnimations(tardis, exterior, root, matrices, vertices, light, overlay, red, green, blue, pAlpha);
		matrices.pop();
	}

	@Override
	public <T extends Entity & Linkable> void renderEntity(T falling, ModelPart root, MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		matrices.scale(1, 1, 1);
		matrices.translate(0, -1.5f, 0);
		super.renderEntity(falling, root, matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}

	@Override
	public ModelPart getPart() {
		return LegoTARDIS;
	}

	@Override
	public void renderDoors(ClientTardis tardis, ExteriorBlockEntity exterior, net.minecraft.client.model.ModelPart root, net.minecraft.client.util.math.MatrixStack matrices, net.minecraft.client.render.VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float pAlpha, boolean isBOTI) {

	}
}