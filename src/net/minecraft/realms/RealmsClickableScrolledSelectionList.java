package net.minecraft.realms;

import net.minecraft.client.gui.*;

public class RealmsClickableScrolledSelectionList
{
    private final /* synthetic */ GuiClickableScrolledSelectionListProxy proxy;
    
    public void customMouseEvent(final int llllllllllllllllIlIllllIllllllII, final int llllllllllllllllIlIllllIlllllIll, final int llllllllllllllllIlIllllIlllllIlI, final float llllllllllllllllIlIllllIlllllIIl, final int llllllllllllllllIlIllllIlllllIII) {
    }
    
    public void scroll(final int llllllllllllllllIlIllllIllllIlII) {
        this.proxy.scrollBy(llllllllllllllllIlIllllIllllIlII);
    }
    
    public int ym() {
        return this.proxy.func_178042_f();
    }
    
    public void render(final int llllllllllllllllIlIlllllIIllIllI, final int llllllllllllllllIlIlllllIIllIlIl, final float llllllllllllllllIlIlllllIIlllIII) {
        this.proxy.drawScreen(llllllllllllllllIlIlllllIIllIllI, llllllllllllllllIlIlllllIIllIlIl, llllllllllllllllIlIlllllIIlllIII);
    }
    
    public int getItemCount() {
        return 0;
    }
    
    public void setLeftPos(final int llllllllllllllllIlIllllIllIllIIl) {
        this.proxy.setSlotXBoundsFromLeft(llllllllllllllllIlIllllIllIllIIl);
    }
    
    public int width() {
        return this.proxy.func_178044_e();
    }
    
    static {
        __OBFID = "CL_00002366";
    }
    
    public int xm() {
        return this.proxy.func_178045_g();
    }
    
    public void selectItem(final int llllllllllllllllIlIlllllIIIIlIll, final boolean llllllllllllllllIlIlllllIIIIlIlI, final int llllllllllllllllIlIlllllIIIIlIIl, final int llllllllllllllllIlIlllllIIIIlIII) {
    }
    
    protected void renderItem(final int llllllllllllllllIlIlllllIIlIlIIl, final int llllllllllllllllIlIlllllIIlIlIII, final int llllllllllllllllIlIlllllIIlIIlll, final int llllllllllllllllIlIlllllIIlIIllI, final Tezzelator llllllllllllllllIlIlllllIIlIIlIl, final int llllllllllllllllIlIlllllIIlIIlII, final int llllllllllllllllIlIlllllIIlIIIll) {
    }
    
    public void renderSelected(final int llllllllllllllllIlIllllIlllIIIlI, final int llllllllllllllllIlIllllIlllIIIIl, final int llllllllllllllllIlIllllIlllIIIII, final Tezzelator llllllllllllllllIlIllllIllIlllll) {
    }
    
    public boolean isSelectedItem(final int llllllllllllllllIlIlllllIIIIIllI) {
        return false;
    }
    
    public int getScroll() {
        return this.proxy.getAmountScrolled();
    }
    
    public RealmsClickableScrolledSelectionList(final int llllllllllllllllIlIlllllIlIIIlII, final int llllllllllllllllIlIlllllIlIIIIll, final int llllllllllllllllIlIlllllIlIIlIII, final int llllllllllllllllIlIlllllIlIIIIIl, final int llllllllllllllllIlIlllllIlIIIllI) {
        this.proxy = new GuiClickableScrolledSelectionListProxy(this, llllllllllllllllIlIlllllIlIIIlII, llllllllllllllllIlIlllllIlIIIIll, llllllllllllllllIlIlllllIlIIlIII, llllllllllllllllIlIlllllIlIIIIIl, llllllllllllllllIlIlllllIlIIIllI);
    }
    
    public void itemClicked(final int llllllllllllllllIlIllllIlllIlIII, final int llllllllllllllllIlIllllIlllIIlll, final int llllllllllllllllIlIllllIlllIIllI, final int llllllllllllllllIlIllllIlllIIlIl, final int llllllllllllllllIlIllllIlllIIlII) {
    }
    
    public void renderItem(final int llllllllllllllllIlIlllllIIIllIlI, final int llllllllllllllllIlIlllllIIIllIIl, final int llllllllllllllllIlIlllllIIIllIII, final int llllllllllllllllIlIlllllIIIlIlll, final int llllllllllllllllIlIlllllIIIIllll, final int llllllllllllllllIlIlllllIIIIlllI) {
        this.renderItem(llllllllllllllllIlIlllllIIIllIlI, llllllllllllllllIlIlllllIIIllIIl, llllllllllllllllIlIlllllIIIllIII, llllllllllllllllIlIlllllIIIlIlll, Tezzelator.instance, llllllllllllllllIlIlllllIIIIllll, llllllllllllllllIlIlllllIIIIlllI);
    }
    
    public int getScrollbarPosition() {
        return this.proxy.func_178044_e() / 2 + 124;
    }
    
    public void renderBackground() {
    }
    
    protected void renderList(final int llllllllllllllllIlIllllIlllIllIl, final int llllllllllllllllIlIllllIlllIllII, final int llllllllllllllllIlIllllIlllIlIll, final int llllllllllllllllIlIllllIlllIlIlI) {
    }
    
    public void mouseEvent() {
        this.proxy.func_178039_p();
    }
    
    public int getMaxPosition() {
        return 0;
    }
}
