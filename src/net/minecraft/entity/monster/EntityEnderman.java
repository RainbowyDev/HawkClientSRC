package net.minecraft.entity.monster;

import net.minecraft.nbt.*;
import net.minecraft.block.*;
import net.minecraft.block.state.*;
import net.minecraft.item.*;
import com.google.common.collect.*;
import net.minecraft.init.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import com.google.common.base.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.*;
import net.minecraft.block.material.*;
import net.minecraft.util.*;
import net.minecraft.entity.ai.attributes.*;
import java.util.*;

public class EntityEnderman extends EntityMob
{
    private static final /* synthetic */ Set carriableBlocks;
    private /* synthetic */ boolean isAggressive;
    private static final /* synthetic */ UUID attackingSpeedBoostModifierUUID;
    private static final /* synthetic */ AttributeModifier attackingSpeedBoostModifier;
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllllIllllIlIlllIIIlII) {
        super.writeEntityToNBT(lllllllllllllllIllllIlIlllIIIlII);
        final IBlockState lllllllllllllllIllllIlIlllIIIllI = this.func_175489_ck();
        lllllllllllllllIllllIlIlllIIIlII.setShort("carried", (short)Block.getIdFromBlock(lllllllllllllllIllllIlIlllIIIllI.getBlock()));
        lllllllllllllllIllllIlIlllIIIlII.setShort("carriedData", (short)lllllllllllllllIllllIlIlllIIIllI.getBlock().getMetaFromState(lllllllllllllllIllllIlIlllIIIllI));
    }
    
    @Override
    protected String getDeathSound() {
        return "mob.endermen.death";
    }
    
    protected boolean teleportTo(final double lllllllllllllllIllllIlIlIllIIIlI, final double lllllllllllllllIllllIlIlIllIIIIl, final double lllllllllllllllIllllIlIlIlIIlIll) {
        final double lllllllllllllllIllllIlIlIlIlllll = this.posX;
        final double lllllllllllllllIllllIlIlIlIllllI = this.posY;
        final double lllllllllllllllIllllIlIlIlIlllIl = this.posZ;
        this.posX = lllllllllllllllIllllIlIlIllIIIlI;
        this.posY = lllllllllllllllIllllIlIlIllIIIIl;
        this.posZ = lllllllllllllllIllllIlIlIlIIlIll;
        boolean lllllllllllllllIllllIlIlIlIlllII = false;
        BlockPos lllllllllllllllIllllIlIlIlIllIll = new BlockPos(this.posX, this.posY, this.posZ);
        if (this.worldObj.isBlockLoaded(lllllllllllllllIllllIlIlIlIllIll)) {
            boolean lllllllllllllllIllllIlIlIlIllIlI = false;
            while (!lllllllllllllllIllllIlIlIlIllIlI && lllllllllllllllIllllIlIlIlIllIll.getY() > 0) {
                final BlockPos lllllllllllllllIllllIlIlIlIllIIl = lllllllllllllllIllllIlIlIlIllIll.offsetDown();
                final Block lllllllllllllllIllllIlIlIlIllIII = this.worldObj.getBlockState(lllllllllllllllIllllIlIlIlIllIIl).getBlock();
                if (lllllllllllllllIllllIlIlIlIllIII.getMaterial().blocksMovement()) {
                    lllllllllllllllIllllIlIlIlIllIlI = true;
                }
                else {
                    --this.posY;
                    lllllllllllllllIllllIlIlIlIllIll = lllllllllllllllIllllIlIlIlIllIIl;
                }
            }
            if (lllllllllllllllIllllIlIlIlIllIlI) {
                super.setPositionAndUpdate(this.posX, this.posY, this.posZ);
                if (this.worldObj.getCollidingBoundingBoxes(this, this.getEntityBoundingBox()).isEmpty() && !this.worldObj.isAnyLiquid(this.getEntityBoundingBox())) {
                    lllllllllllllllIllllIlIlIlIlllII = true;
                }
            }
        }
        if (!lllllllllllllllIllllIlIlIlIlllII) {
            this.setPosition(lllllllllllllllIllllIlIlIlIlllll, lllllllllllllllIllllIlIlIlIllllI, lllllllllllllllIllllIlIlIlIlllIl);
            return false;
        }
        final short lllllllllllllllIllllIlIlIlIlIlll = 128;
        for (int lllllllllllllllIllllIlIlIlIlIllI = 0; lllllllllllllllIllllIlIlIlIlIllI < lllllllllllllllIllllIlIlIlIlIlll; ++lllllllllllllllIllllIlIlIlIlIllI) {
            final double lllllllllllllllIllllIlIlIlIlIlIl = lllllllllllllllIllllIlIlIlIlIllI / (lllllllllllllllIllllIlIlIlIlIlll - 1.0);
            final float lllllllllllllllIllllIlIlIlIlIlII = (this.rand.nextFloat() - 0.5f) * 0.2f;
            final float lllllllllllllllIllllIlIlIlIlIIll = (this.rand.nextFloat() - 0.5f) * 0.2f;
            final float lllllllllllllllIllllIlIlIlIlIIlI = (this.rand.nextFloat() - 0.5f) * 0.2f;
            final double lllllllllllllllIllllIlIlIlIlIIIl = lllllllllllllllIllllIlIlIlIlllll + (this.posX - lllllllllllllllIllllIlIlIlIlllll) * lllllllllllllllIllllIlIlIlIlIlIl + (this.rand.nextDouble() - 0.5) * this.width * 2.0;
            final double lllllllllllllllIllllIlIlIlIlIIII = lllllllllllllllIllllIlIlIlIllllI + (this.posY - lllllllllllllllIllllIlIlIlIllllI) * lllllllllllllllIllllIlIlIlIlIlIl + this.rand.nextDouble() * this.height;
            final double lllllllllllllllIllllIlIlIlIIllll = lllllllllllllllIllllIlIlIlIlllIl + (this.posZ - lllllllllllllllIllllIlIlIlIlllIl) * lllllllllllllllIllllIlIlIlIlIlIl + (this.rand.nextDouble() - 0.5) * this.width * 2.0;
            this.worldObj.spawnParticle(EnumParticleTypes.PORTAL, lllllllllllllllIllllIlIlIlIlIIIl, lllllllllllllllIllllIlIlIlIlIIII, lllllllllllllllIllllIlIlIlIIllll, lllllllllllllllIllllIlIlIlIlIlII, lllllllllllllllIllllIlIlIlIlIIll, lllllllllllllllIllllIlIlIlIlIIlI, new int[0]);
        }
        this.worldObj.playSoundEffect(lllllllllllllllIllllIlIlIlIlllll, lllllllllllllllIllllIlIlIlIllllI, lllllllllllllllIllllIlIlIlIlllIl, "mob.endermen.portal", 1.0f, 1.0f);
        this.playSound("mob.endermen.portal", 1.0f, 1.0f);
        return true;
    }
    
    @Override
    protected String getHurtSound() {
        return "mob.endermen.hit";
    }
    
    private boolean shouldAttackPlayer(final EntityPlayer lllllllllllllllIllllIlIllIllIIII) {
        final ItemStack lllllllllllllllIllllIlIllIlIllll = lllllllllllllllIllllIlIllIllIIII.inventory.armorInventory[3];
        if (lllllllllllllllIllllIlIllIlIllll != null && lllllllllllllllIllllIlIllIlIllll.getItem() == Item.getItemFromBlock(Blocks.pumpkin)) {
            return false;
        }
        final Vec3 lllllllllllllllIllllIlIllIlIlllI = lllllllllllllllIllllIlIllIllIIII.getLook(1.0f).normalize();
        Vec3 lllllllllllllllIllllIlIllIlIllIl = new Vec3(this.posX - lllllllllllllllIllllIlIllIllIIII.posX, this.getEntityBoundingBox().minY + this.height / 2.0f - (lllllllllllllllIllllIlIllIllIIII.posY + lllllllllllllllIllllIlIllIllIIII.getEyeHeight()), this.posZ - lllllllllllllllIllllIlIllIllIIII.posZ);
        final double lllllllllllllllIllllIlIllIlIllII = lllllllllllllllIllllIlIllIlIllIl.lengthVector();
        lllllllllllllllIllllIlIllIlIllIl = lllllllllllllllIllllIlIllIlIllIl.normalize();
        final double lllllllllllllllIllllIlIllIlIlIll = lllllllllllllllIllllIlIllIlIlllI.dotProduct(lllllllllllllllIllllIlIllIlIllIl);
        return lllllllllllllllIllllIlIllIlIlIll > 1.0 - 0.025 / lllllllllllllllIllllIlIllIlIllII && lllllllllllllllIllllIlIllIllIIII.canEntityBeSeen(this);
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, new Short((short)0));
        this.dataWatcher.addObject(17, new Byte((byte)0));
        this.dataWatcher.addObject(18, new Byte((byte)0));
    }
    
    public void func_175490_a(final IBlockState lllllllllllllllIllllIlIlIIlIIIIl) {
        this.dataWatcher.updateObject(16, (short)(Block.getStateId(lllllllllllllllIllllIlIlIIlIIIIl) & 0xFFFF));
    }
    
    public void setScreaming(final boolean lllllllllllllllIllllIlIlIIIIlIII) {
        this.dataWatcher.updateObject(18, (byte)(byte)(lllllllllllllllIllllIlIlIIIIlIII ? 1 : 0));
    }
    
    @Override
    protected String getLivingSound() {
        return this.isScreaming() ? "mob.endermen.scream" : "mob.endermen.idle";
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30000001192092896);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(7.0);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(64.0);
    }
    
    @Override
    public float getEyeHeight() {
        return 2.55f;
    }
    
    @Override
    public void onLivingUpdate() {
        if (this.worldObj.isRemote) {
            for (int lllllllllllllllIllllIlIllIIlllll = 0; lllllllllllllllIllllIlIllIIlllll < 2; ++lllllllllllllllIllllIlIllIIlllll) {
                this.worldObj.spawnParticle(EnumParticleTypes.PORTAL, this.posX + (this.rand.nextDouble() - 0.5) * this.width, this.posY + this.rand.nextDouble() * this.height - 0.25, this.posZ + (this.rand.nextDouble() - 0.5) * this.width, (this.rand.nextDouble() - 0.5) * 2.0, -this.rand.nextDouble(), (this.rand.nextDouble() - 0.5) * 2.0, new int[0]);
            }
        }
        this.isJumping = false;
        super.onLivingUpdate();
    }
    
    static {
        __OBFID = "CL_00001685";
        attackingSpeedBoostModifierUUID = UUID.fromString("020E0DFB-87AE-4653-9556-831010E291A0");
        attackingSpeedBoostModifier = new AttributeModifier(EntityEnderman.attackingSpeedBoostModifierUUID, "Attacking speed boost", 0.15000000596046448, 0).setSaved(false);
        (carriableBlocks = Sets.newIdentityHashSet()).add(Blocks.grass);
        EntityEnderman.carriableBlocks.add(Blocks.dirt);
        EntityEnderman.carriableBlocks.add(Blocks.sand);
        EntityEnderman.carriableBlocks.add(Blocks.gravel);
        EntityEnderman.carriableBlocks.add(Blocks.yellow_flower);
        EntityEnderman.carriableBlocks.add(Blocks.red_flower);
        EntityEnderman.carriableBlocks.add(Blocks.brown_mushroom);
        EntityEnderman.carriableBlocks.add(Blocks.red_mushroom);
        EntityEnderman.carriableBlocks.add(Blocks.tnt);
        EntityEnderman.carriableBlocks.add(Blocks.cactus);
        EntityEnderman.carriableBlocks.add(Blocks.clay);
        EntityEnderman.carriableBlocks.add(Blocks.pumpkin);
        EntityEnderman.carriableBlocks.add(Blocks.melon_block);
        EntityEnderman.carriableBlocks.add(Blocks.mycelium);
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllllIllllIlIllIlllIlI) {
        super.readEntityFromNBT(lllllllllllllllIllllIlIllIlllIlI);
        IBlockState lllllllllllllllIllllIlIllIllllII = null;
        if (lllllllllllllllIllllIlIllIlllIlI.hasKey("carried", 8)) {
            final IBlockState lllllllllllllllIllllIlIllIllllIl = Block.getBlockFromName(lllllllllllllllIllllIlIllIlllIlI.getString("carried")).getStateFromMeta(lllllllllllllllIllllIlIllIlllIlI.getShort("carriedData") & 0xFFFF);
        }
        else {
            lllllllllllllllIllllIlIllIllllII = Block.getBlockById(lllllllllllllllIllllIlIllIlllIlI.getShort("carried")).getStateFromMeta(lllllllllllllllIllllIlIllIlllIlI.getShort("carriedData") & 0xFFFF);
        }
        this.func_175490_a(lllllllllllllllIllllIlIllIllllII);
    }
    
    public boolean isScreaming() {
        return this.dataWatcher.getWatchableObjectByte(18) > 0;
    }
    
    @Override
    protected Item getDropItem() {
        return Items.ender_pearl;
    }
    
    @Override
    protected void dropFewItems(final boolean lllllllllllllllIllllIlIlIIllIIII, final int lllllllllllllllIllllIlIlIIlIllll) {
        final Item lllllllllllllllIllllIlIlIIlIlllI = this.getDropItem();
        if (lllllllllllllllIllllIlIlIIlIlllI != null) {
            for (int lllllllllllllllIllllIlIlIIlIllIl = this.rand.nextInt(2 + lllllllllllllllIllllIlIlIIlIllll), lllllllllllllllIllllIlIlIIlIllII = 0; lllllllllllllllIllllIlIlIIlIllII < lllllllllllllllIllllIlIlIIlIllIl; ++lllllllllllllllIllllIlIlIIlIllII) {
                this.dropItem(lllllllllllllllIllllIlIlIIlIlllI, 1);
            }
        }
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource lllllllllllllllIllllIlIlIIIlIIll, final float lllllllllllllllIllllIlIlIIIlIIlI) {
        if (this.func_180431_b(lllllllllllllllIllllIlIlIIIlIIll)) {
            return false;
        }
        if (lllllllllllllllIllllIlIlIIIlIIll.getEntity() == null || !(lllllllllllllllIllllIlIlIIIlIIll.getEntity() instanceof EntityEndermite)) {
            if (!this.worldObj.isRemote) {
                this.setScreaming(true);
            }
            if (lllllllllllllllIllllIlIlIIIlIIll instanceof EntityDamageSource && lllllllllllllllIllllIlIlIIIlIIll.getEntity() instanceof EntityPlayer) {
                if (lllllllllllllllIllllIlIlIIIlIIll.getEntity() instanceof EntityPlayerMP && ((EntityPlayerMP)lllllllllllllllIllllIlIlIIIlIIll.getEntity()).theItemInWorldManager.isCreative()) {
                    this.setScreaming(false);
                }
                else {
                    this.isAggressive = true;
                }
            }
            if (lllllllllllllllIllllIlIlIIIlIIll instanceof EntityDamageSourceIndirect) {
                this.isAggressive = false;
                for (int lllllllllllllllIllllIlIlIIIlIllI = 0; lllllllllllllllIllllIlIlIIIlIllI < 64; ++lllllllllllllllIllllIlIlIIIlIllI) {
                    if (this.teleportRandomly()) {
                        return true;
                    }
                }
                return false;
            }
        }
        final boolean lllllllllllllllIllllIlIlIIIlIlIl = super.attackEntityFrom(lllllllllllllllIllllIlIlIIIlIIll, lllllllllllllllIllllIlIlIIIlIIlI);
        if (lllllllllllllllIllllIlIlIIIlIIll.isUnblockable() && this.rand.nextInt(10) != 0) {
            this.teleportRandomly();
        }
        return lllllllllllllllIllllIlIlIIIlIlIl;
    }
    
    public EntityEnderman(final World lllllllllllllllIllllIlIlllIlIlII) {
        super(lllllllllllllllIllllIlIlllIlIlII);
        this.setSize(0.6f, 2.9f);
        this.stepHeight = 1.0f;
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, 1.0, false));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.tasks.addTask(10, new AIPlaceBlock());
        this.tasks.addTask(11, new AITakeBlock());
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
        this.targetTasks.addTask(2, new AIFindPlayer());
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityEndermite.class, 10, true, false, (Predicate)new Predicate() {
            static {
                __OBFID = "CL_00002223";
            }
            
            public boolean apply(final Object llllllllllllllllIlIIIIIIIIIlIlll) {
                return this.func_179948_a((EntityEndermite)llllllllllllllllIlIIIIIIIIIlIlll);
            }
            
            public boolean func_179948_a(final EntityEndermite llllllllllllllllIlIIIIIIIIIllIll) {
                return llllllllllllllllIlIIIIIIIIIllIll.isSpawnedByPlayer();
            }
        }));
    }
    
    static /* synthetic */ void access$2(final EntityEnderman lllllllllllllllIllllIlIlIIIIIIIl, final boolean lllllllllllllllIllllIlIlIIIIIIII) {
        lllllllllllllllIllllIlIlIIIIIIIl.isAggressive = lllllllllllllllIllllIlIlIIIIIIII;
    }
    
    @Override
    protected void updateAITasks() {
        if (this.isWet()) {
            this.attackEntityFrom(DamageSource.drown, 1.0f);
        }
        if (this.isScreaming() && !this.isAggressive && this.rand.nextInt(100) == 0) {
            this.setScreaming(false);
        }
        if (this.worldObj.isDaytime()) {
            final float lllllllllllllllIllllIlIllIIllIIl = this.getBrightness(1.0f);
            if (lllllllllllllllIllllIlIllIIllIIl > 0.5f && this.worldObj.isAgainstSky(new BlockPos(this)) && this.rand.nextFloat() * 30.0f < (lllllllllllllllIllllIlIllIIllIIl - 0.4f) * 2.0f) {
                this.setAttackTarget(null);
                this.setScreaming(false);
                this.isAggressive = false;
                this.teleportRandomly();
            }
        }
        super.updateAITasks();
    }
    
    protected boolean teleportToEntity(final Entity lllllllllllllllIllllIlIlIllllIll) {
        Vec3 lllllllllllllllIllllIlIllIIIIIIl = new Vec3(this.posX - lllllllllllllllIllllIlIlIllllIll.posX, this.getEntityBoundingBox().minY + this.height / 2.0f - lllllllllllllllIllllIlIlIllllIll.posY + lllllllllllllllIllllIlIlIllllIll.getEyeHeight(), this.posZ - lllllllllllllllIllllIlIlIllllIll.posZ);
        lllllllllllllllIllllIlIllIIIIIIl = lllllllllllllllIllllIlIllIIIIIIl.normalize();
        final double lllllllllllllllIllllIlIllIIIIIII = 16.0;
        final double lllllllllllllllIllllIlIlIlllllll = this.posX + (this.rand.nextDouble() - 0.5) * 8.0 - lllllllllllllllIllllIlIllIIIIIIl.xCoord * lllllllllllllllIllllIlIllIIIIIII;
        final double lllllllllllllllIllllIlIlIllllllI = this.posY + (this.rand.nextInt(16) - 8) - lllllllllllllllIllllIlIllIIIIIIl.yCoord * lllllllllllllllIllllIlIllIIIIIII;
        final double lllllllllllllllIllllIlIlIlllllIl = this.posZ + (this.rand.nextDouble() - 0.5) * 8.0 - lllllllllllllllIllllIlIllIIIIIIl.zCoord * lllllllllllllllIllllIlIllIIIIIII;
        return this.teleportTo(lllllllllllllllIllllIlIlIlllllll, lllllllllllllllIllllIlIlIllllllI, lllllllllllllllIllllIlIlIlllllIl);
    }
    
    protected boolean teleportRandomly() {
        final double lllllllllllllllIllllIlIllIIlIIIl = this.posX + (this.rand.nextDouble() - 0.5) * 64.0;
        final double lllllllllllllllIllllIlIllIIlIIII = this.posY + (this.rand.nextInt(64) - 32);
        final double lllllllllllllllIllllIlIllIIIllll = this.posZ + (this.rand.nextDouble() - 0.5) * 64.0;
        return this.teleportTo(lllllllllllllllIllllIlIllIIlIIIl, lllllllllllllllIllllIlIllIIlIIII, lllllllllllllllIllllIlIllIIIllll);
    }
    
    public IBlockState func_175489_ck() {
        return Block.getStateById(this.dataWatcher.getWatchableObjectShort(16) & 0xFFFF);
    }
    
    class AIPlaceBlock extends EntityAIBase
    {
        private boolean func_179474_a(final World llllllllllllllIlllIlllIIIIIlIlII, final BlockPos llllllllllllllIlllIlllIIIIIlIIll, final Block llllllllllllllIlllIlllIIIIIIllIl, final Block llllllllllllllIlllIlllIIIIIlIIIl, final Block llllllllllllllIlllIlllIIIIIlIIII) {
            return llllllllllllllIlllIlllIIIIIIllIl.canPlaceBlockAt(llllllllllllllIlllIlllIIIIIlIlII, llllllllllllllIlllIlllIIIIIlIIll) && llllllllllllllIlllIlllIIIIIlIIIl.getMaterial() == Material.air && llllllllllllllIlllIlllIIIIIlIIII.getMaterial() != Material.air && llllllllllllllIlllIlllIIIIIlIIII.isFullCube();
        }
        
        static {
            __OBFID = "CL_00002222";
        }
        
        @Override
        public void updateTask() {
            final Random llllllllllllllIlllIlllIIIIlIlIll = EntityEnderman.this.getRNG();
            final World llllllllllllllIlllIlllIIIIlIlIlI = EntityEnderman.this.worldObj;
            final int llllllllllllllIlllIlllIIIIlIlIIl = MathHelper.floor_double(EntityEnderman.this.posX - 1.0 + llllllllllllllIlllIlllIIIIlIlIll.nextDouble() * 2.0);
            final int llllllllllllllIlllIlllIIIIlIlIII = MathHelper.floor_double(EntityEnderman.this.posY + llllllllllllllIlllIlllIIIIlIlIll.nextDouble() * 2.0);
            final int llllllllllllllIlllIlllIIIIlIIlll = MathHelper.floor_double(EntityEnderman.this.posZ - 1.0 + llllllllllllllIlllIlllIIIIlIlIll.nextDouble() * 2.0);
            final BlockPos llllllllllllllIlllIlllIIIIlIIllI = new BlockPos(llllllllllllllIlllIlllIIIIlIlIIl, llllllllllllllIlllIlllIIIIlIlIII, llllllllllllllIlllIlllIIIIlIIlll);
            final Block llllllllllllllIlllIlllIIIIlIIlIl = llllllllllllllIlllIlllIIIIlIlIlI.getBlockState(llllllllllllllIlllIlllIIIIlIIllI).getBlock();
            final Block llllllllllllllIlllIlllIIIIlIIlII = llllllllllllllIlllIlllIIIIlIlIlI.getBlockState(llllllllllllllIlllIlllIIIIlIIllI.offsetDown()).getBlock();
            if (this.func_179474_a(llllllllllllllIlllIlllIIIIlIlIlI, llllllllllllllIlllIlllIIIIlIIllI, EntityEnderman.this.func_175489_ck().getBlock(), llllllllllllllIlllIlllIIIIlIIlIl, llllllllllllllIlllIlllIIIIlIIlII)) {
                llllllllllllllIlllIlllIIIIlIlIlI.setBlockState(llllllllllllllIlllIlllIIIIlIIllI, EntityEnderman.this.func_175489_ck(), 3);
                EntityEnderman.this.func_175490_a(Blocks.air.getDefaultState());
            }
        }
        
        @Override
        public boolean shouldExecute() {
            return EntityEnderman.this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing") && EntityEnderman.this.func_175489_ck().getBlock().getMaterial() != Material.air && EntityEnderman.this.getRNG().nextInt(2000) == 0;
        }
    }
    
    class AITakeBlock extends EntityAIBase
    {
        @Override
        public void updateTask() {
            final Random lllllllllllllllIIlIIIIIlIlIlllll = EntityEnderman.this.getRNG();
            final World lllllllllllllllIIlIIIIIlIlIllllI = EntityEnderman.this.worldObj;
            final int lllllllllllllllIIlIIIIIlIlIlllIl = MathHelper.floor_double(EntityEnderman.this.posX - 2.0 + lllllllllllllllIIlIIIIIlIlIlllll.nextDouble() * 4.0);
            final int lllllllllllllllIIlIIIIIlIlIlllII = MathHelper.floor_double(EntityEnderman.this.posY + lllllllllllllllIIlIIIIIlIlIlllll.nextDouble() * 3.0);
            final int lllllllllllllllIIlIIIIIlIlIllIll = MathHelper.floor_double(EntityEnderman.this.posZ - 2.0 + lllllllllllllllIIlIIIIIlIlIlllll.nextDouble() * 4.0);
            final BlockPos lllllllllllllllIIlIIIIIlIlIllIlI = new BlockPos(lllllllllllllllIIlIIIIIlIlIlllIl, lllllllllllllllIIlIIIIIlIlIlllII, lllllllllllllllIIlIIIIIlIlIllIll);
            final IBlockState lllllllllllllllIIlIIIIIlIlIllIIl = lllllllllllllllIIlIIIIIlIlIllllI.getBlockState(lllllllllllllllIIlIIIIIlIlIllIlI);
            final Block lllllllllllllllIIlIIIIIlIlIllIII = lllllllllllllllIIlIIIIIlIlIllIIl.getBlock();
            if (EntityEnderman.carriableBlocks.contains(lllllllllllllllIIlIIIIIlIlIllIII)) {
                EntityEnderman.this.func_175490_a(lllllllllllllllIIlIIIIIlIlIllIIl);
                lllllllllllllllIIlIIIIIlIlIllllI.setBlockState(lllllllllllllllIIlIIIIIlIlIllIlI, Blocks.air.getDefaultState());
            }
        }
        
        static {
            __OBFID = "CL_00002220";
        }
        
        @Override
        public boolean shouldExecute() {
            return EntityEnderman.this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing") && EntityEnderman.this.func_175489_ck().getBlock().getMaterial() == Material.air && EntityEnderman.this.getRNG().nextInt(20) == 0;
        }
    }
    
    class AIFindPlayer extends EntityAINearestAttackableTarget
    {
        private /* synthetic */ int field_179451_i;
        private /* synthetic */ int field_179450_h;
        private /* synthetic */ EntityPlayer field_179448_g;
        
        @Override
        public void resetTask() {
            this.field_179448_g = null;
            EntityEnderman.this.setScreaming(false);
            final IAttributeInstance lllllllllllllIlllllllIllIlllllII = EntityEnderman.this.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
            lllllllllllllIlllllllIllIlllllII.removeModifier(EntityEnderman.attackingSpeedBoostModifier);
            super.resetTask();
        }
        
        @Override
        public void startExecuting() {
            this.field_179450_h = 5;
            this.field_179451_i = 0;
        }
        
        public AIFindPlayer() {
            super(EntityEnderman.this, EntityPlayer.class, true);
        }
        
        @Override
        public boolean continueExecuting() {
            if (this.field_179448_g == null) {
                return super.continueExecuting();
            }
            if (!EntityEnderman.this.shouldAttackPlayer(this.field_179448_g)) {
                return false;
            }
            EntityEnderman.access$2(EntityEnderman.this, true);
            EntityEnderman.this.faceEntity(this.field_179448_g, 10.0f, 10.0f);
            return true;
        }
        
        @Override
        public void updateTask() {
            if (this.field_179448_g != null) {
                if (--this.field_179450_h <= 0) {
                    this.targetEntity = this.field_179448_g;
                    this.field_179448_g = null;
                    super.startExecuting();
                    EntityEnderman.this.playSound("mob.endermen.stare", 1.0f, 1.0f);
                    EntityEnderman.this.setScreaming(true);
                    final IAttributeInstance lllllllllllllIlllllllIllIlllIIll = EntityEnderman.this.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
                    lllllllllllllIlllllllIllIlllIIll.applyModifier(EntityEnderman.attackingSpeedBoostModifier);
                }
            }
            else {
                if (this.targetEntity != null) {
                    if (this.targetEntity instanceof EntityPlayer && EntityEnderman.this.shouldAttackPlayer((EntityPlayer)this.targetEntity)) {
                        if (this.targetEntity.getDistanceSqToEntity(EntityEnderman.this) < 16.0) {
                            EntityEnderman.this.teleportRandomly();
                        }
                        this.field_179451_i = 0;
                    }
                    else if (this.targetEntity.getDistanceSqToEntity(EntityEnderman.this) > 256.0 && this.field_179451_i++ >= 30 && EntityEnderman.this.teleportToEntity(this.targetEntity)) {
                        this.field_179451_i = 0;
                    }
                }
                super.updateTask();
            }
        }
        
        static {
            __OBFID = "CL_00002221";
        }
        
        @Override
        public boolean shouldExecute() {
            final double lllllllllllllIlllllllIlllIIIIlll = this.getTargetDistance();
            final List lllllllllllllIlllllllIlllIIIIllI = this.taskOwner.worldObj.func_175647_a(EntityPlayer.class, this.taskOwner.getEntityBoundingBox().expand(lllllllllllllIlllllllIlllIIIIlll, 4.0, lllllllllllllIlllllllIlllIIIIlll), this.targetEntitySelector);
            Collections.sort((List<Object>)lllllllllllllIlllllllIlllIIIIllI, this.theNearestAttackableTargetSorter);
            if (lllllllllllllIlllllllIlllIIIIllI.isEmpty()) {
                return false;
            }
            this.field_179448_g = lllllllllllllIlllllllIlllIIIIllI.get(0);
            return true;
        }
    }
}
