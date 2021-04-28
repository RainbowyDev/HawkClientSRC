package net.minecraft.potion;

import net.minecraft.entity.ai.attributes.*;
import net.minecraft.util.*;

public class PotionAttackDamage extends Potion
{
    @Override
    public double func_111183_a(final int llllllllllllllIlllllIIlllllIllII, final AttributeModifier llllllllllllllIlllllIIlllllIlIll) {
        return (this.id == Potion.weakness.id) ? (-0.5f * (llllllllllllllIlllllIIlllllIllII + 1)) : (1.3 * (llllllllllllllIlllllIIlllllIllII + 1));
    }
    
    protected PotionAttackDamage(final int llllllllllllllIlllllIIlllllllIII, final ResourceLocation llllllllllllllIlllllIIllllllIIlI, final boolean llllllllllllllIlllllIIllllllIIIl, final int llllllllllllllIlllllIIllllllIlIl) {
        super(llllllllllllllIlllllIIlllllllIII, llllllllllllllIlllllIIllllllIIlI, llllllllllllllIlllllIIllllllIIIl, llllllllllllllIlllllIIllllllIlIl);
    }
    
    static {
        __OBFID = "CL_00001525";
    }
}
