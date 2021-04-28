package net.minecraft.client.gui;

import net.minecraft.client.multiplayer.*;
import org.lwjgl.input.*;
import java.io.*;
import net.minecraft.client.resources.*;
import java.util.*;

public class GuiScreenAddServer extends GuiScreen
{
    private /* synthetic */ GuiTextField serverIPField;
    private /* synthetic */ GuiButton serverResourcePacks;
    private final /* synthetic */ GuiScreen parentScreen;
    private final /* synthetic */ ServerData serverData;
    private /* synthetic */ GuiTextField serverNameField;
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }
    
    @Override
    protected void keyTyped(final char lIlIIIllIIlllll, final int lIlIIIllIlIIIIl) throws IOException {
        this.serverNameField.textboxKeyTyped(lIlIIIllIIlllll, lIlIIIllIlIIIIl);
        this.serverIPField.textboxKeyTyped(lIlIIIllIIlllll, lIlIIIllIlIIIIl);
        if (lIlIIIllIlIIIIl == 15) {
            this.serverNameField.setFocused(!this.serverNameField.isFocused());
            this.serverIPField.setFocused(!this.serverIPField.isFocused());
        }
        if (lIlIIIllIlIIIIl == 28 || lIlIIIllIlIIIIl == 156) {
            this.actionPerformed(this.buttonList.get(0));
        }
        this.buttonList.get(0).enabled = (this.serverIPField.getText().length() > 0 && this.serverIPField.getText().split(":").length > 0 && this.serverNameField.getText().length() > 0);
    }
    
    @Override
    public void drawScreen(final int lIlIIIllIIIlIII, final int lIlIIIllIIIIlll, final float lIlIIIllIIIlIlI) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, I18n.format("addServer.title", new Object[0]), this.width / 2, 17, 16777215);
        this.drawString(this.fontRendererObj, I18n.format("addServer.enterName", new Object[0]), this.width / 2 - 100, 53, 10526880);
        this.drawString(this.fontRendererObj, I18n.format("addServer.enterIp", new Object[0]), this.width / 2 - 100, 94, 10526880);
        this.serverNameField.drawTextBox();
        this.serverIPField.drawTextBox();
        super.drawScreen(lIlIIIllIIIlIII, lIlIIIllIIIIlll, lIlIIIllIIIlIlI);
    }
    
    static {
        __OBFID = "CL_00000695";
    }
    
    @Override
    public void updateScreen() {
        this.serverNameField.updateCursorCounter();
        this.serverIPField.updateCursorCounter();
    }
    
    public GuiScreenAddServer(final GuiScreen lIlIIIllIllIlIl, final ServerData lIlIIIllIllIlll) {
        this.parentScreen = lIlIIIllIllIlIl;
        this.serverData = lIlIIIllIllIlll;
    }
    
    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + 18, I18n.format("addServer.add", new Object[0])));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 120 + 18, I18n.format("gui.cancel", new Object[0])));
        final List buttonList = this.buttonList;
        final GuiButton serverResourcePacks = new GuiButton(2, this.width / 2 - 100, this.height / 4 + 72, String.valueOf(new StringBuilder(String.valueOf(I18n.format("addServer.resourcePack", new Object[0]))).append(": ").append(this.serverData.getResourceMode().getMotd().getFormattedText())));
        this.serverResourcePacks = serverResourcePacks;
        buttonList.add(serverResourcePacks);
        this.serverNameField = new GuiTextField(0, this.fontRendererObj, this.width / 2 - 100, 66, 200, 20);
        this.serverNameField.setFocused(true);
        this.serverNameField.setText(this.serverData.serverName);
        this.serverIPField = new GuiTextField(1, this.fontRendererObj, this.width / 2 - 100, 106, 200, 20);
        this.serverIPField.setMaxStringLength(128);
        this.serverIPField.setText(this.serverData.serverIP);
        this.buttonList.get(0).enabled = (this.serverIPField.getText().length() > 0 && this.serverIPField.getText().split(":").length > 0 && this.serverNameField.getText().length() > 0);
    }
    
    @Override
    protected void mouseClicked(final int lIlIIIllIIllIII, final int lIlIIIllIIlIlll, final int lIlIIIllIIlIllI) throws IOException {
        super.mouseClicked(lIlIIIllIIllIII, lIlIIIllIIlIlll, lIlIIIllIIlIllI);
        this.serverIPField.mouseClicked(lIlIIIllIIllIII, lIlIIIllIIlIlll, lIlIIIllIIlIllI);
        this.serverNameField.mouseClicked(lIlIIIllIIllIII, lIlIIIllIIlIlll, lIlIIIllIIlIllI);
    }
    
    @Override
    protected void actionPerformed(final GuiButton lIlIIIllIlIlIIl) throws IOException {
        if (lIlIIIllIlIlIIl.enabled) {
            if (lIlIIIllIlIlIIl.id == 2) {
                this.serverData.setResourceMode(ServerData.ServerResourceMode.values()[(this.serverData.getResourceMode().ordinal() + 1) % ServerData.ServerResourceMode.values().length]);
                this.serverResourcePacks.displayString = String.valueOf(new StringBuilder(String.valueOf(I18n.format("addServer.resourcePack", new Object[0]))).append(": ").append(this.serverData.getResourceMode().getMotd().getFormattedText()));
            }
            else if (lIlIIIllIlIlIIl.id == 1) {
                this.parentScreen.confirmClicked(false, 0);
            }
            else if (lIlIIIllIlIlIIl.id == 0) {
                this.serverData.serverName = this.serverNameField.getText();
                this.serverData.serverIP = this.serverIPField.getText();
                this.parentScreen.confirmClicked(true, 0);
            }
        }
    }
}
