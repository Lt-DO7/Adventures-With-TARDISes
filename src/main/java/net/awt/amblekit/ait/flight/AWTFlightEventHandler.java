package net.awt.amblekit.ait.flight;

import dev.amble.ait.api.tardis.KeyedTardisComponent;
import dev.amble.ait.api.tardis.TardisComponent;
import dev.amble.ait.api.tardis.TardisEvents;
import dev.amble.ait.api.tardis.TardisTickable;
import dev.amble.ait.core.tardis.ServerTardis;
import net.awt.amblekit.ait.subsystems.AWTSubsystemHandler;
import net.minecraft.server.MinecraftServer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class AWTFlightEventHandler extends KeyedTardisComponent implements TardisTickable {
    public static final TardisComponent.IdLike ID =
            new TardisComponent.AbstractId<>("AWT_FLIGHT_EVENTS", AWTFlightEventHandler::new, AWTFlightEventHandler.class);

    private String activeHazardId;
    private int remainingTicks;
    private int solvedControlCount;
    private final List<String> requiredControls = new ArrayList<>();

    static {
        TardisEvents.DEMAT.register(tardis -> {
            AWTFlightEventHandler handler = tardis.asServer().handler(ID);
            if (handler != null) {
                handler.handleDemat(tardis.asServer());
            }
            return TardisEvents.Interaction.PASS;
        });

        TardisEvents.ENTER_FLIGHT.register(tardis -> {
            AWTFlightEventHandler handler = tardis.asServer().handler(ID);
            if (handler != null) {
                handler.handleEnterFlight(tardis.asServer());
            }
        });

        TardisEvents.BEFORE_LAND.register((tardis, pos) -> {
            AWTFlightEventHandler handler = tardis.asServer().handler(ID);
            if (handler != null) {
                handler.handleBeforeLand(tardis.asServer());
            }
            return new TardisEvents.Result<>(pos);
        });

        TardisEvents.LANDED.register(tardis -> {
            AWTFlightEventHandler handler = tardis.asServer().handler(ID);
            if (handler != null) {
                handler.handleLanded(tardis.asServer());
            }
        });
    }

    public AWTFlightEventHandler() {
        super(ID);
    }

    @Override
    public void tick(MinecraftServer server) {
        if (!(tardis() instanceof ServerTardis serverTardis) || activeHazardId == null) {
            return;
        }

        if (remainingTicks > 0) {
            remainingTicks--;
            sync();
        }

        if (remainingTicks == 0) {
            fail(serverTardis);
        }
    }

    public boolean hasActiveHazard() {
        return activeHazardId != null;
    }

    public String activeHazardId() {
        return activeHazardId;
    }

    public int remainingTicks() {
        return remainingTicks;
    }

    public List<String> requiredControls() {
        return List.copyOf(requiredControls);
    }

    public int solvedControlCount() {
        return solvedControlCount;
    }

    public void arm(String hazardId, int durationTicks, List<String> controls) {
        this.activeHazardId = hazardId;
        this.remainingTicks = Math.max(1, durationTicks);
        this.solvedControlCount = 0;
        this.requiredControls.clear();
        this.requiredControls.addAll(controls);
        sync();
    }

    public void clear() {
        if (activeHazardId == null && remainingTicks == 0 && solvedControlCount == 0 && requiredControls.isEmpty()) {
            return;
        }

        activeHazardId = null;
        remainingTicks = 0;
        solvedControlCount = 0;
        requiredControls.clear();
        sync();
    }

    private void handleDemat(ServerTardis tardis) {
        clear();

        AWTFlightHazardContext context = context(tardis);

        for (AWTFlightHazardType type : AWTFlightHazardRegistry.values()) {
            if (!type.canTrigger(context)) {
                continue;
            }

            float chance = Math.max(0.0f, Math.min(1.0f, type.chance(context)));
            if (ThreadLocalRandom.current().nextFloat() > chance) {
                continue;
            }

            arm(type.id(), type.durationTicks(context), type.requiredControls(context));
            return;
        }
    }

    private void handleEnterFlight(ServerTardis tardis) {
        if (activeHazardId == null) {
            return;
        }

        if (tardis.sequence().hasActiveSequence()) {
            return;
        }

        AWTFlightHazardType type = activeType(tardis);
        List<String> controlIds = List.copyOf(requiredControls);
        List<dev.amble.ait.core.tardis.control.Control> controls = AWTControlResolver.resolveAll(controlIds);
        if (controls.isEmpty()) {
            fail(tardis);
            return;
        }

        tardis.sequence().setActiveSequence(new AWTHazardSequence(activeHazardId, remainingTicks, controlIds, controls), true);
        sync();
    }

    private void handleBeforeLand(ServerTardis tardis) {
        if (activeHazardId == null) {
            return;
        }

        fail(tardis);
    }

    private void handleLanded(ServerTardis tardis) {
        clear();
    }

    private AWTFlightHazardContext context(ServerTardis tardis) {
        return new AWTFlightHazardContext(tardis, this, tardis.handler(AWTSubsystemHandler.ID));
    }

    private AWTFlightHazardType activeType(ServerTardis tardis) {
        AWTFlightHazardType type = AWTFlightHazardRegistry.get(activeHazardId);
        if (type == null) {
            throw new IllegalStateException("Unknown AWT flight hazard: " + activeHazardId + " for " + tardis.getUuid());
        }
        return type;
    }

    private void succeed(ServerTardis tardis) {
        solvedControlCount = requiredControls.size();
        activeType(tardis).onSuccess(context(tardis));
        clear();
    }

    private void fail(ServerTardis tardis) {
        activeType(tardis).onFailure(context(tardis));
        clear();
    }

    void onSequenceProgress(int solvedControlCount) {
        if (this.solvedControlCount == solvedControlCount) {
            return;
        }

        this.solvedControlCount = solvedControlCount;
        sync();
    }

    void onSequenceSuccess(ServerTardis tardis) {
        if (activeHazardId == null) {
            return;
        }

        succeed(tardis);
    }

    void onSequenceFailure(ServerTardis tardis) {
        if (activeHazardId == null) {
            return;
        }

        fail(tardis);
    }
}
