package net.minecraft.entity.monster;

import com.google.common.base.*;
import net.minecraft.entity.ai.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.enchantment.*;
import net.minecraft.util.*;

public abstract class EntityMob extends EntityCreature implements IMob
{
    protected final /* synthetic */ EntityAIBase field_175455_a;
    
    @Override
    protected String getSwimSound() {
        return "game.hostile.swim";
    }
    
    static {
        __OBFID = "CL_00001692";
    }
    
    public EntityMob(final World llllllllllllllllIIIlllIlIlIIlIIl) {
        super(llllllllllllllllIIIlllIlIlIIlIIl);
        this.field_175455_a = new EntityAIAvoidEntity(this, (Predicate)new Predicate() {
            public boolean apply(final Object llllllllllllllIlllIIIlllIlIIlIlI) {
                return this.func_179911_a((Entity)llllllllllllllIlllIIIlllIlIIlIlI);
            }
            
            static {
                __OBFID = "CL_00002208";
            }
            
            public boolean func_179911_a(final Entity llllllllllllllIlllIIIlllIlIIllll) {
                return llllllllllllllIlllIIIlllIlIIllll instanceof EntityCreeper && ((EntityCreeper)llllllllllllllIlllIIIlllIlIIllll).getCreeperState() > 0;
            }
        }, 4.0f, 1.0, 2.0);
        this.experienceValue = 5;
    }
    
    @Override
    public boolean getCanSpawnHere() {
        return this.worldObj.getDifficulty() != EnumDifficulty.PEACEFUL && this.isValidLightLevel() && super.getCanSpawnHere();
    }
    
    @Override
    protected String getDeathSound() {
        return "game.hostile.die";
    }
    
    @Override
    protected String func_146067_o(final int llllllllllllllllIIIlllIlIIlIllIl) {
        return (llllllllllllllllIIIlllIlIIlIllIl > 4) ? "game.hostile.hurt.fall.big" : "game.hostile.hurt.fall.small";
    }
    
    @Override
    protected String getSplashSound() {
        return "game.hostile.swim.splash";
    }
    
    @Override
    protected boolean func_146066_aG() {
        return true;
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource llllllllllllllllIIIlllIlIIllIlII, final float llllllllllllllllIIIlllIlIIllIIll) {
        if (this.func_180431_b(llllllllllllllllIIIlllIlIIllIlII)) {
            return false;
        }
        if (super.attackEntityFrom(llllllllllllllllIIIlllIlIIllIlII, llllllllllllllllIIIlllIlIIllIIll)) {
            final Entity llllllllllllllllIIIlllIlIIllIllI = llllllllllllllllIIIlllIlIIllIlII.getEntity();
            return this.riddenByEntity == llllllllllllllllIIIlllIlIIllIllI || this.ridingEntity == llllllllllllllllIIIlllIlIIllIllI || true;
        }
        return false;
    }
    
    @Override
    public void onLivingUpdate() {
        this.updateArmSwingProgress();
        final float llllllllllllllllIIIlllIlIlIIIlIl = this.getBrightness(1.0f);
        if (llllllllllllllllIIIlllIlIlIIIlIl > 0.5f) {
            this.entityAge += 2;
        }
        super.onLivingUpdate();
    }
    
    protected boolean isValidLightLevel() {
        final BlockPos llllllllllllllllIIIlllIlIIIIlllI = new BlockPos(this.posX, this.getEntityBoundingBox().minY, this.posZ);
        if (this.worldObj.getLightFor(EnumSkyBlock.SKY, llllllllllllllllIIIlllIlIIIIlllI) > this.rand.nextInt(32)) {
            return false;
        }
        int llllllllllllllllIIIlllIlIIIIllIl = this.worldObj.getLightFromNeighbors(llllllllllllllllIIIlllIlIIIIlllI);
        if (this.worldObj.isThundering()) {
            final int llllllllllllllllIIIlllIlIIIIllII = this.worldObj.getSkylightSubtracted();
            this.worldObj.setSkylightSubtracted(10);
            llllllllllllllllIIIlllIlIIIIllIl = this.worldObj.getLightFromNeighbors(llllllllllllllllIIIlllIlIIIIlllI);
            this.worldObj.setSkylightSubtracted(llllllllllllllllIIIlllIlIIIIllII);
        }
        return llllllllllllllllIIIlllIlIIIIllIl <= this.rand.nextInt(8);
    }
    
    @Override
    protected String getHurtSound() {
        return "game.hostile.hurt";
    }
    
    @Override
    public float func_180484_a(final BlockPos llllllllllllllllIIIlllIlIIIlIlII) {
        return 0.5f - this.worldObj.getLightBrightness(llllllllllllllllIIIlllIlIIIlIlII);
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
    }
    
    @Override
    public boolean attackEntityAsMob(final Entity llllllllllllllllIIIlllIlIIlIIlII) {
        float llllllllllllllllIIIlllIlIIlIIIll = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
        int llllllllllllllllIIIlllIlIIlIIIlI = 0;
        if (llllllllllllllllIIIlllIlIIlIIlII instanceof EntityLivingBase) {
            llllllllllllllllIIIlllIlIIlIIIll += EnchantmentHelper.func_152377_a(this.getHeldItem(), ((EntityLivingBase)llllllllllllllllIIIlllIlIIlIIlII).getCreatureAttribute());
            llllllllllllllllIIIlllIlIIlIIIlI += EnchantmentHelper.getRespiration(this);
        }
        final boolean llllllllllllllllIIIlllIlIIlIIIIl = llllllllllllllllIIIlllIlIIlIIlII.attackEntityFrom(DamageSource.causeMobDamage(this), llllllllllllllllIIIlllIlIIlIIIll);
        if (llllllllllllllllIIIlllIlIIlIIIIl) {
            if (llllllllllllllllIIIlllIlIIlIIIlI > 0) {
                llllllllllllllllIIIlllIlIIlIIlII.addVelocity(-MathHelper.sin(this.rotationYaw * 3.1415927f / 180.0f) * llllllllllllllllIIIlllIlIIlIIIlI * 0.5f, 0.1, MathHelper.cos(this.rotationYaw * 3.1415927f / 180.0f) * llllllllllllllllIIIlllIlIIlIIIlI * 0.5f);
                this.motionX *= 0.6;
                this.motionZ *= 0.6;
            }
            final int llllllllllllllllIIIlllIlIIlIIIII = EnchantmentHelper.getFireAspectModifier(this);
            if (llllllllllllllllIIIlllIlIIlIIIII > 0) {
                llllllllllllllllIIIlllIlIIlIIlII.setFire(llllllllllllllllIIIlllIlIIlIIIII * 4);
            }
            this.func_174815_a(this, llllllllllllllllIIIlllIlIIlIIlII);
        }
        return llllllllllllllllIIIlllIlIIlIIIIl;
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!this.worldObj.isRemote && this.worldObj.getDifficulty() == EnumDifficulty.PEACEFUL) {
            this.setDead();
        }
    }
}
