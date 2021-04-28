package net.minecraft.world;

import net.minecraft.util.*;

public class ChunkCoordIntPair
{
    private /* synthetic */ int cachedHashCode;
    public final /* synthetic */ int chunkXPos;
    public final /* synthetic */ int chunkZPos;
    
    public BlockPos getCenterBlock(final int lllllllllllllllllllIlllIIIIlIIll) {
        return new BlockPos(this.getCenterXPos(), lllllllllllllllllllIlllIIIIlIIll, this.getCenterZPosition());
    }
    
    public int getCenterZPosition() {
        return (this.chunkZPos << 4) + 8;
    }
    
    public int getXEnd() {
        return (this.chunkXPos << 4) + 15;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllllllllIlllIIIlllIll) {
        if (this == lllllllllllllllllllIlllIIIlllIll) {
            return true;
        }
        if (!(lllllllllllllllllllIlllIIIlllIll instanceof ChunkCoordIntPair)) {
            return false;
        }
        final ChunkCoordIntPair lllllllllllllllllllIlllIIIlllIlI = (ChunkCoordIntPair)lllllllllllllllllllIlllIIIlllIll;
        return this.chunkXPos == lllllllllllllllllllIlllIIIlllIlI.chunkXPos && this.chunkZPos == lllllllllllllllllllIlllIIIlllIlI.chunkZPos;
    }
    
    public int getCenterXPos() {
        return (this.chunkXPos << 4) + 8;
    }
    
    public BlockPos getBlock(final int lllllllllllllllllllIlllIIIIllIll, final int lllllllllllllllllllIlllIIIIllllI, final int lllllllllllllllllllIlllIIIIllIIl) {
        return new BlockPos((this.chunkXPos << 4) + lllllllllllllllllllIlllIIIIllIll, lllllllllllllllllllIlllIIIIllllI, (this.chunkZPos << 4) + lllllllllllllllllllIlllIIIIllIIl);
    }
    
    public int getZEnd() {
        return (this.chunkZPos << 4) + 15;
    }
    
    public int getXStart() {
        return this.chunkXPos << 4;
    }
    
    @Override
    public int hashCode() {
        if (this.cachedHashCode == 0) {
            final int lllllllllllllllllllIlllIIlIIIlII = 1664525 * this.chunkXPos + 1013904223;
            final int lllllllllllllllllllIlllIIlIIIIll = 1664525 * (this.chunkZPos ^ 0xDEADBEEF) + 1013904223;
            this.cachedHashCode = (lllllllllllllllllllIlllIIlIIIlII ^ lllllllllllllllllllIlllIIlIIIIll);
        }
        return this.cachedHashCode;
    }
    
    public ChunkCoordIntPair(final int lllllllllllllllllllIlllIIlIlIIll, final int lllllllllllllllllllIlllIIlIlIIlI) {
        this.cachedHashCode = 0;
        this.chunkXPos = lllllllllllllllllllIlllIIlIlIIll;
        this.chunkZPos = lllllllllllllllllllIlllIIlIlIIlI;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("[").append(this.chunkXPos).append(", ").append(this.chunkZPos).append("]"));
    }
    
    public int getZStart() {
        return this.chunkZPos << 4;
    }
    
    static {
        __OBFID = "CL_00000133";
    }
    
    public static long chunkXZ2Int(final int lllllllllllllllllllIlllIIlIIlIlI, final int lllllllllllllllllllIlllIIlIIlIIl) {
        return ((long)lllllllllllllllllllIlllIIlIIlIlI & 0xFFFFFFFFL) | ((long)lllllllllllllllllllIlllIIlIIlIIl & 0xFFFFFFFFL) << 32;
    }
}
