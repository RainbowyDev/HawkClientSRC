package net.minecraft.world.biome;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.world.chunk.*;

public class BiomeGenOcean extends BiomeGenBase
{
    @Override
    public void genTerrainBlocks(final World llllllllllllllIlllIIllIIlllIlllI, final Random llllllllllllllIlllIIllIIlllIllIl, final ChunkPrimer llllllllllllllIlllIIllIIlllIllII, final int llllllllllllllIlllIIllIIlllIlIll, final int llllllllllllllIlllIIllIIlllIlIlI, final double llllllllllllllIlllIIllIIlllIlIIl) {
        super.genTerrainBlocks(llllllllllllllIlllIIllIIlllIlllI, llllllllllllllIlllIIllIIlllIllIl, llllllllllllllIlllIIllIIlllIllII, llllllllllllllIlllIIllIIlllIlIll, llllllllllllllIlllIIllIIlllIlIlI, llllllllllllllIlllIIllIIlllIlIIl);
    }
    
    static {
        __OBFID = "CL_00000179";
    }
    
    @Override
    public TempCategory getTempCategory() {
        return TempCategory.OCEAN;
    }
    
    public BiomeGenOcean(final int llllllllllllllIlllIIllIIlllllIlI) {
        super(llllllllllllllIlllIIllIIlllllIlI);
        this.spawnableCreatureList.clear();
    }
}
