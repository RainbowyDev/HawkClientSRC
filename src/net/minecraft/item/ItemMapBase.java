package net.minecraft.item;

import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.network.*;

public class ItemMapBase extends Item
{
    public Packet createMapDataPacket(final ItemStack llllllllllllllIllIIIIlIlllIlIIll, final World llllllllllllllIllIIIIlIlllIlIIlI, final EntityPlayer llllllllllllllIllIIIIlIlllIlIIIl) {
        return null;
    }
    
    static {
        __OBFID = "CL_00000004";
    }
    
    @Override
    public boolean isMap() {
        return true;
    }
}
