package net.minecraft.client.renderer.block.model;

import net.minecraft.util.*;
import java.lang.reflect.*;
import com.google.gson.*;

public class BlockFaceUV
{
    public /* synthetic */ float[] field_178351_a;
    public final /* synthetic */ int field_178350_b;
    
    public BlockFaceUV(final float[] lllllllllllllllIIlllIlIlIlIIIllI, final int lllllllllllllllIIlllIlIlIlIIIlIl) {
        this.field_178351_a = lllllllllllllllIIlllIlIlIlIIIllI;
        this.field_178350_b = lllllllllllllllIIlllIlIlIlIIIlIl;
    }
    
    private int func_178347_d(final int lllllllllllllllIIlllIlIlIIlIlIlI) {
        return (lllllllllllllllIIlllIlIlIIlIlIlI + this.field_178350_b / 90) % 4;
    }
    
    public float func_178346_b(final int lllllllllllllllIIlllIlIlIIllIIIl) {
        if (this.field_178351_a == null) {
            throw new NullPointerException("uvs");
        }
        final int lllllllllllllllIIlllIlIlIIllIIll = this.func_178347_d(lllllllllllllllIIlllIlIlIIllIIIl);
        return (lllllllllllllllIIlllIlIlIIllIIll != 0 && lllllllllllllllIIlllIlIlIIllIIll != 3) ? this.field_178351_a[3] : this.field_178351_a[1];
    }
    
    static {
        __OBFID = "CL_00002505";
    }
    
    public int func_178345_c(final int lllllllllllllllIIlllIlIlIIlIIllI) {
        return (lllllllllllllllIIlllIlIlIIlIIllI + (4 - this.field_178350_b / 90)) % 4;
    }
    
    public void func_178349_a(final float[] lllllllllllllllIIlllIlIlIIIllllI) {
        if (this.field_178351_a == null) {
            this.field_178351_a = lllllllllllllllIIlllIlIlIIIllllI;
        }
    }
    
    public float func_178348_a(final int lllllllllllllllIIlllIlIlIIlllIlI) {
        if (this.field_178351_a == null) {
            throw new NullPointerException("uvs");
        }
        final int lllllllllllllllIIlllIlIlIIllllII = this.func_178347_d(lllllllllllllllIIlllIlIlIIlllIlI);
        return (lllllllllllllllIIlllIlIlIIllllII != 0 && lllllllllllllllIIlllIlIlIIllllII != 1) ? this.field_178351_a[2] : this.field_178351_a[0];
    }
    
    static class Deserializer implements JsonDeserializer
    {
        private float[] func_178292_b(final JsonObject lllllllllllllllIIIIlIIIIllllIllI) {
            if (!lllllllllllllllIIIIlIIIIllllIllI.has("uv")) {
                return null;
            }
            final JsonArray lllllllllllllllIIIIlIIIIllllIlIl = JsonUtils.getJsonObjectJsonArrayField(lllllllllllllllIIIIlIIIIllllIllI, "uv");
            if (lllllllllllllllIIIIlIIIIllllIlIl.size() != 4) {
                throw new JsonParseException(String.valueOf(new StringBuilder("Expected 4 uv values, found: ").append(lllllllllllllllIIIIlIIIIllllIlIl.size())));
            }
            final float[] lllllllllllllllIIIIlIIIIllllIlII = new float[4];
            for (int lllllllllllllllIIIIlIIIIllllIIll = 0; lllllllllllllllIIIIlIIIIllllIIll < lllllllllllllllIIIIlIIIIllllIlII.length; ++lllllllllllllllIIIIlIIIIllllIIll) {
                lllllllllllllllIIIIlIIIIllllIlII[lllllllllllllllIIIIlIIIIllllIIll] = JsonUtils.getJsonElementFloatValue(lllllllllllllllIIIIlIIIIllllIlIl.get(lllllllllllllllIIIIlIIIIllllIIll), String.valueOf(new StringBuilder("uv[").append(lllllllllllllllIIIIlIIIIllllIIll).append("]")));
            }
            return lllllllllllllllIIIIlIIIIllllIlII;
        }
        
        protected int func_178291_a(final JsonObject lllllllllllllllIIIIlIIIIllllllll) {
            final int lllllllllllllllIIIIlIIIIlllllllI = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(lllllllllllllllIIIIlIIIIllllllll, "rotation", 0);
            if (lllllllllllllllIIIIlIIIIlllllllI >= 0 && lllllllllllllllIIIIlIIIIlllllllI % 90 == 0 && lllllllllllllllIIIIlIIIIlllllllI / 90 <= 3) {
                return lllllllllllllllIIIIlIIIIlllllllI;
            }
            throw new JsonParseException(String.valueOf(new StringBuilder("Invalid rotation ").append(lllllllllllllllIIIIlIIIIlllllllI).append(" found, only 0/90/180/270 allowed")));
        }
        
        public Object deserialize(final JsonElement lllllllllllllllIIIIlIIIIlllIIlIl, final Type lllllllllllllllIIIIlIIIIlllIlIII, final JsonDeserializationContext lllllllllllllllIIIIlIIIIlllIIIll) {
            return this.func_178293_a(lllllllllllllllIIIIlIIIIlllIIlIl, lllllllllllllllIIIIlIIIIlllIlIII, lllllllllllllllIIIIlIIIIlllIIIll);
        }
        
        static {
            __OBFID = "CL_00002504";
        }
        
        public BlockFaceUV func_178293_a(final JsonElement lllllllllllllllIIIIlIIIlIIIIllIl, final Type lllllllllllllllIIIIlIIIlIIIIllII, final JsonDeserializationContext lllllllllllllllIIIIlIIIlIIIIlIll) {
            final JsonObject lllllllllllllllIIIIlIIIlIIIIlIlI = lllllllllllllllIIIIlIIIlIIIIllIl.getAsJsonObject();
            final float[] lllllllllllllllIIIIlIIIlIIIIlIIl = this.func_178292_b(lllllllllllllllIIIIlIIIlIIIIlIlI);
            final int lllllllllllllllIIIIlIIIlIIIIlIII = this.func_178291_a(lllllllllllllllIIIIlIIIlIIIIlIlI);
            return new BlockFaceUV(lllllllllllllllIIIIlIIIlIIIIlIIl, lllllllllllllllIIIIlIIIlIIIIlIII);
        }
    }
}
