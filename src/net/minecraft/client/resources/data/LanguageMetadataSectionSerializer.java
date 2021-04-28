package net.minecraft.client.resources.data;

import java.lang.reflect.*;
import com.google.common.collect.*;
import net.minecraft.util.*;
import net.minecraft.client.resources.*;
import com.google.gson.*;
import java.util.*;

public class LanguageMetadataSectionSerializer extends BaseMetadataSectionSerializer
{
    @Override
    public String getSectionName() {
        return "language";
    }
    
    public LanguageMetadataSection deserialize(final JsonElement llllllllllllllIIIlIlIIIIIIIlllIl, final Type llllllllllllllIIIlIlIIIIIIIlllII, final JsonDeserializationContext llllllllllllllIIIlIlIIIIIIIllIll) {
        final JsonObject llllllllllllllIIIlIlIIIIIIIllIlI = llllllllllllllIIIlIlIIIIIIIlllIl.getAsJsonObject();
        final HashSet llllllllllllllIIIlIlIIIIIIIllIIl = Sets.newHashSet();
        for (final Map.Entry llllllllllllllIIIlIlIIIIIIIlIIll : llllllllllllllIIIlIlIIIIIIIllIlI.entrySet()) {
            final String llllllllllllllIIIlIlIIIIIIIlIlll = llllllllllllllIIIlIlIIIIIIIlIIll.getKey();
            final JsonObject llllllllllllllIIIlIlIIIIIIIlIIlI = JsonUtils.getElementAsJsonObject(llllllllllllllIIIlIlIIIIIIIlIIll.getValue(), "language");
            final String llllllllllllllIIIlIlIIIIIIIlIllI = JsonUtils.getJsonObjectStringFieldValue(llllllllllllllIIIlIlIIIIIIIlIIlI, "region");
            final String llllllllllllllIIIlIlIIIIIIIlIlIl = JsonUtils.getJsonObjectStringFieldValue(llllllllllllllIIIlIlIIIIIIIlIIlI, "name");
            final boolean llllllllllllllIIIlIlIIIIIIIlIlII = JsonUtils.getJsonObjectBooleanFieldValueOrDefault(llllllllllllllIIIlIlIIIIIIIlIIlI, "bidirectional", false);
            if (llllllllllllllIIIlIlIIIIIIIlIllI.isEmpty()) {
                throw new JsonParseException(String.valueOf(new StringBuilder("Invalid language->'").append(llllllllllllllIIIlIlIIIIIIIlIlll).append("'->region: empty value")));
            }
            if (llllllllllllllIIIlIlIIIIIIIlIlIl.isEmpty()) {
                throw new JsonParseException(String.valueOf(new StringBuilder("Invalid language->'").append(llllllllllllllIIIlIlIIIIIIIlIlll).append("'->name: empty value")));
            }
            if (!llllllllllllllIIIlIlIIIIIIIllIIl.add(new Language(llllllllllllllIIIlIlIIIIIIIlIlll, llllllllllllllIIIlIlIIIIIIIlIllI, llllllllllllllIIIlIlIIIIIIIlIlIl, llllllllllllllIIIlIlIIIIIIIlIlII))) {
                throw new JsonParseException(String.valueOf(new StringBuilder("Duplicate language->'").append(llllllllllllllIIIlIlIIIIIIIlIlll).append("' defined")));
            }
        }
        return new LanguageMetadataSection(llllllllllllllIIIlIlIIIIIIIllIIl);
    }
    
    static {
        __OBFID = "CL_00001111";
    }
}
