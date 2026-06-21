package net.awt.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AWTSubsystemItem extends Item {
    private final String subsystemId;

    public AWTSubsystemItem(Settings settings, String subsystemId) {
        super(settings);
        this.subsystemId = subsystemId;
    }

    public String subsystemId() {
        return subsystemId;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(Text.literal(subsystemId.replace('_', ' ')));
    }
}
