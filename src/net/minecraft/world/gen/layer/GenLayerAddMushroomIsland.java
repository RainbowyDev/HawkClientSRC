package net.minecraft.world.gen.layer;

import net.minecraft.world.biome.*;

public class GenLayerAddMushroomIsland extends GenLayer
{
    static {
        __OBFID = "CL_00000552";
    }
    
    @Override
    public int[] getInts(final int lllllllllllllllllllIlIIIllIlIIIl, final int lllllllllllllllllllIlIIIlIlllllI, final int lllllllllllllllllllIlIIIlIllllIl, final int lllllllllllllllllllIlIIIlIllllII) {
        final int lllllllllllllllllllIlIIIllIIllIl = lllllllllllllllllllIlIIIllIlIIIl - 1;
        final int lllllllllllllllllllIlIIIllIIllII = lllllllllllllllllllIlIIIlIlllllI - 1;
        final int lllllllllllllllllllIlIIIllIIlIll = lllllllllllllllllllIlIIIlIllllIl + 2;
        final int lllllllllllllllllllIlIIIllIIlIlI = lllllllllllllllllllIlIIIlIllllII + 2;
        final int[] lllllllllllllllllllIlIIIllIIlIIl = this.parent.getInts(lllllllllllllllllllIlIIIllIIllIl, lllllllllllllllllllIlIIIllIIllII, lllllllllllllllllllIlIIIllIIlIll, lllllllllllllllllllIlIIIllIIlIlI);
        final int[] lllllllllllllllllllIlIIIllIIlIII = IntCache.getIntCache(lllllllllllllllllllIlIIIlIllllIl * lllllllllllllllllllIlIIIlIllllII);
        for (int lllllllllllllllllllIlIIIllIIIlll = 0; lllllllllllllllllllIlIIIllIIIlll < lllllllllllllllllllIlIIIlIllllII; ++lllllllllllllllllllIlIIIllIIIlll) {
            for (int lllllllllllllllllllIlIIIllIIIllI = 0; lllllllllllllllllllIlIIIllIIIllI < lllllllllllllllllllIlIIIlIllllIl; ++lllllllllllllllllllIlIIIllIIIllI) {
                final int lllllllllllllllllllIlIIIllIIIlIl = lllllllllllllllllllIlIIIllIIlIIl[lllllllllllllllllllIlIIIllIIIllI + 0 + (lllllllllllllllllllIlIIIllIIIlll + 0) * lllllllllllllllllllIlIIIllIIlIll];
                final int lllllllllllllllllllIlIIIllIIIlII = lllllllllllllllllllIlIIIllIIlIIl[lllllllllllllllllllIlIIIllIIIllI + 2 + (lllllllllllllllllllIlIIIllIIIlll + 0) * lllllllllllllllllllIlIIIllIIlIll];
                final int lllllllllllllllllllIlIIIllIIIIll = lllllllllllllllllllIlIIIllIIlIIl[lllllllllllllllllllIlIIIllIIIllI + 0 + (lllllllllllllllllllIlIIIllIIIlll + 2) * lllllllllllllllllllIlIIIllIIlIll];
                final int lllllllllllllllllllIlIIIllIIIIlI = lllllllllllllllllllIlIIIllIIlIIl[lllllllllllllllllllIlIIIllIIIllI + 2 + (lllllllllllllllllllIlIIIllIIIlll + 2) * lllllllllllllllllllIlIIIllIIlIll];
                final int lllllllllllllllllllIlIIIllIIIIIl = lllllllllllllllllllIlIIIllIIlIIl[lllllllllllllllllllIlIIIllIIIllI + 1 + (lllllllllllllllllllIlIIIllIIIlll + 1) * lllllllllllllllllllIlIIIllIIlIll];
                this.initChunkSeed(lllllllllllllllllllIlIIIllIIIllI + lllllllllllllllllllIlIIIllIlIIIl, lllllllllllllllllllIlIIIllIIIlll + lllllllllllllllllllIlIIIlIlllllI);
                if (lllllllllllllllllllIlIIIllIIIIIl == 0 && lllllllllllllllllllIlIIIllIIIlIl == 0 && lllllllllllllllllllIlIIIllIIIlII == 0 && lllllllllllllllllllIlIIIllIIIIll == 0 && lllllllllllllllllllIlIIIllIIIIlI == 0 && this.nextInt(100) == 0) {
                    lllllllllllllllllllIlIIIllIIlIII[lllllllllllllllllllIlIIIllIIIllI + lllllllllllllllllllIlIIIllIIIlll * lllllllllllllllllllIlIIIlIllllIl] = BiomeGenBase.mushroomIsland.biomeID;
                }
                else {
                    lllllllllllllllllllIlIIIllIIlIII[lllllllllllllllllllIlIIIllIIIllI + lllllllllllllllllllIlIIIllIIIlll * lllllllllllllllllllIlIIIlIllllIl] = lllllllllllllllllllIlIIIllIIIIIl;
                }
            }
        }
        return lllllllllllllllllllIlIIIllIIlIII;
    }
    
    public GenLayerAddMushroomIsland(final long lllllllllllllllllllIlIIIlllIIllI, final GenLayer lllllllllllllllllllIlIIIlllIlIII) {
        super(lllllllllllllllllllIlIIIlllIIllI);
        this.parent = lllllllllllllllllllIlIIIlllIlIII;
    }
}
