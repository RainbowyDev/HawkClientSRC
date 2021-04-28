package net.minecraft.inventory;

import net.minecraft.item.*;
import net.minecraft.tileentity.*;
import net.minecraft.init.*;

public class SlotFurnaceFuel extends Slot
{
    @Override
    public boolean isItemValid(final ItemStack lIlIIIIlllIIlI) {
        return TileEntityFurnace.isItemFuel(lIlIIIIlllIIlI) || func_178173_c_(lIlIIIIlllIIlI);
    }
    
    public static boolean func_178173_c_(final ItemStack lIlIIIIllIlIII) {
        return lIlIIIIllIlIII != null && lIlIIIIllIlIII.getItem() != null && lIlIIIIllIlIII.getItem() == Items.bucket;
    }
    
    static {
        __OBFID = "CL_00002184";
    }
    
    @Override
    public int func_178170_b(final ItemStack lIlIIIIllIllIl) {
        return func_178173_c_(lIlIIIIllIllIl) ? 1 : super.func_178170_b(lIlIIIIllIllIl);
    }
    
    public SlotFurnaceFuel(final IInventory lIlIIIIllllIII, final int lIlIIIIlllllII, final int lIlIIIIllllIll, final int lIlIIIIlllIlIl) {
        super(lIlIIIIllllIII, lIlIIIIlllllII, lIlIIIIllllIll, lIlIIIIlllIlIl);
    }
}
