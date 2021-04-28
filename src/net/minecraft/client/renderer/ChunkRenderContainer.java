package net.minecraft.client.renderer;

import java.util.*;
import net.minecraft.client.renderer.chunk.*;
import net.minecraft.util.*;
import com.google.common.collect.*;

public abstract class ChunkRenderContainer
{
    protected /* synthetic */ List field_178009_a;
    protected /* synthetic */ boolean field_178007_b;
    private /* synthetic */ double field_178005_d;
    private /* synthetic */ double field_178006_e;
    private /* synthetic */ double field_178008_c;
    
    public void func_178003_a(final RenderChunk lIllIllllllIII) {
        final BlockPos lIllIllllllIlI = lIllIllllllIII.func_178568_j();
        GlStateManager.translate((float)(lIllIllllllIlI.getX() - this.field_178008_c), (float)(lIllIllllllIlI.getY() - this.field_178005_d), (float)(lIllIllllllIlI.getZ() - this.field_178006_e));
    }
    
    public abstract void func_178001_a(final EnumWorldBlockLayer p0);
    
    public void func_178002_a(final RenderChunk lIllIlllllIIll, final EnumWorldBlockLayer lIllIlllllIIlI) {
        this.field_178009_a.add(lIllIlllllIIll);
    }
    
    public void func_178004_a(final double lIlllIIIIIIIlI, final double lIlllIIIIIIIIl, final double lIlllIIIIIIlII) {
        this.field_178007_b = true;
        this.field_178009_a.clear();
        this.field_178008_c = lIlllIIIIIIIlI;
        this.field_178005_d = lIlllIIIIIIIIl;
        this.field_178006_e = lIlllIIIIIIlII;
    }
    
    public ChunkRenderContainer() {
        this.field_178009_a = Lists.newArrayListWithCapacity(17424);
    }
    
    static {
        __OBFID = "CL_00002563";
    }
}
