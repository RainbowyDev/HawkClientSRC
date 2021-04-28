package net.minecraft.client.shader;

import net.minecraft.client.renderer.texture.*;
import org.lwjgl.opengl.*;
import java.nio.*;
import net.minecraft.client.renderer.*;

public class Framebuffer
{
    public /* synthetic */ int framebufferWidth;
    public /* synthetic */ int framebufferFilter;
    public /* synthetic */ boolean useDepth;
    public /* synthetic */ int framebufferTextureWidth;
    public /* synthetic */ int framebufferTexture;
    public /* synthetic */ int depthBuffer;
    public /* synthetic */ float[] framebufferColor;
    public /* synthetic */ int framebufferHeight;
    public /* synthetic */ int framebufferTextureHeight;
    public /* synthetic */ int framebufferObject;
    
    public Framebuffer(final int lllllllllllllllllIIlIIlIlIIlIIII, final int lllllllllllllllllIIlIIlIlIIlIIll, final boolean lllllllllllllllllIIlIIlIlIIlIIlI) {
        this.useDepth = lllllllllllllllllIIlIIlIlIIlIIlI;
        this.framebufferObject = -1;
        this.framebufferTexture = -1;
        this.depthBuffer = -1;
        this.framebufferColor = new float[4];
        this.framebufferColor[0] = 1.0f;
        this.framebufferColor[1] = 1.0f;
        this.framebufferColor[2] = 1.0f;
        this.framebufferColor[3] = 0.0f;
        this.createBindFramebuffer(lllllllllllllllllIIlIIlIlIIlIIII, lllllllllllllllllIIlIIlIlIIlIIll);
    }
    
    public void deleteFramebuffer() {
        if (OpenGlHelper.isFramebufferEnabled()) {
            this.unbindFramebufferTexture();
            this.unbindFramebuffer();
            if (this.depthBuffer > -1) {
                OpenGlHelper.func_153184_g(this.depthBuffer);
                this.depthBuffer = -1;
            }
            if (this.framebufferTexture > -1) {
                TextureUtil.deleteTexture(this.framebufferTexture);
                this.framebufferTexture = -1;
            }
            if (this.framebufferObject > -1) {
                OpenGlHelper.func_153171_g(OpenGlHelper.field_153198_e, 0);
                OpenGlHelper.func_153174_h(this.framebufferObject);
                this.framebufferObject = -1;
            }
        }
    }
    
    public void bindFramebufferTexture() {
        if (OpenGlHelper.isFramebufferEnabled()) {
            GlStateManager.func_179144_i(this.framebufferTexture);
        }
    }
    
    public void createBindFramebuffer(final int lllllllllllllllllIIlIIlIlIIIlIIl, final int lllllllllllllllllIIlIIlIlIIIIlIl) {
        if (!OpenGlHelper.isFramebufferEnabled()) {
            this.framebufferWidth = lllllllllllllllllIIlIIlIlIIIlIIl;
            this.framebufferHeight = lllllllllllllllllIIlIIlIlIIIIlIl;
        }
        else {
            GlStateManager.enableDepth();
            if (this.framebufferObject >= 0) {
                this.deleteFramebuffer();
            }
            this.createFramebuffer(lllllllllllllllllIIlIIlIlIIIlIIl, lllllllllllllllllIIlIIlIlIIIIlIl);
            this.checkFramebufferComplete();
            OpenGlHelper.func_153171_g(OpenGlHelper.field_153198_e, 0);
        }
    }
    
    public void setFramebufferColor(final float lllllllllllllllllIIlIIlIIlIlllIl, final float lllllllllllllllllIIlIIlIIlIlllII, final float lllllllllllllllllIIlIIlIIlIlIllI, final float lllllllllllllllllIIlIIlIIlIlIlIl) {
        this.framebufferColor[0] = lllllllllllllllllIIlIIlIIlIlllIl;
        this.framebufferColor[1] = lllllllllllllllllIIlIIlIIlIlllII;
        this.framebufferColor[2] = lllllllllllllllllIIlIIlIIlIlIllI;
        this.framebufferColor[3] = lllllllllllllllllIIlIIlIIlIlIlIl;
    }
    
    public void createFramebuffer(final int lllllllllllllllllIIlIIlIIllllIlI, final int lllllllllllllllllIIlIIlIIllllIIl) {
        this.framebufferWidth = lllllllllllllllllIIlIIlIIllllIlI;
        this.framebufferHeight = lllllllllllllllllIIlIIlIIllllIIl;
        this.framebufferTextureWidth = lllllllllllllllllIIlIIlIIllllIlI;
        this.framebufferTextureHeight = lllllllllllllllllIIlIIlIIllllIIl;
        if (!OpenGlHelper.isFramebufferEnabled()) {
            this.framebufferClear();
        }
        else {
            this.framebufferObject = OpenGlHelper.func_153165_e();
            this.framebufferTexture = TextureUtil.glGenTextures();
            if (this.useDepth) {
                this.depthBuffer = OpenGlHelper.func_153185_f();
            }
            this.setFramebufferFilter(9728);
            GlStateManager.func_179144_i(this.framebufferTexture);
            GL11.glTexImage2D(3553, 0, 32856, this.framebufferTextureWidth, this.framebufferTextureHeight, 0, 6408, 5121, (ByteBuffer)null);
            OpenGlHelper.func_153171_g(OpenGlHelper.field_153198_e, this.framebufferObject);
            OpenGlHelper.func_153188_a(OpenGlHelper.field_153198_e, OpenGlHelper.field_153200_g, 3553, this.framebufferTexture, 0);
            if (this.useDepth) {
                OpenGlHelper.func_153176_h(OpenGlHelper.field_153199_f, this.depthBuffer);
                OpenGlHelper.func_153186_a(OpenGlHelper.field_153199_f, 33190, this.framebufferTextureWidth, this.framebufferTextureHeight);
                OpenGlHelper.func_153190_b(OpenGlHelper.field_153198_e, OpenGlHelper.field_153201_h, OpenGlHelper.field_153199_f, this.depthBuffer);
            }
            this.framebufferClear();
            this.unbindFramebufferTexture();
        }
    }
    
    public void framebufferRender(final int lllllllllllllllllIIlIIlIIlIIllIl, final int lllllllllllllllllIIlIIlIIlIIllll) {
        this.func_178038_a(lllllllllllllllllIIlIIlIIlIIllIl, lllllllllllllllllIIlIIlIIlIIllll, true);
    }
    
    public void unbindFramebuffer() {
        if (OpenGlHelper.isFramebufferEnabled()) {
            OpenGlHelper.func_153171_g(OpenGlHelper.field_153198_e, 0);
        }
    }
    
    public void func_178038_a(final int lllllllllllllllllIIlIIlIIIllIllI, final int lllllllllllllllllIIlIIlIIIllIlIl, final boolean lllllllllllllllllIIlIIlIIIlllllI) {
        if (OpenGlHelper.isFramebufferEnabled()) {
            GlStateManager.colorMask(true, true, true, false);
            GlStateManager.disableDepth();
            GlStateManager.depthMask(false);
            GlStateManager.matrixMode(5889);
            GlStateManager.loadIdentity();
            GlStateManager.ortho(0.0, lllllllllllllllllIIlIIlIIIllIllI, lllllllllllllllllIIlIIlIIIllIlIl, 0.0, 1000.0, 3000.0);
            GlStateManager.matrixMode(5888);
            GlStateManager.loadIdentity();
            GlStateManager.translate(0.0f, 0.0f, -2000.0f);
            GlStateManager.viewport(0, 0, lllllllllllllllllIIlIIlIIIllIllI, lllllllllllllllllIIlIIlIIIllIlIl);
            GlStateManager.func_179098_w();
            GlStateManager.disableLighting();
            GlStateManager.disableAlpha();
            if (lllllllllllllllllIIlIIlIIIlllllI) {
                GlStateManager.disableBlend();
                GlStateManager.enableColorMaterial();
            }
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.bindFramebufferTexture();
            final float lllllllllllllllllIIlIIlIIIllllIl = (float)lllllllllllllllllIIlIIlIIIllIllI;
            final float lllllllllllllllllIIlIIlIIIllllII = (float)lllllllllllllllllIIlIIlIIIllIlIl;
            final float lllllllllllllllllIIlIIlIIIlllIll = this.framebufferWidth / (float)this.framebufferTextureWidth;
            final float lllllllllllllllllIIlIIlIIIlllIlI = this.framebufferHeight / (float)this.framebufferTextureHeight;
            final Tessellator lllllllllllllllllIIlIIlIIIlllIIl = Tessellator.getInstance();
            final WorldRenderer lllllllllllllllllIIlIIlIIIlllIII = lllllllllllllllllIIlIIlIIIlllIIl.getWorldRenderer();
            lllllllllllllllllIIlIIlIIIlllIII.startDrawingQuads();
            lllllllllllllllllIIlIIlIIIlllIII.func_178991_c(-1);
            lllllllllllllllllIIlIIlIIIlllIII.addVertexWithUV(0.0, lllllllllllllllllIIlIIlIIIllllII, 0.0, 0.0, 0.0);
            lllllllllllllllllIIlIIlIIIlllIII.addVertexWithUV(lllllllllllllllllIIlIIlIIIllllIl, lllllllllllllllllIIlIIlIIIllllII, 0.0, lllllllllllllllllIIlIIlIIIlllIll, 0.0);
            lllllllllllllllllIIlIIlIIIlllIII.addVertexWithUV(lllllllllllllllllIIlIIlIIIllllIl, 0.0, 0.0, lllllllllllllllllIIlIIlIIIlllIll, lllllllllllllllllIIlIIlIIIlllIlI);
            lllllllllllllllllIIlIIlIIIlllIII.addVertexWithUV(0.0, 0.0, 0.0, 0.0, lllllllllllllllllIIlIIlIIIlllIlI);
            lllllllllllllllllIIlIIlIIIlllIIl.draw();
            this.unbindFramebufferTexture();
            GlStateManager.depthMask(true);
            GlStateManager.colorMask(true, true, true, true);
        }
    }
    
    public void bindFramebuffer(final boolean lllllllllllllllllIIlIIlIIllIIlll) {
        if (OpenGlHelper.isFramebufferEnabled()) {
            OpenGlHelper.func_153171_g(OpenGlHelper.field_153198_e, this.framebufferObject);
            if (lllllllllllllllllIIlIIlIIllIIlll) {
                GlStateManager.viewport(0, 0, this.framebufferWidth, this.framebufferHeight);
            }
        }
    }
    
    public void checkFramebufferComplete() {
        final int lllllllllllllllllIIlIIlIIlllIIII = OpenGlHelper.func_153167_i(OpenGlHelper.field_153198_e);
        if (lllllllllllllllllIIlIIlIIlllIIII == OpenGlHelper.field_153202_i) {
            return;
        }
        if (lllllllllllllllllIIlIIlIIlllIIII == OpenGlHelper.field_153203_j) {
            throw new RuntimeException("GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT");
        }
        if (lllllllllllllllllIIlIIlIIlllIIII == OpenGlHelper.field_153204_k) {
            throw new RuntimeException("GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT");
        }
        if (lllllllllllllllllIIlIIlIIlllIIII == OpenGlHelper.field_153205_l) {
            throw new RuntimeException("GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER");
        }
        if (lllllllllllllllllIIlIIlIIlllIIII == OpenGlHelper.field_153206_m) {
            throw new RuntimeException("GL_FRAMEBUFFER_INCOMPLETE_READ_BUFFER");
        }
        throw new RuntimeException(String.valueOf(new StringBuilder("glCheckFramebufferStatus returned unknown status:").append(lllllllllllllllllIIlIIlIIlllIIII)));
    }
    
    public void framebufferClear() {
        this.bindFramebuffer(true);
        GlStateManager.clearColor(this.framebufferColor[0], this.framebufferColor[1], this.framebufferColor[2], this.framebufferColor[3]);
        int lllllllllllllllllIIlIIlIIIlIlIlI = 16384;
        if (this.useDepth) {
            GlStateManager.clearDepth(1.0);
            lllllllllllllllllIIlIIlIIIlIlIlI |= 0x100;
        }
        GlStateManager.clear(lllllllllllllllllIIlIIlIIIlIlIlI);
        this.unbindFramebuffer();
    }
    
    static {
        __OBFID = "CL_00000959";
    }
    
    public void setFramebufferFilter(final int lllllllllllllllllIIlIIlIIlllIIll) {
        if (OpenGlHelper.isFramebufferEnabled()) {
            this.framebufferFilter = lllllllllllllllllIIlIIlIIlllIIll;
            GlStateManager.func_179144_i(this.framebufferTexture);
            GL11.glTexParameterf(3553, 10241, (float)lllllllllllllllllIIlIIlIIlllIIll);
            GL11.glTexParameterf(3553, 10240, (float)lllllllllllllllllIIlIIlIIlllIIll);
            GL11.glTexParameterf(3553, 10242, 10496.0f);
            GL11.glTexParameterf(3553, 10243, 10496.0f);
            GlStateManager.func_179144_i(0);
        }
    }
    
    public void unbindFramebufferTexture() {
        if (OpenGlHelper.isFramebufferEnabled()) {
            GlStateManager.func_179144_i(0);
        }
    }
}
