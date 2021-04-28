package net.minecraft.block.properties;

import net.minecraft.util.*;
import com.google.common.collect.*;
import java.util.*;
import com.google.common.base.*;

public class PropertyDirection extends PropertyEnum
{
    static {
        __OBFID = "CL_00002016";
    }
    
    public static PropertyDirection create(final String lllllllllllllllIlIIIlIlIIIIllIlI, final Predicate lllllllllllllllIlIIIlIlIIIIllIIl) {
        return create(lllllllllllllllIlIIIlIlIIIIllIlI, Collections2.filter((Collection)Lists.newArrayList((Object[])EnumFacing.values()), lllllllllllllllIlIIIlIlIIIIllIIl));
    }
    
    public static PropertyDirection create(final String lllllllllllllllIlIIIlIlIIIlIIIII) {
        return create(lllllllllllllllIlIIIlIlIIIlIIIII, Predicates.alwaysTrue());
    }
    
    protected PropertyDirection(final String lllllllllllllllIlIIIlIlIIIlIIIll, final Collection lllllllllllllllIlIIIlIlIIIlIIlIl) {
        super(lllllllllllllllIlIIIlIlIIIlIIIll, EnumFacing.class, lllllllllllllllIlIIIlIlIIIlIIlIl);
    }
    
    public static PropertyDirection create(final String lllllllllllllllIlIIIlIlIIIIlIllI, final Collection lllllllllllllllIlIIIlIlIIIIlIlIl) {
        return new PropertyDirection(lllllllllllllllIlIIIlIlIIIIlIllI, lllllllllllllllIlIIIlIlIIIIlIlIl);
    }
}
