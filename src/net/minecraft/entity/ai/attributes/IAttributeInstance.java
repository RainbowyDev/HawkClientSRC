package net.minecraft.entity.ai.attributes;

import java.util.*;

public interface IAttributeInstance
{
    void removeModifier(final AttributeModifier p0);
    
    boolean func_180374_a(final AttributeModifier p0);
    
    void removeAllModifiers();
    
    IAttribute getAttribute();
    
    AttributeModifier getModifier(final UUID p0);
    
    void applyModifier(final AttributeModifier p0);
    
    void setBaseValue(final double p0);
    
    Collection getModifiersByOperation(final int p0);
    
    Collection func_111122_c();
    
    double getAttributeValue();
    
    double getBaseValue();
}
