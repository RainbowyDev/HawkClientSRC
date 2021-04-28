package net.minecraft.entity.passive;

import net.minecraft.init.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.pathfinding.*;
import net.minecraft.entity.ai.*;
import net.minecraft.util.*;
import net.minecraft.block.*;
import net.minecraft.entity.*;

public class EntityCow extends EntityAnimal
{
    @Override
    protected String getHurtSound() {
        return "mob.cow.hurt";
    }
    
    @Override
    public float getEyeHeight() {
        return this.height;
    }
    
    @Override
    protected float getSoundVolume() {
        return 0.4f;
    }
    
    @Override
    protected void dropFewItems(final boolean lllllllllllllllIllIllIlllIlIllII, final int lllllllllllllllIllIllIlllIlIlIll) {
        for (int lllllllllllllllIllIllIlllIlIlIlI = this.rand.nextInt(3) + this.rand.nextInt(1 + lllllllllllllllIllIllIlllIlIlIll), lllllllllllllllIllIllIlllIlIlIIl = 0; lllllllllllllllIllIllIlllIlIlIIl < lllllllllllllllIllIllIlllIlIlIlI; ++lllllllllllllllIllIllIlllIlIlIIl) {
            this.dropItem(Items.leather, 1);
        }
        for (int lllllllllllllllIllIllIlllIlIlIlI = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + lllllllllllllllIllIllIlllIlIlIll), lllllllllllllllIllIllIlllIlIlIIl = 0; lllllllllllllllIllIllIlllIlIlIIl < lllllllllllllllIllIllIlllIlIlIlI; ++lllllllllllllllIllIllIlllIlIlIIl) {
            if (this.isBurning()) {
                this.dropItem(Items.cooked_beef, 1);
            }
            else {
                this.dropItem(Items.beef, 1);
            }
        }
    }
    
    @Override
    public boolean interact(final EntityPlayer lllllllllllllllIllIllIlllIlIIIII) {
        final ItemStack lllllllllllllllIllIllIlllIIlllll = lllllllllllllllIllIllIlllIlIIIII.inventory.getCurrentItem();
        if (lllllllllllllllIllIllIlllIIlllll != null && lllllllllllllllIllIllIlllIIlllll.getItem() == Items.bucket && !lllllllllllllllIllIllIlllIlIIIII.capabilities.isCreativeMode) {
            if (lllllllllllllllIllIllIlllIIlllll.stackSize-- == 1) {
                lllllllllllllllIllIllIlllIlIIIII.inventory.setInventorySlotContents(lllllllllllllllIllIllIlllIlIIIII.inventory.currentItem, new ItemStack(Items.milk_bucket));
            }
            else if (!lllllllllllllllIllIllIlllIlIIIII.inventory.addItemStackToInventory(new ItemStack(Items.milk_bucket))) {
                lllllllllllllllIllIllIlllIlIIIII.dropPlayerItemWithRandomChoice(new ItemStack(Items.milk_bucket, 1, 0), false);
            }
            return true;
        }
        return super.interact(lllllllllllllllIllIllIlllIlIIIII);
    }
    
    @Override
    protected String getDeathSound() {
        return "mob.cow.hurt";
    }
    
    @Override
    protected String getLivingSound() {
        return "mob.cow.say";
    }
    
    @Override
    protected Item getDropItem() {
        return Items.leather;
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.20000000298023224);
    }
    
    public EntityCow(final World lllllllllllllllIllIllIllllIIIIIl) {
        super(lllllllllllllllIllIllIllllIIIIIl);
        this.setSize(0.9f, 1.3f);
        ((PathNavigateGround)this.getNavigator()).func_179690_a(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 2.0));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0));
        this.tasks.addTask(3, new EntityAITempt(this, 1.25, Items.wheat, false));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.25));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0f));
        this.tasks.addTask(7, new EntityAILookIdle(this));
    }
    
    @Override
    protected void func_180429_a(final BlockPos lllllllllllllllIllIllIlllIllIllI, final Block lllllllllllllllIllIllIlllIllIlIl) {
        this.playSound("mob.cow.step", 0.15f, 1.0f);
    }
    
    static {
        __OBFID = "CL_00001640";
    }
    
    @Override
    public EntityCow createChild(final EntityAgeable lllllllllllllllIllIllIlllIIllIIl) {
        return new EntityCow(this.worldObj);
    }
}
