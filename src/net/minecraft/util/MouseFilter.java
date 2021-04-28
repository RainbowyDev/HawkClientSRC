package net.minecraft.util;

public class MouseFilter
{
    private /* synthetic */ float field_76334_b;
    private /* synthetic */ float field_76336_a;
    private /* synthetic */ float field_76335_c;
    
    public float smooth(float lIIlllIllIllllI, final float lIIlllIllIlllIl) {
        this.field_76336_a += lIIlllIllIllllI;
        lIIlllIllIllllI = (this.field_76336_a - this.field_76334_b) * lIIlllIllIlllIl;
        this.field_76335_c += (lIIlllIllIllllI - this.field_76335_c) * 0.5f;
        if ((lIIlllIllIllllI > 0.0f && lIIlllIllIllllI > this.field_76335_c) || (lIIlllIllIllllI < 0.0f && lIIlllIllIllllI < this.field_76335_c)) {
            lIIlllIllIllllI = this.field_76335_c;
        }
        this.field_76334_b += lIIlllIllIllllI;
        return lIIlllIllIllllI;
    }
    
    public void func_180179_a() {
        this.field_76336_a = 0.0f;
        this.field_76334_b = 0.0f;
        this.field_76335_c = 0.0f;
    }
    
    static {
        __OBFID = "CL_00001500";
    }
}
