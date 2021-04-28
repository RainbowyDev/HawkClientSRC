package net.minecraft.client.particle;

import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;

public class EntityFireworkSparkFX extends EntityFX
{
    private final /* synthetic */ EffectRenderer field_92047_az;
    private /* synthetic */ boolean field_92048_ay;
    private /* synthetic */ boolean hasFadeColour;
    private /* synthetic */ float fadeColourBlue;
    private /* synthetic */ boolean field_92054_ax;
    private /* synthetic */ float fadeColourRed;
    private /* synthetic */ int baseTextureIndex;
    private /* synthetic */ float fadeColourGreen;
    
    @Override
    public boolean canBePushed() {
        return false;
    }
    
    static {
        __OBFID = "CL_00000905";
    }
    
    public void setFadeColour(final int llllllllllllllllIIlIlIllllIIIIII) {
        this.fadeColourRed = ((llllllllllllllllIIlIlIllllIIIIII & 0xFF0000) >> 16) / 255.0f;
        this.fadeColourGreen = ((llllllllllllllllIIlIlIllllIIIIII & 0xFF00) >> 8) / 255.0f;
        this.fadeColourBlue = ((llllllllllllllllIIlIlIllllIIIIII & 0xFF) >> 0) / 255.0f;
        this.hasFadeColour = true;
    }
    
    public void setColour(final int llllllllllllllllIIlIlIllllIIlllI) {
        final float llllllllllllllllIIlIlIllllIIllIl = ((llllllllllllllllIIlIlIllllIIlllI & 0xFF0000) >> 16) / 255.0f;
        final float llllllllllllllllIIlIlIllllIIllII = ((llllllllllllllllIIlIlIllllIIlllI & 0xFF00) >> 8) / 255.0f;
        final float llllllllllllllllIIlIlIllllIIlIll = ((llllllllllllllllIIlIlIllllIIlllI & 0xFF) >> 0) / 255.0f;
        final float llllllllllllllllIIlIlIllllIIlIlI = 1.0f;
        this.setRBGColorF(llllllllllllllllIIlIlIllllIIllIl * llllllllllllllllIIlIlIllllIIlIlI, llllllllllllllllIIlIlIllllIIllII * llllllllllllllllIIlIlIllllIIlIlI, llllllllllllllllIIlIlIllllIIlIll * llllllllllllllllIIlIlIllllIIlIlI);
    }
    
    public EntityFireworkSparkFX(final World llllllllllllllllIIlIlIllllllIIlI, final double llllllllllllllllIIlIlIllllllIIIl, final double llllllllllllllllIIlIlIllllllIIII, final double llllllllllllllllIIlIlIlllllIllll, final double llllllllllllllllIIlIlIlllllIlllI, final double llllllllllllllllIIlIlIlllllIIlII, final double llllllllllllllllIIlIlIlllllIIIll, final EffectRenderer llllllllllllllllIIlIlIlllllIIIlI) {
        super(llllllllllllllllIIlIlIllllllIIlI, llllllllllllllllIIlIlIllllllIIIl, llllllllllllllllIIlIlIllllllIIII, llllllllllllllllIIlIlIlllllIllll);
        this.baseTextureIndex = 160;
        this.motionX = llllllllllllllllIIlIlIlllllIlllI;
        this.motionY = llllllllllllllllIIlIlIlllllIIlII;
        this.motionZ = llllllllllllllllIIlIlIlllllIIIll;
        this.field_92047_az = llllllllllllllllIIlIlIlllllIIIlI;
        this.particleScale *= 0.75f;
        this.particleMaxAge = 48 + this.rand.nextInt(12);
        this.noClip = false;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox() {
        return null;
    }
    
    public void setTrail(final boolean llllllllllllllllIIlIlIllllIllllI) {
        this.field_92054_ax = llllllllllllllllIIlIlIllllIllllI;
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setDead();
        }
        if (this.particleAge > this.particleMaxAge / 2) {
            this.setAlphaF(1.0f - (this.particleAge - (float)(this.particleMaxAge / 2)) / this.particleMaxAge);
            if (this.hasFadeColour) {
                this.particleRed += (this.fadeColourRed - this.particleRed) * 0.2f;
                this.particleGreen += (this.fadeColourGreen - this.particleGreen) * 0.2f;
                this.particleBlue += (this.fadeColourBlue - this.particleBlue) * 0.2f;
            }
        }
        this.setParticleTextureIndex(this.baseTextureIndex + (7 - this.particleAge * 8 / this.particleMaxAge));
        this.motionY -= 0.004;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9100000262260437;
        this.motionY *= 0.9100000262260437;
        this.motionZ *= 0.9100000262260437;
        if (this.onGround) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
        if (this.field_92054_ax && this.particleAge < this.particleMaxAge / 2 && (this.particleAge + this.particleMaxAge) % 2 == 0) {
            final EntityFireworkSparkFX llllllllllllllllIIlIlIlllIIlllIl = new EntityFireworkSparkFX(this.worldObj, this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0, this.field_92047_az);
            llllllllllllllllIIlIlIlllIIlllIl.setAlphaF(0.99f);
            llllllllllllllllIIlIlIlllIIlllIl.setRBGColorF(this.particleRed, this.particleGreen, this.particleBlue);
            llllllllllllllllIIlIlIlllIIlllIl.particleAge = llllllllllllllllIIlIlIlllIIlllIl.particleMaxAge / 2;
            if (this.hasFadeColour) {
                llllllllllllllllIIlIlIlllIIlllIl.hasFadeColour = true;
                llllllllllllllllIIlIlIlllIIlllIl.fadeColourRed = this.fadeColourRed;
                llllllllllllllllIIlIlIlllIIlllIl.fadeColourGreen = this.fadeColourGreen;
                llllllllllllllllIIlIlIlllIIlllIl.fadeColourBlue = this.fadeColourBlue;
            }
            llllllllllllllllIIlIlIlllIIlllIl.field_92048_ay = this.field_92048_ay;
            this.field_92047_az.addEffect(llllllllllllllllIIlIlIlllIIlllIl);
        }
    }
    
    @Override
    public void func_180434_a(final WorldRenderer llllllllllllllllIIlIlIlllIlIlIII, final Entity llllllllllllllllIIlIlIlllIlIIlll, final float llllllllllllllllIIlIlIlllIlIllll, final float llllllllllllllllIIlIlIlllIlIlllI, final float llllllllllllllllIIlIlIlllIlIllIl, final float llllllllllllllllIIlIlIlllIlIIIll, final float llllllllllllllllIIlIlIlllIlIIIlI, final float llllllllllllllllIIlIlIlllIlIlIlI) {
        if (!this.field_92048_ay || this.particleAge < this.particleMaxAge / 3 || (this.particleAge + this.particleMaxAge) / 3 % 2 == 0) {
            super.func_180434_a(llllllllllllllllIIlIlIlllIlIlIII, llllllllllllllllIIlIlIlllIlIIlll, llllllllllllllllIIlIlIlllIlIllll, llllllllllllllllIIlIlIlllIlIlllI, llllllllllllllllIIlIlIlllIlIllIl, llllllllllllllllIIlIlIlllIlIIIll, llllllllllllllllIIlIlIlllIlIIIlI, llllllllllllllllIIlIlIlllIlIlIlI);
        }
    }
    
    @Override
    public int getBrightnessForRender(final float llllllllllllllllIIlIlIlllIIllIIl) {
        return 15728880;
    }
    
    public void setTwinkle(final boolean llllllllllllllllIIlIlIllllIllIII) {
        this.field_92048_ay = llllllllllllllllIIlIlIllllIllIII;
    }
    
    @Override
    public float getBrightness(final float llllllllllllllllIIlIlIlllIIlIlll) {
        return 1.0f;
    }
}
