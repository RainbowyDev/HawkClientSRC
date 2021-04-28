package net.minecraft.entity.ai.attributes;

import net.minecraft.server.management.*;
import com.google.common.collect.*;
import java.util.*;

public abstract class BaseAttributeMap
{
    protected final /* synthetic */ Multimap field_180377_c;
    protected final /* synthetic */ Map attributes;
    protected final /* synthetic */ Map attributesByName;
    
    public IAttributeInstance getAttributeInstanceByName(final String lllllllllllllllIlIlIllIllIIlllII) {
        return this.attributesByName.get(lllllllllllllllIlIlIllIllIIlllII);
    }
    
    public Collection getAllAttributes() {
        return this.attributesByName.values();
    }
    
    public IAttributeInstance getAttributeInstance(final IAttribute lllllllllllllllIlIlIllIllIlIIlII) {
        return this.attributes.get(lllllllllllllllIlIlIllIllIlIIlII);
    }
    
    public void func_180794_a(final IAttributeInstance lllllllllllllllIlIlIllIllIIIlIll) {
    }
    
    public IAttributeInstance registerAttribute(final IAttribute lllllllllllllllIlIlIllIllIIlIIlI) {
        if (this.attributesByName.containsKey(lllllllllllllllIlIlIllIllIIlIIlI.getAttributeUnlocalizedName())) {
            throw new IllegalArgumentException("Attribute is already registered!");
        }
        final IAttributeInstance lllllllllllllllIlIlIllIllIIlIlIl = this.func_180376_c(lllllllllllllllIlIlIllIllIIlIIlI);
        this.attributesByName.put(lllllllllllllllIlIlIllIllIIlIIlI.getAttributeUnlocalizedName(), lllllllllllllllIlIlIllIllIIlIlIl);
        this.attributes.put(lllllllllllllllIlIlIllIllIIlIIlI, lllllllllllllllIlIlIllIllIIlIlIl);
        for (IAttribute lllllllllllllllIlIlIllIllIIlIlII = lllllllllllllllIlIlIllIllIIlIIlI.func_180372_d(); lllllllllllllllIlIlIllIllIIlIlII != null; lllllllllllllllIlIlIllIllIIlIlII = lllllllllllllllIlIlIllIllIIlIlII.func_180372_d()) {
            this.field_180377_c.put((Object)lllllllllllllllIlIlIllIllIIlIlII, (Object)lllllllllllllllIlIlIllIllIIlIIlI);
        }
        return lllllllllllllllIlIlIllIllIIlIlIl;
    }
    
    protected abstract IAttributeInstance func_180376_c(final IAttribute p0);
    
    static {
        __OBFID = "CL_00001566";
    }
    
    public BaseAttributeMap() {
        this.attributes = Maps.newHashMap();
        this.attributesByName = new LowerStringMap();
        this.field_180377_c = (Multimap)HashMultimap.create();
    }
    
    public void applyAttributeModifiers(final Multimap lllllllllllllllIlIlIllIlIlllIIII) {
        for (final Map.Entry lllllllllllllllIlIlIllIlIlllIIll : lllllllllllllllIlIlIllIlIlllIIII.entries()) {
            final IAttributeInstance lllllllllllllllIlIlIllIlIlllIIlI = this.getAttributeInstanceByName(lllllllllllllllIlIlIllIlIlllIIll.getKey());
            if (lllllllllllllllIlIlIllIlIlllIIlI != null) {
                lllllllllllllllIlIlIllIlIlllIIlI.removeModifier(lllllllllllllllIlIlIllIlIlllIIll.getValue());
                lllllllllllllllIlIlIllIlIlllIIlI.applyModifier(lllllllllllllllIlIlIllIlIlllIIll.getValue());
            }
        }
    }
    
    public void removeAttributeModifiers(final Multimap lllllllllllllllIlIlIllIllIIIIlII) {
        for (final Map.Entry lllllllllllllllIlIlIllIllIIIIIlI : lllllllllllllllIlIlIllIllIIIIlII.entries()) {
            final IAttributeInstance lllllllllllllllIlIlIllIllIIIIIIl = this.getAttributeInstanceByName(lllllllllllllllIlIlIllIllIIIIIlI.getKey());
            if (lllllllllllllllIlIlIllIllIIIIIIl != null) {
                lllllllllllllllIlIlIllIllIIIIIIl.removeModifier(lllllllllllllllIlIlIllIllIIIIIlI.getValue());
            }
        }
    }
}
