package net.awt.TARDIS.exterior.client.model.exterior;

import dev.amble.ait.api.tardis.link.v2.Linkable;
import dev.amble.ait.client.models.exteriors.ExteriorModel;
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
public class OnionExterior extends ExteriorModel {
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
	public Animation getAnimationForDoorState(DoorHandler.AnimationDoorState animationDoorState) {
		return null;
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
}