package com.corz.manager;

import com.corz.modules.Module;
import net.minecraft.client.MinecraftClient;
import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    private static final List<Module> modules = new ArrayList<>();

    public static void initModules() {
        // --- COMBAT MODULES (24 Featured in Videos) ---
        modules.add(new Module("Auto Crystal", "Combat", "Places and detonates end crystals automatically.") {});
        modules.add(new Module("Anchor Macro", "Combat", "Charges and detonates respawn anchors.") {});
        modules.add(new Module("Safe Anchor", "Combat", "Detonates anchors safely behind shields.") {});
        modules.add(new Module("Aim Assist", "Combat", "Smooth crosshair targeting to nearest player.") {});
        modules.add(new Module("Triggerbot", "Combat", "Strikes automatically under crosshair.") {});
        modules.add(new Module("Auto Totem", "Combat", "Instantly pops totems into offhand.") {});
        modules.add(new Module("Auto Refill", "Combat", "Restocks inventory items mid-fight.") {});
        modules.add(new Module("Key Pearl", "Combat", "Instant pearl throw keybind.") {});
        modules.add(new Module("Auto Mace", "Combat", "Times fully charged smash on the way down.") {});
        modules.add(new Module("Mace Swap", "Combat", "Swaps to mace for hit, then switches back.") {});
        modules.add(new Module("Killaura", "Combat", "Attacks entities in attack range.") {});
        modules.add(new Module("Surround", "Combat", "Places obsidian around feet for protection.") {});
        modules.add(new Module("HoleFill", "Combat", "Fills nearby safe holes with obsidian.") {});
        modules.add(new Module("Velocity", "Combat", "Cancels knockback and explosions.") {});
        modules.add(new Module("Criticals", "Combat", "Forces critical hits on every strike.") {});
        modules.add(new Module("Auto Pot", "Combat", "Throws health/speed splash potions.") {});
        modules.add(new Module("Reach", "Combat", "Extends attack and interaction reach.") {});
        modules.add(new Module("Auto Trap", "Combat", "Surrounds target players with obsidian.") {});
        modules.add(new Module("Auto Clicker", "Combat", "High-frequency automated clicking.") {});
        modules.add(new Module("Hit Select", "Combat", "Synchronizes hits with knockback windows.") {});
        modules.add(new Module("Auto XP", "Combat", "Mends armor using XP bottles.") {});
        modules.add(new Module("Silent Aim", "Combat", "Rays targets without view snapping.") {});
        modules.add(new Module("Crystal Optimizer", "Combat", "Optimizes crystal placement speeds.") {});
        modules.add(new Module("Combat Stats", "Combat", "Tracks PvP stats and K/D ratios.") {});

        // --- DONUTSMP MODULES (27 Featured in Videos) ---
        modules.add(new Module("Auto Builder", "DonutSMP", "Litematica schematic automatic placement.") {});
        modules.add(new Module("Auto Area Miner", "DonutSMP", "Clears selected boxes completely.") {});
        modules.add(new Module("Chunk Finder", "DonutSMP", "Finds bases and structures while exploring.") {});
        modules.add(new Module("Sus Chunk Finder", "DonutSMP", "Marks hidden bases on top-down maps.") {});
        modules.add(new Module("Netherite Finder", "DonutSMP", "Highlights ancient debris through stone.") {});
        modules.add(new Module("Deep Player Finder", "DonutSMP", "Locates players hiding deep underground.") {});
        modules.add(new Module("Staff List", "DonutSMP", "Displays online server staff members.") {});
        modules.add(new Module("Auto Sell", "DonutSMP", "Automatically sells selected items.") {});
        modules.add(new Module("Auto Sell Chest", "DonutSMP", "Empties entire chests to shop.") {});
        modules.add(new Module("Auto Villager Trade", "DonutSMP", "Trades with villagers automatically.") {});
        modules.add(new Module("Auto Farm", "DonutSMP", "Automated crop harvester and replanter.") {});
        modules.add(new Module("Auto Quest", "DonutSMP", "Auto-completes available server quests.") {});
        modules.add(new Module("Auto Reconnect", "DonutSMP", "Instantly reconnects upon server kick.") {});
        modules.add(new Module("AH Sniper", "DonutSMP", "Snipes underpriced auction house items.") {});
        modules.add(new Module("Auto Miner", "DonutSMP", "Automated tunnel mine helper.") {});
        modules.add(new Module("Auto Fisher", "DonutSMP", "Automated fishing and loot collection.") {});
        modules.add(new Module("Auto Brew", "DonutSMP", "Automatic potion brewing queues.") {});
        modules.add(new Module("Auto Repair", "DonutSMP", "Auto repairs tools at anvils.") {});
        modules.add(new Module("Spawner Finder", "DonutSMP", "Highlights and labels nearby mob spawners.") {});
        modules.add(new Module("Base Radar", "DonutSMP", "Scans coordinates for player chests/bases.") {});
        modules.add(new Module("AH Tracker", "DonutSMP", "Monitors lowest auction house prices.") {});
        modules.add(new Module("Quest Tracker", "DonutSMP", "Optimizes quest completion routes.") {});
        modules.add(new Module("Economy Logger", "DonutSMP", "Logs profit per hour from grinding.") {});
        modules.add(new Module("Vault Organizer", "DonutSMP", "Auto sorts player vaults and chests.") {});
        modules.add(new Module("Claim Finder", "DonutSMP", "Scans land claim boundaries.") {});
        modules.add(new Module("Auto Claim", "DonutSMP", "Automatically claims conquered chunks.") {});
        modules.add(new Module("Donut Optimizer", "DonutSMP", "Maximizes TPS performance on DonutSMP.") {});

        // --- VISUALS & MOVEMENT (69 Total Featured in Videos) ---
        modules.add(new Module("Player ESP", "Visuals", "Highlights players through walls with teams.") {});
        modules.add(new Module("NameTags", "Visuals", "Shows health, armor, and items on tags.") {});
        modules.add(new Module("Storage ESP", "Visuals", "Boxes around chests and shulker boxes.") {});
        modules.add(new Module("Spawner Finder", "Visuals", "Adds beams and labels to mob spawners.") {});
        modules.add(new Module("Pearl Prediction", "Visuals", "Draws flight paths and landing spots.") {});
        modules.add(new Module("Pearl Catch", "Visuals", "Warns when enemy pearl lands nearby.") {});
        modules.add(new Module("Custom Sky", "Visuals", "Northern Lights, Black Hole, Saturn Nebula.") {});
        modules.add(new Module("Flight", "Movement", "Survival flight mode.") {});
        modules.add(new Module("Freecam", "Movement", "Detaches camera freely.") {});
        modules.add(new Module("Free Look", "Movement", "Independent camera rotation.") {});
        modules.add(new Module("Bridge Build", "Movement", "Automatic scaffolding and bridging.") {});
        modules.add(new Module("Auto Jump Reset", "Movement", "Jumps when hit to cut knockback.") {});
        modules.add(new Module("Glowing Trails", "Visuals", "Leaves glowing particle trails.") {});
        modules.add(new Module("Jump Circles", "Visuals", "Renders circles upon jumping.") {});
        modules.add(new Module("Sword Inspect", "Visuals", "Counter-Strike style sword animation.") {});
        modules.add(new Module("Cape Library", "Visuals", "Custom animated capes and wings.") {});
        modules.add(new Module("Chams", "Visuals", "Renders entities through solid blocks.") {});
        modules.add(new Module("China Hat", "Visuals", "Aesthetic stylish hat on player.") {});
        modules.add(new Module("Full Bright", "Visuals", "Maximizes gamma lighting.") {});
        modules.add(new Module("Item ESP", "Visuals", "Highlights dropped world items.") {});
        modules.add(new Module("Glow", "Visuals", "Glowing entity outlines.") {});
        modules.add(new Module("Atmosphere", "Visuals", "Custom skybox and lighting.") {});
        modules.add(new Module("Tracers", "Visuals", "Draws directional lines to players.") {});
        modules.add(new Module("Xray", "Visuals", "Renders underground valuable ores.") {});
        modules.add(new Module("Hole ESP", "Visuals", "Highlights safe obsidian holes.") {});
        modules.add(new Module("Breadcrumbs", "Visuals", "Leaves trail behind player path.") {});
        modules.add(new Module("Speed", "Movement", "Increases movement velocity.") {});
        modules.add(new Module("Step", "Movement", "Steps up full blocks instantly.") {});
        modules.add(new Module("Spider", "Movement", "Climbs vertical walls like spider.") {});
        modules.add(new Module("Long Jump", "Movement", "Boosted jump distance.") {});
        modules.add(new Module("Safe Walk", "Movement", "Prevents walking off block edges.") {});
        modules.add(new Module("No Fall", "Misc", "Negates fall damage packets.") {});
        modules.add(new Module("Fast Break", "Misc", "Accelerates block breaking speed.") {});
        modules.add(new Module("Spammer", "Misc", "Custom chat message spammer.") {});
        modules.add(new Module("Anti Crash", "Misc", "Packet crash protection.") {});
        modules.add(new Module("Ping Spoof", "Network", "Simulates artificial latency.") {});
        modules.add(new Module("Packet Cancel", "Network", "Outbound packet interceptor.") {});
    }

    public static List<Module> getModules() { return modules; }
    public static List<Module> getModulesByCategory(String category) {
        List<Module> res = new ArrayList<>();
        for (Module m : modules) {
            if (m.getCategory().equalsIgnoreCase(category)) res.add(m);
        }
        return res;
    }

    public static void onTick(MinecraftClient client) {
        for (Module m : modules) {
            if (m.isEnabled()) m.onTick(client);
        }
    }
}
