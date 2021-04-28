package net.minecraft.entity.ai;

import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.*;
import net.minecraft.stats.*;
import net.minecraft.util.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.player.*;
import java.util.*;

public class EntityAIMate extends EntityAIBase
{
    /* synthetic */ World theWorld;
    private /* synthetic */ EntityAnimal theAnimal;
    /* synthetic */ double moveSpeed;
    /* synthetic */ int spawnBabyDelay;
    private /* synthetic */ EntityAnimal targetMate;
    
    public EntityAIMate(final EntityAnimal llllllllllllllllIIIIIIlllIIIIIll, final double llllllllllllllllIIIIIIlllIIIIIlI) {
        this.theAnimal = llllllllllllllllIIIIIIlllIIIIIll;
        this.theWorld = llllllllllllllllIIIIIIlllIIIIIll.worldObj;
        this.moveSpeed = llllllllllllllllIIIIIIlllIIIIIlI;
        this.setMutexBits(3);
    }
    
    static {
        __OBFID = "CL_00001578";
    }
    
    @Override
    public boolean shouldExecute() {
        if (!this.theAnimal.isInLove()) {
            return false;
        }
        this.targetMate = this.getNearbyMate();
        return this.targetMate != null;
    }
    
    @Override
    public void resetTask() {
        this.targetMate = null;
        this.spawnBabyDelay = 0;
    }
    
    @Override
    public boolean continueExecuting() {
        return this.targetMate.isEntityAlive() && this.targetMate.isInLove() && this.spawnBabyDelay < 60;
    }
    
    private EntityAnimal getNearbyMate() {
        final float llllllllllllllllIIIIIIllIllIlIlI = 8.0f;
        final List llllllllllllllllIIIIIIllIllIlIIl = this.theWorld.getEntitiesWithinAABB(this.theAnimal.getClass(), this.theAnimal.getEntityBoundingBox().expand(llllllllllllllllIIIIIIllIllIlIlI, llllllllllllllllIIIIIIllIllIlIlI, llllllllllllllllIIIIIIllIllIlIlI));
        double llllllllllllllllIIIIIIllIllIlIII = Double.MAX_VALUE;
        EntityAnimal llllllllllllllllIIIIIIllIllIIlll = null;
        for (final EntityAnimal llllllllllllllllIIIIIIllIllIIlIl : llllllllllllllllIIIIIIllIllIlIIl) {
            if (this.theAnimal.canMateWith(llllllllllllllllIIIIIIllIllIIlIl) && this.theAnimal.getDistanceSqToEntity(llllllllllllllllIIIIIIllIllIIlIl) < llllllllllllllllIIIIIIllIllIlIII) {
                llllllllllllllllIIIIIIllIllIIlll = llllllllllllllllIIIIIIllIllIIlIl;
                llllllllllllllllIIIIIIllIllIlIII = this.theAnimal.getDistanceSqToEntity(llllllllllllllllIIIIIIllIllIIlIl);
            }
        }
        return llllllllllllllllIIIIIIllIllIIlll;
    }
    
    private void spawnBaby() {
        final EntityAgeable llllllllllllllllIIIIIIllIlIlIlII = this.theAnimal.createChild(this.targetMate);
        if (llllllllllllllllIIIIIIllIlIlIlII != null) {
            EntityPlayer llllllllllllllllIIIIIIllIlIlIIll = this.theAnimal.func_146083_cb();
            if (llllllllllllllllIIIIIIllIlIlIIll == null && this.targetMate.func_146083_cb() != null) {
                llllllllllllllllIIIIIIllIlIlIIll = this.targetMate.func_146083_cb();
            }
            if (llllllllllllllllIIIIIIllIlIlIIll != null) {
                llllllllllllllllIIIIIIllIlIlIIll.triggerAchievement(StatList.animalsBredStat);
                if (this.theAnimal instanceof EntityCow) {
                    llllllllllllllllIIIIIIllIlIlIIll.triggerAchievement(AchievementList.breedCow);
                }
            }
            this.theAnimal.setGrowingAge(6000);
            this.targetMate.setGrowingAge(6000);
            this.theAnimal.resetInLove();
            this.targetMate.resetInLove();
            llllllllllllllllIIIIIIllIlIlIlII.setGrowingAge(-24000);
            llllllllllllllllIIIIIIllIlIlIlII.setLocationAndAngles(this.theAnimal.posX, this.theAnimal.posY, this.theAnimal.posZ, 0.0f, 0.0f);
            this.theWorld.spawnEntityInWorld(llllllllllllllllIIIIIIllIlIlIlII);
            final Random llllllllllllllllIIIIIIllIlIlIIlI = this.theAnimal.getRNG();
            for (int llllllllllllllllIIIIIIllIlIlIIIl = 0; llllllllllllllllIIIIIIllIlIlIIIl < 7; ++llllllllllllllllIIIIIIllIlIlIIIl) {
                final double llllllllllllllllIIIIIIllIlIlIIII = llllllllllllllllIIIIIIllIlIlIIlI.nextGaussian() * 0.02;
                final double llllllllllllllllIIIIIIllIlIIllll = llllllllllllllllIIIIIIllIlIlIIlI.nextGaussian() * 0.02;
                final double llllllllllllllllIIIIIIllIlIIlllI = llllllllllllllllIIIIIIllIlIlIIlI.nextGaussian() * 0.02;
                this.theWorld.spawnParticle(EnumParticleTypes.HEART, this.theAnimal.posX + llllllllllllllllIIIIIIllIlIlIIlI.nextFloat() * this.theAnimal.width * 2.0f - this.theAnimal.width, this.theAnimal.posY + 0.5 + llllllllllllllllIIIIIIllIlIlIIlI.nextFloat() * this.theAnimal.height, this.theAnimal.posZ + llllllllllllllllIIIIIIllIlIlIIlI.nextFloat() * this.theAnimal.width * 2.0f - this.theAnimal.width, llllllllllllllllIIIIIIllIlIlIIII, llllllllllllllllIIIIIIllIlIIllll, llllllllllllllllIIIIIIllIlIIlllI, new int[0]);
            }
            if (this.theWorld.getGameRules().getGameRuleBooleanValue("doMobLoot")) {
                this.theWorld.spawnEntityInWorld(new EntityXPOrb(this.theWorld, this.theAnimal.posX, this.theAnimal.posY, this.theAnimal.posZ, llllllllllllllllIIIIIIllIlIlIIlI.nextInt(7) + 1));
            }
        }
    }
    
    @Override
    public void updateTask() {
        this.theAnimal.getLookHelper().setLookPositionWithEntity(this.targetMate, 10.0f, (float)this.theAnimal.getVerticalFaceSpeed());
        this.theAnimal.getNavigator().tryMoveToEntityLiving(this.targetMate, this.moveSpeed);
        ++this.spawnBabyDelay;
        if (this.spawnBabyDelay >= 60 && this.theAnimal.getDistanceSqToEntity(this.targetMate) < 9.0) {
            this.spawnBaby();
        }
    }
}
