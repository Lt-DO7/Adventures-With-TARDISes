package net.awt.amblekit.ait.subsystems;

import net.minecraft.item.Item;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public final class AWTSubsystemRegistry {
    private static final Map<String, AWTSubsystemType> TYPES = new LinkedHashMap<>();
    private static final Map<Item, AWTSubsystemType> ITEMS = new LinkedHashMap<>();

    private AWTSubsystemRegistry() {
    }

    public static void register(AWTSubsystemType type) {
        TYPES.put(type.id(), type);
        ITEMS.put(type.subsystemItem(), type);
    }

    public static AWTSubsystemType get(String id) {
        return TYPES.get(id);
    }

    public static AWTSubsystemType get(Item item) {
        return ITEMS.get(item);
    }

    public static Collection<AWTSubsystemType> values() {
        return TYPES.values();
    }
}
