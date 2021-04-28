package net.minecraft.client.gui.stream;

import net.minecraft.client.settings.*;
import net.minecraft.client.gui.*;
import java.io.*;
import net.minecraft.client.resources.*;
import net.minecraft.util.*;

public class GuiStreamOptions extends GuiScreen
{
    private final /* synthetic */ GameSettings field_152318_h;
    private /* synthetic */ String field_152313_r;
    private final /* synthetic */ GuiScreen field_152317_g;
    private static final /* synthetic */ GameSettings.Options[] field_152316_f;
    private static final /* synthetic */ GameSettings.Options[] field_152312_a;
    private /* synthetic */ String field_152319_i;
    private /* synthetic */ boolean field_152315_t;
    private /* synthetic */ int field_152314_s;
    
    public GuiStreamOptions(final GuiScreen llllllllllllllllIIIllIIIIllIlIIl, final GameSettings llllllllllllllllIIIllIIIIllIlIII) {
        this.field_152315_t = false;
        this.field_152317_g = llllllllllllllllIIIllIIIIllIlIIl;
        this.field_152318_h = llllllllllllllllIIIllIIIIllIlIII;
    }
    
    static {
        __OBFID = "CL_00001841";
        field_152312_a = new GameSettings.Options[] { GameSettings.Options.STREAM_BYTES_PER_PIXEL, GameSettings.Options.STREAM_FPS, GameSettings.Options.STREAM_KBPS, GameSettings.Options.STREAM_SEND_METADATA, GameSettings.Options.STREAM_VOLUME_MIC, GameSettings.Options.STREAM_VOLUME_SYSTEM, GameSettings.Options.STREAM_MIC_TOGGLE_BEHAVIOR, GameSettings.Options.STREAM_COMPRESSION };
        field_152316_f = new GameSettings.Options[] { GameSettings.Options.STREAM_CHAT_ENABLED, GameSettings.Options.STREAM_CHAT_USER_FILTER };
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllllIIIllIIIIIIlIIll) throws IOException {
        if (llllllllllllllllIIIllIIIIIIlIIll.enabled) {
            if (llllllllllllllllIIIllIIIIIIlIIll.id < 100 && llllllllllllllllIIIllIIIIIIlIIll instanceof GuiOptionButton) {
                final GameSettings.Options llllllllllllllllIIIllIIIIIIlIlll = ((GuiOptionButton)llllllllllllllllIIIllIIIIIIlIIll).returnEnumOptions();
                this.field_152318_h.setOptionValue(llllllllllllllllIIIllIIIIIIlIlll, 1);
                llllllllllllllllIIIllIIIIIIlIIll.displayString = this.field_152318_h.getKeyBinding(GameSettings.Options.getEnumOptions(llllllllllllllllIIIllIIIIIIlIIll.id));
                if (this.mc.getTwitchStream().func_152934_n() && llllllllllllllllIIIllIIIIIIlIlll != GameSettings.Options.STREAM_CHAT_ENABLED && llllllllllllllllIIIllIIIIIIlIlll != GameSettings.Options.STREAM_CHAT_USER_FILTER) {
                    this.field_152315_t = true;
                }
            }
            else if (llllllllllllllllIIIllIIIIIIlIIll instanceof GuiOptionSlider) {
                if (llllllllllllllllIIIllIIIIIIlIIll.id == GameSettings.Options.STREAM_VOLUME_MIC.returnEnumOrdinal()) {
                    this.mc.getTwitchStream().func_152915_s();
                }
                else if (llllllllllllllllIIIllIIIIIIlIIll.id == GameSettings.Options.STREAM_VOLUME_SYSTEM.returnEnumOrdinal()) {
                    this.mc.getTwitchStream().func_152915_s();
                }
                else if (this.mc.getTwitchStream().func_152934_n()) {
                    this.field_152315_t = true;
                }
            }
            if (llllllllllllllllIIIllIIIIIIlIIll.id == 200) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(this.field_152317_g);
            }
            else if (llllllllllllllllIIIllIIIIIIlIIll.id == 201) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(new GuiIngestServers(this));
            }
        }
    }
    
    @Override
    public void initGui() {
        int llllllllllllllllIIIllIIIIIllIlII = 0;
        this.field_152319_i = I18n.format("options.stream.title", new Object[0]);
        this.field_152313_r = I18n.format("options.stream.chat.title", new Object[0]);
        for (final GameSettings.Options llllllllllllllllIIIllIIIIIllIIII : GuiStreamOptions.field_152312_a) {
            if (llllllllllllllllIIIllIIIIIllIIII.getEnumFloat()) {
                this.buttonList.add(new GuiOptionSlider(llllllllllllllllIIIllIIIIIllIIII.returnEnumOrdinal(), this.width / 2 - 155 + llllllllllllllllIIIllIIIIIllIlII % 2 * 160, this.height / 6 + 24 * (llllllllllllllllIIIllIIIIIllIlII >> 1), llllllllllllllllIIIllIIIIIllIIII));
            }
            else {
                this.buttonList.add(new GuiOptionButton(llllllllllllllllIIIllIIIIIllIIII.returnEnumOrdinal(), this.width / 2 - 155 + llllllllllllllllIIIllIIIIIllIlII % 2 * 160, this.height / 6 + 24 * (llllllllllllllllIIIllIIIIIllIlII >> 1), llllllllllllllllIIIllIIIIIllIIII, this.field_152318_h.getKeyBinding(llllllllllllllllIIIllIIIIIllIIII)));
            }
            ++llllllllllllllllIIIllIIIIIllIlII;
        }
        if (llllllllllllllllIIIllIIIIIllIlII % 2 == 1) {
            ++llllllllllllllllIIIllIIIIIllIlII;
        }
        this.field_152314_s = this.height / 6 + 24 * (llllllllllllllllIIIllIIIIIllIlII >> 1) + 6;
        llllllllllllllllIIIllIIIIIllIlII += 2;
        for (final GameSettings.Options llllllllllllllllIIIllIIIIIlIllll : GuiStreamOptions.field_152316_f) {
            if (llllllllllllllllIIIllIIIIIlIllll.getEnumFloat()) {
                this.buttonList.add(new GuiOptionSlider(llllllllllllllllIIIllIIIIIlIllll.returnEnumOrdinal(), this.width / 2 - 155 + llllllllllllllllIIIllIIIIIllIlII % 2 * 160, this.height / 6 + 24 * (llllllllllllllllIIIllIIIIIllIlII >> 1), llllllllllllllllIIIllIIIIIlIllll));
            }
            else {
                this.buttonList.add(new GuiOptionButton(llllllllllllllllIIIllIIIIIlIllll.returnEnumOrdinal(), this.width / 2 - 155 + llllllllllllllllIIIllIIIIIllIlII % 2 * 160, this.height / 6 + 24 * (llllllllllllllllIIIllIIIIIllIlII >> 1), llllllllllllllllIIIllIIIIIlIllll, this.field_152318_h.getKeyBinding(llllllllllllllllIIIllIIIIIlIllll)));
            }
            ++llllllllllllllllIIIllIIIIIllIlII;
        }
        this.buttonList.add(new GuiButton(200, this.width / 2 - 155, this.height / 6 + 168, 150, 20, I18n.format("gui.done", new Object[0])));
        final GuiButton llllllllllllllllIIIllIIIIIlIlllI = new GuiButton(201, this.width / 2 + 5, this.height / 6 + 168, 150, 20, I18n.format("options.stream.ingestSelection", new Object[0]));
        llllllllllllllllIIIllIIIIIlIlllI.enabled = ((this.mc.getTwitchStream().func_152924_m() && this.mc.getTwitchStream().func_152925_v().length > 0) || this.mc.getTwitchStream().func_152908_z());
        this.buttonList.add(llllllllllllllllIIIllIIIIIlIlllI);
    }
    
    @Override
    public void drawScreen(final int llllllllllllllllIIIllIIIIIIIIIII, final int llllllllllllllllIIIllIIIIIIIIlII, final float llllllllllllllllIIIlIlllllllllII) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, this.field_152319_i, this.width / 2, 20, 16777215);
        this.drawCenteredString(this.fontRendererObj, this.field_152313_r, this.width / 2, this.field_152314_s, 16777215);
        if (this.field_152315_t) {
            this.drawCenteredString(this.fontRendererObj, String.valueOf(new StringBuilder().append(EnumChatFormatting.RED).append(I18n.format("options.stream.changes", new Object[0]))), this.width / 2, 20 + this.fontRendererObj.FONT_HEIGHT, 16777215);
        }
        super.drawScreen(llllllllllllllllIIIllIIIIIIIIIII, llllllllllllllllIIIllIIIIIIIIlII, llllllllllllllllIIIlIlllllllllII);
    }
}
