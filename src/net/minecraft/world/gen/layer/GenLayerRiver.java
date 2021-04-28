package net.minecraft.world.gen.layer;

import net.minecraft.world.biome.*;

public class GenLayerRiver extends GenLayer
{
    static {
        __OBFID = "CL_00000566";
    }
    
    public GenLayerRiver(final long lIIIlIlIIllllIl, final GenLayer lIIIlIlIIllllll) {
        super(lIIIlIlIIllllIl);
        super.parent = lIIIlIlIIllllll;
    }
    
    @Override
    public int[] getInts(final int lIIIlIlIIlIlIII, final int lIIIlIlIIlIIlll, final int lIIIlIlIIlIIllI, final int lIIIlIlIIlIIlIl) {
        final int lIIIlIlIIlIIlII = lIIIlIlIIlIlIII - 1;
        final int lIIIlIlIIlIIIll = lIIIlIlIIlIIlll - 1;
        final int lIIIlIlIIlIIIlI = lIIIlIlIIlIIllI + 2;
        final int lIIIlIlIIlIIIIl = lIIIlIlIIlIIlIl + 2;
        final int[] lIIIlIlIIlIIIII = this.parent.getInts(lIIIlIlIIlIIlII, lIIIlIlIIlIIIll, lIIIlIlIIlIIIlI, lIIIlIlIIlIIIIl);
        final int[] lIIIlIlIIIlllll = IntCache.getIntCache(lIIIlIlIIlIIllI * lIIIlIlIIlIIlIl);
        for (int lIIIlIlIIIllllI = 0; lIIIlIlIIIllllI < lIIIlIlIIlIIlIl; ++lIIIlIlIIIllllI) {
            for (int lIIIlIlIIIlllIl = 0; lIIIlIlIIIlllIl < lIIIlIlIIlIIllI; ++lIIIlIlIIIlllIl) {
                final int lIIIlIlIIIlllII = this.func_151630_c(lIIIlIlIIlIIIII[lIIIlIlIIIlllIl + 0 + (lIIIlIlIIIllllI + 1) * lIIIlIlIIlIIIlI]);
                final int lIIIlIlIIIllIll = this.func_151630_c(lIIIlIlIIlIIIII[lIIIlIlIIIlllIl + 2 + (lIIIlIlIIIllllI + 1) * lIIIlIlIIlIIIlI]);
                final int lIIIlIlIIIllIlI = this.func_151630_c(lIIIlIlIIlIIIII[lIIIlIlIIIlllIl + 1 + (lIIIlIlIIIllllI + 0) * lIIIlIlIIlIIIlI]);
                final int lIIIlIlIIIllIIl = this.func_151630_c(lIIIlIlIIlIIIII[lIIIlIlIIIlllIl + 1 + (lIIIlIlIIIllllI + 2) * lIIIlIlIIlIIIlI]);
                final int lIIIlIlIIIllIII = this.func_151630_c(lIIIlIlIIlIIIII[lIIIlIlIIIlllIl + 1 + (lIIIlIlIIIllllI + 1) * lIIIlIlIIlIIIlI]);
                if (lIIIlIlIIIllIII == lIIIlIlIIIlllII && lIIIlIlIIIllIII == lIIIlIlIIIllIlI && lIIIlIlIIIllIII == lIIIlIlIIIllIll && lIIIlIlIIIllIII == lIIIlIlIIIllIIl) {
                    lIIIlIlIIIlllll[lIIIlIlIIIlllIl + lIIIlIlIIIllllI * lIIIlIlIIlIIllI] = -1;
                }
                else {
                    lIIIlIlIIIlllll[lIIIlIlIIIlllIl + lIIIlIlIIIllllI * lIIIlIlIIlIIllI] = BiomeGenBase.river.biomeID;
                }
            }
        }
        return lIIIlIlIIIlllll;
    }
    
    private int func_151630_c(final int lIIIlIlIIIIIIll) {
        return (lIIIlIlIIIIIIll >= 2) ? (2 + (lIIIlIlIIIIIIll & 0x1)) : lIIIlIlIIIIIIll;
    }
}
