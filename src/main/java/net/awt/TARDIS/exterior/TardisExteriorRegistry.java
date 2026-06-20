package net.awt.TARDIS.exterior;

import dev.amble.ait.client.models.exteriors.JakeTheDogExteriorModel;
import dev.amble.ait.data.schema.exterior.variant.addon.AddonExterior;
import net.awt.TARDIS.exterior.category.custom.AWTExclusiveCategory;
import net.awt.TARDIS.exterior.client.model.door.*;
import net.awt.TARDIS.exterior.client.model.exterior.*;
import net.awt.sound.AWTSound;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import org.joml.Vector3f;

import static net.awt.AdventuresWithTARDISes.MOD_ID;

public class TardisExteriorRegistry {
    public static AddonExterior REDONION;
    public static AddonExterior YELLOWONION;
    public static AddonExterior BLUEONION;
    public static AddonExterior WHITEONION;
    public static AddonExterior PURPLEONION;
    public static AddonExterior GREYONION;
    public static AddonExterior PINKONION;
    public static AddonExterior LIGHTBLUEONION;
    public static AddonExterior LIMEGREENONION;
    public static AddonExterior POLICEBOX;
    public static AddonExterior TYPE70;
    public static AddonExterior TYPE70WG;
    public static AddonExterior TYPE70ALT;
    public static AddonExterior BLOCKTIS;
    public static AddonExterior BLOCKTISV2;
    public static AddonExterior BLOCKTISV3;
    public static AddonExterior LEGO;
    public static AddonExterior LEGO2;
    public static AddonExterior LEGO3;
    public static AddonExterior LEGODIM;
    public static AddonExterior POLICEBOXALT;
    public static AddonExterior POLICEBOXPURPLE;
    public static AddonExterior LEFTHOTTUB;
    public static AddonExterior POLICEBOXCORAL;
    public static AddonExterior POLICEBOXBADWOLF;
    public static AddonExterior POLICEBOXBADGHOST;
    public static AddonExterior GAMBLEBOX;
    public static AddonExterior POLICEBOXTOKOMAK;
    public static AddonExterior POLICEBOXALT2;
    public static AddonExterior POLICEBOXRHAMNOUS;
    public static AddonExterior POLICEBOXNATHAN;
    public static AddonExterior POLICEBOXDINO;
    public static AddonExterior POLICEBOXORANGE;
    public static AddonExterior POLICEBOXFLATLINE;
    public static AddonExterior RHAMNOUSVANILLA;
    public static AddonExterior GLASGLOWVANILLA;
    public static AddonExterior GAMBLEBLOCKTIS;
    public static AddonExterior BLOCKTISBNW;
    public static AddonExterior TIMEPOD;
    public static AddonExterior POLICEBOXLUX;
    public static AddonExterior GLASGLOW;
   public static AddonExterior BEEHIVE;
   public static AddonExterior NEZUKO;
   public static AddonExterior POLICEBOXCANDY;
   public static AddonExterior POLICEBOXGLASGLOW;
    public static AddonExterior POLICEBOXTEXTURE;
    public static AddonExterior LEGODIMALT;
    public static AddonExterior LEGODIMINVERTED;
    public static AddonExterior BLUEBERRY;
    public static AddonExterior K2PHONEBOOTH;
    public static AddonExterior K2PHONEBOOTHBATTERED;
    public static AddonExterior K2PHONEBOOTHBLUE;
    public static AddonExterior K2PHONEBOOTHGREY;
    public static AddonExterior K2PHONEBOOTHPINK;
    public static AddonExterior K2PHONEBOOTHGLOOM;
    public static AddonExterior K2PHONEBOOTHGHOST;
    public static AddonExterior K2PHONEBOOTHFUTURE;
    public static AddonExterior K6PHONEBOOTH;
    public static AddonExterior K6PHONEBOOTHBATTERED;
    public static AddonExterior K6PHONEBOOTHGLOOM;
    public static AddonExterior K6PHONEBOOTHFUTURE;
    public static AddonExterior K6PHONEBOOTHBEE;
    public static AddonExterior K6PHONEBOOTHGHOST;
    public static AddonExterior POLICEBOXENC;
    public static AddonExterior SCARFO;
    public static AddonExterior LIGHT;
    public static AddonExterior BLUEBERRYGHOST;

    public static AddonExterior JAKE;

    public static void onInitialize() {
        REDONION = new AddonExterior(new Identifier(MOD_ID, "onion"), MOD_ID, "redonion").register();
        REDONION.setDoor(new AddonExterior.Door(REDONION, false, AWTSound.BLOOP, AWTSound.BLOOP)).toDoor().register();

        YELLOWONION = new AddonExterior(new Identifier(MOD_ID, "onion"), MOD_ID, "yellowonion").register();
        YELLOWONION.setDoor(new AddonExterior.Door(YELLOWONION, false, AWTSound.BLOOP, AWTSound.BLOOP)).toDoor().register();

        BLUEONION = new AddonExterior(new Identifier(MOD_ID, "onion"), MOD_ID, "blueonion").register();
        BLUEONION.setDoor(new AddonExterior.Door(BLUEONION, false, AWTSound.BLOOP, AWTSound.BLOOP)).toDoor().register();

        WHITEONION = new AddonExterior(new Identifier(MOD_ID, "onion"), MOD_ID, "whiteonion").register();
        WHITEONION.setDoor(new AddonExterior.Door(WHITEONION, false, AWTSound.BLOOP, AWTSound.BLOOP)).toDoor().register();

        PURPLEONION = new AddonExterior(new Identifier(MOD_ID, "onion"), MOD_ID, "purpleonion").register();
        PURPLEONION.setDoor(new AddonExterior.Door(PURPLEONION, false, AWTSound.BLOOP, AWTSound.BLOOP)).toDoor().register();

        GREYONION = new AddonExterior(new Identifier(MOD_ID, "onion"), MOD_ID, "greyonion").register();
        GREYONION.setDoor(new AddonExterior.Door(GREYONION, false, AWTSound.BLOOP, AWTSound.BLOOP)).toDoor().register();

        PINKONION = new AddonExterior(new Identifier(MOD_ID, "onion"), MOD_ID, "pinkonion").register();
        PINKONION.setDoor(new AddonExterior.Door(PINKONION, false, AWTSound.BLOOP, AWTSound.BLOOP)).toDoor().register();

        LIGHTBLUEONION = new AddonExterior(new Identifier(MOD_ID, "onion"), MOD_ID, "lightblueonion").register();
        LIGHTBLUEONION.setDoor(new AddonExterior.Door(LIGHTBLUEONION, false, AWTSound.BLOOP, AWTSound.BLOOP)).toDoor().register();

        LIMEGREENONION = new AddonExterior(new Identifier(MOD_ID, "onion"), MOD_ID, "limegreenonion").register();
        LIMEGREENONION.setDoor(new AddonExterior.Door(LIMEGREENONION, false, AWTSound.BLOOP, AWTSound.BLOOP)).toDoor().register();

        POLICEBOX = new AddonExterior(new Identifier(MOD_ID, "modernboxes"), MOD_ID, "policebox_copper").register();
        POLICEBOX.setDoor(new AddonExterior.Door(POLICEBOX, true, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        TYPE70 = new AddonExterior(new Identifier(MOD_ID, "capsules"), MOD_ID, "type70").register();
        TYPE70.setDoor(new AddonExterior.Door(TYPE70, false, SoundEvents.BLOCK_IRON_DOOR_OPEN, SoundEvents.BLOCK_IRON_DOOR_CLOSE)).toDoor().register();

        TYPE70WG = new AddonExterior(new Identifier(MOD_ID, "capsules"), MOD_ID, "type70wg").register();
        TYPE70WG.setDoor(new AddonExterior.Door(TYPE70WG, false, SoundEvents.BLOCK_IRON_DOOR_OPEN, SoundEvents.BLOCK_IRON_DOOR_CLOSE)).toDoor().register();

        TYPE70ALT = new AddonExterior(new Identifier(MOD_ID, "capsules"), MOD_ID, "type70alt").register();
        TYPE70ALT.setDoor(new AddonExterior.Door(TYPE70ALT, false, SoundEvents.BLOCK_IRON_DOOR_OPEN, SoundEvents.BLOCK_IRON_DOOR_CLOSE)).toDoor().register();

        BLOCKTIS = new AddonExterior(new Identifier(MOD_ID, "blocktardis"), MOD_ID, "blocktis").register();
        BLOCKTIS.setDoor(new AddonExterior.Door(BLOCKTIS, false, SoundEvents.BLOCK_IRON_DOOR_OPEN, SoundEvents.BLOCK_IRON_DOOR_CLOSE)).toDoor().register();

        BLOCKTISV2 = new AddonExterior(new Identifier(MOD_ID, "blocktardis"), MOD_ID, "blocktisv2").register();
        BLOCKTISV2.setDoor(new AddonExterior.Door(BLOCKTISV2, false, SoundEvents.BLOCK_IRON_DOOR_OPEN, SoundEvents.BLOCK_IRON_DOOR_CLOSE)).toDoor().register();

        BLOCKTISBNW = new AddonExterior(new Identifier(MOD_ID, "blocktardis"), MOD_ID, "blocktisbnw").register();
        BLOCKTISBNW.setDoor(new AddonExterior.Door(BLOCKTISBNW, false, SoundEvents.BLOCK_IRON_DOOR_OPEN, SoundEvents.BLOCK_IRON_DOOR_CLOSE)).toDoor().register();

        BLOCKTISV3 = new AddonExterior(new Identifier(MOD_ID, "blocktardis"), MOD_ID, "blocktisv3").register();
        BLOCKTISV3.setDoor(new AddonExterior.Door(BLOCKTISV3, false, SoundEvents.BLOCK_IRON_DOOR_OPEN, SoundEvents.BLOCK_IRON_DOOR_CLOSE)).toDoor().register();

        RHAMNOUSVANILLA = new AddonExterior(new Identifier(MOD_ID, "blocktardis"), MOD_ID, "rhamnous_vanilla").register();
        RHAMNOUSVANILLA.setDoor(new AddonExterior.Door(RHAMNOUSVANILLA, false, SoundEvents.BLOCK_IRON_DOOR_OPEN, SoundEvents.BLOCK_IRON_DOOR_CLOSE)).toDoor().register();

        GLASGLOWVANILLA = new AddonExterior(new Identifier(MOD_ID, "blocktardis"), MOD_ID, "glasglow_vanilla").register();
        GLASGLOWVANILLA.setDoor(new AddonExterior.Door(GLASGLOWVANILLA, false, SoundEvents.BLOCK_IRON_DOOR_OPEN, SoundEvents.BLOCK_IRON_DOOR_CLOSE)).toDoor().register();

        GAMBLEBLOCKTIS = new AddonExterior(new Identifier(MOD_ID, "blocktardis"), MOD_ID, "gambleblocktis").register();
        GAMBLEBLOCKTIS.setDoor(new AddonExterior.Door(GAMBLEBLOCKTIS, false, SoundEvents.BLOCK_WOODEN_DOOR_OPEN, SoundEvents.BLOCK_WOODEN_DOOR_CLOSE)).toDoor().register();

        LEGO = new AddonExterior(new Identifier(MOD_ID, "legoboxes"), MOD_ID, "logo_tardis_default").register();
        LEGO.setDoor(new AddonExterior.Door(LEGO, true, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        LEGO2 = new AddonExterior(new Identifier(MOD_ID, "legoboxes"), MOD_ID, "logo_tardis_purple").register();
        LEGO2.setDoor(new AddonExterior.Door(LEGO2, true, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        LEGO3 = new AddonExterior(new Identifier(MOD_ID, "legoboxes"), MOD_ID, "logo_tardis_darkblue").register();
        LEGO3.setDoor(new AddonExterior.Door(LEGO3, true, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        LEGODIM = new AddonExterior(new Identifier(MOD_ID, "legoboxes"), MOD_ID, "lego_dimensions_police_box").register();
        LEGODIM.setDoor(new AddonExterior.Door(LEGODIM, true, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        POLICEBOXALT = new AddonExterior(new Identifier(MOD_ID, "modernboxes"), MOD_ID, "policebox_alt").register();
        POLICEBOXALT.setDoor(new AddonExterior.Door(POLICEBOXALT, true, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        POLICEBOXPURPLE = new AddonExterior(new Identifier(MOD_ID, "modernboxes"), MOD_ID, "policebox_purple").register();
        POLICEBOXPURPLE.setDoor(new AddonExterior.Door(POLICEBOXPURPLE, true, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        JAKE = new AddonExterior(new Identifier(MOD_ID, "ships"), MOD_ID, "jake").register();
        JAKE.setDoor(new AddonExterior.Door(JAKE, false, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        LEFTHOTTUB = new AddonExterior(new Identifier(MOD_ID, "hottub"), MOD_ID, "lefthottub").register();
        LEFTHOTTUB.setDoor(new AddonExterior.Door(LEFTHOTTUB, true, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        POLICEBOXCORAL = new AddonExterior(new Identifier(MOD_ID, "modernboxes"), MOD_ID, "policebox_coral").register();
        POLICEBOXCORAL.setDoor(new AddonExterior.Door(POLICEBOXCORAL, true, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        POLICEBOXBADWOLF = new AddonExterior(new Identifier(MOD_ID, "modernboxes"), MOD_ID, "policebox_badwolf").register();
        POLICEBOXBADWOLF.setDoor(new AddonExterior.Door(POLICEBOXBADWOLF, true, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        POLICEBOXBADGHOST = new AddonExterior(new Identifier(MOD_ID, "modernboxes"), MOD_ID, "policebox_badghost").register();
        POLICEBOXBADGHOST.setDoor(new AddonExterior.Door(POLICEBOXBADGHOST, true, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        GAMBLEBOX = new AddonExterior(AWTExclusiveCategory.REFERENCE, MOD_ID, "gamblebox").register();
        GAMBLEBOX.setDoor(new AddonExterior.Door(GAMBLEBOX, true, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        POLICEBOXTOKOMAK = new AddonExterior(new Identifier(MOD_ID, "modernboxes"), MOD_ID, "policebox_tokomak").register();
        POLICEBOXTOKOMAK.setDoor(new AddonExterior.Door(POLICEBOXTOKOMAK, true, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        POLICEBOXALT2 = new AddonExterior(new Identifier(MOD_ID, "modernboxes"), MOD_ID, "policebox_alt2").register();
        POLICEBOXALT2.setDoor(new AddonExterior.Door(POLICEBOXALT2, true, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        POLICEBOXRHAMNOUS = new AddonExterior(new Identifier(MOD_ID, "modernboxes"), MOD_ID, "policebox_rhamnous").register();
        POLICEBOXRHAMNOUS.setDoor(new AddonExterior.Door(POLICEBOXRHAMNOUS, true, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        POLICEBOXNATHAN = new AddonExterior(new Identifier(MOD_ID, "modernboxes"), MOD_ID, "policebox_nathan").register();
        POLICEBOXNATHAN.setDoor(new AddonExterior.Door(POLICEBOXNATHAN, true, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        POLICEBOXDINO = new AddonExterior(AWTExclusiveCategory.REFERENCE, MOD_ID, "policebox_dino").register();
        POLICEBOXDINO.setDoor(new AddonExterior.Door(POLICEBOXDINO, true, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        POLICEBOXORANGE = new AddonExterior(new Identifier(MOD_ID, "modernboxes"), MOD_ID, "policebox_orange").register();
        POLICEBOXORANGE.setDoor(new AddonExterior.Door(POLICEBOXORANGE, true, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        POLICEBOXFLATLINE = new AddonExterior(new Identifier(MOD_ID, "modernboxes"), MOD_ID, "policebox_flatline").register();
        POLICEBOXFLATLINE.setDoor(new AddonExterior.Door(POLICEBOXFLATLINE, true, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        POLICEBOXLUX = new AddonExterior(new Identifier(MOD_ID, "modernboxes"), MOD_ID, "policebox_lux").register();
        POLICEBOXLUX.setDoor(new AddonExterior.Door(POLICEBOXLUX, true, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        POLICEBOXCANDY = new AddonExterior(new Identifier(MOD_ID, "modernboxes"), MOD_ID, "policebox_candy").register();
        POLICEBOXCANDY.setDoor(new AddonExterior.Door(POLICEBOXCANDY, true, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        POLICEBOXGLASGLOW = new AddonExterior(new Identifier(MOD_ID, "modernboxes"), MOD_ID, "policebox_glasglow").register();
        POLICEBOXGLASGLOW.setDoor(new AddonExterior.Door(POLICEBOXGLASGLOW, true, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        POLICEBOXTEXTURE = new AddonExterior(new Identifier(MOD_ID, "modernboxes"), MOD_ID, "policebox_texture").register();
        POLICEBOXTEXTURE.setDoor(new AddonExterior.Door(POLICEBOXTEXTURE, true, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        TIMEPOD = new AddonExterior(new Identifier(MOD_ID, "ships"), MOD_ID, "timepod").register();
        TIMEPOD.setDoor(new AddonExterior.Door(TIMEPOD, false, SoundEvents.BLOCK_IRON_TRAPDOOR_OPEN, SoundEvents.BLOCK_IRON_TRAPDOOR_CLOSE)).toDoor().register();

        BEEHIVE = new AddonExterior(new Identifier(MOD_ID, "ships"), MOD_ID, "beehive").register();
        BEEHIVE.setDoor(new AddonExterior.Door(BEEHIVE, false, SoundEvents.BLOCK_BEEHIVE_ENTER, SoundEvents.BLOCK_BEEHIVE_EXIT)).toDoor().register();

        NEZUKO = new AddonExterior(new Identifier(MOD_ID, "ships"), MOD_ID, "nezuko").register();
        NEZUKO.setDoor(new AddonExterior.Door(NEZUKO, false, SoundEvents.BLOCK_WOODEN_DOOR_OPEN, SoundEvents.BLOCK_WOODEN_DOOR_CLOSE)).toDoor().register();

        GLASGLOW = new AddonExterior(new Identifier(MOD_ID, "classicboxes"), MOD_ID, "glasglow").register();
        GLASGLOW.setDoor(new AddonExterior.Door(GLASGLOW, true, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        LEGODIMALT = new AddonExterior(new Identifier(MOD_ID, "legoboxes"), MOD_ID, "lego_dimensions_police_box_alt").register();
        LEGODIMALT.setDoor(new AddonExterior.Door(LEGODIMALT, true, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        LEGODIMINVERTED = new AddonExterior(new Identifier(MOD_ID, "legoboxes"), MOD_ID, "inverted_lego_dimensions_police_box").register();
        LEGODIMINVERTED.setDoor(new AddonExterior.Door(LEGODIMINVERTED, true, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        BLUEBERRY = new AddonExterior(AWTExclusiveCategory.REFERENCE, MOD_ID, "blueberry").register();
        BLUEBERRY.setDoor(new AddonExterior.Door(BLUEBERRY, true, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        K2PHONEBOOTH = new AddonExterior(new Identifier(MOD_ID, "phonebooths"), MOD_ID, "k2phonebooth").register();
        K2PHONEBOOTH.setDoor(new AddonExterior.Door(K2PHONEBOOTH, false, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        K2PHONEBOOTHBATTERED = new AddonExterior(new Identifier(MOD_ID, "phonebooths"), MOD_ID, "k2phonebooth_battered").register();
        K2PHONEBOOTHBATTERED.setDoor(new AddonExterior.Door(K2PHONEBOOTHBATTERED, false, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        K2PHONEBOOTHBLUE = new AddonExterior(new Identifier(MOD_ID, "phonebooths"), MOD_ID, "k2phonebooth_blue").register();
        K2PHONEBOOTHBLUE.setDoor(new AddonExterior.Door(K2PHONEBOOTHBLUE, false, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        K2PHONEBOOTHGREY = new AddonExterior(new Identifier(MOD_ID, "phonebooths"), MOD_ID, "k2phonebooth_grey").register();
        K2PHONEBOOTHGREY.setDoor(new AddonExterior.Door(K2PHONEBOOTHGREY, false, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        K2PHONEBOOTHPINK = new AddonExterior(new Identifier(MOD_ID, "phonebooths"), MOD_ID, "k2phonebooth_pink").register();
        K2PHONEBOOTHPINK.setDoor(new AddonExterior.Door(K2PHONEBOOTHPINK, false, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        K2PHONEBOOTHGLOOM = new AddonExterior(new Identifier(MOD_ID, "phonebooths"), MOD_ID, "k2phonebooth_gloom").register();
        K2PHONEBOOTHGLOOM.setDoor(new AddonExterior.Door(K2PHONEBOOTHGLOOM, false, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        K2PHONEBOOTHGHOST = new AddonExterior(new Identifier(MOD_ID, "phonebooths"), MOD_ID, "k2phonebooth_ghost").register();
        K2PHONEBOOTHGHOST.setDoor(new AddonExterior.Door(K2PHONEBOOTHGHOST, false, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        K2PHONEBOOTHFUTURE = new AddonExterior(new Identifier(MOD_ID, "phonebooths"), MOD_ID, "k2phonebooth_futuristic").register();
        K2PHONEBOOTHFUTURE.setDoor(new AddonExterior.Door(K2PHONEBOOTHFUTURE, false, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        K6PHONEBOOTH = new AddonExterior(new Identifier(MOD_ID, "phonebooths"), MOD_ID, "k6phonebooth").register();
        K6PHONEBOOTH.setDoor(new AddonExterior.Door(K6PHONEBOOTH, false, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        K6PHONEBOOTHBATTERED = new AddonExterior(new Identifier(MOD_ID, "phonebooths"), MOD_ID, "k6phonebooth_battered").register();
        K6PHONEBOOTHBATTERED.setDoor(new AddonExterior.Door(K6PHONEBOOTHBATTERED, false, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        K6PHONEBOOTHGLOOM = new AddonExterior(new Identifier(MOD_ID, "phonebooths"), MOD_ID, "k6phonebooth_gloom").register();
        K6PHONEBOOTHGLOOM.setDoor(new AddonExterior.Door(K6PHONEBOOTHGLOOM, false, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        K6PHONEBOOTHFUTURE = new AddonExterior(new Identifier(MOD_ID, "phonebooths"), MOD_ID, "k6phonebooth_futuristic").register();
        K6PHONEBOOTHFUTURE.setDoor(new AddonExterior.Door(K6PHONEBOOTHFUTURE, false, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        K6PHONEBOOTHBEE = new AddonExterior(new Identifier(MOD_ID, "phonebooths"), MOD_ID, "k6phonebooth_bee").register();
        K6PHONEBOOTHBEE.setDoor(new AddonExterior.Door(K6PHONEBOOTHBEE, false, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        K6PHONEBOOTHGHOST = new AddonExterior(new Identifier(MOD_ID, "phonebooths"), MOD_ID, "k6phonebooth_ghost").register();
        K6PHONEBOOTHGHOST.setDoor(new AddonExterior.Door(K6PHONEBOOTHGHOST, false, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        POLICEBOXENC = new AddonExterior(AWTExclusiveCategory.REFERENCE, MOD_ID, "policebox_enc").register();
        POLICEBOXENC.setDoor(new AddonExterior.Door(POLICEBOXENC, true, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        SCARFO = new AddonExterior(AWTExclusiveCategory.REFERENCE, MOD_ID, "scorched_earth").register();
        SCARFO.setDoor(new AddonExterior.Door(SCARFO, true, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        LIGHT = new AddonExterior(AWTExclusiveCategory.REFERENCE, MOD_ID, "light_exterior").register();
        LIGHT.setDoor(new AddonExterior.Door(LIGHT, true, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

        BLUEBERRYGHOST = new AddonExterior(AWTExclusiveCategory.REFERENCE, MOD_ID, "blueberry_ghost").register();
        BLUEBERRYGHOST.setDoor(new AddonExterior.Door(BLUEBERRYGHOST, true, AWTSound.POLICEBOXDOOROPEN, AWTSound.POLICEBOXDOORCLOSED)).toDoor().register();

    }

    @Environment(EnvType.CLIENT)
    public static void registerClientAddonExteriors() {
        REDONION.setModel(new OnionExterior()).toClient().register();
        REDONION.toDoor().setModel(new OnionDoor(OnionDoor.getTexturedModelData().createModel())).toClient().register();
        REDONION.setSonicItemTranslations(new Vector3f(0.15f, 1.122f, 0.94f));

        YELLOWONION.setModel(new OnionExterior()).toClient().register();
        YELLOWONION.toDoor().setModel(new OnionDoor(OnionDoor.getTexturedModelData().createModel())).toClient().register();
        YELLOWONION.setSonicItemTranslations(new Vector3f(0.15f, 1.122f, 0.94f));

        BLUEONION.setModel(new OnionExterior()).toClient().register();
        BLUEONION.toDoor().setModel(new OnionDoor(OnionDoor.getTexturedModelData().createModel())).toClient().register();
        BLUEONION.setSonicItemTranslations(new Vector3f(0.15f, 1.122f, 0.94f));

        WHITEONION.setModel(new OnionExterior()).toClient().register();
        WHITEONION.toDoor().setModel(new OnionDoor(OnionDoor.getTexturedModelData().createModel())).toClient().register();
        WHITEONION.setSonicItemTranslations(new Vector3f(0.15f, 1.122f, 0.94f));

        PURPLEONION.setModel(new OnionExterior()).toClient().register();
        PURPLEONION.toDoor().setModel(new OnionDoor(OnionDoor.getTexturedModelData().createModel())).toClient().register();
        PURPLEONION.setSonicItemTranslations(new Vector3f(0.15f, 1.122f, 0.94f));

        GREYONION.setModel(new OnionExterior()).toClient().register();
        GREYONION.toDoor().setModel(new OnionDoor(OnionDoor.getTexturedModelData().createModel())).toClient().register();
        GREYONION.setSonicItemTranslations(new Vector3f(0.15f, 1.122f, 0.94f));

        PINKONION.setModel(new OnionExterior()).toClient().register();
        PINKONION.toDoor().setModel(new OnionDoor(OnionDoor.getTexturedModelData().createModel())).toClient().register();
        PINKONION.setSonicItemTranslations(new Vector3f(0.15f, 1.122f, 0.94f));

        LIGHTBLUEONION.setModel(new OnionExterior()).toClient().register();
        LIGHTBLUEONION.toDoor().setModel(new OnionDoor(OnionDoor.getTexturedModelData().createModel())).toClient().register();
        LIGHTBLUEONION.setSonicItemTranslations(new Vector3f(0.15f, 1.122f, 0.94f));

        LIMEGREENONION.setModel(new OnionExterior()).toClient().register();
        LIMEGREENONION.toDoor().setModel(new OnionDoor(OnionDoor.getTexturedModelData().createModel())).toClient().register();
        LIMEGREENONION.setSonicItemTranslations(new Vector3f(0.15f, 1.122f, 0.94f));

        POLICEBOX.setModel(new policebox()).toClient().register();
        POLICEBOX.toDoor().setModel(new policeboxdoor(policeboxdoor.getTexturedModelData().createModel())).toClient().register();
        POLICEBOX.setSonicItemTranslations(new Vector3f(0, 0, 0));

        TYPE70.setModel(new Type70Exterior()).toClient().register();
        TYPE70.toDoor().setModel(new Type70Door(Type70Door.getTexturedModelData().createModel())).toClient().register();
        TYPE70.setPortalWidth(1f);
        TYPE70.setPortalHeight(2f);
        TYPE70.setSonicItemTranslations(new Vector3f(0, 0, 0));

        TYPE70WG.setModel(new Type70Exterior()).toClient().register();
        TYPE70WG.toDoor().setModel(new Type70Door(Type70Door.getTexturedModelData().createModel())).toClient().register();
        TYPE70WG.setPortalWidth(1f);
        TYPE70WG.setPortalHeight(2f);
        TYPE70WG.setSonicItemTranslations(new Vector3f(0, 0, 0));

        TYPE70ALT.setModel(new Type70Exterior()).toClient().register();
        TYPE70ALT.toDoor().setModel(new Type70Door(Type70Door.getTexturedModelData().createModel())).toClient().register();
        TYPE70ALT.setPortalWidth(1f);
        TYPE70ALT.setPortalHeight(2f);
        TYPE70ALT.setSonicItemTranslations(new Vector3f(0, 0, 0));

        BLOCKTIS.setModel(new BlocktisExterior()).toClient().register();
        BLOCKTIS.toDoor().setModel(new BlocktisDoor(BlocktisDoor.getTexturedModelData().createModel())).toClient().register();
        BLOCKTIS.setPortalWidth(0.75f);
        BLOCKTIS.setPortalHeight(1.75f);
        BLOCKTIS.setSonicItemTranslations(new Vector3f(0, 0, 0));

        BLOCKTISV2.setModel(new BlocktisV2Exterior()).toClient().register();
        BLOCKTISV2.toDoor().setModel(new BlocktisV2Door(BlocktisV2Door.getTexturedModelData().createModel())).toClient().register();
        BLOCKTISV2.setPortalWidth(0.75f);
        BLOCKTISV2.setPortalHeight(1.75f);
        BLOCKTISV2.setSonicItemTranslations(new Vector3f(0, 0, 0));

        BLOCKTISBNW.setModel(new BlocktisV2Exterior()).toClient().register();
        BLOCKTISBNW.toDoor().setModel(new BlocktisV2Door(BlocktisV2Door.getTexturedModelData().createModel())).toClient().register();
        BLOCKTISBNW.setPortalWidth(0.75f);
        BLOCKTISBNW.setPortalHeight(1.75f);
        BLOCKTISBNW.setSonicItemTranslations(new Vector3f(0, 0, 0));

        BLOCKTISV3.setModel(new BlocktisV2Exterior()).toClient().register();
        BLOCKTISV3.toDoor().setModel(new BlocktisV2Door(BlocktisV2Door.getTexturedModelData().createModel())).toClient().register();
        BLOCKTISV3.setPortalWidth(0.75f);
        BLOCKTISV3.setPortalHeight(1.75f);
        BLOCKTISV3.setSonicItemTranslations(new Vector3f(0, 0, 0));

        RHAMNOUSVANILLA.setModel(new RhamnousVanilla()).toClient().register();
        RHAMNOUSVANILLA.toDoor().setModel(new RhamnousVanillaDoor(RhamnousVanillaDoor.getTexturedModelData().createModel())).toClient().register();
        RHAMNOUSVANILLA.setPortalWidth(0.75f);
        RHAMNOUSVANILLA.setPortalHeight(1.75f);
        RHAMNOUSVANILLA.setSonicItemTranslations(new Vector3f(0, 0, 0));

        GAMBLEBLOCKTIS.setModel(new gambleblocktis()).toClient().register();
        GAMBLEBLOCKTIS.toDoor().setModel(new RhamnousVanillaDoor(RhamnousVanillaDoor.getTexturedModelData().createModel())).toClient().register();
        GAMBLEBLOCKTIS.setPortalWidth(0.75f);
        GAMBLEBLOCKTIS.setPortalHeight(1.75f);
        GAMBLEBLOCKTIS.setSonicItemTranslations(new Vector3f(0, 0, 0));

        GLASGLOWVANILLA.setModel(new BlocktisV2Exterior()).toClient().register();
        GLASGLOWVANILLA.toDoor().setModel(new BlocktisV2Door(BlocktisV2Door.getTexturedModelData().createModel())).toClient().register();
        GLASGLOWVANILLA.setPortalWidth(0.75f);
        GLASGLOWVANILLA.setPortalHeight(1.75f);
        GLASGLOWVANILLA.setSonicItemTranslations(new Vector3f(0, 0, 0));

        LEGO.setModel(new logo_tardis_model()).toClient().register();
        LEGO.toDoor().setModel(new logo_tardis_model_door(logo_tardis_model_door.getTexturedModelData().createModel())).toClient().register();
        LEGO.setPortalWidth(1f);
        LEGO.setPortalHeight(2f);
        LEGO.setSonicItemTranslations(new Vector3f(0, 0, 0));

        LEGO2.setModel(new logo_tardis_model()).toClient().register();
        LEGO2.toDoor().setModel(new logo_tardis_model_door(logo_tardis_model_door.getTexturedModelData().createModel())).toClient().register();
        LEGO2.setPortalWidth(1f);
        LEGO2.setPortalHeight(2f);
        LEGO2.setSonicItemTranslations(new Vector3f(0, 0, 0));

        LEGO3.setModel(new logo_tardis_model()).toClient().register();
        LEGO3.toDoor().setModel(new logo_tardis_model_door(logo_tardis_model_door.getTexturedModelData().createModel())).toClient().register();
        LEGO3.setPortalWidth(1f);
        LEGO3.setPortalHeight(2f);
        LEGO3.setSonicItemTranslations(new Vector3f(0, 0, 0));

        LEGODIM.setModel(new lego_tardis_model()).toClient().register();
        LEGODIM.toDoor().setModel(new lego_tardis_model_door(lego_tardis_model_door.getTexturedModelData().createModel())).toClient().register();
        LEGODIM.setPortalWidth(0.90f);
        LEGODIM.setPortalHeight(1.5f);
        LEGODIM.setSonicItemTranslations(new Vector3f(0, 0, 0));

        POLICEBOXALT.setModel(new policebox()).toClient().register();
        POLICEBOXALT.toDoor().setModel(new policeboxdoor(policeboxdoor.getTexturedModelData().createModel())).toClient().register();
        POLICEBOXALT.setSonicItemTranslations(new Vector3f(0, 0, 0));

        POLICEBOXPURPLE.setModel(new policebox()).toClient().register();
        POLICEBOXPURPLE.toDoor().setModel(new policeboxdoor(policeboxdoor.getTexturedModelData().createModel())).toClient().register();
        POLICEBOXPURPLE.setSonicItemTranslations(new Vector3f(0, 0, 0));

        JAKE.setModel(new JakeTheDogExteriorModel(JakeTheDogExteriorModel.getTexturedModelData().createModel())).toClient().register();
        JAKE.toDoor().setModel(new awtjakemouth(awtjakemouth.getTexturedModelData().createModel())).toClient().register();

        LEFTHOTTUB.setModel(new lefthottub()).toClient().register();
        LEFTHOTTUB.toDoor().setModel(new lefthottubdoor(lefthottubdoor.getTexturedModelData().createModel())).toClient().register();
        LEFTHOTTUB.setSonicItemTranslations(new Vector3f(0, 0, 0));

        POLICEBOXCORAL.setModel(new policebox()).toClient().register();
        POLICEBOXCORAL.toDoor().setModel(new policeboxdoor(policeboxdoor.getTexturedModelData().createModel())).toClient().register();
        POLICEBOXCORAL.setSonicItemTranslations(new Vector3f(0, 0, 0));

        POLICEBOXBADWOLF.setModel(new policebox()).toClient().register();
        POLICEBOXBADWOLF.toDoor().setModel(new policeboxdoor(policeboxdoor.getTexturedModelData().createModel())).toClient().register();
        POLICEBOXBADWOLF.setSonicItemTranslations(new Vector3f(0, 0, 0));

        POLICEBOXBADGHOST.setModel(new policebox()).toClient().register();
        POLICEBOXBADGHOST.toDoor().setModel(new policeboxdoor(policeboxdoor.getTexturedModelData().createModel())).toClient().register();
        POLICEBOXBADGHOST.setSonicItemTranslations(new Vector3f(0, 0, 0));

        GAMBLEBOX.setModel(new policebox()).toClient().register();
        GAMBLEBOX.toDoor().setModel(new policeboxdoor(policeboxdoor.getTexturedModelData().createModel())).toClient().register();
        GAMBLEBOX.setSonicItemTranslations(new Vector3f(0, 0, 0));

        POLICEBOXTOKOMAK.setModel(new policebox()).toClient().register();
        POLICEBOXTOKOMAK.toDoor().setModel(new policeboxdoor(policeboxdoor.getTexturedModelData().createModel())).toClient().register();
        POLICEBOXTOKOMAK.setSonicItemTranslations(new Vector3f(0, 0, 0));

        POLICEBOXALT2.setModel(new policebox()).toClient().register();
        POLICEBOXALT2.toDoor().setModel(new policeboxdoor(policeboxdoor.getTexturedModelData().createModel())).toClient().register();
        POLICEBOXALT2.setSonicItemTranslations(new Vector3f(0, 0, 0));

        POLICEBOXRHAMNOUS.setModel(new policebox()).toClient().register();
        POLICEBOXRHAMNOUS.toDoor().setModel(new policeboxdoor(policeboxdoor.getTexturedModelData().createModel())).toClient().register();
        //POLICEBOXRHAMNOUS.setPortalWidth(1f);
        //POLICEBOXRHAMNOUS.setPortalHeight(2f);
        // POLICEBOXRHAMNOUS.setPortalTranslations(BiFunction<Vector3d,Byte,Vector3d>);
        POLICEBOXRHAMNOUS.setSonicItemTranslations(new Vector3f(0, 0, 0));

        POLICEBOXNATHAN.setModel(new policebox()).toClient().register();
        POLICEBOXNATHAN.toDoor().setModel(new policeboxdoor(policeboxdoor.getTexturedModelData().createModel())).toClient().register();
        POLICEBOXNATHAN.setSonicItemTranslations(new Vector3f(0, 0, 0));

        POLICEBOXDINO.setModel(new policebox()).toClient().register();
        POLICEBOXDINO.toDoor().setModel(new policeboxdoor(policeboxdoor.getTexturedModelData().createModel())).toClient().register();
        POLICEBOXDINO.setSonicItemTranslations(new Vector3f(0, 0, 0));

        POLICEBOXFLATLINE.setModel(new flatline_policebox()).toClient().register();
        POLICEBOXFLATLINE.toDoor().setModel(new flatline_policebox_door(flatline_policebox_door.getTexturedModelData().createModel())).toClient().register();
        POLICEBOXFLATLINE.setSonicItemTranslations(new Vector3f(0, 0, 0));

        POLICEBOXLUX.setModel(new policebox()).toClient().register();
        POLICEBOXLUX.toDoor().setModel(new policeboxdoor(policeboxdoor.getTexturedModelData().createModel())).toClient().register();
        POLICEBOXLUX.setSonicItemTranslations(new Vector3f(0, 0, 0));

        POLICEBOXCANDY.setModel(new policebox()).toClient().register();
        POLICEBOXCANDY.toDoor().setModel(new policeboxdoor(policeboxdoor.getTexturedModelData().createModel())).toClient().register();
        POLICEBOXCANDY.setSonicItemTranslations(new Vector3f(0, 0, 0));

        POLICEBOXGLASGLOW.setModel(new policebox()).toClient().register();
        POLICEBOXGLASGLOW.toDoor().setModel(new policeboxdoor(policeboxdoor.getTexturedModelData().createModel())).toClient().register();
        POLICEBOXGLASGLOW.setSonicItemTranslations(new Vector3f(0, 0, 0));

        POLICEBOXORANGE.setModel(new policebox()).toClient().register();
        POLICEBOXORANGE.toDoor().setModel(new policeboxdoor(policeboxdoor.getTexturedModelData().createModel())).toClient().register();
        POLICEBOXORANGE.setSonicItemTranslations(new Vector3f(0, 0, 0));

        POLICEBOXENC.setModel(new policebox()).toClient().register();
        POLICEBOXENC.toDoor().setModel(new policeboxdoor(policeboxdoor.getTexturedModelData().createModel())).toClient().register();
        POLICEBOXENC.setSonicItemTranslations(new Vector3f(0, 0, 0));

        TIMEPOD.setModel(new timepod(timepod.getTexturedModelData().createModel())).toClient().register();
        TIMEPOD.toDoor().setModel(new timepoddoor(timepoddoor.getTexturedModelData().createModel())).toClient().register();

        BEEHIVE.setModel(new beehive()).toClient().register();
        BEEHIVE.toDoor().setModel(new beehivedoor(beehivedoor.getTexturedModelData().createModel())).toClient().register();
        BEEHIVE.setSonicItemTranslations(new Vector3f(0, 0, 0));

        NEZUKO.setModel(new neziko()).toClient().register();
        NEZUKO.toDoor().setModel(new nezikodoor(nezikodoor.getTexturedModelData().createModel())).toClient().register();
        NEZUKO.setSonicItemTranslations(new Vector3f(0, 0, 0));

        GLASGLOW.setModel(new Glasgow()).toClient().register();
        GLASGLOW.toDoor().setModel(new GlasgowDoor(GlasgowDoor.getTexturedModelData().createModel())).toClient().register();
        GLASGLOW.setSonicItemTranslations(new Vector3f(0, 0, 0));

        POLICEBOXTEXTURE.setModel(new policebox()).toClient().register();
        POLICEBOXTEXTURE.toDoor().setModel(new policeboxdoor(policeboxdoor.getTexturedModelData().createModel())).toClient().register();
        POLICEBOXTEXTURE.setSonicItemTranslations(new Vector3f(0, 0, 0));

        LEGODIMALT.setModel(new lego_tardis_model()).toClient().register();
        LEGODIMALT.toDoor().setModel(new lego_tardis_model_door(lego_tardis_model_door.getTexturedModelData().createModel())).toClient().register();
        LEGODIMALT.setPortalWidth(0.90f);
        LEGODIMALT.setPortalHeight(1.5f);
        LEGODIMALT.setSonicItemTranslations(new Vector3f(0, 0, 0));

        LEGODIMINVERTED.setModel(new lego_tardis_model()).toClient().register();
        LEGODIMINVERTED.toDoor().setModel(new lego_tardis_model_door(lego_tardis_model_door.getTexturedModelData().createModel())).toClient().register();
        LEGODIMINVERTED.setPortalWidth(0.90f);
        LEGODIMINVERTED.setPortalHeight(1.5f);
        LEGODIMINVERTED.setSonicItemTranslations(new Vector3f(0, 0, 0));

        BLUEBERRY.setModel(new blueberry()).toClient().register();
        BLUEBERRY.toDoor().setModel(new blueberry_door(blueberry_door.getTexturedModelData().createModel())).toClient().register();
        BLUEBERRY.setSonicItemTranslations(new Vector3f(0, 0, 0));

        K2PHONEBOOTH.setModel(new k2phonebooth()).toClient().register();
        K2PHONEBOOTH.toDoor().setModel(new k2phonebooth_door(k2phonebooth_door.getTexturedModelData().createModel())).toClient().register();
        K2PHONEBOOTH.setSonicItemTranslations(new Vector3f(0, 0, 0));

        K2PHONEBOOTHBATTERED.setModel(new k2phonebooth()).toClient().register();
        K2PHONEBOOTHBATTERED.toDoor().setModel(new k2phonebooth_door(k2phonebooth_door.getTexturedModelData().createModel())).toClient().register();
        K2PHONEBOOTHBATTERED.setSonicItemTranslations(new Vector3f(0, 0, 0));

        K2PHONEBOOTHBLUE.setModel(new k2phonebooth()).toClient().register();
        K2PHONEBOOTHBLUE.toDoor().setModel(new k2phonebooth_door(k2phonebooth_door.getTexturedModelData().createModel())).toClient().register();
        K2PHONEBOOTHBLUE.setSonicItemTranslations(new Vector3f(0, 0, 0));

        K2PHONEBOOTHGREY.setModel(new k2phonebooth()).toClient().register();
        K2PHONEBOOTHGREY.toDoor().setModel(new k2phonebooth_door(k2phonebooth_door.getTexturedModelData().createModel())).toClient().register();
        K2PHONEBOOTHGREY.setSonicItemTranslations(new Vector3f(0, 0, 0));

        K2PHONEBOOTHPINK.setModel(new k2phonebooth()).toClient().register();
        K2PHONEBOOTHPINK.toDoor().setModel(new k2phonebooth_door(k2phonebooth_door.getTexturedModelData().createModel())).toClient().register();
        K2PHONEBOOTHPINK.setSonicItemTranslations(new Vector3f(0, 0, 0));

        K2PHONEBOOTHGHOST.setModel(new k2phonebooth()).toClient().register();
        K2PHONEBOOTHGHOST.toDoor().setModel(new k2phonebooth_door(k2phonebooth_door.getTexturedModelData().createModel())).toClient().register();
        K2PHONEBOOTHGHOST.setSonicItemTranslations(new Vector3f(0, 0, 0));

        K2PHONEBOOTHGLOOM.setModel(new k2phonebooth()).toClient().register();
        K2PHONEBOOTHGLOOM.toDoor().setModel(new k2phonebooth_door(k2phonebooth_door.getTexturedModelData().createModel())).toClient().register();
        K2PHONEBOOTHGLOOM.setSonicItemTranslations(new Vector3f(0, 0, 0));

        K2PHONEBOOTHFUTURE.setModel(new k2phonebooth()).toClient().register();
        K2PHONEBOOTHFUTURE.toDoor().setModel(new k2phonebooth_door(k2phonebooth_door.getTexturedModelData().createModel())).toClient().register();
        K2PHONEBOOTHFUTURE.setSonicItemTranslations(new Vector3f(0, 0, 0));

        K6PHONEBOOTH.setModel(new k2phonebooth()).toClient().register();
        K6PHONEBOOTH.toDoor().setModel(new k2phonebooth_door(k2phonebooth_door.getTexturedModelData().createModel())).toClient().register();
        K6PHONEBOOTH.setSonicItemTranslations(new Vector3f(0, 0, 0));

        K6PHONEBOOTHBATTERED.setModel(new k2phonebooth()).toClient().register();
        K6PHONEBOOTHBATTERED.toDoor().setModel(new k2phonebooth_door(k2phonebooth_door.getTexturedModelData().createModel())).toClient().register();
        K6PHONEBOOTHBATTERED.setSonicItemTranslations(new Vector3f(0, 0, 0));

        K6PHONEBOOTHGLOOM.setModel(new k2phonebooth()).toClient().register();
        K6PHONEBOOTHGLOOM.toDoor().setModel(new k2phonebooth_door(k2phonebooth_door.getTexturedModelData().createModel())).toClient().register();
        K6PHONEBOOTHGLOOM.setSonicItemTranslations(new Vector3f(0, 0, 0));

        K6PHONEBOOTHFUTURE.setModel(new k2phonebooth()).toClient().register();
        K6PHONEBOOTHFUTURE.toDoor().setModel(new k2phonebooth_door(k2phonebooth_door.getTexturedModelData().createModel())).toClient().register();
        K6PHONEBOOTHFUTURE.setSonicItemTranslations(new Vector3f(0, 0, 0));

        K6PHONEBOOTHBEE.setModel(new k2phonebooth()).toClient().register();
        K6PHONEBOOTHBEE.toDoor().setModel(new k2phonebooth_door(k2phonebooth_door.getTexturedModelData().createModel())).toClient().register();
        K6PHONEBOOTHBEE.setSonicItemTranslations(new Vector3f(0, 0, 0));

        K6PHONEBOOTHGHOST.setModel(new k2phonebooth()).toClient().register();
        K6PHONEBOOTHGHOST.toDoor().setModel(new k2phonebooth_door(k2phonebooth_door.getTexturedModelData().createModel())).toClient().register();
        K6PHONEBOOTHGHOST.setSonicItemTranslations(new Vector3f(0, 0, 0));

        SCARFO.setModel(new scarfs()).toClient().register();
        SCARFO.toDoor().setModel(new scarfs_door(scarfs_door.getTexturedModelData().createModel())).toClient().register();
        SCARFO.setSonicItemTranslations(new Vector3f(0, 0, 0));

        LIGHT.setModel(new lights()).toClient().register();
        LIGHT.toDoor().setModel(new lights_door(lights_door.getTexturedModelData().createModel())).toClient().register();
        LIGHT.setSonicItemTranslations(new Vector3f(0, 0, 0));

        BLUEBERRYGHOST.setModel(new blueberry()).toClient().register();
        BLUEBERRYGHOST.toDoor().setModel(new blueberry_door(blueberry_door.getTexturedModelData().createModel())).toClient().register();
        BLUEBERRYGHOST.setSonicItemTranslations(new Vector3f(0, 0, 0));
    }
}
