package net.awt.amblekit.ait.subsystems;

import net.minecraft.item.Item;

public record AWTSubsystemType(String id, int maxHealth, Item repairItem, Item subsystemItem) {
}
