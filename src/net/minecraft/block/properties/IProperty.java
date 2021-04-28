package net.minecraft.block.properties;

import java.util.*;

public interface IProperty
{
    String getName(final Comparable p0);
    
    Class getValueClass();
    
    Collection getAllowedValues();
    
    String getName();
}
