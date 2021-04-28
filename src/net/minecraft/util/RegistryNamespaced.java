package net.minecraft.util;

import java.util.*;
import com.google.common.collect.*;

public class RegistryNamespaced extends RegistrySimple implements IObjectIntIterable
{
    protected final /* synthetic */ ObjectIntIdentityMap underlyingIntegerMap;
    protected final /* synthetic */ Map field_148758_b;
    
    public Object getNameForObject(final Object llllllllllllllllIlllIllIIlllIIII) {
        return this.field_148758_b.get(llllllllllllllllIlllIllIIlllIIII);
    }
    
    @Override
    public Iterator iterator() {
        return this.underlyingIntegerMap.iterator();
    }
    
    public RegistryNamespaced() {
        this.underlyingIntegerMap = new ObjectIntIdentityMap();
        this.field_148758_b = (Map)((BiMap)this.registryObjects).inverse();
    }
    
    @Override
    public Object getObject(final Object llllllllllllllllIlllIllIIlllIlII) {
        return super.getObject(llllllllllllllllIlllIllIIlllIlII);
    }
    
    public void register(final int llllllllllllllllIlllIllIlIIIIIIl, final Object llllllllllllllllIlllIllIIlllllII, final Object llllllllllllllllIlllIllIIlllllll) {
        this.underlyingIntegerMap.put(llllllllllllllllIlllIllIIlllllll, llllllllllllllllIlllIllIlIIIIIIl);
        this.putObject(llllllllllllllllIlllIllIIlllllII, llllllllllllllllIlllIllIIlllllll);
    }
    
    @Override
    public boolean containsKey(final Object llllllllllllllllIlllIllIIllIlIlI) {
        return super.containsKey(llllllllllllllllIlllIllIIllIlIlI);
    }
    
    static {
        __OBFID = "CL_00001206";
    }
    
    @Override
    protected Map createUnderlyingMap() {
        return (Map)HashBiMap.create();
    }
    
    public Object getObjectById(final int llllllllllllllllIlllIllIIlIllllI) {
        return this.underlyingIntegerMap.getByValue(llllllllllllllllIlllIllIIlIllllI);
    }
    
    public int getIDForObject(final Object llllllllllllllllIlllIllIIllIIlII) {
        return this.underlyingIntegerMap.get(llllllllllllllllIlllIllIIllIIlII);
    }
}
