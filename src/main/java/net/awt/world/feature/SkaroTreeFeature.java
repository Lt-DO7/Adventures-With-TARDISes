package net.awt.world.feature;

import net.awt.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Heightmap;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class SkaroTreeFeature extends Feature<DefaultFeatureConfig> {

    public SkaroTreeFeature() {
        super(DefaultFeatureConfig.CODEC);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        StructureWorldAccess world = context.getWorld();
        BlockPos top = world.getTopPosition(Heightmap.Type.WORLD_SURFACE_WG, context.getOrigin());
        BlockPos ground = top.down();
        BlockState groundState = world.getBlockState(ground);
        Random random = context.getRandom();

        if (!isValidGround(groundState)) {
            return false;
        }

        int treeType = random.nextInt(3);
        switch (treeType) {
            case 0 -> generateStandardTree(world, ground, random);
            case 1 -> generateTallTree(world, ground, random);
            case 2 -> generateBush(world, ground, random);
        }

        return true;
    }

    private boolean isValidGround(BlockState state) {
        return state.isOf(Blocks.GRASS_BLOCK)
                || state.isOf(Blocks.DIRT)
                || state.isOf(ModBlocks.WASTED_GRASS)
                || state.isOf(ModBlocks.WASTED_DIRT);
    }

    private void generateStandardTree(StructureWorldAccess world, BlockPos ground, Random random) {
        int height = 4 + random.nextInt(3);
        BlockPos trunkTop = placeTrunk(world, ground, height);

        int radius = 2 + random.nextInt(2);
        placeBlobLeaves(world, trunkTop, radius, random);
    }

    private void generateTallTree(StructureWorldAccess world, BlockPos ground, Random random) {
        int height = 7 + random.nextInt(4);
        BlockPos trunkTop = placeTrunk(world, ground, height);

        int radius = 2 + random.nextInt(2);
        placeBlobLeaves(world, trunkTop.up(1), radius, random);
    }

    private void generateBush(StructureWorldAccess world, BlockPos ground, Random random) {
        int height = 1 + random.nextInt(2);
        BlockPos trunkTop = placeTrunk(world, ground, height);

        int radius = 3 + random.nextInt(2);
        for (int dx = -radius; dx <= radius; dx++) {
            for (int dz = -radius; dz <= radius; dz++) {
                int dist = Math.abs(dx) + Math.abs(dz);
                if (dist > radius + 1) continue;
                if (dist == radius + 1 && random.nextBoolean()) continue;

                BlockPos leafPos = trunkTop.add(dx, 0, dz);
                if (world.getBlockState(leafPos).isAir()) {
                    world.setBlockState(leafPos, ModBlocks.WASTED_LEAVES.getDefaultState(), 2);
                }
            }
        }
        for (int dx = -radius + 1; dx <= radius - 1; dx++) {
            for (int dz = -radius + 1; dz <= radius - 1; dz++) {
                if (Math.abs(dx) == radius - 1 && Math.abs(dz) == radius - 1 && random.nextBoolean()) continue;
                if (Math.abs(dx) + Math.abs(dz) > radius + 1) continue;

                BlockPos leafPos = trunkTop.add(dx, 1, dz);
                if (world.getBlockState(leafPos).isAir()) {
                    world.setBlockState(leafPos, ModBlocks.WASTED_LEAVES.getDefaultState(), 2);
                }
            }
        }
    }

    private BlockPos placeTrunk(StructureWorldAccess world, BlockPos ground, int height) {
        BlockState log = ModBlocks.WASTED_LOG.getDefaultState();
        BlockPos.Mutable pos = ground.up().mutableCopy();

        for (int i = 0; i < height; i++) {
            if (world.getBlockState(pos).isAir()) {
                world.setBlockState(pos, log, 2);
            }
            pos.move(0, 1, 0);
        }

        return pos.down().toImmutable();
    }

    private void placeBlobLeaves(StructureWorldAccess world, BlockPos center, int radius, Random random) {
        BlockState leaves = ModBlocks.WASTED_LEAVES.getDefaultState();

        for (int dx = -radius; dx <= radius; dx++) {
            for (int dz = -radius; dz <= radius; dz++) {
                for (int dy = -radius; dy <= radius; dy++) {
                    BlockPos leafPos = center.add(dx, dy, dz);
                    if (!world.getBlockState(leafPos).isAir()) continue;

                    int dist = Math.abs(dx) + Math.abs(dz) + Math.abs(dy);
                    if (dist <= radius || dist == radius + 1 && random.nextBoolean()) {
                        world.setBlockState(leafPos, leaves, 2);
                    }
                }
            }
        }
    }
}
