package net.minecraft.entity.projectile;

import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.potion.*;
import net.minecraft.entity.*;

public class EntityWitherSkull extends EntityFireball
{
    public EntityWitherSkull(final World llllllllllllllIllIIllIIllIllIIlI) {
        super(llllllllllllllIllIIllIIllIllIIlI);
        this.setSize(0.3125f, 0.3125f);
    }
    
    @Override
    protected void entityInit() {
        this.dataWatcher.addObject(10, 0);
    }
    
    public EntityWitherSkull(final World llllllllllllllIllIIllIIllIlIlIII, final EntityLivingBase llllllllllllllIllIIllIIllIlIIIIl, final double llllllllllllllIllIIllIIllIlIIllI, final double llllllllllllllIllIIllIIllIlIIlIl, final double llllllllllllllIllIIllIIllIlIIlII) {
        super(llllllllllllllIllIIllIIllIlIlIII, llllllllllllllIllIIllIIllIlIIIIl, llllllllllllllIllIIllIIllIlIIllI, llllllllllllllIllIIllIIllIlIIlIl, llllllllllllllIllIIllIIllIlIIlII);
        this.setSize(0.3125f, 0.3125f);
    }
    
    @Override
    public boolean isBurning() {
        return false;
    }
    
    @Override
    public float getExplosionResistance(final Explosion llllllllllllllIllIIllIIlIlllIlII, final World llllllllllllllIllIIllIIlIlllIIll, final BlockPos llllllllllllllIllIIllIIlIllllIII, final IBlockState llllllllllllllIllIIllIIlIlllIIIl) {
        float llllllllllllllIllIIllIIlIlllIllI = super.getExplosionResistance(llllllllllllllIllIIllIIlIlllIlII, llllllllllllllIllIIllIIlIlllIIll, llllllllllllllIllIIllIIlIllllIII, llllllllllllllIllIIllIIlIlllIIIl);
        if (this.isInvulnerable() && llllllllllllllIllIIllIIlIlllIIIl.getBlock() != Blocks.bedrock && llllllllllllllIllIIllIIlIlllIIIl.getBlock() != Blocks.end_portal && llllllllllllllIllIIllIIlIlllIIIl.getBlock() != Blocks.end_portal_frame && llllllllllllllIllIIllIIlIlllIIIl.getBlock() != Blocks.command_block) {
            llllllllllllllIllIIllIIlIlllIllI = Math.min(0.8f, llllllllllllllIllIIllIIlIlllIllI);
        }
        return llllllllllllllIllIIllIIlIlllIllI;
    }
    
    @Override
    public boolean canBeCollidedWith() {
        return false;
    }
    
    @Override
    protected void onImpact(final MovingObjectPosition llllllllllllllIllIIllIIlIllIlIII) {
        if (!this.worldObj.isRemote) {
            if (llllllllllllllIllIIllIIlIllIlIII.entityHit != null) {
                if (this.shootingEntity != null) {
                    if (llllllllllllllIllIIllIIlIllIlIII.entityHit.attackEntityFrom(DamageSource.causeMobDamage(this.shootingEntity), 8.0f)) {
                        if (!llllllllllllllIllIIllIIlIllIlIII.entityHit.isEntityAlive()) {
                            this.shootingEntity.heal(5.0f);
                        }
                        else {
                            this.func_174815_a(this.shootingEntity, llllllllllllllIllIIllIIlIllIlIII.entityHit);
                        }
                    }
                }
                else {
                    llllllllllllllIllIIllIIlIllIlIII.entityHit.attackEntityFrom(DamageSource.magic, 5.0f);
                }
                if (llllllllllllllIllIIllIIlIllIlIII.entityHit instanceof EntityLivingBase) {
                    byte llllllllllllllIllIIllIIlIllIlIlI = 0;
                    if (this.worldObj.getDifficulty() == EnumDifficulty.NORMAL) {
                        llllllllllllllIllIIllIIlIllIlIlI = 10;
                    }
                    else if (this.worldObj.getDifficulty() == EnumDifficulty.HARD) {
                        llllllllllllllIllIIllIIlIllIlIlI = 40;
                    }
                    if (llllllllllllllIllIIllIIlIllIlIlI > 0) {
                        ((EntityLivingBase)llllllllllllllIllIIllIIlIllIlIII.entityHit).addPotionEffect(new PotionEffect(Potion.wither.id, 20 * llllllllllllllIllIIllIIlIllIlIlI, 1));
                    }
                }
            }
            this.worldObj.newExplosion(this, this.posX, this.posY, this.posZ, 1.0f, false, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
            this.setDead();
        }
    }
    
    public boolean isInvulnerable() {
        return this.dataWatcher.getWatchableObjectByte(10) == 1;
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource llllllllllllllIllIIllIIlIllIIlII, final float llllllllllllllIllIIllIIlIllIIIll) {
        return false;
    }
    
    static {
        __OBFID = "CL_00001728";
    }
    
    public EntityWitherSkull(final World llllllllllllllIllIIllIIllIIIlIIl, final double llllllllllllllIllIIllIIllIIlIIII, final double llllllllllllllIllIIllIIllIIIIlll, final double llllllllllllllIllIIllIIllIIIIllI, final double llllllllllllllIllIIllIIllIIIllIl, final double llllllllllllllIllIIllIIllIIIllII, final double llllllllllllllIllIIllIIllIIIlIll) {
        super(llllllllllllllIllIIllIIllIIIlIIl, llllllllllllllIllIIllIIllIIlIIII, llllllllllllllIllIIllIIllIIIIlll, llllllllllllllIllIIllIIllIIIIllI, llllllllllllllIllIIllIIllIIIllIl, llllllllllllllIllIIllIIllIIIllII, llllllllllllllIllIIllIIllIIIlIll);
        this.setSize(0.3125f, 0.3125f);
    }
    
    public void setInvulnerable(final boolean llllllllllllllIllIIllIIlIlIlIlll) {
        this.dataWatcher.updateObject(10, (byte)(byte)(llllllllllllllIllIIllIIlIlIlIlll ? 1 : 0));
    }
    
    @Override
    protected float getMotionFactor() {
        return this.isInvulnerable() ? 0.73f : super.getMotionFactor();
    }
}
