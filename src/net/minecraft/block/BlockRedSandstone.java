package net.minecraft.block;

import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.block.material.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;

public class BlockRedSandstone extends Block
{
    public static final /* synthetic */ PropertyEnum TYPE;
    
    static {
        __OBFID = "CL_00002072";
        TYPE = PropertyEnum.create("type", EnumType.class);
    }
    
    @Override
    public void getSubBlocks(final Item llllllllllllllIlIIIlIlIlIlllIlIl, final CreativeTabs llllllllllllllIlIIIlIlIlIlllIlII, final List llllllllllllllIlIIIlIlIlIlllIIll) {
        for (final EnumType llllllllllllllIlIIIlIlIlIllIllll : EnumType.values()) {
            llllllllllllllIlIIIlIlIlIlllIIll.add(new ItemStack(llllllllllllllIlIIIlIlIlIlllIlIl, 1, llllllllllllllIlIIIlIlIlIllIllll.getMetaFromState()));
        }
    }
    
    public BlockRedSandstone() {
        super(Material.rock);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockRedSandstone.TYPE, EnumType.DEFAULT));
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    @Override
    public int damageDropped(final IBlockState llllllllllllllIlIIIlIlIlIllllllI) {
        return ((EnumType)llllllllllllllIlIIIlIlIlIllllllI.getValue(BlockRedSandstone.TYPE)).getMetaFromState();
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIlIIIlIlIlIllIIIll) {
        return this.getDefaultState().withProperty(BlockRedSandstone.TYPE, EnumType.func_176825_a(llllllllllllllIlIIIlIlIlIllIIIll));
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockRedSandstone.TYPE });
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIlIIIlIlIlIlIlllll) {
        return ((EnumType)llllllllllllllIlIIIlIlIlIlIlllll.getValue(BlockRedSandstone.TYPE)).getMetaFromState();
    }
    
    public enum EnumType implements IStringSerializable
    {
        private final /* synthetic */ String field_176830_g;
        
        SMOOTH("SMOOTH", 2, "SMOOTH", 2, 2, "smooth_red_sandstone", "smooth"), 
        CHISELED("CHISELED", 1, "CHISELED", 1, 1, "chiseled_red_sandstone", "chiseled");
        
        private final /* synthetic */ String field_176829_f;
        private static final /* synthetic */ EnumType[] field_176831_d;
        
        DEFAULT("DEFAULT", 0, "DEFAULT", 0, 0, "red_sandstone", "default");
        
        private final /* synthetic */ int field_176832_e;
        
        @Override
        public String toString() {
            return this.field_176829_f;
        }
        
        public static EnumType func_176825_a(int llllllllllllllIIlIIllllIlllIlIII) {
            if (llllllllllllllIIlIIllllIlllIlIII < 0 || llllllllllllllIIlIIllllIlllIlIII >= EnumType.field_176831_d.length) {
                llllllllllllllIIlIIllllIlllIlIII = 0;
            }
            return EnumType.field_176831_d[llllllllllllllIIlIIllllIlllIlIII];
        }
        
        private EnumType(final String llllllllllllllIIlIIllllIllllIlIl, final int llllllllllllllIIlIIllllIllllIlII, final String llllllllllllllIIlIIllllIlllllIll, final int llllllllllllllIIlIIllllIlllllIlI, final int llllllllllllllIIlIIllllIllllIIll, final String llllllllllllllIIlIIllllIlllllIII, final String llllllllllllllIIlIIllllIllllIIIl) {
            this.field_176832_e = llllllllllllllIIlIIllllIllllIIll;
            this.field_176829_f = llllllllllllllIIlIIllllIlllllIII;
            this.field_176830_g = llllllllllllllIIlIIllllIllllIIIl;
        }
        
        @Override
        public String getName() {
            return this.field_176829_f;
        }
        
        public int getMetaFromState() {
            return this.field_176832_e;
        }
        
        static {
            __OBFID = "CL_00002071";
            field_176831_d = new EnumType[values().length];
            for (final EnumType llllllllllllllIIlIIlllllIIIIIlll : values()) {
                EnumType.field_176831_d[llllllllllllllIIlIIlllllIIIIIlll.getMetaFromState()] = llllllllllllllIIlIIlllllIIIIIlll;
            }
        }
        
        public String func_176828_c() {
            return this.field_176830_g;
        }
    }
}
