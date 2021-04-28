package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import com.google.common.base.*;
import java.util.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.block.state.*;

public class BlockTorch extends Block
{
    public static final /* synthetic */ PropertyDirection FACING_PROP;
    
    @Override
    public void onBlockAdded(final World lllllllllllllllllIllIIIIIIIlllII, final BlockPos lllllllllllllllllIllIIIIIIIlIlll, final IBlockState lllllllllllllllllIllIIIIIIIlIllI) {
        this.func_176593_f(lllllllllllllllllIllIIIIIIIlllII, lllllllllllllllllIllIIIIIIIlIlll, lllllllllllllllllIllIIIIIIIlIllI);
    }
    
    protected boolean func_176592_e(final World lllllllllllllllllIlIllllllllllll, final BlockPos lllllllllllllllllIlIllllllllIllI, final IBlockState lllllllllllllllllIlIllllllllllIl) {
        if (!this.func_176593_f(lllllllllllllllllIlIllllllllllll, lllllllllllllllllIlIllllllllIllI, lllllllllllllllllIlIllllllllllIl)) {
            return true;
        }
        final EnumFacing lllllllllllllllllIlIllllllllllII = (EnumFacing)lllllllllllllllllIlIllllllllllIl.getValue(BlockTorch.FACING_PROP);
        final EnumFacing.Axis lllllllllllllllllIlIlllllllllIll = lllllllllllllllllIlIllllllllllII.getAxis();
        final EnumFacing lllllllllllllllllIlIlllllllllIlI = lllllllllllllllllIlIllllllllllII.getOpposite();
        boolean lllllllllllllllllIlIlllllllllIIl = false;
        if (lllllllllllllllllIlIlllllllllIll.isHorizontal() && !lllllllllllllllllIlIllllllllllll.func_175677_d(lllllllllllllllllIlIllllllllIllI.offset(lllllllllllllllllIlIlllllllllIlI), true)) {
            lllllllllllllllllIlIlllllllllIIl = true;
        }
        else if (lllllllllllllllllIlIlllllllllIll.isVertical() && !this.func_176594_d(lllllllllllllllllIlIllllllllllll, lllllllllllllllllIlIllllllllIllI.offset(lllllllllllllllllIlIlllllllllIlI))) {
            lllllllllllllllllIlIlllllllllIIl = true;
        }
        if (lllllllllllllllllIlIlllllllllIIl) {
            this.dropBlockAsItem(lllllllllllllllllIlIllllllllllll, lllllllllllllllllIlIllllllllIllI, lllllllllllllllllIlIllllllllllIl, 0);
            lllllllllllllllllIlIllllllllllll.setBlockToAir(lllllllllllllllllIlIllllllllIllI);
            return true;
        }
        return false;
    }
    
    private boolean func_176594_d(final World lllllllllllllllllIllIIIIIlIlllll, final BlockPos lllllllllllllllllIllIIIIIlIllllI) {
        if (World.doesBlockHaveSolidTopSurface(lllllllllllllllllIllIIIIIlIlllll, lllllllllllllllllIllIIIIIlIllllI)) {
            return true;
        }
        final Block lllllllllllllllllIllIIIIIlIlllIl = lllllllllllllllllIllIIIIIlIlllll.getBlockState(lllllllllllllllllIllIIIIIlIllllI).getBlock();
        return lllllllllllllllllIllIIIIIlIlllIl instanceof BlockFence || lllllllllllllllllIllIIIIIlIlllIl == Blocks.glass || lllllllllllllllllIllIIIIIlIlllIl == Blocks.cobblestone_wall || lllllllllllllllllIllIIIIIlIlllIl == Blocks.stained_glass;
    }
    
    static {
        __OBFID = "CL_00000325";
        FACING_PROP = PropertyDirection.create("facing", (Predicate)new Predicate() {
            static {
                __OBFID = "CL_00002054";
            }
            
            public boolean apply(final Object llllllllllllllIlllIllllIIllIllll) {
                return this.func_176601_a((EnumFacing)llllllllllllllIlllIllllIIllIllll);
            }
            
            public boolean func_176601_a(final EnumFacing llllllllllllllIlllIllllIIlllIllI) {
                return llllllllllllllIlllIllllIIlllIllI != EnumFacing.DOWN;
            }
        });
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    @Override
    public void onNeighborBlockChange(final World lllllllllllllllllIllIIIIIIIIlIll, final BlockPos lllllllllllllllllIllIIIIIIIIlIlI, final IBlockState lllllllllllllllllIllIIIIIIIIlIIl, final Block lllllllllllllllllIllIIIIIIIIllIl) {
        this.func_176592_e(lllllllllllllllllIllIIIIIIIIlIll, lllllllllllllllllIllIIIIIIIIlIlI, lllllllllllllllllIllIIIIIIIIlIIl);
    }
    
    @Override
    public MovingObjectPosition collisionRayTrace(final World lllllllllllllllllIlIllllllIlllII, final BlockPos lllllllllllllllllIlIllllllIlIlII, final Vec3 lllllllllllllllllIlIllllllIllIlI, final Vec3 lllllllllllllllllIlIllllllIllIIl) {
        final EnumFacing lllllllllllllllllIlIllllllIllIII = (EnumFacing)lllllllllllllllllIlIllllllIlllII.getBlockState(lllllllllllllllllIlIllllllIlIlII).getValue(BlockTorch.FACING_PROP);
        float lllllllllllllllllIlIllllllIlIlll = 0.15f;
        if (lllllllllllllllllIlIllllllIllIII == EnumFacing.EAST) {
            this.setBlockBounds(0.0f, 0.2f, 0.5f - lllllllllllllllllIlIllllllIlIlll, lllllllllllllllllIlIllllllIlIlll * 2.0f, 0.8f, 0.5f + lllllllllllllllllIlIllllllIlIlll);
        }
        else if (lllllllllllllllllIlIllllllIllIII == EnumFacing.WEST) {
            this.setBlockBounds(1.0f - lllllllllllllllllIlIllllllIlIlll * 2.0f, 0.2f, 0.5f - lllllllllllllllllIlIllllllIlIlll, 1.0f, 0.8f, 0.5f + lllllllllllllllllIlIllllllIlIlll);
        }
        else if (lllllllllllllllllIlIllllllIllIII == EnumFacing.SOUTH) {
            this.setBlockBounds(0.5f - lllllllllllllllllIlIllllllIlIlll, 0.2f, 0.0f, 0.5f + lllllllllllllllllIlIllllllIlIlll, 0.8f, lllllllllllllllllIlIllllllIlIlll * 2.0f);
        }
        else if (lllllllllllllllllIlIllllllIllIII == EnumFacing.NORTH) {
            this.setBlockBounds(0.5f - lllllllllllllllllIlIllllllIlIlll, 0.2f, 1.0f - lllllllllllllllllIlIllllllIlIlll * 2.0f, 0.5f + lllllllllllllllllIlIllllllIlIlll, 0.8f, 1.0f);
        }
        else {
            lllllllllllllllllIlIllllllIlIlll = 0.1f;
            this.setBlockBounds(0.5f - lllllllllllllllllIlIllllllIlIlll, 0.0f, 0.5f - lllllllllllllllllIlIllllllIlIlll, 0.5f + lllllllllllllllllIlIllllllIlIlll, 0.6f, 0.5f + lllllllllllllllllIlIllllllIlIlll);
        }
        return super.collisionRayTrace(lllllllllllllllllIlIllllllIlllII, lllllllllllllllllIlIllllllIlIlII, lllllllllllllllllIlIllllllIllIlI, lllllllllllllllllIlIllllllIllIIl);
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllllIlIlllllIlIIIIl) {
        final byte lllllllllllllllllIlIlllllIlIIIII = 0;
        final int lllllllllllllllllIlIlllllIIllIll;
        switch (SwitchEnumFacing.field_176609_a[((EnumFacing)lllllllllllllllllIlIlllllIlIIIIl.getValue(BlockTorch.FACING_PROP)).ordinal()]) {
            case 1: {
                final int lllllllllllllllllIlIlllllIIlllll = lllllllllllllllllIlIlllllIlIIIII | 0x1;
                break;
            }
            case 2: {
                final int lllllllllllllllllIlIlllllIIllllI = lllllllllllllllllIlIlllllIlIIIII | 0x2;
                break;
            }
            case 3: {
                final int lllllllllllllllllIlIlllllIIlllIl = lllllllllllllllllIlIlllllIlIIIII | 0x3;
                break;
            }
            case 4: {
                final int lllllllllllllllllIlIlllllIIlllII = lllllllllllllllllIlIlllllIlIIIII | 0x4;
                break;
            }
            default: {
                lllllllllllllllllIlIlllllIIllIll = (lllllllllllllllllIlIlllllIlIIIII | 0x5);
                break;
            }
        }
        return lllllllllllllllllIlIlllllIIllIll;
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllllllllIllIIIIIlIlIIll, final BlockPos lllllllllllllllllIllIIIIIlIlIIlI) {
        for (final EnumFacing lllllllllllllllllIllIIIIIlIlIIII : BlockTorch.FACING_PROP.getAllowedValues()) {
            if (this.func_176595_b(lllllllllllllllllIllIIIIIlIlIIll, lllllllllllllllllIllIIIIIlIlIIlI, lllllllllllllllllIllIIIIIlIlIIII)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.CUTOUT;
    }
    
    @Override
    public void randomDisplayTick(final World lllllllllllllllllIlIllllllIIIlII, final BlockPos lllllllllllllllllIlIlllllIllIlll, final IBlockState lllllllllllllllllIlIlllllIllIllI, final Random lllllllllllllllllIlIllllllIIIIIl) {
        final EnumFacing lllllllllllllllllIlIllllllIIIIII = (EnumFacing)lllllllllllllllllIlIlllllIllIllI.getValue(BlockTorch.FACING_PROP);
        final double lllllllllllllllllIlIlllllIllllll = lllllllllllllllllIlIlllllIllIlll.getX() + 0.5;
        final double lllllllllllllllllIlIlllllIlllllI = lllllllllllllllllIlIlllllIllIlll.getY() + 0.7;
        final double lllllllllllllllllIlIlllllIllllIl = lllllllllllllllllIlIlllllIllIlll.getZ() + 0.5;
        final double lllllllllllllllllIlIlllllIllllII = 0.22;
        final double lllllllllllllllllIlIlllllIlllIll = 0.27;
        if (lllllllllllllllllIlIllllllIIIIII.getAxis().isHorizontal()) {
            final EnumFacing lllllllllllllllllIlIlllllIlllIlI = lllllllllllllllllIlIllllllIIIIII.getOpposite();
            lllllllllllllllllIlIllllllIIIlII.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, lllllllllllllllllIlIlllllIllllll + lllllllllllllllllIlIlllllIlllIll * lllllllllllllllllIlIlllllIlllIlI.getFrontOffsetX(), lllllllllllllllllIlIlllllIlllllI + lllllllllllllllllIlIlllllIllllII, lllllllllllllllllIlIlllllIllllIl + lllllllllllllllllIlIlllllIlllIll * lllllllllllllllllIlIlllllIlllIlI.getFrontOffsetZ(), 0.0, 0.0, 0.0, new int[0]);
            lllllllllllllllllIlIllllllIIIlII.spawnParticle(EnumParticleTypes.FLAME, lllllllllllllllllIlIlllllIllllll + lllllllllllllllllIlIlllllIlllIll * lllllllllllllllllIlIlllllIlllIlI.getFrontOffsetX(), lllllllllllllllllIlIlllllIlllllI + lllllllllllllllllIlIlllllIllllII, lllllllllllllllllIlIlllllIllllIl + lllllllllllllllllIlIlllllIlllIll * lllllllllllllllllIlIlllllIlllIlI.getFrontOffsetZ(), 0.0, 0.0, 0.0, new int[0]);
        }
        else {
            lllllllllllllllllIlIllllllIIIlII.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, lllllllllllllllllIlIlllllIllllll, lllllllllllllllllIlIlllllIlllllI, lllllllllllllllllIlIlllllIllllIl, 0.0, 0.0, 0.0, new int[0]);
            lllllllllllllllllIlIllllllIIIlII.spawnParticle(EnumParticleTypes.FLAME, lllllllllllllllllIlIlllllIllllll, lllllllllllllllllIlIlllllIlllllI, lllllllllllllllllIlIlllllIllllIl, 0.0, 0.0, 0.0, new int[0]);
        }
    }
    
    protected boolean func_176593_f(final World lllllllllllllllllIlIlllllllIlIll, final BlockPos lllllllllllllllllIlIlllllllIIllI, final IBlockState lllllllllllllllllIlIlllllllIlIIl) {
        if (lllllllllllllllllIlIlllllllIlIIl.getBlock() == this && this.func_176595_b(lllllllllllllllllIlIlllllllIlIll, lllllllllllllllllIlIlllllllIIllI, (EnumFacing)lllllllllllllllllIlIlllllllIlIIl.getValue(BlockTorch.FACING_PROP))) {
            return true;
        }
        if (lllllllllllllllllIlIlllllllIlIll.getBlockState(lllllllllllllllllIlIlllllllIIllI).getBlock() == this) {
            this.dropBlockAsItem(lllllllllllllllllIlIlllllllIlIll, lllllllllllllllllIlIlllllllIIllI, lllllllllllllllllIlIlllllllIlIIl, 0);
            lllllllllllllllllIlIlllllllIlIll.setBlockToAir(lllllllllllllllllIlIlllllllIIllI);
        }
        return false;
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllllllllIllIIIIIIlIIllI, final BlockPos lllllllllllllllllIllIIIIIIlIIlIl, final EnumFacing lllllllllllllllllIllIIIIIIlIllll, final float lllllllllllllllllIllIIIIIIlIlllI, final float lllllllllllllllllIllIIIIIIlIllIl, final float lllllllllllllllllIllIIIIIIlIllII, final int lllllllllllllllllIllIIIIIIlIlIll, final EntityLivingBase lllllllllllllllllIllIIIIIIlIlIlI) {
        if (this.func_176595_b(lllllllllllllllllIllIIIIIIlIIllI, lllllllllllllllllIllIIIIIIlIIlIl, lllllllllllllllllIllIIIIIIlIllll)) {
            return this.getDefaultState().withProperty(BlockTorch.FACING_PROP, lllllllllllllllllIllIIIIIIlIllll);
        }
        for (final EnumFacing lllllllllllllllllIllIIIIIIlIlIII : EnumFacing.Plane.HORIZONTAL) {
            if (lllllllllllllllllIllIIIIIIlIIllI.func_175677_d(lllllllllllllllllIllIIIIIIlIIlIl.offset(lllllllllllllllllIllIIIIIIlIlIII.getOpposite()), true)) {
                return this.getDefaultState().withProperty(BlockTorch.FACING_PROP, lllllllllllllllllIllIIIIIIlIlIII);
            }
        }
        return this.getDefaultState();
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final World lllllllllllllllllIllIIIIIllIlIII, final BlockPos lllllllllllllllllIllIIIIIllIIlll, final IBlockState lllllllllllllllllIllIIIIIllIIllI) {
        return null;
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    protected BlockTorch() {
        super(Material.circuits);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockTorch.FACING_PROP, EnumFacing.UP));
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockTorch.FACING_PROP });
    }
    
    private boolean func_176595_b(final World lllllllllllllllllIllIIIIIlIIIIll, final BlockPos lllllllllllllllllIllIIIIIIllllII, final EnumFacing lllllllllllllllllIllIIIIIIlllIll) {
        final BlockPos lllllllllllllllllIllIIIIIlIIIIII = lllllllllllllllllIllIIIIIIllllII.offset(lllllllllllllllllIllIIIIIIlllIll.getOpposite());
        final boolean lllllllllllllllllIllIIIIIIllllll = lllllllllllllllllIllIIIIIIlllIll.getAxis().isHorizontal();
        return (lllllllllllllllllIllIIIIIIllllll && lllllllllllllllllIllIIIIIlIIIIll.func_175677_d(lllllllllllllllllIllIIIIIlIIIIII, true)) || (lllllllllllllllllIllIIIIIIlllIll.equals(EnumFacing.UP) && this.func_176594_d(lllllllllllllllllIllIIIIIlIIIIll, lllllllllllllllllIllIIIIIlIIIIII));
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllllIlIlllllIlIIlll) {
        IBlockState lllllllllllllllllIlIlllllIlIlIIl = this.getDefaultState();
        switch (lllllllllllllllllIlIlllllIlIIlll) {
            case 1: {
                lllllllllllllllllIlIlllllIlIlIIl = lllllllllllllllllIlIlllllIlIlIIl.withProperty(BlockTorch.FACING_PROP, EnumFacing.EAST);
                break;
            }
            case 2: {
                lllllllllllllllllIlIlllllIlIlIIl = lllllllllllllllllIlIlllllIlIlIIl.withProperty(BlockTorch.FACING_PROP, EnumFacing.WEST);
                break;
            }
            case 3: {
                lllllllllllllllllIlIlllllIlIlIIl = lllllllllllllllllIlIlllllIlIlIIl.withProperty(BlockTorch.FACING_PROP, EnumFacing.SOUTH);
                break;
            }
            case 4: {
                lllllllllllllllllIlIlllllIlIlIIl = lllllllllllllllllIlIlllllIlIlIIl.withProperty(BlockTorch.FACING_PROP, EnumFacing.NORTH);
                break;
            }
            default: {
                lllllllllllllllllIlIlllllIlIlIIl = lllllllllllllllllIlIlllllIlIlIIl.withProperty(BlockTorch.FACING_PROP, EnumFacing.UP);
                break;
            }
        }
        return lllllllllllllllllIlIlllllIlIlIIl;
    }
    
    static final class SwitchEnumFacing
    {
        static final /* synthetic */ int[] field_176609_a;
        
        static {
            __OBFID = "CL_00002053";
            field_176609_a = new int[EnumFacing.values().length];
            try {
                SwitchEnumFacing.field_176609_a[EnumFacing.EAST.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumFacing.field_176609_a[EnumFacing.WEST.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumFacing.field_176609_a[EnumFacing.SOUTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchEnumFacing.field_176609_a[EnumFacing.NORTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                SwitchEnumFacing.field_176609_a[EnumFacing.DOWN.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                SwitchEnumFacing.field_176609_a[EnumFacing.UP.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
        }
    }
}
