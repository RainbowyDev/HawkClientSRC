package net.minecraft.client.renderer.texture;

import net.minecraft.client.*;
import net.minecraft.world.*;
import optifine.*;
import shadersmod.client.*;
import net.minecraft.util.*;

public class TextureCompass extends TextureAtlasSprite
{
    public static /* synthetic */ String field_176608_l;
    public /* synthetic */ double currentAngle;
    public /* synthetic */ double angleDelta;
    
    @Override
    public void updateAnimation() {
        final Minecraft lllllllllllllllIllllIIIIlIIllIII = Minecraft.getMinecraft();
        if (lllllllllllllllIllllIIIIlIIllIII.theWorld != null && lllllllllllllllIllllIIIIlIIllIII.thePlayer != null) {
            this.updateCompass(lllllllllllllllIllllIIIIlIIllIII.theWorld, lllllllllllllllIllllIIIIlIIllIII.thePlayer.posX, lllllllllllllllIllllIIIIlIIllIII.thePlayer.posZ, lllllllllllllllIllllIIIIlIIllIII.thePlayer.rotationYaw, false, false);
        }
        else {
            this.updateCompass(null, 0.0, 0.0, 0.0, true, false);
        }
    }
    
    public TextureCompass(final String lllllllllllllllIllllIIIIlIIllllI) {
        super(lllllllllllllllIllllIIIIlIIllllI);
        TextureCompass.field_176608_l = lllllllllllllllIllllIIIIlIIllllI;
    }
    
    static {
        __OBFID = "CL_00001071";
    }
    
    public void updateCompass(final World lllllllllllllllIllllIIIIIlllllII, final double lllllllllllllllIllllIIIIIllllIll, final double lllllllllllllllIllllIIIIlIIIIlll, double lllllllllllllllIllllIIIIIllllIIl, final boolean lllllllllllllllIllllIIIIIllllIII, final boolean lllllllllllllllIllllIIIIlIIIIlII) {
        if (!this.framesTextureData.isEmpty()) {
            double lllllllllllllllIllllIIIIlIIIIIll = 0.0;
            if (lllllllllllllllIllllIIIIIlllllII != null && !lllllllllllllllIllllIIIIIllllIII) {
                final BlockPos lllllllllllllllIllllIIIIlIIIIIlI = lllllllllllllllIllllIIIIIlllllII.getSpawnPoint();
                final double lllllllllllllllIllllIIIIlIIIIIIl = lllllllllllllllIllllIIIIlIIIIIlI.getX() - lllllllllllllllIllllIIIIIllllIll;
                final double lllllllllllllllIllllIIIIlIIIIIII = lllllllllllllllIllllIIIIlIIIIIlI.getZ() - lllllllllllllllIllllIIIIlIIIIlll;
                lllllllllllllllIllllIIIIIllllIIl %= 360.0;
                lllllllllllllllIllllIIIIlIIIIIll = -((lllllllllllllllIllllIIIIIllllIIl - 90.0) * 3.141592653589793 / 180.0 - Math.atan2(lllllllllllllllIllllIIIIlIIIIIII, lllllllllllllllIllllIIIIlIIIIIIl));
                if (!lllllllllllllllIllllIIIIIlllllII.provider.isSurfaceWorld()) {
                    lllllllllllllllIllllIIIIlIIIIIll = Math.random() * 3.141592653589793 * 2.0;
                }
            }
            if (lllllllllllllllIllllIIIIlIIIIlII) {
                this.currentAngle = lllllllllllllllIllllIIIIlIIIIIll;
            }
            else {
                double lllllllllllllllIllllIIIIIlllllll;
                for (lllllllllllllllIllllIIIIIlllllll = lllllllllllllllIllllIIIIlIIIIIll - this.currentAngle; lllllllllllllllIllllIIIIIlllllll < -3.141592653589793; lllllllllllllllIllllIIIIIlllllll += 6.283185307179586) {}
                while (lllllllllllllllIllllIIIIIlllllll >= 3.141592653589793) {
                    lllllllllllllllIllllIIIIIlllllll -= 6.283185307179586;
                }
                lllllllllllllllIllllIIIIIlllllll = MathHelper.clamp_double(lllllllllllllllIllllIIIIIlllllll, -1.0, 1.0);
                this.angleDelta += lllllllllllllllIllllIIIIIlllllll * 0.1;
                this.angleDelta *= 0.8;
                this.currentAngle += this.angleDelta;
            }
            int lllllllllllllllIllllIIIIIllllllI;
            for (lllllllllllllllIllllIIIIIllllllI = (int)((this.currentAngle / 6.283185307179586 + 1.0) * this.framesTextureData.size()) % this.framesTextureData.size(); lllllllllllllllIllllIIIIIllllllI < 0; lllllllllllllllIllllIIIIIllllllI = (lllllllllllllllIllllIIIIIllllllI + this.framesTextureData.size()) % this.framesTextureData.size()) {}
            if (lllllllllllllllIllllIIIIIllllllI != this.frameCounter) {
                this.frameCounter = lllllllllllllllIllllIIIIIllllllI;
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
