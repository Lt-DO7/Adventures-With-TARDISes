package net.awt.TARDIS.exterior.client.model.exterior;

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

// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class scarfs extends SimpleExteriorModel {
	private final ModelPart root;
	private final ModelPart frame;
	private final ModelPart left_door;
	private final ModelPart right_door;
	public scarfs(ModelPart root) {
		this.root = root.getChild("root");
		this.frame = this.root.getChild("frame");
		this.left_door = this.frame.getChild("left_door");
		this.right_door = this.frame.getChild("right_door");
	}

	public scarfs()   {
		this(getTexturedModelData().createModel());
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData frame = root.addChild("frame", ModelPartBuilder.create().uv(0, 0).cuboid(-10.125F, -0.75F, -10.125F, 20.25F, 1.5F, 20.25F, new Dilation(0.0F))
		.uv(68, 56).cuboid(-7.125F, -33.0F, -9.0F, 14.25F, 1.5F, 0.75F, new Dilation(0.0F))
		.uv(106, 53).cuboid(-8.25F, -35.25F, -10.125F, 16.5F, 2.25F, 1.5F, new Dilation(0.0F))
		.uv(68, 37).cuboid(-10.125F, -35.25F, -8.25F, 1.5F, 2.25F, 16.5F, new Dilation(0.0F))
		.uv(84, 107).cuboid(-0.375F, -31.5F, 8.625F, 0.75F, 30.75F, 0.375F, new Dilation(0.0F))
		.uv(80, 107).cuboid(-9.0F, -31.5F, -0.375F, 0.375F, 30.75F, 0.75F, new Dilation(0.0F))
		.uv(150, 91).cuboid(7.5F, -36.75F, -9.0F, 1.5F, 0.75F, 1.5F, new Dilation(0.0F))
		.uv(18, 104).cuboid(7.125F, -36.0F, 7.125F, 2.25F, 35.25F, 2.25F, new Dilation(0.0F))
		.uv(26, 104).cuboid(-9.375F, -36.0F, 7.125F, 2.25F, 35.25F, 2.25F, new Dilation(0.0F))
		.uv(34, 104).cuboid(-9.375F, -36.0F, -9.375F, 2.25F, 35.25F, 2.25F, new Dilation(0.0F))
		.uv(42, 104).cuboid(7.125F, -36.0F, -9.375F, 2.25F, 35.25F, 2.25F, new Dilation(0.0F))
		.uv(0, 59).cuboid(7.125F, -31.5F, -7.125F, 1.5F, 30.75F, 14.25F, new Dilation(0.0F))
		.uv(64, 74).cuboid(-7.125F, -31.5F, 7.125F, 14.25F, 30.75F, 1.5F, new Dilation(0.0F))
		.uv(32, 59).cuboid(-8.625F, -31.5F, -7.125F, 1.5F, 30.75F, 14.25F, new Dilation(0.0F))
		.uv(50, 128).cuboid(-9.0517F, -2.5767F, -7.6583F, 2.0F, 3.0F, 15.0F, new Dilation(0.0F))
		.uv(82, 107).cuboid(8.625F, -31.5F, -0.375F, 0.375F, 30.75F, 0.75F, new Dilation(0.0F))
		.uv(106, 37).cuboid(8.25F, -33.0F, -7.125F, 0.75F, 1.5F, 14.25F, new Dilation(0.0F))
		.uv(50, 107).cuboid(-9.0F, -33.0F, -7.125F, 0.75F, 1.5F, 14.25F, new Dilation(0.0F))
		.uv(80, 19).cuboid(-7.125F, -33.0F, 8.25F, 14.25F, 1.5F, 0.75F, new Dilation(0.0F))
		.uv(112, 106).cuboid(-8.25F, -35.25F, 8.625F, 16.5F, 2.25F, 1.5F, new Dilation(0.0F))
		.uv(80, 0).cuboid(8.625F, -35.25F, -8.25F, 1.5F, 2.25F, 16.5F, new Dilation(0.0F))
		.uv(0, 40).cuboid(-8.25F, -37.5F, -8.25F, 16.5F, 1.5F, 16.5F, new Dilation(0.0F))
		.uv(0, 22).cuboid(-8.625F, -36.25F, -8.625F, 17.25F, 1.0F, 17.25F, new Dilation(0.0F))
		.uv(68, 22).cuboid(-7.125F, -38.25F, -7.125F, 14.25F, 0.75F, 14.25F, new Dilation(0.0F))
		.uv(146, 72).cuboid(-1.875F, -38.8467F, -1.875F, 3.75F, 0.75F, 3.75F, new Dilation(0.0F))
		.uv(147, 66).cuboid(-1.4983F, -41.8183F, -1.5683F, 3.0F, 1.0F, 3.0F, new Dilation(0.0F))
		.uv(149, 84).cuboid(-1.125F, -41.25F, -1.125F, 2.25F, 3.0F, 2.25F, new Dilation(0.0F))
		.uv(51, 129).mirrored().cuboid(7.105F, -2.5767F, -7.6583F, 2.0F, 3.0F, 15.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, -0.75F, 0.0F));

		ModelPartData frame_r1 = frame.addChild("frame_r1", ModelPartBuilder.create().uv(51, 129).mirrored().cuboid(6.625F, -4.5F, -7.125F, 2.0F, 3.0F, 15.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.3733F, 1.9233F, 0.4267F, 0.0F, -1.5708F, 0.0F));

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
			this.frame.getChild("left_door").yaw = (door.isLeftOpen() || door.isOpen()) ? -5.0F : 0.0F;
			this.frame.getChild("right_door").yaw = (door.isRightOpen() || door.areBothOpen())
					? 5.0F
					: 0.0F;
		} else {
			float maxRot = 85f;
			this.frame.getChild("left_door").yaw = (float) Math.toRadians(maxRot * door.getLeftRot());
			this.frame.getChild("right_door").yaw = (float) -Math.toRadians(maxRot * door.getRightRot());
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
		return root;
	}


	@Override
	public void renderDoors(ClientTardis tardis, ExteriorBlockEntity exterior, net.minecraft.client.model.ModelPart root, net.minecraft.client.util.math.MatrixStack matrices, net.minecraft.client.render.VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float pAlpha, boolean isBOTI) {

	}
}