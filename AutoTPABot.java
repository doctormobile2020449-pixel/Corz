package com.corz.bots;
import net.minecraft.client.MinecraftClient;
public class AutoTPABot extends AbstractBot {
    public AutoTPABot(String id, String name) { super(id, name); }
    @Override public void onTick(MinecraftClient client) {
        if (client.player == null) return;
        this.status = this.enabled ? "AUTO TPA BOT ACTIVE" : "OFFLINE";
    }
}
