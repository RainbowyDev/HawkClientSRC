package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import java.util.*;
import net.minecraft.block.material.*;
import com.google.common.collect.*;
import net.minecraft.util.*;

public class BlockRedstoneWire extends Block
{
    private final /* synthetic */ Set field_150179_b;
    public static final /* synthetic */ PropertyEnum NORTH;
    public static final /* synthetic */ PropertyEnum SOUTH;
    public static final /* synthetic */ PropertyEnum WEST;
    public static final /* synthetic */ PropertyEnum EAST;
    public static final /* synthetic */ PropertyInteger POWER;
    private /* synthetic */ boolean canProvidePower;
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIIlIIIlllIIlIIlIII) {
        return (int)llllllllllllllIIlIIIlllIIlIIlIII.getValue(BlockRedstoneWire.POWER);
    }
    
    @Override
    public int isProvidingStrongPower(final IBlockAccess llllllllllllllIIlIIIlllIlllIIIlI, final BlockPos llllllllllllllIIlIIIlllIlllIIIIl, final IBlockState llllllllllllllIIlIIIlllIlllIIIII, final EnumFacing llllllllllllllIIlIIIlllIlllIIlII) {
        return this.canProvidePower ? this.isProvidingWeakPower(llllllllllllllIIlIIIlllIlllIIIlI, llllllllllllllIIlIIIlllIlllIIIIl, llllllllllllllIIlIIIlllIlllIIIII, llllllllllllllIIlIIIlllIlllIIlII) : 0;
    }
    
    private int func_176342_a(final World llllllllllllllIIlIIIllllIIIIIIlI, final BlockPos llllllllllllllIIlIIIllllIIIIIIIl, final int llllllllllllllIIlIIIllllIIIIIlIl) {
        if (llllllllllllllIIlIIIllllIIIIIIlI.getBlockState(llllllllllllllIIlIIIllllIIIIIIIl).getBlock() != this) {
            return llllllllllllllIIlIIIllllIIIIIlIl;
        }
        final int llllllllllllllIIlIIIllllIIIIIlII = (int)llllllllllllllIIlIIIllllIIIIIIlI.getBlockState(llllllllllllllIIlIIIllllIIIIIIIl).getValue(BlockRedstoneWire.POWER);
        return (llllllllllllllIIlIIIllllIIIIIlII > llllllllllllllIIlIIIllllIIIIIlIl) ? llllllllllllllIIlIIIllllIIIIIlII : llllllllllllllIIlIIIllllIIIIIlIl;
    }
    
    static {
        __OBFID = "CL_00000295";
        NORTH = PropertyEnum.create("north", EnumAttachPosition.class);
        EAST = PropertyEnum.create("east", EnumAttachPosition.class);
        SOUTH = PropertyEnum.create("south", EnumAttachPosition.class);
        WEST = PropertyEnum.create("west", EnumAttachPosition.class);
        POWER = PropertyInteger.create("power", 0, 15);
    }
    
    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.CUTOUT;
    }
    
    protected static boolean func_176343_a(final IBlockState llllllllllllllIIlIIIlllIlIIllIIl, final EnumFacing llllllllllllllIIlIIIlllIlIIllIII) {
        final Block llllllllllllllIIlIIIlllIlIIllIll = llllllllllllllIIlIIIlllIlIIllIIl.getBlock();
        if (llllllllllllllIIlIIIlllIlIIllIll == Blocks.redstone_wire) {
            return true;
        }
        if (Blocks.unpowered_repeater.func_149907_e(llllllllllllllIIlIIIlllIlIIllIll)) {
            final EnumFacing llllllllllllllIIlIIIlllIlIIllIlI = (EnumFacing)llllllllllllllIIlIIIlllIlIIllIIl.getValue(BlockRedstoneRepeater.AGE);
            return llllllllllllllIIlIIIlllIlIIllIlI == llllllllllllllIIlIIIlllIlIIllIII || llllllllllllllIIlIIIlllIlIIllIlI.getOpposite() == llllllllllllllIIlIIIlllIlIIllIII;
        }
        return llllllllllllllIIlIIIlllIlIIllIll.canProvidePower() && llllllllllllllIIlIIIlllIlIIllIII != null;
    }
    
    protected static boolean func_176340_e(final IBlockAccess llllllllllllllIIlIIIlllIlIlIIllI, final BlockPos llllllllllllllIIlIIIlllIlIlIIlll) {
        return func_176346_d(llllllllllllllIIlIIIlllIlIlIIllI.getBlockState(llllllllllllllIIlIIIlllIlIlIIlll));
    }
    
    @Override
    public void randomDisplayTick(final World llllllllllllllIIlIIIlllIIllIllII, final BlockPos llllllllllllllIIlIIIlllIIllIlIll, final IBlockState llllllllllllllIIlIIIlllIIllIlIlI, final Random llllllllllllllIIlIIIlllIIllIlIIl) {
        final int llllllllllllllIIlIIIlllIIllIlIII = (int)llllllllllllllIIlIIIlllIIllIlIlI.getValue(BlockRedstoneWire.POWER);
        if (llllllllllllllIIlIIIlllIIllIlIII != 0) {
            final double llllllllllllllIIlIIIlllIIllIIlll = llllllllllllllIIlIIIlllIIllIlIll.getX() + 0.5 + (llllllllllllllIIlIIIlllIIllIlIIl.nextFloat() - 0.5) * 0.2;
            final double llllllllllllllIIlIIIlllIIllIIllI = llllllllllllllIIlIIIlllIIllIlIll.getY() + 0.0625f;
            final double llllllllllllllIIlIIIlllIIllIIlIl = llllllllllllllIIlIIIlllIIllIlIll.getZ() + 0.5 + (llllllllllllllIIlIIIlllIIllIlIIl.nextFloat() - 0.5) * 0.2;
            final float llllllllllllllIIlIIIlllIIllIIlII = llllllllllllllIIlIIIlllIIllIlIII / 15.0f;
            final float llllllllllllllIIlIIIlllIIllIIIll = llllllllllllllIIlIIIlllIIllIIlII * 0.6f + 0.4f;
            final float llllllllllllllIIlIIIlllIIllIIIlI = Math.max(0.0f, llllllllllllllIIlIIIlllIIllIIlII * llllllllllllllIIlIIIlllIIllIIlII * 0.7f - 0.5f);
            final float llllllllllllllIIlIIIlllIIllIIIIl = Math.max(0.0f, llllllllllllllIIlIIIlllIIllIIlII * llllllllllllllIIlIIIlllIIllIIlII * 0.6f - 0.7f);
            llllllllllllllIIlIIIlllIIllIllII.spawnParticle(EnumParticleTypes.REDSTONE, llllllllllllllIIlIIIlllIIllIIlll, llllllllllllllIIlIIIlllIIllIIllI, llllllllllllllIIlIIIlllIIllIIlIl, llllllllllllllIIlIIIlllIIllIIIll, llllllllllllllIIlIIIlllIIllIIIlI, llllllllllllllIIlIIIlllIIllIIIIl, new int[0]);
        }
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockRedstoneWire.NORTH, BlockRedstoneWire.EAST, BlockRedstoneWire.SOUTH, BlockRedstoneWire.WEST, BlockRedstoneWire.POWER });
    }
    
    @Override
    public boolean canPlaceBlockAt(final World llllllllllllllIIlIIIlllllIlIIIIl, final BlockPos llllllllllllllIIlIIIlllllIlIIIlI) {
        return World.doesBlockHaveSolidTopSurface(llllllllllllllIIlIIIlllllIlIIIIl, llllllllllllllIIlIIIlllllIlIIIlI.offsetDown()) || llllllllllllllIIlIIIlllllIlIIIIl.getBlockState(llllllllllllllIIlIIIlllllIlIIIlI.offsetDown()).getBlock() == Blocks.glowstone;
    }
    
    @Override
    public void breakBlock(final World llllllllllllllIIlIIIllllIIlIIIIl, final BlockPos llllllllllllllIIlIIIllllIIIlIlII, final IBlockState llllllllllllllIIlIIIllllIIIlllll) {
        super.breakBlock(llllllllllllllIIlIIIllllIIlIIIIl, llllllllllllllIIlIIIllllIIIlIlII, llllllllllllllIIlIIIllllIIIlllll);
        if (!llllllllllllllIIlIIIllllIIlIIIIl.isRemote) {
            for (final EnumFacing llllllllllllllIIlIIIllllIIIllIll : EnumFacing.values()) {
                llllllllllllllIIlIIIllllIIlIIIIl.notifyNeighborsOfStateChange(llllllllllllllIIlIIIllllIIIlIlII.offset(llllllllllllllIIlIIIllllIIIllIll), this);
            }
            this.updateSurroundingRedstone(llllllllllllllIIlIIIllllIIlIIIIl, llllllllllllllIIlIIIllllIIIlIlII, llllllllllllllIIlIIIllllIIIlllll);
            for (final EnumFacing llllllllllllllIIlIIIllllIIIllIIl : EnumFacing.Plane.HORIZONTAL) {
                this.func_176344_d(llllllllllllllIIlIIIllllIIlIIIIl, llllllllllllllIIlIIIllllIIIlIlII.offset(llllllllllllllIIlIIIllllIIIllIIl));
            }
            for (final EnumFacing llllllllllllllIIlIIIllllIIIllIII : EnumFacing.Plane.HORIZONTAL) {
                final BlockPos llllllllllllllIIlIIIllllIIIlIlll = llllllllllllllIIlIIIllllIIIlIlII.offset(llllllllllllllIIlIIIllllIIIllIII);
                if (llllllllllllllIIlIIIllllIIlIIIIl.getBlockState(llllllllllllllIIlIIIllllIIIlIlll).getBlock().isNormalCube()) {
                    this.func_176344_d(llllllllllllllIIlIIIllllIIlIIIIl, llllllllllllllIIlIIIllllIIIlIlll.offsetUp());
                }
                else {
                    this.func_176344_d(llllllllllllllIIlIIIllllIIlIIIIl, llllllllllllllIIlIIIllllIIIlIlll.offsetDown());
                }
            }
        }
    }
    
    private IBlockState func_176345_a(final World llllllllllllllIIlIIIllllIllllIIl, final BlockPos llllllllllllllIIlIIIllllIllIIlIl, final BlockPos llllllllllllllIIlIIIllllIllIIlII, IBlockState llllllllllllllIIlIIIllllIllIIIll) {
        final IBlockState llllllllllllllIIlIIIllllIlllIlIl = llllllllllllllIIlIIIllllIllIIIll;
        final int llllllllllllllIIlIIIllllIlllIlII = (int)llllllllllllllIIlIIIllllIllIIIll.getValue(BlockRedstoneWire.POWER);
        final byte llllllllllllllIIlIIIllllIlllIIll = 0;
        int llllllllllllllIIlIIIllllIlllIIlI = this.func_176342_a(llllllllllllllIIlIIIllllIllllIIl, llllllllllllllIIlIIIllllIllIIlII, llllllllllllllIIlIIIllllIlllIIll);
        this.canProvidePower = false;
        final int llllllllllllllIIlIIIllllIlllIIIl = llllllllllllllIIlIIIllllIllllIIl.func_175687_A(llllllllllllllIIlIIIllllIllIIlIl);
        this.canProvidePower = true;
        if (llllllllllllllIIlIIIllllIlllIIIl > 0 && llllllllllllllIIlIIIllllIlllIIIl > llllllllllllllIIlIIIllllIlllIIlI - 1) {
            llllllllllllllIIlIIIllllIlllIIlI = llllllllllllllIIlIIIllllIlllIIIl;
        }
        int llllllllllllllIIlIIIllllIlllIIII = 0;
        for (final EnumFacing llllllllllllllIIlIIIllllIllIlllI : EnumFacing.Plane.HORIZONTAL) {
            final BlockPos llllllllllllllIIlIIIllllIllIllIl = llllllllllllllIIlIIIllllIllIIlIl.offset(llllllllllllllIIlIIIllllIllIlllI);
            final boolean llllllllllllllIIlIIIllllIllIllII = llllllllllllllIIlIIIllllIllIllIl.getX() != llllllllllllllIIlIIIllllIllIIlII.getX() || llllllllllllllIIlIIIllllIllIllIl.getZ() != llllllllllllllIIlIIIllllIllIIlII.getZ();
            if (llllllllllllllIIlIIIllllIllIllII) {
                llllllllllllllIIlIIIllllIlllIIII = this.func_176342_a(llllllllllllllIIlIIIllllIllllIIl, llllllllllllllIIlIIIllllIllIllIl, llllllllllllllIIlIIIllllIlllIIII);
            }
            if (llllllllllllllIIlIIIllllIllllIIl.getBlockState(llllllllllllllIIlIIIllllIllIllIl).getBlock().isNormalCube() && !llllllllllllllIIlIIIllllIllllIIl.getBlockState(llllllllllllllIIlIIIllllIllIIlIl.offsetUp()).getBlock().isNormalCube()) {
                if (!llllllllllllllIIlIIIllllIllIllII || llllllllllllllIIlIIIllllIllIIlIl.getY() < llllllllllllllIIlIIIllllIllIIlII.getY()) {
                    continue;
                }
                llllllllllllllIIlIIIllllIlllIIII = this.func_176342_a(llllllllllllllIIlIIIllllIllllIIl, llllllllllllllIIlIIIllllIllIllIl.offsetUp(), llllllllllllllIIlIIIllllIlllIIII);
            }
            else {
                if (llllllllllllllIIlIIIllllIllllIIl.getBlockState(llllllllllllllIIlIIIllllIllIllIl).getBlock().isNormalCube() || !llllllllllllllIIlIIIllllIllIllII || llllllllllllllIIlIIIllllIllIIlIl.getY() > llllllllllllllIIlIIIllllIllIIlII.getY()) {
                    continue;
                }
                llllllllllllllIIlIIIllllIlllIIII = this.func_176342_a(llllllllllllllIIlIIIllllIllllIIl, llllllllllllllIIlIIIllllIllIllIl.offsetDown(), llllllllllllllIIlIIIllllIlllIIII);
            }
        }
        if (llllllllllllllIIlIIIllllIlllIIII > llllllllllllllIIlIIIllllIlllIIlI) {
            llllllllllllllIIlIIIllllIlllIIlI = llllllllllllllIIlIIIllllIlllIIII - 1;
        }
        else if (llllllllllllllIIlIIIllllIlllIIlI > 0) {
            --llllllllllllllIIlIIIllllIlllIIlI;
        }
        else {
            llllllllllllllIIlIIIllllIlllIIlI = 0;
        }
        if (llllllllllllllIIlIIIllllIlllIIIl > llllllllllllllIIlIIIllllIlllIIlI - 1) {
            llllllllllllllIIlIIIllllIlllIIlI = llllllllllllllIIlIIIllllIlllIIIl;
        }
        if (llllllllllllllIIlIIIllllIlllIlII != llllllllllllllIIlIIIllllIlllIIlI) {
            llllllllllllllIIlIIIllllIllIIIll = llllllllllllllIIlIIIllllIllIIIll.withProperty(BlockRedstoneWire.POWER, llllllllllllllIIlIIIllllIlllIIlI);
            if (llllllllllllllIIlIIIllllIllllIIl.getBlockState(llllllllllllllIIlIIIllllIllIIlIl) == llllllllllllllIIlIIIllllIlllIlIl) {
                llllllllllllllIIlIIIllllIllllIIl.setBlockState(llllllllllllllIIlIIIllllIllIIlIl, llllllllllllllIIlIIIllllIllIIIll, 2);
            }
            this.field_150179_b.add(llllllllllllllIIlIIIllllIllIIlIl);
            for (final EnumFacing llllllllllllllIIlIIIllllIllIlIII : EnumFacing.values()) {
                this.field_150179_b.add(llllllllllllllIIlIIIllllIllIIlIl.offset(llllllllllllllIIlIIIllllIllIlIII));
            }
        }
        return llllllllllllllIIlIIIllllIllIIIll;
    }
    
    @Override
    public Item getItem(final World llllllllllllllIIlIIIlllIIlIlIIll, final BlockPos llllllllllllllIIlIIIlllIIlIlIIlI) {
        return Items.redstone;
    }
    
    @Override
    public IBlockState getActualState(IBlockState llllllllllllllIIlIIIllllllIlIIIl, final IBlockAccess llllllllllllllIIlIIIllllllIlIIII, final BlockPos llllllllllllllIIlIIIllllllIlIIll) {
        llllllllllllllIIlIIIllllllIlIIIl = (double)((IBlockState)llllllllllllllIIlIIIllllllIlIIIl).withProperty(BlockRedstoneWire.WEST, this.getAttachPosition(llllllllllllllIIlIIIllllllIlIIII, llllllllllllllIIlIIIllllllIlIIll, EnumFacing.WEST));
        llllllllllllllIIlIIIllllllIlIIIl = (double)((IBlockState)llllllllllllllIIlIIIllllllIlIIIl).withProperty(BlockRedstoneWire.EAST, this.getAttachPosition(llllllllllllllIIlIIIllllllIlIIII, llllllllllllllIIlIIIllllllIlIIll, EnumFacing.EAST));
        llllllllllllllIIlIIIllllllIlIIIl = (double)((IBlockState)llllllllllllllIIlIIIllllllIlIIIl).withProperty(BlockRedstoneWire.NORTH, this.getAttachPosition(llllllllllllllIIlIIIllllllIlIIII, llllllllllllllIIlIIIllllllIlIIll, EnumFacing.NORTH));
        llllllllllllllIIlIIIllllllIlIIIl = (double)((IBlockState)llllllllllllllIIlIIIllllllIlIIIl).withProperty(BlockRedstoneWire.SOUTH, this.getAttachPosition(llllllllllllllIIlIIIllllllIlIIII, llllllllllllllIIlIIIllllllIlIIll, EnumFacing.SOUTH));
        return (IBlockState)llllllllllllllIIlIIIllllllIlIIIl;
    }
    
    private EnumAttachPosition getAttachPosition(final IBlockAccess llllllllllllllIIlIIIllllllIIIlll, final BlockPos llllllllllllllIIlIIIllllllIIIllI, final EnumFacing llllllllllllllIIlIIIllllllIIIlIl) {
        final BlockPos llllllllllllllIIlIIIllllllIIIlII = llllllllllllllIIlIIIllllllIIIllI.offset(llllllllllllllIIlIIIllllllIIIlIl);
        final Block llllllllllllllIIlIIIllllllIIIIll = llllllllllllllIIlIIIllllllIIIlll.getBlockState(llllllllllllllIIlIIIllllllIIIllI.offset(llllllllllllllIIlIIIllllllIIIlIl)).getBlock();
        if (!func_176343_a(llllllllllllllIIlIIIllllllIIIlll.getBlockState(llllllllllllllIIlIIIllllllIIIlII), llllllllllllllIIlIIIllllllIIIlIl) && (llllllllllllllIIlIIIllllllIIIIll.isSolidFullCube() || !func_176346_d(llllllllllllllIIlIIIllllllIIIlll.getBlockState(llllllllllllllIIlIIIllllllIIIlII.offsetDown())))) {
            final Block llllllllllllllIIlIIIllllllIIIIlI = llllllllllllllIIlIIIllllllIIIlll.getBlockState(llllllllllllllIIlIIIllllllIIIllI.offsetUp()).getBlock();
            return (!llllllllllllllIIlIIIllllllIIIIlI.isSolidFullCube() && llllllllllllllIIlIIIllllllIIIIll.isSolidFullCube() && func_176346_d(llllllllllllllIIlIIIllllllIIIlll.getBlockState(llllllllllllllIIlIIIllllllIIIlII.offsetUp()))) ? EnumAttachPosition.UP : EnumAttachPosition.NONE;
        }
        return EnumAttachPosition.SIDE;
    }
    
    private IBlockState updateSurroundingRedstone(final World llllllllllllllIIlIIIlllllIIlIIII, final BlockPos llllllllllllllIIlIIIlllllIIIllll, IBlockState llllllllllllllIIlIIIlllllIIIlllI) {
        llllllllllllllIIlIIIlllllIIIlllI = (boolean)this.func_176345_a(llllllllllllllIIlIIIlllllIIlIIII, llllllllllllllIIlIIIlllllIIIllll, llllllllllllllIIlIIIlllllIIIllll, (IBlockState)llllllllllllllIIlIIIlllllIIIlllI);
        final ArrayList llllllllllllllIIlIIIlllllIIlIlII = Lists.newArrayList((Iterable)this.field_150179_b);
        this.field_150179_b.clear();
        for (final BlockPos llllllllllllllIIlIIIlllllIIlIIlI : llllllllllllllIIlIIIlllllIIlIlII) {
            llllllllllllllIIlIIIlllllIIlIIII.notifyNeighborsOfStateChange(llllllllllllllIIlIIIlllllIIlIIlI, this);
        }
        return (IBlockState)llllllllllllllIIlIIIlllllIIIlllI;
    }
    
    private void func_176344_d(final World llllllllllllllIIlIIIllllIlIIllll, final BlockPos llllllllllllllIIlIIIllllIlIIlllI) {
        if (llllllllllllllIIlIIIllllIlIIllll.getBlockState(llllllllllllllIIlIIIllllIlIIlllI).getBlock() == this) {
            llllllllllllllIIlIIIllllIlIIllll.notifyNeighborsOfStateChange(llllllllllllllIIlIIIllllIlIIlllI, this);
            for (final EnumFacing llllllllllllllIIlIIIllllIlIIlIlI : EnumFacing.values()) {
                llllllllllllllIIlIIIllllIlIIllll.notifyNeighborsOfStateChange(llllllllllllllIIlIIIllllIlIIlllI.offset(llllllllllllllIIlIIIllllIlIIlIlI), this);
            }
        }
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final World llllllllllllllIIlIIIlllllIlllIlI, final BlockPos llllllllllllllIIlIIIlllllIlllIIl, final IBlockState llllllllllllllIIlIIIlllllIlllIII) {
        return null;
    }
    
    @Override
    public int isProvidingWeakPower(final IBlockAccess llllllllllllllIIlIIIlllIllIlIlII, final BlockPos llllllllllllllIIlIIIlllIllIIlIlI, final IBlockState llllllllllllllIIlIIIlllIllIlIIlI, final EnumFacing llllllllllllllIIlIIIlllIllIlIIIl) {
        if (!this.canProvidePower) {
            return 0;
        }
        final int llllllllllllllIIlIIIlllIllIlIIII = (int)llllllllllllllIIlIIIlllIllIlIIlI.getValue(BlockRedstoneWire.POWER);
        if (llllllllllllllIIlIIIlllIllIlIIII == 0) {
            return 0;
        }
        if (llllllllllllllIIlIIIlllIllIlIIIl == EnumFacing.UP) {
            return llllllllllllllIIlIIIlllIllIlIIII;
        }
        final EnumSet llllllllllllllIIlIIIlllIllIIllll = EnumSet.noneOf(EnumFacing.class);
        for (final EnumFacing llllllllllllllIIlIIIlllIllIIllIl : EnumFacing.Plane.HORIZONTAL) {
            if (this.func_176339_d(llllllllllllllIIlIIIlllIllIlIlII, llllllllllllllIIlIIIlllIllIIlIlI, llllllllllllllIIlIIIlllIllIIllIl)) {
                llllllllllllllIIlIIIlllIllIIllll.add(llllllllllllllIIlIIIlllIllIIllIl);
            }
        }
        if (llllllllllllllIIlIIIlllIllIlIIIl.getAxis().isHorizontal() && llllllllllllllIIlIIIlllIllIIllll.isEmpty()) {
            return llllllllllllllIIlIIIlllIllIlIIII;
        }
        if (llllllllllllllIIlIIIlllIllIIllll.contains(llllllllllllllIIlIIIlllIllIlIIIl) && !llllllllllllllIIlIIIlllIllIIllll.contains(llllllllllllllIIlIIIlllIllIlIIIl.rotateYCCW()) && !llllllllllllllIIlIIIlllIllIIllll.contains(llllllllllllllIIlIIIlllIllIlIIIl.rotateY())) {
            return llllllllllllllIIlIIIlllIllIlIIII;
        }
        return 0;
    }
    
    @Override
    public int colorMultiplier(final IBlockAccess llllllllllllllIIlIIIlllllIlIlIlI, final BlockPos llllllllllllllIIlIIIlllllIlIlllI, final int llllllllllllllIIlIIIlllllIlIllIl) {
        final IBlockState llllllllllllllIIlIIIlllllIlIllII = llllllllllllllIIlIIIlllllIlIlIlI.getBlockState(llllllllllllllIIlIIIlllllIlIlllI);
        return (llllllllllllllIIlIIIlllllIlIllII.getBlock() != this) ? super.colorMultiplier(llllllllllllllIIlIIIlllllIlIlIlI, llllllllllllllIIlIIIlllllIlIlllI, llllllllllllllIIlIIIlllllIlIllIl) : this.func_176337_b((int)llllllllllllllIIlIIIlllllIlIllII.getValue(BlockRedstoneWire.POWER));
    }
    
    private boolean func_176339_d(final IBlockAccess llllllllllllllIIlIIIlllIlIlllIlI, final BlockPos llllllllllllllIIlIIIlllIlIlllIIl, final EnumFacing llllllllllllllIIlIIIlllIlIllIIII) {
        final BlockPos llllllllllllllIIlIIIlllIlIllIlll = llllllllllllllIIlIIIlllIlIlllIIl.offset(llllllllllllllIIlIIIlllIlIllIIII);
        final IBlockState llllllllllllllIIlIIIlllIlIllIllI = llllllllllllllIIlIIIlllIlIlllIlI.getBlockState(llllllllllllllIIlIIIlllIlIllIlll);
        final Block llllllllllllllIIlIIIlllIlIllIlIl = llllllllllllllIIlIIIlllIlIllIllI.getBlock();
        final boolean llllllllllllllIIlIIIlllIlIllIlII = llllllllllllllIIlIIIlllIlIllIlIl.isNormalCube();
        final boolean llllllllllllllIIlIIIlllIlIllIIll = llllllllllllllIIlIIIlllIlIlllIlI.getBlockState(llllllllllllllIIlIIIlllIlIlllIIl.offsetUp()).getBlock().isNormalCube();
        return (!llllllllllllllIIlIIIlllIlIllIIll && llllllllllllllIIlIIIlllIlIllIlII && func_176340_e(llllllllllllllIIlIIIlllIlIlllIlI, llllllllllllllIIlIIIlllIlIllIlll.offsetUp())) || func_176343_a(llllllllllllllIIlIIIlllIlIllIllI, llllllllllllllIIlIIIlllIlIllIIII) || (llllllllllllllIIlIIIlllIlIllIlIl == Blocks.powered_repeater && llllllllllllllIIlIIIlllIlIllIllI.getValue(BlockRedstoneDiode.AGE) == llllllllllllllIIlIIIlllIlIllIIII) || (!llllllllllllllIIlIIIlllIlIllIlII && func_176340_e(llllllllllllllIIlIIIlllIlIlllIlI, llllllllllllllIIlIIIlllIlIllIlll.offsetDown()));
    }
    
    @Override
    public void onNeighborBlockChange(final World llllllllllllllIIlIIIlllIlllllIIl, final BlockPos llllllllllllllIIlIIIlllIllllIIll, final IBlockState llllllllllllllIIlIIIlllIllllIIlI, final Block llllllllllllllIIlIIIlllIllllIllI) {
        if (!llllllllllllllIIlIIIlllIlllllIIl.isRemote) {
            if (this.canPlaceBlockAt(llllllllllllllIIlIIIlllIlllllIIl, llllllllllllllIIlIIIlllIllllIIll)) {
                this.updateSurroundingRedstone(llllllllllllllIIlIIIlllIlllllIIl, llllllllllllllIIlIIIlllIllllIIll, llllllllllllllIIlIIIlllIllllIIlI);
            }
            else {
                this.dropBlockAsItem(llllllllllllllIIlIIIlllIlllllIIl, llllllllllllllIIlIIIlllIllllIIll, llllllllllllllIIlIIIlllIllllIIlI, 0);
                llllllllllllllIIlIIIlllIlllllIIl.setBlockToAir(llllllllllllllIIlIIIlllIllllIIll);
            }
        }
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    protected static boolean func_176346_d(final IBlockState llllllllllllllIIlIIIlllIlIlIIIlI) {
        return func_176343_a(llllllllllllllIIlIIIlllIlIlIIIlI, null);
    }
    
    @Override
    public void onBlockAdded(final World llllllllllllllIIlIIIllllIIllIIIl, final BlockPos llllllllllllllIIlIIIllllIIllIIII, final IBlockState llllllllllllllIIlIIIllllIIlIllll) {
        if (!llllllllllllllIIlIIIllllIIllIIIl.isRemote) {
            this.updateSurroundingRedstone(llllllllllllllIIlIIIllllIIllIIIl, llllllllllllllIIlIIIllllIIllIIII, llllllllllllllIIlIIIllllIIlIllll);
            for (final EnumFacing llllllllllllllIIlIIIllllIIllIllI : EnumFacing.Plane.VERTICAL) {
                llllllllllllllIIlIIIllllIIllIIIl.notifyNeighborsOfStateChange(llllllllllllllIIlIIIllllIIllIIII.offset(llllllllllllllIIlIIIllllIIllIllI), this);
            }
            for (final EnumFacing llllllllllllllIIlIIIllllIIllIlIl : EnumFacing.Plane.HORIZONTAL) {
                this.func_176344_d(llllllllllllllIIlIIIllllIIllIIIl, llllllllllllllIIlIIIllllIIllIIII.offset(llllllllllllllIIlIIIllllIIllIlIl));
            }
            for (final EnumFacing llllllllllllllIIlIIIllllIIllIlII : EnumFacing.Plane.HORIZONTAL) {
                final BlockPos llllllllllllllIIlIIIllllIIllIIll = llllllllllllllIIlIIIllllIIllIIII.offset(llllllllllllllIIlIIIllllIIllIlII);
                if (llllllllllllllIIlIIIllllIIllIIIl.getBlockState(llllllllllllllIIlIIIllllIIllIIll).getBlock().isNormalCube()) {
                    this.func_176344_d(llllllllllllllIIlIIIllllIIllIIIl, llllllllllllllIIlIIIllllIIllIIll.offsetUp());
                }
                else {
                    this.func_176344_d(llllllllllllllIIlIIIllllIIllIIIl, llllllllllllllIIlIIIllllIIllIIll.offsetDown());
                }
            }
        }
    }
    
    private int func_176337_b(final int llllllllllllllIIlIIIlllIlIIIlIIl) {
        final float llllllllllllllIIlIIIlllIlIIIlIII = llllllllllllllIIlIIIlllIlIIIlIIl / 15.0f;
        float llllllllllllllIIlIIIlllIlIIIIlll = llllllllllllllIIlIIIlllIlIIIlIII * 0.6f + 0.4f;
        if (llllllllllllllIIlIIIlllIlIIIlIIl == 0) {
            llllllllllllllIIlIIIlllIlIIIIlll = 0.3f;
        }
        float llllllllllllllIIlIIIlllIlIIIIllI = llllllllllllllIIlIIIlllIlIIIlIII * llllllllllllllIIlIIIlllIlIIIlIII * 0.7f - 0.5f;
        float llllllllllllllIIlIIIlllIlIIIIlIl = llllllllllllllIIlIIIlllIlIIIlIII * llllllllllllllIIlIIIlllIlIIIlIII * 0.6f - 0.7f;
        if (llllllllllllllIIlIIIlllIlIIIIllI < 0.0f) {
            llllllllllllllIIlIIIlllIlIIIIllI = 0.0f;
        }
        if (llllllllllllllIIlIIIlllIlIIIIlIl < 0.0f) {
            llllllllllllllIIlIIIlllIlIIIIlIl = 0.0f;
        }
        final int llllllllllllllIIlIIIlllIlIIIIlII = MathHelper.clamp_int((int)(llllllllllllllIIlIIIlllIlIIIIlll * 255.0f), 0, 255);
        final int llllllllllllllIIlIIIlllIlIIIIIll = MathHelper.clamp_int((int)(llllllllllllllIIlIIIlllIlIIIIllI * 255.0f), 0, 255);
        final int llllllllllllllIIlIIIlllIlIIIIIlI = MathHelper.clamp_int((int)(llllllllllllllIIlIIIlllIlIIIIlIl * 255.0f), 0, 255);
        return 0xFF000000 | llllllllllllllIIlIIIlllIlIIIIlII << 16 | llllllllllllllIIlIIIlllIlIIIIIll << 8 | llllllllllllllIIlIIIlllIlIIIIIlI;
    }
    
    public BlockRedstoneWire() {
        super(Material.circuits);
        this.canProvidePower = true;
        this.field_150179_b = Sets.newHashSet();
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockRedstoneWire.NORTH, EnumAttachPosition.NONE).withProperty(BlockRedstoneWire.EAST, EnumAttachPosition.NONE).withProperty(BlockRedstoneWire.SOUTH, EnumAttachPosition.NONE).withProperty(BlockRedstoneWire.WEST, EnumAttachPosition.NONE).withProperty(BlockRedstoneWire.POWER, 0));
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.0625f, 1.0f);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIIlIIIlllIIlIIlIll) {
        return this.getDefaultState().withProperty(BlockRedstoneWire.POWER, llllllllllllllIIlIIIlllIIlIIlIll);
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllIIlIIIlllIllllIIII, final Random llllllllllllllIIlIIIlllIlllIllll, final int llllllllllllllIIlIIIlllIlllIlllI) {
        return Items.redstone;
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public boolean canProvidePower() {
        return this.canProvidePower;
    }
    
    enum EnumAttachPosition implements IStringSerializable
    {
        NONE("NONE", 2, "NONE", 2, "none"), 
        SIDE("SIDE", 1, "SIDE", 1, "side");
        
        private final /* synthetic */ String field_176820_d;
        
        UP("UP", 0, "UP", 0, "up");
        
        @Override
        public String getName() {
            return this.field_176820_d;
        }
        
        private EnumAttachPosition(final String llllllllllllllIllIIIIIIIlIllIlII, final int llllllllllllllIllIIIIIIIlIllIIll, final String llllllllllllllIllIIIIIIIlIlllIII, final int llllllllllllllIllIIIIIIIlIllIlll, final String llllllllllllllIllIIIIIIIlIllIllI) {
            this.field_176820_d = llllllllllllllIllIIIIIIIlIllIllI;
        }
        
        @Override
        public String toString() {
            return this.getName();
        }
        
        static {
            __OBFID = "CL_00002070";
        }
    }
}
