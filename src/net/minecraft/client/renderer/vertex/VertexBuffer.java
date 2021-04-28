package net.minecraft.client.renderer.vertex;

import net.minecraft.client.renderer.*;
import java.nio.*;
import org.lwjgl.opengl.*;

public class VertexBuffer
{
    private /* synthetic */ int field_177364_c;
    private /* synthetic */ int field_177365_a;
    private final /* synthetic */ VertexFormat field_177363_b;
    
    static {
        __OBFID = "CL_00002402";
    }
    
    public VertexBuffer(final VertexFormat lllllllllllllllIlllllIIllIlllIII) {
        this.field_177363_b = lllllllllllllllIlllllIIllIlllIII;
        this.field_177365_a = OpenGlHelper.func_176073_e();
    }
    
    public void func_177360_a(final ByteBuffer lllllllllllllllIlllllIIllIlIllIl, final int lllllllllllllllIlllllIIllIlIllll) {
        this.func_177359_a();
        OpenGlHelper.func_176071_a(OpenGlHelper.field_176089_P, lllllllllllllllIlllllIIllIlIllIl, 35044);
        this.func_177361_b();
        this.field_177364_c = lllllllllllllllIlllllIIllIlIllll / this.field_177363_b.func_177338_f();
    }
    
    public void func_177359_a() {
        OpenGlHelper.func_176072_g(OpenGlHelper.field_176089_P, this.field_177365_a);
    }
    
    public void func_177361_b() {
        OpenGlHelper.func_176072_g(OpenGlHelper.field_176089_P, 0);
    }
    
    public void func_177362_c() {
        if (this.field_177365_a >= 0) {
            OpenGlHelper.func_176074_g(this.field_177365_a);
            this.field_177365_a = -1;
        }
    }
    
    public void func_177358_a(final int lllllllllllllllIlllllIIllIlIIllI) {
        GL11.glDrawArrays(lllllllllllllllIlllllIIllIlIIllI, 0, this.field_177364_c);
    }
}
