package net.minecraft.util;

import com.google.gson.reflect.*;
import com.google.gson.*;
import com.google.common.collect.*;
import java.util.*;
import java.io.*;
import com.google.gson.stream.*;

public class EnumTypeAdapterFactory implements TypeAdapterFactory
{
    private String func_151232_a(final Object lllllllllllllllIllIIIllllIlIIlIl) {
        return (lllllllllllllllIllIIIllllIlIIlIl instanceof Enum) ? ((Enum)lllllllllllllllIllIIIllllIlIIlIl).name().toLowerCase(Locale.US) : lllllllllllllllIllIIIllllIlIIlIl.toString().toLowerCase(Locale.US);
    }
    
    static {
        __OBFID = "CL_00001494";
    }
    
    public TypeAdapter create(final Gson lllllllllllllllIllIIIllllIllIlll, final TypeToken lllllllllllllllIllIIIllllIlIlllI) {
        final Class lllllllllllllllIllIIIllllIllIlIl = lllllllllllllllIllIIIllllIlIlllI.getRawType();
        if (!lllllllllllllllIllIIIllllIllIlIl.isEnum()) {
            return null;
        }
        final HashMap lllllllllllllllIllIIIllllIllIlII = Maps.newHashMap();
        for (final Object lllllllllllllllIllIIIllllIllIIII : lllllllllllllllIllIIIllllIllIlIl.getEnumConstants()) {
            lllllllllllllllIllIIIllllIllIlII.put(this.func_151232_a(lllllllllllllllIllIIIllllIllIIII), lllllllllllllllIllIIIllllIllIIII);
        }
        return new TypeAdapter() {
            static {
                __OBFID = "CL_00001495";
            }
            
            public void write(final JsonWriter llllllllllllllIIIllIllIIlIllIlll, final Object llllllllllllllIIIllIllIIlIllIllI) throws IOException {
                if (llllllllllllllIIIllIllIIlIllIllI == null) {
                    llllllllllllllIIIllIllIIlIllIlll.nullValue();
                }
                else {
                    llllllllllllllIIIllIllIIlIllIlll.value(EnumTypeAdapterFactory.this.func_151232_a(llllllllllllllIIIllIllIIlIllIllI));
                }
            }
            
            public Object read(final JsonReader llllllllllllllIIIllIllIIlIllIIlI) throws IOException {
                if (llllllllllllllIIIllIllIIlIllIIlI.peek() == JsonToken.NULL) {
                    llllllllllllllIIIllIllIIlIllIIlI.nextNull();
                    return null;
                }
                return lllllllllllllllIllIIIllllIllIlII.get(llllllllllllllIIIllIllIIlIllIIlI.nextString());
            }
        };
    }
}
