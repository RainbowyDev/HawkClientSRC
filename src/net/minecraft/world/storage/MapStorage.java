package net.minecraft.world.storage;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.nbt.*;
import com.google.common.collect.*;
import java.io.*;

public class MapStorage
{
    protected /* synthetic */ Map loadedDataMap;
    private /* synthetic */ Map idCounts;
    private /* synthetic */ List loadedDataList;
    private /* synthetic */ ISaveHandler saveHandler;
    
    public WorldSavedData loadData(final Class lllllllllllllllIlIllIIlIIlIlllll, final String lllllllllllllllIlIllIIlIIlIllllI) {
        WorldSavedData lllllllllllllllIlIllIIlIIlIlllIl = this.loadedDataMap.get(lllllllllllllllIlIllIIlIIlIllllI);
        if (lllllllllllllllIlIllIIlIIlIlllIl != null) {
            return lllllllllllllllIlIllIIlIIlIlllIl;
        }
        if (this.saveHandler != null) {
            try {
                final File lllllllllllllllIlIllIIlIIlIlllII = this.saveHandler.getMapFileFromName(lllllllllllllllIlIllIIlIIlIllllI);
                if (lllllllllllllllIlIllIIlIIlIlllII != null && lllllllllllllllIlIllIIlIIlIlllII.exists()) {
                    try {
                        lllllllllllllllIlIllIIlIIlIlllIl = lllllllllllllllIlIllIIlIIlIlllll.getConstructor(String.class).newInstance(lllllllllllllllIlIllIIlIIlIllllI);
                    }
                    catch (Exception lllllllllllllllIlIllIIlIIlIllIll) {
                        throw new RuntimeException(String.valueOf(new StringBuilder("Failed to instantiate ").append(lllllllllllllllIlIllIIlIIlIlllll.toString())), lllllllllllllllIlIllIIlIIlIllIll);
                    }
                    final FileInputStream lllllllllllllllIlIllIIlIIlIllIlI = new FileInputStream(lllllllllllllllIlIllIIlIIlIlllII);
                    final NBTTagCompound lllllllllllllllIlIllIIlIIlIllIIl = CompressedStreamTools.readCompressed(lllllllllllllllIlIllIIlIIlIllIlI);
                    lllllllllllllllIlIllIIlIIlIllIlI.close();
                    lllllllllllllllIlIllIIlIIlIlllIl.readFromNBT(lllllllllllllllIlIllIIlIIlIllIIl.getCompoundTag("data"));
                }
            }
            catch (Exception lllllllllllllllIlIllIIlIIlIllIII) {
                lllllllllllllllIlIllIIlIIlIllIII.printStackTrace();
            }
        }
        if (lllllllllllllllIlIllIIlIIlIlllIl != null) {
            this.loadedDataMap.put(lllllllllllllllIlIllIIlIIlIllllI, lllllllllllllllIlIllIIlIIlIlllIl);
            this.loadedDataList.add(lllllllllllllllIlIllIIlIIlIlllIl);
        }
        return lllllllllllllllIlIllIIlIIlIlllIl;
    }
    
    private void loadIdCounts() {
        try {
            this.idCounts.clear();
            if (this.saveHandler == null) {
                return;
            }
            final File lllllllllllllllIlIllIIlIIIlIIIIl = this.saveHandler.getMapFileFromName("idcounts");
            if (lllllllllllllllIlIllIIlIIIlIIIIl != null && lllllllllllllllIlIllIIlIIIlIIIIl.exists()) {
                final DataInputStream lllllllllllllllIlIllIIlIIIlIIIII = new DataInputStream(new FileInputStream(lllllllllllllllIlIllIIlIIIlIIIIl));
                final NBTTagCompound lllllllllllllllIlIllIIlIIIIlllll = CompressedStreamTools.read(lllllllllllllllIlIllIIlIIIlIIIII);
                lllllllllllllllIlIllIIlIIIlIIIII.close();
                for (final String lllllllllllllllIlIllIIlIIIIlllIl : lllllllllllllllIlIllIIlIIIIlllll.getKeySet()) {
                    final NBTBase lllllllllllllllIlIllIIlIIIIlllII = lllllllllllllllIlIllIIlIIIIlllll.getTag(lllllllllllllllIlIllIIlIIIIlllIl);
                    if (lllllllllllllllIlIllIIlIIIIlllII instanceof NBTTagShort) {
                        final NBTTagShort lllllllllllllllIlIllIIlIIIIllIll = (NBTTagShort)lllllllllllllllIlIllIIlIIIIlllII;
                        final short lllllllllllllllIlIllIIlIIIIllIlI = lllllllllllllllIlIllIIlIIIIllIll.getShort();
                        this.idCounts.put(lllllllllllllllIlIllIIlIIIIlllIl, lllllllllllllllIlIllIIlIIIIllIlI);
                    }
                }
            }
        }
        catch (Exception lllllllllllllllIlIllIIlIIIIllIIl) {
            lllllllllllllllIlIllIIlIIIIllIIl.printStackTrace();
        }
    }
    
    public MapStorage(final ISaveHandler lllllllllllllllIlIllIIlIIllIlIlI) {
        this.loadedDataMap = Maps.newHashMap();
        this.loadedDataList = Lists.newArrayList();
        this.idCounts = Maps.newHashMap();
        this.saveHandler = lllllllllllllllIlIllIIlIIllIlIlI;
        this.loadIdCounts();
    }
    
    private void saveData(final WorldSavedData lllllllllllllllIlIllIIlIIIllIIII) {
        if (this.saveHandler != null) {
            try {
                final File lllllllllllllllIlIllIIlIIIllIllI = this.saveHandler.getMapFileFromName(lllllllllllllllIlIllIIlIIIllIIII.mapName);
                if (lllllllllllllllIlIllIIlIIIllIllI != null) {
                    final NBTTagCompound lllllllllllllllIlIllIIlIIIllIlIl = new NBTTagCompound();
                    lllllllllllllllIlIllIIlIIIllIIII.writeToNBT(lllllllllllllllIlIllIIlIIIllIlIl);
                    final NBTTagCompound lllllllllllllllIlIllIIlIIIllIlII = new NBTTagCompound();
                    lllllllllllllllIlIllIIlIIIllIlII.setTag("data", lllllllllllllllIlIllIIlIIIllIlIl);
                    final FileOutputStream lllllllllllllllIlIllIIlIIIllIIll = new FileOutputStream(lllllllllllllllIlIllIIlIIIllIllI);
                    CompressedStreamTools.writeCompressed(lllllllllllllllIlIllIIlIIIllIlII, lllllllllllllllIlIllIIlIIIllIIll);
                    lllllllllllllllIlIllIIlIIIllIIll.close();
                }
            }
            catch (Exception lllllllllllllllIlIllIIlIIIllIIlI) {
                lllllllllllllllIlIllIIlIIIllIIlI.printStackTrace();
            }
        }
    }
    
    public int getUniqueDataId(final String lllllllllllllllIlIllIIIlllllllII) {
        Short lllllllllllllllIlIllIIlIIIIIIlIl = this.idCounts.get(lllllllllllllllIlIllIIIlllllllII);
        if (lllllllllllllllIlIllIIlIIIIIIlIl == null) {
            lllllllllllllllIlIllIIlIIIIIIlIl = 0;
        }
        else {
            lllllllllllllllIlIllIIlIIIIIIlIl = (short)(lllllllllllllllIlIllIIlIIIIIIlIl + 1);
        }
        this.idCounts.put(lllllllllllllllIlIllIIIlllllllII, lllllllllllllllIlIllIIlIIIIIIlIl);
        if (this.saveHandler == null) {
            return lllllllllllllllIlIllIIlIIIIIIlIl;
        }
        try {
            final File lllllllllllllllIlIllIIlIIIIIIlII = this.saveHandler.getMapFileFromName("idcounts");
            if (lllllllllllllllIlIllIIlIIIIIIlII != null) {
                final NBTTagCompound lllllllllllllllIlIllIIlIIIIIIIll = new NBTTagCompound();
                for (final String lllllllllllllllIlIllIIlIIIIIIIIl : this.idCounts.keySet()) {
                    final short lllllllllllllllIlIllIIlIIIIIIIII = this.idCounts.get(lllllllllllllllIlIllIIlIIIIIIIIl);
                    lllllllllllllllIlIllIIlIIIIIIIll.setShort(lllllllllllllllIlIllIIlIIIIIIIIl, lllllllllllllllIlIllIIlIIIIIIIII);
                }
                final DataOutputStream lllllllllllllllIlIllIIIlllllllll = new DataOutputStream(new FileOutputStream(lllllllllllllllIlIllIIlIIIIIIlII));
                CompressedStreamTools.write(lllllllllllllllIlIllIIlIIIIIIIll, lllllllllllllllIlIllIIIlllllllll);
                lllllllllllllllIlIllIIIlllllllll.close();
            }
        }
        catch (Exception lllllllllllllllIlIllIIIllllllllI) {
            lllllllllllllllIlIllIIIllllllllI.printStackTrace();
        }
        return lllllllllllllllIlIllIIlIIIIIIlIl;
    }
    
    public void setData(final String lllllllllllllllIlIllIIlIIlIIlIIl, final WorldSavedData lllllllllllllllIlIllIIlIIlIIlIll) {
        if (this.loadedDataMap.containsKey(lllllllllllllllIlIllIIlIIlIIlIIl)) {
            this.loadedDataList.remove(this.loadedDataMap.remove(lllllllllllllllIlIllIIlIIlIIlIIl));
        }
        this.loadedDataMap.put(lllllllllllllllIlIllIIlIIlIIlIIl, lllllllllllllllIlIllIIlIIlIIlIll);
        this.loadedDataList.add(lllllllllllllllIlIllIIlIIlIIlIll);
    }
    
    public void saveAllData() {
        for (int lllllllllllllllIlIllIIlIIlIIIIll = 0; lllllllllllllllIlIllIIlIIlIIIIll < this.loadedDataList.size(); ++lllllllllllllllIlIllIIlIIlIIIIll) {
            final WorldSavedData lllllllllllllllIlIllIIlIIlIIIIlI = this.loadedDataList.get(lllllllllllllllIlIllIIlIIlIIIIll);
            if (lllllllllllllllIlIllIIlIIlIIIIlI.isDirty()) {
                this.saveData(lllllllllllllllIlIllIIlIIlIIIIlI);
                lllllllllllllllIlIllIIlIIlIIIIlI.setDirty(false);
            }
        }
    }
    
    static {
        __OBFID = "CL_00000604";
    }
}
