package net.minecraft.world.gen;

import java.util.*;

public class NoiseGeneratorImproved extends NoiseGenerator
{
    private static final /* synthetic */ double[] field_152381_e;
    private static final /* synthetic */ double[] field_152385_i;
    private /* synthetic */ int[] permutations;
    public /* synthetic */ double xCoord;
    private static final /* synthetic */ double[] field_152383_g;
    private static final /* synthetic */ double[] field_152382_f;
    public /* synthetic */ double yCoord;
    public /* synthetic */ double zCoord;
    private static final /* synthetic */ double[] field_152384_h;
    
    public NoiseGeneratorImproved() {
        this(new Random());
    }
    
    public final double grad(final int lIIlllIIIIlIllI, final double lIIlllIIIIllIlI, final double lIIlllIIIIlIlII, final double lIIlllIIIIlIIll) {
        final int lIIlllIIIIlIlll = lIIlllIIIIlIllI & 0xF;
        return NoiseGeneratorImproved.field_152381_e[lIIlllIIIIlIlll] * lIIlllIIIIllIlI + NoiseGeneratorImproved.field_152382_f[lIIlllIIIIlIlll] * lIIlllIIIIlIlII + NoiseGeneratorImproved.field_152383_g[lIIlllIIIIlIlll] * lIIlllIIIIlIIll;
    }
    
    public final double func_76309_a(final int lIIlllIIIlIlIIl, final double lIIlllIIIlIIlII, final double lIIlllIIIlIIlll) {
        final int lIIlllIIIlIIllI = lIIlllIIIlIlIIl & 0xF;
        return NoiseGeneratorImproved.field_152384_h[lIIlllIIIlIIllI] * lIIlllIIIlIIlII + NoiseGeneratorImproved.field_152385_i[lIIlllIIIlIIllI] * lIIlllIIIlIIlll;
    }
    
    public void populateNoiseArray(final double[] lIIllIlllIllllI, final double lIIllIllIIlIIll, final double lIIllIllIIlIIlI, final double lIIllIllIIlIIIl, final int lIIllIlllIllIlI, final int lIIllIllIIIllll, final int lIIllIllIIIlllI, final double lIIllIlllIlIlll, final double lIIllIllIIIllII, final double lIIllIlllIlIlIl, final double lIIllIllIIIlIlI) {
        if (lIIllIllIIIllll == 1) {
            final boolean lIIllIllIllllIl = false;
            final boolean lIIllIllIllllII = false;
            final boolean lIIllIllIlllIll = false;
            final boolean lIIllIllIlllIlI = false;
            double lIIllIllIlllIIl = 0.0;
            double lIIllIllIlllIII = 0.0;
            int lIIllIlllIIIIIl = 0;
            final double lIIllIllIllIlll = 1.0 / lIIllIllIIIlIlI;
            for (int lIIllIllIllIllI = 0; lIIllIllIllIllI < lIIllIlllIllIlI; ++lIIllIllIllIllI) {
                double lIIllIlllIIllll = lIIllIllIIlIIll + lIIllIllIllIllI * lIIllIlllIlIlll + this.xCoord;
                int lIIllIllIllIlIl = (int)lIIllIlllIIllll;
                if (lIIllIlllIIllll < lIIllIllIllIlIl) {
                    --lIIllIllIllIlIl;
                }
                final int lIIllIllIllIlII = lIIllIllIllIlIl & 0xFF;
                lIIllIlllIIllll -= lIIllIllIllIlIl;
                final double lIIllIlllIIllIl = lIIllIlllIIllll * lIIllIlllIIllll * lIIllIlllIIllll * (lIIllIlllIIllll * (lIIllIlllIIllll * 6.0 - 15.0) + 10.0);
                for (int lIIllIlllIIlIll = 0; lIIllIlllIIlIll < lIIllIllIIIlllI; ++lIIllIlllIIlIll) {
                    double lIIllIlllIIlIIl = lIIllIllIIlIIIl + lIIllIlllIIlIll * lIIllIlllIlIlIl + this.zCoord;
                    int lIIllIlllIIIlll = (int)lIIllIlllIIlIIl;
                    if (lIIllIlllIIlIIl < lIIllIlllIIIlll) {
                        --lIIllIlllIIIlll;
                    }
                    final int lIIllIlllIIIlIl = lIIllIlllIIIlll & 0xFF;
                    lIIllIlllIIlIIl -= lIIllIlllIIIlll;
                    final double lIIllIlllIIIIll = lIIllIlllIIlIIl * lIIllIlllIIlIIl * lIIllIlllIIlIIl * (lIIllIlllIIlIIl * (lIIllIlllIIlIIl * 6.0 - 15.0) + 10.0);
                    final int lIIllIlllIlIIll = this.permutations[lIIllIllIllIlII] + 0;
                    final int lIIllIllIllIIll = this.permutations[lIIllIlllIlIIll] + lIIllIlllIIIlIl;
                    final int lIIllIllIllIIlI = this.permutations[lIIllIllIllIlII + 1] + 0;
                    final int lIIllIlllIlIIIl = this.permutations[lIIllIllIllIIlI] + lIIllIlllIIIlIl;
                    lIIllIllIlllIIl = this.lerp(lIIllIlllIIllIl, this.func_76309_a(this.permutations[lIIllIllIllIIll], lIIllIlllIIllll, lIIllIlllIIlIIl), this.grad(this.permutations[lIIllIlllIlIIIl], lIIllIlllIIllll - 1.0, 0.0, lIIllIlllIIlIIl));
                    lIIllIllIlllIII = this.lerp(lIIllIlllIIllIl, this.grad(this.permutations[lIIllIllIllIIll + 1], lIIllIlllIIllll, 0.0, lIIllIlllIIlIIl - 1.0), this.grad(this.permutations[lIIllIlllIlIIIl + 1], lIIllIlllIIllll - 1.0, 0.0, lIIllIlllIIlIIl - 1.0));
                    final double lIIllIllIllIIIl = this.lerp(lIIllIlllIIIIll, lIIllIllIlllIIl, lIIllIllIlllIII);
                    final int n;
                    final int lIIllIllIllllll = n = lIIllIlllIIIIIl++;
                    lIIllIlllIllllI[n] += lIIllIllIllIIIl * lIIllIllIllIlll;
                }
            }
        }
        else {
            int lIIllIlllIlIIlI = 0;
            final double lIIllIllIllIIII = 1.0 / lIIllIllIIIlIlI;
            int lIIllIlllIlIIII = -1;
            final boolean lIIllIllIlIllll = false;
            final boolean lIIllIllIlIlllI = false;
            final boolean lIIllIllIlIllIl = false;
            final boolean lIIllIllIlIllII = false;
            final boolean lIIllIllIlIlIll = false;
            final boolean lIIllIllIlIlIlI = false;
            double lIIllIllIlIlIIl = 0.0;
            double lIIllIlllIIlllI = 0.0;
            double lIIllIllIlIlIII = 0.0;
            double lIIllIlllIIllII = 0.0;
            for (int lIIllIlllIIlIlI = 0; lIIllIlllIIlIlI < lIIllIlllIllIlI; ++lIIllIlllIIlIlI) {
                double lIIllIlllIIlIII = lIIllIllIIlIIll + lIIllIlllIIlIlI * lIIllIlllIlIlll + this.xCoord;
                int lIIllIlllIIIllI = (int)lIIllIlllIIlIII;
                if (lIIllIlllIIlIII < lIIllIlllIIIllI) {
                    --lIIllIlllIIIllI;
                }
                final int lIIllIlllIIIlII = lIIllIlllIIIllI & 0xFF;
                lIIllIlllIIlIII -= lIIllIlllIIIllI;
                final double lIIllIlllIIIIlI = lIIllIlllIIlIII * lIIllIlllIIlIII * lIIllIlllIIlIII * (lIIllIlllIIlIII * (lIIllIlllIIlIII * 6.0 - 15.0) + 10.0);
                for (int lIIllIllIlIIlll = 0; lIIllIllIlIIlll < lIIllIllIIIlllI; ++lIIllIllIlIIlll) {
                    double lIIllIllIlIIllI = lIIllIllIIlIIIl + lIIllIllIlIIlll * lIIllIlllIlIlIl + this.zCoord;
                    int lIIllIllIlIIlIl = (int)lIIllIllIlIIllI;
                    if (lIIllIllIlIIllI < lIIllIllIlIIlIl) {
                        --lIIllIllIlIIlIl;
                    }
                    final int lIIllIllIlIIlII = lIIllIllIlIIlIl & 0xFF;
                    lIIllIllIlIIllI -= lIIllIllIlIIlIl;
                    final double lIIllIllIlIIIll = lIIllIllIlIIllI * lIIllIllIlIIllI * lIIllIllIlIIllI * (lIIllIllIlIIllI * (lIIllIllIlIIllI * 6.0 - 15.0) + 10.0);
                    for (int lIIllIllIlIIIlI = 0; lIIllIllIlIIIlI < lIIllIllIIIllll; ++lIIllIllIlIIIlI) {
                        double lIIllIllIlIIIIl = lIIllIllIIlIIlI + lIIllIllIlIIIlI * lIIllIllIIIllII + this.yCoord;
                        int lIIllIllIlIIIII = (int)lIIllIllIlIIIIl;
                        if (lIIllIllIlIIIIl < lIIllIllIlIIIII) {
                            --lIIllIllIlIIIII;
                        }
                        final int lIIllIllIIlllll = lIIllIllIlIIIII & 0xFF;
                        lIIllIllIlIIIIl -= lIIllIllIlIIIII;
                        final double lIIllIllIIllllI = lIIllIllIlIIIIl * lIIllIllIlIIIIl * lIIllIllIlIIIIl * (lIIllIllIlIIIIl * (lIIllIllIlIIIIl * 6.0 - 15.0) + 10.0);
                        if (lIIllIllIlIIIlI == 0 || lIIllIllIIlllll != lIIllIlllIlIIII) {
                            lIIllIlllIlIIII = lIIllIllIIlllll;
                            final int lIIllIllIIlllIl = this.permutations[lIIllIlllIIIlII] + lIIllIllIIlllll;
                            final int lIIllIllIIlllII = this.permutations[lIIllIllIIlllIl] + lIIllIllIlIIlII;
                            final int lIIllIllIIllIll = this.permutations[lIIllIllIIlllIl + 1] + lIIllIllIlIIlII;
                            final int lIIllIllIIllIlI = this.permutations[lIIllIlllIIIlII + 1] + lIIllIllIIlllll;
                            final int lIIllIlllIIIIII = this.permutations[lIIllIllIIllIlI] + lIIllIllIlIIlII;
                            final int lIIllIllIIllIIl = this.permutations[lIIllIllIIllIlI + 1] + lIIllIllIlIIlII;
                            lIIllIllIlIlIIl = this.lerp(lIIllIlllIIIIlI, this.grad(this.permutations[lIIllIllIIlllII], lIIllIlllIIlIII, lIIllIllIlIIIIl, lIIllIllIlIIllI), this.grad(this.permutations[lIIllIlllIIIIII], lIIllIlllIIlIII - 1.0, lIIllIllIlIIIIl, lIIllIllIlIIllI));
                            lIIllIlllIIlllI = this.lerp(lIIllIlllIIIIlI, this.grad(this.permutations[lIIllIllIIllIll], lIIllIlllIIlIII, lIIllIllIlIIIIl - 1.0, lIIllIllIlIIllI), this.grad(this.permutations[lIIllIllIIllIIl], lIIllIlllIIlIII - 1.0, lIIllIllIlIIIIl - 1.0, lIIllIllIlIIllI));
                            lIIllIllIlIlIII = this.lerp(lIIllIlllIIIIlI, this.grad(this.permutations[lIIllIllIIlllII + 1], lIIllIlllIIlIII, lIIllIllIlIIIIl, lIIllIllIlIIllI - 1.0), this.grad(this.permutations[lIIllIlllIIIIII + 1], lIIllIlllIIlIII - 1.0, lIIllIllIlIIIIl, lIIllIllIlIIllI - 1.0));
                            lIIllIlllIIllII = this.lerp(lIIllIlllIIIIlI, this.grad(this.permutations[lIIllIllIIllIll + 1], lIIllIlllIIlIII, lIIllIllIlIIIIl - 1.0, lIIllIllIlIIllI - 1.0), this.grad(this.permutations[lIIllIllIIllIIl + 1], lIIllIlllIIlIII - 1.0, lIIllIllIlIIIIl - 1.0, lIIllIllIlIIllI - 1.0));
                        }
                        final double lIIllIllIIllIII = this.lerp(lIIllIllIIllllI, lIIllIllIlIlIIl, lIIllIlllIIlllI);
                        final double lIIllIllIIlIlll = this.lerp(lIIllIllIIllllI, lIIllIllIlIlIII, lIIllIlllIIllII);
                        final double lIIllIllIIlIllI = this.lerp(lIIllIllIlIIIll, lIIllIllIIllIII, lIIllIllIIlIlll);
                        final int n2;
                        final int lIIllIllIlllllI = n2 = lIIllIlllIlIIlI++;
                        lIIllIlllIllllI[n2] += lIIllIllIIlIllI * lIIllIllIllIIII;
                    }
                }
            }
        }
    }
    
    static {
        __OBFID = "CL_00000534";
        field_152381_e = new double[] { 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, -1.0, 0.0 };
        field_152382_f = new double[] { 1.0, 1.0, -1.0, -1.0, 0.0, 0.0, 0.0, 0.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0 };
        field_152383_g = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, -1.0, -1.0, 1.0, 1.0, -1.0, -1.0, 0.0, 1.0, 0.0, -1.0 };
        field_152384_h = new double[] { 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, -1.0, 0.0 };
        field_152385_i = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, -1.0, -1.0, 1.0, 1.0, -1.0, -1.0, 0.0, 1.0, 0.0, -1.0 };
    }
    
    public NoiseGeneratorImproved(final Random lIIlllIIlIIIIIl) {
        this.permutations = new int[512];
        this.xCoord = lIIlllIIlIIIIIl.nextDouble() * 256.0;
        this.yCoord = lIIlllIIlIIIIIl.nextDouble() * 256.0;
        this.zCoord = lIIlllIIlIIIIIl.nextDouble() * 256.0;
        for (int lIIlllIIlIIIIII = 0; lIIlllIIlIIIIII < 256; this.permutations[lIIlllIIlIIIIII] = lIIlllIIlIIIIII++) {}
        for (int lIIlllIIlIIIIII = 0; lIIlllIIlIIIIII < 256; ++lIIlllIIlIIIIII) {
            final int lIIlllIIIllllll = lIIlllIIlIIIIIl.nextInt(256 - lIIlllIIlIIIIII) + lIIlllIIlIIIIII;
            final int lIIlllIIIlllllI = this.permutations[lIIlllIIlIIIIII];
            this.permutations[lIIlllIIlIIIIII] = this.permutations[lIIlllIIIllllll];
            this.permutations[lIIlllIIIllllll] = lIIlllIIIlllllI;
            this.permutations[lIIlllIIlIIIIII + 256] = this.permutations[lIIlllIIlIIIIII];
        }
    }
    
    public final double lerp(final double lIIlllIIIllIIIl, final double lIIlllIIIllIIII, final double lIIlllIIIlIllll) {
        return lIIlllIIIllIIII + lIIlllIIIllIIIl * (lIIlllIIIlIllll - lIIlllIIIllIIII);
    }
}
