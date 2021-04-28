package net.minecraft.client.shader;

import javax.vecmath.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;
import java.util.*;
import net.minecraft.client.resources.*;
import com.google.common.collect.*;
import net.minecraft.client.util.*;

public class Shader
{
    private final /* synthetic */ List listAuxWidths;
    public final /* synthetic */ Framebuffer framebufferIn;
    private final /* synthetic */ List listAuxFramebuffers;
    public final /* synthetic */ Framebuffer framebufferOut;
    private final /* synthetic */ List listAuxHeights;
    private final /* synthetic */ List listAuxNames;
    private final /* synthetic */ ShaderManager manager;
    private /* synthetic */ Matrix4f projectionMatrix;
    
    public void setProjectionMatrix(final Matrix4f llllllllllllllIlIIlIllIIIIllllII) {
        this.projectionMatrix = llllllllllllllIlIIlIllIIIIllllII;
    }
    
    public void addAuxFramebuffer(final String llllllllllllllIlIIlIllIIIlIIlIll, final Object llllllllllllllIlIIlIllIIIlIIlIlI, final int llllllllllllllIlIIlIllIIIlIIlIIl, final int llllllllllllllIlIIlIllIIIlIIIIll) {
        this.listAuxNames.add(this.listAuxNames.size(), llllllllllllllIlIIlIllIIIlIIlIll);
        this.listAuxFramebuffers.add(this.listAuxFramebuffers.size(), llllllllllllllIlIIlIllIIIlIIlIlI);
        this.listAuxWidths.add(this.listAuxWidths.size(), llllllllllllllIlIIlIllIIIlIIlIIl);
        this.listAuxHeights.add(this.listAuxHeights.size(), llllllllllllllIlIIlIllIIIlIIIIll);
    }
    
    public void loadShader(final float llllllllllllllIlIIlIllIIIIlIIlll) {
        this.preLoadShader();
        this.framebufferIn.unbindFramebuffer();
        final float llllllllllllllIlIIlIllIIIIllIIII = (float)this.framebufferOut.framebufferTextureWidth;
        final float llllllllllllllIlIIlIllIIIIlIllll = (float)this.framebufferOut.framebufferTextureHeight;
        GlStateManager.viewport(0, 0, (int)llllllllllllllIlIIlIllIIIIllIIII, (int)llllllllllllllIlIIlIllIIIIlIllll);
        this.manager.addSamplerTexture("DiffuseSampler", this.framebufferIn);
        for (int llllllllllllllIlIIlIllIIIIlIlllI = 0; llllllllllllllIlIIlIllIIIIlIlllI < this.listAuxFramebuffers.size(); ++llllllllllllllIlIIlIllIIIIlIlllI) {
            this.manager.addSamplerTexture(this.listAuxNames.get(llllllllllllllIlIIlIllIIIIlIlllI), this.listAuxFramebuffers.get(llllllllllllllIlIIlIllIIIIlIlllI));
            this.manager.getShaderUniformOrDefault(String.valueOf(new StringBuilder("AuxSize").append(llllllllllllllIlIIlIllIIIIlIlllI))).set(this.listAuxWidths.get(llllllllllllllIlIIlIllIIIIlIlllI), this.listAuxHeights.get(llllllllllllllIlIIlIllIIIIlIlllI));
        }
        this.manager.getShaderUniformOrDefault("ProjMat").set(this.projectionMatrix);
        this.manager.getShaderUniformOrDefault("InSize").set((float)this.framebufferIn.framebufferTextureWidth, (float)this.framebufferIn.framebufferTextureHeight);
        this.manager.getShaderUniformOrDefault("OutSize").set(llllllllllllllIlIIlIllIIIIllIIII, llllllllllllllIlIIlIllIIIIlIllll);
        this.manager.getShaderUniformOrDefault("Time").set(llllllllllllllIlIIlIllIIIIlIIlll);
        final Minecraft llllllllllllllIlIIlIllIIIIlIllIl = Minecraft.getMinecraft();
        this.manager.getShaderUniformOrDefault("ScreenSize").set((float)llllllllllllllIlIIlIllIIIIlIllIl.displayWidth, (float)llllllllllllllIlIIlIllIIIIlIllIl.displayHeight);
        this.manager.useShader();
        this.framebufferOut.framebufferClear();
        this.framebufferOut.bindFramebuffer(false);
        GlStateManager.depthMask(false);
        GlStateManager.colorMask(true, true, true, true);
        final Tessellator llllllllllllllIlIIlIllIIIIlIllII = Tessellator.getInstance();
        final WorldRenderer llllllllllllllIlIIlIllIIIIlIlIll = llllllllllllllIlIIlIllIIIIlIllII.getWorldRenderer();
        llllllllllllllIlIIlIllIIIIlIlIll.startDrawingQuads();
        llllllllllllllIlIIlIllIIIIlIlIll.func_178991_c(-1);
        llllllllllllllIlIIlIllIIIIlIlIll.addVertex(0.0, llllllllllllllIlIIlIllIIIIlIllll, 500.0);
        llllllllllllllIlIIlIllIIIIlIlIll.addVertex(llllllllllllllIlIIlIllIIIIllIIII, llllllllllllllIlIIlIllIIIIlIllll, 500.0);
        llllllllllllllIlIIlIllIIIIlIlIll.addVertex(llllllllllllllIlIIlIllIIIIllIIII, 0.0, 500.0);
        llllllllllllllIlIIlIllIIIIlIlIll.addVertex(0.0, 0.0, 500.0);
        llllllllllllllIlIIlIllIIIIlIllII.draw();
        GlStateManager.depthMask(true);
        GlStateManager.colorMask(true, true, true, true);
        this.manager.endShader();
        this.framebufferOut.unbindFramebuffer();
        this.framebufferIn.unbindFramebufferTexture();
        for (final Object llllllllllllllIlIIlIllIIIIlIlIIl : this.listAuxFramebuffers) {
            if (llllllllllllllIlIIlIllIIIIlIlIIl instanceof Framebuffer) {
                ((Framebuffer)llllllllllllllIlIIlIllIIIIlIlIIl).unbindFramebufferTexture();
            }
        }
    }
    
    public Shader(final IResourceManager llllllllllllllIlIIlIllIIIlIllIII, final String llllllllllllllIlIIlIllIIIlIlllII, final Framebuffer llllllllllllllIlIIlIllIIIlIllIll, final Framebuffer llllllllllllllIlIIlIllIIIlIlIlIl) throws JsonException {
        this.listAuxFramebuffers = Lists.newArrayList();
        this.listAuxNames = Lists.newArrayList();
        this.listAuxWidths = Lists.newArrayList();
        this.listAuxHeights = Lists.newArrayList();
        this.manager = new ShaderManager(llllllllllllllIlIIlIllIIIlIllIII, llllllllllllllIlIIlIllIIIlIlllII);
        this.framebufferIn = llllllllllllllIlIIlIllIIIlIllIll;
        this.framebufferOut = llllllllllllllIlIIlIllIIIlIlIlIl;
    }
    
    private void preLoadShader() {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.disableBlend();
        GlStateManager.disableDepth();
        GlStateManager.disableAlpha();
        GlStateManager.disableFog();
        GlStateManager.disableLighting();
        GlStateManager.disableColorMaterial();
        GlStateManager.func_179098_w();
        GlStateManager.func_179144_i(0);
    }
    
    public void deleteShader() {
        this.manager.deleteShader();
    }
    
    public ShaderManager getShaderManager() {
        return this.manager;
    }
    
    static {
        __OBFID = "CL_00001042";
    }
}
