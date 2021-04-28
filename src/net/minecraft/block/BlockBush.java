package net.minecraft.block;

import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.init.*;
import java.util.*;
import net.minecraft.block.material.*;
import net.minecraft.util.*;
import net.minecraft.creativetab.*;

public class BlockBush extends Block
{
    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.CUTOUT;
    }
    
    protected void func_176475_e(final World lllllllllllllllIIlllllIllIlIIlll, final BlockPos lllllllllllllllIIlllllIllIlIIIlI, final IBlockState lllllllllllllllIIlllllIllIlIIlIl) {
        if (!this.canBlockStay(lllllllllllllllIIlllllIllIlIIlll, lllllllllllllllIIlllllIllIlIIIlI, lllllllllllllllIIlllllIllIlIIlIl)) {
            this.dropBlockAsItem(lllllllllllllllIIlllllIllIlIIlll, lllllllllllllllIIlllllIllIlIIIlI, lllllllllllllllIIlllllIllIlIIlIl, 0);
            lllllllllllllllIIlllllIllIlIIlll.setBlockState(lllllllllllllllIIlllllIllIlIIIlI, Blocks.air.getDefaultState(), 3);
        }
    }
    
    static {
        __OBFID = "CL_00000208";
    }
    
    @Override
    public void updateTick(final World lllllllllllllllIIlllllIllIlIllll, final BlockPos lllllllllllllllIIlllllIllIllIIll, final IBlockState lllllllllllllllIIlllllIllIlIllIl, final Random lllllllllllllllIIlllllIllIllIIIl) {
        this.func_176475_e(lllllllllllllllIIlllllIllIlIllll, lllllllllllllllIIlllllIllIllIIll, lllllllllllllllIIlllllIllIlIllIl);
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllllllIIlllllIlllIlIIIl, final BlockPos lllllllllllllllIIlllllIlllIlIIII) {
        return super.canPlaceBlockAt(lllllllllllllllIIlllllIlllIlIIIl, lllllllllllllllIIlllllIlllIlIIII) && this.canPlaceBlockOn(lllllllllllllllIIlllllIlllIlIIIl.getBlockState(lllllllllllllllIIlllllIlllIlIIII.offsetDown()).getBlock());
    }
    
    protected BlockBush() {
        this(Material.plants);
    }
    
    protected boolean canPlaceBlockOn(final Block lllllllllllllllIIlllllIlllIIlIIl) {
        return lllllllllllllllIIlllllIlllIIlIIl == Blocks.grass || lllllllllllllllIIlllllIlllIIlIIl == Blocks.dirt || lllllllllllllllIIlllllIlllIIlIIl == Blocks.farmland;
    }
    
    @Override
    public void onNeighborBlockChange(final World lllllllllllllllIIlllllIlllIIIIlI, final BlockPos lllllllllllllllIIlllllIllIllllII, final IBlockState lllllllllllllllIIlllllIlllIIIIII, final Block lllllllllllllllIIlllllIllIllllll) {
        super.onNeighborBlockChange(lllllllllllllllIIlllllIlllIIIIlI, lllllllllllllllIIlllllIllIllllII, lllllllllllllllIIlllllIlllIIIIII, lllllllllllllllIIlllllIllIllllll);
        this.func_176475_e(lllllllllllllllIIlllllIlllIIIIlI, lllllllllllllllIIlllllIllIllllII, lllllllllllllllIIlllllIlllIIIIII);
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    public boolean canBlockStay(final World lllllllllllllllIIlllllIllIIlllII, final BlockPos lllllllllllllllIIlllllIllIIlIlll, final IBlockState lllllllllllllllIIlllllIllIIllIlI) {
        return this.canPlaceBlockOn(lllllllllllllllIIlllllIllIIlllII.getBlockState(lllllllllllllllIIlllllIllIIlIlll.offsetDown()).getBlock());
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final World lllllllllllllllIIlllllIllIIlIlIl, final BlockPos lllllllllllllllIIlllllIllIIlIlII, final IBlockState lllllllllllllllIIlllllIllIIlIIll) {
        return null;
    }
    
    protected BlockBush(final Material lllllllllllllllIIlllllIlllIlllIl) {
        super(lllllllllllllllIIlllllIlllIlllIl);
        this.setTickRandomly(true);
        final float lllllllllllllllIIlllllIlllIlllII = 0.2f;
        this.setBlockBounds(0.5f - lllllllllllllllIIlllllIlllIlllII, 0.0f, 0.5f - lllllllllllllllIIlllllIlllIlllII, 0.5f + lllllllllllllllIIlllllIlllIlllII, lllllllllllllllIIlllllIlllIlllII * 3.0f, 0.5f + lllllllllllllllIIlllllIlllIlllII);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
}
