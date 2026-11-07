package com.corz.manager;

import java.util.HashMap;
import java.util.Map;

public class MacroManager {
    private static final Map<String, String> macros = new HashMap<>();

    public static void init() {
        macros.put("HOME", "/home");
        macros.put("FEED", "/feed");
        macros.put("SHOP", "/shop");
    }

    public static Map<String, String> getMacros() { return macros; }
    public static void setMacro(String key, String command) { macros.put(key, command); }
}
