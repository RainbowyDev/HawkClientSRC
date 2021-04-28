package net.minecraft.realms;

import net.minecraft.util.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.*;

public class RealmsButton
{
    private /* synthetic */ GuiButtonRealmsProxy proxy;
    
    public int getWidth() {
        return this.proxy.getButtonWidth();
    }
    
    public void renderBg(final int llllllllllllllIllllllIIIllllIIII, final int llllllllllllllIllllllIIIlllIllll) {
    }
    
    public void active(final boolean llllllllllllllIllllllIIlIIlIlIII) {
        this.proxy.setEnabled(llllllllllllllIllllllIIlIIlIlIII);
    }
    
    static {
        __OBFID = "CL_00001890";
        WIDGETS_LOCATION = new ResourceLocation("textures/gui/widgets.png");
    }
    
    public int getYImage(final boolean llllllllllllllIllllllIIIlllIlIIl) {
        return this.proxy.func_154312_c(llllllllllllllIllllllIIIlllIlIIl);
    }
    
    public void msg(final String llllllllllllllIllllllIIlIIlIIIIl) {
        this.proxy.setText(llllllllllllllIllllllIIlIIlIIIIl);
    }
    
    public RealmsButton(final int llllllllllllllIllllllIIlIlIIlIlI, final int llllllllllllllIllllllIIlIlIlIllI, final int llllllllllllllIllllllIIlIlIlIlII, final int llllllllllllllIllllllIIlIlIlIIlI, final int llllllllllllllIllllllIIlIlIIIlII, final String llllllllllllllIllllllIIlIlIIlllI) {
        this.proxy = new GuiButtonRealmsProxy(this, llllllllllllllIllllllIIlIlIIlIlI, llllllllllllllIllllllIIlIlIlIllI, llllllllllllllIllllllIIlIlIlIlII, llllllllllllllIllllllIIlIlIIlllI, llllllllllllllIllllllIIlIlIlIIlI, llllllllllllllIllllllIIlIlIIIlII);
    }
    
    public int y() {
        return this.proxy.getPositionY();
    }
    
    public void blit(final int llllllllllllllIllllllIIIllllIlll, final int llllllllllllllIllllllIIIllllIllI, final int llllllllllllllIllllllIIIllllllII, final int llllllllllllllIllllllIIIlllllIll, final int llllllllllllllIllllllIIIlllllIlI, final int llllllllllllllIllllllIIIllllIIlI) {
        this.proxy.drawTexturedModalRect(llllllllllllllIllllllIIIllllIlll, llllllllllllllIllllllIIIllllIllI, llllllllllllllIllllllIIIllllllII, llllllllllllllIllllllIIIlllllIll, llllllllllllllIllllllIIIlllllIlI, llllllllllllllIllllllIIIllllIIlI);
    }
    
    public boolean active() {
        return this.proxy.getEnabled();
    }
    
    public GuiButton getProxy() {
        return this.proxy;
    }
    
    public void released(final int llllllllllllllIllllllIIlIIIIlIII, final int llllllllllllllIllllllIIlIIIIIlll) {
    }
    
    public void render(final int llllllllllllllIllllllIIlIIIlIIIl, final int llllllllllllllIllllllIIlIIIlIIII) {
        this.proxy.drawButton(Minecraft.getMinecraft(), llllllllllllllIllllllIIlIIIlIIIl, llllllllllllllIllllllIIlIIIlIIII);
    }
    
    public void clicked(final int llllllllllllllIllllllIIlIIIIlIll, final int llllllllllllllIllllllIIlIIIIlIlI) {
    }
    
    public int getHeight() {
        return this.proxy.func_175232_g();
    }
    
    public int id() {
        return this.proxy.getId();
    }
    
    public RealmsButton(final int llllllllllllllIllllllIIlIllIIlIl, final int llllllllllllllIllllllIIlIllIIlII, final int llllllllllllllIllllllIIlIllIlIll, final String llllllllllllllIllllllIIlIllIlIIl) {
        this.proxy = new GuiButtonRealmsProxy(this, llllllllllllllIllllllIIlIllIIlIl, llllllllllllllIllllllIIlIllIIlII, llllllllllllllIllllllIIlIllIlIll, llllllllllllllIllllllIIlIllIlIIl);
    }
}
