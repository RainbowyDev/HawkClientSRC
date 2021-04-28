package net.minecraft.world;

import net.minecraft.nbt.*;

public abstract class WorldSavedData
{
    public final /* synthetic */ String mapName;
    private /* synthetic */ boolean dirty;
    
    public WorldSavedData(final String lllllllllllllllIllIlIIIIIlIllIII) {
        this.mapName = lllllllllllllllIllIlIIIIIlIllIII;
    }
    
    public void markDirty() {
        this.setDirty(true);
    }
    
    public abstract void writeToNBT(final NBTTagCompound p0);
    
    public void setDirty(final boolean lllllllllllllllIllIlIIIIIlIIllll) {
        this.dirty = lllllllllllllllIllIlIIIIIlIIllll;
    }
    
    static {
        __OBFID = "CL_00000580";
    }
    
    public boolean isDirty() {
        return this.dirty;
    }
    
    public abstract void readFromNBT(final NBTTagCompound p0);
}
