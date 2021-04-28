package shadersmod.client;

import org.lwjgl.opengl.*;
import org.lwjgl.*;
import net.minecraft.client.renderer.*;
import java.nio.*;

public class HFNoiseTexture
{
    public /* synthetic */ int textureUnit;
    public /* synthetic */ int texID;
    
    public int getID() {
        return this.texID;
    }
    
    private int random(int lIIlIIlIllIIIII) {
        lIIlIIlIllIIIII ^= lIIlIIlIllIIIII << 13;
        lIIlIIlIllIIIII ^= lIIlIIlIllIIIII >> 17;
        lIIlIIlIllIIIII ^= lIIlIIlIllIIIII << 5;
        return lIIlIIlIllIIIII;
    }
    
    private byte[] genHFNoiseImage(final int lIIlIIlIlIIIlll, final int lIIlIIlIlIIIllI) {
        final byte[] lIIlIIlIlIIIlIl = new byte[lIIlIIlIlIIIlll * lIIlIIlIlIIIllI * 3];
        int lIIlIIlIlIIIlII = 0;
        for (int lIIlIIlIlIIIIll = 0; lIIlIIlIlIIIIll < lIIlIIlIlIIIllI; ++lIIlIIlIlIIIIll) {
            for (int lIIlIIlIlIIIIlI = 0; lIIlIIlIlIIIIlI < lIIlIIlIlIIIlll; ++lIIlIIlIlIIIIlI) {
                for (int lIIlIIlIlIIIIIl = 1; lIIlIIlIlIIIIIl < 4; ++lIIlIIlIlIIIIIl) {
                    lIIlIIlIlIIIlIl[lIIlIIlIlIIIlII++] = this.random(lIIlIIlIlIIIIlI, lIIlIIlIlIIIIll, lIIlIIlIlIIIIIl);
                }
            }
        }
        return lIIlIIlIlIIIlIl;
    }
    
    public HFNoiseTexture(final int lIIlIIlIlllIIlI, final int lIIlIIlIlllIIIl) {
        this.texID = GL11.glGenTextures();
        this.textureUnit = 15;
        final byte[] lIIlIIlIlllIIII = this.genHFNoiseImage(lIIlIIlIlllIIlI, lIIlIIlIlllIIIl);
        final ByteBuffer lIIlIIlIllIllll = BufferUtils.createByteBuffer(lIIlIIlIlllIIII.length);
        lIIlIIlIllIllll.put(lIIlIIlIlllIIII);
        lIIlIIlIllIllll.flip();
        GlStateManager.func_179144_i(this.texID);
        GL11.glTexImage2D(3553, 0, 6407, lIIlIIlIlllIIlI, lIIlIIlIlllIIIl, 0, 6407, 5121, lIIlIIlIllIllll);
        GL11.glTexParameteri(3553, 10242, 10497);
        GL11.glTexParameteri(3553, 10243, 10497);
        GL11.glTexParameteri(3553, 10240, 9729);
        GL11.glTexParameteri(3553, 10241, 9729);
        GlStateManager.func_179144_i(0);
    }
    
    private byte random(final int lIIlIIlIlIlIlII, final int lIIlIIlIlIllIII, final int lIIlIIlIlIlIlll) {
        final int lIIlIIlIlIlIllI = (this.random(lIIlIIlIlIlIlII) + this.random(lIIlIIlIlIllIII * 19)) * this.random(lIIlIIlIlIlIlll * 23) - lIIlIIlIlIlIlll;
        return (byte)(this.random(lIIlIIlIlIlIllI) % 128);
    }
    
    public void destroy() {
        GlStateManager.func_179150_h(this.texID);
        this.texID = 0;
    }
}
