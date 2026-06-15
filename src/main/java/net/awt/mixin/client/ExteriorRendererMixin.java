package net.awt.mixin.client;

import dev.amble.ait.client.renderers.exteriors.ExteriorRenderer;
import dev.amble.ait.client.tardis.ClientTardis;
import dev.amble.ait.core.blockentities.ExteriorBlockEntity;
import net.awt.TARDIS.exterior.client.animation.ExteriorAnimationApplier;
import net.awt.TARDIS.exterior.client.render.SiegeExteriorOverrideRegistry;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Group;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ExteriorRenderer.class, remap = false)
public abstract class ExteriorRendererMixin {

    @Inject(method = "renderExterior", at = @At("HEAD"), cancellable = true, remap = false)
    private void awt$renderCustomSiege(Profiler profiler, ClientTardis tardis, ExteriorBlockEntity exterior, float tickDelta,
                                       MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay,
                                       CallbackInfo ci) {
        if (!tardis.siege().isActive()) {
            return;
        }

        Identifier variantId = tardis.getExterior().getVariant().id();
        SiegeExteriorOverrideRegistry.Entry entry = SiegeExteriorOverrideRegistry.get(variantId);
        if (entry == null) {
            return;
        }

        profiler.push("awt_custom_siege");
        matrices.push();
        matrices.translate(0.5f, 0.5f, 0.5f);

        ModelPart root = entry.model().getPart();
        VertexConsumer vertices = vertexConsumers.getBuffer(RenderLayer.getEntityCutout(entry.texture(variantId)));
        entry.model().renderWithAnimations(tardis, exterior, root, matrices, vertices, light, overlay, 1.0f, 1.0f, 1.0f, 1.0f, tickDelta);

        matrices.pop();
        profiler.pop();
        ci.cancel();
    }

    @Group(name = "awt$exteriorPartLookup", min = 1, max = 1)
    @Redirect(method = "renderExterior",
        at = @At(value = "INVOKE", target = "Ldev/amble/ait/client/models/exteriors/ExteriorModel;getPart()Lnet/minecraft/client/model/ModelPart;"),
        remap = false,
        require = 0)
    private ModelPart awt$applyExteriorAnimationOverrideLegacy(dev.amble.ait.client.models.exteriors.ExteriorModel model,
                                                               Profiler profiler, ClientTardis tardis, ExteriorBlockEntity exterior, float tickDelta,
                                                               MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        return awt$applyExteriorAnimationOverride(model, tardis, tickDelta);
    }

    @Group(name = "awt$exteriorPartLookup", min = 1, max = 1)
    @Redirect(method = "renderExterior",
        at = @At(value = "INVOKE", target = "Ldev/amble/ait/client/models/exteriors/ExteriorModel;method_32008()Lnet/minecraft/class_630;"),
        remap = false,
        require = 0)
    private ModelPart awt$applyExteriorAnimationOverrideCurrent(dev.amble.ait.client.models.exteriors.ExteriorModel model,
                                                                Profiler profiler, ClientTardis tardis, ExteriorBlockEntity exterior, float tickDelta,
                                                                MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        return awt$applyExteriorAnimationOverride(model, tardis, tickDelta);
    }

    private ModelPart awt$applyExteriorAnimationOverride(dev.amble.ait.client.models.exteriors.ExteriorModel model,
                                                         ClientTardis tardis, float tickDelta) {
        ModelPart root = model.getPart();
        ExteriorAnimationApplier.reset(root);
        ExteriorAnimationApplier.apply(tardis.getExterior().getVariant().id(), tardis, root, tickDelta);
        return root;
    }
}
