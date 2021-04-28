package net.minecraft.client.renderer.chunk;

import java.util.*;
import net.minecraft.client.renderer.*;
import com.google.common.collect.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;

public class CompiledChunk
{
    private final /* synthetic */ boolean[] field_178500_b;
    private final /* synthetic */ List field_178499_e;
    private /* synthetic */ WorldRenderer.State field_178497_g;
    private /* synthetic */ SetVisibility field_178496_f;
    private /* synthetic */ boolean field_178498_d;
    private final /* synthetic */ boolean[] field_178501_c;
    
    public CompiledChunk() {
        this.field_178500_b = new boolean[EnumWorldBlockLayer.values().length];
        this.field_178501_c = new boolean[EnumWorldBlockLayer.values().length];
        this.field_178498_d = true;
        this.field_178499_e = Lists.newArrayList();
        this.field_178496_f = new SetVisibility();
    }
    
    public void func_178488_a(final SetVisibility llllllllllllllllIIlIIlIlIIIIIlII) {
        this.field_178496_f = llllllllllllllllIIlIIlIlIIIIIlII;
    }
    
    public boolean func_178491_b(final EnumWorldBlockLayer llllllllllllllllIIlIIlIlIIlIIllI) {
        return !this.field_178500_b[llllllllllllllllIIlIIlIlIIlIIllI.ordinal()];
    }
    
    public void func_178490_a(final TileEntity llllllllllllllllIIlIIlIlIIIlIIll) {
        this.field_178499_e.add(llllllllllllllllIIlIIlIlIIIlIIll);
    }
    
    static {
        __OBFID = "CL_00002456";
        field_178502_a = new CompiledChunk() {
            @Override
            protected void func_178486_a(final EnumWorldBlockLayer lIIlIIllIIllIlI) {
                throw new UnsupportedOperationException();
            }
            
            static {
                __OBFID = "CL_00002455";
            }
            
            @Override
            public void func_178493_c(final EnumWorldBlockLayer lIIlIIllIIllIII) {
                throw new UnsupportedOperationException();
            }
            
            @Override
            public boolean func_178495_a(final EnumFacing lIIlIIllIIlIllI, final EnumFacing lIIlIIllIIlIlIl) {
                return false;
            }
        };
    }
    
    public void func_178494_a(final WorldRenderer.State llllllllllllllllIIlIIlIIlllllIll) {
        this.field_178497_g = llllllllllllllllIIlIIlIIlllllIll;
    }
    
    public boolean func_178489_a() {
        return this.field_178498_d;
    }
    
    protected void func_178486_a(final EnumWorldBlockLayer llllllllllllllllIIlIIlIlIIlIllII) {
        this.field_178498_d = false;
        this.field_178500_b[llllllllllllllllIIlIIlIlIIlIllII.ordinal()] = true;
    }
    
    public WorldRenderer.State func_178487_c() {
        return this.field_178497_g;
    }
    
    public boolean func_178492_d(final EnumWorldBlockLayer llllllllllllllllIIlIIlIlIIIllIlI) {
        return this.field_178501_c[llllllllllllllllIIlIIlIlIIIllIlI.ordinal()];
    }
    
    public boolean func_178495_a(final EnumFacing llllllllllllllllIIlIIlIlIIIIllII, final EnumFacing llllllllllllllllIIlIIlIlIIIIlIll) {
        return this.field_178496_f.func_178621_a(llllllllllllllllIIlIIlIlIIIIllII, llllllllllllllllIIlIIlIlIIIIlIll);
    }
    
    public void func_178493_c(final EnumWorldBlockLayer llllllllllllllllIIlIIlIlIIlIIIlI) {
        this.field_178501_c[llllllllllllllllIIlIIlIlIIlIIIlI.ordinal()] = true;
    }
    
    public List func_178485_b() {
        return this.field_178499_e;
    }
}
