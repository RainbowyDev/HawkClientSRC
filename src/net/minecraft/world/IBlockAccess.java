package net.minecraft.world;

import net.minecraft.world.biome.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;

public interface IBlockAccess
{
    BiomeGenBase getBiomeGenForCoords(final BlockPos p0);
    
    WorldType getWorldType();
    
    TileEntity getTileEntity(final BlockPos p0);
    
    int getStrongPower(final BlockPos p0, final EnumFacing p1);
    
    boolean isAirBlock(final BlockPos p0);
    
    boolean extendedLevelsInChunkCache();
    
    IBlockState getBlockState(final BlockPos p0);
    
    int getCombinedLight(final BlockPos p0, final int p1);
}
