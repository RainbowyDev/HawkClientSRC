package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.util.*;

public class BlockLever extends Block
{
    public static final /* synthetic */ PropertyBool POWERED;
    public static final /* synthetic */ PropertyEnum FACING;
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIIllllIIIIIlIIIllI) {
        return this.getDefaultState().withProperty(BlockLever.FACING, EnumOrientation.func_176853_a(llllllllllllllIIllllIIIIIlIIIllI & 0x7)).withProperty(BlockLever.POWERED, (llllllllllllllIIllllIIIIIlIIIllI & 0x8) > 0);
    }
    
    @Override
    public void onNeighborBlockChange(final World llllllllllllllIIllllIIIIllIIIIlI, final BlockPos llllllllllllllIIllllIIIIllIIIIIl, final IBlockState llllllllllllllIIllllIIIIllIIIlll, final Block llllllllllllllIIllllIIIIllIIIlIl) {
        if (this.func_176356_e(llllllllllllllIIllllIIIIllIIIIlI, llllllllllllllIIllllIIIIllIIIIIl) && !this.func_176358_d(llllllllllllllIIllllIIIIllIIIIlI, llllllllllllllIIllllIIIIllIIIIIl.offset(((EnumOrientation)llllllllllllllIIllllIIIIllIIIlll.getValue(BlockLever.FACING)).func_176852_c().getOpposite()))) {
            this.dropBlockAsItem(llllllllllllllIIllllIIIIllIIIIlI, llllllllllllllIIllllIIIIllIIIIIl, llllllllllllllIIllllIIIIllIIIlll, 0);
            llllllllllllllIIllllIIIIllIIIIlI.setBlockToAir(llllllllllllllIIllllIIIIllIIIIIl);
        }
    }
    
    @Override
    public void setBlockBoundsBasedOnState(final IBlockAccess llllllllllllllIIllllIIIIlIIlIIII, final BlockPos llllllllllllllIIllllIIIIlIIlIllI) {
        float llllllllllllllIIllllIIIIlIIlIlII = 0.1875f;
        switch (SwitchEnumFacing.ORIENTATION_LOOKUP[((EnumOrientation)llllllllllllllIIllllIIIIlIIlIIII.getBlockState(llllllllllllllIIllllIIIIlIIlIllI).getValue(BlockLever.FACING)).ordinal()]) {
            case 1: {
                this.setBlockBounds(0.0f, 0.2f, 0.5f - llllllllllllllIIllllIIIIlIIlIlII, llllllllllllllIIllllIIIIlIIlIlII * 2.0f, 0.8f, 0.5f + llllllllllllllIIllllIIIIlIIlIlII);
                break;
            }
            case 2: {
                this.setBlockBounds(1.0f - llllllllllllllIIllllIIIIlIIlIlII * 2.0f, 0.2f, 0.5f - llllllllllllllIIllllIIIIlIIlIlII, 1.0f, 0.8f, 0.5f + llllllllllllllIIllllIIIIlIIlIlII);
                break;
            }
            case 3: {
                this.setBlockBounds(0.5f - llllllllllllllIIllllIIIIlIIlIlII, 0.2f, 0.0f, 0.5f + llllllllllllllIIllllIIIIlIIlIlII, 0.8f, llllllllllllllIIllllIIIIlIIlIlII * 2.0f);
                break;
            }
            case 4: {
                this.setBlockBounds(0.5f - llllllllllllllIIllllIIIIlIIlIlII, 0.2f, 1.0f - llllllllllllllIIllllIIIIlIIlIlII * 2.0f, 0.5f + llllllllllllllIIllllIIIIlIIlIlII, 0.8f, 1.0f);
                break;
            }
            case 5:
            case 6: {
                llllllllllllllIIllllIIIIlIIlIlII = 0.25f;
                this.setBlockBounds(0.5f - llllllllllllllIIllllIIIIlIIlIlII, 0.0f, 0.5f - llllllllllllllIIllllIIIIlIIlIlII, 0.5f + llllllllllllllIIllllIIIIlIIlIlII, 0.6f, 0.5f + llllllllllllllIIllllIIIIlIIlIlII);
                break;
            }
            case 7:
            case 8: {
                llllllllllllllIIllllIIIIlIIlIlII = 0.25f;
                this.setBlockBounds(0.5f - llllllllllllllIIllllIIIIlIIlIlII, 0.4f, 0.5f - llllllllllllllIIllllIIIIlIIlIlII, 0.5f + llllllllllllllIIllllIIIIlIIlIlII, 1.0f, 0.5f + llllllllllllllIIllllIIIIlIIlIlII);
                break;
            }
        }
    }
    
    @Override
    public boolean canPlaceBlockAt(final World llllllllllllllIIllllIIIIlllllIll, final BlockPos llllllllllllllIIllllIIIIllllIlll) {
        return this.func_176358_d(llllllllllllllIIllllIIIIlllllIll, llllllllllllllIIllllIIIIllllIlll.offsetWest()) || this.func_176358_d(llllllllllllllIIllllIIIIlllllIll, llllllllllllllIIllllIIIIllllIlll.offsetEast()) || this.func_176358_d(llllllllllllllIIllllIIIIlllllIll, llllllllllllllIIllllIIIIllllIlll.offsetNorth()) || this.func_176358_d(llllllllllllllIIllllIIIIlllllIll, llllllllllllllIIllllIIIIllllIlll.offsetSouth()) || World.doesBlockHaveSolidTopSurface(llllllllllllllIIllllIIIIlllllIll, llllllllllllllIIllllIIIIllllIlll.offsetDown()) || this.func_176358_d(llllllllllllllIIllllIIIIlllllIll, llllllllllllllIIllllIIIIllllIlll.offsetUp());
    }
    
    protected boolean func_176358_d(final World llllllllllllllIIllllIIIIllllIIIl, final BlockPos llllllllllllllIIllllIIIIllllIIII) {
        return llllllllllllllIIllllIIIIllllIIIl.getBlockState(llllllllllllllIIllllIIIIllllIIII).getBlock().isNormalCube();
    }
    
    @Override
    public int isProvidingStrongPower(final IBlockAccess llllllllllllllIIllllIIIIIlIlIIlI, final BlockPos llllllllllllllIIllllIIIIIlIlIIIl, final IBlockState llllllllllllllIIllllIIIIIlIIlllI, final EnumFacing llllllllllllllIIllllIIIIIlIIllIl) {
        return llllllllllllllIIllllIIIIIlIIlllI.getValue(BlockLever.POWERED) ? ((((EnumOrientation)llllllllllllllIIllllIIIIIlIIlllI.getValue(BlockLever.FACING)).func_176852_c() == llllllllllllllIIllllIIIIIlIIllIl) ? 15 : 0) : 0;
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    @Override
    public void breakBlock(final World llllllllllllllIIllllIIIIIllIIlIl, final BlockPos llllllllllllllIIllllIIIIIlIlllll, final IBlockState llllllllllllllIIllllIIIIIlIllllI) {
        if (llllllllllllllIIllllIIIIIlIllllI.getValue(BlockLever.POWERED)) {
            llllllllllllllIIllllIIIIIllIIlIl.notifyNeighborsOfStateChange(llllllllllllllIIllllIIIIIlIlllll, this);
            final EnumFacing llllllllllllllIIllllIIIIIllIIIlI = ((EnumOrientation)llllllllllllllIIllllIIIIIlIllllI.getValue(BlockLever.FACING)).func_176852_c();
            llllllllllllllIIllllIIIIIllIIlIl.notifyNeighborsOfStateChange(llllllllllllllIIllllIIIIIlIlllll.offset(llllllllllllllIIllllIIIIIllIIIlI.getOpposite()), this);
        }
        super.breakBlock(llllllllllllllIIllllIIIIIllIIlIl, llllllllllllllIIllllIIIIIlIlllll, llllllllllllllIIllllIIIIIlIllllI);
    }
    
    static {
        __OBFID = "CL_00000264";
        FACING = PropertyEnum.create("facing", EnumOrientation.class);
        POWERED = PropertyBool.create("powered");
    }
    
    @Override
    public boolean canProvidePower() {
        return true;
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIIllllIIIIIIlllllI) {
        final byte llllllllllllllIIllllIIIIIlIIIIII = 0;
        int llllllllllllllIIllllIIIIIIllllll = llllllllllllllIIllllIIIIIlIIIIII | ((EnumOrientation)llllllllllllllIIllllIIIIIIlllllI.getValue(BlockLever.FACING)).func_176855_a();
        if (llllllllllllllIIllllIIIIIIlllllI.getValue(BlockLever.POWERED)) {
            llllllllllllllIIllllIIIIIIllllll |= 0x8;
        }
        return llllllllllllllIIllllIIIIIIllllll;
    }
    
    private boolean func_176356_e(final World llllllllllllllIIllllIIIIlIllIIIl, final BlockPos llllllllllllllIIllllIIIIlIlIllll) {
        if (this.canPlaceBlockAt(llllllllllllllIIllllIIIIlIllIIIl, llllllllllllllIIllllIIIIlIlIllll)) {
            return true;
        }
        this.dropBlockAsItem(llllllllllllllIIllllIIIIlIllIIIl, llllllllllllllIIllllIIIIlIlIllll, llllllllllllllIIllllIIIIlIllIIIl.getBlockState(llllllllllllllIIllllIIIIlIlIllll), 0);
        llllllllllllllIIllllIIIIlIllIIIl.setBlockToAir(llllllllllllllIIllllIIIIlIlIllll);
        return false;
    }
    
    @Override
    public boolean onBlockActivated(final World llllllllllllllIIllllIIIIIllllIIl, final BlockPos llllllllllllllIIllllIIIIIllllIII, IBlockState llllllllllllllIIllllIIIIIllIllIl, final EntityPlayer llllllllllllllIIllllIIIIIlllIllI, final EnumFacing llllllllllllllIIllllIIIIIlllIlIl, final float llllllllllllllIIllllIIIIIlllIlII, final float llllllllllllllIIllllIIIIIlllIIll, final float llllllllllllllIIllllIIIIIlllIIlI) {
        if (llllllllllllllIIllllIIIIIllllIIl.isRemote) {
            return true;
        }
        llllllllllllllIIllllIIIIIllIllIl = (Exception)((IBlockState)llllllllllllllIIllllIIIIIllIllIl).cycleProperty(BlockLever.POWERED);
        llllllllllllllIIllllIIIIIllllIIl.setBlockState(llllllllllllllIIllllIIIIIllllIII, (IBlockState)llllllllllllllIIllllIIIIIllIllIl, 3);
        llllllllllllllIIllllIIIIIllllIIl.playSoundEffect(llllllllllllllIIllllIIIIIllllIII.getX() + 0.5, llllllllllllllIIllllIIIIIllllIII.getY() + 0.5, llllllllllllllIIllllIIIIIllllIII.getZ() + 0.5, "random.click", 0.3f, ((boolean)((IBlockState)llllllllllllllIIllllIIIIIllIllIl).getValue(BlockLever.POWERED)) ? 0.6f : 0.5f);
        llllllllllllllIIllllIIIIIllllIIl.notifyNeighborsOfStateChange(llllllllllllllIIllllIIIIIllllIII, this);
        final EnumFacing llllllllllllllIIllllIIIIIlllIIIl = ((EnumOrientation)((IBlockState)llllllllllllllIIllllIIIIIllIllIl).getValue(BlockLever.FACING)).func_176852_c();
        llllllllllllllIIllllIIIIIllllIIl.notifyNeighborsOfStateChange(llllllllllllllIIllllIIIIIllllIII.offset(llllllllllllllIIllllIIIIIlllIIIl.getOpposite()), this);
        return true;
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockLever.FACING, BlockLever.POWERED });
    }
    
    @Override
    public IBlockState onBlockPlaced(final World llllllllllllllIIllllIIIIllIllIlI, final BlockPos llllllllllllllIIllllIIIIlllIIlIl, final EnumFacing llllllllllllllIIllllIIIIllIllIII, final float llllllllllllllIIllllIIIIlllIIIll, final float llllllllllllllIIllllIIIIlllIIIlI, final float llllllllllllllIIllllIIIIlllIIIIl, final int llllllllllllllIIllllIIIIlllIIIII, final EntityLivingBase llllllllllllllIIllllIIIIllIlIlll) {
        final IBlockState llllllllllllllIIllllIIIIllIllllI = this.getDefaultState().withProperty(BlockLever.POWERED, false);
        if (this.func_176358_d(llllllllllllllIIllllIIIIllIllIlI, llllllllllllllIIllllIIIIlllIIlIl.offset(llllllllllllllIIllllIIIIllIllIII.getOpposite()))) {
            return llllllllllllllIIllllIIIIllIllllI.withProperty(BlockLever.FACING, EnumOrientation.func_176856_a(llllllllllllllIIllllIIIIllIllIII, llllllllllllllIIllllIIIIllIlIlll.func_174811_aO()));
        }
        for (final EnumFacing llllllllllllllIIllllIIIIllIlllII : EnumFacing.Plane.HORIZONTAL) {
            if (llllllllllllllIIllllIIIIllIlllII != llllllllllllllIIllllIIIIllIllIII && this.func_176358_d(llllllllllllllIIllllIIIIllIllIlI, llllllllllllllIIllllIIIIlllIIlIl.offset(llllllllllllllIIllllIIIIllIlllII.getOpposite()))) {
                return llllllllllllllIIllllIIIIllIllllI.withProperty(BlockLever.FACING, EnumOrientation.func_176856_a(llllllllllllllIIllllIIIIllIlllII, llllllllllllllIIllllIIIIllIlIlll.func_174811_aO()));
            }
        }
        if (World.doesBlockHaveSolidTopSurface(llllllllllllllIIllllIIIIllIllIlI, llllllllllllllIIllllIIIIlllIIlIl.offsetDown())) {
            return llllllllllllllIIllllIIIIllIllllI.withProperty(BlockLever.FACING, EnumOrientation.func_176856_a(EnumFacing.UP, llllllllllllllIIllllIIIIllIlIlll.func_174811_aO()));
        }
        return llllllllllllllIIllllIIIIllIllllI;
    }
    
    public static int func_176357_a(final EnumFacing llllllllllllllIIllllIIIIllIlIIlI) {
        switch (SwitchEnumFacing.FACING_LOOKUP[llllllllllllllIIllllIIIIllIlIIlI.ordinal()]) {
            case 1: {
                return 0;
            }
            case 2: {
                return 5;
            }
            case 3: {
                return 4;
            }
            case 4: {
                return 3;
            }
            case 5: {
                return 2;
            }
            case 6: {
                return 1;
            }
            default: {
                return -1;
            }
        }
    }
    
    @Override
    public int isProvidingWeakPower(final IBlockAccess llllllllllllllIIllllIIIIIlIllIlI, final BlockPos llllllllllllllIIllllIIIIIlIllIIl, final IBlockState llllllllllllllIIllllIIIIIlIllIII, final EnumFacing llllllllllllllIIllllIIIIIlIlIlll) {
        return llllllllllllllIIllllIIIIIlIllIII.getValue(BlockLever.POWERED) ? 15 : 0;
    }
    
    protected BlockLever() {
        super(Material.circuits);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockLever.FACING, EnumOrientation.NORTH).withProperty(BlockLever.POWERED, false));
        this.setCreativeTab(CreativeTabs.tabRedstone);
    }
    
    @Override
    public boolean canPlaceBlockOnSide(final World llllllllllllllIIllllIIIlIIIIIllI, final BlockPos llllllllllllllIIllllIIIlIIIIIlIl, final EnumFacing llllllllllllllIIllllIIIlIIIIIlII) {
        return (llllllllllllllIIllllIIIlIIIIIlII == EnumFacing.UP && World.doesBlockHaveSolidTopSurface(llllllllllllllIIllllIIIlIIIIIllI, llllllllllllllIIllllIIIlIIIIIlIl.offsetDown())) || this.func_176358_d(llllllllllllllIIllllIIIlIIIIIllI, llllllllllllllIIllllIIIlIIIIIlIl.offset(llllllllllllllIIllllIIIlIIIIIlII.getOpposite()));
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final World llllllllllllllIIllllIIIlIIIlIIII, final BlockPos llllllllllllllIIllllIIIlIIIIllll, final IBlockState llllllllllllllIIllllIIIlIIIIlllI) {
        return null;
    }
    
    public enum EnumOrientation implements IStringSerializable
    {
        SOUTH("SOUTH", 3, "SOUTH", 3, 3, "south", EnumFacing.SOUTH), 
        NORTH("NORTH", 4, "NORTH", 4, 4, "north", EnumFacing.NORTH);
        
        private final /* synthetic */ String field_176867_k;
        
        EAST("EAST", 1, "EAST", 1, 1, "east", EnumFacing.EAST);
        
        private static final /* synthetic */ EnumOrientation[] field_176869_i;
        
        UP_Z("UP_Z", 5, "UP_Z", 5, 5, "up_z", EnumFacing.UP), 
        UP_X("UP_X", 6, "UP_X", 6, 6, "up_x", EnumFacing.UP);
        
        private final /* synthetic */ EnumFacing field_176864_l;
        
        WEST("WEST", 2, "WEST", 2, 2, "west", EnumFacing.WEST), 
        DOWN_X("DOWN_X", 0, "DOWN_X", 0, 0, "down_x", EnumFacing.DOWN), 
        DOWN_Z("DOWN_Z", 7, "DOWN_Z", 7, 7, "down_z", EnumFacing.DOWN);
        
        private final /* synthetic */ int field_176866_j;
        
        @Override
        public String getName() {
            return this.field_176867_k;
        }
        
        public EnumFacing func_176852_c() {
            return this.field_176864_l;
        }
        
        public static EnumOrientation func_176853_a(int llllllllllllllllIlIIIlIIIIIIlIlI) {
            if (llllllllllllllllIlIIIlIIIIIIlIlI < 0 || llllllllllllllllIlIIIlIIIIIIlIlI >= EnumOrientation.field_176869_i.length) {
                llllllllllllllllIlIIIlIIIIIIlIlI = 0;
            }
            return EnumOrientation.field_176869_i[llllllllllllllllIlIIIlIIIIIIlIlI];
        }
        
        public static EnumOrientation func_176856_a(final EnumFacing llllllllllllllllIlIIIlIIIIIIIlll, final EnumFacing llllllllllllllllIlIIIlIIIIIIIlII) {
            switch (SwitchEnumFacing.FACING_LOOKUP[llllllllllllllllIlIIIlIIIIIIIlll.ordinal()]) {
                case 1: {
                    switch (SwitchEnumFacing.AXIS_LOOKUP[llllllllllllllllIlIIIlIIIIIIIlII.getAxis().ordinal()]) {
                        case 1: {
                            return EnumOrientation.DOWN_X;
                        }
                        case 2: {
                            return EnumOrientation.DOWN_Z;
                        }
                        default: {
                            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Invalid entityFacing ").append(llllllllllllllllIlIIIlIIIIIIIlII).append(" for facing ").append(llllllllllllllllIlIIIlIIIIIIIlll)));
                        }
                    }
                    break;
                }
                case 2: {
                    switch (SwitchEnumFacing.AXIS_LOOKUP[llllllllllllllllIlIIIlIIIIIIIlII.getAxis().ordinal()]) {
                        case 1: {
                            return EnumOrientation.UP_X;
                        }
                        case 2: {
                            return EnumOrientation.UP_Z;
                        }
                        default: {
                            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Invalid entityFacing ").append(llllllllllllllllIlIIIlIIIIIIIlII).append(" for facing ").append(llllllllllllllllIlIIIlIIIIIIIlll)));
                        }
                    }
                    break;
                }
                case 3: {
                    return EnumOrientation.NORTH;
                }
                case 4: {
                    return EnumOrientation.SOUTH;
                }
                case 5: {
                    return EnumOrientation.WEST;
                }
                case 6: {
                    return EnumOrientation.EAST;
                }
                default: {
                    throw new IllegalArgumentException(String.valueOf(new StringBuilder("Invalid facing: ").append(llllllllllllllllIlIIIlIIIIIIIlll)));
                }
            }
        }
        
        public int func_176855_a() {
            return this.field_176866_j;
        }
        
        private EnumOrientation(final String llllllllllllllllIlIIIlIIIIIllIlI, final int llllllllllllllllIlIIIlIIIIIllIIl, final String llllllllllllllllIlIIIlIIIIlIIIII, final int llllllllllllllllIlIIIlIIIIIlllll, final int llllllllllllllllIlIIIlIIIIIllllI, final String llllllllllllllllIlIIIlIIIIIlIlll, final EnumFacing llllllllllllllllIlIIIlIIIIIlllII) {
            this.field_176866_j = llllllllllllllllIlIIIlIIIIIllllI;
            this.field_176867_k = llllllllllllllllIlIIIlIIIIIlIlll;
            this.field_176864_l = llllllllllllllllIlIIIlIIIIIlllII;
        }
        
        @Override
        public String toString() {
            return this.field_176867_k;
        }
        
        static {
            __OBFID = "CL_00002102";
            field_176869_i = new EnumOrientation[values().length];
            for (final EnumOrientation llllllllllllllllIlIIIlIIIIlIllII : values()) {
                EnumOrientation.field_176869_i[llllllllllllllllIlIIIlIIIIlIllII.func_176855_a()] = llllllllllllllllIlIIIlIIIIlIllII;
            }
        }
    }
    
    static final class SwitchEnumFacing
    {
        static final /* synthetic */ int[] ORIENTATION_LOOKUP;
        static final /* synthetic */ int[] FACING_LOOKUP;
        static final /* synthetic */ int[] AXIS_LOOKUP;
        
        static {
            __OBFID = "CL_00002103";
            AXIS_LOOKUP = new int[EnumFacing.Axis.values().length];
            try {
                SwitchEnumFacing.AXIS_LOOKUP[EnumFacing.Axis.X.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumFacing.AXIS_LOOKUP[EnumFacing.Axis.Z.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            ORIENTATION_LOOKUP = new int[EnumOrientation.values().length];
            try {
                SwitchEnumFacing.ORIENTATION_LOOKUP[EnumOrientation.EAST.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchEnumFacing.ORIENTATION_LOOKUP[EnumOrientation.WEST.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                SwitchEnumFacing.ORIENTATION_LOOKUP[EnumOrientation.SOUTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                SwitchEnumFacing.ORIENTATION_LOOKUP[EnumOrientation.NORTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
            try {
                SwitchEnumFacing.ORIENTATION_LOOKUP[EnumOrientation.UP_Z.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError7) {}
            try {
                SwitchEnumFacing.ORIENTATION_LOOKUP[EnumOrientation.UP_X.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError8) {}
            try {
                SwitchEnumFacing.ORIENTATION_LOOKUP[EnumOrientation.DOWN_X.ordinal()] = 7;
            }
            catch (NoSuchFieldError noSuchFieldError9) {}
            try {
                SwitchEnumFacing.ORIENTATION_LOOKUP[EnumOrientation.DOWN_Z.ordinal()] = 8;
            }
            catch (NoSuchFieldError noSuchFieldError10) {}
            FACING_LOOKUP = new int[EnumFacing.values().length];
            try {
                SwitchEnumFacing.FACING_LOOKUP[EnumFacing.DOWN.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError11) {}
            try {
                SwitchEnumFacing.FACING_LOOKUP[EnumFacing.UP.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError12) {}
            try {
                SwitchEnumFacing.FACING_LOOKUP[EnumFacing.NORTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError13) {}
            try {
                SwitchEnumFacing.FACING_LOOKUP[EnumFacing.SOUTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError14) {}
            try {
                SwitchEnumFacing.FACING_LOOKUP[EnumFacing.WEST.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError15) {}
            try {
                SwitchEnumFacing.FACING_LOOKUP[EnumFacing.EAST.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError16) {}
        }
    }
}
