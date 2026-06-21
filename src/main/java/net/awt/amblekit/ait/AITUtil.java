package net.awt.amblekit.ait;

import dev.amble.ait.api.AITModInitializer;
import net.awt.AdventuresWithTARDISes;
import net.awt.amblekit.ait.integration.AWTAITBootstrap;

public class AITUtil implements AITModInitializer {
    private static AITUtil instance;

    @Override
    public void onInitializeAIT() {
        // this is called when AIT is ready to be registered to and used with, ait related logic should be placed here
        if (isAITLoaded()) return;

        AdventuresWithTARDISes.LOGGER.info("Initializing AITUtil");
        instance = this;
        AWTAITBootstrap.initialize();

    }

    public static AITUtil instance() {
        return instance;
    }

    public static boolean isAITLoaded() {
        return instance() != null;
    }
}
