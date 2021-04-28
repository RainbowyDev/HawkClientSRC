package net.minecraft.block.properties;

import com.google.common.collect.*;
import java.util.*;

public class PropertyInteger extends PropertyHelper
{
    private final /* synthetic */ ImmutableSet allowedValues;
    
    @Override
    public String getName(final Comparable llllllllllllllIlIIIIllIIIllIIIIl) {
        return this.getName0((Integer)llllllllllllllIlIIIIllIIIllIIIIl);
    }
    
    @Override
    public int hashCode() {
        int llllllllllllllIlIIIIllIIIlllIllI = super.hashCode();
        llllllllllllllIlIIIIllIIIlllIllI = 31 * llllllllllllllIlIIIIllIIIlllIllI + this.allowedValues.hashCode();
        return llllllllllllllIlIIIIllIIIlllIllI;
    }
    
    @Override
    public boolean equals(final Object llllllllllllllIlIIIIllIIIllllIll) {
        if (this == llllllllllllllIlIIIIllIIIllllIll) {
            return true;
        }
        if (llllllllllllllIlIIIIllIIIllllIll == null || this.getClass() != llllllllllllllIlIIIIllIIIllllIll.getClass()) {
            return false;
        }
        if (!super.equals(llllllllllllllIlIIIIllIIIllllIll)) {
            return false;
        }
        final PropertyInteger llllllllllllllIlIIIIllIIIlllllIl = (PropertyInteger)llllllllllllllIlIIIIllIIIllllIll;
        return this.allowedValues.equals((Object)llllllllllllllIlIIIIllIIIlllllIl.allowedValues);
    }
    
    @Override
    public Collection getAllowedValues() {
        return (Collection)this.allowedValues;
    }
    
    protected PropertyInteger(final String llllllllllllllIlIIIIllIIlIIlIIII, final int llllllllllllllIlIIIIllIIlIIIllll, final int llllllllllllllIlIIIIllIIlIIIlIII) {
        super(llllllllllllllIlIIIIllIIlIIlIIII, Integer.class);
        if (llllllllllllllIlIIIIllIIlIIIllll < 0) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Min value of ").append(llllllllllllllIlIIIIllIIlIIlIIII).append(" must be 0 or greater")));
        }
        if (llllllllllllllIlIIIIllIIlIIIlIII <= llllllllllllllIlIIIIllIIlIIIllll) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Max value of ").append(llllllllllllllIlIIIIllIIlIIlIIII).append(" must be greater than min (").append(llllllllllllllIlIIIIllIIlIIIllll).append(")")));
        }
        final HashSet llllllllllllllIlIIIIllIIlIIIllIl = Sets.newHashSet();
        for (int llllllllllllllIlIIIIllIIlIIIllII = llllllllllllllIlIIIIllIIlIIIllll; llllllllllllllIlIIIIllIIlIIIllII <= llllllllllllllIlIIIIllIIlIIIlIII; ++llllllllllllllIlIIIIllIIlIIIllII) {
            llllllllllllllIlIIIIllIIlIIIllIl.add(llllllllllllllIlIIIIllIIlIIIllII);
        }
        this.allowedValues = ImmutableSet.copyOf((Collection)llllllllllllllIlIIIIllIIlIIIllIl);
    }
    
    static {
        __OBFID = "CL_00002014";
    }
    
    public static PropertyInteger create(final String llllllllllllllIlIIIIllIIIllIllIl, final int llllllllllllllIlIIIIllIIIllIllll, final int llllllllllllllIlIIIIllIIIllIlllI) {
        return new PropertyInteger(llllllllllllllIlIIIIllIIIllIllIl, llllllllllllllIlIIIIllIIIllIllll, llllllllllllllIlIIIIllIIIllIlllI);
    }
    
    public String getName0(final Integer llllllllllllllIlIIIIllIIIllIlIII) {
        return llllllllllllllIlIIIIllIIIllIlIII.toString();
    }
}
