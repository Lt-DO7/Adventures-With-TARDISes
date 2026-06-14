package net.awt.TARDIS.exterior.client.model.exterior;

import dev.amble.ait.api.tardis.link.v2.Linkable;
import dev.amble.ait.client.models.exteriors.SimpleExteriorModel;
import dev.amble.ait.client.tardis.ClientTardis;
import dev.amble.ait.core.blockentities.ExteriorBlockEntity;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class SeigedOnion extends SimpleExteriorModel {
	private final ModelPart Root;
	private final ModelPart Body;
	private final ModelPart Hat;
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
	public SeigedOnion(ModelPart root) {
		this.Root = root.getChild("Root");
		this.Body = this.Root.getChild("Body");
		this.Hat = this.Body.getChild("Hat");
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

	public SeigedOnion() {
		this(getTexturedModelData().createModel());
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData Root = modelPartData.addChild("Root", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, 3.5F, -7.0F, 16.0F, 10.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 27.5F, 0.0F, 0.0F, 0.0F, 3.1416F));

		ModelPartData top_r1 = Root.addChild("top_r1", ModelPartBuilder.create().uv(0, 48).cuboid(-2.0F, -7.0F, -7.0F, 12.0F, 14.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 12.5F, 0.0F, -1.5708F, 0.0F, -1.5708F));

		ModelPartData front_r1 = Root.addChild("front_r1", ModelPartBuilder.create().uv(0, 24).cuboid(-8.0F, -9.0F, -7.0F, 16.0F, 10.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 12.5F, 0.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData Body = Root.addChild("Body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 12.5F, 0.0F));

		ModelPartData Hat = Body.addChild("Hat", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.0F, 0.0F));

		ModelPartData Top_r2 = Hat.addChild("Top_r2", ModelPartBuilder.create().uv(60, 44).cuboid(10.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, -1.5708F));

		ModelPartData Mid_r1 = Hat.addChild("Mid_r1", ModelPartBuilder.create().uv(36, 76).cuboid(10.0F, -2.0F, -2.0F, 1.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.0F, 0.0F, -1.5708F, 0.0F, -1.5708F));

		ModelPartData Low_r1 = Hat.addChild("Low_r1", ModelPartBuilder.create().uv(52, 48).cuboid(10.0F, -5.0F, -5.0F, 1.0F, 10.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 2.0F, 0.0F, -1.5708F, 0.0F, -1.5708F));

		ModelPartData Leg1 = Root.addChild("Leg1", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 12.25F, -8.25F));

		ModelPartData Hip_r1 = Leg1.addChild("Hip_r1", ModelPartBuilder.create().uv(60, 36).cuboid(0.25F, -2.0F, -2.0F, 7.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.5F, -0.75F, -1.5708F, -0.3927F, -1.5708F));

		ModelPartData Joint1 = Leg1.addChild("Joint1", ModelPartBuilder.create(), ModelTransform.of(0.0F, 1.5F, -0.75F, -0.3927F, 0.0F, 0.0F));

		ModelPartData Joint2 = Joint1.addChild("Joint2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 14.0F, 0.0F));

		ModelPartData Joint3 = Joint2.addChild("Joint3", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 12.0F, 0.0F));

		ModelPartData Leg2 = Root.addChild("Leg2", ModelPartBuilder.create(), ModelTransform.of(7.1447F, 12.25F, 4.125F, -3.1416F, -1.0472F, 3.1416F));

		ModelPartData Hip_r2 = Leg2.addChild("Hip_r2", ModelPartBuilder.create().uv(52, 68).cuboid(0.25F, -2.0F, -2.0F, 7.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.5F, -0.75F, -1.5708F, -0.3927F, -1.5708F));

		ModelPartData Joint4 = Leg2.addChild("Joint4", ModelPartBuilder.create(), ModelTransform.of(0.0F, 1.5F, -0.75F, -0.3927F, 0.0F, 0.0F));

		ModelPartData Joint5 = Joint4.addChild("Joint5", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 14.0F, 0.0F));

		ModelPartData Joint6 = Joint5.addChild("Joint6", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 12.0F, 0.0F));

		ModelPartData Leg3 = Root.addChild("Leg3", ModelPartBuilder.create(), ModelTransform.of(-7.1447F, 12.25F, 4.125F, -3.1416F, 1.0472F, 3.1416F));

		ModelPartData Hip_r3 = Leg3.addChild("Hip_r3", ModelPartBuilder.create().uv(74, 44).cuboid(0.25F, -2.0F, -2.0F, 7.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.5F, -0.75F, -1.5708F, -0.3927F, -1.5708F));

		ModelPartData Joint7 = Leg3.addChild("Joint7", ModelPartBuilder.create(), ModelTransform.of(0.0F, 1.5F, -0.75F, -0.3927F, 0.0F, 0.0F));

		ModelPartData Joint8 = Joint7.addChild("Joint8", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 14.0F, 0.0F));

		ModelPartData Joint9 = Joint8.addChild("Joint9", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 12.0F, 0.0F));
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
		matrices.translate(0.5f, 1.5f, 0.5f);
		super.renderEntity(falling, root, matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}

	@Override
	public void renderWithAnimations(ClientTardis tardis, ExteriorBlockEntity exterior, ModelPart root, MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		matrices.translate(0.5f, 1.5f, 0.5f);
		super.renderWithAnimations(tardis, exterior, root, matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}

	@Override
	public ModelPart getPart() {
		return Root;
	}
}
