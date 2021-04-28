package net.minecraft.client.gui;

import net.minecraft.util.*;
import java.io.*;
import net.minecraft.client.resources.*;
import java.util.*;

public class GuiDisconnected extends GuiScreen
{
    private /* synthetic */ String reason;
    private /* synthetic */ List multilineMessage;
    private /* synthetic */ IChatComponent message;
    private /* synthetic */ int field_175353_i;
    private final /* synthetic */ GuiScreen parentScreen;
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllIIlIIIlIlIIllIllIl) throws IOException {
        if (llllllllllllllIIlIIIlIlIIllIllIl.id == 0) {
            this.mc.displayGuiScreen(this.parentScreen);
        }
    }
    
    @Override
    public void initGui() {
        this.buttonList.clear();
        this.multilineMessage = this.fontRendererObj.listFormattedStringToWidth(this.message.getFormattedText(), this.width - 50);
        this.field_175353_i = this.multilineMessage.size() * this.fontRendererObj.FONT_HEIGHT;
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 2 + this.field_175353_i / 2 + this.fontRendererObj.FONT_HEIGHT, I18n.format("gui.toMenu", new Object[0])));
    }
    
    @Override
    protected void keyTyped(final char llllllllllllllIIlIIIlIlIIlllIlIl, final int llllllllllllllIIlIIIlIlIIlllIlII) throws IOException {
    }
    
    static {
        __OBFID = "CL_00000693";
    }
    
    public GuiDisconnected(final GuiScreen llllllllllllllIIlIIIlIlIIlllllIl, final String llllllllllllllIIlIIIlIlIIlllllII, final IChatComponent llllllllllllllIIlIIIlIlIIlllIlll) {
        this.parentScreen = llllllllllllllIIlIIIlIlIIlllllIl;
        this.reason = I18n.format(llllllllllllllIIlIIIlIlIIlllllII, new Object[0]);
        this.message = llllllllllllllIIlIIIlIlIIlllIlll;
    }
    
    @Override
    public void drawScreen(final int llllllllllllllIIlIIIlIlIIlIllIll, final int llllllllllllllIIlIIIlIlIIlIllIlI, final float llllllllllllllIIlIIIlIlIIlIllIIl) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, this.reason, this.width / 2, this.height / 2 - this.field_175353_i / 2 - this.fontRendererObj.FONT_HEIGHT * 2, 11184810);
        int llllllllllllllIIlIIIlIlIIlIlllll = this.height / 2 - this.field_175353_i / 2;
        if (this.multilineMessage != null) {
            for (final String llllllllllllllIIlIIIlIlIIlIlllIl : this.multilineMessage) {
                this.drawCenteredString(this.fontRendererObj, llllllllllllllIIlIIIlIlIIlIlllIl, this.width / 2, llllllllllllllIIlIIIlIlIIlIlllll, 16777215);
                llllllllllllllIIlIIIlIlIIlIlllll += this.fontRendererObj.FONT_HEIGHT;
            }
        }
        super.drawScreen(llllllllllllllIIlIIIlIlIIlIllIll, llllllllllllllIIlIIIlIlIIlIllIlI, llllllllllllllIIlIIIlIlIIlIllIIl);
    }
}
