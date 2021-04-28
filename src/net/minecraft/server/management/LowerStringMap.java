package net.minecraft.server.management;

import com.google.common.collect.*;
import java.util.*;

public class LowerStringMap implements Map
{
    private final /* synthetic */ Map internalMap;
    
    @Override
    public boolean containsKey(final Object llllllllllllllllIIlIIllllIIIlIlI) {
        return this.internalMap.containsKey(llllllllllllllllIIlIIllllIIIlIlI.toString().toLowerCase());
    }
    
    public LowerStringMap() {
        this.internalMap = Maps.newLinkedHashMap();
    }
    
    @Override
    public Collection values() {
        return this.internalMap.values();
    }
    
    @Override
    public boolean isEmpty() {
        return this.internalMap.isEmpty();
    }
    
    public Object put(final String llllllllllllllllIIlIIlllIlllIlII, final Object llllllllllllllllIIlIIlllIlllIllI) {
        return this.internalMap.put(llllllllllllllllIIlIIlllIlllIlII.toLowerCase(), llllllllllllllllIIlIIlllIlllIllI);
    }
    
    static {
        __OBFID = "CL_00001488";
    }
    
    @Override
    public void clear() {
        this.internalMap.clear();
    }
    
    @Override
    public Object put(final Object llllllllllllllllIIlIIlllIlIIllIl, final Object llllllllllllllllIIlIIlllIlIIllll) {
        return this.put((String)llllllllllllllllIIlIIlllIlIIllIl, llllllllllllllllIIlIIlllIlIIllll);
    }
    
    @Override
    public Object get(final Object llllllllllllllllIIlIIlllIlllllII) {
        return this.internalMap.get(llllllllllllllllIIlIIlllIlllllII.toString().toLowerCase());
    }
    
    @Override
    public Set keySet() {
        return this.internalMap.keySet();
    }
    
    @Override
    public void putAll(final Map llllllllllllllllIIlIIlllIllIIlll) {
        for (final Entry llllllllllllllllIIlIIlllIllIIlIl : llllllllllllllllIIlIIlllIllIIlll.entrySet()) {
            this.put(llllllllllllllllIIlIIlllIllIIlIl.getKey(), llllllllllllllllIIlIIlllIllIIlIl.getValue());
        }
    }
    
    @Override
    public boolean containsValue(final Object llllllllllllllllIIlIIllllIIIIIlI) {
        return this.internalMap.containsKey(llllllllllllllllIIlIIllllIIIIIlI);
    }
    
    @Override
    public Object remove(final Object llllllllllllllllIIlIIlllIllIllll) {
        return this.internalMap.remove(llllllllllllllllIIlIIlllIllIllll.toString().toLowerCase());
    }
    
    @Override
    public Set entrySet() {
        return this.internalMap.entrySet();
    }
    
    @Override
    public int size() {
        return this.internalMap.size();
    }
}
