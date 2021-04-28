package net.minecraft.potion;

import net.minecraft.util.*;

public class PotionHealth extends Potion
{
    static {
        __OBFID = "CL_00001527";
    }
    
    public PotionHealth(final int llllllllllllllIIllIIIIlIlIlllIIl, final ResourceLocation llllllllllllllIIllIIIIlIlIllllIl, final boolean llllllllllllllIIllIIIIlIlIllIlll, final int llllllllllllllIIllIIIIlIlIllIllI) {
        super(llllllllllllllIIllIIIIlIlIlllIIl, llllllllllllllIIllIIIIlIlIllllIl, llllllllllllllIIllIIIIlIlIllIlll, llllllllllllllIIllIIIIlIlIllIllI);
    }
    
    @Override
    public boolean isInstant() {
        return true;
    }
    
    @Override
    public boolean isReady(final int llllllllllllllIIllIIIIlIlIllIIlI, final int llllllllllllllIIllIIIIlIlIllIIIl) {
        return llllllllllllllIIllIIIIlIlIllIIlI >= 1;
    }
}
