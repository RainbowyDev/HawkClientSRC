package net.minecraft.entity.ai;

import net.minecraft.entity.passive.*;
import net.minecraft.init.*;
import net.minecraft.entity.item.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;

public class EntityAIVillagerInteract extends EntityAIWatchClosest2
{
    private /* synthetic */ int field_179478_e;
    private /* synthetic */ EntityVillager field_179477_f;
    
    @Override
    public void startExecuting() {
        super.startExecuting();
        if (this.field_179477_f.func_175555_cq() && this.closestEntity instanceof EntityVillager && ((EntityVillager)this.closestEntity).func_175557_cr()) {
            this.field_179478_e = 10;
        }
        else {
            this.field_179478_e = 0;
        }
    }
    
    public EntityAIVillagerInteract(final EntityVillager lllllllllllllllIlllIlIlIllIlIllI) {
        super(lllllllllllllllIlllIlIlIllIlIllI, EntityVillager.class, 3.0f, 0.02f);
        this.field_179477_f = lllllllllllllllIlllIlIlIllIlIllI;
    }
    
    static {
        __OBFID = "CL_00002251";
    }
    
    @Override
    public void updateTask() {
        super.updateTask();
        if (this.field_179478_e > 0) {
            --this.field_179478_e;
            if (this.field_179478_e == 0) {
                final InventoryBasic lllllllllllllllIlllIlIlIllIIIlII = this.field_179477_f.func_175551_co();
                for (int lllllllllllllllIlllIlIlIllIIIIll = 0; lllllllllllllllIlllIlIlIllIIIIll < lllllllllllllllIlllIlIlIllIIIlII.getSizeInventory(); ++lllllllllllllllIlllIlIlIllIIIIll) {
                    final ItemStack lllllllllllllllIlllIlIlIllIIIIlI = lllllllllllllllIlllIlIlIllIIIlII.getStackInSlot(lllllllllllllllIlllIlIlIllIIIIll);
                    ItemStack lllllllllllllllIlllIlIlIllIIIIIl = null;
                    if (lllllllllllllllIlllIlIlIllIIIIlI != null) {
                        final Item lllllllllllllllIlllIlIlIllIIIIII = lllllllllllllllIlllIlIlIllIIIIlI.getItem();
                        if ((lllllllllllllllIlllIlIlIllIIIIII == Items.bread || lllllllllllllllIlllIlIlIllIIIIII == Items.potato || lllllllllllllllIlllIlIlIllIIIIII == Items.carrot) && lllllllllllllllIlllIlIlIllIIIIlI.stackSize > 3) {
                            final int lllllllllllllllIlllIlIlIlIllllll = lllllllllllllllIlllIlIlIllIIIIlI.stackSize / 2;
                            final ItemStack itemStack = lllllllllllllllIlllIlIlIllIIIIlI;
                            itemStack.stackSize -= lllllllllllllllIlllIlIlIlIllllll;
                            lllllllllllllllIlllIlIlIllIIIIIl = new ItemStack(lllllllllllllllIlllIlIlIllIIIIII, lllllllllllllllIlllIlIlIlIllllll, lllllllllllllllIlllIlIlIllIIIIlI.getMetadata());
                        }
                        else if (lllllllllllllllIlllIlIlIllIIIIII == Items.wheat && lllllllllllllllIlllIlIlIllIIIIlI.stackSize > 5) {
                            final int lllllllllllllllIlllIlIlIlIlllllI = lllllllllllllllIlllIlIlIllIIIIlI.stackSize / 2 / 3 * 3;
                            final int lllllllllllllllIlllIlIlIlIllllIl = lllllllllllllllIlllIlIlIlIlllllI / 3;
                            final ItemStack itemStack2 = lllllllllllllllIlllIlIlIllIIIIlI;
                            itemStack2.stackSize -= lllllllllllllllIlllIlIlIlIlllllI;
                            lllllllllllllllIlllIlIlIllIIIIIl = new ItemStack(Items.bread, lllllllllllllllIlllIlIlIlIllllIl, 0);
                        }
                        if (lllllllllllllllIlllIlIlIllIIIIlI.stackSize <= 0) {
                            lllllllllllllllIlllIlIlIllIIIlII.setInventorySlotContents(lllllllllllllllIlllIlIlIllIIIIll, null);
                        }
                    }
                    if (lllllllllllllllIlllIlIlIllIIIIIl != null) {
                        final double lllllllllllllllIlllIlIlIlIllllII = this.field_179477_f.posY - 0.30000001192092896 + this.field_179477_f.getEyeHeight();
                        final EntityItem lllllllllllllllIlllIlIlIlIlllIll = new EntityItem(this.field_179477_f.worldObj, this.field_179477_f.posX, lllllllllllllllIlllIlIlIlIllllII, this.field_179477_f.posZ, lllllllllllllllIlllIlIlIllIIIIIl);
                        final float lllllllllllllllIlllIlIlIlIlllIlI = 0.3f;
                        final float lllllllllllllllIlllIlIlIlIlllIIl = this.field_179477_f.rotationYawHead;
                        final float lllllllllllllllIlllIlIlIlIlllIII = this.field_179477_f.rotationPitch;
                        lllllllllllllllIlllIlIlIlIlllIll.motionX = -MathHelper.sin(lllllllllllllllIlllIlIlIlIlllIIl / 180.0f * 3.1415927f) * MathHelper.cos(lllllllllllllllIlllIlIlIlIlllIII / 180.0f * 3.1415927f) * lllllllllllllllIlllIlIlIlIlllIlI;
                        lllllllllllllllIlllIlIlIlIlllIll.motionZ = MathHelper.cos(lllllllllllllllIlllIlIlIlIlllIIl / 180.0f * 3.1415927f) * MathHelper.cos(lllllllllllllllIlllIlIlIlIlllIII / 180.0f * 3.1415927f) * lllllllllllllllIlllIlIlIlIlllIlI;
                        lllllllllllllllIlllIlIlIlIlllIll.motionY = -MathHelper.sin(lllllllllllllllIlllIlIlIlIlllIII / 180.0f * 3.1415927f) * lllllllllllllllIlllIlIlIlIlllIlI + 0.1f;
                        lllllllllllllllIlllIlIlIlIlllIll.setDefaultPickupDelay();
                        this.field_179477_f.worldObj.spawnEntityInWorld(lllllllllllllllIlllIlIlIlIlllIll);
                        break;
                    }
                }
            }
        }
    }
}
