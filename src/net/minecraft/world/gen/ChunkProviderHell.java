package net.minecraft.world.gen;

import net.minecraft.world.gen.structure.*;
import net.minecraft.world.chunk.*;
import net.minecraft.init.*;
import net.minecraft.block.state.pattern.*;
import net.minecraft.world.gen.feature.*;
import com.google.common.base.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.world.biome.*;
import net.minecraft.entity.*;
import java.util.*;

public class ChunkProviderHell implements IChunkProvider
{
    private final /* synthetic */ NoiseGeneratorOctaves netherrackExculsivityNoiseGen;
    private final /* synthetic */ NoiseGeneratorOctaves slowsandGravelNoiseGen;
    private /* synthetic */ double[] noiseField;
    private final /* synthetic */ WorldGenGlowStone1 field_177469_u;
    /* synthetic */ double[] noiseData4;
    private final /* synthetic */ MapGenNetherBridge genNetherBridge;
    private final /* synthetic */ GeneratorBushFeature field_177465_A;
    private final /* synthetic */ WorldGenHellLava field_177473_x;
    private final /* synthetic */ World worldObj;
    private final /* synthetic */ WorldGenGlowStone2 field_177468_v;
    private final /* synthetic */ NoiseGeneratorOctaves netherNoiseGen3;
    private /* synthetic */ double[] netherrackExclusivityNoise;
    private /* synthetic */ double[] gravelNoise;
    private /* synthetic */ double[] slowsandNoise;
    public final /* synthetic */ NoiseGeneratorOctaves netherNoiseGen6;
    public final /* synthetic */ NoiseGeneratorOctaves netherNoiseGen7;
    private final /* synthetic */ GeneratorBushFeature field_177471_z;
    private final /* synthetic */ WorldGenerator field_177467_w;
    /* synthetic */ double[] noiseData5;
    /* synthetic */ double[] noiseData3;
    private final /* synthetic */ boolean field_177466_i;
    /* synthetic */ double[] noiseData1;
    private final /* synthetic */ WorldGenFire field_177470_t;
    private final /* synthetic */ WorldGenHellLava field_177472_y;
    private final /* synthetic */ MapGenBase netherCaveGenerator;
    /* synthetic */ double[] noiseData2;
    private final /* synthetic */ Random hellRNG;
    private final /* synthetic */ NoiseGeneratorOctaves netherNoiseGen1;
    private final /* synthetic */ NoiseGeneratorOctaves netherNoiseGen2;
    
    @Override
    public void func_180514_a(final Chunk lllllllllllllllIIlllIIIlIIlIlIll, final int lllllllllllllllIIlllIIIlIIlIlIlI, final int lllllllllllllllIIlllIIIlIIlIlIIl) {
        this.genNetherBridge.func_175792_a(this, this.worldObj, lllllllllllllllIIlllIIIlIIlIlIlI, lllllllllllllllIIlllIIIlIIlIlIIl, null);
    }
    
    @Override
    public boolean canSave() {
        return true;
    }
    
    static {
        __OBFID = "CL_00000392";
    }
    
    public ChunkProviderHell(final World lllllllllllllllIIlllIIlIIllIIIIl, final boolean lllllllllllllllIIlllIIlIIlIlllII, final long lllllllllllllllIIlllIIlIIlIllIll) {
        this.slowsandNoise = new double[256];
        this.gravelNoise = new double[256];
        this.netherrackExclusivityNoise = new double[256];
        this.field_177470_t = new WorldGenFire();
        this.field_177469_u = new WorldGenGlowStone1();
        this.field_177468_v = new WorldGenGlowStone2();
        this.field_177467_w = new WorldGenMinable(Blocks.quartz_ore.getDefaultState(), 14, (Predicate)BlockHelper.forBlock(Blocks.netherrack));
        this.field_177473_x = new WorldGenHellLava(Blocks.flowing_lava, true);
        this.field_177472_y = new WorldGenHellLava(Blocks.flowing_lava, false);
        this.field_177471_z = new GeneratorBushFeature(Blocks.brown_mushroom);
        this.field_177465_A = new GeneratorBushFeature(Blocks.red_mushroom);
        this.genNetherBridge = new MapGenNetherBridge();
        this.netherCaveGenerator = new MapGenCavesHell();
        this.worldObj = lllllllllllllllIIlllIIlIIllIIIIl;
        this.field_177466_i = lllllllllllllllIIlllIIlIIlIlllII;
        this.hellRNG = new Random(lllllllllllllllIIlllIIlIIlIllIll);
        this.netherNoiseGen1 = new NoiseGeneratorOctaves(this.hellRNG, 16);
        this.netherNoiseGen2 = new NoiseGeneratorOctaves(this.hellRNG, 16);
        this.netherNoiseGen3 = new NoiseGeneratorOctaves(this.hellRNG, 8);
        this.slowsandGravelNoiseGen = new NoiseGeneratorOctaves(this.hellRNG, 4);
        this.netherrackExculsivityNoiseGen = new NoiseGeneratorOctaves(this.hellRNG, 4);
        this.netherNoiseGen6 = new NoiseGeneratorOctaves(this.hellRNG, 10);
        this.netherNoiseGen7 = new NoiseGeneratorOctaves(this.hellRNG, 16);
    }
    
    public void func_180516_b(final int lllllllllllllllIIlllIIIlllIIllIl, final int lllllllllllllllIIlllIIIlllIIllII, final ChunkPrimer lllllllllllllllIIlllIIIlllIllIll) {
        final byte lllllllllllllllIIlllIIIlllIllIlI = 64;
        final double lllllllllllllllIIlllIIIlllIllIIl = 0.03125;
        this.slowsandNoise = this.slowsandGravelNoiseGen.generateNoiseOctaves(this.slowsandNoise, lllllllllllllllIIlllIIIlllIIllIl * 16, lllllllllllllllIIlllIIIlllIIllII * 16, 0, 16, 16, 1, lllllllllllllllIIlllIIIlllIllIIl, lllllllllllllllIIlllIIIlllIllIIl, 1.0);
        this.gravelNoise = this.slowsandGravelNoiseGen.generateNoiseOctaves(this.gravelNoise, lllllllllllllllIIlllIIIlllIIllIl * 16, 109, lllllllllllllllIIlllIIIlllIIllII * 16, 16, 1, 16, lllllllllllllllIIlllIIIlllIllIIl, 1.0, lllllllllllllllIIlllIIIlllIllIIl);
        this.netherrackExclusivityNoise = this.netherrackExculsivityNoiseGen.generateNoiseOctaves(this.netherrackExclusivityNoise, lllllllllllllllIIlllIIIlllIIllIl * 16, lllllllllllllllIIlllIIIlllIIllII * 16, 0, 16, 16, 1, lllllllllllllllIIlllIIIlllIllIIl * 2.0, lllllllllllllllIIlllIIIlllIllIIl * 2.0, lllllllllllllllIIlllIIIlllIllIIl * 2.0);
        for (int lllllllllllllllIIlllIIIlllIllIII = 0; lllllllllllllllIIlllIIIlllIllIII < 16; ++lllllllllllllllIIlllIIIlllIllIII) {
            for (int lllllllllllllllIIlllIIIlllIlIlll = 0; lllllllllllllllIIlllIIIlllIlIlll < 16; ++lllllllllllllllIIlllIIIlllIlIlll) {
                final boolean lllllllllllllllIIlllIIIlllIlIllI = this.slowsandNoise[lllllllllllllllIIlllIIIlllIllIII + lllllllllllllllIIlllIIIlllIlIlll * 16] + this.hellRNG.nextDouble() * 0.2 > 0.0;
                final boolean lllllllllllllllIIlllIIIlllIlIlIl = this.gravelNoise[lllllllllllllllIIlllIIIlllIllIII + lllllllllllllllIIlllIIIlllIlIlll * 16] + this.hellRNG.nextDouble() * 0.2 > 0.0;
                final int lllllllllllllllIIlllIIIlllIlIlII = (int)(this.netherrackExclusivityNoise[lllllllllllllllIIlllIIIlllIllIII + lllllllllllllllIIlllIIIlllIlIlll * 16] / 3.0 + 3.0 + this.hellRNG.nextDouble() * 0.25);
                int lllllllllllllllIIlllIIIlllIlIIll = -1;
                IBlockState lllllllllllllllIIlllIIIlllIlIIlI = Blocks.netherrack.getDefaultState();
                IBlockState lllllllllllllllIIlllIIIlllIlIIIl = Blocks.netherrack.getDefaultState();
                for (int lllllllllllllllIIlllIIIlllIlIIII = 127; lllllllllllllllIIlllIIIlllIlIIII >= 0; --lllllllllllllllIIlllIIIlllIlIIII) {
                    if (lllllllllllllllIIlllIIIlllIlIIII < 127 - this.hellRNG.nextInt(5) && lllllllllllllllIIlllIIIlllIlIIII > this.hellRNG.nextInt(5)) {
                        final IBlockState lllllllllllllllIIlllIIIlllIIllll = lllllllllllllllIIlllIIIlllIllIll.getBlockState(lllllllllllllllIIlllIIIlllIlIlll, lllllllllllllllIIlllIIIlllIlIIII, lllllllllllllllIIlllIIIlllIllIII);
                        if (lllllllllllllllIIlllIIIlllIIllll.getBlock() != null && lllllllllllllllIIlllIIIlllIIllll.getBlock().getMaterial() != Material.air) {
                            if (lllllllllllllllIIlllIIIlllIIllll.getBlock() == Blocks.netherrack) {
                                if (lllllllllllllllIIlllIIIlllIlIIll == -1) {
                                    if (lllllllllllllllIIlllIIIlllIlIlII <= 0) {
                                        lllllllllllllllIIlllIIIlllIlIIlI = null;
                                        lllllllllllllllIIlllIIIlllIlIIIl = Blocks.netherrack.getDefaultState();
                                    }
                                    else if (lllllllllllllllIIlllIIIlllIlIIII >= lllllllllllllllIIlllIIIlllIllIlI - 4 && lllllllllllllllIIlllIIIlllIlIIII <= lllllllllllllllIIlllIIIlllIllIlI + 1) {
                                        lllllllllllllllIIlllIIIlllIlIIlI = Blocks.netherrack.getDefaultState();
                                        lllllllllllllllIIlllIIIlllIlIIIl = Blocks.netherrack.getDefaultState();
                                        if (lllllllllllllllIIlllIIIlllIlIlIl) {
                                            lllllllllllllllIIlllIIIlllIlIIlI = Blocks.gravel.getDefaultState();
                                            lllllllllllllllIIlllIIIlllIlIIIl = Blocks.netherrack.getDefaultState();
                                        }
                                        if (lllllllllllllllIIlllIIIlllIlIllI) {
                                            lllllllllllllllIIlllIIIlllIlIIlI = Blocks.soul_sand.getDefaultState();
                                            lllllllllllllllIIlllIIIlllIlIIIl = Blocks.soul_sand.getDefaultState();
                                        }
                                    }
                                    if (lllllllllllllllIIlllIIIlllIlIIII < lllllllllllllllIIlllIIIlllIllIlI && (lllllllllllllllIIlllIIIlllIlIIlI == null || lllllllllllllllIIlllIIIlllIlIIlI.getBlock().getMaterial() == Material.air)) {
                                        lllllllllllllllIIlllIIIlllIlIIlI = Blocks.lava.getDefaultState();
                                    }
                                    lllllllllllllllIIlllIIIlllIlIIll = lllllllllllllllIIlllIIIlllIlIlII;
                                    if (lllllllllllllllIIlllIIIlllIlIIII >= lllllllllllllllIIlllIIIlllIllIlI - 1) {
                                        lllllllllllllllIIlllIIIlllIllIll.setBlockState(lllllllllllllllIIlllIIIlllIlIlll, lllllllllllllllIIlllIIIlllIlIIII, lllllllllllllllIIlllIIIlllIllIII, lllllllllllllllIIlllIIIlllIlIIlI);
                                    }
                                    else {
                                        lllllllllllllllIIlllIIIlllIllIll.setBlockState(lllllllllllllllIIlllIIIlllIlIlll, lllllllllllllllIIlllIIIlllIlIIII, lllllllllllllllIIlllIIIlllIllIII, lllllllllllllllIIlllIIIlllIlIIIl);
                                    }
                                }
                                else if (lllllllllllllllIIlllIIIlllIlIIll > 0) {
                                    --lllllllllllllllIIlllIIIlllIlIIll;
                                    lllllllllllllllIIlllIIIlllIllIll.setBlockState(lllllllllllllllIIlllIIIlllIlIlll, lllllllllllllllIIlllIIIlllIlIIII, lllllllllllllllIIlllIIIlllIllIII, lllllllllllllllIIlllIIIlllIlIIIl);
                                }
                            }
                        }
                        else {
                            lllllllllllllllIIlllIIIlllIlIIll = -1;
                        }
                    }
                    else {
                        lllllllllllllllIIlllIIIlllIllIll.setBlockState(lllllllllllllllIIlllIIIlllIlIlll, lllllllllllllllIIlllIIIlllIlIIII, lllllllllllllllIIlllIIIlllIllIII, Blocks.bedrock.getDefaultState());
                    }
                }
            }
        }
    }
    
    @Override
    public boolean saveChunks(final boolean lllllllllllllllIIlllIIIlIlIIIllI, final IProgressUpdate lllllllllllllllIIlllIIIlIlIIIlIl) {
        return true;
    }
    
    private double[] initializeNoiseField(double[] lllllllllllllllIIlllIIIlIlllIlll, final int lllllllllllllllIIlllIIIllIIIlllI, final int lllllllllllllllIIlllIIIllIIIllIl, final int lllllllllllllllIIlllIIIllIIIllII, final int lllllllllllllllIIlllIIIllIIIlIll, final int lllllllllllllllIIlllIIIllIIIlIlI, final int lllllllllllllllIIlllIIIlIlllIIIl) {
        if (lllllllllllllllIIlllIIIlIlllIlll == null) {
            lllllllllllllllIIlllIIIlIlllIlll = new double[lllllllllllllllIIlllIIIllIIIlIll * lllllllllllllllIIlllIIIllIIIlIlI * lllllllllllllllIIlllIIIlIlllIIIl];
        }
        final double lllllllllllllllIIlllIIIllIIIlIII = 684.412;
        final double lllllllllllllllIIlllIIIllIIIIlll = 2053.236;
        this.noiseData4 = this.netherNoiseGen6.generateNoiseOctaves(this.noiseData4, lllllllllllllllIIlllIIIllIIIlllI, lllllllllllllllIIlllIIIllIIIllIl, lllllllllllllllIIlllIIIllIIIllII, lllllllllllllllIIlllIIIllIIIlIll, 1, lllllllllllllllIIlllIIIlIlllIIIl, 1.0, 0.0, 1.0);
        this.noiseData5 = this.netherNoiseGen7.generateNoiseOctaves(this.noiseData5, lllllllllllllllIIlllIIIllIIIlllI, lllllllllllllllIIlllIIIllIIIllIl, lllllllllllllllIIlllIIIllIIIllII, lllllllllllllllIIlllIIIllIIIlIll, 1, lllllllllllllllIIlllIIIlIlllIIIl, 100.0, 0.0, 100.0);
        this.noiseData1 = this.netherNoiseGen3.generateNoiseOctaves(this.noiseData1, lllllllllllllllIIlllIIIllIIIlllI, lllllllllllllllIIlllIIIllIIIllIl, lllllllllllllllIIlllIIIllIIIllII, lllllllllllllllIIlllIIIllIIIlIll, lllllllllllllllIIlllIIIllIIIlIlI, lllllllllllllllIIlllIIIlIlllIIIl, lllllllllllllllIIlllIIIllIIIlIII / 80.0, lllllllllllllllIIlllIIIllIIIIlll / 60.0, lllllllllllllllIIlllIIIllIIIlIII / 80.0);
        this.noiseData2 = this.netherNoiseGen1.generateNoiseOctaves(this.noiseData2, lllllllllllllllIIlllIIIllIIIlllI, lllllllllllllllIIlllIIIllIIIllIl, lllllllllllllllIIlllIIIllIIIllII, lllllllllllllllIIlllIIIllIIIlIll, lllllllllllllllIIlllIIIllIIIlIlI, lllllllllllllllIIlllIIIlIlllIIIl, lllllllllllllllIIlllIIIllIIIlIII, lllllllllllllllIIlllIIIllIIIIlll, lllllllllllllllIIlllIIIllIIIlIII);
        this.noiseData3 = this.netherNoiseGen2.generateNoiseOctaves(this.noiseData3, lllllllllllllllIIlllIIIllIIIlllI, lllllllllllllllIIlllIIIllIIIllIl, lllllllllllllllIIlllIIIllIIIllII, lllllllllllllllIIlllIIIllIIIlIll, lllllllllllllllIIlllIIIllIIIlIlI, lllllllllllllllIIlllIIIlIlllIIIl, lllllllllllllllIIlllIIIllIIIlIII, lllllllllllllllIIlllIIIllIIIIlll, lllllllllllllllIIlllIIIllIIIlIII);
        int lllllllllllllllIIlllIIIllIIIIllI = 0;
        final double[] lllllllllllllllIIlllIIIllIIIIlIl = new double[lllllllllllllllIIlllIIIllIIIlIlI];
        for (int lllllllllllllllIIlllIIIllIIIIlII = 0; lllllllllllllllIIlllIIIllIIIIlII < lllllllllllllllIIlllIIIllIIIlIlI; ++lllllllllllllllIIlllIIIllIIIIlII) {
            lllllllllllllllIIlllIIIllIIIIlIl[lllllllllllllllIIlllIIIllIIIIlII] = Math.cos(lllllllllllllllIIlllIIIllIIIIlII * 3.141592653589793 * 6.0 / lllllllllllllllIIlllIIIllIIIlIlI) * 2.0;
            double lllllllllllllllIIlllIIIllIIIIIll = lllllllllllllllIIlllIIIllIIIIlII;
            if (lllllllllllllllIIlllIIIllIIIIlII > lllllllllllllllIIlllIIIllIIIlIlI / 2) {
                lllllllllllllllIIlllIIIllIIIIIll = lllllllllllllllIIlllIIIllIIIlIlI - 1 - lllllllllllllllIIlllIIIllIIIIlII;
            }
            if (lllllllllllllllIIlllIIIllIIIIIll < 4.0) {
                lllllllllllllllIIlllIIIllIIIIIll = 4.0 - lllllllllllllllIIlllIIIllIIIIIll;
                final double[] array = lllllllllllllllIIlllIIIllIIIIlIl;
                final int n = lllllllllllllllIIlllIIIllIIIIlII;
                array[n] -= lllllllllllllllIIlllIIIllIIIIIll * lllllllllllllllIIlllIIIllIIIIIll * lllllllllllllllIIlllIIIllIIIIIll * 10.0;
            }
        }
        for (int lllllllllllllllIIlllIIIllIIIIlII = 0; lllllllllllllllIIlllIIIllIIIIlII < lllllllllllllllIIlllIIIllIIIlIll; ++lllllllllllllllIIlllIIIllIIIIlII) {
            for (int lllllllllllllllIIlllIIIllIIIIIlI = 0; lllllllllllllllIIlllIIIllIIIIIlI < lllllllllllllllIIlllIIIlIlllIIIl; ++lllllllllllllllIIlllIIIllIIIIIlI) {
                final double lllllllllllllllIIlllIIIllIIIIIIl = 0.0;
                for (int lllllllllllllllIIlllIIIllIIIIIII = 0; lllllllllllllllIIlllIIIllIIIIIII < lllllllllllllllIIlllIIIllIIIlIlI; ++lllllllllllllllIIlllIIIllIIIIIII) {
                    double lllllllllllllllIIlllIIIlIlllllll = 0.0;
                    final double lllllllllllllllIIlllIIIlIllllllI = lllllllllllllllIIlllIIIllIIIIlIl[lllllllllllllllIIlllIIIllIIIIIII];
                    final double lllllllllllllllIIlllIIIlIlllllIl = this.noiseData2[lllllllllllllllIIlllIIIllIIIIllI] / 512.0;
                    final double lllllllllllllllIIlllIIIlIlllllII = this.noiseData3[lllllllllllllllIIlllIIIllIIIIllI] / 512.0;
                    final double lllllllllllllllIIlllIIIlIllllIll = (this.noiseData1[lllllllllllllllIIlllIIIllIIIIllI] / 10.0 + 1.0) / 2.0;
                    if (lllllllllllllllIIlllIIIlIllllIll < 0.0) {
                        lllllllllllllllIIlllIIIlIlllllll = lllllllllllllllIIlllIIIlIlllllIl;
                    }
                    else if (lllllllllllllllIIlllIIIlIllllIll > 1.0) {
                        lllllllllllllllIIlllIIIlIlllllll = lllllllllllllllIIlllIIIlIlllllII;
                    }
                    else {
                        lllllllllllllllIIlllIIIlIlllllll = lllllllllllllllIIlllIIIlIlllllIl + (lllllllllllllllIIlllIIIlIlllllII - lllllllllllllllIIlllIIIlIlllllIl) * lllllllllllllllIIlllIIIlIllllIll;
                    }
                    lllllllllllllllIIlllIIIlIlllllll -= lllllllllllllllIIlllIIIlIllllllI;
                    if (lllllllllllllllIIlllIIIllIIIIIII > lllllllllllllllIIlllIIIllIIIlIlI - 4) {
                        final double lllllllllllllllIIlllIIIlIllllIlI = (lllllllllllllllIIlllIIIllIIIIIII - (lllllllllllllllIIlllIIIllIIIlIlI - 4)) / 3.0f;
                        lllllllllllllllIIlllIIIlIlllllll = lllllllllllllllIIlllIIIlIlllllll * (1.0 - lllllllllllllllIIlllIIIlIllllIlI) + -10.0 * lllllllllllllllIIlllIIIlIllllIlI;
                    }
                    if (lllllllllllllllIIlllIIIllIIIIIII < lllllllllllllllIIlllIIIllIIIIIIl) {
                        double lllllllllllllllIIlllIIIlIllllIIl = (lllllllllllllllIIlllIIIllIIIIIIl - lllllllllllllllIIlllIIIllIIIIIII) / 4.0;
                        lllllllllllllllIIlllIIIlIllllIIl = MathHelper.clamp_double(lllllllllllllllIIlllIIIlIllllIIl, 0.0, 1.0);
                        lllllllllllllllIIlllIIIlIlllllll = lllllllllllllllIIlllIIIlIlllllll * (1.0 - lllllllllllllllIIlllIIIlIllllIIl) + -10.0 * lllllllllllllllIIlllIIIlIllllIIl;
                    }
                    lllllllllllllllIIlllIIIlIlllIlll[lllllllllllllllIIlllIIIllIIIIllI] = lllllllllllllllIIlllIIIlIlllllll;
                    ++lllllllllllllllIIlllIIIllIIIIllI;
                }
            }
        }
        return lllllllllllllllIIlllIIIlIlllIlll;
    }
    
    public void func_180515_a(final int lllllllllllllllIIlllIIlIIIIlIIIl, final int lllllllllllllllIIlllIIlIIIIlIIII, final ChunkPrimer lllllllllllllllIIlllIIlIIIllIIll) {
        final byte lllllllllllllllIIlllIIlIIIllIIlI = 4;
        final byte lllllllllllllllIIlllIIlIIIllIIIl = 32;
        final int lllllllllllllllIIlllIIlIIIllIIII = lllllllllllllllIIlllIIlIIIllIIlI + 1;
        final byte lllllllllllllllIIlllIIlIIIlIllll = 17;
        final int lllllllllllllllIIlllIIlIIIlIlllI = lllllllllllllllIIlllIIlIIIllIIlI + 1;
        this.noiseField = this.initializeNoiseField(this.noiseField, lllllllllllllllIIlllIIlIIIIlIIIl * lllllllllllllllIIlllIIlIIIllIIlI, 0, lllllllllllllllIIlllIIlIIIIlIIII * lllllllllllllllIIlllIIlIIIllIIlI, lllllllllllllllIIlllIIlIIIllIIII, lllllllllllllllIIlllIIlIIIlIllll, lllllllllllllllIIlllIIlIIIlIlllI);
        for (int lllllllllllllllIIlllIIlIIIlIllIl = 0; lllllllllllllllIIlllIIlIIIlIllIl < lllllllllllllllIIlllIIlIIIllIIlI; ++lllllllllllllllIIlllIIlIIIlIllIl) {
            for (int lllllllllllllllIIlllIIlIIIlIllII = 0; lllllllllllllllIIlllIIlIIIlIllII < lllllllllllllllIIlllIIlIIIllIIlI; ++lllllllllllllllIIlllIIlIIIlIllII) {
                for (int lllllllllllllllIIlllIIlIIIlIlIll = 0; lllllllllllllllIIlllIIlIIIlIlIll < 16; ++lllllllllllllllIIlllIIlIIIlIlIll) {
                    final double lllllllllllllllIIlllIIlIIIlIlIlI = 0.125;
                    double lllllllllllllllIIlllIIlIIIlIlIIl = this.noiseField[((lllllllllllllllIIlllIIlIIIlIllIl + 0) * lllllllllllllllIIlllIIlIIIlIlllI + lllllllllllllllIIlllIIlIIIlIllII + 0) * lllllllllllllllIIlllIIlIIIlIllll + lllllllllllllllIIlllIIlIIIlIlIll + 0];
                    double lllllllllllllllIIlllIIlIIIlIlIII = this.noiseField[((lllllllllllllllIIlllIIlIIIlIllIl + 0) * lllllllllllllllIIlllIIlIIIlIlllI + lllllllllllllllIIlllIIlIIIlIllII + 1) * lllllllllllllllIIlllIIlIIIlIllll + lllllllllllllllIIlllIIlIIIlIlIll + 0];
                    double lllllllllllllllIIlllIIlIIIlIIlll = this.noiseField[((lllllllllllllllIIlllIIlIIIlIllIl + 1) * lllllllllllllllIIlllIIlIIIlIlllI + lllllllllllllllIIlllIIlIIIlIllII + 0) * lllllllllllllllIIlllIIlIIIlIllll + lllllllllllllllIIlllIIlIIIlIlIll + 0];
                    double lllllllllllllllIIlllIIlIIIlIIllI = this.noiseField[((lllllllllllllllIIlllIIlIIIlIllIl + 1) * lllllllllllllllIIlllIIlIIIlIlllI + lllllllllllllllIIlllIIlIIIlIllII + 1) * lllllllllllllllIIlllIIlIIIlIllll + lllllllllllllllIIlllIIlIIIlIlIll + 0];
                    final double lllllllllllllllIIlllIIlIIIlIIlIl = (this.noiseField[((lllllllllllllllIIlllIIlIIIlIllIl + 0) * lllllllllllllllIIlllIIlIIIlIlllI + lllllllllllllllIIlllIIlIIIlIllII + 0) * lllllllllllllllIIlllIIlIIIlIllll + lllllllllllllllIIlllIIlIIIlIlIll + 1] - lllllllllllllllIIlllIIlIIIlIlIIl) * lllllllllllllllIIlllIIlIIIlIlIlI;
                    final double lllllllllllllllIIlllIIlIIIlIIlII = (this.noiseField[((lllllllllllllllIIlllIIlIIIlIllIl + 0) * lllllllllllllllIIlllIIlIIIlIlllI + lllllllllllllllIIlllIIlIIIlIllII + 1) * lllllllllllllllIIlllIIlIIIlIllll + lllllllllllllllIIlllIIlIIIlIlIll + 1] - lllllllllllllllIIlllIIlIIIlIlIII) * lllllllllllllllIIlllIIlIIIlIlIlI;
                    final double lllllllllllllllIIlllIIlIIIlIIIll = (this.noiseField[((lllllllllllllllIIlllIIlIIIlIllIl + 1) * lllllllllllllllIIlllIIlIIIlIlllI + lllllllllllllllIIlllIIlIIIlIllII + 0) * lllllllllllllllIIlllIIlIIIlIllll + lllllllllllllllIIlllIIlIIIlIlIll + 1] - lllllllllllllllIIlllIIlIIIlIIlll) * lllllllllllllllIIlllIIlIIIlIlIlI;
                    final double lllllllllllllllIIlllIIlIIIlIIIlI = (this.noiseField[((lllllllllllllllIIlllIIlIIIlIllIl + 1) * lllllllllllllllIIlllIIlIIIlIlllI + lllllllllllllllIIlllIIlIIIlIllII + 1) * lllllllllllllllIIlllIIlIIIlIllll + lllllllllllllllIIlllIIlIIIlIlIll + 1] - lllllllllllllllIIlllIIlIIIlIIllI) * lllllllllllllllIIlllIIlIIIlIlIlI;
                    for (int lllllllllllllllIIlllIIlIIIlIIIIl = 0; lllllllllllllllIIlllIIlIIIlIIIIl < 8; ++lllllllllllllllIIlllIIlIIIlIIIIl) {
                        final double lllllllllllllllIIlllIIlIIIlIIIII = 0.25;
                        double lllllllllllllllIIlllIIlIIIIlllll = lllllllllllllllIIlllIIlIIIlIlIIl;
                        double lllllllllllllllIIlllIIlIIIIllllI = lllllllllllllllIIlllIIlIIIlIlIII;
                        final double lllllllllllllllIIlllIIlIIIIlllIl = (lllllllllllllllIIlllIIlIIIlIIlll - lllllllllllllllIIlllIIlIIIlIlIIl) * lllllllllllllllIIlllIIlIIIlIIIII;
                        final double lllllllllllllllIIlllIIlIIIIlllII = (lllllllllllllllIIlllIIlIIIlIIllI - lllllllllllllllIIlllIIlIIIlIlIII) * lllllllllllllllIIlllIIlIIIlIIIII;
                        for (int lllllllllllllllIIlllIIlIIIIllIll = 0; lllllllllllllllIIlllIIlIIIIllIll < 4; ++lllllllllllllllIIlllIIlIIIIllIll) {
                            final double lllllllllllllllIIlllIIlIIIIllIlI = 0.25;
                            double lllllllllllllllIIlllIIlIIIIllIIl = lllllllllllllllIIlllIIlIIIIlllll;
                            final double lllllllllllllllIIlllIIlIIIIllIII = (lllllllllllllllIIlllIIlIIIIllllI - lllllllllllllllIIlllIIlIIIIlllll) * lllllllllllllllIIlllIIlIIIIllIlI;
                            for (int lllllllllllllllIIlllIIlIIIIlIlll = 0; lllllllllllllllIIlllIIlIIIIlIlll < 4; ++lllllllllllllllIIlllIIlIIIIlIlll) {
                                IBlockState lllllllllllllllIIlllIIlIIIIlIllI = null;
                                if (lllllllllllllllIIlllIIlIIIlIlIll * 8 + lllllllllllllllIIlllIIlIIIlIIIIl < lllllllllllllllIIlllIIlIIIllIIIl) {
                                    lllllllllllllllIIlllIIlIIIIlIllI = Blocks.lava.getDefaultState();
                                }
                                if (lllllllllllllllIIlllIIlIIIIllIIl > 0.0) {
                                    lllllllllllllllIIlllIIlIIIIlIllI = Blocks.netherrack.getDefaultState();
                                }
                                final int lllllllllllllllIIlllIIlIIIIlIlIl = lllllllllllllllIIlllIIlIIIIllIll + lllllllllllllllIIlllIIlIIIlIllIl * 4;
                                final int lllllllllllllllIIlllIIlIIIIlIlII = lllllllllllllllIIlllIIlIIIlIIIIl + lllllllllllllllIIlllIIlIIIlIlIll * 8;
                                final int lllllllllllllllIIlllIIlIIIIlIIll = lllllllllllllllIIlllIIlIIIIlIlll + lllllllllllllllIIlllIIlIIIlIllII * 4;
                                lllllllllllllllIIlllIIlIIIllIIll.setBlockState(lllllllllllllllIIlllIIlIIIIlIlIl, lllllllllllllllIIlllIIlIIIIlIlII, lllllllllllllllIIlllIIlIIIIlIIll, lllllllllllllllIIlllIIlIIIIlIllI);
                                lllllllllllllllIIlllIIlIIIIllIIl += lllllllllllllllIIlllIIlIIIIllIII;
                            }
                            lllllllllllllllIIlllIIlIIIIlllll += lllllllllllllllIIlllIIlIIIIlllIl;
                            lllllllllllllllIIlllIIlIIIIllllI += lllllllllllllllIIlllIIlIIIIlllII;
                        }
                        lllllllllllllllIIlllIIlIIIlIlIIl += lllllllllllllllIIlllIIlIIIlIIlIl;
                        lllllllllllllllIIlllIIlIIIlIlIII += lllllllllllllllIIlllIIlIIIlIIlII;
                        lllllllllllllllIIlllIIlIIIlIIlll += lllllllllllllllIIlllIIlIIIlIIIll;
                        lllllllllllllllIIlllIIlIIIlIIllI += lllllllllllllllIIlllIIlIIIlIIIlI;
                    }
                }
            }
        }
    }
    
    @Override
    public boolean unloadQueuedChunks() {
        return false;
    }
    
    @Override
    public void populate(final IChunkProvider lllllllllllllllIIlllIIIlIlIllIII, final int lllllllllllllllIIlllIIIlIlIlIIIl, final int lllllllllllllllIIlllIIIlIlIlIIII) {
        BlockFalling.fallInstantly = true;
        final BlockPos lllllllllllllllIIlllIIIlIlIlIlIl = new BlockPos(lllllllllllllllIIlllIIIlIlIlIIIl * 16, 0, lllllllllllllllIIlllIIIlIlIlIIII * 16);
        final ChunkCoordIntPair lllllllllllllllIIlllIIIlIlIlIlII = new ChunkCoordIntPair(lllllllllllllllIIlllIIIlIlIlIIIl, lllllllllllllllIIlllIIIlIlIlIIII);
        this.genNetherBridge.func_175794_a(this.worldObj, this.hellRNG, lllllllllllllllIIlllIIIlIlIlIlII);
        for (int lllllllllllllllIIlllIIIlIlIlIIll = 0; lllllllllllllllIIlllIIIlIlIlIIll < 8; ++lllllllllllllllIIlllIIIlIlIlIIll) {
            this.field_177472_y.generate(this.worldObj, this.hellRNG, lllllllllllllllIIlllIIIlIlIlIlIl.add(this.hellRNG.nextInt(16) + 8, this.hellRNG.nextInt(120) + 4, this.hellRNG.nextInt(16) + 8));
        }
        for (int lllllllllllllllIIlllIIIlIlIlIIll = 0; lllllllllllllllIIlllIIIlIlIlIIll < this.hellRNG.nextInt(this.hellRNG.nextInt(10) + 1) + 1; ++lllllllllllllllIIlllIIIlIlIlIIll) {
            this.field_177470_t.generate(this.worldObj, this.hellRNG, lllllllllllllllIIlllIIIlIlIlIlIl.add(this.hellRNG.nextInt(16) + 8, this.hellRNG.nextInt(120) + 4, this.hellRNG.nextInt(16) + 8));
        }
        for (int lllllllllllllllIIlllIIIlIlIlIIll = 0; lllllllllllllllIIlllIIIlIlIlIIll < this.hellRNG.nextInt(this.hellRNG.nextInt(10) + 1); ++lllllllllllllllIIlllIIIlIlIlIIll) {
            this.field_177469_u.generate(this.worldObj, this.hellRNG, lllllllllllllllIIlllIIIlIlIlIlIl.add(this.hellRNG.nextInt(16) + 8, this.hellRNG.nextInt(120) + 4, this.hellRNG.nextInt(16) + 8));
        }
        for (int lllllllllllllllIIlllIIIlIlIlIIll = 0; lllllllllllllllIIlllIIIlIlIlIIll < 10; ++lllllllllllllllIIlllIIIlIlIlIIll) {
            this.field_177468_v.generate(this.worldObj, this.hellRNG, lllllllllllllllIIlllIIIlIlIlIlIl.add(this.hellRNG.nextInt(16) + 8, this.hellRNG.nextInt(128), this.hellRNG.nextInt(16) + 8));
        }
        if (this.hellRNG.nextBoolean()) {
            this.field_177471_z.generate(this.worldObj, this.hellRNG, lllllllllllllllIIlllIIIlIlIlIlIl.add(this.hellRNG.nextInt(16) + 8, this.hellRNG.nextInt(128), this.hellRNG.nextInt(16) + 8));
        }
        if (this.hellRNG.nextBoolean()) {
            this.field_177465_A.generate(this.worldObj, this.hellRNG, lllllllllllllllIIlllIIIlIlIlIlIl.add(this.hellRNG.nextInt(16) + 8, this.hellRNG.nextInt(128), this.hellRNG.nextInt(16) + 8));
        }
        for (int lllllllllllllllIIlllIIIlIlIlIIll = 0; lllllllllllllllIIlllIIIlIlIlIIll < 16; ++lllllllllllllllIIlllIIIlIlIlIIll) {
            this.field_177467_w.generate(this.worldObj, this.hellRNG, lllllllllllllllIIlllIIIlIlIlIlIl.add(this.hellRNG.nextInt(16), this.hellRNG.nextInt(108) + 10, this.hellRNG.nextInt(16)));
        }
        for (int lllllllllllllllIIlllIIIlIlIlIIll = 0; lllllllllllllllIIlllIIIlIlIlIIll < 16; ++lllllllllllllllIIlllIIIlIlIlIIll) {
            this.field_177473_x.generate(this.worldObj, this.hellRNG, lllllllllllllllIIlllIIIlIlIlIlIl.add(this.hellRNG.nextInt(16), this.hellRNG.nextInt(108) + 10, this.hellRNG.nextInt(16)));
        }
        BlockFalling.fallInstantly = false;
    }
    
    @Override
    public boolean chunkExists(final int lllllllllllllllIIlllIIIlIllIIIIl, final int lllllllllllllllIIlllIIIlIllIIIII) {
        return true;
    }
    
    @Override
    public String makeString() {
        return "HellRandomLevelSource";
    }
    
    @Override
    public boolean func_177460_a(final IChunkProvider lllllllllllllllIIlllIIIlIlIIlIll, final Chunk lllllllllllllllIIlllIIIlIlIIlIlI, final int lllllllllllllllIIlllIIIlIlIIlIIl, final int lllllllllllllllIIlllIIIlIlIIlIII) {
        return false;
    }
    
    @Override
    public BlockPos func_180513_a(final World lllllllllllllllIIlllIIIlIIllIIll, final String lllllllllllllllIIlllIIIlIIllIIlI, final BlockPos lllllllllllllllIIlllIIIlIIllIIIl) {
        return null;
    }
    
    @Override
    public Chunk func_177459_a(final BlockPos lllllllllllllllIIlllIIIlIIlIIIII) {
        return this.provideChunk(lllllllllllllllIIlllIIIlIIlIIIII.getX() >> 4, lllllllllllllllIIlllIIIlIIlIIIII.getZ() >> 4);
    }
    
    @Override
    public Chunk provideChunk(final int lllllllllllllllIIlllIIIllIlIllIl, final int lllllllllllllllIIlllIIIllIlIllII) {
        this.hellRNG.setSeed(lllllllllllllllIIlllIIIllIlIllIl * 341873128712L + lllllllllllllllIIlllIIIllIlIllII * 132897987541L);
        final ChunkPrimer lllllllllllllllIIlllIIIllIllIIll = new ChunkPrimer();
        this.func_180515_a(lllllllllllllllIIlllIIIllIlIllIl, lllllllllllllllIIlllIIIllIlIllII, lllllllllllllllIIlllIIIllIllIIll);
        this.func_180516_b(lllllllllllllllIIlllIIIllIlIllIl, lllllllllllllllIIlllIIIllIlIllII, lllllllllllllllIIlllIIIllIllIIll);
        this.netherCaveGenerator.func_175792_a(this, this.worldObj, lllllllllllllllIIlllIIIllIlIllIl, lllllllllllllllIIlllIIIllIlIllII, lllllllllllllllIIlllIIIllIllIIll);
        if (this.field_177466_i) {
            this.genNetherBridge.func_175792_a(this, this.worldObj, lllllllllllllllIIlllIIIllIlIllIl, lllllllllllllllIIlllIIIllIlIllII, lllllllllllllllIIlllIIIllIllIIll);
        }
        final Chunk lllllllllllllllIIlllIIIllIllIIlI = new Chunk(this.worldObj, lllllllllllllllIIlllIIIllIllIIll, lllllllllllllllIIlllIIIllIlIllIl, lllllllllllllllIIlllIIIllIlIllII);
        final BiomeGenBase[] lllllllllllllllIIlllIIIllIllIIIl = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(null, lllllllllllllllIIlllIIIllIlIllIl * 16, lllllllllllllllIIlllIIIllIlIllII * 16, 16, 16);
        final byte[] lllllllllllllllIIlllIIIllIllIIII = lllllllllllllllIIlllIIIllIllIIlI.getBiomeArray();
        for (int lllllllllllllllIIlllIIIllIlIllll = 0; lllllllllllllllIIlllIIIllIlIllll < lllllllllllllllIIlllIIIllIllIIII.length; ++lllllllllllllllIIlllIIIllIlIllll) {
            lllllllllllllllIIlllIIIllIllIIII[lllllllllllllllIIlllIIIllIlIllll] = (byte)lllllllllllllllIIlllIIIllIllIIIl[lllllllllllllllIIlllIIIllIlIllll].biomeID;
        }
        lllllllllllllllIIlllIIIllIllIIlI.resetRelightChecks();
        return lllllllllllllllIIlllIIIllIllIIlI;
    }
    
    @Override
    public int getLoadedChunkCount() {
        return 0;
    }
    
    @Override
    public void saveExtraData() {
    }
    
    @Override
    public List func_177458_a(final EnumCreatureType lllllllllllllllIIlllIIIlIIlllIll, final BlockPos lllllllllllllllIIlllIIIlIIlllIlI) {
        if (lllllllllllllllIIlllIIIlIIlllIll == EnumCreatureType.MONSTER) {
            if (this.genNetherBridge.func_175795_b(lllllllllllllllIIlllIIIlIIlllIlI)) {
                return this.genNetherBridge.getSpawnList();
            }
            if (this.genNetherBridge.func_175796_a(this.worldObj, lllllllllllllllIIlllIIIlIIlllIlI) && this.worldObj.getBlockState(lllllllllllllllIIlllIIIlIIlllIlI.offsetDown()).getBlock() == Blocks.nether_brick) {
                return this.genNetherBridge.getSpawnList();
            }
        }
        final BiomeGenBase lllllllllllllllIIlllIIIlIIlllIIl = this.worldObj.getBiomeGenForCoords(lllllllllllllllIIlllIIIlIIlllIlI);
        return lllllllllllllllIIlllIIIlIIlllIIl.getSpawnableList(lllllllllllllllIIlllIIIlIIlllIll);
    }
}
