package net.minecraft.entity.passive;

import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;

public abstract class EntityWaterMob extends EntityLiving implements IAnimals
{
    public EntityWaterMob(final World llIIIIllllllIll) {
        super(llIIIIllllllIll);
    }
    
    @Override
    public void onEntityUpdate() {
        int llIIIIllllIllII = this.getAir();
        super.onEntityUpdate();
        if (this.isEntityAlive() && !this.isInWater()) {
            --llIIIIllllIllII;
            this.setAir(llIIIIllllIllII);
            if (this.getAir() == -20) {
                this.setAir(0);
                this.attackEntityFrom(DamageSource.drown, 2.0f);
            }
        }
        else {
            this.setAir(300);
        }
    }
    
    @Override
    protected boolean canDespawn() {
        return true;
    }
    
    @Override
    public boolean isPushedByWater() {
        return false;
    }
    
    @Override
    public int getTalkInterval() {
        return 120;
    }
    
    @Override
    public boolean handleLavaMovement() {
        return this.worldObj.checkNoEntityCollision(this.getEntityBoundingBox(), this);
    }
    
    @Override
    public boolean getCanSpawnHere() {
        return true;
    }
    
    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }
    
    @Override
    protected int getExperiencePoints(final EntityPlayer llIIIIlllllIIIl) {
        return 1 + this.worldObj.rand.nextInt(3);
    }
    
    static {
        __OBFID = "CL_00001653";
    }
}
