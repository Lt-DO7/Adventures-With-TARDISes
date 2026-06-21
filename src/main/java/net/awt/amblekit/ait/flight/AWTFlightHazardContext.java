package net.awt.amblekit.ait.flight;

import dev.amble.ait.core.tardis.ServerTardis;
import net.awt.amblekit.ait.subsystems.AWTSubsystemHandler;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public record AWTFlightHazardContext(ServerTardis tardis, AWTFlightEventHandler hazards, AWTSubsystemHandler subsystems) {
    public Identifier destinationId() {
        return tardis.travel().destination().getDimension().getValue();
    }

    public boolean destinationEquals(String id) {
        return destinationId().toString().equals(id);
    }

    public void offsetLanding(int x, int y, int z) {
        tardis.travel().forceDestination(cached -> cached.pos(cached.getPos().add(x, y, z)));
    }

    public void emergencyLand() {
        tardis.travel().speed(0);
        tardis.travel().rematerialize();
    }

    public void roughLanding() {
        offsetLanding(6, 0, 6);
    }

    public void damageSubsystem(String id, int amount) {
        subsystems.damage(id, amount);
    }

    public void disableSubsystem(String id) {
        subsystems.disable(id);
    }

    public BlockPos destinationPos() {
        return tardis.travel().destination().getPos();
    }

    public void returnToPreviousDimension() {
        if (tardis.travel().previousPosition() == null || tardis.travel().destination() == null) {
            return;
        }

        tardis.travel().forceDestination(tardis.travel().destination().world(tardis.travel().previousPosition().getWorld()));
    }
}
