package com.bindchanger.screen;

import com.bindchanger.BindChangerConfig;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.input.KeyInput;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;

public final class BindChangerConfigScreen extends Screen {

    private boolean waitingForKey = false;

    public BindChangerConfigScreen() {
        super(Text.literal("BindChanger Config"));
    }

    @Override
    protected void init() {
        int cx = width / 2;
        int cy = height / 2;

        addDrawableChild(
                ButtonWidget.builder(
                        Text.literal("Hotbar Slot: " + BindChangerConfig.hotbarSlot),
                        btn -> {
                            BindChangerConfig.hotbarSlot =
                                    BindChangerConfig.hotbarSlot % 9 + 1;
                            btn.setMessage(
                                    Text.literal("Hotbar Slot: " + BindChangerConfig.hotbarSlot)
                            );
                        }
                ).dimensions(cx - 100, cy - 30, 200, 20).build()
        );

        addDrawableChild(
                ButtonWidget.builder(
                        Text.literal("Custom Key: " +
                                BindChangerConfig.customKey.getLocalizedText().getString()),
                        btn -> {
                            waitingForKey = true;
                            btn.setMessage(Text.literal("Press any key..."));
                        }
                ).dimensions(cx - 100, cy, 200, 20).build()
        );

        addDrawableChild(
                ButtonWidget.builder(
                        Text.literal("Done"),
                        btn -> close()
                ).dimensions(cx - 100, cy + 30, 200, 20).build()
        );
    }

    @Override
    public boolean keyPressed(KeyInput keyInput) {
        if (waitingForKey) {
            BindChangerConfig.customKey =
                    InputUtil.Type.KEYSYM.createFromCode(keyInput.key());
            waitingForKey = false;
            clearChildren();
            init();
            return true;
        }
        return super.keyPressed(keyInput);
    }
}
