package net.minecraft.client.renderer.chunk;

import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;

public class ListedRenderChunk extends RenderChunk
{
    private final /* synthetic */ int field_178601_d;
    
    public ListedRenderChunk(final World lllllllllllllllllllIIIIlIllIIlIl, final RenderGlobal lllllllllllllllllllIIIIlIllIlIIl, final BlockPos lllllllllllllllllllIIIIlIllIIIll, final int lllllllllllllllllllIIIIlIllIIIlI) {
        super(lllllllllllllllllllIIIIlIllIIlIl, lllllllllllllllllllIIIIlIllIlIIl, lllllllllllllllllllIIIIlIllIIIll, lllllllllllllllllllIIIIlIllIIIlI);
        this.field_178601_d = GLAllocation.generateDisplayLists(EnumWorldBlockLayer.values().length);
    }
    
    static {
        __OBFID = "CL_00002453";
    }
    
    @Override
    public void func_178566_a() {
        super.func_178566_a();
        GLAllocation.func_178874_a(this.field_178601_d, EnumWorldBlockLayer.values().length);
    }
    
    public int func_178600_a(final EnumWorldBlockLayer lllllllllllllllllllIIIIlIlIlllIl, final CompiledChunk lllllllllllllllllllIIIIlIlIllIIl) {
        return lllllllllllllllllllIIIIlIlIllIIl.func_178491_b(lllllllllllllllllllIIIIlIlIlllIl) ? -1 : (this.field_178601_d + lllllllllllllllllllIIIIlIlIlllIl.ordinal());
    }
}
