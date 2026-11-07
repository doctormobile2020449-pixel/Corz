package com.corz.manager;

public class ThemeManager {
    public static enum Theme { CORZ_ORANGE, NEON_PINK, CYBER_CYAN, BLOOD_RED, GOLD_LUXURY }
    private static Theme currentTheme = Theme.CORZ_ORANGE;

    public static void init() { currentTheme = Theme.CORZ_ORANGE; }
    public static void setTheme(Theme t) { currentTheme = t; }
    public static Theme getCurrentTheme() { return currentTheme; }

    public static int getAccentColor() {
        switch (currentTheme) {
            case NEON_PINK: return 0xFFFF007F;
            case CYBER_CYAN: return 0xFF00E5FF;
            case BLOOD_RED: return 0xFFFF1744;
            case GOLD_LUXURY: return 0xFFFFD700;
            case CORZ_ORANGE:
            default: return 0xFFFF5500;
        }
    }
}
