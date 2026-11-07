package com.corz.bots;

import net.minecraft.client.MinecraftClient;

public abstract class AbstractBot {
    protected String id, name, status = "OFFLINE";
    protected boolean enabled;

    public AbstractBot(String id, String name) {
        this.id = id; this.name = name; this.enabled = false;
    }

    public abstract void onTick(MinecraftClient client);
    public void toggle() {
        this.enabled = !this.enabled;
        this.status = this.enabled ? "ACTIVE" : "OFFLINE";
    }

    public boolean isEnabled() { return enabled; }
    public String getId() { return id; }
    public String getName() { return name; }
    public String getStatus() { return status; }
}
