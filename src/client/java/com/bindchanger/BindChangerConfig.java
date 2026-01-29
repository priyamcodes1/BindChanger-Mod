package com.bindchanger;

import net.minecraft.client.util.InputUtil;

public final class BindChangerConfig {

    public static int hotbarSlot = 7;

    public static InputUtil.Key customKey =
            InputUtil.Type.KEYSYM.createFromCode(81); // Q

    public static boolean mouseMode = false;

    private BindChangerConfig() {}
}
