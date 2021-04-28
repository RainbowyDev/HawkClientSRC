package net.minecraft.world.chunk.storage;

import org.apache.logging.log4j.*;
import net.minecraft.util.*;
import com.google.common.collect.*;
import net.minecraft.world.*;
import net.minecraft.world.biome.*;
import net.minecraft.nbt.*;
import org.apache.commons.lang3.*;
import net.minecraft.world.storage.*;
import net.minecraft.client.*;
import java.io.*;
import java.util.*;

public class AnvilSaveConverter extends SaveFormatOld
{
    private static final /* synthetic */ Logger logger;
    
    static {
        __OBFID = "CL_00000582";
        logger = LogManager.getLogger();
    }
    
    private void convertFile(final File llllllllllllllllllIIIlIllIllIIll, final Iterable llllllllllllllllllIIIlIllIlIlIII, final WorldChunkManager llllllllllllllllllIIIlIllIllIIIl, int llllllllllllllllllIIIlIllIlIIllI, final int llllllllllllllllllIIIlIllIlIllll, final IProgressUpdate llllllllllllllllllIIIlIllIlIIlII) {
        for (final File llllllllllllllllllIIIlIllIlIllII : llllllllllllllllllIIIlIllIlIlIII) {
            this.convertChunks(llllllllllllllllllIIIlIllIllIIll, llllllllllllllllllIIIlIllIlIllII, llllllllllllllllllIIIlIllIllIIIl, llllllllllllllllllIIIlIllIlIIllI, llllllllllllllllllIIIlIllIlIllll, llllllllllllllllllIIIlIllIlIIlII);
            ++llllllllllllllllllIIIlIllIlIIllI;
            final int llllllllllllllllllIIIlIllIlIlIll = (int)Math.round(100.0 * llllllllllllllllllIIIlIllIlIIllI / llllllllllllllllllIIIlIllIlIllll);
            llllllllllllllllllIIIlIllIlIIlII.setLoadingProgress(llllllllllllllllllIIIlIllIlIlIll);
        }
    }
    
    protected int getSaveVersion() {
        return 19133;
    }
    
    private void createFile(final String llllllllllllllllllIIIlIlllIIIlll) {
        final File llllllllllllllllllIIIlIlllIIIllI = new File(this.savesDirectory, llllllllllllllllllIIIlIlllIIIlll);
        if (!llllllllllllllllllIIIlIlllIIIllI.exists()) {
            AnvilSaveConverter.logger.warn("Unable to create level.dat_mcr backup");
        }
        else {
            final File llllllllllllllllllIIIlIlllIIIlIl = new File(llllllllllllllllllIIIlIlllIIIllI, "level.dat");
            if (!llllllllllllllllllIIIlIlllIIIlIl.exists()) {
                AnvilSaveConverter.logger.warn("Unable to create level.dat_mcr backup");
            }
            else {
                final File llllllllllllllllllIIIlIlllIIIlII = new File(llllllllllllllllllIIIlIlllIIIllI, "level.dat_mcr");
                if (!llllllllllllllllllIIIlIlllIIIlIl.renameTo(llllllllllllllllllIIIlIlllIIIlII)) {
                    AnvilSaveConverter.logger.warn("Unable to create level.dat_mcr backup");
                }
            }
        }
    }
    
    public AnvilSaveConverter(final File llllllllllllllllllIIIllIIIlllIIl) {
        super(llllllllllllllllllIIIllIIIlllIIl);
    }
    
    @Override
    public ISaveHandler getSaveLoader(final String llllllllllllllllllIIIllIIIIIlIII, final boolean llllllllllllllllllIIIllIIIIIlIlI) {
        return new AnvilSaveHandler(this.savesDirectory, llllllllllllllllllIIIllIIIIIlIII, llllllllllllllllllIIIllIIIIIlIlI);
    }
    
    @Override
    public boolean func_154334_a(final String llllllllllllllllllIIIlIlllllllll) {
        final WorldInfo llllllllllllllllllIIIllIIIIIIIIl = this.getWorldInfo(llllllllllllllllllIIIlIlllllllll);
        return llllllllllllllllllIIIllIIIIIIIIl != null && llllllllllllllllllIIIllIIIIIIIIl.getSaveVersion() == 19132;
    }
    
    @Override
    public String func_154333_a() {
        return "Anvil";
    }
    
    @Override
    public boolean convertMapFormat(final String llllllllllllllllllIIIlIllllIIllI, final IProgressUpdate llllllllllllllllllIIIlIllllIIlIl) {
        llllllllllllllllllIIIlIllllIIlIl.setLoadingProgress(0);
        final ArrayList llllllllllllllllllIIIlIllllIIlII = Lists.newArrayList();
        final ArrayList llllllllllllllllllIIIlIllllIIIll = Lists.newArrayList();
        final ArrayList llllllllllllllllllIIIlIllllIIIlI = Lists.newArrayList();
        final File llllllllllllllllllIIIlIllllIIIIl = new File(this.savesDirectory, llllllllllllllllllIIIlIllllIIllI);
        final File llllllllllllllllllIIIlIllllIIIII = new File(llllllllllllllllllIIIlIllllIIIIl, "DIM-1");
        final File llllllllllllllllllIIIlIlllIlllll = new File(llllllllllllllllllIIIlIllllIIIIl, "DIM1");
        AnvilSaveConverter.logger.info("Scanning folders...");
        this.addRegionFilesToCollection(llllllllllllllllllIIIlIllllIIIIl, llllllllllllllllllIIIlIllllIIlII);
        if (llllllllllllllllllIIIlIllllIIIII.exists()) {
            this.addRegionFilesToCollection(llllllllllllllllllIIIlIllllIIIII, llllllllllllllllllIIIlIllllIIIll);
        }
        if (llllllllllllllllllIIIlIlllIlllll.exists()) {
            this.addRegionFilesToCollection(llllllllllllllllllIIIlIlllIlllll, llllllllllllllllllIIIlIllllIIIlI);
        }
        final int llllllllllllllllllIIIlIlllIllllI = llllllllllllllllllIIIlIllllIIlII.size() + llllllllllllllllllIIIlIllllIIIll.size() + llllllllllllllllllIIIlIllllIIIlI.size();
        AnvilSaveConverter.logger.info(String.valueOf(new StringBuilder("Total conversion count is ").append(llllllllllllllllllIIIlIlllIllllI)));
        final WorldInfo llllllllllllllllllIIIlIlllIlllIl = this.getWorldInfo(llllllllllllllllllIIIlIllllIIllI);
        Object llllllllllllllllllIIIlIlllIlllII = null;
        if (llllllllllllllllllIIIlIlllIlllIl.getTerrainType() == WorldType.FLAT) {
            llllllllllllllllllIIIlIlllIlllII = new WorldChunkManagerHell(BiomeGenBase.plains, 0.5f);
        }
        else {
            llllllllllllllllllIIIlIlllIlllII = new WorldChunkManager(llllllllllllllllllIIIlIlllIlllIl.getSeed(), llllllllllllllllllIIIlIlllIlllIl.getTerrainType(), llllllllllllllllllIIIlIlllIlllIl.getGeneratorOptions());
        }
        this.convertFile(new File(llllllllllllllllllIIIlIllllIIIIl, "region"), llllllllllllllllllIIIlIllllIIlII, (WorldChunkManager)llllllllllllllllllIIIlIlllIlllII, 0, llllllllllllllllllIIIlIlllIllllI, llllllllllllllllllIIIlIllllIIlIl);
        this.convertFile(new File(llllllllllllllllllIIIlIllllIIIII, "region"), llllllllllllllllllIIIlIllllIIIll, new WorldChunkManagerHell(BiomeGenBase.hell, 0.0f), llllllllllllllllllIIIlIllllIIlII.size(), llllllllllllllllllIIIlIlllIllllI, llllllllllllllllllIIIlIllllIIlIl);
        this.convertFile(new File(llllllllllllllllllIIIlIlllIlllll, "region"), llllllllllllllllllIIIlIllllIIIlI, new WorldChunkManagerHell(BiomeGenBase.sky, 0.0f), llllllllllllllllllIIIlIllllIIlII.size() + llllllllllllllllllIIIlIllllIIIll.size(), llllllllllllllllllIIIlIlllIllllI, llllllllllllllllllIIIlIllllIIlIl);
        llllllllllllllllllIIIlIlllIlllIl.setSaveVersion(19133);
        if (llllllllllllllllllIIIlIlllIlllIl.getTerrainType() == WorldType.DEFAULT_1_1) {
            llllllllllllllllllIIIlIlllIlllIl.setTerrainType(WorldType.DEFAULT);
        }
        this.createFile(llllllllllllllllllIIIlIllllIIllI);
        final ISaveHandler llllllllllllllllllIIIlIlllIllIll = this.getSaveLoader(llllllllllllllllllIIIlIllllIIllI, false);
        llllllllllllllllllIIIlIlllIllIll.saveWorldInfo(llllllllllllllllllIIIlIlllIlllIl);
        return true;
    }
    
    @Override
    public void flushCache() {
        RegionFileCache.clearRegionFileReferences();
    }
    
    private void convertChunks(final File llllllllllllllllllIIIlIllIIIllIl, final File llllllllllllllllllIIIlIllIIIllII, final WorldChunkManager llllllllllllllllllIIIlIlIlllIlll, final int llllllllllllllllllIIIlIllIIIlIlI, final int llllllllllllllllllIIIlIllIIIlIIl, final IProgressUpdate llllllllllllllllllIIIlIlIlllIlII) {
        try {
            final String llllllllllllllllllIIIlIllIIIIlll = llllllllllllllllllIIIlIllIIIllII.getName();
            final RegionFile llllllllllllllllllIIIlIllIIIIllI = new RegionFile(llllllllllllllllllIIIlIllIIIllII);
            final RegionFile llllllllllllllllllIIIlIllIIIIlIl = new RegionFile(new File(llllllllllllllllllIIIlIllIIIllIl, String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllllIIIlIllIIIIlll.substring(0, llllllllllllllllllIIIlIllIIIIlll.length() - ".mcr".length()))).append(".mca"))));
            for (int llllllllllllllllllIIIlIllIIIIlII = 0; llllllllllllllllllIIIlIllIIIIlII < 32; ++llllllllllllllllllIIIlIllIIIIlII) {
                for (int llllllllllllllllllIIIlIllIIIIIll = 0; llllllllllllllllllIIIlIllIIIIIll < 32; ++llllllllllllllllllIIIlIllIIIIIll) {
                    if (llllllllllllllllllIIIlIllIIIIllI.isChunkSaved(llllllllllllllllllIIIlIllIIIIlII, llllllllllllllllllIIIlIllIIIIIll) && !llllllllllllllllllIIIlIllIIIIlIl.isChunkSaved(llllllllllllllllllIIIlIllIIIIlII, llllllllllllllllllIIIlIllIIIIIll)) {
                        final DataInputStream llllllllllllllllllIIIlIllIIIIIlI = llllllllllllllllllIIIlIllIIIIllI.getChunkDataInputStream(llllllllllllllllllIIIlIllIIIIlII, llllllllllllllllllIIIlIllIIIIIll);
                        if (llllllllllllllllllIIIlIllIIIIIlI == null) {
                            AnvilSaveConverter.logger.warn("Failed to fetch input stream");
                        }
                        else {
                            final NBTTagCompound llllllllllllllllllIIIlIllIIIIIIl = CompressedStreamTools.read(llllllllllllllllllIIIlIllIIIIIlI);
                            llllllllllllllllllIIIlIllIIIIIlI.close();
                            final NBTTagCompound llllllllllllllllllIIIlIllIIIIIII = llllllllllllllllllIIIlIllIIIIIIl.getCompoundTag("Level");
                            final ChunkLoader.AnvilConverterData llllllllllllllllllIIIlIlIlllllll = ChunkLoader.load(llllllllllllllllllIIIlIllIIIIIII);
                            final NBTTagCompound llllllllllllllllllIIIlIlIllllllI = new NBTTagCompound();
                            final NBTTagCompound llllllllllllllllllIIIlIlIlllllIl = new NBTTagCompound();
                            llllllllllllllllllIIIlIlIllllllI.setTag("Level", llllllllllllllllllIIIlIlIlllllIl);
                            ChunkLoader.convertToAnvilFormat(llllllllllllllllllIIIlIlIlllllll, llllllllllllllllllIIIlIlIlllllIl, llllllllllllllllllIIIlIlIlllIlll);
                            final DataOutputStream llllllllllllllllllIIIlIlIlllllII = llllllllllllllllllIIIlIllIIIIlIl.getChunkDataOutputStream(llllllllllllllllllIIIlIllIIIIlII, llllllllllllllllllIIIlIllIIIIIll);
                            CompressedStreamTools.write(llllllllllllllllllIIIlIlIllllllI, llllllllllllllllllIIIlIlIlllllII);
                            llllllllllllllllllIIIlIlIlllllII.close();
                        }
                    }
                }
                int llllllllllllllllllIIIlIllIIIIIll = (int)Math.round(100.0 * (llllllllllllllllllIIIlIllIIIlIlI * 1024) / (llllllllllllllllllIIIlIllIIIlIIl * 1024));
                final int llllllllllllllllllIIIlIlIllllIll = (int)Math.round(100.0 * ((llllllllllllllllllIIIlIllIIIIlII + 1) * 32 + llllllllllllllllllIIIlIllIIIlIlI * 1024) / (llllllllllllllllllIIIlIllIIIlIIl * 1024));
                if (llllllllllllllllllIIIlIlIllllIll > llllllllllllllllllIIIlIllIIIIIll) {
                    llllllllllllllllllIIIlIlIlllIlII.setLoadingProgress(llllllllllllllllllIIIlIlIllllIll);
                }
            }
            llllllllllllllllllIIIlIllIIIIllI.close();
            llllllllllllllllllIIIlIllIIIIlIl.close();
        }
        catch (IOException llllllllllllllllllIIIlIlIllllIlI) {
            llllllllllllllllllIIIlIlIllllIlI.printStackTrace();
        }
    }
    
    @Override
    public boolean isOldMapFormat(final String llllllllllllllllllIIIlIllllllIIl) {
        final WorldInfo llllllllllllllllllIIIlIllllllIII = this.getWorldInfo(llllllllllllllllllIIIlIllllllIIl);
        return llllllllllllllllllIIIlIllllllIII != null && llllllllllllllllllIIIlIllllllIII.getSaveVersion() != this.getSaveVersion();
    }
    
    @Override
    public List getSaveList() throws AnvilConverterException {
        if (this.savesDirectory != null && this.savesDirectory.exists() && this.savesDirectory.isDirectory()) {
            final ArrayList llllllllllllllllllIIIllIIIlIlIII = Lists.newArrayList();
            final File[] llllllllllllllllllIIIllIIIlIIllI;
            final File[] llllllllllllllllllIIIllIIIlIIlll = llllllllllllllllllIIIllIIIlIIllI = this.savesDirectory.listFiles();
            for (int llllllllllllllllllIIIllIIIlIIlIl = llllllllllllllllllIIIllIIIlIIlll.length, llllllllllllllllllIIIllIIIlIIlII = 0; llllllllllllllllllIIIllIIIlIIlII < llllllllllllllllllIIIllIIIlIIlIl; ++llllllllllllllllllIIIllIIIlIIlII) {
                final File llllllllllllllllllIIIllIIIlIIIll = llllllllllllllllllIIIllIIIlIIllI[llllllllllllllllllIIIllIIIlIIlII];
                if (llllllllllllllllllIIIllIIIlIIIll.isDirectory()) {
                    final String llllllllllllllllllIIIllIIIlIIIlI = llllllllllllllllllIIIllIIIlIIIll.getName();
                    final WorldInfo llllllllllllllllllIIIllIIIlIIIIl = this.getWorldInfo(llllllllllllllllllIIIllIIIlIIIlI);
                    if (llllllllllllllllllIIIllIIIlIIIIl != null && (llllllllllllllllllIIIllIIIlIIIIl.getSaveVersion() == 19132 || llllllllllllllllllIIIllIIIlIIIIl.getSaveVersion() == 19133)) {
                        final boolean llllllllllllllllllIIIllIIIlIIIII = llllllllllllllllllIIIllIIIlIIIIl.getSaveVersion() != this.getSaveVersion();
                        String llllllllllllllllllIIIllIIIIlllll = llllllllllllllllllIIIllIIIlIIIIl.getWorldName();
                        if (StringUtils.isEmpty((CharSequence)llllllllllllllllllIIIllIIIIlllll)) {
                            llllllllllllllllllIIIllIIIIlllll = llllllllllllllllllIIIllIIIlIIIlI;
                        }
                        final long llllllllllllllllllIIIllIIIIllllI = 0L;
                        llllllllllllllllllIIIllIIIlIlIII.add(new SaveFormatComparator(llllllllllllllllllIIIllIIIlIIIlI, llllllllllllllllllIIIllIIIIlllll, llllllllllllllllllIIIllIIIlIIIIl.getLastTimePlayed(), llllllllllllllllllIIIllIIIIllllI, llllllllllllllllllIIIllIIIlIIIIl.getGameType(), llllllllllllllllllIIIllIIIlIIIII, llllllllllllllllllIIIllIIIlIIIIl.isHardcoreModeEnabled(), llllllllllllllllllIIIllIIIlIIIIl.areCommandsAllowed()));
                    }
                }
            }
            return llllllllllllllllllIIIllIIIlIlIII;
        }
        throw new AnvilConverterException("Unable to read or access folder where game worlds are saved!");
    }
    
    private void addRegionFilesToCollection(final File llllllllllllllllllIIIlIlIlIlllII, final Collection llllllllllllllllllIIIlIlIllIIIII) {
        final File llllllllllllllllllIIIlIlIlIlllll = new File(llllllllllllllllllIIIlIlIlIlllII, "region");
        final File[] llllllllllllllllllIIIlIlIlIllllI = llllllllllllllllllIIIlIlIlIlllll.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(final File llllllllllllllIIlIIIlIllIlIlIIll, final String llllllllllllllIIlIIIlIllIlIlIIIl) {
                return llllllllllllllIIlIIIlIllIlIlIIIl.endsWith(".mcr");
            }
            
            static {
                __OBFID = "CL_00000583";
            }
        });
        if (llllllllllllllllllIIIlIlIlIllllI != null) {
            Collections.addAll(llllllllllllllllllIIIlIlIllIIIII, llllllllllllllllllIIIlIlIlIllllI);
        }
    }
}
