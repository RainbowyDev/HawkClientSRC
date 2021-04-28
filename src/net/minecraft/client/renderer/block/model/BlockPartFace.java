package net.minecraft.client.renderer.block.model;

import java.lang.reflect.*;
import com.google.gson.*;
import net.minecraft.util.*;

public class BlockPartFace
{
    public final /* synthetic */ String field_178242_d;
    public final /* synthetic */ int field_178245_c;
    public final /* synthetic */ EnumFacing field_178244_b;
    public final /* synthetic */ BlockFaceUV field_178243_e;
    
    static {
        __OBFID = "CL_00002508";
        field_178246_a = null;
    }
    
    public BlockPartFace(final EnumFacing lllllllllllllllIllIIIlllIlllIIIl, final int lllllllllllllllIllIIIlllIllIlIll, final String lllllllllllllllIllIIIlllIllIlIlI, final BlockFaceUV lllllllllllllllIllIIIlllIllIlllI) {
        this.field_178244_b = lllllllllllllllIllIIIlllIlllIIIl;
        this.field_178245_c = lllllllllllllllIllIIIlllIllIlIll;
        this.field_178242_d = lllllllllllllllIllIIIlllIllIlIlI;
        this.field_178243_e = lllllllllllllllIllIIIlllIllIlllI;
    }
    
    static class Deserializer implements JsonDeserializer
    {
        public BlockPartFace func_178338_a(final JsonElement llllllllllllllIllIlIIllIllllIIII, final Type llllllllllllllIllIlIIllIlllIllll, final JsonDeserializationContext llllllllllllllIllIlIIllIlllIlllI) {
            final JsonObject llllllllllllllIllIlIIllIlllIllIl = llllllllllllllIllIlIIllIllllIIII.getAsJsonObject();
            final EnumFacing llllllllllllllIllIlIIllIlllIllII = this.func_178339_c(llllllllllllllIllIlIIllIlllIllIl);
            final int llllllllllllllIllIlIIllIlllIlIll = this.func_178337_a(llllllllllllllIllIlIIllIlllIllIl);
            final String llllllllllllllIllIlIIllIlllIlIlI = this.func_178340_b(llllllllllllllIllIlIIllIlllIllIl);
            final BlockFaceUV llllllllllllllIllIlIIllIlllIlIIl = (BlockFaceUV)llllllllllllllIllIlIIllIlllIlllI.deserialize((JsonElement)llllllllllllllIllIlIIllIlllIllIl, (Type)BlockFaceUV.class);
            return new BlockPartFace(llllllllllllllIllIlIIllIlllIllII, llllllllllllllIllIlIIllIlllIlIll, llllllllllllllIllIlIIllIlllIlIlI, llllllllllllllIllIlIIllIlllIlIIl);
        }
        
        static {
            __OBFID = "CL_00002507";
        }
        
        public Object deserialize(final JsonElement llllllllllllllIllIlIIllIllIIlIII, final Type llllllllllllllIllIlIIllIllIIlIll, final JsonDeserializationContext llllllllllllllIllIlIIllIllIIlIlI) {
            return this.func_178338_a(llllllllllllllIllIlIIllIllIIlIII, llllllllllllllIllIlIIllIllIIlIll, llllllllllllllIllIlIIllIllIIlIlI);
        }
        
        private String func_178340_b(final JsonObject llllllllllllllIllIlIIllIllIllIlI) {
            return JsonUtils.getJsonObjectStringFieldValue(llllllllllllllIllIlIIllIllIllIlI, "texture");
        }
        
        private EnumFacing func_178339_c(final JsonObject llllllllllllllIllIlIIllIllIlIlIl) {
            final String llllllllllllllIllIlIIllIllIlIlII = JsonUtils.getJsonObjectStringFieldValueOrDefault(llllllllllllllIllIlIIllIllIlIlIl, "cullface", "");
            return EnumFacing.byName(llllllllllllllIllIlIIllIllIlIlII);
        }
        
        protected int func_178337_a(final JsonObject llllllllllllllIllIlIIllIllIlllIl) {
            return JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllIllIlIIllIllIlllIl, "tintindex", -1);
        }
    }
}
