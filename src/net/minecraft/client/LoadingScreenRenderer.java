package net.minecraft.client;

import net.minecraft.client.shader.*;
import net.minecraft.util.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.renderer.*;

public class LoadingScreenRenderer implements IProgressUpdate
{
    private /* synthetic */ boolean field_73724_e;
    private /* synthetic */ Minecraft mc;
    private /* synthetic */ long field_73723_d;
    private /* synthetic */ Framebuffer field_146588_g;
    private /* synthetic */ String currentlyDisplayedText;
    private /* synthetic */ String field_73727_a;
    private /* synthetic */ ScaledResolution field_146587_f;
    
    @Override
    public void setLoadingProgress(final int lllllllllllllllIlIllIIIlIlIIlIII) {
        if (!this.mc.running) {
            if (!this.field_73724_e) {
                throw new MinecraftError();
            }
        }
        else {
            final long lllllllllllllllIlIllIIIlIlIIIlll = Minecraft.getSystemTime();
            if (lllllllllllllllIlIllIIIlIlIIIlll - this.field_73723_d >= 100L) {
                this.field_73723_d = lllllllllllllllIlIllIIIlIlIIIlll;
                final ScaledResolution lllllllllllllllIlIllIIIlIlIIIllI = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
                final int lllllllllllllllIlIllIIIlIlIIIlIl = lllllllllllllllIlIllIIIlIlIIIllI.getScaleFactor();
                final int lllllllllllllllIlIllIIIlIlIIIlII = lllllllllllllllIlIllIIIlIlIIIllI.getScaledWidth();
                final int lllllllllllllllIlIllIIIlIlIIIIll = lllllllllllllllIlIllIIIlIlIIIllI.getScaledHeight();
                if (OpenGlHelper.isFramebufferEnabled()) {
                    this.field_146588_g.framebufferClear();
                }
                else {
                    GlStateManager.clear(256);
                }
                this.field_146588_g.bindFramebuffer(false);
                GlStateManager.matrixMode(5889);
                GlStateManager.loadIdentity();
                GlStateManager.ortho(0.0, lllllllllllllllIlIllIIIlIlIIIllI.getScaledWidth_double(), lllllllllllllllIlIllIIIlIlIIIllI.getScaledHeight_double(), 0.0, 100.0, 300.0);
                GlStateManager.matrixMode(5888);
                GlStateManager.loadIdentity();
                GlStateManager.translate(0.0f, 0.0f, -200.0f);
                if (!OpenGlHelper.isFramebufferEnabled()) {
                    GlStateManager.clear(16640);
                }
                final Tessellator lllllllllllllllIlIllIIIlIlIIIIlI = Tessellator.getInstance();
                final WorldRenderer lllllllllllllllIlIllIIIlIlIIIIIl = lllllllllllllllIlIllIIIlIlIIIIlI.getWorldRenderer();
                this.mc.getTextureManager().bindTexture(Gui.optionsBackground);
                final float lllllllllllllllIlIllIIIlIlIIIIII = 32.0f;
                lllllllllllllllIlIllIIIlIlIIIIIl.startDrawingQuads();
                lllllllllllllllIlIllIIIlIlIIIIIl.func_178991_c(4210752);
                lllllllllllllllIlIllIIIlIlIIIIIl.addVertexWithUV(0.0, lllllllllllllllIlIllIIIlIlIIIIll, 0.0, 0.0, lllllllllllllllIlIllIIIlIlIIIIll / lllllllllllllllIlIllIIIlIlIIIIII);
                lllllllllllllllIlIllIIIlIlIIIIIl.addVertexWithUV(lllllllllllllllIlIllIIIlIlIIIlII, lllllllllllllllIlIllIIIlIlIIIIll, 0.0, lllllllllllllllIlIllIIIlIlIIIlII / lllllllllllllllIlIllIIIlIlIIIIII, lllllllllllllllIlIllIIIlIlIIIIll / lllllllllllllllIlIllIIIlIlIIIIII);
                lllllllllllllllIlIllIIIlIlIIIIIl.addVertexWithUV(lllllllllllllllIlIllIIIlIlIIIlII, 0.0, 0.0, lllllllllllllllIlIllIIIlIlIIIlII / lllllllllllllllIlIllIIIlIlIIIIII, 0.0);
                lllllllllllllllIlIllIIIlIlIIIIIl.addVertexWithUV(0.0, 0.0, 0.0, 0.0, 0.0);
                lllllllllllllllIlIllIIIlIlIIIIlI.draw();
                if (lllllllllllllllIlIllIIIlIlIIlIII >= 0) {
                    final byte lllllllllllllllIlIllIIIlIIllllll = 100;
                    final byte lllllllllllllllIlIllIIIlIIlllllI = 2;
                    final int lllllllllllllllIlIllIIIlIIllllIl = lllllllllllllllIlIllIIIlIlIIIlII / 2 - lllllllllllllllIlIllIIIlIIllllll / 2;
                    final int lllllllllllllllIlIllIIIlIIllllII = lllllllllllllllIlIllIIIlIlIIIIll / 2 + 16;
                    GlStateManager.func_179090_x();
                    lllllllllllllllIlIllIIIlIlIIIIIl.startDrawingQuads();
                    lllllllllllllllIlIllIIIlIlIIIIIl.func_178991_c(8421504);
                    lllllllllllllllIlIllIIIlIlIIIIIl.addVertex(lllllllllllllllIlIllIIIlIIllllIl, lllllllllllllllIlIllIIIlIIllllII, 0.0);
                    lllllllllllllllIlIllIIIlIlIIIIIl.addVertex(lllllllllllllllIlIllIIIlIIllllIl, lllllllllllllllIlIllIIIlIIllllII + lllllllllllllllIlIllIIIlIIlllllI, 0.0);
                    lllllllllllllllIlIllIIIlIlIIIIIl.addVertex(lllllllllllllllIlIllIIIlIIllllIl + lllllllllllllllIlIllIIIlIIllllll, lllllllllllllllIlIllIIIlIIllllII + lllllllllllllllIlIllIIIlIIlllllI, 0.0);
                    lllllllllllllllIlIllIIIlIlIIIIIl.addVertex(lllllllllllllllIlIllIIIlIIllllIl + lllllllllllllllIlIllIIIlIIllllll, lllllllllllllllIlIllIIIlIIllllII, 0.0);
                    lllllllllllllllIlIllIIIlIlIIIIIl.func_178991_c(8454016);
                    lllllllllllllllIlIllIIIlIlIIIIIl.addVertex(lllllllllllllllIlIllIIIlIIllllIl, lllllllllllllllIlIllIIIlIIllllII, 0.0);
                    lllllllllllllllIlIllIIIlIlIIIIIl.addVertex(lllllllllllllllIlIllIIIlIIllllIl, lllllllllllllllIlIllIIIlIIllllII + lllllllllllllllIlIllIIIlIIlllllI, 0.0);
                    lllllllllllllllIlIllIIIlIlIIIIIl.addVertex(lllllllllllllllIlIllIIIlIIllllIl + lllllllllllllllIlIllIIIlIlIIlIII, lllllllllllllllIlIllIIIlIIllllII + lllllllllllllllIlIllIIIlIIlllllI, 0.0);
                    lllllllllllllllIlIllIIIlIlIIIIIl.addVertex(lllllllllllllllIlIllIIIlIIllllIl + lllllllllllllllIlIllIIIlIlIIlIII, lllllllllllllllIlIllIIIlIIllllII, 0.0);
                    lllllllllllllllIlIllIIIlIlIIIIlI.draw();
                    GlStateManager.func_179098_w();
                }
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
                this.mc.fontRendererObj.drawStringWithShadow(this.currentlyDisplayedText, (float)((lllllllllllllllIlIllIIIlIlIIIlII - this.mc.fontRendererObj.getStringWidth(this.currentlyDisplayedText)) / 2), (float)(lllllllllllllllIlIllIIIlIlIIIIll / 2 - 4 - 16), 16777215);
                this.mc.fontRendererObj.drawStringWithShadow(this.field_73727_a, (float)((lllllllllllllllIlIllIIIlIlIIIlII - this.mc.fontRendererObj.getStringWidth(this.field_73727_a)) / 2), (float)(lllllllllllllllIlIllIIIlIlIIIIll / 2 - 4 + 8), 16777215);
                this.field_146588_g.unbindFramebuffer();
                if (OpenGlHelper.isFramebufferEnabled()) {
                    this.field_146588_g.framebufferRender(lllllllllllllllIlIllIIIlIlIIIlII * lllllllllllllllIlIllIIIlIlIIIlIl, lllllllllllllllIlIllIIIlIlIIIIll * lllllllllllllllIlIllIIIlIlIIIlIl);
                }
                this.mc.func_175601_h();
                try {
                    Thread.yield();
                }
                catch (Exception ex) {}
            }
        }
    }
    
    @Override
    public void setDoneWorking() {
    }
    
    public LoadingScreenRenderer(final Minecraft lllllllllllllllIlIllIIIlIlllIllI) {
        this.field_73727_a = "";
        this.currentlyDisplayedText = "";
        this.field_73723_d = Minecraft.getSystemTime();
        this.mc = lllllllllllllllIlIllIIIlIlllIllI;
        this.field_146587_f = new ScaledResolution(lllllllllllllllIlIllIIIlIlllIllI, lllllllllllllllIlIllIIIlIlllIllI.displayWidth, lllllllllllllllIlIllIIIlIlllIllI.displayHeight);
        this.field_146588_g = new Framebuffer(lllllllllllllllIlIllIIIlIlllIllI.displayWidth, lllllllllllllllIlIllIIIlIlllIllI.displayHeight, false);
        this.field_146588_g.setFramebufferFilter(9728);
    }
    
    @Override
    public void displayLoadingString(final String lllllllllllllllIlIllIIIlIlIllIlI) {
        if (!this.mc.running) {
            if (!this.field_73724_e) {
                throw new MinecraftError();
            }
        }
        else {
            this.field_73723_d = 0L;
            this.field_73727_a = lllllllllllllllIlIllIIIlIlIllIlI;
            this.setLoadingProgress(-1);
            this.field_73723_d = 0L;
        }
    }
    
    private void func_73722_d(final String lllllllllllllllIlIllIIIlIlIlllll) {
        this.currentlyDisplayedText = lllllllllllllllIlIllIIIlIlIlllll;
        if (!this.mc.running) {
            if (!this.field_73724_e) {
                throw new MinecraftError();
            }
        }
        else {
            GlStateManager.clear(256);
            GlStateManager.matrixMode(5889);
            GlStateManager.loadIdentity();
            if (OpenGlHelper.isFramebufferEnabled()) {
                final int lllllllllllllllIlIllIIIlIllIIIlI = this.field_146587_f.getScaleFactor();
                GlStateManager.ortho(0.0, this.field_146587_f.getScaledWidth() * lllllllllllllllIlIllIIIlIllIIIlI, this.field_146587_f.getScaledHeight() * lllllllllllllllIlIllIIIlIllIIIlI, 0.0, 100.0, 300.0);
            }
            else {
                final ScaledResolution lllllllllllllllIlIllIIIlIllIIIIl = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
                GlStateManager.ortho(0.0, lllllllllllllllIlIllIIIlIllIIIIl.getScaledWidth_double(), lllllllllllllllIlIllIIIlIllIIIIl.getScaledHeight_double(), 0.0, 100.0, 300.0);
            }
            GlStateManager.matrixMode(5888);
            GlStateManager.loadIdentity();
            GlStateManager.translate(0.0f, 0.0f, -200.0f);
        }
    }
    
    @Override
    public void displaySavingString(final String lllllllllllllllIlIllIIIlIllIlIlI) {
        this.field_73724_e = true;
        this.func_73722_d(lllllllllllllllIlIllIIIlIllIlIlI);
    }
    
    static {
        __OBFID = "CL_00000655";
    }
    
    @Override
    public void resetProgressAndMessage(final String lllllllllllllllIlIllIIIlIlllIIII) {
        this.field_73724_e = false;
        this.func_73722_d(lllllllllllllllIlIllIIIlIlllIIII);
    }
}
