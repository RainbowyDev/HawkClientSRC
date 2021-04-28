package net.minecraft.client.stream;

import net.minecraft.entity.*;

public class MetadataCombat extends Metadata
{
    static {
        __OBFID = "CL_00002377";
    }
    
    public MetadataCombat(final EntityLivingBase lllllllllllllllIIIIlllIIlllIllll, final EntityLivingBase lllllllllllllllIIIIlllIIlllIlllI) {
        super("player_combat");
        this.func_152808_a("player", lllllllllllllllIIIIlllIIlllIllll.getName());
        if (lllllllllllllllIIIIlllIIlllIlllI != null) {
            this.func_152808_a("primary_opponent", lllllllllllllllIIIIlllIIlllIlllI.getName());
        }
        if (lllllllllllllllIIIIlllIIlllIlllI != null) {
            this.func_152807_a(String.valueOf(new StringBuilder("Combat between ").append(lllllllllllllllIIIIlllIIlllIllll.getName()).append(" and ").append(lllllllllllllllIIIIlllIIlllIlllI.getName())));
        }
        else {
            this.func_152807_a(String.valueOf(new StringBuilder("Combat between ").append(lllllllllllllllIIIIlllIIlllIllll.getName()).append(" and others")));
        }
    }
}
