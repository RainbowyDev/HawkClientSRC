package net.minecraft.world.gen.layer;

public class GenLayerRemoveTooMuchOcean extends GenLayer
{
    public GenLayerRemoveTooMuchOcean(final long lllllllllllllllIIIIIllIllIIllllI, final GenLayer lllllllllllllllIIIIIllIllIIlllIl) {
        super(lllllllllllllllIIIIIllIllIIllllI);
        this.parent = lllllllllllllllIIIIIllIllIIlllIl;
    }
    
    @Override
    public int[] getInts(final int lllllllllllllllIIIIIllIllIIIIllI, final int lllllllllllllllIIIIIllIllIIIIlIl, final int lllllllllllllllIIIIIllIllIIIIlII, final int lllllllllllllllIIIIIllIlIlllIIIl) {
        final int lllllllllllllllIIIIIllIllIIIIIlI = lllllllllllllllIIIIIllIllIIIIllI - 1;
        final int lllllllllllllllIIIIIllIllIIIIIIl = lllllllllllllllIIIIIllIllIIIIlIl - 1;
        final int lllllllllllllllIIIIIllIllIIIIIII = lllllllllllllllIIIIIllIllIIIIlII + 2;
        final int lllllllllllllllIIIIIllIlIlllllll = lllllllllllllllIIIIIllIlIlllIIIl + 2;
        final int[] lllllllllllllllIIIIIllIlIllllllI = this.parent.getInts(lllllllllllllllIIIIIllIllIIIIIlI, lllllllllllllllIIIIIllIllIIIIIIl, lllllllllllllllIIIIIllIllIIIIIII, lllllllllllllllIIIIIllIlIlllllll);
        final int[] lllllllllllllllIIIIIllIlIlllllIl = IntCache.getIntCache(lllllllllllllllIIIIIllIllIIIIlII * lllllllllllllllIIIIIllIlIlllIIIl);
        for (int lllllllllllllllIIIIIllIlIlllllII = 0; lllllllllllllllIIIIIllIlIlllllII < lllllllllllllllIIIIIllIlIlllIIIl; ++lllllllllllllllIIIIIllIlIlllllII) {
            for (int lllllllllllllllIIIIIllIlIllllIll = 0; lllllllllllllllIIIIIllIlIllllIll < lllllllllllllllIIIIIllIllIIIIlII; ++lllllllllllllllIIIIIllIlIllllIll) {
                final int lllllllllllllllIIIIIllIlIllllIlI = lllllllllllllllIIIIIllIlIllllllI[lllllllllllllllIIIIIllIlIllllIll + 1 + (lllllllllllllllIIIIIllIlIlllllII + 1 - 1) * (lllllllllllllllIIIIIllIllIIIIlII + 2)];
                final int lllllllllllllllIIIIIllIlIllllIIl = lllllllllllllllIIIIIllIlIllllllI[lllllllllllllllIIIIIllIlIllllIll + 1 + 1 + (lllllllllllllllIIIIIllIlIlllllII + 1) * (lllllllllllllllIIIIIllIllIIIIlII + 2)];
                final int lllllllllllllllIIIIIllIlIllllIII = lllllllllllllllIIIIIllIlIllllllI[lllllllllllllllIIIIIllIlIllllIll + 1 - 1 + (lllllllllllllllIIIIIllIlIlllllII + 1) * (lllllllllllllllIIIIIllIllIIIIlII + 2)];
                final int lllllllllllllllIIIIIllIlIlllIlll = lllllllllllllllIIIIIllIlIllllllI[lllllllllllllllIIIIIllIlIllllIll + 1 + (lllllllllllllllIIIIIllIlIlllllII + 1 + 1) * (lllllllllllllllIIIIIllIllIIIIlII + 2)];
                final int lllllllllllllllIIIIIllIlIlllIllI = lllllllllllllllIIIIIllIlIllllllI[lllllllllllllllIIIIIllIlIllllIll + 1 + (lllllllllllllllIIIIIllIlIlllllII + 1) * lllllllllllllllIIIIIllIllIIIIIII];
                lllllllllllllllIIIIIllIlIlllllIl[lllllllllllllllIIIIIllIlIllllIll + lllllllllllllllIIIIIllIlIlllllII * lllllllllllllllIIIIIllIllIIIIlII] = lllllllllllllllIIIIIllIlIlllIllI;
                this.initChunkSeed(lllllllllllllllIIIIIllIlIllllIll + lllllllllllllllIIIIIllIllIIIIllI, lllllllllllllllIIIIIllIlIlllllII + lllllllllllllllIIIIIllIllIIIIlIl);
                if (lllllllllllllllIIIIIllIlIlllIllI == 0 && lllllllllllllllIIIIIllIlIllllIlI == 0 && lllllllllllllllIIIIIllIlIllllIIl == 0 && lllllllllllllllIIIIIllIlIllllIII == 0 && lllllllllllllllIIIIIllIlIlllIlll == 0 && this.nextInt(2) == 0) {
                    lllllllllllllllIIIIIllIlIlllllIl[lllllllllllllllIIIIIllIlIllllIll + lllllllllllllllIIIIIllIlIlllllII * lllllllllllllllIIIIIllIllIIIIlII] = 1;
                }
            }
        }
        return lllllllllllllllIIIIIllIlIlllllIl;
    }
    
    static {
        __OBFID = "CL_00000564";
    }
}
