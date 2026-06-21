package net.awt.entity.client;

import net.awt.AdventuresWithTARDISes;
import net.awt.entity.custom.MondasianCybermanEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class MondasianCybermanRenderer extends MobEntityRenderer<MondasianCybermanEntity, MondasianCybermanModel<MondasianCybermanEntity>> {
    private static final Identifier TEXTURE = new Identifier(AdventuresWithTARDISes.MOD_ID, "textures/entity/mondasian_cyberman.png");

    public MondasianCybermanRenderer(EntityRendererFactory.Context context) {
        super(context, new MondasianCybermanModel<>(context.getPart(ModModelLayers.MONDASIAN_CYBERMAN)), 0.55F);
    }

    @Override
    public Identifier getTexture(MondasianCybermanEntity entity) {
        return TEXTURE;
    }
}
