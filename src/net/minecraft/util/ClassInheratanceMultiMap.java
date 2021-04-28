package net.minecraft.util;

import org.apache.commons.lang3.*;
import java.util.*;
import com.google.common.collect.*;

public class ClassInheratanceMultiMap extends AbstractSet
{
    private final /* synthetic */ Class field_180217_c;
    private final /* synthetic */ Set field_180216_b;
    private final /* synthetic */ Multimap field_180218_a;
    
    @Override
    public int size() {
        return this.field_180218_a.get((Object)this.field_180217_c).size();
    }
    
    public ClassInheratanceMultiMap(final Class llllllllllllllllIlIlIllllllIIlll) {
        this.field_180218_a = (Multimap)HashMultimap.create();
        this.field_180216_b = Sets.newIdentityHashSet();
        this.field_180217_c = llllllllllllllllIlIlIllllllIIlll;
        this.field_180216_b.add(llllllllllllllllIlIlIllllllIIlll);
    }
    
    static {
        __OBFID = "CL_00002266";
    }
    
    protected Class func_180212_a(final Class llllllllllllllllIlIlIllllIlllIlI, final boolean llllllllllllllllIlIlIllllIlllllI) {
        for (final Class llllllllllllllllIlIlIllllIllllII : ClassUtils.hierarchy(llllllllllllllllIlIlIllllIlllIlI, ClassUtils.Interfaces.INCLUDE)) {
            if (this.field_180216_b.contains(llllllllllllllllIlIlIllllIllllII)) {
                if (llllllllllllllllIlIlIllllIllllII == this.field_180217_c && llllllllllllllllIlIlIllllIlllllI) {
                    this.func_180213_a(llllllllllllllllIlIlIllllIlllIlI);
                }
                return llllllllllllllllIlIlIllllIllllII;
            }
        }
        throw new IllegalArgumentException(String.valueOf(new StringBuilder("Don't know how to search for ").append(llllllllllllllllIlIlIllllIlllIlI)));
    }
    
    @Override
    public Iterator iterator() {
        final Iterator llllllllllllllllIlIlIllllIIIllll = this.field_180218_a.get((Object)this.field_180217_c).iterator();
        return (Iterator)new AbstractIterator() {
            protected Object computeNext() {
                return llllllllllllllllIlIlIllllIIIllll.hasNext() ? llllllllllllllllIlIlIllllIIIllll.next() : this.endOfData();
            }
            
            static {
                __OBFID = "CL_00002264";
            }
        };
    }
    
    @Override
    public boolean add(final Object llllllllllllllllIlIlIllllIllIIIl) {
        for (final Class llllllllllllllllIlIlIllllIlIllll : this.field_180216_b) {
            if (llllllllllllllllIlIlIllllIlIllll.isAssignableFrom(llllllllllllllllIlIlIllllIllIIIl.getClass())) {
                this.field_180218_a.put((Object)llllllllllllllllIlIlIllllIlIllll, llllllllllllllllIlIlIllllIllIIIl);
            }
        }
        return true;
    }
    
    public void func_180213_a(final Class llllllllllllllllIlIlIlllllIlIIlI) {
        for (final Object llllllllllllllllIlIlIlllllIlIlIl : this.field_180218_a.get((Object)this.func_180212_a(llllllllllllllllIlIlIlllllIlIIlI, false))) {
            if (llllllllllllllllIlIlIlllllIlIIlI.isAssignableFrom(llllllllllllllllIlIlIlllllIlIlIl.getClass())) {
                this.field_180218_a.put((Object)llllllllllllllllIlIlIlllllIlIIlI, llllllllllllllllIlIlIlllllIlIlIl);
            }
        }
        this.field_180216_b.add(llllllllllllllllIlIlIlllllIlIIlI);
    }
    
    public Iterable func_180215_b(final Class llllllllllllllllIlIlIllllIIlIlIl) {
        return new Iterable() {
            static {
                __OBFID = "CL_00002265";
            }
            
            @Override
            public Iterator iterator() {
                final Iterator llllllllllllllIIIIIllIlIlIllIIll = ClassInheratanceMultiMap.this.field_180218_a.get((Object)ClassInheratanceMultiMap.this.func_180212_a(llllllllllllllllIlIlIllllIIlIlIl, true)).iterator();
                return (Iterator)Iterators.filter(llllllllllllllIIIIIllIlIlIllIIll, llllllllllllllllIlIlIllllIIlIlIl);
            }
        };
    }
    
    @Override
    public boolean remove(final Object llllllllllllllllIlIlIllllIIlllIl) {
        final Object llllllllllllllllIlIlIllllIlIIIlI = llllllllllllllllIlIlIllllIIlllIl;
        boolean llllllllllllllllIlIlIllllIlIIIIl = false;
        for (final Class llllllllllllllllIlIlIllllIIlllll : this.field_180216_b) {
            if (llllllllllllllllIlIlIllllIIlllll.isAssignableFrom(llllllllllllllllIlIlIllllIlIIIlI.getClass())) {
                llllllllllllllllIlIlIllllIlIIIIl |= this.field_180218_a.remove((Object)llllllllllllllllIlIlIllllIIlllll, llllllllllllllllIlIlIllllIlIIIlI);
            }
        }
        return llllllllllllllllIlIlIllllIlIIIIl;
    }
}
