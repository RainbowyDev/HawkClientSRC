package net.minecraft.block;

import net.minecraft.block.material.*;
import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.block.state.*;

public class BlockPressurePlate extends BlockBasePressurePlate
{
    private final /* synthetic */ Sensitivity sensitivity;
    public static final /* synthetic */ PropertyBool POWERED;
    
    protected BlockPressurePlate(final Material lllllllllllllllIlIIlllIIIlIllIII, final Sensitivity lllllllllllllllIlIIlllIIIlIlIlll) {
        super(lllllllllllllllIlIIlllIIIlIllIII);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockPressurePlate.POWERED, false));
        this.sensitivity = lllllllllllllllIlIIlllIIIlIlIlll;
    }
    
    @Override
    protected int computeRedstoneStrength(final World lllllllllllllllIlIIlllIIIIllIlll, final BlockPos lllllllllllllllIlIIlllIIIIllllll) {
        final AxisAlignedBB lllllllllllllllIlIIlllIIIIlllllI = this.getSensitiveAABB(lllllllllllllllIlIIlllIIIIllllll);
        switch (SwitchSensitivity.SENSITIVITY_ARRAY[this.sensitivity.ordinal()]) {
            case 1: {
                final List lllllllllllllllIlIIlllIIIIllllIl = lllllllllllllllIlIIlllIIIIllIlll.getEntitiesWithinAABBExcludingEntity(null, lllllllllllllllIlIIlllIIIIlllllI);
                break;
            }
            case 2: {
                final List lllllllllllllllIlIIlllIIIIllllII = lllllllllllllllIlIIlllIIIIllIlll.getEntitiesWithinAABB(EntityLivingBase.class, lllllllllllllllIlIIlllIIIIlllllI);
                break;
            }
            default: {
                return 0;
            }
        }
        final List lllllllllllllllIlIIlllIIIIlllIll;
        if (!lllllllllllllllIlIIlllIIIIlllIll.isEmpty()) {
            for (final Entity lllllllllllllllIlIIlllIIIIlllIIl : lllllllllllllllIlIIlllIIIIlllIll) {
                if (!lllllllllllllllIlIIlllIIIIlllIIl.doesEntityNotTriggerPressurePlate()) {
                    return 15;
                }
            }
        }
        return 0;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllIlIIlllIIIIlIllII) {
        return this.getDefaultState().withProperty(BlockPressurePlate.POWERED, lllllllllllllllIlIIlllIIIIlIllII == 1);
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockPressurePlate.POWERED });
    }
    
    static {
        __OBFID = "CL_00000289";
        POWERED = PropertyBool.create("powered");
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllIlIIlllIIIIlIlIII) {
        return ((boolean)lllllllllllllllIlIIlllIIIIlIlIII.getValue(BlockPressurePlate.POWERED)) ? 1 : 0;
    }
    
    @Override
    protected IBlockState setRedstoneStrength(final IBlockState lllllllllllllllIlIIlllIIIlIIllII, final int lllllllllllllllIlIIlllIIIlIIlIll) {
        return lllllllllllllllIlIIlllIIIlIIllII.withProperty(BlockPressurePlate.POWERED, lllllllllllllllIlIIlllIIIlIIlIll > 0);
    }
    
    @Override
    protected int getRedstoneStrength(final IBlockState lllllllllllllllIlIIlllIIIlIlIIIl) {
        return lllllllllllllllIlIIlllIIIlIlIIIl.getValue(BlockPressurePlate.POWERED) ? 15 : 0;
    }
    
    public enum Sensitivity
    {
        MOBS("MOBS", 1, "MOBS", 1), 
        EVERYTHING("EVERYTHING", 0, "EVERYTHING", 0);
        
        static {
            __OBFID = "CL_00000290";
        }
        
        private Sensitivity(final String lIlIllIIIlIlIl, final int lIlIllIIIlIlII, final String lIlIllIIIllIII, final int lIlIllIIIlIlll) {
        }
    }
    
    static final class SwitchSensitivity
    {
        static final /* synthetic */ int[] SENSITIVITY_ARRAY;
        
        static {
            __OBFID = "CL_00002078";
            SENSITIVITY_ARRAY = new int[Sensitivity.values().length];
            try {
                SwitchSensitivity.SENSITIVITY_ARRAY[Sensitivity.EVERYTHING.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchSensitivity.SENSITIVITY_ARRAY[Sensitivity.MOBS.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
        }
    }
}
