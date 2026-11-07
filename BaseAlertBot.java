package com.corz.bots;
import net.minecraft.client.MinecraftClient;
public class BaseAlertBot extends AbstractBot {
    public BaseAlertBot(String id, String name) { super(id, name); }
    @Override public void onTick(MinecraftClient client) {
        if (client.player == null) return;
        this.status = this.enabled ? "BASE ALERT ACTIVE" : "OFFLINE";
    }
}
