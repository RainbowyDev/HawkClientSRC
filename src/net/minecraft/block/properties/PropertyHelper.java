package net.minecraft.block.properties;

import com.google.common.base.*;

public abstract class PropertyHelper implements IProperty
{
    private final /* synthetic */ String name;
    private final /* synthetic */ Class valueClass;
    
    static {
        __OBFID = "CL_00002018";
    }
    
    @Override
    public Class getValueClass() {
        return this.valueClass;
    }
    
    @Override
    public String getName() {
        return this.name;
    }
    
    protected PropertyHelper(final String lllllllllllllllIIIIIIIIIIIIlIIIl, final Class lllllllllllllllIIIIIIIIIIIIlIIII) {
        this.valueClass = lllllllllllllllIIIIIIIIIIIIlIIII;
        this.name = lllllllllllllllIIIIIIIIIIIIlIIIl;
    }
    
    @Override
    public int hashCode() {
        return 31 * this.valueClass.hashCode() + this.name.hashCode();
    }
    
    @Override
    public String toString() {
        return Objects.toStringHelper((Object)this).add("name", (Object)this.name).add("clazz", (Object)this.valueClass).add("values", (Object)this.getAllowedValues()).toString();
    }
    
    @Override
    public boolean equals(final Object lllllllllllllllIIIIIIIIIIIIIIIlI) {
        if (this == lllllllllllllllIIIIIIIIIIIIIIIlI) {
            return true;
        }
        if (lllllllllllllllIIIIIIIIIIIIIIIlI != null && this.getClass() == lllllllllllllllIIIIIIIIIIIIIIIlI.getClass()) {
            final PropertyHelper lllllllllllllllIIIIIIIIIIIIIIIIl = (PropertyHelper)lllllllllllllllIIIIIIIIIIIIIIIlI;
            return this.valueClass.equals(lllllllllllllllIIIIIIIIIIIIIIIIl.valueClass) && this.name.equals(lllllllllllllllIIIIIIIIIIIIIIIIl.name);
        }
        return false;
    }
}
