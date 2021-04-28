package net.minecraft.realms;

import net.minecraft.client.gui.*;
import net.minecraft.client.*;

public class RealmsEditBox
{
    private final /* synthetic */ GuiTextField editBox;
    
    public void mouseClicked(final int llllllllllllllIIIIlllIllllIlIIll, final int llllllllllllllIIIIlllIllllIlIllI, final int llllllllllllllIIIIlllIllllIlIlIl) {
        this.editBox.mouseClicked(llllllllllllllIIIIlllIllllIlIIll, llllllllllllllIIIIlllIllllIlIllI, llllllllllllllIIIIlllIllllIlIlIl);
    }
    
    public void setValue(final String llllllllllllllIIIIlllIlllllIlIIl) {
        this.editBox.setText(llllllllllllllIIIIlllIlllllIlIIl);
    }
    
    static {
        __OBFID = "CL_00001858";
    }
    
    public boolean isFocused() {
        return this.editBox.isFocused();
    }
    
    public void render() {
        this.editBox.drawTextBox();
    }
    
    public void keyPressed(final char llllllllllllllIIIIlllIlllllIIIIl, final int llllllllllllllIIIIlllIlllllIIIll) {
        this.editBox.textboxKeyTyped(llllllllllllllIIIIlllIlllllIIIIl, llllllllllllllIIIIlllIlllllIIIll);
    }
    
    public void setFocus(final boolean llllllllllllllIIIIlllIlllllIllll) {
        this.editBox.setFocused(llllllllllllllIIIIlllIlllllIllll);
    }
    
    public void setMaxLength(final int llllllllllllllIIIIlllIllllIIlIlI) {
        this.editBox.setMaxStringLength(llllllllllllllIIIIlllIllllIIlIlI);
    }
    
    public String getValue() {
        return this.editBox.getText();
    }
    
    public void tick() {
        this.editBox.updateCursorCounter();
    }
    
    public RealmsEditBox(final int llllllllllllllIIIIlllIllllllllll, final int llllllllllllllIIIIlllIlllllllllI, final int llllllllllllllIIIIlllIllllllllIl, final int llllllllllllllIIIIlllIllllllllII, final int llllllllllllllIIIIllllIIIIIIIIIl) {
        this.editBox = new GuiTextField(llllllllllllllIIIIlllIllllllllll, Minecraft.getMinecraft().fontRendererObj, llllllllllllllIIIIlllIlllllllllI, llllllllllllllIIIIlllIllllllllIl, llllllllllllllIIIIlllIllllllllII, llllllllllllllIIIIllllIIIIIIIIIl);
    }
    
    public void setIsEditable(final boolean llllllllllllllIIIIlllIllllIIIlII) {
        this.editBox.setEnabled(llllllllllllllIIIIlllIllllIIIlII);
    }
}
