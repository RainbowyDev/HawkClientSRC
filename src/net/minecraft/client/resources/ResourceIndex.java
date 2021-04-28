package net.minecraft.client.resources;

import org.apache.logging.log4j.*;
import com.google.common.collect.*;
import com.google.common.base.*;
import com.google.common.io.*;
import net.minecraft.util.*;
import com.google.gson.*;
import org.apache.commons.io.*;
import java.io.*;
import java.util.*;

public class ResourceIndex
{
    private final /* synthetic */ Map field_152784_b;
    private static final /* synthetic */ Logger field_152783_a;
    
    static {
        __OBFID = "CL_00001831";
        field_152783_a = LogManager.getLogger();
    }
    
    public Map func_152782_a() {
        return this.field_152784_b;
    }
    
    public ResourceIndex(final File lllIIIlIlIlIlII, final String lllIIIlIllIIlIl) {
        this.field_152784_b = Maps.newHashMap();
        if (lllIIIlIllIIlIl != null) {
            final File lllIIIlIllIIlII = new File(lllIIIlIlIlIlII, "objects");
            final File lllIIIlIllIIIll = new File(lllIIIlIlIlIlII, String.valueOf(new StringBuilder("indexes/").append(lllIIIlIllIIlIl).append(".json")));
            BufferedReader lllIIIlIllIIIlI = null;
            try {
                lllIIIlIllIIIlI = Files.newReader(lllIIIlIllIIIll, Charsets.UTF_8);
                final JsonObject lllIIIlIllIIIIl = new JsonParser().parse((Reader)lllIIIlIllIIIlI).getAsJsonObject();
                final JsonObject lllIIIlIllIIIII = JsonUtils.getJsonObjectFieldOrDefault(lllIIIlIllIIIIl, "objects", null);
                if (lllIIIlIllIIIII != null) {
                    for (final Map.Entry lllIIIlIlIllllI : lllIIIlIllIIIII.entrySet()) {
                        final JsonObject lllIIIlIlIlllIl = lllIIIlIlIllllI.getValue();
                        final String lllIIIlIlIlllII = lllIIIlIlIllllI.getKey();
                        final String[] lllIIIlIlIllIll = lllIIIlIlIlllII.split("/", 2);
                        final String lllIIIlIlIllIlI = (lllIIIlIlIllIll.length == 1) ? lllIIIlIlIllIll[0] : String.valueOf(new StringBuilder(String.valueOf(lllIIIlIlIllIll[0])).append(":").append(lllIIIlIlIllIll[1]));
                        final String lllIIIlIlIllIIl = JsonUtils.getJsonObjectStringFieldValue(lllIIIlIlIlllIl, "hash");
                        final File lllIIIlIlIllIII = new File(lllIIIlIllIIlII, String.valueOf(new StringBuilder(String.valueOf(lllIIIlIlIllIIl.substring(0, 2))).append("/").append(lllIIIlIlIllIIl)));
                        this.field_152784_b.put(lllIIIlIlIllIlI, lllIIIlIlIllIII);
                    }
                }
            }
            catch (JsonParseException lllIIIlIlIlIlll) {
                ResourceIndex.field_152783_a.error(String.valueOf(new StringBuilder("Unable to parse resource index file: ").append(lllIIIlIllIIIll)));
            }
            catch (FileNotFoundException lllIIIlIlIlIllI) {
                ResourceIndex.field_152783_a.error(String.valueOf(new StringBuilder("Can't find the resource index file: ").append(lllIIIlIllIIIll)));
            }
            finally {
                IOUtils.closeQuietly((Reader)lllIIIlIllIIIlI);
            }
            IOUtils.closeQuietly((Reader)lllIIIlIllIIIlI);
        }
    }
}
