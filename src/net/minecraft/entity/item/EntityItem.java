package net.minecraft.entity.item;

import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.world.*;
import org.apache.logging.log4j.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.stats.*;
import net.minecraft.init.*;
import net.minecraft.nbt.*;
import net.minecraft.block.material.*;
import net.minecraft.util.*;

public class EntityItem extends Entity
{
    public /* synthetic */ float hoverStart;
    private /* synthetic */ String owner;
    private /* synthetic */ int delayBeforeCanPickup;
    private /* synthetic */ int age;
    private static final /* synthetic */ Logger logger;
    private /* synthetic */ int health;
    private /* synthetic */ String thrower;
    
    public void func_174873_u() {
        this.age = -6000;
    }
    
    public void readEntityFromNBT(final NBTTagCompound llllllllllllllllIIlIlIIIIlIIIlll) {
        this.health = (llllllllllllllllIIlIlIIIIlIIIlll.getShort("Health") & 0xFF);
        this.age = llllllllllllllllIIlIlIIIIlIIIlll.getShort("Age");
        if (llllllllllllllllIIlIlIIIIlIIIlll.hasKey("PickupDelay")) {
            this.delayBeforeCanPickup = llllllllllllllllIIlIlIIIIlIIIlll.getShort("PickupDelay");
        }
        if (llllllllllllllllIIlIlIIIIlIIIlll.hasKey("Owner")) {
            this.owner = llllllllllllllllIIlIlIIIIlIIIlll.getString("Owner");
        }
        if (llllllllllllllllIIlIlIIIIlIIIlll.hasKey("Thrower")) {
            this.thrower = llllllllllllllllIIlIlIIIIlIIIlll.getString("Thrower");
        }
        final NBTTagCompound llllllllllllllllIIlIlIIIIlIIIllI = llllllllllllllllIIlIlIIIIlIIIlll.getCompoundTag("Item");
        this.setEntityItemStack(ItemStack.loadItemStackFromNBT(llllllllllllllllIIlIlIIIIlIIIllI));
        if (this.getEntityItem() == null) {
            this.setDead();
        }
    }
    
    @Override
    public void travelToDimension(final int llllllllllllllllIIlIlIIIIIlIlIlI) {
        super.travelToDimension(llllllllllllllllIIlIlIIIIIlIlIlI);
        if (!this.worldObj.isRemote) {
            this.searchForOtherItemsNearby();
        }
    }
    
    public ItemStack getEntityItem() {
        final ItemStack llllllllllllllllIIlIlIIIIIlIIllI = this.getDataWatcher().getWatchableObjectItemStack(10);
        if (llllllllllllllllIIlIlIIIIIlIIllI == null) {
            if (this.worldObj != null) {
                EntityItem.logger.error(String.valueOf(new StringBuilder("Item entity ").append(this.getEntityId()).append(" has no item?!")));
            }
            return new ItemStack(Blocks.stone);
        }
        return llllllllllllllllIIlIlIIIIIlIIllI;
    }
    
    @Override
    protected void entityInit() {
        this.getDataWatcher().addObjectByDataType(10, 5);
    }
    
    public void setPickupDelay(final int llllllllllllllllIIlIIllllllllIlI) {
        this.delayBeforeCanPickup = llllllllllllllllIIlIIllllllllIlI;
    }
    
    private void searchForOtherItemsNearby() {
        for (final EntityItem llllllllllllllllIIlIlIIIIlllIllI : this.worldObj.getEntitiesWithinAABB(EntityItem.class, this.getEntityBoundingBox().expand(0.5, 0.0, 0.5))) {
            this.combineItems(llllllllllllllllIIlIlIIIIlllIllI);
        }
    }
    
    public void setAgeToCreativeDespawnTime() {
        this.age = 4800;
    }
    
    public void setThrower(final String llllllllllllllllIIlIlIIIIIIIlllI) {
        this.thrower = llllllllllllllllIIlIlIIIIIIIlllI;
    }
    
    public EntityItem(final World llllllllllllllllIIlIlIIIlIlIIlII, final double llllllllllllllllIIlIlIIIlIlIIIll, final double llllllllllllllllIIlIlIIIlIlIIIlI, final double llllllllllllllllIIlIlIIIlIlIIllI) {
        super(llllllllllllllllIIlIlIIIlIlIIlII);
        this.health = 5;
        this.hoverStart = (float)(Math.random() * 3.141592653589793 * 2.0);
        this.setSize(0.25f, 0.25f);
        this.setPosition(llllllllllllllllIIlIlIIIlIlIIIll, llllllllllllllllIIlIlIIIlIlIIIlI, llllllllllllllllIIlIlIIIlIlIIllI);
        this.rotationYaw = (float)(Math.random() * 360.0);
        this.motionX = (float)(Math.random() * 0.20000000298023224 - 0.10000000149011612);
        this.motionY = 0.20000000298023224;
        this.motionZ = (float)(Math.random() * 0.20000000298023224 - 0.10000000149011612);
    }
    
    static {
        __OBFID = "CL_00001669";
        logger = LogManager.getLogger();
    }
    
    public EntityItem(final World llllllllllllllllIIlIlIIIlIIlIIll, final double llllllllllllllllIIlIlIIIlIIllIII, final double llllllllllllllllIIlIlIIIlIIlIlll, final double llllllllllllllllIIlIlIIIlIIlIllI, final ItemStack llllllllllllllllIIlIlIIIlIIlIlIl) {
        this(llllllllllllllllIIlIlIIIlIIlIIll, llllllllllllllllIIlIlIIIlIIllIII, llllllllllllllllIIlIlIIIlIIlIlll, llllllllllllllllIIlIlIIIlIIlIllI);
        this.setEntityItemStack(llllllllllllllllIIlIlIIIlIIlIlIl);
    }
    
    @Override
    public boolean canAttackWithItem() {
        return false;
    }
    
    public String getThrower() {
        return this.thrower;
    }
    
    @Override
    public void onCollideWithPlayer(final EntityPlayer llllllllllllllllIIlIlIIIIIllIlll) {
        if (!this.worldObj.isRemote) {
            final ItemStack llllllllllllllllIIlIlIIIIIlllIll = this.getEntityItem();
            final int llllllllllllllllIIlIlIIIIIlllIlI = llllllllllllllllIIlIlIIIIIlllIll.stackSize;
            if (this.delayBeforeCanPickup == 0 && (this.owner == null || 6000 - this.age <= 200 || this.owner.equals(llllllllllllllllIIlIlIIIIIllIlll.getName())) && llllllllllllllllIIlIlIIIIIllIlll.inventory.addItemStackToInventory(llllllllllllllllIIlIlIIIIIlllIll)) {
                if (llllllllllllllllIIlIlIIIIIlllIll.getItem() == Item.getItemFromBlock(Blocks.log)) {
                    llllllllllllllllIIlIlIIIIIllIlll.triggerAchievement(AchievementList.mineWood);
                }
                if (llllllllllllllllIIlIlIIIIIlllIll.getItem() == Item.getItemFromBlock(Blocks.log2)) {
                    llllllllllllllllIIlIlIIIIIllIlll.triggerAchievement(AchievementList.mineWood);
                }
                if (llllllllllllllllIIlIlIIIIIlllIll.getItem() == Items.leather) {
                    llllllllllllllllIIlIlIIIIIllIlll.triggerAchievement(AchievementList.killCow);
                }
                if (llllllllllllllllIIlIlIIIIIlllIll.getItem() == Items.diamond) {
                    llllllllllllllllIIlIlIIIIIllIlll.triggerAchievement(AchievementList.diamonds);
                }
                if (llllllllllllllllIIlIlIIIIIlllIll.getItem() == Items.blaze_rod) {
                    llllllllllllllllIIlIlIIIIIllIlll.triggerAchievement(AchievementList.blazeRod);
                }
                if (llllllllllllllllIIlIlIIIIIlllIll.getItem() == Items.diamond && this.getThrower() != null) {
                    final EntityPlayer llllllllllllllllIIlIlIIIIIlllIIl = this.worldObj.getPlayerEntityByName(this.getThrower());
                    if (llllllllllllllllIIlIlIIIIIlllIIl != null && llllllllllllllllIIlIlIIIIIlllIIl != llllllllllllllllIIlIlIIIIIllIlll) {
                        llllllllllllllllIIlIlIIIIIlllIIl.triggerAchievement(AchievementList.diamondsToYou);
                    }
                }
                if (!this.isSlient()) {
                    this.worldObj.playSoundAtEntity(llllllllllllllllIIlIlIIIIIllIlll, "random.pop", 0.2f, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7f + 1.0f) * 2.0f);
                }
                llllllllllllllllIIlIlIIIIIllIlll.onItemPickup(this, llllllllllllllllIIlIlIIIIIlllIlI);
                if (llllllllllllllllIIlIlIIIIIlllIll.stackSize <= 0) {
                    this.setDead();
                }
            }
        }
    }
    
    public void writeEntityToNBT(final NBTTagCompound llllllllllllllllIIlIlIIIIlIIllII) {
        llllllllllllllllIIlIlIIIIlIIllII.setShort("Health", (byte)this.health);
        llllllllllllllllIIlIlIIIIlIIllII.setShort("Age", (short)this.age);
        llllllllllllllllIIlIlIIIIlIIllII.setShort("PickupDelay", (short)this.delayBeforeCanPickup);
        if (this.getThrower() != null) {
            llllllllllllllllIIlIlIIIIlIIllII.setString("Thrower", this.thrower);
        }
        if (this.getOwner() != null) {
            llllllllllllllllIIlIlIIIIlIIllII.setString("Owner", this.owner);
        }
        if (this.getEntityItem() != null) {
            llllllllllllllllIIlIlIIIIlIIllII.setTag("Item", this.getEntityItem().writeToNBT(new NBTTagCompound()));
        }
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource llllllllllllllllIIlIlIIIIlIlIllI, final float llllllllllllllllIIlIlIIIIlIlIlIl) {
        if (this.func_180431_b(llllllllllllllllIIlIlIIIIlIlIllI)) {
            return false;
        }
        if (this.getEntityItem() != null && this.getEntityItem().getItem() == Items.nether_star && llllllllllllllllIIlIlIIIIlIlIllI.isExplosion()) {
            return false;
        }
        this.setBeenAttacked();
        this.health -= (int)llllllllllllllllIIlIlIIIIlIlIlIl;
        if (this.health <= 0) {
            this.setDead();
        }
        return false;
    }
    
    @Override
    public boolean handleWaterMovement() {
        if (this.worldObj.handleMaterialAcceleration(this.getEntityBoundingBox(), Material.water, this)) {
            if (!this.inWater && !this.firstUpdate) {
                this.resetHeight();
            }
            this.inWater = true;
        }
        else {
            this.inWater = false;
        }
        return this.inWater;
    }
    
    public void func_174870_v() {
        this.setInfinitePickupDelay();
        this.age = 5999;
    }
    
    public String getOwner() {
        return this.owner;
    }
    
    public int func_174872_o() {
        return this.age;
    }
    
    @Override
    public void onUpdate() {
        if (this.getEntityItem() == null) {
            this.setDead();
        }
        else {
            super.onUpdate();
            if (this.delayBeforeCanPickup > 0 && this.delayBeforeCanPickup != 32767) {
                --this.delayBeforeCanPickup;
            }
            this.prevPosX = this.posX;
            this.prevPosY = this.posY;
            this.prevPosZ = this.posZ;
            this.motionY -= 0.03999999910593033;
            this.noClip = this.pushOutOfBlocks(this.posX, (this.getEntityBoundingBox().minY + this.getEntityBoundingBox().maxY) / 2.0, this.posZ);
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            final boolean llllllllllllllllIIlIlIIIlIIIIIII = (int)this.prevPosX != (int)this.posX || (int)this.prevPosY != (int)this.posY || (int)this.prevPosZ != (int)this.posZ;
            if (llllllllllllllllIIlIlIIIlIIIIIII || this.ticksExisted % 25 == 0) {
                if (this.worldObj.getBlockState(new BlockPos(this)).getBlock().getMaterial() == Material.lava) {
                    this.motionY = 0.20000000298023224;
                    this.motionX = (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f;
                    this.motionZ = (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f;
                    this.playSound("random.fizz", 0.4f, 2.0f + this.rand.nextFloat() * 0.4f);
                }
                if (!this.worldObj.isRemote) {
                    this.searchForOtherItemsNearby();
                }
            }
            float llllllllllllllllIIlIlIIIIlllllll = 0.98f;
            if (this.onGround) {
                llllllllllllllllIIlIlIIIIlllllll = this.worldObj.getBlockState(new BlockPos(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.getEntityBoundingBox().minY) - 1, MathHelper.floor_double(this.posZ))).getBlock().slipperiness * 0.98f;
            }
            this.motionX *= llllllllllllllllIIlIlIIIIlllllll;
            this.motionY *= 0.9800000190734863;
            this.motionZ *= llllllllllllllllIIlIlIIIIlllllll;
            if (this.onGround) {
                this.motionY *= -0.5;
            }
            if (this.age != -32768) {
                ++this.age;
            }
            this.handleWaterMovement();
            if (!this.worldObj.isRemote && this.age >= 6000) {
                this.setDead();
            }
        }
    }
    
    private boolean combineItems(final EntityItem llllllllllllllllIIlIlIIIIllIlIIl) {
        if (llllllllllllllllIIlIlIIIIllIlIIl == this) {
            return false;
        }
        if (!llllllllllllllllIIlIlIIIIllIlIIl.isEntityAlive() || !this.isEntityAlive()) {
            return false;
        }
        final ItemStack llllllllllllllllIIlIlIIIIllIllII = this.getEntityItem();
        final ItemStack llllllllllllllllIIlIlIIIIllIlIll = llllllllllllllllIIlIlIIIIllIlIIl.getEntityItem();
        if (this.delayBeforeCanPickup == 32767 || llllllllllllllllIIlIlIIIIllIlIIl.delayBeforeCanPickup == 32767) {
            return false;
        }
        if (this.age == -32768 || llllllllllllllllIIlIlIIIIllIlIIl.age == -32768) {
            return false;
        }
        if (llllllllllllllllIIlIlIIIIllIlIll.getItem() != llllllllllllllllIIlIlIIIIllIllII.getItem()) {
            return false;
        }
        if (llllllllllllllllIIlIlIIIIllIlIll.hasTagCompound() ^ llllllllllllllllIIlIlIIIIllIllII.hasTagCompound()) {
            return false;
        }
        if (llllllllllllllllIIlIlIIIIllIlIll.hasTagCompound() && !llllllllllllllllIIlIlIIIIllIlIll.getTagCompound().equals(llllllllllllllllIIlIlIIIIllIllII.getTagCompound())) {
            return false;
        }
        if (llllllllllllllllIIlIlIIIIllIlIll.getItem() == null) {
            return false;
        }
        if (llllllllllllllllIIlIlIIIIllIlIll.getItem().getHasSubtypes() && llllllllllllllllIIlIlIIIIllIlIll.getMetadata() != llllllllllllllllIIlIlIIIIllIllII.getMetadata()) {
            return false;
        }
        if (llllllllllllllllIIlIlIIIIllIlIll.stackSize < llllllllllllllllIIlIlIIIIllIllII.stackSize) {
            return llllllllllllllllIIlIlIIIIllIlIIl.combineItems(this);
        }
        if (llllllllllllllllIIlIlIIIIllIlIll.stackSize + llllllllllllllllIIlIlIIIIllIllII.stackSize > llllllllllllllllIIlIlIIIIllIlIll.getMaxStackSize()) {
            return false;
        }
        final ItemStack itemStack = llllllllllllllllIIlIlIIIIllIlIll;
        itemStack.stackSize += llllllllllllllllIIlIlIIIIllIllII.stackSize;
        llllllllllllllllIIlIlIIIIllIlIIl.delayBeforeCanPickup = Math.max(llllllllllllllllIIlIlIIIIllIlIIl.delayBeforeCanPickup, this.delayBeforeCanPickup);
        llllllllllllllllIIlIlIIIIllIlIIl.age = Math.min(llllllllllllllllIIlIlIIIIllIlIIl.age, this.age);
        llllllllllllllllIIlIlIIIIllIlIIl.setEntityItemStack(llllllllllllllllIIlIlIIIIllIlIll);
        this.setDead();
        return true;
    }
    
    public EntityItem(final World llllllllllllllllIIlIlIIIlIIIlIII) {
        super(llllllllllllllllIIlIlIIIlIIIlIII);
        this.health = 5;
        this.hoverStart = (float)(Math.random() * 3.141592653589793 * 2.0);
        this.setSize(0.25f, 0.25f);
        this.setEntityItemStack(new ItemStack(Blocks.air, 0));
    }
    
    public void setNoPickupDelay() {
        this.delayBeforeCanPickup = 0;
    }
    
    public void setInfinitePickupDelay() {
        this.delayBeforeCanPickup = 32767;
    }
    
    public void setDefaultPickupDelay() {
        this.delayBeforeCanPickup = 10;
    }
    
    @Override
    protected void dealFireDamage(final int llllllllllllllllIIlIlIIIIlIllIll) {
        this.attackEntityFrom(DamageSource.inFire, (float)llllllllllllllllIIlIlIIIIlIllIll);
    }
    
    @Override
    protected boolean canTriggerWalking() {
        return false;
    }
    
    public void setOwner(final String llllllllllllllllIIlIlIIIIIIlIlIl) {
        this.owner = llllllllllllllllIIlIlIIIIIIlIlIl;
    }
    
    public void setEntityItemStack(final ItemStack llllllllllllllllIIlIlIIIIIlIIIII) {
        this.getDataWatcher().updateObject(10, llllllllllllllllIIlIlIIIIIlIIIII);
        this.getDataWatcher().setObjectWatched(10);
    }
    
    @Override
    public String getName() {
        return this.hasCustomName() ? this.getCustomNameTag() : StatCollector.translateToLocal(String.valueOf(new StringBuilder("item.").append(this.getEntityItem().getUnlocalizedName())));
    }
    
    public boolean func_174874_s() {
        return this.delayBeforeCanPickup > 0;
    }
}
