package net.minecraft.block;

import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.block.material.*;
import net.minecraft.block.properties.*;
import java.util.*;
import net.minecraft.entity.*;
import net.minecraft.creativetab.*;
import net.minecraft.util.*;

public abstract class BlockLog extends BlockRotatedPillar
{
    public static final /* synthetic */ PropertyEnum AXIS_PROP;
    
    static {
        __OBFID = "CL_00000266";
        AXIS_PROP = PropertyEnum.create("axis", EnumAxis.class);
    }
    
    @Override
    public void breakBlock(final World lllllllllllllllIlIlIIlIIIllIIllI, final BlockPos lllllllllllllllIlIlIIlIIIllIllIl, final IBlockState lllllllllllllllIlIlIIlIIIllIllII) {
        final byte lllllllllllllllIlIlIIlIIIllIlIll = 4;
        final int lllllllllllllllIlIlIIlIIIllIlIlI = lllllllllllllllIlIlIIlIIIllIlIll + 1;
        if (lllllllllllllllIlIlIIlIIIllIIllI.isAreaLoaded(lllllllllllllllIlIlIIlIIIllIllIl.add(-lllllllllllllllIlIlIIlIIIllIlIlI, -lllllllllllllllIlIlIIlIIIllIlIlI, -lllllllllllllllIlIlIIlIIIllIlIlI), lllllllllllllllIlIlIIlIIIllIllIl.add(lllllllllllllllIlIlIIlIIIllIlIlI, lllllllllllllllIlIlIIlIIIllIlIlI, lllllllllllllllIlIlIIlIIIllIlIlI))) {
            for (final BlockPos lllllllllllllllIlIlIIlIIIllIlIII : BlockPos.getAllInBox(lllllllllllllllIlIlIIlIIIllIllIl.add(-lllllllllllllllIlIlIIlIIIllIlIll, -lllllllllllllllIlIlIIlIIIllIlIll, -lllllllllllllllIlIlIIlIIIllIlIll), lllllllllllllllIlIlIIlIIIllIllIl.add(lllllllllllllllIlIlIIlIIIllIlIll, lllllllllllllllIlIlIIlIIIllIlIll, lllllllllllllllIlIlIIlIIIllIlIll))) {
                final IBlockState lllllllllllllllIlIlIIlIIIllIIlll = lllllllllllllllIlIlIIlIIIllIIllI.getBlockState(lllllllllllllllIlIlIIlIIIllIlIII);
                if (lllllllllllllllIlIlIIlIIIllIIlll.getBlock().getMaterial() == Material.leaves && !(boolean)lllllllllllllllIlIlIIlIIIllIIlll.getValue(BlockLeaves.field_176236_b)) {
                    lllllllllllllllIlIlIIlIIIllIIllI.setBlockState(lllllllllllllllIlIlIIlIIIllIlIII, lllllllllllllllIlIlIIlIIIllIIlll.withProperty(BlockLeaves.field_176236_b, true), 4);
                }
            }
        }
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllllllIlIlIIlIIIlIIllII, final BlockPos lllllllllllllllIlIlIIlIIIlIIlIll, final EnumFacing lllllllllllllllIlIlIIlIIIlIIlIlI, final float lllllllllllllllIlIlIIlIIIlIIlIIl, final float lllllllllllllllIlIlIIlIIIlIIlIII, final float lllllllllllllllIlIlIIlIIIlIlIIII, final int lllllllllllllllIlIlIIlIIIlIIIllI, final EntityLivingBase lllllllllllllllIlIlIIlIIIlIIIlIl) {
        return super.onBlockPlaced(lllllllllllllllIlIlIIlIIIlIIllII, lllllllllllllllIlIlIIlIIIlIIlIll, lllllllllllllllIlIlIIlIIIlIIlIlI, lllllllllllllllIlIlIIlIIIlIIlIIl, lllllllllllllllIlIlIIlIIIlIIlIII, lllllllllllllllIlIlIIlIIIlIlIIII, lllllllllllllllIlIlIIlIIIlIIIllI, lllllllllllllllIlIlIIlIIIlIIIlIl).withProperty(BlockLog.AXIS_PROP, EnumAxis.func_176870_a(lllllllllllllllIlIlIIlIIIlIIlIlI.getAxis()));
    }
    
    public BlockLog() {
        super(Material.wood);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(2.0f);
        this.setStepSound(BlockLog.soundTypeWood);
    }
    
    public enum EnumAxis implements IStringSerializable
    {
        NONE("NONE", 3, "NONE", 3, "none"), 
        X("X", 0, "X", 0, "x");
        
        private final /* synthetic */ String field_176874_e;
        
        Y("Y", 1, "Y", 1, "y"), 
        Z("Z", 2, "Z", 2, "z");
        
        @Override
        public String toString() {
            return this.field_176874_e;
        }
        
        public static EnumAxis func_176870_a(final EnumFacing.Axis llIIllIlIlllIl) {
            switch (SwitchAxis.field_180167_a[llIIllIlIlllIl.ordinal()]) {
                case 1: {
                    return EnumAxis.X;
                }
                case 2: {
                    return EnumAxis.Y;
                }
                case 3: {
                    return EnumAxis.Z;
                }
                default: {
                    return EnumAxis.NONE;
                }
            }
        }
        
        @Override
        public String getName() {
            return this.field_176874_e;
        }
        
        static {
            __OBFID = "CL_00002100";
        }
        
        private EnumAxis(final String llIIllIllIIlII, final int llIIllIllIIIll, final String llIIllIllIlIII, final int llIIllIllIIlll, final String llIIllIllIIllI) {
            this.field_176874_e = llIIllIllIIllI;
        }
    }
    
    static final class SwitchAxis
    {
        static final /* synthetic */ int[] field_180167_a;
        
        static {
            __OBFID = "CL_00002101";
            field_180167_a = new int[EnumFacing.Axis.values().length];
            try {
                SwitchAxis.field_180167_a[EnumFacing.Axis.X.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchAxis.field_180167_a[EnumFacing.Axis.Y.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchAxis.field_180167_a[EnumFacing.Axis.Z.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
        }
    }
}
