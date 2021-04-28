package net.minecraft.client.resources.data;

import java.lang.reflect.*;
import net.minecraft.util.*;
import org.apache.commons.lang3.*;
import com.google.gson.*;

public class FontMetadataSectionSerializer extends BaseMetadataSectionSerializer
{
    public FontMetadataSection deserialize(final JsonElement llllllllllllllIIIIIIIIlllIIlIlll, final Type llllllllllllllIIIIIIIIlllIlIlIII, final JsonDeserializationContext llllllllllllllIIIIIIIIlllIlIIlll) {
        final JsonObject llllllllllllllIIIIIIIIlllIlIIllI = llllllllllllllIIIIIIIIlllIIlIlll.getAsJsonObject();
        final float[] llllllllllllllIIIIIIIIlllIlIIlIl = new float[256];
        final float[] llllllllllllllIIIIIIIIlllIlIIlII = new float[256];
        final float[] llllllllllllllIIIIIIIIlllIlIIIll = new float[256];
        float llllllllllllllIIIIIIIIlllIlIIIlI = 1.0f;
        float llllllllllllllIIIIIIIIlllIlIIIIl = 0.0f;
        float llllllllllllllIIIIIIIIlllIlIIIII = 0.0f;
        if (llllllllllllllIIIIIIIIlllIlIIllI.has("characters")) {
            if (!llllllllllllllIIIIIIIIlllIlIIllI.get("characters").isJsonObject()) {
                throw new JsonParseException(String.valueOf(new StringBuilder("Invalid font->characters: expected object, was ").append(llllllllllllllIIIIIIIIlllIlIIllI.get("characters"))));
            }
            final JsonObject llllllllllllllIIIIIIIIlllIIlllll = llllllllllllllIIIIIIIIlllIlIIllI.getAsJsonObject("characters");
            if (llllllllllllllIIIIIIIIlllIIlllll.has("default")) {
                if (!llllllllllllllIIIIIIIIlllIIlllll.get("default").isJsonObject()) {
                    throw new JsonParseException(String.valueOf(new StringBuilder("Invalid font->characters->default: expected object, was ").append(llllllllllllllIIIIIIIIlllIIlllll.get("default"))));
                }
                final JsonObject llllllllllllllIIIIIIIIlllIIllllI = llllllllllllllIIIIIIIIlllIIlllll.getAsJsonObject("default");
                llllllllllllllIIIIIIIIlllIlIIIlI = JsonUtils.getJsonObjectFloatFieldValueOrDefault(llllllllllllllIIIIIIIIlllIIllllI, "width", llllllllllllllIIIIIIIIlllIlIIIlI);
                Validate.inclusiveBetween(0.0, 3.4028234663852886E38, (double)llllllllllllllIIIIIIIIlllIlIIIlI, "Invalid default width");
                llllllllllllllIIIIIIIIlllIlIIIIl = JsonUtils.getJsonObjectFloatFieldValueOrDefault(llllllllllllllIIIIIIIIlllIIllllI, "spacing", llllllllllllllIIIIIIIIlllIlIIIIl);
                Validate.inclusiveBetween(0.0, 3.4028234663852886E38, (double)llllllllllllllIIIIIIIIlllIlIIIIl, "Invalid default spacing");
                llllllllllllllIIIIIIIIlllIlIIIII = JsonUtils.getJsonObjectFloatFieldValueOrDefault(llllllllllllllIIIIIIIIlllIIllllI, "left", llllllllllllllIIIIIIIIlllIlIIIIl);
                Validate.inclusiveBetween(0.0, 3.4028234663852886E38, (double)llllllllllllllIIIIIIIIlllIlIIIII, "Invalid default left");
            }
            for (int llllllllllllllIIIIIIIIlllIIlllIl = 0; llllllllllllllIIIIIIIIlllIIlllIl < 256; ++llllllllllllllIIIIIIIIlllIIlllIl) {
                final JsonElement llllllllllllllIIIIIIIIlllIIlllII = llllllllllllllIIIIIIIIlllIIlllll.get(Integer.toString(llllllllllllllIIIIIIIIlllIIlllIl));
                float llllllllllllllIIIIIIIIlllIIllIll = llllllllllllllIIIIIIIIlllIlIIIlI;
                float llllllllllllllIIIIIIIIlllIIllIlI = llllllllllllllIIIIIIIIlllIlIIIIl;
                float llllllllllllllIIIIIIIIlllIIllIIl = llllllllllllllIIIIIIIIlllIlIIIII;
                if (llllllllllllllIIIIIIIIlllIIlllII != null) {
                    final JsonObject llllllllllllllIIIIIIIIlllIIllIII = JsonUtils.getElementAsJsonObject(llllllllllllllIIIIIIIIlllIIlllII, String.valueOf(new StringBuilder("characters[").append(llllllllllllllIIIIIIIIlllIIlllIl).append("]")));
                    llllllllllllllIIIIIIIIlllIIllIll = JsonUtils.getJsonObjectFloatFieldValueOrDefault(llllllllllllllIIIIIIIIlllIIllIII, "width", llllllllllllllIIIIIIIIlllIlIIIlI);
                    Validate.inclusiveBetween(0.0, 3.4028234663852886E38, (double)llllllllllllllIIIIIIIIlllIIllIll, "Invalid width");
                    llllllllllllllIIIIIIIIlllIIllIlI = JsonUtils.getJsonObjectFloatFieldValueOrDefault(llllllllllllllIIIIIIIIlllIIllIII, "spacing", llllllllllllllIIIIIIIIlllIlIIIIl);
                    Validate.inclusiveBetween(0.0, 3.4028234663852886E38, (double)llllllllllllllIIIIIIIIlllIIllIlI, "Invalid spacing");
                    llllllllllllllIIIIIIIIlllIIllIIl = JsonUtils.getJsonObjectFloatFieldValueOrDefault(llllllllllllllIIIIIIIIlllIIllIII, "left", llllllllllllllIIIIIIIIlllIlIIIII);
                    Validate.inclusiveBetween(0.0, 3.4028234663852886E38, (double)llllllllllllllIIIIIIIIlllIIllIIl, "Invalid left");
                }
                llllllllllllllIIIIIIIIlllIlIIlIl[llllllllllllllIIIIIIIIlllIIlllIl] = llllllllllllllIIIIIIIIlllIIllIll;
                llllllllllllllIIIIIIIIlllIlIIlII[llllllllllllllIIIIIIIIlllIIlllIl] = llllllllllllllIIIIIIIIlllIIllIlI;
                llllllllllllllIIIIIIIIlllIlIIIll[llllllllllllllIIIIIIIIlllIIlllIl] = llllllllllllllIIIIIIIIlllIIllIIl;
            }
        }
        return new FontMetadataSection(llllllllllllllIIIIIIIIlllIlIIlIl, llllllllllllllIIIIIIIIlllIlIIIll, llllllllllllllIIIIIIIIlllIlIIlII);
    }
    
    @Override
    public String getSectionName() {
        return "font";
    }
    
    static {
        __OBFID = "CL_00001109";
    }
}
