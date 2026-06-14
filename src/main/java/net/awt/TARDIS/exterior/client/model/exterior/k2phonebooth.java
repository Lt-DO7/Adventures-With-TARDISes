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

// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class k2phonebooth extends SimpleExteriorModel {
	private final ModelPart root;
	private final ModelPart door;
	private final ModelPart frame;
	private final ModelPart bulb;
	private final ModelPart phone2;
	private final ModelPart book;
	private final ModelPart phone;
	private final ModelPart recieverholder1;
	private final ModelPart recieverholder2;
	private final ModelPart dialangler;
	private final ModelPart dial;
	private final ModelPart handset;
	private final ModelPart phone3;
	public k2phonebooth(ModelPart root) {
		this.root = root.getChild("root");
		this.door = this.root.getChild("door");
		this.frame = this.root.getChild("frame");
		this.bulb = this.frame.getChild("bulb");
		this.phone2 = this.frame.getChild("phone2");
		this.book = this.phone2.getChild("book");
		this.phone = this.phone2.getChild("phone");
		this.recieverholder1 = this.phone.getChild("recieverholder1");
		this.recieverholder2 = this.phone.getChild("recieverholder2");
		this.dialangler = this.phone.getChild("dialangler");
		this.dial = this.dialangler.getChild("dial");
		this.handset = this.phone.getChild("handset");
		this.phone3 = this.frame.getChild("phone3");
	}
	public k2phonebooth()   {
		this(getTexturedModelData().createModel());
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData door = root.addChild("door", ModelPartBuilder.create().uv(128, 143).cuboid(0.4467F, -39.0F, -0.7067F, 15.0F, 38.0F, 1.0F, new Dilation(0.0F))
		.uv(16, 17).cuboid(0.7667F, -39.0F, -0.6067F, 14.0F, 38.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-8.0F, 0.0F, -10.0F));

		ModelPartData frame = root.addChild("frame", ModelPartBuilder.create().uv(106, 157).cuboid(7.5F, -39.0F, -10.5F, 3.0F, 38.0F, 3.0F, new Dilation(0.0F))
		.uv(160, 128).cuboid(-10.5F, -39.0F, -10.5F, 3.0F, 38.0F, 3.0F, new Dilation(0.0F))
		.uv(168, 39).cuboid(-10.5F, -39.0F, 7.5F, 3.0F, 38.0F, 3.0F, new Dilation(0.0F))
		.uv(160, 169).cuboid(7.5F, -39.0F, 7.5F, 3.0F, 38.0F, 3.0F, new Dilation(0.0F))
		.uv(0, 103).cuboid(-10.5F, -39.0F, -7.5F, 1.0F, 38.0F, 15.0F, new Dilation(0.0F))
		.uv(128, 104).cuboid(-7.5F, -39.0F, 9.5F, 15.0F, 38.0F, 1.0F, new Dilation(0.0F))
		.uv(32, 103).cuboid(9.5F, -39.0F, -7.5F, 1.0F, 38.0F, 15.0F, new Dilation(0.0F))
		.uv(82, 42).cuboid(-10.5F, -42.0F, -10.5F, 21.0F, 3.0F, 3.0F, new Dilation(0.0F))
		.uv(84, 79).cuboid(-10.0F, -47.0F, -10.0F, 1.0F, 5.0F, 20.0F, new Dilation(0.0001F))
		.uv(0, 79).cuboid(-10.5F, -50.0F, -10.5F, 21.0F, 3.0F, 21.0F, new Dilation(0.001F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData thing_r1 = frame.addChild("thing_r1", ModelPartBuilder.create().uv(84, 79).cuboid(-10.0F, -47.0F, -10.0F, 1.0F, 5.0F, 20.0F, new Dilation(0.01F))
		.uv(82, 36).cuboid(-10.5F, -42.0F, -10.5F, 21.0F, 3.0F, 3.0F, new Dilation(0.01F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData thing_r2 = frame.addChild("thing_r2", ModelPartBuilder.create().uv(84, 79).cuboid(-10.0F, -47.0F, -10.0F, 1.0F, 5.0F, 20.0F, new Dilation(0.001F))
		.uv(82, 36).cuboid(-10.5F, -42.0F, -10.5F, 21.0F, 3.0F, 3.0F, new Dilation(0.001F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData thing_r3 = frame.addChild("thing_r3", ModelPartBuilder.create().uv(84, 79).cuboid(-10.0F, -47.0F, -10.0F, 1.0F, 5.0F, 20.0F, new Dilation(0.1F))
		.uv(82, 36).cuboid(-10.5F, -42.0F, -10.5F, 21.0F, 3.0F, 3.0F, new Dilation(0.001F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData bulb = frame.addChild("bulb", ModelPartBuilder.create().uv(148, 24).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -45.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		ModelPartData phone2 = frame.addChild("phone2", ModelPartBuilder.create().uv(64, 48).cuboid(10.0F, -17.0F, 14.0F, 5.0F, 1.0F, 6.0F, new Dilation(0.0F))
		.uv(172, 135).cuboid(14.0F, -23.0F, 14.0F, 1.0F, 6.0F, 6.0F, new Dilation(0.0F))
		.uv(134, 72).cuboid(10.0F, -24.0F, 14.0F, 5.0F, 1.0F, 6.0F, new Dilation(0.0F))
		.uv(164, 93).cuboid(0.0F, -24.0F, 14.0F, 5.0F, 1.0F, 6.0F, new Dilation(0.0F))
		.uv(172, 147).cuboid(0.0F, -23.0F, 14.0F, 1.0F, 6.0F, 6.0F, new Dilation(0.0F))
		.uv(172, 128).cuboid(0.0F, -17.0F, 14.0F, 5.0F, 1.0F, 6.0F, new Dilation(0.0F))
		.uv(164, 80).cuboid(5.0F, -24.0F, 16.0F, 5.0F, 9.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-7.5F, -1.0F, -11.5F));

		ModelPartData book = phone2.addChild("book", ModelPartBuilder.create().uv(172, 159).cuboid(-2.0F, -5.0F, -2.5F, 2.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(12.0F, -17.0F, 17.5F, 0.0F, 0.0F, 0.4102F));

		ModelPartData phone = phone2.addChild("phone", ModelPartBuilder.create().uv(148, 39).cuboid(-2.5F, -1.0F, 0.0F, 5.0F, 1.0F, 3.0F, new Dilation(0.0F))
		.uv(148, 30).cuboid(-1.5F, -3.0F, 1.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(156, 72).cuboid(-5.5F, -2.0F, 1.5F, 4.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.5F, -24.0F, 15.5F, 0.0F, -0.6109F, 0.0F));

		ModelPartData recieverholder1 = phone.addChild("recieverholder1", ModelPartBuilder.create().uv(148, 45).cuboid(-1.5F, -1.0F, 0.0F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 1.0F, 0.7854F, 0.0F, 0.0F));

		ModelPartData recieverholder2 = phone.addChild("recieverholder2", ModelPartBuilder.create().uv(156, 45).cuboid(-1.5F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 2.0F, -0.7854F, 0.0F, 0.0F));

		ModelPartData dialangler = phone.addChild("dialangler", ModelPartBuilder.create(), ModelTransform.of(0.0F, -1.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

		ModelPartData dial = dialangler.addChild("dial", ModelPartBuilder.create().uv(86, 48).cuboid(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.0F, 0.0F));

		ModelPartData handset = phone.addChild("handset", ModelPartBuilder.create().uv(148, 43).cuboid(-2.5F, -1.0F, -0.5F, 5.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(148, 33).cuboid(-3.5F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(148, 36).cuboid(1.5F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -3.0F, 1.5F));

		ModelPartData phone3 = frame.addChild("phone3", ModelPartBuilder.create().uv(64, 0).cuboid(-11.0933F, 0.0F, -1.0F, 23.0F, 1.0F, 23.0F, new Dilation(0.0F))
		.uv(64, 104).cuboid(9.4067F, -38.0F, 3.0F, 1.0F, 38.0F, 15.0F, new Dilation(0.0F))
		.uv(96, 104).cuboid(-9.5933F, -38.0F, 3.0F, 1.0F, 38.0F, 15.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.4067F, -1.0F, -10.5F));
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
		matrices.scale(0.95f, 0.95f, 0.95f);
		matrices.translate(0, -1.5f, 0);

		DoorHandler door = exterior.tardis().get().door();

		if (!AITModClient.CONFIG.animateDoors) {
			this.root.getChild("door").yaw = (door.isLeftOpen() || door.isOpen()) ? -5.0F : 0.0F;
		} else {
			float maxRot = 85;
			this.root.getChild("door").yaw = (float) Math.toRadians(maxRot * door.getLeftRot());
		}

		super.renderWithAnimations(tardis, exterior, root, matrices, vertices, light, overlay, red, green, blue, pAlpha);
		matrices.pop();
	}

	@Override
	public <T extends Entity & Linkable> void renderEntity(T falling, ModelPart root, MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		matrices.scale(0.95f, 0.95f, 0.95f);
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