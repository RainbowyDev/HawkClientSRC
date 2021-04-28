package net.minecraft.client.renderer.block.model;

import java.io.*;
import java.lang.reflect.*;
import net.minecraft.client.resources.model.*;
import net.minecraft.util.*;
import com.google.gson.*;
import com.google.common.collect.*;
import java.util.*;

public class ModelBlockDefinition
{
    static final /* synthetic */ Gson field_178333_a;
    private final /* synthetic */ Map field_178332_b;
    
    public ModelBlockDefinition(final List lllllllllllllllIIllllIIlIlIlllII) {
        this.field_178332_b = Maps.newHashMap();
        for (final ModelBlockDefinition lllllllllllllllIIllllIIlIlIllIlI : lllllllllllllllIIllllIIlIlIlllII) {
            this.field_178332_b.putAll(lllllllllllllllIIllllIIlIlIllIlI.field_178332_b);
        }
    }
    
    @Override
    public boolean equals(final Object lllllllllllllllIIllllIIlIlIIlIII) {
        if (this == lllllllllllllllIIllllIIlIlIIlIII) {
            return true;
        }
        if (lllllllllllllllIIllllIIlIlIIlIII instanceof ModelBlockDefinition) {
            final ModelBlockDefinition lllllllllllllllIIllllIIlIlIIIlll = (ModelBlockDefinition)lllllllllllllllIIllllIIlIlIIlIII;
            return this.field_178332_b.equals(lllllllllllllllIIllllIIlIlIIIlll.field_178332_b);
        }
        return false;
    }
    
    public static ModelBlockDefinition func_178331_a(final Reader lllllllllllllllIIllllIIlIllIllll) {
        return (ModelBlockDefinition)ModelBlockDefinition.field_178333_a.fromJson(lllllllllllllllIIllllIIlIllIllll, (Class)ModelBlockDefinition.class);
    }
    
    static {
        __OBFID = "CL_00002498";
        field_178333_a = new GsonBuilder().registerTypeAdapter((Type)ModelBlockDefinition.class, (Object)new Deserializer()).registerTypeAdapter((Type)Variant.class, (Object)new Variant.Deserializer()).create();
    }
    
    @Override
    public int hashCode() {
        return this.field_178332_b.hashCode();
    }
    
    public Variants func_178330_b(final String lllllllllllllllIIllllIIlIlIlIIIl) {
        final Variants lllllllllllllllIIllllIIlIlIlIIII = this.field_178332_b.get(lllllllllllllllIIllllIIlIlIlIIIl);
        if (lllllllllllllllIIllllIIlIlIlIIII == null) {
            throw new MissingVariantException();
        }
        return lllllllllllllllIIllllIIlIlIlIIII;
    }
    
    public ModelBlockDefinition(final Collection lllllllllllllllIIllllIIlIllIlIII) {
        this.field_178332_b = Maps.newHashMap();
        for (final Variants lllllllllllllllIIllllIIlIllIIllI : lllllllllllllllIIllllIIlIllIlIII) {
            this.field_178332_b.put(lllllllllllllllIIllllIIlIllIIllI.field_178423_a, lllllllllllllllIIllllIIlIllIIllI);
        }
    }
    
    public static class Variant
    {
        private final /* synthetic */ boolean field_178436_c;
        private final /* synthetic */ int field_178434_d;
        private final /* synthetic */ ModelRotation field_178435_b;
        private final /* synthetic */ ResourceLocation field_178437_a;
        
        public int getWeight() {
            return this.field_178434_d;
        }
        
        @Override
        public int hashCode() {
            int llllllllllllllllIIIlIlIIllIlllll = this.field_178437_a.hashCode();
            llllllllllllllllIIIlIlIIllIlllll = 31 * llllllllllllllllIIIlIlIIllIlllll + ((this.field_178435_b != null) ? this.field_178435_b.hashCode() : 0);
            llllllllllllllllIIIlIlIIllIlllll = 31 * llllllllllllllllIIIlIlIIllIlllll + (this.field_178436_c ? 1 : 0);
            return llllllllllllllllIIIlIlIIllIlllll;
        }
        
        public Variant(final ResourceLocation llllllllllllllllIIIlIlIIlllllIll, final ModelRotation llllllllllllllllIIIlIlIIllllllll, final boolean llllllllllllllllIIIlIlIIlllllIIl, final int llllllllllllllllIIIlIlIIllllllIl) {
            this.field_178437_a = llllllllllllllllIIIlIlIIlllllIll;
            this.field_178435_b = llllllllllllllllIIIlIlIIllllllll;
            this.field_178436_c = llllllllllllllllIIIlIlIIlllllIIl;
            this.field_178434_d = llllllllllllllllIIIlIlIIllllllIl;
        }
        
        public ModelRotation getRotation() {
            return this.field_178435_b;
        }
        
        public boolean isUvLocked() {
            return this.field_178436_c;
        }
        
        @Override
        public boolean equals(final Object llllllllllllllllIIIlIlIIlllIIlII) {
            if (this == llllllllllllllllIIIlIlIIlllIIlII) {
                return true;
            }
            if (!(llllllllllllllllIIIlIlIIlllIIlII instanceof Variant)) {
                return false;
            }
            final Variant llllllllllllllllIIIlIlIIlllIIllI = (Variant)llllllllllllllllIIIlIlIIlllIIlII;
            return this.field_178437_a.equals(llllllllllllllllIIIlIlIIlllIIllI.field_178437_a) && this.field_178435_b == llllllllllllllllIIIlIlIIlllIIllI.field_178435_b && this.field_178436_c == llllllllllllllllIIIlIlIIlllIIllI.field_178436_c;
        }
        
        public ResourceLocation getModelLocation() {
            return this.field_178437_a;
        }
        
        static {
            __OBFID = "CL_00002495";
        }
        
        public static class Deserializer implements JsonDeserializer
        {
            private ResourceLocation func_178426_a(final String llllllllllllllIIIllIllIIIIllIIIl) {
                ResourceLocation llllllllllllllIIIllIllIIIIllIIII = new ResourceLocation(llllllllllllllIIIllIllIIIIllIIIl);
                llllllllllllllIIIllIllIIIIllIIII = new ResourceLocation(llllllllllllllIIIllIllIIIIllIIII.getResourceDomain(), String.valueOf(new StringBuilder("block/").append(llllllllllllllIIIllIllIIIIllIIII.getResourcePath())));
                return llllllllllllllIIIllIllIIIIllIIII;
            }
            
            protected ModelRotation func_178428_a(final JsonObject llllllllllllllIIIllIllIIIIlIIIII) {
                final int llllllllllllllIIIllIllIIIIlIIIll = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllIIIllIllIIIIlIIIII, "x", 0);
                final int llllllllllllllIIIllIllIIIIlIIIlI = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllIIIllIllIIIIlIIIII, "y", 0);
                final ModelRotation llllllllllllllIIIllIllIIIIlIIIIl = ModelRotation.func_177524_a(llllllllllllllIIIllIllIIIIlIIIll, llllllllllllllIIIllIllIIIIlIIIlI);
                if (llllllllllllllIIIllIllIIIIlIIIIl == null) {
                    throw new JsonParseException(String.valueOf(new StringBuilder("Invalid BlockModelRotation x: ").append(llllllllllllllIIIllIllIIIIlIIIll).append(", y: ").append(llllllllllllllIIIllIllIIIIlIIIlI)));
                }
                return llllllllllllllIIIllIllIIIIlIIIIl;
            }
            
            public Object deserialize(final JsonElement llllllllllllllIIIllIllIIIIIIllll, final Type llllllllllllllIIIllIllIIIIIIlIlI, final JsonDeserializationContext llllllllllllllIIIllIllIIIIIIllIl) {
                return this.func_178425_a(llllllllllllllIIIllIllIIIIIIllll, llllllllllllllIIIllIllIIIIIIlIlI, llllllllllllllIIIllIllIIIIIIllIl);
            }
            
            protected String func_178424_b(final JsonObject llllllllllllllIIIllIllIIIIIllIIl) {
                return JsonUtils.getJsonObjectStringFieldValue(llllllllllllllIIIllIllIIIIIllIIl, "model");
            }
            
            private boolean func_178429_d(final JsonObject llllllllllllllIIIllIllIIIIlIlIll) {
                return JsonUtils.getJsonObjectBooleanFieldValueOrDefault(llllllllllllllIIIllIllIIIIlIlIll, "uvlock", false);
            }
            
            static {
                __OBFID = "CL_00002494";
            }
            
            public Variant func_178425_a(final JsonElement llllllllllllllIIIllIllIIIlIIIIll, final Type llllllllllllllIIIllIllIIIlIIIIlI, final JsonDeserializationContext llllllllllllllIIIllIllIIIlIIIIIl) {
                final JsonObject llllllllllllllIIIllIllIIIlIIIIII = llllllllllllllIIIllIllIIIlIIIIll.getAsJsonObject();
                final String llllllllllllllIIIllIllIIIIllllll = this.func_178424_b(llllllllllllllIIIllIllIIIlIIIIII);
                final ModelRotation llllllllllllllIIIllIllIIIIlllllI = this.func_178428_a(llllllllllllllIIIllIllIIIlIIIIII);
                final boolean llllllllllllllIIIllIllIIIIllllIl = this.func_178429_d(llllllllllllllIIIllIllIIIlIIIIII);
                final int llllllllllllllIIIllIllIIIIllllII = this.func_178427_c(llllllllllllllIIIllIllIIIlIIIIII);
                return new Variant(this.func_178426_a(llllllllllllllIIIllIllIIIIllllll), llllllllllllllIIIllIllIIIIlllllI, llllllllllllllIIIllIllIIIIllllIl, llllllllllllllIIIllIllIIIIllllII);
            }
            
            protected int func_178427_c(final JsonObject llllllllllllllIIIllIllIIIIIlIllI) {
                return JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllIIIllIllIIIIIlIllI, "weight", 1);
            }
        }
    }
    
    public static class Deserializer implements JsonDeserializer
    {
        public ModelBlockDefinition func_178336_a(final JsonElement llllllllllllllllllllIIlIllIlIlll, final Type llllllllllllllllllllIIlIllIlIllI, final JsonDeserializationContext llllllllllllllllllllIIlIllIlIIII) {
            final JsonObject llllllllllllllllllllIIlIllIlIlII = llllllllllllllllllllIIlIllIlIlll.getAsJsonObject();
            final List llllllllllllllllllllIIlIllIlIIll = this.func_178334_a(llllllllllllllllllllIIlIllIlIIII, llllllllllllllllllllIIlIllIlIlII);
            return new ModelBlockDefinition((Collection)llllllllllllllllllllIIlIllIlIIll);
        }
        
        protected Variants func_178335_a(final JsonDeserializationContext llllllllllllllllllllIIlIlIlIlIIl, final Map.Entry llllllllllllllllllllIIlIlIlIllll) {
            final String llllllllllllllllllllIIlIlIlIlllI = llllllllllllllllllllIIlIlIlIllll.getKey();
            final ArrayList llllllllllllllllllllIIlIlIlIllIl = Lists.newArrayList();
            final JsonElement llllllllllllllllllllIIlIlIlIllII = (JsonElement)llllllllllllllllllllIIlIlIlIllll.getValue();
            if (llllllllllllllllllllIIlIlIlIllII.isJsonArray()) {
                for (final JsonElement llllllllllllllllllllIIlIlIlIlIlI : llllllllllllllllllllIIlIlIlIllII.getAsJsonArray()) {
                    llllllllllllllllllllIIlIlIlIllIl.add(llllllllllllllllllllIIlIlIlIlIIl.deserialize(llllllllllllllllllllIIlIlIlIlIlI, (Type)Variant.class));
                }
            }
            else {
                llllllllllllllllllllIIlIlIlIllIl.add(llllllllllllllllllllIIlIlIlIlIIl.deserialize(llllllllllllllllllllIIlIlIlIllII, (Type)Variant.class));
            }
            return new Variants(llllllllllllllllllllIIlIlIlIlllI, llllllllllllllllllllIIlIlIlIllIl);
        }
        
        protected List func_178334_a(final JsonDeserializationContext llllllllllllllllllllIIlIllIIIlIl, final JsonObject llllllllllllllllllllIIlIllIIIlII) {
            final JsonObject llllllllllllllllllllIIlIllIIIIll = JsonUtils.getJsonObject(llllllllllllllllllllIIlIllIIIlII, "variants");
            final ArrayList llllllllllllllllllllIIlIllIIIIlI = Lists.newArrayList();
            for (final Map.Entry llllllllllllllllllllIIlIllIIIIII : llllllllllllllllllllIIlIllIIIIll.entrySet()) {
                llllllllllllllllllllIIlIllIIIIlI.add(this.func_178335_a(llllllllllllllllllllIIlIllIIIlIl, llllllllllllllllllllIIlIllIIIIII));
            }
            return llllllllllllllllllllIIlIllIIIIlI;
        }
        
        static {
            __OBFID = "CL_00002497";
        }
        
        public Object deserialize(final JsonElement llllllllllllllllllllIIlIlIIllIIl, final Type llllllllllllllllllllIIlIlIIlllII, final JsonDeserializationContext llllllllllllllllllllIIlIlIIlIlll) {
            return this.func_178336_a(llllllllllllllllllllIIlIlIIllIIl, llllllllllllllllllllIIlIlIIlllII, llllllllllllllllllllIIlIlIIlIlll);
        }
    }
    
    public static class Variants
    {
        private final /* synthetic */ String field_178423_a;
        private final /* synthetic */ List field_178422_b;
        
        static {
            __OBFID = "CL_00002493";
        }
        
        @Override
        public int hashCode() {
            int llllllllllllllIIIllIlIlIIIlllIlI = this.field_178423_a.hashCode();
            llllllllllllllIIIllIlIlIIIlllIlI = 31 * llllllllllllllIIIllIlIlIIIlllIlI + this.field_178422_b.hashCode();
            return llllllllllllllIIIllIlIlIIIlllIlI;
        }
        
        public Variants(final String llllllllllllllIIIllIlIlIIlIIlIll, final List llllllllllllllIIIllIlIlIIlIIlIlI) {
            this.field_178423_a = llllllllllllllIIIllIlIlIIlIIlIll;
            this.field_178422_b = llllllllllllllIIIllIlIlIIlIIlIlI;
        }
        
        @Override
        public boolean equals(final Object llllllllllllllIIIllIlIlIIlIIIIlI) {
            if (this == llllllllllllllIIIllIlIlIIlIIIIlI) {
                return true;
            }
            if (!(llllllllllllllIIIllIlIlIIlIIIIlI instanceof Variants)) {
                return false;
            }
            final Variants llllllllllllllIIIllIlIlIIlIIIIIl = (Variants)llllllllllllllIIIllIlIlIIlIIIIlI;
            return this.field_178423_a.equals(llllllllllllllIIIllIlIlIIlIIIIIl.field_178423_a) && this.field_178422_b.equals(llllllllllllllIIIllIlIlIIlIIIIIl.field_178422_b);
        }
        
        public List getVariants() {
            return this.field_178422_b;
        }
    }
    
    public class MissingVariantException extends RuntimeException
    {
        static {
            __OBFID = "CL_00002496";
        }
    }
}
