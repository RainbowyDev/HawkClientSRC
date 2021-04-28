package net.minecraft.world.biome;

import net.minecraft.util.*;
import java.util.*;

public class WorldChunkManagerHell extends WorldChunkManager
{
    private /* synthetic */ BiomeGenBase biomeGenerator;
    private /* synthetic */ float rainfall;
    
    @Override
    public BiomeGenBase[] getBiomesForGeneration(BiomeGenBase[] llllllllllllllIlIlIlllllIIIIIlll, final int llllllllllllllIlIlIlllllIIIIllII, final int llllllllllllllIlIlIlllllIIIIlIll, final int llllllllllllllIlIlIlllllIIIIlIlI, final int llllllllllllllIlIlIlllllIIIIlIIl) {
        if (llllllllllllllIlIlIlllllIIIIIlll == null || llllllllllllllIlIlIlllllIIIIIlll.length < llllllllllllllIlIlIlllllIIIIlIlI * llllllllllllllIlIlIlllllIIIIlIIl) {
            llllllllllllllIlIlIlllllIIIIIlll = new BiomeGenBase[llllllllllllllIlIlIlllllIIIIlIlI * llllllllllllllIlIlIlllllIIIIlIIl];
        }
        Arrays.fill(llllllllllllllIlIlIlllllIIIIIlll, 0, llllllllllllllIlIlIlllllIIIIlIlI * llllllllllllllIlIlIlllllIIIIlIIl, this.biomeGenerator);
        return llllllllllllllIlIlIlllllIIIIIlll;
    }
    
    @Override
    public float[] getRainfall(float[] llllllllllllllIlIlIllllIlllllIIl, final int llllllllllllllIlIlIllllIlllllllI, final int llllllllllllllIlIlIllllIllllllIl, final int llllllllllllllIlIlIllllIllllllII, final int llllllllllllllIlIlIllllIlllllIll) {
        if (llllllllllllllIlIlIllllIlllllIIl == null || llllllllllllllIlIlIllllIlllllIIl.length < llllllllllllllIlIlIllllIllllllII * llllllllllllllIlIlIllllIlllllIll) {
            llllllllllllllIlIlIllllIlllllIIl = new float[llllllllllllllIlIlIllllIllllllII * llllllllllllllIlIlIllllIlllllIll];
        }
        Arrays.fill(llllllllllllllIlIlIllllIlllllIIl, 0, llllllllllllllIlIlIllllIllllllII * llllllllllllllIlIlIllllIlllllIll, this.rainfall);
        return llllllllllllllIlIlIllllIlllllIIl;
    }
    
    static {
        __OBFID = "CL_00000169";
    }
    
    public WorldChunkManagerHell(final BiomeGenBase llllllllllllllIlIlIlllllIIIllIII, final float llllllllllllllIlIlIlllllIIIlIlll) {
        this.biomeGenerator = llllllllllllllIlIlIlllllIIIllIII;
        this.rainfall = llllllllllllllIlIlIlllllIIIlIlll;
    }
    
    @Override
    public boolean areBiomesViable(final int llllllllllllllIlIlIllllIllIIIIII, final int llllllllllllllIlIlIllllIlIllllll, final int llllllllllllllIlIlIllllIlIlllllI, final List llllllllllllllIlIlIllllIlIlllIll) {
        return llllllllllllllIlIlIllllIlIlllIll.contains(this.biomeGenerator);
    }
    
    @Override
    public BiomeGenBase[] loadBlockGeneratorData(BiomeGenBase[] llllllllllllllIlIlIllllIlllIlIll, final int llllllllllllllIlIlIllllIllllIIII, final int llllllllllllllIlIlIllllIlllIllll, final int llllllllllllllIlIlIllllIlllIlIlI, final int llllllllllllllIlIlIllllIlllIlIIl) {
        if (llllllllllllllIlIlIllllIlllIlIll == null || llllllllllllllIlIlIllllIlllIlIll.length < llllllllllllllIlIlIllllIlllIlIlI * llllllllllllllIlIlIllllIlllIlIIl) {
            llllllllllllllIlIlIllllIlllIlIll = new BiomeGenBase[llllllllllllllIlIlIllllIlllIlIlI * llllllllllllllIlIlIllllIlllIlIIl];
        }
        Arrays.fill((Object[])llllllllllllllIlIlIllllIlllIlIll, 0, llllllllllllllIlIlIllllIlllIlIlI * llllllllllllllIlIlIllllIlllIlIIl, this.biomeGenerator);
        return (BiomeGenBase[])llllllllllllllIlIlIllllIlllIlIll;
    }
    
    @Override
    public BiomeGenBase func_180631_a(final BlockPos llllllllllllllIlIlIlllllIIIlIlII) {
        return this.biomeGenerator;
    }
    
    @Override
    public BlockPos findBiomePosition(final int llllllllllllllIlIlIllllIllIIlllI, final int llllllllllllllIlIlIllllIllIIIlll, final int llllllllllllllIlIlIllllIllIIIllI, final List llllllllllllllIlIlIllllIllIIlIll, final Random llllllllllllllIlIlIllllIllIIIlII) {
        return llllllllllllllIlIlIllllIllIIlIll.contains(this.biomeGenerator) ? new BlockPos(llllllllllllllIlIlIllllIllIIlllI - llllllllllllllIlIlIllllIllIIIllI + llllllllllllllIlIlIllllIllIIIlII.nextInt(llllllllllllllIlIlIllllIllIIIllI * 2 + 1), 0, llllllllllllllIlIlIllllIllIIIlll - llllllllllllllIlIlIllllIllIIIllI + llllllllllllllIlIlIllllIllIIIlII.nextInt(llllllllllllllIlIlIllllIllIIIllI * 2 + 1)) : null;
    }
    
    @Override
    public BiomeGenBase[] getBiomeGenAt(final BiomeGenBase[] llllllllllllllIlIlIllllIlllIIIIl, final int llllllllllllllIlIlIllllIllIllIIl, final int llllllllllllllIlIlIllllIllIllIII, final int llllllllllllllIlIlIllllIllIllllI, final int llllllllllllllIlIlIllllIllIlIllI, final boolean llllllllllllllIlIlIllllIllIlllII) {
        return this.loadBlockGeneratorData(llllllllllllllIlIlIllllIlllIIIIl, llllllllllllllIlIlIllllIllIllIIl, llllllllllllllIlIlIllllIllIllIII, llllllllllllllIlIlIllllIllIllllI, llllllllllllllIlIlIllllIllIlIllI);
    }
}
