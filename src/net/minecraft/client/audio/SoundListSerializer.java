package net.minecraft.client.audio;

import java.lang.reflect.*;
import net.minecraft.util.*;
import org.apache.commons.lang3.*;
import com.google.gson.*;

public class SoundListSerializer implements JsonDeserializer
{
    static {
        __OBFID = "CL_00001124";
    }
    
    public Object deserialize(final JsonElement llllllllllllllIlIIIIIllIlIIlIIll, final Type llllllllllllllIlIIIIIllIlIIlIIlI, final JsonDeserializationContext llllllllllllllIlIIIIIllIlIIlIlIl) {
        return this.deserialize1(llllllllllllllIlIIIIIllIlIIlIIll, llllllllllllllIlIIIIIllIlIIlIIlI, llllllllllllllIlIIIIIllIlIIlIlIl);
    }
    
    public SoundList deserialize1(final JsonElement llllllllllllllIlIIIIIllIlIllIllI, final Type llllllllllllllIlIIIIIllIlIllIlIl, final JsonDeserializationContext llllllllllllllIlIIIIIllIlIllIlII) {
        final JsonObject llllllllllllllIlIIIIIllIlIllIIll = JsonUtils.getElementAsJsonObject(llllllllllllllIlIIIIIllIlIllIllI, "entry");
        final SoundList llllllllllllllIlIIIIIllIlIllIIlI = new SoundList();
        llllllllllllllIlIIIIIllIlIllIIlI.setReplaceExisting(JsonUtils.getJsonObjectBooleanFieldValueOrDefault(llllllllllllllIlIIIIIllIlIllIIll, "replace", false));
        final SoundCategory llllllllllllllIlIIIIIllIlIllIIIl = SoundCategory.func_147154_a(JsonUtils.getJsonObjectStringFieldValueOrDefault(llllllllllllllIlIIIIIllIlIllIIll, "category", SoundCategory.MASTER.getCategoryName()));
        llllllllllllllIlIIIIIllIlIllIIlI.setSoundCategory(llllllllllllllIlIIIIIllIlIllIIIl);
        Validate.notNull((Object)llllllllllllllIlIIIIIllIlIllIIIl, "Invalid category", new Object[0]);
        if (llllllllllllllIlIIIIIllIlIllIIll.has("sounds")) {
            final JsonArray llllllllllllllIlIIIIIllIlIllIIII = JsonUtils.getJsonObjectJsonArrayField(llllllllllllllIlIIIIIllIlIllIIll, "sounds");
            for (int llllllllllllllIlIIIIIllIlIlIllll = 0; llllllllllllllIlIIIIIllIlIlIllll < llllllllllllllIlIIIIIllIlIllIIII.size(); ++llllllllllllllIlIIIIIllIlIlIllll) {
                final JsonElement llllllllllllllIlIIIIIllIlIlIlllI = llllllllllllllIlIIIIIllIlIllIIII.get(llllllllllllllIlIIIIIllIlIlIllll);
                final SoundList.SoundEntry llllllllllllllIlIIIIIllIlIlIllIl = new SoundList.SoundEntry();
                if (JsonUtils.jsonElementTypeIsString(llllllllllllllIlIIIIIllIlIlIlllI)) {
                    llllllllllllllIlIIIIIllIlIlIllIl.setSoundEntryName(JsonUtils.getJsonElementStringValue(llllllllllllllIlIIIIIllIlIlIlllI, "sound"));
                }
                else {
                    final JsonObject llllllllllllllIlIIIIIllIlIlIllII = JsonUtils.getElementAsJsonObject(llllllllllllllIlIIIIIllIlIlIlllI, "sound");
                    llllllllllllllIlIIIIIllIlIlIllIl.setSoundEntryName(JsonUtils.getJsonObjectStringFieldValue(llllllllllllllIlIIIIIllIlIlIllII, "name"));
                    if (llllllllllllllIlIIIIIllIlIlIllII.has("type")) {
                        final SoundList.SoundEntry.Type llllllllllllllIlIIIIIllIlIlIlIll = SoundList.SoundEntry.Type.getType(JsonUtils.getJsonObjectStringFieldValue(llllllllllllllIlIIIIIllIlIlIllII, "type"));
                        Validate.notNull((Object)llllllllllllllIlIIIIIllIlIlIlIll, "Invalid type", new Object[0]);
                        llllllllllllllIlIIIIIllIlIlIllIl.setSoundEntryType(llllllllllllllIlIIIIIllIlIlIlIll);
                    }
                    if (llllllllllllllIlIIIIIllIlIlIllII.has("volume")) {
                        final float llllllllllllllIlIIIIIllIlIlIlIlI = JsonUtils.getJsonObjectFloatFieldValue(llllllllllllllIlIIIIIllIlIlIllII, "volume");
                        Validate.isTrue(llllllllllllllIlIIIIIllIlIlIlIlI > 0.0f, "Invalid volume", new Object[0]);
                        llllllllllllllIlIIIIIllIlIlIllIl.setSoundEntryVolume(llllllllllllllIlIIIIIllIlIlIlIlI);
                    }
                    if (llllllllllllllIlIIIIIllIlIlIllII.has("pitch")) {
                        final float llllllllllllllIlIIIIIllIlIlIlIIl = JsonUtils.getJsonObjectFloatFieldValue(llllllllllllllIlIIIIIllIlIlIllII, "pitch");
                        Validate.isTrue(llllllllllllllIlIIIIIllIlIlIlIIl > 0.0f, "Invalid pitch", new Object[0]);
                        llllllllllllllIlIIIIIllIlIlIllIl.setSoundEntryPitch(llllllllllllllIlIIIIIllIlIlIlIIl);
                    }
                    if (llllllllllllllIlIIIIIllIlIlIllII.has("weight")) {
                        final int llllllllllllllIlIIIIIllIlIlIlIII = JsonUtils.getJsonObjectIntegerFieldValue(llllllllllllllIlIIIIIllIlIlIllII, "weight");
                        Validate.isTrue(llllllllllllllIlIIIIIllIlIlIlIII > 0, "Invalid weight", new Object[0]);
                        llllllllllllllIlIIIIIllIlIlIllIl.setSoundEntryWeight(llllllllllllllIlIIIIIllIlIlIlIII);
                    }
                    if (llllllllllllllIlIIIIIllIlIlIllII.has("stream")) {
                        llllllllllllllIlIIIIIllIlIlIllIl.setStreaming(JsonUtils.getJsonObjectBooleanFieldValue(llllllllllllllIlIIIIIllIlIlIllII, "stream"));
                    }
                }
                llllllllllllllIlIIIIIllIlIllIIlI.getSoundList().add(llllllllllllllIlIIIIIllIlIlIllIl);
            }
        }
        return llllllllllllllIlIIIIIllIlIllIIlI;
    }
}
