package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.item.*;
import com.google.common.base.*;
import net.minecraft.block.state.*;

public class BlockNewLog extends BlockLog
{
    public static final /* synthetic */ PropertyEnum field_176300_b;
    
    @Override
    public int damageDropped(final IBlockState lllllllllllllllIlllIlllIllIlllIl) {
        return ((BlockPlanks.EnumType)lllllllllllllllIlllIlllIllIlllIl.getValue(BlockNewLog.field_176300_b)).func_176839_a() - 4;
    }
    
    @Override
    public void getSubBlocks(final Item lllllllllllllllIlllIlllIllllllIl, final CreativeTabs lllllllllllllllIlllIlllIllllllll, final List lllllllllllllllIlllIlllIlllllllI) {
        lllllllllllllllIlllIlllIlllllllI.add(new ItemStack(lllllllllllllllIlllIlllIllllllIl, 1, BlockPlanks.EnumType.ACACIA.func_176839_a() - 4));
        lllllllllllllllIlllIlllIlllllllI.add(new ItemStack(lllllllllllllllIlllIlllIllllllIl, 1, BlockPlanks.EnumType.DARK_OAK.func_176839_a() - 4));
    }
    
    public BlockNewLog() {
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockNewLog.field_176300_b, BlockPlanks.EnumType.ACACIA).withProperty(BlockNewLog.AXIS_PROP, EnumAxis.Y));
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllIlllIlllIlllIlllI) {
        final byte lllllllllllllllIlllIlllIlllIllIl = 0;
        int lllllllllllllllIlllIlllIlllIllII = lllllllllllllllIlllIlllIlllIllIl | ((BlockPlanks.EnumType)lllllllllllllllIlllIlllIlllIlllI.getValue(BlockNewLog.field_176300_b)).func_176839_a() - 4;
        switch (SwitchEnumAxis.field_180191_a[((EnumAxis)lllllllllllllllIlllIlllIlllIlllI.getValue(BlockNewLog.AXIS_PROP)).ordinal()]) {
            case 1: {
                lllllllllllllllIlllIlllIlllIllII |= 0x4;
                break;
            }
            case 2: {
                lllllllllllllllIlllIlllIlllIllII |= 0x8;
                break;
            }
            case 3: {
                lllllllllllllllIlllIlllIlllIllII |= 0xC;
                break;
            }
        }
        return lllllllllllllllIlllIlllIlllIllII;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllIlllIlllIllllIlll) {
        IBlockState lllllllllllllllIlllIlllIllllIllI = this.getDefaultState().withProperty(BlockNewLog.field_176300_b, BlockPlanks.EnumType.func_176837_a((lllllllllllllllIlllIlllIllllIlll & 0x3) + 4));
        switch (lllllllllllllllIlllIlllIllllIlll & 0xC) {
            case 0: {
                lllllllllllllllIlllIlllIllllIllI = lllllllllllllllIlllIlllIllllIllI.withProperty(BlockNewLog.AXIS_PROP, EnumAxis.Y);
                break;
            }
            case 4: {
                lllllllllllllllIlllIlllIllllIllI = lllllllllllllllIlllIlllIllllIllI.withProperty(BlockNewLog.AXIS_PROP, EnumAxis.X);
                break;
            }
            case 8: {
                lllllllllllllllIlllIlllIllllIllI = lllllllllllllllIlllIlllIllllIllI.withProperty(BlockNewLog.AXIS_PROP, EnumAxis.Z);
                break;
            }
            default: {
                lllllllllllllllIlllIlllIllllIllI = lllllllllllllllIlllIlllIllllIllI.withProperty(BlockNewLog.AXIS_PROP, EnumAxis.NONE);
                break;
            }
        }
        return lllllllllllllllIlllIlllIllllIllI;
    }
    
    @Override
    protected ItemStack createStackedBlock(final IBlockState lllllllllllllllIlllIlllIlllIIIlI) {
        return new ItemStack(Item.getItemFromBlock(this), 1, ((BlockPlanks.EnumType)lllllllllllllllIlllIlllIlllIIIlI.getValue(BlockNewLog.field_176300_b)).func_176839_a() - 4);
    }
    
    static {
        __OBFID = "CL_00000277";
        field_176300_b = PropertyEnum.create("variant", BlockPlanks.EnumType.class, (Predicate)new Predicate() {
            public boolean func_180194_a(final BlockPlanks.EnumType llllllllllllllIIlIlllIlIIIlllIII) {
                return llllllllllllllIIlIlllIlIIIlllIII.func_176839_a() >= 4;
            }
            
            public boolean apply(final Object llllllllllllllIIlIlllIlIIIllIIlI) {
                return this.func_180194_a((BlockPlanks.EnumType)llllllllllllllIIlIlllIlIIIllIIlI);
            }
            
            static {
                __OBFID = "CL_00002089";
            }
        });
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockNewLog.field_176300_b, BlockNewLog.AXIS_PROP });
    }
    
    static final class SwitchEnumAxis
    {
        static final /* synthetic */ int[] field_180191_a;
        
        static {
            __OBFID = "CL_00002088";
            field_180191_a = new int[EnumAxis.values().length];
            try {
                SwitchEnumAxis.field_180191_a[EnumAxis.X.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumAxis.field_180191_a[EnumAxis.Z.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumAxis.field_180191_a[EnumAxis.NONE.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
        }
    }
}
