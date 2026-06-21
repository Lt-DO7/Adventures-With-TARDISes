package net.awt.amblekit.ait.integration;

import dev.amble.ait.core.engine.SubSystem;

import java.util.LinkedHashMap;
import java.util.Map;

public final class AWTSubsystemLinkRegistry {
    private static final Map<String, String> AIT_TO_AWT = new LinkedHashMap<>();

    private AWTSubsystemLinkRegistry() {
    }

    public static void register(SubSystem.IdLike aitId, String awtId) {
        AIT_TO_AWT.put(aitId.name(), awtId);
    }

    public static String get(SubSystem.IdLike aitId) {
        return aitId == null ? null : AIT_TO_AWT.get(aitId.name());
    }

    public static String get(String aitId) {
        return aitId == null ? null : AIT_TO_AWT.get(aitId);
    }
}
