package net.awt.mixin.ait;

import dev.amble.ait.core.engine.SubSystem;
import dev.amble.ait.core.engine.block.generic.GenericStructureSystemBlockEntity;
import net.awt.amblekit.ait.integration.AWTSubsystemBridge;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = GenericStructureSystemBlockEntity.class, remap = false)
public abstract class GenericStructureSystemBlockEntityMixin {
    @Inject(method = "useOn", at = @At("HEAD"))
    private void awt$removeMappedSubsystem(BlockState state, World world, boolean sneaking, PlayerEntity player, ItemStack hand,
                                           CallbackInfoReturnable<ActionResult> cir) {
        if (!hand.isEmpty()) {
            return;
        }

        GenericStructureSystemBlockEntity block = (GenericStructureSystemBlockEntity) (Object) this;
        SubSystem system = block.system();
        if (system == null || block.tardis().isEmpty()) {
            return;
        }

        AWTSubsystemBridge.onSubsystemRemoved(block.tardis().get(), system.getId());
    }

    @Inject(method = "useOn", at = @At("RETURN"))
    private void awt$insertMappedSubsystem(BlockState state, World world, boolean sneaking, PlayerEntity player, ItemStack hand,
                                           CallbackInfoReturnable<ActionResult> cir) {
        GenericStructureSystemBlockEntity block = (GenericStructureSystemBlockEntity) (Object) this;
        if (block.system() == null || cir.getReturnValue() != ActionResult.SUCCESS) {
            return;
        }

        AWTSubsystemBridge.onSubsystemInserted(block, block.system().getId());
    }
}
