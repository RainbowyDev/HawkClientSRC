package net.minecraft.entity.ai;

import net.minecraft.entity.passive.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.item.*;

public class EntityAIBeg extends EntityAIBase
{
    private /* synthetic */ EntityWolf theWolf;
    private /* synthetic */ float minPlayerDistance;
    private /* synthetic */ World worldObject;
    private /* synthetic */ EntityPlayer thePlayer;
    private /* synthetic */ int field_75384_e;
    
    @Override
    public boolean shouldExecute() {
        this.thePlayer = this.worldObject.getClosestPlayerToEntity(this.theWolf, this.minPlayerDistance);
        return this.thePlayer != null && this.hasPlayerGotBoneInHand(this.thePlayer);
    }
    
    @Override
    public void resetTask() {
        this.theWolf.func_70918_i(false);
        this.thePlayer = null;
    }
    
    @Override
    public void updateTask() {
        this.theWolf.getLookHelper().setLookPosition(this.thePlayer.posX, this.thePlayer.posY + this.thePlayer.getEyeHeight(), this.thePlayer.posZ, 10.0f, (float)this.theWolf.getVerticalFaceSpeed());
        --this.field_75384_e;
    }
    
    @Override
    public boolean continueExecuting() {
        return this.thePlayer.isEntityAlive() && this.theWolf.getDistanceSqToEntity(this.thePlayer) <= this.minPlayerDistance * this.minPlayerDistance && (this.field_75384_e > 0 && this.hasPlayerGotBoneInHand(this.thePlayer));
    }
    
    private boolean hasPlayerGotBoneInHand(final EntityPlayer llllllllllllllllllIIIIIIIIlllllI) {
        final ItemStack llllllllllllllllllIIIIIIIlIIIIII = llllllllllllllllllIIIIIIIIlllllI.inventory.getCurrentItem();
        return llllllllllllllllllIIIIIIIlIIIIII != null && ((!this.theWolf.isTamed() && llllllllllllllllllIIIIIIIlIIIIII.getItem() == Items.bone) || this.theWolf.isBreedingItem(llllllllllllllllllIIIIIIIlIIIIII));
    }
    
    @Override
    public void startExecuting() {
        this.theWolf.func_70918_i(true);
        this.field_75384_e = 40 + this.theWolf.getRNG().nextInt(40);
    }
    
    static {
        __OBFID = "CL_00001576";
    }
    
    public EntityAIBeg(final EntityWolf llllllllllllllllllIIIIIIIlIlIllI, final float llllllllllllllllllIIIIIIIlIllIII) {
        this.theWolf = llllllllllllllllllIIIIIIIlIlIllI;
        this.worldObject = llllllllllllllllllIIIIIIIlIlIllI.worldObj;
        this.minPlayerDistance = llllllllllllllllllIIIIIIIlIllIII;
        this.setMutexBits(2);
    }
}
