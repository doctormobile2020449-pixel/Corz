package com.corz.ui;

import com.corz.bots.AbstractBot;
import com.corz.manager.*;
import com.corz.modules.Module;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.text.Text;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class CorzDashboardScreen extends Screen {
    private String activeCategory = "Combat";
    private final List<String> categories = List.of("Combat", "DonutSMP", "Visuals", "Bots");
    private final List<String> generalOptions = List.of("Settings", "Theme", "Waypoints", "Friends", "Macros");

    public CorzDashboardScreen() {
        super(Text.literal("Corz Dashboard v2.4 Video Accurate Edition"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);

        int screenWidth = this.width;
        int screenHeight = this.height;
        int panelWidth = Math.min(880, screenWidth - 20);
        int panelHeight = Math.min(560, screenHeight - 20);
        int panelX = (screenWidth - panelWidth) / 2;
        int panelY = (screenHeight - panelHeight) / 2;
        int accent = ThemeManager.getAccentColor();

        // Main Panel background
        context.fill(panelX, panelY, panelX + panelWidth, panelY + panelHeight, 0xFF12141C);
        context.drawBorder(panelX, panelY, panelWidth, panelHeight, 0xFF2A2E3D);

        // Sidebar background
        context.fill(panelX, panelY, panelX + 175, panelY + panelHeight, 0xFF0D0F14);

        // Logo & Version
        context.drawText(this.textRenderer, "C CORZ", panelX + 16, panelY + 16, accent, true);
        context.drawText(this.textRenderer, "v2.4", panelX + 68, panelY + 20, 0xFF7A7F8E, false);

        // Categories
        context.drawText(this.textRenderer, "MODULES", panelX + 16, panelY + 45, 0xFF5A5F6E, false);
        int currentY = panelY + 62;
        for (String cat : categories) {
            boolean selected = activeCategory.equals(cat);
            if (selected) context.fill(panelX + 12, currentY - 2, panelX + 163, currentY + 18, 0x33FF5500);
            context.drawText(this.textRenderer, cat, panelX + 22, currentY + 3, selected ? accent : 0xFFB0B5C0, false);
            currentY += 22;
        }

        // General
        context.drawText(this.textRenderer, "GENERAL", panelX + 16, currentY + 6, 0xFF5A5F6E, false);
        currentY += 24;
        for (String gen : generalOptions) {
            boolean selected = activeCategory.equals(gen);
            if (selected) context.fill(panelX + 12, currentY - 2, panelX + 163, currentY + 18, 0x33FF5500);
            context.drawText(this.textRenderer, gen, panelX + 22, currentY + 3, selected ? accent : 0xFFB0B5C0, false);
            currentY += 22;
        }

        // Profile Card at bottom left
        context.fill(panelX + 12, panelY + panelHeight - 48, panelX + 163, panelY + panelHeight - 12, 0xFF1A1D26);
        context.drawText(this.textRenderer, "You", panelX + 22, panelY + panelHeight - 40, 0xFFFFFFFF, true);
        context.drawText(this.textRenderer, "OwnedByM4", panelX + 22, panelY + panelHeight - 26, 0xFF00FF55, false);

        // Header (Greeting, Clock, Search)
        context.drawText(this.textRenderer, "Hello, You (v1.21.11 Ready)", panelX + 195, panelY + 18, 0xFFE0E5EF, false);
        String timeStr = new SimpleDateFormat("HH:mm").format(new Date());
        context.drawText(this.textRenderer, timeStr, panelX + 400, panelY + 18, accent, true);

        int searchX = panelX + 500;
        int searchY = panelY + 12;
        context.fill(searchX, searchY, searchX + 350, searchY + 26, 0xFF1A1D26);
        context.drawText(this.textRenderer, "🔍 Search 100+ modules, 9 bots...", searchX + 8, searchY + 8, 0xFF6A6F7E, false);

        // Content Viewport routing
        if (activeCategory.equals("Bots")) {
            renderBotView(context, panelX + 185, panelY + 50, panelWidth - 185, panelHeight - 50, mouseX, mouseY);
        } else if (activeCategory.equals("Theme")) {
            renderThemeView(context, panelX + 185, panelY + 50, panelWidth - 185, panelHeight - 50);
        } else if (activeCategory.equals("Waypoints")) {
            renderWaypointView(context, panelX + 185, panelY + 50, panelWidth - 185, panelHeight - 50);
        } else if (activeCategory.equals("Friends")) {
            renderFriendView(context, panelX + 185, panelY + 50, panelWidth - 185, panelHeight - 50);
        } else if (activeCategory.equals("Macros")) {
            renderMacroView(context, panelX + 185, panelY + 50, panelWidth - 185, panelHeight - 50);
        } else {
            renderModuleGrid(context, panelX + 185, panelY + 50, panelWidth - 185, panelHeight - 50, activeCategory);
        }

        super.render(context, mouseX, mouseY, delta);
    }

    private void renderModuleGrid(DrawContext context, int x, int y, int width, int height, String category) {
        String subtitle = category.equals("Combat") ? "(24 Modules)" : category.equals("DonutSMP") ? "(27 Modules)" : "(69 Modules)";
        context.drawText(this.textRenderer, category.toUpperCase() + " " + subtitle, x + 16, y + 16, 0xFFFFFFFF, true);

        List<Module> mods = ModuleManager.getModulesByCategory(category);
        int cardWidth = 320;
        int cardHeight = 40;
        int startX = x + 16;
        int startY = y + 36;

        int index = 0;
        for (Module mod : mods) {
            int col = index % 2;
            int row = index / 2;
            int cX = startX + col * (cardWidth + 12);
            int cY = startY + row * (cardHeight + 8);

            if (cY + cardHeight > y + height - 10) break;

            context.fill(cX, cY, cX + cardWidth, cY + cardHeight, 0xFF161920);
            context.drawText(this.textRenderer, mod.getName() + " ⓘ", cX + 10, cY + 6, 0xFFFFFFFF, false);
            context.drawText(this.textRenderer, mod.getDescription(), cX + 10, cY + 22, 0xFF7A7F8E, false);

            int switchBg = mod.isEnabled() ? 0xFF6C5CE7 : 0xFF2E333D;
            context.fill(cX + cardWidth - 44, cY + 12, cX + cardWidth - 14, cY + 28, switchBg);
            int knobX = mod.isEnabled() ? (cX + cardWidth - 26) : (cX + cardWidth - 42);
            context.fill(knobX, cY + 14, knobX + 12, cY + 26, 0xFFFFFFFF);

            index++;
        }
    }

    private void renderBotView(DrawContext context, int x, int y, int width, int height, int mouseX, int mouseY) {
        context.drawText(this.textRenderer, "AUTONOMOUS BOTS (9 FEATURED BOTS)", x + 16, y + 16, 0xFFFFFFFF, true);
        List<AbstractBot> bots = BotManager.getActiveBots();
        int botY = y + 36;

        for (AbstractBot bot : bots) {
            context.fill(x + 16, botY, x + width - 16, botY + 45, 0xFF161920);
            context.drawText(this.textRenderer, bot.getId() + " | " + bot.getName() + " -> STATUS: " + bot.getStatus(), x + 20, botY + 16, 0xFF00FF55, true);

            int btnColor = bot.isEnabled() ? 0xFF55FF55 : 0xFFFF5555;
            context.fill(x + width - 110, botY + 10, x + width - 24, botY + 35, btnColor);
            context.drawText(this.textRenderer, bot.isEnabled() ? "ACTIVE" : "OFFLINE", x + width - 95, botY + 18, 0xFF000000, true);

            botY += 52;
            if (botY > y + height - 20) break;
        }
    }

    private void renderThemeView(DrawContext context, int x, int y, int width, int height) {
        context.drawText(this.textRenderer, "THEME CUSTOMIZER", x + 16, y + 16, 0xFFFFFFFF, true);
        String[] themes = {"CORZ_ORANGE", "NEON_PINK", "CYBER_CYAN", "BLOOD_RED", "GOLD_LUXURY"};
        int tY = y + 45;
        for (String t : themes) {
            context.fill(x + 16, tY, x + 300, tY + 36, 0xFF161920);
            context.drawText(this.textRenderer, "Theme Preset: " + t, x + 24, tY + 12, 0xFFFFFFFF, false);
            tY += 45;
        }
    }

    private void renderWaypointView(DrawContext context, int x, int y, int width, int height) {
        context.drawText(this.textRenderer, "WORLD WAYPOINTS MANAGER", x + 16, y + 16, 0xFFFFFFFF, true);
        List<WaypointManager.Waypoint> wps = WaypointManager.getWaypoints();
        int wY = y + 45;
        for (WaypointManager.Waypoint wp : wps) {
            context.fill(x + 16, wY, x + width - 16, wY + 36, 0xFF161920);
            context.drawText(this.textRenderer, wp.name + " -> X: " + wp.x + ", Y: " + wp.y + ", Z: " + wp.z, x + 24, wY + 12, 0xFF00FF55, false);
            wY += 45;
        }
    }

    private void renderFriendView(DrawContext context, int x, int y, int width, int height) {
        context.drawText(this.textRenderer, "FRIEND LIST MANAGER (COMBAT BYPASS)", x + 16, y + 16, 0xFFFFFFFF, true);
        int fY = y + 45;
        for (String f : FriendManager.getFriends()) {
            context.fill(x + 16, fY, x + 300, fY + 36, 0xFF161920);
            context.drawText(this.textRenderer, "Friend: " + f, x + 24, fY + 12, 0xFFFF5500, false);
            fY += 45;
        }
    }

    private void renderMacroView(DrawContext context, int x, int y, int width, int height) {
        context.drawText(this.textRenderer, "CHAT MACRO ENGINE", x + 16, y + 16, 0xFFFFFFFF, true);
        int mY = y + 45;
        for (Map.Entry<String, String> entry : MacroManager.getMacros().entrySet()) {
            context.fill(x + 16, mY, x + width - 16, mY + 36, 0xFF161920);
            context.drawText(this.textRenderer, "[" + entry.getKey() + "] -> " + entry.getValue(), x + 24, mY + 12, 0xFF00E5FF, false);
            mY += 45;
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        int screenWidth = this.width;
        int screenHeight = this.height;
        int panelWidth = Math.min(880, screenWidth - 20);
        int panelHeight = Math.min(560, screenHeight - 20);
        int panelX = (screenWidth - panelWidth) / 2;
        int panelY = (screenHeight - panelHeight) / 2;

        int currentY = panelY + 62;
        for (String cat : categories) {
            if (mouseX >= panelX + 12 && mouseX <= panelX + 163 && mouseY >= currentY - 2 && mouseY <= currentY + 18) {
                activeCategory = cat;
                return true;
            }
            currentY += 22;
        }

        currentY += 6 + 24;
        for (String gen : generalOptions) {
            if (mouseX >= panelX + 12 && mouseX <= panelX + 163 && mouseY >= currentY - 2 && mouseY <= currentY + 18) {
                activeCategory = gen;
                return true;
            }
            currentY += 22;
        }

        if (activeCategory.equals("Theme")) {
            if (mouseY >= panelY + 45 && mouseY <= panelY + 81) ThemeManager.setTheme(ThemeManager.Theme.CORZ_ORANGE);
            else if (mouseY >= panelY + 90 && mouseY <= panelY + 126) ThemeManager.setTheme(ThemeManager.Theme.NEON_PINK);
            else if (mouseY >= panelY + 135 && mouseY <= panelY + 171) ThemeManager.setTheme(ThemeManager.Theme.CYBER_CYAN);
            else if (mouseY >= panelY + 180 && mouseY <= panelY + 216) ThemeManager.setTheme(ThemeManager.Theme.BLOOD_RED);
            else if (mouseY >= panelY + 225 && mouseY <= panelY + 261) ThemeManager.setTheme(ThemeManager.Theme.GOLD_LUXURY);
            return true;
        }

        if (activeCategory.equals("Bots")) {
            int botY = panelY + 50 + 36;
            for (AbstractBot bot : BotManager.getActiveBots()) {
                if (mouseX >= panelX + 185 + panelWidth - 185 - 110 && mouseX <= panelX + 185 + panelWidth - 185 - 24 && mouseY >= botY + 10 && mouseY <= botY + 35) {
                    bot.toggle();
                    return true;
                }
                botY += 52;
            }
        }

        if (!activeCategory.equals("Bots") && !activeCategory.equals("Theme") && !activeCategory.equals("Waypoints") && !activeCategory.equals("Friends") && !activeCategory.equals("Macros")) {
            List<Module> mods = ModuleManager.getModulesByCategory(activeCategory);
            int cardWidth = 320;
            int cardHeight = 40;
            int startX = panelX + 185 + 16;
            int startY = panelY + 50 + 36;

            for (int i = 0; i < mods.size(); i++) {
                int col = i % 2;
                int row = i / 2;
                int cX = startX + col * (cardWidth + 12);
                int cY = startY + row * (cardHeight + 8);
                if (mouseX >= cX && mouseX <= cX + cardWidth && mouseY >= cY && mouseY <= cY + cardHeight) {
                    mods.get(i).toggle();
                    return true;
                }
            }
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean touchClicked(double mouseX, double mouseY, int button) {
        return this.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean shouldPause() { return false; }
}
