package net.awt.amblekit.ait.flight;

import dev.amble.ait.core.tardis.control.Control;
import dev.amble.ait.registry.impl.ControlRegistry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class AWTControlResolver {
    private AWTControlResolver() {
    }

    public static List<Control> resolveAll(List<String> controlIds) {
        List<Control> controls = new ArrayList<>();

        for (String controlId : controlIds) {
            Control control = resolve(controlId);
            if (control != null) {
                controls.add(control);
            }
        }

        return controls;
    }

    public static Control resolve(String controlId) {
        if (controlId == null || controlId.isBlank()) {
            return null;
        }

        if (controlId.contains(":")) {
            return ControlRegistry.REGISTRY.get(new Identifier(controlId));
        }

        String normalized = normalize(controlId);
        for (Control control : ControlRegistry.REGISTRY) {
            if (matches(control, controlId, normalized)) {
                return control;
            }
        }

        return null;
    }

    private static boolean matches(Control control, String controlId, String normalized) {
        return control.id().getPath().equals(controlId)
                || control.id().getPath().equals(normalized)
                || control.getClass().getSimpleName().equals(controlId)
                || normalize(control.getClass().getSimpleName()).equals(normalized);
    }

    private static String normalize(String value) {
        return value
                .replace("Control", "")
                .replace("_", "")
                .replace("-", "")
                .toLowerCase(Locale.ROOT);
    }
}
