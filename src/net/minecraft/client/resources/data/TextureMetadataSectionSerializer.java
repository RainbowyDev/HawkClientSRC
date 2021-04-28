package net.minecraft.client.resources.data;

import java.lang.reflect.*;
import net.minecraft.util.*;
import com.google.common.collect.*;
import java.util.*;
import com.google.gson.*;

public class TextureMetadataSectionSerializer extends BaseMetadataSectionSerializer
{
    public TextureMetadataSection deserialize(final JsonElement llllllllllllllIIlIlllllIIlllIIll, final Type llllllllllllllIIlIlllllIIlllIIlI, final JsonDeserializationContext llllllllllllllIIlIlllllIIlllIIIl) {
        final JsonObject llllllllllllllIIlIlllllIIlllIIII = llllllllllllllIIlIlllllIIlllIIll.getAsJsonObject();
        final boolean llllllllllllllIIlIlllllIIllIllll = JsonUtils.getJsonObjectBooleanFieldValueOrDefault(llllllllllllllIIlIlllllIIlllIIII, "blur", false);
        final boolean llllllllllllllIIlIlllllIIllIlllI = JsonUtils.getJsonObjectBooleanFieldValueOrDefault(llllllllllllllIIlIlllllIIlllIIII, "clamp", false);
        final ArrayList llllllllllllllIIlIlllllIIllIllIl = Lists.newArrayList();
        if (llllllllllllllIIlIlllllIIlllIIII.has("mipmaps")) {
            try {
                final JsonArray llllllllllllllIIlIlllllIIllIllII = llllllllllllllIIlIlllllIIlllIIII.getAsJsonArray("mipmaps");
                for (int llllllllllllllIIlIlllllIIllIlIll = 0; llllllllllllllIIlIlllllIIllIlIll < llllllllllllllIIlIlllllIIllIllII.size(); ++llllllllllllllIIlIlllllIIllIlIll) {
                    final JsonElement llllllllllllllIIlIlllllIIllIlIlI = llllllllllllllIIlIlllllIIllIllII.get(llllllllllllllIIlIlllllIIllIlIll);
                    if (llllllllllllllIIlIlllllIIllIlIlI.isJsonPrimitive()) {
                        try {
                            llllllllllllllIIlIlllllIIllIllIl.add(llllllllllllllIIlIlllllIIllIlIlI.getAsInt());
                            continue;
                        }
                        catch (NumberFormatException llllllllllllllIIlIlllllIIllIlIIl) {
                            throw new JsonParseException(String.valueOf(new StringBuilder("Invalid texture->mipmap->").append(llllllllllllllIIlIlllllIIllIlIll).append(": expected number, was ").append(llllllllllllllIIlIlllllIIllIlIlI)), (Throwable)llllllllllllllIIlIlllllIIllIlIIl);
                        }
                    }
                    if (llllllllllllllIIlIlllllIIllIlIlI.isJsonObject()) {
                        throw new JsonParseException(String.valueOf(new StringBuilder("Invalid texture->mipmap->").append(llllllllllllllIIlIlllllIIllIlIll).append(": expected number, was ").append(llllllllllllllIIlIlllllIIllIlIlI)));
                    }
                }
            }
            catch (ClassCastException llllllllllllllIIlIlllllIIllIlIII) {
                throw new JsonParseException(String.valueOf(new StringBuilder("Invalid texture->mipmaps: expected array, was ").append(llllllllllllllIIlIlllllIIlllIIII.get("mipmaps"))), (Throwable)llllllllllllllIIlIlllllIIllIlIII);
            }
        }
        return new TextureMetadataSection(llllllllllllllIIlIlllllIIllIllll, llllllllllllllIIlIlllllIIllIlllI, llllllllllllllIIlIlllllIIllIllIl);
    }
    
    @Override
    public String getSectionName() {
        return "texture";
    }
    
    static {
        __OBFID = "CL_00001115";
    }
}
