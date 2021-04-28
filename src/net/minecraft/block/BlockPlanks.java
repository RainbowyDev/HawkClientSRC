package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;

public class BlockPlanks extends Block
{
    public static final /* synthetic */ PropertyEnum VARIANT_PROP;
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIIIlIlIllIIlllIlll) {
        return ((EnumType)llllllllllllllIIIlIlIllIIlllIlll.getValue(BlockPlanks.VARIANT_PROP)).func_176839_a();
    }
    
    @Override
    public void getSubBlocks(final Item llllllllllllllIIIlIlIllIlIIllIll, final CreativeTabs llllllllllllllIIIlIlIllIlIIllIIl, final List llllllllllllllIIIlIlIllIlIIlIlll) {
        for (final EnumType llllllllllllllIIIlIlIllIlIIlIIlI : EnumType.values()) {
            llllllllllllllIIIlIlIllIlIIlIlll.add(new ItemStack(llllllllllllllIIIlIlIllIlIIllIll, 1, llllllllllllllIIIlIlIllIlIIlIIlI.func_176839_a()));
        }
    }
    
    public BlockPlanks() {
        super(Material.wood);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockPlanks.VARIANT_PROP, EnumType.OAK));
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    static {
        __OBFID = "CL_00002082";
        VARIANT_PROP = PropertyEnum.create("variant", EnumType.class);
    }
    
    @Override
    public int damageDropped(final IBlockState llllllllllllllIIIlIlIllIlIllIIII) {
        return ((EnumType)llllllllllllllIIIlIlIllIlIllIIII.getValue(BlockPlanks.VARIANT_PROP)).func_176839_a();
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIIIlIlIllIIlllllIl) {
        return this.getDefaultState().withProperty(BlockPlanks.VARIANT_PROP, EnumType.func_176837_a(llllllllllllllIIIlIlIllIIlllllIl));
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockPlanks.VARIANT_PROP });
    }
    
    public enum EnumType implements IStringSerializable
    {
        private final /* synthetic */ int field_176850_h;
        
        DARK_OAK("DARK_OAK", 5, "DARK_OAK", 5, 5, "dark_oak", "big_oak");
        
        private final /* synthetic */ String field_176851_i;
        
        SPRUCE("SPRUCE", 1, "SPRUCE", 1, 1, "spruce"), 
        ACACIA("ACACIA", 4, "ACACIA", 4, 4, "acacia");
        
        private final /* synthetic */ String field_176848_j;
        
        BIRCH("BIRCH", 2, "BIRCH", 2, 2, "birch"), 
        JUNGLE("JUNGLE", 3, "JUNGLE", 3, 3, "jungle");
        
        private static final /* synthetic */ EnumType[] field_176842_g;
        
        OAK("OAK", 0, "OAK", 0, 0, "oak");
        
        private EnumType(final String lllllllllllllllIIIIIIIlllIIIlIlI, final int lllllllllllllllIIIIIIIlllIIIlIIl, final String lllllllllllllllIIIIIIIlllIIlIIII, final int lllllllllllllllIIIIIIIlllIIIllll, final int lllllllllllllllIIIIIIIlllIIIlllI, final String lllllllllllllllIIIIIIIlllIIIllIl, final String lllllllllllllllIIIIIIIlllIIIllII) {
            this.field_176850_h = lllllllllllllllIIIIIIIlllIIIlllI;
            this.field_176851_i = lllllllllllllllIIIIIIIlllIIIllIl;
            this.field_176848_j = lllllllllllllllIIIIIIIlllIIIllII;
        }
        
        public String func_176840_c() {
            return this.field_176848_j;
        }
        
        private EnumType(final String lllllllllllllllIIIIIIIlllIIlllIl, final int lllllllllllllllIIIIIIIlllIIlllII, final String lllllllllllllllIIIIIIIlllIlIIlIl, final int lllllllllllllllIIIIIIIlllIIllIlI, final int lllllllllllllllIIIIIIIlllIIllIIl, final String lllllllllllllllIIIIIIIlllIIllIII) {
            this(lllllllllllllllIIIIIIIlllIIlllIl, lllllllllllllllIIIIIIIlllIIlllII, lllllllllllllllIIIIIIIlllIlIIlIl, lllllllllllllllIIIIIIIlllIIllIlI, lllllllllllllllIIIIIIIlllIIllIIl, lllllllllllllllIIIIIIIlllIIllIII, lllllllllllllllIIIIIIIlllIIllIII);
        }
        
        @Override
        public String toString() {
            return this.field_176851_i;
        }
        
        public int func_176839_a() {
            return this.field_176850_h;
        }
        
        static {
            __OBFID = "CL_00002081";
            field_176842_g = new EnumType[values().length];
            for (final EnumType lllllllllllllllIIIIIIIlllIlllIIl : values()) {
                EnumType.field_176842_g[lllllllllllllllIIIIIIIlllIlllIIl.func_176839_a()] = lllllllllllllllIIIIIIIlllIlllIIl;
            }
        }
        
        public static EnumType func_176837_a(int lllllllllllllllIIIIIIIllIlllllIl) {
            if (lllllllllllllllIIIIIIIllIlllllIl < 0 || lllllllllllllllIIIIIIIllIlllllIl >= EnumType.field_176842_g.length) {
                lllllllllllllllIIIIIIIllIlllllIl = 0;
            }
            return EnumType.field_176842_g[lllllllllllllllIIIIIIIllIlllllIl];
        }
        
        @Override
        public String getName() {
            return this.field_176851_i;
        }
    }
}
