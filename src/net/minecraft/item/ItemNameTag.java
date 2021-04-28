package net.minecraft.item;

import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.creativetab.*;

public class ItemNameTag extends Item
{
    static {
        __OBFID = "CL_00000052";
    }
    
    @Override
    public boolean itemInteractionForEntity(final ItemStack llllllllllllllIIIlIIIllIlIIlllII, final EntityPlayer llllllllllllllIIIlIIIllIlIlIIIII, final EntityLivingBase llllllllllllllIIIlIIIllIlIIllIlI) {
        if (!llllllllllllllIIIlIIIllIlIIlllII.hasDisplayName()) {
            return false;
        }
        if (llllllllllllllIIIlIIIllIlIIllIlI instanceof EntityLiving) {
            final EntityLiving llllllllllllllIIIlIIIllIlIIllllI = (EntityLiving)llllllllllllllIIIlIIIllIlIIllIlI;
            llllllllllllllIIIlIIIllIlIIllllI.setCustomNameTag(llllllllllllllIIIlIIIllIlIIlllII.getDisplayName());
            llllllllllllllIIIlIIIllIlIIllllI.enablePersistence();
            --llllllllllllllIIIlIIIllIlIIlllII.stackSize;
            return true;
        }
        return super.itemInteractionForEntity(llllllllllllllIIIlIIIllIlIIlllII, llllllllllllllIIIlIIIllIlIlIIIII, llllllllllllllIIIlIIIllIlIIllIlI);
    }
    
    public ItemNameTag() {
        this.setCreativeTab(CreativeTabs.tabTools);
    }
}
