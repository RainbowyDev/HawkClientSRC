package net.minecraft.world.biome;

import java.util.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.block.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.entity.passive.*;

public class BiomeGenForest extends BiomeGenBase
{
    protected static final /* synthetic */ WorldGenForest field_150629_aC;
    protected static final /* synthetic */ WorldGenForest field_150630_aD;
    private /* synthetic */ int field_150632_aF;
    protected static final /* synthetic */ WorldGenCanopyTree field_150631_aE;
    
    @Override
    public BlockFlower.EnumFlowerType pickRandomFlower(final Random llllllllllllllIIIIlIllllIIIllIlI, final BlockPos llllllllllllllIIIIlIllllIIIllIIl) {
        if (this.field_150632_aF == 1) {
            final double llllllllllllllIIIIlIllllIIIllIII = MathHelper.clamp_double((1.0 + BiomeGenForest.field_180281_af.func_151601_a(llllllllllllllIIIIlIllllIIIllIIl.getX() / 48.0, llllllllllllllIIIIlIllllIIIllIIl.getZ() / 48.0)) / 2.0, 0.0, 0.9999);
            final BlockFlower.EnumFlowerType llllllllllllllIIIIlIllllIIIlIlll = BlockFlower.EnumFlowerType.values()[(int)(llllllllllllllIIIIlIllllIIIllIII * BlockFlower.EnumFlowerType.values().length)];
            return (llllllllllllllIIIIlIllllIIIlIlll == BlockFlower.EnumFlowerType.BLUE_ORCHID) ? BlockFlower.EnumFlowerType.POPPY : llllllllllllllIIIIlIllllIIIlIlll;
        }
        return super.pickRandomFlower(llllllllllllllIIIIlIllllIIIllIlI, llllllllllllllIIIIlIllllIIIllIIl);
    }
    
    @Override
    public void func_180624_a(final World llllllllllllllIIIIlIlllIllllIIll, final Random llllllllllllllIIIIlIllllIIIIIlII, final BlockPos llllllllllllllIIIIlIlllIllllIIIl) {
        if (this.field_150632_aF == 3) {
            for (int llllllllllllllIIIIlIllllIIIIIIlI = 0; llllllllllllllIIIIlIllllIIIIIIlI < 4; ++llllllllllllllIIIIlIllllIIIIIIlI) {
                for (int llllllllllllllIIIIlIllllIIIIIIII = 0; llllllllllllllIIIIlIllllIIIIIIII < 4; ++llllllllllllllIIIIlIllllIIIIIIII) {
                    final int llllllllllllllIIIIlIlllIlllllllI = llllllllllllllIIIIlIllllIIIIIIlI * 4 + 1 + 8 + llllllllllllllIIIIlIllllIIIIIlII.nextInt(3);
                    final int llllllllllllllIIIIlIlllIllllllII = llllllllllllllIIIIlIllllIIIIIIII * 4 + 1 + 8 + llllllllllllllIIIIlIllllIIIIIlII.nextInt(3);
                    final BlockPos llllllllllllllIIIIlIlllIlllllIlI = llllllllllllllIIIIlIlllIllllIIll.getHorizon(llllllllllllllIIIIlIlllIllllIIIl.add(llllllllllllllIIIIlIlllIlllllllI, 0, llllllllllllllIIIIlIlllIllllllII));
                    if (llllllllllllllIIIIlIllllIIIIIlII.nextInt(20) == 0) {
                        final WorldGenBigMushroom llllllllllllllIIIIlIlllIlllllIIl = new WorldGenBigMushroom();
                        llllllllllllllIIIIlIlllIlllllIIl.generate(llllllllllllllIIIIlIlllIllllIIll, llllllllllllllIIIIlIllllIIIIIlII, llllllllllllllIIIIlIlllIlllllIlI);
                    }
                    else {
                        final WorldGenAbstractTree llllllllllllllIIIIlIlllIlllllIII = this.genBigTreeChance(llllllllllllllIIIIlIllllIIIIIlII);
                        llllllllllllllIIIIlIlllIlllllIII.func_175904_e();
                        if (llllllllllllllIIIIlIlllIlllllIII.generate(llllllllllllllIIIIlIlllIllllIIll, llllllllllllllIIIIlIllllIIIIIlII, llllllllllllllIIIIlIlllIlllllIlI)) {
                            llllllllllllllIIIIlIlllIlllllIII.func_180711_a(llllllllllllllIIIIlIlllIllllIIll, llllllllllllllIIIIlIllllIIIIIlII, llllllllllllllIIIIlIlllIlllllIlI);
                        }
                    }
                }
            }
        }
        int llllllllllllllIIIIlIllllIIIIIIIl = llllllllllllllIIIIlIllllIIIIIlII.nextInt(5) - 3;
        if (this.field_150632_aF == 1) {
            llllllllllllllIIIIlIllllIIIIIIIl += 2;
        }
        for (int llllllllllllllIIIIlIlllIllllllll = 0; llllllllllllllIIIIlIlllIllllllll < llllllllllllllIIIIlIllllIIIIIIIl; ++llllllllllllllIIIIlIlllIllllllll) {
            final int llllllllllllllIIIIlIlllIllllllIl = llllllllllllllIIIIlIllllIIIIIlII.nextInt(3);
            if (llllllllllllllIIIIlIlllIllllllIl == 0) {
                BiomeGenForest.field_180280_ag.func_180710_a(BlockDoublePlant.EnumPlantType.SYRINGA);
            }
            else if (llllllllllllllIIIIlIlllIllllllIl == 1) {
                BiomeGenForest.field_180280_ag.func_180710_a(BlockDoublePlant.EnumPlantType.ROSE);
            }
            else if (llllllllllllllIIIIlIlllIllllllIl == 2) {
                BiomeGenForest.field_180280_ag.func_180710_a(BlockDoublePlant.EnumPlantType.PAEONIA);
            }
            for (int llllllllllllllIIIIlIlllIlllllIll = 0; llllllllllllllIIIIlIlllIlllllIll < 5; ++llllllllllllllIIIIlIlllIlllllIll) {
                final int llllllllllllllIIIIlIlllIllllIlll = llllllllllllllIIIIlIllllIIIIIlII.nextInt(16) + 8;
                final int llllllllllllllIIIIlIlllIllllIllI = llllllllllllllIIIIlIllllIIIIIlII.nextInt(16) + 8;
                final int llllllllllllllIIIIlIlllIllllIlIl = llllllllllllllIIIIlIllllIIIIIlII.nextInt(llllllllllllllIIIIlIlllIllllIIll.getHorizon(llllllllllllllIIIIlIlllIllllIIIl.add(llllllllllllllIIIIlIlllIllllIlll, 0, llllllllllllllIIIIlIlllIllllIllI)).getY() + 32);
                if (BiomeGenForest.field_180280_ag.generate(llllllllllllllIIIIlIlllIllllIIll, llllllllllllllIIIIlIllllIIIIIlII, new BlockPos(llllllllllllllIIIIlIlllIllllIIIl.getX() + llllllllllllllIIIIlIlllIllllIlll, llllllllllllllIIIIlIlllIllllIlIl, llllllllllllllIIIIlIlllIllllIIIl.getZ() + llllllllllllllIIIIlIlllIllllIllI))) {
                    break;
                }
            }
        }
        super.func_180624_a(llllllllllllllIIIIlIlllIllllIIll, llllllllllllllIIIIlIllllIIIIIlII, llllllllllllllIIIIlIlllIllllIIIl);
    }
    
    static {
        __OBFID = "CL_00000170";
        field_150629_aC = new WorldGenForest(false, true);
        field_150630_aD = new WorldGenForest(false, false);
        field_150631_aE = new WorldGenCanopyTree(false);
    }
    
    @Override
    public int func_180627_b(final BlockPos llllllllllllllIIIIlIlllIlllIIIlI) {
        final int llllllllllllllIIIIlIlllIlllIIlII = super.func_180627_b(llllllllllllllIIIIlIlllIlllIIIlI);
        return (this.field_150632_aF == 3) ? ((llllllllllllllIIIIlIlllIlllIIlII & 0xFEFEFE) + 2634762 >> 1) : llllllllllllllIIIIlIlllIlllIIlII;
    }
    
    @Override
    protected BiomeGenBase createMutatedBiome(final int llllllllllllllIIIIlIlllIllIllIIl) {
        if (this.biomeID == BiomeGenBase.forest.biomeID) {
            final BiomeGenForest llllllllllllllIIIIlIlllIllIllIll = new BiomeGenForest(llllllllllllllIIIIlIlllIllIllIIl, 1);
            llllllllllllllIIIIlIlllIllIllIll.setHeight(new Height(this.minHeight, this.maxHeight + 0.2f));
            llllllllllllllIIIIlIlllIllIllIll.setBiomeName("Flower Forest");
            llllllllllllllIIIIlIlllIllIllIll.func_150557_a(6976549, true);
            llllllllllllllIIIIlIlllIllIllIll.setFillerBlockMetadata(8233509);
            return llllllllllllllIIIIlIlllIllIllIll;
        }
        return (this.biomeID != BiomeGenBase.birchForest.biomeID && this.biomeID != BiomeGenBase.birchForestHills.biomeID) ? new BiomeGenMutated(llllllllllllllIIIIlIlllIllIllIIl, this) {
            static {
                __OBFID = "CL_00000172";
            }
            
            @Override
            public void func_180624_a(final World llllllllllllllIlIIIllIllIIllIlIl, final Random llllllllllllllIlIIIllIllIIllIIII, final BlockPos llllllllllllllIlIIIllIllIIlIllll) {
                this.baseBiome.func_180624_a(llllllllllllllIlIIIllIllIIllIlIl, llllllllllllllIlIIIllIllIIllIIII, llllllllllllllIlIIIllIllIIlIllll);
            }
        } : new BiomeGenMutated(llllllllllllllIIIIlIlllIllIllIIl, this) {
            @Override
            public WorldGenAbstractTree genBigTreeChance(final Random lllllllllllllllllIIIllIllIIlIlll) {
                return lllllllllllllllllIIIllIllIIlIlll.nextBoolean() ? BiomeGenForest.field_150629_aC : BiomeGenForest.field_150630_aD;
            }
            
            static {
                __OBFID = "CL_00001861";
            }
        };
    }
    
    @Override
    public WorldGenAbstractTree genBigTreeChance(final Random llllllllllllllIIIIlIllllIIlIIIll) {
        return (this.field_150632_aF == 3 && llllllllllllllIIIIlIllllIIlIIIll.nextInt(3) > 0) ? BiomeGenForest.field_150631_aE : ((this.field_150632_aF != 2 && llllllllllllllIIIIlIllllIIlIIIll.nextInt(5) != 0) ? this.worldGeneratorTrees : BiomeGenForest.field_150630_aD);
    }
    
    public BiomeGenForest(final int llllllllllllllIIIIlIllllIIllIlII, final int llllllllllllllIIIIlIllllIIllIIll) {
        super(llllllllllllllIIIIlIllllIIllIlII);
        this.field_150632_aF = llllllllllllllIIIIlIllllIIllIIll;
        this.theBiomeDecorator.treesPerChunk = 10;
        this.theBiomeDecorator.grassPerChunk = 2;
        if (this.field_150632_aF == 1) {
            this.theBiomeDecorator.treesPerChunk = 6;
            this.theBiomeDecorator.flowersPerChunk = 100;
            this.theBiomeDecorator.grassPerChunk = 1;
        }
        this.setFillerBlockMetadata(5159473);
        this.setTemperatureRainfall(0.7f, 0.8f);
        if (this.field_150632_aF == 2) {
            this.field_150609_ah = 353825;
            this.color = 3175492;
            this.setTemperatureRainfall(0.6f, 0.6f);
        }
        if (this.field_150632_aF == 0) {
            this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 5, 4, 4));
        }
        if (this.field_150632_aF == 3) {
            this.theBiomeDecorator.treesPerChunk = -999;
        }
    }
    
    @Override
    protected BiomeGenBase func_150557_a(final int llllllllllllllIIIIlIllllIIlIlIll, final boolean llllllllllllllIIIIlIllllIIlIIlll) {
        if (this.field_150632_aF == 2) {
            this.field_150609_ah = 353825;
            this.color = llllllllllllllIIIIlIllllIIlIlIll;
            if (llllllllllllllIIIIlIllllIIlIIlll) {
                this.field_150609_ah = (this.field_150609_ah & 0xFEFEFE) >> 1;
            }
            return this;
        }
        return super.func_150557_a(llllllllllllllIIIIlIllllIIlIlIll, llllllllllllllIIIIlIllllIIlIIlll);
    }
}
