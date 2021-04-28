package shadersmod.client;

import net.minecraft.entity.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.client.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.renderer.texture.*;
import optifine.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.culling.*;
import net.minecraft.client.renderer.*;

public class ShadersRender
{
    public static void beginTranslucent() {
        if (Shaders.isRenderingWorld) {
            if (Shaders.usedDepthBuffers >= 2) {
                GlStateManager.setActiveTexture(33995);
                Shaders.checkGLError("pre copy depth");
                GL11.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, Shaders.renderWidth, Shaders.renderHeight);
                Shaders.checkGLError("copy depth");
                GlStateManager.setActiveTexture(33984);
            }
            Shaders.useProgram(12);
        }
    }
    
    public static void setupArrayPointersVbo() {
        final boolean llIIIIIllIlllIl = true;
        GL11.glVertexPointer(3, 5126, 56, 0L);
        GL11.glColorPointer(4, 5121, 56, 12L);
        GL11.glTexCoordPointer(2, 5126, 56, 16L);
        OpenGlHelper.setClientActiveTexture(OpenGlHelper.lightmapTexUnit);
        GL11.glTexCoordPointer(2, 5122, 56, 24L);
        OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit);
        GL11.glNormalPointer(5120, 56, 28L);
        GL20.glVertexAttribPointer(Shaders.midTexCoordAttrib, 2, 5126, false, 56, 32L);
        GL20.glVertexAttribPointer(Shaders.tangentAttrib, 4, 5122, false, 56, 40L);
        GL20.glVertexAttribPointer(Shaders.entityAttrib, 3, 5122, false, 56, 48L);
    }
    
    public static void updateChunks(final RenderGlobal llIIIIlIIlIllll, final long llIIIIlIIlIllII) {
        llIIIIlIIlIllll.func_174967_a(llIIIIlIIlIllII);
    }
    
    public static void beaconBeamStartQuad1() {
    }
    
    public static void beaconBeamBegin() {
        Shaders.useProgram(14);
    }
    
    public static void beginTerrainCutout() {
        if (Shaders.isRenderingWorld) {
            Shaders.useProgram(7);
        }
    }
    
    public static void endBlockDamage() {
        if (Shaders.isRenderingWorld) {
            GlStateManager.depthMask(true);
            Shaders.useProgram(3);
        }
    }
    
    public static void preRenderChunkLayer() {
        if (OpenGlHelper.func_176075_f()) {
            GL11.glEnableClientState(32885);
            GL20.glEnableVertexAttribArray(Shaders.midTexCoordAttrib);
            GL20.glEnableVertexAttribArray(Shaders.tangentAttrib);
            GL20.glEnableVertexAttribArray(Shaders.entityAttrib);
        }
    }
    
    public static void endTranslucent() {
        if (Shaders.isRenderingWorld) {
            Shaders.useProgram(3);
        }
    }
    
    public static void setupTerrain(final RenderGlobal llIIIIlIIllIlll, final Entity llIIIIlIIllllII, final double llIIIIlIIlllIll, final ICamera llIIIIlIIllIlII, final int llIIIIlIIlllIIl, final boolean llIIIIlIIllIIlI) {
        llIIIIlIIllIlll.func_174970_a(llIIIIlIIllllII, llIIIIlIIlllIll, llIIIIlIIllIlII, llIIIIlIIlllIIl, llIIIIlIIllIIlI);
    }
    
    public static void endTerrain() {
        if (Shaders.isRenderingWorld) {
            Shaders.useProgram(3);
        }
    }
    
    public static void beginBlockDamage() {
        if (Shaders.isRenderingWorld) {
            Shaders.useProgram(11);
            if (Shaders.programsID[11] == Shaders.programsID[7]) {
                Shaders.setDrawBuffers(Shaders.drawBuffersColorAtt0);
                GlStateManager.depthMask(false);
            }
        }
    }
    
    public static void layerArmorBaseDrawEnchantedGlintBegin() {
        Shaders.useProgram(17);
    }
    
    public static void beaconBeamDraw1() {
    }
    
    public static void beginTerrainCutoutMipped() {
        if (Shaders.isRenderingWorld) {
            Shaders.useProgram(7);
        }
    }
    
    public static void renderFPOverlay(final EntityRenderer llIIIIlIIIIIlll, final float llIIIIlIIIIIllI, final int llIIIIlIIIIIlIl) {
        if (!Shaders.isShadowPass) {
            Shaders.beginFPOverlay();
            llIIIIlIIIIIlll.renderHand(llIIIIlIIIIIllI, llIIIIlIIIIIlIl);
            Shaders.endFPOverlay();
        }
    }
    
    public static void beginTerrainSolid() {
        if (Shaders.isRenderingWorld) {
            Shaders.fogEnabled = true;
            Shaders.useProgram(7);
        }
    }
    
    public static void renderHand0(final EntityRenderer llIIIIlIIlIIIIl, final float llIIIIlIIlIIIII, final int llIIIIlIIIlllll) {
        if (!Shaders.isShadowPass) {
            final Item llIIIIlIIlIIIll = (Shaders.itemToRender != null) ? Shaders.itemToRender.getItem() : null;
            final Block llIIIIlIIlIIIlI = (llIIIIlIIlIIIll instanceof ItemBlock) ? ((ItemBlock)llIIIIlIIlIIIll).getBlock() : null;
            if (!(llIIIIlIIlIIIll instanceof ItemBlock) || !(llIIIIlIIlIIIlI instanceof Block) || llIIIIlIIlIIIlI.getBlockLayer() == EnumWorldBlockLayer.SOLID) {
                Shaders.readCenterDepth();
                Shaders.beginHand();
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                llIIIIlIIlIIIIl.renderHand(llIIIIlIIlIIIII, llIIIIlIIIlllll);
                Shaders.endHand();
                Shaders.isHandRendered = true;
            }
        }
    }
    
    public static void renderShadowMap(final EntityRenderer llIIIIIlllllIII, final int llIIIIIllllIlll, final float llIIIIIllllIllI, final long llIIIIIllllIlIl) {
        if (Shaders.usedShadowDepthBuffers > 0 && --Shaders.shadowPassCounter <= 0) {
            final Minecraft llIIIIIllllIlII = Minecraft.getMinecraft();
            llIIIIIllllIlII.mcProfiler.endStartSection("shadow pass");
            final RenderGlobal llIIIIIllllIIll = llIIIIIllllIlII.renderGlobal;
            Shaders.isShadowPass = true;
            Shaders.shadowPassCounter = Shaders.shadowPassInterval;
            Shaders.preShadowPassThirdPersonView = llIIIIIllllIlII.gameSettings.thirdPersonView;
            llIIIIIllllIlII.gameSettings.thirdPersonView = 1;
            Shaders.checkGLError("pre shadow");
            GL11.glMatrixMode(5889);
            GL11.glPushMatrix();
            GL11.glMatrixMode(5888);
            GL11.glPushMatrix();
            llIIIIIllllIlII.mcProfiler.endStartSection("shadow clear");
            EXTFramebufferObject.glBindFramebufferEXT(36160, Shaders.sfb);
            Shaders.checkGLError("shadow bind sfb");
            Shaders.useProgram(30);
            llIIIIIllllIlII.mcProfiler.endStartSection("shadow camera");
            llIIIIIlllllIII.setupCameraTransform(llIIIIIllllIllI, 2);
            Shaders.setCameraShadow(llIIIIIllllIllI);
            ActiveRenderInfo.updateRenderInfo(llIIIIIllllIlII.thePlayer, llIIIIIllllIlII.gameSettings.thirdPersonView == 2);
            Shaders.checkGLError("shadow camera");
            GL20.glDrawBuffers(Shaders.sfbDrawBuffers);
            Shaders.checkGLError("shadow drawbuffers");
            GL11.glReadBuffer(0);
            Shaders.checkGLError("shadow readbuffer");
            EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36096, 3553, Shaders.sfbDepthTextures.get(0), 0);
            if (Shaders.usedShadowColorBuffers != 0) {
                EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36064, 3553, Shaders.sfbColorTextures.get(0), 0);
            }
            Shaders.checkFramebufferStatus("shadow fb");
            GL11.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glClear((Shaders.usedShadowColorBuffers != 0) ? 16640 : 256);
            Shaders.checkGLError("shadow clear");
            llIIIIIllllIlII.mcProfiler.endStartSection("shadow frustum");
            final ClippingHelper llIIIIIllllIIlI = ClippingHelperShadow.getInstance();
            llIIIIIllllIlII.mcProfiler.endStartSection("shadow culling");
            final Frustrum llIIIIIllllIIIl = new Frustrum(llIIIIIllllIIlI);
            final Entity llIIIIIllllIIII = llIIIIIllllIlII.func_175606_aa();
            final double llIIIIIlllIllll = llIIIIIllllIIII.lastTickPosX + (llIIIIIllllIIII.posX - llIIIIIllllIIII.lastTickPosX) * llIIIIIllllIllI;
            final double llIIIIIlllIlllI = llIIIIIllllIIII.lastTickPosY + (llIIIIIllllIIII.posY - llIIIIIllllIIII.lastTickPosY) * llIIIIIllllIllI;
            final double llIIIIIlllIllIl = llIIIIIllllIIII.lastTickPosZ + (llIIIIIllllIIII.posZ - llIIIIIllllIIII.lastTickPosZ) * llIIIIIllllIllI;
            llIIIIIllllIIIl.setPosition(llIIIIIlllIllll, llIIIIIlllIlllI, llIIIIIlllIllIl);
            GlStateManager.shadeModel(7425);
            GlStateManager.enableDepth();
            GlStateManager.depthFunc(515);
            GlStateManager.depthMask(true);
            GlStateManager.colorMask(true, true, true, true);
            GlStateManager.disableCull();
            llIIIIIllllIlII.mcProfiler.endStartSection("shadow prepareterrain");
            llIIIIIllllIlII.getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
            llIIIIIllllIlII.mcProfiler.endStartSection("shadow setupterrain");
            final boolean llIIIIIlllIllII = false;
            final int llIIIIIlllIlIll = llIIIIIlllllIII.field_175084_ae++;
            llIIIIIllllIIll.func_174970_a(llIIIIIllllIIII, llIIIIIllllIllI, llIIIIIllllIIIl, llIIIIIlllIlIll, llIIIIIllllIlII.thePlayer.func_175149_v());
            llIIIIIllllIlII.mcProfiler.endStartSection("shadow updatechunks");
            llIIIIIllllIlII.mcProfiler.endStartSection("shadow terrain");
            GlStateManager.matrixMode(5888);
            GlStateManager.pushMatrix();
            GlStateManager.disableAlpha();
            llIIIIIllllIIll.func_174977_a(EnumWorldBlockLayer.SOLID, llIIIIIllllIllI, 2, llIIIIIllllIIII);
            Shaders.checkGLError("shadow terrain solid");
            GlStateManager.enableAlpha();
            llIIIIIllllIIll.func_174977_a(EnumWorldBlockLayer.CUTOUT_MIPPED, llIIIIIllllIllI, 2, llIIIIIllllIIII);
            Shaders.checkGLError("shadow terrain cutoutmipped");
            llIIIIIllllIlII.getTextureManager().getTexture(TextureMap.locationBlocksTexture).func_174936_b(false, false);
            llIIIIIllllIIll.func_174977_a(EnumWorldBlockLayer.CUTOUT, llIIIIIllllIllI, 2, llIIIIIllllIIII);
            Shaders.checkGLError("shadow terrain cutout");
            llIIIIIllllIlII.getTextureManager().getTexture(TextureMap.locationBlocksTexture).func_174935_a();
            GlStateManager.shadeModel(7424);
            GlStateManager.alphaFunc(516, 0.1f);
            GlStateManager.matrixMode(5888);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            llIIIIIllllIlII.mcProfiler.endStartSection("shadow entities");
            if (Reflector.ForgeHooksClient_setRenderPass.exists()) {
                Reflector.callVoid(Reflector.ForgeHooksClient_setRenderPass, 0);
            }
            llIIIIIllllIIll.func_180446_a(llIIIIIllllIIII, llIIIIIllllIIIl, llIIIIIllllIllI);
            Shaders.checkGLError("shadow entities");
            GlStateManager.matrixMode(5888);
            GlStateManager.popMatrix();
            GlStateManager.depthMask(true);
            GlStateManager.disableBlend();
            GlStateManager.enableCull();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            GlStateManager.alphaFunc(516, 0.1f);
            if (Shaders.usedShadowDepthBuffers >= 2) {
                GlStateManager.setActiveTexture(33989);
                Shaders.checkGLError("pre copy shadow depth");
                GL11.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, Shaders.shadowMapWidth, Shaders.shadowMapHeight);
                Shaders.checkGLError("copy shadow depth");
                GlStateManager.setActiveTexture(33984);
            }
            GlStateManager.disableBlend();
            GlStateManager.depthMask(true);
            llIIIIIllllIlII.getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
            GlStateManager.shadeModel(7425);
            Shaders.checkGLError("shadow pre-translucent");
            GL20.glDrawBuffers(Shaders.sfbDrawBuffers);
            Shaders.checkGLError("shadow drawbuffers pre-translucent");
            Shaders.checkFramebufferStatus("shadow pre-translucent");
            llIIIIIllllIlII.mcProfiler.endStartSection("shadow translucent");
            llIIIIIllllIIll.func_174977_a(EnumWorldBlockLayer.TRANSLUCENT, llIIIIIllllIllI, 2, llIIIIIllllIIII);
            Shaders.checkGLError("shadow translucent");
            if (Reflector.ForgeHooksClient_setRenderPass.exists()) {
                RenderHelper.enableStandardItemLighting();
                Reflector.call(Reflector.ForgeHooksClient_setRenderPass, 1);
                llIIIIIllllIIll.func_180446_a(llIIIIIllllIIII, llIIIIIllllIIIl, llIIIIIllllIllI);
                Reflector.call(Reflector.ForgeHooksClient_setRenderPass, -1);
                RenderHelper.disableStandardItemLighting();
                Shaders.checkGLError("shadow entities 1");
            }
            GlStateManager.shadeModel(7424);
            GlStateManager.depthMask(true);
            GlStateManager.enableCull();
            GlStateManager.disableBlend();
            GL11.glFlush();
            Shaders.checkGLError("shadow flush");
            Shaders.isShadowPass = false;
            llIIIIIllllIlII.gameSettings.thirdPersonView = Shaders.preShadowPassThirdPersonView;
            llIIIIIllllIlII.mcProfiler.endStartSection("shadow postprocess");
            if (Shaders.hasGlGenMipmap) {
                if (Shaders.usedShadowDepthBuffers >= 1) {
                    if (Shaders.shadowMipmapEnabled[0]) {
                        GlStateManager.setActiveTexture(33988);
                        GlStateManager.func_179144_i(Shaders.sfbDepthTextures.get(0));
                        GL30.glGenerateMipmap(3553);
                        GL11.glTexParameteri(3553, 10241, Shaders.shadowFilterNearest[0] ? 9984 : 9987);
                    }
                    if (Shaders.usedShadowDepthBuffers >= 2 && Shaders.shadowMipmapEnabled[1]) {
                        GlStateManager.setActiveTexture(33989);
                        GlStateManager.func_179144_i(Shaders.sfbDepthTextures.get(1));
                        GL30.glGenerateMipmap(3553);
                        GL11.glTexParameteri(3553, 10241, Shaders.shadowFilterNearest[1] ? 9984 : 9987);
                    }
                    GlStateManager.setActiveTexture(33984);
                }
                if (Shaders.usedShadowColorBuffers >= 1) {
                    if (Shaders.shadowColorMipmapEnabled[0]) {
                        GlStateManager.setActiveTexture(33997);
                        GlStateManager.func_179144_i(Shaders.sfbColorTextures.get(0));
                        GL30.glGenerateMipmap(3553);
                        GL11.glTexParameteri(3553, 10241, Shaders.shadowColorFilterNearest[0] ? 9984 : 9987);
                    }
                    if (Shaders.usedShadowColorBuffers >= 2 && Shaders.shadowColorMipmapEnabled[1]) {
                        GlStateManager.setActiveTexture(33998);
                        GlStateManager.func_179144_i(Shaders.sfbColorTextures.get(1));
                        GL30.glGenerateMipmap(3553);
                        GL11.glTexParameteri(3553, 10241, Shaders.shadowColorFilterNearest[1] ? 9984 : 9987);
                    }
                    GlStateManager.setActiveTexture(33984);
                }
            }
            Shaders.checkGLError("shadow postprocess");
            EXTFramebufferObject.glBindFramebufferEXT(36160, Shaders.dfb);
            GL11.glViewport(0, 0, Shaders.renderWidth, Shaders.renderHeight);
            Shaders.activeDrawBuffers = null;
            llIIIIIllllIlII.getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
            Shaders.useProgram(7);
            GL11.glMatrixMode(5888);
            GL11.glPopMatrix();
            GL11.glMatrixMode(5889);
            GL11.glPopMatrix();
            GL11.glMatrixMode(5888);
            Shaders.checkGLError("shadow end");
        }
    }
    
    public static void postRenderChunkLayer() {
        if (OpenGlHelper.func_176075_f()) {
            GL11.glDisableClientState(32885);
            GL20.glDisableVertexAttribArray(Shaders.midTexCoordAttrib);
            GL20.glDisableVertexAttribArray(Shaders.tangentAttrib);
            GL20.glDisableVertexAttribArray(Shaders.entityAttrib);
        }
    }
    
    public static void beaconBeamDraw2() {
        GlStateManager.disableBlend();
    }
    
    public static void beaconBeamStartQuad2() {
    }
    
    public static void renderHand1(final EntityRenderer llIIIIlIIIlIllI, final float llIIIIlIIIllIII, final int llIIIIlIIIlIlll) {
        if (!Shaders.isShadowPass && !Shaders.isHandRendered) {
            Shaders.readCenterDepth();
            GlStateManager.enableBlend();
            Shaders.beginHand();
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            llIIIIlIIIlIllI.renderHand(llIIIIlIIIllIII, llIIIIlIIIlIlll);
            Shaders.endHand();
            Shaders.isHandRendered = true;
        }
    }
    
    public static void layerArmorBaseDrawEnchantedGlintEnd() {
        if (Shaders.isRenderingWorld) {
            Shaders.useProgram(16);
        }
        else {
            Shaders.useProgram(0);
        }
    }
    
    public static void setFrustrumPosition(final Frustrum llIIIIlIlIIIlll, final double llIIIIlIlIIlIlI, final double llIIIIlIlIIlIIl, final double llIIIIlIlIIIlII) {
        llIIIIlIlIIIlll.setPosition(llIIIIlIlIIlIlI, llIIIIlIlIIlIIl, llIIIIlIlIIIlII);
    }
    
    public static void renderItemFP(final ItemRenderer llIIIIlIIIIllll, final float llIIIIlIIIIlllI) {
        GlStateManager.depthMask(true);
        GlStateManager.depthFunc(515);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        llIIIIlIIIIllll.renderItemInFirstPerson(llIIIIlIIIIlllI);
    }
}
