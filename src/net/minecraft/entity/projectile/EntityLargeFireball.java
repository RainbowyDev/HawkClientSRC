package net.minecraft.entity.projectile;

import net.minecraft.nbt.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

public class EntityLargeFireball extends EntityFireball
{
    public /* synthetic */ int field_92057_e;
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound llllllllllllllIlIllllllllIllllIl) {
        super.readEntityFromNBT(llllllllllllllIlIllllllllIllllIl);
        if (llllllllllllllIlIllllllllIllllIl.hasKey("ExplosionPower", 99)) {
            this.field_92057_e = llllllllllllllIlIllllllllIllllIl.getInteger("ExplosionPower");
        }
    }
    
    static {
        __OBFID = "CL_00001719";
    }
    
    public EntityLargeFireball(final World llllllllllllllIlIlllllllllIlllII, final EntityLivingBase llllllllllllllIlIlllllllllIllIll, final double llllllllllllllIlIlllllllllIllIlI, final double llllllllllllllIlIlllllllllIlIIll, final double llllllllllllllIlIlllllllllIllIII) {
        super(llllllllllllllIlIlllllllllIlllII, llllllllllllllIlIlllllllllIllIll, llllllllllllllIlIlllllllllIllIlI, llllllllllllllIlIlllllllllIlIIll, llllllllllllllIlIlllllllllIllIII);
        this.field_92057_e = 1;
    }
    
    public EntityLargeFireball(final World llllllllllllllIlIlllllllllllllII) {
        super(llllllllllllllIlIlllllllllllllII);
        this.field_92057_e = 1;
    }
    
    public EntityLargeFireball(final World llllllllllllllIlIlllllllllllIIlI, final double llllllllllllllIlIlllllllllllIIIl, final double llllllllllllllIlIlllllllllllIIII, final double llllllllllllllIlIllllllllllIIlll, final double llllllllllllllIlIllllllllllIIllI, final double llllllllllllllIlIllllllllllIllIl, final double llllllllllllllIlIllllllllllIllII) {
        super(llllllllllllllIlIlllllllllllIIlI, llllllllllllllIlIlllllllllllIIIl, llllllllllllllIlIlllllllllllIIII, llllllllllllllIlIllllllllllIIlll, llllllllllllllIlIllllllllllIIllI, llllllllllllllIlIllllllllllIllIl, llllllllllllllIlIllllllllllIllII);
        this.field_92057_e = 1;
    }
    
    @Override
    protected void onImpact(final MovingObjectPosition llllllllllllllIlIlllllllllIIllIl) {
        if (!this.worldObj.isRemote) {
            if (llllllllllllllIlIlllllllllIIllIl.entityHit != null) {
                llllllllllllllIlIlllllllllIIllIl.entityHit.attackEntityFrom(DamageSource.causeFireballDamage(this, this.shootingEntity), 6.0f);
                this.func_174815_a(this.shootingEntity, llllllllllllllIlIlllllllllIIllIl.entityHit);
            }
            final boolean llllllllllllllIlIlllllllllIIllII = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");
            this.worldObj.newExplosion(null, this.posX, this.posY, this.posZ, (float)this.field_92057_e, llllllllllllllIlIlllllllllIIllII, llllllllllllllIlIlllllllllIIllII);
            this.setDead();
        }
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound llllllllllllllIlIlllllllllIIIlIl) {
        super.writeEntityToNBT(llllllllllllllIlIlllllllllIIIlIl);
        llllllllllllllIlIlllllllllIIIlIl.setInteger("ExplosionPower", this.field_92057_e);
    }
}
