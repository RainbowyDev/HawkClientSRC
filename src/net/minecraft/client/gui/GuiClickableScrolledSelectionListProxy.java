package net.minecraft.client.gui;

import net.minecraft.client.*;
import net.minecraft.realms.*;
import org.lwjgl.input.*;

public class GuiClickableScrolledSelectionListProxy extends GuiSlot
{
    private final /* synthetic */ RealmsClickableScrolledSelectionList field_178046_u;
    
    public GuiClickableScrolledSelectionListProxy(final RealmsClickableScrolledSelectionList lIlIlIllIllll, final int lIlIlIlllIlIl, final int lIlIlIlllIlII, final int lIlIlIllIllII, final int lIlIlIlllIIlI, final int lIlIlIlllIIIl) {
        super(Minecraft.getMinecraft(), lIlIlIlllIlIl, lIlIlIlllIlII, lIlIlIllIllII, lIlIlIlllIIlI, lIlIlIlllIIIl);
        this.field_178046_u = lIlIlIllIllll;
    }
    
    @Override
    protected void drawBackground() {
        this.field_178046_u.renderBackground();
    }
    
    @Override
    protected int getContentHeight() {
        return this.field_178046_u.getMaxPosition();
    }
    
    @Override
    protected boolean isSelected(final int lIlIlIlIlIlII) {
        return this.field_178046_u.isSelectedItem(lIlIlIlIlIlII);
    }
    
    @Override
    protected int getSize() {
        return this.field_178046_u.getItemCount();
    }
    
    @Override
    protected void drawSlot(final int lIlIlIlIIIllI, final int lIlIlIlIIIlIl, final int lIlIlIlIIIlII, final int lIlIlIIllllII, final int lIlIlIIlllIll, final int lIlIlIlIIIIIl) {
        this.field_178046_u.renderItem(lIlIlIlIIIllI, lIlIlIlIIIlIl, lIlIlIlIIIlII, lIlIlIIllllII, lIlIlIIlllIll, lIlIlIlIIIIIl);
    }
    
    static {
        __OBFID = "CL_00001939";
    }
    
    public int func_178045_g() {
        return super.mouseX;
    }
    
    @Override
    protected void drawSelectionBox(final int lIlIlIIIIlllI, final int lIlIlIIIIllIl, final int lIlIlIIIIllII, final int lIlIlIIIIlIll) {
        for (int lIlIlIIIIlIlI = this.getSize(), lIlIlIIIIlIIl = 0; lIlIlIIIIlIIl < lIlIlIIIIlIlI; ++lIlIlIIIIlIIl) {
            final int lIlIlIIIIlIII = lIlIlIIIIllIl + lIlIlIIIIlIIl * this.slotHeight + this.headerPadding;
            final int lIlIlIIIIIlll = this.slotHeight - 4;
            if (lIlIlIIIIlIII > this.bottom || lIlIlIIIIlIII + lIlIlIIIIIlll < this.top) {
                this.func_178040_a(lIlIlIIIIlIIl, lIlIlIIIIlllI, lIlIlIIIIlIII);
            }
            if (this.showSelectionBox && this.isSelected(lIlIlIIIIlIIl)) {
                this.func_178043_a(this.width, lIlIlIIIIlIII, lIlIlIIIIIlll, Tezzelator.instance);
            }
            this.drawSlot(lIlIlIIIIlIIl, lIlIlIIIIlllI, lIlIlIIIIlIII, lIlIlIIIIIlll, lIlIlIIIIllII, lIlIlIIIIlIll);
        }
    }
    
    @Override
    public void func_178039_p() {
        super.func_178039_p();
        if (this.scrollMultiplier > 0.0f && Mouse.getEventButtonState()) {
            this.field_178046_u.customMouseEvent(this.top, this.bottom, this.headerPadding, this.amountScrolled, this.slotHeight);
        }
    }
    
    public int func_178042_f() {
        return super.mouseY;
    }
    
    @Override
    protected int getScrollBarX() {
        return this.field_178046_u.getScrollbarPosition();
    }
    
    @Override
    protected void elementClicked(final int lIlIlIllIIIII, final boolean lIlIlIlIllIlI, final int lIlIlIlIllIIl, final int lIlIlIlIlllIl) {
        this.field_178046_u.selectItem(lIlIlIllIIIII, lIlIlIlIllIlI, lIlIlIlIllIIl, lIlIlIlIlllIl);
    }
    
    public void func_178043_a(final int lIlIlIIlIIIIl, final int lIlIlIIlIIIII, final int lIlIlIIIllIlI, final Tezzelator lIlIlIIIllIIl) {
        this.field_178046_u.renderSelected(lIlIlIIlIIIIl, lIlIlIIlIIIII, lIlIlIIIllIlI, lIlIlIIIllIIl);
    }
    
    public int func_178044_e() {
        return super.width;
    }
}
