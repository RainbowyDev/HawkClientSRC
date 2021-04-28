package net.minecraft.world.gen.layer;

import net.minecraft.world.biome.*;

public class GenLayerDeepOcean extends GenLayer
{
    @Override
    public int[] getInts(final int llllllllllllllIllIlIIlIIIllllIll, final int llllllllllllllIllIlIIlIIIllllIlI, final int llllllllllllllIllIlIIlIIIllllIIl, final int llllllllllllllIllIlIIlIIIllllIII) {
        final int llllllllllllllIllIlIIlIIIlllIlll = llllllllllllllIllIlIIlIIIllllIll - 1;
        final int llllllllllllllIllIlIIlIIIlllIllI = llllllllllllllIllIlIIlIIIllllIlI - 1;
        final int llllllllllllllIllIlIIlIIIlllIlIl = llllllllllllllIllIlIIlIIIllllIIl + 2;
        final int llllllllllllllIllIlIIlIIIlllIlII = llllllllllllllIllIlIIlIIIllllIII + 2;
        final int[] llllllllllllllIllIlIIlIIIlllIIll = this.parent.getInts(llllllllllllllIllIlIIlIIIlllIlll, llllllllllllllIllIlIIlIIIlllIllI, llllllllllllllIllIlIIlIIIlllIlIl, llllllllllllllIllIlIIlIIIlllIlII);
        final int[] llllllllllllllIllIlIIlIIIlllIIlI = IntCache.getIntCache(llllllllllllllIllIlIIlIIIllllIIl * llllllllllllllIllIlIIlIIIllllIII);
        for (int llllllllllllllIllIlIIlIIIlllIIIl = 0; llllllllllllllIllIlIIlIIIlllIIIl < llllllllllllllIllIlIIlIIIllllIII; ++llllllllllllllIllIlIIlIIIlllIIIl) {
            for (int llllllllllllllIllIlIIlIIIlllIIII = 0; llllllllllllllIllIlIIlIIIlllIIII < llllllllllllllIllIlIIlIIIllllIIl; ++llllllllllllllIllIlIIlIIIlllIIII) {
                final int llllllllllllllIllIlIIlIIIllIllll = llllllllllllllIllIlIIlIIIlllIIll[llllllllllllllIllIlIIlIIIlllIIII + 1 + (llllllllllllllIllIlIIlIIIlllIIIl + 1 - 1) * (llllllllllllllIllIlIIlIIIllllIIl + 2)];
                final int llllllllllllllIllIlIIlIIIllIlllI = llllllllllllllIllIlIIlIIIlllIIll[llllllllllllllIllIlIIlIIIlllIIII + 1 + 1 + (llllllllllllllIllIlIIlIIIlllIIIl + 1) * (llllllllllllllIllIlIIlIIIllllIIl + 2)];
                final int llllllllllllllIllIlIIlIIIllIllIl = llllllllllllllIllIlIIlIIIlllIIll[llllllllllllllIllIlIIlIIIlllIIII + 1 - 1 + (llllllllllllllIllIlIIlIIIlllIIIl + 1) * (llllllllllllllIllIlIIlIIIllllIIl + 2)];
                final int llllllllllllllIllIlIIlIIIllIllII = llllllllllllllIllIlIIlIIIlllIIll[llllllllllllllIllIlIIlIIIlllIIII + 1 + (llllllllllllllIllIlIIlIIIlllIIIl + 1 + 1) * (llllllllllllllIllIlIIlIIIllllIIl + 2)];
                final int llllllllllllllIllIlIIlIIIllIlIll = llllllllllllllIllIlIIlIIIlllIIll[llllllllllllllIllIlIIlIIIlllIIII + 1 + (llllllllllllllIllIlIIlIIIlllIIIl + 1) * llllllllllllllIllIlIIlIIIlllIlIl];
                int llllllllllllllIllIlIIlIIIllIlIlI = 0;
                if (llllllllllllllIllIlIIlIIIllIllll == 0) {
                    ++llllllllllllllIllIlIIlIIIllIlIlI;
                }
                if (llllllllllllllIllIlIIlIIIllIlllI == 0) {
                    ++llllllllllllllIllIlIIlIIIllIlIlI;
                }
                if (llllllllllllllIllIlIIlIIIllIllIl == 0) {
                    ++llllllllllllllIllIlIIlIIIllIlIlI;
                }
                if (llllllllllllllIllIlIIlIIIllIllII == 0) {
                    ++llllllllllllllIllIlIIlIIIllIlIlI;
                }
                if (llllllllllllllIllIlIIlIIIllIlIll == 0 && llllllllllllllIllIlIIlIIIllIlIlI > 3) {
                    llllllllllllllIllIlIIlIIIlllIIlI[llllllllllllllIllIlIIlIIIlllIIII + llllllllllllllIllIlIIlIIIlllIIIl * llllllllllllllIllIlIIlIIIllllIIl] = BiomeGenBase.deepOcean.biomeID;
                }
                else {
                    llllllllllllllIllIlIIlIIIlllIIlI[llllllllllllllIllIlIIlIIIlllIIII + llllllllllllllIllIlIIlIIIlllIIIl * llllllllllllllIllIlIIlIIIllllIIl] = llllllllllllllIllIlIIlIIIllIlIll;
                }
            }
        }
        return llllllllllllllIllIlIIlIIIlllIIlI;
    }
    
    static {
        __OBFID = "CL_00000546";
    }
    
    public GenLayerDeepOcean(final long llllllllllllllIllIlIIlIIlIIlIlII, final GenLayer llllllllllllllIllIlIIlIIlIIlIIll) {
        super(llllllllllllllIllIlIIlIIlIIlIlII);
        this.parent = llllllllllllllIllIlIIlIIlIIlIIll;
    }
}
