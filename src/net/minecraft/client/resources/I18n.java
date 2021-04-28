package net.minecraft.client.resources;

import java.util.*;

public class I18n
{
    private static /* synthetic */ Locale i18nLocale;
    
    public static String format(final String llllllllllllllIIIlIlIlIIIIlllIIl, final Object... llllllllllllllIIIlIlIlIIIIllIllI) {
        return I18n.i18nLocale.formatMessage(llllllllllllllIIIlIlIlIIIIlllIIl, llllllllllllllIIIlIlIlIIIIllIllI);
    }
    
    static void setLocale(final Locale llllllllllllllIIIlIlIlIIIIllllII) {
        I18n.i18nLocale = llllllllllllllIIIlIlIlIIIIllllII;
    }
    
    public static Map getLocaleProperties() {
        return I18n.i18nLocale.field_135032_a;
    }
}
