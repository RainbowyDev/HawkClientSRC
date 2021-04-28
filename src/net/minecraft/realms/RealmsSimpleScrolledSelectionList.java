package net.minecraft.realms;

import net.minecraft.client.gui.*;

public class RealmsSimpleScrolledSelectionList
{
    private final /* synthetic */ GuiSimpleScrolledSelectionListProxy proxy;
    
    static {
        __OBFID = "CL_00002186";
    }
    
    public int getScrollbarPosition() {
        return this.proxy.func_178048_e() / 2 + 124;
    }
    
    public int xm() {
        return this.proxy.func_178049_g();
    }
    
    public int getItemCount() {
        return 0;
    }
    
    public int getScroll() {
        return this.proxy.getAmountScrolled();
    }
    
    protected void renderList(final int llllllllllllllllIlIIIlIIllIIIllI, final int llllllllllllllllIlIIIlIIllIIIlIl, final int llllllllllllllllIlIIIlIIllIIIlII, final int llllllllllllllllIlIIIlIIllIIIIll) {
    }
    
    protected void renderItem(final int llllllllllllllllIlIIIlIIllllllII, final int llllllllllllllllIlIIIlIIlllllIll, final int llllllllllllllllIlIIIlIIlllllIlI, final int llllllllllllllllIlIIIlIIlllllIIl, final Tezzelator llllllllllllllllIlIIIlIIlllllIII, final int llllllllllllllllIlIIIlIIllllIlll, final int llllllllllllllllIlIIIlIIllllIllI) {
    }
    
    public void renderBackground() {
    }
    
    public void render(final int llllllllllllllllIlIIIlIlIIIIllIl, final int llllllllllllllllIlIIIlIlIIIIllII, final float llllllllllllllllIlIIIlIlIIIIIlll) {
        this.proxy.drawScreen(llllllllllllllllIlIIIlIlIIIIllIl, llllllllllllllllIlIIIlIlIIIIllII, llllllllllllllllIlIIIlIlIIIIIlll);
    }
    
    public int getMaxPosition() {
        return 0;
    }
    
    public void scroll(final int llllllllllllllllIlIIIlIIllIIlIll) {
        this.proxy.scrollBy(llllllllllllllllIlIIIlIIllIIlIll);
    }
    
    public void selectItem(final int llllllllllllllllIlIIIlIIllIllllI, final boolean llllllllllllllllIlIIIlIIllIlllIl, final int llllllllllllllllIlIIIlIIllIlllII, final int llllllllllllllllIlIIIlIIllIllIll) {
    }
    
    public int ym() {
        return this.proxy.func_178047_f();
    }
    
    public void renderItem(final int llllllllllllllllIlIIIlIIlllIllIl, final int llllllllllllllllIlIIIlIIlllIIlIl, final int llllllllllllllllIlIIIlIIlllIIlII, final int llllllllllllllllIlIIIlIIlllIIIll, final int llllllllllllllllIlIIIlIIlllIlIIl, final int llllllllllllllllIlIIIlIIlllIlIII) {
        this.renderItem(llllllllllllllllIlIIIlIIlllIllIl, llllllllllllllllIlIIIlIIlllIIlIl, llllllllllllllllIlIIIlIIlllIIlII, llllllllllllllllIlIIIlIIlllIIIll, Tezzelator.instance, llllllllllllllllIlIIIlIIlllIlIIl, llllllllllllllllIlIIIlIIlllIlIII);
    }
    
    public boolean isSelectedItem(final int llllllllllllllllIlIIIlIIllIllIIl) {
        return false;
    }
    
    public RealmsSimpleScrolledSelectionList(final int llllllllllllllllIlIIIlIlIIIlIlll, final int llllllllllllllllIlIIIlIlIIIlIllI, final int llllllllllllllllIlIIIlIlIIIlIlIl, final int llllllllllllllllIlIIIlIlIIIlIlII, final int llllllllllllllllIlIIIlIlIIIlIIll) {
        this.proxy = new GuiSimpleScrolledSelectionListProxy(this, llllllllllllllllIlIIIlIlIIIlIlll, llllllllllllllllIlIIIlIlIIIlIllI, llllllllllllllllIlIIIlIlIIIlIlIl, llllllllllllllllIlIIIlIlIIIlIlII, llllllllllllllllIlIIIlIlIIIlIIll);
    }
    
    public void mouseEvent() {
        this.proxy.func_178039_p();
    }
    
    public int width() {
        return this.proxy.func_178048_e();
    }
}
