package net.minecraft.block.properties;

import net.minecraft.util.*;
import java.util.*;
import com.google.common.base.*;
import com.google.common.collect.*;

public class PropertyEnum extends PropertyHelper
{
    private final /* synthetic */ ImmutableSet allowedValues;
    private final /* synthetic */ Map nameToValue;
    
    @Override
    public String getName(final Comparable llllllllllllllIlllIlllllIlIllIIl) {
        return this.getName((Enum)llllllllllllllIlllIlllllIlIllIIl);
    }
    
    public String getName(final Enum llllllllllllllIlllIllllllIIllIlI) {
        return ((IStringSerializable)llllllllllllllIlllIllllllIIllIlI).getName();
    }
    
    protected PropertyEnum(final String llllllllllllllIlllIllllllIllIIlI, final Class llllllllllllllIlllIllllllIlllIII, final Collection llllllllllllllIlllIllllllIlIllll) {
        super(llllllllllllllIlllIllllllIllIIlI, llllllllllllllIlllIllllllIlllIII);
        this.nameToValue = Maps.newHashMap();
        this.allowedValues = ImmutableSet.copyOf(llllllllllllllIlllIllllllIlIllll);
        for (final Enum llllllllllllllIlllIllllllIllIlIl : llllllllllllllIlllIllllllIlIllll) {
            final String llllllllllllllIlllIllllllIllIlII = ((IStringSerializable)llllllllllllllIlllIllllllIllIlIl).getName();
            if (this.nameToValue.containsKey(llllllllllllllIlllIllllllIllIlII)) {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder("Multiple values have the same name '").append(llllllllllllllIlllIllllllIllIlII).append("'")));
            }
            this.nameToValue.put(llllllllllllllIlllIllllllIllIlII, llllllllllllllIlllIllllllIllIlIl);
        }
    }
    
    public static PropertyEnum create(final String llllllllllllllIlllIllllllIIlIlII, final Class llllllllllllllIlllIllllllIIlIIll) {
        return create(llllllllllllllIlllIllllllIIlIlII, llllllllllllllIlllIllllllIIlIIll, Predicates.alwaysTrue());
    }
    
    @Override
    public Collection getAllowedValues() {
        return (Collection)this.allowedValues;
    }
    
    public static PropertyEnum create(final String llllllllllllllIlllIlllllIllIIlII, final Class llllllllllllllIlllIlllllIllIIllI, final Collection llllllllllllllIlllIlllllIllIIlIl) {
        return new PropertyEnum(llllllllllllllIlllIlllllIllIIlII, llllllllllllllIlllIlllllIllIIllI, llllllllllllllIlllIlllllIllIIlIl);
    }
    
    public static PropertyEnum create(final String llllllllllllllIlllIlllllIlllIlll, final Class llllllllllllllIlllIlllllIllIllll, final Enum... llllllllllllllIlllIlllllIllIllIl) {
        return create(llllllllllllllIlllIlllllIlllIlll, llllllllllllllIlllIlllllIllIllll, Lists.newArrayList((Object[])llllllllllllllIlllIlllllIllIllIl));
    }
    
    public static PropertyEnum create(final String llllllllllllllIlllIllllllIIIIlIl, final Class llllllllllllllIlllIllllllIIIlIIl, final Predicate llllllllllllllIlllIllllllIIIIIIl) {
        return create(llllllllllllllIlllIllllllIIIIlIl, llllllllllllllIlllIllllllIIIlIIl, Collections2.filter((Collection)Lists.newArrayList(llllllllllllllIlllIllllllIIIlIIl.getEnumConstants()), llllllllllllllIlllIllllllIIIIIIl));
    }
    
    static {
        __OBFID = "CL_00002015";
    }
}
