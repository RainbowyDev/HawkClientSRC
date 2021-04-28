package optifine;

import net.minecraft.client.renderer.block.model.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.util.*;
import java.util.*;

public class NaturalProperties
{
    public /* synthetic */ boolean flip;
    private /* synthetic */ Map[] quadMaps;
    public /* synthetic */ int rotation;
    
    private int[] transformVertexData(final int[] llllllllllllllllIllIIlIIlIllIIII, final int llllllllllllllllIllIIlIIlIlllIII, final boolean llllllllllllllllIllIIlIIlIlIlllI) {
        final int[] llllllllllllllllIllIIlIIlIllIllI = llllllllllllllllIllIIlIIlIllIIII.clone();
        int llllllllllllllllIllIIlIIlIllIlIl = 4 - llllllllllllllllIllIIlIIlIlllIII;
        if (llllllllllllllllIllIIlIIlIlIlllI) {
            llllllllllllllllIllIIlIIlIllIlIl += 3;
        }
        llllllllllllllllIllIIlIIlIllIlIl %= 4;
        final int llllllllllllllllIllIIlIIlIllIlII = llllllllllllllllIllIIlIIlIllIllI.length / 4;
        for (int llllllllllllllllIllIIlIIlIllIIll = 0; llllllllllllllllIllIIlIIlIllIIll < 4; ++llllllllllllllllIllIIlIIlIllIIll) {
            final int llllllllllllllllIllIIlIIlIllIIlI = llllllllllllllllIllIIlIIlIllIIll * llllllllllllllllIllIIlIIlIllIlII;
            final int llllllllllllllllIllIIlIIlIllIIIl = llllllllllllllllIllIIlIIlIllIlIl * llllllllllllllllIllIIlIIlIllIlII;
            llllllllllllllllIllIIlIIlIllIllI[llllllllllllllllIllIIlIIlIllIIIl + 4] = llllllllllllllllIllIIlIIlIllIIII[llllllllllllllllIllIIlIIlIllIIlI + 4];
            llllllllllllllllIllIIlIIlIllIllI[llllllllllllllllIllIIlIIlIllIIIl + 4 + 1] = llllllllllllllllIllIIlIIlIllIIII[llllllllllllllllIllIIlIIlIllIIlI + 4 + 1];
            if (llllllllllllllllIllIIlIIlIlIlllI) {
                if (--llllllllllllllllIllIIlIIlIllIlIl < 0) {
                    llllllllllllllllIllIIlIIlIllIlIl = 3;
                }
            }
            else if (++llllllllllllllllIllIIlIIlIllIlIl > 3) {
                llllllllllllllllIllIIlIIlIllIlIl = 0;
            }
        }
        return llllllllllllllllIllIIlIIlIllIllI;
    }
    
    public NaturalProperties(final String llllllllllllllllIllIIlIIllllIlll) {
        this.rotation = 1;
        this.flip = false;
        this.quadMaps = new Map[8];
        if (llllllllllllllllIllIIlIIllllIlll.equals("4")) {
            this.rotation = 4;
        }
        else if (llllllllllllllllIllIIlIIllllIlll.equals("2")) {
            this.rotation = 2;
        }
        else if (llllllllllllllllIllIIlIIllllIlll.equals("F")) {
            this.flip = true;
        }
        else if (llllllllllllllllIllIIlIIllllIlll.equals("4F")) {
            this.rotation = 4;
            this.flip = true;
        }
        else if (llllllllllllllllIllIIlIIllllIlll.equals("2F")) {
            this.rotation = 2;
            this.flip = true;
        }
        else {
            Config.warn(String.valueOf(new StringBuilder("NaturalTextures: Unknown type: ").append(llllllllllllllllIllIIlIIllllIlll)));
        }
    }
    
    private BakedQuad makeQuad(final BakedQuad llllllllllllllllIllIIlIIllIIlIll, final int llllllllllllllllIllIIlIIllIIlIlI, final boolean llllllllllllllllIllIIlIIllIlIIlI) {
        int[] llllllllllllllllIllIIlIIllIlIIIl = llllllllllllllllIllIIlIIllIIlIll.func_178209_a();
        final int llllllllllllllllIllIIlIIllIlIIII = llllllllllllllllIllIIlIIllIIlIll.func_178211_c();
        final EnumFacing llllllllllllllllIllIIlIIllIIllll = llllllllllllllllIllIIlIIllIIlIll.getFace();
        final TextureAtlasSprite llllllllllllllllIllIIlIIllIIlllI = llllllllllllllllIllIIlIIllIIlIll.getSprite();
        if (!this.isFullSprite(llllllllllllllllIllIIlIIllIIlIll)) {
            return llllllllllllllllIllIIlIIllIIlIll;
        }
        llllllllllllllllIllIIlIIllIlIIIl = this.transformVertexData(llllllllllllllllIllIIlIIllIlIIIl, llllllllllllllllIllIIlIIllIIlIlI, llllllllllllllllIllIIlIIllIlIIlI);
        final BakedQuad llllllllllllllllIllIIlIIllIIllIl = new BakedQuad(llllllllllllllllIllIIlIIllIlIIIl, llllllllllllllllIllIIlIIllIlIIII, llllllllllllllllIllIIlIIllIIllll, llllllllllllllllIllIIlIIllIIlllI);
        return llllllllllllllllIllIIlIIllIIllIl;
    }
    
    private boolean equalsDelta(final float llllllllllllllllIllIIlIIIllIllll, final float llllllllllllllllIllIIlIIIllIlIlI, final float llllllllllllllllIllIIlIIIllIllIl) {
        final float llllllllllllllllIllIIlIIIllIllII = MathHelper.abs(llllllllllllllllIllIIlIIIllIllll - llllllllllllllllIllIIlIIIllIlIlI);
        return llllllllllllllllIllIIlIIIllIllII < llllllllllllllllIllIIlIIIllIllIl;
    }
    
    public synchronized BakedQuad getQuad(final BakedQuad llllllllllllllllIllIIlIIlllIlIll, final int llllllllllllllllIllIIlIIlllIIIll, final boolean llllllllllllllllIllIIlIIlllIIIlI) {
        int llllllllllllllllIllIIlIIlllIlIII = llllllllllllllllIllIIlIIlllIIIll;
        if (llllllllllllllllIllIIlIIlllIIIlI) {
            llllllllllllllllIllIIlIIlllIlIII = (llllllllllllllllIllIIlIIlllIIIll | 0x4);
        }
        if (llllllllllllllllIllIIlIIlllIlIII > 0 && llllllllllllllllIllIIlIIlllIlIII < this.quadMaps.length) {
            Object llllllllllllllllIllIIlIIlllIIlll = this.quadMaps[llllllllllllllllIllIIlIIlllIlIII];
            if (llllllllllllllllIllIIlIIlllIIlll == null) {
                llllllllllllllllIllIIlIIlllIIlll = new IdentityHashMap(1);
                this.quadMaps[llllllllllllllllIllIIlIIlllIlIII] = (Map)llllllllllllllllIllIIlIIlllIIlll;
            }
            BakedQuad llllllllllllllllIllIIlIIlllIIllI = ((Map)llllllllllllllllIllIIlIIlllIIlll).get(llllllllllllllllIllIIlIIlllIlIll);
            if (llllllllllllllllIllIIlIIlllIIllI == null) {
                llllllllllllllllIllIIlIIlllIIllI = this.makeQuad(llllllllllllllllIllIIlIIlllIlIll, llllllllllllllllIllIIlIIlllIIIll, llllllllllllllllIllIIlIIlllIIIlI);
                ((Map)llllllllllllllllIllIIlIIlllIIlll).put(llllllllllllllllIllIIlIIlllIlIll, llllllllllllllllIllIIlIIlllIIllI);
            }
            return llllllllllllllllIllIIlIIlllIIllI;
        }
        return llllllllllllllllIllIIlIIlllIlIll;
    }
    
    public boolean isValid() {
        return this.rotation == 2 || this.rotation == 4 || this.flip;
    }
    
    private boolean isFullSprite(final BakedQuad llllllllllllllllIllIIlIIlIIIIlII) {
        final TextureAtlasSprite llllllllllllllllIllIIlIIlIIlIlII = llllllllllllllllIllIIlIIlIIIIlII.getSprite();
        final float llllllllllllllllIllIIlIIlIIlIIll = llllllllllllllllIllIIlIIlIIlIlII.getMinU();
        final float llllllllllllllllIllIIlIIlIIlIIlI = llllllllllllllllIllIIlIIlIIlIlII.getMaxU();
        final float llllllllllllllllIllIIlIIlIIlIIIl = llllllllllllllllIllIIlIIlIIlIIlI - llllllllllllllllIllIIlIIlIIlIIll;
        final float llllllllllllllllIllIIlIIlIIlIIII = llllllllllllllllIllIIlIIlIIlIIIl / 256.0f;
        final float llllllllllllllllIllIIlIIlIIIllll = llllllllllllllllIllIIlIIlIIlIlII.getMinV();
        final float llllllllllllllllIllIIlIIlIIIlllI = llllllllllllllllIllIIlIIlIIlIlII.getMaxV();
        final float llllllllllllllllIllIIlIIlIIIllIl = llllllllllllllllIllIIlIIlIIIlllI - llllllllllllllllIllIIlIIlIIIllll;
        final float llllllllllllllllIllIIlIIlIIIllII = llllllllllllllllIllIIlIIlIIIllIl / 256.0f;
        final int[] llllllllllllllllIllIIlIIlIIIlIll = llllllllllllllllIllIIlIIlIIIIlII.func_178209_a();
        final int llllllllllllllllIllIIlIIlIIIlIlI = llllllllllllllllIllIIlIIlIIIlIll.length / 4;
        for (int llllllllllllllllIllIIlIIlIIIlIIl = 0; llllllllllllllllIllIIlIIlIIIlIIl < 4; ++llllllllllllllllIllIIlIIlIIIlIIl) {
            final int llllllllllllllllIllIIlIIlIIIlIII = llllllllllllllllIllIIlIIlIIIlIIl * llllllllllllllllIllIIlIIlIIIlIlI;
            final float llllllllllllllllIllIIlIIlIIIIlll = Float.intBitsToFloat(llllllllllllllllIllIIlIIlIIIlIll[llllllllllllllllIllIIlIIlIIIlIII + 4]);
            final float llllllllllllllllIllIIlIIlIIIIllI = Float.intBitsToFloat(llllllllllllllllIllIIlIIlIIIlIll[llllllllllllllllIllIIlIIlIIIlIII + 4 + 1]);
            if (!this.equalsDelta(llllllllllllllllIllIIlIIlIIIIlll, llllllllllllllllIllIIlIIlIIlIIll, llllllllllllllllIllIIlIIlIIlIIII) && !this.equalsDelta(llllllllllllllllIllIIlIIlIIIIlll, llllllllllllllllIllIIlIIlIIlIIlI, llllllllllllllllIllIIlIIlIIlIIII)) {
                return false;
            }
            if (!this.equalsDelta(llllllllllllllllIllIIlIIlIIIIllI, llllllllllllllllIllIIlIIlIIIllll, llllllllllllllllIllIIlIIlIIIllII) && !this.equalsDelta(llllllllllllllllIllIIlIIlIIIIllI, llllllllllllllllIllIIlIIlIIIlllI, llllllllllllllllIllIIlIIlIIIllII)) {
                return false;
            }
        }
        return true;
    }
}
