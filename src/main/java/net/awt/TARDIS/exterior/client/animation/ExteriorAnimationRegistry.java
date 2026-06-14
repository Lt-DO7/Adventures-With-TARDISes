package net.awt.TARDIS.exterior.client.animation;

import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class ExteriorAnimationRegistry {
    private static final Map<Identifier, ExteriorAnimationSet> ENTRIES = new HashMap<>();

    static {
        registerShared("awt", Set.of(
            "redonion",
            "yellowonion",
            "blueonion",
            "whiteonion",
            "purpleonion",
            "greyonion",
            "pinkonion",
            "lightblueonion",
            "limegreenonion"
        ), new ExteriorAnimationSet(OnionExteriorAnimations.TAKEOFF, OnionExteriorAnimations.LANDING));
    }

    private ExteriorAnimationRegistry() {
    }

    public static void register(Identifier variantId, ExteriorAnimationSet animationSet) {
        ENTRIES.put(variantId, animationSet);
    }

    public static void registerShared(String namespace, Set<String> paths, ExteriorAnimationSet animationSet) {
        for (String path : paths) {
            register(new Identifier(namespace, "exterior/" + path), animationSet);
        }
    }

    public static ExteriorAnimationSet get(Identifier variantId) {
        return ENTRIES.get(variantId);
    }
}
