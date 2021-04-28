package net.minecraft.world.gen;

import java.util.*;
import net.minecraft.util.*;

public class NoiseGeneratorOctaves extends NoiseGenerator
{
    private /* synthetic */ NoiseGeneratorImproved[] generatorCollection;
    private /* synthetic */ int octaves;
    
    public NoiseGeneratorOctaves(final Random lllllllllllllllIIIlIIlIIIlIllIlI, final int lllllllllllllllIIIlIIlIIIlIllIIl) {
        this.octaves = lllllllllllllllIIIlIIlIIIlIllIIl;
        this.generatorCollection = new NoiseGeneratorImproved[lllllllllllllllIIIlIIlIIIlIllIIl];
        for (int lllllllllllllllIIIlIIlIIIlIllIII = 0; lllllllllllllllIIIlIIlIIIlIllIII < lllllllllllllllIIIlIIlIIIlIllIIl; ++lllllllllllllllIIIlIIlIIIlIllIII) {
            this.generatorCollection[lllllllllllllllIIIlIIlIIIlIllIII] = new NoiseGeneratorImproved(lllllllllllllllIIIlIIlIIIlIllIlI);
        }
    }
    
    public double[] generateNoiseOctaves(final double[] lllllllllllllllIIIlIIlIIIIIIlIlI, final int lllllllllllllllIIIlIIlIIIIIIlIIl, final int lllllllllllllllIIIlIIlIIIIIIlIII, final int lllllllllllllllIIIlIIlIIIIIIIlll, final int lllllllllllllllIIIlIIlIIIIIIllll, final double lllllllllllllllIIIlIIlIIIIIIIlIl, final double lllllllllllllllIIIlIIlIIIIIIllIl, final double lllllllllllllllIIIlIIlIIIIIIllII) {
        return this.generateNoiseOctaves(lllllllllllllllIIIlIIlIIIIIIlIlI, lllllllllllllllIIIlIIlIIIIIIlIIl, 10, lllllllllllllllIIIlIIlIIIIIIlIII, lllllllllllllllIIIlIIlIIIIIIIlll, 1, lllllllllllllllIIIlIIlIIIIIIllll, lllllllllllllllIIIlIIlIIIIIIIlIl, 1.0, lllllllllllllllIIIlIIlIIIIIIllIl);
    }
    
    public double[] generateNoiseOctaves(double[] lllllllllllllllIIIlIIlIIIIlIllIl, final int lllllllllllllllIIIlIIlIIIIlIllII, final int lllllllllllllllIIIlIIlIIIIlIlIll, final int lllllllllllllllIIIlIIlIIIIlIlIlI, final int lllllllllllllllIIIlIIlIIIIllllII, final int lllllllllllllllIIIlIIlIIIIlIlIII, final int lllllllllllllllIIIlIIlIIIIlIIlll, final double lllllllllllllllIIIlIIlIIIIlllIIl, final double lllllllllllllllIIIlIIlIIIIlIIlIl, final double lllllllllllllllIIIlIIlIIIIllIlll) {
        if (lllllllllllllllIIIlIIlIIIIlIllIl == null) {
            lllllllllllllllIIIlIIlIIIIlIllIl = new double[lllllllllllllllIIIlIIlIIIIllllII * lllllllllllllllIIIlIIlIIIIlIlIII * lllllllllllllllIIIlIIlIIIIlIIlll];
        }
        else {
            for (int lllllllllllllllIIIlIIlIIIIllIllI = 0; lllllllllllllllIIIlIIlIIIIllIllI < lllllllllllllllIIIlIIlIIIIlIllIl.length; ++lllllllllllllllIIIlIIlIIIIllIllI) {
                lllllllllllllllIIIlIIlIIIIlIllIl[lllllllllllllllIIIlIIlIIIIllIllI] = 0.0;
            }
        }
        double lllllllllllllllIIIlIIlIIIIllIlIl = 1.0;
        for (int lllllllllllllllIIIlIIlIIIIllIlII = 0; lllllllllllllllIIIlIIlIIIIllIlII < this.octaves; ++lllllllllllllllIIIlIIlIIIIllIlII) {
            double lllllllllllllllIIIlIIlIIIIllIIll = lllllllllllllllIIIlIIlIIIIlIllII * lllllllllllllllIIIlIIlIIIIllIlIl * lllllllllllllllIIIlIIlIIIIlllIIl;
            final double lllllllllllllllIIIlIIlIIIIllIIlI = lllllllllllllllIIIlIIlIIIIlIlIll * lllllllllllllllIIIlIIlIIIIllIlIl * lllllllllllllllIIIlIIlIIIIlIIlIl;
            double lllllllllllllllIIIlIIlIIIIllIIIl = lllllllllllllllIIIlIIlIIIIlIlIlI * lllllllllllllllIIIlIIlIIIIllIlIl * lllllllllllllllIIIlIIlIIIIllIlll;
            long lllllllllllllllIIIlIIlIIIIllIIII = MathHelper.floor_double_long(lllllllllllllllIIIlIIlIIIIllIIll);
            long lllllllllllllllIIIlIIlIIIIlIllll = MathHelper.floor_double_long(lllllllllllllllIIIlIIlIIIIllIIIl);
            lllllllllllllllIIIlIIlIIIIllIIll -= lllllllllllllllIIIlIIlIIIIllIIII;
            lllllllllllllllIIIlIIlIIIIllIIIl -= lllllllllllllllIIIlIIlIIIIlIllll;
            lllllllllllllllIIIlIIlIIIIllIIII %= 16777216L;
            lllllllllllllllIIIlIIlIIIIlIllll %= 16777216L;
            lllllllllllllllIIIlIIlIIIIllIIll += lllllllllllllllIIIlIIlIIIIllIIII;
            lllllllllllllllIIIlIIlIIIIllIIIl += lllllllllllllllIIIlIIlIIIIlIllll;
            this.generatorCollection[lllllllllllllllIIIlIIlIIIIllIlII].populateNoiseArray((double[])lllllllllllllllIIIlIIlIIIIlIllIl, lllllllllllllllIIIlIIlIIIIllIIll, lllllllllllllllIIIlIIlIIIIllIIlI, lllllllllllllllIIIlIIlIIIIllIIIl, lllllllllllllllIIIlIIlIIIIllllII, lllllllllllllllIIIlIIlIIIIlIlIII, lllllllllllllllIIIlIIlIIIIlIIlll, lllllllllllllllIIIlIIlIIIIlllIIl * lllllllllllllllIIIlIIlIIIIllIlIl, lllllllllllllllIIIlIIlIIIIlIIlIl * lllllllllllllllIIIlIIlIIIIllIlIl, lllllllllllllllIIIlIIlIIIIllIlll * lllllllllllllllIIIlIIlIIIIllIlIl, lllllllllllllllIIIlIIlIIIIllIlIl);
            lllllllllllllllIIIlIIlIIIIllIlIl /= 2.0;
        }
        return (double[])lllllllllllllllIIIlIIlIIIIlIllIl;
    }
    
    static {
        __OBFID = "CL_00000535";
    }
}
