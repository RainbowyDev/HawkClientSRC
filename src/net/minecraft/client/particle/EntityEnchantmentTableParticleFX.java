package net.minecraft.client.particle;

import net.minecraft.world.*;

public class EntityEnchantmentTableParticleFX extends EntityFX
{
    private /* synthetic */ double field_70566_as;
    private /* synthetic */ float field_70565_a;
    private /* synthetic */ double field_70567_ar;
    private /* synthetic */ double field_70568_aq;
    
    @Override
    public int getBrightnessForRender(final float lllllllllllllllIllIIIIlIIlllllll) {
        final int lllllllllllllllIllIIIIlIlIIIIlII = super.getBrightnessForRender(lllllllllllllllIllIIIIlIIlllllll);
        float lllllllllllllllIllIIIIlIlIIIIIll = this.particleAge / (float)this.particleMaxAge;
        lllllllllllllllIllIIIIlIlIIIIIll *= lllllllllllllllIllIIIIlIlIIIIIll;
        lllllllllllllllIllIIIIlIlIIIIIll *= lllllllllllllllIllIIIIlIlIIIIIll;
        final int lllllllllllllllIllIIIIlIlIIIIIlI = lllllllllllllllIllIIIIlIlIIIIlII & 0xFF;
        int lllllllllllllllIllIIIIlIlIIIIIIl = lllllllllllllllIllIIIIlIlIIIIlII >> 16 & 0xFF;
        lllllllllllllllIllIIIIlIlIIIIIIl += (int)(lllllllllllllllIllIIIIlIlIIIIIll * 15.0f * 16.0f);
        if (lllllllllllllllIllIIIIlIlIIIIIIl > 240) {
            lllllllllllllllIllIIIIlIlIIIIIIl = 240;
        }
        return lllllllllllllllIllIIIIlIlIIIIIlI | lllllllllllllllIllIIIIlIlIIIIIIl << 16;
    }
    
    protected EntityEnchantmentTableParticleFX(final World lllllllllllllllIllIIIIlIlIIlIlII, final double lllllllllllllllIllIIIIlIlIIlllII, final double lllllllllllllllIllIIIIlIlIIllIll, final double lllllllllllllllIllIIIIlIlIIllIlI, final double lllllllllllllllIllIIIIlIlIIlIIII, final double lllllllllllllllIllIIIIlIlIIIllll, final double lllllllllllllllIllIIIIlIlIIIlllI) {
        super(lllllllllllllllIllIIIIlIlIIlIlII, lllllllllllllllIllIIIIlIlIIlllII, lllllllllllllllIllIIIIlIlIIllIll, lllllllllllllllIllIIIIlIlIIllIlI, lllllllllllllllIllIIIIlIlIIlIIII, lllllllllllllllIllIIIIlIlIIIllll, lllllllllllllllIllIIIIlIlIIIlllI);
        this.motionX = lllllllllllllllIllIIIIlIlIIlIIII;
        this.motionY = lllllllllllllllIllIIIIlIlIIIllll;
        this.motionZ = lllllllllllllllIllIIIIlIlIIIlllI;
        this.field_70568_aq = lllllllllllllllIllIIIIlIlIIlllII;
        this.field_70567_ar = lllllllllllllllIllIIIIlIlIIllIll;
        this.field_70566_as = lllllllllllllllIllIIIIlIlIIllIlI;
        final double n = lllllllllllllllIllIIIIlIlIIlllII + lllllllllllllllIllIIIIlIlIIlIIII;
        this.prevPosX = n;
        this.posX = n;
        final double n2 = lllllllllllllllIllIIIIlIlIIllIll + lllllllllllllllIllIIIIlIlIIIllll;
        this.prevPosY = n2;
        this.posY = n2;
        final double n3 = lllllllllllllllIllIIIIlIlIIllIlI + lllllllllllllllIllIIIIlIlIIIlllI;
        this.prevPosZ = n3;
        this.posZ = n3;
        final float lllllllllllllllIllIIIIlIlIIlIllI = this.rand.nextFloat() * 0.6f + 0.4f;
        final float n4 = this.rand.nextFloat() * 0.5f + 0.2f;
        this.particleScale = n4;
        this.field_70565_a = n4;
        final float particleRed = 1.0f * lllllllllllllllIllIIIIlIlIIlIllI;
        this.particleBlue = particleRed;
        this.particleGreen = particleRed;
        this.particleRed = particleRed;
        this.particleGreen *= 0.9f;
        this.particleRed *= 0.9f;
        this.particleMaxAge = (int)(Math.random() * 10.0) + 30;
        this.noClip = true;
        this.setParticleTextureIndex((int)(Math.random() * 26.0 + 1.0 + 224.0));
    }
    
    static {
        __OBFID = "CL_00000902";
    }
    
    @Override
    public float getBrightness(final float lllllllllllllllIllIIIIlIIlllIIIl) {
        final float lllllllllllllllIllIIIIlIIlllIlII = super.getBrightness(lllllllllllllllIllIIIIlIIlllIIIl);
        float lllllllllllllllIllIIIIlIIlllIIll = this.particleAge / (float)this.particleMaxAge;
        lllllllllllllllIllIIIIlIIlllIIll *= lllllllllllllllIllIIIIlIIlllIIll;
        lllllllllllllllIllIIIIlIIlllIIll *= lllllllllllllllIllIIIIlIIlllIIll;
        return lllllllllllllllIllIIIIlIIlllIlII * (1.0f - lllllllllllllllIllIIIIlIIlllIIll) + lllllllllllllllIllIIIIlIIlllIIll;
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        float lllllllllllllllIllIIIIlIIllIlIlI = this.particleAge / (float)this.particleMaxAge;
        lllllllllllllllIllIIIIlIIllIlIlI = 1.0f - lllllllllllllllIllIIIIlIIllIlIlI;
        float lllllllllllllllIllIIIIlIIllIlIIl = 1.0f - lllllllllllllllIllIIIIlIIllIlIlI;
        lllllllllllllllIllIIIIlIIllIlIIl *= lllllllllllllllIllIIIIlIIllIlIIl;
        lllllllllllllllIllIIIIlIIllIlIIl *= lllllllllllllllIllIIIIlIIllIlIIl;
        this.posX = this.field_70568_aq + this.motionX * lllllllllllllllIllIIIIlIIllIlIlI;
        this.posY = this.field_70567_ar + this.motionY * lllllllllllllllIllIIIIlIIllIlIlI - lllllllllllllllIllIIIIlIIllIlIIl * 1.2f;
        this.posZ = this.field_70566_as + this.motionZ * lllllllllllllllIllIIIIlIIllIlIlI;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setDead();
        }
    }
    
    public static class EnchantmentTable implements IParticleFactory
    {
        static {
            __OBFID = "CL_00002605";
        }
        
        @Override
        public EntityFX func_178902_a(final int lllllllllllllllIIlIlIIllIlIIIlll, final World lllllllllllllllIIlIlIIllIIlllllI, final double lllllllllllllllIIlIlIIllIIllllIl, final double lllllllllllllllIIlIlIIllIIllllII, final double lllllllllllllllIIlIlIIllIlIIIIll, final double lllllllllllllllIIlIlIIllIlIIIIlI, final double lllllllllllllllIIlIlIIllIIlllIIl, final double lllllllllllllllIIlIlIIllIIlllIII, final int... lllllllllllllllIIlIlIIllIIllllll) {
            return new EntityEnchantmentTableParticleFX(lllllllllllllllIIlIlIIllIIlllllI, lllllllllllllllIIlIlIIllIIllllIl, lllllllllllllllIIlIlIIllIIllllII, lllllllllllllllIIlIlIIllIlIIIIll, lllllllllllllllIIlIlIIllIlIIIIlI, lllllllllllllllIIlIlIIllIIlllIIl, lllllllllllllllIIlIlIIllIIlllIII);
        }
    }
}
