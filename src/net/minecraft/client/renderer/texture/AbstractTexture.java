package net.minecraft.client.renderer.texture;

import net.minecraft.client.renderer.*;
import org.lwjgl.opengl.*;
import shadersmod.client.*;

public abstract class AbstractTexture implements ITextureObject
{
    protected /* synthetic */ boolean field_174939_e;
    protected /* synthetic */ boolean field_174941_c;
    protected /* synthetic */ int glTextureId;
    protected /* synthetic */ boolean field_174940_b;
    protected /* synthetic */ boolean field_174938_d;
    
    @Override
    public int getGlTextureId() {
        if (this.glTextureId == -1) {
            this.glTextureId = TextureUtil.glGenTextures();
        }
        return this.glTextureId;
    }
    
    @Override
    public void func_174935_a() {
        this.func_174937_a(this.field_174938_d, this.field_174939_e);
    }
    
    public void func_174937_a(final boolean llllllllllllllIIllIIIlIllIIIllll, final boolean llllllllllllllIIllIIIlIllIIIIlIl) {
        this.field_174940_b = llllllllllllllIIllIIIlIllIIIllll;
        this.field_174941_c = llllllllllllllIIllIIIlIllIIIIlIl;
        final boolean llllllllllllllIIllIIIlIllIIIllIl = true;
        final boolean llllllllllllllIIllIIIlIllIIIllII = true;
        int llllllllllllllIIllIIIlIllIIIlIlI = 0;
        short llllllllllllllIIllIIIlIllIIIlIII = 0;
        if (llllllllllllllIIllIIIlIllIIIllll) {
            final int llllllllllllllIIllIIIlIllIIIlIll = llllllllllllllIIllIIIlIllIIIIlIl ? 9987 : 9729;
            final short llllllllllllllIIllIIIlIllIIIlIIl = 9729;
        }
        else {
            llllllllllllllIIllIIIlIllIIIlIlI = (llllllllllllllIIllIIIlIllIIIIlIl ? 9986 : 9728);
            llllllllllllllIIllIIIlIllIIIlIII = 9728;
        }
        GlStateManager.func_179144_i(this.getGlTextureId());
        GL11.glTexParameteri(3553, 10241, llllllllllllllIIllIIIlIllIIIlIlI);
        GL11.glTexParameteri(3553, 10240, (int)llllllllllllllIIllIIIlIllIIIlIII);
    }
    
    public void deleteGlTexture() {
        ShadersTex.deleteTextures(this, this.glTextureId);
        if (this.glTextureId != -1) {
            TextureUtil.deleteTexture(this.glTextureId);
            this.glTextureId = -1;
        }
    }
    
    static {
        __OBFID = "CL_00001047";
    }
    
    public AbstractTexture() {
        this.glTextureId = -1;
    }
    
    @Override
    public MultiTexID getMultiTexID() {
        return ShadersTex.getMultiTexID(this);
    }
    
    @Override
    public void func_174936_b(final boolean llllllllllllllIIllIIIlIlIlllllII, final boolean llllllllllllllIIllIIIlIlIllllIII) {
        this.field_174938_d = this.field_174940_b;
        this.field_174939_e = this.field_174941_c;
        this.func_174937_a(llllllllllllllIIllIIIlIlIlllllII, llllllllllllllIIllIIIlIlIllllIII);
    }
}
