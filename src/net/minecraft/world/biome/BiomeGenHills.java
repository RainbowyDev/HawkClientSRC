package net.minecraft.world.biome;

import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.world.chunk.*;
import net.minecraft.world.gen.feature.*;

public class BiomeGenHills extends BiomeGenBase
{
    private /* synthetic */ WorldGenTaiga2 field_150634_aD;
    private /* synthetic */ WorldGenerator theWorldGenerator;
    private /* synthetic */ int field_150637_aG;
    private /* synthetic */ int field_150638_aH;
    private /* synthetic */ int field_150636_aF;
    private /* synthetic */ int field_150635_aE;
    
    private BiomeGenHills mutateHills(final BiomeGenBase llllllllllllllIIIllIlIlllIIIIlll) {
        this.field_150638_aH = this.field_150637_aG;
        this.func_150557_a(llllllllllllllIIIllIlIlllIIIIlll.color, true);
        this.setBiomeName(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIllIlIlllIIIIlll.biomeName)).append(" M")));
        this.setHeight(new Height(llllllllllllllIIIllIlIlllIIIIlll.minHeight, llllllllllllllIIIllIlIlllIIIIlll.maxHeight));
        this.setTemperatureRainfall(llllllllllllllIIIllIlIlllIIIIlll.temperature, llllllllllllllIIIllIlIlllIIIIlll.rainfall);
        return this;
    }
    
    protected BiomeGenHills(final int llllllllllllllIIIllIlIllllIIlIIl, final boolean llllllllllllllIIIllIlIllllIIlIII) {
        super(llllllllllllllIIIllIlIllllIIlIIl);
        this.theWorldGenerator = new WorldGenMinable(Blocks.monster_egg.getDefaultState().withProperty(BlockSilverfish.VARIANT_PROP, BlockSilverfish.EnumType.STONE), 9);
        this.field_150634_aD = new WorldGenTaiga2(false);
        this.field_150635_aE = 0;
        this.field_150636_aF = 1;
        this.field_150637_aG = 2;
        this.field_150638_aH = this.field_150635_aE;
        if (llllllllllllllIIIllIlIllllIIlIII) {
            this.theBiomeDecorator.treesPerChunk = 3;
            this.field_150638_aH = this.field_150636_aF;
        }
    }
    
    @Override
    public void func_180624_a(final World llllllllllllllIIIllIlIlllIlIlIlI, final Random llllllllllllllIIIllIlIlllIlIlIIl, final BlockPos llllllllllllllIIIllIlIlllIlIlIII) {
        super.func_180624_a(llllllllllllllIIIllIlIlllIlIlIlI, llllllllllllllIIIllIlIlllIlIlIIl, llllllllllllllIIIllIlIlllIlIlIII);
        for (int llllllllllllllIIIllIlIlllIllIIll = 3 + llllllllllllllIIIllIlIlllIlIlIIl.nextInt(6), llllllllllllllIIIllIlIlllIllIIlI = 0; llllllllllllllIIIllIlIlllIllIIlI < llllllllllllllIIIllIlIlllIllIIll; ++llllllllllllllIIIllIlIlllIllIIlI) {
            final int llllllllllllllIIIllIlIlllIllIIIl = llllllllllllllIIIllIlIlllIlIlIIl.nextInt(16);
            final int llllllllllllllIIIllIlIlllIlIllll = llllllllllllllIIIllIlIlllIlIlIIl.nextInt(28) + 4;
            final int llllllllllllllIIIllIlIlllIlIllIl = llllllllllllllIIIllIlIlllIlIlIIl.nextInt(16);
            final BlockPos llllllllllllllIIIllIlIlllIlIllII = llllllllllllllIIIllIlIlllIlIlIII.add(llllllllllllllIIIllIlIlllIllIIIl, llllllllllllllIIIllIlIlllIlIllll, llllllllllllllIIIllIlIlllIlIllIl);
            if (llllllllllllllIIIllIlIlllIlIlIlI.getBlockState(llllllllllllllIIIllIlIlllIlIllII).getBlock() == Blocks.stone) {
                llllllllllllllIIIllIlIlllIlIlIlI.setBlockState(llllllllllllllIIIllIlIlllIlIllII, Blocks.emerald_ore.getDefaultState(), 2);
            }
        }
        for (int llllllllllllllIIIllIlIlllIllIIll = 0; llllllllllllllIIIllIlIlllIllIIll < 7; ++llllllllllllllIIIllIlIlllIllIIll) {
            final int llllllllllllllIIIllIlIlllIllIIlI = llllllllllllllIIIllIlIlllIlIlIIl.nextInt(16);
            final int llllllllllllllIIIllIlIlllIllIIII = llllllllllllllIIIllIlIlllIlIlIIl.nextInt(64);
            final int llllllllllllllIIIllIlIlllIlIlllI = llllllllllllllIIIllIlIlllIlIlIIl.nextInt(16);
            this.theWorldGenerator.generate(llllllllllllllIIIllIlIlllIlIlIlI, llllllllllllllIIIllIlIlllIlIlIIl, llllllllllllllIIIllIlIlllIlIlIII.add(llllllllllllllIIIllIlIlllIllIIlI, llllllllllllllIIIllIlIlllIllIIII, llllllllllllllIIIllIlIlllIlIlllI));
        }
    }
    
    @Override
    protected BiomeGenBase createMutatedBiome(final int llllllllllllllIIIllIlIlllIIIIIIl) {
        return new BiomeGenHills(llllllllllllllIIIllIlIlllIIIIIIl, false).mutateHills(this);
    }
    
    static {
        __OBFID = "CL_00000168";
    }
    
    @Override
    public void genTerrainBlocks(final World llllllllllllllIIIllIlIlllIIlIIlI, final Random llllllllllllllIIIllIlIlllIIllIII, final ChunkPrimer llllllllllllllIIIllIlIlllIIlIIII, final int llllllllllllllIIIllIlIlllIIIllll, final int llllllllllllllIIIllIlIlllIIIlllI, final double llllllllllllllIIIllIlIlllIIIllIl) {
        this.topBlock = Blocks.grass.getDefaultState();
        this.fillerBlock = Blocks.dirt.getDefaultState();
        if ((llllllllllllllIIIllIlIlllIIIllIl < -1.0 || llllllllllllllIIIllIlIlllIIIllIl > 2.0) && this.field_150638_aH == this.field_150637_aG) {
            this.topBlock = Blocks.gravel.getDefaultState();
            this.fillerBlock = Blocks.gravel.getDefaultState();
        }
        else if (llllllllllllllIIIllIlIlllIIIllIl > 1.0 && this.field_150638_aH != this.field_150636_aF) {
            this.topBlock = Blocks.stone.getDefaultState();
            this.fillerBlock = Blocks.stone.getDefaultState();
        }
        this.func_180628_b(llllllllllllllIIIllIlIlllIIlIIlI, llllllllllllllIIIllIlIlllIIllIII, llllllllllllllIIIllIlIlllIIlIIII, llllllllllllllIIIllIlIlllIIIllll, llllllllllllllIIIllIlIlllIIIlllI, llllllllllllllIIIllIlIlllIIIllIl);
    }
    
    @Override
    public WorldGenAbstractTree genBigTreeChance(final Random llllllllllllllIIIllIlIllllIIIIlI) {
        return (llllllllllllllIIIllIlIllllIIIIlI.nextInt(3) > 0) ? this.field_150634_aD : super.genBigTreeChance(llllllllllllllIIIllIlIllllIIIIlI);
    }
}
