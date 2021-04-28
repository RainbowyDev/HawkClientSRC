package net.minecraft.util;

import java.util.*;

public class MathHelper
{
    private static final /* synthetic */ float[] SIN_TABLE;
    private static final /* synthetic */ float[] SIN_TABLE_FAST;
    public static /* synthetic */ boolean fastMath;
    private static final /* synthetic */ int[] multiplyDeBruijnBitPosition;
    
    public static float clamp_float(final float llllllllllllllIlllIIIlIIIIlIllll, final float llllllllllllllIlllIIIlIIIIlIlllI, final float llllllllllllllIlllIIIlIIIIlIllIl) {
        return (llllllllllllllIlllIIIlIIIIlIllll < llllllllllllllIlllIIIlIIIIlIlllI) ? llllllllllllllIlllIIIlIIIIlIlllI : ((llllllllllllllIlllIIIlIIIIlIllll > llllllllllllllIlllIIIlIIIIlIllIl) ? llllllllllllllIlllIIIlIIIIlIllIl : llllllllllllllIlllIIIlIIIIlIllll);
    }
    
    public static double getRandomDoubleInRange(final Random llllllllllllllIlllIIIIllllllIIll, final double llllllllllllllIlllIIIIllllllIIlI, final double llllllllllllllIlllIIIIllllllIIIl) {
        return (llllllllllllllIlllIIIIllllllIIlI >= llllllllllllllIlllIIIIllllllIIIl) ? llllllllllllllIlllIIIIllllllIIlI : (llllllllllllllIlllIIIIllllllIIll.nextDouble() * (llllllllllllllIlllIIIIllllllIIIl - llllllllllllllIlllIIIIllllllIIlI) + llllllllllllllIlllIIIIllllllIIlI);
    }
    
    public static int abs_int(final int llllllllllllllIlllIIIlIIIlIIlIII) {
        return (llllllllllllllIlllIIIlIIIlIIlIII >= 0) ? llllllllllllllIlllIIIlIIIlIIlIII : (-llllllllllllllIlllIIIlIIIlIIlIII);
    }
    
    public static long floor_double_long(final double llllllllllllllIlllIIIlIIIlIlIlII) {
        final long llllllllllllllIlllIIIlIIIlIlIIll = (long)llllllllllllllIlllIIIlIIIlIlIlII;
        return (llllllllllllllIlllIIIlIIIlIlIlII < llllllllllllllIlllIIIlIIIlIlIIll) ? (llllllllllllllIlllIIIlIIIlIlIIll - 1L) : llllllllllllllIlllIIIlIIIlIlIIll;
    }
    
    public static int func_180181_b(final int llllllllllllllIlllIIIIlllIIIIIll, final int llllllllllllllIlllIIIIlllIIIIIlI, final int llllllllllllllIlllIIIIlllIIIIIIl) {
        int llllllllllllllIlllIIIIlllIIIIIII = (llllllllllllllIlllIIIIlllIIIIIll << 8) + llllllllllllllIlllIIIIlllIIIIIlI;
        llllllllllllllIlllIIIIlllIIIIIII = (llllllllllllllIlllIIIIlllIIIIIII << 8) + llllllllllllllIlllIIIIlllIIIIIIl;
        return llllllllllllllIlllIIIIlllIIIIIII;
    }
    
    public static float abs(final float llllllllllllllIlllIIIlIIIlIIllII) {
        return (llllllllllllllIlllIIIlIIIlIIllII >= 0.0f) ? llllllllllllllIlllIIIlIIIlIIllII : (-llllllllllllllIlllIIIlIIIlIIllII);
    }
    
    public static int ceiling_double_int(final double llllllllllllllIlllIIIlIIIIllllIl) {
        final int llllllllllllllIlllIIIlIIIIlllllI = (int)llllllllllllllIlllIIIlIIIIllllIl;
        return (llllllllllllllIlllIIIlIIIIllllIl > llllllllllllllIlllIIIlIIIIlllllI) ? (llllllllllllllIlllIIIlIIIIlllllI + 1) : llllllllllllllIlllIIIlIIIIlllllI;
    }
    
    public static int func_180183_b(final float llllllllllllllIlllIIIIlllIIIlIlI, final float llllllllllllllIlllIIIIlllIIIllII, final float llllllllllllllIlllIIIIlllIIIlIII) {
        return func_180181_b(floor_float(llllllllllllllIlllIIIIlllIIIlIlI * 255.0f), floor_float(llllllllllllllIlllIIIIlllIIIllII * 255.0f), floor_float(llllllllllllllIlllIIIIlllIIIlIII * 255.0f));
    }
    
    public static long func_180187_c(final int llllllllllllllIlllIIIIllIlIlIIll, final int llllllllllllllIlllIIIIllIlIlIIlI, final int llllllllllllllIlllIIIIllIlIIllIl) {
        long llllllllllllllIlllIIIIllIlIlIIII = (long)(llllllllllllllIlllIIIIllIlIlIIll * 3129871) ^ llllllllllllllIlllIIIIllIlIIllIl * 116129781L ^ (long)llllllllllllllIlllIIIIllIlIlIIlI;
        llllllllllllllIlllIIIIllIlIlIIII = llllllllllllllIlllIIIIllIlIlIIII * llllllllllllllIlllIIIIllIlIlIIII * 42317861L + llllllllllllllIlllIIIIllIlIlIIII * 11L;
        return llllllllllllllIlllIIIIllIlIlIIII;
    }
    
    public static double parseDoubleWithDefaultAndMax(final String llllllllllllllIlllIIIIlllIlIlIll, final double llllllllllllllIlllIIIIlllIlIllIl, final double llllllllllllllIlllIIIIlllIlIlIIl) {
        return Math.max(llllllllllllllIlllIIIIlllIlIlIIl, parseDoubleWithDefault(llllllllllllllIlllIIIIlllIlIlIll, llllllllllllllIlllIIIIlllIlIllIl));
    }
    
    public static long func_180186_a(final Vec3i llllllllllllllIlllIIIIllIlIllIII) {
        return func_180187_c(llllllllllllllIlllIIIIllIlIllIII.getX(), llllllllllllllIlllIIIIllIlIllIII.getY(), llllllllllllllIlllIIIIllIlIllIII.getZ());
    }
    
    public static float randomFloatClamp(final Random llllllllllllllIlllIIIIllllllllII, final float llllllllllllllIlllIIIIlllllllIll, final float llllllllllllllIlllIIIIlllllllIlI) {
        return (llllllllllllllIlllIIIIlllllllIll >= llllllllllllllIlllIIIIlllllllIlI) ? llllllllllllllIlllIIIIlllllllIll : (llllllllllllllIlllIIIIllllllllII.nextFloat() * (llllllllllllllIlllIIIIlllllllIlI - llllllllllllllIlllIIIIlllllllIll) + llllllllllllllIlllIIIIlllllllIll);
    }
    
    public static int bucketInt(final int llllllllllllllIlllIIIlIIIIIIllll, final int llllllllllllllIlllIIIlIIIIIIlllI) {
        return (llllllllllllllIlllIIIlIIIIIIllll < 0) ? (-((-llllllllllllllIlllIIIlIIIIIIllll - 1) / llllllllllllllIlllIIIlIIIIIIlllI) - 1) : (llllllllllllllIlllIIIlIIIIIIllll / llllllllllllllIlllIIIlIIIIIIlllI);
    }
    
    public static int truncateDoubleToInt(final double llllllllllllllIlllIIIlIIIlIlllIl) {
        return (int)(llllllllllllllIlllIIIlIIIlIlllIl + 1024.0) - 1024;
    }
    
    public static int roundUpToPowerOfTwo(final int llllllllllllllIlllIIIIlllIlIIllI) {
        int llllllllllllllIlllIIIIlllIlIIlIl = llllllllllllllIlllIIIIlllIlIIllI - 1;
        llllllllllllllIlllIIIIlllIlIIlIl |= llllllllllllllIlllIIIIlllIlIIlIl >> 1;
        llllllllllllllIlllIIIIlllIlIIlIl |= llllllllllllllIlllIIIIlllIlIIlIl >> 2;
        llllllllllllllIlllIIIIlllIlIIlIl |= llllllllllllllIlllIIIIlllIlIIlIl >> 4;
        llllllllllllllIlllIIIIlllIlIIlIl |= llllllllllllllIlllIIIIlllIlIIlIl >> 8;
        llllllllllllllIlllIIIIlllIlIIlIl |= llllllllllllllIlllIIIIlllIlIIlIl >> 16;
        return llllllllllllllIlllIIIIlllIlIIlIl + 1;
    }
    
    public static boolean func_180185_a(final float llllllllllllllIlllIIIIllllIllIlI, final float llllllllllllllIlllIIIIllllIllIIl) {
        return abs(llllllllllllllIlllIIIIllllIllIIl - llllllllllllllIlllIIIIllllIllIlI) < 1.0E-5f;
    }
    
    public static int ceiling_float_int(final float llllllllllllllIlllIIIlIIIlIIIlIl) {
        final int llllllllllllllIlllIIIlIIIlIIIlII = (int)llllllllllllllIlllIIIlIIIlIIIlIl;
        return (llllllllllllllIlllIIIlIIIlIIIlIl > llllllllllllllIlllIIIlIIIlIIIlII) ? (llllllllllllllIlllIIIlIIIlIIIlII + 1) : llllllllllllllIlllIIIlIIIlIIIlII;
    }
    
    public static int getRandomIntegerInRange(final Random llllllllllllllIlllIIIlIIIIIIIlIl, final int llllllllllllllIlllIIIlIIIIIIIlll, final int llllllllllllllIlllIIIlIIIIIIIllI) {
        return (llllllllllllllIlllIIIlIIIIIIIlll >= llllllllllllllIlllIIIlIIIIIIIllI) ? llllllllllllllIlllIIIlIIIIIIIlll : (llllllllllllllIlllIIIlIIIIIIIlIl.nextInt(llllllllllllllIlllIIIlIIIIIIIllI - llllllllllllllIlllIIIlIIIIIIIlll + 1) + llllllllllllllIlllIIIlIIIIIIIlll);
    }
    
    public static int floor_float(final float llllllllllllllIlllIIIlIIIllIIIll) {
        final int llllllllllllllIlllIIIlIIIllIIIlI = (int)llllllllllllllIlllIIIlIIIllIIIll;
        return (llllllllllllllIlllIIIlIIIllIIIll < llllllllllllllIlllIIIlIIIllIIIlI) ? (llllllllllllllIlllIIIlIIIllIIIlI - 1) : llllllllllllllIlllIIIlIIIllIIIlI;
    }
    
    public static double abs_max(double llllllllllllllIlllIIIlIIIIIlIIll, double llllllllllllllIlllIIIlIIIIIlIIlI) {
        if (llllllllllllllIlllIIIlIIIIIlIIll < 0.0) {
            llllllllllllllIlllIIIlIIIIIlIIll = -llllllllllllllIlllIIIlIIIIIlIIll;
        }
        if (llllllllllllllIlllIIIlIIIIIlIIlI < 0.0) {
            llllllllllllllIlllIIIlIIIIIlIIlI = -llllllllllllllIlllIIIlIIIIIlIIlI;
        }
        return (llllllllllllllIlllIIIlIIIIIlIIll > llllllllllllllIlllIIIlIIIIIlIIlI) ? llllllllllllllIlllIIIlIIIIIlIIll : llllllllllllllIlllIIIlIIIIIlIIlI;
    }
    
    public static int calculateLogBaseTwo(final int llllllllllllllIlllIIIIlllIIllIlI) {
        return calculateLogBaseTwoDeBruijn(llllllllllllllIlllIIIIlllIIllIlI) - (isPowerOfTwo(llllllllllllllIlllIIIIlllIIllIlI) ? 0 : 1);
    }
    
    public static int func_180188_d(final int llllllllllllllIlllIIIIllIlllIIII, final int llllllllllllllIlllIIIIllIllIllll) {
        final int llllllllllllllIlllIIIIllIllIlllI = (llllllllllllllIlllIIIIllIlllIIII & 0xFF0000) >> 16;
        final int llllllllllllllIlllIIIIllIllIllIl = (llllllllllllllIlllIIIIllIllIllll & 0xFF0000) >> 16;
        final int llllllllllllllIlllIIIIllIllIllII = (llllllllllllllIlllIIIIllIlllIIII & 0xFF00) >> 8;
        final int llllllllllllllIlllIIIIllIllIlIll = (llllllllllllllIlllIIIIllIllIllll & 0xFF00) >> 8;
        final int llllllllllllllIlllIIIIllIllIlIlI = (llllllllllllllIlllIIIIllIlllIIII & 0xFF) >> 0;
        final int llllllllllllllIlllIIIIllIllIlIIl = (llllllllllllllIlllIIIIllIllIllll & 0xFF) >> 0;
        final int llllllllllllllIlllIIIIllIllIlIII = (int)(llllllllllllllIlllIIIIllIllIlllI * (float)llllllllllllllIlllIIIIllIllIllIl / 255.0f);
        final int llllllllllllllIlllIIIIllIllIIlll = (int)(llllllllllllllIlllIIIIllIllIllII * (float)llllllllllllllIlllIIIIllIllIlIll / 255.0f);
        final int llllllllllllllIlllIIIIllIllIIllI = (int)(llllllllllllllIlllIIIIllIllIlIlI * (float)llllllllllllllIlllIIIIllIllIlIIl / 255.0f);
        return (llllllllllllllIlllIIIIllIlllIIII & 0xFF000000) | llllllllllllllIlllIIIIllIllIlIII << 16 | llllllllllllllIlllIIIIllIllIIlll << 8 | llllllllllllllIlllIIIIllIllIIllI;
    }
    
    private static int calculateLogBaseTwoDeBruijn(int llllllllllllllIlllIIIIlllIIlllIl) {
        llllllllllllllIlllIIIIlllIIlllIl = (String)(isPowerOfTwo((int)llllllllllllllIlllIIIIlllIIlllIl) ? llllllllllllllIlllIIIIlllIIlllIl : roundUpToPowerOfTwo((int)llllllllllllllIlllIIIIlllIIlllIl));
        return MathHelper.multiplyDeBruijnBitPosition[(int)((long)llllllllllllllIlllIIIIlllIIlllIl * 125613361L >> 27) & 0x1F];
    }
    
    private static boolean isPowerOfTwo(final int llllllllllllllIlllIIIIlllIlIIIIl) {
        return llllllllllllllIlllIIIIlllIlIIIIl != 0 && (llllllllllllllIlllIIIIlllIlIIIIl & llllllllllllllIlllIIIIlllIlIIIIl - 1) == 0x0;
    }
    
    public static float sqrt_float(final float llllllllllllllIlllIIIlIIIllIlIIl) {
        return (float)Math.sqrt(llllllllllllllIlllIIIlIIIllIlIIl);
    }
    
    public static double parseDoubleWithDefault(final String llllllllllllllIlllIIIIlllIllIlII, final double llllllllllllllIlllIIIIlllIllIllI) {
        try {
            return Double.parseDouble(llllllllllllllIlllIIIIlllIllIlII);
        }
        catch (Throwable llllllllllllllIlllIIIIlllIllIlIl) {
            return llllllllllllllIlllIIIIlllIllIllI;
        }
    }
    
    public static int floor_double(final double llllllllllllllIlllIIIlIIIlIllIII) {
        final int llllllllllllllIlllIIIlIIIlIllIIl = (int)llllllllllllllIlllIIIlIIIlIllIII;
        return (llllllllllllllIlllIIIlIIIlIllIII < llllllllllllllIlllIIIlIIIlIllIIl) ? (llllllllllllllIlllIIIlIIIlIllIIl - 1) : llllllllllllllIlllIIIlIIIlIllIIl;
    }
    
    public static float sin(final float llllllllllllllIlllIIIlIIIlllIIII) {
        return MathHelper.fastMath ? MathHelper.SIN_TABLE_FAST[(int)(llllllllllllllIlllIIIlIIIlllIIII * 651.8986f) & 0xFFF] : MathHelper.SIN_TABLE[(int)(llllllllllllllIlllIIIlIIIlllIIII * 10430.378f) & 0xFFFF];
    }
    
    public static int func_154353_e(final double llllllllllllllIlllIIIlIIIlIIllll) {
        return (int)((llllllllllllllIlllIIIlIIIlIIllll >= 0.0) ? llllllllllllllIlllIIIlIIIlIIllll : (-llllllllllllllIlllIIIlIIIlIIllll + 1.0));
    }
    
    public static double clamp_double(final double llllllllllllllIlllIIIlIIIIlIIllI, final double llllllllllllllIlllIIIlIIIIlIIIlI, final double llllllllllllllIlllIIIlIIIIlIIlII) {
        return (llllllllllllllIlllIIIlIIIIlIIllI < llllllllllllllIlllIIIlIIIIlIIIlI) ? llllllllllllllIlllIIIlIIIIlIIIlI : ((llllllllllllllIlllIIIlIIIIlIIllI > llllllllllllllIlllIIIlIIIIlIIlII) ? llllllllllllllIlllIIIlIIIIlIIlII : llllllllllllllIlllIIIlIIIIlIIllI);
    }
    
    public static int func_154354_b(final int llllllllllllllIlllIIIIlllIIlIIll, int llllllllllllllIlllIIIIlllIIlIIlI) {
        if (llllllllllllllIlllIIIIlllIIlIIlI == 0) {
            return 0;
        }
        if (llllllllllllllIlllIIIIlllIIlIIll == 0) {
            return (int)llllllllllllllIlllIIIIlllIIlIIlI;
        }
        if (llllllllllllllIlllIIIIlllIIlIIll < 0) {
            llllllllllllllIlllIIIIlllIIlIIlI *= -1;
        }
        final int llllllllllllllIlllIIIIlllIIlIlII = (int)(llllllllllllllIlllIIIIlllIIlIIll % llllllllllllllIlllIIIIlllIIlIIlI);
        return (int)((llllllllllllllIlllIIIIlllIIlIlII == 0) ? llllllllllllllIlllIIIIlllIIlIIll : (llllllllllllllIlllIIIIlllIIlIIll + llllllllllllllIlllIIIIlllIIlIIlI - llllllllllllllIlllIIIIlllIIlIlII));
    }
    
    public static float sqrt_double(final double llllllllllllllIlllIIIlIIIllIIlll) {
        return (float)Math.sqrt(llllllllllllllIlllIIIlIIIllIIlll);
    }
    
    public static int parseIntWithDefaultAndMax(final String llllllllllllllIlllIIIIlllIllllIl, final int llllllllllllllIlllIIIIlllIllllll, final int llllllllllllllIlllIIIIlllIlllllI) {
        return Math.max(llllllllllllllIlllIIIIlllIlllllI, parseIntWithDefault(llllllllllllllIlllIIIIlllIllllIl, llllllllllllllIlllIIIIlllIllllll));
    }
    
    public static double denormalizeClamp(final double llllllllllllllIlllIIIlIIIIIllIlI, final double llllllllllllllIlllIIIlIIIIIllIIl, final double llllllllllllllIlllIIIlIIIIIllIll) {
        return (llllllllllllllIlllIIIlIIIIIllIll < 0.0) ? llllllllllllllIlllIIIlIIIIIllIlI : ((llllllllllllllIlllIIIlIIIIIllIll > 1.0) ? llllllllllllllIlllIIIlIIIIIllIIl : (llllllllllllllIlllIIIlIIIIIllIlI + (llllllllllllllIlllIIIlIIIIIllIIl - llllllllllllllIlllIIIlIIIIIllIlI) * llllllllllllllIlllIIIlIIIIIllIll));
    }
    
    public static int parseIntWithDefault(final String llllllllllllllIlllIIIIllllIIIllI, final int llllllllllllllIlllIIIIllllIIIlIl) {
        try {
            return Integer.parseInt(llllllllllllllIlllIIIIllllIIIllI);
        }
        catch (Throwable llllllllllllllIlllIIIIllllIIIlll) {
            return llllllllllllllIlllIIIIllllIIIlIl;
        }
    }
    
    public static float wrapAngleTo180_float(float llllllllllllllIlllIIIIllllIlIIII) {
        llllllllllllllIlllIIIIllllIlIIII %= (int)360.0f;
        if (llllllllllllllIlllIIIIllllIlIIII >= 180.0f) {
            llllllllllllllIlllIIIIllllIlIIII -= (int)360.0f;
        }
        if (llllllllllllllIlllIIIIllllIlIIII < -180.0f) {
            llllllllllllllIlllIIIIllllIlIIII += (int)360.0f;
        }
        return llllllllllllllIlllIIIIllllIlIIII;
    }
    
    public static int clamp_int(final int llllllllllllllIlllIIIlIIIIlllIII, final int llllllllllllllIlllIIIlIIIIllIlll, final int llllllllllllllIlllIIIlIIIIllIllI) {
        return (llllllllllllllIlllIIIlIIIIlllIII < llllllllllllllIlllIIIlIIIIllIlll) ? llllllllllllllIlllIIIlIIIIllIlll : ((llllllllllllllIlllIIIlIIIIlllIII > llllllllllllllIlllIIIlIIIIllIllI) ? llllllllllllllIlllIIIlIIIIllIllI : llllllllllllllIlllIIIlIIIIlllIII);
    }
    
    public static double average(final long[] llllllllllllllIlllIIIIlllllIIlII) {
        long llllllllllllllIlllIIIIlllllIlIIl = 0L;
        final long[] llllllllllllllIlllIIIIlllllIlIII = llllllllllllllIlllIIIIlllllIIlII;
        for (int llllllllllllllIlllIIIIlllllIIlll = llllllllllllllIlllIIIIlllllIIlII.length, llllllllllllllIlllIIIIlllllIIllI = 0; llllllllllllllIlllIIIIlllllIIllI < llllllllllllllIlllIIIIlllllIIlll; ++llllllllllllllIlllIIIIlllllIIllI) {
            final long llllllllllllllIlllIIIIlllllIIlIl = llllllllllllllIlllIIIIlllllIlIII[llllllllllllllIlllIIIIlllllIIllI];
            llllllllllllllIlllIIIIlllllIlIIl += llllllllllllllIlllIIIIlllllIIlIl;
        }
        return llllllllllllllIlllIIIIlllllIlIIl / (double)llllllllllllllIlllIIIIlllllIIlII.length;
    }
    
    static {
        __OBFID = "CL_00001496";
        SIN_COUNT = 4096;
        SIN_BITS = 12;
        SIN_MASK = 4095;
        field_180189_a = sqrt_float(2.0f);
        SIN_TABLE_FAST = new float[4096];
        MathHelper.fastMath = false;
        SIN_TABLE = new float[65536];
        for (int llllllllllllllIlllIIIlIIIlllIllI = 0; llllllllllllllIlllIIIlIIIlllIllI < 65536; ++llllllllllllllIlllIIIlIIIlllIllI) {
            MathHelper.SIN_TABLE[llllllllllllllIlllIIIlIIIlllIllI] = (float)Math.sin(llllllllllllllIlllIIIlIIIlllIllI * 3.141592653589793 * 2.0 / 65536.0);
        }
        multiplyDeBruijnBitPosition = new int[] { 0, 1, 28, 2, 29, 14, 24, 3, 30, 22, 20, 15, 25, 17, 4, 8, 31, 27, 13, 23, 21, 19, 16, 7, 26, 12, 18, 6, 11, 5, 10, 9 };
        for (int llllllllllllllIlllIIIlIIIlllIllI = 0; llllllllllllllIlllIIIlIIIlllIllI < 4096; ++llllllllllllllIlllIIIlIIIlllIllI) {
            MathHelper.SIN_TABLE_FAST[llllllllllllllIlllIIIlIIIlllIllI] = (float)Math.sin((llllllllllllllIlllIIIlIIIlllIllI + 0.5f) / 4096.0f * 6.2831855f);
        }
        for (int llllllllllllllIlllIIIlIIIlllIllI = 0; llllllllllllllIlllIIIlIIIlllIllI < 360; llllllllllllllIlllIIIlIIIlllIllI += 90) {
            MathHelper.SIN_TABLE_FAST[(int)(llllllllllllllIlllIIIlIIIlllIllI * 11.377778f) & 0xFFF] = (float)Math.sin(llllllllllllllIlllIIIlIIIlllIllI * 0.017453292f);
        }
    }
    
    public static double wrapAngleTo180_double(double llllllllllllllIlllIIIIllllIIllIl) {
        llllllllllllllIlllIIIIllllIIllIl %= 360.0;
        if (llllllllllllllIlllIIIIllllIIllIl >= 180.0) {
            llllllllllllllIlllIIIIllllIIllIl -= 360.0;
        }
        if (llllllllllllllIlllIIIIllllIIllIl < -180.0) {
            llllllllllllllIlllIIIIllllIIllIl += 360.0;
        }
        return llllllllllllllIlllIIIIllllIIllIl;
    }
    
    public static UUID func_180182_a(final Random llllllllllllllIlllIIIIllIlIIIlIl) {
        final long llllllllllllllIlllIIIIllIlIIIlll = (llllllllllllllIlllIIIIllIlIIIlIl.nextLong() & 0xFFFFFFFFFFFF0FFFL) | 0x4000L;
        final long llllllllllllllIlllIIIIllIlIIIllI = (llllllllllllllIlllIIIIllIlIIIlIl.nextLong() & 0x3FFFFFFFFFFFFFFFL) | Long.MIN_VALUE;
        return new UUID(llllllllllllllIlllIIIIllIlIIIlll, llllllllllllllIlllIIIIllIlIIIllI);
    }
    
    public static int func_180184_b(final int llllllllllllllIlllIIIIllllIlIllI, final int llllllllllllllIlllIIIIllllIlIlIl) {
        return (llllllllllllllIlllIIIIllllIlIllI % llllllllllllllIlllIIIIllllIlIlIl + llllllllllllllIlllIIIIllllIlIlIl) % llllllllllllllIlllIIIIllllIlIlIl;
    }
    
    public static float cos(final float llllllllllllllIlllIIIlIIIllIllIl) {
        return MathHelper.fastMath ? MathHelper.SIN_TABLE_FAST[(int)((llllllllllllllIlllIIIlIIIllIllIl + 1.5707964f) * 651.8986f) & 0xFFF] : MathHelper.SIN_TABLE[(int)(llllllllllllllIlllIIIlIIIllIllIl * 10430.378f + 16384.0f) & 0xFFFF];
    }
}
