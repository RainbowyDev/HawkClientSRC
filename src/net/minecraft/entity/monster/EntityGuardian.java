package net.minecraft.entity.monster;

import net.minecraft.block.material.*;
import com.google.common.base.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.network.play.server.*;
import net.minecraft.network.*;
import net.minecraft.potion.*;
import net.minecraft.nbt.*;
import net.minecraft.pathfinding.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.entity.projectile.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.*;
import net.minecraft.world.*;

public class EntityGuardian extends EntityMob
{
    private /* synthetic */ int field_175479_bo;
    private /* synthetic */ EntityLivingBase field_175478_bn;
    private /* synthetic */ float field_175485_bl;
    private /* synthetic */ float field_175486_bm;
    private /* synthetic */ boolean field_175480_bp;
    private /* synthetic */ float field_175483_bk;
    private /* synthetic */ EntityAIWander field_175481_bq;
    private /* synthetic */ float field_175484_c;
    private /* synthetic */ float field_175482_b;
    
    static {
        __OBFID = "CL_00002213";
    }
    
    public float func_175471_a(final float lllllllllllllllIIllIIIlIIlIlIlIl) {
        return this.field_175484_c + (this.field_175482_b - this.field_175484_c) * lllllllllllllllIIllIIIlIIlIlIlIl;
    }
    
    @Override
    public int getTalkInterval() {
        return 160;
    }
    
    public boolean func_175474_cn() {
        return this.dataWatcher.getWatchableObjectInt(17) != 0;
    }
    
    @Override
    public float func_180484_a(final BlockPos lllllllllllllllIIllIIIlIIlllIlll) {
        return (this.worldObj.getBlockState(lllllllllllllllIIllIIIlIIlllIlll).getBlock().getMaterial() == Material.water) ? (10.0f + this.worldObj.getLightBrightness(lllllllllllllllIIllIIIlIIlllIlll) - 0.5f) : super.func_180484_a(lllllllllllllllIIllIIIlIIlllIlll);
    }
    
    public boolean func_175472_n() {
        return this.func_175468_a(2);
    }
    
    public void func_175467_a(final boolean lllllllllllllllIIllIIIlIlIlIIIll) {
        this.func_175473_a(4, lllllllllllllllIIllIIIlIlIlIIIll);
        if (lllllllllllllllIIllIIIlIlIlIIIll) {
            this.setSize(1.9975f, 1.9975f);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30000001192092896);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(8.0);
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(80.0);
            this.enablePersistence();
            this.field_175481_bq.func_179479_b(400);
        }
    }
    
    public EntityGuardian(final World lllllllllllllllIIllIIIlIlllIIIIl) {
        super(lllllllllllllllIIllIIIlIlllIIIIl);
        this.experienceValue = 10;
        this.setSize(0.85f, 0.85f);
        this.tasks.addTask(4, new AIGuardianAttack());
        final EntityAIMoveTowardsRestriction lllllllllllllllIIllIIIlIlllIIIll;
        this.tasks.addTask(5, lllllllllllllllIIllIIIlIlllIIIll = new EntityAIMoveTowardsRestriction(this, 1.0));
        final EntityAITasks tasks = this.tasks;
        final int llllllllllllllllIIIlIllIIlIllllI = 7;
        final EntityAIWander entityAIWander = new EntityAIWander(this, 1.0, 80);
        this.field_175481_bq = entityAIWander;
        tasks.addTask(llllllllllllllllIIIlIllIIlIllllI, entityAIWander);
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityGuardian.class, 12.0f, 0.01f));
        this.tasks.addTask(9, new EntityAILookIdle(this));
        this.field_175481_bq.setMutexBits(3);
        lllllllllllllllIIllIIIlIlllIIIll.setMutexBits(3);
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityLivingBase.class, 10, true, false, (Predicate)new GuardianTargetSelector()));
        this.moveHelper = new GuardianMoveHelper();
        final float nextFloat = this.rand.nextFloat();
        this.field_175482_b = nextFloat;
        this.field_175484_c = nextFloat;
    }
    
    @Override
    public boolean handleLavaMovement() {
        return this.worldObj.checkNoEntityCollision(this.getEntityBoundingBox(), this) && this.worldObj.getCollidingBoundingBoxes(this, this.getEntityBoundingBox()).isEmpty();
    }
    
    @Override
    protected void updateAITasks() {
        super.updateAITasks();
        if (this.func_175461_cl()) {
            final boolean lllllllllllllllIIllIIIlIIIlllllI = true;
            final boolean lllllllllllllllIIllIIIlIIIllllIl = true;
            final boolean lllllllllllllllIIllIIIlIIIllllII = true;
            final boolean lllllllllllllllIIllIIIlIIIlllIll = true;
            if ((this.ticksExisted + this.getEntityId()) % 1200 == 0) {
                final Potion lllllllllllllllIIllIIIlIIIlllIlI = Potion.digSlowdown;
                final List lllllllllllllllIIllIIIlIIIlllIIl = this.worldObj.func_175661_b(EntityPlayerMP.class, (Predicate)new Predicate() {
                    static {
                        __OBFID = "CL_00002212";
                    }
                    
                    public boolean apply(final Object llllllllllllllIllllIllIlllIlIllI) {
                        return this.func_179913_a((EntityPlayerMP)llllllllllllllIllllIllIlllIlIllI);
                    }
                    
                    public boolean func_179913_a(final EntityPlayerMP llllllllllllllIllllIllIlllIlllII) {
                        return EntityGuardian.this.getDistanceSqToEntity(llllllllllllllIllllIllIlllIlllII) < 2500.0 && llllllllllllllIllllIllIlllIlllII.theItemInWorldManager.func_180239_c();
                    }
                });
                for (final EntityPlayerMP lllllllllllllllIIllIIIlIIIllIlll : lllllllllllllllIIllIIIlIIIlllIIl) {
                    if (!lllllllllllllllIIllIIIlIIIllIlll.isPotionActive(lllllllllllllllIIllIIIlIIIlllIlI) || lllllllllllllllIIllIIIlIIIllIlll.getActivePotionEffect(lllllllllllllllIIllIIIlIIIlllIlI).getAmplifier() < 2 || lllllllllllllllIIllIIIlIIIllIlll.getActivePotionEffect(lllllllllllllllIIllIIIlIIIlllIlI).getDuration() < 1200) {
                        lllllllllllllllIIllIIIlIIIllIlll.playerNetServerHandler.sendPacket(new S2BPacketChangeGameState(10, 0.0f));
                        lllllllllllllllIIllIIIlIIIllIlll.addPotionEffect(new PotionEffect(lllllllllllllllIIllIIIlIIIlllIlI.id, 6000, 2));
                    }
                }
            }
            if (!this.hasHome()) {
                this.func_175449_a(new BlockPos(this), 16);
            }
        }
    }
    
    public float func_175469_o(final float lllllllllllllllIIllIIIlIIlIIllll) {
        return this.field_175486_bm + (this.field_175485_bl - this.field_175486_bm) * lllllllllllllllIIllIIIlIIlIIllll;
    }
    
    @Override
    public boolean getCanSpawnHere() {
        return (this.rand.nextInt(20) == 0 || !this.worldObj.canBlockSeeSky(new BlockPos(this))) && super.getCanSpawnHere();
    }
    
    private void func_175463_b(final int lllllllllllllllIIllIIIlIlIIllIII) {
        this.dataWatcher.updateObject(17, lllllllllllllllIIllIIIlIlIIllIII);
    }
    
    private void func_175473_a(final int lllllllllllllllIIllIIIlIlIlllIII, final boolean lllllllllllllllIIllIIIlIlIlllIll) {
        final int lllllllllllllllIIllIIIlIlIlllIlI = this.dataWatcher.getWatchableObjectInt(16);
        if (lllllllllllllllIIllIIIlIlIlllIll) {
            this.dataWatcher.updateObject(16, lllllllllllllllIIllIIIlIlIlllIlI | lllllllllllllllIIllIIIlIlIlllIII);
        }
        else {
            this.dataWatcher.updateObject(16, lllllllllllllllIIllIIIlIlIlllIlI & ~lllllllllllllllIIllIIIlIlIlllIII);
        }
    }
    
    public float func_175477_p(final float lllllllllllllllIIllIIIlIIlIIlIll) {
        return (this.field_175479_bo + lllllllllllllllIIllIIIlIIlIIlIll) / this.func_175464_ck();
    }
    
    public boolean func_175461_cl() {
        return this.func_175468_a(4);
    }
    
    @Override
    public void func_145781_i(final int lllllllllllllllIIllIIIlIlIIIlIIl) {
        super.func_145781_i(lllllllllllllllIIllIIIlIlIIIlIIl);
        if (lllllllllllllllIIllIIIlIlIIIlIIl == 16) {
            if (this.func_175461_cl() && this.width < 1.0f) {
                this.setSize(1.9975f, 1.9975f);
            }
        }
        else if (lllllllllllllllIIllIIIlIlIIIlIIl == 17) {
            this.field_175479_bo = 0;
            this.field_175478_bn = null;
        }
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(16.0);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0);
    }
    
    public void func_175465_cm() {
        this.func_175467_a(true);
        final float n = 1.0f;
        this.field_175485_bl = n;
        this.field_175486_bm = n;
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllllIIllIIIlIllIlIIIl) {
        super.writeEntityToNBT(lllllllllllllllIIllIIIlIllIlIIIl);
        lllllllllllllllIIllIIIlIllIlIIIl.setBoolean("Elder", this.func_175461_cl());
    }
    
    public EntityLivingBase func_175466_co() {
        if (!this.func_175474_cn()) {
            return null;
        }
        if (!this.worldObj.isRemote) {
            return this.getAttackTarget();
        }
        if (this.field_175478_bn != null) {
            return this.field_175478_bn;
        }
        final Entity lllllllllllllllIIllIIIlIlIIlIIIl = this.worldObj.getEntityByID(this.dataWatcher.getWatchableObjectInt(17));
        if (lllllllllllllllIIllIIIlIlIIlIIIl instanceof EntityLivingBase) {
            this.field_175478_bn = (EntityLivingBase)lllllllllllllllIIllIIIlIlIIlIIIl;
            return this.field_175478_bn;
        }
        return null;
    }
    
    private boolean func_175468_a(final int lllllllllllllllIIllIIIlIllIIIlII) {
        return (this.dataWatcher.getWatchableObjectInt(16) & lllllllllllllllIIllIIIlIllIIIlII) != 0x0;
    }
    
    @Override
    protected String getHurtSound() {
        return this.isInWater() ? (this.func_175461_cl() ? "mob.guardian.elder.hit" : "mob.guardian.hit") : "mob.guardian.land.hit";
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllllIIllIIIlIllIllIIl) {
        super.readEntityFromNBT(lllllllllllllllIIllIIIlIllIllIIl);
        this.func_175467_a(lllllllllllllllIIllIIIlIllIllIIl.getBoolean("Elder"));
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, 0);
        this.dataWatcher.addObject(17, 0);
    }
    
    @Override
    protected PathNavigate func_175447_b(final World lllllllllllllllIIllIIIlIllIIllIl) {
        return new PathNavigateSwimmer(this, lllllllllllllllIIllIIIlIllIIllIl);
    }
    
    @Override
    public void moveEntityWithHeading(final float lllllllllllllllIIllIIIlIIIIIIIll, final float lllllllllllllllIIllIIIIlllllllll) {
        if (this.isServerWorld()) {
            if (this.isInWater()) {
                this.moveFlying(lllllllllllllllIIllIIIlIIIIIIIll, lllllllllllllllIIllIIIIlllllllll, 0.1f);
                this.moveEntity(this.motionX, this.motionY, this.motionZ);
                this.motionX *= 0.8999999761581421;
                this.motionY *= 0.8999999761581421;
                this.motionZ *= 0.8999999761581421;
                if (!this.func_175472_n() && this.getAttackTarget() == null) {
                    this.motionY -= 0.005;
                }
            }
            else {
                super.moveEntityWithHeading(lllllllllllllllIIllIIIlIIIIIIIll, lllllllllllllllIIllIIIIlllllllll);
            }
        }
        else {
            super.moveEntityWithHeading(lllllllllllllllIIllIIIlIIIIIIIll, lllllllllllllllIIllIIIIlllllllll);
        }
    }
    
    @Override
    public float getEyeHeight() {
        return this.height * 0.5f;
    }
    
    @Override
    public void onLivingUpdate() {
        if (this.worldObj.isRemote) {
            this.field_175484_c = this.field_175482_b;
            if (!this.isInWater()) {
                this.field_175483_bk = 2.0f;
                if (this.motionY > 0.0 && this.field_175480_bp && !this.isSlient()) {
                    this.worldObj.playSound(this.posX, this.posY, this.posZ, "mob.guardian.flop", 1.0f, 1.0f, false);
                }
                this.field_175480_bp = (this.motionY < 0.0 && this.worldObj.func_175677_d(new BlockPos(this).offsetDown(), false));
            }
            else if (this.func_175472_n()) {
                if (this.field_175483_bk < 0.5f) {
                    this.field_175483_bk = 4.0f;
                }
                else {
                    this.field_175483_bk += (0.5f - this.field_175483_bk) * 0.1f;
                }
            }
            else {
                this.field_175483_bk += (0.125f - this.field_175483_bk) * 0.2f;
            }
            this.field_175482_b += this.field_175483_bk;
            this.field_175486_bm = this.field_175485_bl;
            if (!this.isInWater()) {
                this.field_175485_bl = this.rand.nextFloat();
            }
            else if (this.func_175472_n()) {
                this.field_175485_bl += (0.0f - this.field_175485_bl) * 0.25f;
            }
            else {
                this.field_175485_bl += (1.0f - this.field_175485_bl) * 0.06f;
            }
            if (this.func_175472_n() && this.isInWater()) {
                final Vec3 lllllllllllllllIIllIIIlIIllIlIll = this.getLook(0.0f);
                for (int lllllllllllllllIIllIIIlIIllIlIlI = 0; lllllllllllllllIIllIIIlIIllIlIlI < 2; ++lllllllllllllllIIllIIIlIIllIlIlI) {
                    this.worldObj.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX + (this.rand.nextDouble() - 0.5) * this.width - lllllllllllllllIIllIIIlIIllIlIll.xCoord * 1.5, this.posY + this.rand.nextDouble() * this.height - lllllllllllllllIIllIIIlIIllIlIll.yCoord * 1.5, this.posZ + (this.rand.nextDouble() - 0.5) * this.width - lllllllllllllllIIllIIIlIIllIlIll.zCoord * 1.5, 0.0, 0.0, 0.0, new int[0]);
                }
            }
            if (this.func_175474_cn()) {
                if (this.field_175479_bo < this.func_175464_ck()) {
                    ++this.field_175479_bo;
                }
                final EntityLivingBase lllllllllllllllIIllIIIlIIllIlIIl = this.func_175466_co();
                if (lllllllllllllllIIllIIIlIIllIlIIl != null) {
                    this.getLookHelper().setLookPositionWithEntity(lllllllllllllllIIllIIIlIIllIlIIl, 90.0f, 90.0f);
                    this.getLookHelper().onUpdateLook();
                    final double lllllllllllllllIIllIIIlIIllIlIII = this.func_175477_p(0.0f);
                    double lllllllllllllllIIllIIIlIIllIIlll = lllllllllllllllIIllIIIlIIllIlIIl.posX - this.posX;
                    double lllllllllllllllIIllIIIlIIllIIllI = lllllllllllllllIIllIIIlIIllIlIIl.posY + lllllllllllllllIIllIIIlIIllIlIIl.height * 0.5f - (this.posY + this.getEyeHeight());
                    double lllllllllllllllIIllIIIlIIllIIlIl = lllllllllllllllIIllIIIlIIllIlIIl.posZ - this.posZ;
                    final double lllllllllllllllIIllIIIlIIllIIlII = Math.sqrt(lllllllllllllllIIllIIIlIIllIIlll * lllllllllllllllIIllIIIlIIllIIlll + lllllllllllllllIIllIIIlIIllIIllI * lllllllllllllllIIllIIIlIIllIIllI + lllllllllllllllIIllIIIlIIllIIlIl * lllllllllllllllIIllIIIlIIllIIlIl);
                    lllllllllllllllIIllIIIlIIllIIlll /= lllllllllllllllIIllIIIlIIllIIlII;
                    lllllllllllllllIIllIIIlIIllIIllI /= lllllllllllllllIIllIIIlIIllIIlII;
                    lllllllllllllllIIllIIIlIIllIIlIl /= lllllllllllllllIIllIIIlIIllIIlII;
                    double lllllllllllllllIIllIIIlIIllIIIll = this.rand.nextDouble();
                    while (lllllllllllllllIIllIIIlIIllIIIll < lllllllllllllllIIllIIIlIIllIIlII) {
                        lllllllllllllllIIllIIIlIIllIIIll += 1.8 - lllllllllllllllIIllIIIlIIllIlIII + this.rand.nextDouble() * (1.7 - lllllllllllllllIIllIIIlIIllIlIII);
                        this.worldObj.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX + lllllllllllllllIIllIIIlIIllIIlll * lllllllllllllllIIllIIIlIIllIIIll, this.posY + lllllllllllllllIIllIIIlIIllIIllI * lllllllllllllllIIllIIIlIIllIIIll + this.getEyeHeight(), this.posZ + lllllllllllllllIIllIIIlIIllIIlIl * lllllllllllllllIIllIIIlIIllIIIll, 0.0, 0.0, 0.0, new int[0]);
                    }
                }
            }
        }
        if (this.inWater) {
            this.setAir(300);
        }
        else if (this.onGround) {
            this.motionY += 0.5;
            this.motionX += (this.rand.nextFloat() * 2.0f - 1.0f) * 0.4f;
            this.motionZ += (this.rand.nextFloat() * 2.0f - 1.0f) * 0.4f;
            this.rotationYaw = this.rand.nextFloat() * 360.0f;
            this.onGround = false;
            this.isAirBorne = true;
        }
        if (this.func_175474_cn()) {
            this.rotationYaw = this.rotationYawHead;
        }
        super.onLivingUpdate();
    }
    
    @Override
    protected String getLivingSound() {
        return this.isInWater() ? (this.func_175461_cl() ? "mob.guardian.elder.idle" : "mob.guardian.idle") : "mob.guardian.land.idle";
    }
    
    @Override
    protected void dropFewItems(final boolean lllllllllllllllIIllIIIlIIIlIlIII, final int lllllllllllllllIIllIIIlIIIlIIIll) {
        final int lllllllllllllllIIllIIIlIIIlIIllI = this.rand.nextInt(3) + this.rand.nextInt(lllllllllllllllIIllIIIlIIIlIIIll + 1);
        if (lllllllllllllllIIllIIIlIIIlIIllI > 0) {
            this.entityDropItem(new ItemStack(Items.prismarine_shard, lllllllllllllllIIllIIIlIIIlIIllI, 0), 1.0f);
        }
        if (this.rand.nextInt(3 + lllllllllllllllIIllIIIlIIIlIIIll) > 1) {
            this.entityDropItem(new ItemStack(Items.fish, 1, ItemFishFood.FishType.COD.getItemDamage()), 1.0f);
        }
        else if (this.rand.nextInt(3 + lllllllllllllllIIllIIIlIIIlIIIll) > 1) {
            this.entityDropItem(new ItemStack(Items.prismarine_crystals, 1, 0), 1.0f);
        }
        if (lllllllllllllllIIllIIIlIIIlIlIII && this.func_175461_cl()) {
            this.entityDropItem(new ItemStack(Blocks.sponge, 1, 1), 1.0f);
        }
    }
    
    @Override
    public int getVerticalFaceSpeed() {
        return 180;
    }
    
    @Override
    protected boolean canTriggerWalking() {
        return false;
    }
    
    public int func_175464_ck() {
        return this.func_175461_cl() ? 60 : 80;
    }
    
    @Override
    protected boolean isValidLightLevel() {
        return true;
    }
    
    @Override
    protected String getDeathSound() {
        return this.isInWater() ? (this.func_175461_cl() ? "mob.guardian.elder.death" : "mob.guardian.death") : "mob.guardian.land.death";
    }
    
    @Override
    protected void addRandomArmor() {
        final ItemStack lllllllllllllllIIllIIIlIIIIllllI = ((WeightedRandomFishable)WeightedRandom.getRandomItem(this.rand, EntityFishHook.func_174855_j())).getItemStack(this.rand);
        this.entityDropItem(lllllllllllllllIIllIIIlIIIIllllI, 1.0f);
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource lllllllllllllllIIllIIIlIIIIIlIll, final float lllllllllllllllIIllIIIlIIIIIlIlI) {
        if (!this.func_175472_n() && !lllllllllllllllIIllIIIlIIIIIlIll.isMagicDamage() && lllllllllllllllIIllIIIlIIIIIlIll.getSourceOfDamage() instanceof EntityLivingBase) {
            final EntityLivingBase lllllllllllllllIIllIIIlIIIIIllIl = (EntityLivingBase)lllllllllllllllIIllIIIlIIIIIlIll.getSourceOfDamage();
            if (!lllllllllllllllIIllIIIlIIIIIlIll.isExplosion()) {
                lllllllllllllllIIllIIIlIIIIIllIl.attackEntityFrom(DamageSource.causeThornsDamage(this), 2.0f);
                lllllllllllllllIIllIIIlIIIIIllIl.playSound("damage.thorns", 0.5f, 1.0f);
            }
        }
        this.field_175481_bq.func_179480_f();
        return super.attackEntityFrom(lllllllllllllllIIllIIIlIIIIIlIll, lllllllllllllllIIllIIIlIIIIIlIlI);
    }
    
    private void func_175476_l(final boolean lllllllllllllllIIllIIIlIlIlIllll) {
        this.func_175473_a(2, lllllllllllllllIIllIIIlIlIlIllll);
    }
    
    class GuardianMoveHelper extends EntityMoveHelper
    {
        @Override
        public void onUpdateMoveHelper() {
            if (this.update && !EntityGuardian.this.getNavigator().noPath()) {
                final double llllllllllllllIllIIllIIIlllIlIIl = this.posX - EntityGuardian.this.posX;
                double llllllllllllllIllIIllIIIlllIlIII = this.posY - EntityGuardian.this.posY;
                final double llllllllllllllIllIIllIIIlllIIlll = this.posZ - EntityGuardian.this.posZ;
                double llllllllllllllIllIIllIIIlllIIllI = llllllllllllllIllIIllIIIlllIlIIl * llllllllllllllIllIIllIIIlllIlIIl + llllllllllllllIllIIllIIIlllIlIII * llllllllllllllIllIIllIIIlllIlIII + llllllllllllllIllIIllIIIlllIIlll * llllllllllllllIllIIllIIIlllIIlll;
                llllllllllllllIllIIllIIIlllIIllI = MathHelper.sqrt_double(llllllllllllllIllIIllIIIlllIIllI);
                llllllllllllllIllIIllIIIlllIlIII /= llllllllllllllIllIIllIIIlllIIllI;
                final float llllllllllllllIllIIllIIIlllIIlIl = (float)(Math.atan2(llllllllllllllIllIIllIIIlllIIlll, llllllllllllllIllIIllIIIlllIlIIl) * 180.0 / 3.141592653589793) - 90.0f;
                EntityGuardian.this.rotationYaw = this.limitAngle(EntityGuardian.this.rotationYaw, llllllllllllllIllIIllIIIlllIIlIl, 30.0f);
                EntityGuardian.this.renderYawOffset = EntityGuardian.this.rotationYaw;
                final float llllllllllllllIllIIllIIIlllIIlII = (float)(this.speed * EntityGuardian.this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue());
                EntityGuardian.this.setAIMoveSpeed(EntityGuardian.this.getAIMoveSpeed() + (llllllllllllllIllIIllIIIlllIIlII - EntityGuardian.this.getAIMoveSpeed()) * 0.125f);
                double llllllllllllllIllIIllIIIlllIIIll = Math.sin((EntityGuardian.this.ticksExisted + EntityGuardian.this.getEntityId()) * 0.5) * 0.05;
                final double llllllllllllllIllIIllIIIlllIIIlI = Math.cos(EntityGuardian.this.rotationYaw * 3.1415927f / 180.0f);
                final double llllllllllllllIllIIllIIIlllIIIIl = Math.sin(EntityGuardian.this.rotationYaw * 3.1415927f / 180.0f);
                final EntityGuardian field_179930_g = EntityGuardian.this;
                field_179930_g.motionX += llllllllllllllIllIIllIIIlllIIIll * llllllllllllllIllIIllIIIlllIIIlI;
                final EntityGuardian field_179930_g2 = EntityGuardian.this;
                field_179930_g2.motionZ += llllllllllllllIllIIllIIIlllIIIll * llllllllllllllIllIIllIIIlllIIIIl;
                llllllllllllllIllIIllIIIlllIIIll = Math.sin((EntityGuardian.this.ticksExisted + EntityGuardian.this.getEntityId()) * 0.75) * 0.05;
                final EntityGuardian field_179930_g3 = EntityGuardian.this;
                field_179930_g3.motionY += llllllllllllllIllIIllIIIlllIIIll * (llllllllllllllIllIIllIIIlllIIIIl + llllllllllllllIllIIllIIIlllIIIlI) * 0.25;
                final EntityGuardian field_179930_g4 = EntityGuardian.this;
                field_179930_g4.motionY += EntityGuardian.this.getAIMoveSpeed() * llllllllllllllIllIIllIIIlllIlIII * 0.1;
                final EntityLookHelper llllllllllllllIllIIllIIIlllIIIII = EntityGuardian.this.getLookHelper();
                final double llllllllllllllIllIIllIIIllIlllll = EntityGuardian.this.posX + llllllllllllllIllIIllIIIlllIlIIl / llllllllllllllIllIIllIIIlllIIllI * 2.0;
                final double llllllllllllllIllIIllIIIllIllllI = EntityGuardian.this.getEyeHeight() + EntityGuardian.this.posY + llllllllllllllIllIIllIIIlllIlIII / llllllllllllllIllIIllIIIlllIIllI * 1.0;
                final double llllllllllllllIllIIllIIIllIlllIl = EntityGuardian.this.posZ + llllllllllllllIllIIllIIIlllIIlll / llllllllllllllIllIIllIIIlllIIllI * 2.0;
                double llllllllllllllIllIIllIIIllIlllII = llllllllllllllIllIIllIIIlllIIIII.func_180423_e();
                double llllllllllllllIllIIllIIIllIllIll = llllllllllllllIllIIllIIIlllIIIII.func_180422_f();
                double llllllllllllllIllIIllIIIllIllIlI = llllllllllllllIllIIllIIIlllIIIII.func_180421_g();
                if (!llllllllllllllIllIIllIIIlllIIIII.func_180424_b()) {
                    llllllllllllllIllIIllIIIllIlllII = llllllllllllllIllIIllIIIllIlllll;
                    llllllllllllllIllIIllIIIllIllIll = llllllllllllllIllIIllIIIllIllllI;
                    llllllllllllllIllIIllIIIllIllIlI = llllllllllllllIllIIllIIIllIlllIl;
                }
                EntityGuardian.this.getLookHelper().setLookPosition(llllllllllllllIllIIllIIIllIlllII + (llllllllllllllIllIIllIIIllIlllll - llllllllllllllIllIIllIIIllIlllII) * 0.125, llllllllllllllIllIIllIIIllIllIll + (llllllllllllllIllIIllIIIllIllllI - llllllllllllllIllIIllIIIllIllIll) * 0.125, llllllllllllllIllIIllIIIllIllIlI + (llllllllllllllIllIIllIIIllIlllIl - llllllllllllllIllIIllIIIllIllIlI) * 0.125, 10.0f, 40.0f);
                EntityGuardian.this.func_175476_l(true);
            }
            else {
                EntityGuardian.this.setAIMoveSpeed(0.0f);
                EntityGuardian.this.func_175476_l(false);
            }
        }
        
        static {
            __OBFID = "CL_00002209";
        }
        
        public GuardianMoveHelper() {
            super(EntityGuardian.this);
        }
    }
    
    class GuardianTargetSelector implements Predicate
    {
        public boolean apply(final Object lllllllllllllllIlllIlIlIlllIllIl) {
            return this.func_179915_a((EntityLivingBase)lllllllllllllllIlllIlIlIlllIllIl);
        }
        
        public boolean func_179915_a(final EntityLivingBase lllllllllllllllIlllIlIlIllllIlIl) {
            return (lllllllllllllllIlllIlIlIllllIlIl instanceof EntityPlayer || lllllllllllllllIlllIlIlIllllIlIl instanceof EntitySquid) && lllllllllllllllIlllIlIlIllllIlIl.getDistanceSqToEntity(EntityGuardian.this) > 9.0;
        }
        
        static {
            __OBFID = "CL_00002210";
        }
    }
    
    class AIGuardianAttack extends EntityAIBase
    {
        private /* synthetic */ int field_179455_b;
        
        @Override
        public boolean continueExecuting() {
            return super.continueExecuting() && (EntityGuardian.this.func_175461_cl() || EntityGuardian.this.getDistanceSqToEntity(EntityGuardian.this.getAttackTarget()) > 9.0);
        }
        
        @Override
        public void startExecuting() {
            this.field_179455_b = -10;
            EntityGuardian.this.getNavigator().clearPathEntity();
            EntityGuardian.this.getLookHelper().setLookPositionWithEntity(EntityGuardian.this.getAttackTarget(), 90.0f, 90.0f);
            EntityGuardian.this.isAirBorne = true;
        }
        
        public AIGuardianAttack() {
            this.setMutexBits(3);
        }
        
        @Override
        public void resetTask() {
            EntityGuardian.this.func_175463_b(0);
            EntityGuardian.this.setAttackTarget(null);
            EntityGuardian.this.field_175481_bq.func_179480_f();
        }
        
        static {
            __OBFID = "CL_00002211";
        }
        
        @Override
        public boolean shouldExecute() {
            final EntityLivingBase llllllllllllllllIlIIllllIIllllIl = EntityGuardian.this.getAttackTarget();
            return llllllllllllllllIlIIllllIIllllIl != null && llllllllllllllllIlIIllllIIllllIl.isEntityAlive();
        }
        
        @Override
        public void updateTask() {
            final EntityLivingBase llllllllllllllllIlIIllllIIlIllIl = EntityGuardian.this.getAttackTarget();
            EntityGuardian.this.getNavigator().clearPathEntity();
            EntityGuardian.this.getLookHelper().setLookPositionWithEntity(llllllllllllllllIlIIllllIIlIllIl, 90.0f, 90.0f);
            if (!EntityGuardian.this.canEntityBeSeen(llllllllllllllllIlIIllllIIlIllIl)) {
                EntityGuardian.this.setAttackTarget(null);
            }
            else {
                ++this.field_179455_b;
                if (this.field_179455_b == 0) {
                    EntityGuardian.this.func_175463_b(EntityGuardian.this.getAttackTarget().getEntityId());
                    EntityGuardian.this.worldObj.setEntityState(EntityGuardian.this, (byte)21);
                }
                else if (this.field_179455_b >= EntityGuardian.this.func_175464_ck()) {
                    float llllllllllllllllIlIIllllIIlIllII = 1.0f;
                    if (EntityGuardian.this.worldObj.getDifficulty() == EnumDifficulty.HARD) {
                        llllllllllllllllIlIIllllIIlIllII += 2.0f;
                    }
                    if (EntityGuardian.this.func_175461_cl()) {
                        llllllllllllllllIlIIllllIIlIllII += 2.0f;
                    }
                    llllllllllllllllIlIIllllIIlIllIl.attackEntityFrom(DamageSource.causeIndirectMagicDamage(EntityGuardian.this, EntityGuardian.this), llllllllllllllllIlIIllllIIlIllII);
                    llllllllllllllllIlIIllllIIlIllIl.attackEntityFrom(DamageSource.causeMobDamage(EntityGuardian.this), (float)EntityGuardian.this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue());
                    EntityGuardian.this.setAttackTarget(null);
                }
                else if (this.field_179455_b < 60 || this.field_179455_b % 20 == 0) {}
                super.updateTask();
            }
        }
    }
}
