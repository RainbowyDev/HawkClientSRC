package net.minecraft.entity.passive;

import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.entity.ai.*;
import net.minecraft.util.*;

public class EntitySquid extends EntityWaterMob
{
    public /* synthetic */ float squidYaw;
    public /* synthetic */ float squidRotation;
    private /* synthetic */ float randomMotionVecZ;
    private /* synthetic */ float randomMotionVecY;
    public /* synthetic */ float prevSquidPitch;
    public /* synthetic */ float prevSquidRotation;
    public /* synthetic */ float tentacleAngle;
    private /* synthetic */ float rotationVelocity;
    public /* synthetic */ float lastTentacleAngle;
    private /* synthetic */ float randomMotionSpeed;
    public /* synthetic */ float prevSquidYaw;
    private /* synthetic */ float field_70871_bB;
    private /* synthetic */ float randomMotionVecX;
    public /* synthetic */ float squidPitch;
    
    static {
        __OBFID = "CL_00001651";
    }
    
    @Override
    protected Item getDropItem() {
        return null;
    }
    
    @Override
    protected String getLivingSound() {
        return null;
    }
    
    @Override
    protected String getHurtSound() {
        return null;
    }
    
    @Override
    public float getEyeHeight() {
        return this.height * 0.5f;
    }
    
    @Override
    protected void dropFewItems(final boolean lIIllllIllllIll, final int lIIllllIlllIllI) {
        for (int lIIllllIllllIIl = this.rand.nextInt(3 + lIIllllIlllIllI) + 1, lIIllllIllllIII = 0; lIIllllIllllIII < lIIllllIllllIIl; ++lIIllllIllllIII) {
            this.entityDropItem(new ItemStack(Items.dye, 1, EnumDyeColor.BLACK.getDyeColorDamage()), 0.0f);
        }
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0);
    }
    
    public void func_175568_b(final float lIIllllIlIlIllI, final float lIIllllIlIlIIIl, final float lIIllllIlIlIlII) {
        this.randomMotionVecX = lIIllllIlIlIllI;
        this.randomMotionVecY = lIIllllIlIlIIIl;
        this.randomMotionVecZ = lIIllllIlIlIlII;
    }
    
    @Override
    protected float getSoundVolume() {
        return 0.4f;
    }
    
    @Override
    public boolean isInWater() {
        return this.worldObj.handleMaterialAcceleration(this.getEntityBoundingBox().expand(0.0, -0.6000000238418579, 0.0), Material.water, this);
    }
    
    @Override
    public void handleHealthUpdate(final byte lIIllllIlIlllII) {
        if (lIIllllIlIlllII == 19) {
            this.squidRotation = 0.0f;
        }
        else {
            super.handleHealthUpdate(lIIllllIlIlllII);
        }
    }
    
    @Override
    public boolean getCanSpawnHere() {
        return this.posY > 45.0 && this.posY < 63.0 && super.getCanSpawnHere();
    }
    
    @Override
    protected String getDeathSound() {
        return null;
    }
    
    public EntitySquid(final World lIIlllllIIIllll) {
        super(lIIlllllIIIllll);
        this.setSize(0.95f, 0.95f);
        this.rand.setSeed(1 + this.getEntityId());
        this.rotationVelocity = 1.0f / (this.rand.nextFloat() + 1.0f) * 0.2f;
        this.tasks.addTask(0, new AIMoveRandom());
    }
    
    @Override
    protected boolean canTriggerWalking() {
        return false;
    }
    
    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        this.prevSquidPitch = this.squidPitch;
        this.prevSquidYaw = this.squidYaw;
        this.prevSquidRotation = this.squidRotation;
        this.lastTentacleAngle = this.tentacleAngle;
        this.squidRotation += this.rotationVelocity;
        if (this.squidRotation > 6.283185307179586) {
            if (this.worldObj.isRemote) {
                this.squidRotation = 6.2831855f;
            }
            else {
                this.squidRotation -= (float)6.283185307179586;
                if (this.rand.nextInt(10) == 0) {
                    this.rotationVelocity = 1.0f / (this.rand.nextFloat() + 1.0f) * 0.2f;
                }
                this.worldObj.setEntityState(this, (byte)19);
            }
        }
        if (this.inWater) {
            if (this.squidRotation < 3.1415927f) {
                final float lIIllllIllIllIl = this.squidRotation / 3.1415927f;
                this.tentacleAngle = MathHelper.sin(lIIllllIllIllIl * lIIllllIllIllIl * 3.1415927f) * 3.1415927f * 0.25f;
                if (lIIllllIllIllIl > 0.75) {
                    this.randomMotionSpeed = 1.0f;
                    this.field_70871_bB = 1.0f;
                }
                else {
                    this.field_70871_bB *= 0.8f;
                }
            }
            else {
                this.tentacleAngle = 0.0f;
                this.randomMotionSpeed *= 0.9f;
                this.field_70871_bB *= 0.99f;
            }
            if (!this.worldObj.isRemote) {
                this.motionX = this.randomMotionVecX * this.randomMotionSpeed;
                this.motionY = this.randomMotionVecY * this.randomMotionSpeed;
                this.motionZ = this.randomMotionVecZ * this.randomMotionSpeed;
            }
            final float lIIllllIllIllII = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.renderYawOffset += (-(float)Math.atan2(this.motionX, this.motionZ) * 180.0f / 3.1415927f - this.renderYawOffset) * 0.1f;
            this.rotationYaw = this.renderYawOffset;
            this.squidYaw += (float)(3.141592653589793 * this.field_70871_bB * 1.5);
            this.squidPitch += (-(float)Math.atan2(lIIllllIllIllII, this.motionY) * 180.0f / 3.1415927f - this.squidPitch) * 0.1f;
        }
        else {
            this.tentacleAngle = MathHelper.abs(MathHelper.sin(this.squidRotation)) * 3.1415927f * 0.25f;
            if (!this.worldObj.isRemote) {
                this.motionX = 0.0;
                this.motionY -= 0.08;
                this.motionY *= 0.9800000190734863;
                this.motionZ = 0.0;
            }
            this.squidPitch += (float)((-90.0f - this.squidPitch) * 0.02);
        }
    }
    
    @Override
    public void moveEntityWithHeading(final float lIIllllIllIIlll, final float lIIllllIllIIllI) {
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
    }
    
    public boolean func_175567_n() {
        return this.randomMotionVecX != 0.0f || this.randomMotionVecY != 0.0f || this.randomMotionVecZ != 0.0f;
    }
    
    class AIMoveRandom extends EntityAIBase
    {
        @Override
        public boolean shouldExecute() {
            return true;
        }
        
        static {
            __OBFID = "CL_00002232";
        }
        
        @Override
        public void updateTask() {
            final int llllllllllllllIlIlllIllIIlIIIIll = EntitySquid.this.getAge();
            if (llllllllllllllIlIlllIllIIlIIIIll > 100) {
                EntitySquid.this.func_175568_b(0.0f, 0.0f, 0.0f);
            }
            else if (EntitySquid.this.getRNG().nextInt(50) == 0 || !EntitySquid.this.inWater || !EntitySquid.this.func_175567_n()) {
                final float llllllllllllllIlIlllIllIIlIIIIlI = EntitySquid.this.getRNG().nextFloat() * 3.1415927f * 2.0f;
                final float llllllllllllllIlIlllIllIIlIIIIIl = MathHelper.cos(llllllllllllllIlIlllIllIIlIIIIlI) * 0.2f;
                final float llllllllllllllIlIlllIllIIlIIIIII = -0.1f + EntitySquid.this.getRNG().nextFloat() * 0.2f;
                final float llllllllllllllIlIlllIllIIIllllll = MathHelper.sin(llllllllllllllIlIlllIllIIlIIIIlI) * 0.2f;
                EntitySquid.this.func_175568_b(llllllllllllllIlIlllIllIIlIIIIIl, llllllllllllllIlIlllIllIIlIIIIII, llllllllllllllIlIlllIllIIIllllll);
            }
        }
    }
}
