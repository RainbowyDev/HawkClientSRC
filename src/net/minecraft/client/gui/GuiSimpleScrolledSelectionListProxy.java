package net.minecraft.client.gui;

import net.minecraft.realms.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.*;

public class GuiSimpleScrolledSelectionListProxy extends GuiSlot
{
    private final /* synthetic */ RealmsSimpleScrolledSelectionList field_178050_u;
    
    public int func_178049_g() {
        return super.mouseX;
    }
    
    @Override
    protected void drawBackground() {
        this.field_178050_u.renderBackground();
    }
    
    static {
        __OBFID = "CL_00001938";
    }
    
    public int func_178048_e() {
        return super.width;
    }
    
    @Override
    public void drawScreen(final int llllllllllllllllIllIlIllllIIIIIl, final int llllllllllllllllIllIlIllllIIlllI, final float llllllllllllllllIllIlIllllIIllIl) {
        if (this.field_178041_q) {
            this.mouseX = llllllllllllllllIllIlIllllIIIIIl;
            this.mouseY = llllllllllllllllIllIlIllllIIlllI;
            this.drawBackground();
            final int llllllllllllllllIllIlIllllIIllII = this.getScrollBarX();
            final int llllllllllllllllIllIlIllllIIlIll = llllllllllllllllIllIlIllllIIllII + 6;
            this.bindAmountScrolled();
            GlStateManager.disableLighting();
            GlStateManager.disableFog();
            final Tessellator llllllllllllllllIllIlIllllIIlIlI = Tessellator.getInstance();
            final WorldRenderer llllllllllllllllIllIlIllllIIlIIl = llllllllllllllllIllIlIllllIIlIlI.getWorldRenderer();
            final int llllllllllllllllIllIlIllllIIlIII = this.left + this.width / 2 - this.getListWidth() / 2 + 2;
            final int llllllllllllllllIllIlIllllIIIlll = this.top + 4 - (int)this.amountScrolled;
            if (this.hasListHeader) {
                this.drawListHeader(llllllllllllllllIllIlIllllIIlIII, llllllllllllllllIllIlIllllIIIlll, llllllllllllllllIllIlIllllIIlIlI);
            }
            this.drawSelectionBox(llllllllllllllllIllIlIllllIIlIII, llllllllllllllllIllIlIllllIIIlll, llllllllllllllllIllIlIllllIIIIIl, llllllllllllllllIllIlIllllIIlllI);
            GlStateManager.disableDepth();
            final boolean llllllllllllllllIllIlIllllIIIllI = true;
            this.overlayBackground(0, this.top, 255, 255);
            this.overlayBackground(this.bottom, this.height, 255, 255);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 0, 1);
            GlStateManager.disableAlpha();
            GlStateManager.shadeModel(7425);
            GlStateManager.func_179090_x();
            final int llllllllllllllllIllIlIllllIIIlIl = this.func_148135_f();
            if (llllllllllllllllIllIlIllllIIIlIl > 0) {
                int llllllllllllllllIllIlIllllIIIlII = (this.bottom - this.top) * (this.bottom - this.top) / this.getContentHeight();
                llllllllllllllllIllIlIllllIIIlII = MathHelper.clamp_int(llllllllllllllllIllIlIllllIIIlII, 32, this.bottom - this.top - 8);
                int llllllllllllllllIllIlIllllIIIIll = (int)this.amountScrolled * (this.bottom - this.top - llllllllllllllllIllIlIllllIIIlII) / llllllllllllllllIllIlIllllIIIlIl + this.top;
                if (llllllllllllllllIllIlIllllIIIIll < this.top) {
                    llllllllllllllllIllIlIllllIIIIll = this.top;
                }
                llllllllllllllllIllIlIllllIIlIIl.startDrawingQuads();
                llllllllllllllllIllIlIllllIIlIIl.func_178974_a(0, 255);
                llllllllllllllllIllIlIllllIIlIIl.addVertexWithUV(llllllllllllllllIllIlIllllIIllII, this.bottom, 0.0, 0.0, 1.0);
                llllllllllllllllIllIlIllllIIlIIl.addVertexWithUV(llllllllllllllllIllIlIllllIIlIll, this.bottom, 0.0, 1.0, 1.0);
                llllllllllllllllIllIlIllllIIlIIl.addVertexWithUV(llllllllllllllllIllIlIllllIIlIll, this.top, 0.0, 1.0, 0.0);
                llllllllllllllllIllIlIllllIIlIIl.addVertexWithUV(llllllllllllllllIllIlIllllIIllII, this.top, 0.0, 0.0, 0.0);
                llllllllllllllllIllIlIllllIIlIlI.draw();
                llllllllllllllllIllIlIllllIIlIIl.startDrawingQuads();
                llllllllllllllllIllIlIllllIIlIIl.func_178974_a(8421504, 255);
                llllllllllllllllIllIlIllllIIlIIl.addVertexWithUV(llllllllllllllllIllIlIllllIIllII, llllllllllllllllIllIlIllllIIIIll + llllllllllllllllIllIlIllllIIIlII, 0.0, 0.0, 1.0);
                llllllllllllllllIllIlIllllIIlIIl.addVertexWithUV(llllllllllllllllIllIlIllllIIlIll, llllllllllllllllIllIlIllllIIIIll + llllllllllllllllIllIlIllllIIIlII, 0.0, 1.0, 1.0);
                llllllllllllllllIllIlIllllIIlIIl.addVertexWithUV(llllllllllllllllIllIlIllllIIlIll, llllllllllllllllIllIlIllllIIIIll, 0.0, 1.0, 0.0);
                llllllllllllllllIllIlIllllIIlIIl.addVertexWithUV(llllllllllllllllIllIlIllllIIllII, llllllllllllllllIllIlIllllIIIIll, 0.0, 0.0, 0.0);
                llllllllllllllllIllIlIllllIIlIlI.draw();
                llllllllllllllllIllIlIllllIIlIIl.startDrawingQuads();
                llllllllllllllllIllIlIllllIIlIIl.func_178974_a(12632256, 255);
                llllllllllllllllIllIlIllllIIlIIl.addVertexWithUV(llllllllllllllllIllIlIllllIIllII, llllllllllllllllIllIlIllllIIIIll + llllllllllllllllIllIlIllllIIIlII - 1, 0.0, 0.0, 1.0);
                llllllllllllllllIllIlIllllIIlIIl.addVertexWithUV(llllllllllllllllIllIlIllllIIlIll - 1, llllllllllllllllIllIlIllllIIIIll + llllllllllllllllIllIlIllllIIIlII - 1, 0.0, 1.0, 1.0);
                llllllllllllllllIllIlIllllIIlIIl.addVertexWithUV(llllllllllllllllIllIlIllllIIlIll - 1, llllllllllllllllIllIlIllllIIIIll, 0.0, 1.0, 0.0);
                llllllllllllllllIllIlIllllIIlIIl.addVertexWithUV(llllllllllllllllIllIlIllllIIllII, llllllllllllllllIllIlIllllIIIIll, 0.0, 0.0, 0.0);
                llllllllllllllllIllIlIllllIIlIlI.draw();
            }
            this.func_148142_b(llllllllllllllllIllIlIllllIIIIIl, llllllllllllllllIllIlIllllIIlllI);
            GlStateManager.func_179098_w();
            GlStateManager.shadeModel(7424);
            GlStateManager.enableAlpha();
            GlStateManager.disableBlend();
        }
    }
    
    @Override
    protected int getContentHeight() {
        return this.field_178050_u.getMaxPosition();
    }
    
    @Override
    public void func_178039_p() {
        super.func_178039_p();
    }
    
    @Override
    protected int getScrollBarX() {
        return this.field_178050_u.getScrollbarPosition();
    }
    
    @Override
    protected void elementClicked(final int llllllllllllllllIllIllIIIIIlIIIl, final boolean llllllllllllllllIllIllIIIIIlIIII, final int llllllllllllllllIllIllIIIIIIllll, final int llllllllllllllllIllIllIIIIIlIIll) {
        this.field_178050_u.selectItem(llllllllllllllllIllIllIIIIIlIIIl, llllllllllllllllIllIllIIIIIlIIII, llllllllllllllllIllIllIIIIIIllll, llllllllllllllllIllIllIIIIIlIIll);
    }
    
    public int func_178047_f() {
        return super.mouseY;
    }
    
    @Override
    protected boolean isSelected(final int llllllllllllllllIllIllIIIIIIlIII) {
        return this.field_178050_u.isSelectedItem(llllllllllllllllIllIllIIIIIIlIII);
    }
    
    @Override
    protected void drawSlot(final int llllllllllllllllIllIlIllllllIlIl, final int llllllllllllllllIllIlIlllllllIll, final int llllllllllllllllIllIlIlllllllIlI, final int llllllllllllllllIllIlIlllllllIIl, final int llllllllllllllllIllIlIllllllIIIl, final int llllllllllllllllIllIlIllllllIlll) {
        this.field_178050_u.renderItem(llllllllllllllllIllIlIllllllIlIl, llllllllllllllllIllIlIlllllllIll, llllllllllllllllIllIlIlllllllIlI, llllllllllllllllIllIlIlllllllIIl, llllllllllllllllIllIlIllllllIIIl, llllllllllllllllIllIlIllllllIlll);
    }
    
    @Override
    protected int getSize() {
        return this.field_178050_u.getItemCount();
    }
    
    public GuiSimpleScrolledSelectionListProxy(final RealmsSimpleScrolledSelectionList llllllllllllllllIllIllIIIIlIllII, final int llllllllllllllllIllIllIIIIlIlIll, final int llllllllllllllllIllIllIIIIlIlIlI, final int llllllllllllllllIllIllIIIIlIIIlI, final int llllllllllllllllIllIllIIIIlIIIIl, final int llllllllllllllllIllIllIIIIlIIlll) {
        super(Minecraft.getMinecraft(), llllllllllllllllIllIllIIIIlIlIll, llllllllllllllllIllIllIIIIlIlIlI, llllllllllllllllIllIllIIIIlIIIlI, llllllllllllllllIllIllIIIIlIIIIl, llllllllllllllllIllIllIIIIlIIlll);
        this.field_178050_u = llllllllllllllllIllIllIIIIlIllII;
    }
}
