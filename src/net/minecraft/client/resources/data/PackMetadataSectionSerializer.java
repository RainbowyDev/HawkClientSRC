package net.minecraft.client.resources.data;

import java.lang.reflect.*;
import com.google.gson.*;
import net.minecraft.util.*;

public class PackMetadataSectionSerializer extends BaseMetadataSectionSerializer implements JsonSerializer
{
    public JsonElement serialize(final Object llIIIlIIlllIllI, final Type llIIIlIIllllIIl, final JsonSerializationContext llIIIlIIllllIII) {
        return this.serialize((PackMetadataSection)llIIIlIIlllIllI, llIIIlIIllllIIl, llIIIlIIllllIII);
    }
    
    public JsonElement serialize(final PackMetadataSection llIIIlIlIIIIlll, final Type llIIIlIlIIIIllI, final JsonSerializationContext llIIIlIlIIIIlIl) {
        final JsonObject llIIIlIlIIIIlII = new JsonObject();
        llIIIlIlIIIIlII.addProperty("pack_format", (Number)llIIIlIlIIIIlll.getPackFormat());
        llIIIlIlIIIIlII.add("description", llIIIlIlIIIIlIl.serialize((Object)llIIIlIlIIIIlll.func_152805_a()));
        return (JsonElement)llIIIlIlIIIIlII;
    }
    
    public String getSectionName() {
        return "pack";
    }
    
    public PackMetadataSection deserialize(final JsonElement llIIIlIlIIllIIl, final Type llIIIlIlIIlllll, final JsonDeserializationContext llIIIlIlIIlllIl) {
        final JsonObject llIIIlIlIIlllII = llIIIlIlIIllIIl.getAsJsonObject();
        final IChatComponent llIIIlIlIIllIll = (IChatComponent)llIIIlIlIIlllIl.deserialize(llIIIlIlIIlllII.get("description"), (Type)IChatComponent.class);
        if (llIIIlIlIIllIll == null) {
            throw new JsonParseException("Invalid/missing description!");
        }
        final int llIIIlIlIIllIlI = JsonUtils.getJsonObjectIntegerFieldValue(llIIIlIlIIlllII, "pack_format");
        return new PackMetadataSection(llIIIlIlIIllIll, llIIIlIlIIllIlI);
    }
    
    static {
        __OBFID = "CL_00001113";
    }
}
