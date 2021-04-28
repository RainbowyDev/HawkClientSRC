package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import java.util.*;
import net.minecraft.block.state.*;

public class BlockReed extends Block
{
    public static final /* synthetic */ PropertyInteger field_176355_a;
    
    @Override
    public void onNeighborBlockChange(final World lllllllllllllllIlIIlIllIlIlIIIll, final BlockPos lllllllllllllllIlIIlIllIlIIlllIl, final IBlockState lllllllllllllllIlIIlIllIlIIlllII, final Block lllllllllllllllIlIIlIllIlIlIIIII) {
        this.func_176353_e(lllllllllllllllIlIIlIllIlIlIIIll, lllllllllllllllIlIIlIllIlIIlllIl, lllllllllllllllIlIIlIllIlIIlllII);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllIlIIlIllIIllIllIl) {
        return this.getDefaultState().withProperty(BlockReed.field_176355_a, lllllllllllllllIlIIlIllIIllIllIl);
    }
    
    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.CUTOUT;
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final World lllllllllllllllIlIIlIllIlIIIIlIl, final BlockPos lllllllllllllllIlIIlIllIlIIIIlII, final IBlockState lllllllllllllllIlIIlIllIlIIIIIll) {
        return null;
    }
    
    protected final boolean func_176353_e(final World lllllllllllllllIlIIlIllIlIIlIllI, final BlockPos lllllllllllllllIlIIlIllIlIIlIIIl, final IBlockState lllllllllllllllIlIIlIllIlIIlIlII) {
        if (this.func_176354_d(lllllllllllllllIlIIlIllIlIIlIllI, lllllllllllllllIlIIlIllIlIIlIIIl)) {
            return true;
        }
        this.dropBlockAsItem(lllllllllllllllIlIIlIllIlIIlIllI, lllllllllllllllIlIIlIllIlIIlIIIl, lllllllllllllllIlIIlIllIlIIlIlII, 0);
        lllllllllllllllIlIIlIllIlIIlIllI.setBlockToAir(lllllllllllllllIlIIlIllIlIIlIIIl);
        return false;
    }
    
    @Override
    public Item getItem(final World lllllllllllllllIlIIlIllIIllllIll, final BlockPos lllllllllllllllIlIIlIllIIllllIlI) {
        return Items.reeds;
    }
    
    @Override
    public int colorMultiplier(final IBlockAccess lllllllllllllllIlIIlIllIIlllIIll, final BlockPos lllllllllllllllIlIIlIllIIlllIIlI, final int lllllllllllllllIlIIlIllIIlllIlII) {
        return lllllllllllllllIlIIlIllIIlllIIll.getBiomeGenForCoords(lllllllllllllllIlIIlIllIIlllIIlI).func_180627_b(lllllllllllllllIlIIlIllIIlllIIlI);
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    static {
        __OBFID = "CL_00000300";
        field_176355_a = PropertyInteger.create("age", 0, 15);
    }
    
    public boolean func_176354_d(final World lllllllllllllllIlIIlIllIlIIIlIII, final BlockPos lllllllllllllllIlIIlIllIlIIIlIlI) {
        return this.canPlaceBlockAt(lllllllllllllllIlIIlIllIlIIIlIII, lllllllllllllllIlIIlIllIlIIIlIlI);
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllllllIlIIlIllIlIlIllIl, final BlockPos lllllllllllllllIlIIlIllIlIlIllII) {
        final Block lllllllllllllllIlIIlIllIlIllIIIl = lllllllllllllllIlIIlIllIlIlIllIl.getBlockState(lllllllllllllllIlIIlIllIlIlIllII.offsetDown()).getBlock();
        if (lllllllllllllllIlIIlIllIlIllIIIl == this) {
            return true;
        }
        if (lllllllllllllllIlIIlIllIlIllIIIl != Blocks.grass && lllllllllllllllIlIIlIllIlIllIIIl != Blocks.dirt && lllllllllllllllIlIIlIllIlIllIIIl != Blocks.sand) {
            return false;
        }
        for (final EnumFacing lllllllllllllllIlIIlIllIlIlIllll : EnumFacing.Plane.HORIZONTAL) {
            if (lllllllllllllllIlIIlIllIlIlIllIl.getBlockState(lllllllllllllllIlIIlIllIlIlIllII.offset(lllllllllllllllIlIIlIllIlIlIllll).offsetDown()).getBlock().getMaterial() == Material.water) {
                return true;
            }
        }
        return false;
    }
    
    protected BlockReed() {
        super(Material.plants);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockReed.field_176355_a, 0));
        final float lllllllllllllllIlIIlIllIllIlIIII = 0.375f;
        this.setBlockBounds(0.5f - lllllllllllllllIlIIlIllIllIlIIII, 0.0f, 0.5f - lllllllllllllllIlIIlIllIllIlIIII, 0.5f + lllllllllllllllIlIIlIllIllIlIIII, 1.0f, 0.5f + lllllllllllllllIlIIlIllIllIlIIII);
        this.setTickRandomly(true);
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllllIlIIlIllIlIIIIIIl, final Random lllllllllllllllIlIIlIllIlIIIIIII, final int lllllllllllllllIlIIlIllIIlllllll) {
        return Items.reeds;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllIlIIlIllIIllIlIII) {
        return (int)lllllllllllllllIlIIlIllIIllIlIII.getValue(BlockReed.field_176355_a);
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockReed.field_176355_a });
    }
    
    @Override
    public void updateTick(final World lllllllllllllllIlIIlIllIlIllllll, final BlockPos lllllllllllllllIlIIlIllIlIlllllI, final IBlockState lllllllllllllllIlIIlIllIlIllllIl, final Random lllllllllllllllIlIIlIllIllIIIIll) {
        if ((lllllllllllllllIlIIlIllIlIllllll.getBlockState(lllllllllllllllIlIIlIllIlIlllllI.offsetDown()).getBlock() == Blocks.reeds || this.func_176353_e(lllllllllllllllIlIIlIllIlIllllll, lllllllllllllllIlIIlIllIlIlllllI, lllllllllllllllIlIIlIllIlIllllIl)) && lllllllllllllllIlIIlIllIlIllllll.isAirBlock(lllllllllllllllIlIIlIllIlIlllllI.offsetUp())) {
            int lllllllllllllllIlIIlIllIllIIIIlI;
            for (lllllllllllllllIlIIlIllIllIIIIlI = 1; lllllllllllllllIlIIlIllIlIllllll.getBlockState(lllllllllllllllIlIIlIllIlIlllllI.offsetDown(lllllllllllllllIlIIlIllIllIIIIlI)).getBlock() == this; ++lllllllllllllllIlIIlIllIllIIIIlI) {}
            if (lllllllllllllllIlIIlIllIllIIIIlI < 3) {
                final int lllllllllllllllIlIIlIllIllIIIIIl = (int)lllllllllllllllIlIIlIllIlIllllIl.getValue(BlockReed.field_176355_a);
                if (lllllllllllllllIlIIlIllIllIIIIIl == 15) {
                    lllllllllllllllIlIIlIllIlIllllll.setBlockState(lllllllllllllllIlIIlIllIlIlllllI.offsetUp(), this.getDefaultState());
                    lllllllllllllllIlIIlIllIlIllllll.setBlockState(lllllllllllllllIlIIlIllIlIlllllI, lllllllllllllllIlIIlIllIlIllllIl.withProperty(BlockReed.field_176355_a, 0), 4);
                }
                else {
                    lllllllllllllllIlIIlIllIlIllllll.setBlockState(lllllllllllllllIlIIlIllIlIlllllI, lllllllllllllllIlIIlIllIlIllllIl.withProperty(BlockReed.field_176355_a, lllllllllllllllIlIIlIllIllIIIIIl + 1), 4);
                }
            }
        }
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
}
