package net.minecraft.client.particle;

import net.minecraft.world.*;
import net.minecraft.item.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;

public class EntityBreakingFX extends EntityFX
{
    static {
        __OBFID = "CL_00000897";
    }
    
    protected EntityBreakingFX(final World llllllllllllllIlllIIIllllIlIllII, final double llllllllllllllIlllIIIllllIllIIlI, final double llllllllllllllIlllIIIllllIlIlIlI, final double llllllllllllllIlllIIIllllIllIIII, final Item llllllllllllllIlllIIIllllIlIlIII, final int llllllllllllllIlllIIIllllIlIIlll) {
        super(llllllllllllllIlllIIIllllIlIllII, llllllllllllllIlllIIIllllIllIIlI, llllllllllllllIlllIIIllllIlIlIlI, llllllllllllllIlllIIIllllIllIIII, 0.0, 0.0, 0.0);
        this.func_180435_a(Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getParticleIcon(llllllllllllllIlllIIIllllIlIlIII, llllllllllllllIlllIIIllllIlIIlll));
        final float particleRed = 1.0f;
        this.particleBlue = particleRed;
        this.particleGreen = particleRed;
        this.particleRed = particleRed;
        this.particleGravity = Blocks.snow.blockParticleGravity;
        this.particleScale /= 2.0f;
    }
    
    protected EntityBreakingFX(final World llllllllllllllIlllIIIlllllIIIlII, final double llllllllllllllIlllIIIlllllIIllIl, final double llllllllllllllIlllIIIlllllIIIIlI, final double llllllllllllllIlllIIIlllllIIlIll, final double llllllllllllllIlllIIIlllllIIlIlI, final double llllllllllllllIlllIIIllllIllllll, final double llllllllllllllIlllIIIlllllIIlIII, final Item llllllllllllllIlllIIIllllIllllIl, final int llllllllllllllIlllIIIllllIllllII) {
        this(llllllllllllllIlllIIIlllllIIIlII, llllllllllllllIlllIIIlllllIIllIl, llllllllllllllIlllIIIlllllIIIIlI, llllllllllllllIlllIIIlllllIIlIll, llllllllllllllIlllIIIllllIllllIl, llllllllllllllIlllIIIllllIllllII);
        this.motionX *= 0.10000000149011612;
        this.motionY *= 0.10000000149011612;
        this.motionZ *= 0.10000000149011612;
        this.motionX += llllllllllllllIlllIIIlllllIIlIlI;
        this.motionY += llllllllllllllIlllIIIllllIllllll;
        this.motionZ += llllllllllllllIlllIIIlllllIIlIII;
    }
    
    @Override
    public void func_180434_a(final WorldRenderer llllllllllllllIlllIIIllllIIlIlII, final Entity llllllllllllllIlllIIIllllIIlIIll, final float llllllllllllllIlllIIIllllIIlIIlI, final float llllllllllllllIlllIIIllllIIlIIIl, final float llllllllllllllIlllIIIllllIIIIIII, final float llllllllllllllIlllIIIllllIIIllll, final float llllllllllllllIlllIIIlllIllllllI, final float llllllllllllllIlllIIIllllIIIllIl) {
        float llllllllllllllIlllIIIllllIIIllII = (this.particleTextureIndexX + this.particleTextureJitterX / 4.0f) / 16.0f;
        float llllllllllllllIlllIIIllllIIIlIll = llllllllllllllIlllIIIllllIIIllII + 0.015609375f;
        float llllllllllllllIlllIIIllllIIIlIlI = (this.particleTextureIndexY + this.particleTextureJitterY / 4.0f) / 16.0f;
        float llllllllllllllIlllIIIllllIIIlIIl = llllllllllllllIlllIIIllllIIIlIlI + 0.015609375f;
        final float llllllllllllllIlllIIIllllIIIlIII = 0.1f * this.particleScale;
        if (this.particleIcon != null) {
            llllllllllllllIlllIIIllllIIIllII = this.particleIcon.getInterpolatedU(this.particleTextureJitterX / 4.0f * 16.0f);
            llllllllllllllIlllIIIllllIIIlIll = this.particleIcon.getInterpolatedU((this.particleTextureJitterX + 1.0f) / 4.0f * 16.0f);
            llllllllllllllIlllIIIllllIIIlIlI = this.particleIcon.getInterpolatedV(this.particleTextureJitterY / 4.0f * 16.0f);
            llllllllllllllIlllIIIllllIIIlIIl = this.particleIcon.getInterpolatedV((this.particleTextureJitterY + 1.0f) / 4.0f * 16.0f);
        }
        final float llllllllllllllIlllIIIllllIIIIlll = (float)(this.prevPosX + (this.posX - this.prevPosX) * llllllllllllllIlllIIIllllIIlIIlI - EntityBreakingFX.interpPosX);
        final float llllllllllllllIlllIIIllllIIIIllI = (float)(this.prevPosY + (this.posY - this.prevPosY) * llllllllllllllIlllIIIllllIIlIIlI - EntityBreakingFX.interpPosY);
        final float llllllllllllllIlllIIIllllIIIIlIl = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * llllllllllllllIlllIIIllllIIlIIlI - EntityBreakingFX.interpPosZ);
        llllllllllllllIlllIIIllllIIlIlII.func_178986_b(this.particleRed, this.particleGreen, this.particleBlue);
        llllllllllllllIlllIIIllllIIlIlII.addVertexWithUV(llllllllllllllIlllIIIllllIIIIlll - llllllllllllllIlllIIIllllIIlIIIl * llllllllllllllIlllIIIllllIIIlIII - llllllllllllllIlllIIIlllIllllllI * llllllllllllllIlllIIIllllIIIlIII, llllllllllllllIlllIIIllllIIIIllI - llllllllllllllIlllIIIllllIIIIIII * llllllllllllllIlllIIIllllIIIlIII, llllllllllllllIlllIIIllllIIIIlIl - llllllllllllllIlllIIIllllIIIllll * llllllllllllllIlllIIIllllIIIlIII - llllllllllllllIlllIIIllllIIIllIl * llllllllllllllIlllIIIllllIIIlIII, llllllllllllllIlllIIIllllIIIllII, llllllllllllllIlllIIIllllIIIlIIl);
        llllllllllllllIlllIIIllllIIlIlII.addVertexWithUV(llllllllllllllIlllIIIllllIIIIlll - llllllllllllllIlllIIIllllIIlIIIl * llllllllllllllIlllIIIllllIIIlIII + llllllllllllllIlllIIIlllIllllllI * llllllllllllllIlllIIIllllIIIlIII, llllllllllllllIlllIIIllllIIIIllI + llllllllllllllIlllIIIllllIIIIIII * llllllllllllllIlllIIIllllIIIlIII, llllllllllllllIlllIIIllllIIIIlIl - llllllllllllllIlllIIIllllIIIllll * llllllllllllllIlllIIIllllIIIlIII + llllllllllllllIlllIIIllllIIIllIl * llllllllllllllIlllIIIllllIIIlIII, llllllllllllllIlllIIIllllIIIllII, llllllllllllllIlllIIIllllIIIlIlI);
        llllllllllllllIlllIIIllllIIlIlII.addVertexWithUV(llllllllllllllIlllIIIllllIIIIlll + llllllllllllllIlllIIIllllIIlIIIl * llllllllllllllIlllIIIllllIIIlIII + llllllllllllllIlllIIIlllIllllllI * llllllllllllllIlllIIIllllIIIlIII, llllllllllllllIlllIIIllllIIIIllI + llllllllllllllIlllIIIllllIIIIIII * llllllllllllllIlllIIIllllIIIlIII, llllllllllllllIlllIIIllllIIIIlIl + llllllllllllllIlllIIIllllIIIllll * llllllllllllllIlllIIIllllIIIlIII + llllllllllllllIlllIIIllllIIIllIl * llllllllllllllIlllIIIllllIIIlIII, llllllllllllllIlllIIIllllIIIlIll, llllllllllllllIlllIIIllllIIIlIlI);
        llllllllllllllIlllIIIllllIIlIlII.addVertexWithUV(llllllllllllllIlllIIIllllIIIIlll + llllllllllllllIlllIIIllllIIlIIIl * llllllllllllllIlllIIIllllIIIlIII - llllllllllllllIlllIIIlllIllllllI * llllllllllllllIlllIIIllllIIIlIII, llllllllllllllIlllIIIllllIIIIllI - llllllllllllllIlllIIIllllIIIIIII * llllllllllllllIlllIIIllllIIIlIII, llllllllllllllIlllIIIllllIIIIlIl + llllllllllllllIlllIIIllllIIIllll * llllllllllllllIlllIIIllllIIIlIII - llllllllllllllIlllIIIllllIIIllIl * llllllllllllllIlllIIIllllIIIlIII, llllllllllllllIlllIIIllllIIIlIll, llllllllllllllIlllIIIllllIIIlIIl);
    }
    
    protected EntityBreakingFX(final World llllllllllllllIlllIIIllllllIIlII, final double llllllllllllllIlllIIIlllllIlllIl, final double llllllllllllllIlllIIIlllllIlllII, final double llllllllllllllIlllIIIllllllIIIIl, final Item llllllllllllllIlllIIIllllllIIIII) {
        this(llllllllllllllIlllIIIllllllIIlII, llllllllllllllIlllIIIlllllIlllIl, llllllllllllllIlllIIIlllllIlllII, llllllllllllllIlllIIIllllllIIIIl, llllllllllllllIlllIIIllllllIIIII, 0);
    }
    
    @Override
    public int getFXLayer() {
        return 1;
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public EntityFX func_178902_a(final int llllllllllllllIlIlIIllIlIlIIIIll, final World llllllllllllllIlIlIIllIlIIlllIII, final double llllllllllllllIlIlIIllIlIlIIIIIl, final double llllllllllllllIlIlIIllIlIIllIllI, final double llllllllllllllIlIlIIllIlIIllIlIl, final double llllllllllllllIlIlIIllIlIIllIlII, final double llllllllllllllIlIlIIllIlIIllllIl, final double llllllllllllllIlIlIIllIlIIllIIlI, final int... llllllllllllllIlIlIIllIlIIlllIll) {
            final int llllllllllllllIlIlIIllIlIIlllIlI = (llllllllllllllIlIlIIllIlIIlllIll.length > 1) ? llllllllllllllIlIlIIllIlIIlllIll[1] : 0;
            return new EntityBreakingFX(llllllllllllllIlIlIIllIlIIlllIII, llllllllllllllIlIlIIllIlIlIIIIIl, llllllllllllllIlIlIIllIlIIllIllI, llllllllllllllIlIlIIllIlIIllIlIl, llllllllllllllIlIlIIllIlIIllIlII, llllllllllllllIlIlIIllIlIIllllIl, llllllllllllllIlIlIIllIlIIllIIlI, Item.getItemById(llllllllllllllIlIlIIllIlIIlllIll[0]), llllllllllllllIlIlIIllIlIIlllIlI);
        }
        
        static {
            __OBFID = "CL_00002613";
        }
    }
    
    public static class SlimeFactory implements IParticleFactory
    {
        static {
            __OBFID = "CL_00002612";
        }
        
        @Override
        public EntityFX func_178902_a(final int llllllllllllllIlIllIlIlllIllIllI, final World llllllllllllllIlIllIlIlllIllIlIl, final double llllllllllllllIlIllIlIlllIllIlII, final double llllllllllllllIlIllIlIlllIlIlIll, final double llllllllllllllIlIllIlIlllIllIIlI, final double llllllllllllllIlIllIlIlllIllIIIl, final double llllllllllllllIlIllIlIlllIllIIII, final double llllllllllllllIlIllIlIlllIlIllll, final int... llllllllllllllIlIllIlIlllIlIlllI) {
            return new EntityBreakingFX(llllllllllllllIlIllIlIlllIllIlIl, llllllllllllllIlIllIlIlllIllIlII, llllllllllllllIlIllIlIlllIlIlIll, llllllllllllllIlIllIlIlllIllIIlI, Items.slime_ball);
        }
    }
    
    public static class SnowballFactory implements IParticleFactory
    {
        @Override
        public EntityFX func_178902_a(final int llllllllllllllIllIllIIllIIIlllll, final World llllllllllllllIllIllIIllIIIlIllI, final double llllllllllllllIllIllIIllIIIlIlIl, final double llllllllllllllIllIllIIllIIIlllII, final double llllllllllllllIllIllIIllIIIllIll, final double llllllllllllllIllIllIIllIIIllIlI, final double llllllllllllllIllIllIIllIIIllIIl, final double llllllllllllllIllIllIIllIIIllIII, final int... llllllllllllllIllIllIIllIIIlIlll) {
            return new EntityBreakingFX(llllllllllllllIllIllIIllIIIlIllI, llllllllllllllIllIllIIllIIIlIlIl, llllllllllllllIllIllIIllIIIlllII, llllllllllllllIllIllIIllIIIllIll, Items.snowball);
        }
        
        static {
            __OBFID = "CL_00002611";
        }
    }
}
