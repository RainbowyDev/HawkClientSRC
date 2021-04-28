package shadersmod.client;

import java.util.regex.*;
import net.minecraft.client.*;
import java.nio.*;
import net.minecraft.world.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.block.*;
import org.lwjgl.*;
import shadersmod.common.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.block.material.*;
import net.minecraft.util.*;
import org.lwjgl.util.glu.*;
import net.minecraft.tileentity.*;
import java.util.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;
import org.lwjgl.opengl.*;
import java.io.*;
import net.minecraft.client.settings.*;
import optifine.*;

public class Shaders
{
    public static /* synthetic */ boolean isSleeping;
    static /* synthetic */ float skyColorG;
    private static /* synthetic */ int[] programsCompositeMipmapSetting;
    public static /* synthetic */ float aoLevel;
    public static /* synthetic */ boolean configCloudShadow;
    public static /* synthetic */ boolean isRenderingDfb;
    static final /* synthetic */ FloatBuffer tempMatrixDirectBuffer;
    private static /* synthetic */ Map<String, String> shaderPackResources;
    public static /* synthetic */ float shadowAngleInterval;
    public static /* synthetic */ boolean progUseMidTexCoordAttrib;
    public static /* synthetic */ float configRenderResMul;
    static /* synthetic */ int systemTimeInt32;
    public static /* synthetic */ ShaderUniformInt uniformEntityId;
    static final /* synthetic */ FloatBuffer previousProjection;
    public static /* synthetic */ String packNameNone;
    static /* synthetic */ float rainStrength;
    public static /* synthetic */ boolean[] shadowColorFilterNearest;
    static /* synthetic */ int spShadowMapHeight;
    public static /* synthetic */ int configTexMagFilB;
    public static /* synthetic */ float blockAoLight;
    public static /* synthetic */ PropertyDefaultTrueFalse shaderPackDynamicHandLight;
    public static /* synthetic */ boolean configTweakBlockDamage;
    public static /* synthetic */ int terrainIconSize;
    public static /* synthetic */ int[] entityData;
    public static /* synthetic */ float wetnessHalfLife;
    static final /* synthetic */ FloatBuffer tempDirectFloatBuffer;
    static final /* synthetic */ float[] faShadowModelViewInverse;
    public static /* synthetic */ int configTexMinFilB;
    static final /* synthetic */ FloatBuffer shadowProjection;
    static final /* synthetic */ IntBuffer dfbDepthTextures;
    static final /* synthetic */ IntBuffer dfbDrawBuffers;
    static final /* synthetic */ boolean[][] programsToggleColorTextures;
    static /* synthetic */ double previousCameraPositionY;
    static /* synthetic */ ShaderProfile[] shaderPackProfiles;
    static /* synthetic */ int dfb;
    static /* synthetic */ int frameCounter;
    private static /* synthetic */ HFNoiseTexture noiseTexture;
    static final /* synthetic */ FloatBuffer projection;
    static final /* synthetic */ int[] dfbColorTexturesA;
    static /* synthetic */ float sunAngle;
    public static /* synthetic */ boolean[] shadowMipmapEnabled;
    static /* synthetic */ boolean usewetness;
    private static final /* synthetic */ int[] formatIds;
    public static /* synthetic */ float shadowIntervalSize;
    static /* synthetic */ int usedShadowDepthBuffers;
    public static /* synthetic */ boolean isHandRendered;
    public static /* synthetic */ boolean[] shadowFilterNearest;
    public static /* synthetic */ boolean[] shadowColorMipmapEnabled;
    public static /* synthetic */ boolean isShadowPass;
    static /* synthetic */ String shaderpacksdirname;
    private static final /* synthetic */ boolean saveFinalShaders;
    public static /* synthetic */ int renderWidth;
    static /* synthetic */ float centerDepthSmooth;
    static /* synthetic */ float[] moonPosition;
    static /* synthetic */ double previousCameraPositionZ;
    static /* synthetic */ IntBuffer[] programsDrawBuffers;
    public static /* synthetic */ PropertyDefaultTrueFalse shaderPackOldLighting;
    static final /* synthetic */ IntBuffer drawBuffersNone;
    static final /* synthetic */ int[] colorTexturesToggle;
    public static /* synthetic */ boolean useTangentAttrib;
    public static /* synthetic */ int entityDataIndex;
    public static /* synthetic */ boolean isShaderPackInitialized;
    static final /* synthetic */ IntBuffer sfbColorTextures;
    static final /* synthetic */ FloatBuffer modelView;
    static final /* synthetic */ IntBuffer drawBuffersColorAtt0;
    static final /* synthetic */ FloatBuffer modelViewInverse;
    static /* synthetic */ int usedColorAttachs;
    static /* synthetic */ Minecraft mc;
    static /* synthetic */ boolean centerDepthSmoothEnabled;
    static /* synthetic */ float[] upPosModelView;
    static /* synthetic */ float shadowAngle;
    static final /* synthetic */ float[] faShadowProjectionInverse;
    static /* synthetic */ float[] shadowLightPosition;
    public static /* synthetic */ boolean renderItemPass1DepthMask;
    static /* synthetic */ int superSamplingLevel;
    public static /* synthetic */ float fogColorR;
    static final /* synthetic */ float[] faShadowProjection;
    static final /* synthetic */ float[] faShadowModelView;
    public static /* synthetic */ boolean useEntityAttrib;
    public static /* synthetic */ float blockLightLevel05;
    static final /* synthetic */ FloatBuffer shadowModelViewInverse;
    public static /* synthetic */ String glVersionString;
    private static /* synthetic */ int renderDisplayHeight;
    public static /* synthetic */ boolean useMidTexCoordAttrib;
    private static /* synthetic */ String[] programsDrawBufSettings;
    static /* synthetic */ float frameTimeCounter;
    public static /* synthetic */ int configTexMinFilS;
    static /* synthetic */ boolean needResetModels;
    public static /* synthetic */ boolean isRenderingWorld;
    static /* synthetic */ boolean fogEnabled;
    static /* synthetic */ float wetness;
    public static /* synthetic */ float configShadowResMul;
    public static /* synthetic */ boolean shouldSkipDefaultShadow;
    static /* synthetic */ int shadowPassInterval;
    static final /* synthetic */ IntBuffer[] drawBuffersBuffer;
    static /* synthetic */ String packNameDefault;
    public static /* synthetic */ boolean configNormalMap;
    public static /* synthetic */ int fogMode;
    public static /* synthetic */ float fogColorB;
    static /* synthetic */ float[] upPosition;
    static /* synthetic */ String optionsfilename;
    public static /* synthetic */ PropertyDefaultTrueFalse configOldLighting;
    static final /* synthetic */ IntBuffer sfbDrawBuffers;
    public static /* synthetic */ float blockLightLevel08;
    public static /* synthetic */ boolean hasForge;
    private static /* synthetic */ String newColorAtmSetting;
    public static /* synthetic */ boolean shaderPackLoaded;
    public static /* synthetic */ int[] terrainTextureSize;
    private static /* synthetic */ float[] tempMat;
    static /* synthetic */ float eyePosY;
    private static final /* synthetic */ int[] programBackups;
    private static final /* synthetic */ ByteBuffer bigBuffer;
    private static /* synthetic */ int noiseTextureResolution;
    static /* synthetic */ File configFile;
    static /* synthetic */ int usedDrawBuffers;
    static final /* synthetic */ FloatBuffer previousModelView;
    static /* synthetic */ File shaderpacksdir;
    private static final /* synthetic */ String[] programNames;
    public static /* synthetic */ Properties shadersConfig;
    static /* synthetic */ float shadowMapFOV;
    public static /* synthetic */ float fogColorG;
    private static /* synthetic */ String newDrawBufSetting;
    public static /* synthetic */ boolean useMultiTexCoord3Attrib;
    static final /* synthetic */ FloatBuffer projectionInverse;
    static /* synthetic */ ShaderOption[] shaderPackOptions;
    public static /* synthetic */ int midTexCoordAttrib;
    public static /* synthetic */ float sunPathRotation;
    private static /* synthetic */ int programIDCopyDepth;
    public static /* synthetic */ PropertyDefaultFastFancyOff shaderPackClouds;
    static /* synthetic */ float[] moonPosModelView;
    static /* synthetic */ float centerDepth;
    static final /* synthetic */ FloatBuffer shadowProjectionInverse;
    public static /* synthetic */ boolean normalMapEnabled;
    static /* synthetic */ float eyeBrightnessFadeX;
    public static /* synthetic */ String glVendorString;
    static /* synthetic */ float clearColorR;
    static /* synthetic */ EntityRenderer entityRenderer;
    static /* synthetic */ long diffWorldTime;
    static /* synthetic */ float clearColorB;
    static final /* synthetic */ FloatBuffer shadowModelView;
    public static /* synthetic */ boolean progUseTangentAttrib;
    public static /* synthetic */ int configTexMagFilS;
    static /* synthetic */ double cameraPositionZ;
    static /* synthetic */ Map<String, ShaderOption[]> shaderPackGuiScreens;
    static /* synthetic */ double previousCameraPositionX;
    public static /* synthetic */ boolean isRenderingSky;
    static /* synthetic */ int[] programsID;
    static /* synthetic */ float eyeBrightnessFadeY;
    static /* synthetic */ int usedDepthBuffers;
    static /* synthetic */ int shadowPassCounter;
    static /* synthetic */ int shadowMapHeight;
    static /* synthetic */ int usedShadowColorBuffers;
    static /* synthetic */ long worldTime;
    public static /* synthetic */ int atlasSizeY;
    static final /* synthetic */ float[] faModelView;
    static /* synthetic */ int sfb;
    static /* synthetic */ IShaderPack shaderPack;
    public static /* synthetic */ int entityAttrib;
    private static /* synthetic */ String[] programsColorAtmSettings;
    public static /* synthetic */ boolean configShadowClipFrustrum;
    public static /* synthetic */ int configTexMagFilN;
    static /* synthetic */ boolean waterShadowEnabled;
    public static /* synthetic */ int activeProgram;
    static /* synthetic */ int usedColorBuffers;
    private static final /* synthetic */ String[] formatNames;
    private static /* synthetic */ World currentWorld;
    public static /* synthetic */ float configHandDepthMul;
    static /* synthetic */ float skyColorB;
    static /* synthetic */ long diffSystemTime;
    public static /* synthetic */ ITextureObject defaultTexture;
    static /* synthetic */ long lastSystemTime;
    static /* synthetic */ float celestialAngle;
    private static /* synthetic */ boolean noiseTextureEnabled;
    public static /* synthetic */ boolean progUseEntityAttrib;
    public static /* synthetic */ float eyeBrightnessHalflife;
    static /* synthetic */ int shadowMapWidth;
    private static /* synthetic */ int newCompositeMipmapSetting;
    public static /* synthetic */ ShaderUniformFloat4 uniformEntityColor;
    static final /* synthetic */ float[] faProjection;
    public static /* synthetic */ int atlasSizeX;
    static /* synthetic */ double cameraPositionX;
    public static /* synthetic */ boolean configSpecularMap;
    static final /* synthetic */ float[] faProjectionInverse;
    private static /* synthetic */ int[] gbuffersFormat;
    private static /* synthetic */ int[] programsRef;
    static /* synthetic */ double cameraPositionY;
    static /* synthetic */ float skyColorR;
    static /* synthetic */ IntBuffer activeDrawBuffers;
    static /* synthetic */ long systemTime;
    static /* synthetic */ float shadowMapHalfPlane;
    static /* synthetic */ File shadersdir;
    static /* synthetic */ float[] shadowLightPositionVector;
    static final /* synthetic */ int[] colorTextureTextureImageUnit;
    static /* synthetic */ int spShadowMapWidth;
    public static /* synthetic */ int configAntialiasingLevel;
    static /* synthetic */ float[] sunPosition;
    public static /* synthetic */ ContextCapabilities capabilities;
    public static /* synthetic */ int renderHeight;
    static /* synthetic */ boolean shadowMapIsOrtho;
    static /* synthetic */ boolean lightmapEnabled;
    public static /* synthetic */ boolean needResizeShadow;
    static /* synthetic */ float centerDepthSmoothHalflife;
    static /* synthetic */ float[] sunPosModelView;
    static /* synthetic */ int moonPhase;
    private static /* synthetic */ int renderDisplayWidth;
    public static /* synthetic */ boolean hasGlGenMipmap;
    public static /* synthetic */ int tangentAttrib;
    private static /* synthetic */ List<Integer> shaderPackDimensions;
    static /* synthetic */ String currentshadername;
    public static /* synthetic */ int configTexMinFilN;
    public static /* synthetic */ boolean isInitializedOnce;
    static final /* synthetic */ float[] faModelViewInverse;
    static /* synthetic */ int isEyeInWater;
    public static /* synthetic */ boolean[] shadowHardwareFilteringEnabled;
    public static /* synthetic */ String glRendererString;
    public static /* synthetic */ ShaderUniformInt uniformBlockEntityId;
    static /* synthetic */ boolean updateChunksErrorRecorded;
    public static /* synthetic */ float blockLightLevel06;
    private static /* synthetic */ int activeCompositeMipmapSetting;
    public static /* synthetic */ int numberResetDisplayList;
    public static /* synthetic */ float drynessHalfLife;
    static final /* synthetic */ IntBuffer sfbDepthTextures;
    static /* synthetic */ float clearColorG;
    public static /* synthetic */ boolean isCompositeRendered;
    static /* synthetic */ long lastWorldTime;
    static final /* synthetic */ IntBuffer dfbColorTextures;
    public static /* synthetic */ Properties loadedShaders;
    static /* synthetic */ int eyeBrightness;
    private static /* synthetic */ String activeColorAtmSettings;
    
    private static void loadShaderPackProperties() {
        Shaders.shaderPackClouds.resetValue();
        Shaders.shaderPackDynamicHandLight.resetValue();
        Shaders.shaderPackOldLighting.resetValue();
        if (Shaders.shaderPack != null) {
            final String llllllllllllllllllIllIllIlIIIIll = "/shaders/shaders.properties";
            try {
                final InputStream llllllllllllllllllIllIllIlIIIIlI = Shaders.shaderPack.getResourceAsStream(llllllllllllllllllIllIllIlIIIIll);
                if (llllllllllllllllllIllIllIlIIIIlI == null) {
                    return;
                }
                final PropertiesOrdered llllllllllllllllllIllIllIlIIIIIl = new PropertiesOrdered();
                llllllllllllllllllIllIllIlIIIIIl.load(llllllllllllllllllIllIllIlIIIIlI);
                llllllllllllllllllIllIllIlIIIIlI.close();
                Shaders.shaderPackClouds.loadFrom(llllllllllllllllllIllIllIlIIIIIl);
                Shaders.shaderPackDynamicHandLight.loadFrom(llllllllllllllllllIllIllIlIIIIIl);
                Shaders.shaderPackOldLighting.loadFrom(llllllllllllllllllIllIllIlIIIIIl);
                Shaders.shaderPackProfiles = ShaderPackParser.parseProfiles(llllllllllllllllllIllIllIlIIIIIl, Shaders.shaderPackOptions);
                Shaders.shaderPackGuiScreens = ShaderPackParser.parseGuiScreens(llllllllllllllllllIllIllIlIIIIIl, Shaders.shaderPackProfiles, Shaders.shaderPackOptions);
            }
            catch (IOException llllllllllllllllllIllIllIlIIIIII) {
                Config.warn(String.valueOf(new StringBuilder("[Shaders] Error reading: ").append(llllllllllllllllllIllIllIlIIIIll)));
            }
        }
    }
    
    public static void disableLightmap() {
        Shaders.lightmapEnabled = false;
        if (Shaders.activeProgram == 3) {
            useProgram(2);
        }
    }
    
    private static boolean printShaderLogInfo(final int llllllllllllllllllIllIIlIllIIIIl, final String llllllllllllllllllIllIIlIllIIIII) {
        final IntBuffer llllllllllllllllllIllIIlIlIlllll = BufferUtils.createIntBuffer(1);
        final int llllllllllllllllllIllIIlIlIllllI = GL20.glGetShaderi(llllllllllllllllllIllIIlIllIIIIl, 35716);
        if (llllllllllllllllllIllIIlIlIllllI > 1) {
            final String llllllllllllllllllIllIIlIlIlllIl = GL20.glGetShaderInfoLog(llllllllllllllllllIllIIlIllIIIIl, llllllllllllllllllIllIIlIlIllllI);
            SMCLog.info(String.valueOf(new StringBuilder("Shader info log: ").append(llllllllllllllllllIllIIlIllIIIII).append("\n").append(llllllllllllllllllIllIIlIlIlllIl)));
            return false;
        }
        return true;
    }
    
    public static int setFogMode(final int llllllllllllllllllIllIIIIllllllI) {
        return Shaders.fogMode = llllllllllllllllllIllIIIIllllllI;
    }
    
    public static void setViewport(final int llllllllllllllllllIllIIIlIIIIlII, final int llllllllllllllllllIllIIIlIIIIIll, final int llllllllllllllllllIllIIIlIIIIIlI, final int llllllllllllllllllIllIIIlIIIIIIl) {
        GlStateManager.colorMask(true, true, true, true);
        if (Shaders.isShadowPass) {
            GL11.glViewport(0, 0, Shaders.shadowMapWidth, Shaders.shadowMapHeight);
        }
        else {
            GL11.glViewport(0, 0, Shaders.renderWidth, Shaders.renderHeight);
            EXTFramebufferObject.glBindFramebufferEXT(36160, Shaders.dfb);
            Shaders.isRenderingDfb = true;
            GlStateManager.enableCull();
            GlStateManager.enableDepth();
            setDrawBuffers(Shaders.drawBuffersNone);
            useProgram(2);
            checkGLError("beginRenderPass");
        }
    }
    
    public static void disableFog() {
        Shaders.fogEnabled = false;
        setProgramUniform1i("fogMode", 0);
    }
    
    public static void sglEnableFog(final int llllllllllllllllllIlIllllIlllIll) {
        GL11.glEnable(llllllllllllllllllIlIllllIlllIll);
        enableFog();
    }
    
    public static int setEntityData1(final int llllllllllllllllllIlIllllIlIllII) {
        Shaders.entityData[Shaders.entityDataIndex * 2] = ((Shaders.entityData[Shaders.entityDataIndex * 2] & 0xFFFF) | llllllllllllllllllIlIllllIlIllII << 16);
        return llllllllllllllllllIlIllllIlIllII;
    }
    
    private static void setupNoiseTexture() {
        if (Shaders.noiseTexture == null) {
            Shaders.noiseTexture = new HFNoiseTexture(Shaders.noiseTextureResolution, Shaders.noiseTextureResolution);
        }
    }
    
    private static void printChat(final String llllllllllllllllllIllIlIIlIlIlll) {
        Shaders.mc.ingameGUI.getChatGUI().printChatMessage(new ChatComponentText(llllllllllllllllllIllIlIIlIlIlll));
    }
    
    private static void printChatAndLogError(final String llllllllllllllllllIllIlIIlIlIlIl) {
        SMCLog.severe(llllllllllllllllllIllIlIIlIlIlIl);
        Shaders.mc.ingameGUI.getChatGUI().printChatMessage(new ChatComponentText(llllllllllllllllllIllIlIIlIlIlIl));
    }
    
    public static String getShaderPackName() {
        return (Shaders.shaderPack == null) ? null : ((Shaders.shaderPack instanceof ShaderPackNone) ? null : Shaders.shaderPack.getName());
    }
    
    public static void resetDisplayListModels() {
        if (Shaders.needResetModels) {
            Shaders.needResetModels = false;
            SMCLog.info("Reset model renderers");
            for (final Render llllllllllllllllllIllIlIIIIlIIlI : Shaders.mc.getRenderManager().getEntityRenderMap().values()) {
                if (llllllllllllllllllIllIlIIIIlIIlI instanceof RendererLivingEntity) {
                    final RendererLivingEntity llllllllllllllllllIllIlIIIIlIIIl = (RendererLivingEntity)llllllllllllllllllIllIlIIIIlIIlI;
                    resetDisplayListModel(llllllllllllllllllIllIlIIIIlIIIl.getMainModel());
                }
            }
        }
    }
    
    public static void sglEnableT2D(final int llllllllllllllllllIlIlllllIIIIlI) {
        GL11.glEnable(llllllllllllllllllIlIlllllIIIIlI);
        enableTexture2D();
    }
    
    public static void beginRender(final Minecraft llllllllllllllllllIllIIIlIlIllII, final float llllllllllllllllllIllIIIlIlIIIIl, final long llllllllllllllllllIllIIIlIlIlIlI) {
        checkGLError("pre beginRender");
        checkWorldChanged(Shaders.mc.theWorld);
        Shaders.mc = llllllllllllllllllIllIIIlIlIllII;
        Shaders.mc.mcProfiler.startSection("init");
        Shaders.entityRenderer = Shaders.mc.entityRenderer;
        if (!Shaders.isShaderPackInitialized) {
            try {
                init();
            }
            catch (IllegalStateException llllllllllllllllllIllIIIlIlIlIIl) {
                if (Config.normalize(llllllllllllllllllIllIIIlIlIlIIl.getMessage()).equals("Function is not supported")) {
                    printChatAndLogError(String.valueOf(new StringBuilder("[Shaders] Error: ").append(llllllllllllllllllIllIIIlIlIlIIl.getMessage())));
                    llllllllllllllllllIllIIIlIlIlIIl.printStackTrace();
                    setShaderPack(Shaders.packNameNone);
                    return;
                }
            }
        }
        if (Shaders.mc.displayWidth != Shaders.renderDisplayWidth || Shaders.mc.displayHeight != Shaders.renderDisplayHeight) {
            resize();
        }
        if (Shaders.needResizeShadow) {
            resizeShadow();
        }
        Shaders.worldTime = Shaders.mc.theWorld.getWorldTime();
        Shaders.diffWorldTime = (Shaders.worldTime - Shaders.lastWorldTime) % 24000L;
        if (Shaders.diffWorldTime < 0L) {
            Shaders.diffWorldTime += 24000L;
        }
        Shaders.lastWorldTime = Shaders.worldTime;
        Shaders.moonPhase = Shaders.mc.theWorld.getMoonPhase();
        Shaders.systemTime = System.currentTimeMillis();
        if (Shaders.lastSystemTime == 0L) {
            Shaders.lastSystemTime = Shaders.systemTime;
        }
        Shaders.diffSystemTime = Shaders.systemTime - Shaders.lastSystemTime;
        Shaders.lastSystemTime = Shaders.systemTime;
        Shaders.frameTimeCounter += Shaders.diffSystemTime * 0.001f;
        Shaders.frameTimeCounter %= 3600.0f;
        Shaders.rainStrength = llllllllllllllllllIllIIIlIlIllII.theWorld.getRainStrength(llllllllllllllllllIllIIIlIlIIIIl);
        final float llllllllllllllllllIllIIIlIlIlIII = Shaders.diffSystemTime * 0.01f;
        float llllllllllllllllllIllIIIlIlIIlll = (float)Math.exp(Math.log(0.5) * llllllllllllllllllIllIIIlIlIlIII / ((Shaders.wetness < Shaders.rainStrength) ? Shaders.drynessHalfLife : Shaders.wetnessHalfLife));
        Shaders.wetness = Shaders.wetness * llllllllllllllllllIllIIIlIlIIlll + Shaders.rainStrength * (1.0f - llllllllllllllllllIllIIIlIlIIlll);
        final Entity llllllllllllllllllIllIIIlIlIIllI = Shaders.mc.func_175606_aa();
        Shaders.isSleeping = (llllllllllllllllllIllIIIlIlIIllI instanceof EntityLivingBase && ((EntityLivingBase)llllllllllllllllllIllIIIlIlIIllI).isPlayerSleeping());
        Shaders.eyePosY = (float)llllllllllllllllllIllIIIlIlIIllI.posY * llllllllllllllllllIllIIIlIlIIIIl + (float)llllllllllllllllllIllIIIlIlIIllI.lastTickPosY * (1.0f - llllllllllllllllllIllIIIlIlIIIIl);
        Shaders.eyeBrightness = llllllllllllllllllIllIIIlIlIIllI.getBrightnessForRender(llllllllllllllllllIllIIIlIlIIIIl);
        llllllllllllllllllIllIIIlIlIIlll = Shaders.diffSystemTime * 0.01f;
        final float llllllllllllllllllIllIIIlIlIIlIl = (float)Math.exp(Math.log(0.5) * llllllllllllllllllIllIIIlIlIIlll / Shaders.eyeBrightnessHalflife);
        Shaders.eyeBrightnessFadeX = Shaders.eyeBrightnessFadeX * llllllllllllllllllIllIIIlIlIIlIl + (Shaders.eyeBrightness & 0xFFFF) * (1.0f - llllllllllllllllllIllIIIlIlIIlIl);
        Shaders.eyeBrightnessFadeY = Shaders.eyeBrightnessFadeY * llllllllllllllllllIllIIIlIlIIlIl + (Shaders.eyeBrightness >> 16) * (1.0f - llllllllllllllllllIllIIIlIlIIlIl);
        Shaders.isEyeInWater = ((Shaders.mc.gameSettings.thirdPersonView == 0 && !Shaders.isSleeping && Shaders.mc.thePlayer.isInsideOfMaterial(Material.water)) ? 1 : 0);
        final Vec3 llllllllllllllllllIllIIIlIlIIlII = Shaders.mc.theWorld.getSkyColor(Shaders.mc.func_175606_aa(), llllllllllllllllllIllIIIlIlIIIIl);
        Shaders.skyColorR = (float)llllllllllllllllllIllIIIlIlIIlII.xCoord;
        Shaders.skyColorG = (float)llllllllllllllllllIllIIIlIlIIlII.yCoord;
        Shaders.skyColorB = (float)llllllllllllllllllIllIIIlIlIIlII.zCoord;
        Shaders.isRenderingWorld = true;
        Shaders.isCompositeRendered = false;
        Shaders.isHandRendered = false;
        if (Shaders.usedShadowDepthBuffers >= 1) {
            GlStateManager.setActiveTexture(33988);
            GlStateManager.func_179144_i(Shaders.sfbDepthTextures.get(0));
            if (Shaders.usedShadowDepthBuffers >= 2) {
                GlStateManager.setActiveTexture(33989);
                GlStateManager.func_179144_i(Shaders.sfbDepthTextures.get(1));
            }
        }
        GlStateManager.setActiveTexture(33984);
        for (int llllllllllllllllllIllIIIlIlIIIll = 0; llllllllllllllllllIllIIIlIlIIIll < Shaders.usedColorBuffers; ++llllllllllllllllllIllIIIlIlIIIll) {
            GlStateManager.func_179144_i(Shaders.dfbColorTexturesA[llllllllllllllllllIllIIIlIlIIIll]);
            GL11.glTexParameteri(3553, 10240, 9729);
            GL11.glTexParameteri(3553, 10241, 9729);
            GlStateManager.func_179144_i(Shaders.dfbColorTexturesA[8 + llllllllllllllllllIllIIIlIlIIIll]);
            GL11.glTexParameteri(3553, 10240, 9729);
            GL11.glTexParameteri(3553, 10241, 9729);
        }
        GlStateManager.func_179144_i(0);
        for (int llllllllllllllllllIllIIIlIlIIIll = 0; llllllllllllllllllIllIIIlIlIIIll < 4 && 4 + llllllllllllllllllIllIIIlIlIIIll < Shaders.usedColorBuffers; ++llllllllllllllllllIllIIIlIlIIIll) {
            GlStateManager.setActiveTexture(33991 + llllllllllllllllllIllIIIlIlIIIll);
            GlStateManager.func_179144_i(Shaders.dfbColorTextures.get(4 + llllllllllllllllllIllIIIlIlIIIll));
        }
        GlStateManager.setActiveTexture(33990);
        GlStateManager.func_179144_i(Shaders.dfbDepthTextures.get(0));
        if (Shaders.usedDepthBuffers >= 2) {
            GlStateManager.setActiveTexture(33995);
            GlStateManager.func_179144_i(Shaders.dfbDepthTextures.get(1));
            if (Shaders.usedDepthBuffers >= 3) {
                GlStateManager.setActiveTexture(33996);
                GlStateManager.func_179144_i(Shaders.dfbDepthTextures.get(2));
            }
        }
        for (int llllllllllllllllllIllIIIlIlIIIll = 0; llllllllllllllllllIllIIIlIlIIIll < Shaders.usedShadowColorBuffers; ++llllllllllllllllllIllIIIlIlIIIll) {
            GlStateManager.setActiveTexture(33997 + llllllllllllllllllIllIIIlIlIIIll);
            GlStateManager.func_179144_i(Shaders.sfbColorTextures.get(llllllllllllllllllIllIIIlIlIIIll));
        }
        if (Shaders.noiseTextureEnabled) {
            GlStateManager.setActiveTexture(33984 + Shaders.noiseTexture.textureUnit);
            GlStateManager.func_179144_i(Shaders.noiseTexture.getID());
            GL11.glTexParameteri(3553, 10242, 10497);
            GL11.glTexParameteri(3553, 10243, 10497);
            GL11.glTexParameteri(3553, 10240, 9729);
            GL11.glTexParameteri(3553, 10241, 9729);
        }
        GlStateManager.setActiveTexture(33984);
        Shaders.previousCameraPositionX = Shaders.cameraPositionX;
        Shaders.previousCameraPositionY = Shaders.cameraPositionY;
        Shaders.previousCameraPositionZ = Shaders.cameraPositionZ;
        Shaders.previousProjection.position(0);
        Shaders.projection.position(0);
        Shaders.previousProjection.put(Shaders.projection);
        Shaders.previousProjection.position(0);
        Shaders.projection.position(0);
        Shaders.previousModelView.position(0);
        Shaders.modelView.position(0);
        Shaders.previousModelView.put(Shaders.modelView);
        Shaders.previousModelView.position(0);
        Shaders.modelView.position(0);
        checkGLError("beginRender");
        ShadersRender.renderShadowMap(Shaders.entityRenderer, 0, llllllllllllllllllIllIIIlIlIIIIl, llllllllllllllllllIllIIIlIlIlIlI);
        Shaders.mc.mcProfiler.endSection();
        EXTFramebufferObject.glBindFramebufferEXT(36160, Shaders.dfb);
        for (int llllllllllllllllllIllIIIlIlIIIll = 0; llllllllllllllllllIllIIIlIlIIIll < Shaders.usedColorBuffers; ++llllllllllllllllllIllIIIlIlIIIll) {
            Shaders.colorTexturesToggle[llllllllllllllllllIllIIIlIlIIIll] = 0;
            EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36064 + llllllllllllllllllIllIIIlIlIIIll, 3553, Shaders.dfbColorTexturesA[llllllllllllllllllIllIIIlIlIIIll], 0);
        }
        checkGLError("end beginRender");
    }
    
    public static void drawComposite() {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glBegin(7);
        GL11.glTexCoord2f(0.0f, 0.0f);
        GL11.glVertex3f(0.0f, 0.0f, 0.0f);
        GL11.glTexCoord2f(1.0f, 0.0f);
        GL11.glVertex3f(1.0f, 0.0f, 0.0f);
        GL11.glTexCoord2f(1.0f, 1.0f);
        GL11.glVertex3f(1.0f, 1.0f, 0.0f);
        GL11.glTexCoord2f(0.0f, 1.0f);
        GL11.glVertex3f(0.0f, 1.0f, 0.0f);
        GL11.glEnd();
    }
    
    public static void resetDisplayListModelRenderer(final ModelRenderer llllllllllllllllllIllIlIIIIIIIIl) {
        llllllllllllllllllIllIlIIIIIIIIl.resetDisplayList();
        if (llllllllllllllllllIllIlIIIIIIIIl.childModels != null) {
            for (int llllllllllllllllllIllIlIIIIIIIII = 0, llllllllllllllllllIllIIlllllllll = llllllllllllllllllIllIlIIIIIIIIl.childModels.size(); llllllllllllllllllIllIlIIIIIIIII < llllllllllllllllllIllIIlllllllll; ++llllllllllllllllllIllIlIIIIIIIII) {
                resetDisplayListModelRenderer(llllllllllllllllllIllIlIIIIIIIIl.childModels.get(llllllllllllllllllIllIlIIIIIIIII));
            }
        }
    }
    
    public static void readCenterDepth() {
        if (!Shaders.isShadowPass && Shaders.centerDepthSmoothEnabled) {
            Shaders.tempDirectFloatBuffer.clear();
            GL11.glReadPixels(Shaders.renderWidth / 2, Shaders.renderHeight / 2, 1, 1, 6402, 5126, Shaders.tempDirectFloatBuffer);
            Shaders.centerDepth = Shaders.tempDirectFloatBuffer.get(0);
            final float llllllllllllllllllIlIlllllIIllIl = Shaders.diffSystemTime * 0.01f;
            final float llllllllllllllllllIlIlllllIIllII = (float)Math.exp(Math.log(0.5) * llllllllllllllllllIlIlllllIIllIl / Shaders.centerDepthSmoothHalflife);
            Shaders.centerDepthSmooth = Shaders.centerDepthSmooth * llllllllllllllllllIlIlllllIIllII + Shaders.centerDepth * (1.0f - llllllllllllllllllIlIlllllIIllII);
        }
    }
    
    public static void endLivingDamage() {
        if (Shaders.isRenderingWorld && !Shaders.isShadowPass) {
            setDrawBuffers(Shaders.programsDrawBuffers[16]);
        }
    }
    
    public static void beginLivingDamage() {
        if (Shaders.isRenderingWorld) {
            ShadersTex.bindTexture(Shaders.defaultTexture);
            if (!Shaders.isShadowPass) {
                setDrawBuffers(Shaders.drawBuffersColorAtt0);
            }
        }
    }
    
    public static void nextAntialiasingLevel() {
        Shaders.configAntialiasingLevel += 2;
        Shaders.configAntialiasingLevel = Shaders.configAntialiasingLevel / 2 * 2;
        if (Shaders.configAntialiasingLevel > 4) {
            Shaders.configAntialiasingLevel = 0;
        }
        Shaders.configAntialiasingLevel = Config.limit(Shaders.configAntialiasingLevel, 0, 4);
    }
    
    public static void setFogColor(final float llllllllllllllllllIllIIIIlllIlll, final float llllllllllllllllllIllIIIIlllIllI, final float llllllllllllllllllIllIIIIlllIlIl) {
        Shaders.fogColorR = llllllllllllllllllIllIIIIlllIlll;
        Shaders.fogColorG = llllllllllllllllllIllIIIIlllIllI;
        Shaders.fogColorB = llllllllllllllllllIllIIIIlllIlIl;
    }
    
    public static void setFog(int llllllllllllllllllIlIllllIllIlIl) {
        GlStateManager.setFog(llllllllllllllllllIlIllllIllIlIl);
        llllllllllllllllllIlIllllIllIlIl = llllllllllllllllllIlIllllIllIlIl;
        if (Shaders.fogEnabled) {
            setProgramUniform1i("fogMode", llllllllllllllllllIlIllllIllIlIl);
        }
    }
    
    public static void beginHand() {
        GL11.glMatrixMode(5888);
        GL11.glPushMatrix();
        GL11.glMatrixMode(5889);
        GL11.glPushMatrix();
        GL11.glMatrixMode(5888);
        useProgram(19);
        checkGLError("beginHand");
        checkFramebufferStatus("beginHand");
    }
    
    static String versiontostring(final int llllllllllllllllllIllIlIlIIIIlII) {
        final String llllllllllllllllllIllIlIlIIIIIll = Integer.toString(llllllllllllllllllIllIlIlIIIIlII);
        return String.valueOf(new StringBuilder(String.valueOf(Integer.toString(Integer.parseInt(llllllllllllllllllIllIlIlIIIIIll.substring(1, 3))))).append(".").append(Integer.toString(Integer.parseInt(llllllllllllllllllIllIlIlIIIIIll.substring(3, 5)))).append(".").append(Integer.toString(Integer.parseInt(llllllllllllllllllIllIlIlIIIIIll.substring(5)))));
    }
    
    public static void glDisableWrapper(final int llllllllllllllllllIlIlllllIIIlII) {
        GL11.glDisable(llllllllllllllllllIlIlllllIIIlII);
        if (llllllllllllllllllIlIlllllIIIlII == 3553) {
            disableTexture2D();
        }
        else if (llllllllllllllllllIlIlllllIIIlII == 2912) {
            disableFog();
        }
    }
    
    public static void endHand() {
        checkGLError("pre endHand");
        checkFramebufferStatus("pre endHand");
        GL11.glMatrixMode(5889);
        GL11.glPopMatrix();
        GL11.glMatrixMode(5888);
        GL11.glPopMatrix();
        GlStateManager.blendFunc(770, 771);
        checkGLError("endHand");
    }
    
    public static void beginClouds() {
        Shaders.fogEnabled = true;
        pushEntity(-3, 0);
        useProgram(6);
    }
    
    private static void saveShader(final String llllllllllllllllllIllIIllIIIlllI, final String llllllllllllllllllIllIIllIIIllIl) {
        try {
            final File llllllllllllllllllIllIIllIIIllII = new File(Shaders.shaderpacksdir, String.valueOf(new StringBuilder("debug/").append(llllllllllllllllllIllIIllIIIlllI)));
            llllllllllllllllllIllIIllIIIllII.getParentFile().mkdirs();
            Config.writeFile(llllllllllllllllllIllIIllIIIllII, llllllllllllllllllIllIIllIIIllIl);
        }
        catch (IOException llllllllllllllllllIllIIllIIIlIll) {
            Config.warn(String.valueOf(new StringBuilder("Error saving: ").append(llllllllllllllllllIllIIllIIIlllI)));
            llllllllllllllllllIllIIllIIIlIll.printStackTrace();
        }
    }
    
    public static ShaderOption[] getShaderPackOptions(final String llllllllllllllllllIllIllIIllIlII) {
        ShaderOption[] llllllllllllllllllIllIllIIllIIll = Shaders.shaderPackOptions.clone();
        if (Shaders.shaderPackGuiScreens == null) {
            if (Shaders.shaderPackProfiles != null) {
                final ShaderOptionProfile llllllllllllllllllIllIllIIllIIlI = new ShaderOptionProfile(Shaders.shaderPackProfiles, llllllllllllllllllIllIllIIllIIll);
                llllllllllllllllllIllIllIIllIIll = (ShaderOption[])Config.addObjectToArray(llllllllllllllllllIllIllIIllIIll, llllllllllllllllllIllIllIIllIIlI, 0);
            }
            llllllllllllllllllIllIllIIllIIll = getVisibleOptions(llllllllllllllllllIllIllIIllIIll);
            return llllllllllllllllllIllIllIIllIIll;
        }
        final String llllllllllllllllllIllIllIIllIIIl = (llllllllllllllllllIllIllIIllIlII != null) ? String.valueOf(new StringBuilder("screen.").append(llllllllllllllllllIllIllIIllIlII)) : "screen";
        final ShaderOption[] llllllllllllllllllIllIllIIllIIII = Shaders.shaderPackGuiScreens.get(llllllllllllllllllIllIllIIllIIIl);
        if (llllllllllllllllllIllIllIIllIIII == null) {
            return new ShaderOption[0];
        }
        final ArrayList llllllllllllllllllIllIllIIlIllll = new ArrayList();
        for (int llllllllllllllllllIllIllIIlIlllI = 0; llllllllllllllllllIllIllIIlIlllI < llllllllllllllllllIllIllIIllIIII.length; ++llllllllllllllllllIllIllIIlIlllI) {
            final ShaderOption llllllllllllllllllIllIllIIlIllIl = llllllllllllllllllIllIllIIllIIII[llllllllllllllllllIllIllIIlIlllI];
            if (llllllllllllllllllIllIllIIlIllIl == null) {
                llllllllllllllllllIllIllIIlIllll.add(null);
            }
            else if (llllllllllllllllllIllIllIIlIllIl instanceof ShaderOptionRest) {
                final ShaderOption[] llllllllllllllllllIllIllIIlIllII = getShaderOptionsRest(Shaders.shaderPackGuiScreens, llllllllllllllllllIllIllIIllIIll);
                llllllllllllllllllIllIllIIlIllll.addAll(Arrays.asList(llllllllllllllllllIllIllIIlIllII));
            }
            else {
                llllllllllllllllllIllIllIIlIllll.add(llllllllllllllllllIllIllIIlIllIl);
            }
        }
        final ShaderOption[] llllllllllllllllllIllIllIIlIlIll = llllllllllllllllllIllIllIIlIllll.toArray(new ShaderOption[llllllllllllllllllIllIllIIlIllll.size()]);
        return llllllllllllllllllIllIllIIlIlIll;
    }
    
    public static void beginSky() {
        Shaders.isRenderingSky = true;
        Shaders.fogEnabled = true;
        setDrawBuffers(Shaders.dfbDrawBuffers);
        useProgram(5);
        pushEntity(-2, 0);
    }
    
    public static void beginProjectRedHalo() {
        if (Shaders.isRenderingWorld) {
            useProgram(1);
        }
    }
    
    public static void beginWater() {
        if (Shaders.isRenderingWorld) {
            if (!Shaders.isShadowPass) {
                useProgram(12);
                GlStateManager.enableBlend();
                GlStateManager.depthMask(true);
            }
            else {
                GlStateManager.depthMask(true);
            }
        }
    }
    
    public static void beginLeash() {
        useProgram(1);
    }
    
    public static void setUpPosition() {
        final FloatBuffer llllllllllllllllllIllIIIIIlIIllI = Shaders.tempMatrixDirectBuffer;
        llllllllllllllllllIllIIIIIlIIllI.clear();
        GL11.glGetFloat(2982, llllllllllllllllllIllIIIIIlIIllI);
        llllllllllllllllllIllIIIIIlIIllI.get(Shaders.tempMat, 0, 16);
        SMath.multiplyMat4xVec4(Shaders.upPosition, Shaders.tempMat, Shaders.upPosModelView);
    }
    
    private static void saveShaderPackOptions(final ShaderOption[] llllllllllllllllllIllIlIlllIllIl, final IShaderPack llllllllllllllllllIllIlIlllIllII) {
        final Properties llllllllllllllllllIllIlIlllIlIll = new Properties();
        if (Shaders.shaderPackOptions != null) {
            for (int llllllllllllllllllIllIlIlllIlIlI = 0; llllllllllllllllllIllIlIlllIlIlI < llllllllllllllllllIllIlIlllIllIl.length; ++llllllllllllllllllIllIlIlllIlIlI) {
                final ShaderOption llllllllllllllllllIllIlIlllIlIIl = llllllllllllllllllIllIlIlllIllIl[llllllllllllllllllIllIlIlllIlIlI];
                if (llllllllllllllllllIllIlIlllIlIIl.isChanged() && llllllllllllllllllIllIlIlllIlIIl.isEnabled()) {
                    llllllllllllllllllIllIlIlllIlIll.setProperty(llllllllllllllllllIllIlIlllIlIIl.getName(), llllllllllllllllllIllIlIlllIlIIl.getValue());
                }
            }
        }
        try {
            saveOptionProperties(llllllllllllllllllIllIlIlllIllII, llllllllllllllllllIllIlIlllIlIll);
        }
        catch (IOException llllllllllllllllllIllIlIlllIlIII) {
            Config.warn(String.valueOf(new StringBuilder("[Shaders] Error saving configuration for ").append(Shaders.shaderPack.getName())));
            llllllllllllllllllIllIlIlllIlIII.printStackTrace();
        }
    }
    
    public static void endWater() {
        if (Shaders.isRenderingWorld) {
            if (Shaders.isShadowPass) {}
            useProgram(Shaders.lightmapEnabled ? 3 : 2);
        }
    }
    
    private static void saveOptionProperties(final IShaderPack llllllllllllllllllIllIlIllIlllIl, final Properties llllllllllllllllllIllIlIllIlllII) throws IOException {
        final String llllllllllllllllllIllIlIllIllIll = String.valueOf(new StringBuilder(String.valueOf(Shaders.shaderpacksdirname)).append("/").append(llllllllllllllllllIllIlIllIlllIl.getName()).append(".txt"));
        final File llllllllllllllllllIllIlIllIllIlI = new File(Minecraft.getMinecraft().mcDataDir, llllllllllllllllllIllIlIllIllIll);
        if (llllllllllllllllllIllIlIllIlllII.isEmpty()) {
            llllllllllllllllllIllIlIllIllIlI.delete();
        }
        else {
            final FileOutputStream llllllllllllllllllIllIlIllIllIIl = new FileOutputStream(llllllllllllllllllIllIlIllIllIlI);
            llllllllllllllllllIllIlIllIlllII.store(llllllllllllllllllIllIlIllIllIIl, null);
            llllllllllllllllllIllIlIllIllIIl.flush();
            llllllllllllllllllIllIlIllIllIIl.close();
        }
    }
    
    public static void postCelestialRotate() {
        final FloatBuffer llllllllllllllllllIllIIIIIlIlIIl = Shaders.tempMatrixDirectBuffer;
        llllllllllllllllllIllIIIIIlIlIIl.clear();
        GL11.glGetFloat(2982, llllllllllllllllllIllIIIIIlIlIIl);
        llllllllllllllllllIllIIIIIlIlIIl.get(Shaders.tempMat, 0, 16);
        SMath.multiplyMat4xVec4(Shaders.sunPosition, Shaders.tempMat, Shaders.sunPosModelView);
        SMath.multiplyMat4xVec4(Shaders.moonPosition, Shaders.tempMat, Shaders.moonPosModelView);
        System.arraycopy((Shaders.shadowAngle == Shaders.sunAngle) ? Shaders.sunPosition : Shaders.moonPosition, 0, Shaders.shadowLightPosition, 0, 3);
        checkGLError("postCelestialRotate");
    }
    
    public static void uninit() {
        if (Shaders.isShaderPackInitialized) {
            checkGLError("Shaders.uninit pre");
            for (int llllllllllllllllllIllIIIllIIIlII = 0; llllllllllllllllllIllIIIllIIIlII < 33; ++llllllllllllllllllIllIIIllIIIlII) {
                if (Shaders.programsRef[llllllllllllllllllIllIIIllIIIlII] != 0) {
                    ARBShaderObjects.glDeleteObjectARB(Shaders.programsRef[llllllllllllllllllIllIIIllIIIlII]);
                    checkGLError("del programRef");
                }
                Shaders.programsRef[llllllllllllllllllIllIIIllIIIlII] = 0;
                Shaders.programsID[llllllllllllllllllIllIIIllIIIlII] = 0;
                Shaders.programsDrawBufSettings[llllllllllllllllllIllIIIllIIIlII] = null;
                Shaders.programsDrawBuffers[llllllllllllllllllIllIIIllIIIlII] = null;
                Shaders.programsCompositeMipmapSetting[llllllllllllllllllIllIIIllIIIlII] = 0;
            }
            if (Shaders.dfb != 0) {
                EXTFramebufferObject.glDeleteFramebuffersEXT(Shaders.dfb);
                Shaders.dfb = 0;
                checkGLError("del dfb");
            }
            if (Shaders.sfb != 0) {
                EXTFramebufferObject.glDeleteFramebuffersEXT(Shaders.sfb);
                Shaders.sfb = 0;
                checkGLError("del sfb");
            }
            if (Shaders.dfbDepthTextures != null) {
                GlStateManager.deleteTextures(Shaders.dfbDepthTextures);
                fillIntBufferZero(Shaders.dfbDepthTextures);
                checkGLError("del dfbDepthTextures");
            }
            if (Shaders.dfbColorTextures != null) {
                GlStateManager.deleteTextures(Shaders.dfbColorTextures);
                fillIntBufferZero(Shaders.dfbColorTextures);
                checkGLError("del dfbTextures");
            }
            if (Shaders.sfbDepthTextures != null) {
                GlStateManager.deleteTextures(Shaders.sfbDepthTextures);
                fillIntBufferZero(Shaders.sfbDepthTextures);
                checkGLError("del shadow depth");
            }
            if (Shaders.sfbColorTextures != null) {
                GlStateManager.deleteTextures(Shaders.sfbColorTextures);
                fillIntBufferZero(Shaders.sfbColorTextures);
                checkGLError("del shadow color");
            }
            if (Shaders.dfbDrawBuffers != null) {
                fillIntBufferZero(Shaders.dfbDrawBuffers);
            }
            if (Shaders.noiseTexture != null) {
                Shaders.noiseTexture.destroy();
                Shaders.noiseTexture = null;
            }
            SMCLog.info("Uninit");
            Shaders.shadowPassInterval = 0;
            Shaders.shouldSkipDefaultShadow = false;
            Shaders.isShaderPackInitialized = false;
            checkGLError("Shaders.uninit");
        }
    }
    
    public static void endRender() {
        if (Shaders.isShadowPass) {
            checkGLError("shadow endRender");
        }
        else {
            if (!Shaders.isCompositeRendered) {
                renderCompositeFinal();
            }
            Shaders.isRenderingWorld = false;
            GlStateManager.colorMask(true, true, true, true);
            useProgram(0);
            RenderHelper.disableStandardItemLighting();
            checkGLError("endRender end");
        }
    }
    
    public static int getEntityData2() {
        return Shaders.entityData[Shaders.entityDataIndex * 2 + 1];
    }
    
    public static void sglDisableFog(final int llllllllllllllllllIlIllllIlllIIl) {
        GL11.glDisable(llllllllllllllllllIlIllllIlllIIl);
        disableFog();
    }
    
    public static void scheduleResize() {
        Shaders.renderDisplayHeight = 0;
    }
    
    public static ShaderOption[] getChangedOptions(final ShaderOption[] llllllllllllllllllIllIlIlIllIIII) {
        final ArrayList llllllllllllllllllIllIlIlIlIllll = new ArrayList();
        for (int llllllllllllllllllIllIlIlIlIlllI = 0; llllllllllllllllllIllIlIlIlIlllI < llllllllllllllllllIllIlIlIllIIII.length; ++llllllllllllllllllIllIlIlIlIlllI) {
            final ShaderOption llllllllllllllllllIllIlIlIlIllIl = llllllllllllllllllIllIlIlIllIIII[llllllllllllllllllIllIlIlIlIlllI];
            if (llllllllllllllllllIllIlIlIlIllIl.isEnabled() && llllllllllllllllllIllIlIlIlIllIl.isChanged()) {
                llllllllllllllllllIllIlIlIlIllll.add(llllllllllllllllllIllIlIlIlIllIl);
            }
        }
        final ShaderOption[] llllllllllllllllllIllIlIlIlIllII = llllllllllllllllllIllIlIlIlIllll.toArray(new ShaderOption[llllllllllllllllllIllIlIlIlIllll.size()]);
        return llllllllllllllllllIllIlIlIlIllII;
    }
    
    public static void beginLitParticles() {
        useProgram(3);
    }
    
    public static void resetDisplayList() {
        ++Shaders.numberResetDisplayList;
        Shaders.needResetModels = true;
        SMCLog.info("Reset world renderers");
        Shaders.mc.renderGlobal.loadRenderers();
    }
    
    public static String translate(final String llllllllllllllllllIlIlllIlllIIIl, final String llllllllllllllllllIlIlllIlllIIII) {
        final String llllllllllllllllllIlIlllIllIllll = Shaders.shaderPackResources.get(llllllllllllllllllIlIlllIlllIIIl);
        return (llllllllllllllllllIlIlllIllIllll == null) ? llllllllllllllllllIlIlllIlllIIII : llllllllllllllllllIlIlllIllIllll;
    }
    
    public static int setEntityData2(final int llllllllllllllllllIlIllllIlIlIlI) {
        Shaders.entityData[Shaders.entityDataIndex * 2 + 1] = ((Shaders.entityData[Shaders.entityDataIndex * 2 + 1] & 0xFFFF0000) | (llllllllllllllllllIlIllllIlIlIlI & 0xFFFF));
        return llllllllllllllllllIlIllllIlIlIlI;
    }
    
    private static ShaderOption[] getShaderOptionsRest(final Map<String, ShaderOption[]> llllllllllllllllllIllIllIIIIlIll, final ShaderOption[] llllllllllllllllllIllIllIIIIlIlI) {
        final HashSet llllllllllllllllllIllIllIIIlIlll = new HashSet();
        final Set llllllllllllllllllIllIllIIIlIllI = llllllllllllllllllIllIllIIIIlIll.keySet();
        for (final String llllllllllllllllllIllIllIIIlIlII : llllllllllllllllllIllIllIIIlIllI) {
            final ShaderOption[] llllllllllllllllllIllIllIIIlIIll = llllllllllllllllllIllIllIIIIlIll.get(llllllllllllllllllIllIllIIIlIlII);
            for (int llllllllllllllllllIllIllIIIlIIlI = 0; llllllllllllllllllIllIllIIIlIIlI < llllllllllllllllllIllIllIIIlIIll.length; ++llllllllllllllllllIllIllIIIlIIlI) {
                final ShaderOption llllllllllllllllllIllIllIIIlIIIl = llllllllllllllllllIllIllIIIlIIll[llllllllllllllllllIllIllIIIlIIlI];
                if (llllllllllllllllllIllIllIIIlIIIl != null) {
                    llllllllllllllllllIllIllIIIlIlll.add(llllllllllllllllllIllIllIIIlIIIl.getName());
                }
            }
        }
        final ArrayList llllllllllllllllllIllIllIIIlIIII = new ArrayList();
        for (int llllllllllllllllllIllIllIIIIllll = 0; llllllllllllllllllIllIllIIIIllll < llllllllllllllllllIllIllIIIIlIlI.length; ++llllllllllllllllllIllIllIIIIllll) {
            final ShaderOption llllllllllllllllllIllIllIIIIlllI = llllllllllllllllllIllIllIIIIlIlI[llllllllllllllllllIllIllIIIIllll];
            if (llllllllllllllllllIllIllIIIIlllI.isVisible()) {
                final String llllllllllllllllllIllIllIIIIllIl = llllllllllllllllllIllIllIIIIlllI.getName();
                if (!llllllllllllllllllIllIllIIIlIlll.contains(llllllllllllllllllIllIllIIIIllIl)) {
                    llllllllllllllllllIllIllIIIlIIII.add(llllllllllllllllllIllIllIIIIlllI);
                }
            }
        }
        final ShaderOption[] llllllllllllllllllIllIllIIIIllII = llllllllllllllllllIllIllIIIlIIII.toArray(new ShaderOption[llllllllllllllllllIllIllIIIlIIII.size()]);
        return llllllllllllllllllIllIllIIIIllII;
    }
    
    public static void printIntBuffer(final String llllllllllllllllllIllIlIIlIIlIIl, final IntBuffer llllllllllllllllllIllIlIIlIIlIII) {
        final StringBuilder llllllllllllllllllIllIlIIlIIllII = new StringBuilder(128);
        llllllllllllllllllIllIlIIlIIllII.append(llllllllllllllllllIllIlIIlIIlIIl).append(" [pos ").append(llllllllllllllllllIllIlIIlIIlIII.position()).append(" lim ").append(llllllllllllllllllIllIlIIlIIlIII.limit()).append(" cap ").append(llllllllllllllllllIllIlIIlIIlIII.capacity()).append(" :");
        for (int llllllllllllllllllIllIlIIlIIlIll = llllllllllllllllllIllIlIIlIIlIII.limit(), llllllllllllllllllIllIlIIlIIlIlI = 0; llllllllllllllllllIllIlIIlIIlIlI < llllllllllllllllllIllIlIIlIIlIll; ++llllllllllllllllllIllIlIIlIIlIlI) {
            llllllllllllllllllIllIlIIlIIllII.append(" ").append(llllllllllllllllllIllIlIIlIIlIII.get(llllllllllllllllllIllIlIIlIIlIlI));
        }
        llllllllllllllllllIllIlIIlIIllII.append("]");
        SMCLog.info(String.valueOf(llllllllllllllllllIllIlIIlIIllII));
    }
    
    public static void nextEntity(final Entity llllllllllllllllllIlIllllllIlllI) {
        if (Shaders.isRenderingWorld) {
            useProgram(16);
            setEntityId(llllllllllllllllllIlIllllllIlllI);
        }
    }
    
    public static boolean isOldLighting() {
        return Shaders.configOldLighting.isDefault() ? (Shaders.shaderPackOldLighting.isDefault() || Shaders.shaderPackOldLighting.isTrue()) : Shaders.configOldLighting.isTrue();
    }
    
    public static void setClearColor(final float llllllllllllllllllIllIIIIlllIIII, final float llllllllllllllllllIllIIIIllIllll, final float llllllllllllllllllIllIIIIllIlIlI, final float llllllllllllllllllIllIIIIllIlIIl) {
        GlStateManager.clearColor(llllllllllllllllllIllIIIIlllIIII, llllllllllllllllllIllIIIIllIllll, llllllllllllllllllIllIIIIllIlIlI, llllllllllllllllllIllIIIIllIlIIl);
        Shaders.clearColorR = llllllllllllllllllIllIIIIlllIIII;
        Shaders.clearColorG = llllllllllllllllllIllIIIIllIllll;
        Shaders.clearColorB = llllllllllllllllllIllIIIIllIlIlI;
    }
    
    public static void setEntityColor(final float llllllllllllllllllIlIlllllIlllll, final float llllllllllllllllllIlIllllllIIIlI, final float llllllllllllllllllIlIllllllIIIIl, final float llllllllllllllllllIlIllllllIIIII) {
        if (Shaders.isRenderingWorld && !Shaders.isShadowPass) {
            Shaders.uniformEntityColor.setValue(llllllllllllllllllIlIlllllIlllll, llllllllllllllllllIlIllllllIIIlI, llllllllllllllllllIlIllllllIIIIl, llllllllllllllllllIlIllllllIIIII);
        }
    }
    
    public static void preSkyList() {
        GL11.glColor3f(Shaders.fogColorR, Shaders.fogColorG, Shaders.fogColorB);
        drawHorizon();
        GL11.glColor3f(Shaders.skyColorR, Shaders.skyColorG, Shaders.skyColorB);
    }
    
    public static void endBlockEntities() {
        if (Shaders.isRenderingWorld) {
            checkGLError("endBlockEntities");
            useProgram(Shaders.lightmapEnabled ? 3 : 2);
            ShadersTex.bindNSTextures(Shaders.defaultTexture.getMultiTexID());
        }
    }
    
    public static int checkGLError(final String llllllllllllllllllIllIlIIllIlIII, final String llllllllllllllllllIllIlIIllIlIlI) {
        final int llllllllllllllllllIllIlIIllIlIIl = GL11.glGetError();
        if (llllllllllllllllllIllIlIIllIlIIl != 0) {
            System.err.format("GL error 0x%04x: %s at %s %s\n", llllllllllllllllllIllIlIIllIlIIl, GLU.gluErrorString(llllllllllllllllllIllIlIIllIlIIl), llllllllllllllllllIllIlIIllIlIII, llllllllllllllllllIllIlIIllIlIlI);
        }
        return llllllllllllllllllIllIlIIllIlIIl;
    }
    
    public static void setProgramUniform1f(final String llllllllllllllllllIllIIlIIIllIlI, final float llllllllllllllllllIllIIlIIIlllIl) {
        final int llllllllllllllllllIllIIlIIIlllII = Shaders.programsID[Shaders.activeProgram];
        if (llllllllllllllllllIllIIlIIIlllII != 0) {
            final int llllllllllllllllllIllIIlIIIllIll = ARBShaderObjects.glGetUniformLocationARB(llllllllllllllllllIllIIlIIIlllII, (CharSequence)llllllllllllllllllIllIIlIIIllIlI);
            ARBShaderObjects.glUniform1fARB(llllllllllllllllllIllIIlIIIllIll, llllllllllllllllllIllIIlIIIlllIl);
            checkGLError(Shaders.programNames[Shaders.activeProgram], llllllllllllllllllIllIIlIIIllIlI);
        }
    }
    
    private static void checkWorldChanged(final World llllllllllllllllllIllIIIlIIIllIl) {
        if (Shaders.currentWorld != llllllllllllllllllIllIIIlIIIllIl) {
            final World llllllllllllllllllIllIIIlIIlIIlI = Shaders.currentWorld;
            Shaders.currentWorld = llllllllllllllllllIllIIIlIIIllIl;
            if (llllllllllllllllllIllIIIlIIlIIlI != null && llllllllllllllllllIllIIIlIIIllIl != null) {
                final int llllllllllllllllllIllIIIlIIlIIIl = llllllllllllllllllIllIIIlIIlIIlI.provider.getDimensionId();
                final int llllllllllllllllllIllIIIlIIlIIII = llllllllllllllllllIllIIIlIIIllIl.provider.getDimensionId();
                final boolean llllllllllllllllllIllIIIlIIIllll = Shaders.shaderPackDimensions.contains(llllllllllllllllllIllIIIlIIlIIIl);
                final boolean llllllllllllllllllIllIIIlIIIlllI = Shaders.shaderPackDimensions.contains(llllllllllllllllllIllIIIlIIlIIII);
                if (llllllllllllllllllIllIIIlIIIllll || llllllllllllllllllIllIIIlIIIlllI) {
                    uninit();
                }
            }
        }
    }
    
    public static void glEnableWrapper(final int llllllllllllllllllIlIlllllIIlIII) {
        GL11.glEnable(llllllllllllllllllIlIlllllIIlIII);
        if (llllllllllllllllllIlIlllllIIlIII == 3553) {
            enableTexture2D();
        }
        else if (llllllllllllllllllIlIlllllIIlIII == 2912) {
            enableFog();
        }
    }
    
    public static void checkShadersModInstalled() {
        try {
            final double llllllllllllllllllIlIllllIIllIlI = (double)Class.forName("shadersmod.transform.SMCClassTransformer");
        }
        catch (Throwable llllllllllllllllllIlIllllIIllIll) {
            return;
        }
        throw new RuntimeException("Shaders Mod detected. Please remove it, OptiFine has built-in support for shaders.");
    }
    
    public static void sglDisableT2D(final int llllllllllllllllllIlIllllIlllllI) {
        GL11.glDisable(llllllllllllllllllIlIllllIlllllI);
        disableTexture2D();
    }
    
    public static void beginFPOverlay() {
        GlStateManager.disableLighting();
        GlStateManager.disableBlend();
    }
    
    public static void beginUpdateChunks() {
        checkGLError("beginUpdateChunks1");
        checkFramebufferStatus("beginUpdateChunks1");
        if (!Shaders.isShadowPass) {
            useProgram(7);
        }
        checkGLError("beginUpdateChunks2");
        checkFramebufferStatus("beginUpdateChunks2");
    }
    
    public static void preWater() {
        if (Shaders.usedDepthBuffers >= 2) {
            GlStateManager.setActiveTexture(33995);
            checkGLError("pre copy depth");
            GL11.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, Shaders.renderWidth, Shaders.renderHeight);
            checkGLError("copy depth");
            GlStateManager.setActiveTexture(33984);
        }
        ShadersTex.bindNSTextures(Shaders.defaultTexture.getMultiTexID());
    }
    
    public static ShaderOption[] getShaderPackOptions() {
        return Shaders.shaderPackOptions;
    }
    
    public static void updateBlockLightLevel() {
        if (isOldLighting()) {
            Shaders.blockLightLevel05 = 0.5f;
            Shaders.blockLightLevel06 = 0.6f;
            Shaders.blockLightLevel08 = 0.8f;
        }
        else {
            Shaders.blockLightLevel05 = 1.0f;
            Shaders.blockLightLevel06 = 1.0f;
            Shaders.blockLightLevel08 = 1.0f;
        }
    }
    
    public static void setProgramUniform3f(final String llllllllllllllllllIllIIlIIIIlIlI, final float llllllllllllllllllIllIIlIIIIllll, final float llllllllllllllllllIllIIlIIIIlIII, final float llllllllllllllllllIllIIlIIIIIlll) {
        final int llllllllllllllllllIllIIlIIIIllII = Shaders.programsID[Shaders.activeProgram];
        if (llllllllllllllllllIllIIlIIIIllII != 0) {
            final int llllllllllllllllllIllIIlIIIIlIll = ARBShaderObjects.glGetUniformLocationARB(llllllllllllllllllIllIIlIIIIllII, (CharSequence)llllllllllllllllllIllIIlIIIIlIlI);
            ARBShaderObjects.glUniform3fARB(llllllllllllllllllIllIIlIIIIlIll, llllllllllllllllllIllIIlIIIIllll, llllllllllllllllllIllIIlIIIIlIII, llllllllllllllllllIllIIlIIIIIlll);
            checkGLError(Shaders.programNames[Shaders.activeProgram], llllllllllllllllllIllIIlIIIIlIlI);
        }
    }
    
    public static void disableTexture2D() {
        if (Shaders.isRenderingSky) {
            useProgram(4);
        }
        else if (Shaders.activeProgram == 2 || Shaders.activeProgram == 3) {
            useProgram(1);
        }
    }
    
    public static void endEntities() {
        if (Shaders.isRenderingWorld) {
            useProgram(Shaders.lightmapEnabled ? 3 : 2);
        }
    }
    
    static void checkOptifine() {
    }
    
    public static int getEntityData() {
        return Shaders.entityData[Shaders.entityDataIndex * 2];
    }
    
    public static void loadConfig() {
        SMCLog.info("Load ShadersMod configuration.");
        try {
            if (!Shaders.shaderpacksdir.exists()) {
                Shaders.shaderpacksdir.mkdir();
            }
        }
        catch (Exception llllllllllllllllllIllIlllIIIllIl) {
            SMCLog.severe(String.valueOf(new StringBuilder("Failed to open the shaderpacks directory: ").append(Shaders.shaderpacksdir)));
        }
        (Shaders.shadersConfig = new PropertiesOrdered()).setProperty(EnumShaderOption.SHADER_PACK.getPropertyKey(), "");
        if (Shaders.configFile.exists()) {
            try {
                final FileReader llllllllllllllllllIllIlllIIIllII = new FileReader(Shaders.configFile);
                Shaders.shadersConfig.load(llllllllllllllllllIllIlllIIIllII);
                llllllllllllllllllIllIlllIIIllII.close();
            }
            catch (Exception ex) {}
        }
        if (!Shaders.configFile.exists()) {
            try {
                storeConfig();
            }
            catch (Exception ex2) {}
        }
        final EnumShaderOption[] llllllllllllllllllIllIlllIIIlIll = EnumShaderOption.values();
        for (int llllllllllllllllllIllIlllIIIlIlI = 0; llllllllllllllllllIllIlllIIIlIlI < llllllllllllllllllIllIlllIIIlIll.length; ++llllllllllllllllllIllIlllIIIlIlI) {
            final EnumShaderOption llllllllllllllllllIllIlllIIIlIIl = llllllllllllllllllIllIlllIIIlIll[llllllllllllllllllIllIlllIIIlIlI];
            final String llllllllllllllllllIllIlllIIIlIII = llllllllllllllllllIllIlllIIIlIIl.getPropertyKey();
            final String llllllllllllllllllIllIlllIIIIlll = llllllllllllllllllIllIlllIIIlIIl.getValueDefault();
            final String llllllllllllllllllIllIlllIIIIllI = Shaders.shadersConfig.getProperty(llllllllllllllllllIllIlllIIIlIII, llllllllllllllllllIllIlllIIIIlll);
            setEnumShaderOption(llllllllllllllllllIllIlllIIIlIIl, llllllllllllllllllIllIlllIIIIllI);
        }
        loadShaderPack();
    }
    
    private static void clearDirectory(final File llllllllllllllllllIllIIllIIIIIll) {
        if (llllllllllllllllllIllIIllIIIIIll.exists() && llllllllllllllllllIllIIllIIIIIll.isDirectory()) {
            final File[] llllllllllllllllllIllIIllIIIIIlI = llllllllllllllllllIllIIllIIIIIll.listFiles();
            if (llllllllllllllllllIllIIllIIIIIlI != null) {
                for (int llllllllllllllllllIllIIllIIIIIIl = 0; llllllllllllllllllIllIIllIIIIIIl < llllllllllllllllllIllIIllIIIIIlI.length; ++llllllllllllllllllIllIIllIIIIIIl) {
                    final File llllllllllllllllllIllIIllIIIIIII = llllllllllllllllllIllIIllIIIIIlI[llllllllllllllllllIllIIllIIIIIIl];
                    if (llllllllllllllllllIllIIllIIIIIII.isDirectory()) {
                        clearDirectory(llllllllllllllllllIllIIllIIIIIII);
                    }
                    llllllllllllllllllIllIIllIIIIIII.delete();
                }
            }
        }
    }
    
    public static void genCompositeMipmap() {
        if (Shaders.hasGlGenMipmap) {
            for (int llllllllllllllllllIllIIIIIlIIIll = 0; llllllllllllllllllIllIIIIIlIIIll < Shaders.usedColorBuffers; ++llllllllllllllllllIllIIIIIlIIIll) {
                if ((Shaders.activeCompositeMipmapSetting & 1 << llllllllllllllllllIllIIIIIlIIIll) != 0x0) {
                    GlStateManager.setActiveTexture(33984 + Shaders.colorTextureTextureImageUnit[llllllllllllllllllIllIIIIIlIIIll]);
                    GL11.glTexParameteri(3553, 10241, 9987);
                    GL30.glGenerateMipmap(3553);
                }
            }
            GlStateManager.setActiveTexture(33984);
        }
    }
    
    public static void setProgramUniform1i(final String llllllllllllllllllIllIIlIIllIlIl, final int llllllllllllllllllIllIIlIIllIlII) {
        final int llllllllllllllllllIllIIlIIllIlll = Shaders.programsID[Shaders.activeProgram];
        if (llllllllllllllllllIllIIlIIllIlll != 0) {
            final int llllllllllllllllllIllIIlIIllIllI = ARBShaderObjects.glGetUniformLocationARB(llllllllllllllllllIllIIlIIllIlll, (CharSequence)llllllllllllllllllIllIIlIIllIlIl);
            ARBShaderObjects.glUniform1iARB(llllllllllllllllllIllIIlIIllIllI, llllllllllllllllllIllIIlIIllIlII);
            checkGLError(Shaders.programNames[Shaders.activeProgram], llllllllllllllllllIllIIlIIllIlIl);
        }
    }
    
    public static void popEntity() {
        Shaders.entityData[Shaders.entityDataIndex * 2] = 0;
        Shaders.entityData[Shaders.entityDataIndex * 2 + 1] = 0;
        --Shaders.entityDataIndex;
    }
    
    public static void nextBlockEntity(final TileEntity llllllllllllllllllIlIlllllIllIlI) {
        if (Shaders.isRenderingWorld) {
            checkGLError("nextBlockEntity");
            useProgram(13);
            setBlockEntityId(llllllllllllllllllIlIlllllIllIlI);
        }
    }
    
    private static void setupFrameBuffer() {
        if (Shaders.dfb != 0) {
            EXTFramebufferObject.glDeleteFramebuffersEXT(Shaders.dfb);
            GlStateManager.deleteTextures(Shaders.dfbDepthTextures);
            GlStateManager.deleteTextures(Shaders.dfbColorTextures);
        }
        Shaders.dfb = EXTFramebufferObject.glGenFramebuffersEXT();
        GL11.glGenTextures((IntBuffer)Shaders.dfbDepthTextures.clear().limit(Shaders.usedDepthBuffers));
        GL11.glGenTextures((IntBuffer)Shaders.dfbColorTextures.clear().limit(16));
        Shaders.dfbDepthTextures.position(0);
        Shaders.dfbColorTextures.position(0);
        Shaders.dfbColorTextures.get(Shaders.dfbColorTexturesA).position(0);
        EXTFramebufferObject.glBindFramebufferEXT(36160, Shaders.dfb);
        GL20.glDrawBuffers(0);
        GL11.glReadBuffer(0);
        for (int llllllllllllllllllIllIIIllIIIIII = 0; llllllllllllllllllIllIIIllIIIIII < Shaders.usedDepthBuffers; ++llllllllllllllllllIllIIIllIIIIII) {
            GlStateManager.func_179144_i(Shaders.dfbDepthTextures.get(llllllllllllllllllIllIIIllIIIIII));
            GL11.glTexParameteri(3553, 10242, 10496);
            GL11.glTexParameteri(3553, 10243, 10496);
            GL11.glTexParameteri(3553, 10241, 9728);
            GL11.glTexParameteri(3553, 10240, 9728);
            GL11.glTexParameteri(3553, 34891, 6409);
            GL11.glTexImage2D(3553, 0, 6402, Shaders.renderWidth, Shaders.renderHeight, 0, 6402, 5126, (FloatBuffer)null);
        }
        EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36096, 3553, Shaders.dfbDepthTextures.get(0), 0);
        GL20.glDrawBuffers(Shaders.dfbDrawBuffers);
        GL11.glReadBuffer(0);
        checkGLError("FT d");
        for (int llllllllllllllllllIllIIIllIIIIII = 0; llllllllllllllllllIllIIIllIIIIII < Shaders.usedColorBuffers; ++llllllllllllllllllIllIIIllIIIIII) {
            GlStateManager.func_179144_i(Shaders.dfbColorTexturesA[llllllllllllllllllIllIIIllIIIIII]);
            GL11.glTexParameteri(3553, 10242, 10496);
            GL11.glTexParameteri(3553, 10243, 10496);
            GL11.glTexParameteri(3553, 10241, 9729);
            GL11.glTexParameteri(3553, 10240, 9729);
            GL11.glTexImage2D(3553, 0, Shaders.gbuffersFormat[llllllllllllllllllIllIIIllIIIIII], Shaders.renderWidth, Shaders.renderHeight, 0, 32993, 33639, (ByteBuffer)null);
            EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36064 + llllllllllllllllllIllIIIllIIIIII, 3553, Shaders.dfbColorTexturesA[llllllllllllllllllIllIIIllIIIIII], 0);
            checkGLError("FT c");
        }
        for (int llllllllllllllllllIllIIIllIIIIII = 0; llllllllllllllllllIllIIIllIIIIII < Shaders.usedColorBuffers; ++llllllllllllllllllIllIIIllIIIIII) {
            GlStateManager.func_179144_i(Shaders.dfbColorTexturesA[8 + llllllllllllllllllIllIIIllIIIIII]);
            GL11.glTexParameteri(3553, 10242, 10496);
            GL11.glTexParameteri(3553, 10243, 10496);
            GL11.glTexParameteri(3553, 10241, 9729);
            GL11.glTexParameteri(3553, 10240, 9729);
            GL11.glTexImage2D(3553, 0, Shaders.gbuffersFormat[llllllllllllllllllIllIIIllIIIIII], Shaders.renderWidth, Shaders.renderHeight, 0, 32993, 33639, (ByteBuffer)null);
            checkGLError("FT ca");
        }
        int llllllllllllllllllIllIIIllIIIIII = EXTFramebufferObject.glCheckFramebufferStatusEXT(36160);
        if (llllllllllllllllllIllIIIllIIIIII == 36058) {
            printChatAndLogError("[Shaders] Error: Failed framebuffer incomplete formats");
            for (int llllllllllllllllllIllIIIlIllllll = 0; llllllllllllllllllIllIIIlIllllll < Shaders.usedColorBuffers; ++llllllllllllllllllIllIIIlIllllll) {
                GlStateManager.func_179144_i(Shaders.dfbColorTextures.get(llllllllllllllllllIllIIIlIllllll));
                GL11.glTexImage2D(3553, 0, 6408, Shaders.renderWidth, Shaders.renderHeight, 0, 32993, 33639, (ByteBuffer)null);
                EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36064 + llllllllllllllllllIllIIIlIllllll, 3553, Shaders.dfbColorTextures.get(llllllllllllllllllIllIIIlIllllll), 0);
                checkGLError("FT c");
            }
            llllllllllllllllllIllIIIllIIIIII = EXTFramebufferObject.glCheckFramebufferStatusEXT(36160);
            if (llllllllllllllllllIllIIIllIIIIII == 36053) {
                SMCLog.info("complete");
            }
        }
        GlStateManager.func_179144_i(0);
        if (llllllllllllllllllIllIIIllIIIIII != 36053) {
            printChatAndLogError(String.valueOf(new StringBuilder("[Shaders] Error: Failed creating framebuffer! (Status ").append(llllllllllllllllllIllIIIllIIIIII).append(")")));
        }
        else {
            SMCLog.info("Framebuffer created.");
        }
    }
    
    public static int checkFramebufferStatus(final String llllllllllllllllllIllIlIIllllllI) {
        final int llllllllllllllllllIllIlIIlllllIl = EXTFramebufferObject.glCheckFramebufferStatusEXT(36160);
        if (llllllllllllllllllIllIlIIlllllIl != 36053) {
            System.err.format("FramebufferStatus 0x%04X at %s\n", llllllllllllllllllIllIlIIlllllIl, llllllllllllllllllIllIlIIllllllI);
        }
        return llllllllllllllllllIllIlIIlllllIl;
    }
    
    public static void setBlockEntityId(final TileEntity llllllllllllllllllIlIlllllIlIlIl) {
        if (Shaders.isRenderingWorld && !Shaders.isShadowPass && Shaders.uniformBlockEntityId.isDefined()) {
            final Block llllllllllllllllllIlIlllllIlIlII = llllllllllllllllllIlIlllllIlIlIl.getBlockType();
            final int llllllllllllllllllIlIlllllIlIIll = Block.getIdFromBlock(llllllllllllllllllIlIlllllIlIlII);
            Shaders.uniformBlockEntityId.setValue(llllllllllllllllllIlIlllllIlIIll);
        }
    }
    
    private static void resize() {
        Shaders.renderDisplayWidth = Shaders.mc.displayWidth;
        Shaders.renderDisplayHeight = Shaders.mc.displayHeight;
        Shaders.renderWidth = Math.round(Shaders.renderDisplayWidth * Shaders.configRenderResMul);
        Shaders.renderHeight = Math.round(Shaders.renderDisplayHeight * Shaders.configRenderResMul);
        setupFrameBuffer();
    }
    
    public static void pushEntity(final int llllllllllllllllllIlIllllIlIIlII, final int llllllllllllllllllIlIllllIlIIlIl) {
        ++Shaders.entityDataIndex;
        Shaders.entityData[Shaders.entityDataIndex * 2] = ((llllllllllllllllllIlIllllIlIIlII & 0xFFFF) | llllllllllllllllllIlIllllIlIIlIl << 16);
        Shaders.entityData[Shaders.entityDataIndex * 2 + 1] = 0;
    }
    
    private static int getBufferIndexFromString(final String llllllllllllllllllIllIIIllllIIll) {
        return (!llllllllllllllllllIllIIIllllIIll.equals("colortex0") && !llllllllllllllllllIllIIIllllIIll.equals("gcolor")) ? ((!llllllllllllllllllIllIIIllllIIll.equals("colortex1") && !llllllllllllllllllIllIIIllllIIll.equals("gdepth")) ? ((!llllllllllllllllllIllIIIllllIIll.equals("colortex2") && !llllllllllllllllllIllIIIllllIIll.equals("gnormal")) ? ((!llllllllllllllllllIllIIIllllIIll.equals("colortex3") && !llllllllllllllllllIllIIIllllIIll.equals("composite")) ? ((!llllllllllllllllllIllIIIllllIIll.equals("colortex4") && !llllllllllllllllllIllIIIllllIIll.equals("gaux1")) ? ((!llllllllllllllllllIllIIIllllIIll.equals("colortex5") && !llllllllllllllllllIllIIIllllIIll.equals("gaux2")) ? ((!llllllllllllllllllIllIIIllllIIll.equals("colortex6") && !llllllllllllllllllIllIIIllllIIll.equals("gaux3")) ? ((!llllllllllllllllllIllIIIllllIIll.equals("colortex7") && !llllllllllllllllllIllIIIllllIIll.equals("gaux4")) ? -1 : 7) : 6) : 5) : 4) : 3) : 2) : 1) : 0;
    }
    
    public static void setProgramUniform2i(final String llllllllllllllllllIllIIlIIlIllII, final int llllllllllllllllllIllIIlIIlIIllI, final int llllllllllllllllllIllIIlIIlIIlIl) {
        final int llllllllllllllllllIllIIlIIlIlIIl = Shaders.programsID[Shaders.activeProgram];
        if (llllllllllllllllllIllIIlIIlIlIIl != 0) {
            final int llllllllllllllllllIllIIlIIlIlIII = ARBShaderObjects.glGetUniformLocationARB(llllllllllllllllllIllIIlIIlIlIIl, (CharSequence)llllllllllllllllllIllIIlIIlIllII);
            ARBShaderObjects.glUniform2iARB(llllllllllllllllllIllIIlIIlIlIII, llllllllllllllllllIllIIlIIlIIllI, llllllllllllllllllIllIIlIIlIIlIl);
            checkGLError(Shaders.programNames[Shaders.activeProgram], llllllllllllllllllIllIIlIIlIllII);
        }
    }
    
    public static void endLeash() {
        useProgram(16);
    }
    
    public static void storeConfig() {
        SMCLog.info("Save ShadersMod configuration.");
        if (Shaders.shadersConfig == null) {
            Shaders.shadersConfig = new PropertiesOrdered();
        }
        final EnumShaderOption[] llllllllllllllllllIllIllIlllIlII = EnumShaderOption.values();
        for (int llllllllllllllllllIllIllIlllIIll = 0; llllllllllllllllllIllIllIlllIIll < llllllllllllllllllIllIllIlllIlII.length; ++llllllllllllllllllIllIllIlllIIll) {
            final EnumShaderOption llllllllllllllllllIllIllIlllIIlI = llllllllllllllllllIllIllIlllIlII[llllllllllllllllllIllIllIlllIIll];
            final String llllllllllllllllllIllIllIlllIIIl = llllllllllllllllllIllIllIlllIIlI.getPropertyKey();
            final String llllllllllllllllllIllIllIlllIIII = getEnumShaderOption(llllllllllllllllllIllIllIlllIIlI);
            Shaders.shadersConfig.setProperty(llllllllllllllllllIllIllIlllIIIl, llllllllllllllllllIllIllIlllIIII);
        }
        try {
            final FileWriter llllllllllllllllllIllIllIllIllll = new FileWriter(Shaders.configFile);
            Shaders.shadersConfig.store(llllllllllllllllllIllIllIllIllll, null);
            llllllllllllllllllIllIllIllIllll.close();
        }
        catch (Exception llllllllllllllllllIllIllIllIlllI) {
            SMCLog.severe(String.valueOf(new StringBuilder("Error saving configuration: ").append(llllllllllllllllllIllIllIllIlllI.getClass().getName()).append(": ").append(llllllllllllllllllIllIllIllIlllI.getMessage())));
        }
    }
    
    public static void beginRenderPass(final int llllllllllllllllllIllIIIlIIIIlll, final float llllllllllllllllllIllIIIlIIIIllI, final long llllllllllllllllllIllIIIlIIIIlIl) {
        if (!Shaders.isShadowPass) {
            EXTFramebufferObject.glBindFramebufferEXT(36160, Shaders.dfb);
            GL11.glViewport(0, 0, Shaders.renderWidth, Shaders.renderHeight);
            Shaders.activeDrawBuffers = null;
            ShadersTex.bindNSTextures(Shaders.defaultTexture.getMultiTexID());
            useProgram(2);
            checkGLError("end beginRenderPass");
        }
    }
    
    public static void setCameraShadow(final float llllllllllllllllllIllIIIIIlllIII) {
        final Entity llllllllllllllllllIllIIIIlIIIlll = Shaders.mc.func_175606_aa();
        final double llllllllllllllllllIllIIIIlIIIllI = llllllllllllllllllIllIIIIlIIIlll.lastTickPosX + (llllllllllllllllllIllIIIIlIIIlll.posX - llllllllllllllllllIllIIIIlIIIlll.lastTickPosX) * llllllllllllllllllIllIIIIIlllIII;
        final double llllllllllllllllllIllIIIIlIIIlIl = llllllllllllllllllIllIIIIlIIIlll.lastTickPosY + (llllllllllllllllllIllIIIIlIIIlll.posY - llllllllllllllllllIllIIIIlIIIlll.lastTickPosY) * llllllllllllllllllIllIIIIIlllIII;
        final double llllllllllllllllllIllIIIIlIIIlII = llllllllllllllllllIllIIIIlIIIlll.lastTickPosZ + (llllllllllllllllllIllIIIIlIIIlll.posZ - llllllllllllllllllIllIIIIlIIIlll.lastTickPosZ) * llllllllllllllllllIllIIIIIlllIII;
        Shaders.cameraPositionX = llllllllllllllllllIllIIIIlIIIllI;
        Shaders.cameraPositionY = llllllllllllllllllIllIIIIlIIIlIl;
        Shaders.cameraPositionZ = llllllllllllllllllIllIIIIlIIIlII;
        GL11.glGetFloat(2983, (FloatBuffer)Shaders.projection.position(0));
        SMath.invertMat4FBFA((FloatBuffer)Shaders.projectionInverse.position(0), (FloatBuffer)Shaders.projection.position(0), Shaders.faProjectionInverse, Shaders.faProjection);
        Shaders.projection.position(0);
        Shaders.projectionInverse.position(0);
        GL11.glGetFloat(2982, (FloatBuffer)Shaders.modelView.position(0));
        SMath.invertMat4FBFA((FloatBuffer)Shaders.modelViewInverse.position(0), (FloatBuffer)Shaders.modelView.position(0), Shaders.faModelViewInverse, Shaders.faModelView);
        Shaders.modelView.position(0);
        Shaders.modelViewInverse.position(0);
        GL11.glViewport(0, 0, Shaders.shadowMapWidth, Shaders.shadowMapHeight);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        if (Shaders.shadowMapIsOrtho) {
            GL11.glOrtho((double)(-Shaders.shadowMapHalfPlane), (double)Shaders.shadowMapHalfPlane, (double)(-Shaders.shadowMapHalfPlane), (double)Shaders.shadowMapHalfPlane, 0.05000000074505806, 256.0);
        }
        else {
            GLU.gluPerspective(Shaders.shadowMapFOV, Shaders.shadowMapWidth / (float)Shaders.shadowMapHeight, 0.05f, 256.0f);
        }
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0f, 0.0f, -100.0f);
        GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
        Shaders.celestialAngle = Shaders.mc.theWorld.getCelestialAngle(llllllllllllllllllIllIIIIIlllIII);
        Shaders.sunAngle = ((Shaders.celestialAngle < 0.75f) ? (Shaders.celestialAngle + 0.25f) : (Shaders.celestialAngle - 0.75f));
        final float llllllllllllllllllIllIIIIlIIIIll = Shaders.celestialAngle * -360.0f;
        final float llllllllllllllllllIllIIIIlIIIIlI = (Shaders.shadowAngleInterval > 0.0f) ? (llllllllllllllllllIllIIIIlIIIIll % Shaders.shadowAngleInterval - Shaders.shadowAngleInterval * 0.5f) : 0.0f;
        if (Shaders.sunAngle <= 0.5) {
            GL11.glRotatef(llllllllllllllllllIllIIIIlIIIIll - llllllllllllllllllIllIIIIlIIIIlI, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(Shaders.sunPathRotation, 1.0f, 0.0f, 0.0f);
            Shaders.shadowAngle = Shaders.sunAngle;
        }
        else {
            GL11.glRotatef(llllllllllllllllllIllIIIIlIIIIll + 180.0f - llllllllllllllllllIllIIIIlIIIIlI, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(Shaders.sunPathRotation, 1.0f, 0.0f, 0.0f);
            Shaders.shadowAngle = Shaders.sunAngle - 0.5f;
        }
        if (Shaders.shadowMapIsOrtho) {
            final float llllllllllllllllllIllIIIIlIIIIIl = Shaders.shadowIntervalSize;
            final float llllllllllllllllllIllIIIIIllllll = llllllllllllllllllIllIIIIlIIIIIl / 2.0f;
            GL11.glTranslatef((float)llllllllllllllllllIllIIIIlIIIllI % llllllllllllllllllIllIIIIlIIIIIl - llllllllllllllllllIllIIIIIllllll, (float)llllllllllllllllllIllIIIIlIIIlIl % llllllllllllllllllIllIIIIlIIIIIl - llllllllllllllllllIllIIIIIllllll, (float)llllllllllllllllllIllIIIIlIIIlII % llllllllllllllllllIllIIIIlIIIIIl - llllllllllllllllllIllIIIIIllllll);
        }
        final float llllllllllllllllllIllIIIIlIIIIII = Shaders.sunAngle * 6.2831855f;
        final float llllllllllllllllllIllIIIIIlllllI = (float)Math.cos(llllllllllllllllllIllIIIIlIIIIII);
        final float llllllllllllllllllIllIIIIIllllIl = (float)Math.sin(llllllllllllllllllIllIIIIlIIIIII);
        final float llllllllllllllllllIllIIIIIllllII = Shaders.sunPathRotation * 6.2831855f;
        float llllllllllllllllllIllIIIIIlllIll = llllllllllllllllllIllIIIIIlllllI;
        float llllllllllllllllllIllIIIIIlllIlI = llllllllllllllllllIllIIIIIllllIl * (float)Math.cos(llllllllllllllllllIllIIIIIllllII);
        float llllllllllllllllllIllIIIIIlllIIl = llllllllllllllllllIllIIIIIllllIl * (float)Math.sin(llllllllllllllllllIllIIIIIllllII);
        if (Shaders.sunAngle > 0.5) {
            llllllllllllllllllIllIIIIIlllIll = -llllllllllllllllllIllIIIIIlllllI;
            llllllllllllllllllIllIIIIIlllIlI = -llllllllllllllllllIllIIIIIlllIlI;
            llllllllllllllllllIllIIIIIlllIIl = -llllllllllllllllllIllIIIIIlllIIl;
        }
        Shaders.shadowLightPositionVector[0] = llllllllllllllllllIllIIIIIlllIll;
        Shaders.shadowLightPositionVector[1] = llllllllllllllllllIllIIIIIlllIlI;
        Shaders.shadowLightPositionVector[2] = llllllllllllllllllIllIIIIIlllIIl;
        Shaders.shadowLightPositionVector[3] = 0.0f;
        GL11.glGetFloat(2983, (FloatBuffer)Shaders.shadowProjection.position(0));
        SMath.invertMat4FBFA((FloatBuffer)Shaders.shadowProjectionInverse.position(0), (FloatBuffer)Shaders.shadowProjection.position(0), Shaders.faShadowProjectionInverse, Shaders.faShadowProjection);
        Shaders.shadowProjection.position(0);
        Shaders.shadowProjectionInverse.position(0);
        GL11.glGetFloat(2982, (FloatBuffer)Shaders.shadowModelView.position(0));
        SMath.invertMat4FBFA((FloatBuffer)Shaders.shadowModelViewInverse.position(0), (FloatBuffer)Shaders.shadowModelView.position(0), Shaders.faShadowModelViewInverse, Shaders.faShadowModelView);
        Shaders.shadowModelView.position(0);
        Shaders.shadowModelViewInverse.position(0);
        setProgramUniformMatrix4ARB("gbufferProjection", false, Shaders.projection);
        setProgramUniformMatrix4ARB("gbufferProjectionInverse", false, Shaders.projectionInverse);
        setProgramUniformMatrix4ARB("gbufferPreviousProjection", false, Shaders.previousProjection);
        setProgramUniformMatrix4ARB("gbufferModelView", false, Shaders.modelView);
        setProgramUniformMatrix4ARB("gbufferModelViewInverse", false, Shaders.modelViewInverse);
        setProgramUniformMatrix4ARB("gbufferPreviousModelView", false, Shaders.previousModelView);
        setProgramUniformMatrix4ARB("shadowProjection", false, Shaders.shadowProjection);
        setProgramUniformMatrix4ARB("shadowProjectionInverse", false, Shaders.shadowProjectionInverse);
        setProgramUniformMatrix4ARB("shadowModelView", false, Shaders.shadowModelView);
        setProgramUniformMatrix4ARB("shadowModelViewInverse", false, Shaders.shadowModelViewInverse);
        Shaders.mc.gameSettings.thirdPersonView = 1;
        checkGLError("setCamera");
    }
    
    public static int checkGLError(final String llllllllllllllllllIllIlIIlIlllIl, final String llllllllllllllllllIllIlIIlIlllII, final String llllllllllllllllllIllIlIIlIllIll) {
        final int llllllllllllllllllIllIlIIlIllllI = GL11.glGetError();
        if (llllllllllllllllllIllIlIIlIllllI != 0) {
            System.err.format("GL error 0x%04x: %s at %s %s %s\n", llllllllllllllllllIllIlIIlIllllI, GLU.gluErrorString(llllllllllllllllllIllIlIIlIllllI), llllllllllllllllllIllIlIIlIlllIl, llllllllllllllllllIllIlIIlIlllII, llllllllllllllllllIllIlIIlIllIll);
        }
        return llllllllllllllllllIllIlIIlIllllI;
    }
    
    public static void setShaderPack(final String llllllllllllllllllIllIllIllIIlII) {
        Shaders.currentshadername = llllllllllllllllllIllIllIllIIlII;
        Shaders.shadersConfig.setProperty(EnumShaderOption.SHADER_PACK.getPropertyKey(), llllllllllllllllllIllIllIllIIlII);
        loadShaderPack();
    }
    
    public static void beginParticles() {
        useProgram(2);
    }
    
    public static void saveShaderPackOptions() {
        saveShaderPackOptions(Shaders.shaderPackOptions, Shaders.shaderPack);
    }
    
    public static boolean isDynamicHandLight() {
        return Shaders.shaderPackDynamicHandLight.isDefault() || Shaders.shaderPackDynamicHandLight.isTrue();
    }
    
    public static void endFPOverlay() {
    }
    
    public static void endClouds() {
        disableFog();
        popEntity();
        useProgram(Shaders.lightmapEnabled ? 3 : 2);
    }
    
    private static int setupProgram(final int llllllllllllllllllIllIIllllIlIll, final String llllllllllllllllllIllIIlllllIIlI, final String llllllllllllllllllIllIIllllIlIIl) {
        checkGLError("pre setupProgram");
        int llllllllllllllllllIllIIlllllIIII = ARBShaderObjects.glCreateProgramObjectARB();
        checkGLError("create");
        if (llllllllllllllllllIllIIlllllIIII != 0) {
            Shaders.progUseEntityAttrib = false;
            Shaders.progUseMidTexCoordAttrib = false;
            Shaders.progUseTangentAttrib = false;
            final int llllllllllllllllllIllIIllllIllll = createVertShader(llllllllllllllllllIllIIlllllIIlI);
            final int llllllllllllllllllIllIIllllIlllI = createFragShader(llllllllllllllllllIllIIllllIlIIl);
            checkGLError("create");
            if (llllllllllllllllllIllIIllllIllll == 0 && llllllllllllllllllIllIIllllIlllI == 0) {
                ARBShaderObjects.glDeleteObjectARB(llllllllllllllllllIllIIlllllIIII);
                llllllllllllllllllIllIIlllllIIII = 0;
            }
            else {
                if (llllllllllllllllllIllIIllllIllll != 0) {
                    ARBShaderObjects.glAttachObjectARB(llllllllllllllllllIllIIlllllIIII, llllllllllllllllllIllIIllllIllll);
                    checkGLError("attach");
                }
                if (llllllllllllllllllIllIIllllIlllI != 0) {
                    ARBShaderObjects.glAttachObjectARB(llllllllllllllllllIllIIlllllIIII, llllllllllllllllllIllIIllllIlllI);
                    checkGLError("attach");
                }
                if (Shaders.progUseEntityAttrib) {
                    ARBVertexShader.glBindAttribLocationARB(llllllllllllllllllIllIIlllllIIII, Shaders.entityAttrib, (CharSequence)"mc_Entity");
                    checkGLError("mc_Entity");
                }
                if (Shaders.progUseMidTexCoordAttrib) {
                    ARBVertexShader.glBindAttribLocationARB(llllllllllllllllllIllIIlllllIIII, Shaders.midTexCoordAttrib, (CharSequence)"mc_midTexCoord");
                    checkGLError("mc_midTexCoord");
                }
                if (Shaders.progUseTangentAttrib) {
                    ARBVertexShader.glBindAttribLocationARB(llllllllllllllllllIllIIlllllIIII, Shaders.tangentAttrib, (CharSequence)"at_tangent");
                    checkGLError("at_tangent");
                }
                ARBShaderObjects.glLinkProgramARB(llllllllllllllllllIllIIlllllIIII);
                if (GL20.glGetProgrami(llllllllllllllllllIllIIlllllIIII, 35714) != 1) {
                    SMCLog.severe(String.valueOf(new StringBuilder("Error linking program: ").append(llllllllllllllllllIllIIlllllIIII)));
                }
                printLogInfo(llllllllllllllllllIllIIlllllIIII, String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllllIllIIlllllIIlI)).append(", ").append(llllllllllllllllllIllIIllllIlIIl)));
                if (llllllllllllllllllIllIIllllIllll != 0) {
                    ARBShaderObjects.glDetachObjectARB(llllllllllllllllllIllIIlllllIIII, llllllllllllllllllIllIIllllIllll);
                    ARBShaderObjects.glDeleteObjectARB(llllllllllllllllllIllIIllllIllll);
                }
                if (llllllllllllllllllIllIIllllIlllI != 0) {
                    ARBShaderObjects.glDetachObjectARB(llllllllllllllllllIllIIlllllIIII, llllllllllllllllllIllIIllllIlllI);
                    ARBShaderObjects.glDeleteObjectARB(llllllllllllllllllIllIIllllIlllI);
                }
                Shaders.programsID[llllllllllllllllllIllIIllllIlIll] = llllllllllllllllllIllIIlllllIIII;
                useProgram(llllllllllllllllllIllIIllllIlIll);
                ARBShaderObjects.glValidateProgramARB(llllllllllllllllllIllIIlllllIIII);
                useProgram(0);
                printLogInfo(llllllllllllllllllIllIIlllllIIII, String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllllIllIIlllllIIlI)).append(", ").append(llllllllllllllllllIllIIllllIlIIl)));
                final int llllllllllllllllllIllIIllllIllIl = GL20.glGetProgrami(llllllllllllllllllIllIIlllllIIII, 35715);
                if (llllllllllllllllllIllIIllllIllIl != 1) {
                    final String llllllllllllllllllIllIIllllIllII = "\"";
                    printChatAndLogError(String.valueOf(new StringBuilder("[Shaders] Error: Invalid program ").append(llllllllllllllllllIllIIllllIllII).append(Shaders.programNames[llllllllllllllllllIllIIllllIlIll]).append(llllllllllllllllllIllIIllllIllII)));
                    ARBShaderObjects.glDeleteObjectARB(llllllllllllllllllIllIIlllllIIII);
                    llllllllllllllllllIllIIlllllIIII = 0;
                }
            }
        }
        return llllllllllllllllllIllIIlllllIIII;
    }
    
    public static void init() {
        boolean llllllllllllllllllIllIlIIIllIIlI = false;
        if (!Shaders.isInitializedOnce) {
            Shaders.isInitializedOnce = true;
            final boolean llllllllllllllllllIllIlIIIllIIll = true;
        }
        else {
            llllllllllllllllllIllIlIIIllIIlI = false;
        }
        if (!Shaders.isShaderPackInitialized) {
            checkGLError("Shaders.init pre");
            if (getShaderPackName() != null) {}
            if (!Shaders.capabilities.OpenGL20) {
                printChatAndLogError("No OpenGL 2.0");
            }
            if (!Shaders.capabilities.GL_EXT_framebuffer_object) {
                printChatAndLogError("No EXT_framebuffer_object");
            }
            Shaders.dfbDrawBuffers.position(0).limit(8);
            Shaders.dfbColorTextures.position(0).limit(16);
            Shaders.dfbDepthTextures.position(0).limit(3);
            Shaders.sfbDrawBuffers.position(0).limit(8);
            Shaders.sfbDepthTextures.position(0).limit(2);
            Shaders.sfbColorTextures.position(0).limit(8);
            Shaders.usedColorBuffers = 4;
            Shaders.usedDepthBuffers = 1;
            Shaders.usedShadowColorBuffers = 0;
            Shaders.usedShadowDepthBuffers = 0;
            Shaders.usedColorAttachs = 1;
            Shaders.usedDrawBuffers = 1;
            Arrays.fill(Shaders.gbuffersFormat, 6408);
            Arrays.fill(Shaders.shadowHardwareFilteringEnabled, false);
            Arrays.fill(Shaders.shadowMipmapEnabled, false);
            Arrays.fill(Shaders.shadowFilterNearest, false);
            Arrays.fill(Shaders.shadowColorMipmapEnabled, false);
            Arrays.fill(Shaders.shadowColorFilterNearest, false);
            Shaders.centerDepthSmoothEnabled = false;
            Shaders.noiseTextureEnabled = false;
            Shaders.sunPathRotation = 0.0f;
            Shaders.shadowIntervalSize = 2.0f;
            Shaders.aoLevel = 0.8f;
            Shaders.blockAoLight = 1.0f - Shaders.aoLevel;
            Shaders.useEntityAttrib = false;
            Shaders.useMidTexCoordAttrib = false;
            Shaders.useMultiTexCoord3Attrib = false;
            Shaders.useTangentAttrib = false;
            Shaders.waterShadowEnabled = false;
            Shaders.updateChunksErrorRecorded = false;
            updateBlockLightLevel();
            final ShaderProfile llllllllllllllllllIllIlIIIllIIIl = ShaderUtils.detectProfile(Shaders.shaderPackProfiles, Shaders.shaderPackOptions, false);
            String llllllllllllllllllIllIlIIIllIIII = "";
            if (Shaders.currentWorld != null) {
                final int llllllllllllllllllIllIlIIIlIllll = Shaders.currentWorld.provider.getDimensionId();
                if (Shaders.shaderPackDimensions.contains(llllllllllllllllllIllIlIIIlIllll)) {
                    llllllllllllllllllIllIlIIIllIIII = String.valueOf(new StringBuilder("world").append(llllllllllllllllllIllIlIIIlIllll).append("/"));
                }
            }
            if (Shaders.saveFinalShaders) {
                clearDirectory(new File(Shaders.shaderpacksdir, "debug"));
            }
            for (int llllllllllllllllllIllIlIIIlIlllI = 0; llllllllllllllllllIllIlIIIlIlllI < 33; ++llllllllllllllllllIllIlIIIlIlllI) {
                String llllllllllllllllllIllIlIIIlIlIll = Shaders.programNames[llllllllllllllllllIllIlIIIlIlllI];
                if (llllllllllllllllllIllIlIIIlIlIll.equals("")) {
                    Shaders.programsID[llllllllllllllllllIllIlIIIlIlllI] = (Shaders.programsRef[llllllllllllllllllIllIlIIIlIlllI] = 0);
                    Shaders.programsDrawBufSettings[llllllllllllllllllIllIlIIIlIlllI] = null;
                    Shaders.programsColorAtmSettings[llllllllllllllllllIllIlIIIlIlllI] = null;
                    Shaders.programsCompositeMipmapSetting[llllllllllllllllllIllIlIIIlIlllI] = 0;
                }
                else {
                    Shaders.newDrawBufSetting = null;
                    Shaders.newColorAtmSetting = null;
                    Shaders.newCompositeMipmapSetting = 0;
                    String llllllllllllllllllIllIlIIIlIlIlI = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllllIllIlIIIllIIII)).append(llllllllllllllllllIllIlIIIlIlIll));
                    if (llllllllllllllllllIllIlIIIllIIIl != null && llllllllllllllllllIllIlIIIllIIIl.isProgramDisabled(llllllllllllllllllIllIlIIIlIlIlI)) {
                        SMCLog.info(String.valueOf(new StringBuilder("Program disabled: ").append(llllllllllllllllllIllIlIIIlIlIlI)));
                        llllllllllllllllllIllIlIIIlIlIll = "<disabled>";
                        llllllllllllllllllIllIlIIIlIlIlI = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllllIllIlIIIllIIII)).append(llllllllllllllllllIllIlIIIlIlIll));
                    }
                    final String llllllllllllllllllIllIlIIIlIllIl = String.valueOf(new StringBuilder("/shaders/").append(llllllllllllllllllIllIlIIIlIlIlI));
                    final int llllllllllllllllllIllIlIIIlIlIIl = setupProgram(llllllllllllllllllIllIlIIIlIlllI, String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllllIllIlIIIlIllIl)).append(".vsh")), String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllllIllIlIIIlIllIl)).append(".fsh")));
                    if (llllllllllllllllllIllIlIIIlIlIIl > 0) {
                        SMCLog.info(String.valueOf(new StringBuilder("Program loaded: ").append(llllllllllllllllllIllIlIIIlIlIlI)));
                    }
                    Shaders.programsID[llllllllllllllllllIllIlIIIlIlllI] = (Shaders.programsRef[llllllllllllllllllIllIlIIIlIlllI] = llllllllllllllllllIllIlIIIlIlIIl);
                    Shaders.programsDrawBufSettings[llllllllllllllllllIllIlIIIlIlllI] = ((llllllllllllllllllIllIlIIIlIlIIl != 0) ? Shaders.newDrawBufSetting : null);
                    Shaders.programsColorAtmSettings[llllllllllllllllllIllIlIIIlIlllI] = ((llllllllllllllllllIllIlIIIlIlIIl != 0) ? Shaders.newColorAtmSetting : null);
                    Shaders.programsCompositeMipmapSetting[llllllllllllllllllIllIlIIIlIlllI] = ((llllllllllllllllllIllIlIIIlIlIIl != 0) ? Shaders.newCompositeMipmapSetting : 0);
                }
            }
            int llllllllllllllllllIllIlIIIlIlllI = GL11.glGetInteger(34852);
            new HashMap();
            for (int llllllllllllllllllIllIlIIIlIlIII = 0; llllllllllllllllllIllIlIIIlIlIII < 33; ++llllllllllllllllllIllIlIIIlIlIII) {
                Arrays.fill(Shaders.programsToggleColorTextures[llllllllllllllllllIllIlIIIlIlIII], false);
                if (llllllllllllllllllIllIlIIIlIlIII == 29) {
                    Shaders.programsDrawBuffers[llllllllllllllllllIllIlIIIlIlIII] = null;
                }
                else if (Shaders.programsID[llllllllllllllllllIllIlIIIlIlIII] == 0) {
                    if (llllllllllllllllllIllIlIIIlIlIII == 30) {
                        Shaders.programsDrawBuffers[llllllllllllllllllIllIlIIIlIlIII] = Shaders.drawBuffersNone;
                    }
                    else {
                        Shaders.programsDrawBuffers[llllllllllllllllllIllIlIIIlIlIII] = Shaders.drawBuffersColorAtt0;
                    }
                }
                else {
                    final String llllllllllllllllllIllIlIIIlIllII = Shaders.programsDrawBufSettings[llllllllllllllllllIllIlIIIlIlIII];
                    if (llllllllllllllllllIllIlIIIlIllII != null) {
                        final IntBuffer llllllllllllllllllIllIlIIIlIIlll = Shaders.drawBuffersBuffer[llllllllllllllllllIllIlIIIlIlIII];
                        int llllllllllllllllllIllIlIIIlIIllI = llllllllllllllllllIllIlIIIlIllII.length();
                        if (llllllllllllllllllIllIlIIIlIIllI > Shaders.usedDrawBuffers) {
                            Shaders.usedDrawBuffers = llllllllllllllllllIllIlIIIlIIllI;
                        }
                        if (llllllllllllllllllIllIlIIIlIIllI > llllllllllllllllllIllIlIIIlIlllI) {
                            llllllllllllllllllIllIlIIIlIIllI = llllllllllllllllllIllIlIIIlIlllI;
                        }
                        (Shaders.programsDrawBuffers[llllllllllllllllllIllIlIIIlIlIII] = llllllllllllllllllIllIlIIIlIIlll).limit(llllllllllllllllllIllIlIIIlIIllI);
                        for (int llllllllllllllllllIllIlIIIlIIlIl = 0; llllllllllllllllllIllIlIIIlIIlIl < llllllllllllllllllIllIlIIIlIIllI; ++llllllllllllllllllIllIlIIIlIIlIl) {
                            int llllllllllllllllllIllIlIIIlIIlII = 0;
                            if (llllllllllllllllllIllIlIIIlIllII.length() > llllllllllllllllllIllIlIIIlIIlIl) {
                                final int llllllllllllllllllIllIlIIIlIIIll = llllllllllllllllllIllIlIIIlIllII.charAt(llllllllllllllllllIllIlIIIlIIlIl) - '0';
                                if (llllllllllllllllllIllIlIIIlIlIII != 30) {
                                    if (llllllllllllllllllIllIlIIIlIIIll >= 0 && llllllllllllllllllIllIlIIIlIIIll <= 7) {
                                        Shaders.programsToggleColorTextures[llllllllllllllllllIllIlIIIlIlIII][llllllllllllllllllIllIlIIIlIIIll] = true;
                                        llllllllllllllllllIllIlIIIlIIlII = llllllllllllllllllIllIlIIIlIIIll + 36064;
                                        if (llllllllllllllllllIllIlIIIlIIIll > Shaders.usedColorAttachs) {
                                            Shaders.usedColorAttachs = llllllllllllllllllIllIlIIIlIIIll;
                                        }
                                        if (llllllllllllllllllIllIlIIIlIIIll > Shaders.usedColorBuffers) {
                                            Shaders.usedColorBuffers = llllllllllllllllllIllIlIIIlIIIll;
                                        }
                                    }
                                }
                                else if (llllllllllllllllllIllIlIIIlIIIll >= 0 && llllllllllllllllllIllIlIIIlIIIll <= 1) {
                                    llllllllllllllllllIllIlIIIlIIlII = llllllllllllllllllIllIlIIIlIIIll + 36064;
                                    if (llllllllllllllllllIllIlIIIlIIIll > Shaders.usedShadowColorBuffers) {
                                        Shaders.usedShadowColorBuffers = llllllllllllllllllIllIlIIIlIIIll;
                                    }
                                }
                            }
                            llllllllllllllllllIllIlIIIlIIlll.put(llllllllllllllllllIllIlIIIlIIlIl, llllllllllllllllllIllIlIIIlIIlII);
                        }
                    }
                    else if (llllllllllllllllllIllIlIIIlIlIII != 30 && llllllllllllllllllIllIlIIIlIlIII != 31 && llllllllllllllllllIllIlIIIlIlIII != 32) {
                        Shaders.programsDrawBuffers[llllllllllllllllllIllIlIIIlIlIII] = Shaders.dfbDrawBuffers;
                        Shaders.usedDrawBuffers = Shaders.usedColorBuffers;
                        Arrays.fill(Shaders.programsToggleColorTextures[llllllllllllllllllIllIlIIIlIlIII], 0, Shaders.usedColorBuffers, true);
                    }
                    else {
                        Shaders.programsDrawBuffers[llllllllllllllllllIllIlIIIlIlIII] = Shaders.sfbDrawBuffers;
                    }
                }
            }
            Shaders.usedColorAttachs = Shaders.usedColorBuffers;
            Shaders.shadowPassInterval = ((Shaders.usedShadowDepthBuffers > 0) ? 1 : 0);
            Shaders.shouldSkipDefaultShadow = (Shaders.usedShadowDepthBuffers > 0);
            SMCLog.info(String.valueOf(new StringBuilder("usedColorBuffers: ").append(Shaders.usedColorBuffers)));
            SMCLog.info(String.valueOf(new StringBuilder("usedDepthBuffers: ").append(Shaders.usedDepthBuffers)));
            SMCLog.info(String.valueOf(new StringBuilder("usedShadowColorBuffers: ").append(Shaders.usedShadowColorBuffers)));
            SMCLog.info(String.valueOf(new StringBuilder("usedShadowDepthBuffers: ").append(Shaders.usedShadowDepthBuffers)));
            SMCLog.info(String.valueOf(new StringBuilder("usedColorAttachs: ").append(Shaders.usedColorAttachs)));
            SMCLog.info(String.valueOf(new StringBuilder("usedDrawBuffers: ").append(Shaders.usedDrawBuffers)));
            Shaders.dfbDrawBuffers.position(0).limit(Shaders.usedDrawBuffers);
            Shaders.dfbColorTextures.position(0).limit(Shaders.usedColorBuffers * 2);
            for (int llllllllllllllllllIllIlIIIlIlIII = 0; llllllllllllllllllIllIlIIIlIlIII < Shaders.usedDrawBuffers; ++llllllllllllllllllIllIlIIIlIlIII) {
                Shaders.dfbDrawBuffers.put(llllllllllllllllllIllIlIIIlIlIII, 36064 + llllllllllllllllllIllIlIIIlIlIII);
            }
            if (Shaders.usedDrawBuffers > llllllllllllllllllIllIlIIIlIlllI) {
                printChatAndLogError(String.valueOf(new StringBuilder("[Shaders] Error: Not enough draw buffers, needed: ").append(Shaders.usedDrawBuffers).append(", available: ").append(llllllllllllllllllIllIlIIIlIlllI)));
            }
            Shaders.sfbDrawBuffers.position(0).limit(Shaders.usedShadowColorBuffers);
            for (int llllllllllllllllllIllIlIIIlIlIII = 0; llllllllllllllllllIllIlIIIlIlIII < Shaders.usedShadowColorBuffers; ++llllllllllllllllllIllIlIIIlIlIII) {
                Shaders.sfbDrawBuffers.put(llllllllllllllllllIllIlIIIlIlIII, 36064 + llllllllllllllllllIllIlIIIlIlIII);
            }
            for (int llllllllllllllllllIllIlIIIlIlIII = 0; llllllllllllllllllIllIlIIIlIlIII < 33; ++llllllllllllllllllIllIlIIIlIlIII) {
                int llllllllllllllllllIllIlIIIlIIIlI;
                for (llllllllllllllllllIllIlIIIlIIIlI = llllllllllllllllllIllIlIIIlIlIII; Shaders.programsID[llllllllllllllllllIllIlIIIlIIIlI] == 0 && Shaders.programBackups[llllllllllllllllllIllIlIIIlIIIlI] != llllllllllllllllllIllIlIIIlIIIlI; llllllllllllllllllIllIlIIIlIIIlI = Shaders.programBackups[llllllllllllllllllIllIlIIIlIIIlI]) {}
                if (llllllllllllllllllIllIlIIIlIIIlI != llllllllllllllllllIllIlIIIlIlIII && llllllllllllllllllIllIlIIIlIlIII != 30) {
                    Shaders.programsID[llllllllllllllllllIllIlIIIlIlIII] = Shaders.programsID[llllllllllllllllllIllIlIIIlIIIlI];
                    Shaders.programsDrawBufSettings[llllllllllllllllllIllIlIIIlIlIII] = Shaders.programsDrawBufSettings[llllllllllllllllllIllIlIIIlIIIlI];
                    Shaders.programsDrawBuffers[llllllllllllllllllIllIlIIIlIlIII] = Shaders.programsDrawBuffers[llllllllllllllllllIllIlIIIlIIIlI];
                }
            }
            resize();
            resizeShadow();
            if (Shaders.noiseTextureEnabled) {
                setupNoiseTexture();
            }
            if (Shaders.defaultTexture == null) {
                Shaders.defaultTexture = ShadersTex.createDefaultTexture();
            }
            GlStateManager.pushMatrix();
            GlStateManager.rotate(-90.0f, 0.0f, 1.0f, 0.0f);
            preCelestialRotate();
            postCelestialRotate();
            GlStateManager.popMatrix();
            Shaders.isShaderPackInitialized = true;
            loadEntityDataMap();
            resetDisplayList();
            if (!llllllllllllllllllIllIlIIIllIIlI) {}
            checkGLError("Shaders.init");
        }
    }
    
    public static void endProjectRedHalo() {
        if (Shaders.isRenderingWorld) {
            useProgram(3);
        }
    }
    
    private static void resizeShadow() {
        Shaders.needResizeShadow = false;
        Shaders.shadowMapWidth = Math.round(Shaders.spShadowMapWidth * Shaders.configShadowResMul);
        Shaders.shadowMapHeight = Math.round(Shaders.spShadowMapHeight * Shaders.configShadowResMul);
        setupShadowFrameBuffer();
    }
    
    public static void endWeather() {
        GlStateManager.disableBlend();
        useProgram(3);
    }
    
    static {
        ProgramShadowCutout = 32;
        MaxShadowColorBuffers = 8;
        ProgramDamagedBlock = 11;
        MaxColorBuffers = 8;
        ProgramComposite7 = 28;
        ProgramShadowSolid = 31;
        ProgramShadow = 30;
        ProgramBeaconBeam = 14;
        ProgramSpiderEyes = 18;
        ProgramTextured = 2;
        ProgramFinal = 29;
        ProgramComposite = 21;
        enableShadersOption = true;
        ProgramClouds = 6;
        ProgramWater = 12;
        ProgramBlock = 13;
        MaxCompositePasses = 8;
        ProgramComposite5 = 26;
        MaxShadowDepthBuffers = 2;
        ProgramBasic = 1;
        ProgramSkyBasic = 4;
        ProgramTerrainCutoutMip = 9;
        ProgramComposite4 = 25;
        enableShadersDebug = true;
        ProgramWeather = 20;
        ProgramComposite1 = 22;
        ProgramItem = 15;
        ProgramCount = 33;
        ProgramTexturedLit = 3;
        ProgramNone = 0;
        ProgramEntities = 16;
        ProgramArmorGlint = 17;
        ProgramComposite6 = 27;
        ProgramTerrainSolid = 8;
        ProgramSkyTextured = 5;
        ProgramTerrainCutout = 10;
        MaxDrawBuffers = 8;
        ProgramHand = 19;
        ProgramTerrain = 7;
        ProgramComposite2 = 23;
        texMinFilRange = 3;
        ProgramComposite3 = 24;
        MaxDepthBuffers = 3;
        bigBufferSize = 2196;
        texMagFilRange = 2;
        Shaders.mc = Minecraft.getMinecraft();
        Shaders.isInitializedOnce = false;
        Shaders.isShaderPackInitialized = false;
        Shaders.hasGlGenMipmap = false;
        Shaders.hasForge = false;
        Shaders.numberResetDisplayList = 0;
        Shaders.needResetModels = false;
        Shaders.renderDisplayWidth = 0;
        Shaders.renderDisplayHeight = 0;
        Shaders.renderWidth = 0;
        Shaders.renderHeight = 0;
        Shaders.isRenderingWorld = false;
        Shaders.isRenderingSky = false;
        Shaders.isCompositeRendered = false;
        Shaders.isRenderingDfb = false;
        Shaders.isShadowPass = false;
        Shaders.renderItemPass1DepthMask = false;
        Shaders.sunPosition = new float[4];
        Shaders.moonPosition = new float[4];
        Shaders.shadowLightPosition = new float[4];
        Shaders.upPosition = new float[4];
        Shaders.shadowLightPositionVector = new float[4];
        Shaders.upPosModelView = new float[] { 0.0f, 100.0f, 0.0f, 0.0f };
        Shaders.sunPosModelView = new float[] { 0.0f, 100.0f, 0.0f, 0.0f };
        Shaders.moonPosModelView = new float[] { 0.0f, -100.0f, 0.0f, 0.0f };
        Shaders.tempMat = new float[16];
        Shaders.worldTime = 0L;
        Shaders.lastWorldTime = 0L;
        Shaders.diffWorldTime = 0L;
        Shaders.celestialAngle = 0.0f;
        Shaders.sunAngle = 0.0f;
        Shaders.shadowAngle = 0.0f;
        Shaders.moonPhase = 0;
        Shaders.systemTime = 0L;
        Shaders.lastSystemTime = 0L;
        Shaders.diffSystemTime = 0L;
        Shaders.frameCounter = 0;
        Shaders.frameTimeCounter = 0.0f;
        Shaders.systemTimeInt32 = 0;
        Shaders.rainStrength = 0.0f;
        Shaders.wetness = 0.0f;
        Shaders.wetnessHalfLife = 600.0f;
        Shaders.drynessHalfLife = 200.0f;
        Shaders.eyeBrightnessHalflife = 10.0f;
        Shaders.usewetness = false;
        Shaders.isEyeInWater = 0;
        Shaders.eyeBrightness = 0;
        Shaders.eyeBrightnessFadeX = 0.0f;
        Shaders.eyeBrightnessFadeY = 0.0f;
        Shaders.eyePosY = 0.0f;
        Shaders.centerDepth = 0.0f;
        Shaders.centerDepthSmooth = 0.0f;
        Shaders.centerDepthSmoothHalflife = 1.0f;
        Shaders.centerDepthSmoothEnabled = false;
        Shaders.superSamplingLevel = 1;
        Shaders.updateChunksErrorRecorded = false;
        Shaders.lightmapEnabled = false;
        Shaders.fogEnabled = true;
        Shaders.entityAttrib = 10;
        Shaders.midTexCoordAttrib = 11;
        Shaders.tangentAttrib = 12;
        Shaders.useEntityAttrib = false;
        Shaders.useMidTexCoordAttrib = false;
        Shaders.useMultiTexCoord3Attrib = false;
        Shaders.useTangentAttrib = false;
        Shaders.progUseEntityAttrib = false;
        Shaders.progUseMidTexCoordAttrib = false;
        Shaders.progUseTangentAttrib = false;
        Shaders.atlasSizeX = 0;
        Shaders.atlasSizeY = 0;
        Shaders.uniformEntityColor = new ShaderUniformFloat4("entityColor");
        Shaders.uniformEntityId = new ShaderUniformInt("entityId");
        Shaders.uniformBlockEntityId = new ShaderUniformInt("blockEntityId");
        Shaders.shadowPassInterval = 0;
        Shaders.needResizeShadow = false;
        Shaders.shadowMapWidth = 1024;
        Shaders.shadowMapHeight = 1024;
        Shaders.spShadowMapWidth = 1024;
        Shaders.spShadowMapHeight = 1024;
        Shaders.shadowMapFOV = 90.0f;
        Shaders.shadowMapHalfPlane = 160.0f;
        Shaders.shadowMapIsOrtho = true;
        Shaders.shadowPassCounter = 0;
        Shaders.shouldSkipDefaultShadow = false;
        Shaders.waterShadowEnabled = false;
        Shaders.usedColorBuffers = 0;
        Shaders.usedDepthBuffers = 0;
        Shaders.usedShadowColorBuffers = 0;
        Shaders.usedShadowDepthBuffers = 0;
        Shaders.usedColorAttachs = 0;
        Shaders.usedDrawBuffers = 0;
        Shaders.dfb = 0;
        Shaders.sfb = 0;
        Shaders.gbuffersFormat = new int[8];
        Shaders.activeProgram = 0;
        programNames = new String[] { "", "gbuffers_basic", "gbuffers_textured", "gbuffers_textured_lit", "gbuffers_skybasic", "gbuffers_skytextured", "gbuffers_clouds", "gbuffers_terrain", "gbuffers_terrain_solid", "gbuffers_terrain_cutout_mip", "gbuffers_terrain_cutout", "gbuffers_damagedblock", "gbuffers_water", "gbuffers_block", "gbuffers_beaconbeam", "gbuffers_item", "gbuffers_entities", "gbuffers_armor_glint", "gbuffers_spidereyes", "gbuffers_hand", "gbuffers_weather", "composite", "composite1", "composite2", "composite3", "composite4", "composite5", "composite6", "composite7", "final", "shadow", "shadow_solid", "shadow_cutout" };
        programBackups = new int[] { 0, 0, 1, 2, 1, 2, 2, 3, 7, 7, 7, 7, 7, 7, 2, 3, 3, 2, 2, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 30, 30 };
        Shaders.programsID = new int[33];
        Shaders.programsRef = new int[33];
        Shaders.programIDCopyDepth = 0;
        Shaders.programsDrawBufSettings = new String[33];
        Shaders.newDrawBufSetting = null;
        Shaders.programsDrawBuffers = new IntBuffer[33];
        Shaders.activeDrawBuffers = null;
        Shaders.programsColorAtmSettings = new String[33];
        Shaders.newColorAtmSetting = null;
        Shaders.activeColorAtmSettings = null;
        Shaders.programsCompositeMipmapSetting = new int[33];
        Shaders.newCompositeMipmapSetting = 0;
        Shaders.activeCompositeMipmapSetting = 0;
        Shaders.loadedShaders = null;
        Shaders.shadersConfig = null;
        Shaders.defaultTexture = null;
        Shaders.normalMapEnabled = false;
        Shaders.shadowHardwareFilteringEnabled = new boolean[2];
        Shaders.shadowMipmapEnabled = new boolean[2];
        Shaders.shadowFilterNearest = new boolean[2];
        Shaders.shadowColorMipmapEnabled = new boolean[8];
        Shaders.shadowColorFilterNearest = new boolean[8];
        Shaders.configTweakBlockDamage = true;
        Shaders.configCloudShadow = true;
        Shaders.configHandDepthMul = 0.125f;
        Shaders.configRenderResMul = 1.0f;
        Shaders.configShadowResMul = 1.0f;
        Shaders.configTexMinFilB = 0;
        Shaders.configTexMinFilN = 0;
        Shaders.configTexMinFilS = 0;
        Shaders.configTexMagFilB = 0;
        Shaders.configTexMagFilN = 0;
        Shaders.configTexMagFilS = 0;
        Shaders.configShadowClipFrustrum = true;
        Shaders.configNormalMap = true;
        Shaders.configSpecularMap = true;
        Shaders.configOldLighting = new PropertyDefaultTrueFalse("oldLighting", "Classic Lighting", 2);
        Shaders.configAntialiasingLevel = 0;
        texMinFilDesc = new String[] { "Nearest", "Nearest-Nearest", "Nearest-Linear" };
        texMagFilDesc = new String[] { "Nearest", "Linear" };
        texMinFilValue = new int[] { 9728, 9984, 9986 };
        texMagFilValue = new int[] { 9728, 9729 };
        Shaders.shaderPack = null;
        Shaders.shaderPackLoaded = false;
        Shaders.packNameNone = "OFF";
        Shaders.packNameDefault = "(internal)";
        Shaders.shaderpacksdirname = "shaderpacks";
        Shaders.optionsfilename = "optionsshaders.txt";
        Shaders.shadersdir = new File(Minecraft.getMinecraft().mcDataDir, "shaders");
        Shaders.shaderpacksdir = new File(Minecraft.getMinecraft().mcDataDir, Shaders.shaderpacksdirname);
        Shaders.configFile = new File(Minecraft.getMinecraft().mcDataDir, Shaders.optionsfilename);
        Shaders.shaderPackOptions = null;
        Shaders.shaderPackProfiles = null;
        Shaders.shaderPackGuiScreens = null;
        Shaders.shaderPackClouds = new PropertyDefaultFastFancyOff("clouds", "Clouds", 0);
        Shaders.shaderPackOldLighting = new PropertyDefaultTrueFalse("oldLighting", "Classic Lighting", 0);
        Shaders.shaderPackDynamicHandLight = new PropertyDefaultTrueFalse("dynamicHandLight", "Dynamic Hand Light", 0);
        Shaders.shaderPackResources = new HashMap<String, String>();
        Shaders.currentWorld = null;
        Shaders.shaderPackDimensions = new ArrayList<Integer>();
        saveFinalShaders = System.getProperty("shaders.debug.save", "false").equals("true");
        Shaders.blockLightLevel05 = 0.5f;
        Shaders.blockLightLevel06 = 0.6f;
        Shaders.blockLightLevel08 = 0.8f;
        Shaders.aoLevel = 0.8f;
        Shaders.blockAoLight = 1.0f - Shaders.aoLevel;
        Shaders.sunPathRotation = 0.0f;
        Shaders.shadowAngleInterval = 0.0f;
        Shaders.fogMode = 0;
        Shaders.shadowIntervalSize = 2.0f;
        Shaders.terrainIconSize = 16;
        Shaders.terrainTextureSize = new int[2];
        Shaders.noiseTextureEnabled = false;
        Shaders.noiseTextureResolution = 256;
        dfbColorTexturesA = new int[16];
        colorTexturesToggle = new int[8];
        colorTextureTextureImageUnit = new int[] { 0, 1, 2, 3, 7, 8, 9, 10 };
        programsToggleColorTextures = new boolean[33][8];
        bigBuffer = (ByteBuffer)BufferUtils.createByteBuffer(2196).limit(0);
        faProjection = new float[16];
        faProjectionInverse = new float[16];
        faModelView = new float[16];
        faModelViewInverse = new float[16];
        faShadowProjection = new float[16];
        faShadowProjectionInverse = new float[16];
        faShadowModelView = new float[16];
        faShadowModelViewInverse = new float[16];
        projection = nextFloatBuffer(16);
        projectionInverse = nextFloatBuffer(16);
        modelView = nextFloatBuffer(16);
        modelViewInverse = nextFloatBuffer(16);
        shadowProjection = nextFloatBuffer(16);
        shadowProjectionInverse = nextFloatBuffer(16);
        shadowModelView = nextFloatBuffer(16);
        shadowModelViewInverse = nextFloatBuffer(16);
        previousProjection = nextFloatBuffer(16);
        previousModelView = nextFloatBuffer(16);
        tempMatrixDirectBuffer = nextFloatBuffer(16);
        tempDirectFloatBuffer = nextFloatBuffer(16);
        dfbColorTextures = nextIntBuffer(16);
        dfbDepthTextures = nextIntBuffer(3);
        sfbColorTextures = nextIntBuffer(8);
        sfbDepthTextures = nextIntBuffer(2);
        dfbDrawBuffers = nextIntBuffer(8);
        sfbDrawBuffers = nextIntBuffer(8);
        drawBuffersNone = nextIntBuffer(8);
        drawBuffersAll = nextIntBuffer(8);
        drawBuffersClear0 = nextIntBuffer(8);
        drawBuffersClear1 = nextIntBuffer(8);
        drawBuffersClearColor = nextIntBuffer(8);
        drawBuffersColorAtt0 = nextIntBuffer(8);
        drawBuffersBuffer = nextIntBufferArray(33, 8);
        Shaders.drawBuffersNone.limit(0);
        Shaders.drawBuffersColorAtt0.put(36064).position(0).limit(1);
        gbufferFormatPattern = Pattern.compile("[ \t]*const[ \t]*int[ \t]*(\\w+)Format[ \t]*=[ \t]*([RGBA81632FUI_SNORM]*)[ \t]*;.*");
        gbufferMipmapEnabledPattern = Pattern.compile("[ \t]*const[ \t]*bool[ \t]*(\\w+)MipmapEnabled[ \t]*=[ \t]*true[ \t]*;.*");
        formatNames = new String[] { "R8", "RG8", "RGB8", "RGBA8", "R8_SNORM", "RG8_SNORM", "RGB8_SNORM", "RGBA8_SNORM", "R16", "RG16", "RGB16", "RGBA16", "R16_SNORM", "RG16_SNORM", "RGB16_SNORM", "RGBA16_SNORM", "R32F", "RG32F", "RGB32F", "RGBA32F", "R32I", "RG32I", "RGB32I", "RGBA32I", "R32UI", "RG32UI", "RGB32UI", "RGBA32UI" };
        formatIds = new int[] { 33321, 33323, 32849, 32856, 36756, 36757, 36758, 36759, 33322, 33324, 32852, 32859, 36760, 36761, 36762, 36763, 33326, 33328, 34837, 34836, 33333, 33339, 36227, 36226, 33334, 33340, 36209, 36208 };
        patternLoadEntityDataMap = Pattern.compile("\\s*([\\w:]+)\\s*=\\s*([-]?\\d+)\\s*");
        Shaders.entityData = new int[32];
        Shaders.entityDataIndex = 0;
    }
    
    public static void enableFog() {
        Shaders.fogEnabled = true;
        setProgramUniform1i("fogMode", Shaders.fogMode);
    }
    
    public static void beginEntities() {
        if (Shaders.isRenderingWorld) {
            useProgram(16);
            resetDisplayListModels();
        }
    }
    
    public static void applyHandDepth() {
        if (Shaders.configHandDepthMul != 1.0) {
            GL11.glScaled(1.0, 1.0, (double)Shaders.configHandDepthMul);
        }
    }
    
    public static boolean isProgramPath(String llllllllllllllllllIlIlllIllIIlll) {
        if (llllllllllllllllllIlIlllIllIIlll == null) {
            return false;
        }
        if (((String)llllllllllllllllllIlIlllIllIIlll).length() <= 0) {
            return false;
        }
        final int llllllllllllllllllIlIlllIllIlIII = ((String)llllllllllllllllllIlIlllIllIIlll).lastIndexOf("/");
        if (llllllllllllllllllIlIlllIllIlIII >= 0) {
            llllllllllllllllllIlIlllIllIIlll = ((String)llllllllllllllllllIlIlllIllIIlll).substring(llllllllllllllllllIlIlllIllIlIII + 1);
        }
        return Arrays.asList(Shaders.programNames).contains(llllllllllllllllllIlIlllIllIIlll);
    }
    
    public static void beginWeather() {
        if (!Shaders.isShadowPass) {
            if (Shaders.usedDepthBuffers >= 3) {
                GlStateManager.setActiveTexture(33996);
                GL11.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, Shaders.renderWidth, Shaders.renderHeight);
                GlStateManager.setActiveTexture(33984);
            }
            GlStateManager.enableDepth();
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(770, 771);
            GlStateManager.enableAlpha();
            useProgram(20);
        }
    }
    
    public static int checkGLError(final String llllllllllllllllllIllIlIIlllIIlI) {
        final int llllllllllllllllllIllIlIIlllIlIl = GL11.glGetError();
        if (llllllllllllllllllIllIlIIlllIlIl != 0) {
            final boolean llllllllllllllllllIllIlIIlllIlII = false;
            if (!llllllllllllllllllIllIlIIlllIlII) {
                if (llllllllllllllllllIllIlIIlllIlIl == 1286) {
                    final int llllllllllllllllllIllIlIIlllIIll = EXTFramebufferObject.glCheckFramebufferStatusEXT(36160);
                    System.err.format("GL error 0x%04X: %s (Fb status 0x%04X) at %s\n", llllllllllllllllllIllIlIIlllIlIl, GLU.gluErrorString(llllllllllllllllllIllIlIIlllIlIl), llllllllllllllllllIllIlIIlllIIll, llllllllllllllllllIllIlIIlllIIlI);
                }
                else {
                    System.err.format("GL error 0x%04X: %s at %s\n", llllllllllllllllllIllIlIIlllIlIl, GLU.gluErrorString(llllllllllllllllllIllIlIIlllIlIl), llllllllllllllllllIllIlIIlllIIlI);
                }
            }
        }
        return llllllllllllllllllIllIlIIlllIlIl;
    }
    
    private static int createVertShader(final String llllllllllllllllllIllIIlllIlllIl) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: invokestatic    org/lwjgl/opengl/ARBShaderObjects.glCreateShaderObjectARB:(I)I
        //     6: istore_1        /* llllllllllllllllllIllIIlllIlllII */
        //     7: iload_1         /* llllllllllllllllllIllIIlllIlllII */
        //     8: ifne            13
        //    11: iconst_0       
        //    12: ireturn        
        //    13: new             Ljava/lang/StringBuilder;
        //    16: dup            
        //    17: ldc_w           131072
        //    20: invokespecial   java/lang/StringBuilder.<init>:(I)V
        //    23: astore_2        /* llllllllllllllllllIllIIlllIlIIIl */
        //    24: aconst_null    
        //    25: astore_3        /* llllllllllllllllllIllIIlllIlIIII */
        //    26: new             Ljava/io/BufferedReader;
        //    29: dup            
        //    30: new             Ljava/io/InputStreamReader;
        //    33: dup            
        //    34: getstatic       shadersmod/client/Shaders.shaderPack:Lshadersmod/client/IShaderPack;
        //    37: aload_0         /* llllllllllllllllllIllIIlllIlIIll */
        //    38: invokeinterface shadersmod/client/IShaderPack.getResourceAsStream:(Ljava/lang/String;)Ljava/io/InputStream;
        //    43: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;)V
        //    46: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;)V
        //    49: astore_3        /* llllllllllllllllllIllIIlllIllIlI */
        //    50: goto            89
        //    53: astore          llllllllllllllllllIllIIlllIllIIl
        //    55: new             Ljava/io/BufferedReader;
        //    58: dup            
        //    59: new             Ljava/io/FileReader;
        //    62: dup            
        //    63: new             Ljava/io/File;
        //    66: dup            
        //    67: aload_0         /* llllllllllllllllllIllIIlllIlIIll */
        //    68: invokespecial   java/io/File.<init>:(Ljava/lang/String;)V
        //    71: invokespecial   java/io/FileReader.<init>:(Ljava/io/File;)V
        //    74: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;)V
        //    77: astore_3        /* llllllllllllllllllIllIIlllIllIlI */
        //    78: goto            89
        //    81: astore          llllllllllllllllllIllIIlllIllIII
        //    83: iload_1         /* llllllllllllllllllIllIIlllIlllII */
        //    84: invokestatic    org/lwjgl/opengl/ARBShaderObjects.glDeleteObjectARB:(I)V
        //    87: iconst_0       
        //    88: ireturn        
        //    89: getstatic       shadersmod/client/Shaders.shaderPackOptions:[Lshadersmod/client/ShaderOption;
        //    92: invokestatic    shadersmod/client/Shaders.getChangedOptions:([Lshadersmod/client/ShaderOption;)[Lshadersmod/client/ShaderOption;
        //    95: astore          llllllllllllllllllIllIIlllIlIlll
        //    97: aload_3         /* llllllllllllllllllIllIIlllIllIlI */
        //    98: ifnull          272
        //   101: aload_3         /* llllllllllllllllllIllIIlllIllIlI */
        //   102: aload_0         /* llllllllllllllllllIllIIlllIlIIll */
        //   103: getstatic       shadersmod/client/Shaders.shaderPack:Lshadersmod/client/IShaderPack;
        //   106: iconst_0       
        //   107: invokestatic    shadersmod/client/ShaderPackParser.resolveIncludes:(Ljava/io/BufferedReader;Ljava/lang/String;Lshadersmod/client/IShaderPack;I)Ljava/io/BufferedReader;
        //   110: astore_3        /* llllllllllllllllllIllIIlllIllIlI */
        //   111: goto            216
        //   114: aload           llllllllllllllllllIllIIlllIlIllI
        //   116: aload           llllllllllllllllllIllIIlllIlIlll
        //   118: invokestatic    shadersmod/client/Shaders.applyOptions:(Ljava/lang/String;[Lshadersmod/client/ShaderOption;)Ljava/lang/String;
        //   121: astore          llllllllllllllllllIllIIlllIlIllI
        //   123: aload_2         /* llllllllllllllllllIllIIlllIllIll */
        //   124: aload           llllllllllllllllllIllIIlllIlIllI
        //   126: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   129: bipush          10
        //   131: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //   134: pop            
        //   135: aload           llllllllllllllllllIllIIlllIlIllI
        //   137: ldc_w           "attribute [_a-zA-Z0-9]+ mc_Entity.*"
        //   140: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //   143: ifeq            157
        //   146: iconst_1       
        //   147: putstatic       shadersmod/client/Shaders.useEntityAttrib:Z
        //   150: iconst_1       
        //   151: putstatic       shadersmod/client/Shaders.progUseEntityAttrib:Z
        //   154: goto            216
        //   157: aload           llllllllllllllllllIllIIlllIlIllI
        //   159: ldc_w           "attribute [_a-zA-Z0-9]+ mc_midTexCoord.*"
        //   162: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //   165: ifeq            179
        //   168: iconst_1       
        //   169: putstatic       shadersmod/client/Shaders.useMidTexCoordAttrib:Z
        //   172: iconst_1       
        //   173: putstatic       shadersmod/client/Shaders.progUseMidTexCoordAttrib:Z
        //   176: goto            216
        //   179: aload           llllllllllllllllllIllIIlllIlIllI
        //   181: ldc_w           ".*gl_MultiTexCoord3.*"
        //   184: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //   187: ifeq            197
        //   190: iconst_1       
        //   191: putstatic       shadersmod/client/Shaders.useMultiTexCoord3Attrib:Z
        //   194: goto            216
        //   197: aload           llllllllllllllllllIllIIlllIlIllI
        //   199: ldc_w           "attribute [_a-zA-Z0-9]+ at_tangent.*"
        //   202: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //   205: ifeq            216
        //   208: iconst_1       
        //   209: putstatic       shadersmod/client/Shaders.useTangentAttrib:Z
        //   212: iconst_1       
        //   213: putstatic       shadersmod/client/Shaders.progUseTangentAttrib:Z
        //   216: aload_3         /* llllllllllllllllllIllIIlllIllIlI */
        //   217: invokevirtual   java/io/BufferedReader.readLine:()Ljava/lang/String;
        //   220: dup            
        //   221: astore          llllllllllllllllllIllIIlllIlIlIl
        //   223: ifnonnull       114
        //   226: aload_3         /* llllllllllllllllllIllIIlllIllIlI */
        //   227: invokevirtual   java/io/BufferedReader.close:()V
        //   230: goto            272
        //   233: astore          llllllllllllllllllIllIIlllIlIlII
        //   235: new             Ljava/lang/StringBuilder;
        //   238: dup            
        //   239: ldc_w           "Couldn't read "
        //   242: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   245: aload_0         /* llllllllllllllllllIllIIlllIlIIll */
        //   246: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   249: ldc_w           "!"
        //   252: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   255: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   258: invokestatic    shadersmod/common/SMCLog.severe:(Ljava/lang/String;)V
        //   261: aload           llllllllllllllllllIllIIlllIlIlII
        //   263: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   266: iload_1         /* llllllllllllllllllIllIIlllIlllII */
        //   267: invokestatic    org/lwjgl/opengl/ARBShaderObjects.glDeleteObjectARB:(I)V
        //   270: iconst_0       
        //   271: ireturn        
        //   272: getstatic       shadersmod/client/Shaders.saveFinalShaders:Z
        //   275: ifeq            286
        //   278: aload_0         /* llllllllllllllllllIllIIlllIlIIll */
        //   279: aload_2         /* llllllllllllllllllIllIIlllIllIll */
        //   280: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   283: invokestatic    shadersmod/client/Shaders.saveShader:(Ljava/lang/String;Ljava/lang/String;)V
        //   286: iload_1         /* llllllllllllllllllIllIIlllIlllII */
        //   287: aload_2         /* llllllllllllllllllIllIIlllIllIll */
        //   288: invokestatic    org/lwjgl/opengl/ARBShaderObjects.glShaderSourceARB:(ILjava/lang/CharSequence;)V
        //   291: iload_1         /* llllllllllllllllllIllIIlllIlllII */
        //   292: invokestatic    org/lwjgl/opengl/ARBShaderObjects.glCompileShaderARB:(I)V
        //   295: iload_1         /* llllllllllllllllllIllIIlllIlllII */
        //   296: ldc_w           35713
        //   299: invokestatic    org/lwjgl/opengl/GL20.glGetShaderi:(II)I
        //   302: iconst_1       
        //   303: if_icmpeq       326
        //   306: new             Ljava/lang/StringBuilder;
        //   309: dup            
        //   310: ldc_w           "Error compiling vertex shader: "
        //   313: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   316: aload_0         /* llllllllllllllllllIllIIlllIlIIll */
        //   317: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   320: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   323: invokestatic    shadersmod/common/SMCLog.severe:(Ljava/lang/String;)V
        //   326: iload_1         /* llllllllllllllllllIllIIlllIlllII */
        //   327: aload_0         /* llllllllllllllllllIllIIlllIlIIll */
        //   328: invokestatic    shadersmod/client/Shaders.printShaderLogInfo:(ILjava/lang/String;)Z
        //   331: pop            
        //   332: iload_1         /* llllllllllllllllllIllIIlllIlllII */
        //   333: ireturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  26     50     53     89     Ljava/lang/Exception;
        //  55     78     81     89     Ljava/lang/Exception;
        //  101    230    233    272    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private static FloatBuffer nextFloatBuffer(final int llllllllllllllllllIllIlllIlIIlIl) {
        final ByteBuffer llllllllllllllllllIllIlllIlIIlII = Shaders.bigBuffer;
        final int llllllllllllllllllIllIlllIlIIIll = llllllllllllllllllIllIlllIlIIlII.limit();
        llllllllllllllllllIllIlllIlIIlII.position(llllllllllllllllllIllIlllIlIIIll).limit(llllllllllllllllllIllIlllIlIIIll + llllllllllllllllllIllIlllIlIIlIl * 4);
        return llllllllllllllllllIllIlllIlIIlII.asFloatBuffer();
    }
    
    public static void resourcesReloaded() {
        loadShaderPackResources();
    }
    
    public static void resetDisplayListModel(final ModelBase llllllllllllllllllIllIlIIIIIIlll) {
        if (llllllllllllllllllIllIlIIIIIIlll != null) {
            for (final Object llllllllllllllllllIllIlIIIIIlIII : llllllllllllllllllIllIlIIIIIIlll.boxList) {
                if (llllllllllllllllllIllIlIIIIIlIII instanceof ModelRenderer) {
                    resetDisplayListModelRenderer((ModelRenderer)llllllllllllllllllIllIlIIIIIlIII);
                }
            }
        }
    }
    
    public static void clearRenderBuffer() {
        if (Shaders.isShadowPass) {
            checkGLError("shadow clear pre");
            EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36096, 3553, Shaders.sfbDepthTextures.get(0), 0);
            GL11.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
            GL20.glDrawBuffers(Shaders.programsDrawBuffers[30]);
            checkFramebufferStatus("shadow clear");
            GL11.glClear(16640);
            checkGLError("shadow clear");
        }
        else {
            checkGLError("clear pre");
            GL20.glDrawBuffers(36064);
            GL11.glClear(16384);
            GL20.glDrawBuffers(36065);
            GL11.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glClear(16384);
            for (int llllllllllllllllllIllIIIIllIIlll = 2; llllllllllllllllllIllIIIIllIIlll < Shaders.usedColorBuffers; ++llllllllllllllllllIllIIIIllIIlll) {
                GL20.glDrawBuffers(36064 + llllllllllllllllllIllIIIIllIIlll);
                GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                GL11.glClear(16384);
            }
            setDrawBuffers(Shaders.dfbDrawBuffers);
            checkFramebufferStatus("clear");
            checkGLError("clear");
        }
    }
    
    private static ByteBuffer nextByteBuffer(final int llllllllllllllllllIllIlllIllIlII) {
        final ByteBuffer llllllllllllllllllIllIlllIllIllI = Shaders.bigBuffer;
        final int llllllllllllllllllIllIlllIllIlIl = llllllllllllllllllIllIlllIllIllI.limit();
        llllllllllllllllllIllIlllIllIllI.position(llllllllllllllllllIllIlllIllIlIl).limit(llllllllllllllllllIllIlllIllIlIl + llllllllllllllllllIllIlllIllIlII);
        return llllllllllllllllllIllIlllIllIllI.slice();
    }
    
    public static void pushEntity(final int llllllllllllllllllIlIllllIlIIIII) {
        ++Shaders.entityDataIndex;
        Shaders.entityData[Shaders.entityDataIndex * 2] = (llllllllllllllllllIlIllllIlIIIII & 0xFFFF);
        Shaders.entityData[Shaders.entityDataIndex * 2 + 1] = 0;
    }
    
    private static ShaderOption[] getVisibleOptions(final ShaderOption[] llllllllllllllllllIllIlIllllIllI) {
        final ArrayList llllllllllllllllllIllIlIlllllIlI = new ArrayList();
        for (int llllllllllllllllllIllIlIlllllIIl = 0; llllllllllllllllllIllIlIlllllIIl < llllllllllllllllllIllIlIllllIllI.length; ++llllllllllllllllllIllIlIlllllIIl) {
            final ShaderOption llllllllllllllllllIllIlIlllllIII = llllllllllllllllllIllIlIllllIllI[llllllllllllllllllIllIlIlllllIIl];
            if (llllllllllllllllllIllIlIlllllIII.isVisible()) {
                llllllllllllllllllIllIlIlllllIlI.add(llllllllllllllllllIllIlIlllllIII);
            }
        }
        final ShaderOption[] llllllllllllllllllIllIlIllllIlll = llllllllllllllllllIllIlIlllllIlI.toArray(new ShaderOption[llllllllllllllllllIllIlIlllllIlI.size()]);
        return llllllllllllllllllIllIlIllllIlll;
    }
    
    static ArrayList listOfShaders() {
        final ArrayList llllllllllllllllllIllIlIlIIlIIlI = new ArrayList();
        llllllllllllllllllIllIlIlIIlIIlI.add(Shaders.packNameNone);
        llllllllllllllllllIllIlIlIIlIIlI.add(Shaders.packNameDefault);
        try {
            if (!Shaders.shaderpacksdir.exists()) {
                Shaders.shaderpacksdir.mkdir();
            }
            final File[] llllllllllllllllllIllIlIlIIlIIIl = Shaders.shaderpacksdir.listFiles();
            for (int llllllllllllllllllIllIlIlIIlIIII = 0; llllllllllllllllllIllIlIlIIlIIII < llllllllllllllllllIllIlIlIIlIIIl.length; ++llllllllllllllllllIllIlIlIIlIIII) {
                final File llllllllllllllllllIllIlIlIIIllll = llllllllllllllllllIllIlIlIIlIIIl[llllllllllllllllllIllIlIlIIlIIII];
                final String llllllllllllllllllIllIlIlIIIlllI = llllllllllllllllllIllIlIlIIIllll.getName();
                if (llllllllllllllllllIllIlIlIIIllll.isDirectory()) {
                    final File llllllllllllllllllIllIlIlIIIllIl = new File(llllllllllllllllllIllIlIlIIIllll, "shaders");
                    if (llllllllllllllllllIllIlIlIIIllIl.exists() && llllllllllllllllllIllIlIlIIIllIl.isDirectory()) {
                        llllllllllllllllllIllIlIlIIlIIlI.add(llllllllllllllllllIllIlIlIIIlllI);
                    }
                }
                else if (llllllllllllllllllIllIlIlIIIllll.isFile() && llllllllllllllllllIllIlIlIIIlllI.toLowerCase().endsWith(".zip")) {
                    llllllllllllllllllIllIlIlIIlIIlI.add(llllllllllllllllllIllIlIlIIIlllI);
                }
            }
        }
        catch (Exception ex) {}
        return llllllllllllllllllIllIlIlIIlIIlI;
    }
    
    public static String getEnumShaderOption(final EnumShaderOption llllllllllllllllllIllIllIllIIlll) {
        switch (NamelessClass341846571.$SwitchMap$shadersmod$client$EnumShaderOption[llllllllllllllllllIllIllIllIIlll.ordinal()]) {
            case 1: {
                return Integer.toString(Shaders.configAntialiasingLevel);
            }
            case 2: {
                return Boolean.toString(Shaders.configNormalMap);
            }
            case 3: {
                return Boolean.toString(Shaders.configSpecularMap);
            }
            case 4: {
                return Float.toString(Shaders.configRenderResMul);
            }
            case 5: {
                return Float.toString(Shaders.configShadowResMul);
            }
            case 6: {
                return Float.toString(Shaders.configHandDepthMul);
            }
            case 7: {
                return Boolean.toString(Shaders.configCloudShadow);
            }
            case 8: {
                return Shaders.configOldLighting.getPropertyValue();
            }
            case 9: {
                return Shaders.currentshadername;
            }
            case 10: {
                return Boolean.toString(Shaders.configTweakBlockDamage);
            }
            case 11: {
                return Boolean.toString(Shaders.configShadowClipFrustrum);
            }
            case 12: {
                return Integer.toString(Shaders.configTexMinFilB);
            }
            case 13: {
                return Integer.toString(Shaders.configTexMinFilN);
            }
            case 14: {
                return Integer.toString(Shaders.configTexMinFilS);
            }
            case 15: {
                return Integer.toString(Shaders.configTexMagFilB);
            }
            case 16: {
                return Integer.toString(Shaders.configTexMagFilB);
            }
            case 17: {
                return Integer.toString(Shaders.configTexMagFilB);
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder("Unknown option: ").append(llllllllllllllllllIllIllIllIIlll)));
            }
        }
    }
    
    private static void loadEntityDataMap() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: sipush          300
        //     7: invokespecial   java/util/IdentityHashMap.<init>:(I)V
        //    10: putstatic       shadersmod/client/Shaders.mapBlockToEntityData:Ljava/util/Map;
        //    13: getstatic       shadersmod/client/Shaders.mapBlockToEntityData:Ljava/util/Map;
        //    16: invokeinterface java/util/Map.isEmpty:()Z
        //    21: ifeq            91
        //    24: getstatic       net/minecraft/block/Block.blockRegistry:Lnet/minecraft/util/RegistryNamespacedDefaultedByKey;
        //    27: invokevirtual   net/minecraft/util/RegistryNamespacedDefaultedByKey.getKeys:()Ljava/util/Set;
        //    30: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
        //    35: astore_0        /* llllllllllllllllllIllIIIlllIIIlI */
        //    36: goto            82
        //    39: aload_0         /* llllllllllllllllllIllIIIlllIIIlI */
        //    40: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    45: checkcast       Lnet/minecraft/util/ResourceLocation;
        //    48: astore_1        /* llllllllllllllllllIllIIIllIlIlII */
        //    49: getstatic       net/minecraft/block/Block.blockRegistry:Lnet/minecraft/util/RegistryNamespacedDefaultedByKey;
        //    52: aload_1         /* llllllllllllllllllIllIIIlllIIIIl */
        //    53: invokevirtual   net/minecraft/util/RegistryNamespacedDefaultedByKey.getObject:(Ljava/lang/Object;)Ljava/lang/Object;
        //    56: checkcast       Lnet/minecraft/block/Block;
        //    59: astore_2        /* llllllllllllllllllIllIIIlllIIIII */
        //    60: getstatic       net/minecraft/block/Block.blockRegistry:Lnet/minecraft/util/RegistryNamespacedDefaultedByKey;
        //    63: aload_2         /* llllllllllllllllllIllIIIlllIIIII */
        //    64: invokevirtual   net/minecraft/util/RegistryNamespacedDefaultedByKey.getIDForObject:(Ljava/lang/Object;)I
        //    67: istore_3        /* llllllllllllllllllIllIIIllIlllll */
        //    68: getstatic       shadersmod/client/Shaders.mapBlockToEntityData:Ljava/util/Map;
        //    71: aload_2         /* llllllllllllllllllIllIIIlllIIIII */
        //    72: iload_3         /* llllllllllllllllllIllIIIllIlllll */
        //    73: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    76: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    81: pop            
        //    82: aload_0         /* llllllllllllllllllIllIIIlllIIIlI */
        //    83: invokeinterface java/util/Iterator.hasNext:()Z
        //    88: ifne            39
        //    91: aconst_null    
        //    92: astore_0        /* llllllllllllllllllIllIIIllIllllI */
        //    93: new             Ljava/io/BufferedReader;
        //    96: dup            
        //    97: new             Ljava/io/InputStreamReader;
        //   100: dup            
        //   101: getstatic       shadersmod/client/Shaders.shaderPack:Lshadersmod/client/IShaderPack;
        //   104: ldc_w           "/mc_Entity_x.txt"
        //   107: invokeinterface shadersmod/client/IShaderPack.getResourceAsStream:(Ljava/lang/String;)Ljava/io/InputStream;
        //   112: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;)V
        //   115: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;)V
        //   118: astore_0        /* llllllllllllllllllIllIIIllIllllI */
        //   119: goto            123
        //   122: astore_1        /* llllllllllllllllllIllIIIllIlIlII */
        //   123: aload_0         /* llllllllllllllllllIllIIIllIllllI */
        //   124: ifnull          245
        //   127: goto            226
        //   130: getstatic       shadersmod/client/Shaders.patternLoadEntityDataMap:Ljava/util/regex/Pattern;
        //   133: aload_1         /* llllllllllllllllllIllIIIllIlllIl */
        //   134: invokevirtual   java/util/regex/Pattern.matcher:(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
        //   137: astore_2        /* llllllllllllllllllIllIIIllIllIll */
        //   138: aload_2         /* llllllllllllllllllIllIIIllIllIll */
        //   139: invokevirtual   java/util/regex/Matcher.matches:()Z
        //   142: ifeq            212
        //   145: aload_2         /* llllllllllllllllllIllIIIllIllIll */
        //   146: iconst_1       
        //   147: invokevirtual   java/util/regex/Matcher.group:(I)Ljava/lang/String;
        //   150: astore_3        /* llllllllllllllllllIllIIIllIllIlI */
        //   151: aload_2         /* llllllllllllllllllIllIIIllIllIll */
        //   152: iconst_2       
        //   153: invokevirtual   java/util/regex/Matcher.group:(I)Ljava/lang/String;
        //   156: astore          llllllllllllllllllIllIIIllIllIIl
        //   158: aload           llllllllllllllllllIllIIIllIllIIl
        //   160: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //   163: istore          llllllllllllllllllIllIIIllIllIII
        //   165: aload_3         /* llllllllllllllllllIllIIIllIllIlI */
        //   166: invokestatic    net/minecraft/block/Block.getBlockFromName:(Ljava/lang/String;)Lnet/minecraft/block/Block;
        //   169: astore          llllllllllllllllllIllIIIllIlIlll
        //   171: aload           llllllllllllllllllIllIIIllIlIlll
        //   173: ifnull          195
        //   176: getstatic       shadersmod/client/Shaders.mapBlockToEntityData:Ljava/util/Map;
        //   179: aload           llllllllllllllllllIllIIIllIlIlll
        //   181: iload           llllllllllllllllllIllIIIllIllIII
        //   183: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   186: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   191: pop            
        //   192: goto            226
        //   195: ldc_w           "Unknown block name %s"
        //   198: iconst_1       
        //   199: anewarray       Ljava/lang/Object;
        //   202: dup            
        //   203: iconst_0       
        //   204: aload_3         /* llllllllllllllllllIllIIIllIllIlI */
        //   205: aastore        
        //   206: invokestatic    shadersmod/common/SMCLog.warning:(Ljava/lang/String;[Ljava/lang/Object;)V
        //   209: goto            226
        //   212: ldc_w           "unmatched %s\n"
        //   215: iconst_1       
        //   216: anewarray       Ljava/lang/Object;
        //   219: dup            
        //   220: iconst_0       
        //   221: aload_1         /* llllllllllllllllllIllIIIllIlllIl */
        //   222: aastore        
        //   223: invokestatic    shadersmod/common/SMCLog.warning:(Ljava/lang/String;[Ljava/lang/Object;)V
        //   226: aload_0         /* llllllllllllllllllIllIIIllIllllI */
        //   227: invokevirtual   java/io/BufferedReader.readLine:()Ljava/lang/String;
        //   230: dup            
        //   231: astore_1        /* llllllllllllllllllIllIIIllIlIlII */
        //   232: ifnonnull       130
        //   235: goto            245
        //   238: astore_2        /* llllllllllllllllllIllIIIllIlIllI */
        //   239: ldc_w           "Error parsing mc_Entity_x.txt"
        //   242: invokestatic    shadersmod/common/SMCLog.warning:(Ljava/lang/String;)V
        //   245: aload_0         /* llllllllllllllllllIllIIIllIllllI */
        //   246: ifnull          257
        //   249: aload_0         /* llllllllllllllllllIllIIIllIllllI */
        //   250: invokevirtual   java/io/BufferedReader.close:()V
        //   253: goto            257
        //   256: astore_1        /* llllllllllllllllllIllIIIllIlIlII */
        //   257: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  93     119    122    123    Ljava/lang/Exception;
        //  127    235    238    245    Ljava/lang/Exception;
        //  249    253    256    257    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static void setProgramUniformMatrix4ARB(final String llllllllllllllllllIllIIIllllllll, final boolean llllllllllllllllllIllIIIlllllIIl, final FloatBuffer llllllllllllllllllIllIIIlllllIII) {
        final int llllllllllllllllllIllIIIllllllII = Shaders.programsID[Shaders.activeProgram];
        if (llllllllllllllllllIllIIIllllllII != 0 && llllllllllllllllllIllIIIlllllIII != null) {
            final int llllllllllllllllllIllIIIlllllIll = ARBShaderObjects.glGetUniformLocationARB(llllllllllllllllllIllIIIllllllII, (CharSequence)llllllllllllllllllIllIIIllllllll);
            ARBShaderObjects.glUniformMatrix4ARB(llllllllllllllllllIllIIIlllllIll, llllllllllllllllllIllIIIlllllIIl, llllllllllllllllllIllIIIlllllIII);
            checkGLError(Shaders.programNames[Shaders.activeProgram], llllllllllllllllllIllIIIllllllll);
        }
    }
    
    public static void loadShaderPack() {
        final boolean llllllllllllllllllIllIllIlIlllII = Shaders.shaderPackLoaded;
        final boolean llllllllllllllllllIllIllIlIllIll = isOldLighting();
        Shaders.shaderPackLoaded = false;
        if (Shaders.shaderPack != null) {
            Shaders.shaderPack.close();
            Shaders.shaderPack = null;
            Shaders.shaderPackResources.clear();
            Shaders.shaderPackDimensions.clear();
            Shaders.shaderPackOptions = null;
            Shaders.shaderPackProfiles = null;
            Shaders.shaderPackGuiScreens = null;
            Shaders.shaderPackClouds.resetValue();
            Shaders.shaderPackDynamicHandLight.resetValue();
            Shaders.shaderPackOldLighting.resetValue();
        }
        boolean llllllllllllllllllIllIllIlIllIlI = false;
        if (Config.isAntialiasing()) {
            SMCLog.info(String.valueOf(new StringBuilder("Shaders can not be loaded, Antialiasing is enabled: ").append(Config.getAntialiasingLevel()).append("x")));
            llllllllllllllllllIllIllIlIllIlI = true;
        }
        if (Config.isAnisotropicFiltering()) {
            SMCLog.info(String.valueOf(new StringBuilder("Shaders can not be loaded, Anisotropic Filtering is enabled: ").append(Config.getAnisotropicFilterLevel()).append("x")));
            llllllllllllllllllIllIllIlIllIlI = true;
        }
        if (Config.isFastRender()) {
            SMCLog.info("Shaders can not be loaded, Fast Render is enabled.");
            llllllllllllllllllIllIllIlIllIlI = true;
        }
        final String llllllllllllllllllIllIllIlIllIIl = Shaders.shadersConfig.getProperty(EnumShaderOption.SHADER_PACK.getPropertyKey(), Shaders.packNameDefault);
        if (!llllllllllllllllllIllIllIlIllIIl.isEmpty() && !llllllllllllllllllIllIllIlIllIIl.equals(Shaders.packNameNone) && !llllllllllllllllllIllIllIlIllIlI) {
            if (llllllllllllllllllIllIllIlIllIIl.equals(Shaders.packNameDefault)) {
                Shaders.shaderPack = new ShaderPackDefault();
                Shaders.shaderPackLoaded = true;
            }
            else {
                try {
                    final File llllllllllllllllllIllIllIlIllIII = new File(Shaders.shaderpacksdir, llllllllllllllllllIllIllIlIllIIl);
                    if (llllllllllllllllllIllIllIlIllIII.isDirectory()) {
                        Shaders.shaderPack = new ShaderPackFolder(llllllllllllllllllIllIllIlIllIIl, llllllllllllllllllIllIllIlIllIII);
                        Shaders.shaderPackLoaded = true;
                    }
                    else if (llllllllllllllllllIllIllIlIllIII.isFile() && llllllllllllllllllIllIllIlIllIIl.toLowerCase().endsWith(".zip")) {
                        Shaders.shaderPack = new ShaderPackZip(llllllllllllllllllIllIllIlIllIIl, llllllllllllllllllIllIllIlIllIII);
                        Shaders.shaderPackLoaded = true;
                    }
                }
                catch (Exception ex) {}
            }
        }
        if (Shaders.shaderPack != null) {
            SMCLog.info(String.valueOf(new StringBuilder("Loaded shaderpack: ").append(getShaderPackName())));
        }
        else {
            SMCLog.info("No shaderpack loaded.");
            Shaders.shaderPack = new ShaderPackNone();
        }
        loadShaderPackResources();
        loadShaderPackDimensions();
        Shaders.shaderPackOptions = loadShaderPackOptions();
        loadShaderPackProperties();
        final boolean llllllllllllllllllIllIllIlIlIlll = Shaders.shaderPackLoaded ^ llllllllllllllllllIllIllIlIlllII;
        final boolean llllllllllllllllllIllIllIlIlIllI = isOldLighting() ^ llllllllllllllllllIllIllIlIllIll;
        if (llllllllllllllllllIllIllIlIlIlll || llllllllllllllllllIllIllIlIlIllI) {
            DefaultVertexFormats.updateVertexFormats();
            if (Reflector.LightUtil.exists()) {
                Reflector.LightUtil_itemConsumer.setValue(null);
                Reflector.LightUtil_tessellator.setValue(null);
            }
            updateBlockLightLevel();
            Shaders.mc.func_175603_A();
        }
    }
    
    private static IntBuffer fillIntBufferZero(final IntBuffer llllllllllllllllllIllIIIllIIlIII) {
        for (int llllllllllllllllllIllIIIllIIlIlI = llllllllllllllllllIllIIIllIIlIII.limit(), llllllllllllllllllIllIIIllIIlIIl = llllllllllllllllllIllIIIllIIlIII.position(); llllllllllllllllllIllIIIllIIlIIl < llllllllllllllllllIllIIIllIIlIlI; ++llllllllllllllllllIllIIIllIIlIIl) {
            llllllllllllllllllIllIIIllIIlIII.put(llllllllllllllllllIllIIIllIIlIIl, 0);
        }
        return llllllllllllllllllIllIIIllIIlIII;
    }
    
    private static String applyOptions(String llllllllllllllllllIllIlIlIIlllIl, final ShaderOption[] llllllllllllllllllIllIlIlIlIIIIl) {
        if (llllllllllllllllllIllIlIlIlIIIIl != null && llllllllllllllllllIllIlIlIlIIIIl.length > 0) {
            for (int llllllllllllllllllIllIlIlIlIIIII = 0; llllllllllllllllllIllIlIlIlIIIII < llllllllllllllllllIllIlIlIlIIIIl.length; ++llllllllllllllllllIllIlIlIlIIIII) {
                final ShaderOption llllllllllllllllllIllIlIlIIlllll = llllllllllllllllllIllIlIlIlIIIIl[llllllllllllllllllIllIlIlIlIIIII];
                final String llllllllllllllllllIllIlIlIIllllI = llllllllllllllllllIllIlIlIIlllll.getName();
                if (llllllllllllllllllIllIlIlIIlllll.matchesLine(llllllllllllllllllIllIlIlIIlllIl)) {
                    llllllllllllllllllIllIlIlIIlllIl = llllllllllllllllllIllIlIlIIlllll.getSourceLine();
                    break;
                }
            }
            return llllllllllllllllllIllIlIlIIlllIl;
        }
        return llllllllllllllllllIllIlIlIIlllIl;
    }
    
    public static void renderCompositeFinal() {
        if (!Shaders.isShadowPass) {
            checkGLError("pre-renderCompositeFinal");
            GL11.glPushMatrix();
            GL11.glLoadIdentity();
            GL11.glMatrixMode(5889);
            GL11.glPushMatrix();
            GL11.glLoadIdentity();
            GL11.glOrtho(0.0, 1.0, 0.0, 1.0, 0.0, 1.0);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.func_179098_w();
            GlStateManager.disableAlpha();
            GlStateManager.disableBlend();
            GlStateManager.enableDepth();
            GlStateManager.depthFunc(519);
            GlStateManager.depthMask(false);
            GlStateManager.disableLighting();
            if (Shaders.usedShadowDepthBuffers >= 1) {
                GlStateManager.setActiveTexture(33988);
                GlStateManager.func_179144_i(Shaders.sfbDepthTextures.get(0));
                if (Shaders.usedShadowDepthBuffers >= 2) {
                    GlStateManager.setActiveTexture(33989);
                    GlStateManager.func_179144_i(Shaders.sfbDepthTextures.get(1));
                }
            }
            for (int llllllllllllllllllIllIIIIIIllIll = 0; llllllllllllllllllIllIIIIIIllIll < Shaders.usedColorBuffers; ++llllllllllllllllllIllIIIIIIllIll) {
                GlStateManager.setActiveTexture(33984 + Shaders.colorTextureTextureImageUnit[llllllllllllllllllIllIIIIIIllIll]);
                GlStateManager.func_179144_i(Shaders.dfbColorTexturesA[llllllllllllllllllIllIIIIIIllIll]);
            }
            GlStateManager.setActiveTexture(33990);
            GlStateManager.func_179144_i(Shaders.dfbDepthTextures.get(0));
            if (Shaders.usedDepthBuffers >= 2) {
                GlStateManager.setActiveTexture(33995);
                GlStateManager.func_179144_i(Shaders.dfbDepthTextures.get(1));
                if (Shaders.usedDepthBuffers >= 3) {
                    GlStateManager.setActiveTexture(33996);
                    GlStateManager.func_179144_i(Shaders.dfbDepthTextures.get(2));
                }
            }
            for (int llllllllllllllllllIllIIIIIIllIll = 0; llllllllllllllllllIllIIIIIIllIll < Shaders.usedShadowColorBuffers; ++llllllllllllllllllIllIIIIIIllIll) {
                GlStateManager.setActiveTexture(33997 + llllllllllllllllllIllIIIIIIllIll);
                GlStateManager.func_179144_i(Shaders.sfbColorTextures.get(llllllllllllllllllIllIIIIIIllIll));
            }
            if (Shaders.noiseTextureEnabled) {
                GlStateManager.setActiveTexture(33984 + Shaders.noiseTexture.textureUnit);
                GlStateManager.func_179144_i(Shaders.noiseTexture.getID());
                GL11.glTexParameteri(3553, 10242, 10497);
                GL11.glTexParameteri(3553, 10243, 10497);
                GL11.glTexParameteri(3553, 10240, 9729);
                GL11.glTexParameteri(3553, 10241, 9729);
            }
            GlStateManager.setActiveTexture(33984);
            final boolean llllllllllllllllllIllIIIIIIllIlI = true;
            for (int llllllllllllllllllIllIIIIIIllIIl = 0; llllllllllllllllllIllIIIIIIllIIl < Shaders.usedColorBuffers; ++llllllllllllllllllIllIIIIIIllIIl) {
                EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36064 + llllllllllllllllllIllIIIIIIllIIl, 3553, Shaders.dfbColorTexturesA[8 + llllllllllllllllllIllIIIIIIllIIl], 0);
            }
            EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36096, 3553, Shaders.dfbDepthTextures.get(0), 0);
            GL20.glDrawBuffers(Shaders.dfbDrawBuffers);
            checkGLError("pre-composite");
            for (int llllllllllllllllllIllIIIIIIllIIl = 0; llllllllllllllllllIllIIIIIIllIIl < 8; ++llllllllllllllllllIllIIIIIIllIIl) {
                if (Shaders.programsID[21 + llllllllllllllllllIllIIIIIIllIIl] != 0) {
                    useProgram(21 + llllllllllllllllllIllIIIIIIllIIl);
                    checkGLError(Shaders.programNames[21 + llllllllllllllllllIllIIIIIIllIIl]);
                    if (Shaders.activeCompositeMipmapSetting != 0) {
                        genCompositeMipmap();
                    }
                    drawComposite();
                    for (int llllllllllllllllllIllIIIIIIllIII = 0; llllllllllllllllllIllIIIIIIllIII < Shaders.usedColorBuffers; ++llllllllllllllllllIllIIIIIIllIII) {
                        if (Shaders.programsToggleColorTextures[21 + llllllllllllllllllIllIIIIIIllIIl][llllllllllllllllllIllIIIIIIllIII]) {
                            final int llllllllllllllllllIllIIIIIIlIlll = Shaders.colorTexturesToggle[llllllllllllllllllIllIIIIIIllIII];
                            final int[] colorTexturesToggle = Shaders.colorTexturesToggle;
                            final int n = llllllllllllllllllIllIIIIIIllIII;
                            final int n2 = 8 - llllllllllllllllllIllIIIIIIlIlll;
                            colorTexturesToggle[n] = n2;
                            final int llllllllllllllllllIllIIIIIIlIllI = n2;
                            GlStateManager.setActiveTexture(33984 + Shaders.colorTextureTextureImageUnit[llllllllllllllllllIllIIIIIIllIII]);
                            GlStateManager.func_179144_i(Shaders.dfbColorTexturesA[llllllllllllllllllIllIIIIIIlIllI + llllllllllllllllllIllIIIIIIllIII]);
                            EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36064 + llllllllllllllllllIllIIIIIIllIII, 3553, Shaders.dfbColorTexturesA[llllllllllllllllllIllIIIIIIlIlll + llllllllllllllllllIllIIIIIIllIII], 0);
                        }
                    }
                    GlStateManager.setActiveTexture(33984);
                }
            }
            checkGLError("composite");
            Shaders.isRenderingDfb = false;
            Shaders.mc.getFramebuffer().bindFramebuffer(true);
            OpenGlHelper.func_153188_a(OpenGlHelper.field_153198_e, OpenGlHelper.field_153200_g, 3553, Shaders.mc.getFramebuffer().framebufferTexture, 0);
            GL11.glViewport(0, 0, Shaders.mc.displayWidth, Shaders.mc.displayHeight);
            if (EntityRenderer.anaglyphEnable) {
                final boolean llllllllllllllllllIllIIIIIIlIlIl = EntityRenderer.anaglyphField != 0;
                GlStateManager.colorMask(llllllllllllllllllIllIIIIIIlIlIl, !llllllllllllllllllIllIIIIIIlIlIl, !llllllllllllllllllIllIIIIIIlIlIl, true);
            }
            GlStateManager.depthMask(true);
            GL11.glClearColor(Shaders.clearColorR, Shaders.clearColorG, Shaders.clearColorB, 1.0f);
            GL11.glClear(16640);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.func_179098_w();
            GlStateManager.disableAlpha();
            GlStateManager.disableBlend();
            GlStateManager.enableDepth();
            GlStateManager.depthFunc(519);
            GlStateManager.depthMask(false);
            checkGLError("pre-final");
            useProgram(29);
            checkGLError("final");
            if (Shaders.activeCompositeMipmapSetting != 0) {
                genCompositeMipmap();
            }
            drawComposite();
            checkGLError("renderCompositeFinal");
            Shaders.isCompositeRendered = true;
            GlStateManager.enableLighting();
            GlStateManager.func_179098_w();
            GlStateManager.enableAlpha();
            GlStateManager.enableBlend();
            GlStateManager.depthFunc(515);
            GlStateManager.depthMask(true);
            GL11.glPopMatrix();
            GL11.glMatrixMode(5888);
            GL11.glPopMatrix();
            useProgram(0);
        }
    }
    
    public static void useProgram(int llllllllllllllllllIllIIlIlIIIlII) {
        checkGLError("pre-useProgram");
        if (Shaders.isShadowPass) {
            llllllllllllllllllIllIIlIlIIIlII = 30;
            if (Shaders.programsID[30] == 0) {
                Shaders.normalMapEnabled = false;
                return;
            }
        }
        if (Shaders.activeProgram != llllllllllllllllllIllIIlIlIIIlII) {
            Shaders.activeProgram = (int)llllllllllllllllllIllIIlIlIIIlII;
            ARBShaderObjects.glUseProgramObjectARB(Shaders.programsID[llllllllllllllllllIllIIlIlIIIlII]);
            if (Shaders.programsID[llllllllllllllllllIllIIlIlIIIlII] == 0) {
                Shaders.normalMapEnabled = false;
            }
            else {
                if (checkGLError("useProgram ", Shaders.programNames[llllllllllllllllllIllIIlIlIIIlII]) != 0) {
                    Shaders.programsID[llllllllllllllllllIllIIlIlIIIlII] = 0;
                }
                final IntBuffer llllllllllllllllllIllIIlIlIIllII = Shaders.programsDrawBuffers[llllllllllllllllllIllIIlIlIIIlII];
                if (Shaders.isRenderingDfb) {
                    setDrawBuffers(llllllllllllllllllIllIIlIlIIllII);
                    checkGLError(Shaders.programNames[llllllllllllllllllIllIIlIlIIIlII], " draw buffers = ", Shaders.programsDrawBufSettings[llllllllllllllllllIllIIlIlIIIlII]);
                }
                Shaders.activeCompositeMipmapSetting = Shaders.programsCompositeMipmapSetting[llllllllllllllllllIllIIlIlIIIlII];
                Shaders.uniformEntityColor.setProgram(Shaders.programsID[Shaders.activeProgram]);
                Shaders.uniformEntityId.setProgram(Shaders.programsID[Shaders.activeProgram]);
                Shaders.uniformBlockEntityId.setProgram(Shaders.programsID[Shaders.activeProgram]);
                switch (llllllllllllllllllIllIIlIlIIIlII) {
                    case 1.0f:
                    case 2.0f:
                    case 3.0f:
                    case 4.0f:
                    case 5.0f:
                    case 6.0f:
                    case 7.0f:
                    case 8.0f:
                    case 9.0f:
                    case 10.0f:
                    case 11.0f:
                    case 12.0f:
                    case 13.0f:
                    case 16.0f:
                    case 18.0f:
                    case 19.0f:
                    case 20.0f: {
                        Shaders.normalMapEnabled = true;
                        setProgramUniform1i("texture", 0);
                        setProgramUniform1i("lightmap", 1);
                        setProgramUniform1i("normals", 2);
                        setProgramUniform1i("specular", 3);
                        setProgramUniform1i("shadow", Shaders.waterShadowEnabled ? 5 : 4);
                        setProgramUniform1i("watershadow", 4);
                        setProgramUniform1i("shadowtex0", 4);
                        setProgramUniform1i("shadowtex1", 5);
                        setProgramUniform1i("depthtex0", 6);
                        setProgramUniform1i("depthtex1", 12);
                        setProgramUniform1i("shadowcolor", 13);
                        setProgramUniform1i("shadowcolor0", 13);
                        setProgramUniform1i("shadowcolor1", 14);
                        setProgramUniform1i("noisetex", 15);
                        break;
                    }
                    default: {
                        Shaders.normalMapEnabled = false;
                        break;
                    }
                    case 21.0f:
                    case 22.0f:
                    case 23.0f:
                    case 24.0f:
                    case 25.0f:
                    case 26.0f:
                    case 27.0f:
                    case 28.0f:
                    case 29.0f: {
                        Shaders.normalMapEnabled = false;
                        setProgramUniform1i("gcolor", 0);
                        setProgramUniform1i("gdepth", 1);
                        setProgramUniform1i("gnormal", 2);
                        setProgramUniform1i("composite", 3);
                        setProgramUniform1i("gaux1", 7);
                        setProgramUniform1i("gaux2", 8);
                        setProgramUniform1i("gaux3", 9);
                        setProgramUniform1i("gaux4", 10);
                        setProgramUniform1i("colortex0", 0);
                        setProgramUniform1i("colortex1", 1);
                        setProgramUniform1i("colortex2", 2);
                        setProgramUniform1i("colortex3", 3);
                        setProgramUniform1i("colortex4", 7);
                        setProgramUniform1i("colortex5", 8);
                        setProgramUniform1i("colortex6", 9);
                        setProgramUniform1i("colortex7", 10);
                        setProgramUniform1i("shadow", Shaders.waterShadowEnabled ? 5 : 4);
                        setProgramUniform1i("watershadow", 4);
                        setProgramUniform1i("shadowtex0", 4);
                        setProgramUniform1i("shadowtex1", 5);
                        setProgramUniform1i("gdepthtex", 6);
                        setProgramUniform1i("depthtex0", 6);
                        setProgramUniform1i("depthtex1", 11);
                        setProgramUniform1i("depthtex2", 12);
                        setProgramUniform1i("shadowcolor", 13);
                        setProgramUniform1i("shadowcolor0", 13);
                        setProgramUniform1i("shadowcolor1", 14);
                        setProgramUniform1i("noisetex", 15);
                        break;
                    }
                    case 30.0f:
                    case 31.0f:
                    case 32.0f: {
                        setProgramUniform1i("tex", 0);
                        setProgramUniform1i("texture", 0);
                        setProgramUniform1i("lightmap", 1);
                        setProgramUniform1i("normals", 2);
                        setProgramUniform1i("specular", 3);
                        setProgramUniform1i("shadow", Shaders.waterShadowEnabled ? 5 : 4);
                        setProgramUniform1i("watershadow", 4);
                        setProgramUniform1i("shadowtex0", 4);
                        setProgramUniform1i("shadowtex1", 5);
                        setProgramUniform1i("shadowcolor", 13);
                        setProgramUniform1i("shadowcolor0", 13);
                        setProgramUniform1i("shadowcolor1", 14);
                        setProgramUniform1i("noisetex", 15);
                        break;
                    }
                }
                final ItemStack llllllllllllllllllIllIIlIlIIlIll = Shaders.mc.thePlayer.getCurrentEquippedItem();
                final Item llllllllllllllllllIllIIlIlIIlIlI = (llllllllllllllllllIllIIlIlIIlIll != null) ? llllllllllllllllllIllIIlIlIIlIll.getItem() : null;
                int llllllllllllllllllIllIIlIlIIlIII = 0;
                Block llllllllllllllllllIllIIlIlIIIllI = null;
                if (llllllllllllllllllIllIIlIlIIlIlI != null) {
                    final int llllllllllllllllllIllIIlIlIIlIIl = Item.itemRegistry.getIDForObject(llllllllllllllllllIllIIlIlIIlIlI);
                    final Block llllllllllllllllllIllIIlIlIIIlll = (Block)Block.blockRegistry.getObjectById(llllllllllllllllllIllIIlIlIIlIIl);
                }
                else {
                    llllllllllllllllllIllIIlIlIIlIII = -1;
                    llllllllllllllllllIllIIlIlIIIllI = null;
                }
                final int llllllllllllllllllIllIIlIlIIIlIl = (llllllllllllllllllIllIIlIlIIIllI != null) ? llllllllllllllllllIllIIlIlIIIllI.getLightValue() : 0;
                setProgramUniform1i("heldItemId", llllllllllllllllllIllIIlIlIIlIII);
                setProgramUniform1i("heldBlockLightValue", llllllllllllllllllIllIIlIlIIIlIl);
                setProgramUniform1i("fogMode", Shaders.fogEnabled ? Shaders.fogMode : 0);
                setProgramUniform3f("fogColor", Shaders.fogColorR, Shaders.fogColorG, Shaders.fogColorB);
                setProgramUniform3f("skyColor", Shaders.skyColorR, Shaders.skyColorG, Shaders.skyColorB);
                setProgramUniform1i("worldTime", (int)Shaders.worldTime % 24000);
                setProgramUniform1i("moonPhase", Shaders.moonPhase);
                setProgramUniform1f("frameTimeCounter", Shaders.frameTimeCounter);
                setProgramUniform1f("sunAngle", Shaders.sunAngle);
                setProgramUniform1f("shadowAngle", Shaders.shadowAngle);
                setProgramUniform1f("rainStrength", Shaders.rainStrength);
                setProgramUniform1f("aspectRatio", Shaders.renderWidth / (float)Shaders.renderHeight);
                setProgramUniform1f("viewWidth", (float)Shaders.renderWidth);
                setProgramUniform1f("viewHeight", (float)Shaders.renderHeight);
                setProgramUniform1f("near", 0.05f);
                setProgramUniform1f("far", (float)(Shaders.mc.gameSettings.renderDistanceChunks * 16));
                setProgramUniform3f("sunPosition", Shaders.sunPosition[0], Shaders.sunPosition[1], Shaders.sunPosition[2]);
                setProgramUniform3f("moonPosition", Shaders.moonPosition[0], Shaders.moonPosition[1], Shaders.moonPosition[2]);
                setProgramUniform3f("shadowLightPosition", Shaders.shadowLightPosition[0], Shaders.shadowLightPosition[1], Shaders.shadowLightPosition[2]);
                setProgramUniform3f("upPosition", Shaders.upPosition[0], Shaders.upPosition[1], Shaders.upPosition[2]);
                setProgramUniform3f("previousCameraPosition", (float)Shaders.previousCameraPositionX, (float)Shaders.previousCameraPositionY, (float)Shaders.previousCameraPositionZ);
                setProgramUniform3f("cameraPosition", (float)Shaders.cameraPositionX, (float)Shaders.cameraPositionY, (float)Shaders.cameraPositionZ);
                setProgramUniformMatrix4ARB("gbufferModelView", false, Shaders.modelView);
                setProgramUniformMatrix4ARB("gbufferModelViewInverse", false, Shaders.modelViewInverse);
                setProgramUniformMatrix4ARB("gbufferPreviousProjection", false, Shaders.previousProjection);
                setProgramUniformMatrix4ARB("gbufferProjection", false, Shaders.projection);
                setProgramUniformMatrix4ARB("gbufferProjectionInverse", false, Shaders.projectionInverse);
                setProgramUniformMatrix4ARB("gbufferPreviousModelView", false, Shaders.previousModelView);
                if (Shaders.usedShadowDepthBuffers > 0) {
                    setProgramUniformMatrix4ARB("shadowProjection", false, Shaders.shadowProjection);
                    setProgramUniformMatrix4ARB("shadowProjectionInverse", false, Shaders.shadowProjectionInverse);
                    setProgramUniformMatrix4ARB("shadowModelView", false, Shaders.shadowModelView);
                    setProgramUniformMatrix4ARB("shadowModelViewInverse", false, Shaders.shadowModelViewInverse);
                }
                setProgramUniform1f("wetness", Shaders.wetness);
                setProgramUniform1f("eyeAltitude", Shaders.eyePosY);
                setProgramUniform2i("eyeBrightness", Shaders.eyeBrightness & 0xFFFF, Shaders.eyeBrightness >> 16);
                setProgramUniform2i("eyeBrightnessSmooth", Math.round(Shaders.eyeBrightnessFadeX), Math.round(Shaders.eyeBrightnessFadeY));
                setProgramUniform2i("terrainTextureSize", Shaders.terrainTextureSize[0], Shaders.terrainTextureSize[1]);
                setProgramUniform1i("terrainIconSize", Shaders.terrainIconSize);
                setProgramUniform1i("isEyeInWater", Shaders.isEyeInWater);
                setProgramUniform1i("hideGUI", Shaders.mc.gameSettings.hideGUI ? 1 : 0);
                setProgramUniform1f("centerDepthSmooth", Shaders.centerDepthSmooth);
                setProgramUniform2i("atlasSize", Shaders.atlasSizeX, Shaders.atlasSizeY);
                checkGLError("useProgram ", Shaders.programNames[llllllllllllllllllIllIIlIlIIIlII]);
            }
        }
    }
    
    public static void beginBlockEntities() {
        if (Shaders.isRenderingWorld) {
            checkGLError("beginBlockEntities");
            useProgram(13);
        }
    }
    
    private static int getTextureFormatFromString(String llllllllllllllllllIllIIIlllIllll) {
        llllllllllllllllllIllIIIlllIllll = llllllllllllllllllIllIIIlllIllll.trim();
        for (int llllllllllllllllllIllIIIlllIlllI = 0; llllllllllllllllllIllIIIlllIlllI < Shaders.formatNames.length; ++llllllllllllllllllIllIIIlllIlllI) {
            final String llllllllllllllllllIllIIIlllIllIl = Shaders.formatNames[llllllllllllllllllIllIIIlllIlllI];
            if (llllllllllllllllllIllIIIlllIllll.equals(llllllllllllllllllIllIIIlllIllIl)) {
                return Shaders.formatIds[llllllllllllllllllIllIIIlllIlllI];
            }
        }
        return 0;
    }
    
    private static IntBuffer nextIntBuffer(final int llllllllllllllllllIllIlllIlIlllI) {
        final ByteBuffer llllllllllllllllllIllIlllIlIllIl = Shaders.bigBuffer;
        final int llllllllllllllllllIllIlllIlIllII = llllllllllllllllllIllIlllIlIllIl.limit();
        llllllllllllllllllIllIlllIlIllIl.position(llllllllllllllllllIllIlllIlIllII).limit(llllllllllllllllllIllIlllIlIllII + llllllllllllllllllIllIlllIlIlllI * 4);
        return llllllllllllllllllIllIlllIlIllIl.asIntBuffer();
    }
    
    public static void endSky() {
        Shaders.isRenderingSky = false;
        setDrawBuffers(Shaders.dfbDrawBuffers);
        useProgram(Shaders.lightmapEnabled ? 3 : 2);
        popEntity();
    }
    
    public static void endParticles() {
        useProgram(3);
    }
    
    public static void setEntityId(final Entity llllllllllllllllllIlIllllllIlIIl) {
        if (Shaders.isRenderingWorld && !Shaders.isShadowPass && Shaders.uniformEntityId.isDefined()) {
            final int llllllllllllllllllIlIllllllIlIlI = EntityList.getEntityID(llllllllllllllllllIlIllllllIlIIl);
            Shaders.uniformEntityId.setValue(llllllllllllllllllIlIllllllIlIlI);
        }
    }
    
    private static boolean printLogInfo(final int llllllllllllllllllIllIIlIlllIlII, final String llllllllllllllllllIllIIlIllIllII) {
        final IntBuffer llllllllllllllllllIllIIlIlllIIlI = BufferUtils.createIntBuffer(1);
        ARBShaderObjects.glGetObjectParameterARB(llllllllllllllllllIllIIlIlllIlII, 35716, llllllllllllllllllIllIIlIlllIIlI);
        final int llllllllllllllllllIllIIlIlllIIIl = llllllllllllllllllIllIIlIlllIIlI.get();
        if (llllllllllllllllllIllIIlIlllIIIl > 1) {
            final ByteBuffer llllllllllllllllllIllIIlIlllIIII = BufferUtils.createByteBuffer(llllllllllllllllllIllIIlIlllIIIl);
            llllllllllllllllllIllIIlIlllIIlI.flip();
            ARBShaderObjects.glGetInfoLogARB(llllllllllllllllllIllIIlIlllIlII, llllllllllllllllllIllIIlIlllIIlI, llllllllllllllllllIllIIlIlllIIII);
            final byte[] llllllllllllllllllIllIIlIllIllll = new byte[llllllllllllllllllIllIIlIlllIIIl];
            llllllllllllllllllIllIIlIlllIIII.get(llllllllllllllllllIllIIlIllIllll);
            if (llllllllllllllllllIllIIlIllIllll[llllllllllllllllllIllIIlIlllIIIl - 1] == 0) {
                llllllllllllllllllIllIIlIllIllll[llllllllllllllllllIllIIlIlllIIIl - 1] = 10;
            }
            final String llllllllllllllllllIllIIlIllIlllI = new String(llllllllllllllllllIllIIlIllIllll);
            SMCLog.info(String.valueOf(new StringBuilder("Info log: ").append(llllllllllllllllllIllIIlIllIllII).append("\n").append(llllllllllllllllllIllIIlIllIlllI)));
            return false;
        }
        return true;
    }
    
    public static void drawHorizon() {
        final WorldRenderer llllllllllllllllllIllIIIIIIIIIll = Tessellator.getInstance().getWorldRenderer();
        final float llllllllllllllllllIllIIIIIIIIIlI = (float)(Shaders.mc.gameSettings.renderDistanceChunks * 16);
        final double llllllllllllllllllIllIIIIIIIIIIl = llllllllllllllllllIllIIIIIIIIIlI * 0.9238;
        final double llllllllllllllllllIllIIIIIIIIIII = llllllllllllllllllIllIIIIIIIIIlI * 0.3826;
        final double llllllllllllllllllIlIlllllllllll = -llllllllllllllllllIllIIIIIIIIIII;
        final double llllllllllllllllllIlIllllllllllI = -llllllllllllllllllIllIIIIIIIIIIl;
        final double llllllllllllllllllIlIlllllllllIl = 16.0;
        final double llllllllllllllllllIlIlllllllllII = -Shaders.cameraPositionY;
        llllllllllllllllllIllIIIIIIIIIll.startDrawingQuads();
        llllllllllllllllllIllIIIIIIIIIll.addVertex(llllllllllllllllllIlIlllllllllll, llllllllllllllllllIlIlllllllllII, llllllllllllllllllIlIllllllllllI);
        llllllllllllllllllIllIIIIIIIIIll.addVertex(llllllllllllllllllIlIlllllllllll, llllllllllllllllllIlIlllllllllIl, llllllllllllllllllIlIllllllllllI);
        llllllllllllllllllIllIIIIIIIIIll.addVertex(llllllllllllllllllIlIllllllllllI, llllllllllllllllllIlIlllllllllIl, llllllllllllllllllIlIlllllllllll);
        llllllllllllllllllIllIIIIIIIIIll.addVertex(llllllllllllllllllIlIllllllllllI, llllllllllllllllllIlIlllllllllII, llllllllllllllllllIlIlllllllllll);
        llllllllllllllllllIllIIIIIIIIIll.addVertex(llllllllllllllllllIlIllllllllllI, llllllllllllllllllIlIlllllllllII, llllllllllllllllllIlIlllllllllll);
        llllllllllllllllllIllIIIIIIIIIll.addVertex(llllllllllllllllllIlIllllllllllI, llllllllllllllllllIlIlllllllllIl, llllllllllllllllllIlIlllllllllll);
        llllllllllllllllllIllIIIIIIIIIll.addVertex(llllllllllllllllllIlIllllllllllI, llllllllllllllllllIlIlllllllllIl, llllllllllllllllllIllIIIIIIIIIII);
        llllllllllllllllllIllIIIIIIIIIll.addVertex(llllllllllllllllllIlIllllllllllI, llllllllllllllllllIlIlllllllllII, llllllllllllllllllIllIIIIIIIIIII);
        llllllllllllllllllIllIIIIIIIIIll.addVertex(llllllllllllllllllIlIllllllllllI, llllllllllllllllllIlIlllllllllII, llllllllllllllllllIllIIIIIIIIIII);
        llllllllllllllllllIllIIIIIIIIIll.addVertex(llllllllllllllllllIlIllllllllllI, llllllllllllllllllIlIlllllllllIl, llllllllllllllllllIllIIIIIIIIIII);
        llllllllllllllllllIllIIIIIIIIIll.addVertex(llllllllllllllllllIlIlllllllllll, llllllllllllllllllIlIlllllllllIl, llllllllllllllllllIllIIIIIIIIIII);
        llllllllllllllllllIllIIIIIIIIIll.addVertex(llllllllllllllllllIlIlllllllllll, llllllllllllllllllIlIlllllllllII, llllllllllllllllllIllIIIIIIIIIII);
        llllllllllllllllllIllIIIIIIIIIll.addVertex(llllllllllllllllllIlIlllllllllll, llllllllllllllllllIlIlllllllllII, llllllllllllllllllIllIIIIIIIIIII);
        llllllllllllllllllIllIIIIIIIIIll.addVertex(llllllllllllllllllIlIlllllllllll, llllllllllllllllllIlIlllllllllIl, llllllllllllllllllIllIIIIIIIIIII);
        llllllllllllllllllIllIIIIIIIIIll.addVertex(llllllllllllllllllIllIIIIIIIIIII, llllllllllllllllllIlIlllllllllIl, llllllllllllllllllIllIIIIIIIIIIl);
        llllllllllllllllllIllIIIIIIIIIll.addVertex(llllllllllllllllllIllIIIIIIIIIII, llllllllllllllllllIlIlllllllllII, llllllllllllllllllIllIIIIIIIIIIl);
        llllllllllllllllllIllIIIIIIIIIll.addVertex(llllllllllllllllllIllIIIIIIIIIII, llllllllllllllllllIlIlllllllllII, llllllllllllllllllIllIIIIIIIIIIl);
        llllllllllllllllllIllIIIIIIIIIll.addVertex(llllllllllllllllllIllIIIIIIIIIII, llllllllllllllllllIlIlllllllllIl, llllllllllllllllllIllIIIIIIIIIIl);
        llllllllllllllllllIllIIIIIIIIIll.addVertex(llllllllllllllllllIllIIIIIIIIIIl, llllllllllllllllllIlIlllllllllIl, llllllllllllllllllIllIIIIIIIIIII);
        llllllllllllllllllIllIIIIIIIIIll.addVertex(llllllllllllllllllIllIIIIIIIIIIl, llllllllllllllllllIlIlllllllllII, llllllllllllllllllIllIIIIIIIIIII);
        llllllllllllllllllIllIIIIIIIIIll.addVertex(llllllllllllllllllIllIIIIIIIIIIl, llllllllllllllllllIlIlllllllllII, llllllllllllllllllIllIIIIIIIIIII);
        llllllllllllllllllIllIIIIIIIIIll.addVertex(llllllllllllllllllIllIIIIIIIIIIl, llllllllllllllllllIlIlllllllllIl, llllllllllllllllllIllIIIIIIIIIII);
        llllllllllllllllllIllIIIIIIIIIll.addVertex(llllllllllllllllllIllIIIIIIIIIIl, llllllllllllllllllIlIlllllllllIl, llllllllllllllllllIlIlllllllllll);
        llllllllllllllllllIllIIIIIIIIIll.addVertex(llllllllllllllllllIllIIIIIIIIIIl, llllllllllllllllllIlIlllllllllII, llllllllllllllllllIlIlllllllllll);
        llllllllllllllllllIllIIIIIIIIIll.addVertex(llllllllllllllllllIllIIIIIIIIIIl, llllllllllllllllllIlIlllllllllII, llllllllllllllllllIlIlllllllllll);
        llllllllllllllllllIllIIIIIIIIIll.addVertex(llllllllllllllllllIllIIIIIIIIIIl, llllllllllllllllllIlIlllllllllIl, llllllllllllllllllIlIlllllllllll);
        llllllllllllllllllIllIIIIIIIIIll.addVertex(llllllllllllllllllIllIIIIIIIIIII, llllllllllllllllllIlIlllllllllIl, llllllllllllllllllIlIllllllllllI);
        llllllllllllllllllIllIIIIIIIIIll.addVertex(llllllllllllllllllIllIIIIIIIIIII, llllllllllllllllllIlIlllllllllII, llllllllllllllllllIlIllllllllllI);
        llllllllllllllllllIllIIIIIIIIIll.addVertex(llllllllllllllllllIllIIIIIIIIIII, llllllllllllllllllIlIlllllllllII, llllllllllllllllllIlIllllllllllI);
        llllllllllllllllllIllIIIIIIIIIll.addVertex(llllllllllllllllllIllIIIIIIIIIII, llllllllllllllllllIlIlllllllllIl, llllllllllllllllllIlIllllllllllI);
        llllllllllllllllllIllIIIIIIIIIll.addVertex(llllllllllllllllllIlIlllllllllll, llllllllllllllllllIlIlllllllllIl, llllllllllllllllllIlIllllllllllI);
        llllllllllllllllllIllIIIIIIIIIll.addVertex(llllllllllllllllllIlIlllllllllll, llllllllllllllllllIlIlllllllllII, llllllllllllllllllIlIllllllllllI);
        Tessellator.getInstance().draw();
    }
    
    public static void endUpdateChunks() {
        checkGLError("endUpdateChunks1");
        checkFramebufferStatus("endUpdateChunks1");
        if (!Shaders.isShadowPass) {
            useProgram(7);
        }
        checkGLError("endUpdateChunks2");
        checkFramebufferStatus("endUpdateChunks2");
    }
    
    public static void enableLightmap() {
        Shaders.lightmapEnabled = true;
        if (Shaders.activeProgram == 2) {
            useProgram(3);
        }
    }
    
    private static String toStringYN(final boolean llllllllllllllllllIllIlIIIllllll) {
        return llllllllllllllllllIllIlIIIllllll ? "Y" : "N";
    }
    
    public static void beginSpiderEyes() {
        if (Shaders.isRenderingWorld && Shaders.programsID[18] != Shaders.programsID[0]) {
            useProgram(18);
            GlStateManager.enableAlpha();
            GlStateManager.alphaFunc(516, 0.0f);
            GlStateManager.blendFunc(770, 771);
        }
    }
    
    public static void setCamera(final float llllllllllllllllllIllIIIIllIIIII) {
        final Entity llllllllllllllllllIllIIIIlIlllll = Shaders.mc.func_175606_aa();
        final double llllllllllllllllllIllIIIIlIllllI = llllllllllllllllllIllIIIIlIlllll.lastTickPosX + (llllllllllllllllllIllIIIIlIlllll.posX - llllllllllllllllllIllIIIIlIlllll.lastTickPosX) * llllllllllllllllllIllIIIIllIIIII;
        final double llllllllllllllllllIllIIIIlIlllIl = llllllllllllllllllIllIIIIlIlllll.lastTickPosY + (llllllllllllllllllIllIIIIlIlllll.posY - llllllllllllllllllIllIIIIlIlllll.lastTickPosY) * llllllllllllllllllIllIIIIllIIIII;
        final double llllllllllllllllllIllIIIIlIlllII = llllllllllllllllllIllIIIIlIlllll.lastTickPosZ + (llllllllllllllllllIllIIIIlIlllll.posZ - llllllllllllllllllIllIIIIlIlllll.lastTickPosZ) * llllllllllllllllllIllIIIIllIIIII;
        Shaders.cameraPositionX = llllllllllllllllllIllIIIIlIllllI;
        Shaders.cameraPositionY = llllllllllllllllllIllIIIIlIlllIl;
        Shaders.cameraPositionZ = llllllllllllllllllIllIIIIlIlllII;
        GL11.glGetFloat(2983, (FloatBuffer)Shaders.projection.position(0));
        SMath.invertMat4FBFA((FloatBuffer)Shaders.projectionInverse.position(0), (FloatBuffer)Shaders.projection.position(0), Shaders.faProjectionInverse, Shaders.faProjection);
        Shaders.projection.position(0);
        Shaders.projectionInverse.position(0);
        GL11.glGetFloat(2982, (FloatBuffer)Shaders.modelView.position(0));
        SMath.invertMat4FBFA((FloatBuffer)Shaders.modelViewInverse.position(0), (FloatBuffer)Shaders.modelView.position(0), Shaders.faModelViewInverse, Shaders.faModelView);
        Shaders.modelView.position(0);
        Shaders.modelViewInverse.position(0);
        checkGLError("setCamera");
    }
    
    public static void startup(final Minecraft llllllllllllllllllIllIlIIlIIIIll) {
        checkShadersModInstalled();
        Shaders.mc = llllllllllllllllllIllIlIIlIIIIll;
        Shaders.capabilities = GLContext.getCapabilities();
        Shaders.glVersionString = GL11.glGetString(7938);
        Shaders.glVendorString = GL11.glGetString(7936);
        Shaders.glRendererString = GL11.glGetString(7937);
        SMCLog.info("ShadersMod version: 2.4.12");
        SMCLog.info(String.valueOf(new StringBuilder("OpenGL Version: ").append(Shaders.glVersionString)));
        SMCLog.info(String.valueOf(new StringBuilder("Vendor:  ").append(Shaders.glVendorString)));
        SMCLog.info(String.valueOf(new StringBuilder("Renderer: ").append(Shaders.glRendererString)));
        SMCLog.info(String.valueOf(new StringBuilder("Capabilities: ").append(Shaders.capabilities.OpenGL20 ? " 2.0 " : " - ").append(Shaders.capabilities.OpenGL21 ? " 2.1 " : " - ").append(Shaders.capabilities.OpenGL30 ? " 3.0 " : " - ").append(Shaders.capabilities.OpenGL32 ? " 3.2 " : " - ").append(Shaders.capabilities.OpenGL40 ? " 4.0 " : " - ")));
        SMCLog.info(String.valueOf(new StringBuilder("GL_MAX_DRAW_BUFFERS: ").append(GL11.glGetInteger(34852))));
        SMCLog.info(String.valueOf(new StringBuilder("GL_MAX_COLOR_ATTACHMENTS_EXT: ").append(GL11.glGetInteger(36063))));
        SMCLog.info(String.valueOf(new StringBuilder("GL_MAX_TEXTURE_IMAGE_UNITS: ").append(GL11.glGetInteger(34930))));
        Shaders.hasGlGenMipmap = Shaders.capabilities.OpenGL30;
        loadConfig();
    }
    
    private static Properties loadOptionProperties(final IShaderPack llllllllllllllllllIllIlIlIlllIIl) throws IOException {
        final Properties llllllllllllllllllIllIlIlIllllIl = new Properties();
        final String llllllllllllllllllIllIlIlIllllII = String.valueOf(new StringBuilder(String.valueOf(Shaders.shaderpacksdirname)).append("/").append(llllllllllllllllllIllIlIlIlllIIl.getName()).append(".txt"));
        final File llllllllllllllllllIllIlIlIlllIll = new File(Minecraft.getMinecraft().mcDataDir, llllllllllllllllllIllIlIlIllllII);
        if (llllllllllllllllllIllIlIlIlllIll.exists() && llllllllllllllllllIllIlIlIlllIll.isFile() && llllllllllllllllllIllIlIlIlllIll.canRead()) {
            final FileInputStream llllllllllllllllllIllIlIlIlllIlI = new FileInputStream(llllllllllllllllllIllIlIlIlllIll);
            llllllllllllllllllIllIlIlIllllIl.load(llllllllllllllllllIllIlIlIlllIlI);
            llllllllllllllllllIllIlIlIlllIlI.close();
            return llllllllllllllllllIllIlIlIllllIl;
        }
        return llllllllllllllllllIllIlIlIllllIl;
    }
    
    public static boolean shouldRenderClouds(final GameSettings llllllllllllllllllIlIlllllllIIlI) {
        if (!Shaders.shaderPackLoaded) {
            return true;
        }
        checkGLError("shouldRenderClouds");
        return Shaders.isShadowPass ? Shaders.configCloudShadow : llllllllllllllllllIlIlllllllIIlI.clouds;
    }
    
    private static IntBuffer[] nextIntBufferArray(final int llllllllllllllllllIllIlllIIlIlll, final int llllllllllllllllllIllIlllIIllIlI) {
        final IntBuffer[] llllllllllllllllllIllIlllIIllIIl = new IntBuffer[llllllllllllllllllIllIlllIIlIlll];
        for (int llllllllllllllllllIllIlllIIllIII = 0; llllllllllllllllllIllIlllIIllIII < llllllllllllllllllIllIlllIIlIlll; ++llllllllllllllllllIllIlllIIllIII) {
            llllllllllllllllllIllIlllIIllIIl[llllllllllllllllllIllIlllIIllIII] = nextIntBuffer(llllllllllllllllllIllIlllIIllIlI);
        }
        return llllllllllllllllllIllIlllIIllIIl;
    }
    
    private static void setEnumShaderOption(final EnumShaderOption llllllllllllllllllIllIllIllllIll, String llllllllllllllllllIllIllIllllIlI) {
        if (llllllllllllllllllIllIllIllllIlI == null) {
            llllllllllllllllllIllIllIllllIlI = llllllllllllllllllIllIllIllllIll.getValueDefault();
        }
        switch (NamelessClass341846571.$SwitchMap$shadersmod$client$EnumShaderOption[llllllllllllllllllIllIllIllllIll.ordinal()]) {
            case 1: {
                Shaders.configAntialiasingLevel = Config.parseInt((String)llllllllllllllllllIllIllIllllIlI, 0);
                break;
            }
            case 2: {
                Shaders.configNormalMap = Config.parseBoolean((String)llllllllllllllllllIllIllIllllIlI, true);
                break;
            }
            case 3: {
                Shaders.configSpecularMap = Config.parseBoolean((String)llllllllllllllllllIllIllIllllIlI, true);
                break;
            }
            case 4: {
                Shaders.configRenderResMul = Config.parseFloat((String)llllllllllllllllllIllIllIllllIlI, 1.0f);
                break;
            }
            case 5: {
                Shaders.configShadowResMul = Config.parseFloat((String)llllllllllllllllllIllIllIllllIlI, 1.0f);
                break;
            }
            case 6: {
                Shaders.configHandDepthMul = Config.parseFloat((String)llllllllllllllllllIllIllIllllIlI, 0.125f);
                break;
            }
            case 7: {
                Shaders.configCloudShadow = Config.parseBoolean((String)llllllllllllllllllIllIllIllllIlI, true);
                break;
            }
            case 8: {
                Shaders.configOldLighting.setPropertyValue((String)llllllllllllllllllIllIllIllllIlI);
                break;
            }
            case 9: {
                Shaders.currentshadername = (String)llllllllllllllllllIllIllIllllIlI;
                break;
            }
            case 10: {
                Shaders.configTweakBlockDamage = Config.parseBoolean((String)llllllllllllllllllIllIllIllllIlI, true);
                break;
            }
            case 11: {
                Shaders.configShadowClipFrustrum = Config.parseBoolean((String)llllllllllllllllllIllIllIllllIlI, true);
                break;
            }
            case 12: {
                Shaders.configTexMinFilB = Config.parseInt((String)llllllllllllllllllIllIllIllllIlI, 0);
                break;
            }
            case 13: {
                Shaders.configTexMinFilN = Config.parseInt((String)llllllllllllllllllIllIllIllllIlI, 0);
                break;
            }
            case 14: {
                Shaders.configTexMinFilS = Config.parseInt((String)llllllllllllllllllIllIllIllllIlI, 0);
                break;
            }
            case 15: {
                Shaders.configTexMagFilB = Config.parseInt((String)llllllllllllllllllIllIllIllllIlI, 0);
                break;
            }
            case 16: {
                Shaders.configTexMagFilB = Config.parseInt((String)llllllllllllllllllIllIllIllllIlI, 0);
                break;
            }
            case 17: {
                Shaders.configTexMagFilB = Config.parseInt((String)llllllllllllllllllIllIllIllllIlI, 0);
                break;
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder("Unknown option: ").append(llllllllllllllllllIllIllIllllIll)));
            }
        }
    }
    
    public static void setDrawBuffers(IntBuffer llllllllllllllllllIllIIlIlIlIlIl) {
        if (llllllllllllllllllIllIIlIlIlIlIl == null) {
            llllllllllllllllllIllIIlIlIlIlIl = Shaders.drawBuffersNone;
        }
        if (Shaders.activeDrawBuffers != llllllllllllllllllIllIIlIlIlIlIl) {
            GL20.glDrawBuffers(Shaders.activeDrawBuffers = (IntBuffer)llllllllllllllllllIllIIlIlIlIlIl);
        }
    }
    
    private static void loadShaderPackDimensions() {
        Shaders.shaderPackDimensions.clear();
        final StringBuffer llllllllllllllllllIllIllIlIIllII = new StringBuffer();
        for (int llllllllllllllllllIllIllIlIIlIll = -128; llllllllllllllllllIllIllIlIIlIll <= 128; ++llllllllllllllllllIllIllIlIIlIll) {
            final String llllllllllllllllllIllIllIlIIlIlI = String.valueOf(new StringBuilder("/shaders/world").append(llllllllllllllllllIllIllIlIIlIll));
            if (Shaders.shaderPack.hasDirectory(llllllllllllllllllIllIllIlIIlIlI)) {
                Shaders.shaderPackDimensions.add(llllllllllllllllllIllIllIlIIlIll);
                llllllllllllllllllIllIllIlIIllII.append(String.valueOf(new StringBuilder(" ").append(llllllllllllllllllIllIllIlIIlIll)));
            }
        }
        if (llllllllllllllllllIllIllIlIIllII.length() > 0) {
            Config.dbg(String.valueOf(new StringBuilder("[Shaders] Dimensions:").append((Object)llllllllllllllllllIllIllIlIIllII)));
        }
    }
    
    public static void preCelestialRotate() {
        setUpPosition();
        GL11.glRotatef(Shaders.sunPathRotation * 1.0f, 0.0f, 0.0f, 1.0f);
        checkGLError("preCelestialRotate");
    }
    
    public static void mcProfilerEndSection() {
        Shaders.mc.mcProfiler.endSection();
    }
    
    private static void loadShaderPackResources() {
        Shaders.shaderPackResources = new HashMap<String, String>();
        if (Shaders.shaderPackLoaded) {
            final ArrayList llllllllllllllllllIlIllllIIIllIl = new ArrayList();
            final String llllllllllllllllllIlIllllIIIllII = "/shaders/lang/";
            final String llllllllllllllllllIlIllllIIIlIll = "en_US";
            final String llllllllllllllllllIlIllllIIIlIlI = ".lang";
            llllllllllllllllllIlIllllIIIllIl.add(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllllIlIllllIIIllII)).append(llllllllllllllllllIlIllllIIIlIll).append(llllllllllllllllllIlIllllIIIlIlI)));
            if (!Config.getGameSettings().language.equals(llllllllllllllllllIlIllllIIIlIll)) {
                llllllllllllllllllIlIllllIIIllIl.add(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllllIlIllllIIIllII)).append(Config.getGameSettings().language).append(llllllllllllllllllIlIllllIIIlIlI)));
            }
            try {
                for (final String llllllllllllllllllIlIllllIIIlIII : llllllllllllllllllIlIllllIIIllIl) {
                    final InputStream llllllllllllllllllIlIllllIIIIlll = Shaders.shaderPack.getResourceAsStream(llllllllllllllllllIlIllllIIIlIII);
                    if (llllllllllllllllllIlIllllIIIIlll != null) {
                        final Properties llllllllllllllllllIlIllllIIIIllI = new Properties();
                        Lang.loadLocaleData(llllllllllllllllllIlIllllIIIIlll, llllllllllllllllllIlIllllIIIIllI);
                        llllllllllllllllllIlIllllIIIIlll.close();
                        final Set llllllllllllllllllIlIllllIIIIlIl = llllllllllllllllllIlIllllIIIIllI.keySet();
                        for (final String llllllllllllllllllIlIllllIIIIIll : llllllllllllllllllIlIllllIIIIlIl) {
                            final String llllllllllllllllllIlIllllIIIIIlI = llllllllllllllllllIlIllllIIIIllI.getProperty(llllllllllllllllllIlIllllIIIIIll);
                            Shaders.shaderPackResources.put(llllllllllllllllllIlIllllIIIIIll, llllllllllllllllllIlIllllIIIIIlI);
                        }
                    }
                }
            }
            catch (IOException llllllllllllllllllIlIllllIIIIIIl) {
                llllllllllllllllllIlIllllIIIIIIl.printStackTrace();
            }
        }
    }
    
    public static ShaderOption getShaderOption(final String llllllllllllllllllIllIllIIIIIIIl) {
        return ShaderUtils.getShaderOption(llllllllllllllllllIllIllIIIIIIIl, Shaders.shaderPackOptions);
    }
    
    public static void enableTexture2D() {
        if (Shaders.isRenderingSky) {
            useProgram(5);
        }
        else if (Shaders.activeProgram == 1) {
            useProgram(Shaders.lightmapEnabled ? 3 : 2);
        }
    }
    
    public static void setSkyColor(final Vec3 llllllllllllllllllIllIIIIIIIllIl) {
        Shaders.skyColorR = (float)llllllllllllllllllIllIIIIIIIllIl.xCoord;
        Shaders.skyColorG = (float)llllllllllllllllllIllIIIIIIIllIl.yCoord;
        Shaders.skyColorB = (float)llllllllllllllllllIllIIIIIIIllIl.zCoord;
        setProgramUniform3f("skyColor", Shaders.skyColorR, Shaders.skyColorG, Shaders.skyColorB);
    }
    
    public static void scheduleResizeShadow() {
        Shaders.needResizeShadow = true;
    }
    
    public static void pushEntity(final Block llllllllllllllllllIlIllllIIllllI) {
        ++Shaders.entityDataIndex;
        Shaders.entityData[Shaders.entityDataIndex * 2] = ((Block.blockRegistry.getIDForObject(llllllllllllllllllIlIllllIIllllI) & 0xFFFF) | llllllllllllllllllIlIllllIIllllI.getRenderType() << 16);
        Shaders.entityData[Shaders.entityDataIndex * 2 + 1] = 0;
    }
    
    public static void sglFogi(final int llllllllllllllllllIlIllllIllIIlI, final int llllllllllllllllllIlIllllIlIllll) {
        GL11.glFogi(llllllllllllllllllIlIllllIllIIlI, llllllllllllllllllIlIllllIlIllll);
        if (llllllllllllllllllIlIllllIllIIlI == 2917) {
            Shaders.fogMode = llllllllllllllllllIlIllllIlIllll;
            if (Shaders.fogEnabled) {
                setProgramUniform1i("fogMode", Shaders.fogMode);
            }
        }
    }
    
    private static void setupShadowFrameBuffer() {
        if (Shaders.usedShadowDepthBuffers != 0) {
            if (Shaders.sfb != 0) {
                EXTFramebufferObject.glDeleteFramebuffersEXT(Shaders.sfb);
                GlStateManager.deleteTextures(Shaders.sfbDepthTextures);
                GlStateManager.deleteTextures(Shaders.sfbColorTextures);
            }
            EXTFramebufferObject.glBindFramebufferEXT(36160, Shaders.sfb = EXTFramebufferObject.glGenFramebuffersEXT());
            GL11.glDrawBuffer(0);
            GL11.glReadBuffer(0);
            GL11.glGenTextures((IntBuffer)Shaders.sfbDepthTextures.clear().limit(Shaders.usedShadowDepthBuffers));
            GL11.glGenTextures((IntBuffer)Shaders.sfbColorTextures.clear().limit(Shaders.usedShadowColorBuffers));
            Shaders.sfbDepthTextures.position(0);
            Shaders.sfbColorTextures.position(0);
            for (int llllllllllllllllllIllIIIlIlllIlI = 0; llllllllllllllllllIllIIIlIlllIlI < Shaders.usedShadowDepthBuffers; ++llllllllllllllllllIllIIIlIlllIlI) {
                GlStateManager.func_179144_i(Shaders.sfbDepthTextures.get(llllllllllllllllllIllIIIlIlllIlI));
                GL11.glTexParameterf(3553, 10242, 10496.0f);
                GL11.glTexParameterf(3553, 10243, 10496.0f);
                final int llllllllllllllllllIllIIIlIlllIIl = Shaders.shadowFilterNearest[llllllllllllllllllIllIIIlIlllIlI] ? 9728 : 9729;
                GL11.glTexParameteri(3553, 10241, llllllllllllllllllIllIIIlIlllIIl);
                GL11.glTexParameteri(3553, 10240, llllllllllllllllllIllIIIlIlllIIl);
                if (Shaders.shadowHardwareFilteringEnabled[llllllllllllllllllIllIIIlIlllIlI]) {
                    GL11.glTexParameteri(3553, 34892, 34894);
                }
                GL11.glTexImage2D(3553, 0, 6402, Shaders.shadowMapWidth, Shaders.shadowMapHeight, 0, 6402, 5126, (FloatBuffer)null);
            }
            EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36096, 3553, Shaders.sfbDepthTextures.get(0), 0);
            checkGLError("FT sd");
            for (int llllllllllllllllllIllIIIlIlllIlI = 0; llllllllllllllllllIllIIIlIlllIlI < Shaders.usedShadowColorBuffers; ++llllllllllllllllllIllIIIlIlllIlI) {
                GlStateManager.func_179144_i(Shaders.sfbColorTextures.get(llllllllllllllllllIllIIIlIlllIlI));
                GL11.glTexParameterf(3553, 10242, 10496.0f);
                GL11.glTexParameterf(3553, 10243, 10496.0f);
                final int llllllllllllllllllIllIIIlIlllIII = Shaders.shadowColorFilterNearest[llllllllllllllllllIllIIIlIlllIlI] ? 9728 : 9729;
                GL11.glTexParameteri(3553, 10241, llllllllllllllllllIllIIIlIlllIII);
                GL11.glTexParameteri(3553, 10240, llllllllllllllllllIllIIIlIlllIII);
                GL11.glTexImage2D(3553, 0, 6408, Shaders.shadowMapWidth, Shaders.shadowMapHeight, 0, 32993, 33639, (ByteBuffer)null);
                EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36064 + llllllllllllllllllIllIIIlIlllIlI, 3553, Shaders.sfbColorTextures.get(llllllllllllllllllIllIIIlIlllIlI), 0);
                checkGLError("FT sc");
            }
            GlStateManager.func_179144_i(0);
            if (Shaders.usedShadowColorBuffers > 0) {
                GL20.glDrawBuffers(Shaders.sfbDrawBuffers);
            }
            int llllllllllllllllllIllIIIlIlllIlI = EXTFramebufferObject.glCheckFramebufferStatusEXT(36160);
            if (llllllllllllllllllIllIIIlIlllIlI != 36053) {
                printChatAndLogError(String.valueOf(new StringBuilder("[Shaders] Error: Failed creating shadow framebuffer! (Status ").append(llllllllllllllllllIllIIIlIlllIlI).append(")")));
            }
            else {
                SMCLog.info("Shadow framebuffer created.");
            }
        }
    }
    
    private static ShaderOption[] loadShaderPackOptions() {
        try {
            final ShaderOption[] llllllllllllllllllIllIlIllIIlllI = ShaderPackParser.parseShaderPackOptions(Shaders.shaderPack, Shaders.programNames, Shaders.shaderPackDimensions);
            final Properties llllllllllllllllllIllIlIllIIllIl = loadOptionProperties(Shaders.shaderPack);
            for (int llllllllllllllllllIllIlIllIIllII = 0; llllllllllllllllllIllIlIllIIllII < llllllllllllllllllIllIlIllIIlllI.length; ++llllllllllllllllllIllIlIllIIllII) {
                final ShaderOption llllllllllllllllllIllIlIllIIlIll = llllllllllllllllllIllIlIllIIlllI[llllllllllllllllllIllIlIllIIllII];
                final String llllllllllllllllllIllIlIllIIlIlI = llllllllllllllllllIllIlIllIIllIl.getProperty(llllllllllllllllllIllIlIllIIlIll.getName());
                if (llllllllllllllllllIllIlIllIIlIlI != null) {
                    llllllllllllllllllIllIlIllIIlIll.resetValue();
                    if (!llllllllllllllllllIllIlIllIIlIll.setValue(llllllllllllllllllIllIlIllIIlIlI)) {
                        Config.warn(String.valueOf(new StringBuilder("[Shaders] Invalid value, option: ").append(llllllllllllllllllIllIlIllIIlIll.getName()).append(", value: ").append(llllllllllllllllllIllIlIllIIlIlI)));
                    }
                }
            }
            return llllllllllllllllllIllIlIllIIlllI;
        }
        catch (IOException llllllllllllllllllIllIlIllIIlIIl) {
            Config.warn(String.valueOf(new StringBuilder("[Shaders] Error reading configuration for ").append(Shaders.shaderPack.getName())));
            llllllllllllllllllIllIlIllIIlIIl.printStackTrace();
            return null;
        }
    }
    
    private static int createFragShader(final String llllllllllllllllllIllIIlllIIIIIl) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: invokestatic    org/lwjgl/opengl/ARBShaderObjects.glCreateShaderObjectARB:(I)I
        //     6: istore_1        /* llllllllllllllllllIllIIllIIlllII */
        //     7: iload_1         /* llllllllllllllllllIllIIlllIIIIII */
        //     8: ifne            13
        //    11: iconst_0       
        //    12: ireturn        
        //    13: new             Ljava/lang/StringBuilder;
        //    16: dup            
        //    17: ldc_w           131072
        //    20: invokespecial   java/lang/StringBuilder.<init>:(I)V
        //    23: astore_2        /* llllllllllllllllllIllIIllIllllll */
        //    24: aconst_null    
        //    25: astore_3        /* llllllllllllllllllIllIIllIIllIlI */
        //    26: new             Ljava/io/BufferedReader;
        //    29: dup            
        //    30: new             Ljava/io/InputStreamReader;
        //    33: dup            
        //    34: getstatic       shadersmod/client/Shaders.shaderPack:Lshadersmod/client/IShaderPack;
        //    37: aload_0         /* llllllllllllllllllIllIIllIIlllIl */
        //    38: invokeinterface shadersmod/client/IShaderPack.getResourceAsStream:(Ljava/lang/String;)Ljava/io/InputStream;
        //    43: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;)V
        //    46: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;)V
        //    49: astore_3        /* llllllllllllllllllIllIIllIlllllI */
        //    50: goto            89
        //    53: astore          llllllllllllllllllIllIIllIllllIl
        //    55: new             Ljava/io/BufferedReader;
        //    58: dup            
        //    59: new             Ljava/io/FileReader;
        //    62: dup            
        //    63: new             Ljava/io/File;
        //    66: dup            
        //    67: aload_0         /* llllllllllllllllllIllIIllIIlllIl */
        //    68: invokespecial   java/io/File.<init>:(Ljava/lang/String;)V
        //    71: invokespecial   java/io/FileReader.<init>:(Ljava/io/File;)V
        //    74: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;)V
        //    77: astore_3        /* llllllllllllllllllIllIIllIlllllI */
        //    78: goto            89
        //    81: astore          llllllllllllllllllIllIIllIllllII
        //    83: iload_1         /* llllllllllllllllllIllIIlllIIIIII */
        //    84: invokestatic    org/lwjgl/opengl/ARBShaderObjects.glDeleteObjectARB:(I)V
        //    87: iconst_0       
        //    88: ireturn        
        //    89: getstatic       shadersmod/client/Shaders.shaderPackOptions:[Lshadersmod/client/ShaderOption;
        //    92: invokestatic    shadersmod/client/Shaders.getChangedOptions:([Lshadersmod/client/ShaderOption;)[Lshadersmod/client/ShaderOption;
        //    95: astore          llllllllllllllllllIllIIllIlllIll
        //    97: aload_3         /* llllllllllllllllllIllIIllIlllllI */
        //    98: ifnull          2444
        //   101: aload_3         /* llllllllllllllllllIllIIllIlllllI */
        //   102: aload_0         /* llllllllllllllllllIllIIllIIlllIl */
        //   103: getstatic       shadersmod/client/Shaders.shaderPack:Lshadersmod/client/IShaderPack;
        //   106: iconst_0       
        //   107: invokestatic    shadersmod/client/ShaderPackParser.resolveIncludes:(Ljava/io/BufferedReader;Ljava/lang/String;Lshadersmod/client/IShaderPack;I)Ljava/io/BufferedReader;
        //   110: astore_3        /* llllllllllllllllllIllIIllIlllllI */
        //   111: goto            2388
        //   114: aload           llllllllllllllllllIllIIllIlllIlI
        //   116: aload           llllllllllllllllllIllIIllIlllIll
        //   118: invokestatic    shadersmod/client/Shaders.applyOptions:(Ljava/lang/String;[Lshadersmod/client/ShaderOption;)Ljava/lang/String;
        //   121: astore          llllllllllllllllllIllIIllIlllIlI
        //   123: aload_2         /* llllllllllllllllllIllIIllIllllll */
        //   124: aload           llllllllllllllllllIllIIllIlllIlI
        //   126: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   129: bipush          10
        //   131: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //   134: pop            
        //   135: aload           llllllllllllllllllIllIIllIlllIlI
        //   137: ldc_w           "#version .*"
        //   140: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //   143: ifne            2388
        //   146: aload           llllllllllllllllllIllIIllIlllIlI
        //   148: ldc_w           "uniform [ _a-zA-Z0-9]+ shadow;.*"
        //   151: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //   154: ifeq            171
        //   157: getstatic       shadersmod/client/Shaders.usedShadowDepthBuffers:I
        //   160: iconst_1       
        //   161: if_icmpge       2388
        //   164: iconst_1       
        //   165: putstatic       shadersmod/client/Shaders.usedShadowDepthBuffers:I
        //   168: goto            2388
        //   171: aload           llllllllllllllllllIllIIllIlllIlI
        //   173: ldc_w           "uniform [ _a-zA-Z0-9]+ watershadow;.*"
        //   176: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //   179: ifeq            200
        //   182: iconst_1       
        //   183: putstatic       shadersmod/client/Shaders.waterShadowEnabled:Z
        //   186: getstatic       shadersmod/client/Shaders.usedShadowDepthBuffers:I
        //   189: iconst_2       
        //   190: if_icmpge       2388
        //   193: iconst_2       
        //   194: putstatic       shadersmod/client/Shaders.usedShadowDepthBuffers:I
        //   197: goto            2388
        //   200: aload           llllllllllllllllllIllIIllIlllIlI
        //   202: ldc_w           "uniform [ _a-zA-Z0-9]+ shadowtex0;.*"
        //   205: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //   208: ifeq            225
        //   211: getstatic       shadersmod/client/Shaders.usedShadowDepthBuffers:I
        //   214: iconst_1       
        //   215: if_icmpge       2388
        //   218: iconst_1       
        //   219: putstatic       shadersmod/client/Shaders.usedShadowDepthBuffers:I
        //   222: goto            2388
        //   225: aload           llllllllllllllllllIllIIllIlllIlI
        //   227: ldc_w           "uniform [ _a-zA-Z0-9]+ shadowtex1;.*"
        //   230: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //   233: ifeq            250
        //   236: getstatic       shadersmod/client/Shaders.usedShadowDepthBuffers:I
        //   239: iconst_2       
        //   240: if_icmpge       2388
        //   243: iconst_2       
        //   244: putstatic       shadersmod/client/Shaders.usedShadowDepthBuffers:I
        //   247: goto            2388
        //   250: aload           llllllllllllllllllIllIIllIlllIlI
        //   252: ldc_w           "uniform [ _a-zA-Z0-9]+ shadowcolor;.*"
        //   255: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //   258: ifeq            275
        //   261: getstatic       shadersmod/client/Shaders.usedShadowColorBuffers:I
        //   264: iconst_1       
        //   265: if_icmpge       2388
        //   268: iconst_1       
        //   269: putstatic       shadersmod/client/Shaders.usedShadowColorBuffers:I
        //   272: goto            2388
        //   275: aload           llllllllllllllllllIllIIllIlllIlI
        //   277: ldc_w           "uniform [ _a-zA-Z0-9]+ shadowcolor0;.*"
        //   280: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //   283: ifeq            300
        //   286: getstatic       shadersmod/client/Shaders.usedShadowColorBuffers:I
        //   289: iconst_1       
        //   290: if_icmpge       2388
        //   293: iconst_1       
        //   294: putstatic       shadersmod/client/Shaders.usedShadowColorBuffers:I
        //   297: goto            2388
        //   300: aload           llllllllllllllllllIllIIllIlllIlI
        //   302: ldc_w           "uniform [ _a-zA-Z0-9]+ shadowcolor1;.*"
        //   305: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //   308: ifeq            325
        //   311: getstatic       shadersmod/client/Shaders.usedShadowColorBuffers:I
        //   314: iconst_2       
        //   315: if_icmpge       2388
        //   318: iconst_2       
        //   319: putstatic       shadersmod/client/Shaders.usedShadowColorBuffers:I
        //   322: goto            2388
        //   325: aload           llllllllllllllllllIllIIllIlllIlI
        //   327: ldc_w           "uniform [ _a-zA-Z0-9]+ shadowcolor2;.*"
        //   330: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //   333: ifeq            350
        //   336: getstatic       shadersmod/client/Shaders.usedShadowColorBuffers:I
        //   339: iconst_3       
        //   340: if_icmpge       2388
        //   343: iconst_3       
        //   344: putstatic       shadersmod/client/Shaders.usedShadowColorBuffers:I
        //   347: goto            2388
        //   350: aload           llllllllllllllllllIllIIllIlllIlI
        //   352: ldc_w           "uniform [ _a-zA-Z0-9]+ shadowcolor3;.*"
        //   355: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //   358: ifeq            375
        //   361: getstatic       shadersmod/client/Shaders.usedShadowColorBuffers:I
        //   364: iconst_4       
        //   365: if_icmpge       2388
        //   368: iconst_4       
        //   369: putstatic       shadersmod/client/Shaders.usedShadowColorBuffers:I
        //   372: goto            2388
        //   375: aload           llllllllllllllllllIllIIllIlllIlI
        //   377: ldc_w           "uniform [ _a-zA-Z0-9]+ depthtex0;.*"
        //   380: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //   383: ifeq            400
        //   386: getstatic       shadersmod/client/Shaders.usedDepthBuffers:I
        //   389: iconst_1       
        //   390: if_icmpge       2388
        //   393: iconst_1       
        //   394: putstatic       shadersmod/client/Shaders.usedDepthBuffers:I
        //   397: goto            2388
        //   400: aload           llllllllllllllllllIllIIllIlllIlI
        //   402: ldc_w           "uniform [ _a-zA-Z0-9]+ depthtex1;.*"
        //   405: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //   408: ifeq            425
        //   411: getstatic       shadersmod/client/Shaders.usedDepthBuffers:I
        //   414: iconst_2       
        //   415: if_icmpge       2388
        //   418: iconst_2       
        //   419: putstatic       shadersmod/client/Shaders.usedDepthBuffers:I
        //   422: goto            2388
        //   425: aload           llllllllllllllllllIllIIllIlllIlI
        //   427: ldc_w           "uniform [ _a-zA-Z0-9]+ depthtex2;.*"
        //   430: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //   433: ifeq            450
        //   436: getstatic       shadersmod/client/Shaders.usedDepthBuffers:I
        //   439: iconst_3       
        //   440: if_icmpge       2388
        //   443: iconst_3       
        //   444: putstatic       shadersmod/client/Shaders.usedDepthBuffers:I
        //   447: goto            2388
        //   450: aload           llllllllllllllllllIllIIllIlllIlI
        //   452: ldc_w           "uniform [ _a-zA-Z0-9]+ gdepth;.*"
        //   455: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //   458: ifeq            483
        //   461: getstatic       shadersmod/client/Shaders.gbuffersFormat:[I
        //   464: iconst_1       
        //   465: iaload         
        //   466: sipush          6408
        //   469: if_icmpne       2388
        //   472: getstatic       shadersmod/client/Shaders.gbuffersFormat:[I
        //   475: iconst_1       
        //   476: ldc_w           34836
        //   479: iastore        
        //   480: goto            2388
        //   483: getstatic       shadersmod/client/Shaders.usedColorBuffers:I
        //   486: iconst_5       
        //   487: if_icmpge       508
        //   490: aload           llllllllllllllllllIllIIllIlllIlI
        //   492: ldc_w           "uniform [ _a-zA-Z0-9]+ gaux1;.*"
        //   495: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //   498: ifeq            508
        //   501: iconst_5       
        //   502: putstatic       shadersmod/client/Shaders.usedColorBuffers:I
        //   505: goto            2388
        //   508: getstatic       shadersmod/client/Shaders.usedColorBuffers:I
        //   511: bipush          6
        //   513: if_icmpge       535
        //   516: aload           llllllllllllllllllIllIIllIlllIlI
        //   518: ldc_w           "uniform [ _a-zA-Z0-9]+ gaux2;.*"
        //   521: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //   524: ifeq            535
        //   527: bipush          6
        //   529: putstatic       shadersmod/client/Shaders.usedColorBuffers:I
        //   532: goto            2388
        //   535: getstatic       shadersmod/client/Shaders.usedColorBuffers:I
        //   538: bipush          7
        //   540: if_icmpge       562
        //   543: aload           llllllllllllllllllIllIIllIlllIlI
        //   545: ldc_w           "uniform [ _a-zA-Z0-9]+ gaux3;.*"
        //   548: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //   551: ifeq            562
        //   554: bipush          7
        //   556: putstatic       shadersmod/client/Shaders.usedColorBuffers:I
        //   559: goto            2388
        //   562: getstatic       shadersmod/client/Shaders.usedColorBuffers:I
        //   565: bipush          8
        //   567: if_icmpge       589
        //   570: aload           llllllllllllllllllIllIIllIlllIlI
        //   572: ldc_w           "uniform [ _a-zA-Z0-9]+ gaux4;.*"
        //   575: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //   578: ifeq            589
        //   581: bipush          8
        //   583: putstatic       shadersmod/client/Shaders.usedColorBuffers:I
        //   586: goto            2388
        //   589: getstatic       shadersmod/client/Shaders.usedColorBuffers:I
        //   592: iconst_5       
        //   593: if_icmpge       614
        //   596: aload           llllllllllllllllllIllIIllIlllIlI
        //   598: ldc_w           "uniform [ _a-zA-Z0-9]+ colortex4;.*"
        //   601: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //   604: ifeq            614
        //   607: iconst_5       
        //   608: putstatic       shadersmod/client/Shaders.usedColorBuffers:I
        //   611: goto            2388
        //   614: getstatic       shadersmod/client/Shaders.usedColorBuffers:I
        //   617: bipush          6
        //   619: if_icmpge       641
        //   622: aload           llllllllllllllllllIllIIllIlllIlI
        //   624: ldc_w           "uniform [ _a-zA-Z0-9]+ colortex5;.*"
        //   627: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //   630: ifeq            641
        //   633: bipush          6
        //   635: putstatic       shadersmod/client/Shaders.usedColorBuffers:I
        //   638: goto            2388
        //   641: getstatic       shadersmod/client/Shaders.usedColorBuffers:I
        //   644: bipush          7
        //   646: if_icmpge       668
        //   649: aload           llllllllllllllllllIllIIllIlllIlI
        //   651: ldc_w           "uniform [ _a-zA-Z0-9]+ colortex6;.*"
        //   654: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //   657: ifeq            668
        //   660: bipush          7
        //   662: putstatic       shadersmod/client/Shaders.usedColorBuffers:I
        //   665: goto            2388
        //   668: getstatic       shadersmod/client/Shaders.usedColorBuffers:I
        //   671: bipush          8
        //   673: if_icmpge       695
        //   676: aload           llllllllllllllllllIllIIllIlllIlI
        //   678: ldc_w           "uniform [ _a-zA-Z0-9]+ colortex7;.*"
        //   681: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //   684: ifeq            695
        //   687: bipush          8
        //   689: putstatic       shadersmod/client/Shaders.usedColorBuffers:I
        //   692: goto            2388
        //   695: getstatic       shadersmod/client/Shaders.usedColorBuffers:I
        //   698: bipush          8
        //   700: if_icmpge       721
        //   703: aload           llllllllllllllllllIllIIllIlllIlI
        //   705: ldc_w           "uniform [ _a-zA-Z0-9]+ centerDepthSmooth;.*"
        //   708: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //   711: ifeq            721
        //   714: iconst_1       
        //   715: putstatic       shadersmod/client/Shaders.centerDepthSmoothEnabled:Z
        //   718: goto            2388
        //   721: aload           llllllllllllllllllIllIIllIlllIlI
        //   723: ldc_w           "/\\* SHADOWRES:[0-9]+ \\*/.*"
        //   726: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //   729: ifeq            801
        //   732: aload           llllllllllllllllllIllIIllIlllIlI
        //   734: ldc_w           "(:| )"
        //   737: iconst_4       
        //   738: invokevirtual   java/lang/String.split:(Ljava/lang/String;I)[Ljava/lang/String;
        //   741: astore          llllllllllllllllllIllIIllIlllIII
        //   743: new             Ljava/lang/StringBuilder;
        //   746: dup            
        //   747: ldc_w           "Shadow map resolution: "
        //   750: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   753: aload           llllllllllllllllllIllIIllIlllIII
        //   755: iconst_2       
        //   756: aaload         
        //   757: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   760: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   763: invokestatic    shadersmod/common/SMCLog.info:(Ljava/lang/String;)V
        //   766: aload           llllllllllllllllllIllIIllIlllIII
        //   768: iconst_2       
        //   769: aaload         
        //   770: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //   773: dup            
        //   774: putstatic       shadersmod/client/Shaders.spShadowMapHeight:I
        //   777: putstatic       shadersmod/client/Shaders.spShadowMapWidth:I
        //   780: getstatic       shadersmod/client/Shaders.spShadowMapWidth:I
        //   783: i2f            
        //   784: getstatic       shadersmod/client/Shaders.configShadowResMul:F
        //   787: fmul           
        //   788: invokestatic    java/lang/Math.round:(F)I
        //   791: dup            
        //   792: putstatic       shadersmod/client/Shaders.shadowMapHeight:I
        //   795: putstatic       shadersmod/client/Shaders.shadowMapWidth:I
        //   798: goto            2388
        //   801: aload           llllllllllllllllllIllIIllIlllIlI
        //   803: ldc_w           "[ \t]*const[ \t]*int[ \t]*shadowMapResolution[ \t]*=[ \t]*-?[0-9.]+f?;.*"
        //   806: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //   809: ifeq            880
        //   812: aload           llllllllllllllllllIllIIllIlllIlI
        //   814: ldc_w           "(=[ \t]*|;)"
        //   817: invokevirtual   java/lang/String.split:(Ljava/lang/String;)[Ljava/lang/String;
        //   820: astore          llllllllllllllllllIllIIllIllIlll
        //   822: new             Ljava/lang/StringBuilder;
        //   825: dup            
        //   826: ldc_w           "Shadow map resolution: "
        //   829: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   832: aload           llllllllllllllllllIllIIllIllIlll
        //   834: iconst_1       
        //   835: aaload         
        //   836: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   839: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   842: invokestatic    shadersmod/common/SMCLog.info:(Ljava/lang/String;)V
        //   845: aload           llllllllllllllllllIllIIllIllIlll
        //   847: iconst_1       
        //   848: aaload         
        //   849: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //   852: dup            
        //   853: putstatic       shadersmod/client/Shaders.spShadowMapHeight:I
        //   856: putstatic       shadersmod/client/Shaders.spShadowMapWidth:I
        //   859: getstatic       shadersmod/client/Shaders.spShadowMapWidth:I
        //   862: i2f            
        //   863: getstatic       shadersmod/client/Shaders.configShadowResMul:F
        //   866: fmul           
        //   867: invokestatic    java/lang/Math.round:(F)I
        //   870: dup            
        //   871: putstatic       shadersmod/client/Shaders.shadowMapHeight:I
        //   874: putstatic       shadersmod/client/Shaders.shadowMapWidth:I
        //   877: goto            2388
        //   880: aload           llllllllllllllllllIllIIllIlllIlI
        //   882: ldc_w           "/\\* SHADOWFOV:[0-9\\.]+ \\*/.*"
        //   885: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //   888: ifeq            942
        //   891: aload           llllllllllllllllllIllIIllIlllIlI
        //   893: ldc_w           "(:| )"
        //   896: iconst_4       
        //   897: invokevirtual   java/lang/String.split:(Ljava/lang/String;I)[Ljava/lang/String;
        //   900: astore          llllllllllllllllllIllIIllIllIllI
        //   902: new             Ljava/lang/StringBuilder;
        //   905: dup            
        //   906: ldc_w           "Shadow map field of view: "
        //   909: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   912: aload           llllllllllllllllllIllIIllIllIllI
        //   914: iconst_2       
        //   915: aaload         
        //   916: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   919: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   922: invokestatic    shadersmod/common/SMCLog.info:(Ljava/lang/String;)V
        //   925: aload           llllllllllllllllllIllIIllIllIllI
        //   927: iconst_2       
        //   928: aaload         
        //   929: invokestatic    java/lang/Float.parseFloat:(Ljava/lang/String;)F
        //   932: putstatic       shadersmod/client/Shaders.shadowMapFOV:F
        //   935: iconst_0       
        //   936: putstatic       shadersmod/client/Shaders.shadowMapIsOrtho:Z
        //   939: goto            2388
        //   942: aload           llllllllllllllllllIllIIllIlllIlI
        //   944: ldc_w           "/\\* SHADOWHPL:[0-9\\.]+ \\*/.*"
        //   947: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //   950: ifeq            1004
        //   953: aload           llllllllllllllllllIllIIllIlllIlI
        //   955: ldc_w           "(:| )"
        //   958: iconst_4       
        //   959: invokevirtual   java/lang/String.split:(Ljava/lang/String;I)[Ljava/lang/String;
        //   962: astore          llllllllllllllllllIllIIllIllIlIl
        //   964: new             Ljava/lang/StringBuilder;
        //   967: dup            
        //   968: ldc_w           "Shadow map half-plane: "
        //   971: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   974: aload           llllllllllllllllllIllIIllIllIlIl
        //   976: iconst_2       
        //   977: aaload         
        //   978: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   981: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   984: invokestatic    shadersmod/common/SMCLog.info:(Ljava/lang/String;)V
        //   987: aload           llllllllllllllllllIllIIllIllIlIl
        //   989: iconst_2       
        //   990: aaload         
        //   991: invokestatic    java/lang/Float.parseFloat:(Ljava/lang/String;)F
        //   994: putstatic       shadersmod/client/Shaders.shadowMapHalfPlane:F
        //   997: iconst_1       
        //   998: putstatic       shadersmod/client/Shaders.shadowMapIsOrtho:Z
        //  1001: goto            2388
        //  1004: aload           llllllllllllllllllIllIIllIlllIlI
        //  1006: ldc_w           "[ \t]*const[ \t]*float[ \t]*shadowDistance[ \t]*=[ \t]*-?[0-9.]+f?;.*"
        //  1009: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //  1012: ifeq            1065
        //  1015: aload           llllllllllllllllllIllIIllIlllIlI
        //  1017: ldc_w           "(=[ \t]*|;)"
        //  1020: invokevirtual   java/lang/String.split:(Ljava/lang/String;)[Ljava/lang/String;
        //  1023: astore          llllllllllllllllllIllIIllIllIlII
        //  1025: new             Ljava/lang/StringBuilder;
        //  1028: dup            
        //  1029: ldc_w           "Shadow map distance: "
        //  1032: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //  1035: aload           llllllllllllllllllIllIIllIllIlII
        //  1037: iconst_1       
        //  1038: aaload         
        //  1039: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1042: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //  1045: invokestatic    shadersmod/common/SMCLog.info:(Ljava/lang/String;)V
        //  1048: aload           llllllllllllllllllIllIIllIllIlII
        //  1050: iconst_1       
        //  1051: aaload         
        //  1052: invokestatic    java/lang/Float.parseFloat:(Ljava/lang/String;)F
        //  1055: putstatic       shadersmod/client/Shaders.shadowMapHalfPlane:F
        //  1058: iconst_1       
        //  1059: putstatic       shadersmod/client/Shaders.shadowMapIsOrtho:Z
        //  1062: goto            2388
        //  1065: aload           llllllllllllllllllIllIIllIlllIlI
        //  1067: ldc_w           "[ \t]*const[ \t]*float[ \t]*shadowIntervalSize[ \t]*=[ \t]*-?[0-9.]+f?;.*"
        //  1070: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //  1073: ifeq            1122
        //  1076: aload           llllllllllllllllllIllIIllIlllIlI
        //  1078: ldc_w           "(=[ \t]*|;)"
        //  1081: invokevirtual   java/lang/String.split:(Ljava/lang/String;)[Ljava/lang/String;
        //  1084: astore          llllllllllllllllllIllIIllIllIIll
        //  1086: new             Ljava/lang/StringBuilder;
        //  1089: dup            
        //  1090: ldc_w           "Shadow map interval size: "
        //  1093: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //  1096: aload           llllllllllllllllllIllIIllIllIIll
        //  1098: iconst_1       
        //  1099: aaload         
        //  1100: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1103: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //  1106: invokestatic    shadersmod/common/SMCLog.info:(Ljava/lang/String;)V
        //  1109: aload           llllllllllllllllllIllIIllIllIIll
        //  1111: iconst_1       
        //  1112: aaload         
        //  1113: invokestatic    java/lang/Float.parseFloat:(Ljava/lang/String;)F
        //  1116: putstatic       shadersmod/client/Shaders.shadowIntervalSize:F
        //  1119: goto            2388
        //  1122: aload           llllllllllllllllllIllIIllIlllIlI
        //  1124: ldc_w           "[ \t]*const[ \t]*bool[ \t]*generateShadowMipmap[ \t]*=[ \t]*true[ \t]*;.*"
        //  1127: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //  1130: ifeq            1149
        //  1133: ldc_w           "Generate shadow mipmap"
        //  1136: invokestatic    shadersmod/common/SMCLog.info:(Ljava/lang/String;)V
        //  1139: getstatic       shadersmod/client/Shaders.shadowMipmapEnabled:[Z
        //  1142: iconst_1       
        //  1143: invokestatic    java/util/Arrays.fill:([ZZ)V
        //  1146: goto            2388
        //  1149: aload           llllllllllllllllllIllIIllIlllIlI
        //  1151: ldc_w           "[ \t]*const[ \t]*bool[ \t]*generateShadowColorMipmap[ \t]*=[ \t]*true[ \t]*;.*"
        //  1154: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //  1157: ifeq            1176
        //  1160: ldc_w           "Generate shadow color mipmap"
        //  1163: invokestatic    shadersmod/common/SMCLog.info:(Ljava/lang/String;)V
        //  1166: getstatic       shadersmod/client/Shaders.shadowColorMipmapEnabled:[Z
        //  1169: iconst_1       
        //  1170: invokestatic    java/util/Arrays.fill:([ZZ)V
        //  1173: goto            2388
        //  1176: aload           llllllllllllllllllIllIIllIlllIlI
        //  1178: ldc_w           "[ \t]*const[ \t]*bool[ \t]*shadowHardwareFiltering[ \t]*=[ \t]*true[ \t]*;.*"
        //  1181: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //  1184: ifeq            1203
        //  1187: ldc_w           "Hardware shadow filtering enabled."
        //  1190: invokestatic    shadersmod/common/SMCLog.info:(Ljava/lang/String;)V
        //  1193: getstatic       shadersmod/client/Shaders.shadowHardwareFilteringEnabled:[Z
        //  1196: iconst_1       
        //  1197: invokestatic    java/util/Arrays.fill:([ZZ)V
        //  1200: goto            2388
        //  1203: aload           llllllllllllllllllIllIIllIlllIlI
        //  1205: ldc_w           "[ \t]*const[ \t]*bool[ \t]*shadowHardwareFiltering0[ \t]*=[ \t]*true[ \t]*;.*"
        //  1208: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //  1211: ifeq            1229
        //  1214: ldc_w           "shadowHardwareFiltering0"
        //  1217: invokestatic    shadersmod/common/SMCLog.info:(Ljava/lang/String;)V
        //  1220: getstatic       shadersmod/client/Shaders.shadowHardwareFilteringEnabled:[Z
        //  1223: iconst_0       
        //  1224: iconst_1       
        //  1225: bastore        
        //  1226: goto            2388
        //  1229: aload           llllllllllllllllllIllIIllIlllIlI
        //  1231: ldc_w           "[ \t]*const[ \t]*bool[ \t]*shadowHardwareFiltering1[ \t]*=[ \t]*true[ \t]*;.*"
        //  1234: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //  1237: ifeq            1255
        //  1240: ldc_w           "shadowHardwareFiltering1"
        //  1243: invokestatic    shadersmod/common/SMCLog.info:(Ljava/lang/String;)V
        //  1246: getstatic       shadersmod/client/Shaders.shadowHardwareFilteringEnabled:[Z
        //  1249: iconst_1       
        //  1250: iconst_1       
        //  1251: bastore        
        //  1252: goto            2388
        //  1255: aload           llllllllllllllllllIllIIllIlllIlI
        //  1257: ldc_w           "[ \t]*const[ \t]*bool[ \t]*(shadowtex0Mipmap|shadowtexMipmap)[ \t]*=[ \t]*true[ \t]*;.*"
        //  1260: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //  1263: ifeq            1281
        //  1266: ldc_w           "shadowtex0Mipmap"
        //  1269: invokestatic    shadersmod/common/SMCLog.info:(Ljava/lang/String;)V
        //  1272: getstatic       shadersmod/client/Shaders.shadowMipmapEnabled:[Z
        //  1275: iconst_0       
        //  1276: iconst_1       
        //  1277: bastore        
        //  1278: goto            2388
        //  1281: aload           llllllllllllllllllIllIIllIlllIlI
        //  1283: ldc_w           "[ \t]*const[ \t]*bool[ \t]*(shadowtex1Mipmap)[ \t]*=[ \t]*true[ \t]*;.*"
        //  1286: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //  1289: ifeq            1307
        //  1292: ldc_w           "shadowtex1Mipmap"
        //  1295: invokestatic    shadersmod/common/SMCLog.info:(Ljava/lang/String;)V
        //  1298: getstatic       shadersmod/client/Shaders.shadowMipmapEnabled:[Z
        //  1301: iconst_1       
        //  1302: iconst_1       
        //  1303: bastore        
        //  1304: goto            2388
        //  1307: aload           llllllllllllllllllIllIIllIlllIlI
        //  1309: ldc_w           "[ \t]*const[ \t]*bool[ \t]*(shadowcolor0Mipmap|shadowColor0Mipmap)[ \t]*=[ \t]*true[ \t]*;.*"
        //  1312: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //  1315: ifeq            1333
        //  1318: ldc_w           "shadowcolor0Mipmap"
        //  1321: invokestatic    shadersmod/common/SMCLog.info:(Ljava/lang/String;)V
        //  1324: getstatic       shadersmod/client/Shaders.shadowColorMipmapEnabled:[Z
        //  1327: iconst_0       
        //  1328: iconst_1       
        //  1329: bastore        
        //  1330: goto            2388
        //  1333: aload           llllllllllllllllllIllIIllIlllIlI
        //  1335: ldc_w           "[ \t]*const[ \t]*bool[ \t]*(shadowcolor1Mipmap|shadowColor1Mipmap)[ \t]*=[ \t]*true[ \t]*;.*"
        //  1338: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //  1341: ifeq            1359
        //  1344: ldc_w           "shadowcolor1Mipmap"
        //  1347: invokestatic    shadersmod/common/SMCLog.info:(Ljava/lang/String;)V
        //  1350: getstatic       shadersmod/client/Shaders.shadowColorMipmapEnabled:[Z
        //  1353: iconst_1       
        //  1354: iconst_1       
        //  1355: bastore        
        //  1356: goto            2388
        //  1359: aload           llllllllllllllllllIllIIllIlllIlI
        //  1361: ldc_w           "[ \t]*const[ \t]*bool[ \t]*(shadowtex0Nearest|shadowtexNearest|shadow0MinMagNearest)[ \t]*=[ \t]*true[ \t]*;.*"
        //  1364: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //  1367: ifeq            1385
        //  1370: ldc_w           "shadowtex0Nearest"
        //  1373: invokestatic    shadersmod/common/SMCLog.info:(Ljava/lang/String;)V
        //  1376: getstatic       shadersmod/client/Shaders.shadowFilterNearest:[Z
        //  1379: iconst_0       
        //  1380: iconst_1       
        //  1381: bastore        
        //  1382: goto            2388
        //  1385: aload           llllllllllllllllllIllIIllIlllIlI
        //  1387: ldc_w           "[ \t]*const[ \t]*bool[ \t]*(shadowtex1Nearest|shadow1MinMagNearest)[ \t]*=[ \t]*true[ \t]*;.*"
        //  1390: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //  1393: ifeq            1411
        //  1396: ldc_w           "shadowtex1Nearest"
        //  1399: invokestatic    shadersmod/common/SMCLog.info:(Ljava/lang/String;)V
        //  1402: getstatic       shadersmod/client/Shaders.shadowFilterNearest:[Z
        //  1405: iconst_1       
        //  1406: iconst_1       
        //  1407: bastore        
        //  1408: goto            2388
        //  1411: aload           llllllllllllllllllIllIIllIlllIlI
        //  1413: ldc_w           "[ \t]*const[ \t]*bool[ \t]*(shadowcolor0Nearest|shadowColor0Nearest|shadowColor0MinMagNearest)[ \t]*=[ \t]*true[ \t]*;.*"
        //  1416: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //  1419: ifeq            1437
        //  1422: ldc_w           "shadowcolor0Nearest"
        //  1425: invokestatic    shadersmod/common/SMCLog.info:(Ljava/lang/String;)V
        //  1428: getstatic       shadersmod/client/Shaders.shadowColorFilterNearest:[Z
        //  1431: iconst_0       
        //  1432: iconst_1       
        //  1433: bastore        
        //  1434: goto            2388
        //  1437: aload           llllllllllllllllllIllIIllIlllIlI
        //  1439: ldc_w           "[ \t]*const[ \t]*bool[ \t]*(shadowcolor1Nearest|shadowColor1Nearest|shadowColor1MinMagNearest)[ \t]*=[ \t]*true[ \t]*;.*"
        //  1442: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //  1445: ifeq            1463
        //  1448: ldc_w           "shadowcolor1Nearest"
        //  1451: invokestatic    shadersmod/common/SMCLog.info:(Ljava/lang/String;)V
        //  1454: getstatic       shadersmod/client/Shaders.shadowColorFilterNearest:[Z
        //  1457: iconst_1       
        //  1458: iconst_1       
        //  1459: bastore        
        //  1460: goto            2388
        //  1463: aload           llllllllllllllllllIllIIllIlllIlI
        //  1465: ldc_w           "/\\* WETNESSHL:[0-9\\.]+ \\*/.*"
        //  1468: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //  1471: ifeq            1521
        //  1474: aload           llllllllllllllllllIllIIllIlllIlI
        //  1476: ldc_w           "(:| )"
        //  1479: iconst_4       
        //  1480: invokevirtual   java/lang/String.split:(Ljava/lang/String;I)[Ljava/lang/String;
        //  1483: astore          llllllllllllllllllIllIIllIllIIlI
        //  1485: new             Ljava/lang/StringBuilder;
        //  1488: dup            
        //  1489: ldc_w           "Wetness halflife: "
        //  1492: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //  1495: aload           llllllllllllllllllIllIIllIllIIlI
        //  1497: iconst_2       
        //  1498: aaload         
        //  1499: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1502: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //  1505: invokestatic    shadersmod/common/SMCLog.info:(Ljava/lang/String;)V
        //  1508: aload           llllllllllllllllllIllIIllIllIIlI
        //  1510: iconst_2       
        //  1511: aaload         
        //  1512: invokestatic    java/lang/Float.parseFloat:(Ljava/lang/String;)F
        //  1515: putstatic       shadersmod/client/Shaders.wetnessHalfLife:F
        //  1518: goto            2388
        //  1521: aload           llllllllllllllllllIllIIllIlllIlI
        //  1523: ldc_w           "[ \t]*const[ \t]*float[ \t]*wetnessHalflife[ \t]*=[ \t]*-?[0-9.]+f?;.*"
        //  1526: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //  1529: ifeq            1578
        //  1532: aload           llllllllllllllllllIllIIllIlllIlI
        //  1534: ldc_w           "(=[ \t]*|;)"
        //  1537: invokevirtual   java/lang/String.split:(Ljava/lang/String;)[Ljava/lang/String;
        //  1540: astore          llllllllllllllllllIllIIllIllIIIl
        //  1542: new             Ljava/lang/StringBuilder;
        //  1545: dup            
        //  1546: ldc_w           "Wetness halflife: "
        //  1549: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //  1552: aload           llllllllllllllllllIllIIllIllIIIl
        //  1554: iconst_1       
        //  1555: aaload         
        //  1556: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1559: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //  1562: invokestatic    shadersmod/common/SMCLog.info:(Ljava/lang/String;)V
        //  1565: aload           llllllllllllllllllIllIIllIllIIIl
        //  1567: iconst_1       
        //  1568: aaload         
        //  1569: invokestatic    java/lang/Float.parseFloat:(Ljava/lang/String;)F
        //  1572: putstatic       shadersmod/client/Shaders.wetnessHalfLife:F
        //  1575: goto            2388
        //  1578: aload           llllllllllllllllllIllIIllIlllIlI
        //  1580: ldc_w           "/\\* DRYNESSHL:[0-9\\.]+ \\*/.*"
        //  1583: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //  1586: ifeq            1636
        //  1589: aload           llllllllllllllllllIllIIllIlllIlI
        //  1591: ldc_w           "(:| )"
        //  1594: iconst_4       
        //  1595: invokevirtual   java/lang/String.split:(Ljava/lang/String;I)[Ljava/lang/String;
        //  1598: astore          llllllllllllllllllIllIIllIllIIII
        //  1600: new             Ljava/lang/StringBuilder;
        //  1603: dup            
        //  1604: ldc_w           "Dryness halflife: "
        //  1607: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //  1610: aload           llllllllllllllllllIllIIllIllIIII
        //  1612: iconst_2       
        //  1613: aaload         
        //  1614: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1617: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //  1620: invokestatic    shadersmod/common/SMCLog.info:(Ljava/lang/String;)V
        //  1623: aload           llllllllllllllllllIllIIllIllIIII
        //  1625: iconst_2       
        //  1626: aaload         
        //  1627: invokestatic    java/lang/Float.parseFloat:(Ljava/lang/String;)F
        //  1630: putstatic       shadersmod/client/Shaders.drynessHalfLife:F
        //  1633: goto            2388
        //  1636: aload           llllllllllllllllllIllIIllIlllIlI
        //  1638: ldc_w           "[ \t]*const[ \t]*float[ \t]*drynessHalflife[ \t]*=[ \t]*-?[0-9.]+f?;.*"
        //  1641: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //  1644: ifeq            1693
        //  1647: aload           llllllllllllllllllIllIIllIlllIlI
        //  1649: ldc_w           "(=[ \t]*|;)"
        //  1652: invokevirtual   java/lang/String.split:(Ljava/lang/String;)[Ljava/lang/String;
        //  1655: astore          llllllllllllllllllIllIIllIlIllll
        //  1657: new             Ljava/lang/StringBuilder;
        //  1660: dup            
        //  1661: ldc_w           "Dryness halflife: "
        //  1664: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //  1667: aload           llllllllllllllllllIllIIllIlIllll
        //  1669: iconst_1       
        //  1670: aaload         
        //  1671: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1674: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //  1677: invokestatic    shadersmod/common/SMCLog.info:(Ljava/lang/String;)V
        //  1680: aload           llllllllllllllllllIllIIllIlIllll
        //  1682: iconst_1       
        //  1683: aaload         
        //  1684: invokestatic    java/lang/Float.parseFloat:(Ljava/lang/String;)F
        //  1687: putstatic       shadersmod/client/Shaders.drynessHalfLife:F
        //  1690: goto            2388
        //  1693: aload           llllllllllllllllllIllIIllIlllIlI
        //  1695: ldc_w           "[ \t]*const[ \t]*float[ \t]*eyeBrightnessHalflife[ \t]*=[ \t]*-?[0-9.]+f?;.*"
        //  1698: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //  1701: ifeq            1750
        //  1704: aload           llllllllllllllllllIllIIllIlllIlI
        //  1706: ldc_w           "(=[ \t]*|;)"
        //  1709: invokevirtual   java/lang/String.split:(Ljava/lang/String;)[Ljava/lang/String;
        //  1712: astore          llllllllllllllllllIllIIllIlIlllI
        //  1714: new             Ljava/lang/StringBuilder;
        //  1717: dup            
        //  1718: ldc_w           "Eye brightness halflife: "
        //  1721: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //  1724: aload           llllllllllllllllllIllIIllIlIlllI
        //  1726: iconst_1       
        //  1727: aaload         
        //  1728: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1731: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //  1734: invokestatic    shadersmod/common/SMCLog.info:(Ljava/lang/String;)V
        //  1737: aload           llllllllllllllllllIllIIllIlIlllI
        //  1739: iconst_1       
        //  1740: aaload         
        //  1741: invokestatic    java/lang/Float.parseFloat:(Ljava/lang/String;)F
        //  1744: putstatic       shadersmod/client/Shaders.eyeBrightnessHalflife:F
        //  1747: goto            2388
        //  1750: aload           llllllllllllllllllIllIIllIlllIlI
        //  1752: ldc_w           "[ \t]*const[ \t]*float[ \t]*centerDepthHalflife[ \t]*=[ \t]*-?[0-9.]+f?;.*"
        //  1755: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //  1758: ifeq            1807
        //  1761: aload           llllllllllllllllllIllIIllIlllIlI
        //  1763: ldc_w           "(=[ \t]*|;)"
        //  1766: invokevirtual   java/lang/String.split:(Ljava/lang/String;)[Ljava/lang/String;
        //  1769: astore          llllllllllllllllllIllIIllIlIllIl
        //  1771: new             Ljava/lang/StringBuilder;
        //  1774: dup            
        //  1775: ldc_w           "Center depth halflife: "
        //  1778: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //  1781: aload           llllllllllllllllllIllIIllIlIllIl
        //  1783: iconst_1       
        //  1784: aaload         
        //  1785: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1788: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //  1791: invokestatic    shadersmod/common/SMCLog.info:(Ljava/lang/String;)V
        //  1794: aload           llllllllllllllllllIllIIllIlIllIl
        //  1796: iconst_1       
        //  1797: aaload         
        //  1798: invokestatic    java/lang/Float.parseFloat:(Ljava/lang/String;)F
        //  1801: putstatic       shadersmod/client/Shaders.centerDepthSmoothHalflife:F
        //  1804: goto            2388
        //  1807: aload           llllllllllllllllllIllIIllIlllIlI
        //  1809: ldc_w           "[ \t]*const[ \t]*float[ \t]*sunPathRotation[ \t]*=[ \t]*-?[0-9.]+f?;.*"
        //  1812: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //  1815: ifeq            1864
        //  1818: aload           llllllllllllllllllIllIIllIlllIlI
        //  1820: ldc_w           "(=[ \t]*|;)"
        //  1823: invokevirtual   java/lang/String.split:(Ljava/lang/String;)[Ljava/lang/String;
        //  1826: astore          llllllllllllllllllIllIIllIlIllII
        //  1828: new             Ljava/lang/StringBuilder;
        //  1831: dup            
        //  1832: ldc_w           "Sun path rotation: "
        //  1835: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //  1838: aload           llllllllllllllllllIllIIllIlIllII
        //  1840: iconst_1       
        //  1841: aaload         
        //  1842: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1845: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //  1848: invokestatic    shadersmod/common/SMCLog.info:(Ljava/lang/String;)V
        //  1851: aload           llllllllllllllllllIllIIllIlIllII
        //  1853: iconst_1       
        //  1854: aaload         
        //  1855: invokestatic    java/lang/Float.parseFloat:(Ljava/lang/String;)F
        //  1858: putstatic       shadersmod/client/Shaders.sunPathRotation:F
        //  1861: goto            2388
        //  1864: aload           llllllllllllllllllIllIIllIlllIlI
        //  1866: ldc_w           "[ \t]*const[ \t]*float[ \t]*ambientOcclusionLevel[ \t]*=[ \t]*-?[0-9.]+f?;.*"
        //  1869: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //  1872: ifeq            1929
        //  1875: aload           llllllllllllllllllIllIIllIlllIlI
        //  1877: ldc_w           "(=[ \t]*|;)"
        //  1880: invokevirtual   java/lang/String.split:(Ljava/lang/String;)[Ljava/lang/String;
        //  1883: astore          llllllllllllllllllIllIIllIlIlIll
        //  1885: new             Ljava/lang/StringBuilder;
        //  1888: dup            
        //  1889: ldc_w           "AO Level: "
        //  1892: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //  1895: aload           llllllllllllllllllIllIIllIlIlIll
        //  1897: iconst_1       
        //  1898: aaload         
        //  1899: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1902: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //  1905: invokestatic    shadersmod/common/SMCLog.info:(Ljava/lang/String;)V
        //  1908: aload           llllllllllllllllllIllIIllIlIlIll
        //  1910: iconst_1       
        //  1911: aaload         
        //  1912: invokestatic    java/lang/Float.parseFloat:(Ljava/lang/String;)F
        //  1915: putstatic       shadersmod/client/Shaders.aoLevel:F
        //  1918: fconst_1       
        //  1919: getstatic       shadersmod/client/Shaders.aoLevel:F
        //  1922: fsub           
        //  1923: putstatic       shadersmod/client/Shaders.blockAoLight:F
        //  1926: goto            2388
        //  1929: aload           llllllllllllllllllIllIIllIlllIlI
        //  1931: ldc_w           "[ \t]*const[ \t]*int[ \t]*superSamplingLevel[ \t]*=[ \t]*-?[0-9.]+f?;.*"
        //  1934: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //  1937: ifeq            2007
        //  1940: aload           llllllllllllllllllIllIIllIlllIlI
        //  1942: ldc_w           "(=[ \t]*|;)"
        //  1945: invokevirtual   java/lang/String.split:(Ljava/lang/String;)[Ljava/lang/String;
        //  1948: astore          llllllllllllllllllIllIIllIlIlIlI
        //  1950: aload           llllllllllllllllllIllIIllIlIlIlI
        //  1952: iconst_1       
        //  1953: aaload         
        //  1954: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //  1957: istore          llllllllllllllllllIllIIllIlIIlll
        //  1959: iload           llllllllllllllllllIllIIllIlIIlll
        //  1961: iconst_1       
        //  1962: if_icmple       2000
        //  1965: new             Ljava/lang/StringBuilder;
        //  1968: dup            
        //  1969: ldc_w           "Super sampling level: "
        //  1972: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //  1975: iload           llllllllllllllllllIllIIllIlIIlll
        //  1977: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //  1980: ldc_w           "x"
        //  1983: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1986: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //  1989: invokestatic    shadersmod/common/SMCLog.info:(Ljava/lang/String;)V
        //  1992: iload           llllllllllllllllllIllIIllIlIIlll
        //  1994: putstatic       shadersmod/client/Shaders.superSamplingLevel:I
        //  1997: goto            2388
        //  2000: iconst_1       
        //  2001: putstatic       shadersmod/client/Shaders.superSamplingLevel:I
        //  2004: goto            2388
        //  2007: aload           llllllllllllllllllIllIIllIlllIlI
        //  2009: ldc_w           "[ \t]*const[ \t]*int[ \t]*noiseTextureResolution[ \t]*=[ \t]*-?[0-9.]+f?;.*"
        //  2012: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //  2015: ifeq            2074
        //  2018: aload           llllllllllllllllllIllIIllIlllIlI
        //  2020: ldc_w           "(=[ \t]*|;)"
        //  2023: invokevirtual   java/lang/String.split:(Ljava/lang/String;)[Ljava/lang/String;
        //  2026: astore          llllllllllllllllllIllIIllIlIlIIl
        //  2028: ldc_w           "Noise texture enabled"
        //  2031: invokestatic    shadersmod/common/SMCLog.info:(Ljava/lang/String;)V
        //  2034: new             Ljava/lang/StringBuilder;
        //  2037: dup            
        //  2038: ldc_w           "Noise texture resolution: "
        //  2041: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //  2044: aload           llllllllllllllllllIllIIllIlIlIIl
        //  2046: iconst_1       
        //  2047: aaload         
        //  2048: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  2051: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //  2054: invokestatic    shadersmod/common/SMCLog.info:(Ljava/lang/String;)V
        //  2057: aload           llllllllllllllllllIllIIllIlIlIIl
        //  2059: iconst_1       
        //  2060: aaload         
        //  2061: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //  2064: putstatic       shadersmod/client/Shaders.noiseTextureResolution:I
        //  2067: iconst_1       
        //  2068: putstatic       shadersmod/client/Shaders.noiseTextureEnabled:Z
        //  2071: goto            2388
        //  2074: aload           llllllllllllllllllIllIIllIlllIlI
        //  2076: ldc_w           "[ \t]*const[ \t]*int[ \t]*\\w+Format[ \t]*=[ \t]*[RGBA81632FUI_SNORM]*[ \t]*;.*"
        //  2079: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //  2082: ifeq            2172
        //  2085: getstatic       shadersmod/client/Shaders.gbufferFormatPattern:Ljava/util/regex/Pattern;
        //  2088: aload           llllllllllllllllllIllIIllIlllIlI
        //  2090: invokevirtual   java/util/regex/Pattern.matcher:(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
        //  2093: astore          llllllllllllllllllIllIIllIlIIlII
        //  2095: aload           llllllllllllllllllIllIIllIlIIlII
        //  2097: invokevirtual   java/util/regex/Matcher.matches:()Z
        //  2100: pop            
        //  2101: aload           llllllllllllllllllIllIIllIlIIlII
        //  2103: iconst_1       
        //  2104: invokevirtual   java/util/regex/Matcher.group:(I)Ljava/lang/String;
        //  2107: astore          llllllllllllllllllIllIIllIlIIllI
        //  2109: aload           llllllllllllllllllIllIIllIlIIlII
        //  2111: iconst_2       
        //  2112: invokevirtual   java/util/regex/Matcher.group:(I)Ljava/lang/String;
        //  2115: astore          llllllllllllllllllIllIIllIlIIIlI
        //  2117: aload           llllllllllllllllllIllIIllIlIIllI
        //  2119: invokestatic    shadersmod/client/Shaders.getBufferIndexFromString:(Ljava/lang/String;)I
        //  2122: istore          llllllllllllllllllIllIIllIlIIIIl
        //  2124: aload           llllllllllllllllllIllIIllIlIIIlI
        //  2126: invokestatic    shadersmod/client/Shaders.getTextureFormatFromString:(Ljava/lang/String;)I
        //  2129: istore          llllllllllllllllllIllIIllIlIIIII
        //  2131: iload           llllllllllllllllllIllIIllIlIIIIl
        //  2133: iflt            2388
        //  2136: iload           llllllllllllllllllIllIIllIlIIIII
        //  2138: ifeq            2388
        //  2141: getstatic       shadersmod/client/Shaders.gbuffersFormat:[I
        //  2144: iload           llllllllllllllllllIllIIllIlIIIIl
        //  2146: iload           llllllllllllllllllIllIIllIlIIIII
        //  2148: iastore        
        //  2149: ldc_w           "%s format: %s"
        //  2152: iconst_2       
        //  2153: anewarray       Ljava/lang/Object;
        //  2156: dup            
        //  2157: iconst_0       
        //  2158: aload           llllllllllllllllllIllIIllIlIIllI
        //  2160: aastore        
        //  2161: dup            
        //  2162: iconst_1       
        //  2163: aload           llllllllllllllllllIllIIllIlIIIlI
        //  2165: aastore        
        //  2166: invokestatic    shadersmod/common/SMCLog.info:(Ljava/lang/String;[Ljava/lang/Object;)V
        //  2169: goto            2388
        //  2172: aload           llllllllllllllllllIllIIllIlllIlI
        //  2174: ldc_w           "/\\* GAUX4FORMAT:RGBA32F \\*/.*"
        //  2177: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //  2180: ifeq            2201
        //  2183: ldc_w           "gaux4 format : RGB32AF"
        //  2186: invokestatic    shadersmod/common/SMCLog.info:(Ljava/lang/String;)V
        //  2189: getstatic       shadersmod/client/Shaders.gbuffersFormat:[I
        //  2192: bipush          7
        //  2194: ldc_w           34836
        //  2197: iastore        
        //  2198: goto            2388
        //  2201: aload           llllllllllllllllllIllIIllIlllIlI
        //  2203: ldc_w           "/\\* GAUX4FORMAT:RGB32F \\*/.*"
        //  2206: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //  2209: ifeq            2230
        //  2212: ldc_w           "gaux4 format : RGB32F"
        //  2215: invokestatic    shadersmod/common/SMCLog.info:(Ljava/lang/String;)V
        //  2218: getstatic       shadersmod/client/Shaders.gbuffersFormat:[I
        //  2221: bipush          7
        //  2223: ldc_w           34837
        //  2226: iastore        
        //  2227: goto            2388
        //  2230: aload           llllllllllllllllllIllIIllIlllIlI
        //  2232: ldc_w           "/\\* GAUX4FORMAT:RGB16 \\*/.*"
        //  2235: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //  2238: ifeq            2259
        //  2241: ldc_w           "gaux4 format : RGB16"
        //  2244: invokestatic    shadersmod/common/SMCLog.info:(Ljava/lang/String;)V
        //  2247: getstatic       shadersmod/client/Shaders.gbuffersFormat:[I
        //  2250: bipush          7
        //  2252: ldc_w           32852
        //  2255: iastore        
        //  2256: goto            2388
        //  2259: aload           llllllllllllllllllIllIIllIlllIlI
        //  2261: ldc_w           "[ \t]*const[ \t]*bool[ \t]*\\w+MipmapEnabled[ \t]*=[ \t]*true[ \t]*;.*"
        //  2264: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //  2267: ifeq            2359
        //  2270: aload_0         /* llllllllllllllllllIllIIllIIlllIl */
        //  2271: ldc_w           ".*composite[0-9]?.fsh"
        //  2274: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //  2277: ifne            2290
        //  2280: aload_0         /* llllllllllllllllllIllIIllIIlllIl */
        //  2281: ldc_w           ".*final.fsh"
        //  2284: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //  2287: ifeq            2388
        //  2290: getstatic       shadersmod/client/Shaders.gbufferMipmapEnabledPattern:Ljava/util/regex/Pattern;
        //  2293: aload           llllllllllllllllllIllIIllIlllIlI
        //  2295: invokevirtual   java/util/regex/Pattern.matcher:(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
        //  2298: astore          llllllllllllllllllIllIIllIlIIIll
        //  2300: aload           llllllllllllllllllIllIIllIlIIIll
        //  2302: invokevirtual   java/util/regex/Matcher.matches:()Z
        //  2305: pop            
        //  2306: aload           llllllllllllllllllIllIIllIlIIIll
        //  2308: iconst_1       
        //  2309: invokevirtual   java/util/regex/Matcher.group:(I)Ljava/lang/String;
        //  2312: astore          llllllllllllllllllIllIIllIlIIlIl
        //  2314: aload           llllllllllllllllllIllIIllIlIIlIl
        //  2316: invokestatic    shadersmod/client/Shaders.getBufferIndexFromString:(Ljava/lang/String;)I
        //  2319: istore          llllllllllllllllllIllIIllIIlllll
        //  2321: iload           llllllllllllllllllIllIIllIIlllll
        //  2323: iflt            2388
        //  2326: getstatic       shadersmod/client/Shaders.newCompositeMipmapSetting:I
        //  2329: iconst_1       
        //  2330: iload           llllllllllllllllllIllIIllIIlllll
        //  2332: ishl           
        //  2333: ior            
        //  2334: putstatic       shadersmod/client/Shaders.newCompositeMipmapSetting:I
        //  2337: ldc_w           "%s mipmap enabled for %s"
        //  2340: iconst_2       
        //  2341: anewarray       Ljava/lang/Object;
        //  2344: dup            
        //  2345: iconst_0       
        //  2346: aload           llllllllllllllllllIllIIllIlIIlIl
        //  2348: aastore        
        //  2349: dup            
        //  2350: iconst_1       
        //  2351: aload_0         /* llllllllllllllllllIllIIllIIlllIl */
        //  2352: aastore        
        //  2353: invokestatic    shadersmod/common/SMCLog.info:(Ljava/lang/String;[Ljava/lang/Object;)V
        //  2356: goto            2388
        //  2359: aload           llllllllllllllllllIllIIllIlllIlI
        //  2361: ldc_w           "/\\* DRAWBUFFERS:[0-7N]* \\*/.*"
        //  2364: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //  2367: ifeq            2388
        //  2370: aload           llllllllllllllllllIllIIllIlllIlI
        //  2372: ldc_w           "(:| )"
        //  2375: iconst_4       
        //  2376: invokevirtual   java/lang/String.split:(Ljava/lang/String;I)[Ljava/lang/String;
        //  2379: astore          llllllllllllllllllIllIIllIlIlIII
        //  2381: aload           llllllllllllllllllIllIIllIlIlIII
        //  2383: iconst_2       
        //  2384: aaload         
        //  2385: putstatic       shadersmod/client/Shaders.newDrawBufSetting:Ljava/lang/String;
        //  2388: aload_3         /* llllllllllllllllllIllIIllIlllllI */
        //  2389: invokevirtual   java/io/BufferedReader.readLine:()Ljava/lang/String;
        //  2392: dup            
        //  2393: astore          llllllllllllllllllIllIIllIlllIIl
        //  2395: ifnonnull       114
        //  2398: aload_3         /* llllllllllllllllllIllIIllIlllllI */
        //  2399: invokevirtual   java/io/BufferedReader.close:()V
        //  2402: goto            2444
        //  2405: astore          llllllllllllllllllIllIIllIIllllI
        //  2407: new             Ljava/lang/StringBuilder;
        //  2410: dup            
        //  2411: ldc_w           "Couldn't read "
        //  2414: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //  2417: aload_0         /* llllllllllllllllllIllIIllIIlllIl */
        //  2418: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  2421: ldc_w           "!"
        //  2424: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  2427: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //  2430: invokestatic    shadersmod/common/SMCLog.severe:(Ljava/lang/String;)V
        //  2433: aload           llllllllllllllllllIllIIllIIllllI
        //  2435: invokevirtual   java/lang/Exception.printStackTrace:()V
        //  2438: iload_1         /* llllllllllllllllllIllIIlllIIIIII */
        //  2439: invokestatic    org/lwjgl/opengl/ARBShaderObjects.glDeleteObjectARB:(I)V
        //  2442: iconst_0       
        //  2443: ireturn        
        //  2444: getstatic       shadersmod/client/Shaders.saveFinalShaders:Z
        //  2447: ifeq            2458
        //  2450: aload_0         /* llllllllllllllllllIllIIllIIlllIl */
        //  2451: aload_2         /* llllllllllllllllllIllIIllIllllll */
        //  2452: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //  2455: invokestatic    shadersmod/client/Shaders.saveShader:(Ljava/lang/String;Ljava/lang/String;)V
        //  2458: iload_1         /* llllllllllllllllllIllIIlllIIIIII */
        //  2459: aload_2         /* llllllllllllllllllIllIIllIllllll */
        //  2460: invokestatic    org/lwjgl/opengl/ARBShaderObjects.glShaderSourceARB:(ILjava/lang/CharSequence;)V
        //  2463: iload_1         /* llllllllllllllllllIllIIlllIIIIII */
        //  2464: invokestatic    org/lwjgl/opengl/ARBShaderObjects.glCompileShaderARB:(I)V
        //  2467: iload_1         /* llllllllllllllllllIllIIlllIIIIII */
        //  2468: ldc_w           35713
        //  2471: invokestatic    org/lwjgl/opengl/GL20.glGetShaderi:(II)I
        //  2474: iconst_1       
        //  2475: if_icmpeq       2498
        //  2478: new             Ljava/lang/StringBuilder;
        //  2481: dup            
        //  2482: ldc_w           "Error compiling fragment shader: "
        //  2485: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //  2488: aload_0         /* llllllllllllllllllIllIIllIIlllIl */
        //  2489: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  2492: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //  2495: invokestatic    shadersmod/common/SMCLog.severe:(Ljava/lang/String;)V
        //  2498: iload_1         /* llllllllllllllllllIllIIlllIIIIII */
        //  2499: aload_0         /* llllllllllllllllllIllIIllIIlllIl */
        //  2500: invokestatic    shadersmod/client/Shaders.printShaderLogInfo:(ILjava/lang/String;)Z
        //  2503: pop            
        //  2504: iload_1         /* llllllllllllllllllIllIIlllIIIIII */
        //  2505: ireturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  26     50     53     89     Ljava/lang/Exception;
        //  55     78     81     89     Ljava/lang/Exception;
        //  101    2402   2405   2444   Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static class NamelessClass341846571
    {
        static final /* synthetic */ int[] $SwitchMap$shadersmod$client$EnumShaderOption;
        
        static {
            $SwitchMap$shadersmod$client$EnumShaderOption = new int[EnumShaderOption.values().length];
            try {
                NamelessClass341846571.$SwitchMap$shadersmod$client$EnumShaderOption[EnumShaderOption.ANTIALIASING.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                NamelessClass341846571.$SwitchMap$shadersmod$client$EnumShaderOption[EnumShaderOption.NORMAL_MAP.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                NamelessClass341846571.$SwitchMap$shadersmod$client$EnumShaderOption[EnumShaderOption.SPECULAR_MAP.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                NamelessClass341846571.$SwitchMap$shadersmod$client$EnumShaderOption[EnumShaderOption.RENDER_RES_MUL.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                NamelessClass341846571.$SwitchMap$shadersmod$client$EnumShaderOption[EnumShaderOption.SHADOW_RES_MUL.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                NamelessClass341846571.$SwitchMap$shadersmod$client$EnumShaderOption[EnumShaderOption.HAND_DEPTH_MUL.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
            try {
                NamelessClass341846571.$SwitchMap$shadersmod$client$EnumShaderOption[EnumShaderOption.CLOUD_SHADOW.ordinal()] = 7;
            }
            catch (NoSuchFieldError noSuchFieldError7) {}
            try {
                NamelessClass341846571.$SwitchMap$shadersmod$client$EnumShaderOption[EnumShaderOption.OLD_LIGHTING.ordinal()] = 8;
            }
            catch (NoSuchFieldError noSuchFieldError8) {}
            try {
                NamelessClass341846571.$SwitchMap$shadersmod$client$EnumShaderOption[EnumShaderOption.SHADER_PACK.ordinal()] = 9;
            }
            catch (NoSuchFieldError noSuchFieldError9) {}
            try {
                NamelessClass341846571.$SwitchMap$shadersmod$client$EnumShaderOption[EnumShaderOption.TWEAK_BLOCK_DAMAGE.ordinal()] = 10;
            }
            catch (NoSuchFieldError noSuchFieldError10) {}
            try {
                NamelessClass341846571.$SwitchMap$shadersmod$client$EnumShaderOption[EnumShaderOption.SHADOW_CLIP_FRUSTRUM.ordinal()] = 11;
            }
            catch (NoSuchFieldError noSuchFieldError11) {}
            try {
                NamelessClass341846571.$SwitchMap$shadersmod$client$EnumShaderOption[EnumShaderOption.TEX_MIN_FIL_B.ordinal()] = 12;
            }
            catch (NoSuchFieldError noSuchFieldError12) {}
            try {
                NamelessClass341846571.$SwitchMap$shadersmod$client$EnumShaderOption[EnumShaderOption.TEX_MIN_FIL_N.ordinal()] = 13;
            }
            catch (NoSuchFieldError noSuchFieldError13) {}
            try {
                NamelessClass341846571.$SwitchMap$shadersmod$client$EnumShaderOption[EnumShaderOption.TEX_MIN_FIL_S.ordinal()] = 14;
            }
            catch (NoSuchFieldError noSuchFieldError14) {}
            try {
                NamelessClass341846571.$SwitchMap$shadersmod$client$EnumShaderOption[EnumShaderOption.TEX_MAG_FIL_B.ordinal()] = 15;
            }
            catch (NoSuchFieldError noSuchFieldError15) {}
            try {
                NamelessClass341846571.$SwitchMap$shadersmod$client$EnumShaderOption[EnumShaderOption.TEX_MAG_FIL_N.ordinal()] = 16;
            }
            catch (NoSuchFieldError noSuchFieldError16) {}
            try {
                NamelessClass341846571.$SwitchMap$shadersmod$client$EnumShaderOption[EnumShaderOption.TEX_MAG_FIL_S.ordinal()] = 17;
            }
            catch (NoSuchFieldError noSuchFieldError17) {}
        }
    }
}
