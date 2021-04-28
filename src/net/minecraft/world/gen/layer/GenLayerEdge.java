package net.minecraft.world.gen.layer;

public class GenLayerEdge extends GenLayer
{
    private final /* synthetic */ Mode field_151627_c;
    
    public GenLayerEdge(final long llllllllllllllIlIIllIllIlIIlIlII, final GenLayer llllllllllllllIlIIllIllIlIIlIIll, final Mode llllllllllllllIlIIllIllIlIIlIIlI) {
        super(llllllllllllllIlIIllIllIlIIlIlII);
        this.parent = llllllllllllllIlIIllIllIlIIlIIll;
        this.field_151627_c = llllllllllllllIlIIllIllIlIIlIIlI;
    }
    
    @Override
    public int[] getInts(final int llllllllllllllIlIIllIllIlIIIIIlI, final int llllllllllllllIlIIllIllIIllllIII, final int llllllllllllllIlIIllIllIIlllIlll, final int llllllllllllllIlIIllIllIIlllllIl) {
        switch (SwitchMode.field_151642_a[this.field_151627_c.ordinal()]) {
            default: {
                return this.getIntsCoolWarm(llllllllllllllIlIIllIllIlIIIIIlI, llllllllllllllIlIIllIllIIllllIII, llllllllllllllIlIIllIllIIlllIlll, llllllllllllllIlIIllIllIIlllllIl);
            }
            case 2: {
                return this.getIntsHeatIce(llllllllllllllIlIIllIllIlIIIIIlI, llllllllllllllIlIIllIllIIllllIII, llllllllllllllIlIIllIllIIlllIlll, llllllllllllllIlIIllIllIIlllllIl);
            }
            case 3: {
                return this.getIntsSpecial(llllllllllllllIlIIllIllIlIIIIIlI, llllllllllllllIlIIllIllIIllllIII, llllllllllllllIlIIllIllIIlllIlll, llllllllllllllIlIIllIllIIlllllIl);
            }
        }
    }
    
    static {
        __OBFID = "CL_00000547";
    }
    
    private int[] getIntsSpecial(final int llllllllllllllIlIIllIlIllllIIIII, final int llllllllllllllIlIIllIlIlllIlllll, final int llllllllllllllIlIIllIlIlllIllllI, final int llllllllllllllIlIIllIlIlllIlllIl) {
        final int[] llllllllllllllIlIIllIlIllllIIllI = this.parent.getInts(llllllllllllllIlIIllIlIllllIIIII, llllllllllllllIlIIllIlIlllIlllll, llllllllllllllIlIIllIlIlllIllllI, llllllllllllllIlIIllIlIlllIlllIl);
        final int[] llllllllllllllIlIIllIlIllllIIlIl = IntCache.getIntCache(llllllllllllllIlIIllIlIlllIllllI * llllllllllllllIlIIllIlIlllIlllIl);
        for (int llllllllllllllIlIIllIlIllllIIlII = 0; llllllllllllllIlIIllIlIllllIIlII < llllllllllllllIlIIllIlIlllIlllIl; ++llllllllllllllIlIIllIlIllllIIlII) {
            for (int llllllllllllllIlIIllIlIllllIIIll = 0; llllllllllllllIlIIllIlIllllIIIll < llllllllllllllIlIIllIlIlllIllllI; ++llllllllllllllIlIIllIlIllllIIIll) {
                this.initChunkSeed(llllllllllllllIlIIllIlIllllIIIll + llllllllllllllIlIIllIlIllllIIIII, llllllllllllllIlIIllIlIllllIIlII + llllllllllllllIlIIllIlIlllIlllll);
                int llllllllllllllIlIIllIlIllllIIIlI = llllllllllllllIlIIllIlIllllIIllI[llllllllllllllIlIIllIlIllllIIIll + llllllllllllllIlIIllIlIllllIIlII * llllllllllllllIlIIllIlIlllIllllI];
                if (llllllllllllllIlIIllIlIllllIIIlI != 0 && this.nextInt(13) == 0) {
                    llllllllllllllIlIIllIlIllllIIIlI |= (1 + this.nextInt(15) << 8 & 0xF00);
                }
                llllllllllllllIlIIllIlIllllIIlIl[llllllllllllllIlIIllIlIllllIIIll + llllllllllllllIlIIllIlIllllIIlII * llllllllllllllIlIIllIlIlllIllllI] = llllllllllllllIlIIllIlIllllIIIlI;
            }
        }
        return llllllllllllllIlIIllIlIllllIIlIl;
    }
    
    private int[] getIntsHeatIce(final int llllllllllllllIlIIllIllIIIIIlIII, final int llllllllllllllIlIIllIllIIIIIIlll, final int llllllllllllllIlIIllIllIIIIIIllI, final int llllllllllllllIlIIllIllIIIIllIIl) {
        final int llllllllllllllIlIIllIllIIIIllIII = llllllllllllllIlIIllIllIIIIIlIII - 1;
        final int llllllllllllllIlIIllIllIIIIlIlll = llllllllllllllIlIIllIllIIIIIIlll - 1;
        final int llllllllllllllIlIIllIllIIIIlIllI = 1 + llllllllllllllIlIIllIllIIIIIIllI + 1;
        final int llllllllllllllIlIIllIllIIIIlIlIl = 1 + llllllllllllllIlIIllIllIIIIllIIl + 1;
        final int[] llllllllllllllIlIIllIllIIIIlIlII = this.parent.getInts(llllllllllllllIlIIllIllIIIIllIII, llllllllllllllIlIIllIllIIIIlIlll, llllllllllllllIlIIllIllIIIIlIllI, llllllllllllllIlIIllIllIIIIlIlIl);
        final int[] llllllllllllllIlIIllIllIIIIlIIll = IntCache.getIntCache(llllllllllllllIlIIllIllIIIIIIllI * llllllllllllllIlIIllIllIIIIllIIl);
        for (int llllllllllllllIlIIllIllIIIIlIIlI = 0; llllllllllllllIlIIllIllIIIIlIIlI < llllllllllllllIlIIllIllIIIIllIIl; ++llllllllllllllIlIIllIllIIIIlIIlI) {
            for (int llllllllllllllIlIIllIllIIIIlIIIl = 0; llllllllllllllIlIIllIllIIIIlIIIl < llllllllllllllIlIIllIllIIIIIIllI; ++llllllllllllllIlIIllIllIIIIlIIIl) {
                int llllllllllllllIlIIllIllIIIIlIIII = llllllllllllllIlIIllIllIIIIlIlII[llllllllllllllIlIIllIllIIIIlIIIl + 1 + (llllllllllllllIlIIllIllIIIIlIIlI + 1) * llllllllllllllIlIIllIllIIIIlIllI];
                if (llllllllllllllIlIIllIllIIIIlIIII == 4) {
                    final int llllllllllllllIlIIllIllIIIIIllll = llllllllllllllIlIIllIllIIIIlIlII[llllllllllllllIlIIllIllIIIIlIIIl + 1 + (llllllllllllllIlIIllIllIIIIlIIlI + 1 - 1) * llllllllllllllIlIIllIllIIIIlIllI];
                    final int llllllllllllllIlIIllIllIIIIIlllI = llllllllllllllIlIIllIllIIIIlIlII[llllllllllllllIlIIllIllIIIIlIIIl + 1 + 1 + (llllllllllllllIlIIllIllIIIIlIIlI + 1) * llllllllllllllIlIIllIllIIIIlIllI];
                    final int llllllllllllllIlIIllIllIIIIIllIl = llllllllllllllIlIIllIllIIIIlIlII[llllllllllllllIlIIllIllIIIIlIIIl + 1 - 1 + (llllllllllllllIlIIllIllIIIIlIIlI + 1) * llllllllllllllIlIIllIllIIIIlIllI];
                    final int llllllllllllllIlIIllIllIIIIIllII = llllllllllllllIlIIllIllIIIIlIlII[llllllllllllllIlIIllIllIIIIlIIIl + 1 + (llllllllllllllIlIIllIllIIIIlIIlI + 1 + 1) * llllllllllllllIlIIllIllIIIIlIllI];
                    final boolean llllllllllllllIlIIllIllIIIIIlIll = llllllllllllllIlIIllIllIIIIIllll == 2 || llllllllllllllIlIIllIllIIIIIlllI == 2 || llllllllllllllIlIIllIllIIIIIllIl == 2 || llllllllllllllIlIIllIllIIIIIllII == 2;
                    final boolean llllllllllllllIlIIllIllIIIIIlIlI = llllllllllllllIlIIllIllIIIIIllll == 1 || llllllllllllllIlIIllIllIIIIIlllI == 1 || llllllllllllllIlIIllIllIIIIIllIl == 1 || llllllllllllllIlIIllIllIIIIIllII == 1;
                    if (llllllllllllllIlIIllIllIIIIIlIlI || llllllllllllllIlIIllIllIIIIIlIll) {
                        llllllllllllllIlIIllIllIIIIlIIII = 3;
                    }
                }
                llllllllllllllIlIIllIllIIIIlIIll[llllllllllllllIlIIllIllIIIIlIIIl + llllllllllllllIlIIllIllIIIIlIIlI * llllllllllllllIlIIllIllIIIIIIllI] = llllllllllllllIlIIllIllIIIIlIIII;
            }
        }
        return llllllllllllllIlIIllIllIIIIlIIll;
    }
    
    private int[] getIntsCoolWarm(final int llllllllllllllIlIIllIllIIlIllIII, final int llllllllllllllIlIIllIllIIlIIIIll, final int llllllllllllllIlIIllIllIIlIIIIlI, final int llllllllllllllIlIIllIllIIlIIIIIl) {
        final int llllllllllllllIlIIllIllIIlIlIlII = llllllllllllllIlIIllIllIIlIllIII - 1;
        final int llllllllllllllIlIIllIllIIlIlIIll = llllllllllllllIlIIllIllIIlIIIIll - 1;
        final int llllllllllllllIlIIllIllIIlIlIIlI = 1 + llllllllllllllIlIIllIllIIlIIIIlI + 1;
        final int llllllllllllllIlIIllIllIIlIlIIIl = 1 + llllllllllllllIlIIllIllIIlIIIIIl + 1;
        final int[] llllllllllllllIlIIllIllIIlIlIIII = this.parent.getInts(llllllllllllllIlIIllIllIIlIlIlII, llllllllllllllIlIIllIllIIlIlIIll, llllllllllllllIlIIllIllIIlIlIIlI, llllllllllllllIlIIllIllIIlIlIIIl);
        final int[] llllllllllllllIlIIllIllIIlIIllll = IntCache.getIntCache(llllllllllllllIlIIllIllIIlIIIIlI * llllllllllllllIlIIllIllIIlIIIIIl);
        for (int llllllllllllllIlIIllIllIIlIIlllI = 0; llllllllllllllIlIIllIllIIlIIlllI < llllllllllllllIlIIllIllIIlIIIIIl; ++llllllllllllllIlIIllIllIIlIIlllI) {
            for (int llllllllllllllIlIIllIllIIlIIllIl = 0; llllllllllllllIlIIllIllIIlIIllIl < llllllllllllllIlIIllIllIIlIIIIlI; ++llllllllllllllIlIIllIllIIlIIllIl) {
                this.initChunkSeed(llllllllllllllIlIIllIllIIlIIllIl + llllllllllllllIlIIllIllIIlIllIII, llllllllllllllIlIIllIllIIlIIlllI + llllllllllllllIlIIllIllIIlIIIIll);
                int llllllllllllllIlIIllIllIIlIIllII = llllllllllllllIlIIllIllIIlIlIIII[llllllllllllllIlIIllIllIIlIIllIl + 1 + (llllllllllllllIlIIllIllIIlIIlllI + 1) * llllllllllllllIlIIllIllIIlIlIIlI];
                if (llllllllllllllIlIIllIllIIlIIllII == 1) {
                    final int llllllllllllllIlIIllIllIIlIIlIll = llllllllllllllIlIIllIllIIlIlIIII[llllllllllllllIlIIllIllIIlIIllIl + 1 + (llllllllllllllIlIIllIllIIlIIlllI + 1 - 1) * llllllllllllllIlIIllIllIIlIlIIlI];
                    final int llllllllllllllIlIIllIllIIlIIlIlI = llllllllllllllIlIIllIllIIlIlIIII[llllllllllllllIlIIllIllIIlIIllIl + 1 + 1 + (llllllllllllllIlIIllIllIIlIIlllI + 1) * llllllllllllllIlIIllIllIIlIlIIlI];
                    final int llllllllllllllIlIIllIllIIlIIlIIl = llllllllllllllIlIIllIllIIlIlIIII[llllllllllllllIlIIllIllIIlIIllIl + 1 - 1 + (llllllllllllllIlIIllIllIIlIIlllI + 1) * llllllllllllllIlIIllIllIIlIlIIlI];
                    final int llllllllllllllIlIIllIllIIlIIlIII = llllllllllllllIlIIllIllIIlIlIIII[llllllllllllllIlIIllIllIIlIIllIl + 1 + (llllllllllllllIlIIllIllIIlIIlllI + 1 + 1) * llllllllllllllIlIIllIllIIlIlIIlI];
                    final boolean llllllllllllllIlIIllIllIIlIIIlll = llllllllllllllIlIIllIllIIlIIlIll == 3 || llllllllllllllIlIIllIllIIlIIlIlI == 3 || llllllllllllllIlIIllIllIIlIIlIIl == 3 || llllllllllllllIlIIllIllIIlIIlIII == 3;
                    final boolean llllllllllllllIlIIllIllIIlIIIllI = llllllllllllllIlIIllIllIIlIIlIll == 4 || llllllllllllllIlIIllIllIIlIIlIlI == 4 || llllllllllllllIlIIllIllIIlIIlIIl == 4 || llllllllllllllIlIIllIllIIlIIlIII == 4;
                    if (llllllllllllllIlIIllIllIIlIIIlll || llllllllllllllIlIIllIllIIlIIIllI) {
                        llllllllllllllIlIIllIllIIlIIllII = 2;
                    }
                }
                llllllllllllllIlIIllIllIIlIIllll[llllllllllllllIlIIllIllIIlIIllIl + llllllllllllllIlIIllIllIIlIIlllI * llllllllllllllIlIIllIllIIlIIIIlI] = llllllllllllllIlIIllIllIIlIIllII;
            }
        }
        return llllllllllllllIlIIllIllIIlIIllll;
    }
    
    static final class SwitchMode
    {
        static final /* synthetic */ int[] field_151642_a;
        
        static {
            __OBFID = "CL_00000548";
            field_151642_a = new int[Mode.values().length];
            try {
                SwitchMode.field_151642_a[Mode.COOL_WARM.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchMode.field_151642_a[Mode.HEAT_ICE.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchMode.field_151642_a[Mode.SPECIAL.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
        }
    }
    
    public enum Mode
    {
        COOL_WARM("COOL_WARM", 0, "COOL_WARM", 0), 
        HEAT_ICE("HEAT_ICE", 1, "HEAT_ICE", 1), 
        SPECIAL("SPECIAL", 2, "SPECIAL", 2);
        
        private Mode(final String llllllllllllllllIllllIlIIllIIlll, final int llllllllllllllllIllllIlIIllIIllI, final String llllllllllllllllIllllIlIIllIlIlI, final int llllllllllllllllIllllIlIIllIlIIl) {
        }
        
        static {
            __OBFID = "CL_00000549";
        }
    }
}
