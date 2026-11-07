package com.corz.bots;
import net.minecraft.client.MinecraftClient;
public class AreaMinerBot extends AbstractBot {
    public AreaMinerBot(String id, String name) { super(id, name); }
    @Override public void onTick(MinecraftClient client) {
        if (client.player == null) return;
        this.status = this.enabled ? "AREA MINER BOT ACTIVE" : "OFFLINE";
    }
}
