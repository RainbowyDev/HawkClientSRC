package net.minecraft.item;

import net.minecraft.block.*;

public class ItemLeaves extends ItemBlock
{
    private final /* synthetic */ BlockLeaves field_150940_b;
    
    static {
        __OBFID = "CL_00000046";
    }
    
    @Override
    public int getMetadata(final int llllllllllllllIllIlIlIllllIIIIIl) {
        return llllllllllllllIllIlIlIllllIIIIIl | 0x4;
    }
    
    @Override
    public int getColorFromItemStack(final ItemStack llllllllllllllIllIlIlIlllIlllIlI, final int llllllllllllllIllIlIlIlllIllllII) {
        return this.field_150940_b.getRenderColor(this.field_150940_b.getStateFromMeta(llllllllllllllIllIlIlIlllIlllIlI.getMetadata()));
    }
    
    public ItemLeaves(final BlockLeaves llllllllllllllIllIlIlIllllIIIlIl) {
        super(llllllllllllllIllIlIlIllllIIIlIl);
        this.field_150940_b = llllllllllllllIllIlIlIllllIIIlIl;
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }
    
    @Override
    public String getUnlocalizedName(final ItemStack llllllllllllllIllIlIlIlllIllIllI) {
        return String.valueOf(new StringBuilder(String.valueOf(super.getUnlocalizedName())).append(".").append(this.field_150940_b.func_176233_b(llllllllllllllIllIlIlIlllIllIllI.getMetadata()).func_176840_c()));
    }
}
