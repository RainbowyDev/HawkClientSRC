package net.minecraft.entity.ai;

import net.minecraft.entity.passive.*;
import com.google.common.base.*;
import net.minecraft.entity.*;

public class EntityAITargetNonTamed extends EntityAINearestAttackableTarget
{
    private /* synthetic */ EntityTameable theTameable;
    
    static {
        __OBFID = "CL_00001623";
    }
    
    @Override
    public boolean shouldExecute() {
        return !this.theTameable.isTamed() && super.shouldExecute();
    }
    
    public EntityAITargetNonTamed(final EntityTameable lIlIIllIIlllIlI, final Class lIlIIllIIlllIIl, final boolean lIlIIllIIllIIll, final Predicate lIlIIllIIllIIlI) {
        super(lIlIIllIIlllIlI, lIlIIllIIlllIIl, 10, lIlIIllIIllIIll, false, lIlIIllIIllIIlI);
        this.theTameable = lIlIIllIIlllIlI;
    }
}
