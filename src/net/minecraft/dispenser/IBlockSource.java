package net.minecraft.dispenser;

import net.minecraft.block.*;
import net.minecraft.util.*;
import net.minecraft.tileentity.*;

public interface IBlockSource extends ILocatableSource
{
    Block getBlock();
    
    BlockPos getBlockPos();
    
    int getBlockMetadata();
    
    double getZ();
    
    double getX();
    
    TileEntity getBlockTileEntity();
    
    double getY();
}
