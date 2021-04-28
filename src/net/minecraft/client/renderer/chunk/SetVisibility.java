package net.minecraft.client.renderer.chunk;

import net.minecraft.util.*;
import java.util.*;

public class SetVisibility
{
    private final /* synthetic */ BitSet field_178622_b;
    private static final /* synthetic */ int field_178623_a;
    
    @Override
    public String toString() {
        final StringBuilder llllllllllllllllllllIIIlIIllllll = new StringBuilder();
        llllllllllllllllllllIIIlIIllllll.append(' ');
        for (final EnumFacing llllllllllllllllllllIIIlIIlllIll : EnumFacing.values()) {
            llllllllllllllllllllIIIlIIllllll.append(' ').append(llllllllllllllllllllIIIlIIlllIll.toString().toUpperCase().charAt(0));
        }
        llllllllllllllllllllIIIlIIllllll.append('\n');
        for (final EnumFacing llllllllllllllllllllIIIlIIlllIlI : EnumFacing.values()) {
            llllllllllllllllllllIIIlIIllllll.append(llllllllllllllllllllIIIlIIlllIlI.toString().toUpperCase().charAt(0));
            for (final EnumFacing llllllllllllllllllllIIIlIIllIllI : EnumFacing.values()) {
                if (llllllllllllllllllllIIIlIIlllIlI == llllllllllllllllllllIIIlIIllIllI) {
                    llllllllllllllllllllIIIlIIllllll.append("  ");
                }
                else {
                    final boolean llllllllllllllllllllIIIlIIllIlIl = this.func_178621_a(llllllllllllllllllllIIIlIIlllIlI, llllllllllllllllllllIIIlIIllIllI);
                    llllllllllllllllllllIIIlIIllllll.append(' ').append(llllllllllllllllllllIIIlIIllIlIl ? 'Y' : 'n');
                }
            }
            llllllllllllllllllllIIIlIIllllll.append('\n');
        }
        return String.valueOf(llllllllllllllllllllIIIlIIllllll);
    }
    
    public void func_178619_a(final EnumFacing llllllllllllllllllllIIIlIlIlllIl, final EnumFacing llllllllllllllllllllIIIlIllIIIII, final boolean llllllllllllllllllllIIIlIlIlllll) {
        this.field_178622_b.set(llllllllllllllllllllIIIlIlIlllIl.ordinal() + llllllllllllllllllllIIIlIllIIIII.ordinal() * SetVisibility.field_178623_a, llllllllllllllllllllIIIlIlIlllll);
        this.field_178622_b.set(llllllllllllllllllllIIIlIllIIIII.ordinal() + llllllllllllllllllllIIIlIlIlllIl.ordinal() * SetVisibility.field_178623_a, llllllllllllllllllllIIIlIlIlllll);
    }
    
    public void func_178620_a(final Set llllllllllllllllllllIIIlIlllIIIl) {
        for (final EnumFacing llllllllllllllllllllIIIlIllIllll : llllllllllllllllllllIIIlIlllIIIl) {
            for (final EnumFacing llllllllllllllllllllIIIlIllIllIl : llllllllllllllllllllIIIlIlllIIIl) {
                this.func_178619_a(llllllllllllllllllllIIIlIllIllll, llllllllllllllllllllIIIlIllIllIl, true);
            }
        }
    }
    
    public void func_178618_a(final boolean llllllllllllllllllllIIIlIlIlIlIl) {
        this.field_178622_b.set(0, this.field_178622_b.size(), llllllllllllllllllllIIIlIlIlIlIl);
    }
    
    static {
        __OBFID = "CL_00002448";
        field_178623_a = EnumFacing.values().length;
    }
    
    public SetVisibility() {
        this.field_178622_b = new BitSet(SetVisibility.field_178623_a * SetVisibility.field_178623_a);
    }
    
    public boolean func_178621_a(final EnumFacing llllllllllllllllllllIIIlIlIIllIl, final EnumFacing llllllllllllllllllllIIIlIlIIllII) {
        return this.field_178622_b.get(llllllllllllllllllllIIIlIlIIllIl.ordinal() + llllllllllllllllllllIIIlIlIIllII.ordinal() * SetVisibility.field_178623_a);
    }
}
