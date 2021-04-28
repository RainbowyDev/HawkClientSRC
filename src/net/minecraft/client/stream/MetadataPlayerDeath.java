package net.minecraft.client.stream;

import net.minecraft.entity.*;

public class MetadataPlayerDeath extends Metadata
{
    public MetadataPlayerDeath(final EntityLivingBase llllIIllllllI, final EntityLivingBase llllIIlllllIl) {
        super("player_death");
        if (llllIIllllllI != null) {
            this.func_152808_a("player", llllIIllllllI.getName());
        }
        if (llllIIlllllIl != null) {
            this.func_152808_a("killer", llllIIlllllIl.getName());
        }
    }
    
    static {
        __OBFID = "CL_00002376";
    }
}
