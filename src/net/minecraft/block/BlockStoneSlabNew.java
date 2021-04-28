package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.util.*;

public abstract class BlockStoneSlabNew extends BlockSlab
{
    public static final /* synthetic */ PropertyBool field_176558_b;
    public static final /* synthetic */ PropertyEnum field_176559_M;
    
    @Override
    protected BlockState createBlockState() {
        return this.isDouble() ? new BlockState(this, new IProperty[] { BlockStoneSlabNew.field_176558_b, BlockStoneSlabNew.field_176559_M }) : new BlockState(this, new IProperty[] { BlockStoneSlabNew.HALF_PROP, BlockStoneSlabNew.field_176559_M });
    }
    
    static {
        __OBFID = "CL_00002087";
        field_176558_b = PropertyBool.create("seamless");
        field_176559_M = PropertyEnum.create("variant", EnumType.class);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIIllIIIIllllIIIlIl) {
        IBlockState llllllllllllllIIllIIIIllllIIIlll = this.getDefaultState().withProperty(BlockStoneSlabNew.field_176559_M, EnumType.func_176916_a(llllllllllllllIIllIIIIllllIIIlIl & 0x7));
        if (this.isDouble()) {
            llllllllllllllIIllIIIIllllIIIlll = llllllllllllllIIllIIIIllllIIIlll.withProperty(BlockStoneSlabNew.field_176558_b, (llllllllllllllIIllIIIIllllIIIlIl & 0x8) != 0x0);
        }
        else {
            llllllllllllllIIllIIIIllllIIIlll = llllllllllllllIIllIIIIllllIIIlll.withProperty(BlockStoneSlabNew.HALF_PROP, ((llllllllllllllIIllIIIIllllIIIlIl & 0x8) == 0x0) ? EnumBlockHalf.BOTTOM : EnumBlockHalf.TOP);
        }
        return llllllllllllllIIllIIIIllllIIIlll;
    }
    
    @Override
    public int damageDropped(final IBlockState llllllllllllllIIllIIIIlllIllIIIl) {
        return ((EnumType)llllllllllllllIIllIIIIlllIllIIIl.getValue(BlockStoneSlabNew.field_176559_M)).func_176915_a();
    }
    
    @Override
    public Object func_176553_a(final ItemStack llllllllllllllIIllIIIIlllllIIIIl) {
        return EnumType.func_176916_a(llllllllllllllIIllIIIIlllllIIIIl.getMetadata() & 0x7);
    }
    
    @Override
    public String getFullSlabName(final int llllllllllllllIIllIIIIlllllIlIII) {
        return String.valueOf(new StringBuilder(String.valueOf(super.getUnlocalizedName())).append(".").append(EnumType.func_176916_a(llllllllllllllIIllIIIIlllllIlIII).func_176918_c()));
    }
    
    public BlockStoneSlabNew() {
        super(Material.rock);
        IBlockState llllllllllllllIIllIIIIllllllIlIl = this.blockState.getBaseState();
        if (this.isDouble()) {
            llllllllllllllIIllIIIIllllllIlIl = llllllllllllllIIllIIIIllllllIlIl.withProperty(BlockStoneSlabNew.field_176558_b, false);
        }
        else {
            llllllllllllllIIllIIIIllllllIlIl = llllllllllllllIIllIIIIllllllIlIl.withProperty(BlockStoneSlabNew.HALF_PROP, EnumBlockHalf.BOTTOM);
        }
        this.setDefaultState(llllllllllllllIIllIIIIllllllIlIl.withProperty(BlockStoneSlabNew.field_176559_M, EnumType.RED_SANDSTONE));
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    @Override
    public void getSubBlocks(final Item llllllllllllllIIllIIIIllllIlIIlI, final CreativeTabs llllllllllllllIIllIIIIllllIllIII, final List llllllllllllllIIllIIIIllllIlIlll) {
        if (llllllllllllllIIllIIIIllllIlIIlI != Item.getItemFromBlock(Blocks.double_stone_slab2)) {
            for (final EnumType llllllllllllllIIllIIIIllllIlIIll : EnumType.values()) {
                llllllllllllllIIllIIIIllllIlIlll.add(new ItemStack(llllllllllllllIIllIIIIllllIlIIlI, 1, llllllllllllllIIllIIIIllllIlIIll.func_176915_a()));
            }
        }
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllIIllIIIIllllllIIIl, final Random llllllllllllllIIllIIIIllllllIIII, final int llllllllllllllIIllIIIIlllllIllll) {
        return Item.getItemFromBlock(Blocks.stone_slab2);
    }
    
    @Override
    public Item getItem(final World llllllllllllllIIllIIIIlllllIllIl, final BlockPos llllllllllllllIIllIIIIlllllIllII) {
        return Item.getItemFromBlock(Blocks.stone_slab2);
    }
    
    @Override
    public IProperty func_176551_l() {
        return BlockStoneSlabNew.field_176559_M;
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIIllIIIIlllIlllllI) {
        final byte llllllllllllllIIllIIIIlllIllllIl = 0;
        int llllllllllllllIIllIIIIlllIllllII = llllllllllllllIIllIIIIlllIllllIl | ((EnumType)llllllllllllllIIllIIIIlllIlllllI.getValue(BlockStoneSlabNew.field_176559_M)).func_176915_a();
        if (this.isDouble()) {
            if (llllllllllllllIIllIIIIlllIlllllI.getValue(BlockStoneSlabNew.field_176558_b)) {
                llllllllllllllIIllIIIIlllIllllII |= 0x8;
            }
        }
        else if (llllllllllllllIIllIIIIlllIlllllI.getValue(BlockStoneSlabNew.HALF_PROP) == EnumBlockHalf.TOP) {
            llllllllllllllIIllIIIIlllIllllII |= 0x8;
        }
        return llllllllllllllIIllIIIIlllIllllII;
    }
    
    public enum EnumType implements IStringSerializable
    {
        private final /* synthetic */ int field_176922_c;
        
        RED_SANDSTONE("RED_SANDSTONE", 0, "RED_SANDSTONE", 0, 0, "red_sandstone");
        
        private static final /* synthetic */ EnumType[] field_176921_b;
        private final /* synthetic */ String field_176919_d;
        
        public int func_176915_a() {
            return this.field_176922_c;
        }
        
        @Override
        public String getName() {
            return this.field_176919_d;
        }
        
        public static EnumType func_176916_a(int lllllllllllllllIlIlIlllIIlIIIlll) {
            if (lllllllllllllllIlIlIlllIIlIIIlll < 0 || lllllllllllllllIlIlIlllIIlIIIlll >= EnumType.field_176921_b.length) {
                lllllllllllllllIlIlIlllIIlIIIlll = 0;
            }
            return EnumType.field_176921_b[lllllllllllllllIlIlIlllIIlIIIlll];
        }
        
        @Override
        public String toString() {
            return this.field_176919_d;
        }
        
        private EnumType(final String lllllllllllllllIlIlIlllIIlIlIIll, final int lllllllllllllllIlIlIlllIIlIlIIlI, final String lllllllllllllllIlIlIlllIIlIllIII, final int lllllllllllllllIlIlIlllIIlIlIlll, final int lllllllllllllllIlIlIlllIIlIlIIIl, final String lllllllllllllllIlIlIlllIIlIlIIII) {
            this.field_176922_c = lllllllllllllllIlIlIlllIIlIlIIIl;
            this.field_176919_d = lllllllllllllllIlIlIlllIIlIlIIII;
        }
        
        static {
            __OBFID = "CL_00002086";
            field_176921_b = new EnumType[values().length];
            for (final EnumType lllllllllllllllIlIlIlllIIllIIIll : values()) {
                EnumType.field_176921_b[lllllllllllllllIlIlIlllIIllIIIll.func_176915_a()] = lllllllllllllllIlIlIlllIIllIIIll;
            }
        }
        
        public String func_176918_c() {
            return this.field_176919_d;
        }
    }
}
