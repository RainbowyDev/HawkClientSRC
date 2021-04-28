package net.minecraft.world.gen.layer;

public class GenLayerAddSnow extends GenLayer
{
    @Override
    public int[] getInts(final int lllllllllllllllIIIIIIlIlIIlIIIII, final int lllllllllllllllIIIIIIlIlIIIlllll, final int lllllllllllllllIIIIIIlIlIIllIIII, final int lllllllllllllllIIIIIIlIlIIIlllIl) {
        final int lllllllllllllllIIIIIIlIlIIlIlllI = lllllllllllllllIIIIIIlIlIIlIIIII - 1;
        final int lllllllllllllllIIIIIIlIlIIlIllIl = lllllllllllllllIIIIIIlIlIIIlllll - 1;
        final int lllllllllllllllIIIIIIlIlIIlIllII = lllllllllllllllIIIIIIlIlIIllIIII + 2;
        final int lllllllllllllllIIIIIIlIlIIlIlIll = lllllllllllllllIIIIIIlIlIIIlllIl + 2;
        final int[] lllllllllllllllIIIIIIlIlIIlIlIlI = this.parent.getInts(lllllllllllllllIIIIIIlIlIIlIlllI, lllllllllllllllIIIIIIlIlIIlIllIl, lllllllllllllllIIIIIIlIlIIlIllII, lllllllllllllllIIIIIIlIlIIlIlIll);
        final int[] lllllllllllllllIIIIIIlIlIIlIlIIl = IntCache.getIntCache(lllllllllllllllIIIIIIlIlIIllIIII * lllllllllllllllIIIIIIlIlIIIlllIl);
        for (int lllllllllllllllIIIIIIlIlIIlIlIII = 0; lllllllllllllllIIIIIIlIlIIlIlIII < lllllllllllllllIIIIIIlIlIIIlllIl; ++lllllllllllllllIIIIIIlIlIIlIlIII) {
            for (int lllllllllllllllIIIIIIlIlIIlIIlll = 0; lllllllllllllllIIIIIIlIlIIlIIlll < lllllllllllllllIIIIIIlIlIIllIIII; ++lllllllllllllllIIIIIIlIlIIlIIlll) {
                final int lllllllllllllllIIIIIIlIlIIlIIllI = lllllllllllllllIIIIIIlIlIIlIlIlI[lllllllllllllllIIIIIIlIlIIlIIlll + 1 + (lllllllllllllllIIIIIIlIlIIlIlIII + 1) * lllllllllllllllIIIIIIlIlIIlIllII];
                this.initChunkSeed(lllllllllllllllIIIIIIlIlIIlIIlll + lllllllllllllllIIIIIIlIlIIlIIIII, lllllllllllllllIIIIIIlIlIIlIlIII + lllllllllllllllIIIIIIlIlIIIlllll);
                if (lllllllllllllllIIIIIIlIlIIlIIllI == 0) {
                    lllllllllllllllIIIIIIlIlIIlIlIIl[lllllllllllllllIIIIIIlIlIIlIIlll + lllllllllllllllIIIIIIlIlIIlIlIII * lllllllllllllllIIIIIIlIlIIllIIII] = 0;
                }
                else {
                    final int lllllllllllllllIIIIIIlIlIIlIIlIl = this.nextInt(6);
                    byte lllllllllllllllIIIIIIlIlIIlIIIlI = 0;
                    if (lllllllllllllllIIIIIIlIlIIlIIlIl == 0) {
                        final byte lllllllllllllllIIIIIIlIlIIlIIlII = 4;
                    }
                    else if (lllllllllllllllIIIIIIlIlIIlIIlIl <= 1) {
                        final byte lllllllllllllllIIIIIIlIlIIlIIIll = 3;
                    }
                    else {
                        lllllllllllllllIIIIIIlIlIIlIIIlI = 1;
                    }
                    lllllllllllllllIIIIIIlIlIIlIlIIl[lllllllllllllllIIIIIIlIlIIlIIlll + lllllllllllllllIIIIIIlIlIIlIlIII * lllllllllllllllIIIIIIlIlIIllIIII] = lllllllllllllllIIIIIIlIlIIlIIIlI;
                }
            }
        }
        return lllllllllllllllIIIIIIlIlIIlIlIIl;
    }
    
    public GenLayerAddSnow(final long lllllllllllllllIIIIIIlIlIlIIlIII, final GenLayer lllllllllllllllIIIIIIlIlIlIIIlII) {
        super(lllllllllllllllIIIIIIlIlIlIIlIII);
        this.parent = lllllllllllllllIIIIIIlIlIlIIIlII;
    }
    
    static {
        __OBFID = "CL_00000553";
    }
}
