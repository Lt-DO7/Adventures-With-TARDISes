package net.awt.world.gen;

import net.awt.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class ModSurfaceRules {

    public static MaterialRules.MaterialRule THE_LOST_WORLD_SURFACE() {

        return MaterialRules.sequence(

                MaterialRules.condition(
                        MaterialRules.STONE_DEPTH_FLOOR,
                        MaterialRules.block(ModBlocks.LOST_DIRT.getDefaultState())
                ),

                MaterialRules.condition(
                        MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH,
                        MaterialRules.block(Blocks.DIRT.getDefaultState())
                )
        );
    }
}