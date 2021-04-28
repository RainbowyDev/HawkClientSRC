package net.minecraft.util;

import java.util.regex.*;

public class StringUtils
{
    private static final /* synthetic */ Pattern patternControlCode;
    
    public static String stripControlCodes(final String lIIllllIIlIIIII) {
        return StringUtils.patternControlCode.matcher(lIIllllIIlIIIII).replaceAll("");
    }
    
    public static boolean isNullOrEmpty(final String lIIllllIIIlllIl) {
        return org.apache.commons.lang3.StringUtils.isEmpty((CharSequence)lIIllllIIIlllIl);
    }
    
    public static String ticksToElapsedTime(final int lIIllllIIlIIlII) {
        int lIIllllIIlIIllI = lIIllllIIlIIlII / 20;
        final int lIIllllIIlIIlIl = lIIllllIIlIIllI / 60;
        lIIllllIIlIIllI %= 60;
        return (lIIllllIIlIIllI < 10) ? String.valueOf(new StringBuilder(String.valueOf(lIIllllIIlIIlIl)).append(":0").append(lIIllllIIlIIllI)) : String.valueOf(new StringBuilder(String.valueOf(lIIllllIIlIIlIl)).append(":").append(lIIllllIIlIIllI));
    }
    
    static {
        __OBFID = "CL_00001501";
        patternControlCode = Pattern.compile("(?i)\\u00A7[0-9A-FK-OR]");
    }
}
