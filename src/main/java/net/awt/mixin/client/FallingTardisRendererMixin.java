package net.awt.mixin.client;

import dev.amble.ait.api.tardis.link.v2.TardisRef;
import dev.amble.ait.client.models.exteriors.ExteriorModel;
import dev.amble.ait.client.renderers.entities.FallingTardisRenderer;
import dev.amble.ait.core.blocks.ExteriorBlock;
import dev.amble.ait.core.entities.FallingTardisEntity;
import dev.amble.ait.core.tardis.Tardis;
import net.awt.TARDIS.exterior.client.render.SiegeExteriorOverrideRegistry;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = FallingTardisRenderer.class, remap = false)
public abstract class FallingTardisRendererMixin {

    @Inject(method = "render", at = @At("HEAD"), cancellable = true, remap = false)
    private void awt$renderCustomSiege(FallingTardisEntity entity, float yaw, float tickDelta, MatrixStack matrices,
                                       VertexConsumerProvider vertexConsumers, int light, CallbackInfo ci) {
        try {
            TardisRef ref = entity.tardis();
            Tardis tardis = ref.get();
            if (tardis == null || !tardis.siege().isActive()) {
                return;
            }

            Identifier variantId = tardis.getExterior().getVariant().id();
            SiegeExteriorOverrideRegistry.Entry entry = SiegeExteriorOverrideRegistry.get(variantId);
            if (entry == null) {
                return;
            }

            matrices.push();

            if (entity.getBlockState().contains(ExteriorBlock.ROTATION)) {
                int rotation = entity.getBlockState().get(ExteriorBlock.ROTATION);
                float rotationDegrees = Direction.fromHorizontal(rotation).asRotation();
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rotationDegrees + 180.0f));
            }

            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180.0f));

            ExteriorModel model = entry.model();
            ModelPart root = model.getPart();
            VertexConsumer vertices = vertexConsumers.getBuffer(RenderLayer.getEntityCutout(entry.texture(variantId)));
            model.renderEntity(entity, root, matrices, vertices, light, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.0f, 1.0f);

            matrices.pop();
            ci.cancel();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
