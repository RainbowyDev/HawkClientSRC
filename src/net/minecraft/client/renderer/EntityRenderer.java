package net.minecraft.client.renderer;

import java.nio.*;
import net.minecraft.client.*;
import java.io.*;
import com.google.gson.*;
import net.minecraft.entity.*;
import net.minecraft.entity.item.*;
import org.lwjgl.input.*;
import java.util.concurrent.*;
import net.minecraft.crash.*;
import net.minecraft.client.entity.*;
import shadersmod.client.*;
import net.minecraft.block.material.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.world.biome.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.monster.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.shader.*;
import net.minecraft.entity.boss.*;
import org.apache.logging.log4j.*;
import org.lwjgl.util.glu.*;
import net.minecraft.potion.*;
import net.minecraft.client.gui.*;
import net.minecraft.server.integrated.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.entity.passive.*;
import org.lwjgl.opengl.*;
import net.minecraft.enchantment.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.renderer.culling.*;
import net.minecraft.util.*;
import hawk.events.listeners.*;
import hawk.*;
import hawk.events.*;
import net.minecraft.client.particle.*;
import net.minecraft.client.settings.*;
import optifine.*;
import java.util.*;
import java.lang.reflect.*;

public class EntityRenderer implements IResourceManagerReloadListener
{
    private /* synthetic */ float thirdPersonDistanceTemp;
    private /* synthetic */ Random random;
    private final /* synthetic */ MapItemRenderer theMapItemRenderer;
    private /* synthetic */ float thirdPersonDistance;
    private static final /* synthetic */ ResourceLocation[] shaderResourceLocations;
    private /* synthetic */ float avgServerTimeDiff;
    private /* synthetic */ double cameraZoom;
    private /* synthetic */ boolean field_175078_W;
    private /* synthetic */ float smoothCamFilterY;
    private /* synthetic */ MouseFilter mouseFilterYAxis;
    private /* synthetic */ float smoothCamFilterX;
    private /* synthetic */ FloatBuffer fogColorBuffer;
    private /* synthetic */ boolean field_175074_C;
    private /* synthetic */ boolean initialized;
    private static final /* synthetic */ ResourceLocation locationSnowPng;
    private /* synthetic */ boolean field_175083_ad;
    private /* synthetic */ int serverWaitTime;
    private /* synthetic */ float fovModifierHand;
    private /* synthetic */ float fogColor2;
    private final /* synthetic */ ResourceLocation locationLightMap;
    private final /* synthetic */ IResourceManager resourceManager;
    private /* synthetic */ float torchFlickerX;
    private static final /* synthetic */ ResourceLocation locationRainPng;
    private /* synthetic */ double cameraPitch;
    private /* synthetic */ float fogColor1;
    private /* synthetic */ float field_175075_L;
    private /* synthetic */ boolean cloudFog;
    private /* synthetic */ long renderEndNanoTime;
    private /* synthetic */ MouseFilter mouseFilterXAxis;
    private /* synthetic */ float clipDistance;
    private /* synthetic */ long prevFrameTime;
    public /* synthetic */ float field_175080_Q;
    public static /* synthetic */ boolean anaglyphEnable;
    private /* synthetic */ boolean field_175073_D;
    private /* synthetic */ float[] field_175076_N;
    public /* synthetic */ float field_175082_R;
    private /* synthetic */ float avgServerTickDiff;
    private /* synthetic */ float smoothCamYaw;
    public /* synthetic */ float field_175081_S;
    private /* synthetic */ float fovModifierHandPrev;
    private /* synthetic */ float[] field_175077_O;
    private static final /* synthetic */ Logger logger;
    private /* synthetic */ float bossColorModifier;
    private /* synthetic */ float smoothCamPartialTicks;
    public /* synthetic */ ItemRenderer itemRenderer;
    private /* synthetic */ float bossColorModifierPrev;
    public static final /* synthetic */ int shaderCount;
    private final /* synthetic */ DynamicTexture lightmapTexture;
    private /* synthetic */ int rendererUpdateCount;
    private /* synthetic */ float smoothCamPitch;
    private /* synthetic */ double cameraYaw;
    private /* synthetic */ World updatedWorld;
    private /* synthetic */ boolean lightmapUpdateNeeded;
    public /* synthetic */ int field_175084_ae;
    private /* synthetic */ long lastServerTime;
    private final /* synthetic */ int[] lightmapColors;
    private /* synthetic */ Entity pointedEntity;
    private /* synthetic */ int field_175079_V;
    public /* synthetic */ boolean fogStandard;
    private /* synthetic */ int lastServerTicks;
    public static /* synthetic */ int anaglyphField;
    private /* synthetic */ ShaderGroup[] fxaaShaders;
    private /* synthetic */ int rainSoundCounter;
    private /* synthetic */ int shaderIndex;
    private /* synthetic */ int serverWaitTimeCurrent;
    private /* synthetic */ boolean showDebugInfo;
    private /* synthetic */ Minecraft mc;
    private /* synthetic */ float farPlaneDistance;
    private /* synthetic */ ShaderGroup theShaderGroup;
    private /* synthetic */ long lastErrorCheckTimeMs;
    
    private void func_175069_a(final ResourceLocation llllllllllllllIIIIlIlIIlllIlIlIl) {
        if (OpenGlHelper.isFramebufferEnabled()) {
            try {
                this.theShaderGroup = new ShaderGroup(this.mc.getTextureManager(), this.resourceManager, this.mc.getFramebuffer(), llllllllllllllIIIIlIlIIlllIlIlIl);
                this.theShaderGroup.createBindFramebuffers(this.mc.displayWidth, this.mc.displayHeight);
                this.field_175083_ad = true;
            }
            catch (IOException llllllllllllllIIIIlIlIIlllIllIII) {
                EntityRenderer.logger.warn(String.valueOf(new StringBuilder("Failed to load shader: ").append(llllllllllllllIIIIlIlIIlllIlIlIl)), (Throwable)llllllllllllllIIIIlIlIIlllIllIII);
                this.shaderIndex = EntityRenderer.shaderCount;
                this.field_175083_ad = false;
            }
            catch (JsonSyntaxException llllllllllllllIIIIlIlIIlllIlIlll) {
                EntityRenderer.logger.warn(String.valueOf(new StringBuilder("Failed to load shader: ").append(llllllllllllllIIIIlIlIIlllIlIlIl)), (Throwable)llllllllllllllIIIIlIlIIlllIlIlll);
                this.shaderIndex = EntityRenderer.shaderCount;
                this.field_175083_ad = false;
            }
        }
    }
    
    public void getMouseOver(final float llllllllllllllIIIIlIlIIllIIIIIlI) {
        final Entity llllllllllllllIIIIlIlIIllIIlIlII = this.mc.func_175606_aa();
        if (llllllllllllllIIIIlIlIIllIIlIlII != null && this.mc.theWorld != null) {
            this.mc.mcProfiler.startSection("pick");
            this.mc.pointedEntity = null;
            double llllllllllllllIIIIlIlIIllIIlIIll = this.mc.playerController.getBlockReachDistance();
            this.mc.objectMouseOver = llllllllllllllIIIIlIlIIllIIlIlII.func_174822_a(llllllllllllllIIIIlIlIIllIIlIIll, llllllllllllllIIIIlIlIIllIIIIIlI);
            double llllllllllllllIIIIlIlIIllIIlIIlI = llllllllllllllIIIIlIlIIllIIlIIll;
            final Vec3 llllllllllllllIIIIlIlIIllIIlIIIl = llllllllllllllIIIIlIlIIllIIlIlII.func_174824_e(llllllllllllllIIIIlIlIIllIIIIIlI);
            if (this.mc.playerController.extendedReach()) {
                llllllllllllllIIIIlIlIIllIIlIIll = 6.0;
                llllllllllllllIIIIlIlIIllIIlIIlI = 6.0;
            }
            else {
                if (llllllllllllllIIIIlIlIIllIIlIIll > 3.0) {
                    llllllllllllllIIIIlIlIIllIIlIIlI = 3.0;
                }
                llllllllllllllIIIIlIlIIllIIlIIll = llllllllllllllIIIIlIlIIllIIlIIlI;
            }
            if (this.mc.objectMouseOver != null) {
                llllllllllllllIIIIlIlIIllIIlIIlI = this.mc.objectMouseOver.hitVec.distanceTo(llllllllllllllIIIIlIlIIllIIlIIIl);
            }
            final Vec3 llllllllllllllIIIIlIlIIllIIlIIII = llllllllllllllIIIIlIlIIllIIlIlII.getLook(llllllllllllllIIIIlIlIIllIIIIIlI);
            final Vec3 llllllllllllllIIIIlIlIIllIIIllll = llllllllllllllIIIIlIlIIllIIlIIIl.addVector(llllllllllllllIIIIlIlIIllIIlIIII.xCoord * llllllllllllllIIIIlIlIIllIIlIIll, llllllllllllllIIIIlIlIIllIIlIIII.yCoord * llllllllllllllIIIIlIlIIllIIlIIll, llllllllllllllIIIIlIlIIllIIlIIII.zCoord * llllllllllllllIIIIlIlIIllIIlIIll);
            this.pointedEntity = null;
            Vec3 llllllllllllllIIIIlIlIIllIIIlllI = null;
            final float llllllllllllllIIIIlIlIIllIIIllIl = 1.0f;
            final List llllllllllllllIIIIlIlIIllIIIllII = this.mc.theWorld.getEntitiesWithinAABBExcludingEntity(llllllllllllllIIIIlIlIIllIIlIlII, llllllllllllllIIIIlIlIIllIIlIlII.getEntityBoundingBox().addCoord(llllllllllllllIIIIlIlIIllIIlIIII.xCoord * llllllllllllllIIIIlIlIIllIIlIIll, llllllllllllllIIIIlIlIIllIIlIIII.yCoord * llllllllllllllIIIIlIlIIllIIlIIll, llllllllllllllIIIIlIlIIllIIlIIII.zCoord * llllllllllllllIIIIlIlIIllIIlIIll).expand(llllllllllllllIIIIlIlIIllIIIllIl, llllllllllllllIIIIlIlIIllIIIllIl, llllllllllllllIIIIlIlIIllIIIllIl));
            double llllllllllllllIIIIlIlIIllIIIlIll = llllllllllllllIIIIlIlIIllIIlIIlI;
            for (int llllllllllllllIIIIlIlIIllIIIlIlI = 0; llllllllllllllIIIIlIlIIllIIIlIlI < llllllllllllllIIIIlIlIIllIIIllII.size(); ++llllllllllllllIIIIlIlIIllIIIlIlI) {
                final Entity llllllllllllllIIIIlIlIIllIIIlIIl = llllllllllllllIIIIlIlIIllIIIllII.get(llllllllllllllIIIIlIlIIllIIIlIlI);
                if (llllllllllllllIIIIlIlIIllIIIlIIl.canBeCollidedWith()) {
                    final float llllllllllllllIIIIlIlIIllIIIlIII = llllllllllllllIIIIlIlIIllIIIlIIl.getCollisionBorderSize();
                    final AxisAlignedBB llllllllllllllIIIIlIlIIllIIIIlll = llllllllllllllIIIIlIlIIllIIIlIIl.getEntityBoundingBox().expand(llllllllllllllIIIIlIlIIllIIIlIII, llllllllllllllIIIIlIlIIllIIIlIII, llllllllllllllIIIIlIlIIllIIIlIII);
                    final MovingObjectPosition llllllllllllllIIIIlIlIIllIIIIllI = llllllllllllllIIIIlIlIIllIIIIlll.calculateIntercept(llllllllllllllIIIIlIlIIllIIlIIIl, llllllllllllllIIIIlIlIIllIIIllll);
                    if (llllllllllllllIIIIlIlIIllIIIIlll.isVecInside(llllllllllllllIIIIlIlIIllIIlIIIl)) {
                        if (0.0 < llllllllllllllIIIIlIlIIllIIIlIll || llllllllllllllIIIIlIlIIllIIIlIll == 0.0) {
                            this.pointedEntity = llllllllllllllIIIIlIlIIllIIIlIIl;
                            llllllllllllllIIIIlIlIIllIIIlllI = ((llllllllllllllIIIIlIlIIllIIIIllI == null) ? llllllllllllllIIIIlIlIIllIIlIIIl : llllllllllllllIIIIlIlIIllIIIIllI.hitVec);
                            llllllllllllllIIIIlIlIIllIIIlIll = 0.0;
                        }
                    }
                    else if (llllllllllllllIIIIlIlIIllIIIIllI != null) {
                        final double llllllllllllllIIIIlIlIIllIIIIlIl = llllllllllllllIIIIlIlIIllIIlIIIl.distanceTo(llllllllllllllIIIIlIlIIllIIIIllI.hitVec);
                        if (llllllllllllllIIIIlIlIIllIIIIlIl < llllllllllllllIIIIlIlIIllIIIlIll || llllllllllllllIIIIlIlIIllIIIlIll == 0.0) {
                            boolean llllllllllllllIIIIlIlIIllIIIIlII = false;
                            if (Reflector.ForgeEntity_canRiderInteract.exists()) {
                                llllllllllllllIIIIlIlIIllIIIIlII = Reflector.callBoolean(llllllllllllllIIIIlIlIIllIIIlIIl, Reflector.ForgeEntity_canRiderInteract, new Object[0]);
                            }
                            if (llllllllllllllIIIIlIlIIllIIIlIIl == llllllllllllllIIIIlIlIIllIIlIlII.ridingEntity && !llllllllllllllIIIIlIlIIllIIIIlII) {
                                if (llllllllllllllIIIIlIlIIllIIIlIll == 0.0) {
                                    this.pointedEntity = llllllllllllllIIIIlIlIIllIIIlIIl;
                                    llllllllllllllIIIIlIlIIllIIIlllI = llllllllllllllIIIIlIlIIllIIIIllI.hitVec;
                                }
                            }
                            else {
                                this.pointedEntity = llllllllllllllIIIIlIlIIllIIIlIIl;
                                llllllllllllllIIIIlIlIIllIIIlllI = llllllllllllllIIIIlIlIIllIIIIllI.hitVec;
                                llllllllllllllIIIIlIlIIllIIIlIll = llllllllllllllIIIIlIlIIllIIIIlIl;
                            }
                        }
                    }
                }
            }
            if (this.pointedEntity != null && (llllllllllllllIIIIlIlIIllIIIlIll < llllllllllllllIIIIlIlIIllIIlIIlI || this.mc.objectMouseOver == null)) {
                this.mc.objectMouseOver = new MovingObjectPosition(this.pointedEntity, llllllllllllllIIIIlIlIIllIIIlllI);
                if (this.pointedEntity instanceof EntityLivingBase || this.pointedEntity instanceof EntityItemFrame) {
                    this.mc.pointedEntity = this.pointedEntity;
                }
            }
            this.mc.mcProfiler.endSection();
        }
    }
    
    public void updateCameraAndRender(final float llllllllllllllIIIIlIlIIIIlIllIIl) {
        this.frameInit();
        final boolean llllllllllllllIIIIlIlIIIIlIllIII = Display.isActive();
        if (!llllllllllllllIIIIlIlIIIIlIllIII && this.mc.gameSettings.pauseOnLostFocus && (!this.mc.gameSettings.touchscreen || !Mouse.isButtonDown(1))) {
            if (Minecraft.getSystemTime() - this.prevFrameTime > 500L) {
                this.mc.displayInGameMenu();
            }
        }
        else {
            this.prevFrameTime = Minecraft.getSystemTime();
        }
        this.mc.mcProfiler.startSection("mouse");
        if (llllllllllllllIIIIlIlIIIIlIllIII && Minecraft.isRunningOnMac && this.mc.inGameHasFocus && !Mouse.isInsideWindow()) {
            Mouse.setGrabbed(false);
            Mouse.setCursorPosition(Display.getWidth() / 2, Display.getHeight() / 2);
            Mouse.setGrabbed(true);
        }
        if (this.mc.inGameHasFocus && llllllllllllllIIIIlIlIIIIlIllIII) {
            this.mc.mouseHelper.mouseXYChange();
            final float llllllllllllllIIIIlIlIIIIlIlIlll = this.mc.gameSettings.mouseSensitivity * 0.6f + 0.2f;
            final float llllllllllllllIIIIlIlIIIIlIlIllI = llllllllllllllIIIIlIlIIIIlIlIlll * llllllllllllllIIIIlIlIIIIlIlIlll * llllllllllllllIIIIlIlIIIIlIlIlll * 8.0f;
            float llllllllllllllIIIIlIlIIIIlIlIlIl = this.mc.mouseHelper.deltaX * llllllllllllllIIIIlIlIIIIlIlIllI;
            float llllllllllllllIIIIlIlIIIIlIlIlII = this.mc.mouseHelper.deltaY * llllllllllllllIIIIlIlIIIIlIlIllI;
            byte llllllllllllllIIIIlIlIIIIlIlIIll = 1;
            if (this.mc.gameSettings.invertMouse) {
                llllllllllllllIIIIlIlIIIIlIlIIll = -1;
            }
            if (this.mc.gameSettings.smoothCamera) {
                this.smoothCamYaw += llllllllllllllIIIIlIlIIIIlIlIlIl;
                this.smoothCamPitch += llllllllllllllIIIIlIlIIIIlIlIlII;
                final float llllllllllllllIIIIlIlIIIIlIlIIlI = llllllllllllllIIIIlIlIIIIlIllIIl - this.smoothCamPartialTicks;
                this.smoothCamPartialTicks = llllllllllllllIIIIlIlIIIIlIllIIl;
                llllllllllllllIIIIlIlIIIIlIlIlIl = this.smoothCamFilterX * llllllllllllllIIIIlIlIIIIlIlIIlI;
                llllllllllllllIIIIlIlIIIIlIlIlII = this.smoothCamFilterY * llllllllllllllIIIIlIlIIIIlIlIIlI;
                this.mc.thePlayer.setAngles(llllllllllllllIIIIlIlIIIIlIlIlIl, llllllllllllllIIIIlIlIIIIlIlIlII * llllllllllllllIIIIlIlIIIIlIlIIll);
            }
            else {
                this.smoothCamYaw = 0.0f;
                this.smoothCamPitch = 0.0f;
                this.mc.thePlayer.setAngles(llllllllllllllIIIIlIlIIIIlIlIlIl, llllllllllllllIIIIlIlIIIIlIlIlII * llllllllllllllIIIIlIlIIIIlIlIIll);
            }
        }
        this.mc.mcProfiler.endSection();
        if (!this.mc.skipRenderWorld) {
            EntityRenderer.anaglyphEnable = this.mc.gameSettings.anaglyph;
            final ScaledResolution llllllllllllllIIIIlIlIIIIlIlIIIl = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
            final int llllllllllllllIIIIlIlIIIIlIlIIII = llllllllllllllIIIIlIlIIIIlIlIIIl.getScaledWidth();
            final int llllllllllllllIIIIlIlIIIIlIIllll = llllllllllllllIIIIlIlIIIIlIlIIIl.getScaledHeight();
            final int llllllllllllllIIIIlIlIIIIlIIlllI = Mouse.getX() * llllllllllllllIIIIlIlIIIIlIlIIII / this.mc.displayWidth;
            final int llllllllllllllIIIIlIlIIIIlIIllIl = llllllllllllllIIIIlIlIIIIlIIllll - Mouse.getY() * llllllllllllllIIIIlIlIIIIlIIllll / this.mc.displayHeight - 1;
            final int llllllllllllllIIIIlIlIIIIlIIllII = this.mc.gameSettings.limitFramerate;
            if (this.mc.theWorld != null) {
                this.mc.mcProfiler.startSection("level");
                final int llllllllllllllIIIIlIlIIIIlIIlIll = Math.max(Minecraft.func_175610_ah(), 30);
                this.renderWorld(llllllllllllllIIIIlIlIIIIlIllIIl, this.renderEndNanoTime + 1000000000 / llllllllllllllIIIIlIlIIIIlIIlIll);
                if (OpenGlHelper.shadersSupported) {
                    this.mc.renderGlobal.func_174975_c();
                    if (this.theShaderGroup != null && this.field_175083_ad) {
                        GlStateManager.matrixMode(5890);
                        GlStateManager.pushMatrix();
                        GlStateManager.loadIdentity();
                        this.theShaderGroup.loadShaderGroup(llllllllllllllIIIIlIlIIIIlIllIIl);
                        GlStateManager.popMatrix();
                    }
                    this.mc.getFramebuffer().bindFramebuffer(true);
                }
                this.renderEndNanoTime = System.nanoTime();
                this.mc.mcProfiler.endStartSection("gui");
                if (!this.mc.gameSettings.hideGUI || this.mc.currentScreen != null) {
                    GlStateManager.alphaFunc(516, 0.1f);
                    this.mc.ingameGUI.func_175180_a(llllllllllllllIIIIlIlIIIIlIllIIl);
                    if (this.mc.gameSettings.ofShowFps && !this.mc.gameSettings.showDebugInfo) {
                        Config.drawFps();
                    }
                    if (this.mc.gameSettings.showDebugInfo) {
                        Lagometer.showLagometer(llllllllllllllIIIIlIlIIIIlIlIIIl);
                    }
                }
                this.mc.mcProfiler.endSection();
            }
            else {
                GlStateManager.viewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
                GlStateManager.matrixMode(5889);
                GlStateManager.loadIdentity();
                GlStateManager.matrixMode(5888);
                GlStateManager.loadIdentity();
                this.setupOverlayRendering();
                this.renderEndNanoTime = System.nanoTime();
            }
            if (this.mc.currentScreen != null) {
                GlStateManager.clear(256);
                try {
                    if (Reflector.ForgeHooksClient_drawScreen.exists()) {
                        Reflector.callVoid(Reflector.ForgeHooksClient_drawScreen, this.mc.currentScreen, llllllllllllllIIIIlIlIIIIlIIlllI, llllllllllllllIIIIlIlIIIIlIIllIl, llllllllllllllIIIIlIlIIIIlIllIIl);
                    }
                    else {
                        this.mc.currentScreen.drawScreen(llllllllllllllIIIIlIlIIIIlIIlllI, llllllllllllllIIIIlIlIIIIlIIllIl, llllllllllllllIIIIlIlIIIIlIllIIl);
                    }
                }
                catch (Throwable llllllllllllllIIIIlIlIIIIlIIlIlI) {
                    final CrashReport llllllllllllllIIIIlIlIIIIlIIlIIl = CrashReport.makeCrashReport(llllllllllllllIIIIlIlIIIIlIIlIlI, "Rendering screen");
                    final CrashReportCategory llllllllllllllIIIIlIlIIIIlIIlIII = llllllllllllllIIIIlIlIIIIlIIlIIl.makeCategory("Screen render details");
                    llllllllllllllIIIIlIlIIIIlIIlIII.addCrashSectionCallable("Screen name", new Callable() {
                        static {
                            __OBFID = "CL_00000948";
                        }
                        
                        @Override
                        public String call() {
                            return EntityRenderer.this.mc.currentScreen.getClass().getCanonicalName();
                        }
                    });
                    llllllllllllllIIIIlIlIIIIlIIlIII.addCrashSectionCallable("Mouse location", new Callable() {
                        @Override
                        public String call() {
                            return String.format("Scaled: (%d, %d). Absolute: (%d, %d)", llllllllllllllIIIIlIlIIIIlIIlllI, llllllllllllllIIIIlIlIIIIlIIllIl, Mouse.getX(), Mouse.getY());
                        }
                        
                        static {
                            __OBFID = "CL_00000950";
                        }
                    });
                    llllllllllllllIIIIlIlIIIIlIIlIII.addCrashSectionCallable("Screen size", new Callable() {
                        static {
                            __OBFID = "CL_00000951";
                        }
                        
                        @Override
                        public String call() {
                            return String.format("Scaled: (%d, %d). Absolute: (%d, %d). Scale factor of %d", llllllllllllllIIIIlIlIIIIlIlIIIl.getScaledWidth(), llllllllllllllIIIIlIlIIIIlIlIIIl.getScaledHeight(), EntityRenderer.this.mc.displayWidth, EntityRenderer.this.mc.displayHeight, llllllllllllllIIIIlIlIIIIlIlIIIl.getScaleFactor());
                        }
                    });
                    throw new ReportedException(llllllllllllllIIIIlIlIIIIlIIlIIl);
                }
            }
        }
        this.frameFinish();
        this.waitForServerThread();
        Lagometer.updateLagometer();
        if (this.mc.gameSettings.ofProfiler) {
            this.mc.gameSettings.showDebugProfilerChart = true;
        }
    }
    
    private void hurtCameraEffect(final float llllllllllllllIIIIlIlIIlIlIIIlII) {
        if (this.mc.func_175606_aa() instanceof EntityLivingBase) {
            final EntityLivingBase llllllllllllllIIIIlIlIIlIlIIlIIl = (EntityLivingBase)this.mc.func_175606_aa();
            float llllllllllllllIIIIlIlIIlIlIIlIII = llllllllllllllIIIIlIlIIlIlIIlIIl.hurtTime - llllllllllllllIIIIlIlIIlIlIIIlII;
            if (llllllllllllllIIIIlIlIIlIlIIlIIl.getHealth() <= 0.0f) {
                final float llllllllllllllIIIIlIlIIlIlIIIlll = llllllllllllllIIIIlIlIIlIlIIlIIl.deathTime + llllllllllllllIIIIlIlIIlIlIIIlII;
                GlStateManager.rotate(40.0f - 8000.0f / (llllllllllllllIIIIlIlIIlIlIIIlll + 200.0f), 0.0f, 0.0f, 1.0f);
            }
            if (llllllllllllllIIIIlIlIIlIlIIlIII < 0.0f) {
                return;
            }
            llllllllllllllIIIIlIlIIlIlIIlIII /= llllllllllllllIIIIlIlIIlIlIIlIIl.maxHurtTime;
            llllllllllllllIIIIlIlIIlIlIIlIII = MathHelper.sin(llllllllllllllIIIIlIlIIlIlIIlIII * llllllllllllllIIIIlIlIIlIlIIlIII * llllllllllllllIIIIlIlIIlIlIIlIII * llllllllllllllIIIIlIlIIlIlIIlIII * 3.1415927f);
            final float llllllllllllllIIIIlIlIIlIlIIIllI = llllllllllllllIIIIlIlIIlIlIIlIIl.attackedAtYaw;
            GlStateManager.rotate(-llllllllllllllIIIIlIlIIlIlIIIllI, 0.0f, 1.0f, 0.0f);
            GlStateManager.rotate(-llllllllllllllIIIIlIlIIlIlIIlIII * 14.0f, 0.0f, 0.0f, 1.0f);
            GlStateManager.rotate(llllllllllllllIIIIlIlIIlIlIIIllI, 0.0f, 1.0f, 0.0f);
        }
    }
    
    private void updateFovModifierHand() {
        float llllllllllllllIIIIlIlIIlIllIllII = 1.0f;
        if (this.mc.func_175606_aa() instanceof AbstractClientPlayer) {
            final AbstractClientPlayer llllllllllllllIIIIlIlIIlIllIlIll = (AbstractClientPlayer)this.mc.func_175606_aa();
            llllllllllllllIIIIlIlIIlIllIllII = llllllllllllllIIIIlIlIIlIllIlIll.func_175156_o();
        }
        this.fovModifierHandPrev = this.fovModifierHand;
        this.fovModifierHand += (llllllllllllllIIIIlIlIIlIllIllII - this.fovModifierHand) * 0.5f;
        if (this.fovModifierHand > 1.5f) {
            this.fovModifierHand = 1.5f;
        }
        if (this.fovModifierHand < 0.1f) {
            this.fovModifierHand = 0.1f;
        }
    }
    
    public void renderHand(final float llllllllllllllIIIIlIlIIIllIIIIll, final int llllllllllllllIIIIlIlIIIllIIIlll) {
        if (!this.field_175078_W) {
            GlStateManager.matrixMode(5889);
            GlStateManager.loadIdentity();
            final float llllllllllllllIIIIlIlIIIllIIIllI = 0.07f;
            if (this.mc.gameSettings.anaglyph) {
                GlStateManager.translate(-(llllllllllllllIIIIlIlIIIllIIIlll * 2 - 1) * llllllllllllllIIIIlIlIIIllIIIllI, 0.0f, 0.0f);
            }
            if (Config.isShaders()) {
                Shaders.applyHandDepth();
            }
            Project.gluPerspective(this.getFOVModifier(llllllllllllllIIIIlIlIIIllIIIIll, false), this.mc.displayWidth / (float)this.mc.displayHeight, 0.05f, this.farPlaneDistance * 2.0f);
            GlStateManager.matrixMode(5888);
            GlStateManager.loadIdentity();
            if (this.mc.gameSettings.anaglyph) {
                GlStateManager.translate((llllllllllllllIIIIlIlIIIllIIIlll * 2 - 1) * 0.1f, 0.0f, 0.0f);
            }
            boolean llllllllllllllIIIIlIlIIIllIIIlIl = false;
            if (!Config.isShaders() || !Shaders.isHandRendered) {
                GlStateManager.pushMatrix();
                this.hurtCameraEffect(llllllllllllllIIIIlIlIIIllIIIIll);
                if (this.mc.gameSettings.viewBobbing) {
                    this.setupViewBobbing(llllllllllllllIIIIlIlIIIllIIIIll);
                }
                llllllllllllllIIIIlIlIIIllIIIlIl = (this.mc.func_175606_aa() instanceof EntityLivingBase && ((EntityLivingBase)this.mc.func_175606_aa()).isPlayerSleeping());
                if (this.mc.gameSettings.thirdPersonView == 0 && !llllllllllllllIIIIlIlIIIllIIIlIl && !this.mc.gameSettings.hideGUI && !this.mc.playerController.enableEverythingIsScrewedUpMode()) {
                    this.func_180436_i();
                    if (Config.isShaders()) {
                        ShadersRender.renderItemFP(this.itemRenderer, llllllllllllllIIIIlIlIIIllIIIIll);
                    }
                    else {
                        this.itemRenderer.renderItemInFirstPerson(llllllllllllllIIIIlIlIIIllIIIIll);
                    }
                    this.func_175072_h();
                }
                GlStateManager.popMatrix();
            }
            if (Config.isShaders() && !Shaders.isCompositeRendered) {
                return;
            }
            this.func_175072_h();
            if (this.mc.gameSettings.thirdPersonView == 0 && !llllllllllllllIIIIlIlIIIllIIIlIl) {
                this.itemRenderer.renderOverlays(llllllllllllllIIIIlIlIIIllIIIIll);
                this.hurtCameraEffect(llllllllllllllIIIIlIlIIIllIIIIll);
            }
            if (this.mc.gameSettings.viewBobbing) {
                this.setupViewBobbing(llllllllllllllIIIIlIlIIIllIIIIll);
            }
        }
    }
    
    public void stopUseShader() {
        if (this.theShaderGroup != null) {
            this.theShaderGroup.deleteShaderGroup();
        }
        this.theShaderGroup = null;
        this.shaderIndex = EntityRenderer.shaderCount;
    }
    
    private void func_175067_i(final float llllllllllllllIIIIlIlIIIIIIllIll) {
        if (this.mc.gameSettings.showDebugInfo && !this.mc.gameSettings.hideGUI && !this.mc.thePlayer.func_175140_cp() && !this.mc.gameSettings.field_178879_v) {
            final Entity llllllllllllllIIIIlIlIIIIIIlllIl = this.mc.func_175606_aa();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            GL11.glLineWidth(1.0f);
            GlStateManager.func_179090_x();
            GlStateManager.depthMask(false);
            GlStateManager.pushMatrix();
            GlStateManager.matrixMode(5888);
            GlStateManager.loadIdentity();
            this.orientCamera(llllllllllllllIIIIlIlIIIIIIllIll);
            GlStateManager.translate(0.0f, llllllllllllllIIIIlIlIIIIIIlllIl.getEyeHeight(), 0.0f);
            RenderGlobal.drawOutlinedBoundingBox(new AxisAlignedBB(0.0, 0.0, 0.0, 0.005, 1.0E-4, 1.0E-4), -65536);
            RenderGlobal.drawOutlinedBoundingBox(new AxisAlignedBB(0.0, 0.0, 0.0, 1.0E-4, 1.0E-4, 0.005), -16776961);
            RenderGlobal.drawOutlinedBoundingBox(new AxisAlignedBB(0.0, 0.0, 0.0, 1.0E-4, 0.0033, 1.0E-4), -16711936);
            GlStateManager.popMatrix();
            GlStateManager.depthMask(true);
            GlStateManager.func_179098_w();
            GlStateManager.disableBlend();
        }
    }
    
    public void renderWorld(final float llllllllllllllIIIIlIlIIIIIIlIlIl, final long llllllllllllllIIIIlIlIIIIIIlIlII) {
        this.updateLightmap(llllllllllllllIIIIlIlIIIIIIlIlIl);
        if (this.mc.func_175606_aa() == null) {
            this.mc.func_175607_a(this.mc.thePlayer);
        }
        this.getMouseOver(llllllllllllllIIIIlIlIIIIIIlIlIl);
        if (Config.isShaders()) {
            Shaders.beginRender(this.mc, llllllllllllllIIIIlIlIIIIIIlIlIl, llllllllllllllIIIIlIlIIIIIIlIlII);
        }
        GlStateManager.enableDepth();
        GlStateManager.enableAlpha();
        GlStateManager.alphaFunc(516, 0.1f);
        this.mc.mcProfiler.startSection("center");
        if (this.mc.gameSettings.anaglyph) {
            EntityRenderer.anaglyphField = 0;
            GlStateManager.colorMask(false, true, true, false);
            this.func_175068_a(0, llllllllllllllIIIIlIlIIIIIIlIlIl, llllllllllllllIIIIlIlIIIIIIlIlII);
            EntityRenderer.anaglyphField = 1;
            GlStateManager.colorMask(true, false, false, false);
            this.func_175068_a(1, llllllllllllllIIIIlIlIIIIIIlIlIl, llllllllllllllIIIIlIlIIIIIIlIlII);
            GlStateManager.colorMask(true, true, true, false);
        }
        else {
            this.func_175068_a(2, llllllllllllllIIIIlIlIIIIIIlIlIl, llllllllllllllIIIIlIlIIIIIIlIlII);
        }
        this.mc.mcProfiler.endSection();
    }
    
    public void func_180436_i() {
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.matrixMode(5890);
        GlStateManager.loadIdentity();
        final float llllllllllllllIIIIlIlIIIlIlllIll = 0.00390625f;
        GlStateManager.scale(llllllllllllllIIIIlIlIIIlIlllIll, llllllllllllllIIIIlIlIIIlIlllIll, llllllllllllllIIIIlIlIIIlIlllIll);
        GlStateManager.translate(8.0f, 8.0f, 8.0f);
        GlStateManager.matrixMode(5888);
        this.mc.getTextureManager().bindTexture(this.locationLightMap);
        GL11.glTexParameteri(3553, 10241, 9729);
        GL11.glTexParameteri(3553, 10240, 9729);
        GL11.glTexParameteri(3553, 10242, 10496);
        GL11.glTexParameteri(3553, 10243, 10496);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.func_179098_w();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        if (Config.isShaders()) {
            Shaders.enableLightmap();
        }
    }
    
    public void setupOverlayRendering() {
        final ScaledResolution llllllllllllllIIIIlIIlllIIlIIIlI = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
        GlStateManager.clear(256);
        GlStateManager.matrixMode(5889);
        GlStateManager.loadIdentity();
        GlStateManager.ortho(0.0, llllllllllllllIIIIlIIlllIIlIIIlI.getScaledWidth_double(), llllllllllllllIIIIlIIlllIIlIIIlI.getScaledHeight_double(), 0.0, 1000.0, 3000.0);
        GlStateManager.matrixMode(5888);
        GlStateManager.loadIdentity();
        GlStateManager.translate(0.0f, 0.0f, -2000.0f);
    }
    
    private void addRainParticles() {
        float llllllllllllllIIIIlIIlllllIIIIII = this.mc.theWorld.getRainStrength(1.0f);
        if (!Config.isRainFancy()) {
            llllllllllllllIIIIlIIlllllIIIIII /= 2.0f;
        }
        if (llllllllllllllIIIIlIIlllllIIIIII != 0.0f && Config.isRainSplash()) {
            this.random.setSeed(this.rendererUpdateCount * 312987231L);
            final Entity llllllllllllllIIIIlIIllllIllllll = this.mc.func_175606_aa();
            final WorldClient llllllllllllllIIIIlIIllllIlllllI = this.mc.theWorld;
            final BlockPos llllllllllllllIIIIlIIllllIllllIl = new BlockPos(llllllllllllllIIIIlIIllllIllllll);
            final byte llllllllllllllIIIIlIIllllIllllII = 10;
            double llllllllllllllIIIIlIIllllIlllIll = 0.0;
            double llllllllllllllIIIIlIIllllIlllIlI = 0.0;
            double llllllllllllllIIIIlIIllllIlllIIl = 0.0;
            int llllllllllllllIIIIlIIllllIlllIII = 0;
            int llllllllllllllIIIIlIIllllIllIlll = (int)(100.0f * llllllllllllllIIIIlIIlllllIIIIII * llllllllllllllIIIIlIIlllllIIIIII);
            if (this.mc.gameSettings.particleSetting == 1) {
                llllllllllllllIIIIlIIllllIllIlll >>= 1;
            }
            else if (this.mc.gameSettings.particleSetting == 2) {
                llllllllllllllIIIIlIIllllIllIlll = 0;
            }
            for (int llllllllllllllIIIIlIIllllIllIllI = 0; llllllllllllllIIIIlIIllllIllIllI < llllllllllllllIIIIlIIllllIllIlll; ++llllllllllllllIIIIlIIllllIllIllI) {
                final BlockPos llllllllllllllIIIIlIIllllIllIlIl = llllllllllllllIIIIlIIllllIlllllI.func_175725_q(llllllllllllllIIIIlIIllllIllllIl.add(this.random.nextInt(llllllllllllllIIIIlIIllllIllllII) - this.random.nextInt(llllllllllllllIIIIlIIllllIllllII), 0, this.random.nextInt(llllllllllllllIIIIlIIllllIllllII) - this.random.nextInt(llllllllllllllIIIIlIIllllIllllII)));
                final BiomeGenBase llllllllllllllIIIIlIIllllIllIlII = llllllllllllllIIIIlIIllllIlllllI.getBiomeGenForCoords(llllllllllllllIIIIlIIllllIllIlIl);
                final BlockPos llllllllllllllIIIIlIIllllIllIIll = llllllllllllllIIIIlIIllllIllIlIl.offsetDown();
                final Block llllllllllllllIIIIlIIllllIllIIlI = llllllllllllllIIIIlIIllllIlllllI.getBlockState(llllllllllllllIIIIlIIllllIllIIll).getBlock();
                if (llllllllllllllIIIIlIIllllIllIlIl.getY() <= llllllllllllllIIIIlIIllllIllllIl.getY() + llllllllllllllIIIIlIIllllIllllII && llllllllllllllIIIIlIIllllIllIlIl.getY() >= llllllllllllllIIIIlIIllllIllllIl.getY() - llllllllllllllIIIIlIIllllIllllII && llllllllllllllIIIIlIIllllIllIlII.canSpawnLightningBolt() && llllllllllllllIIIIlIIllllIllIlII.func_180626_a(llllllllllllllIIIIlIIllllIllIlIl) >= 0.15f) {
                    final float llllllllllllllIIIIlIIllllIllIIIl = this.random.nextFloat();
                    final float llllllllllllllIIIIlIIllllIllIIII = this.random.nextFloat();
                    if (llllllllllllllIIIIlIIllllIllIIlI.getMaterial() == Material.lava) {
                        this.mc.theWorld.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, llllllllllllllIIIIlIIllllIllIlIl.getX() + llllllllllllllIIIIlIIllllIllIIIl, llllllllllllllIIIIlIIllllIllIlIl.getY() + 0.1f - llllllllllllllIIIIlIIllllIllIIlI.getBlockBoundsMinY(), llllllllllllllIIIIlIIllllIllIlIl.getZ() + llllllllllllllIIIIlIIllllIllIIII, 0.0, 0.0, 0.0, new int[0]);
                    }
                    else if (llllllllllllllIIIIlIIllllIllIIlI.getMaterial() != Material.air) {
                        llllllllllllllIIIIlIIllllIllIIlI.setBlockBoundsBasedOnState(llllllllllllllIIIIlIIllllIlllllI, llllllllllllllIIIIlIIllllIllIIll);
                        ++llllllllllllllIIIIlIIllllIlllIII;
                        if (this.random.nextInt(llllllllllllllIIIIlIIllllIlllIII) == 0) {
                            llllllllllllllIIIIlIIllllIlllIll = llllllllllllllIIIIlIIllllIllIIll.getX() + llllllllllllllIIIIlIIllllIllIIIl;
                            llllllllllllllIIIIlIIllllIlllIlI = llllllllllllllIIIIlIIllllIllIIll.getY() + 0.1f + llllllllllllllIIIIlIIllllIllIIlI.getBlockBoundsMaxY() - 1.0;
                            llllllllllllllIIIIlIIllllIlllIIl = llllllllllllllIIIIlIIllllIllIIll.getZ() + llllllllllllllIIIIlIIllllIllIIII;
                        }
                        this.mc.theWorld.spawnParticle(EnumParticleTypes.WATER_DROP, llllllllllllllIIIIlIIllllIllIIll.getX() + llllllllllllllIIIIlIIllllIllIIIl, llllllllllllllIIIIlIIllllIllIIll.getY() + 0.1f + llllllllllllllIIIIlIIllllIllIIlI.getBlockBoundsMaxY(), llllllllllllllIIIIlIIllllIllIIll.getZ() + llllllllllllllIIIIlIIllllIllIIII, 0.0, 0.0, 0.0, new int[0]);
                    }
                }
            }
            if (llllllllllllllIIIIlIIllllIlllIII > 0 && this.random.nextInt(3) < this.rainSoundCounter++) {
                this.rainSoundCounter = 0;
                if (llllllllllllllIIIIlIIllllIlllIlI > llllllllllllllIIIIlIIllllIllllIl.getY() + 1 && llllllllllllllIIIIlIIllllIlllllI.func_175725_q(llllllllllllllIIIIlIIllllIllllIl).getY() > MathHelper.floor_float((float)llllllllllllllIIIIlIIllllIllllIl.getY())) {
                    this.mc.theWorld.playSound(llllllllllllllIIIIlIIllllIlllIll, llllllllllllllIIIIlIIllllIlllIlI, llllllllllllllIIIIlIIllllIlllIIl, "ambient.weather.rain", 0.1f, 0.5f, false);
                }
                else {
                    this.mc.theWorld.playSound(llllllllllllllIIIIlIIllllIlllIll, llllllllllllllIIIIlIIllllIlllIlI, llllllllllllllIIIIlIIllllIlllIIl, "ambient.weather.rain", 0.2f, 1.0f, false);
                }
            }
        }
    }
    
    private boolean func_175070_n() {
        if (!this.field_175073_D) {
            return false;
        }
        final Entity llllllllllllllIIIIlIlIIIIIlIllll = this.mc.func_175606_aa();
        boolean llllllllllllllIIIIlIlIIIIIlIlllI = llllllllllllllIIIIlIlIIIIIlIllll instanceof EntityPlayer && !this.mc.gameSettings.hideGUI;
        if (llllllllllllllIIIIlIlIIIIIlIlllI && !((EntityPlayer)llllllllllllllIIIIlIlIIIIIlIllll).capabilities.allowEdit) {
            final ItemStack llllllllllllllIIIIlIlIIIIIlIllIl = ((EntityPlayer)llllllllllllllIIIIlIlIIIIIlIllll).getCurrentEquippedItem();
            if (this.mc.objectMouseOver != null && this.mc.objectMouseOver.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
                final BlockPos llllllllllllllIIIIlIlIIIIIlIllII = this.mc.objectMouseOver.func_178782_a();
                final IBlockState llllllllllllllIIIIlIlIIIIIlIlIll = this.mc.theWorld.getBlockState(llllllllllllllIIIIlIlIIIIIlIllII);
                final Block llllllllllllllIIIIlIlIIIIIlIlIlI = llllllllllllllIIIIlIlIIIIIlIlIll.getBlock();
                if (this.mc.playerController.func_178889_l() == WorldSettings.GameType.SPECTATOR) {
                    llllllllllllllIIIIlIlIIIIIlIlllI = (ReflectorForge.blockHasTileEntity(llllllllllllllIIIIlIlIIIIIlIlIll) && this.mc.theWorld.getTileEntity(llllllllllllllIIIIlIlIIIIIlIllII) instanceof IInventory);
                }
                else {
                    llllllllllllllIIIIlIlIIIIIlIlllI = (llllllllllllllIIIIlIlIIIIIlIllIl != null && (llllllllllllllIIIIlIlIIIIIlIllIl.canDestroy(llllllllllllllIIIIlIlIIIIIlIlIlI) || llllllllllllllIIIIlIlIIIIIlIllIl.canPlaceOn(llllllllllllllIIIIlIlIIIIIlIlIlI)));
                }
            }
        }
        return llllllllllllllIIIIlIlIIIIIlIlllI;
    }
    
    public void activateNextShader() {
        if (OpenGlHelper.shadersSupported && this.mc.func_175606_aa() instanceof EntityPlayer) {
            if (this.theShaderGroup != null) {
                this.theShaderGroup.deleteShaderGroup();
            }
            this.shaderIndex = (this.shaderIndex + 1) % (EntityRenderer.shaderResourceLocations.length + 1);
            if (this.shaderIndex != EntityRenderer.shaderCount) {
                this.func_175069_a(EntityRenderer.shaderResourceLocations[this.shaderIndex]);
            }
            else {
                this.theShaderGroup = null;
            }
        }
    }
    
    public void func_175072_h() {
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.func_179090_x();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        if (Config.isShaders()) {
            Shaders.disableLightmap();
        }
    }
    
    public void func_175066_a(final Entity llllllllllllllIIIIlIlIIllllIIIIl) {
        if (OpenGlHelper.shadersSupported) {
            if (this.theShaderGroup != null) {
                this.theShaderGroup.deleteShaderGroup();
            }
            this.theShaderGroup = null;
            if (llllllllllllllIIIIlIlIIllllIIIIl instanceof EntityCreeper) {
                this.func_175069_a(new ResourceLocation("shaders/post/creeper.json"));
            }
            else if (llllllllllllllIIIIlIlIIllllIIIIl instanceof EntitySpider) {
                this.func_175069_a(new ResourceLocation("shaders/post/spider.json"));
            }
            else if (llllllllllllllIIIIlIlIIllllIIIIl instanceof EntityEnderman) {
                this.func_175069_a(new ResourceLocation("shaders/post/invert.json"));
            }
            else if (Reflector.ForgeHooksClient_loadEntityShader.exists()) {
                Reflector.call(Reflector.ForgeHooksClient_loadEntityShader, llllllllllllllIIIIlIlIIllllIIIIl, this);
            }
        }
    }
    
    private void frameInit() {
        if (!this.initialized) {
            TextureUtils.registerResourceListener();
            if (Config.getBitsOs() == 64 && Config.getBitsJre() == 32) {
                Config.setNotify64BitJava(true);
            }
            this.initialized = true;
        }
        Config.checkDisplayMode();
        final WorldClient llllllllllllllIIIIlIIllIlIIIlIlI = this.mc.theWorld;
        if (llllllllllllllIIIIlIIllIlIIIlIlI != null) {
            if (Config.getNewRelease() != null) {
                final String llllllllllllllIIIIlIIllIlIIIlIIl = "HD_U".replace("HD_U", "HD Ultra").replace("L", "Light");
                final String llllllllllllllIIIIlIIllIlIIIlIII = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIIlIIllIlIIIlIIl)).append(" ").append(Config.getNewRelease()));
                final ChatComponentText llllllllllllllIIIIlIIllIlIIIIlll = new ChatComponentText(I18n.format("of.message.newVersion", llllllllllllllIIIIlIIllIlIIIlIII));
                this.mc.ingameGUI.getChatGUI().printChatMessage(llllllllllllllIIIIlIIllIlIIIIlll);
                Config.setNewRelease(null);
            }
            if (Config.isNotify64BitJava()) {
                Config.setNotify64BitJava(false);
                final ChatComponentText llllllllllllllIIIIlIIllIlIIIIllI = new ChatComponentText(I18n.format("of.message.java64Bit", new Object[0]));
                this.mc.ingameGUI.getChatGUI().printChatMessage(llllllllllllllIIIIlIIllIlIIIIllI);
            }
        }
        if (this.mc.currentScreen instanceof GuiMainMenu) {
            this.updateMainMenu((GuiMainMenu)this.mc.currentScreen);
        }
        if (this.updatedWorld != llllllllllllllIIIIlIIllIlIIIlIlI) {
            RandomMobs.worldChanged(this.updatedWorld, llllllllllllllIIIIlIIllIlIIIlIlI);
            Config.updateThreadPriorities();
            this.lastServerTime = 0L;
            this.lastServerTicks = 0;
            this.updatedWorld = llllllllllllllIIIIlIIllIlIIIlIlI;
        }
        if (!this.setFxaaShader(Shaders.configAntialiasingLevel)) {
            Shaders.configAntialiasingLevel = 0;
        }
    }
    
    private void updateTorchFlicker() {
        this.field_175075_L += (float)((Math.random() - Math.random()) * Math.random() * Math.random());
        this.field_175075_L *= (float)0.9;
        this.torchFlickerX += (this.field_175075_L - this.torchFlickerX) * 1.0f;
        this.lightmapUpdateNeeded = true;
    }
    
    public void updateRenderer() {
        if (OpenGlHelper.shadersSupported && ShaderLinkHelper.getStaticShaderLinkHelper() == null) {
            ShaderLinkHelper.setNewStaticShaderLinkHelper();
        }
        this.updateFovModifierHand();
        this.updateTorchFlicker();
        this.fogColor2 = this.fogColor1;
        this.thirdPersonDistanceTemp = this.thirdPersonDistance;
        if (this.mc.gameSettings.smoothCamera) {
            final float llllllllllllllIIIIlIlIIlllIIIllI = this.mc.gameSettings.mouseSensitivity * 0.6f + 0.2f;
            final float llllllllllllllIIIIlIlIIlllIIIlII = llllllllllllllIIIIlIlIIlllIIIllI * llllllllllllllIIIIlIlIIlllIIIllI * llllllllllllllIIIIlIlIIlllIIIllI * 8.0f;
            this.smoothCamFilterX = this.mouseFilterXAxis.smooth(this.smoothCamYaw, 0.05f * llllllllllllllIIIIlIlIIlllIIIlII);
            this.smoothCamFilterY = this.mouseFilterYAxis.smooth(this.smoothCamPitch, 0.05f * llllllllllllllIIIIlIlIIlllIIIlII);
            this.smoothCamPartialTicks = 0.0f;
            this.smoothCamYaw = 0.0f;
            this.smoothCamPitch = 0.0f;
        }
        else {
            this.smoothCamFilterX = 0.0f;
            this.smoothCamFilterY = 0.0f;
            this.mouseFilterXAxis.func_180179_a();
            this.mouseFilterYAxis.func_180179_a();
        }
        if (this.mc.func_175606_aa() == null) {
            this.mc.func_175607_a(this.mc.thePlayer);
        }
        final Entity llllllllllllllIIIIlIlIIlllIIIIlI = this.mc.func_175606_aa();
        final double llllllllllllllIIIIlIlIIlllIIIIIl = llllllllllllllIIIIlIlIIlllIIIIlI.posX;
        final double llllllllllllllIIIIlIlIIlllIIIIII = llllllllllllllIIIIlIlIIlllIIIIlI.posY + llllllllllllllIIIIlIlIIlllIIIIlI.getEyeHeight();
        final double llllllllllllllIIIIlIlIIllIllllll = llllllllllllllIIIIlIlIIlllIIIIlI.posZ;
        final float llllllllllllllIIIIlIlIIlllIIIlIl = this.mc.theWorld.getLightBrightness(new BlockPos(llllllllllllllIIIIlIlIIlllIIIIIl, llllllllllllllIIIIlIlIIlllIIIIII, llllllllllllllIIIIlIlIIllIllllll));
        float llllllllllllllIIIIlIlIIlllIIIIll = this.mc.gameSettings.renderDistanceChunks / 16.0f;
        llllllllllllllIIIIlIlIIlllIIIIll = MathHelper.clamp_float(llllllllllllllIIIIlIlIIlllIIIIll, 0.0f, 1.0f);
        final float llllllllllllllIIIIlIlIIllIlllllI = llllllllllllllIIIIlIlIIlllIIIlIl * (1.0f - llllllllllllllIIIIlIlIIlllIIIIll) + llllllllllllllIIIIlIlIIlllIIIIll;
        this.fogColor1 += (llllllllllllllIIIIlIlIIllIlllllI - this.fogColor1) * 0.1f;
        ++this.rendererUpdateCount;
        this.itemRenderer.updateEquippedItem();
        this.addRainParticles();
        this.bossColorModifierPrev = this.bossColorModifier;
        if (BossStatus.hasColorModifier) {
            this.bossColorModifier += 0.05f;
            if (this.bossColorModifier > 1.0f) {
                this.bossColorModifier = 1.0f;
            }
            BossStatus.hasColorModifier = false;
        }
        else if (this.bossColorModifier > 0.0f) {
            this.bossColorModifier -= 0.0125f;
        }
    }
    
    static {
        __OBFID = "CL_00000947";
        logger = LogManager.getLogger();
        locationRainPng = new ResourceLocation("textures/environment/rain.png");
        locationSnowPng = new ResourceLocation("textures/environment/snow.png");
        shaderResourceLocations = new ResourceLocation[] { new ResourceLocation("shaders/post/notch.json"), new ResourceLocation("shaders/post/fxaa.json"), new ResourceLocation("shaders/post/art.json"), new ResourceLocation("shaders/post/bumpy.json"), new ResourceLocation("shaders/post/blobs2.json"), new ResourceLocation("shaders/post/pencil.json"), new ResourceLocation("shaders/post/color_convolve.json"), new ResourceLocation("shaders/post/deconverge.json"), new ResourceLocation("shaders/post/flip.json"), new ResourceLocation("shaders/post/invert.json"), new ResourceLocation("shaders/post/ntsc.json"), new ResourceLocation("shaders/post/outline.json"), new ResourceLocation("shaders/post/phosphor.json"), new ResourceLocation("shaders/post/scan_pincushion.json"), new ResourceLocation("shaders/post/sobel.json"), new ResourceLocation("shaders/post/bits.json"), new ResourceLocation("shaders/post/desaturate.json"), new ResourceLocation("shaders/post/green.json"), new ResourceLocation("shaders/post/blur.json"), new ResourceLocation("shaders/post/wobble.json"), new ResourceLocation("shaders/post/blobs.json"), new ResourceLocation("shaders/post/antialias.json"), new ResourceLocation("shaders/post/creeper.json"), new ResourceLocation("shaders/post/spider.json") };
        shaderCount = EntityRenderer.shaderResourceLocations.length;
    }
    
    private void frameFinish() {
        if (this.mc.theWorld != null) {
            final long llllllllllllllIIIIlIIllIIllllIlI = System.currentTimeMillis();
            if (llllllllllllllIIIIlIIllIIllllIlI > this.lastErrorCheckTimeMs + 10000L) {
                this.lastErrorCheckTimeMs = llllllllllllllIIIIlIIllIIllllIlI;
                final int llllllllllllllIIIIlIIllIIllllIIl = GL11.glGetError();
                if (llllllllllllllIIIIlIIllIIllllIIl != 0) {
                    final String llllllllllllllIIIIlIIllIIllllIII = GLU.gluErrorString(llllllllllllllIIIIlIIllIIllllIIl);
                    final ChatComponentText llllllllllllllIIIIlIIllIIlllIlll = new ChatComponentText(I18n.format("of.message.openglError", llllllllllllllIIIIlIIllIIllllIIl, llllllllllllllIIIIlIIllIIllllIII));
                    this.mc.ingameGUI.getChatGUI().printChatMessage(llllllllllllllIIIIlIIllIIlllIlll);
                }
            }
        }
    }
    
    public boolean setFxaaShader(final int llllllllllllllIIIIlIIllIIlIlIllI) {
        if (!OpenGlHelper.isFramebufferEnabled()) {
            return false;
        }
        if (this.theShaderGroup != null && this.theShaderGroup != this.fxaaShaders[2] && this.theShaderGroup != this.fxaaShaders[4]) {
            return true;
        }
        if (llllllllllllllIIIIlIIllIIlIlIllI != 2 && llllllllllllllIIIIlIIllIIlIlIllI != 4) {
            if (this.theShaderGroup == null) {
                return true;
            }
            this.theShaderGroup.deleteShaderGroup();
            this.theShaderGroup = null;
            return true;
        }
        else {
            if (this.theShaderGroup != null && this.theShaderGroup == this.fxaaShaders[llllllllllllllIIIIlIIllIIlIlIllI]) {
                return true;
            }
            if (this.mc.theWorld == null) {
                return true;
            }
            this.func_175069_a(new ResourceLocation(String.valueOf(new StringBuilder("shaders/post/fxaa_of_").append(llllllllllllllIIIIlIIllIIlIlIllI).append("x.json"))));
            this.fxaaShaders[llllllllllllllIIIIlIIllIIlIlIllI] = this.theShaderGroup;
            return this.field_175083_ad;
        }
    }
    
    public void setupCameraTransform(final float llllllllllllllIIIIlIlIIIllIlIlII, final int llllllllllllllIIIIlIlIIIllIlIIll) {
        this.farPlaneDistance = (float)(this.mc.gameSettings.renderDistanceChunks * 16);
        if (Config.isFogFancy()) {
            this.farPlaneDistance *= 0.95f;
        }
        if (Config.isFogFast()) {
            this.farPlaneDistance *= 0.83f;
        }
        GlStateManager.matrixMode(5889);
        GlStateManager.loadIdentity();
        final float llllllllllllllIIIIlIlIIIllIllIIl = 0.07f;
        if (this.mc.gameSettings.anaglyph) {
            GlStateManager.translate(-(llllllllllllllIIIIlIlIIIllIlIIll * 2 - 1) * llllllllllllllIIIIlIlIIIllIllIIl, 0.0f, 0.0f);
        }
        this.clipDistance = this.farPlaneDistance * 2.0f;
        if (this.clipDistance < 173.0f) {
            this.clipDistance = 173.0f;
        }
        if (this.mc.theWorld.provider.getDimensionId() == 1) {
            this.clipDistance = 256.0f;
        }
        if (this.cameraZoom != 1.0) {
            GlStateManager.translate((float)this.cameraYaw, (float)(-this.cameraPitch), 0.0f);
            GlStateManager.scale(this.cameraZoom, this.cameraZoom, 1.0);
        }
        Project.gluPerspective(this.getFOVModifier(llllllllllllllIIIIlIlIIIllIlIlII, true), this.mc.displayWidth / (float)this.mc.displayHeight, 0.05f, this.clipDistance);
        GlStateManager.matrixMode(5888);
        GlStateManager.loadIdentity();
        if (this.mc.gameSettings.anaglyph) {
            GlStateManager.translate((llllllllllllllIIIIlIlIIIllIlIIll * 2 - 1) * 0.1f, 0.0f, 0.0f);
        }
        this.hurtCameraEffect(llllllllllllllIIIIlIlIIIllIlIlII);
        if (this.mc.gameSettings.viewBobbing) {
            this.setupViewBobbing(llllllllllllllIIIIlIlIIIllIlIlII);
        }
        final float llllllllllllllIIIIlIlIIIllIllIII = this.mc.thePlayer.prevTimeInPortal + (this.mc.thePlayer.timeInPortal - this.mc.thePlayer.prevTimeInPortal) * llllllllllllllIIIIlIlIIIllIlIlII;
        if (llllllllllllllIIIIlIlIIIllIllIII > 0.0f) {
            byte llllllllllllllIIIIlIlIIIllIlIlll = 20;
            if (this.mc.thePlayer.isPotionActive(Potion.confusion)) {
                llllllllllllllIIIIlIlIIIllIlIlll = 7;
            }
            float llllllllllllllIIIIlIlIIIllIlIllI = 5.0f / (llllllllllllllIIIIlIlIIIllIllIII * llllllllllllllIIIIlIlIIIllIllIII + 5.0f) - llllllllllllllIIIIlIlIIIllIllIII * 0.04f;
            llllllllllllllIIIIlIlIIIllIlIllI *= llllllllllllllIIIIlIlIIIllIlIllI;
            GlStateManager.rotate((this.rendererUpdateCount + llllllllllllllIIIIlIlIIIllIlIlII) * llllllllllllllIIIIlIlIIIllIlIlll, 0.0f, 1.0f, 1.0f);
            GlStateManager.scale(1.0f / llllllllllllllIIIIlIlIIIllIlIllI, 1.0f, 1.0f);
            GlStateManager.rotate(-(this.rendererUpdateCount + llllllllllllllIIIIlIlIIIllIlIlII) * llllllllllllllIIIIlIlIIIllIlIlll, 0.0f, 1.0f, 1.0f);
        }
        this.orientCamera(llllllllllllllIIIIlIlIIIllIlIlII);
        if (this.field_175078_W) {
            switch (this.field_175079_V) {
                case 0: {
                    GlStateManager.rotate(90.0f, 0.0f, 1.0f, 0.0f);
                    break;
                }
                case 1: {
                    GlStateManager.rotate(180.0f, 0.0f, 1.0f, 0.0f);
                    break;
                }
                case 2: {
                    GlStateManager.rotate(-90.0f, 0.0f, 1.0f, 0.0f);
                    break;
                }
                case 3: {
                    GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
                    break;
                }
                case 4: {
                    GlStateManager.rotate(-90.0f, 1.0f, 0.0f, 0.0f);
                    break;
                }
            }
        }
    }
    
    private void waitForServerThread() {
        this.serverWaitTimeCurrent = 0;
        if (Config.isSmoothWorld() && Config.isSingleProcessor()) {
            if (this.mc.isIntegratedServerRunning()) {
                final IntegratedServer llllllllllllllIIIIlIIllIlIIlllIl = this.mc.getIntegratedServer();
                if (llllllllllllllIIIIlIIllIlIIlllIl != null) {
                    final boolean llllllllllllllIIIIlIIllIlIIlllII = this.mc.isGamePaused();
                    if (!llllllllllllllIIIIlIIllIlIIlllII && !(this.mc.currentScreen instanceof GuiDownloadTerrain)) {
                        if (this.serverWaitTime > 0) {
                            Lagometer.timerServer.start();
                            Config.sleep(this.serverWaitTime);
                            Lagometer.timerServer.end();
                            this.serverWaitTimeCurrent = this.serverWaitTime;
                        }
                        final long llllllllllllllIIIIlIIllIlIIllIll = System.nanoTime() / 1000000L;
                        if (this.lastServerTime != 0L && this.lastServerTicks != 0) {
                            long llllllllllllllIIIIlIIllIlIIllIlI = llllllllllllllIIIIlIIllIlIIllIll - this.lastServerTime;
                            if (llllllllllllllIIIIlIIllIlIIllIlI < 0L) {
                                this.lastServerTime = llllllllllllllIIIIlIIllIlIIllIll;
                                llllllllllllllIIIIlIIllIlIIllIlI = 0L;
                            }
                            if (llllllllllllllIIIIlIIllIlIIllIlI >= 50L) {
                                this.lastServerTime = llllllllllllllIIIIlIIllIlIIllIll;
                                final int llllllllllllllIIIIlIIllIlIIllIIl = llllllllllllllIIIIlIIllIlIIlllIl.getTickCounter();
                                int llllllllllllllIIIIlIIllIlIIllIII = llllllllllllllIIIIlIIllIlIIllIIl - this.lastServerTicks;
                                if (llllllllllllllIIIIlIIllIlIIllIII < 0) {
                                    this.lastServerTicks = llllllllllllllIIIIlIIllIlIIllIIl;
                                    llllllllllllllIIIIlIIllIlIIllIII = 0;
                                }
                                if (llllllllllllllIIIIlIIllIlIIllIII < 1 && this.serverWaitTime < 100) {
                                    this.serverWaitTime += 2;
                                }
                                if (llllllllllllllIIIIlIIllIlIIllIII > 1 && this.serverWaitTime > 0) {
                                    --this.serverWaitTime;
                                }
                                this.lastServerTicks = llllllllllllllIIIIlIIllIlIIllIIl;
                            }
                        }
                        else {
                            this.lastServerTime = llllllllllllllIIIIlIIllIlIIllIll;
                            this.lastServerTicks = llllllllllllllIIIIlIIllIlIIlllIl.getTickCounter();
                            this.avgServerTickDiff = 1.0f;
                            this.avgServerTimeDiff = 50.0f;
                        }
                    }
                    else {
                        if (this.mc.currentScreen instanceof GuiDownloadTerrain) {
                            Config.sleep(20L);
                        }
                        this.lastServerTime = 0L;
                        this.lastServerTicks = 0;
                    }
                }
            }
        }
        else {
            this.lastServerTime = 0L;
            this.lastServerTicks = 0;
        }
    }
    
    private float func_180438_a(final EntityLivingBase llllllllllllllIIIIlIlIIIIllIlIIl, final float llllllllllllllIIIIlIlIIIIllIlIII) {
        final int llllllllllllllIIIIlIlIIIIllIlIlI = llllllllllllllIIIIlIlIIIIllIlIIl.getActivePotionEffect(Potion.nightVision).getDuration();
        return (llllllllllllllIIIIlIlIIIIllIlIlI > 200) ? 1.0f : (0.7f + MathHelper.sin((llllllllllllllIIIIlIlIIIIllIlIlI - llllllllllllllIIIIlIlIIIIllIlIII) * 3.1415927f * 0.2f) * 0.3f);
    }
    
    protected void renderRainSnow(final float llllllllllllllIIIIlIIlllIlllIllI) {
        if (Reflector.ForgeWorldProvider_getWeatherRenderer.exists()) {
            final WorldProvider llllllllllllllIIIIlIIlllIlllIlIl = this.mc.theWorld.provider;
            final Object llllllllllllllIIIIlIIlllIlllIlII = Reflector.call(llllllllllllllIIIIlIIlllIlllIlIl, Reflector.ForgeWorldProvider_getWeatherRenderer, new Object[0]);
            if (llllllllllllllIIIIlIIlllIlllIlII != null) {
                Reflector.callVoid(llllllllllllllIIIIlIIlllIlllIlII, Reflector.IRenderHandler_render, llllllllllllllIIIIlIIlllIlllIllI, this.mc.theWorld, this.mc);
                return;
            }
        }
        final float llllllllllllllIIIIlIIlllIlllIIll = this.mc.theWorld.getRainStrength(llllllllllllllIIIIlIIlllIlllIllI);
        if (llllllllllllllIIIIlIIlllIlllIIll > 0.0f) {
            if (Config.isRainOff()) {
                return;
            }
            this.func_180436_i();
            final Entity llllllllllllllIIIIlIIlllIlllIIlI = this.mc.func_175606_aa();
            final WorldClient llllllllllllllIIIIlIIlllIlllIIIl = this.mc.theWorld;
            final int llllllllllllllIIIIlIIlllIlllIIII = MathHelper.floor_double(llllllllllllllIIIIlIIlllIlllIIlI.posX);
            final int llllllllllllllIIIIlIIlllIllIllll = MathHelper.floor_double(llllllllllllllIIIIlIIlllIlllIIlI.posY);
            final int llllllllllllllIIIIlIIlllIllIlllI = MathHelper.floor_double(llllllllllllllIIIIlIIlllIlllIIlI.posZ);
            final Tessellator llllllllllllllIIIIlIIlllIllIllIl = Tessellator.getInstance();
            final WorldRenderer llllllllllllllIIIIlIIlllIllIllII = llllllllllllllIIIIlIIlllIllIllIl.getWorldRenderer();
            GlStateManager.disableCull();
            GL11.glNormal3f(0.0f, 1.0f, 0.0f);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            GlStateManager.alphaFunc(516, 0.1f);
            final double llllllllllllllIIIIlIIlllIllIlIll = llllllllllllllIIIIlIIlllIlllIIlI.lastTickPosX + (llllllllllllllIIIIlIIlllIlllIIlI.posX - llllllllllllllIIIIlIIlllIlllIIlI.lastTickPosX) * llllllllllllllIIIIlIIlllIlllIllI;
            final double llllllllllllllIIIIlIIlllIllIlIlI = llllllllllllllIIIIlIIlllIlllIIlI.lastTickPosY + (llllllllllllllIIIIlIIlllIlllIIlI.posY - llllllllllllllIIIIlIIlllIlllIIlI.lastTickPosY) * llllllllllllllIIIIlIIlllIlllIllI;
            final double llllllllllllllIIIIlIIlllIllIlIIl = llllllllllllllIIIIlIIlllIlllIIlI.lastTickPosZ + (llllllllllllllIIIIlIIlllIlllIIlI.posZ - llllllllllllllIIIIlIIlllIlllIIlI.lastTickPosZ) * llllllllllllllIIIIlIIlllIlllIllI;
            final int llllllllllllllIIIIlIIlllIllIlIII = MathHelper.floor_double(llllllllllllllIIIIlIIlllIllIlIlI);
            byte llllllllllllllIIIIlIIlllIllIIlll = 5;
            if (Config.isRainFancy()) {
                llllllllllllllIIIIlIIlllIllIIlll = 10;
            }
            byte llllllllllllllIIIIlIIlllIllIIllI = -1;
            final float llllllllllllllIIIIlIIlllIllIIlIl = this.rendererUpdateCount + llllllllllllllIIIIlIIlllIlllIllI;
            if (Config.isRainFancy()) {
                llllllllllllllIIIIlIIlllIllIIlll = 10;
            }
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            for (int llllllllllllllIIIIlIIlllIllIIlII = llllllllllllllIIIIlIIlllIllIlllI - llllllllllllllIIIIlIIlllIllIIlll; llllllllllllllIIIIlIIlllIllIIlII <= llllllllllllllIIIIlIIlllIllIlllI + llllllllllllllIIIIlIIlllIllIIlll; ++llllllllllllllIIIIlIIlllIllIIlII) {
                for (int llllllllllllllIIIIlIIlllIllIIIll = llllllllllllllIIIIlIIlllIlllIIII - llllllllllllllIIIIlIIlllIllIIlll; llllllllllllllIIIIlIIlllIllIIIll <= llllllllllllllIIIIlIIlllIlllIIII + llllllllllllllIIIIlIIlllIllIIlll; ++llllllllllllllIIIIlIIlllIllIIIll) {
                    final int llllllllllllllIIIIlIIlllIllIIIlI = (llllllllllllllIIIIlIIlllIllIIlII - llllllllllllllIIIIlIIlllIllIlllI + 16) * 32 + llllllllllllllIIIIlIIlllIllIIIll - llllllllllllllIIIIlIIlllIlllIIII + 16;
                    final float llllllllllllllIIIIlIIlllIllIIIIl = this.field_175076_N[llllllllllllllIIIIlIIlllIllIIIlI] * 0.5f;
                    final float llllllllllllllIIIIlIIlllIllIIIII = this.field_175077_O[llllllllllllllIIIIlIIlllIllIIIlI] * 0.5f;
                    final BlockPos llllllllllllllIIIIlIIlllIlIlllll = new BlockPos(llllllllllllllIIIIlIIlllIllIIIll, 0, llllllllllllllIIIIlIIlllIllIIlII);
                    final BiomeGenBase llllllllllllllIIIIlIIlllIlIllllI = llllllllllllllIIIIlIIlllIlllIIIl.getBiomeGenForCoords(llllllllllllllIIIIlIIlllIlIlllll);
                    if (llllllllllllllIIIIlIIlllIlIllllI.canSpawnLightningBolt() || llllllllllllllIIIIlIIlllIlIllllI.getEnableSnow()) {
                        final int llllllllllllllIIIIlIIlllIlIlllIl = llllllllllllllIIIIlIIlllIlllIIIl.func_175725_q(llllllllllllllIIIIlIIlllIlIlllll).getY();
                        int llllllllllllllIIIIlIIlllIlIlllII = llllllllllllllIIIIlIIlllIllIllll - llllllllllllllIIIIlIIlllIllIIlll;
                        int llllllllllllllIIIIlIIlllIlIllIll = llllllllllllllIIIIlIIlllIllIllll + llllllllllllllIIIIlIIlllIllIIlll;
                        if (llllllllllllllIIIIlIIlllIlIlllII < llllllllllllllIIIIlIIlllIlIlllIl) {
                            llllllllllllllIIIIlIIlllIlIlllII = llllllllllllllIIIIlIIlllIlIlllIl;
                        }
                        if (llllllllllllllIIIIlIIlllIlIllIll < llllllllllllllIIIIlIIlllIlIlllIl) {
                            llllllllllllllIIIIlIIlllIlIllIll = llllllllllllllIIIIlIIlllIlIlllIl;
                        }
                        final float llllllllllllllIIIIlIIlllIlIllIlI = 1.0f;
                        int llllllllllllllIIIIlIIlllIlIllIIl;
                        if ((llllllllllllllIIIIlIIlllIlIllIIl = llllllllllllllIIIIlIIlllIlIlllIl) < llllllllllllllIIIIlIIlllIllIlIII) {
                            llllllllllllllIIIIlIIlllIlIllIIl = llllllllllllllIIIIlIIlllIllIlIII;
                        }
                        if (llllllllllllllIIIIlIIlllIlIlllII != llllllllllllllIIIIlIIlllIlIllIll) {
                            this.random.setSeed(llllllllllllllIIIIlIIlllIllIIIll * llllllllllllllIIIIlIIlllIllIIIll * 3121 + llllllllllllllIIIIlIIlllIllIIIll * 45238971 ^ llllllllllllllIIIIlIIlllIllIIlII * llllllllllllllIIIIlIIlllIllIIlII * 418711 + llllllllllllllIIIIlIIlllIllIIlII * 13761);
                            final float llllllllllllllIIIIlIIlllIlIllIII = llllllllllllllIIIIlIIlllIlIllllI.func_180626_a(new BlockPos(llllllllllllllIIIIlIIlllIllIIIll, llllllllllllllIIIIlIIlllIlIlllII, llllllllllllllIIIIlIIlllIllIIlII));
                            if (llllllllllllllIIIIlIIlllIlllIIIl.getWorldChunkManager().getTemperatureAtHeight(llllllllllllllIIIIlIIlllIlIllIII, llllllllllllllIIIIlIIlllIlIlllIl) >= 0.15f) {
                                if (llllllllllllllIIIIlIIlllIllIIllI != 0) {
                                    if (llllllllllllllIIIIlIIlllIllIIllI >= 0) {
                                        llllllllllllllIIIIlIIlllIllIllIl.draw();
                                    }
                                    llllllllllllllIIIIlIIlllIllIIllI = 0;
                                    this.mc.getTextureManager().bindTexture(EntityRenderer.locationRainPng);
                                    llllllllllllllIIIIlIIlllIllIllII.startDrawingQuads();
                                }
                                final float llllllllllllllIIIIlIIlllIlIlIlll = ((this.rendererUpdateCount + llllllllllllllIIIIlIIlllIllIIIll * llllllllllllllIIIIlIIlllIllIIIll * 3121 + llllllllllllllIIIIlIIlllIllIIIll * 45238971 + llllllllllllllIIIIlIIlllIllIIlII * llllllllllllllIIIIlIIlllIllIIlII * 418711 + llllllllllllllIIIIlIIlllIllIIlII * 13761 & 0x1F) + llllllllllllllIIIIlIIlllIlllIllI) / 32.0f * (3.0f + this.random.nextFloat());
                                final double llllllllllllllIIIIlIIlllIlIlIIll = llllllllllllllIIIIlIIlllIllIIIll + 0.5f - llllllllllllllIIIIlIIlllIlllIIlI.posX;
                                final double llllllllllllllIIIIlIIlllIlIlIlIl = llllllllllllllIIIIlIIlllIllIIlII + 0.5f - llllllllllllllIIIIlIIlllIlllIIlI.posZ;
                                final float llllllllllllllIIIIlIIlllIlIlIIlI = MathHelper.sqrt_double(llllllllllllllIIIIlIIlllIlIlIIll * llllllllllllllIIIIlIIlllIlIlIIll + llllllllllllllIIIIlIIlllIlIlIlIl * llllllllllllllIIIIlIIlllIlIlIlIl) / llllllllllllllIIIIlIIlllIllIIlll;
                                final float llllllllllllllIIIIlIIlllIlIlIIIl = 1.0f;
                                llllllllllllllIIIIlIIlllIllIllII.func_178963_b(llllllllllllllIIIIlIIlllIlllIIIl.getCombinedLight(new BlockPos(llllllllllllllIIIIlIIlllIllIIIll, llllllllllllllIIIIlIIlllIlIllIIl, llllllllllllllIIIIlIIlllIllIIlII), 0));
                                llllllllllllllIIIIlIIlllIllIllII.func_178960_a(llllllllllllllIIIIlIIlllIlIlIIIl, llllllllllllllIIIIlIIlllIlIlIIIl, llllllllllllllIIIIlIIlllIlIlIIIl, ((1.0f - llllllllllllllIIIIlIIlllIlIlIIlI * llllllllllllllIIIIlIIlllIlIlIIlI) * 0.5f + 0.5f) * llllllllllllllIIIIlIIlllIlllIIll);
                                llllllllllllllIIIIlIIlllIllIllII.setTranslation(-llllllllllllllIIIIlIIlllIllIlIll * 1.0, -llllllllllllllIIIIlIIlllIllIlIlI * 1.0, -llllllllllllllIIIIlIIlllIllIlIIl * 1.0);
                                llllllllllllllIIIIlIIlllIllIllII.addVertexWithUV(llllllllllllllIIIIlIIlllIllIIIll - llllllllllllllIIIIlIIlllIllIIIIl + 0.5, llllllllllllllIIIIlIIlllIlIlllII, llllllllllllllIIIIlIIlllIllIIlII - llllllllllllllIIIIlIIlllIllIIIII + 0.5, 0.0f * llllllllllllllIIIIlIIlllIlIllIlI, llllllllllllllIIIIlIIlllIlIlllII * llllllllllllllIIIIlIIlllIlIllIlI / 4.0f + llllllllllllllIIIIlIIlllIlIlIlll * llllllllllllllIIIIlIIlllIlIllIlI);
                                llllllllllllllIIIIlIIlllIllIllII.addVertexWithUV(llllllllllllllIIIIlIIlllIllIIIll + llllllllllllllIIIIlIIlllIllIIIIl + 0.5, llllllllllllllIIIIlIIlllIlIlllII, llllllllllllllIIIIlIIlllIllIIlII + llllllllllllllIIIIlIIlllIllIIIII + 0.5, 1.0f * llllllllllllllIIIIlIIlllIlIllIlI, llllllllllllllIIIIlIIlllIlIlllII * llllllllllllllIIIIlIIlllIlIllIlI / 4.0f + llllllllllllllIIIIlIIlllIlIlIlll * llllllllllllllIIIIlIIlllIlIllIlI);
                                llllllllllllllIIIIlIIlllIllIllII.addVertexWithUV(llllllllllllllIIIIlIIlllIllIIIll + llllllllllllllIIIIlIIlllIllIIIIl + 0.5, llllllllllllllIIIIlIIlllIlIllIll, llllllllllllllIIIIlIIlllIllIIlII + llllllllllllllIIIIlIIlllIllIIIII + 0.5, 1.0f * llllllllllllllIIIIlIIlllIlIllIlI, llllllllllllllIIIIlIIlllIlIllIll * llllllllllllllIIIIlIIlllIlIllIlI / 4.0f + llllllllllllllIIIIlIIlllIlIlIlll * llllllllllllllIIIIlIIlllIlIllIlI);
                                llllllllllllllIIIIlIIlllIllIllII.addVertexWithUV(llllllllllllllIIIIlIIlllIllIIIll - llllllllllllllIIIIlIIlllIllIIIIl + 0.5, llllllllllllllIIIIlIIlllIlIllIll, llllllllllllllIIIIlIIlllIllIIlII - llllllllllllllIIIIlIIlllIllIIIII + 0.5, 0.0f * llllllllllllllIIIIlIIlllIlIllIlI, llllllllllllllIIIIlIIlllIlIllIll * llllllllllllllIIIIlIIlllIlIllIlI / 4.0f + llllllllllllllIIIIlIIlllIlIlIlll * llllllllllllllIIIIlIIlllIlIllIlI);
                                llllllllllllllIIIIlIIlllIllIllII.setTranslation(0.0, 0.0, 0.0);
                            }
                            else {
                                if (llllllllllllllIIIIlIIlllIllIIllI != 1) {
                                    if (llllllllllllllIIIIlIIlllIllIIllI >= 0) {
                                        llllllllllllllIIIIlIIlllIllIllIl.draw();
                                    }
                                    llllllllllllllIIIIlIIlllIllIIllI = 1;
                                    this.mc.getTextureManager().bindTexture(EntityRenderer.locationSnowPng);
                                    llllllllllllllIIIIlIIlllIllIllII.startDrawingQuads();
                                }
                                final float llllllllllllllIIIIlIIlllIlIlIllI = ((this.rendererUpdateCount & 0x1FF) + llllllllllllllIIIIlIIlllIlllIllI) / 512.0f;
                                final float llllllllllllllIIIIlIIlllIlIlIIII = this.random.nextFloat() + llllllllllllllIIIIlIIlllIllIIlIl * 0.01f * (float)this.random.nextGaussian();
                                final float llllllllllllllIIIIlIIlllIlIIllll = this.random.nextFloat() + llllllllllllllIIIIlIIlllIllIIlIl * (float)this.random.nextGaussian() * 0.001f;
                                final double llllllllllllllIIIIlIIlllIlIlIlII = llllllllllllllIIIIlIIlllIllIIIll + 0.5f - llllllllllllllIIIIlIIlllIlllIIlI.posX;
                                final double llllllllllllllIIIIlIIlllIlIIlllI = llllllllllllllIIIIlIIlllIllIIlII + 0.5f - llllllllllllllIIIIlIIlllIlllIIlI.posZ;
                                final float llllllllllllllIIIIlIIlllIlIIllIl = MathHelper.sqrt_double(llllllllllllllIIIIlIIlllIlIlIlII * llllllllllllllIIIIlIIlllIlIlIlII + llllllllllllllIIIIlIIlllIlIIlllI * llllllllllllllIIIIlIIlllIlIIlllI) / llllllllllllllIIIIlIIlllIllIIlll;
                                final float llllllllllllllIIIIlIIlllIlIIllII = 1.0f;
                                llllllllllllllIIIIlIIlllIllIllII.func_178963_b((llllllllllllllIIIIlIIlllIlllIIIl.getCombinedLight(new BlockPos(llllllllllllllIIIIlIIlllIllIIIll, llllllllllllllIIIIlIIlllIlIllIIl, llllllllllllllIIIIlIIlllIllIIlII), 0) * 3 + 15728880) / 4);
                                llllllllllllllIIIIlIIlllIllIllII.func_178960_a(llllllllllllllIIIIlIIlllIlIIllII, llllllllllllllIIIIlIIlllIlIIllII, llllllllllllllIIIIlIIlllIlIIllII, ((1.0f - llllllllllllllIIIIlIIlllIlIIllIl * llllllllllllllIIIIlIIlllIlIIllIl) * 0.3f + 0.5f) * llllllllllllllIIIIlIIlllIlllIIll);
                                llllllllllllllIIIIlIIlllIllIllII.setTranslation(-llllllllllllllIIIIlIIlllIllIlIll * 1.0, -llllllllllllllIIIIlIIlllIllIlIlI * 1.0, -llllllllllllllIIIIlIIlllIllIlIIl * 1.0);
                                llllllllllllllIIIIlIIlllIllIllII.addVertexWithUV(llllllllllllllIIIIlIIlllIllIIIll - llllllllllllllIIIIlIIlllIllIIIIl + 0.5, llllllllllllllIIIIlIIlllIlIlllII, llllllllllllllIIIIlIIlllIllIIlII - llllllllllllllIIIIlIIlllIllIIIII + 0.5, 0.0f * llllllllllllllIIIIlIIlllIlIllIlI + llllllllllllllIIIIlIIlllIlIlIIII, llllllllllllllIIIIlIIlllIlIlllII * llllllllllllllIIIIlIIlllIlIllIlI / 4.0f + llllllllllllllIIIIlIIlllIlIlIllI * llllllllllllllIIIIlIIlllIlIllIlI + llllllllllllllIIIIlIIlllIlIIllll);
                                llllllllllllllIIIIlIIlllIllIllII.addVertexWithUV(llllllllllllllIIIIlIIlllIllIIIll + llllllllllllllIIIIlIIlllIllIIIIl + 0.5, llllllllllllllIIIIlIIlllIlIlllII, llllllllllllllIIIIlIIlllIllIIlII + llllllllllllllIIIIlIIlllIllIIIII + 0.5, 1.0f * llllllllllllllIIIIlIIlllIlIllIlI + llllllllllllllIIIIlIIlllIlIlIIII, llllllllllllllIIIIlIIlllIlIlllII * llllllllllllllIIIIlIIlllIlIllIlI / 4.0f + llllllllllllllIIIIlIIlllIlIlIllI * llllllllllllllIIIIlIIlllIlIllIlI + llllllllllllllIIIIlIIlllIlIIllll);
                                llllllllllllllIIIIlIIlllIllIllII.addVertexWithUV(llllllllllllllIIIIlIIlllIllIIIll + llllllllllllllIIIIlIIlllIllIIIIl + 0.5, llllllllllllllIIIIlIIlllIlIllIll, llllllllllllllIIIIlIIlllIllIIlII + llllllllllllllIIIIlIIlllIllIIIII + 0.5, 1.0f * llllllllllllllIIIIlIIlllIlIllIlI + llllllllllllllIIIIlIIlllIlIlIIII, llllllllllllllIIIIlIIlllIlIllIll * llllllllllllllIIIIlIIlllIlIllIlI / 4.0f + llllllllllllllIIIIlIIlllIlIlIllI * llllllllllllllIIIIlIIlllIlIllIlI + llllllllllllllIIIIlIIlllIlIIllll);
                                llllllllllllllIIIIlIIlllIllIllII.addVertexWithUV(llllllllllllllIIIIlIIlllIllIIIll - llllllllllllllIIIIlIIlllIllIIIIl + 0.5, llllllllllllllIIIIlIIlllIlIllIll, llllllllllllllIIIIlIIlllIllIIlII - llllllllllllllIIIIlIIlllIllIIIII + 0.5, 0.0f * llllllllllllllIIIIlIIlllIlIllIlI + llllllllllllllIIIIlIIlllIlIlIIII, llllllllllllllIIIIlIIlllIlIllIll * llllllllllllllIIIIlIIlllIlIllIlI / 4.0f + llllllllllllllIIIIlIIlllIlIlIllI * llllllllllllllIIIIlIIlllIlIllIlI + llllllllllllllIIIIlIIlllIlIIllll);
                                llllllllllllllIIIIlIIlllIllIllII.setTranslation(0.0, 0.0, 0.0);
                            }
                        }
                    }
                }
            }
            if (llllllllllllllIIIIlIIlllIllIIllI >= 0) {
                llllllllllllllIIIIlIIlllIllIllIl.draw();
            }
            GlStateManager.enableCull();
            GlStateManager.disableBlend();
            GlStateManager.alphaFunc(516, 0.1f);
            this.func_175072_h();
        }
    }
    
    @Override
    public void onResourceManagerReload(final IResourceManager llllllllllllllIIIIlIlIIlllIlIIIl) {
        if (this.theShaderGroup != null) {
            this.theShaderGroup.deleteShaderGroup();
        }
        this.theShaderGroup = null;
        if (this.shaderIndex != EntityRenderer.shaderCount) {
            this.func_175069_a(EntityRenderer.shaderResourceLocations[this.shaderIndex]);
        }
        else {
            this.func_175066_a(this.mc.func_175606_aa());
        }
    }
    
    private void orientCamera(final float llllllllllllllIIIIlIlIIlIIIlIlIl) {
        final Entity llllllllllllllIIIIlIlIIlIIIlIlII = this.mc.func_175606_aa();
        float llllllllllllllIIIIlIlIIlIIIlIIll = llllllllllllllIIIIlIlIIlIIIlIlII.getEyeHeight();
        double llllllllllllllIIIIlIlIIlIIIlIIlI = llllllllllllllIIIIlIlIIlIIIlIlII.prevPosX + (llllllllllllllIIIIlIlIIlIIIlIlII.posX - llllllllllllllIIIIlIlIIlIIIlIlII.prevPosX) * llllllllllllllIIIIlIlIIlIIIlIlIl;
        double llllllllllllllIIIIlIlIIlIIIlIIIl = llllllllllllllIIIIlIlIIlIIIlIlII.prevPosY + (llllllllllllllIIIIlIlIIlIIIlIlII.posY - llllllllllllllIIIIlIlIIlIIIlIlII.prevPosY) * llllllllllllllIIIIlIlIIlIIIlIlIl + llllllllllllllIIIIlIlIIlIIIlIIll;
        double llllllllllllllIIIIlIlIIlIIIlIIII = llllllllllllllIIIIlIlIIlIIIlIlII.prevPosZ + (llllllllllllllIIIIlIlIIlIIIlIlII.posZ - llllllllllllllIIIIlIlIIlIIIlIlII.prevPosZ) * llllllllllllllIIIIlIlIIlIIIlIlIl;
        if (llllllllllllllIIIIlIlIIlIIIlIlII instanceof EntityLivingBase && ((EntityLivingBase)llllllllllllllIIIIlIlIIlIIIlIlII).isPlayerSleeping()) {
            ++llllllllllllllIIIIlIlIIlIIIlIIll;
            GlStateManager.translate(0.0f, 0.3f, 0.0f);
            if (!this.mc.gameSettings.debugCamEnable) {
                final BlockPos llllllllllllllIIIIlIlIIlIIIIlIll = new BlockPos(llllllllllllllIIIIlIlIIlIIIlIlII);
                final IBlockState llllllllllllllIIIIlIlIIlIIIIlIlI = this.mc.theWorld.getBlockState(llllllllllllllIIIIlIlIIlIIIIlIll);
                final Block llllllllllllllIIIIlIlIIlIIIIlIIl = llllllllllllllIIIIlIlIIlIIIIlIlI.getBlock();
                if (Reflector.ForgeHooksClient_orientBedCamera.exists()) {
                    Reflector.callVoid(Reflector.ForgeHooksClient_orientBedCamera, this.mc.theWorld, llllllllllllllIIIIlIlIIlIIIIlIll, llllllllllllllIIIIlIlIIlIIIIlIlI, llllllllllllllIIIIlIlIIlIIIlIlII);
                }
                else if (llllllllllllllIIIIlIlIIlIIIIlIIl == Blocks.bed) {
                    final int llllllllllllllIIIIlIlIIlIIIIlIII = ((EnumFacing)llllllllllllllIIIIlIlIIlIIIIlIlI.getValue(BlockBed.AGE)).getHorizontalIndex();
                    GlStateManager.rotate((float)(llllllllllllllIIIIlIlIIlIIIIlIII * 90), 0.0f, 1.0f, 0.0f);
                }
                GlStateManager.rotate(llllllllllllllIIIIlIlIIlIIIlIlII.prevRotationYaw + (llllllllllllllIIIIlIlIIlIIIlIlII.rotationYaw - llllllllllllllIIIIlIlIIlIIIlIlII.prevRotationYaw) * llllllllllllllIIIIlIlIIlIIIlIlIl + 180.0f, 0.0f, -1.0f, 0.0f);
                GlStateManager.rotate(llllllllllllllIIIIlIlIIlIIIlIlII.prevRotationPitch + (llllllllllllllIIIIlIlIIlIIIlIlII.rotationPitch - llllllllllllllIIIIlIlIIlIIIlIlII.prevRotationPitch) * llllllllllllllIIIIlIlIIlIIIlIlIl, -1.0f, 0.0f, 0.0f);
            }
        }
        else if (this.mc.gameSettings.thirdPersonView > 0) {
            double llllllllllllllIIIIlIlIIlIIIIIlll = this.thirdPersonDistanceTemp + (this.thirdPersonDistance - this.thirdPersonDistanceTemp) * llllllllllllllIIIIlIlIIlIIIlIlIl;
            if (this.mc.gameSettings.debugCamEnable) {
                GlStateManager.translate(0.0f, 0.0f, (float)(-llllllllllllllIIIIlIlIIlIIIIIlll));
            }
            else {
                final float llllllllllllllIIIIlIlIIlIIIIllll = llllllllllllllIIIIlIlIIlIIIlIlII.rotationYaw;
                float llllllllllllllIIIIlIlIIlIIIIllIl = llllllllllllllIIIIlIlIIlIIIlIlII.rotationPitch;
                if (this.mc.gameSettings.thirdPersonView == 2) {
                    llllllllllllllIIIIlIlIIlIIIIllIl += 180.0f;
                }
                final double llllllllllllllIIIIlIlIIlIIIIIllI = -MathHelper.sin(llllllllllllllIIIIlIlIIlIIIIllll / 180.0f * 3.1415927f) * MathHelper.cos(llllllllllllllIIIIlIlIIlIIIIllIl / 180.0f * 3.1415927f) * llllllllllllllIIIIlIlIIlIIIIIlll;
                final double llllllllllllllIIIIlIlIIlIIIIIlIl = MathHelper.cos(llllllllllllllIIIIlIlIIlIIIIllll / 180.0f * 3.1415927f) * MathHelper.cos(llllllllllllllIIIIlIlIIlIIIIllIl / 180.0f * 3.1415927f) * llllllllllllllIIIIlIlIIlIIIIIlll;
                final double llllllllllllllIIIIlIlIIlIIIIIlII = -MathHelper.sin(llllllllllllllIIIIlIlIIlIIIIllIl / 180.0f * 3.1415927f) * llllllllllllllIIIIlIlIIlIIIIIlll;
                for (int llllllllllllllIIIIlIlIIlIIIIIIll = 0; llllllllllllllIIIIlIlIIlIIIIIIll < 8; ++llllllllllllllIIIIlIlIIlIIIIIIll) {
                    float llllllllllllllIIIIlIlIIlIIIIIIlI = (float)((llllllllllllllIIIIlIlIIlIIIIIIll & 0x1) * 2 - 1);
                    float llllllllllllllIIIIlIlIIlIIIIIIIl = (float)((llllllllllllllIIIIlIlIIlIIIIIIll >> 1 & 0x1) * 2 - 1);
                    float llllllllllllllIIIIlIlIIlIIIIIIII = (float)((llllllllllllllIIIIlIlIIlIIIIIIll >> 2 & 0x1) * 2 - 1);
                    llllllllllllllIIIIlIlIIlIIIIIIlI *= 0.1f;
                    llllllllllllllIIIIlIlIIlIIIIIIIl *= 0.1f;
                    llllllllllllllIIIIlIlIIlIIIIIIII *= 0.1f;
                    final MovingObjectPosition llllllllllllllIIIIlIlIIIllllllll = this.mc.theWorld.rayTraceBlocks(new Vec3(llllllllllllllIIIIlIlIIlIIIlIIlI + llllllllllllllIIIIlIlIIlIIIIIIlI, llllllllllllllIIIIlIlIIlIIIlIIIl + llllllllllllllIIIIlIlIIlIIIIIIIl, llllllllllllllIIIIlIlIIlIIIlIIII + llllllllllllllIIIIlIlIIlIIIIIIII), new Vec3(llllllllllllllIIIIlIlIIlIIIlIIlI - llllllllllllllIIIIlIlIIlIIIIIllI + llllllllllllllIIIIlIlIIlIIIIIIlI + llllllllllllllIIIIlIlIIlIIIIIIII, llllllllllllllIIIIlIlIIlIIIlIIIl - llllllllllllllIIIIlIlIIlIIIIIlII + llllllllllllllIIIIlIlIIlIIIIIIIl, llllllllllllllIIIIlIlIIlIIIlIIII - llllllllllllllIIIIlIlIIlIIIIIlIl + llllllllllllllIIIIlIlIIlIIIIIIII));
                    if (llllllllllllllIIIIlIlIIIllllllll != null) {
                        final double llllllllllllllIIIIlIlIIIlllllllI = llllllllllllllIIIIlIlIIIllllllll.hitVec.distanceTo(new Vec3(llllllllllllllIIIIlIlIIlIIIlIIlI, llllllllllllllIIIIlIlIIlIIIlIIIl, llllllllllllllIIIIlIlIIlIIIlIIII));
                        if (llllllllllllllIIIIlIlIIIlllllllI < llllllllllllllIIIIlIlIIlIIIIIlll) {
                            llllllllllllllIIIIlIlIIlIIIIIlll = llllllllllllllIIIIlIlIIIlllllllI;
                        }
                    }
                }
                if (this.mc.gameSettings.thirdPersonView == 2) {
                    GlStateManager.rotate(180.0f, 0.0f, 1.0f, 0.0f);
                }
                GlStateManager.rotate(llllllllllllllIIIIlIlIIlIIIlIlII.rotationPitch - llllllllllllllIIIIlIlIIlIIIIllIl, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(llllllllllllllIIIIlIlIIlIIIlIlII.rotationYaw - llllllllllllllIIIIlIlIIlIIIIllll, 0.0f, 1.0f, 0.0f);
                GlStateManager.translate(0.0f, 0.0f, (float)(-llllllllllllllIIIIlIlIIlIIIIIlll));
                GlStateManager.rotate(llllllllllllllIIIIlIlIIlIIIIllll - llllllllllllllIIIIlIlIIlIIIlIlII.rotationYaw, 0.0f, 1.0f, 0.0f);
                GlStateManager.rotate(llllllllllllllIIIIlIlIIlIIIIllIl - llllllllllllllIIIIlIlIIlIIIlIlII.rotationPitch, 1.0f, 0.0f, 0.0f);
            }
        }
        else {
            GlStateManager.translate(0.0f, 0.0f, -0.1f);
        }
        if (Reflector.EntityViewRenderEvent_CameraSetup_Constructor.exists()) {
            if (!this.mc.gameSettings.debugCamEnable) {
                float llllllllllllllIIIIlIlIIlIIIIlllI = llllllllllllllIIIIlIlIIlIIIlIlII.prevRotationYaw + (llllllllllllllIIIIlIlIIlIIIlIlII.rotationYaw - llllllllllllllIIIIlIlIIlIIIlIlII.prevRotationYaw) * llllllllllllllIIIIlIlIIlIIIlIlIl + 180.0f;
                float llllllllllllllIIIIlIlIIlIIIIllII = llllllllllllllIIIIlIlIIlIIIlIlII.prevRotationPitch + (llllllllllllllIIIIlIlIIlIIIlIlII.rotationPitch - llllllllllllllIIIIlIlIIlIIIlIlII.prevRotationPitch) * llllllllllllllIIIIlIlIIlIIIlIlIl;
                float llllllllllllllIIIIlIlIIIllllllIl = 0.0f;
                if (llllllllllllllIIIIlIlIIlIIIlIlII instanceof EntityAnimal) {
                    final EntityAnimal llllllllllllllIIIIlIlIIIllllllII = (EntityAnimal)llllllllllllllIIIIlIlIIlIIIlIlII;
                    llllllllllllllIIIIlIlIIlIIIIlllI = llllllllllllllIIIIlIlIIIllllllII.prevRotationYawHead + (llllllllllllllIIIIlIlIIIllllllII.rotationYawHead - llllllllllllllIIIIlIlIIIllllllII.prevRotationYawHead) * llllllllllllllIIIIlIlIIlIIIlIlIl + 180.0f;
                }
                final Block llllllllllllllIIIIlIlIIIlllllIll = ActiveRenderInfo.func_180786_a(this.mc.theWorld, llllllllllllllIIIIlIlIIlIIIlIlII, llllllllllllllIIIIlIlIIlIIIlIlIl);
                final Object llllllllllllllIIIIlIlIIIlllllIlI = Reflector.newInstance(Reflector.EntityViewRenderEvent_CameraSetup_Constructor, this, llllllllllllllIIIIlIlIIlIIIlIlII, llllllllllllllIIIIlIlIIIlllllIll, llllllllllllllIIIIlIlIIlIIIlIlIl, llllllllllllllIIIIlIlIIlIIIIlllI, llllllllllllllIIIIlIlIIlIIIIllII, llllllllllllllIIIIlIlIIIllllllIl);
                Reflector.postForgeBusEvent(llllllllllllllIIIIlIlIIIlllllIlI);
                llllllllllllllIIIIlIlIIIllllllIl = Reflector.getFieldValueFloat(llllllllllllllIIIIlIlIIIlllllIlI, Reflector.EntityViewRenderEvent_CameraSetup_roll, llllllllllllllIIIIlIlIIIllllllIl);
                llllllllllllllIIIIlIlIIlIIIIllII = Reflector.getFieldValueFloat(llllllllllllllIIIIlIlIIIlllllIlI, Reflector.EntityViewRenderEvent_CameraSetup_pitch, llllllllllllllIIIIlIlIIlIIIIllII);
                llllllllllllllIIIIlIlIIlIIIIlllI = Reflector.getFieldValueFloat(llllllllllllllIIIIlIlIIIlllllIlI, Reflector.EntityViewRenderEvent_CameraSetup_yaw, llllllllllllllIIIIlIlIIlIIIIlllI);
                GlStateManager.rotate(llllllllllllllIIIIlIlIIIllllllIl, 0.0f, 0.0f, 1.0f);
                GlStateManager.rotate(llllllllllllllIIIIlIlIIlIIIIllII, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(llllllllllllllIIIIlIlIIlIIIIlllI, 0.0f, 1.0f, 0.0f);
            }
        }
        else if (!this.mc.gameSettings.debugCamEnable) {
            GlStateManager.rotate(llllllllllllllIIIIlIlIIlIIIlIlII.prevRotationPitch + (llllllllllllllIIIIlIlIIlIIIlIlII.rotationPitch - llllllllllllllIIIIlIlIIlIIIlIlII.prevRotationPitch) * llllllllllllllIIIIlIlIIlIIIlIlIl, 1.0f, 0.0f, 0.0f);
            if (llllllllllllllIIIIlIlIIlIIIlIlII instanceof EntityAnimal) {
                final EntityAnimal llllllllllllllIIIIlIlIIIlllllIIl = (EntityAnimal)llllllllllllllIIIIlIlIIlIIIlIlII;
                GlStateManager.rotate(llllllllllllllIIIIlIlIIIlllllIIl.prevRotationYawHead + (llllllllllllllIIIIlIlIIIlllllIIl.rotationYawHead - llllllllllllllIIIIlIlIIIlllllIIl.prevRotationYawHead) * llllllllllllllIIIIlIlIIlIIIlIlIl + 180.0f, 0.0f, 1.0f, 0.0f);
            }
            else {
                GlStateManager.rotate(llllllllllllllIIIIlIlIIlIIIlIlII.prevRotationYaw + (llllllllllllllIIIIlIlIIlIIIlIlII.rotationYaw - llllllllllllllIIIIlIlIIlIIIlIlII.prevRotationYaw) * llllllllllllllIIIIlIlIIlIIIlIlIl + 180.0f, 0.0f, 1.0f, 0.0f);
            }
        }
        GlStateManager.translate(0.0f, -llllllllllllllIIIIlIlIIlIIIlIIll, 0.0f);
        llllllllllllllIIIIlIlIIlIIIlIIlI = llllllllllllllIIIIlIlIIlIIIlIlII.prevPosX + (llllllllllllllIIIIlIlIIlIIIlIlII.posX - llllllllllllllIIIIlIlIIlIIIlIlII.prevPosX) * llllllllllllllIIIIlIlIIlIIIlIlIl;
        llllllllllllllIIIIlIlIIlIIIlIIIl = llllllllllllllIIIIlIlIIlIIIlIlII.prevPosY + (llllllllllllllIIIIlIlIIlIIIlIlII.posY - llllllllllllllIIIIlIlIIlIIIlIlII.prevPosY) * llllllllllllllIIIIlIlIIlIIIlIlIl + llllllllllllllIIIIlIlIIlIIIlIIll;
        llllllllllllllIIIIlIlIIlIIIlIIII = llllllllllllllIIIIlIlIIlIIIlIlII.prevPosZ + (llllllllllllllIIIIlIlIIlIIIlIlII.posZ - llllllllllllllIIIIlIlIIlIIIlIlII.prevPosZ) * llllllllllllllIIIIlIlIIlIIIlIlIl;
        this.cloudFog = this.mc.renderGlobal.hasCloudFog(llllllllllllllIIIIlIlIIlIIIlIIlI, llllllllllllllIIIIlIlIIlIIIlIIIl, llllllllllllllIIIIlIlIIlIIIlIIII, llllllllllllllIIIIlIlIIlIIIlIlIl);
    }
    
    private void func_180437_a(final RenderGlobal llllllllllllllIIIIlIIlllllIllIlI, final float llllllllllllllIIIIlIIlllllIlIlIl, final int llllllllllllllIIIIlIIlllllIllIII) {
        if (this.mc.gameSettings.renderDistanceChunks >= 4 && !Config.isCloudsOff() && Shaders.shouldRenderClouds(this.mc.gameSettings)) {
            this.mc.mcProfiler.endStartSection("clouds");
            GlStateManager.matrixMode(5889);
            GlStateManager.loadIdentity();
            Project.gluPerspective(this.getFOVModifier(llllllllllllllIIIIlIIlllllIlIlIl, true), this.mc.displayWidth / (float)this.mc.displayHeight, 0.05f, this.clipDistance * 4.0f);
            GlStateManager.matrixMode(5888);
            GlStateManager.pushMatrix();
            this.setupFog(0, llllllllllllllIIIIlIIlllllIlIlIl);
            llllllllllllllIIIIlIIlllllIllIlI.func_180447_b(llllllllllllllIIIIlIIlllllIlIlIl, llllllllllllllIIIIlIIlllllIllIII);
            GlStateManager.disableFog();
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5889);
            GlStateManager.loadIdentity();
            Project.gluPerspective(this.getFOVModifier(llllllllllllllIIIIlIIlllllIlIlIl, true), this.mc.displayWidth / (float)this.mc.displayHeight, 0.05f, this.clipDistance);
            GlStateManager.matrixMode(5888);
        }
    }
    
    private void setupFog(final int llllllllllllllIIIIlIIllIllIIlIIl, final float llllllllllllllIIIIlIIllIlIlllllI) {
        final Entity llllllllllllllIIIIlIIllIllIIIlll = this.mc.func_175606_aa();
        boolean llllllllllllllIIIIlIIllIllIIIllI = false;
        this.fogStandard = false;
        if (llllllllllllllIIIIlIIllIllIIIlll instanceof EntityPlayer) {
            llllllllllllllIIIIlIIllIllIIIllI = ((EntityPlayer)llllllllllllllIIIIlIIllIllIIIlll).capabilities.isCreativeMode;
        }
        GL11.glFog(2918, this.setFogColorBuffer(this.field_175080_Q, this.field_175082_R, this.field_175081_S, 1.0f));
        GL11.glNormal3f(0.0f, -1.0f, 0.0f);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        final Block llllllllllllllIIIIlIIllIllIIIlIl = ActiveRenderInfo.func_180786_a(this.mc.theWorld, llllllllllllllIIIIlIIllIllIIIlll, llllllllllllllIIIIlIIllIlIlllllI);
        float llllllllllllllIIIIlIIllIllIIIlII = -1.0f;
        if (Reflector.ForgeHooksClient_getFogDensity.exists()) {
            llllllllllllllIIIIlIIllIllIIIlII = Reflector.callFloat(Reflector.ForgeHooksClient_getFogDensity, this, llllllllllllllIIIIlIIllIllIIIlll, llllllllllllllIIIIlIIllIllIIIlIl, llllllllllllllIIIIlIIllIlIlllllI, 0.1f);
        }
        if (llllllllllllllIIIIlIIllIllIIIlII >= 0.0f) {
            GlStateManager.setFogDensity(llllllllllllllIIIIlIIllIllIIIlII);
        }
        else if (llllllllllllllIIIIlIIllIllIIIlll instanceof EntityLivingBase && ((EntityLivingBase)llllllllllllllIIIIlIIllIllIIIlll).isPotionActive(Potion.blindness)) {
            float llllllllllllllIIIIlIIllIllIIIIll = 5.0f;
            final int llllllllllllllIIIIlIIllIllIIIIIl = ((EntityLivingBase)llllllllllllllIIIIlIIllIllIIIlll).getActivePotionEffect(Potion.blindness).getDuration();
            if (llllllllllllllIIIIlIIllIllIIIIIl < 20) {
                llllllllllllllIIIIlIIllIllIIIIll = 5.0f + (this.farPlaneDistance - 5.0f) * (1.0f - llllllllllllllIIIIlIIllIllIIIIIl / 20.0f);
            }
            if (Config.isShaders()) {
                Shaders.setFog(9729);
            }
            else {
                GlStateManager.setFog(9729);
            }
            if (llllllllllllllIIIIlIIllIllIIlIIl == -1) {
                GlStateManager.setFogStart(0.0f);
                GlStateManager.setFogEnd(llllllllllllllIIIIlIIllIllIIIIll * 0.8f);
            }
            else {
                GlStateManager.setFogStart(llllllllllllllIIIIlIIllIllIIIIll * 0.25f);
                GlStateManager.setFogEnd(llllllllllllllIIIIlIIllIllIIIIll);
            }
            if (GLContext.getCapabilities().GL_NV_fog_distance && Config.isFogFancy()) {
                GL11.glFogi(34138, 34139);
            }
        }
        else if (this.cloudFog) {
            if (Config.isShaders()) {
                Shaders.setFog(2048);
            }
            else {
                GlStateManager.setFog(2048);
            }
            GlStateManager.setFogDensity(0.1f);
        }
        else if (llllllllllllllIIIIlIIllIllIIIlIl.getMaterial() == Material.water) {
            if (Config.isShaders()) {
                Shaders.setFog(2048);
            }
            else {
                GlStateManager.setFog(2048);
            }
            if (llllllllllllllIIIIlIIllIllIIIlll instanceof EntityLivingBase && ((EntityLivingBase)llllllllllllllIIIIlIIllIllIIIlll).isPotionActive(Potion.waterBreathing)) {
                GlStateManager.setFogDensity(0.01f);
            }
            else {
                GlStateManager.setFogDensity(0.1f - EnchantmentHelper.func_180319_a(llllllllllllllIIIIlIIllIllIIIlll) * 0.03f);
            }
            if (Config.isClearWater()) {
                GlStateManager.setFogDensity(0.02f);
            }
        }
        else if (llllllllllllllIIIIlIIllIllIIIlIl.getMaterial() == Material.lava) {
            if (Config.isShaders()) {
                Shaders.setFog(2048);
            }
            else {
                GlStateManager.setFog(2048);
            }
            GlStateManager.setFogDensity(2.0f);
        }
        else {
            final float llllllllllllllIIIIlIIllIllIIIIlI = this.farPlaneDistance;
            this.fogStandard = true;
            if (Config.isShaders()) {
                Shaders.setFog(9729);
            }
            else {
                GlStateManager.setFog(9729);
            }
            if (llllllllllllllIIIIlIIllIllIIlIIl == -1) {
                GlStateManager.setFogStart(0.0f);
                GlStateManager.setFogEnd(llllllllllllllIIIIlIIllIllIIIIlI);
            }
            else {
                GlStateManager.setFogStart(llllllllllllllIIIIlIIllIllIIIIlI * Config.getFogStart());
                GlStateManager.setFogEnd(llllllllllllllIIIIlIIllIllIIIIlI);
            }
            if (GLContext.getCapabilities().GL_NV_fog_distance) {
                if (Config.isFogFancy()) {
                    GL11.glFogi(34138, 34139);
                }
                if (Config.isFogFast()) {
                    GL11.glFogi(34138, 34140);
                }
            }
            if (this.mc.theWorld.provider.doesXZShowFog((int)llllllllllllllIIIIlIIllIllIIIlll.posX, (int)llllllllllllllIIIIlIIllIllIIIlll.posZ)) {
                GlStateManager.setFogStart(llllllllllllllIIIIlIIllIllIIIIlI * 0.05f);
                GlStateManager.setFogEnd(llllllllllllllIIIIlIIllIllIIIIlI);
            }
            if (Reflector.ForgeHooksClient_onFogRender.exists()) {
                Reflector.callVoid(Reflector.ForgeHooksClient_onFogRender, this, llllllllllllllIIIIlIIllIllIIIlll, llllllllllllllIIIIlIIllIllIIIlIl, llllllllllllllIIIIlIIllIlIlllllI, llllllllllllllIIIIlIIllIllIIlIIl, llllllllllllllIIIIlIIllIllIIIIlI);
            }
        }
        GlStateManager.enableColorMaterial();
        GlStateManager.enableFog();
        GlStateManager.colorMaterial(1028, 4608);
    }
    
    private void setupViewBobbing(final float llllllllllllllIIIIlIlIIlIIllIIIl) {
        if (this.mc.func_175606_aa() instanceof EntityPlayer) {
            final EntityPlayer llllllllllllllIIIIlIlIIlIIllIlll = (EntityPlayer)this.mc.func_175606_aa();
            final float llllllllllllllIIIIlIlIIlIIllIllI = llllllllllllllIIIIlIlIIlIIllIlll.distanceWalkedModified - llllllllllllllIIIIlIlIIlIIllIlll.prevDistanceWalkedModified;
            final float llllllllllllllIIIIlIlIIlIIllIlIl = -(llllllllllllllIIIIlIlIIlIIllIlll.distanceWalkedModified + llllllllllllllIIIIlIlIIlIIllIllI * llllllllllllllIIIIlIlIIlIIllIIIl);
            final float llllllllllllllIIIIlIlIIlIIllIlII = llllllllllllllIIIIlIlIIlIIllIlll.prevCameraYaw + (llllllllllllllIIIIlIlIIlIIllIlll.cameraYaw - llllllllllllllIIIIlIlIIlIIllIlll.prevCameraYaw) * llllllllllllllIIIIlIlIIlIIllIIIl;
            final float llllllllllllllIIIIlIlIIlIIllIIll = llllllllllllllIIIIlIlIIlIIllIlll.prevCameraPitch + (llllllllllllllIIIIlIlIIlIIllIlll.cameraPitch - llllllllllllllIIIIlIlIIlIIllIlll.prevCameraPitch) * llllllllllllllIIIIlIlIIlIIllIIIl;
            GlStateManager.translate(MathHelper.sin(llllllllllllllIIIIlIlIIlIIllIlIl * 3.1415927f) * llllllllllllllIIIIlIlIIlIIllIlII * 0.5f, -Math.abs(MathHelper.cos(llllllllllllllIIIIlIlIIlIIllIlIl * 3.1415927f) * llllllllllllllIIIIlIlIIlIIllIlII), 0.0f);
            GlStateManager.rotate(MathHelper.sin(llllllllllllllIIIIlIlIIlIIllIlIl * 3.1415927f) * llllllllllllllIIIIlIlIIlIIllIlII * 3.0f, 0.0f, 0.0f, 1.0f);
            GlStateManager.rotate(Math.abs(MathHelper.cos(llllllllllllllIIIIlIlIIlIIllIlIl * 3.1415927f - 0.2f) * llllllllllllllIIIIlIlIIlIIllIlII) * 5.0f, 1.0f, 0.0f, 0.0f);
            GlStateManager.rotate(llllllllllllllIIIIlIlIIlIIllIIll, 1.0f, 0.0f, 0.0f);
        }
    }
    
    private void func_175068_a(final int llllllllllllllIIIIlIIllllllIlllI, final float llllllllllllllIIIIlIIllllllIllIl, final long llllllllllllllIIIIlIIllllllIllII) {
        final boolean llllllllllllllIIIIlIIlllllllllII = Config.isShaders();
        if (llllllllllllllIIIIlIIlllllllllII) {
            Shaders.beginRenderPass(llllllllllllllIIIIlIIllllllIlllI, llllllllllllllIIIIlIIllllllIllIl, llllllllllllllIIIIlIIllllllIllII);
        }
        final RenderGlobal llllllllllllllIIIIlIIllllllllIll = this.mc.renderGlobal;
        final EffectRenderer llllllllllllllIIIIlIIllllllllIlI = this.mc.effectRenderer;
        final boolean llllllllllllllIIIIlIIllllllllIIl = this.func_175070_n();
        GlStateManager.enableCull();
        this.mc.mcProfiler.endStartSection("clear");
        if (llllllllllllllIIIIlIIlllllllllII) {
            Shaders.setViewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
        }
        else {
            GlStateManager.viewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
        }
        this.updateFogColor(llllllllllllllIIIIlIIllllllIllIl);
        GlStateManager.clear(16640);
        if (llllllllllllllIIIIlIIlllllllllII) {
            Shaders.clearRenderBuffer();
        }
        this.mc.mcProfiler.endStartSection("camera");
        this.setupCameraTransform(llllllllllllllIIIIlIIllllllIllIl, llllllllllllllIIIIlIIllllllIlllI);
        if (llllllllllllllIIIIlIIlllllllllII) {
            Shaders.setCamera(llllllllllllllIIIIlIIllllllIllIl);
        }
        ActiveRenderInfo.updateRenderInfo(this.mc.thePlayer, this.mc.gameSettings.thirdPersonView == 2);
        this.mc.mcProfiler.endStartSection("frustum");
        ClippingHelperImpl.getInstance();
        this.mc.mcProfiler.endStartSection("culling");
        final Frustrum llllllllllllllIIIIlIIllllllllIII = new Frustrum();
        final Entity llllllllllllllIIIIlIIlllllllIlll = this.mc.func_175606_aa();
        final double llllllllllllllIIIIlIIlllllllIllI = llllllllllllllIIIIlIIlllllllIlll.lastTickPosX + (llllllllllllllIIIIlIIlllllllIlll.posX - llllllllllllllIIIIlIIlllllllIlll.lastTickPosX) * llllllllllllllIIIIlIIllllllIllIl;
        final double llllllllllllllIIIIlIIlllllllIlIl = llllllllllllllIIIIlIIlllllllIlll.lastTickPosY + (llllllllllllllIIIIlIIlllllllIlll.posY - llllllllllllllIIIIlIIlllllllIlll.lastTickPosY) * llllllllllllllIIIIlIIllllllIllIl;
        final double llllllllllllllIIIIlIIlllllllIlII = llllllllllllllIIIIlIIlllllllIlll.lastTickPosZ + (llllllllllllllIIIIlIIlllllllIlll.posZ - llllllllllllllIIIIlIIlllllllIlll.lastTickPosZ) * llllllllllllllIIIIlIIllllllIllIl;
        if (llllllllllllllIIIIlIIlllllllllII) {
            ShadersRender.setFrustrumPosition(llllllllllllllIIIIlIIllllllllIII, llllllllllllllIIIIlIIlllllllIllI, llllllllllllllIIIIlIIlllllllIlIl, llllllllllllllIIIIlIIlllllllIlII);
        }
        else {
            llllllllllllllIIIIlIIllllllllIII.setPosition(llllllllllllllIIIIlIIlllllllIllI, llllllllllllllIIIIlIIlllllllIlIl, llllllllllllllIIIIlIIlllllllIlII);
        }
        if ((Config.isSkyEnabled() || Config.isSunMoonEnabled() || Config.isStarsEnabled()) && !Shaders.isShadowPass) {
            this.setupFog(-1, llllllllllllllIIIIlIIllllllIllIl);
            this.mc.mcProfiler.endStartSection("sky");
            GlStateManager.matrixMode(5889);
            GlStateManager.loadIdentity();
            Project.gluPerspective(this.getFOVModifier(llllllllllllllIIIIlIIllllllIllIl, true), this.mc.displayWidth / (float)this.mc.displayHeight, 0.05f, this.clipDistance);
            GlStateManager.matrixMode(5888);
            if (llllllllllllllIIIIlIIlllllllllII) {
                Shaders.beginSky();
            }
            llllllllllllllIIIIlIIllllllllIll.func_174976_a(llllllllllllllIIIIlIIllllllIllIl, llllllllllllllIIIIlIIllllllIlllI);
            if (llllllllllllllIIIIlIIlllllllllII) {
                Shaders.endSky();
            }
            GlStateManager.matrixMode(5889);
            GlStateManager.loadIdentity();
            Project.gluPerspective(this.getFOVModifier(llllllllllllllIIIIlIIllllllIllIl, true), this.mc.displayWidth / (float)this.mc.displayHeight, 0.05f, this.clipDistance);
            GlStateManager.matrixMode(5888);
        }
        else {
            GlStateManager.disableBlend();
        }
        this.setupFog(0, llllllllllllllIIIIlIIllllllIllIl);
        GlStateManager.shadeModel(7425);
        if (llllllllllllllIIIIlIIlllllllIlll.posY + llllllllllllllIIIIlIIlllllllIlll.getEyeHeight() < 128.0 + this.mc.gameSettings.ofCloudsHeight * 128.0f) {
            this.func_180437_a(llllllllllllllIIIIlIIllllllllIll, llllllllllllllIIIIlIIllllllIllIl, llllllllllllllIIIIlIIllllllIlllI);
        }
        this.mc.mcProfiler.endStartSection("prepareterrain");
        this.setupFog(0, llllllllllllllIIIIlIIllllllIllIl);
        this.mc.getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
        RenderHelper.disableStandardItemLighting();
        this.mc.mcProfiler.endStartSection("terrain_setup");
        if (llllllllllllllIIIIlIIlllllllllII) {
            ShadersRender.setupTerrain(llllllllllllllIIIIlIIllllllllIll, llllllllllllllIIIIlIIlllllllIlll, llllllllllllllIIIIlIIllllllIllIl, llllllllllllllIIIIlIIllllllllIII, this.field_175084_ae++, this.mc.thePlayer.func_175149_v());
        }
        else {
            llllllllllllllIIIIlIIllllllllIll.func_174970_a(llllllllllllllIIIIlIIlllllllIlll, llllllllllllllIIIIlIIllllllIllIl, llllllllllllllIIIIlIIllllllllIII, this.field_175084_ae++, this.mc.thePlayer.func_175149_v());
        }
        if (llllllllllllllIIIIlIIllllllIlllI == 0 || llllllllllllllIIIIlIIllllllIlllI == 2) {
            this.mc.mcProfiler.endStartSection("updatechunks");
            Lagometer.timerChunkUpload.start();
            if (llllllllllllllIIIIlIIlllllllllII) {
                ShadersRender.updateChunks(llllllllllllllIIIIlIIllllllllIll, llllllllllllllIIIIlIIllllllIllII);
            }
            else {
                this.mc.renderGlobal.func_174967_a(llllllllllllllIIIIlIIllllllIllII);
            }
            Lagometer.timerChunkUpload.end();
        }
        this.mc.mcProfiler.endStartSection("terrain");
        Lagometer.timerTerrain.start();
        if (this.mc.gameSettings.ofSmoothFps && llllllllllllllIIIIlIIllllllIlllI > 0) {
            this.mc.mcProfiler.endStartSection("finish");
            GL11.glFinish();
            this.mc.mcProfiler.endStartSection("terrain");
        }
        GlStateManager.matrixMode(5888);
        GlStateManager.pushMatrix();
        GlStateManager.disableAlpha();
        if (llllllllllllllIIIIlIIlllllllllII) {
            ShadersRender.beginTerrainSolid();
        }
        llllllllllllllIIIIlIIllllllllIll.func_174977_a(EnumWorldBlockLayer.SOLID, llllllllllllllIIIIlIIllllllIllIl, llllllllllllllIIIIlIIllllllIlllI, llllllllllllllIIIIlIIlllllllIlll);
        GlStateManager.enableAlpha();
        if (llllllllllllllIIIIlIIlllllllllII) {
            ShadersRender.beginTerrainCutoutMipped();
        }
        llllllllllllllIIIIlIIllllllllIll.func_174977_a(EnumWorldBlockLayer.CUTOUT_MIPPED, llllllllllllllIIIIlIIllllllIllIl, llllllllllllllIIIIlIIllllllIlllI, llllllllllllllIIIIlIIlllllllIlll);
        this.mc.getTextureManager().getTexture(TextureMap.locationBlocksTexture).func_174936_b(false, false);
        if (llllllllllllllIIIIlIIlllllllllII) {
            ShadersRender.beginTerrainCutout();
        }
        llllllllllllllIIIIlIIllllllllIll.func_174977_a(EnumWorldBlockLayer.CUTOUT, llllllllllllllIIIIlIIllllllIllIl, llllllllllllllIIIIlIIllllllIlllI, llllllllllllllIIIIlIIlllllllIlll);
        this.mc.getTextureManager().getTexture(TextureMap.locationBlocksTexture).func_174935_a();
        if (llllllllllllllIIIIlIIlllllllllII) {
            ShadersRender.endTerrain();
        }
        Lagometer.timerTerrain.end();
        GlStateManager.shadeModel(7424);
        GlStateManager.alphaFunc(516, 0.1f);
        if (!this.field_175078_W) {
            GlStateManager.matrixMode(5888);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            RenderHelper.enableStandardItemLighting();
            this.mc.mcProfiler.endStartSection("entities");
            if (Reflector.ForgeHooksClient_setRenderPass.exists()) {
                Reflector.callVoid(Reflector.ForgeHooksClient_setRenderPass, 0);
            }
            llllllllllllllIIIIlIIllllllllIll.func_180446_a(llllllllllllllIIIIlIIlllllllIlll, llllllllllllllIIIIlIIllllllllIII, llllllllllllllIIIIlIIllllllIllIl);
            if (Reflector.ForgeHooksClient_setRenderPass.exists()) {
                Reflector.callVoid(Reflector.ForgeHooksClient_setRenderPass, -1);
            }
            RenderHelper.disableStandardItemLighting();
            this.func_175072_h();
            GlStateManager.matrixMode(5888);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            if (this.mc.objectMouseOver != null && llllllllllllllIIIIlIIlllllllIlll.isInsideOfMaterial(Material.water) && llllllllllllllIIIIlIIllllllllIIl) {
                final EntityPlayer llllllllllllllIIIIlIIlllllllIIll = (EntityPlayer)llllllllllllllIIIIlIIlllllllIlll;
                GlStateManager.disableAlpha();
                this.mc.mcProfiler.endStartSection("outline");
                if ((!Reflector.ForgeHooksClient_onDrawBlockHighlight.exists() || !Reflector.callBoolean(Reflector.ForgeHooksClient_onDrawBlockHighlight, llllllllllllllIIIIlIIllllllllIll, llllllllllllllIIIIlIIlllllllIIll, this.mc.objectMouseOver, 0, llllllllllllllIIIIlIIlllllllIIll.getHeldItem(), llllllllllllllIIIIlIIllllllIllIl)) && !this.mc.gameSettings.hideGUI) {
                    llllllllllllllIIIIlIIllllllllIll.drawSelectionBox(llllllllllllllIIIIlIIlllllllIIll, this.mc.objectMouseOver, 0, llllllllllllllIIIIlIIllllllIllIl);
                }
                GlStateManager.enableAlpha();
            }
        }
        GlStateManager.matrixMode(5888);
        GlStateManager.popMatrix();
        if (llllllllllllllIIIIlIIllllllllIIl && this.mc.objectMouseOver != null && !llllllllllllllIIIIlIIlllllllIlll.isInsideOfMaterial(Material.water)) {
            final EntityPlayer llllllllllllllIIIIlIIlllllllIIlI = (EntityPlayer)llllllllllllllIIIIlIIlllllllIlll;
            GlStateManager.disableAlpha();
            this.mc.mcProfiler.endStartSection("outline");
            if ((!Reflector.ForgeHooksClient_onDrawBlockHighlight.exists() || !Reflector.callBoolean(Reflector.ForgeHooksClient_onDrawBlockHighlight, llllllllllllllIIIIlIIllllllllIll, llllllllllllllIIIIlIIlllllllIIlI, this.mc.objectMouseOver, 0, llllllllllllllIIIIlIIlllllllIIlI.getHeldItem(), llllllllllllllIIIIlIIllllllIllIl)) && !this.mc.gameSettings.hideGUI) {
                llllllllllllllIIIIlIIllllllllIll.drawSelectionBox(llllllllllllllIIIIlIIlllllllIIlI, this.mc.objectMouseOver, 0, llllllllllllllIIIIlIIllllllIllIl);
            }
            GlStateManager.enableAlpha();
        }
        if (!llllllllllllllIIIIlIIllllllllIll.damagedBlocks.isEmpty()) {
            this.mc.mcProfiler.endStartSection("destroyProgress");
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 1, 1, 0);
            llllllllllllllIIIIlIIllllllllIll.func_174981_a(Tessellator.getInstance(), Tessellator.getInstance().getWorldRenderer(), llllllllllllllIIIIlIIlllllllIlll, llllllllllllllIIIIlIIllllllIllIl);
            GlStateManager.disableBlend();
        }
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.disableBlend();
        if (!this.field_175078_W) {
            this.func_180436_i();
            this.mc.mcProfiler.endStartSection("litParticles");
            if (llllllllllllllIIIIlIIlllllllllII) {
                Shaders.beginLitParticles();
            }
            llllllllllllllIIIIlIIllllllllIlI.renderLitParticles(llllllllllllllIIIIlIIlllllllIlll, llllllllllllllIIIIlIIllllllIllIl);
            RenderHelper.disableStandardItemLighting();
            this.setupFog(0, llllllllllllllIIIIlIIllllllIllIl);
            this.mc.mcProfiler.endStartSection("particles");
            if (llllllllllllllIIIIlIIlllllllllII) {
                Shaders.beginParticles();
            }
            llllllllllllllIIIIlIIllllllllIlI.renderParticles(llllllllllllllIIIIlIIlllllllIlll, llllllllllllllIIIIlIIllllllIllIl);
            if (llllllllllllllIIIIlIIlllllllllII) {
                Shaders.endParticles();
            }
            this.func_175072_h();
        }
        GlStateManager.depthMask(false);
        GlStateManager.enableCull();
        this.mc.mcProfiler.endStartSection("weather");
        if (llllllllllllllIIIIlIIlllllllllII) {
            Shaders.beginWeather();
        }
        this.renderRainSnow(llllllllllllllIIIIlIIllllllIllIl);
        if (llllllllllllllIIIIlIIlllllllllII) {
            Shaders.endWeather();
        }
        GlStateManager.depthMask(true);
        llllllllllllllIIIIlIIllllllllIll.func_180449_a(llllllllllllllIIIIlIIlllllllIlll, llllllllllllllIIIIlIIllllllIllIl);
        if (llllllllllllllIIIIlIIlllllllllII) {
            ShadersRender.renderHand0(this, llllllllllllllIIIIlIIllllllIllIl, llllllllllllllIIIIlIIllllllIlllI);
            Shaders.preWater();
        }
        GlStateManager.disableBlend();
        GlStateManager.enableCull();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.alphaFunc(516, 0.1f);
        this.setupFog(0, llllllllllllllIIIIlIIllllllIllIl);
        GlStateManager.enableBlend();
        GlStateManager.depthMask(false);
        this.mc.getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
        GlStateManager.shadeModel(7425);
        if (Config.isTranslucentBlocksFancy()) {
            this.mc.mcProfiler.endStartSection("translucent");
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            if (llllllllllllllIIIIlIIlllllllllII) {
                Shaders.beginWater();
            }
            llllllllllllllIIIIlIIllllllllIll.func_174977_a(EnumWorldBlockLayer.TRANSLUCENT, llllllllllllllIIIIlIIllllllIllIl, llllllllllllllIIIIlIIllllllIlllI, llllllllllllllIIIIlIIlllllllIlll);
            if (llllllllllllllIIIIlIIlllllllllII) {
                Shaders.endWater();
            }
            GlStateManager.disableBlend();
        }
        else {
            this.mc.mcProfiler.endStartSection("translucent");
            if (llllllllllllllIIIIlIIlllllllllII) {
                Shaders.beginWater();
            }
            llllllllllllllIIIIlIIllllllllIll.func_174977_a(EnumWorldBlockLayer.TRANSLUCENT, llllllllllllllIIIIlIIllllllIllIl, llllllllllllllIIIIlIIllllllIlllI, llllllllllllllIIIIlIIlllllllIlll);
            if (llllllllllllllIIIIlIIlllllllllII) {
                Shaders.endWater();
            }
        }
        if (Reflector.ForgeHooksClient_setRenderPass.exists() && !this.field_175078_W) {
            RenderHelper.enableStandardItemLighting();
            this.mc.mcProfiler.endStartSection("entities");
            Reflector.callVoid(Reflector.ForgeHooksClient_setRenderPass, 1);
            this.mc.renderGlobal.func_180446_a(llllllllllllllIIIIlIIlllllllIlll, llllllllllllllIIIIlIIllllllllIII, llllllllllllllIIIIlIIllllllIllIl);
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            Reflector.callVoid(Reflector.ForgeHooksClient_setRenderPass, -1);
            RenderHelper.disableStandardItemLighting();
        }
        GlStateManager.shadeModel(7424);
        GlStateManager.depthMask(true);
        GlStateManager.enableCull();
        GlStateManager.disableBlend();
        GlStateManager.disableFog();
        if (llllllllllllllIIIIlIIlllllllIlll.posY + llllllllllllllIIIIlIIlllllllIlll.getEyeHeight() >= 128.0 + this.mc.gameSettings.ofCloudsHeight * 128.0f) {
            this.mc.mcProfiler.endStartSection("aboveClouds");
            this.func_180437_a(llllllllllllllIIIIlIIllllllllIll, llllllllllllllIIIIlIIllllllIllIl, llllllllllllllIIIIlIIllllllIlllI);
        }
        final EventRender3D llllllllllllllIIIIlIIlllllllIIIl = new EventRender3D(llllllllllllllIIIIlIIllllllIllIl);
        Client.onEvent(llllllllllllllIIIIlIIlllllllIIIl);
        if (Reflector.ForgeHooksClient_dispatchRenderLast.exists()) {
            this.mc.mcProfiler.endStartSection("forge_render_last");
            Reflector.callVoid(Reflector.ForgeHooksClient_dispatchRenderLast, llllllllllllllIIIIlIIllllllllIll, llllllllllllllIIIIlIIllllllIllIl);
        }
        this.mc.mcProfiler.endStartSection("hand");
        final boolean llllllllllllllIIIIlIIlllllllIIII = Reflector.callBoolean(Reflector.ForgeHooksClient_renderFirstPersonHand, this.mc.renderGlobal, llllllllllllllIIIIlIIllllllIllIl, llllllllllllllIIIIlIIllllllIlllI);
        if (!llllllllllllllIIIIlIIlllllllIIII && this.field_175074_C && !Shaders.isShadowPass) {
            if (llllllllllllllIIIIlIIlllllllllII) {
                ShadersRender.renderHand1(this, llllllllllllllIIIIlIIllllllIllIl, llllllllllllllIIIIlIIllllllIlllI);
                Shaders.renderCompositeFinal();
            }
            GlStateManager.clear(256);
            if (llllllllllllllIIIIlIIlllllllllII) {
                ShadersRender.renderFPOverlay(this, llllllllllllllIIIIlIIllllllIllIl, llllllllllllllIIIIlIIllllllIlllI);
            }
            else {
                this.renderHand(llllllllllllllIIIIlIIllllllIllIl, llllllllllllllIIIIlIIllllllIlllI);
            }
            this.func_175067_i(llllllllllllllIIIIlIIllllllIllIl);
        }
        if (llllllllllllllIIIIlIIlllllllllII) {
            Shaders.endRender();
        }
    }
    
    public void func_152430_c(final float llllllllllllllIIIIlIlIIIIIlllIIl) {
        this.setupOverlayRendering();
        this.mc.ingameGUI.func_180478_c(new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight));
    }
    
    private FloatBuffer setFogColorBuffer(final float llllllllllllllIIIIlIIllIlIllIIIl, final float llllllllllllllIIIIlIIllIlIllIIII, final float llllllllllllllIIIIlIIllIlIlIlIlI, final float llllllllllllllIIIIlIIllIlIlIlllI) {
        if (Config.isShaders()) {
            Shaders.setFogColor(llllllllllllllIIIIlIIllIlIllIIIl, llllllllllllllIIIIlIIllIlIllIIII, llllllllllllllIIIIlIIllIlIlIlIlI);
        }
        this.fogColorBuffer.clear();
        this.fogColorBuffer.put(llllllllllllllIIIIlIIllIlIllIIIl).put(llllllllllllllIIIIlIIllIlIllIIII).put(llllllllllllllIIIIlIIllIlIlIlIlI).put(llllllllllllllIIIIlIIllIlIlIlllI);
        this.fogColorBuffer.flip();
        return this.fogColorBuffer;
    }
    
    private float getFOVModifier(final float llllllllllllllIIIIlIlIIlIlIlllll, final boolean llllllllllllllIIIIlIlIIlIlIlIlIl) {
        if (this.field_175078_W) {
            return 90.0f;
        }
        final Entity llllllllllllllIIIIlIlIIlIlIlllIl = this.mc.func_175606_aa();
        float llllllllllllllIIIIlIlIIlIlIlllII = 70.0f;
        if (llllllllllllllIIIIlIlIIlIlIlIlIl) {
            llllllllllllllIIIIlIlIIlIlIlllII = this.mc.gameSettings.fovSetting;
            if (Config.isDynamicFov()) {
                llllllllllllllIIIIlIlIIlIlIlllII *= this.fovModifierHandPrev + (this.fovModifierHand - this.fovModifierHandPrev) * llllllllllllllIIIIlIlIIlIlIlllll;
            }
        }
        boolean llllllllllllllIIIIlIlIIlIlIllIll = false;
        if (this.mc.currentScreen == null) {
            final GameSettings llllllllllllllIIIIlIlIIlIlIllIlI = this.mc.gameSettings;
            llllllllllllllIIIIlIlIIlIlIllIll = GameSettings.isKeyDown(this.mc.gameSettings.ofKeyBindZoom);
        }
        if (llllllllllllllIIIIlIlIIlIlIllIll) {
            if (!Config.zoomMode) {
                Config.zoomMode = true;
                this.mc.gameSettings.smoothCamera = true;
            }
            if (Config.zoomMode) {
                llllllllllllllIIIIlIlIIlIlIlllII /= 4.0f;
            }
        }
        else if (Config.zoomMode) {
            Config.zoomMode = false;
            this.mc.gameSettings.smoothCamera = false;
            this.mouseFilterXAxis = new MouseFilter();
            this.mouseFilterYAxis = new MouseFilter();
            this.mc.renderGlobal.displayListEntitiesDirty = true;
        }
        if (llllllllllllllIIIIlIlIIlIlIlllIl instanceof EntityLivingBase && ((EntityLivingBase)llllllllllllllIIIIlIlIIlIlIlllIl).getHealth() <= 0.0f) {
            final float llllllllllllllIIIIlIlIIlIlIllIIl = ((EntityLivingBase)llllllllllllllIIIIlIlIIlIlIlllIl).deathTime + llllllllllllllIIIIlIlIIlIlIlllll;
            llllllllllllllIIIIlIlIIlIlIlllII /= (1.0f - 500.0f / (llllllllllllllIIIIlIlIIlIlIllIIl + 500.0f)) * 2.0f + 1.0f;
        }
        final Block llllllllllllllIIIIlIlIIlIlIllIII = ActiveRenderInfo.func_180786_a(this.mc.theWorld, llllllllllllllIIIIlIlIIlIlIlllIl, llllllllllllllIIIIlIlIIlIlIlllll);
        if (llllllllllllllIIIIlIlIIlIlIllIII.getMaterial() == Material.water) {
            llllllllllllllIIIIlIlIIlIlIlllII = llllllllllllllIIIIlIlIIlIlIlllII * 60.0f / 70.0f;
        }
        return llllllllllllllIIIIlIlIIlIlIlllII;
    }
    
    public void updateShaderGroupSize(final int llllllllllllllIIIIlIlIIllIlIlIll, final int llllllllllllllIIIIlIlIIllIlIllIl) {
        if (OpenGlHelper.shadersSupported) {
            if (this.theShaderGroup != null) {
                this.theShaderGroup.createBindFramebuffers(llllllllllllllIIIIlIlIIllIlIlIll, llllllllllllllIIIIlIlIIllIlIllIl);
            }
            this.mc.renderGlobal.checkOcclusionQueryResult(llllllllllllllIIIIlIlIIllIlIlIll, llllllllllllllIIIIlIlIIllIlIllIl);
        }
    }
    
    public EntityRenderer(final Minecraft llllllllllllllIIIIlIlIIlllllIllI, final IResourceManager llllllllllllllIIIIlIlIIlllllIlIl) {
        this.random = new Random();
        this.mouseFilterXAxis = new MouseFilter();
        this.mouseFilterYAxis = new MouseFilter();
        this.thirdPersonDistance = 4.0f;
        this.thirdPersonDistanceTemp = 4.0f;
        this.field_175074_C = true;
        this.field_175073_D = true;
        this.prevFrameTime = Minecraft.getSystemTime();
        this.field_175076_N = new float[1024];
        this.field_175077_O = new float[1024];
        this.fogColorBuffer = GLAllocation.createDirectFloatBuffer(16);
        this.field_175079_V = 0;
        this.field_175078_W = false;
        this.cameraZoom = 1.0;
        this.initialized = false;
        this.updatedWorld = null;
        this.showDebugInfo = false;
        this.fogStandard = false;
        this.clipDistance = 128.0f;
        this.lastServerTime = 0L;
        this.lastServerTicks = 0;
        this.serverWaitTime = 0;
        this.serverWaitTimeCurrent = 0;
        this.avgServerTimeDiff = 0.0f;
        this.avgServerTickDiff = 0.0f;
        this.lastErrorCheckTimeMs = 0L;
        this.fxaaShaders = new ShaderGroup[10];
        this.shaderIndex = EntityRenderer.shaderCount;
        this.field_175083_ad = false;
        this.field_175084_ae = 0;
        this.mc = llllllllllllllIIIIlIlIIlllllIllI;
        this.resourceManager = llllllllllllllIIIIlIlIIlllllIlIl;
        this.itemRenderer = llllllllllllllIIIIlIlIIlllllIllI.getItemRenderer();
        this.theMapItemRenderer = new MapItemRenderer(llllllllllllllIIIIlIlIIlllllIllI.getTextureManager());
        this.lightmapTexture = new DynamicTexture(16, 16);
        this.locationLightMap = llllllllllllllIIIIlIlIIlllllIllI.getTextureManager().getDynamicTextureLocation("lightMap", this.lightmapTexture);
        this.lightmapColors = this.lightmapTexture.getTextureData();
        this.theShaderGroup = null;
        for (int llllllllllllllIIIIlIlIIlllllllII = 0; llllllllllllllIIIIlIlIIlllllllII < 32; ++llllllllllllllIIIIlIlIIlllllllII) {
            for (int llllllllllllllIIIIlIlIIllllllIll = 0; llllllllllllllIIIIlIlIIllllllIll < 32; ++llllllllllllllIIIIlIlIIllllllIll) {
                final float llllllllllllllIIIIlIlIIllllllIlI = (float)(llllllllllllllIIIIlIlIIllllllIll - 16);
                final float llllllllllllllIIIIlIlIIllllllIIl = (float)(llllllllllllllIIIIlIlIIlllllllII - 16);
                final float llllllllllllllIIIIlIlIIllllllIII = MathHelper.sqrt_float(llllllllllllllIIIIlIlIIllllllIlI * llllllllllllllIIIIlIlIIllllllIlI + llllllllllllllIIIIlIlIIllllllIIl * llllllllllllllIIIIlIlIIllllllIIl);
                this.field_175076_N[llllllllllllllIIIIlIlIIlllllllII << 5 | llllllllllllllIIIIlIlIIllllllIll] = -llllllllllllllIIIIlIlIIllllllIIl / llllllllllllllIIIIlIlIIllllllIII;
                this.field_175077_O[llllllllllllllIIIIlIlIIlllllllII << 5 | llllllllllllllIIIIlIlIIllllllIll] = llllllllllllllIIIIlIlIIllllllIlI / llllllllllllllIIIIlIlIIllllllIII;
            }
        }
    }
    
    public boolean isShaderActive() {
        return OpenGlHelper.shadersSupported && this.theShaderGroup != null;
    }
    
    private void updateLightmap(final float llllllllllllllIIIIlIlIIIlIIIIlIl) {
        if (this.lightmapUpdateNeeded) {
            this.mc.mcProfiler.startSection("lightTex");
            final WorldClient llllllllllllllIIIIlIlIIIlIIlllIl = this.mc.theWorld;
            if (llllllllllllllIIIIlIlIIIlIIlllIl != null) {
                if (Config.isCustomColors() && CustomColors.updateLightmap(llllllllllllllIIIIlIlIIIlIIlllIl, this.torchFlickerX, this.lightmapColors, this.mc.thePlayer.isPotionActive(Potion.nightVision))) {
                    this.lightmapTexture.updateDynamicTexture();
                    this.lightmapUpdateNeeded = false;
                    this.mc.mcProfiler.endSection();
                    return;
                }
                for (int llllllllllllllIIIIlIlIIIlIIlllII = 0; llllllllllllllIIIIlIlIIIlIIlllII < 256; ++llllllllllllllIIIIlIlIIIlIIlllII) {
                    final float llllllllllllllIIIIlIlIIIlIIllIll = llllllllllllllIIIIlIlIIIlIIlllIl.getSunBrightness(1.0f) * 0.95f + 0.05f;
                    float llllllllllllllIIIIlIlIIIlIIllIlI = llllllllllllllIIIIlIlIIIlIIlllIl.provider.getLightBrightnessTable()[llllllllllllllIIIIlIlIIIlIIlllII / 16] * llllllllllllllIIIIlIlIIIlIIllIll;
                    final float llllllllllllllIIIIlIlIIIlIIllIIl = llllllllllllllIIIIlIlIIIlIIlllIl.provider.getLightBrightnessTable()[llllllllllllllIIIIlIlIIIlIIlllII % 16] * (this.torchFlickerX * 0.1f + 1.5f);
                    if (llllllllllllllIIIIlIlIIIlIIlllIl.func_175658_ac() > 0) {
                        llllllllllllllIIIIlIlIIIlIIllIlI = llllllllllllllIIIIlIlIIIlIIlllIl.provider.getLightBrightnessTable()[llllllllllllllIIIIlIlIIIlIIlllII / 16];
                    }
                    final float llllllllllllllIIIIlIlIIIlIIllIII = llllllllllllllIIIIlIlIIIlIIllIlI * (llllllllllllllIIIIlIlIIIlIIlllIl.getSunBrightness(1.0f) * 0.65f + 0.35f);
                    final float llllllllllllllIIIIlIlIIIlIIlIlll = llllllllllllllIIIIlIlIIIlIIllIlI * (llllllllllllllIIIIlIlIIIlIIlllIl.getSunBrightness(1.0f) * 0.65f + 0.35f);
                    final float llllllllllllllIIIIlIlIIIlIIlIllI = llllllllllllllIIIIlIlIIIlIIllIIl * ((llllllllllllllIIIIlIlIIIlIIllIIl * 0.6f + 0.4f) * 0.6f + 0.4f);
                    final float llllllllllllllIIIIlIlIIIlIIlIlIl = llllllllllllllIIIIlIlIIIlIIllIIl * (llllllllllllllIIIIlIlIIIlIIllIIl * llllllllllllllIIIIlIlIIIlIIllIIl * 0.6f + 0.4f);
                    float llllllllllllllIIIIlIlIIIlIIlIlII = llllllllllllllIIIIlIlIIIlIIllIII + llllllllllllllIIIIlIlIIIlIIllIIl;
                    float llllllllllllllIIIIlIlIIIlIIlIIll = llllllllllllllIIIIlIlIIIlIIlIlll + llllllllllllllIIIIlIlIIIlIIlIllI;
                    float llllllllllllllIIIIlIlIIIlIIlIIlI = llllllllllllllIIIIlIlIIIlIIllIlI + llllllllllllllIIIIlIlIIIlIIlIlIl;
                    llllllllllllllIIIIlIlIIIlIIlIlII = llllllllllllllIIIIlIlIIIlIIlIlII * 0.96f + 0.03f;
                    llllllllllllllIIIIlIlIIIlIIlIIll = llllllllllllllIIIIlIlIIIlIIlIIll * 0.96f + 0.03f;
                    llllllllllllllIIIIlIlIIIlIIlIIlI = llllllllllllllIIIIlIlIIIlIIlIIlI * 0.96f + 0.03f;
                    if (this.bossColorModifier > 0.0f) {
                        final float llllllllllllllIIIIlIlIIIlIIlIIIl = this.bossColorModifierPrev + (this.bossColorModifier - this.bossColorModifierPrev) * llllllllllllllIIIIlIlIIIlIIIIlIl;
                        llllllllllllllIIIIlIlIIIlIIlIlII = llllllllllllllIIIIlIlIIIlIIlIlII * (1.0f - llllllllllllllIIIIlIlIIIlIIlIIIl) + llllllllllllllIIIIlIlIIIlIIlIlII * 0.7f * llllllllllllllIIIIlIlIIIlIIlIIIl;
                        llllllllllllllIIIIlIlIIIlIIlIIll = llllllllllllllIIIIlIlIIIlIIlIIll * (1.0f - llllllllllllllIIIIlIlIIIlIIlIIIl) + llllllllllllllIIIIlIlIIIlIIlIIll * 0.6f * llllllllllllllIIIIlIlIIIlIIlIIIl;
                        llllllllllllllIIIIlIlIIIlIIlIIlI = llllllllllllllIIIIlIlIIIlIIlIIlI * (1.0f - llllllllllllllIIIIlIlIIIlIIlIIIl) + llllllllllllllIIIIlIlIIIlIIlIIlI * 0.6f * llllllllllllllIIIIlIlIIIlIIlIIIl;
                    }
                    if (llllllllllllllIIIIlIlIIIlIIlllIl.provider.getDimensionId() == 1) {
                        llllllllllllllIIIIlIlIIIlIIlIlII = 0.22f + llllllllllllllIIIIlIlIIIlIIllIIl * 0.75f;
                        llllllllllllllIIIIlIlIIIlIIlIIll = 0.28f + llllllllllllllIIIIlIlIIIlIIlIllI * 0.75f;
                        llllllllllllllIIIIlIlIIIlIIlIIlI = 0.25f + llllllllllllllIIIIlIlIIIlIIlIlIl * 0.75f;
                    }
                    if (this.mc.thePlayer.isPotionActive(Potion.nightVision)) {
                        final float llllllllllllllIIIIlIlIIIlIIlIIII = this.func_180438_a(this.mc.thePlayer, llllllllllllllIIIIlIlIIIlIIIIlIl);
                        float llllllllllllllIIIIlIlIIIlIIIlllI = 1.0f / llllllllllllllIIIIlIlIIIlIIlIlII;
                        if (llllllllllllllIIIIlIlIIIlIIIlllI > 1.0f / llllllllllllllIIIIlIlIIIlIIlIIll) {
                            llllllllllllllIIIIlIlIIIlIIIlllI = 1.0f / llllllllllllllIIIIlIlIIIlIIlIIll;
                        }
                        if (llllllllllllllIIIIlIlIIIlIIIlllI > 1.0f / llllllllllllllIIIIlIlIIIlIIlIIlI) {
                            llllllllllllllIIIIlIlIIIlIIIlllI = 1.0f / llllllllllllllIIIIlIlIIIlIIlIIlI;
                        }
                        llllllllllllllIIIIlIlIIIlIIlIlII = llllllllllllllIIIIlIlIIIlIIlIlII * (1.0f - llllllllllllllIIIIlIlIIIlIIlIIII) + llllllllllllllIIIIlIlIIIlIIlIlII * llllllllllllllIIIIlIlIIIlIIIlllI * llllllllllllllIIIIlIlIIIlIIlIIII;
                        llllllllllllllIIIIlIlIIIlIIlIIll = llllllllllllllIIIIlIlIIIlIIlIIll * (1.0f - llllllllllllllIIIIlIlIIIlIIlIIII) + llllllllllllllIIIIlIlIIIlIIlIIll * llllllllllllllIIIIlIlIIIlIIIlllI * llllllllllllllIIIIlIlIIIlIIlIIII;
                        llllllllllllllIIIIlIlIIIlIIlIIlI = llllllllllllllIIIIlIlIIIlIIlIIlI * (1.0f - llllllllllllllIIIIlIlIIIlIIlIIII) + llllllllllllllIIIIlIlIIIlIIlIIlI * llllllllllllllIIIIlIlIIIlIIIlllI * llllllllllllllIIIIlIlIIIlIIlIIII;
                    }
                    if (llllllllllllllIIIIlIlIIIlIIlIlII > 1.0f) {
                        llllllllllllllIIIIlIlIIIlIIlIlII = 1.0f;
                    }
                    if (llllllllllllllIIIIlIlIIIlIIlIIll > 1.0f) {
                        llllllllllllllIIIIlIlIIIlIIlIIll = 1.0f;
                    }
                    if (llllllllllllllIIIIlIlIIIlIIlIIlI > 1.0f) {
                        llllllllllllllIIIIlIlIIIlIIlIIlI = 1.0f;
                    }
                    final float llllllllllllllIIIIlIlIIIlIIIllll = this.mc.gameSettings.gammaSetting;
                    float llllllllllllllIIIIlIlIIIlIIIllIl = 1.0f - llllllllllllllIIIIlIlIIIlIIlIlII;
                    float llllllllllllllIIIIlIlIIIlIIIllII = 1.0f - llllllllllllllIIIIlIlIIIlIIlIIll;
                    float llllllllllllllIIIIlIlIIIlIIIlIll = 1.0f - llllllllllllllIIIIlIlIIIlIIlIIlI;
                    llllllllllllllIIIIlIlIIIlIIIllIl = 1.0f - llllllllllllllIIIIlIlIIIlIIIllIl * llllllllllllllIIIIlIlIIIlIIIllIl * llllllllllllllIIIIlIlIIIlIIIllIl * llllllllllllllIIIIlIlIIIlIIIllIl;
                    llllllllllllllIIIIlIlIIIlIIIllII = 1.0f - llllllllllllllIIIIlIlIIIlIIIllII * llllllllllllllIIIIlIlIIIlIIIllII * llllllllllllllIIIIlIlIIIlIIIllII * llllllllllllllIIIIlIlIIIlIIIllII;
                    llllllllllllllIIIIlIlIIIlIIIlIll = 1.0f - llllllllllllllIIIIlIlIIIlIIIlIll * llllllllllllllIIIIlIlIIIlIIIlIll * llllllllllllllIIIIlIlIIIlIIIlIll * llllllllllllllIIIIlIlIIIlIIIlIll;
                    llllllllllllllIIIIlIlIIIlIIlIlII = llllllllllllllIIIIlIlIIIlIIlIlII * (1.0f - llllllllllllllIIIIlIlIIIlIIIllll) + llllllllllllllIIIIlIlIIIlIIIllIl * llllllllllllllIIIIlIlIIIlIIIllll;
                    llllllllllllllIIIIlIlIIIlIIlIIll = llllllllllllllIIIIlIlIIIlIIlIIll * (1.0f - llllllllllllllIIIIlIlIIIlIIIllll) + llllllllllllllIIIIlIlIIIlIIIllII * llllllllllllllIIIIlIlIIIlIIIllll;
                    llllllllllllllIIIIlIlIIIlIIlIIlI = llllllllllllllIIIIlIlIIIlIIlIIlI * (1.0f - llllllllllllllIIIIlIlIIIlIIIllll) + llllllllllllllIIIIlIlIIIlIIIlIll * llllllllllllllIIIIlIlIIIlIIIllll;
                    llllllllllllllIIIIlIlIIIlIIlIlII = llllllllllllllIIIIlIlIIIlIIlIlII * 0.96f + 0.03f;
                    llllllllllllllIIIIlIlIIIlIIlIIll = llllllllllllllIIIIlIlIIIlIIlIIll * 0.96f + 0.03f;
                    llllllllllllllIIIIlIlIIIlIIlIIlI = llllllllllllllIIIIlIlIIIlIIlIIlI * 0.96f + 0.03f;
                    if (llllllllllllllIIIIlIlIIIlIIlIlII > 1.0f) {
                        llllllllllllllIIIIlIlIIIlIIlIlII = 1.0f;
                    }
                    if (llllllllllllllIIIIlIlIIIlIIlIIll > 1.0f) {
                        llllllllllllllIIIIlIlIIIlIIlIIll = 1.0f;
                    }
                    if (llllllllllllllIIIIlIlIIIlIIlIIlI > 1.0f) {
                        llllllllllllllIIIIlIlIIIlIIlIIlI = 1.0f;
                    }
                    if (llllllllllllllIIIIlIlIIIlIIlIlII < 0.0f) {
                        llllllllllllllIIIIlIlIIIlIIlIlII = 0.0f;
                    }
                    if (llllllllllllllIIIIlIlIIIlIIlIIll < 0.0f) {
                        llllllllllllllIIIIlIlIIIlIIlIIll = 0.0f;
                    }
                    if (llllllllllllllIIIIlIlIIIlIIlIIlI < 0.0f) {
                        llllllllllllllIIIIlIlIIIlIIlIIlI = 0.0f;
                    }
                    final short llllllllllllllIIIIlIlIIIlIIIlIlI = 255;
                    final int llllllllllllllIIIIlIlIIIlIIIlIIl = (int)(llllllllllllllIIIIlIlIIIlIIlIlII * 255.0f);
                    final int llllllllllllllIIIIlIlIIIlIIIlIII = (int)(llllllllllllllIIIIlIlIIIlIIlIIll * 255.0f);
                    final int llllllllllllllIIIIlIlIIIlIIIIlll = (int)(llllllllllllllIIIIlIlIIIlIIlIIlI * 255.0f);
                    this.lightmapColors[llllllllllllllIIIIlIlIIIlIIlllII] = (llllllllllllllIIIIlIlIIIlIIIlIlI << 24 | llllllllllllllIIIIlIlIIIlIIIlIIl << 16 | llllllllllllllIIIIlIlIIIlIIIlIII << 8 | llllllllllllllIIIIlIlIIIlIIIIlll);
                }
                this.lightmapTexture.updateDynamicTexture();
                this.lightmapUpdateNeeded = false;
                this.mc.mcProfiler.endSection();
            }
        }
    }
    
    public MapItemRenderer getMapItemRenderer() {
        return this.theMapItemRenderer;
    }
    
    private void updateFogColor(final float llllllllllllllIIIIlIIllIlllIIlll) {
        final WorldClient llllllllllllllIIIIlIIlllIIIIlIII = this.mc.theWorld;
        final Entity llllllllllllllIIIIlIIlllIIIIIlll = this.mc.func_175606_aa();
        float llllllllllllllIIIIlIIlllIIIIIllI = 0.25f + 0.75f * this.mc.gameSettings.renderDistanceChunks / 32.0f;
        llllllllllllllIIIIlIIlllIIIIIllI = 1.0f - (float)Math.pow(llllllllllllllIIIIlIIlllIIIIIllI, 0.25);
        Vec3 llllllllllllllIIIIlIIlllIIIIIlIl = llllllllllllllIIIIlIIlllIIIIlIII.getSkyColor(this.mc.func_175606_aa(), llllllllllllllIIIIlIIllIlllIIlll);
        llllllllllllllIIIIlIIlllIIIIIlIl = CustomColors.getWorldSkyColor(llllllllllllllIIIIlIIlllIIIIIlIl, llllllllllllllIIIIlIIlllIIIIlIII, this.mc.func_175606_aa(), llllllllllllllIIIIlIIllIlllIIlll);
        final float llllllllllllllIIIIlIIlllIIIIIlII = (float)llllllllllllllIIIIlIIlllIIIIIlIl.xCoord;
        final float llllllllllllllIIIIlIIlllIIIIIIll = (float)llllllllllllllIIIIlIIlllIIIIIlIl.yCoord;
        final float llllllllllllllIIIIlIIlllIIIIIIlI = (float)llllllllllllllIIIIlIIlllIIIIIlIl.zCoord;
        Vec3 llllllllllllllIIIIlIIlllIIIIIIIl = llllllllllllllIIIIlIIlllIIIIlIII.getFogColor(llllllllllllllIIIIlIIllIlllIIlll);
        llllllllllllllIIIIlIIlllIIIIIIIl = CustomColors.getWorldFogColor(llllllllllllllIIIIlIIlllIIIIIIIl, llllllllllllllIIIIlIIlllIIIIlIII, this.mc.func_175606_aa(), llllllllllllllIIIIlIIllIlllIIlll);
        this.field_175080_Q = (float)llllllllllllllIIIIlIIlllIIIIIIIl.xCoord;
        this.field_175082_R = (float)llllllllllllllIIIIlIIlllIIIIIIIl.yCoord;
        this.field_175081_S = (float)llllllllllllllIIIIlIIlllIIIIIIIl.zCoord;
        if (this.mc.gameSettings.renderDistanceChunks >= 4) {
            final double llllllllllllllIIIIlIIllIllllllIl = -1.0;
            final Vec3 llllllllllllllIIIIlIIllIllllllII = (MathHelper.sin(llllllllllllllIIIIlIIlllIIIIlIII.getCelestialAngleRadians(llllllllllllllIIIIlIIllIlllIIlll)) > 0.0f) ? new Vec3(llllllllllllllIIIIlIIllIllllllIl, 0.0, 0.0) : new Vec3(1.0, 0.0, 0.0);
            float llllllllllllllIIIIlIIlllIIIIIIII = (float)llllllllllllllIIIIlIIlllIIIIIlll.getLook(llllllllllllllIIIIlIIllIlllIIlll).dotProduct(llllllllllllllIIIIlIIllIllllllII);
            if (llllllllllllllIIIIlIIlllIIIIIIII < 0.0f) {
                llllllllllllllIIIIlIIlllIIIIIIII = 0.0f;
            }
            if (llllllllllllllIIIIlIIlllIIIIIIII > 0.0f) {
                final float[] llllllllllllllIIIIlIIllIlllllIll = llllllllllllllIIIIlIIlllIIIIlIII.provider.calcSunriseSunsetColors(llllllllllllllIIIIlIIlllIIIIlIII.getCelestialAngle(llllllllllllllIIIIlIIllIlllIIlll), llllllllllllllIIIIlIIllIlllIIlll);
                if (llllllllllllllIIIIlIIllIlllllIll != null) {
                    llllllllllllllIIIIlIIlllIIIIIIII *= llllllllllllllIIIIlIIllIlllllIll[3];
                    this.field_175080_Q = this.field_175080_Q * (1.0f - llllllllllllllIIIIlIIlllIIIIIIII) + llllllllllllllIIIIlIIllIlllllIll[0] * llllllllllllllIIIIlIIlllIIIIIIII;
                    this.field_175082_R = this.field_175082_R * (1.0f - llllllllllllllIIIIlIIlllIIIIIIII) + llllllllllllllIIIIlIIllIlllllIll[1] * llllllllllllllIIIIlIIlllIIIIIIII;
                    this.field_175081_S = this.field_175081_S * (1.0f - llllllllllllllIIIIlIIlllIIIIIIII) + llllllllllllllIIIIlIIllIlllllIll[2] * llllllllllllllIIIIlIIlllIIIIIIII;
                }
            }
        }
        this.field_175080_Q += (llllllllllllllIIIIlIIlllIIIIIlII - this.field_175080_Q) * llllllllllllllIIIIlIIlllIIIIIllI;
        this.field_175082_R += (llllllllllllllIIIIlIIlllIIIIIIll - this.field_175082_R) * llllllllllllllIIIIlIIlllIIIIIllI;
        this.field_175081_S += (llllllllllllllIIIIlIIlllIIIIIIlI - this.field_175081_S) * llllllllllllllIIIIlIIlllIIIIIllI;
        final float llllllllllllllIIIIlIIllIlllllIlI = llllllllllllllIIIIlIIlllIIIIlIII.getRainStrength(llllllllllllllIIIIlIIllIlllIIlll);
        if (llllllllllllllIIIIlIIllIlllllIlI > 0.0f) {
            final float llllllllllllllIIIIlIIllIlllllIIl = 1.0f - llllllllllllllIIIIlIIllIlllllIlI * 0.5f;
            final float llllllllllllllIIIIlIIllIllllIlll = 1.0f - llllllllllllllIIIIlIIllIlllllIlI * 0.4f;
            this.field_175080_Q *= llllllllllllllIIIIlIIllIlllllIIl;
            this.field_175082_R *= llllllllllllllIIIIlIIllIlllllIIl;
            this.field_175081_S *= llllllllllllllIIIIlIIllIllllIlll;
        }
        final float llllllllllllllIIIIlIIllIlllllIII = llllllllllllllIIIIlIIlllIIIIlIII.getWeightedThunderStrength(llllllllllllllIIIIlIIllIlllIIlll);
        if (llllllllllllllIIIIlIIllIlllllIII > 0.0f) {
            final float llllllllllllllIIIIlIIllIllllIllI = 1.0f - llllllllllllllIIIIlIIllIlllllIII * 0.5f;
            this.field_175080_Q *= llllllllllllllIIIIlIIllIllllIllI;
            this.field_175082_R *= llllllllllllllIIIIlIIllIllllIllI;
            this.field_175081_S *= llllllllllllllIIIIlIIllIllllIllI;
        }
        final Block llllllllllllllIIIIlIIllIllllIlIl = ActiveRenderInfo.func_180786_a(this.mc.theWorld, llllllllllllllIIIIlIIlllIIIIIlll, llllllllllllllIIIIlIIllIlllIIlll);
        if (this.cloudFog) {
            final Vec3 llllllllllllllIIIIlIIllIllllIlII = llllllllllllllIIIIlIIlllIIIIlIII.getCloudColour(llllllllllllllIIIIlIIllIlllIIlll);
            this.field_175080_Q = (float)llllllllllllllIIIIlIIllIllllIlII.xCoord;
            this.field_175082_R = (float)llllllllllllllIIIIlIIllIllllIlII.yCoord;
            this.field_175081_S = (float)llllllllllllllIIIIlIIllIllllIlII.zCoord;
        }
        else if (llllllllllllllIIIIlIIllIllllIlIl.getMaterial() == Material.water) {
            float llllllllllllllIIIIlIIllIllllllll = EnchantmentHelper.func_180319_a(llllllllllllllIIIIlIIlllIIIIIlll) * 0.2f;
            if (llllllllllllllIIIIlIIlllIIIIIlll instanceof EntityLivingBase && ((EntityLivingBase)llllllllllllllIIIIlIIlllIIIIIlll).isPotionActive(Potion.waterBreathing)) {
                llllllllllllllIIIIlIIllIllllllll = llllllllllllllIIIIlIIllIllllllll * 0.3f + 0.6f;
            }
            this.field_175080_Q = 0.02f + llllllllllllllIIIIlIIllIllllllll;
            this.field_175082_R = 0.02f + llllllllllllllIIIIlIIllIllllllll;
            this.field_175081_S = 0.2f + llllllllllllllIIIIlIIllIllllllll;
            final Vec3 llllllllllllllIIIIlIIllIllllIIll = CustomColors.getUnderwaterColor(this.mc.theWorld, this.mc.func_175606_aa().posX, this.mc.func_175606_aa().posY + 1.0, this.mc.func_175606_aa().posZ);
            if (llllllllllllllIIIIlIIllIllllIIll != null) {
                this.field_175080_Q = (float)llllllllllllllIIIIlIIllIllllIIll.xCoord;
                this.field_175082_R = (float)llllllllllllllIIIIlIIllIllllIIll.yCoord;
                this.field_175081_S = (float)llllllllllllllIIIIlIIllIllllIIll.zCoord;
            }
        }
        else if (llllllllllllllIIIIlIIllIllllIlIl.getMaterial() == Material.lava) {
            this.field_175080_Q = 0.6f;
            this.field_175082_R = 0.1f;
            this.field_175081_S = 0.0f;
        }
        final float llllllllllllllIIIIlIIllIlllllllI = this.fogColor2 + (this.fogColor1 - this.fogColor2) * llllllllllllllIIIIlIIllIlllIIlll;
        this.field_175080_Q *= llllllllllllllIIIIlIIllIlllllllI;
        this.field_175082_R *= llllllllllllllIIIIlIIllIlllllllI;
        this.field_175081_S *= llllllllllllllIIIIlIIllIlllllllI;
        final double llllllllllllllIIIIlIIllIllllIIlI = llllllllllllllIIIIlIIlllIIIIlIII.provider.getVoidFogYFactor();
        double llllllllllllllIIIIlIIllIllllIIIl = (llllllllllllllIIIIlIIlllIIIIIlll.lastTickPosY + (llllllllllllllIIIIlIIlllIIIIIlll.posY - llllllllllllllIIIIlIIlllIIIIIlll.lastTickPosY) * llllllllllllllIIIIlIIllIlllIIlll) * llllllllllllllIIIIlIIllIllllIIlI;
        if (llllllllllllllIIIIlIIlllIIIIIlll instanceof EntityLivingBase && ((EntityLivingBase)llllllllllllllIIIIlIIlllIIIIIlll).isPotionActive(Potion.blindness)) {
            final int llllllllllllllIIIIlIIllIllllIIII = ((EntityLivingBase)llllllllllllllIIIIlIIlllIIIIIlll).getActivePotionEffect(Potion.blindness).getDuration();
            if (llllllllllllllIIIIlIIllIllllIIII < 20) {
                llllllllllllllIIIIlIIllIllllIIIl *= 1.0f - llllllllllllllIIIIlIIllIllllIIII / 20.0f;
            }
            else {
                llllllllllllllIIIIlIIllIllllIIIl = 0.0;
            }
        }
        if (llllllllllllllIIIIlIIllIllllIIIl < 1.0) {
            if (llllllllllllllIIIIlIIllIllllIIIl < 0.0) {
                llllllllllllllIIIIlIIllIllllIIIl = 0.0;
            }
            llllllllllllllIIIIlIIllIllllIIIl *= llllllllllllllIIIIlIIllIllllIIIl;
            this.field_175080_Q *= (float)llllllllllllllIIIIlIIllIllllIIIl;
            this.field_175082_R *= (float)llllllllllllllIIIIlIIllIllllIIIl;
            this.field_175081_S *= (float)llllllllllllllIIIIlIIllIllllIIIl;
        }
        if (this.bossColorModifier > 0.0f) {
            final float llllllllllllllIIIIlIIllIlllIllll = this.bossColorModifierPrev + (this.bossColorModifier - this.bossColorModifierPrev) * llllllllllllllIIIIlIIllIlllIIlll;
            this.field_175080_Q = this.field_175080_Q * (1.0f - llllllllllllllIIIIlIIllIlllIllll) + this.field_175080_Q * 0.7f * llllllllllllllIIIIlIIllIlllIllll;
            this.field_175082_R = this.field_175082_R * (1.0f - llllllllllllllIIIIlIIllIlllIllll) + this.field_175082_R * 0.6f * llllllllllllllIIIIlIIllIlllIllll;
            this.field_175081_S = this.field_175081_S * (1.0f - llllllllllllllIIIIlIIllIlllIllll) + this.field_175081_S * 0.6f * llllllllllllllIIIIlIIllIlllIllll;
        }
        if (llllllllllllllIIIIlIIlllIIIIIlll instanceof EntityLivingBase && ((EntityLivingBase)llllllllllllllIIIIlIIlllIIIIIlll).isPotionActive(Potion.nightVision)) {
            final float llllllllllllllIIIIlIIllIlllIlllI = this.func_180438_a((EntityLivingBase)llllllllllllllIIIIlIIlllIIIIIlll, llllllllllllllIIIIlIIllIlllIIlll);
            float llllllllllllllIIIIlIIllIlllIllII = 1.0f / this.field_175080_Q;
            if (llllllllllllllIIIIlIIllIlllIllII > 1.0f / this.field_175082_R) {
                llllllllllllllIIIIlIIllIlllIllII = 1.0f / this.field_175082_R;
            }
            if (llllllllllllllIIIIlIIllIlllIllII > 1.0f / this.field_175081_S) {
                llllllllllllllIIIIlIIllIlllIllII = 1.0f / this.field_175081_S;
            }
            this.field_175080_Q = this.field_175080_Q * (1.0f - llllllllllllllIIIIlIIllIlllIlllI) + this.field_175080_Q * llllllllllllllIIIIlIIllIlllIllII * llllllllllllllIIIIlIIllIlllIlllI;
            this.field_175082_R = this.field_175082_R * (1.0f - llllllllllllllIIIIlIIllIlllIlllI) + this.field_175082_R * llllllllllllllIIIIlIIllIlllIllII * llllllllllllllIIIIlIIllIlllIlllI;
            this.field_175081_S = this.field_175081_S * (1.0f - llllllllllllllIIIIlIIllIlllIlllI) + this.field_175081_S * llllllllllllllIIIIlIIllIlllIllII * llllllllllllllIIIIlIIllIlllIlllI;
        }
        if (this.mc.gameSettings.anaglyph) {
            final float llllllllllllllIIIIlIIllIlllIllIl = (this.field_175080_Q * 30.0f + this.field_175082_R * 59.0f + this.field_175081_S * 11.0f) / 100.0f;
            final float llllllllllllllIIIIlIIllIlllIlIll = (this.field_175080_Q * 30.0f + this.field_175082_R * 70.0f) / 100.0f;
            final float llllllllllllllIIIIlIIllIlllIlIlI = (this.field_175080_Q * 30.0f + this.field_175081_S * 70.0f) / 100.0f;
            this.field_175080_Q = llllllllllllllIIIIlIIllIlllIllIl;
            this.field_175082_R = llllllllllllllIIIIlIIllIlllIlIll;
            this.field_175081_S = llllllllllllllIIIIlIIllIlllIlIlI;
        }
        if (Reflector.EntityViewRenderEvent_FogColors_Constructor.exists()) {
            final Object llllllllllllllIIIIlIIllIlllIlIIl = Reflector.newInstance(Reflector.EntityViewRenderEvent_FogColors_Constructor, this, llllllllllllllIIIIlIIlllIIIIIlll, llllllllllllllIIIIlIIllIllllIlIl, llllllllllllllIIIIlIIllIlllIIlll, this.field_175080_Q, this.field_175082_R, this.field_175081_S);
            Reflector.postForgeBusEvent(llllllllllllllIIIIlIIllIlllIlIIl);
            this.field_175080_Q = Reflector.getFieldValueFloat(llllllllllllllIIIIlIIllIlllIlIIl, Reflector.EntityViewRenderEvent_FogColors_red, this.field_175080_Q);
            this.field_175082_R = Reflector.getFieldValueFloat(llllllllllllllIIIIlIIllIlllIlIIl, Reflector.EntityViewRenderEvent_FogColors_green, this.field_175082_R);
            this.field_175081_S = Reflector.getFieldValueFloat(llllllllllllllIIIIlIIllIlllIlIIl, Reflector.EntityViewRenderEvent_FogColors_blue, this.field_175081_S);
        }
        Shaders.setClearColor(this.field_175080_Q, this.field_175082_R, this.field_175081_S, 0.0f);
    }
    
    public void func_175071_c() {
        this.field_175083_ad = !this.field_175083_ad;
    }
    
    private void updateMainMenu(final GuiMainMenu llllllllllllllIIIIlIIllIIllIlIIl) {
        try {
            String llllllllllllllIIIIlIIllIIllIlIII = null;
            final Calendar llllllllllllllIIIIlIIllIIllIIlll = Calendar.getInstance();
            llllllllllllllIIIIlIIllIIllIIlll.setTime(new Date());
            final int llllllllllllllIIIIlIIllIIllIIllI = llllllllllllllIIIIlIIllIIllIIlll.get(5);
            final int llllllllllllllIIIIlIIllIIllIIlIl = llllllllllllllIIIIlIIllIIllIIlll.get(2) + 1;
            if (llllllllllllllIIIIlIIllIIllIIllI == 8 && llllllllllllllIIIIlIIllIIllIIlIl == 4) {
                llllllllllllllIIIIlIIllIIllIlIII = "Happy birthday, OptiFine!";
            }
            if (llllllllllllllIIIIlIIllIIllIIllI == 14 && llllllllllllllIIIIlIIllIIllIIlIl == 8) {
                llllllllllllllIIIIlIIllIIllIlIII = "Happy birthday, sp614x!";
            }
            if (llllllllllllllIIIIlIIllIIllIlIII == null) {
                return;
            }
            final Field[] llllllllllllllIIIIlIIllIIllIIlII = GuiMainMenu.class.getDeclaredFields();
            for (int llllllllllllllIIIIlIIllIIllIIIll = 0; llllllllllllllIIIIlIIllIIllIIIll < llllllllllllllIIIIlIIllIIllIIlII.length; ++llllllllllllllIIIIlIIllIIllIIIll) {
                if (llllllllllllllIIIIlIIllIIllIIlII[llllllllllllllIIIIlIIllIIllIIIll].getType() == String.class) {
                    llllllllllllllIIIIlIIllIIllIIlII[llllllllllllllIIIIlIIllIIllIIIll].setAccessible(true);
                    llllllllllllllIIIIlIIllIIllIIlII[llllllllllllllIIIIlIIllIIllIIIll].set(llllllllllllllIIIIlIIllIIllIlIIl, llllllllllllllIIIIlIIllIIllIlIII);
                    break;
                }
            }
        }
        catch (Throwable t) {}
    }
    
    public ShaderGroup getShaderGroup() {
        return this.theShaderGroup;
    }
}
