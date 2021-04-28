package net.minecraft.client.gui;

import net.minecraft.realms.*;
import net.minecraft.client.*;

public class GuiSlotRealmsProxy extends GuiSlot
{
    private final /* synthetic */ RealmsScrolledSelectionList selectionList;
    
    @Override
    protected int getSize() {
        return this.selectionList.getItemCount();
    }
    
    static {
        __OBFID = "CL_00001846";
    }
    
    public int func_154338_k() {
        return super.width;
    }
    
    @Override
    protected int getContentHeight() {
        return this.selectionList.getMaxPosition();
    }
    
    @Override
    protected void drawBackground() {
        this.selectionList.renderBackground();
    }
    
    @Override
    protected int getScrollBarX() {
        return this.selectionList.getScrollbarPosition();
    }
    
    @Override
    protected void drawSlot(final int llllllllllllllllIllIIIIlIIIllIII, final int llllllllllllllllIllIIIIlIIIlIIII, final int llllllllllllllllIllIIIIlIIIlIllI, final int llllllllllllllllIllIIIIlIIIIlllI, final int llllllllllllllllIllIIIIlIIIIllIl, final int llllllllllllllllIllIIIIlIIIIllII) {
        this.selectionList.renderItem(llllllllllllllllIllIIIIlIIIllIII, llllllllllllllllIllIIIIlIIIlIIII, llllllllllllllllIllIIIIlIIIlIllI, llllllllllllllllIllIIIIlIIIIlllI, llllllllllllllllIllIIIIlIIIIllIl, llllllllllllllllIllIIIIlIIIIllII);
    }
    
    @Override
    protected void elementClicked(final int llllllllllllllllIllIIIIlIIlIllIl, final boolean llllllllllllllllIllIIIIlIIllIIIl, final int llllllllllllllllIllIIIIlIIlIlIll, final int llllllllllllllllIllIIIIlIIlIlIlI) {
        this.selectionList.selectItem(llllllllllllllllIllIIIIlIIlIllIl, llllllllllllllllIllIIIIlIIllIIIl, llllllllllllllllIllIIIIlIIlIlIll, llllllllllllllllIllIIIIlIIlIlIlI);
    }
    
    public int func_154339_l() {
        return super.mouseY;
    }
    
    public GuiSlotRealmsProxy(final RealmsScrolledSelectionList llllllllllllllllIllIIIIlIlIIlIII, final int llllllllllllllllIllIIIIlIlIIIIII, final int llllllllllllllllIllIIIIlIIllllll, final int llllllllllllllllIllIIIIlIlIIIlIl, final int llllllllllllllllIllIIIIlIIllllIl, final int llllllllllllllllIllIIIIlIlIIIIll) {
        super(Minecraft.getMinecraft(), llllllllllllllllIllIIIIlIlIIIIII, llllllllllllllllIllIIIIlIIllllll, llllllllllllllllIllIIIIlIlIIIlIl, llllllllllllllllIllIIIIlIIllllIl, llllllllllllllllIllIIIIlIlIIIIll);
        this.selectionList = llllllllllllllllIllIIIIlIlIIlIII;
    }
    
    @Override
    public void func_178039_p() {
        super.func_178039_p();
    }
    
    @Override
    protected boolean isSelected(final int llllllllllllllllIllIIIIlIIlIIlII) {
        return this.selectionList.isSelectedItem(llllllllllllllllIllIIIIlIIlIIlII);
    }
    
    public int func_154337_m() {
        return super.mouseX;
    }
}
