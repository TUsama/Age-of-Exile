package com.robertx22.mine_and_slash.gui.bases;

import com.robertx22.mine_and_slash.event_hooks.player.OnKeyPress;
import com.robertx22.mine_and_slash.mmorpg.registers.client.KeybindsRegister;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.LiteralText;

public class BaseScreen extends Screen {

    protected BaseScreen(int width, int height) {
        super(new LiteralText(""));
        this.sizeX = width;
        this.sizeY = height;
    }

    public int guiLeft = 0;
    public int guiTop = 0;

    public int sizeX = 0;
    public int sizeY = 0;

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (KeybindsRegister.hubScreen.matchesKey(keyCode, scanCode)) {
            MinecraftClient.getInstance()
                .openScreen(null);
            OnKeyPress.cooldown = 5;
            return false;
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    protected void init() {
        super.init();

        this.guiLeft = (this.width - this.sizeX) / 2;
        this.guiTop = (this.height - this.sizeY) / 2;
    }

}
