package net.minecraft.world.gen;

import java.util.*;

public class NoiseGeneratorPerlin extends NoiseGenerator
{
    private /* synthetic */ int field_151602_b;
    private /* synthetic */ NoiseGeneratorSimplex[] field_151603_a;
    
    public double[] func_151600_a(double[] llllllllllllllIllllIIIIIllIllIll, final double llllllllllllllIllllIIIIIlllIlIII, final double llllllllllllllIllllIIIIIlllIIlll, final int llllllllllllllIllllIIIIIllIllIII, final int llllllllllllllIllllIIIIIllIlIlll, final double llllllllllllllIllllIIIIIlllIIlII, final double llllllllllllllIllllIIIIIllIlIlIl, final double llllllllllllllIllllIIIIIlllIIIlI, final double llllllllllllllIllllIIIIIllIlIIll) {
        if (llllllllllllllIllllIIIIIllIllIll != null && llllllllllllllIllllIIIIIllIllIll.length >= llllllllllllllIllllIIIIIllIllIII * llllllllllllllIllllIIIIIllIlIlll) {
            for (int llllllllllllllIllllIIIIIlllIIIII = 0; llllllllllllllIllllIIIIIlllIIIII < llllllllllllllIllllIIIIIllIllIll.length; ++llllllllllllllIllllIIIIIlllIIIII) {
                llllllllllllllIllllIIIIIllIllIll[llllllllllllllIllllIIIIIlllIIIII] = 0.0;
            }
        }
        else {
            llllllllllllllIllllIIIIIllIllIll = new double[llllllllllllllIllllIIIIIllIllIII * llllllllllllllIllllIIIIIllIlIlll];
        }
        double llllllllllllllIllllIIIIIllIlllll = 1.0;
        double llllllllllllllIllllIIIIIllIllllI = 1.0;
        for (int llllllllllllllIllllIIIIIllIlllIl = 0; llllllllllllllIllllIIIIIllIlllIl < this.field_151602_b; ++llllllllllllllIllllIIIIIllIlllIl) {
            this.field_151603_a[llllllllllllllIllllIIIIIllIlllIl].func_151606_a(llllllllllllllIllllIIIIIllIllIll, llllllllllllllIllllIIIIIlllIlIII, llllllllllllllIllllIIIIIlllIIlll, llllllllllllllIllllIIIIIllIllIII, llllllllllllllIllllIIIIIllIlIlll, llllllllllllllIllllIIIIIlllIIlII * llllllllllllllIllllIIIIIllIllllI * llllllllllllllIllllIIIIIllIlllll, llllllllllllllIllllIIIIIllIlIlIl * llllllllllllllIllllIIIIIllIllllI * llllllllllllllIllllIIIIIllIlllll, 0.55 / llllllllllllllIllllIIIIIllIlllll);
            llllllllllllllIllllIIIIIllIllllI *= llllllllllllllIllllIIIIIlllIIIlI;
            llllllllllllllIllllIIIIIllIlllll *= llllllllllllllIllllIIIIIllIlIIll;
        }
        return llllllllllllllIllllIIIIIllIllIll;
    }
    
    public double func_151601_a(final double llllllllllllllIllllIIIIlIIIlllIl, final double llllllllllllllIllllIIIIlIIIlIllI) {
        double llllllllllllllIllllIIIIlIIIllIll = 0.0;
        double llllllllllllllIllllIIIIlIIIllIlI = 1.0;
        for (int llllllllllllllIllllIIIIlIIIllIIl = 0; llllllllllllllIllllIIIIlIIIllIIl < this.field_151602_b; ++llllllllllllllIllllIIIIlIIIllIIl) {
            llllllllllllllIllllIIIIlIIIllIll += this.field_151603_a[llllllllllllllIllllIIIIlIIIllIIl].func_151605_a(llllllllllllllIllllIIIIlIIIlllIl * llllllllllllllIllllIIIIlIIIllIlI, llllllllllllllIllllIIIIlIIIlIllI * llllllllllllllIllllIIIIlIIIllIlI) / llllllllllllllIllllIIIIlIIIllIlI;
            llllllllllllllIllllIIIIlIIIllIlI /= 2.0;
        }
        return llllllllllllllIllllIIIIlIIIllIll;
    }
    
    public NoiseGeneratorPerlin(final Random llllllllllllllIllllIIIIlIIlIlIll, final int llllllllllllllIllllIIIIlIIlIIllI) {
        this.field_151602_b = llllllllllllllIllllIIIIlIIlIIllI;
        this.field_151603_a = new NoiseGeneratorSimplex[llllllllllllllIllllIIIIlIIlIIllI];
        for (int llllllllllllllIllllIIIIlIIlIlIIl = 0; llllllllllllllIllllIIIIlIIlIlIIl < llllllllllllllIllllIIIIlIIlIIllI; ++llllllllllllllIllllIIIIlIIlIlIIl) {
            this.field_151603_a[llllllllllllllIllllIIIIlIIlIlIIl] = new NoiseGeneratorSimplex(llllllllllllllIllllIIIIlIIlIlIll);
        }
    }
    
    static {
        __OBFID = "CL_00000536";
    }
    
    public double[] func_151599_a(final double[] llllllllllllllIllllIIIIlIIIIlIII, final double llllllllllllllIllllIIIIIlllllllI, final double llllllllllllllIllllIIIIIllllllIl, final int llllllllllllllIllllIIIIlIIIIIlIl, final int llllllllllllllIllllIIIIIlllllIll, final double llllllllllllllIllllIIIIIlllllIlI, final double llllllllllllllIllllIIIIlIIIIIIlI, final double llllllllllllllIllllIIIIIlllllIII) {
        return this.func_151600_a(llllllllllllllIllllIIIIlIIIIlIII, llllllllllllllIllllIIIIIlllllllI, llllllllllllllIllllIIIIIllllllIl, llllllllllllllIllllIIIIlIIIIIlIl, llllllllllllllIllllIIIIIlllllIll, llllllllllllllIllllIIIIIlllllIlI, llllllllllllllIllllIIIIlIIIIIIlI, llllllllllllllIllllIIIIIlllllIII, 0.5);
    }
}
