package net.awt;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public class AWTDevTeam {
    public static final UUID LEFT = UUID.fromString("225058d4-1f7a-417a-bce9-70d6a7216609");
    public static final UUID DINO = UUID.fromString("fa5ecfab-8941-4968-8692-f5c467e57520");
    public static final UUID DEO = UUID.fromString("c36e27d8-1658-4465-b8ed-29ff2bc622ec");
    public static final UUID ENCDATA = UUID.fromString("bfa96e7e-9fcb-475e-ae69-c3415553535d");
    public static final UUID SCARFO = UUID.fromString("373565e5-2ce7-49d6-a2a9-7bc0b512a5b0");
    public static final UUID CALEB = UUID.fromString("d4609ed0-4ed8-4ac8-83bc-08983b962520");
    public static final UUID BLUEBERRY = UUID.fromString("d21bc86a-14ce-4d4b-bc15-62f6a4c58fe3");
    public static final UUID RHAMMII = UUID.fromString("10782674-3280-4f34-850d-48d1377f94a6");
    public static final List<UUID> UUIDList = List.of(LEFT,DINO,DEO,ENCDATA,SCARFO,CALEB,BLUEBERRY,RHAMMII);

    public AWTDevTeam() {
    }

    public static boolean isDev(UUID uuid) {
        return UUIDList.contains(uuid);
    }
}
