package alts;

import net.minecraft.client.gui.*;
import net.minecraft.util.*;
import java.io.*;

public class GuiRenameAlt extends GuiScreen
{
    private /* synthetic */ GuiTextField nameField;
    private /* synthetic */ String status;
    private final /* synthetic */ GuiAltManager manager;
    private /* synthetic */ PasswordField pwField;
    
    public void actionPerformed(final GuiButton llllllllllllllIlIllIIllllIllIllI) {
        switch (llllllllllllllIlIllIIllllIllIllI.id) {
            case 1: {
                this.mc.displayGuiScreen(this.manager);
                break;
            }
            case 0: {
                this.manager.selectedAlt.setMask(this.nameField.getText());
                this.manager.selectedAlt.setPassword(this.pwField.getText());
                this.status = "Edited!";
                break;
            }
        }
    }
    
    @Override
    public void drawScreen(final int llllllllllllllIlIllIIllllIllIIII, final int llllllllllllllIlIllIIllllIlIlIll, final float llllllllllllllIlIllIIllllIlIlllI) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, "Edit Alt", this.width / 2, 10, -1);
        this.drawCenteredString(this.fontRendererObj, this.status, this.width / 2, 20, -1);
        this.nameField.drawTextBox();
        this.pwField.drawTextBox();
        if (this.nameField.getText().isEmpty()) {
            this.drawString(this.mc.fontRendererObj, "New name", this.width / 2 - 96, 66, -7829368);
        }
        if (this.pwField.getText().isEmpty()) {
            this.drawString(this.mc.fontRendererObj, "New password", this.width / 2 - 96, 106, -7829368);
        }
        super.drawScreen(llllllllllllllIlIllIIllllIllIIII, llllllllllllllIlIllIIllllIlIlIll, llllllllllllllIlIllIIllllIlIlllI);
    }
    
    @Override
    protected void keyTyped(final char llllllllllllllIlIllIIllllIIlllll, final int llllllllllllllIlIllIIllllIIllllI) {
        this.nameField.textboxKeyTyped(llllllllllllllIlIllIIllllIIlllll, llllllllllllllIlIllIIllllIIllllI);
        this.pwField.textboxKeyTyped(llllllllllllllIlIllIIllllIIlllll, llllllllllllllIlIllIIllllIIllllI);
        if (llllllllllllllIlIllIIllllIIlllll == '\t' && (this.nameField.isFocused() || this.pwField.isFocused())) {
            this.nameField.setFocused(!this.nameField.isFocused());
            this.pwField.setFocused(!this.pwField.isFocused());
        }
        if (llllllllllllllIlIllIIllllIIlllll == '\r') {
            this.actionPerformed(this.buttonList.get(0));
        }
    }
    
    public GuiRenameAlt(final GuiAltManager llllllllllllllIlIllIIllllIllllII) {
        this.status = String.valueOf(new StringBuilder().append(EnumChatFormatting.GRAY).append("Waiting..."));
        this.manager = llllllllllllllIlIllIIllllIllllII;
    }
    
    @Override
    protected void mouseClicked(final int llllllllllllllIlIllIIllllIIlIlll, final int llllllllllllllIlIllIIllllIIlIllI, final int llllllllllllllIlIllIIllllIIlIIII) {
        try {
            super.mouseClicked(llllllllllllllIlIllIIllllIIlIlll, llllllllllllllIlIllIIllllIIlIllI, llllllllllllllIlIllIIllllIIlIIII);
        }
        catch (IOException llllllllllllllIlIllIIllllIIlIlII) {
            llllllllllllllIlIllIIllllIIlIlII.printStackTrace();
        }
        this.nameField.mouseClicked(llllllllllllllIlIllIIllllIIlIlll, llllllllllllllIlIllIIllllIIlIllI, llllllllllllllIlIllIIllllIIlIIII);
        this.pwField.mouseClicked(llllllllllllllIlIllIIllllIIlIlll, llllllllllllllIlIllIIllllIIlIllI, llllllllllllllIlIllIIllllIIlIIII);
    }
    
    @Override
    public void initGui() {
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 92 + 12, "Edit"));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 116 + 12, "Cancel"));
        this.nameField = new GuiTextField(this.eventButton, this.mc.fontRendererObj, this.width / 2 - 100, 60, 200, 20);
        this.pwField = new PasswordField(this.mc.fontRendererObj, this.width / 2 - 100, 100, 200, 20);
    }
}
