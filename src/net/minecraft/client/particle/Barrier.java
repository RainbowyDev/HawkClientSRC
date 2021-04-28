package net.minecraft.client.particle;

import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.item.*;
import net.minecraft.client.*;
import net.minecraft.init.*;

public class Barrier extends EntityFX
{
    @Override
    public int getFXLayer() {
        return 1;
    }
    
    static {
        __OBFID = "CL_00002615";
    }
    
    @Override
    public void func_180434_a(final WorldRenderer llllllllllllllllIlllIIIIIIIlIIII, final Entity llllllllllllllllIlllIIIIIIIIllll, final float llllllllllllllllIllIlllllllllllI, final float llllllllllllllllIllIllllllllllIl, final float llllllllllllllllIlllIIIIIIIIllII, final float llllllllllllllllIllIlllllllllIll, final float llllllllllllllllIllIlllllllllIlI, final float llllllllllllllllIllIlllllllllIIl) {
        final float llllllllllllllllIlllIIIIIIIIlIII = this.particleIcon.getMinU();
        final float llllllllllllllllIlllIIIIIIIIIlll = this.particleIcon.getMaxU();
        final float llllllllllllllllIlllIIIIIIIIIllI = this.particleIcon.getMinV();
        final float llllllllllllllllIlllIIIIIIIIIlIl = this.particleIcon.getMaxV();
        final float llllllllllllllllIlllIIIIIIIIIlII = (float)(this.prevPosX + (this.posX - this.prevPosX) * llllllllllllllllIllIlllllllllllI - Barrier.interpPosX);
        final float llllllllllllllllIlllIIIIIIIIIIll = (float)(this.prevPosY + (this.posY - this.prevPosY) * llllllllllllllllIllIlllllllllllI - Barrier.interpPosY);
        final float llllllllllllllllIlllIIIIIIIIIIlI = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * llllllllllllllllIllIlllllllllllI - Barrier.interpPosZ);
        llllllllllllllllIlllIIIIIIIlIIII.func_178986_b(this.particleRed, this.particleGreen, this.particleBlue);
        final float llllllllllllllllIlllIIIIIIIIIIIl = 0.5f;
        llllllllllllllllIlllIIIIIIIlIIII.addVertexWithUV(llllllllllllllllIlllIIIIIIIIIlII - llllllllllllllllIllIllllllllllIl * llllllllllllllllIlllIIIIIIIIIIIl - llllllllllllllllIllIlllllllllIlI * llllllllllllllllIlllIIIIIIIIIIIl, llllllllllllllllIlllIIIIIIIIIIll - llllllllllllllllIlllIIIIIIIIllII * llllllllllllllllIlllIIIIIIIIIIIl, llllllllllllllllIlllIIIIIIIIIIlI - llllllllllllllllIllIlllllllllIll * llllllllllllllllIlllIIIIIIIIIIIl - llllllllllllllllIllIlllllllllIIl * llllllllllllllllIlllIIIIIIIIIIIl, llllllllllllllllIlllIIIIIIIIIlll, llllllllllllllllIlllIIIIIIIIIlIl);
        llllllllllllllllIlllIIIIIIIlIIII.addVertexWithUV(llllllllllllllllIlllIIIIIIIIIlII - llllllllllllllllIllIllllllllllIl * llllllllllllllllIlllIIIIIIIIIIIl + llllllllllllllllIllIlllllllllIlI * llllllllllllllllIlllIIIIIIIIIIIl, llllllllllllllllIlllIIIIIIIIIIll + llllllllllllllllIlllIIIIIIIIllII * llllllllllllllllIlllIIIIIIIIIIIl, llllllllllllllllIlllIIIIIIIIIIlI - llllllllllllllllIllIlllllllllIll * llllllllllllllllIlllIIIIIIIIIIIl + llllllllllllllllIllIlllllllllIIl * llllllllllllllllIlllIIIIIIIIIIIl, llllllllllllllllIlllIIIIIIIIIlll, llllllllllllllllIlllIIIIIIIIIllI);
        llllllllllllllllIlllIIIIIIIlIIII.addVertexWithUV(llllllllllllllllIlllIIIIIIIIIlII + llllllllllllllllIllIllllllllllIl * llllllllllllllllIlllIIIIIIIIIIIl + llllllllllllllllIllIlllllllllIlI * llllllllllllllllIlllIIIIIIIIIIIl, llllllllllllllllIlllIIIIIIIIIIll + llllllllllllllllIlllIIIIIIIIllII * llllllllllllllllIlllIIIIIIIIIIIl, llllllllllllllllIlllIIIIIIIIIIlI + llllllllllllllllIllIlllllllllIll * llllllllllllllllIlllIIIIIIIIIIIl + llllllllllllllllIllIlllllllllIIl * llllllllllllllllIlllIIIIIIIIIIIl, llllllllllllllllIlllIIIIIIIIlIII, llllllllllllllllIlllIIIIIIIIIllI);
        llllllllllllllllIlllIIIIIIIlIIII.addVertexWithUV(llllllllllllllllIlllIIIIIIIIIlII + llllllllllllllllIllIllllllllllIl * llllllllllllllllIlllIIIIIIIIIIIl - llllllllllllllllIllIlllllllllIlI * llllllllllllllllIlllIIIIIIIIIIIl, llllllllllllllllIlllIIIIIIIIIIll - llllllllllllllllIlllIIIIIIIIllII * llllllllllllllllIlllIIIIIIIIIIIl, llllllllllllllllIlllIIIIIIIIIIlI + llllllllllllllllIllIlllllllllIll * llllllllllllllllIlllIIIIIIIIIIIl - llllllllllllllllIllIlllllllllIIl * llllllllllllllllIlllIIIIIIIIIIIl, llllllllllllllllIlllIIIIIIIIlIII, llllllllllllllllIlllIIIIIIIIIlIl);
    }
    
    protected Barrier(final World llllllllllllllllIlllIIIIIIlIIlll, final double llllllllllllllllIlllIIIIIIlIIllI, final double llllllllllllllllIlllIIIIIIlIIlIl, final double llllllllllllllllIlllIIIIIIlIIlII, final Item llllllllllllllllIlllIIIIIIlIIIll) {
        super(llllllllllllllllIlllIIIIIIlIIlll, llllllllllllllllIlllIIIIIIlIIllI, llllllllllllllllIlllIIIIIIlIIlIl, llllllllllllllllIlllIIIIIIlIIlII, 0.0, 0.0, 0.0);
        this.func_180435_a(Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getParticleIcon(llllllllllllllllIlllIIIIIIlIIIll));
        final float particleRed = 1.0f;
        this.particleBlue = particleRed;
        this.particleGreen = particleRed;
        this.particleRed = particleRed;
        final double motionX = 0.0;
        this.motionZ = motionX;
        this.motionY = motionX;
        this.motionX = motionX;
        this.particleGravity = 0.0f;
        this.particleMaxAge = 80;
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public EntityFX func_178902_a(final int llllllllllllllIIllllIlIIlIIIlllI, final World llllllllllllllIIllllIlIIlIIIIlIl, final double llllllllllllllIIllllIlIIlIIIIlII, final double llllllllllllllIIllllIlIIlIIIlIll, final double llllllllllllllIIllllIlIIlIIIIIlI, final double llllllllllllllIIllllIlIIlIIIlIIl, final double llllllllllllllIIllllIlIIlIIIlIII, final double llllllllllllllIIllllIlIIlIIIIlll, final int... llllllllllllllIIllllIlIIlIIIIllI) {
            return new Barrier(llllllllllllllIIllllIlIIlIIIIlIl, llllllllllllllIIllllIlIIlIIIIlII, llllllllllllllIIllllIlIIlIIIlIll, llllllllllllllIIllllIlIIlIIIIIlI, Item.getItemFromBlock(Blocks.barrier));
        }
        
        static {
            __OBFID = "CL_00002614";
        }
    }
}
