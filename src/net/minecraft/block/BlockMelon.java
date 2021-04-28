package net.minecraft.block;

import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;

public class BlockMelon extends Block
{
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllllllIlIlIlIlIIIIIll, final Random lllllllllllllllllIlIlIlIlIIIIIlI, final int lllllllllllllllllIlIlIlIlIIIIIIl) {
        return Items.melon;
    }
    
    static {
        __OBFID = "CL_00000267";
    }
    
    @Override
    public int quantityDropped(final Random lllllllllllllllllIlIlIlIIllllIIl) {
        return 3 + lllllllllllllllllIlIlIlIIllllIIl.nextInt(5);
    }
    
    protected BlockMelon() {
        super(Material.gourd);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    @Override
    public int quantityDroppedWithBonus(final int lllllllllllllllllIlIlIlIIllIlllI, final Random lllllllllllllllllIlIlIlIIllIllIl) {
        return Math.min(9, this.quantityDropped(lllllllllllllllllIlIlIlIIllIllIl) + lllllllllllllllllIlIlIlIIllIllIl.nextInt(1 + lllllllllllllllllIlIlIlIIllIlllI));
    }
}
