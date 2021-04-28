package net.minecraft.entity.monster;

import net.minecraft.village.*;
import net.minecraft.world.*;
import net.minecraft.pathfinding.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.block.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import com.google.common.base.*;

public class EntityIronGolem extends EntityGolem
{
    private /* synthetic */ int holdRoseTick;
    /* synthetic */ Village villageObj;
    private /* synthetic */ int attackTimer;
    private /* synthetic */ int homeCheckTimer;
    
    public EntityIronGolem(final World lllllllllllllllIIlIlIIIlIIIIIlIl) {
        super(lllllllllllllllIIlIlIIIlIIIIIlIl);
        this.setSize(1.4f, 2.9f);
        ((PathNavigateGround)this.getNavigator()).func_179690_a(true);
        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, 1.0, true));
        this.tasks.addTask(2, new EntityAIMoveTowardsTarget(this, 0.9, 32.0f));
        this.tasks.addTask(3, new EntityAIMoveThroughVillage(this, 0.6, true));
        this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0));
        this.tasks.addTask(5, new EntityAILookAtVillager(this));
        this.tasks.addTask(6, new EntityAIWander(this, 0.6));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0f));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIDefendVillage(this));
        this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false, new Class[0]));
        this.targetTasks.addTask(3, new AINearestAttackableTargetNonCreeper(this, EntityLiving.class, 10, false, true, IMob.field_175450_e));
    }
    
    @Override
    protected void dropFewItems(final boolean lllllllllllllllIIlIlIIIIlIIlIIII, final int lllllllllllllllIIlIlIIIIlIIIllll) {
        for (int lllllllllllllllIIlIlIIIIlIIIlllI = this.rand.nextInt(3), lllllllllllllllIIlIlIIIIlIIIllIl = 0; lllllllllllllllIIlIlIIIIlIIIllIl < lllllllllllllllIIlIlIIIIlIIIlllI; ++lllllllllllllllIIlIlIIIIlIIIllIl) {
            this.dropItemWithOffset(Item.getItemFromBlock(Blocks.red_flower), 1, (float)BlockFlower.EnumFlowerType.POPPY.func_176968_b());
        }
        for (int lllllllllllllllIIlIlIIIIlIIIllIl = 3 + this.rand.nextInt(3), lllllllllllllllIIlIlIIIIlIIIllII = 0; lllllllllllllllIIlIlIIIIlIIIllII < lllllllllllllllIIlIlIIIIlIIIllIl; ++lllllllllllllllIIlIlIIIIlIIIllII) {
            this.dropItem(Items.iron_ingot, 1);
        }
    }
    
    @Override
    public void onDeath(final DamageSource lllllllllllllllIIlIlIIIIIlllIIll) {
        if (!this.isPlayerCreated() && this.attackingPlayer != null && this.villageObj != null) {
            this.villageObj.setReputationForPlayer(this.attackingPlayer.getName(), -5);
        }
        super.onDeath(lllllllllllllllIIlIlIIIIIlllIIll);
    }
    
    @Override
    public boolean attackEntityAsMob(final Entity lllllllllllllllIIlIlIIIIllIIIIll) {
        this.attackTimer = 10;
        this.worldObj.setEntityState(this, (byte)4);
        final boolean lllllllllllllllIIlIlIIIIllIIIlIl = lllllllllllllllIIlIlIIIIllIIIIll.attackEntityFrom(DamageSource.causeMobDamage(this), (float)(7 + this.rand.nextInt(15)));
        if (lllllllllllllllIIlIlIIIIllIIIlIl) {
            lllllllllllllllIIlIlIIIIllIIIIll.motionY += 0.4000000059604645;
            this.func_174815_a(this, lllllllllllllllIIlIlIIIIllIIIIll);
        }
        this.playSound("mob.irongolem.throw", 1.0f, 1.0f);
        return lllllllllllllllIIlIlIIIIllIIIlIl;
    }
    
    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.attackTimer > 0) {
            --this.attackTimer;
        }
        if (this.holdRoseTick > 0) {
            --this.holdRoseTick;
        }
        if (this.motionX * this.motionX + this.motionZ * this.motionZ > 2.500000277905201E-7 && this.rand.nextInt(5) == 0) {
            final int lllllllllllllllIIlIlIIIIlllIIlll = MathHelper.floor_double(this.posX);
            final int lllllllllllllllIIlIlIIIIlllIIllI = MathHelper.floor_double(this.posY - 0.20000000298023224);
            final int lllllllllllllllIIlIlIIIIlllIIlIl = MathHelper.floor_double(this.posZ);
            final IBlockState lllllllllllllllIIlIlIIIIlllIIlII = this.worldObj.getBlockState(new BlockPos(lllllllllllllllIIlIlIIIIlllIIlll, lllllllllllllllIIlIlIIIIlllIIllI, lllllllllllllllIIlIlIIIIlllIIlIl));
            final Block lllllllllllllllIIlIlIIIIlllIIIll = lllllllllllllllIIlIlIIIIlllIIlII.getBlock();
            if (lllllllllllllllIIlIlIIIIlllIIIll.getMaterial() != Material.air) {
                this.worldObj.spawnParticle(EnumParticleTypes.BLOCK_CRACK, this.posX + (this.rand.nextFloat() - 0.5) * this.width, this.getEntityBoundingBox().minY + 0.1, this.posZ + (this.rand.nextFloat() - 0.5) * this.width, 4.0 * (this.rand.nextFloat() - 0.5), 0.5, (this.rand.nextFloat() - 0.5) * 4.0, Block.getStateId(lllllllllllllllIIlIlIIIIlllIIlII));
            }
        }
    }
    
    @Override
    protected int decreaseAirSupply(final int lllllllllllllllIIlIlIIIIllllIllI) {
        return lllllllllllllllIIlIlIIIIllllIllI;
    }
    
    @Override
    protected void updateAITasks() {
        final int homeCheckTimer = this.homeCheckTimer - 1;
        this.homeCheckTimer = homeCheckTimer;
        if (homeCheckTimer <= 0) {
            this.homeCheckTimer = 70 + this.rand.nextInt(50);
            this.villageObj = this.worldObj.getVillageCollection().func_176056_a(new BlockPos(this), 32);
            if (this.villageObj == null) {
                this.detachHome();
            }
            else {
                final BlockPos lllllllllllllllIIlIlIIIIlllllllI = this.villageObj.func_180608_a();
                this.func_175449_a(lllllllllllllllIIlIlIIIIlllllllI, (int)(this.villageObj.getVillageRadius() * 0.6f));
            }
        }
        super.updateAITasks();
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllllIIlIlIIIIllIlIIIl) {
        super.writeEntityToNBT(lllllllllllllllIIlIlIIIIllIlIIIl);
        lllllllllllllllIIlIlIIIIllIlIIIl.setBoolean("PlayerCreated", this.isPlayerCreated());
    }
    
    @Override
    protected void collideWithEntity(final Entity lllllllllllllllIIlIlIIIIlllIllll) {
        if (lllllllllllllllIIlIlIIIIlllIllll instanceof IMob && this.getRNG().nextInt(20) == 0) {
            this.setAttackTarget((EntityLivingBase)lllllllllllllllIIlIlIIIIlllIllll);
        }
        super.collideWithEntity(lllllllllllllllIIlIlIIIIlllIllll);
    }
    
    @Override
    protected String getDeathSound() {
        return "mob.irongolem.death";
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllllIIlIlIIIIllIIlIll) {
        super.readEntityFromNBT(lllllllllllllllIIlIlIIIIllIIlIll);
        this.setPlayerCreated(lllllllllllllllIIlIlIIIIllIIlIll.getBoolean("PlayerCreated"));
    }
    
    public void setHoldingRose(final boolean lllllllllllllllIIlIlIIIIlIlIlIIl) {
        this.holdRoseTick = (lllllllllllllllIIlIlIIIIlIlIlIIl ? 400 : 0);
        this.worldObj.setEntityState(this, (byte)11);
    }
    
    public int getAttackTimer() {
        return this.attackTimer;
    }
    
    public int getHoldRoseTick() {
        return this.holdRoseTick;
    }
    
    @Override
    public void handleHealthUpdate(final byte lllllllllllllllIIlIlIIIIlIlllllI) {
        if (lllllllllllllllIIlIlIIIIlIlllllI == 4) {
            this.attackTimer = 10;
            this.playSound("mob.irongolem.throw", 1.0f, 1.0f);
        }
        else if (lllllllllllllllIIlIlIIIIlIlllllI == 11) {
            this.holdRoseTick = 400;
        }
        else {
            super.handleHealthUpdate(lllllllllllllllIIlIlIIIIlIlllllI);
        }
    }
    
    public boolean isPlayerCreated() {
        return (this.dataWatcher.getWatchableObjectByte(16) & 0x1) != 0x0;
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, 0);
    }
    
    @Override
    public boolean canAttackClass(final Class lllllllllllllllIIlIlIIIIllIlIlll) {
        return (!this.isPlayerCreated() || !EntityPlayer.class.isAssignableFrom(lllllllllllllllIIlIlIIIIllIlIlll)) && super.canAttackClass(lllllllllllllllIIlIlIIIIllIlIlll);
    }
    
    @Override
    protected void func_180429_a(final BlockPos lllllllllllllllIIlIlIIIIlIIllIII, final Block lllllllllllllllIIlIlIIIIlIIlIlll) {
        this.playSound("mob.irongolem.walk", 1.0f, 1.0f);
    }
    
    @Override
    protected String getHurtSound() {
        return "mob.irongolem.hit";
    }
    
    public Village getVillage() {
        return this.villageObj;
    }
    
    public void setPlayerCreated(final boolean lllllllllllllllIIlIlIIIIIlllllIl) {
        final byte lllllllllllllllIIlIlIIIIIlllllII = this.dataWatcher.getWatchableObjectByte(16);
        if (lllllllllllllllIIlIlIIIIIlllllIl) {
            this.dataWatcher.updateObject(16, (byte)(lllllllllllllllIIlIlIIIIIlllllII | 0x1));
        }
        else {
            this.dataWatcher.updateObject(16, (byte)(lllllllllllllllIIlIlIIIIIlllllII & 0xFFFFFFFE));
        }
    }
    
    static {
        __OBFID = "CL_00001652";
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25);
    }
    
    static class AINearestAttackableTargetNonCreeper extends EntityAINearestAttackableTarget
    {
        static {
            __OBFID = "CL_00002231";
        }
        
        public AINearestAttackableTargetNonCreeper(final EntityCreature lllllllllllllllIIIlIlIIlIlIllIlI, final Class lllllllllllllllIIIlIlIIlIlIlIIlI, final int lllllllllllllllIIIlIlIIlIlIlIIIl, final boolean lllllllllllllllIIIlIlIIlIlIlIlll, final boolean lllllllllllllllIIIlIlIIlIlIIllll, final Predicate lllllllllllllllIIIlIlIIlIlIIlllI) {
            super(lllllllllllllllIIIlIlIIlIlIllIlI, lllllllllllllllIIIlIlIIlIlIlIIlI, lllllllllllllllIIIlIlIIlIlIlIIIl, lllllllllllllllIIIlIlIIlIlIlIlll, lllllllllllllllIIIlIlIIlIlIIllll, lllllllllllllllIIIlIlIIlIlIIlllI);
            this.targetEntitySelector = (Predicate)new Predicate() {
                static {
                    __OBFID = "CL_00002230";
                }
                
                public boolean apply(final Object lllllllllllllllIlIlIllIIllllllII) {
                    return this.func_180096_a((EntityLivingBase)lllllllllllllllIlIlIllIIllllllII);
                }
                
                public boolean func_180096_a(final EntityLivingBase lllllllllllllllIlIlIllIlIIIIIlII) {
                    if (lllllllllllllllIIIlIlIIlIlIIlllI != null && !lllllllllllllllIIIlIlIIlIlIIlllI.apply((Object)lllllllllllllllIlIlIllIlIIIIIlII)) {
                        return false;
                    }
                    if (lllllllllllllllIlIlIllIlIIIIIlII instanceof EntityCreeper) {
                        return false;
                    }
                    if (lllllllllllllllIlIlIllIlIIIIIlII instanceof EntityPlayer) {
                        double lllllllllllllllIlIlIllIlIIIIIlll = EntityAITarget.this.getTargetDistance();
                        if (lllllllllllllllIlIlIllIlIIIIIlII.isSneaking()) {
                            lllllllllllllllIlIlIllIlIIIIIlll *= 0.800000011920929;
                        }
                        if (lllllllllllllllIlIlIllIlIIIIIlII.isInvisible()) {
                            float lllllllllllllllIlIlIllIlIIIIIllI = ((EntityPlayer)lllllllllllllllIlIlIllIlIIIIIlII).getArmorVisibility();
                            if (lllllllllllllllIlIlIllIlIIIIIllI < 0.1f) {
                                lllllllllllllllIlIlIllIlIIIIIllI = 0.1f;
                            }
                            lllllllllllllllIlIlIllIlIIIIIlll *= 0.7f * lllllllllllllllIlIlIllIlIIIIIllI;
                        }
                        if (lllllllllllllllIlIlIllIlIIIIIlII.getDistanceToEntity(lllllllllllllllIIIlIlIIlIlIllIlI) > lllllllllllllllIlIlIllIlIIIIIlll) {
                            return false;
                        }
                    }
                    return EntityAITarget.this.isSuitableTarget(lllllllllllllllIlIlIllIlIIIIIlII, false);
                }
            };
        }
    }
}
