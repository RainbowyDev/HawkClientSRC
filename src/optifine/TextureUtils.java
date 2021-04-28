package optifine;

import java.nio.*;
import java.awt.image.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.renderer.texture.*;
import shadersmod.client.*;
import net.minecraft.client.*;
import java.io.*;
import java.awt.*;

public class TextureUtils
{
    public static /* synthetic */ TextureAtlasSprite iconLavaFlow;
    public static /* synthetic */ TextureAtlasSprite iconGrassTop;
    public static /* synthetic */ TextureAtlasSprite iconGlass;
    public static /* synthetic */ TextureAtlasSprite iconSnow;
    public static /* synthetic */ TextureAtlasSprite iconGrassSideSnowed;
    public static /* synthetic */ TextureAtlasSprite iconCompass;
    public static /* synthetic */ TextureAtlasSprite iconWaterFlow;
    public static /* synthetic */ TextureAtlasSprite iconMyceliumTop;
    public static /* synthetic */ TextureAtlasSprite iconGlassPaneTop;
    public static /* synthetic */ TextureAtlasSprite iconFireLayer1;
    public static /* synthetic */ TextureAtlasSprite iconPortal;
    public static /* synthetic */ TextureAtlasSprite iconLavaStill;
    private static /* synthetic */ IntBuffer staticBuffer;
    public static /* synthetic */ TextureAtlasSprite iconClock;
    public static /* synthetic */ TextureAtlasSprite iconWaterStill;
    public static /* synthetic */ TextureAtlasSprite iconGrassSide;
    public static /* synthetic */ TextureAtlasSprite iconMyceliumSide;
    public static /* synthetic */ TextureAtlasSprite iconGrassSideOverlay;
    public static /* synthetic */ TextureAtlasSprite iconFireLayer0;
    
    public static int twoToPower(final int lllllllllllllllIIIlllIIllIlIllIl) {
        int lllllllllllllllIIIlllIIllIlIllII = 1;
        for (int lllllllllllllllIIIlllIIllIlIlIll = 0; lllllllllllllllIIIlllIIllIlIlIll < lllllllllllllllIIIlllIIllIlIllIl; ++lllllllllllllllIIIlllIIllIlIlIll) {
            lllllllllllllllIIIlllIIllIlIllII *= 2;
        }
        return lllllllllllllllIIIlllIIllIlIllII;
    }
    
    public static void bindTexture(final int lllllllllllllllIIIlllIIlIllllIII) {
        GlStateManager.func_179144_i(lllllllllllllllIIIlllIIlIllllIII);
    }
    
    public static String fixResourcePath(String lllllllllllllllIIIlllIIllIIIlIlI, String lllllllllllllllIIIlllIIllIIIlIIl) {
        final String lllllllllllllllIIIlllIIllIIIllII = "assets/minecraft/";
        if (((String)lllllllllllllllIIIlllIIllIIIlIlI).startsWith(lllllllllllllllIIIlllIIllIIIllII)) {
            lllllllllllllllIIIlllIIllIIIlIlI = ((String)lllllllllllllllIIIlllIIllIIIlIlI).substring(lllllllllllllllIIIlllIIllIIIllII.length());
            return (String)lllllllllllllllIIIlllIIllIIIlIlI;
        }
        if (((String)lllllllllllllllIIIlllIIllIIIlIlI).startsWith("./")) {
            lllllllllllllllIIIlllIIllIIIlIlI = ((String)lllllllllllllllIIIlllIIllIIIlIlI).substring(2);
            if (!lllllllllllllllIIIlllIIllIIIlIIl.endsWith("/")) {
                lllllllllllllllIIIlllIIllIIIlIIl = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIIlllIIllIIIlIIl)).append("/"));
            }
            lllllllllllllllIIIlllIIllIIIlIlI = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIIlllIIllIIIlIIl)).append((String)lllllllllllllllIIIlllIIllIIIlIlI));
            return (String)lllllllllllllllIIIlllIIllIIIlIlI;
        }
        if (((String)lllllllllllllllIIIlllIIllIIIlIlI).startsWith("/~")) {
            lllllllllllllllIIIlllIIllIIIlIlI = ((String)lllllllllllllllIIIlllIIllIIIlIlI).substring(1);
        }
        final String lllllllllllllllIIIlllIIllIIIlIll = "mcpatcher/";
        if (((String)lllllllllllllllIIIlllIIllIIIlIlI).startsWith("~/")) {
            lllllllllllllllIIIlllIIllIIIlIlI = ((String)lllllllllllllllIIIlllIIllIIIlIlI).substring(2);
            lllllllllllllllIIIlllIIllIIIlIlI = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIIlllIIllIIIlIll)).append((String)lllllllllllllllIIIlllIIllIIIlIlI));
            return (String)lllllllllllllllIIIlllIIllIIIlIlI;
        }
        if (((String)lllllllllllllllIIIlllIIllIIIlIlI).startsWith("/")) {
            lllllllllllllllIIIlllIIllIIIlIlI = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIIlllIIllIIIlIll)).append(((String)lllllllllllllllIIIlllIIllIIIlIlI).substring(1)));
            return (String)lllllllllllllllIIIlllIIllIIIlIlI;
        }
        return (String)lllllllllllllllIIIlllIIllIIIlIlI;
    }
    
    public static BufferedImage scaleToPowerOfTwo(final BufferedImage lllllllllllllllIIIlllIIlIllIlIII, final int lllllllllllllllIIIlllIIlIlIllllI) {
        if (lllllllllllllllIIIlllIIlIllIlIII == null) {
            return lllllllllllllllIIIlllIIlIllIlIII;
        }
        final int lllllllllllllllIIIlllIIlIllIIllI = lllllllllllllllIIIlllIIlIllIlIII.getWidth();
        final int lllllllllllllllIIIlllIIlIllIIlIl = lllllllllllllllIIIlllIIlIllIlIII.getHeight();
        int lllllllllllllllIIIlllIIlIllIIlII = Math.max(lllllllllllllllIIIlllIIlIllIIllI, lllllllllllllllIIIlllIIlIlIllllI);
        lllllllllllllllIIIlllIIlIllIIlII = MathHelper.roundUpToPowerOfTwo(lllllllllllllllIIIlllIIlIllIIlII);
        if (lllllllllllllllIIIlllIIlIllIIlII == lllllllllllllllIIIlllIIlIllIIllI) {
            return lllllllllllllllIIIlllIIlIllIlIII;
        }
        final int lllllllllllllllIIIlllIIlIllIIIll = lllllllllllllllIIIlllIIlIllIIlIl * lllllllllllllllIIIlllIIlIllIIlII / lllllllllllllllIIIlllIIlIllIIllI;
        final BufferedImage lllllllllllllllIIIlllIIlIllIIIlI = new BufferedImage(lllllllllllllllIIIlllIIlIllIIlII, lllllllllllllllIIIlllIIlIllIIIll, 2);
        final Graphics2D lllllllllllllllIIIlllIIlIllIIIIl = lllllllllllllllIIIlllIIlIllIIIlI.createGraphics();
        Object lllllllllllllllIIIlllIIlIllIIIII = RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR;
        if (lllllllllllllllIIIlllIIlIllIIlII % lllllllllllllllIIIlllIIlIllIIllI != 0) {
            lllllllllllllllIIIlllIIlIllIIIII = RenderingHints.VALUE_INTERPOLATION_BILINEAR;
        }
        lllllllllllllllIIIlllIIlIllIIIIl.setRenderingHint(RenderingHints.KEY_INTERPOLATION, lllllllllllllllIIIlllIIlIllIIIII);
        lllllllllllllllIIIlllIIlIllIIIIl.drawImage(lllllllllllllllIIIlllIIlIllIlIII, 0, 0, lllllllllllllllIIIlllIIlIllIIlII, lllllllllllllllIIIlllIIlIllIIIll, null);
        return lllllllllllllllIIIlllIIlIllIIIlI;
    }
    
    public static void resourcesReloaded(final IResourceManager lllllllllllllllIIIlllIIllIIllllI) {
        if (getTextureMapBlocks() != null) {
            Config.dbg("*** Reloading custom textures ***");
            CustomSky.reset();
            TextureAnimations.reset();
            update();
            NaturalTextures.update();
            BetterGrass.update();
            BetterSnow.update();
            TextureAnimations.update();
            CustomColors.update();
            CustomSky.update();
            RandomMobs.resetTextures();
            CustomItems.updateModels();
            Shaders.resourcesReloaded();
            Lang.resourcesReloaded();
            Config.updateTexturePackClouds();
            SmartLeaves.updateLeavesModels();
            Config.getTextureManager().tick();
        }
    }
    
    public static ITextureObject getTexture(final ResourceLocation lllllllllllllllIIIlllIIllIlIIIIl) {
        final ITextureObject lllllllllllllllIIIlllIIllIlIIIll = Config.getTextureManager().getTexture(lllllllllllllllIIIlllIIllIlIIIIl);
        if (lllllllllllllllIIIlllIIllIlIIIll != null) {
            return lllllllllllllllIIIlllIIllIlIIIll;
        }
        if (!Config.hasResource(lllllllllllllllIIIlllIIllIlIIIIl)) {
            return null;
        }
        final SimpleTexture lllllllllllllllIIIlllIIllIlIIIlI = new SimpleTexture(lllllllllllllllIIIlllIIllIlIIIIl);
        Config.getTextureManager().loadTexture(lllllllllllllllIIIlllIIllIlIIIIl, lllllllllllllllIIIlllIIllIlIIIlI);
        return lllllllllllllllIIIlllIIllIlIIIlI;
    }
    
    public static int ceilPowerOfTwo(final int lllllllllllllllIIIlllIIllIllllIl) {
        int lllllllllllllllIIIlllIIllIllllII;
        for (lllllllllllllllIIIlllIIllIllllII = 1; lllllllllllllllIIIlllIIllIllllII < lllllllllllllllIIIlllIIllIllllIl; lllllllllllllllIIIlllIIllIllllII *= 2) {}
        return lllllllllllllllIIIlllIIllIllllII;
    }
    
    static {
        texStone = "stone";
        SPRITE_PREFIX_ITEMS = "minecraft:items/";
        texCactusSide = "cactus_side";
        texRedstoneLampOff = "redstone_lamp_off";
        texLeavesBirch = "leaves_birch";
        texGrassSideSnowed = "grass_side_snowed";
        texClay = "clay";
        texWaterStill = "water_still";
        texLogBigOak = "log_big_oak";
        texRedstoneLampOn = "redstone_lamp_on";
        texLogBigOakTop = "log_big_oak_top";
        texLeavesSpruceOpaque = "leaves_spruce_opaque";
        SPRITE_PREFIX_BLOCKS = "minecraft:blocks/";
        texObsidian = "obsidian";
        texLeavesSpuce = "leaves_spruce";
        texCompass = "compass";
        texGlassPaneTop = "glass_pane_top";
        texLavaStill = "lava_still";
        texLogAcaciaTop = "log_acacia_top";
        texLogOakTop = "log_oak_top";
        texDiamondOre = "diamond_ore";
        texGoldOre = "gold_ore";
        texGrassTop = "grass_top";
        texSoulSand = "soul_sand";
        texSnow = "snow";
        texLogSpruce = "log_spruce";
        texLavaFlow = "lava_flow";
        texCoarseDirt = "coarse_dirt";
        texIronOre = "iron_ore";
        texLogAcacia = "log_acacia";
        texLogSpruceTop = "log_spruce_top";
        texLapisOre = "lapis_ore";
        texLeavesJungle = "leaves_jungle";
        texClock = "clock";
        texEndStone = "end_stone";
        texDirt = "dirt";
        texSand = "sand";
        texGlass = "glass";
        texCoalOre = "coal_ore";
        texLogBirchTop = "log_birch_top";
        texSandstoneBottom = "sandstone_bottom";
        texStoneslabTop = "stone_slab_top";
        texSandstoneTop = "sandstone_top";
        texLeavesSpruce = "leaves_spruce";
        texMyceliumSide = "mycelium_side";
        texLeavesBigOak = "leaves_big_oak";
        texNetherrack = "netherrack";
        texMyceliumTop = "mycelium_top";
        texGrassSide = "grass_side";
        texRedstoneOre = "redstone_ore";
        texLogJungleTop = "log_jungle_top";
        texLeavesAcacia = "leaves_acacia";
        texGlowstone = "glowstone";
        texFireLayer0 = "fire_layer_0";
        texLogJungle = "log_jungle";
        texWaterFlow = "water_flow";
        texStoneslabSide = "stone_slab_side";
        texFarmlandWet = "farmland_wet";
        texFarmlandDry = "farmland_dry";
        texGravel = "gravel";
        texBedrock = "bedrock";
        texLeavesOak = "leaves_oak";
        texFireLayer1 = "fire_layer_1";
        texLogBirch = "log_birch";
        texGrassSideOverlay = "grass_side_overlay";
        texPortal = "portal";
        texLogOak = "log_oak";
        TextureUtils.staticBuffer = GLAllocation.createDirectIntBuffer(256);
    }
    
    public static int getPowerOfTwo(final int lllllllllllllllIIIlllIIllIllIIll) {
        int lllllllllllllllIIIlllIIllIllIlIl;
        int lllllllllllllllIIIlllIIllIllIlII;
        for (lllllllllllllllIIIlllIIllIllIlIl = 1, lllllllllllllllIIIlllIIllIllIlII = 0; lllllllllllllllIIIlllIIllIllIlIl < lllllllllllllllIIIlllIIllIllIIll; lllllllllllllllIIIlllIIllIllIlIl *= 2, ++lllllllllllllllIIIlllIIllIllIlII) {}
        return lllllllllllllllIIIlllIIllIllIlII;
    }
    
    public static boolean isPowerOfTwo(final int lllllllllllllllIIIlllIIlIlllIlIl) {
        final int lllllllllllllllIIIlllIIlIlllIlII = MathHelper.roundUpToPowerOfTwo(lllllllllllllllIIIlllIIlIlllIlIl);
        return lllllllllllllllIIIlllIIlIlllIlII == lllllllllllllllIIIlllIIlIlllIlIl;
    }
    
    public static void update() {
        final TextureMap lllllllllllllllIIIlllIIlllIlIlll = getTextureMapBlocks();
        if (lllllllllllllllIIIlllIIlllIlIlll != null) {
            final String lllllllllllllllIIIlllIIlllIlIllI = "minecraft:blocks/";
            TextureUtils.iconGrassTop = lllllllllllllllIIIlllIIlllIlIlll.getSpriteSafe(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIIlllIIlllIlIllI)).append("grass_top")));
            TextureUtils.iconGrassSide = lllllllllllllllIIIlllIIlllIlIlll.getSpriteSafe(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIIlllIIlllIlIllI)).append("grass_side")));
            TextureUtils.iconGrassSideOverlay = lllllllllllllllIIIlllIIlllIlIlll.getSpriteSafe(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIIlllIIlllIlIllI)).append("grass_side_overlay")));
            TextureUtils.iconSnow = lllllllllllllllIIIlllIIlllIlIlll.getSpriteSafe(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIIlllIIlllIlIllI)).append("snow")));
            TextureUtils.iconGrassSideSnowed = lllllllllllllllIIIlllIIlllIlIlll.getSpriteSafe(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIIlllIIlllIlIllI)).append("grass_side_snowed")));
            TextureUtils.iconMyceliumSide = lllllllllllllllIIIlllIIlllIlIlll.getSpriteSafe(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIIlllIIlllIlIllI)).append("mycelium_side")));
            TextureUtils.iconMyceliumTop = lllllllllllllllIIIlllIIlllIlIlll.getSpriteSafe(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIIlllIIlllIlIllI)).append("mycelium_top")));
            TextureUtils.iconWaterStill = lllllllllllllllIIIlllIIlllIlIlll.getSpriteSafe(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIIlllIIlllIlIllI)).append("water_still")));
            TextureUtils.iconWaterFlow = lllllllllllllllIIIlllIIlllIlIlll.getSpriteSafe(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIIlllIIlllIlIllI)).append("water_flow")));
            TextureUtils.iconLavaStill = lllllllllllllllIIIlllIIlllIlIlll.getSpriteSafe(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIIlllIIlllIlIllI)).append("lava_still")));
            TextureUtils.iconLavaFlow = lllllllllllllllIIIlllIIlllIlIlll.getSpriteSafe(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIIlllIIlllIlIllI)).append("lava_flow")));
            TextureUtils.iconFireLayer0 = lllllllllllllllIIIlllIIlllIlIlll.getSpriteSafe(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIIlllIIlllIlIllI)).append("fire_layer_0")));
            TextureUtils.iconFireLayer1 = lllllllllllllllIIIlllIIlllIlIlll.getSpriteSafe(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIIlllIIlllIlIllI)).append("fire_layer_1")));
            TextureUtils.iconPortal = lllllllllllllllIIIlllIIlllIlIlll.getSpriteSafe(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIIlllIIlllIlIllI)).append("portal")));
            TextureUtils.iconGlass = lllllllllllllllIIIlllIIlllIlIlll.getSpriteSafe(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIIlllIIlllIlIllI)).append("glass")));
            TextureUtils.iconGlassPaneTop = lllllllllllllllIIIlllIIlllIlIlll.getSpriteSafe(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIIlllIIlllIlIllI)).append("glass_pane_top")));
            final String lllllllllllllllIIIlllIIlllIlIlIl = "minecraft:items/";
            TextureUtils.iconCompass = lllllllllllllllIIIlllIIlllIlIlll.getSpriteSafe(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIIlllIIlllIlIlIl)).append("compass")));
            TextureUtils.iconClock = lllllllllllllllIIIlllIIlllIlIlll.getSpriteSafe(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIIlllIIlllIlIlIl)).append("clock")));
        }
    }
    
    public static BufferedImage scaleMinTo(final BufferedImage lllllllllllllllIIIlllIIlIlIIllIl, final int lllllllllllllllIIIlllIIlIlIIllII) {
        if (lllllllllllllllIIIlllIIlIlIIllIl == null) {
            return lllllllllllllllIIIlllIIlIlIIllIl;
        }
        final int lllllllllllllllIIIlllIIlIlIIlIll = lllllllllllllllIIIlllIIlIlIIllIl.getWidth();
        final int lllllllllllllllIIIlllIIlIlIIlIlI = lllllllllllllllIIIlllIIlIlIIllIl.getHeight();
        if (lllllllllllllllIIIlllIIlIlIIlIll >= lllllllllllllllIIIlllIIlIlIIllII) {
            return lllllllllllllllIIIlllIIlIlIIllIl;
        }
        int lllllllllllllllIIIlllIIlIlIIlIIl;
        for (lllllllllllllllIIIlllIIlIlIIlIIl = lllllllllllllllIIIlllIIlIlIIlIll; lllllllllllllllIIIlllIIlIlIIlIIl < lllllllllllllllIIIlllIIlIlIIllII; lllllllllllllllIIIlllIIlIlIIlIIl *= 2) {}
        final int lllllllllllllllIIIlllIIlIlIIlIII = lllllllllllllllIIIlllIIlIlIIlIlI * lllllllllllllllIIIlllIIlIlIIlIIl / lllllllllllllllIIIlllIIlIlIIlIll;
        final BufferedImage lllllllllllllllIIIlllIIlIlIIIlll = new BufferedImage(lllllllllllllllIIIlllIIlIlIIlIIl, lllllllllllllllIIIlllIIlIlIIlIII, 2);
        final Graphics2D lllllllllllllllIIIlllIIlIlIIIllI = lllllllllllllllIIIlllIIlIlIIIlll.createGraphics();
        final Object lllllllllllllllIIIlllIIlIlIIIlIl = RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR;
        lllllllllllllllIIIlllIIlIlIIIllI.setRenderingHint(RenderingHints.KEY_INTERPOLATION, lllllllllllllllIIIlllIIlIlIIIlIl);
        lllllllllllllllIIIlllIIlIlIIIllI.drawImage(lllllllllllllllIIIlllIIlIlIIllIl, 0, 0, lllllllllllllllIIIlllIIlIlIIlIIl, lllllllllllllllIIIlllIIlIlIIlIII, null);
        return lllllllllllllllIIIlllIIlIlIIIlll;
    }
    
    public static String getBasePath(final String lllllllllllllllIIIlllIIllIIIIlII) {
        final int lllllllllllllllIIIlllIIllIIIIIll = lllllllllllllllIIIlllIIllIIIIlII.lastIndexOf(47);
        return (lllllllllllllllIIIlllIIllIIIIIll < 0) ? "" : lllllllllllllllIIIlllIIllIIIIlII.substring(0, lllllllllllllllIIIlllIIllIIIIIll);
    }
    
    public static void applyAnisotropicLevel() {
        if (GLContext.getCapabilities().GL_EXT_texture_filter_anisotropic) {
            final float lllllllllllllllIIIlllIIlIllllllI = GL11.glGetFloat(34047);
            float lllllllllllllllIIIlllIIlIlllllIl = (float)Config.getAnisotropicFilterLevel();
            lllllllllllllllIIIlllIIlIlllllIl = Math.min(lllllllllllllllIIIlllIIlIlllllIl, lllllllllllllllIIIlllIIlIllllllI);
            GL11.glTexParameterf(3553, 34046, lllllllllllllllIIIlllIIlIlllllIl);
        }
    }
    
    public static void registerResourceListener() {
        final IResourceManager lllllllllllllllIIIlllIIllIIllIlI = Config.getResourceManager();
        if (lllllllllllllllIIIlllIIllIIllIlI instanceof IReloadableResourceManager) {
            final IReloadableResourceManager lllllllllllllllIIIlllIIllIIllIIl = (IReloadableResourceManager)lllllllllllllllIIIlllIIllIIllIlI;
            final IResourceManagerReloadListener lllllllllllllllIIIlllIIllIIllIII = new IResourceManagerReloadListener() {
                @Override
                public void onResourceManagerReload(final IResourceManager lllllllllllllllllIlIIIIIIlIlIlll) {
                    TextureUtils.resourcesReloaded(lllllllllllllllllIlIIIIIIlIlIlll);
                }
            };
            lllllllllllllllIIIlllIIllIIllIIl.registerReloadListener(lllllllllllllllIIIlllIIllIIllIII);
        }
        final ITickableTextureObject lllllllllllllllIIIlllIIllIIlIlll = new ITickableTextureObject() {
            @Override
            public void tick() {
                TextureAnimations.updateCustomAnimations();
            }
            
            @Override
            public void func_174936_b(final boolean llllllllllllllllIIlIllllllIlIIll, final boolean llllllllllllllllIIlIllllllIlIIlI) {
            }
            
            @Override
            public int getGlTextureId() {
                return 0;
            }
            
            @Override
            public MultiTexID getMultiTexID() {
                return null;
            }
            
            @Override
            public void func_174935_a() {
            }
            
            @Override
            public void loadTexture(final IResourceManager llllllllllllllllIIlIllllllIlIllI) throws IOException {
            }
        };
        final ResourceLocation lllllllllllllllIIIlllIIllIIlIllI = new ResourceLocation("optifine/TickableTextures");
        Config.getTextureManager().loadTickableTexture(lllllllllllllllIIIlllIIllIIlIllI, lllllllllllllllIIIlllIIllIIlIlll);
    }
    
    public static BufferedImage fixTextureDimensions(final String lllllllllllllllIIIlllIIlllIIlIll, final BufferedImage lllllllllllllllIIIlllIIlllIIIlII) {
        if (lllllllllllllllIIIlllIIlllIIlIll.startsWith("/mob/zombie") || lllllllllllllllIIIlllIIlllIIlIll.startsWith("/mob/pigzombie")) {
            final int lllllllllllllllIIIlllIIlllIIlIIl = lllllllllllllllIIIlllIIlllIIIlII.getWidth();
            final int lllllllllllllllIIIlllIIlllIIlIII = lllllllllllllllIIIlllIIlllIIIlII.getHeight();
            if (lllllllllllllllIIIlllIIlllIIlIIl == lllllllllllllllIIIlllIIlllIIlIII * 2) {
                final BufferedImage lllllllllllllllIIIlllIIlllIIIlll = new BufferedImage(lllllllllllllllIIIlllIIlllIIlIIl, lllllllllllllllIIIlllIIlllIIlIII * 2, 2);
                final Graphics2D lllllllllllllllIIIlllIIlllIIIllI = lllllllllllllllIIIlllIIlllIIIlll.createGraphics();
                lllllllllllllllIIIlllIIlllIIIllI.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                lllllllllllllllIIIlllIIlllIIIllI.drawImage(lllllllllllllllIIIlllIIlllIIIlII, 0, 0, lllllllllllllllIIIlllIIlllIIlIIl, lllllllllllllllIIIlllIIlllIIlIII, null);
                return lllllllllllllllIIIlllIIlllIIIlll;
            }
        }
        return lllllllllllllllIIIlllIIlllIIIlII;
    }
    
    public static TextureMap getTextureMapBlocks() {
        return Minecraft.getMinecraft().getTextureMapBlocks();
    }
    
    public static Dimension getImageSize(final InputStream lllllllllllllllIIIlllIIlIIllIIlI, final String lllllllllllllllIIIlllIIlIIllIIIl) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    javax/imageio/ImageIO.getImageReadersBySuffix:(Ljava/lang/String;)Ljava/util/Iterator;
        //     4: astore_2        /* lllllllllllllllIIIlllIIlIIllIIII */
        //     5: aload_2         /* lllllllllllllllIIIlllIIlIIllIIII */
        //     6: invokeinterface java/util/Iterator.hasNext:()Z
        //    11: ifeq            97
        //    14: aload_2         /* lllllllllllllllIIIlllIIlIIllIIII */
        //    15: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    20: checkcast       Ljavax/imageio/ImageReader;
        //    23: astore_3        /* lllllllllllllllIIIlllIIlIIlIllll */
        //    24: aload_0         /* lllllllllllllllIIIlllIIlIIlIlIII */
        //    25: invokestatic    javax/imageio/ImageIO.createImageInputStream:(Ljava/lang/Object;)Ljavax/imageio/stream/ImageInputStream;
        //    28: astore          lllllllllllllllIIIlllIIlIIlIllII
        //    30: aload_3         /* lllllllllllllllIIIlllIIlIIlIllll */
        //    31: aload           lllllllllllllllIIIlllIIlIIlIllII
        //    33: invokevirtual   javax/imageio/ImageReader.setInput:(Ljava/lang/Object;)V
        //    36: aload_3         /* lllllllllllllllIIIlllIIlIIlIllll */
        //    37: aload_3         /* lllllllllllllllIIIlllIIlIIlIllll */
        //    38: invokevirtual   javax/imageio/ImageReader.getMinIndex:()I
        //    41: invokevirtual   javax/imageio/ImageReader.getWidth:(I)I
        //    44: istore          lllllllllllllllIIIlllIIlIIlIlIll
        //    46: aload_3         /* lllllllllllllllIIIlllIIlIIlIllll */
        //    47: aload_3         /* lllllllllllllllIIIlllIIlIIlIllll */
        //    48: invokevirtual   javax/imageio/ImageReader.getMinIndex:()I
        //    51: invokevirtual   javax/imageio/ImageReader.getHeight:(I)I
        //    54: istore          lllllllllllllllIIIlllIIlIIlIlIlI
        //    56: new             Ljava/awt/Dimension;
        //    59: dup            
        //    60: iload           lllllllllllllllIIIlllIIlIIlIlIll
        //    62: iload           lllllllllllllllIIIlllIIlIIlIlIlI
        //    64: invokespecial   java/awt/Dimension.<init>:(II)V
        //    67: astore          lllllllllllllllIIIlllIIlIIlIlllI
        //    69: goto            90
        //    72: astore          lllllllllllllllIIIlllIIlIIlIlIIl
        //    74: aload_3         /* lllllllllllllllIIIlllIIlIIlIllll */
        //    75: invokevirtual   javax/imageio/ImageReader.dispose:()V
        //    78: goto            5
        //    81: astore          lllllllllllllllIIIlllIIlIIlIIIII
        //    83: aload_3         /* lllllllllllllllIIIlllIIlIIlIllll */
        //    84: invokevirtual   javax/imageio/ImageReader.dispose:()V
        //    87: aload           lllllllllllllllIIIlllIIlIIlIIIII
        //    89: athrow         
        //    90: aload_3         /* lllllllllllllllIIIlllIIlIIlIllll */
        //    91: invokevirtual   javax/imageio/ImageReader.dispose:()V
        //    94: aload           lllllllllllllllIIIlllIIlIIlIllIl
        //    96: areturn        
        //    97: aconst_null    
        //    98: areturn        
        //    StackMapTable: 00 05 FC 00 05 07 03 48 FF 00 42 00 04 07 03 84 07 00 81 07 03 48 07 03 52 00 01 07 03 40 48 07 03 86 FF 00 08 00 08 07 03 84 07 00 81 07 03 48 07 03 52 07 03 63 07 03 88 01 01 00 00 FF 00 06 00 03 07 03 84 07 00 81 07 03 48 00 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  24     69     72     81     Ljava/io/IOException;
        //  24     74     81     90     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2895)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at us.deathmarine.luyten.FileSaver.doSaveJarDecompiled(FileSaver.java:192)
        //     at us.deathmarine.luyten.FileSaver.access$300(FileSaver.java:45)
        //     at us.deathmarine.luyten.FileSaver$4.run(FileSaver.java:112)
        //     at java.lang.Thread.run(Unknown Source)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
}
