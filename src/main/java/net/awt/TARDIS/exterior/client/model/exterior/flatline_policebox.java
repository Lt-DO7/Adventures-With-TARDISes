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
public class flatline_policebox extends SimpleExteriorModel {
	private final ModelPart bone;
	private final ModelPart sides;
	private final ModelPart roof;
	private final ModelPart lantern;
	private final ModelPart PCB;
	private final ModelPart base;
	private final ModelPart posts;
	private final ModelPart front;
	private final ModelPart doors;
	private final ModelPart rightdoor;
	private final ModelPart phone;
	private final ModelPart leftdoor;
	public flatline_policebox(ModelPart root) {
		this.bone = root.getChild("bone");
		this.sides = this.bone.getChild("sides");
		this.roof = this.bone.getChild("roof");
		this.lantern = this.roof.getChild("lantern");
		this.PCB = this.roof.getChild("PCB");
		this.base = this.bone.getChild("base");
		this.posts = this.bone.getChild("posts");
		this.front = this.bone.getChild("front");
		this.doors = this.front.getChild("doors");
		this.rightdoor = this.doors.getChild("rightdoor");
		this.phone = this.rightdoor.getChild("phone");
		this.leftdoor = this.doors.getChild("leftdoor");
	}
    public flatline_policebox()  {
        this(getTexturedModelData().createModel());
    }
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bone = modelPartData.addChild("bone", ModelPartBuilder.create(), ModelTransform.pivot(-1.3F, 24.0F, 3.0F));

		ModelPartData sides = bone.addChild("sides", ModelPartBuilder.create().uv(74, 135).cuboid(-10.0813F, -33.0F, 4.2813F, 2.0F, 31.0F, 1.0F, new Dilation(0.0F))
		.uv(48, 118).cuboid(-10.0813F, -34.0F, -10.7187F, 2.0F, 1.0F, 16.0F, new Dilation(0.0F))
		.uv(64, 49).cuboid(-9.5813F, -33.0F, -9.7187F, 1.0F, 31.0F, 14.0F, new Dilation(0.0F))
		.uv(0, 67).cuboid(10.4687F, -33.0F, -9.7187F, 0.0F, 31.0F, 14.0F, new Dilation(0.0F))
		.uv(94, 27).cuboid(-10.1313F, -33.0F, -9.7187F, 0.0F, 31.0F, 14.0F, new Dilation(0.0F))
		.uv(28, 67).cuboid(10.6687F, -33.0F, -9.7187F, 0.0F, 31.0F, 14.0F, new Dilation(0.0F))
		.uv(96, 138).cuboid(-10.0813F, -33.0F, -10.7187F, 2.0F, 31.0F, 1.0F, new Dilation(0.0F))
		.uv(102, 138).cuboid(8.9187F, -33.0F, -10.7187F, 2.0F, 31.0F, 1.0F, new Dilation(0.0F))
		.uv(122, 24).cuboid(8.9187F, -34.0F, -10.7187F, 2.0F, 1.0F, 16.0F, new Dilation(0.0F))
		.uv(108, 138).cuboid(8.9187F, -33.0F, 4.2813F, 2.0F, 31.0F, 1.0F, new Dilation(0.0F))
		.uv(80, 135).cuboid(10.6687F, -33.0F, -3.7187F, 0.0F, 31.0F, 2.0F, new Dilation(0.0F))
		.uv(114, 138).cuboid(-10.0813F, -33.0F, -3.7187F, 0.0F, 31.0F, 2.0F, new Dilation(0.0F))
		.uv(96, 135).cuboid(-7.5813F, -34.0F, 5.7813F, 16.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(50, 135).cuboid(7.4187F, -33.0F, 5.7813F, 1.0F, 31.0F, 2.0F, new Dilation(0.0F))
		.uv(104, 104).cuboid(-6.5813F, -33.0F, 7.7813F, 14.0F, 31.0F, 0.0F, new Dilation(0.0F))
		.uv(104, 72).cuboid(-6.5813F, -33.0F, 6.5313F, 14.0F, 31.0F, 1.0F, new Dilation(0.0F))
		.uv(126, 163).cuboid(0.45F, -15.0F, 7.0F, 0.0F, 5.0F, 5.0F, new Dilation(0.0F))
		.uv(126, 158).cuboid(0.45F, -21.0F, 7.0F, 0.0F, 5.0F, 5.0F, new Dilation(0.0F))
		.uv(126, 153).cuboid(0.45F, -27.0F, 7.0F, 0.0F, 5.0F, 5.0F, new Dilation(0.0F))
		.uv(126, 148).cuboid(0.45F, -33.0F, 7.0F, 0.0F, 5.0F, 5.0F, new Dilation(0.0F))
		.uv(56, 135).cuboid(-7.5813F, -33.0F, 5.7813F, 1.0F, 31.0F, 2.0F, new Dilation(0.0F))
		.uv(122, 41).cuboid(-0.5813F, -33.0F, 7.7813F, 2.0F, 31.0F, 0.0F, new Dilation(0.0F))
		.uv(126, 168).cuboid(0.45F, -9.0F, 7.0F, 0.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(1.3F, 0.0F, 0.0F));

		ModelPartData roof = bone.addChild("roof", ModelPartBuilder.create().uv(0, 49).cuboid(-6.2813F, -4.5F, -10.8187F, 16.0F, 2.0F, 16.0F, new Dilation(0.0F))
		.uv(0, 27).cuboid(-7.2813F, -3.5F, -11.8187F, 18.0F, 4.0F, 18.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -37.0F, 0.1F));

		ModelPartData lantern = roof.addChild("lantern", ModelPartBuilder.create().uv(72, 27).cuboid(-13.5813F, -42.5F, 23.2813F, 5.0F, 1.0F, 5.0F, new Dilation(0.0F))
		.uv(72, 43).cuboid(-12.5813F, -47.749F, 24.2813F, 3.0F, 1.0F, 3.0F, new Dilation(0.0F))
		.uv(72, 33).cuboid(-13.0813F, -47.5F, 23.7813F, 4.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(12.8F, 37.0F, -28.6F));

		ModelPartData cube_r1 = lantern.addChild("cube_r1", ModelPartBuilder.create().uv(72, 38).cuboid(0.0F, -5.0F, -3.0F, 3.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-13.2026F, -40.5F, 25.7958F, 0.0F, -0.7854F, 0.0F));

		ModelPartData cube_r2 = lantern.addChild("cube_r2", ModelPartBuilder.create().uv(56, 75).cuboid(0.0F, -6.0F, -1.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-11.8026F, -40.5F, 25.0742F, 0.0F, -0.7854F, 0.0F));

		ModelPartData cube_r3 = lantern.addChild("cube_r3", ModelPartBuilder.create().uv(56, 86).cuboid(-3.0F, -6.0F, -2.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F))
		.uv(56, 67).cuboid(-1.0F, -6.0F, -4.0F, 0.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-11.7884F, -40.5F, 27.9026F, 0.0F, -0.7854F, 0.0F));

		ModelPartData PCB = roof.addChild("PCB", ModelPartBuilder.create().uv(56, 94).cuboid(-9.7349F, -40.535F, -13.2651F, 3.0F, 3.0F, 21.0F, new Dilation(0.0F))
		.uv(96, 0).cuboid(10.2651F, -40.535F, -13.2651F, 3.0F, 3.0F, 21.0F, new Dilation(0.0F))
		.uv(0, 118).cuboid(-8.7349F, -40.535F, 5.7349F, 21.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 40.5464F, -0.1F));

		ModelPartData base = bone.addChild("base", ModelPartBuilder.create().uv(0, 0).cuboid(-10.2813F, -3.0F, -14.7187F, 24.0F, 3.0F, 24.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData posts = bone.addChild("posts", ModelPartBuilder.create(), ModelTransform.pivot(-23.0F, 1.0F, -2.0F));

		ModelPartData cube_r4 = posts.addChild("cube_r4", ModelPartBuilder.create().uv(24, 124).cuboid(-11.7651F, -38.6145F, -11.7651F, 3.0F, 36.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(4.9536F, -0.3855F, 19.0464F, 0.0F, -1.5708F, 0.0F));

		ModelPartData cube_r5 = posts.addChild("cube_r5", ModelPartBuilder.create().uv(94, 72).cuboid(-10.7651F, -5.6145F, -10.7651F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(5.9536F, -35.3855F, 18.0464F, 0.0F, -1.5708F, 0.0F));

		ModelPartData cube_r6 = posts.addChild("cube_r6", ModelPartBuilder.create().uv(56, 90).cuboid(-10.7651F, -5.6145F, -10.7651F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(23.9536F, -35.3855F, 18.0464F, 0.0F, -1.5708F, 0.0F));

		ModelPartData cube_r7 = posts.addChild("cube_r7", ModelPartBuilder.create().uv(12, 124).cuboid(-11.7651F, -38.6145F, -11.7651F, 3.0F, 36.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(23.9536F, -0.3855F, 19.0464F, 0.0F, -1.5708F, 0.0F));

		ModelPartData cube_r8 = posts.addChild("cube_r8", ModelPartBuilder.create().uv(84, 42).cuboid(-10.7651F, -5.6145F, -10.7651F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(5.9536F, -35.3855F, 0.0464F, 0.0F, -1.5708F, 0.0F));

		ModelPartData cube_r9 = posts.addChild("cube_r9", ModelPartBuilder.create().uv(84, 38).cuboid(-10.7651F, -5.6145F, -10.7651F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(23.9536F, -35.3855F, 0.0464F, 0.0F, -1.5708F, 0.0F));

		ModelPartData front = bone.addChild("front", ModelPartBuilder.create().uv(62, 135).cuboid(8.7187F, -33.0F, -13.2187F, 1.0F, 31.0F, 2.0F, new Dilation(0.0F))
		.uv(131, 136).cuboid(-7.0813F, -34.0F, -13.2187F, 17.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(68, 135).cuboid(-6.2813F, -33.0F, -13.2187F, 1.0F, 31.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 112).cuboid(-8.7349F, -36.9886F, -14.2651F, 21.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r10 = front.addChild("cube_r10", ModelPartBuilder.create().uv(0, 124).cuboid(-11.7651F, -38.6145F, -11.7651F, 3.0F, 36.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-18.0464F, 0.6145F, -1.9536F, 0.0F, -1.5708F, 0.0F));

		ModelPartData cube_r11 = front.addChild("cube_r11", ModelPartBuilder.create().uv(84, 118).cuboid(-11.7651F, -38.6145F, -11.7651F, 3.0F, 36.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.9536F, 0.6145F, -1.9536F, 0.0F, -1.5708F, 0.0F));

		ModelPartData doors = front.addChild("doors", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData rightdoor = doors.addChild("rightdoor", ModelPartBuilder.create().uv(126, 41).cuboid(5.9687F, -30.0F, -0.2687F, 2.0F, 30.0F, 0.0F, new Dilation(0.0F))
		.uv(134, 73).cuboid(-0.2813F, -30.0F, 0.0313F, 7.0F, 31.0F, 0.0F, new Dilation(0.0F))
		.uv(134, 41).cuboid(-0.2813F, -30.0F, 0.2813F, 7.0F, 31.0F, 1.0F, new Dilation(0.0F))
		.uv(80, 47).cuboid(5.6687F, -19.7071F, -0.6758F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F))
		.uv(80, 50).cuboid(1.6687F, -19.7071F, -0.6758F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.0F, -3.0F, -13.0F));

		ModelPartData cube_r12 = rightdoor.addChild("cube_r12", ModelPartBuilder.create().uv(82, 50).cuboid(-1.7187F, 2.9719F, -12.043F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F))
		.uv(82, 47).cuboid(2.2813F, 2.9719F, -12.043F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(3.3874F, -7.6642F, 4.2961F, -1.5708F, 0.0F, 0.0F));

		ModelPartData cube_r13 = rightdoor.addChild("cube_r13", ModelPartBuilder.create().uv(84, 49).cuboid(-1.7187F, -12.3358F, -5.679F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F))
		.uv(84, 46).cuboid(2.2813F, -12.3358F, -5.679F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(3.3874F, -23.3851F, 11.66F, 1.5708F, 0.0F, 0.0F));

		ModelPartData phone = rightdoor.addChild("phone", ModelPartBuilder.create().uv(88, 33).cuboid(-1.25F, -4.0F, -1.75F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(94, 80).cuboid(-2.75F, -4.0F, -1.75F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(56, 81).cuboid(-3.0F, -4.0F, -2.0F, 3.0F, 4.0F, 1.0F, new Dilation(0.0F))
		.uv(91, 98).cuboid(-3.5F, -4.75F, -1.75F, 4.0F, 5.0F, 2.0F, new Dilation(0.0F))
		.uv(1, 1).cuboid(-1.9F, -4.0F, -2.0F, 2.0F, 4.0F, 1.0F, new Dilation(0.0F))
		.uv(1, 1).cuboid(-3.15F, -4.0F, -2.0F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F))
		.uv(2, 7).cuboid(-1.45F, -3.5F, -1.7F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(2, 7).cuboid(-1.45F, -1.5F, -1.7F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(2, 2).cuboid(-2.65F, -3.4F, -1.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
		.uv(2, 2).cuboid(-2.65F, -1.4F, -1.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(4.7187F, -16.25F, 3.0313F));

		ModelPartData cube_r14 = phone.addChild("cube_r14", ModelPartBuilder.create().uv(95, 77).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.7929F, -0.7071F, -0.5F, 0.0F, 0.0F, -0.7854F));

		ModelPartData cube_r15 = phone.addChild("cube_r15", ModelPartBuilder.create().uv(76, 47).cuboid(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.5429F, -3.5F, -1.2071F, 0.0F, 0.7854F, 0.0F));

		ModelPartData cube_r16 = phone.addChild("cube_r16", ModelPartBuilder.create().uv(72, 47).cuboid(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.0429F, -3.5F, -1.2071F, 0.0F, 0.7854F, 0.0F));

		ModelPartData leftdoor = doors.addChild("leftdoor", ModelPartBuilder.create().uv(132, 104).cuboid(-7.2813F, -30.0F, -0.7187F, 7.0F, 31.0F, 1.0F, new Dilation(0.0F))
		.uv(36, 135).cuboid(-7.2813F, -30.0F, -0.9687F, 7.0F, 31.0F, 0.0F, new Dilation(0.0F))
		.uv(86, 46).cuboid(-6.8313F, -19.5071F, -1.6758F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(9.0F, -3.0F, -12.0F));

		ModelPartData cube_r17 = leftdoor.addChild("cube_r17", ModelPartBuilder.create().uv(86, 48).cuboid(-1.7187F, 3.9719F, -12.043F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-5.1126F, -7.2587F, 2.766F, -1.6144F, 0.0F, 0.0F));

		ModelPartData cube_r18 = leftdoor.addChild("cube_r18", ModelPartBuilder.create().uv(84, 48).cuboid(-1.7187F, -11.3358F, -5.679F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-5.1126F, -23.1851F, 9.66F, 1.5708F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 256, 256);
	}
    @Override
    public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        bone.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
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
        matrices.scale(0.25f, 0.25f, 0.25f);
        matrices.translate(0, -1.5f, 0);

        DoorHandler door = exterior.tardis().get().door();

        if (!AITModClient.CONFIG.animateDoors) {
            this.doors.getChild("leftdoor").yaw = (door.isLeftOpen() || door.isOpen()) ? -5.0F : 0.0F;
            this.doors.getChild("rightdoor").yaw = (door.isRightOpen() || door.areBothOpen())
                    ? 5.0F
                    : 0.0F;
        } else {
            float maxRot = 85f;
            this.doors.getChild("leftdoor").yaw = (float) Math.toRadians(maxRot * door.getLeftRot());
            this.doors.getChild("rightdoor").yaw = (float) -Math.toRadians(maxRot * door.getRightRot());
        }

        super.renderWithAnimations(tardis, exterior, root, matrices, vertices, light, overlay, red, green, blue, pAlpha);
        matrices.pop();
    }

    @Override
    public <T extends Entity & Linkable> void renderEntity(T falling, ModelPart root, MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        matrices.push();
        matrices.scale(0.25f, 0.25f, 0.25f);
        matrices.translate(0, -1.5f, 0);
        super.renderEntity(falling, root, matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        matrices.pop();
    }

    @Override
    public ModelPart getPart() {
        return bone;
    }


    @Override
    public void renderDoors(ClientTardis tardis, ExteriorBlockEntity exterior, ModelPart root, MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float pAlpha, boolean isBOTI) {

    }
}