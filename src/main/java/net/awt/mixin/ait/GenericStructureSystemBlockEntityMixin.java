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
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import java.util.Optional;

@Mixin(value = GenericStructureSystemBlockEntity.class, remap = false)
public abstract class GenericStructureSystemBlockEntityMixin {
    @Shadow public abstract Optional<dev.amble.ait.core.tardis.Tardis> tardis();
    @Shadow public abstract dev.amble.ait.core.engine.SubSystem system();

    @Inject(method = "useOn", at = @At("HEAD"))
    private void awt$removeMappedSubsystem(BlockState state, World world, boolean sneaking, PlayerEntity player, ItemStack hand,
                                           CallbackInfoReturnable<ActionResult> cir) {
        if (!hand.isEmpty()) {
            return;
        }

        SubSystem system = this.system();
        if (system == null || this.tardis().isEmpty()) {
            return;
        }

        AWTSubsystemBridge.onSubsystemRemoved(this.tardis().get(), system.getId());
    }

    @Inject(method = "useOn", at = @At("RETURN"))
    private void awt$insertMappedSubsystem(BlockState state, World world, boolean sneaking, PlayerEntity player, ItemStack hand,
                                           CallbackInfoReturnable<ActionResult> cir) {
        if (!(this.system() != null) || cir.getReturnValue() != ActionResult.SUCCESS) {
            return;
        }

        AWTSubsystemBridge.onSubsystemInserted((GenericStructureSystemBlockEntity) (Object) this, this.system().getId());
    }
}
