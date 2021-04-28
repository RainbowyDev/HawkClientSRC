package net.minecraft.block;

import net.minecraft.dispenser.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.tileentity.*;
import net.minecraft.block.state.*;

public class BlockSourceImpl implements IBlockSource
{
    private final /* synthetic */ BlockPos pos;
    private final /* synthetic */ World worldObj;
    
    @Override
    public TileEntity getBlockTileEntity() {
        return this.worldObj.getTileEntity(this.pos);
    }
    
    public BlockSourceImpl(final World lllllllllllllllIIlIlllllIIllIIIl, final BlockPos lllllllllllllllIIlIlllllIIllIIII) {
        this.worldObj = lllllllllllllllIIlIlllllIIllIIIl;
        this.pos = lllllllllllllllIIlIlllllIIllIIII;
    }
    
    static {
        __OBFID = "CL_00001194";
    }
    
    @Override
    public double getZ() {
        return this.pos.getZ() + 0.5;
    }
    
    @Override
    public BlockPos getBlockPos() {
        return this.pos;
    }
    
    @Override
    public int getBlockMetadata() {
        final IBlockState lllllllllllllllIIlIlllllIIIllIlI = this.worldObj.getBlockState(this.pos);
        return lllllllllllllllIIlIlllllIIIllIlI.getBlock().getMetaFromState(lllllllllllllllIIlIlllllIIIllIlI);
    }
    
    @Override
    public World getWorld() {
        return this.worldObj;
    }
    
    @Override
    public Block getBlock() {
        return this.worldObj.getBlockState(this.pos).getBlock();
    }
    
    @Override
    public double getX() {
        return this.pos.getX() + 0.5;
    }
    
    @Override
    public double getY() {
        return this.pos.getY() + 0.5;
    }
}
