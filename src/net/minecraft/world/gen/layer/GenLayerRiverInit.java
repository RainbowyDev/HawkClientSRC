package net.minecraft.world.gen.layer;

public class GenLayerRiverInit extends GenLayer
{
    public GenLayerRiverInit(final long llllllllllllllIlIIIlllIlIllIIIII, final GenLayer llllllllllllllIlIIIlllIlIlIlllll) {
        super(llllllllllllllIlIIIlllIlIllIIIII);
        this.parent = llllllllllllllIlIIIlllIlIlIlllll;
    }
    
    static {
        __OBFID = "CL_00000565";
    }
    
    @Override
    public int[] getInts(final int llllllllllllllIlIIIlllIlIlIlIlII, final int llllllllllllllIlIIIlllIlIlIlIIll, final int llllllllllllllIlIIIlllIlIlIlIIlI, final int llllllllllllllIlIIIlllIlIlIIlIII) {
        final int[] llllllllllllllIlIIIlllIlIlIlIIII = this.parent.getInts(llllllllllllllIlIIIlllIlIlIlIlII, llllllllllllllIlIIIlllIlIlIlIIll, llllllllllllllIlIIIlllIlIlIlIIlI, llllllllllllllIlIIIlllIlIlIIlIII);
        final int[] llllllllllllllIlIIIlllIlIlIIllll = IntCache.getIntCache(llllllllllllllIlIIIlllIlIlIlIIlI * llllllllllllllIlIIIlllIlIlIIlIII);
        for (int llllllllllllllIlIIIlllIlIlIIlllI = 0; llllllllllllllIlIIIlllIlIlIIlllI < llllllllllllllIlIIIlllIlIlIIlIII; ++llllllllllllllIlIIIlllIlIlIIlllI) {
            for (int llllllllllllllIlIIIlllIlIlIIllIl = 0; llllllllllllllIlIIIlllIlIlIIllIl < llllllllllllllIlIIIlllIlIlIlIIlI; ++llllllllllllllIlIIIlllIlIlIIllIl) {
                this.initChunkSeed(llllllllllllllIlIIIlllIlIlIIllIl + llllllllllllllIlIIIlllIlIlIlIlII, llllllllllllllIlIIIlllIlIlIIlllI + llllllllllllllIlIIIlllIlIlIlIIll);
                llllllllllllllIlIIIlllIlIlIIllll[llllllllllllllIlIIIlllIlIlIIllIl + llllllllllllllIlIIIlllIlIlIIlllI * llllllllllllllIlIIIlllIlIlIlIIlI] = ((llllllllllllllIlIIIlllIlIlIlIIII[llllllllllllllIlIIIlllIlIlIIllIl + llllllllllllllIlIIIlllIlIlIIlllI * llllllllllllllIlIIIlllIlIlIlIIlI] > 0) ? (this.nextInt(299999) + 2) : 0);
            }
        }
        return llllllllllllllIlIIIlllIlIlIIllll;
    }
}
