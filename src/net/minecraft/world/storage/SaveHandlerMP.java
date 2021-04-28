package net.minecraft.world.storage;

import net.minecraft.world.chunk.storage.*;
import java.io.*;
import net.minecraft.nbt.*;
import net.minecraft.world.*;

public class SaveHandlerMP implements ISaveHandler
{
    static {
        __OBFID = "CL_00000602";
    }
    
    @Override
    public IChunkLoader getChunkLoader(final WorldProvider llllllllllllllIllIIIIlIlllllIIIl) {
        return null;
    }
    
    @Override
    public void flush() {
    }
    
    @Override
    public void saveWorldInfo(final WorldInfo llllllllllllllIllIIIIlIllllIllII) {
    }
    
    @Override
    public File getMapFileFromName(final String llllllllllllllIllIIIIlIllllIlIII) {
        return null;
    }
    
    @Override
    public void saveWorldInfoWithPlayer(final WorldInfo llllllllllllllIllIIIIlIllllIllll, final NBTTagCompound llllllllllllllIllIIIIlIllllIlllI) {
    }
    
    @Override
    public File getWorldDirectory() {
        return null;
    }
    
    @Override
    public void checkSessionLock() throws MinecraftException {
    }
    
    @Override
    public String getWorldDirectoryName() {
        return "none";
    }
    
    @Override
    public IPlayerFileData getPlayerNBTManager() {
        return null;
    }
    
    @Override
    public WorldInfo loadWorldInfo() {
        return null;
    }
}
