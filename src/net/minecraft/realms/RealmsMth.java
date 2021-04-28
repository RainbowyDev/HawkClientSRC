package net.minecraft.realms;

import net.minecraft.util.*;
import java.util.*;
import org.apache.commons.lang3.*;

public class RealmsMth
{
    public static float sin(final float llllllllllllllllIlIlllIlIlIlIlII) {
        return MathHelper.sin(llllllllllllllllIlIlllIlIlIlIlII);
    }
    
    public static int nextInt(final Random llllllllllllllllIlIlllIIlIllIIll, final int llllllllllllllllIlIlllIIlIlIllll, final int llllllllllllllllIlIlllIIlIlIlllI) {
        return MathHelper.getRandomIntegerInRange(llllllllllllllllIlIlllIIlIllIIll, llllllllllllllllIlIlllIIlIlIllll, llllllllllllllllIlIlllIIlIlIlllI);
    }
    
    public static double average(final long[] llllllllllllllllIlIlllIIlIllllIl) {
        return MathHelper.average(llllllllllllllllIlIlllIIlIllllIl);
    }
    
    public static int absFloor(final double llllllllllllllllIlIlllIlIIIIIIlI) {
        return MathHelper.func_154353_e(llllllllllllllllIlIlllIlIIIIIIlI);
    }
    
    public static int ceil(final float llllllllllllllllIlIlllIlIlIIIlll) {
        return MathHelper.ceiling_float_int(llllllllllllllllIlIlllIlIlIIIlll);
    }
    
    public static double getDouble(final String llllllllllllllllIlIlllIIllIIlIII, final double llllllllllllllllIlIlllIIllIIlIlI, final double llllllllllllllllIlIlllIIllIIIllI) {
        return MathHelper.parseDoubleWithDefaultAndMax(llllllllllllllllIlIlllIIllIIlIII, llllllllllllllllIlIlllIIllIIlIlI, llllllllllllllllIlIlllIIllIIIllI);
    }
    
    public static double getDouble(final String llllllllllllllllIlIlllIlIIIIlIll, final double llllllllllllllllIlIlllIlIIIIlIII) {
        return MathHelper.parseDoubleWithDefault(llllllllllllllllIlIlllIlIIIIlIll, llllllllllllllllIlIlllIlIIIIlIII);
    }
    
    public static float cos(final float llllllllllllllllIlIlllIIlllllIlI) {
        return MathHelper.cos(llllllllllllllllIlIlllIIlllllIlI);
    }
    
    public static int getInt(final String llllllllllllllllIlIlllIlIIIlIIIl, final int llllllllllllllllIlIlllIlIIIIlllI) {
        return MathHelper.parseIntWithDefault(llllllllllllllllIlIlllIlIIIlIIIl, llllllllllllllllIlIlllIlIIIIlllI);
    }
    
    public static double nextDouble(final Random llllllllllllllllIlIlllIlIlIIllll, final double llllllllllllllllIlIlllIlIlIIlIll, final double llllllllllllllllIlIlllIlIlIIllIl) {
        return MathHelper.getRandomDoubleInRange(llllllllllllllllIlIlllIlIlIIllll, llllllllllllllllIlIlllIlIlIIlIll, llllllllllllllllIlIlllIlIlIIllIl);
    }
    
    public static int floor(final double llllllllllllllllIlIlllIlIlIIIlIl) {
        return MathHelper.floor_double(llllllllllllllllIlIlllIlIlIIIlIl);
    }
    
    public static float clamp(final float llllllllllllllllIlIlllIIllIlIIIl, final float llllllllllllllllIlIlllIIllIlIIll, final float llllllllllllllllIlIlllIIllIlIIlI) {
        return MathHelper.clamp_float(llllllllllllllllIlIlllIIllIlIIIl, llllllllllllllllIlIlllIIllIlIIll, llllllllllllllllIlIlllIIllIlIIlI);
    }
    
    public static float sqrt(final double llllllllllllllllIlIlllIlIIIllllI) {
        return MathHelper.sqrt_double(llllllllllllllllIlIlllIlIIIllllI);
    }
    
    public static int clamp(final int llllllllllllllllIlIlllIlIIllIlII, final int llllllllllllllllIlIlllIlIIllIIll, final int llllllllllllllllIlIlllIlIIllIIlI) {
        return MathHelper.clamp_int(llllllllllllllllIlIlllIlIIllIlII, llllllllllllllllIlIlllIlIIllIIll, llllllllllllllllIlIlllIlIIllIIlI);
    }
    
    public static double clampedLerp(final double llllllllllllllllIlIlllIlIIlIlllI, final double llllllllllllllllIlIlllIlIIlIllIl, final double llllllllllllllllIlIlllIlIIlIllII) {
        return MathHelper.denormalizeClamp(llllllllllllllllIlIlllIlIIlIlllI, llllllllllllllllIlIlllIlIIlIllIl, llllllllllllllllIlIlllIlIIlIllII);
    }
    
    public static float wrapDegrees(final float llllllllllllllllIlIlllIIllIllIIl) {
        return MathHelper.wrapAngleTo180_float(llllllllllllllllIlIlllIIllIllIIl);
    }
    
    public static long lfloor(final double llllllllllllllllIlIlllIlIIlIIIIl) {
        return MathHelper.floor_double_long(llllllllllllllllIlIlllIlIIlIIIIl);
    }
    
    public static int getInt(final String llllllllllllllllIlIlllIIllllIlIl, final int llllllllllllllllIlIlllIIllllIlII, final int llllllllllllllllIlIlllIIllllIIll) {
        return MathHelper.parseIntWithDefaultAndMax(llllllllllllllllIlIlllIIllllIlIl, llllllllllllllllIlIlllIIllllIlII, llllllllllllllllIlIlllIIllllIIll);
    }
    
    public static float sqrt(final float llllllllllllllllIlIlllIIllllllIl) {
        return MathHelper.sqrt_float(llllllllllllllllIlIlllIIllllllIl);
    }
    
    public static double clamp(final double llllllllllllllllIlIlllIlIIIllIIl, final double llllllllllllllllIlIlllIlIIIlIlIl, final double llllllllllllllllIlIlllIlIIIlIlII) {
        return MathHelper.clamp_double(llllllllllllllllIlIlllIlIIIllIIl, llllllllllllllllIlIlllIlIIIlIlIl, llllllllllllllllIlIlllIlIIIlIlII);
    }
    
    static {
        __OBFID = "CL_00001900";
    }
    
    public static double absMax(final double llllllllllllllllIlIlllIIlllIlIlI, final double llllllllllllllllIlIlllIIlllIIlll) {
        return MathHelper.abs_max(llllllllllllllllIlIlllIIlllIlIlI, llllllllllllllllIlIlllIIlllIIlll);
    }
    
    public static int abs(final int llllllllllllllllIlIlllIIlIlllIII) {
        return MathHelper.abs_int(llllllllllllllllIlIlllIIlIlllIII);
    }
    
    public static int smallestEncompassingPowerOfTwo(final int llllllllllllllllIlIlllIIllllllll) {
        return MathHelper.roundUpToPowerOfTwo(llllllllllllllllIlIlllIIllllllll);
    }
    
    public static float abs(final float llllllllllllllllIlIlllIlIIlllIll) {
        return MathHelper.abs(llllllllllllllllIlIlllIlIIlllIll);
    }
    
    public static int intFloorDiv(final int llllllllllllllllIlIlllIlIlIIIIIl, final int llllllllllllllllIlIlllIlIIlllllI) {
        return MathHelper.bucketInt(llllllllllllllllIlIlllIlIlIIIIIl, llllllllllllllllIlIlllIlIIlllllI);
    }
    
    public static boolean isEmpty(final String llllllllllllllllIlIlllIlIIlIIIll) {
        return StringUtils.isEmpty((CharSequence)llllllllllllllllIlIlllIlIIlIIIll);
    }
    
    public static double wrapDegrees(final double llllllllllllllllIlIlllIIllIllIll) {
        return MathHelper.wrapAngleTo180_double(llllllllllllllllIlIlllIIllIllIll);
    }
    
    public static float nextFloat(final Random llllllllllllllllIlIlllIIlllIIIll, final float llllllllllllllllIlIlllIIllIlllll, final float llllllllllllllllIlIlllIIlllIIIIl) {
        return MathHelper.randomFloatClamp(llllllllllllllllIlIlllIIlllIIIll, llllllllllllllllIlIlllIIllIlllll, llllllllllllllllIlIlllIIlllIIIIl);
    }
    
    public static int log2(final int llllllllllllllllIlIlllIlIIIIIlIl) {
        return MathHelper.calculateLogBaseTwo(llllllllllllllllIlIlllIlIIIIIlIl);
    }
    
    public static int ceil(final double llllllllllllllllIlIlllIlIIlIIlll) {
        return MathHelper.ceiling_double_int(llllllllllllllllIlIlllIlIIlIIlll);
    }
    
    public static int fastFloor(final double llllllllllllllllIlIlllIIlllIllIl) {
        return MathHelper.truncateDoubleToInt(llllllllllllllllIlIlllIIlllIllIl);
    }
    
    public static int roundUp(final int llllllllllllllllIlIlllIIllIIIIll, final int llllllllllllllllIlIlllIIllIIIIII) {
        return MathHelper.func_154354_b(llllllllllllllllIlIlllIIllIIIIll, llllllllllllllllIlIlllIIllIIIIII);
    }
    
    public static int floor(final float llllllllllllllllIlIlllIIlIlllIll) {
        return MathHelper.floor_float(llllllllllllllllIlIlllIIlIlllIll);
    }
}
