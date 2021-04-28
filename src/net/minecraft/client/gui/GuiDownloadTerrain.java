package net.minecraft.client.gui;

import net.minecraft.client.network.*;
import net.minecraft.client.resources.*;
import java.io.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;

public class GuiDownloadTerrain extends GuiScreen
{
    private /* synthetic */ int progress;
    private /* synthetic */ NetHandlerPlayClient netHandlerPlayClient;
    
    public GuiDownloadTerrain(final NetHandlerPlayClient llllllllllllllIlIIIIIIlIlIlIlIll) {
        this.netHandlerPlayClient = llllllllllllllIlIIIIIIlIlIlIlIll;
    }
    
    @Override
    public void drawScreen(final int llllllllllllllIlIIIIIIlIlIIlllII, final int llllllllllllllIlIIIIIIlIlIIllIll, final float llllllllllllllIlIIIIIIlIlIIllIlI) {
        this.drawBackground(0);
        this.drawCenteredString(this.fontRendererObj, I18n.format("multiplayer.downloadingTerrain", new Object[0]), this.width / 2, this.height / 2 - 50, 16777215);
        super.drawScreen(llllllllllllllIlIIIIIIlIlIIlllII, llllllllllllllIlIIIIIIlIlIIllIll, llllllllllllllIlIIIIIIlIlIIllIlI);
    }
    
    static {
        __OBFID = "CL_00000708";
    }
    
    @Override
    public void initGui() {
        this.buttonList.clear();
    }
    
    @Override
    protected void keyTyped(final char llllllllllllllIlIIIIIIlIlIlIlIIl, final int llllllllllllllIlIIIIIIlIlIlIlIII) throws IOException {
    }
    
    @Override
    public void updateScreen() {
        ++this.progress;
        if (this.progress % 20 == 0) {
            this.netHandlerPlayClient.addToSendQueue(new C00PacketKeepAlive());
        }
    }
    
    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
