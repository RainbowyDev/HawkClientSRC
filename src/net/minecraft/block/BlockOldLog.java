package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.block.state.*;
import com.google.common.base.*;

public class BlockOldLog extends BlockLog
{
    public static final /* synthetic */ PropertyEnum VARIANT_PROP;
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllIllIIlllIIIIIlllI) {
        IBlockState lllllllllllllllIllIIlllIIIIIllIl = this.getDefaultState().withProperty(BlockOldLog.VARIANT_PROP, BlockPlanks.EnumType.func_176837_a((lllllllllllllllIllIIlllIIIIIlllI & 0x3) % 4));
        switch (lllllllllllllllIllIIlllIIIIIlllI & 0xC) {
            case 0: {
                lllllllllllllllIllIIlllIIIIIllIl = lllllllllllllllIllIIlllIIIIIllIl.withProperty(BlockOldLog.AXIS_PROP, EnumAxis.Y);
                break;
            }
            case 4: {
                lllllllllllllllIllIIlllIIIIIllIl = lllllllllllllllIllIIlllIIIIIllIl.withProperty(BlockOldLog.AXIS_PROP, EnumAxis.X);
                break;
            }
            case 8: {
                lllllllllllllllIllIIlllIIIIIllIl = lllllllllllllllIllIIlllIIIIIllIl.withProperty(BlockOldLog.AXIS_PROP, EnumAxis.Z);
                break;
            }
            default: {
                lllllllllllllllIllIIlllIIIIIllIl = lllllllllllllllIllIIlllIIIIIllIl.withProperty(BlockOldLog.AXIS_PROP, EnumAxis.NONE);
                break;
            }
        }
        return lllllllllllllllIllIIlllIIIIIllIl;
    }
    
    @Override
    public int damageDropped(final IBlockState lllllllllllllllIllIIllIlllllIlII) {
        return ((BlockPlanks.EnumType)lllllllllllllllIllIIllIlllllIlII.getValue(BlockOldLog.VARIANT_PROP)).func_176839_a();
    }
    
    public BlockOldLog() {
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockOldLog.VARIANT_PROP, BlockPlanks.EnumType.OAK).withProperty(BlockOldLog.AXIS_PROP, EnumAxis.Y));
    }
    
    @Override
    public void getSubBlocks(final Item lllllllllllllllIllIIlllIIIIlIlII, final CreativeTabs lllllllllllllllIllIIlllIIIIlIllI, final List lllllllllllllllIllIIlllIIIIlIIll) {
        lllllllllllllllIllIIlllIIIIlIIll.add(new ItemStack(lllllllllllllllIllIIlllIIIIlIlII, 1, BlockPlanks.EnumType.OAK.func_176839_a()));
        lllllllllllllllIllIIlllIIIIlIIll.add(new ItemStack(lllllllllllllllIllIIlllIIIIlIlII, 1, BlockPlanks.EnumType.SPRUCE.func_176839_a()));
        lllllllllllllllIllIIlllIIIIlIIll.add(new ItemStack(lllllllllllllllIllIIlllIIIIlIlII, 1, BlockPlanks.EnumType.BIRCH.func_176839_a()));
        lllllllllllllllIllIIlllIIIIlIIll.add(new ItemStack(lllllllllllllllIllIIlllIIIIlIlII, 1, BlockPlanks.EnumType.JUNGLE.func_176839_a()));
    }
    
    @Override
    protected ItemStack createStackedBlock(final IBlockState lllllllllllllllIllIIllIlllllIlll) {
        return new ItemStack(Item.getItemFromBlock(this), 1, ((BlockPlanks.EnumType)lllllllllllllllIllIIllIlllllIlll.getValue(BlockOldLog.VARIANT_PROP)).func_176839_a());
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllIllIIlllIIIIIIlIl) {
        final byte lllllllllllllllIllIIlllIIIIIIlII = 0;
        int lllllllllllllllIllIIlllIIIIIIIll = lllllllllllllllIllIIlllIIIIIIlII | ((BlockPlanks.EnumType)lllllllllllllllIllIIlllIIIIIIlIl.getValue(BlockOldLog.VARIANT_PROP)).func_176839_a();
        switch (SwitchEnumAxis.field_180203_a[((EnumAxis)lllllllllllllllIllIIlllIIIIIIlIl.getValue(BlockOldLog.AXIS_PROP)).ordinal()]) {
            case 1: {
                lllllllllllllllIllIIlllIIIIIIIll |= 0x4;
                break;
            }
            case 2: {
                lllllllllllllllIllIIlllIIIIIIIll |= 0x8;
                break;
            }
            case 3: {
                lllllllllllllllIllIIlllIIIIIIIll |= 0xC;
                break;
            }
        }
        return lllllllllllllllIllIIlllIIIIIIIll;
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockOldLog.VARIANT_PROP, BlockOldLog.AXIS_PROP });
    }
    
    static {
        __OBFID = "CL_00000281";
        VARIANT_PROP = PropertyEnum.create("variant", BlockPlanks.EnumType.class, (Predicate)new Predicate() {
            public boolean func_180200_a(final BlockPlanks.EnumType lllllllllllllllIIllllIIIllIIlIIl) {
                return lllllllllllllllIIllllIIIllIIlIIl.func_176839_a() < 4;
            }
            
            public boolean apply(final Object lllllllllllllllIIllllIIIllIIIIll) {
                return this.func_180200_a((BlockPlanks.EnumType)lllllllllllllllIIllllIIIllIIIIll);
            }
            
            static {
                __OBFID = "CL_00002084";
            }
        });
    }
    
    static final class SwitchEnumAxis
    {
        static final /* synthetic */ int[] field_180203_a;
        
        static {
            __OBFID = "CL_00002083";
            field_180203_a = new int[EnumAxis.values().length];
            try {
                SwitchEnumAxis.field_180203_a[EnumAxis.X.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumAxis.field_180203_a[EnumAxis.Z.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumAxis.field_180203_a[EnumAxis.NONE.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
        }
    }
}
