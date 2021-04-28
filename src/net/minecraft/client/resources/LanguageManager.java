package net.minecraft.client.resources;

import net.minecraft.client.resources.data.*;
import java.io.*;
import org.apache.logging.log4j.*;
import net.minecraft.util.*;
import java.util.*;
import com.google.common.collect.*;

public class LanguageManager implements IResourceManagerReloadListener
{
    private final /* synthetic */ IMetadataSerializer theMetadataSerializer;
    protected static final /* synthetic */ Locale currentLocale;
    private /* synthetic */ Map languageMap;
    private /* synthetic */ String currentLanguage;
    private static final /* synthetic */ Logger logger;
    
    public boolean isCurrentLocaleUnicode() {
        return LanguageManager.currentLocale.isUnicode();
    }
    
    public Language getCurrentLanguage() {
        return this.languageMap.containsKey(this.currentLanguage) ? this.languageMap.get(this.currentLanguage) : this.languageMap.get("en_US");
    }
    
    public void parseLanguageMetadata(final List lllllllllllllllllIIIllIIllIIIlII) {
        this.languageMap.clear();
        for (final IResourcePack lllllllllllllllllIIIllIIllIIIIlI : lllllllllllllllllIIIllIIllIIIlII) {
            try {
                final LanguageMetadataSection lllllllllllllllllIIIllIIllIIIIIl = (LanguageMetadataSection)lllllllllllllllllIIIllIIllIIIIlI.getPackMetadata(this.theMetadataSerializer, "language");
                if (lllllllllllllllllIIIllIIllIIIIIl == null) {
                    continue;
                }
                for (final Language lllllllllllllllllIIIllIIlIllllll : lllllllllllllllllIIIllIIllIIIIIl.getLanguages()) {
                    if (!this.languageMap.containsKey(lllllllllllllllllIIIllIIlIllllll.getLanguageCode())) {
                        this.languageMap.put(lllllllllllllllllIIIllIIlIllllll.getLanguageCode(), lllllllllllllllllIIIllIIlIllllll);
                    }
                }
            }
            catch (RuntimeException lllllllllllllllllIIIllIIlIlllllI) {
                LanguageManager.logger.warn(String.valueOf(new StringBuilder("Unable to parse metadata section of resourcepack: ").append(lllllllllllllllllIIIllIIllIIIIlI.getPackName())), (Throwable)lllllllllllllllllIIIllIIlIlllllI);
            }
            catch (IOException lllllllllllllllllIIIllIIlIllllIl) {
                LanguageManager.logger.warn(String.valueOf(new StringBuilder("Unable to parse metadata section of resourcepack: ").append(lllllllllllllllllIIIllIIllIIIIlI.getPackName())), (Throwable)lllllllllllllllllIIIllIIlIllllIl);
            }
        }
    }
    
    public boolean isCurrentLanguageBidirectional() {
        return this.getCurrentLanguage() != null && this.getCurrentLanguage().isBidirectional();
    }
    
    public SortedSet getLanguages() {
        return Sets.newTreeSet((Iterable)this.languageMap.values());
    }
    
    static {
        __OBFID = "CL_00001096";
        logger = LogManager.getLogger();
        currentLocale = new Locale();
    }
    
    @Override
    public void onResourceManagerReload(final IResourceManager lllllllllllllllllIIIllIIlIlIlllI) {
        final ArrayList lllllllllllllllllIIIllIIlIllIIII = Lists.newArrayList((Object[])new String[] { "en_US" });
        if (!"en_US".equals(this.currentLanguage)) {
            lllllllllllllllllIIIllIIlIllIIII.add(this.currentLanguage);
        }
        LanguageManager.currentLocale.loadLocaleDataFiles(lllllllllllllllllIIIllIIlIlIlllI, lllllllllllllllllIIIllIIlIllIIII);
        StringTranslate.replaceWith(LanguageManager.currentLocale.field_135032_a);
    }
    
    public void setCurrentLanguage(final Language lllllllllllllllllIIIllIIlIlIIIll) {
        this.currentLanguage = lllllllllllllllllIIIllIIlIlIIIll.getLanguageCode();
    }
    
    public LanguageManager(final IMetadataSerializer lllllllllllllllllIIIllIIllIlIIIl, final String lllllllllllllllllIIIllIIllIlIIII) {
        this.languageMap = Maps.newHashMap();
        this.theMetadataSerializer = lllllllllllllllllIIIllIIllIlIIIl;
        this.currentLanguage = lllllllllllllllllIIIllIIllIlIIII;
        I18n.setLocale(LanguageManager.currentLocale);
    }
}
