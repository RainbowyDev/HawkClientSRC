package net.minecraft.entity.ai;

import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.inventory.*;

public class EntityAITradePlayer extends EntityAIBase
{
    private /* synthetic */ EntityVillager villager;
    
    @Override
    public void startExecuting() {
        this.villager.getNavigator().clearPathEntity();
    }
    
    static {
        __OBFID = "CL_00001617";
    }
    
    @Override
    public void resetTask() {
        this.villager.setCustomer(null);
    }
    
    @Override
    public boolean shouldExecute() {
        if (!this.villager.isEntityAlive()) {
            return false;
        }
        if (this.villager.isInWater()) {
            return false;
        }
        if (!this.villager.onGround) {
            return false;
        }
        if (this.villager.velocityChanged) {
            return false;
        }
        final EntityPlayer lllllllllllllllIIlIIIllllIlIIlII = this.villager.getCustomer();
        return lllllllllllllllIIlIIIllllIlIIlII != null && this.villager.getDistanceSqToEntity(lllllllllllllllIIlIIIllllIlIIlII) <= 16.0 && lllllllllllllllIIlIIIllllIlIIlII.openContainer instanceof Container;
    }
    
    public EntityAITradePlayer(final EntityVillager lllllllllllllllIIlIIIllllIlIlIlI) {
        this.villager = lllllllllllllllIIlIIIllllIlIlIlI;
        this.setMutexBits(5);
    }
}
