package net.minecraft.entity.item;

import net.minecraft.entity.projectile.*;
import net.minecraft.util.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;

public class EntityEnderPearl extends EntityThrowable
{
    @Override
    protected void onImpact(final MovingObjectPosition lllllllllllllllIlllIIlIlIIllIIII) {
        final EntityLivingBase lllllllllllllllIlllIIlIlIIllIlIl = this.getThrower();
        if (lllllllllllllllIlllIIlIlIIllIIII.entityHit != null) {
            lllllllllllllllIlllIIlIlIIllIIII.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, lllllllllllllllIlllIIlIlIIllIlIl), 0.0f);
        }
        for (int lllllllllllllllIlllIIlIlIIllIlII = 0; lllllllllllllllIlllIIlIlIIllIlII < 32; ++lllllllllllllllIlllIIlIlIIllIlII) {
            this.worldObj.spawnParticle(EnumParticleTypes.PORTAL, this.posX, this.posY + this.rand.nextDouble() * 2.0, this.posZ, this.rand.nextGaussian(), 0.0, this.rand.nextGaussian(), new int[0]);
        }
        if (!this.worldObj.isRemote) {
            if (lllllllllllllllIlllIIlIlIIllIlIl instanceof EntityPlayerMP) {
                final EntityPlayerMP lllllllllllllllIlllIIlIlIIllIIll = (EntityPlayerMP)lllllllllllllllIlllIIlIlIIllIlIl;
                if (lllllllllllllllIlllIIlIlIIllIIll.playerNetServerHandler.getNetworkManager().isChannelOpen() && lllllllllllllllIlllIIlIlIIllIIll.worldObj == this.worldObj && !lllllllllllllllIlllIIlIlIIllIIll.isPlayerSleeping()) {
                    if (this.rand.nextFloat() < 0.05f && this.worldObj.getGameRules().getGameRuleBooleanValue("doMobSpawning")) {
                        final EntityEndermite lllllllllllllllIlllIIlIlIIllIIlI = new EntityEndermite(this.worldObj);
                        lllllllllllllllIlllIIlIlIIllIIlI.setSpawnedByPlayer(true);
                        lllllllllllllllIlllIIlIlIIllIIlI.setLocationAndAngles(lllllllllllllllIlllIIlIlIIllIlIl.posX, lllllllllllllllIlllIIlIlIIllIlIl.posY, lllllllllllllllIlllIIlIlIIllIlIl.posZ, lllllllllllllllIlllIIlIlIIllIlIl.rotationYaw, lllllllllllllllIlllIIlIlIIllIlIl.rotationPitch);
                        this.worldObj.spawnEntityInWorld(lllllllllllllllIlllIIlIlIIllIIlI);
                    }
                    if (lllllllllllllllIlllIIlIlIIllIlIl.isRiding()) {
                        lllllllllllllllIlllIIlIlIIllIlIl.mountEntity(null);
                    }
                    lllllllllllllllIlllIIlIlIIllIlIl.setPositionAndUpdate(this.posX, this.posY, this.posZ);
                    lllllllllllllllIlllIIlIlIIllIlIl.fallDistance = 0.0f;
                    lllllllllllllllIlllIIlIlIIllIlIl.attackEntityFrom(DamageSource.fall, 5.0f);
                }
            }
            this.setDead();
        }
    }
    
    static {
        __OBFID = "CL_00001725";
    }
    
    public EntityEnderPearl(final World lllllllllllllllIlllIIlIlIlIIIlIl, final double lllllllllllllllIlllIIlIlIlIIIlII, final double lllllllllllllllIlllIIlIlIIlllllI, final double lllllllllllllllIlllIIlIlIIllllIl) {
        super(lllllllllllllllIlllIIlIlIlIIIlIl, lllllllllllllllIlllIIlIlIlIIIlII, lllllllllllllllIlllIIlIlIIlllllI, lllllllllllllllIlllIIlIlIIllllIl);
    }
    
    public EntityEnderPearl(final World lllllllllllllllIlllIIlIlIlIIllIl, final EntityLivingBase lllllllllllllllIlllIIlIlIlIIllll) {
        super(lllllllllllllllIlllIIlIlIlIIllIl, lllllllllllllllIlllIIlIlIlIIllll);
    }
    
    @Override
    public void onUpdate() {
        final EntityLivingBase lllllllllllllllIlllIIlIlIIlIlIIl = this.getThrower();
        if (lllllllllllllllIlllIIlIlIIlIlIIl != null && lllllllllllllllIlllIIlIlIIlIlIIl instanceof EntityPlayer && !lllllllllllllllIlllIIlIlIIlIlIIl.isEntityAlive()) {
            this.setDead();
        }
        else {
            super.onUpdate();
        }
    }
}
