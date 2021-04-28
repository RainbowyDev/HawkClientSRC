package net.minecraft.world.gen.layer;

public class GenLayerIsland extends GenLayer
{
    static {
        __OBFID = "CL_00000558";
    }
    
    public GenLayerIsland(final long llllllllllllllIlIllIIlIIIIlIlIII) {
        super(llllllllllllllIlIllIIlIIIIlIlIII);
    }
    
    @Override
    public int[] getInts(final int llllllllllllllIlIllIIlIIIIIllllI, final int llllllllllllllIlIllIIlIIIIIlIlIl, final int llllllllllllllIlIllIIlIIIIIlIlII, final int llllllllllllllIlIllIIlIIIIIllIll) {
        final int[] llllllllllllllIlIllIIlIIIIIllIlI = IntCache.getIntCache(llllllllllllllIlIllIIlIIIIIlIlII * llllllllllllllIlIllIIlIIIIIllIll);
        for (int llllllllllllllIlIllIIlIIIIIllIIl = 0; llllllllllllllIlIllIIlIIIIIllIIl < llllllllllllllIlIllIIlIIIIIllIll; ++llllllllllllllIlIllIIlIIIIIllIIl) {
            for (int llllllllllllllIlIllIIlIIIIIllIII = 0; llllllllllllllIlIllIIlIIIIIllIII < llllllllllllllIlIllIIlIIIIIlIlII; ++llllllllllllllIlIllIIlIIIIIllIII) {
                this.initChunkSeed(llllllllllllllIlIllIIlIIIIIllllI + llllllllllllllIlIllIIlIIIIIllIII, llllllllllllllIlIllIIlIIIIIlIlIl + llllllllllllllIlIllIIlIIIIIllIIl);
                llllllllllllllIlIllIIlIIIIIllIlI[llllllllllllllIlIllIIlIIIIIllIII + llllllllllllllIlIllIIlIIIIIllIIl * llllllllllllllIlIllIIlIIIIIlIlII] = ((this.nextInt(10) == 0) ? 1 : 0);
            }
        }
        if (llllllllllllllIlIllIIlIIIIIllllI > -llllllllllllllIlIllIIlIIIIIlIlII && llllllllllllllIlIllIIlIIIIIllllI <= 0 && llllllllllllllIlIllIIlIIIIIlIlIl > -llllllllllllllIlIllIIlIIIIIllIll && llllllllllllllIlIllIIlIIIIIlIlIl <= 0) {
            llllllllllllllIlIllIIlIIIIIllIlI[-llllllllllllllIlIllIIlIIIIIllllI + -llllllllllllllIlIllIIlIIIIIlIlIl * llllllllllllllIlIllIIlIIIIIlIlII] = 1;
        }
        return llllllllllllllIlIllIIlIIIIIllIlI;
    }
}
