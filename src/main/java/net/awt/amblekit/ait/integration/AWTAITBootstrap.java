package net.awt.amblekit.ait.integration;

import dev.amble.ait.registry.impl.TardisComponentRegistry;
import net.awt.AdventuresWithTARDISes;
import net.awt.amblekit.ait.flight.AWTFlightEventHandler;
import net.awt.amblekit.ait.subsystems.AWTSubsystemHandler;

public final class AWTAITBootstrap {
    private static boolean initialized;

    private AWTAITBootstrap() {
    }

    public static void initialize() {
        if (initialized) {
            return;
        }

        initialized = true;

        registerTardisComponents();

        AdventuresWithTARDISes.LOGGER.info("Initialized AWT modular TARDIS systems");
    }

    private static void registerTardisComponents() {
        TardisComponentRegistry.getInstance().register(AWTSubsystemHandler.ID);
        TardisComponentRegistry.getInstance().register(AWTFlightEventHandler.ID);
    }
}
