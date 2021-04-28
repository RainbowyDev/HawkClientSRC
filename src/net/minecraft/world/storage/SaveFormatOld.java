package net.minecraft.world.storage;

import java.io.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;
import com.google.common.collect.*;
import java.util.*;
import net.minecraft.client.*;
import org.apache.logging.log4j.*;

public class SaveFormatOld implements ISaveFormat
{
    protected final /* synthetic */ File savesDirectory;
    private static final /* synthetic */ Logger logger;
    
    @Override
    public boolean func_154335_d(final String lllllllllllllllIlIlIlIllIIlIIIII) {
        final File lllllllllllllllIlIlIlIllIIlIIIll = new File(this.savesDirectory, lllllllllllllllIlIlIlIllIIlIIIII);
        if (lllllllllllllllIlIlIlIllIIlIIIll.exists()) {
            return false;
        }
        try {
            lllllllllllllllIlIlIlIllIIlIIIll.mkdir();
            lllllllllllllllIlIlIlIllIIlIIIll.delete();
            return true;
        }
        catch (Throwable lllllllllllllllIlIlIlIllIIlIIIlI) {
            SaveFormatOld.logger.warn("Couldn't make new level", lllllllllllllllIlIlIlIllIIlIIIlI);
            return false;
        }
    }
    
    @Override
    public void renameWorld(final String lllllllllllllllIlIlIlIllIIllIlll, final String lllllllllllllllIlIlIlIllIIlIlllI) {
        final File lllllllllllllllIlIlIlIllIIllIlIl = new File(this.savesDirectory, lllllllllllllllIlIlIlIllIIllIlll);
        if (lllllllllllllllIlIlIlIllIIllIlIl.exists()) {
            final File lllllllllllllllIlIlIlIllIIllIlII = new File(lllllllllllllllIlIlIlIllIIllIlIl, "level.dat");
            if (lllllllllllllllIlIlIlIllIIllIlII.exists()) {
                try {
                    final NBTTagCompound lllllllllllllllIlIlIlIllIIllIIll = CompressedStreamTools.readCompressed(new FileInputStream(lllllllllllllllIlIlIlIllIIllIlII));
                    final NBTTagCompound lllllllllllllllIlIlIlIllIIllIIlI = lllllllllllllllIlIlIlIllIIllIIll.getCompoundTag("Data");
                    lllllllllllllllIlIlIlIllIIllIIlI.setString("LevelName", lllllllllllllllIlIlIlIllIIlIlllI);
                    CompressedStreamTools.writeCompressed(lllllllllllllllIlIlIlIllIIllIIll, new FileOutputStream(lllllllllllllllIlIlIlIllIIllIlII));
                }
                catch (Exception lllllllllllllllIlIlIlIllIIllIIIl) {
                    lllllllllllllllIlIlIlIllIIllIIIl.printStackTrace();
                }
            }
        }
    }
    
    @Override
    public ISaveHandler getSaveLoader(final String lllllllllllllllIlIlIlIlIllllllll, final boolean lllllllllllllllIlIlIlIllIIIIIIIl) {
        return new SaveHandler(this.savesDirectory, lllllllllllllllIlIlIlIlIllllllll, lllllllllllllllIlIlIlIllIIIIIIIl);
    }
    
    @Override
    public String func_154333_a() {
        return "Old Format";
    }
    
    @Override
    public boolean convertMapFormat(final String lllllllllllllllIlIlIlIlIlllllIII, final IProgressUpdate lllllllllllllllIlIlIlIlIllllIlll) {
        return false;
    }
    
    @Override
    public void flushCache() {
    }
    
    @Override
    public boolean canLoadWorld(final String lllllllllllllllIlIlIlIlIllllIIlI) {
        final File lllllllllllllllIlIlIlIlIllllIIIl = new File(this.savesDirectory, lllllllllllllllIlIlIlIlIllllIIlI);
        return lllllllllllllllIlIlIlIlIllllIIIl.isDirectory();
    }
    
    @Override
    public boolean func_154334_a(final String lllllllllllllllIlIlIlIlIllllllII) {
        return false;
    }
    
    @Override
    public boolean deleteWorldDirectory(final String lllllllllllllllIlIlIlIllIIIlIIll) {
        final File lllllllllllllllIlIlIlIllIIIlIllI = new File(this.savesDirectory, lllllllllllllllIlIlIlIllIIIlIIll);
        if (!lllllllllllllllIlIlIlIllIIIlIllI.exists()) {
            return true;
        }
        SaveFormatOld.logger.info(String.valueOf(new StringBuilder("Deleting level ").append(lllllllllllllllIlIlIlIllIIIlIIll)));
        for (int lllllllllllllllIlIlIlIllIIIlIlIl = 1; lllllllllllllllIlIlIlIllIIIlIlIl <= 5; ++lllllllllllllllIlIlIlIllIIIlIlIl) {
            SaveFormatOld.logger.info(String.valueOf(new StringBuilder("Attempt ").append(lllllllllllllllIlIlIlIllIIIlIlIl).append("...")));
            if (deleteFiles(lllllllllllllllIlIlIlIllIIIlIllI.listFiles())) {
                break;
            }
            SaveFormatOld.logger.warn("Unsuccessful in deleting contents.");
            if (lllllllllllllllIlIlIlIllIIIlIlIl < 5) {
                try {
                    Thread.sleep(500L);
                }
                catch (InterruptedException ex) {}
            }
        }
        return lllllllllllllllIlIlIlIllIIIlIllI.delete();
    }
    
    @Override
    public boolean isOldMapFormat(final String lllllllllllllllIlIlIlIlIlllllIlI) {
        return false;
    }
    
    @Override
    public List getSaveList() throws AnvilConverterException {
        final ArrayList lllllllllllllllIlIlIlIllIllIIIIl = Lists.newArrayList();
        for (int lllllllllllllllIlIlIlIllIllIIIII = 0; lllllllllllllllIlIlIlIllIllIIIII < 5; ++lllllllllllllllIlIlIlIllIllIIIII) {
            final String lllllllllllllllIlIlIlIllIlIlllll = String.valueOf(new StringBuilder("World").append(lllllllllllllllIlIlIlIllIllIIIII + 1));
            final WorldInfo lllllllllllllllIlIlIlIllIlIllllI = this.getWorldInfo(lllllllllllllllIlIlIlIllIlIlllll);
            if (lllllllllllllllIlIlIlIllIlIllllI != null) {
                lllllllllllllllIlIlIlIllIllIIIIl.add(new SaveFormatComparator(lllllllllllllllIlIlIlIllIlIlllll, "", lllllllllllllllIlIlIlIllIlIllllI.getLastTimePlayed(), lllllllllllllllIlIlIlIllIlIllllI.getSizeOnDisk(), lllllllllllllllIlIlIlIllIlIllllI.getGameType(), false, lllllllllllllllIlIlIlIllIlIllllI.isHardcoreModeEnabled(), lllllllllllllllIlIlIlIllIlIllllI.areCommandsAllowed()));
            }
        }
        return lllllllllllllllIlIlIlIllIllIIIIl;
    }
    
    protected static boolean deleteFiles(final File[] lllllllllllllllIlIlIlIllIIIIllII) {
        for (int lllllllllllllllIlIlIlIllIIIIlIll = 0; lllllllllllllllIlIlIlIllIIIIlIll < lllllllllllllllIlIlIlIllIIIIllII.length; ++lllllllllllllllIlIlIlIllIIIIlIll) {
            final File lllllllllllllllIlIlIlIllIIIIlIlI = lllllllllllllllIlIlIlIllIIIIllII[lllllllllllllllIlIlIlIllIIIIlIll];
            SaveFormatOld.logger.debug(String.valueOf(new StringBuilder("Deleting ").append(lllllllllllllllIlIlIlIllIIIIlIlI)));
            if (lllllllllllllllIlIlIlIllIIIIlIlI.isDirectory() && !deleteFiles(lllllllllllllllIlIlIlIllIIIIlIlI.listFiles())) {
                SaveFormatOld.logger.warn(String.valueOf(new StringBuilder("Couldn't delete directory ").append(lllllllllllllllIlIlIlIllIIIIlIlI)));
                return false;
            }
            if (!lllllllllllllllIlIlIlIllIIIIlIlI.delete()) {
                SaveFormatOld.logger.warn(String.valueOf(new StringBuilder("Couldn't delete file ").append(lllllllllllllllIlIlIlIllIIIIlIlI)));
                return false;
            }
        }
        return true;
    }
    
    static {
        __OBFID = "CL_00000586";
        logger = LogManager.getLogger();
    }
    
    public SaveFormatOld(final File lllllllllllllllIlIlIlIllIllIlIll) {
        if (!lllllllllllllllIlIlIlIllIllIlIll.exists()) {
            lllllllllllllllIlIlIlIllIllIlIll.mkdirs();
        }
        this.savesDirectory = lllllllllllllllIlIlIlIllIllIlIll;
    }
    
    @Override
    public WorldInfo getWorldInfo(final String lllllllllllllllIlIlIlIllIlIIIlIl) {
        final File lllllllllllllllIlIlIlIllIlIIlllI = new File(this.savesDirectory, lllllllllllllllIlIlIlIllIlIIIlIl);
        if (!lllllllllllllllIlIlIlIllIlIIlllI.exists()) {
            return null;
        }
        File lllllllllllllllIlIlIlIllIlIIllIl = new File(lllllllllllllllIlIlIlIllIlIIlllI, "level.dat");
        if (lllllllllllllllIlIlIlIllIlIIllIl.exists()) {
            try {
                final NBTTagCompound lllllllllllllllIlIlIlIllIlIIllII = CompressedStreamTools.readCompressed(new FileInputStream(lllllllllllllllIlIlIlIllIlIIllIl));
                final NBTTagCompound lllllllllllllllIlIlIlIllIlIIlIlI = lllllllllllllllIlIlIlIllIlIIllII.getCompoundTag("Data");
                return new WorldInfo(lllllllllllllllIlIlIlIllIlIIlIlI);
            }
            catch (Exception lllllllllllllllIlIlIlIllIlIIlIII) {
                SaveFormatOld.logger.error(String.valueOf(new StringBuilder("Exception reading ").append(lllllllllllllllIlIlIlIllIlIIllIl)), (Throwable)lllllllllllllllIlIlIlIllIlIIlIII);
            }
        }
        lllllllllllllllIlIlIlIllIlIIllIl = new File(lllllllllllllllIlIlIlIllIlIIlllI, "level.dat_old");
        if (lllllllllllllllIlIlIlIllIlIIllIl.exists()) {
            try {
                final NBTTagCompound lllllllllllllllIlIlIlIllIlIIlIll = CompressedStreamTools.readCompressed(new FileInputStream(lllllllllllllllIlIlIlIllIlIIllIl));
                final NBTTagCompound lllllllllllllllIlIlIlIllIlIIlIIl = lllllllllllllllIlIlIlIllIlIIlIll.getCompoundTag("Data");
                return new WorldInfo(lllllllllllllllIlIlIlIllIlIIlIIl);
            }
            catch (Exception lllllllllllllllIlIlIlIllIlIIIlll) {
                SaveFormatOld.logger.error(String.valueOf(new StringBuilder("Exception reading ").append(lllllllllllllllIlIlIlIllIlIIllIl)), (Throwable)lllllllllllllllIlIlIlIllIlIIIlll);
            }
        }
        return null;
    }
}
