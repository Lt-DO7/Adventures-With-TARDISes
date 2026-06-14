package net.awt.TARDIS.exterior.client.model.exterior;

import dev.amble.ait.api.tardis.link.v2.Linkable;
import dev.amble.ait.client.models.exteriors.ExteriorModel;
import dev.amble.ait.client.models.exteriors.SimpleExteriorModel;
import dev.amble.ait.client.tardis.ClientTardis;
import dev.amble.ait.core.blockentities.ExteriorBlockEntity;
import dev.amble.ait.core.tardis.handler.DoorHandler;
import dev.amble.ait.core.tardis.handler.travel.TravelHandlerBase;
import net.awt.TARDIS.exterior.client.render.ExteriorTravelAnimationOverrideRegistry;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class OnionExterior extends SimpleExteriorModel {
	private final ModelPart Root;
	private final ModelPart Body;
	private final ModelPart Hat;
	private final ModelPart OmgitsaUFO;
	private final ModelPart GetInLoserWereGoingShopping;
	private final ModelPart Petals;
	private final ModelPart Leg1;
	private final ModelPart Joint1;
	private final ModelPart Joint2;
	private final ModelPart Joint3;
	private final ModelPart Leg2;
	private final ModelPart Joint4;
	private final ModelPart Joint5;
	private final ModelPart Joint6;
	private final ModelPart Leg3;
	private final ModelPart Joint7;
	private final ModelPart Joint8;
	private final ModelPart Joint9;
	private final float defaultRootPivotX;
	private final float defaultRootPivotY;
	private final float defaultRootPivotZ;
	private final float defaultRootPitch;
	private final float defaultRootYaw;
	private final float defaultRootRoll;
	private final float defaultBodyPivotX;
	private final float defaultBodyPivotY;
	private final float defaultBodyPivotZ;
	private final float defaultBodyPitch;
	private final float defaultBodyYaw;
	private final float defaultBodyRoll;
	private final float defaultPetalsPitch;
	private final float defaultPetalsYaw;
	private final float defaultPetalsRoll;
	private final float defaultLeg1Pitch;
	private final float defaultLeg2Pitch;
	private final float defaultLeg3Pitch;
	private final float defaultJoint2Pitch;
	private final float defaultJoint3Pitch;
	private final float defaultJoint5Pitch;
	private final float defaultJoint6Pitch;
	private final float defaultJoint8Pitch;
	private final float defaultJoint9Pitch;
	private static final float RADIANS_PER_DEGREE = (float) (Math.PI / 180.0);
	private static final float TAKEOFF_LENGTH = 10.5f;
	private static final float LANDING_LENGTH = 12.0f;
	public OnionExterior(ModelPart root) {
		this.Root = root.getChild("Root");
		this.Body = this.Root.getChild("Body");
		this.Hat = this.Body.getChild("Hat");
		this.OmgitsaUFO = this.Body.getChild("OmgitsaUFO");
		this.GetInLoserWereGoingShopping = this.OmgitsaUFO.getChild("GetInLoserWereGoingShopping");
		this.Petals = this.Body.getChild("Petals");
		this.Leg1 = this.Root.getChild("Leg1");
		this.Joint1 = this.Leg1.getChild("Joint1");
		this.Joint2 = this.Joint1.getChild("Joint2");
		this.Joint3 = this.Joint2.getChild("Joint3");
		this.Leg2 = this.Root.getChild("Leg2");
		this.Joint4 = this.Leg2.getChild("Joint4");
		this.Joint5 = this.Joint4.getChild("Joint5");
		this.Joint6 = this.Joint5.getChild("Joint6");
		this.Leg3 = this.Root.getChild("Leg3");
		this.Joint7 = this.Leg3.getChild("Joint7");
		this.Joint8 = this.Joint7.getChild("Joint8");
		this.Joint9 = this.Joint8.getChild("Joint9");
		this.defaultRootPivotX = this.Root.pivotX;
		this.defaultRootPivotY = this.Root.pivotY;
		this.defaultRootPivotZ = this.Root.pivotZ;
		this.defaultRootPitch = this.Root.pitch;
		this.defaultRootYaw = this.Root.yaw;
		this.defaultRootRoll = this.Root.roll;
		this.defaultBodyPivotX = this.Body.pivotX;
		this.defaultBodyPivotY = this.Body.pivotY;
		this.defaultBodyPivotZ = this.Body.pivotZ;
		this.defaultBodyPitch = this.Body.pitch;
		this.defaultBodyYaw = this.Body.yaw;
		this.defaultBodyRoll = this.Body.roll;
		this.defaultPetalsPitch = this.Petals.pitch;
		this.defaultPetalsYaw = this.Petals.yaw;
		this.defaultPetalsRoll = this.Petals.roll;
		this.defaultLeg1Pitch = this.Leg1.pitch;
		this.defaultLeg2Pitch = this.Leg2.pitch;
		this.defaultLeg3Pitch = this.Leg3.pitch;
		this.defaultJoint2Pitch = this.Joint2.pitch;
		this.defaultJoint3Pitch = this.Joint3.pitch;
		this.defaultJoint5Pitch = this.Joint5.pitch;
		this.defaultJoint6Pitch = this.Joint6.pitch;
		this.defaultJoint8Pitch = this.Joint8.pitch;
		this.defaultJoint9Pitch = this.Joint9.pitch;
	}
	public OnionExterior()  {
		this(getTexturedModelData().createModel());
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData Root = modelPartData.addChild("Root", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, -44.5F, -7.0F, 16.0F, 10.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 24.5F, 0.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData topbottom_r1 = Root.addChild("topbottom_r1", ModelPartBuilder.create().uv(0, 48).cuboid(-2.0F, -7.0F, -7.0F, 12.0F, 14.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -35.5F, 0.0F, -1.5708F, 0.0F, -1.5708F));

		ModelPartData frontback_r1 = Root.addChild("frontback_r1", ModelPartBuilder.create().uv(0, 24).cuboid(-8.0F, -9.0F, -7.0F, 16.0F, 10.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -35.5F, 0.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData Body = Root.addChild("Body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -35.5F, 0.0F));

		ModelPartData Hat = Body.addChild("Hat", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.0F, 0.0F));

		ModelPartData Top_r1 = Hat.addChild("Top_r1", ModelPartBuilder.create().uv(60, 44).cuboid(10.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, -1.5708F));

		ModelPartData Mid_r1 = Hat.addChild("Mid_r1", ModelPartBuilder.create().uv(36, 76).cuboid(10.0F, -2.0F, -2.0F, 1.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.0F, 0.0F, -1.5708F, 0.0F, -1.5708F));

		ModelPartData Low_r1 = Hat.addChild("Low_r1", ModelPartBuilder.create().uv(52, 48).cuboid(10.0F, -5.0F, -5.0F, 1.0F, 10.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 2.0F, 0.0F, -1.5708F, 0.0F, -1.5708F));

		ModelPartData OmgitsaUFO = Body.addChild("OmgitsaUFO", ModelPartBuilder.create().uv(88, 44).cuboid(-5.0F, 0.0F, -5.0F, 10.0F, 35.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData GetInLoserWereGoingShopping = OmgitsaUFO.addChild("GetInLoserWereGoingShopping", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 3.0F, 0.0F));

		ModelPartData Arrow_r1 = GetInLoserWereGoingShopping.addChild("Arrow_r1", ModelPartBuilder.create().uv(0, -2).cuboid(0.0F, -4.0F, -3.5F, 0.0F, 8.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-0.25F, 19.0F, 5.25F, 0.0F, -1.5708F, 0.0F));

		ModelPartData Petals = Body.addChild("Petals", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -12.5F, 0.0F));

		ModelPartData petal3_r1 = Petals.addChild("petal3_r1", ModelPartBuilder.create().uv(0, 76).cuboid(0.0F, 1.0F, -3.0F, 0.0F, 8.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -2.5133F, 0.0F, -1.5708F));

		ModelPartData petal2_r1 = Petals.addChild("petal2_r1", ModelPartBuilder.create().uv(74, 66).cuboid(0.0F, 1.0F, -3.0F, 0.0F, 8.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -1.2566F, 0.0F, -1.5708F));

		ModelPartData petal1_r1 = Petals.addChild("petal1_r1", ModelPartBuilder.create().uv(74, 52).cuboid(0.0F, 1.0F, -3.0F, 0.0F, 8.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		ModelPartData petal5_r1 = Petals.addChild("petal5_r1", ModelPartBuilder.create().uv(24, 76).cuboid(0.0F, 1.0F, -3.0F, 0.0F, 8.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 1.2566F, 0.0F, -1.5708F));

		ModelPartData petal4_r1 = Petals.addChild("petal4_r1", ModelPartBuilder.create().uv(12, 76).cuboid(0.0F, 1.0F, -3.0F, 0.0F, 8.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 2.5133F, 0.0F, -1.5708F));

		ModelPartData Leg1 = Root.addChild("Leg1", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -35.75F, -8.25F));

		ModelPartData Hip_r1 = Leg1.addChild("Hip_r1", ModelPartBuilder.create().uv(60, 36).cuboid(0.25F, -2.0F, -2.0F, 7.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.5F, -0.75F, -1.5708F, -0.3927F, -1.5708F));

		ModelPartData Joint1 = Leg1.addChild("Joint1", ModelPartBuilder.create(), ModelTransform.of(0.0F, 1.5F, -0.75F, -0.3927F, 0.0F, 0.0F));

		ModelPartData leg_r1 = Joint1.addChild("leg_r1", ModelPartBuilder.create().uv(60, 0).cuboid(-13.75F, -1.0F, -1.0F, 15.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, -1.5708F));

		ModelPartData Joint2 = Joint1.addChild("Joint2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 14.0F, 0.0F));

		ModelPartData leg_r2 = Joint2.addChild("leg_r2", ModelPartBuilder.create().uv(60, 20).cuboid(-11.75F, -1.0F, -1.0F, 13.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, -1.5708F));

		ModelPartData Joint3 = Joint2.addChild("Joint3", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 12.0F, 0.0F));

		ModelPartData leg_r3 = Joint3.addChild("leg_r3", ModelPartBuilder.create().uv(60, 24).cuboid(-11.75F, -1.0F, -1.0F, 13.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, -1.5708F));

		ModelPartData Leg2 = Root.addChild("Leg2", ModelPartBuilder.create(), ModelTransform.of(7.1447F, -35.75F, 4.125F, -3.1416F, -1.0472F, 3.1416F));

		ModelPartData Hip_r2 = Leg2.addChild("Hip_r2", ModelPartBuilder.create().uv(52, 68).cuboid(0.25F, -2.0F, -2.0F, 7.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.5F, -0.75F, -1.5708F, -0.3927F, -1.5708F));

		ModelPartData Joint4 = Leg2.addChild("Joint4", ModelPartBuilder.create(), ModelTransform.of(0.0F, 1.5F, -0.75F, -0.3927F, 0.0F, 0.0F));

		ModelPartData leg_r4 = Joint4.addChild("leg_r4", ModelPartBuilder.create().uv(60, 4).cuboid(-13.75F, -1.0F, -1.0F, 15.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, -1.5708F));

		ModelPartData Joint5 = Joint4.addChild("Joint5", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 14.0F, 0.0F));

		ModelPartData leg_r5 = Joint5.addChild("leg_r5", ModelPartBuilder.create().uv(60, 28).cuboid(-11.75F, -1.0F, -1.0F, 13.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, -1.5708F));

		ModelPartData Joint6 = Joint5.addChild("Joint6", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 12.0F, 0.0F));

		ModelPartData leg_r6 = Joint6.addChild("leg_r6", ModelPartBuilder.create().uv(60, 32).cuboid(-11.75F, -1.0F, -1.0F, 13.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, -1.5708F));

		ModelPartData Leg3 = Root.addChild("Leg3", ModelPartBuilder.create(), ModelTransform.of(-7.1447F, -35.75F, 4.125F, -3.1416F, 1.0472F, 3.1416F));

		ModelPartData Hip_r3 = Leg3.addChild("Hip_r3", ModelPartBuilder.create().uv(74, 44).cuboid(0.25F, -2.0F, -2.0F, 7.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.5F, -0.75F, -1.5708F, -0.3927F, -1.5708F));

		ModelPartData Joint7 = Leg3.addChild("Joint7", ModelPartBuilder.create(), ModelTransform.of(0.0F, 1.5F, -0.75F, -0.3927F, 0.0F, 0.0F));

		ModelPartData leg_r7 = Joint7.addChild("leg_r7", ModelPartBuilder.create().uv(60, 8).cuboid(-13.75F, -1.0F, -1.0F, 15.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, -1.5708F));

		ModelPartData Joint8 = Joint7.addChild("Joint8", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 14.0F, 0.0F));

		ModelPartData leg_r8 = Joint8.addChild("leg_r8", ModelPartBuilder.create().uv(60, 12).cuboid(-11.75F, -1.0F, -1.0F, 13.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, -1.5708F));

		ModelPartData Joint9 = Joint8.addChild("Joint9", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 12.0F, 0.0F));

		ModelPartData leg_r9 = Joint9.addChild("leg_r9", ModelPartBuilder.create().uv(60, 16).cuboid(-11.75F, -1.0F, -1.0F, 13.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, -1.5708F));
		return TexturedModelData.of(modelData, 128, 128);
	}
	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderDoors(ClientTardis clientTardis, ExteriorBlockEntity exteriorBlockEntity, ModelPart modelPart, MatrixStack matrixStack, VertexConsumer vertexConsumer, int i, int i1, float v, float v1, float v2, float v3, boolean b) {

	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {

		Root.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public <T extends Entity & Linkable> void renderEntity(T falling, ModelPart root, MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {


		matrices.push();
		matrices.scale(1, 1, 1);
		matrices.translate(1.5f, 3f, 1.5f);
		super.renderEntity(falling, root, matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}

	@Override
	public void renderWithAnimations(ClientTardis tardis, ExteriorBlockEntity exterior, ModelPart root, MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		if ( exterior.tardis().isEmpty())
			return;

		DoorHandler door =  exterior.tardis().get().door();
		this.OmgitsaUFO.visible = door.isOpen();
		if (!ExteriorTravelAnimationOverrideRegistry.apply(tardis.getExterior().getVariant().id(), this, tardis, 0.0f)) {
			this.resetAnimatedPose();
		}

		matrices.push();
		matrices.scale(1, 1, 1);
		matrices.translate(0, -1.59f, 0);
		super.renderWithAnimations(tardis, exterior, root, matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}

	@Override
	public ModelPart getPart() {
		return Root;
	}

	public void applyTravelAnimation(ClientTardis tardis, float tickDelta) {
		this.resetAnimatedPose();

		TravelHandlerBase.State state = tardis.travel().getState();
		float time = tardis.travel().getAnimations().getTicks() + tickDelta;
		if (state == TravelHandlerBase.State.DEMAT) {
			this.applyTakeoffPose(Math.min(time, TAKEOFF_LENGTH));
		} else if (state == TravelHandlerBase.State.MAT) {
			this.applyLandingPose(Math.min(time, LANDING_LENGTH));
		}
	}

	private void resetAnimatedPose() {
		this.Root.setPivot(this.defaultRootPivotX, this.defaultRootPivotY, this.defaultRootPivotZ);
		this.Root.pitch = this.defaultRootPitch;
		this.Root.yaw = this.defaultRootYaw;
		this.Root.roll = this.defaultRootRoll;
		this.Body.setPivot(this.defaultBodyPivotX, this.defaultBodyPivotY, this.defaultBodyPivotZ);
		this.Body.pitch = this.defaultBodyPitch;
		this.Body.yaw = this.defaultBodyYaw;
		this.Body.roll = this.defaultBodyRoll;
		this.Petals.pitch = this.defaultPetalsPitch;
		this.Petals.yaw = this.defaultPetalsYaw;
		this.Petals.roll = this.defaultPetalsRoll;
		this.Leg1.pitch = this.defaultLeg1Pitch;
		this.Leg2.pitch = this.defaultLeg2Pitch;
		this.Leg3.pitch = this.defaultLeg3Pitch;
		this.Joint2.pitch = this.defaultJoint2Pitch;
		this.Joint3.pitch = this.defaultJoint3Pitch;
		this.Joint5.pitch = this.defaultJoint5Pitch;
		this.Joint6.pitch = this.defaultJoint6Pitch;
		this.Joint8.pitch = this.defaultJoint8Pitch;
		this.Joint9.pitch = this.defaultJoint9Pitch;
	}

	private void applyTakeoffPose(float time) {
		float petalsYaw = sample(time,
			0.0f, 0.0f,
			0.25f, 66.0f,
			0.5f, 180.0f,
			1.0f, 540.0f,
			1.5f, 900.0f,
			2.0f, 1260.0f,
			2.5f, 1620.0f,
			3.0f, 1980.0f,
			4.0f, 2700.0f,
			5.0f, 3420.0f,
			6.0f, 4140.0f,
			7.0f, 4860.0f,
			8.0f, 5580.0f,
			9.0f, 6300.0f,
			10.0f, 7020.0f,
			10.5f, 7380.0f);
		float bodyYaw = sample(time,
			0.0f, 0.0f,
			3.0f, 0.0f,
			4.0f, -90.0f,
			5.5f, -270.0f,
			7.0f, -540.0f,
			8.5f, -900.0f,
			10.5f, -1260.0f);
		float bodyLift = sample(time,
			0.0f, 0.0f,
			1.5f, 0.0f,
			2.5f, 2.0f,
			3.5f, 1.0f,
			4.5f, 2.0f,
			10.5f, 2.0f);

		this.Petals.yaw += petalsYaw * RADIANS_PER_DEGREE;
		this.Root.yaw += bodyYaw * RADIANS_PER_DEGREE;
		this.Root.setPivot(this.defaultRootPivotX, this.defaultRootPivotY - bodyLift, this.defaultRootPivotZ);
		this.Leg1.pitch += sample(time, 0.0f, 0.0f, 2.5f, 0.0f, 4.0f, -30.0f) * RADIANS_PER_DEGREE;
		this.Leg2.pitch += sample(time, 0.0f, 0.0f, 2.5f, 0.0f, 4.0f, -30.0f) * RADIANS_PER_DEGREE;
		this.Leg3.pitch += sample(time, 0.0f, 0.0f, 2.5f, 0.0f, 4.0f, -30.0f) * RADIANS_PER_DEGREE;
		this.Joint2.pitch += sample(time, 0.0f, 0.0f, 2.5f, 0.0f, 3.5f, 90.0f) * RADIANS_PER_DEGREE;
		this.Joint5.pitch += sample(time, 0.0f, 0.0f, 2.5f, 0.0f, 3.5f, 90.0f) * RADIANS_PER_DEGREE;
		this.Joint8.pitch += sample(time, 0.0f, 0.0f, 2.5f, 0.0f, 3.5f, 90.0f) * RADIANS_PER_DEGREE;
		this.Joint3.pitch += sample(time, 0.0f, 0.0f, 2.5f, 0.0f, 3.0f, 67.5f) * RADIANS_PER_DEGREE;
		this.Joint6.pitch += sample(time, 0.0f, 0.0f, 2.5f, 0.0f, 3.0f, 67.5f) * RADIANS_PER_DEGREE;
		this.Joint9.pitch += sample(time, 0.0f, 0.0f, 2.5f, 0.0f, 3.0f, 67.5f) * RADIANS_PER_DEGREE;
	}

	private void applyLandingPose(float time) {
		float petalsYaw = sample(time,
			0.0f, -3240.0f,
			1.0f, -2520.0f,
			2.0f, -1800.0f,
			3.0f, -1080.0f,
			4.0f, -360.0f,
			5.0f, 360.0f,
			6.0f, 1080.0f,
			7.0f, 1800.0f,
			8.0f, 2520.0f,
			9.0f, 3240.0f,
			10.0f, 3420.0f,
			11.0f, 3510.0f,
			11.5f, 3510.0f,
			12.0f, 3510.0f);
		float bodyYaw = sample(time,
			0.0f, -1845.0f,
			1.0f, -1485.0f,
			2.0f, -1125.0f,
			3.0f, -855.0f,
			4.0f, -675.0f,
			5.0f, -495.0f,
			6.0f, -315.0f,
			7.0f, -135.0f,
			8.0f, -45.0f,
			9.0f, 0.0f,
			9.5f, 0.0f,
			12.0f, 0.0f);
		float bodyLift = sample(time,
			0.0f, 0.0f,
			8.0f, 0.0f,
			9.0f, 4.0f,
			10.0f, 0.0f,
			12.0f, 0.0f);
		float legPitch = sample(time,
			0.0f, -30.0f,
			9.0f, -30.0f,
			10.0f, 0.0f,
			12.0f, 0.0f);
		float midJointPitch = sample(time,
			0.0f, 90.0f,
			9.0f, 90.0f,
			10.0f, 0.0f,
			12.0f, 0.0f);
		float endJointPitch = sample(time,
			0.0f, 67.5f,
			9.0f, 67.5f,
			10.0f, 0.0f,
			12.0f, 0.0f);

		this.Petals.yaw += petalsYaw * RADIANS_PER_DEGREE;
		this.Root.yaw += bodyYaw * RADIANS_PER_DEGREE;
		this.Root.setPivot(this.defaultRootPivotX, this.defaultRootPivotY - bodyLift, this.defaultRootPivotZ);
		this.Leg1.pitch += legPitch * RADIANS_PER_DEGREE;
		this.Leg2.pitch += legPitch * RADIANS_PER_DEGREE;
		this.Leg3.pitch += legPitch * RADIANS_PER_DEGREE;
		this.Joint2.pitch += midJointPitch * RADIANS_PER_DEGREE;
		this.Joint5.pitch += midJointPitch * RADIANS_PER_DEGREE;
		this.Joint8.pitch += midJointPitch * RADIANS_PER_DEGREE;
		this.Joint3.pitch += endJointPitch * RADIANS_PER_DEGREE;
		this.Joint6.pitch += endJointPitch * RADIANS_PER_DEGREE;
		this.Joint9.pitch += endJointPitch * RADIANS_PER_DEGREE;
	}

	private static float sample(float time, float... keyframes) {
		if (keyframes.length < 2) {
			return 0.0f;
		}

		if (time <= keyframes[0]) {
			return keyframes[1];
		}

		for (int i = 2; i < keyframes.length; i += 2) {
			float frameTime = keyframes[i];
			float frameValue = keyframes[i + 1];
			float previousTime = keyframes[i - 2];
			float previousValue = keyframes[i - 1];
			if (time <= frameTime) {
				float delta = frameTime - previousTime;
				if (delta <= 0.0f) {
					return frameValue;
				}
				float progress = (time - previousTime) / delta;
				return previousValue + ((frameValue - previousValue) * progress);
			}
		}

		return keyframes[keyframes.length - 1];
	}
}
