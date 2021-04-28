package net.minecraft.world.gen;

import java.util.*;

public class NoiseGeneratorSimplex
{
    private static final /* synthetic */ double field_151609_g;
    private /* synthetic */ int[] field_151608_f;
    private static final /* synthetic */ double field_151615_h;
    private static /* synthetic */ int[][] field_151611_e;
    public /* synthetic */ double field_151610_d;
    public /* synthetic */ double field_151612_b;
    public static final /* synthetic */ double field_151614_a;
    public /* synthetic */ double field_151613_c;
    
    public double func_151605_a(final double lllllllllllllllIlIllIlIIIllIllll, final double lllllllllllllllIlIllIlIIIllIlllI) {
        final double lllllllllllllllIlIllIlIIIllIllIl = 0.5 * (NoiseGeneratorSimplex.field_151614_a - 1.0);
        final double lllllllllllllllIlIllIlIIIllIllII = (lllllllllllllllIlIllIlIIIllIllll + lllllllllllllllIlIllIlIIIllIlllI) * lllllllllllllllIlIllIlIIIllIllIl;
        final int lllllllllllllllIlIllIlIIIllIlIll = func_151607_a(lllllllllllllllIlIllIlIIIllIllll + lllllllllllllllIlIllIlIIIllIllII);
        final int lllllllllllllllIlIllIlIIIllIlIlI = func_151607_a(lllllllllllllllIlIllIlIIIllIlllI + lllllllllllllllIlIllIlIIIllIllII);
        final double lllllllllllllllIlIllIlIIIllIlIIl = (3.0 - NoiseGeneratorSimplex.field_151614_a) / 6.0;
        final double lllllllllllllllIlIllIlIIIllIlIII = (lllllllllllllllIlIllIlIIIllIlIll + lllllllllllllllIlIllIlIIIllIlIlI) * lllllllllllllllIlIllIlIIIllIlIIl;
        final double lllllllllllllllIlIllIlIIIllIIlll = lllllllllllllllIlIllIlIIIllIlIll - lllllllllllllllIlIllIlIIIllIlIII;
        final double lllllllllllllllIlIllIlIIIllIIllI = lllllllllllllllIlIllIlIIIllIlIlI - lllllllllllllllIlIllIlIIIllIlIII;
        final double lllllllllllllllIlIllIlIIIllIIlIl = lllllllllllllllIlIllIlIIIllIllll - lllllllllllllllIlIllIlIIIllIIlll;
        final double lllllllllllllllIlIllIlIIIllIIlII = lllllllllllllllIlIllIlIIIllIlllI - lllllllllllllllIlIllIlIIIllIIllI;
        byte lllllllllllllllIlIllIlIIIllIIIlI = 0;
        byte lllllllllllllllIlIllIlIIIllIIIII = 0;
        if (lllllllllllllllIlIllIlIIIllIIlIl > lllllllllllllllIlIllIlIIIllIIlII) {
            final byte lllllllllllllllIlIllIlIIIllIIIll = 1;
            final byte lllllllllllllllIlIllIlIIIllIIIIl = 0;
        }
        else {
            lllllllllllllllIlIllIlIIIllIIIlI = 0;
            lllllllllllllllIlIllIlIIIllIIIII = 1;
        }
        final double lllllllllllllllIlIllIlIIIlIlllll = lllllllllllllllIlIllIlIIIllIIlIl - lllllllllllllllIlIllIlIIIllIIIlI + lllllllllllllllIlIllIlIIIllIlIIl;
        final double lllllllllllllllIlIllIlIIIlIllllI = lllllllllllllllIlIllIlIIIllIIlII - lllllllllllllllIlIllIlIIIllIIIII + lllllllllllllllIlIllIlIIIllIlIIl;
        final double lllllllllllllllIlIllIlIIIlIlllIl = lllllllllllllllIlIllIlIIIllIIlIl - 1.0 + 2.0 * lllllllllllllllIlIllIlIIIllIlIIl;
        final double lllllllllllllllIlIllIlIIIlIlllII = lllllllllllllllIlIllIlIIIllIIlII - 1.0 + 2.0 * lllllllllllllllIlIllIlIIIllIlIIl;
        final int lllllllllllllllIlIllIlIIIlIllIll = lllllllllllllllIlIllIlIIIllIlIll & 0xFF;
        final int lllllllllllllllIlIllIlIIIlIllIlI = lllllllllllllllIlIllIlIIIllIlIlI & 0xFF;
        final int lllllllllllllllIlIllIlIIIlIllIIl = this.field_151608_f[lllllllllllllllIlIllIlIIIlIllIll + this.field_151608_f[lllllllllllllllIlIllIlIIIlIllIlI]] % 12;
        final int lllllllllllllllIlIllIlIIIlIllIII = this.field_151608_f[lllllllllllllllIlIllIlIIIlIllIll + lllllllllllllllIlIllIlIIIllIIIlI + this.field_151608_f[lllllllllllllllIlIllIlIIIlIllIlI + lllllllllllllllIlIllIlIIIllIIIII]] % 12;
        final int lllllllllllllllIlIllIlIIIlIlIlll = this.field_151608_f[lllllllllllllllIlIllIlIIIlIllIll + 1 + this.field_151608_f[lllllllllllllllIlIllIlIIIlIllIlI + 1]] % 12;
        double lllllllllllllllIlIllIlIIIlIlIllI = 0.5 - lllllllllllllllIlIllIlIIIllIIlIl * lllllllllllllllIlIllIlIIIllIIlIl - lllllllllllllllIlIllIlIIIllIIlII * lllllllllllllllIlIllIlIIIllIIlII;
        double lllllllllllllllIlIllIlIIIlIlIlII = 0.0;
        if (lllllllllllllllIlIllIlIIIlIlIllI < 0.0) {
            final double lllllllllllllllIlIllIlIIIlIlIlIl = 0.0;
        }
        else {
            lllllllllllllllIlIllIlIIIlIlIllI *= lllllllllllllllIlIllIlIIIlIlIllI;
            lllllllllllllllIlIllIlIIIlIlIlII = lllllllllllllllIlIllIlIIIlIlIllI * lllllllllllllllIlIllIlIIIlIlIllI * func_151604_a(NoiseGeneratorSimplex.field_151611_e[lllllllllllllllIlIllIlIIIlIllIIl], lllllllllllllllIlIllIlIIIllIIlIl, lllllllllllllllIlIllIlIIIllIIlII);
        }
        double lllllllllllllllIlIllIlIIIlIlIIll = 0.5 - lllllllllllllllIlIllIlIIIlIlllll * lllllllllllllllIlIllIlIIIlIlllll - lllllllllllllllIlIllIlIIIlIllllI * lllllllllllllllIlIllIlIIIlIllllI;
        double lllllllllllllllIlIllIlIIIlIlIIIl = 0.0;
        if (lllllllllllllllIlIllIlIIIlIlIIll < 0.0) {
            final double lllllllllllllllIlIllIlIIIlIlIIlI = 0.0;
        }
        else {
            lllllllllllllllIlIllIlIIIlIlIIll *= lllllllllllllllIlIllIlIIIlIlIIll;
            lllllllllllllllIlIllIlIIIlIlIIIl = lllllllllllllllIlIllIlIIIlIlIIll * lllllllllllllllIlIllIlIIIlIlIIll * func_151604_a(NoiseGeneratorSimplex.field_151611_e[lllllllllllllllIlIllIlIIIlIllIII], lllllllllllllllIlIllIlIIIlIlllll, lllllllllllllllIlIllIlIIIlIllllI);
        }
        double lllllllllllllllIlIllIlIIIlIlIIII = 0.5 - lllllllllllllllIlIllIlIIIlIlllIl * lllllllllllllllIlIllIlIIIlIlllIl - lllllllllllllllIlIllIlIIIlIlllII * lllllllllllllllIlIllIlIIIlIlllII;
        double lllllllllllllllIlIllIlIIIlIIlllI = 0.0;
        if (lllllllllllllllIlIllIlIIIlIlIIII < 0.0) {
            final double lllllllllllllllIlIllIlIIIlIIllll = 0.0;
        }
        else {
            lllllllllllllllIlIllIlIIIlIlIIII *= lllllllllllllllIlIllIlIIIlIlIIII;
            lllllllllllllllIlIllIlIIIlIIlllI = lllllllllllllllIlIllIlIIIlIlIIII * lllllllllllllllIlIllIlIIIlIlIIII * func_151604_a(NoiseGeneratorSimplex.field_151611_e[lllllllllllllllIlIllIlIIIlIlIlll], lllllllllllllllIlIllIlIIIlIlllIl, lllllllllllllllIlIllIlIIIlIlllII);
        }
        return 70.0 * (lllllllllllllllIlIllIlIIIlIlIlII + lllllllllllllllIlIllIlIIIlIlIIIl + lllllllllllllllIlIllIlIIIlIIlllI);
    }
    
    private static double func_151604_a(final int[] lllllllllllllllIlIllIlIIlIIlIIIl, final double lllllllllllllllIlIllIlIIlIIlIIll, final double lllllllllllllllIlIllIlIIlIIIllll) {
        return lllllllllllllllIlIllIlIIlIIlIIIl[0] * lllllllllllllllIlIllIlIIlIIlIIll + lllllllllllllllIlIllIlIIlIIlIIIl[1] * lllllllllllllllIlIllIlIIlIIIllll;
    }
    
    public void func_151606_a(final double[] lllllllllllllllIlIllIIllllIllIIl, final double lllllllllllllllIlIllIIllllIllIII, final double lllllllllllllllIlIllIlIIIIIIIlII, final int lllllllllllllllIlIllIIllllIlIllI, final int lllllllllllllllIlIllIIllllIlIlIl, final double lllllllllllllllIlIllIIllllIlIlII, final double lllllllllllllllIlIllIIllllIlIIll, final double lllllllllllllllIlIllIIllllIlIIlI) {
        int lllllllllllllllIlIllIIlllllllllI = 0;
        for (int lllllllllllllllIlIllIIllllllllIl = 0; lllllllllllllllIlIllIIllllllllIl < lllllllllllllllIlIllIIllllIlIlIl; ++lllllllllllllllIlIllIIllllllllIl) {
            final double lllllllllllllllIlIllIIllllllllII = (lllllllllllllllIlIllIlIIIIIIIlII + lllllllllllllllIlIllIIllllllllIl) * lllllllllllllllIlIllIIllllIlIIll + this.field_151613_c;
            for (int lllllllllllllllIlIllIIlllllllIll = 0; lllllllllllllllIlIllIIlllllllIll < lllllllllllllllIlIllIIllllIlIllI; ++lllllllllllllllIlIllIIlllllllIll) {
                final double lllllllllllllllIlIllIIlllllllIlI = (lllllllllllllllIlIllIIllllIllIII + lllllllllllllllIlIllIIlllllllIll) * lllllllllllllllIlIllIIllllIlIlII + this.field_151612_b;
                final double lllllllllllllllIlIllIIlllllllIIl = (lllllllllllllllIlIllIIlllllllIlI + lllllllllllllllIlIllIIllllllllII) * NoiseGeneratorSimplex.field_151609_g;
                final int lllllllllllllllIlIllIIlllllllIII = func_151607_a(lllllllllllllllIlIllIIlllllllIlI + lllllllllllllllIlIllIIlllllllIIl);
                final int lllllllllllllllIlIllIIllllllIlll = func_151607_a(lllllllllllllllIlIllIIllllllllII + lllllllllllllllIlIllIIlllllllIIl);
                final double lllllllllllllllIlIllIIllllllIllI = (lllllllllllllllIlIllIIlllllllIII + lllllllllllllllIlIllIIllllllIlll) * NoiseGeneratorSimplex.field_151615_h;
                final double lllllllllllllllIlIllIIllllllIlIl = lllllllllllllllIlIllIIlllllllIII - lllllllllllllllIlIllIIllllllIllI;
                final double lllllllllllllllIlIllIIllllllIlII = lllllllllllllllIlIllIIllllllIlll - lllllllllllllllIlIllIIllllllIllI;
                final double lllllllllllllllIlIllIIllllllIIll = lllllllllllllllIlIllIIlllllllIlI - lllllllllllllllIlIllIIllllllIlIl;
                final double lllllllllllllllIlIllIIllllllIIlI = lllllllllllllllIlIllIIllllllllII - lllllllllllllllIlIllIIllllllIlII;
                byte lllllllllllllllIlIllIIllllllIIII = 0;
                byte lllllllllllllllIlIllIIlllllIlllI = 0;
                if (lllllllllllllllIlIllIIllllllIIll > lllllllllllllllIlIllIIllllllIIlI) {
                    final byte lllllllllllllllIlIllIIllllllIIIl = 1;
                    final byte lllllllllllllllIlIllIIlllllIllll = 0;
                }
                else {
                    lllllllllllllllIlIllIIllllllIIII = 0;
                    lllllllllllllllIlIllIIlllllIlllI = 1;
                }
                final double lllllllllllllllIlIllIIlllllIllIl = lllllllllllllllIlIllIIllllllIIll - lllllllllllllllIlIllIIllllllIIII + NoiseGeneratorSimplex.field_151615_h;
                final double lllllllllllllllIlIllIIlllllIllII = lllllllllllllllIlIllIIllllllIIlI - lllllllllllllllIlIllIIlllllIlllI + NoiseGeneratorSimplex.field_151615_h;
                final double lllllllllllllllIlIllIIlllllIlIll = lllllllllllllllIlIllIIllllllIIll - 1.0 + 2.0 * NoiseGeneratorSimplex.field_151615_h;
                final double lllllllllllllllIlIllIIlllllIlIlI = lllllllllllllllIlIllIIllllllIIlI - 1.0 + 2.0 * NoiseGeneratorSimplex.field_151615_h;
                final int lllllllllllllllIlIllIIlllllIlIIl = lllllllllllllllIlIllIIlllllllIII & 0xFF;
                final int lllllllllllllllIlIllIIlllllIlIII = lllllllllllllllIlIllIIllllllIlll & 0xFF;
                final int lllllllllllllllIlIllIIlllllIIlll = this.field_151608_f[lllllllllllllllIlIllIIlllllIlIIl + this.field_151608_f[lllllllllllllllIlIllIIlllllIlIII]] % 12;
                final int lllllllllllllllIlIllIIlllllIIllI = this.field_151608_f[lllllllllllllllIlIllIIlllllIlIIl + lllllllllllllllIlIllIIllllllIIII + this.field_151608_f[lllllllllllllllIlIllIIlllllIlIII + lllllllllllllllIlIllIIlllllIlllI]] % 12;
                final int lllllllllllllllIlIllIIlllllIIlIl = this.field_151608_f[lllllllllllllllIlIllIIlllllIlIIl + 1 + this.field_151608_f[lllllllllllllllIlIllIIlllllIlIII + 1]] % 12;
                double lllllllllllllllIlIllIIlllllIIlII = 0.5 - lllllllllllllllIlIllIIllllllIIll * lllllllllllllllIlIllIIllllllIIll - lllllllllllllllIlIllIIllllllIIlI * lllllllllllllllIlIllIIllllllIIlI;
                double lllllllllllllllIlIllIIlllllIIIlI = 0.0;
                if (lllllllllllllllIlIllIIlllllIIlII < 0.0) {
                    final double lllllllllllllllIlIllIIlllllIIIll = 0.0;
                }
                else {
                    lllllllllllllllIlIllIIlllllIIlII *= lllllllllllllllIlIllIIlllllIIlII;
                    lllllllllllllllIlIllIIlllllIIIlI = lllllllllllllllIlIllIIlllllIIlII * lllllllllllllllIlIllIIlllllIIlII * func_151604_a(NoiseGeneratorSimplex.field_151611_e[lllllllllllllllIlIllIIlllllIIlll], lllllllllllllllIlIllIIllllllIIll, lllllllllllllllIlIllIIllllllIIlI);
                }
                double lllllllllllllllIlIllIIlllllIIIIl = 0.5 - lllllllllllllllIlIllIIlllllIllIl * lllllllllllllllIlIllIIlllllIllIl - lllllllllllllllIlIllIIlllllIllII * lllllllllllllllIlIllIIlllllIllII;
                double lllllllllllllllIlIllIIllllIlllll = 0.0;
                if (lllllllllllllllIlIllIIlllllIIIIl < 0.0) {
                    final double lllllllllllllllIlIllIIlllllIIIII = 0.0;
                }
                else {
                    lllllllllllllllIlIllIIlllllIIIIl *= lllllllllllllllIlIllIIlllllIIIIl;
                    lllllllllllllllIlIllIIllllIlllll = lllllllllllllllIlIllIIlllllIIIIl * lllllllllllllllIlIllIIlllllIIIIl * func_151604_a(NoiseGeneratorSimplex.field_151611_e[lllllllllllllllIlIllIIlllllIIllI], lllllllllllllllIlIllIIlllllIllIl, lllllllllllllllIlIllIIlllllIllII);
                }
                double lllllllllllllllIlIllIIllllIllllI = 0.5 - lllllllllllllllIlIllIIlllllIlIll * lllllllllllllllIlIllIIlllllIlIll - lllllllllllllllIlIllIIlllllIlIlI * lllllllllllllllIlIllIIlllllIlIlI;
                double lllllllllllllllIlIllIIllllIlllII = 0.0;
                if (lllllllllllllllIlIllIIllllIllllI < 0.0) {
                    final double lllllllllllllllIlIllIIllllIlllIl = 0.0;
                }
                else {
                    lllllllllllllllIlIllIIllllIllllI *= lllllllllllllllIlIllIIllllIllllI;
                    lllllllllllllllIlIllIIllllIlllII = lllllllllllllllIlIllIIllllIllllI * lllllllllllllllIlIllIIllllIllllI * func_151604_a(NoiseGeneratorSimplex.field_151611_e[lllllllllllllllIlIllIIlllllIIlIl], lllllllllllllllIlIllIIlllllIlIll, lllllllllllllllIlIllIIlllllIlIlI);
                }
                final int n;
                final int lllllllllllllllIlIllIIllllIllIll = n = lllllllllllllllIlIllIIlllllllllI++;
                lllllllllllllllIlIllIIllllIllIIl[n] += 70.0 * (lllllllllllllllIlIllIIlllllIIIlI + lllllllllllllllIlIllIIllllIlllll + lllllllllllllllIlIllIIllllIlllII) * lllllllllllllllIlIllIIllllIlIIlI;
            }
        }
    }
    
    private static int func_151607_a(final double lllllllllllllllIlIllIlIIlIIllIIl) {
        return (lllllllllllllllIlIllIlIIlIIllIIl > 0.0) ? ((int)lllllllllllllllIlIllIlIIlIIllIIl) : ((int)lllllllllllllllIlIllIlIIlIIllIIl - 1);
    }
    
    public NoiseGeneratorSimplex() {
        this(new Random());
    }
    
    static {
        __OBFID = "CL_00000537";
        NoiseGeneratorSimplex.field_151611_e = new int[][] { { 1, 1, 0 }, { -1, 1, 0 }, { 1, -1, 0 }, { -1, -1, 0 }, { 1, 0, 1 }, { -1, 0, 1 }, { 1, 0, -1 }, { -1, 0, -1 }, { 0, 1, 1 }, { 0, -1, 1 }, { 0, 1, -1 }, { 0, -1, -1 } };
        field_151614_a = Math.sqrt(3.0);
        field_151609_g = 0.5 * (NoiseGeneratorSimplex.field_151614_a - 1.0);
        field_151615_h = (3.0 - NoiseGeneratorSimplex.field_151614_a) / 6.0;
    }
    
    public NoiseGeneratorSimplex(final Random lllllllllllllllIlIllIlIIlIIllllI) {
        this.field_151608_f = new int[512];
        this.field_151612_b = lllllllllllllllIlIllIlIIlIIllllI.nextDouble() * 256.0;
        this.field_151613_c = lllllllllllllllIlIllIlIIlIIllllI.nextDouble() * 256.0;
        this.field_151610_d = lllllllllllllllIlIllIlIIlIIllllI.nextDouble() * 256.0;
        for (int lllllllllllllllIlIllIlIIlIlIIIlI = 0; lllllllllllllllIlIllIlIIlIlIIIlI < 256; this.field_151608_f[lllllllllllllllIlIllIlIIlIlIIIlI] = lllllllllllllllIlIllIlIIlIlIIIlI++) {}
        for (int lllllllllllllllIlIllIlIIlIlIIIlI = 0; lllllllllllllllIlIllIlIIlIlIIIlI < 256; ++lllllllllllllllIlIllIlIIlIlIIIlI) {
            final int lllllllllllllllIlIllIlIIlIlIIIIl = lllllllllllllllIlIllIlIIlIIllllI.nextInt(256 - lllllllllllllllIlIllIlIIlIlIIIlI) + lllllllllllllllIlIllIlIIlIlIIIlI;
            final int lllllllllllllllIlIllIlIIlIlIIIII = this.field_151608_f[lllllllllllllllIlIllIlIIlIlIIIlI];
            this.field_151608_f[lllllllllllllllIlIllIlIIlIlIIIlI] = this.field_151608_f[lllllllllllllllIlIllIlIIlIlIIIIl];
            this.field_151608_f[lllllllllllllllIlIllIlIIlIlIIIIl] = lllllllllllllllIlIllIlIIlIlIIIII;
            this.field_151608_f[lllllllllllllllIlIllIlIIlIlIIIlI + 256] = this.field_151608_f[lllllllllllllllIlIllIlIIlIlIIIlI];
        }
    }
}
