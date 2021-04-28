package net.minecraft.item;

import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;

public class ItemSoup extends ItemFood
{
    @Override
    public ItemStack onItemUseFinish(final ItemStack llllllllllllllIllllIllIlIlllIIll, final World llllllllllllllIllllIllIlIlllIIlI, final EntityPlayer llllllllllllllIllllIllIlIlllIIIl) {
        super.onItemUseFinish(llllllllllllllIllllIllIlIlllIIll, llllllllllllllIllllIllIlIlllIIlI, llllllllllllllIllllIllIlIlllIIIl);
        return new ItemStack(Items.bowl);
    }
    
    public ItemSoup(final int llllllllllllllIllllIllIlIlllllIl) {
        super(llllllllllllllIllllIllIlIlllllIl, false);
        this.setMaxStackSize(1);
    }
    
    static {
        __OBFID = "CL_00001778";
    }
}
