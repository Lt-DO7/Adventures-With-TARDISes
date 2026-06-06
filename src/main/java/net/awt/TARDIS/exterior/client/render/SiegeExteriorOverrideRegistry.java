package net.awt.TARDIS.exterior.client.render;

import dev.amble.ait.client.models.exteriors.ExteriorModel;
import net.awt.TARDIS.exterior.client.model.exterior.SeigedOnion;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;

public final class SiegeExteriorOverrideRegistry {
    private static final Map<Identifier, Entry> ENTRIES = new HashMap<>();

    static {
        registerSharedModel("awt", Set.of(
            "redonion",
            "yellowonion",
            "blueonion",
            "whiteonion",
            "purpleonion",
            "greyonion",
            "pinkonion",
            "lightblueonion",
            "limegreenonion"
        ), SeigedOnion::new);
    }

    private SiegeExteriorOverrideRegistry() {
    }

    public static void registerSharedModel(String namespace, Set<String> paths, Supplier<ExteriorModel> modelFactory) {
        for (String path : paths) {
            Identifier id = new Identifier(namespace, "exterior/" + path);
            register(id, modelFactory, variantId -> new Identifier(variantId.getNamespace(),
                "textures/blockentities/exteriors/" + awt$textureFolder(variantId) + "/siege.png"));
        }
    }

    public static void register(Identifier variantId, Supplier<ExteriorModel> modelFactory, Function<Identifier, Identifier> textureFactory) {
        ENTRIES.put(variantId, new Entry(modelFactory.get(), textureFactory));
    }

    public static Entry get(Identifier variantId) {
        return ENTRIES.get(variantId);
    }

    private static String awt$textureFolder(Identifier variantId) {
        String path = variantId.getPath();
        String prefix = "exterior/";
        return path.startsWith(prefix) ? path.substring(prefix.length()) : path;
    }

    public record Entry(ExteriorModel model, Function<Identifier, Identifier> textureFactory) {
        public Identifier texture(Identifier variantId) {
            return textureFactory.apply(variantId);
        }
    }
}
