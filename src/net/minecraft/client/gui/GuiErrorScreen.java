package net.minecraft.client.gui;

import java.io.*;
import net.minecraft.client.resources.*;

public class GuiErrorScreen extends GuiScreen
{
    private /* synthetic */ String field_146312_f;
    private /* synthetic */ String field_146313_a;
    
    public GuiErrorScreen(final String llllllllllllllllllllIlIIllllIIll, final String llllllllllllllllllllIlIIllllIIlI) {
        this.field_146313_a = llllllllllllllllllllIlIIllllIIll;
        this.field_146312_f = llllllllllllllllllllIlIIllllIIlI;
    }
    
    @Override
    public void drawScreen(final int llllllllllllllllllllIlIIlllIIlIl, final int llllllllllllllllllllIlIIlllIIlII, final float llllllllllllllllllllIlIIlllIIIll) {
        this.drawGradientRect(0, 0, this.width, this.height, -12574688, -11530224);
        this.drawCenteredString(this.fontRendererObj, this.field_146313_a, this.width / 2, 90, 16777215);
        this.drawCenteredString(this.fontRendererObj, this.field_146312_f, this.width / 2, 110, 16777215);
        super.drawScreen(llllllllllllllllllllIlIIlllIIlIl, llllllllllllllllllllIlIIlllIIlII, llllllllllllllllllllIlIIlllIIIll);
    }
    
    @Override
    protected void keyTyped(final char llllllllllllllllllllIlIIlllIIIIl, final int llllllllllllllllllllIlIIlllIIIII) throws IOException {
    }
    
    static {
        __OBFID = "CL_00000696";
    }
    
    @Override
    public void initGui() {
        super.initGui();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, 140, I18n.format("gui.cancel", new Object[0])));
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllllllllIlIIllIlllIl) throws IOException {
        this.mc.displayGuiScreen(null);
    }
}
