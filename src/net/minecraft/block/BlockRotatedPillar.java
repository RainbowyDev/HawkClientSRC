package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.block.material.*;
import net.minecraft.util.*;

public abstract class BlockRotatedPillar extends Block
{
    protected BlockRotatedPillar(final Material lllllllllllllllIllIIIllllIIIIlll) {
        super(lllllllllllllllIllIIIllllIIIIlll);
    }
    
    static {
        __OBFID = "CL_00000302";
        field_176298_M = PropertyEnum.create("axis", EnumFacing.Axis.class);
    }
}
