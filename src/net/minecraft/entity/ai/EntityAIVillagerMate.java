package net.minecraft.entity.ai;

import net.minecraft.entity.passive.*;
import net.minecraft.village.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class EntityAIVillagerMate extends EntityAIBase
{
    private /* synthetic */ int matingTimeout;
    private /* synthetic */ EntityVillager mate;
    private /* synthetic */ EntityVillager villagerObj;
    /* synthetic */ Village villageObj;
    private /* synthetic */ World worldObj;
    
    private void giveBirth() {
        final EntityVillager llllllllllllllllIIIllIIIIIlllIll = this.villagerObj.func_180488_b(this.mate);
        this.mate.setGrowingAge(6000);
        this.villagerObj.setGrowingAge(6000);
        this.mate.func_175549_o(false);
        this.villagerObj.func_175549_o(false);
        llllllllllllllllIIIllIIIIIlllIll.setGrowingAge(-24000);
        llllllllllllllllIIIllIIIIIlllIll.setLocationAndAngles(this.villagerObj.posX, this.villagerObj.posY, this.villagerObj.posZ, 0.0f, 0.0f);
        this.worldObj.spawnEntityInWorld(llllllllllllllllIIIllIIIIIlllIll);
        this.worldObj.setEntityState(llllllllllllllllIIIllIIIIIlllIll, (byte)12);
    }
    
    @Override
    public boolean shouldExecute() {
        if (this.villagerObj.getGrowingAge() != 0) {
            return false;
        }
        if (this.villagerObj.getRNG().nextInt(500) != 0) {
            return false;
        }
        this.villageObj = this.worldObj.getVillageCollection().func_176056_a(new BlockPos(this.villagerObj), 0);
        if (this.villageObj == null) {
            return false;
        }
        if (!this.checkSufficientDoorsPresentForNewVillager() || !this.villagerObj.func_175550_n(true)) {
            return false;
        }
        final Entity llllllllllllllllIIIllIIIIllIIIII = this.worldObj.findNearestEntityWithinAABB(EntityVillager.class, this.villagerObj.getEntityBoundingBox().expand(8.0, 3.0, 8.0), this.villagerObj);
        if (llllllllllllllllIIIllIIIIllIIIII == null) {
            return false;
        }
        this.mate = (EntityVillager)llllllllllllllllIIIllIIIIllIIIII;
        return this.mate.getGrowingAge() == 0 && this.mate.func_175550_n(true);
    }
    
    private boolean checkSufficientDoorsPresentForNewVillager() {
        if (!this.villageObj.isMatingSeason()) {
            return false;
        }
        final int llllllllllllllllIIIllIIIIlIIIlIl = (int)((float)this.villageObj.getNumVillageDoors() * 0.35);
        return this.villageObj.getNumVillagers() < llllllllllllllllIIIllIIIIlIIIlIl;
    }
    
    @Override
    public void startExecuting() {
        this.matingTimeout = 300;
        this.villagerObj.setMating(true);
    }
    
    static {
        __OBFID = "CL_00001594";
    }
    
    public EntityAIVillagerMate(final EntityVillager llllllllllllllllIIIllIIIIlllllIl) {
        this.villagerObj = llllllllllllllllIIIllIIIIlllllIl;
        this.worldObj = llllllllllllllllIIIllIIIIlllllIl.worldObj;
        this.setMutexBits(3);
    }
    
    @Override
    public void updateTask() {
        --this.matingTimeout;
        this.villagerObj.getLookHelper().setLookPositionWithEntity(this.mate, 10.0f, 30.0f);
        if (this.villagerObj.getDistanceSqToEntity(this.mate) > 2.25) {
            this.villagerObj.getNavigator().tryMoveToEntityLiving(this.mate, 0.25);
        }
        else if (this.matingTimeout == 0 && this.mate.isMating()) {
            this.giveBirth();
        }
        if (this.villagerObj.getRNG().nextInt(35) == 0) {
            this.worldObj.setEntityState(this.villagerObj, (byte)12);
        }
    }
    
    @Override
    public boolean continueExecuting() {
        return this.matingTimeout >= 0 && this.checkSufficientDoorsPresentForNewVillager() && this.villagerObj.getGrowingAge() == 0 && this.villagerObj.func_175550_n(false);
    }
    
    @Override
    public void resetTask() {
        this.villageObj = null;
        this.mate = null;
        this.villagerObj.setMating(false);
    }
}
