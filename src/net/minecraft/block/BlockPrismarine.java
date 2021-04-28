package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.util.*;

public class BlockPrismarine extends Block
{
    public static final /* synthetic */ PropertyEnum VARIANTS;
    public static final /* synthetic */ int ROUGHMETA;
    public static final /* synthetic */ int DARKMETA;
    public static final /* synthetic */ int BRICKSMETA;
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllllIIlIIlIlIllllII) {
        return this.getDefaultState().withProperty(BlockPrismarine.VARIANTS, EnumType.func_176810_a(lllllllllllllllllIIlIIlIlIllllII));
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllllIIlIIlIllIIIlIl) {
        return ((EnumType)lllllllllllllllllIIlIIlIllIIIlIl.getValue(BlockPrismarine.VARIANTS)).getMetadata();
    }
    
    public BlockPrismarine() {
        super(Material.rock);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockPrismarine.VARIANTS, EnumType.ROUGH));
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockPrismarine.VARIANTS });
    }
    
    @Override
    public int damageDropped(final IBlockState lllllllllllllllllIIlIIlIllIIlIIl) {
        return ((EnumType)lllllllllllllllllIIlIIlIllIIlIIl.getValue(BlockPrismarine.VARIANTS)).getMetadata();
    }
    
    @Override
    public void getSubBlocks(final Item lllllllllllllllllIIlIIlIlIllIlIl, final CreativeTabs lllllllllllllllllIIlIIlIlIllIlll, final List lllllllllllllllllIIlIIlIlIllIllI) {
        lllllllllllllllllIIlIIlIlIllIllI.add(new ItemStack(lllllllllllllllllIIlIIlIlIllIlIl, 1, BlockPrismarine.ROUGHMETA));
        lllllllllllllllllIIlIIlIlIllIllI.add(new ItemStack(lllllllllllllllllIIlIIlIlIllIlIl, 1, BlockPrismarine.BRICKSMETA));
        lllllllllllllllllIIlIIlIlIllIllI.add(new ItemStack(lllllllllllllllllIIlIIlIlIllIlIl, 1, BlockPrismarine.DARKMETA));
    }
    
    static {
        __OBFID = "CL_00002077";
        VARIANTS = PropertyEnum.create("variant", EnumType.class);
        ROUGHMETA = EnumType.ROUGH.getMetadata();
        BRICKSMETA = EnumType.BRICKS.getMetadata();
        DARKMETA = EnumType.DARK.getMetadata();
    }
    
    public enum EnumType implements IStringSerializable
    {
        DARK("DARK", 2, "DARK", 2, 2, "dark_prismarine", "dark"), 
        BRICKS("BRICKS", 1, "BRICKS", 1, 1, "prismarine_bricks", "bricks");
        
        private static final /* synthetic */ EnumType[] field_176813_d;
        private final /* synthetic */ int meta;
        private final /* synthetic */ String field_176812_g;
        
        ROUGH("ROUGH", 0, "ROUGH", 0, 0, "prismarine", "rough");
        
        private final /* synthetic */ String field_176811_f;
        
        @Override
        public String toString() {
            return this.field_176811_f;
        }
        
        @Override
        public String getName() {
            return this.field_176811_f;
        }
        
        public static EnumType func_176810_a(int llllllllllllllIIlIllIllIIlllIIII) {
            if (llllllllllllllIIlIllIllIIlllIIII < 0 || llllllllllllllIIlIllIllIIlllIIII >= EnumType.field_176813_d.length) {
                llllllllllllllIIlIllIllIIlllIIII = 0;
            }
            return EnumType.field_176813_d[llllllllllllllIIlIllIllIIlllIIII];
        }
        
        static {
            __OBFID = "CL_00002076";
            field_176813_d = new EnumType[values().length];
            for (final EnumType llllllllllllllIIlIllIllIlIIIllll : values()) {
                EnumType.field_176813_d[llllllllllllllIIlIllIllIlIIIllll.getMetadata()] = llllllllllllllIIlIllIllIlIIIllll;
            }
        }
        
        private EnumType(final String llllllllllllllIIlIllIllIIlllllIl, final int llllllllllllllIIlIllIllIIlllllII, final String llllllllllllllIIlIllIllIlIIIIIll, final int llllllllllllllIIlIllIllIlIIIIIlI, final int llllllllllllllIIlIllIllIIllllIll, final String llllllllllllllIIlIllIllIIllllIlI, final String llllllllllllllIIlIllIllIIlllllll) {
            this.meta = llllllllllllllIIlIllIllIIllllIll;
            this.field_176811_f = llllllllllllllIIlIllIllIIllllIlI;
            this.field_176812_g = llllllllllllllIIlIllIllIIlllllll;
        }
        
        public String func_176809_c() {
            return this.field_176812_g;
        }
        
        public int getMetadata() {
            return this.meta;
        }
    }
}
