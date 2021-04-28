package net.minecraft.client.particle;

import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.block.material.*;

public class EntityBubbleFX extends EntityFX
{
    protected EntityBubbleFX(final World lllllllllllllllIIIIlIIIIIIllllIl, final double lllllllllllllllIIIIlIIIIIIllllII, final double lllllllllllllllIIIIlIIIIIlIIIIll, final double lllllllllllllllIIIIlIIIIIlIIIIlI, final double lllllllllllllllIIIIlIIIIIIlllIIl, final double lllllllllllllllIIIIlIIIIIIllIlll, final double lllllllllllllllIIIIlIIIIIIllIllI) {
        super(lllllllllllllllIIIIlIIIIIIllllIl, lllllllllllllllIIIIlIIIIIIllllII, lllllllllllllllIIIIlIIIIIlIIIIll, lllllllllllllllIIIIlIIIIIlIIIIlI, lllllllllllllllIIIIlIIIIIIlllIIl, lllllllllllllllIIIIlIIIIIIllIlll, lllllllllllllllIIIIlIIIIIIllIllI);
        this.particleRed = 1.0f;
        this.particleGreen = 1.0f;
        this.particleBlue = 1.0f;
        this.setParticleTextureIndex(32);
        this.setSize(0.02f, 0.02f);
        this.particleScale *= this.rand.nextFloat() * 0.6f + 0.2f;
        this.motionX = lllllllllllllllIIIIlIIIIIIlllIIl * 0.20000000298023224 + (Math.random() * 2.0 - 1.0) * 0.019999999552965164;
        this.motionY = lllllllllllllllIIIIlIIIIIIllIlll * 0.20000000298023224 + (Math.random() * 2.0 - 1.0) * 0.019999999552965164;
        this.motionZ = lllllllllllllllIIIIlIIIIIIllIllI * 0.20000000298023224 + (Math.random() * 2.0 - 1.0) * 0.019999999552965164;
        this.particleMaxAge = (int)(8.0 / (Math.random() * 0.8 + 0.2));
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.motionY += 0.002;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.8500000238418579;
        this.motionY *= 0.8500000238418579;
        this.motionZ *= 0.8500000238418579;
        if (this.worldObj.getBlockState(new BlockPos(this)).getBlock().getMaterial() != Material.water) {
            this.setDead();
        }
        if (this.particleMaxAge-- <= 0) {
            this.setDead();
        }
    }
    
    static {
        __OBFID = "CL_00000898";
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public EntityFX func_178902_a(final int lllllllllllllllIlIIlIIlIlIIlIlIl, final World lllllllllllllllIlIIlIIlIlIIIllII, final double lllllllllllllllIlIIlIIlIlIIlIIll, final double lllllllllllllllIlIIlIIlIlIIIlIlI, final double lllllllllllllllIlIIlIIlIlIIIlIIl, final double lllllllllllllllIlIIlIIlIlIIlIIII, final double lllllllllllllllIlIIlIIlIlIIIllll, final double lllllllllllllllIlIIlIIlIlIIIIllI, final int... lllllllllllllllIlIIlIIlIlIIIllIl) {
            return new EntityBubbleFX(lllllllllllllllIlIIlIIlIlIIIllII, lllllllllllllllIlIIlIIlIlIIlIIll, lllllllllllllllIlIIlIIlIlIIIlIlI, lllllllllllllllIlIIlIIlIlIIIlIIl, lllllllllllllllIlIIlIIlIlIIlIIII, lllllllllllllllIlIIlIIlIlIIIllll, lllllllllllllllIlIIlIIlIlIIIIllI);
        }
        
        static {
            __OBFID = "CL_00002610";
        }
    }
}
