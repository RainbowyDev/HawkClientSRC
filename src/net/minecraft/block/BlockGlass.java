package net.minecraft.block;

import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import java.util.*;

public class BlockGlass extends BlockBreakable
{
    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.CUTOUT;
    }
    
    @Override
    protected boolean canSilkHarvest() {
        return true;
    }
    
    public BlockGlass(final Material lllllllllllllllllIIllIIllIllllII, final boolean lllllllllllllllllIIllIIllIlllIll) {
        super(lllllllllllllllllIIllIIllIllllII, lllllllllllllllllIIllIIllIlllIll);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    @Override
    public int quantityDropped(final Random lllllllllllllllllIIllIIllIllIllI) {
        return 0;
    }
    
    static {
        __OBFID = "CL_00000249";
    }
}
