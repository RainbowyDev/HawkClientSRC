package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;

public abstract class BlockButton extends Block
{
    public static final /* synthetic */ PropertyDirection FACING_PROP;
    private final /* synthetic */ boolean wooden;
    public static final /* synthetic */ PropertyBool POWERED_PROP;
    
    @Override
    public int getMetaFromState(final IBlockState lIIlIllIlIIlIII) {
        int lIIlIllIlIIlIIl = 0;
        switch (SwitchEnumFacing.field_180420_a[((EnumFacing)lIIlIllIlIIlIII.getValue(BlockButton.FACING_PROP)).ordinal()]) {
            case 1: {
                final int lIIlIllIlIIlllI = 1;
                break;
            }
            case 2: {
                final int lIIlIllIlIIllIl = 2;
                break;
            }
            case 3: {
                final int lIIlIllIlIIllII = 3;
                break;
            }
            case 4: {
                final int lIIlIllIlIIlIll = 4;
                break;
            }
            default: {
                final int lIIlIllIlIIlIlI = 5;
                break;
            }
            case 6: {
                lIIlIllIlIIlIIl = 0;
                break;
            }
        }
        if (lIIlIllIlIIlIII.getValue(BlockButton.POWERED_PROP)) {
            lIIlIllIlIIlIIl |= 0x8;
        }
        return lIIlIllIlIIlIIl;
    }
    
    @Override
    public int isProvidingWeakPower(final IBlockAccess lIIlIlllIlllIll, final BlockPos lIIlIlllIlllIlI, final IBlockState lIIlIlllIllIlll, final EnumFacing lIIlIlllIlllIII) {
        return lIIlIlllIllIlll.getValue(BlockButton.POWERED_PROP) ? 15 : 0;
    }
    
    @Override
    public void breakBlock(final World lIIlIllllIIIIII, final BlockPos lIIlIllllIIIIll, final IBlockState lIIlIlllIlllllI) {
        if (lIIlIlllIlllllI.getValue(BlockButton.POWERED_PROP)) {
            this.func_176582_b(lIIlIllllIIIIII, lIIlIllllIIIIll, (EnumFacing)lIIlIlllIlllllI.getValue(BlockButton.FACING_PROP));
        }
        super.breakBlock(lIIlIllllIIIIII, lIIlIllllIIIIll, lIIlIlllIlllllI);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lIIlIllIlIlIlII) {
        final EnumFacing lIIlIllIlIlIllI;
        switch (lIIlIllIlIlIlII & 0x7) {
            case 0: {
                final EnumFacing lIIlIllIlIllIll = EnumFacing.DOWN;
                break;
            }
            case 1: {
                final EnumFacing lIIlIllIlIllIlI = EnumFacing.EAST;
                break;
            }
            case 2: {
                final EnumFacing lIIlIllIlIllIIl = EnumFacing.WEST;
                break;
            }
            case 3: {
                final EnumFacing lIIlIllIlIllIII = EnumFacing.SOUTH;
                break;
            }
            case 4: {
                final EnumFacing lIIlIllIlIlIlll = EnumFacing.NORTH;
                break;
            }
            default: {
                lIIlIllIlIlIllI = EnumFacing.UP;
                break;
            }
        }
        return this.getDefaultState().withProperty(BlockButton.FACING_PROP, lIIlIllIlIlIllI).withProperty(BlockButton.POWERED_PROP, (lIIlIllIlIlIlII & 0x8) > 0);
    }
    
    private void func_180681_d(final IBlockState lIIlIlllllIIIlI) {
        final EnumFacing lIIlIlllllIlIlI = (EnumFacing)lIIlIlllllIIIlI.getValue(BlockButton.FACING_PROP);
        final boolean lIIlIlllllIlIIl = (boolean)lIIlIlllllIIIlI.getValue(BlockButton.POWERED_PROP);
        final float lIIlIlllllIlIII = 0.25f;
        final float lIIlIlllllIIlll = 0.375f;
        final float lIIlIlllllIIllI = (lIIlIlllllIlIIl ? 1 : 2) / 16.0f;
        final float lIIlIlllllIIlIl = 0.125f;
        final float lIIlIlllllIIlII = 0.1875f;
        switch (SwitchEnumFacing.field_180420_a[lIIlIlllllIlIlI.ordinal()]) {
            case 1: {
                this.setBlockBounds(0.0f, 0.375f, 0.3125f, lIIlIlllllIIllI, 0.625f, 0.6875f);
                break;
            }
            case 2: {
                this.setBlockBounds(1.0f - lIIlIlllllIIllI, 0.375f, 0.3125f, 1.0f, 0.625f, 0.6875f);
                break;
            }
            case 3: {
                this.setBlockBounds(0.3125f, 0.375f, 0.0f, 0.6875f, 0.625f, lIIlIlllllIIllI);
                break;
            }
            case 4: {
                this.setBlockBounds(0.3125f, 0.375f, 1.0f - lIIlIlllllIIllI, 0.6875f, 0.625f, 1.0f);
                break;
            }
            case 5: {
                this.setBlockBounds(0.3125f, 0.0f, 0.375f, 0.6875f, 0.0f + lIIlIlllllIIllI, 0.625f);
                break;
            }
            case 6: {
                this.setBlockBounds(0.3125f, 1.0f - lIIlIlllllIIllI, 0.375f, 0.6875f, 1.0f, 0.625f);
                break;
            }
        }
    }
    
    private void func_176582_b(final World lIIlIllIllIIlll, final BlockPos lIIlIllIllIIIlI, final EnumFacing lIIlIllIllIIlIl) {
        lIIlIllIllIIlll.notifyNeighborsOfStateChange(lIIlIllIllIIIlI, this);
        lIIlIllIllIIlll.notifyNeighborsOfStateChange(lIIlIllIllIIIlI.offset(lIIlIllIllIIlIl.getOpposite()), this);
    }
    
    @Override
    public void onNeighborBlockChange(final World lIIllIIIIIlIlII, final BlockPos lIIllIIIIIIllIl, final IBlockState lIIllIIIIIlIIlI, final Block lIIllIIIIIlIIIl) {
        if (this.func_176583_e(lIIllIIIIIlIlII, lIIllIIIIIIllIl, lIIllIIIIIlIIlI)) {
            final EnumFacing lIIllIIIIIlIIII = (EnumFacing)lIIllIIIIIlIIlI.getValue(BlockButton.FACING_PROP);
            if (!lIIllIIIIIlIlII.getBlockState(lIIllIIIIIIllIl.offset(lIIllIIIIIlIIII.getOpposite())).getBlock().isNormalCube()) {
                this.dropBlockAsItem(lIIllIIIIIlIlII, lIIllIIIIIIllIl, lIIllIIIIIlIIlI, 0);
                lIIllIIIIIlIlII.setBlockToAir(lIIllIIIIIIllIl);
            }
        }
    }
    
    private void func_180680_f(final World lIIlIllIllllIIl, final BlockPos lIIlIllIllllIII, final IBlockState lIIlIllIlllIlll) {
        this.func_180681_d(lIIlIllIlllIlll);
        final List lIIlIllIlllIllI = lIIlIllIllllIIl.getEntitiesWithinAABB(EntityArrow.class, new AxisAlignedBB(lIIlIllIllllIII.getX() + this.minX, lIIlIllIllllIII.getY() + this.minY, lIIlIllIllllIII.getZ() + this.minZ, lIIlIllIllllIII.getX() + this.maxX, lIIlIllIllllIII.getY() + this.maxY, lIIlIllIllllIII.getZ() + this.maxZ));
        final boolean lIIlIllIlllIlIl = !lIIlIllIlllIllI.isEmpty();
        final boolean lIIlIllIlllIlII = (boolean)lIIlIllIlllIlll.getValue(BlockButton.POWERED_PROP);
        if (lIIlIllIlllIlIl && !lIIlIllIlllIlII) {
            lIIlIllIllllIIl.setBlockState(lIIlIllIllllIII, lIIlIllIlllIlll.withProperty(BlockButton.POWERED_PROP, true));
            this.func_176582_b(lIIlIllIllllIIl, lIIlIllIllllIII, (EnumFacing)lIIlIllIlllIlll.getValue(BlockButton.FACING_PROP));
            lIIlIllIllllIIl.markBlockRangeForRenderUpdate(lIIlIllIllllIII, lIIlIllIllllIII);
            lIIlIllIllllIIl.playSoundEffect(lIIlIllIllllIII.getX() + 0.5, lIIlIllIllllIII.getY() + 0.5, lIIlIllIllllIII.getZ() + 0.5, "random.click", 0.3f, 0.6f);
        }
        if (!lIIlIllIlllIlIl && lIIlIllIlllIlII) {
            lIIlIllIllllIIl.setBlockState(lIIlIllIllllIII, lIIlIllIlllIlll.withProperty(BlockButton.POWERED_PROP, false));
            this.func_176582_b(lIIlIllIllllIIl, lIIlIllIllllIII, (EnumFacing)lIIlIllIlllIlll.getValue(BlockButton.FACING_PROP));
            lIIlIllIllllIIl.markBlockRangeForRenderUpdate(lIIlIllIllllIII, lIIlIllIllllIII);
            lIIlIllIllllIIl.playSoundEffect(lIIlIllIllllIII.getX() + 0.5, lIIlIllIllllIII.getY() + 0.5, lIIlIllIllllIII.getZ() + 0.5, "random.click", 0.3f, 0.5f);
        }
        if (lIIlIllIlllIlIl) {
            lIIlIllIllllIIl.scheduleUpdate(lIIlIllIllllIII, this, this.tickRate(lIIlIllIllllIIl));
        }
    }
    
    @Override
    public void setBlockBoundsForItemRender() {
        final float lIIlIlllIIlIlIl = 0.1875f;
        final float lIIlIlllIIlIlII = 0.125f;
        final float lIIlIlllIIlIIll = 0.125f;
        this.setBlockBounds(0.5f - lIIlIlllIIlIlIl, 0.5f - lIIlIlllIIlIlII, 0.5f - lIIlIlllIIlIIll, 0.5f + lIIlIlllIIlIlIl, 0.5f + lIIlIlllIIlIlII, 0.5f + lIIlIlllIIlIIll);
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final World lIIllIIIlIlIIIl, final BlockPos lIIllIIIlIlIIII, final IBlockState lIIllIIIlIIllll) {
        return null;
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lIIllIIIIllIlll, final BlockPos lIIllIIIIllIIII) {
        for (final EnumFacing lIIllIIIIllIIlI : EnumFacing.values()) {
            if (lIIllIIIIllIlll.getBlockState(lIIllIIIIllIIII.offset(lIIllIIIIllIIlI)).getBlock().isNormalCube()) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean canProvidePower() {
        return true;
    }
    
    @Override
    public boolean onBlockActivated(final World lIIlIllllIlIlIl, final BlockPos lIIlIllllIlIlII, final IBlockState lIIlIllllIIlIlI, final EntityPlayer lIIlIllllIlIIlI, final EnumFacing lIIlIllllIlIIIl, final float lIIlIllllIlIIII, final float lIIlIllllIIllll, final float lIIlIllllIIlllI) {
        if (lIIlIllllIIlIlI.getValue(BlockButton.POWERED_PROP)) {
            return true;
        }
        lIIlIllllIlIlIl.setBlockState(lIIlIllllIlIlII, lIIlIllllIIlIlI.withProperty(BlockButton.POWERED_PROP, true), 3);
        lIIlIllllIlIlIl.markBlockRangeForRenderUpdate(lIIlIllllIlIlII, lIIlIllllIlIlII);
        lIIlIllllIlIlIl.playSoundEffect(lIIlIllllIlIlII.getX() + 0.5, lIIlIllllIlIlII.getY() + 0.5, lIIlIllllIlIlII.getZ() + 0.5, "random.click", 0.3f, 0.6f);
        this.func_176582_b(lIIlIllllIlIlIl, lIIlIllllIlIlII, (EnumFacing)lIIlIllllIIlIlI.getValue(BlockButton.FACING_PROP));
        lIIlIllllIlIlIl.scheduleUpdate(lIIlIllllIlIlII, this, this.tickRate(lIIlIllllIlIlIl));
        return true;
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockButton.FACING_PROP, BlockButton.POWERED_PROP });
    }
    
    @Override
    public int tickRate(final World lIIllIIIlIIllII) {
        return this.wooden ? 30 : 20;
    }
    
    @Override
    public int isProvidingStrongPower(final IBlockAccess lIIlIlllIllIIll, final BlockPos lIIlIlllIllIIlI, final IBlockState lIIlIlllIllIIIl, final EnumFacing lIIlIlllIllIIII) {
        return lIIlIlllIllIIIl.getValue(BlockButton.POWERED_PROP) ? ((lIIlIlllIllIIIl.getValue(BlockButton.FACING_PROP) == lIIlIlllIllIIII) ? 15 : 0) : 0;
    }
    
    @Override
    public void onEntityCollidedWithBlock(final World lIIlIlllIIIlIIl, final BlockPos lIIlIlllIIIIIll, final IBlockState lIIlIlllIIIIIlI, final Entity lIIlIlllIIIIllI) {
        if (!lIIlIlllIIIlIIl.isRemote && this.wooden && !(boolean)lIIlIlllIIIIIlI.getValue(BlockButton.POWERED_PROP)) {
            this.func_180680_f(lIIlIlllIIIlIIl, lIIlIlllIIIIIll, lIIlIlllIIIIIlI);
        }
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lIIllIIIIIlllIl, final BlockPos lIIllIIIIIlllII, final EnumFacing lIIllIIIIlIIlII, final float lIIllIIIIlIIIll, final float lIIllIIIIlIIIlI, final float lIIllIIIIlIIIIl, final int lIIllIIIIlIIIII, final EntityLivingBase lIIllIIIIIlllll) {
        return lIIllIIIIIlllIl.getBlockState(lIIllIIIIIlllII.offset(lIIllIIIIlIIlII.getOpposite())).getBlock().isNormalCube() ? this.getDefaultState().withProperty(BlockButton.FACING_PROP, lIIllIIIIlIIlII).withProperty(BlockButton.POWERED_PROP, false) : this.getDefaultState().withProperty(BlockButton.FACING_PROP, EnumFacing.DOWN).withProperty(BlockButton.POWERED_PROP, false);
    }
    
    @Override
    public boolean canPlaceBlockOnSide(final World lIIllIIIlIIIlII, final BlockPos lIIllIIIlIIIIII, final EnumFacing lIIllIIIlIIIIlI) {
        return lIIllIIIlIIIlII.getBlockState(lIIllIIIlIIIIII.offset(lIIllIIIlIIIIlI.getOpposite())).getBlock().isNormalCube();
    }
    
    @Override
    public void randomTick(final World lIIlIlllIlIlIll, final BlockPos lIIlIlllIlIlIlI, final IBlockState lIIlIlllIlIlIIl, final Random lIIlIlllIlIlIII) {
    }
    
    @Override
    public void setBlockBoundsBasedOnState(final IBlockAccess lIIlIlllllllIlI, final BlockPos lIIlIlllllllIIl) {
        this.func_180681_d(lIIlIlllllllIlI.getBlockState(lIIlIlllllllIIl));
    }
    
    @Override
    public void updateTick(final World lIIlIlllIlIIIlI, final BlockPos lIIlIlllIIlllII, final IBlockState lIIlIlllIlIIIII, final Random lIIlIlllIIlllll) {
        if (!lIIlIlllIlIIIlI.isRemote && (boolean)lIIlIlllIlIIIII.getValue(BlockButton.POWERED_PROP)) {
            if (this.wooden) {
                this.func_180680_f(lIIlIlllIlIIIlI, lIIlIlllIIlllII, lIIlIlllIlIIIII);
            }
            else {
                lIIlIlllIlIIIlI.setBlockState(lIIlIlllIIlllII, lIIlIlllIlIIIII.withProperty(BlockButton.POWERED_PROP, false));
                this.func_176582_b(lIIlIlllIlIIIlI, lIIlIlllIIlllII, (EnumFacing)lIIlIlllIlIIIII.getValue(BlockButton.FACING_PROP));
                lIIlIlllIlIIIlI.playSoundEffect(lIIlIlllIIlllII.getX() + 0.5, lIIlIlllIIlllII.getY() + 0.5, lIIlIlllIIlllII.getZ() + 0.5, "random.click", 0.3f, 0.5f);
                lIIlIlllIlIIIlI.markBlockRangeForRenderUpdate(lIIlIlllIIlllII, lIIlIlllIIlllII);
            }
        }
    }
    
    protected BlockButton(final boolean lIIllIIIlIlIlIl) {
        super(Material.circuits);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockButton.FACING_PROP, EnumFacing.NORTH).withProperty(BlockButton.POWERED_PROP, false));
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabRedstone);
        this.wooden = lIIllIIIlIlIlIl;
    }
    
    static {
        __OBFID = "CL_00000209";
        FACING_PROP = PropertyDirection.create("facing");
        POWERED_PROP = PropertyBool.create("powered");
    }
    
    private boolean func_176583_e(final World lIIllIIIIIIIIIl, final BlockPos lIIllIIIIIIIlII, final IBlockState lIIllIIIIIIIIll) {
        if (!this.canPlaceBlockAt(lIIllIIIIIIIIIl, lIIllIIIIIIIlII)) {
            this.dropBlockAsItem(lIIllIIIIIIIIIl, lIIllIIIIIIIlII, lIIllIIIIIIIIll, 0);
            lIIllIIIIIIIIIl.setBlockToAir(lIIllIIIIIIIlII);
            return false;
        }
        return true;
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    static final class SwitchEnumFacing
    {
        static final /* synthetic */ int[] field_180420_a;
        
        static {
            __OBFID = "CL_00002131";
            field_180420_a = new int[EnumFacing.values().length];
            try {
                SwitchEnumFacing.field_180420_a[EnumFacing.EAST.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumFacing.field_180420_a[EnumFacing.WEST.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumFacing.field_180420_a[EnumFacing.SOUTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchEnumFacing.field_180420_a[EnumFacing.NORTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                SwitchEnumFacing.field_180420_a[EnumFacing.UP.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                SwitchEnumFacing.field_180420_a[EnumFacing.DOWN.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
        }
    }
}
