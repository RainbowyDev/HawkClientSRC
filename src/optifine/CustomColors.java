package optifine;

import net.minecraft.client.particle.*;
import net.minecraft.util.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.client.*;
import net.minecraft.init.*;
import java.io.*;
import net.minecraft.item.*;
import net.minecraft.potion.*;
import net.minecraft.entity.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;
import net.minecraft.world.biome.*;
import net.minecraft.client.renderer.block.model.*;
import javax.imageio.*;
import java.awt.image.*;
import org.apache.commons.lang3.tuple.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import java.util.*;

public class CustomColors
{
    private static /* synthetic */ int particlePortalColor;
    private static /* synthetic */ CustomColorFader skyColorFader;
    private static /* synthetic */ CustomColormap[] colorsBlockColormaps;
    private static /* synthetic */ int signTextColor;
    private static /* synthetic */ CustomColormap underwaterColors;
    private static final /* synthetic */ IBlockState BLOCK_STATE_DIRT;
    private static /* synthetic */ CustomColormap stemMelonColors;
    private static /* synthetic */ CustomColormap redstoneColors;
    private static final /* synthetic */ IColorizer COLORIZER_FOLIAGE_BIRCH;
    private static /* synthetic */ int bossTextColor;
    private static /* synthetic */ int[] spawnEggSecondaryColors;
    private static /* synthetic */ int[] potionColors;
    private static /* synthetic */ CustomColormap[] lightMapsColorsRgb;
    private static final /* synthetic */ IColorizer COLORIZER_FOLIAGE;
    private static /* synthetic */ float[][] sunRgbs;
    private static /* synthetic */ CustomColormap skyColors;
    private static final /* synthetic */ IColorizer COLORIZER_WATER;
    private static /* synthetic */ CustomColormap swampFoliageColors;
    private static /* synthetic */ float[][] wolfCollarColors;
    private static /* synthetic */ CustomColormap swampGrassColors;
    private static final /* synthetic */ IBlockState BLOCK_STATE_WATER;
    private static /* synthetic */ int[] mapColorsOriginal;
    private static /* synthetic */ CustomColormap myceliumParticleColors;
    private static /* synthetic */ Vec3 fogColorEnd;
    private static /* synthetic */ boolean useDefaultGrassFoliageColors;
    private static /* synthetic */ int[] textColors;
    private static /* synthetic */ CustomColorFader fogColorFader;
    private static /* synthetic */ Vec3 skyColorEnd;
    private static /* synthetic */ CustomColormap fogColors;
    public static /* synthetic */ Random random;
    private static /* synthetic */ CustomColormap waterColors;
    private static /* synthetic */ CustomColormap xpOrbColors;
    private static /* synthetic */ int expBarTextColor;
    private static /* synthetic */ int lilyPadColor;
    private static /* synthetic */ float[][] sheepColors;
    private static /* synthetic */ int[] spawnEggPrimaryColors;
    private static /* synthetic */ CustomColormap stemPumpkinColors;
    private static /* synthetic */ CustomColorFader underwaterColorFader;
    private static final /* synthetic */ IColorizer COLORIZER_FOLIAGE_PINE;
    private static /* synthetic */ float[][] torchRgbs;
    private static /* synthetic */ int lightmapMinDimensionId;
    private static /* synthetic */ CustomColormap[][] blockColormaps;
    private static /* synthetic */ CustomColormap stemColors;
    private static /* synthetic */ CustomColormap foliageBirchColors;
    private static /* synthetic */ Vec3 fogColorNether;
    private static /* synthetic */ CustomColormap foliagePineColors;
    private static final /* synthetic */ IColorizer COLORIZER_GRASS;
    private static /* synthetic */ int particleWaterColor;
    
    private static CustomColormap[][] readBlockColormaps(final String[] llllllllllllllllllIIlIllIIlllIlI, final CustomColormap[] llllllllllllllllllIIlIllIIlllIIl, final int llllllllllllllllllIIlIllIIlllIII, final int llllllllllllllllllIIlIllIIllIlll) {
        final String[] llllllllllllllllllIIlIllIIllIllI = ResUtils.collectFiles(llllllllllllllllllIIlIllIIlllIlI, new String[] { ".properties" });
        Arrays.sort(llllllllllllllllllIIlIllIIllIllI);
        final ArrayList llllllllllllllllllIIlIllIIllIlIl = new ArrayList();
        for (int llllllllllllllllllIIlIllIIllIlII = 0; llllllllllllllllllIIlIllIIllIlII < llllllllllllllllllIIlIllIIllIllI.length; ++llllllllllllllllllIIlIllIIllIlII) {
            final String llllllllllllllllllIIlIllIIllIIll = llllllllllllllllllIIlIllIIllIllI[llllllllllllllllllIIlIllIIllIlII];
            dbg(String.valueOf(new StringBuilder("Block colormap: ").append(llllllllllllllllllIIlIllIIllIIll)));
            try {
                final ResourceLocation llllllllllllllllllIIlIllIIllIIlI = new ResourceLocation("minecraft", llllllllllllllllllIIlIllIIllIIll);
                final InputStream llllllllllllllllllIIlIllIIllIIIl = Config.getResourceStream(llllllllllllllllllIIlIllIIllIIlI);
                if (llllllllllllllllllIIlIllIIllIIIl == null) {
                    warn(String.valueOf(new StringBuilder("File not found: ").append(llllllllllllllllllIIlIllIIllIIll)));
                }
                else {
                    final Properties llllllllllllllllllIIlIllIIllIIII = new Properties();
                    llllllllllllllllllIIlIllIIllIIII.load(llllllllllllllllllIIlIllIIllIIIl);
                    final CustomColormap llllllllllllllllllIIlIllIIlIllll = new CustomColormap(llllllllllllllllllIIlIllIIllIIII, llllllllllllllllllIIlIllIIllIIll, llllllllllllllllllIIlIllIIlllIII, llllllllllllllllllIIlIllIIllIlll);
                    if (llllllllllllllllllIIlIllIIlIllll.isValid(llllllllllllllllllIIlIllIIllIIll) && llllllllllllllllllIIlIllIIlIllll.isValidMatchBlocks(llllllllllllllllllIIlIllIIllIIll)) {
                        addToBlockList(llllllllllllllllllIIlIllIIlIllll, llllllllllllllllllIIlIllIIllIlIl);
                    }
                }
            }
            catch (FileNotFoundException llllllllllllllllllIIlIllIIlIlllI) {
                warn(String.valueOf(new StringBuilder("File not found: ").append(llllllllllllllllllIIlIllIIllIIll)));
            }
            catch (Exception llllllllllllllllllIIlIllIIlIllIl) {
                llllllllllllllllllIIlIllIIlIllIl.printStackTrace();
            }
        }
        if (llllllllllllllllllIIlIllIIlllIIl != null) {
            for (int llllllllllllllllllIIlIllIIllIlII = 0; llllllllllllllllllIIlIllIIllIlII < llllllllllllllllllIIlIllIIlllIIl.length; ++llllllllllllllllllIIlIllIIllIlII) {
                final CustomColormap llllllllllllllllllIIlIllIIlIllII = llllllllllllllllllIIlIllIIlllIIl[llllllllllllllllllIIlIllIIllIlII];
                addToBlockList(llllllllllllllllllIIlIllIIlIllII, llllllllllllllllllIIlIllIIllIlIl);
            }
        }
        if (llllllllllllllllllIIlIllIIllIlIl.size() <= 0) {
            return null;
        }
        final CustomColormap[][] llllllllllllllllllIIlIllIIlIlIll = blockListToArray(llllllllllllllllllIIlIllIIllIlIl);
        return llllllllllllllllllIIlIllIIlIlIll;
    }
    
    private static CustomColormap[][] blockListToArray(final List llllllllllllllllllIIlIlIlllllllI) {
        final CustomColormap[][] llllllllllllllllllIIlIlIllllllIl = new CustomColormap[llllllllllllllllllIIlIlIlllllllI.size()][];
        for (int llllllllllllllllllIIlIlIllllllII = 0; llllllllllllllllllIIlIlIllllllII < llllllllllllllllllIIlIlIlllllllI.size(); ++llllllllllllllllllIIlIlIllllllII) {
            final List llllllllllllllllllIIlIlIlllllIll = llllllllllllllllllIIlIlIlllllllI.get(llllllllllllllllllIIlIlIllllllII);
            if (llllllllllllllllllIIlIlIlllllIll != null) {
                final CustomColormap[] llllllllllllllllllIIlIlIlllllIlI = llllllllllllllllllIIlIlIlllllIll.toArray(new CustomColormap[llllllllllllllllllIIlIlIlllllIll.size()]);
                llllllllllllllllllIIlIlIllllllIl[llllllllllllllllllIIlIlIllllllII] = llllllllllllllllllIIlIlIlllllIlI;
            }
        }
        return llllllllllllllllllIIlIlIllllllIl;
    }
    
    private static int readColor(final Properties llllllllllllllllllIIlIlIlllIllll, final String[] llllllllllllllllllIIlIlIlllIlllI) {
        for (int llllllllllllllllllIIlIlIlllIllIl = 0; llllllllllllllllllIIlIlIlllIllIl < llllllllllllllllllIIlIlIlllIlllI.length; ++llllllllllllllllllIIlIlIlllIllIl) {
            final String llllllllllllllllllIIlIlIlllIllII = llllllllllllllllllIIlIlIlllIlllI[llllllllllllllllllIIlIlIlllIllIl];
            final int llllllllllllllllllIIlIlIlllIlIll = readColor(llllllllllllllllllIIlIlIlllIllll, llllllllllllllllllIIlIlIlllIllII);
            if (llllllllllllllllllIIlIlIlllIlIll >= 0) {
                return llllllllllllllllllIIlIlIlllIlIll;
            }
        }
        return -1;
    }
    
    public static void updateUseDefaultGrassFoliageColors() {
        CustomColors.useDefaultGrassFoliageColors = (CustomColors.foliageBirchColors == null && CustomColors.foliagePineColors == null && CustomColors.swampGrassColors == null && CustomColors.swampFoliageColors == null && Config.isSwampColors() && Config.isSmoothBiomes());
    }
    
    private static int[] readSpawnEggColors(final Properties llllllllllllllllllIIIlllllIllIII, final String llllllllllllllllllIIIlllllIlIlll, final String llllllllllllllllllIIIlllllIIlIII, final String llllllllllllllllllIIIlllllIIIlll) {
        final ArrayList llllllllllllllllllIIIlllllIlIlII = new ArrayList();
        final Set llllllllllllllllllIIIlllllIlIIll = llllllllllllllllllIIIlllllIllIII.keySet();
        int llllllllllllllllllIIIlllllIlIIlI = 0;
        for (final String llllllllllllllllllIIIlllllIlIIII : llllllllllllllllllIIIlllllIlIIll) {
            final String llllllllllllllllllIIIlllllIIllll = llllllllllllllllllIIIlllllIllIII.getProperty(llllllllllllllllllIIIlllllIlIIII);
            if (llllllllllllllllllIIIlllllIlIIII.startsWith(llllllllllllllllllIIIlllllIIlIII)) {
                final String llllllllllllllllllIIIlllllIIlllI = StrUtils.removePrefix(llllllllllllllllllIIIlllllIlIIII, llllllllllllllllllIIIlllllIIlIII);
                final int llllllllllllllllllIIIlllllIIllIl = getEntityId(llllllllllllllllllIIIlllllIIlllI);
                final int llllllllllllllllllIIIlllllIIllII = parseColor(llllllllllllllllllIIIlllllIIllll);
                if (llllllllllllllllllIIIlllllIIllIl >= 0 && llllllllllllllllllIIIlllllIIllII >= 0) {
                    while (llllllllllllllllllIIIlllllIlIlII.size() <= llllllllllllllllllIIIlllllIIllIl) {
                        llllllllllllllllllIIIlllllIlIlII.add(-1);
                    }
                    llllllllllllllllllIIIlllllIlIlII.set(llllllllllllllllllIIIlllllIIllIl, llllllllllllllllllIIIlllllIIllII);
                    ++llllllllllllllllllIIIlllllIlIIlI;
                }
                else {
                    warn(String.valueOf(new StringBuilder("Invalid spawn egg color: ").append(llllllllllllllllllIIIlllllIlIIII).append(" = ").append(llllllllllllllllllIIIlllllIIllll)));
                }
            }
        }
        if (llllllllllllllllllIIIlllllIlIIlI <= 0) {
            return null;
        }
        dbg(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllllIIIlllllIIIlll)).append(" colors: ").append(llllllllllllllllllIIIlllllIlIIlI)));
        final int[] llllllllllllllllllIIIlllllIIlIll = new int[llllllllllllllllllIIIlllllIlIlII.size()];
        for (int llllllllllllllllllIIIlllllIIlIlI = 0; llllllllllllllllllIIIlllllIIlIlI < llllllllllllllllllIIIlllllIIlIll.length; ++llllllllllllllllllIIIlllllIIlIlI) {
            llllllllllllllllllIIIlllllIIlIll[llllllllllllllllllIIIlllllIIlIlI] = llllllllllllllllllIIIlllllIlIlII.get(llllllllllllllllllIIIlllllIIlIlI);
        }
        return llllllllllllllllllIIIlllllIIlIll;
    }
    
    public static void updateWaterFX(final EntityFX llllllllllllllllllIIlIIlIIlIlIII, final IBlockAccess llllllllllllllllllIIlIIlIIlIIlll, final double llllllllllllllllllIIlIIlIIlIIllI, final double llllllllllllllllllIIlIIlIIlIIlIl, final double llllllllllllllllllIIlIIlIIllIlIl) {
        if (CustomColors.waterColors != null || CustomColors.blockColormaps != null) {
            final BlockPos llllllllllllllllllIIlIIlIIllIlII = new BlockPos(llllllllllllllllllIIlIIlIIlIIllI, llllllllllllllllllIIlIIlIIlIIlIl, llllllllllllllllllIIlIIlIIllIlIl);
            final RenderEnv llllllllllllllllllIIlIIlIIllIIll = RenderEnv.getInstance(llllllllllllllllllIIlIIlIIlIIlll, CustomColors.BLOCK_STATE_WATER, llllllllllllllllllIIlIIlIIllIlII);
            final int llllllllllllllllllIIlIIlIIllIIlI = getFluidColor(llllllllllllllllllIIlIIlIIlIIlll, CustomColors.BLOCK_STATE_WATER, llllllllllllllllllIIlIIlIIllIlII, llllllllllllllllllIIlIIlIIllIIll);
            final int llllllllllllllllllIIlIIlIIllIIIl = llllllllllllllllllIIlIIlIIllIIlI >> 16 & 0xFF;
            final int llllllllllllllllllIIlIIlIIllIIII = llllllllllllllllllIIlIIlIIllIIlI >> 8 & 0xFF;
            final int llllllllllllllllllIIlIIlIIlIllll = llllllllllllllllllIIlIIlIIllIIlI & 0xFF;
            float llllllllllllllllllIIlIIlIIlIlllI = llllllllllllllllllIIlIIlIIllIIIl / 255.0f;
            float llllllllllllllllllIIlIIlIIlIllIl = llllllllllllllllllIIlIIlIIllIIII / 255.0f;
            float llllllllllllllllllIIlIIlIIlIllII = llllllllllllllllllIIlIIlIIlIllll / 255.0f;
            if (CustomColors.particleWaterColor >= 0) {
                final int llllllllllllllllllIIlIIlIIlIlIll = CustomColors.particleWaterColor >> 16 & 0xFF;
                final int llllllllllllllllllIIlIIlIIlIlIlI = CustomColors.particleWaterColor >> 8 & 0xFF;
                final int llllllllllllllllllIIlIIlIIlIlIIl = CustomColors.particleWaterColor & 0xFF;
                llllllllllllllllllIIlIIlIIlIlllI *= llllllllllllllllllIIlIIlIIlIlIll / 255.0f;
                llllllllllllllllllIIlIIlIIlIllIl *= llllllllllllllllllIIlIIlIIlIlIlI / 255.0f;
                llllllllllllllllllIIlIIlIIlIllII *= llllllllllllllllllIIlIIlIIlIlIIl / 255.0f;
            }
            llllllllllllllllllIIlIIlIIlIlIII.setRBGColorF(llllllllllllllllllIIlIIlIIlIlllI, llllllllllllllllllIIlIIlIIlIllIl, llllllllllllllllllIIlIIlIIlIllII);
        }
    }
    
    public static int getXpOrbColor(final float llllllllllllllllllIIlIIlIlIIllIl) {
        if (CustomColors.xpOrbColors == null) {
            return -1;
        }
        final int llllllllllllllllllIIlIIlIlIIllll = (int)((MathHelper.sin(llllllllllllllllllIIlIIlIlIIllIl) + 1.0f) * (CustomColors.xpOrbColors.getLength() - 1) / 2.0);
        final int llllllllllllllllllIIlIIlIlIIlllI = CustomColors.xpOrbColors.getColor(llllllllllllllllllIIlIIlIlIIllll);
        return llllllllllllllllllIIlIIlIlIIlllI;
    }
    
    private static void warn(final String llllllllllllllllllIIIllIlIlIIIII) {
        Config.warn(String.valueOf(new StringBuilder("CustomColors: ").append(llllllllllllllllllIIIllIlIlIIIII)));
    }
    
    private static CustomColormap[] readCustomColormaps(final Properties llllllllllllllllllIIlIllIllIllIl, final String llllllllllllllllllIIlIllIllIllII) {
        final ArrayList llllllllllllllllllIIlIllIllIlIll = new ArrayList();
        final String llllllllllllllllllIIlIllIllIlIlI = "palette.block.";
        final HashMap llllllllllllllllllIIlIllIllIlIIl = new HashMap();
        final Set llllllllllllllllllIIlIllIllIlIII = llllllllllllllllllIIlIllIllIllIl.keySet();
        for (final String llllllllllllllllllIIlIllIllIIlII : llllllllllllllllllIIlIllIllIlIII) {
            final String llllllllllllllllllIIlIllIllIIllI = llllllllllllllllllIIlIllIllIllIl.getProperty(llllllllllllllllllIIlIllIllIIlII);
            if (llllllllllllllllllIIlIllIllIIlII.startsWith(llllllllllllllllllIIlIllIllIlIlI)) {
                llllllllllllllllllIIlIllIllIlIIl.put(llllllllllllllllllIIlIllIllIIlII, llllllllllllllllllIIlIllIllIIllI);
            }
        }
        final String[] llllllllllllllllllIIlIllIllIIIll = (String[])llllllllllllllllllIIlIllIllIlIIl.keySet().toArray(new String[llllllllllllllllllIIlIllIllIlIIl.size()]);
        for (int llllllllllllllllllIIlIllIllIIIlI = 0; llllllllllllllllllIIlIllIllIIIlI < llllllllllllllllllIIlIllIllIIIll.length; ++llllllllllllllllllIIlIllIllIIIlI) {
            final String llllllllllllllllllIIlIllIllIIlIl = llllllllllllllllllIIlIllIllIIIll[llllllllllllllllllIIlIllIllIIIlI];
            final String llllllllllllllllllIIlIllIllIIIIl = llllllllllllllllllIIlIllIllIllIl.getProperty(llllllllllllllllllIIlIllIllIIlIl);
            dbg(String.valueOf(new StringBuilder("Block palette: ").append(llllllllllllllllllIIlIllIllIIlIl).append(" = ").append(llllllllllllllllllIIlIllIllIIIIl)));
            String llllllllllllllllllIIlIllIllIIIII = llllllllllllllllllIIlIllIllIIlIl.substring(llllllllllllllllllIIlIllIllIlIlI.length());
            final String llllllllllllllllllIIlIllIlIlllll = TextureUtils.getBasePath(llllllllllllllllllIIlIllIllIllII);
            llllllllllllllllllIIlIllIllIIIII = TextureUtils.fixResourcePath(llllllllllllllllllIIlIllIllIIIII, llllllllllllllllllIIlIllIlIlllll);
            final CustomColormap llllllllllllllllllIIlIllIlIllllI = getCustomColors(llllllllllllllllllIIlIllIllIIIII, 256, 256);
            if (llllllllllllllllllIIlIllIlIllllI == null) {
                warn(String.valueOf(new StringBuilder("Colormap not found: ").append(llllllllllllllllllIIlIllIllIIIII)));
            }
            else {
                final ConnectedParser llllllllllllllllllIIlIllIlIlllIl = new ConnectedParser("CustomColors");
                final MatchBlock[] llllllllllllllllllIIlIllIlIlllII = llllllllllllllllllIIlIllIlIlllIl.parseMatchBlocks(llllllllllllllllllIIlIllIllIIIIl);
                if (llllllllllllllllllIIlIllIlIlllII != null && llllllllllllllllllIIlIllIlIlllII.length > 0) {
                    for (int llllllllllllllllllIIlIllIlIllIll = 0; llllllllllllllllllIIlIllIlIllIll < llllllllllllllllllIIlIllIlIlllII.length; ++llllllllllllllllllIIlIllIlIllIll) {
                        final MatchBlock llllllllllllllllllIIlIllIlIllIlI = llllllllllllllllllIIlIllIlIlllII[llllllllllllllllllIIlIllIlIllIll];
                        llllllllllllllllllIIlIllIlIllllI.addMatchBlock(llllllllllllllllllIIlIllIlIllIlI);
                    }
                    llllllllllllllllllIIlIllIllIlIll.add(llllllllllllllllllIIlIllIlIllllI);
                }
                else {
                    warn(String.valueOf(new StringBuilder("Invalid match blocks: ").append(llllllllllllllllllIIlIllIllIIIIl)));
                }
            }
        }
        if (llllllllllllllllllIIlIllIllIlIll.size() <= 0) {
            return null;
        }
        final CustomColormap[] llllllllllllllllllIIlIllIlIllIIl = llllllllllllllllllIIlIllIllIlIll.toArray(new CustomColormap[llllllllllllllllllIIlIllIllIlIll.size()]);
        return llllllllllllllllllIIlIllIlIllIIl;
    }
    
    public static Vec3 getWorldSkyColor(Vec3 llllllllllllllllllIIIllllllIlIIl, final WorldClient llllllllllllllllllIIIllllllIlIII, final Entity llllllllllllllllllIIIllllllIIlll, final float llllllllllllllllllIIIllllllIllII) {
        final int llllllllllllllllllIIIllllllIlIll = llllllllllllllllllIIIllllllIlIII.provider.getDimensionId();
        switch (llllllllllllllllllIIIllllllIlIll) {
            case 0: {
                final Minecraft llllllllllllllllllIIIllllllIlIlI = Minecraft.getMinecraft();
                llllllllllllllllllIIIllllllIlIIl = getSkyColor(llllllllllllllllllIIIllllllIlIIl, llllllllllllllllllIIIllllllIlIlI.theWorld, llllllllllllllllllIIIllllllIIlll.posX, llllllllllllllllllIIIllllllIIlll.posY + 1.0, llllllllllllllllllIIIllllllIIlll.posZ);
                break;
            }
            case 1: {
                llllllllllllllllllIIIllllllIlIIl = getSkyColorEnd(llllllllllllllllllIIIllllllIlIIl);
                break;
            }
        }
        return llllllllllllllllllIIIllllllIlIIl;
    }
    
    private static void dbg(final String llllllllllllllllllIIIllIlIlIIlII) {
        Config.dbg(String.valueOf(new StringBuilder("CustomColors: ").append(llllllllllllllllllIIIllIlIlIIlII)));
    }
    
    public static void updateMyceliumFX(final EntityFX llllllllllllllllllIIlIIllIlIIlIl) {
        if (CustomColors.myceliumParticleColors != null) {
            final int llllllllllllllllllIIlIIllIlIIlII = CustomColors.myceliumParticleColors.getColorRandom();
            final int llllllllllllllllllIIlIIllIlIIIll = llllllllllllllllllIIlIIllIlIIlII >> 16 & 0xFF;
            final int llllllllllllllllllIIlIIllIlIIIlI = llllllllllllllllllIIlIIllIlIIlII >> 8 & 0xFF;
            final int llllllllllllllllllIIlIIllIlIIIIl = llllllllllllllllllIIlIIllIlIIlII & 0xFF;
            final float llllllllllllllllllIIlIIllIlIIIII = llllllllllllllllllIIlIIllIlIIIll / 255.0f;
            final float llllllllllllllllllIIlIIllIIlllll = llllllllllllllllllIIlIIllIlIIIlI / 255.0f;
            final float llllllllllllllllllIIlIIllIIllllI = llllllllllllllllllIIlIIllIlIIIIl / 255.0f;
            llllllllllllllllllIIlIIllIlIIlIl.setRBGColorF(llllllllllllllllllIIlIIllIlIIIII, llllllllllllllllllIIlIIllIIlllll, llllllllllllllllllIIlIIllIIllllI);
        }
    }
    
    public static Vec3 getWorldFogColor(Vec3 llllllllllllllllllIIIllllllllIIl, final WorldClient llllllllllllllllllIIIllllllllIII, final Entity llllllllllllllllllIIIlllllllIlll, final float llllllllllllllllllIIIlllllllllII) {
        final int llllllllllllllllllIIIllllllllIll = llllllllllllllllllIIIllllllllIII.provider.getDimensionId();
        switch (llllllllllllllllllIIIllllllllIll) {
            case -1: {
                llllllllllllllllllIIIllllllllIIl = getFogColorNether((Vec3)llllllllllllllllllIIIllllllllIIl);
                break;
            }
            case 0: {
                final Minecraft llllllllllllllllllIIIllllllllIlI = Minecraft.getMinecraft();
                llllllllllllllllllIIIllllllllIIl = getFogColor((Vec3)llllllllllllllllllIIIllllllllIIl, llllllllllllllllllIIIllllllllIlI.theWorld, llllllllllllllllllIIIlllllllIlll.posX, llllllllllllllllllIIIlllllllIlll.posY + 1.0, llllllllllllllllllIIIlllllllIlll.posZ);
                break;
            }
            case 1: {
                llllllllllllllllllIIIllllllllIIl = getFogColorEnd((Vec3)llllllllllllllllllIIIllllllllIIl);
                break;
            }
        }
        return (Vec3)llllllllllllllllllIIIllllllllIIl;
    }
    
    public static void updatePortalFX(final EntityFX llllllllllllllllllIIlIIllIllIlIl) {
        if (CustomColors.particlePortalColor >= 0) {
            final int llllllllllllllllllIIlIIllIllllII = CustomColors.particlePortalColor;
            final int llllllllllllllllllIIlIIllIlllIll = llllllllllllllllllIIlIIllIllllII >> 16 & 0xFF;
            final int llllllllllllllllllIIlIIllIlllIlI = llllllllllllllllllIIlIIllIllllII >> 8 & 0xFF;
            final int llllllllllllllllllIIlIIllIlllIIl = llllllllllllllllllIIlIIllIllllII & 0xFF;
            final float llllllllllllllllllIIlIIllIlllIII = llllllllllllllllllIIlIIllIlllIll / 255.0f;
            final float llllllllllllllllllIIlIIllIllIlll = llllllllllllllllllIIlIIllIlllIlI / 255.0f;
            final float llllllllllllllllllIIlIIllIllIllI = llllllllllllllllllIIlIIllIlllIIl / 255.0f;
            llllllllllllllllllIIlIIllIllIlIl.setRBGColorF(llllllllllllllllllIIlIIllIlllIII, llllllllllllllllllIIlIIllIllIlll, llllllllllllllllllIIlIIllIllIllI);
        }
    }
    
    private static int getSmoothColorMultiplier(final IBlockAccess llllllllllllllllllIIlIIllllIIlIl, final BlockPos llllllllllllllllllIIlIIllllIIlII, final IColorizer llllllllllllllllllIIlIIllllIIIll, final BlockPosM llllllllllllllllllIIlIIlllllIIlI) {
        int llllllllllllllllllIIlIIlllllIIIl = 0;
        int llllllllllllllllllIIlIIlllllIIII = 0;
        int llllllllllllllllllIIlIIllllIllll = 0;
        final int llllllllllllllllllIIlIIllllIlllI = llllllllllllllllllIIlIIllllIIlII.getX();
        final int llllllllllllllllllIIlIIllllIllIl = llllllllllllllllllIIlIIllllIIlII.getY();
        final int llllllllllllllllllIIlIIllllIllII = llllllllllllllllllIIlIIllllIIlII.getZ();
        final BlockPosM llllllllllllllllllIIlIIllllIlIll = llllllllllllllllllIIlIIlllllIIlI;
        for (int llllllllllllllllllIIlIIllllIlIlI = llllllllllllllllllIIlIIllllIlllI - 1; llllllllllllllllllIIlIIllllIlIlI <= llllllllllllllllllIIlIIllllIlllI + 1; ++llllllllllllllllllIIlIIllllIlIlI) {
            for (int llllllllllllllllllIIlIIllllIlIIl = llllllllllllllllllIIlIIllllIllII - 1; llllllllllllllllllIIlIIllllIlIIl <= llllllllllllllllllIIlIIllllIllII + 1; ++llllllllllllllllllIIlIIllllIlIIl) {
                llllllllllllllllllIIlIIllllIlIll.setXyz(llllllllllllllllllIIlIIllllIlIlI, llllllllllllllllllIIlIIllllIllIl, llllllllllllllllllIIlIIllllIlIIl);
                final int llllllllllllllllllIIlIIllllIIlll = llllllllllllllllllIIlIIllllIIIll.getColor(llllllllllllllllllIIlIIllllIIlIl, llllllllllllllllllIIlIIllllIlIll);
                llllllllllllllllllIIlIIlllllIIIl += (llllllllllllllllllIIlIIllllIIlll >> 16 & 0xFF);
                llllllllllllllllllIIlIIlllllIIII += (llllllllllllllllllIIlIIllllIIlll >> 8 & 0xFF);
                llllllllllllllllllIIlIIllllIllll += (llllllllllllllllllIIlIIllllIIlll & 0xFF);
            }
        }
        int llllllllllllllllllIIlIIllllIlIlI = llllllllllllllllllIIlIIlllllIIIl / 9;
        final int llllllllllllllllllIIlIIllllIlIII = llllllllllllllllllIIlIIlllllIIII / 9;
        final int llllllllllllllllllIIlIIllllIIllI = llllllllllllllllllIIlIIllllIllll / 9;
        return llllllllllllllllllIIlIIllllIlIlI << 16 | llllllllllllllllllIIlIIllllIlIII << 8 | llllllllllllllllllIIlIIllllIIllI;
    }
    
    private static Vec3 getFogColorNether(final Vec3 llllllllllllllllllIIlIIlIIIIllll) {
        return (CustomColors.fogColorNether == null) ? llllllllllllllllllIIlIIlIIIIllll : CustomColors.fogColorNether;
    }
    
    private static Vec3 getFogColor(final Vec3 llllllllllllllllllIIlIIIllIIlIII, final IBlockAccess llllllllllllllllllIIlIIIllIIIlll, final double llllllllllllllllllIIlIIIllIIIllI, final double llllllllllllllllllIIlIIIlIllIlIl, final double llllllllllllllllllIIlIIIlIllIlII) {
        if (CustomColors.fogColors == null) {
            return llllllllllllllllllIIlIIIllIIlIII;
        }
        final int llllllllllllllllllIIlIIIllIIIIll = CustomColors.fogColors.getColorSmooth(llllllllllllllllllIIlIIIllIIIlll, llllllllllllllllllIIlIIIllIIIllI, llllllllllllllllllIIlIIIlIllIlIl, llllllllllllllllllIIlIIIlIllIlII, 3);
        final int llllllllllllllllllIIlIIIllIIIIlI = llllllllllllllllllIIlIIIllIIIIll >> 16 & 0xFF;
        final int llllllllllllllllllIIlIIIllIIIIIl = llllllllllllllllllIIlIIIllIIIIll >> 8 & 0xFF;
        final int llllllllllllllllllIIlIIIllIIIIII = llllllllllllllllllIIlIIIllIIIIll & 0xFF;
        float llllllllllllllllllIIlIIIlIllllll = llllllllllllllllllIIlIIIllIIIIlI / 255.0f;
        float llllllllllllllllllIIlIIIlIlllllI = llllllllllllllllllIIlIIIllIIIIIl / 255.0f;
        float llllllllllllllllllIIlIIIlIllllIl = llllllllllllllllllIIlIIIllIIIIII / 255.0f;
        final float llllllllllllllllllIIlIIIlIllllII = (float)llllllllllllllllllIIlIIIllIIlIII.xCoord / 0.753f;
        final float llllllllllllllllllIIlIIIlIlllIll = (float)llllllllllllllllllIIlIIIllIIlIII.yCoord / 0.8471f;
        final float llllllllllllllllllIIlIIIlIlllIlI = (float)llllllllllllllllllIIlIIIllIIlIII.zCoord;
        llllllllllllllllllIIlIIIlIllllll *= llllllllllllllllllIIlIIIlIllllII;
        llllllllllllllllllIIlIIIlIlllllI *= llllllllllllllllllIIlIIIlIlllIll;
        llllllllllllllllllIIlIIIlIllllIl *= llllllllllllllllllIIlIIIlIlllIlI;
        final Vec3 llllllllllllllllllIIlIIIlIlllIIl = CustomColors.fogColorFader.getColor(llllllllllllllllllIIlIIIlIllllll, llllllllllllllllllIIlIIIlIlllllI, llllllllllllllllllIIlIIIlIllllIl);
        return llllllllllllllllllIIlIIIlIlllIIl;
    }
    
    private static int getStemColorMultiplier(final Block llllllllllllllllllIIlIIIlIIIIIII, final IBlockAccess llllllllllllllllllIIlIIIIlllllll, final BlockPos llllllllllllllllllIIlIIIIllllllI, final RenderEnv llllllllllllllllllIIlIIIIllllIIl) {
        CustomColormap llllllllllllllllllIIlIIIIlllllII = CustomColors.stemColors;
        if (llllllllllllllllllIIlIIIlIIIIIII == Blocks.pumpkin_stem && CustomColors.stemPumpkinColors != null) {
            llllllllllllllllllIIlIIIIlllllII = CustomColors.stemPumpkinColors;
        }
        if (llllllllllllllllllIIlIIIlIIIIIII == Blocks.melon_stem && CustomColors.stemMelonColors != null) {
            llllllllllllllllllIIlIIIIlllllII = CustomColors.stemMelonColors;
        }
        if (llllllllllllllllllIIlIIIIlllllII == null) {
            return -1;
        }
        final int llllllllllllllllllIIlIIIIllllIll = llllllllllllllllllIIlIIIIllllIIl.getMetadata();
        return llllllllllllllllllIIlIIIIlllllII.getColor(llllllllllllllllllIIlIIIIllllIll);
    }
    
    public static int getPotionColor(final int llllllllllllllllllIIIllIllIlIIlI, final int llllllllllllllllllIIIllIllIIlllI) {
        if (CustomColors.potionColors == null) {
            return llllllllllllllllllIIIllIllIIlllI;
        }
        if (llllllllllllllllllIIIllIllIlIIlI >= 0 && llllllllllllllllllIIIllIllIlIIlI < CustomColors.potionColors.length) {
            final int llllllllllllllllllIIIllIllIlIIII = CustomColors.potionColors[llllllllllllllllllIIIllIllIlIIlI];
            return (llllllllllllllllllIIIllIllIlIIII < 0) ? llllllllllllllllllIIIllIllIIlllI : llllllllllllllllllIIIllIllIlIIII;
        }
        return llllllllllllllllllIIIllIllIIlllI;
    }
    
    private static void readColorProperties(final String llllllllllllllllllIIlIlllIIIIlII) {
        try {
            final ResourceLocation llllllllllllllllllIIlIlllIIIlIlI = new ResourceLocation(llllllllllllllllllIIlIlllIIIIlII);
            final InputStream llllllllllllllllllIIlIlllIIIlIIl = Config.getResourceStream(llllllllllllllllllIIlIlllIIIlIlI);
            if (llllllllllllllllllIIlIlllIIIlIIl == null) {
                return;
            }
            dbg(String.valueOf(new StringBuilder("Loading ").append(llllllllllllllllllIIlIlllIIIIlII)));
            final Properties llllllllllllllllllIIlIlllIIIlIII = new Properties();
            llllllllllllllllllIIlIlllIIIlIII.load(llllllllllllllllllIIlIlllIIIlIIl);
            llllllllllllllllllIIlIlllIIIlIIl.close();
            CustomColors.particleWaterColor = readColor(llllllllllllllllllIIlIlllIIIlIII, new String[] { "particle.water", "drop.water" });
            CustomColors.particlePortalColor = readColor(llllllllllllllllllIIlIlllIIIlIII, "particle.portal");
            CustomColors.lilyPadColor = readColor(llllllllllllllllllIIlIlllIIIlIII, "lilypad");
            CustomColors.expBarTextColor = readColor(llllllllllllllllllIIlIlllIIIlIII, "text.xpbar");
            CustomColors.bossTextColor = readColor(llllllllllllllllllIIlIlllIIIlIII, "text.boss");
            CustomColors.signTextColor = readColor(llllllllllllllllllIIlIlllIIIlIII, "text.sign");
            CustomColors.fogColorNether = readColorVec3(llllllllllllllllllIIlIlllIIIlIII, "fog.nether");
            CustomColors.fogColorEnd = readColorVec3(llllllllllllllllllIIlIlllIIIlIII, "fog.end");
            CustomColors.skyColorEnd = readColorVec3(llllllllllllllllllIIlIlllIIIlIII, "sky.end");
            CustomColors.colorsBlockColormaps = readCustomColormaps(llllllllllllllllllIIlIlllIIIlIII, llllllllllllllllllIIlIlllIIIIlII);
            CustomColors.spawnEggPrimaryColors = readSpawnEggColors(llllllllllllllllllIIlIlllIIIlIII, llllllllllllllllllIIlIlllIIIIlII, "egg.shell.", "Spawn egg shell");
            CustomColors.spawnEggSecondaryColors = readSpawnEggColors(llllllllllllllllllIIlIlllIIIlIII, llllllllllllllllllIIlIlllIIIIlII, "egg.spots.", "Spawn egg spot");
            CustomColors.wolfCollarColors = readDyeColors(llllllllllllllllllIIlIlllIIIlIII, llllllllllllllllllIIlIlllIIIIlII, "collar.", "Wolf collar");
            CustomColors.sheepColors = readDyeColors(llllllllllllllllllIIlIlllIIIlIII, llllllllllllllllllIIlIlllIIIIlII, "sheep.", "Sheep");
            CustomColors.textColors = readTextColors(llllllllllllllllllIIlIlllIIIlIII, llllllllllllllllllIIlIlllIIIIlII, "text.code.", "Text");
            final int[] llllllllllllllllllIIlIlllIIIIlll = readMapColors(llllllllllllllllllIIlIlllIIIlIII, llllllllllllllllllIIlIlllIIIIlII, "map.", "Map");
            if (llllllllllllllllllIIlIlllIIIIlll != null) {
                if (CustomColors.mapColorsOriginal == null) {
                    CustomColors.mapColorsOriginal = getMapColors();
                }
                setMapColors(llllllllllllllllllIIlIlllIIIIlll);
            }
            CustomColors.potionColors = readPotionColors(llllllllllllllllllIIlIlllIIIlIII, llllllllllllllllllIIlIlllIIIIlII, "potion.", "Potion");
        }
        catch (FileNotFoundException llllllllllllllllllIIlIlllIIIIllI) {}
        catch (IOException llllllllllllllllllIIlIlllIIIIlIl) {
            llllllllllllllllllIIlIlllIIIIlIl.printStackTrace();
        }
    }
    
    private static int getSpawnEggColor(final ItemMonsterPlacer llllllllllllllllllIIIllllIllIlll, final ItemStack llllllllllllllllllIIIllllIllIllI, final int llllllllllllllllllIIIllllIllIlIl, final int llllllllllllllllllIIIllllIllIlII) {
        final int llllllllllllllllllIIIllllIllIIll = llllllllllllllllllIIIllllIllIllI.getMetadata();
        final int[] llllllllllllllllllIIIllllIllIIlI = (llllllllllllllllllIIIllllIllIlIl == 0) ? CustomColors.spawnEggPrimaryColors : CustomColors.spawnEggSecondaryColors;
        if (llllllllllllllllllIIIllllIllIIlI == null) {
            return llllllllllllllllllIIIllllIllIlII;
        }
        if (llllllllllllllllllIIIllllIllIIll >= 0 && llllllllllllllllllIIIllllIllIIll < llllllllllllllllllIIIllllIllIIlI.length) {
            final int llllllllllllllllllIIIllllIllIIIl = llllllllllllllllllIIIllllIllIIlI[llllllllllllllllllIIIllllIllIIll];
            return (llllllllllllllllllIIIllllIllIIIl < 0) ? llllllllllllllllllIIIllllIllIlII : llllllllllllllllllIIIllllIllIIIl;
        }
        return llllllllllllllllllIIIllllIllIlII;
    }
    
    private static int parseColor(String llllllllllllllllllIIlIlIllIlIlll) {
        if (llllllllllllllllllIIlIlIllIlIlll == null) {
            return -1;
        }
        llllllllllllllllllIIlIlIllIlIlll = llllllllllllllllllIIlIlIllIlIlll.trim();
        try {
            final int llllllllllllllllllIIlIlIllIlIllI = Integer.parseInt(llllllllllllllllllIIlIlIllIlIlll, 16) & 0xFFFFFF;
            return llllllllllllllllllIIlIlIllIlIllI;
        }
        catch (NumberFormatException llllllllllllllllllIIlIlIllIlIlIl) {
            return -1;
        }
    }
    
    public static int getColorFromItemStack(final ItemStack llllllllllllllllllIIIllllIlIIIlI, final int llllllllllllllllllIIIllllIlIIlIl, final int llllllllllllllllllIIIllllIlIIlII) {
        if (llllllllllllllllllIIIllllIlIIIlI == null) {
            return llllllllllllllllllIIIllllIlIIlII;
        }
        final Item llllllllllllllllllIIIllllIlIIIll = llllllllllllllllllIIIllllIlIIIlI.getItem();
        return (llllllllllllllllllIIIllllIlIIIll == null) ? llllllllllllllllllIIIllllIlIIlII : ((llllllllllllllllllIIIllllIlIIIll instanceof ItemMonsterPlacer) ? getSpawnEggColor((ItemMonsterPlacer)llllllllllllllllllIIIllllIlIIIll, llllllllllllllllllIIIllllIlIIIlI, llllllllllllllllllIIIllllIlIIlIl, llllllllllllllllllIIIllllIlIIlII) : llllllllllllllllllIIIllllIlIIlII);
    }
    
    public static Vec3 getUnderwaterColor(final IBlockAccess llllllllllllllllllIIlIIIlIIlIIII, final double llllllllllllllllllIIlIIIlIIllIll, final double llllllllllllllllllIIlIIIlIIllIlI, final double llllllllllllllllllIIlIIIlIIIllIl) {
        if (CustomColors.underwaterColors == null) {
            return null;
        }
        final int llllllllllllllllllIIlIIIlIIllIII = CustomColors.underwaterColors.getColorSmooth(llllllllllllllllllIIlIIIlIIlIIII, llllllllllllllllllIIlIIIlIIllIll, llllllllllllllllllIIlIIIlIIllIlI, llllllllllllllllllIIlIIIlIIIllIl, 3);
        final int llllllllllllllllllIIlIIIlIIlIlll = llllllllllllllllllIIlIIIlIIllIII >> 16 & 0xFF;
        final int llllllllllllllllllIIlIIIlIIlIllI = llllllllllllllllllIIlIIIlIIllIII >> 8 & 0xFF;
        final int llllllllllllllllllIIlIIIlIIlIlIl = llllllllllllllllllIIlIIIlIIllIII & 0xFF;
        final float llllllllllllllllllIIlIIIlIIlIlII = llllllllllllllllllIIlIIIlIIlIlll / 255.0f;
        final float llllllllllllllllllIIlIIIlIIlIIll = llllllllllllllllllIIlIIIlIIlIllI / 255.0f;
        final float llllllllllllllllllIIlIIIlIIlIIlI = llllllllllllllllllIIlIIIlIIlIlIl / 255.0f;
        final Vec3 llllllllllllllllllIIlIIIlIIlIIIl = CustomColors.underwaterColorFader.getColor(llllllllllllllllllIIlIIIlIIlIlII, llllllllllllllllllIIlIIIlIIlIIll, llllllllllllllllllIIlIIIlIIlIIlI);
        return llllllllllllllllllIIlIIIlIIlIIIl;
    }
    
    private static void addToList(final CustomColormap llllllllllllllllllIIlIllIIIIlIll, final List llllllllllllllllllIIlIllIIIIIllI, final int llllllllllllllllllIIlIllIIIIlIIl) {
        while (llllllllllllllllllIIlIllIIIIlIIl >= llllllllllllllllllIIlIllIIIIIllI.size()) {
            llllllllllllllllllIIlIllIIIIIllI.add(null);
        }
        Object llllllllllllllllllIIlIllIIIIlIII = llllllllllllllllllIIlIllIIIIIllI.get(llllllllllllllllllIIlIllIIIIlIIl);
        if (llllllllllllllllllIIlIllIIIIlIII == null) {
            llllllllllllllllllIIlIllIIIIlIII = new ArrayList();
            llllllllllllllllllIIlIllIIIIIllI.set(llllllllllllllllllIIlIllIIIIlIIl, llllllllllllllllllIIlIllIIIIlIII);
        }
        ((List)llllllllllllllllllIIlIllIIIIlIII).add(llllllllllllllllllIIlIllIIIIlIll);
    }
    
    private static int[] readPotionColors(final Properties llllllllllllllllllIIIllIlllIllII, final String llllllllllllllllllIIIllIllllIlll, final String llllllllllllllllllIIIllIllllIllI, final String llllllllllllllllllIIIllIlllIlIlI) {
        final int[] llllllllllllllllllIIIllIllllIlII = new int[Potion.potionTypes.length];
        Arrays.fill(llllllllllllllllllIIIllIllllIlII, -1);
        int llllllllllllllllllIIIllIllllIIll = 0;
        final Set llllllllllllllllllIIIllIllllIIlI = llllllllllllllllllIIIllIlllIllII.keySet();
        for (final String llllllllllllllllllIIIllIllllIIII : llllllllllllllllllIIIllIllllIIlI) {
            final String llllllllllllllllllIIIllIlllIllll = llllllllllllllllllIIIllIlllIllII.getProperty(llllllllllllllllllIIIllIllllIIII);
            if (llllllllllllllllllIIIllIllllIIII.startsWith(llllllllllllllllllIIIllIllllIllI)) {
                final int llllllllllllllllllIIIllIlllIlllI = getPotionId(llllllllllllllllllIIIllIllllIIII);
                final int llllllllllllllllllIIIllIlllIllIl = parseColor(llllllllllllllllllIIIllIlllIllll);
                if (llllllllllllllllllIIIllIlllIlllI >= 0 && llllllllllllllllllIIIllIlllIlllI < llllllllllllllllllIIIllIllllIlII.length && llllllllllllllllllIIIllIlllIllIl >= 0) {
                    llllllllllllllllllIIIllIllllIlII[llllllllllllllllllIIIllIlllIlllI] = llllllllllllllllllIIIllIlllIllIl;
                    ++llllllllllllllllllIIIllIllllIIll;
                }
                else {
                    warn(String.valueOf(new StringBuilder("Invalid color: ").append(llllllllllllllllllIIIllIllllIIII).append(" = ").append(llllllllllllllllllIIIllIlllIllll)));
                }
            }
        }
        if (llllllllllllllllllIIIllIllllIIll <= 0) {
            return null;
        }
        dbg(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllllIIIllIlllIlIlI)).append(" colors: ").append(llllllllllllllllllIIIllIllllIIll)));
        return llllllllllllllllllIIIllIllllIlII;
    }
    
    public static CustomColormap getCustomColors(final String llllllllllllllllllIIlIlIlIIllIlI, final int llllllllllllllllllIIlIlIlIIllIIl, final int llllllllllllllllllIIlIlIlIIllIII) {
        try {
            final ResourceLocation llllllllllllllllllIIlIlIlIIlIlll = new ResourceLocation(llllllllllllllllllIIlIlIlIIllIlI);
            if (!Config.hasResource(llllllllllllllllllIIlIlIlIIlIlll)) {
                return null;
            }
            dbg(String.valueOf(new StringBuilder("Colormap ").append(llllllllllllllllllIIlIlIlIIllIlI)));
            final Properties llllllllllllllllllIIlIlIlIIlIllI = new Properties();
            String llllllllllllllllllIIlIlIlIIlIlIl = StrUtils.replaceSuffix(llllllllllllllllllIIlIlIlIIllIlI, ".png", ".properties");
            final ResourceLocation llllllllllllllllllIIlIlIlIIlIlII = new ResourceLocation(llllllllllllllllllIIlIlIlIIlIlIl);
            if (Config.hasResource(llllllllllllllllllIIlIlIlIIlIlII)) {
                final InputStream llllllllllllllllllIIlIlIlIIlIIll = Config.getResourceStream(llllllllllllllllllIIlIlIlIIlIlII);
                llllllllllllllllllIIlIlIlIIlIllI.load(llllllllllllllllllIIlIlIlIIlIIll);
                llllllllllllllllllIIlIlIlIIlIIll.close();
                dbg(String.valueOf(new StringBuilder("Colormap properties: ").append(llllllllllllllllllIIlIlIlIIlIlIl)));
            }
            else {
                ((Hashtable<String, String>)llllllllllllllllllIIlIlIlIIlIllI).put("format", "vanilla");
                ((Hashtable<String, String>)llllllllllllllllllIIlIlIlIIlIllI).put("source", llllllllllllllllllIIlIlIlIIllIlI);
                llllllllllllllllllIIlIlIlIIlIlIl = llllllllllllllllllIIlIlIlIIllIlI;
            }
            final CustomColormap llllllllllllllllllIIlIlIlIIlIIlI = new CustomColormap(llllllllllllllllllIIlIlIlIIlIllI, llllllllllllllllllIIlIlIlIIlIlIl, llllllllllllllllllIIlIlIlIIllIIl, llllllllllllllllllIIlIlIlIIllIII);
            return llllllllllllllllllIIlIlIlIIlIIlI.isValid(llllllllllllllllllIIlIlIlIIlIlIl) ? llllllllllllllllllIIlIlIlIIlIIlI : null;
        }
        catch (Exception llllllllllllllllllIIlIlIlIIlIIIl) {
            llllllllllllllllllIIlIlIlIIlIIIl.printStackTrace();
            return null;
        }
    }
    
    private static float[][] readDyeColors(final Properties llllllllllllllllllIIIllllIIIllll, final String llllllllllllllllllIIIllllIIIlllI, final String llllllllllllllllllIIIlllIlllllII, final String llllllllllllllllllIIIlllIllllIll) {
        final EnumDyeColor[] llllllllllllllllllIIIllllIIIlIll = EnumDyeColor.values();
        final HashMap llllllllllllllllllIIIllllIIIlIlI = new HashMap();
        for (int llllllllllllllllllIIIllllIIIlIIl = 0; llllllllllllllllllIIIllllIIIlIIl < llllllllllllllllllIIIllllIIIlIll.length; ++llllllllllllllllllIIIllllIIIlIIl) {
            final EnumDyeColor llllllllllllllllllIIIllllIIIlIII = llllllllllllllllllIIIllllIIIlIll[llllllllllllllllllIIIllllIIIlIIl];
            llllllllllllllllllIIIllllIIIlIlI.put(llllllllllllllllllIIIllllIIIlIII.getName(), llllllllllllllllllIIIllllIIIlIII);
        }
        final float[][] llllllllllllllllllIIIllllIIIIlll = new float[llllllllllllllllllIIIllllIIIlIll.length][];
        int llllllllllllllllllIIIllllIIIIllI = 0;
        final Set llllllllllllllllllIIIllllIIIIlIl = llllllllllllllllllIIIllllIIIllll.keySet();
        for (final String llllllllllllllllllIIIllllIIIIIll : llllllllllllllllllIIIllllIIIIlIl) {
            final String llllllllllllllllllIIIllllIIIIIlI = llllllllllllllllllIIIllllIIIllll.getProperty(llllllllllllllllllIIIllllIIIIIll);
            if (llllllllllllllllllIIIllllIIIIIll.startsWith(llllllllllllllllllIIIlllIlllllII)) {
                String llllllllllllllllllIIIllllIIIIIIl = StrUtils.removePrefix(llllllllllllllllllIIIllllIIIIIll, llllllllllllllllllIIIlllIlllllII);
                if (llllllllllllllllllIIIllllIIIIIIl.equals("lightBlue")) {
                    llllllllllllllllllIIIllllIIIIIIl = "light_blue";
                }
                final EnumDyeColor llllllllllllllllllIIIllllIIIIIII = llllllllllllllllllIIIllllIIIlIlI.get(llllllllllllllllllIIIllllIIIIIIl);
                final int llllllllllllllllllIIIlllIlllllll = parseColor(llllllllllllllllllIIIllllIIIIIlI);
                if (llllllllllllllllllIIIllllIIIIIII != null && llllllllllllllllllIIIlllIlllllll >= 0) {
                    final float[] llllllllllllllllllIIIlllIllllllI = { (llllllllllllllllllIIIlllIlllllll >> 16 & 0xFF) / 255.0f, (llllllllllllllllllIIIlllIlllllll >> 8 & 0xFF) / 255.0f, (llllllllllllllllllIIIlllIlllllll & 0xFF) / 255.0f };
                    llllllllllllllllllIIIllllIIIIlll[llllllllllllllllllIIIllllIIIIIII.ordinal()] = llllllllllllllllllIIIlllIllllllI;
                    ++llllllllllllllllllIIIllllIIIIllI;
                }
                else {
                    warn(String.valueOf(new StringBuilder("Invalid color: ").append(llllllllllllllllllIIIllllIIIIIll).append(" = ").append(llllllllllllllllllIIIllllIIIIIlI)));
                }
            }
        }
        if (llllllllllllllllllIIIllllIIIIllI <= 0) {
            return null;
        }
        dbg(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllllIIIlllIllllIll)).append(" colors: ").append(llllllllllllllllllIIIllllIIIIllI)));
        return llllllllllllllllllIIIllllIIIIlll;
    }
    
    private static float[] getDyeColors(final EnumDyeColor llllllllllllllllllIIIlllIllIlIlI, final float[][] llllllllllllllllllIIIlllIllIIlIl, final float[] llllllllllllllllllIIIlllIllIlIII) {
        if (llllllllllllllllllIIIlllIllIIlIl == null) {
            return llllllllllllllllllIIIlllIllIlIII;
        }
        if (llllllllllllllllllIIIlllIllIlIlI == null) {
            return llllllllllllllllllIIIlllIllIlIII;
        }
        final float[] llllllllllllllllllIIIlllIllIIlll = llllllllllllllllllIIIlllIllIIlIl[llllllllllllllllllIIIlllIllIlIlI.ordinal()];
        return (llllllllllllllllllIIIlllIllIIlll == null) ? llllllllllllllllllIIIlllIllIlIII : llllllllllllllllllIIIlllIllIIlll;
    }
    
    public static void update() {
        CustomColors.waterColors = null;
        CustomColors.foliageBirchColors = null;
        CustomColors.foliagePineColors = null;
        CustomColors.swampGrassColors = null;
        CustomColors.swampFoliageColors = null;
        CustomColors.skyColors = null;
        CustomColors.fogColors = null;
        CustomColors.underwaterColors = null;
        CustomColors.redstoneColors = null;
        CustomColors.xpOrbColors = null;
        CustomColors.stemColors = null;
        CustomColors.myceliumParticleColors = null;
        CustomColors.lightMapsColorsRgb = null;
        CustomColors.particleWaterColor = -1;
        CustomColors.particlePortalColor = -1;
        CustomColors.lilyPadColor = -1;
        CustomColors.expBarTextColor = -1;
        CustomColors.bossTextColor = -1;
        CustomColors.signTextColor = -1;
        CustomColors.fogColorNether = null;
        CustomColors.fogColorEnd = null;
        CustomColors.skyColorEnd = null;
        CustomColors.colorsBlockColormaps = null;
        CustomColors.blockColormaps = null;
        CustomColors.useDefaultGrassFoliageColors = true;
        CustomColors.spawnEggPrimaryColors = null;
        CustomColors.spawnEggSecondaryColors = null;
        CustomColors.wolfCollarColors = null;
        CustomColors.sheepColors = null;
        CustomColors.textColors = null;
        setMapColors(CustomColors.mapColorsOriginal);
        CustomColors.potionColors = null;
        PotionHelper.clearPotionColorCache();
        final String llllllllllllllllllIIlIlllllIlIII = "mcpatcher/colormap/";
        final String[] llllllllllllllllllIIlIlllllIIlll = { "water.png", "watercolorX.png" };
        CustomColors.waterColors = getCustomColors(llllllllllllllllllIIlIlllllIlIII, llllllllllllllllllIIlIlllllIIlll, 256, 256);
        updateUseDefaultGrassFoliageColors();
        if (Config.isCustomColors()) {
            final String[] llllllllllllllllllIIlIlllllIIllI = { "pine.png", "pinecolor.png" };
            CustomColors.foliagePineColors = getCustomColors(llllllllllllllllllIIlIlllllIlIII, llllllllllllllllllIIlIlllllIIllI, 256, 256);
            final String[] llllllllllllllllllIIlIlllllIIlIl = { "birch.png", "birchcolor.png" };
            CustomColors.foliageBirchColors = getCustomColors(llllllllllllllllllIIlIlllllIlIII, llllllllllllllllllIIlIlllllIIlIl, 256, 256);
            final String[] llllllllllllllllllIIlIlllllIIlII = { "swampgrass.png", "swampgrasscolor.png" };
            CustomColors.swampGrassColors = getCustomColors(llllllllllllllllllIIlIlllllIlIII, llllllllllllllllllIIlIlllllIIlII, 256, 256);
            final String[] llllllllllllllllllIIlIlllllIIIll = { "swampfoliage.png", "swampfoliagecolor.png" };
            CustomColors.swampFoliageColors = getCustomColors(llllllllllllllllllIIlIlllllIlIII, llllllllllllllllllIIlIlllllIIIll, 256, 256);
            final String[] llllllllllllllllllIIlIlllllIIIlI = { "sky0.png", "skycolor0.png" };
            CustomColors.skyColors = getCustomColors(llllllllllllllllllIIlIlllllIlIII, llllllllllllllllllIIlIlllllIIIlI, 256, 256);
            final String[] llllllllllllllllllIIlIlllllIIIIl = { "fog0.png", "fogcolor0.png" };
            CustomColors.fogColors = getCustomColors(llllllllllllllllllIIlIlllllIlIII, llllllllllllllllllIIlIlllllIIIIl, 256, 256);
            final String[] llllllllllllllllllIIlIlllllIIIII = { "underwater.png", "underwatercolor.png" };
            CustomColors.underwaterColors = getCustomColors(llllllllllllllllllIIlIlllllIlIII, llllllllllllllllllIIlIlllllIIIII, 256, 256);
            final String[] llllllllllllllllllIIlIllllIlllll = { "redstone.png", "redstonecolor.png" };
            CustomColors.redstoneColors = getCustomColors(llllllllllllllllllIIlIlllllIlIII, llllllllllllllllllIIlIllllIlllll, 16, 1);
            CustomColors.xpOrbColors = getCustomColors(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllllIIlIlllllIlIII)).append("xporb.png")), -1, -1);
            final String[] llllllllllllllllllIIlIllllIllllI = { "stem.png", "stemcolor.png" };
            CustomColors.stemColors = getCustomColors(llllllllllllllllllIIlIlllllIlIII, llllllllllllllllllIIlIllllIllllI, 8, 1);
            CustomColors.stemPumpkinColors = getCustomColors(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllllIIlIlllllIlIII)).append("pumpkinstem.png")), 8, 1);
            CustomColors.stemMelonColors = getCustomColors(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllllIIlIlllllIlIII)).append("melonstem.png")), 8, 1);
            final String[] llllllllllllllllllIIlIllllIlllIl = { "myceliumparticle.png", "myceliumparticlecolor.png" };
            CustomColors.myceliumParticleColors = getCustomColors(llllllllllllllllllIIlIlllllIlIII, llllllllllllllllllIIlIllllIlllIl, -1, -1);
            final Pair llllllllllllllllllIIlIllllIlllII = parseLightmapsRgb();
            CustomColors.lightMapsColorsRgb = (CustomColormap[])llllllllllllllllllIIlIllllIlllII.getLeft();
            CustomColors.lightmapMinDimensionId = (int)llllllllllllllllllIIlIllllIlllII.getRight();
            readColorProperties("mcpatcher/color.properties");
            CustomColors.blockColormaps = readBlockColormaps(new String[] { String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllllIIlIlllllIlIII)).append("custom/")), String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllllIIlIlllllIlIII)).append("blocks/")) }, CustomColors.colorsBlockColormaps, 256, 256);
            updateUseDefaultGrassFoliageColors();
        }
    }
    
    private static int getPotionId(final String llllllllllllllllllIIIllIllIlllIl) {
        if (llllllllllllllllllIIIllIllIlllIl.equals("potion.water")) {
            return 0;
        }
        final Potion[] llllllllllllllllllIIIllIllIlllII = Potion.potionTypes;
        for (int llllllllllllllllllIIIllIllIllIll = 0; llllllllllllllllllIIIllIllIllIll < llllllllllllllllllIIIllIllIlllII.length; ++llllllllllllllllllIIIllIllIllIll) {
            final Potion llllllllllllllllllIIIllIllIllIlI = llllllllllllllllllIIIllIllIlllII[llllllllllllllllllIIIllIllIllIll];
            if (llllllllllllllllllIIIllIllIllIlI != null && llllllllllllllllllIIIllIllIllIlI.getName().equals(llllllllllllllllllIIIllIllIlllIl)) {
                return llllllllllllllllllIIIllIllIllIlI.getId();
            }
        }
        return -1;
    }
    
    private static int[] readTextColors(final Properties llllllllllllllllllIIIlllIIllllIl, final String llllllllllllllllllIIIlllIlIIlIIl, final String llllllllllllllllllIIIlllIlIIlIII, final String llllllllllllllllllIIIlllIlIIIlll) {
        final int[] llllllllllllllllllIIIlllIlIIIllI = new int[32];
        Arrays.fill(llllllllllllllllllIIIlllIlIIIllI, -1);
        int llllllllllllllllllIIIlllIlIIIlIl = 0;
        final Set llllllllllllllllllIIIlllIlIIIlII = llllllllllllllllllIIIlllIIllllIl.keySet();
        for (final String llllllllllllllllllIIIlllIlIIIIlI : llllllllllllllllllIIIlllIlIIIlII) {
            final String llllllllllllllllllIIIlllIlIIIIIl = llllllllllllllllllIIIlllIIllllIl.getProperty(llllllllllllllllllIIIlllIlIIIIlI);
            if (llllllllllllllllllIIIlllIlIIIIlI.startsWith(llllllllllllllllllIIIlllIlIIlIII)) {
                final String llllllllllllllllllIIIlllIlIIIIII = StrUtils.removePrefix(llllllllllllllllllIIIlllIlIIIIlI, llllllllllllllllllIIIlllIlIIlIII);
                final int llllllllllllllllllIIIlllIIllllll = Config.parseInt(llllllllllllllllllIIIlllIlIIIIII, -1);
                final int llllllllllllllllllIIIlllIIlllllI = parseColor(llllllllllllllllllIIIlllIlIIIIIl);
                if (llllllllllllllllllIIIlllIIllllll >= 0 && llllllllllllllllllIIIlllIIllllll < llllllllllllllllllIIIlllIlIIIllI.length && llllllllllllllllllIIIlllIIlllllI >= 0) {
                    llllllllllllllllllIIIlllIlIIIllI[llllllllllllllllllIIIlllIIllllll] = llllllllllllllllllIIIlllIIlllllI;
                    ++llllllllllllllllllIIIlllIlIIIlIl;
                }
                else {
                    warn(String.valueOf(new StringBuilder("Invalid color: ").append(llllllllllllllllllIIIlllIlIIIIlI).append(" = ").append(llllllllllllllllllIIIlllIlIIIIIl)));
                }
            }
        }
        if (llllllllllllllllllIIIlllIlIIIlIl <= 0) {
            return null;
        }
        dbg(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllllIIIlllIlIIIlll)).append(" colors: ").append(llllllllllllllllllIIIlllIlIIIlIl)));
        return llllllllllllllllllIIIlllIlIIIllI;
    }
    
    public static int getSignTextColor(final int llllllllllllllllllIIIllIlIIllIII) {
        return (CustomColors.signTextColor < 0) ? llllllllllllllllllIIIllIlIIllIII : CustomColors.signTextColor;
    }
    
    private static int getMapColorIndex(final String llllllllllllllllllIIIllIllIIlIll) {
        return (llllllllllllllllllIIIllIllIIlIll == null) ? -1 : (llllllllllllllllllIIIllIllIIlIll.equals("air") ? MapColor.airColor.colorIndex : (llllllllllllllllllIIIllIllIIlIll.equals("grass") ? MapColor.grassColor.colorIndex : (llllllllllllllllllIIIllIllIIlIll.equals("sand") ? MapColor.sandColor.colorIndex : (llllllllllllllllllIIIllIllIIlIll.equals("cloth") ? MapColor.clothColor.colorIndex : (llllllllllllllllllIIIllIllIIlIll.equals("tnt") ? MapColor.tntColor.colorIndex : (llllllllllllllllllIIIllIllIIlIll.equals("ice") ? MapColor.iceColor.colorIndex : (llllllllllllllllllIIIllIllIIlIll.equals("iron") ? MapColor.ironColor.colorIndex : (llllllllllllllllllIIIllIllIIlIll.equals("foliage") ? MapColor.foliageColor.colorIndex : (llllllllllllllllllIIIllIllIIlIll.equals("snow") ? MapColor.snowColor.colorIndex : (llllllllllllllllllIIIllIllIIlIll.equals("clay") ? MapColor.clayColor.colorIndex : (llllllllllllllllllIIIllIllIIlIll.equals("dirt") ? MapColor.dirtColor.colorIndex : (llllllllllllllllllIIIllIllIIlIll.equals("stone") ? MapColor.stoneColor.colorIndex : (llllllllllllllllllIIIllIllIIlIll.equals("water") ? MapColor.waterColor.colorIndex : (llllllllllllllllllIIIllIllIIlIll.equals("wood") ? MapColor.woodColor.colorIndex : (llllllllllllllllllIIIllIllIIlIll.equals("quartz") ? MapColor.quartzColor.colorIndex : (llllllllllllllllllIIIllIllIIlIll.equals("adobe") ? MapColor.adobeColor.colorIndex : (llllllllllllllllllIIIllIllIIlIll.equals("magenta") ? MapColor.magentaColor.colorIndex : (llllllllllllllllllIIIllIllIIlIll.equals("lightBlue") ? MapColor.lightBlueColor.colorIndex : (llllllllllllllllllIIIllIllIIlIll.equals("light_blue") ? MapColor.lightBlueColor.colorIndex : (llllllllllllllllllIIIllIllIIlIll.equals("yellow") ? MapColor.yellowColor.colorIndex : (llllllllllllllllllIIIllIllIIlIll.equals("lime") ? MapColor.limeColor.colorIndex : (llllllllllllllllllIIIllIllIIlIll.equals("pink") ? MapColor.pinkColor.colorIndex : (llllllllllllllllllIIIllIllIIlIll.equals("gray") ? MapColor.grayColor.colorIndex : (llllllllllllllllllIIIllIllIIlIll.equals("silver") ? MapColor.silverColor.colorIndex : (llllllllllllllllllIIIllIllIIlIll.equals("cyan") ? MapColor.cyanColor.colorIndex : (llllllllllllllllllIIIllIllIIlIll.equals("purple") ? MapColor.purpleColor.colorIndex : (llllllllllllllllllIIIllIllIIlIll.equals("blue") ? MapColor.blueColor.colorIndex : (llllllllllllllllllIIIllIllIIlIll.equals("brown") ? MapColor.brownColor.colorIndex : (llllllllllllllllllIIIllIllIIlIll.equals("green") ? MapColor.greenColor.colorIndex : (llllllllllllllllllIIIllIllIIlIll.equals("red") ? MapColor.redColor.colorIndex : (llllllllllllllllllIIIllIllIIlIll.equals("black") ? MapColor.blackColor.colorIndex : (llllllllllllllllllIIIllIllIIlIll.equals("gold") ? MapColor.goldColor.colorIndex : (llllllllllllllllllIIIllIllIIlIll.equals("diamond") ? MapColor.diamondColor.colorIndex : (llllllllllllllllllIIIllIllIIlIll.equals("lapis") ? MapColor.lapisColor.colorIndex : (llllllllllllllllllIIIllIllIIlIll.equals("emerald") ? MapColor.emeraldColor.colorIndex : (llllllllllllllllllIIIllIllIIlIll.equals("obsidian") ? MapColor.obsidianColor.colorIndex : (llllllllllllllllllIIIllIllIIlIll.equals("netherrack") ? MapColor.netherrackColor.colorIndex : -1)))))))))))))))))))))))))))))))))))));
    }
    
    private static int getEntityId(final String llllllllllllllllllIIIllIlIlIlIll) {
        if (llllllllllllllllllIIIllIlIlIlIll == null) {
            return -1;
        }
        final int llllllllllllllllllIIIllIlIlIlIlI = EntityList.func_180122_a(llllllllllllllllllIIIllIlIlIlIll);
        if (llllllllllllllllllIIIllIlIlIlIlI < 0) {
            return -1;
        }
        final String llllllllllllllllllIIIllIlIlIlIIl = EntityList.getStringFromID(llllllllllllllllllIIIllIlIlIlIlI);
        return Config.equals(llllllllllllllllllIIIllIlIlIlIll, llllllllllllllllllIIIllIlIlIlIIl) ? llllllllllllllllllIIIllIlIlIlIlI : -1;
    }
    
    private static void setMapColors(final int[] llllllllllllllllllIIIllIlIllIIll) {
        if (llllllllllllllllllIIIllIlIllIIll != null) {
            final MapColor[] llllllllllllllllllIIIllIlIllIlll = MapColor.mapColorArray;
            for (int llllllllllllllllllIIIllIlIllIllI = 0; llllllllllllllllllIIIllIlIllIllI < llllllllllllllllllIIIllIlIllIlll.length && llllllllllllllllllIIIllIlIllIllI < llllllllllllllllllIIIllIlIllIIll.length; ++llllllllllllllllllIIIllIlIllIllI) {
                final MapColor llllllllllllllllllIIIllIlIllIlIl = llllllllllllllllllIIIllIlIllIlll[llllllllllllllllllIIIllIlIllIllI];
                if (llllllllllllllllllIIIllIlIllIlIl != null) {
                    final int llllllllllllllllllIIIllIlIllIlII = llllllllllllllllllIIIllIlIllIIll[llllllllllllllllllIIIllIlIllIllI];
                    if (llllllllllllllllllIIIllIlIllIlII >= 0) {
                        llllllllllllllllllIIIllIlIllIlIl.colorValue = llllllllllllllllllIIIllIlIllIlII;
                    }
                }
            }
        }
    }
    
    public static float[] getWolfCollarColors(final EnumDyeColor llllllllllllllllllIIIlllIllIIIII, final float[] llllllllllllllllllIIIlllIlIlllIl) {
        return getDyeColors(llllllllllllllllllIIIlllIllIIIII, CustomColors.wolfCollarColors, llllllllllllllllllIIIlllIlIlllIl);
    }
    
    private static int getLilypadColorMultiplier(final IBlockAccess llllllllllllllllllIIlIIlIIIlIlIl, final BlockPos llllllllllllllllllIIlIIlIIIlIIlI) {
        return (CustomColors.lilyPadColor < 0) ? Blocks.waterlily.colorMultiplier(llllllllllllllllllIIlIIlIIIlIlIl, llllllllllllllllllIIlIIlIIIlIIlI) : CustomColors.lilyPadColor;
    }
    
    private static Vec3 readColorVec3(final Properties llllllllllllllllllIIlIlIllIIIIII, final String llllllllllllllllllIIlIlIllIIlIII) {
        final int llllllllllllllllllIIlIlIllIIIlll = readColor(llllllllllllllllllIIlIlIllIIIIII, llllllllllllllllllIIlIlIllIIlIII);
        if (llllllllllllllllllIIlIlIllIIIlll < 0) {
            return null;
        }
        final int llllllllllllllllllIIlIlIllIIIllI = llllllllllllllllllIIlIlIllIIIlll >> 16 & 0xFF;
        final int llllllllllllllllllIIlIlIllIIIlIl = llllllllllllllllllIIlIlIllIIIlll >> 8 & 0xFF;
        final int llllllllllllllllllIIlIlIllIIIlII = llllllllllllllllllIIlIlIllIIIlll & 0xFF;
        final float llllllllllllllllllIIlIlIllIIIIll = llllllllllllllllllIIlIlIllIIIllI / 255.0f;
        final float llllllllllllllllllIIlIlIllIIIIlI = llllllllllllllllllIIlIlIllIIIlIl / 255.0f;
        final float llllllllllllllllllIIlIlIllIIIIIl = llllllllllllllllllIIlIlIllIIIlII / 255.0f;
        return new Vec3(llllllllllllllllllIIlIlIllIIIIll, llllllllllllllllllIIlIlIllIIIIlI, llllllllllllllllllIIlIlIllIIIIIl);
    }
    
    public static int getFluidColor(final IBlockAccess llllllllllllllllllIIlIIlllIIlIll, final IBlockState llllllllllllllllllIIlIIlllIlIIII, final BlockPos llllllllllllllllllIIlIIlllIIlIIl, final RenderEnv llllllllllllllllllIIlIIlllIIlIII) {
        final Block llllllllllllllllllIIlIIlllIIllIl = llllllllllllllllllIIlIIlllIlIIII.getBlock();
        Object llllllllllllllllllIIlIIlllIIllII = getBlockColormap(llllllllllllllllllIIlIIlllIlIIII);
        if (llllllllllllllllllIIlIIlllIIllII == null && llllllllllllllllllIIlIIlllIIllIl.getMaterial() == Material.water) {
            llllllllllllllllllIIlIIlllIIllII = CustomColors.COLORIZER_WATER;
        }
        return (llllllllllllllllllIIlIIlllIIllII == null) ? llllllllllllllllllIIlIIlllIIllIl.colorMultiplier(llllllllllllllllllIIlIIlllIIlIll, llllllllllllllllllIIlIIlllIIlIIl) : ((Config.isSmoothBiomes() && !((IColorizer)llllllllllllllllllIIlIIlllIIllII).isColorConstant()) ? getSmoothColorMultiplier(llllllllllllllllllIIlIIlllIIlIll, llllllllllllllllllIIlIIlllIIlIIl, (IColorizer)llllllllllllllllllIIlIIlllIIllII, llllllllllllllllllIIlIIlllIIlIII.getColorizerBlockPosM()) : ((IColorizer)llllllllllllllllllIIlIIlllIIllII).getColor(llllllllllllllllllIIlIIlllIIlIll, llllllllllllllllllIIlIIlllIIlIIl));
    }
    
    private static CustomColormap getBlockColormap(final IBlockState llllllllllllllllllIIlIlIIIIIlIIl) {
        if (CustomColors.blockColormaps == null) {
            return null;
        }
        if (!(llllllllllllllllllIIlIlIIIIIlIIl instanceof BlockStateBase)) {
            return null;
        }
        final BlockStateBase llllllllllllllllllIIlIlIIIIIlllI = (BlockStateBase)llllllllllllllllllIIlIlIIIIIlIIl;
        final int llllllllllllllllllIIlIlIIIIIllIl = llllllllllllllllllIIlIlIIIIIlllI.getBlockId();
        if (llllllllllllllllllIIlIlIIIIIllIl < 0 || llllllllllllllllllIIlIlIIIIIllIl >= CustomColors.blockColormaps.length) {
            return null;
        }
        final CustomColormap[] llllllllllllllllllIIlIlIIIIIllII = CustomColors.blockColormaps[llllllllllllllllllIIlIlIIIIIllIl];
        if (llllllllllllllllllIIlIlIIIIIllII == null) {
            return null;
        }
        for (int llllllllllllllllllIIlIlIIIIIlIll = 0; llllllllllllllllllIIlIlIIIIIlIll < llllllllllllllllllIIlIlIIIIIllII.length; ++llllllllllllllllllIIlIlIIIIIlIll) {
            final CustomColormap llllllllllllllllllIIlIlIIIIIlIlI = llllllllllllllllllIIlIlIIIIIllII[llllllllllllllllllIIlIlIIIIIlIll];
            if (llllllllllllllllllIIlIlIIIIIlIlI.matchesBlock(llllllllllllllllllIIlIlIIIIIlllI)) {
                return llllllllllllllllllIIlIlIIIIIlIlI;
            }
        }
        return null;
    }
    
    protected static BiomeGenBase getColorBiome(final IBlockAccess llllllllllllllllllIIlIlIIlIlIlIl, final BlockPos llllllllllllllllllIIlIlIIlIlIlII) {
        BiomeGenBase llllllllllllllllllIIlIlIIlIlIIlI = llllllllllllllllllIIlIlIIlIlIlIl.getBiomeGenForCoords(llllllllllllllllllIIlIlIIlIlIlII);
        if (llllllllllllllllllIIlIlIIlIlIIlI == BiomeGenBase.swampland && !Config.isSwampColors()) {
            llllllllllllllllllIIlIlIIlIlIIlI = BiomeGenBase.plains;
        }
        return llllllllllllllllllIIlIlIIlIlIIlI;
    }
    
    public static void updateReddustFX(final EntityFX llllllllllllllllllIIlIIlIlllIIII, final IBlockAccess llllllllllllllllllIIlIIlIlllllIl, final double llllllllllllllllllIIlIIlIlllllII, final double llllllllllllllllllIIlIIlIllllIll, final double llllllllllllllllllIIlIIlIllIllII) {
        if (CustomColors.redstoneColors != null) {
            final IBlockState llllllllllllllllllIIlIIlIllllIIl = llllllllllllllllllIIlIIlIlllllIl.getBlockState(new BlockPos(llllllllllllllllllIIlIIlIlllllII, llllllllllllllllllIIlIIlIllllIll, llllllllllllllllllIIlIIlIllIllII));
            final int llllllllllllllllllIIlIIlIllllIII = getRedstoneLevel(llllllllllllllllllIIlIIlIllllIIl, 15);
            final int llllllllllllllllllIIlIIlIlllIlll = CustomColors.redstoneColors.getColor(llllllllllllllllllIIlIIlIllllIII);
            final int llllllllllllllllllIIlIIlIlllIllI = llllllllllllllllllIIlIIlIlllIlll >> 16 & 0xFF;
            final int llllllllllllllllllIIlIIlIlllIlIl = llllllllllllllllllIIlIIlIlllIlll >> 8 & 0xFF;
            final int llllllllllllllllllIIlIIlIlllIlII = llllllllllllllllllIIlIIlIlllIlll & 0xFF;
            final float llllllllllllllllllIIlIIlIlllIIll = llllllllllllllllllIIlIIlIlllIllI / 255.0f;
            final float llllllllllllllllllIIlIIlIlllIIlI = llllllllllllllllllIIlIIlIlllIlIl / 255.0f;
            final float llllllllllllllllllIIlIIlIlllIIIl = llllllllllllllllllIIlIIlIlllIlII / 255.0f;
            llllllllllllllllllIIlIIlIlllIIII.setRBGColorF(llllllllllllllllllIIlIIlIlllIIll, llllllllllllllllllIIlIIlIlllIIlI, llllllllllllllllllIIlIIlIlllIIIl);
        }
    }
    
    public static int getColorMultiplier(final BakedQuad llllllllllllllllllIIlIlIIlllIlIl, final Block llllllllllllllllllIIlIlIIlIllllI, final IBlockAccess llllllllllllllllllIIlIlIIlIlllIl, BlockPos llllllllllllllllllIIlIlIIlIlllII, final RenderEnv llllllllllllllllllIIlIlIIlIllIll) {
        if (CustomColors.blockColormaps != null) {
            IBlockState llllllllllllllllllIIlIlIIllIllll = llllllllllllllllllIIlIlIIlIllIll.getBlockState();
            if (!llllllllllllllllllIIlIlIIlllIlIl.func_178212_b()) {
                if (llllllllllllllllllIIlIlIIlIllllI == Blocks.grass) {
                    llllllllllllllllllIIlIlIIllIllll = CustomColors.BLOCK_STATE_DIRT;
                }
                if (llllllllllllllllllIIlIlIIlIllllI == Blocks.redstone_wire) {
                    return -1;
                }
            }
            if (llllllllllllllllllIIlIlIIlIllllI == Blocks.double_plant && llllllllllllllllllIIlIlIIlIllIll.getMetadata() >= 8) {
                llllllllllllllllllIIlIlIIlIlllII = (Comparable<Byte>)((BlockPos)llllllllllllllllllIIlIlIIlIlllII).offsetDown();
                llllllllllllllllllIIlIlIIllIllll = llllllllllllllllllIIlIlIIlIlllIl.getBlockState((BlockPos)llllllllllllllllllIIlIlIIlIlllII);
            }
            final CustomColormap llllllllllllllllllIIlIlIIllIllIl = getBlockColormap(llllllllllllllllllIIlIlIIllIllll);
            if (llllllllllllllllllIIlIlIIllIllIl != null) {
                if (Config.isSmoothBiomes() && !llllllllllllllllllIIlIlIIllIllIl.isColorConstant()) {
                    return getSmoothColorMultiplier(llllllllllllllllllIIlIlIIlIlllIl, (BlockPos)llllllllllllllllllIIlIlIIlIlllII, llllllllllllllllllIIlIlIIllIllIl, llllllllllllllllllIIlIlIIlIllIll.getColorizerBlockPosM());
                }
                return llllllllllllllllllIIlIlIIllIllIl.getColor(llllllllllllllllllIIlIlIIlIlllIl, (BlockPos)llllllllllllllllllIIlIlIIlIlllII);
            }
        }
        if (!llllllllllllllllllIIlIlIIlllIlIl.func_178212_b()) {
            return -1;
        }
        if (llllllllllllllllllIIlIlIIlIllllI == Blocks.waterlily) {
            return getLilypadColorMultiplier(llllllllllllllllllIIlIlIIlIlllIl, (BlockPos)llllllllllllllllllIIlIlIIlIlllII);
        }
        if (llllllllllllllllllIIlIlIIlIllllI == Blocks.redstone_wire) {
            return getRedstoneColor(llllllllllllllllllIIlIlIIlIllIll.getBlockState());
        }
        if (llllllllllllllllllIIlIlIIlIllllI instanceof BlockStem) {
            return getStemColorMultiplier(llllllllllllllllllIIlIlIIlIllllI, llllllllllllllllllIIlIlIIlIlllIl, (BlockPos)llllllllllllllllllIIlIlIIlIlllII, llllllllllllllllllIIlIlIIlIllIll);
        }
        if (CustomColors.useDefaultGrassFoliageColors) {
            return -1;
        }
        final int llllllllllllllllllIIlIlIIllIlIll = llllllllllllllllllIIlIlIIlIllIll.getMetadata();
        IColorizer llllllllllllllllllIIlIlIIllIIIII = null;
        if (llllllllllllllllllIIlIlIIlIllllI != Blocks.grass && llllllllllllllllllIIlIlIIlIllllI != Blocks.tallgrass && llllllllllllllllllIIlIlIIlIllllI != Blocks.double_plant) {
            if (llllllllllllllllllIIlIlIIlIllllI == Blocks.double_plant) {
                final IColorizer llllllllllllllllllIIlIlIIllIlIlI = CustomColors.COLORIZER_GRASS;
                if (llllllllllllllllllIIlIlIIllIlIll >= 8) {
                    llllllllllllllllllIIlIlIIlIlllII = (Comparable<Byte>)((BlockPos)llllllllllllllllllIIlIlIIlIlllII).offsetDown();
                }
            }
            else if (llllllllllllllllllIIlIlIIlIllllI == Blocks.leaves) {
                switch (llllllllllllllllllIIlIlIIllIlIll & 0x3) {
                    case 0: {
                        final IColorizer llllllllllllllllllIIlIlIIllIlIIl = CustomColors.COLORIZER_FOLIAGE;
                        break;
                    }
                    case 1: {
                        final IColorizer llllllllllllllllllIIlIlIIllIIlll = CustomColors.COLORIZER_FOLIAGE_PINE;
                        break;
                    }
                    case 2: {
                        final IColorizer llllllllllllllllllIIlIlIIllIIlIl = CustomColors.COLORIZER_FOLIAGE_BIRCH;
                        break;
                    }
                    default: {
                        final IColorizer llllllllllllllllllIIlIlIIllIIIll = CustomColors.COLORIZER_FOLIAGE;
                        break;
                    }
                }
            }
            else if (llllllllllllllllllIIlIlIIlIllllI == Blocks.leaves2) {
                final IColorizer llllllllllllllllllIIlIlIIllIIIlI = CustomColors.COLORIZER_FOLIAGE;
            }
            else {
                if (llllllllllllllllllIIlIlIIlIllllI != Blocks.vine) {
                    return -1;
                }
                final IColorizer llllllllllllllllllIIlIlIIllIIIIl = CustomColors.COLORIZER_FOLIAGE;
            }
        }
        else {
            llllllllllllllllllIIlIlIIllIIIII = CustomColors.COLORIZER_GRASS;
        }
        return (Config.isSmoothBiomes() && !llllllllllllllllllIIlIlIIllIIIII.isColorConstant()) ? getSmoothColorMultiplier(llllllllllllllllllIIlIlIIlIlllIl, (BlockPos)llllllllllllllllllIIlIlIIlIlllII, llllllllllllllllllIIlIlIIllIIIII, llllllllllllllllllIIlIlIIlIllIll.getColorizerBlockPosM()) : llllllllllllllllllIIlIlIIllIIIII.getColor(llllllllllllllllllIIlIlIIlIlllIl, (BlockPos)llllllllllllllllllIIlIlIIlIlllII);
    }
    
    private static void addToBlockList(final CustomColormap llllllllllllllllllIIlIllIIIllIIl, final List llllllllllllllllllIIlIllIIIlIIll) {
        final int[] llllllllllllllllllIIlIllIIIlIlll = llllllllllllllllllIIlIllIIIllIIl.getMatchBlockIds();
        if (llllllllllllllllllIIlIllIIIlIlll != null && llllllllllllllllllIIlIllIIIlIlll.length > 0) {
            for (int llllllllllllllllllIIlIllIIIlIllI = 0; llllllllllllllllllIIlIllIIIlIllI < llllllllllllllllllIIlIllIIIlIlll.length; ++llllllllllllllllllIIlIllIIIlIllI) {
                final int llllllllllllllllllIIlIllIIIlIlIl = llllllllllllllllllIIlIllIIIlIlll[llllllllllllllllllIIlIllIIIlIllI];
                if (llllllllllllllllllIIlIllIIIlIlIl < 0) {
                    warn(String.valueOf(new StringBuilder("Invalid block ID: ").append(llllllllllllllllllIIlIllIIIlIlIl)));
                }
                else {
                    addToList(llllllllllllllllllIIlIllIIIllIIl, llllllllllllllllllIIlIllIIIlIIll, llllllllllllllllllIIlIllIIIlIlIl);
                }
            }
        }
        else {
            warn(String.valueOf(new StringBuilder("No match blocks: ").append(Config.arrayToString(llllllllllllllllllIIlIllIIIlIlll))));
        }
    }
    
    public static int getExpBarTextColor(final int llllllllllllllllllIIIllIlIIlllIl) {
        return (CustomColors.expBarTextColor < 0) ? llllllllllllllllllIIIllIlIIlllIl : CustomColors.expBarTextColor;
    }
    
    static {
        CustomColors.waterColors = null;
        CustomColors.foliagePineColors = null;
        CustomColors.foliageBirchColors = null;
        CustomColors.swampFoliageColors = null;
        CustomColors.swampGrassColors = null;
        CustomColors.colorsBlockColormaps = null;
        CustomColors.blockColormaps = null;
        CustomColors.skyColors = null;
        CustomColors.skyColorFader = new CustomColorFader();
        CustomColors.fogColors = null;
        CustomColors.fogColorFader = new CustomColorFader();
        CustomColors.underwaterColors = null;
        CustomColors.underwaterColorFader = new CustomColorFader();
        CustomColors.lightMapsColorsRgb = null;
        CustomColors.lightmapMinDimensionId = 0;
        CustomColors.sunRgbs = new float[16][3];
        CustomColors.torchRgbs = new float[16][3];
        CustomColors.redstoneColors = null;
        CustomColors.xpOrbColors = null;
        CustomColors.stemColors = null;
        CustomColors.stemMelonColors = null;
        CustomColors.stemPumpkinColors = null;
        CustomColors.myceliumParticleColors = null;
        CustomColors.useDefaultGrassFoliageColors = true;
        CustomColors.particleWaterColor = -1;
        CustomColors.particlePortalColor = -1;
        CustomColors.lilyPadColor = -1;
        CustomColors.expBarTextColor = -1;
        CustomColors.bossTextColor = -1;
        CustomColors.signTextColor = -1;
        CustomColors.fogColorNether = null;
        CustomColors.fogColorEnd = null;
        CustomColors.skyColorEnd = null;
        CustomColors.spawnEggPrimaryColors = null;
        CustomColors.spawnEggSecondaryColors = null;
        CustomColors.wolfCollarColors = null;
        CustomColors.sheepColors = null;
        CustomColors.textColors = null;
        CustomColors.mapColorsOriginal = null;
        CustomColors.potionColors = null;
        BLOCK_STATE_DIRT = Blocks.dirt.getDefaultState();
        BLOCK_STATE_WATER = Blocks.water.getDefaultState();
        CustomColors.random = new Random();
        COLORIZER_GRASS = new IColorizer() {
            @Override
            public int getColor(final IBlockAccess lIIlIIlIIlIlIlI, final BlockPos lIIlIIlIIlIlIIl) {
                final BiomeGenBase lIIlIIlIIlIlIll = CustomColors.getColorBiome(lIIlIIlIIlIlIlI, lIIlIIlIIlIlIIl);
                return (CustomColors.swampGrassColors != null && lIIlIIlIIlIlIll == BiomeGenBase.swampland) ? CustomColors.swampGrassColors.getColor(lIIlIIlIIlIlIll, lIIlIIlIIlIlIIl) : lIIlIIlIIlIlIll.func_180627_b(lIIlIIlIIlIlIIl);
            }
            
            @Override
            public boolean isColorConstant() {
                return false;
            }
        };
        COLORIZER_FOLIAGE = new IColorizer() {
            @Override
            public int getColor(final IBlockAccess llllllllllllllIlIllllIIIIIIlIllI, final BlockPos llllllllllllllIlIllllIIIIIIllIII) {
                final BiomeGenBase llllllllllllllIlIllllIIIIIIlIlll = CustomColors.getColorBiome(llllllllllllllIlIllllIIIIIIlIllI, llllllllllllllIlIllllIIIIIIllIII);
                return (CustomColors.swampFoliageColors != null && llllllllllllllIlIllllIIIIIIlIlll == BiomeGenBase.swampland) ? CustomColors.swampFoliageColors.getColor(llllllllllllllIlIllllIIIIIIlIlll, llllllllllllllIlIllllIIIIIIllIII) : llllllllllllllIlIllllIIIIIIlIlll.func_180625_c(llllllllllllllIlIllllIIIIIIllIII);
            }
            
            @Override
            public boolean isColorConstant() {
                return false;
            }
        };
        COLORIZER_FOLIAGE_PINE = new IColorizer() {
            @Override
            public int getColor(final IBlockAccess llllllllllllllIIllIllIlIIIIIIIll, final BlockPos llllllllllllllIIllIllIlIIIIIIIII) {
                return (CustomColors.foliagePineColors != null) ? CustomColors.foliagePineColors.getColor(llllllllllllllIIllIllIlIIIIIIIll, llllllllllllllIIllIllIlIIIIIIIII) : ColorizerFoliage.getFoliageColorPine();
            }
            
            @Override
            public boolean isColorConstant() {
                return CustomColors.foliagePineColors == null;
            }
        };
        COLORIZER_FOLIAGE_BIRCH = new IColorizer() {
            @Override
            public int getColor(final IBlockAccess lllllllllllllllllIlIIllIllllIlll, final BlockPos lllllllllllllllllIlIIllIllllIllI) {
                return (CustomColors.foliageBirchColors != null) ? CustomColors.foliageBirchColors.getColor(lllllllllllllllllIlIIllIllllIlll, lllllllllllllllllIlIIllIllllIllI) : ColorizerFoliage.getFoliageColorBirch();
            }
            
            @Override
            public boolean isColorConstant() {
                return CustomColors.foliageBirchColors == null;
            }
        };
        COLORIZER_WATER = new IColorizer() {
            @Override
            public int getColor(final IBlockAccess llllllllllllllIllllIIlIIlIIIlIll, final BlockPos llllllllllllllIllllIIlIIlIIIllIl) {
                final BiomeGenBase llllllllllllllIllllIIlIIlIIIllII = CustomColors.getColorBiome(llllllllllllllIllllIIlIIlIIIlIll, llllllllllllllIllllIIlIIlIIIllIl);
                return (CustomColors.waterColors != null) ? CustomColors.waterColors.getColor(llllllllllllllIllllIIlIIlIIIllII, llllllllllllllIllllIIlIIlIIIllIl) : (Reflector.ForgeBiomeGenBase_getWaterColorMultiplier.exists() ? Reflector.callInt(llllllllllllllIllllIIlIIlIIIllII, Reflector.ForgeBiomeGenBase_getWaterColorMultiplier, new Object[0]) : llllllllllllllIllllIIlIIlIIIllII.waterColorMultiplier);
            }
            
            @Override
            public boolean isColorConstant() {
                return false;
            }
        };
    }
    
    private static int getTextureHeight(final String llllllllllllllllllIIlIlllIIlIlII, final int llllllllllllllllllIIlIlllIIlIIll) {
        try {
            final InputStream llllllllllllllllllIIlIlllIIlIlll = Config.getResourceStream(new ResourceLocation(llllllllllllllllllIIlIlllIIlIlII));
            if (llllllllllllllllllIIlIlllIIlIlll == null) {
                return llllllllllllllllllIIlIlllIIlIIll;
            }
            final BufferedImage llllllllllllllllllIIlIlllIIlIllI = ImageIO.read(llllllllllllllllllIIlIlllIIlIlll);
            llllllllllllllllllIIlIlllIIlIlll.close();
            return (llllllllllllllllllIIlIlllIIlIllI == null) ? llllllllllllllllllIIlIlllIIlIIll : llllllllllllllllllIIlIlllIIlIllI.getHeight();
        }
        catch (IOException llllllllllllllllllIIlIlllIIlIlIl) {
            return llllllllllllllllllIIlIlllIIlIIll;
        }
    }
    
    private static int getRedstoneColor(final IBlockState llllllllllllllllllIIlIIllIIIllll) {
        if (CustomColors.redstoneColors == null) {
            return -1;
        }
        final int llllllllllllllllllIIlIIllIIlIIIl = getRedstoneLevel(llllllllllllllllllIIlIIllIIIllll, 15);
        final int llllllllllllllllllIIlIIllIIlIIII = CustomColors.redstoneColors.getColor(llllllllllllllllllIIlIIllIIlIIIl);
        return llllllllllllllllllIIlIIllIIlIIII;
    }
    
    private static CustomColormap getCustomColors(final String llllllllllllllllllIIlIlIlIllIIII, final String[] llllllllllllllllllIIlIlIlIlIllll, final int llllllllllllllllllIIlIlIlIlIIlll, final int llllllllllllllllllIIlIlIlIlIIllI) {
        for (int llllllllllllllllllIIlIlIlIlIllII = 0; llllllllllllllllllIIlIlIlIlIllII < llllllllllllllllllIIlIlIlIlIllll.length; ++llllllllllllllllllIIlIlIlIlIllII) {
            String llllllllllllllllllIIlIlIlIlIlIll = llllllllllllllllllIIlIlIlIlIllll[llllllllllllllllllIIlIlIlIlIllII];
            llllllllllllllllllIIlIlIlIlIlIll = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllllIIlIlIlIllIIII)).append(llllllllllllllllllIIlIlIlIlIlIll));
            final CustomColormap llllllllllllllllllIIlIlIlIlIlIlI = getCustomColors(llllllllllllllllllIIlIlIlIlIlIll, llllllllllllllllllIIlIlIlIlIIlll, llllllllllllllllllIIlIlIlIlIIllI);
            if (llllllllllllllllllIIlIlIlIlIlIlI != null) {
                return llllllllllllllllllIIlIlIlIlIlIlI;
            }
        }
        return null;
    }
    
    public static int getTextColor(final int llllllllllllllllllIIIlllIIlIlllI, final int llllllllllllllllllIIIlllIIlIlIlI) {
        if (CustomColors.textColors == null) {
            return llllllllllllllllllIIIlllIIlIlIlI;
        }
        if (llllllllllllllllllIIIlllIIlIlllI >= 0 && llllllllllllllllllIIIlllIIlIlllI < CustomColors.textColors.length) {
            final int llllllllllllllllllIIIlllIIlIllII = CustomColors.textColors[llllllllllllllllllIIIlllIIlIlllI];
            return (llllllllllllllllllIIIlllIIlIllII < 0) ? llllllllllllllllllIIIlllIIlIlIlI : llllllllllllllllllIIIlllIIlIllII;
        }
        return llllllllllllllllllIIIlllIIlIlIlI;
    }
    
    private static int[] readMapColors(final Properties llllllllllllllllllIIIlllIIIIllll, final String llllllllllllllllllIIIlllIIIllIll, final String llllllllllllllllllIIIlllIIIllIlI, final String llllllllllllllllllIIIlllIIIllIIl) {
        final int[] llllllllllllllllllIIIlllIIIllIII = new int[MapColor.mapColorArray.length];
        Arrays.fill(llllllllllllllllllIIIlllIIIllIII, -1);
        int llllllllllllllllllIIIlllIIIlIlll = 0;
        final Set llllllllllllllllllIIIlllIIIlIllI = llllllllllllllllllIIIlllIIIIllll.keySet();
        for (final String llllllllllllllllllIIIlllIIIlIlII : llllllllllllllllllIIIlllIIIlIllI) {
            final String llllllllllllllllllIIIlllIIIlIIll = llllllllllllllllllIIIlllIIIIllll.getProperty(llllllllllllllllllIIIlllIIIlIlII);
            if (llllllllllllllllllIIIlllIIIlIlII.startsWith(llllllllllllllllllIIIlllIIIllIlI)) {
                final String llllllllllllllllllIIIlllIIIlIIlI = StrUtils.removePrefix(llllllllllllllllllIIIlllIIIlIlII, llllllllllllllllllIIIlllIIIllIlI);
                final int llllllllllllllllllIIIlllIIIlIIIl = getMapColorIndex(llllllllllllllllllIIIlllIIIlIIlI);
                final int llllllllllllllllllIIIlllIIIlIIII = parseColor(llllllllllllllllllIIIlllIIIlIIll);
                if (llllllllllllllllllIIIlllIIIlIIIl >= 0 && llllllllllllllllllIIIlllIIIlIIIl < llllllllllllllllllIIIlllIIIllIII.length && llllllllllllllllllIIIlllIIIlIIII >= 0) {
                    llllllllllllllllllIIIlllIIIllIII[llllllllllllllllllIIIlllIIIlIIIl] = llllllllllllllllllIIIlllIIIlIIII;
                    ++llllllllllllllllllIIIlllIIIlIlll;
                }
                else {
                    warn(String.valueOf(new StringBuilder("Invalid color: ").append(llllllllllllllllllIIIlllIIIlIlII).append(" = ").append(llllllllllllllllllIIIlllIIIlIIll)));
                }
            }
        }
        if (llllllllllllllllllIIIlllIIIlIlll <= 0) {
            return null;
        }
        dbg(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllllIIIlllIIIllIIl)).append(" colors: ").append(llllllllllllllllllIIIlllIIIlIlll)));
        return llllllllllllllllllIIIlllIIIllIII;
    }
    
    public static Vec3 getSkyColor(final Vec3 llllllllllllllllllIIlIIIlllIlIII, final IBlockAccess llllllllllllllllllIIlIIIlllIIlll, final double llllllllllllllllllIIlIIIlllIIllI, final double llllllllllllllllllIIlIIIlllIIlIl, final double llllllllllllllllllIIlIIIllllIlII) {
        if (CustomColors.skyColors == null) {
            return llllllllllllllllllIIlIIIlllIlIII;
        }
        final int llllllllllllllllllIIlIIIllllIIll = CustomColors.skyColors.getColorSmooth(llllllllllllllllllIIlIIIlllIIlll, llllllllllllllllllIIlIIIlllIIllI, llllllllllllllllllIIlIIIlllIIlIl, llllllllllllllllllIIlIIIllllIlII, 3);
        final int llllllllllllllllllIIlIIIllllIIlI = llllllllllllllllllIIlIIIllllIIll >> 16 & 0xFF;
        final int llllllllllllllllllIIlIIIllllIIIl = llllllllllllllllllIIlIIIllllIIll >> 8 & 0xFF;
        final int llllllllllllllllllIIlIIIllllIIII = llllllllllllllllllIIlIIIllllIIll & 0xFF;
        float llllllllllllllllllIIlIIIlllIllll = llllllllllllllllllIIlIIIllllIIlI / 255.0f;
        float llllllllllllllllllIIlIIIlllIlllI = llllllllllllllllllIIlIIIllllIIIl / 255.0f;
        float llllllllllllllllllIIlIIIlllIllIl = llllllllllllllllllIIlIIIllllIIII / 255.0f;
        final float llllllllllllllllllIIlIIIlllIllII = (float)llllllllllllllllllIIlIIIlllIlIII.xCoord / 0.5f;
        final float llllllllllllllllllIIlIIIlllIlIll = (float)llllllllllllllllllIIlIIIlllIlIII.yCoord / 0.66275f;
        final float llllllllllllllllllIIlIIIlllIlIlI = (float)llllllllllllllllllIIlIIIlllIlIII.zCoord;
        llllllllllllllllllIIlIIIlllIllll *= llllllllllllllllllIIlIIIlllIllII;
        llllllllllllllllllIIlIIIlllIlllI *= llllllllllllllllllIIlIIIlllIlIll;
        llllllllllllllllllIIlIIIlllIllIl *= llllllllllllllllllIIlIIIlllIlIlI;
        final Vec3 llllllllllllllllllIIlIIIlllIlIIl = CustomColors.skyColorFader.getColor(llllllllllllllllllIIlIIIlllIllll, llllllllllllllllllIIlIIIlllIlllI, llllllllllllllllllIIlIIIlllIllIl);
        return llllllllllllllllllIIlIIIlllIlIIl;
    }
    
    public static float[] getSheepColors(final EnumDyeColor llllllllllllllllllIIIlllIlIllIlI, final float[] llllllllllllllllllIIIlllIlIllIIl) {
        return getDyeColors(llllllllllllllllllIIIlllIlIllIlI, CustomColors.sheepColors, llllllllllllllllllIIIlllIlIllIIl);
    }
    
    private static int[] getMapColors() {
        final MapColor[] llllllllllllllllllIIIllIllIIIlIl = MapColor.mapColorArray;
        final int[] llllllllllllllllllIIIllIllIIIlII = new int[llllllllllllllllllIIIllIllIIIlIl.length];
        Arrays.fill(llllllllllllllllllIIIllIllIIIlII, -1);
        for (int llllllllllllllllllIIIllIllIIIIll = 0; llllllllllllllllllIIIllIllIIIIll < llllllllllllllllllIIIllIllIIIlIl.length && llllllllllllllllllIIIllIllIIIIll < llllllllllllllllllIIIllIllIIIlII.length; ++llllllllllllllllllIIIllIllIIIIll) {
            final MapColor llllllllllllllllllIIIllIllIIIIlI = llllllllllllllllllIIIllIllIIIlIl[llllllllllllllllllIIIllIllIIIIll];
            if (llllllllllllllllllIIIllIllIIIIlI != null) {
                llllllllllllllllllIIIllIllIIIlII[llllllllllllllllllIIIllIllIIIIll] = llllllllllllllllllIIIllIllIIIIlI.colorValue;
            }
        }
        return llllllllllllllllllIIIllIllIIIlII;
    }
    
    private static Pair<CustomColormap[], Integer> parseLightmapsRgb() {
        final String llllllllllllllllllIIlIlllIllllll = "mcpatcher/lightmap/world";
        final String llllllllllllllllllIIlIlllIlllllI = ".png";
        final String[] llllllllllllllllllIIlIlllIllllIl = ResUtils.collectFiles(llllllllllllllllllIIlIlllIllllll, llllllllllllllllllIIlIlllIlllllI);
        final HashMap llllllllllllllllllIIlIlllIllllII = new HashMap();
        for (int llllllllllllllllllIIlIlllIlllIIl = 0; llllllllllllllllllIIlIlllIlllIIl < llllllllllllllllllIIlIlllIllllIl.length; ++llllllllllllllllllIIlIlllIlllIIl) {
            final String llllllllllllllllllIIlIlllIlllIII = llllllllllllllllllIIlIlllIllllIl[llllllllllllllllllIIlIlllIlllIIl];
            final String llllllllllllllllllIIlIlllIllIlll = StrUtils.removePrefixSuffix(llllllllllllllllllIIlIlllIlllIII, llllllllllllllllllIIlIlllIllllll, llllllllllllllllllIIlIlllIlllllI);
            final int llllllllllllllllllIIlIlllIlllIll = Config.parseInt(llllllllllllllllllIIlIlllIllIlll, Integer.MIN_VALUE);
            if (llllllllllllllllllIIlIlllIlllIll == Integer.MIN_VALUE) {
                warn(String.valueOf(new StringBuilder("Invalid dimension ID: ").append(llllllllllllllllllIIlIlllIllIlll).append(", path: ").append(llllllllllllllllllIIlIlllIlllIII)));
            }
            else {
                llllllllllllllllllIIlIlllIllllII.put(llllllllllllllllllIIlIlllIlllIll, llllllllllllllllllIIlIlllIlllIII);
            }
        }
        final Set llllllllllllllllllIIlIlllIllIllI = llllllllllllllllllIIlIlllIllllII.keySet();
        final Integer[] llllllllllllllllllIIlIlllIllIlIl = llllllllllllllllllIIlIlllIllIllI.toArray(new Integer[llllllllllllllllllIIlIlllIllIllI.size()]);
        Arrays.sort(llllllllllllllllllIIlIlllIllIlIl);
        if (llllllllllllllllllIIlIlllIllIlIl.length <= 0) {
            return (Pair<CustomColormap[], Integer>)new ImmutablePair((Object)null, (Object)0);
        }
        final int llllllllllllllllllIIlIlllIllIlII = llllllllllllllllllIIlIlllIllIlIl[0];
        final int llllllllllllllllllIIlIlllIlllIlI = llllllllllllllllllIIlIlllIllIlIl[llllllllllllllllllIIlIlllIllIlIl.length - 1];
        final int llllllllllllllllllIIlIlllIllIIll = llllllllllllllllllIIlIlllIlllIlI - llllllllllllllllllIIlIlllIllIlII + 1;
        final CustomColormap[] llllllllllllllllllIIlIlllIllIIlI = new CustomColormap[llllllllllllllllllIIlIlllIllIIll];
        for (int llllllllllllllllllIIlIlllIllIIIl = 0; llllllllllllllllllIIlIlllIllIIIl < llllllllllllllllllIIlIlllIllIlIl.length; ++llllllllllllllllllIIlIlllIllIIIl) {
            final Integer llllllllllllllllllIIlIlllIllIIII = llllllllllllllllllIIlIlllIllIlIl[llllllllllllllllllIIlIlllIllIIIl];
            final String llllllllllllllllllIIlIlllIlIllll = llllllllllllllllllIIlIlllIllllII.get(llllllllllllllllllIIlIlllIllIIII);
            final CustomColormap llllllllllllllllllIIlIlllIlIlllI = getCustomColors(llllllllllllllllllIIlIlllIlIllll, -1, -1);
            if (llllllllllllllllllIIlIlllIlIlllI != null) {
                if (llllllllllllllllllIIlIlllIlIlllI.getWidth() < 16) {
                    warn(String.valueOf(new StringBuilder("Invalid lightmap width: ").append(llllllllllllllllllIIlIlllIlIlllI.getWidth()).append(", path: ").append(llllllllllllllllllIIlIlllIlIllll)));
                }
                else {
                    final int llllllllllllllllllIIlIlllIlIllIl = llllllllllllllllllIIlIlllIllIIII - llllllllllllllllllIIlIlllIllIlII;
                    llllllllllllllllllIIlIlllIllIIlI[llllllllllllllllllIIlIlllIlIllIl] = llllllllllllllllllIIlIlllIlIlllI;
                }
            }
        }
        return (Pair<CustomColormap[], Integer>)new ImmutablePair((Object)llllllllllllllllllIIlIlllIllIIlI, (Object)llllllllllllllllllIIlIlllIllIlII);
    }
    
    private static int getRedstoneLevel(final IBlockState llllllllllllllllllIIlIIlIlIllIII, final int llllllllllllllllllIIlIIlIlIlllII) {
        final Block llllllllllllllllllIIlIIlIlIllIll = llllllllllllllllllIIlIIlIlIllIII.getBlock();
        if (!(llllllllllllllllllIIlIIlIlIllIll instanceof BlockRedstoneWire)) {
            return llllllllllllllllllIIlIIlIlIlllII;
        }
        final Comparable llllllllllllllllllIIlIIlIlIllIlI = llllllllllllllllllIIlIIlIlIllIII.getValue(BlockRedstoneWire.POWER);
        if (!(llllllllllllllllllIIlIIlIlIllIlI instanceof Integer)) {
            return llllllllllllllllllIIlIIlIlIlllII;
        }
        final Integer llllllllllllllllllIIlIIlIlIllIIl = (Integer)llllllllllllllllllIIlIIlIlIllIlI;
        return llllllllllllllllllIIlIIlIlIllIIl;
    }
    
    public static int getBossTextColor(final int llllllllllllllllllIIIllIlIIllIll) {
        return (CustomColors.bossTextColor < 0) ? llllllllllllllllllIIIllIlIIllIll : CustomColors.bossTextColor;
    }
    
    private static int readColor(final Properties llllllllllllllllllIIlIlIlllIIIIl, final String llllllllllllllllllIIlIlIllIlllII) {
        String llllllllllllllllllIIlIlIllIlllll = llllllllllllllllllIIlIlIlllIIIIl.getProperty(llllllllllllllllllIIlIlIllIlllII);
        if (llllllllllllllllllIIlIlIllIlllll == null) {
            return -1;
        }
        llllllllllllllllllIIlIlIllIlllll = llllllllllllllllllIIlIlIllIlllll.trim();
        final int llllllllllllllllllIIlIlIllIllllI = parseColor(llllllllllllllllllIIlIlIllIlllll);
        if (llllllllllllllllllIIlIlIllIllllI < 0) {
            warn(String.valueOf(new StringBuilder("Invalid color: ").append(llllllllllllllllllIIlIlIllIlllII).append(" = ").append(llllllllllllllllllIIlIlIllIlllll)));
            return llllllllllllllllllIIlIlIllIllllI;
        }
        dbg(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllllIIlIlIllIlllII)).append(" = ").append(llllllllllllllllllIIlIlIllIlllll)));
        return llllllllllllllllllIIlIlIllIllllI;
    }
    
    private static void getLightMapColumn(final float[][] llllllllllllllllllIIlIIIIIlIIlII, final float llllllllllllllllllIIlIIIIIIlIIIl, final int llllllllllllllllllIIlIIIIIlIIIlI, final int llllllllllllllllllIIlIIIIIlIIIIl, final float[][] llllllllllllllllllIIlIIIIIIIlllI) {
        final int llllllllllllllllllIIlIIIIIIlllll = (int)Math.floor(llllllllllllllllllIIlIIIIIIlIIIl);
        final int llllllllllllllllllIIlIIIIIIllllI = (int)Math.ceil(llllllllllllllllllIIlIIIIIIlIIIl);
        if (llllllllllllllllllIIlIIIIIIlllll == llllllllllllllllllIIlIIIIIIllllI) {
            for (int llllllllllllllllllIIlIIIIIIlllIl = 0; llllllllllllllllllIIlIIIIIIlllIl < 16; ++llllllllllllllllllIIlIIIIIIlllIl) {
                final float[] llllllllllllllllllIIlIIIIIIlllII = llllllllllllllllllIIlIIIIIlIIlII[llllllllllllllllllIIlIIIIIlIIIlI + llllllllllllllllllIIlIIIIIIlllIl * llllllllllllllllllIIlIIIIIlIIIIl + llllllllllllllllllIIlIIIIIIlllll];
                final float[] llllllllllllllllllIIlIIIIIIllIll = llllllllllllllllllIIlIIIIIIIlllI[llllllllllllllllllIIlIIIIIIlllIl];
                for (int llllllllllllllllllIIlIIIIIIllIlI = 0; llllllllllllllllllIIlIIIIIIllIlI < 3; ++llllllllllllllllllIIlIIIIIIllIlI) {
                    llllllllllllllllllIIlIIIIIIllIll[llllllllllllllllllIIlIIIIIIllIlI] = llllllllllllllllllIIlIIIIIIlllII[llllllllllllllllllIIlIIIIIIllIlI];
                }
            }
        }
        else {
            final float llllllllllllllllllIIlIIIIIIllIIl = 1.0f - (llllllllllllllllllIIlIIIIIIlIIIl - llllllllllllllllllIIlIIIIIIlllll);
            final float llllllllllllllllllIIlIIIIIIllIII = 1.0f - (llllllllllllllllllIIlIIIIIIllllI - llllllllllllllllllIIlIIIIIIlIIIl);
            for (int llllllllllllllllllIIlIIIIIIlIlll = 0; llllllllllllllllllIIlIIIIIIlIlll < 16; ++llllllllllllllllllIIlIIIIIIlIlll) {
                final float[] llllllllllllllllllIIlIIIIIIlIllI = llllllllllllllllllIIlIIIIIlIIlII[llllllllllllllllllIIlIIIIIlIIIlI + llllllllllllllllllIIlIIIIIIlIlll * llllllllllllllllllIIlIIIIIlIIIIl + llllllllllllllllllIIlIIIIIIlllll];
                final float[] llllllllllllllllllIIlIIIIIIlIlIl = llllllllllllllllllIIlIIIIIlIIlII[llllllllllllllllllIIlIIIIIlIIIlI + llllllllllllllllllIIlIIIIIIlIlll * llllllllllllllllllIIlIIIIIlIIIIl + llllllllllllllllllIIlIIIIIIllllI];
                final float[] llllllllllllllllllIIlIIIIIIlIlII = llllllllllllllllllIIlIIIIIIIlllI[llllllllllllllllllIIlIIIIIIlIlll];
                for (int llllllllllllllllllIIlIIIIIIlIIll = 0; llllllllllllllllllIIlIIIIIIlIIll < 3; ++llllllllllllllllllIIlIIIIIIlIIll) {
                    llllllllllllllllllIIlIIIIIIlIlII[llllllllllllllllllIIlIIIIIIlIIll] = llllllllllllllllllIIlIIIIIIlIllI[llllllllllllllllllIIlIIIIIIlIIll] * llllllllllllllllllIIlIIIIIIllIIl + llllllllllllllllllIIlIIIIIIlIlIl[llllllllllllllllllIIlIIIIIIlIIll] * llllllllllllllllllIIlIIIIIIllIII;
                }
            }
        }
    }
    
    private static Vec3 getFogColorEnd(final Vec3 llllllllllllllllllIIlIIlIIIIllII) {
        return (CustomColors.fogColorEnd == null) ? llllllllllllllllllIIlIIlIIIIllII : CustomColors.fogColorEnd;
    }
    
    private static Vec3 getSkyColorEnd(final Vec3 llllllllllllllllllIIlIIlIIIIlIlI) {
        return (CustomColors.skyColorEnd == null) ? llllllllllllllllllIIlIIlIIIIlIlI : CustomColors.skyColorEnd;
    }
    
    public static boolean updateLightmap(final World llllllllllllllllllIIlIIIIlIIlIII, final float llllllllllllllllllIIlIIIIlIIIlll, final int[] llllllllllllllllllIIlIIIIlIIIllI, final boolean llllllllllllllllllIIlIIIIlIlllIl) {
        if (llllllllllllllllllIIlIIIIlIIlIII == null) {
            return false;
        }
        if (CustomColors.lightMapsColorsRgb == null) {
            return false;
        }
        final int llllllllllllllllllIIlIIIIlIlllII = llllllllllllllllllIIlIIIIlIIlIII.provider.getDimensionId();
        final int llllllllllllllllllIIlIIIIlIllIll = llllllllllllllllllIIlIIIIlIlllII - CustomColors.lightmapMinDimensionId;
        if (llllllllllllllllllIIlIIIIlIllIll < 0 || llllllllllllllllllIIlIIIIlIllIll >= CustomColors.lightMapsColorsRgb.length) {
            return false;
        }
        final CustomColormap llllllllllllllllllIIlIIIIlIllIlI = CustomColors.lightMapsColorsRgb[llllllllllllllllllIIlIIIIlIllIll];
        if (llllllllllllllllllIIlIIIIlIllIlI == null) {
            return false;
        }
        final int llllllllllllllllllIIlIIIIlIllIIl = llllllllllllllllllIIlIIIIlIllIlI.getHeight();
        if (llllllllllllllllllIIlIIIIlIlllIl && llllllllllllllllllIIlIIIIlIllIIl < 64) {
            return false;
        }
        final int llllllllllllllllllIIlIIIIlIllIII = llllllllllllllllllIIlIIIIlIllIlI.getWidth();
        if (llllllllllllllllllIIlIIIIlIllIII < 16) {
            warn(String.valueOf(new StringBuilder("Invalid lightmap width: ").append(llllllllllllllllllIIlIIIIlIllIII).append(" for dimension: ").append(llllllllllllllllllIIlIIIIlIlllII)));
            CustomColors.lightMapsColorsRgb[llllllllllllllllllIIlIIIIlIllIll] = null;
            return false;
        }
        int llllllllllllllllllIIlIIIIlIlIlll = 0;
        if (llllllllllllllllllIIlIIIIlIlllIl) {
            llllllllllllllllllIIlIIIIlIlIlll = llllllllllllllllllIIlIIIIlIllIII * 16 * 2;
        }
        float llllllllllllllllllIIlIIIIlIlIllI = 1.1666666f * (llllllllllllllllllIIlIIIIlIIlIII.getSunBrightness(1.0f) - 0.2f);
        if (llllllllllllllllllIIlIIIIlIIlIII.func_175658_ac() > 0) {
            llllllllllllllllllIIlIIIIlIlIllI = 1.0f;
        }
        llllllllllllllllllIIlIIIIlIlIllI = Config.limitTo1(llllllllllllllllllIIlIIIIlIlIllI);
        final float llllllllllllllllllIIlIIIIlIlIlIl = llllllllllllllllllIIlIIIIlIlIllI * (llllllllllllllllllIIlIIIIlIllIII - 1);
        final float llllllllllllllllllIIlIIIIlIlIlII = Config.limitTo1(llllllllllllllllllIIlIIIIlIIIlll + 0.5f) * (llllllllllllllllllIIlIIIIlIllIII - 1);
        final float llllllllllllllllllIIlIIIIlIlIIll = Config.limitTo1(Config.getGameSettings().gammaSetting);
        final boolean llllllllllllllllllIIlIIIIlIlIIlI = llllllllllllllllllIIlIIIIlIlIIll > 1.0E-4f;
        final float[][] llllllllllllllllllIIlIIIIlIlIIIl = llllllllllllllllllIIlIIIIlIllIlI.getColorsRgb();
        getLightMapColumn(llllllllllllllllllIIlIIIIlIlIIIl, llllllllllllllllllIIlIIIIlIlIlIl, llllllllllllllllllIIlIIIIlIlIlll, llllllllllllllllllIIlIIIIlIllIII, CustomColors.sunRgbs);
        getLightMapColumn(llllllllllllllllllIIlIIIIlIlIIIl, llllllllllllllllllIIlIIIIlIlIlII, llllllllllllllllllIIlIIIIlIlIlll + 16 * llllllllllllllllllIIlIIIIlIllIII, llllllllllllllllllIIlIIIIlIllIII, CustomColors.torchRgbs);
        final float[] llllllllllllllllllIIlIIIIlIlIIII = new float[3];
        for (int llllllllllllllllllIIlIIIIlIIllll = 0; llllllllllllllllllIIlIIIIlIIllll < 16; ++llllllllllllllllllIIlIIIIlIIllll) {
            for (int llllllllllllllllllIIlIIIIlIIlllI = 0; llllllllllllllllllIIlIIIIlIIlllI < 16; ++llllllllllllllllllIIlIIIIlIIlllI) {
                for (int llllllllllllllllllIIlIIIIlIIllIl = 0; llllllllllllllllllIIlIIIIlIIllIl < 3; ++llllllllllllllllllIIlIIIIlIIllIl) {
                    float llllllllllllllllllIIlIIIIlIIllII = Config.limitTo1(CustomColors.sunRgbs[llllllllllllllllllIIlIIIIlIIllll][llllllllllllllllllIIlIIIIlIIllIl] + CustomColors.torchRgbs[llllllllllllllllllIIlIIIIlIIlllI][llllllllllllllllllIIlIIIIlIIllIl]);
                    if (llllllllllllllllllIIlIIIIlIlIIlI) {
                        float llllllllllllllllllIIlIIIIlIIlIll = 1.0f - llllllllllllllllllIIlIIIIlIIllII;
                        llllllllllllllllllIIlIIIIlIIlIll = 1.0f - llllllllllllllllllIIlIIIIlIIlIll * llllllllllllllllllIIlIIIIlIIlIll * llllllllllllllllllIIlIIIIlIIlIll * llllllllllllllllllIIlIIIIlIIlIll;
                        llllllllllllllllllIIlIIIIlIIllII = llllllllllllllllllIIlIIIIlIlIIll * llllllllllllllllllIIlIIIIlIIlIll + (1.0f - llllllllllllllllllIIlIIIIlIlIIll) * llllllllllllllllllIIlIIIIlIIllII;
                    }
                    llllllllllllllllllIIlIIIIlIlIIII[llllllllllllllllllIIlIIIIlIIllIl] = llllllllllllllllllIIlIIIIlIIllII;
                }
                int llllllllllllllllllIIlIIIIlIIllIl = (int)(llllllllllllllllllIIlIIIIlIlIIII[0] * 255.0f);
                final int llllllllllllllllllIIlIIIIlIIlIlI = (int)(llllllllllllllllllIIlIIIIlIlIIII[1] * 255.0f);
                final int llllllllllllllllllIIlIIIIlIIlIIl = (int)(llllllllllllllllllIIlIIIIlIlIIII[2] * 255.0f);
                llllllllllllllllllIIlIIIIlIIIllI[llllllllllllllllllIIlIIIIlIIllll * 16 + llllllllllllllllllIIlIIIIlIIlllI] = (0xFF000000 | llllllllllllllllllIIlIIIIlIIllIl << 16 | llllllllllllllllllIIlIIIIlIIlIlI << 8 | llllllllllllllllllIIlIIIIlIIlIIl);
            }
        }
        return true;
    }
    
    public interface IColorizer
    {
        boolean isColorConstant();
        
        int getColor(final IBlockAccess p0, final BlockPos p1);
    }
}
