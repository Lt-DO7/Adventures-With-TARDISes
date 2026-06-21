package net.awt.amblekit.ait.flight;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public final class AWTFlightHazardRegistry {
    private static final Map<String, AWTFlightHazardType> HAZARDS = new LinkedHashMap<>();

    private AWTFlightHazardRegistry() {
    }

    public static void register(AWTFlightHazardType type) {
        HAZARDS.put(type.id(), type);
    }

    public static AWTFlightHazardType get(String id) {
        return HAZARDS.get(id);
    }

    public static Collection<AWTFlightHazardType> values() {
        return HAZARDS.values();
    }
}
