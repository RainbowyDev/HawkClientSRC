package net.minecraft.util;

public class Vec4b
{
    private /* synthetic */ byte field_176117_a;
    private /* synthetic */ byte field_176114_d;
    private /* synthetic */ byte field_176115_b;
    private /* synthetic */ byte field_176116_c;
    
    public byte func_176111_d() {
        return this.field_176114_d;
    }
    
    public byte func_176112_b() {
        return this.field_176115_b;
    }
    
    @Override
    public int hashCode() {
        final byte llllllllllllllllIIlllIllllIlIIII = this.field_176117_a;
        int llllllllllllllllIIlllIllllIIllll = 31 * llllllllllllllllIIlllIllllIlIIII + this.field_176115_b;
        llllllllllllllllIIlllIllllIIllll = 31 * llllllllllllllllIIlllIllllIIllll + this.field_176116_c;
        llllllllllllllllIIlllIllllIIllll = 31 * llllllllllllllllIIlllIllllIIllll + this.field_176114_d;
        return llllllllllllllllIIlllIllllIIllll;
    }
    
    @Override
    public boolean equals(final Object llllllllllllllllIIlllIllllIllIIl) {
        if (this == llllllllllllllllIIlllIllllIllIIl) {
            return true;
        }
        if (!(llllllllllllllllIIlllIllllIllIIl instanceof Vec4b)) {
            return false;
        }
        final Vec4b llllllllllllllllIIlllIllllIllIII = (Vec4b)llllllllllllllllIIlllIllllIllIIl;
        return this.field_176117_a == llllllllllllllllIIlllIllllIllIII.field_176117_a && this.field_176114_d == llllllllllllllllIIlllIllllIllIII.field_176114_d && this.field_176115_b == llllllllllllllllIIlllIllllIllIII.field_176115_b && this.field_176116_c == llllllllllllllllIIlllIllllIllIII.field_176116_c;
    }
    
    static {
        __OBFID = "CL_00001964";
    }
    
    public byte func_176113_c() {
        return this.field_176116_c;
    }
    
    public byte func_176110_a() {
        return this.field_176117_a;
    }
    
    public Vec4b(final Vec4b llllllllllllllllIIlllIlllllIlIlI) {
        this.field_176117_a = llllllllllllllllIIlllIlllllIlIlI.field_176117_a;
        this.field_176115_b = llllllllllllllllIIlllIlllllIlIlI.field_176115_b;
        this.field_176116_c = llllllllllllllllIIlllIlllllIlIlI.field_176116_c;
        this.field_176114_d = llllllllllllllllIIlllIlllllIlIlI.field_176114_d;
    }
    
    public Vec4b(final byte llllllllllllllllIIlllIlllllllIII, final byte llllllllllllllllIIlllIllllllIIlI, final byte llllllllllllllllIIlllIllllllIIIl, final byte llllllllllllllllIIlllIllllllIIII) {
        this.field_176117_a = llllllllllllllllIIlllIlllllllIII;
        this.field_176115_b = llllllllllllllllIIlllIllllllIIlI;
        this.field_176116_c = llllllllllllllllIIlllIllllllIIIl;
        this.field_176114_d = llllllllllllllllIIlllIllllllIIII;
    }
}
