package net.minecraft.world.gen.layer;

public class GenLayerVoronoiZoom extends GenLayer
{
    static {
        __OBFID = "CL_00000571";
    }
    
    @Override
    public int[] getInts(int llllllllllllllIllIlIlIIIIIIlIlII, int llllllllllllllIllIlIlIIIIIIlIIll, final int llllllllllllllIllIlIlIIIIIIlIIlI, final int llllllllllllllIllIlIlIIIIIllIllI) {
        llllllllllllllIllIlIlIIIIIIlIlII -= 2;
        llllllllllllllIllIlIlIIIIIIlIIll -= 2;
        final int llllllllllllllIllIlIlIIIIIllIlIl = llllllllllllllIllIlIlIIIIIIlIlII >> 2;
        final int llllllllllllllIllIlIlIIIIIllIlII = llllllllllllllIllIlIlIIIIIIlIIll >> 2;
        final int llllllllllllllIllIlIlIIIIIllIIll = (llllllllllllllIllIlIlIIIIIIlIIlI >> 2) + 2;
        final int llllllllllllllIllIlIlIIIIIllIIlI = (llllllllllllllIllIlIlIIIIIllIllI >> 2) + 2;
        final int[] llllllllllllllIllIlIlIIIIIllIIIl = this.parent.getInts(llllllllllllllIllIlIlIIIIIllIlIl, llllllllllllllIllIlIlIIIIIllIlII, llllllllllllllIllIlIlIIIIIllIIll, llllllllllllllIllIlIlIIIIIllIIlI);
        final int llllllllllllllIllIlIlIIIIIllIIII = llllllllllllllIllIlIlIIIIIllIIll - 1 << 2;
        final int llllllllllllllIllIlIlIIIIIlIllll = llllllllllllllIllIlIlIIIIIllIIlI - 1 << 2;
        final int[] llllllllllllllIllIlIlIIIIIlIlllI = IntCache.getIntCache(llllllllllllllIllIlIlIIIIIllIIII * llllllllllllllIllIlIlIIIIIlIllll);
        for (int llllllllllllllIllIlIlIIIIIlIlIll = 0; llllllllllllllIllIlIlIIIIIlIlIll < llllllllllllllIllIlIlIIIIIllIIlI - 1; ++llllllllllllllIllIlIlIIIIIlIlIll) {
            int llllllllllllllIllIlIlIIIIIlIllIl = 0;
            int llllllllllllllIllIlIlIIIIIlIlIlI = llllllllllllllIllIlIlIIIIIllIIIl[llllllllllllllIllIlIlIIIIIlIllIl + 0 + (llllllllllllllIllIlIlIIIIIlIlIll + 0) * llllllllllllllIllIlIlIIIIIllIIll];
            int llllllllllllllIllIlIlIIIIIlIlIIl = llllllllllllllIllIlIlIIIIIllIIIl[llllllllllllllIllIlIlIIIIIlIllIl + 0 + (llllllllllllllIllIlIlIIIIIlIlIll + 1) * llllllllllllllIllIlIlIIIIIllIIll];
            while (llllllllllllllIllIlIlIIIIIlIllIl < llllllllllllllIllIlIlIIIIIllIIll - 1) {
                final double llllllllllllllIllIlIlIIIIIlIlIII = 3.6;
                this.initChunkSeed(llllllllllllllIllIlIlIIIIIlIllIl + llllllllllllllIllIlIlIIIIIllIlIl << 2, llllllllllllllIllIlIlIIIIIlIlIll + llllllllllllllIllIlIlIIIIIllIlII << 2);
                final double llllllllllllllIllIlIlIIIIIlIIlll = (this.nextInt(1024) / 1024.0 - 0.5) * 3.6;
                final double llllllllllllllIllIlIlIIIIIlIIllI = (this.nextInt(1024) / 1024.0 - 0.5) * 3.6;
                this.initChunkSeed(llllllllllllllIllIlIlIIIIIlIllIl + llllllllllllllIllIlIlIIIIIllIlIl + 1 << 2, llllllllllllllIllIlIlIIIIIlIlIll + llllllllllllllIllIlIlIIIIIllIlII << 2);
                final double llllllllllllllIllIlIlIIIIIlIIlIl = (this.nextInt(1024) / 1024.0 - 0.5) * 3.6 + 4.0;
                final double llllllllllllllIllIlIlIIIIIlIIlII = (this.nextInt(1024) / 1024.0 - 0.5) * 3.6;
                this.initChunkSeed(llllllllllllllIllIlIlIIIIIlIllIl + llllllllllllllIllIlIlIIIIIllIlIl << 2, llllllllllllllIllIlIlIIIIIlIlIll + llllllllllllllIllIlIlIIIIIllIlII + 1 << 2);
                final double llllllllllllllIllIlIlIIIIIlIIIll = (this.nextInt(1024) / 1024.0 - 0.5) * 3.6;
                final double llllllllllllllIllIlIlIIIIIlIIIlI = (this.nextInt(1024) / 1024.0 - 0.5) * 3.6 + 4.0;
                this.initChunkSeed(llllllllllllllIllIlIlIIIIIlIllIl + llllllllllllllIllIlIlIIIIIllIlIl + 1 << 2, llllllllllllllIllIlIlIIIIIlIlIll + llllllllllllllIllIlIlIIIIIllIlII + 1 << 2);
                final double llllllllllllllIllIlIlIIIIIlIIIIl = (this.nextInt(1024) / 1024.0 - 0.5) * 3.6 + 4.0;
                final double llllllllllllllIllIlIlIIIIIlIIIII = (this.nextInt(1024) / 1024.0 - 0.5) * 3.6 + 4.0;
                final int llllllllllllllIllIlIlIIIIIIlllll = llllllllllllllIllIlIlIIIIIllIIIl[llllllllllllllIllIlIlIIIIIlIllIl + 1 + (llllllllllllllIllIlIlIIIIIlIlIll + 0) * llllllllllllllIllIlIlIIIIIllIIll] & 0xFF;
                final int llllllllllllllIllIlIlIIIIIIllllI = llllllllllllllIllIlIlIIIIIllIIIl[llllllllllllllIllIlIlIIIIIlIllIl + 1 + (llllllllllllllIllIlIlIIIIIlIlIll + 1) * llllllllllllllIllIlIlIIIIIllIIll] & 0xFF;
                for (int llllllllllllllIllIlIlIIIIIIlllIl = 0; llllllllllllllIllIlIlIIIIIIlllIl < 4; ++llllllllllllllIllIlIlIIIIIIlllIl) {
                    int llllllllllllllIllIlIlIIIIIIlllII = ((llllllllllllllIllIlIlIIIIIlIlIll << 2) + llllllllllllllIllIlIlIIIIIIlllIl) * llllllllllllllIllIlIlIIIIIllIIII + (llllllllllllllIllIlIlIIIIIlIllIl << 2);
                    for (int llllllllllllllIllIlIlIIIIIIllIll = 0; llllllllllllllIllIlIlIIIIIIllIll < 4; ++llllllllllllllIllIlIlIIIIIIllIll) {
                        final double llllllllllllllIllIlIlIIIIIIllIlI = (llllllllllllllIllIlIlIIIIIIlllIl - llllllllllllllIllIlIlIIIIIlIIllI) * (llllllllllllllIllIlIlIIIIIIlllIl - llllllllllllllIllIlIlIIIIIlIIllI) + (llllllllllllllIllIlIlIIIIIIllIll - llllllllllllllIllIlIlIIIIIlIIlll) * (llllllllllllllIllIlIlIIIIIIllIll - llllllllllllllIllIlIlIIIIIlIIlll);
                        final double llllllllllllllIllIlIlIIIIIIllIIl = (llllllllllllllIllIlIlIIIIIIlllIl - llllllllllllllIllIlIlIIIIIlIIlII) * (llllllllllllllIllIlIlIIIIIIlllIl - llllllllllllllIllIlIlIIIIIlIIlII) + (llllllllllllllIllIlIlIIIIIIllIll - llllllllllllllIllIlIlIIIIIlIIlIl) * (llllllllllllllIllIlIlIIIIIIllIll - llllllllllllllIllIlIlIIIIIlIIlIl);
                        final double llllllllllllllIllIlIlIIIIIIllIII = (llllllllllllllIllIlIlIIIIIIlllIl - llllllllllllllIllIlIlIIIIIlIIIlI) * (llllllllllllllIllIlIlIIIIIIlllIl - llllllllllllllIllIlIlIIIIIlIIIlI) + (llllllllllllllIllIlIlIIIIIIllIll - llllllllllllllIllIlIlIIIIIlIIIll) * (llllllllllllllIllIlIlIIIIIIllIll - llllllllllllllIllIlIlIIIIIlIIIll);
                        final double llllllllllllllIllIlIlIIIIIIlIlll = (llllllllllllllIllIlIlIIIIIIlllIl - llllllllllllllIllIlIlIIIIIlIIIII) * (llllllllllllllIllIlIlIIIIIIlllIl - llllllllllllllIllIlIlIIIIIlIIIII) + (llllllllllllllIllIlIlIIIIIIllIll - llllllllllllllIllIlIlIIIIIlIIIIl) * (llllllllllllllIllIlIlIIIIIIllIll - llllllllllllllIllIlIlIIIIIlIIIIl);
                        if (llllllllllllllIllIlIlIIIIIIllIlI < llllllllllllllIllIlIlIIIIIIllIIl && llllllllllllllIllIlIlIIIIIIllIlI < llllllllllllllIllIlIlIIIIIIllIII && llllllllllllllIllIlIlIIIIIIllIlI < llllllllllllllIllIlIlIIIIIIlIlll) {
                            llllllllllllllIllIlIlIIIIIlIlllI[llllllllllllllIllIlIlIIIIIIlllII++] = llllllllllllllIllIlIlIIIIIlIlIlI;
                        }
                        else if (llllllllllllllIllIlIlIIIIIIllIIl < llllllllllllllIllIlIlIIIIIIllIlI && llllllllllllllIllIlIlIIIIIIllIIl < llllllllllllllIllIlIlIIIIIIllIII && llllllllllllllIllIlIlIIIIIIllIIl < llllllllllllllIllIlIlIIIIIIlIlll) {
                            llllllllllllllIllIlIlIIIIIlIlllI[llllllllllllllIllIlIlIIIIIIlllII++] = llllllllllllllIllIlIlIIIIIIlllll;
                        }
                        else if (llllllllllllllIllIlIlIIIIIIllIII < llllllllllllllIllIlIlIIIIIIllIlI && llllllllllllllIllIlIlIIIIIIllIII < llllllllllllllIllIlIlIIIIIIllIIl && llllllllllllllIllIlIlIIIIIIllIII < llllllllllllllIllIlIlIIIIIIlIlll) {
                            llllllllllllllIllIlIlIIIIIlIlllI[llllllllllllllIllIlIlIIIIIIlllII++] = llllllllllllllIllIlIlIIIIIlIlIIl;
                        }
                        else {
                            llllllllllllllIllIlIlIIIIIlIlllI[llllllllllllllIllIlIlIIIIIIlllII++] = llllllllllllllIllIlIlIIIIIIllllI;
                        }
                    }
                }
                llllllllllllllIllIlIlIIIIIlIlIlI = llllllllllllllIllIlIlIIIIIIlllll;
                llllllllllllllIllIlIlIIIIIlIlIIl = llllllllllllllIllIlIlIIIIIIllllI;
                ++llllllllllllllIllIlIlIIIIIlIllIl;
            }
        }
        final int[] llllllllllllllIllIlIlIIIIIIlIllI = IntCache.getIntCache(llllllllllllllIllIlIlIIIIIIlIIlI * llllllllllllllIllIlIlIIIIIllIllI);
        for (int llllllllllllllIllIlIlIIIIIlIllII = 0; llllllllllllllIllIlIlIIIIIlIllII < llllllllllllllIllIlIlIIIIIllIllI; ++llllllllllllllIllIlIlIIIIIlIllII) {
            System.arraycopy(llllllllllllllIllIlIlIIIIIlIlllI, (llllllllllllllIllIlIlIIIIIlIllII + (llllllllllllllIllIlIlIIIIIIlIIll & 0x3)) * llllllllllllllIllIlIlIIIIIllIIII + (llllllllllllllIllIlIlIIIIIIlIlII & 0x3), llllllllllllllIllIlIlIIIIIIlIllI, llllllllllllllIllIlIlIIIIIlIllII * llllllllllllllIllIlIlIIIIIIlIIlI, llllllllllllllIllIlIlIIIIIIlIIlI);
        }
        return llllllllllllllIllIlIlIIIIIIlIllI;
    }
    
    public GenLayerVoronoiZoom(final long llllllllllllllIllIlIlIIIIlIlllll, final GenLayer llllllllllllllIllIlIlIIIIlIllllI) {
        super(llllllllllllllIllIlIlIIIIlIlllll);
        super.parent = llllllllllllllIllIlIlIIIIlIllllI;
    }
}
