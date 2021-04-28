package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.block.material.*;
import net.minecraft.util.*;

public class BlockStoneBrick extends Block
{
    public static final /* synthetic */ PropertyEnum VARIANT_PROP;
    
    @Override
    public IBlockState getStateFromMeta(final int llllIIllIllIll) {
        return this.getDefaultState().withProperty(BlockStoneBrick.VARIANT_PROP, EnumType.getStateFromMeta(llllIIllIllIll));
    }
    
    static {
        __OBFID = "CL_00000318";
        VARIANT_PROP = PropertyEnum.create("variant", EnumType.class);
        DEFAULT_META = EnumType.DEFAULT.getMetaFromState();
        MOSSY_META = EnumType.MOSSY.getMetaFromState();
        CRACKED_META = EnumType.CRACKED.getMetaFromState();
        CHISELED_META = EnumType.CHISELED.getMetaFromState();
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockStoneBrick.VARIANT_PROP });
    }
    
    @Override
    public void getSubBlocks(final Item llllIIlllIllIl, final CreativeTabs llllIIlllIllII, final List llllIIlllIIlIl) {
        for (final EnumType llllIIlllIIlll : EnumType.values()) {
            llllIIlllIIlIl.add(new ItemStack(llllIIlllIllIl, 1, llllIIlllIIlll.getMetaFromState()));
        }
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllIIllIlIlll) {
        return ((EnumType)llllIIllIlIlll.getValue(BlockStoneBrick.VARIANT_PROP)).getMetaFromState();
    }
    
    public BlockStoneBrick() {
        super(Material.rock);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockStoneBrick.VARIANT_PROP, EnumType.DEFAULT));
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    @Override
    public int damageDropped(final IBlockState llllIIllllIlIl) {
        return ((EnumType)llllIIllllIlIl.getValue(BlockStoneBrick.VARIANT_PROP)).getMetaFromState();
    }
    
    public enum EnumType implements IStringSerializable
    {
        CRACKED("CRACKED", 2, "CRACKED", 2, 2, "cracked_stonebrick", "cracked"), 
        DEFAULT("DEFAULT", 0, "DEFAULT", 0, 0, "stonebrick", "default");
        
        private static final /* synthetic */ EnumType[] TYPES_ARRAY;
        private final /* synthetic */ String field_176616_g;
        private final /* synthetic */ String field_176622_h;
        
        CHISELED("CHISELED", 3, "CHISELED", 3, 3, "chiseled_stonebrick", "chiseled"), 
        MOSSY("MOSSY", 1, "MOSSY", 1, 1, "mossy_stonebrick", "mossy");
        
        private final /* synthetic */ int field_176615_f;
        
        @Override
        public String toString() {
            return this.field_176616_g;
        }
        
        public static EnumType getStateFromMeta(int llllllllllllllIIIIlllllllIlllIll) {
            if (llllllllllllllIIIIlllllllIlllIll < 0 || llllllllllllllIIIIlllllllIlllIll >= EnumType.TYPES_ARRAY.length) {
                llllllllllllllIIIIlllllllIlllIll = 0;
            }
            return EnumType.TYPES_ARRAY[llllllllllllllIIIIlllllllIlllIll];
        }
        
        private EnumType(final String llllllllllllllIIIIllllllllIIlIlI, final int llllllllllllllIIIIllllllllIIlIII, final String llllllllllllllIIIIllllllllIlIIlI, final int llllllllllllllIIIIllllllllIlIIII, final int llllllllllllllIIIIllllllllIIllll, final String llllllllllllllIIIIllllllllIIlllI, final String llllllllllllllIIIIllllllllIIllII) {
            this.field_176615_f = llllllllllllllIIIIllllllllIIllll;
            this.field_176616_g = llllllllllllllIIIIllllllllIIlllI;
            this.field_176622_h = llllllllllllllIIIIllllllllIIllII;
        }
        
        @Override
        public String getName() {
            return this.field_176616_g;
        }
        
        public String getVariantName() {
            return this.field_176622_h;
        }
        
        public int getMetaFromState() {
            return this.field_176615_f;
        }
        
        static {
            __OBFID = "CL_00002057";
            TYPES_ARRAY = new EnumType[values().length];
            for (final EnumType llllllllllllllIIIIlllllllllIlIII : values()) {
                EnumType.TYPES_ARRAY[llllllllllllllIIIIlllllllllIlIII.getMetaFromState()] = llllllllllllllIIIIlllllllllIlIII;
            }
        }
    }
}
