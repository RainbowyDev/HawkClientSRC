package net.minecraft.world.gen.layer;

public class GenLayerZoom extends GenLayer
{
    public static GenLayer magnify(final long llllllllllllllllIIIlllIlIlllIIll, final GenLayer llllllllllllllllIIIlllIlIlllIIlI, final int llllllllllllllllIIIlllIlIlllIllI) {
        Object llllllllllllllllIIIlllIlIlllIlIl = llllllllllllllllIIIlllIlIlllIIlI;
        for (int llllllllllllllllIIIlllIlIlllIlII = 0; llllllllllllllllIIIlllIlIlllIlII < llllllllllllllllIIIlllIlIlllIllI; ++llllllllllllllllIIIlllIlIlllIlII) {
            llllllllllllllllIIIlllIlIlllIlIl = new GenLayerZoom(llllllllllllllllIIIlllIlIlllIIll + llllllllllllllllIIIlllIlIlllIlII, (GenLayer)llllllllllllllllIIIlllIlIlllIlIl);
        }
        return (GenLayer)llllllllllllllllIIIlllIlIlllIlIl;
    }
    
    static {
        __OBFID = "CL_00000572";
    }
    
    @Override
    public int[] getInts(final int llllllllllllllllIIIlllIllIIlIIII, final int llllllllllllllllIIIlllIllIIIllll, final int llllllllllllllllIIIlllIllIlIIlII, final int llllllllllllllllIIIlllIllIIIllIl) {
        final int llllllllllllllllIIIlllIllIlIIIlI = llllllllllllllllIIIlllIllIIlIIII >> 1;
        final int llllllllllllllllIIIlllIllIlIIIIl = llllllllllllllllIIIlllIllIIIllll >> 1;
        final int llllllllllllllllIIIlllIllIlIIIII = (llllllllllllllllIIIlllIllIlIIlII >> 1) + 2;
        final int llllllllllllllllIIIlllIllIIlllll = (llllllllllllllllIIIlllIllIIIllIl >> 1) + 2;
        final int[] llllllllllllllllIIIlllIllIIllllI = this.parent.getInts(llllllllllllllllIIIlllIllIlIIIlI, llllllllllllllllIIIlllIllIlIIIIl, llllllllllllllllIIIlllIllIlIIIII, llllllllllllllllIIIlllIllIIlllll);
        final int llllllllllllllllIIIlllIllIIlllIl = llllllllllllllllIIIlllIllIlIIIII - 1 << 1;
        final int llllllllllllllllIIIlllIllIIlllII = llllllllllllllllIIIlllIllIIlllll - 1 << 1;
        final int[] llllllllllllllllIIIlllIllIIllIll = IntCache.getIntCache(llllllllllllllllIIIlllIllIIlllIl * llllllllllllllllIIIlllIllIIlllII);
        for (int llllllllllllllllIIIlllIllIIllIII = 0; llllllllllllllllIIIlllIllIIllIII < llllllllllllllllIIIlllIllIIlllll - 1; ++llllllllllllllllIIIlllIllIIllIII) {
            int llllllllllllllllIIIlllIllIIllIlI = (llllllllllllllllIIIlllIllIIllIII << 1) * llllllllllllllllIIIlllIllIIlllIl;
            int llllllllllllllllIIIlllIllIIlIlll = 0;
            int llllllllllllllllIIIlllIllIIlIllI = llllllllllllllllIIIlllIllIIllllI[llllllllllllllllIIIlllIllIIlIlll + 0 + (llllllllllllllllIIIlllIllIIllIII + 0) * llllllllllllllllIIIlllIllIlIIIII];
            int llllllllllllllllIIIlllIllIIlIlIl = llllllllllllllllIIIlllIllIIllllI[llllllllllllllllIIIlllIllIIlIlll + 0 + (llllllllllllllllIIIlllIllIIllIII + 1) * llllllllllllllllIIIlllIllIlIIIII];
            while (llllllllllllllllIIIlllIllIIlIlll < llllllllllllllllIIIlllIllIlIIIII - 1) {
                this.initChunkSeed(llllllllllllllllIIIlllIllIIlIlll + llllllllllllllllIIIlllIllIlIIIlI << 1, llllllllllllllllIIIlllIllIIllIII + llllllllllllllllIIIlllIllIlIIIIl << 1);
                final int llllllllllllllllIIIlllIllIIlIlII = llllllllllllllllIIIlllIllIIllllI[llllllllllllllllIIIlllIllIIlIlll + 1 + (llllllllllllllllIIIlllIllIIllIII + 0) * llllllllllllllllIIIlllIllIlIIIII];
                final int llllllllllllllllIIIlllIllIIlIIll = llllllllllllllllIIIlllIllIIllllI[llllllllllllllllIIIlllIllIIlIlll + 1 + (llllllllllllllllIIIlllIllIIllIII + 1) * llllllllllllllllIIIlllIllIlIIIII];
                llllllllllllllllIIIlllIllIIllIll[llllllllllllllllIIIlllIllIIllIlI] = llllllllllllllllIIIlllIllIIlIllI;
                llllllllllllllllIIIlllIllIIllIll[llllllllllllllllIIIlllIllIIllIlI++ + llllllllllllllllIIIlllIllIIlllIl] = this.selectRandom(llllllllllllllllIIIlllIllIIlIllI, llllllllllllllllIIIlllIllIIlIlIl);
                llllllllllllllllIIIlllIllIIllIll[llllllllllllllllIIIlllIllIIllIlI] = this.selectRandom(llllllllllllllllIIIlllIllIIlIllI, llllllllllllllllIIIlllIllIIlIlII);
                llllllllllllllllIIIlllIllIIllIll[llllllllllllllllIIIlllIllIIllIlI++ + llllllllllllllllIIIlllIllIIlllIl] = this.selectModeOrRandom(llllllllllllllllIIIlllIllIIlIllI, llllllllllllllllIIIlllIllIIlIlII, llllllllllllllllIIIlllIllIIlIlIl, llllllllllllllllIIIlllIllIIlIIll);
                llllllllllllllllIIIlllIllIIlIllI = llllllllllllllllIIIlllIllIIlIlII;
                llllllllllllllllIIIlllIllIIlIlIl = llllllllllllllllIIIlllIllIIlIIll;
                ++llllllllllllllllIIIlllIllIIlIlll;
            }
        }
        final int[] llllllllllllllllIIIlllIllIIlIIlI = IntCache.getIntCache(llllllllllllllllIIIlllIllIlIIlII * llllllllllllllllIIIlllIllIIIllIl);
        for (int llllllllllllllllIIIlllIllIIllIIl = 0; llllllllllllllllIIIlllIllIIllIIl < llllllllllllllllIIIlllIllIIIllIl; ++llllllllllllllllIIIlllIllIIllIIl) {
            System.arraycopy(llllllllllllllllIIIlllIllIIllIll, (llllllllllllllllIIIlllIllIIllIIl + (llllllllllllllllIIIlllIllIIIllll & 0x1)) * llllllllllllllllIIIlllIllIIlllIl + (llllllllllllllllIIIlllIllIIlIIII & 0x1), llllllllllllllllIIIlllIllIIlIIlI, llllllllllllllllIIIlllIllIIllIIl * llllllllllllllllIIIlllIllIlIIlII, llllllllllllllllIIIlllIllIlIIlII);
        }
        return llllllllllllllllIIIlllIllIIlIIlI;
    }
    
    public GenLayerZoom(final long llllllllllllllllIIIlllIllIllllIl, final GenLayer llllllllllllllllIIIlllIllIllllll) {
        super(llllllllllllllllIIIlllIllIllllIl);
        super.parent = llllllllllllllllIIIlllIllIllllll;
    }
}
