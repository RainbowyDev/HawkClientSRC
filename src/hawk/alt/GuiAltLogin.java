package hawk.alt;

import java.io.*;
import net.minecraft.client.gui.*;
import org.lwjgl.input.*;
import net.minecraft.util.*;

public final class GuiAltLogin extends GuiScreen
{
    private /* synthetic */ PasswordField password;
    private /* synthetic */ AltLoginThread thread;
    private /* synthetic */ GuiTextField username;
    private final /* synthetic */ GuiScreen previousScreen;
    
    @Override
    protected void mouseClicked(final int lllllllllllllllIllIIllllIIIIIIll, final int lllllllllllllllIllIIllllIIIIIIlI, final int lllllllllllllllIllIIllllIIIIIllI) {
        try {
            super.mouseClicked(lllllllllllllllIllIIllllIIIIIIll, lllllllllllllllIllIIllllIIIIIIlI, lllllllllllllllIllIIllllIIIIIllI);
        }
        catch (IOException lllllllllllllllIllIIllllIIIIIlIl) {
            lllllllllllllllIllIIllllIIIIIlIl.printStackTrace();
        }
        this.username.mouseClicked(lllllllllllllllIllIIllllIIIIIIll, lllllllllllllllIllIIllllIIIIIIlI, lllllllllllllllIllIIllllIIIIIllI);
        this.password.mouseClicked(lllllllllllllllIllIIllllIIIIIIll, lllllllllllllllIllIIllllIIIIIIlI, lllllllllllllllIllIIllllIIIIIllI);
    }
    
    @Override
    protected void keyTyped(final char lllllllllllllllIllIIllllIIIlIIIl, final int lllllllllllllllIllIIllllIIIlIlII) {
        try {
            super.keyTyped(lllllllllllllllIllIIllllIIIlIIIl, lllllllllllllllIllIIllllIIIlIlII);
        }
        catch (IOException lllllllllllllllIllIIllllIIIlIIll) {
            lllllllllllllllIllIIllllIIIlIIll.printStackTrace();
        }
        if (lllllllllllllllIllIIllllIIIlIIIl == '\t') {
            if (!this.username.isFocused() && !this.password.isFocused()) {
                this.username.setFocused(true);
            }
            else {
                this.username.setFocused(this.password.isFocused());
                this.password.setFocused(!this.username.isFocused());
            }
        }
        if (lllllllllllllllIllIIllllIIIlIIIl == '\r') {
            this.actionPerformed(this.buttonList.get(0));
        }
        this.username.textboxKeyTyped(lllllllllllllllIllIIllllIIIlIIIl, lllllllllllllllIllIIllllIIIlIlII);
        this.password.textboxKeyTyped(lllllllllllllllIllIIllllIIIlIIIl, lllllllllllllllIllIIllllIIIlIlII);
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }
    
    @Override
    public void drawScreen(final int lllllllllllllllIllIIllllIIlIIlll, final int lllllllllllllllIllIIllllIIlIIllI, final float lllllllllllllllIllIIllllIIlIIlIl) {
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
        super.drawScreen(lllllllllllllllIllIIllllIIlIIlll, lllllllllllllllIllIIllllIIlIIllI, lllllllllllllllIllIIllllIIlIIlIl);
    }
    
    public GuiAltLogin(final GuiScreen lllllllllllllllIllIIllllIIllIIll) {
        this.previousScreen = lllllllllllllllIllIIllllIIllIIll;
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllllIllIIllllIIlIllIl) {
        switch (lllllllllllllllIllIIllllIIlIllIl.id) {
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
    
    @Override
    public void initGui() {
        final int lllllllllllllllIllIIllllIIIlllIl = this.height / 4 + 24;
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, lllllllllllllllIllIIllllIIIlllIl + 72 + 12, "Login"));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, lllllllllllllllIllIIllllIIIlllIl + 72 + 12 + 24, "Back"));
        this.username = new GuiTextField(lllllllllllllllIllIIllllIIIlllIl, this.mc.fontRendererObj, this.width / 2 - 100, 60, 200, 20);
        this.password = new PasswordField(this.mc.fontRendererObj, this.width / 2 - 100, 100, 200, 20);
        this.username.setFocused(true);
        Keyboard.enableRepeatEvents(true);
    }
    
    @Override
    public void updateScreen() {
        this.username.updateCursorCounter();
        this.password.updateCursorCounter();
    }
}
