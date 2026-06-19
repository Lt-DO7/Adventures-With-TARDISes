package net.awt.TARDIS.exterior.client.animation.bridge;

import dev.amble.ait.core.tardis.handler.travel.TravelHandlerBase;
import net.awt.TARDIS.exterior.client.animation.ExteriorAnimationSet;
import net.awt.TARDIS.exterior.client.animation.OnionExteriorAnimations;
import net.minecraft.client.render.entity.animation.Transformation;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class ExteriorAnimationBridgeRegistry {
    private static final Map<Identifier, ExteriorAnimationBridgeDefinition> VARIANT_ENTRIES = new HashMap<>();
    private static final Map<Identifier, BridgeRuntimeEntry> RUNTIME_ENTRIES = new HashMap<>();

    static {
        registerShared(
            "awt",
            "onion",
            Set.of(
                "redonion",
                "yellowonion",
                "blueonion",
                "whiteonion",
                "purpleonion",
                "greyonion",
                "pinkonion",
                "lightblueonion",
                "limegreenonion"
            ),
            new ExteriorAnimationSet(OnionExteriorAnimations.TAKEOFF, OnionExteriorAnimations.LANDING),
            "Root",
            Set.of(
                new ExteriorAnimationBridgeDefinition.DelegatedTrack("Root", Transformation.Targets.ROTATE),
                new ExteriorAnimationBridgeDefinition.DelegatedTrack("Root", Transformation.Targets.TRANSLATE)
            ),
            new Identifier("ait", "tardis/demat"),
            new Identifier("ait", "tardis/mat")
        );
    }

    private ExteriorAnimationBridgeRegistry() {
    }

    public static ExteriorAnimationBridgeDefinition getByVariant(Identifier variantId) {
        return VARIANT_ENTRIES.get(variantId);
    }

    public static BridgeRuntimeEntry getByRuntimeId(Identifier animationId) {
        return RUNTIME_ENTRIES.get(animationId);
    }

    public static void registerShared(String namespace, String bridgeName, Set<String> paths, ExteriorAnimationSet animationSet,
                                      String rootBone, Set<ExteriorAnimationBridgeDefinition.DelegatedTrack> delegatedTracks,
                                      Identifier dematSoundId, Identifier matSoundId) {
        Identifier dematId = new Identifier(namespace, "bridge/" + bridgeName + "_demat");
        Identifier matId = new Identifier(namespace, "bridge/" + bridgeName + "_mat");
        ExteriorAnimationBridgeDefinition definition = new ExteriorAnimationBridgeDefinition(
            dematId,
            matId,
            animationSet,
            rootBone,
            delegatedTracks,
            dematSoundId,
            matSoundId
        );

        for (String path : paths) {
            VARIANT_ENTRIES.put(new Identifier(namespace, "exterior/" + path), definition);
        }

        RUNTIME_ENTRIES.put(dematId, new BridgeRuntimeEntry(definition, TravelHandlerBase.State.DEMAT));
        RUNTIME_ENTRIES.put(matId, new BridgeRuntimeEntry(definition, TravelHandlerBase.State.MAT));
    }

    public record BridgeRuntimeEntry(ExteriorAnimationBridgeDefinition definition, TravelHandlerBase.State state) {
    }
}
