package net.awt.entity.client;

import net.awt.AdventuresWithTARDISes;
import net.awt.entity.custom.ProtoCybermanEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class ProtoCybermanRenderer extends MobEntityRenderer<ProtoCybermanEntity, ProtoCybermanModel<ProtoCybermanEntity>> {
    private static final Identifier TEXTURE = new Identifier(AdventuresWithTARDISes.MOD_ID, "textures/entity/proto_cyberman.png");

    public ProtoCybermanRenderer(EntityRendererFactory.Context context) {
        super(context, new ProtoCybermanModel<>(context.getPart(ModModelLayers.PROTO_CYBERMAN)), 0.55F);
    }

    @Override
    public Identifier getTexture(ProtoCybermanEntity entity) {
        return TEXTURE;
    }
}
