package net.minecraft.world.gen.layer;

public class GenLayerSmooth extends GenLayer
{
    public GenLayerSmooth(final long llllllllllllllllIIlIIIlIlIIIlIIl, final GenLayer llllllllllllllllIIlIIIlIlIIIlIII) {
        super(llllllllllllllllIIlIIIlIlIIIlIIl);
        super.parent = llllllllllllllllIIlIIIlIlIIIlIII;
    }
    
    static {
        __OBFID = "CL_00000569";
    }
    
    @Override
    public int[] getInts(final int llllllllllllllllIIlIIIlIIlllIIIl, final int llllllllllllllllIIlIIIlIIlIllllI, final int llllllllllllllllIIlIIIlIIlIlllIl, final int llllllllllllllllIIlIIIlIIllIlllI) {
        final int llllllllllllllllIIlIIIlIIllIllIl = llllllllllllllllIIlIIIlIIlllIIIl - 1;
        final int llllllllllllllllIIlIIIlIIllIllII = llllllllllllllllIIlIIIlIIlIllllI - 1;
        final int llllllllllllllllIIlIIIlIIllIlIll = llllllllllllllllIIlIIIlIIlIlllIl + 2;
        final int llllllllllllllllIIlIIIlIIllIlIlI = llllllllllllllllIIlIIIlIIllIlllI + 2;
        final int[] llllllllllllllllIIlIIIlIIllIlIIl = this.parent.getInts(llllllllllllllllIIlIIIlIIllIllIl, llllllllllllllllIIlIIIlIIllIllII, llllllllllllllllIIlIIIlIIllIlIll, llllllllllllllllIIlIIIlIIllIlIlI);
        final int[] llllllllllllllllIIlIIIlIIllIlIII = IntCache.getIntCache(llllllllllllllllIIlIIIlIIlIlllIl * llllllllllllllllIIlIIIlIIllIlllI);
        for (int llllllllllllllllIIlIIIlIIllIIlll = 0; llllllllllllllllIIlIIIlIIllIIlll < llllllllllllllllIIlIIIlIIllIlllI; ++llllllllllllllllIIlIIIlIIllIIlll) {
            for (int llllllllllllllllIIlIIIlIIllIIllI = 0; llllllllllllllllIIlIIIlIIllIIllI < llllllllllllllllIIlIIIlIIlIlllIl; ++llllllllllllllllIIlIIIlIIllIIllI) {
                final int llllllllllllllllIIlIIIlIIllIIlIl = llllllllllllllllIIlIIIlIIllIlIIl[llllllllllllllllIIlIIIlIIllIIllI + 0 + (llllllllllllllllIIlIIIlIIllIIlll + 1) * llllllllllllllllIIlIIIlIIllIlIll];
                final int llllllllllllllllIIlIIIlIIllIIlII = llllllllllllllllIIlIIIlIIllIlIIl[llllllllllllllllIIlIIIlIIllIIllI + 2 + (llllllllllllllllIIlIIIlIIllIIlll + 1) * llllllllllllllllIIlIIIlIIllIlIll];
                final int llllllllllllllllIIlIIIlIIllIIIll = llllllllllllllllIIlIIIlIIllIlIIl[llllllllllllllllIIlIIIlIIllIIllI + 1 + (llllllllllllllllIIlIIIlIIllIIlll + 0) * llllllllllllllllIIlIIIlIIllIlIll];
                final int llllllllllllllllIIlIIIlIIllIIIlI = llllllllllllllllIIlIIIlIIllIlIIl[llllllllllllllllIIlIIIlIIllIIllI + 1 + (llllllllllllllllIIlIIIlIIllIIlll + 2) * llllllllllllllllIIlIIIlIIllIlIll];
                int llllllllllllllllIIlIIIlIIllIIIIl = llllllllllllllllIIlIIIlIIllIlIIl[llllllllllllllllIIlIIIlIIllIIllI + 1 + (llllllllllllllllIIlIIIlIIllIIlll + 1) * llllllllllllllllIIlIIIlIIllIlIll];
                if (llllllllllllllllIIlIIIlIIllIIlIl == llllllllllllllllIIlIIIlIIllIIlII && llllllllllllllllIIlIIIlIIllIIIll == llllllllllllllllIIlIIIlIIllIIIlI) {
                    this.initChunkSeed(llllllllllllllllIIlIIIlIIllIIllI + llllllllllllllllIIlIIIlIIlllIIIl, llllllllllllllllIIlIIIlIIllIIlll + llllllllllllllllIIlIIIlIIlIllllI);
                    if (this.nextInt(2) == 0) {
                        llllllllllllllllIIlIIIlIIllIIIIl = llllllllllllllllIIlIIIlIIllIIlIl;
                    }
                    else {
                        llllllllllllllllIIlIIIlIIllIIIIl = llllllllllllllllIIlIIIlIIllIIIll;
                    }
                }
                else {
                    if (llllllllllllllllIIlIIIlIIllIIlIl == llllllllllllllllIIlIIIlIIllIIlII) {
                        llllllllllllllllIIlIIIlIIllIIIIl = llllllllllllllllIIlIIIlIIllIIlIl;
                    }
                    if (llllllllllllllllIIlIIIlIIllIIIll == llllllllllllllllIIlIIIlIIllIIIlI) {
                        llllllllllllllllIIlIIIlIIllIIIIl = llllllllllllllllIIlIIIlIIllIIIll;
                    }
                }
                llllllllllllllllIIlIIIlIIllIlIII[llllllllllllllllIIlIIIlIIllIIllI + llllllllllllllllIIlIIIlIIllIIlll * llllllllllllllllIIlIIIlIIlIlllIl] = llllllllllllllllIIlIIIlIIllIIIIl;
            }
        }
        return llllllllllllllllIIlIIIlIIllIlIII;
    }
}
