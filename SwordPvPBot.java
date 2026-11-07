package com.corz.bots;
import net.minecraft.client.MinecraftClient;
public class SwordPvPBot extends AbstractBot {
    public SwordPvPBot(String id, String name) { super(id, name); }
    @Override public void onTick(MinecraftClient client) {
        if (client.player == null) return;
        this.status = this.enabled ? "SWORD PVP BOT ACTIVE" : "OFFLINE";
    }
}
