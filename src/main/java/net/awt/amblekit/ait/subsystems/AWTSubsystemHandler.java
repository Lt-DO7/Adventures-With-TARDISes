package net.awt.amblekit.ait.subsystems;

import dev.amble.ait.api.tardis.KeyedTardisComponent;
import dev.amble.ait.api.tardis.TardisComponent;
import dev.amble.ait.api.tardis.TardisTickable;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class AWTSubsystemHandler extends KeyedTardisComponent implements TardisTickable {
    public static final TardisComponent.IdLike ID =
            new TardisComponent.AbstractId<>("AWT_SUBSYSTEMS", AWTSubsystemHandler::new, AWTSubsystemHandler.class);

    private final Map<String, AWTSubsystemState> systems = new LinkedHashMap<>();

    public AWTSubsystemHandler() {
        super(ID);
    }

    @Override
    public void onCreate() {
        bootstrapMissingSubsystems();
    }

    @Override
    public void tick(MinecraftServer server) {
        bootstrapMissingSubsystems();
    }

    public Collection<AWTSubsystemState> values() {
        bootstrapMissingSubsystems();
        return systems.values();
    }

    public AWTSubsystemState get(String id) {
        bootstrapMissingSubsystems();
        return systems.get(id);
    }

    public boolean has(String id) {
        return get(id) != null;
    }

    public boolean isConnected(String id) {
        AWTSubsystemState state = get(id);
        return state != null && state.connected();
    }

    public boolean isEnabled(String id) {
        AWTSubsystemState state = get(id);
        return state != null && state.enabled();
    }

    public int getHealth(String id) {
        AWTSubsystemState state = get(id);
        return state == null ? 0 : state.health();
    }

    public boolean isActive(String id) {
        AWTSubsystemState state = get(id);
        return state != null && state.connected() && state.enabled() && state.health() > 0;
    }

    public void setConnected(String id, boolean connected) {
        AWTSubsystemState state = get(id);
        if (state == null || state.connected() == connected) {
            return;
        }

        state.connected(connected);

        if (!connected) {
            state.enabled(false);
        } else if (!state.isBroken()) {
            state.enabled(true);
        }

        sync();
    }

    public void setEnabled(String id, boolean enabled) {
        AWTSubsystemState state = get(id);
        if (state == null) {
            return;
        }

        boolean next = enabled && state.connected() && !state.isBroken();
        if (state.enabled() == next) {
            return;
        }

        state.enabled(next);
        sync();
    }

    public void disable(String id) {
        setEnabled(id, false);
    }

    public void damage(String id, int amount) {
        mutateHealth(id, -Math.max(0, amount));
    }

    public void repair(String id, int amount) {
        mutateHealth(id, Math.max(0, amount));
    }

    public boolean canRepair(String id, ItemStack stack) {
        AWTSubsystemType type = AWTSubsystemRegistry.get(id);
        AWTSubsystemState state = get(id);
        return type != null && state != null && stack.isOf(type.repairItem()) && state.health() < type.maxHealth();
    }

    private void mutateHealth(String id, int delta) {
        AWTSubsystemType type = AWTSubsystemRegistry.get(id);
        AWTSubsystemState state = get(id);
        if (type == null || state == null || delta == 0) {
            return;
        }

        int previous = state.health();
        int next = Math.max(0, Math.min(type.maxHealth(), previous + delta));
        if (previous == next) {
            return;
        }

        state.health(next);

        if (state.isBroken()) {
            state.enabled(false);
        } else if (state.connected()) {
            state.enabled(true);
        }

        sync();
    }

    private void bootstrapMissingSubsystems() {
        boolean changed = false;

        for (AWTSubsystemType type : AWTSubsystemRegistry.values()) {
            if (systems.containsKey(type.id())) {
                continue;
            }

            systems.put(type.id(), new AWTSubsystemState(type.id(), type.maxHealth()));
            changed = true;
        }

        if (changed && isServer()) {
            sync();
        }
    }
}
