package net.minecraft.world.storage;

import net.minecraft.entity.player.*;
import net.minecraft.nbt.*;

public interface IPlayerFileData
{
    String[] getAvailablePlayerDat();
    
    NBTTagCompound readPlayerData(final EntityPlayer p0);
    
    void writePlayerData(final EntityPlayer p0);
}
