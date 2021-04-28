package net.minecraft.client.gui;

import net.minecraft.client.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.*;
import org.lwjgl.input.*;

public abstract class GuiSlot
{
    protected /* synthetic */ boolean hasListHeader;
    protected /* synthetic */ int bottom;
    protected /* synthetic */ float amountScrolled;
    protected final /* synthetic */ int slotHeight;
    protected /* synthetic */ float scrollMultiplier;
    protected /* synthetic */ int headerPadding;
    protected /* synthetic */ boolean field_178041_q;
    protected /* synthetic */ int width;
    protected /* synthetic */ int height;
    protected final /* synthetic */ Minecraft mc;
    protected /* synthetic */ int right;
    protected /* synthetic */ boolean field_148163_i;
    protected /* synthetic */ int mouseY;
    private /* synthetic */ boolean enabled;
    protected /* synthetic */ float initialClickY;
    protected /* synthetic */ int top;
    private /* synthetic */ int scrollUpButtonID;
    private /* synthetic */ int scrollDownButtonID;
    protected /* synthetic */ int mouseX;
    protected /* synthetic */ int selectedElement;
    protected /* synthetic */ int left;
    protected /* synthetic */ boolean showSelectionBox;
    protected /* synthetic */ long lastClicked;
    
    public boolean isMouseYWithinSlotBounds(final int lllllllllllllllIlllIlIlIIIIlIlII) {
        return lllllllllllllllIlllIlIlIIIIlIlII >= this.top && lllllllllllllllIlllIlIlIIIIlIlII <= this.bottom && this.mouseX >= this.left && this.mouseX <= this.right;
    }
    
    protected void drawListHeader(final int lllllllllllllllIlllIlIlIIlIIlIlI, final int lllllllllllllllIlllIlIlIIlIIlIIl, final Tessellator lllllllllllllllIlllIlIlIIlIIlIII) {
    }
    
    protected void overlayBackground(final int lllllllllllllllIlllIlIIlIlllIlIl, final int lllllllllllllllIlllIlIIlIlllIlII, final int lllllllllllllllIlllIlIIlIlllIIll, final int lllllllllllllllIlllIlIIlIllllIlI) {
        final Tessellator lllllllllllllllIlllIlIIlIllllIIl = Tessellator.getInstance();
        final WorldRenderer lllllllllllllllIlllIlIIlIllllIII = lllllllllllllllIlllIlIIlIllllIIl.getWorldRenderer();
        this.mc.getTextureManager().bindTexture(Gui.optionsBackground);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        final float lllllllllllllllIlllIlIIlIlllIlll = 32.0f;
        lllllllllllllllIlllIlIIlIllllIII.startDrawingQuads();
        lllllllllllllllIlllIlIIlIllllIII.func_178974_a(4210752, lllllllllllllllIlllIlIIlIllllIlI);
        lllllllllllllllIlllIlIIlIllllIII.addVertexWithUV(this.left, lllllllllllllllIlllIlIIlIlllIlII, 0.0, 0.0, lllllllllllllllIlllIlIIlIlllIlII / lllllllllllllllIlllIlIIlIlllIlll);
        lllllllllllllllIlllIlIIlIllllIII.addVertexWithUV(this.left + this.width, lllllllllllllllIlllIlIIlIlllIlII, 0.0, this.width / lllllllllllllllIlllIlIIlIlllIlll, lllllllllllllllIlllIlIIlIlllIlII / lllllllllllllllIlllIlIIlIlllIlll);
        lllllllllllllllIlllIlIIlIllllIII.func_178974_a(4210752, lllllllllllllllIlllIlIIlIlllIIll);
        lllllllllllllllIlllIlIIlIllllIII.addVertexWithUV(this.left + this.width, lllllllllllllllIlllIlIIlIlllIlIl, 0.0, this.width / lllllllllllllllIlllIlIIlIlllIlll, lllllllllllllllIlllIlIIlIlllIlIl / lllllllllllllllIlllIlIIlIlllIlll);
        lllllllllllllllIlllIlIIlIllllIII.addVertexWithUV(this.left, lllllllllllllllIlllIlIIlIlllIlIl, 0.0, 0.0, lllllllllllllllIlllIlIIlIlllIlIl / lllllllllllllllIlllIlIIlIlllIlll);
        lllllllllllllllIlllIlIIlIllllIIl.draw();
    }
    
    protected int getScrollBarX() {
        return this.width / 2 + 124;
    }
    
    public void drawScreen(final int lllllllllllllllIlllIlIIlllllIllI, final int lllllllllllllllIlllIlIIllllIIllI, final float lllllllllllllllIlllIlIIlllllIlII) {
        if (this.field_178041_q) {
            this.mouseX = lllllllllllllllIlllIlIIlllllIllI;
            this.mouseY = lllllllllllllllIlllIlIIllllIIllI;
            this.drawBackground();
            final int lllllllllllllllIlllIlIIlllllIIll = this.getScrollBarX();
            final int lllllllllllllllIlllIlIIlllllIIlI = lllllllllllllllIlllIlIIlllllIIll + 6;
            this.bindAmountScrolled();
            GlStateManager.disableLighting();
            GlStateManager.disableFog();
            final Tessellator lllllllllllllllIlllIlIIlllllIIIl = Tessellator.getInstance();
            final WorldRenderer lllllllllllllllIlllIlIIlllllIIII = lllllllllllllllIlllIlIIlllllIIIl.getWorldRenderer();
            this.mc.getTextureManager().bindTexture(Gui.optionsBackground);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            final float lllllllllllllllIlllIlIIllllIllll = 32.0f;
            lllllllllllllllIlllIlIIlllllIIII.startDrawingQuads();
            lllllllllllllllIlllIlIIlllllIIII.func_178991_c(2105376);
            lllllllllllllllIlllIlIIlllllIIII.addVertexWithUV(this.left, this.bottom, 0.0, this.left / lllllllllllllllIlllIlIIllllIllll, (this.bottom + (int)this.amountScrolled) / lllllllllllllllIlllIlIIllllIllll);
            lllllllllllllllIlllIlIIlllllIIII.addVertexWithUV(this.right, this.bottom, 0.0, this.right / lllllllllllllllIlllIlIIllllIllll, (this.bottom + (int)this.amountScrolled) / lllllllllllllllIlllIlIIllllIllll);
            lllllllllllllllIlllIlIIlllllIIII.addVertexWithUV(this.right, this.top, 0.0, this.right / lllllllllllllllIlllIlIIllllIllll, (this.top + (int)this.amountScrolled) / lllllllllllllllIlllIlIIllllIllll);
            lllllllllllllllIlllIlIIlllllIIII.addVertexWithUV(this.left, this.top, 0.0, this.left / lllllllllllllllIlllIlIIllllIllll, (this.top + (int)this.amountScrolled) / lllllllllllllllIlllIlIIllllIllll);
            lllllllllllllllIlllIlIIlllllIIIl.draw();
            final int lllllllllllllllIlllIlIIllllIlllI = this.left + this.width / 2 - this.getListWidth() / 2 + 2;
            final int lllllllllllllllIlllIlIIllllIllIl = this.top + 4 - (int)this.amountScrolled;
            if (this.hasListHeader) {
                this.drawListHeader(lllllllllllllllIlllIlIIllllIlllI, lllllllllllllllIlllIlIIllllIllIl, lllllllllllllllIlllIlIIlllllIIIl);
            }
            this.drawSelectionBox(lllllllllllllllIlllIlIIllllIlllI, lllllllllllllllIlllIlIIllllIllIl, lllllllllllllllIlllIlIIlllllIllI, lllllllllllllllIlllIlIIllllIIllI);
            GlStateManager.disableDepth();
            final byte lllllllllllllllIlllIlIIllllIllII = 4;
            this.overlayBackground(0, this.top, 255, 255);
            this.overlayBackground(this.bottom, this.height, 255, 255);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 0, 1);
            GlStateManager.disableAlpha();
            GlStateManager.shadeModel(7425);
            GlStateManager.func_179090_x();
            lllllllllllllllIlllIlIIlllllIIII.startDrawingQuads();
            lllllllllllllllIlllIlIIlllllIIII.func_178974_a(0, 0);
            lllllllllllllllIlllIlIIlllllIIII.addVertexWithUV(this.left, this.top + lllllllllllllllIlllIlIIllllIllII, 0.0, 0.0, 1.0);
            lllllllllllllllIlllIlIIlllllIIII.addVertexWithUV(this.right, this.top + lllllllllllllllIlllIlIIllllIllII, 0.0, 1.0, 1.0);
            lllllllllllllllIlllIlIIlllllIIII.func_178974_a(0, 255);
            lllllllllllllllIlllIlIIlllllIIII.addVertexWithUV(this.right, this.top, 0.0, 1.0, 0.0);
            lllllllllllllllIlllIlIIlllllIIII.addVertexWithUV(this.left, this.top, 0.0, 0.0, 0.0);
            lllllllllllllllIlllIlIIlllllIIIl.draw();
            lllllllllllllllIlllIlIIlllllIIII.startDrawingQuads();
            lllllllllllllllIlllIlIIlllllIIII.func_178974_a(0, 255);
            lllllllllllllllIlllIlIIlllllIIII.addVertexWithUV(this.left, this.bottom, 0.0, 0.0, 1.0);
            lllllllllllllllIlllIlIIlllllIIII.addVertexWithUV(this.right, this.bottom, 0.0, 1.0, 1.0);
            lllllllllllllllIlllIlIIlllllIIII.func_178974_a(0, 0);
            lllllllllllllllIlllIlIIlllllIIII.addVertexWithUV(this.right, this.bottom - lllllllllllllllIlllIlIIllllIllII, 0.0, 1.0, 0.0);
            lllllllllllllllIlllIlIIlllllIIII.addVertexWithUV(this.left, this.bottom - lllllllllllllllIlllIlIIllllIllII, 0.0, 0.0, 0.0);
            lllllllllllllllIlllIlIIlllllIIIl.draw();
            final int lllllllllllllllIlllIlIIllllIlIll = this.func_148135_f();
            if (lllllllllllllllIlllIlIIllllIlIll > 0) {
                int lllllllllllllllIlllIlIIllllIlIlI = (this.bottom - this.top) * (this.bottom - this.top) / this.getContentHeight();
                lllllllllllllllIlllIlIIllllIlIlI = MathHelper.clamp_int(lllllllllllllllIlllIlIIllllIlIlI, 32, this.bottom - this.top - 8);
                int lllllllllllllllIlllIlIIllllIlIIl = (int)this.amountScrolled * (this.bottom - this.top - lllllllllllllllIlllIlIIllllIlIlI) / lllllllllllllllIlllIlIIllllIlIll + this.top;
                if (lllllllllllllllIlllIlIIllllIlIIl < this.top) {
                    lllllllllllllllIlllIlIIllllIlIIl = this.top;
                }
                lllllllllllllllIlllIlIIlllllIIII.startDrawingQuads();
                lllllllllllllllIlllIlIIlllllIIII.func_178974_a(0, 255);
                lllllllllllllllIlllIlIIlllllIIII.addVertexWithUV(lllllllllllllllIlllIlIIlllllIIll, this.bottom, 0.0, 0.0, 1.0);
                lllllllllllllllIlllIlIIlllllIIII.addVertexWithUV(lllllllllllllllIlllIlIIlllllIIlI, this.bottom, 0.0, 1.0, 1.0);
                lllllllllllllllIlllIlIIlllllIIII.addVertexWithUV(lllllllllllllllIlllIlIIlllllIIlI, this.top, 0.0, 1.0, 0.0);
                lllllllllllllllIlllIlIIlllllIIII.addVertexWithUV(lllllllllllllllIlllIlIIlllllIIll, this.top, 0.0, 0.0, 0.0);
                lllllllllllllllIlllIlIIlllllIIIl.draw();
                lllllllllllllllIlllIlIIlllllIIII.startDrawingQuads();
                lllllllllllllllIlllIlIIlllllIIII.func_178974_a(8421504, 255);
                lllllllllllllllIlllIlIIlllllIIII.addVertexWithUV(lllllllllllllllIlllIlIIlllllIIll, lllllllllllllllIlllIlIIllllIlIIl + lllllllllllllllIlllIlIIllllIlIlI, 0.0, 0.0, 1.0);
                lllllllllllllllIlllIlIIlllllIIII.addVertexWithUV(lllllllllllllllIlllIlIIlllllIIlI, lllllllllllllllIlllIlIIllllIlIIl + lllllllllllllllIlllIlIIllllIlIlI, 0.0, 1.0, 1.0);
                lllllllllllllllIlllIlIIlllllIIII.addVertexWithUV(lllllllllllllllIlllIlIIlllllIIlI, lllllllllllllllIlllIlIIllllIlIIl, 0.0, 1.0, 0.0);
                lllllllllllllllIlllIlIIlllllIIII.addVertexWithUV(lllllllllllllllIlllIlIIlllllIIll, lllllllllllllllIlllIlIIllllIlIIl, 0.0, 0.0, 0.0);
                lllllllllllllllIlllIlIIlllllIIIl.draw();
                lllllllllllllllIlllIlIIlllllIIII.startDrawingQuads();
                lllllllllllllllIlllIlIIlllllIIII.func_178974_a(12632256, 255);
                lllllllllllllllIlllIlIIlllllIIII.addVertexWithUV(lllllllllllllllIlllIlIIlllllIIll, lllllllllllllllIlllIlIIllllIlIIl + lllllllllllllllIlllIlIIllllIlIlI - 1, 0.0, 0.0, 1.0);
                lllllllllllllllIlllIlIIlllllIIII.addVertexWithUV(lllllllllllllllIlllIlIIlllllIIlI - 1, lllllllllllllllIlllIlIIllllIlIIl + lllllllllllllllIlllIlIIllllIlIlI - 1, 0.0, 1.0, 1.0);
                lllllllllllllllIlllIlIIlllllIIII.addVertexWithUV(lllllllllllllllIlllIlIIlllllIIlI - 1, lllllllllllllllIlllIlIIllllIlIIl, 0.0, 1.0, 0.0);
                lllllllllllllllIlllIlIIlllllIIII.addVertexWithUV(lllllllllllllllIlllIlIIlllllIIll, lllllllllllllllIlllIlIIllllIlIIl, 0.0, 0.0, 0.0);
                lllllllllllllllIlllIlIIlllllIIIl.draw();
            }
            this.func_148142_b(lllllllllllllllIlllIlIIlllllIllI, lllllllllllllllIlllIlIIllllIIllI);
            GlStateManager.func_179098_w();
            GlStateManager.shadeModel(7424);
            GlStateManager.enableAlpha();
            GlStateManager.disableBlend();
        }
    }
    
    public void setEnabled(final boolean lllllllllllllllIlllIlIIllIllIlll) {
        this.enabled = lllllllllllllllIlllIlIIllIllIlll;
    }
    
    public void setDimensions(final int lllllllllllllllIlllIlIlIIllIIlIl, final int lllllllllllllllIlllIlIlIIllIIlII, final int lllllllllllllllIlllIlIlIIllIlIII, final int lllllllllllllllIlllIlIlIIllIIIlI) {
        this.width = lllllllllllllllIlllIlIlIIllIIlIl;
        this.height = lllllllllllllllIlllIlIlIIllIIlII;
        this.top = lllllllllllllllIlllIlIlIIllIlIII;
        this.bottom = lllllllllllllllIlllIlIlIIllIIIlI;
        this.left = 0;
        this.right = lllllllllllllllIlllIlIlIIllIIlIl;
    }
    
    public boolean getEnabled() {
        return this.enabled;
    }
    
    public int func_148135_f() {
        return Math.max(0, this.getContentHeight() - (this.bottom - this.top - 4));
    }
    
    public int getSlotHeight() {
        return this.slotHeight;
    }
    
    public int getListWidth() {
        return 220;
    }
    
    public int getAmountScrolled() {
        return (int)this.amountScrolled;
    }
    
    public void func_178039_p() {
        if (this.isMouseYWithinSlotBounds(this.mouseY)) {
            if (Mouse.isButtonDown(0) && this.getEnabled()) {
                if (this.initialClickY == -1.0f) {
                    boolean lllllllllllllllIlllIlIIlllIIllll = true;
                    if (this.mouseY >= this.top && this.mouseY <= this.bottom) {
                        final int lllllllllllllllIlllIlIIlllIIlllI = this.width / 2 - this.getListWidth() / 2;
                        final int lllllllllllllllIlllIlIIlllIIllIl = this.width / 2 + this.getListWidth() / 2;
                        final int lllllllllllllllIlllIlIIlllIIllII = this.mouseY - this.top - this.headerPadding + (int)this.amountScrolled - 4;
                        final int lllllllllllllllIlllIlIIlllIIlIll = lllllllllllllllIlllIlIIlllIIllII / this.slotHeight;
                        if (this.mouseX >= lllllllllllllllIlllIlIIlllIIlllI && this.mouseX <= lllllllllllllllIlllIlIIlllIIllIl && lllllllllllllllIlllIlIIlllIIlIll >= 0 && lllllllllllllllIlllIlIIlllIIllII >= 0 && lllllllllllllllIlllIlIIlllIIlIll < this.getSize()) {
                            final boolean lllllllllllllllIlllIlIIlllIIlIlI = lllllllllllllllIlllIlIIlllIIlIll == this.selectedElement && Minecraft.getSystemTime() - this.lastClicked < 250L;
                            this.elementClicked(lllllllllllllllIlllIlIIlllIIlIll, lllllllllllllllIlllIlIIlllIIlIlI, this.mouseX, this.mouseY);
                            this.selectedElement = lllllllllllllllIlllIlIIlllIIlIll;
                            this.lastClicked = Minecraft.getSystemTime();
                        }
                        else if (this.mouseX >= lllllllllllllllIlllIlIIlllIIlllI && this.mouseX <= lllllllllllllllIlllIlIIlllIIllIl && lllllllllllllllIlllIlIIlllIIllII < 0) {
                            this.func_148132_a(this.mouseX - lllllllllllllllIlllIlIIlllIIlllI, this.mouseY - this.top + (int)this.amountScrolled - 4);
                            lllllllllllllllIlllIlIIlllIIllll = false;
                        }
                        final int lllllllllllllllIlllIlIIlllIIlIIl = this.getScrollBarX();
                        final int lllllllllllllllIlllIlIIlllIIlIII = lllllllllllllllIlllIlIIlllIIlIIl + 6;
                        if (this.mouseX >= lllllllllllllllIlllIlIIlllIIlIIl && this.mouseX <= lllllllllllllllIlllIlIIlllIIlIII) {
                            this.scrollMultiplier = -1.0f;
                            int lllllllllllllllIlllIlIIlllIIIlll = this.func_148135_f();
                            if (lllllllllllllllIlllIlIIlllIIIlll < 1) {
                                lllllllllllllllIlllIlIIlllIIIlll = 1;
                            }
                            int lllllllllllllllIlllIlIIlllIIIllI = (int)((this.bottom - this.top) * (this.bottom - this.top) / (float)this.getContentHeight());
                            lllllllllllllllIlllIlIIlllIIIllI = MathHelper.clamp_int(lllllllllllllllIlllIlIIlllIIIllI, 32, this.bottom - this.top - 8);
                            this.scrollMultiplier /= (this.bottom - this.top - lllllllllllllllIlllIlIIlllIIIllI) / (float)lllllllllllllllIlllIlIIlllIIIlll;
                        }
                        else {
                            this.scrollMultiplier = 1.0f;
                        }
                        if (lllllllllllllllIlllIlIIlllIIllll) {
                            this.initialClickY = (float)this.mouseY;
                        }
                        else {
                            this.initialClickY = -2.0f;
                        }
                    }
                    else {
                        this.initialClickY = -2.0f;
                    }
                }
                else if (this.initialClickY >= 0.0f) {
                    this.amountScrolled -= (this.mouseY - this.initialClickY) * this.scrollMultiplier;
                    this.initialClickY = (float)this.mouseY;
                }
            }
            else {
                this.initialClickY = -1.0f;
            }
            int lllllllllllllllIlllIlIIlllIIIlIl = Mouse.getEventDWheel();
            if (lllllllllllllllIlllIlIIlllIIIlIl != 0) {
                if (lllllllllllllllIlllIlIIlllIIIlIl > 0) {
                    lllllllllllllllIlllIlIIlllIIIlIl = -1;
                }
                else if (lllllllllllllllIlllIlIIlllIIIlIl < 0) {
                    lllllllllllllllIlllIlIIlllIIIlIl = 1;
                }
                this.amountScrolled += lllllllllllllllIlllIlIIlllIIIlIl * this.slotHeight / 2;
            }
        }
    }
    
    protected int getContentHeight() {
        return this.getSize() * this.slotHeight + this.headerPadding;
    }
    
    public void setShowSelectionBox(final boolean lllllllllllllllIlllIlIlIIlIlllII) {
        this.showSelectionBox = lllllllllllllllIlllIlIlIIlIlllII;
    }
    
    protected abstract int getSize();
    
    public void actionPerformed(final GuiButton lllllllllllllllIlllIlIlIIIIIlIII) {
        if (lllllllllllllllIlllIlIlIIIIIlIII.enabled) {
            if (lllllllllllllllIlllIlIlIIIIIlIII.id == this.scrollUpButtonID) {
                this.amountScrolled -= this.slotHeight * 2 / 3;
                this.initialClickY = -2.0f;
                this.bindAmountScrolled();
            }
            else if (lllllllllllllllIlllIlIlIIIIIlIII.id == this.scrollDownButtonID) {
                this.amountScrolled += this.slotHeight * 2 / 3;
                this.initialClickY = -2.0f;
                this.bindAmountScrolled();
            }
        }
    }
    
    public void scrollBy(final int lllllllllllllllIlllIlIlIIIIIllII) {
        this.amountScrolled += lllllllllllllllIlllIlIlIIIIIllII;
        this.bindAmountScrolled();
        this.initialClickY = -2.0f;
    }
    
    protected void drawSelectionBox(final int lllllllllllllllIlllIlIIllIlIIIlI, final int lllllllllllllllIlllIlIIllIIlIlII, final int lllllllllllllllIlllIlIIllIIlIIll, final int lllllllllllllllIlllIlIIllIIlIIlI) {
        final int lllllllllllllllIlllIlIIllIIllllI = this.getSize();
        final Tessellator lllllllllllllllIlllIlIIllIIlllIl = Tessellator.getInstance();
        final WorldRenderer lllllllllllllllIlllIlIIllIIlllII = lllllllllllllllIlllIlIIllIIlllIl.getWorldRenderer();
        for (int lllllllllllllllIlllIlIIllIIllIll = 0; lllllllllllllllIlllIlIIllIIllIll < lllllllllllllllIlllIlIIllIIllllI; ++lllllllllllllllIlllIlIIllIIllIll) {
            final int lllllllllllllllIlllIlIIllIIllIlI = lllllllllllllllIlllIlIIllIIlIlII + lllllllllllllllIlllIlIIllIIllIll * this.slotHeight + this.headerPadding;
            final int lllllllllllllllIlllIlIIllIIllIIl = this.slotHeight - 4;
            if (lllllllllllllllIlllIlIIllIIllIlI > this.bottom || lllllllllllllllIlllIlIIllIIllIlI + lllllllllllllllIlllIlIIllIIllIIl < this.top) {
                this.func_178040_a(lllllllllllllllIlllIlIIllIIllIll, lllllllllllllllIlllIlIIllIlIIIlI, lllllllllllllllIlllIlIIllIIllIlI);
            }
            if (this.showSelectionBox && this.isSelected(lllllllllllllllIlllIlIIllIIllIll)) {
                final int lllllllllllllllIlllIlIIllIIllIII = this.left + (this.width / 2 - this.getListWidth() / 2);
                final int lllllllllllllllIlllIlIIllIIlIlll = this.left + this.width / 2 + this.getListWidth() / 2;
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                GlStateManager.func_179090_x();
                lllllllllllllllIlllIlIIllIIlllII.startDrawingQuads();
                lllllllllllllllIlllIlIIllIIlllII.func_178991_c(8421504);
                lllllllllllllllIlllIlIIllIIlllII.addVertexWithUV(lllllllllllllllIlllIlIIllIIllIII, lllllllllllllllIlllIlIIllIIllIlI + lllllllllllllllIlllIlIIllIIllIIl + 2, 0.0, 0.0, 1.0);
                lllllllllllllllIlllIlIIllIIlllII.addVertexWithUV(lllllllllllllllIlllIlIIllIIlIlll, lllllllllllllllIlllIlIIllIIllIlI + lllllllllllllllIlllIlIIllIIllIIl + 2, 0.0, 1.0, 1.0);
                lllllllllllllllIlllIlIIllIIlllII.addVertexWithUV(lllllllllllllllIlllIlIIllIIlIlll, lllllllllllllllIlllIlIIllIIllIlI - 2, 0.0, 1.0, 0.0);
                lllllllllllllllIlllIlIIllIIlllII.addVertexWithUV(lllllllllllllllIlllIlIIllIIllIII, lllllllllllllllIlllIlIIllIIllIlI - 2, 0.0, 0.0, 0.0);
                lllllllllllllllIlllIlIIllIIlllII.func_178991_c(0);
                lllllllllllllllIlllIlIIllIIlllII.addVertexWithUV(lllllllllllllllIlllIlIIllIIllIII + 1, lllllllllllllllIlllIlIIllIIllIlI + lllllllllllllllIlllIlIIllIIllIIl + 1, 0.0, 0.0, 1.0);
                lllllllllllllllIlllIlIIllIIlllII.addVertexWithUV(lllllllllllllllIlllIlIIllIIlIlll - 1, lllllllllllllllIlllIlIIllIIllIlI + lllllllllllllllIlllIlIIllIIllIIl + 1, 0.0, 1.0, 1.0);
                lllllllllllllllIlllIlIIllIIlllII.addVertexWithUV(lllllllllllllllIlllIlIIllIIlIlll - 1, lllllllllllllllIlllIlIIllIIllIlI - 1, 0.0, 1.0, 0.0);
                lllllllllllllllIlllIlIIllIIlllII.addVertexWithUV(lllllllllllllllIlllIlIIllIIllIII + 1, lllllllllllllllIlllIlIIllIIllIlI - 1, 0.0, 0.0, 0.0);
                lllllllllllllllIlllIlIIllIIlllIl.draw();
                GlStateManager.func_179098_w();
            }
            this.drawSlot(lllllllllllllllIlllIlIIllIIllIll, lllllllllllllllIlllIlIIllIlIIIlI, lllllllllllllllIlllIlIIllIIllIlI, lllllllllllllllIlllIlIIllIIllIIl, lllllllllllllllIlllIlIIllIIlIIll, lllllllllllllllIlllIlIIllIIlIIlI);
        }
    }
    
    public GuiSlot(final Minecraft lllllllllllllllIlllIlIlIIlllllIl, final int lllllllllllllllIlllIlIlIIlllIlIl, final int lllllllllllllllIlllIlIlIIllllIll, final int lllllllllllllllIlllIlIlIIlllIIll, final int lllllllllllllllIlllIlIlIIlllIIlI, final int lllllllllllllllIlllIlIlIIlllIIIl) {
        this.field_148163_i = true;
        this.initialClickY = -2.0f;
        this.selectedElement = -1;
        this.field_178041_q = true;
        this.showSelectionBox = true;
        this.enabled = true;
        this.mc = lllllllllllllllIlllIlIlIIlllllIl;
        this.width = lllllllllllllllIlllIlIlIIlllIlIl;
        this.height = lllllllllllllllIlllIlIlIIllllIll;
        this.top = lllllllllllllllIlllIlIlIIlllIIll;
        this.bottom = lllllllllllllllIlllIlIlIIlllIIlI;
        this.slotHeight = lllllllllllllllIlllIlIlIIlllIIIl;
        this.left = 0;
        this.right = lllllllllllllllIlllIlIlIIlllIlIl;
    }
    
    protected abstract void drawSlot(final int p0, final int p1, final int p2, final int p3, final int p4, final int p5);
    
    protected abstract void drawBackground();
    
    protected void func_148132_a(final int lllllllllllllllIlllIlIlIIlIIIllI, final int lllllllllllllllIlllIlIlIIlIIIlIl) {
    }
    
    protected void func_148142_b(final int lllllllllllllllIlllIlIlIIlIIIIll, final int lllllllllllllllIlllIlIlIIlIIIIlI) {
    }
    
    public void registerScrollButtons(final int lllllllllllllllIlllIlIlIIIlIlIII, final int lllllllllllllllIlllIlIlIIIlIIlII) {
        this.scrollUpButtonID = lllllllllllllllIlllIlIlIIIlIlIII;
        this.scrollDownButtonID = lllllllllllllllIlllIlIlIIIlIIlII;
    }
    
    protected abstract boolean isSelected(final int p0);
    
    protected abstract void elementClicked(final int p0, final boolean p1, final int p2, final int p3);
    
    protected void func_178040_a(final int lllllllllllllllIlllIlIlIIlIIlllI, final int lllllllllllllllIlllIlIlIIlIIllIl, final int lllllllllllllllIlllIlIlIIlIIllII) {
    }
    
    public int getSlotIndexFromScreenCoords(final int lllllllllllllllIlllIlIlIIIllIIlI, final int lllllllllllllllIlllIlIlIIIllIIIl) {
        final int lllllllllllllllIlllIlIlIIIllIlll = this.left + this.width / 2 - this.getListWidth() / 2;
        final int lllllllllllllllIlllIlIlIIIllIllI = this.left + this.width / 2 + this.getListWidth() / 2;
        final int lllllllllllllllIlllIlIlIIIllIlIl = lllllllllllllllIlllIlIlIIIllIIIl - this.top - this.headerPadding + (int)this.amountScrolled - 4;
        final int lllllllllllllllIlllIlIlIIIllIlII = lllllllllllllllIlllIlIlIIIllIlIl / this.slotHeight;
        return (lllllllllllllllIlllIlIlIIIllIIlI < this.getScrollBarX() && lllllllllllllllIlllIlIlIIIllIIlI >= lllllllllllllllIlllIlIlIIIllIlll && lllllllllllllllIlllIlIlIIIllIIlI <= lllllllllllllllIlllIlIlIIIllIllI && lllllllllllllllIlllIlIlIIIllIlII >= 0 && lllllllllllllllIlllIlIlIIIllIlIl >= 0 && lllllllllllllllIlllIlIlIIIllIlII < this.getSize()) ? lllllllllllllllIlllIlIlIIIllIlII : -1;
    }
    
    protected void setHasListHeader(final boolean lllllllllllllllIlllIlIlIIlIlIlll, final int lllllllllllllllIlllIlIlIIlIlIllI) {
        this.hasListHeader = lllllllllllllllIlllIlIlIIlIlIlll;
        this.headerPadding = lllllllllllllllIlllIlIlIIlIlIllI;
        if (!lllllllllllllllIlllIlIlIIlIlIlll) {
            this.headerPadding = 0;
        }
    }
    
    public void setSlotXBoundsFromLeft(final int lllllllllllllllIlllIlIIlIllIlIIl) {
        this.left = lllllllllllllllIlllIlIIlIllIlIIl;
        this.right = lllllllllllllllIlllIlIIlIllIlIIl + this.width;
    }
    
    protected void bindAmountScrolled() {
        int lllllllllllllllIlllIlIlIIIlIIIII = this.func_148135_f();
        if (lllllllllllllllIlllIlIlIIIlIIIII < 0) {
            lllllllllllllllIlllIlIlIIIlIIIII /= 2;
        }
        if (!this.field_148163_i && lllllllllllllllIlllIlIlIIIlIIIII < 0) {
            lllllllllllllllIlllIlIlIIIlIIIII = 0;
        }
        this.amountScrolled = MathHelper.clamp_float(this.amountScrolled, 0.0f, (float)lllllllllllllllIlllIlIlIIIlIIIII);
    }
    
    static {
        __OBFID = "CL_00000679";
    }
}
