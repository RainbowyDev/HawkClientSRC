package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.util.*;

public class BlockStone extends Block
{
    public static final /* synthetic */ PropertyEnum VARIANT_PROP;
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllIIlIIllIlIllllIII) {
        return ((EnumType)lllllllllllllllIIlIIllIlIllllIII.getValue(BlockStone.VARIANT_PROP)).getMetaFromState();
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllIIlIIllIlIlllllII) {
        return this.getDefaultState().withProperty(BlockStone.VARIANT_PROP, EnumType.getStateFromMeta(lllllllllllllllIIlIIllIlIlllllII));
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockStone.VARIANT_PROP });
    }
    
    static {
        __OBFID = "CL_00000317";
        VARIANT_PROP = PropertyEnum.create("variant", EnumType.class);
    }
    
    @Override
    public int damageDropped(final IBlockState lllllllllllllllIIlIIllIllIIlIlll) {
        return ((EnumType)lllllllllllllllIIlIIllIllIIlIlll.getValue(BlockStone.VARIANT_PROP)).getMetaFromState();
    }
    
    public BlockStone() {
        super(Material.rock);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockStone.VARIANT_PROP, EnumType.STONE));
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    @Override
    public void getSubBlocks(final Item lllllllllllllllIIlIIllIllIIIlllI, final CreativeTabs lllllllllllllllIIlIIllIllIIIllIl, final List lllllllllllllllIIlIIllIllIIIllII) {
        for (final EnumType lllllllllllllllIIlIIllIllIIIlIII : EnumType.values()) {
            lllllllllllllllIIlIIllIllIIIllII.add(new ItemStack(lllllllllllllllIIlIIllIllIIIlllI, 1, lllllllllllllllIIlIIllIllIIIlIII.getMetaFromState()));
        }
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllllIIlIIllIllIIlllIl, final Random lllllllllllllllIIlIIllIllIIlllII, final int lllllllllllllllIIlIIllIllIIllIll) {
        return (lllllllllllllllIIlIIllIllIIlllIl.getValue(BlockStone.VARIANT_PROP) == EnumType.STONE) ? Item.getItemFromBlock(Blocks.cobblestone) : Item.getItemFromBlock(Blocks.stone);
    }
    
    public enum EnumType implements IStringSerializable
    {
        DIORITE("DIORITE", 3, "DIORITE", 3, 3, "diorite");
        
        private final /* synthetic */ String name;
        
        STONE("STONE", 0, "STONE", 0, 0, "stone");
        
        private final /* synthetic */ String field_176654_k;
        
        DIORITE_SMOOTH("DIORITE_SMOOTH", 4, "DIORITE_SMOOTH", 4, 4, "smooth_diorite", "dioriteSmooth"), 
        GRANITE_SMOOTH("GRANITE_SMOOTH", 2, "GRANITE_SMOOTH", 2, 2, "smooth_granite", "graniteSmooth");
        
        private final /* synthetic */ int meta;
        
        ANDESITE_SMOOTH("ANDESITE_SMOOTH", 6, "ANDESITE_SMOOTH", 6, 6, "smooth_andesite", "andesiteSmooth"), 
        ANDESITE("ANDESITE", 5, "ANDESITE", 5, 5, "andesite"), 
        GRANITE("GRANITE", 1, "GRANITE", 1, 1, "granite");
        
        private static final /* synthetic */ EnumType[] BLOCKSTATES;
        
        static {
            __OBFID = "CL_00002058";
            BLOCKSTATES = new EnumType[values().length];
            for (final EnumType lllllllllllllllIllllllIIIllllIll : values()) {
                EnumType.BLOCKSTATES[lllllllllllllllIllllllIIIllllIll.getMetaFromState()] = lllllllllllllllIllllllIIIllllIll;
            }
        }
        
        @Override
        public String getName() {
            return this.name;
        }
        
        public int getMetaFromState() {
            return this.meta;
        }
        
        public static EnumType getStateFromMeta(int lllllllllllllllIllllllIIIlIIlIIl) {
            if (lllllllllllllllIllllllIIIlIIlIIl < 0 || lllllllllllllllIllllllIIIlIIlIIl >= EnumType.BLOCKSTATES.length) {
                lllllllllllllllIllllllIIIlIIlIIl = 0;
            }
            return EnumType.BLOCKSTATES[lllllllllllllllIllllllIIIlIIlIIl];
        }
        
        private EnumType(final String lllllllllllllllIllllllIIIllIlIIl, final int lllllllllllllllIllllllIIIllIlIII, final String lllllllllllllllIllllllIIIllIlllI, final int lllllllllllllllIllllllIIIllIllIl, final int lllllllllllllllIllllllIIIllIIlIl, final String lllllllllllllllIllllllIIIllIIlII) {
            this(lllllllllllllllIllllllIIIllIlIIl, lllllllllllllllIllllllIIIllIlIII, lllllllllllllllIllllllIIIllIlllI, lllllllllllllllIllllllIIIllIllIl, lllllllllllllllIllllllIIIllIIlIl, lllllllllllllllIllllllIIIllIIlII, lllllllllllllllIllllllIIIllIIlII);
        }
        
        private EnumType(final String lllllllllllllllIllllllIIIlIlIllI, final int lllllllllllllllIllllllIIIlIlIlIl, final String lllllllllllllllIllllllIIIlIlllII, final int lllllllllllllllIllllllIIIlIllIll, final int lllllllllllllllIllllllIIIlIllIlI, final String lllllllllllllllIllllllIIIlIlIIll, final String lllllllllllllllIllllllIIIlIllIII) {
            this.meta = lllllllllllllllIllllllIIIlIllIlI;
            this.name = lllllllllllllllIllllllIIIlIlIIll;
            this.field_176654_k = lllllllllllllllIllllllIIIlIllIII;
        }
        
        public String func_176644_c() {
            return this.field_176654_k;
        }
        
        @Override
        public String toString() {
            return this.name;
        }
    }
}
