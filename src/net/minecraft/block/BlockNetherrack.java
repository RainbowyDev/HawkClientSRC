package net.minecraft.block;

import net.minecraft.creativetab.*;
import net.minecraft.block.state.*;
import net.minecraft.block.material.*;

public class BlockNetherrack extends Block
{
    public BlockNetherrack() {
        super(Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    @Override
    public MapColor getMapColor(final IBlockState llllllllllllllIllIlIlIllIIIIlIII) {
        return MapColor.netherrackColor;
    }
    
    static {
        __OBFID = "CL_00000275";
    }
}
