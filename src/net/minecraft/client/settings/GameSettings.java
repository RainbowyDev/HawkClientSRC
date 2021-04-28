package net.minecraft.client.settings;

import com.google.gson.*;
import net.minecraft.client.*;
import org.lwjgl.input.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.audio.*;
import java.io.*;
import java.lang.reflect.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.stream.*;
import org.apache.commons.lang3.*;
import shadersmod.client.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import org.lwjgl.opengl.*;
import optifine.*;
import net.minecraft.world.*;
import com.google.common.collect.*;
import java.util.*;
import org.apache.logging.log4j.*;

public class GameSettings
{
    public /* synthetic */ boolean ofLazyChunkLoading;
    private static final /* synthetic */ String[] STREAM_CHAT_MODES;
    public /* synthetic */ String language;
    public /* synthetic */ float chatScale;
    public /* synthetic */ int ofClouds;
    public /* synthetic */ float chatWidth;
    public /* synthetic */ boolean ofAnimatedTerrain;
    public /* synthetic */ int ofMipmapType;
    public /* synthetic */ boolean heldItemTooltips;
    public /* synthetic */ KeyBinding keyBindStreamToggleMic;
    public /* synthetic */ boolean fancyGraphics;
    public /* synthetic */ KeyBinding keyBindSneak;
    public /* synthetic */ boolean ofSmoothWorld;
    public /* synthetic */ boolean ofDrippingWaterLava;
    public /* synthetic */ boolean ofAnimatedTextures;
    public /* synthetic */ int ofTranslucentBlocks;
    public /* synthetic */ int ofAutoSaveTicks;
    public /* synthetic */ KeyBinding keyBindDrop;
    public /* synthetic */ boolean ofOcclusionFancy;
    public /* synthetic */ int ofDroppedItems;
    public /* synthetic */ boolean ofCustomItems;
    private static final /* synthetic */ String[] STREAM_CHAT_FILTER_MODES;
    public /* synthetic */ float streamGameVolume;
    public /* synthetic */ float mouseSensitivity;
    public /* synthetic */ float streamBytesPerPixel;
    private static final /* synthetic */ String[] AMBIENT_OCCLUSIONS;
    public /* synthetic */ boolean field_178879_v;
    public /* synthetic */ boolean ofAnimatedExplosion;
    public /* synthetic */ boolean ofVoidParticles;
    public /* synthetic */ int ofChunkUpdates;
    public /* synthetic */ int ofAnimatedLava;
    public /* synthetic */ boolean ofAnimatedPortal;
    public /* synthetic */ int ofTrees;
    public /* synthetic */ float streamFps;
    public /* synthetic */ int ofVignette;
    public /* synthetic */ boolean fullScreen;
    public /* synthetic */ KeyBinding ofKeyBindZoom;
    public /* synthetic */ boolean ofFireworkParticles;
    public /* synthetic */ KeyBinding keyBindSprint;
    public /* synthetic */ boolean ofPotionParticles;
    public /* synthetic */ KeyBinding keyBindSmoothCamera;
    private static final /* synthetic */ int[] OF_DYNAMIC_LIGHTS;
    public /* synthetic */ KeyBinding keyBindForward;
    private static final /* synthetic */ String[] PARTICLES;
    public /* synthetic */ String lastServer;
    public /* synthetic */ boolean ofAnimatedRedstone;
    public /* synthetic */ int particleSetting;
    public /* synthetic */ KeyBinding field_178883_an;
    public /* synthetic */ KeyBinding keyBindFullscreen;
    public /* synthetic */ KeyBinding keyBindJump;
    public /* synthetic */ int ofRain;
    public /* synthetic */ boolean ofShowFps;
    public /* synthetic */ List resourcePacks;
    public /* synthetic */ float streamMicVolume;
    private /* synthetic */ File optionsFile;
    public /* synthetic */ boolean ofSky;
    public /* synthetic */ boolean forceUnicodeFont;
    public /* synthetic */ int ofTime;
    private static final /* synthetic */ String[] GUISCALES;
    public /* synthetic */ String ofFullscreenMode;
    private static final /* synthetic */ String[] STREAM_MIC_MODES;
    public /* synthetic */ boolean ofFastMath;
    public /* synthetic */ float fovSetting;
    public /* synthetic */ boolean ofWaterParticles;
    public /* synthetic */ float chatOpacity;
    public /* synthetic */ boolean ofBetterSnow;
    public /* synthetic */ int ofFogType;
    public /* synthetic */ int guiScale;
    public /* synthetic */ boolean anaglyph;
    public /* synthetic */ boolean pauseOnLostFocus;
    public /* synthetic */ boolean field_178881_t;
    public /* synthetic */ EntityPlayer.EnumChatVisibility chatVisibility;
    public /* synthetic */ int mipmapLevels;
    public /* synthetic */ boolean invertMouse;
    public /* synthetic */ KeyBinding keyBindInventory;
    public /* synthetic */ float chatHeightUnfocused;
    public /* synthetic */ boolean ofFastRender;
    public /* synthetic */ int ambientOcclusion;
    public /* synthetic */ float saturation;
    public /* synthetic */ boolean chatColours;
    public /* synthetic */ boolean ofPortalParticles;
    public /* synthetic */ boolean chatLinks;
    public /* synthetic */ boolean ofSmoothFps;
    public /* synthetic */ KeyBinding keyBindUseItem;
    public /* synthetic */ KeyBinding keyBindTogglePerspective;
    public /* synthetic */ KeyBinding keyBindAttack;
    public /* synthetic */ float ofCloudsHeight;
    public /* synthetic */ int streamChatUserFilter;
    public /* synthetic */ boolean streamSendMetadata;
    public /* synthetic */ float streamKbps;
    public /* synthetic */ boolean ofRandomMobs;
    public /* synthetic */ boolean snooperEnabled;
    public /* synthetic */ KeyBinding keyBindPickBlock;
    public /* synthetic */ KeyBinding keyBindStreamCommercials;
    public /* synthetic */ int streamMicToggleBehavior;
    public /* synthetic */ boolean ofAnimatedFire;
    public /* synthetic */ boolean ofProfiler;
    public /* synthetic */ boolean ofWeather;
    public /* synthetic */ boolean touchscreen;
    public /* synthetic */ boolean ofCustomColors;
    public /* synthetic */ int ofAaLevel;
    public /* synthetic */ int ofAnimatedWater;
    public /* synthetic */ KeyBinding[] keyBindings;
    public /* synthetic */ KeyBinding keyBindStreamStartStop;
    public /* synthetic */ boolean ofSunMoon;
    public /* synthetic */ boolean ofNaturalTextures;
    public /* synthetic */ float ofFogStart;
    private final /* synthetic */ Set field_178882_aU;
    public /* synthetic */ boolean ofSmoothBiomes;
    private static final /* synthetic */ String[] KEYS_DYNAMIC_LIGHTS;
    private static final /* synthetic */ int[] OF_TREES_VALUES;
    public /* synthetic */ float ofAoLevel;
    public /* synthetic */ boolean ofAnimatedSmoke;
    public /* synthetic */ String streamPreferredServer;
    public /* synthetic */ boolean advancedItemTooltips;
    public /* synthetic */ boolean ofShowCapes;
    public /* synthetic */ boolean enableVsync;
    public /* synthetic */ boolean fboEnable;
    public /* synthetic */ boolean ofStars;
    public /* synthetic */ int renderDistanceChunks;
    private static final /* synthetic */ Logger logger;
    public /* synthetic */ KeyBinding keyBindCommand;
    public /* synthetic */ boolean ofDynamicFov;
    public /* synthetic */ KeyBinding keyBindPlayerList;
    public /* synthetic */ int overrideWidth;
    public /* synthetic */ KeyBinding keyBindLeft;
    public /* synthetic */ boolean ofAnimatedFlame;
    public /* synthetic */ KeyBinding keyBindStreamPauseUnpause;
    public /* synthetic */ boolean ofSwampColors;
    public /* synthetic */ int overrideHeight;
    public /* synthetic */ boolean clouds;
    public /* synthetic */ boolean ofCustomSky;
    public /* synthetic */ int streamCompression;
    public /* synthetic */ int ofConnectedTextures;
    public /* synthetic */ boolean hideServerAddress;
    public /* synthetic */ EnumDifficulty difficulty;
    public /* synthetic */ boolean field_178880_u;
    public /* synthetic */ boolean ofClearWater;
    public /* synthetic */ boolean ofChunkUpdatesDynamic;
    public /* synthetic */ KeyBinding keyBindChat;
    private static final /* synthetic */ ParameterizedType typeListString;
    public /* synthetic */ int ofDynamicLights;
    public /* synthetic */ KeyBinding[] keyBindsHotbar;
    public /* synthetic */ boolean viewBobbing;
    public /* synthetic */ int streamChatEnabled;
    private static final /* synthetic */ Gson gson;
    protected /* synthetic */ Minecraft mc;
    public /* synthetic */ boolean showInventoryAchievementHint;
    public /* synthetic */ KeyBinding keyBindScreenshot;
    public /* synthetic */ boolean chatLinksPrompt;
    public /* synthetic */ float gammaSetting;
    public /* synthetic */ int ofAfLevel;
    public /* synthetic */ boolean ofLagometer;
    private /* synthetic */ Map mapSoundLevels;
    public /* synthetic */ KeyBinding keyBindRight;
    public /* synthetic */ boolean ofRainSplash;
    public /* synthetic */ KeyBinding keyBindBack;
    private static final /* synthetic */ String[] STREAM_COMPRESSIONS;
    public /* synthetic */ int limitFramerate;
    public /* synthetic */ int ofBetterGrass;
    public /* synthetic */ boolean ofCustomFonts;
    private /* synthetic */ File optionsFileOF;
    public /* synthetic */ float chatHeightFocused;
    
    public void saveOfOptions() {
        try {
            final PrintWriter lllllllllllllllIlIIIIIIIIIIIIlll = new PrintWriter(new FileWriter(this.optionsFileOF));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofRenderDistanceChunks:").append(this.renderDistanceChunks)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofFogType:").append(this.ofFogType)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofFogStart:").append(this.ofFogStart)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofMipmapType:").append(this.ofMipmapType)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofOcclusionFancy:").append(this.ofOcclusionFancy)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofSmoothFps:").append(this.ofSmoothFps)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofSmoothWorld:").append(this.ofSmoothWorld)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofAoLevel:").append(this.ofAoLevel)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofClouds:").append(this.ofClouds)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofCloudsHeight:").append(this.ofCloudsHeight)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofTrees:").append(this.ofTrees)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofDroppedItems:").append(this.ofDroppedItems)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofRain:").append(this.ofRain)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofAnimatedWater:").append(this.ofAnimatedWater)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofAnimatedLava:").append(this.ofAnimatedLava)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofAnimatedFire:").append(this.ofAnimatedFire)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofAnimatedPortal:").append(this.ofAnimatedPortal)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofAnimatedRedstone:").append(this.ofAnimatedRedstone)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofAnimatedExplosion:").append(this.ofAnimatedExplosion)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofAnimatedFlame:").append(this.ofAnimatedFlame)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofAnimatedSmoke:").append(this.ofAnimatedSmoke)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofVoidParticles:").append(this.ofVoidParticles)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofWaterParticles:").append(this.ofWaterParticles)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofPortalParticles:").append(this.ofPortalParticles)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofPotionParticles:").append(this.ofPotionParticles)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofFireworkParticles:").append(this.ofFireworkParticles)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofDrippingWaterLava:").append(this.ofDrippingWaterLava)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofAnimatedTerrain:").append(this.ofAnimatedTerrain)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofAnimatedTextures:").append(this.ofAnimatedTextures)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofRainSplash:").append(this.ofRainSplash)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofLagometer:").append(this.ofLagometer)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofShowFps:").append(this.ofShowFps)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofAutoSaveTicks:").append(this.ofAutoSaveTicks)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofBetterGrass:").append(this.ofBetterGrass)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofConnectedTextures:").append(this.ofConnectedTextures)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofWeather:").append(this.ofWeather)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofSky:").append(this.ofSky)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofStars:").append(this.ofStars)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofSunMoon:").append(this.ofSunMoon)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofVignette:").append(this.ofVignette)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofChunkUpdates:").append(this.ofChunkUpdates)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofChunkUpdatesDynamic:").append(this.ofChunkUpdatesDynamic)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofTime:").append(this.ofTime)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofClearWater:").append(this.ofClearWater)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofAaLevel:").append(this.ofAaLevel)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofAfLevel:").append(this.ofAfLevel)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofProfiler:").append(this.ofProfiler)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofBetterSnow:").append(this.ofBetterSnow)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofSwampColors:").append(this.ofSwampColors)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofRandomMobs:").append(this.ofRandomMobs)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofSmoothBiomes:").append(this.ofSmoothBiomes)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofCustomFonts:").append(this.ofCustomFonts)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofCustomColors:").append(this.ofCustomColors)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofCustomItems:").append(this.ofCustomItems)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofCustomSky:").append(this.ofCustomSky)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofShowCapes:").append(this.ofShowCapes)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofNaturalTextures:").append(this.ofNaturalTextures)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofLazyChunkLoading:").append(this.ofLazyChunkLoading)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofDynamicFov:").append(this.ofDynamicFov)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofDynamicLights:").append(this.ofDynamicLights)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofFullscreenMode:").append(this.ofFullscreenMode)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofFastMath:").append(this.ofFastMath)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofFastRender:").append(this.ofFastRender)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("ofTranslucentBlocks:").append(this.ofTranslucentBlocks)));
            lllllllllllllllIlIIIIIIIIIIIIlll.println(String.valueOf(new StringBuilder("key_").append(this.ofKeyBindZoom.getKeyDescription()).append(":").append(this.ofKeyBindZoom.getKeyCode())));
            lllllllllllllllIlIIIIIIIIIIIIlll.close();
        }
        catch (Exception lllllllllllllllIlIIIIIIIIIIIIllI) {
            Config.warn("Failed to save options");
            lllllllllllllllIlIIIIIIIIIIIIllI.printStackTrace();
        }
    }
    
    private float parseFloat(final String lllllllllllllllIlIIIIIIIlIlIIlIl) {
        return lllllllllllllllIlIIIIIIIlIlIIlIl.equals("true") ? 1.0f : (lllllllllllllllIlIIIIIIIlIlIIlIl.equals("false") ? 0.0f : Float.parseFloat(lllllllllllllllIlIIIIIIIlIlIIlIl));
    }
    
    public boolean shouldRenderClouds() {
        return this.renderDistanceChunks >= 4 && this.clouds;
    }
    
    public static boolean isKeyDown(final KeyBinding lllllllllllllllIlIIIIIIlIIlIIIlI) {
        final int lllllllllllllllIlIIIIIIlIIlIIIIl = lllllllllllllllIlIIIIIIlIIlIIIlI.getKeyCode();
        return lllllllllllllllIlIIIIIIlIIlIIIIl >= -100 && lllllllllllllllIlIIIIIIlIIlIIIIl <= 255 && lllllllllllllllIlIIIIIIlIIlIIIlI.getKeyCode() != 0 && ((lllllllllllllllIlIIIIIIlIIlIIIlI.getKeyCode() < 0) ? Mouse.isButtonDown(lllllllllllllllIlIIIIIIlIIlIIIlI.getKeyCode() + 100) : Keyboard.isKeyDown(lllllllllllllllIlIIIIIIlIIlIIIlI.getKeyCode()));
    }
    
    public void setOptionFloatValue(final Options lllllllllllllllIlIIIIIIlIIIIllll, final float lllllllllllllllIlIIIIIIlIIIIlllI) {
        this.setOptionFloatValueOF(lllllllllllllllIlIIIIIIlIIIIllll, lllllllllllllllIlIIIIIIlIIIIlllI);
        if (lllllllllllllllIlIIIIIIlIIIIllll == Options.SENSITIVITY) {
            this.mouseSensitivity = lllllllllllllllIlIIIIIIlIIIIlllI;
        }
        if (lllllllllllllllIlIIIIIIlIIIIllll == Options.FOV) {
            this.fovSetting = lllllllllllllllIlIIIIIIlIIIIlllI;
        }
        if (lllllllllllllllIlIIIIIIlIIIIllll == Options.GAMMA) {
            this.gammaSetting = lllllllllllllllIlIIIIIIlIIIIlllI;
        }
        if (lllllllllllllllIlIIIIIIlIIIIllll == Options.FRAMERATE_LIMIT) {
            this.limitFramerate = (int)lllllllllllllllIlIIIIIIlIIIIlllI;
            this.enableVsync = false;
            if (this.limitFramerate <= 0) {
                this.limitFramerate = (int)Options.FRAMERATE_LIMIT.getValueMax();
                this.enableVsync = true;
            }
            this.updateVSync();
        }
        if (lllllllllllllllIlIIIIIIlIIIIllll == Options.CHAT_OPACITY) {
            this.chatOpacity = lllllllllllllllIlIIIIIIlIIIIlllI;
            this.mc.ingameGUI.getChatGUI().refreshChat();
        }
        if (lllllllllllllllIlIIIIIIlIIIIllll == Options.CHAT_HEIGHT_FOCUSED) {
            this.chatHeightFocused = lllllllllllllllIlIIIIIIlIIIIlllI;
            this.mc.ingameGUI.getChatGUI().refreshChat();
        }
        if (lllllllllllllllIlIIIIIIlIIIIllll == Options.CHAT_HEIGHT_UNFOCUSED) {
            this.chatHeightUnfocused = lllllllllllllllIlIIIIIIlIIIIlllI;
            this.mc.ingameGUI.getChatGUI().refreshChat();
        }
        if (lllllllllllllllIlIIIIIIlIIIIllll == Options.CHAT_WIDTH) {
            this.chatWidth = lllllllllllllllIlIIIIIIlIIIIlllI;
            this.mc.ingameGUI.getChatGUI().refreshChat();
        }
        if (lllllllllllllllIlIIIIIIlIIIIllll == Options.CHAT_SCALE) {
            this.chatScale = lllllllllllllllIlIIIIIIlIIIIlllI;
            this.mc.ingameGUI.getChatGUI().refreshChat();
        }
        if (lllllllllllllllIlIIIIIIlIIIIllll == Options.MIPMAP_LEVELS) {
            final int lllllllllllllllIlIIIIIIlIIIIllII = this.mipmapLevels;
            this.mipmapLevels = (int)lllllllllllllllIlIIIIIIlIIIIlllI;
            if (lllllllllllllllIlIIIIIIlIIIIllII != lllllllllllllllIlIIIIIIlIIIIlllI) {
                this.mc.getTextureMapBlocks().setMipmapLevels(this.mipmapLevels);
                this.mc.getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
                this.mc.getTextureMapBlocks().func_174937_a(false, this.mipmapLevels > 0);
                this.mc.func_175603_A();
            }
        }
        if (lllllllllllllllIlIIIIIIlIIIIllll == Options.BLOCK_ALTERNATIVES) {
            this.field_178880_u = !this.field_178880_u;
            this.mc.renderGlobal.loadRenderers();
        }
        if (lllllllllllllllIlIIIIIIlIIIIllll == Options.RENDER_DISTANCE) {
            this.renderDistanceChunks = (int)lllllllllllllllIlIIIIIIlIIIIlllI;
            this.mc.renderGlobal.func_174979_m();
        }
        if (lllllllllllllllIlIIIIIIlIIIIllll == Options.STREAM_BYTES_PER_PIXEL) {
            this.streamBytesPerPixel = lllllllllllllllIlIIIIIIlIIIIlllI;
        }
        if (lllllllllllllllIlIIIIIIlIIIIllll == Options.STREAM_VOLUME_MIC) {
            this.streamMicVolume = lllllllllllllllIlIIIIIIlIIIIlllI;
            this.mc.getTwitchStream().func_152915_s();
        }
        if (lllllllllllllllIlIIIIIIlIIIIllll == Options.STREAM_VOLUME_SYSTEM) {
            this.streamGameVolume = lllllllllllllllIlIIIIIIlIIIIlllI;
            this.mc.getTwitchStream().func_152915_s();
        }
        if (lllllllllllllllIlIIIIIIlIIIIllll == Options.STREAM_KBPS) {
            this.streamKbps = lllllllllllllllIlIIIIIIlIIIIlllI;
        }
        if (lllllllllllllllIlIIIIIIlIIIIllll == Options.STREAM_FPS) {
            this.streamFps = lllllllllllllllIlIIIIIIlIIIIlllI;
        }
    }
    
    private static String getTranslation(final String[] lllllllllllllllIlIIIIIIIllIlllll, int lllllllllllllllIlIIIIIIIllIllllI) {
        if (lllllllllllllllIlIIIIIIIllIllllI < 0 || lllllllllllllllIlIIIIIIIllIllllI >= lllllllllllllllIlIIIIIIIllIlllll.length) {
            lllllllllllllllIlIIIIIIIllIllllI = 0;
        }
        return I18n.format(lllllllllllllllIlIIIIIIIllIlllll[lllllllllllllllIlIIIIIIIllIllllI], new Object[0]);
    }
    
    public float getSoundLevel(final SoundCategory lllllllllllllllIlIIIIIIIlIIIIIlI) {
        return this.mapSoundLevels.containsKey(lllllllllllllllIlIIIIIIIlIIIIIlI) ? this.mapSoundLevels.get(lllllllllllllllIlIIIIIIIlIIIIIlI) : 1.0f;
    }
    
    private static int indexOf(final int lllllllllllllllIIlllllllllIlIllI, final int[] lllllllllllllllIIlllllllllIllIII) {
        for (int lllllllllllllllIIlllllllllIlIlll = 0; lllllllllllllllIIlllllllllIlIlll < lllllllllllllllIIlllllllllIllIII.length; ++lllllllllllllllIIlllllllllIlIlll) {
            if (lllllllllllllllIIlllllllllIllIII[lllllllllllllllIIlllllllllIlIlll] == lllllllllllllllIIlllllllllIlIllI) {
                return lllllllllllllllIIlllllllllIlIlll;
            }
        }
        return -1;
    }
    
    private String getKeyBindingOF(final Options lllllllllllllllIlIIIIIIIIIlIllIl) {
        String lllllllllllllllIlIIIIIIIIIlIllII = String.valueOf(new StringBuilder(String.valueOf(I18n.format(lllllllllllllllIlIIIIIIIIIlIllIl.getEnumString(), new Object[0]))).append(": "));
        if (lllllllllllllllIlIIIIIIIIIlIllII == null) {
            lllllllllllllllIlIIIIIIIIIlIllII = lllllllllllllllIlIIIIIIIIIlIllIl.getEnumString();
        }
        if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.RENDER_DISTANCE) {
            final int lllllllllllllllIlIIIIIIIIIlIlIll = (int)this.getOptionFloatValue(lllllllllllllllIlIIIIIIIIIlIllIl);
            String lllllllllllllllIlIIIIIIIIIlIlIIl = I18n.format("options.renderDistance.tiny", new Object[0]);
            byte lllllllllllllllIlIIIIIIIIIlIlIII = 2;
            if (lllllllllllllllIlIIIIIIIIIlIlIll >= 4) {
                lllllllllllllllIlIIIIIIIIIlIlIIl = I18n.format("options.renderDistance.short", new Object[0]);
                lllllllllllllllIlIIIIIIIIIlIlIII = 4;
            }
            if (lllllllllllllllIlIIIIIIIIIlIlIll >= 8) {
                lllllllllllllllIlIIIIIIIIIlIlIIl = I18n.format("options.renderDistance.normal", new Object[0]);
                lllllllllllllllIlIIIIIIIIIlIlIII = 8;
            }
            if (lllllllllllllllIlIIIIIIIIIlIlIll >= 16) {
                lllllllllllllllIlIIIIIIIIIlIlIIl = I18n.format("options.renderDistance.far", new Object[0]);
                lllllllllllllllIlIIIIIIIIIlIlIII = 16;
            }
            if (lllllllllllllllIlIIIIIIIIIlIlIll >= 32) {
                lllllllllllllllIlIIIIIIIIIlIlIIl = Lang.get("of.options.renderDistance.extreme");
                lllllllllllllllIlIIIIIIIIIlIlIII = 32;
            }
            final int lllllllllllllllIlIIIIIIIIIlIIlll = this.renderDistanceChunks - lllllllllllllllIlIIIIIIIIIlIlIII;
            String lllllllllllllllIlIIIIIIIIIlIIllI = lllllllllllllllIlIIIIIIIIIlIlIIl;
            if (lllllllllllllllIlIIIIIIIIIlIIlll > 0) {
                lllllllllllllllIlIIIIIIIIIlIIllI = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIlIIl)).append("+"));
            }
            return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(lllllllllllllllIlIIIIIIIIIlIlIll).append(" ").append(lllllllllllllllIlIIIIIIIIIlIIllI));
        }
        if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.FOG_FANCY) {
            switch (this.ofFogType) {
                case 1: {
                    return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getFast()));
                }
                case 2: {
                    return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getFancy()));
                }
                case 3: {
                    return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                }
                default: {
                    return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                }
            }
        }
        else {
            if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.FOG_START) {
                return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(this.ofFogStart));
            }
            if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.MIPMAP_TYPE) {
                switch (this.ofMipmapType) {
                    case 0: {
                        return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.get("of.options.mipmap.nearest")));
                    }
                    case 1: {
                        return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.get("of.options.mipmap.linear")));
                    }
                    case 2: {
                        return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.get("of.options.mipmap.bilinear")));
                    }
                    case 3: {
                        return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.get("of.options.mipmap.trilinear")));
                    }
                    default: {
                        return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append("of.options.mipmap.nearest"));
                    }
                }
            }
            else {
                if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.SMOOTH_FPS) {
                    return this.ofSmoothFps ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                }
                if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.SMOOTH_WORLD) {
                    return this.ofSmoothWorld ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                }
                if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.CLOUDS) {
                    switch (this.ofClouds) {
                        case 1: {
                            return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getFast()));
                        }
                        case 2: {
                            return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getFancy()));
                        }
                        case 3: {
                            return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                        }
                        default: {
                            return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getDefault()));
                        }
                    }
                }
                else if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.TREES) {
                    switch (this.ofTrees) {
                        case 1: {
                            return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getFast()));
                        }
                        case 2: {
                            return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getFancy()));
                        }
                        default: {
                            return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getDefault()));
                        }
                        case 4: {
                            return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.get("of.general.smart")));
                        }
                    }
                }
                else if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.DROPPED_ITEMS) {
                    switch (this.ofDroppedItems) {
                        case 1: {
                            return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getFast()));
                        }
                        case 2: {
                            return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getFancy()));
                        }
                        default: {
                            return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getDefault()));
                        }
                    }
                }
                else if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.RAIN) {
                    switch (this.ofRain) {
                        case 1: {
                            return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getFast()));
                        }
                        case 2: {
                            return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getFancy()));
                        }
                        case 3: {
                            return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                        }
                        default: {
                            return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getDefault()));
                        }
                    }
                }
                else if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.ANIMATED_WATER) {
                    switch (this.ofAnimatedWater) {
                        case 1: {
                            return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.get("of.options.animation.dynamic")));
                        }
                        case 2: {
                            return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                        }
                        default: {
                            return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOn()));
                        }
                    }
                }
                else if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.ANIMATED_LAVA) {
                    switch (this.ofAnimatedLava) {
                        case 1: {
                            return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.get("of.options.animation.dynamic")));
                        }
                        case 2: {
                            return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                        }
                        default: {
                            return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOn()));
                        }
                    }
                }
                else {
                    if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.ANIMATED_FIRE) {
                        return this.ofAnimatedFire ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                    }
                    if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.ANIMATED_PORTAL) {
                        return this.ofAnimatedPortal ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                    }
                    if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.ANIMATED_REDSTONE) {
                        return this.ofAnimatedRedstone ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                    }
                    if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.ANIMATED_EXPLOSION) {
                        return this.ofAnimatedExplosion ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                    }
                    if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.ANIMATED_FLAME) {
                        return this.ofAnimatedFlame ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                    }
                    if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.ANIMATED_SMOKE) {
                        return this.ofAnimatedSmoke ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                    }
                    if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.VOID_PARTICLES) {
                        return this.ofVoidParticles ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                    }
                    if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.WATER_PARTICLES) {
                        return this.ofWaterParticles ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                    }
                    if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.PORTAL_PARTICLES) {
                        return this.ofPortalParticles ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                    }
                    if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.POTION_PARTICLES) {
                        return this.ofPotionParticles ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                    }
                    if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.FIREWORK_PARTICLES) {
                        return this.ofFireworkParticles ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                    }
                    if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.DRIPPING_WATER_LAVA) {
                        return this.ofDrippingWaterLava ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                    }
                    if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.ANIMATED_TERRAIN) {
                        return this.ofAnimatedTerrain ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                    }
                    if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.ANIMATED_TEXTURES) {
                        return this.ofAnimatedTextures ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                    }
                    if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.RAIN_SPLASH) {
                        return this.ofRainSplash ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                    }
                    if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.LAGOMETER) {
                        return this.ofLagometer ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                    }
                    if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.SHOW_FPS) {
                        return this.ofShowFps ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                    }
                    if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.AUTOSAVE_TICKS) {
                        return (this.ofAutoSaveTicks <= 40) ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.get("of.options.save.default"))) : ((this.ofAutoSaveTicks <= 400) ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.get("of.options.save.20s"))) : ((this.ofAutoSaveTicks <= 4000) ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.get("of.options.save.3min"))) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.get("of.options.save.30min")))));
                    }
                    if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.BETTER_GRASS) {
                        switch (this.ofBetterGrass) {
                            case 1: {
                                return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getFast()));
                            }
                            case 2: {
                                return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getFancy()));
                            }
                            default: {
                                return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                            }
                        }
                    }
                    else if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.CONNECTED_TEXTURES) {
                        switch (this.ofConnectedTextures) {
                            case 1: {
                                return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getFast()));
                            }
                            case 2: {
                                return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getFancy()));
                            }
                            default: {
                                return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                            }
                        }
                    }
                    else {
                        if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.WEATHER) {
                            return this.ofWeather ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                        }
                        if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.SKY) {
                            return this.ofSky ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                        }
                        if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.STARS) {
                            return this.ofStars ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                        }
                        if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.SUN_MOON) {
                            return this.ofSunMoon ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                        }
                        if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.VIGNETTE) {
                            switch (this.ofVignette) {
                                case 1: {
                                    return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getFast()));
                                }
                                case 2: {
                                    return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getFancy()));
                                }
                                default: {
                                    return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getDefault()));
                                }
                            }
                        }
                        else {
                            if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.CHUNK_UPDATES) {
                                return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(this.ofChunkUpdates));
                            }
                            if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.CHUNK_UPDATES_DYNAMIC) {
                                return this.ofChunkUpdatesDynamic ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                            }
                            if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.TIME) {
                                return (this.ofTime == 1) ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.get("of.options.time.dayOnly"))) : ((this.ofTime == 2) ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.get("of.options.time.nightOnly"))) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getDefault())));
                            }
                            if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.CLEAR_WATER) {
                                return this.ofClearWater ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                            }
                            if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.AA_LEVEL) {
                                String lllllllllllllllIlIIIIIIIIIlIIlIl = "";
                                if (this.ofAaLevel != Config.getAntialiasingLevel()) {
                                    lllllllllllllllIlIIIIIIIIIlIIlIl = String.valueOf(new StringBuilder(" (").append(Lang.get("of.general.restart")).append(")"));
                                }
                                return (this.ofAaLevel == 0) ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()).append(lllllllllllllllIlIIIIIIIIIlIIlIl)) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(this.ofAaLevel).append(lllllllllllllllIlIIIIIIIIIlIIlIl));
                            }
                            if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.AF_LEVEL) {
                                return (this.ofAfLevel == 1) ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(this.ofAfLevel));
                            }
                            if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.PROFILER) {
                                return this.ofProfiler ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                            }
                            if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.BETTER_SNOW) {
                                return this.ofBetterSnow ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                            }
                            if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.SWAMP_COLORS) {
                                return this.ofSwampColors ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                            }
                            if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.RANDOM_MOBS) {
                                return this.ofRandomMobs ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                            }
                            if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.SMOOTH_BIOMES) {
                                return this.ofSmoothBiomes ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                            }
                            if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.CUSTOM_FONTS) {
                                return this.ofCustomFonts ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                            }
                            if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.CUSTOM_COLORS) {
                                return this.ofCustomColors ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                            }
                            if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.CUSTOM_SKY) {
                                return this.ofCustomSky ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                            }
                            if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.SHOW_CAPES) {
                                return this.ofShowCapes ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                            }
                            if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.CUSTOM_ITEMS) {
                                return this.ofCustomItems ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                            }
                            if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.NATURAL_TEXTURES) {
                                return this.ofNaturalTextures ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                            }
                            if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.FAST_MATH) {
                                return this.ofFastMath ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                            }
                            if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.FAST_RENDER) {
                                return this.ofFastRender ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                            }
                            if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.TRANSLUCENT_BLOCKS) {
                                return (this.ofTranslucentBlocks == 1) ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getFast())) : ((this.ofTranslucentBlocks == 2) ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getFancy())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getDefault())));
                            }
                            if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.LAZY_CHUNK_LOADING) {
                                return this.ofLazyChunkLoading ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                            }
                            if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.DYNAMIC_FOV) {
                                return this.ofDynamicFov ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                            }
                            if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.DYNAMIC_LIGHTS) {
                                final int lllllllllllllllIlIIIIIIIIIlIlIlI = indexOf(this.ofDynamicLights, GameSettings.OF_DYNAMIC_LIGHTS);
                                return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(getTranslation(GameSettings.KEYS_DYNAMIC_LIGHTS, lllllllllllllllIlIIIIIIIIIlIlIlI)));
                            }
                            if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.FULLSCREEN_MODE) {
                                return this.ofFullscreenMode.equals("Default") ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getDefault())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(this.ofFullscreenMode));
                            }
                            if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.HELD_ITEM_TOOLTIPS) {
                                return this.heldItemTooltips ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.getOff()));
                            }
                            if (lllllllllllllllIlIIIIIIIIIlIllIl == Options.FRAMERATE_LIMIT) {
                                final float lllllllllllllllIlIIIIIIIIIlIIlII = this.getOptionFloatValue(lllllllllllllllIlIIIIIIIIIlIllIl);
                                return (lllllllllllllllIlIIIIIIIIIlIIlII == 0.0f) ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(Lang.get("of.options.framerateLimit.vsync"))) : ((lllllllllllllllIlIIIIIIIIIlIIlII == lllllllllllllllIlIIIIIIIIIlIllIl.valueMax) ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append(I18n.format("options.framerateLimit.max", new Object[0]))) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIIIlIllII)).append((int)lllllllllllllllIlIIIIIIIIIlIIlII).append(" fps")));
                            }
                            return null;
                        }
                    }
                }
            }
        }
    }
    
    public void loadOptions() {
        try {
            if (!this.optionsFile.exists()) {
                return;
            }
            final BufferedReader lllllllllllllllIlIIIIIIIlIlllllI = new BufferedReader(new FileReader(this.optionsFile));
            String lllllllllllllllIlIIIIIIIlIllllIl = "";
            this.mapSoundLevels.clear();
            while ((lllllllllllllllIlIIIIIIIlIllllIl = lllllllllllllllIlIIIIIIIlIlllllI.readLine()) != null) {
                try {
                    final String[] lllllllllllllllIlIIIIIIIlIllllII = lllllllllllllllIlIIIIIIIlIllllIl.split(":");
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("mouseSensitivity")) {
                        this.mouseSensitivity = this.parseFloat(lllllllllllllllIlIIIIIIIlIllllII[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("fov")) {
                        this.fovSetting = this.parseFloat(lllllllllllllllIlIIIIIIIlIllllII[1]) * 40.0f + 70.0f;
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("gamma")) {
                        this.gammaSetting = this.parseFloat(lllllllllllllllIlIIIIIIIlIllllII[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("saturation")) {
                        this.saturation = this.parseFloat(lllllllllllllllIlIIIIIIIlIllllII[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("invertYMouse")) {
                        this.invertMouse = lllllllllllllllIlIIIIIIIlIllllII[1].equals("true");
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("renderDistance")) {
                        this.renderDistanceChunks = Integer.parseInt(lllllllllllllllIlIIIIIIIlIllllII[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("guiScale")) {
                        this.guiScale = Integer.parseInt(lllllllllllllllIlIIIIIIIlIllllII[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("particles")) {
                        this.particleSetting = Integer.parseInt(lllllllllllllllIlIIIIIIIlIllllII[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("bobView")) {
                        this.viewBobbing = lllllllllllllllIlIIIIIIIlIllllII[1].equals("true");
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("anaglyph3d")) {
                        this.anaglyph = lllllllllllllllIlIIIIIIIlIllllII[1].equals("true");
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("maxFps")) {
                        this.limitFramerate = Integer.parseInt(lllllllllllllllIlIIIIIIIlIllllII[1]);
                        this.enableVsync = false;
                        if (this.limitFramerate <= 0) {
                            this.limitFramerate = (int)Options.FRAMERATE_LIMIT.getValueMax();
                            this.enableVsync = true;
                        }
                        this.updateVSync();
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("fboEnable")) {
                        this.fboEnable = lllllllllllllllIlIIIIIIIlIllllII[1].equals("true");
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("difficulty")) {
                        this.difficulty = EnumDifficulty.getDifficultyEnum(Integer.parseInt(lllllllllllllllIlIIIIIIIlIllllII[1]));
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("fancyGraphics")) {
                        this.fancyGraphics = lllllllllllllllIlIIIIIIIlIllllII[1].equals("true");
                        this.updateRenderClouds();
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("ao")) {
                        if (lllllllllllllllIlIIIIIIIlIllllII[1].equals("true")) {
                            this.ambientOcclusion = 2;
                        }
                        else if (lllllllllllllllIlIIIIIIIlIllllII[1].equals("false")) {
                            this.ambientOcclusion = 0;
                        }
                        else {
                            this.ambientOcclusion = Integer.parseInt(lllllllllllllllIlIIIIIIIlIllllII[1]);
                        }
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("renderClouds")) {
                        this.clouds = lllllllllllllllIlIIIIIIIlIllllII[1].equals("true");
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("resourcePacks")) {
                        this.resourcePacks = (List)GameSettings.gson.fromJson(lllllllllllllllIlIIIIIIIlIllllIl.substring(lllllllllllllllIlIIIIIIIlIllllIl.indexOf(58) + 1), (Type)GameSettings.typeListString);
                        if (this.resourcePacks == null) {
                            this.resourcePacks = Lists.newArrayList();
                        }
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("lastServer") && lllllllllllllllIlIIIIIIIlIllllII.length >= 2) {
                        this.lastServer = lllllllllllllllIlIIIIIIIlIllllIl.substring(lllllllllllllllIlIIIIIIIlIllllIl.indexOf(58) + 1);
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("lang") && lllllllllllllllIlIIIIIIIlIllllII.length >= 2) {
                        this.language = lllllllllllllllIlIIIIIIIlIllllII[1];
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("chatVisibility")) {
                        this.chatVisibility = EntityPlayer.EnumChatVisibility.getEnumChatVisibility(Integer.parseInt(lllllllllllllllIlIIIIIIIlIllllII[1]));
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("chatColors")) {
                        this.chatColours = lllllllllllllllIlIIIIIIIlIllllII[1].equals("true");
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("chatLinks")) {
                        this.chatLinks = lllllllllllllllIlIIIIIIIlIllllII[1].equals("true");
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("chatLinksPrompt")) {
                        this.chatLinksPrompt = lllllllllllllllIlIIIIIIIlIllllII[1].equals("true");
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("chatOpacity")) {
                        this.chatOpacity = this.parseFloat(lllllllllllllllIlIIIIIIIlIllllII[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("snooperEnabled")) {
                        this.snooperEnabled = lllllllllllllllIlIIIIIIIlIllllII[1].equals("true");
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("fullscreen")) {
                        this.fullScreen = lllllllllllllllIlIIIIIIIlIllllII[1].equals("true");
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("enableVsync")) {
                        this.enableVsync = lllllllllllllllIlIIIIIIIlIllllII[1].equals("true");
                        this.updateVSync();
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("useVbo")) {
                        this.field_178881_t = lllllllllllllllIlIIIIIIIlIllllII[1].equals("true");
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("hideServerAddress")) {
                        this.hideServerAddress = lllllllllllllllIlIIIIIIIlIllllII[1].equals("true");
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("advancedItemTooltips")) {
                        this.advancedItemTooltips = lllllllllllllllIlIIIIIIIlIllllII[1].equals("true");
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("pauseOnLostFocus")) {
                        this.pauseOnLostFocus = lllllllllllllllIlIIIIIIIlIllllII[1].equals("true");
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("touchscreen")) {
                        this.touchscreen = lllllllllllllllIlIIIIIIIlIllllII[1].equals("true");
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("overrideHeight")) {
                        this.overrideHeight = Integer.parseInt(lllllllllllllllIlIIIIIIIlIllllII[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("overrideWidth")) {
                        this.overrideWidth = Integer.parseInt(lllllllllllllllIlIIIIIIIlIllllII[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("heldItemTooltips")) {
                        this.heldItemTooltips = lllllllllllllllIlIIIIIIIlIllllII[1].equals("true");
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("chatHeightFocused")) {
                        this.chatHeightFocused = this.parseFloat(lllllllllllllllIlIIIIIIIlIllllII[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("chatHeightUnfocused")) {
                        this.chatHeightUnfocused = this.parseFloat(lllllllllllllllIlIIIIIIIlIllllII[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("chatScale")) {
                        this.chatScale = this.parseFloat(lllllllllllllllIlIIIIIIIlIllllII[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("chatWidth")) {
                        this.chatWidth = this.parseFloat(lllllllllllllllIlIIIIIIIlIllllII[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("showInventoryAchievementHint")) {
                        this.showInventoryAchievementHint = lllllllllllllllIlIIIIIIIlIllllII[1].equals("true");
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("mipmapLevels")) {
                        this.mipmapLevels = Integer.parseInt(lllllllllllllllIlIIIIIIIlIllllII[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("streamBytesPerPixel")) {
                        this.streamBytesPerPixel = this.parseFloat(lllllllllllllllIlIIIIIIIlIllllII[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("streamMicVolume")) {
                        this.streamMicVolume = this.parseFloat(lllllllllllllllIlIIIIIIIlIllllII[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("streamSystemVolume")) {
                        this.streamGameVolume = this.parseFloat(lllllllllllllllIlIIIIIIIlIllllII[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("streamKbps")) {
                        this.streamKbps = this.parseFloat(lllllllllllllllIlIIIIIIIlIllllII[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("streamFps")) {
                        this.streamFps = this.parseFloat(lllllllllllllllIlIIIIIIIlIllllII[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("streamCompression")) {
                        this.streamCompression = Integer.parseInt(lllllllllllllllIlIIIIIIIlIllllII[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("streamSendMetadata")) {
                        this.streamSendMetadata = lllllllllllllllIlIIIIIIIlIllllII[1].equals("true");
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("streamPreferredServer") && lllllllllllllllIlIIIIIIIlIllllII.length >= 2) {
                        this.streamPreferredServer = lllllllllllllllIlIIIIIIIlIllllIl.substring(lllllllllllllllIlIIIIIIIlIllllIl.indexOf(58) + 1);
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("streamChatEnabled")) {
                        this.streamChatEnabled = Integer.parseInt(lllllllllllllllIlIIIIIIIlIllllII[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("streamChatUserFilter")) {
                        this.streamChatUserFilter = Integer.parseInt(lllllllllllllllIlIIIIIIIlIllllII[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("streamMicToggleBehavior")) {
                        this.streamMicToggleBehavior = Integer.parseInt(lllllllllllllllIlIIIIIIIlIllllII[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("forceUnicodeFont")) {
                        this.forceUnicodeFont = lllllllllllllllIlIIIIIIIlIllllII[1].equals("true");
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("allowBlockAlternatives")) {
                        this.field_178880_u = lllllllllllllllIlIIIIIIIlIllllII[1].equals("true");
                    }
                    if (lllllllllllllllIlIIIIIIIlIllllII[0].equals("reducedDebugInfo")) {
                        this.field_178879_v = lllllllllllllllIlIIIIIIIlIllllII[1].equals("true");
                    }
                    for (final KeyBinding lllllllllllllllIlIIIIIIIlIlllIII : this.keyBindings) {
                        if (lllllllllllllllIlIIIIIIIlIllllII[0].equals(String.valueOf(new StringBuilder("key_").append(lllllllllllllllIlIIIIIIIlIlllIII.getKeyDescription())))) {
                            lllllllllllllllIlIIIIIIIlIlllIII.setKeyCode(Integer.parseInt(lllllllllllllllIlIIIIIIIlIllllII[1]));
                        }
                    }
                    for (final SoundCategory lllllllllllllllIlIIIIIIIlIllIllI : SoundCategory.values()) {
                        if (lllllllllllllllIlIIIIIIIlIllllII[0].equals(String.valueOf(new StringBuilder("soundCategory_").append(lllllllllllllllIlIIIIIIIlIllIllI.getCategoryName())))) {
                            this.mapSoundLevels.put(lllllllllllllllIlIIIIIIIlIllIllI, this.parseFloat(lllllllllllllllIlIIIIIIIlIllllII[1]));
                        }
                    }
                    for (final EnumPlayerModelParts lllllllllllllllIlIIIIIIIlIllIlII : EnumPlayerModelParts.values()) {
                        if (lllllllllllllllIlIIIIIIIlIllllII[0].equals(String.valueOf(new StringBuilder("modelPart_").append(lllllllllllllllIlIIIIIIIlIllIlII.func_179329_c())))) {
                            this.func_178878_a(lllllllllllllllIlIIIIIIIlIllIlII, lllllllllllllllIlIIIIIIIlIllllII[1].equals("true"));
                        }
                    }
                }
                catch (Exception lllllllllllllllIlIIIIIIIlIllIIll) {
                    GameSettings.logger.warn(String.valueOf(new StringBuilder("Skipping bad option: ").append(lllllllllllllllIlIIIIIIIlIllllIl)));
                    lllllllllllllllIlIIIIIIIlIllIIll.printStackTrace();
                }
            }
            KeyBinding.resetKeyBindingArrayAndHash();
            lllllllllllllllIlIIIIIIIlIlllllI.close();
        }
        catch (Exception lllllllllllllllIlIIIIIIIlIllIIlI) {
            GameSettings.logger.error("Failed to load options", (Throwable)lllllllllllllllIlIIIIIIIlIllIIlI);
        }
        this.loadOfOptions();
    }
    
    private void updateRenderClouds() {
        switch (this.ofClouds) {
            default: {
                this.clouds = true;
                break;
            }
            case 3: {
                this.clouds = false;
                break;
            }
        }
    }
    
    private void setOptionValueOF(final Options lllllllllllllllIlIIIIIIIIIlllllI, final int lllllllllllllllIlIIIIIIIIIllllIl) {
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.FOG_FANCY) {
            switch (this.ofFogType) {
                case 1: {
                    this.ofFogType = 2;
                    if (!Config.isFancyFogAvailable()) {
                        this.ofFogType = 3;
                        break;
                    }
                    break;
                }
                case 2: {
                    this.ofFogType = 3;
                    break;
                }
                case 3: {
                    this.ofFogType = 1;
                    break;
                }
                default: {
                    this.ofFogType = 1;
                    break;
                }
            }
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.FOG_START) {
            this.ofFogStart += 0.2f;
            if (this.ofFogStart > 0.81f) {
                this.ofFogStart = 0.2f;
            }
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.SMOOTH_FPS) {
            this.ofSmoothFps = !this.ofSmoothFps;
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.SMOOTH_WORLD) {
            this.ofSmoothWorld = !this.ofSmoothWorld;
            Config.updateThreadPriorities();
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.CLOUDS) {
            ++this.ofClouds;
            if (this.ofClouds > 3) {
                this.ofClouds = 0;
            }
            this.updateRenderClouds();
            this.mc.renderGlobal.resetClouds();
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.TREES) {
            this.ofTrees = nextValue(this.ofTrees, GameSettings.OF_TREES_VALUES);
            this.mc.renderGlobal.loadRenderers();
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.DROPPED_ITEMS) {
            ++this.ofDroppedItems;
            if (this.ofDroppedItems > 2) {
                this.ofDroppedItems = 0;
            }
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.RAIN) {
            ++this.ofRain;
            if (this.ofRain > 3) {
                this.ofRain = 0;
            }
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.ANIMATED_WATER) {
            ++this.ofAnimatedWater;
            if (this.ofAnimatedWater == 1) {
                ++this.ofAnimatedWater;
            }
            if (this.ofAnimatedWater > 2) {
                this.ofAnimatedWater = 0;
            }
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.ANIMATED_LAVA) {
            ++this.ofAnimatedLava;
            if (this.ofAnimatedLava == 1) {
                ++this.ofAnimatedLava;
            }
            if (this.ofAnimatedLava > 2) {
                this.ofAnimatedLava = 0;
            }
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.ANIMATED_FIRE) {
            this.ofAnimatedFire = !this.ofAnimatedFire;
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.ANIMATED_PORTAL) {
            this.ofAnimatedPortal = !this.ofAnimatedPortal;
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.ANIMATED_REDSTONE) {
            this.ofAnimatedRedstone = !this.ofAnimatedRedstone;
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.ANIMATED_EXPLOSION) {
            this.ofAnimatedExplosion = !this.ofAnimatedExplosion;
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.ANIMATED_FLAME) {
            this.ofAnimatedFlame = !this.ofAnimatedFlame;
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.ANIMATED_SMOKE) {
            this.ofAnimatedSmoke = !this.ofAnimatedSmoke;
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.VOID_PARTICLES) {
            this.ofVoidParticles = !this.ofVoidParticles;
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.WATER_PARTICLES) {
            this.ofWaterParticles = !this.ofWaterParticles;
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.PORTAL_PARTICLES) {
            this.ofPortalParticles = !this.ofPortalParticles;
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.POTION_PARTICLES) {
            this.ofPotionParticles = !this.ofPotionParticles;
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.FIREWORK_PARTICLES) {
            this.ofFireworkParticles = !this.ofFireworkParticles;
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.DRIPPING_WATER_LAVA) {
            this.ofDrippingWaterLava = !this.ofDrippingWaterLava;
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.ANIMATED_TERRAIN) {
            this.ofAnimatedTerrain = !this.ofAnimatedTerrain;
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.ANIMATED_TEXTURES) {
            this.ofAnimatedTextures = !this.ofAnimatedTextures;
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.RAIN_SPLASH) {
            this.ofRainSplash = !this.ofRainSplash;
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.LAGOMETER) {
            this.ofLagometer = !this.ofLagometer;
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.SHOW_FPS) {
            this.ofShowFps = !this.ofShowFps;
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.AUTOSAVE_TICKS) {
            this.ofAutoSaveTicks *= 10;
            if (this.ofAutoSaveTicks > 40000) {
                this.ofAutoSaveTicks = 40;
            }
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.BETTER_GRASS) {
            ++this.ofBetterGrass;
            if (this.ofBetterGrass > 3) {
                this.ofBetterGrass = 1;
            }
            this.mc.renderGlobal.loadRenderers();
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.CONNECTED_TEXTURES) {
            ++this.ofConnectedTextures;
            if (this.ofConnectedTextures > 3) {
                this.ofConnectedTextures = 1;
            }
            if (this.ofConnectedTextures != 2) {
                this.mc.refreshResources();
            }
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.WEATHER) {
            this.ofWeather = !this.ofWeather;
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.SKY) {
            this.ofSky = !this.ofSky;
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.STARS) {
            this.ofStars = !this.ofStars;
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.SUN_MOON) {
            this.ofSunMoon = !this.ofSunMoon;
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.VIGNETTE) {
            ++this.ofVignette;
            if (this.ofVignette > 2) {
                this.ofVignette = 0;
            }
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.CHUNK_UPDATES) {
            ++this.ofChunkUpdates;
            if (this.ofChunkUpdates > 5) {
                this.ofChunkUpdates = 1;
            }
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.CHUNK_UPDATES_DYNAMIC) {
            this.ofChunkUpdatesDynamic = !this.ofChunkUpdatesDynamic;
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.TIME) {
            ++this.ofTime;
            if (this.ofTime > 2) {
                this.ofTime = 0;
            }
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.CLEAR_WATER) {
            this.ofClearWater = !this.ofClearWater;
            this.updateWaterOpacity();
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.PROFILER) {
            this.ofProfiler = !this.ofProfiler;
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.BETTER_SNOW) {
            this.ofBetterSnow = !this.ofBetterSnow;
            this.mc.renderGlobal.loadRenderers();
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.SWAMP_COLORS) {
            this.ofSwampColors = !this.ofSwampColors;
            CustomColors.updateUseDefaultGrassFoliageColors();
            this.mc.renderGlobal.loadRenderers();
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.RANDOM_MOBS) {
            this.ofRandomMobs = !this.ofRandomMobs;
            RandomMobs.resetTextures();
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.SMOOTH_BIOMES) {
            this.ofSmoothBiomes = !this.ofSmoothBiomes;
            CustomColors.updateUseDefaultGrassFoliageColors();
            this.mc.renderGlobal.loadRenderers();
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.CUSTOM_FONTS) {
            this.ofCustomFonts = !this.ofCustomFonts;
            this.mc.fontRendererObj.onResourceManagerReload(Config.getResourceManager());
            this.mc.standardGalacticFontRenderer.onResourceManagerReload(Config.getResourceManager());
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.CUSTOM_COLORS) {
            this.ofCustomColors = !this.ofCustomColors;
            CustomColors.update();
            this.mc.renderGlobal.loadRenderers();
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.CUSTOM_ITEMS) {
            this.ofCustomItems = !this.ofCustomItems;
            this.mc.refreshResources();
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.CUSTOM_SKY) {
            this.ofCustomSky = !this.ofCustomSky;
            CustomSky.update();
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.SHOW_CAPES) {
            this.ofShowCapes = !this.ofShowCapes;
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.NATURAL_TEXTURES) {
            this.ofNaturalTextures = !this.ofNaturalTextures;
            NaturalTextures.update();
            this.mc.renderGlobal.loadRenderers();
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.FAST_MATH) {
            this.ofFastMath = !this.ofFastMath;
            MathHelper.fastMath = this.ofFastMath;
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.FAST_RENDER) {
            if (!this.ofFastRender && Config.isShaders()) {
                Config.showGuiMessage(Lang.get("of.message.fr.shaders1"), Lang.get("of.message.fr.shaders2"));
                return;
            }
            this.ofFastRender = !this.ofFastRender;
            if (this.ofFastRender) {
                this.mc.entityRenderer.stopUseShader();
            }
            Config.updateFramebufferSize();
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.TRANSLUCENT_BLOCKS) {
            if (this.ofTranslucentBlocks == 0) {
                this.ofTranslucentBlocks = 1;
            }
            else if (this.ofTranslucentBlocks == 1) {
                this.ofTranslucentBlocks = 2;
            }
            else if (this.ofTranslucentBlocks == 2) {
                this.ofTranslucentBlocks = 0;
            }
            else {
                this.ofTranslucentBlocks = 0;
            }
            this.mc.renderGlobal.loadRenderers();
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.LAZY_CHUNK_LOADING) {
            this.ofLazyChunkLoading = !this.ofLazyChunkLoading;
            Config.updateAvailableProcessors();
            if (!Config.isSingleProcessor()) {
                this.ofLazyChunkLoading = false;
            }
            this.mc.renderGlobal.loadRenderers();
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.FULLSCREEN_MODE) {
            final List lllllllllllllllIlIIIIIIIIIllllII = Arrays.asList(Config.getFullscreenModes());
            if (this.ofFullscreenMode.equals("Default")) {
                this.ofFullscreenMode = lllllllllllllllIlIIIIIIIIIllllII.get(0);
            }
            else {
                int lllllllllllllllIlIIIIIIIIIlllIll = lllllllllllllllIlIIIIIIIIIllllII.indexOf(this.ofFullscreenMode);
                if (lllllllllllllllIlIIIIIIIIIlllIll < 0) {
                    this.ofFullscreenMode = "Default";
                }
                else if (++lllllllllllllllIlIIIIIIIIIlllIll >= lllllllllllllllIlIIIIIIIIIllllII.size()) {
                    this.ofFullscreenMode = "Default";
                }
                else {
                    this.ofFullscreenMode = lllllllllllllllIlIIIIIIIIIllllII.get(lllllllllllllllIlIIIIIIIIIlllIll);
                }
            }
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.DYNAMIC_FOV) {
            this.ofDynamicFov = !this.ofDynamicFov;
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.DYNAMIC_LIGHTS) {
            this.ofDynamicLights = nextValue(this.ofDynamicLights, GameSettings.OF_DYNAMIC_LIGHTS);
            DynamicLights.removeLights(this.mc.renderGlobal);
        }
        if (lllllllllllllllIlIIIIIIIIIlllllI == Options.HELD_ITEM_TOOLTIPS) {
            this.heldItemTooltips = !this.heldItemTooltips;
        }
    }
    
    public void setOptionKeyBinding(final KeyBinding lllllllllllllllIlIIIIIIlIIIllIlI, final int lllllllllllllllIlIIIIIIlIIIllIIl) {
        lllllllllllllllIlIIIIIIlIIIllIlI.setKeyCode(lllllllllllllllIlIIIIIIlIIIllIIl);
        this.saveOptions();
    }
    
    public String getKeyBinding(final Options lllllllllllllllIlIIIIIIIllIIlllI) {
        final String lllllllllllllllIlIIIIIIIllIlIlIl = this.getKeyBindingOF(lllllllllllllllIlIIIIIIIllIIlllI);
        if (lllllllllllllllIlIIIIIIIllIlIlIl != null) {
            return lllllllllllllllIlIIIIIIIllIlIlIl;
        }
        final String lllllllllllllllIlIIIIIIIllIlIlII = String.valueOf(new StringBuilder(String.valueOf(I18n.format(lllllllllllllllIlIIIIIIIllIIlllI.getEnumString(), new Object[0]))).append(": "));
        if (lllllllllllllllIlIIIIIIIllIIlllI.getEnumFloat()) {
            final float lllllllllllllllIlIIIIIIIllIlIIll = this.getOptionFloatValue(lllllllllllllllIlIIIIIIIllIIlllI);
            final float lllllllllllllllIlIIIIIIIllIlIIlI = lllllllllllllllIlIIIIIIIllIIlllI.normalizeValue(lllllllllllllllIlIIIIIIIllIlIIll);
            return (lllllllllllllllIlIIIIIIIllIIlllI == Options.SENSITIVITY) ? ((lllllllllllllllIlIIIIIIIllIlIIlI == 0.0f) ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIllIlIlII)).append(I18n.format("options.sensitivity.min", new Object[0]))) : ((lllllllllllllllIlIIIIIIIllIlIIlI == 1.0f) ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIllIlIlII)).append(I18n.format("options.sensitivity.max", new Object[0]))) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIllIlIlII)).append((int)(lllllllllllllllIlIIIIIIIllIlIIlI * 200.0f)).append("%")))) : ((lllllllllllllllIlIIIIIIIllIIlllI == Options.FOV) ? ((lllllllllllllllIlIIIIIIIllIlIIll == 70.0f) ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIllIlIlII)).append(I18n.format("options.fov.min", new Object[0]))) : ((lllllllllllllllIlIIIIIIIllIlIIll == 110.0f) ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIllIlIlII)).append(I18n.format("options.fov.max", new Object[0]))) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIllIlIlII)).append((int)lllllllllllllllIlIIIIIIIllIlIIll)))) : ((lllllllllllllllIlIIIIIIIllIIlllI == Options.FRAMERATE_LIMIT) ? ((lllllllllllllllIlIIIIIIIllIlIIll == lllllllllllllllIlIIIIIIIllIIlllI.valueMax) ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIllIlIlII)).append(I18n.format("options.framerateLimit.max", new Object[0]))) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIllIlIlII)).append((int)lllllllllllllllIlIIIIIIIllIlIIll).append(" fps"))) : ((lllllllllllllllIlIIIIIIIllIIlllI == Options.RENDER_CLOUDS) ? ((lllllllllllllllIlIIIIIIIllIlIIll == lllllllllllllllIlIIIIIIIllIIlllI.valueMin) ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIllIlIlII)).append(I18n.format("options.cloudHeight.min", new Object[0]))) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIllIlIlII)).append((int)lllllllllllllllIlIIIIIIIllIlIIll + 128))) : ((lllllllllllllllIlIIIIIIIllIIlllI == Options.GAMMA) ? ((lllllllllllllllIlIIIIIIIllIlIIlI == 0.0f) ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIllIlIlII)).append(I18n.format("options.gamma.min", new Object[0]))) : ((lllllllllllllllIlIIIIIIIllIlIIlI == 1.0f) ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIllIlIlII)).append(I18n.format("options.gamma.max", new Object[0]))) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIllIlIlII)).append("+").append((int)(lllllllllllllllIlIIIIIIIllIlIIlI * 100.0f)).append("%")))) : ((lllllllllllllllIlIIIIIIIllIIlllI == Options.SATURATION) ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIllIlIlII)).append((int)(lllllllllllllllIlIIIIIIIllIlIIlI * 400.0f)).append("%")) : ((lllllllllllllllIlIIIIIIIllIIlllI == Options.CHAT_OPACITY) ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIllIlIlII)).append((int)(lllllllllllllllIlIIIIIIIllIlIIlI * 90.0f + 10.0f)).append("%")) : ((lllllllllllllllIlIIIIIIIllIIlllI == Options.CHAT_HEIGHT_UNFOCUSED) ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIllIlIlII)).append(GuiNewChat.calculateChatboxHeight(lllllllllllllllIlIIIIIIIllIlIIlI)).append("px")) : ((lllllllllllllllIlIIIIIIIllIIlllI == Options.CHAT_HEIGHT_FOCUSED) ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIllIlIlII)).append(GuiNewChat.calculateChatboxHeight(lllllllllllllllIlIIIIIIIllIlIIlI)).append("px")) : ((lllllllllllllllIlIIIIIIIllIIlllI == Options.CHAT_WIDTH) ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIllIlIlII)).append(GuiNewChat.calculateChatboxWidth(lllllllllllllllIlIIIIIIIllIlIIlI)).append("px")) : ((lllllllllllllllIlIIIIIIIllIIlllI == Options.RENDER_DISTANCE) ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIllIlIlII)).append((int)lllllllllllllllIlIIIIIIIllIlIIll).append(" chunks")) : ((lllllllllllllllIlIIIIIIIllIIlllI == Options.MIPMAP_LEVELS) ? ((lllllllllllllllIlIIIIIIIllIlIIll == 0.0f) ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIllIlIlII)).append(I18n.format("options.off", new Object[0]))) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIllIlIlII)).append((int)lllllllllllllllIlIIIIIIIllIlIIll))) : ((lllllllllllllllIlIIIIIIIllIIlllI == Options.STREAM_FPS) ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIllIlIlII)).append(TwitchStream.func_152948_a(lllllllllllllllIlIIIIIIIllIlIIlI)).append(" fps")) : ((lllllllllllllllIlIIIIIIIllIIlllI == Options.STREAM_KBPS) ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIllIlIlII)).append(TwitchStream.func_152946_b(lllllllllllllllIlIIIIIIIllIlIIlI)).append(" Kbps")) : ((lllllllllllllllIlIIIIIIIllIIlllI == Options.STREAM_BYTES_PER_PIXEL) ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIllIlIlII)).append(String.format("%.3f bpp", TwitchStream.func_152947_c(lllllllllllllllIlIIIIIIIllIlIIlI)))) : ((lllllllllllllllIlIIIIIIIllIlIIlI == 0.0f) ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIllIlIlII)).append(I18n.format("options.off", new Object[0]))) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIllIlIlII)).append((int)(lllllllllllllllIlIIIIIIIllIlIIlI * 100.0f)).append("%")))))))))))))))));
        }
        if (lllllllllllllllIlIIIIIIIllIIlllI.getEnumBoolean()) {
            final boolean lllllllllllllllIlIIIIIIIllIlIIIl = this.getOptionOrdinalValue(lllllllllllllllIlIIIIIIIllIIlllI);
            return lllllllllllllllIlIIIIIIIllIlIIIl ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIllIlIlII)).append(I18n.format("options.on", new Object[0]))) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIllIlIlII)).append(I18n.format("options.off", new Object[0])));
        }
        if (lllllllllllllllIlIIIIIIIllIIlllI == Options.GUI_SCALE) {
            return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIllIlIlII)).append(getTranslation(GameSettings.GUISCALES, this.guiScale)));
        }
        if (lllllllllllllllIlIIIIIIIllIIlllI == Options.CHAT_VISIBILITY) {
            return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIllIlIlII)).append(I18n.format(this.chatVisibility.getResourceKey(), new Object[0])));
        }
        if (lllllllllllllllIlIIIIIIIllIIlllI == Options.PARTICLES) {
            return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIllIlIlII)).append(getTranslation(GameSettings.PARTICLES, this.particleSetting)));
        }
        if (lllllllllllllllIlIIIIIIIllIIlllI == Options.AMBIENT_OCCLUSION) {
            return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIllIlIlII)).append(getTranslation(GameSettings.AMBIENT_OCCLUSIONS, this.ambientOcclusion)));
        }
        if (lllllllllllllllIlIIIIIIIllIIlllI == Options.STREAM_COMPRESSION) {
            return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIllIlIlII)).append(getTranslation(GameSettings.STREAM_COMPRESSIONS, this.streamCompression)));
        }
        if (lllllllllllllllIlIIIIIIIllIIlllI == Options.STREAM_CHAT_ENABLED) {
            return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIllIlIlII)).append(getTranslation(GameSettings.STREAM_CHAT_MODES, this.streamChatEnabled)));
        }
        if (lllllllllllllllIlIIIIIIIllIIlllI == Options.STREAM_CHAT_USER_FILTER) {
            return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIllIlIlII)).append(getTranslation(GameSettings.STREAM_CHAT_FILTER_MODES, this.streamChatUserFilter)));
        }
        if (lllllllllllllllIlIIIIIIIllIIlllI == Options.STREAM_MIC_TOGGLE_BEHAVIOR) {
            return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIllIlIlII)).append(getTranslation(GameSettings.STREAM_MIC_MODES, this.streamMicToggleBehavior)));
        }
        if (lllllllllllllllIlIIIIIIIllIIlllI != Options.GRAPHICS) {
            return lllllllllllllllIlIIIIIIIllIlIlII;
        }
        if (this.fancyGraphics) {
            return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIllIlIlII)).append(I18n.format("options.graphics.fancy", new Object[0])));
        }
        final String lllllllllllllllIlIIIIIIIllIlIIII = "options.graphics.fast";
        return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIIIIllIlIlII)).append(I18n.format("options.graphics.fast", new Object[0])));
    }
    
    public GameSettings(final Minecraft lllllllllllllllIlIIIIIIlIIlIllII, final File lllllllllllllllIlIIIIIIlIIlIlIll) {
        this.mouseSensitivity = 0.5f;
        this.renderDistanceChunks = -1;
        this.viewBobbing = true;
        this.fboEnable = true;
        this.limitFramerate = 120;
        this.clouds = true;
        this.fancyGraphics = true;
        this.ambientOcclusion = 2;
        this.resourcePacks = Lists.newArrayList();
        this.ofFogType = 1;
        this.ofFogStart = 0.8f;
        this.ofMipmapType = 0;
        this.ofOcclusionFancy = false;
        this.ofSmoothFps = false;
        this.ofSmoothWorld = Config.isSingleProcessor();
        this.ofLazyChunkLoading = Config.isSingleProcessor();
        this.ofAoLevel = 1.0f;
        this.ofAaLevel = 0;
        this.ofAfLevel = 1;
        this.ofClouds = 0;
        this.ofCloudsHeight = 0.0f;
        this.ofTrees = 0;
        this.ofRain = 0;
        this.ofDroppedItems = 0;
        this.ofBetterGrass = 3;
        this.ofAutoSaveTicks = 4000;
        this.ofLagometer = false;
        this.ofProfiler = false;
        this.ofShowFps = false;
        this.ofWeather = true;
        this.ofSky = true;
        this.ofStars = true;
        this.ofSunMoon = true;
        this.ofVignette = 0;
        this.ofChunkUpdates = 1;
        this.ofChunkUpdatesDynamic = false;
        this.ofTime = 0;
        this.ofClearWater = false;
        this.ofBetterSnow = false;
        this.ofFullscreenMode = "Default";
        this.ofSwampColors = true;
        this.ofRandomMobs = true;
        this.ofSmoothBiomes = true;
        this.ofCustomFonts = true;
        this.ofCustomColors = true;
        this.ofCustomSky = true;
        this.ofShowCapes = true;
        this.ofConnectedTextures = 2;
        this.ofCustomItems = true;
        this.ofNaturalTextures = false;
        this.ofFastMath = false;
        this.ofFastRender = true;
        this.ofTranslucentBlocks = 0;
        this.ofDynamicFov = true;
        this.ofDynamicLights = 3;
        this.ofAnimatedWater = 0;
        this.ofAnimatedLava = 0;
        this.ofAnimatedFire = true;
        this.ofAnimatedPortal = true;
        this.ofAnimatedRedstone = true;
        this.ofAnimatedExplosion = true;
        this.ofAnimatedFlame = true;
        this.ofAnimatedSmoke = true;
        this.ofVoidParticles = true;
        this.ofWaterParticles = true;
        this.ofRainSplash = true;
        this.ofPortalParticles = true;
        this.ofPotionParticles = true;
        this.ofFireworkParticles = true;
        this.ofDrippingWaterLava = true;
        this.ofAnimatedTerrain = true;
        this.ofAnimatedTextures = true;
        this.chatVisibility = EntityPlayer.EnumChatVisibility.FULL;
        this.chatColours = true;
        this.chatLinks = true;
        this.chatLinksPrompt = true;
        this.chatOpacity = 1.0f;
        this.snooperEnabled = true;
        this.enableVsync = true;
        this.field_178881_t = false;
        this.field_178880_u = true;
        this.field_178879_v = false;
        this.pauseOnLostFocus = true;
        this.field_178882_aU = Sets.newHashSet((Object[])EnumPlayerModelParts.values());
        this.heldItemTooltips = true;
        this.chatScale = 1.0f;
        this.chatWidth = 1.0f;
        this.chatHeightUnfocused = 0.44366196f;
        this.chatHeightFocused = 1.0f;
        this.showInventoryAchievementHint = true;
        this.mipmapLevels = 4;
        this.mapSoundLevels = Maps.newEnumMap((Class)SoundCategory.class);
        this.streamBytesPerPixel = 0.5f;
        this.streamMicVolume = 1.0f;
        this.streamGameVolume = 1.0f;
        this.streamKbps = 0.5412844f;
        this.streamFps = 0.31690142f;
        this.streamCompression = 1;
        this.streamSendMetadata = true;
        this.streamPreferredServer = "";
        this.streamChatEnabled = 0;
        this.streamChatUserFilter = 0;
        this.streamMicToggleBehavior = 0;
        this.keyBindForward = new KeyBinding("key.forward", 17, "key.categories.movement");
        this.keyBindLeft = new KeyBinding("key.left", 30, "key.categories.movement");
        this.keyBindBack = new KeyBinding("key.back", 31, "key.categories.movement");
        this.keyBindRight = new KeyBinding("key.right", 32, "key.categories.movement");
        this.keyBindJump = new KeyBinding("key.jump", 57, "key.categories.movement");
        this.keyBindSneak = new KeyBinding("key.sneak", 42, "key.categories.movement");
        this.keyBindInventory = new KeyBinding("key.inventory", 18, "key.categories.inventory");
        this.keyBindUseItem = new KeyBinding("key.use", -99, "key.categories.gameplay");
        this.keyBindDrop = new KeyBinding("key.drop", 16, "key.categories.gameplay");
        this.keyBindAttack = new KeyBinding("key.attack", -100, "key.categories.gameplay");
        this.keyBindPickBlock = new KeyBinding("key.pickItem", -98, "key.categories.gameplay");
        this.keyBindSprint = new KeyBinding("key.sprint", 29, "key.categories.gameplay");
        this.keyBindChat = new KeyBinding("key.chat", 20, "key.categories.multiplayer");
        this.keyBindPlayerList = new KeyBinding("key.playerlist", 15, "key.categories.multiplayer");
        this.keyBindCommand = new KeyBinding("key.command", 53, "key.categories.multiplayer");
        this.keyBindScreenshot = new KeyBinding("key.screenshot", 60, "key.categories.misc");
        this.keyBindTogglePerspective = new KeyBinding("key.togglePerspective", 63, "key.categories.misc");
        this.keyBindSmoothCamera = new KeyBinding("key.smoothCamera", 0, "key.categories.misc");
        this.keyBindFullscreen = new KeyBinding("key.fullscreen", 87, "key.categories.misc");
        this.field_178883_an = new KeyBinding("key.spectatorOutlines", 0, "key.categories.misc");
        this.keyBindStreamStartStop = new KeyBinding("key.streamStartStop", 64, "key.categories.stream");
        this.keyBindStreamPauseUnpause = new KeyBinding("key.streamPauseUnpause", 65, "key.categories.stream");
        this.keyBindStreamCommercials = new KeyBinding("key.streamCommercial", 0, "key.categories.stream");
        this.keyBindStreamToggleMic = new KeyBinding("key.streamToggleMic", 0, "key.categories.stream");
        this.keyBindsHotbar = new KeyBinding[] { new KeyBinding("key.hotbar.1", 2, "key.categories.inventory"), new KeyBinding("key.hotbar.2", 3, "key.categories.inventory"), new KeyBinding("key.hotbar.3", 4, "key.categories.inventory"), new KeyBinding("key.hotbar.4", 5, "key.categories.inventory"), new KeyBinding("key.hotbar.5", 6, "key.categories.inventory"), new KeyBinding("key.hotbar.6", 7, "key.categories.inventory"), new KeyBinding("key.hotbar.7", 8, "key.categories.inventory"), new KeyBinding("key.hotbar.8", 9, "key.categories.inventory"), new KeyBinding("key.hotbar.9", 10, "key.categories.inventory") };
        this.keyBindings = (KeyBinding[])ArrayUtils.addAll((Object[])new KeyBinding[] { this.keyBindAttack, this.keyBindUseItem, this.keyBindForward, this.keyBindLeft, this.keyBindBack, this.keyBindRight, this.keyBindJump, this.keyBindSneak, this.keyBindDrop, this.keyBindInventory, this.keyBindChat, this.keyBindPlayerList, this.keyBindPickBlock, this.keyBindCommand, this.keyBindScreenshot, this.keyBindTogglePerspective, this.keyBindSmoothCamera, this.keyBindSprint, this.keyBindStreamStartStop, this.keyBindStreamPauseUnpause, this.keyBindStreamCommercials, this.keyBindStreamToggleMic, this.keyBindFullscreen, this.field_178883_an }, (Object[])this.keyBindsHotbar);
        this.difficulty = EnumDifficulty.NORMAL;
        this.lastServer = "";
        this.fovSetting = 70.0f;
        this.language = "en_US";
        this.forceUnicodeFont = false;
        this.mc = lllllllllllllllIlIIIIIIlIIlIllII;
        this.optionsFile = new File(lllllllllllllllIlIIIIIIlIIlIlIll, "options.txt");
        this.optionsFileOF = new File(lllllllllllllllIlIIIIIIlIIlIlIll, "optionsof.txt");
        this.limitFramerate = (int)Options.FRAMERATE_LIMIT.getValueMax();
        this.ofKeyBindZoom = new KeyBinding("of.key.zoom", 46, "key.categories.misc");
        this.keyBindings = (KeyBinding[])ArrayUtils.add((Object[])this.keyBindings, (Object)this.ofKeyBindZoom);
        Options.RENDER_DISTANCE.setValueMax(32.0f);
        this.renderDistanceChunks = 8;
        this.loadOptions();
        Config.initGameSettings(this);
    }
    
    public void resetSettings() {
        this.renderDistanceChunks = 8;
        this.viewBobbing = true;
        this.anaglyph = false;
        this.limitFramerate = (int)Options.FRAMERATE_LIMIT.getValueMax();
        this.enableVsync = false;
        this.updateVSync();
        this.mipmapLevels = 4;
        this.fancyGraphics = true;
        this.ambientOcclusion = 2;
        this.clouds = true;
        this.fovSetting = 70.0f;
        this.gammaSetting = 0.0f;
        this.guiScale = 0;
        this.particleSetting = 0;
        this.heldItemTooltips = true;
        this.field_178881_t = false;
        this.field_178880_u = true;
        this.forceUnicodeFont = false;
        this.ofFogType = 1;
        this.ofFogStart = 0.8f;
        this.ofMipmapType = 0;
        this.ofOcclusionFancy = false;
        this.ofSmoothFps = false;
        Config.updateAvailableProcessors();
        this.ofSmoothWorld = Config.isSingleProcessor();
        this.ofLazyChunkLoading = Config.isSingleProcessor();
        this.ofFastMath = false;
        this.ofFastRender = false;
        this.ofTranslucentBlocks = 0;
        this.ofDynamicFov = true;
        this.ofDynamicLights = 3;
        this.ofAoLevel = 1.0f;
        this.ofAaLevel = 0;
        this.ofAfLevel = 1;
        this.ofClouds = 0;
        this.ofCloudsHeight = 0.0f;
        this.ofTrees = 0;
        this.ofRain = 0;
        this.ofBetterGrass = 3;
        this.ofAutoSaveTicks = 4000;
        this.ofLagometer = false;
        this.ofShowFps = false;
        this.ofProfiler = false;
        this.ofWeather = true;
        this.ofSky = true;
        this.ofStars = true;
        this.ofSunMoon = true;
        this.ofVignette = 0;
        this.ofChunkUpdates = 1;
        this.ofChunkUpdatesDynamic = false;
        this.ofTime = 0;
        this.ofClearWater = false;
        this.ofBetterSnow = false;
        this.ofFullscreenMode = "Default";
        this.ofSwampColors = true;
        this.ofRandomMobs = true;
        this.ofSmoothBiomes = true;
        this.ofCustomFonts = true;
        this.ofCustomColors = true;
        this.ofCustomItems = true;
        this.ofCustomSky = true;
        this.ofShowCapes = true;
        this.ofConnectedTextures = 2;
        this.ofNaturalTextures = false;
        this.ofAnimatedWater = 0;
        this.ofAnimatedLava = 0;
        this.ofAnimatedFire = true;
        this.ofAnimatedPortal = true;
        this.ofAnimatedRedstone = true;
        this.ofAnimatedExplosion = true;
        this.ofAnimatedFlame = true;
        this.ofAnimatedSmoke = true;
        this.ofVoidParticles = true;
        this.ofWaterParticles = true;
        this.ofRainSplash = true;
        this.ofPortalParticles = true;
        this.ofPotionParticles = true;
        this.ofFireworkParticles = true;
        this.ofDrippingWaterLava = true;
        this.ofAnimatedTerrain = true;
        this.ofAnimatedTextures = true;
        Shaders.setShaderPack(Shaders.packNameNone);
        Shaders.configAntialiasingLevel = 0;
        Shaders.uninit();
        Shaders.storeConfig();
        this.updateWaterOpacity();
        this.mc.refreshResources();
        this.saveOptions();
    }
    
    public void saveOptions() {
        if (Reflector.FMLClientHandler.exists()) {
            final Object lllllllllllllllIlIIIIIIIlIIllIlI = Reflector.call(Reflector.FMLClientHandler_instance, new Object[0]);
            if (lllllllllllllllIlIIIIIIIlIIllIlI != null && Reflector.callBoolean(lllllllllllllllIlIIIIIIIlIIllIlI, Reflector.FMLClientHandler_isLoading, new Object[0])) {
                return;
            }
        }
        try {
            final PrintWriter lllllllllllllllIlIIIIIIIlIIllIIl = new PrintWriter(new FileWriter(this.optionsFile));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("invertYMouse:").append(this.invertMouse)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("mouseSensitivity:").append(this.mouseSensitivity)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("fov:").append((this.fovSetting - 70.0f) / 40.0f)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("gamma:").append(this.gammaSetting)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("saturation:").append(this.saturation)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("renderDistance:").append(this.renderDistanceChunks)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("guiScale:").append(this.guiScale)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("particles:").append(this.particleSetting)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("bobView:").append(this.viewBobbing)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("anaglyph3d:").append(this.anaglyph)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("maxFps:").append(this.limitFramerate)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("fboEnable:").append(this.fboEnable)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("difficulty:").append(this.difficulty.getDifficultyId())));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("fancyGraphics:").append(this.fancyGraphics)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("ao:").append(this.ambientOcclusion)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("renderClouds:").append(this.clouds)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("resourcePacks:").append(GameSettings.gson.toJson((Object)this.resourcePacks))));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("lastServer:").append(this.lastServer)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("lang:").append(this.language)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("chatVisibility:").append(this.chatVisibility.getChatVisibility())));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("chatColors:").append(this.chatColours)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("chatLinks:").append(this.chatLinks)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("chatLinksPrompt:").append(this.chatLinksPrompt)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("chatOpacity:").append(this.chatOpacity)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("snooperEnabled:").append(this.snooperEnabled)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("fullscreen:").append(this.fullScreen)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("enableVsync:").append(this.enableVsync)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("useVbo:").append(this.field_178881_t)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("hideServerAddress:").append(this.hideServerAddress)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("advancedItemTooltips:").append(this.advancedItemTooltips)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("pauseOnLostFocus:").append(this.pauseOnLostFocus)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("touchscreen:").append(this.touchscreen)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("overrideWidth:").append(this.overrideWidth)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("overrideHeight:").append(this.overrideHeight)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("heldItemTooltips:").append(this.heldItemTooltips)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("chatHeightFocused:").append(this.chatHeightFocused)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("chatHeightUnfocused:").append(this.chatHeightUnfocused)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("chatScale:").append(this.chatScale)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("chatWidth:").append(this.chatWidth)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("showInventoryAchievementHint:").append(this.showInventoryAchievementHint)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("mipmapLevels:").append(this.mipmapLevels)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("streamBytesPerPixel:").append(this.streamBytesPerPixel)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("streamMicVolume:").append(this.streamMicVolume)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("streamSystemVolume:").append(this.streamGameVolume)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("streamKbps:").append(this.streamKbps)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("streamFps:").append(this.streamFps)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("streamCompression:").append(this.streamCompression)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("streamSendMetadata:").append(this.streamSendMetadata)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("streamPreferredServer:").append(this.streamPreferredServer)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("streamChatEnabled:").append(this.streamChatEnabled)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("streamChatUserFilter:").append(this.streamChatUserFilter)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("streamMicToggleBehavior:").append(this.streamMicToggleBehavior)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("forceUnicodeFont:").append(this.forceUnicodeFont)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("allowBlockAlternatives:").append(this.field_178880_u)));
            lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("reducedDebugInfo:").append(this.field_178879_v)));
            for (final KeyBinding lllllllllllllllIlIIIIIIIlIIlIlIl : this.keyBindings) {
                lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("key_").append(lllllllllllllllIlIIIIIIIlIIlIlIl.getKeyDescription()).append(":").append(lllllllllllllllIlIIIIIIIlIIlIlIl.getKeyCode())));
            }
            for (final SoundCategory lllllllllllllllIlIIIIIIIlIIlIIll : SoundCategory.values()) {
                lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("soundCategory_").append(lllllllllllllllIlIIIIIIIlIIlIIll.getCategoryName()).append(":").append(this.getSoundLevel(lllllllllllllllIlIIIIIIIlIIlIIll))));
            }
            for (final EnumPlayerModelParts lllllllllllllllIlIIIIIIIlIIlIIIl : EnumPlayerModelParts.values()) {
                lllllllllllllllIlIIIIIIIlIIllIIl.println(String.valueOf(new StringBuilder("modelPart_").append(lllllllllllllllIlIIIIIIIlIIlIIIl.func_179329_c()).append(":").append(this.field_178882_aU.contains(lllllllllllllllIlIIIIIIIlIIlIIIl))));
            }
            lllllllllllllllIlIIIIIIIlIIllIIl.close();
        }
        catch (Exception lllllllllllllllIlIIIIIIIlIIlIIII) {
            GameSettings.logger.error("Failed to save options", (Throwable)lllllllllllllllIlIIIIIIIlIIlIIII);
        }
        this.saveOfOptions();
        this.sendSettingsToServer();
    }
    
    private static int nextValue(final int lllllllllllllllIIllllllllllIlIII, final int[] lllllllllllllllIIllllllllllIIlll) {
        int lllllllllllllllIIllllllllllIlIIl = indexOf(lllllllllllllllIIllllllllllIlIII, lllllllllllllllIIllllllllllIIlll);
        if (lllllllllllllllIIllllllllllIlIIl < 0) {
            return lllllllllllllllIIllllllllllIIlll[0];
        }
        if (++lllllllllllllllIIllllllllllIlIIl >= lllllllllllllllIIllllllllllIIlll.length) {
            lllllllllllllllIIllllllllllIlIIl = 0;
        }
        return lllllllllllllllIIllllllllllIIlll[lllllllllllllllIIllllllllllIlIIl];
    }
    
    public boolean getOptionOrdinalValue(final Options lllllllllllllllIlIIIIIIIlllIIllI) {
        switch (SwitchOptions.optionIds[lllllllllllllllIlIIIIIIIlllIIllI.ordinal()]) {
            case 1: {
                return this.invertMouse;
            }
            case 2: {
                return this.viewBobbing;
            }
            case 3: {
                return this.anaglyph;
            }
            case 4: {
                return this.fboEnable;
            }
            case 5: {
                return this.clouds;
            }
            case 6: {
                return this.chatColours;
            }
            case 7: {
                return this.chatLinks;
            }
            case 8: {
                return this.chatLinksPrompt;
            }
            case 9: {
                return this.snooperEnabled;
            }
            case 10: {
                return this.fullScreen;
            }
            case 11: {
                return this.enableVsync;
            }
            case 12: {
                return this.field_178881_t;
            }
            case 13: {
                return this.touchscreen;
            }
            case 14: {
                return this.streamSendMetadata;
            }
            case 15: {
                return this.forceUnicodeFont;
            }
            case 16: {
                return this.field_178880_u;
            }
            case 17: {
                return this.field_178879_v;
            }
            default: {
                return false;
            }
        }
    }
    
    public void sendSettingsToServer() {
        if (this.mc.thePlayer != null) {
            int lllllllllllllllIlIIIIIIIIlllIIll = 0;
            for (final EnumPlayerModelParts lllllllllllllllIlIIIIIIIIlllIIlI : this.field_178882_aU) {
                lllllllllllllllIlIIIIIIIIlllIIll |= lllllllllllllllIlIIIIIIIIlllIIlI.func_179327_a();
            }
            this.mc.thePlayer.sendQueue.addToSendQueue(new C15PacketClientSettings(this.language, this.renderDistanceChunks, this.chatVisibility, this.chatColours, lllllllllllllllIlIIIIIIIIlllIIll));
        }
    }
    
    private static int limit(final int lllllllllllllllIIllllllllllIIIlI, final int[] lllllllllllllllIIllllllllllIIIIl) {
        final int lllllllllllllllIIllllllllllIIIII = indexOf(lllllllllllllllIIllllllllllIIIlI, lllllllllllllllIIllllllllllIIIIl);
        return (lllllllllllllllIIllllllllllIIIII < 0) ? lllllllllllllllIIllllllllllIIIIl[0] : lllllllllllllllIIllllllllllIIIlI;
    }
    
    private void setOptionFloatValueOF(final Options lllllllllllllllIlIIIIIIIIlIIlIII, final float lllllllllllllllIlIIIIIIIIlIIIlll) {
        if (lllllllllllllllIlIIIIIIIIlIIlIII == Options.CLOUD_HEIGHT) {
            this.ofCloudsHeight = lllllllllllllllIlIIIIIIIIlIIIlll;
            this.mc.renderGlobal.resetClouds();
        }
        if (lllllllllllllllIlIIIIIIIIlIIlIII == Options.AO_LEVEL) {
            this.ofAoLevel = lllllllllllllllIlIIIIIIIIlIIIlll;
            this.mc.renderGlobal.loadRenderers();
        }
        if (lllllllllllllllIlIIIIIIIIlIIlIII == Options.AA_LEVEL) {
            final int lllllllllllllllIlIIIIIIIIlIIlllI = (int)lllllllllllllllIlIIIIIIIIlIIIlll;
            if (lllllllllllllllIlIIIIIIIIlIIlllI > 0 && Config.isShaders()) {
                Config.showGuiMessage(Lang.get("of.message.aa.shaders1"), Lang.get("of.message.aa.shaders2"));
                return;
            }
            final int[] lllllllllllllllIlIIIIIIIIlIIlIll = { 0, 2, 4, 6, 8, 12, 16 };
            this.ofAaLevel = 0;
            for (int lllllllllllllllIlIIIIIIIIlIIlIlI = 0; lllllllllllllllIlIIIIIIIIlIIlIlI < lllllllllllllllIlIIIIIIIIlIIlIll.length; ++lllllllllllllllIlIIIIIIIIlIIlIlI) {
                if (lllllllllllllllIlIIIIIIIIlIIlllI >= lllllllllllllllIlIIIIIIIIlIIlIll[lllllllllllllllIlIIIIIIIIlIIlIlI]) {
                    this.ofAaLevel = lllllllllllllllIlIIIIIIIIlIIlIll[lllllllllllllllIlIIIIIIIIlIIlIlI];
                }
            }
            this.ofAaLevel = Config.limit(this.ofAaLevel, 0, 16);
        }
        if (lllllllllllllllIlIIIIIIIIlIIlIII == Options.AF_LEVEL) {
            final int lllllllllllllllIlIIIIIIIIlIIllIl = (int)lllllllllllllllIlIIIIIIIIlIIIlll;
            if (lllllllllllllllIlIIIIIIIIlIIllIl > 1 && Config.isShaders()) {
                Config.showGuiMessage(Lang.get("of.message.af.shaders1"), Lang.get("of.message.af.shaders2"));
                return;
            }
            this.ofAfLevel = 1;
            while (this.ofAfLevel * 2 <= lllllllllllllllIlIIIIIIIIlIIllIl) {
                this.ofAfLevel *= 2;
            }
            this.ofAfLevel = Config.limit(this.ofAfLevel, 1, 16);
            this.mc.refreshResources();
        }
        if (lllllllllllllllIlIIIIIIIIlIIlIII == Options.MIPMAP_TYPE) {
            final int lllllllllllllllIlIIIIIIIIlIIllII = (int)lllllllllllllllIlIIIIIIIIlIIIlll;
            this.ofMipmapType = Config.limit(lllllllllllllllIlIIIIIIIIlIIllII, 0, 3);
            this.mc.refreshResources();
        }
    }
    
    public void setOptionValue(final Options lllllllllllllllIlIIIIIIIllllIIIl, final int lllllllllllllllIlIIIIIIIllllIIII) {
        this.setOptionValueOF(lllllllllllllllIlIIIIIIIllllIIIl, lllllllllllllllIlIIIIIIIllllIIII);
        if (lllllllllllllllIlIIIIIIIllllIIIl == Options.INVERT_MOUSE) {
            this.invertMouse = !this.invertMouse;
        }
        if (lllllllllllllllIlIIIIIIIllllIIIl == Options.GUI_SCALE) {
            this.guiScale = (this.guiScale + lllllllllllllllIlIIIIIIIllllIIII & 0x3);
        }
        if (lllllllllllllllIlIIIIIIIllllIIIl == Options.PARTICLES) {
            this.particleSetting = (this.particleSetting + lllllllllllllllIlIIIIIIIllllIIII) % 3;
        }
        if (lllllllllllllllIlIIIIIIIllllIIIl == Options.VIEW_BOBBING) {
            this.viewBobbing = !this.viewBobbing;
        }
        if (lllllllllllllllIlIIIIIIIllllIIIl == Options.RENDER_CLOUDS) {
            this.clouds = !this.clouds;
        }
        if (lllllllllllllllIlIIIIIIIllllIIIl == Options.FORCE_UNICODE_FONT) {
            this.forceUnicodeFont = !this.forceUnicodeFont;
            this.mc.fontRendererObj.setUnicodeFlag(this.mc.getLanguageManager().isCurrentLocaleUnicode() || this.forceUnicodeFont);
        }
        if (lllllllllllllllIlIIIIIIIllllIIIl == Options.FBO_ENABLE) {
            this.fboEnable = !this.fboEnable;
        }
        if (lllllllllllllllIlIIIIIIIllllIIIl == Options.ANAGLYPH) {
            this.anaglyph = !this.anaglyph;
            this.mc.refreshResources();
        }
        if (lllllllllllllllIlIIIIIIIllllIIIl == Options.GRAPHICS) {
            this.fancyGraphics = !this.fancyGraphics;
            this.updateRenderClouds();
            this.mc.renderGlobal.loadRenderers();
        }
        if (lllllllllllllllIlIIIIIIIllllIIIl == Options.AMBIENT_OCCLUSION) {
            this.ambientOcclusion = (this.ambientOcclusion + lllllllllllllllIlIIIIIIIllllIIII) % 3;
            this.mc.renderGlobal.loadRenderers();
        }
        if (lllllllllllllllIlIIIIIIIllllIIIl == Options.CHAT_VISIBILITY) {
            this.chatVisibility = EntityPlayer.EnumChatVisibility.getEnumChatVisibility((this.chatVisibility.getChatVisibility() + lllllllllllllllIlIIIIIIIllllIIII) % 3);
        }
        if (lllllllllllllllIlIIIIIIIllllIIIl == Options.STREAM_COMPRESSION) {
            this.streamCompression = (this.streamCompression + lllllllllllllllIlIIIIIIIllllIIII) % 3;
        }
        if (lllllllllllllllIlIIIIIIIllllIIIl == Options.STREAM_SEND_METADATA) {
            this.streamSendMetadata = !this.streamSendMetadata;
        }
        if (lllllllllllllllIlIIIIIIIllllIIIl == Options.STREAM_CHAT_ENABLED) {
            this.streamChatEnabled = (this.streamChatEnabled + lllllllllllllllIlIIIIIIIllllIIII) % 3;
        }
        if (lllllllllllllllIlIIIIIIIllllIIIl == Options.STREAM_CHAT_USER_FILTER) {
            this.streamChatUserFilter = (this.streamChatUserFilter + lllllllllllllllIlIIIIIIIllllIIII) % 3;
        }
        if (lllllllllllllllIlIIIIIIIllllIIIl == Options.STREAM_MIC_TOGGLE_BEHAVIOR) {
            this.streamMicToggleBehavior = (this.streamMicToggleBehavior + lllllllllllllllIlIIIIIIIllllIIII) % 2;
        }
        if (lllllllllllllllIlIIIIIIIllllIIIl == Options.CHAT_COLOR) {
            this.chatColours = !this.chatColours;
        }
        if (lllllllllllllllIlIIIIIIIllllIIIl == Options.CHAT_LINKS) {
            this.chatLinks = !this.chatLinks;
        }
        if (lllllllllllllllIlIIIIIIIllllIIIl == Options.CHAT_LINKS_PROMPT) {
            this.chatLinksPrompt = !this.chatLinksPrompt;
        }
        if (lllllllllllllllIlIIIIIIIllllIIIl == Options.SNOOPER_ENABLED) {
            this.snooperEnabled = !this.snooperEnabled;
        }
        if (lllllllllllllllIlIIIIIIIllllIIIl == Options.TOUCHSCREEN) {
            this.touchscreen = !this.touchscreen;
        }
        if (lllllllllllllllIlIIIIIIIllllIIIl == Options.USE_FULLSCREEN) {
            this.fullScreen = !this.fullScreen;
            if (this.mc.isFullScreen() != this.fullScreen) {
                this.mc.toggleFullscreen();
            }
        }
        if (lllllllllllllllIlIIIIIIIllllIIIl == Options.ENABLE_VSYNC) {
            this.enableVsync = !this.enableVsync;
            Display.setVSyncEnabled(this.enableVsync);
        }
        if (lllllllllllllllIlIIIIIIIllllIIIl == Options.USE_VBO) {
            this.field_178881_t = !this.field_178881_t;
            this.mc.renderGlobal.loadRenderers();
        }
        if (lllllllllllllllIlIIIIIIIllllIIIl == Options.BLOCK_ALTERNATIVES) {
            this.field_178880_u = !this.field_178880_u;
            this.mc.renderGlobal.loadRenderers();
        }
        if (lllllllllllllllIlIIIIIIIllllIIIl == Options.REDUCED_DEBUG_INFO) {
            this.field_178879_v = !this.field_178879_v;
        }
        this.saveOptions();
    }
    
    private void updateWaterOpacity() {
        if (this.mc.isIntegratedServerRunning() && this.mc.getIntegratedServer() != null) {
            Config.waterOpacityChanged = true;
        }
        ClearWater.updateWaterOpacity(this, this.mc.theWorld);
    }
    
    public Set func_178876_d() {
        return (Set)ImmutableSet.copyOf((Collection)this.field_178882_aU);
    }
    
    public GameSettings() {
        this.mouseSensitivity = 0.5f;
        this.renderDistanceChunks = -1;
        this.viewBobbing = true;
        this.fboEnable = true;
        this.limitFramerate = 120;
        this.clouds = true;
        this.fancyGraphics = true;
        this.ambientOcclusion = 2;
        this.resourcePacks = Lists.newArrayList();
        this.ofFogType = 1;
        this.ofFogStart = 0.8f;
        this.ofMipmapType = 0;
        this.ofOcclusionFancy = false;
        this.ofSmoothFps = false;
        this.ofSmoothWorld = Config.isSingleProcessor();
        this.ofLazyChunkLoading = Config.isSingleProcessor();
        this.ofAoLevel = 1.0f;
        this.ofAaLevel = 0;
        this.ofAfLevel = 1;
        this.ofClouds = 0;
        this.ofCloudsHeight = 0.0f;
        this.ofTrees = 0;
        this.ofRain = 0;
        this.ofDroppedItems = 0;
        this.ofBetterGrass = 3;
        this.ofAutoSaveTicks = 4000;
        this.ofLagometer = false;
        this.ofProfiler = false;
        this.ofShowFps = false;
        this.ofWeather = true;
        this.ofSky = true;
        this.ofStars = true;
        this.ofSunMoon = true;
        this.ofVignette = 0;
        this.ofChunkUpdates = 1;
        this.ofChunkUpdatesDynamic = false;
        this.ofTime = 0;
        this.ofClearWater = false;
        this.ofBetterSnow = false;
        this.ofFullscreenMode = "Default";
        this.ofSwampColors = true;
        this.ofRandomMobs = true;
        this.ofSmoothBiomes = true;
        this.ofCustomFonts = true;
        this.ofCustomColors = true;
        this.ofCustomSky = true;
        this.ofShowCapes = true;
        this.ofConnectedTextures = 2;
        this.ofCustomItems = true;
        this.ofNaturalTextures = false;
        this.ofFastMath = false;
        this.ofFastRender = true;
        this.ofTranslucentBlocks = 0;
        this.ofDynamicFov = true;
        this.ofDynamicLights = 3;
        this.ofAnimatedWater = 0;
        this.ofAnimatedLava = 0;
        this.ofAnimatedFire = true;
        this.ofAnimatedPortal = true;
        this.ofAnimatedRedstone = true;
        this.ofAnimatedExplosion = true;
        this.ofAnimatedFlame = true;
        this.ofAnimatedSmoke = true;
        this.ofVoidParticles = true;
        this.ofWaterParticles = true;
        this.ofRainSplash = true;
        this.ofPortalParticles = true;
        this.ofPotionParticles = true;
        this.ofFireworkParticles = true;
        this.ofDrippingWaterLava = true;
        this.ofAnimatedTerrain = true;
        this.ofAnimatedTextures = true;
        this.chatVisibility = EntityPlayer.EnumChatVisibility.FULL;
        this.chatColours = true;
        this.chatLinks = true;
        this.chatLinksPrompt = true;
        this.chatOpacity = 1.0f;
        this.snooperEnabled = true;
        this.enableVsync = true;
        this.field_178881_t = false;
        this.field_178880_u = true;
        this.field_178879_v = false;
        this.pauseOnLostFocus = true;
        this.field_178882_aU = Sets.newHashSet((Object[])EnumPlayerModelParts.values());
        this.heldItemTooltips = true;
        this.chatScale = 1.0f;
        this.chatWidth = 1.0f;
        this.chatHeightUnfocused = 0.44366196f;
        this.chatHeightFocused = 1.0f;
        this.showInventoryAchievementHint = true;
        this.mipmapLevels = 4;
        this.mapSoundLevels = Maps.newEnumMap((Class)SoundCategory.class);
        this.streamBytesPerPixel = 0.5f;
        this.streamMicVolume = 1.0f;
        this.streamGameVolume = 1.0f;
        this.streamKbps = 0.5412844f;
        this.streamFps = 0.31690142f;
        this.streamCompression = 1;
        this.streamSendMetadata = true;
        this.streamPreferredServer = "";
        this.streamChatEnabled = 0;
        this.streamChatUserFilter = 0;
        this.streamMicToggleBehavior = 0;
        this.keyBindForward = new KeyBinding("key.forward", 17, "key.categories.movement");
        this.keyBindLeft = new KeyBinding("key.left", 30, "key.categories.movement");
        this.keyBindBack = new KeyBinding("key.back", 31, "key.categories.movement");
        this.keyBindRight = new KeyBinding("key.right", 32, "key.categories.movement");
        this.keyBindJump = new KeyBinding("key.jump", 57, "key.categories.movement");
        this.keyBindSneak = new KeyBinding("key.sneak", 42, "key.categories.movement");
        this.keyBindInventory = new KeyBinding("key.inventory", 18, "key.categories.inventory");
        this.keyBindUseItem = new KeyBinding("key.use", -99, "key.categories.gameplay");
        this.keyBindDrop = new KeyBinding("key.drop", 16, "key.categories.gameplay");
        this.keyBindAttack = new KeyBinding("key.attack", -100, "key.categories.gameplay");
        this.keyBindPickBlock = new KeyBinding("key.pickItem", -98, "key.categories.gameplay");
        this.keyBindSprint = new KeyBinding("key.sprint", 29, "key.categories.gameplay");
        this.keyBindChat = new KeyBinding("key.chat", 20, "key.categories.multiplayer");
        this.keyBindPlayerList = new KeyBinding("key.playerlist", 15, "key.categories.multiplayer");
        this.keyBindCommand = new KeyBinding("key.command", 53, "key.categories.multiplayer");
        this.keyBindScreenshot = new KeyBinding("key.screenshot", 60, "key.categories.misc");
        this.keyBindTogglePerspective = new KeyBinding("key.togglePerspective", 63, "key.categories.misc");
        this.keyBindSmoothCamera = new KeyBinding("key.smoothCamera", 0, "key.categories.misc");
        this.keyBindFullscreen = new KeyBinding("key.fullscreen", 87, "key.categories.misc");
        this.field_178883_an = new KeyBinding("key.spectatorOutlines", 0, "key.categories.misc");
        this.keyBindStreamStartStop = new KeyBinding("key.streamStartStop", 64, "key.categories.stream");
        this.keyBindStreamPauseUnpause = new KeyBinding("key.streamPauseUnpause", 65, "key.categories.stream");
        this.keyBindStreamCommercials = new KeyBinding("key.streamCommercial", 0, "key.categories.stream");
        this.keyBindStreamToggleMic = new KeyBinding("key.streamToggleMic", 0, "key.categories.stream");
        this.keyBindsHotbar = new KeyBinding[] { new KeyBinding("key.hotbar.1", 2, "key.categories.inventory"), new KeyBinding("key.hotbar.2", 3, "key.categories.inventory"), new KeyBinding("key.hotbar.3", 4, "key.categories.inventory"), new KeyBinding("key.hotbar.4", 5, "key.categories.inventory"), new KeyBinding("key.hotbar.5", 6, "key.categories.inventory"), new KeyBinding("key.hotbar.6", 7, "key.categories.inventory"), new KeyBinding("key.hotbar.7", 8, "key.categories.inventory"), new KeyBinding("key.hotbar.8", 9, "key.categories.inventory"), new KeyBinding("key.hotbar.9", 10, "key.categories.inventory") };
        this.keyBindings = (KeyBinding[])ArrayUtils.addAll((Object[])new KeyBinding[] { this.keyBindAttack, this.keyBindUseItem, this.keyBindForward, this.keyBindLeft, this.keyBindBack, this.keyBindRight, this.keyBindJump, this.keyBindSneak, this.keyBindDrop, this.keyBindInventory, this.keyBindChat, this.keyBindPlayerList, this.keyBindPickBlock, this.keyBindCommand, this.keyBindScreenshot, this.keyBindTogglePerspective, this.keyBindSmoothCamera, this.keyBindSprint, this.keyBindStreamStartStop, this.keyBindStreamPauseUnpause, this.keyBindStreamCommercials, this.keyBindStreamToggleMic, this.keyBindFullscreen, this.field_178883_an }, (Object[])this.keyBindsHotbar);
        this.difficulty = EnumDifficulty.NORMAL;
        this.lastServer = "";
        this.fovSetting = 70.0f;
        this.language = "en_US";
        this.forceUnicodeFont = false;
    }
    
    public void func_178877_a(final EnumPlayerModelParts lllllllllllllllIlIIIIIIIIlIllIll) {
        if (!this.func_178876_d().contains(lllllllllllllllIlIIIIIIIIlIllIll)) {
            this.field_178882_aU.add(lllllllllllllllIlIIIIIIIIlIllIll);
        }
        else {
            this.field_178882_aU.remove(lllllllllllllllIlIIIIIIIIlIllIll);
        }
        this.sendSettingsToServer();
    }
    
    public void func_178878_a(final EnumPlayerModelParts lllllllllllllllIlIIIIIIIIllIIlIl, final boolean lllllllllllllllIlIIIIIIIIllIIlII) {
        if (lllllllllllllllIlIIIIIIIIllIIlII) {
            this.field_178882_aU.add(lllllllllllllllIlIIIIIIIIllIIlIl);
        }
        else {
            this.field_178882_aU.remove(lllllllllllllllIlIIIIIIIIllIIlIl);
        }
        this.sendSettingsToServer();
    }
    
    static {
        DEFAULT_STR = "Default";
        SMART = 4;
        FANCY = 2;
        __OBFID = "CL_00000650";
        DEFAULT = 0;
        OFF = 3;
        ANIM_GENERATED = 1;
        ANIM_OFF = 2;
        FAST = 1;
        ANIM_ON = 0;
        logger = LogManager.getLogger();
        gson = new Gson();
        typeListString = new ParameterizedType() {
            @Override
            public Type getOwnerType() {
                return null;
            }
            
            @Override
            public Type[] getActualTypeArguments() {
                return new Type[] { String.class };
            }
            
            @Override
            public Type getRawType() {
                return List.class;
            }
            
            static {
                __OBFID = "CL_00000651";
            }
        };
        GUISCALES = new String[] { "options.guiScale.auto", "options.guiScale.small", "options.guiScale.normal", "options.guiScale.large" };
        PARTICLES = new String[] { "options.particles.all", "options.particles.decreased", "options.particles.minimal" };
        AMBIENT_OCCLUSIONS = new String[] { "options.ao.off", "options.ao.min", "options.ao.max" };
        STREAM_COMPRESSIONS = new String[] { "options.stream.compression.low", "options.stream.compression.medium", "options.stream.compression.high" };
        STREAM_CHAT_MODES = new String[] { "options.stream.chat.enabled.streaming", "options.stream.chat.enabled.always", "options.stream.chat.enabled.never" };
        STREAM_CHAT_FILTER_MODES = new String[] { "options.stream.chat.userFilter.all", "options.stream.chat.userFilter.subs", "options.stream.chat.userFilter.mods" };
        STREAM_MIC_MODES = new String[] { "options.stream.mic_toggle.mute", "options.stream.mic_toggle.talk" };
        OF_TREES_VALUES = new int[] { 0, 1, 4, 2 };
        OF_DYNAMIC_LIGHTS = new int[] { 3, 1, 2 };
        KEYS_DYNAMIC_LIGHTS = new String[] { "options.off", "options.graphics.fast", "options.graphics.fancy" };
    }
    
    public void updateVSync() {
        Display.setVSyncEnabled(this.enableVsync);
    }
    
    public void loadOfOptions() {
        try {
            File lllllllllllllllIlIIIIIIIIIIlIlIl = this.optionsFileOF;
            if (!lllllllllllllllIlIIIIIIIIIIlIlIl.exists()) {
                lllllllllllllllIlIIIIIIIIIIlIlIl = this.optionsFile;
            }
            if (!lllllllllllllllIlIIIIIIIIIIlIlIl.exists()) {
                return;
            }
            final BufferedReader lllllllllllllllIlIIIIIIIIIIlIlII = new BufferedReader(new FileReader(lllllllllllllllIlIIIIIIIIIIlIlIl));
            String lllllllllllllllIlIIIIIIIIIIlIIll = "";
            while ((lllllllllllllllIlIIIIIIIIIIlIIll = lllllllllllllllIlIIIIIIIIIIlIlII.readLine()) != null) {
                try {
                    final String[] lllllllllllllllIlIIIIIIIIIIlIIlI = lllllllllllllllIlIIIIIIIIIIlIIll.split(":");
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofRenderDistanceChunks") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.renderDistanceChunks = Integer.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                        this.renderDistanceChunks = Config.limit(this.renderDistanceChunks, 2, 32);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofFogType") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofFogType = Integer.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                        this.ofFogType = Config.limit(this.ofFogType, 1, 3);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofFogStart") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofFogStart = Float.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                        if (this.ofFogStart < 0.2f) {
                            this.ofFogStart = 0.2f;
                        }
                        if (this.ofFogStart > 0.81f) {
                            this.ofFogStart = 0.8f;
                        }
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofMipmapType") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofMipmapType = Integer.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                        this.ofMipmapType = Config.limit(this.ofMipmapType, 0, 3);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofOcclusionFancy") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofOcclusionFancy = Boolean.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofSmoothFps") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofSmoothFps = Boolean.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofSmoothWorld") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofSmoothWorld = Boolean.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofAoLevel") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofAoLevel = Float.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                        this.ofAoLevel = Config.limit(this.ofAoLevel, 0.0f, 1.0f);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofClouds") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofClouds = Integer.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                        this.ofClouds = Config.limit(this.ofClouds, 0, 3);
                        this.updateRenderClouds();
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofCloudsHeight") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofCloudsHeight = Float.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                        this.ofCloudsHeight = Config.limit(this.ofCloudsHeight, 0.0f, 1.0f);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofTrees") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofTrees = Integer.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                        this.ofTrees = limit(this.ofTrees, GameSettings.OF_TREES_VALUES);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofDroppedItems") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofDroppedItems = Integer.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                        this.ofDroppedItems = Config.limit(this.ofDroppedItems, 0, 2);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofRain") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofRain = Integer.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                        this.ofRain = Config.limit(this.ofRain, 0, 3);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofAnimatedWater") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofAnimatedWater = Integer.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                        this.ofAnimatedWater = Config.limit(this.ofAnimatedWater, 0, 2);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofAnimatedLava") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofAnimatedLava = Integer.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                        this.ofAnimatedLava = Config.limit(this.ofAnimatedLava, 0, 2);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofAnimatedFire") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofAnimatedFire = Boolean.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofAnimatedPortal") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofAnimatedPortal = Boolean.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofAnimatedRedstone") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofAnimatedRedstone = Boolean.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofAnimatedExplosion") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofAnimatedExplosion = Boolean.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofAnimatedFlame") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofAnimatedFlame = Boolean.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofAnimatedSmoke") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofAnimatedSmoke = Boolean.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofVoidParticles") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofVoidParticles = Boolean.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofWaterParticles") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofWaterParticles = Boolean.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofPortalParticles") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofPortalParticles = Boolean.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofPotionParticles") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofPotionParticles = Boolean.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofFireworkParticles") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofFireworkParticles = Boolean.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofDrippingWaterLava") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofDrippingWaterLava = Boolean.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofAnimatedTerrain") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofAnimatedTerrain = Boolean.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofAnimatedTextures") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofAnimatedTextures = Boolean.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofRainSplash") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofRainSplash = Boolean.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofLagometer") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofLagometer = Boolean.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofShowFps") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofShowFps = Boolean.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofAutoSaveTicks") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofAutoSaveTicks = Integer.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                        this.ofAutoSaveTicks = Config.limit(this.ofAutoSaveTicks, 40, 40000);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofBetterGrass") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofBetterGrass = Integer.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                        this.ofBetterGrass = Config.limit(this.ofBetterGrass, 1, 3);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofConnectedTextures") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofConnectedTextures = Integer.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                        this.ofConnectedTextures = Config.limit(this.ofConnectedTextures, 1, 3);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofWeather") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofWeather = Boolean.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofSky") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofSky = Boolean.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofStars") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofStars = Boolean.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofSunMoon") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofSunMoon = Boolean.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofVignette") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofVignette = Integer.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                        this.ofVignette = Config.limit(this.ofVignette, 0, 2);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofChunkUpdates") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofChunkUpdates = Integer.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                        this.ofChunkUpdates = Config.limit(this.ofChunkUpdates, 1, 5);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofChunkUpdatesDynamic") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofChunkUpdatesDynamic = Boolean.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofTime") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofTime = Integer.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                        this.ofTime = Config.limit(this.ofTime, 0, 2);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofClearWater") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofClearWater = Boolean.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                        this.updateWaterOpacity();
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofAaLevel") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofAaLevel = Integer.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                        this.ofAaLevel = Config.limit(this.ofAaLevel, 0, 16);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofAfLevel") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofAfLevel = Integer.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                        this.ofAfLevel = Config.limit(this.ofAfLevel, 1, 16);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofProfiler") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofProfiler = Boolean.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofBetterSnow") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofBetterSnow = Boolean.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofSwampColors") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofSwampColors = Boolean.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofRandomMobs") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofRandomMobs = Boolean.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofSmoothBiomes") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofSmoothBiomes = Boolean.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofCustomFonts") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofCustomFonts = Boolean.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofCustomColors") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofCustomColors = Boolean.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofCustomItems") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofCustomItems = Boolean.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofCustomSky") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofCustomSky = Boolean.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofShowCapes") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofShowCapes = Boolean.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofNaturalTextures") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofNaturalTextures = Boolean.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofLazyChunkLoading") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofLazyChunkLoading = Boolean.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofDynamicFov") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofDynamicFov = Boolean.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofDynamicLights") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofDynamicLights = Integer.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                        this.ofDynamicLights = limit(this.ofDynamicLights, GameSettings.OF_DYNAMIC_LIGHTS);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofFullscreenMode") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofFullscreenMode = lllllllllllllllIlIIIIIIIIIIlIIlI[1];
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofFastMath") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofFastMath = Boolean.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                        MathHelper.fastMath = this.ofFastMath;
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofFastRender") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofFastRender = Boolean.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                    }
                    if (lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals("ofTranslucentBlocks") && lllllllllllllllIlIIIIIIIIIIlIIlI.length >= 2) {
                        this.ofTranslucentBlocks = Integer.valueOf(lllllllllllllllIlIIIIIIIIIIlIIlI[1]);
                        this.ofTranslucentBlocks = Config.limit(this.ofTranslucentBlocks, 0, 2);
                    }
                    if (!lllllllllllllllIlIIIIIIIIIIlIIlI[0].equals(String.valueOf(new StringBuilder("key_").append(this.ofKeyBindZoom.getKeyDescription())))) {
                        continue;
                    }
                    this.ofKeyBindZoom.setKeyCode(Integer.parseInt(lllllllllllllllIlIIIIIIIIIIlIIlI[1]));
                }
                catch (Exception lllllllllllllllIlIIIIIIIIIIlIIIl) {
                    Config.dbg(String.valueOf(new StringBuilder("Skipping bad option: ").append(lllllllllllllllIlIIIIIIIIIIlIIll)));
                    lllllllllllllllIlIIIIIIIIIIlIIIl.printStackTrace();
                }
            }
            KeyBinding.resetKeyBindingArrayAndHash();
            lllllllllllllllIlIIIIIIIIIIlIlII.close();
        }
        catch (Exception lllllllllllllllIlIIIIIIIIIIlIIII) {
            Config.warn("Failed to load options");
            lllllllllllllllIlIIIIIIIIIIlIIII.printStackTrace();
        }
    }
    
    public void setSoundLevel(final SoundCategory lllllllllllllllIlIIIIIIIIllllIlI, final float lllllllllllllllIlIIIIIIIIllllIIl) {
        this.mc.getSoundHandler().setSoundLevel(lllllllllllllllIlIIIIIIIIllllIlI, lllllllllllllllIlIIIIIIIIllllIIl);
        this.mapSoundLevels.put(lllllllllllllllIlIIIIIIIIllllIlI, lllllllllllllllIlIIIIIIIIllllIIl);
    }
    
    public float getOptionFloatValue(final Options lllllllllllllllIlIIIIIIIlllIllII) {
        return (lllllllllllllllIlIIIIIIIlllIllII == Options.CLOUD_HEIGHT) ? this.ofCloudsHeight : ((lllllllllllllllIlIIIIIIIlllIllII == Options.AO_LEVEL) ? this.ofAoLevel : ((lllllllllllllllIlIIIIIIIlllIllII == Options.AA_LEVEL) ? ((float)this.ofAaLevel) : ((lllllllllllllllIlIIIIIIIlllIllII == Options.AF_LEVEL) ? ((float)this.ofAfLevel) : ((lllllllllllllllIlIIIIIIIlllIllII == Options.MIPMAP_TYPE) ? ((float)this.ofMipmapType) : ((lllllllllllllllIlIIIIIIIlllIllII == Options.FRAMERATE_LIMIT) ? ((this.limitFramerate == Options.FRAMERATE_LIMIT.getValueMax() && this.enableVsync) ? 0.0f : ((float)this.limitFramerate)) : ((lllllllllllllllIlIIIIIIIlllIllII == Options.FOV) ? this.fovSetting : ((lllllllllllllllIlIIIIIIIlllIllII == Options.GAMMA) ? this.gammaSetting : ((lllllllllllllllIlIIIIIIIlllIllII == Options.SATURATION) ? this.saturation : ((lllllllllllllllIlIIIIIIIlllIllII == Options.SENSITIVITY) ? this.mouseSensitivity : ((lllllllllllllllIlIIIIIIIlllIllII == Options.CHAT_OPACITY) ? this.chatOpacity : ((lllllllllllllllIlIIIIIIIlllIllII == Options.CHAT_HEIGHT_FOCUSED) ? this.chatHeightFocused : ((lllllllllllllllIlIIIIIIIlllIllII == Options.CHAT_HEIGHT_UNFOCUSED) ? this.chatHeightUnfocused : ((lllllllllllllllIlIIIIIIIlllIllII == Options.CHAT_SCALE) ? this.chatScale : ((lllllllllllllllIlIIIIIIIlllIllII == Options.CHAT_WIDTH) ? this.chatWidth : ((lllllllllllllllIlIIIIIIIlllIllII == Options.FRAMERATE_LIMIT) ? ((float)this.limitFramerate) : ((lllllllllllllllIlIIIIIIIlllIllII == Options.MIPMAP_LEVELS) ? ((float)this.mipmapLevels) : ((lllllllllllllllIlIIIIIIIlllIllII == Options.RENDER_DISTANCE) ? ((float)this.renderDistanceChunks) : ((lllllllllllllllIlIIIIIIIlllIllII == Options.STREAM_BYTES_PER_PIXEL) ? this.streamBytesPerPixel : ((lllllllllllllllIlIIIIIIIlllIllII == Options.STREAM_VOLUME_MIC) ? this.streamMicVolume : ((lllllllllllllllIlIIIIIIIlllIllII == Options.STREAM_VOLUME_SYSTEM) ? this.streamGameVolume : ((lllllllllllllllIlIIIIIIIlllIllII == Options.STREAM_KBPS) ? this.streamKbps : ((lllllllllllllllIlIIIIIIIlllIllII == Options.STREAM_FPS) ? this.streamFps : 0.0f))))))))))))))))))))));
    }
    
    public static String getKeyDisplayString(final int lllllllllllllllIlIIIIIIlIIlIIlIl) {
        return (lllllllllllllllIlIIIIIIlIIlIIlIl < 0) ? I18n.format("key.mouseButton", lllllllllllllllIlIIIIIIlIIlIIlIl + 101) : ((lllllllllllllllIlIIIIIIlIIlIIlIl < 256) ? Keyboard.getKeyName(lllllllllllllllIlIIIIIIlIIlIIlIl) : String.format("%c", (char)(lllllllllllllllIlIIIIIIlIIlIIlIl - 256)).toUpperCase());
    }
    
    public void setAllAnimations(final boolean lllllllllllllllIIlllllllllllIIII) {
        final int lllllllllllllllIIlllllllllllIIlI = lllllllllllllllIIlllllllllllIIII ? 0 : 2;
        this.ofAnimatedWater = lllllllllllllllIIlllllllllllIIlI;
        this.ofAnimatedLava = lllllllllllllllIIlllllllllllIIlI;
        this.ofAnimatedFire = lllllllllllllllIIlllllllllllIIII;
        this.ofAnimatedPortal = lllllllllllllllIIlllllllllllIIII;
        this.ofAnimatedRedstone = lllllllllllllllIIlllllllllllIIII;
        this.ofAnimatedExplosion = lllllllllllllllIIlllllllllllIIII;
        this.ofAnimatedFlame = lllllllllllllllIIlllllllllllIIII;
        this.ofAnimatedSmoke = lllllllllllllllIIlllllllllllIIII;
        this.ofVoidParticles = lllllllllllllllIIlllllllllllIIII;
        this.ofWaterParticles = lllllllllllllllIIlllllllllllIIII;
        this.ofRainSplash = lllllllllllllllIIlllllllllllIIII;
        this.ofPortalParticles = lllllllllllllllIIlllllllllllIIII;
        this.ofPotionParticles = lllllllllllllllIIlllllllllllIIII;
        this.ofFireworkParticles = lllllllllllllllIIlllllllllllIIII;
        this.particleSetting = (lllllllllllllllIIlllllllllllIIII ? 0 : 2);
        this.ofDrippingWaterLava = lllllllllllllllIIlllllllllllIIII;
        this.ofAnimatedTerrain = lllllllllllllllIIlllllllllllIIII;
        this.ofAnimatedTextures = lllllllllllllllIIlllllllllllIIII;
    }
    
    public enum Options
    {
        SNOOPER_ENABLED("SNOOPER_ENABLED", 20, "SNOOPER_ENABLED", 20, "SNOOPER_ENABLED", 20, "options.snooper", false, true), 
        CHAT_WIDTH("CHAT_WIDTH", 26, "CHAT_WIDTH", 26, "CHAT_WIDTH", 26, "options.chat.width", true, false), 
        MIPMAP_LEVELS("MIPMAP_LEVELS", 29, "MIPMAP_LEVELS", 29, "MIPMAP_LEVELS", 29, "options.mipmapLevels", true, false, 0.0f, 4.0f, 1.0f), 
        CUSTOM_COLORS("CUSTOM_COLORS", 89, "CUSTOM_COLORS", 89, "", 999, "of.options.CUSTOM_COLORS", false, false), 
        DYNAMIC_LIGHTS("DYNAMIC_LIGHTS", 105, "DYNAMIC_LIGHTS", 105, "", 999, "of.options.DYNAMIC_LIGHTS", false, false), 
        SUN_MOON("SUN_MOON", 67, "SUN_MOON", 67, "", 999, "of.options.SUN_MOON", false, false), 
        POTION_PARTICLES("POTION_PARTICLES", 78, "POTION_PARTICLES", 78, "", 999, "of.options.POTION_PARTICLES", false, false), 
        TREES("TREES", 49, "TREES", 49, "", 999, "of.options.TREES", false, false), 
        VIGNETTE("VIGNETTE", 68, "VIGNETTE", 68, "", 999, "of.options.VIGNETTE", false, false), 
        DRIPPING_WATER_LAVA("DRIPPING_WATER_LAVA", 81, "DRIPPING_WATER_LAVA", 81, "", 999, "of.options.DRIPPING_WATER_LAVA", false, false), 
        STREAM_MIC_TOGGLE_BEHAVIOR("STREAM_MIC_TOGGLE_BEHAVIOR", 40, "STREAM_MIC_TOGGLE_BEHAVIOR", 40, "STREAM_MIC_TOGGLE_BEHAVIOR", 40, "options.stream.micToggleBehavior", false, false), 
        ANIMATED_TERRAIN("ANIMATED_TERRAIN", 84, "ANIMATED_TERRAIN", 84, "", 999, "of.options.ANIMATED_TERRAIN", false, false), 
        PROFILER("PROFILER", 80, "PROFILER", 80, "", 999, "of.options.PROFILER", false, false), 
        BETTER_GRASS("BETTER_GRASS", 59, "BETTER_GRASS", 59, "", 999, "of.options.BETTER_GRASS", false, false), 
        PORTAL_PARTICLES("PORTAL_PARTICLES", 77, "PORTAL_PARTICLES", 77, "", 999, "of.options.PORTAL_PARTICLES", false, false), 
        ANIMATED_REDSTONE("ANIMATED_REDSTONE", 60, "ANIMATED_REDSTONE", 60, "", 999, "of.options.ANIMATED_REDSTONE", false, false), 
        CHAT_HEIGHT_FOCUSED("CHAT_HEIGHT_FOCUSED", 27, "CHAT_HEIGHT_FOCUSED", 27, "CHAT_HEIGHT_FOCUSED", 27, "options.chat.height.focused", true, false), 
        CHAT_LINKS("CHAT_LINKS", 17, "CHAT_LINKS", 17, "CHAT_LINKS", 17, "options.chat.links", false, true), 
        FOG_FANCY("FOG_FANCY", 43, "FOG_FANCY", 43, "", 999, "of.options.FOG_FANCY", false, false), 
        FOV("FOV", 2, "FOV", 2, "FOV", 2, "options.fov", true, false, 30.0f, 110.0f, 1.0f);
        
        private final /* synthetic */ boolean enumBoolean;
        
        DYNAMIC_FOV("DYNAMIC_FOV", 104, "DYNAMIC_FOV", 104, "", 999, "of.options.DYNAMIC_FOV", false, false), 
        CHAT_LINKS_PROMPT("CHAT_LINKS_PROMPT", 19, "CHAT_LINKS_PROMPT", 19, "CHAT_LINKS_PROMPT", 19, "options.chat.links.prompt", false, true);
        
        private /* synthetic */ float valueMin;
        
        CHAT_OPACITY("CHAT_OPACITY", 18, "CHAT_OPACITY", 18, "CHAT_OPACITY", 18, "options.chat.opacity", true, false);
        
        private final /* synthetic */ boolean enumFloat;
        
        FAST_RENDER("FAST_RENDER", 102, "FAST_RENDER", 102, "", 999, "of.options.FAST_RENDER", false, false);
        
        private final /* synthetic */ String enumString;
        
        CLOUDS("CLOUDS", 47, "CLOUDS", 47, "", 999, "of.options.CLOUDS", false, false), 
        GRAPHICS("GRAPHICS", 11, "GRAPHICS", 11, "GRAPHICS", 11, "options.graphics", false, false), 
        RAIN("RAIN", 50, "RAIN", 50, "", 999, "of.options.RAIN", false, false), 
        CUSTOM_FONTS("CUSTOM_FONTS", 88, "CUSTOM_FONTS", 88, "", 999, "of.options.CUSTOM_FONTS", false, false), 
        STREAM_CHAT_USER_FILTER("STREAM_CHAT_USER_FILTER", 39, "STREAM_CHAT_USER_FILTER", 39, "STREAM_CHAT_USER_FILTER", 39, "options.stream.chat.userFilter", false, false), 
        STREAM_CHAT_ENABLED("STREAM_CHAT_ENABLED", 38, "STREAM_CHAT_ENABLED", 38, "STREAM_CHAT_ENABLED", 38, "options.stream.chat.enabled", false, false), 
        CHAT_VISIBILITY("CHAT_VISIBILITY", 15, "CHAT_VISIBILITY", 15, "CHAT_VISIBILITY", 15, "options.chat.visibility", false, false), 
        RENDER_CLOUDS("RENDER_CLOUDS", 10, "RENDER_CLOUDS", 10, "RENDER_CLOUDS", 10, "options.renderClouds", false, true), 
        SHOW_CAPES("SHOW_CAPES", 90, "SHOW_CAPES", 90, "", 999, "of.options.SHOW_CAPES", false, false), 
        MIPMAP_TYPE("MIPMAP_TYPE", 45, "MIPMAP_TYPE", 45, "", 999, "of.options.MIPMAP_TYPE", true, false, 0.0f, 3.0f, 1.0f), 
        FULLSCREEN_MODE("FULLSCREEN_MODE", 83, "FULLSCREEN_MODE", 83, "", 999, "of.options.FULLSCREEN_MODE", false, false), 
        CHAT_SCALE("CHAT_SCALE", 25, "CHAT_SCALE", 25, "CHAT_SCALE", 25, "options.chat.scale", true, false), 
        FOG_START("FOG_START", 44, "FOG_START", 44, "", 999, "of.options.FOG_START", false, false), 
        ANIMATED_LAVA("ANIMATED_LAVA", 52, "ANIMATED_LAVA", 52, "", 999, "of.options.ANIMATED_LAVA", false, false), 
        INVERT_MOUSE("INVERT_MOUSE", 0, "INVERT_MOUSE", 0, "INVERT_MOUSE", 0, "options.invertMouse", false, true), 
        ANAGLYPH("ANAGLYPH", 7, "ANAGLYPH", 7, "ANAGLYPH", 7, "options.anaglyph", false, true), 
        CLOUD_HEIGHT("CLOUD_HEIGHT", 48, "CLOUD_HEIGHT", 48, "", 999, "of.options.CLOUD_HEIGHT", true, false), 
        LAZY_CHUNK_LOADING("LAZY_CHUNK_LOADING", 99, "LAZY_CHUNK_LOADING", 99, "", 999, "of.options.LAZY_CHUNK_LOADING", false, false), 
        ANIMATED_SMOKE("ANIMATED_SMOKE", 63, "ANIMATED_SMOKE", 63, "", 999, "of.options.ANIMATED_SMOKE", false, false), 
        CHUNK_UPDATES("CHUNK_UPDATES", 69, "CHUNK_UPDATES", 69, "", 999, "of.options.CHUNK_UPDATES", false, false), 
        SMOOTH_FPS("SMOOTH_FPS", 46, "SMOOTH_FPS", 46, "", 999, "of.options.SMOOTH_FPS", false, false), 
        CHAT_HEIGHT_UNFOCUSED("CHAT_HEIGHT_UNFOCUSED", 28, "CHAT_HEIGHT_UNFOCUSED", 28, "CHAT_HEIGHT_UNFOCUSED", 28, "options.chat.height.unfocused", true, false), 
        ANIMATED_FLAME("ANIMATED_FLAME", 62, "ANIMATED_FLAME", 62, "", 999, "of.options.ANIMATED_FLAME", false, false), 
        SMOOTH_BIOMES("SMOOTH_BIOMES", 87, "SMOOTH_BIOMES", 87, "", 999, "of.options.SMOOTH_BIOMES", false, false), 
        AF_LEVEL("AF_LEVEL", 94, "AF_LEVEL", 94, "", 999, "of.options.AF_LEVEL", true, false, 1.0f, 16.0f, 1.0f), 
        RANDOM_MOBS("RANDOM_MOBS", 86, "RANDOM_MOBS", 86, "", 999, "of.options.RANDOM_MOBS", false, false), 
        FIREWORK_PARTICLES("FIREWORK_PARTICLES", 79, "FIREWORK_PARTICLES", 79, "", 999, "of.options.FIREWORK_PARTICLES", false, false), 
        NATURAL_TEXTURES("NATURAL_TEXTURES", 96, "NATURAL_TEXTURES", 96, "", 999, "of.options.NATURAL_TEXTURES", false, false), 
        CLEAR_WATER("CLEAR_WATER", 72, "CLEAR_WATER", 72, "", 999, "of.options.CLEAR_WATER", false, false), 
        REDUCED_DEBUG_INFO("REDUCED_DEBUG_INFO", 42, "REDUCED_DEBUG_INFO", 42, "REDUCED_DEBUG_INFO", 42, "options.reducedDebugInfo", false, true), 
        SWAMP_COLORS("SWAMP_COLORS", 85, "SWAMP_COLORS", 85, "", 999, "of.options.SWAMP_COLORS", false, false), 
        SATURATION("SATURATION", 4, "SATURATION", 4, "SATURATION", 4, "options.saturation", true, false), 
        STREAM_BYTES_PER_PIXEL("STREAM_BYTES_PER_PIXEL", 31, "STREAM_BYTES_PER_PIXEL", 31, "STREAM_BYTES_PER_PIXEL", 31, "options.stream.bytesPerPixel", true, false), 
        HELD_ITEM_TOOLTIPS("HELD_ITEM_TOOLTIPS", 97, "HELD_ITEM_TOOLTIPS", 97, "", 999, "of.options.HELD_ITEM_TOOLTIPS", false, false), 
        ENABLE_VSYNC("ENABLE_VSYNC", 22, "ENABLE_VSYNC", 22, "ENABLE_VSYNC", 22, "options.vsync", false, true), 
        WEATHER("WEATHER", 64, "WEATHER", 64, "", 999, "of.options.WEATHER", false, false), 
        FRAMERATE_LIMIT("FRAMERATE_LIMIT", 8, "FRAMERATE_LIMIT", 8, "FRAMERATE_LIMIT", 8, "options.framerateLimit", true, false, 0.0f, 260.0f, 5.0f), 
        SHOW_FPS("SHOW_FPS", 57, "SHOW_FPS", 57, "", 999, "of.options.SHOW_FPS", false, false), 
        GUI_SCALE("GUI_SCALE", 13, "GUI_SCALE", 13, "GUI_SCALE", 13, "options.guiScale", false, false), 
        ANIMATED_PORTAL("ANIMATED_PORTAL", 54, "ANIMATED_PORTAL", 54, "", 999, "of.options.ANIMATED_PORTAL", false, false), 
        VOID_PARTICLES("VOID_PARTICLES", 74, "VOID_PARTICLES", 74, "", 999, "of.options.VOID_PARTICLES", false, false);
        
        private final /* synthetic */ float valueStep;
        
        VIEW_BOBBING("VIEW_BOBBING", 6, "VIEW_BOBBING", 6, "VIEW_BOBBING", 6, "options.viewBobbing", false, true), 
        ANIMATED_WATER("ANIMATED_WATER", 51, "ANIMATED_WATER", 51, "", 999, "of.options.ANIMATED_WATER", false, false), 
        ANIMATED_EXPLOSION("ANIMATED_EXPLOSION", 61, "ANIMATED_EXPLOSION", 61, "", 999, "of.options.ANIMATED_EXPLOSION", false, false), 
        TOUCHSCREEN("TOUCHSCREEN", 24, "TOUCHSCREEN", 24, "TOUCHSCREEN", 24, "options.touchscreen", false, true), 
        CONNECTED_TEXTURES("CONNECTED_TEXTURES", 91, "CONNECTED_TEXTURES", 91, "", 999, "of.options.CONNECTED_TEXTURES", false, false), 
        USE_FULLSCREEN("USE_FULLSCREEN", 21, "USE_FULLSCREEN", 21, "USE_FULLSCREEN", 21, "options.fullscreen", false, true), 
        RENDER_DISTANCE("RENDER_DISTANCE", 5, "RENDER_DISTANCE", 5, "RENDER_DISTANCE", 5, "options.renderDistance", true, false, 2.0f, 16.0f, 1.0f), 
        AO_LEVEL("AO_LEVEL", 55, "AO_LEVEL", 55, "", 999, "of.options.AO_LEVEL", true, false), 
        STREAM_VOLUME_SYSTEM("STREAM_VOLUME_SYSTEM", 33, "STREAM_VOLUME_SYSTEM", 33, "STREAM_VOLUME_SYSTEM", 33, "options.stream.systemVolume", true, false), 
        DROPPED_ITEMS("DROPPED_ITEMS", 98, "DROPPED_ITEMS", 98, "", 999, "of.options.DROPPED_ITEMS", false, false), 
        CHUNK_UPDATES_DYNAMIC("CHUNK_UPDATES_DYNAMIC", 70, "CHUNK_UPDATES_DYNAMIC", 70, "", 999, "of.options.CHUNK_UPDATES_DYNAMIC", false, false), 
        STREAM_VOLUME_MIC("STREAM_VOLUME_MIC", 32, "STREAM_VOLUME_MIC", 32, "STREAM_VOLUME_MIC", 32, "options.stream.micVolumne", true, false), 
        ANIMATED_FIRE("ANIMATED_FIRE", 53, "ANIMATED_FIRE", 53, "", 999, "of.options.ANIMATED_FIRE", false, false), 
        LAGOMETER("LAGOMETER", 56, "LAGOMETER", 56, "", 999, "of.options.LAGOMETER", false, false), 
        CUSTOM_ITEMS("CUSTOM_ITEMS", 92, "CUSTOM_ITEMS", 92, "", 999, "of.options.CUSTOM_ITEMS", false, false), 
        BETTER_SNOW("BETTER_SNOW", 82, "BETTER_SNOW", 82, "", 999, "of.options.BETTER_SNOW", false, false), 
        USE_VBO("USE_VBO", 23, "USE_VBO", 23, "USE_VBO", 23, "options.vbo", false, true), 
        AMBIENT_OCCLUSION("AMBIENT_OCCLUSION", 12, "AMBIENT_OCCLUSION", 12, "AMBIENT_OCCLUSION", 12, "options.ao", false, false), 
        ANIMATED_TEXTURES("ANIMATED_TEXTURES", 95, "ANIMATED_TEXTURES", 95, "", 999, "of.options.ANIMATED_TEXTURES", false, false), 
        STARS("STARS", 66, "STARS", 66, "", 999, "of.options.STARS", false, false), 
        FAST_MATH("FAST_MATH", 101, "FAST_MATH", 101, "", 999, "of.options.FAST_MATH", false, false), 
        STREAM_FPS("STREAM_FPS", 35, "STREAM_FPS", 35, "STREAM_FPS", 35, "options.stream.fps", true, false), 
        CUSTOM_SKY("CUSTOM_SKY", 100, "CUSTOM_SKY", 100, "", 999, "of.options.CUSTOM_SKY", false, false), 
        AUTOSAVE_TICKS("AUTOSAVE_TICKS", 58, "AUTOSAVE_TICKS", 58, "", 999, "of.options.AUTOSAVE_TICKS", false, false), 
        STREAM_KBPS("STREAM_KBPS", 34, "STREAM_KBPS", 34, "STREAM_KBPS", 34, "options.stream.kbps", true, false), 
        STREAM_COMPRESSION("STREAM_COMPRESSION", 36, "STREAM_COMPRESSION", 36, "STREAM_COMPRESSION", 36, "options.stream.compression", false, false), 
        SKY("SKY", 65, "SKY", 65, "", 999, "of.options.SKY", false, false), 
        RAIN_SPLASH("RAIN_SPLASH", 76, "RAIN_SPLASH", 76, "", 999, "of.options.RAIN_SPLASH", false, false), 
        BLOCK_ALTERNATIVES("BLOCK_ALTERNATIVES", 41, "BLOCK_ALTERNATIVES", 41, "BLOCK_ALTERNATIVES", 41, "options.blockAlternatives", false, true), 
        CHAT_COLOR("CHAT_COLOR", 16, "CHAT_COLOR", 16, "CHAT_COLOR", 16, "options.chat.color", false, true), 
        TRANSLUCENT_BLOCKS("TRANSLUCENT_BLOCKS", 103, "TRANSLUCENT_BLOCKS", 103, "", 999, "of.options.TRANSLUCENT_BLOCKS", false, false), 
        FBO_ENABLE("FBO_ENABLE", 9, "FBO_ENABLE", 9, "FBO_ENABLE", 9, "options.fboEnable", false, true), 
        AA_LEVEL("AA_LEVEL", 93, "AA_LEVEL", 93, "", 999, "of.options.AA_LEVEL", true, false, 0.0f, 16.0f, 1.0f), 
        GAMMA("GAMMA", 3, "GAMMA", 3, "GAMMA", 3, "options.gamma", true, false);
        
        private /* synthetic */ float valueMax;
        
        SENSITIVITY("SENSITIVITY", 1, "SENSITIVITY", 1, "SENSITIVITY", 1, "options.sensitivity", true, false), 
        FORCE_UNICODE_FONT("FORCE_UNICODE_FONT", 30, "FORCE_UNICODE_FONT", 30, "FORCE_UNICODE_FONT", 30, "options.forceUnicodeFont", false, true), 
        PARTICLES("PARTICLES", 14, "PARTICLES", 14, "PARTICLES", 14, "options.particles", false, false), 
        SMOOTH_WORLD("SMOOTH_WORLD", 73, "SMOOTH_WORLD", 73, "", 999, "of.options.SMOOTH_WORLD", false, false), 
        STREAM_SEND_METADATA("STREAM_SEND_METADATA", 37, "STREAM_SEND_METADATA", 37, "STREAM_SEND_METADATA", 37, "options.stream.sendMetadata", false, true), 
        TIME("TIME", 71, "TIME", 71, "", 999, "of.options.TIME", false, false), 
        WATER_PARTICLES("WATER_PARTICLES", 75, "WATER_PARTICLES", 75, "", 999, "of.options.WATER_PARTICLES", false, false);
        
        public boolean getEnumFloat() {
            return this.enumFloat;
        }
        
        public int returnEnumOrdinal() {
            return this.ordinal();
        }
        
        public boolean getEnumBoolean() {
            return this.enumBoolean;
        }
        
        public String getEnumString() {
            return this.enumString;
        }
        
        public static Options getEnumOptions(final int llllllllllllllIIllIllIllIIIIIIII) {
            for (final Options llllllllllllllIIllIllIllIIIIIIIl : values()) {
                if (llllllllllllllIIllIllIllIIIIIIIl.returnEnumOrdinal() == llllllllllllllIIllIllIllIIIIIIII) {
                    return llllllllllllllIIllIllIllIIIIIIIl;
                }
            }
            return null;
        }
        
        public float normalizeValue(final float llllllllllllllIIllIllIlIlIlIlIII) {
            return MathHelper.clamp_float((this.snapToStepClamp(llllllllllllllIIllIllIlIlIlIlIII) - this.valueMin) / (this.valueMax - this.valueMin), 0.0f, 1.0f);
        }
        
        protected float snapToStep(float llllllllllllllIIllIllIlIlIIlIllI) {
            if (this.valueStep > 0.0f) {
                llllllllllllllIIllIllIlIlIIlIllI = this.valueStep * Math.round(llllllllllllllIIllIllIlIlIIlIllI / this.valueStep);
            }
            return llllllllllllllIIllIllIlIlIIlIllI;
        }
        
        public float denormalizeValue(final float llllllllllllllIIllIllIlIlIlIIlII) {
            return this.snapToStepClamp(this.valueMin + (this.valueMax - this.valueMin) * MathHelper.clamp_float(llllllllllllllIIllIllIlIlIlIIlII, 0.0f, 1.0f));
        }
        
        public void setValueMax(final float llllllllllllllIIllIllIlIlIllIIII) {
            this.valueMax = llllllllllllllIIllIllIlIlIllIIII;
        }
        
        private Options(final String llllllllllllllIIllIllIlIlllIlIII, final int llllllllllllllIIllIllIlIlllIIlll, final String llllllllllllllIIllIllIlIlllIIllI, final int llllllllllllllIIllIllIlIlllIIlIl, final String llllllllllllllIIllIllIlIlllIlllI, final int llllllllllllllIIllIllIlIlllIIIll, final String llllllllllllllIIllIllIlIlllIllII, final boolean llllllllllllllIIllIllIlIlllIIIIl, final boolean llllllllllllllIIllIllIlIlllIIIII) {
            this(llllllllllllllIIllIllIlIlllIlIII, llllllllllllllIIllIllIlIlllIIlll, llllllllllllllIIllIllIlIlllIIllI, llllllllllllllIIllIllIlIlllIIlIl, llllllllllllllIIllIllIlIlllIlllI, llllllllllllllIIllIllIlIlllIIIll, llllllllllllllIIllIllIlIlllIllII, llllllllllllllIIllIllIlIlllIIIIl, llllllllllllllIIllIllIlIlllIIIII, 0.0f, 1.0f, 0.0f);
        }
        
        static {
            __OBFID = "CL_00000653";
            $VALUES$ = new Options[] { Options.INVERT_MOUSE, Options.SENSITIVITY, Options.FOV, Options.GAMMA, Options.SATURATION, Options.RENDER_DISTANCE, Options.VIEW_BOBBING, Options.ANAGLYPH, Options.FRAMERATE_LIMIT, Options.FBO_ENABLE, Options.RENDER_CLOUDS, Options.GRAPHICS, Options.AMBIENT_OCCLUSION, Options.GUI_SCALE, Options.PARTICLES, Options.CHAT_VISIBILITY, Options.CHAT_COLOR, Options.CHAT_LINKS, Options.CHAT_OPACITY, Options.CHAT_LINKS_PROMPT, Options.SNOOPER_ENABLED, Options.USE_FULLSCREEN, Options.ENABLE_VSYNC, Options.USE_VBO, Options.TOUCHSCREEN, Options.CHAT_SCALE, Options.CHAT_WIDTH, Options.CHAT_HEIGHT_FOCUSED, Options.CHAT_HEIGHT_UNFOCUSED, Options.MIPMAP_LEVELS, Options.FORCE_UNICODE_FONT, Options.STREAM_BYTES_PER_PIXEL, Options.STREAM_VOLUME_MIC, Options.STREAM_VOLUME_SYSTEM, Options.STREAM_KBPS, Options.STREAM_FPS, Options.STREAM_COMPRESSION, Options.STREAM_SEND_METADATA, Options.STREAM_CHAT_ENABLED, Options.STREAM_CHAT_USER_FILTER, Options.STREAM_MIC_TOGGLE_BEHAVIOR, Options.BLOCK_ALTERNATIVES, Options.REDUCED_DEBUG_INFO, Options.FOG_FANCY, Options.FOG_START, Options.MIPMAP_TYPE, Options.SMOOTH_FPS, Options.CLOUDS, Options.CLOUD_HEIGHT, Options.TREES, Options.RAIN, Options.ANIMATED_WATER, Options.ANIMATED_LAVA, Options.ANIMATED_FIRE, Options.ANIMATED_PORTAL, Options.AO_LEVEL, Options.LAGOMETER, Options.SHOW_FPS, Options.AUTOSAVE_TICKS, Options.BETTER_GRASS, Options.ANIMATED_REDSTONE, Options.ANIMATED_EXPLOSION, Options.ANIMATED_FLAME, Options.ANIMATED_SMOKE, Options.WEATHER, Options.SKY, Options.STARS, Options.SUN_MOON, Options.VIGNETTE, Options.CHUNK_UPDATES, Options.CHUNK_UPDATES_DYNAMIC, Options.TIME, Options.CLEAR_WATER, Options.SMOOTH_WORLD, Options.VOID_PARTICLES, Options.WATER_PARTICLES, Options.RAIN_SPLASH, Options.PORTAL_PARTICLES, Options.POTION_PARTICLES, Options.FIREWORK_PARTICLES, Options.PROFILER, Options.DRIPPING_WATER_LAVA, Options.BETTER_SNOW, Options.FULLSCREEN_MODE, Options.ANIMATED_TERRAIN, Options.SWAMP_COLORS, Options.RANDOM_MOBS, Options.SMOOTH_BIOMES, Options.CUSTOM_FONTS, Options.CUSTOM_COLORS, Options.SHOW_CAPES, Options.CONNECTED_TEXTURES, Options.CUSTOM_ITEMS, Options.AA_LEVEL, Options.AF_LEVEL, Options.ANIMATED_TEXTURES, Options.NATURAL_TEXTURES, Options.HELD_ITEM_TOOLTIPS, Options.DROPPED_ITEMS, Options.LAZY_CHUNK_LOADING, Options.CUSTOM_SKY, Options.FAST_MATH, Options.FAST_RENDER, Options.TRANSLUCENT_BLOCKS, Options.DYNAMIC_FOV, Options.DYNAMIC_LIGHTS };
        }
        
        public float snapToStepClamp(float llllllllllllllIIllIllIlIlIIlllII) {
            llllllllllllllIIllIllIlIlIIlllII = this.snapToStep(llllllllllllllIIllIllIlIlIIlllII);
            return MathHelper.clamp_float(llllllllllllllIIllIllIlIlIIlllII, this.valueMin, this.valueMax);
        }
        
        public float getValueMax() {
            return this.valueMax;
        }
        
        private Options(final String llllllllllllllIIllIllIlIllIIlIlI, final int llllllllllllllIIllIllIlIllIIlIIl, final String llllllllllllllIIllIllIlIllIlIlIl, final int llllllllllllllIIllIllIlIllIlIlII, final String llllllllllllllIIllIllIlIllIlIIll, final int llllllllllllllIIllIllIlIllIlIIlI, final String llllllllllllllIIllIllIlIllIlIIIl, final boolean llllllllllllllIIllIllIlIllIIIlll, final boolean llllllllllllllIIllIllIlIllIIllll, final float llllllllllllllIIllIllIlIllIIlllI, final float llllllllllllllIIllIllIlIllIIIlII, final float llllllllllllllIIllIllIlIllIIllII) {
            this.enumString = llllllllllllllIIllIllIlIllIlIIIl;
            this.enumFloat = llllllllllllllIIllIllIlIllIIIlll;
            this.enumBoolean = llllllllllllllIIllIllIlIllIIllll;
            this.valueMin = llllllllllllllIIllIllIlIllIIlllI;
            this.valueMax = llllllllllllllIIllIllIlIllIIIlII;
            this.valueStep = llllllllllllllIIllIllIlIllIIllII;
        }
    }
    
    static final class SwitchOptions
    {
        static final /* synthetic */ int[] optionIds;
        
        static {
            __OBFID = "CL_00000652";
            optionIds = new int[Options.values().length];
            try {
                SwitchOptions.optionIds[Options.INVERT_MOUSE.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchOptions.optionIds[Options.VIEW_BOBBING.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchOptions.optionIds[Options.ANAGLYPH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchOptions.optionIds[Options.FBO_ENABLE.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                SwitchOptions.optionIds[Options.RENDER_CLOUDS.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                SwitchOptions.optionIds[Options.CHAT_COLOR.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
            try {
                SwitchOptions.optionIds[Options.CHAT_LINKS.ordinal()] = 7;
            }
            catch (NoSuchFieldError noSuchFieldError7) {}
            try {
                SwitchOptions.optionIds[Options.CHAT_LINKS_PROMPT.ordinal()] = 8;
            }
            catch (NoSuchFieldError noSuchFieldError8) {}
            try {
                SwitchOptions.optionIds[Options.SNOOPER_ENABLED.ordinal()] = 9;
            }
            catch (NoSuchFieldError noSuchFieldError9) {}
            try {
                SwitchOptions.optionIds[Options.USE_FULLSCREEN.ordinal()] = 10;
            }
            catch (NoSuchFieldError noSuchFieldError10) {}
            try {
                SwitchOptions.optionIds[Options.ENABLE_VSYNC.ordinal()] = 11;
            }
            catch (NoSuchFieldError noSuchFieldError11) {}
            try {
                SwitchOptions.optionIds[Options.USE_VBO.ordinal()] = 12;
            }
            catch (NoSuchFieldError noSuchFieldError12) {}
            try {
                SwitchOptions.optionIds[Options.TOUCHSCREEN.ordinal()] = 13;
            }
            catch (NoSuchFieldError noSuchFieldError13) {}
            try {
                SwitchOptions.optionIds[Options.STREAM_SEND_METADATA.ordinal()] = 14;
            }
            catch (NoSuchFieldError noSuchFieldError14) {}
            try {
                SwitchOptions.optionIds[Options.FORCE_UNICODE_FONT.ordinal()] = 15;
            }
            catch (NoSuchFieldError noSuchFieldError15) {}
            try {
                SwitchOptions.optionIds[Options.BLOCK_ALTERNATIVES.ordinal()] = 16;
            }
            catch (NoSuchFieldError noSuchFieldError16) {}
            try {
                SwitchOptions.optionIds[Options.REDUCED_DEBUG_INFO.ordinal()] = 17;
            }
            catch (NoSuchFieldError noSuchFieldError17) {}
        }
    }
}
