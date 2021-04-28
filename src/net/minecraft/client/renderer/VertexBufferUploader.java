package net.minecraft.client.renderer;

import net.minecraft.client.renderer.vertex.*;

public class VertexBufferUploader extends WorldVertexBufferUploader
{
    private /* synthetic */ VertexBuffer field_178179_a;
    
    @Override
    public int draw(final WorldRenderer lllllllllllllllIllIlIIIllllIllll, final int lllllllllllllllIllIlIIIlllllIIIl) {
        lllllllllllllllIllIlIIIllllIllll.reset();
        this.field_178179_a.func_177360_a(lllllllllllllllIllIlIIIllllIllll.func_178966_f(), lllllllllllllllIllIlIIIllllIllll.func_178976_e());
        return lllllllllllllllIllIlIIIlllllIIIl;
    }
    
    static {
        __OBFID = "CL_00002532";
    }
    
    public void func_178178_a(final VertexBuffer lllllllllllllllIllIlIIIllllIlIlI) {
        this.field_178179_a = lllllllllllllllIllIlIIIllllIlIlI;
    }
    
    public VertexBufferUploader() {
        this.field_178179_a = null;
    }
}
