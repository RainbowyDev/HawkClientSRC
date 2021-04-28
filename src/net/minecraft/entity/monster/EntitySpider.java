package net.minecraft.entity.monster;

import net.minecraft.util.*;
import net.minecraft.block.*;
import net.minecraft.potion.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.entity.player.*;
import net.minecraft.pathfinding.*;
import net.minecraft.world.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.*;
import java.util.*;

public class EntitySpider extends EntityMob
{
    @Override
    protected void func_180429_a(final BlockPos llllllllllllllIllIllIIlIllIlIllI, final Block llllllllllllllIllIllIIlIllIlIlIl) {
        this.playSound("mob.spider.step", 0.15f, 1.0f);
    }
    
    @Override
    public boolean isPotionApplicable(final PotionEffect llllllllllllllIllIllIIlIllIIIIIl) {
        return llllllllllllllIllIllIIlIllIIIIIl.getPotionID() != Potion.poison.id && super.isPotionApplicable(llllllllllllllIllIllIIlIllIIIIIl);
    }
    
    public boolean isBesideClimbableBlock() {
        return (this.dataWatcher.getWatchableObjectByte(16) & 0x1) != 0x0;
    }
    
    @Override
    protected Item getDropItem() {
        return Items.string;
    }
    
    @Override
    protected void dropFewItems(final boolean llllllllllllllIllIllIIlIllIIlIll, final int llllllllllllllIllIllIIlIllIIlIlI) {
        super.dropFewItems(llllllllllllllIllIllIIlIllIIlIll, llllllllllllllIllIllIIlIllIIlIlI);
        if (llllllllllllllIllIllIIlIllIIlIll && (this.rand.nextInt(3) == 0 || this.rand.nextInt(1 + llllllllllllllIllIllIIlIllIIlIlI) > 0)) {
            this.dropItem(Items.spider_eye, 1);
        }
    }
    
    public EntitySpider(final World llllllllllllllIllIllIIlIlllIlIll) {
        super(llllllllllllllIllIllIIlIlllIlIll);
        this.setSize(1.4f, 0.9f);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.field_175455_a);
        this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4f));
        this.tasks.addTask(4, new AISpiderAttack(EntityPlayer.class));
        this.tasks.addTask(4, new AISpiderAttack(EntityIronGolem.class));
        this.tasks.addTask(5, new EntityAIWander(this, 0.8));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
        this.targetTasks.addTask(2, new AISpiderTarget(EntityPlayer.class));
        this.targetTasks.addTask(3, new AISpiderTarget(EntityIronGolem.class));
    }
    
    @Override
    protected String getLivingSound() {
        return "mob.spider.say";
    }
    
    @Override
    public float getEyeHeight() {
        return 0.65f;
    }
    
    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.ARTHROPOD;
    }
    
    @Override
    protected String getHurtSound() {
        return "mob.spider.say";
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(16.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30000001192092896);
    }
    
    @Override
    public boolean isOnLadder() {
        return this.isBesideClimbableBlock();
    }
    
    public void setBesideClimbableBlock(final boolean llllllllllllllIllIllIIlIlIllIlll) {
        byte llllllllllllllIllIllIIlIlIllIllI = this.dataWatcher.getWatchableObjectByte(16);
        if (llllllllllllllIllIllIIlIlIllIlll) {
            llllllllllllllIllIllIIlIlIllIllI |= 0x1;
        }
        else {
            llllllllllllllIllIllIIlIlIllIllI &= 0xFFFFFFFE;
        }
        this.dataWatcher.updateObject(16, llllllllllllllIllIllIIlIlIllIllI);
    }
    
    @Override
    public void setInWeb() {
    }
    
    static {
        __OBFID = "CL_00001699";
    }
    
    @Override
    protected PathNavigate func_175447_b(final World llllllllllllllIllIllIIlIlllIIlIl) {
        return new PathNavigateClimber(this, llllllllllllllIllIllIIlIlllIIlIl);
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, new Byte((byte)0));
    }
    
    @Override
    public IEntityLivingData func_180482_a(final DifficultyInstance llllllllllllllIllIllIIlIlIlIllII, final IEntityLivingData llllllllllllllIllIllIIlIlIlIlIll) {
        Object llllllllllllllIllIllIIlIlIlIlIlI = super.func_180482_a(llllllllllllllIllIllIIlIlIlIllII, llllllllllllllIllIllIIlIlIlIlIll);
        if (this.worldObj.rand.nextInt(100) == 0) {
            final EntitySkeleton llllllllllllllIllIllIIlIlIlIlIIl = new EntitySkeleton(this.worldObj);
            llllllllllllllIllIllIIlIlIlIlIIl.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
            llllllllllllllIllIllIIlIlIlIlIIl.func_180482_a(llllllllllllllIllIllIIlIlIlIllII, null);
            this.worldObj.spawnEntityInWorld(llllllllllllllIllIllIIlIlIlIlIIl);
            llllllllllllllIllIllIIlIlIlIlIIl.mountEntity(this);
        }
        if (llllllllllllllIllIllIIlIlIlIlIlI == null) {
            llllllllllllllIllIllIIlIlIlIlIlI = new GroupData();
            if (this.worldObj.getDifficulty() == EnumDifficulty.HARD && this.worldObj.rand.nextFloat() < 0.1f * llllllllllllllIllIllIIlIlIlIllII.func_180170_c()) {
                ((GroupData)llllllllllllllIllIllIIlIlIlIlIlI).func_111104_a(this.worldObj.rand);
            }
        }
        if (llllllllllllllIllIllIIlIlIlIlIlI instanceof GroupData) {
            final int llllllllllllllIllIllIIlIlIlIlIII = ((GroupData)llllllllllllllIllIllIIlIlIlIlIlI).field_111105_a;
            if (llllllllllllllIllIllIIlIlIlIlIII > 0 && Potion.potionTypes[llllllllllllllIllIllIIlIlIlIlIII] != null) {
                this.addPotionEffect(new PotionEffect(llllllllllllllIllIllIIlIlIlIlIII, Integer.MAX_VALUE));
            }
        }
        return (IEntityLivingData)llllllllllllllIllIllIIlIlIlIlIlI;
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!this.worldObj.isRemote) {
            this.setBesideClimbableBlock(this.isCollidedHorizontally);
        }
    }
    
    @Override
    protected String getDeathSound() {
        return "mob.spider.death";
    }
    
    class AISpiderTarget extends EntityAINearestAttackableTarget
    {
        static {
            __OBFID = "CL_00002196";
        }
        
        public AISpiderTarget(final Class llllllllllllllllllIlIIlIIIIllIII) {
            super(EntitySpider.this, llllllllllllllllllIlIIlIIIIllIII, true);
        }
        
        @Override
        public boolean shouldExecute() {
            final float llllllllllllllllllIlIIlIIIIlIlII = this.taskOwner.getBrightness(1.0f);
            return llllllllllllllllllIlIIlIIIIlIlII < 0.5f && super.shouldExecute();
        }
    }
    
    class AISpiderAttack extends EntityAIAttackOnCollide
    {
        @Override
        public boolean continueExecuting() {
            final float llllllllllllllIIlllIIlIIllIIIlII = this.attacker.getBrightness(1.0f);
            if (llllllllllllllIIlllIIlIIllIIIlII >= 0.5f && this.attacker.getRNG().nextInt(100) == 0) {
                this.attacker.setAttackTarget(null);
                return false;
            }
            return super.continueExecuting();
        }
        
        static {
            __OBFID = "CL_00002197";
        }
        
        @Override
        protected double func_179512_a(final EntityLivingBase llllllllllllllIIlllIIlIIlIlllllI) {
            return 4.0f + llllllllllllllIIlllIIlIIlIlllllI.width;
        }
        
        public AISpiderAttack(final Class llllllllllllllIIlllIIlIIllIIlIll) {
            super(EntitySpider.this, llllllllllllllIIlllIIlIIllIIlIll, 1.0, true);
        }
    }
    
    public static class GroupData implements IEntityLivingData
    {
        public /* synthetic */ int field_111105_a;
        
        public void func_111104_a(final Random llllllllllllllIlIlIllIllIIllIIIl) {
            final int llllllllllllllIlIlIllIllIIllIIll = llllllllllllllIlIlIllIllIIllIIIl.nextInt(5);
            if (llllllllllllllIlIlIllIllIIllIIll <= 1) {
                this.field_111105_a = Potion.moveSpeed.id;
            }
            else if (llllllllllllllIlIlIllIllIIllIIll <= 2) {
                this.field_111105_a = Potion.damageBoost.id;
            }
            else if (llllllllllllllIlIlIllIllIIllIIll <= 3) {
                this.field_111105_a = Potion.regeneration.id;
            }
            else if (llllllllllllllIlIlIllIllIIllIIll <= 4) {
                this.field_111105_a = Potion.invisibility.id;
            }
        }
        
        static {
            __OBFID = "CL_00001700";
        }
    }
}
