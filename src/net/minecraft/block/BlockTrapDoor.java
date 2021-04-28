package net.minecraft.block;

import net.minecraft.world.*;
import com.google.common.base.*;
import net.minecraft.block.properties.*;
import net.minecraft.init.*;
import net.minecraft.entity.player.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.*;
import net.minecraft.creativetab.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;

public class BlockTrapDoor extends Block
{
    public static final /* synthetic */ PropertyBool field_176283_b;
    public static final /* synthetic */ PropertyEnum field_176285_M;
    public static final /* synthetic */ PropertyDirection field_176284_a;
    
    @Override
    public AxisAlignedBB getSelectedBoundingBox(final World lllllllllllllllllIIIlIIllIIllIll, final BlockPos lllllllllllllllllIIIlIIllIIllIlI) {
        this.setBlockBoundsBasedOnState(lllllllllllllllllIIIlIIllIIllIll, lllllllllllllllllIIIlIIllIIllIlI);
        return super.getSelectedBoundingBox(lllllllllllllllllIIIlIIllIIllIll, lllllllllllllllllIIIlIIllIIllIlI);
    }
    
    protected static EnumFacing func_176281_b(final int lllllllllllllllllIIIlIIIlllllIIl) {
        switch (lllllllllllllllllIIIlIIIlllllIIl & 0x3) {
            case 0: {
                return EnumFacing.NORTH;
            }
            case 1: {
                return EnumFacing.SOUTH;
            }
            case 2: {
                return EnumFacing.WEST;
            }
            default: {
                return EnumFacing.EAST;
            }
        }
    }
    
    static {
        __OBFID = "CL_00000327";
        field_176284_a = PropertyDirection.create("facing", (Predicate)EnumFacing.Plane.HORIZONTAL);
        field_176283_b = PropertyBool.create("open");
        field_176285_M = PropertyEnum.create("half", DoorHalf.class);
    }
    
    public void func_180693_d(final IBlockState lllllllllllllllllIIIlIIlIlIllIll) {
        if (lllllllllllllllllIIIlIIlIlIllIll.getBlock() == this) {
            final boolean lllllllllllllllllIIIlIIlIlIllIlI = lllllllllllllllllIIIlIIlIlIllIll.getValue(BlockTrapDoor.field_176285_M) == DoorHalf.TOP;
            final Boolean lllllllllllllllllIIIlIIlIlIllIIl = (Boolean)lllllllllllllllllIIIlIIlIlIllIll.getValue(BlockTrapDoor.field_176283_b);
            final EnumFacing lllllllllllllllllIIIlIIlIlIllIII = (EnumFacing)lllllllllllllllllIIIlIIlIlIllIll.getValue(BlockTrapDoor.field_176284_a);
            final float lllllllllllllllllIIIlIIlIlIlIlll = 0.1875f;
            if (lllllllllllllllllIIIlIIlIlIllIlI) {
                this.setBlockBounds(0.0f, 0.8125f, 0.0f, 1.0f, 1.0f, 1.0f);
            }
            else {
                this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.1875f, 1.0f);
            }
            if (lllllllllllllllllIIIlIIlIlIllIIl) {
                if (lllllllllllllllllIIIlIIlIlIllIII == EnumFacing.NORTH) {
                    this.setBlockBounds(0.0f, 0.0f, 0.8125f, 1.0f, 1.0f, 1.0f);
                }
                if (lllllllllllllllllIIIlIIlIlIllIII == EnumFacing.SOUTH) {
                    this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.1875f);
                }
                if (lllllllllllllllllIIIlIIlIlIllIII == EnumFacing.WEST) {
                    this.setBlockBounds(0.8125f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                }
                if (lllllllllllllllllIIIlIIlIlIllIII == EnumFacing.EAST) {
                    this.setBlockBounds(0.0f, 0.0f, 0.0f, 0.1875f, 1.0f, 1.0f);
                }
            }
        }
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    @Override
    public void setBlockBoundsForItemRender() {
        final float lllllllllllllllllIIIlIIlIlllIIIl = 0.1875f;
        this.setBlockBounds(0.0f, 0.40625f, 0.0f, 1.0f, 0.59375f, 1.0f);
    }
    
    protected static int func_176282_a(final EnumFacing lllllllllllllllllIIIlIIIllllIllI) {
        switch (SwitchEnumFacing.field_177058_a[lllllllllllllllllIIIlIIIllllIllI.ordinal()]) {
            case 1: {
                return 0;
            }
            case 2: {
                return 1;
            }
            case 3: {
                return 2;
            }
            default: {
                return 3;
            }
        }
    }
    
    private static boolean isValidSupportBlock(final Block lllllllllllllllllIIIlIIIllllIIlI) {
        return (lllllllllllllllllIIIlIIIllllIIlI.blockMaterial.isOpaque() && lllllllllllllllllIIIlIIIllllIIlI.isFullCube()) || lllllllllllllllllIIIlIIIllllIIlI == Blocks.glowstone || lllllllllllllllllIIIlIIIllllIIlI instanceof BlockSlab || lllllllllllllllllIIIlIIIllllIIlI instanceof BlockStairs;
    }
    
    @Override
    public boolean canPlaceBlockOnSide(final World lllllllllllllllllIIIlIIlIIIIIIII, final BlockPos lllllllllllllllllIIIlIIIllllllll, final EnumFacing lllllllllllllllllIIIlIIIlllllIll) {
        return !lllllllllllllllllIIIlIIIlllllIll.getAxis().isVertical() && isValidSupportBlock(lllllllllllllllllIIIlIIlIIIIIIII.getBlockState(lllllllllllllllllIIIlIIIllllllll.offset(lllllllllllllllllIIIlIIIlllllIll.getOpposite())).getBlock());
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllllIIIlIIIlllIlIll) {
        return this.getDefaultState().withProperty(BlockTrapDoor.field_176284_a, func_176281_b(lllllllllllllllllIIIlIIIlllIlIll)).withProperty(BlockTrapDoor.field_176283_b, (lllllllllllllllllIIIlIIIlllIlIll & 0x4) != 0x0).withProperty(BlockTrapDoor.field_176285_M, ((lllllllllllllllllIIIlIIIlllIlIll & 0x8) == 0x0) ? DoorHalf.BOTTOM : DoorHalf.TOP);
    }
    
    @Override
    public void setBlockBoundsBasedOnState(final IBlockAccess lllllllllllllllllIIIlIIlIlllIllI, final BlockPos lllllllllllllllllIIIlIIlIllllIII) {
        this.func_180693_d(lllllllllllllllllIIIlIIlIlllIllI.getBlockState(lllllllllllllllllIIIlIIlIllllIII));
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllllllllIIIlIIlIlIIlIlI, final BlockPos lllllllllllllllllIIIlIIlIlIIIIII, IBlockState lllllllllllllllllIIIlIIlIIllllll, final EntityPlayer lllllllllllllllllIIIlIIlIlIIIlll, final EnumFacing lllllllllllllllllIIIlIIlIlIIIllI, final float lllllllllllllllllIIIlIIlIlIIIlIl, final float lllllllllllllllllIIIlIIlIlIIIlII, final float lllllllllllllllllIIIlIIlIlIIIIll) {
        if (this.blockMaterial == Material.iron) {
            return true;
        }
        lllllllllllllllllIIIlIIlIIllllll = (byte)((IBlockState)lllllllllllllllllIIIlIIlIIllllll).cycleProperty(BlockTrapDoor.field_176283_b);
        lllllllllllllllllIIIlIIlIlIIlIlI.setBlockState(lllllllllllllllllIIIlIIlIlIIIIII, (IBlockState)lllllllllllllllllIIIlIIlIIllllll, 2);
        lllllllllllllllllIIIlIIlIlIIlIlI.playAuxSFXAtEntity(lllllllllllllllllIIIlIIlIlIIIlll, ((boolean)((IBlockState)lllllllllllllllllIIIlIIlIIllllll).getValue(BlockTrapDoor.field_176283_b)) ? 1003 : 1006, lllllllllllllllllIIIlIIlIlIIIIII, 0);
        return true;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllllIIIlIIIlllIIllI) {
        final byte lllllllllllllllllIIIlIIIlllIIlIl = 0;
        int lllllllllllllllllIIIlIIIlllIIlII = lllllllllllllllllIIIlIIIlllIIlIl | func_176282_a((EnumFacing)lllllllllllllllllIIIlIIIlllIIllI.getValue(BlockTrapDoor.field_176284_a));
        if (lllllllllllllllllIIIlIIIlllIIllI.getValue(BlockTrapDoor.field_176283_b)) {
            lllllllllllllllllIIIlIIIlllIIlII |= 0x4;
        }
        if (lllllllllllllllllIIIlIIIlllIIllI.getValue(BlockTrapDoor.field_176285_M) == DoorHalf.TOP) {
            lllllllllllllllllIIIlIIIlllIIlII |= 0x8;
        }
        return lllllllllllllllllIIIlIIIlllIIlII;
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllllllllIIIlIIlIIIlIIIl, final BlockPos lllllllllllllllllIIIlIIlIIIlIIII, final EnumFacing lllllllllllllllllIIIlIIlIIIIllll, final float lllllllllllllllllIIIlIIlIIIIlllI, final float lllllllllllllllllIIIlIIlIIIIllIl, final float lllllllllllllllllIIIlIIlIIIIllII, final int lllllllllllllllllIIIlIIlIIIIlIll, final EntityLivingBase lllllllllllllllllIIIlIIlIIIIlIlI) {
        IBlockState lllllllllllllllllIIIlIIlIIIIlIIl = this.getDefaultState();
        if (lllllllllllllllllIIIlIIlIIIIllll.getAxis().isHorizontal()) {
            lllllllllllllllllIIIlIIlIIIIlIIl = lllllllllllllllllIIIlIIlIIIIlIIl.withProperty(BlockTrapDoor.field_176284_a, lllllllllllllllllIIIlIIlIIIIllll).withProperty(BlockTrapDoor.field_176283_b, false);
            lllllllllllllllllIIIlIIlIIIIlIIl = lllllllllllllllllIIIlIIlIIIIlIIl.withProperty(BlockTrapDoor.field_176285_M, (lllllllllllllllllIIIlIIlIIIIllIl > 0.5f) ? DoorHalf.TOP : DoorHalf.BOTTOM);
        }
        return lllllllllllllllllIIIlIIlIIIIlIIl;
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final World lllllllllllllllllIIIlIIllIIIIlIl, final BlockPos lllllllllllllllllIIIlIIllIIIIIll, final IBlockState lllllllllllllllllIIIlIIllIIIlIIl) {
        this.setBlockBoundsBasedOnState(lllllllllllllllllIIIlIIllIIIIlIl, lllllllllllllllllIIIlIIllIIIIIll);
        return super.getCollisionBoundingBox(lllllllllllllllllIIIlIIllIIIIlIl, lllllllllllllllllIIIlIIllIIIIIll, lllllllllllllllllIIIlIIllIIIlIIl);
    }
    
    protected BlockTrapDoor(final Material lllllllllllllllllIIIlIIllIlllIll) {
        super(lllllllllllllllllIIIlIIllIlllIll);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockTrapDoor.field_176284_a, EnumFacing.NORTH).withProperty(BlockTrapDoor.field_176283_b, false).withProperty(BlockTrapDoor.field_176285_M, DoorHalf.BOTTOM));
        final float lllllllllllllllllIIIlIIlllIIIIIl = 0.5f;
        final float lllllllllllllllllIIIlIIllIllllll = 1.0f;
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        this.setCreativeTab(CreativeTabs.tabRedstone);
    }
    
    @Override
    public boolean isPassable(final IBlockAccess lllllllllllllllllIIIlIIllIlIlIIl, final BlockPos lllllllllllllllllIIIlIIllIlIlIII) {
        return !(boolean)lllllllllllllllllIIIlIIllIlIlIIl.getBlockState(lllllllllllllllllIIIlIIllIlIlIII).getValue(BlockTrapDoor.field_176283_b);
    }
    
    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.CUTOUT;
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockTrapDoor.field_176284_a, BlockTrapDoor.field_176283_b, BlockTrapDoor.field_176285_M });
    }
    
    @Override
    public MovingObjectPosition collisionRayTrace(final World lllllllllllllllllIIIlIIlIIIllIlI, final BlockPos lllllllllllllllllIIIlIIlIIIllIIl, final Vec3 lllllllllllllllllIIIlIIlIIIllIII, final Vec3 lllllllllllllllllIIIlIIlIIIlllII) {
        this.setBlockBoundsBasedOnState(lllllllllllllllllIIIlIIlIIIllIlI, lllllllllllllllllIIIlIIlIIIllIIl);
        return super.collisionRayTrace(lllllllllllllllllIIIlIIlIIIllIlI, lllllllllllllllllIIIlIIlIIIllIIl, lllllllllllllllllIIIlIIlIIIllIII, lllllllllllllllllIIIlIIlIIIlllII);
    }
    
    @Override
    public void onNeighborBlockChange(final World lllllllllllllllllIIIlIIlIIllIlII, final BlockPos lllllllllllllllllIIIlIIlIIllIIll, final IBlockState lllllllllllllllllIIIlIIlIIllIIlI, final Block lllllllllllllllllIIIlIIlIIlIlIIl) {
        if (!lllllllllllllllllIIIlIIlIIllIlII.isRemote) {
            final BlockPos lllllllllllllllllIIIlIIlIIllIIII = lllllllllllllllllIIIlIIlIIllIIll.offset(((EnumFacing)lllllllllllllllllIIIlIIlIIllIIlI.getValue(BlockTrapDoor.field_176284_a)).getOpposite());
            if (!isValidSupportBlock(lllllllllllllllllIIIlIIlIIllIlII.getBlockState(lllllllllllllllllIIIlIIlIIllIIII).getBlock())) {
                lllllllllllllllllIIIlIIlIIllIlII.setBlockToAir(lllllllllllllllllIIIlIIlIIllIIll);
                this.dropBlockAsItem(lllllllllllllllllIIIlIIlIIllIlII, lllllllllllllllllIIIlIIlIIllIIll, lllllllllllllllllIIIlIIlIIllIIlI, 0);
            }
            else {
                final boolean lllllllllllllllllIIIlIIlIIlIllll = lllllllllllllllllIIIlIIlIIllIlII.isBlockPowered(lllllllllllllllllIIIlIIlIIllIIll);
                if (lllllllllllllllllIIIlIIlIIlIllll || lllllllllllllllllIIIlIIlIIlIlIIl.canProvidePower()) {
                    final boolean lllllllllllllllllIIIlIIlIIlIlllI = (boolean)lllllllllllllllllIIIlIIlIIllIIlI.getValue(BlockTrapDoor.field_176283_b);
                    if (lllllllllllllllllIIIlIIlIIlIlllI != lllllllllllllllllIIIlIIlIIlIllll) {
                        lllllllllllllllllIIIlIIlIIllIlII.setBlockState(lllllllllllllllllIIIlIIlIIllIIll, lllllllllllllllllIIIlIIlIIllIIlI.withProperty(BlockTrapDoor.field_176283_b, lllllllllllllllllIIIlIIlIIlIllll), 2);
                        lllllllllllllllllIIIlIIlIIllIlII.playAuxSFXAtEntity(null, lllllllllllllllllIIIlIIlIIlIllll ? 1003 : 1006, lllllllllllllllllIIIlIIlIIllIIll, 0);
                    }
                }
            }
        }
    }
    
    static final class SwitchEnumFacing
    {
        static final /* synthetic */ int[] field_177058_a;
        
        static {
            __OBFID = "CL_00002052";
            field_177058_a = new int[EnumFacing.values().length];
            try {
                SwitchEnumFacing.field_177058_a[EnumFacing.NORTH.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumFacing.field_177058_a[EnumFacing.SOUTH.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumFacing.field_177058_a[EnumFacing.WEST.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchEnumFacing.field_177058_a[EnumFacing.EAST.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
        }
    }
    
    public enum DoorHalf implements IStringSerializable
    {
        TOP("TOP", 0, "TOP", 0, "top"), 
        BOTTOM("BOTTOM", 1, "BOTTOM", 1, "bottom");
        
        private final /* synthetic */ String field_176671_c;
        
        @Override
        public String toString() {
            return this.field_176671_c;
        }
        
        @Override
        public String getName() {
            return this.field_176671_c;
        }
        
        private DoorHalf(final String llIIIIllIIllIIl, final int llIIIIllIIllIII, final String llIIIIllIIlllIl, final int llIIIIllIIlllII, final String llIIIIllIIllIll) {
            this.field_176671_c = llIIIIllIIllIll;
        }
        
        static {
            __OBFID = "CL_00002051";
        }
    }
}
