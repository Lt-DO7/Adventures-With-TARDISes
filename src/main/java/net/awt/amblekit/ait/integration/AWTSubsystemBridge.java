package net.awt.amblekit.ait.integration;

import dev.amble.ait.core.engine.SubSystem;
import dev.amble.ait.core.engine.block.generic.GenericStructureSystemBlockEntity;
import dev.amble.ait.core.tardis.Tardis;
import net.awt.amblekit.ait.subsystems.AWTSubsystemHandler;

public final class AWTSubsystemBridge {
    private AWTSubsystemBridge() {
    }

    public static void onSubsystemInserted(GenericStructureSystemBlockEntity block, SubSystem.IdLike aitId) {
        if (block.tardis().isEmpty()) {
            return;
        }

        sync(block.tardis().get(), aitId, block.isLinked());
    }

    public static void onSubsystemRemoved(Tardis tardis, SubSystem.IdLike aitId) {
        sync(tardis, aitId, false);
    }

    public static void onLinkStateChanged(GenericStructureSystemBlockEntity block, boolean linked) {
        if (block.tardis().isEmpty()) {
            return;
        }

        sync(block.tardis().get(), block.system() == null ? null : block.system().getId(), linked);
    }

    private static void sync(Tardis tardis, SubSystem.IdLike aitId, boolean connected) {
        String awtId = AWTSubsystemLinkRegistry.get(aitId);
        if (awtId == null) {
            return;
        }

        AWTSubsystemHandler handler = tardis.handler(AWTSubsystemHandler.ID);
        if (handler != null) {
            handler.setConnected(awtId, connected);
        }
    }
}
