package net.minecraft.item;

import net.minecraft.block.*;

public class ItemAnvilBlock extends ItemMultiTexture
{
    public ItemAnvilBlock(final Block llllllllllllllIIllllIIllllIlIllI) {
        super(llllllllllllllIIllllIIllllIlIllI, llllllllllllllIIllllIIllllIlIllI, new String[] { "intact", "slightlyDamaged", "veryDamaged" });
    }
    
    static {
        __OBFID = "CL_00001764";
    }
    
    @Override
    public int getMetadata(final int llllllllllllllIIllllIIllllIlIIll) {
        return llllllllllllllIIllllIIllllIlIIll << 2;
    }
}
