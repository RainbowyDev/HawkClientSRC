package net.minecraft.item;

import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.stats.*;
import net.minecraft.creativetab.*;

public class ItemCarrotOnAStick extends Item
{
    @Override
    public boolean isFull3D() {
        return true;
    }
    
    @Override
    public boolean shouldRotateAroundWhenRendering() {
        return true;
    }
    
    static {
        __OBFID = "CL_00000001";
    }
    
    @Override
    public ItemStack onItemRightClick(final ItemStack llllllllllllllIllllIIIIIlIlIIIlI, final World llllllllllllllIllllIIIIIlIlIIIIl, final EntityPlayer llllllllllllllIllllIIIIIlIIllIll) {
        if (llllllllllllllIllllIIIIIlIIllIll.isRiding() && llllllllllllllIllllIIIIIlIIllIll.ridingEntity instanceof EntityPig) {
            final EntityPig llllllllllllllIllllIIIIIlIIlllll = (EntityPig)llllllllllllllIllllIIIIIlIIllIll.ridingEntity;
            if (llllllllllllllIllllIIIIIlIIlllll.getAIControlledByPlayer().isControlledByPlayer() && llllllllllllllIllllIIIIIlIlIIIlI.getMaxDamage() - llllllllllllllIllllIIIIIlIlIIIlI.getMetadata() >= 7) {
                llllllllllllllIllllIIIIIlIIlllll.getAIControlledByPlayer().boostSpeed();
                llllllllllllllIllllIIIIIlIlIIIlI.damageItem(7, llllllllllllllIllllIIIIIlIIllIll);
                if (llllllllllllllIllllIIIIIlIlIIIlI.stackSize == 0) {
                    final ItemStack llllllllllllllIllllIIIIIlIIllllI = new ItemStack(Items.fishing_rod);
                    llllllllllllllIllllIIIIIlIIllllI.setTagCompound(llllllllllllllIllllIIIIIlIlIIIlI.getTagCompound());
                    return llllllllllllllIllllIIIIIlIIllllI;
                }
            }
        }
        llllllllllllllIllllIIIIIlIIllIll.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
        return llllllllllllllIllllIIIIIlIlIIIlI;
    }
    
    public ItemCarrotOnAStick() {
        this.setCreativeTab(CreativeTabs.tabTransport);
        this.setMaxStackSize(1);
        this.setMaxDamage(25);
    }
}
