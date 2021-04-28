package net.minecraft.block;

import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;

public class BlockAir extends Block
{
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final World llIIIIllIllllII, final BlockPos llIIIIllIlllIll, final IBlockState llIIIIllIlllIlI) {
        return null;
    }
    
    @Override
    public int getRenderType() {
        return -1;
    }
    
    protected BlockAir() {
        super(Material.air);
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World llIIIIllIllIlII, final BlockPos llIIIIllIllIIll, final IBlockState llIIIIllIllIIlI, final float llIIIIllIllIIIl, final int llIIIIllIllIIII) {
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    static {
        __OBFID = "CL_00000190";
    }
    
    @Override
    public boolean canCollideCheck(final IBlockState llIIIIllIllIlll, final boolean llIIIIllIllIllI) {
        return false;
    }
}
