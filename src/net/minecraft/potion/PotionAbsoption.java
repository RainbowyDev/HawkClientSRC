package net.minecraft.potion;

import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;

public class PotionAbsoption extends Potion
{
    protected PotionAbsoption(final int lllllllllllllllIIIIlIIIllIllllIl, final ResourceLocation lllllllllllllllIIIIlIIIllIllIlll, final boolean lllllllllllllllIIIIlIIIllIllIllI, final int lllllllllllllllIIIIlIIIllIllIlIl) {
        super(lllllllllllllllIIIIlIIIllIllllIl, lllllllllllllllIIIIlIIIllIllIlll, lllllllllllllllIIIIlIIIllIllIllI, lllllllllllllllIIIIlIIIllIllIlIl);
    }
    
    static {
        __OBFID = "CL_00001524";
    }
    
    @Override
    public void removeAttributesModifiersFromEntity(final EntityLivingBase lllllllllllllllIIIIlIIIllIlIlIll, final BaseAttributeMap lllllllllllllllIIIIlIIIllIlIlIlI, final int lllllllllllllllIIIIlIIIllIlIlIIl) {
        lllllllllllllllIIIIlIIIllIlIlIll.setAbsorptionAmount(lllllllllllllllIIIIlIIIllIlIlIll.getAbsorptionAmount() - 4 * (lllllllllllllllIIIIlIIIllIlIlIIl + 1));
        super.removeAttributesModifiersFromEntity(lllllllllllllllIIIIlIIIllIlIlIll, lllllllllllllllIIIIlIIIllIlIlIlI, lllllllllllllllIIIIlIIIllIlIlIIl);
    }
    
    @Override
    public void applyAttributesModifiersToEntity(final EntityLivingBase lllllllllllllllIIIIlIIIllIlIIIll, final BaseAttributeMap lllllllllllllllIIIIlIIIllIIllllI, final int lllllllllllllllIIIIlIIIllIlIIIIl) {
        lllllllllllllllIIIIlIIIllIlIIIll.setAbsorptionAmount(lllllllllllllllIIIIlIIIllIlIIIll.getAbsorptionAmount() + 4 * (lllllllllllllllIIIIlIIIllIlIIIIl + 1));
        super.applyAttributesModifiersToEntity(lllllllllllllllIIIIlIIIllIlIIIll, lllllllllllllllIIIIlIIIllIIllllI, lllllllllllllllIIIIlIIIllIlIIIIl);
    }
}
