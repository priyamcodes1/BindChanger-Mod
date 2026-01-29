package com.bindchanger;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

public final class BindChangerClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BindChangerKeybinds.register();

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (BindChangerKeybinds.TOGGLE.wasPressed()) {
                BindChangerLogic.toggle();
            }

if (BindChangerKeybinds.OPEN_CONFIG.wasPressed()) {
    MinecraftClient.getInstance()
            .setScreen(new com.bindchanger.screen.BindChangerConfigScreen());
}

        });
    }
}
