package alts;

import net.minecraft.client.gui.*;
import java.io.*;
import org.lwjgl.input.*;
import net.minecraft.util.*;

public final class GuiAltLogin extends GuiScreen
{
    private /* synthetic */ GuiTextField username;
    private /* synthetic */ PasswordField password;
    private /* synthetic */ AltLoginThread thread;
    private final /* synthetic */ GuiScreen previousScreen;
    
    @Override
    protected void actionPerformed(final GuiButton lIlIllllIIIIlI) {
        switch (lIlIllllIIIIlI.id) {
            case 1: {
                this.mc.displayGuiScreen(this.previousScreen);
                break;
            }
            case 0: {
                this.thread = new AltLoginThread(this.username.getText(), this.password.getText());
                this.thread.start();
                break;
            }
        }
    }
    
    public GuiAltLogin(final GuiScreen lIlIllllIIlIII) {
        this.previousScreen = lIlIllllIIlIII;
    }
    
    @Override
    protected void keyTyped(final char lIlIlllIlIlIlI, final int lIlIlllIlIIlIl) {
        try {
            super.keyTyped(lIlIlllIlIlIlI, lIlIlllIlIIlIl);
        }
        catch (IOException lIlIlllIlIlIII) {
            lIlIlllIlIlIII.printStackTrace();
        }
        if (lIlIlllIlIlIlI == '\t') {
            if (!this.username.isFocused() && !this.password.isFocused()) {
                this.username.setFocused(true);
            }
            else {
                this.username.setFocused(this.password.isFocused());
                this.password.setFocused(!this.username.isFocused());
            }
        }
        if (lIlIlllIlIlIlI == '\r') {
            this.actionPerformed(this.buttonList.get(0));
        }
        this.username.textboxKeyTyped(lIlIlllIlIlIlI, lIlIlllIlIIlIl);
        this.password.textboxKeyTyped(lIlIlllIlIlIlI, lIlIlllIlIIlIl);
    }
    
    @Override
    protected void mouseClicked(final int lIlIlllIIlllIl, final int lIlIlllIIlIlll, final int lIlIlllIIllIll) {
        try {
            super.mouseClicked(lIlIlllIIlllIl, lIlIlllIIlIlll, lIlIlllIIllIll);
        }
        catch (IOException lIlIlllIIllIlI) {
            lIlIlllIIllIlI.printStackTrace();
        }
        this.username.mouseClicked(lIlIlllIIlllIl, lIlIlllIIlIlll, lIlIlllIIllIll);
        this.password.mouseClicked(lIlIlllIIlllIl, lIlIlllIIlIlll, lIlIlllIIllIll);
    }
    
    @Override
    public void initGui() {
        final int lIlIlllIllIIlI = this.height / 4 + 24;
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, lIlIlllIllIIlI + 72 + 12, "Login"));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, lIlIlllIllIIlI + 72 + 12 + 24, "Back"));
        this.username = new GuiTextField(lIlIlllIllIIlI, this.mc.fontRendererObj, this.width / 2 - 100, 60, 200, 20);
        this.password = new PasswordField(this.mc.fontRendererObj, this.width / 2 - 100, 100, 200, 20);
        this.username.setFocused(true);
        Keyboard.enableRepeatEvents(true);
    }
    
    @Override
    public void updateScreen() {
        this.username.updateCursorCounter();
        this.password.updateCursorCounter();
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }
    
    @Override
    public void drawScreen(final int lIlIlllIlllIII, final int lIlIlllIllIlll, final float lIlIlllIlllIlI) {
        this.drawDefaultBackground();
        this.username.drawTextBox();
        this.password.drawTextBox();
        this.drawCenteredString(this.mc.fontRendererObj, "Alt Login", this.width / 2, 20, -1);
        this.drawCenteredString(this.mc.fontRendererObj, (this.thread == null) ? String.valueOf(new StringBuilder().append(EnumChatFormatting.GRAY).append("Idle...")) : this.thread.getStatus(), this.width / 2, 29, -1);
        if (this.username.getText().isEmpty()) {
            this.drawString(this.mc.fontRendererObj, "Username / E-Mail", this.width / 2 - 96, 66, -7829368);
        }
        if (this.password.getText().isEmpty()) {
            this.drawString(this.mc.fontRendererObj, "Password", this.width / 2 - 96, 106, -7829368);
        }
        super.drawScreen(lIlIlllIlllIII, lIlIlllIllIlll, lIlIlllIlllIlI);
    }
}
