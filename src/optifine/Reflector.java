package optifine;

import java.lang.reflect.*;
import net.minecraft.entity.item.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.renderer.*;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.block.state.*;
import net.minecraft.tileentity.*;
import net.minecraft.potion.*;
import net.minecraft.item.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.resources.model.*;
import net.minecraft.world.biome.*;
import net.minecraft.client.renderer.entity.*;
import java.util.*;
import net.minecraft.client.renderer.tileentity.*;

public class Reflector
{
    public static /* synthetic */ ReflectorMethod ForgeBlock_canCreatureSpawn;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_orientBedCamera;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_getArmorModel;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_setRenderPass;
    public static /* synthetic */ ReflectorClass ForgeWorldProvider;
    public static /* synthetic */ ReflectorMethod ForgeVertexFormatElementEnumUseage_preDraw;
    public static /* synthetic */ ReflectorMethod ForgeEntity_shouldRenderInPass;
    public static /* synthetic */ ReflectorMethod ForgeEventFactory_renderBlockOverlay;
    public static /* synthetic */ ReflectorMethod IExtendedBlockState_getClean;
    public static /* synthetic */ ReflectorMethod MinecraftForgeClient_onRebuildChunk;
    public static /* synthetic */ ReflectorField MinecraftForge_EVENT_BUS;
    public static /* synthetic */ ReflectorClass ChunkWatchEvent_UnWatch;
    public static /* synthetic */ ReflectorField EntityViewRenderEvent_CameraSetup_pitch;
    public static /* synthetic */ ReflectorMethod ForgeItem_getModel;
    public static /* synthetic */ ReflectorClass IColoredBakedQuad;
    public static /* synthetic */ ReflectorClass Event_Result;
    public static /* synthetic */ ReflectorMethod LightUtil_putBakedQuad;
    public static /* synthetic */ ReflectorMethod ForgeHooks_onLivingUpdate;
    public static /* synthetic */ ReflectorClass SplashScreen;
    public static /* synthetic */ ReflectorMethod ForgeItemRecord_getRecordResource;
    public static /* synthetic */ ReflectorMethod ForgeItem_getDurabilityForDisplay;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_renderFirstPersonHand;
    public static /* synthetic */ ReflectorConstructor RenderLivingEvent_Pre_Constructor;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_putQuadColor;
    public static /* synthetic */ ReflectorConstructor DrawScreenEvent_Pre_Constructor;
    public static /* synthetic */ ReflectorClass DrawScreenEvent_Pre;
    public static /* synthetic */ ReflectorClass RenderLivingEvent_Post;
    public static /* synthetic */ ReflectorMethod ForgeHooks_onLivingDeath;
    public static /* synthetic */ ReflectorField Event_Result_DEFAULT;
    public static /* synthetic */ ReflectorMethod ForgeHooks_onLivingHurt;
    public static /* synthetic */ ReflectorConstructor EntityViewRenderEvent_CameraSetup_Constructor;
    public static /* synthetic */ ReflectorMethod ForgeTileEntityRendererDispatcher_drawBatch;
    public static /* synthetic */ ReflectorField ForgeEntity_capturedDrops;
    public static /* synthetic */ ReflectorField EntityViewRenderEvent_FogColors_green;
    public static /* synthetic */ ReflectorMethod ModelLoader_onRegisterItems;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_drawScreen;
    public static /* synthetic */ ReflectorMethod EventBus_post;
    public static /* synthetic */ ReflectorMethod FMLClientHandler_trackBrokenTexture;
    public static /* synthetic */ ReflectorField LightUtil_tessellator;
    public static /* synthetic */ ReflectorMethod ISmartBlockModel_handleBlockState;
    public static /* synthetic */ ReflectorClass ISmartBlockModel;
    public static /* synthetic */ ReflectorClass RenderItemInFrameEvent;
    public static /* synthetic */ ReflectorConstructor ChunkWatchEvent_UnWatch_Constructor;
    public static /* synthetic */ ReflectorField EntityViewRenderEvent_FogColors_blue;
    public static /* synthetic */ ReflectorClass MinecraftForgeClient;
    public static /* synthetic */ ReflectorClass RenderLivingEvent_Pre;
    public static /* synthetic */ ReflectorClass ItemModelMesherForge;
    public static /* synthetic */ ReflectorMethod ForgeHooks_onLivingSetAttackTarget;
    public static /* synthetic */ ReflectorClass FMLCommonHandler;
    public static /* synthetic */ ReflectorField Launch_blackboard;
    public static /* synthetic */ ReflectorMethod RenderingRegistry_loadEntityRenderers;
    public static /* synthetic */ ReflectorField ForgeModContainer_forgeLightPipelineEnabled;
    public static /* synthetic */ ReflectorClass ForgePotionEffect;
    public static /* synthetic */ ReflectorField EntityViewRenderEvent_CameraSetup_roll;
    public static /* synthetic */ ReflectorMethod ForgeWorldProvider_getWeatherRenderer;
    public static /* synthetic */ ReflectorClass Launch;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_setRenderLayer;
    public static /* synthetic */ ReflectorMethod MinecraftForgeClient_getRenderPass;
    public static /* synthetic */ ReflectorField EntityViewRenderEvent_CameraSetup_yaw;
    public static /* synthetic */ ReflectorClass ForgeVertexFormatElementEnumUseage;
    public static /* synthetic */ ReflectorClass ForgeWorld;
    public static /* synthetic */ ReflectorMethod ForgeItem_onEntitySwing;
    public static /* synthetic */ ReflectorMethod ForgeTileEntity_canRenderBreaking;
    public static /* synthetic */ ReflectorMethod ForgeBiomeGenBase_getWaterColorMultiplier;
    public static /* synthetic */ ReflectorClass ForgeEventFactory;
    public static /* synthetic */ ReflectorMethod ForgeBlock_isBedFoot;
    public static /* synthetic */ ReflectorMethod ForgeTileEntity_shouldRenderInPass;
    public static /* synthetic */ ReflectorClass ForgeBiomeGenBase;
    public static /* synthetic */ ReflectorClass RenderingRegistry;
    public static /* synthetic */ ReflectorClass FMLClientHandler;
    public static /* synthetic */ ReflectorClass CoreModManager;
    public static /* synthetic */ ReflectorField LightUtil_itemConsumer;
    public static /* synthetic */ ReflectorField Event_Result_DENY;
    public static /* synthetic */ ReflectorMethod FMLCommonHandler_instance;
    public static /* synthetic */ ReflectorMethod ForgeHooks_onLivingFall;
    public static /* synthetic */ ReflectorClass IRenderHandler;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_getMatrix;
    public static /* synthetic */ ReflectorClass ForgeBlock;
    public static /* synthetic */ ReflectorClass IExtendedBlockState;
    public static /* synthetic */ ReflectorClass ForgeModContainer;
    public static /* synthetic */ ReflectorMethod ForgeHooks_onLivingAttack;
    public static /* synthetic */ ReflectorMethod ForgeEventFactory_canEntitySpawn;
    public static /* synthetic */ ReflectorConstructor RenderLivingEvent_Specials_Pre_Constructor;
    public static /* synthetic */ ReflectorMethod ForgeEventFactory_renderFireOverlay;
    public static /* synthetic */ ReflectorMethod ForgeHooks_onLivingJump;
    public static /* synthetic */ ReflectorClass MinecraftForge;
    public static /* synthetic */ ReflectorField OptiFineClassTransformer_instance;
    public static /* synthetic */ ReflectorField Attributes_DEFAULT_BAKED_FORMAT;
    public static /* synthetic */ ReflectorField ForgeEntity_captureDrops;
    public static /* synthetic */ ReflectorClass OptiFineClassTransformer;
    public static /* synthetic */ ReflectorMethod ForgeBlock_addDestroyEffects;
    public static /* synthetic */ ReflectorClass LightUtil;
    public static /* synthetic */ ReflectorMethod ForgeBlock_getBedDirection;
    public static /* synthetic */ ReflectorMethod ForgeWorld_getPerWorldStorage;
    public static /* synthetic */ ReflectorClass DimensionManager;
    public static /* synthetic */ ReflectorMethod ForgeBlock_isBed;
    public static /* synthetic */ ReflectorMethod ForgeTileEntity_getRenderBoundingBox;
    public static /* synthetic */ ReflectorMethod FMLCommonHandler_enhanceCrashReport;
    public static /* synthetic */ ReflectorConstructor EntityViewRenderEvent_FogColors_Constructor;
    public static /* synthetic */ ReflectorClass ForgeItemRecord;
    public static /* synthetic */ ReflectorMethod ForgeBlock_canRenderInLayer;
    public static /* synthetic */ ReflectorConstructor ItemModelMesherForge_Constructor;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_transform;
    public static /* synthetic */ ReflectorMethod BlamingTransformer_onCrash;
    public static /* synthetic */ ReflectorConstructor RenderLivingEvent_Post_Constructor;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_getOffsetFOV;
    public static /* synthetic */ ReflectorMethod OptiFineClassTransformer_getOptiFineResource;
    public static /* synthetic */ ReflectorMethod ForgeBlock_addHitEffects;
    public static /* synthetic */ ReflectorMethod ForgeBlock_getExtendedState;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_onFogRender;
    public static /* synthetic */ ReflectorClass RenderBlockOverlayEvent_OverlayType;
    public static /* synthetic */ ReflectorConstructor RenderLivingEvent_Specials_Post_Constructor;
    public static /* synthetic */ ReflectorConstructor DrawScreenEvent_Post_Constructor;
    public static /* synthetic */ ReflectorClass RenderLivingEvent_Specials_Post;
    public static /* synthetic */ ReflectorMethod FMLCommonHandler_getBrandings;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_onDrawBlockHighlight;
    public static /* synthetic */ ReflectorMethod ForgeEventFactory_canEntityDespawn;
    public static /* synthetic */ ReflectorClass BlamingTransformer;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_handleCameraTransforms;
    public static /* synthetic */ ReflectorConstructor WorldEvent_Load_Constructor;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_dispatchRenderLast;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_loadEntityShader;
    public static /* synthetic */ ReflectorConstructor RenderItemInFrameEvent_Constructor;
    public static /* synthetic */ ReflectorMethod CoreModManager_onCrash;
    public static /* synthetic */ ReflectorClass RenderLivingEvent_Specials_Pre;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_onTextureStitchedPost;
    public static /* synthetic */ ReflectorMethod ForgeTileEntityRendererDispatcher_preDrawBatch;
    public static /* synthetic */ ReflectorField RenderBlockOverlayEvent_OverlayType_BLOCK;
    public static /* synthetic */ ReflectorMethod ForgeWorldProvider_getSkyRenderer;
    public static /* synthetic */ ReflectorMethod ForgeVertexFormatElementEnumUseage_postDraw;
    public static /* synthetic */ ReflectorMethod FMLClientHandler_instance;
    public static /* synthetic */ ReflectorClass ForgeHooks;
    public static /* synthetic */ ReflectorMethod DimensionManager_getStaticDimensionIDs;
    public static /* synthetic */ ReflectorMethod ForgeEntity_shouldRiderSit;
    public static /* synthetic */ ReflectorClass ForgeItem;
    public static /* synthetic */ ReflectorClass DrawScreenEvent_Post;
    public static /* synthetic */ ReflectorMethod FMLCommonHandler_callFuture;
    public static /* synthetic */ ReflectorMethod ForgeHooks_onLivingDrops;
    public static /* synthetic */ ReflectorMethod ForgeItem_showDurabilityBar;
    public static /* synthetic */ ReflectorClass ModelLoader;
    public static /* synthetic */ ReflectorMethod IRenderHandler_render;
    public static /* synthetic */ ReflectorMethod ForgeEventFactory_renderWaterOverlay;
    public static /* synthetic */ ReflectorClass BetterFoliageClient;
    public static /* synthetic */ ReflectorMethod FMLClientHandler_isLoading;
    public static /* synthetic */ ReflectorClass ForgeTileEntityRendererDispatcher;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_getFogDensity;
    public static /* synthetic */ ReflectorClass ForgeHooksClient;
    public static /* synthetic */ ReflectorMethod ForgeWorld_countEntities;
    public static /* synthetic */ ReflectorMethod FMLCommonHandler_handleServerAboutToStart;
    public static /* synthetic */ ReflectorClass EntityViewRenderEvent_FogColors;
    public static /* synthetic */ ReflectorClass WorldEvent_Load;
    public static /* synthetic */ ReflectorMethod FMLClientHandler_trackMissingTexture;
    public static /* synthetic */ ReflectorClass ForgeTileEntity;
    public static /* synthetic */ ReflectorMethod ForgeBlock_isAir;
    public static /* synthetic */ ReflectorField Event_Result_ALLOW;
    public static /* synthetic */ ReflectorMethod LightUtil_renderQuadColor;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_fillNormal;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_getArmorTexture;
    public static /* synthetic */ ReflectorMethod ForgeEntity_canRiderInteract;
    public static /* synthetic */ ReflectorClass EventBus;
    public static /* synthetic */ ReflectorMethod ForgeBlock_hasTileEntity;
    public static /* synthetic */ ReflectorClass ForgeEntity;
    public static /* synthetic */ ReflectorMethod FMLCommonHandler_handleServerStarting;
    public static /* synthetic */ ReflectorMethod ForgeItem_shouldCauseReequipAnimation;
    public static /* synthetic */ ReflectorClass Attributes;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_onTextureStitchedPre;
    public static /* synthetic */ ReflectorMethod ForgeWorldProvider_getCloudRenderer;
    public static /* synthetic */ ReflectorClass EntityViewRenderEvent_CameraSetup;
    public static /* synthetic */ ReflectorField EntityViewRenderEvent_FogColors_red;
    public static /* synthetic */ ReflectorMethod ForgePotionEffect_isCurativeItem;
    
    private static void dbgCall(final boolean llllllllllllllIIIIIlIlIIlllIlllI, final String llllllllllllllIIIIIlIlIIlllIllIl, final ReflectorMethod llllllllllllllIIIIIlIlIIllllIlII, final Object[] llllllllllllllIIIIIlIlIIlllIlIll, final Object llllllllllllllIIIIIlIlIIllllIIlI) {
        final String llllllllllllllIIIIIlIlIIllllIIIl = llllllllllllllIIIIIlIlIIllllIlII.getTargetMethod().getDeclaringClass().getName();
        final String llllllllllllllIIIIIlIlIIllllIIII = llllllllllllllIIIIIlIlIIllllIlII.getTargetMethod().getName();
        String llllllllllllllIIIIIlIlIIlllIllll = "";
        if (llllllllllllllIIIIIlIlIIlllIlllI) {
            llllllllllllllIIIIIlIlIIlllIllll = " static";
        }
        Config.dbg(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIIIlIlIIlllIllIl)).append(llllllllllllllIIIIIlIlIIlllIllll).append(" ").append(llllllllllllllIIIIIlIlIIllllIIIl).append(".").append(llllllllllllllIIIIIlIlIIllllIIII).append("(").append(Config.arrayToString(llllllllllllllIIIIIlIlIIlllIlIll)).append(") => ").append(llllllllllllllIIIIIlIlIIllllIIlI)));
    }
    
    public static Field[] getFields(final Class llllllllllllllIIIIIlIlIIlIIIIlIl, final Class llllllllllllllIIIIIlIlIIlIIIIlII) {
        final ArrayList llllllllllllllIIIIIlIlIIlIIIIIll = new ArrayList();
        try {
            final Field[] llllllllllllllIIIIIlIlIIlIIIIIlI = llllllllllllllIIIIIlIlIIlIIIIlIl.getDeclaredFields();
            for (int llllllllllllllIIIIIlIlIIlIIIIIIl = 0; llllllllllllllIIIIIlIlIIlIIIIIIl < llllllllllllllIIIIIlIlIIlIIIIIlI.length; ++llllllllllllllIIIIIlIlIIlIIIIIIl) {
                final Field llllllllllllllIIIIIlIlIIlIIIIIII = llllllllllllllIIIIIlIlIIlIIIIIlI[llllllllllllllIIIIIlIlIIlIIIIIIl];
                if (llllllllllllllIIIIIlIlIIlIIIIIII.getType() == llllllllllllllIIIIIlIlIIlIIIIlII) {
                    llllllllllllllIIIIIlIlIIlIIIIIII.setAccessible(true);
                    llllllllllllllIIIIIlIlIIlIIIIIll.add(llllllllllllllIIIIIlIlIIlIIIIIII);
                }
            }
            final Field[] llllllllllllllIIIIIlIlIIIlllllll = llllllllllllllIIIIIlIlIIlIIIIIll.toArray(new Field[llllllllllllllIIIIIlIlIIlIIIIIll.size()]);
            return llllllllllllllIIIIIlIlIIIlllllll;
        }
        catch (Exception llllllllllllllIIIIIlIlIIIllllllI) {
            return null;
        }
    }
    
    public static boolean postForgeBusEvent(final ReflectorConstructor llllllllllllllIIIIIlIlIlIlIlIlII, final Object... llllllllllllllIIIIIlIlIlIlIlIIII) {
        final Object llllllllllllllIIIIIlIlIlIlIlIIlI = newInstance(llllllllllllllIIIIIlIlIlIlIlIlII, llllllllllllllIIIIIlIlIlIlIlIIII);
        return llllllllllllllIIIIIlIlIlIlIlIIlI != null && postForgeBusEvent(llllllllllllllIIIIIlIlIlIlIlIIlI);
    }
    
    private static void dbgCallVoid(final boolean llllllllllllllIIIIIlIlIIllIllIII, final String llllllllllllllIIIIIlIlIIllIllllI, final ReflectorMethod llllllllllllllIIIIIlIlIIllIlIllI, final Object[] llllllllllllllIIIIIlIlIIllIlllII) {
        final String llllllllllllllIIIIIlIlIIllIllIll = llllllllllllllIIIIIlIlIIllIlIllI.getTargetMethod().getDeclaringClass().getName();
        final String llllllllllllllIIIIIlIlIIllIllIlI = llllllllllllllIIIIIlIlIIllIlIllI.getTargetMethod().getName();
        String llllllllllllllIIIIIlIlIIllIllIIl = "";
        if (llllllllllllllIIIIIlIlIIllIllIII) {
            llllllllllllllIIIIIlIlIIllIllIIl = " static";
        }
        Config.dbg(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIIIlIlIIllIllllI)).append(llllllllllllllIIIIIlIlIIllIllIIl).append(" ").append(llllllllllllllIIIIIlIlIIllIllIll).append(".").append(llllllllllllllIIIIIlIlIIllIllIlI).append("(").append(Config.arrayToString(llllllllllllllIIIIIlIlIIllIlllII)).append(")")));
    }
    
    public static String callString(final ReflectorMethod llllllllllllllIIIIIlIllIIIIIllII, final Object... llllllllllllllIIIIIlIllIIIIIlIll) {
        try {
            final Method llllllllllllllIIIIIlIllIIIIIlIlI = llllllllllllllIIIIIlIllIIIIIllII.getTargetMethod();
            if (llllllllllllllIIIIIlIllIIIIIlIlI == null) {
                return null;
            }
            final String llllllllllllllIIIIIlIllIIIIIlIIl = (String)llllllllllllllIIIIIlIllIIIIIlIlI.invoke(null, llllllllllllllIIIIIlIllIIIIIlIll);
            return llllllllllllllIIIIIlIllIIIIIlIIl;
        }
        catch (Throwable llllllllllllllIIIIIlIllIIIIIlIII) {
            handleException(llllllllllllllIIIIIlIllIIIIIlIII, null, llllllllllllllIIIIIlIllIIIIIllII, llllllllllllllIIIIIlIllIIIIIlIll);
            return null;
        }
    }
    
    public static float callFloat(final Object llllllllllllllIIIIIlIlIllIlllllI, final ReflectorMethod llllllllllllllIIIIIlIlIllIllllIl, final Object... llllllllllllllIIIIIlIlIlllIIIIlI) {
        try {
            final Method llllllllllllllIIIIIlIlIlllIIIIIl = llllllllllllllIIIIIlIlIllIllllIl.getTargetMethod();
            if (llllllllllllllIIIIIlIlIlllIIIIIl == null) {
                return 0.0f;
            }
            final Float llllllllllllllIIIIIlIlIlllIIIIII = (Float)llllllllllllllIIIIIlIlIlllIIIIIl.invoke(llllllllllllllIIIIIlIlIllIlllllI, llllllllllllllIIIIIlIlIlllIIIIlI);
            return llllllllllllllIIIIIlIlIlllIIIIII;
        }
        catch (Throwable llllllllllllllIIIIIlIlIllIllllll) {
            handleException(llllllllllllllIIIIIlIlIllIllllll, llllllllllllllIIIIIlIlIllIlllllI, llllllllllllllIIIIIlIlIllIllllIl, llllllllllllllIIIIIlIlIlllIIIIlI);
            return 0.0f;
        }
    }
    
    public static double callDouble(final Object llllllllllllllIIIIIlIlIllIlIlllI, final ReflectorMethod llllllllllllllIIIIIlIlIllIllIIll, final Object... llllllllllllllIIIIIlIlIllIllIIlI) {
        try {
            final Method llllllllllllllIIIIIlIlIllIllIIIl = llllllllllllllIIIIIlIlIllIllIIll.getTargetMethod();
            if (llllllllllllllIIIIIlIlIllIllIIIl == null) {
                return 0.0;
            }
            final Double llllllllllllllIIIIIlIlIllIllIIII = (Double)llllllllllllllIIIIIlIlIllIllIIIl.invoke(llllllllllllllIIIIIlIlIllIlIlllI, llllllllllllllIIIIIlIlIllIllIIlI);
            return llllllllllllllIIIIIlIlIllIllIIII;
        }
        catch (Throwable llllllllllllllIIIIIlIlIllIlIllll) {
            handleException(llllllllllllllIIIIIlIlIllIlIllll, llllllllllllllIIIIIlIlIllIlIlllI, llllllllllllllIIIIIlIlIllIllIIll, llllllllllllllIIIIIlIlIllIllIIlI);
            return 0.0;
        }
    }
    
    public static Method[] getMethods(final Class llllllllllllllIIIIIlIlIlIIIlIIll, final String llllllllllllllIIIIIlIlIlIIIllIIl) {
        final ArrayList llllllllllllllIIIIIlIlIlIIIllIII = new ArrayList();
        final Method[] llllllllllllllIIIIIlIlIlIIIlIlll = llllllllllllllIIIIIlIlIlIIIlIIll.getDeclaredMethods();
        for (int llllllllllllllIIIIIlIlIlIIIlIllI = 0; llllllllllllllIIIIIlIlIlIIIlIllI < llllllllllllllIIIIIlIlIlIIIlIlll.length; ++llllllllllllllIIIIIlIlIlIIIlIllI) {
            final Method llllllllllllllIIIIIlIlIlIIIlIlIl = llllllllllllllIIIIIlIlIlIIIlIlll[llllllllllllllIIIIIlIlIlIIIlIllI];
            if (llllllllllllllIIIIIlIlIlIIIlIlIl.getName().equals(llllllllllllllIIIIIlIlIlIIIllIIl)) {
                llllllllllllllIIIIIlIlIlIIIllIII.add(llllllllllllllIIIIIlIlIlIIIlIlIl);
            }
        }
        final Method[] llllllllllllllIIIIIlIlIlIIIlIlII = llllllllllllllIIIIIlIlIlIIIllIII.toArray(new Method[llllllllllllllIIIIIlIlIlIIIllIII.size()]);
        return llllllllllllllIIIIIlIlIlIIIlIlII;
    }
    
    private static void handleException(final Throwable llllllllllllllIIIIIlIlIIlIllIlII, final Object llllllllllllllIIIIIlIlIIlIllIIll, final ReflectorMethod llllllllllllllIIIIIlIlIIlIllIllI, final Object[] llllllllllllllIIIIIlIlIIlIllIIIl) {
        if (llllllllllllllIIIIIlIlIIlIllIlII instanceof InvocationTargetException) {
            llllllllllllllIIIIIlIlIIlIllIlII.printStackTrace();
        }
        else {
            if (llllllllllllllIIIIIlIlIIlIllIlII instanceof IllegalArgumentException) {
                Config.warn("*** IllegalArgumentException ***");
                Config.warn(String.valueOf(new StringBuilder("Method: ").append(llllllllllllllIIIIIlIlIIlIllIllI.getTargetMethod())));
                Config.warn(String.valueOf(new StringBuilder("Object: ").append(llllllllllllllIIIIIlIlIIlIllIIll)));
                Config.warn(String.valueOf(new StringBuilder("Parameter classes: ").append(Config.arrayToString(getClasses(llllllllllllllIIIIIlIlIIlIllIIIl)))));
                Config.warn(String.valueOf(new StringBuilder("Parameters: ").append(Config.arrayToString(llllllllllllllIIIIIlIlIIlIllIIIl))));
            }
            Config.warn("*** Exception outside of method ***");
            Config.warn(String.valueOf(new StringBuilder("Method deactivated: ").append(llllllllllllllIIIIIlIlIIlIllIllI.getTargetMethod())));
            llllllllllllllIIIIIlIlIIlIllIllI.deactivate();
            llllllllllllllIIIIIlIlIIlIllIlII.printStackTrace();
        }
    }
    
    private static void handleException(final Throwable llllllllllllllIIIIIlIlIIlIlIllIl, final ReflectorConstructor llllllllllllllIIIIIlIlIIlIlIlIIl, final Object[] llllllllllllllIIIIIlIlIIlIlIlIll) {
        if (llllllllllllllIIIIIlIlIIlIlIllIl instanceof InvocationTargetException) {
            llllllllllllllIIIIIlIlIIlIlIllIl.printStackTrace();
        }
        else {
            if (llllllllllllllIIIIIlIlIIlIlIllIl instanceof IllegalArgumentException) {
                Config.warn("*** IllegalArgumentException ***");
                Config.warn(String.valueOf(new StringBuilder("Constructor: ").append(llllllllllllllIIIIIlIlIIlIlIlIIl.getTargetConstructor())));
                Config.warn(String.valueOf(new StringBuilder("Parameter classes: ").append(Config.arrayToString(getClasses(llllllllllllllIIIIIlIlIIlIlIlIll)))));
                Config.warn(String.valueOf(new StringBuilder("Parameters: ").append(Config.arrayToString(llllllllllllllIIIIIlIlIIlIlIlIll))));
            }
            Config.warn("*** Exception outside of constructor ***");
            Config.warn(String.valueOf(new StringBuilder("Constructor deactivated: ").append(llllllllllllllIIIIIlIlIIlIlIlIIl.getTargetConstructor())));
            llllllllllllllIIIIIlIlIIlIlIlIIl.deactivate();
            llllllllllllllIIIIIlIlIIlIlIllIl.printStackTrace();
        }
    }
    
    public static boolean matchesTypes(final Class[] llllllllllllllIIIIIlIlIlIIIIIIll, final Class[] llllllllllllllIIIIIlIlIlIIIIIIlI) {
        if (llllllllllllllIIIIIlIlIlIIIIIIll.length != llllllllllllllIIIIIlIlIlIIIIIIlI.length) {
            return false;
        }
        for (int llllllllllllllIIIIIlIlIlIIIIIllI = 0; llllllllllllllIIIIIlIlIlIIIIIllI < llllllllllllllIIIIIlIlIlIIIIIIlI.length; ++llllllllllllllIIIIIlIlIlIIIIIllI) {
            final Class llllllllllllllIIIIIlIlIlIIIIIlIl = llllllllllllllIIIIIlIlIlIIIIIIll[llllllllllllllIIIIIlIlIlIIIIIllI];
            final Class llllllllllllllIIIIIlIlIlIIIIIlII = llllllllllllllIIIIIlIlIlIIIIIIlI[llllllllllllllIIIIIlIlIlIIIIIllI];
            if (llllllllllllllIIIIIlIlIlIIIIIlIl != llllllllllllllIIIIIlIlIlIIIIIlII) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean postForgeBusEvent(final Object llllllllllllllIIIIIlIlIlIlIIlIlI) {
        if (llllllllllllllIIIIIlIlIlIlIIlIlI == null) {
            return false;
        }
        final Object llllllllllllllIIIIIlIlIlIlIIlIIl = getFieldValue(Reflector.MinecraftForge_EVENT_BUS);
        if (llllllllllllllIIIIIlIlIlIlIIlIIl == null) {
            return false;
        }
        final Object llllllllllllllIIIIIlIlIlIlIIlIII = call(llllllllllllllIIIIIlIlIlIlIIlIIl, Reflector.EventBus_post, llllllllllllllIIIIIlIlIlIlIIlIlI);
        if (!(llllllllllllllIIIIIlIlIlIlIIlIII instanceof Boolean)) {
            return false;
        }
        final Boolean llllllllllllllIIIIIlIlIlIlIIIlll = (Boolean)llllllllllllllIIIIIlIlIlIlIIlIII;
        return llllllllllllllIIIIIlIlIlIlIIIlll;
    }
    
    private static void dbgFieldValue(final boolean llllllllllllllIIIIIlIlIIllIIlIlI, final String llllllllllllllIIIIIlIlIIllIIIIlI, final ReflectorField llllllllllllllIIIIIlIlIIllIIlIII, final Object llllllllllllllIIIIIlIlIIllIIIlll) {
        final String llllllllllllllIIIIIlIlIIllIIIllI = llllllllllllllIIIIIlIlIIllIIlIII.getTargetField().getDeclaringClass().getName();
        final String llllllllllllllIIIIIlIlIIllIIIlIl = llllllllllllllIIIIIlIlIIllIIlIII.getTargetField().getName();
        String llllllllllllllIIIIIlIlIIllIIIlII = "";
        if (llllllllllllllIIIIIlIlIIllIIlIlI) {
            llllllllllllllIIIIIlIlIIllIIIlII = " static";
        }
        Config.dbg(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIIIlIlIIllIIIIlI)).append(llllllllllllllIIIIIlIlIIllIIIlII).append(" ").append(llllllllllllllIIIIIlIlIIllIIIllI).append(".").append(llllllllllllllIIIIIlIlIIllIIIlIl).append(" => ").append(llllllllllllllIIIIIlIlIIllIIIlll)));
    }
    
    public static void setFieldValue(final Object llllllllllllllIIIIIlIlIlIllIIIII, final ReflectorField llllllllllllllIIIIIlIlIlIlIlllll, final Object llllllllllllllIIIIIlIlIlIlIllllI) {
        try {
            final Field llllllllllllllIIIIIlIlIlIlIlllIl = llllllllllllllIIIIIlIlIlIlIlllll.getTargetField();
            if (llllllllllllllIIIIIlIlIlIlIlllIl == null) {
                return;
            }
            llllllllllllllIIIIIlIlIlIlIlllIl.set(llllllllllllllIIIIIlIlIlIllIIIII, llllllllllllllIIIIIlIlIlIlIllllI);
        }
        catch (Throwable llllllllllllllIIIIIlIlIlIlIlllII) {
            llllllllllllllIIIIIlIlIlIlIlllII.printStackTrace();
        }
    }
    
    public static float getFieldValueFloat(final Object llllllllllllllIIIIIlIlIlIllIllll, final ReflectorField llllllllllllllIIIIIlIlIlIllIlllI, final float llllllllllllllIIIIIlIlIlIlllIIlI) {
        final Object llllllllllllllIIIIIlIlIlIlllIIIl = getFieldValue(llllllllllllllIIIIIlIlIlIllIllll, llllllllllllllIIIIIlIlIlIllIlllI);
        if (!(llllllllllllllIIIIIlIlIlIlllIIIl instanceof Float)) {
            return llllllllllllllIIIIIlIlIlIlllIIlI;
        }
        final Float llllllllllllllIIIIIlIlIlIlllIIII = (Float)llllllllllllllIIIIIlIlIlIlllIIIl;
        return llllllllllllllIIIIIlIlIlIlllIIII;
    }
    
    public static boolean callBoolean(final ReflectorMethod llllllllllllllIIIIIlIllIIIlllIll, final Object... llllllllllllllIIIIIlIllIIIlllIlI) {
        try {
            final Method llllllllllllllIIIIIlIllIIIlllllI = llllllllllllllIIIIIlIllIIIlllIll.getTargetMethod();
            if (llllllllllllllIIIIIlIllIIIlllllI == null) {
                return false;
            }
            final Boolean llllllllllllllIIIIIlIllIIIllllIl = (Boolean)llllllllllllllIIIIIlIllIIIlllllI.invoke(null, llllllllllllllIIIIIlIllIIIlllIlI);
            return llllllllllllllIIIIIlIllIIIllllIl;
        }
        catch (Throwable llllllllllllllIIIIIlIllIIIllllII) {
            handleException(llllllllllllllIIIIIlIllIIIllllII, null, llllllllllllllIIIIIlIllIIIlllIll, llllllllllllllIIIIIlIllIIIlllIlI);
            return false;
        }
    }
    
    public static Object newInstance(final ReflectorConstructor llllllllllllllIIIIIlIlIlIIlllllI, final Object... llllllllllllllIIIIIlIlIlIIllllIl) {
        final Constructor llllllllllllllIIIIIlIlIlIIllllII = llllllllllllllIIIIIlIlIlIIlllllI.getTargetConstructor();
        if (llllllllllllllIIIIIlIlIlIIllllII == null) {
            return null;
        }
        try {
            final Object llllllllllllllIIIIIlIlIlIIlllIll = llllllllllllllIIIIIlIlIlIIllllII.newInstance(llllllllllllllIIIIIlIlIlIIllllIl);
            return llllllllllllllIIIIIlIlIlIIlllIll;
        }
        catch (Throwable llllllllllllllIIIIIlIlIlIIlllIlI) {
            handleException(llllllllllllllIIIIIlIlIlIIlllIlI, llllllllllllllIIIIIlIlIlIIlllllI, llllllllllllllIIIIIlIlIlIIllllIl);
            return null;
        }
    }
    
    public static Object call(final Object llllllllllllllIIIIIlIlIllIIIlllI, final ReflectorMethod llllllllllllllIIIIIlIlIllIIlIIll, final Object... llllllllllllllIIIIIlIlIllIIlIIlI) {
        try {
            final Method llllllllllllllIIIIIlIlIllIIlIIIl = llllllllllllllIIIIIlIlIllIIlIIll.getTargetMethod();
            if (llllllllllllllIIIIIlIlIllIIlIIIl == null) {
                return null;
            }
            final Object llllllllllllllIIIIIlIlIllIIlIIII = llllllllllllllIIIIIlIlIllIIlIIIl.invoke(llllllllllllllIIIIIlIlIllIIIlllI, llllllllllllllIIIIIlIlIllIIlIIlI);
            return llllllllllllllIIIIIlIlIllIIlIIII;
        }
        catch (Throwable llllllllllllllIIIIIlIlIllIIIllll) {
            handleException(llllllllllllllIIIIIlIlIllIIIllll, llllllllllllllIIIIIlIlIllIIIlllI, llllllllllllllIIIIIlIlIllIIlIIll, llllllllllllllIIIIIlIlIllIIlIIlI);
            return null;
        }
    }
    
    public static int callInt(final Object llllllllllllllIIIIIlIlIlllIIlllI, final ReflectorMethod llllllllllllllIIIIIlIlIlllIIllIl, final Object... llllllllllllllIIIIIlIlIlllIlIIlI) {
        try {
            final Method llllllllllllllIIIIIlIlIlllIlIIIl = llllllllllllllIIIIIlIlIlllIIllIl.getTargetMethod();
            if (llllllllllllllIIIIIlIlIlllIlIIIl == null) {
                return 0;
            }
            final Integer llllllllllllllIIIIIlIlIlllIlIIII = (Integer)llllllllllllllIIIIIlIlIlllIlIIIl.invoke(llllllllllllllIIIIIlIlIlllIIlllI, llllllllllllllIIIIIlIlIlllIlIIlI);
            return llllllllllllllIIIIIlIlIlllIlIIII;
        }
        catch (Throwable llllllllllllllIIIIIlIlIlllIIllll) {
            handleException(llllllllllllllIIIIIlIlIlllIIllll, llllllllllllllIIIIIlIlIlllIIlllI, llllllllllllllIIIIIlIlIlllIIllIl, llllllllllllllIIIIIlIlIlllIlIIlI);
            return 0;
        }
    }
    
    public static void setFieldValue(final ReflectorField llllllllllllllIIIIIlIlIlIllIlIII, final Object llllllllllllllIIIIIlIlIlIllIIlll) {
        setFieldValue(null, llllllllllllllIIIIIlIlIlIllIlIII, llllllllllllllIIIIIlIlIlIllIIlll);
    }
    
    public static int callInt(final ReflectorMethod llllllllllllllIIIIIlIllIIIlIlllI, final Object... llllllllllllllIIIIIlIllIIIlIllIl) {
        try {
            final Method llllllllllllllIIIIIlIllIIIllIIIl = llllllllllllllIIIIIlIllIIIlIlllI.getTargetMethod();
            if (llllllllllllllIIIIIlIllIIIllIIIl == null) {
                return 0;
            }
            final Integer llllllllllllllIIIIIlIllIIIllIIII = (Integer)llllllllllllllIIIIIlIllIIIllIIIl.invoke(null, llllllllllllllIIIIIlIllIIIlIllIl);
            return llllllllllllllIIIIIlIllIIIllIIII;
        }
        catch (Throwable llllllllllllllIIIIIlIllIIIlIllll) {
            handleException(llllllllllllllIIIIIlIllIIIlIllll, null, llllllllllllllIIIIIlIllIIIlIlllI, llllllllllllllIIIIIlIllIIIlIllIl);
            return 0;
        }
    }
    
    public static float callFloat(final ReflectorMethod llllllllllllllIIIIIlIllIIIlIIllI, final Object... llllllllllllllIIIIIlIllIIIlIIIII) {
        try {
            final Method llllllllllllllIIIIIlIllIIIlIIlII = llllllllllllllIIIIIlIllIIIlIIllI.getTargetMethod();
            if (llllllllllllllIIIIIlIllIIIlIIlII == null) {
                return 0.0f;
            }
            final Float llllllllllllllIIIIIlIllIIIlIIIll = (Float)llllllllllllllIIIIIlIllIIIlIIlII.invoke(null, llllllllllllllIIIIIlIllIIIlIIIII);
            return llllllllllllllIIIIIlIllIIIlIIIll;
        }
        catch (Throwable llllllllllllllIIIIIlIllIIIlIIIlI) {
            handleException(llllllllllllllIIIIIlIllIIIlIIIlI, null, llllllllllllllIIIIIlIllIIIlIIllI, llllllllllllllIIIIIlIllIIIlIIIII);
            return 0.0f;
        }
    }
    
    public static void callVoid(final Object llllllllllllllIIIIIlIlIlllllIIlI, final ReflectorMethod llllllllllllllIIIIIlIlIllllIllII, final Object... llllllllllllllIIIIIlIlIlllllIIII) {
        try {
            if (llllllllllllllIIIIIlIlIlllllIIlI == null) {
                return;
            }
            final Method llllllllllllllIIIIIlIlIllllIllll = llllllllllllllIIIIIlIlIllllIllII.getTargetMethod();
            if (llllllllllllllIIIIIlIlIllllIllll == null) {
                return;
            }
            llllllllllllllIIIIIlIlIllllIllll.invoke(llllllllllllllIIIIIlIlIlllllIIlI, llllllllllllllIIIIIlIlIlllllIIII);
        }
        catch (Throwable llllllllllllllIIIIIlIlIllllIlllI) {
            handleException(llllllllllllllIIIIIlIlIllllIlllI, llllllllllllllIIIIIlIlIlllllIIlI, llllllllllllllIIIIIlIlIllllIllII, llllllllllllllIIIIIlIlIlllllIIII);
        }
    }
    
    public static String callString(final Object llllllllllllllIIIIIlIlIllIlIIlII, final ReflectorMethod llllllllllllllIIIIIlIlIllIlIIIll, final Object... llllllllllllllIIIIIlIlIllIIlllII) {
        try {
            final Method llllllllllllllIIIIIlIlIllIlIIIIl = llllllllllllllIIIIIlIlIllIlIIIll.getTargetMethod();
            if (llllllllllllllIIIIIlIlIllIlIIIIl == null) {
                return null;
            }
            final String llllllllllllllIIIIIlIlIllIlIIIII = (String)llllllllllllllIIIIIlIlIllIlIIIIl.invoke(llllllllllllllIIIIIlIlIllIlIIlII, llllllllllllllIIIIIlIlIllIIlllII);
            return llllllllllllllIIIIIlIlIllIlIIIII;
        }
        catch (Throwable llllllllllllllIIIIIlIlIllIIlllll) {
            handleException(llllllllllllllIIIIIlIlIllIIlllll, llllllllllllllIIIIIlIlIllIlIIlII, llllllllllllllIIIIIlIlIllIlIIIll, llllllllllllllIIIIIlIlIllIIlllII);
            return null;
        }
    }
    
    public static double callDouble(final ReflectorMethod llllllllllllllIIIIIlIllIIIIlIlII, final Object... llllllllllllllIIIIIlIllIIIIlIIll) {
        try {
            final Method llllllllllllllIIIIIlIllIIIIlIlll = llllllllllllllIIIIIlIllIIIIlIlII.getTargetMethod();
            if (llllllllllllllIIIIIlIllIIIIlIlll == null) {
                return 0.0;
            }
            final Double llllllllllllllIIIIIlIllIIIIlIllI = (Double)llllllllllllllIIIIIlIllIIIIlIlll.invoke(null, llllllllllllllIIIIIlIllIIIIlIIll);
            return llllllllllllllIIIIIlIllIIIIlIllI;
        }
        catch (Throwable llllllllllllllIIIIIlIllIIIIlIlIl) {
            handleException(llllllllllllllIIIIIlIllIIIIlIlIl, null, llllllllllllllIIIIIlIllIIIIlIlII, llllllllllllllIIIIIlIllIIIIlIIll);
            return 0.0;
        }
    }
    
    private static Object[] getClasses(final Object[] llllllllllllllIIIIIlIlIIlIlIIIll) {
        if (llllllllllllllIIIIIlIlIIlIlIIIll == null) {
            return new Class[0];
        }
        final Class[] llllllllllllllIIIIIlIlIIlIlIIIlI = new Class[llllllllllllllIIIIIlIlIIlIlIIIll.length];
        for (int llllllllllllllIIIIIlIlIIlIlIIIIl = 0; llllllllllllllIIIIIlIlIIlIlIIIIl < llllllllllllllIIIIIlIlIIlIlIIIlI.length; ++llllllllllllllIIIIIlIlIIlIlIIIIl) {
            final Object llllllllllllllIIIIIlIlIIlIlIIIII = llllllllllllllIIIIIlIlIIlIlIIIll[llllllllllllllIIIIIlIlIIlIlIIIIl];
            if (llllllllllllllIIIIIlIlIIlIlIIIII != null) {
                llllllllllllllIIIIIlIlIIlIlIIIlI[llllllllllllllIIIIIlIlIIlIlIIIIl] = llllllllllllllIIIIIlIlIIlIlIIIII.getClass();
            }
        }
        return llllllllllllllIIIIIlIlIIlIlIIIlI;
    }
    
    public static void callVoid(final ReflectorMethod llllllllllllllIIIIIlIllIIlIIlIll, final Object... llllllllllllllIIIIIlIllIIlIIlIlI) {
        try {
            final Method llllllllllllllIIIIIlIllIIlIIlIIl = llllllllllllllIIIIIlIllIIlIIlIll.getTargetMethod();
            if (llllllllllllllIIIIIlIllIIlIIlIIl == null) {
                return;
            }
            llllllllllllllIIIIIlIllIIlIIlIIl.invoke(null, llllllllllllllIIIIIlIllIIlIIlIlI);
        }
        catch (Throwable llllllllllllllIIIIIlIllIIlIIlIII) {
            handleException(llllllllllllllIIIIIlIllIIlIIlIII, null, llllllllllllllIIIIIlIllIIlIIlIll, llllllllllllllIIIIIlIllIIlIIlIlI);
        }
    }
    
    public static boolean callBoolean(final Object llllllllllllllIIIIIlIlIlllIllllI, final ReflectorMethod llllllllllllllIIIIIlIlIlllIlllIl, final Object... llllllllllllllIIIIIlIlIlllIlllII) {
        try {
            final Method llllllllllllllIIIIIlIlIllllIIIIl = llllllllllllllIIIIIlIlIlllIlllIl.getTargetMethod();
            if (llllllllllllllIIIIIlIlIllllIIIIl == null) {
                return false;
            }
            final Boolean llllllllllllllIIIIIlIlIllllIIIII = (Boolean)llllllllllllllIIIIIlIlIllllIIIIl.invoke(llllllllllllllIIIIIlIlIlllIllllI, llllllllllllllIIIIIlIlIlllIlllII);
            return llllllllllllllIIIIIlIlIllllIIIII;
        }
        catch (Throwable llllllllllllllIIIIIlIlIlllIlllll) {
            handleException(llllllllllllllIIIIIlIlIlllIlllll, llllllllllllllIIIIIlIlIlllIllllI, llllllllllllllIIIIIlIlIlllIlllIl, llllllllllllllIIIIIlIlIlllIlllII);
            return false;
        }
    }
    
    public static Method getMethod(final Class llllllllllllllIIIIIlIlIlIIlIIlll, final String llllllllllllllIIIIIlIlIlIIlIllIl, final Class[] llllllllllllllIIIIIlIlIlIIlIIlIl) {
        final Method[] llllllllllllllIIIIIlIlIlIIlIlIll = llllllllllllllIIIIIlIlIlIIlIIlll.getDeclaredMethods();
        for (int llllllllllllllIIIIIlIlIlIIlIlIlI = 0; llllllllllllllIIIIIlIlIlIIlIlIlI < llllllllllllllIIIIIlIlIlIIlIlIll.length; ++llllllllllllllIIIIIlIlIlIIlIlIlI) {
            final Method llllllllllllllIIIIIlIlIlIIlIlIIl = llllllllllllllIIIIIlIlIlIIlIlIll[llllllllllllllIIIIIlIlIlIIlIlIlI];
            if (llllllllllllllIIIIIlIlIlIIlIlIIl.getName().equals(llllllllllllllIIIIIlIlIlIIlIllIl)) {
                final Class[] llllllllllllllIIIIIlIlIlIIlIlIII = llllllllllllllIIIIIlIlIlIIlIlIIl.getParameterTypes();
                if (matchesTypes(llllllllllllllIIIIIlIlIlIIlIIlIl, llllllllllllllIIIIIlIlIlIIlIlIII)) {
                    return llllllllllllllIIIIIlIlIlIIlIlIIl;
                }
            }
        }
        return null;
    }
    
    static {
        Reflector.MinecraftForge = new ReflectorClass("net.minecraftforge.common.MinecraftForge");
        Reflector.MinecraftForge_EVENT_BUS = new ReflectorField(Reflector.MinecraftForge, "EVENT_BUS");
        Reflector.ForgeHooks = new ReflectorClass("net.minecraftforge.common.ForgeHooks");
        Reflector.ForgeHooks_onLivingSetAttackTarget = new ReflectorMethod(Reflector.ForgeHooks, "onLivingSetAttackTarget");
        Reflector.ForgeHooks_onLivingUpdate = new ReflectorMethod(Reflector.ForgeHooks, "onLivingUpdate");
        Reflector.ForgeHooks_onLivingAttack = new ReflectorMethod(Reflector.ForgeHooks, "onLivingAttack");
        Reflector.ForgeHooks_onLivingHurt = new ReflectorMethod(Reflector.ForgeHooks, "onLivingHurt");
        Reflector.ForgeHooks_onLivingDeath = new ReflectorMethod(Reflector.ForgeHooks, "onLivingDeath");
        Reflector.ForgeHooks_onLivingDrops = new ReflectorMethod(Reflector.ForgeHooks, "onLivingDrops");
        Reflector.ForgeHooks_onLivingFall = new ReflectorMethod(Reflector.ForgeHooks, "onLivingFall");
        Reflector.ForgeHooks_onLivingJump = new ReflectorMethod(Reflector.ForgeHooks, "onLivingJump");
        Reflector.MinecraftForgeClient = new ReflectorClass("net.minecraftforge.client.MinecraftForgeClient");
        Reflector.MinecraftForgeClient_getRenderPass = new ReflectorMethod(Reflector.MinecraftForgeClient, "getRenderPass");
        Reflector.MinecraftForgeClient_onRebuildChunk = new ReflectorMethod(Reflector.MinecraftForgeClient, "onRebuildChunk");
        Reflector.ForgeHooksClient = new ReflectorClass("net.minecraftforge.client.ForgeHooksClient");
        Reflector.ForgeHooksClient_onDrawBlockHighlight = new ReflectorMethod(Reflector.ForgeHooksClient, "onDrawBlockHighlight");
        Reflector.ForgeHooksClient_orientBedCamera = new ReflectorMethod(Reflector.ForgeHooksClient, "orientBedCamera");
        Reflector.ForgeHooksClient_dispatchRenderLast = new ReflectorMethod(Reflector.ForgeHooksClient, "dispatchRenderLast");
        Reflector.ForgeHooksClient_setRenderPass = new ReflectorMethod(Reflector.ForgeHooksClient, "setRenderPass");
        Reflector.ForgeHooksClient_onTextureStitchedPre = new ReflectorMethod(Reflector.ForgeHooksClient, "onTextureStitchedPre");
        Reflector.ForgeHooksClient_onTextureStitchedPost = new ReflectorMethod(Reflector.ForgeHooksClient, "onTextureStitchedPost");
        Reflector.ForgeHooksClient_renderFirstPersonHand = new ReflectorMethod(Reflector.ForgeHooksClient, "renderFirstPersonHand");
        Reflector.ForgeHooksClient_getOffsetFOV = new ReflectorMethod(Reflector.ForgeHooksClient, "getOffsetFOV");
        Reflector.ForgeHooksClient_drawScreen = new ReflectorMethod(Reflector.ForgeHooksClient, "drawScreen");
        Reflector.ForgeHooksClient_onFogRender = new ReflectorMethod(Reflector.ForgeHooksClient, "onFogRender");
        Reflector.ForgeHooksClient_setRenderLayer = new ReflectorMethod(Reflector.ForgeHooksClient, "setRenderLayer");
        Reflector.ForgeHooksClient_transform = new ReflectorMethod(Reflector.ForgeHooksClient, "transform");
        Reflector.ForgeHooksClient_getMatrix = new ReflectorMethod(Reflector.ForgeHooksClient, "getMatrix", new Class[] { ModelRotation.class });
        Reflector.ForgeHooksClient_fillNormal = new ReflectorMethod(Reflector.ForgeHooksClient, "fillNormal");
        Reflector.ForgeHooksClient_handleCameraTransforms = new ReflectorMethod(Reflector.ForgeHooksClient, "handleCameraTransforms");
        Reflector.ForgeHooksClient_getArmorModel = new ReflectorMethod(Reflector.ForgeHooksClient, "getArmorModel");
        Reflector.ForgeHooksClient_getArmorTexture = new ReflectorMethod(Reflector.ForgeHooksClient, "getArmorTexture");
        Reflector.ForgeHooksClient_putQuadColor = new ReflectorMethod(Reflector.ForgeHooksClient, "putQuadColor");
        Reflector.ForgeHooksClient_loadEntityShader = new ReflectorMethod(Reflector.ForgeHooksClient, "loadEntityShader");
        Reflector.ForgeHooksClient_getFogDensity = new ReflectorMethod(Reflector.ForgeHooksClient, "getFogDensity");
        Reflector.FMLCommonHandler = new ReflectorClass("net.minecraftforge.fml.common.FMLCommonHandler");
        Reflector.FMLCommonHandler_instance = new ReflectorMethod(Reflector.FMLCommonHandler, "instance");
        Reflector.FMLCommonHandler_handleServerStarting = new ReflectorMethod(Reflector.FMLCommonHandler, "handleServerStarting");
        Reflector.FMLCommonHandler_handleServerAboutToStart = new ReflectorMethod(Reflector.FMLCommonHandler, "handleServerAboutToStart");
        Reflector.FMLCommonHandler_enhanceCrashReport = new ReflectorMethod(Reflector.FMLCommonHandler, "enhanceCrashReport");
        Reflector.FMLCommonHandler_getBrandings = new ReflectorMethod(Reflector.FMLCommonHandler, "getBrandings");
        Reflector.FMLCommonHandler_callFuture = new ReflectorMethod(Reflector.FMLCommonHandler, "callFuture");
        Reflector.FMLClientHandler = new ReflectorClass("net.minecraftforge.fml.client.FMLClientHandler");
        Reflector.FMLClientHandler_instance = new ReflectorMethod(Reflector.FMLClientHandler, "instance");
        Reflector.FMLClientHandler_isLoading = new ReflectorMethod(Reflector.FMLClientHandler, "isLoading");
        Reflector.FMLClientHandler_trackBrokenTexture = new ReflectorMethod(Reflector.FMLClientHandler, "trackBrokenTexture");
        Reflector.FMLClientHandler_trackMissingTexture = new ReflectorMethod(Reflector.FMLClientHandler, "trackMissingTexture");
        Reflector.ForgeWorldProvider = new ReflectorClass(WorldProvider.class);
        Reflector.ForgeWorldProvider_getSkyRenderer = new ReflectorMethod(Reflector.ForgeWorldProvider, "getSkyRenderer");
        Reflector.ForgeWorldProvider_getCloudRenderer = new ReflectorMethod(Reflector.ForgeWorldProvider, "getCloudRenderer");
        Reflector.ForgeWorldProvider_getWeatherRenderer = new ReflectorMethod(Reflector.ForgeWorldProvider, "getWeatherRenderer");
        Reflector.ForgeWorld = new ReflectorClass(World.class);
        Reflector.ForgeWorld_countEntities = new ReflectorMethod(Reflector.ForgeWorld, "countEntities", new Class[] { EnumCreatureType.class, Boolean.TYPE });
        Reflector.ForgeWorld_getPerWorldStorage = new ReflectorMethod(Reflector.ForgeWorld, "getPerWorldStorage");
        Reflector.IRenderHandler = new ReflectorClass("net.minecraftforge.client.IRenderHandler");
        Reflector.IRenderHandler_render = new ReflectorMethod(Reflector.IRenderHandler, "render");
        Reflector.DimensionManager = new ReflectorClass("net.minecraftforge.common.DimensionManager");
        Reflector.DimensionManager_getStaticDimensionIDs = new ReflectorMethod(Reflector.DimensionManager, "getStaticDimensionIDs");
        Reflector.WorldEvent_Load = new ReflectorClass("net.minecraftforge.event.world.WorldEvent$Load");
        Reflector.WorldEvent_Load_Constructor = new ReflectorConstructor(Reflector.WorldEvent_Load, new Class[] { World.class });
        Reflector.RenderItemInFrameEvent = new ReflectorClass("net.minecraftforge.client.event.RenderItemInFrameEvent");
        Reflector.RenderItemInFrameEvent_Constructor = new ReflectorConstructor(Reflector.RenderItemInFrameEvent, new Class[] { EntityItemFrame.class, RenderItemFrame.class });
        Reflector.DrawScreenEvent_Pre = new ReflectorClass("net.minecraftforge.client.event.GuiScreenEvent$DrawScreenEvent$Pre");
        Reflector.DrawScreenEvent_Pre_Constructor = new ReflectorConstructor(Reflector.DrawScreenEvent_Pre, new Class[] { GuiScreen.class, Integer.TYPE, Integer.TYPE, Float.TYPE });
        Reflector.DrawScreenEvent_Post = new ReflectorClass("net.minecraftforge.client.event.GuiScreenEvent$DrawScreenEvent$Post");
        Reflector.DrawScreenEvent_Post_Constructor = new ReflectorConstructor(Reflector.DrawScreenEvent_Post, new Class[] { GuiScreen.class, Integer.TYPE, Integer.TYPE, Float.TYPE });
        Reflector.EntityViewRenderEvent_FogColors = new ReflectorClass("net.minecraftforge.client.event.EntityViewRenderEvent$FogColors");
        Reflector.EntityViewRenderEvent_FogColors_Constructor = new ReflectorConstructor(Reflector.EntityViewRenderEvent_FogColors, new Class[] { EntityRenderer.class, Entity.class, Block.class, Double.TYPE, Float.TYPE, Float.TYPE, Float.TYPE });
        Reflector.EntityViewRenderEvent_FogColors_red = new ReflectorField(Reflector.EntityViewRenderEvent_FogColors, "red");
        Reflector.EntityViewRenderEvent_FogColors_green = new ReflectorField(Reflector.EntityViewRenderEvent_FogColors, "green");
        Reflector.EntityViewRenderEvent_FogColors_blue = new ReflectorField(Reflector.EntityViewRenderEvent_FogColors, "blue");
        Reflector.EntityViewRenderEvent_CameraSetup = new ReflectorClass("net.minecraftforge.client.event.EntityViewRenderEvent$CameraSetup");
        Reflector.EntityViewRenderEvent_CameraSetup_Constructor = new ReflectorConstructor(Reflector.EntityViewRenderEvent_CameraSetup, new Class[] { EntityRenderer.class, Entity.class, Block.class, Double.TYPE, Float.TYPE, Float.TYPE, Float.TYPE });
        Reflector.EntityViewRenderEvent_CameraSetup_yaw = new ReflectorField(Reflector.EntityViewRenderEvent_CameraSetup, "yaw");
        Reflector.EntityViewRenderEvent_CameraSetup_pitch = new ReflectorField(Reflector.EntityViewRenderEvent_CameraSetup, "pitch");
        Reflector.EntityViewRenderEvent_CameraSetup_roll = new ReflectorField(Reflector.EntityViewRenderEvent_CameraSetup, "roll");
        Reflector.RenderLivingEvent_Pre = new ReflectorClass("net.minecraftforge.client.event.RenderLivingEvent$Pre");
        Reflector.RenderLivingEvent_Pre_Constructor = new ReflectorConstructor(Reflector.RenderLivingEvent_Pre, new Class[] { EntityLivingBase.class, RendererLivingEntity.class, Double.TYPE, Double.TYPE, Double.TYPE });
        Reflector.RenderLivingEvent_Post = new ReflectorClass("net.minecraftforge.client.event.RenderLivingEvent$Post");
        Reflector.RenderLivingEvent_Post_Constructor = new ReflectorConstructor(Reflector.RenderLivingEvent_Post, new Class[] { EntityLivingBase.class, RendererLivingEntity.class, Double.TYPE, Double.TYPE, Double.TYPE });
        Reflector.RenderLivingEvent_Specials_Pre = new ReflectorClass("net.minecraftforge.client.event.RenderLivingEvent$Specials$Pre");
        Reflector.RenderLivingEvent_Specials_Pre_Constructor = new ReflectorConstructor(Reflector.RenderLivingEvent_Specials_Pre, new Class[] { EntityLivingBase.class, RendererLivingEntity.class, Double.TYPE, Double.TYPE, Double.TYPE });
        Reflector.RenderLivingEvent_Specials_Post = new ReflectorClass("net.minecraftforge.client.event.RenderLivingEvent$Specials$Post");
        Reflector.RenderLivingEvent_Specials_Post_Constructor = new ReflectorConstructor(Reflector.RenderLivingEvent_Specials_Post, new Class[] { EntityLivingBase.class, RendererLivingEntity.class, Double.TYPE, Double.TYPE, Double.TYPE });
        Reflector.EventBus = new ReflectorClass("net.minecraftforge.fml.common.eventhandler.EventBus");
        Reflector.EventBus_post = new ReflectorMethod(Reflector.EventBus, "post");
        Reflector.Event_Result = new ReflectorClass("net.minecraftforge.fml.common.eventhandler.Event$Result");
        Reflector.Event_Result_DENY = new ReflectorField(Reflector.Event_Result, "DENY");
        Reflector.Event_Result_ALLOW = new ReflectorField(Reflector.Event_Result, "ALLOW");
        Reflector.Event_Result_DEFAULT = new ReflectorField(Reflector.Event_Result, "DEFAULT");
        Reflector.ForgeEventFactory = new ReflectorClass("net.minecraftforge.event.ForgeEventFactory");
        Reflector.ForgeEventFactory_canEntitySpawn = new ReflectorMethod(Reflector.ForgeEventFactory, "canEntitySpawn");
        Reflector.ForgeEventFactory_canEntityDespawn = new ReflectorMethod(Reflector.ForgeEventFactory, "canEntityDespawn");
        Reflector.ForgeEventFactory_renderBlockOverlay = new ReflectorMethod(Reflector.ForgeEventFactory, "renderBlockOverlay");
        Reflector.ForgeEventFactory_renderWaterOverlay = new ReflectorMethod(Reflector.ForgeEventFactory, "renderWaterOverlay");
        Reflector.ForgeEventFactory_renderFireOverlay = new ReflectorMethod(Reflector.ForgeEventFactory, "renderFireOverlay");
        Reflector.RenderBlockOverlayEvent_OverlayType = new ReflectorClass("net.minecraftforge.client.event.RenderBlockOverlayEvent$OverlayType");
        Reflector.RenderBlockOverlayEvent_OverlayType_BLOCK = new ReflectorField(Reflector.RenderBlockOverlayEvent_OverlayType, "BLOCK");
        Reflector.ChunkWatchEvent_UnWatch = new ReflectorClass("net.minecraftforge.event.world.ChunkWatchEvent$UnWatch");
        Reflector.ChunkWatchEvent_UnWatch_Constructor = new ReflectorConstructor(Reflector.ChunkWatchEvent_UnWatch, new Class[] { ChunkCoordIntPair.class, EntityPlayerMP.class });
        Reflector.ForgeBlock = new ReflectorClass(Block.class);
        Reflector.ForgeBlock_getBedDirection = new ReflectorMethod(Reflector.ForgeBlock, "getBedDirection");
        Reflector.ForgeBlock_isBed = new ReflectorMethod(Reflector.ForgeBlock, "isBed");
        Reflector.ForgeBlock_isBedFoot = new ReflectorMethod(Reflector.ForgeBlock, "isBedFoot");
        Reflector.ForgeBlock_hasTileEntity = new ReflectorMethod(Reflector.ForgeBlock, "hasTileEntity", new Class[] { IBlockState.class });
        Reflector.ForgeBlock_canCreatureSpawn = new ReflectorMethod(Reflector.ForgeBlock, "canCreatureSpawn");
        Reflector.ForgeBlock_addHitEffects = new ReflectorMethod(Reflector.ForgeBlock, "addHitEffects");
        Reflector.ForgeBlock_addDestroyEffects = new ReflectorMethod(Reflector.ForgeBlock, "addDestroyEffects");
        Reflector.ForgeBlock_isAir = new ReflectorMethod(Reflector.ForgeBlock, "isAir");
        Reflector.ForgeBlock_canRenderInLayer = new ReflectorMethod(Reflector.ForgeBlock, "canRenderInLayer");
        Reflector.ForgeBlock_getExtendedState = new ReflectorMethod(Reflector.ForgeBlock, "getExtendedState");
        Reflector.ForgeEntity = new ReflectorClass(Entity.class);
        Reflector.ForgeEntity_captureDrops = new ReflectorField(Reflector.ForgeEntity, "captureDrops");
        Reflector.ForgeEntity_capturedDrops = new ReflectorField(Reflector.ForgeEntity, "capturedDrops");
        Reflector.ForgeEntity_shouldRenderInPass = new ReflectorMethod(Reflector.ForgeEntity, "shouldRenderInPass");
        Reflector.ForgeEntity_canRiderInteract = new ReflectorMethod(Reflector.ForgeEntity, "canRiderInteract");
        Reflector.ForgeEntity_shouldRiderSit = new ReflectorMethod(Reflector.ForgeEntity, "shouldRiderSit");
        Reflector.ForgeTileEntity = new ReflectorClass(TileEntity.class);
        Reflector.ForgeTileEntity_shouldRenderInPass = new ReflectorMethod(Reflector.ForgeTileEntity, "shouldRenderInPass");
        Reflector.ForgeTileEntity_getRenderBoundingBox = new ReflectorMethod(Reflector.ForgeTileEntity, "getRenderBoundingBox");
        Reflector.ForgeTileEntity_canRenderBreaking = new ReflectorMethod(Reflector.ForgeTileEntity, "canRenderBreaking");
        Reflector.ForgeItem = new ReflectorClass(Item.class);
        Reflector.ForgeItem_onEntitySwing = new ReflectorMethod(Reflector.ForgeItem, "onEntitySwing");
        Reflector.ForgeItem_shouldCauseReequipAnimation = new ReflectorMethod(Reflector.ForgeItem, "shouldCauseReequipAnimation");
        Reflector.ForgeItem_getModel = new ReflectorMethod(Reflector.ForgeItem, "getModel");
        Reflector.ForgeItem_showDurabilityBar = new ReflectorMethod(Reflector.ForgeItem, "showDurabilityBar");
        Reflector.ForgeItem_getDurabilityForDisplay = new ReflectorMethod(Reflector.ForgeItem, "getDurabilityForDisplay");
        Reflector.ForgePotionEffect = new ReflectorClass(PotionEffect.class);
        Reflector.ForgePotionEffect_isCurativeItem = new ReflectorMethod(Reflector.ForgePotionEffect, "isCurativeItem");
        Reflector.ForgeItemRecord = new ReflectorClass(ItemRecord.class);
        Reflector.ForgeItemRecord_getRecordResource = new ReflectorMethod(Reflector.ForgeItemRecord, "getRecordResource", new Class[] { String.class });
        Reflector.ForgeVertexFormatElementEnumUseage = new ReflectorClass(VertexFormatElement.EnumUseage.class);
        Reflector.ForgeVertexFormatElementEnumUseage_preDraw = new ReflectorMethod(Reflector.ForgeVertexFormatElementEnumUseage, "preDraw");
        Reflector.ForgeVertexFormatElementEnumUseage_postDraw = new ReflectorMethod(Reflector.ForgeVertexFormatElementEnumUseage, "postDraw");
        Reflector.BlamingTransformer = new ReflectorClass("net.minecraftforge.fml.common.asm.transformers.BlamingTransformer");
        Reflector.BlamingTransformer_onCrash = new ReflectorMethod(Reflector.BlamingTransformer, "onCrash");
        Reflector.CoreModManager = new ReflectorClass("net.minecraftforge.fml.relauncher.CoreModManager");
        Reflector.CoreModManager_onCrash = new ReflectorMethod(Reflector.CoreModManager, "onCrash");
        Reflector.ISmartBlockModel = new ReflectorClass("net.minecraftforge.client.model.ISmartBlockModel");
        Reflector.ISmartBlockModel_handleBlockState = new ReflectorMethod(Reflector.ISmartBlockModel, "handleBlockState");
        Reflector.Launch = new ReflectorClass("net.minecraft.launchwrapper.Launch");
        Reflector.Launch_blackboard = new ReflectorField(Reflector.Launch, "blackboard");
        Reflector.SplashScreen = new ReflectorClass("net.minecraftforge.fml.client.SplashProgress");
        Reflector.LightUtil = new ReflectorClass("net.minecraftforge.client.model.pipeline.LightUtil");
        Reflector.LightUtil_tessellator = new ReflectorField(Reflector.LightUtil, "tessellator");
        Reflector.LightUtil_itemConsumer = new ReflectorField(Reflector.LightUtil, "itemConsumer");
        Reflector.LightUtil_putBakedQuad = new ReflectorMethod(Reflector.LightUtil, "putBakedQuad");
        Reflector.LightUtil_renderQuadColor = new ReflectorMethod(Reflector.LightUtil, "renderQuadColor");
        Reflector.IExtendedBlockState = new ReflectorClass("net.minecraftforge.common.property.IExtendedBlockState");
        Reflector.IExtendedBlockState_getClean = new ReflectorMethod(Reflector.IExtendedBlockState, "getClean");
        Reflector.ItemModelMesherForge = new ReflectorClass("net.minecraftforge.client.ItemModelMesherForge");
        Reflector.ItemModelMesherForge_Constructor = new ReflectorConstructor(Reflector.ItemModelMesherForge, new Class[] { ModelManager.class });
        Reflector.ModelLoader = new ReflectorClass("net.minecraftforge.client.model.ModelLoader");
        Reflector.ModelLoader_onRegisterItems = new ReflectorMethod(Reflector.ModelLoader, "onRegisterItems");
        Reflector.Attributes = new ReflectorClass("net.minecraftforge.client.model.Attributes");
        Reflector.Attributes_DEFAULT_BAKED_FORMAT = new ReflectorField(Reflector.Attributes, "DEFAULT_BAKED_FORMAT");
        Reflector.BetterFoliageClient = new ReflectorClass("mods.betterfoliage.client.BetterFoliageClient");
        Reflector.IColoredBakedQuad = new ReflectorClass("net.minecraftforge.client.model.IColoredBakedQuad");
        Reflector.ForgeBiomeGenBase = new ReflectorClass(BiomeGenBase.class);
        Reflector.ForgeBiomeGenBase_getWaterColorMultiplier = new ReflectorMethod(Reflector.ForgeBiomeGenBase, "getWaterColorMultiplier");
        Reflector.RenderingRegistry = new ReflectorClass("net.minecraftforge.fml.client.registry.RenderingRegistry");
        Reflector.RenderingRegistry_loadEntityRenderers = new ReflectorMethod(Reflector.RenderingRegistry, "loadEntityRenderers", new Class[] { RenderManager.class, Map.class });
        Reflector.ForgeTileEntityRendererDispatcher = new ReflectorClass(TileEntityRendererDispatcher.class);
        Reflector.ForgeTileEntityRendererDispatcher_preDrawBatch = new ReflectorMethod(Reflector.ForgeTileEntityRendererDispatcher, "preDrawBatch");
        Reflector.ForgeTileEntityRendererDispatcher_drawBatch = new ReflectorMethod(Reflector.ForgeTileEntityRendererDispatcher, "drawBatch");
        Reflector.OptiFineClassTransformer = new ReflectorClass("optifine.OptiFineClassTransformer");
        Reflector.OptiFineClassTransformer_instance = new ReflectorField(Reflector.OptiFineClassTransformer, "instance");
        Reflector.OptiFineClassTransformer_getOptiFineResource = new ReflectorMethod(Reflector.OptiFineClassTransformer, "getOptiFineResource");
        Reflector.ForgeModContainer = new ReflectorClass("net.minecraftforge.common.ForgeModContainer");
        Reflector.ForgeModContainer_forgeLightPipelineEnabled = new ReflectorField(Reflector.ForgeModContainer, "forgeLightPipelineEnabled");
    }
    
    public static Object getFieldValue(final ReflectorField llllllllllllllIIIIIlIlIllIIIlIII) {
        return getFieldValue(null, llllllllllllllIIIIIlIlIllIIIlIII);
    }
    
    public static Object getFieldValue(final Object llllllllllllllIIIIIlIlIllIIIIIlI, final ReflectorField llllllllllllllIIIIIlIlIlIlllllII) {
        try {
            final Field llllllllllllllIIIIIlIlIllIIIIIII = llllllllllllllIIIIIlIlIlIlllllII.getTargetField();
            if (llllllllllllllIIIIIlIlIllIIIIIII == null) {
                return null;
            }
            final Object llllllllllllllIIIIIlIlIlIlllllll = llllllllllllllIIIIIlIlIllIIIIIII.get(llllllllllllllIIIIIlIlIllIIIIIlI);
            return llllllllllllllIIIIIlIlIlIlllllll;
        }
        catch (Throwable llllllllllllllIIIIIlIlIlIllllllI) {
            llllllllllllllIIIIIlIlIlIllllllI.printStackTrace();
            return null;
        }
    }
    
    public static Object call(final ReflectorMethod llllllllllllllIIIIIlIlIlllllllll, final Object... llllllllllllllIIIIIlIlIllllllllI) {
        try {
            final Method llllllllllllllIIIIIlIlIlllllllIl = llllllllllllllIIIIIlIlIlllllllll.getTargetMethod();
            if (llllllllllllllIIIIIlIlIlllllllIl == null) {
                return null;
            }
            final Object llllllllllllllIIIIIlIlIlllllllII = llllllllllllllIIIIIlIlIlllllllIl.invoke(null, llllllllllllllIIIIIlIlIllllllllI);
            return llllllllllllllIIIIIlIlIlllllllII;
        }
        catch (Throwable llllllllllllllIIIIIlIlIllllllIll) {
            handleException(llllllllllllllIIIIIlIlIllllllIll, null, llllllllllllllIIIIIlIlIlllllllll, llllllllllllllIIIIIlIlIllllllllI);
            return null;
        }
    }
    
    public static Field getField(final Class llllllllllllllIIIIIlIlIIlIIlIIII, final Class llllllllllllllIIIIIlIlIIlIIlIlIl) {
        try {
            final Field[] llllllllllllllIIIIIlIlIIlIIlIlII = llllllllllllllIIIIIlIlIIlIIlIIII.getDeclaredFields();
            for (int llllllllllllllIIIIIlIlIIlIIlIIll = 0; llllllllllllllIIIIIlIlIIlIIlIIll < llllllllllllllIIIIIlIlIIlIIlIlII.length; ++llllllllllllllIIIIIlIlIIlIIlIIll) {
                final Field llllllllllllllIIIIIlIlIIlIIlIIlI = llllllllllllllIIIIIlIlIIlIIlIlII[llllllllllllllIIIIIlIlIIlIIlIIll];
                if (llllllllllllllIIIIIlIlIIlIIlIIlI.getType() == llllllllllllllIIIIIlIlIIlIIlIlIl) {
                    llllllllllllllIIIIIlIlIIlIIlIIlI.setAccessible(true);
                    return llllllllllllllIIIIIlIlIIlIIlIIlI;
                }
            }
            return null;
        }
        catch (Exception llllllllllllllIIIIIlIlIIlIIlIIIl) {
            return null;
        }
    }
}
