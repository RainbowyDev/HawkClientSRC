package net.minecraft.client.gui;

import net.minecraft.client.resources.*;
import java.io.*;
import net.minecraft.client.multiplayer.*;
import java.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.*;

public class GuiGameOver extends GuiScreen implements GuiYesNoCallback
{
    private /* synthetic */ int field_146347_a;
    private /* synthetic */ boolean field_146346_f;
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllllIIlIIlIllIIlllll) throws IOException {
        switch (llllllllllllllllIIlIIlIllIIlllll.id) {
            case 0: {
                this.mc.thePlayer.respawnPlayer();
                this.mc.displayGuiScreen(null);
                break;
            }
            case 1: {
                final GuiYesNo llllllllllllllllIIlIIlIllIIllllI = new GuiYesNo(this, I18n.format("deathScreen.quit.confirm", new Object[0]), "", I18n.format("deathScreen.titleScreen", new Object[0]), I18n.format("deathScreen.respawn", new Object[0]), 0);
                this.mc.displayGuiScreen(llllllllllllllllIIlIIlIllIIllllI);
                llllllllllllllllIIlIIlIllIIllllI.setButtonDelay(20);
                break;
            }
        }
    }
    
    @Override
    public void confirmClicked(final boolean llllllllllllllllIIlIIlIllIIlIlII, final int llllllllllllllllIIlIIlIllIIlIllI) {
        if (llllllllllllllllIIlIIlIllIIlIlII) {
            this.mc.theWorld.sendQuittingDisconnectingPacket();
            this.mc.loadWorld(null);
            this.mc.displayGuiScreen(new GuiMainMenu());
        }
        else {
            this.mc.thePlayer.respawnPlayer();
            this.mc.displayGuiScreen(null);
        }
    }
    
    @Override
    public void initGui() {
        this.buttonList.clear();
        if (this.mc.theWorld.getWorldInfo().isHardcoreModeEnabled()) {
            if (this.mc.isIntegratedServerRunning()) {
                this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 96, I18n.format("deathScreen.deleteWorld", new Object[0])));
            }
            else {
                this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 96, I18n.format("deathScreen.leaveServer", new Object[0])));
            }
        }
        else {
            this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 72, I18n.format("deathScreen.respawn", new Object[0])));
            this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 96, I18n.format("deathScreen.titleScreen", new Object[0])));
            if (this.mc.getSession() == null) {
                this.buttonList.get(1).enabled = false;
            }
        }
        for (final GuiButton llllllllllllllllIIlIIlIllIlIlIll : this.buttonList) {
            llllllllllllllllIIlIIlIllIlIlIll.enabled = false;
        }
    }
    
    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
    
    static {
        __OBFID = "CL_00000690";
    }
    
    @Override
    public void drawScreen(final int llllllllllllllllIIlIIlIllIIIIllI, final int llllllllllllllllIIlIIlIllIIIlIll, final float llllllllllllllllIIlIIlIllIIIIlII) {
        this.drawGradientRect(0, 0, this.width, this.height, 1615855616, -1602211792);
        GlStateManager.pushMatrix();
        GlStateManager.scale(2.0f, 2.0f, 2.0f);
        final boolean llllllllllllllllIIlIIlIllIIIlIIl = this.mc.theWorld.getWorldInfo().isHardcoreModeEnabled();
        final String llllllllllllllllIIlIIlIllIIIlIII = llllllllllllllllIIlIIlIllIIIlIIl ? I18n.format("deathScreen.title.hardcore", new Object[0]) : I18n.format("deathScreen.title", new Object[0]);
        this.drawCenteredString(this.fontRendererObj, llllllllllllllllIIlIIlIllIIIlIII, this.width / 2 / 2, 30, 16777215);
        GlStateManager.popMatrix();
        if (llllllllllllllllIIlIIlIllIIIlIIl) {
            this.drawCenteredString(this.fontRendererObj, I18n.format("deathScreen.hardcoreInfo", new Object[0]), this.width / 2, 144, 16777215);
        }
        this.drawCenteredString(this.fontRendererObj, String.valueOf(new StringBuilder(String.valueOf(I18n.format("deathScreen.score", new Object[0]))).append(": ").append(EnumChatFormatting.YELLOW).append(this.mc.thePlayer.getScore())), this.width / 2, 100, 16777215);
        super.drawScreen(llllllllllllllllIIlIIlIllIIIIllI, llllllllllllllllIIlIIlIllIIIlIll, llllllllllllllllIIlIIlIllIIIIlII);
    }
    
    public GuiGameOver() {
        this.field_146346_f = false;
    }
    
    @Override
    public void updateScreen() {
        super.updateScreen();
        ++this.field_146347_a;
        if (this.field_146347_a == 20) {
            for (final GuiButton llllllllllllllllIIlIIlIlIlllllII : this.buttonList) {
                llllllllllllllllIIlIIlIlIlllllII.enabled = true;
            }
        }
    }
    
    @Override
    protected void keyTyped(final char llllllllllllllllIIlIIlIllIlIIlIl, final int llllllllllllllllIIlIIlIllIlIIlII) throws IOException {
    }
}
