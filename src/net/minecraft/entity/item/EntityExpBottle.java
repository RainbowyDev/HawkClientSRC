package net.minecraft.entity.item;

import net.minecraft.entity.projectile.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;

public class EntityExpBottle extends EntityThrowable
{
    @Override
    protected float func_70183_g() {
        return -20.0f;
    }
    
    @Override
    protected void onImpact(final MovingObjectPosition lIlIlllIllIl) {
        if (!this.worldObj.isRemote) {
            this.worldObj.playAuxSFX(2002, new BlockPos(this), 0);
            int lIlIlllIllII = 3 + this.worldObj.rand.nextInt(5) + this.worldObj.rand.nextInt(5);
            while (lIlIlllIllII > 0) {
                final int lIlIlllIlIll = EntityXPOrb.getXPSplit(lIlIlllIllII);
                lIlIlllIllII -= lIlIlllIlIll;
                this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, lIlIlllIlIll));
            }
            this.setDead();
        }
    }
    
    public EntityExpBottle(final World lIllIIIIIlIl, final EntityLivingBase lIllIIIIIlll) {
        super(lIllIIIIIlIl, lIllIIIIIlll);
    }
    
    @Override
    protected float func_70182_d() {
        return 0.7f;
    }
    
    public EntityExpBottle(final World lIlIlllllIII, final double lIlIllllIlll, final double lIlIlllllIll, final double lIlIllllIlIl) {
        super(lIlIlllllIII, lIlIllllIlll, lIlIlllllIll, lIlIllllIlIl);
    }
    
    @Override
    protected float getGravityVelocity() {
        return 0.07f;
    }
    
    static {
        __OBFID = "CL_00001726";
    }
    
    public EntityExpBottle(final World lIllIIIIllll) {
        super(lIllIIIIllll);
    }
}
