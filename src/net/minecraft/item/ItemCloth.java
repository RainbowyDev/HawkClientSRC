package net.minecraft.item;

import net.minecraft.block.*;

public class ItemCloth extends ItemBlock
{
    public ItemCloth(final Block llllllllllllllIIIlIllllIIlllIlII) {
        super(llllllllllllllIIIlIllllIIlllIlII);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }
    
    @Override
    public int getMetadata(final int llllllllllllllIIIlIllllIIlllIIII) {
        return llllllllllllllIIIlIllllIIlllIIII;
    }
    
    @Override
    public String getUnlocalizedName(final ItemStack llllllllllllllIIIlIllllIIllIllII) {
        return String.valueOf(new StringBuilder(String.valueOf(super.getUnlocalizedName())).append(".").append(EnumDyeColor.func_176764_b(llllllllllllllIIIlIllllIIllIllII.getMetadata()).func_176762_d()));
    }
    
    static {
        __OBFID = "CL_00000075";
    }
}
