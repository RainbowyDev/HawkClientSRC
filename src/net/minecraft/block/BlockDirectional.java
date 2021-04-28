package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.block.material.*;
import net.minecraft.util.*;
import com.google.common.base.*;

public abstract class BlockDirectional extends Block
{
    protected BlockDirectional(final Material llllllllllllllllIIIIlIlIlIIIlIIl) {
        super(llllllllllllllllIIIIlIlIlIIIlIIl);
    }
    
    static {
        __OBFID = "CL_00000227";
        AGE = PropertyDirection.create("facing", (Predicate)EnumFacing.Plane.HORIZONTAL);
    }
}
