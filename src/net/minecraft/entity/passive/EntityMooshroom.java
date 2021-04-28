package net.minecraft.entity.passive;

import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;

public class EntityMooshroom extends EntityCow
{
    @Override
    public EntityMooshroom createChild(final EntityAgeable lIIIIIIIIll) {
        return new EntityMooshroom(this.worldObj);
    }
    
    @Override
    public boolean interact(final EntityPlayer lIIIIIIlllI) {
        final ItemStack lIIIIIIllIl = lIIIIIIlllI.inventory.getCurrentItem();
        if (lIIIIIIllIl != null && lIIIIIIllIl.getItem() == Items.bowl && this.getGrowingAge() >= 0) {
            if (lIIIIIIllIl.stackSize == 1) {
                lIIIIIIlllI.inventory.setInventorySlotContents(lIIIIIIlllI.inventory.currentItem, new ItemStack(Items.mushroom_stew));
                return true;
            }
            if (lIIIIIIlllI.inventory.addItemStackToInventory(new ItemStack(Items.mushroom_stew)) && !lIIIIIIlllI.capabilities.isCreativeMode) {
                lIIIIIIlllI.inventory.decrStackSize(lIIIIIIlllI.inventory.currentItem, 1);
                return true;
            }
        }
        if (lIIIIIIllIl != null && lIIIIIIllIl.getItem() == Items.shears && this.getGrowingAge() >= 0) {
            this.setDead();
            this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, this.posX, this.posY + this.height / 2.0f, this.posZ, 0.0, 0.0, 0.0, new int[0]);
            if (!this.worldObj.isRemote) {
                final EntityCow lIIIIIIllII = new EntityCow(this.worldObj);
                lIIIIIIllII.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
                lIIIIIIllII.setHealth(this.getHealth());
                lIIIIIIllII.renderYawOffset = this.renderYawOffset;
                if (this.hasCustomName()) {
                    lIIIIIIllII.setCustomNameTag(this.getCustomNameTag());
                }
                this.worldObj.spawnEntityInWorld(lIIIIIIllII);
                for (int lIIIIIIlIll = 0; lIIIIIIlIll < 5; ++lIIIIIIlIll) {
                    this.worldObj.spawnEntityInWorld(new EntityItem(this.worldObj, this.posX, this.posY + this.height, this.posZ, new ItemStack(Blocks.red_mushroom)));
                }
                lIIIIIIllIl.damageItem(1, lIIIIIIlllI);
                this.playSound("mob.sheep.shear", 1.0f, 1.0f);
            }
            return true;
        }
        return super.interact(lIIIIIIlllI);
    }
    
    static {
        __OBFID = "CL_00001645";
    }
    
    public EntityMooshroom(final World lIIIIIlIlIl) {
        super(lIIIIIlIlIl);
        this.setSize(0.9f, 1.3f);
        this.field_175506_bl = Blocks.mycelium;
    }
}
