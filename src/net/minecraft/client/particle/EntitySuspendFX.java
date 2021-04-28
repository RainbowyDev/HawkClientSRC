package net.minecraft.client.particle;

import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.block.material.*;

public class EntitySuspendFX extends EntityFX
{
    protected EntitySuspendFX(final World llllllllllllllIIlIIIIIIIlIlllIlI, final double llllllllllllllIIlIIIIIIIlIlllIIl, final double llllllllllllllIIlIIIIIIIllIIIIII, final double llllllllllllllIIlIIIIIIIlIllllll, final double llllllllllllllIIlIIIIIIIlIlllllI, final double llllllllllllllIIlIIIIIIIlIllIlIl, final double llllllllllllllIIlIIIIIIIlIllIlII) {
        super(llllllllllllllIIlIIIIIIIlIlllIlI, llllllllllllllIIlIIIIIIIlIlllIIl, llllllllllllllIIlIIIIIIIllIIIIII - 0.125, llllllllllllllIIlIIIIIIIlIllllll, llllllllllllllIIlIIIIIIIlIlllllI, llllllllllllllIIlIIIIIIIlIllIlIl, llllllllllllllIIlIIIIIIIlIllIlII);
        this.particleRed = 0.4f;
        this.particleGreen = 0.4f;
        this.particleBlue = 0.7f;
        this.setParticleTextureIndex(0);
        this.setSize(0.01f, 0.01f);
        this.particleScale *= this.rand.nextFloat() * 0.6f + 0.2f;
        this.motionX = llllllllllllllIIlIIIIIIIlIlllllI * 0.0;
        this.motionY = llllllllllllllIIlIIIIIIIlIllIlIl * 0.0;
        this.motionZ = llllllllllllllIIlIIIIIIIlIllIlII * 0.0;
        this.particleMaxAge = (int)(16.0 / (Math.random() * 0.8 + 0.2));
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        if (this.worldObj.getBlockState(new BlockPos(this)).getBlock().getMaterial() != Material.water) {
            this.setDead();
        }
        if (this.particleMaxAge-- <= 0) {
            this.setDead();
        }
    }
    
    static {
        __OBFID = "CL_00000928";
    }
    
    public static class Factory implements IParticleFactory
    {
        static {
            __OBFID = "CL_00002579";
        }
        
        @Override
        public EntityFX func_178902_a(final int llllllllllllllIllllIIIllIIIllIIl, final World llllllllllllllIllllIIIllIIIllIII, final double llllllllllllllIllllIIIllIIIIllll, final double llllllllllllllIllllIIIllIIIIlllI, final double llllllllllllllIllllIIIllIIIIllIl, final double llllllllllllllIllllIIIllIIIIllII, final double llllllllllllllIllllIIIllIIIlIIll, final double llllllllllllllIllllIIIllIIIIlIlI, final int... llllllllllllllIllllIIIllIIIlIIIl) {
            return new EntitySuspendFX(llllllllllllllIllllIIIllIIIllIII, llllllllllllllIllllIIIllIIIIllll, llllllllllllllIllllIIIllIIIIlllI, llllllllllllllIllllIIIllIIIIllIl, llllllllllllllIllllIIIllIIIIllII, llllllllllllllIllllIIIllIIIlIIll, llllllllllllllIllllIIIllIIIIlIlI);
        }
    }
}
