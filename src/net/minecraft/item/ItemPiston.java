package net.minecraft.item;

import net.minecraft.block.*;

public class ItemPiston extends ItemBlock
{
    static {
        __OBFID = "CL_00000054";
    }
    
    @Override
    public int getMetadata(final int llllllllllllllIIIIIIIlIlIlIIllII) {
        return 7;
    }
    
    public ItemPiston(final Block llllllllllllllIIIIIIIlIlIlIlIIII) {
        super(llllllllllllllIIIIIIIlIlIlIlIIII);
    }
}
