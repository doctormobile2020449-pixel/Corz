package com.corz.bots;
import net.minecraft.client.MinecraftClient;
public class MacePvPBot extends AbstractBot {
    public MacePvPBot(String id, String name) { super(id, name); }
    @Override public void onTick(MinecraftClient client) {
        if (client.player == null) return;
        this.status = this.enabled ? "MACE PVP BOT ACTIVE" : "OFFLINE";
    }
}
