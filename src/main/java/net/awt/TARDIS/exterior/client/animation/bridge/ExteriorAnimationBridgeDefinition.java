package net.awt.TARDIS.exterior.client.animation.bridge;

import dev.amble.ait.core.tardis.handler.travel.TravelHandlerBase;
import net.awt.TARDIS.exterior.client.animation.ExteriorAnimationSet;
import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.Transformation;
import net.minecraft.util.Identifier;

import java.util.Set;

public record ExteriorAnimationBridgeDefinition(
    Identifier dematId,
    Identifier matId,
    ExteriorAnimationSet animationSet,
    String rootBone,
    Set<DelegatedTrack> delegatedTracks,
    Identifier dematSoundId,
    Identifier matSoundId
) {
    public Identifier idFor(TravelHandlerBase.State state) {
        return state == TravelHandlerBase.State.DEMAT ? dematId : matId;
    }

    public Identifier soundFor(TravelHandlerBase.State state) {
        return state == TravelHandlerBase.State.DEMAT ? dematSoundId : matSoundId;
    }

    public Animation animationFor(TravelHandlerBase.State state) {
        return state == TravelHandlerBase.State.DEMAT ? animationSet.takeoff() : animationSet.landing();
    }

    public boolean delegates(String boneName, Transformation.Target target) {
        return delegatedTracks.contains(new DelegatedTrack(boneName, target));
    }

    public record DelegatedTrack(String boneName, Transformation.Target target) {
    }
}
