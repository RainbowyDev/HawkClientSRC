package net.minecraft.world.chunk;

import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.block.*;

public class ChunkPrimer
{
    private final /* synthetic */ short[] data;
    private final /* synthetic */ IBlockState defaultState;
    
    public ChunkPrimer() {
        this.data = new short[65536];
        this.defaultState = Blocks.air.getDefaultState();
    }
    
    static {
        __OBFID = "CL_00002007";
    }
    
    public void setBlockState(final int llllllllllllllIIIlIIIlllIlIlIIll, final int llllllllllllllIIIlIIIlllIlIIllII, final int llllllllllllllIIIlIIIlllIlIIlIll, final IBlockState llllllllllllllIIIlIIIlllIlIlIIII) {
        final int llllllllllllllIIIlIIIlllIlIIllll = llllllllllllllIIIlIIIlllIlIlIIll << 12 | llllllllllllllIIIlIIIlllIlIIlIll << 8 | llllllllllllllIIIlIIIlllIlIIllII;
        this.setBlockState(llllllllllllllIIIlIIIlllIlIIllll, llllllllllllllIIIlIIIlllIlIlIIII);
    }
    
    public IBlockState getBlockState(final int llllllllllllllIIIlIIIlllIllIIlll, final int llllllllllllllIIIlIIIlllIllIIllI, final int llllllllllllllIIIlIIIlllIllIIlIl) {
        final int llllllllllllllIIIlIIIlllIllIlIIl = llllllllllllllIIIlIIIlllIllIIlll << 12 | llllllllllllllIIIlIIIlllIllIIlIl << 8 | llllllllllllllIIIlIIIlllIllIIllI;
        return this.getBlockState(llllllllllllllIIIlIIIlllIllIlIIl);
    }
    
    public IBlockState getBlockState(final int llllllllllllllIIIlIIIlllIlIlllII) {
        if (llllllllllllllIIIlIIIlllIlIlllII >= 0 && llllllllllllllIIIlIIIlllIlIlllII < this.data.length) {
            final IBlockState llllllllllllllIIIlIIIlllIlIllllI = (IBlockState)Block.BLOCK_STATE_IDS.getByValue(this.data[llllllllllllllIIIlIIIlllIlIlllII]);
            return (llllllllllllllIIIlIIIlllIlIllllI != null) ? llllllllllllllIIIlIIIlllIlIllllI : this.defaultState;
        }
        throw new IndexOutOfBoundsException("The coordinate is out of range");
    }
    
    public void setBlockState(final int llllllllllllllIIIlIIIlllIlIIIlII, final IBlockState llllllllllllllIIIlIIIlllIlIIIIll) {
        if (llllllllllllllIIIlIIIlllIlIIIlII >= 0 && llllllllllllllIIIlIIIlllIlIIIlII < this.data.length) {
            this.data[llllllllllllllIIIlIIIlllIlIIIlII] = (short)Block.BLOCK_STATE_IDS.get(llllllllllllllIIIlIIIlllIlIIIIll);
            return;
        }
        throw new IndexOutOfBoundsException("The coordinate is out of range");
    }
}
