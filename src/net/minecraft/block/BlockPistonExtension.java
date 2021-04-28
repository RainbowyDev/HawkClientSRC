package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.util.*;

public class BlockPistonExtension extends Block
{
    public static final /* synthetic */ PropertyDirection field_176326_a;
    public static final /* synthetic */ PropertyEnum field_176325_b;
    public static final /* synthetic */ PropertyBool field_176327_M;
    
    private void func_176323_e(final IBlockState lllllllllllllllIIlIIIIllllllllIl) {
        final float lllllllllllllllIIlIIIIllllllllII = 0.25f;
        final float lllllllllllllllIIlIIIIlllllllIll = 0.375f;
        final float lllllllllllllllIIlIIIIlllllllIlI = 0.625f;
        final float lllllllllllllllIIlIIIIlllllllIIl = 0.25f;
        final float lllllllllllllllIIlIIIIlllllllIII = 0.75f;
        switch (SwitchEnumFacing.field_177247_a[((EnumFacing)lllllllllllllllIIlIIIIllllllllIl.getValue(BlockPistonExtension.field_176326_a)).ordinal()]) {
            case 1: {
                this.setBlockBounds(0.375f, 0.25f, 0.375f, 0.625f, 1.0f, 0.625f);
                break;
            }
            case 2: {
                this.setBlockBounds(0.375f, 0.0f, 0.375f, 0.625f, 0.75f, 0.625f);
                break;
            }
            case 3: {
                this.setBlockBounds(0.25f, 0.375f, 0.25f, 0.75f, 0.625f, 1.0f);
                break;
            }
            case 4: {
                this.setBlockBounds(0.25f, 0.375f, 0.0f, 0.75f, 0.625f, 0.75f);
                break;
            }
            case 5: {
                this.setBlockBounds(0.375f, 0.25f, 0.25f, 0.625f, 0.75f, 1.0f);
                break;
            }
            case 6: {
                this.setBlockBounds(0.0f, 0.375f, 0.25f, 0.75f, 0.625f, 0.75f);
                break;
            }
        }
    }
    
    @Override
    public void onNeighborBlockChange(final World lllllllllllllllIIlIIIIllllIlIIll, final BlockPos lllllllllllllllIIlIIIIllllIIlIll, final IBlockState lllllllllllllllIIlIIIIllllIlIIIl, final Block lllllllllllllllIIlIIIIllllIIlIIl) {
        final EnumFacing lllllllllllllllIIlIIIIllllIIllll = (EnumFacing)lllllllllllllllIIlIIIIllllIlIIIl.getValue(BlockPistonExtension.field_176326_a);
        final BlockPos lllllllllllllllIIlIIIIllllIIlllI = lllllllllllllllIIlIIIIllllIIlIll.offset(lllllllllllllllIIlIIIIllllIIllll.getOpposite());
        final IBlockState lllllllllllllllIIlIIIIllllIIllIl = lllllllllllllllIIlIIIIllllIlIIll.getBlockState(lllllllllllllllIIlIIIIllllIIlllI);
        if (lllllllllllllllIIlIIIIllllIIllIl.getBlock() != Blocks.piston && lllllllllllllllIIlIIIIllllIIllIl.getBlock() != Blocks.sticky_piston) {
            lllllllllllllllIIlIIIIllllIlIIll.setBlockToAir(lllllllllllllllIIlIIIIllllIIlIll);
        }
        else {
            lllllllllllllllIIlIIIIllllIIllIl.getBlock().onNeighborBlockChange(lllllllllllllllIIlIIIIllllIlIIll, lllllllllllllllIIlIIIIllllIIlllI, lllllllllllllllIIlIIIIllllIIllIl, lllllllllllllllIIlIIIIllllIIlIIl);
        }
    }
    
    @Override
    public void breakBlock(final World lllllllllllllllIIlIIIlIIIIllIIII, BlockPos lllllllllllllllIIlIIIlIIIIlIlIIl, final IBlockState lllllllllllllllIIlIIIlIIIIlIlllI) {
        super.breakBlock(lllllllllllllllIIlIIIlIIIIllIIII, lllllllllllllllIIlIIIlIIIIlIlIIl, lllllllllllllllIIlIIIlIIIIlIlllI);
        final EnumFacing lllllllllllllllIIlIIIlIIIIlIllIl = ((EnumFacing)lllllllllllllllIIlIIIlIIIIlIlllI.getValue(BlockPistonExtension.field_176326_a)).getOpposite();
        lllllllllllllllIIlIIIlIIIIlIlIIl = lllllllllllllllIIlIIIlIIIIlIlIIl.offset(lllllllllllllllIIlIIIlIIIIlIllIl);
        final IBlockState lllllllllllllllIIlIIIlIIIIlIllII = lllllllllllllllIIlIIIlIIIIllIIII.getBlockState(lllllllllllllllIIlIIIlIIIIlIlIIl);
        if ((lllllllllllllllIIlIIIlIIIIlIllII.getBlock() == Blocks.piston || lllllllllllllllIIlIIIlIIIIlIllII.getBlock() == Blocks.sticky_piston) && (boolean)lllllllllllllllIIlIIIlIIIIlIllII.getValue(BlockPistonBase.EXTENDED)) {
            lllllllllllllllIIlIIIlIIIIlIllII.getBlock().dropBlockAsItem(lllllllllllllllIIlIIIlIIIIllIIII, lllllllllllllllIIlIIIlIIIIlIlIIl, lllllllllllllllIIlIIIlIIIIlIllII, 0);
            lllllllllllllllIIlIIIlIIIIllIIII.setBlockToAir(lllllllllllllllIIlIIIlIIIIlIlIIl);
        }
    }
    
    public BlockPistonExtension() {
        super(Material.piston);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockPistonExtension.field_176326_a, EnumFacing.NORTH).withProperty(BlockPistonExtension.field_176325_b, EnumPistonType.DEFAULT).withProperty(BlockPistonExtension.field_176327_M, false));
        this.setStepSound(BlockPistonExtension.soundTypePiston);
        this.setHardness(0.5f);
    }
    
    public static EnumFacing func_176322_b(final int lllllllllllllllIIlIIIIlllIllllIl) {
        final int lllllllllllllllIIlIIIIlllIlllllI = lllllllllllllllIIlIIIIlllIllllIl & 0x7;
        return (lllllllllllllllIIlIIIIlllIlllllI > 5) ? null : EnumFacing.getFront(lllllllllllllllIIlIIIIlllIlllllI);
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllllllIIlIIIlIIIIlIIIlI, final BlockPos lllllllllllllllIIlIIIlIIIIlIIIIl) {
        return false;
    }
    
    @Override
    public void setBlockBoundsBasedOnState(final IBlockAccess lllllllllllllllIIlIIIIlllllIlIIl, final BlockPos lllllllllllllllIIlIIIIlllllIlIII) {
        this.func_176324_d(lllllllllllllllIIlIIIIlllllIlIIl.getBlockState(lllllllllllllllIIlIIIIlllllIlIII));
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockAccess lllllllllllllllIIlIIIIllllIIIlII, final BlockPos lllllllllllllllIIlIIIIllllIIIIll, final EnumFacing lllllllllllllllIIlIIIIllllIIIIlI) {
        return true;
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    @Override
    public boolean canPlaceBlockOnSide(final World lllllllllllllllIIlIIIlIIIIIlllll, final BlockPos lllllllllllllllIIlIIIlIIIIIllllI, final EnumFacing lllllllllllllllIIlIIIlIIIIIlllIl) {
        return false;
    }
    
    @Override
    public Item getItem(final World lllllllllllllllIIlIIIIlllIlllIII, final BlockPos lllllllllllllllIIlIIIIlllIllIlIl) {
        return (lllllllllllllllIIlIIIIlllIlllIII.getBlockState(lllllllllllllllIIlIIIIlllIllIlIl).getValue(BlockPistonExtension.field_176325_b) == EnumPistonType.STICKY) ? Item.getItemFromBlock(Blocks.sticky_piston) : Item.getItemFromBlock(Blocks.piston);
    }
    
    @Override
    public void addCollisionBoxesToList(final World lllllllllllllllIIlIIIlIIIIIIlIll, final BlockPos lllllllllllllllIIlIIIlIIIIIlIIIl, final IBlockState lllllllllllllllIIlIIIlIIIIIIlIIl, final AxisAlignedBB lllllllllllllllIIlIIIlIIIIIIllll, final List lllllllllllllllIIlIIIlIIIIIIlllI, final Entity lllllllllllllllIIlIIIlIIIIIIllIl) {
        this.func_176324_d(lllllllllllllllIIlIIIlIIIIIIlIIl);
        super.addCollisionBoxesToList(lllllllllllllllIIlIIIlIIIIIIlIll, lllllllllllllllIIlIIIlIIIIIlIIIl, lllllllllllllllIIlIIIlIIIIIIlIIl, lllllllllllllllIIlIIIlIIIIIIllll, lllllllllllllllIIlIIIlIIIIIIlllI, lllllllllllllllIIlIIIlIIIIIIllIl);
        this.func_176323_e(lllllllllllllllIIlIIIlIIIIIIlIIl);
        super.addCollisionBoxesToList(lllllllllllllllIIlIIIlIIIIIIlIll, lllllllllllllllIIlIIIlIIIIIlIIIl, lllllllllllllllIIlIIIlIIIIIIlIIl, lllllllllllllllIIlIIIlIIIIIIllll, lllllllllllllllIIlIIIlIIIIIIlllI, lllllllllllllllIIlIIIlIIIIIIllIl);
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }
    
    @Override
    public void onBlockHarvested(final World lllllllllllllllIIlIIIlIIIIlllllI, final BlockPos lllllllllllllllIIlIIIlIIIlIIIlIl, final IBlockState lllllllllllllllIIlIIIlIIIIllllII, final EntityPlayer lllllllllllllllIIlIIIlIIIlIIIIll) {
        if (lllllllllllllllIIlIIIlIIIlIIIIll.capabilities.isCreativeMode) {
            final EnumFacing lllllllllllllllIIlIIIlIIIlIIIIlI = (EnumFacing)lllllllllllllllIIlIIIlIIIIllllII.getValue(BlockPistonExtension.field_176326_a);
            if (lllllllllllllllIIlIIIlIIIlIIIIlI != null) {
                final BlockPos lllllllllllllllIIlIIIlIIIlIIIIIl = lllllllllllllllIIlIIIlIIIlIIIlIl.offset(lllllllllllllllIIlIIIlIIIlIIIIlI.getOpposite());
                final Block lllllllllllllllIIlIIIlIIIlIIIIII = lllllllllllllllIIlIIIlIIIIlllllI.getBlockState(lllllllllllllllIIlIIIlIIIlIIIIIl).getBlock();
                if (lllllllllllllllIIlIIIlIIIlIIIIII == Blocks.piston || lllllllllllllllIIlIIIlIIIlIIIIII == Blocks.sticky_piston) {
                    lllllllllllllllIIlIIIlIIIIlllllI.setBlockToAir(lllllllllllllllIIlIIIlIIIlIIIIIl);
                }
            }
        }
        super.onBlockHarvested(lllllllllllllllIIlIIIlIIIIlllllI, lllllllllllllllIIlIIIlIIIlIIIlIl, lllllllllllllllIIlIIIlIIIIllllII, lllllllllllllllIIlIIIlIIIlIIIIll);
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllIIlIIIIlllIlIllll) {
        return this.getDefaultState().withProperty(BlockPistonExtension.field_176326_a, func_176322_b(lllllllllllllllIIlIIIIlllIlIllll)).withProperty(BlockPistonExtension.field_176325_b, ((lllllllllllllllIIlIIIIlllIlIllll & 0x8) > 0) ? EnumPistonType.STICKY : EnumPistonType.DEFAULT);
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockPistonExtension.field_176326_a, BlockPistonExtension.field_176325_b, BlockPistonExtension.field_176327_M });
    }
    
    public void func_176324_d(final IBlockState lllllllllllllllIIlIIIIlllllIIIlI) {
        final float lllllllllllllllIIlIIIIlllllIIIIl = 0.25f;
        final EnumFacing lllllllllllllllIIlIIIIlllllIIIII = (EnumFacing)lllllllllllllllIIlIIIIlllllIIIlI.getValue(BlockPistonExtension.field_176326_a);
        if (lllllllllllllllIIlIIIIlllllIIIII != null) {
            switch (SwitchEnumFacing.field_177247_a[lllllllllllllllIIlIIIIlllllIIIII.ordinal()]) {
                case 1: {
                    this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.25f, 1.0f);
                    break;
                }
                case 2: {
                    this.setBlockBounds(0.0f, 0.75f, 0.0f, 1.0f, 1.0f, 1.0f);
                    break;
                }
                case 3: {
                    this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.25f);
                    break;
                }
                case 4: {
                    this.setBlockBounds(0.0f, 0.0f, 0.75f, 1.0f, 1.0f, 1.0f);
                    break;
                }
                case 5: {
                    this.setBlockBounds(0.0f, 0.0f, 0.0f, 0.25f, 1.0f, 1.0f);
                    break;
                }
                case 6: {
                    this.setBlockBounds(0.75f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                    break;
                }
            }
        }
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllIIlIIIIlllIlIIlll) {
        final byte lllllllllllllllIIlIIIIlllIlIlIIl = 0;
        int lllllllllllllllIIlIIIIlllIlIlIII = lllllllllllllllIIlIIIIlllIlIlIIl | ((EnumFacing)lllllllllllllllIIlIIIIlllIlIIlll.getValue(BlockPistonExtension.field_176326_a)).getIndex();
        if (lllllllllllllllIIlIIIIlllIlIIlll.getValue(BlockPistonExtension.field_176325_b) == EnumPistonType.STICKY) {
            lllllllllllllllIIlIIIIlllIlIlIII |= 0x8;
        }
        return lllllllllllllllIIlIIIIlllIlIlIII;
    }
    
    @Override
    public int quantityDropped(final Random lllllllllllllllIIlIIIlIIIIIllIll) {
        return 0;
    }
    
    static {
        __OBFID = "CL_00000367";
        field_176326_a = PropertyDirection.create("facing");
        field_176325_b = PropertyEnum.create("type", EnumPistonType.class);
        field_176327_M = PropertyBool.create("short");
    }
    
    public enum EnumPistonType implements IStringSerializable
    {
        STICKY("STICKY", 1, "STICKY", 1, "sticky");
        
        private final /* synthetic */ String field_176714_c;
        
        DEFAULT("DEFAULT", 0, "DEFAULT", 0, "normal");
        
        static {
            __OBFID = "CL_00002035";
        }
        
        private EnumPistonType(final String lllllllllllllllIlIIIIlIlIIIIlIlI, final int lllllllllllllllIlIIIIlIlIIIIlIIl, final String lllllllllllllllIlIIIIlIlIIIIlllI, final int lllllllllllllllIlIIIIlIlIIIIllIl, final String lllllllllllllllIlIIIIlIlIIIIllII) {
            this.field_176714_c = lllllllllllllllIlIIIIlIlIIIIllII;
        }
        
        @Override
        public String getName() {
            return this.field_176714_c;
        }
        
        @Override
        public String toString() {
            return this.field_176714_c;
        }
    }
    
    static final class SwitchEnumFacing
    {
        static final /* synthetic */ int[] field_177247_a;
        
        static {
            __OBFID = "CL_00002036";
            field_177247_a = new int[EnumFacing.values().length];
            try {
                SwitchEnumFacing.field_177247_a[EnumFacing.DOWN.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumFacing.field_177247_a[EnumFacing.UP.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumFacing.field_177247_a[EnumFacing.NORTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchEnumFacing.field_177247_a[EnumFacing.SOUTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                SwitchEnumFacing.field_177247_a[EnumFacing.WEST.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                SwitchEnumFacing.field_177247_a[EnumFacing.EAST.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
        }
    }
}
