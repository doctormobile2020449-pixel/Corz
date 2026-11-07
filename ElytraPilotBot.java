package com.corz.bots;
import net.minecraft.client.MinecraftClient;
public class ElytraPilotBot extends AbstractBot {
    public ElytraPilotBot(String id, String name) { super(id, name); }
    @Override public void onTick(MinecraftClient client) {
        if (client.player == null) return;
        this.status = this.enabled ? "ELYTRA PILOT ACTIVE" : "OFFLINE";
    }
}
