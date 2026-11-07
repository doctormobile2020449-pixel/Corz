package com.corz.bots;
import net.minecraft.client.MinecraftClient;
public class CrystalPvPBot extends AbstractBot {
    public CrystalPvPBot(String id, String name) { super(id, name); }
    @Override public void onTick(MinecraftClient client) {
        if (client.player == null) return;
        this.status = this.enabled ? "CRYSTAL PVP BOT ACTIVE" : "OFFLINE";
    }
}
