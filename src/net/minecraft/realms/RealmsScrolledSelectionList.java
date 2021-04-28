package net.minecraft.realms;

import net.minecraft.client.gui.*;

public class RealmsScrolledSelectionList
{
    private final /* synthetic */ GuiSlotRealmsProxy proxy;
    
    public void renderBackground() {
    }
    
    public void mouseEvent() {
        this.proxy.func_178039_p();
    }
    
    public void renderItem(final int llllllllllllllIlIIIIIlIlIllIllll, final int llllllllllllllIlIIIIIlIlIllIIlll, final int llllllllllllllIlIIIIIlIlIllIIllI, final int llllllllllllllIlIIIIIlIlIllIIlIl, final int llllllllllllllIlIIIIIlIlIllIIlII, final int llllllllllllllIlIIIIIlIlIllIIIll) {
        this.renderItem(llllllllllllllIlIIIIIlIlIllIllll, llllllllllllllIlIIIIIlIlIllIIlll, llllllllllllllIlIIIIIlIlIllIIllI, llllllllllllllIlIIIIIlIlIllIIlIl, Tezzelator.instance, llllllllllllllIlIIIIIlIlIllIIlII, llllllllllllllIlIIIIIlIlIllIIIll);
    }
    
    public int getItemCount() {
        return 0;
    }
    
    protected void renderItem(final int llllllllllllllIlIIIIIlIlIllllllI, final int llllllllllllllIlIIIIIlIlIlllllIl, final int llllllllllllllIlIIIIIlIlIlllllII, final int llllllllllllllIlIIIIIlIlIllllIll, final Tezzelator llllllllllllllIlIIIIIlIlIllllIlI, final int llllllllllllllIlIIIIIlIlIllllIIl, final int llllllllllllllIlIIIIIlIlIllllIII) {
    }
    
    public int xm() {
        return this.proxy.func_154337_m();
    }
    
    public void scroll(final int llllllllllllllIlIIIIIlIlIlIIllll) {
        this.proxy.scrollBy(llllllllllllllIlIIIIIlIlIlIIllll);
    }
    
    static {
        __OBFID = "CL_00001863";
    }
    
    public void selectItem(final int llllllllllllllIlIIIIIlIlIllIIIII, final boolean llllllllllllllIlIIIIIlIlIlIlllll, final int llllllllllllllIlIIIIIlIlIlIllllI, final int llllllllllllllIlIIIIIlIlIlIlllIl) {
    }
    
    public int getScroll() {
        return this.proxy.getAmountScrolled();
    }
    
    public int width() {
        return this.proxy.func_154338_k();
    }
    
    public boolean isSelectedItem(final int llllllllllllllIlIIIIIlIlIlIllIll) {
        return false;
    }
    
    protected void renderList(final int llllllllllllllIlIIIIIlIlIlIIlIII, final int llllllllllllllIlIIIIIlIlIlIIIlll, final int llllllllllllllIlIIIIIlIlIlIIIllI, final int llllllllllllllIlIIIIIlIlIlIIIlIl) {
    }
    
    public int getMaxPosition() {
        return 0;
    }
    
    public void render(final int llllllllllllllIlIIIIIlIllIIIllll, final int llllllllllllllIlIIIIIlIllIIIlIlI, final float llllllllllllllIlIIIIIlIllIIIlIIl) {
        this.proxy.drawScreen(llllllllllllllIlIIIIIlIllIIIllll, llllllllllllllIlIIIIIlIllIIIlIlI, llllllllllllllIlIIIIIlIllIIIlIIl);
    }
    
    public RealmsScrolledSelectionList(final int llllllllllllllIlIIIIIlIllIIllIIl, final int llllllllllllllIlIIIIIlIllIIllIII, final int llllllllllllllIlIIIIIlIllIIlllIl, final int llllllllllllllIlIIIIIlIllIIlllII, final int llllllllllllllIlIIIIIlIllIIllIll) {
        this.proxy = new GuiSlotRealmsProxy(this, llllllllllllllIlIIIIIlIllIIllIIl, llllllllllllllIlIIIIIlIllIIllIII, llllllllllllllIlIIIIIlIllIIlllIl, llllllllllllllIlIIIIIlIllIIlllII, llllllllllllllIlIIIIIlIllIIllIll);
    }
    
    public int ym() {
        return this.proxy.func_154339_l();
    }
    
    public int getScrollbarPosition() {
        return this.proxy.func_154338_k() / 2 + 124;
    }
}
