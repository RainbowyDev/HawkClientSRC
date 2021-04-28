package net.minecraft.world.biome;

import net.minecraft.block.state.*;
import net.minecraft.world.gen.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.world.chunk.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.block.properties.*;
import net.minecraft.item.*;
import net.minecraft.block.*;
import net.minecraft.world.gen.feature.*;
import java.util.*;

public class BiomeGenMesa extends BiomeGenBase
{
    private /* synthetic */ IBlockState[] field_150621_aC;
    private /* synthetic */ NoiseGeneratorPerlin field_150623_aE;
    private /* synthetic */ boolean field_150620_aI;
    private /* synthetic */ NoiseGeneratorPerlin field_150624_aF;
    private /* synthetic */ boolean field_150626_aH;
    private /* synthetic */ NoiseGeneratorPerlin field_150625_aG;
    private /* synthetic */ long field_150622_aD;
    
    @Override
    public int func_180627_b(final BlockPos llllllllllllllllllIlIlIIlIIIlIll) {
        return 9470285;
    }
    
    static {
        __OBFID = "CL_00000176";
    }
    
    @Override
    public void func_180624_a(final World llllllllllllllllllIlIlIIlIIIIIIl, final Random llllllllllllllllllIlIlIIlIIIIlII, final BlockPos llllllllllllllllllIlIlIIlIIIIIll) {
        super.func_180624_a(llllllllllllllllllIlIlIIlIIIIIIl, llllllllllllllllllIlIlIIlIIIIlII, llllllllllllllllllIlIlIIlIIIIIll);
    }
    
    @Override
    public void genTerrainBlocks(final World llllllllllllllllllIlIlIIIllIlIIl, final Random llllllllllllllllllIlIlIIIlIIlIlI, final ChunkPrimer llllllllllllllllllIlIlIIIllIIlll, final int llllllllllllllllllIlIlIIIlIIlIII, final int llllllllllllllllllIlIlIIIllIIlIl, final double llllllllllllllllllIlIlIIIlIIIllI) {
        if (this.field_150621_aC == null || this.field_150622_aD != llllllllllllllllllIlIlIIIllIlIIl.getSeed()) {
            this.func_150619_a(llllllllllllllllllIlIlIIIllIlIIl.getSeed());
        }
        if (this.field_150623_aE == null || this.field_150624_aF == null || this.field_150622_aD != llllllllllllllllllIlIlIIIllIlIIl.getSeed()) {
            final Random llllllllllllllllllIlIlIIIllIIIll = new Random(this.field_150622_aD);
            this.field_150623_aE = new NoiseGeneratorPerlin(llllllllllllllllllIlIlIIIllIIIll, 4);
            this.field_150624_aF = new NoiseGeneratorPerlin(llllllllllllllllllIlIlIIIllIIIll, 1);
        }
        this.field_150622_aD = llllllllllllllllllIlIlIIIllIlIIl.getSeed();
        double llllllllllllllllllIlIlIIIllIIIlI = 0.0;
        if (this.field_150626_aH) {
            final int llllllllllllllllllIlIlIIIllIIIIl = (llllllllllllllllllIlIlIIIlIIlIII & 0xFFFFFFF0) + (llllllllllllllllllIlIlIIIllIIlIl & 0xF);
            final int llllllllllllllllllIlIlIIIlIlllll = (llllllllllllllllllIlIlIIIllIIlIl & 0xFFFFFFF0) + (llllllllllllllllllIlIlIIIlIIlIII & 0xF);
            final double llllllllllllllllllIlIlIIIlIlllIl = Math.min(Math.abs(llllllllllllllllllIlIlIIIlIIIllI), this.field_150623_aE.func_151601_a(llllllllllllllllllIlIlIIIllIIIIl * 0.25, llllllllllllllllllIlIlIIIlIlllll * 0.25));
            if (llllllllllllllllllIlIlIIIlIlllIl > 0.0) {
                final double llllllllllllllllllIlIlIIIlIlllII = 0.001953125;
                final double llllllllllllllllllIlIlIIIlIllIll = Math.abs(this.field_150624_aF.func_151601_a(llllllllllllllllllIlIlIIIllIIIIl * llllllllllllllllllIlIlIIIlIlllII, llllllllllllllllllIlIlIIIlIlllll * llllllllllllllllllIlIlIIIlIlllII));
                llllllllllllllllllIlIlIIIllIIIlI = llllllllllllllllllIlIlIIIlIlllIl * llllllllllllllllllIlIlIIIlIlllIl * 2.5;
                final double llllllllllllllllllIlIlIIIlIllIlI = Math.ceil(llllllllllllllllllIlIlIIIlIllIll * 50.0) + 14.0;
                if (llllllllllllllllllIlIlIIIllIIIlI > llllllllllllllllllIlIlIIIlIllIlI) {
                    llllllllllllllllllIlIlIIIllIIIlI = llllllllllllllllllIlIlIIIlIllIlI;
                }
                llllllllllllllllllIlIlIIIllIIIlI += 64.0;
            }
        }
        final int llllllllllllllllllIlIlIIIllIIIII = llllllllllllllllllIlIlIIIlIIlIII & 0xF;
        final int llllllllllllllllllIlIlIIIlIllllI = llllllllllllllllllIlIlIIIllIIlIl & 0xF;
        final boolean llllllllllllllllllIlIlIIIlIllIIl = true;
        IBlockState llllllllllllllllllIlIlIIIlIllIII = Blocks.stained_hardened_clay.getDefaultState();
        IBlockState llllllllllllllllllIlIlIIIlIlIlll = this.fillerBlock;
        final int llllllllllllllllllIlIlIIIlIlIllI = (int)(llllllllllllllllllIlIlIIIlIIIllI / 3.0 + 3.0 + llllllllllllllllllIlIlIIIlIIlIlI.nextDouble() * 0.25);
        final boolean llllllllllllllllllIlIlIIIlIlIlIl = Math.cos(llllllllllllllllllIlIlIIIlIIIllI / 3.0 * 3.141592653589793) > 0.0;
        int llllllllllllllllllIlIlIIIlIlIlII = -1;
        boolean llllllllllllllllllIlIlIIIlIlIIll = false;
        for (int llllllllllllllllllIlIlIIIlIlIIlI = 255; llllllllllllllllllIlIlIIIlIlIIlI >= 0; --llllllllllllllllllIlIlIIIlIlIIlI) {
            if (llllllllllllllllllIlIlIIIllIIlll.getBlockState(llllllllllllllllllIlIlIIIlIllllI, llllllllllllllllllIlIlIIIlIlIIlI, llllllllllllllllllIlIlIIIllIIIII).getBlock().getMaterial() == Material.air && llllllllllllllllllIlIlIIIlIlIIlI < (int)llllllllllllllllllIlIlIIIllIIIlI) {
                llllllllllllllllllIlIlIIIllIIlll.setBlockState(llllllllllllllllllIlIlIIIlIllllI, llllllllllllllllllIlIlIIIlIlIIlI, llllllllllllllllllIlIlIIIllIIIII, Blocks.stone.getDefaultState());
            }
            if (llllllllllllllllllIlIlIIIlIlIIlI <= llllllllllllllllllIlIlIIIlIIlIlI.nextInt(5)) {
                llllllllllllllllllIlIlIIIllIIlll.setBlockState(llllllllllllllllllIlIlIIIlIllllI, llllllllllllllllllIlIlIIIlIlIIlI, llllllllllllllllllIlIlIIIllIIIII, Blocks.bedrock.getDefaultState());
            }
            else {
                final IBlockState llllllllllllllllllIlIlIIIlIlIIIl = llllllllllllllllllIlIlIIIllIIlll.getBlockState(llllllllllllllllllIlIlIIIlIllllI, llllllllllllllllllIlIlIIIlIlIIlI, llllllllllllllllllIlIlIIIllIIIII);
                if (llllllllllllllllllIlIlIIIlIlIIIl.getBlock().getMaterial() == Material.air) {
                    llllllllllllllllllIlIlIIIlIlIlII = -1;
                }
                else if (llllllllllllllllllIlIlIIIlIlIIIl.getBlock() == Blocks.stone) {
                    if (llllllllllllllllllIlIlIIIlIlIlII == -1) {
                        llllllllllllllllllIlIlIIIlIlIIll = false;
                        if (llllllllllllllllllIlIlIIIlIlIllI <= 0) {
                            llllllllllllllllllIlIlIIIlIllIII = null;
                            llllllllllllllllllIlIlIIIlIlIlll = Blocks.stone.getDefaultState();
                        }
                        else if (llllllllllllllllllIlIlIIIlIlIIlI >= 59 && llllllllllllllllllIlIlIIIlIlIIlI <= 64) {
                            llllllllllllllllllIlIlIIIlIllIII = Blocks.stained_hardened_clay.getDefaultState();
                            llllllllllllllllllIlIlIIIlIlIlll = this.fillerBlock;
                        }
                        if (llllllllllllllllllIlIlIIIlIlIIlI < 63 && (llllllllllllllllllIlIlIIIlIllIII == null || llllllllllllllllllIlIlIIIlIllIII.getBlock().getMaterial() == Material.air)) {
                            llllllllllllllllllIlIlIIIlIllIII = Blocks.water.getDefaultState();
                        }
                        llllllllllllllllllIlIlIIIlIlIlII = llllllllllllllllllIlIlIIIlIlIllI + Math.max(0, llllllllllllllllllIlIlIIIlIlIIlI - 63);
                        if (llllllllllllllllllIlIlIIIlIlIIlI >= 62) {
                            if (this.field_150620_aI && llllllllllllllllllIlIlIIIlIlIIlI > 86 + llllllllllllllllllIlIlIIIlIlIllI * 2) {
                                if (llllllllllllllllllIlIlIIIlIlIlIl) {
                                    llllllllllllllllllIlIlIIIllIIlll.setBlockState(llllllllllllllllllIlIlIIIlIllllI, llllllllllllllllllIlIlIIIlIlIIlI, llllllllllllllllllIlIlIIIllIIIII, Blocks.dirt.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.COARSE_DIRT));
                                }
                                else {
                                    llllllllllllllllllIlIlIIIllIIlll.setBlockState(llllllllllllllllllIlIlIIIlIllllI, llllllllllllllllllIlIlIIIlIlIIlI, llllllllllllllllllIlIlIIIllIIIII, Blocks.grass.getDefaultState());
                                }
                            }
                            else if (llllllllllllllllllIlIlIIIlIlIIlI > 66 + llllllllllllllllllIlIlIIIlIlIllI) {
                                IBlockState llllllllllllllllllIlIlIIIlIIlllI = null;
                                if (llllllllllllllllllIlIlIIIlIlIIlI >= 64 && llllllllllllllllllIlIlIIIlIlIIlI <= 127) {
                                    if (llllllllllllllllllIlIlIIIlIlIlIl) {
                                        final IBlockState llllllllllllllllllIlIlIIIlIlIIII = Blocks.hardened_clay.getDefaultState();
                                    }
                                    else {
                                        final IBlockState llllllllllllllllllIlIlIIIlIIllll = this.func_180629_a(llllllllllllllllllIlIlIIIlIIlIII, llllllllllllllllllIlIlIIIlIlIIlI, llllllllllllllllllIlIlIIIllIIlIl);
                                    }
                                }
                                else {
                                    llllllllllllllllllIlIlIIIlIIlllI = Blocks.stained_hardened_clay.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.ORANGE);
                                }
                                llllllllllllllllllIlIlIIIllIIlll.setBlockState(llllllllllllllllllIlIlIIIlIllllI, llllllllllllllllllIlIlIIIlIlIIlI, llllllllllllllllllIlIlIIIllIIIII, llllllllllllllllllIlIlIIIlIIlllI);
                            }
                            else {
                                llllllllllllllllllIlIlIIIllIIlll.setBlockState(llllllllllllllllllIlIlIIIlIllllI, llllllllllllllllllIlIlIIIlIlIIlI, llllllllllllllllllIlIlIIIllIIIII, this.topBlock);
                                llllllllllllllllllIlIlIIIlIlIIll = true;
                            }
                        }
                        else {
                            llllllllllllllllllIlIlIIIllIIlll.setBlockState(llllllllllllllllllIlIlIIIlIllllI, llllllllllllllllllIlIlIIIlIlIIlI, llllllllllllllllllIlIlIIIllIIIII, llllllllllllllllllIlIlIIIlIlIlll);
                            if (llllllllllllllllllIlIlIIIlIlIlll.getBlock() == Blocks.stained_hardened_clay) {
                                llllllllllllllllllIlIlIIIllIIlll.setBlockState(llllllllllllllllllIlIlIIIlIllllI, llllllllllllllllllIlIlIIIlIlIIlI, llllllllllllllllllIlIlIIIllIIIII, llllllllllllllllllIlIlIIIlIlIlll.getBlock().getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.ORANGE));
                            }
                        }
                    }
                    else if (llllllllllllllllllIlIlIIIlIlIlII > 0) {
                        --llllllllllllllllllIlIlIIIlIlIlII;
                        if (llllllllllllllllllIlIlIIIlIlIIll) {
                            llllllllllllllllllIlIlIIIllIIlll.setBlockState(llllllllllllllllllIlIlIIIlIllllI, llllllllllllllllllIlIlIIIlIlIIlI, llllllllllllllllllIlIlIIIllIIIII, Blocks.stained_hardened_clay.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.ORANGE));
                        }
                        else {
                            final IBlockState llllllllllllllllllIlIlIIIlIIllIl = this.func_180629_a(llllllllllllllllllIlIlIIIlIIlIII, llllllllllllllllllIlIlIIIlIlIIlI, llllllllllllllllllIlIlIIIllIIlIl);
                            llllllllllllllllllIlIlIIIllIIlll.setBlockState(llllllllllllllllllIlIlIIIlIllllI, llllllllllllllllllIlIlIIIlIlIIlI, llllllllllllllllllIlIlIIIllIIIII, llllllllllllllllllIlIlIIIlIIllIl);
                        }
                    }
                }
            }
        }
    }
    
    @Override
    public int func_180625_c(final BlockPos llllllllllllllllllIlIlIIlIIIllIl) {
        return 10387789;
    }
    
    @Override
    protected BiomeGenBase createMutatedBiome(final int llllllllllllllllllIlIIllllllllII) {
        final boolean llllllllllllllllllIlIIlllllllIll = this.biomeID == BiomeGenBase.mesa.biomeID;
        final BiomeGenMesa llllllllllllllllllIlIIlllllllIlI = new BiomeGenMesa(llllllllllllllllllIlIIllllllllII, llllllllllllllllllIlIIlllllllIll, this.field_150620_aI);
        if (!llllllllllllllllllIlIIlllllllIll) {
            llllllllllllllllllIlIIlllllllIlI.setHeight(BiomeGenMesa.height_LowHills);
            llllllllllllllllllIlIIlllllllIlI.setBiomeName(String.valueOf(new StringBuilder(String.valueOf(this.biomeName)).append(" M")));
        }
        else {
            llllllllllllllllllIlIIlllllllIlI.setBiomeName(String.valueOf(new StringBuilder(String.valueOf(this.biomeName)).append(" (Bryce)")));
        }
        llllllllllllllllllIlIIlllllllIlI.func_150557_a(this.color, true);
        return llllllllllllllllllIlIIlllllllIlI;
    }
    
    public BiomeGenMesa(final int llllllllllllllllllIlIlIIlIIllIIl, final boolean llllllllllllllllllIlIlIIlIIllIII, final boolean llllllllllllllllllIlIlIIlIIlIlll) {
        super(llllllllllllllllllIlIlIIlIIllIIl);
        this.field_150626_aH = llllllllllllllllllIlIlIIlIIllIII;
        this.field_150620_aI = llllllllllllllllllIlIlIIlIIlIlll;
        this.setDisableRain();
        this.setTemperatureRainfall(2.0f, 0.0f);
        this.spawnableCreatureList.clear();
        this.topBlock = Blocks.sand.getDefaultState().withProperty(BlockSand.VARIANT_PROP, BlockSand.EnumType.RED_SAND);
        this.fillerBlock = Blocks.stained_hardened_clay.getDefaultState();
        this.theBiomeDecorator.treesPerChunk = -999;
        this.theBiomeDecorator.deadBushPerChunk = 20;
        this.theBiomeDecorator.reedsPerChunk = 3;
        this.theBiomeDecorator.cactiPerChunk = 5;
        this.theBiomeDecorator.flowersPerChunk = 0;
        this.spawnableCreatureList.clear();
        if (llllllllllllllllllIlIlIIlIIlIlll) {
            this.theBiomeDecorator.treesPerChunk = 5;
        }
    }
    
    private IBlockState func_180629_a(final int llllllllllllllllllIlIlIIIIIIlIIl, final int llllllllllllllllllIlIlIIIIIIlIII, final int llllllllllllllllllIlIlIIIIIIIlll) {
        final int llllllllllllllllllIlIlIIIIIIIllI = (int)Math.round(this.field_150625_aG.func_151601_a(llllllllllllllllllIlIlIIIIIIlIIl * 1.0 / 512.0, llllllllllllllllllIlIlIIIIIIlIIl * 1.0 / 512.0) * 2.0);
        return this.field_150621_aC[(llllllllllllllllllIlIlIIIIIIlIII + llllllllllllllllllIlIlIIIIIIIllI + 64) % 64];
    }
    
    @Override
    public WorldGenAbstractTree genBigTreeChance(final Random llllllllllllllllllIlIlIIlIIlIIII) {
        return this.worldGeneratorTrees;
    }
    
    private void func_150619_a(final long llllllllllllllllllIlIlIIIIlIllII) {
        this.field_150621_aC = new IBlockState[64];
        Arrays.fill(this.field_150621_aC, Blocks.hardened_clay.getDefaultState());
        final Random llllllllllllllllllIlIlIIIIlIlIll = new Random(llllllllllllllllllIlIlIIIIlIllII);
        this.field_150625_aG = new NoiseGeneratorPerlin(llllllllllllllllllIlIlIIIIlIlIll, 1);
        for (int llllllllllllllllllIlIlIIIIlIlIlI = 0; llllllllllllllllllIlIlIIIIlIlIlI < 64; ++llllllllllllllllllIlIlIIIIlIlIlI) {
            llllllllllllllllllIlIlIIIIlIlIlI += llllllllllllllllllIlIlIIIIlIlIll.nextInt(5) + 1;
            if (llllllllllllllllllIlIlIIIIlIlIlI < 64) {
                this.field_150621_aC[llllllllllllllllllIlIlIIIIlIlIlI] = Blocks.stained_hardened_clay.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.ORANGE);
            }
        }
        for (int llllllllllllllllllIlIlIIIIlIlIlI = llllllllllllllllllIlIlIIIIlIlIll.nextInt(4) + 2, llllllllllllllllllIlIlIIIIlIlIIl = 0; llllllllllllllllllIlIlIIIIlIlIIl < llllllllllllllllllIlIlIIIIlIlIlI; ++llllllllllllllllllIlIlIIIIlIlIIl) {
            for (int llllllllllllllllllIlIlIIIIlIlIII = llllllllllllllllllIlIlIIIIlIlIll.nextInt(3) + 1, llllllllllllllllllIlIlIIIIlIIllI = llllllllllllllllllIlIlIIIIlIlIll.nextInt(64), llllllllllllllllllIlIlIIIIlIIIll = 0; llllllllllllllllllIlIlIIIIlIIllI + llllllllllllllllllIlIlIIIIlIIIll < 64 && llllllllllllllllllIlIlIIIIlIIIll < llllllllllllllllllIlIlIIIIlIlIII; ++llllllllllllllllllIlIlIIIIlIIIll) {
                this.field_150621_aC[llllllllllllllllllIlIlIIIIlIIllI + llllllllllllllllllIlIlIIIIlIIIll] = Blocks.stained_hardened_clay.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.YELLOW);
            }
        }
        for (int llllllllllllllllllIlIlIIIIlIlIIl = llllllllllllllllllIlIlIIIIlIlIll.nextInt(4) + 2, llllllllllllllllllIlIlIIIIlIIlll = 0; llllllllllllllllllIlIlIIIIlIIlll < llllllllllllllllllIlIlIIIIlIlIIl; ++llllllllllllllllllIlIlIIIIlIIlll) {
            for (int llllllllllllllllllIlIlIIIIlIIlIl = llllllllllllllllllIlIlIIIIlIlIll.nextInt(3) + 2, llllllllllllllllllIlIlIIIIlIIIlI = llllllllllllllllllIlIlIIIIlIlIll.nextInt(64), llllllllllllllllllIlIlIIIIIlllll = 0; llllllllllllllllllIlIlIIIIlIIIlI + llllllllllllllllllIlIlIIIIIlllll < 64 && llllllllllllllllllIlIlIIIIIlllll < llllllllllllllllllIlIlIIIIlIIlIl; ++llllllllllllllllllIlIlIIIIIlllll) {
                this.field_150621_aC[llllllllllllllllllIlIlIIIIlIIIlI + llllllllllllllllllIlIlIIIIIlllll] = Blocks.stained_hardened_clay.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.BROWN);
            }
        }
        for (int llllllllllllllllllIlIlIIIIlIIlll = llllllllllllllllllIlIlIIIIlIlIll.nextInt(4) + 2, llllllllllllllllllIlIlIIIIlIIlII = 0; llllllllllllllllllIlIlIIIIlIIlII < llllllllllllllllllIlIlIIIIlIIlll; ++llllllllllllllllllIlIlIIIIlIIlII) {
            for (int llllllllllllllllllIlIlIIIIlIIIIl = llllllllllllllllllIlIlIIIIlIlIll.nextInt(3) + 1, llllllllllllllllllIlIlIIIIIllllI = llllllllllllllllllIlIlIIIIlIlIll.nextInt(64), llllllllllllllllllIlIlIIIIIlllII = 0; llllllllllllllllllIlIlIIIIIllllI + llllllllllllllllllIlIlIIIIIlllII < 64 && llllllllllllllllllIlIlIIIIIlllII < llllllllllllllllllIlIlIIIIlIIIIl; ++llllllllllllllllllIlIlIIIIIlllII) {
                this.field_150621_aC[llllllllllllllllllIlIlIIIIIllllI + llllllllllllllllllIlIlIIIIIlllII] = Blocks.stained_hardened_clay.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.RED);
            }
        }
        int llllllllllllllllllIlIlIIIIlIIlII = llllllllllllllllllIlIlIIIIlIlIll.nextInt(3) + 3;
        int llllllllllllllllllIlIlIIIIlIIIII = 0;
        for (int llllllllllllllllllIlIlIIIIIlllIl = 0; llllllllllllllllllIlIlIIIIIlllIl < llllllllllllllllllIlIlIIIIlIIlII; ++llllllllllllllllllIlIlIIIIIlllIl) {
            final byte llllllllllllllllllIlIlIIIIIllIll = 1;
            llllllllllllllllllIlIlIIIIlIIIII += llllllllllllllllllIlIlIIIIlIlIll.nextInt(16) + 4;
            for (int llllllllllllllllllIlIlIIIIIllIlI = 0; llllllllllllllllllIlIlIIIIlIIIII + llllllllllllllllllIlIlIIIIIllIlI < 64 && llllllllllllllllllIlIlIIIIIllIlI < llllllllllllllllllIlIlIIIIIllIll; ++llllllllllllllllllIlIlIIIIIllIlI) {
                this.field_150621_aC[llllllllllllllllllIlIlIIIIlIIIII + llllllllllllllllllIlIlIIIIIllIlI] = Blocks.stained_hardened_clay.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.WHITE);
                if (llllllllllllllllllIlIlIIIIlIIIII + llllllllllllllllllIlIlIIIIIllIlI > 1 && llllllllllllllllllIlIlIIIIlIlIll.nextBoolean()) {
                    this.field_150621_aC[llllllllllllllllllIlIlIIIIlIIIII + llllllllllllllllllIlIlIIIIIllIlI - 1] = Blocks.stained_hardened_clay.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.SILVER);
                }
                if (llllllllllllllllllIlIlIIIIlIIIII + llllllllllllllllllIlIlIIIIIllIlI < 63 && llllllllllllllllllIlIlIIIIlIlIll.nextBoolean()) {
                    this.field_150621_aC[llllllllllllllllllIlIlIIIIlIIIII + llllllllllllllllllIlIlIIIIIllIlI + 1] = Blocks.stained_hardened_clay.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.SILVER);
                }
            }
        }
    }
}
