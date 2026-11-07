package com.corz.bots;
import net.minecraft.client.MinecraftClient;
public class AnchorHunterBot extends AbstractBot {
    public AnchorHunterBot(String id, String name) { super(id, name); }
    @Override public void onTick(MinecraftClient client) {
        if (client.player == null) return;
        this.status = this.enabled ? "ANCHOR HUNTER ACTIVE" : "OFFLINE";
    }
}
