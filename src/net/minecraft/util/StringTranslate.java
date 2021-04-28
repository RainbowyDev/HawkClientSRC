package net.minecraft.util;

import com.google.common.base.*;
import java.util.regex.*;
import org.apache.commons.io.*;
import com.google.common.collect.*;
import java.io.*;
import java.util.*;

public class StringTranslate
{
    private /* synthetic */ long lastUpdateTimeInMilliseconds;
    private final /* synthetic */ Map languageList;
    private static /* synthetic */ StringTranslate instance;
    private static final /* synthetic */ Splitter equalSignSplitter;
    private static final /* synthetic */ Pattern numericVariablePattern;
    
    public long getLastUpdateTimeInMilliseconds() {
        return this.lastUpdateTimeInMilliseconds;
    }
    
    static StringTranslate getInstance() {
        return StringTranslate.instance;
    }
    
    public StringTranslate() {
        this.languageList = Maps.newHashMap();
        try {
            final InputStream llllllllllllllllIIllIIlIlllIllII = StringTranslate.class.getResourceAsStream("/assets/minecraft/lang/en_US.lang");
            for (final String llllllllllllllllIIllIIlIlllIlIlI : IOUtils.readLines(llllllllllllllllIIllIIlIlllIllII, Charsets.UTF_8)) {
                if (!llllllllllllllllIIllIIlIlllIlIlI.isEmpty() && llllllllllllllllIIllIIlIlllIlIlI.charAt(0) != '#') {
                    final String[] llllllllllllllllIIllIIlIlllIlIIl = (String[])Iterables.toArray(StringTranslate.equalSignSplitter.split((CharSequence)llllllllllllllllIIllIIlIlllIlIlI), (Class)String.class);
                    if (llllllllllllllllIIllIIlIlllIlIIl == null || llllllllllllllllIIllIIlIlllIlIIl.length != 2) {
                        continue;
                    }
                    final String llllllllllllllllIIllIIlIlllIlIII = llllllllllllllllIIllIIlIlllIlIIl[0];
                    final String llllllllllllllllIIllIIlIlllIIlll = StringTranslate.numericVariablePattern.matcher(llllllllllllllllIIllIIlIlllIlIIl[1]).replaceAll("%$1s");
                    this.languageList.put(llllllllllllllllIIllIIlIlllIlIII, llllllllllllllllIIllIIlIlllIIlll);
                }
            }
            this.lastUpdateTimeInMilliseconds = System.currentTimeMillis();
        }
        catch (IOException ex) {}
    }
    
    public synchronized String translateKeyFormat(final String llllllllllllllllIIllIIlIllIIlIll, final Object... llllllllllllllllIIllIIlIllIIllll) {
        final String llllllllllllllllIIllIIlIllIIlllI = this.tryTranslateKey(llllllllllllllllIIllIIlIllIIlIll);
        try {
            return String.format(llllllllllllllllIIllIIlIllIIlllI, llllllllllllllllIIllIIlIllIIllll);
        }
        catch (IllegalFormatException llllllllllllllllIIllIIlIllIIllIl) {
            return String.valueOf(new StringBuilder("Format error: ").append(llllllllllllllllIIllIIlIllIIlllI));
        }
    }
    
    private String tryTranslateKey(final String llllllllllllllllIIllIIlIllIIIIII) {
        final String llllllllllllllllIIllIIlIllIIIIlI = this.languageList.get(llllllllllllllllIIllIIlIllIIIIII);
        return (llllllllllllllllIIllIIlIllIIIIlI == null) ? llllllllllllllllIIllIIlIllIIIIII : llllllllllllllllIIllIIlIllIIIIlI;
    }
    
    public static synchronized void replaceWith(final Map llllllllllllllllIIllIIlIllIllllI) {
        StringTranslate.instance.languageList.clear();
        StringTranslate.instance.languageList.putAll(llllllllllllllllIIllIIlIllIllllI);
        StringTranslate.instance.lastUpdateTimeInMilliseconds = System.currentTimeMillis();
    }
    
    public synchronized boolean isKeyTranslated(final String llllllllllllllllIIllIIlIlIlllIll) {
        return this.languageList.containsKey(llllllllllllllllIIllIIlIlIlllIll);
    }
    
    static {
        __OBFID = "CL_00001212";
        numericVariablePattern = Pattern.compile("%(\\d+\\$)?[\\d\\.]*[df]");
        equalSignSplitter = Splitter.on('=').limit(2);
        StringTranslate.instance = new StringTranslate();
    }
    
    public synchronized String translateKey(final String llllllllllllllllIIllIIlIllIllIIl) {
        return this.tryTranslateKey(llllllllllllllllIIllIIlIllIllIIl);
    }
}
