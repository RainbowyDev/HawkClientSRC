package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;

public class BlockTripWire extends Block
{
    public static final /* synthetic */ PropertyBool field_176294_M;
    public static final /* synthetic */ PropertyBool field_176289_Q;
    public static final /* synthetic */ PropertyBool field_176293_a;
    public static final /* synthetic */ PropertyBool field_176292_R;
    public static final /* synthetic */ PropertyBool field_176291_P;
    public static final /* synthetic */ PropertyBool field_176290_b;
    public static final /* synthetic */ PropertyBool field_176295_N;
    public static final /* synthetic */ PropertyBool field_176296_O;
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllllIlIllIllIIlIllI) {
        int lllllllllllllllllIlIllIllIIlIlIl = 0;
        if (lllllllllllllllllIlIllIllIIlIllI.getValue(BlockTripWire.field_176293_a)) {
            lllllllllllllllllIlIllIllIIlIlIl |= 0x1;
        }
        if (lllllllllllllllllIlIllIllIIlIllI.getValue(BlockTripWire.field_176290_b)) {
            lllllllllllllllllIlIllIllIIlIlIl |= 0x2;
        }
        if (lllllllllllllllllIlIllIllIIlIllI.getValue(BlockTripWire.field_176294_M)) {
            lllllllllllllllllIlIllIllIIlIlIl |= 0x4;
        }
        if (lllllllllllllllllIlIllIllIIlIllI.getValue(BlockTripWire.field_176295_N)) {
            lllllllllllllllllIlIllIllIIlIlIl |= 0x8;
        }
        return lllllllllllllllllIlIllIllIIlIlIl;
    }
    
    @Override
    public void onEntityCollidedWithBlock(final World lllllllllllllllllIlIllIllllIlIIl, final BlockPos lllllllllllllllllIlIllIllllIllIl, final IBlockState lllllllllllllllllIlIllIllllIIlll, final Entity lllllllllllllllllIlIllIllllIlIll) {
        if (!lllllllllllllllllIlIllIllllIlIIl.isRemote && !(boolean)lllllllllllllllllIlIllIllllIIlll.getValue(BlockTripWire.field_176293_a)) {
            this.func_176288_d(lllllllllllllllllIlIllIllllIlIIl, lllllllllllllllllIlIllIllllIllIl);
        }
    }
    
    private void func_176288_d(final World lllllllllllllllllIlIllIlllIIllII, final BlockPos lllllllllllllllllIlIllIlllIIIIlI) {
        IBlockState lllllllllllllllllIlIllIlllIIlIlI = lllllllllllllllllIlIllIlllIIllII.getBlockState(lllllllllllllllllIlIllIlllIIIIlI);
        final boolean lllllllllllllllllIlIllIlllIIlIIl = (boolean)lllllllllllllllllIlIllIlllIIlIlI.getValue(BlockTripWire.field_176293_a);
        boolean lllllllllllllllllIlIllIlllIIlIII = false;
        final List lllllllllllllllllIlIllIlllIIIlll = lllllllllllllllllIlIllIlllIIllII.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(lllllllllllllllllIlIllIlllIIIIlI.getX() + this.minX, lllllllllllllllllIlIllIlllIIIIlI.getY() + this.minY, lllllllllllllllllIlIllIlllIIIIlI.getZ() + this.minZ, lllllllllllllllllIlIllIlllIIIIlI.getX() + this.maxX, lllllllllllllllllIlIllIlllIIIIlI.getY() + this.maxY, lllllllllllllllllIlIllIlllIIIIlI.getZ() + this.maxZ));
        if (!lllllllllllllllllIlIllIlllIIIlll.isEmpty()) {
            for (final Entity lllllllllllllllllIlIllIlllIIIlIl : lllllllllllllllllIlIllIlllIIIlll) {
                if (!lllllllllllllllllIlIllIlllIIIlIl.doesEntityNotTriggerPressurePlate()) {
                    lllllllllllllllllIlIllIlllIIlIII = true;
                    break;
                }
            }
        }
        if (lllllllllllllllllIlIllIlllIIlIII != lllllllllllllllllIlIllIlllIIlIIl) {
            lllllllllllllllllIlIllIlllIIlIlI = lllllllllllllllllIlIllIlllIIlIlI.withProperty(BlockTripWire.field_176293_a, lllllllllllllllllIlIllIlllIIlIII);
            lllllllllllllllllIlIllIlllIIllII.setBlockState(lllllllllllllllllIlIllIlllIIIIlI, lllllllllllllllllIlIllIlllIIlIlI, 3);
            this.func_176286_e(lllllllllllllllllIlIllIlllIIllII, lllllllllllllllllIlIllIlllIIIIlI, lllllllllllllllllIlIllIlllIIlIlI);
        }
        if (lllllllllllllllllIlIllIlllIIlIII) {
            lllllllllllllllllIlIllIlllIIllII.scheduleUpdate(lllllllllllllllllIlIllIlllIIIIlI, this, this.tickRate(lllllllllllllllllIlIllIlllIIllII));
        }
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    @Override
    public void onBlockHarvested(final World lllllllllllllllllIlIlllIIIIlIllI, final BlockPos lllllllllllllllllIlIlllIIIIlIlIl, final IBlockState lllllllllllllllllIlIlllIIIIllIII, final EntityPlayer lllllllllllllllllIlIlllIIIIlIlll) {
        if (!lllllllllllllllllIlIlllIIIIlIllI.isRemote && lllllllllllllllllIlIlllIIIIlIlll.getCurrentEquippedItem() != null && lllllllllllllllllIlIlllIIIIlIlll.getCurrentEquippedItem().getItem() == Items.shears) {
            lllllllllllllllllIlIlllIIIIlIllI.setBlockState(lllllllllllllllllIlIlllIIIIlIlIl, lllllllllllllllllIlIlllIIIIllIII.withProperty(BlockTripWire.field_176295_N, true), 4);
        }
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockTripWire.field_176293_a, BlockTripWire.field_176290_b, BlockTripWire.field_176294_M, BlockTripWire.field_176295_N, BlockTripWire.field_176296_O, BlockTripWire.field_176291_P, BlockTripWire.field_176292_R, BlockTripWire.field_176289_Q });
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllllIlIllIllIIlllII) {
        return this.getDefaultState().withProperty(BlockTripWire.field_176293_a, (lllllllllllllllllIlIllIllIIlllII & 0x1) > 0).withProperty(BlockTripWire.field_176290_b, (lllllllllllllllllIlIllIllIIlllII & 0x2) > 0).withProperty(BlockTripWire.field_176294_M, (lllllllllllllllllIlIllIllIIlllII & 0x4) > 0).withProperty(BlockTripWire.field_176295_N, (lllllllllllllllllIlIllIllIIlllII & 0x8) > 0);
    }
    
    private void func_176286_e(final World lllllllllllllllllIlIllIlllllllIl, final BlockPos lllllllllllllllllIlIllIlllllllII, final IBlockState lllllllllllllllllIlIllIllllllIll) {
        for (final EnumFacing lllllllllllllllllIlIlllIIIIIIIIl : new EnumFacing[] { EnumFacing.SOUTH, EnumFacing.WEST }) {
            int lllllllllllllllllIlIlllIIIIIIIII = 1;
            while (lllllllllllllllllIlIlllIIIIIIIII < 42) {
                final BlockPos lllllllllllllllllIlIllIlllllllll = lllllllllllllllllIlIllIlllllllII.offset(lllllllllllllllllIlIlllIIIIIIIIl, lllllllllllllllllIlIlllIIIIIIIII);
                final IBlockState lllllllllllllllllIlIllIllllllllI = lllllllllllllllllIlIllIlllllllIl.getBlockState(lllllllllllllllllIlIllIlllllllll);
                if (lllllllllllllllllIlIllIllllllllI.getBlock() == Blocks.tripwire_hook) {
                    if (lllllllllllllllllIlIllIllllllllI.getValue(BlockTripWireHook.field_176264_a) == lllllllllllllllllIlIlllIIIIIIIIl.getOpposite()) {
                        Blocks.tripwire_hook.func_176260_a(lllllllllllllllllIlIllIlllllllIl, lllllllllllllllllIlIllIlllllllll, lllllllllllllllllIlIllIllllllllI, false, true, lllllllllllllllllIlIlllIIIIIIIII, lllllllllllllllllIlIllIllllllIll);
                        break;
                    }
                    break;
                }
                else {
                    if (lllllllllllllllllIlIllIllllllllI.getBlock() != Blocks.tripwire) {
                        break;
                    }
                    ++lllllllllllllllllIlIlllIIIIIIIII;
                }
            }
        }
    }
    
    static {
        __OBFID = "CL_00000328";
        field_176293_a = PropertyBool.create("powered");
        field_176290_b = PropertyBool.create("suspended");
        field_176294_M = PropertyBool.create("attached");
        field_176295_N = PropertyBool.create("disarmed");
        field_176296_O = PropertyBool.create("north");
        field_176291_P = PropertyBool.create("east");
        field_176289_Q = PropertyBool.create("south");
        field_176292_R = PropertyBool.create("west");
    }
    
    @Override
    public IBlockState getActualState(final IBlockState lllllllllllllllllIlIlllIIllIllIl, final IBlockAccess lllllllllllllllllIlIlllIIllIllII, final BlockPos lllllllllllllllllIlIlllIIllIlIll) {
        return lllllllllllllllllIlIlllIIllIllIl.withProperty(BlockTripWire.field_176296_O, func_176287_c(lllllllllllllllllIlIlllIIllIllII, lllllllllllllllllIlIlllIIllIlIll, lllllllllllllllllIlIlllIIllIllIl, EnumFacing.NORTH)).withProperty(BlockTripWire.field_176291_P, func_176287_c(lllllllllllllllllIlIlllIIllIllII, lllllllllllllllllIlIlllIIllIlIll, lllllllllllllllllIlIlllIIllIllIl, EnumFacing.EAST)).withProperty(BlockTripWire.field_176289_Q, func_176287_c(lllllllllllllllllIlIlllIIllIllII, lllllllllllllllllIlIlllIIllIlIll, lllllllllllllllllIlIlllIIllIllIl, EnumFacing.SOUTH)).withProperty(BlockTripWire.field_176292_R, func_176287_c(lllllllllllllllllIlIlllIIllIllII, lllllllllllllllllIlIlllIIllIlIll, lllllllllllllllllIlIlllIIllIllIl, EnumFacing.WEST));
    }
    
    @Override
    public void breakBlock(final World lllllllllllllllllIlIlllIIIlIIllI, final BlockPos lllllllllllllllllIlIlllIIIlIIlIl, final IBlockState lllllllllllllllllIlIlllIIIlIIlII) {
        this.func_176286_e(lllllllllllllllllIlIlllIIIlIIllI, lllllllllllllllllIlIlllIIIlIIlIl, lllllllllllllllllIlIlllIIIlIIlII.withProperty(BlockTripWire.field_176293_a, true));
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllllllIlIlllIIllIIIlI, final Random lllllllllllllllllIlIlllIIllIIIIl, final int lllllllllllllllllIlIlllIIllIIIII) {
        return Items.string;
    }
    
    @Override
    public void onNeighborBlockChange(final World lllllllllllllllllIlIlllIIlIlIlIl, final BlockPos lllllllllllllllllIlIlllIIlIlIlII, final IBlockState lllllllllllllllllIlIlllIIlIlIIll, final Block lllllllllllllllllIlIlllIIlIlIIlI) {
        final boolean lllllllllllllllllIlIlllIIlIlIIIl = (boolean)lllllllllllllllllIlIlllIIlIlIIll.getValue(BlockTripWire.field_176290_b);
        final boolean lllllllllllllllllIlIlllIIlIlIIII = !World.doesBlockHaveSolidTopSurface(lllllllllllllllllIlIlllIIlIlIlIl, lllllllllllllllllIlIlllIIlIlIlII.offsetDown());
        if (lllllllllllllllllIlIlllIIlIlIIIl != lllllllllllllllllIlIlllIIlIlIIII) {
            this.dropBlockAsItem(lllllllllllllllllIlIlllIIlIlIlIl, lllllllllllllllllIlIlllIIlIlIlII, lllllllllllllllllIlIlllIIlIlIIll, 0);
            lllllllllllllllllIlIlllIIlIlIlIl.setBlockToAir(lllllllllllllllllIlIlllIIlIlIlII);
        }
    }
    
    @Override
    public void setBlockBoundsBasedOnState(final IBlockAccess lllllllllllllllllIlIlllIIIllllII, final BlockPos lllllllllllllllllIlIlllIIIlllIll) {
        final IBlockState lllllllllllllllllIlIlllIIlIIIIII = lllllllllllllllllIlIlllIIIllllII.getBlockState(lllllllllllllllllIlIlllIIIlllIll);
        final boolean lllllllllllllllllIlIlllIIIllllll = (boolean)lllllllllllllllllIlIlllIIlIIIIII.getValue(BlockTripWire.field_176294_M);
        final boolean lllllllllllllllllIlIlllIIIlllllI = (boolean)lllllllllllllllllIlIlllIIlIIIIII.getValue(BlockTripWire.field_176290_b);
        if (!lllllllllllllllllIlIlllIIIlllllI) {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.09375f, 1.0f);
        }
        else if (!lllllllllllllllllIlIlllIIIllllll) {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.5f, 1.0f);
        }
        else {
            this.setBlockBounds(0.0f, 0.0625f, 0.0f, 1.0f, 0.15625f, 1.0f);
        }
    }
    
    public static boolean func_176287_c(final IBlockAccess lllllllllllllllllIlIllIllIllIIlI, final BlockPos lllllllllllllllllIlIllIllIllIIIl, final IBlockState lllllllllllllllllIlIllIllIlIIllI, final EnumFacing lllllllllllllllllIlIllIllIlIIlIl) {
        final BlockPos lllllllllllllllllIlIllIllIlIlllI = lllllllllllllllllIlIllIllIllIIIl.offset(lllllllllllllllllIlIllIllIlIIlIl);
        final IBlockState lllllllllllllllllIlIllIllIlIllIl = lllllllllllllllllIlIllIllIllIIlI.getBlockState(lllllllllllllllllIlIllIllIlIlllI);
        final Block lllllllllllllllllIlIllIllIlIllII = lllllllllllllllllIlIllIllIlIllIl.getBlock();
        if (lllllllllllllllllIlIllIllIlIllII == Blocks.tripwire_hook) {
            final EnumFacing lllllllllllllllllIlIllIllIlIlIll = lllllllllllllllllIlIllIllIlIIlIl.getOpposite();
            return lllllllllllllllllIlIllIllIlIllIl.getValue(BlockTripWireHook.field_176264_a) == lllllllllllllllllIlIllIllIlIlIll;
        }
        if (lllllllllllllllllIlIllIllIlIllII == Blocks.tripwire) {
            final boolean lllllllllllllllllIlIllIllIlIlIlI = (boolean)lllllllllllllllllIlIllIllIlIIllI.getValue(BlockTripWire.field_176290_b);
            final boolean lllllllllllllllllIlIllIllIlIlIIl = (boolean)lllllllllllllllllIlIllIllIlIllIl.getValue(BlockTripWire.field_176290_b);
            return lllllllllllllllllIlIllIllIlIlIlI == lllllllllllllllllIlIllIllIlIlIIl;
        }
        return false;
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final World lllllllllllllllllIlIlllIIllIlIIl, final BlockPos lllllllllllllllllIlIlllIIllIlIII, final IBlockState lllllllllllllllllIlIlllIIllIIlll) {
        return null;
    }
    
    @Override
    public void randomTick(final World lllllllllllllllllIlIllIllllIIlIl, final BlockPos lllllllllllllllllIlIllIllllIIlII, final IBlockState lllllllllllllllllIlIllIllllIIIll, final Random lllllllllllllllllIlIllIllllIIIlI) {
    }
    
    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.TRANSLUCENT;
    }
    
    @Override
    public void onBlockAdded(final World lllllllllllllllllIlIlllIIIlIlllI, final BlockPos lllllllllllllllllIlIlllIIIllIIIl, IBlockState lllllllllllllllllIlIlllIIIlIllII) {
        lllllllllllllllllIlIlllIIIlIllII = (boolean)((IBlockState)lllllllllllllllllIlIlllIIIlIllII).withProperty(BlockTripWire.field_176290_b, !World.doesBlockHaveSolidTopSurface(lllllllllllllllllIlIlllIIIlIlllI, lllllllllllllllllIlIlllIIIllIIIl.offsetDown()));
        lllllllllllllllllIlIlllIIIlIlllI.setBlockState(lllllllllllllllllIlIlllIIIllIIIl, (IBlockState)lllllllllllllllllIlIlllIIIlIllII, 3);
        this.func_176286_e(lllllllllllllllllIlIlllIIIlIlllI, lllllllllllllllllIlIlllIIIllIIIl, (IBlockState)lllllllllllllllllIlIlllIIIlIllII);
    }
    
    @Override
    public Item getItem(final World lllllllllllllllllIlIlllIIlIllllI, final BlockPos lllllllllllllllllIlIlllIIlIlllIl) {
        return Items.string;
    }
    
    @Override
    public void updateTick(final World lllllllllllllllllIlIllIlllIlllIl, final BlockPos lllllllllllllllllIlIllIlllIlllII, final IBlockState lllllllllllllllllIlIllIlllIllIll, final Random lllllllllllllllllIlIllIlllIllIlI) {
        if (!lllllllllllllllllIlIllIlllIlllIl.isRemote && (boolean)lllllllllllllllllIlIllIlllIlllIl.getBlockState(lllllllllllllllllIlIllIlllIlllII).getValue(BlockTripWire.field_176293_a)) {
            this.func_176288_d(lllllllllllllllllIlIllIlllIlllIl, lllllllllllllllllIlIllIlllIlllII);
        }
    }
    
    public BlockTripWire() {
        super(Material.circuits);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockTripWire.field_176293_a, false).withProperty(BlockTripWire.field_176290_b, false).withProperty(BlockTripWire.field_176294_M, false).withProperty(BlockTripWire.field_176295_N, false).withProperty(BlockTripWire.field_176296_O, false).withProperty(BlockTripWire.field_176291_P, false).withProperty(BlockTripWire.field_176289_Q, false).withProperty(BlockTripWire.field_176292_R, false));
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.15625f, 1.0f);
        this.setTickRandomly(true);
    }
}
