package net.minecraft.block;

import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;

public class BlockQuartz extends Block
{
    public static final /* synthetic */ PropertyEnum VARIANT_PROP;
    
    static {
        __OBFID = "CL_00000292";
        VARIANT_PROP = PropertyEnum.create("variant", EnumType.class);
    }
    
    @Override
    public void getSubBlocks(final Item llllllllllllllIlIIlllllIIIIIlIII, final CreativeTabs llllllllllllllIlIIlllllIIIIIlIlI, final List llllllllllllllIlIIlllllIIIIIlIIl) {
        llllllllllllllIlIIlllllIIIIIlIIl.add(new ItemStack(llllllllllllllIlIIlllllIIIIIlIII, 1, EnumType.DEFAULT.getMetaFromState()));
        llllllllllllllIlIIlllllIIIIIlIIl.add(new ItemStack(llllllllllllllIlIIlllllIIIIIlIII, 1, EnumType.CHISELED.getMetaFromState()));
        llllllllllllllIlIIlllllIIIIIlIIl.add(new ItemStack(llllllllllllllIlIIlllllIIIIIlIII, 1, EnumType.LINES_Y.getMetaFromState()));
    }
    
    public BlockQuartz() {
        super(Material.rock);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockQuartz.VARIANT_PROP, EnumType.DEFAULT));
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    @Override
    public int damageDropped(final IBlockState llllllllllllllIlIIlllllIIIIllIIl) {
        final EnumType llllllllllllllIlIIlllllIIIIllIlI = (EnumType)llllllllllllllIlIIlllllIIIIllIIl.getValue(BlockQuartz.VARIANT_PROP);
        return (llllllllllllllIlIIlllllIIIIllIlI != EnumType.LINES_X && llllllllllllllIlIIlllllIIIIllIlI != EnumType.LINES_Z) ? llllllllllllllIlIIlllllIIIIllIlI.getMetaFromState() : EnumType.LINES_Y.getMetaFromState();
    }
    
    @Override
    public IBlockState onBlockPlaced(final World llllllllllllllIlIIlllllIIIlIlIIl, final BlockPos llllllllllllllIlIIlllllIIIlIlIII, final EnumFacing llllllllllllllIlIIlllllIIIlIIIII, final float llllllllllllllIlIIlllllIIIlIIllI, final float llllllllllllllIlIIlllllIIIlIIlIl, final float llllllllllllllIlIIlllllIIIlIIlII, final int llllllllllllllIlIIlllllIIIlIIIll, final EntityLivingBase llllllllllllllIlIIlllllIIIlIIIlI) {
        if (llllllllllllllIlIIlllllIIIlIIIll != EnumType.LINES_Y.getMetaFromState()) {
            return (llllllllllllllIlIIlllllIIIlIIIll == EnumType.CHISELED.getMetaFromState()) ? this.getDefaultState().withProperty(BlockQuartz.VARIANT_PROP, EnumType.CHISELED) : this.getDefaultState().withProperty(BlockQuartz.VARIANT_PROP, EnumType.DEFAULT);
        }
        switch (SwitchAxis.field_180101_a[llllllllllllllIlIIlllllIIIlIIIII.getAxis().ordinal()]) {
            case 1: {
                return this.getDefaultState().withProperty(BlockQuartz.VARIANT_PROP, EnumType.LINES_Z);
            }
            case 2: {
                return this.getDefaultState().withProperty(BlockQuartz.VARIANT_PROP, EnumType.LINES_X);
            }
            default: {
                return this.getDefaultState().withProperty(BlockQuartz.VARIANT_PROP, EnumType.LINES_Y);
            }
        }
    }
    
    @Override
    public MapColor getMapColor(final IBlockState llllllllllllllIlIIlllllIIIIIIlIl) {
        return MapColor.quartzColor;
    }
    
    @Override
    protected ItemStack createStackedBlock(final IBlockState llllllllllllllIlIIlllllIIIIlIIll) {
        final EnumType llllllllllllllIlIIlllllIIIIlIIlI = (EnumType)llllllllllllllIlIIlllllIIIIlIIll.getValue(BlockQuartz.VARIANT_PROP);
        return (llllllllllllllIlIIlllllIIIIlIIlI != EnumType.LINES_X && llllllllllllllIlIIlllllIIIIlIIlI != EnumType.LINES_Z) ? super.createStackedBlock(llllllllllllllIlIIlllllIIIIlIIll) : new ItemStack(Item.getItemFromBlock(this), 1, EnumType.LINES_Y.getMetaFromState());
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIlIIlllllIIIIIIIIl) {
        return this.getDefaultState().withProperty(BlockQuartz.VARIANT_PROP, EnumType.func_176794_a(llllllllllllllIlIIlllllIIIIIIIIl));
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIlIIllllIllllllIll) {
        return ((EnumType)llllllllllllllIlIIllllIllllllIll.getValue(BlockQuartz.VARIANT_PROP)).getMetaFromState();
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockQuartz.VARIANT_PROP });
    }
    
    static final class SwitchAxis
    {
        static final /* synthetic */ int[] field_180101_a;
        
        static {
            __OBFID = "CL_00002075";
            field_180101_a = new int[EnumFacing.Axis.values().length];
            try {
                SwitchAxis.field_180101_a[EnumFacing.Axis.Z.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchAxis.field_180101_a[EnumFacing.Axis.X.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchAxis.field_180101_a[EnumFacing.Axis.Y.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
        }
    }
    
    public enum EnumType implements IStringSerializable
    {
        LINES_Y("LINES_Y", 2, "LINES_Y", 2, 2, "lines_y", "lines"), 
        LINES_Z("LINES_Z", 4, "LINES_Z", 4, 4, "lines_z", "lines");
        
        private final /* synthetic */ String field_176806_i;
        private final /* synthetic */ String field_176805_h;
        
        DEFAULT("DEFAULT", 0, "DEFAULT", 0, 0, "default", "default"), 
        LINES_X("LINES_X", 3, "LINES_X", 3, 3, "lines_x", "lines");
        
        private static final /* synthetic */ EnumType[] TYPES_ARRAY;
        private final /* synthetic */ int field_176798_g;
        
        CHISELED("CHISELED", 1, "CHISELED", 1, 1, "chiseled", "chiseled");
        
        public static EnumType func_176794_a(int llllllllllllllIlIIllllIllIlIIIII) {
            if (llllllllllllllIlIIllllIllIlIIIII < 0 || llllllllllllllIlIIllllIllIlIIIII >= EnumType.TYPES_ARRAY.length) {
                llllllllllllllIlIIllllIllIlIIIII = 0;
            }
            return EnumType.TYPES_ARRAY[llllllllllllllIlIIllllIllIlIIIII];
        }
        
        public int getMetaFromState() {
            return this.field_176798_g;
        }
        
        @Override
        public String getName() {
            return this.field_176805_h;
        }
        
        private EnumType(final String llllllllllllllIlIIllllIllIlIllIl, final int llllllllllllllIlIIllllIllIlIllII, final String llllllllllllllIlIIllllIllIllIIll, final int llllllllllllllIlIIllllIllIllIIlI, final int llllllllllllllIlIIllllIllIllIIIl, final String llllllllllllllIlIIllllIllIlIlIlI, final String llllllllllllllIlIIllllIllIlIllll) {
            this.field_176798_g = llllllllllllllIlIIllllIllIllIIIl;
            this.field_176805_h = llllllllllllllIlIIllllIllIlIlIlI;
            this.field_176806_i = llllllllllllllIlIIllllIllIlIllll;
        }
        
        @Override
        public String toString() {
            return this.field_176806_i;
        }
        
        static {
            __OBFID = "CL_00002074";
            TYPES_ARRAY = new EnumType[values().length];
            for (final EnumType llllllllllllllIlIIllllIllIllllll : values()) {
                EnumType.TYPES_ARRAY[llllllllllllllIlIIllllIllIllllll.getMetaFromState()] = llllllllllllllIlIIllllIllIllllll;
            }
        }
    }
}
