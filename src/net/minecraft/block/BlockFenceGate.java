package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.entity.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;

public class BlockFenceGate extends BlockDirectional
{
    public static final /* synthetic */ PropertyBool field_176466_a;
    public static final /* synthetic */ PropertyBool field_176467_M;
    public static final /* synthetic */ PropertyBool field_176465_b;
    
    @Override
    public boolean isPassable(final IBlockAccess llllllllllllllIlIIlIllIlllIllIll, final BlockPos llllllllllllllIlIIlIllIlllIllIlI) {
        return (boolean)llllllllllllllIlIIlIllIlllIllIll.getBlockState(llllllllllllllIlIIlIllIlllIllIlI).getValue(BlockFenceGate.field_176466_a);
    }
    
    @Override
    public boolean onBlockActivated(final World llllllllllllllIlIIlIllIllIlllIll, final BlockPos llllllllllllllIlIIlIllIllIlllIlI, IBlockState llllllllllllllIlIIlIllIllIlllIIl, final EntityPlayer llllllllllllllIlIIlIllIlllIIIIIl, final EnumFacing llllllllllllllIlIIlIllIlllIIIIII, final float llllllllllllllIlIIlIllIllIllllll, final float llllllllllllllIlIIlIllIllIlllllI, final float llllllllllllllIlIIlIllIllIllllIl) {
        if (((IBlockState)llllllllllllllIlIIlIllIllIlllIIl).getValue(BlockFenceGate.field_176466_a)) {
            llllllllllllllIlIIlIllIllIlllIIl = ((IBlockState)llllllllllllllIlIIlIllIllIlllIIl).withProperty(BlockFenceGate.field_176466_a, false);
            llllllllllllllIlIIlIllIllIlllIll.setBlockState(llllllllllllllIlIIlIllIllIlllIlI, (IBlockState)llllllllllllllIlIIlIllIllIlllIIl, 2);
        }
        else {
            final EnumFacing llllllllllllllIlIIlIllIllIllllII = EnumFacing.fromAngle(llllllllllllllIlIIlIllIlllIIIIIl.rotationYaw);
            if (((IBlockState)llllllllllllllIlIIlIllIllIlllIIl).getValue(BlockFenceGate.AGE) == llllllllllllllIlIIlIllIllIllllII.getOpposite()) {
                llllllllllllllIlIIlIllIllIlllIIl = ((IBlockState)llllllllllllllIlIIlIllIllIlllIIl).withProperty(BlockFenceGate.AGE, llllllllllllllIlIIlIllIllIllllII);
            }
            llllllllllllllIlIIlIllIllIlllIIl = ((IBlockState)llllllllllllllIlIIlIllIllIlllIIl).withProperty(BlockFenceGate.field_176466_a, true);
            llllllllllllllIlIIlIllIllIlllIll.setBlockState(llllllllllllllIlIIlIllIllIlllIlI, (IBlockState)llllllllllllllIlIIlIllIllIlllIIl, 2);
        }
        llllllllllllllIlIIlIllIllIlllIll.playAuxSFXAtEntity(llllllllllllllIlIIlIllIlllIIIIIl, ((boolean)((IBlockState)llllllllllllllIlIIlIllIllIlllIIl).getValue(BlockFenceGate.field_176466_a)) ? 1003 : 1006, llllllllllllllIlIIlIllIllIlllIlI, 0);
        return true;
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIlIIlIllIllIIllIII) {
        final byte llllllllllllllIlIIlIllIllIIlIlll = 0;
        int llllllllllllllIlIIlIllIllIIlIllI = llllllllllllllIlIIlIllIllIIlIlll | ((EnumFacing)llllllllllllllIlIIlIllIllIIllIII.getValue(BlockFenceGate.AGE)).getHorizontalIndex();
        if (llllllllllllllIlIIlIllIllIIllIII.getValue(BlockFenceGate.field_176465_b)) {
            llllllllllllllIlIIlIllIllIIlIllI |= 0x8;
        }
        if (llllllllllllllIlIIlIllIllIIllIII.getValue(BlockFenceGate.field_176466_a)) {
            llllllllllllllIlIIlIllIllIIlIllI |= 0x4;
        }
        return llllllllllllllIlIIlIllIllIIlIllI;
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    static {
        __OBFID = "CL_00000243";
        field_176466_a = PropertyBool.create("open");
        field_176465_b = PropertyBool.create("powered");
        field_176467_M = PropertyBool.create("in_wall");
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    @Override
    public void onNeighborBlockChange(final World llllllllllllllIlIIlIllIllIlIlIll, final BlockPos llllllllllllllIlIIlIllIllIlIlIlI, final IBlockState llllllllllllllIlIIlIllIllIlIlllI, final Block llllllllllllllIlIIlIllIllIlIlIII) {
        if (!llllllllllllllIlIIlIllIllIlIlIll.isRemote) {
            final boolean llllllllllllllIlIIlIllIllIlIllII = llllllllllllllIlIIlIllIllIlIlIll.isBlockPowered(llllllllllllllIlIIlIllIllIlIlIlI);
            if (llllllllllllllIlIIlIllIllIlIllII || llllllllllllllIlIIlIllIllIlIlIII.canProvidePower()) {
                if (llllllllllllllIlIIlIllIllIlIllII && !(boolean)llllllllllllllIlIIlIllIllIlIlllI.getValue(BlockFenceGate.field_176466_a) && !(boolean)llllllllllllllIlIIlIllIllIlIlllI.getValue(BlockFenceGate.field_176465_b)) {
                    llllllllllllllIlIIlIllIllIlIlIll.setBlockState(llllllllllllllIlIIlIllIllIlIlIlI, llllllllllllllIlIIlIllIllIlIlllI.withProperty(BlockFenceGate.field_176466_a, true).withProperty(BlockFenceGate.field_176465_b, true), 2);
                    llllllllllllllIlIIlIllIllIlIlIll.playAuxSFXAtEntity(null, 1003, llllllllllllllIlIIlIllIllIlIlIlI, 0);
                }
                else if (!llllllllllllllIlIIlIllIllIlIllII && (boolean)llllllllllllllIlIIlIllIllIlIlllI.getValue(BlockFenceGate.field_176466_a) && (boolean)llllllllllllllIlIIlIllIllIlIlllI.getValue(BlockFenceGate.field_176465_b)) {
                    llllllllllllllIlIIlIllIllIlIlIll.setBlockState(llllllllllllllIlIIlIllIllIlIlIlI, llllllllllllllIlIIlIllIllIlIlllI.withProperty(BlockFenceGate.field_176466_a, false).withProperty(BlockFenceGate.field_176465_b, false), 2);
                    llllllllllllllIlIIlIllIllIlIlIll.playAuxSFXAtEntity(null, 1006, llllllllllllllIlIIlIllIllIlIlIlI, 0);
                }
                else if (llllllllllllllIlIIlIllIllIlIllII != (boolean)llllllllllllllIlIIlIllIllIlIlllI.getValue(BlockFenceGate.field_176465_b)) {
                    llllllllllllllIlIIlIllIllIlIlIll.setBlockState(llllllllllllllIlIIlIllIllIlIlIlI, llllllllllllllIlIIlIllIllIlIlllI.withProperty(BlockFenceGate.field_176465_b, llllllllllllllIlIIlIllIllIlIllII), 2);
                }
            }
        }
    }
    
    @Override
    public IBlockState getActualState(IBlockState llllllllllllllIlIIlIlllIIIIIIlII, final IBlockAccess llllllllllllllIlIIlIlllIIIIIIIll, final BlockPos llllllllllllllIlIIlIlllIIIIIIllI) {
        final EnumFacing.Axis llllllllllllllIlIIlIlllIIIIIIlIl = ((EnumFacing)llllllllllllllIlIIlIlllIIIIIIlII.getValue(BlockFenceGate.AGE)).getAxis();
        if ((llllllllllllllIlIIlIlllIIIIIIlIl == EnumFacing.Axis.Z && (llllllllllllllIlIIlIlllIIIIIIIll.getBlockState(llllllllllllllIlIIlIlllIIIIIIllI.offsetWest()).getBlock() == Blocks.cobblestone_wall || llllllllllllllIlIIlIlllIIIIIIIll.getBlockState(llllllllllllllIlIIlIlllIIIIIIllI.offsetEast()).getBlock() == Blocks.cobblestone_wall)) || (llllllllllllllIlIIlIlllIIIIIIlIl == EnumFacing.Axis.X && (llllllllllllllIlIIlIlllIIIIIIIll.getBlockState(llllllllllllllIlIIlIlllIIIIIIllI.offsetNorth()).getBlock() == Blocks.cobblestone_wall || llllllllllllllIlIIlIlllIIIIIIIll.getBlockState(llllllllllllllIlIIlIlllIIIIIIllI.offsetSouth()).getBlock() == Blocks.cobblestone_wall))) {
            llllllllllllllIlIIlIlllIIIIIIlII = llllllllllllllIlIIlIlllIIIIIIlII.withProperty(BlockFenceGate.field_176467_M, true);
        }
        return llllllllllllllIlIIlIlllIIIIIIlII;
    }
    
    @Override
    public IBlockState onBlockPlaced(final World llllllllllllllIlIIlIllIlllIlIlII, final BlockPos llllllllllllllIlIIlIllIlllIlIIll, final EnumFacing llllllllllllllIlIIlIllIlllIlIIlI, final float llllllllllllllIlIIlIllIlllIlIIIl, final float llllllllllllllIlIIlIllIlllIlIIII, final float llllllllllllllIlIIlIllIlllIIllll, final int llllllllllllllIlIIlIllIlllIIlllI, final EntityLivingBase llllllllllllllIlIIlIllIlllIIllIl) {
        return this.getDefaultState().withProperty(BlockFenceGate.AGE, llllllllllllllIlIIlIllIlllIIllIl.func_174811_aO()).withProperty(BlockFenceGate.field_176466_a, false).withProperty(BlockFenceGate.field_176465_b, false).withProperty(BlockFenceGate.field_176467_M, false);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIlIIlIllIllIIlllIl) {
        return this.getDefaultState().withProperty(BlockFenceGate.AGE, EnumFacing.getHorizontal(llllllllllllllIlIIlIllIllIIlllIl)).withProperty(BlockFenceGate.field_176466_a, (llllllllllllllIlIIlIllIllIIlllIl & 0x4) != 0x0).withProperty(BlockFenceGate.field_176465_b, (llllllllllllllIlIIlIllIllIIlllIl & 0x8) != 0x0);
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockAccess llllllllllllllIlIIlIllIllIlIIlIl, final BlockPos llllllllllllllIlIIlIllIllIlIIlII, final EnumFacing llllllllllllllIlIIlIllIllIlIIIll) {
        return true;
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockFenceGate.AGE, BlockFenceGate.field_176466_a, BlockFenceGate.field_176465_b, BlockFenceGate.field_176467_M });
    }
    
    @Override
    public boolean canPlaceBlockAt(final World llllllllllllllIlIIlIllIlllllllII, final BlockPos llllllllllllllIlIIlIllIllllllIll) {
        return llllllllllllllIlIIlIllIlllllllII.getBlockState(llllllllllllllIlIIlIllIllllllIll.offsetDown()).getBlock().getMaterial().isSolid() && super.canPlaceBlockAt(llllllllllllllIlIIlIllIlllllllII, llllllllllllllIlIIlIllIllllllIll);
    }
    
    @Override
    public void setBlockBoundsBasedOnState(final IBlockAccess llllllllllllllIlIIlIllIllllIIIll, final BlockPos llllllllllllllIlIIlIllIllllIIllI) {
        final EnumFacing.Axis llllllllllllllIlIIlIllIllllIIlIl = ((EnumFacing)llllllllllllllIlIIlIllIllllIIIll.getBlockState(llllllllllllllIlIIlIllIllllIIllI).getValue(BlockFenceGate.AGE)).getAxis();
        if (llllllllllllllIlIIlIllIllllIIlIl == EnumFacing.Axis.Z) {
            this.setBlockBounds(0.0f, 0.0f, 0.375f, 1.0f, 1.0f, 0.625f);
        }
        else {
            this.setBlockBounds(0.375f, 0.0f, 0.0f, 0.625f, 1.0f, 1.0f);
        }
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final World llllllllllllllIlIIlIllIlllllIIll, final BlockPos llllllllllllllIlIIlIllIlllllIIlI, final IBlockState llllllllllllllIlIIlIllIllllIlllI) {
        if (llllllllllllllIlIIlIllIllllIlllI.getValue(BlockFenceGate.field_176466_a)) {
            return null;
        }
        final EnumFacing.Axis llllllllllllllIlIIlIllIlllllIIII = ((EnumFacing)llllllllllllllIlIIlIllIllllIlllI.getValue(BlockFenceGate.AGE)).getAxis();
        return (llllllllllllllIlIIlIllIlllllIIII == EnumFacing.Axis.Z) ? new AxisAlignedBB(llllllllllllllIlIIlIllIlllllIIlI.getX(), llllllllllllllIlIIlIllIlllllIIlI.getY(), llllllllllllllIlIIlIllIlllllIIlI.getZ() + 0.375f, llllllllllllllIlIIlIllIlllllIIlI.getX() + 1, llllllllllllllIlIIlIllIlllllIIlI.getY() + 1.5f, llllllllllllllIlIIlIllIlllllIIlI.getZ() + 0.625f) : new AxisAlignedBB(llllllllllllllIlIIlIllIlllllIIlI.getX() + 0.375f, llllllllllllllIlIIlIllIlllllIIlI.getY(), llllllllllllllIlIIlIllIlllllIIlI.getZ(), llllllllllllllIlIIlIllIlllllIIlI.getX() + 0.625f, llllllllllllllIlIIlIllIlllllIIlI.getY() + 1.5f, llllllllllllllIlIIlIllIlllllIIlI.getZ() + 1);
    }
    
    public BlockFenceGate() {
        super(Material.wood);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockFenceGate.field_176466_a, false).withProperty(BlockFenceGate.field_176465_b, false).withProperty(BlockFenceGate.field_176467_M, false));
        this.setCreativeTab(CreativeTabs.tabRedstone);
    }
}
