package optifine;

import com.google.common.base.*;
import java.util.regex.*;
import net.minecraft.client.resources.*;
import net.minecraft.util.*;
import java.io.*;
import org.apache.commons.io.*;
import com.google.common.collect.*;
import java.util.*;

public class Lang
{
    private static final /* synthetic */ Splitter splitter;
    private static final /* synthetic */ Pattern pattern;
    
    public static String getFancy() {
        return I18n.format("options.graphics.fancy", new Object[0]);
    }
    
    public static String getDefault() {
        return I18n.format("generator.default", new Object[0]);
    }
    
    public static String getFast() {
        return I18n.format("options.graphics.fast", new Object[0]);
    }
    
    public static String getOff() {
        return I18n.format("options.off", new Object[0]);
    }
    
    public static String get(final String lllllllllllllllIIIIIIllIIIllIlll, final String lllllllllllllllIIIIIIllIIIllIIll) {
        final String lllllllllllllllIIIIIIllIIIllIlIl = I18n.format(lllllllllllllllIIIIIIllIIIllIlll, new Object[0]);
        return (lllllllllllllllIIIIIIllIIIllIlIl != null && !lllllllllllllllIIIIIIllIIIllIlIl.equals(lllllllllllllllIIIIIIllIIIllIlll)) ? lllllllllllllllIIIIIIllIIIllIlIl : lllllllllllllllIIIIIIllIIIllIIll;
    }
    
    private static void loadResources(final IResourcePack lllllllllllllllIIIIIIllIIllIIIIl, final String[] lllllllllllllllIIIIIIllIIlIllIII, final Map lllllllllllllllIIIIIIllIIlIlllll) {
        try {
            for (int lllllllllllllllIIIIIIllIIlIllllI = 0; lllllllllllllllIIIIIIllIIlIllllI < lllllllllllllllIIIIIIllIIlIllIII.length; ++lllllllllllllllIIIIIIllIIlIllllI) {
                final String lllllllllllllllIIIIIIllIIlIlllIl = lllllllllllllllIIIIIIllIIlIllIII[lllllllllllllllIIIIIIllIIlIllllI];
                final ResourceLocation lllllllllllllllIIIIIIllIIlIlllII = new ResourceLocation(lllllllllllllllIIIIIIllIIlIlllIl);
                if (lllllllllllllllIIIIIIllIIllIIIIl.resourceExists(lllllllllllllllIIIIIIllIIlIlllII)) {
                    final InputStream lllllllllllllllIIIIIIllIIlIllIll = lllllllllllllllIIIIIIllIIllIIIIl.getInputStream(lllllllllllllllIIIIIIllIIlIlllII);
                    if (lllllllllllllllIIIIIIllIIlIllIll != null) {
                        loadLocaleData(lllllllllllllllIIIIIIllIIlIllIll, lllllllllllllllIIIIIIllIIlIlllll);
                    }
                }
            }
        }
        catch (IOException lllllllllllllllIIIIIIllIIlIllIlI) {
            lllllllllllllllIIIIIIllIIlIllIlI.printStackTrace();
        }
    }
    
    public static void resourcesReloaded() {
        final Map lllllllllllllllIIIIIIllIIlllllll = I18n.getLocaleProperties();
        final ArrayList lllllllllllllllIIIIIIllIIlllllIl = new ArrayList();
        final String lllllllllllllllIIIIIIllIIllllIll = "optifine/lang/";
        final String lllllllllllllllIIIIIIllIIllllIIl = "en_US";
        final String lllllllllllllllIIIIIIllIIlllIlll = ".lang";
        lllllllllllllllIIIIIIllIIlllllIl.add(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIIIIIllIIllllIll)).append(lllllllllllllllIIIIIIllIIllllIIl).append(lllllllllllllllIIIIIIllIIlllIlll)));
        if (!Config.getGameSettings().language.equals(lllllllllllllllIIIIIIllIIllllIIl)) {
            lllllllllllllllIIIIIIllIIlllllIl.add(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIIIIIllIIllllIll)).append(Config.getGameSettings().language).append(lllllllllllllllIIIIIIllIIlllIlll)));
        }
        final String[] lllllllllllllllIIIIIIllIIlllIlIl = lllllllllllllllIIIIIIllIIlllllIl.toArray(new String[lllllllllllllllIIIIIIllIIlllllIl.size()]);
        loadResources(Config.getDefaultResourcePack(), lllllllllllllllIIIIIIllIIlllIlIl, lllllllllllllllIIIIIIllIIlllllll);
        final IResourcePack[] lllllllllllllllIIIIIIllIIlllIlII = Config.getResourcePacks();
        for (int lllllllllllllllIIIIIIllIIlllIIll = 0; lllllllllllllllIIIIIIllIIlllIIll < lllllllllllllllIIIIIIllIIlllIlII.length; ++lllllllllllllllIIIIIIllIIlllIIll) {
            final IResourcePack lllllllllllllllIIIIIIllIIlllIIlI = lllllllllllllllIIIIIIllIIlllIlII[lllllllllllllllIIIIIIllIIlllIIll];
            loadResources(lllllllllllllllIIIIIIllIIlllIIlI, lllllllllllllllIIIIIIllIIlllIlIl, lllllllllllllllIIIIIIllIIlllllll);
        }
    }
    
    static {
        splitter = Splitter.on('=').limit(2);
        pattern = Pattern.compile("%(\\d+\\$)?[\\d\\.]*[df]");
    }
    
    public static String getOn() {
        return I18n.format("options.on", new Object[0]);
    }
    
    public static String get(final String lllllllllllllllIIIIIIllIIIlllIll) {
        return I18n.format(lllllllllllllllIIIIIIllIIIlllIll, new Object[0]);
    }
    
    public static void loadLocaleData(final InputStream lllllllllllllllIIIIIIllIIlIIlIll, final Map lllllllllllllllIIIIIIllIIlIIlIlI) throws IOException {
        for (final String lllllllllllllllIIIIIIllIIlIIlIII : IOUtils.readLines(lllllllllllllllIIIIIIllIIlIIlIll, Charsets.UTF_8)) {
            if (!lllllllllllllllIIIIIIllIIlIIlIII.isEmpty() && lllllllllllllllIIIIIIllIIlIIlIII.charAt(0) != '#') {
                final String[] lllllllllllllllIIIIIIllIIlIIIlll = (String[])Iterables.toArray(Lang.splitter.split((CharSequence)lllllllllllllllIIIIIIllIIlIIlIII), (Class)String.class);
                if (lllllllllllllllIIIIIIllIIlIIIlll == null || lllllllllllllllIIIIIIllIIlIIIlll.length != 2) {
                    continue;
                }
                final String lllllllllllllllIIIIIIllIIlIIIllI = lllllllllllllllIIIIIIllIIlIIIlll[0];
                final String lllllllllllllllIIIIIIllIIlIIIlIl = Lang.pattern.matcher(lllllllllllllllIIIIIIllIIlIIIlll[1]).replaceAll("%$1s");
                lllllllllllllllIIIIIIllIIlIIlIlI.put(lllllllllllllllIIIIIIllIIlIIIllI, lllllllllllllllIIIIIIllIIlIIIlIl);
            }
        }
    }
}
