package net.minecraft.entity.boss;

import net.minecraft.entity.monster.*;
import net.minecraft.pathfinding.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.ai.*;
import net.minecraft.world.*;
import net.minecraft.command.*;
import com.google.common.base.*;
import net.minecraft.block.material.*;
import net.minecraft.block.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.init.*;
import net.minecraft.stats.*;
import net.minecraft.entity.item.*;
import java.util.*;
import net.minecraft.potion.*;

public class EntityWither extends EntityMob implements IBossDisplayData, IRangedAttackMob
{
    private /* synthetic */ int[] field_82223_h;
    private /* synthetic */ int[] field_82224_i;
    private /* synthetic */ float[] field_82221_e;
    private /* synthetic */ int field_82222_j;
    private /* synthetic */ float[] field_82217_f;
    private static final /* synthetic */ Predicate attackEntitySelector;
    private /* synthetic */ float[] field_82218_g;
    private /* synthetic */ float[] field_82220_d;
    
    @Override
    protected String getLivingSound() {
        return "mob.wither.idle";
    }
    
    public float func_82210_r(final int llllllllllllllIIIlIlIllIlIllIIll) {
        return this.field_82220_d[llllllllllllllIIIlIlIllIlIllIIll];
    }
    
    @Override
    protected String getDeathSound() {
        return "mob.wither.death";
    }
    
    public EntityWither(final World llllllllllllllIIIlIlIlllllIIlIll) {
        super(llllllllllllllIIIlIlIlllllIIlIll);
        this.field_82220_d = new float[2];
        this.field_82221_e = new float[2];
        this.field_82217_f = new float[2];
        this.field_82218_g = new float[2];
        this.field_82223_h = new int[2];
        this.field_82224_i = new int[2];
        this.setHealth(this.getMaxHealth());
        this.setSize(0.9f, 3.5f);
        this.isImmuneToFire = true;
        ((PathNavigateGround)this.getNavigator()).func_179693_d(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIArrowAttack(this, 1.0, 40, 20.0f));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityLiving.class, 0, false, false, EntityWither.attackEntitySelector));
        this.experienceValue = 50;
    }
    
    public float func_82207_a(final int llllllllllllllIIIlIlIllIlIllllll) {
        return this.field_82221_e[llllllllllllllIIIlIlIllIlIllllll];
    }
    
    @Override
    protected void updateAITasks() {
        if (this.getInvulTime() > 0) {
            final int llllllllllllllIIIlIlIlllIllllIII = this.getInvulTime() - 1;
            if (llllllllllllllIIIlIlIlllIllllIII <= 0) {
                this.worldObj.newExplosion(this, this.posX, this.posY + this.getEyeHeight(), this.posZ, 7.0f, false, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
                this.worldObj.func_175669_a(1013, new BlockPos(this), 0);
            }
            this.setInvulTime(llllllllllllllIIIlIlIlllIllllIII);
            if (this.ticksExisted % 10 == 0) {
                this.heal(10.0f);
            }
        }
        else {
            super.updateAITasks();
            for (int llllllllllllllIIIlIlIlllIlllIlll = 1; llllllllllllllIIIlIlIlllIlllIlll < 3; ++llllllllllllllIIIlIlIlllIlllIlll) {
                if (this.ticksExisted >= this.field_82223_h[llllllllllllllIIIlIlIlllIlllIlll - 1]) {
                    this.field_82223_h[llllllllllllllIIIlIlIlllIlllIlll - 1] = this.ticksExisted + 10 + this.rand.nextInt(10);
                    if (this.worldObj.getDifficulty() == EnumDifficulty.NORMAL || this.worldObj.getDifficulty() == EnumDifficulty.HARD) {
                        final int llllllllllllllIIIlIlIlllIlllIlII = llllllllllllllIIIlIlIlllIlllIlll - 1;
                        final int llllllllllllllIIIlIlIlllIlllIIll = this.field_82224_i[llllllllllllllIIIlIlIlllIlllIlll - 1];
                        this.field_82224_i[llllllllllllllIIIlIlIlllIlllIlII] = this.field_82224_i[llllllllllllllIIIlIlIlllIlllIlll - 1] + 1;
                        if (llllllllllllllIIIlIlIlllIlllIIll > 15) {
                            final float llllllllllllllIIIlIlIlllIlllIIlI = 10.0f;
                            final float llllllllllllllIIIlIlIlllIlllIIIl = 5.0f;
                            final double llllllllllllllIIIlIlIlllIlllIIII = MathHelper.getRandomDoubleInRange(this.rand, this.posX - llllllllllllllIIIlIlIlllIlllIIlI, this.posX + llllllllllllllIIIlIlIlllIlllIIlI);
                            final double llllllllllllllIIIlIlIlllIllIllll = MathHelper.getRandomDoubleInRange(this.rand, this.posY - llllllllllllllIIIlIlIlllIlllIIIl, this.posY + llllllllllllllIIIlIlIlllIlllIIIl);
                            final double llllllllllllllIIIlIlIlllIllIlllI = MathHelper.getRandomDoubleInRange(this.rand, this.posZ - llllllllllllllIIIlIlIlllIlllIIlI, this.posZ + llllllllllllllIIIlIlIlllIlllIIlI);
                            this.launchWitherSkullToCoords(llllllllllllllIIIlIlIlllIlllIlll + 1, llllllllllllllIIIlIlIlllIlllIIII, llllllllllllllIIIlIlIlllIllIllll, llllllllllllllIIIlIlIlllIllIlllI, true);
                            this.field_82224_i[llllllllllllllIIIlIlIlllIlllIlll - 1] = 0;
                        }
                    }
                    final int llllllllllllllIIIlIlIlllIlllIllI = this.getWatchedTargetId(llllllllllllllIIIlIlIlllIlllIlll);
                    if (llllllllllllllIIIlIlIlllIlllIllI > 0) {
                        final Entity llllllllllllllIIIlIlIlllIllIllIl = this.worldObj.getEntityByID(llllllllllllllIIIlIlIlllIlllIllI);
                        if (llllllllllllllIIIlIlIlllIllIllIl != null && llllllllllllllIIIlIlIlllIllIllIl.isEntityAlive() && this.getDistanceSqToEntity(llllllllllllllIIIlIlIlllIllIllIl) <= 900.0 && this.canEntityBeSeen(llllllllllllllIIIlIlIlllIllIllIl)) {
                            this.launchWitherSkullToEntity(llllllllllllllIIIlIlIlllIlllIlll + 1, (EntityLivingBase)llllllllllllllIIIlIlIlllIllIllIl);
                            this.field_82223_h[llllllllllllllIIIlIlIlllIlllIlll - 1] = this.ticksExisted + 40 + this.rand.nextInt(20);
                            this.field_82224_i[llllllllllllllIIIlIlIlllIlllIlll - 1] = 0;
                        }
                        else {
                            this.func_82211_c(llllllllllllllIIIlIlIlllIlllIlll, 0);
                        }
                    }
                    else {
                        final List llllllllllllllIIIlIlIlllIllIllII = this.worldObj.func_175647_a(EntityLivingBase.class, this.getEntityBoundingBox().expand(20.0, 8.0, 20.0), Predicates.and(EntityWither.attackEntitySelector, IEntitySelector.field_180132_d));
                        int llllllllllllllIIIlIlIlllIllIlIll = 0;
                        while (llllllllllllllIIIlIlIlllIllIlIll < 10 && !llllllllllllllIIIlIlIlllIllIllII.isEmpty()) {
                            final EntityLivingBase llllllllllllllIIIlIlIlllIllIlIlI = llllllllllllllIIIlIlIlllIllIllII.get(this.rand.nextInt(llllllllllllllIIIlIlIlllIllIllII.size()));
                            if (llllllllllllllIIIlIlIlllIllIlIlI != this && llllllllllllllIIIlIlIlllIllIlIlI.isEntityAlive() && this.canEntityBeSeen(llllllllllllllIIIlIlIlllIllIlIlI)) {
                                if (!(llllllllllllllIIIlIlIlllIllIlIlI instanceof EntityPlayer)) {
                                    this.func_82211_c(llllllllllllllIIIlIlIlllIlllIlll, llllllllllllllIIIlIlIlllIllIlIlI.getEntityId());
                                    break;
                                }
                                if (!((EntityPlayer)llllllllllllllIIIlIlIlllIllIlIlI).capabilities.disableDamage) {
                                    this.func_82211_c(llllllllllllllIIIlIlIlllIlllIlll, llllllllllllllIIIlIlIlllIllIlIlI.getEntityId());
                                    break;
                                }
                                break;
                            }
                            else {
                                llllllllllllllIIIlIlIlllIllIllII.remove(llllllllllllllIIIlIlIlllIllIlIlI);
                                ++llllllllllllllIIIlIlIlllIllIlIll;
                            }
                        }
                    }
                }
            }
            if (this.getAttackTarget() != null) {
                this.func_82211_c(0, this.getAttackTarget().getEntityId());
            }
            else {
                this.func_82211_c(0, 0);
            }
            if (this.field_82222_j > 0) {
                --this.field_82222_j;
                if (this.field_82222_j == 0 && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
                    final int llllllllllllllIIIlIlIlllIlllIlll = MathHelper.floor_double(this.posY);
                    final int llllllllllllllIIIlIlIlllIlllIlIl = MathHelper.floor_double(this.posX);
                    final int llllllllllllllIIIlIlIlllIllIlIIl = MathHelper.floor_double(this.posZ);
                    boolean llllllllllllllIIIlIlIlllIllIlIII = false;
                    for (int llllllllllllllIIIlIlIlllIllIIlll = -1; llllllllllllllIIIlIlIlllIllIIlll <= 1; ++llllllllllllllIIIlIlIlllIllIIlll) {
                        for (int llllllllllllllIIIlIlIlllIllIIllI = -1; llllllllllllllIIIlIlIlllIllIIllI <= 1; ++llllllllllllllIIIlIlIlllIllIIllI) {
                            for (int llllllllllllllIIIlIlIlllIllIIlIl = 0; llllllllllllllIIIlIlIlllIllIIlIl <= 3; ++llllllllllllllIIIlIlIlllIllIIlIl) {
                                final int llllllllllllllIIIlIlIlllIllIIlII = llllllllllllllIIIlIlIlllIlllIlIl + llllllllllllllIIIlIlIlllIllIIlll;
                                final int llllllllllllllIIIlIlIlllIllIIIll = llllllllllllllIIIlIlIlllIlllIlll + llllllllllllllIIIlIlIlllIllIIlIl;
                                final int llllllllllllllIIIlIlIlllIllIIIlI = llllllllllllllIIIlIlIlllIllIlIIl + llllllllllllllIIIlIlIlllIllIIllI;
                                final Block llllllllllllllIIIlIlIlllIllIIIIl = this.worldObj.getBlockState(new BlockPos(llllllllllllllIIIlIlIlllIllIIlII, llllllllllllllIIIlIlIlllIllIIIll, llllllllllllllIIIlIlIlllIllIIIlI)).getBlock();
                                if (llllllllllllllIIIlIlIlllIllIIIIl.getMaterial() != Material.air && llllllllllllllIIIlIlIlllIllIIIIl != Blocks.bedrock && llllllllllllllIIIlIlIlllIllIIIIl != Blocks.end_portal && llllllllllllllIIIlIlIlllIllIIIIl != Blocks.end_portal_frame && llllllllllllllIIIlIlIlllIllIIIIl != Blocks.command_block && llllllllllllllIIIlIlIlllIllIIIIl != Blocks.barrier) {
                                    llllllllllllllIIIlIlIlllIllIlIII = (this.worldObj.destroyBlock(new BlockPos(llllllllllllllIIIlIlIlllIllIIlII, llllllllllllllIIIlIlIlllIllIIIll, llllllllllllllIIIlIlIlllIllIIIlI), true) || llllllllllllllIIIlIlIlllIllIlIII);
                                }
                            }
                        }
                    }
                    if (llllllllllllllIIIlIlIlllIllIlIII) {
                        this.worldObj.playAuxSFXAtEntity(null, 1012, new BlockPos(this), 0);
                    }
                }
            }
            if (this.ticksExisted % 20 == 0) {
                this.heal(1.0f);
            }
        }
    }
    
    @Override
    public void setInWeb() {
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound llllllllllllllIIIlIlIllllIllllII) {
        super.readEntityFromNBT(llllllllllllllIIIlIlIllllIllllII);
        this.setInvulTime(llllllllllllllIIIlIlIllllIllllII.getInteger("Invul"));
    }
    
    @Override
    public int getBrightnessForRender(final float llllllllllllllIIIlIlIllIllIIlIll) {
        return 15728880;
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource llllllllllllllIIIlIlIllIlllIIlll, final float llllllllllllllIIIlIlIllIlllIIllI) {
        if (this.func_180431_b(llllllllllllllIIIlIlIllIlllIIlll)) {
            return false;
        }
        if (llllllllllllllIIIlIlIllIlllIIlll == DamageSource.drown || llllllllllllllIIIlIlIllIlllIIlll.getEntity() instanceof EntityWither) {
            return false;
        }
        if (this.getInvulTime() > 0 && llllllllllllllIIIlIlIllIlllIIlll != DamageSource.outOfWorld) {
            return false;
        }
        if (this.isArmored()) {
            final Entity llllllllllllllIIIlIlIllIlllIIlIl = llllllllllllllIIIlIlIllIlllIIlll.getSourceOfDamage();
            if (llllllllllllllIIIlIlIllIlllIIlIl instanceof EntityArrow) {
                return false;
            }
        }
        final Entity llllllllllllllIIIlIlIllIlllIIlII = llllllllllllllIIIlIlIllIlllIIlll.getEntity();
        if (llllllllllllllIIIlIlIllIlllIIlII != null && !(llllllllllllllIIIlIlIllIlllIIlII instanceof EntityPlayer) && llllllllllllllIIIlIlIllIlllIIlII instanceof EntityLivingBase && ((EntityLivingBase)llllllllllllllIIIlIlIllIlllIIlII).getCreatureAttribute() == this.getCreatureAttribute()) {
            return false;
        }
        if (this.field_82222_j <= 0) {
            this.field_82222_j = 20;
        }
        for (int llllllllllllllIIIlIlIllIlllIIIll = 0; llllllllllllllIIIlIlIllIlllIIIll < this.field_82224_i.length; ++llllllllllllllIIIlIlIllIlllIIIll) {
            final int[] field_82224_i = this.field_82224_i;
            final int n = llllllllllllllIIIlIlIllIlllIIIll;
            field_82224_i[n] += 3;
        }
        return super.attackEntityFrom(llllllllllllllIIIlIlIllIlllIIlll, llllllllllllllIIIlIlIllIlllIIllI);
    }
    
    static {
        __OBFID = "CL_00001661";
        attackEntitySelector = (Predicate)new Predicate() {
            public boolean func_180027_a(final Entity lllllllllllllllllIlllllllllIlIII) {
                return lllllllllllllllllIlllllllllIlIII instanceof EntityLivingBase && ((EntityLivingBase)lllllllllllllllllIlllllllllIlIII).getCreatureAttribute() != EnumCreatureAttribute.UNDEAD;
            }
            
            static {
                __OBFID = "CL_00001662";
            }
            
            public boolean apply(final Object lllllllllllllllllIlllllllllIIIll) {
                return this.func_180027_a((Entity)lllllllllllllllllIlllllllllIIIll);
            }
        };
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(17, new Integer(0));
        this.dataWatcher.addObject(18, new Integer(0));
        this.dataWatcher.addObject(19, new Integer(0));
        this.dataWatcher.addObject(20, new Integer(0));
    }
    
    @Override
    public void onLivingUpdate() {
        this.motionY *= 0.6000000238418579;
        if (!this.worldObj.isRemote && this.getWatchedTargetId(0) > 0) {
            final Entity llllllllllllllIIIlIlIllllIlIIIlI = this.worldObj.getEntityByID(this.getWatchedTargetId(0));
            if (llllllllllllllIIIlIlIllllIlIIIlI != null) {
                if (this.posY < llllllllllllllIIIlIlIllllIlIIIlI.posY || (!this.isArmored() && this.posY < llllllllllllllIIIlIlIllllIlIIIlI.posY + 5.0)) {
                    if (this.motionY < 0.0) {
                        this.motionY = 0.0;
                    }
                    this.motionY += (0.5 - this.motionY) * 0.6000000238418579;
                }
                final double llllllllllllllIIIlIlIllllIlIIIIl = llllllllllllllIIIlIlIllllIlIIIlI.posX - this.posX;
                final double llllllllllllllIIIlIlIllllIlIlIII = llllllllllllllIIIlIlIllllIlIIIlI.posZ - this.posZ;
                final double llllllllllllllIIIlIlIllllIlIIllI = llllllllllllllIIIlIlIllllIlIIIIl * llllllllllllllIIIlIlIllllIlIIIIl + llllllllllllllIIIlIlIllllIlIlIII * llllllllllllllIIIlIlIllllIlIlIII;
                if (llllllllllllllIIIlIlIllllIlIIllI > 9.0) {
                    final double llllllllllllllIIIlIlIllllIlIIlII = MathHelper.sqrt_double(llllllllllllllIIIlIlIllllIlIIllI);
                    this.motionX += (llllllllllllllIIIlIlIllllIlIIIIl / llllllllllllllIIIlIlIllllIlIIlII * 0.5 - this.motionX) * 0.6000000238418579;
                    this.motionZ += (llllllllllllllIIIlIlIllllIlIlIII / llllllllllllllIIIlIlIllllIlIIlII * 0.5 - this.motionZ) * 0.6000000238418579;
                }
            }
        }
        if (this.motionX * this.motionX + this.motionZ * this.motionZ > 0.05000000074505806) {
            this.rotationYaw = (float)Math.atan2(this.motionZ, this.motionX) * 57.295776f - 90.0f;
        }
        super.onLivingUpdate();
        for (int llllllllllllllIIIlIlIllllIlIIIII = 0; llllllllllllllIIIlIlIllllIlIIIII < 2; ++llllllllllllllIIIlIlIllllIlIIIII) {
            this.field_82218_g[llllllllllllllIIIlIlIllllIlIIIII] = this.field_82221_e[llllllllllllllIIIlIlIllllIlIIIII];
            this.field_82217_f[llllllllllllllIIIlIlIllllIlIIIII] = this.field_82220_d[llllllllllllllIIIlIlIllllIlIIIII];
        }
        for (int llllllllllllllIIIlIlIllllIlIIIII = 0; llllllllllllllIIIlIlIllllIlIIIII < 2; ++llllllllllllllIIIlIlIllllIlIIIII) {
            final int llllllllllllllIIIlIlIllllIIlllll = this.getWatchedTargetId(llllllllllllllIIIlIlIllllIlIIIII + 1);
            Entity llllllllllllllIIIlIlIllllIIlllIl = null;
            if (llllllllllllllIIIlIlIllllIIlllll > 0) {
                llllllllllllllIIIlIlIllllIIlllIl = this.worldObj.getEntityByID(llllllllllllllIIIlIlIllllIIlllll);
            }
            if (llllllllllllllIIIlIlIllllIIlllIl != null) {
                final double llllllllllllllIIIlIlIllllIlIIlll = this.func_82214_u(llllllllllllllIIIlIlIllllIlIIIII + 1);
                final double llllllllllllllIIIlIlIllllIlIIlIl = this.func_82208_v(llllllllllllllIIIlIlIllllIlIIIII + 1);
                final double llllllllllllllIIIlIlIllllIlIIIll = this.func_82213_w(llllllllllllllIIIlIlIllllIlIIIII + 1);
                final double llllllllllllllIIIlIlIllllIIlllII = llllllllllllllIIIlIlIllllIIlllIl.posX - llllllllllllllIIIlIlIllllIlIIlll;
                final double llllllllllllllIIIlIlIllllIIllIll = llllllllllllllIIIlIlIllllIIlllIl.posY + llllllllllllllIIIlIlIllllIIlllIl.getEyeHeight() - llllllllllllllIIIlIlIllllIlIIlIl;
                final double llllllllllllllIIIlIlIllllIIllIlI = llllllllllllllIIIlIlIllllIIlllIl.posZ - llllllllllllllIIIlIlIllllIlIIIll;
                final double llllllllllllllIIIlIlIllllIIllIIl = MathHelper.sqrt_double(llllllllllllllIIIlIlIllllIIlllII * llllllllllllllIIIlIlIllllIIlllII + llllllllllllllIIIlIlIllllIIllIlI * llllllllllllllIIIlIlIllllIIllIlI);
                final float llllllllllllllIIIlIlIllllIIllIII = (float)(Math.atan2(llllllllllllllIIIlIlIllllIIllIlI, llllllllllllllIIIlIlIllllIIlllII) * 180.0 / 3.141592653589793) - 90.0f;
                final float llllllllllllllIIIlIlIllllIIlIlll = (float)(-(Math.atan2(llllllllllllllIIIlIlIllllIIllIll, llllllllllllllIIIlIlIllllIIllIIl) * 180.0 / 3.141592653589793));
                this.field_82220_d[llllllllllllllIIIlIlIllllIlIIIII] = this.func_82204_b(this.field_82220_d[llllllllllllllIIIlIlIllllIlIIIII], llllllllllllllIIIlIlIllllIIlIlll, 40.0f);
                this.field_82221_e[llllllllllllllIIIlIlIllllIlIIIII] = this.func_82204_b(this.field_82221_e[llllllllllllllIIIlIlIllllIlIIIII], llllllllllllllIIIlIlIllllIIllIII, 10.0f);
            }
            else {
                this.field_82221_e[llllllllllllllIIIlIlIllllIlIIIII] = this.func_82204_b(this.field_82221_e[llllllllllllllIIIlIlIllllIlIIIII], this.renderYawOffset, 10.0f);
            }
        }
        final boolean llllllllllllllIIIlIlIllllIIlIllI = this.isArmored();
        for (int llllllllllllllIIIlIlIllllIIllllI = 0; llllllllllllllIIIlIlIllllIIllllI < 3; ++llllllllllllllIIIlIlIllllIIllllI) {
            final double llllllllllllllIIIlIlIllllIIlIlIl = this.func_82214_u(llllllllllllllIIIlIlIllllIIllllI);
            final double llllllllllllllIIIlIlIllllIIlIlII = this.func_82208_v(llllllllllllllIIIlIlIllllIIllllI);
            final double llllllllllllllIIIlIlIllllIIlIIll = this.func_82213_w(llllllllllllllIIIlIlIllllIIllllI);
            this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, llllllllllllllIIIlIlIllllIIlIlIl + this.rand.nextGaussian() * 0.30000001192092896, llllllllllllllIIIlIlIllllIIlIlII + this.rand.nextGaussian() * 0.30000001192092896, llllllllllllllIIIlIlIllllIIlIIll + this.rand.nextGaussian() * 0.30000001192092896, 0.0, 0.0, 0.0, new int[0]);
            if (llllllllllllllIIIlIlIllllIIlIllI && this.worldObj.rand.nextInt(4) == 0) {
                this.worldObj.spawnParticle(EnumParticleTypes.SPELL_MOB, llllllllllllllIIIlIlIllllIIlIlIl + this.rand.nextGaussian() * 0.30000001192092896, llllllllllllllIIIlIlIllllIIlIlII + this.rand.nextGaussian() * 0.30000001192092896, llllllllllllllIIIlIlIllllIIlIIll + this.rand.nextGaussian() * 0.30000001192092896, 0.699999988079071, 0.699999988079071, 0.5, new int[0]);
            }
        }
        if (this.getInvulTime() > 0) {
            for (int llllllllllllllIIIlIlIllllIIllllI = 0; llllllllllllllIIIlIlIllllIIllllI < 3; ++llllllllllllllIIIlIlIllllIIllllI) {
                this.worldObj.spawnParticle(EnumParticleTypes.SPELL_MOB, this.posX + this.rand.nextGaussian() * 1.0, this.posY + this.rand.nextFloat() * 3.3f, this.posZ + this.rand.nextGaussian() * 1.0, 0.699999988079071, 0.699999988079071, 0.8999999761581421, new int[0]);
            }
        }
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(300.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.6000000238418579);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0);
    }
    
    private double func_82213_w(final int llllllllllllllIIIlIlIlllIIllIlII) {
        if (llllllllllllllIIIlIlIlllIIllIlII <= 0) {
            return this.posZ;
        }
        final float llllllllllllllIIIlIlIlllIIllIlll = (this.renderYawOffset + 180 * (llllllllllllllIIIlIlIlllIIllIlII - 1)) / 180.0f * 3.1415927f;
        final float llllllllllllllIIIlIlIlllIIllIllI = MathHelper.sin(llllllllllllllIIIlIlIlllIIllIlll);
        return this.posZ + llllllllllllllIIIlIlIlllIIllIllI * 1.3;
    }
    
    public void setInvulTime(final int llllllllllllllIIIlIlIllIlIlIIllI) {
        this.dataWatcher.updateObject(20, llllllllllllllIIIlIlIllIlIlIIllI);
    }
    
    public void func_82211_c(final int llllllllllllllIIIlIlIllIlIIIlIll, final int llllllllllllllIIIlIlIllIlIIIIlIl) {
        this.dataWatcher.updateObject(17 + llllllllllllllIIIlIlIllIlIIIlIll, llllllllllllllIIIlIlIllIlIIIIlIl);
    }
    
    private float func_82204_b(final float llllllllllllllIIIlIlIlllIIlIllII, final float llllllllllllllIIIlIlIlllIIlIlIll, final float llllllllllllllIIIlIlIlllIIlIIllI) {
        float llllllllllllllIIIlIlIlllIIlIlIIl = MathHelper.wrapAngleTo180_float(llllllllllllllIIIlIlIlllIIlIlIll - llllllllllllllIIIlIlIlllIIlIllII);
        if (llllllllllllllIIIlIlIlllIIlIlIIl > llllllllllllllIIIlIlIlllIIlIIllI) {
            llllllllllllllIIIlIlIlllIIlIlIIl = llllllllllllllIIIlIlIlllIIlIIllI;
        }
        if (llllllllllllllIIIlIlIlllIIlIlIIl < -llllllllllllllIIIlIlIlllIIlIIllI) {
            llllllllllllllIIIlIlIlllIIlIlIIl = -llllllllllllllIIIlIlIlllIIlIIllI;
        }
        return llllllllllllllIIIlIlIlllIIlIllII + llllllllllllllIIIlIlIlllIIlIlIIl;
    }
    
    public boolean isArmored() {
        return this.getHealth() <= this.getMaxHealth() / 2.0f;
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound llllllllllllllIIIlIlIlllllIIIIlI) {
        super.writeEntityToNBT(llllllllllllllIIIlIlIlllllIIIIlI);
        llllllllllllllIIIlIlIlllllIIIIlI.setInteger("Invul", this.getInvulTime());
    }
    
    private void launchWitherSkullToCoords(final int llllllllllllllIIIlIlIlllIIIIIIII, final double llllllllllllllIIIlIlIlllIIIIllII, final double llllllllllllllIIIlIlIllIlllllllI, final double llllllllllllllIIIlIlIllIllllllIl, final boolean llllllllllllllIIIlIlIllIllllllII) {
        this.worldObj.playAuxSFXAtEntity(null, 1014, new BlockPos(this), 0);
        final double llllllllllllllIIIlIlIlllIIIIlIII = this.func_82214_u(llllllllllllllIIIlIlIlllIIIIIIII);
        final double llllllllllllllIIIlIlIlllIIIIIlll = this.func_82208_v(llllllllllllllIIIlIlIlllIIIIIIII);
        final double llllllllllllllIIIlIlIlllIIIIIllI = this.func_82213_w(llllllllllllllIIIlIlIlllIIIIIIII);
        final double llllllllllllllIIIlIlIlllIIIIIlIl = llllllllllllllIIIlIlIlllIIIIllII - llllllllllllllIIIlIlIlllIIIIlIII;
        final double llllllllllllllIIIlIlIlllIIIIIlII = llllllllllllllIIIlIlIllIlllllllI - llllllllllllllIIIlIlIlllIIIIIlll;
        final double llllllllllllllIIIlIlIlllIIIIIIll = llllllllllllllIIIlIlIllIllllllIl - llllllllllllllIIIlIlIlllIIIIIllI;
        final EntityWitherSkull llllllllllllllIIIlIlIlllIIIIIIlI = new EntityWitherSkull(this.worldObj, this, llllllllllllllIIIlIlIlllIIIIIlIl, llllllllllllllIIIlIlIlllIIIIIlII, llllllllllllllIIIlIlIlllIIIIIIll);
        if (llllllllllllllIIIlIlIllIllllllII) {
            llllllllllllllIIIlIlIlllIIIIIIlI.setInvulnerable(true);
        }
        llllllllllllllIIIlIlIlllIIIIIIlI.posY = llllllllllllllIIIlIlIlllIIIIIlll;
        llllllllllllllIIIlIlIlllIIIIIIlI.posX = llllllllllllllIIIlIlIlllIIIIlIII;
        llllllllllllllIIIlIlIlllIIIIIIlI.posZ = llllllllllllllIIIlIlIlllIIIIIllI;
        this.worldObj.spawnEntityInWorld(llllllllllllllIIIlIlIlllIIIIIIlI);
    }
    
    @Override
    public void attackEntityWithRangedAttack(final EntityLivingBase llllllllllllllIIIlIlIllIllllIIIl, final float llllllllllllllIIIlIlIllIllllIIII) {
        this.launchWitherSkullToEntity(0, llllllllllllllIIIlIlIllIllllIIIl);
    }
    
    private double func_82208_v(final int llllllllllllllIIIlIlIlllIlIIIIII) {
        return (llllllllllllllIIIlIlIlllIlIIIIII <= 0) ? (this.posY + 3.0) : (this.posY + 2.2);
    }
    
    @Override
    protected void despawnEntity() {
        this.entityAge = 0;
    }
    
    @Override
    public int getTotalArmorValue() {
        return 4;
    }
    
    @Override
    protected void dropFewItems(final boolean llllllllllllllIIIlIlIllIllIllIII, final int llllllllllllllIIIlIlIllIllIlIlll) {
        final EntityItem llllllllllllllIIIlIlIllIllIlIllI = this.dropItem(Items.nether_star, 1);
        if (llllllllllllllIIIlIlIllIllIlIllI != null) {
            llllllllllllllIIIlIlIllIllIlIllI.func_174873_u();
        }
        if (!this.worldObj.isRemote) {
            for (final EntityPlayer llllllllllllllIIIlIlIllIllIlIlII : this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, this.getEntityBoundingBox().expand(50.0, 100.0, 50.0))) {
                llllllllllllllIIIlIlIllIllIlIlII.triggerAchievement(AchievementList.killWither);
            }
        }
    }
    
    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEAD;
    }
    
    public int getInvulTime() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }
    
    public void func_82206_m() {
        this.setInvulTime(220);
        this.setHealth(this.getMaxHealth() / 3.0f);
    }
    
    private void launchWitherSkullToEntity(final int llllllllllllllIIIlIlIlllIIlIIIII, final EntityLivingBase llllllllllllllIIIlIlIlllIIIlllII) {
        this.launchWitherSkullToCoords(llllllllllllllIIIlIlIlllIIlIIIII, llllllllllllllIIIlIlIlllIIIlllII.posX, llllllllllllllIIIlIlIlllIIIlllII.posY + llllllllllllllIIIlIlIlllIIIlllII.getEyeHeight() * 0.5, llllllllllllllIIIlIlIlllIIIlllII.posZ, llllllllllllllIIIlIlIlllIIlIIIII == 0 && this.rand.nextFloat() < 0.001f);
    }
    
    public int getWatchedTargetId(final int llllllllllllllIIIlIlIllIlIIlllII) {
        return this.dataWatcher.getWatchableObjectInt(17 + llllllllllllllIIIlIlIllIlIIlllII);
    }
    
    private double func_82214_u(final int llllllllllllllIIIlIlIlllIlIIIllI) {
        if (llllllllllllllIIIlIlIlllIlIIIllI <= 0) {
            return this.posX;
        }
        final float llllllllllllllIIIlIlIlllIlIIlIIl = (this.renderYawOffset + 180 * (llllllllllllllIIIlIlIlllIlIIIllI - 1)) / 180.0f * 3.1415927f;
        final float llllllllllllllIIIlIlIlllIlIIlIII = MathHelper.cos(llllllllllllllIIIlIlIlllIlIIlIIl);
        return this.posX + llllllllllllllIIIlIlIlllIlIIlIII * 1.3;
    }
    
    @Override
    public void fall(final float llllllllllllllIIIlIlIllIllIIlIIl, final float llllllllllllllIIIlIlIllIllIIlIII) {
    }
    
    @Override
    public void addPotionEffect(final PotionEffect llllllllllllllIIIlIlIllIllIIIllI) {
    }
    
    @Override
    protected String getHurtSound() {
        return "mob.wither.hurt";
    }
    
    @Override
    public void mountEntity(final Entity llllllllllllllIIIlIlIllIIlllIllI) {
        this.ridingEntity = null;
    }
}
