package optifine;

import java.io.*;
import net.minecraft.client.gui.*;
import java.util.*;
import com.google.common.collect.*;
import net.minecraft.client.resources.*;

public class GuiMessage extends GuiScreen
{
    private final /* synthetic */ List listLines2;
    protected /* synthetic */ String confirmButtonText;
    private /* synthetic */ GuiScreen parentScreen;
    private /* synthetic */ String messageLine1;
    private /* synthetic */ String messageLine2;
    private /* synthetic */ int ticksUntilEnable;
    
    public void setButtonDelay(final int llllllllllllllIIIlllIIIllIlIIIlI) {
        this.ticksUntilEnable = llllllllllllllIIIlllIIIllIlIIIlI;
        for (final GuiButton llllllllllllllIIIlllIIIllIlIIIIl : this.buttonList) {
            llllllllllllllIIIlllIIIllIlIIIIl.enabled = false;
        }
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllIIIlllIIIllIlllllI) throws IOException {
        Config.getMinecraft().displayGuiScreen(this.parentScreen);
    }
    
    @Override
    public void drawScreen(final int llllllllllllllIIIlllIIIllIlIllIl, final int llllllllllllllIIIlllIIIllIlIllII, final float llllllllllllllIIIlllIIIllIllIIlI) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, this.messageLine1, this.width / 2, 70, 16777215);
        int llllllllllllllIIIlllIIIllIllIIIl = 90;
        for (final String llllllllllllllIIIlllIIIllIlIllll : this.listLines2) {
            this.drawCenteredString(this.fontRendererObj, llllllllllllllIIIlllIIIllIlIllll, this.width / 2, llllllllllllllIIIlllIIIllIllIIIl, 16777215);
            llllllllllllllIIIlllIIIllIllIIIl += this.fontRendererObj.FONT_HEIGHT;
        }
        super.drawScreen(llllllllllllllIIIlllIIIllIlIllIl, llllllllllllllIIIlllIIIllIlIllII, llllllllllllllIIIlllIIIllIllIIlI);
    }
    
    @Override
    public void updateScreen() {
        super.updateScreen();
        final int ticksUntilEnable = this.ticksUntilEnable - 1;
        this.ticksUntilEnable = ticksUntilEnable;
        if (ticksUntilEnable == 0) {
            for (final GuiButton llllllllllllllIIIlllIIIllIIlIlll : this.buttonList) {
                llllllllllllllIIIlllIIIllIIlIlll.enabled = true;
            }
        }
    }
    
    @Override
    public void initGui() {
        this.buttonList.add(new GuiOptionButton(0, this.width / 2 - 74, this.height / 6 + 96, this.confirmButtonText));
        this.listLines2.clear();
        this.listLines2.addAll(this.fontRendererObj.listFormattedStringToWidth(this.messageLine2, this.width - 50));
    }
    
    public GuiMessage(final GuiScreen llllllllllllllIIIlllIIIlllIIIllI, final String llllllllllllllIIIlllIIIlllIIlIIl, final String llllllllllllllIIIlllIIIlllIIIlII) {
        this.listLines2 = Lists.newArrayList();
        this.parentScreen = llllllllllllllIIIlllIIIlllIIIllI;
        this.messageLine1 = llllllllllllllIIIlllIIIlllIIlIIl;
        this.messageLine2 = llllllllllllllIIIlllIIIlllIIIlII;
        this.confirmButtonText = I18n.format("gui.done", new Object[0]);
    }
}
