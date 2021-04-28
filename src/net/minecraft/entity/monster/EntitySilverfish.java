package net.minecraft.entity.monster;

import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import java.util.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.ai.*;
import net.minecraft.util.*;

public class EntitySilverfish extends EntityMob
{
    private /* synthetic */ AISummonSilverfish field_175460_b;
    
    static {
        __OBFID = "CL_00001696";
    }
    
    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.ARTHROPOD;
    }
    
    @Override
    protected String getDeathSound() {
        return "mob.silverfish.kill";
    }
    
    @Override
    public boolean getCanSpawnHere() {
        if (super.getCanSpawnHere()) {
            final EntityPlayer llllllllllllllIIIlIIlllllIIllIlI = this.worldObj.getClosestPlayerToEntity(this, 5.0);
            return llllllllllllllIIIlIIlllllIIllIlI == null;
        }
        return false;
    }
    
    @Override
    protected String getHurtSound() {
        return "mob.silverfish.hit";
    }
    
    @Override
    public float func_180484_a(final BlockPos llllllllllllllIIIlIIlllllIlIIIIl) {
        return (this.worldObj.getBlockState(llllllllllllllIIIlIIlllllIlIIIIl.offsetDown()).getBlock() == Blocks.stone) ? 10.0f : super.func_180484_a(llllllllllllllIIIlIIlllllIlIIIIl);
    }
    
    @Override
    protected String getLivingSound() {
        return "mob.silverfish.say";
    }
    
    @Override
    protected void func_180429_a(final BlockPos llllllllllllllIIIlIIlllllIlIlIll, final Block llllllllllllllIIIlIIlllllIlIlIlI) {
        this.playSound("mob.silverfish.step", 0.15f, 1.0f);
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(8.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1.0);
    }
    
    @Override
    protected boolean isValidLightLevel() {
        return true;
    }
    
    @Override
    public float getEyeHeight() {
        return 0.1f;
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource llllllllllllllIIIlIIlllllIlIllll, final float llllllllllllllIIIlIIlllllIllIIIl) {
        if (this.func_180431_b(llllllllllllllIIIlIIlllllIlIllll)) {
            return false;
        }
        if (llllllllllllllIIIlIIlllllIlIllll instanceof EntityDamageSource || llllllllllllllIIIlIIlllllIlIllll == DamageSource.magic) {
            this.field_175460_b.func_179462_f();
        }
        return super.attackEntityFrom(llllllllllllllIIIlIIlllllIlIllll, llllllllllllllIIIlIIlllllIllIIIl);
    }
    
    public EntitySilverfish(final World llllllllllllllIIIlIIllllllIIIIIl) {
        super(llllllllllllllIIIlIIllllllIIIIIl);
        this.setSize(0.4f, 0.3f);
        this.tasks.addTask(1, new EntityAISwimming(this));
        final EntityAITasks tasks = this.tasks;
        final int llllllllllllllllIIIlIllIIlIllllI = 3;
        final AISummonSilverfish aiSummonSilverfish = new AISummonSilverfish();
        this.field_175460_b = aiSummonSilverfish;
        tasks.addTask(llllllllllllllllIIIlIllIIlIllllI, aiSummonSilverfish);
        this.tasks.addTask(4, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0, false));
        this.tasks.addTask(5, new AIHideInStone());
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[0]));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
    }
    
    @Override
    public void onUpdate() {
        this.renderYawOffset = this.rotationYaw;
        super.onUpdate();
    }
    
    @Override
    protected boolean canTriggerWalking() {
        return false;
    }
    
    @Override
    protected Item getDropItem() {
        return null;
    }
    
    class AISummonSilverfish extends EntityAIBase
    {
        private /* synthetic */ int field_179463_b;
        
        public void func_179462_f() {
            if (this.field_179463_b == 0) {
                this.field_179463_b = 20;
            }
        }
        
        @Override
        public boolean shouldExecute() {
            return this.field_179463_b > 0;
        }
        
        @Override
        public void updateTask() {
            --this.field_179463_b;
            if (this.field_179463_b <= 0) {
                final World llllllllllllllIIllllIIlllIlIIIlI = EntitySilverfish.this.worldObj;
                final Random llllllllllllllIIllllIIlllIlIIIIl = EntitySilverfish.this.getRNG();
                final BlockPos llllllllllllllIIllllIIlllIlIIIII = new BlockPos(EntitySilverfish.this);
                for (int llllllllllllllIIllllIIlllIIlllll = 0; llllllllllllllIIllllIIlllIIlllll <= 5 && llllllllllllllIIllllIIlllIIlllll >= -5; llllllllllllllIIllllIIlllIIlllll = ((llllllllllllllIIllllIIlllIIlllll <= 0) ? (1 - llllllllllllllIIllllIIlllIIlllll) : (0 - llllllllllllllIIllllIIlllIIlllll))) {
                    for (int llllllllllllllIIllllIIlllIIllllI = 0; llllllllllllllIIllllIIlllIIllllI <= 10 && llllllllllllllIIllllIIlllIIllllI >= -10; llllllllllllllIIllllIIlllIIllllI = ((llllllllllllllIIllllIIlllIIllllI <= 0) ? (1 - llllllllllllllIIllllIIlllIIllllI) : (0 - llllllllllllllIIllllIIlllIIllllI))) {
                        for (int llllllllllllllIIllllIIlllIIlllIl = 0; llllllllllllllIIllllIIlllIIlllIl <= 10 && llllllllllllllIIllllIIlllIIlllIl >= -10; llllllllllllllIIllllIIlllIIlllIl = ((llllllllllllllIIllllIIlllIIlllIl <= 0) ? (1 - llllllllllllllIIllllIIlllIIlllIl) : (0 - llllllllllllllIIllllIIlllIIlllIl))) {
                            final BlockPos llllllllllllllIIllllIIlllIIlllII = llllllllllllllIIllllIIlllIlIIIII.add(llllllllllllllIIllllIIlllIIllllI, llllllllllllllIIllllIIlllIIlllll, llllllllllllllIIllllIIlllIIlllIl);
                            final IBlockState llllllllllllllIIllllIIlllIIllIll = llllllllllllllIIllllIIlllIlIIIlI.getBlockState(llllllllllllllIIllllIIlllIIlllII);
                            if (llllllllllllllIIllllIIlllIIllIll.getBlock() == Blocks.monster_egg) {
                                if (llllllllllllllIIllllIIlllIlIIIlI.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
                                    llllllllllllllIIllllIIlllIlIIIlI.destroyBlock(llllllllllllllIIllllIIlllIIlllII, true);
                                }
                                else {
                                    llllllllllllllIIllllIIlllIlIIIlI.setBlockState(llllllllllllllIIllllIIlllIIlllII, ((BlockSilverfish.EnumType)llllllllllllllIIllllIIlllIIllIll.getValue(BlockSilverfish.VARIANT_PROP)).func_176883_d(), 3);
                                }
                                if (llllllllllllllIIllllIIlllIlIIIIl.nextBoolean()) {
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        
        static {
            __OBFID = "CL_00002204";
        }
    }
    
    class AIHideInStone extends EntityAIWander
    {
        private /* synthetic */ boolean field_179484_c;
        private /* synthetic */ EnumFacing field_179483_b;
        
        static {
            __OBFID = "CL_00002205";
        }
        
        public AIHideInStone() {
            super(EntitySilverfish.this, 1.0, 10);
            this.setMutexBits(1);
        }
        
        @Override
        public void startExecuting() {
            if (!this.field_179484_c) {
                super.startExecuting();
            }
            else {
                final World llllllllllllllllllllIlllIlIIlllI = EntitySilverfish.this.worldObj;
                final BlockPos llllllllllllllllllllIlllIlIIllIl = new BlockPos(EntitySilverfish.this.posX, EntitySilverfish.this.posY + 0.5, EntitySilverfish.this.posZ).offset(this.field_179483_b);
                final IBlockState llllllllllllllllllllIlllIlIIllII = llllllllllllllllllllIlllIlIIlllI.getBlockState(llllllllllllllllllllIlllIlIIllIl);
                if (BlockSilverfish.func_176377_d(llllllllllllllllllllIlllIlIIllII)) {
                    llllllllllllllllllllIlllIlIIlllI.setBlockState(llllllllllllllllllllIlllIlIIllIl, Blocks.monster_egg.getDefaultState().withProperty(BlockSilverfish.VARIANT_PROP, BlockSilverfish.EnumType.func_176878_a(llllllllllllllllllllIlllIlIIllII)), 3);
                    EntitySilverfish.this.spawnExplosionParticle();
                    EntitySilverfish.this.setDead();
                }
            }
        }
        
        @Override
        public boolean shouldExecute() {
            if (EntitySilverfish.this.getAttackTarget() != null) {
                return false;
            }
            if (!EntitySilverfish.this.getNavigator().noPath()) {
                return false;
            }
            final Random llllllllllllllllllllIlllIlIlllIl = EntitySilverfish.this.getRNG();
            if (llllllllllllllllllllIlllIlIlllIl.nextInt(10) == 0) {
                this.field_179483_b = EnumFacing.random(llllllllllllllllllllIlllIlIlllIl);
                final BlockPos llllllllllllllllllllIlllIlIlllII = new BlockPos(EntitySilverfish.this.posX, EntitySilverfish.this.posY + 0.5, EntitySilverfish.this.posZ).offset(this.field_179483_b);
                final IBlockState llllllllllllllllllllIlllIlIllIll = EntitySilverfish.this.worldObj.getBlockState(llllllllllllllllllllIlllIlIlllII);
                if (BlockSilverfish.func_176377_d(llllllllllllllllllllIlllIlIllIll)) {
                    this.field_179484_c = true;
                    return true;
                }
            }
            this.field_179484_c = false;
            return super.shouldExecute();
        }
        
        @Override
        public boolean continueExecuting() {
            return !this.field_179484_c && super.continueExecuting();
        }
    }
}
