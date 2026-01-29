package com.bindchanger;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public final class BindChangerLogic {

    public static void toggle() {
        BindChangerConfig.mouseMode = !BindChangerConfig.mouseMode;
        apply();
    }

    public static void apply() {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client == null || client.player == null) return;

        int slot = BindChangerConfig.hotbarSlot - 1;
        if (slot < 0 || slot > 8) return;

        KeyBinding hotbar = client.options.hotbarKeys[slot];

        if (BindChangerConfig.mouseMode) {
            // LEFT MOUSE BUTTON
            hotbar.setBoundKey(InputUtil.Type.MOUSE.createFromCode(0));

            client.player.sendMessage(
                    Text.literal(
                            "BindChanger: Hotbar " +
                                    BindChangerConfig.hotbarSlot +
                                    " → Left Click"
                    ).formatted(Formatting.GREEN),
                    false
            );
        } else {
            // CUSTOM KEY (already InputUtil.Key)
            hotbar.setBoundKey(BindChangerConfig.customKey);

            client.player.sendMessage(
                    Text.literal(
                            "BindChanger: Hotbar " +
                                    BindChangerConfig.hotbarSlot +
                                    " → " +
                                    BindChangerConfig.customKey.getLocalizedText().getString()
                    ).formatted(Formatting.GREEN),
                    false
            );
        }

        KeyBinding.updateKeysByCode();
    }

    private BindChangerLogic() {}
}
