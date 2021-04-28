package net.minecraft.world.gen;

import net.minecraft.world.biome.*;
import net.minecraft.world.gen.structure.*;
import net.minecraft.init.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.world.chunk.*;
import net.minecraft.block.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.*;

public class ChunkProviderGenerate implements IChunkProvider
{
    private /* synthetic */ MapGenBase ravineGenerator;
    private /* synthetic */ StructureOceanMonument field_177474_A;
    private /* synthetic */ Block field_177476_s;
    private /* synthetic */ ChunkProviderSettings field_177477_r;
    private final /* synthetic */ boolean mapFeaturesEnabled;
    /* synthetic */ double[] field_147426_g;
    private /* synthetic */ double[] stoneNoise;
    private /* synthetic */ MapGenMineshaft mineshaftGenerator;
    private /* synthetic */ Random rand;
    private /* synthetic */ MapGenBase caveGenerator;
    public /* synthetic */ NoiseGeneratorOctaves noiseGen6;
    private final /* synthetic */ float[] parabolicField;
    private /* synthetic */ World worldObj;
    /* synthetic */ double[] field_147427_d;
    private /* synthetic */ WorldType field_177475_o;
    private /* synthetic */ NoiseGeneratorPerlin field_147430_m;
    private /* synthetic */ BiomeGenBase[] biomesForGeneration;
    private /* synthetic */ NoiseGeneratorOctaves field_147432_k;
    private final /* synthetic */ double[] field_147434_q;
    private /* synthetic */ NoiseGeneratorOctaves field_147431_j;
    private /* synthetic */ MapGenScatteredFeature scatteredFeatureGenerator;
    public /* synthetic */ NoiseGeneratorOctaves mobSpawnerNoise;
    public /* synthetic */ NoiseGeneratorOctaves noiseGen5;
    /* synthetic */ double[] field_147428_e;
    private /* synthetic */ NoiseGeneratorOctaves field_147429_l;
    /* synthetic */ double[] field_147425_f;
    private /* synthetic */ MapGenVillage villageGenerator;
    private /* synthetic */ MapGenStronghold strongholdGenerator;
    
    @Override
    public boolean saveChunks(final boolean llllllllllllllIllIllIIIIIIllIlll, final IProgressUpdate llllllllllllllIllIllIIIIIIllIllI) {
        return true;
    }
    
    @Override
    public boolean func_177460_a(final IChunkProvider llllllllllllllIllIllIIIIIlIIIIlI, final Chunk llllllllllllllIllIllIIIIIlIIIIIl, final int llllllllllllllIllIllIIIIIlIIIIII, final int llllllllllllllIllIllIIIIIIlllIlI) {
        boolean llllllllllllllIllIllIIIIIIlllllI = false;
        if (this.field_177477_r.field_177852_y && this.mapFeaturesEnabled && llllllllllllllIllIllIIIIIlIIIIIl.getInhabitedTime() < 3600L) {
            llllllllllllllIllIllIIIIIIlllllI |= this.field_177474_A.func_175794_a(this.worldObj, this.rand, new ChunkCoordIntPair(llllllllllllllIllIllIIIIIlIIIIII, llllllllllllllIllIllIIIIIIlllIlI));
        }
        return llllllllllllllIllIllIIIIIIlllllI;
    }
    
    public ChunkProviderGenerate(final World llllllllllllllIllIllIIlIIIIIIIlI, final long llllllllllllllIllIllIIlIIIIIIIII, final boolean llllllllllllllIllIllIIlIIIIIlIll, final String llllllllllllllIllIllIIlIIIIIlIlI) {
        this.field_177476_s = Blocks.water;
        this.stoneNoise = new double[256];
        this.caveGenerator = new MapGenCaves();
        this.strongholdGenerator = new MapGenStronghold();
        this.villageGenerator = new MapGenVillage();
        this.mineshaftGenerator = new MapGenMineshaft();
        this.scatteredFeatureGenerator = new MapGenScatteredFeature();
        this.ravineGenerator = new MapGenRavine();
        this.field_177474_A = new StructureOceanMonument();
        this.worldObj = llllllllllllllIllIllIIlIIIIIIIlI;
        this.mapFeaturesEnabled = llllllllllllllIllIllIIlIIIIIlIll;
        this.field_177475_o = llllllllllllllIllIllIIlIIIIIIIlI.getWorldInfo().getTerrainType();
        this.rand = new Random(llllllllllllllIllIllIIlIIIIIIIII);
        this.field_147431_j = new NoiseGeneratorOctaves(this.rand, 16);
        this.field_147432_k = new NoiseGeneratorOctaves(this.rand, 16);
        this.field_147429_l = new NoiseGeneratorOctaves(this.rand, 8);
        this.field_147430_m = new NoiseGeneratorPerlin(this.rand, 4);
        this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
        this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
        this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);
        this.field_147434_q = new double[825];
        this.parabolicField = new float[25];
        for (int llllllllllllllIllIllIIlIIIIIlIII = -2; llllllllllllllIllIllIIlIIIIIlIII <= 2; ++llllllllllllllIllIllIIlIIIIIlIII) {
            for (int llllllllllllllIllIllIIlIIIIIIlll = -2; llllllllllllllIllIllIIlIIIIIIlll <= 2; ++llllllllllllllIllIllIIlIIIIIIlll) {
                final float llllllllllllllIllIllIIlIIIIIIllI = 10.0f / MathHelper.sqrt_float(llllllllllllllIllIllIIlIIIIIlIII * llllllllllllllIllIllIIlIIIIIlIII + llllllllllllllIllIllIIlIIIIIIlll * llllllllllllllIllIllIIlIIIIIIlll + 0.2f);
                this.parabolicField[llllllllllllllIllIllIIlIIIIIlIII + 2 + (llllllllllllllIllIllIIlIIIIIIlll + 2) * 5] = llllllllllllllIllIllIIlIIIIIIllI;
            }
        }
        if (llllllllllllllIllIllIIlIIIIIlIlI != null) {
            this.field_177477_r = ChunkProviderSettings.Factory.func_177865_a(llllllllllllllIllIllIIlIIIIIlIlI).func_177864_b();
            this.field_177476_s = (this.field_177477_r.field_177778_E ? Blocks.lava : Blocks.water);
        }
    }
    
    @Override
    public List func_177458_a(final EnumCreatureType llllllllllllllIllIllIIIIIIlIllII, final BlockPos llllllllllllllIllIllIIIIIIlIlIll) {
        final BiomeGenBase llllllllllllllIllIllIIIIIIlIlIlI = this.worldObj.getBiomeGenForCoords(llllllllllllllIllIllIIIIIIlIlIll);
        if (this.mapFeaturesEnabled) {
            if (llllllllllllllIllIllIIIIIIlIllII == EnumCreatureType.MONSTER && this.scatteredFeatureGenerator.func_175798_a(llllllllllllllIllIllIIIIIIlIlIll)) {
                return this.scatteredFeatureGenerator.getScatteredFeatureSpawnList();
            }
            if (llllllllllllllIllIllIIIIIIlIllII == EnumCreatureType.MONSTER && this.field_177477_r.field_177852_y && this.field_177474_A.func_175796_a(this.worldObj, llllllllllllllIllIllIIIIIIlIlIll)) {
                return this.field_177474_A.func_175799_b();
            }
        }
        return llllllllllllllIllIllIIIIIIlIlIlI.getSpawnableList(llllllllllllllIllIllIIIIIIlIllII);
    }
    
    @Override
    public void func_180514_a(final Chunk llllllllllllllIllIllIIIIIIIlIlII, final int llllllllllllllIllIllIIIIIIIlIIII, final int llllllllllllllIllIllIIIIIIIlIIlI) {
        if (this.field_177477_r.field_177829_w && this.mapFeaturesEnabled) {
            this.mineshaftGenerator.func_175792_a(this, this.worldObj, llllllllllllllIllIllIIIIIIIlIIII, llllllllllllllIllIllIIIIIIIlIIlI, null);
        }
        if (this.field_177477_r.field_177831_v && this.mapFeaturesEnabled) {
            this.villageGenerator.func_175792_a(this, this.worldObj, llllllllllllllIllIllIIIIIIIlIIII, llllllllllllllIllIllIIIIIIIlIIlI, null);
        }
        if (this.field_177477_r.field_177833_u && this.mapFeaturesEnabled) {
            this.strongholdGenerator.func_175792_a(this, this.worldObj, llllllllllllllIllIllIIIIIIIlIIII, llllllllllllllIllIllIIIIIIIlIIlI, null);
        }
        if (this.field_177477_r.field_177854_x && this.mapFeaturesEnabled) {
            this.scatteredFeatureGenerator.func_175792_a(this, this.worldObj, llllllllllllllIllIllIIIIIIIlIIII, llllllllllllllIllIllIIIIIIIlIIlI, null);
        }
        if (this.field_177477_r.field_177852_y && this.mapFeaturesEnabled) {
            this.field_177474_A.func_175792_a(this, this.worldObj, llllllllllllllIllIllIIIIIIIlIIII, llllllllllllllIllIllIIIIIIIlIIlI, null);
        }
    }
    
    @Override
    public BlockPos func_180513_a(final World llllllllllllllIllIllIIIIIIlIIIII, final String llllllllllllllIllIllIIIIIIIlllll, final BlockPos llllllllllllllIllIllIIIIIIIllIlI) {
        return ("Stronghold".equals(llllllllllllllIllIllIIIIIIIlllll) && this.strongholdGenerator != null) ? this.strongholdGenerator.func_180706_b(llllllllllllllIllIllIIIIIIlIIIII, llllllllllllllIllIllIIIIIIIllIlI) : null;
    }
    
    @Override
    public String makeString() {
        return "RandomLevelSource";
    }
    
    public void func_180518_a(final int llllllllllllllIllIllIIIllIIlIIIl, final int llllllllllllllIllIllIIIllIIlIIII, final ChunkPrimer llllllllllllllIllIllIIIlIlIllIII) {
        this.biomesForGeneration = this.worldObj.getWorldChunkManager().getBiomesForGeneration(this.biomesForGeneration, llllllllllllllIllIllIIIllIIlIIIl * 4 - 2, llllllllllllllIllIllIIIllIIlIIII * 4 - 2, 10, 10);
        this.func_147423_a(llllllllllllllIllIllIIIllIIlIIIl * 4, 0, llllllllllllllIllIllIIIllIIlIIII * 4);
        for (int llllllllllllllIllIllIIIllIIIlllI = 0; llllllllllllllIllIllIIIllIIIlllI < 4; ++llllllllllllllIllIllIIIllIIIlllI) {
            final int llllllllllllllIllIllIIIllIIIllIl = llllllllllllllIllIllIIIllIIIlllI * 5;
            final int llllllllllllllIllIllIIIllIIIllII = (llllllllllllllIllIllIIIllIIIlllI + 1) * 5;
            for (int llllllllllllllIllIllIIIllIIIlIlI = 0; llllllllllllllIllIllIIIllIIIlIlI < 4; ++llllllllllllllIllIllIIIllIIIlIlI) {
                final int llllllllllllllIllIllIIIllIIIlIIl = (llllllllllllllIllIllIIIllIIIllIl + llllllllllllllIllIllIIIllIIIlIlI) * 33;
                final int llllllllllllllIllIllIIIllIIIlIII = (llllllllllllllIllIllIIIllIIIllIl + llllllllllllllIllIllIIIllIIIlIlI + 1) * 33;
                final int llllllllllllllIllIllIIIllIIIIllI = (llllllllllllllIllIllIIIllIIIllII + llllllllllllllIllIllIIIllIIIlIlI) * 33;
                final int llllllllllllllIllIllIIIllIIIIlII = (llllllllllllllIllIllIIIllIIIllII + llllllllllllllIllIllIIIllIIIlIlI + 1) * 33;
                for (int llllllllllllllIllIllIIIllIIIIIlI = 0; llllllllllllllIllIllIIIllIIIIIlI < 32; ++llllllllllllllIllIllIIIllIIIIIlI) {
                    final double llllllllllllllIllIllIIIllIIIIIII = 0.125;
                    double llllllllllllllIllIllIIIlIllllllI = this.field_147434_q[llllllllllllllIllIllIIIllIIIlIIl + llllllllllllllIllIllIIIllIIIIIlI];
                    double llllllllllllllIllIllIIIlIlllllII = this.field_147434_q[llllllllllllllIllIllIIIllIIIlIII + llllllllllllllIllIllIIIllIIIIIlI];
                    double llllllllllllllIllIllIIIlIllllIlI = this.field_147434_q[llllllllllllllIllIllIIIllIIIIllI + llllllllllllllIllIllIIIllIIIIIlI];
                    double llllllllllllllIllIllIIIlIllllIII = this.field_147434_q[llllllllllllllIllIllIIIllIIIIlII + llllllllllllllIllIllIIIllIIIIIlI];
                    final double llllllllllllllIllIllIIIlIlllIllI = (this.field_147434_q[llllllllllllllIllIllIIIllIIIlIIl + llllllllllllllIllIllIIIllIIIIIlI + 1] - llllllllllllllIllIllIIIlIllllllI) * llllllllllllllIllIllIIIllIIIIIII;
                    final double llllllllllllllIllIllIIIlIlllIlII = (this.field_147434_q[llllllllllllllIllIllIIIllIIIlIII + llllllllllllllIllIllIIIllIIIIIlI + 1] - llllllllllllllIllIllIIIlIlllllII) * llllllllllllllIllIllIIIllIIIIIII;
                    final double llllllllllllllIllIllIIIlIlllIIlI = (this.field_147434_q[llllllllllllllIllIllIIIllIIIIllI + llllllllllllllIllIllIIIllIIIIIlI + 1] - llllllllllllllIllIllIIIlIllllIlI) * llllllllllllllIllIllIIIllIIIIIII;
                    final double llllllllllllllIllIllIIIlIlllIIII = (this.field_147434_q[llllllllllllllIllIllIIIllIIIIlII + llllllllllllllIllIllIIIllIIIIIlI + 1] - llllllllllllllIllIllIIIlIllllIII) * llllllllllllllIllIllIIIllIIIIIII;
                    for (int llllllllllllllIllIllIIIlIllIlllI = 0; llllllllllllllIllIllIIIlIllIlllI < 8; ++llllllllllllllIllIllIIIlIllIlllI) {
                        final double llllllllllllllIllIllIIIlIllIllII = 0.25;
                        double llllllllllllllIllIllIIIlIllIlIlI = llllllllllllllIllIllIIIlIllllllI;
                        double llllllllllllllIllIllIIIlIllIlIII = llllllllllllllIllIllIIIlIlllllII;
                        final double llllllllllllllIllIllIIIlIllIIllI = (llllllllllllllIllIllIIIlIllllIlI - llllllllllllllIllIllIIIlIllllllI) * llllllllllllllIllIllIIIlIllIllII;
                        final double llllllllllllllIllIllIIIlIllIIlII = (llllllllllllllIllIllIIIlIllllIII - llllllllllllllIllIllIIIlIlllllII) * llllllllllllllIllIllIIIlIllIllII;
                        for (int llllllllllllllIllIllIIIlIllIIIlI = 0; llllllllllllllIllIllIIIlIllIIIlI < 4; ++llllllllllllllIllIllIIIlIllIIIlI) {
                            final double llllllllllllllIllIllIIIlIllIIIII = 0.25;
                            final double llllllllllllllIllIllIIIlIlIllllI = (llllllllllllllIllIllIIIlIllIlIII - llllllllllllllIllIllIIIlIllIlIlI) * llllllllllllllIllIllIIIlIllIIIII;
                            double llllllllllllllIllIllIIIlIlIlllIl = llllllllllllllIllIllIIIlIllIlIlI - llllllllllllllIllIllIIIlIlIllllI;
                            for (int llllllllllllllIllIllIIIlIlIlllII = 0; llllllllllllllIllIllIIIlIlIlllII < 4; ++llllllllllllllIllIllIIIlIlIlllII) {
                                if ((llllllllllllllIllIllIIIlIlIlllIl += llllllllllllllIllIllIIIlIlIllllI) > 0.0) {
                                    llllllllllllllIllIllIIIlIlIllIII.setBlockState(llllllllllllllIllIllIIIllIIIlllI * 4 + llllllllllllllIllIllIIIlIllIIIlI, llllllllllllllIllIllIIIllIIIIIlI * 8 + llllllllllllllIllIllIIIlIllIlllI, llllllllllllllIllIllIIIllIIIlIlI * 4 + llllllllllllllIllIllIIIlIlIlllII, Blocks.stone.getDefaultState());
                                }
                                else if (llllllllllllllIllIllIIIllIIIIIlI * 8 + llllllllllllllIllIllIIIlIllIlllI < this.field_177477_r.field_177841_q) {
                                    llllllllllllllIllIllIIIlIlIllIII.setBlockState(llllllllllllllIllIllIIIllIIIlllI * 4 + llllllllllllllIllIllIIIlIllIIIlI, llllllllllllllIllIllIIIllIIIIIlI * 8 + llllllllllllllIllIllIIIlIllIlllI, llllllllllllllIllIllIIIllIIIlIlI * 4 + llllllllllllllIllIllIIIlIlIlllII, this.field_177476_s.getDefaultState());
                                }
                            }
                            llllllllllllllIllIllIIIlIllIlIlI += llllllllllllllIllIllIIIlIllIIllI;
                            llllllllllllllIllIllIIIlIllIlIII += llllllllllllllIllIllIIIlIllIIlII;
                        }
                        llllllllllllllIllIllIIIlIllllllI += llllllllllllllIllIllIIIlIlllIllI;
                        llllllllllllllIllIllIIIlIlllllII += llllllllllllllIllIllIIIlIlllIlII;
                        llllllllllllllIllIllIIIlIllllIlI += llllllllllllllIllIllIIIlIlllIIlI;
                        llllllllllllllIllIllIIIlIllllIII += llllllllllllllIllIllIIIlIlllIIII;
                    }
                }
            }
        }
    }
    
    @Override
    public int getLoadedChunkCount() {
        return 0;
    }
    
    public void func_180517_a(final int llllllllllllllIllIllIIIlIIIIIIlI, final int llllllllllllllIllIllIIIlIIIIllIl, final ChunkPrimer llllllllllllllIllIllIIIlIIIIIIII, final BiomeGenBase[] llllllllllllllIllIllIIIIllllllll) {
        final double llllllllllllllIllIllIIIlIIIIlIIl = 0.03125;
        this.stoneNoise = this.field_147430_m.func_151599_a(this.stoneNoise, llllllllllllllIllIllIIIlIIIIIIlI * 16, llllllllllllllIllIllIIIlIIIIllIl * 16, 16, 16, llllllllllllllIllIllIIIlIIIIlIIl * 2.0, llllllllllllllIllIllIIIlIIIIlIIl * 2.0, 1.0);
        for (int llllllllllllllIllIllIIIlIIIIIlll = 0; llllllllllllllIllIllIIIlIIIIIlll < 16; ++llllllllllllllIllIllIIIlIIIIIlll) {
            for (int llllllllllllllIllIllIIIlIIIIIlIl = 0; llllllllllllllIllIllIIIlIIIIIlIl < 16; ++llllllllllllllIllIllIIIlIIIIIlIl) {
                final BiomeGenBase llllllllllllllIllIllIIIlIIIIIlII = llllllllllllllIllIllIIIIllllllll[llllllllllllllIllIllIIIlIIIIIlIl + llllllllllllllIllIllIIIlIIIIIlll * 16];
                llllllllllllllIllIllIIIlIIIIIlII.genTerrainBlocks(this.worldObj, this.rand, llllllllllllllIllIllIIIlIIIIIIII, llllllllllllllIllIllIIIlIIIIIIlI * 16 + llllllllllllllIllIllIIIlIIIIIlll, llllllllllllllIllIllIIIlIIIIllIl * 16 + llllllllllllllIllIllIIIlIIIIIlIl, this.stoneNoise[llllllllllllllIllIllIIIlIIIIIlIl + llllllllllllllIllIllIIIlIIIIIlll * 16]);
            }
        }
    }
    
    @Override
    public Chunk provideChunk(final int llllllllllllllIllIllIIIIllllIIlI, final int llllllllllllllIllIllIIIIllllIIIl) {
        this.rand.setSeed(llllllllllllllIllIllIIIIllllIIlI * 341873128712L + llllllllllllllIllIllIIIIllllIIIl * 132897987541L);
        final ChunkPrimer llllllllllllllIllIllIIIIllllIIII = new ChunkPrimer();
        this.func_180518_a(llllllllllllllIllIllIIIIllllIIlI, llllllllllllllIllIllIIIIllllIIIl, llllllllllllllIllIllIIIIllllIIII);
        this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, llllllllllllllIllIllIIIIllllIIlI * 16, llllllllllllllIllIllIIIIllllIIIl * 16, 16, 16);
        this.func_180517_a(llllllllllllllIllIllIIIIllllIIlI, llllllllllllllIllIllIIIIllllIIIl, llllllllllllllIllIllIIIIllllIIII, this.biomesForGeneration);
        if (this.field_177477_r.field_177839_r) {
            this.caveGenerator.func_175792_a(this, this.worldObj, llllllllllllllIllIllIIIIllllIIlI, llllllllllllllIllIllIIIIllllIIIl, llllllllllllllIllIllIIIIllllIIII);
        }
        if (this.field_177477_r.field_177850_z) {
            this.ravineGenerator.func_175792_a(this, this.worldObj, llllllllllllllIllIllIIIIllllIIlI, llllllllllllllIllIllIIIIllllIIIl, llllllllllllllIllIllIIIIllllIIII);
        }
        if (this.field_177477_r.field_177829_w && this.mapFeaturesEnabled) {
            this.mineshaftGenerator.func_175792_a(this, this.worldObj, llllllllllllllIllIllIIIIllllIIlI, llllllllllllllIllIllIIIIllllIIIl, llllllllllllllIllIllIIIIllllIIII);
        }
        if (this.field_177477_r.field_177831_v && this.mapFeaturesEnabled) {
            this.villageGenerator.func_175792_a(this, this.worldObj, llllllllllllllIllIllIIIIllllIIlI, llllllllllllllIllIllIIIIllllIIIl, llllllllllllllIllIllIIIIllllIIII);
        }
        if (this.field_177477_r.field_177833_u && this.mapFeaturesEnabled) {
            this.strongholdGenerator.func_175792_a(this, this.worldObj, llllllllllllllIllIllIIIIllllIIlI, llllllllllllllIllIllIIIIllllIIIl, llllllllllllllIllIllIIIIllllIIII);
        }
        if (this.field_177477_r.field_177854_x && this.mapFeaturesEnabled) {
            this.scatteredFeatureGenerator.func_175792_a(this, this.worldObj, llllllllllllllIllIllIIIIllllIIlI, llllllllllllllIllIllIIIIllllIIIl, llllllllllllllIllIllIIIIllllIIII);
        }
        if (this.field_177477_r.field_177852_y && this.mapFeaturesEnabled) {
            this.field_177474_A.func_175792_a(this, this.worldObj, llllllllllllllIllIllIIIIllllIIlI, llllllllllllllIllIllIIIIllllIIIl, llllllllllllllIllIllIIIIllllIIII);
        }
        final Chunk llllllllllllllIllIllIIIIlllIllll = new Chunk(this.worldObj, llllllllllllllIllIllIIIIllllIIII, llllllllllllllIllIllIIIIllllIIlI, llllllllllllllIllIllIIIIllllIIIl);
        final byte[] llllllllllllllIllIllIIIIlllIlllI = llllllllllllllIllIllIIIIlllIllll.getBiomeArray();
        for (int llllllllllllllIllIllIIIIlllIllIl = 0; llllllllllllllIllIllIIIIlllIllIl < llllllllllllllIllIllIIIIlllIlllI.length; ++llllllllllllllIllIllIIIIlllIllIl) {
            llllllllllllllIllIllIIIIlllIlllI[llllllllllllllIllIllIIIIlllIllIl] = (byte)this.biomesForGeneration[llllllllllllllIllIllIIIIlllIllIl].biomeID;
        }
        llllllllllllllIllIllIIIIlllIllll.generateSkylightMap();
        return llllllllllllllIllIllIIIIlllIllll;
    }
    
    @Override
    public Chunk func_177459_a(final BlockPos llllllllllllllIllIllIIIIIIIIlIll) {
        return this.provideChunk(llllllllllllllIllIllIIIIIIIIlIll.getX() >> 4, llllllllllllllIllIllIIIIIIIIlIll.getZ() >> 4);
    }
    
    @Override
    public boolean unloadQueuedChunks() {
        return false;
    }
    
    @Override
    public boolean canSave() {
        return true;
    }
    
    @Override
    public void populate(final IChunkProvider llllllllllllllIllIllIIIIIlllIIIl, final int llllllllllllllIllIllIIIIIlllIIII, final int llllllllllllllIllIllIIIIIllIllll) {
        BlockFalling.fallInstantly = true;
        final int llllllllllllllIllIllIIIIIllIlllI = llllllllllllllIllIllIIIIIlllIIII * 16;
        final int llllllllllllllIllIllIIIIIllIllIl = llllllllllllllIllIllIIIIIllIllll * 16;
        BlockPos llllllllllllllIllIllIIIIIllIllII = new BlockPos(llllllllllllllIllIllIIIIIllIlllI, 0, llllllllllllllIllIllIIIIIllIllIl);
        final BiomeGenBase llllllllllllllIllIllIIIIIllIlIll = this.worldObj.getBiomeGenForCoords(llllllllllllllIllIllIIIIIllIllII.add(16, 0, 16));
        this.rand.setSeed(this.worldObj.getSeed());
        final long llllllllllllllIllIllIIIIIllIlIlI = this.rand.nextLong() / 2L * 2L + 1L;
        final long llllllllllllllIllIllIIIIIllIlIIl = this.rand.nextLong() / 2L * 2L + 1L;
        this.rand.setSeed(llllllllllllllIllIllIIIIIlllIIII * llllllllllllllIllIllIIIIIllIlIlI + llllllllllllllIllIllIIIIIllIllll * llllllllllllllIllIllIIIIIllIlIIl ^ this.worldObj.getSeed());
        boolean llllllllllllllIllIllIIIIIllIlIII = false;
        final ChunkCoordIntPair llllllllllllllIllIllIIIIIllIIlll = new ChunkCoordIntPair(llllllllllllllIllIllIIIIIlllIIII, llllllllllllllIllIllIIIIIllIllll);
        if (this.field_177477_r.field_177829_w && this.mapFeaturesEnabled) {
            this.mineshaftGenerator.func_175794_a(this.worldObj, this.rand, llllllllllllllIllIllIIIIIllIIlll);
        }
        if (this.field_177477_r.field_177831_v && this.mapFeaturesEnabled) {
            llllllllllllllIllIllIIIIIllIlIII = this.villageGenerator.func_175794_a(this.worldObj, this.rand, llllllllllllllIllIllIIIIIllIIlll);
        }
        if (this.field_177477_r.field_177833_u && this.mapFeaturesEnabled) {
            this.strongholdGenerator.func_175794_a(this.worldObj, this.rand, llllllllllllllIllIllIIIIIllIIlll);
        }
        if (this.field_177477_r.field_177854_x && this.mapFeaturesEnabled) {
            this.scatteredFeatureGenerator.func_175794_a(this.worldObj, this.rand, llllllllllllllIllIllIIIIIllIIlll);
        }
        if (this.field_177477_r.field_177852_y && this.mapFeaturesEnabled) {
            this.field_177474_A.func_175794_a(this.worldObj, this.rand, llllllllllllllIllIllIIIIIllIIlll);
        }
        if (llllllllllllllIllIllIIIIIllIlIll != BiomeGenBase.desert && llllllllllllllIllIllIIIIIllIlIll != BiomeGenBase.desertHills && this.field_177477_r.field_177781_A && !llllllllllllllIllIllIIIIIllIlIII && this.rand.nextInt(this.field_177477_r.field_177782_B) == 0) {
            final int llllllllllllllIllIllIIIIIllIIllI = this.rand.nextInt(16) + 8;
            final int llllllllllllllIllIllIIIIIllIIIlI = this.rand.nextInt(256);
            final int llllllllllllllIllIllIIIIIlIllllI = this.rand.nextInt(16) + 8;
            new WorldGenLakes(Blocks.water).generate(this.worldObj, this.rand, llllllllllllllIllIllIIIIIllIllII.add(llllllllllllllIllIllIIIIIllIIllI, llllllllllllllIllIllIIIIIllIIIlI, llllllllllllllIllIllIIIIIlIllllI));
        }
        if (!llllllllllllllIllIllIIIIIllIlIII && this.rand.nextInt(this.field_177477_r.field_177777_D / 10) == 0 && this.field_177477_r.field_177783_C) {
            final int llllllllllllllIllIllIIIIIllIIlIl = this.rand.nextInt(16) + 8;
            final int llllllllllllllIllIllIIIIIllIIIIl = this.rand.nextInt(this.rand.nextInt(248) + 8);
            final int llllllllllllllIllIllIIIIIlIlllIl = this.rand.nextInt(16) + 8;
            if (llllllllllllllIllIllIIIIIllIIIIl < 63 || this.rand.nextInt(this.field_177477_r.field_177777_D / 8) == 0) {
                new WorldGenLakes(Blocks.lava).generate(this.worldObj, this.rand, llllllllllllllIllIllIIIIIllIllII.add(llllllllllllllIllIllIIIIIllIIlIl, llllllllllllllIllIllIIIIIllIIIIl, llllllllllllllIllIllIIIIIlIlllIl));
            }
        }
        if (this.field_177477_r.field_177837_s) {
            for (int llllllllllllllIllIllIIIIIllIIlII = 0; llllllllllllllIllIllIIIIIllIIlII < this.field_177477_r.field_177835_t; ++llllllllllllllIllIllIIIIIllIIlII) {
                final int llllllllllllllIllIllIIIIIllIIIII = this.rand.nextInt(16) + 8;
                final int llllllllllllllIllIllIIIIIlIlllII = this.rand.nextInt(256);
                final int llllllllllllllIllIllIIIIIlIllIll = this.rand.nextInt(16) + 8;
                new WorldGenDungeons().generate(this.worldObj, this.rand, llllllllllllllIllIllIIIIIllIllII.add(llllllllllllllIllIllIIIIIllIIIII, llllllllllllllIllIllIIIIIlIlllII, llllllllllllllIllIllIIIIIlIllIll));
            }
        }
        llllllllllllllIllIllIIIIIllIlIll.func_180624_a(this.worldObj, this.rand, new BlockPos(llllllllllllllIllIllIIIIIllIlllI, 0, llllllllllllllIllIllIIIIIllIllIl));
        SpawnerAnimals.performWorldGenSpawning(this.worldObj, llllllllllllllIllIllIIIIIllIlIll, llllllllllllllIllIllIIIIIllIlllI + 8, llllllllllllllIllIllIIIIIllIllIl + 8, 16, 16, this.rand);
        llllllllllllllIllIllIIIIIllIllII = llllllllllllllIllIllIIIIIllIllII.add(8, 0, 8);
        for (int llllllllllllllIllIllIIIIIllIIIll = 0; llllllllllllllIllIllIIIIIllIIIll < 16; ++llllllllllllllIllIllIIIIIllIIIll) {
            for (int llllllllllllllIllIllIIIIIlIlllll = 0; llllllllllllllIllIllIIIIIlIlllll < 16; ++llllllllllllllIllIllIIIIIlIlllll) {
                final BlockPos llllllllllllllIllIllIIIIIlIllIlI = this.worldObj.func_175725_q(llllllllllllllIllIllIIIIIllIllII.add(llllllllllllllIllIllIIIIIllIIIll, 0, llllllllllllllIllIllIIIIIlIlllll));
                final BlockPos llllllllllllllIllIllIIIIIlIllIIl = llllllllllllllIllIllIIIIIlIllIlI.offsetDown();
                if (this.worldObj.func_175675_v(llllllllllllllIllIllIIIIIlIllIIl)) {
                    this.worldObj.setBlockState(llllllllllllllIllIllIIIIIlIllIIl, Blocks.ice.getDefaultState(), 2);
                }
                if (this.worldObj.func_175708_f(llllllllllllllIllIllIIIIIlIllIlI, true)) {
                    this.worldObj.setBlockState(llllllllllllllIllIllIIIIIlIllIlI, Blocks.snow_layer.getDefaultState(), 2);
                }
            }
        }
        BlockFalling.fallInstantly = false;
    }
    
    @Override
    public void saveExtraData() {
    }
    
    @Override
    public boolean chunkExists(final int llllllllllllllIllIllIIIIlIIIIlII, final int llllllllllllllIllIllIIIIlIIIIIll) {
        return true;
    }
    
    static {
        __OBFID = "CL_00000396";
    }
    
    private void func_147423_a(final int llllllllllllllIllIllIIIIlIlIIIll, final int llllllllllllllIllIllIIIIllIIIlII, final int llllllllllllllIllIllIIIIllIIIIll) {
        this.field_147426_g = this.noiseGen6.generateNoiseOctaves(this.field_147426_g, llllllllllllllIllIllIIIIlIlIIIll, llllllllllllllIllIllIIIIllIIIIll, 5, 5, this.field_177477_r.field_177808_e, this.field_177477_r.field_177803_f, this.field_177477_r.field_177804_g);
        final float llllllllllllllIllIllIIIIllIIIIlI = this.field_177477_r.field_177811_a;
        final float llllllllllllllIllIllIIIIllIIIIIl = this.field_177477_r.field_177809_b;
        this.field_147427_d = this.field_147429_l.generateNoiseOctaves(this.field_147427_d, llllllllllllllIllIllIIIIlIlIIIll, llllllllllllllIllIllIIIIllIIIlII, llllllllllllllIllIllIIIIllIIIIll, 5, 33, 5, llllllllllllllIllIllIIIIllIIIIlI / this.field_177477_r.field_177825_h, llllllllllllllIllIllIIIIllIIIIIl / this.field_177477_r.field_177827_i, llllllllllllllIllIllIIIIllIIIIlI / this.field_177477_r.field_177821_j);
        this.field_147428_e = this.field_147431_j.generateNoiseOctaves(this.field_147428_e, llllllllllllllIllIllIIIIlIlIIIll, llllllllllllllIllIllIIIIllIIIlII, llllllllllllllIllIllIIIIllIIIIll, 5, 33, 5, llllllllllllllIllIllIIIIllIIIIlI, llllllllllllllIllIllIIIIllIIIIIl, llllllllllllllIllIllIIIIllIIIIlI);
        this.field_147425_f = this.field_147432_k.generateNoiseOctaves(this.field_147425_f, llllllllllllllIllIllIIIIlIlIIIll, llllllllllllllIllIllIIIIllIIIlII, llllllllllllllIllIllIIIIllIIIIll, 5, 33, 5, llllllllllllllIllIllIIIIllIIIIlI, llllllllllllllIllIllIIIIllIIIIIl, llllllllllllllIllIllIIIIllIIIIlI);
        final boolean llllllllllllllIllIllIIIIllIIIIII = false;
        final boolean llllllllllllllIllIllIIIIlIllllll = false;
        int llllllllllllllIllIllIIIIlIlllllI = 0;
        int llllllllllllllIllIllIIIIlIllllIl = 0;
        for (int llllllllllllllIllIllIIIIlIllllII = 0; llllllllllllllIllIllIIIIlIllllII < 5; ++llllllllllllllIllIllIIIIlIllllII) {
            for (int llllllllllllllIllIllIIIIlIlllIll = 0; llllllllllllllIllIllIIIIlIlllIll < 5; ++llllllllllllllIllIllIIIIlIlllIll) {
                float llllllllllllllIllIllIIIIlIlllIlI = 0.0f;
                float llllllllllllllIllIllIIIIlIlllIIl = 0.0f;
                float llllllllllllllIllIllIIIIlIlllIII = 0.0f;
                final byte llllllllllllllIllIllIIIIlIllIlll = 2;
                final BiomeGenBase llllllllllllllIllIllIIIIlIllIllI = this.biomesForGeneration[llllllllllllllIllIllIIIIlIllllII + 2 + (llllllllllllllIllIllIIIIlIlllIll + 2) * 10];
                for (int llllllllllllllIllIllIIIIlIllIlIl = -llllllllllllllIllIllIIIIlIllIlll; llllllllllllllIllIllIIIIlIllIlIl <= llllllllllllllIllIllIIIIlIllIlll; ++llllllllllllllIllIllIIIIlIllIlIl) {
                    for (int llllllllllllllIllIllIIIIlIllIlII = -llllllllllllllIllIllIIIIlIllIlll; llllllllllllllIllIllIIIIlIllIlII <= llllllllllllllIllIllIIIIlIllIlll; ++llllllllllllllIllIllIIIIlIllIlII) {
                        final BiomeGenBase llllllllllllllIllIllIIIIlIllIIll = this.biomesForGeneration[llllllllllllllIllIllIIIIlIllllII + llllllllllllllIllIllIIIIlIllIlIl + 2 + (llllllllllllllIllIllIIIIlIlllIll + llllllllllllllIllIllIIIIlIllIlII + 2) * 10];
                        float llllllllllllllIllIllIIIIlIllIIlI = this.field_177477_r.field_177813_n + llllllllllllllIllIllIIIIlIllIIll.minHeight * this.field_177477_r.field_177819_m;
                        float llllllllllllllIllIllIIIIlIllIIIl = this.field_177477_r.field_177843_p + llllllllllllllIllIllIIIIlIllIIll.maxHeight * this.field_177477_r.field_177815_o;
                        if (this.field_177475_o == WorldType.AMPLIFIED && llllllllllllllIllIllIIIIlIllIIlI > 0.0f) {
                            llllllllllllllIllIllIIIIlIllIIlI = 1.0f + llllllllllllllIllIllIIIIlIllIIlI * 2.0f;
                            llllllllllllllIllIllIIIIlIllIIIl = 1.0f + llllllllllllllIllIllIIIIlIllIIIl * 4.0f;
                        }
                        float llllllllllllllIllIllIIIIlIllIIII = this.parabolicField[llllllllllllllIllIllIIIIlIllIlIl + 2 + (llllllllllllllIllIllIIIIlIllIlII + 2) * 5] / (llllllllllllllIllIllIIIIlIllIIlI + 2.0f);
                        if (llllllllllllllIllIllIIIIlIllIIll.minHeight > llllllllllllllIllIllIIIIlIllIllI.minHeight) {
                            llllllllllllllIllIllIIIIlIllIIII /= 2.0f;
                        }
                        llllllllllllllIllIllIIIIlIlllIlI += llllllllllllllIllIllIIIIlIllIIIl * llllllllllllllIllIllIIIIlIllIIII;
                        llllllllllllllIllIllIIIIlIlllIIl += llllllllllllllIllIllIIIIlIllIIlI * llllllllllllllIllIllIIIIlIllIIII;
                        llllllllllllllIllIllIIIIlIlllIII += llllllllllllllIllIllIIIIlIllIIII;
                    }
                }
                llllllllllllllIllIllIIIIlIlllIlI /= llllllllllllllIllIllIIIIlIlllIII;
                llllllllllllllIllIllIIIIlIlllIIl /= llllllllllllllIllIllIIIIlIlllIII;
                llllllllllllllIllIllIIIIlIlllIlI = llllllllllllllIllIllIIIIlIlllIlI * 0.9f + 0.1f;
                llllllllllllllIllIllIIIIlIlllIIl = (llllllllllllllIllIllIIIIlIlllIIl * 4.0f - 1.0f) / 8.0f;
                double llllllllllllllIllIllIIIIlIlIllll = this.field_147426_g[llllllllllllllIllIllIIIIlIllllIl] / 8000.0;
                if (llllllllllllllIllIllIIIIlIlIllll < 0.0) {
                    llllllllllllllIllIllIIIIlIlIllll = -llllllllllllllIllIllIIIIlIlIllll * 0.3;
                }
                llllllllllllllIllIllIIIIlIlIllll = llllllllllllllIllIllIIIIlIlIllll * 3.0 - 2.0;
                if (llllllllllllllIllIllIIIIlIlIllll < 0.0) {
                    llllllllllllllIllIllIIIIlIlIllll /= 2.0;
                    if (llllllllllllllIllIllIIIIlIlIllll < -1.0) {
                        llllllllllllllIllIllIIIIlIlIllll = -1.0;
                    }
                    llllllllllllllIllIllIIIIlIlIllll /= 1.4;
                    llllllllllllllIllIllIIIIlIlIllll /= 2.0;
                }
                else {
                    if (llllllllllllllIllIllIIIIlIlIllll > 1.0) {
                        llllllllllllllIllIllIIIIlIlIllll = 1.0;
                    }
                    llllllllllllllIllIllIIIIlIlIllll /= 8.0;
                }
                ++llllllllllllllIllIllIIIIlIllllIl;
                double llllllllllllllIllIllIIIIlIlIlllI = llllllllllllllIllIllIIIIlIlllIIl;
                final double llllllllllllllIllIllIIIIlIlIllIl = llllllllllllllIllIllIIIIlIlllIlI;
                llllllllllllllIllIllIIIIlIlIlllI += llllllllllllllIllIllIIIIlIlIllll * 0.2;
                llllllllllllllIllIllIIIIlIlIlllI = llllllllllllllIllIllIIIIlIlIlllI * this.field_177477_r.field_177823_k / 8.0;
                final double llllllllllllllIllIllIIIIlIlIllII = this.field_177477_r.field_177823_k + llllllllllllllIllIllIIIIlIlIlllI * 4.0;
                for (int llllllllllllllIllIllIIIIlIlIlIll = 0; llllllllllllllIllIllIIIIlIlIlIll < 33; ++llllllllllllllIllIllIIIIlIlIlIll) {
                    double llllllllllllllIllIllIIIIlIlIlIlI = (llllllllllllllIllIllIIIIlIlIlIll - llllllllllllllIllIllIIIIlIlIllII) * this.field_177477_r.field_177817_l * 128.0 / 256.0 / llllllllllllllIllIllIIIIlIlIllIl;
                    if (llllllllllllllIllIllIIIIlIlIlIlI < 0.0) {
                        llllllllllllllIllIllIIIIlIlIlIlI *= 4.0;
                    }
                    final double llllllllllllllIllIllIIIIlIlIlIIl = this.field_147428_e[llllllllllllllIllIllIIIIlIlllllI] / this.field_177477_r.field_177806_d;
                    final double llllllllllllllIllIllIIIIlIlIlIII = this.field_147425_f[llllllllllllllIllIllIIIIlIlllllI] / this.field_177477_r.field_177810_c;
                    final double llllllllllllllIllIllIIIIlIlIIlll = (this.field_147427_d[llllllllllllllIllIllIIIIlIlllllI] / 10.0 + 1.0) / 2.0;
                    double llllllllllllllIllIllIIIIlIlIIllI = MathHelper.denormalizeClamp(llllllllllllllIllIllIIIIlIlIlIIl, llllllllllllllIllIllIIIIlIlIlIII, llllllllllllllIllIllIIIIlIlIIlll) - llllllllllllllIllIllIIIIlIlIlIlI;
                    if (llllllllllllllIllIllIIIIlIlIlIll > 29) {
                        final double llllllllllllllIllIllIIIIlIlIIlIl = (llllllllllllllIllIllIIIIlIlIlIll - 29) / 3.0f;
                        llllllllllllllIllIllIIIIlIlIIllI = llllllllllllllIllIllIIIIlIlIIllI * (1.0 - llllllllllllllIllIllIIIIlIlIIlIl) + -10.0 * llllllllllllllIllIllIIIIlIlIIlIl;
                    }
                    this.field_147434_q[llllllllllllllIllIllIIIIlIlllllI] = llllllllllllllIllIllIIIIlIlIIllI;
                    ++llllllllllllllIllIllIIIIlIlllllI;
                }
            }
        }
    }
}
