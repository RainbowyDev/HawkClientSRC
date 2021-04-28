package net.minecraft.block.state;

import net.minecraft.block.properties.*;
import com.google.common.collect.*;
import net.minecraft.block.*;
import java.util.*;

public interface IBlockState
{
    IBlockState cycleProperty(final IProperty p0);
    
    ImmutableMap getProperties();
    
    Block getBlock();
    
    Comparable getValue(final IProperty p0);
    
    Collection getPropertyNames();
    
    IBlockState withProperty(final IProperty p0, final Comparable p1);
}
