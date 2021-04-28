package optifine;

import net.minecraft.util.*;
import java.util.zip.*;
import java.io.*;
import java.util.*;
import net.minecraft.client.resources.*;

public class ResUtils
{
    public static String[] collectFiles(final String lllllllllllllllllIIlllllIllIIIII, final String lllllllllllllllllIIlllllIlIlllll) {
        return collectFiles(new String[] { lllllllllllllllllIIlllllIllIIIII }, new String[] { lllllllllllllllllIIlllllIlIlllll });
    }
    
    public static String[] collectFiles(final IResourcePack lllllllllllllllllIIlllllIIllIlII, final String[] lllllllllllllllllIIlllllIIllIIll, final String[] lllllllllllllllllIIlllllIIllIIlI) {
        return collectFiles(lllllllllllllllllIIlllllIIllIlII, lllllllllllllllllIIlllllIIllIIll, lllllllllllllllllIIlllllIIllIIlI, null);
    }
    
    public static String[] collectFiles(final String[] lllllllllllllllllIIlllllIlIlIlIl, final String[] lllllllllllllllllIIlllllIlIlIlII) {
        final LinkedHashSet lllllllllllllllllIIlllllIlIlIIll = new LinkedHashSet();
        final IResourcePack[] lllllllllllllllllIIlllllIlIlIIlI = Config.getResourcePacks();
        for (int lllllllllllllllllIIlllllIlIlIIIl = 0; lllllllllllllllllIIlllllIlIlIIIl < lllllllllllllllllIIlllllIlIlIIlI.length; ++lllllllllllllllllIIlllllIlIlIIIl) {
            final IResourcePack lllllllllllllllllIIlllllIlIlIIII = lllllllllllllllllIIlllllIlIlIIlI[lllllllllllllllllIIlllllIlIlIIIl];
            final String[] lllllllllllllllllIIlllllIlIIllll = collectFiles(lllllllllllllllllIIlllllIlIlIIII, lllllllllllllllllIIlllllIlIlIlIl, lllllllllllllllllIIlllllIlIlIlII, null);
            lllllllllllllllllIIlllllIlIlIIll.addAll(Arrays.asList(lllllllllllllllllIIlllllIlIIllll));
        }
        final String[] lllllllllllllllllIIlllllIlIIlllI = (String[])lllllllllllllllllIIlllllIlIlIIll.toArray(new String[lllllllllllllllllIIlllllIlIlIIll.size()]);
        return lllllllllllllllllIIlllllIlIIlllI;
    }
    
    private static String[] collectFilesFixed(final IResourcePack lllllllllllllllllIIlllllIIIlIIlI, final String[] lllllllllllllllllIIlllllIIIllIII) {
        if (lllllllllllllllllIIlllllIIIllIII == null) {
            return new String[0];
        }
        final ArrayList lllllllllllllllllIIlllllIIIlIlll = new ArrayList();
        for (int lllllllllllllllllIIlllllIIIlIllI = 0; lllllllllllllllllIIlllllIIIlIllI < lllllllllllllllllIIlllllIIIllIII.length; ++lllllllllllllllllIIlllllIIIlIllI) {
            final String lllllllllllllllllIIlllllIIIlIlIl = lllllllllllllllllIIlllllIIIllIII[lllllllllllllllllIIlllllIIIlIllI];
            final ResourceLocation lllllllllllllllllIIlllllIIIlIlII = new ResourceLocation(lllllllllllllllllIIlllllIIIlIlIl);
            if (lllllllllllllllllIIlllllIIIlIIlI.resourceExists(lllllllllllllllllIIlllllIIIlIlII)) {
                lllllllllllllllllIIlllllIIIlIlll.add(lllllllllllllllllIIlllllIIIlIlIl);
            }
        }
        final String[] lllllllllllllllllIIlllllIIIlIIll = lllllllllllllllllIIlllllIIIlIlll.toArray(new String[lllllllllllllllllIIlllllIIIlIlll.size()]);
        return lllllllllllllllllIIlllllIIIlIIll;
    }
    
    private static String[] collectFilesZIP(final File lllllllllllllllllIIllllIllIllIlI, final String[] lllllllllllllllllIIllllIllIIlllI, final String[] lllllllllllllllllIIllllIllIIllIl) {
        final ArrayList lllllllllllllllllIIllllIllIlIlll = new ArrayList();
        final String lllllllllllllllllIIllllIllIlIllI = "assets/minecraft/";
        try {
            final ZipFile lllllllllllllllllIIllllIllIlIlIl = new ZipFile(lllllllllllllllllIIllllIllIllIlI);
            final Enumeration lllllllllllllllllIIllllIllIlIlII = lllllllllllllllllIIllllIllIlIlIl.entries();
            while (lllllllllllllllllIIllllIllIlIlII.hasMoreElements()) {
                final ZipEntry lllllllllllllllllIIllllIllIlIIll = lllllllllllllllllIIllllIllIlIlII.nextElement();
                String lllllllllllllllllIIllllIllIlIIlI = lllllllllllllllllIIllllIllIlIIll.getName();
                if (lllllllllllllllllIIllllIllIlIIlI.startsWith(lllllllllllllllllIIllllIllIlIllI)) {
                    lllllllllllllllllIIllllIllIlIIlI = lllllllllllllllllIIllllIllIlIIlI.substring(lllllllllllllllllIIllllIllIlIllI.length());
                    if (!StrUtils.startsWith(lllllllllllllllllIIllllIllIlIIlI, lllllllllllllllllIIllllIllIIlllI) || !StrUtils.endsWith(lllllllllllllllllIIllllIllIlIIlI, lllllllllllllllllIIllllIllIIllIl)) {
                        continue;
                    }
                    lllllllllllllllllIIllllIllIlIlll.add(lllllllllllllllllIIllllIllIlIIlI);
                }
            }
            lllllllllllllllllIIllllIllIlIlIl.close();
            final String[] lllllllllllllllllIIllllIllIlIIIl = lllllllllllllllllIIllllIllIlIlll.toArray(new String[lllllllllllllllllIIllllIllIlIlll.size()]);
            return lllllllllllllllllIIllllIllIlIIIl;
        }
        catch (IOException lllllllllllllllllIIllllIllIlIIII) {
            lllllllllllllllllIIllllIllIlIIII.printStackTrace();
            return new String[0];
        }
    }
    
    private static String[] collectFilesFolder(final File lllllllllllllllllIIllllIllllllll, final String lllllllllllllllllIIllllIlllIllll, final String[] lllllllllllllllllIIllllIlllIlllI, final String[] lllllllllllllllllIIllllIlllIllIl) {
        final ArrayList lllllllllllllllllIIllllIlllllIll = new ArrayList();
        final String lllllllllllllllllIIllllIlllllIlI = "assets/minecraft/";
        final File[] lllllllllllllllllIIllllIlllllIIl = lllllllllllllllllIIllllIllllllll.listFiles();
        if (lllllllllllllllllIIllllIlllllIIl == null) {
            return new String[0];
        }
        for (int lllllllllllllllllIIllllIlllllIII = 0; lllllllllllllllllIIllllIlllllIII < lllllllllllllllllIIllllIlllllIIl.length; ++lllllllllllllllllIIllllIlllllIII) {
            final File lllllllllllllllllIIllllIllllIlll = lllllllllllllllllIIllllIlllllIIl[lllllllllllllllllIIllllIlllllIII];
            if (lllllllllllllllllIIllllIllllIlll.isFile()) {
                String lllllllllllllllllIIllllIllllIllI = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllllIIllllIlllIllll)).append(lllllllllllllllllIIllllIllllIlll.getName()));
                if (lllllllllllllllllIIllllIllllIllI.startsWith(lllllllllllllllllIIllllIlllllIlI)) {
                    lllllllllllllllllIIllllIllllIllI = lllllllllllllllllIIllllIllllIllI.substring(lllllllllllllllllIIllllIlllllIlI.length());
                    if (StrUtils.startsWith(lllllllllllllllllIIllllIllllIllI, lllllllllllllllllIIllllIlllIlllI) && StrUtils.endsWith(lllllllllllllllllIIllllIllllIllI, lllllllllllllllllIIllllIlllIllIl)) {
                        lllllllllllllllllIIllllIlllllIll.add(lllllllllllllllllIIllllIllllIllI);
                    }
                }
            }
            else if (lllllllllllllllllIIllllIllllIlll.isDirectory()) {
                final String lllllllllllllllllIIllllIllllIlIl = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllllIIllllIlllIllll)).append(lllllllllllllllllIIllllIllllIlll.getName()).append("/"));
                final String[] lllllllllllllllllIIllllIllllIlII = collectFilesFolder(lllllllllllllllllIIllllIllllIlll, lllllllllllllllllIIllllIllllIlIl, lllllllllllllllllIIllllIlllIlllI, lllllllllllllllllIIllllIlllIllIl);
                for (int lllllllllllllllllIIllllIllllIIll = 0; lllllllllllllllllIIllllIllllIIll < lllllllllllllllllIIllllIllllIlII.length; ++lllllllllllllllllIIllllIllllIIll) {
                    final String lllllllllllllllllIIllllIllllIIlI = lllllllllllllllllIIllllIllllIlII[lllllllllllllllllIIllllIllllIIll];
                    lllllllllllllllllIIllllIlllllIll.add(lllllllllllllllllIIllllIllllIIlI);
                }
            }
        }
        final String[] lllllllllllllllllIIllllIllllIIIl = lllllllllllllllllIIllllIlllllIll.toArray(new String[lllllllllllllllllIIllllIlllllIll.size()]);
        return lllllllllllllllllIIllllIllllIIIl;
    }
    
    public static String[] collectFiles(final IResourcePack lllllllllllllllllIIlllllIIlIlIll, final String[] lllllllllllllllllIIlllllIIlIlIlI, final String[] lllllllllllllllllIIlllllIIlIIIll, final String[] lllllllllllllllllIIlllllIIlIIIlI) {
        if (lllllllllllllllllIIlllllIIlIlIll instanceof DefaultResourcePack) {
            return collectFilesFixed(lllllllllllllllllIIlllllIIlIlIll, lllllllllllllllllIIlllllIIlIIIlI);
        }
        if (!(lllllllllllllllllIIlllllIIlIlIll instanceof AbstractResourcePack)) {
            return new String[0];
        }
        final AbstractResourcePack lllllllllllllllllIIlllllIIlIIlll = (AbstractResourcePack)lllllllllllllllllIIlllllIIlIlIll;
        final File lllllllllllllllllIIlllllIIlIIllI = lllllllllllllllllIIlllllIIlIIlll.resourcePackFile;
        return (lllllllllllllllllIIlllllIIlIIllI == null) ? new String[0] : (lllllllllllllllllIIlllllIIlIIllI.isDirectory() ? collectFilesFolder(lllllllllllllllllIIlllllIIlIIllI, "", lllllllllllllllllIIlllllIIlIlIlI, lllllllllllllllllIIlllllIIlIIIll) : (lllllllllllllllllIIlllllIIlIIllI.isFile() ? collectFilesZIP(lllllllllllllllllIIlllllIIlIIllI, lllllllllllllllllIIlllllIIlIlIlI, lllllllllllllllllIIlllllIIlIIIll) : new String[0]));
    }
    
    public static String[] collectFiles(final IResourcePack lllllllllllllllllIIlllllIIlllllI, final String lllllllllllllllllIIlllllIIllllIl, final String lllllllllllllllllIIlllllIlIIIIII, final String[] lllllllllllllllllIIlllllIIlllIll) {
        return collectFiles(lllllllllllllllllIIlllllIIlllllI, new String[] { lllllllllllllllllIIlllllIIllllIl }, new String[] { lllllllllllllllllIIlllllIlIIIIII }, lllllllllllllllllIIlllllIIlllIll);
    }
}
