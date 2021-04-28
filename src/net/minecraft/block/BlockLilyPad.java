package net.minecraft.block;

import net.minecraft.block.state.*;
import net.minecraft.creativetab.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.item.*;
import net.minecraft.block.material.*;
import net.minecraft.block.properties.*;
import net.minecraft.init.*;
import net.minecraft.world.*;

public class BlockLilyPad extends BlockBush
{
    @Override
    public int getRenderColor(final IBlockState llllllllllllllIIIIIlIlIIIIIIIIIl) {
        return 7455580;
    }
    
    protected BlockLilyPad() {
        final float llllllllllllllIIIIIlIlIIIIlIIlIl = 0.5f;
        final float llllllllllllllIIIIIlIlIIIIlIIlII = 0.015625f;
        this.setBlockBounds(0.5f - llllllllllllllIIIIIlIlIIIIlIIlIl, 0.0f, 0.5f - llllllllllllllIIIIIlIlIIIIlIIlIl, 0.5f + llllllllllllllIIIIIlIlIIIIlIIlIl, llllllllllllllIIIIIlIlIIIIlIIlII, 0.5f + llllllllllllllIIIIIlIlIIIIlIIlIl);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIIIIIlIIlllllIllII) {
        return 0;
    }
    
    @Override
    public int getBlockColor() {
        return 7455580;
    }
    
    @Override
    public void addCollisionBoxesToList(final World llllllllllllllIIIIIlIlIIIIIlIIIl, final BlockPos llllllllllllllIIIIIlIlIIIIIlIIII, final IBlockState llllllllllllllIIIIIlIlIIIIIIllll, final AxisAlignedBB llllllllllllllIIIIIlIlIIIIIlIlIl, final List llllllllllllllIIIIIlIlIIIIIlIlII, final Entity llllllllllllllIIIIIlIlIIIIIlIIll) {
        if (llllllllllllllIIIIIlIlIIIIIlIIll == null || !(llllllllllllllIIIIIlIlIIIIIlIIll instanceof EntityBoat)) {
            super.addCollisionBoxesToList(llllllllllllllIIIIIlIlIIIIIlIIIl, llllllllllllllIIIIIlIlIIIIIlIIII, llllllllllllllIIIIIlIlIIIIIIllll, llllllllllllllIIIIIlIlIIIIIlIlIl, llllllllllllllIIIIIlIlIIIIIlIlII, llllllllllllllIIIIIlIlIIIIIlIIll);
        }
    }
    
    @Override
    public boolean canBlockStay(final World llllllllllllllIIIIIlIIllllllIIII, final BlockPos llllllllllllllIIIIIlIIllllllIIll, final IBlockState llllllllllllllIIIIIlIIllllllIIlI) {
        if (llllllllllllllIIIIIlIIllllllIIll.getY() >= 0 && llllllllllllllIIIIIlIIllllllIIll.getY() < 256) {
            final IBlockState llllllllllllllIIIIIlIIllllllIIIl = llllllllllllllIIIIIlIIllllllIIII.getBlockState(llllllllllllllIIIIIlIIllllllIIll.offsetDown());
            return llllllllllllllIIIIIlIIllllllIIIl.getBlock().getMaterial() == Material.water && (int)llllllllllllllIIIIIlIIllllllIIIl.getValue(BlockLiquid.LEVEL) == 0;
        }
        return false;
    }
    
    @Override
    protected boolean canPlaceBlockOn(final Block llllllllllllllIIIIIlIIlllllllIlI) {
        return llllllllllllllIIIIIlIIlllllllIlI == Blocks.water;
    }
    
    @Override
    public int colorMultiplier(final IBlockAccess llllllllllllllIIIIIlIIllllllllll, final BlockPos llllllllllllllIIIIIlIIlllllllllI, final int llllllllllllllIIIIIlIIllllllllIl) {
        return 2129968;
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final World llllllllllllllIIIIIlIlIIIIIIlIII, final BlockPos llllllllllllllIIIIIlIlIIIIIIIlII, final IBlockState llllllllllllllIIIIIlIlIIIIIIIllI) {
        return new AxisAlignedBB(llllllllllllllIIIIIlIlIIIIIIIlII.getX() + this.minX, llllllllllllllIIIIIlIlIIIIIIIlII.getY() + this.minY, llllllllllllllIIIIIlIlIIIIIIIlII.getZ() + this.minZ, llllllllllllllIIIIIlIlIIIIIIIlII.getX() + this.maxX, llllllllllllllIIIIIlIlIIIIIIIlII.getY() + this.maxY, llllllllllllllIIIIIlIlIIIIIIIlII.getZ() + this.maxZ);
    }
    
    static {
        __OBFID = "CL_00000332";
    }
}
