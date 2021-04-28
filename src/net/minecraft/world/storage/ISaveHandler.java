package net.minecraft.world.storage;

import net.minecraft.world.chunk.storage.*;
import java.io.*;
import net.minecraft.world.*;
import net.minecraft.nbt.*;

public interface ISaveHandler
{
    IChunkLoader getChunkLoader(final WorldProvider p0);
    
    void saveWorldInfo(final WorldInfo p0);
    
    void flush();
    
    File getWorldDirectory();
    
    String getWorldDirectoryName();
    
    void checkSessionLock() throws MinecraftException;
    
    void saveWorldInfoWithPlayer(final WorldInfo p0, final NBTTagCompound p1);
    
    WorldInfo loadWorldInfo();
    
    IPlayerFileData getPlayerNBTManager();
    
    File getMapFileFromName(final String p0);
}
