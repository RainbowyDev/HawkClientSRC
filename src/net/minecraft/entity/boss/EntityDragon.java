package net.minecraft.entity.boss;

import net.minecraft.entity.monster.*;
import net.minecraft.entity.item.*;
import com.google.common.collect.*;
import net.minecraft.entity.player.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.util.*;

public class EntityDragon extends EntityLiving implements IMob, IEntityMultiPart, IBossDisplayData
{
    public /* synthetic */ EntityEnderCrystal healingEnderCrystal;
    public /* synthetic */ EntityDragonPart dragonPartWing1;
    public /* synthetic */ EntityDragonPart dragonPartTail1;
    public /* synthetic */ EntityDragonPart[] dragonPartArray;
    public /* synthetic */ int ringBufferIndex;
    private /* synthetic */ Entity target;
    public /* synthetic */ int deathTicks;
    public /* synthetic */ EntityDragonPart dragonPartTail2;
    public /* synthetic */ float prevAnimTime;
    public /* synthetic */ float animTime;
    public /* synthetic */ double targetY;
    public /* synthetic */ double[][] ringBuffer;
    public /* synthetic */ EntityDragonPart dragonPartHead;
    public /* synthetic */ boolean slowed;
    public /* synthetic */ EntityDragonPart dragonPartBody;
    public /* synthetic */ double targetX;
    public /* synthetic */ EntityDragonPart dragonPartTail3;
    public /* synthetic */ double targetZ;
    public /* synthetic */ EntityDragonPart dragonPartWing2;
    public /* synthetic */ boolean forceNewTarget;
    
    private void collideWithEntities(final List lllllllllllllllllIlIllIIlIIIllIl) {
        final double lllllllllllllllllIlIllIIlIIlIlIl = (this.dragonPartBody.getEntityBoundingBox().minX + this.dragonPartBody.getEntityBoundingBox().maxX) / 2.0;
        final double lllllllllllllllllIlIllIIlIIlIlII = (this.dragonPartBody.getEntityBoundingBox().minZ + this.dragonPartBody.getEntityBoundingBox().maxZ) / 2.0;
        for (final Entity lllllllllllllllllIlIllIIlIIlIIlI : lllllllllllllllllIlIllIIlIIIllIl) {
            if (lllllllllllllllllIlIllIIlIIlIIlI instanceof EntityLivingBase) {
                final double lllllllllllllllllIlIllIIlIIlIIIl = lllllllllllllllllIlIllIIlIIlIIlI.posX - lllllllllllllllllIlIllIIlIIlIlIl;
                final double lllllllllllllllllIlIllIIlIIlIIII = lllllllllllllllllIlIllIIlIIlIIlI.posZ - lllllllllllllllllIlIllIIlIIlIlII;
                final double lllllllllllllllllIlIllIIlIIIllll = lllllllllllllllllIlIllIIlIIlIIIl * lllllllllllllllllIlIllIIlIIlIIIl + lllllllllllllllllIlIllIIlIIlIIII * lllllllllllllllllIlIllIIlIIlIIII;
                lllllllllllllllllIlIllIIlIIlIIlI.addVelocity(lllllllllllllllllIlIllIIlIIlIIIl / lllllllllllllllllIlIllIIlIIIllll * 4.0, 0.20000000298023224, lllllllllllllllllIlIllIIlIIlIIII / lllllllllllllllllIlIllIIlIIIllll * 4.0);
            }
        }
    }
    
    @Override
    protected String getLivingSound() {
        return "mob.enderdragon.growl";
    }
    
    public EntityDragon(final World lllllllllllllllllIlIllIlIIllllII) {
        super(lllllllllllllllllIlIllIlIIllllII);
        this.ringBuffer = new double[64][3];
        this.ringBufferIndex = -1;
        final EntityDragonPart[] dragonPartArray = new EntityDragonPart[7];
        final int n = 0;
        final EntityDragonPart dragonPartHead = new EntityDragonPart(this, "head", 6.0f, 6.0f);
        this.dragonPartHead = dragonPartHead;
        dragonPartArray[n] = dragonPartHead;
        final int n2 = 1;
        final EntityDragonPart dragonPartBody = new EntityDragonPart(this, "body", 8.0f, 8.0f);
        this.dragonPartBody = dragonPartBody;
        dragonPartArray[n2] = dragonPartBody;
        final int n3 = 2;
        final EntityDragonPart dragonPartTail1 = new EntityDragonPart(this, "tail", 4.0f, 4.0f);
        this.dragonPartTail1 = dragonPartTail1;
        dragonPartArray[n3] = dragonPartTail1;
        final int n4 = 3;
        final EntityDragonPart dragonPartTail2 = new EntityDragonPart(this, "tail", 4.0f, 4.0f);
        this.dragonPartTail2 = dragonPartTail2;
        dragonPartArray[n4] = dragonPartTail2;
        final int n5 = 4;
        final EntityDragonPart dragonPartTail3 = new EntityDragonPart(this, "tail", 4.0f, 4.0f);
        this.dragonPartTail3 = dragonPartTail3;
        dragonPartArray[n5] = dragonPartTail3;
        final int n6 = 5;
        final EntityDragonPart dragonPartWing1 = new EntityDragonPart(this, "wing", 4.0f, 4.0f);
        this.dragonPartWing1 = dragonPartWing1;
        dragonPartArray[n6] = dragonPartWing1;
        final int n7 = 6;
        final EntityDragonPart dragonPartWing2 = new EntityDragonPart(this, "wing", 4.0f, 4.0f);
        this.dragonPartWing2 = dragonPartWing2;
        dragonPartArray[n7] = dragonPartWing2;
        this.dragonPartArray = dragonPartArray;
        this.setHealth(this.getMaxHealth());
        this.setSize(16.0f, 8.0f);
        this.noClip = true;
        this.isImmuneToFire = true;
        this.targetY = 100.0;
        this.ignoreFrustumCheck = true;
    }
    
    @Override
    protected float getSoundVolume() {
        return 5.0f;
    }
    
    public double[] getMovementOffsets(final int lllllllllllllllllIlIllIlIIlIllII, float lllllllllllllllllIlIllIlIIlIIIll) {
        if (this.getHealth() <= 0.0f) {
            lllllllllllllllllIlIllIlIIlIIIll = 0.0f;
        }
        lllllllllllllllllIlIllIlIIlIIIll = 1.0f - lllllllllllllllllIlIllIlIIlIIIll;
        final int lllllllllllllllllIlIllIlIIlIlIlI = this.ringBufferIndex - lllllllllllllllllIlIllIlIIlIllII * 1 & 0x3F;
        final int lllllllllllllllllIlIllIlIIlIlIIl = this.ringBufferIndex - lllllllllllllllllIlIllIlIIlIllII * 1 - 1 & 0x3F;
        final double[] lllllllllllllllllIlIllIlIIlIlIII = new double[3];
        double lllllllllllllllllIlIllIlIIlIIlll = this.ringBuffer[lllllllllllllllllIlIllIlIIlIlIlI][0];
        double lllllllllllllllllIlIllIlIIlIIllI = MathHelper.wrapAngleTo180_double(this.ringBuffer[lllllllllllllllllIlIllIlIIlIlIIl][0] - lllllllllllllllllIlIllIlIIlIIlll);
        lllllllllllllllllIlIllIlIIlIlIII[0] = lllllllllllllllllIlIllIlIIlIIlll + lllllllllllllllllIlIllIlIIlIIllI * lllllllllllllllllIlIllIlIIlIIIll;
        lllllllllllllllllIlIllIlIIlIIlll = this.ringBuffer[lllllllllllllllllIlIllIlIIlIlIlI][1];
        lllllllllllllllllIlIllIlIIlIIllI = this.ringBuffer[lllllllllllllllllIlIllIlIIlIlIIl][1] - lllllllllllllllllIlIllIlIIlIIlll;
        lllllllllllllllllIlIllIlIIlIlIII[1] = lllllllllllllllllIlIllIlIIlIIlll + lllllllllllllllllIlIllIlIIlIIllI * lllllllllllllllllIlIllIlIIlIIIll;
        lllllllllllllllllIlIllIlIIlIlIII[2] = this.ringBuffer[lllllllllllllllllIlIllIlIIlIlIlI][2] + (this.ringBuffer[lllllllllllllllllIlIllIlIIlIlIIl][2] - this.ringBuffer[lllllllllllllllllIlIllIlIIlIlIlI][2]) * lllllllllllllllllIlIllIlIIlIIIll;
        return lllllllllllllllllIlIllIlIIlIlIII;
    }
    
    @Override
    protected void onDeathUpdate() {
        ++this.deathTicks;
        if (this.deathTicks >= 180 && this.deathTicks <= 200) {
            final float lllllllllllllllllIlIllIIIIIIIIlI = (this.rand.nextFloat() - 0.5f) * 8.0f;
            final float lllllllllllllllllIlIllIIIIIIIIIl = (this.rand.nextFloat() - 0.5f) * 4.0f;
            final float lllllllllllllllllIlIllIIIIIIIIII = (this.rand.nextFloat() - 0.5f) * 8.0f;
            this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, this.posX + lllllllllllllllllIlIllIIIIIIIIlI, this.posY + 2.0 + lllllllllllllllllIlIllIIIIIIIIIl, this.posZ + lllllllllllllllllIlIllIIIIIIIIII, 0.0, 0.0, 0.0, new int[0]);
        }
        if (!this.worldObj.isRemote) {
            if (this.deathTicks > 150 && this.deathTicks % 5 == 0 && this.worldObj.getGameRules().getGameRuleBooleanValue("doMobLoot")) {
                int lllllllllllllllllIlIlIllllllllll = 1000;
                while (lllllllllllllllllIlIlIllllllllll > 0) {
                    final int lllllllllllllllllIlIlIllllllllIl = EntityXPOrb.getXPSplit(lllllllllllllllllIlIlIllllllllll);
                    lllllllllllllllllIlIlIllllllllll -= lllllllllllllllllIlIlIllllllllIl;
                    this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, lllllllllllllllllIlIlIllllllllIl));
                }
            }
            if (this.deathTicks == 1) {
                this.worldObj.func_175669_a(1018, new BlockPos(this), 0);
            }
        }
        this.moveEntity(0.0, 0.10000000149011612, 0.0);
        final float n = this.rotationYaw + 20.0f;
        this.rotationYaw = n;
        this.renderYawOffset = n;
        if (this.deathTicks == 200 && !this.worldObj.isRemote) {
            int lllllllllllllllllIlIlIlllllllllI = 2000;
            while (lllllllllllllllllIlIlIlllllllllI > 0) {
                final int lllllllllllllllllIlIlIllllllllII = EntityXPOrb.getXPSplit(lllllllllllllllllIlIlIlllllllllI);
                lllllllllllllllllIlIlIlllllllllI -= lllllllllllllllllIlIlIllllllllII;
                this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, lllllllllllllllllIlIlIllllllllII));
            }
            this.func_175499_a(new BlockPos(this.posX, 64.0, this.posZ));
            this.setDead();
        }
    }
    
    private void attackEntitiesInList(final List lllllllllllllllllIlIllIIlIIIIIII) {
        for (int lllllllllllllllllIlIllIIIlllllll = 0; lllllllllllllllllIlIllIIIlllllll < lllllllllllllllllIlIllIIlIIIIIII.size(); ++lllllllllllllllllIlIllIIIlllllll) {
            final Entity lllllllllllllllllIlIllIIIllllllI = lllllllllllllllllIlIllIIlIIIIIII.get(lllllllllllllllllIlIllIIIlllllll);
            if (lllllllllllllllllIlIllIIIllllllI instanceof EntityLivingBase) {
                lllllllllllllllllIlIllIIIllllllI.attackEntityFrom(DamageSource.causeMobDamage(this), 10.0f);
                this.func_174815_a(this, lllllllllllllllllIlIllIIIllllllI);
            }
        }
    }
    
    private void setNewTarget() {
        this.forceNewTarget = false;
        final ArrayList lllllllllllllllllIlIllIIIlllIIIl = Lists.newArrayList((Iterable)this.worldObj.playerEntities);
        final Iterator lllllllllllllllllIlIllIIIlllIIII = lllllllllllllllllIlIllIIIlllIIIl.iterator();
        while (lllllllllllllllllIlIllIIIlllIIII.hasNext()) {
            if (lllllllllllllllllIlIllIIIlllIIII.next().func_175149_v()) {
                lllllllllllllllllIlIllIIIlllIIII.remove();
            }
        }
        if (this.rand.nextInt(2) == 0 && !lllllllllllllllllIlIllIIIlllIIIl.isEmpty()) {
            this.target = lllllllllllllllllIlIllIIIlllIIIl.get(this.rand.nextInt(lllllllllllllllllIlIllIIIlllIIIl.size()));
        }
        else {
            boolean lllllllllllllllllIlIllIIIllIllll;
            do {
                this.targetX = 0.0;
                this.targetY = 70.0f + this.rand.nextFloat() * 50.0f;
                this.targetZ = 0.0;
                this.targetX += this.rand.nextFloat() * 120.0f - 60.0f;
                this.targetZ += this.rand.nextFloat() * 120.0f - 60.0f;
                final double lllllllllllllllllIlIllIIIllIlllI = this.posX - this.targetX;
                final double lllllllllllllllllIlIllIIIllIllIl = this.posY - this.targetY;
                final double lllllllllllllllllIlIllIIIllIllII = this.posZ - this.targetZ;
                lllllllllllllllllIlIllIIIllIllll = (lllllllllllllllllIlIllIIIllIlllI * lllllllllllllllllIlIllIIIllIlllI + lllllllllllllllllIlIllIIIllIllIl * lllllllllllllllllIlIllIIIllIllIl + lllllllllllllllllIlIllIIIllIllII * lllllllllllllllllIlIllIIIllIllII > 100.0);
            } while (!lllllllllllllllllIlIllIIIllIllll);
            this.target = null;
        }
    }
    
    private void updateDragonEnderCrystal() {
        if (this.healingEnderCrystal != null) {
            if (this.healingEnderCrystal.isDead) {
                if (!this.worldObj.isRemote) {
                    this.attackEntityFromPart(this.dragonPartHead, DamageSource.setExplosionSource(null), 10.0f);
                }
                this.healingEnderCrystal = null;
            }
            else if (this.ticksExisted % 10 == 0 && this.getHealth() < this.getMaxHealth()) {
                this.setHealth(this.getHealth() + 1.0f);
            }
        }
        if (this.rand.nextInt(10) == 0) {
            final float lllllllllllllllllIlIllIIlIlIllll = 32.0f;
            final List lllllllllllllllllIlIllIIlIlIlllI = this.worldObj.getEntitiesWithinAABB(EntityEnderCrystal.class, this.getEntityBoundingBox().expand(lllllllllllllllllIlIllIIlIlIllll, lllllllllllllllllIlIllIIlIlIllll, lllllllllllllllllIlIllIIlIlIllll));
            EntityEnderCrystal lllllllllllllllllIlIllIIlIlIllIl = null;
            double lllllllllllllllllIlIllIIlIlIllII = Double.MAX_VALUE;
            for (final EntityEnderCrystal lllllllllllllllllIlIllIIlIlIlIlI : lllllllllllllllllIlIllIIlIlIlllI) {
                final double lllllllllllllllllIlIllIIlIlIlIIl = lllllllllllllllllIlIllIIlIlIlIlI.getDistanceSqToEntity(this);
                if (lllllllllllllllllIlIllIIlIlIlIIl < lllllllllllllllllIlIllIIlIlIllII) {
                    lllllllllllllllllIlIllIIlIlIllII = lllllllllllllllllIlIllIIlIlIlIIl;
                    lllllllllllllllllIlIllIIlIlIllIl = lllllllllllllllllIlIllIIlIlIlIlI;
                }
            }
            this.healingEnderCrystal = lllllllllllllllllIlIllIIlIlIllIl;
        }
    }
    
    @Override
    public void onLivingUpdate() {
        if (this.worldObj.isRemote) {
            final float lllllllllllllllllIlIllIlIIIIIIll = MathHelper.cos(this.animTime * 3.1415927f * 2.0f);
            final float lllllllllllllllllIlIllIlIIIIIIII = MathHelper.cos(this.prevAnimTime * 3.1415927f * 2.0f);
            if (lllllllllllllllllIlIllIlIIIIIIII <= -0.3f && lllllllllllllllllIlIllIlIIIIIIll >= -0.3f && !this.isSlient()) {
                this.worldObj.playSound(this.posX, this.posY, this.posZ, "mob.enderdragon.wings", 5.0f, 0.8f + this.rand.nextFloat() * 0.3f, false);
            }
        }
        this.prevAnimTime = this.animTime;
        if (this.getHealth() <= 0.0f) {
            final float lllllllllllllllllIlIllIlIIIIIIlI = (this.rand.nextFloat() - 0.5f) * 8.0f;
            final float lllllllllllllllllIlIllIIllllllll = (this.rand.nextFloat() - 0.5f) * 4.0f;
            final float lllllllllllllllllIlIllIIllllllIl = (this.rand.nextFloat() - 0.5f) * 8.0f;
            this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, this.posX + lllllllllllllllllIlIllIlIIIIIIlI, this.posY + 2.0 + lllllllllllllllllIlIllIIllllllll, this.posZ + lllllllllllllllllIlIllIIllllllIl, 0.0, 0.0, 0.0, new int[0]);
        }
        else {
            this.updateDragonEnderCrystal();
            float lllllllllllllllllIlIllIlIIIIIIIl = 0.2f / (MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ) * 10.0f + 1.0f);
            lllllllllllllllllIlIllIlIIIIIIIl *= (float)Math.pow(2.0, this.motionY);
            if (this.slowed) {
                this.animTime += lllllllllllllllllIlIllIlIIIIIIIl * 0.5f;
            }
            else {
                this.animTime += lllllllllllllllllIlIllIlIIIIIIIl;
            }
            this.rotationYaw = MathHelper.wrapAngleTo180_float(this.rotationYaw);
            if (this.ringBufferIndex < 0) {
                for (int lllllllllllllllllIlIllIIlllllIll = 0; lllllllllllllllllIlIllIIlllllIll < this.ringBuffer.length; ++lllllllllllllllllIlIllIIlllllIll) {
                    this.ringBuffer[lllllllllllllllllIlIllIIlllllIll][0] = this.rotationYaw;
                    this.ringBuffer[lllllllllllllllllIlIllIIlllllIll][1] = this.posY;
                }
            }
            if (++this.ringBufferIndex == this.ringBuffer.length) {
                this.ringBufferIndex = 0;
            }
            this.ringBuffer[this.ringBufferIndex][0] = this.rotationYaw;
            this.ringBuffer[this.ringBufferIndex][1] = this.posY;
            if (this.worldObj.isRemote) {
                if (this.newPosRotationIncrements > 0) {
                    final double lllllllllllllllllIlIllIIllllIlII = this.posX + (this.newPosX - this.posX) / this.newPosRotationIncrements;
                    final double lllllllllllllllllIlIllIIlllllIlI = this.posY + (this.newPosY - this.posY) / this.newPosRotationIncrements;
                    final double lllllllllllllllllIlIllIIlllllIII = this.posZ + (this.newPosZ - this.posZ) / this.newPosRotationIncrements;
                    final double lllllllllllllllllIlIllIIllllIllI = MathHelper.wrapAngleTo180_double(this.newRotationYaw - this.rotationYaw);
                    this.rotationYaw += (float)(lllllllllllllllllIlIllIIllllIllI / this.newPosRotationIncrements);
                    this.rotationPitch += (float)((this.newRotationPitch - this.rotationPitch) / this.newPosRotationIncrements);
                    --this.newPosRotationIncrements;
                    this.setPosition(lllllllllllllllllIlIllIIllllIlII, lllllllllllllllllIlIllIIlllllIlI, lllllllllllllllllIlIllIIlllllIII);
                    this.setRotation(this.rotationYaw, this.rotationPitch);
                }
            }
            else {
                final double lllllllllllllllllIlIllIIllllIIll = this.targetX - this.posX;
                double lllllllllllllllllIlIllIIlllllIIl = this.targetY - this.posY;
                final double lllllllllllllllllIlIllIIllllIlll = this.targetZ - this.posZ;
                final double lllllllllllllllllIlIllIIllllIlIl = lllllllllllllllllIlIllIIllllIIll * lllllllllllllllllIlIllIIllllIIll + lllllllllllllllllIlIllIIlllllIIl * lllllllllllllllllIlIllIIlllllIIl + lllllllllllllllllIlIllIIllllIlll * lllllllllllllllllIlIllIIllllIlll;
                if (this.target != null) {
                    this.targetX = this.target.posX;
                    this.targetZ = this.target.posZ;
                    final double lllllllllllllllllIlIllIIlllIlllI = this.targetX - this.posX;
                    final double lllllllllllllllllIlIllIIlllIllIl = this.targetZ - this.posZ;
                    final double lllllllllllllllllIlIllIIlllIllII = Math.sqrt(lllllllllllllllllIlIllIIlllIlllI * lllllllllllllllllIlIllIIlllIlllI + lllllllllllllllllIlIllIIlllIllIl * lllllllllllllllllIlIllIIlllIllIl);
                    double lllllllllllllllllIlIllIIllllIIII = 0.4000000059604645 + lllllllllllllllllIlIllIIlllIllII / 80.0 - 1.0;
                    if (lllllllllllllllllIlIllIIllllIIII > 10.0) {
                        lllllllllllllllllIlIllIIllllIIII = 10.0;
                    }
                    this.targetY = this.target.getEntityBoundingBox().minY + lllllllllllllllllIlIllIIllllIIII;
                }
                else {
                    this.targetX += this.rand.nextGaussian() * 2.0;
                    this.targetZ += this.rand.nextGaussian() * 2.0;
                }
                if (this.forceNewTarget || lllllllllllllllllIlIllIIllllIlIl < 100.0 || lllllllllllllllllIlIllIIllllIlIl > 22500.0 || this.isCollidedHorizontally || this.isCollidedVertically) {
                    this.setNewTarget();
                }
                lllllllllllllllllIlIllIIlllllIIl /= MathHelper.sqrt_double(lllllllllllllllllIlIllIIllllIIll * lllllllllllllllllIlIllIIllllIIll + lllllllllllllllllIlIllIIllllIlll * lllllllllllllllllIlIllIIllllIlll);
                final float lllllllllllllllllIlIllIIllllIIlI = 0.6f;
                lllllllllllllllllIlIllIIlllllIIl = MathHelper.clamp_double(lllllllllllllllllIlIllIIlllllIIl, -lllllllllllllllllIlIllIIllllIIlI, lllllllllllllllllIlIllIIllllIIlI);
                this.motionY += lllllllllllllllllIlIllIIlllllIIl * 0.10000000149011612;
                this.rotationYaw = MathHelper.wrapAngleTo180_float(this.rotationYaw);
                final double lllllllllllllllllIlIllIIlllIlIll = 180.0 - Math.atan2(lllllllllllllllllIlIllIIllllIIll, lllllllllllllllllIlIllIIllllIlll) * 180.0 / 3.141592653589793;
                double lllllllllllllllllIlIllIIlllIlIlI = MathHelper.wrapAngleTo180_double(lllllllllllllllllIlIllIIlllIlIll - this.rotationYaw);
                if (lllllllllllllllllIlIllIIlllIlIlI > 50.0) {
                    lllllllllllllllllIlIllIIlllIlIlI = 50.0;
                }
                if (lllllllllllllllllIlIllIIlllIlIlI < -50.0) {
                    lllllllllllllllllIlIllIIlllIlIlI = -50.0;
                }
                final Vec3 lllllllllllllllllIlIllIIlllIlIIl = new Vec3(this.targetX - this.posX, this.targetY - this.posY, this.targetZ - this.posZ).normalize();
                final double lllllllllllllllllIlIllIIlllIllll = -MathHelper.cos(this.rotationYaw * 3.1415927f / 180.0f);
                final Vec3 lllllllllllllllllIlIllIIlllIlIII = new Vec3(MathHelper.sin(this.rotationYaw * 3.1415927f / 180.0f), this.motionY, lllllllllllllllllIlIllIIlllIllll).normalize();
                float lllllllllllllllllIlIllIIlllIIlll = ((float)lllllllllllllllllIlIllIIlllIlIII.dotProduct(lllllllllllllllllIlIllIIlllIlIIl) + 0.5f) / 1.5f;
                if (lllllllllllllllllIlIllIIlllIIlll < 0.0f) {
                    lllllllllllllllllIlIllIIlllIIlll = 0.0f;
                }
                this.randomYawVelocity *= 0.8f;
                final float lllllllllllllllllIlIllIIlllIIllI = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ) * 1.0f + 1.0f;
                double lllllllllllllllllIlIllIIlllIIlIl = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ) * 1.0 + 1.0;
                if (lllllllllllllllllIlIllIIlllIIlIl > 40.0) {
                    lllllllllllllllllIlIllIIlllIIlIl = 40.0;
                }
                this.randomYawVelocity += (float)(lllllllllllllllllIlIllIIlllIlIlI * (0.699999988079071 / lllllllllllllllllIlIllIIlllIIlIl / lllllllllllllllllIlIllIIlllIIllI));
                this.rotationYaw += this.randomYawVelocity * 0.1f;
                final float lllllllllllllllllIlIllIIlllIIlII = (float)(2.0 / (lllllllllllllllllIlIllIIlllIIlIl + 1.0));
                final float lllllllllllllllllIlIllIIlllIIIll = 0.06f;
                this.moveFlying(0.0f, -1.0f, lllllllllllllllllIlIllIIlllIIIll * (lllllllllllllllllIlIllIIlllIIlll * lllllllllllllllllIlIllIIlllIIlII + (1.0f - lllllllllllllllllIlIllIIlllIIlII)));
                if (this.slowed) {
                    this.moveEntity(this.motionX * 0.800000011920929, this.motionY * 0.800000011920929, this.motionZ * 0.800000011920929);
                }
                else {
                    this.moveEntity(this.motionX, this.motionY, this.motionZ);
                }
                final Vec3 lllllllllllllllllIlIllIIlllIIIlI = new Vec3(this.motionX, this.motionY, this.motionZ).normalize();
                float lllllllllllllllllIlIllIIlllIIIIl = ((float)lllllllllllllllllIlIllIIlllIIIlI.dotProduct(lllllllllllllllllIlIllIIlllIlIII) + 1.0f) / 2.0f;
                lllllllllllllllllIlIllIIlllIIIIl = 0.8f + 0.15f * lllllllllllllllllIlIllIIlllIIIIl;
                this.motionX *= lllllllllllllllllIlIllIIlllIIIIl;
                this.motionZ *= lllllllllllllllllIlIllIIlllIIIIl;
                this.motionY *= 0.9100000262260437;
            }
            this.renderYawOffset = this.rotationYaw;
            final EntityDragonPart dragonPartHead = this.dragonPartHead;
            final EntityDragonPart dragonPartHead2 = this.dragonPartHead;
            final float n = 3.0f;
            dragonPartHead2.height = n;
            dragonPartHead.width = n;
            final EntityDragonPart dragonPartTail1 = this.dragonPartTail1;
            final EntityDragonPart dragonPartTail2 = this.dragonPartTail1;
            final float n2 = 2.0f;
            dragonPartTail2.height = n2;
            dragonPartTail1.width = n2;
            final EntityDragonPart dragonPartTail3 = this.dragonPartTail2;
            final EntityDragonPart dragonPartTail4 = this.dragonPartTail2;
            final float n3 = 2.0f;
            dragonPartTail4.height = n3;
            dragonPartTail3.width = n3;
            final EntityDragonPart dragonPartTail5 = this.dragonPartTail3;
            final EntityDragonPart dragonPartTail6 = this.dragonPartTail3;
            final float n4 = 2.0f;
            dragonPartTail6.height = n4;
            dragonPartTail5.width = n4;
            this.dragonPartBody.height = 3.0f;
            this.dragonPartBody.width = 5.0f;
            this.dragonPartWing1.height = 2.0f;
            this.dragonPartWing1.width = 4.0f;
            this.dragonPartWing2.height = 3.0f;
            this.dragonPartWing2.width = 4.0f;
            final float lllllllllllllllllIlIllIIlllllllI = (float)(this.getMovementOffsets(5, 1.0f)[1] - this.getMovementOffsets(10, 1.0f)[1]) * 10.0f / 180.0f * 3.1415927f;
            final float lllllllllllllllllIlIllIIllllllII = MathHelper.cos(lllllllllllllllllIlIllIIlllllllI);
            final float lllllllllllllllllIlIllIIlllIIIII = -MathHelper.sin(lllllllllllllllllIlIllIIlllllllI);
            final float lllllllllllllllllIlIllIIllIlllll = this.rotationYaw * 3.1415927f / 180.0f;
            final float lllllllllllllllllIlIllIIllIllllI = MathHelper.sin(lllllllllllllllllIlIllIIllIlllll);
            final float lllllllllllllllllIlIllIIllIlllIl = MathHelper.cos(lllllllllllllllllIlIllIIllIlllll);
            this.dragonPartBody.onUpdate();
            this.dragonPartBody.setLocationAndAngles(this.posX + lllllllllllllllllIlIllIIllIllllI * 0.5f, this.posY, this.posZ - lllllllllllllllllIlIllIIllIlllIl * 0.5f, 0.0f, 0.0f);
            this.dragonPartWing1.onUpdate();
            this.dragonPartWing1.setLocationAndAngles(this.posX + lllllllllllllllllIlIllIIllIlllIl * 4.5f, this.posY + 2.0, this.posZ + lllllllllllllllllIlIllIIllIllllI * 4.5f, 0.0f, 0.0f);
            this.dragonPartWing2.onUpdate();
            this.dragonPartWing2.setLocationAndAngles(this.posX - lllllllllllllllllIlIllIIllIlllIl * 4.5f, this.posY + 2.0, this.posZ - lllllllllllllllllIlIllIIllIllllI * 4.5f, 0.0f, 0.0f);
            if (!this.worldObj.isRemote && this.hurtTime == 0) {
                this.collideWithEntities(this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.dragonPartWing1.getEntityBoundingBox().expand(4.0, 2.0, 4.0).offset(0.0, -2.0, 0.0)));
                this.collideWithEntities(this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.dragonPartWing2.getEntityBoundingBox().expand(4.0, 2.0, 4.0).offset(0.0, -2.0, 0.0)));
                this.attackEntitiesInList(this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.dragonPartHead.getEntityBoundingBox().expand(1.0, 1.0, 1.0)));
            }
            final double[] lllllllllllllllllIlIllIIllIlllII = this.getMovementOffsets(5, 1.0f);
            final double[] lllllllllllllllllIlIllIIllIllIll = this.getMovementOffsets(0, 1.0f);
            final float lllllllllllllllllIlIllIIllllIIIl = MathHelper.sin(this.rotationYaw * 3.1415927f / 180.0f - this.randomYawVelocity * 0.01f);
            final float lllllllllllllllllIlIllIIllIllIlI = MathHelper.cos(this.rotationYaw * 3.1415927f / 180.0f - this.randomYawVelocity * 0.01f);
            this.dragonPartHead.onUpdate();
            this.dragonPartHead.setLocationAndAngles(this.posX + lllllllllllllllllIlIllIIllllIIIl * 5.5f * lllllllllllllllllIlIllIIllllllII, this.posY + (lllllllllllllllllIlIllIIllIllIll[1] - lllllllllllllllllIlIllIIllIlllII[1]) * 1.0 + lllllllllllllllllIlIllIIlllIIIII * 5.5f, this.posZ - lllllllllllllllllIlIllIIllIllIlI * 5.5f * lllllllllllllllllIlIllIIllllllII, 0.0f, 0.0f);
            for (int lllllllllllllllllIlIllIIllIllIIl = 0; lllllllllllllllllIlIllIIllIllIIl < 3; ++lllllllllllllllllIlIllIIllIllIIl) {
                EntityDragonPart lllllllllllllllllIlIllIIllIllIII = null;
                if (lllllllllllllllllIlIllIIllIllIIl == 0) {
                    lllllllllllllllllIlIllIIllIllIII = this.dragonPartTail1;
                }
                if (lllllllllllllllllIlIllIIllIllIIl == 1) {
                    lllllllllllllllllIlIllIIllIllIII = this.dragonPartTail2;
                }
                if (lllllllllllllllllIlIllIIllIllIIl == 2) {
                    lllllllllllllllllIlIllIIllIllIII = this.dragonPartTail3;
                }
                final double[] lllllllllllllllllIlIllIIllIlIlll = this.getMovementOffsets(12 + lllllllllllllllllIlIllIIllIllIIl * 2, 1.0f);
                final float lllllllllllllllllIlIllIIllIlIllI = this.rotationYaw * 3.1415927f / 180.0f + this.simplifyAngle(lllllllllllllllllIlIllIIllIlIlll[0] - lllllllllllllllllIlIllIIllIlllII[0]) * 3.1415927f / 180.0f * 1.0f;
                final float lllllllllllllllllIlIllIIllIlIlIl = MathHelper.sin(lllllllllllllllllIlIllIIllIlIllI);
                final float lllllllllllllllllIlIllIIllIlIlII = MathHelper.cos(lllllllllllllllllIlIllIIllIlIllI);
                final float lllllllllllllllllIlIllIIllIlIIll = 1.5f;
                final float lllllllllllllllllIlIllIIllIlIIlI = (lllllllllllllllllIlIllIIllIllIIl + 1) * 2.0f;
                lllllllllllllllllIlIllIIllIllIII.onUpdate();
                lllllllllllllllllIlIllIIllIllIII.setLocationAndAngles(this.posX - (lllllllllllllllllIlIllIIllIllllI * lllllllllllllllllIlIllIIllIlIIll + lllllllllllllllllIlIllIIllIlIlIl * lllllllllllllllllIlIllIIllIlIIlI) * lllllllllllllllllIlIllIIllllllII, this.posY + (lllllllllllllllllIlIllIIllIlIlll[1] - lllllllllllllllllIlIllIIllIlllII[1]) * 1.0 - (lllllllllllllllllIlIllIIllIlIIlI + lllllllllllllllllIlIllIIllIlIIll) * lllllllllllllllllIlIllIIlllIIIII + 1.5, this.posZ + (lllllllllllllllllIlIllIIllIlllIl * lllllllllllllllllIlIllIIllIlIIll + lllllllllllllllllIlIllIIllIlIlII * lllllllllllllllllIlIllIIllIlIIlI) * lllllllllllllllllIlIllIIllllllII, 0.0f, 0.0f);
            }
            if (!this.worldObj.isRemote) {
                this.slowed = (this.destroyBlocksInAABB(this.dragonPartHead.getEntityBoundingBox()) | this.destroyBlocksInAABB(this.dragonPartBody.getEntityBoundingBox()));
            }
        }
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
    }
    
    protected boolean func_82195_e(final DamageSource lllllllllllllllllIlIllIIIIIIllII, final float lllllllllllllllllIlIllIIIIIIlIll) {
        return super.attackEntityFrom(lllllllllllllllllIlIllIIIIIIllII, lllllllllllllllllIlIllIIIIIIlIll);
    }
    
    @Override
    protected void despawnEntity() {
    }
    
    @Override
    protected String getHurtSound() {
        return "mob.enderdragon.hit";
    }
    
    @Override
    public boolean canBeCollidedWith() {
        return false;
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(200.0);
    }
    
    private boolean destroyBlocksInAABB(final AxisAlignedBB lllllllllllllllllIlIllIIIIllllll) {
        final int lllllllllllllllllIlIllIIIlIIllll = MathHelper.floor_double(lllllllllllllllllIlIllIIIIllllll.minX);
        final int lllllllllllllllllIlIllIIIlIIlllI = MathHelper.floor_double(lllllllllllllllllIlIllIIIIllllll.minY);
        final int lllllllllllllllllIlIllIIIlIIllIl = MathHelper.floor_double(lllllllllllllllllIlIllIIIIllllll.minZ);
        final int lllllllllllllllllIlIllIIIlIIllII = MathHelper.floor_double(lllllllllllllllllIlIllIIIIllllll.maxX);
        final int lllllllllllllllllIlIllIIIlIIlIll = MathHelper.floor_double(lllllllllllllllllIlIllIIIIllllll.maxY);
        final int lllllllllllllllllIlIllIIIlIIlIlI = MathHelper.floor_double(lllllllllllllllllIlIllIIIIllllll.maxZ);
        boolean lllllllllllllllllIlIllIIIlIIlIIl = false;
        boolean lllllllllllllllllIlIllIIIlIIlIII = false;
        for (int lllllllllllllllllIlIllIIIlIIIlll = lllllllllllllllllIlIllIIIlIIllll; lllllllllllllllllIlIllIIIlIIIlll <= lllllllllllllllllIlIllIIIlIIllII; ++lllllllllllllllllIlIllIIIlIIIlll) {
            for (int lllllllllllllllllIlIllIIIlIIIllI = lllllllllllllllllIlIllIIIlIIlllI; lllllllllllllllllIlIllIIIlIIIllI <= lllllllllllllllllIlIllIIIlIIlIll; ++lllllllllllllllllIlIllIIIlIIIllI) {
                for (int lllllllllllllllllIlIllIIIlIIIlIl = lllllllllllllllllIlIllIIIlIIllIl; lllllllllllllllllIlIllIIIlIIIlIl <= lllllllllllllllllIlIllIIIlIIlIlI; ++lllllllllllllllllIlIllIIIlIIIlIl) {
                    final Block lllllllllllllllllIlIllIIIlIIIlII = this.worldObj.getBlockState(new BlockPos(lllllllllllllllllIlIllIIIlIIIlll, lllllllllllllllllIlIllIIIlIIIllI, lllllllllllllllllIlIllIIIlIIIlIl)).getBlock();
                    if (lllllllllllllllllIlIllIIIlIIIlII.getMaterial() != Material.air) {
                        if (lllllllllllllllllIlIllIIIlIIIlII != Blocks.barrier && lllllllllllllllllIlIllIIIlIIIlII != Blocks.obsidian && lllllllllllllllllIlIllIIIlIIIlII != Blocks.end_stone && lllllllllllllllllIlIllIIIlIIIlII != Blocks.bedrock && lllllllllllllllllIlIllIIIlIIIlII != Blocks.command_block && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
                            lllllllllllllllllIlIllIIIlIIlIII = (this.worldObj.setBlockToAir(new BlockPos(lllllllllllllllllIlIllIIIlIIIlll, lllllllllllllllllIlIllIIIlIIIllI, lllllllllllllllllIlIllIIIlIIIlIl)) || lllllllllllllllllIlIllIIIlIIlIII);
                        }
                        else {
                            lllllllllllllllllIlIllIIIlIIlIIl = true;
                        }
                    }
                }
            }
        }
        if (lllllllllllllllllIlIllIIIlIIlIII) {
            final double lllllllllllllllllIlIllIIIlIIIIll = lllllllllllllllllIlIllIIIIllllll.minX + (lllllllllllllllllIlIllIIIIllllll.maxX - lllllllllllllllllIlIllIIIIllllll.minX) * this.rand.nextFloat();
            final double lllllllllllllllllIlIllIIIlIIIIlI = lllllllllllllllllIlIllIIIIllllll.minY + (lllllllllllllllllIlIllIIIIllllll.maxY - lllllllllllllllllIlIllIIIIllllll.minY) * this.rand.nextFloat();
            final double lllllllllllllllllIlIllIIIlIIIIIl = lllllllllllllllllIlIllIIIIllllll.minZ + (lllllllllllllllllIlIllIIIIllllll.maxZ - lllllllllllllllllIlIllIIIIllllll.minZ) * this.rand.nextFloat();
            this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, lllllllllllllllllIlIllIIIlIIIIll, lllllllllllllllllIlIllIIIlIIIIlI, lllllllllllllllllIlIllIIIlIIIIIl, 0.0, 0.0, 0.0, new int[0]);
        }
        return lllllllllllllllllIlIllIIIlIIlIIl;
    }
    
    private void func_175499_a(final BlockPos lllllllllllllllllIlIlIlllllIllII) {
        final boolean lllllllllllllllllIlIlIlllllIlIll = true;
        final double lllllllllllllllllIlIlIlllllIlIlI = 12.25;
        final double lllllllllllllllllIlIlIlllllIlIIl = 6.25;
        for (int lllllllllllllllllIlIlIlllllIlIII = -1; lllllllllllllllllIlIlIlllllIlIII <= 32; ++lllllllllllllllllIlIlIlllllIlIII) {
            for (int lllllllllllllllllIlIlIlllllIIlll = -4; lllllllllllllllllIlIlIlllllIIlll <= 4; ++lllllllllllllllllIlIlIlllllIIlll) {
                for (int lllllllllllllllllIlIlIlllllIIllI = -4; lllllllllllllllllIlIlIlllllIIllI <= 4; ++lllllllllllllllllIlIlIlllllIIllI) {
                    final double lllllllllllllllllIlIlIlllllIIlIl = lllllllllllllllllIlIlIlllllIIlll * lllllllllllllllllIlIlIlllllIIlll + lllllllllllllllllIlIlIlllllIIllI * lllllllllllllllllIlIlIlllllIIllI;
                    if (lllllllllllllllllIlIlIlllllIIlIl <= 12.25) {
                        final BlockPos lllllllllllllllllIlIlIlllllIIlII = lllllllllllllllllIlIlIlllllIllII.add(lllllllllllllllllIlIlIlllllIIlll, lllllllllllllllllIlIlIlllllIlIII, lllllllllllllllllIlIlIlllllIIllI);
                        if (lllllllllllllllllIlIlIlllllIlIII < 0) {
                            if (lllllllllllllllllIlIlIlllllIIlIl <= 6.25) {
                                this.worldObj.setBlockState(lllllllllllllllllIlIlIlllllIIlII, Blocks.bedrock.getDefaultState());
                            }
                        }
                        else if (lllllllllllllllllIlIlIlllllIlIII > 0) {
                            this.worldObj.setBlockState(lllllllllllllllllIlIlIlllllIIlII, Blocks.air.getDefaultState());
                        }
                        else if (lllllllllllllllllIlIlIlllllIIlIl > 6.25) {
                            this.worldObj.setBlockState(lllllllllllllllllIlIlIlllllIIlII, Blocks.bedrock.getDefaultState());
                        }
                        else {
                            this.worldObj.setBlockState(lllllllllllllllllIlIlIlllllIIlII, Blocks.end_portal.getDefaultState());
                        }
                    }
                }
            }
        }
        this.worldObj.setBlockState(lllllllllllllllllIlIlIlllllIllII, Blocks.bedrock.getDefaultState());
        this.worldObj.setBlockState(lllllllllllllllllIlIlIlllllIllII.offsetUp(), Blocks.bedrock.getDefaultState());
        final BlockPos lllllllllllllllllIlIlIlllllIIIll = lllllllllllllllllIlIlIlllllIllII.offsetUp(2);
        this.worldObj.setBlockState(lllllllllllllllllIlIlIlllllIIIll, Blocks.bedrock.getDefaultState());
        this.worldObj.setBlockState(lllllllllllllllllIlIlIlllllIIIll.offsetWest(), Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING_PROP, EnumFacing.EAST));
        this.worldObj.setBlockState(lllllllllllllllllIlIlIlllllIIIll.offsetEast(), Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING_PROP, EnumFacing.WEST));
        this.worldObj.setBlockState(lllllllllllllllllIlIlIlllllIIIll.offsetNorth(), Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING_PROP, EnumFacing.SOUTH));
        this.worldObj.setBlockState(lllllllllllllllllIlIlIlllllIIIll.offsetSouth(), Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING_PROP, EnumFacing.NORTH));
        this.worldObj.setBlockState(lllllllllllllllllIlIlIlllllIllII.offsetUp(3), Blocks.bedrock.getDefaultState());
        this.worldObj.setBlockState(lllllllllllllllllIlIlIlllllIllII.offsetUp(4), Blocks.dragon_egg.getDefaultState());
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource lllllllllllllllllIlIllIIIIIllIII, final float lllllllllllllllllIlIllIIIIIlIlII) {
        if (lllllllllllllllllIlIllIIIIIllIII instanceof EntityDamageSource && ((EntityDamageSource)lllllllllllllllllIlIllIIIIIllIII).func_180139_w()) {
            this.func_82195_e(lllllllllllllllllIlIllIIIIIllIII, lllllllllllllllllIlIllIIIIIlIlII);
        }
        return false;
    }
    
    @Override
    public Entity[] getParts() {
        return this.dragonPartArray;
    }
    
    static {
        __OBFID = "CL_00001659";
    }
    
    @Override
    public World func_82194_d() {
        return this.worldObj;
    }
    
    private float simplifyAngle(final double lllllllllllllllllIlIllIIIllIIIlI) {
        return (float)MathHelper.wrapAngleTo180_double(lllllllllllllllllIlIllIIIllIIIlI);
    }
    
    @Override
    public boolean attackEntityFromPart(final EntityDragonPart lllllllllllllllllIlIllIIIIlIlIIl, final DamageSource lllllllllllllllllIlIllIIIIlIIIIl, float lllllllllllllllllIlIllIIIIlIIIII) {
        if (lllllllllllllllllIlIllIIIIlIlIIl != this.dragonPartHead) {
            lllllllllllllllllIlIllIIIIlIIIII = lllllllllllllllllIlIllIIIIlIIIII / 4.0f + 1.0f;
        }
        final float lllllllllllllllllIlIllIIIIlIIllI = this.rotationYaw * 3.1415927f / 180.0f;
        final float lllllllllllllllllIlIllIIIIlIIlIl = MathHelper.sin(lllllllllllllllllIlIllIIIIlIIllI);
        final float lllllllllllllllllIlIllIIIIlIIlII = MathHelper.cos(lllllllllllllllllIlIllIIIIlIIllI);
        this.targetX = this.posX + lllllllllllllllllIlIllIIIIlIIlIl * 5.0f + (this.rand.nextFloat() - 0.5f) * 2.0f;
        this.targetY = this.posY + this.rand.nextFloat() * 3.0f + 1.0;
        this.targetZ = this.posZ - lllllllllllllllllIlIllIIIIlIIlII * 5.0f + (this.rand.nextFloat() - 0.5f) * 2.0f;
        this.target = null;
        if (lllllllllllllllllIlIllIIIIlIIIIl.getEntity() instanceof EntityPlayer || lllllllllllllllllIlIllIIIIlIIIIl.isExplosion()) {
            this.func_82195_e(lllllllllllllllllIlIllIIIIlIIIIl, (float)lllllllllllllllllIlIllIIIIlIIIII);
        }
        return true;
    }
    
    @Override
    public void func_174812_G() {
        this.setDead();
    }
}
