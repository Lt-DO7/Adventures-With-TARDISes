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
public class phonebooth extends SimpleExteriorModel {
	private final ModelPart Booth;
	private final ModelPart door;
	private final ModelPart WallWest;
	private final ModelPart WallEast;
	private final ModelPart WallSouth;
	public phonebooth(ModelPart root) {
		this.Booth = root.getChild("Booth");
		this.door = this.Booth.getChild("door");
		this.WallWest = this.Booth.getChild("WallWest");
		this.WallEast = this.Booth.getChild("WallEast");
		this.WallSouth = this.Booth.getChild("WallSouth");
	}
    public phonebooth()   {
        this(getTexturedModelData().createModel());
    }

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData Booth = modelPartData.addChild("Booth", ModelPartBuilder.create().uv(0, 53).cuboid(-10.0F, 20.0F, -10.0F, 20.0F, 2.0F, 20.0F, new Dilation(0.0F))
		.uv(142, 103).cuboid(-9.5F, -17.0F, -9.5F, 2.0F, 37.0F, 2.0F, new Dilation(0.0F))
		.uv(80, 63).cuboid(-1.0F, -23.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 75).cuboid(-9.5F, -18.0F, -9.5F, 19.0F, 1.0F, 19.0F, new Dilation(0.0F))
		.uv(80, 22).cuboid(-7.5F, -20.9F, 8.8F, 15.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 26).cuboid(-9.5F, -25.8F, -9.5F, 19.0F, 8.0F, 19.0F, new Dilation(-0.2F))
		.uv(76, 26).cuboid(-8.5F, -22.0F, -8.5F, 17.0F, 0.0F, 17.0F, new Dilation(0.0F))
		.uv(80, 0).cuboid(-8.5F, -22.0F, -8.5F, 0.0F, 5.0F, 17.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-10.0F, -26.3F, -10.0F, 20.0F, 6.0F, 20.0F, new Dilation(-0.5F))
		.uv(80, 57).cuboid(-1.5F, -21.0F, -1.5F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 2.0F, 0.0F));

		ModelPartData cube_r1 = Booth.addChild("cube_r1", ModelPartBuilder.create().uv(134, 81).cuboid(-8.5F, 0.0F, -8.5F, 0.0F, 5.0F, 17.0F, new Dilation(0.0F))
		.uv(76, 49).cuboid(-7.5F, 1.1F, 8.8F, 15.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(50, 133).cuboid(-9.5F, 5.0F, -9.5F, 2.0F, 37.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -22.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData cube_r2 = Booth.addChild("cube_r2", ModelPartBuilder.create().uv(0, 133).cuboid(-8.5F, 0.0F, -8.5F, 0.0F, 5.0F, 17.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -22.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));

		ModelPartData cube_r3 = Booth.addChild("cube_r3", ModelPartBuilder.create().uv(114, 0).cuboid(-8.5F, 0.0F, -8.5F, 0.0F, 5.0F, 17.0F, new Dilation(0.0F))
		.uv(76, 46).cuboid(-7.5F, 1.1F, 8.8F, 15.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(34, 133).cuboid(-9.5F, 5.0F, -9.5F, 2.0F, 37.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -22.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData cube_r4 = Booth.addChild("cube_r4", ModelPartBuilder.create().uv(76, 43).cuboid(-7.5F, -1.0F, 8.8F, 15.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -19.9F, 0.0F, -3.1416F, 0.0F, 3.1416F));

		ModelPartData cube_r5 = Booth.addChild("cube_r5", ModelPartBuilder.create().uv(42, 133).cuboid(-9.5F, -17.0F, -9.5F, 2.0F, 37.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData door = Booth.addChild("door", ModelPartBuilder.create().uv(80, 67).cuboid(-14.0F, -2.5F, -1.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(76, 75).cuboid(-15.0F, -17.0F, -0.8F, 15.0F, 37.0F, 1.0F, new Dilation(0.0F))
		.uv(108, 81).cuboid(-13.4667F, -16.0F, -0.1F, 13.0F, 33.0F, 0.0F, new Dilation(0.001F)), ModelTransform.pivot(7.5F, 0.0F, -9.0F));

		ModelPartData WallWest = Booth.addChild("WallWest", ModelPartBuilder.create().uv(108, 43).cuboid(-7.5F, -17.0F, -9.8F, 15.0F, 37.0F, 1.0F, new Dilation(0.0F))
		.uv(64, 113).cuboid(-6.5F, -16.0F, -9.2F, 13.0F, 33.0F, 0.0F, new Dilation(0.001F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData WallEast = Booth.addChild("WallEast", ModelPartBuilder.create().uv(0, 95).cuboid(-7.5F, -17.0F, -9.8F, 15.0F, 37.0F, 1.0F, new Dilation(0.0F))
		.uv(90, 114).cuboid(-6.5F, -16.0F, -9.2F, 13.0F, 33.0F, 0.0F, new Dilation(0.001F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData WallSouth = Booth.addChild("WallSouth", ModelPartBuilder.create().uv(32, 95).cuboid(-7.4467F, -17.0F, -9.8F, 15.0F, 37.0F, 1.0F, new Dilation(0.0F))
		.uv(116, 114).cuboid(-6.5F, -16.0F, -9.25F, 13.0F, 33.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));
		return TexturedModelData.of(modelData, 256, 256);
	}
    @Override
    public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        Booth.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
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
            this.Booth.getChild("door").yaw = (door.isLeftOpen() || door.isOpen()) ? -5.0F : 0.0F;
        } else {
            float maxRot = 85;
            this.Booth.getChild("door").yaw = (float) Math.toRadians(maxRot * door.getLeftRot());
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
        return Booth;
    }

    @Override
    public void renderDoors(ClientTardis tardis, ExteriorBlockEntity exterior, net.minecraft.client.model.ModelPart root, net.minecraft.client.util.math.MatrixStack matrices, net.minecraft.client.render.VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float pAlpha, boolean isBOTI) {

    }
}