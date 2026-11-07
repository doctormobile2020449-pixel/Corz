package com.corz.modules;

import net.minecraft.client.MinecraftClient;

public abstract class Module {
    private final String name;
    private final String category;
    private final String description;
    private boolean enabled;

    public Module(String name, String category, String description) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.enabled = false;
    }

    public void toggle() {
        this.enabled = !this.enabled;
        if (this.enabled) onEnable();
        else onDisable();
    }

    public void onEnable() {}
    public void onDisable() {}
    public void onTick(MinecraftClient client) {}

    public String getName() { return name; }
    public String getCategory() { return category; }
    public String getDescription() { return description; }
    public boolean isEnabled() { return enabled; }
    public void setEnabled(boolean enabled) {
        if (this.enabled != enabled) toggle();
    }
}
