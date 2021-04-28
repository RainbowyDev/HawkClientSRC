package net.minecraft.util;

import java.util.*;
import com.google.common.base.*;
import com.google.common.collect.*;

public class ObjectIntIdentityMap implements IObjectIntIterable
{
    private final /* synthetic */ IdentityHashMap field_148749_a;
    private final /* synthetic */ List field_148748_b;
    
    @Override
    public Iterator iterator() {
        return (Iterator)Iterators.filter((Iterator)this.field_148748_b.iterator(), Predicates.notNull());
    }
    
    public List getObjectList() {
        return this.field_148748_b;
    }
    
    public void put(final Object lllllllllllllllIllIIIlIlIlIlIIII, final int lllllllllllllllIllIIIlIlIlIIllll) {
        this.field_148749_a.put(lllllllllllllllIllIIIlIlIlIlIIII, lllllllllllllllIllIIIlIlIlIIllll);
        while (this.field_148748_b.size() <= lllllllllllllllIllIIIlIlIlIIllll) {
            this.field_148748_b.add(null);
        }
        this.field_148748_b.set(lllllllllllllllIllIIIlIlIlIIllll, lllllllllllllllIllIIIlIlIlIlIIII);
    }
    
    static {
        __OBFID = "CL_00001203";
    }
    
    public ObjectIntIdentityMap() {
        this.field_148749_a = new IdentityHashMap(512);
        this.field_148748_b = Lists.newArrayList();
    }
    
    public int get(final Object lllllllllllllllIllIIIlIlIlIIIlII) {
        final Integer lllllllllllllllIllIIIlIlIlIIIllI = this.field_148749_a.get(lllllllllllllllIllIIIlIlIlIIIlII);
        return (lllllllllllllllIllIIIlIlIlIIIllI == null) ? -1 : lllllllllllllllIllIIIlIlIlIIIllI;
    }
    
    public final Object getByValue(final int lllllllllllllllIllIIIlIlIIllllll) {
        return (lllllllllllllllIllIIIlIlIIllllll >= 0 && lllllllllllllllIllIIIlIlIIllllll < this.field_148748_b.size()) ? this.field_148748_b.get(lllllllllllllllIllIIIlIlIIllllll) : null;
    }
}
