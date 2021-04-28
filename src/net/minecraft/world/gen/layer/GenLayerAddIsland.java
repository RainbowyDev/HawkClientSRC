package net.minecraft.world.gen.layer;

public class GenLayerAddIsland extends GenLayer
{
    static {
        __OBFID = "CL_00000551";
    }
    
    public GenLayerAddIsland(final long llllllllllllllllIllllIlIlllIllll, final GenLayer llllllllllllllllIllllIlIllllIIIl) {
        super(llllllllllllllllIllllIlIlllIllll);
        this.parent = llllllllllllllllIllllIlIllllIIIl;
    }
    
    @Override
    public int[] getInts(final int llllllllllllllllIllllIlIllIIIlII, final int llllllllllllllllIllllIlIllIlIlll, final int llllllllllllllllIllllIlIllIlIllI, final int llllllllllllllllIllllIlIllIlIlIl) {
        final int llllllllllllllllIllllIlIllIlIlII = llllllllllllllllIllllIlIllIIIlII - 1;
        final int llllllllllllllllIllllIlIllIlIIll = llllllllllllllllIllllIlIllIlIlll - 1;
        final int llllllllllllllllIllllIlIllIlIIlI = llllllllllllllllIllllIlIllIlIllI + 2;
        final int llllllllllllllllIllllIlIllIlIIIl = llllllllllllllllIllllIlIllIlIlIl + 2;
        final int[] llllllllllllllllIllllIlIllIlIIII = this.parent.getInts(llllllllllllllllIllllIlIllIlIlII, llllllllllllllllIllllIlIllIlIIll, llllllllllllllllIllllIlIllIlIIlI, llllllllllllllllIllllIlIllIlIIIl);
        final int[] llllllllllllllllIllllIlIllIIllll = IntCache.getIntCache(llllllllllllllllIllllIlIllIlIllI * llllllllllllllllIllllIlIllIlIlIl);
        for (int llllllllllllllllIllllIlIllIIlllI = 0; llllllllllllllllIllllIlIllIIlllI < llllllllllllllllIllllIlIllIlIlIl; ++llllllllllllllllIllllIlIllIIlllI) {
            for (int llllllllllllllllIllllIlIllIIllIl = 0; llllllllllllllllIllllIlIllIIllIl < llllllllllllllllIllllIlIllIlIllI; ++llllllllllllllllIllllIlIllIIllIl) {
                final int llllllllllllllllIllllIlIllIIllII = llllllllllllllllIllllIlIllIlIIII[llllllllllllllllIllllIlIllIIllIl + 0 + (llllllllllllllllIllllIlIllIIlllI + 0) * llllllllllllllllIllllIlIllIlIIlI];
                final int llllllllllllllllIllllIlIllIIlIll = llllllllllllllllIllllIlIllIlIIII[llllllllllllllllIllllIlIllIIllIl + 2 + (llllllllllllllllIllllIlIllIIlllI + 0) * llllllllllllllllIllllIlIllIlIIlI];
                final int llllllllllllllllIllllIlIllIIlIlI = llllllllllllllllIllllIlIllIlIIII[llllllllllllllllIllllIlIllIIllIl + 0 + (llllllllllllllllIllllIlIllIIlllI + 2) * llllllllllllllllIllllIlIllIlIIlI];
                final int llllllllllllllllIllllIlIllIIlIIl = llllllllllllllllIllllIlIllIlIIII[llllllllllllllllIllllIlIllIIllIl + 2 + (llllllllllllllllIllllIlIllIIlllI + 2) * llllllllllllllllIllllIlIllIlIIlI];
                final int llllllllllllllllIllllIlIllIIlIII = llllllllllllllllIllllIlIllIlIIII[llllllllllllllllIllllIlIllIIllIl + 1 + (llllllllllllllllIllllIlIllIIlllI + 1) * llllllllllllllllIllllIlIllIlIIlI];
                this.initChunkSeed(llllllllllllllllIllllIlIllIIllIl + llllllllllllllllIllllIlIllIIIlII, llllllllllllllllIllllIlIllIIlllI + llllllllllllllllIllllIlIllIlIlll);
                if (llllllllllllllllIllllIlIllIIlIII == 0 && (llllllllllllllllIllllIlIllIIllII != 0 || llllllllllllllllIllllIlIllIIlIll != 0 || llllllllllllllllIllllIlIllIIlIlI != 0 || llllllllllllllllIllllIlIllIIlIIl != 0)) {
                    int llllllllllllllllIllllIlIllIIIlll = 1;
                    int llllllllllllllllIllllIlIllIIIllI = 1;
                    if (llllllllllllllllIllllIlIllIIllII != 0 && this.nextInt(llllllllllllllllIllllIlIllIIIlll++) == 0) {
                        llllllllllllllllIllllIlIllIIIllI = llllllllllllllllIllllIlIllIIllII;
                    }
                    if (llllllllllllllllIllllIlIllIIlIll != 0 && this.nextInt(llllllllllllllllIllllIlIllIIIlll++) == 0) {
                        llllllllllllllllIllllIlIllIIIllI = llllllllllllllllIllllIlIllIIlIll;
                    }
                    if (llllllllllllllllIllllIlIllIIlIlI != 0 && this.nextInt(llllllllllllllllIllllIlIllIIIlll++) == 0) {
                        llllllllllllllllIllllIlIllIIIllI = llllllllllllllllIllllIlIllIIlIlI;
                    }
                    if (llllllllllllllllIllllIlIllIIlIIl != 0 && this.nextInt(llllllllllllllllIllllIlIllIIIlll++) == 0) {
                        llllllllllllllllIllllIlIllIIIllI = llllllllllllllllIllllIlIllIIlIIl;
                    }
                    if (this.nextInt(3) == 0) {
                        llllllllllllllllIllllIlIllIIllll[llllllllllllllllIllllIlIllIIllIl + llllllllllllllllIllllIlIllIIlllI * llllllllllllllllIllllIlIllIlIllI] = llllllllllllllllIllllIlIllIIIllI;
                    }
                    else if (llllllllllllllllIllllIlIllIIIllI == 4) {
                        llllllllllllllllIllllIlIllIIllll[llllllllllllllllIllllIlIllIIllIl + llllllllllllllllIllllIlIllIIlllI * llllllllllllllllIllllIlIllIlIllI] = 4;
                    }
                    else {
                        llllllllllllllllIllllIlIllIIllll[llllllllllllllllIllllIlIllIIllIl + llllllllllllllllIllllIlIllIIlllI * llllllllllllllllIllllIlIllIlIllI] = 0;
                    }
                }
                else if (llllllllllllllllIllllIlIllIIlIII > 0 && (llllllllllllllllIllllIlIllIIllII == 0 || llllllllllllllllIllllIlIllIIlIll == 0 || llllllllllllllllIllllIlIllIIlIlI == 0 || llllllllllllllllIllllIlIllIIlIIl == 0)) {
                    if (this.nextInt(5) == 0) {
                        if (llllllllllllllllIllllIlIllIIlIII == 4) {
                            llllllllllllllllIllllIlIllIIllll[llllllllllllllllIllllIlIllIIllIl + llllllllllllllllIllllIlIllIIlllI * llllllllllllllllIllllIlIllIlIllI] = 4;
                        }
                        else {
                            llllllllllllllllIllllIlIllIIllll[llllllllllllllllIllllIlIllIIllIl + llllllllllllllllIllllIlIllIIlllI * llllllllllllllllIllllIlIllIlIllI] = 0;
                        }
                    }
                    else {
                        llllllllllllllllIllllIlIllIIllll[llllllllllllllllIllllIlIllIIllIl + llllllllllllllllIllllIlIllIIlllI * llllllllllllllllIllllIlIllIlIllI] = llllllllllllllllIllllIlIllIIlIII;
                    }
                }
                else {
                    llllllllllllllllIllllIlIllIIllll[llllllllllllllllIllllIlIllIIllIl + llllllllllllllllIllllIlIllIIlllI * llllllllllllllllIllllIlIllIlIllI] = llllllllllllllllIllllIlIllIIlIII;
                }
            }
        }
        return llllllllllllllllIllllIlIllIIllll;
    }
}
