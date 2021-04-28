package net.minecraft.client.renderer.block.model;

import java.lang.reflect.*;
import com.google.gson.*;

public class ItemCameraTransforms
{
    public final /* synthetic */ ItemTransformVec3f field_178354_e;
    public final /* synthetic */ ItemTransformVec3f field_178356_c;
    public final /* synthetic */ ItemTransformVec3f field_178353_d;
    public final /* synthetic */ ItemTransformVec3f field_178355_b;
    
    static {
        __OBFID = "CL_00002482";
        field_178357_a = new ItemCameraTransforms(ItemTransformVec3f.field_178366_a, ItemTransformVec3f.field_178366_a, ItemTransformVec3f.field_178366_a, ItemTransformVec3f.field_178366_a);
    }
    
    public ItemCameraTransforms(final ItemTransformVec3f lllllllllllllllIIllllIIlIIIlIlII, final ItemTransformVec3f lllllllllllllllIIllllIIlIIIlIIll, final ItemTransformVec3f lllllllllllllllIIllllIIlIIIIllIl, final ItemTransformVec3f lllllllllllllllIIllllIIlIIIlIIIl) {
        this.field_178355_b = lllllllllllllllIIllllIIlIIIlIlII;
        this.field_178356_c = lllllllllllllllIIllllIIlIIIlIIll;
        this.field_178353_d = lllllllllllllllIIllllIIlIIIIllIl;
        this.field_178354_e = lllllllllllllllIIllllIIlIIIlIIIl;
    }
    
    public enum TransformType
    {
        THIRD_PERSON("THIRD_PERSON", 1, "THIRD_PERSON", 1), 
        GUI("GUI", 4, "GUI", 4), 
        HEAD("HEAD", 3, "HEAD", 3), 
        NONE("NONE", 0, "NONE", 0), 
        FIRST_PERSON("FIRST_PERSON", 2, "FIRST_PERSON", 2);
        
        private TransformType(final String llllllllllllllIlIllIlIIIIllIlIIl, final int llllllllllllllIlIllIlIIIIllIlIII, final String llllllllllllllIlIllIlIIIIllIllII, final int llllllllllllllIlIllIlIIIIllIlIll) {
        }
        
        static {
            __OBFID = "CL_00002480";
        }
    }
    
    static class Deserializer implements JsonDeserializer
    {
        public Object deserialize(final JsonElement llllllllllllllllIllllIIIllIlIlll, final Type llllllllllllllllIllllIIIllIllIlI, final JsonDeserializationContext llllllllllllllllIllllIIIllIllIIl) {
            return this.func_178352_a(llllllllllllllllIllllIIIllIlIlll, llllllllllllllllIllllIIIllIllIlI, llllllllllllllllIllllIIIllIllIIl);
        }
        
        public ItemCameraTransforms func_178352_a(final JsonElement llllllllllllllllIllllIIIlllIllll, final Type llllllllllllllllIllllIIIlllIlllI, final JsonDeserializationContext llllllllllllllllIllllIIIlllIllIl) {
            final JsonObject llllllllllllllllIllllIIIlllIllII = llllllllllllllllIllllIIIlllIllll.getAsJsonObject();
            ItemTransformVec3f llllllllllllllllIllllIIIlllIlIll = ItemTransformVec3f.field_178366_a;
            ItemTransformVec3f llllllllllllllllIllllIIIlllIlIlI = ItemTransformVec3f.field_178366_a;
            ItemTransformVec3f llllllllllllllllIllllIIIlllIlIIl = ItemTransformVec3f.field_178366_a;
            ItemTransformVec3f llllllllllllllllIllllIIIlllIlIII = ItemTransformVec3f.field_178366_a;
            if (llllllllllllllllIllllIIIlllIllII.has("thirdperson")) {
                llllllllllllllllIllllIIIlllIlIll = (ItemTransformVec3f)llllllllllllllllIllllIIIlllIllIl.deserialize(llllllllllllllllIllllIIIlllIllII.get("thirdperson"), (Type)ItemTransformVec3f.class);
            }
            if (llllllllllllllllIllllIIIlllIllII.has("firstperson")) {
                llllllllllllllllIllllIIIlllIlIlI = (ItemTransformVec3f)llllllllllllllllIllllIIIlllIllIl.deserialize(llllllllllllllllIllllIIIlllIllII.get("firstperson"), (Type)ItemTransformVec3f.class);
            }
            if (llllllllllllllllIllllIIIlllIllII.has("head")) {
                llllllllllllllllIllllIIIlllIlIIl = (ItemTransformVec3f)llllllllllllllllIllllIIIlllIllIl.deserialize(llllllllllllllllIllllIIIlllIllII.get("head"), (Type)ItemTransformVec3f.class);
            }
            if (llllllllllllllllIllllIIIlllIllII.has("gui")) {
                llllllllllllllllIllllIIIlllIlIII = (ItemTransformVec3f)llllllllllllllllIllllIIIlllIllIl.deserialize(llllllllllllllllIllllIIIlllIllII.get("gui"), (Type)ItemTransformVec3f.class);
            }
            return new ItemCameraTransforms(llllllllllllllllIllllIIIlllIlIll, llllllllllllllllIllllIIIlllIlIlI, llllllllllllllllIllllIIIlllIlIIl, llllllllllllllllIllllIIIlllIlIII);
        }
        
        static {
            __OBFID = "CL_00002481";
        }
    }
}
