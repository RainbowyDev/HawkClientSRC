package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;
import com.google.common.base.*;

public class BlockRailPowered extends BlockRailBase
{
    public static final /* synthetic */ PropertyBool field_176569_M;
    public static final /* synthetic */ PropertyEnum field_176568_b;
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIlllIlIlIIIlllllIl) {
        return this.getDefaultState().withProperty(BlockRailPowered.field_176568_b, EnumRailDirection.func_177016_a(llllllllllllllIlllIlIlIIIlllllIl & 0x7)).withProperty(BlockRailPowered.field_176569_M, (llllllllllllllIlllIlIlIIIlllllIl & 0x8) > 0);
    }
    
    @Override
    protected void func_176561_b(final World llllllllllllllIlllIlIlIIlIIIIllI, final BlockPos llllllllllllllIlllIlIlIIlIIIIlIl, final IBlockState llllllllllllllIlllIlIlIIlIIIlIll, final Block llllllllllllllIlllIlIlIIlIIIlIlI) {
        final boolean llllllllllllllIlllIlIlIIlIIIlIIl = (boolean)llllllllllllllIlllIlIlIIlIIIlIll.getValue(BlockRailPowered.field_176569_M);
        final boolean llllllllllllllIlllIlIlIIlIIIlIII = llllllllllllllIlllIlIlIIlIIIIllI.isBlockPowered(llllllllllllllIlllIlIlIIlIIIIlIl) || this.func_176566_a(llllllllllllllIlllIlIlIIlIIIIllI, llllllllllllllIlllIlIlIIlIIIIlIl, llllllllllllllIlllIlIlIIlIIIlIll, true, 0) || this.func_176566_a(llllllllllllllIlllIlIlIIlIIIIllI, llllllllllllllIlllIlIlIIlIIIIlIl, llllllllllllllIlllIlIlIIlIIIlIll, false, 0);
        if (llllllllllllllIlllIlIlIIlIIIlIII != llllllllllllllIlllIlIlIIlIIIlIIl) {
            llllllllllllllIlllIlIlIIlIIIIllI.setBlockState(llllllllllllllIlllIlIlIIlIIIIlIl, llllllllllllllIlllIlIlIIlIIIlIll.withProperty(BlockRailPowered.field_176569_M, llllllllllllllIlllIlIlIIlIIIlIII), 3);
            llllllllllllllIlllIlIlIIlIIIIllI.notifyNeighborsOfStateChange(llllllllllllllIlllIlIlIIlIIIIlIl.offsetDown(), this);
            if (((EnumRailDirection)llllllllllllllIlllIlIlIIlIIIlIll.getValue(BlockRailPowered.field_176568_b)).func_177018_c()) {
                llllllllllllllIlllIlIlIIlIIIIllI.notifyNeighborsOfStateChange(llllllllllllllIlllIlIlIIlIIIIlIl.offsetUp(), this);
            }
        }
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockRailPowered.field_176568_b, BlockRailPowered.field_176569_M });
    }
    
    protected BlockRailPowered() {
        super(true);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockRailPowered.field_176568_b, EnumRailDirection.NORTH_SOUTH).withProperty(BlockRailPowered.field_176569_M, false));
    }
    
    protected boolean func_176566_a(final World llllllllllllllIlllIlIlIIllIlIllI, final BlockPos llllllllllllllIlllIlIlIIllIlIlII, final IBlockState llllllllllllllIlllIlIlIIllIIIIll, final boolean llllllllllllllIlllIlIlIIllIIIIIl, final int llllllllllllllIlllIlIlIIllIIllll) {
        if (llllllllllllllIlllIlIlIIllIIllll >= 8) {
            return false;
        }
        int llllllllllllllIlllIlIlIIllIIlllI = llllllllllllllIlllIlIlIIllIlIlII.getX();
        int llllllllllllllIlllIlIlIIllIIllII = llllllllllllllIlllIlIlIIllIlIlII.getY();
        int llllllllllllllIlllIlIlIIllIIlIll = llllllllllllllIlllIlIlIIllIlIlII.getZ();
        boolean llllllllllllllIlllIlIlIIllIIlIIl = true;
        EnumRailDirection llllllllllllllIlllIlIlIIllIIIlll = (EnumRailDirection)llllllllllllllIlllIlIlIIllIIIIll.getValue(BlockRailPowered.field_176568_b);
        switch (SwitchEnumRailDirection.field_180121_a[llllllllllllllIlllIlIlIIllIIIlll.ordinal()]) {
            case 1: {
                if (llllllllllllllIlllIlIlIIllIIIIIl) {
                    ++llllllllllllllIlllIlIlIIllIIlIll;
                    break;
                }
                --llllllllllllllIlllIlIlIIllIIlIll;
                break;
            }
            case 2: {
                if (llllllllllllllIlllIlIlIIllIIIIIl) {
                    --llllllllllllllIlllIlIlIIllIIlllI;
                    break;
                }
                ++llllllllllllllIlllIlIlIIllIIlllI;
                break;
            }
            case 3: {
                if (llllllllllllllIlllIlIlIIllIIIIIl) {
                    --llllllllllllllIlllIlIlIIllIIlllI;
                }
                else {
                    ++llllllllllllllIlllIlIlIIllIIlllI;
                    ++llllllllllllllIlllIlIlIIllIIllII;
                    llllllllllllllIlllIlIlIIllIIlIIl = false;
                }
                llllllllllllllIlllIlIlIIllIIIlll = EnumRailDirection.EAST_WEST;
                break;
            }
            case 4: {
                if (llllllllllllllIlllIlIlIIllIIIIIl) {
                    --llllllllllllllIlllIlIlIIllIIlllI;
                    ++llllllllllllllIlllIlIlIIllIIllII;
                    llllllllllllllIlllIlIlIIllIIlIIl = false;
                }
                else {
                    ++llllllllllllllIlllIlIlIIllIIlllI;
                }
                llllllllllllllIlllIlIlIIllIIIlll = EnumRailDirection.EAST_WEST;
                break;
            }
            case 5: {
                if (llllllllllllllIlllIlIlIIllIIIIIl) {
                    ++llllllllllllllIlllIlIlIIllIIlIll;
                }
                else {
                    --llllllllllllllIlllIlIlIIllIIlIll;
                    ++llllllllllllllIlllIlIlIIllIIllII;
                    llllllllllllllIlllIlIlIIllIIlIIl = false;
                }
                llllllllllllllIlllIlIlIIllIIIlll = EnumRailDirection.NORTH_SOUTH;
                break;
            }
            case 6: {
                if (llllllllllllllIlllIlIlIIllIIIIIl) {
                    ++llllllllllllllIlllIlIlIIllIIlIll;
                    ++llllllllllllllIlllIlIlIIllIIllII;
                    llllllllllllllIlllIlIlIIllIIlIIl = false;
                }
                else {
                    --llllllllllllllIlllIlIlIIllIIlIll;
                }
                llllllllllllllIlllIlIlIIllIIIlll = EnumRailDirection.NORTH_SOUTH;
                break;
            }
        }
        return this.func_176567_a(llllllllllllllIlllIlIlIIllIlIllI, new BlockPos(llllllllllllllIlllIlIlIIllIIlllI, llllllllllllllIlllIlIlIIllIIllII, llllllllllllllIlllIlIlIIllIIlIll), llllllllllllllIlllIlIlIIllIIIIIl, llllllllllllllIlllIlIlIIllIIllll, llllllllllllllIlllIlIlIIllIIIlll) || (llllllllllllllIlllIlIlIIllIIlIIl && this.func_176567_a(llllllllllllllIlllIlIlIIllIlIllI, new BlockPos(llllllllllllllIlllIlIlIIllIIlllI, llllllllllllllIlllIlIlIIllIIllII - 1, llllllllllllllIlllIlIlIIllIIlIll), llllllllllllllIlllIlIlIIllIIIIIl, llllllllllllllIlllIlIlIIllIIllll, llllllllllllllIlllIlIlIIllIIIlll));
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIlllIlIlIIIlllIIll) {
        final byte llllllllllllllIlllIlIlIIIlllIlIl = 0;
        int llllllllllllllIlllIlIlIIIlllIlII = llllllllllllllIlllIlIlIIIlllIlIl | ((EnumRailDirection)llllllllllllllIlllIlIlIIIlllIIll.getValue(BlockRailPowered.field_176568_b)).func_177015_a();
        if (llllllllllllllIlllIlIlIIIlllIIll.getValue(BlockRailPowered.field_176569_M)) {
            llllllllllllllIlllIlIlIIIlllIlII |= 0x8;
        }
        return llllllllllllllIlllIlIlIIIlllIlII;
    }
    
    protected boolean func_176567_a(final World llllllllllllllIlllIlIlIIlIIllIll, final BlockPos llllllllllllllIlllIlIlIIlIlIIIlI, final boolean llllllllllllllIlllIlIlIIlIIllIIl, final int llllllllllllllIlllIlIlIIlIIllIII, final EnumRailDirection llllllllllllllIlllIlIlIIlIIlIlll) {
        final IBlockState llllllllllllllIlllIlIlIIlIIllllI = llllllllllllllIlllIlIlIIlIIllIll.getBlockState(llllllllllllllIlllIlIlIIlIlIIIlI);
        if (llllllllllllllIlllIlIlIIlIIllllI.getBlock() != this) {
            return false;
        }
        final EnumRailDirection llllllllllllllIlllIlIlIIlIIlllIl = (EnumRailDirection)llllllllllllllIlllIlIlIIlIIllllI.getValue(BlockRailPowered.field_176568_b);
        return (llllllllllllllIlllIlIlIIlIIlIlll != EnumRailDirection.EAST_WEST || (llllllllllllllIlllIlIlIIlIIlllIl != EnumRailDirection.NORTH_SOUTH && llllllllllllllIlllIlIlIIlIIlllIl != EnumRailDirection.ASCENDING_NORTH && llllllllllllllIlllIlIlIIlIIlllIl != EnumRailDirection.ASCENDING_SOUTH)) && (llllllllllllllIlllIlIlIIlIIlIlll != EnumRailDirection.NORTH_SOUTH || (llllllllllllllIlllIlIlIIlIIlllIl != EnumRailDirection.EAST_WEST && llllllllllllllIlllIlIlIIlIIlllIl != EnumRailDirection.ASCENDING_EAST && llllllllllllllIlllIlIlIIlIIlllIl != EnumRailDirection.ASCENDING_WEST)) && (boolean)llllllllllllllIlllIlIlIIlIIllllI.getValue(BlockRailPowered.field_176569_M) && (llllllllllllllIlllIlIlIIlIIllIll.isBlockPowered(llllllllllllllIlllIlIlIIlIlIIIlI) || this.func_176566_a(llllllllllllllIlllIlIlIIlIIllIll, llllllllllllllIlllIlIlIIlIlIIIlI, llllllllllllllIlllIlIlIIlIIllllI, llllllllllllllIlllIlIlIIlIIllIIl, llllllllllllllIlllIlIlIIlIIllIII + 1));
    }
    
    static {
        __OBFID = "CL_00000288";
        field_176568_b = PropertyEnum.create("shape", EnumRailDirection.class, (Predicate)new Predicate() {
            public boolean apply(final Object llllllllllllllllIlllllIlIllIlIlI) {
                return this.func_180133_a((EnumRailDirection)llllllllllllllllIlllllIlIllIlIlI);
            }
            
            public boolean func_180133_a(final EnumRailDirection llllllllllllllllIlllllIlIlllIIIl) {
                return llllllllllllllllIlllllIlIlllIIIl != EnumRailDirection.NORTH_EAST && llllllllllllllllIlllllIlIlllIIIl != EnumRailDirection.NORTH_WEST && llllllllllllllllIlllllIlIlllIIIl != EnumRailDirection.SOUTH_EAST && llllllllllllllllIlllllIlIlllIIIl != EnumRailDirection.SOUTH_WEST;
            }
            
            static {
                __OBFID = "CL_00002080";
            }
        });
        field_176569_M = PropertyBool.create("powered");
    }
    
    @Override
    public IProperty func_176560_l() {
        return BlockRailPowered.field_176568_b;
    }
    
    static final class SwitchEnumRailDirection
    {
        static final /* synthetic */ int[] field_180121_a;
        
        static {
            __OBFID = "CL_00002079";
            field_180121_a = new int[EnumRailDirection.values().length];
            try {
                SwitchEnumRailDirection.field_180121_a[EnumRailDirection.NORTH_SOUTH.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumRailDirection.field_180121_a[EnumRailDirection.EAST_WEST.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumRailDirection.field_180121_a[EnumRailDirection.ASCENDING_EAST.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchEnumRailDirection.field_180121_a[EnumRailDirection.ASCENDING_WEST.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                SwitchEnumRailDirection.field_180121_a[EnumRailDirection.ASCENDING_NORTH.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                SwitchEnumRailDirection.field_180121_a[EnumRailDirection.ASCENDING_SOUTH.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
        }
    }
}
