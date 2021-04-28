package net.minecraft.client.renderer.block.model;

import javax.vecmath.*;
import java.lang.reflect.*;
import com.google.gson.*;
import net.minecraft.util.*;
import com.google.common.collect.*;
import java.util.*;

public class BlockPart
{
    public final /* synthetic */ BlockPartRotation field_178237_d;
    public final /* synthetic */ Map field_178240_c;
    public final /* synthetic */ Vector3f field_178239_b;
    public final /* synthetic */ boolean field_178238_e;
    public final /* synthetic */ Vector3f field_178241_a;
    
    private float[] func_178236_a(final EnumFacing llllllllllllllIIIllIllllIlllIllI) {
        switch (SwitchEnumFacing.field_178234_a[llllllllllllllIIIllIllllIlllIllI.ordinal()]) {
            case 1:
            case 2: {
                final float[] llllllllllllllIIIllIllllIllllIll = { this.field_178241_a.x, this.field_178241_a.z, this.field_178239_b.x, this.field_178239_b.z };
                break;
            }
            case 3:
            case 4: {
                final float[] llllllllllllllIIIllIllllIllllIlI = { this.field_178241_a.x, 16.0f - this.field_178239_b.y, this.field_178239_b.x, 16.0f - this.field_178241_a.y };
                break;
            }
            case 5:
            case 6: {
                final float[] llllllllllllllIIIllIllllIllllIIl = { this.field_178241_a.z, 16.0f - this.field_178239_b.y, this.field_178239_b.z, 16.0f - this.field_178241_a.y };
                break;
            }
            default: {
                throw new NullPointerException();
            }
        }
        final float[] llllllllllllllIIIllIllllIllllIII;
        return llllllllllllllIIIllIllllIllllIII;
    }
    
    public BlockPart(final Vector3f llllllllllllllIIIllIlllllIIlIIIl, final Vector3f llllllllllllllIIIllIlllllIIlIIII, final Map llllllllllllllIIIllIlllllIIlIlIl, final BlockPartRotation llllllllllllllIIIllIlllllIIIlllI, final boolean llllllllllllllIIIllIlllllIIlIIll) {
        this.field_178241_a = llllllllllllllIIIllIlllllIIlIIIl;
        this.field_178239_b = llllllllllllllIIIllIlllllIIlIIII;
        this.field_178240_c = llllllllllllllIIIllIlllllIIlIlIl;
        this.field_178237_d = llllllllllllllIIIllIlllllIIIlllI;
        this.field_178238_e = llllllllllllllIIIllIlllllIIlIIll;
        this.func_178235_a();
    }
    
    private void func_178235_a() {
        for (final Map.Entry llllllllllllllIIIllIlllllIIIIllI : this.field_178240_c.entrySet()) {
            final float[] llllllllllllllIIIllIlllllIIIIlIl = this.func_178236_a(llllllllllllllIIIllIlllllIIIIllI.getKey());
            llllllllllllllIIIllIlllllIIIIllI.getValue().field_178243_e.func_178349_a(llllllllllllllIIIllIlllllIIIIlIl);
        }
    }
    
    static {
        __OBFID = "CL_00002511";
    }
    
    static final class SwitchEnumFacing
    {
        static final /* synthetic */ int[] field_178234_a;
        
        static {
            __OBFID = "CL_00002510";
            field_178234_a = new int[EnumFacing.values().length];
            try {
                SwitchEnumFacing.field_178234_a[EnumFacing.DOWN.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumFacing.field_178234_a[EnumFacing.UP.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumFacing.field_178234_a[EnumFacing.NORTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchEnumFacing.field_178234_a[EnumFacing.SOUTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                SwitchEnumFacing.field_178234_a[EnumFacing.WEST.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                SwitchEnumFacing.field_178234_a[EnumFacing.EAST.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
        }
    }
    
    static class Deserializer implements JsonDeserializer
    {
        static {
            __OBFID = "CL_00002509";
        }
        
        private EnumFacing func_178248_a(final String lllllllllllllllIIlllIlIIIIIlIlIl) {
            final EnumFacing lllllllllllllllIIlllIlIIIIIlIllI = EnumFacing.byName(lllllllllllllllIIlllIlIIIIIlIlIl);
            if (lllllllllllllllIIlllIlIIIIIlIllI == null) {
                throw new JsonParseException(String.valueOf(new StringBuilder("Unknown facing: ").append(lllllllllllllllIIlllIlIIIIIlIlIl)));
            }
            return lllllllllllllllIIlllIlIIIIIlIllI;
        }
        
        public BlockPart func_178254_a(final JsonElement lllllllllllllllIIlllIlIIIllllIIl, final Type lllllllllllllllIIlllIlIIIllllIII, final JsonDeserializationContext lllllllllllllllIIlllIlIIIlllIlll) {
            final JsonObject lllllllllllllllIIlllIlIIIlllIllI = lllllllllllllllIIlllIlIIIllllIIl.getAsJsonObject();
            final Vector3f lllllllllllllllIIlllIlIIIlllIlIl = this.func_178249_e(lllllllllllllllIIlllIlIIIlllIllI);
            final Vector3f lllllllllllllllIIlllIlIIIlllIlII = this.func_178247_d(lllllllllllllllIIlllIlIIIlllIllI);
            final BlockPartRotation lllllllllllllllIIlllIlIIIlllIIll = this.func_178256_a(lllllllllllllllIIlllIlIIIlllIllI);
            final Map lllllllllllllllIIlllIlIIIlllIIlI = this.func_178250_a(lllllllllllllllIIlllIlIIIlllIlll, lllllllllllllllIIlllIlIIIlllIllI);
            if (lllllllllllllllIIlllIlIIIlllIllI.has("shade") && !JsonUtils.func_180199_c(lllllllllllllllIIlllIlIIIlllIllI, "shade")) {
                throw new JsonParseException("Expected shade to be a Boolean");
            }
            final boolean lllllllllllllllIIlllIlIIIlllIIIl = JsonUtils.getJsonObjectBooleanFieldValueOrDefault(lllllllllllllllIIlllIlIIIlllIllI, "shade", true);
            return new BlockPart(lllllllllllllllIIlllIlIIIlllIlIl, lllllllllllllllIIlllIlIIIlllIlII, lllllllllllllllIIlllIlIIIlllIIlI, lllllllllllllllIIlllIlIIIlllIIll, lllllllllllllllIIlllIlIIIlllIIIl);
        }
        
        private BlockPartRotation func_178256_a(final JsonObject lllllllllllllllIIlllIlIIIlIllllI) {
            BlockPartRotation lllllllllllllllIIlllIlIIIlIlllIl = null;
            if (lllllllllllllllIIlllIlIIIlIllllI.has("rotation")) {
                final JsonObject lllllllllllllllIIlllIlIIIlIlllII = JsonUtils.getJsonObject(lllllllllllllllIIlllIlIIIlIllllI, "rotation");
                final Vector3f lllllllllllllllIIlllIlIIIlIllIll = this.func_178251_a(lllllllllllllllIIlllIlIIIlIlllII, "origin");
                lllllllllllllllIIlllIlIIIlIllIll.scale(0.0625f);
                final EnumFacing.Axis lllllllllllllllIIlllIlIIIlIllIlI = this.func_178252_c(lllllllllllllllIIlllIlIIIlIlllII);
                final float lllllllllllllllIIlllIlIIIlIllIIl = this.func_178255_b(lllllllllllllllIIlllIlIIIlIlllII);
                final boolean lllllllllllllllIIlllIlIIIlIllIII = JsonUtils.getJsonObjectBooleanFieldValueOrDefault(lllllllllllllllIIlllIlIIIlIlllII, "rescale", false);
                lllllllllllllllIIlllIlIIIlIlllIl = new BlockPartRotation(lllllllllllllllIIlllIlIIIlIllIll, lllllllllllllllIIlllIlIIIlIllIlI, lllllllllllllllIIlllIlIIIlIllIIl, lllllllllllllllIIlllIlIIIlIllIII);
            }
            return lllllllllllllllIIlllIlIIIlIlllIl;
        }
        
        private Vector3f func_178251_a(final JsonObject lllllllllllllllIIlllIIlllllllIll, final String lllllllllllllllIIlllIIlllllllIlI) {
            final JsonArray lllllllllllllllIIlllIIlllllllIIl = JsonUtils.getJsonObjectJsonArrayField(lllllllllllllllIIlllIIlllllllIll, lllllllllllllllIIlllIIlllllllIlI);
            if (lllllllllllllllIIlllIIlllllllIIl.size() != 3) {
                throw new JsonParseException(String.valueOf(new StringBuilder("Expected 3 ").append(lllllllllllllllIIlllIIlllllllIlI).append(" values, found: ").append(lllllllllllllllIIlllIIlllllllIIl.size())));
            }
            final float[] lllllllllllllllIIlllIIlllllllIII = new float[3];
            for (int lllllllllllllllIIlllIIllllllIlll = 0; lllllllllllllllIIlllIIllllllIlll < lllllllllllllllIIlllIIlllllllIII.length; ++lllllllllllllllIIlllIIllllllIlll) {
                lllllllllllllllIIlllIIlllllllIII[lllllllllllllllIIlllIIllllllIlll] = JsonUtils.getJsonElementFloatValue(lllllllllllllllIIlllIIlllllllIIl.get(lllllllllllllllIIlllIIllllllIlll), String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIlllIIlllllllIlI)).append("[").append(lllllllllllllllIIlllIIllllllIlll).append("]")));
            }
            return new Vector3f(lllllllllllllllIIlllIIlllllllIII);
        }
        
        private Vector3f func_178249_e(final JsonObject lllllllllllllllIIlllIlIIIIIIIIll) {
            final Vector3f lllllllllllllllIIlllIlIIIIIIIlIl = this.func_178251_a(lllllllllllllllIIlllIlIIIIIIIIll, "from");
            if (lllllllllllllllIIlllIlIIIIIIIlIl.x >= -16.0f && lllllllllllllllIIlllIlIIIIIIIlIl.y >= -16.0f && lllllllllllllllIIlllIlIIIIIIIlIl.z >= -16.0f && lllllllllllllllIIlllIlIIIIIIIlIl.x <= 32.0f && lllllllllllllllIIlllIlIIIIIIIlIl.y <= 32.0f && lllllllllllllllIIlllIlIIIIIIIlIl.z <= 32.0f) {
                return lllllllllllllllIIlllIlIIIIIIIlIl;
            }
            throw new JsonParseException(String.valueOf(new StringBuilder("'from' specifier exceeds the allowed boundaries: ").append(lllllllllllllllIIlllIlIIIIIIIlIl)));
        }
        
        private EnumFacing.Axis func_178252_c(final JsonObject lllllllllllllllIIlllIlIIIlIIIlII) {
            final String lllllllllllllllIIlllIlIIIlIIIIll = JsonUtils.getJsonObjectStringFieldValue(lllllllllllllllIIlllIlIIIlIIIlII, "axis");
            final EnumFacing.Axis lllllllllllllllIIlllIlIIIlIIIIlI = EnumFacing.Axis.byName(lllllllllllllllIIlllIlIIIlIIIIll.toLowerCase());
            if (lllllllllllllllIIlllIlIIIlIIIIlI == null) {
                throw new JsonParseException(String.valueOf(new StringBuilder("Invalid rotation axis: ").append(lllllllllllllllIIlllIlIIIlIIIIll)));
            }
            return lllllllllllllllIIlllIlIIIlIIIIlI;
        }
        
        private float func_178255_b(final JsonObject lllllllllllllllIIlllIlIIIlIIlIlI) {
            final float lllllllllllllllIIlllIlIIIlIIlIll = JsonUtils.getJsonObjectFloatFieldValue(lllllllllllllllIIlllIlIIIlIIlIlI, "angle");
            if (lllllllllllllllIIlllIlIIIlIIlIll != 0.0f && MathHelper.abs(lllllllllllllllIIlllIlIIIlIIlIll) != 22.5f && MathHelper.abs(lllllllllllllllIIlllIlIIIlIIlIll) != 45.0f) {
                throw new JsonParseException(String.valueOf(new StringBuilder("Invalid rotation ").append(lllllllllllllllIIlllIlIIIlIIlIll).append(" found, only -45/-22.5/0/22.5/45 allowed")));
            }
            return lllllllllllllllIIlllIlIIIlIIlIll;
        }
        
        private Map func_178250_a(final JsonDeserializationContext lllllllllllllllIIlllIlIIIIlllIIl, final JsonObject lllllllllllllllIIlllIlIIIIllIlII) {
            final Map lllllllllllllllIIlllIlIIIIllIlll = this.func_178253_b(lllllllllllllllIIlllIlIIIIlllIIl, lllllllllllllllIIlllIlIIIIllIlII);
            if (lllllllllllllllIIlllIlIIIIllIlll.isEmpty()) {
                throw new JsonParseException("Expected between 1 and 6 unique faces, got 0");
            }
            return lllllllllllllllIIlllIlIIIIllIlll;
        }
        
        private Vector3f func_178247_d(final JsonObject lllllllllllllllIIlllIlIIIIIIllII) {
            final Vector3f lllllllllllllllIIlllIlIIIIIIlllI = this.func_178251_a(lllllllllllllllIIlllIlIIIIIIllII, "to");
            if (lllllllllllllllIIlllIlIIIIIIlllI.x >= -16.0f && lllllllllllllllIIlllIlIIIIIIlllI.y >= -16.0f && lllllllllllllllIIlllIlIIIIIIlllI.z >= -16.0f && lllllllllllllllIIlllIlIIIIIIlllI.x <= 32.0f && lllllllllllllllIIlllIlIIIIIIlllI.y <= 32.0f && lllllllllllllllIIlllIlIIIIIIlllI.z <= 32.0f) {
                return lllllllllllllllIIlllIlIIIIIIlllI;
            }
            throw new JsonParseException(String.valueOf(new StringBuilder("'to' specifier exceeds the allowed boundaries: ").append(lllllllllllllllIIlllIlIIIIIIlllI)));
        }
        
        private Map func_178253_b(final JsonDeserializationContext lllllllllllllllIIlllIlIIIIlIIIIl, final JsonObject lllllllllllllllIIlllIlIIIIlIIIII) {
            final EnumMap lllllllllllllllIIlllIlIIIIlIIlll = Maps.newEnumMap((Class)EnumFacing.class);
            final JsonObject lllllllllllllllIIlllIlIIIIlIIllI = JsonUtils.getJsonObject(lllllllllllllllIIlllIlIIIIlIIIII, "faces");
            for (final Map.Entry lllllllllllllllIIlllIlIIIIlIIlII : lllllllllllllllIIlllIlIIIIlIIllI.entrySet()) {
                final EnumFacing lllllllllllllllIIlllIlIIIIlIIIll = this.func_178248_a(lllllllllllllllIIlllIlIIIIlIIlII.getKey());
                lllllllllllllllIIlllIlIIIIlIIlll.put(lllllllllllllllIIlllIlIIIIlIIIll, lllllllllllllllIIlllIlIIIIlIIIIl.deserialize((JsonElement)lllllllllllllllIIlllIlIIIIlIIlII.getValue(), (Type)BlockPartFace.class));
            }
            return lllllllllllllllIIlllIlIIIIlIIlll;
        }
        
        public Object deserialize(final JsonElement lllllllllllllllIIlllIIlllllIllII, final Type lllllllllllllllIIlllIIlllllIIlll, final JsonDeserializationContext lllllllllllllllIIlllIIlllllIIllI) {
            return this.func_178254_a(lllllllllllllllIIlllIIlllllIllII, lllllllllllllllIIlllIIlllllIIlll, lllllllllllllllIIlllIIlllllIIllI);
        }
    }
}
