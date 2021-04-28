package net.minecraft.client.resources.data;

import net.minecraft.util.*;
import org.apache.commons.lang3.*;
import java.lang.reflect.*;
import com.google.gson.*;
import com.google.common.collect.*;
import java.util.*;

public class AnimationMetadataSectionSerializer extends BaseMetadataSectionSerializer implements JsonSerializer
{
    private AnimationFrame parseAnimationFrame(final int llllllllllllllIIIIlIllllllIlllIl, final JsonElement llllllllllllllIIIIlIlllllllIIIIl) {
        if (llllllllllllllIIIIlIlllllllIIIIl.isJsonPrimitive()) {
            return new AnimationFrame(JsonUtils.getJsonElementIntegerValue(llllllllllllllIIIIlIlllllllIIIIl, String.valueOf(new StringBuilder("frames[").append(llllllllllllllIIIIlIllllllIlllIl).append("]"))));
        }
        if (llllllllllllllIIIIlIlllllllIIIIl.isJsonObject()) {
            final JsonObject llllllllllllllIIIIlIlllllllIIIII = JsonUtils.getElementAsJsonObject(llllllllllllllIIIIlIlllllllIIIIl, String.valueOf(new StringBuilder("frames[").append(llllllllllllllIIIIlIllllllIlllIl).append("]")));
            final int llllllllllllllIIIIlIllllllIlllll = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllIIIIlIlllllllIIIII, "time", -1);
            if (llllllllllllllIIIIlIlllllllIIIII.has("time")) {
                Validate.inclusiveBetween(1L, 2147483647L, (long)llllllllllllllIIIIlIllllllIlllll, "Invalid frame time");
            }
            final int llllllllllllllIIIIlIllllllIllllI = JsonUtils.getJsonObjectIntegerFieldValue(llllllllllllllIIIIlIlllllllIIIII, "index");
            Validate.inclusiveBetween(0L, 2147483647L, (long)llllllllllllllIIIIlIllllllIllllI, "Invalid frame index");
            return new AnimationFrame(llllllllllllllIIIIlIllllllIllllI, llllllllllllllIIIIlIllllllIlllll);
        }
        return null;
    }
    
    public JsonElement serialize(final AnimationMetadataSection llllllllllllllIIIIlIllllllIIlIll, final Type llllllllllllllIIIIlIllllllIlIIIl, final JsonSerializationContext llllllllllllllIIIIlIllllllIlIIII) {
        final JsonObject llllllllllllllIIIIlIllllllIIllll = new JsonObject();
        llllllllllllllIIIIlIllllllIIllll.addProperty("frametime", (Number)llllllllllllllIIIIlIllllllIIlIll.getFrameTime());
        if (llllllllllllllIIIIlIllllllIIlIll.getFrameWidth() != -1) {
            llllllllllllllIIIIlIllllllIIllll.addProperty("width", (Number)llllllllllllllIIIIlIllllllIIlIll.getFrameWidth());
        }
        if (llllllllllllllIIIIlIllllllIIlIll.getFrameHeight() != -1) {
            llllllllllllllIIIIlIllllllIIllll.addProperty("height", (Number)llllllllllllllIIIIlIllllllIIlIll.getFrameHeight());
        }
        if (llllllllllllllIIIIlIllllllIIlIll.getFrameCount() > 0) {
            final JsonArray llllllllllllllIIIIlIllllllIIlllI = new JsonArray();
            for (int llllllllllllllIIIIlIllllllIIllIl = 0; llllllllllllllIIIIlIllllllIIllIl < llllllllllllllIIIIlIllllllIIlIll.getFrameCount(); ++llllllllllllllIIIIlIllllllIIllIl) {
                if (llllllllllllllIIIIlIllllllIIlIll.frameHasTime(llllllllllllllIIIIlIllllllIIllIl)) {
                    final JsonObject llllllllllllllIIIIlIllllllIIllII = new JsonObject();
                    llllllllllllllIIIIlIllllllIIllII.addProperty("index", (Number)llllllllllllllIIIIlIllllllIIlIll.getFrameIndex(llllllllllllllIIIIlIllllllIIllIl));
                    llllllllllllllIIIIlIllllllIIllII.addProperty("time", (Number)llllllllllllllIIIIlIllllllIIlIll.getFrameTimeSingle(llllllllllllllIIIIlIllllllIIllIl));
                    llllllllllllllIIIIlIllllllIIlllI.add((JsonElement)llllllllllllllIIIIlIllllllIIllII);
                }
                else {
                    llllllllllllllIIIIlIllllllIIlllI.add((JsonElement)new JsonPrimitive((Number)llllllllllllllIIIIlIllllllIIlIll.getFrameIndex(llllllllllllllIIIIlIllllllIIllIl)));
                }
            }
            llllllllllllllIIIIlIllllllIIllll.add("frames", (JsonElement)llllllllllllllIIIIlIllllllIIlllI);
        }
        return (JsonElement)llllllllllllllIIIIlIllllllIIllll;
    }
    
    static {
        __OBFID = "CL_00001107";
    }
    
    public AnimationMetadataSection deserialize(final JsonElement llllllllllllllIIIIlIllllllllllll, final Type llllllllllllllIIIIlIlllllllllllI, final JsonDeserializationContext llllllllllllllIIIIlIllllllllllIl) {
        final ArrayList llllllllllllllIIIIlIllllllllllII = Lists.newArrayList();
        final JsonObject llllllllllllllIIIIlIlllllllllIll = JsonUtils.getElementAsJsonObject(llllllllllllllIIIIlIllllllllllll, "metadata section");
        final int llllllllllllllIIIIlIlllllllllIlI = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllIIIIlIlllllllllIll, "frametime", 1);
        if (llllllllllllllIIIIlIlllllllllIlI != 1) {
            Validate.inclusiveBetween(1L, 2147483647L, (long)llllllllllllllIIIIlIlllllllllIlI, "Invalid default frame time");
        }
        if (llllllllllllllIIIIlIlllllllllIll.has("frames")) {
            try {
                final JsonArray llllllllllllllIIIIlIllllllllIlll = JsonUtils.getJsonObjectJsonArrayField(llllllllllllllIIIIlIlllllllllIll, "frames");
                for (int llllllllllllllIIIIlIlllllllllIIl = 0; llllllllllllllIIIIlIlllllllllIIl < llllllllllllllIIIIlIllllllllIlll.size(); ++llllllllllllllIIIIlIlllllllllIIl) {
                    final JsonElement llllllllllllllIIIIlIllllllllIllI = llllllllllllllIIIIlIllllllllIlll.get(llllllllllllllIIIIlIlllllllllIIl);
                    final AnimationFrame llllllllllllllIIIIlIllllllllIlIl = this.parseAnimationFrame(llllllllllllllIIIIlIlllllllllIIl, llllllllllllllIIIIlIllllllllIllI);
                    if (llllllllllllllIIIIlIllllllllIlIl != null) {
                        llllllllllllllIIIIlIllllllllllII.add(llllllllllllllIIIIlIllllllllIlIl);
                    }
                }
            }
            catch (ClassCastException llllllllllllllIIIIlIllllllllIlII) {
                throw new JsonParseException(String.valueOf(new StringBuilder("Invalid animation->frames: expected array, was ").append(llllllllllllllIIIIlIlllllllllIll.get("frames"))), (Throwable)llllllllllllllIIIIlIllllllllIlII);
            }
        }
        final int llllllllllllllIIIIlIllllllllIIll = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllIIIIlIlllllllllIll, "width", -1);
        final int llllllllllllllIIIIlIlllllllllIII = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllIIIIlIlllllllllIll, "height", -1);
        if (llllllllllllllIIIIlIllllllllIIll != -1) {
            Validate.inclusiveBetween(1L, 2147483647L, (long)llllllllllllllIIIIlIllllllllIIll, "Invalid width");
        }
        if (llllllllllllllIIIIlIlllllllllIII != -1) {
            Validate.inclusiveBetween(1L, 2147483647L, (long)llllllllllllllIIIIlIlllllllllIII, "Invalid height");
        }
        final boolean llllllllllllllIIIIlIllllllllIIlI = JsonUtils.getJsonObjectBooleanFieldValueOrDefault(llllllllllllllIIIIlIlllllllllIll, "interpolate", false);
        return new AnimationMetadataSection(llllllllllllllIIIIlIllllllllllII, llllllllllllllIIIIlIllllllllIIll, llllllllllllllIIIIlIlllllllllIII, llllllllllllllIIIIlIlllllllllIlI, llllllllllllllIIIIlIllllllllIIlI);
    }
    
    public String getSectionName() {
        return "animation";
    }
    
    public JsonElement serialize(final Object llllllllllllllIIIIlIllllllIIIIII, final Type llllllllllllllIIIIlIlllllIlllIll, final JsonSerializationContext llllllllllllllIIIIlIlllllIlllIlI) {
        return this.serialize((AnimationMetadataSection)llllllllllllllIIIIlIllllllIIIIII, llllllllllllllIIIIlIlllllIlllIll, llllllllllllllIIIIlIlllllIlllIlI);
    }
}
