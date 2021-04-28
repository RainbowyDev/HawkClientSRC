package net.minecraft.entity.ai;

import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.world.pathfinder.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.block.*;

public class EntityAIControlledByPlayer extends EntityAIBase
{
    private /* synthetic */ float currentSpeed;
    private /* synthetic */ boolean speedBoosted;
    private final /* synthetic */ float maxSpeed;
    private /* synthetic */ int maxSpeedBoostTime;
    private /* synthetic */ int speedBoostTime;
    private final /* synthetic */ EntityLiving thisEntity;
    
    @Override
    public void updateTask() {
        final EntityPlayer llllllllllllllIIlIIlllllIlllIlIl = (EntityPlayer)this.thisEntity.riddenByEntity;
        final EntityCreature llllllllllllllIIlIIlllllIlllIlII = (EntityCreature)this.thisEntity;
        float llllllllllllllIIlIIlllllIlllIIll = MathHelper.wrapAngleTo180_float(llllllllllllllIIlIIlllllIlllIlIl.rotationYaw - this.thisEntity.rotationYaw) * 0.5f;
        if (llllllllllllllIIlIIlllllIlllIIll > 5.0f) {
            llllllllllllllIIlIIlllllIlllIIll = 5.0f;
        }
        if (llllllllllllllIIlIIlllllIlllIIll < -5.0f) {
            llllllllllllllIIlIIlllllIlllIIll = -5.0f;
        }
        this.thisEntity.rotationYaw = MathHelper.wrapAngleTo180_float(this.thisEntity.rotationYaw + llllllllllllllIIlIIlllllIlllIIll);
        if (this.currentSpeed < this.maxSpeed) {
            this.currentSpeed += (this.maxSpeed - this.currentSpeed) * 0.01f;
        }
        if (this.currentSpeed > this.maxSpeed) {
            this.currentSpeed = this.maxSpeed;
        }
        final int llllllllllllllIIlIIlllllIlllIIlI = MathHelper.floor_double(this.thisEntity.posX);
        final int llllllllllllllIIlIIlllllIlllIIIl = MathHelper.floor_double(this.thisEntity.posY);
        final int llllllllllllllIIlIIlllllIlllIIII = MathHelper.floor_double(this.thisEntity.posZ);
        float llllllllllllllIIlIIlllllIllIllll = this.currentSpeed;
        if (this.speedBoosted) {
            if (this.speedBoostTime++ > this.maxSpeedBoostTime) {
                this.speedBoosted = false;
            }
            llllllllllllllIIlIIlllllIllIllll += llllllllllllllIIlIIlllllIllIllll * 1.15f * MathHelper.sin(this.speedBoostTime / (float)this.maxSpeedBoostTime * 3.1415927f);
        }
        float llllllllllllllIIlIIlllllIllIlllI = 0.91f;
        if (this.thisEntity.onGround) {
            llllllllllllllIIlIIlllllIllIlllI = this.thisEntity.worldObj.getBlockState(new BlockPos(MathHelper.floor_float((float)llllllllllllllIIlIIlllllIlllIIlI), MathHelper.floor_float((float)llllllllllllllIIlIIlllllIlllIIIl) - 1, MathHelper.floor_float((float)llllllllllllllIIlIIlllllIlllIIII))).getBlock().slipperiness * 0.91f;
        }
        final float llllllllllllllIIlIIlllllIllIllIl = 0.16277136f / (llllllllllllllIIlIIlllllIllIlllI * llllllllllllllIIlIIlllllIllIlllI * llllllllllllllIIlIIlllllIllIlllI);
        final float llllllllllllllIIlIIlllllIllIllII = MathHelper.sin(llllllllllllllIIlIIlllllIlllIlII.rotationYaw * 3.1415927f / 180.0f);
        final float llllllllllllllIIlIIlllllIllIlIll = MathHelper.cos(llllllllllllllIIlIIlllllIlllIlII.rotationYaw * 3.1415927f / 180.0f);
        final float llllllllllllllIIlIIlllllIllIlIlI = llllllllllllllIIlIIlllllIlllIlII.getAIMoveSpeed() * llllllllllllllIIlIIlllllIllIllIl;
        float llllllllllllllIIlIIlllllIllIlIIl = Math.max(llllllllllllllIIlIIlllllIllIllll, 1.0f);
        llllllllllllllIIlIIlllllIllIlIIl = llllllllllllllIIlIIlllllIllIlIlI / llllllllllllllIIlIIlllllIllIlIIl;
        final float llllllllllllllIIlIIlllllIllIlIII = llllllllllllllIIlIIlllllIllIllll * llllllllllllllIIlIIlllllIllIlIIl;
        float llllllllllllllIIlIIlllllIllIIlll = -(llllllllllllllIIlIIlllllIllIlIII * llllllllllllllIIlIIlllllIllIllII);
        float llllllllllllllIIlIIlllllIllIIllI = llllllllllllllIIlIIlllllIllIlIII * llllllllllllllIIlIIlllllIllIlIll;
        if (MathHelper.abs(llllllllllllllIIlIIlllllIllIIlll) > MathHelper.abs(llllllllllllllIIlIIlllllIllIIllI)) {
            if (llllllllllllllIIlIIlllllIllIIlll < 0.0f) {
                llllllllllllllIIlIIlllllIllIIlll -= this.thisEntity.width / 2.0f;
            }
            if (llllllllllllllIIlIIlllllIllIIlll > 0.0f) {
                llllllllllllllIIlIIlllllIllIIlll += this.thisEntity.width / 2.0f;
            }
            llllllllllllllIIlIIlllllIllIIllI = 0.0f;
        }
        else {
            llllllllllllllIIlIIlllllIllIIlll = 0.0f;
            if (llllllllllllllIIlIIlllllIllIIllI < 0.0f) {
                llllllllllllllIIlIIlllllIllIIllI -= this.thisEntity.width / 2.0f;
            }
            if (llllllllllllllIIlIIlllllIllIIllI > 0.0f) {
                llllllllllllllIIlIIlllllIllIIllI += this.thisEntity.width / 2.0f;
            }
        }
        final int llllllllllllllIIlIIlllllIllIIlIl = MathHelper.floor_double(this.thisEntity.posX + llllllllllllllIIlIIlllllIllIIlll);
        final int llllllllllllllIIlIIlllllIllIIlII = MathHelper.floor_double(this.thisEntity.posZ + llllllllllllllIIlIIlllllIllIIllI);
        final int llllllllllllllIIlIIlllllIllIIIll = MathHelper.floor_float(this.thisEntity.width + 1.0f);
        final int llllllllllllllIIlIIlllllIllIIIlI = MathHelper.floor_float(this.thisEntity.height + llllllllllllllIIlIIlllllIlllIlIl.height + 1.0f);
        final int llllllllllllllIIlIIlllllIllIIIIl = MathHelper.floor_float(this.thisEntity.width + 1.0f);
        if (llllllllllllllIIlIIlllllIlllIIlI != llllllllllllllIIlIIlllllIllIIlIl || llllllllllllllIIlIIlllllIlllIIII != llllllllllllllIIlIIlllllIllIIlII) {
            final Block llllllllllllllIIlIIlllllIllIIIII = this.thisEntity.worldObj.getBlockState(new BlockPos(llllllllllllllIIlIIlllllIlllIIlI, llllllllllllllIIlIIlllllIlllIIIl, llllllllllllllIIlIIlllllIlllIIII)).getBlock();
            final boolean llllllllllllllIIlIIlllllIlIlllll = !this.isStairOrSlab(llllllllllllllIIlIIlllllIllIIIII) && (llllllllllllllIIlIIlllllIllIIIII.getMaterial() != Material.air || !this.isStairOrSlab(this.thisEntity.worldObj.getBlockState(new BlockPos(llllllllllllllIIlIIlllllIlllIIlI, llllllllllllllIIlIIlllllIlllIIIl - 1, llllllllllllllIIlIIlllllIlllIIII)).getBlock()));
            if (llllllllllllllIIlIIlllllIlIlllll && WalkNodeProcessor.func_176170_a(this.thisEntity.worldObj, this.thisEntity, llllllllllllllIIlIIlllllIllIIlIl, llllllllllllllIIlIIlllllIlllIIIl, llllllllllllllIIlIIlllllIllIIlII, llllllllllllllIIlIIlllllIllIIIll, llllllllllllllIIlIIlllllIllIIIlI, llllllllllllllIIlIIlllllIllIIIIl, false, false, true) == 0 && 1 == WalkNodeProcessor.func_176170_a(this.thisEntity.worldObj, this.thisEntity, llllllllllllllIIlIIlllllIlllIIlI, llllllllllllllIIlIIlllllIlllIIIl + 1, llllllllllllllIIlIIlllllIlllIIII, llllllllllllllIIlIIlllllIllIIIll, llllllllllllllIIlIIlllllIllIIIlI, llllllllllllllIIlIIlllllIllIIIIl, false, false, true) && 1 == WalkNodeProcessor.func_176170_a(this.thisEntity.worldObj, this.thisEntity, llllllllllllllIIlIIlllllIllIIlIl, llllllllllllllIIlIIlllllIlllIIIl + 1, llllllllllllllIIlIIlllllIllIIlII, llllllllllllllIIlIIlllllIllIIIll, llllllllllllllIIlIIlllllIllIIIlI, llllllllllllllIIlIIlllllIllIIIIl, false, false, true)) {
                llllllllllllllIIlIIlllllIlllIlII.getJumpHelper().setJumping();
            }
        }
        if (!llllllllllllllIIlIIlllllIlllIlIl.capabilities.isCreativeMode && this.currentSpeed >= this.maxSpeed * 0.5f && this.thisEntity.getRNG().nextFloat() < 0.006f && !this.speedBoosted) {
            final ItemStack llllllllllllllIIlIIlllllIlIllllI = llllllllllllllIIlIIlllllIlllIlIl.getHeldItem();
            if (llllllllllllllIIlIIlllllIlIllllI != null && llllllllllllllIIlIIlllllIlIllllI.getItem() == Items.carrot_on_a_stick) {
                llllllllllllllIIlIIlllllIlIllllI.damageItem(1, llllllllllllllIIlIIlllllIlllIlIl);
                if (llllllllllllllIIlIIlllllIlIllllI.stackSize == 0) {
                    final ItemStack llllllllllllllIIlIIlllllIlIlllIl = new ItemStack(Items.fishing_rod);
                    llllllllllllllIIlIIlllllIlIlllIl.setTagCompound(llllllllllllllIIlIIlllllIlIllllI.getTagCompound());
                    llllllllllllllIIlIIlllllIlllIlIl.inventory.mainInventory[llllllllllllllIIlIIlllllIlllIlIl.inventory.currentItem] = llllllllllllllIIlIIlllllIlIlllIl;
                }
            }
        }
        this.thisEntity.moveEntityWithHeading(0.0f, llllllllllllllIIlIIlllllIllIllll);
    }
    
    @Override
    public boolean shouldExecute() {
        return this.thisEntity.isEntityAlive() && this.thisEntity.riddenByEntity != null && this.thisEntity.riddenByEntity instanceof EntityPlayer && (this.speedBoosted || this.thisEntity.canBeSteered());
    }
    
    public void boostSpeed() {
        this.speedBoosted = true;
        this.speedBoostTime = 0;
        this.maxSpeedBoostTime = this.thisEntity.getRNG().nextInt(841) + 140;
    }
    
    @Override
    public void resetTask() {
        this.speedBoosted = false;
        this.currentSpeed = 0.0f;
    }
    
    public boolean isSpeedBoosted() {
        return this.speedBoosted;
    }
    
    static {
        __OBFID = "CL_00001580";
    }
    
    public EntityAIControlledByPlayer(final EntityLiving llllllllllllllIIlIIllllllIIlllII, final float llllllllllllllIIlIIllllllIIllIII) {
        this.thisEntity = llllllllllllllIIlIIllllllIIlllII;
        this.maxSpeed = llllllllllllllIIlIIllllllIIllIII;
        this.setMutexBits(7);
    }
    
    public boolean isControlledByPlayer() {
        return !this.isSpeedBoosted() && this.currentSpeed > this.maxSpeed * 0.3f;
    }
    
    @Override
    public void startExecuting() {
        this.currentSpeed = 0.0f;
    }
    
    private boolean isStairOrSlab(final Block llllllllllllllIIlIIlllllIlIIIIIl) {
        return llllllllllllllIIlIIlllllIlIIIIIl instanceof BlockStairs || llllllllllllllIIlIIlllllIlIIIIIl instanceof BlockSlab;
    }
}
