package net.awt.mixin.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.LogoDrawer;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.time.LocalDate;
import java.time.Month;
import java.util.Random;

@Mixin(LogoDrawer.class)
public class LogoDrawerMixin {

    private static final Identifier AWT_LOGO = new Identifier("awt", "textures/gui/title/awt_logo_2026.png");
    private static final Identifier AWT_LOGO_XMAS = new Identifier("awt", "textures/gui/title/awt_christmas_logo.png");
    private static final Identifier AWT_MINCERAFT_LOGO = new Identifier("awt", "textures/gui/title/awt_minceraft_logo.png");
    private static final Identifier AWT_LOGO_LEBRON = new Identifier("awt", "textures/gui/title/awt_lebron_logo.png");
    private static final Identifier AWT_LOGO_HALLOWEEN = new Identifier("awt", "textures/gui/title/awt_halloween_logo.png");
    private static final Identifier AWT_LOGO_CLASSIC = new Identifier("awt","textures/gui/title/awt_logo.png");
    private static final Identifier AWT_BLUESDAY = new Identifier("awt","textures/gui/title/awt_bluesday.png");
    private static final Identifier AWT_DEOSDAY = new Identifier("awt","textures/gui/title/awt_deosday.png");

    @Unique
    private static final boolean IS_MINCERAFT = new Random().nextInt(1000) == 0; // 0.1% chance

    @Inject(method = "draw*", at = @At("HEAD"), cancellable = true)
    private void injectCustomLogo(DrawContext context, int screenWidth, float alpha, CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();

        Identifier logo;
        if (isDeosday()) {
            logo = AWT_DEOSDAY;
        } else if (isBluesday()) {
            logo = AWT_BLUESDAY;
        } else if (IS_MINCERAFT) {
            logo = AWT_MINCERAFT_LOGO;
        } else if (isChristmas()) {
            logo = AWT_LOGO_XMAS;
        } else if (isHalloween()) {
            logo = AWT_LOGO_HALLOWEEN;
        } else if (isLebron()) {
            logo = AWT_LOGO_LEBRON;
        } else if (isClassic()) {
            logo = AWT_LOGO_CLASSIC;
        } else {
            logo = AWT_LOGO;
        }


        int logoWidth = 400;
        int logoHeight = 90;

        int centerX = (screenWidth - logoWidth) / 2;
        int logoY = 12; // Adjust vertical position

        RenderSystem.enableBlend();
        context.drawTexture(logo, centerX, logoY, 0.0f, 0.0f, logoWidth, logoHeight, logoWidth, logoHeight);

        ci.cancel(); // prevent other logo logic
    }

    @Unique
    private boolean isChristmas() {
        LocalDate date = LocalDate.now();
        return date.getMonth() == Month.DECEMBER;
    }

    @Unique
    private boolean isLebron() {
        LocalDate date = LocalDate.now();
        return date.getMonth() == Month.DECEMBER && date.getDayOfMonth() == 30;
    }

    @Unique
    private boolean isHalloween() {
        LocalDate date = LocalDate.now();
        return date.getMonth() == Month.OCTOBER && date.getDayOfMonth() == 31;
    }

    @Unique
    private boolean isClassic() {
        LocalDate date = LocalDate.now();
        return date.getMonth() == Month.JULY && date.getDayOfMonth() == 15;
    }

    @Unique
    private boolean isBluesday() {
        LocalDate date = LocalDate.now();
        return date.getMonth() == Month.OCTOBER && date.getDayOfMonth() == 15;
    }

    @Unique
    private boolean isDeosday() {
        LocalDate date = LocalDate.now();
        return date.getMonth() == Month.JUNE && date.getDayOfMonth() == 10;
    }
}