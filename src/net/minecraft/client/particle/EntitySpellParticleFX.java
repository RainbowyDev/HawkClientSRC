package net.minecraft.client.particle;

import java.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntitySpellParticleFX extends EntityFX
{
    private /* synthetic */ int baseSpellTextureIndex;
    private static final /* synthetic */ Random field_174848_a;
    
    @Override
    public void func_180434_a(final WorldRenderer llllllllllllllIIIlllIIlIlIlIIIIl, final Entity llllllllllllllIIIlllIIlIlIlIIIII, final float llllllllllllllIIIlllIIlIlIlIlIIl, final float llllllllllllllIIIlllIIlIlIIllllI, final float llllllllllllllIIIlllIIlIlIIlllIl, final float llllllllllllllIIIlllIIlIlIlIIllI, final float llllllllllllllIIIlllIIlIlIIllIll, final float llllllllllllllIIIlllIIlIlIIllIlI) {
        float llllllllllllllIIIlllIIlIlIlIIIll = (this.particleAge + llllllllllllllIIIlllIIlIlIlIlIIl) / this.particleMaxAge * 32.0f;
        llllllllllllllIIIlllIIlIlIlIIIll = MathHelper.clamp_float(llllllllllllllIIIlllIIlIlIlIIIll, 0.0f, 1.0f);
        super.func_180434_a(llllllllllllllIIIlllIIlIlIlIIIIl, llllllllllllllIIIlllIIlIlIlIIIII, llllllllllllllIIIlllIIlIlIlIlIIl, llllllllllllllIIIlllIIlIlIIllllI, llllllllllllllIIIlllIIlIlIIlllIl, llllllllllllllIIIlllIIlIlIlIIllI, llllllllllllllIIIlllIIlIlIIllIll, llllllllllllllIIIlllIIlIlIIllIlI);
    }
    
    static {
        __OBFID = "CL_00000926";
        field_174848_a = new Random();
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setDead();
        }
        this.setParticleTextureIndex(this.baseSpellTextureIndex + (7 - this.particleAge * 8 / this.particleMaxAge));
        this.motionY += 0.004;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        if (this.posY == this.prevPosY) {
            this.motionX *= 1.1;
            this.motionZ *= 1.1;
        }
        this.motionX *= 0.9599999785423279;
        this.motionY *= 0.9599999785423279;
        this.motionZ *= 0.9599999785423279;
        if (this.onGround) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
    }
    
    public void setBaseSpellTextureIndex(final int llllllllllllllIIIlllIIlIlIIlIIlI) {
        this.baseSpellTextureIndex = llllllllllllllIIIlllIIlIlIIlIIlI;
    }
    
    protected EntitySpellParticleFX(final World llllllllllllllIIIlllIIlIlIllllIl, final double llllllllllllllIIIlllIIlIlIllllII, final double llllllllllllllIIIlllIIlIllIIIIll, final double llllllllllllllIIIlllIIlIlIlllIlI, final double llllllllllllllIIIlllIIlIlIlllIIl, final double llllllllllllllIIIlllIIlIllIIIIII, final double llllllllllllllIIIlllIIlIlIllllll) {
        super(llllllllllllllIIIlllIIlIlIllllIl, llllllllllllllIIIlllIIlIlIllllII, llllllllllllllIIIlllIIlIllIIIIll, llllllllllllllIIIlllIIlIlIlllIlI, 0.5 - EntitySpellParticleFX.field_174848_a.nextDouble(), llllllllllllllIIIlllIIlIllIIIIII, 0.5 - EntitySpellParticleFX.field_174848_a.nextDouble());
        this.baseSpellTextureIndex = 128;
        this.motionY *= 0.20000000298023224;
        if (llllllllllllllIIIlllIIlIlIlllIIl == 0.0 && llllllllllllllIIIlllIIlIlIllllll == 0.0) {
            this.motionX *= 0.10000000149011612;
            this.motionZ *= 0.10000000149011612;
        }
        this.particleScale *= 0.75f;
        this.particleMaxAge = (int)(8.0 / (Math.random() * 0.8 + 0.2));
        this.noClip = false;
    }
    
    public static class WitchFactory implements IParticleFactory
    {
        static {
            __OBFID = "CL_00002581";
        }
        
        @Override
        public EntityFX func_178902_a(final int lllllllllllllllIIIIlIIIllIIIIIlI, final World lllllllllllllllIIIIlIIIlIlllIlIl, final double lllllllllllllllIIIIlIIIllIIIIIII, final double lllllllllllllllIIIIlIIIlIlllllll, final double lllllllllllllllIIIIlIIIlIlllIIlI, final double lllllllllllllllIIIIlIIIlIlllllIl, final double lllllllllllllllIIIIlIIIlIlllIIII, final double lllllllllllllllIIIIlIIIlIllllIll, final int... lllllllllllllllIIIIlIIIlIllllIlI) {
            final EntitySpellParticleFX lllllllllllllllIIIIlIIIlIllllIIl = new EntitySpellParticleFX(lllllllllllllllIIIIlIIIlIlllIlIl, lllllllllllllllIIIIlIIIllIIIIIII, lllllllllllllllIIIIlIIIlIlllllll, lllllllllllllllIIIIlIIIlIlllIIlI, lllllllllllllllIIIIlIIIlIlllllIl, lllllllllllllllIIIIlIIIlIlllIIII, lllllllllllllllIIIIlIIIlIllllIll);
            lllllllllllllllIIIIlIIIlIllllIIl.setBaseSpellTextureIndex(144);
            final float lllllllllllllllIIIIlIIIlIllllIII = lllllllllllllllIIIIlIIIlIlllIlIl.rand.nextFloat() * 0.5f + 0.35f;
            lllllllllllllllIIIIlIIIlIllllIIl.setRBGColorF(1.0f * lllllllllllllllIIIIlIIIlIllllIII, 0.0f * lllllllllllllllIIIIlIIIlIllllIII, 1.0f * lllllllllllllllIIIIlIIIlIllllIII);
            return lllllllllllllllIIIIlIIIlIllllIIl;
        }
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public EntityFX func_178902_a(final int lIlIIIIIIIllIlI, final World lIlIIIIIIIllIIl, final double lIlIIIIIIIllIII, final double lIlIIIIIIIIllll, final double lIlIIIIIIIlIllI, final double lIlIIIIIIIIllIl, final double lIlIIIIIIIlIlII, final double lIlIIIIIIIlIIll, final int... lIlIIIIIIIlIIlI) {
            return new EntitySpellParticleFX(lIlIIIIIIIllIIl, lIlIIIIIIIllIII, lIlIIIIIIIIllll, lIlIIIIIIIlIllI, lIlIIIIIIIIllIl, lIlIIIIIIIlIlII, lIlIIIIIIIlIIll);
        }
        
        static {
            __OBFID = "CL_00002582";
        }
    }
    
    public static class InstantFactory implements IParticleFactory
    {
        @Override
        public EntityFX func_178902_a(final int llllllllllllllIIIlIIlIIllIIIlIIl, final World llllllllllllllIIIlIIlIIllIIIlIII, final double llllllllllllllIIIlIIlIIlIlllllIl, final double llllllllllllllIIIlIIlIIllIIIIllI, final double llllllllllllllIIIlIIlIIlIllllIll, final double llllllllllllllIIIlIIlIIlIllllIlI, final double llllllllllllllIIIlIIlIIlIllllIIl, final double llllllllllllllIIIlIIlIIllIIIIIlI, final int... llllllllllllllIIIlIIlIIllIIIIIIl) {
            final EntitySpellParticleFX llllllllllllllIIIlIIlIIllIIIIIII = new EntitySpellParticleFX(llllllllllllllIIIlIIlIIllIIIlIII, llllllllllllllIIIlIIlIIlIlllllIl, llllllllllllllIIIlIIlIIllIIIIllI, llllllllllllllIIIlIIlIIlIllllIll, llllllllllllllIIIlIIlIIlIllllIlI, llllllllllllllIIIlIIlIIlIllllIIl, llllllllllllllIIIlIIlIIllIIIIIlI);
            llllllllllllllIIIlIIlIIllIIIIIII.setBaseSpellTextureIndex(144);
            return llllllllllllllIIIlIIlIIllIIIIIII;
        }
        
        static {
            __OBFID = "CL_00002584";
        }
    }
    
    public static class MobFactory implements IParticleFactory
    {
        @Override
        public EntityFX func_178902_a(final int llllllllllllllllIIlIIIllIIlllIll, final World llllllllllllllllIIlIIIllIIllIIII, final double llllllllllllllllIIlIIIllIIlllIIl, final double llllllllllllllllIIlIIIllIIlllIII, final double llllllllllllllllIIlIIIllIIllIlll, final double llllllllllllllllIIlIIIllIIlIllII, final double llllllllllllllllIIlIIIllIIlIlIll, final double llllllllllllllllIIlIIIllIIlIlIlI, final int... llllllllllllllllIIlIIIllIIllIIll) {
            final EntitySpellParticleFX llllllllllllllllIIlIIIllIIllIIlI = new EntitySpellParticleFX(llllllllllllllllIIlIIIllIIllIIII, llllllllllllllllIIlIIIllIIlllIIl, llllllllllllllllIIlIIIllIIlllIII, llllllllllllllllIIlIIIllIIllIlll, llllllllllllllllIIlIIIllIIlIllII, llllllllllllllllIIlIIIllIIlIlIll, llllllllllllllllIIlIIIllIIlIlIlI);
            llllllllllllllllIIlIIIllIIllIIlI.setRBGColorF((float)llllllllllllllllIIlIIIllIIlIllII, (float)llllllllllllllllIIlIIIllIIlIlIll, (float)llllllllllllllllIIlIIIllIIlIlIlI);
            return llllllllllllllllIIlIIIllIIllIIlI;
        }
        
        static {
            __OBFID = "CL_00002583";
        }
    }
    
    public static class AmbientMobFactory implements IParticleFactory
    {
        static {
            __OBFID = "CL_00002585";
        }
        
        @Override
        public EntityFX func_178902_a(final int llllllllllllllIIllIIIlIIlIIlIlIl, final World llllllllllllllIIllIIIlIIlIIlIlII, final double llllllllllllllIIllIIIlIIlIIIlIIl, final double llllllllllllllIIllIIIlIIlIIlIIlI, final double llllllllllllllIIllIIIlIIlIIlIIIl, final double llllllllllllllIIllIIIlIIlIIIIllI, final double llllllllllllllIIllIIIlIIlIIIllll, final double llllllllllllllIIllIIIlIIlIIIlllI, final int... llllllllllllllIIllIIIlIIlIIIllIl) {
            final EntitySpellParticleFX llllllllllllllIIllIIIlIIlIIIllII = new EntitySpellParticleFX(llllllllllllllIIllIIIlIIlIIlIlII, llllllllllllllIIllIIIlIIlIIIlIIl, llllllllllllllIIllIIIlIIlIIlIIlI, llllllllllllllIIllIIIlIIlIIlIIIl, llllllllllllllIIllIIIlIIlIIIIllI, llllllllllllllIIllIIIlIIlIIIllll, llllllllllllllIIllIIIlIIlIIIlllI);
            llllllllllllllIIllIIIlIIlIIIllII.setAlphaF(0.15f);
            llllllllllllllIIllIIIlIIlIIIllII.setRBGColorF((float)llllllllllllllIIllIIIlIIlIIIIllI, (float)llllllllllllllIIllIIIlIIlIIIllll, (float)llllllllllllllIIllIIIlIIlIIIlllI);
            return llllllllllllllIIllIIIlIIlIIIllII;
        }
    }
}
