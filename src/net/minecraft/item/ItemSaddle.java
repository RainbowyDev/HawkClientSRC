package net.minecraft.item;

import net.minecraft.creativetab.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.*;

public class ItemSaddle extends Item
{
    public ItemSaddle() {
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabs.tabTransport);
    }
    
    @Override
    public boolean hitEntity(final ItemStack lllllllllllllllllIlIlIlIIIlIllll, final EntityLivingBase lllllllllllllllllIlIlIlIIIlIlllI, final EntityLivingBase lllllllllllllllllIlIlIlIIIllIIIl) {
        this.itemInteractionForEntity(lllllllllllllllllIlIlIlIIIlIllll, null, lllllllllllllllllIlIlIlIIIlIlllI);
        return true;
    }
    
    @Override
    public boolean itemInteractionForEntity(final ItemStack lllllllllllllllllIlIlIlIIIlllIlI, final EntityPlayer lllllllllllllllllIlIlIlIIIllllIl, final EntityLivingBase lllllllllllllllllIlIlIlIIIlllIIl) {
        if (lllllllllllllllllIlIlIlIIIlllIIl instanceof EntityPig) {
            final EntityPig lllllllllllllllllIlIlIlIIIlllIll = (EntityPig)lllllllllllllllllIlIlIlIIIlllIIl;
            if (!lllllllllllllllllIlIlIlIIIlllIll.getSaddled() && !lllllllllllllllllIlIlIlIIIlllIll.isChild()) {
                lllllllllllllllllIlIlIlIIIlllIll.setSaddled(true);
                lllllllllllllllllIlIlIlIIIlllIll.worldObj.playSoundAtEntity(lllllllllllllllllIlIlIlIIIlllIll, "mob.horse.leather", 0.5f, 1.0f);
                --lllllllllllllllllIlIlIlIIIlllIlI.stackSize;
            }
            return true;
        }
        return false;
    }
    
    static {
        __OBFID = "CL_00000059";
    }
}
