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
public class classic_policebox extends SimpleExteriorModel {
	private final ModelPart parent;
	private final ModelPart door;
	private final ModelPart right_door;
	private final ModelPart left_door;
	private final ModelPart frame;
	private final ModelPart doorstop;
	private final ModelPart roof;
	private final ModelPart ls_1;
	private final ModelPart ls_2;
	private final ModelPart wheel1;
	private final ModelPart wheel2;
	private final ModelPart wheel3;
	private final ModelPart wheel4;
	private final ModelPart portal;
	public classic_policebox(ModelPart root) {
		this.parent = root.getChild("parent");
		this.door = this.parent.getChild("door");
		this.right_door = this.door.getChild("right_door");
		this.left_door = this.door.getChild("left_door");
		this.frame = this.parent.getChild("frame");
		this.doorstop = this.frame.getChild("doorstop");
		this.roof = this.frame.getChild("roof");
		this.ls_1 = this.roof.getChild("ls_1");
		this.ls_2 = this.roof.getChild("ls_2");
		this.wheel1 = this.frame.getChild("wheel1");
		this.wheel2 = this.frame.getChild("wheel2");
		this.wheel3 = this.frame.getChild("wheel3");
		this.wheel4 = this.frame.getChild("wheel4");
		this.portal = this.parent.getChild("portal");
	}

	public classic_policebox()   {
		this(getTexturedModelData().createModel());
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData parent = modelPartData.addChild("parent", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.7F, 0.0F));

		ModelPartData door = parent.addChild("door", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -0.7F, 0.0F));

		ModelPartData right_door = door.addChild("right_door", ModelPartBuilder.create().uv(145, 137).cuboid(-7.5F, -31.5F, -0.375F, 7.5F, 31.5F, 1.0F, new Dilation(0.0F))
		.uv(53, 147).cuboid(-7.5F, -31.5F, -0.75F, 7.5F, 31.5F, 1.0F, new Dilation(0.0F))
		.uv(59, 77).cuboid(-7.4208F, -20.3067F, -1.0767F, 0.75F, 2.5233F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(7.875F, -0.8F, -8.125F));

		ModelPartData left_door = door.addChild("left_door", ModelPartBuilder.create().uv(135, 87).cuboid(0.0F, -31.5F, -0.375F, 8.25F, 31.5F, 1.0F, new Dilation(0.0F))
		.uv(80, 23).cuboid(7.5F, -31.5F, -1.125F, 0.75F, 31.5F, 0.0F, new Dilation(0.0F))
		.uv(35, 141).cuboid(0.0F, -31.5F, -0.75F, 8.25F, 31.5F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-7.875F, -0.8F, -8.125F));

		ModelPartData frame = parent.addChild("frame", ModelPartBuilder.create().uv(0, 0).cuboid(-10.875F, -1.5F, -10.875F, 21.75F, 0.75F, 21.75F, new Dilation(0.0F))
		.uv(72, 148).cuboid(7.875F, -37.875F, -9.375F, 2.25F, 36.75F, 1.5F, new Dilation(0.0F))
		.uv(80, 148).cuboid(-10.125F, -37.875F, -9.375F, 2.25F, 36.75F, 1.5F, new Dilation(0.0F))
		.uv(0, 145).cuboid(-10.125F, -2.25F, -7.875F, 0.75F, 0.75F, 15.75F, new Dilation(0.0F))
		.uv(88, 148).cuboid(-10.125F, -37.875F, 7.875F, 2.25F, 36.75F, 1.5F, new Dilation(0.0F))
		.uv(96, 148).cuboid(7.875F, -37.875F, 7.875F, 2.25F, 36.75F, 1.5F, new Dilation(0.0F))
		.uv(104, 148).cuboid(-8.625F, -36.75F, -10.125F, 17.25F, 2.25F, 1.5F, new Dilation(0.0F))
		.uv(154, 88).cuboid(-8.625F, -36.75F, -9.75F, 17.25F, 2.25F, 0.75F, new Dilation(0.0F))
		.uv(154, 91).cuboid(-8.625F, -36.75F, 9.0F, 17.25F, 2.25F, 0.75F, new Dilation(0.0F))
		.uv(70, 129).cuboid(9.375F, -36.75F, -8.25F, 1.5F, 2.25F, 16.5F, new Dilation(0.0F))
		.uv(104, 152).cuboid(-8.625F, -36.75F, 8.625F, 17.25F, 2.25F, 1.5F, new Dilation(0.0F))
		.uv(0, 126).cuboid(9.75F, -36.75F, -8.25F, 0.75F, 2.25F, 16.5F, new Dilation(0.0F))
		.uv(108, 129).cuboid(-10.875F, -36.75F, -8.25F, 1.5F, 2.25F, 16.5F, new Dilation(0.0F))
		.uv(136, 33).cuboid(-10.5F, -36.75F, -8.25F, 0.75F, 2.25F, 16.5F, new Dilation(0.0F))
		.uv(154, 94).cuboid(-7.875F, -34.5F, -8.625F, 15.75F, 1.5F, 0.75F, new Dilation(0.0F))
		.uv(136, 52).cuboid(-10.125F, -34.5F, -7.875F, 0.75F, 1.5F, 15.75F, new Dilation(0.0F))
		.uv(154, 97).cuboid(-7.875F, -34.5F, 7.875F, 15.75F, 1.5F, 0.75F, new Dilation(0.0F))
		.uv(136, 70).cuboid(9.375F, -34.5F, -7.875F, 0.75F, 1.5F, 15.75F, new Dilation(0.0F))
		.uv(66, 61).cuboid(-9.375F, -33.0F, -7.875F, 1.5F, 31.5F, 15.75F, new Dilation(0.0F))
		.uv(102, 96).cuboid(-7.875F, -33.0F, 7.125F, 15.75F, 31.5F, 0.75F, new Dilation(0.0F))
		.uv(0, 78).cuboid(7.875F, -33.0F, -7.875F, 1.5F, 31.5F, 15.75F, new Dilation(0.0F))
		.uv(88, 0).cuboid(8.25F, -33.0F, -7.875F, 0.75F, 31.5F, 15.75F, new Dilation(0.0F))
		.uv(102, 48).cuboid(-9.0F, -33.0F, -7.875F, 0.75F, 31.5F, 15.75F, new Dilation(0.0F))
		.uv(74, 23).cuboid(-10.125F, -33.0F, -0.375F, 0.75F, 30.75F, 0.75F, new Dilation(0.0F))
		.uv(77, 23).cuboid(-0.625F, -33.0F, 7.875F, 1.0F, 31.5F, 0.375F, new Dilation(0.0F))
		.uv(36, 78).cuboid(9.375F, -33.0F, -0.375F, 0.75F, 29.25F, 0.75F, new Dilation(0.0F))
		.uv(36, 109).cuboid(-7.875F, -33.0F, 6.75F, 15.75F, 31.5F, 0.75F, new Dilation(0.0F))
		.uv(0, 23).cuboid(-9.75F, -37.875F, -8.625F, 19.5F, 1.5F, 17.25F, new Dilation(0.0F))
		.uv(0, 61).cuboid(-8.625F, -33.75F, -7.875F, 17.25F, 0.75F, 15.75F, new Dilation(0.0F))
		.uv(146, 121).cuboid(9.375F, -2.25F, -7.875F, 0.75F, 0.75F, 15.75F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData doorstop = frame.addChild("doorstop", ModelPartBuilder.create(), ModelTransform.of(1.5F, -33.0F, -8.625F, 0.3927F, 0.0F, 0.0F));

		ModelPartData roof = frame.addChild("roof", ModelPartBuilder.create().uv(0, 42).cuboid(-9.375F, -0.75F, -9.0F, 18.75F, 0.75F, 18.0F, new Dilation(0.0F))
		.uv(74, 55).cuboid(-2.625F, -1.5F, -2.625F, 5.25F, 0.75F, 5.25F, new Dilation(0.0F))
		.uv(40, 84).cuboid(-1.5F, -6.75F, -1.5F, 3.0F, 5.25F, 3.0F, new Dilation(0.0F))
		.uv(40, 78).cuboid(-2.625F, -6.0F, -2.625F, 5.25F, 0.75F, 5.25F, new Dilation(0.0F)), ModelTransform.of(0.0F, -37.875F, 0.0F, 0.0F, 0.0175F, 0.0F));

		ModelPartData ls_1 = roof.addChild("ls_1", ModelPartBuilder.create().uv(82, 48).cuboid(-3.375F, -3.75F, 0.0F, 6.75F, 3.75F, 0.75F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.5F, 0.0F, 0.0F, -0.7854F, 0.0F));

		ModelPartData ls_2 = roof.addChild("ls_2", ModelPartBuilder.create().uv(40, 92).cuboid(-3.375F, -3.75F, 0.0F, 6.75F, 3.75F, 0.75F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.5F, 0.0F, 0.0F, 0.7854F, 0.0F));

		ModelPartData wheel1 = frame.addChild("wheel1", ModelPartBuilder.create(), ModelTransform.of(9.0F, -0.375F, -9.0F, 0.0F, 0.7854F, 0.0F));

		ModelPartData wheel2 = frame.addChild("wheel2", ModelPartBuilder.create(), ModelTransform.of(-9.0F, -0.375F, -9.0F, 0.0F, -0.7854F, 0.0F));

		ModelPartData wheel3 = frame.addChild("wheel3", ModelPartBuilder.create(), ModelTransform.of(9.0F, -0.375F, 9.0F, 0.0F, -0.7854F, 0.0F));

		ModelPartData wheel4 = frame.addChild("wheel4", ModelPartBuilder.create(), ModelTransform.of(-9.0F, -0.375F, 9.0F, 0.0F, 0.7854F, 0.0F));

		ModelPartData portal = parent.addChild("portal", ModelPartBuilder.create().uv(120, 0).cuboid(-8.0583F, -33.0F, 0.0F, 17.0F, 31.5F, 0.75F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.5F));
		return TexturedModelData.of(modelData, 256, 256);
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
		matrices.scale(1, 1, 1);
		matrices.translate(0, -1.5f, 0);

		DoorHandler door = exterior.tardis().get().door();

		if (!AITModClient.CONFIG.animateDoors) {
			this.door.getChild("right_door").yaw = (door.isLeftOpen() || door.isOpen()) ? -5.0F : 0.0F;
			this.door.getChild("left_door").yaw = (door.isRightOpen() || door.areBothOpen())
					? 5.0F
					: 0.0F;
		} else {
			float maxRot = -85f;
			this.door.getChild("right_door").yaw = (float) Math.toRadians(maxRot * door.getLeftRot());
			this.door.getChild("left_door").yaw = (float) -Math.toRadians(maxRot * door.getRightRot());
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
		return parent;
	}


	@Override
	public void renderDoors(ClientTardis tardis, ExteriorBlockEntity exterior, net.minecraft.client.model.ModelPart root, net.minecraft.client.util.math.MatrixStack matrices, net.minecraft.client.render.VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float pAlpha, boolean isBOTI) {

	}
}