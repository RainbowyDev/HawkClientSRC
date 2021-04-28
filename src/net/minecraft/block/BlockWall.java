package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.creativetab.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;

public class BlockWall extends Block
{
    public static final /* synthetic */ PropertyBool field_176257_M;
    public static final /* synthetic */ PropertyEnum field_176255_P;
    public static final /* synthetic */ PropertyBool field_176259_O;
    public static final /* synthetic */ PropertyBool field_176256_a;
    public static final /* synthetic */ PropertyBool field_176258_N;
    public static final /* synthetic */ PropertyBool field_176254_b;
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllIIIIIlIIlIlIllllI) {
        return ((EnumType)lllllllllllllllIIIIIlIIlIlIllllI.getValue(BlockWall.field_176255_P)).func_176657_a();
    }
    
    public BlockWall(final Block lllllllllllllllIIIIIlIIlllIIllII) {
        super(lllllllllllllllIIIIIlIIlllIIllII.blockMaterial);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockWall.field_176256_a, false).withProperty(BlockWall.field_176254_b, false).withProperty(BlockWall.field_176257_M, false).withProperty(BlockWall.field_176258_N, false).withProperty(BlockWall.field_176259_O, false).withProperty(BlockWall.field_176255_P, EnumType.NORMAL));
        this.setHardness(lllllllllllllllIIIIIlIIlllIIllII.blockHardness);
        this.setResistance(lllllllllllllllIIIIIlIIlllIIllII.blockResistance / 3.0f);
        this.setStepSound(lllllllllllllllIIIIIlIIlllIIllII.stepSound);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    static {
        __OBFID = "CL_00000331";
        field_176256_a = PropertyBool.create("up");
        field_176254_b = PropertyBool.create("north");
        field_176257_M = PropertyBool.create("east");
        field_176258_N = PropertyBool.create("south");
        field_176259_O = PropertyBool.create("west");
        field_176255_P = PropertyEnum.create("variant", EnumType.class);
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockAccess lllllllllllllllIIIIIlIIlIllIlIIl, final BlockPos lllllllllllllllIIIIIlIIlIllIlIII, final EnumFacing lllllllllllllllIIIIIlIIlIllIlIll) {
        return lllllllllllllllIIIIIlIIlIllIlIll != EnumFacing.DOWN || super.shouldSideBeRendered(lllllllllllllllIIIIIlIIlIllIlIIl, lllllllllllllllIIIIIlIIlIllIlIII, lllllllllllllllIIIIIlIIlIllIlIll);
    }
    
    @Override
    public boolean isPassable(final IBlockAccess lllllllllllllllIIIIIlIIlllIIlIIl, final BlockPos lllllllllllllllIIIIIlIIlllIIlIII) {
        return false;
    }
    
    public boolean func_176253_e(final IBlockAccess lllllllllllllllIIIIIlIIllIIIllIl, final BlockPos lllllllllllllllIIIIIlIIllIIIllII) {
        final Block lllllllllllllllIIIIIlIIllIIIllll = lllllllllllllllIIIIIlIIllIIIllIl.getBlockState(lllllllllllllllIIIIIlIIllIIIllII).getBlock();
        return lllllllllllllllIIIIIlIIllIIIllll != Blocks.barrier && (lllllllllllllllIIIIIlIIllIIIllll == this || lllllllllllllllIIIIIlIIllIIIllll instanceof BlockFenceGate || (lllllllllllllllIIIIIlIIllIIIllll.blockMaterial.isOpaque() && lllllllllllllllIIIIIlIIllIIIllll.isFullCube() && lllllllllllllllIIIIIlIIllIIIllll.blockMaterial != Material.gourd));
    }
    
    @Override
    public void getSubBlocks(final Item lllllllllllllllIIIIIlIIllIIIIIll, final CreativeTabs lllllllllllllllIIIIIlIIllIIIIIlI, final List lllllllllllllllIIIIIlIIlIllllIll) {
        for (final EnumType lllllllllllllllIIIIIlIIlIlllllIl : EnumType.values()) {
            lllllllllllllllIIIIIlIIlIllllIll.add(new ItemStack(lllllllllllllllIIIIIlIIllIIIIIll, 1, lllllllllllllllIIIIIlIIlIlllllIl.func_176657_a()));
        }
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllIIIIIlIIlIllIIIll) {
        return this.getDefaultState().withProperty(BlockWall.field_176255_P, EnumType.func_176660_a(lllllllllllllllIIIIIlIIlIllIIIll));
    }
    
    @Override
    public IBlockState getActualState(final IBlockState lllllllllllllllIIIIIlIIlIlIlIIll, final IBlockAccess lllllllllllllllIIIIIlIIlIlIlIllI, final BlockPos lllllllllllllllIIIIIlIIlIlIlIlIl) {
        return lllllllllllllllIIIIIlIIlIlIlIIll.withProperty(BlockWall.field_176256_a, !lllllllllllllllIIIIIlIIlIlIlIllI.isAirBlock(lllllllllllllllIIIIIlIIlIlIlIlIl.offsetUp())).withProperty(BlockWall.field_176254_b, this.func_176253_e(lllllllllllllllIIIIIlIIlIlIlIllI, lllllllllllllllIIIIIlIIlIlIlIlIl.offsetNorth())).withProperty(BlockWall.field_176257_M, this.func_176253_e(lllllllllllllllIIIIIlIIlIlIlIllI, lllllllllllllllIIIIIlIIlIlIlIlIl.offsetEast())).withProperty(BlockWall.field_176258_N, this.func_176253_e(lllllllllllllllIIIIIlIIlIlIlIllI, lllllllllllllllIIIIIlIIlIlIlIlIl.offsetSouth())).withProperty(BlockWall.field_176259_O, this.func_176253_e(lllllllllllllllIIIIIlIIlIlIlIllI, lllllllllllllllIIIIIlIIlIlIlIlIl.offsetWest()));
    }
    
    @Override
    public void setBlockBoundsBasedOnState(final IBlockAccess lllllllllllllllIIIIIlIIllIlIllIl, final BlockPos lllllllllllllllIIIIIlIIllIlllIII) {
        final boolean lllllllllllllllIIIIIlIIllIllIlll = this.func_176253_e(lllllllllllllllIIIIIlIIllIlIllIl, lllllllllllllllIIIIIlIIllIlllIII.offsetNorth());
        final boolean lllllllllllllllIIIIIlIIllIllIllI = this.func_176253_e(lllllllllllllllIIIIIlIIllIlIllIl, lllllllllllllllIIIIIlIIllIlllIII.offsetSouth());
        final boolean lllllllllllllllIIIIIlIIllIllIlIl = this.func_176253_e(lllllllllllllllIIIIIlIIllIlIllIl, lllllllllllllllIIIIIlIIllIlllIII.offsetWest());
        final boolean lllllllllllllllIIIIIlIIllIllIlII = this.func_176253_e(lllllllllllllllIIIIIlIIllIlIllIl, lllllllllllllllIIIIIlIIllIlllIII.offsetEast());
        float lllllllllllllllIIIIIlIIllIllIIll = 0.25f;
        float lllllllllllllllIIIIIlIIllIllIIlI = 0.75f;
        float lllllllllllllllIIIIIlIIllIllIIIl = 0.25f;
        float lllllllllllllllIIIIIlIIllIllIIII = 0.75f;
        float lllllllllllllllIIIIIlIIllIlIllll = 1.0f;
        if (lllllllllllllllIIIIIlIIllIllIlll) {
            lllllllllllllllIIIIIlIIllIllIIIl = 0.0f;
        }
        if (lllllllllllllllIIIIIlIIllIllIllI) {
            lllllllllllllllIIIIIlIIllIllIIII = 1.0f;
        }
        if (lllllllllllllllIIIIIlIIllIllIlIl) {
            lllllllllllllllIIIIIlIIllIllIIll = 0.0f;
        }
        if (lllllllllllllllIIIIIlIIllIllIlII) {
            lllllllllllllllIIIIIlIIllIllIIlI = 1.0f;
        }
        if (lllllllllllllllIIIIIlIIllIllIlll && lllllllllllllllIIIIIlIIllIllIllI && !lllllllllllllllIIIIIlIIllIllIlIl && !lllllllllllllllIIIIIlIIllIllIlII) {
            lllllllllllllllIIIIIlIIllIlIllll = 0.8125f;
            lllllllllllllllIIIIIlIIllIllIIll = 0.3125f;
            lllllllllllllllIIIIIlIIllIllIIlI = 0.6875f;
        }
        else if (!lllllllllllllllIIIIIlIIllIllIlll && !lllllllllllllllIIIIIlIIllIllIllI && lllllllllllllllIIIIIlIIllIllIlIl && lllllllllllllllIIIIIlIIllIllIlII) {
            lllllllllllllllIIIIIlIIllIlIllll = 0.8125f;
            lllllllllllllllIIIIIlIIllIllIIIl = 0.3125f;
            lllllllllllllllIIIIIlIIllIllIIII = 0.6875f;
        }
        this.setBlockBounds(lllllllllllllllIIIIIlIIllIllIIll, 0.0f, lllllllllllllllIIIIIlIIllIllIIIl, lllllllllllllllIIIIIlIIllIllIIlI, lllllllllllllllIIIIIlIIllIlIllll, lllllllllllllllIIIIIlIIllIllIIII);
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final World lllllllllllllllIIIIIlIIllIIlllIl, final BlockPos lllllllllllllllIIIIIlIIllIIllIII, final IBlockState lllllllllllllllIIIIIlIIllIIllIll) {
        this.setBlockBoundsBasedOnState(lllllllllllllllIIIIIlIIllIIlllIl, lllllllllllllllIIIIIlIIllIIllIII);
        this.maxY = 1.5;
        return super.getCollisionBoundingBox(lllllllllllllllIIIIIlIIllIIlllIl, lllllllllllllllIIIIIlIIllIIllIII, lllllllllllllllIIIIIlIIllIIllIll);
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    @Override
    public int damageDropped(final IBlockState lllllllllllllllIIIIIlIIlIlllIlII) {
        return ((EnumType)lllllllllllllllIIIIIlIIlIlllIlII.getValue(BlockWall.field_176255_P)).func_176657_a();
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockWall.field_176256_a, BlockWall.field_176254_b, BlockWall.field_176257_M, BlockWall.field_176259_O, BlockWall.field_176258_N, BlockWall.field_176255_P });
    }
    
    public enum EnumType implements IStringSerializable
    {
        private final /* synthetic */ int field_176663_d;
        private final /* synthetic */ String field_176664_e;
        private /* synthetic */ String field_176661_f;
        
        MOSSY("MOSSY", 1, "MOSSY", 1, 1, "mossy_cobblestone", "mossy"), 
        NORMAL("NORMAL", 0, "NORMAL", 0, 0, "cobblestone", "normal");
        
        private static final /* synthetic */ EnumType[] field_176666_c;
        
        public static EnumType func_176660_a(int llllIIIIIlIlI) {
            if (llllIIIIIlIlI < 0 || llllIIIIIlIlI >= EnumType.field_176666_c.length) {
                llllIIIIIlIlI = 0;
            }
            return EnumType.field_176666_c[llllIIIIIlIlI];
        }
        
        private EnumType(final String llllIIIIlIlll, final int llllIIIIlIllI, final String llllIIIIlllIl, final int llllIIIIlllII, final int llllIIIIlIlIl, final String llllIIIIlIlII, final String llllIIIIlIIll) {
            this.field_176663_d = llllIIIIlIlIl;
            this.field_176664_e = llllIIIIlIlII;
            this.field_176661_f = llllIIIIlIIll;
        }
        
        public String func_176659_c() {
            return this.field_176661_f;
        }
        
        @Override
        public String getName() {
            return this.field_176664_e;
        }
        
        static {
            __OBFID = "CL_00002048";
            field_176666_c = new EnumType[values().length];
            for (final EnumType llllIIIlIllll : values()) {
                EnumType.field_176666_c[llllIIIlIllll.func_176657_a()] = llllIIIlIllll;
            }
        }
        
        @Override
        public String toString() {
            return this.field_176664_e;
        }
        
        public int func_176657_a() {
            return this.field_176663_d;
        }
    }
}
