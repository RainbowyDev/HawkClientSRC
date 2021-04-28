package net.minecraft.util;

public class StatCollector
{
    private static /* synthetic */ StringTranslate fallbackTranslator;
    private static /* synthetic */ StringTranslate localizedName;
    
    public static String translateToFallback(final String llllllllllllllIlIIlIlIIllIlIllIl) {
        return StatCollector.fallbackTranslator.translateKey(llllllllllllllIlIIlIlIIllIlIllIl);
    }
    
    public static String translateToLocalFormatted(final String llllllllllllllIlIIlIlIIllIllIIlI, final Object... llllllllllllllIlIIlIlIIllIllIIIl) {
        return StatCollector.localizedName.translateKeyFormat(llllllllllllllIlIIlIlIIllIllIIlI, llllllllllllllIlIIlIlIIllIllIIIl);
    }
    
    static {
        __OBFID = "CL_00001211";
        StatCollector.localizedName = StringTranslate.getInstance();
        StatCollector.fallbackTranslator = new StringTranslate();
    }
    
    public static long getLastTranslationUpdateTimeInMilliseconds() {
        return StatCollector.localizedName.getLastUpdateTimeInMilliseconds();
    }
    
    public static String translateToLocal(final String llllllllllllllIlIIlIlIIllIllIlIl) {
        return StatCollector.localizedName.translateKey(llllllllllllllIlIIlIlIIllIllIlIl);
    }
    
    public static boolean canTranslate(final String llllllllllllllIlIIlIlIIllIlIlIIl) {
        return StatCollector.localizedName.isKeyTranslated(llllllllllllllIlIIlIlIIllIlIlIIl);
    }
}
