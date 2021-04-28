package net.minecraft.block;

import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;

public class BlockObsidian extends Block
{
    @Override
    public MapColor getMapColor(final IBlockState llllllllllllllIIlIllIIlIIIIIIIIl) {
        return MapColor.obsidianColor;
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllIIlIllIIlIIIIIIlIl, final Random llllllllllllllIIlIllIIlIIIIIIlII, final int llllllllllllllIIlIllIIlIIIIIIIll) {
        return Item.getItemFromBlock(Blocks.obsidian);
    }
    
    public BlockObsidian() {
        super(Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    static {
        __OBFID = "CL_00000279";
    }
}
