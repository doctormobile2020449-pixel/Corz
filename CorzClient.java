package com.corz;

import com.corz.manager.BotManager;
import com.corz.manager.FriendManager;
import com.corz.manager.MacroManager;
import com.corz.manager.ModuleManager;
import com.corz.manager.ThemeManager;
import com.corz.manager.WaypointManager;
import com.corz.ui.CorzDashboardScreen;
import com.corz.ui.MobileHudOverlay;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class CorzClient implements ClientModInitializer {
    private static KeyBinding openGuiKey;
    private static KeyBinding mobileHudToggleKey;

    @Override
    public void onInitializeClient() {
        System.out.println("[Corz Client v2.4 Video Accurate] Initializing core modules, 9 bots & dashboard...");

        openGuiKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.corz.dashboard",
                InputUtil.Type.KEY_SYM,
                GLFW.GLFW_KEY_RIGHT_SHIFT,
                "category.corz.client"
        ));

        mobileHudToggleKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.corz.mobile_hud",
                InputUtil.Type.KEY_SYM,
                GLFW.GLFW_KEY_APOSTROPHE,
                "category.corz.client"
        ));

        ModuleManager.initModules();
        BotManager.registerBots();
        ThemeManager.init();
        WaypointManager.init();
        FriendManager.init();
        MacroManager.init();

        HudRenderCallback.EVENT.register(new MobileHudOverlay());

        ClientTickEvents.END_TICK.register(client -> {
            while (openGuiKey.wasPressed()) {
                client.setScreen(new CorzDashboardScreen());
            }
            while (mobileHudToggleKey.wasPressed()) {
                MobileHudOverlay.toggleVisibility();
            }
            ModuleManager.onTick(client);
        });
    }
}
