package net.minecraft.block;

import net.minecraft.creativetab.*;
import net.minecraft.block.state.*;
import net.minecraft.block.material.*;

public class BlockHardenedClay extends Block
{
    public BlockHardenedClay() {
        super(Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    @Override
    public MapColor getMapColor(final IBlockState llllllllllllllIllIlllIIlIlIllIIl) {
        return MapColor.adobeColor;
    }
    
    static {
        __OBFID = "CL_00000255";
    }
}
