package com.corz.bots;
import net.minecraft.client.MinecraftClient;
public class AutoBuilderBot extends AbstractBot {
    public AutoBuilderBot(String id, String name) { super(id, name); }
    @Override public void onTick(MinecraftClient client) {
        if (client.player == null) return;
        this.status = this.enabled ? "AUTO BUILDER ACTIVE" : "OFFLINE";
    }
}
