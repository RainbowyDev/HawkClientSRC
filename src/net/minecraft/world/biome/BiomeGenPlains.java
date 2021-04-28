package net.minecraft.world.biome;

import java.util.*;
import net.minecraft.util.*;
import net.minecraft.entity.passive.*;
import net.minecraft.world.*;
import net.minecraft.block.*;

public class BiomeGenPlains extends BiomeGenBase
{
    protected /* synthetic */ boolean field_150628_aC;
    
    @Override
    public BlockFlower.EnumFlowerType pickRandomFlower(final Random llllllllllllllllIlIIllIlIlIIIlII, final BlockPos llllllllllllllllIlIIllIlIIlllllI) {
        final double llllllllllllllllIlIIllIlIlIIIIlI = BiomeGenPlains.field_180281_af.func_151601_a(llllllllllllllllIlIIllIlIIlllllI.getX() / 200.0, llllllllllllllllIlIIllIlIIlllllI.getZ() / 200.0);
        if (llllllllllllllllIlIIllIlIlIIIIlI < -0.8) {
            final int llllllllllllllllIlIIllIlIlIIIIIl = llllllllllllllllIlIIllIlIlIIIlII.nextInt(4);
            switch (llllllllllllllllIlIIllIlIlIIIIIl) {
                case 0: {
                    return BlockFlower.EnumFlowerType.ORANGE_TULIP;
                }
                case 1: {
                    return BlockFlower.EnumFlowerType.RED_TULIP;
                }
                case 2: {
                    return BlockFlower.EnumFlowerType.PINK_TULIP;
                }
                default: {
                    return BlockFlower.EnumFlowerType.WHITE_TULIP;
                }
            }
        }
        else {
            if (llllllllllllllllIlIIllIlIlIIIlII.nextInt(3) > 0) {
                final int llllllllllllllllIlIIllIlIlIIIIII = llllllllllllllllIlIIllIlIlIIIlII.nextInt(3);
                return (llllllllllllllllIlIIllIlIlIIIIII == 0) ? BlockFlower.EnumFlowerType.POPPY : ((llllllllllllllllIlIIllIlIlIIIIII == 1) ? BlockFlower.EnumFlowerType.HOUSTONIA : BlockFlower.EnumFlowerType.OXEYE_DAISY);
            }
            return BlockFlower.EnumFlowerType.DANDELION;
        }
    }
    
    static {
        __OBFID = "CL_00000180";
    }
    
    protected BiomeGenPlains(final int llllllllllllllllIlIIllIlIlIllIII) {
        super(llllllllllllllllIlIIllIlIlIllIII);
        this.setTemperatureRainfall(0.8f, 0.4f);
        this.setHeight(BiomeGenPlains.height_LowPlains);
        this.spawnableCreatureList.add(new SpawnListEntry(EntityHorse.class, 5, 2, 6));
        this.theBiomeDecorator.treesPerChunk = -999;
        this.theBiomeDecorator.flowersPerChunk = 4;
        this.theBiomeDecorator.grassPerChunk = 10;
    }
    
    @Override
    public void func_180624_a(final World llllllllllllllllIlIIllIIllllllIl, final Random llllllllllllllllIlIIllIIllllllII, final BlockPos llllllllllllllllIlIIllIIlllllIlI) {
        final double llllllllllllllllIlIIllIlIIIIllII = BiomeGenPlains.field_180281_af.func_151601_a((llllllllllllllllIlIIllIIlllllIlI.getX() + 8) / 200.0, (llllllllllllllllIlIIllIIlllllIlI.getZ() + 8) / 200.0);
        if (llllllllllllllllIlIIllIlIIIIllII < -0.8) {
            this.theBiomeDecorator.flowersPerChunk = 15;
            this.theBiomeDecorator.grassPerChunk = 5;
        }
        else {
            this.theBiomeDecorator.flowersPerChunk = 4;
            this.theBiomeDecorator.grassPerChunk = 10;
            BiomeGenPlains.field_180280_ag.func_180710_a(BlockDoublePlant.EnumPlantType.GRASS);
            for (int llllllllllllllllIlIIllIlIIIIlIlI = 0; llllllllllllllllIlIIllIlIIIIlIlI < 7; ++llllllllllllllllIlIIllIlIIIIlIlI) {
                final int llllllllllllllllIlIIllIlIIIIIllI = llllllllllllllllIlIIllIIllllllII.nextInt(16) + 8;
                final int llllllllllllllllIlIIllIlIIIIIIll = llllllllllllllllIlIIllIIllllllII.nextInt(16) + 8;
                final int llllllllllllllllIlIIllIlIIIIIIIl = llllllllllllllllIlIIllIIllllllII.nextInt(llllllllllllllllIlIIllIIllllllIl.getHorizon(llllllllllllllllIlIIllIIlllllIlI.add(llllllllllllllllIlIIllIlIIIIIllI, 0, llllllllllllllllIlIIllIlIIIIIIll)).getY() + 32);
                BiomeGenPlains.field_180280_ag.generate(llllllllllllllllIlIIllIIllllllIl, llllllllllllllllIlIIllIIllllllII, llllllllllllllllIlIIllIIlllllIlI.add(llllllllllllllllIlIIllIlIIIIIllI, llllllllllllllllIlIIllIlIIIIIIIl, llllllllllllllllIlIIllIlIIIIIIll));
            }
        }
        if (this.field_150628_aC) {
            BiomeGenPlains.field_180280_ag.func_180710_a(BlockDoublePlant.EnumPlantType.SUNFLOWER);
            for (int llllllllllllllllIlIIllIlIIIIlIII = 0; llllllllllllllllIlIIllIlIIIIlIII < 10; ++llllllllllllllllIlIIllIlIIIIlIII) {
                final int llllllllllllllllIlIIllIlIIIIIlII = llllllllllllllllIlIIllIIllllllII.nextInt(16) + 8;
                final int llllllllllllllllIlIIllIlIIIIIIlI = llllllllllllllllIlIIllIIllllllII.nextInt(16) + 8;
                final int llllllllllllllllIlIIllIlIIIIIIII = llllllllllllllllIlIIllIIllllllII.nextInt(llllllllllllllllIlIIllIIllllllIl.getHorizon(llllllllllllllllIlIIllIIlllllIlI.add(llllllllllllllllIlIIllIlIIIIIlII, 0, llllllllllllllllIlIIllIlIIIIIIlI)).getY() + 32);
                BiomeGenPlains.field_180280_ag.generate(llllllllllllllllIlIIllIIllllllIl, llllllllllllllllIlIIllIIllllllII, llllllllllllllllIlIIllIIlllllIlI.add(llllllllllllllllIlIIllIlIIIIIlII, llllllllllllllllIlIIllIlIIIIIIII, llllllllllllllllIlIIllIlIIIIIIlI));
            }
        }
        super.func_180624_a(llllllllllllllllIlIIllIIllllllIl, llllllllllllllllIlIIllIIllllllII, llllllllllllllllIlIIllIIlllllIlI);
    }
    
    @Override
    protected BiomeGenBase createMutatedBiome(final int llllllllllllllllIlIIllIIlllIIllI) {
        final BiomeGenPlains llllllllllllllllIlIIllIIlllIIlIl = new BiomeGenPlains(llllllllllllllllIlIIllIIlllIIllI);
        llllllllllllllllIlIIllIIlllIIlIl.setBiomeName("Sunflower Plains");
        llllllllllllllllIlIIllIIlllIIlIl.field_150628_aC = true;
        llllllllllllllllIlIIllIIlllIIlIl.setColor(9286496);
        llllllllllllllllIlIIllIIlllIIlIl.field_150609_ah = 14273354;
        return llllllllllllllllIlIIllIIlllIIlIl;
    }
}
