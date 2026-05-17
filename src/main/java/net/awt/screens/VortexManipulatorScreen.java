package net.awt.screens;

import net.awt.AdventuresWithTARDISes;
import net.awt.networking.ModPackets;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.widget.ToggleButtonWidget;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class VortexManipulatorScreen extends Screen {
    private static final int GUI_WIDTH = 250;
    private static final int GUI_HEIGHT = 250;
    private static final float GUI_SCALE_X = GUI_WIDTH / 64.0f;
    private static final float GUI_SCALE_Y = GUI_HEIGHT / 64.0f;

    public VortexManipulatorScreen() {
        super(Text.literal("Vortex Manipulator"));
    }

    public ButtonWidget teleport;
    public TextFieldWidget dimension;
    public TextFieldWidget x;
    public TextFieldWidget y;
    public TextFieldWidget z;
    public ToggleButtonWidget surface;
    private int left;
    private int top;

    @Override
    protected void init() {
        left = (width - GUI_WIDTH) / 2;
        top = (height - GUI_HEIGHT) / 2;

        teleport = ButtonWidget.builder(Text.empty(), button -> {
                    ClientPlayNetworking.send(ModPackets.VM_PACKET, new PacketByteBuf(PacketByteBufs.create()
                            .writeString(dimension.getText())
                            .writeDouble(getValue(x.getText(), client.player.getX()))
                            .writeDouble(getValue(y.getText(), client.player.getY()))
                            .writeDouble(getValue(z.getText(), client.player.getZ()))

                    ));
                    client.setScreen(null);
        })
                .dimensions(guiX(14), guiY(40), guiWidth(10), guiHeight(10))
                .build();
        teleport.setMessage(Text.empty());

        dimension = createTextField(guiX(9), guiY(22), guiWidth(20), guiHeight(5), Text.literal("meow"));
        x = createTextField(guiX(45), guiY(19), guiWidth(12), guiHeight(3), Text.literal("x"));
        y = createTextField(guiX(45), guiY(28), guiWidth(12), guiHeight(3), Text.literal("y"));
        z = createTextField(guiX(45), guiY(38), guiWidth(12), guiHeight(3), Text.literal("z"));

        surface = new ToggleButtonWidget(guiX(55), guiY(41), guiWidth(5), guiHeight(5), false);

        addSelectableChild(teleport);
        addDrawableChild(dimension);
        addDrawableChild(x);
        addDrawableChild(y);
        addDrawableChild(z);
        //addDrawable(surface); this crashes the game for some reason


    }

    private int guiX(int sourceX) {
        return left + Math.round(sourceX * GUI_SCALE_X);
    }

    private int guiY(int sourceY) {
        return top + Math.round(sourceY * GUI_SCALE_Y);
    }

    private int guiWidth(int sourceWidth) {
        return Math.round(sourceWidth * GUI_SCALE_X);
    }

    private int guiHeight(int sourceHeight) {
        return Math.round(sourceHeight * GUI_SCALE_Y);
    }

    private TextFieldWidget createTextField(int x, int y, int width, int height, Text message) {
        TextFieldWidget field = new TextFieldWidget(textRenderer, x, y, width, height, message);
        field.setDrawsBackground(false);
        field.setEditableColor(0xFFFFFF);
        field.setUneditableColor(0xFFFFFF);
        return field;
    }

    private double getValue(String text, double defaultValue) {
        if (text == null || text.trim().isEmpty()) return defaultValue;
        try {
            return Double.parseDouble(text.trim());
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        context.drawTexture(new Identifier(AdventuresWithTARDISes.MOD_ID, "textures/img.png"), left, top, 0, 0, GUI_WIDTH, GUI_HEIGHT);
        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
