package net.minecraft.block.state.pattern;

import java.lang.reflect.*;
import com.google.common.collect.*;
import com.google.common.base.*;
import java.util.*;
import org.apache.commons.lang3.*;

public class FactoryBlockPattern
{
    private final /* synthetic */ Map field_177666_c;
    private static final /* synthetic */ Joiner field_177667_a;
    private final /* synthetic */ List field_177665_b;
    private /* synthetic */ int field_177663_d;
    private /* synthetic */ int field_177664_e;
    
    private Predicate[][][] func_177658_c() {
        this.func_177657_d();
        final Predicate[][][] llllllllllllllIIlIlIllIIlIlIIlll = (Predicate[][][])Array.newInstance(Predicate.class, this.field_177665_b.size(), this.field_177663_d, this.field_177664_e);
        for (int llllllllllllllIIlIlIllIIlIlIIllI = 0; llllllllllllllIIlIlIllIIlIlIIllI < this.field_177665_b.size(); ++llllllllllllllIIlIlIllIIlIlIIllI) {
            for (int llllllllllllllIIlIlIllIIlIlIIlIl = 0; llllllllllllllIIlIlIllIIlIlIIlIl < this.field_177663_d; ++llllllllllllllIIlIlIllIIlIlIIlIl) {
                for (int llllllllllllllIIlIlIllIIlIlIIlII = 0; llllllllllllllIIlIlIllIIlIlIIlII < this.field_177664_e; ++llllllllllllllIIlIlIllIIlIlIIlII) {
                    llllllllllllllIIlIlIllIIlIlIIlll[llllllllllllllIIlIlIllIIlIlIIllI][llllllllllllllIIlIlIllIIlIlIIlIl][llllllllllllllIIlIlIllIIlIlIIlII] = this.field_177666_c.get(((String[])this.field_177665_b.get(llllllllllllllIIlIlIllIIlIlIIllI))[llllllllllllllIIlIlIllIIlIlIIlIl].charAt(llllllllllllllIIlIlIllIIlIlIIlII));
                }
            }
        }
        return llllllllllllllIIlIlIllIIlIlIIlll;
    }
    
    public BlockPattern build() {
        return new BlockPattern(this.func_177658_c());
    }
    
    private FactoryBlockPattern() {
        this.field_177665_b = Lists.newArrayList();
        this.field_177666_c = Maps.newHashMap();
        this.field_177666_c.put(' ', Predicates.alwaysTrue());
    }
    
    private void func_177657_d() {
        final ArrayList llllllllllllllIIlIlIllIIlIIllIIl = Lists.newArrayList();
        for (final Map.Entry llllllllllllllIIlIlIllIIlIIlIlll : this.field_177666_c.entrySet()) {
            if (llllllllllllllIIlIlIllIIlIIlIlll.getValue() == null) {
                llllllllllllllIIlIlIllIIlIIllIIl.add(llllllllllllllIIlIlIllIIlIIlIlll.getKey());
            }
        }
        if (!llllllllllllllIIlIlIllIIlIIllIIl.isEmpty()) {
            throw new IllegalStateException(String.valueOf(new StringBuilder("Predicates for character(s) ").append(FactoryBlockPattern.field_177667_a.join((Iterable)llllllllllllllIIlIlIllIIlIIllIIl)).append(" are missing")));
        }
    }
    
    public FactoryBlockPattern where(final char llllllllllllllIIlIlIllIIlIllIIlI, final Predicate llllllllllllllIIlIlIllIIlIllIlII) {
        this.field_177666_c.put(llllllllllllllIIlIlIllIIlIllIIlI, llllllllllllllIIlIlIllIIlIllIlII);
        return this;
    }
    
    static {
        __OBFID = "CL_00002021";
        field_177667_a = Joiner.on(",");
    }
    
    public static FactoryBlockPattern start() {
        return new FactoryBlockPattern();
    }
    
    public FactoryBlockPattern aisle(final String... llllllllllllllIIlIlIllIIllIIIIlI) {
        if (ArrayUtils.isEmpty((Object[])llllllllllllllIIlIlIllIIllIIIIlI) || StringUtils.isEmpty((CharSequence)llllllllllllllIIlIlIllIIllIIIIlI[0])) {
            throw new IllegalArgumentException("Empty pattern for aisle");
        }
        if (this.field_177665_b.isEmpty()) {
            this.field_177663_d = llllllllllllllIIlIlIllIIllIIIIlI.length;
            this.field_177664_e = llllllllllllllIIlIlIllIIllIIIIlI[0].length();
        }
        if (llllllllllllllIIlIlIllIIllIIIIlI.length != this.field_177663_d) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Expected aisle with height of ").append(this.field_177663_d).append(", but was given one with a height of ").append(llllllllllllllIIlIlIllIIllIIIIlI.length).append(")")));
        }
        final String[] llllllllllllllIIlIlIllIIllIIlIll = llllllllllllllIIlIlIllIIllIIIIlI;
        for (int llllllllllllllIIlIlIllIIllIIlIlI = llllllllllllllIIlIlIllIIllIIIIlI.length, llllllllllllllIIlIlIllIIllIIlIIl = 0; llllllllllllllIIlIlIllIIllIIlIIl < llllllllllllllIIlIlIllIIllIIlIlI; ++llllllllllllllIIlIlIllIIllIIlIIl) {
            final String llllllllllllllIIlIlIllIIllIIlIII = llllllllllllllIIlIlIllIIllIIlIll[llllllllllllllIIlIlIllIIllIIlIIl];
            if (llllllllllllllIIlIlIllIIllIIlIII.length() != this.field_177664_e) {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder("Not all rows in the given aisle are the correct width (expected ").append(this.field_177664_e).append(", found one with ").append(llllllllllllllIIlIlIllIIllIIlIII.length()).append(")")));
            }
            for (final char llllllllllllllIIlIlIllIIllIIIlII : llllllllllllllIIlIlIllIIllIIlIII.toCharArray()) {
                if (!this.field_177666_c.containsKey(llllllllllllllIIlIlIllIIllIIIlII)) {
                    this.field_177666_c.put(llllllllllllllIIlIlIllIIllIIIlII, null);
                }
            }
        }
        this.field_177665_b.add(llllllllllllllIIlIlIllIIllIIIIlI);
        return this;
    }
}
