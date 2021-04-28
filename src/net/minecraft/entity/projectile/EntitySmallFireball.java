package net.minecraft.entity.projectile;

import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.util.*;

public class EntitySmallFireball extends EntityFireball
{
    public EntitySmallFireball(final World lllllllllllllIllllllllIIllIllIII, final EntityLivingBase lllllllllllllIllllllllIIllIlIlll, final double lllllllllllllIllllllllIIllIlIllI, final double lllllllllllllIllllllllIIllIIllll, final double lllllllllllllIllllllllIIllIIlllI) {
        super(lllllllllllllIllllllllIIllIllIII, lllllllllllllIllllllllIIllIlIlll, lllllllllllllIllllllllIIllIlIllI, lllllllllllllIllllllllIIllIIllll, lllllllllllllIllllllllIIllIIlllI);
        this.setSize(0.3125f, 0.3125f);
    }
    
    static {
        __OBFID = "CL_00001721";
    }
    
    public EntitySmallFireball(final World lllllllllllllIllllllllIIlllIIIlI) {
        super(lllllllllllllIllllllllIIlllIIIlI);
        this.setSize(0.3125f, 0.3125f);
    }
    
    @Override
    public boolean canBeCollidedWith() {
        return false;
    }
    
    public EntitySmallFireball(final World lllllllllllllIllllllllIIllIIIlII, final double lllllllllllllIllllllllIIlIlllIll, final double lllllllllllllIllllllllIIlIlllIlI, final double lllllllllllllIllllllllIIlIlllIIl, final double lllllllllllllIllllllllIIllIIIIII, final double lllllllllllllIllllllllIIlIllIlll, final double lllllllllllllIllllllllIIlIlllllI) {
        super(lllllllllllllIllllllllIIllIIIlII, lllllllllllllIllllllllIIlIlllIll, lllllllllllllIllllllllIIlIlllIlI, lllllllllllllIllllllllIIlIlllIIl, lllllllllllllIllllllllIIllIIIIII, lllllllllllllIllllllllIIlIllIlll, lllllllllllllIllllllllIIlIlllllI);
        this.setSize(0.3125f, 0.3125f);
    }
    
    @Override
    protected void onImpact(final MovingObjectPosition lllllllllllllIllllllllIIlIllIIII) {
        if (!this.worldObj.isRemote) {
            if (lllllllllllllIllllllllIIlIllIIII.entityHit != null) {
                final boolean lllllllllllllIllllllllIIlIlIllll = lllllllllllllIllllllllIIlIllIIII.entityHit.attackEntityFrom(DamageSource.causeFireballDamage(this, this.shootingEntity), 5.0f);
                if (lllllllllllllIllllllllIIlIlIllll) {
                    this.func_174815_a(this.shootingEntity, lllllllllllllIllllllllIIlIllIIII.entityHit);
                    if (!lllllllllllllIllllllllIIlIllIIII.entityHit.isImmuneToFire()) {
                        lllllllllllllIllllllllIIlIllIIII.entityHit.setFire(5);
                    }
                }
            }
            else {
                boolean lllllllllllllIllllllllIIlIlIlllI = true;
                if (this.shootingEntity != null && this.shootingEntity instanceof EntityLiving) {
                    lllllllllllllIllllllllIIlIlIlllI = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");
                }
                if (lllllllllllllIllllllllIIlIlIlllI) {
                    final BlockPos lllllllllllllIllllllllIIlIlIllIl = lllllllllllllIllllllllIIlIllIIII.func_178782_a().offset(lllllllllllllIllllllllIIlIllIIII.field_178784_b);
                    if (this.worldObj.isAirBlock(lllllllllllllIllllllllIIlIlIllIl)) {
                        this.worldObj.setBlockState(lllllllllllllIllllllllIIlIlIllIl, Blocks.fire.getDefaultState());
                    }
                }
            }
            this.setDead();
        }
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource lllllllllllllIllllllllIIlIlIIllI, final float lllllllllllllIllllllllIIlIlIIlIl) {
        return false;
    }
}
