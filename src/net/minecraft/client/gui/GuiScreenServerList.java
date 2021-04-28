package net.minecraft.client.gui;

import net.minecraft.client.multiplayer.*;
import java.io.*;
import org.lwjgl.input.*;
import net.minecraft.client.resources.*;

public class GuiScreenServerList extends GuiScreen
{
    private final /* synthetic */ ServerData field_146301_f;
    private /* synthetic */ GuiTextField field_146302_g;
    private final /* synthetic */ GuiScreen field_146303_a;
    
    static {
        __OBFID = "CL_00000692";
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllIIIlIIIIIIIlIIIlIl) throws IOException {
        if (llllllllllllllIIIlIIIIIIIlIIIlIl.enabled) {
            if (llllllllllllllIIIlIIIIIIIlIIIlIl.id == 1) {
                this.field_146303_a.confirmClicked(false, 0);
            }
            else if (llllllllllllllIIIlIIIIIIIlIIIlIl.id == 0) {
                this.field_146301_f.serverIP = this.field_146302_g.getText();
                this.field_146303_a.confirmClicked(true, 0);
            }
        }
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
        this.mc.gameSettings.lastServer = this.field_146302_g.getText();
        this.mc.gameSettings.saveOptions();
    }
    
    @Override
    public void updateScreen() {
        this.field_146302_g.updateCursorCounter();
    }
    
    @Override
    protected void mouseClicked(final int llllllllllllllIIIlIIIIIIIIllIIlI, final int llllllllllllllIIIlIIIIIIIIllIlIl, final int llllllllllllllIIIlIIIIIIIIllIlII) throws IOException {
        super.mouseClicked(llllllllllllllIIIlIIIIIIIIllIIlI, llllllllllllllIIIlIIIIIIIIllIlIl, llllllllllllllIIIlIIIIIIIIllIlII);
        this.field_146302_g.mouseClicked(llllllllllllllIIIlIIIIIIIIllIIlI, llllllllllllllIIIlIIIIIIIIllIlIl, llllllllllllllIIIlIIIIIIIIllIlII);
    }
    
    @Override
    protected void keyTyped(final char llllllllllllllIIIlIIIIIIIIllllIl, final int llllllllllllllIIIlIIIIIIIIllllll) throws IOException {
        if (this.field_146302_g.textboxKeyTyped(llllllllllllllIIIlIIIIIIIIllllIl, llllllllllllllIIIlIIIIIIIIllllll)) {
            this.buttonList.get(0).enabled = (this.field_146302_g.getText().length() > 0 && this.field_146302_g.getText().split(":").length > 0);
        }
        else if (llllllllllllllIIIlIIIIIIIIllllll == 28 || llllllllllllllIIIlIIIIIIIIllllll == 156) {
            this.actionPerformed(this.buttonList.get(0));
        }
    }
    
    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + 12, I18n.format("selectServer.select", new Object[0])));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 120 + 12, I18n.format("gui.cancel", new Object[0])));
        this.field_146302_g = new GuiTextField(2, this.fontRendererObj, this.width / 2 - 100, 116, 200, 20);
        this.field_146302_g.setMaxStringLength(128);
        this.field_146302_g.setFocused(true);
        this.field_146302_g.setText(this.mc.gameSettings.lastServer);
        this.buttonList.get(0).enabled = (this.field_146302_g.getText().length() > 0 && this.field_146302_g.getText().split(":").length > 0);
    }
    
    public GuiScreenServerList(final GuiScreen llllllllllllllIIIlIIIIIIIlIllIII, final ServerData llllllllllllllIIIlIIIIIIIlIlIlII) {
        this.field_146303_a = llllllllllllllIIIlIIIIIIIlIllIII;
        this.field_146301_f = llllllllllllllIIIlIIIIIIIlIlIlII;
    }
    
    @Override
    public void drawScreen(final int llllllllllllllIIIlIIIIIIIIlIIllI, final int llllllllllllllIIIlIIIIIIIIlIlIIl, final float llllllllllllllIIIlIIIIIIIIlIIlII) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, I18n.format("selectServer.direct", new Object[0]), this.width / 2, 20, 16777215);
        this.drawString(this.fontRendererObj, I18n.format("addServer.enterIp", new Object[0]), this.width / 2 - 100, 100, 10526880);
        this.field_146302_g.drawTextBox();
        super.drawScreen(llllllllllllllIIIlIIIIIIIIlIIllI, llllllllllllllIIIlIIIIIIIIlIlIIl, llllllllllllllIIIlIIIIIIIIlIIlII);
    }
}
