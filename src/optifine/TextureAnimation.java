package optifine;

import net.minecraft.util.*;
import java.nio.*;
import net.minecraft.client.renderer.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.texture.*;
import java.util.*;

public class TextureAnimation
{
    private /* synthetic */ String dstTex;
    private /* synthetic */ int frameHeight;
    private /* synthetic */ int dstTextId;
    /* synthetic */ byte[] srcData;
    /* synthetic */ ResourceLocation dstTexLoc;
    private /* synthetic */ int dstX;
    private /* synthetic */ int dstY;
    private /* synthetic */ TextureAnimationFrame[] frames;
    private /* synthetic */ int frameWidth;
    private /* synthetic */ String srcTex;
    private /* synthetic */ int activeFrame;
    private /* synthetic */ ByteBuffer imageData;
    
    public boolean updateTexture() {
        if (this.dstTextId < 0) {
            final ITextureObject lllllllllllllllllllllIlllIIlIIII = TextureUtils.getTexture(this.dstTexLoc);
            if (lllllllllllllllllllllIlllIIlIIII == null) {
                return false;
            }
            this.dstTextId = lllllllllllllllllllllIlllIIlIIII.getGlTextureId();
        }
        if (this.imageData == null) {
            this.imageData = GLAllocation.createDirectByteBuffer(this.srcData.length);
            this.imageData.put(this.srcData);
            this.srcData = null;
        }
        if (!this.nextFrame()) {
            return false;
        }
        final int lllllllllllllllllllllIlllIIIllll = this.frameWidth * this.frameHeight * 4;
        final int lllllllllllllllllllllIlllIIIlllI = this.getActiveFrameIndex();
        final int lllllllllllllllllllllIlllIIIllIl = lllllllllllllllllllllIlllIIIllll * lllllllllllllllllllllIlllIIIlllI;
        if (lllllllllllllllllllllIlllIIIllIl + lllllllllllllllllllllIlllIIIllll > this.imageData.capacity()) {
            return false;
        }
        this.imageData.position(lllllllllllllllllllllIlllIIIllIl);
        GlStateManager.func_179144_i(this.dstTextId);
        GL11.glTexSubImage2D(3553, 0, this.dstX, this.dstY, this.frameWidth, this.frameHeight, 6408, 5121, this.imageData);
        return true;
    }
    
    public int getActiveFrameIndex() {
        if (this.frames.length <= 0) {
            return 0;
        }
        if (this.activeFrame >= this.frames.length) {
            this.activeFrame = 0;
        }
        final TextureAnimationFrame lllllllllllllllllllllIlllIIllIll = this.frames[this.activeFrame];
        return lllllllllllllllllllllIlllIIllIll.index;
    }
    
    public boolean nextFrame() {
        if (this.frames.length <= 0) {
            return false;
        }
        if (this.activeFrame >= this.frames.length) {
            this.activeFrame = 0;
        }
        final TextureAnimationFrame textureAnimationFrame;
        final TextureAnimationFrame lllllllllllllllllllllIlllIlIIIIl = textureAnimationFrame = this.frames[this.activeFrame];
        ++textureAnimationFrame.counter;
        if (lllllllllllllllllllllIlllIlIIIIl.counter < lllllllllllllllllllllIlllIlIIIIl.duration) {
            return false;
        }
        lllllllllllllllllllllIlllIlIIIIl.counter = 0;
        ++this.activeFrame;
        if (this.activeFrame >= this.frames.length) {
            this.activeFrame = 0;
        }
        return true;
    }
    
    public String getSrcTex() {
        return this.srcTex;
    }
    
    public ResourceLocation getDstTexLoc() {
        return this.dstTexLoc;
    }
    
    public String getDstTex() {
        return this.dstTex;
    }
    
    public TextureAnimation(final String lllllllllllllllllllllIllllIIlllI, final byte[] lllllllllllllllllllllIllllIIllIl, final String lllllllllllllllllllllIllllIIllII, final ResourceLocation lllllllllllllllllllllIllllIIlIll, final int lllllllllllllllllllllIllllIIlIlI, final int lllllllllllllllllllllIllllIIlIIl, final int lllllllllllllllllllllIlllIllIIlI, final int lllllllllllllllllllllIllllIIIlll, final Properties lllllllllllllllllllllIlllIllIIII, final int lllllllllllllllllllllIllllIIIlIl) {
        this.srcTex = null;
        this.dstTex = null;
        this.dstTexLoc = null;
        this.dstTextId = -1;
        this.dstX = 0;
        this.dstY = 0;
        this.frameWidth = 0;
        this.frameHeight = 0;
        this.frames = null;
        this.activeFrame = 0;
        this.srcData = null;
        this.imageData = null;
        this.srcTex = lllllllllllllllllllllIllllIIlllI;
        this.dstTex = lllllllllllllllllllllIllllIIllII;
        this.dstTexLoc = lllllllllllllllllllllIllllIIlIll;
        this.dstX = lllllllllllllllllllllIllllIIlIlI;
        this.dstY = lllllllllllllllllllllIllllIIlIIl;
        this.frameWidth = lllllllllllllllllllllIlllIllIIlI;
        this.frameHeight = lllllllllllllllllllllIllllIIIlll;
        final int lllllllllllllllllllllIllllIIIlII = lllllllllllllllllllllIlllIllIIlI * lllllllllllllllllllllIllllIIIlll * 4;
        if (lllllllllllllllllllllIllllIIllIl.length % lllllllllllllllllllllIllllIIIlII != 0) {
            Config.warn(String.valueOf(new StringBuilder("Invalid animated texture length: ").append(lllllllllllllllllllllIllllIIllIl.length).append(", frameWidth: ").append(lllllllllllllllllllllIlllIllIIlI).append(", frameHeight: ").append(lllllllllllllllllllllIllllIIIlll)));
        }
        this.srcData = lllllllllllllllllllllIllllIIllIl;
        int lllllllllllllllllllllIllllIIIIll = lllllllllllllllllllllIllllIIllIl.length / lllllllllllllllllllllIllllIIIlII;
        if (lllllllllllllllllllllIlllIllIIII.get("tile.0") != null) {
            for (int lllllllllllllllllllllIllllIIIIlI = 0; lllllllllllllllllllllIlllIllIIII.get(String.valueOf(new StringBuilder("tile.").append(lllllllllllllllllllllIllllIIIIlI))) != null; ++lllllllllllllllllllllIllllIIIIlI) {
                lllllllllllllllllllllIllllIIIIll = lllllllllllllllllllllIllllIIIIlI + 1;
            }
        }
        final String lllllllllllllllllllllIllllIIIIIl = ((Hashtable<K, String>)lllllllllllllllllllllIlllIllIIII).get("duration");
        final int lllllllllllllllllllllIllllIIIIII = Config.parseInt(lllllllllllllllllllllIllllIIIIIl, lllllllllllllllllllllIllllIIIlIl);
        this.frames = new TextureAnimationFrame[lllllllllllllllllllllIllllIIIIll];
        for (int lllllllllllllllllllllIlllIllllll = 0; lllllllllllllllllllllIlllIllllll < this.frames.length; ++lllllllllllllllllllllIlllIllllll) {
            final String lllllllllllllllllllllIlllIlllllI = ((Hashtable<K, String>)lllllllllllllllllllllIlllIllIIII).get(String.valueOf(new StringBuilder("tile.").append(lllllllllllllllllllllIlllIllllll)));
            final int lllllllllllllllllllllIlllIllllIl = Config.parseInt(lllllllllllllllllllllIlllIlllllI, lllllllllllllllllllllIlllIllllll);
            final String lllllllllllllllllllllIlllIllllII = ((Hashtable<K, String>)lllllllllllllllllllllIlllIllIIII).get(String.valueOf(new StringBuilder("duration.").append(lllllllllllllllllllllIlllIllllll)));
            final int lllllllllllllllllllllIlllIlllIll = Config.parseInt(lllllllllllllllllllllIlllIllllII, lllllllllllllllllllllIllllIIIIII);
            final TextureAnimationFrame lllllllllllllllllllllIlllIlllIlI = new TextureAnimationFrame(lllllllllllllllllllllIlllIllllIl, lllllllllllllllllllllIlllIlllIll);
            this.frames[lllllllllllllllllllllIlllIllllll] = lllllllllllllllllllllIlllIlllIlI;
        }
    }
    
    public int getFrameCount() {
        return this.frames.length;
    }
}
