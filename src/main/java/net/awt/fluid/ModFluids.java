package net.awt.fluid;

import net.awt.AdventuresWithTARDISes;
import net.awt.block.ModBlocks;
import net.awt.item.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class ModFluids {
    public static final FlowableFluid STILL_RADIATION = Registry.register(
            Registries.FLUID,
            new Identifier(AdventuresWithTARDISes.MOD_ID, "radiation"),
            new Still()
    );

    public static final FlowableFluid FLOWING_RADIATION = Registry.register(
            Registries.FLUID,
            new Identifier(AdventuresWithTARDISes.MOD_ID, "flowing_radiation"),
            new Flowing()
    );

    public static final FluidBlock RADIATION = Registry.register(
            Registries.BLOCK,
            new Identifier(AdventuresWithTARDISes.MOD_ID, "radiation"),
            new FluidBlock(STILL_RADIATION, FabricBlockSettings.copyOf(net.minecraft.block.Blocks.WATER)
                    .mapColor(net.minecraft.block.MapColor.DARK_GREEN)
                    .strength(100.0F)
                    .noCollision()
                    .dropsNothing()
                    .replaceable()
                    .sounds(BlockSoundGroup.SLIME)) {
                @Override
                public void onEntityCollision(BlockState state, net.minecraft.world.World world, BlockPos pos, Entity entity) {
                    entity.setOnFireFor(2);
                    super.onEntityCollision(state, world, pos, entity);
                }
            }
    );

    public static void registerModFluids() {
        AdventuresWithTARDISes.LOGGER.info("Registering ModFluids for " + AdventuresWithTARDISes.MOD_ID);
    }

    public abstract static class RadiationFluid extends FlowableFluid {
        @Override
        public Fluid getStill() {
            return STILL_RADIATION;
        }

        @Override
        public Fluid getFlowing() {
            return FLOWING_RADIATION;
        }

        @Override
        public Item getBucketItem() {
            return ModItems.RADIATION_BUCKET;
        }

        @Override
        protected boolean isInfinite(net.minecraft.world.World world) {
            return false;
        }

        @Override
        protected void beforeBreakingBlock(net.minecraft.world.WorldAccess world, BlockPos pos, BlockState state) {
            BlockEntityAccessor.dropStacks(state, world, pos);
        }

        @Override
        protected int getFlowSpeed(WorldView world) {
            return 3;
        }

        @Override
        protected int getLevelDecreasePerBlock(WorldView world) {
            return 1;
        }

        @Override
        public int getTickRate(WorldView world) {
            return 20;
        }

        @Override
        protected float getBlastResistance() {
            return 100.0F;
        }

        @Override
        protected BlockState toBlockState(FluidState state) {
            return ModFluids.RADIATION.getDefaultState().with(FluidBlock.LEVEL, getBlockStateLevel(state));
        }

        @Override
        public boolean matchesType(Fluid fluid) {
            return fluid == STILL_RADIATION || fluid == FLOWING_RADIATION;
        }

        @Override
        protected boolean canBeReplacedWith(FluidState state, BlockView world, BlockPos pos, Fluid fluid, net.minecraft.util.math.Direction direction) {
            return direction == net.minecraft.util.math.Direction.DOWN && !fluid.matchesType(STILL_RADIATION);
        }
    }

    public static class Flowing extends RadiationFluid {
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(Properties.LEVEL_1_8);
        }

        @Override
        public int getLevel(FluidState state) {
            return state.get(Properties.LEVEL_1_8);
        }

        @Override
        public boolean isStill(FluidState state) {
            return false;
        }
    }

    public static class Still extends RadiationFluid {
        @Override
        public int getLevel(FluidState state) {
            return 8;
        }

        @Override
        public boolean isStill(FluidState state) {
            return true;
        }
    }

    private static final class BlockEntityAccessor {
        private static void dropStacks(BlockState state, net.minecraft.world.WorldAccess world, BlockPos pos) {
            net.minecraft.block.Block.dropStacks(state, world, pos, state.hasBlockEntity() ? world.getBlockEntity(pos) : null);
        }
    }
}
