package net.minecraft.client.renderer.block.model;

import javax.vecmath.*;
import java.lang.reflect.*;
import net.minecraft.util.*;
import com.google.gson.*;

public class ItemTransformVec3f
{
    public final /* synthetic */ Vector3f field_178365_c;
    public final /* synthetic */ Vector3f field_178364_b;
    public final /* synthetic */ Vector3f field_178363_d;
    
    public ItemTransformVec3f(final Vector3f llllllllllllllIlllIllIIlIIIlIIll, final Vector3f llllllllllllllIlllIllIIlIIIIlllI, final Vector3f llllllllllllllIlllIllIIlIIIIllIl) {
        this.field_178364_b = new Vector3f(llllllllllllllIlllIllIIlIIIlIIll);
        this.field_178365_c = new Vector3f(llllllllllllllIlllIllIIlIIIIlllI);
        this.field_178363_d = new Vector3f(llllllllllllllIlllIllIIlIIIIllIl);
    }
    
    static {
        __OBFID = "CL_00002484";
        field_178366_a = new ItemTransformVec3f(new Vector3f(), new Vector3f(), new Vector3f(1.0f, 1.0f, 1.0f));
    }
    
    static class Deserializer implements JsonDeserializer
    {
        private static final /* synthetic */ Vector3f field_178362_a;
        private static final /* synthetic */ Vector3f field_178360_b;
        private static final /* synthetic */ Vector3f field_178361_c;
        
        public Object deserialize(final JsonElement llllllllllllllIlIllIlIIlllIIIIIl, final Type llllllllllllllIlIllIlIIlllIIIIII, final JsonDeserializationContext llllllllllllllIlIllIlIIllIlllIll) {
            return this.func_178359_a(llllllllllllllIlIllIlIIlllIIIIIl, llllllllllllllIlIllIlIIlllIIIIII, llllllllllllllIlIllIlIIllIlllIll);
        }
        
        public ItemTransformVec3f func_178359_a(final JsonElement llllllllllllllIlIllIlIIlllIllllI, final Type llllllllllllllIlIllIlIIllllIIlIl, final JsonDeserializationContext llllllllllllllIlIllIlIIllllIIlII) {
            final JsonObject llllllllllllllIlIllIlIIllllIIIll = llllllllllllllIlIllIlIIlllIllllI.getAsJsonObject();
            final Vector3f llllllllllllllIlIllIlIIllllIIIlI = this.func_178358_a(llllllllllllllIlIllIlIIllllIIIll, "rotation", Deserializer.field_178362_a);
            final Vector3f llllllllllllllIlIllIlIIllllIIIIl = this.func_178358_a(llllllllllllllIlIllIlIIllllIIIll, "translation", Deserializer.field_178360_b);
            llllllllllllllIlIllIlIIllllIIIIl.scale(0.0625f);
            MathHelper.clamp_double(llllllllllllllIlIllIlIIllllIIIIl.x, -1.5, 1.5);
            MathHelper.clamp_double(llllllllllllllIlIllIlIIllllIIIIl.y, -1.5, 1.5);
            MathHelper.clamp_double(llllllllllllllIlIllIlIIllllIIIIl.z, -1.5, 1.5);
            final Vector3f llllllllllllllIlIllIlIIllllIIIII = this.func_178358_a(llllllllllllllIlIllIlIIllllIIIll, "scale", Deserializer.field_178361_c);
            MathHelper.clamp_double(llllllllllllllIlIllIlIIllllIIIII.x, -1.5, 1.5);
            MathHelper.clamp_double(llllllllllllllIlIllIlIIllllIIIII.y, -1.5, 1.5);
            MathHelper.clamp_double(llllllllllllllIlIllIlIIllllIIIII.z, -1.5, 1.5);
            return new ItemTransformVec3f(llllllllllllllIlIllIlIIllllIIIlI, llllllllllllllIlIllIlIIllllIIIIl, llllllllllllllIlIllIlIIllllIIIII);
        }
        
        private Vector3f func_178358_a(final JsonObject llllllllllllllIlIllIlIIlllIIllII, final String llllllllllllllIlIllIlIIlllIlIIIl, final Vector3f llllllllllllllIlIllIlIIlllIlIIII) {
            if (!llllllllllllllIlIllIlIIlllIIllII.has(llllllllllllllIlIllIlIIlllIlIIIl)) {
                return llllllllllllllIlIllIlIIlllIlIIII;
            }
            final JsonArray llllllllllllllIlIllIlIIlllIIllll = JsonUtils.getJsonObjectJsonArrayField(llllllllllllllIlIllIlIIlllIIllII, llllllllllllllIlIllIlIIlllIlIIIl);
            if (llllllllllllllIlIllIlIIlllIIllll.size() != 3) {
                throw new JsonParseException(String.valueOf(new StringBuilder("Expected 3 ").append(llllllllllllllIlIllIlIIlllIlIIIl).append(" values, found: ").append(llllllllllllllIlIllIlIIlllIIllll.size())));
            }
            final float[] llllllllllllllIlIllIlIIlllIIlllI = new float[3];
            for (int llllllllllllllIlIllIlIIlllIIllIl = 0; llllllllllllllIlIllIlIIlllIIllIl < llllllllllllllIlIllIlIIlllIIlllI.length; ++llllllllllllllIlIllIlIIlllIIllIl) {
                llllllllllllllIlIllIlIIlllIIlllI[llllllllllllllIlIllIlIIlllIIllIl] = JsonUtils.getJsonElementFloatValue(llllllllllllllIlIllIlIIlllIIllll.get(llllllllllllllIlIllIlIIlllIIllIl), String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlIllIlIIlllIlIIIl)).append("[").append(llllllllllllllIlIllIlIIlllIIllIl).append("]")));
            }
            return new Vector3f(llllllllllllllIlIllIlIIlllIIlllI);
        }
        
        static {
            __OBFID = "CL_00002483";
            field_178362_a = new Vector3f(0.0f, 0.0f, 0.0f);
            field_178360_b = new Vector3f(0.0f, 0.0f, 0.0f);
            field_178361_c = new Vector3f(1.0f, 1.0f, 1.0f);
        }
    }
}
