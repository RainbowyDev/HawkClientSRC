package net.minecraft.client.gui;

import net.minecraft.realms.*;
import net.minecraft.client.*;

public class GuiButtonRealmsProxy extends GuiButton
{
    private /* synthetic */ RealmsButton field_154318_o;
    
    public int getPositionY() {
        return super.yPosition;
    }
    
    @Override
    public boolean mousePressed(final Minecraft llllllllllllllIlIlIIlIIIIllllIII, final int llllllllllllllIlIlIIlIIIIlllIlll, final int llllllllllllllIlIlIIlIIIIlllIIlI) {
        if (super.mousePressed(llllllllllllllIlIlIIlIIIIllllIII, llllllllllllllIlIlIIlIIIIlllIlll, llllllllllllllIlIlIIlIIIIlllIIlI)) {
            this.field_154318_o.clicked(llllllllllllllIlIlIIlIIIIlllIlll, llllllllllllllIlIlIIlIIIIlllIIlI);
        }
        return super.mousePressed(llllllllllllllIlIlIIlIIIIllllIII, llllllllllllllIlIlIIlIIIIlllIlll, llllllllllllllIlIlIIlIIIIlllIIlI);
    }
    
    public int getId() {
        return super.id;
    }
    
    static {
        __OBFID = "CL_00001848";
    }
    
    public void setEnabled(final boolean llllllllllllllIlIlIIlIIIlIIllIlI) {
        super.enabled = llllllllllllllIlIlIIlIIIlIIllIlI;
    }
    
    public GuiButtonRealmsProxy(final RealmsButton llllllllllllllIlIlIIlIIIlIllIlII, final int llllllllllllllIlIlIIlIIIlIlIlIll, final int llllllllllllllIlIlIIlIIIlIlIlIlI, final int llllllllllllllIlIlIIlIIIlIlIlIIl, final String llllllllllllllIlIlIIlIIIlIlIlIII, final int llllllllllllllIlIlIIlIIIlIlIllll, final int llllllllllllllIlIlIIlIIIlIlIIllI) {
        super(llllllllllllllIlIlIIlIIIlIlIlIll, llllllllllllllIlIlIIlIIIlIlIlIlI, llllllllllllllIlIlIIlIIIlIlIlIIl, llllllllllllllIlIlIIlIIIlIlIllll, llllllllllllllIlIlIIlIIIlIlIIllI, llllllllllllllIlIlIIlIIIlIlIlIII);
        this.field_154318_o = llllllllllllllIlIlIIlIIIlIllIlII;
    }
    
    public void setText(final String llllllllllllllIlIlIIlIIIlIIIllIl) {
        super.displayString = llllllllllllllIlIlIIlIIIlIIIllIl;
    }
    
    public int func_175232_g() {
        return this.height;
    }
    
    public void mouseDragged(final Minecraft llllllllllllllIlIlIIlIIIIlIlIIlI, final int llllllllllllllIlIlIIlIIIIlIIllIl, final int llllllllllllllIlIlIIlIIIIlIIllII) {
        this.field_154318_o.renderBg(llllllllllllllIlIlIIlIIIIlIIllIl, llllllllllllllIlIlIIlIIIIlIIllII);
    }
    
    public GuiButtonRealmsProxy(final RealmsButton llllllllllllllIlIlIIlIIIllIIIIlI, final int llllllllllllllIlIlIIlIIIllIIIIIl, final int llllllllllllllIlIlIIlIIIllIIIllI, final int llllllllllllllIlIlIIlIIIlIllllll, final String llllllllllllllIlIlIIlIIIllIIIlII) {
        super(llllllllllllllIlIlIIlIIIllIIIIIl, llllllllllllllIlIlIIlIIIllIIIllI, llllllllllllllIlIlIIlIIIlIllllll, llllllllllllllIlIlIIlIIIllIIIlII);
        this.field_154318_o = llllllllllllllIlIlIIlIIIllIIIIlI;
    }
    
    public boolean getEnabled() {
        return super.enabled;
    }
    
    @Override
    public void mouseReleased(final int llllllllllllllIlIlIIlIIIIllIIIII, final int llllllllllllllIlIlIIlIIIIllIIlII) {
        this.field_154318_o.released(llllllllllllllIlIlIIlIIIIllIIIII, llllllllllllllIlIlIIlIIIIllIIlII);
    }
    
    @Override
    public int getButtonWidth() {
        return super.getButtonWidth();
    }
    
    public int getHoverState(final boolean llllllllllllllIlIlIIlIIIIIlllIIl) {
        return this.field_154318_o.getYImage(llllllllllllllIlIlIIlIIIIIlllIIl);
    }
    
    public RealmsButton getRealmsButton() {
        return this.field_154318_o;
    }
    
    public int func_154312_c(final boolean llllllllllllllIlIlIIlIIIIIlIllII) {
        return super.getHoverState(llllllllllllllIlIlIIlIIIIIlIllII);
    }
}
