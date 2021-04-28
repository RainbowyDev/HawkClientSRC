package net.minecraft.world.chunk.storage;

import net.minecraft.world.chunk.*;
import net.minecraft.block.*;
import net.minecraft.block.state.*;
import java.util.*;
import optifine.*;
import net.minecraft.init.*;

public class ExtendedBlockStorage
{
    private /* synthetic */ int yBase;
    private /* synthetic */ NibbleArray blocklightArray;
    private /* synthetic */ NibbleArray skylightArray;
    private /* synthetic */ int blockRefCount;
    private /* synthetic */ int tickRefCount;
    private /* synthetic */ char[] data;
    
    public void setExtBlocklightValue(final int llIllIlIllIl, final int llIllIlIllII, final int llIllIlIlIll, final int llIllIlIlIlI) {
        this.blocklightArray.set(llIllIlIllIl, llIllIlIllII, llIllIlIlIll, llIllIlIlIlI);
    }
    
    public void removeInvalidBlocks() {
        final List llIllIIIlIlI = Block.BLOCK_STATE_IDS.getObjectList();
        final int llIllIIIlIIl = llIllIIIlIlI.size();
        int llIllIIIlIII = 0;
        int llIllIIIIlll = 0;
        for (int llIllIIIIllI = 0; llIllIIIIllI < 16; ++llIllIIIIllI) {
            final int llIllIIIIlIl = llIllIIIIllI << 8;
            for (int llIllIIIIlII = 0; llIllIIIIlII < 16; ++llIllIIIIlII) {
                final int llIllIIIIIll = llIllIIIIlIl | llIllIIIIlII << 4;
                for (int llIllIIIIIlI = 0; llIllIIIIIlI < 16; ++llIllIIIIIlI) {
                    final char llIllIIIIIIl = this.data[llIllIIIIIll | llIllIIIIIlI];
                    if (llIllIIIIIIl > '\0') {
                        ++llIllIIIlIII;
                        if (llIllIIIIIIl < llIllIIIlIIl) {
                            final IBlockState llIllIIIIIII = llIllIIIlIlI.get(llIllIIIIIIl);
                            if (llIllIIIIIII != null) {
                                final Block llIlIlllllll = llIllIIIIIII.getBlock();
                                if (llIlIlllllll.getTickRandomly()) {
                                    ++llIllIIIIlll;
                                }
                            }
                        }
                    }
                }
            }
        }
        this.blockRefCount = llIllIIIlIII;
        this.tickRefCount = llIllIIIIlll;
    }
    
    public void set(final int llIllllllIIl, final int lllIIIIIIIII, final int llIlllllllll, IBlockState llIlllllIllI) {
        if (Reflector.IExtendedBlockState.isInstance(llIlllllIllI)) {
            llIlllllIllI = (IBlockState)Reflector.call(llIlllllIllI, Reflector.IExtendedBlockState_getClean, new Object[0]);
        }
        final IBlockState llIlllllllIl = this.get(llIllllllIIl, lllIIIIIIIII, llIlllllllll);
        final Block llIlllllllII = llIlllllllIl.getBlock();
        final Block llIllllllIll = llIlllllIllI.getBlock();
        if (llIlllllllII != Blocks.air) {
            --this.blockRefCount;
            if (llIlllllllII.getTickRandomly()) {
                --this.tickRefCount;
            }
        }
        if (llIllllllIll != Blocks.air) {
            ++this.blockRefCount;
            if (llIllllllIll.getTickRandomly()) {
                ++this.tickRefCount;
            }
        }
        this.data[lllIIIIIIIII << 8 | llIlllllllll << 4 | llIllllllIIl] = (char)Block.BLOCK_STATE_IDS.get(llIlllllIllI);
    }
    
    public void setData(final char[] llIlIllIlIIl) {
        this.data = llIlIllIlIIl;
    }
    
    public NibbleArray getSkylightArray() {
        return this.skylightArray;
    }
    
    public char[] getData() {
        return this.data;
    }
    
    public int getExtSkylightValue(final int llIllIllIllI, final int llIllIllIlIl, final int llIllIlllIII) {
        return this.skylightArray.get(llIllIllIllI, llIllIllIlIl, llIllIlllIII);
    }
    
    public void setSkylightArray(final NibbleArray llIlIlIllIIl) {
        this.skylightArray = llIlIlIllIIl;
    }
    
    public int getExtBlocklightValue(final int llIllIIlllll, final int llIllIIllllI, final int llIllIIlllIl) {
        return this.blocklightArray.get(llIllIIlllll, llIllIIllllI, llIllIIlllIl);
    }
    
    public Block getBlockByExtId(final int llIllllIllIl, final int llIllllIllII, final int llIllllIIlll) {
        return this.get(llIllllIllIl, llIllllIllII, llIllllIIlll).getBlock();
    }
    
    public int getExtBlockMetadata(final int llIlllIllIll, final int llIlllIllIlI, final int llIlllIllllI) {
        final IBlockState llIlllIlllIl = this.get(llIlllIllIll, llIlllIllIlI, llIlllIllllI);
        return llIlllIlllIl.getBlock().getMetaFromState(llIlllIlllIl);
    }
    
    public void setExtSkylightValue(final int llIlllIIlIII, final int llIlllIIIIlI, final int llIlllIIIllI, final int llIlllIIIlIl) {
        this.skylightArray.set(llIlllIIlIII, llIlllIIIIlI, llIlllIIIllI, llIlllIIIlIl);
    }
    
    public boolean getNeedsRandomTick() {
        return this.tickRefCount > 0;
    }
    
    public int getYLocation() {
        return this.yBase;
    }
    
    public IBlockState get(final int lllIIIIIlllI, final int lllIIIIIllIl, final int lllIIIIlIIIl) {
        final IBlockState lllIIIIlIIII = (IBlockState)Block.BLOCK_STATE_IDS.getByValue(this.data[lllIIIIIllIl << 8 | lllIIIIlIIIl << 4 | lllIIIIIlllI]);
        return (lllIIIIlIIII != null) ? lllIIIIlIIII : Blocks.air.getDefaultState();
    }
    
    static {
        __OBFID = "CL_00000375";
    }
    
    public void setBlocklightArray(final NibbleArray llIlIlIlllIl) {
        this.blocklightArray = llIlIlIlllIl;
    }
    
    public NibbleArray getBlocklightArray() {
        return this.blocklightArray;
    }
    
    public boolean isEmpty() {
        return this.blockRefCount == 0;
    }
    
    public ExtendedBlockStorage(final int lllIIIIllIll, final boolean lllIIIIlllIl) {
        this.yBase = lllIIIIllIll;
        this.data = new char[4096];
        this.blocklightArray = new NibbleArray();
        if (lllIIIIlllIl) {
            this.skylightArray = new NibbleArray();
        }
    }
}
