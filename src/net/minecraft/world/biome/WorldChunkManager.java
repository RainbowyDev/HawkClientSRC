package net.minecraft.world.biome;

import net.minecraft.world.gen.layer.*;
import net.minecraft.util.*;
import net.minecraft.crash.*;
import com.google.common.collect.*;
import java.util.*;
import net.minecraft.world.*;

public class WorldChunkManager
{
    private /* synthetic */ String field_180301_f;
    private /* synthetic */ GenLayer biomeIndexLayer;
    private /* synthetic */ GenLayer genBiomes;
    private /* synthetic */ List biomesToSpawnIn;
    private /* synthetic */ BiomeCache biomeCache;
    
    public BiomeGenBase[] loadBlockGeneratorData(final BiomeGenBase[] llllllllllllllIIIIIlllIIlIIIIlIl, final int llllllllllllllIIIIIlllIIlIIIIlII, final int llllllllllllllIIIIIlllIIIllllIll, final int llllllllllllllIIIIIlllIIIllllIlI, final int llllllllllllllIIIIIlllIIIllllIIl) {
        return this.getBiomeGenAt(llllllllllllllIIIIIlllIIlIIIIlIl, llllllllllllllIIIIIlllIIlIIIIlII, llllllllllllllIIIIIlllIIIllllIll, llllllllllllllIIIIIlllIIIllllIlI, llllllllllllllIIIIIlllIIIllllIIl, true);
    }
    
    public BiomeGenBase func_180631_a(final BlockPos llllllllllllllIIIIIlllIIllIlllIl) {
        return this.func_180300_a(llllllllllllllIIIIIlllIIllIlllIl, null);
    }
    
    public float getTemperatureAtHeight(final float llllllllllllllIIIIIlllIIlIlIllll, final int llllllllllllllIIIIIlllIIlIlIlllI) {
        return llllllllllllllIIIIIlllIIlIlIllll;
    }
    
    static {
        __OBFID = "CL_00000166";
    }
    
    public BiomeGenBase[] getBiomeGenAt(BiomeGenBase[] llllllllllllllIIIIIlllIIIlIlIIIl, final int llllllllllllllIIIIIlllIIIllIIIll, final int llllllllllllllIIIIIlllIIIllIIIIl, final int llllllllllllllIIIIIlllIIIlIlllll, final int llllllllllllllIIIIIlllIIIlIlllIl, final boolean llllllllllllllIIIIIlllIIIlIIIlll) {
        IntCache.resetIntCache();
        if (llllllllllllllIIIIIlllIIIlIlIIIl == null || llllllllllllllIIIIIlllIIIlIlIIIl.length < llllllllllllllIIIIIlllIIIlIlllll * llllllllllllllIIIIIlllIIIlIlllIl) {
            llllllllllllllIIIIIlllIIIlIlIIIl = new BiomeGenBase[llllllllllllllIIIIIlllIIIlIlllll * llllllllllllllIIIIIlllIIIlIlllIl];
        }
        if (llllllllllllllIIIIIlllIIIlIIIlll && llllllllllllllIIIIIlllIIIlIlllll == 16 && llllllllllllllIIIIIlllIIIlIlllIl == 16 && (llllllllllllllIIIIIlllIIIllIIIll & 0xF) == 0x0 && (llllllllllllllIIIIIlllIIIllIIIIl & 0xF) == 0x0) {
            final BiomeGenBase[] llllllllllllllIIIIIlllIIIlIllIIl = this.biomeCache.getCachedBiomes(llllllllllllllIIIIIlllIIIllIIIll, llllllllllllllIIIIIlllIIIllIIIIl);
            System.arraycopy(llllllllllllllIIIIIlllIIIlIllIIl, 0, llllllllllllllIIIIIlllIIIlIlIIIl, 0, llllllllllllllIIIIIlllIIIlIlllll * llllllllllllllIIIIIlllIIIlIlllIl);
            return (BiomeGenBase[])llllllllllllllIIIIIlllIIIlIlIIIl;
        }
        final int[] llllllllllllllIIIIIlllIIIlIlIlll = this.biomeIndexLayer.getInts(llllllllllllllIIIIIlllIIIllIIIll, llllllllllllllIIIIIlllIIIllIIIIl, llllllllllllllIIIIIlllIIIlIlllll, llllllllllllllIIIIIlllIIIlIlllIl);
        for (int llllllllllllllIIIIIlllIIIlIlIlIl = 0; llllllllllllllIIIIIlllIIIlIlIlIl < llllllllllllllIIIIIlllIIIlIlllll * llllllllllllllIIIIIlllIIIlIlllIl; ++llllllllllllllIIIIIlllIIIlIlIlIl) {
            llllllllllllllIIIIIlllIIIlIlIIIl[llllllllllllllIIIIIlllIIIlIlIlIl] = BiomeGenBase.getBiomeFromBiomeList(llllllllllllllIIIIIlllIIIlIlIlll[llllllllllllllIIIIIlllIIIlIlIlIl], BiomeGenBase.field_180279_ad);
        }
        return (BiomeGenBase[])llllllllllllllIIIIIlllIIIlIlIIIl;
    }
    
    public boolean areBiomesViable(final int llllllllllllllIIIIIlllIIIIIlllll, final int llllllllllllllIIIIIlllIIIIlIllll, final int llllllllllllllIIIIIlllIIIIIlllIl, final List llllllllllllllIIIIIlllIIIIlIllIl) {
        IntCache.resetIntCache();
        final int llllllllllllllIIIIIlllIIIIlIllII = llllllllllllllIIIIIlllIIIIIlllll - llllllllllllllIIIIIlllIIIIIlllIl >> 2;
        final int llllllllllllllIIIIIlllIIIIlIlIll = llllllllllllllIIIIIlllIIIIlIllll - llllllllllllllIIIIIlllIIIIIlllIl >> 2;
        final int llllllllllllllIIIIIlllIIIIlIlIlI = llllllllllllllIIIIIlllIIIIIlllll + llllllllllllllIIIIIlllIIIIIlllIl >> 2;
        final int llllllllllllllIIIIIlllIIIIlIlIIl = llllllllllllllIIIIIlllIIIIlIllll + llllllllllllllIIIIIlllIIIIIlllIl >> 2;
        final int llllllllllllllIIIIIlllIIIIlIlIII = llllllllllllllIIIIIlllIIIIlIlIlI - llllllllllllllIIIIIlllIIIIlIllII + 1;
        final int llllllllllllllIIIIIlllIIIIlIIlll = llllllllllllllIIIIIlllIIIIlIlIIl - llllllllllllllIIIIIlllIIIIlIlIll + 1;
        final int[] llllllllllllllIIIIIlllIIIIlIIllI = this.genBiomes.getInts(llllllllllllllIIIIIlllIIIIlIllII, llllllllllllllIIIIIlllIIIIlIlIll, llllllllllllllIIIIIlllIIIIlIlIII, llllllllllllllIIIIIlllIIIIlIIlll);
        try {
            for (int llllllllllllllIIIIIlllIIIIlIIlIl = 0; llllllllllllllIIIIIlllIIIIlIIlIl < llllllllllllllIIIIIlllIIIIlIlIII * llllllllllllllIIIIIlllIIIIlIIlll; ++llllllllllllllIIIIIlllIIIIlIIlIl) {
                final BiomeGenBase llllllllllllllIIIIIlllIIIIlIIlII = BiomeGenBase.getBiome(llllllllllllllIIIIIlllIIIIlIIllI[llllllllllllllIIIIIlllIIIIlIIlIl]);
                if (!llllllllllllllIIIIIlllIIIIlIllIl.contains(llllllllllllllIIIIIlllIIIIlIIlII)) {
                    return false;
                }
            }
            return true;
        }
        catch (Throwable llllllllllllllIIIIIlllIIIIlIIIll) {
            final CrashReport llllllllllllllIIIIIlllIIIIlIIIlI = CrashReport.makeCrashReport(llllllllllllllIIIIIlllIIIIlIIIll, "Invalid Biome id");
            final CrashReportCategory llllllllllllllIIIIIlllIIIIlIIIIl = llllllllllllllIIIIIlllIIIIlIIIlI.makeCategory("Layer");
            llllllllllllllIIIIIlllIIIIlIIIIl.addCrashSection("Layer", this.genBiomes.toString());
            llllllllllllllIIIIIlllIIIIlIIIIl.addCrashSection("x", llllllllllllllIIIIIlllIIIIIlllll);
            llllllllllllllIIIIIlllIIIIlIIIIl.addCrashSection("z", llllllllllllllIIIIIlllIIIIlIllll);
            llllllllllllllIIIIIlllIIIIlIIIIl.addCrashSection("radius", llllllllllllllIIIIIlllIIIIIlllIl);
            llllllllllllllIIIIIlllIIIIlIIIIl.addCrashSection("allowed", llllllllllllllIIIIIlllIIIIlIllIl);
            throw new ReportedException(llllllllllllllIIIIIlllIIIIlIIIlI);
        }
    }
    
    protected WorldChunkManager() {
        this.biomeCache = new BiomeCache(this);
        this.field_180301_f = "";
        this.biomesToSpawnIn = Lists.newArrayList();
        this.biomesToSpawnIn.add(BiomeGenBase.forest);
        this.biomesToSpawnIn.add(BiomeGenBase.plains);
        this.biomesToSpawnIn.add(BiomeGenBase.taiga);
        this.biomesToSpawnIn.add(BiomeGenBase.taigaHills);
        this.biomesToSpawnIn.add(BiomeGenBase.forestHills);
        this.biomesToSpawnIn.add(BiomeGenBase.jungle);
        this.biomesToSpawnIn.add(BiomeGenBase.jungleHills);
    }
    
    public BlockPos findBiomePosition(final int llllllllllllllIIIIIllIllllllllIl, final int llllllllllllllIIIIIllIlllllIlIIl, final int llllllllllllllIIIIIllIlllllllIll, final List llllllllllllllIIIIIllIlllllllIlI, final Random llllllllllllllIIIIIllIlllllIIllI) {
        IntCache.resetIntCache();
        final int llllllllllllllIIIIIllIlllllllIII = llllllllllllllIIIIIllIllllllllIl - llllllllllllllIIIIIllIlllllllIll >> 2;
        final int llllllllllllllIIIIIllIllllllIlll = llllllllllllllIIIIIllIlllllIlIIl - llllllllllllllIIIIIllIlllllllIll >> 2;
        final int llllllllllllllIIIIIllIllllllIllI = llllllllllllllIIIIIllIllllllllIl + llllllllllllllIIIIIllIlllllllIll >> 2;
        final int llllllllllllllIIIIIllIllllllIlIl = llllllllllllllIIIIIllIlllllIlIIl + llllllllllllllIIIIIllIlllllllIll >> 2;
        final int llllllllllllllIIIIIllIllllllIlII = llllllllllllllIIIIIllIllllllIllI - llllllllllllllIIIIIllIlllllllIII + 1;
        final int llllllllllllllIIIIIllIllllllIIll = llllllllllllllIIIIIllIllllllIlIl - llllllllllllllIIIIIllIllllllIlll + 1;
        final int[] llllllllllllllIIIIIllIllllllIIlI = this.genBiomes.getInts(llllllllllllllIIIIIllIlllllllIII, llllllllllllllIIIIIllIllllllIlll, llllllllllllllIIIIIllIllllllIlII, llllllllllllllIIIIIllIllllllIIll);
        BlockPos llllllllllllllIIIIIllIllllllIIIl = null;
        int llllllllllllllIIIIIllIllllllIIII = 0;
        for (int llllllllllllllIIIIIllIlllllIllll = 0; llllllllllllllIIIIIllIlllllIllll < llllllllllllllIIIIIllIllllllIlII * llllllllllllllIIIIIllIllllllIIll; ++llllllllllllllIIIIIllIlllllIllll) {
            final int llllllllllllllIIIIIllIlllllIlllI = llllllllllllllIIIIIllIlllllllIII + llllllllllllllIIIIIllIlllllIllll % llllllllllllllIIIIIllIllllllIlII << 2;
            final int llllllllllllllIIIIIllIlllllIllIl = llllllllllllllIIIIIllIllllllIlll + llllllllllllllIIIIIllIlllllIllll / llllllllllllllIIIIIllIllllllIlII << 2;
            final BiomeGenBase llllllllllllllIIIIIllIlllllIllII = BiomeGenBase.getBiome(llllllllllllllIIIIIllIllllllIIlI[llllllllllllllIIIIIllIlllllIllll]);
            if (llllllllllllllIIIIIllIlllllllIlI.contains(llllllllllllllIIIIIllIlllllIllII) && (llllllllllllllIIIIIllIllllllIIIl == null || llllllllllllllIIIIIllIlllllIIllI.nextInt(llllllllllllllIIIIIllIllllllIIII + 1) == 0)) {
                llllllllllllllIIIIIllIllllllIIIl = new BlockPos(llllllllllllllIIIIIllIlllllIlllI, 0, llllllllllllllIIIIIllIlllllIllIl);
                ++llllllllllllllIIIIIllIllllllIIII;
            }
        }
        return llllllllllllllIIIIIllIllllllIIIl;
    }
    
    public void cleanupCache() {
        this.biomeCache.cleanupCache();
    }
    
    public BiomeGenBase[] getBiomesForGeneration(BiomeGenBase[] llllllllllllllIIIIIlllIIlIIlIllI, final int llllllllllllllIIIIIlllIIlIIlIlIl, final int llllllllllllllIIIIIlllIIlIIlllll, final int llllllllllllllIIIIIlllIIlIIllllI, final int llllllllllllllIIIIIlllIIlIIlllIl) {
        IntCache.resetIntCache();
        if (llllllllllllllIIIIIlllIIlIIlIllI == null || llllllllllllllIIIIIlllIIlIIlIllI.length < llllllllllllllIIIIIlllIIlIIllllI * llllllllllllllIIIIIlllIIlIIlllIl) {
            llllllllllllllIIIIIlllIIlIIlIllI = new BiomeGenBase[llllllllllllllIIIIIlllIIlIIllllI * llllllllllllllIIIIIlllIIlIIlllIl];
        }
        final int[] llllllllllllllIIIIIlllIIlIIlllII = this.genBiomes.getInts(llllllllllllllIIIIIlllIIlIIlIlIl, llllllllllllllIIIIIlllIIlIIlllll, llllllllllllllIIIIIlllIIlIIllllI, llllllllllllllIIIIIlllIIlIIlllIl);
        try {
            for (int llllllllllllllIIIIIlllIIlIIllIll = 0; llllllllllllllIIIIIlllIIlIIllIll < llllllllllllllIIIIIlllIIlIIllllI * llllllllllllllIIIIIlllIIlIIlllIl; ++llllllllllllllIIIIIlllIIlIIllIll) {
                llllllllllllllIIIIIlllIIlIIlIllI[llllllllllllllIIIIIlllIIlIIllIll] = BiomeGenBase.getBiomeFromBiomeList(llllllllllllllIIIIIlllIIlIIlllII[llllllllllllllIIIIIlllIIlIIllIll], BiomeGenBase.field_180279_ad);
            }
            return (BiomeGenBase[])llllllllllllllIIIIIlllIIlIIlIllI;
        }
        catch (Throwable llllllllllllllIIIIIlllIIlIIllIlI) {
            final CrashReport llllllllllllllIIIIIlllIIlIIllIIl = CrashReport.makeCrashReport(llllllllllllllIIIIIlllIIlIIllIlI, "Invalid Biome id");
            final CrashReportCategory llllllllllllllIIIIIlllIIlIIllIII = llllllllllllllIIIIIlllIIlIIllIIl.makeCategory("RawBiomeBlock");
            llllllllllllllIIIIIlllIIlIIllIII.addCrashSection("biomes[] size", llllllllllllllIIIIIlllIIlIIlIllI.length);
            llllllllllllllIIIIIlllIIlIIllIII.addCrashSection("x", llllllllllllllIIIIIlllIIlIIlIlIl);
            llllllllllllllIIIIIlllIIlIIllIII.addCrashSection("z", llllllllllllllIIIIIlllIIlIIlllll);
            llllllllllllllIIIIIlllIIlIIllIII.addCrashSection("w", llllllllllllllIIIIIlllIIlIIllllI);
            llllllllllllllIIIIIlllIIlIIllIII.addCrashSection("h", llllllllllllllIIIIIlllIIlIIlllIl);
            throw new ReportedException(llllllllllllllIIIIIlllIIlIIllIIl);
        }
    }
    
    public WorldChunkManager(final World llllllllllllllIIIIIlllIIlllIlIII) {
        this(llllllllllllllIIIIIlllIIlllIlIII.getSeed(), llllllllllllllIIIIIlllIIlllIlIII.getWorldInfo().getTerrainType(), llllllllllllllIIIIIlllIIlllIlIII.getWorldInfo().getGeneratorOptions());
    }
    
    public float[] getRainfall(float[] llllllllllllllIIIIIlllIIlIlllIll, final int llllllllllllllIIIIIlllIIllIIIllI, final int llllllllllllllIIIIIlllIIlIlllIIl, final int llllllllllllllIIIIIlllIIllIIIlII, final int llllllllllllllIIIIIlllIIllIIIIll) {
        IntCache.resetIntCache();
        if (llllllllllllllIIIIIlllIIlIlllIll == null || llllllllllllllIIIIIlllIIlIlllIll.length < llllllllllllllIIIIIlllIIllIIIlII * llllllllllllllIIIIIlllIIllIIIIll) {
            llllllllllllllIIIIIlllIIlIlllIll = new float[llllllllllllllIIIIIlllIIllIIIlII * llllllllllllllIIIIIlllIIllIIIIll];
        }
        final int[] llllllllllllllIIIIIlllIIllIIIIlI = this.biomeIndexLayer.getInts(llllllllllllllIIIIIlllIIllIIIllI, llllllllllllllIIIIIlllIIlIlllIIl, llllllllllllllIIIIIlllIIllIIIlII, llllllllllllllIIIIIlllIIllIIIIll);
        for (int llllllllllllllIIIIIlllIIllIIIIIl = 0; llllllllllllllIIIIIlllIIllIIIIIl < llllllllllllllIIIIIlllIIllIIIlII * llllllllllllllIIIIIlllIIllIIIIll; ++llllllllllllllIIIIIlllIIllIIIIIl) {
            try {
                float llllllllllllllIIIIIlllIIllIIIIII = BiomeGenBase.getBiomeFromBiomeList(llllllllllllllIIIIIlllIIllIIIIlI[llllllllllllllIIIIIlllIIllIIIIIl], BiomeGenBase.field_180279_ad).getIntRainfall() / 65536.0f;
                if (llllllllllllllIIIIIlllIIllIIIIII > 1.0f) {
                    llllllllllllllIIIIIlllIIllIIIIII = 1.0f;
                }
                llllllllllllllIIIIIlllIIlIlllIll[llllllllllllllIIIIIlllIIllIIIIIl] = llllllllllllllIIIIIlllIIllIIIIII;
            }
            catch (Throwable llllllllllllllIIIIIlllIIlIllllll) {
                final CrashReport llllllllllllllIIIIIlllIIlIlllllI = CrashReport.makeCrashReport(llllllllllllllIIIIIlllIIlIllllll, "Invalid Biome id");
                final CrashReportCategory llllllllllllllIIIIIlllIIlIllllIl = llllllllllllllIIIIIlllIIlIlllllI.makeCategory("DownfallBlock");
                llllllllllllllIIIIIlllIIlIllllIl.addCrashSection("biome id", llllllllllllllIIIIIlllIIllIIIIIl);
                llllllllllllllIIIIIlllIIlIllllIl.addCrashSection("downfalls[] size", llllllllllllllIIIIIlllIIlIlllIll.length);
                llllllllllllllIIIIIlllIIlIllllIl.addCrashSection("x", llllllllllllllIIIIIlllIIllIIIllI);
                llllllllllllllIIIIIlllIIlIllllIl.addCrashSection("z", llllllllllllllIIIIIlllIIlIlllIIl);
                llllllllllllllIIIIIlllIIlIllllIl.addCrashSection("w", llllllllllllllIIIIIlllIIllIIIlII);
                llllllllllllllIIIIIlllIIlIllllIl.addCrashSection("h", llllllllllllllIIIIIlllIIllIIIIll);
                throw new ReportedException(llllllllllllllIIIIIlllIIlIlllllI);
            }
        }
        return llllllllllllllIIIIIlllIIlIlllIll;
    }
    
    public List getBiomesToSpawnIn() {
        return this.biomesToSpawnIn;
    }
    
    public WorldChunkManager(final long llllllllllllllIIIIIlllIIlllIllll, final WorldType llllllllllllllIIIIIlllIIlllIlllI, final String llllllllllllllIIIIIlllIIllllIIlI) {
        this();
        this.field_180301_f = llllllllllllllIIIIIlllIIllllIIlI;
        final GenLayer[] llllllllllllllIIIIIlllIIllllIIIl = GenLayer.func_180781_a(llllllllllllllIIIIIlllIIlllIllll, llllllllllllllIIIIIlllIIlllIlllI, llllllllllllllIIIIIlllIIllllIIlI);
        this.genBiomes = llllllllllllllIIIIIlllIIllllIIIl[0];
        this.biomeIndexLayer = llllllllllllllIIIIIlllIIllllIIIl[1];
    }
    
    public BiomeGenBase func_180300_a(final BlockPos llllllllllllllIIIIIlllIIllIllIII, final BiomeGenBase llllllllllllllIIIIIlllIIllIlIlll) {
        return this.biomeCache.func_180284_a(llllllllllllllIIIIIlllIIllIllIII.getX(), llllllllllllllIIIIIlllIIllIllIII.getZ(), llllllllllllllIIIIIlllIIllIlIlll);
    }
}
