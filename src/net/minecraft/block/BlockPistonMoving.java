package net.minecraft.block;

import net.minecraft.world.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.tileentity.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.util.*;

public class BlockPistonMoving extends BlockContainer
{
    public static final /* synthetic */ PropertyEnum field_176425_b;
    public static final /* synthetic */ PropertyDirection field_176426_a;
    
    @Override
    public MovingObjectPosition collisionRayTrace(final World llllllllllllllIIlllllllIllllIlIl, final BlockPos llllllllllllllIIlllllllIllllIlII, final Vec3 llllllllllllllIIlllllllIllllIIll, final Vec3 llllllllllllllIIlllllllIllllIIIl) {
        return null;
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World llllllllllllllIIllllllllIIIIIIII, final BlockPos llllllllllllllIIlllllllIlllllllI, final IBlockState llllllllllllllIIllllllllIIIIlIII, final float llllllllllllllIIllllllllIIIIIlll, final int llllllllllllllIIllllllllIIIIIllI) {
        if (!llllllllllllllIIllllllllIIIIIIII.isRemote) {
            final TileEntityPiston llllllllllllllIIllllllllIIIIIlII = this.func_176422_e(llllllllllllllIIllllllllIIIIIIII, llllllllllllllIIlllllllIlllllllI);
            if (llllllllllllllIIllllllllIIIIIlII != null) {
                final IBlockState llllllllllllllIIllllllllIIIIIIll = llllllllllllllIIllllllllIIIIIlII.func_174927_b();
                llllllllllllllIIllllllllIIIIIIll.getBlock().dropBlockAsItem(llllllllllllllIIllllllllIIIIIIII, llllllllllllllIIlllllllIlllllllI, llllllllllllllIIllllllllIIIIIIll, 0);
            }
        }
    }
    
    @Override
    public Item getItem(final World llllllllllllllIIlllllllIIIlIIIll, final BlockPos llllllllllllllIIlllllllIIIlIIIIl) {
        return null;
    }
    
    @Override
    public boolean onBlockActivated(final World llllllllllllllIIllllllllIIIlllll, final BlockPos llllllllllllllIIllllllllIIIllllI, final IBlockState llllllllllllllIIllllllllIIIlllIl, final EntityPlayer llllllllllllllIIllllllllIIIlllII, final EnumFacing llllllllllllllIIllllllllIIIllIll, final float llllllllllllllIIllllllllIIIllIlI, final float llllllllllllllIIllllllllIIIllIIl, final float llllllllllllllIIllllllllIIIllIII) {
        if (!llllllllllllllIIllllllllIIIlllll.isRemote && llllllllllllllIIllllllllIIIlllll.getTileEntity(llllllllllllllIIllllllllIIIllllI) == null) {
            llllllllllllllIIllllllllIIIlllll.setBlockToAir(llllllllllllllIIllllllllIIIllllI);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean canPlaceBlockAt(final World llllllllllllllIIllllllllIIlllIlI, final BlockPos llllllllllllllIIllllllllIIlllIIl) {
        return false;
    }
    
    @Override
    public void breakBlock(final World llllllllllllllIIllllllllIlIIIlII, final BlockPos llllllllllllllIIllllllllIIlllllI, final IBlockState llllllllllllllIIllllllllIlIIIIlI) {
        final TileEntity llllllllllllllIIllllllllIlIIIIIl = llllllllllllllIIllllllllIlIIIlII.getTileEntity(llllllllllllllIIllllllllIIlllllI);
        if (llllllllllllllIIllllllllIlIIIIIl instanceof TileEntityPiston) {
            ((TileEntityPiston)llllllllllllllIIllllllllIlIIIIIl).clearPistonTileEntity();
        }
        else {
            super.breakBlock(llllllllllllllIIllllllllIlIIIlII, llllllllllllllIIllllllllIIlllllI, llllllllllllllIIllllllllIlIIIIlI);
        }
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIIlllllllIIIIllIII) {
        return this.getDefaultState().withProperty(BlockPistonMoving.field_176426_a, BlockPistonExtension.func_176322_b(llllllllllllllIIlllllllIIIIllIII)).withProperty(BlockPistonMoving.field_176425_b, ((llllllllllllllIIlllllllIIIIllIII & 0x8) > 0) ? BlockPistonExtension.EnumPistonType.STICKY : BlockPistonExtension.EnumPistonType.DEFAULT);
    }
    
    @Override
    public void onBlockDestroyedByPlayer(final World llllllllllllllIIllllllllIIlIlllI, final BlockPos llllllllllllllIIllllllllIIlIlIII, final IBlockState llllllllllllllIIllllllllIIlIllII) {
        final BlockPos llllllllllllllIIllllllllIIlIlIll = llllllllllllllIIllllllllIIlIlIII.offset(((EnumFacing)llllllllllllllIIllllllllIIlIllII.getValue(BlockPistonMoving.field_176426_a)).getOpposite());
        final IBlockState llllllllllllllIIllllllllIIlIlIlI = llllllllllllllIIllllllllIIlIlllI.getBlockState(llllllllllllllIIllllllllIIlIlIll);
        if (llllllllllllllIIllllllllIIlIlIlI.getBlock() instanceof BlockPistonBase && (boolean)llllllllllllllIIllllllllIIlIlIlI.getValue(BlockPistonBase.EXTENDED)) {
            llllllllllllllIIllllllllIIlIlllI.setBlockToAir(llllllllllllllIIllllllllIIlIlIll);
        }
    }
    
    @Override
    public void setBlockBoundsBasedOnState(final IBlockAccess llllllllllllllIIlllllllIlIIlIIll, final BlockPos llllllllllllllIIlllllllIlIIlllll) {
        final TileEntityPiston llllllllllllllIIlllllllIlIIlllIl = this.func_176422_e(llllllllllllllIIlllllllIlIIlIIll, llllllllllllllIIlllllllIlIIlllll);
        if (llllllllllllllIIlllllllIlIIlllIl != null) {
            final IBlockState llllllllllllllIIlllllllIlIIllIll = llllllllllllllIIlllllllIlIIlllIl.func_174927_b();
            final Block llllllllllllllIIlllllllIlIIllIIl = llllllllllllllIIlllllllIlIIllIll.getBlock();
            if (llllllllllllllIIlllllllIlIIllIIl == this || llllllllllllllIIlllllllIlIIllIIl.getMaterial() == Material.air) {
                return;
            }
            float llllllllllllllIIlllllllIlIIlIlll = llllllllllllllIIlllllllIlIIlllIl.func_145860_a(0.0f);
            if (llllllllllllllIIlllllllIlIIlllIl.isExtending()) {
                llllllllllllllIIlllllllIlIIlIlll = 1.0f - llllllllllllllIIlllllllIlIIlIlll;
            }
            llllllllllllllIIlllllllIlIIllIIl.setBlockBoundsBasedOnState(llllllllllllllIIlllllllIlIIlIIll, llllllllllllllIIlllllllIlIIlllll);
            if (llllllllllllllIIlllllllIlIIllIIl == Blocks.piston || llllllllllllllIIlllllllIlIIllIIl == Blocks.sticky_piston) {
                llllllllllllllIIlllllllIlIIlIlll = 0.0f;
            }
            final EnumFacing llllllllllllllIIlllllllIlIIlIlIl = llllllllllllllIIlllllllIlIIlllIl.func_174930_e();
            this.minX = llllllllllllllIIlllllllIlIIllIIl.getBlockBoundsMinX() - llllllllllllllIIlllllllIlIIlIlIl.getFrontOffsetX() * llllllllllllllIIlllllllIlIIlIlll;
            this.minY = llllllllllllllIIlllllllIlIIllIIl.getBlockBoundsMinY() - llllllllllllllIIlllllllIlIIlIlIl.getFrontOffsetY() * llllllllllllllIIlllllllIlIIlIlll;
            this.minZ = llllllllllllllIIlllllllIlIIllIIl.getBlockBoundsMinZ() - llllllllllllllIIlllllllIlIIlIlIl.getFrontOffsetZ() * llllllllllllllIIlllllllIlIIlIlll;
            this.maxX = llllllllllllllIIlllllllIlIIllIIl.getBlockBoundsMaxX() - llllllllllllllIIlllllllIlIIlIlIl.getFrontOffsetX() * llllllllllllllIIlllllllIlIIlIlll;
            this.maxY = llllllllllllllIIlllllllIlIIllIIl.getBlockBoundsMaxY() - llllllllllllllIIlllllllIlIIlIlIl.getFrontOffsetY() * llllllllllllllIIlllllllIlIIlIlll;
            this.maxZ = llllllllllllllIIlllllllIlIIllIIl.getBlockBoundsMaxZ() - llllllllllllllIIlllllllIlIIlIlIl.getFrontOffsetZ() * llllllllllllllIIlllllllIlIIlIlll;
        }
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIIlllllllIIIIIIllI) {
        final byte llllllllllllllIIlllllllIIIIIlIII = 0;
        int llllllllllllllIIlllllllIIIIIIlll = llllllllllllllIIlllllllIIIIIlIII | ((EnumFacing)llllllllllllllIIlllllllIIIIIIllI.getValue(BlockPistonMoving.field_176426_a)).getIndex();
        if (llllllllllllllIIlllllllIIIIIIllI.getValue(BlockPistonMoving.field_176425_b) == BlockPistonExtension.EnumPistonType.STICKY) {
            llllllllllllllIIlllllllIIIIIIlll |= 0x8;
        }
        return llllllllllllllIIlllllllIIIIIIlll;
    }
    
    @Override
    public TileEntity createNewTileEntity(final World llllllllllllllIIllllllllIlIllIII, final int llllllllllllllIIllllllllIlIlIlll) {
        return null;
    }
    
    static {
        __OBFID = "CL_00000368";
        field_176426_a = BlockPistonExtension.field_176326_a;
        field_176425_b = BlockPistonExtension.field_176325_b;
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockPistonMoving.field_176426_a, BlockPistonMoving.field_176425_b });
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllIIllllllllIIIlIlII, final Random llllllllllllllIIllllllllIIIlIIll, final int llllllllllllllIIllllllllIIIlIIlI) {
        return null;
    }
    
    public BlockPistonMoving() {
        super(Material.piston);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockPistonMoving.field_176426_a, EnumFacing.NORTH).withProperty(BlockPistonMoving.field_176425_b, BlockPistonExtension.EnumPistonType.DEFAULT));
        this.setHardness(-1.0f);
    }
    
    public static TileEntity func_176423_a(final IBlockState llllllllllllllIIllllllllIlIlIIlI, final EnumFacing llllllllllllllIIllllllllIlIIllIl, final boolean llllllllllllllIIllllllllIlIIllII, final boolean llllllllllllllIIllllllllIlIIllll) {
        return new TileEntityPiston(llllllllllllllIIllllllllIlIlIIlI, llllllllllllllIIllllllllIlIIllIl, llllllllllllllIIllllllllIlIIllII, llllllllllllllIIllllllllIlIIllll);
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final World llllllllllllllIIlllllllIllIIlIll, final BlockPos llllllllllllllIIlllllllIllIIlIIl, final IBlockState llllllllllllllIIlllllllIllIIIlll) {
        final TileEntityPiston llllllllllllllIIlllllllIllIIIllI = this.func_176422_e(llllllllllllllIIlllllllIllIIlIll, llllllllllllllIIlllllllIllIIlIIl);
        if (llllllllllllllIIlllllllIllIIIllI == null) {
            return null;
        }
        float llllllllllllllIIlllllllIllIIIlII = llllllllllllllIIlllllllIllIIIllI.func_145860_a(0.0f);
        if (llllllllllllllIIlllllllIllIIIllI.isExtending()) {
            llllllllllllllIIlllllllIllIIIlII = 1.0f - llllllllllllllIIlllllllIllIIIlII;
        }
        return this.func_176424_a(llllllllllllllIIlllllllIllIIlIll, llllllllllllllIIlllllllIllIIlIIl, llllllllllllllIIlllllllIllIIIllI.func_174927_b(), llllllllllllllIIlllllllIllIIIlII, llllllllllllllIIlllllllIllIIIllI.func_174930_e());
    }
    
    private TileEntityPiston func_176422_e(final IBlockAccess llllllllllllllIIlllllllIIIlIllII, final BlockPos llllllllllllllIIlllllllIIIlIlIlI) {
        final TileEntity llllllllllllllIIlllllllIIIlIlllI = llllllllllllllIIlllllllIIIlIllII.getTileEntity(llllllllllllllIIlllllllIIIlIlIlI);
        return (llllllllllllllIIlllllllIIIlIlllI instanceof TileEntityPiston) ? ((TileEntityPiston)llllllllllllllIIlllllllIIIlIlllI) : null;
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    public AxisAlignedBB func_176424_a(final World llllllllllllllIIlllllllIIllIIllI, final BlockPos llllllllllllllIIlllllllIIlIIlIll, final IBlockState llllllllllllllIIlllllllIIllIIlII, final float llllllllllllllIIlllllllIIlIIlIIl, final EnumFacing llllllllllllllIIlllllllIIllIIIlI) {
        if (llllllllllllllIIlllllllIIllIIlII.getBlock() == this || llllllllllllllIIlllllllIIllIIlII.getBlock().getMaterial() == Material.air) {
            return null;
        }
        final AxisAlignedBB llllllllllllllIIlllllllIIllIIIIl = llllllllllllllIIlllllllIIllIIlII.getBlock().getCollisionBoundingBox(llllllllllllllIIlllllllIIllIIllI, llllllllllllllIIlllllllIIlIIlIll, llllllllllllllIIlllllllIIllIIlII);
        if (llllllllllllllIIlllllllIIllIIIIl == null) {
            return null;
        }
        double llllllllllllllIIlllllllIIlIlIllI = llllllllllllllIIlllllllIIllIIIIl.minX;
        double llllllllllllllIIlllllllIIlIlIlII = llllllllllllllIIlllllllIIllIIIIl.minY;
        double llllllllllllllIIlllllllIIlIlIIlI = llllllllllllllIIlllllllIIllIIIIl.minZ;
        double llllllllllllllIIlllllllIIlIlIIII = llllllllllllllIIlllllllIIllIIIIl.maxX;
        double llllllllllllllIIlllllllIIlIIllll = llllllllllllllIIlllllllIIllIIIIl.maxY;
        double llllllllllllllIIlllllllIIlIIlllI = llllllllllllllIIlllllllIIllIIIIl.maxZ;
        if (llllllllllllllIIlllllllIIllIIIlI.getFrontOffsetX() < 0) {
            llllllllllllllIIlllllllIIlIlIllI -= llllllllllllllIIlllllllIIllIIIlI.getFrontOffsetX() * llllllllllllllIIlllllllIIlIIlIIl;
        }
        else {
            llllllllllllllIIlllllllIIlIlIIII -= llllllllllllllIIlllllllIIllIIIlI.getFrontOffsetX() * llllllllllllllIIlllllllIIlIIlIIl;
        }
        if (llllllllllllllIIlllllllIIllIIIlI.getFrontOffsetY() < 0) {
            llllllllllllllIIlllllllIIlIlIlII -= llllllllllllllIIlllllllIIllIIIlI.getFrontOffsetY() * llllllllllllllIIlllllllIIlIIlIIl;
        }
        else {
            llllllllllllllIIlllllllIIlIIllll -= llllllllllllllIIlllllllIIllIIIlI.getFrontOffsetY() * llllllllllllllIIlllllllIIlIIlIIl;
        }
        if (llllllllllllllIIlllllllIIllIIIlI.getFrontOffsetZ() < 0) {
            llllllllllllllIIlllllllIIlIlIIlI -= llllllllllllllIIlllllllIIllIIIlI.getFrontOffsetZ() * llllllllllllllIIlllllllIIlIIlIIl;
        }
        else {
            llllllllllllllIIlllllllIIlIIlllI -= llllllllllllllIIlllllllIIllIIIlI.getFrontOffsetZ() * llllllllllllllIIlllllllIIlIIlIIl;
        }
        return new AxisAlignedBB(llllllllllllllIIlllllllIIlIlIllI, llllllllllllllIIlllllllIIlIlIlII, llllllllllllllIIlllllllIIlIlIIlI, llllllllllllllIIlllllllIIlIlIIII, llllllllllllllIIlllllllIIlIIllll, llllllllllllllIIlllllllIIlIIlllI);
    }
    
    @Override
    public void onNeighborBlockChange(final World llllllllllllllIIlllllllIlllIIIIl, final BlockPos llllllllllllllIIlllllllIllIlllll, final IBlockState llllllllllllllIIlllllllIlllIIlIl, final Block llllllllllllllIIlllllllIlllIIIll) {
        if (!llllllllllllllIIlllllllIlllIIIIl.isRemote) {
            llllllllllllllIIlllllllIlllIIIIl.getTileEntity(llllllllllllllIIlllllllIllIlllll);
        }
    }
    
    @Override
    public boolean canPlaceBlockOnSide(final World llllllllllllllIIllllllllIIllIlll, final BlockPos llllllllllllllIIllllllllIIllIllI, final EnumFacing llllllllllllllIIllllllllIIllIlIl) {
        return false;
    }
}
