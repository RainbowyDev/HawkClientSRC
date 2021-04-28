package net.minecraft.world.gen.layer;

import net.minecraft.world.biome.*;

public class GenLayerRareBiome extends GenLayer
{
    static {
        __OBFID = "CL_00000562";
    }
    
    public GenLayerRareBiome(final long llllllllllllllIllIlllllllllIlIll, final GenLayer llllllllllllllIllIlllllllllIlIlI) {
        super(llllllllllllllIllIlllllllllIlIll);
        this.parent = llllllllllllllIllIlllllllllIlIlI;
    }
    
    @Override
    public int[] getInts(final int llllllllllllllIllIllllllllIllllI, final int llllllllllllllIllIllllllllIlIIll, final int llllllllllllllIllIllllllllIlllII, final int llllllllllllllIllIllllllllIllIll) {
        final int[] llllllllllllllIllIllllllllIllIlI = this.parent.getInts(llllllllllllllIllIllllllllIllllI - 1, llllllllllllllIllIllllllllIlIIll - 1, llllllllllllllIllIllllllllIlllII + 2, llllllllllllllIllIllllllllIllIll + 2);
        final int[] llllllllllllllIllIllllllllIllIIl = IntCache.getIntCache(llllllllllllllIllIllllllllIlllII * llllllllllllllIllIllllllllIllIll);
        for (int llllllllllllllIllIllllllllIllIII = 0; llllllllllllllIllIllllllllIllIII < llllllllllllllIllIllllllllIllIll; ++llllllllllllllIllIllllllllIllIII) {
            for (int llllllllllllllIllIllllllllIlIlll = 0; llllllllllllllIllIllllllllIlIlll < llllllllllllllIllIllllllllIlllII; ++llllllllllllllIllIllllllllIlIlll) {
                this.initChunkSeed(llllllllllllllIllIllllllllIlIlll + llllllllllllllIllIllllllllIllllI, llllllllllllllIllIllllllllIllIII + llllllllllllllIllIllllllllIlIIll);
                final int llllllllllllllIllIllllllllIlIllI = llllllllllllllIllIllllllllIllIlI[llllllllllllllIllIllllllllIlIlll + 1 + (llllllllllllllIllIllllllllIllIII + 1) * (llllllllllllllIllIllllllllIlllII + 2)];
                if (this.nextInt(57) == 0) {
                    if (llllllllllllllIllIllllllllIlIllI == BiomeGenBase.plains.biomeID) {
                        llllllllllllllIllIllllllllIllIIl[llllllllllllllIllIllllllllIlIlll + llllllllllllllIllIllllllllIllIII * llllllllllllllIllIllllllllIlllII] = BiomeGenBase.plains.biomeID + 128;
                    }
                    else {
                        llllllllllllllIllIllllllllIllIIl[llllllllllllllIllIllllllllIlIlll + llllllllllllllIllIllllllllIllIII * llllllllllllllIllIllllllllIlllII] = llllllllllllllIllIllllllllIlIllI;
                    }
                }
                else {
                    llllllllllllllIllIllllllllIllIIl[llllllllllllllIllIllllllllIlIlll + llllllllllllllIllIllllllllIllIII * llllllllllllllIllIllllllllIlllII] = llllllllllllllIllIllllllllIlIllI;
                }
            }
        }
        return llllllllllllllIllIllllllllIllIIl;
    }
}
