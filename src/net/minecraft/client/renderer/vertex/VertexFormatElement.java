package net.minecraft.client.renderer.vertex;

import org.apache.logging.log4j.*;

public class VertexFormatElement
{
    private /* synthetic */ int field_177378_e;
    private static final /* synthetic */ Logger field_177381_a;
    private /* synthetic */ int field_177376_f;
    private final /* synthetic */ EnumUseage field_177380_c;
    private /* synthetic */ int field_177377_d;
    private final /* synthetic */ EnumType field_177379_b;
    
    public final boolean func_177374_g() {
        return this.field_177380_c == EnumUseage.POSITION;
    }
    
    public final int func_177369_e() {
        return this.field_177377_d;
    }
    
    public void func_177371_a(final int lllllllllllllllIIIIlIllIllIIIIll) {
        this.field_177376_f = lllllllllllllllIIIIlIllIllIIIIll;
    }
    
    public final int func_177368_f() {
        return this.field_177379_b.func_177395_a() * this.field_177378_e;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllllIIIIlIllIlIIIIlll) {
        if (this == lllllllllllllllIIIIlIllIlIIIIlll) {
            return true;
        }
        if (lllllllllllllllIIIIlIllIlIIIIlll != null && this.getClass() == lllllllllllllllIIIIlIllIlIIIIlll.getClass()) {
            final VertexFormatElement lllllllllllllllIIIIlIllIlIIIlIIl = (VertexFormatElement)lllllllllllllllIIIIlIllIlIIIIlll;
            return this.field_177378_e == lllllllllllllllIIIIlIllIlIIIlIIl.field_177378_e && this.field_177377_d == lllllllllllllllIIIIlIllIlIIIlIIl.field_177377_d && this.field_177376_f == lllllllllllllllIIIIlIllIlIIIlIIl.field_177376_f && this.field_177379_b == lllllllllllllllIIIIlIllIlIIIlIIl.field_177379_b && this.field_177380_c == lllllllllllllllIIIIlIllIlIIIlIIl.field_177380_c;
        }
        return false;
    }
    
    public final EnumType func_177367_b() {
        return this.field_177379_b;
    }
    
    @Override
    public int hashCode() {
        int lllllllllllllllIIIIlIllIlIIIIIlI = this.field_177379_b.hashCode();
        lllllllllllllllIIIIlIllIlIIIIIlI = 31 * lllllllllllllllIIIIlIllIlIIIIIlI + this.field_177380_c.hashCode();
        lllllllllllllllIIIIlIllIlIIIIIlI = 31 * lllllllllllllllIIIIlIllIlIIIIIlI + this.field_177377_d;
        lllllllllllllllIIIIlIllIlIIIIIlI = 31 * lllllllllllllllIIIIlIllIlIIIIIlI + this.field_177378_e;
        lllllllllllllllIIIIlIllIlIIIIIlI = 31 * lllllllllllllllIIIIlIllIlIIIIIlI + this.field_177376_f;
        return lllllllllllllllIIIIlIllIlIIIIIlI;
    }
    
    public final int func_177370_d() {
        return this.field_177378_e;
    }
    
    static {
        __OBFID = "CL_00002399";
        field_177381_a = LogManager.getLogger();
    }
    
    private final boolean func_177372_a(final int lllllllllllllllIIIIlIllIlIllIIIl, final EnumUseage lllllllllllllllIIIIlIllIlIlIllII) {
        return lllllllllllllllIIIIlIllIlIllIIIl == 0 || lllllllllllllllIIIIlIllIlIlIllII == EnumUseage.UV;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder(String.valueOf(this.field_177378_e)).append(",").append(this.field_177380_c.func_177384_a()).append(",").append(this.field_177379_b.func_177396_b()));
    }
    
    public int func_177373_a() {
        return this.field_177376_f;
    }
    
    public VertexFormatElement(final int lllllllllllllllIIIIlIllIllIlIlIl, final EnumType lllllllllllllllIIIIlIllIllIIllll, final EnumUseage lllllllllllllllIIIIlIllIllIlIIll, final int lllllllllllllllIIIIlIllIllIIllIl) {
        if (!this.func_177372_a(lllllllllllllllIIIIlIllIllIlIlIl, lllllllllllllllIIIIlIllIllIlIIll)) {
            VertexFormatElement.field_177381_a.warn("Multiple vertex elements of the same type other than UVs are not supported. Forcing type to UV.");
            this.field_177380_c = EnumUseage.UV;
        }
        else {
            this.field_177380_c = lllllllllllllllIIIIlIllIllIlIIll;
        }
        this.field_177379_b = lllllllllllllllIIIIlIllIllIIllll;
        this.field_177377_d = lllllllllllllllIIIIlIllIllIlIlIl;
        this.field_177378_e = lllllllllllllllIIIIlIllIllIIllIl;
        this.field_177376_f = 0;
    }
    
    public final EnumUseage func_177375_c() {
        return this.field_177380_c;
    }
    
    public enum EnumUseage
    {
        COLOR("COLOR", 2, "COLOR", 2, "Vertex Color"), 
        POSITION("POSITION", 0, "POSITION", 0, "Position"), 
        NORMAL("NORMAL", 1, "NORMAL", 1, "Normal"), 
        MATRIX("MATRIX", 4, "MATRIX", 4, "Bone Matrix"), 
        PADDING("PADDING", 6, "PADDING", 6, "Padding"), 
        BLEND_WEIGHT("BLEND_WEIGHT", 5, "BLEND_WEIGHT", 5, "Blend Weight");
        
        private final /* synthetic */ String field_177392_h;
        
        UV("UV", 3, "UV", 3, "UV");
        
        private EnumUseage(final String lllllllllllllllIlIIIllIlIIIlIllI, final int lllllllllllllllIlIIIllIlIIIlIlII, final String lllllllllllllllIlIIIllIlIIIllIll, final int lllllllllllllllIlIIIllIlIIIllIIl, final String lllllllllllllllIlIIIllIlIIIlIIlI) {
            this.field_177392_h = lllllllllllllllIlIIIllIlIIIlIIlI;
        }
        
        public String func_177384_a() {
            return this.field_177392_h;
        }
        
        static {
            __OBFID = "CL_00002397";
        }
    }
    
    public enum EnumType
    {
        UINT("UINT", 5, "UINT", 5, 4, "Unsigned Int", 5125);
        
        private final /* synthetic */ int field_177407_h;
        
        INT("INT", 6, "INT", 6, 4, "Int", 5124), 
        USHORT("USHORT", 3, "USHORT", 3, 2, "Unsigned Short", 5123);
        
        private final /* synthetic */ int field_177405_j;
        
        SHORT("SHORT", 4, "SHORT", 4, 2, "Short", 5122), 
        BYTE("BYTE", 2, "BYTE", 2, 1, "Byte", 5120), 
        FLOAT("FLOAT", 0, "FLOAT", 0, 4, "Float", 5126);
        
        private final /* synthetic */ String field_177408_i;
        
        UBYTE("UBYTE", 1, "UBYTE", 1, 1, "Unsigned Byte", 5121);
        
        static {
            __OBFID = "CL_00002398";
        }
        
        public int func_177397_c() {
            return this.field_177405_j;
        }
        
        public String func_177396_b() {
            return this.field_177408_i;
        }
        
        public int func_177395_a() {
            return this.field_177407_h;
        }
        
        private EnumType(final String llllllllllllllIllllllllIIIllllll, final int llllllllllllllIllllllllIIIlllllI, final String llllllllllllllIllllllllIIlIIIlIl, final int llllllllllllllIllllllllIIlIIIlII, final int llllllllllllllIllllllllIIlIIIIll, final String llllllllllllllIllllllllIIlIIIIlI, final int llllllllllllllIllllllllIIlIIIIIl) {
            this.field_177407_h = llllllllllllllIllllllllIIlIIIIll;
            this.field_177408_i = llllllllllllllIllllllllIIlIIIIlI;
            this.field_177405_j = llllllllllllllIllllllllIIlIIIIIl;
        }
    }
}
