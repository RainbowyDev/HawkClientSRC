package net.minecraft.entity.ai.attributes;

import com.google.common.collect.*;
import net.minecraft.server.management.*;
import java.util.*;

public class ServersideAttributeMap extends BaseAttributeMap
{
    private final /* synthetic */ Set attributeInstanceSet;
    protected final /* synthetic */ Map descriptionToAttributeInstanceMap;
    
    public ModifiableAttributeInstance func_180796_b(final String llllllllllllllllIlllIlIIllllIlIl) {
        IAttributeInstance llllllllllllllllIlllIlIIllllIlll = super.getAttributeInstanceByName(llllllllllllllllIlllIlIIllllIlIl);
        if (llllllllllllllllIlllIlIIllllIlll == null) {
            llllllllllllllllIlllIlIIllllIlll = this.descriptionToAttributeInstanceMap.get(llllllllllllllllIlllIlIIllllIlIl);
        }
        return (ModifiableAttributeInstance)llllllllllllllllIlllIlIIllllIlll;
    }
    
    public Set getAttributeInstanceSet() {
        return this.attributeInstanceSet;
    }
    
    public ServersideAttributeMap() {
        this.attributeInstanceSet = Sets.newHashSet();
        this.descriptionToAttributeInstanceMap = new LowerStringMap();
    }
    
    @Override
    public IAttributeInstance registerAttribute(final IAttribute llllllllllllllllIlllIlIIlllIllII) {
        final IAttributeInstance llllllllllllllllIlllIlIIlllIlllI = super.registerAttribute(llllllllllllllllIlllIlIIlllIllII);
        if (llllllllllllllllIlllIlIIlllIllII instanceof RangedAttribute && ((RangedAttribute)llllllllllllllllIlllIlIIlllIllII).getDescription() != null) {
            this.descriptionToAttributeInstanceMap.put(((RangedAttribute)llllllllllllllllIlllIlIIlllIllII).getDescription(), llllllllllllllllIlllIlIIlllIlllI);
        }
        return llllllllllllllllIlllIlIIlllIlllI;
    }
    
    @Override
    public void func_180794_a(final IAttributeInstance llllllllllllllllIlllIlIIllIllIIl) {
        if (llllllllllllllllIlllIlIIllIllIIl.getAttribute().getShouldWatch()) {
            this.attributeInstanceSet.add(llllllllllllllllIlllIlIIllIllIIl);
        }
        for (final IAttribute llllllllllllllllIlllIlIIllIlllII : this.field_180377_c.get((Object)llllllllllllllllIlllIlIIllIllIIl.getAttribute())) {
            final ModifiableAttributeInstance llllllllllllllllIlllIlIIllIllIll = this.func_180795_e(llllllllllllllllIlllIlIIllIlllII);
            if (llllllllllllllllIlllIlIIllIllIll != null) {
                llllllllllllllllIlllIlIIllIllIll.flagForUpdate();
            }
        }
    }
    
    @Override
    public IAttributeInstance getAttributeInstance(final IAttribute llllllllllllllllIlllIlIIlIllllIl) {
        return this.func_180795_e(llllllllllllllllIlllIlIIlIllllIl);
    }
    
    public ModifiableAttributeInstance func_180795_e(final IAttribute llllllllllllllllIlllIlIIllllllIl) {
        return (ModifiableAttributeInstance)super.getAttributeInstance(llllllllllllllllIlllIlIIllllllIl);
    }
    
    static {
        __OBFID = "CL_00001569";
    }
    
    public Collection getWatchedAttributes() {
        final HashSet llllllllllllllllIlllIlIIllIIllIl = Sets.newHashSet();
        for (final IAttributeInstance llllllllllllllllIlllIlIIllIIlIll : this.getAllAttributes()) {
            if (llllllllllllllllIlllIlIIllIIlIll.getAttribute().getShouldWatch()) {
                llllllllllllllllIlllIlIIllIIllIl.add(llllllllllllllllIlllIlIIllIIlIll);
            }
        }
        return llllllllllllllllIlllIlIIllIIllIl;
    }
    
    @Override
    public IAttributeInstance getAttributeInstanceByName(final String llllllllllllllllIlllIlIIllIIIIll) {
        return this.func_180796_b(llllllllllllllllIlllIlIIllIIIIll);
    }
    
    @Override
    protected IAttributeInstance func_180376_c(final IAttribute llllllllllllllllIlllIlIIlllIIlll) {
        return new ModifiableAttributeInstance(this, llllllllllllllllIlllIlIIlllIIlll);
    }
}
