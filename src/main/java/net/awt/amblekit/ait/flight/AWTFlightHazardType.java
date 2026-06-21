package net.awt.amblekit.ait.flight;

import java.util.List;

public interface AWTFlightHazardType {
    String id();

    boolean canTrigger(AWTFlightHazardContext context);

    float chance(AWTFlightHazardContext context);

    int durationTicks(AWTFlightHazardContext context);

    List<String> requiredControls(AWTFlightHazardContext context);

    void onSuccess(AWTFlightHazardContext context);

    void onFailure(AWTFlightHazardContext context);
}
