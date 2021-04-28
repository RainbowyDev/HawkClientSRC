package net.minecraft.world.gen;

import net.minecraft.world.*;
import net.minecraft.world.biome.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;
import net.minecraft.world.chunk.*;
import net.minecraft.block.*;
import net.minecraft.util.*;

public class ChunkProviderEnd implements IChunkProvider
{
    /* synthetic */ double[] noiseData3;
    private /* synthetic */ World endWorld;
    private /* synthetic */ NoiseGeneratorOctaves noiseGen2;
    public /* synthetic */ NoiseGeneratorOctaves noiseGen4;
    private /* synthetic */ NoiseGeneratorOctaves noiseGen3;
    private /* synthetic */ Random endRNG;
    public /* synthetic */ NoiseGeneratorOctaves noiseGen5;
    /* synthetic */ double[] noiseData1;
    /* synthetic */ double[] noiseData2;
    /* synthetic */ double[] noiseData5;
    private /* synthetic */ double[] densities;
    /* synthetic */ double[] noiseData4;
    private /* synthetic */ BiomeGenBase[] biomesForGeneration;
    private /* synthetic */ NoiseGeneratorOctaves noiseGen1;
    
    @Override
    public int getLoadedChunkCount() {
        return 0;
    }
    
    @Override
    public List func_177458_a(final EnumCreatureType lllllllllllllllIllIIIlIIIIIlIIIl, final BlockPos lllllllllllllllIllIIIlIIIIIlIIll) {
        return this.endWorld.getBiomeGenForCoords(lllllllllllllllIllIIIlIIIIIlIIll).getSpawnableList(lllllllllllllllIllIIIlIIIIIlIIIl);
    }
    
    public ChunkProviderEnd(final World lllllllllllllllIllIIIlIlIIIllIIl, final long lllllllllllllllIllIIIlIlIIIllIII) {
        this.endWorld = lllllllllllllllIllIIIlIlIIIllIIl;
        this.endRNG = new Random(lllllllllllllllIllIIIlIlIIIllIII);
        this.noiseGen1 = new NoiseGeneratorOctaves(this.endRNG, 16);
        this.noiseGen2 = new NoiseGeneratorOctaves(this.endRNG, 16);
        this.noiseGen3 = new NoiseGeneratorOctaves(this.endRNG, 8);
        this.noiseGen4 = new NoiseGeneratorOctaves(this.endRNG, 10);
        this.noiseGen5 = new NoiseGeneratorOctaves(this.endRNG, 16);
    }
    
    @Override
    public boolean unloadQueuedChunks() {
        return false;
    }
    
    public void func_180519_a(final ChunkPrimer lllllllllllllllIllIIIlIIlIlIIIIl) {
        for (int lllllllllllllllIllIIIlIIlIlIIIII = 0; lllllllllllllllIllIIIlIIlIlIIIII < 16; ++lllllllllllllllIllIIIlIIlIlIIIII) {
            for (int lllllllllllllllIllIIIlIIlIIlllll = 0; lllllllllllllllIllIIIlIIlIIlllll < 16; ++lllllllllllllllIllIIIlIIlIIlllll) {
                final byte lllllllllllllllIllIIIlIIlIIllllI = 1;
                int lllllllllllllllIllIIIlIIlIIlllIl = -1;
                IBlockState lllllllllllllllIllIIIlIIlIIlllII = Blocks.end_stone.getDefaultState();
                IBlockState lllllllllllllllIllIIIlIIlIIllIll = Blocks.end_stone.getDefaultState();
                for (int lllllllllllllllIllIIIlIIlIIllIlI = 127; lllllllllllllllIllIIIlIIlIIllIlI >= 0; --lllllllllllllllIllIIIlIIlIIllIlI) {
                    final IBlockState lllllllllllllllIllIIIlIIlIIllIIl = lllllllllllllllIllIIIlIIlIlIIIIl.getBlockState(lllllllllllllllIllIIIlIIlIlIIIII, lllllllllllllllIllIIIlIIlIIllIlI, lllllllllllllllIllIIIlIIlIIlllll);
                    if (lllllllllllllllIllIIIlIIlIIllIIl.getBlock().getMaterial() == Material.air) {
                        lllllllllllllllIllIIIlIIlIIlllIl = -1;
                    }
                    else if (lllllllllllllllIllIIIlIIlIIllIIl.getBlock() == Blocks.stone) {
                        if (lllllllllllllllIllIIIlIIlIIlllIl == -1) {
                            if (lllllllllllllllIllIIIlIIlIIllllI <= 0) {
                                lllllllllllllllIllIIIlIIlIIlllII = Blocks.air.getDefaultState();
                                lllllllllllllllIllIIIlIIlIIllIll = Blocks.end_stone.getDefaultState();
                            }
                            lllllllllllllllIllIIIlIIlIIlllIl = lllllllllllllllIllIIIlIIlIIllllI;
                            if (lllllllllllllllIllIIIlIIlIIllIlI >= 0) {
                                lllllllllllllllIllIIIlIIlIlIIIIl.setBlockState(lllllllllllllllIllIIIlIIlIlIIIII, lllllllllllllllIllIIIlIIlIIllIlI, lllllllllllllllIllIIIlIIlIIlllll, lllllllllllllllIllIIIlIIlIIlllII);
                            }
                            else {
                                lllllllllllllllIllIIIlIIlIlIIIIl.setBlockState(lllllllllllllllIllIIIlIIlIlIIIII, lllllllllllllllIllIIIlIIlIIllIlI, lllllllllllllllIllIIIlIIlIIlllll, lllllllllllllllIllIIIlIIlIIllIll);
                            }
                        }
                        else if (lllllllllllllllIllIIIlIIlIIlllIl > 0) {
                            --lllllllllllllllIllIIIlIIlIIlllIl;
                            lllllllllllllllIllIIIlIIlIlIIIIl.setBlockState(lllllllllllllllIllIIIlIIlIlIIIII, lllllllllllllllIllIIIlIIlIIllIlI, lllllllllllllllIllIIIlIIlIIlllll, lllllllllllllllIllIIIlIIlIIllIll);
                        }
                    }
                }
            }
        }
    }
    
    @Override
    public void saveExtraData() {
    }
    
    @Override
    public boolean saveChunks(final boolean lllllllllllllllIllIIIlIIIIIllllI, final IProgressUpdate lllllllllllllllIllIIIlIIIIIlllIl) {
        return true;
    }
    
    @Override
    public BlockPos func_180513_a(final World lllllllllllllllIllIIIlIIIIIIlllI, final String lllllllllllllllIllIIIlIIIIIIllIl, final BlockPos lllllllllllllllIllIIIlIIIIIIllII) {
        return null;
    }
    
    public void func_180520_a(final int lllllllllllllllIllIIIlIIllIIllIl, final int lllllllllllllllIllIIIlIIlllIllll, final ChunkPrimer lllllllllllllllIllIIIlIIlllIlllI) {
        final byte lllllllllllllllIllIIIlIIlllIllIl = 2;
        final int lllllllllllllllIllIIIlIIlllIllII = lllllllllllllllIllIIIlIIlllIllIl + 1;
        final byte lllllllllllllllIllIIIlIIlllIlIll = 33;
        final int lllllllllllllllIllIIIlIIlllIlIlI = lllllllllllllllIllIIIlIIlllIllIl + 1;
        this.densities = this.initializeNoiseField(this.densities, lllllllllllllllIllIIIlIIllIIllIl * lllllllllllllllIllIIIlIIlllIllIl, 0, lllllllllllllllIllIIIlIIlllIllll * lllllllllllllllIllIIIlIIlllIllIl, lllllllllllllllIllIIIlIIlllIllII, lllllllllllllllIllIIIlIIlllIlIll, lllllllllllllllIllIIIlIIlllIlIlI);
        for (int lllllllllllllllIllIIIlIIlllIlIIl = 0; lllllllllllllllIllIIIlIIlllIlIIl < lllllllllllllllIllIIIlIIlllIllIl; ++lllllllllllllllIllIIIlIIlllIlIIl) {
            for (int lllllllllllllllIllIIIlIIlllIlIII = 0; lllllllllllllllIllIIIlIIlllIlIII < lllllllllllllllIllIIIlIIlllIllIl; ++lllllllllllllllIllIIIlIIlllIlIII) {
                for (int lllllllllllllllIllIIIlIIlllIIlll = 0; lllllllllllllllIllIIIlIIlllIIlll < 32; ++lllllllllllllllIllIIIlIIlllIIlll) {
                    final double lllllllllllllllIllIIIlIIlllIIllI = 0.25;
                    double lllllllllllllllIllIIIlIIlllIIlIl = this.densities[((lllllllllllllllIllIIIlIIlllIlIIl + 0) * lllllllllllllllIllIIIlIIlllIlIlI + lllllllllllllllIllIIIlIIlllIlIII + 0) * lllllllllllllllIllIIIlIIlllIlIll + lllllllllllllllIllIIIlIIlllIIlll + 0];
                    double lllllllllllllllIllIIIlIIlllIIlII = this.densities[((lllllllllllllllIllIIIlIIlllIlIIl + 0) * lllllllllllllllIllIIIlIIlllIlIlI + lllllllllllllllIllIIIlIIlllIlIII + 1) * lllllllllllllllIllIIIlIIlllIlIll + lllllllllllllllIllIIIlIIlllIIlll + 0];
                    double lllllllllllllllIllIIIlIIlllIIIll = this.densities[((lllllllllllllllIllIIIlIIlllIlIIl + 1) * lllllllllllllllIllIIIlIIlllIlIlI + lllllllllllllllIllIIIlIIlllIlIII + 0) * lllllllllllllllIllIIIlIIlllIlIll + lllllllllllllllIllIIIlIIlllIIlll + 0];
                    double lllllllllllllllIllIIIlIIlllIIIlI = this.densities[((lllllllllllllllIllIIIlIIlllIlIIl + 1) * lllllllllllllllIllIIIlIIlllIlIlI + lllllllllllllllIllIIIlIIlllIlIII + 1) * lllllllllllllllIllIIIlIIlllIlIll + lllllllllllllllIllIIIlIIlllIIlll + 0];
                    final double lllllllllllllllIllIIIlIIlllIIIIl = (this.densities[((lllllllllllllllIllIIIlIIlllIlIIl + 0) * lllllllllllllllIllIIIlIIlllIlIlI + lllllllllllllllIllIIIlIIlllIlIII + 0) * lllllllllllllllIllIIIlIIlllIlIll + lllllllllllllllIllIIIlIIlllIIlll + 1] - lllllllllllllllIllIIIlIIlllIIlIl) * lllllllllllllllIllIIIlIIlllIIllI;
                    final double lllllllllllllllIllIIIlIIlllIIIII = (this.densities[((lllllllllllllllIllIIIlIIlllIlIIl + 0) * lllllllllllllllIllIIIlIIlllIlIlI + lllllllllllllllIllIIIlIIlllIlIII + 1) * lllllllllllllllIllIIIlIIlllIlIll + lllllllllllllllIllIIIlIIlllIIlll + 1] - lllllllllllllllIllIIIlIIlllIIlII) * lllllllllllllllIllIIIlIIlllIIllI;
                    final double lllllllllllllllIllIIIlIIllIlllll = (this.densities[((lllllllllllllllIllIIIlIIlllIlIIl + 1) * lllllllllllllllIllIIIlIIlllIlIlI + lllllllllllllllIllIIIlIIlllIlIII + 0) * lllllllllllllllIllIIIlIIlllIlIll + lllllllllllllllIllIIIlIIlllIIlll + 1] - lllllllllllllllIllIIIlIIlllIIIll) * lllllllllllllllIllIIIlIIlllIIllI;
                    final double lllllllllllllllIllIIIlIIllIllllI = (this.densities[((lllllllllllllllIllIIIlIIlllIlIIl + 1) * lllllllllllllllIllIIIlIIlllIlIlI + lllllllllllllllIllIIIlIIlllIlIII + 1) * lllllllllllllllIllIIIlIIlllIlIll + lllllllllllllllIllIIIlIIlllIIlll + 1] - lllllllllllllllIllIIIlIIlllIIIlI) * lllllllllllllllIllIIIlIIlllIIllI;
                    for (int lllllllllllllllIllIIIlIIllIlllIl = 0; lllllllllllllllIllIIIlIIllIlllIl < 4; ++lllllllllllllllIllIIIlIIllIlllIl) {
                        final double lllllllllllllllIllIIIlIIllIlllII = 0.125;
                        double lllllllllllllllIllIIIlIIllIllIll = lllllllllllllllIllIIIlIIlllIIlIl;
                        double lllllllllllllllIllIIIlIIllIllIlI = lllllllllllllllIllIIIlIIlllIIlII;
                        final double lllllllllllllllIllIIIlIIllIllIIl = (lllllllllllllllIllIIIlIIlllIIIll - lllllllllllllllIllIIIlIIlllIIlIl) * lllllllllllllllIllIIIlIIllIlllII;
                        final double lllllllllllllllIllIIIlIIllIllIII = (lllllllllllllllIllIIIlIIlllIIIlI - lllllllllllllllIllIIIlIIlllIIlII) * lllllllllllllllIllIIIlIIllIlllII;
                        for (int lllllllllllllllIllIIIlIIllIlIlll = 0; lllllllllllllllIllIIIlIIllIlIlll < 8; ++lllllllllllllllIllIIIlIIllIlIlll) {
                            final double lllllllllllllllIllIIIlIIllIlIllI = 0.125;
                            double lllllllllllllllIllIIIlIIllIlIlIl = lllllllllllllllIllIIIlIIllIllIll;
                            final double lllllllllllllllIllIIIlIIllIlIlII = (lllllllllllllllIllIIIlIIllIllIlI - lllllllllllllllIllIIIlIIllIllIll) * lllllllllllllllIllIIIlIIllIlIllI;
                            for (int lllllllllllllllIllIIIlIIllIlIIll = 0; lllllllllllllllIllIIIlIIllIlIIll < 8; ++lllllllllllllllIllIIIlIIllIlIIll) {
                                IBlockState lllllllllllllllIllIIIlIIllIlIIlI = null;
                                if (lllllllllllllllIllIIIlIIllIlIlIl > 0.0) {
                                    lllllllllllllllIllIIIlIIllIlIIlI = Blocks.end_stone.getDefaultState();
                                }
                                final int lllllllllllllllIllIIIlIIllIlIIIl = lllllllllllllllIllIIIlIIllIlIlll + lllllllllllllllIllIIIlIIlllIlIIl * 8;
                                final int lllllllllllllllIllIIIlIIllIlIIII = lllllllllllllllIllIIIlIIllIlllIl + lllllllllllllllIllIIIlIIlllIIlll * 4;
                                final int lllllllllllllllIllIIIlIIllIIllll = lllllllllllllllIllIIIlIIllIlIIll + lllllllllllllllIllIIIlIIlllIlIII * 8;
                                lllllllllllllllIllIIIlIIlllIlllI.setBlockState(lllllllllllllllIllIIIlIIllIlIIIl, lllllllllllllllIllIIIlIIllIlIIII, lllllllllllllllIllIIIlIIllIIllll, lllllllllllllllIllIIIlIIllIlIIlI);
                                lllllllllllllllIllIIIlIIllIlIlIl += lllllllllllllllIllIIIlIIllIlIlII;
                            }
                            lllllllllllllllIllIIIlIIllIllIll += lllllllllllllllIllIIIlIIllIllIIl;
                            lllllllllllllllIllIIIlIIllIllIlI += lllllllllllllllIllIIIlIIllIllIII;
                        }
                        lllllllllllllllIllIIIlIIlllIIlIl += lllllllllllllllIllIIIlIIlllIIIIl;
                        lllllllllllllllIllIIIlIIlllIIlII += lllllllllllllllIllIIIlIIlllIIIII;
                        lllllllllllllllIllIIIlIIlllIIIll += lllllllllllllllIllIIIlIIllIlllll;
                        lllllllllllllllIllIIIlIIlllIIIlI += lllllllllllllllIllIIIlIIllIllllI;
                    }
                }
            }
        }
    }
    
    @Override
    public boolean func_177460_a(final IChunkProvider lllllllllllllllIllIIIlIIIIlIIIll, final Chunk lllllllllllllllIllIIIlIIIIlIIIlI, final int lllllllllllllllIllIIIlIIIIlIIIIl, final int lllllllllllllllIllIIIlIIIIlIIIII) {
        return false;
    }
    
    @Override
    public boolean canSave() {
        return true;
    }
    
    @Override
    public void populate(final IChunkProvider lllllllllllllllIllIIIlIIIIlIllII, final int lllllllllllllllIllIIIlIIIIlIlIll, final int lllllllllllllllIllIIIlIIIIlIlIlI) {
        BlockFalling.fallInstantly = true;
        final BlockPos lllllllllllllllIllIIIlIIIIlIlIIl = new BlockPos(lllllllllllllllIllIIIlIIIIlIlIll * 16, 0, lllllllllllllllIllIIIlIIIIlIlIlI * 16);
        this.endWorld.getBiomeGenForCoords(lllllllllllllllIllIIIlIIIIlIlIIl.add(16, 0, 16)).func_180624_a(this.endWorld, this.endWorld.rand, lllllllllllllllIllIIIlIIIIlIlIIl);
        BlockFalling.fallInstantly = false;
    }
    
    @Override
    public Chunk provideChunk(final int lllllllllllllllIllIIIlIIlIIIIlll, final int lllllllllllllllIllIIIlIIIlllllll) {
        this.endRNG.setSeed(lllllllllllllllIllIIIlIIlIIIIlll * 341873128712L + lllllllllllllllIllIIIlIIIlllllll * 132897987541L);
        final ChunkPrimer lllllllllllllllIllIIIlIIlIIIIlIl = new ChunkPrimer();
        this.biomesForGeneration = this.endWorld.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, lllllllllllllllIllIIIlIIlIIIIlll * 16, lllllllllllllllIllIIIlIIIlllllll * 16, 16, 16);
        this.func_180520_a(lllllllllllllllIllIIIlIIlIIIIlll, lllllllllllllllIllIIIlIIIlllllll, lllllllllllllllIllIIIlIIlIIIIlIl);
        this.func_180519_a(lllllllllllllllIllIIIlIIlIIIIlIl);
        final Chunk lllllllllllllllIllIIIlIIlIIIIlII = new Chunk(this.endWorld, lllllllllllllllIllIIIlIIlIIIIlIl, lllllllllllllllIllIIIlIIlIIIIlll, lllllllllllllllIllIIIlIIIlllllll);
        final byte[] lllllllllllllllIllIIIlIIlIIIIIll = lllllllllllllllIllIIIlIIlIIIIlII.getBiomeArray();
        for (int lllllllllllllllIllIIIlIIlIIIIIlI = 0; lllllllllllllllIllIIIlIIlIIIIIlI < lllllllllllllllIllIIIlIIlIIIIIll.length; ++lllllllllllllllIllIIIlIIlIIIIIlI) {
            lllllllllllllllIllIIIlIIlIIIIIll[lllllllllllllllIllIIIlIIlIIIIIlI] = (byte)this.biomesForGeneration[lllllllllllllllIllIIIlIIlIIIIIlI].biomeID;
        }
        lllllllllllllllIllIIIlIIlIIIIlII.generateSkylightMap();
        return lllllllllllllllIllIIIlIIlIIIIlII;
    }
    
    @Override
    public boolean chunkExists(final int lllllllllllllllIllIIIlIIIIllIIll, final int lllllllllllllllIllIIIlIIIIllIIlI) {
        return true;
    }
    
    @Override
    public void func_180514_a(final Chunk lllllllllllllllIllIIIlIIIIIIlIIl, final int lllllllllllllllIllIIIlIIIIIIlIII, final int lllllllllllllllIllIIIlIIIIIIIlll) {
    }
    
    private double[] initializeNoiseField(double[] lllllllllllllllIllIIIlIIIlIIlIlI, final int lllllllllllllllIllIIIlIIIllIIIIl, final int lllllllllllllllIllIIIlIIIlIIlIII, final int lllllllllllllllIllIIIlIIIlIIIlll, final int lllllllllllllllIllIIIlIIIlIIIllI, final int lllllllllllllllIllIIIlIIIlIlllIl, final int lllllllllllllllIllIIIlIIIlIIIlII) {
        if (lllllllllllllllIllIIIlIIIlIIlIlI == null) {
            lllllllllllllllIllIIIlIIIlIIlIlI = new double[lllllllllllllllIllIIIlIIIlIIIllI * lllllllllllllllIllIIIlIIIlIlllIl * lllllllllllllllIllIIIlIIIlIIIlII];
        }
        double lllllllllllllllIllIIIlIIIlIllIll = 684.412;
        final double lllllllllllllllIllIIIlIIIlIllIlI = 684.412;
        this.noiseData4 = this.noiseGen4.generateNoiseOctaves(this.noiseData4, lllllllllllllllIllIIIlIIIllIIIIl, lllllllllllllllIllIIIlIIIlIIIlll, lllllllllllllllIllIIIlIIIlIIIllI, lllllllllllllllIllIIIlIIIlIIIlII, 1.121, 1.121, 0.5);
        this.noiseData5 = this.noiseGen5.generateNoiseOctaves(this.noiseData5, lllllllllllllllIllIIIlIIIllIIIIl, lllllllllllllllIllIIIlIIIlIIIlll, lllllllllllllllIllIIIlIIIlIIIllI, lllllllllllllllIllIIIlIIIlIIIlII, 200.0, 200.0, 0.5);
        lllllllllllllllIllIIIlIIIlIllIll *= 2.0;
        this.noiseData1 = this.noiseGen3.generateNoiseOctaves(this.noiseData1, lllllllllllllllIllIIIlIIIllIIIIl, lllllllllllllllIllIIIlIIIlIIlIII, lllllllllllllllIllIIIlIIIlIIIlll, lllllllllllllllIllIIIlIIIlIIIllI, lllllllllllllllIllIIIlIIIlIlllIl, lllllllllllllllIllIIIlIIIlIIIlII, lllllllllllllllIllIIIlIIIlIllIll / 80.0, lllllllllllllllIllIIIlIIIlIllIlI / 160.0, lllllllllllllllIllIIIlIIIlIllIll / 80.0);
        this.noiseData2 = this.noiseGen1.generateNoiseOctaves(this.noiseData2, lllllllllllllllIllIIIlIIIllIIIIl, lllllllllllllllIllIIIlIIIlIIlIII, lllllllllllllllIllIIIlIIIlIIIlll, lllllllllllllllIllIIIlIIIlIIIllI, lllllllllllllllIllIIIlIIIlIlllIl, lllllllllllllllIllIIIlIIIlIIIlII, lllllllllllllllIllIIIlIIIlIllIll, lllllllllllllllIllIIIlIIIlIllIlI, lllllllllllllllIllIIIlIIIlIllIll);
        this.noiseData3 = this.noiseGen2.generateNoiseOctaves(this.noiseData3, lllllllllllllllIllIIIlIIIllIIIIl, lllllllllllllllIllIIIlIIIlIIlIII, lllllllllllllllIllIIIlIIIlIIIlll, lllllllllllllllIllIIIlIIIlIIIllI, lllllllllllllllIllIIIlIIIlIlllIl, lllllllllllllllIllIIIlIIIlIIIlII, lllllllllllllllIllIIIlIIIlIllIll, lllllllllllllllIllIIIlIIIlIllIlI, lllllllllllllllIllIIIlIIIlIllIll);
        int lllllllllllllllIllIIIlIIIlIllIIl = 0;
        for (int lllllllllllllllIllIIIlIIIlIllIII = 0; lllllllllllllllIllIIIlIIIlIllIII < lllllllllllllllIllIIIlIIIlIIIllI; ++lllllllllllllllIllIIIlIIIlIllIII) {
            for (int lllllllllllllllIllIIIlIIIlIlIlll = 0; lllllllllllllllIllIIIlIIIlIlIlll < lllllllllllllllIllIIIlIIIlIIIlII; ++lllllllllllllllIllIIIlIIIlIlIlll) {
                final float lllllllllllllllIllIIIlIIIlIlIllI = (lllllllllllllllIllIIIlIIIlIllIII + lllllllllllllllIllIIIlIIIllIIIIl) / 1.0f;
                final float lllllllllllllllIllIIIlIIIlIlIlIl = (lllllllllllllllIllIIIlIIIlIlIlll + lllllllllllllllIllIIIlIIIlIIIlll) / 1.0f;
                float lllllllllllllllIllIIIlIIIlIlIlII = 100.0f - MathHelper.sqrt_float(lllllllllllllllIllIIIlIIIlIlIllI * lllllllllllllllIllIIIlIIIlIlIllI + lllllllllllllllIllIIIlIIIlIlIlIl * lllllllllllllllIllIIIlIIIlIlIlIl) * 8.0f;
                if (lllllllllllllllIllIIIlIIIlIlIlII > 80.0f) {
                    lllllllllllllllIllIIIlIIIlIlIlII = 80.0f;
                }
                if (lllllllllllllllIllIIIlIIIlIlIlII < -100.0f) {
                    lllllllllllllllIllIIIlIIIlIlIlII = -100.0f;
                }
                for (int lllllllllllllllIllIIIlIIIlIlIIll = 0; lllllllllllllllIllIIIlIIIlIlIIll < lllllllllllllllIllIIIlIIIlIlllIl; ++lllllllllllllllIllIIIlIIIlIlIIll) {
                    double lllllllllllllllIllIIIlIIIlIlIIlI = 0.0;
                    final double lllllllllllllllIllIIIlIIIlIlIIIl = this.noiseData2[lllllllllllllllIllIIIlIIIlIllIIl] / 512.0;
                    final double lllllllllllllllIllIIIlIIIlIlIIII = this.noiseData3[lllllllllllllllIllIIIlIIIlIllIIl] / 512.0;
                    final double lllllllllllllllIllIIIlIIIlIIllll = (this.noiseData1[lllllllllllllllIllIIIlIIIlIllIIl] / 10.0 + 1.0) / 2.0;
                    if (lllllllllllllllIllIIIlIIIlIIllll < 0.0) {
                        lllllllllllllllIllIIIlIIIlIlIIlI = lllllllllllllllIllIIIlIIIlIlIIIl;
                    }
                    else if (lllllllllllllllIllIIIlIIIlIIllll > 1.0) {
                        lllllllllllllllIllIIIlIIIlIlIIlI = lllllllllllllllIllIIIlIIIlIlIIII;
                    }
                    else {
                        lllllllllllllllIllIIIlIIIlIlIIlI = lllllllllllllllIllIIIlIIIlIlIIIl + (lllllllllllllllIllIIIlIIIlIlIIII - lllllllllllllllIllIIIlIIIlIlIIIl) * lllllllllllllllIllIIIlIIIlIIllll;
                    }
                    lllllllllllllllIllIIIlIIIlIlIIlI -= 8.0;
                    lllllllllllllllIllIIIlIIIlIlIIlI += lllllllllllllllIllIIIlIIIlIlIlII;
                    byte lllllllllllllllIllIIIlIIIlIIlllI = 2;
                    if (lllllllllllllllIllIIIlIIIlIlIIll > lllllllllllllllIllIIIlIIIlIlllIl / 2 - lllllllllllllllIllIIIlIIIlIIlllI) {
                        double lllllllllllllllIllIIIlIIIlIIllIl = (lllllllllllllllIllIIIlIIIlIlIIll - (lllllllllllllllIllIIIlIIIlIlllIl / 2 - lllllllllllllllIllIIIlIIIlIIlllI)) / 64.0f;
                        lllllllllllllllIllIIIlIIIlIIllIl = MathHelper.clamp_double(lllllllllllllllIllIIIlIIIlIIllIl, 0.0, 1.0);
                        lllllllllllllllIllIIIlIIIlIlIIlI = lllllllllllllllIllIIIlIIIlIlIIlI * (1.0 - lllllllllllllllIllIIIlIIIlIIllIl) + -3000.0 * lllllllllllllllIllIIIlIIIlIIllIl;
                    }
                    lllllllllllllllIllIIIlIIIlIIlllI = 8;
                    if (lllllllllllllllIllIIIlIIIlIlIIll < lllllllllllllllIllIIIlIIIlIIlllI) {
                        final double lllllllllllllllIllIIIlIIIlIIllII = (lllllllllllllllIllIIIlIIIlIIlllI - lllllllllllllllIllIIIlIIIlIlIIll) / (lllllllllllllllIllIIIlIIIlIIlllI - 1.0f);
                        lllllllllllllllIllIIIlIIIlIlIIlI = lllllllllllllllIllIIIlIIIlIlIIlI * (1.0 - lllllllllllllllIllIIIlIIIlIIllII) + -30.0 * lllllllllllllllIllIIIlIIIlIIllII;
                    }
                    lllllllllllllllIllIIIlIIIlIIlIlI[lllllllllllllllIllIIIlIIIlIllIIl] = lllllllllllllllIllIIIlIIIlIlIIlI;
                    ++lllllllllllllllIllIIIlIIIlIllIIl;
                }
            }
        }
        return lllllllllllllllIllIIIlIIIlIIlIlI;
    }
    
    @Override
    public Chunk func_177459_a(final BlockPos lllllllllllllllIllIIIlIIIIIIIIIl) {
        return this.provideChunk(lllllllllllllllIllIIIlIIIIIIIIIl.getX() >> 4, lllllllllllllllIllIIIlIIIIIIIIIl.getZ() >> 4);
    }
    
    static {
        __OBFID = "CL_00000397";
    }
    
    @Override
    public String makeString() {
        return "RandomLevelSource";
    }
}
