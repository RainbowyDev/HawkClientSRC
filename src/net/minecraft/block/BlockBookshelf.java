package net.minecraft.block;

import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;

public class BlockBookshelf extends Block
{
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllllIlIlIllIIlIllllIl, final Random lllllllllllllllIlIlIllIIlIllllII, final int lllllllllllllllIlIlIllIIlIlllIll) {
        return Items.book;
    }
    
    public BlockBookshelf() {
        super(Material.wood);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    static {
        __OBFID = "CL_00000206";
    }
    
    @Override
    public int quantityDropped(final Random lllllllllllllllIlIlIllIIlIllllll) {
        return 3;
    }
}
