package net.minecraft.entity.passive;

import net.minecraft.entity.player.*;
import com.google.common.base.*;
import net.minecraft.init.*;
import net.minecraft.nbt.*;
import net.minecraft.world.*;
import net.minecraft.item.*;
import net.minecraft.pathfinding.*;
import net.minecraft.entity.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.ai.*;

public class EntityRabbit extends EntityAnimal
{
    private /* synthetic */ int field_175538_bq;
    private /* synthetic */ boolean field_175537_bp;
    private /* synthetic */ int field_175535_bn;
    private /* synthetic */ AIAvoidEntity field_175539_bk;
    private /* synthetic */ EntityPlayer field_175543_bt;
    private /* synthetic */ int field_175541_bs;
    private /* synthetic */ EnumMoveType field_175542_br;
    private /* synthetic */ boolean field_175536_bo;
    private /* synthetic */ int field_175540_bm;
    
    @Override
    protected float func_175134_bD() {
        return (this.moveHelper.isUpdating() && this.moveHelper.func_179919_e() > this.posY + 0.5) ? 0.5f : this.field_175542_br.func_180074_b();
    }
    
    private void func_175530_ct() {
        this.field_175538_bq = this.func_175532_cm();
    }
    
    public boolean func_175523_cj() {
        return this.field_175536_bo;
    }
    
    @Override
    public void func_174830_Y() {
    }
    
    public void func_175519_a(final boolean lllllllllllllllIlllIIIIIIIlIIlII, final EnumMoveType lllllllllllllllIlllIIIIIIIlIIIll) {
        super.setJumping(lllllllllllllllIlllIIIIIIIlIIlII);
        if (!lllllllllllllllIlllIIIIIIIlIIlII) {
            if (this.field_175542_br == EnumMoveType.ATTACK) {
                this.field_175542_br = EnumMoveType.HOP;
            }
        }
        else {
            this.func_175515_b(1.5 * lllllllllllllllIlllIIIIIIIlIIIll.func_180072_a());
            this.playSound(this.func_175516_ck(), this.getSoundVolume(), ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f) * 0.8f);
        }
        this.field_175536_bo = lllllllllllllllIlllIIIIIIIlIIlII;
    }
    
    public void func_175515_b(final double lllllllllllllllIlllIIIIIIIlIlllI) {
        this.getNavigator().setSpeed(lllllllllllllllIlllIIIIIIIlIlllI);
        this.moveHelper.setMoveTo(this.moveHelper.func_179917_d(), this.moveHelper.func_179919_e(), this.moveHelper.func_179918_f(), lllllllllllllllIlllIIIIIIIlIlllI);
    }
    
    @Override
    protected void addRandomArmor() {
        this.entityDropItem(new ItemStack(Items.rabbit_foot, 1), 0.0f);
    }
    
    private void func_175533_a(final double lllllllllllllllIlllIIIIIIIIIIIIl, final double lllllllllllllllIlllIIIIIIIIIIIII) {
        this.rotationYaw = (float)(Math.atan2(lllllllllllllllIlllIIIIIIIIIIIII - this.posZ, lllllllllllllllIlllIIIIIIIIIIIIl - this.posX) * 180.0 / 3.141592653589793) - 90.0f;
    }
    
    @Override
    public int getTotalArmorValue() {
        return (this.func_175531_cl() == 99) ? 8 : super.getTotalArmorValue();
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource lllllllllllllllIllIlllllllIIllIl, final float lllllllllllllllIllIlllllllIIllll) {
        return !this.func_180431_b(lllllllllllllllIllIlllllllIIllIl) && super.attackEntityFrom(lllllllllllllllIllIlllllllIIllIl, lllllllllllllllIllIlllllllIIllll);
    }
    
    public EntityRabbit(final World lllllllllllllllIlllIIIIIIlIIIIIl) {
        super(lllllllllllllllIlllIIIIIIlIIIIIl);
        this.field_175540_bm = 0;
        this.field_175535_bn = 0;
        this.field_175536_bo = false;
        this.field_175537_bp = false;
        this.field_175538_bq = 0;
        this.field_175542_br = EnumMoveType.HOP;
        this.field_175541_bs = 0;
        this.field_175543_bt = null;
        this.setSize(0.6f, 0.7f);
        this.jumpHelper = new RabbitJumpHelper(this);
        this.moveHelper = new RabbitMoveHelper();
        ((PathNavigateGround)this.getNavigator()).func_179690_a(true);
        this.navigator.func_179678_a(2.5f);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(1, new AIPanic(1.33));
        this.tasks.addTask(2, new EntityAITempt(this, 1.0, Items.carrot, false));
        this.tasks.addTask(3, new EntityAIMate(this, 0.8));
        this.tasks.addTask(5, new AIRaidFarm());
        this.tasks.addTask(5, new EntityAIWander(this, 0.6));
        this.tasks.addTask(11, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0f));
        this.field_175539_bk = new AIAvoidEntity((Predicate)new Predicate() {
            public boolean apply(final Object llllllllllllllIIllIIllIIlIIIlllI) {
                return this.func_180086_a((Entity)llllllllllllllIIllIIllIIlIIIlllI);
            }
            
            static {
                __OBFID = "CL_00002241";
            }
            
            public boolean func_180086_a(final Entity llllllllllllllIIllIIllIIlIIlIIlI) {
                return llllllllllllllIIllIIllIIlIIlIIlI instanceof EntityWolf;
            }
        }, 16.0f, 1.33, 1.33);
        this.tasks.addTask(4, this.field_175539_bk);
        this.func_175515_b(0.0);
    }
    
    protected String func_175516_ck() {
        return "mob.rabbit.hop";
    }
    
    protected void func_175528_cn() {
        this.worldObj.spawnParticle(EnumParticleTypes.BLOCK_DUST, this.posX + this.rand.nextFloat() * this.width * 2.0f - this.width, this.posY + 0.5 + this.rand.nextFloat() * this.height, this.posZ + this.rand.nextFloat() * this.width * 2.0f - this.width, 0.0, 0.0, 0.0, Block.getStateId(Blocks.carrots.getStateFromMeta(7)));
        this.field_175541_bs = 100;
    }
    
    private boolean func_175534_cv() {
        return this.field_175541_bs == 0;
    }
    
    @Override
    protected String getDeathSound() {
        return "mob.rabbit.death";
    }
    
    public void func_175529_r(final int lllllllllllllllIllIllllllIlIIIlI) {
        if (lllllllllllllllIllIllllllIlIIIlI == 99) {
            this.tasks.removeTask(this.field_175539_bk);
            this.tasks.addTask(4, new AIEvilAttack());
            this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
            this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
            this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityWolf.class, true));
            if (!this.hasCustomName()) {
                this.setCustomNameTag(StatCollector.translateToLocal("entity.KillerBunny.name"));
            }
        }
        this.dataWatcher.updateObject(18, (byte)lllllllllllllllIllIllllllIlIIIlI);
    }
    
    public void func_175522_a(final EnumMoveType lllllllllllllllIlllIIIIIIIlllIII) {
        this.field_175542_br = lllllllllllllllIlllIIIIIIIlllIII;
    }
    
    private void func_175517_cu() {
        this.func_175530_ct();
        this.func_175520_cs();
    }
    
    @Override
    public boolean attackEntityAsMob(final Entity lllllllllllllllIllIlllllllIllIII) {
        if (this.func_175531_cl() == 99) {
            this.playSound("mob.attack", 1.0f, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
            return lllllllllllllllIllIlllllllIllIII.attackEntityFrom(DamageSource.causeMobDamage(this), 8.0f);
        }
        return lllllllllllllllIllIlllllllIllIII.attackEntityFrom(DamageSource.causeMobDamage(this), 3.0f);
    }
    
    @Override
    public boolean isBreedingItem(final ItemStack lllllllllllllllIllIllllllIlIlIIl) {
        return lllllllllllllllIllIllllllIlIlIIl != null && this.func_175525_a(lllllllllllllllIllIllllllIlIlIIl.getItem());
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllllIllIllllllllIlIII) {
        super.writeEntityToNBT(lllllllllllllllIllIllllllllIlIII);
        lllllllllllllllIllIllllllllIlIII.setInteger("RabbitType", this.func_175531_cl());
        lllllllllllllllIllIllllllllIlIII.setInteger("MoreCarrotTicks", this.field_175541_bs);
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30000001192092896);
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(18, 0);
    }
    
    protected int func_175532_cm() {
        return this.field_175542_br.func_180075_c();
    }
    
    @Override
    public IEntityLivingData func_180482_a(final DifficultyInstance lllllllllllllllIllIllllllIIllIII, final IEntityLivingData lllllllllllllllIllIllllllIIlIIIl) {
        Object lllllllllllllllIllIllllllIIlIllI = super.func_180482_a(lllllllllllllllIllIllllllIIllIII, lllllllllllllllIllIllllllIIlIIIl);
        int lllllllllllllllIllIllllllIIlIlIl = this.rand.nextInt(6);
        boolean lllllllllllllllIllIllllllIIlIlII = false;
        if (lllllllllllllllIllIllllllIIlIllI instanceof RabbitTypeData) {
            lllllllllllllllIllIllllllIIlIlIl = ((RabbitTypeData)lllllllllllllllIllIllllllIIlIllI).field_179427_a;
            lllllllllllllllIllIllllllIIlIlII = true;
        }
        else {
            lllllllllllllllIllIllllllIIlIllI = new RabbitTypeData(lllllllllllllllIllIllllllIIlIlIl);
        }
        this.func_175529_r(lllllllllllllllIllIllllllIIlIlIl);
        if (lllllllllllllllIllIllllllIIlIlII) {
            this.setGrowingAge(-24000);
        }
        return (IEntityLivingData)lllllllllllllllIllIllllllIIlIllI;
    }
    
    static {
        __OBFID = "CL_00002242";
    }
    
    @Override
    protected String getHurtSound() {
        return "mob.rabbit.hurt";
    }
    
    public int func_175531_cl() {
        return this.dataWatcher.getWatchableObjectByte(18);
    }
    
    @Override
    protected String getLivingSound() {
        return "mob.rabbit.idle";
    }
    
    private boolean func_175525_a(final Item lllllllllllllllIllIllllllIlllIII) {
        return lllllllllllllllIllIllllllIlllIII == Items.carrot || lllllllllllllllIllIllllllIlllIII == Items.golden_carrot || lllllllllllllllIllIllllllIlllIII == Item.getItemFromBlock(Blocks.yellow_flower);
    }
    
    public void updateAITasks() {
        if (this.moveHelper.getSpeed() > 0.8) {
            this.func_175522_a(EnumMoveType.SPRINT);
        }
        else if (this.field_175542_br != EnumMoveType.ATTACK) {
            this.func_175522_a(EnumMoveType.HOP);
        }
        if (this.field_175538_bq > 0) {
            --this.field_175538_bq;
        }
        if (this.field_175541_bs > 0) {
            this.field_175541_bs -= this.rand.nextInt(3);
            if (this.field_175541_bs < 0) {
                this.field_175541_bs = 0;
            }
        }
        if (this.onGround) {
            if (!this.field_175537_bp) {
                this.func_175519_a(false, EnumMoveType.NONE);
                this.func_175517_cu();
            }
            if (this.func_175531_cl() == 99 && this.field_175538_bq == 0) {
                final EntityLivingBase lllllllllllllllIlllIIIIIIIIlIIIl = this.getAttackTarget();
                if (lllllllllllllllIlllIIIIIIIIlIIIl != null && this.getDistanceSqToEntity(lllllllllllllllIlllIIIIIIIIlIIIl) < 16.0) {
                    this.func_175533_a(lllllllllllllllIlllIIIIIIIIlIIIl.posX, lllllllllllllllIlllIIIIIIIIlIIIl.posZ);
                    this.moveHelper.setMoveTo(lllllllllllllllIlllIIIIIIIIlIIIl.posX, lllllllllllllllIlllIIIIIIIIlIIIl.posY, lllllllllllllllIlllIIIIIIIIlIIIl.posZ, this.moveHelper.getSpeed());
                    this.func_175524_b(EnumMoveType.ATTACK);
                    this.field_175537_bp = true;
                }
            }
            final RabbitJumpHelper lllllllllllllllIlllIIIIIIIIlIIII = (RabbitJumpHelper)this.jumpHelper;
            if (!lllllllllllllllIlllIIIIIIIIlIIII.func_180067_c()) {
                if (this.moveHelper.isUpdating() && this.field_175538_bq == 0) {
                    final PathEntity lllllllllllllllIlllIIIIIIIIIllll = this.navigator.getPath();
                    Vec3 lllllllllllllllIlllIIIIIIIIIlllI = new Vec3(this.moveHelper.func_179917_d(), this.moveHelper.func_179919_e(), this.moveHelper.func_179918_f());
                    if (lllllllllllllllIlllIIIIIIIIIllll != null && lllllllllllllllIlllIIIIIIIIIllll.getCurrentPathIndex() < lllllllllllllllIlllIIIIIIIIIllll.getCurrentPathLength()) {
                        lllllllllllllllIlllIIIIIIIIIlllI = lllllllllllllllIlllIIIIIIIIIllll.getPosition(this);
                    }
                    this.func_175533_a(lllllllllllllllIlllIIIIIIIIIlllI.xCoord, lllllllllllllllIlllIIIIIIIIIlllI.zCoord);
                    this.func_175524_b(this.field_175542_br);
                }
            }
            else if (!lllllllllllllllIlllIIIIIIIIlIIII.func_180065_d()) {
                this.func_175518_cr();
            }
        }
        this.field_175537_bp = this.onGround;
    }
    
    private void func_175518_cr() {
        ((RabbitJumpHelper)this.jumpHelper).func_180066_a(true);
    }
    
    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.field_175540_bm != this.field_175535_bn) {
            if (this.field_175540_bm == 0 && !this.worldObj.isRemote) {
                this.worldObj.setEntityState(this, (byte)1);
            }
            ++this.field_175540_bm;
        }
        else if (this.field_175535_bn != 0) {
            this.field_175540_bm = 0;
            this.field_175535_bn = 0;
        }
    }
    
    @Override
    protected void dropFewItems(final boolean lllllllllllllllIllIlllllllIIIIll, final int lllllllllllllllIllIllllllIlllllI) {
        for (int lllllllllllllllIllIlllllllIIIIIl = this.rand.nextInt(2) + this.rand.nextInt(1 + lllllllllllllllIllIllllllIlllllI), lllllllllllllllIllIlllllllIIIIII = 0; lllllllllllllllIllIlllllllIIIIII < lllllllllllllllIllIlllllllIIIIIl; ++lllllllllllllllIllIlllllllIIIIII) {
            this.dropItem(Items.rabbit_hide, 1);
        }
        for (int lllllllllllllllIllIlllllllIIIIIl = this.rand.nextInt(2), lllllllllllllllIllIlllllllIIIIII = 0; lllllllllllllllIllIlllllllIIIIII < lllllllllllllllIllIlllllllIIIIIl; ++lllllllllllllllIllIlllllllIIIIII) {
            if (this.isBurning()) {
                this.dropItem(Items.cooked_rabbit, 1);
            }
            else {
                this.dropItem(Items.rabbit, 1);
            }
        }
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllllIllIllllllllIIlII) {
        super.readEntityFromNBT(lllllllllllllllIllIllllllllIIlII);
        this.func_175529_r(lllllllllllllllIllIllllllllIIlII.getInteger("RabbitType"));
        this.field_175541_bs = lllllllllllllllIllIllllllllIIlII.getInteger("MoreCarrotTicks");
    }
    
    @Override
    public void handleHealthUpdate(final byte lllllllllllllllIllIllllllIIIIIIl) {
        if (lllllllllllllllIllIllllllIIIIIIl == 1) {
            this.func_174808_Z();
            this.field_175535_bn = 10;
            this.field_175540_bm = 0;
        }
        else {
            super.handleHealthUpdate(lllllllllllllllIllIllllllIIIIIIl);
        }
    }
    
    public void func_175524_b(final EnumMoveType lllllllllllllllIlllIIIIIIIIlllll) {
        this.func_175519_a(true, lllllllllllllllIlllIIIIIIIIlllll);
        this.field_175535_bn = lllllllllllllllIlllIIIIIIIIlllll.func_180073_d();
        this.field_175540_bm = 0;
    }
    
    public EntityRabbit func_175526_b(final EntityAgeable lllllllllllllllIllIllllllIllIIll) {
        final EntityRabbit lllllllllllllllIllIllllllIllIIlI = new EntityRabbit(this.worldObj);
        if (lllllllllllllllIllIllllllIllIIll instanceof EntityRabbit) {
            lllllllllllllllIllIllllllIllIIlI.func_175529_r(this.rand.nextBoolean() ? this.func_175531_cl() : ((EntityRabbit)lllllllllllllllIllIllllllIllIIll).func_175531_cl());
        }
        return lllllllllllllllIllIllllllIllIIlI;
    }
    
    @Override
    public EntityAgeable createChild(final EntityAgeable lllllllllllllllIllIlllllIllllIIl) {
        return this.func_175526_b(lllllllllllllllIllIlllllIllllIIl);
    }
    
    private void func_175520_cs() {
        ((RabbitJumpHelper)this.jumpHelper).func_180066_a(false);
    }
    
    public float func_175521_o(final float lllllllllllllllIlllIIIIIIIllIIlI) {
        return (this.field_175535_bn == 0) ? 0.0f : ((this.field_175540_bm + lllllllllllllllIlllIIIIIIIllIIlI) / this.field_175535_bn);
    }
    
    class AIEvilAttack extends EntityAIAttackOnCollide
    {
        public AIEvilAttack() {
            super(EntityRabbit.this, EntityLivingBase.class, 1.4, true);
        }
        
        @Override
        protected double func_179512_a(final EntityLivingBase lllllllllllllllIllIIIIlIllIIIlIl) {
            return 4.0f + lllllllllllllllIllIIIIlIllIIIlIl.width;
        }
        
        static {
            __OBFID = "CL_00002240";
        }
    }
    
    class RabbitMoveHelper extends EntityMoveHelper
    {
        static {
            __OBFID = "CL_00002235";
        }
        
        public RabbitMoveHelper() {
            super(EntityRabbit.this);
        }
        
        @Override
        public void onUpdateMoveHelper() {
            if (EntityRabbit.this.onGround && !EntityRabbit.this.func_175523_cj()) {
                EntityRabbit.this.func_175515_b(0.0);
            }
            super.onUpdateMoveHelper();
        }
    }
    
    class AIPanic extends EntityAIPanic
    {
        public AIPanic(final double lllllllllllllllIIIIlIIIIIlIIllII) {
            super(EntityRabbit.this, lllllllllllllllIIIIlIIIIIlIIllII);
        }
        
        @Override
        public void updateTask() {
            super.updateTask();
            EntityRabbit.this.func_175515_b(this.speed);
        }
        
        static {
            __OBFID = "CL_00002234";
        }
    }
    
    enum EnumMoveType
    {
        private final /* synthetic */ int field_180085_i;
        private final /* synthetic */ float field_180076_f;
        
        HOP("HOP", 1, "HOP", 1, 0.8f, 0.2f, 20, 10), 
        NONE("NONE", 0, "NONE", 0, 0.0f, 0.0f, 30, 1), 
        SPRINT("SPRINT", 3, "SPRINT", 3, 1.75f, 0.4f, 1, 8);
        
        private final /* synthetic */ float field_180077_g;
        
        ATTACK("ATTACK", 4, "ATTACK", 4, 2.0f, 0.7f, 7, 8), 
        STEP("STEP", 2, "STEP", 2, 1.0f, 0.45f, 14, 14);
        
        private final /* synthetic */ int field_180084_h;
        
        public int func_180075_c() {
            return this.field_180084_h;
        }
        
        private EnumMoveType(final String llllllllllllllllllIlllIlllllIllI, final int llllllllllllllllllIlllIlllllIlIl, final String llllllllllllllllllIlllIlllllllIl, final int llllllllllllllllllIlllIlllllllII, final float llllllllllllllllllIlllIllllllIll, final float llllllllllllllllllIlllIlllllIIll, final int llllllllllllllllllIlllIlllllIIlI, final int llllllllllllllllllIlllIllllllIII) {
            this.field_180076_f = llllllllllllllllllIlllIllllllIll;
            this.field_180077_g = llllllllllllllllllIlllIlllllIIll;
            this.field_180084_h = llllllllllllllllllIlllIlllllIIlI;
            this.field_180085_i = llllllllllllllllllIlllIllllllIII;
        }
        
        public int func_180073_d() {
            return this.field_180085_i;
        }
        
        public float func_180074_b() {
            return this.field_180077_g;
        }
        
        public float func_180072_a() {
            return this.field_180076_f;
        }
        
        static {
            __OBFID = "CL_00002239";
        }
    }
    
    class AIRaidFarm extends EntityAIMoveToBlock
    {
        private /* synthetic */ boolean field_179498_d;
        private /* synthetic */ boolean field_179499_e;
        
        static {
            __OBFID = "CL_00002233";
        }
        
        @Override
        public boolean continueExecuting() {
            return this.field_179499_e && super.continueExecuting();
        }
        
        @Override
        public void updateTask() {
            super.updateTask();
            EntityRabbit.this.getLookHelper().setLookPosition(this.field_179494_b.getX() + 0.5, this.field_179494_b.getY() + 1, this.field_179494_b.getZ() + 0.5, 10.0f, (float)EntityRabbit.this.getVerticalFaceSpeed());
            if (this.func_179487_f()) {
                final World lllllllllllllllIIlIIIIIIIllIlIII = EntityRabbit.this.worldObj;
                final BlockPos lllllllllllllllIIlIIIIIIIllIIlll = this.field_179494_b.offsetUp();
                final IBlockState lllllllllllllllIIlIIIIIIIllIIllI = lllllllllllllllIIlIIIIIIIllIlIII.getBlockState(lllllllllllllllIIlIIIIIIIllIIlll);
                final Block lllllllllllllllIIlIIIIIIIllIIlIl = lllllllllllllllIIlIIIIIIIllIIllI.getBlock();
                if (this.field_179499_e && lllllllllllllllIIlIIIIIIIllIIlIl instanceof BlockCarrot && (int)lllllllllllllllIIlIIIIIIIllIIllI.getValue(BlockCarrot.AGE) == 7) {
                    lllllllllllllllIIlIIIIIIIllIlIII.setBlockState(lllllllllllllllIIlIIIIIIIllIIlll, Blocks.air.getDefaultState(), 2);
                    lllllllllllllllIIlIIIIIIIllIlIII.destroyBlock(lllllllllllllllIIlIIIIIIIllIIlll, true);
                    EntityRabbit.this.func_175528_cn();
                }
                this.field_179499_e = false;
                this.field_179496_a = 10;
            }
        }
        
        @Override
        protected boolean func_179488_a(final World lllllllllllllllIIlIIIIIIIlIllIIl, BlockPos lllllllllllllllIIlIIIIIIIlIlIIll) {
            Block lllllllllllllllIIlIIIIIIIlIlIlll = lllllllllllllllIIlIIIIIIIlIllIIl.getBlockState(lllllllllllllllIIlIIIIIIIlIlIIll).getBlock();
            if (lllllllllllllllIIlIIIIIIIlIlIlll == Blocks.farmland) {
                lllllllllllllllIIlIIIIIIIlIlIIll = lllllllllllllllIIlIIIIIIIlIlIIll.offsetUp();
                final IBlockState lllllllllllllllIIlIIIIIIIlIlIllI = lllllllllllllllIIlIIIIIIIlIllIIl.getBlockState(lllllllllllllllIIlIIIIIIIlIlIIll);
                lllllllllllllllIIlIIIIIIIlIlIlll = lllllllllllllllIIlIIIIIIIlIlIllI.getBlock();
                if (lllllllllllllllIIlIIIIIIIlIlIlll instanceof BlockCarrot && (int)lllllllllllllllIIlIIIIIIIlIlIllI.getValue(BlockCarrot.AGE) == 7 && this.field_179498_d && !this.field_179499_e) {
                    this.field_179499_e = true;
                    return true;
                }
            }
            return false;
        }
        
        @Override
        public void startExecuting() {
            super.startExecuting();
        }
        
        public AIRaidFarm() {
            super(EntityRabbit.this, 0.699999988079071, 16);
            this.field_179499_e = false;
        }
        
        @Override
        public void resetTask() {
            super.resetTask();
        }
        
        @Override
        public boolean shouldExecute() {
            if (this.field_179496_a <= 0) {
                if (!EntityRabbit.this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
                    return false;
                }
                this.field_179499_e = false;
                this.field_179498_d = EntityRabbit.this.func_175534_cv();
            }
            return super.shouldExecute();
        }
    }
    
    public static class RabbitTypeData implements IEntityLivingData
    {
        public /* synthetic */ int field_179427_a;
        
        static {
            __OBFID = "CL_00002237";
        }
        
        public RabbitTypeData(final int llllllllllllllIIIIIllllIIIIlIlII) {
            this.field_179427_a = llllllllllllllIIIIIllllIIIIlIlII;
        }
    }
    
    class AIAvoidEntity extends EntityAIAvoidEntity
    {
        public AIAvoidEntity(final Predicate llllllllllllllIIIIIlIIIIIlIIIIIl, final float llllllllllllllIIIIIlIIIIIlIIIllI, final double llllllllllllllIIIIIlIIIIIlIIIlIl, final double llllllllllllllIIIIIlIIIIIlIIIlII) {
            super(EntityRabbit.this, llllllllllllllIIIIIlIIIIIlIIIIIl, llllllllllllllIIIIIlIIIIIlIIIllI, llllllllllllllIIIIIlIIIIIlIIIlIl, llllllllllllllIIIIIlIIIIIlIIIlII);
        }
        
        static {
            __OBFID = "CL_00002238";
        }
        
        @Override
        public void updateTask() {
            super.updateTask();
        }
    }
    
    public class RabbitJumpHelper extends EntityJumpHelper
    {
        private /* synthetic */ boolean field_180068_d;
        
        public boolean func_180067_c() {
            return this.isJumping;
        }
        
        public void func_180066_a(final boolean llllllllllllllIIIIIlIIIIlIllIIII) {
            this.field_180068_d = llllllllllllllIIIIIlIIIIlIllIIII;
        }
        
        public RabbitJumpHelper() {
            super(EntityRabbit.this);
            this.field_180068_d = false;
        }
        
        @Override
        public void doJump() {
            if (this.isJumping) {
                EntityRabbit.this.func_175524_b(EnumMoveType.STEP);
                this.isJumping = false;
            }
        }
        
        public boolean func_180065_d() {
            return this.field_180068_d;
        }
        
        static {
            __OBFID = "CL_00002236";
        }
    }
}
