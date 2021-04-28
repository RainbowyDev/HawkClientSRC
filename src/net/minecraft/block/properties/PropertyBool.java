package net.minecraft.block.properties;

import com.google.common.collect.*;
import java.util.*;

public class PropertyBool extends PropertyHelper
{
    private final /* synthetic */ ImmutableSet allowedValues;
    
    @Override
    public Collection getAllowedValues() {
        return (Collection)this.allowedValues;
    }
    
    public static PropertyBool create(final String llllllllllllllIlIIIllIllIIIIlIIl) {
        return new PropertyBool(llllllllllllllIlIIIllIllIIIIlIIl);
    }
    
    protected PropertyBool(final String llllllllllllllIlIIIllIllIIIIlllI) {
        super(llllllllllllllIlIIIllIllIIIIlllI, Boolean.class);
        this.allowedValues = ImmutableSet.of((Object)true, (Object)false);
    }
    
    public String getName0(final Boolean llllllllllllllIlIIIllIllIIIIIlII) {
        return llllllllllllllIlIIIllIllIIIIIlII.toString();
    }
    
    @Override
    public String getName(final Comparable llllllllllllllIlIIIllIlIlllllllI) {
        return this.getName0((Boolean)llllllllllllllIlIIIllIlIlllllllI);
    }
    
    static {
        __OBFID = "CL_00002017";
    }
}
