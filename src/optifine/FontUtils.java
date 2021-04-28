package optifine;

import net.minecraft.util.*;
import java.io.*;
import java.util.*;

public class FontUtils
{
    public static float readFloat(final Properties lIIllIIlIlIlIlI, final String lIIllIIlIlIlllI, final float lIIllIIlIlIlIII) {
        final String lIIllIIlIlIllII = lIIllIIlIlIlIlI.getProperty(lIIllIIlIlIlllI);
        if (lIIllIIlIlIllII == null) {
            return lIIllIIlIlIlIII;
        }
        final float lIIllIIlIlIlIll = Config.parseFloat(lIIllIIlIlIllII, Float.MIN_VALUE);
        if (lIIllIIlIlIlIll == Float.MIN_VALUE) {
            Config.warn(String.valueOf(new StringBuilder("Invalid value for ").append(lIIllIIlIlIlllI).append(": ").append(lIIllIIlIlIllII)));
            return lIIllIIlIlIlIII;
        }
        return lIIllIIlIlIlIll;
    }
    
    public static Properties readFontProperties(final ResourceLocation lIIllIIlllIIIIl) {
        final String lIIllIIlllIIIII = lIIllIIlllIIIIl.getResourcePath();
        final Properties lIIllIIllIlllll = new Properties();
        final String lIIllIIllIllllI = ".png";
        if (!lIIllIIlllIIIII.endsWith(lIIllIIllIllllI)) {
            return lIIllIIllIlllll;
        }
        final String lIIllIIllIlllIl = String.valueOf(new StringBuilder(String.valueOf(lIIllIIlllIIIII.substring(0, lIIllIIlllIIIII.length() - lIIllIIllIllllI.length()))).append(".properties"));
        try {
            final ResourceLocation lIIllIIllIlllII = new ResourceLocation(lIIllIIlllIIIIl.getResourceDomain(), lIIllIIllIlllIl);
            final InputStream lIIllIIllIllIll = Config.getResourceStream(Config.getResourceManager(), lIIllIIllIlllII);
            if (lIIllIIllIllIll == null) {
                return lIIllIIllIlllll;
            }
            Config.log(String.valueOf(new StringBuilder("Loading ").append(lIIllIIllIlllIl)));
            lIIllIIllIlllll.load(lIIllIIllIllIll);
        }
        catch (FileNotFoundException ex) {}
        catch (IOException lIIllIIllIllIlI) {
            lIIllIIllIllIlI.printStackTrace();
        }
        return lIIllIIllIlllll;
    }
    
    public static void readCustomCharWidths(final Properties lIIllIIlIlllllI, final float[] lIIllIIllIIIlll) {
        final Set lIIllIIllIIIllI = lIIllIIlIlllllI.keySet();
        for (final String lIIllIIllIIIlII : lIIllIIllIIIllI) {
            final String lIIllIIllIIIIll = "width.";
            if (lIIllIIllIIIlII.startsWith(lIIllIIllIIIIll)) {
                final String lIIllIIllIIIIlI = lIIllIIllIIIlII.substring(lIIllIIllIIIIll.length());
                final int lIIllIIllIIIIIl = Config.parseInt(lIIllIIllIIIIlI, -1);
                if (lIIllIIllIIIIIl < 0 || lIIllIIllIIIIIl >= lIIllIIllIIIlll.length) {
                    continue;
                }
                final String lIIllIIllIIIIII = lIIllIIlIlllllI.getProperty(lIIllIIllIIIlII);
                final float lIIllIIlIllllll = Config.parseFloat(lIIllIIllIIIIII, -1.0f);
                if (lIIllIIlIllllll < 0.0f) {
                    continue;
                }
                lIIllIIllIIIlll[lIIllIIllIIIIIl] = lIIllIIlIllllll;
            }
        }
    }
    
    public static ResourceLocation getHdFontLocation(final ResourceLocation lIIllIIlIIllIll) {
        if (!Config.isCustomFonts()) {
            return lIIllIIlIIllIll;
        }
        if (lIIllIIlIIllIll == null) {
            return lIIllIIlIIllIll;
        }
        String lIIllIIlIIlllll = lIIllIIlIIllIll.getResourcePath();
        final String lIIllIIlIIllllI = "textures/";
        final String lIIllIIlIIlllIl = "mcpatcher/";
        if (!lIIllIIlIIlllll.startsWith(lIIllIIlIIllllI)) {
            return lIIllIIlIIllIll;
        }
        lIIllIIlIIlllll = lIIllIIlIIlllll.substring(lIIllIIlIIllllI.length());
        lIIllIIlIIlllll = String.valueOf(new StringBuilder(String.valueOf(lIIllIIlIIlllIl)).append(lIIllIIlIIlllll));
        final ResourceLocation lIIllIIlIIlllII = new ResourceLocation(lIIllIIlIIllIll.getResourceDomain(), lIIllIIlIIlllll);
        return Config.hasResource(Config.getResourceManager(), lIIllIIlIIlllII) ? lIIllIIlIIlllII : lIIllIIlIIllIll;
    }
}
