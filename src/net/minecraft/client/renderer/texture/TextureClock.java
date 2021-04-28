package net.minecraft.client.renderer.texture;

import net.minecraft.client.*;
import net.minecraft.util.*;
import optifine.*;
import shadersmod.client.*;

public class TextureClock extends TextureAtlasSprite
{
    private /* synthetic */ double field_94240_i;
    private /* synthetic */ double field_94239_h;
    
    static {
        __OBFID = "CL_00001070";
    }
    
    public TextureClock(final String llllllllllllllIIllIIIIIlIIlIllll) {
        super(llllllllllllllIIllIIIIIlIIlIllll);
    }
    
    @Override
    public void updateAnimation() {
        if (!this.framesTextureData.isEmpty()) {
            final Minecraft llllllllllllllIIllIIIIIlIIlIlIII = Minecraft.getMinecraft();
            double llllllllllllllIIllIIIIIlIIlIIlll = 0.0;
            if (llllllllllllllIIllIIIIIlIIlIlIII.theWorld != null && llllllllllllllIIllIIIIIlIIlIlIII.thePlayer != null) {
                final float llllllllllllllIIllIIIIIlIIlIIllI = llllllllllllllIIllIIIIIlIIlIlIII.theWorld.getCelestialAngle(1.0f);
                llllllllllllllIIllIIIIIlIIlIIlll = llllllllllllllIIllIIIIIlIIlIIllI;
                if (!llllllllllllllIIllIIIIIlIIlIlIII.theWorld.provider.isSurfaceWorld()) {
                    llllllllllllllIIllIIIIIlIIlIIlll = Math.random();
                }
            }
            double llllllllllllllIIllIIIIIlIIlIIlIl;
            for (llllllllllllllIIllIIIIIlIIlIIlIl = llllllllllllllIIllIIIIIlIIlIIlll - this.field_94239_h; llllllllllllllIIllIIIIIlIIlIIlIl < -0.5; ++llllllllllllllIIllIIIIIlIIlIIlIl) {}
            while (llllllllllllllIIllIIIIIlIIlIIlIl >= 0.5) {
                --llllllllllllllIIllIIIIIlIIlIIlIl;
            }
            llllllllllllllIIllIIIIIlIIlIIlIl = MathHelper.clamp_double(llllllllllllllIIllIIIIIlIIlIIlIl, -1.0, 1.0);
            this.field_94240_i += llllllllllllllIIllIIIIIlIIlIIlIl * 0.1;
            this.field_94240_i *= 0.8;
            this.field_94239_h += this.field_94240_i;
            int llllllllllllllIIllIIIIIlIIlIIlII;
            for (llllllllllllllIIllIIIIIlIIlIIlII = (int)((this.field_94239_h + 1.0) * this.framesTextureData.size()) % this.framesTextureData.size(); llllllllllllllIIllIIIIIlIIlIIlII < 0; llllllllllllllIIllIIIIIlIIlIIlII = (llllllllllllllIIllIIIIIlIIlIIlII + this.framesTextureData.size()) % this.framesTextureData.size()) {}
            if (llllllllllllllIIllIIIIIlIIlIIlII != this.frameCounter) {
                this.frameCounter = llllllllllllllIIllIIIIIlIIlIIlII;
                if (Config.isShaders()) {
                    ShadersTex.uploadTexSub(this.framesTextureData.get(this.frameCounter), this.width, this.height, this.originX, this.originY, false, false);
                }
                else {
                    TextureUtil.uploadTextureMipmap(this.framesTextureData.get(this.frameCounter), this.width, this.height, this.originX, this.originY, false, false);
                }
            }
        }
    }
}
