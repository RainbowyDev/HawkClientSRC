package net.minecraft.item;

public class ItemBook extends Item
{
    @Override
    public int getItemEnchantability() {
        return 1;
    }
    
    @Override
    public boolean isItemTool(final ItemStack lllllllllllllllIIllllllIIlIlIIll) {
        return lllllllllllllllIIllllllIIlIlIIll.stackSize == 1;
    }
    
    static {
        __OBFID = "CL_00001775";
    }
}
