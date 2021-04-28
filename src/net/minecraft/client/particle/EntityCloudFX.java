package net.minecraft.client.particle;

import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;

public class EntityCloudFX extends EntityFX
{
    /* synthetic */ float field_70569_a;
    
    @Override
    public void func_180434_a(final WorldRenderer llllllllllllllIIlllIlIllIIIllIIl, final Entity llllllllllllllIIlllIlIllIIIIlllI, final float llllllllllllllIIlllIlIllIIIIllIl, final float llllllllllllllIIlllIlIllIIIIllII, final float llllllllllllllIIlllIlIllIIIIlIll, final float llllllllllllllIIlllIlIllIIIIlIlI, final float llllllllllllllIIlllIlIllIIIlIIll, final float llllllllllllllIIlllIlIllIIIIlIII) {
        float llllllllllllllIIlllIlIllIIIlIIIl = (this.particleAge + llllllllllllllIIlllIlIllIIIIllIl) / this.particleMaxAge * 32.0f;
        llllllllllllllIIlllIlIllIIIlIIIl = MathHelper.clamp_float(llllllllllllllIIlllIlIllIIIlIIIl, 0.0f, 1.0f);
        this.particleScale = this.field_70569_a * llllllllllllllIIlllIlIllIIIlIIIl;
        super.func_180434_a(llllllllllllllIIlllIlIllIIIllIIl, llllllllllllllIIlllIlIllIIIIlllI, llllllllllllllIIlllIlIllIIIIllIl, llllllllllllllIIlllIlIllIIIIllII, llllllllllllllIIlllIlIllIIIIlIll, llllllllllllllIIlllIlIllIIIIlIlI, llllllllllllllIIlllIlIllIIIlIIll, llllllllllllllIIlllIlIllIIIIlIII);
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setDead();
        }
        this.setParticleTextureIndex(7 - this.particleAge * 8 / this.particleMaxAge);
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9599999785423279;
        this.motionY *= 0.9599999785423279;
        this.motionZ *= 0.9599999785423279;
        final EntityPlayer llllllllllllllIIlllIlIllIIIIIIll = this.worldObj.getClosestPlayerToEntity(this, 2.0);
        if (llllllllllllllIIlllIlIllIIIIIIll != null && this.posY > llllllllllllllIIlllIlIllIIIIIIll.getEntityBoundingBox().minY) {
            this.posY += (llllllllllllllIIlllIlIllIIIIIIll.getEntityBoundingBox().minY - this.posY) * 0.2;
            this.motionY += (llllllllllllllIIlllIlIllIIIIIIll.motionY - this.motionY) * 0.2;
            this.setPosition(this.posX, this.posY, this.posZ);
        }
        if (this.onGround) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
    }
    
    static {
        __OBFID = "CL_00000920";
    }
    
    protected EntityCloudFX(final World llllllllllllllIIlllIlIllIIlIllII, final double llllllllllllllIIlllIlIllIIlIlIll, final double llllllllllllllIIlllIlIllIIllIIll, final double llllllllllllllIIlllIlIllIIlIlIIl, final double llllllllllllllIIlllIlIllIIllIIIl, final double llllllllllllllIIlllIlIllIIllIIII, final double llllllllllllllIIlllIlIllIIlIllll) {
        super(llllllllllllllIIlllIlIllIIlIllII, llllllllllllllIIlllIlIllIIlIlIll, llllllllllllllIIlllIlIllIIllIIll, llllllllllllllIIlllIlIllIIlIlIIl, 0.0, 0.0, 0.0);
        final float llllllllllllllIIlllIlIllIIlIlllI = 2.5f;
        this.motionX *= 0.10000000149011612;
        this.motionY *= 0.10000000149011612;
        this.motionZ *= 0.10000000149011612;
        this.motionX += llllllllllllllIIlllIlIllIIllIIIl;
        this.motionY += llllllllllllllIIlllIlIllIIllIIII;
        this.motionZ += llllllllllllllIIlllIlIllIIlIllll;
        final float particleRed = 1.0f - (float)(Math.random() * 0.30000001192092896);
        this.particleBlue = particleRed;
        this.particleGreen = particleRed;
        this.particleRed = particleRed;
        this.particleScale *= 0.75f;
        this.particleScale *= llllllllllllllIIlllIlIllIIlIlllI;
        this.field_70569_a = this.particleScale;
        this.particleMaxAge = (int)(8.0 / (Math.random() * 0.8 + 0.3));
        this.particleMaxAge *= (int)llllllllllllllIIlllIlIllIIlIlllI;
        this.noClip = false;
    }
    
    public static class Factory implements IParticleFactory
    {
        static {
            __OBFID = "CL_00002591";
        }
        
        @Override
        public EntityFX func_178902_a(final int llllllllllllllllIIlIllIlIIlIIIlI, final World llllllllllllllllIIlIllIlIIIllIII, final double llllllllllllllllIIlIllIlIIlIIIII, final double llllllllllllllllIIlIllIlIIIlIlII, final double llllllllllllllllIIlIllIlIIIlIIlI, final double llllllllllllllllIIlIllIlIIIlIIII, final double llllllllllllllllIIlIllIlIIIIlllI, final double llllllllllllllllIIlIllIlIIIIlIlI, final int... llllllllllllllllIIlIllIlIIIllIIl) {
            return new EntityCloudFX(llllllllllllllllIIlIllIlIIIllIII, llllllllllllllllIIlIllIlIIlIIIII, llllllllllllllllIIlIllIlIIIlIlII, llllllllllllllllIIlIllIlIIIlIIlI, llllllllllllllllIIlIllIlIIIlIIII, llllllllllllllllIIlIllIlIIIIlllI, llllllllllllllllIIlIllIlIIIIlIlI);
        }
    }
}
