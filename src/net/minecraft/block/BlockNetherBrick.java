package net.minecraft.block;

import net.minecraft.block.state.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;

public class BlockNetherBrick extends Block
{
    static {
        __OBFID = "CL_00002091";
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllllllIIlIllllIIlllIlll) {
        return MapColor.netherrackColor;
    }
    
    public BlockNetherBrick() {
        super(Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
}
