package net.minecraft.block;

import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;

public class BlockSoulSand extends Block
{
    @Override
    public void onEntityCollidedWithBlock(final World llllllllllllllIlIIlIlIIlIlIlIlII, final BlockPos llllllllllllllIlIIlIlIIlIlIlIIll, final IBlockState llllllllllllllIlIIlIlIIlIlIlIIlI, final Entity llllllllllllllIlIIlIlIIlIlIlIIIl) {
        llllllllllllllIlIIlIlIIlIlIlIIIl.motionX *= 0.4;
        llllllllllllllIlIIlIlIIlIlIlIIIl.motionZ *= 0.4;
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final World llllllllllllllIlIIlIlIIlIlIlllII, final BlockPos llllllllllllllIlIIlIlIIlIlIllIll, final IBlockState llllllllllllllIlIIlIlIIlIlIllIlI) {
        final float llllllllllllllIlIIlIlIIlIlIllIIl = 0.125f;
        return new AxisAlignedBB(llllllllllllllIlIIlIlIIlIlIllIll.getX(), llllllllllllllIlIIlIlIIlIlIllIll.getY(), llllllllllllllIlIIlIlIIlIlIllIll.getZ(), llllllllllllllIlIIlIlIIlIlIllIll.getX() + 1, llllllllllllllIlIIlIlIIlIlIllIll.getY() + 1 - llllllllllllllIlIIlIlIIlIlIllIIl, llllllllllllllIlIIlIlIIlIlIllIll.getZ() + 1);
    }
    
    public BlockSoulSand() {
        super(Material.sand);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    static {
        __OBFID = "CL_00000310";
    }
}
