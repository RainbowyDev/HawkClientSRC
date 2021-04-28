package net.minecraft.client.resources;

import java.util.regex.*;
import com.google.common.base.*;
import net.minecraft.util.*;
import java.util.*;
import java.io.*;
import org.apache.commons.io.*;
import com.google.common.collect.*;

public class Locale
{
    /* synthetic */ Map field_135032_a;
    private /* synthetic */ boolean field_135029_d;
    private static final /* synthetic */ Pattern field_135031_c;
    private static final /* synthetic */ Splitter splitter;
    
    public synchronized void loadLocaleDataFiles(final IResourceManager llllllllllllllIlllllIIIIIIIIllIl, final List llllllllllllllIlllllIIIIIIIlIlII) {
        this.field_135032_a.clear();
        for (final String llllllllllllllIlllllIIIIIIIlIIlI : llllllllllllllIlllllIIIIIIIlIlII) {
            final String llllllllllllllIlllllIIIIIIIlIIIl = String.format("lang/%s.lang", llllllllllllllIlllllIIIIIIIlIIlI);
            for (final String llllllllllllllIlllllIIIIIIIIllll : llllllllllllllIlllllIIIIIIIIllIl.getResourceDomains()) {
                try {
                    this.loadLocaleData(llllllllllllllIlllllIIIIIIIIllIl.getAllResources(new ResourceLocation(llllllllllllllIlllllIIIIIIIIllll, llllllllllllllIlllllIIIIIIIlIIIl)));
                }
                catch (IOException ex) {}
            }
        }
        this.checkUnicode();
    }
    
    private String translateKeyPrivate(final String llllllllllllllIllllIllllllIIIIlI) {
        final String llllllllllllllIllllIllllllIIIIIl = this.field_135032_a.get(llllllllllllllIllllIllllllIIIIlI);
        return (llllllllllllllIllllIllllllIIIIIl == null) ? llllllllllllllIllllIllllllIIIIlI : llllllllllllllIllllIllllllIIIIIl;
    }
    
    public boolean isUnicode() {
        return this.field_135029_d;
    }
    
    public Locale() {
        this.field_135032_a = Maps.newHashMap();
    }
    
    public String formatMessage(final String llllllllllllllIllllIlllllIllIIlI, final Object[] llllllllllllllIllllIlllllIllIllI) {
        final String llllllllllllllIllllIlllllIllIlIl = this.translateKeyPrivate(llllllllllllllIllllIlllllIllIIlI);
        try {
            return String.format(llllllllllllllIllllIlllllIllIlIl, llllllllllllllIllllIlllllIllIllI);
        }
        catch (IllegalFormatException llllllllllllllIllllIlllllIllIlII) {
            return String.valueOf(new StringBuilder("Format error: ").append(llllllllllllllIllllIlllllIllIlIl));
        }
    }
    
    private void loadLocaleData(final InputStream llllllllllllllIllllIllllllIIllII) throws IOException {
        for (final String llllllllllllllIllllIllllllIlIIIl : IOUtils.readLines(llllllllllllllIllllIllllllIIllII, Charsets.UTF_8)) {
            if (!llllllllllllllIllllIllllllIlIIIl.isEmpty() && llllllllllllllIllllIllllllIlIIIl.charAt(0) != '#') {
                final String[] llllllllllllllIllllIllllllIlIIII = (String[])Iterables.toArray(Locale.splitter.split((CharSequence)llllllllllllllIllllIllllllIlIIIl), (Class)String.class);
                if (llllllllllllllIllllIllllllIlIIII == null || llllllllllllllIllllIllllllIlIIII.length != 2) {
                    continue;
                }
                final String llllllllllllllIllllIllllllIIllll = llllllllllllllIllllIllllllIlIIII[0];
                final String llllllllllllllIllllIllllllIIlllI = Locale.field_135031_c.matcher(llllllllllllllIllllIllllllIlIIII[1]).replaceAll("%$1s");
                this.field_135032_a.put(llllllllllllllIllllIllllllIIllll, llllllllllllllIllllIllllllIIlllI);
            }
        }
    }
    
    private void loadLocaleData(final List llllllllllllllIllllIlllllllIIIII) throws IOException {
        for (final IResource llllllllllllllIllllIlllllllIIIll : llllllllllllllIllllIlllllllIIIII) {
            final InputStream llllllllllllllIllllIlllllllIIIlI = llllllllllllllIllllIlllllllIIIll.getInputStream();
            try {
                this.loadLocaleData(llllllllllllllIllllIlllllllIIIlI);
            }
            finally {
                IOUtils.closeQuietly(llllllllllllllIllllIlllllllIIIlI);
            }
            IOUtils.closeQuietly(llllllllllllllIllllIlllllllIIIlI);
        }
    }
    
    static {
        __OBFID = "CL_00001097";
        splitter = Splitter.on('=').limit(2);
        field_135031_c = Pattern.compile("%(\\d+\\$)?[\\d\\.]*[df]");
    }
    
    private void checkUnicode() {
        this.field_135029_d = false;
        int llllllllllllllIllllIlllllllllIlI = 0;
        int llllllllllllllIllllIlllllllllIIl = 0;
        for (final String llllllllllllllIllllIllllllllIlll : this.field_135032_a.values()) {
            final int llllllllllllllIllllIllllllllIllI = llllllllllllllIllllIllllllllIlll.length();
            llllllllllllllIllllIlllllllllIIl += llllllllllllllIllllIllllllllIllI;
            for (int llllllllllllllIllllIllllllllIlIl = 0; llllllllllllllIllllIllllllllIlIl < llllllllllllllIllllIllllllllIllI; ++llllllllllllllIllllIllllllllIlIl) {
                if (llllllllllllllIllllIllllllllIlll.charAt(llllllllllllllIllllIllllllllIlIl) >= '\u0100') {
                    ++llllllllllllllIllllIlllllllllIlI;
                }
            }
        }
        final float llllllllllllllIllllIllllllllIlII = llllllllllllllIllllIlllllllllIlI / (float)llllllllllllllIllllIlllllllllIIl;
        this.field_135029_d = (llllllllllllllIllllIllllllllIlII > 0.1);
    }
}
