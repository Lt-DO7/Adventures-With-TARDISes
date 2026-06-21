package net.awt.entity;

import net.awt.AdventuresWithTARDISes;
import net.awt.entity.custom.CybermatEntity;
import net.awt.entity.custom.K9Entity;
import net.awt.entity.custom.LaserEntity;
import net.awt.entity.custom.MondasianCybermanEntity;
import net.awt.entity.custom.ProtoCybermanEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<K9Entity> K9 = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(AdventuresWithTARDISes.MOD_ID,"k9"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, K9Entity::new).dimensions(EntityDimensions.fixed(1f, 1f)).build());

    public static final EntityType<CybermatEntity> CYBERMAT = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(AdventuresWithTARDISes.MOD_ID,"cybermat"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CybermatEntity::new).dimensions(EntityDimensions.fixed(1f, 1f)).build());

    public static final EntityType<ProtoCybermanEntity> PROTO_CYBERMAN = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(AdventuresWithTARDISes.MOD_ID, "proto_cyberman"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ProtoCybermanEntity::new).dimensions(EntityDimensions.fixed(0.8f, 2.2f)).build());

    public static final EntityType<MondasianCybermanEntity> MONDASIAN_CYBERMAN = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(AdventuresWithTARDISes.MOD_ID, "mondasian_cyberman"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MondasianCybermanEntity::new).dimensions(EntityDimensions.fixed(0.8f, 2.3f)).build());

    public static final EntityType<LaserEntity> LASER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(AdventuresWithTARDISes.MOD_ID, "laser"),
            FabricEntityTypeBuilder.<LaserEntity>create(SpawnGroup.MISC, LaserEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
                    .trackRangeBlocks(64)
                    .trackedUpdateRate(1)
                    .build());
}
