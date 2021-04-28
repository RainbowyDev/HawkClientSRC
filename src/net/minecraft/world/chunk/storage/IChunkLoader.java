package net.minecraft.world.chunk.storage;

import net.minecraft.world.chunk.*;
import java.io.*;
import net.minecraft.world.*;

public interface IChunkLoader
{
    void saveExtraData();
    
    void saveExtraChunkData(final World p0, final Chunk p1);
    
    void saveChunk(final World p0, final Chunk p1) throws IOException, MinecraftException;
    
    void chunkTick();
    
    Chunk loadChunk(final World p0, final int p1, final int p2) throws IOException;
}
