package net.minecraft.world.biome;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.entity.passive.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.chunk.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;

public class BiomeGenSavanna extends BiomeGenBase
{
    private static final /* synthetic */ WorldGenSavannaTree field_150627_aC;
    
    @Override
    public void func_180624_a(final World llllllllllllllllIllIlllllIIIlIlI, final Random llllllllllllllllIllIlllllIIIlIIl, final BlockPos llllllllllllllllIllIlllllIIlIIII) {
        BiomeGenSavanna.field_180280_ag.func_180710_a(BlockDoublePlant.EnumPlantType.GRASS);
        for (int llllllllllllllllIllIlllllIIIllll = 0; llllllllllllllllIllIlllllIIIllll < 7; ++llllllllllllllllIllIlllllIIIllll) {
            final int llllllllllllllllIllIlllllIIIlllI = llllllllllllllllIllIlllllIIIlIIl.nextInt(16) + 8;
            final int llllllllllllllllIllIlllllIIIllIl = llllllllllllllllIllIlllllIIIlIIl.nextInt(16) + 8;
            final int llllllllllllllllIllIlllllIIIllII = llllllllllllllllIllIlllllIIIlIIl.nextInt(llllllllllllllllIllIlllllIIIlIlI.getHorizon(llllllllllllllllIllIlllllIIlIIII.add(llllllllllllllllIllIlllllIIIlllI, 0, llllllllllllllllIllIlllllIIIllIl)).getY() + 32);
            BiomeGenSavanna.field_180280_ag.generate(llllllllllllllllIllIlllllIIIlIlI, llllllllllllllllIllIlllllIIIlIIl, llllllllllllllllIllIlllllIIlIIII.add(llllllllllllllllIllIlllllIIIlllI, llllllllllllllllIllIlllllIIIllII, llllllllllllllllIllIlllllIIIllIl));
        }
        super.func_180624_a(llllllllllllllllIllIlllllIIIlIlI, llllllllllllllllIllIlllllIIIlIIl, llllllllllllllllIllIlllllIIlIIII);
    }
    
    protected BiomeGenSavanna(final int llllllllllllllllIllIlllllIlIllIl) {
        super(llllllllllllllllIllIlllllIlIllIl);
        this.spawnableCreatureList.add(new SpawnListEntry(EntityHorse.class, 1, 2, 6));
        this.theBiomeDecorator.treesPerChunk = 1;
        this.theBiomeDecorator.flowersPerChunk = 4;
        this.theBiomeDecorator.grassPerChunk = 20;
    }
    
    @Override
    public WorldGenAbstractTree genBigTreeChance(final Random llllllllllllllllIllIlllllIlIIlIl) {
        return (llllllllllllllllIllIlllllIlIIlIl.nextInt(5) > 0) ? BiomeGenSavanna.field_150627_aC : this.worldGeneratorTrees;
    }
    
    static {
        __OBFID = "CL_00000182";
        field_150627_aC = new WorldGenSavannaTree(false);
    }
    
    @Override
    protected BiomeGenBase createMutatedBiome(final int llllllllllllllllIllIlllllIIlllIl) {
        final Mutated llllllllllllllllIllIlllllIIlllll = new Mutated(llllllllllllllllIllIlllllIIlllIl, this);
        llllllllllllllllIllIlllllIIlllll.temperature = (this.temperature + 1.0f) * 0.5f;
        llllllllllllllllIllIlllllIIlllll.minHeight = this.minHeight * 0.5f + 0.3f;
        llllllllllllllllIllIlllllIIlllll.maxHeight = this.maxHeight * 0.5f + 1.2f;
        return llllllllllllllllIllIlllllIIlllll;
    }
    
    public static class Mutated extends BiomeGenMutated
    {
        static {
            __OBFID = "CL_00000183";
        }
        
        public Mutated(final int llllllllllllllIllIlIIlIIllIllIIl, final BiomeGenBase llllllllllllllIllIlIIlIIllIllIII) {
            super(llllllllllllllIllIlIIlIIllIllIIl, llllllllllllllIllIlIIlIIllIllIII);
            this.theBiomeDecorator.treesPerChunk = 2;
            this.theBiomeDecorator.flowersPerChunk = 2;
            this.theBiomeDecorator.grassPerChunk = 5;
        }
        
        @Override
        public void func_180624_a(final World llllllllllllllIllIlIIlIIlIlllIIl, final Random llllllllllllllIllIlIIlIIlIlllIII, final BlockPos llllllllllllllIllIlIIlIIlIlllIll) {
            this.theBiomeDecorator.func_180292_a(llllllllllllllIllIlIIlIIlIlllIIl, llllllllllllllIllIlIIlIIlIlllIII, this, llllllllllllllIllIlIIlIIlIlllIll);
        }
        
        @Override
        public void genTerrainBlocks(final World llllllllllllllIllIlIIlIIllIIlIII, final Random llllllllllllllIllIlIIlIIllIIIlll, final ChunkPrimer llllllllllllllIllIlIIlIIllIIIllI, final int llllllllllllllIllIlIIlIIllIIIlIl, final int llllllllllllllIllIlIIlIIllIIIlII, final double llllllllllllllIllIlIIlIIllIIlIlI) {
            this.topBlock = Blocks.grass.getDefaultState();
            this.fillerBlock = Blocks.dirt.getDefaultState();
            if (llllllllllllllIllIlIIlIIllIIlIlI > 1.75) {
                this.topBlock = Blocks.stone.getDefaultState();
                this.fillerBlock = Blocks.stone.getDefaultState();
            }
            else if (llllllllllllllIllIlIIlIIllIIlIlI > -0.5) {
                this.topBlock = Blocks.dirt.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.COARSE_DIRT);
            }
            this.func_180628_b(llllllllllllllIllIlIIlIIllIIlIII, llllllllllllllIllIlIIlIIllIIIlll, llllllllllllllIllIlIIlIIllIIIllI, llllllllllllllIllIlIIlIIllIIIlIl, llllllllllllllIllIlIIlIIllIIIlII, llllllllllllllIllIlIIlIIllIIlIlI);
        }
    }
}
