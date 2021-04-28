package net.minecraft.util;

import java.util.*;
import com.google.gson.*;
import com.google.common.collect.*;

public class JsonSerializableSet extends ForwardingSet implements IJsonSerializable
{
    private final /* synthetic */ Set underlyingSet;
    
    public void func_152753_a(final JsonElement llllllllllllllllIllIllllllIllIll) {
        if (llllllllllllllllIllIllllllIllIll.isJsonArray()) {
            for (final JsonElement llllllllllllllllIllIllllllIllIIl : llllllllllllllllIllIllllllIllIll.getAsJsonArray()) {
                this.add((Object)llllllllllllllllIllIllllllIllIIl.getAsString());
            }
        }
    }
    
    public JsonElement getSerializableElement() {
        final JsonArray llllllllllllllllIllIllllllIIllll = new JsonArray();
        for (final String llllllllllllllllIllIllllllIIllIl : this) {
            llllllllllllllllIllIllllllIIllll.add((JsonElement)new JsonPrimitive(llllllllllllllllIllIllllllIIllIl));
        }
        return (JsonElement)llllllllllllllllIllIllllllIIllll;
    }
    
    protected Set delegate() {
        return this.underlyingSet;
    }
    
    static {
        __OBFID = "CL_00001482";
    }
    
    public JsonSerializableSet() {
        this.underlyingSet = Sets.newHashSet();
    }
}
