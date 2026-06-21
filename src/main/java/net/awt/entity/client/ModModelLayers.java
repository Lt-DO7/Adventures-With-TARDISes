package net.awt.entity.client;

import net.awt.AdventuresWithTARDISes;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer LASER =
            new EntityModelLayer(new Identifier(AdventuresWithTARDISes.MOD_ID, "laser"), "main");

    public static final EntityModelLayer PROTO_CYBERMAN =
            new EntityModelLayer(new Identifier(AdventuresWithTARDISes.MOD_ID, "proto_cyberman"), "main");

    public static final EntityModelLayer MONDASIAN_CYBERMAN =
            new EntityModelLayer(new Identifier(AdventuresWithTARDISes.MOD_ID, "mondasian_cyberman"), "main");

    public static final EntityModelLayer K9 =
            new EntityModelLayer(new Identifier(AdventuresWithTARDISes.MOD_ID, "k9"), "main");

    public static final EntityModelLayer CYBERMAT =
            new EntityModelLayer(new Identifier(AdventuresWithTARDISes.MOD_ID, "cybermat"), "main");

    public static final EntityModelLayer PREHISTORIC_HELMET_ARMOR =
            new EntityModelLayer(new Identifier(AdventuresWithTARDISes.MOD_ID, "prehistoric_helmet_armor"), "main");

    public static final EntityModelLayer PREHISTORIC_CHESTPLATE_ARMOR =
            new EntityModelLayer(new Identifier(AdventuresWithTARDISes.MOD_ID, "prehistoric_chestplate_armor"), "main");

    public static final EntityModelLayer PREHISTORIC_LEGGINGS_ARMOR =
            new EntityModelLayer(new Identifier(AdventuresWithTARDISes.MOD_ID, "prehistoric_leggings_armor"), "main");

    public static final EntityModelLayer PREHISTORIC_BOOTS_ARMOR =
            new EntityModelLayer(new Identifier(AdventuresWithTARDISes.MOD_ID, "prehistoric_boots_armor"), "main");
}
