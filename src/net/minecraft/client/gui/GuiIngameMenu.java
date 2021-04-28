package net.minecraft.client.gui;

import net.minecraft.client.multiplayer.*;
import net.minecraft.client.gui.achievement.*;
import java.io.*;
import net.minecraft.client.resources.*;

public class GuiIngameMenu extends GuiScreen
{
    private /* synthetic */ int field_146445_a;
    private /* synthetic */ int field_146444_f;
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllllllllIIIIlllIIIII) throws IOException {
        switch (llllllllllllllllllllIIIIlllIIIII.id) {
            case 0: {
                this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
                break;
            }
            case 1: {
                llllllllllllllllllllIIIIlllIIIII.enabled = false;
                this.mc.theWorld.sendQuittingDisconnectingPacket();
                this.mc.loadWorld(null);
                this.mc.displayGuiScreen(new GuiMainMenu());
                break;
            }
            case 4: {
                this.mc.displayGuiScreen(null);
                this.mc.setIngameFocus();
                break;
            }
            case 5: {
                this.mc.displayGuiScreen(new GuiAchievements(this, this.mc.thePlayer.getStatFileWriter()));
                break;
            }
            case 6: {
                this.mc.displayGuiScreen(new GuiStats(this, this.mc.thePlayer.getStatFileWriter()));
                break;
            }
            case 7: {
                this.mc.displayGuiScreen(new GuiShareToLan(this));
                break;
            }
        }
    }
    
    @Override
    public void updateScreen() {
        super.updateScreen();
        ++this.field_146444_f;
    }
    
    static {
        __OBFID = "CL_00000703";
    }
    
    @Override
    public void drawScreen(final int llllllllllllllllllllIIIIllIlIlll, final int llllllllllllllllllllIIIIllIlIIlI, final float llllllllllllllllllllIIIIllIlIlIl) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, I18n.format("menu.game", new Object[0]), this.width / 2, 40, 16777215);
        super.drawScreen(llllllllllllllllllllIIIIllIlIlll, llllllllllllllllllllIIIIllIlIIlI, llllllllllllllllllllIIIIllIlIlIl);
    }
    
    @Override
    public void initGui() {
        this.field_146445_a = 0;
        this.buttonList.clear();
        final byte llllllllllllllllllllIIIIlllIllII = -16;
        final boolean llllllllllllllllllllIIIIlllIlIll = true;
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 120 + llllllllllllllllllllIIIIlllIllII, I18n.format("menu.returnToMenu", new Object[0])));
        if (!this.mc.isIntegratedServerRunning()) {
            this.buttonList.get(0).displayString = I18n.format("menu.disconnect", new Object[0]);
        }
        this.buttonList.add(new GuiButton(4, this.width / 2 - 100, this.height / 4 + 24 + llllllllllllllllllllIIIIlllIllII, I18n.format("menu.returnToGame", new Object[0])));
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + llllllllllllllllllllIIIIlllIllII, 98, 20, I18n.format("menu.options", new Object[0])));
        final GuiButton llllllllllllllllllllIIIIlllIlIlI;
        this.buttonList.add(llllllllllllllllllllIIIIlllIlIlI = new GuiButton(7, this.width / 2 + 2, this.height / 4 + 96 + llllllllllllllllllllIIIIlllIllII, 98, 20, I18n.format("menu.shareToLan", new Object[0])));
        this.buttonList.add(new GuiButton(5, this.width / 2 - 100, this.height / 4 + 48 + llllllllllllllllllllIIIIlllIllII, 98, 20, I18n.format("gui.achievements", new Object[0])));
        this.buttonList.add(new GuiButton(6, this.width / 2 + 2, this.height / 4 + 48 + llllllllllllllllllllIIIIlllIllII, 98, 20, I18n.format("gui.stats", new Object[0])));
        llllllllllllllllllllIIIIlllIlIlI.enabled = (this.mc.isSingleplayer() && !this.mc.getIntegratedServer().getPublic());
    }
}
