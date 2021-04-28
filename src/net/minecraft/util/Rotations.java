package net.minecraft.util;

import net.minecraft.nbt.*;

public class Rotations
{
    protected final /* synthetic */ float field_179418_c;
    protected final /* synthetic */ float field_179419_a;
    protected final /* synthetic */ float field_179417_b;
    
    public float func_179413_d() {
        return this.field_179418_c;
    }
    
    static {
        __OBFID = "CL_00002316";
    }
    
    public Rotations(final NBTTagList llllllllllllllIlllllIIlIIllIlllI) {
        this.field_179419_a = llllllllllllllIlllllIIlIIllIlllI.getFloat(0);
        this.field_179417_b = llllllllllllllIlllllIIlIIllIlllI.getFloat(1);
        this.field_179418_c = llllllllllllllIlllllIIlIIllIlllI.getFloat(2);
    }
    
    public float func_179415_b() {
        return this.field_179419_a;
    }
    
    public Rotations(final float llllllllllllllIlllllIIlIIlllllll, final float llllllllllllllIlllllIIlIIllllllI, final float llllllllllllllIlllllIIlIlIIIIIlI) {
        this.field_179419_a = llllllllllllllIlllllIIlIIlllllll;
        this.field_179417_b = llllllllllllllIlllllIIlIIllllllI;
        this.field_179418_c = llllllllllllllIlllllIIlIlIIIIIlI;
    }
    
    public NBTTagList func_179414_a() {
        final NBTTagList llllllllllllllIlllllIIlIIllIIIlI = new NBTTagList();
        llllllllllllllIlllllIIlIIllIIIlI.appendTag(new NBTTagFloat(this.field_179419_a));
        llllllllllllllIlllllIIlIIllIIIlI.appendTag(new NBTTagFloat(this.field_179417_b));
        llllllllllllllIlllllIIlIIllIIIlI.appendTag(new NBTTagFloat(this.field_179418_c));
        return llllllllllllllIlllllIIlIIllIIIlI;
    }
    
    public float func_179416_c() {
        return this.field_179417_b;
    }
    
    @Override
    public boolean equals(final Object llllllllllllllIlllllIIlIIlIlIlII) {
        if (!(llllllllllllllIlllllIIlIIlIlIlII instanceof Rotations)) {
            return false;
        }
        final Rotations llllllllllllllIlllllIIlIIlIlIIll = (Rotations)llllllllllllllIlllllIIlIIlIlIlII;
        return this.field_179419_a == llllllllllllllIlllllIIlIIlIlIIll.field_179419_a && this.field_179417_b == llllllllllllllIlllllIIlIIlIlIIll.field_179417_b && this.field_179418_c == llllllllllllllIlllllIIlIIlIlIIll.field_179418_c;
    }
}
