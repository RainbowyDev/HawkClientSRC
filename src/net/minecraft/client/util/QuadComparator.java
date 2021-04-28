package net.minecraft.client.util;

import java.util.*;
import java.nio.*;

public class QuadComparator implements Comparator
{
    private /* synthetic */ int field_178079_e;
    private /* synthetic */ float field_147629_c;
    private /* synthetic */ float field_147628_b;
    private /* synthetic */ FloatBuffer field_147627_d;
    private /* synthetic */ float field_147630_a;
    
    public int compare(final Integer llllllllllllllIllIlIlIlIIIIIlIll, final Integer llllllllllllllIllIlIlIlIIIIIlIlI) {
        final float llllllllllllllIllIlIlIlIIIlIllII = this.field_147627_d.get(llllllllllllllIllIlIlIlIIIIIlIll) - this.field_147630_a;
        final float llllllllllllllIllIlIlIlIIIlIlIll = this.field_147627_d.get(llllllllllllllIllIlIlIlIIIIIlIll + 1) - this.field_147628_b;
        final float llllllllllllllIllIlIlIlIIIlIlIlI = this.field_147627_d.get(llllllllllllllIllIlIlIlIIIIIlIll + 2) - this.field_147629_c;
        final float llllllllllllllIllIlIlIlIIIlIlIIl = this.field_147627_d.get(llllllllllllllIllIlIlIlIIIIIlIll + this.field_178079_e + 0) - this.field_147630_a;
        final float llllllllllllllIllIlIlIlIIIlIlIII = this.field_147627_d.get(llllllllllllllIllIlIlIlIIIIIlIll + this.field_178079_e + 1) - this.field_147628_b;
        final float llllllllllllllIllIlIlIlIIIlIIlll = this.field_147627_d.get(llllllllllllllIllIlIlIlIIIIIlIll + this.field_178079_e + 2) - this.field_147629_c;
        final float llllllllllllllIllIlIlIlIIIlIIllI = this.field_147627_d.get(llllllllllllllIllIlIlIlIIIIIlIll + this.field_178079_e * 2 + 0) - this.field_147630_a;
        final float llllllllllllllIllIlIlIlIIIlIIlIl = this.field_147627_d.get(llllllllllllllIllIlIlIlIIIIIlIll + this.field_178079_e * 2 + 1) - this.field_147628_b;
        final float llllllllllllllIllIlIlIlIIIlIIlII = this.field_147627_d.get(llllllllllllllIllIlIlIlIIIIIlIll + this.field_178079_e * 2 + 2) - this.field_147629_c;
        final float llllllllllllllIllIlIlIlIIIlIIIll = this.field_147627_d.get(llllllllllllllIllIlIlIlIIIIIlIll + this.field_178079_e * 3 + 0) - this.field_147630_a;
        final float llllllllllllllIllIlIlIlIIIlIIIlI = this.field_147627_d.get(llllllllllllllIllIlIlIlIIIIIlIll + this.field_178079_e * 3 + 1) - this.field_147628_b;
        final float llllllllllllllIllIlIlIlIIIlIIIIl = this.field_147627_d.get(llllllllllllllIllIlIlIlIIIIIlIll + this.field_178079_e * 3 + 2) - this.field_147629_c;
        final float llllllllllllllIllIlIlIlIIIlIIIII = this.field_147627_d.get(llllllllllllllIllIlIlIlIIIIIlIlI) - this.field_147630_a;
        final float llllllllllllllIllIlIlIlIIIIlllll = this.field_147627_d.get(llllllllllllllIllIlIlIlIIIIIlIlI + 1) - this.field_147628_b;
        final float llllllllllllllIllIlIlIlIIIIllllI = this.field_147627_d.get(llllllllllllllIllIlIlIlIIIIIlIlI + 2) - this.field_147629_c;
        final float llllllllllllllIllIlIlIlIIIIlllIl = this.field_147627_d.get(llllllllllllllIllIlIlIlIIIIIlIlI + this.field_178079_e + 0) - this.field_147630_a;
        final float llllllllllllllIllIlIlIlIIIIlllII = this.field_147627_d.get(llllllllllllllIllIlIlIlIIIIIlIlI + this.field_178079_e + 1) - this.field_147628_b;
        final float llllllllllllllIllIlIlIlIIIIllIll = this.field_147627_d.get(llllllllllllllIllIlIlIlIIIIIlIlI + this.field_178079_e + 2) - this.field_147629_c;
        final float llllllllllllllIllIlIlIlIIIIllIlI = this.field_147627_d.get(llllllllllllllIllIlIlIlIIIIIlIlI + this.field_178079_e * 2 + 0) - this.field_147630_a;
        final float llllllllllllllIllIlIlIlIIIIllIIl = this.field_147627_d.get(llllllllllllllIllIlIlIlIIIIIlIlI + this.field_178079_e * 2 + 1) - this.field_147628_b;
        final float llllllllllllllIllIlIlIlIIIIllIII = this.field_147627_d.get(llllllllllllllIllIlIlIlIIIIIlIlI + this.field_178079_e * 2 + 2) - this.field_147629_c;
        final float llllllllllllllIllIlIlIlIIIIlIlll = this.field_147627_d.get(llllllllllllllIllIlIlIlIIIIIlIlI + this.field_178079_e * 3 + 0) - this.field_147630_a;
        final float llllllllllllllIllIlIlIlIIIIlIllI = this.field_147627_d.get(llllllllllllllIllIlIlIlIIIIIlIlI + this.field_178079_e * 3 + 1) - this.field_147628_b;
        final float llllllllllllllIllIlIlIlIIIIlIlIl = this.field_147627_d.get(llllllllllllllIllIlIlIlIIIIIlIlI + this.field_178079_e * 3 + 2) - this.field_147629_c;
        final float llllllllllllllIllIlIlIlIIIIlIlII = (llllllllllllllIllIlIlIlIIIlIllII + llllllllllllllIllIlIlIlIIIlIlIIl + llllllllllllllIllIlIlIlIIIlIIllI + llllllllllllllIllIlIlIlIIIlIIIll) * 0.25f;
        final float llllllllllllllIllIlIlIlIIIIlIIll = (llllllllllllllIllIlIlIlIIIlIlIll + llllllllllllllIllIlIlIlIIIlIlIII + llllllllllllllIllIlIlIlIIIlIIlIl + llllllllllllllIllIlIlIlIIIlIIIlI) * 0.25f;
        final float llllllllllllllIllIlIlIlIIIIlIIlI = (llllllllllllllIllIlIlIlIIIlIlIlI + llllllllllllllIllIlIlIlIIIlIIlll + llllllllllllllIllIlIlIlIIIlIIlII + llllllllllllllIllIlIlIlIIIlIIIIl) * 0.25f;
        final float llllllllllllllIllIlIlIlIIIIlIIIl = (llllllllllllllIllIlIlIlIIIlIIIII + llllllllllllllIllIlIlIlIIIIlllIl + llllllllllllllIllIlIlIlIIIIllIlI + llllllllllllllIllIlIlIlIIIIlIlll) * 0.25f;
        final float llllllllllllllIllIlIlIlIIIIlIIII = (llllllllllllllIllIlIlIlIIIIlllll + llllllllllllllIllIlIlIlIIIIlllII + llllllllllllllIllIlIlIlIIIIllIIl + llllllllllllllIllIlIlIlIIIIlIllI) * 0.25f;
        final float llllllllllllllIllIlIlIlIIIIIllll = (llllllllllllllIllIlIlIlIIIIllllI + llllllllllllllIllIlIlIlIIIIllIll + llllllllllllllIllIlIlIlIIIIllIII + llllllllllllllIllIlIlIlIIIIlIlIl) * 0.25f;
        final float llllllllllllllIllIlIlIlIIIIIlllI = llllllllllllllIllIlIlIlIIIIlIlII * llllllllllllllIllIlIlIlIIIIlIlII + llllllllllllllIllIlIlIlIIIIlIIll * llllllllllllllIllIlIlIlIIIIlIIll + llllllllllllllIllIlIlIlIIIIlIIlI * llllllllllllllIllIlIlIlIIIIlIIlI;
        final float llllllllllllllIllIlIlIlIIIIIllIl = llllllllllllllIllIlIlIlIIIIlIIIl * llllllllllllllIllIlIlIlIIIIlIIIl + llllllllllllllIllIlIlIlIIIIlIIII * llllllllllllllIllIlIlIlIIIIlIIII + llllllllllllllIllIlIlIlIIIIIllll * llllllllllllllIllIlIlIlIIIIIllll;
        return Float.compare(llllllllllllllIllIlIlIlIIIIIllIl, llllllllllllllIllIlIlIlIIIIIlllI);
    }
    
    public QuadComparator(final FloatBuffer llllllllllllllIllIlIlIlIIlIlllIl, final float llllllllllllllIllIlIlIlIIlIlIllI, final float llllllllllllllIllIlIlIlIIlIllIll, final float llllllllllllllIllIlIlIlIIlIllIlI, final int llllllllllllllIllIlIlIlIIlIllIIl) {
        this.field_147627_d = llllllllllllllIllIlIlIlIIlIlllIl;
        this.field_147630_a = llllllllllllllIllIlIlIlIIlIlIllI;
        this.field_147628_b = llllllllllllllIllIlIlIlIIlIllIll;
        this.field_147629_c = llllllllllllllIllIlIlIlIIlIllIlI;
        this.field_178079_e = llllllllllllllIllIlIlIlIIlIllIIl;
    }
    
    @Override
    public int compare(final Object llllllllllllllIllIlIlIIllllIIIlI, final Object llllllllllllllIllIlIlIIllllIIlII) {
        return this.compare((Integer)llllllllllllllIllIlIlIIllllIIIlI, (Integer)llllllllllllllIllIlIlIIllllIIlII);
    }
    
    static {
        __OBFID = "CL_00000958";
    }
}
