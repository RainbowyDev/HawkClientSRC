package net.minecraft.block;

import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;

public class BlockCompressedPowered extends BlockCompressed
{
    public BlockCompressedPowered(final MapColor llllllllllllllIIIlIIIIIlIIIllllI) {
        super(llllllllllllllIIIlIIIIIlIIIllllI);
        this.setCreativeTab(CreativeTabs.tabRedstone);
    }
    
    static {
        __OBFID = "CL_00000287";
    }
    
    @Override
    public int isProvidingWeakPower(final IBlockAccess llllllllllllllIIIlIIIIIlIIIllIll, final BlockPos llllllllllllllIIIlIIIIIlIIIllIlI, final IBlockState llllllllllllllIIIlIIIIIlIIIllIIl, final EnumFacing llllllllllllllIIIlIIIIIlIIIllIII) {
        return 15;
    }
    
    @Override
    public boolean canProvidePower() {
        return true;
    }
}
