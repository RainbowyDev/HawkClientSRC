package net.minecraft.block;

import net.minecraft.block.state.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import java.util.*;

public abstract class BlockRedstoneDiode extends BlockDirectional
{
    protected final /* synthetic */ boolean isRepeaterPowered;
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    public boolean func_176402_i(final World llllllllllllllIIllllIlIIllIllIll, final BlockPos llllllllllllllIIllllIlIIllIllIlI, final IBlockState llllllllllllllIIllllIlIIllIlIlII) {
        final EnumFacing llllllllllllllIIllllIlIIllIllIII = ((EnumFacing)llllllllllllllIIllllIlIIllIlIlII.getValue(BlockRedstoneDiode.AGE)).getOpposite();
        final BlockPos llllllllllllllIIllllIlIIllIlIlll = llllllllllllllIIllllIlIIllIllIlI.offset(llllllllllllllIIllllIlIIllIllIII);
        return isRedstoneRepeaterBlockID(llllllllllllllIIllllIlIIllIllIll.getBlockState(llllllllllllllIIllllIlIIllIlIlll).getBlock()) && llllllllllllllIIllllIlIIllIllIll.getBlockState(llllllllllllllIIllllIlIIllIlIlll).getValue(BlockRedstoneDiode.AGE) != llllllllllllllIIllllIlIIllIllIII;
    }
    
    protected BlockRedstoneDiode(final boolean llllllllllllllIIllllIllIIIIIllII) {
        super(Material.circuits);
        this.isRepeaterPowered = llllllllllllllIIllllIllIIIIIllII;
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.125f, 1.0f);
    }
    
    @Override
    public void onNeighborBlockChange(final World llllllllllllllIIllllIlIllIlIlIll, final BlockPos llllllllllllllIIllllIlIllIllIIll, final IBlockState llllllllllllllIIllllIlIllIllIIlI, final Block llllllllllllllIIllllIlIllIllIIIl) {
        if (this.func_176409_d(llllllllllllllIIllllIlIllIlIlIll, llllllllllllllIIllllIlIllIllIIll)) {
            this.func_176398_g(llllllllllllllIIllllIlIllIlIlIll, llllllllllllllIIllllIlIllIllIIll, llllllllllllllIIllllIlIllIllIIlI);
        }
        else {
            this.dropBlockAsItem(llllllllllllllIIllllIlIllIlIlIll, llllllllllllllIIllllIlIllIllIIll, llllllllllllllIIllllIlIllIllIIlI, 0);
            llllllllllllllIIllllIlIllIlIlIll.setBlockToAir(llllllllllllllIIllllIlIllIllIIll);
            for (final EnumFacing llllllllllllllIIllllIlIllIlIllIl : EnumFacing.values()) {
                llllllllllllllIIllllIlIllIlIlIll.notifyNeighborsOfStateChange(llllllllllllllIIllllIlIllIllIIll.offset(llllllllllllllIIllllIlIllIlIllIl), this);
            }
        }
    }
    
    protected int func_176407_c(final IBlockAccess llllllllllllllIIllllIlIlIllIIlII, final BlockPos llllllllllllllIIllllIlIlIllIIIll, final IBlockState llllllllllllllIIllllIlIlIlIllIll) {
        final EnumFacing llllllllllllllIIllllIlIlIllIIIIl = (EnumFacing)llllllllllllllIIllllIlIlIlIllIll.getValue(BlockRedstoneDiode.AGE);
        final EnumFacing llllllllllllllIIllllIlIlIllIIIII = llllllllllllllIIllllIlIlIllIIIIl.rotateY();
        final EnumFacing llllllllllllllIIllllIlIlIlIlllll = llllllllllllllIIllllIlIlIllIIIIl.rotateYCCW();
        return Math.max(this.func_176401_c(llllllllllllllIIllllIlIlIllIIlII, llllllllllllllIIllllIlIlIllIIIll.offset(llllllllllllllIIllllIlIlIllIIIII), llllllllllllllIIllllIlIlIllIIIII), this.func_176401_c(llllllllllllllIIllllIlIlIllIIlII, llllllllllllllIIllllIlIlIllIIIll.offset(llllllllllllllIIllllIlIlIlIlllll), llllllllllllllIIllllIlIlIlIlllll));
    }
    
    protected void func_176398_g(final World llllllllllllllIIllllIlIllIIlllIl, final BlockPos llllllllllllllIIllllIlIllIIlIllI, final IBlockState llllllllllllllIIllllIlIllIIllIll) {
        if (!this.func_176405_b(llllllllllllllIIllllIlIllIIlllIl, llllllllllllllIIllllIlIllIIlIllI, llllllllllllllIIllllIlIllIIllIll)) {
            final boolean llllllllllllllIIllllIlIllIIllIlI = this.func_176404_e(llllllllllllllIIllllIlIllIIlllIl, llllllllllllllIIllllIlIllIIlIllI, llllllllllllllIIllllIlIllIIllIll);
            if (((this.isRepeaterPowered && !llllllllllllllIIllllIlIllIIllIlI) || (!this.isRepeaterPowered && llllllllllllllIIllllIlIllIIllIlI)) && !llllllllllllllIIllllIlIllIIlllIl.isBlockTickPending(llllllllllllllIIllllIlIllIIlIllI, this)) {
                byte llllllllllllllIIllllIlIllIIllIIl = -1;
                if (this.func_176402_i(llllllllllllllIIllllIlIllIIlllIl, llllllllllllllIIllllIlIllIIlIllI, llllllllllllllIIllllIlIllIIllIll)) {
                    llllllllllllllIIllllIlIllIIllIIl = -3;
                }
                else if (this.isRepeaterPowered) {
                    llllllllllllllIIllllIlIllIIllIIl = -2;
                }
                llllllllllllllIIllllIlIllIIlllIl.func_175654_a(llllllllllllllIIllllIlIllIIlIllI, this, this.func_176403_d(llllllllllllllIIllllIlIllIIllIll), llllllllllllllIIllllIlIllIIllIIl);
            }
        }
    }
    
    @Override
    public void onBlockPlacedBy(final World llllllllllllllIIllllIlIlIIlIllII, final BlockPos llllllllllllllIIllllIlIlIIlIlIll, final IBlockState llllllllllllllIIllllIlIlIIllIIII, final EntityLivingBase llllllllllllllIIllllIlIlIIlIllll, final ItemStack llllllllllllllIIllllIlIlIIlIlllI) {
        if (this.func_176404_e(llllllllllllllIIllllIlIlIIlIllII, llllllllllllllIIllllIlIlIIlIlIll, llllllllllllllIIllllIlIlIIllIIII)) {
            llllllllllllllIIllllIlIlIIlIllII.scheduleUpdate(llllllllllllllIIllllIlIlIIlIlIll, this, 1);
        }
    }
    
    public static boolean isRedstoneRepeaterBlockID(final Block llllllllllllllIIllllIlIIlllIlIIl) {
        return Blocks.unpowered_repeater.func_149907_e(llllllllllllllIIllllIlIIlllIlIIl) || Blocks.unpowered_comparator.func_149907_e(llllllllllllllIIllllIlIIlllIlIIl);
    }
    
    protected abstract IBlockState func_180674_e(final IBlockState p0);
    
    protected void func_176400_h(final World llllllllllllllIIllllIlIlIIIlIllI, final BlockPos llllllllllllllIIllllIlIlIIIlIlIl, final IBlockState llllllllllllllIIllllIlIlIIIIlllI) {
        final EnumFacing llllllllllllllIIllllIlIlIIIlIIll = (EnumFacing)llllllllllllllIIllllIlIlIIIIlllI.getValue(BlockRedstoneDiode.AGE);
        final BlockPos llllllllllllllIIllllIlIlIIIlIIlI = llllllllllllllIIllllIlIlIIIlIlIl.offset(llllllllllllllIIllllIlIlIIIlIIll.getOpposite());
        llllllllllllllIIllllIlIlIIIlIllI.notifyBlockOfStateChange(llllllllllllllIIllllIlIlIIIlIIlI, this);
        llllllllllllllIIllllIlIlIIIlIllI.notifyNeighborsOfStateExcept(llllllllllllllIIllllIlIlIIIlIIlI, this, llllllllllllllIIllllIlIlIIIlIIll);
    }
    
    protected int func_176408_a(final IBlockAccess llllllllllllllIIllllIlIIlllIllIl, final BlockPos llllllllllllllIIllllIlIIlllIllII, final IBlockState llllllllllllllIIllllIlIIlllIlIll) {
        return 15;
    }
    
    protected int func_176399_m(final IBlockState llllllllllllllIIllllIlIIllIIllII) {
        return this.func_176403_d(llllllllllllllIIllllIlIIllIIllII);
    }
    
    protected int func_176397_f(final World llllllllllllllIIllllIlIlIllllIlI, final BlockPos llllllllllllllIIllllIlIlIlllIIlI, final IBlockState llllllllllllllIIllllIlIlIllllIII) {
        final EnumFacing llllllllllllllIIllllIlIlIlllIlll = (EnumFacing)llllllllllllllIIllllIlIlIllllIII.getValue(BlockRedstoneDiode.AGE);
        final BlockPos llllllllllllllIIllllIlIlIlllIllI = llllllllllllllIIllllIlIlIlllIIlI.offset(llllllllllllllIIllllIlIlIlllIlll);
        final int llllllllllllllIIllllIlIlIlllIlIl = llllllllllllllIIllllIlIlIllllIlI.getRedstonePower(llllllllllllllIIllllIlIlIlllIllI, llllllllllllllIIllllIlIlIlllIlll);
        if (llllllllllllllIIllllIlIlIlllIlIl >= 15) {
            return llllllllllllllIIllllIlIlIlllIlIl;
        }
        final IBlockState llllllllllllllIIllllIlIlIlllIlII = llllllllllllllIIllllIlIlIllllIlI.getBlockState(llllllllllllllIIllllIlIlIlllIllI);
        return Math.max(llllllllllllllIIllllIlIlIlllIlIl, (llllllllllllllIIllllIlIlIlllIlII.getBlock() == Blocks.redstone_wire) ? ((int)llllllllllllllIIllllIlIlIlllIlII.getValue(BlockRedstoneWire.POWER)) : 0);
    }
    
    @Override
    public boolean canPlaceBlockAt(final World llllllllllllllIIllllIllIIIIIIllI, final BlockPos llllllllllllllIIllllIllIIIIIIlIl) {
        return World.doesBlockHaveSolidTopSurface(llllllllllllllIIllllIllIIIIIIllI, llllllllllllllIIllllIllIIIIIIlIl.offsetDown()) && super.canPlaceBlockAt(llllllllllllllIIllllIllIIIIIIllI, llllllllllllllIIllllIllIIIIIIlIl);
    }
    
    @Override
    public int isProvidingStrongPower(final IBlockAccess llllllllllllllIIllllIlIlllIlIlIl, final BlockPos llllllllllllllIIllllIlIlllIIllll, final IBlockState llllllllllllllIIllllIlIlllIlIIll, final EnumFacing llllllllllllllIIllllIlIlllIIllIl) {
        return this.isProvidingWeakPower(llllllllllllllIIllllIlIlllIlIlIl, llllllllllllllIIllllIlIlllIIllll, llllllllllllllIIllllIlIlllIlIIll, llllllllllllllIIllllIlIlllIIllIl);
    }
    
    public boolean func_176409_d(final World llllllllllllllIIllllIlIlllllllII, final BlockPos llllllllllllllIIllllIlIllllllIll) {
        return World.doesBlockHaveSolidTopSurface(llllllllllllllIIllllIlIlllllllII, llllllllllllllIIllllIlIllllllIll.offsetDown());
    }
    
    protected abstract IBlockState func_180675_k(final IBlockState p0);
    
    protected boolean func_176404_e(final World llllllllllllllIIllllIlIllIIIlIIl, final BlockPos llllllllllllllIIllllIlIllIIIIlII, final IBlockState llllllllllllllIIllllIlIllIIIIIll) {
        return this.func_176397_f(llllllllllllllIIllllIlIllIIIlIIl, llllllllllllllIIllllIlIllIIIIlII, llllllllllllllIIllllIlIllIIIIIll) > 0;
    }
    
    @Override
    public boolean isAssociatedBlock(final Block llllllllllllllIIllllIlIIllIIlIII) {
        return this.func_149907_e(llllllllllllllIIllllIlIIllIIlIII);
    }
    
    @Override
    public int isProvidingWeakPower(final IBlockAccess llllllllllllllIIllllIlIlllIIIllI, final BlockPos llllllllllllllIIllllIlIlllIIIlIl, final IBlockState llllllllllllllIIllllIlIllIllllll, final EnumFacing llllllllllllllIIllllIlIllIlllllI) {
        return this.func_176406_l(llllllllllllllIIllllIlIllIllllll) ? ((llllllllllllllIIllllIlIllIllllll.getValue(BlockRedstoneDiode.AGE) == llllllllllllllIIllllIlIllIlllllI) ? this.func_176408_a(llllllllllllllIIllllIlIlllIIIllI, llllllllllllllIIllllIlIlllIIIlIl, llllllllllllllIIllllIlIllIllllll) : 0) : 0;
    }
    
    protected int func_176401_c(final IBlockAccess llllllllllllllIIllllIlIlIlIIlIlI, final BlockPos llllllllllllllIIllllIlIlIlIIllll, final EnumFacing llllllllllllllIIllllIlIlIlIIlllI) {
        final IBlockState llllllllllllllIIllllIlIlIlIIllIl = llllllllllllllIIllllIlIlIlIIlIlI.getBlockState(llllllllllllllIIllllIlIlIlIIllll);
        final Block llllllllllllllIIllllIlIlIlIIllII = llllllllllllllIIllllIlIlIlIIllIl.getBlock();
        return (int)(this.func_149908_a(llllllllllllllIIllllIlIlIlIIllII) ? ((llllllllllllllIIllllIlIlIlIIllII == Blocks.redstone_wire) ? llllllllllllllIIllllIlIlIlIIllIl.getValue(BlockRedstoneWire.POWER) : llllllllllllllIIllllIlIlIlIIlIlI.getStrongPower(llllllllllllllIIllllIlIlIlIIllll, llllllllllllllIIllllIlIlIlIIlllI)) : 0);
    }
    
    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.CUTOUT;
    }
    
    protected boolean func_176406_l(final IBlockState llllllllllllllIIllllIlIlllIlllIl) {
        return this.isRepeaterPowered;
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockAccess llllllllllllllIIllllIlIllllIIIll, final BlockPos llllllllllllllIIllllIlIllllIIIlI, final EnumFacing llllllllllllllIIllllIlIllllIIIIl) {
        return llllllllllllllIIllllIlIllllIIIIl.getAxis() != EnumFacing.Axis.Y;
    }
    
    protected boolean func_149908_a(final Block llllllllllllllIIllllIlIIllllIIII) {
        return llllllllllllllIIllllIlIIllllIIII.canProvidePower();
    }
    
    @Override
    public boolean canProvidePower() {
        return true;
    }
    
    @Override
    public void onBlockAdded(final World llllllllllllllIIllllIlIlIIlIIIII, final BlockPos llllllllllllllIIllllIlIlIIIlllll, final IBlockState llllllllllllllIIllllIlIlIIlIIIlI) {
        this.func_176400_h(llllllllllllllIIllllIlIlIIlIIIII, llllllllllllllIIllllIlIlIIIlllll, llllllllllllllIIllllIlIlIIlIIIlI);
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public void onBlockDestroyedByPlayer(final World llllllllllllllIIllllIlIIlllllIlI, final BlockPos llllllllllllllIIllllIlIIlllllIIl, final IBlockState llllllllllllllIIllllIlIlIIIIIIII) {
        if (this.isRepeaterPowered) {
            for (final EnumFacing llllllllllllllIIllllIlIIllllllII : EnumFacing.values()) {
                llllllllllllllIIllllIlIIlllllIlI.notifyNeighborsOfStateChange(llllllllllllllIIllllIlIIlllllIIl.offset(llllllllllllllIIllllIlIIllllllII), this);
            }
        }
        super.onBlockDestroyedByPlayer(llllllllllllllIIllllIlIIlllllIlI, llllllllllllllIIllllIlIIlllllIIl, llllllllllllllIIllllIlIlIIIIIIII);
    }
    
    @Override
    public IBlockState onBlockPlaced(final World llllllllllllllIIllllIlIlIlIIIIIl, final BlockPos llllllllllllllIIllllIlIlIlIIIIII, final EnumFacing llllllllllllllIIllllIlIlIIllllll, final float llllllllllllllIIllllIlIlIIlllllI, final float llllllllllllllIIllllIlIlIIllllIl, final float llllllllllllllIIllllIlIlIIllllII, final int llllllllllllllIIllllIlIlIIlllIll, final EntityLivingBase llllllllllllllIIllllIlIlIIlllIlI) {
        return this.getDefaultState().withProperty(BlockRedstoneDiode.AGE, llllllllllllllIIllllIlIlIIlllIlI.func_174811_aO().getOpposite());
    }
    
    @Override
    public void randomTick(final World llllllllllllllIIllllIlIllllllIIl, final BlockPos llllllllllllllIIllllIlIllllllIII, final IBlockState llllllllllllllIIllllIlIlllllIlll, final Random llllllllllllllIIllllIlIlllllIllI) {
    }
    
    public boolean func_149907_e(final Block llllllllllllllIIllllIlIIlllIIIlI) {
        return llllllllllllllIIllllIlIIlllIIIlI == this.func_180674_e(this.getDefaultState()).getBlock() || llllllllllllllIIllllIlIIlllIIIlI == this.func_180675_k(this.getDefaultState()).getBlock();
    }
    
    public boolean func_176405_b(final IBlockAccess llllllllllllllIIllllIlIllIIlIIIl, final BlockPos llllllllllllllIIllllIlIllIIlIIII, final IBlockState llllllllllllllIIllllIlIllIIIllll) {
        return false;
    }
    
    @Override
    public void updateTick(final World llllllllllllllIIllllIlIllllIllll, final BlockPos llllllllllllllIIllllIlIllllIlllI, final IBlockState llllllllllllllIIllllIlIllllIIlll, final Random llllllllllllllIIllllIlIllllIllII) {
        if (!this.func_176405_b(llllllllllllllIIllllIlIllllIllll, llllllllllllllIIllllIlIllllIlllI, llllllllllllllIIllllIlIllllIIlll)) {
            final boolean llllllllllllllIIllllIlIllllIlIll = this.func_176404_e(llllllllllllllIIllllIlIllllIllll, llllllllllllllIIllllIlIllllIlllI, llllllllllllllIIllllIlIllllIIlll);
            if (this.isRepeaterPowered && !llllllllllllllIIllllIlIllllIlIll) {
                llllllllllllllIIllllIlIllllIllll.setBlockState(llllllllllllllIIllllIlIllllIlllI, this.func_180675_k(llllllllllllllIIllllIlIllllIIlll), 2);
            }
            else if (!this.isRepeaterPowered) {
                llllllllllllllIIllllIlIllllIllll.setBlockState(llllllllllllllIIllllIlIllllIlllI, this.func_180674_e(llllllllllllllIIllllIlIllllIIlll), 2);
                if (!llllllllllllllIIllllIlIllllIlIll) {
                    llllllllllllllIIllllIlIllllIllll.func_175654_a(llllllllllllllIIllllIlIllllIlllI, this.func_180674_e(llllllllllllllIIllllIlIllllIIlll).getBlock(), this.func_176399_m(llllllllllllllIIllllIlIllllIIlll), -1);
                }
            }
        }
    }
    
    static {
        __OBFID = "CL_00000226";
    }
    
    protected abstract int func_176403_d(final IBlockState p0);
}
