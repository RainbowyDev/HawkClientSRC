package net.minecraft.item;

import net.minecraft.block.*;

public class ItemColored extends ItemBlock
{
    private /* synthetic */ String[] field_150945_c;
    private final /* synthetic */ Block field_150944_b;
    
    @Override
    public int getMetadata(final int lIllll) {
        return lIllll;
    }
    
    static {
        __OBFID = "CL_00000003";
    }
    
    public ItemColored(final Block llllIl, final boolean lllIIl) {
        super(llllIl);
        this.field_150944_b = llllIl;
        if (lllIIl) {
            this.setMaxDamage(0);
            this.setHasSubtypes(true);
        }
    }
    
    @Override
    public String getUnlocalizedName(final ItemStack lIIIII) {
        if (this.field_150945_c == null) {
            return super.getUnlocalizedName(lIIIII);
        }
        final int lIIIlI = lIIIII.getMetadata();
        return (lIIIlI >= 0 && lIIIlI < this.field_150945_c.length) ? String.valueOf(new StringBuilder(String.valueOf(super.getUnlocalizedName(lIIIII))).append(".").append(this.field_150945_c[lIIIlI])) : super.getUnlocalizedName(lIIIII);
    }
    
    @Override
    public int getColorFromItemStack(final ItemStack llIlIl, final int llIlII) {
        return this.field_150944_b.getRenderColor(this.field_150944_b.getStateFromMeta(llIlIl.getMetadata()));
    }
    
    public ItemColored func_150943_a(final String[] lIlIII) {
        this.field_150945_c = lIlIII;
        return this;
    }
}
