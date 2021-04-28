package net.minecraft.block;

import net.minecraft.block.material.*;
import net.minecraft.block.properties.*;
import net.minecraft.creativetab.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;

public abstract class BlockStoneSlab extends BlockSlab
{
    public static final /* synthetic */ PropertyEnum field_176556_M;
    public static final /* synthetic */ PropertyBool field_176555_b;
    
    public BlockStoneSlab() {
        super(Material.rock);
        IBlockState llllllllllllllIlIlIIIIIIIllIIIlI = this.blockState.getBaseState();
        if (this.isDouble()) {
            llllllllllllllIlIlIIIIIIIllIIIlI = llllllllllllllIlIlIIIIIIIllIIIlI.withProperty(BlockStoneSlab.field_176555_b, false);
        }
        else {
            llllllllllllllIlIlIIIIIIIllIIIlI = llllllllllllllIlIlIIIIIIIllIIIlI.withProperty(BlockStoneSlab.HALF_PROP, EnumBlockHalf.BOTTOM);
        }
        this.setDefaultState(llllllllllllllIlIlIIIIIIIllIIIlI.withProperty(BlockStoneSlab.field_176556_M, EnumType.STONE));
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    @Override
    public IProperty func_176551_l() {
        return BlockStoneSlab.field_176556_M;
    }
    
    static {
        __OBFID = "CL_00000320";
        field_176555_b = PropertyBool.create("seamless");
        field_176556_M = PropertyEnum.create("variant", EnumType.class);
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllIlIlIIIIIIIlIllllI, final Random llllllllllllllIlIlIIIIIIIlIlllIl, final int llllllllllllllIlIlIIIIIIIlIlllII) {
        return Item.getItemFromBlock(Blocks.stone_slab);
    }
    
    @Override
    public Item getItem(final World llllllllllllllIlIlIIIIIIIlIllIlI, final BlockPos llllllllllllllIlIlIIIIIIIlIllIIl) {
        return Item.getItemFromBlock(Blocks.stone_slab);
    }
    
    @Override
    public int damageDropped(final IBlockState llllllllllllllIlIlIIIIIIIIIlllll) {
        return ((EnumType)llllllllllllllIlIlIIIIIIIIIlllll.getValue(BlockStoneSlab.field_176556_M)).func_176624_a();
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIlIlIIIIIIIIllIIlI) {
        IBlockState llllllllllllllIlIlIIIIIIIIllIlII = this.getDefaultState().withProperty(BlockStoneSlab.field_176556_M, EnumType.func_176625_a(llllllllllllllIlIlIIIIIIIIllIIlI & 0x7));
        if (this.isDouble()) {
            llllllllllllllIlIlIIIIIIIIllIlII = llllllllllllllIlIlIIIIIIIIllIlII.withProperty(BlockStoneSlab.field_176555_b, (llllllllllllllIlIlIIIIIIIIllIIlI & 0x8) != 0x0);
        }
        else {
            llllllllllllllIlIlIIIIIIIIllIlII = llllllllllllllIlIlIIIIIIIIllIlII.withProperty(BlockStoneSlab.HALF_PROP, ((llllllllllllllIlIlIIIIIIIIllIIlI & 0x8) == 0x0) ? EnumBlockHalf.BOTTOM : EnumBlockHalf.TOP);
        }
        return llllllllllllllIlIlIIIIIIIIllIlII;
    }
    
    @Override
    public void getSubBlocks(final Item llllllllllllllIlIlIIIIIIIlIIIllI, final CreativeTabs llllllllllllllIlIlIIIIIIIlIIIlIl, final List llllllllllllllIlIlIIIIIIIIlllllI) {
        if (llllllllllllllIlIlIIIIIIIlIIIllI != Item.getItemFromBlock(Blocks.double_stone_slab)) {
            for (final EnumType llllllllllllllIlIlIIIIIIIlIIIIII : EnumType.values()) {
                if (llllllllllllllIlIlIIIIIIIlIIIIII != EnumType.WOOD) {
                    llllllllllllllIlIlIIIIIIIIlllllI.add(new ItemStack(llllllllllllllIlIlIIIIIIIlIIIllI, 1, llllllllllllllIlIlIIIIIIIlIIIIII.func_176624_a()));
                }
            }
        }
    }
    
    @Override
    public String getFullSlabName(final int llllllllllllllIlIlIIIIIIIlIlIlIl) {
        return String.valueOf(new StringBuilder(String.valueOf(super.getUnlocalizedName())).append(".").append(EnumType.func_176625_a(llllllllllllllIlIlIIIIIIIlIlIlIl).func_176627_c()));
    }
    
    @Override
    protected BlockState createBlockState() {
        return this.isDouble() ? new BlockState(this, new IProperty[] { BlockStoneSlab.field_176555_b, BlockStoneSlab.field_176556_M }) : new BlockState(this, new IProperty[] { BlockStoneSlab.HALF_PROP, BlockStoneSlab.field_176556_M });
    }
    
    @Override
    public Object func_176553_a(final ItemStack llllllllllllllIlIlIIIIIIIlIIllll) {
        return EnumType.func_176625_a(llllllllllllllIlIlIIIIIIIlIIllll.getMetadata() & 0x7);
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIlIlIIIIIIIIlIIlll) {
        final byte llllllllllllllIlIlIIIIIIIIlIlIlI = 0;
        int llllllllllllllIlIlIIIIIIIIlIlIIl = llllllllllllllIlIlIIIIIIIIlIlIlI | ((EnumType)llllllllllllllIlIlIIIIIIIIlIIlll.getValue(BlockStoneSlab.field_176556_M)).func_176624_a();
        if (this.isDouble()) {
            if (llllllllllllllIlIlIIIIIIIIlIIlll.getValue(BlockStoneSlab.field_176555_b)) {
                llllllllllllllIlIlIIIIIIIIlIlIIl |= 0x8;
            }
        }
        else if (llllllllllllllIlIlIIIIIIIIlIIlll.getValue(BlockStoneSlab.HALF_PROP) == EnumBlockHalf.TOP) {
            llllllllllllllIlIlIIIIIIIIlIlIIl |= 0x8;
        }
        return llllllllllllllIlIlIIIIIIIIlIlIIl;
    }
    
    public enum EnumType implements IStringSerializable
    {
        SAND("SAND", 1, "SAND", 1, 1, "sandstone", "sand"), 
        COBBLESTONE("COBBLESTONE", 3, "COBBLESTONE", 3, 3, "cobblestone", "cobble"), 
        SMOOTHBRICK("SMOOTHBRICK", 5, "SMOOTHBRICK", 5, 5, "stone_brick", "smoothStoneBrick"), 
        NETHERBRICK("NETHERBRICK", 6, "NETHERBRICK", 6, 6, "nether_brick", "netherBrick");
        
        private static final /* synthetic */ EnumType[] field_176640_i;
        
        STONE("STONE", 0, "STONE", 0, 0, "stone"), 
        WOOD("WOOD", 2, "WOOD", 2, 2, "wood_old", "wood");
        
        private final /* synthetic */ String field_176635_l;
        private final /* synthetic */ String field_176638_k;
        private final /* synthetic */ int field_176637_j;
        
        BRICK("BRICK", 4, "BRICK", 4, 4, "brick"), 
        QUARTZ("QUARTZ", 7, "QUARTZ", 7, 7, "quartz");
        
        private EnumType(final String llllllllllllllIIlIlIIIIIIIlIlIII, final int llllllllllllllIIlIlIIIIIIIlIIlll, final String llllllllllllllIIlIlIIIIIIIlIlllI, final int llllllllllllllIIlIlIIIIIIIlIllIl, final int llllllllllllllIIlIlIIIIIIIlIIllI, final String llllllllllllllIIlIlIIIIIIIlIlIll, final String llllllllllllllIIlIlIIIIIIIlIIlII) {
            this.field_176637_j = llllllllllllllIIlIlIIIIIIIlIIllI;
            this.field_176638_k = llllllllllllllIIlIlIIIIIIIlIlIll;
            this.field_176635_l = llllllllllllllIIlIlIIIIIIIlIIlII;
        }
        
        private EnumType(final String llllllllllllllIIlIlIIIIIIIlllIll, final int llllllllllllllIIlIlIIIIIIIlllIlI, final String llllllllllllllIIlIlIIIIIIllllIII, final int llllllllllllllIIlIlIIIIIIIlllIII, final int llllllllllllllIIlIlIIIIIIIllIlll, final String llllllllllllllIIlIlIIIIIIIllllIl) {
            this(llllllllllllllIIlIlIIIIIIIlllIll, llllllllllllllIIlIlIIIIIIIlllIlI, llllllllllllllIIlIlIIIIIIllllIII, llllllllllllllIIlIlIIIIIIIlllIII, llllllllllllllIIlIlIIIIIIIllIlll, llllllllllllllIIlIlIIIIIIIllllIl, llllllllllllllIIlIlIIIIIIIllllIl);
        }
        
        public int func_176624_a() {
            return this.field_176637_j;
        }
        
        static {
            __OBFID = "CL_00002056";
            field_176640_i = new EnumType[values().length];
            for (final EnumType llllllllllllllIIlIlIIIIIlIIIlllI : values()) {
                EnumType.field_176640_i[llllllllllllllIIlIlIIIIIlIIIlllI.func_176624_a()] = llllllllllllllIIlIlIIIIIlIIIlllI;
            }
        }
        
        public static EnumType func_176625_a(int llllllllllllllIIlIlIIIIIIIIllIll) {
            if (llllllllllllllIIlIlIIIIIIIIllIll < 0 || llllllllllllllIIlIlIIIIIIIIllIll >= EnumType.field_176640_i.length) {
                llllllllllllllIIlIlIIIIIIIIllIll = 0;
            }
            return EnumType.field_176640_i[llllllllllllllIIlIlIIIIIIIIllIll];
        }
        
        public String func_176627_c() {
            return this.field_176635_l;
        }
        
        @Override
        public String getName() {
            return this.field_176638_k;
        }
        
        @Override
        public String toString() {
            return this.field_176638_k;
        }
    }
}
