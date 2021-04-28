package net.minecraft.client.gui;

import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.texture.*;

public class Gui
{
    protected /* synthetic */ float zLevel;
    
    protected void drawHorizontalLine(int llllllllllllllllIIllllllIlllIIII, int llllllllllllllllIIllllllIllIllll, final int llllllllllllllllIIllllllIllIlllI, final int llllllllllllllllIIllllllIllIllIl) {
        if (llllllllllllllllIIllllllIllIllll < llllllllllllllllIIllllllIlllIIII) {
            final int llllllllllllllllIIllllllIlllIIIl = llllllllllllllllIIllllllIlllIIII;
            llllllllllllllllIIllllllIlllIIII = llllllllllllllllIIllllllIllIllll;
            llllllllllllllllIIllllllIllIllll = llllllllllllllllIIllllllIlllIIIl;
        }
        drawRect(llllllllllllllllIIllllllIlllIIII, llllllllllllllllIIllllllIllIlllI, llllllllllllllllIIllllllIllIllll + 1, llllllllllllllllIIllllllIllIlllI + 1, llllllllllllllllIIllllllIllIllIl);
    }
    
    static {
        __OBFID = "CL_00000662";
        optionsBackground = new ResourceLocation("textures/gui/options_background.png");
        statIcons = new ResourceLocation("textures/gui/container/stats_icons.png");
        icons = new ResourceLocation("textures/gui/icons.png");
    }
    
    protected void drawGradientRect(final int llllllllllllllllIIllllllIIIlIIll, final int llllllllllllllllIIllllllIIIlIIlI, final int llllllllllllllllIIllllllIIlIIIlI, final int llllllllllllllllIIllllllIIlIIIIl, final int llllllllllllllllIIllllllIIlIIIII, final int llllllllllllllllIIllllllIIIlllll) {
        final float llllllllllllllllIIllllllIIIllllI = (llllllllllllllllIIllllllIIlIIIII >> 24 & 0xFF) / 255.0f;
        final float llllllllllllllllIIllllllIIIlllIl = (llllllllllllllllIIllllllIIlIIIII >> 16 & 0xFF) / 255.0f;
        final float llllllllllllllllIIllllllIIIlllII = (llllllllllllllllIIllllllIIlIIIII >> 8 & 0xFF) / 255.0f;
        final float llllllllllllllllIIllllllIIIllIll = (llllllllllllllllIIllllllIIlIIIII & 0xFF) / 255.0f;
        final float llllllllllllllllIIllllllIIIllIlI = (llllllllllllllllIIllllllIIIlllll >> 24 & 0xFF) / 255.0f;
        final float llllllllllllllllIIllllllIIIllIIl = (llllllllllllllllIIllllllIIIlllll >> 16 & 0xFF) / 255.0f;
        final float llllllllllllllllIIllllllIIIllIII = (llllllllllllllllIIllllllIIIlllll >> 8 & 0xFF) / 255.0f;
        final float llllllllllllllllIIllllllIIIlIlll = (llllllllllllllllIIllllllIIIlllll & 0xFF) / 255.0f;
        GlStateManager.func_179090_x();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.shadeModel(7425);
        final Tessellator llllllllllllllllIIllllllIIIlIllI = Tessellator.getInstance();
        final WorldRenderer llllllllllllllllIIllllllIIIlIlIl = llllllllllllllllIIllllllIIIlIllI.getWorldRenderer();
        llllllllllllllllIIllllllIIIlIlIl.startDrawingQuads();
        llllllllllllllllIIllllllIIIlIlIl.func_178960_a(llllllllllllllllIIllllllIIIlllIl, llllllllllllllllIIllllllIIIlllII, llllllllllllllllIIllllllIIIllIll, llllllllllllllllIIllllllIIIllllI);
        llllllllllllllllIIllllllIIIlIlIl.addVertex(llllllllllllllllIIllllllIIlIIIlI, llllllllllllllllIIllllllIIIlIIlI, this.zLevel);
        llllllllllllllllIIllllllIIIlIlIl.addVertex(llllllllllllllllIIllllllIIIlIIll, llllllllllllllllIIllllllIIIlIIlI, this.zLevel);
        llllllllllllllllIIllllllIIIlIlIl.func_178960_a(llllllllllllllllIIllllllIIIllIIl, llllllllllllllllIIllllllIIIllIII, llllllllllllllllIIllllllIIIlIlll, llllllllllllllllIIllllllIIIllIlI);
        llllllllllllllllIIllllllIIIlIlIl.addVertex(llllllllllllllllIIllllllIIIlIIll, llllllllllllllllIIllllllIIlIIIIl, this.zLevel);
        llllllllllllllllIIllllllIIIlIlIl.addVertex(llllllllllllllllIIllllllIIlIIIlI, llllllllllllllllIIllllllIIlIIIIl, this.zLevel);
        llllllllllllllllIIllllllIIIlIllI.draw();
        GlStateManager.shadeModel(7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.func_179098_w();
    }
    
    public static void drawScaledCustomSizeModalRect(final int llllllllllllllllIIlllllIIlIlIlll, final int llllllllllllllllIIlllllIIlIIlIII, final float llllllllllllllllIIlllllIIlIIIlll, final float llllllllllllllllIIlllllIIlIIIllI, final int llllllllllllllllIIlllllIIlIlIIll, final int llllllllllllllllIIlllllIIlIlIIlI, final int llllllllllllllllIIlllllIIlIlIIIl, final int llllllllllllllllIIlllllIIlIlIIII, final float llllllllllllllllIIlllllIIlIIllll, final float llllllllllllllllIIlllllIIlIIIIII) {
        final float llllllllllllllllIIlllllIIlIIllIl = 1.0f / llllllllllllllllIIlllllIIlIIllll;
        final float llllllllllllllllIIlllllIIlIIllII = 1.0f / llllllllllllllllIIlllllIIlIIIIII;
        final Tessellator llllllllllllllllIIlllllIIlIIlIll = Tessellator.getInstance();
        final WorldRenderer llllllllllllllllIIlllllIIlIIlIlI = llllllllllllllllIIlllllIIlIIlIll.getWorldRenderer();
        llllllllllllllllIIlllllIIlIIlIlI.startDrawingQuads();
        llllllllllllllllIIlllllIIlIIlIlI.addVertexWithUV(llllllllllllllllIIlllllIIlIlIlll, llllllllllllllllIIlllllIIlIIlIII + llllllllllllllllIIlllllIIlIlIIII, 0.0, llllllllllllllllIIlllllIIlIIIlll * llllllllllllllllIIlllllIIlIIllIl, (llllllllllllllllIIlllllIIlIIIllI + llllllllllllllllIIlllllIIlIlIIlI) * llllllllllllllllIIlllllIIlIIllII);
        llllllllllllllllIIlllllIIlIIlIlI.addVertexWithUV(llllllllllllllllIIlllllIIlIlIlll + llllllllllllllllIIlllllIIlIlIIIl, llllllllllllllllIIlllllIIlIIlIII + llllllllllllllllIIlllllIIlIlIIII, 0.0, (llllllllllllllllIIlllllIIlIIIlll + llllllllllllllllIIlllllIIlIlIIll) * llllllllllllllllIIlllllIIlIIllIl, (llllllllllllllllIIlllllIIlIIIllI + llllllllllllllllIIlllllIIlIlIIlI) * llllllllllllllllIIlllllIIlIIllII);
        llllllllllllllllIIlllllIIlIIlIlI.addVertexWithUV(llllllllllllllllIIlllllIIlIlIlll + llllllllllllllllIIlllllIIlIlIIIl, llllllllllllllllIIlllllIIlIIlIII, 0.0, (llllllllllllllllIIlllllIIlIIIlll + llllllllllllllllIIlllllIIlIlIIll) * llllllllllllllllIIlllllIIlIIllIl, llllllllllllllllIIlllllIIlIIIllI * llllllllllllllllIIlllllIIlIIllII);
        llllllllllllllllIIlllllIIlIIlIlI.addVertexWithUV(llllllllllllllllIIlllllIIlIlIlll, llllllllllllllllIIlllllIIlIIlIII, 0.0, llllllllllllllllIIlllllIIlIIIlll * llllllllllllllllIIlllllIIlIIllIl, llllllllllllllllIIlllllIIlIIIllI * llllllllllllllllIIlllllIIlIIllII);
        llllllllllllllllIIlllllIIlIIlIll.draw();
    }
    
    public static void drawRect(double llllllllllllllllIIllllllIlIIIIlI, double llllllllllllllllIIllllllIlIIIIII, double llllllllllllllllIIllllllIIllllll, double llllllllllllllllIIllllllIIlllllI, final int llllllllllllllllIIllllllIlIIlIll) {
        if (llllllllllllllllIIllllllIlIIIIlI < llllllllllllllllIIllllllIIllllll) {
            final double llllllllllllllllIIllllllIlIIlIlI = llllllllllllllllIIllllllIlIIIIlI;
            llllllllllllllllIIllllllIlIIIIlI = (double)llllllllllllllllIIllllllIIllllll;
            llllllllllllllllIIllllllIIllllll = llllllllllllllllIIllllllIlIIlIlI;
        }
        if (llllllllllllllllIIllllllIlIIIIII < llllllllllllllllIIllllllIIlllllI) {
            final double llllllllllllllllIIllllllIlIIlIIl = (double)llllllllllllllllIIllllllIlIIIIII;
            llllllllllllllllIIllllllIlIIIIII = llllllllllllllllIIllllllIIlllllI;
            llllllllllllllllIIllllllIIlllllI = llllllllllllllllIIllllllIlIIlIIl;
        }
        final float llllllllllllllllIIllllllIlIIlIII = (llllllllllllllllIIllllllIlIIlIll >> 24 & 0xFF) / 255.0f;
        final float llllllllllllllllIIllllllIlIIIlll = (llllllllllllllllIIllllllIlIIlIll >> 16 & 0xFF) / 255.0f;
        final float llllllllllllllllIIllllllIlIIIllI = (llllllllllllllllIIllllllIlIIlIll >> 8 & 0xFF) / 255.0f;
        final float llllllllllllllllIIllllllIlIIIlIl = (llllllllllllllllIIllllllIlIIlIll & 0xFF) / 255.0f;
        final Tessellator llllllllllllllllIIllllllIlIIIlII = Tessellator.getInstance();
        final WorldRenderer llllllllllllllllIIllllllIlIIIIll = llllllllllllllllIIllllllIlIIIlII.getWorldRenderer();
        GlStateManager.enableBlend();
        GlStateManager.func_179090_x();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.color(llllllllllllllllIIllllllIlIIIlll, llllllllllllllllIIllllllIlIIIllI, llllllllllllllllIIllllllIlIIIlIl, llllllllllllllllIIllllllIlIIlIII);
        llllllllllllllllIIllllllIlIIIIll.startDrawingQuads();
        llllllllllllllllIIllllllIlIIIIll.addVertex(llllllllllllllllIIllllllIlIIIIlI, llllllllllllllllIIllllllIIlllllI, 0.0);
        llllllllllllllllIIllllllIlIIIIll.addVertex((double)llllllllllllllllIIllllllIIllllll, llllllllllllllllIIllllllIIlllllI, 0.0);
        llllllllllllllllIIllllllIlIIIIll.addVertex((double)llllllllllllllllIIllllllIIllllll, (double)llllllllllllllllIIllllllIlIIIIII, 0.0);
        llllllllllllllllIIllllllIlIIIIll.addVertex(llllllllllllllllIIllllllIlIIIIlI, (double)llllllllllllllllIIllllllIlIIIIII, 0.0);
        llllllllllllllllIIllllllIlIIIlII.draw();
        GlStateManager.func_179098_w();
        GlStateManager.disableBlend();
    }
    
    public static void drawModalRectWithCustomSizedTexture(final int llllllllllllllllIIlllllIIlllllIl, final int llllllllllllllllIIlllllIIlllllII, final float llllllllllllllllIIlllllIIllllIll, final float llllllllllllllllIIlllllIIllllIlI, final int llllllllllllllllIIlllllIIllIllIl, final int llllllllllllllllIIlllllIIllllIII, final float llllllllllllllllIIlllllIIllIlIll, final float llllllllllllllllIIlllllIIlllIllI) {
        final float llllllllllllllllIIlllllIIlllIlIl = 1.0f / llllllllllllllllIIlllllIIllIlIll;
        final float llllllllllllllllIIlllllIIlllIlII = 1.0f / llllllllllllllllIIlllllIIlllIllI;
        final Tessellator llllllllllllllllIIlllllIIlllIIll = Tessellator.getInstance();
        final WorldRenderer llllllllllllllllIIlllllIIlllIIlI = llllllllllllllllIIlllllIIlllIIll.getWorldRenderer();
        llllllllllllllllIIlllllIIlllIIlI.startDrawingQuads();
        llllllllllllllllIIlllllIIlllIIlI.addVertexWithUV(llllllllllllllllIIlllllIIlllllIl, llllllllllllllllIIlllllIIlllllII + llllllllllllllllIIlllllIIllllIII, 0.0, llllllllllllllllIIlllllIIllllIll * llllllllllllllllIIlllllIIlllIlIl, (llllllllllllllllIIlllllIIllllIlI + llllllllllllllllIIlllllIIllllIII) * llllllllllllllllIIlllllIIlllIlII);
        llllllllllllllllIIlllllIIlllIIlI.addVertexWithUV(llllllllllllllllIIlllllIIlllllIl + llllllllllllllllIIlllllIIllIllIl, llllllllllllllllIIlllllIIlllllII + llllllllllllllllIIlllllIIllllIII, 0.0, (llllllllllllllllIIlllllIIllllIll + llllllllllllllllIIlllllIIllIllIl) * llllllllllllllllIIlllllIIlllIlIl, (llllllllllllllllIIlllllIIllllIlI + llllllllllllllllIIlllllIIllllIII) * llllllllllllllllIIlllllIIlllIlII);
        llllllllllllllllIIlllllIIlllIIlI.addVertexWithUV(llllllllllllllllIIlllllIIlllllIl + llllllllllllllllIIlllllIIllIllIl, llllllllllllllllIIlllllIIlllllII, 0.0, (llllllllllllllllIIlllllIIllllIll + llllllllllllllllIIlllllIIllIllIl) * llllllllllllllllIIlllllIIlllIlIl, llllllllllllllllIIlllllIIllllIlI * llllllllllllllllIIlllllIIlllIlII);
        llllllllllllllllIIlllllIIlllIIlI.addVertexWithUV(llllllllllllllllIIlllllIIlllllIl, llllllllllllllllIIlllllIIlllllII, 0.0, llllllllllllllllIIlllllIIllllIll * llllllllllllllllIIlllllIIlllIlIl, llllllllllllllllIIlllllIIllllIlI * llllllllllllllllIIlllllIIlllIlII);
        llllllllllllllllIIlllllIIlllIIll.draw();
    }
    
    protected void drawVerticalLine(final int llllllllllllllllIIllllllIllIIlIl, int llllllllllllllllIIllllllIlIlllll, int llllllllllllllllIIllllllIlIllllI, final int llllllllllllllllIIllllllIlIlllIl) {
        if (llllllllllllllllIIllllllIlIllllI < llllllllllllllllIIllllllIlIlllll) {
            final int llllllllllllllllIIllllllIllIIIIl = llllllllllllllllIIllllllIlIlllll;
            llllllllllllllllIIllllllIlIlllll = llllllllllllllllIIllllllIlIllllI;
            llllllllllllllllIIllllllIlIllllI = llllllllllllllllIIllllllIllIIIIl;
        }
        drawRect(llllllllllllllllIIllllllIllIIlIl, llllllllllllllllIIllllllIlIlllll + 1, llllllllllllllllIIllllllIllIIlIl + 1, llllllllllllllllIIllllllIlIllllI, llllllllllllllllIIllllllIlIlllIl);
    }
    
    public void drawTexturedModalRect(final int llllllllllllllllIIlllllIllIIllII, final int llllllllllllllllIIlllllIllIIlIll, final int llllllllllllllllIIlllllIllIlIlIl, final int llllllllllllllllIIlllllIllIIlIIl, final int llllllllllllllllIIlllllIllIIlIII, final int llllllllllllllllIIlllllIllIIIlll) {
        final float llllllllllllllllIIlllllIllIlIIIl = 0.00390625f;
        final float llllllllllllllllIIlllllIllIlIIII = 0.00390625f;
        final Tessellator llllllllllllllllIIlllllIllIIllll = Tessellator.getInstance();
        final WorldRenderer llllllllllllllllIIlllllIllIIlllI = llllllllllllllllIIlllllIllIIllll.getWorldRenderer();
        llllllllllllllllIIlllllIllIIlllI.startDrawingQuads();
        llllllllllllllllIIlllllIllIIlllI.addVertexWithUV(llllllllllllllllIIlllllIllIIllII + 0, llllllllllllllllIIlllllIllIIlIll + llllllllllllllllIIlllllIllIIIlll, this.zLevel, (llllllllllllllllIIlllllIllIlIlIl + 0) * llllllllllllllllIIlllllIllIlIIIl, (llllllllllllllllIIlllllIllIIlIIl + llllllllllllllllIIlllllIllIIIlll) * llllllllllllllllIIlllllIllIlIIII);
        llllllllllllllllIIlllllIllIIlllI.addVertexWithUV(llllllllllllllllIIlllllIllIIllII + llllllllllllllllIIlllllIllIIlIII, llllllllllllllllIIlllllIllIIlIll + llllllllllllllllIIlllllIllIIIlll, this.zLevel, (llllllllllllllllIIlllllIllIlIlIl + llllllllllllllllIIlllllIllIIlIII) * llllllllllllllllIIlllllIllIlIIIl, (llllllllllllllllIIlllllIllIIlIIl + llllllllllllllllIIlllllIllIIIlll) * llllllllllllllllIIlllllIllIlIIII);
        llllllllllllllllIIlllllIllIIlllI.addVertexWithUV(llllllllllllllllIIlllllIllIIllII + llllllllllllllllIIlllllIllIIlIII, llllllllllllllllIIlllllIllIIlIll + 0, this.zLevel, (llllllllllllllllIIlllllIllIlIlIl + llllllllllllllllIIlllllIllIIlIII) * llllllllllllllllIIlllllIllIlIIIl, (llllllllllllllllIIlllllIllIIlIIl + 0) * llllllllllllllllIIlllllIllIlIIII);
        llllllllllllllllIIlllllIllIIlllI.addVertexWithUV(llllllllllllllllIIlllllIllIIllII + 0, llllllllllllllllIIlllllIllIIlIll + 0, this.zLevel, (llllllllllllllllIIlllllIllIlIlIl + 0) * llllllllllllllllIIlllllIllIlIIIl, (llllllllllllllllIIlllllIllIIlIIl + 0) * llllllllllllllllIIlllllIllIlIIII);
        llllllllllllllllIIlllllIllIIllll.draw();
    }
    
    public void func_175174_a(final float llllllllllllllllIIlllllIlIllIllI, final float llllllllllllllllIIlllllIlIlIlIlI, final int llllllllllllllllIIlllllIlIllIlII, final int llllllllllllllllIIlllllIlIlIlIII, final int llllllllllllllllIIlllllIlIllIIlI, final int llllllllllllllllIIlllllIlIllIIIl) {
        final float llllllllllllllllIIlllllIlIllIIII = 0.00390625f;
        final float llllllllllllllllIIlllllIlIlIllll = 0.00390625f;
        final Tessellator llllllllllllllllIIlllllIlIlIlllI = Tessellator.getInstance();
        final WorldRenderer llllllllllllllllIIlllllIlIlIllIl = llllllllllllllllIIlllllIlIlIlllI.getWorldRenderer();
        llllllllllllllllIIlllllIlIlIllIl.startDrawingQuads();
        llllllllllllllllIIlllllIlIlIllIl.addVertexWithUV(llllllllllllllllIIlllllIlIllIllI + 0.0f, llllllllllllllllIIlllllIlIlIlIlI + llllllllllllllllIIlllllIlIllIIIl, this.zLevel, (llllllllllllllllIIlllllIlIllIlII + 0) * llllllllllllllllIIlllllIlIllIIII, (llllllllllllllllIIlllllIlIlIlIII + llllllllllllllllIIlllllIlIllIIIl) * llllllllllllllllIIlllllIlIlIllll);
        llllllllllllllllIIlllllIlIlIllIl.addVertexWithUV(llllllllllllllllIIlllllIlIllIllI + llllllllllllllllIIlllllIlIllIIlI, llllllllllllllllIIlllllIlIlIlIlI + llllllllllllllllIIlllllIlIllIIIl, this.zLevel, (llllllllllllllllIIlllllIlIllIlII + llllllllllllllllIIlllllIlIllIIlI) * llllllllllllllllIIlllllIlIllIIII, (llllllllllllllllIIlllllIlIlIlIII + llllllllllllllllIIlllllIlIllIIIl) * llllllllllllllllIIlllllIlIlIllll);
        llllllllllllllllIIlllllIlIlIllIl.addVertexWithUV(llllllllllllllllIIlllllIlIllIllI + llllllllllllllllIIlllllIlIllIIlI, llllllllllllllllIIlllllIlIlIlIlI + 0.0f, this.zLevel, (llllllllllllllllIIlllllIlIllIlII + llllllllllllllllIIlllllIlIllIIlI) * llllllllllllllllIIlllllIlIllIIII, (llllllllllllllllIIlllllIlIlIlIII + 0) * llllllllllllllllIIlllllIlIlIllll);
        llllllllllllllllIIlllllIlIlIllIl.addVertexWithUV(llllllllllllllllIIlllllIlIllIllI + 0.0f, llllllllllllllllIIlllllIlIlIlIlI + 0.0f, this.zLevel, (llllllllllllllllIIlllllIlIllIlII + 0) * llllllllllllllllIIlllllIlIllIIII, (llllllllllllllllIIlllllIlIlIlIII + 0) * llllllllllllllllIIlllllIlIlIllll);
        llllllllllllllllIIlllllIlIlIlllI.draw();
    }
    
    public void drawCenteredString(final FontRenderer llllllllllllllllIIlllllIlllllIII, final String llllllllllllllllIIlllllIllllIlll, final int llllllllllllllllIIlllllIlllllIll, final int llllllllllllllllIIlllllIllllIlIl, final int llllllllllllllllIIlllllIlllllIIl) {
        llllllllllllllllIIlllllIlllllIII.drawStringWithShadow(llllllllllllllllIIlllllIllllIlll, (float)(llllllllllllllllIIlllllIlllllIll - llllllllllllllllIIlllllIlllllIII.getStringWidth(llllllllllllllllIIlllllIllllIlll) / 2), (float)llllllllllllllllIIlllllIllllIlIl, llllllllllllllllIIlllllIlllllIIl);
    }
    
    public void drawString(final FontRenderer llllllllllllllllIIlllllIlllIlIII, final String llllllllllllllllIIlllllIlllIllII, final int llllllllllllllllIIlllllIlllIlIll, final int llllllllllllllllIIlllllIlllIlIlI, final int llllllllllllllllIIlllllIlllIIlII) {
        llllllllllllllllIIlllllIlllIlIII.drawStringWithShadow(llllllllllllllllIIlllllIlllIllII, (float)llllllllllllllllIIlllllIlllIlIll, (float)llllllllllllllllIIlllllIlllIlIlI, llllllllllllllllIIlllllIlllIIlII);
    }
    
    public void func_175175_a(final int llllllllllllllllIIlllllIlIIllIII, final int llllllllllllllllIIlllllIlIIIllll, final TextureAtlasSprite llllllllllllllllIIlllllIlIIIlllI, final int llllllllllllllllIIlllllIlIIIllIl, final int llllllllllllllllIIlllllIlIIlIlII) {
        final Tessellator llllllllllllllllIIlllllIlIIlIIll = Tessellator.getInstance();
        final WorldRenderer llllllllllllllllIIlllllIlIIlIIlI = llllllllllllllllIIlllllIlIIlIIll.getWorldRenderer();
        llllllllllllllllIIlllllIlIIlIIlI.startDrawingQuads();
        llllllllllllllllIIlllllIlIIlIIlI.addVertexWithUV(llllllllllllllllIIlllllIlIIllIII + 0, llllllllllllllllIIlllllIlIIIllll + llllllllllllllllIIlllllIlIIlIlII, this.zLevel, llllllllllllllllIIlllllIlIIIlllI.getMinU(), llllllllllllllllIIlllllIlIIIlllI.getMaxV());
        llllllllllllllllIIlllllIlIIlIIlI.addVertexWithUV(llllllllllllllllIIlllllIlIIllIII + llllllllllllllllIIlllllIlIIIllIl, llllllllllllllllIIlllllIlIIIllll + llllllllllllllllIIlllllIlIIlIlII, this.zLevel, llllllllllllllllIIlllllIlIIIlllI.getMaxU(), llllllllllllllllIIlllllIlIIIlllI.getMaxV());
        llllllllllllllllIIlllllIlIIlIIlI.addVertexWithUV(llllllllllllllllIIlllllIlIIllIII + llllllllllllllllIIlllllIlIIIllIl, llllllllllllllllIIlllllIlIIIllll + 0, this.zLevel, llllllllllllllllIIlllllIlIIIlllI.getMaxU(), llllllllllllllllIIlllllIlIIIlllI.getMinV());
        llllllllllllllllIIlllllIlIIlIIlI.addVertexWithUV(llllllllllllllllIIlllllIlIIllIII + 0, llllllllllllllllIIlllllIlIIIllll + 0, this.zLevel, llllllllllllllllIIlllllIlIIIlllI.getMinU(), llllllllllllllllIIlllllIlIIIlllI.getMinV());
        llllllllllllllllIIlllllIlIIlIIll.draw();
    }
}
