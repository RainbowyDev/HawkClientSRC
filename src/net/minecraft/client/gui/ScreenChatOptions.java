package net.minecraft.client.gui;

import net.minecraft.client.settings.*;
import java.io.*;
import net.minecraft.client.resources.*;

public class ScreenChatOptions extends GuiScreen
{
    private final /* synthetic */ GameSettings game_settings;
    private /* synthetic */ String field_146398_r;
    private /* synthetic */ String field_146401_i;
    private /* synthetic */ int field_146397_s;
    private final /* synthetic */ GuiScreen field_146396_g;
    private static final /* synthetic */ GameSettings.Options[] field_146399_a;
    
    public ScreenChatOptions(final GuiScreen llllIIIlIllIIII, final GameSettings llllIIIlIllIIlI) {
        this.field_146396_g = llllIIIlIllIIII;
        this.game_settings = llllIIIlIllIIlI;
    }
    
    @Override
    public void drawScreen(final int llllIIIlIIlIIIl, final int llllIIIlIIlIIII, final float llllIIIlIIIlIll) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, this.field_146401_i, this.width / 2, 20, 16777215);
        this.drawCenteredString(this.fontRendererObj, this.field_146398_r, this.width / 2, this.field_146397_s + 7, 16777215);
        super.drawScreen(llllIIIlIIlIIIl, llllIIIlIIlIIII, llllIIIlIIIlIll);
    }
    
    static {
        __OBFID = "CL_00000681";
        field_146399_a = new GameSettings.Options[] { GameSettings.Options.CHAT_VISIBILITY, GameSettings.Options.CHAT_COLOR, GameSettings.Options.CHAT_LINKS, GameSettings.Options.CHAT_OPACITY, GameSettings.Options.CHAT_LINKS_PROMPT, GameSettings.Options.CHAT_SCALE, GameSettings.Options.CHAT_HEIGHT_FOCUSED, GameSettings.Options.CHAT_HEIGHT_UNFOCUSED, GameSettings.Options.CHAT_WIDTH, GameSettings.Options.REDUCED_DEBUG_INFO };
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllIIIlIIllIIl) throws IOException {
        if (llllIIIlIIllIIl.enabled) {
            if (llllIIIlIIllIIl.id < 100 && llllIIIlIIllIIl instanceof GuiOptionButton) {
                this.game_settings.setOptionValue(((GuiOptionButton)llllIIIlIIllIIl).returnEnumOptions(), 1);
                llllIIIlIIllIIl.displayString = this.game_settings.getKeyBinding(GameSettings.Options.getEnumOptions(llllIIIlIIllIIl.id));
            }
            if (llllIIIlIIllIIl.id == 200) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(this.field_146396_g);
            }
        }
    }
    
    @Override
    public void initGui() {
        int llllIIIlIlIIlll = 0;
        this.field_146401_i = I18n.format("options.chat.title", new Object[0]);
        this.field_146398_r = I18n.format("options.multiplayer.title", new Object[0]);
        for (final GameSettings.Options llllIIIlIlIIIll : ScreenChatOptions.field_146399_a) {
            if (llllIIIlIlIIIll.getEnumFloat()) {
                this.buttonList.add(new GuiOptionSlider(llllIIIlIlIIIll.returnEnumOrdinal(), this.width / 2 - 155 + llllIIIlIlIIlll % 2 * 160, this.height / 6 + 24 * (llllIIIlIlIIlll >> 1), llllIIIlIlIIIll));
            }
            else {
                this.buttonList.add(new GuiOptionButton(llllIIIlIlIIIll.returnEnumOrdinal(), this.width / 2 - 155 + llllIIIlIlIIlll % 2 * 160, this.height / 6 + 24 * (llllIIIlIlIIlll >> 1), llllIIIlIlIIIll, this.game_settings.getKeyBinding(llllIIIlIlIIIll)));
            }
            ++llllIIIlIlIIlll;
        }
        if (llllIIIlIlIIlll % 2 == 1) {
            ++llllIIIlIlIIlll;
        }
        this.field_146397_s = this.height / 6 + 24 * (llllIIIlIlIIlll >> 1);
        this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 120, I18n.format("gui.done", new Object[0])));
    }
}
