package com.bindchanger;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;

public final class BindChangerKeybinds {

    // In MC 1.21.11 with Yarn mappings, KeyBinding.Category uses create() method
    private static final KeyBinding.Category CATEGORY = KeyBinding.Category.create(
            Identifier.of("bindchanger", "keybinds")
    );

    public static KeyBinding TOGGLE;
    public static KeyBinding OPEN_CONFIG;

    public static void register() {
        TOGGLE = KeyBindingHelper.registerKeyBinding(
                new KeyBinding(
                        "key.bindchanger.toggle",
                        InputUtil.Type.KEYSYM,
                        GLFW.GLFW_KEY_V,
                        CATEGORY
                )
        );

        OPEN_CONFIG = KeyBindingHelper.registerKeyBinding(
                new KeyBinding(
                        "key.bindchanger.config",
                        InputUtil.Type.KEYSYM,
                        GLFW.GLFW_KEY_B,
                        CATEGORY
                )
        );
    }

    private BindChangerKeybinds() {}
}
