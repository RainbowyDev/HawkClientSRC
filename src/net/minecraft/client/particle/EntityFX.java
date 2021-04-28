package net.minecraft.client.particle;

import net.minecraft.entity.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.renderer.*;
import net.minecraft.nbt.*;
import net.minecraft.world.*;
import net.minecraft.client.*;
import net.minecraft.util.*;

public class EntityFX extends Entity
{
    protected /* synthetic */ float particleAlpha;
    public static /* synthetic */ double interpPosX;
    protected /* synthetic */ float particleGreen;
    protected /* synthetic */ float particleRed;
    protected /* synthetic */ TextureAtlasSprite particleIcon;
    protected /* synthetic */ int particleAge;
    public static /* synthetic */ double interpPosZ;
    public static /* synthetic */ double interpPosY;
    protected /* synthetic */ float particleScale;
    protected /* synthetic */ int particleTextureIndexX;
    protected /* synthetic */ int particleMaxAge;
    protected /* synthetic */ float particleTextureJitterX;
    protected /* synthetic */ float particleGravity;
    protected /* synthetic */ float particleBlue;
    protected /* synthetic */ int particleTextureIndexY;
    protected /* synthetic */ float particleTextureJitterY;
    
    public float getRedColorF() {
        return this.particleRed;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder(String.valueOf(this.getClass().getSimpleName())).append(", Pos (").append(this.posX).append(",").append(this.posY).append(",").append(this.posZ).append("), RGBA (").append(this.particleRed).append(",").append(this.particleGreen).append(",").append(this.particleBlue).append(",").append(this.particleAlpha).append("), Age ").append(this.particleAge));
    }
    
    public void func_180434_a(final WorldRenderer llllIIIIlIlIII, final Entity llllIIIIlllIII, final float llllIIIIlIIlll, final float llllIIIIlIIllI, final float llllIIIIllIlIl, final float llllIIIIllIlII, final float llllIIIIllIIll, final float llllIIIIllIIlI) {
        float llllIIIIllIIIl = this.particleTextureIndexX / 16.0f;
        float llllIIIIllIIII = llllIIIIllIIIl + 0.0624375f;
        float llllIIIIlIllll = this.particleTextureIndexY / 16.0f;
        float llllIIIIlIlllI = llllIIIIlIllll + 0.0624375f;
        final float llllIIIIlIllIl = 0.1f * this.particleScale;
        if (this.particleIcon != null) {
            llllIIIIllIIIl = this.particleIcon.getMinU();
            llllIIIIllIIII = this.particleIcon.getMaxU();
            llllIIIIlIllll = this.particleIcon.getMinV();
            llllIIIIlIlllI = this.particleIcon.getMaxV();
        }
        final float llllIIIIlIllII = (float)(this.prevPosX + (this.posX - this.prevPosX) * llllIIIIlIIlll - EntityFX.interpPosX);
        final float llllIIIIlIlIll = (float)(this.prevPosY + (this.posY - this.prevPosY) * llllIIIIlIIlll - EntityFX.interpPosY);
        final float llllIIIIlIlIlI = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * llllIIIIlIIlll - EntityFX.interpPosZ);
        llllIIIIlIlIII.func_178960_a(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha);
        llllIIIIlIlIII.addVertexWithUV(llllIIIIlIllII - llllIIIIlIIllI * llllIIIIlIllIl - llllIIIIllIIll * llllIIIIlIllIl, llllIIIIlIlIll - llllIIIIllIlIl * llllIIIIlIllIl, llllIIIIlIlIlI - llllIIIIllIlII * llllIIIIlIllIl - llllIIIIllIIlI * llllIIIIlIllIl, llllIIIIllIIII, llllIIIIlIlllI);
        llllIIIIlIlIII.addVertexWithUV(llllIIIIlIllII - llllIIIIlIIllI * llllIIIIlIllIl + llllIIIIllIIll * llllIIIIlIllIl, llllIIIIlIlIll + llllIIIIllIlIl * llllIIIIlIllIl, llllIIIIlIlIlI - llllIIIIllIlII * llllIIIIlIllIl + llllIIIIllIIlI * llllIIIIlIllIl, llllIIIIllIIII, llllIIIIlIllll);
        llllIIIIlIlIII.addVertexWithUV(llllIIIIlIllII + llllIIIIlIIllI * llllIIIIlIllIl + llllIIIIllIIll * llllIIIIlIllIl, llllIIIIlIlIll + llllIIIIllIlIl * llllIIIIlIllIl, llllIIIIlIlIlI + llllIIIIllIlII * llllIIIIlIllIl + llllIIIIllIIlI * llllIIIIlIllIl, llllIIIIllIIIl, llllIIIIlIllll);
        llllIIIIlIlIII.addVertexWithUV(llllIIIIlIllII + llllIIIIlIIllI * llllIIIIlIllIl - llllIIIIllIIll * llllIIIIlIllIl, llllIIIIlIlIll - llllIIIIllIlIl * llllIIIIlIllIl, llllIIIIlIlIlI + llllIIIIllIlII * llllIIIIlIllIl - llllIIIIllIIlI * llllIIIIlIllIl, llllIIIIllIIIl, llllIIIIlIlllI);
    }
    
    public int getFXLayer() {
        return 0;
    }
    
    public void setParticleTextureIndex(final int llllIIIIIIIllI) {
        if (this.getFXLayer() != 0) {
            throw new RuntimeException("Invalid call to Particle.setMiscTex");
        }
        this.particleTextureIndexX = llllIIIIIIIllI % 16;
        this.particleTextureIndexY = llllIIIIIIIllI / 16;
    }
    
    public EntityFX multiplyVelocity(final float llllIIIlllIlII) {
        this.motionX *= llllIIIlllIlII;
        this.motionY = (this.motionY - 0.10000000149011612) * llllIIIlllIlII + 0.10000000149011612;
        this.motionZ *= llllIIIlllIlII;
        return this;
    }
    
    public void readEntityFromNBT(final NBTTagCompound llllIIIIIlIlIl) {
    }
    
    public void setRBGColorF(final float llllIIIllIlIII, final float llllIIIllIIIll, final float llllIIIllIIllI) {
        this.particleRed = llllIIIllIlIII;
        this.particleGreen = llllIIIllIIIll;
        this.particleBlue = llllIIIllIIllI;
    }
    
    public EntityFX multipleParticleScaleBy(final float llllIIIlllIIII) {
        this.setSize(0.2f * llllIIIlllIIII, 0.2f * llllIIIlllIIII);
        this.particleScale *= llllIIIlllIIII;
        return this;
    }
    
    protected EntityFX(final World llllIIlIlIIIII, final double llllIIlIIllIlI, final double llllIIlIIllIIl, final double llllIIlIIllIII) {
        super(llllIIlIlIIIII);
        this.particleAlpha = 1.0f;
        this.setSize(0.2f, 0.2f);
        this.setPosition(llllIIlIIllIlI, llllIIlIIllIIl, llllIIlIIllIII);
        this.lastTickPosX = llllIIlIIllIlI;
        this.lastTickPosY = llllIIlIIllIIl;
        this.lastTickPosZ = llllIIlIIllIII;
        final float particleRed = 1.0f;
        this.particleBlue = particleRed;
        this.particleGreen = particleRed;
        this.particleRed = particleRed;
        this.particleTextureJitterX = this.rand.nextFloat() * 3.0f;
        this.particleTextureJitterY = this.rand.nextFloat() * 3.0f;
        this.particleScale = (this.rand.nextFloat() * 0.5f + 0.5f) * 2.0f;
        this.particleMaxAge = (int)(4.0f / (this.rand.nextFloat() * 0.9f + 0.1f));
        this.particleAge = 0;
    }
    
    public void setAlphaF(final float llllIIIlIlllII) {
        if (this.particleAlpha == 1.0f && llllIIIlIlllII < 1.0f) {
            Minecraft.getMinecraft().effectRenderer.func_178928_b(this);
        }
        else if (this.particleAlpha < 1.0f && llllIIIlIlllII == 1.0f) {
            Minecraft.getMinecraft().effectRenderer.func_178931_c(this);
        }
        this.particleAlpha = llllIIIlIlllII;
    }
    
    @Override
    protected void entityInit() {
    }
    
    @Override
    public boolean canAttackWithItem() {
        return false;
    }
    
    public EntityFX(final World llllIIlIIIIIlI, final double llllIIlIIIlIll, final double llllIIlIIIIIII, final double llllIIIlllllll, final double llllIIlIIIlIII, final double llllIIlIIIIlll, final double llllIIlIIIIllI) {
        this(llllIIlIIIIIlI, llllIIlIIIlIll, llllIIlIIIIIII, llllIIIlllllll);
        this.motionX = llllIIlIIIlIII + (Math.random() * 2.0 - 1.0) * 0.4000000059604645;
        this.motionY = llllIIlIIIIlll + (Math.random() * 2.0 - 1.0) * 0.4000000059604645;
        this.motionZ = llllIIlIIIIllI + (Math.random() * 2.0 - 1.0) * 0.4000000059604645;
        final float llllIIlIIIIlIl = (float)(Math.random() + Math.random() + 1.0) * 0.15f;
        final float llllIIlIIIIlII = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
        this.motionX = this.motionX / llllIIlIIIIlII * llllIIlIIIIlIl * 0.4000000059604645;
        this.motionY = this.motionY / llllIIlIIIIlII * llllIIlIIIIlIl * 0.4000000059604645 + 0.10000000149011612;
        this.motionZ = this.motionZ / llllIIlIIIIlII * llllIIlIIIIlIl * 0.4000000059604645;
    }
    
    public void writeEntityToNBT(final NBTTagCompound llllIIIIIlIlll) {
    }
    
    public float getBlueColorF() {
        return this.particleBlue;
    }
    
    static {
        __OBFID = "CL_00000914";
    }
    
    public void nextTextureIndexX() {
        ++this.particleTextureIndexX;
    }
    
    @Override
    protected boolean canTriggerWalking() {
        return false;
    }
    
    public float getGreenColorF() {
        return this.particleGreen;
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setDead();
        }
        this.motionY -= 0.04 * this.particleGravity;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9800000190734863;
        this.motionY *= 0.9800000190734863;
        this.motionZ *= 0.9800000190734863;
        if (this.onGround) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
    }
    
    public void func_180435_a(final TextureAtlasSprite llllIIIIIIllIl) {
        final int llllIIIIIIllll = this.getFXLayer();
        if (llllIIIIIIllll == 1) {
            this.particleIcon = llllIIIIIIllIl;
            return;
        }
        throw new RuntimeException("Invalid call to Particle.setTex, use coordinate methods");
    }
    
    public float func_174838_j() {
        return this.particleAlpha;
    }
}
