package net.minecraft.world.biome;

import net.minecraft.init.*;
import java.util.*;
import net.minecraft.entity.passive.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.chunk.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;

public class BiomeGenTaiga extends BiomeGenBase
{
    private static final /* synthetic */ WorldGenMegaPineTree field_150641_aE;
    private static final /* synthetic */ WorldGenTaiga2 field_150640_aD;
    private static final /* synthetic */ WorldGenBlockBlob field_150643_aG;
    private /* synthetic */ int field_150644_aH;
    private static final /* synthetic */ WorldGenTaiga1 field_150639_aC;
    private static final /* synthetic */ WorldGenMegaPineTree field_150642_aF;
    
    static {
        __OBFID = "CL_00000186";
        field_150639_aC = new WorldGenTaiga1();
        field_150640_aD = new WorldGenTaiga2(false);
        field_150641_aE = new WorldGenMegaPineTree(false, false);
        field_150642_aF = new WorldGenMegaPineTree(false, true);
        field_150643_aG = new WorldGenBlockBlob(Blocks.mossy_cobblestone, 0);
    }
    
    @Override
    public WorldGenAbstractTree genBigTreeChance(final Random llllllllllllllIllIIIIIIIIlIlllll) {
        return ((this.field_150644_aH == 1 || this.field_150644_aH == 2) && llllllllllllllIllIIIIIIIIlIlllll.nextInt(3) == 0) ? ((this.field_150644_aH != 2 && llllllllllllllIllIIIIIIIIlIlllll.nextInt(13) != 0) ? BiomeGenTaiga.field_150641_aE : BiomeGenTaiga.field_150642_aF) : ((llllllllllllllIllIIIIIIIIlIlllll.nextInt(3) == 0) ? BiomeGenTaiga.field_150639_aC : BiomeGenTaiga.field_150640_aD);
    }
    
    public BiomeGenTaiga(final int llllllllllllllIllIIIIIIIIllIlIIl, final int llllllllllllllIllIIIIIIIIllIlIII) {
        super(llllllllllllllIllIIIIIIIIllIlIIl);
        this.field_150644_aH = llllllllllllllIllIIIIIIIIllIlIII;
        this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 8, 4, 4));
        this.theBiomeDecorator.treesPerChunk = 10;
        if (llllllllllllllIllIIIIIIIIllIlIII != 1 && llllllllllllllIllIIIIIIIIllIlIII != 2) {
            this.theBiomeDecorator.grassPerChunk = 1;
            this.theBiomeDecorator.mushroomsPerChunk = 1;
        }
        else {
            this.theBiomeDecorator.grassPerChunk = 7;
            this.theBiomeDecorator.deadBushPerChunk = 1;
            this.theBiomeDecorator.mushroomsPerChunk = 3;
        }
    }
    
    @Override
    public void func_180624_a(final World llllllllllllllIllIIIIIIIIlIlIIII, final Random llllllllllllllIllIIIIIIIIlIIllll, final BlockPos llllllllllllllIllIIIIIIIIlIIlllI) {
        if (this.field_150644_aH == 1 || this.field_150644_aH == 2) {
            for (int llllllllllllllIllIIIIIIIIlIIllIl = llllllllllllllIllIIIIIIIIlIIllll.nextInt(3), llllllllllllllIllIIIIIIIIlIIlIll = 0; llllllllllllllIllIIIIIIIIlIIlIll < llllllllllllllIllIIIIIIIIlIIllIl; ++llllllllllllllIllIIIIIIIIlIIlIll) {
                final int llllllllllllllIllIIIIIIIIlIIlIIl = llllllllllllllIllIIIIIIIIlIIllll.nextInt(16) + 8;
                final int llllllllllllllIllIIIIIIIIlIIIlll = llllllllllllllIllIIIIIIIIlIIllll.nextInt(16) + 8;
                final BlockPos llllllllllllllIllIIIIIIIIlIIIlIl = llllllllllllllIllIIIIIIIIlIlIIII.getHorizon(llllllllllllllIllIIIIIIIIlIIlllI.add(llllllllllllllIllIIIIIIIIlIIlIIl, 0, llllllllllllllIllIIIIIIIIlIIIlll));
                BiomeGenTaiga.field_150643_aG.generate(llllllllllllllIllIIIIIIIIlIlIIII, llllllllllllllIllIIIIIIIIlIIllll, llllllllllllllIllIIIIIIIIlIIIlIl);
            }
        }
        BiomeGenTaiga.field_180280_ag.func_180710_a(BlockDoublePlant.EnumPlantType.FERN);
        for (int llllllllllllllIllIIIIIIIIlIIllII = 0; llllllllllllllIllIIIIIIIIlIIllII < 7; ++llllllllllllllIllIIIIIIIIlIIllII) {
            final int llllllllllllllIllIIIIIIIIlIIlIlI = llllllllllllllIllIIIIIIIIlIIllll.nextInt(16) + 8;
            final int llllllllllllllIllIIIIIIIIlIIlIII = llllllllllllllIllIIIIIIIIlIIllll.nextInt(16) + 8;
            final int llllllllllllllIllIIIIIIIIlIIIllI = llllllllllllllIllIIIIIIIIlIIllll.nextInt(llllllllllllllIllIIIIIIIIlIlIIII.getHorizon(llllllllllllllIllIIIIIIIIlIIlllI.add(llllllllllllllIllIIIIIIIIlIIlIlI, 0, llllllllllllllIllIIIIIIIIlIIlIII)).getY() + 32);
            BiomeGenTaiga.field_180280_ag.generate(llllllllllllllIllIIIIIIIIlIlIIII, llllllllllllllIllIIIIIIIIlIIllll, llllllllllllllIllIIIIIIIIlIIlllI.add(llllllllllllllIllIIIIIIIIlIIlIlI, llllllllllllllIllIIIIIIIIlIIIllI, llllllllllllllIllIIIIIIIIlIIlIII));
        }
        super.func_180624_a(llllllllllllllIllIIIIIIIIlIlIIII, llllllllllllllIllIIIIIIIIlIIllll, llllllllllllllIllIIIIIIIIlIIlllI);
    }
    
    @Override
    public WorldGenerator getRandomWorldGenForGrass(final Random llllllllllllllIllIIIIIIIIlIllIll) {
        return (llllllllllllllIllIIIIIIIIlIllIll.nextInt(5) > 0) ? new WorldGenTallGrass(BlockTallGrass.EnumType.FERN) : new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);
    }
    
    @Override
    public void genTerrainBlocks(final World llllllllllllllIllIIIIIIIIIllIIll, final Random llllllllllllllIllIIIIIIIIIlIlIll, final ChunkPrimer llllllllllllllIllIIIIIIIIIlIlIlI, final int llllllllllllllIllIIIIIIIIIllIIII, final int llllllllllllllIllIIIIIIIIIlIllll, final double llllllllllllllIllIIIIIIIIIlIlllI) {
        if (this.field_150644_aH == 1 || this.field_150644_aH == 2) {
            this.topBlock = Blocks.grass.getDefaultState();
            this.fillerBlock = Blocks.dirt.getDefaultState();
            if (llllllllllllllIllIIIIIIIIIlIlllI > 1.75) {
                this.topBlock = Blocks.dirt.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.COARSE_DIRT);
            }
            else if (llllllllllllllIllIIIIIIIIIlIlllI > -0.95) {
                this.topBlock = Blocks.dirt.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.PODZOL);
            }
        }
        this.func_180628_b(llllllllllllllIllIIIIIIIIIllIIll, llllllllllllllIllIIIIIIIIIlIlIll, llllllllllllllIllIIIIIIIIIlIlIlI, llllllllllllllIllIIIIIIIIIllIIII, llllllllllllllIllIIIIIIIIIlIllll, llllllllllllllIllIIIIIIIIIlIlllI);
    }
    
    @Override
    protected BiomeGenBase createMutatedBiome(final int llllllllllllllIllIIIIIIIIIlIIIll) {
        return (this.biomeID == BiomeGenBase.megaTaiga.biomeID) ? new BiomeGenTaiga(llllllllllllllIllIIIIIIIIIlIIIll, 2).func_150557_a(5858897, true).setBiomeName("Mega Spruce Taiga").setFillerBlockMetadata(5159473).setTemperatureRainfall(0.25f, 0.8f).setHeight(new Height(this.minHeight, this.maxHeight)) : super.createMutatedBiome(llllllllllllllIllIIIIIIIIIlIIIll);
    }
}
