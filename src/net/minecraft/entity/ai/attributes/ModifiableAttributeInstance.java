package net.minecraft.entity.ai.attributes;

import com.google.common.collect.*;
import java.util.*;

public class ModifiableAttributeInstance implements IAttributeInstance
{
    private final /* synthetic */ IAttribute genericAttribute;
    private final /* synthetic */ BaseAttributeMap attributeMap;
    private /* synthetic */ double cachedValue;
    private final /* synthetic */ Map mapByName;
    private /* synthetic */ boolean needsUpdate;
    private /* synthetic */ double baseValue;
    private final /* synthetic */ Map mapByOperation;
    private final /* synthetic */ Map mapByUUID;
    
    @Override
    public void removeModifier(final AttributeModifier lllllllllllllllIIIIlllIIIIlIIIII) {
        for (int lllllllllllllllIIIIlllIIIIIlllll = 0; lllllllllllllllIIIIlllIIIIIlllll < 3; ++lllllllllllllllIIIIlllIIIIIlllll) {
            final Set lllllllllllllllIIIIlllIIIIIllllI = this.mapByOperation.get(lllllllllllllllIIIIlllIIIIIlllll);
            lllllllllllllllIIIIlllIIIIIllllI.remove(lllllllllllllllIIIIlllIIIIlIIIII);
        }
        final Set lllllllllllllllIIIIlllIIIIIlllIl = this.mapByName.get(lllllllllllllllIIIIlllIIIIlIIIII.getName());
        if (lllllllllllllllIIIIlllIIIIIlllIl != null) {
            lllllllllllllllIIIIlllIIIIIlllIl.remove(lllllllllllllllIIIIlllIIIIlIIIII);
            if (lllllllllllllllIIIIlllIIIIIlllIl.isEmpty()) {
                this.mapByName.remove(lllllllllllllllIIIIlllIIIIlIIIII.getName());
            }
        }
        this.mapByUUID.remove(lllllllllllllllIIIIlllIIIIlIIIII.getID());
        this.flagForUpdate();
    }
    
    private double computeValue() {
        double lllllllllllllllIIIIllIllllllllll = this.getBaseValue();
        for (final AttributeModifier lllllllllllllllIIIIllIlllllllllI : this.func_180375_b(0)) {
            lllllllllllllllIIIIllIllllllllll += lllllllllllllllIIIIllIlllllllllI.getAmount();
        }
        double lllllllllllllllIIIIllIllllllllII = lllllllllllllllIIIIllIllllllllll;
        for (final AttributeModifier lllllllllllllllIIIIllIlllllllIlI : this.func_180375_b(1)) {
            lllllllllllllllIIIIllIllllllllII += lllllllllllllllIIIIllIllllllllll * lllllllllllllllIIIIllIlllllllIlI.getAmount();
        }
        for (final AttributeModifier lllllllllllllllIIIIllIlllllllIIl : this.func_180375_b(2)) {
            lllllllllllllllIIIIllIllllllllII *= 1.0 + lllllllllllllllIIIIllIlllllllIIl.getAmount();
        }
        return this.genericAttribute.clampValue(lllllllllllllllIIIIllIllllllllII);
    }
    
    @Override
    public double getAttributeValue() {
        if (this.needsUpdate) {
            this.cachedValue = this.computeValue();
            this.needsUpdate = false;
        }
        return this.cachedValue;
    }
    
    @Override
    public void applyModifier(final AttributeModifier lllllllllllllllIIIIlllIIIIlIllIl) {
        if (this.getModifier(lllllllllllllllIIIIlllIIIIlIllIl.getID()) != null) {
            throw new IllegalArgumentException("Modifier is already applied on this attribute!");
        }
        Object lllllllllllllllIIIIlllIIIIlIllII = this.mapByName.get(lllllllllllllllIIIIlllIIIIlIllIl.getName());
        if (lllllllllllllllIIIIlllIIIIlIllII == null) {
            lllllllllllllllIIIIlllIIIIlIllII = Sets.newHashSet();
            this.mapByName.put(lllllllllllllllIIIIlllIIIIlIllIl.getName(), lllllllllllllllIIIIlllIIIIlIllII);
        }
        this.mapByOperation.get(lllllllllllllllIIIIlllIIIIlIllIl.getOperation()).add(lllllllllllllllIIIIlllIIIIlIllIl);
        ((Set)lllllllllllllllIIIIlllIIIIlIllII).add(lllllllllllllllIIIIlllIIIIlIllIl);
        this.mapByUUID.put(lllllllllllllllIIIIlllIIIIlIllIl.getID(), lllllllllllllllIIIIlllIIIIlIllIl);
        this.flagForUpdate();
    }
    
    @Override
    public AttributeModifier getModifier(final UUID lllllllllllllllIIIIlllIIIIlllIlI) {
        return this.mapByUUID.get(lllllllllllllllIIIIlllIIIIlllIlI);
    }
    
    public ModifiableAttributeInstance(final BaseAttributeMap lllllllllllllllIIIIlllIIIlIlllll, final IAttribute lllllllllllllllIIIIlllIIIlIllllI) {
        this.mapByOperation = Maps.newHashMap();
        this.mapByName = Maps.newHashMap();
        this.mapByUUID = Maps.newHashMap();
        this.needsUpdate = true;
        this.attributeMap = lllllllllllllllIIIIlllIIIlIlllll;
        this.genericAttribute = lllllllllllllllIIIIlllIIIlIllllI;
        this.baseValue = lllllllllllllllIIIIlllIIIlIllllI.getDefaultValue();
        for (int lllllllllllllllIIIIlllIIIlIlllIl = 0; lllllllllllllllIIIIlllIIIlIlllIl < 3; ++lllllllllllllllIIIIlllIIIlIlllIl) {
            this.mapByOperation.put(lllllllllllllllIIIIlllIIIlIlllIl, Sets.newHashSet());
        }
    }
    
    @Override
    public void setBaseValue(final double lllllllllllllllIIIIlllIIIlIIllIl) {
        if (lllllllllllllllIIIIlllIIIlIIllIl != this.getBaseValue()) {
            this.baseValue = lllllllllllllllIIIIlllIIIlIIllIl;
            this.flagForUpdate();
        }
    }
    
    @Override
    public double getBaseValue() {
        return this.baseValue;
    }
    
    @Override
    public Collection getModifiersByOperation(final int lllllllllllllllIIIIlllIIIlIIIlll) {
        return this.mapByOperation.get(lllllllllllllllIIIIlllIIIlIIIlll);
    }
    
    private Collection func_180375_b(final int lllllllllllllllIIIIllIlllllIIlll) {
        final HashSet lllllllllllllllIIIIllIlllllIlIll = Sets.newHashSet((Iterable)this.getModifiersByOperation(lllllllllllllllIIIIllIlllllIIlll));
        for (IAttribute lllllllllllllllIIIIllIlllllIlIlI = this.genericAttribute.func_180372_d(); lllllllllllllllIIIIllIlllllIlIlI != null; lllllllllllllllIIIIllIlllllIlIlI = lllllllllllllllIIIIllIlllllIlIlI.func_180372_d()) {
            final IAttributeInstance lllllllllllllllIIIIllIlllllIlIIl = this.attributeMap.getAttributeInstance(lllllllllllllllIIIIllIlllllIlIlI);
            if (lllllllllllllllIIIIllIlllllIlIIl != null) {
                lllllllllllllllIIIIllIlllllIlIll.addAll(lllllllllllllllIIIIllIlllllIlIIl.getModifiersByOperation(lllllllllllllllIIIIllIlllllIIlll));
            }
        }
        return lllllllllllllllIIIIllIlllllIlIll;
    }
    
    protected void flagForUpdate() {
        this.needsUpdate = true;
        this.attributeMap.func_180794_a(this);
    }
    
    @Override
    public void removeAllModifiers() {
        final Collection lllllllllllllllIIIIlllIIIIIlIIlI = this.func_111122_c();
        if (lllllllllllllllIIIIlllIIIIIlIIlI != null) {
            final ArrayList lllllllllllllllIIIIlllIIIIIlIIIl = Lists.newArrayList((Iterable)lllllllllllllllIIIIlllIIIIIlIIlI);
            for (final AttributeModifier lllllllllllllllIIIIlllIIIIIIllll : lllllllllllllllIIIIlllIIIIIlIIIl) {
                this.removeModifier(lllllllllllllllIIIIlllIIIIIIllll);
            }
        }
    }
    
    @Override
    public Collection func_111122_c() {
        final HashSet lllllllllllllllIIIIlllIIIlIIIIlI = Sets.newHashSet();
        for (int lllllllllllllllIIIIlllIIIlIIIIIl = 0; lllllllllllllllIIIIlllIIIlIIIIIl < 3; ++lllllllllllllllIIIIlllIIIlIIIIIl) {
            lllllllllllllllIIIIlllIIIlIIIIlI.addAll(this.getModifiersByOperation(lllllllllllllllIIIIlllIIIlIIIIIl));
        }
        return lllllllllllllllIIIIlllIIIlIIIIlI;
    }
    
    static {
        __OBFID = "CL_00001567";
    }
    
    @Override
    public IAttribute getAttribute() {
        return this.genericAttribute;
    }
    
    @Override
    public boolean func_180374_a(final AttributeModifier lllllllllllllllIIIIlllIIIIllIIlI) {
        return this.mapByUUID.get(lllllllllllllllIIIIlllIIIIllIIlI.getID()) != null;
    }
}
