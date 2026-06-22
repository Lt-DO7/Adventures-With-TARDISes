package net.awt.world.dimension;

import net.awt.AdventuresWithTARDISes;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;

import java.util.OptionalLong;

public class ModDimensions {
    public static final RegistryKey<World> SKARO_LEVEL_KEY = RegistryKey.of(
            RegistryKeys.WORLD, new Identifier(AdventuresWithTARDISes.MOD_ID, "skaro"));
    public static final RegistryKey<DimensionType> SKARO_DIM_TYPE = RegistryKey.of(
            RegistryKeys.DIMENSION_TYPE, new Identifier(AdventuresWithTARDISes.MOD_ID, "skaro_type"));

    public static final RegistryKey<World> MONDAS_LEVEL_KEY = RegistryKey.of(
            RegistryKeys.WORLD,
            new Identifier(AdventuresWithTARDISes.MOD_ID, "mondas")
    );
    public static final RegistryKey<DimensionType> MONDAS_DIM_TYPE = RegistryKey.of(
            RegistryKeys.DIMENSION_TYPE,
            new Identifier(AdventuresWithTARDISes.MOD_ID, "mondas_type")
    );

    public static void bootstrapType(Registerable<DimensionType> context) {
        context.register(SKARO_DIM_TYPE, new DimensionType(
                OptionalLong.of(18_000L),
                true,
                false,
                false,
                true,
                1.0D,
                true,
                false,
                -64,
                384,
                384,
                BlockTags.INFINIBURN_OVERWORLD,
                DimensionTypes.OVERWORLD_ID,
                0.0F,
                new DimensionType.MonsterSettings(false, false, UniformIntProvider.create(0, 7), 0)
        ));

        context.register(MONDAS_DIM_TYPE, new DimensionType(
                OptionalLong.of(18000L),
                true,
                false,
                false,
                true,
                1.0D,
                true,
                false,
                -64,
                384,
                384,
                BlockTags.INFINIBURN_OVERWORLD,
                DimensionTypes.OVERWORLD_ID,
                0.0F,
                new DimensionType.MonsterSettings(false, false, UniformIntProvider.create(0, 7), 0)
        ));
    }


}
