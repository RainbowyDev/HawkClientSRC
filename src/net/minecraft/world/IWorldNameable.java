package net.minecraft.world;

import net.minecraft.util.*;

public interface IWorldNameable
{
    String getName();
    
    IChatComponent getDisplayName();
    
    boolean hasCustomName();
}
