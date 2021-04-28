package net.minecraft.block;

import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.util.*;

public abstract class BlockBasePressurePlate extends Block
{
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final World llllllllllllllllIllIlIIlIIIlIIll, final BlockPos llllllllllllllllIllIlIIlIIIlIIlI, final IBlockState llllllllllllllllIllIlIIlIIIlIIIl) {
        return null;
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    @Override
    public boolean canProvidePower() {
        return true;
    }
    
    protected abstract int computeRedstoneStrength(final World p0, final BlockPos p1);
    
    protected void updateState(final World llllllllllllllllIllIlIIIllIIIIII, final BlockPos llllllllllllllllIllIlIIIlIllllll, IBlockState llllllllllllllllIllIlIIIlIllIllI, final int llllllllllllllllIllIlIIIlIllllIl) {
        final int llllllllllllllllIllIlIIIlIllllII = this.computeRedstoneStrength(llllllllllllllllIllIlIIIllIIIIII, llllllllllllllllIllIlIIIlIllllll);
        final boolean llllllllllllllllIllIlIIIlIlllIll = llllllllllllllllIllIlIIIlIllllIl > 0;
        final boolean llllllllllllllllIllIlIIIlIlllIlI = llllllllllllllllIllIlIIIlIllllII > 0;
        if (llllllllllllllllIllIlIIIlIllllIl != llllllllllllllllIllIlIIIlIllllII) {
            llllllllllllllllIllIlIIIlIllIllI = (short)this.setRedstoneStrength((IBlockState)llllllllllllllllIllIlIIIlIllIllI, llllllllllllllllIllIlIIIlIllllII);
            llllllllllllllllIllIlIIIllIIIIII.setBlockState(llllllllllllllllIllIlIIIlIllllll, (IBlockState)llllllllllllllllIllIlIIIlIllIllI, 2);
            this.updateNeighbors(llllllllllllllllIllIlIIIllIIIIII, llllllllllllllllIllIlIIIlIllllll);
            llllllllllllllllIllIlIIIllIIIIII.markBlockRangeForRenderUpdate(llllllllllllllllIllIlIIIlIllllll, llllllllllllllllIllIlIIIlIllllll);
        }
        if (!llllllllllllllllIllIlIIIlIlllIlI && llllllllllllllllIllIlIIIlIlllIll) {
            llllllllllllllllIllIlIIIllIIIIII.playSoundEffect(llllllllllllllllIllIlIIIlIllllll.getX() + 0.5, llllllllllllllllIllIlIIIlIllllll.getY() + 0.1, llllllllllllllllIllIlIIIlIllllll.getZ() + 0.5, "random.click", 0.3f, 0.5f);
        }
        else if (llllllllllllllllIllIlIIIlIlllIlI && !llllllllllllllllIllIlIIIlIlllIll) {
            llllllllllllllllIllIlIIIllIIIIII.playSoundEffect(llllllllllllllllIllIlIIIlIllllll.getX() + 0.5, llllllllllllllllIllIlIIIlIllllll.getY() + 0.1, llllllllllllllllIllIlIIIlIllllll.getZ() + 0.5, "random.click", 0.3f, 0.6f);
        }
        if (llllllllllllllllIllIlIIIlIlllIlI) {
            llllllllllllllllIllIlIIIllIIIIII.scheduleUpdate(llllllllllllllllIllIlIIIlIllllll, this, this.tickRate(llllllllllllllllIllIlIIIllIIIIII));
        }
    }
    
    @Override
    public int tickRate(final World llllllllllllllllIllIlIIlIIIlIlIl) {
        return 20;
    }
    
    @Override
    public void randomTick(final World llllllllllllllllIllIlIIIlllIllIl, final BlockPos llllllllllllllllIllIlIIIlllIllII, final IBlockState llllllllllllllllIllIlIIIlllIlIll, final Random llllllllllllllllIllIlIIIlllIlIlI) {
    }
    
    @Override
    public void onEntityCollidedWithBlock(final World llllllllllllllllIllIlIIIllIIllIl, final BlockPos llllllllllllllllIllIlIIIllIIllII, final IBlockState llllllllllllllllIllIlIIIllIIlIll, final Entity llllllllllllllllIllIlIIIllIlIIII) {
        if (!llllllllllllllllIllIlIIIllIIllIl.isRemote) {
            final int llllllllllllllllIllIlIIIllIIllll = this.getRedstoneStrength(llllllllllllllllIllIlIIIllIIlIll);
            if (llllllllllllllllIllIlIIIllIIllll == 0) {
                this.updateState(llllllllllllllllIllIlIIIllIIllIl, llllllllllllllllIllIlIIIllIIllII, llllllllllllllllIllIlIIIllIIlIll, llllllllllllllllIllIlIIIllIIllll);
            }
        }
    }
    
    private boolean canBePlacedOn(final World llllllllllllllllIllIlIIIllllIIII, final BlockPos llllllllllllllllIllIlIIIllllIIIl) {
        return World.doesBlockHaveSolidTopSurface(llllllllllllllllIllIlIIIllllIIII, llllllllllllllllIllIlIIIllllIIIl) || llllllllllllllllIllIlIIIllllIIII.getBlockState(llllllllllllllllIllIlIIIllllIIIl).getBlock() instanceof BlockFence;
    }
    
    protected abstract IBlockState setRedstoneStrength(final IBlockState p0, final int p1);
    
    protected BlockBasePressurePlate(final Material llllllllllllllllIllIlIIlIIlIlllI) {
        super(llllllllllllllllIllIlIIlIIlIlllI);
        this.setCreativeTab(CreativeTabs.tabRedstone);
        this.setTickRandomly(true);
    }
    
    protected abstract int getRedstoneStrength(final IBlockState p0);
    
    @Override
    public int isProvidingWeakPower(final IBlockAccess llllllllllllllllIllIlIIIlIIlIIlI, final BlockPos llllllllllllllllIllIlIIIlIIlIIIl, final IBlockState llllllllllllllllIllIlIIIlIIIllIl, final EnumFacing llllllllllllllllIllIlIIIlIIIllll) {
        return this.getRedstoneStrength(llllllllllllllllIllIlIIIlIIIllIl);
    }
    
    protected AxisAlignedBB getSensitiveAABB(final BlockPos llllllllllllllllIllIlIIIlIlIlllI) {
        final float llllllllllllllllIllIlIIIlIlIllIl = 0.125f;
        return new AxisAlignedBB(llllllllllllllllIllIlIIIlIlIlllI.getX() + 0.125f, llllllllllllllllIllIlIIIlIlIlllI.getY(), llllllllllllllllIllIlIIIlIlIlllI.getZ() + 0.125f, llllllllllllllllIllIlIIIlIlIlllI.getX() + 1 - 0.125f, llllllllllllllllIllIlIIIlIlIlllI.getY() + 0.25, llllllllllllllllIllIlIIIlIlIlllI.getZ() + 1 - 0.125f);
    }
    
    @Override
    public void setBlockBoundsForItemRender() {
        final float llllllllllllllllIllIlIIIIllllIll = 0.5f;
        final float llllllllllllllllIllIlIIIIllllIlI = 0.125f;
        final float llllllllllllllllIllIlIIIIllllIIl = 0.5f;
        this.setBlockBounds(0.0f, 0.375f, 0.0f, 1.0f, 0.625f, 1.0f);
    }
    
    @Override
    public void onNeighborBlockChange(final World llllllllllllllllIllIlIIIlllllIII, final BlockPos llllllllllllllllIllIlIIIllllllII, final IBlockState llllllllllllllllIllIlIIIlllllIll, final Block llllllllllllllllIllIlIIIlllllIlI) {
        if (!this.canBePlacedOn(llllllllllllllllIllIlIIIlllllIII, llllllllllllllllIllIlIIIllllllII.offsetDown())) {
            this.dropBlockAsItem(llllllllllllllllIllIlIIIlllllIII, llllllllllllllllIllIlIIIllllllII, llllllllllllllllIllIlIIIlllllIll, 0);
            llllllllllllllllIllIlIIIlllllIII.setBlockToAir(llllllllllllllllIllIlIIIllllllII);
        }
    }
    
    @Override
    public void updateTick(final World llllllllllllllllIllIlIIIllIlllIl, final BlockPos llllllllllllllllIllIlIIIlllIIIlI, final IBlockState llllllllllllllllIllIlIIIlllIIIIl, final Random llllllllllllllllIllIlIIIlllIIIII) {
        if (!llllllllllllllllIllIlIIIllIlllIl.isRemote) {
            final int llllllllllllllllIllIlIIIllIlllll = this.getRedstoneStrength(llllllllllllllllIllIlIIIlllIIIIl);
            if (llllllllllllllllIllIlIIIllIlllll > 0) {
                this.updateState(llllllllllllllllIllIlIIIllIlllIl, llllllllllllllllIllIlIIIlllIIIlI, llllllllllllllllIllIlIIIlllIIIIl, llllllllllllllllIllIlIIIllIlllll);
            }
        }
    }
    
    @Override
    public int getMobilityFlag() {
        return 1;
    }
    
    @Override
    public void setBlockBoundsBasedOnState(final IBlockAccess llllllllllllllllIllIlIIlIIlIIlII, final BlockPos llllllllllllllllIllIlIIlIIlIIIll) {
        this.func_180668_d(llllllllllllllllIllIlIIlIIlIIlII.getBlockState(llllllllllllllllIllIlIIlIIlIIIll));
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    protected void updateNeighbors(final World llllllllllllllllIllIlIIIlIIlIlll, final BlockPos llllllllllllllllIllIlIIIlIIlIllI) {
        llllllllllllllllIllIlIIIlIIlIlll.notifyNeighborsOfStateChange(llllllllllllllllIllIlIIIlIIlIllI, this);
        llllllllllllllllIllIlIIIlIIlIlll.notifyNeighborsOfStateChange(llllllllllllllllIllIlIIIlIIlIllI.offsetDown(), this);
    }
    
    protected void func_180668_d(final IBlockState llllllllllllllllIllIlIIlIIIllIIl) {
        final boolean llllllllllllllllIllIlIIlIIIlllII = this.getRedstoneStrength(llllllllllllllllIllIlIIlIIIllIIl) > 0;
        final float llllllllllllllllIllIlIIlIIIllIll = 0.0625f;
        if (llllllllllllllllIllIlIIlIIIlllII) {
            this.setBlockBounds(0.0625f, 0.0f, 0.0625f, 0.9375f, 0.03125f, 0.9375f);
        }
        else {
            this.setBlockBounds(0.0625f, 0.0f, 0.0625f, 0.9375f, 0.0625f, 0.9375f);
        }
    }
    
    @Override
    public void breakBlock(final World llllllllllllllllIllIlIIIlIlIIlIl, final BlockPos llllllllllllllllIllIlIIIlIlIIlII, final IBlockState llllllllllllllllIllIlIIIlIlIIIll) {
        if (this.getRedstoneStrength(llllllllllllllllIllIlIIIlIlIIIll) > 0) {
            this.updateNeighbors(llllllllllllllllIllIlIIIlIlIIlIl, llllllllllllllllIllIlIIIlIlIIlII);
        }
        super.breakBlock(llllllllllllllllIllIlIIIlIlIIlIl, llllllllllllllllIllIlIIIlIlIIlII, llllllllllllllllIllIlIIIlIlIIIll);
    }
    
    @Override
    public boolean isPassable(final IBlockAccess llllllllllllllllIllIlIIlIIIIllIl, final BlockPos llllllllllllllllIllIlIIlIIIIllII) {
        return true;
    }
    
    static {
        __OBFID = "CL_00000194";
    }
    
    @Override
    public boolean canPlaceBlockAt(final World llllllllllllllllIllIlIIlIIIIIlll, final BlockPos llllllllllllllllIllIlIIlIIIIIIll) {
        return this.canBePlacedOn(llllllllllllllllIllIlIIlIIIIIlll, llllllllllllllllIllIlIIlIIIIIIll.offsetDown());
    }
    
    @Override
    public int isProvidingStrongPower(final IBlockAccess llllllllllllllllIllIlIIIlIIIlIII, final BlockPos llllllllllllllllIllIlIIIlIIIIlll, final IBlockState llllllllllllllllIllIlIIIlIIIIIll, final EnumFacing llllllllllllllllIllIlIIIlIIIIlIl) {
        return (llllllllllllllllIllIlIIIlIIIIlIl == EnumFacing.UP) ? this.getRedstoneStrength(llllllllllllllllIllIlIIIlIIIIIll) : 0;
    }
}
