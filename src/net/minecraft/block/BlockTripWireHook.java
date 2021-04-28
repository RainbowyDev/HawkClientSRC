package net.minecraft.block;

import net.minecraft.world.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import com.google.common.base.*;
import net.minecraft.item.*;

public class BlockTripWireHook extends Block
{
    public static final /* synthetic */ PropertyBool field_176263_b;
    public static final /* synthetic */ PropertyDirection field_176264_a;
    public static final /* synthetic */ PropertyBool field_176266_N;
    public static final /* synthetic */ PropertyBool field_176265_M;
    
    @Override
    public IBlockState getActualState(final IBlockState llllllllllllllllIlIIllIlIlIlIIll, final IBlockAccess llllllllllllllllIlIIllIlIlIlIIlI, final BlockPos llllllllllllllllIlIIllIlIlIIlllI) {
        return llllllllllllllllIlIIllIlIlIlIIll.withProperty(BlockTripWireHook.field_176266_N, !World.doesBlockHaveSolidTopSurface(llllllllllllllllIlIIllIlIlIlIIlI, llllllllllllllllIlIIllIlIlIIlllI.offsetDown()));
    }
    
    @Override
    public void updateTick(final World llllllllllllllllIlIIllIIIlIIIIII, final BlockPos llllllllllllllllIlIIllIIIIllllll, final IBlockState llllllllllllllllIlIIllIIIlIIIIll, final Random llllllllllllllllIlIIllIIIlIIIIlI) {
        this.func_176260_a(llllllllllllllllIlIIllIIIlIIIIII, llllllllllllllllIlIIllIIIIllllll, llllllllllllllllIlIIllIIIlIIIIll, false, true, -1, null);
    }
    
    @Override
    public boolean canProvidePower() {
        return true;
    }
    
    public BlockTripWireHook() {
        super(Material.circuits);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockTripWireHook.field_176264_a, EnumFacing.NORTH).withProperty(BlockTripWireHook.field_176263_b, false).withProperty(BlockTripWireHook.field_176265_M, false).withProperty(BlockTripWireHook.field_176266_N, false));
        this.setCreativeTab(CreativeTabs.tabRedstone);
        this.setTickRandomly(true);
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllllIlIIlIllllIllIII) {
        final byte llllllllllllllllIlIIlIllllIlIlll = 0;
        int llllllllllllllllIlIIlIllllIlIllI = llllllllllllllllIlIIlIllllIlIlll | ((EnumFacing)llllllllllllllllIlIIlIllllIllIII.getValue(BlockTripWireHook.field_176264_a)).getHorizontalIndex();
        if (llllllllllllllllIlIIlIllllIllIII.getValue(BlockTripWireHook.field_176263_b)) {
            llllllllllllllllIlIIlIllllIlIllI |= 0x8;
        }
        if (llllllllllllllllIlIIlIllllIllIII.getValue(BlockTripWireHook.field_176265_M)) {
            llllllllllllllllIlIIlIllllIlIllI |= 0x4;
        }
        return llllllllllllllllIlIIlIllllIlIllI;
    }
    
    @Override
    public IBlockState onBlockPlaced(final World llllllllllllllllIlIIllIlIIIllIll, final BlockPos llllllllllllllllIlIIllIlIIIllIIl, final EnumFacing llllllllllllllllIlIIllIlIIIlIlll, final float llllllllllllllllIlIIllIlIIIlIlIl, final float llllllllllllllllIlIIllIlIIIlIIll, final float llllllllllllllllIlIIllIlIIIlIIIl, final int llllllllllllllllIlIIllIlIIIIllll, final EntityLivingBase llllllllllllllllIlIIllIlIIIIllIl) {
        IBlockState llllllllllllllllIlIIllIlIIIIlIll = this.getDefaultState().withProperty(BlockTripWireHook.field_176263_b, false).withProperty(BlockTripWireHook.field_176265_M, false).withProperty(BlockTripWireHook.field_176266_N, false);
        if (llllllllllllllllIlIIllIlIIIlIlll.getAxis().isHorizontal()) {
            llllllllllllllllIlIIllIlIIIIlIll = llllllllllllllllIlIIllIlIIIIlIll.withProperty(BlockTripWireHook.field_176264_a, llllllllllllllllIlIIllIlIIIlIlll);
        }
        return llllllllllllllllIlIIllIlIIIIlIll;
    }
    
    static {
        __OBFID = "CL_00000329";
        field_176264_a = PropertyDirection.create("facing", (Predicate)EnumFacing.Plane.HORIZONTAL);
        field_176263_b = PropertyBool.create("powered");
        field_176265_M = PropertyBool.create("attached");
        field_176266_N = PropertyBool.create("suspended");
    }
    
    private void func_176262_b(final World llllllllllllllllIlIIllIIIIlIIlIl, final BlockPos llllllllllllllllIlIIllIIIIlIIIII, final EnumFacing llllllllllllllllIlIIllIIIIIlllll) {
        llllllllllllllllIlIIllIIIIlIIlIl.notifyNeighborsOfStateChange(llllllllllllllllIlIIllIIIIlIIIII, this);
        llllllllllllllllIlIIllIIIIlIIlIl.notifyNeighborsOfStateChange(llllllllllllllllIlIIllIIIIlIIIII.offset(llllllllllllllllIlIIllIIIIIlllll.getOpposite()), this);
    }
    
    @Override
    public boolean canPlaceBlockAt(final World llllllllllllllllIlIIllIlIIlIllII, final BlockPos llllllllllllllllIlIIllIlIIlIIlll) {
        for (final EnumFacing llllllllllllllllIlIIllIlIIlIlIIl : EnumFacing.Plane.HORIZONTAL) {
            if (llllllllllllllllIlIIllIlIIlIllII.getBlockState(llllllllllllllllIlIIllIlIIlIIlll.offset(llllllllllllllllIlIIllIlIIlIlIIl)).getBlock().isNormalCube()) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final World llllllllllllllllIlIIllIlIlIIlIll, final BlockPos llllllllllllllllIlIIllIlIlIIlIlI, final IBlockState llllllllllllllllIlIIllIlIlIIlIII) {
        return null;
    }
    
    @Override
    public int isProvidingStrongPower(final IBlockAccess llllllllllllllllIlIIlIlllllIlIlI, final BlockPos llllllllllllllllIlIIlIlllllIlIIl, final IBlockState llllllllllllllllIlIIlIlllllIlIII, final EnumFacing llllllllllllllllIlIIlIlllllIIlIl) {
        return llllllllllllllllIlIIlIlllllIlIII.getValue(BlockTripWireHook.field_176263_b) ? ((llllllllllllllllIlIIlIlllllIlIII.getValue(BlockTripWireHook.field_176264_a) == llllllllllllllllIlIIlIlllllIIlIl) ? 15 : 0) : 0;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllllIlIIlIllllIlllIl) {
        return this.getDefaultState().withProperty(BlockTripWireHook.field_176264_a, EnumFacing.getHorizontal(llllllllllllllllIlIIlIllllIlllIl & 0x3)).withProperty(BlockTripWireHook.field_176263_b, (llllllllllllllllIlIIlIllllIlllIl & 0x8) > 0).withProperty(BlockTripWireHook.field_176265_M, (llllllllllllllllIlIIlIllllIlllIl & 0x4) > 0);
    }
    
    private boolean func_176261_e(final World llllllllllllllllIlIIllIIIIIlIlIl, final BlockPos llllllllllllllllIlIIllIIIIIlIlII, final IBlockState llllllllllllllllIlIIllIIIIIlIlll) {
        if (!this.canPlaceBlockAt(llllllllllllllllIlIIllIIIIIlIlIl, llllllllllllllllIlIIllIIIIIlIlII)) {
            this.dropBlockAsItem(llllllllllllllllIlIIllIIIIIlIlIl, llllllllllllllllIlIIllIIIIIlIlII, llllllllllllllllIlIIllIIIIIlIlll, 0);
            llllllllllllllllIlIIllIIIIIlIlIl.setBlockToAir(llllllllllllllllIlIIllIIIIIlIlII);
            return false;
        }
        return true;
    }
    
    @Override
    public void breakBlock(final World llllllllllllllllIlIIlIllllllllll, final BlockPos llllllllllllllllIlIIlIlllllllIII, final IBlockState llllllllllllllllIlIIlIllllllIlll) {
        final boolean llllllllllllllllIlIIlIllllllllII = (boolean)llllllllllllllllIlIIlIllllllIlll.getValue(BlockTripWireHook.field_176265_M);
        final boolean llllllllllllllllIlIIlIlllllllIll = (boolean)llllllllllllllllIlIIlIllllllIlll.getValue(BlockTripWireHook.field_176263_b);
        if (llllllllllllllllIlIIlIllllllllII || llllllllllllllllIlIIlIlllllllIll) {
            this.func_176260_a(llllllllllllllllIlIIlIllllllllll, llllllllllllllllIlIIlIlllllllIII, llllllllllllllllIlIIlIllllllIlll, true, false, -1, null);
        }
        if (llllllllllllllllIlIIlIlllllllIll) {
            llllllllllllllllIlIIlIllllllllll.notifyNeighborsOfStateChange(llllllllllllllllIlIIlIlllllllIII, this);
            llllllllllllllllIlIIlIllllllllll.notifyNeighborsOfStateChange(llllllllllllllllIlIIlIlllllllIII.offset(((EnumFacing)llllllllllllllllIlIIlIllllllIlll.getValue(BlockTripWireHook.field_176264_a)).getOpposite()), this);
        }
        super.breakBlock(llllllllllllllllIlIIlIllllllllll, llllllllllllllllIlIIlIlllllllIII, llllllllllllllllIlIIlIllllllIlll);
    }
    
    @Override
    public void setBlockBoundsBasedOnState(final IBlockAccess llllllllllllllllIlIIllIIIIIIlIIl, final BlockPos llllllllllllllllIlIIllIIIIIIlIII) {
        final float llllllllllllllllIlIIllIIIIIIlIll = 0.1875f;
        switch (SwitchEnumFacing.field_177056_a[((EnumFacing)llllllllllllllllIlIIllIIIIIIlIIl.getBlockState(llllllllllllllllIlIIllIIIIIIlIII).getValue(BlockTripWireHook.field_176264_a)).ordinal()]) {
            case 1: {
                this.setBlockBounds(0.0f, 0.2f, 0.5f - llllllllllllllllIlIIllIIIIIIlIll, llllllllllllllllIlIIllIIIIIIlIll * 2.0f, 0.8f, 0.5f + llllllllllllllllIlIIllIIIIIIlIll);
                break;
            }
            case 2: {
                this.setBlockBounds(1.0f - llllllllllllllllIlIIllIIIIIIlIll * 2.0f, 0.2f, 0.5f - llllllllllllllllIlIIllIIIIIIlIll, 1.0f, 0.8f, 0.5f + llllllllllllllllIlIIllIIIIIIlIll);
                break;
            }
            case 3: {
                this.setBlockBounds(0.5f - llllllllllllllllIlIIllIIIIIIlIll, 0.2f, 0.0f, 0.5f + llllllllllllllllIlIIllIIIIIIlIll, 0.8f, llllllllllllllllIlIIllIIIIIIlIll * 2.0f);
                break;
            }
            case 4: {
                this.setBlockBounds(0.5f - llllllllllllllllIlIIllIIIIIIlIll, 0.2f, 1.0f - llllllllllllllllIlIIllIIIIIIlIll * 2.0f, 0.5f + llllllllllllllllIlIIllIIIIIIlIll, 0.8f, 1.0f);
                break;
            }
        }
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockTripWireHook.field_176264_a, BlockTripWireHook.field_176263_b, BlockTripWireHook.field_176265_M, BlockTripWireHook.field_176266_N });
    }
    
    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.CUTOUT_MIPPED;
    }
    
    @Override
    public void onNeighborBlockChange(final World llllllllllllllllIlIIllIIllIllIll, final BlockPos llllllllllllllllIlIIllIIllIlIIII, final IBlockState llllllllllllllllIlIIllIIllIllIIl, final Block llllllllllllllllIlIIllIIllIllIII) {
        if (llllllllllllllllIlIIllIIllIllIII != this && this.func_176261_e(llllllllllllllllIlIIllIIllIllIll, llllllllllllllllIlIIllIIllIlIIII, llllllllllllllllIlIIllIIllIllIIl)) {
            final EnumFacing llllllllllllllllIlIIllIIllIlIllI = (EnumFacing)llllllllllllllllIlIIllIIllIllIIl.getValue(BlockTripWireHook.field_176264_a);
            if (!llllllllllllllllIlIIllIIllIllIll.getBlockState(llllllllllllllllIlIIllIIllIlIIII.offset(llllllllllllllllIlIIllIIllIlIllI.getOpposite())).getBlock().isNormalCube()) {
                this.dropBlockAsItem(llllllllllllllllIlIIllIIllIllIll, llllllllllllllllIlIIllIIllIlIIII, llllllllllllllllIlIIllIIllIllIIl, 0);
                llllllllllllllllIlIIllIIllIllIll.setBlockToAir(llllllllllllllllIlIIllIIllIlIIII);
            }
        }
    }
    
    @Override
    public void randomTick(final World llllllllllllllllIlIIllIIIlIIlllI, final BlockPos llllllllllllllllIlIIllIIIlIIllIl, final IBlockState llllllllllllllllIlIIllIIIlIIllII, final Random llllllllllllllllIlIIllIIIlIIlIll) {
    }
    
    @Override
    public int isProvidingWeakPower(final IBlockAccess llllllllllllllllIlIIlIllllllIIlI, final BlockPos llllllllllllllllIlIIlIllllllIIIl, final IBlockState llllllllllllllllIlIIlIllllllIIII, final EnumFacing llllllllllllllllIlIIlIlllllIllll) {
        return llllllllllllllllIlIIlIllllllIIII.getValue(BlockTripWireHook.field_176263_b) ? 15 : 0;
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    private void func_180694_a(final World llllllllllllllllIlIIllIIIIllIllI, final BlockPos llllllllllllllllIlIIllIIIIlIllll, final boolean llllllllllllllllIlIIllIIIIlIlllI, final boolean llllllllllllllllIlIIllIIIIlIllIl, final boolean llllllllllllllllIlIIllIIIIlIllII, final boolean llllllllllllllllIlIIllIIIIllIIIl) {
        if (llllllllllllllllIlIIllIIIIlIllIl && !llllllllllllllllIlIIllIIIIllIIIl) {
            llllllllllllllllIlIIllIIIIllIllI.playSoundEffect(llllllllllllllllIlIIllIIIIlIllll.getX() + 0.5, llllllllllllllllIlIIllIIIIlIllll.getY() + 0.1, llllllllllllllllIlIIllIIIIlIllll.getZ() + 0.5, "random.click", 0.4f, 0.6f);
        }
        else if (!llllllllllllllllIlIIllIIIIlIllIl && llllllllllllllllIlIIllIIIIllIIIl) {
            llllllllllllllllIlIIllIIIIllIllI.playSoundEffect(llllllllllllllllIlIIllIIIIlIllll.getX() + 0.5, llllllllllllllllIlIIllIIIIlIllll.getY() + 0.1, llllllllllllllllIlIIllIIIIlIllll.getZ() + 0.5, "random.click", 0.4f, 0.5f);
        }
        else if (llllllllllllllllIlIIllIIIIlIlllI && !llllllllllllllllIlIIllIIIIlIllII) {
            llllllllllllllllIlIIllIIIIllIllI.playSoundEffect(llllllllllllllllIlIIllIIIIlIllll.getX() + 0.5, llllllllllllllllIlIIllIIIIlIllll.getY() + 0.1, llllllllllllllllIlIIllIIIIlIllll.getZ() + 0.5, "random.click", 0.4f, 0.7f);
        }
        else if (!llllllllllllllllIlIIllIIIIlIlllI && llllllllllllllllIlIIllIIIIlIllII) {
            llllllllllllllllIlIIllIIIIllIllI.playSoundEffect(llllllllllllllllIlIIllIIIIlIllll.getX() + 0.5, llllllllllllllllIlIIllIIIIlIllll.getY() + 0.1, llllllllllllllllIlIIllIIIIlIllll.getZ() + 0.5, "random.bowhit", 0.4f, 1.2f / (llllllllllllllllIlIIllIIIIllIllI.rand.nextFloat() * 0.2f + 0.9f));
        }
    }
    
    public void func_176260_a(final World llllllllllllllllIlIIllIIIllIIlII, final BlockPos llllllllllllllllIlIIllIIIllIIIll, final IBlockState llllllllllllllllIlIIllIIIllllllI, final boolean llllllllllllllllIlIIllIIIllIIIIl, final boolean llllllllllllllllIlIIllIIIlllllII, final int llllllllllllllllIlIIllIIIlIlllll, final IBlockState llllllllllllllllIlIIllIIIlIllllI) {
        final EnumFacing llllllllllllllllIlIIllIIIllllIIl = (EnumFacing)llllllllllllllllIlIIllIIIllllllI.getValue(BlockTripWireHook.field_176264_a);
        final boolean llllllllllllllllIlIIllIIIllllIII = (boolean)llllllllllllllllIlIIllIIIllllllI.getValue(BlockTripWireHook.field_176265_M);
        final boolean llllllllllllllllIlIIllIIIlllIlll = (boolean)llllllllllllllllIlIIllIIIllllllI.getValue(BlockTripWireHook.field_176263_b);
        final boolean llllllllllllllllIlIIllIIIlllIllI = !World.doesBlockHaveSolidTopSurface(llllllllllllllllIlIIllIIIllIIlII, llllllllllllllllIlIIllIIIllIIIll.offsetDown());
        boolean llllllllllllllllIlIIllIIIlllIlIl = !llllllllllllllllIlIIllIIIllIIIIl;
        boolean llllllllllllllllIlIIllIIIlllIlII = false;
        int llllllllllllllllIlIIllIIIlllIIll = 0;
        final IBlockState[] llllllllllllllllIlIIllIIIlllIIlI = new IBlockState[42];
        int llllllllllllllllIlIIllIIIllIllll = 1;
        while (llllllllllllllllIlIIllIIIllIllll < 42) {
            final BlockPos llllllllllllllllIlIIllIIIlllIIIl = llllllllllllllllIlIIllIIIllIIIll.offset(llllllllllllllllIlIIllIIIllllIIl, llllllllllllllllIlIIllIIIllIllll);
            IBlockState llllllllllllllllIlIIllIIIllIlllI = llllllllllllllllIlIIllIIIllIIlII.getBlockState(llllllllllllllllIlIIllIIIlllIIIl);
            if (llllllllllllllllIlIIllIIIllIlllI.getBlock() == Blocks.tripwire_hook) {
                if (llllllllllllllllIlIIllIIIllIlllI.getValue(BlockTripWireHook.field_176264_a) == llllllllllllllllIlIIllIIIllllIIl.getOpposite()) {
                    llllllllllllllllIlIIllIIIlllIIll = llllllllllllllllIlIIllIIIllIllll;
                    break;
                }
                break;
            }
            else {
                if (llllllllllllllllIlIIllIIIllIlllI.getBlock() != Blocks.tripwire && llllllllllllllllIlIIllIIIllIllll != llllllllllllllllIlIIllIIIlIlllll) {
                    llllllllllllllllIlIIllIIIlllIIlI[llllllllllllllllIlIIllIIIllIllll] = null;
                    llllllllllllllllIlIIllIIIlllIlIl = false;
                }
                else {
                    if (llllllllllllllllIlIIllIIIllIllll == llllllllllllllllIlIIllIIIlIlllll) {
                        llllllllllllllllIlIIllIIIllIlllI = (IBlockState)Objects.firstNonNull((Object)llllllllllllllllIlIIllIIIlIllllI, (Object)llllllllllllllllIlIIllIIIllIlllI);
                    }
                    final boolean llllllllllllllllIlIIllIIIllIllIl = !(boolean)llllllllllllllllIlIIllIIIllIlllI.getValue(BlockTripWire.field_176295_N);
                    final boolean llllllllllllllllIlIIllIIIllIllII = (boolean)llllllllllllllllIlIIllIIIllIlllI.getValue(BlockTripWire.field_176293_a);
                    final boolean llllllllllllllllIlIIllIIIllIlIll = (boolean)llllllllllllllllIlIIllIIIllIlllI.getValue(BlockTripWire.field_176290_b);
                    llllllllllllllllIlIIllIIIlllIlIl &= (llllllllllllllllIlIIllIIIllIlIll == llllllllllllllllIlIIllIIIlllIllI);
                    llllllllllllllllIlIIllIIIlllIlII |= (llllllllllllllllIlIIllIIIllIllIl && llllllllllllllllIlIIllIIIllIllII);
                    llllllllllllllllIlIIllIIIlllIIlI[llllllllllllllllIlIIllIIIllIllll] = llllllllllllllllIlIIllIIIllIlllI;
                    if (llllllllllllllllIlIIllIIIllIllll == llllllllllllllllIlIIllIIIlIlllll) {
                        llllllllllllllllIlIIllIIIllIIlII.scheduleUpdate(llllllllllllllllIlIIllIIIllIIIll, this, this.tickRate(llllllllllllllllIlIIllIIIllIIlII));
                        llllllllllllllllIlIIllIIIlllIlIl &= llllllllllllllllIlIIllIIIllIllIl;
                    }
                }
                ++llllllllllllllllIlIIllIIIllIllll;
            }
        }
        llllllllllllllllIlIIllIIIlllIlIl &= (llllllllllllllllIlIIllIIIlllIIll > 1);
        llllllllllllllllIlIIllIIIlllIlII &= llllllllllllllllIlIIllIIIlllIlIl;
        final IBlockState llllllllllllllllIlIIllIIIllIlIlI = this.getDefaultState().withProperty(BlockTripWireHook.field_176265_M, llllllllllllllllIlIIllIIIlllIlIl).withProperty(BlockTripWireHook.field_176263_b, llllllllllllllllIlIIllIIIlllIlII);
        if (llllllllllllllllIlIIllIIIlllIIll > 0) {
            final BlockPos llllllllllllllllIlIIllIIIlllIIII = llllllllllllllllIlIIllIIIllIIIll.offset(llllllllllllllllIlIIllIIIllllIIl, llllllllllllllllIlIIllIIIlllIIll);
            final EnumFacing llllllllllllllllIlIIllIIIllIlIIl = llllllllllllllllIlIIllIIIllllIIl.getOpposite();
            llllllllllllllllIlIIllIIIllIIlII.setBlockState(llllllllllllllllIlIIllIIIlllIIII, llllllllllllllllIlIIllIIIllIlIlI.withProperty(BlockTripWireHook.field_176264_a, llllllllllllllllIlIIllIIIllIlIIl), 3);
            this.func_176262_b(llllllllllllllllIlIIllIIIllIIlII, llllllllllllllllIlIIllIIIlllIIII, llllllllllllllllIlIIllIIIllIlIIl);
            this.func_180694_a(llllllllllllllllIlIIllIIIllIIlII, llllllllllllllllIlIIllIIIlllIIII, llllllllllllllllIlIIllIIIlllIlIl, llllllllllllllllIlIIllIIIlllIlII, llllllllllllllllIlIIllIIIllllIII, llllllllllllllllIlIIllIIIlllIlll);
        }
        this.func_180694_a(llllllllllllllllIlIIllIIIllIIlII, llllllllllllllllIlIIllIIIllIIIll, llllllllllllllllIlIIllIIIlllIlIl, llllllllllllllllIlIIllIIIlllIlII, llllllllllllllllIlIIllIIIllllIII, llllllllllllllllIlIIllIIIlllIlll);
        if (!llllllllllllllllIlIIllIIIllIIIIl) {
            llllllllllllllllIlIIllIIIllIIlII.setBlockState(llllllllllllllllIlIIllIIIllIIIll, llllllllllllllllIlIIllIIIllIlIlI.withProperty(BlockTripWireHook.field_176264_a, llllllllllllllllIlIIllIIIllllIIl), 3);
            if (llllllllllllllllIlIIllIIIlllllII) {
                this.func_176262_b(llllllllllllllllIlIIllIIIllIIlII, llllllllllllllllIlIIllIIIllIIIll, llllllllllllllllIlIIllIIIllllIIl);
            }
        }
        if (llllllllllllllllIlIIllIIIllllIII != llllllllllllllllIlIIllIIIlllIlIl) {
            for (int llllllllllllllllIlIIllIIIllIlIII = 1; llllllllllllllllIlIIllIIIllIlIII < llllllllllllllllIlIIllIIIlllIIll; ++llllllllllllllllIlIIllIIIllIlIII) {
                final BlockPos llllllllllllllllIlIIllIIIllIIlll = llllllllllllllllIlIIllIIIllIIIll.offset(llllllllllllllllIlIIllIIIllllIIl, llllllllllllllllIlIIllIIIllIlIII);
                final IBlockState llllllllllllllllIlIIllIIIllIIllI = llllllllllllllllIlIIllIIIlllIIlI[llllllllllllllllIlIIllIIIllIlIII];
                if (llllllllllllllllIlIIllIIIllIIllI != null && llllllllllllllllIlIIllIIIllIIlII.getBlockState(llllllllllllllllIlIIllIIIllIIlll).getBlock() != Blocks.air) {
                    llllllllllllllllIlIIllIIIllIIlII.setBlockState(llllllllllllllllIlIIllIIIllIIlll, llllllllllllllllIlIIllIIIllIIllI.withProperty(BlockTripWireHook.field_176265_M, llllllllllllllllIlIIllIIIlllIlIl), 3);
                }
            }
        }
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public boolean canPlaceBlockOnSide(final World llllllllllllllllIlIIllIlIIllIlll, final BlockPos llllllllllllllllIlIIllIlIIllIIll, final EnumFacing llllllllllllllllIlIIllIlIIllIlIl) {
        return llllllllllllllllIlIIllIlIIllIlIl.getAxis().isHorizontal() && llllllllllllllllIlIIllIlIIllIlll.getBlockState(llllllllllllllllIlIIllIlIIllIIll.offset(llllllllllllllllIlIIllIlIIllIlIl.getOpposite())).getBlock().isNormalCube();
    }
    
    @Override
    public void onBlockPlacedBy(final World llllllllllllllllIlIIllIIllllIlII, final BlockPos llllllllllllllllIlIIllIIlllIlIll, final IBlockState llllllllllllllllIlIIllIIlllIlIlI, final EntityLivingBase llllllllllllllllIlIIllIIlllIllll, final ItemStack llllllllllllllllIlIIllIIlllIlllI) {
        this.func_176260_a(llllllllllllllllIlIIllIIllllIlII, llllllllllllllllIlIIllIIlllIlIll, llllllllllllllllIlIIllIIlllIlIlI, false, false, -1, null);
    }
    
    static final class SwitchEnumFacing
    {
        static final /* synthetic */ int[] field_177056_a;
        
        static {
            __OBFID = "CL_00002050";
            field_177056_a = new int[EnumFacing.values().length];
            try {
                SwitchEnumFacing.field_177056_a[EnumFacing.EAST.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumFacing.field_177056_a[EnumFacing.WEST.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumFacing.field_177056_a[EnumFacing.SOUTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchEnumFacing.field_177056_a[EnumFacing.NORTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
        }
    }
}
