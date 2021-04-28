package net.minecraft.entity.boss;

import net.minecraft.util.*;

public interface IBossDisplayData
{
    float getHealth();
    
    IChatComponent getDisplayName();
    
    float getMaxHealth();
}
