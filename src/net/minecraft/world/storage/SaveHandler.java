package net.minecraft.world.storage;

import net.minecraft.entity.player.*;
import net.minecraft.world.chunk.storage.*;
import net.minecraft.world.*;
import net.minecraft.nbt.*;
import java.io.*;
import net.minecraft.server.*;
import org.apache.logging.log4j.*;

public class SaveHandler implements IPlayerFileData, ISaveHandler
{
    private final /* synthetic */ File playersDirectory;
    private final /* synthetic */ File mapDataDir;
    private static final /* synthetic */ Logger logger;
    private final /* synthetic */ File worldDirectory;
    private final /* synthetic */ String saveDirectoryName;
    private final /* synthetic */ long initializationTime;
    
    @Override
    public String getWorldDirectoryName() {
        return this.saveDirectoryName;
    }
    
    @Override
    public void writePlayerData(final EntityPlayer lllllllllllllllIlIIIIlIllIIIIIII) {
        try {
            final NBTTagCompound lllllllllllllllIlIIIIlIlIlllllll = new NBTTagCompound();
            lllllllllllllllIlIIIIlIllIIIIIII.writeToNBT(lllllllllllllllIlIIIIlIlIlllllll);
            final File lllllllllllllllIlIIIIlIlIllllllI = new File(this.playersDirectory, String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIlIllIIIIIII.getUniqueID().toString())).append(".dat.tmp")));
            final File lllllllllllllllIlIIIIlIlIlllllIl = new File(this.playersDirectory, String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIlIllIIIIIII.getUniqueID().toString())).append(".dat")));
            CompressedStreamTools.writeCompressed(lllllllllllllllIlIIIIlIlIlllllll, new FileOutputStream(lllllllllllllllIlIIIIlIlIllllllI));
            if (lllllllllllllllIlIIIIlIlIlllllIl.exists()) {
                lllllllllllllllIlIIIIlIlIlllllIl.delete();
            }
            lllllllllllllllIlIIIIlIlIllllllI.renameTo(lllllllllllllllIlIIIIlIlIlllllIl);
        }
        catch (Exception lllllllllllllllIlIIIIlIlIlllllII) {
            SaveHandler.logger.warn(String.valueOf(new StringBuilder("Failed to save player data for ").append(lllllllllllllllIlIIIIlIllIIIIIII.getName())));
        }
    }
    
    @Override
    public IChunkLoader getChunkLoader(final WorldProvider lllllllllllllllIlIIIIlIlllIIlIII) {
        throw new RuntimeException("Old Chunk Storage is no longer supported.");
    }
    
    @Override
    public void flush() {
    }
    
    @Override
    public void checkSessionLock() throws MinecraftException {
        try {
            final File lllllllllllllllIlIIIIlIlllIlIIII = new File(this.worldDirectory, "session.lock");
            final DataInputStream lllllllllllllllIlIIIIlIlllIIllll = new DataInputStream(new FileInputStream(lllllllllllllllIlIIIIlIlllIlIIII));
            try {
                if (lllllllllllllllIlIIIIlIlllIIllll.readLong() != this.initializationTime) {
                    throw new MinecraftException("The save is being accessed from another location, aborting");
                }
            }
            finally {
                lllllllllllllllIlIIIIlIlllIIllll.close();
            }
            lllllllllllllllIlIIIIlIlllIIllll.close();
        }
        catch (IOException lllllllllllllllIlIIIIlIlllIIlllI) {
            throw new MinecraftException("Failed to check session lock, aborting");
        }
    }
    
    @Override
    public NBTTagCompound readPlayerData(final EntityPlayer lllllllllllllllIlIIIIlIlIlllIIIl) {
        NBTTagCompound lllllllllllllllIlIIIIlIlIlllIIII = null;
        try {
            final File lllllllllllllllIlIIIIlIlIllIllll = new File(this.playersDirectory, String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIlIlIlllIIIl.getUniqueID().toString())).append(".dat")));
            if (lllllllllllllllIlIIIIlIlIllIllll.exists() && lllllllllllllllIlIIIIlIlIllIllll.isFile()) {
                lllllllllllllllIlIIIIlIlIlllIIII = CompressedStreamTools.readCompressed(new FileInputStream(lllllllllllllllIlIIIIlIlIllIllll));
            }
        }
        catch (Exception lllllllllllllllIlIIIIlIlIllIlllI) {
            SaveHandler.logger.warn(String.valueOf(new StringBuilder("Failed to load player data for ").append(lllllllllllllllIlIIIIlIlIlllIIIl.getName())));
        }
        if (lllllllllllllllIlIIIIlIlIlllIIII != null) {
            lllllllllllllllIlIIIIlIlIlllIIIl.readFromNBT(lllllllllllllllIlIIIIlIlIlllIIII);
        }
        return lllllllllllllllIlIIIIlIlIlllIIII;
    }
    
    @Override
    public String[] getAvailablePlayerDat() {
        String[] lllllllllllllllIlIIIIlIlIllIIIlI = this.playersDirectory.list();
        if (lllllllllllllllIlIIIIlIlIllIIIlI == null) {
            lllllllllllllllIlIIIIlIlIllIIIlI = new String[0];
        }
        for (int lllllllllllllllIlIIIIlIlIllIIIIl = 0; lllllllllllllllIlIIIIlIlIllIIIIl < lllllllllllllllIlIIIIlIlIllIIIlI.length; ++lllllllllllllllIlIIIIlIlIllIIIIl) {
            if (lllllllllllllllIlIIIIlIlIllIIIlI[lllllllllllllllIlIIIIlIlIllIIIIl].endsWith(".dat")) {
                lllllllllllllllIlIIIIlIlIllIIIlI[lllllllllllllllIlIIIIlIlIllIIIIl] = lllllllllllllllIlIIIIlIlIllIIIlI[lllllllllllllllIlIIIIlIlIllIIIIl].substring(0, lllllllllllllllIlIIIIlIlIllIIIlI[lllllllllllllllIlIIIIlIlIllIIIIl].length() - 4);
            }
        }
        return lllllllllllllllIlIIIIlIlIllIIIlI;
    }
    
    @Override
    public void saveWorldInfoWithPlayer(final WorldInfo lllllllllllllllIlIIIIlIllIlIIIll, final NBTTagCompound lllllllllllllllIlIIIIlIllIlIIIlI) {
        final NBTTagCompound lllllllllllllllIlIIIIlIllIlIlIlI = lllllllllllllllIlIIIIlIllIlIIIll.cloneNBTCompound(lllllllllllllllIlIIIIlIllIlIIIlI);
        final NBTTagCompound lllllllllllllllIlIIIIlIllIlIlIIl = new NBTTagCompound();
        lllllllllllllllIlIIIIlIllIlIlIIl.setTag("Data", lllllllllllllllIlIIIIlIllIlIlIlI);
        try {
            final File lllllllllllllllIlIIIIlIllIlIlIII = new File(this.worldDirectory, "level.dat_new");
            final File lllllllllllllllIlIIIIlIllIlIIlll = new File(this.worldDirectory, "level.dat_old");
            final File lllllllllllllllIlIIIIlIllIlIIllI = new File(this.worldDirectory, "level.dat");
            CompressedStreamTools.writeCompressed(lllllllllllllllIlIIIIlIllIlIlIIl, new FileOutputStream(lllllllllllllllIlIIIIlIllIlIlIII));
            if (lllllllllllllllIlIIIIlIllIlIIlll.exists()) {
                lllllllllllllllIlIIIIlIllIlIIlll.delete();
            }
            lllllllllllllllIlIIIIlIllIlIIllI.renameTo(lllllllllllllllIlIIIIlIllIlIIlll);
            if (lllllllllllllllIlIIIIlIllIlIIllI.exists()) {
                lllllllllllllllIlIIIIlIllIlIIllI.delete();
            }
            lllllllllllllllIlIIIIlIllIlIlIII.renameTo(lllllllllllllllIlIIIIlIllIlIIllI);
            if (lllllllllllllllIlIIIIlIllIlIlIII.exists()) {
                lllllllllllllllIlIIIIlIllIlIlIII.delete();
            }
        }
        catch (Exception lllllllllllllllIlIIIIlIllIlIIlIl) {
            lllllllllllllllIlIIIIlIllIlIIlIl.printStackTrace();
        }
    }
    
    private void setSessionLock() {
        try {
            final File lllllllllllllllIlIIIIlIlllIlllll = new File(this.worldDirectory, "session.lock");
            final DataOutputStream lllllllllllllllIlIIIIlIlllIllllI = new DataOutputStream(new FileOutputStream(lllllllllllllllIlIIIIlIlllIlllll));
            try {
                lllllllllllllllIlIIIIlIlllIllllI.writeLong(this.initializationTime);
            }
            finally {
                lllllllllllllllIlIIIIlIlllIllllI.close();
            }
            lllllllllllllllIlIIIIlIlllIllllI.close();
        }
        catch (IOException lllllllllllllllIlIIIIlIlllIlllIl) {
            lllllllllllllllIlIIIIlIlllIlllIl.printStackTrace();
            throw new RuntimeException("Failed to check session lock, aborting");
        }
    }
    
    public SaveHandler(final File lllllllllllllllIlIIIIlIllllIIlll, final String lllllllllllllllIlIIIIlIllllIlIlI, final boolean lllllllllllllllIlIIIIlIllllIIlIl) {
        this.initializationTime = MinecraftServer.getCurrentTimeMillis();
        this.worldDirectory = new File(lllllllllllllllIlIIIIlIllllIIlll, lllllllllllllllIlIIIIlIllllIlIlI);
        this.worldDirectory.mkdirs();
        this.playersDirectory = new File(this.worldDirectory, "playerdata");
        this.mapDataDir = new File(this.worldDirectory, "data");
        this.mapDataDir.mkdirs();
        this.saveDirectoryName = lllllllllllllllIlIIIIlIllllIlIlI;
        if (lllllllllllllllIlIIIIlIllllIIlIl) {
            this.playersDirectory.mkdirs();
        }
        this.setSessionLock();
    }
    
    @Override
    public File getMapFileFromName(final String lllllllllllllllIlIIIIlIlIlIllIIl) {
        return new File(this.mapDataDir, String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIIIlIlIlIllIIl)).append(".dat")));
    }
    
    @Override
    public IPlayerFileData getPlayerNBTManager() {
        return this;
    }
    
    static {
        __OBFID = "CL_00000585";
        logger = LogManager.getLogger();
    }
    
    @Override
    public void saveWorldInfo(final WorldInfo lllllllllllllllIlIIIIlIllIIlIlII) {
        final NBTTagCompound lllllllllllllllIlIIIIlIllIIlIIll = lllllllllllllllIlIIIIlIllIIlIlII.getNBTTagCompound();
        final NBTTagCompound lllllllllllllllIlIIIIlIllIIlIIlI = new NBTTagCompound();
        lllllllllllllllIlIIIIlIllIIlIIlI.setTag("Data", lllllllllllllllIlIIIIlIllIIlIIll);
        try {
            final File lllllllllllllllIlIIIIlIllIIlIIIl = new File(this.worldDirectory, "level.dat_new");
            final File lllllllllllllllIlIIIIlIllIIlIIII = new File(this.worldDirectory, "level.dat_old");
            final File lllllllllllllllIlIIIIlIllIIIllll = new File(this.worldDirectory, "level.dat");
            CompressedStreamTools.writeCompressed(lllllllllllllllIlIIIIlIllIIlIIlI, new FileOutputStream(lllllllllllllllIlIIIIlIllIIlIIIl));
            if (lllllllllllllllIlIIIIlIllIIlIIII.exists()) {
                lllllllllllllllIlIIIIlIllIIlIIII.delete();
            }
            lllllllllllllllIlIIIIlIllIIIllll.renameTo(lllllllllllllllIlIIIIlIllIIlIIII);
            if (lllllllllllllllIlIIIIlIllIIIllll.exists()) {
                lllllllllllllllIlIIIIlIllIIIllll.delete();
            }
            lllllllllllllllIlIIIIlIllIIlIIIl.renameTo(lllllllllllllllIlIIIIlIllIIIllll);
            if (lllllllllllllllIlIIIIlIllIIlIIIl.exists()) {
                lllllllllllllllIlIIIIlIllIIlIIIl.delete();
            }
        }
        catch (Exception lllllllllllllllIlIIIIlIllIIIlllI) {
            lllllllllllllllIlIIIIlIllIIIlllI.printStackTrace();
        }
    }
    
    @Override
    public File getWorldDirectory() {
        return this.worldDirectory;
    }
    
    @Override
    public WorldInfo loadWorldInfo() {
        File lllllllllllllllIlIIIIlIlllIIIIIl = new File(this.worldDirectory, "level.dat");
        if (lllllllllllllllIlIIIIlIlllIIIIIl.exists()) {
            try {
                final NBTTagCompound lllllllllllllllIlIIIIlIlllIIIIII = CompressedStreamTools.readCompressed(new FileInputStream(lllllllllllllllIlIIIIlIlllIIIIIl));
                final NBTTagCompound lllllllllllllllIlIIIIlIllIlllllI = lllllllllllllllIlIIIIlIlllIIIIII.getCompoundTag("Data");
                return new WorldInfo(lllllllllllllllIlIIIIlIllIlllllI);
            }
            catch (Exception lllllllllllllllIlIIIIlIllIllllII) {
                lllllllllllllllIlIIIIlIllIllllII.printStackTrace();
            }
        }
        lllllllllllllllIlIIIIlIlllIIIIIl = new File(this.worldDirectory, "level.dat_old");
        if (lllllllllllllllIlIIIIlIlllIIIIIl.exists()) {
            try {
                final NBTTagCompound lllllllllllllllIlIIIIlIllIllllll = CompressedStreamTools.readCompressed(new FileInputStream(lllllllllllllllIlIIIIlIlllIIIIIl));
                final NBTTagCompound lllllllllllllllIlIIIIlIllIllllIl = lllllllllllllllIlIIIIlIllIllllll.getCompoundTag("Data");
                return new WorldInfo(lllllllllllllllIlIIIIlIllIllllIl);
            }
            catch (Exception lllllllllllllllIlIIIIlIllIlllIll) {
                lllllllllllllllIlIIIIlIllIlllIll.printStackTrace();
            }
        }
        return null;
    }
}
