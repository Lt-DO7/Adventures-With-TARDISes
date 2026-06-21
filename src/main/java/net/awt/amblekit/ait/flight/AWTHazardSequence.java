package net.awt.amblekit.ait.flight;

import dev.amble.ait.core.tardis.Tardis;
import dev.amble.ait.core.tardis.control.Control;
import dev.amble.ait.core.tardis.control.sequences.Sequence;
import net.awt.AdventuresWithTARDISes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AWTHazardSequence extends Sequence {
    private final String hazardId;
    private final int timeToFail;
    private final List<String> controlIds;
    private final List<Control> controls;

    public AWTHazardSequence(String hazardId, int timeToFail, List<String> controlIds, List<Control> controls) {
        this.hazardId = hazardId;
        this.timeToFail = timeToFail;
        this.controlIds = List.copyOf(controlIds);
        this.controls = List.copyOf(controls);
    }

    @Override
    public Identifier id() {
        return AdventuresWithTARDISes.id("hazard/" + hazardId);
    }

    @Override
    public List<Control> getControls() {
        return controls;
    }

    @Override
    public Long timeToFail() {
        return (long) timeToFail;
    }

    @Override
    public void execute(Tardis tardis, @Nullable ServerPlayerEntity player) {
        super.execute(tardis, player);
        AWTFlightEventHandler handler = handler(tardis);
        if (handler != null) {
            handler.onSequenceSuccess(tardis.asServer());
        }
    }

    @Override
    public void executeMissed(Tardis tardis, @Nullable ServerPlayerEntity player) {
        super.executeMissed(tardis, player);
        AWTFlightEventHandler handler = handler(tardis);
        if (handler != null) {
            handler.onSequenceFailure(tardis.asServer());
        }
    }

    @Override
    public Text sequenceStartMessage() {
        return Text.literal("Hazard: " + hazardId);
    }

    public List<String> controlIds() {
        return controlIds;
    }

    private AWTFlightEventHandler handler(Tardis tardis) {
        return tardis.asServer().handler(AWTFlightEventHandler.ID);
    }
}
