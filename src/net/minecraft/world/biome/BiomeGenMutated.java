package net.minecraft.world.biome;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.*;
import com.google.common.collect.*;
import net.minecraft.world.chunk.*;
import net.minecraft.world.gen.feature.*;

public class BiomeGenMutated extends BiomeGenBase
{
    protected /* synthetic */ BiomeGenBase baseBiome;
    
    @Override
    public void func_180624_a(final World lIIIlllIllIllI, final Random lIIIlllIllIlIl, final BlockPos lIIIlllIlllIII) {
        this.baseBiome.theBiomeDecorator.func_180292_a(lIIIlllIllIllI, lIIIlllIllIlIl, this, lIIIlllIlllIII);
    }
    
    @Override
    public TempCategory getTempCategory() {
        return this.baseBiome.getTempCategory();
    }
    
    @Override
    public Class getBiomeClass() {
        return this.baseBiome.getBiomeClass();
    }
    
    @Override
    public boolean isEqualTo(final BiomeGenBase lIIIlllIIIIIIl) {
        return this.baseBiome.isEqualTo(lIIIlllIIIIIIl);
    }
    
    @Override
    public int func_180625_c(final BlockPos lIIIlllIIlIIlI) {
        return this.baseBiome.func_180625_c(lIIIlllIIlIIlI);
    }
    
    static {
        __OBFID = "CL_00000178";
    }
    
    public BiomeGenMutated(final int lIIIllllIIIlII, final BiomeGenBase lIIIllllIIIIll) {
        super(lIIIllllIIIlII);
        this.baseBiome = lIIIllllIIIIll;
        this.func_150557_a(lIIIllllIIIIll.color, true);
        this.biomeName = String.valueOf(new StringBuilder(String.valueOf(lIIIllllIIIIll.biomeName)).append(" M"));
        this.topBlock = lIIIllllIIIIll.topBlock;
        this.fillerBlock = lIIIllllIIIIll.fillerBlock;
        this.fillerBlockMetadata = lIIIllllIIIIll.fillerBlockMetadata;
        this.minHeight = lIIIllllIIIIll.minHeight;
        this.maxHeight = lIIIllllIIIIll.maxHeight;
        this.temperature = lIIIllllIIIIll.temperature;
        this.rainfall = lIIIllllIIIIll.rainfall;
        this.waterColorMultiplier = lIIIllllIIIIll.waterColorMultiplier;
        this.enableSnow = lIIIllllIIIIll.enableSnow;
        this.enableRain = lIIIllllIIIIll.enableRain;
        this.spawnableCreatureList = Lists.newArrayList((Iterable)lIIIllllIIIIll.spawnableCreatureList);
        this.spawnableMonsterList = Lists.newArrayList((Iterable)lIIIllllIIIIll.spawnableMonsterList);
        this.spawnableCaveCreatureList = Lists.newArrayList((Iterable)lIIIllllIIIIll.spawnableCaveCreatureList);
        this.spawnableWaterCreatureList = Lists.newArrayList((Iterable)lIIIllllIIIIll.spawnableWaterCreatureList);
        this.temperature = lIIIllllIIIIll.temperature;
        this.rainfall = lIIIllllIIIIll.rainfall;
        this.minHeight = lIIIllllIIIIll.minHeight + 0.1f;
        this.maxHeight = lIIIllllIIIIll.maxHeight + 0.2f;
    }
    
    @Override
    public int func_180627_b(final BlockPos lIIIlllIIIllII) {
        return this.baseBiome.func_180627_b(lIIIlllIIIllII);
    }
    
    @Override
    public void genTerrainBlocks(final World lIIIlllIlIIlII, final Random lIIIlllIlIlIlI, final ChunkPrimer lIIIlllIlIIIlI, final int lIIIlllIlIlIII, final int lIIIlllIlIIIII, final double lIIIlllIlIIllI) {
        this.baseBiome.genTerrainBlocks(lIIIlllIlIIlII, lIIIlllIlIlIlI, lIIIlllIlIIIlI, lIIIlllIlIlIII, lIIIlllIlIIIII, lIIIlllIlIIllI);
    }
    
    @Override
    public float getSpawningChance() {
        return this.baseBiome.getSpawningChance();
    }
    
    @Override
    public WorldGenAbstractTree genBigTreeChance(final Random lIIIlllIIllIII) {
        return this.baseBiome.genBigTreeChance(lIIIlllIIllIII);
    }
}
