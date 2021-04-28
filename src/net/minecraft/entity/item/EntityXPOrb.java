package net.minecraft.entity.item;

import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.block.material.*;
import net.minecraft.nbt.*;
import net.minecraft.world.*;
import net.minecraft.util.*;

public class EntityXPOrb extends Entity
{
    private /* synthetic */ int xpOrbHealth;
    public /* synthetic */ int xpOrbAge;
    public /* synthetic */ int xpColor;
    private /* synthetic */ int xpValue;
    private /* synthetic */ EntityPlayer closestPlayer;
    private /* synthetic */ int xpTargetColor;
    public /* synthetic */ int field_70532_c;
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.field_70532_c > 0) {
            --this.field_70532_c;
        }
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.motionY -= 0.029999999329447746;
        if (this.worldObj.getBlockState(new BlockPos(this)).getBlock().getMaterial() == Material.lava) {
            this.motionY = 0.20000000298023224;
            this.motionX = (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f;
            this.motionZ = (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f;
            this.playSound("random.fizz", 0.4f, 2.0f + this.rand.nextFloat() * 0.4f);
        }
        this.pushOutOfBlocks(this.posX, (this.getEntityBoundingBox().minY + this.getEntityBoundingBox().maxY) / 2.0, this.posZ);
        final double lllllllllllllllIIIlIIIlllIlIllIl = 8.0;
        if (this.xpTargetColor < this.xpColor - 20 + this.getEntityId() % 100) {
            if (this.closestPlayer == null || this.closestPlayer.getDistanceSqToEntity(this) > lllllllllllllllIIIlIIIlllIlIllIl * lllllllllllllllIIIlIIIlllIlIllIl) {
                this.closestPlayer = this.worldObj.getClosestPlayerToEntity(this, lllllllllllllllIIIlIIIlllIlIllIl);
            }
            this.xpTargetColor = this.xpColor;
        }
        if (this.closestPlayer != null && this.closestPlayer.func_175149_v()) {
            this.closestPlayer = null;
        }
        if (this.closestPlayer != null) {
            final double lllllllllllllllIIIlIIIlllIlIllII = (this.closestPlayer.posX - this.posX) / lllllllllllllllIIIlIIIlllIlIllIl;
            final double lllllllllllllllIIIlIIIlllIlIlIll = (this.closestPlayer.posY + this.closestPlayer.getEyeHeight() - this.posY) / lllllllllllllllIIIlIIIlllIlIllIl;
            final double lllllllllllllllIIIlIIIlllIlIlIlI = (this.closestPlayer.posZ - this.posZ) / lllllllllllllllIIIlIIIlllIlIllIl;
            final double lllllllllllllllIIIlIIIlllIlIlIIl = Math.sqrt(lllllllllllllllIIIlIIIlllIlIllII * lllllllllllllllIIIlIIIlllIlIllII + lllllllllllllllIIIlIIIlllIlIlIll * lllllllllllllllIIIlIIIlllIlIlIll + lllllllllllllllIIIlIIIlllIlIlIlI * lllllllllllllllIIIlIIIlllIlIlIlI);
            double lllllllllllllllIIIlIIIlllIlIlIII = 1.0 - lllllllllllllllIIIlIIIlllIlIlIIl;
            if (lllllllllllllllIIIlIIIlllIlIlIII > 0.0) {
                lllllllllllllllIIIlIIIlllIlIlIII *= lllllllllllllllIIIlIIIlllIlIlIII;
                this.motionX += lllllllllllllllIIIlIIIlllIlIllII / lllllllllllllllIIIlIIIlllIlIlIIl * lllllllllllllllIIIlIIIlllIlIlIII * 0.1;
                this.motionY += lllllllllllllllIIIlIIIlllIlIlIll / lllllllllllllllIIIlIIIlllIlIlIIl * lllllllllllllllIIIlIIIlllIlIlIII * 0.1;
                this.motionZ += lllllllllllllllIIIlIIIlllIlIlIlI / lllllllllllllllIIIlIIIlllIlIlIIl * lllllllllllllllIIIlIIIlllIlIlIII * 0.1;
            }
        }
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        float lllllllllllllllIIIlIIIlllIlIIlll = 0.98f;
        if (this.onGround) {
            lllllllllllllllIIIlIIIlllIlIIlll = this.worldObj.getBlockState(new BlockPos(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.getEntityBoundingBox().minY) - 1, MathHelper.floor_double(this.posZ))).getBlock().slipperiness * 0.98f;
        }
        this.motionX *= lllllllllllllllIIIlIIIlllIlIIlll;
        this.motionY *= 0.9800000190734863;
        this.motionZ *= lllllllllllllllIIIlIIIlllIlIIlll;
        if (this.onGround) {
            this.motionY *= -0.8999999761581421;
        }
        ++this.xpColor;
        ++this.xpOrbAge;
        if (this.xpOrbAge >= 6000) {
            this.setDead();
        }
    }
    
    public int getTextureByXP() {
        return (this.xpValue >= 2477) ? 10 : ((this.xpValue >= 1237) ? 9 : ((this.xpValue >= 617) ? 8 : ((this.xpValue >= 307) ? 7 : ((this.xpValue >= 149) ? 6 : ((this.xpValue >= 73) ? 5 : ((this.xpValue >= 37) ? 4 : ((this.xpValue >= 17) ? 3 : ((this.xpValue >= 7) ? 2 : ((this.xpValue >= 3) ? 1 : 0)))))))));
    }
    
    @Override
    public boolean handleWaterMovement() {
        return this.worldObj.handleMaterialAcceleration(this.getEntityBoundingBox(), Material.water, this);
    }
    
    @Override
    public boolean canAttackWithItem() {
        return false;
    }
    
    static {
        __OBFID = "CL_00001544";
    }
    
    @Override
    protected boolean canTriggerWalking() {
        return false;
    }
    
    public int getXpValue() {
        return this.xpValue;
    }
    
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllllIIIlIIIlllIIIlIII) {
        lllllllllllllllIIIlIIIlllIIIlIII.setShort("Health", (byte)this.xpOrbHealth);
        lllllllllllllllIIIlIIIlllIIIlIII.setShort("Age", (short)this.xpOrbAge);
        lllllllllllllllIIIlIIIlllIIIlIII.setShort("Value", (short)this.xpValue);
    }
    
    @Override
    protected void entityInit() {
    }
    
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllllIIIlIIIlllIIIIIlI) {
        this.xpOrbHealth = (lllllllllllllllIIIlIIIlllIIIIIlI.getShort("Health") & 0xFF);
        this.xpOrbAge = lllllllllllllllIIIlIIIlllIIIIIlI.getShort("Age");
        this.xpValue = lllllllllllllllIIIlIIIlllIIIIIlI.getShort("Value");
    }
    
    public EntityXPOrb(final World lllllllllllllllIIIlIIIllllIIlIll) {
        super(lllllllllllllllIIIlIIIllllIIlIll);
        this.xpOrbHealth = 5;
        this.setSize(0.25f, 0.25f);
    }
    
    @Override
    public void onCollideWithPlayer(final EntityPlayer lllllllllllllllIIIlIIIllIllllllI) {
        if (!this.worldObj.isRemote && this.field_70532_c == 0 && lllllllllllllllIIIlIIIllIllllllI.xpCooldown == 0) {
            lllllllllllllllIIIlIIIllIllllllI.xpCooldown = 2;
            this.worldObj.playSoundAtEntity(lllllllllllllllIIIlIIIllIllllllI, "random.orb", 0.1f, 0.5f * ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7f + 1.8f));
            lllllllllllllllIIIlIIIllIllllllI.onItemPickup(this, 1);
            lllllllllllllllIIIlIIIllIllllllI.addExperience(this.xpValue);
            this.setDead();
        }
    }
    
    @Override
    public int getBrightnessForRender(final float lllllllllllllllIIIlIIIllllIIIIII) {
        float lllllllllllllllIIIlIIIlllIllllll = 0.5f;
        lllllllllllllllIIIlIIIlllIllllll = MathHelper.clamp_float(lllllllllllllllIIIlIIIlllIllllll, 0.0f, 1.0f);
        final int lllllllllllllllIIIlIIIlllIlllllI = super.getBrightnessForRender(lllllllllllllllIIIlIIIllllIIIIII);
        int lllllllllllllllIIIlIIIlllIllllIl = lllllllllllllllIIIlIIIlllIlllllI & 0xFF;
        final int lllllllllllllllIIIlIIIlllIllllII = lllllllllllllllIIIlIIIlllIlllllI >> 16 & 0xFF;
        lllllllllllllllIIIlIIIlllIllllIl += (int)(lllllllllllllllIIIlIIIlllIllllll * 15.0f * 16.0f);
        if (lllllllllllllllIIIlIIIlllIllllIl > 240) {
            lllllllllllllllIIIlIIIlllIllllIl = 240;
        }
        return lllllllllllllllIIIlIIIlllIllllIl | lllllllllllllllIIIlIIIlllIllllII << 16;
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource lllllllllllllllIIIlIIIlllIIIllll, final float lllllllllllllllIIIlIIIlllIIIlllI) {
        if (this.func_180431_b(lllllllllllllllIIIlIIIlllIIIllll)) {
            return false;
        }
        this.setBeenAttacked();
        this.xpOrbHealth -= (int)lllllllllllllllIIIlIIIlllIIIlllI;
        if (this.xpOrbHealth <= 0) {
            this.setDead();
        }
        return false;
    }
    
    public EntityXPOrb(final World lllllllllllllllIIIlIIIllllIlIlII, final double lllllllllllllllIIIlIIIllllIlIIll, final double lllllllllllllllIIIlIIIllllIllIII, final double lllllllllllllllIIIlIIIllllIlIIIl, final int lllllllllllllllIIIlIIIllllIlIllI) {
        super(lllllllllllllllIIIlIIIllllIlIlII);
        this.xpOrbHealth = 5;
        this.setSize(0.5f, 0.5f);
        this.setPosition(lllllllllllllllIIIlIIIllllIlIIll, lllllllllllllllIIIlIIIllllIllIII, lllllllllllllllIIIlIIIllllIlIIIl);
        this.rotationYaw = (float)(Math.random() * 360.0);
        this.motionX = (float)(Math.random() * 0.20000000298023224 - 0.10000000149011612) * 2.0f;
        this.motionY = (float)(Math.random() * 0.2) * 2.0f;
        this.motionZ = (float)(Math.random() * 0.20000000298023224 - 0.10000000149011612) * 2.0f;
        this.xpValue = lllllllllllllllIIIlIIIllllIlIllI;
    }
    
    public static int getXPSplit(final int lllllllllllllllIIIlIIIllIlllIlII) {
        return (lllllllllllllllIIIlIIIllIlllIlII >= 2477) ? 2477 : ((lllllllllllllllIIIlIIIllIlllIlII >= 1237) ? 1237 : ((lllllllllllllllIIIlIIIllIlllIlII >= 617) ? 617 : ((lllllllllllllllIIIlIIIllIlllIlII >= 307) ? 307 : ((lllllllllllllllIIIlIIIllIlllIlII >= 149) ? 149 : ((lllllllllllllllIIIlIIIllIlllIlII >= 73) ? 73 : ((lllllllllllllllIIIlIIIllIlllIlII >= 37) ? 37 : ((lllllllllllllllIIIlIIIllIlllIlII >= 17) ? 17 : ((lllllllllllllllIIIlIIIllIlllIlII >= 7) ? 7 : ((lllllllllllllllIIIlIIIllIlllIlII >= 3) ? 3 : 1)))))))));
    }
    
    @Override
    protected void dealFireDamage(final int lllllllllllllllIIIlIIIlllIIllIIl) {
        this.attackEntityFrom(DamageSource.inFire, (float)lllllllllllllllIIIlIIIlllIIllIIl);
    }
}
