package com.lukflug.panelstudio.mc8forge;

import com.lukflug.panelstudio.*;
import java.util.*;
import java.nio.*;
import org.lwjgl.opengl.*;
import org.lwjgl.util.glu.*;
import net.minecraft.client.renderer.*;
import java.awt.*;
import net.minecraft.util.*;
import net.minecraft.client.*;
import javax.imageio.*;
import net.minecraft.client.renderer.texture.*;
import java.io.*;
import java.awt.image.*;

public abstract class GLInterface implements Interface
{
    protected /* synthetic */ boolean clipX;
    private static final /* synthetic */ IntBuffer VIEWPORT;
    private /* synthetic */ Stack<Rectangle> clipRect;
    private static final /* synthetic */ FloatBuffer PROJECTION;
    private static final /* synthetic */ FloatBuffer MODELVIEW;
    private static final /* synthetic */ FloatBuffer COORDS;
    
    public GLInterface(final boolean lllllllllllllllllIIllIIllIIIIIIl) {
        this.clipRect = new Stack<Rectangle>();
        this.clipX = lllllllllllllllllIIllIIllIIIIIIl;
    }
    
    public static void begin() {
        GlStateManager.enableBlend();
        GL11.glDisable(3553);
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.shadeModel(7425);
        GL11.glLineWidth(2.0f);
    }
    
    protected void scissor(final Rectangle lllllllllllllllllIIllIIIllIlllll) {
        if (lllllllllllllllllIIllIIIllIlllll == null) {
            GL11.glScissor(0, 0, 0, 0);
            GL11.glEnable(3089);
            return;
        }
        GLU.gluProject((float)lllllllllllllllllIIllIIIllIlllll.x, (float)lllllllllllllllllIIllIIIllIlllll.y, this.getZLevel(), GLInterface.MODELVIEW, GLInterface.PROJECTION, GLInterface.VIEWPORT, GLInterface.COORDS);
        float lllllllllllllllllIIllIIIllIllllI = GLInterface.COORDS.get(0);
        final float lllllllllllllllllIIllIIIllIlllIl = GLInterface.COORDS.get(1);
        GLU.gluProject((float)(lllllllllllllllllIIllIIIllIlllll.x + lllllllllllllllllIIllIIIllIlllll.width), (float)(lllllllllllllllllIIllIIIllIlllll.y + lllllllllllllllllIIllIIIllIlllll.height), this.getZLevel(), GLInterface.MODELVIEW, GLInterface.PROJECTION, GLInterface.VIEWPORT, GLInterface.COORDS);
        float lllllllllllllllllIIllIIIllIlllII = GLInterface.COORDS.get(0);
        final float lllllllllllllllllIIllIIIllIllIll = GLInterface.COORDS.get(1);
        if (!this.clipX) {
            lllllllllllllllllIIllIIIllIllllI = (float)GLInterface.VIEWPORT.get(0);
            lllllllllllllllllIIllIIIllIlllII = lllllllllllllllllIIllIIIllIllllI + GLInterface.VIEWPORT.get(2);
        }
        GL11.glScissor(Math.round(Math.min(lllllllllllllllllIIllIIIllIllllI, lllllllllllllllllIIllIIIllIlllII)), Math.round(Math.min(lllllllllllllllllIIllIIIllIlllIl, lllllllllllllllllIIllIIIllIllIll)), Math.round(Math.abs(lllllllllllllllllIIllIIIllIlllII - lllllllllllllllllIIllIIIllIllllI)), Math.round(Math.abs(lllllllllllllllllIIllIIIllIllIll - lllllllllllllllllIIllIIIllIlllIl)));
        GL11.glEnable(3089);
    }
    
    public static void end() {
        GlStateManager.shadeModel(7424);
        GL11.glEnable(3553);
        GlStateManager.disableBlend();
    }
    
    public void getMatrices() {
        GlStateManager.getFloat(2982, GLInterface.MODELVIEW);
        GlStateManager.getFloat(2983, GLInterface.PROJECTION);
        GL11.glGetInteger(2978, GLInterface.VIEWPORT);
    }
    
    protected abstract String getResourcePrefix();
    
    protected abstract float getZLevel();
    
    @Override
    public void drawRect(final Rectangle lllllllllllllllllIIllIIlIIlIllIl, final Color lllllllllllllllllIIllIIlIIlIIlII, final Color lllllllllllllllllIIllIIlIIlIIIll, final Color lllllllllllllllllIIllIIlIIlIlIlI, final Color lllllllllllllllllIIllIIlIIlIlIIl) {
        final Tessellator lllllllllllllllllIIllIIlIIlIlIII = Tessellator.getInstance();
        final WorldRenderer lllllllllllllllllIIllIIlIIlIIlll = lllllllllllllllllIIllIIlIIlIlIII.getWorldRenderer();
        lllllllllllllllllIIllIIlIIlIIlll.startDrawing(2);
        lllllllllllllllllIIllIIlIIlIIlll.func_178960_a(lllllllllllllllllIIllIIlIIlIlIIl.getRed() / 255.0f, lllllllllllllllllIIllIIlIIlIlIIl.getGreen() / 255.0f, lllllllllllllllllIIllIIlIIlIlIIl.getBlue() / 255.0f, lllllllllllllllllIIllIIlIIlIlIIl.getAlpha() / 255.0f);
        lllllllllllllllllIIllIIlIIlIIlll.addVertex(lllllllllllllllllIIllIIlIIlIllIl.x, lllllllllllllllllIIllIIlIIlIllIl.y + lllllllllllllllllIIllIIlIIlIllIl.height, this.getZLevel());
        lllllllllllllllllIIllIIlIIlIIlll.func_178960_a(lllllllllllllllllIIllIIlIIlIlIlI.getRed() / 255.0f, lllllllllllllllllIIllIIlIIlIlIlI.getGreen() / 255.0f, lllllllllllllllllIIllIIlIIlIlIlI.getBlue() / 255.0f, lllllllllllllllllIIllIIlIIlIlIlI.getAlpha() / 255.0f);
        lllllllllllllllllIIllIIlIIlIIlll.addVertex(lllllllllllllllllIIllIIlIIlIllIl.x + lllllllllllllllllIIllIIlIIlIllIl.width, lllllllllllllllllIIllIIlIIlIllIl.y + lllllllllllllllllIIllIIlIIlIllIl.height, this.getZLevel());
        lllllllllllllllllIIllIIlIIlIIlll.func_178960_a(lllllllllllllllllIIllIIlIIlIIIll.getRed() / 255.0f, lllllllllllllllllIIllIIlIIlIIIll.getGreen() / 255.0f, lllllllllllllllllIIllIIlIIlIIIll.getBlue() / 255.0f, lllllllllllllllllIIllIIlIIlIIIll.getAlpha() / 255.0f);
        lllllllllllllllllIIllIIlIIlIIlll.addVertex(lllllllllllllllllIIllIIlIIlIllIl.x + lllllllllllllllllIIllIIlIIlIllIl.width, lllllllllllllllllIIllIIlIIlIllIl.y, this.getZLevel());
        lllllllllllllllllIIllIIlIIlIIlll.func_178960_a(lllllllllllllllllIIllIIlIIlIIlII.getRed() / 255.0f, lllllllllllllllllIIllIIlIIlIIlII.getGreen() / 255.0f, lllllllllllllllllIIllIIlIIlIIlII.getBlue() / 255.0f, lllllllllllllllllIIllIIlIIlIIlII.getAlpha() / 255.0f);
        lllllllllllllllllIIllIIlIIlIIlll.addVertex(lllllllllllllllllIIllIIlIIlIllIl.x, lllllllllllllllllIIllIIlIIlIllIl.y, this.getZLevel());
        lllllllllllllllllIIllIIlIIlIlIII.draw();
    }
    
    @Override
    public void drawImage(final Rectangle lllllllllllllllllIIllIIlIIIIIIIl, final int lllllllllllllllllIIllIIlIIIIIIII, final boolean lllllllllllllllllIIllIIIllllIIlI, final int lllllllllllllllllIIllIIIllllIIIl) {
        if (lllllllllllllllllIIllIIIllllIIIl == 0) {
            return;
        }
        final int[][] lllllllllllllllllIIllIIIllllllIl = { { 0, 1 }, { 1, 1 }, { 1, 0 }, new int[2] };
        for (int lllllllllllllllllIIllIIIllllllII = 0; lllllllllllllllllIIllIIIllllllII < lllllllllllllllllIIllIIlIIIIIIII % 4; ++lllllllllllllllllIIllIIIllllllII) {
            final int lllllllllllllllllIIllIIIlllllIll = lllllllllllllllllIIllIIIllllllIl[3][0];
            final int lllllllllllllllllIIllIIIlllllIlI = lllllllllllllllllIIllIIIllllllIl[3][1];
            lllllllllllllllllIIllIIIllllllIl[3][0] = lllllllllllllllllIIllIIIllllllIl[2][0];
            lllllllllllllllllIIllIIIllllllIl[3][1] = lllllllllllllllllIIllIIIllllllIl[2][1];
            lllllllllllllllllIIllIIIllllllIl[2][0] = lllllllllllllllllIIllIIIllllllIl[1][0];
            lllllllllllllllllIIllIIIllllllIl[2][1] = lllllllllllllllllIIllIIIllllllIl[1][1];
            lllllllllllllllllIIllIIIllllllIl[1][0] = lllllllllllllllllIIllIIIllllllIl[0][0];
            lllllllllllllllllIIllIIIllllllIl[1][1] = lllllllllllllllllIIllIIIllllllIl[0][1];
            lllllllllllllllllIIllIIIllllllIl[0][0] = lllllllllllllllllIIllIIIlllllIll;
            lllllllllllllllllIIllIIIllllllIl[0][1] = lllllllllllllllllIIllIIIlllllIlI;
        }
        if (lllllllllllllllllIIllIIIllllIIlI) {
            int lllllllllllllllllIIllIIIlllllIIl = lllllllllllllllllIIllIIIllllllIl[3][0];
            int lllllllllllllllllIIllIIIlllllIII = lllllllllllllllllIIllIIIllllllIl[3][1];
            lllllllllllllllllIIllIIIllllllIl[3][0] = lllllllllllllllllIIllIIIllllllIl[0][0];
            lllllllllllllllllIIllIIIllllllIl[3][1] = lllllllllllllllllIIllIIIllllllIl[0][1];
            lllllllllllllllllIIllIIIllllllIl[0][0] = lllllllllllllllllIIllIIIlllllIIl;
            lllllllllllllllllIIllIIIllllllIl[0][1] = lllllllllllllllllIIllIIIlllllIII;
            lllllllllllllllllIIllIIIlllllIIl = lllllllllllllllllIIllIIIllllllIl[2][0];
            lllllllllllllllllIIllIIIlllllIII = lllllllllllllllllIIllIIIllllllIl[2][1];
            lllllllllllllllllIIllIIIllllllIl[2][0] = lllllllllllllllllIIllIIIllllllIl[1][0];
            lllllllllllllllllIIllIIIllllllIl[2][1] = lllllllllllllllllIIllIIIllllllIl[1][1];
            lllllllllllllllllIIllIIIllllllIl[1][0] = lllllllllllllllllIIllIIIlllllIIl;
            lllllllllllllllllIIllIIIllllllIl[1][1] = lllllllllllllllllIIllIIIlllllIII;
        }
        final Tessellator lllllllllllllllllIIllIIIllllIlll = Tessellator.getInstance();
        final WorldRenderer lllllllllllllllllIIllIIIllllIllI = lllllllllllllllllIIllIIIllllIlll.getWorldRenderer();
        GL11.glBindTexture(3553, lllllllllllllllllIIllIIIllllIIIl);
        GL11.glEnable(3553);
        lllllllllllllllllIIllIIIllllIllI.startDrawingQuads();
        lllllllllllllllllIIllIIIllllIllI.addVertex(lllllllllllllllllIIllIIlIIIIIIIl.x, lllllllllllllllllIIllIIlIIIIIIIl.y + lllllllllllllllllIIllIIlIIIIIIIl.height, this.getZLevel());
        lllllllllllllllllIIllIIIllllIllI.setTextureUV(lllllllllllllllllIIllIIIllllllIl[0][0], lllllllllllllllllIIllIIIllllllIl[0][1]);
        lllllllllllllllllIIllIIIllllIllI.addVertexWithUV(lllllllllllllllllIIllIIlIIIIIIIl.x + lllllllllllllllllIIllIIlIIIIIIIl.width, lllllllllllllllllIIllIIlIIIIIIIl.y + lllllllllllllllllIIllIIlIIIIIIIl.height, this.getZLevel(), lllllllllllllllllIIllIIIllllllIl[1][0], lllllllllllllllllIIllIIIllllllIl[1][1]);
        lllllllllllllllllIIllIIIllllIllI.addVertexWithUV(lllllllllllllllllIIllIIlIIIIIIIl.x + lllllllllllllllllIIllIIlIIIIIIIl.width, lllllllllllllllllIIllIIlIIIIIIIl.y, this.getZLevel(), lllllllllllllllllIIllIIIllllllIl[2][0], lllllllllllllllllIIllIIIllllllIl[2][1]);
        lllllllllllllllllIIllIIIllllIllI.addVertexWithUV(lllllllllllllllllIIllIIlIIIIIIIl.x, lllllllllllllllllIIllIIlIIIIIIIl.y, this.getZLevel(), lllllllllllllllllIIllIIIllllllIl[3][0], lllllllllllllllllIIllIIIllllllIl[3][1]);
        lllllllllllllllllIIllIIIllllIlll.draw();
        GL11.glDisable(3553);
    }
    
    static {
        MODELVIEW = GLAllocation.createDirectFloatBuffer(16);
        PROJECTION = GLAllocation.createDirectFloatBuffer(16);
        VIEWPORT = GLAllocation.createDirectIntBuffer(16);
        COORDS = GLAllocation.createDirectFloatBuffer(3);
    }
    
    @Override
    public void window(final Rectangle lllllllllllllllllIIllIIIllIIIIIl) {
        if (this.clipRect.isEmpty()) {
            this.scissor(lllllllllllllllllIIllIIIllIIIIIl);
            this.clipRect.push(lllllllllllllllllIIllIIIllIIIIIl);
        }
        else {
            final Rectangle lllllllllllllllllIIllIIIllIIlIlI = this.clipRect.peek();
            if (lllllllllllllllllIIllIIIllIIlIlI == null) {
                this.scissor(null);
                this.clipRect.push(null);
            }
            else {
                final int lllllllllllllllllIIllIIIllIIlIIl = Math.max(lllllllllllllllllIIllIIIllIIIIIl.x, lllllllllllllllllIIllIIIllIIlIlI.x);
                final int lllllllllllllllllIIllIIIllIIlIII = Math.max(lllllllllllllllllIIllIIIllIIIIIl.y, lllllllllllllllllIIllIIIllIIlIlI.y);
                final int lllllllllllllllllIIllIIIllIIIlll = Math.min(lllllllllllllllllIIllIIIllIIIIIl.x + lllllllllllllllllIIllIIIllIIIIIl.width, lllllllllllllllllIIllIIIllIIlIlI.x + lllllllllllllllllIIllIIIllIIlIlI.width);
                final int lllllllllllllllllIIllIIIllIIIlIl = Math.min(lllllllllllllllllIIllIIIllIIIIIl.y + lllllllllllllllllIIllIIIllIIIIIl.height, lllllllllllllllllIIllIIIllIIlIlI.y + lllllllllllllllllIIllIIIllIIlIlI.height);
                if (lllllllllllllllllIIllIIIllIIIlll > lllllllllllllllllIIllIIIllIIlIIl && lllllllllllllllllIIllIIIllIIIlIl > lllllllllllllllllIIllIIIllIIlIII) {
                    final Rectangle lllllllllllllllllIIllIIIllIIIlII = new Rectangle(lllllllllllllllllIIllIIIllIIlIIl, lllllllllllllllllIIllIIIllIIlIII, lllllllllllllllllIIllIIIllIIIlll - lllllllllllllllllIIllIIIllIIlIIl, lllllllllllllllllIIllIIIllIIIlIl - lllllllllllllllllIIllIIIllIIlIII);
                    this.scissor(lllllllllllllllllIIllIIIllIIIlII);
                    this.clipRect.push(lllllllllllllllllIIllIIIllIIIlII);
                }
                else {
                    this.scissor(null);
                    this.clipRect.push(null);
                }
            }
        }
    }
    
    @Override
    public void restore() {
        if (!this.clipRect.isEmpty()) {
            this.clipRect.pop();
            if (this.clipRect.isEmpty()) {
                GL11.glDisable(3089);
            }
            else {
                this.scissor(this.clipRect.peek());
            }
        }
    }
    
    @Override
    public void fillTriangle(final Point lllllllllllllllllIIllIIlIllIlIll, final Point lllllllllllllllllIIllIIlIllIlIlI, final Point lllllllllllllllllIIllIIlIlllIIlI, final Color lllllllllllllllllIIllIIlIlllIIIl, final Color lllllllllllllllllIIllIIlIllIIlll, final Color lllllllllllllllllIIllIIlIllIllll) {
        final Tessellator lllllllllllllllllIIllIIlIllIlllI = Tessellator.getInstance();
        final WorldRenderer lllllllllllllllllIIllIIlIllIllIl = lllllllllllllllllIIllIIlIllIlllI.getWorldRenderer();
        lllllllllllllllllIIllIIlIllIllIl.startDrawing(4);
        lllllllllllllllllIIllIIlIllIllIl.func_178960_a(lllllllllllllllllIIllIIlIlllIIIl.getRed() / 255.0f, lllllllllllllllllIIllIIlIlllIIIl.getGreen() / 255.0f, lllllllllllllllllIIllIIlIlllIIIl.getBlue() / 255.0f, lllllllllllllllllIIllIIlIlllIIIl.getAlpha() / 255.0f);
        lllllllllllllllllIIllIIlIllIllIl.addVertex(lllllllllllllllllIIllIIlIllIlIll.x, lllllllllllllllllIIllIIlIllIlIll.y, this.getZLevel());
        lllllllllllllllllIIllIIlIllIllIl.func_178960_a(lllllllllllllllllIIllIIlIllIIlll.getRed() / 255.0f, lllllllllllllllllIIllIIlIllIIlll.getGreen() / 255.0f, lllllllllllllllllIIllIIlIllIIlll.getBlue() / 255.0f, lllllllllllllllllIIllIIlIllIIlll.getAlpha() / 255.0f);
        lllllllllllllllllIIllIIlIllIllIl.addVertex(lllllllllllllllllIIllIIlIllIlIlI.x, lllllllllllllllllIIllIIlIllIlIlI.y, this.getZLevel());
        lllllllllllllllllIIllIIlIllIllIl.func_178960_a(lllllllllllllllllIIllIIlIllIllll.getRed() / 255.0f, lllllllllllllllllIIllIIlIllIllll.getGreen() / 255.0f, lllllllllllllllllIIllIIlIllIllll.getBlue() / 255.0f, lllllllllllllllllIIllIIlIllIllll.getAlpha() / 255.0f);
        lllllllllllllllllIIllIIlIllIllIl.addVertex(lllllllllllllllllIIllIIlIlllIIlI.x, lllllllllllllllllIIllIIlIlllIIlI.y, this.getZLevel());
        lllllllllllllllllIIllIIlIllIlllI.draw();
    }
    
    @Override
    public void drawLine(final Point lllllllllllllllllIIllIIlIlIlIlII, final Point lllllllllllllllllIIllIIlIlIllIlI, final Color lllllllllllllllllIIllIIlIlIllIIl, final Color lllllllllllllllllIIllIIlIlIlIIIl) {
        final Tessellator lllllllllllllllllIIllIIlIlIlIlll = Tessellator.getInstance();
        final WorldRenderer lllllllllllllllllIIllIIlIlIlIllI = lllllllllllllllllIIllIIlIlIlIlll.getWorldRenderer();
        lllllllllllllllllIIllIIlIlIlIllI.startDrawing(1);
        lllllllllllllllllIIllIIlIlIlIllI.func_178960_a(lllllllllllllllllIIllIIlIlIllIIl.getRed() / 255.0f, lllllllllllllllllIIllIIlIlIllIIl.getGreen() / 255.0f, lllllllllllllllllIIllIIlIlIllIIl.getBlue() / 255.0f, lllllllllllllllllIIllIIlIlIllIIl.getAlpha() / 255.0f);
        lllllllllllllllllIIllIIlIlIlIllI.addVertex(lllllllllllllllllIIllIIlIlIlIlII.x, lllllllllllllllllIIllIIlIlIlIlII.y, this.getZLevel());
        lllllllllllllllllIIllIIlIlIlIllI.func_178960_a(lllllllllllllllllIIllIIlIlIlIIIl.getRed() / 255.0f, lllllllllllllllllIIllIIlIlIlIIIl.getGreen() / 255.0f, lllllllllllllllllIIllIIlIlIlIIIl.getBlue() / 255.0f, lllllllllllllllllIIllIIlIlIlIIIl.getAlpha() / 255.0f);
        lllllllllllllllllIIllIIlIlIlIllI.addVertex(lllllllllllllllllIIllIIlIlIllIlI.x, lllllllllllllllllIIllIIlIlIllIlI.y, this.getZLevel());
        lllllllllllllllllIIllIIlIlIlIlll.draw();
    }
    
    @Override
    public synchronized int loadImage(final String lllllllllllllllllIIllIIlIIIlIlll) {
        try {
            final ResourceLocation lllllllllllllllllIIllIIlIIIlIllI = new ResourceLocation(String.valueOf(new StringBuilder(String.valueOf(this.getResourcePrefix())).append(lllllllllllllllllIIllIIlIIIlIlll)));
            final InputStream lllllllllllllllllIIllIIlIIIlIlIl = Minecraft.getMinecraft().getResourceManager().getResource(lllllllllllllllllIIllIIlIIIlIllI).getInputStream();
            final BufferedImage lllllllllllllllllIIllIIlIIIlIlII = ImageIO.read(lllllllllllllllllIIllIIlIIIlIlIl);
            final int lllllllllllllllllIIllIIlIIIlIIll = TextureUtil.glGenTextures();
            TextureUtil.uploadTextureImage(lllllllllllllllllIIllIIlIIIlIIll, lllllllllllllllllIIllIIlIIIlIlII);
            return lllllllllllllllllIIllIIlIIIlIIll;
        }
        catch (IOException lllllllllllllllllIIllIIlIIIlIIlI) {
            lllllllllllllllllIIllIIlIIIlIIlI.printStackTrace();
            return 0;
        }
    }
    
    @Override
    public void fillRect(final Rectangle lllllllllllllllllIIllIIlIIllllIl, final Color lllllllllllllllllIIllIIlIIllllII, final Color lllllllllllllllllIIllIIlIIlllIll, final Color lllllllllllllllllIIllIIlIlIIIIlI, final Color lllllllllllllllllIIllIIlIlIIIIIl) {
        final Tessellator lllllllllllllllllIIllIIlIlIIIIII = Tessellator.getInstance();
        final WorldRenderer lllllllllllllllllIIllIIlIIllllll = lllllllllllllllllIIllIIlIlIIIIII.getWorldRenderer();
        lllllllllllllllllIIllIIlIIllllll.startDrawingQuads();
        lllllllllllllllllIIllIIlIIllllll.func_178960_a(lllllllllllllllllIIllIIlIlIIIIIl.getRed() / 255.0f, lllllllllllllllllIIllIIlIlIIIIIl.getGreen() / 255.0f, lllllllllllllllllIIllIIlIlIIIIIl.getBlue() / 255.0f, lllllllllllllllllIIllIIlIlIIIIIl.getAlpha() / 255.0f);
        lllllllllllllllllIIllIIlIIllllll.addVertex(lllllllllllllllllIIllIIlIIllllIl.x, lllllllllllllllllIIllIIlIIllllIl.y + lllllllllllllllllIIllIIlIIllllIl.height, this.getZLevel());
        lllllllllllllllllIIllIIlIIllllll.func_178960_a(lllllllllllllllllIIllIIlIlIIIIlI.getRed() / 255.0f, lllllllllllllllllIIllIIlIlIIIIlI.getGreen() / 255.0f, lllllllllllllllllIIllIIlIlIIIIlI.getBlue() / 255.0f, lllllllllllllllllIIllIIlIlIIIIlI.getAlpha() / 255.0f);
        lllllllllllllllllIIllIIlIIllllll.addVertex(lllllllllllllllllIIllIIlIIllllIl.x + lllllllllllllllllIIllIIlIIllllIl.width, lllllllllllllllllIIllIIlIIllllIl.y + lllllllllllllllllIIllIIlIIllllIl.height, this.getZLevel());
        lllllllllllllllllIIllIIlIIllllll.func_178960_a(lllllllllllllllllIIllIIlIIlllIll.getRed() / 255.0f, lllllllllllllllllIIllIIlIIlllIll.getGreen() / 255.0f, lllllllllllllllllIIllIIlIIlllIll.getBlue() / 255.0f, lllllllllllllllllIIllIIlIIlllIll.getAlpha() / 255.0f);
        lllllllllllllllllIIllIIlIIllllll.addVertex(lllllllllllllllllIIllIIlIIllllIl.x + lllllllllllllllllIIllIIlIIllllIl.width, lllllllllllllllllIIllIIlIIllllIl.y, this.getZLevel());
        lllllllllllllllllIIllIIlIIllllll.func_178960_a(lllllllllllllllllIIllIIlIIllllII.getRed() / 255.0f, lllllllllllllllllIIllIIlIIllllII.getGreen() / 255.0f, lllllllllllllllllIIllIIlIIllllII.getBlue() / 255.0f, lllllllllllllllllIIllIIlIIllllII.getAlpha() / 255.0f);
        lllllllllllllllllIIllIIlIIllllll.addVertex(lllllllllllllllllIIllIIlIIllllIl.x, lllllllllllllllllIIllIIlIIllllIl.y, this.getZLevel());
        lllllllllllllllllIIllIIlIlIIIIII.draw();
    }
}
