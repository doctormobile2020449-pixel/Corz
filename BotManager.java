package com.corz.manager;

import com.corz.bots.*;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import java.util.ArrayList;
import java.util.List;

public class BotManager {
    private static final List<AbstractBot> activeBots = new ArrayList<>();

    public static void registerBots() {
        activeBots.add(new BaseAlertBot("BASE-01", "Base Alert"));
        activeBots.add(new MacePvPBot("MACE-02", "Mace PvP Bot"));
        activeBots.add(new SwordPvPBot("SWD-03", "Sword PvP Bot"));
        activeBots.add(new AutoBuilderBot("BLD-04", "Auto Builder"));
        activeBots.add(new CrystalPvPBot("CRY-05", "Crystal PvP"));
        activeBots.add(new AreaMinerBot("MIN-06", "Area Miner"));
        activeBots.add(new AnchorHunterBot("ANC-07", "Anchor Hunter"));
        activeBots.add(new ElytraPilotBot("ELY-08", "Elytra Pilot"));
        activeBots.add(new AutoTPABot("TPA-09", "Auto TPA"));

        ClientTickEvents.END_TICK.register(client -> {
            if (client.player == null || client.world == null) return;
            for (AbstractBot bot : activeBots) {
                if (bot.isEnabled()) bot.onTick(client);
            }
        });
    }

    public static List<AbstractBot> getActiveBots() { return activeBots; }
}
