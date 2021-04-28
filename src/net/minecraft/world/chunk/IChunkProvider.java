package net.minecraft.world.chunk;

import net.minecraft.world.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.util.*;

public interface IChunkProvider
{
    boolean chunkExists(final int p0, final int p1);
    
    boolean func_177460_a(final IChunkProvider p0, final Chunk p1, final int p2, final int p3);
    
    Chunk func_177459_a(final BlockPos p0);
    
    void populate(final IChunkProvider p0, final int p1, final int p2);
    
    Chunk provideChunk(final int p0, final int p1);
    
    boolean canSave();
    
    void func_180514_a(final Chunk p0, final int p1, final int p2);
    
    boolean unloadQueuedChunks();
    
    BlockPos func_180513_a(final World p0, final String p1, final BlockPos p2);
    
    int getLoadedChunkCount();
    
    List func_177458_a(final EnumCreatureType p0, final BlockPos p1);
    
    void saveExtraData();
    
    boolean saveChunks(final boolean p0, final IProgressUpdate p1);
    
    String makeString();
}
