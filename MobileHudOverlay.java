package com.corz.ui;

import com.corz.manager.ThemeManager;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public class MobileHudOverlay implements HudRenderCallback {
    private static boolean visible = true;
    public static void toggleVisibility() { visible = !visible; }

    @Override
    public void onHudRender(DrawContext context, float tickDelta) {
        if (!visible) return;
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.options.hudHidden) return;

        int screenWidth = client.getWindow().getScaledWidth();
        int btnX = screenWidth - 75;
        int btnY = 10;
        int accent = ThemeManager.getAccentColor();

        context.fill(btnX, btnY, btnX + 65, btnY + 24, 0xAA12141C);
        context.drawBorder(btnX, btnY, 65, 24, accent);
        context.drawText(client.textRenderer, "CORZ GUI", btnX + 8, btnY + 8, accent, true);
    }
}
