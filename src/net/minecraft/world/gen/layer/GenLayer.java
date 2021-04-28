package net.minecraft.world.gen.layer;

import net.minecraft.world.biome.*;
import net.minecraft.world.*;
import net.minecraft.world.gen.*;
import java.util.concurrent.*;
import net.minecraft.util.*;
import net.minecraft.crash.*;

public abstract class GenLayer
{
    protected /* synthetic */ long baseSeed;
    private /* synthetic */ long worldGenSeed;
    protected /* synthetic */ GenLayer parent;
    private /* synthetic */ long chunkSeed;
    
    protected static boolean isBiomeOceanic(final int lllIIIIIlllIllI) {
        return lllIIIIIlllIllI == BiomeGenBase.ocean.biomeID || lllIIIIIlllIllI == BiomeGenBase.deepOcean.biomeID || lllIIIIIlllIllI == BiomeGenBase.frozenOcean.biomeID;
    }
    
    public abstract int[] getInts(final int p0, final int p1, final int p2, final int p3);
    
    public static GenLayer[] func_180781_a(final long lllIIIIllIIlIII, final WorldType lllIIIIlllIIlIl, final String lllIIIIlllIIlII) {
        final GenLayerIsland lllIIIIlllIIIll = new GenLayerIsland(1L);
        final GenLayerFuzzyZoom lllIIIIlllIIIlI = new GenLayerFuzzyZoom(2000L, lllIIIIlllIIIll);
        GenLayerAddIsland lllIIIIlllIIIIl = new GenLayerAddIsland(1L, lllIIIIlllIIIlI);
        GenLayerZoom lllIIIIlllIIIII = new GenLayerZoom(2001L, lllIIIIlllIIIIl);
        lllIIIIlllIIIIl = new GenLayerAddIsland(2L, lllIIIIlllIIIII);
        lllIIIIlllIIIIl = new GenLayerAddIsland(50L, lllIIIIlllIIIIl);
        lllIIIIlllIIIIl = new GenLayerAddIsland(70L, lllIIIIlllIIIIl);
        final GenLayerRemoveTooMuchOcean lllIIIIllIlllll = new GenLayerRemoveTooMuchOcean(2L, lllIIIIlllIIIIl);
        final GenLayerAddSnow lllIIIIllIllllI = new GenLayerAddSnow(2L, lllIIIIllIlllll);
        lllIIIIlllIIIIl = new GenLayerAddIsland(3L, lllIIIIllIllllI);
        GenLayerEdge lllIIIIllIlllIl = new GenLayerEdge(2L, lllIIIIlllIIIIl, GenLayerEdge.Mode.COOL_WARM);
        lllIIIIllIlllIl = new GenLayerEdge(2L, lllIIIIllIlllIl, GenLayerEdge.Mode.HEAT_ICE);
        lllIIIIllIlllIl = new GenLayerEdge(3L, lllIIIIllIlllIl, GenLayerEdge.Mode.SPECIAL);
        lllIIIIlllIIIII = new GenLayerZoom(2002L, lllIIIIllIlllIl);
        lllIIIIlllIIIII = new GenLayerZoom(2003L, lllIIIIlllIIIII);
        lllIIIIlllIIIIl = new GenLayerAddIsland(4L, lllIIIIlllIIIII);
        final GenLayerAddMushroomIsland lllIIIIllIlllII = new GenLayerAddMushroomIsland(5L, lllIIIIlllIIIIl);
        final GenLayerDeepOcean lllIIIIllIllIll = new GenLayerDeepOcean(4L, lllIIIIllIlllII);
        final GenLayer lllIIIIllIllIlI = GenLayerZoom.magnify(1000L, lllIIIIllIllIll, 0);
        ChunkProviderSettings lllIIIIllIllIIl = null;
        int lllIIIIllIlIlll;
        int lllIIIIllIllIII = lllIIIIllIlIlll = 4;
        if (lllIIIIlllIIlIl == WorldType.CUSTOMIZED && lllIIIIlllIIlII.length() > 0) {
            lllIIIIllIllIIl = ChunkProviderSettings.Factory.func_177865_a(lllIIIIlllIIlII).func_177864_b();
            lllIIIIllIllIII = lllIIIIllIllIIl.field_177780_G;
            lllIIIIllIlIlll = lllIIIIllIllIIl.field_177788_H;
        }
        if (lllIIIIlllIIlIl == WorldType.LARGE_BIOMES) {
            lllIIIIllIllIII = 6;
        }
        GenLayer lllIIIIllIlIllI = GenLayerZoom.magnify(1000L, lllIIIIllIllIlI, 0);
        final GenLayerRiverInit lllIIIIllIlIlIl = new GenLayerRiverInit(100L, lllIIIIllIlIllI);
        final GenLayerBiome lllIIIIllIlIlII = new GenLayerBiome(200L, lllIIIIllIllIlI, lllIIIIlllIIlIl, lllIIIIlllIIlII);
        final GenLayer lllIIIIllIlIIll = GenLayerZoom.magnify(1000L, lllIIIIllIlIlII, 2);
        final GenLayerBiomeEdge lllIIIIllIlIIlI = new GenLayerBiomeEdge(1000L, lllIIIIllIlIIll);
        final GenLayer lllIIIIllIlIIIl = GenLayerZoom.magnify(1000L, lllIIIIllIlIlIl, 2);
        final GenLayerHills lllIIIIllIlIIII = new GenLayerHills(1000L, lllIIIIllIlIIlI, lllIIIIllIlIIIl);
        lllIIIIllIlIllI = GenLayerZoom.magnify(1000L, lllIIIIllIlIlIl, 2);
        lllIIIIllIlIllI = GenLayerZoom.magnify(1000L, lllIIIIllIlIllI, lllIIIIllIlIlll);
        final GenLayerRiver lllIIIIllIIllll = new GenLayerRiver(1L, lllIIIIllIlIllI);
        final GenLayerSmooth lllIIIIllIIlllI = new GenLayerSmooth(1000L, lllIIIIllIIllll);
        Object lllIIIIllIIllIl = new GenLayerRareBiome(1001L, lllIIIIllIlIIII);
        for (int lllIIIIllIIllII = 0; lllIIIIllIIllII < lllIIIIllIllIII; ++lllIIIIllIIllII) {
            lllIIIIllIIllIl = new GenLayerZoom(1000 + lllIIIIllIIllII, (GenLayer)lllIIIIllIIllIl);
            if (lllIIIIllIIllII == 0) {
                lllIIIIllIIllIl = new GenLayerAddIsland(3L, (GenLayer)lllIIIIllIIllIl);
            }
            if (lllIIIIllIIllII == 1 || lllIIIIllIllIII == 1) {
                lllIIIIllIIllIl = new GenLayerShore(1000L, (GenLayer)lllIIIIllIIllIl);
            }
        }
        final GenLayerSmooth lllIIIIllIIlIll = new GenLayerSmooth(1000L, (GenLayer)lllIIIIllIIllIl);
        final GenLayerRiverMix lllIIIIllIIlIlI = new GenLayerRiverMix(100L, lllIIIIllIIlIll, lllIIIIllIIlllI);
        final GenLayerVoronoiZoom lllIIIIllIIlIIl = new GenLayerVoronoiZoom(10L, lllIIIIllIIlIlI);
        lllIIIIllIIlIlI.initWorldGenSeed(lllIIIIllIIlIII);
        lllIIIIllIIlIIl.initWorldGenSeed(lllIIIIllIIlIII);
        return new GenLayer[] { lllIIIIllIIlIlI, lllIIIIllIIlIIl, lllIIIIllIIlIlI };
    }
    
    protected static boolean biomesEqualOrMesaPlateau(final int lllIIIIIlllllll, final int lllIIIIlIIIIlIl) {
        if (lllIIIIIlllllll == lllIIIIlIIIIlIl) {
            return true;
        }
        if (lllIIIIIlllllll != BiomeGenBase.mesaPlateau_F.biomeID && lllIIIIIlllllll != BiomeGenBase.mesaPlateau.biomeID) {
            final BiomeGenBase lllIIIIlIIIIlII = BiomeGenBase.getBiome(lllIIIIIlllllll);
            final BiomeGenBase lllIIIIlIIIIIll = BiomeGenBase.getBiome(lllIIIIlIIIIlIl);
            try {
                return lllIIIIlIIIIlII != null && lllIIIIlIIIIIll != null && lllIIIIlIIIIlII.isEqualTo(lllIIIIlIIIIIll);
            }
            catch (Throwable lllIIIIlIIIIIlI) {
                final CrashReport lllIIIIlIIIIIIl = CrashReport.makeCrashReport(lllIIIIlIIIIIlI, "Comparing biomes");
                final CrashReportCategory lllIIIIlIIIIIII = lllIIIIlIIIIIIl.makeCategory("Biomes being compared");
                lllIIIIlIIIIIII.addCrashSection("Biome A ID", lllIIIIIlllllll);
                lllIIIIlIIIIIII.addCrashSection("Biome B ID", lllIIIIlIIIIlIl);
                lllIIIIlIIIIIII.addCrashSectionCallable("Biome A", new Callable() {
                    @Override
                    public String call() {
                        return String.valueOf(lllIIIIlIIIIlII);
                    }
                    
                    static {
                        __OBFID = "CL_00000560";
                    }
                });
                lllIIIIlIIIIIII.addCrashSectionCallable("Biome B", new Callable() {
                    @Override
                    public String call() {
                        return String.valueOf(lllIIIIlIIIIIll);
                    }
                    
                    static {
                        __OBFID = "CL_00000561";
                    }
                });
                throw new ReportedException(lllIIIIlIIIIIIl);
            }
        }
        return lllIIIIlIIIIlIl == BiomeGenBase.mesaPlateau_F.biomeID || lllIIIIlIIIIlIl == BiomeGenBase.mesaPlateau.biomeID;
    }
    
    public void initChunkSeed(final long lllIIIIlIIllIll, final long lllIIIIlIIlIlll) {
        this.chunkSeed = this.worldGenSeed;
        this.chunkSeed *= this.chunkSeed * 6364136223846793005L + 1442695040888963407L;
        this.chunkSeed += lllIIIIlIIllIll;
        this.chunkSeed *= this.chunkSeed * 6364136223846793005L + 1442695040888963407L;
        this.chunkSeed += lllIIIIlIIlIlll;
        this.chunkSeed *= this.chunkSeed * 6364136223846793005L + 1442695040888963407L;
        this.chunkSeed += lllIIIIlIIllIll;
        this.chunkSeed *= this.chunkSeed * 6364136223846793005L + 1442695040888963407L;
        this.chunkSeed += lllIIIIlIIlIlll;
    }
    
    public void initWorldGenSeed(final long lllIIIIlIlIIIII) {
        this.worldGenSeed = lllIIIIlIlIIIII;
        if (this.parent != null) {
            this.parent.initWorldGenSeed(lllIIIIlIlIIIII);
        }
        this.worldGenSeed *= this.worldGenSeed * 6364136223846793005L + 1442695040888963407L;
        this.worldGenSeed += this.baseSeed;
        this.worldGenSeed *= this.worldGenSeed * 6364136223846793005L + 1442695040888963407L;
        this.worldGenSeed += this.baseSeed;
        this.worldGenSeed *= this.worldGenSeed * 6364136223846793005L + 1442695040888963407L;
        this.worldGenSeed += this.baseSeed;
    }
    
    static {
        __OBFID = "CL_00000559";
    }
    
    protected int selectRandom(final int... lllIIIIIlllIIlI) {
        return lllIIIIIlllIIlI[this.nextInt(lllIIIIIlllIIlI.length)];
    }
    
    public GenLayer(final long lllIIIIlIlIlIII) {
        this.baseSeed = lllIIIIlIlIlIII;
        this.baseSeed *= this.baseSeed * 6364136223846793005L + 1442695040888963407L;
        this.baseSeed += lllIIIIlIlIlIII;
        this.baseSeed *= this.baseSeed * 6364136223846793005L + 1442695040888963407L;
        this.baseSeed += lllIIIIlIlIlIII;
        this.baseSeed *= this.baseSeed * 6364136223846793005L + 1442695040888963407L;
        this.baseSeed += lllIIIIlIlIlIII;
    }
    
    protected int nextInt(final int lllIIIIlIIlIIlI) {
        int lllIIIIlIIlIIIl = (int)((this.chunkSeed >> 24) % lllIIIIlIIlIIlI);
        if (lllIIIIlIIlIIIl < 0) {
            lllIIIIlIIlIIIl += lllIIIIlIIlIIlI;
        }
        this.chunkSeed *= this.chunkSeed * 6364136223846793005L + 1442695040888963407L;
        this.chunkSeed += this.worldGenSeed;
        return lllIIIIlIIlIIIl;
    }
    
    protected int selectModeOrRandom(final int lllIIIIIllIlIIl, final int lllIIIIIllIlIII, final int lllIIIIIllIIIlI, final int lllIIIIIllIIllI) {
        return (lllIIIIIllIlIII == lllIIIIIllIIIlI && lllIIIIIllIIIlI == lllIIIIIllIIllI) ? lllIIIIIllIlIII : ((lllIIIIIllIlIIl == lllIIIIIllIlIII && lllIIIIIllIlIIl == lllIIIIIllIIIlI) ? lllIIIIIllIlIIl : ((lllIIIIIllIlIIl == lllIIIIIllIlIII && lllIIIIIllIlIIl == lllIIIIIllIIllI) ? lllIIIIIllIlIIl : ((lllIIIIIllIlIIl == lllIIIIIllIIIlI && lllIIIIIllIlIIl == lllIIIIIllIIllI) ? lllIIIIIllIlIIl : ((lllIIIIIllIlIIl == lllIIIIIllIlIII && lllIIIIIllIIIlI != lllIIIIIllIIllI) ? lllIIIIIllIlIIl : ((lllIIIIIllIlIIl == lllIIIIIllIIIlI && lllIIIIIllIlIII != lllIIIIIllIIllI) ? lllIIIIIllIlIIl : ((lllIIIIIllIlIIl == lllIIIIIllIIllI && lllIIIIIllIlIII != lllIIIIIllIIIlI) ? lllIIIIIllIlIIl : ((lllIIIIIllIlIII == lllIIIIIllIIIlI && lllIIIIIllIlIIl != lllIIIIIllIIllI) ? lllIIIIIllIlIII : ((lllIIIIIllIlIII == lllIIIIIllIIllI && lllIIIIIllIlIIl != lllIIIIIllIIIlI) ? lllIIIIIllIlIII : ((lllIIIIIllIIIlI == lllIIIIIllIIllI && lllIIIIIllIlIIl != lllIIIIIllIlIII) ? lllIIIIIllIIIlI : this.selectRandom(lllIIIIIllIlIIl, lllIIIIIllIlIII, lllIIIIIllIIIlI, lllIIIIIllIIllI))))))))));
    }
}
