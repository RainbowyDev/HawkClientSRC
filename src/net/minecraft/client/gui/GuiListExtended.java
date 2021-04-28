package net.minecraft.client.gui;

import net.minecraft.client.*;

public abstract class GuiListExtended extends GuiSlot
{
    public boolean func_148179_a(final int llllllllllllllIIIlIIIIlllIIllIII, final int llllllllllllllIIIlIIIIlllIlIIIII, final int llllllllllllllIIIlIIIIlllIIlIllI) {
        if (this.isMouseYWithinSlotBounds(llllllllllllllIIIlIIIIlllIlIIIII)) {
            final int llllllllllllllIIIlIIIIlllIIllllI = this.getSlotIndexFromScreenCoords(llllllllllllllIIIlIIIIlllIIllIII, llllllllllllllIIIlIIIIlllIlIIIII);
            if (llllllllllllllIIIlIIIIlllIIllllI >= 0) {
                final int llllllllllllllIIIlIIIIlllIIlllIl = this.left + this.width / 2 - this.getListWidth() / 2 + 2;
                final int llllllllllllllIIIlIIIIlllIIlllII = this.top + 4 - this.getAmountScrolled() + llllllllllllllIIIlIIIIlllIIllllI * this.slotHeight + this.headerPadding;
                final int llllllllllllllIIIlIIIIlllIIllIll = llllllllllllllIIIlIIIIlllIIllIII - llllllllllllllIIIlIIIIlllIIlllIl;
                final int llllllllllllllIIIlIIIIlllIIllIlI = llllllllllllllIIIlIIIIlllIlIIIII - llllllllllllllIIIlIIIIlllIIlllII;
                if (this.getListEntry(llllllllllllllIIIlIIIIlllIIllllI).mousePressed(llllllllllllllIIIlIIIIlllIIllllI, llllllllllllllIIIlIIIIlllIIllIII, llllllllllllllIIIlIIIIlllIlIIIII, llllllllllllllIIIlIIIIlllIIlIllI, llllllllllllllIIIlIIIIlllIIllIll, llllllllllllllIIIlIIIIlllIIllIlI)) {
                    this.setEnabled(false);
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    protected void func_178040_a(final int llllllllllllllIIIlIIIIlllIlIlllI, final int llllllllllllllIIIlIIIIlllIlIllIl, final int llllllllllllllIIIlIIIIlllIlIllII) {
        this.getListEntry(llllllllllllllIIIlIIIIlllIlIlllI).setSelected(llllllllllllllIIIlIIIIlllIlIlllI, llllllllllllllIIIlIIIIlllIlIllIl, llllllllllllllIIIlIIIIlllIlIllII);
    }
    
    @Override
    protected boolean isSelected(final int llllllllllllllIIIlIIIIllllIIlllI) {
        return false;
    }
    
    static {
        __OBFID = "CL_00000674";
    }
    
    public boolean func_148181_b(final int llllllllllllllIIIlIIIIlllIIIIllI, final int llllllllllllllIIIlIIIIllIlllllII, final int llllllllllllllIIIlIIIIlllIIIIlII) {
        for (int llllllllllllllIIIlIIIIlllIIIIIll = 0; llllllllllllllIIIlIIIIlllIIIIIll < this.getSize(); ++llllllllllllllIIIlIIIIlllIIIIIll) {
            final int llllllllllllllIIIlIIIIlllIIIIIlI = this.left + this.width / 2 - this.getListWidth() / 2 + 2;
            final int llllllllllllllIIIlIIIIlllIIIIIIl = this.top + 4 - this.getAmountScrolled() + llllllllllllllIIIlIIIIlllIIIIIll * this.slotHeight + this.headerPadding;
            final int llllllllllllllIIIlIIIIlllIIIIIII = llllllllllllllIIIlIIIIlllIIIIllI - llllllllllllllIIIlIIIIlllIIIIIlI;
            final int llllllllllllllIIIlIIIIllIlllllll = llllllllllllllIIIlIIIIllIlllllII - llllllllllllllIIIlIIIIlllIIIIIIl;
            this.getListEntry(llllllllllllllIIIlIIIIlllIIIIIll).mouseReleased(llllllllllllllIIIlIIIIlllIIIIIll, llllllllllllllIIIlIIIIlllIIIIllI, llllllllllllllIIIlIIIIllIlllllII, llllllllllllllIIIlIIIIlllIIIIlII, llllllllllllllIIIlIIIIlllIIIIIII, llllllllllllllIIIlIIIIllIlllllll);
        }
        this.setEnabled(true);
        return false;
    }
    
    public GuiListExtended(final Minecraft llllllllllllllIIIlIIIIlllllIlIll, final int llllllllllllllIIIlIIIIllllIlllll, final int llllllllllllllIIIlIIIIllllIlllIl, final int llllllllllllllIIIlIIIIlllllIIlll, final int llllllllllllllIIIlIIIIlllllIIlIl, final int llllllllllllllIIIlIIIIllllIllIIl) {
        super(llllllllllllllIIIlIIIIlllllIlIll, llllllllllllllIIIlIIIIllllIlllll, llllllllllllllIIIlIIIIllllIlllIl, llllllllllllllIIIlIIIIlllllIIlll, llllllllllllllIIIlIIIIlllllIIlIl, llllllllllllllIIIlIIIIllllIllIIl);
    }
    
    @Override
    protected void drawSlot(final int llllllllllllllIIIlIIIIllllIIIlII, final int llllllllllllllIIIlIIIIlllIllllII, final int llllllllllllllIIIlIIIIlllIlllIll, final int llllllllllllllIIIlIIIIlllIlllIlI, final int llllllllllllllIIIlIIIIlllIlllIIl, final int llllllllllllllIIIlIIIIlllIlllIII) {
        this.getListEntry(llllllllllllllIIIlIIIIllllIIIlII).drawEntry(llllllllllllllIIIlIIIIllllIIIlII, llllllllllllllIIIlIIIIlllIllllII, llllllllllllllIIIlIIIIlllIlllIll, this.getListWidth(), llllllllllllllIIIlIIIIlllIlllIlI, llllllllllllllIIIlIIIIlllIlllIIl, llllllllllllllIIIlIIIIlllIlllIII, this.getSlotIndexFromScreenCoords(llllllllllllllIIIlIIIIlllIlllIIl, llllllllllllllIIIlIIIIlllIlllIII) == llllllllllllllIIIlIIIIllllIIIlII);
    }
    
    public abstract IGuiListEntry getListEntry(final int p0);
    
    @Override
    protected void elementClicked(final int llllllllllllllIIIlIIIIllllIlIlIl, final boolean llllllllllllllIIIlIIIIllllIlIlII, final int llllllllllllllIIIlIIIIllllIlIIlI, final int llllllllllllllIIIlIIIIllllIlIIII) {
    }
    
    @Override
    protected void drawBackground() {
    }
    
    public interface IGuiListEntry
    {
        void setSelected(final int p0, final int p1, final int p2);
        
        void mouseReleased(final int p0, final int p1, final int p2, final int p3, final int p4, final int p5);
        
        void drawEntry(final int p0, final int p1, final int p2, final int p3, final int p4, final int p5, final int p6, final boolean p7);
        
        boolean mousePressed(final int p0, final int p1, final int p2, final int p3, final int p4, final int p5);
    }
}
