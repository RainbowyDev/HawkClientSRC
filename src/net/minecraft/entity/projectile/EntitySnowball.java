package net.minecraft.entity.projectile;

import net.minecraft.world.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class EntitySnowball extends EntityThrowable
{
    static {
        __OBFID = "CL_00001722";
    }
    
    public EntitySnowball(final World lIIIlIIllIlllll, final EntityLivingBase lIIIlIIlllIIIIl) {
        super(lIIIlIIllIlllll, lIIIlIIlllIIIIl);
    }
    
    public EntitySnowball(final World lIIIlIIllIlIlll, final double lIIIlIIllIlIllI, final double lIIIlIIllIlIIII, final double lIIIlIIllIlIlII) {
        super(lIIIlIIllIlIlll, lIIIlIIllIlIllI, lIIIlIIllIlIIII, lIIIlIIllIlIlII);
    }
    
    @Override
    protected void onImpact(final MovingObjectPosition lIIIlIIllIIIllI) {
        if (lIIIlIIllIIIllI.entityHit != null) {
            byte lIIIlIIllIIlIIl = 0;
            if (lIIIlIIllIIIllI.entityHit instanceof EntityBlaze) {
                lIIIlIIllIIlIIl = 3;
            }
            lIIIlIIllIIIllI.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), lIIIlIIllIIlIIl);
        }
        for (int lIIIlIIllIIlIII = 0; lIIIlIIllIIlIII < 8; ++lIIIlIIllIIlIII) {
            this.worldObj.spawnParticle(EnumParticleTypes.SNOWBALL, this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0, new int[0]);
        }
        if (!this.worldObj.isRemote) {
            this.setDead();
        }
    }
    
    public EntitySnowball(final World lIIIlIIlllIlIIl) {
        super(lIIIlIIlllIlIIl);
    }
}
