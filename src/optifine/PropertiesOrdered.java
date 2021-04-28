package optifine;

import java.util.*;

public class PropertiesOrdered extends Properties
{
    private /* synthetic */ Set<Object> keysOrdered;
    
    @Override
    public synchronized Enumeration<Object> keys() {
        return Collections.enumeration(this.keySet());
    }
    
    @Override
    public Set<Object> keySet() {
        final Set llllllllllllllllIIIIlIllIllIlIll = super.keySet();
        this.keysOrdered.retainAll(llllllllllllllllIIIIlIllIllIlIll);
        return Collections.unmodifiableSet((Set<?>)this.keysOrdered);
    }
    
    @Override
    public synchronized Object put(final Object llllllllllllllllIIIIlIllIlllIIII, final Object llllllllllllllllIIIIlIllIlllIIlI) {
        this.keysOrdered.add(llllllllllllllllIIIIlIllIlllIIII);
        return super.put(llllllllllllllllIIIIlIllIlllIIII, llllllllllllllllIIIIlIllIlllIIlI);
    }
    
    public PropertiesOrdered() {
        this.keysOrdered = new LinkedHashSet<Object>();
    }
}
