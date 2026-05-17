package net.awt;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public class AWTDevTeam {
    public static final UUID LEFT = UUID.fromString("225058d4-1f7a-417a-bce9-70d6a7216609");
    public static final UUID DINO = UUID.fromString("fa5ecfab-8941-4968-8692-f5c467e57520");
    public static final UUID DEO = UUID.fromString("c36e27d8-1658-4465-b8ed-29ff2bc622ec");
    public static final UUID RHAMNOUS = UUID.fromString("52874799-eb90-4bd4-bc8c-f4ed89b4cb83");
    public static final UUID NATHAN = UUID.fromString("5ddf0693-9a1f-4f34-b29d-9daa1e4d0c2a");
    public static final UUID TARDISOWNER = UUID.fromString("a82ed141-f1c7-4e33-8f07-3b7e3d556ba8");
    public static final UUID COLOURFUL = UUID.fromString("33e35580-7404-497b-bf0f-6e735afd67cd");
    public static final UUID SCARFO = UUID.fromString("373565e5-2ce7-49d6-a2a9-7bc0b512a5b0");
    public static final List<UUID> UUIDList = List.of(LEFT,DINO,DEO,RHAMNOUS,NATHAN,TARDISOWNER,COLOURFUL,SCARFO);

    public AWTDevTeam() {
    }

    public static boolean isDev(UUID uuid) {
        return UUIDList.contains(uuid);
    }
}
