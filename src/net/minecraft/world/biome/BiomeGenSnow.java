package net.minecraft.world.biome;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.world.gen.feature.*;

public class BiomeGenSnow extends BiomeGenBase
{
    private /* synthetic */ boolean field_150615_aC;
    private /* synthetic */ WorldGenIceSpike field_150616_aD;
    private /* synthetic */ WorldGenIcePath field_150617_aE;
    
    @Override
    public void func_180624_a(final World llllllllllllllIIlIIlIIllIllllIII, final Random llllllllllllllIIlIIlIIlllIIIlIII, final BlockPos llllllllllllllIIlIIlIIllIlllIlII) {
        if (this.field_150615_aC) {
            for (int llllllllllllllIIlIIlIIlllIIIIlII = 0; llllllllllllllIIlIIlIIlllIIIIlII < 3; ++llllllllllllllIIlIIlIIlllIIIIlII) {
                final int llllllllllllllIIlIIlIIlllIIIIIlI = llllllllllllllIIlIIlIIlllIIIlIII.nextInt(16) + 8;
                final int llllllllllllllIIlIIlIIllIllllllI = llllllllllllllIIlIIlIIlllIIIlIII.nextInt(16) + 8;
                this.field_150616_aD.generate(llllllllllllllIIlIIlIIllIllllIII, llllllllllllllIIlIIlIIlllIIIlIII, llllllllllllllIIlIIlIIllIllllIII.getHorizon(llllllllllllllIIlIIlIIllIlllIlII.add(llllllllllllllIIlIIlIIlllIIIIIlI, 0, llllllllllllllIIlIIlIIllIllllllI)));
            }
            for (int llllllllllllllIIlIIlIIlllIIIIlII = 0; llllllllllllllIIlIIlIIlllIIIIlII < 2; ++llllllllllllllIIlIIlIIlllIIIIlII) {
                final int llllllllllllllIIlIIlIIlllIIIIIII = llllllllllllllIIlIIlIIlllIIIlIII.nextInt(16) + 8;
                final int llllllllllllllIIlIIlIIllIlllllII = llllllllllllllIIlIIlIIlllIIIlIII.nextInt(16) + 8;
                this.field_150617_aE.generate(llllllllllllllIIlIIlIIllIllllIII, llllllllllllllIIlIIlIIlllIIIlIII, llllllllllllllIIlIIlIIllIllllIII.getHorizon(llllllllllllllIIlIIlIIllIlllIlII.add(llllllllllllllIIlIIlIIlllIIIIIII, 0, llllllllllllllIIlIIlIIllIlllllII)));
            }
        }
        super.func_180624_a(llllllllllllllIIlIIlIIllIllllIII, llllllllllllllIIlIIlIIlllIIIlIII, llllllllllllllIIlIIlIIllIlllIlII);
    }
    
    public BiomeGenSnow(final int llllllllllllllIIlIIlIIlllIlIIIlI, final boolean llllllllllllllIIlIIlIIlllIlIIIII) {
        super(llllllllllllllIIlIIlIIlllIlIIIlI);
        this.field_150616_aD = new WorldGenIceSpike();
        this.field_150617_aE = new WorldGenIcePath(4);
        this.field_150615_aC = llllllllllllllIIlIIlIIlllIlIIIII;
        if (llllllllllllllIIlIIlIIlllIlIIIII) {
            this.topBlock = Blocks.snow.getDefaultState();
        }
        this.spawnableCreatureList.clear();
    }
    
    static {
        __OBFID = "CL_00000174";
    }
    
    @Override
    public WorldGenAbstractTree genBigTreeChance(final Random llllllllllllllIIlIIlIIllIllIlllI) {
        return new WorldGenTaiga2(false);
    }
    
    @Override
    protected BiomeGenBase createMutatedBiome(final int llllllllllllllIIlIIlIIllIllIIIIl) {
        final BiomeGenBase llllllllllllllIIlIIlIIllIlIlllll = new BiomeGenSnow(llllllllllllllIIlIIlIIllIllIIIIl, true).func_150557_a(13828095, true).setBiomeName(String.valueOf(new StringBuilder(String.valueOf(this.biomeName)).append(" Spikes"))).setEnableSnow().setTemperatureRainfall(0.0f, 0.5f).setHeight(new Height(this.minHeight + 0.1f, this.maxHeight + 0.1f));
        llllllllllllllIIlIIlIIllIlIlllll.minHeight = this.minHeight + 0.3f;
        llllllllllllllIIlIIlIIllIlIlllll.maxHeight = this.maxHeight + 0.4f;
        return llllllllllllllIIlIIlIIllIlIlllll;
    }
}
