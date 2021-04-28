package net.minecraft.potion;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.util.*;

public class PotionHealthBoost extends Potion
{
    static {
        __OBFID = "CL_00001526";
    }
    
    @Override
    public void removeAttributesModifiersFromEntity(final EntityLivingBase lIIlIlIIlIllIIl, final BaseAttributeMap lIIlIlIIlIlllII, final int lIIlIlIIlIllIll) {
        super.removeAttributesModifiersFromEntity(lIIlIlIIlIllIIl, lIIlIlIIlIlllII, lIIlIlIIlIllIll);
        if (lIIlIlIIlIllIIl.getHealth() > lIIlIlIIlIllIIl.getMaxHealth()) {
            lIIlIlIIlIllIIl.setHealth(lIIlIlIIlIllIIl.getMaxHealth());
        }
    }
    
    public PotionHealthBoost(final int lIIlIlIIllIlIll, final ResourceLocation lIIlIlIIllIlIlI, final boolean lIIlIlIIllIIlII, final int lIIlIlIIllIlIII) {
        super(lIIlIlIIllIlIll, lIIlIlIIllIlIlI, lIIlIlIIllIIlII, lIIlIlIIllIlIII);
    }
}
