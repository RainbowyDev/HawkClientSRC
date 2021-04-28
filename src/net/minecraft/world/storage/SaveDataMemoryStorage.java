package net.minecraft.world.storage;

import net.minecraft.world.*;

public class SaveDataMemoryStorage extends MapStorage
{
    @Override
    public void saveAllData() {
    }
    
    public SaveDataMemoryStorage() {
        super(null);
    }
    
    static {
        __OBFID = "CL_00001963";
    }
    
    @Override
    public void setData(final String llllllllllllllllIllIIIIIIIIIIlIl, final WorldSavedData llllllllllllllllIllIIIIIIIIIIlII) {
        this.loadedDataMap.put(llllllllllllllllIllIIIIIIIIIIlIl, llllllllllllllllIllIIIIIIIIIIlII);
    }
    
    @Override
    public WorldSavedData loadData(final Class llllllllllllllllIllIIIIIIIIIllIl, final String llllllllllllllllIllIIIIIIIIIlIlI) {
        return this.loadedDataMap.get(llllllllllllllllIllIIIIIIIIIlIlI);
    }
    
    @Override
    public int getUniqueDataId(final String llllllllllllllllIlIllllllllllllI) {
        return 0;
    }
}
