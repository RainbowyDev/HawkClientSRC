package net.minecraft.entity.player;

import com.mojang.authlib.*;
import net.minecraft.block.material.*;
import net.minecraft.block.properties.*;
import net.minecraft.event.*;
import net.minecraft.block.*;
import com.google.common.base.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.entity.monster.*;
import net.minecraft.stats.*;
import net.minecraft.block.state.*;
import net.minecraft.tileentity.*;
import net.minecraft.inventory.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.passive.*;
import com.google.common.collect.*;
import net.minecraft.enchantment.*;
import net.minecraft.potion.*;
import net.minecraft.scoreboard.*;
import net.minecraft.network.play.server.*;
import net.minecraft.network.*;
import net.minecraft.entity.boss.*;
import net.minecraft.server.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.command.server.*;
import net.minecraft.entity.*;
import net.minecraft.nbt.*;

public abstract class EntityPlayer extends EntityLivingBase
{
    public /* synthetic */ float field_71089_bV;
    public /* synthetic */ BlockPos playerLocation;
    protected /* synthetic */ boolean sleeping;
    private /* synthetic */ BlockPos spawnChunk;
    private /* synthetic */ int itemInUseCount;
    private /* synthetic */ int field_82249_h;
    public /* synthetic */ float cameraYaw;
    private /* synthetic */ ItemStack itemInUse;
    protected /* synthetic */ FoodStats foodStats;
    public /* synthetic */ double field_71085_bR;
    protected /* synthetic */ int flyToggleTimer;
    private final /* synthetic */ GameProfile gameProfile;
    private /* synthetic */ boolean spawnForced;
    public /* synthetic */ Container inventoryContainer;
    private /* synthetic */ int sleepTimer;
    private /* synthetic */ BlockPos startMinecartRidingCoordinate;
    public /* synthetic */ Container openContainer;
    public /* synthetic */ float experience;
    public /* synthetic */ int experienceLevel;
    public /* synthetic */ double field_71091_bM;
    public /* synthetic */ InventoryPlayer inventory;
    private /* synthetic */ int field_175152_f;
    public /* synthetic */ float field_71079_bU;
    private /* synthetic */ boolean field_175153_bG;
    public /* synthetic */ int xpCooldown;
    public /* synthetic */ float speedInAir;
    public /* synthetic */ double field_71095_bQ;
    public /* synthetic */ double field_71094_bP;
    public /* synthetic */ float prevCameraYaw;
    public /* synthetic */ double field_71097_bO;
    private /* synthetic */ InventoryEnderChest theInventoryEnderChest;
    public /* synthetic */ int experienceTotal;
    public /* synthetic */ double field_71096_bN;
    public /* synthetic */ PlayerCapabilities capabilities;
    protected /* synthetic */ float speedOnGround;
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound llllllllllllllIllIIIllIIlIIIIIll) {
        super.readEntityFromNBT(llllllllllllllIllIIIllIIlIIIIIll);
        this.entityUniqueID = getUUID(this.gameProfile);
        final NBTTagList llllllllllllllIllIIIllIIlIIIIIlI = llllllllllllllIllIIIllIIlIIIIIll.getTagList("Inventory", 10);
        this.inventory.readFromNBT(llllllllllllllIllIIIllIIlIIIIIlI);
        this.inventory.currentItem = llllllllllllllIllIIIllIIlIIIIIll.getInteger("SelectedItemSlot");
        this.sleeping = llllllllllllllIllIIIllIIlIIIIIll.getBoolean("Sleeping");
        this.sleepTimer = llllllllllllllIllIIIllIIlIIIIIll.getShort("SleepTimer");
        this.experience = llllllllllllllIllIIIllIIlIIIIIll.getFloat("XpP");
        this.experienceLevel = llllllllllllllIllIIIllIIlIIIIIll.getInteger("XpLevel");
        this.experienceTotal = llllllllllllllIllIIIllIIlIIIIIll.getInteger("XpTotal");
        this.field_175152_f = llllllllllllllIllIIIllIIlIIIIIll.getInteger("XpSeed");
        if (this.field_175152_f == 0) {
            this.field_175152_f = this.rand.nextInt();
        }
        this.setScore(llllllllllllllIllIIIllIIlIIIIIll.getInteger("Score"));
        if (this.sleeping) {
            this.playerLocation = new BlockPos(this);
            this.wakeUpPlayer(true, true, false);
        }
        if (llllllllllllllIllIIIllIIlIIIIIll.hasKey("SpawnX", 99) && llllllllllllllIllIIIllIIlIIIIIll.hasKey("SpawnY", 99) && llllllllllllllIllIIIllIIlIIIIIll.hasKey("SpawnZ", 99)) {
            this.spawnChunk = new BlockPos(llllllllllllllIllIIIllIIlIIIIIll.getInteger("SpawnX"), llllllllllllllIllIIIllIIlIIIIIll.getInteger("SpawnY"), llllllllllllllIllIIIllIIlIIIIIll.getInteger("SpawnZ"));
            this.spawnForced = llllllllllllllIllIIIllIIlIIIIIll.getBoolean("SpawnForced");
        }
        this.foodStats.readNBT(llllllllllllllIllIIIllIIlIIIIIll);
        this.capabilities.readCapabilitiesFromNBT(llllllllllllllIllIIIllIIlIIIIIll);
        if (llllllllllllllIllIIIllIIlIIIIIll.hasKey("EnderItems", 9)) {
            final NBTTagList llllllllllllllIllIIIllIIlIIIIIIl = llllllllllllllIllIIIllIIlIIIIIll.getTagList("EnderItems", 10);
            this.theInventoryEnderChest.loadInventoryFromNBT(llllllllllllllIllIIIllIIlIIIIIIl);
        }
    }
    
    protected void joinEntityItemWithWorld(final EntityItem llllllllllllllIllIIIllIIlIlIIIIl) {
        this.worldObj.spawnEntityInWorld(llllllllllllllIllIIIllIIlIlIIIIl);
    }
    
    @Override
    public boolean isPushedByWater() {
        return !this.capabilities.isFlying;
    }
    
    public int getSleepTimer() {
        return this.sleepTimer;
    }
    
    protected void onItemUseFinish() {
        if (this.itemInUse != null) {
            this.updateItemUse(this.itemInUse, 16);
            final int llllllllllllllIllIIIllIlIlIllIII = this.itemInUse.stackSize;
            final ItemStack llllllllllllllIllIIIllIlIlIlIlll = this.itemInUse.onItemUseFinish(this.worldObj, this);
            if (llllllllllllllIllIIIllIlIlIlIlll != this.itemInUse || (llllllllllllllIllIIIllIlIlIlIlll != null && llllllllllllllIllIIIllIlIlIlIlll.stackSize != llllllllllllllIllIIIllIlIlIllIII)) {
                this.inventory.mainInventory[this.inventory.currentItem] = llllllllllllllIllIIIllIlIlIlIlll;
                if (llllllllllllllIllIIIllIlIlIlIlll.stackSize == 0) {
                    this.inventory.mainInventory[this.inventory.currentItem] = null;
                }
            }
            this.clearItemInUse();
        }
    }
    
    @Override
    public void setCurrentItemOrArmor(final int llllllllllllllIllIIIlIlIlIIIIlll, final ItemStack llllllllllllllIllIIIlIlIlIIIIllI) {
        this.inventory.armorInventory[llllllllllllllIllIIIlIlIlIIIIlll] = llllllllllllllIllIIIlIlIlIIIIllI;
    }
    
    public int xpBarCap() {
        return (this.experienceLevel >= 30) ? (112 + (this.experienceLevel - 30) * 9) : ((this.experienceLevel >= 15) ? (37 + (this.experienceLevel - 15) * 5) : (7 + this.experienceLevel * 2));
    }
    
    public void addScore(final int llllllllllllllIllIIIllIlIIIIIIIl) {
        final int llllllllllllllIllIIIllIlIIIIIIll = this.getScore();
        this.dataWatcher.updateObject(18, llllllllllllllIllIIIllIlIIIIIIll + llllllllllllllIllIIIllIlIIIIIIIl);
    }
    
    @Override
    public boolean isPlayerSleeping() {
        return this.sleeping;
    }
    
    @Override
    public int getTotalArmorValue() {
        return this.inventory.getTotalArmorValue();
    }
    
    public static BlockPos func_180467_a(final World llllllllllllllIllIIIlIlllIIlIIll, final BlockPos llllllllllllllIllIIIlIlllIIllIIl, final boolean llllllllllllllIllIIIlIlllIIlIIIl) {
        if (llllllllllllllIllIIIlIlllIIlIIll.getBlockState(llllllllllllllIllIIIlIlllIIllIIl).getBlock() == Blocks.bed) {
            return BlockBed.getSafeExitLocation(llllllllllllllIllIIIlIlllIIlIIll, llllllllllllllIllIIIlIlllIIllIIl, 0);
        }
        if (!llllllllllllllIllIIIlIlllIIlIIIl) {
            return null;
        }
        final Material llllllllllllllIllIIIlIlllIIlIlll = llllllllllllllIllIIIlIlllIIlIIll.getBlockState(llllllllllllllIllIIIlIlllIIllIIl).getBlock().getMaterial();
        final Material llllllllllllllIllIIIlIlllIIlIllI = llllllllllllllIllIIIlIlllIIlIIll.getBlockState(llllllllllllllIllIIIlIlllIIllIIl.offsetUp()).getBlock().getMaterial();
        final boolean llllllllllllllIllIIIlIlllIIlIlIl = !llllllllllllllIllIIIlIlllIIlIlll.isSolid() && !llllllllllllllIllIIIlIlllIIlIlll.isLiquid();
        final boolean llllllllllllllIllIIIlIlllIIlIlII = !llllllllllllllIllIIIlIlllIIlIllI.isSolid() && !llllllllllllllIllIIIlIlllIIlIllI.isLiquid();
        return (llllllllllllllIllIIIlIlllIIlIlIl && llllllllllllllIllIIIlIlllIIlIlII) ? llllllllllllllIllIIIlIlllIIllIIl : null;
    }
    
    public void setScore(final int llllllllllllllIllIIIllIlIIIIlIIl) {
        this.dataWatcher.updateObject(18, llllllllllllllIllIIIllIlIIIIlIIl);
    }
    
    @Override
    public float getEyeHeight() {
        float llllllllllllllIllIIIlIlIIllIIlII = 1.62f;
        if (this.isPlayerSleeping()) {
            llllllllllllllIllIIIlIlIIllIIlII = 0.2f;
        }
        if (this.isSneaking()) {
            llllllllllllllIllIIIlIlIIllIIlII -= 0.08f;
        }
        return llllllllllllllIllIIIlIlIIllIIlII;
    }
    
    public boolean isBlocking() {
        return this.isUsingItem() && this.itemInUse.getItem().getItemUseAction(this.itemInUse) == EnumAction.BLOCK;
    }
    
    @Override
    public boolean getAlwaysRenderNameTagForRender() {
        return true;
    }
    
    public void destroyCurrentEquippedItem() {
        this.inventory.setInventorySlotContents(this.inventory.currentItem, null);
    }
    
    public int getItemInUseDuration() {
        return this.isUsingItem() ? (this.itemInUse.getMaxItemUseDuration() - this.itemInUseCount) : 0;
    }
    
    public int func_175138_ci() {
        return this.field_175152_f;
    }
    
    @Override
    public ItemStack getHeldItem() {
        return this.inventory.getCurrentItem();
    }
    
    public EnumStatus func_180469_a(final BlockPos llllllllllllllIllIIIlIllllIIlIIl) {
        if (!this.worldObj.isRemote) {
            if (this.isPlayerSleeping() || !this.isEntityAlive()) {
                return EnumStatus.OTHER_PROBLEM;
            }
            if (!this.worldObj.provider.isSurfaceWorld()) {
                return EnumStatus.NOT_POSSIBLE_HERE;
            }
            if (this.worldObj.isDaytime()) {
                return EnumStatus.NOT_POSSIBLE_NOW;
            }
            if (Math.abs(this.posX - llllllllllllllIllIIIlIllllIIlIIl.getX()) > 3.0 || Math.abs(this.posY - llllllllllllllIllIIIlIllllIIlIIl.getY()) > 2.0 || Math.abs(this.posZ - llllllllllllllIllIIIlIllllIIlIIl.getZ()) > 3.0) {
                return EnumStatus.TOO_FAR_AWAY;
            }
            final double llllllllllllllIllIIIlIllllIIlIII = 8.0;
            final double llllllllllllllIllIIIlIllllIIIlll = 5.0;
            final List llllllllllllllIllIIIlIllllIIIllI = this.worldObj.getEntitiesWithinAABB(EntityMob.class, new AxisAlignedBB(llllllllllllllIllIIIlIllllIIlIIl.getX() - llllllllllllllIllIIIlIllllIIlIII, llllllllllllllIllIIIlIllllIIlIIl.getY() - llllllllllllllIllIIIlIllllIIIlll, llllllllllllllIllIIIlIllllIIlIIl.getZ() - llllllllllllllIllIIIlIllllIIlIII, llllllllllllllIllIIIlIllllIIlIIl.getX() + llllllllllllllIllIIIlIllllIIlIII, llllllllllllllIllIIIlIllllIIlIIl.getY() + llllllllllllllIllIIIlIllllIIIlll, llllllllllllllIllIIIlIllllIIlIIl.getZ() + llllllllllllllIllIIIlIllllIIlIII));
            if (!llllllllllllllIllIIIlIllllIIIllI.isEmpty()) {
                return EnumStatus.NOT_SAFE;
            }
        }
        if (this.isRiding()) {
            this.mountEntity(null);
        }
        this.setSize(0.2f, 0.2f);
        if (this.worldObj.isBlockLoaded(llllllllllllllIllIIIlIllllIIlIIl)) {
            final EnumFacing llllllllllllllIllIIIlIllllIIIlIl = (EnumFacing)this.worldObj.getBlockState(llllllllllllllIllIIIlIllllIIlIIl).getValue(BlockDirectional.AGE);
            float llllllllllllllIllIIIlIllllIIIlII = 0.5f;
            float llllllllllllllIllIIIlIllllIIIIll = 0.5f;
            switch (SwitchEnumFacing.field_179420_a[llllllllllllllIllIIIlIllllIIIlIl.ordinal()]) {
                case 1: {
                    llllllllllllllIllIIIlIllllIIIIll = 0.9f;
                    break;
                }
                case 2: {
                    llllllllllllllIllIIIlIllllIIIIll = 0.1f;
                    break;
                }
                case 3: {
                    llllllllllllllIllIIIlIllllIIIlII = 0.1f;
                    break;
                }
                case 4: {
                    llllllllllllllIllIIIlIllllIIIlII = 0.9f;
                    break;
                }
            }
            this.func_175139_a(llllllllllllllIllIIIlIllllIIIlIl);
            this.setPosition(llllllllllllllIllIIIlIllllIIlIIl.getX() + llllllllllllllIllIIIlIllllIIIlII, llllllllllllllIllIIIlIllllIIlIIl.getY() + 0.6875f, llllllllllllllIllIIIlIllllIIlIIl.getZ() + llllllllllllllIllIIIlIllllIIIIll);
        }
        else {
            this.setPosition(llllllllllllllIllIIIlIllllIIlIIl.getX() + 0.5f, llllllllllllllIllIIIlIllllIIlIIl.getY() + 0.6875f, llllllllllllllIllIIIlIllllIIlIIl.getZ() + 0.5f);
        }
        this.sleeping = true;
        this.sleepTimer = 0;
        this.playerLocation = llllllllllllllIllIIIlIllllIIlIIl;
        final double motionX = 0.0;
        this.motionY = motionX;
        this.motionZ = motionX;
        this.motionX = motionX;
        if (!this.worldObj.isRemote) {
            this.worldObj.updateAllPlayersSleepingFlag();
        }
        return EnumStatus.OK;
    }
    
    public void onCriticalHit(final Entity llllllllllllllIllIIIlIllllIllllI) {
    }
    
    @Override
    public Team getTeam() {
        return this.getWorldScoreboard().getPlayersTeam(this.getName());
    }
    
    public void displayGUIChest(final IInventory llllllllllllllIllIIIllIIIIlIlIlI) {
    }
    
    @Override
    public IChatComponent getDisplayName() {
        final ChatComponentText llllllllllllllIllIIIlIlIIllIlIlI = new ChatComponentText(ScorePlayerTeam.formatPlayerName(this.getTeam(), this.getName()));
        llllllllllllllIllIIIlIlIIllIlIlI.getChatStyle().setChatClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, String.valueOf(new StringBuilder("/msg ").append(this.getName()).append(" "))));
        llllllllllllllIllIIIlIlIIllIlIlI.getChatStyle().setChatHoverEvent(this.func_174823_aP());
        llllllllllllllIllIIIlIlIIllIlIlI.getChatStyle().setInsertion(this.getName());
        return llllllllllllllIllIIIlIlIIllIlIlI;
    }
    
    public float getArmorVisibility() {
        int llllllllllllllIllIIIllIIIlIIlIll = 0;
        for (final ItemStack llllllllllllllIllIIIllIIIlIIIlll : this.inventory.armorInventory) {
            if (llllllllllllllIllIIIllIIIlIIIlll != null) {
                ++llllllllllllllIllIIIllIIIlIIlIll;
            }
        }
        return llllllllllllllIllIIIllIIIlIIlIll / (float)this.inventory.armorInventory.length;
    }
    
    public void jump() {
        super.jump();
        this.triggerAchievement(StatList.jumpStat);
        if (this.isSprinting()) {
            this.addExhaustion(0.8f);
        }
        else {
            this.addExhaustion(0.2f);
        }
    }
    
    public boolean func_175140_cp() {
        return this.field_175153_bG;
    }
    
    public int getScore() {
        return this.dataWatcher.getWatchableObjectInt(18);
    }
    
    private void collideWithPlayer(final Entity llllllllllllllIllIIIllIlIIIlIIlI) {
        llllllllllllllIllIIIllIlIIIlIIlI.onCollideWithPlayer(this);
    }
    
    public abstract boolean func_175149_v();
    
    static {
        __OBFID = "CL_00001711";
    }
    
    public void clonePlayer(final EntityPlayer llllllllllllllIllIIIlIlIlIlIIIlI, final boolean llllllllllllllIllIIIlIlIlIlIIlII) {
        if (llllllllllllllIllIIIlIlIlIlIIlII) {
            this.inventory.copyInventory(llllllllllllllIllIIIlIlIlIlIIIlI.inventory);
            this.setHealth(llllllllllllllIllIIIlIlIlIlIIIlI.getHealth());
            this.foodStats = llllllllllllllIllIIIlIlIlIlIIIlI.foodStats;
            this.experienceLevel = llllllllllllllIllIIIlIlIlIlIIIlI.experienceLevel;
            this.experienceTotal = llllllllllllllIllIIIlIlIlIlIIIlI.experienceTotal;
            this.experience = llllllllllllllIllIIIlIlIlIlIIIlI.experience;
            this.setScore(llllllllllllllIllIIIlIlIlIlIIIlI.getScore());
            this.teleportDirection = llllllllllllllIllIIIlIlIlIlIIIlI.teleportDirection;
        }
        else if (this.worldObj.getGameRules().getGameRuleBooleanValue("keepInventory")) {
            this.inventory.copyInventory(llllllllllllllIllIIIlIlIlIlIIIlI.inventory);
            this.experienceLevel = llllllllllllllIllIIIlIlIlIlIIIlI.experienceLevel;
            this.experienceTotal = llllllllllllllIllIIIlIlIlIlIIIlI.experienceTotal;
            this.experience = llllllllllllllIllIIIlIlIlIlIIIlI.experience;
            this.setScore(llllllllllllllIllIIIlIlIlIlIIIlI.getScore());
        }
        this.theInventoryEnderChest = llllllllllllllIllIIIlIlIlIlIIIlI.theInventoryEnderChest;
        this.getDataWatcher().updateObject(10, llllllllllllllIllIIIlIlIlIlIIIlI.getDataWatcher().getWatchableObjectByte(10));
    }
    
    public void setGameType(final WorldSettings.GameType llllllllllllllIllIIIlIlIlIIllIll) {
    }
    
    public void func_175145_a(final StatBase llllllllllllllIllIIIlIllIllIIIlI) {
    }
    
    public boolean shouldHeal() {
        return this.getHealth() > 0.0f && this.getHealth() < this.getMaxHealth();
    }
    
    public boolean isUsingItem() {
        return this.itemInUse != null;
    }
    
    public void addChatComponentMessage(final IChatComponent llllllllllllllIllIIIlIllIlllllII) {
    }
    
    @Override
    public float getAIMoveSpeed() {
        return (float)this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue();
    }
    
    public boolean canHarvestBlock(final Block llllllllllllllIllIIIllIIlIIIlIll) {
        return this.inventory.func_146025_b(llllllllllllllIllIIIllIIlIIIlIll);
    }
    
    @Override
    protected String func_146067_o(final int llllllllllllllIllIIIlIllIIIlIlII) {
        return (llllllllllllllIllIIIlIllIIIlIlII > 4) ? "game.player.hurt.fall.big" : "game.player.hurt.fall.small";
    }
    
    @Override
    public void moveEntityWithHeading(final float llllllllllllllIllIIIlIllIlIIllIl, final float llllllllllllllIllIIIlIllIlIlIlII) {
        final double llllllllllllllIllIIIlIllIlIlIIll = this.posX;
        final double llllllllllllllIllIIIlIllIlIlIIlI = this.posY;
        final double llllllllllllllIllIIIlIllIlIlIIIl = this.posZ;
        if (this.capabilities.isFlying && this.ridingEntity == null) {
            final double llllllllllllllIllIIIlIllIlIlIIII = this.motionY;
            final float llllllllllllllIllIIIlIllIlIIllll = this.jumpMovementFactor;
            this.jumpMovementFactor = this.capabilities.getFlySpeed() * (this.isSprinting() ? 2 : 1);
            super.moveEntityWithHeading(llllllllllllllIllIIIlIllIlIIllIl, llllllllllllllIllIIIlIllIlIlIlII);
            this.motionY = llllllllllllllIllIIIlIllIlIlIIII * 0.6;
            this.jumpMovementFactor = llllllllllllllIllIIIlIllIlIIllll;
        }
        else {
            super.moveEntityWithHeading(llllllllllllllIllIIIlIllIlIIllIl, llllllllllllllIllIIIlIllIlIlIlII);
        }
        this.addMovementStat(this.posX - llllllllllllllIllIIIlIllIlIlIIll, this.posY - llllllllllllllIllIIIlIllIlIlIIlI, this.posZ - llllllllllllllIllIIIlIllIlIlIIIl);
    }
    
    public static UUID getUUID(final GameProfile llllllllllllllIllIIIlIlIIlIlIlII) {
        UUID llllllllllllllIllIIIlIlIIlIlIlIl = llllllllllllllIllIIIlIlIIlIlIlII.getId();
        if (llllllllllllllIllIIIlIlIIlIlIlIl == null) {
            llllllllllllllIllIIIlIlIIlIlIlIl = func_175147_b(llllllllllllllIllIIIlIlIIlIlIlII.getName());
        }
        return llllllllllllllIllIIIlIlIIlIlIlIl;
    }
    
    @Override
    protected String getDeathSound() {
        return "game.player.die";
    }
    
    public void displayGui(final IInteractionObject llllllllllllllIllIIIllIIIIlIIlIl) {
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.10000000149011612);
    }
    
    public void setItemInUse(final ItemStack llllllllllllllIllIIIlIlIllIIllII, final int llllllllllllllIllIIIlIlIllIIlIll) {
        if (llllllllllllllIllIIIlIlIllIIllII != this.itemInUse) {
            this.itemInUse = llllllllllllllIllIIIlIlIllIIllII;
            this.itemInUseCount = llllllllllllllIllIIIlIlIllIIlIll;
            if (!this.worldObj.isRemote) {
                this.setEating(true);
            }
        }
    }
    
    @Override
    public ItemStack getCurrentArmor(final int llllllllllllllIllIIIlIllIIIIIIll) {
        return this.inventory.armorItemInSlot(llllllllllllllIllIIIlIllIIIIIIll);
    }
    
    public static UUID func_175147_b(final String llllllllllllllIllIIIlIlIIlIlIIII) {
        return UUID.nameUUIDFromBytes(String.valueOf(new StringBuilder("OfflinePlayer:").append(llllllllllllllIllIIIlIlIIlIlIIII)).getBytes(Charsets.UTF_8));
    }
    
    public boolean isPlayerFullyAsleep() {
        return this.sleeping && this.sleepTimer >= 100;
    }
    
    protected void closeScreen() {
        this.openContainer = this.inventoryContainer;
    }
    
    public void clearItemInUse() {
        this.itemInUse = null;
        this.itemInUseCount = 0;
        if (!this.worldObj.isRemote) {
            this.setEating(false);
        }
    }
    
    public boolean func_175146_a(final LockCode llllllllllllllIllIIIlIlIIlIIlIll) {
        if (llllllllllllllIllIIIlIlIIlIIlIll.isEmpty()) {
            return true;
        }
        final ItemStack llllllllllllllIllIIIlIlIIlIIlIlI = this.getCurrentEquippedItem();
        return llllllllllllllIllIIIlIlIIlIIlIlI != null && llllllllllllllIllIIIlIlIIlIIlIlI.hasDisplayName() && llllllllllllllIllIIIlIlIIlIIlIlI.getDisplayName().equals(llllllllllllllIllIIIlIlIIlIIlIll.getLock());
    }
    
    public void func_71013_b(final int llllllllllllllIllIIIlIlIllllIIIl) {
        this.experienceLevel -= llllllllllllllIllIIIlIlIllllIIIl;
        if (this.experienceLevel < 0) {
            this.experienceLevel = 0;
            this.experience = 0.0f;
            this.experienceTotal = 0;
        }
        this.field_175152_f = this.rand.nextInt();
    }
    
    public ItemStack getItemInUse() {
        return this.itemInUse;
    }
    
    public boolean canEat(final boolean llllllllllllllIllIIIlIlIllIlIlII) {
        return (llllllllllllllIllIIIlIlIllIlIlII || this.foodStats.needFood()) && !this.capabilities.disableDamage;
    }
    
    @Override
    protected void damageEntity(final DamageSource llllllllllllllIllIIIllIIIIllIlIl, float llllllllllllllIllIIIllIIIIllIlII) {
        if (!this.func_180431_b(llllllllllllllIllIIIllIIIIllIlIl)) {
            if (!llllllllllllllIllIIIllIIIIllIlIl.isUnblockable() && this.isBlocking() && llllllllllllllIllIIIllIIIIllIlII > 0.0f) {
                llllllllllllllIllIIIllIIIIllIlII = (1.0f + llllllllllllllIllIIIllIIIIllIlII) * 0.5f;
            }
            llllllllllllllIllIIIllIIIIllIlII = this.applyArmorCalculations(llllllllllllllIllIIIllIIIIllIlIl, llllllllllllllIllIIIllIIIIllIlII);
            final float llllllllllllllIllIIIllIIIIlllIII;
            llllllllllllllIllIIIllIIIIllIlII = (llllllllllllllIllIIIllIIIIlllIII = this.applyPotionDamageCalculations(llllllllllllllIllIIIllIIIIllIlIl, llllllllllllllIllIIIllIIIIllIlII));
            llllllllllllllIllIIIllIIIIllIlII = Math.max(llllllllllllllIllIIIllIIIIllIlII - this.getAbsorptionAmount(), 0.0f);
            this.setAbsorptionAmount(this.getAbsorptionAmount() - (llllllllllllllIllIIIllIIIIlllIII - llllllllllllllIllIIIllIIIIllIlII));
            if (llllllllllllllIllIIIllIIIIllIlII != 0.0f) {
                this.addExhaustion(llllllllllllllIllIIIllIIIIllIlIl.getHungerDamage());
                final float llllllllllllllIllIIIllIIIIllIlll = this.getHealth();
                this.setHealth(this.getHealth() - llllllllllllllIllIIIllIIIIllIlII);
                this.getCombatTracker().func_94547_a(llllllllllllllIllIIIllIIIIllIlIl, llllllllllllllIllIIIllIIIIllIlll, llllllllllllllIllIIIllIIIIllIlII);
                if (llllllllllllllIllIIIllIIIIllIlII < 3.4028235E37f) {
                    this.addStat(StatList.damageTakenStat, Math.round(llllllllllllllIllIIIllIIIIllIlII * 10.0f));
                }
            }
        }
    }
    
    protected void updateItemUse(final ItemStack llllllllllllllIllIIIllIlIllIlIIl, final int llllllllllllllIllIIIllIlIllIIIIl) {
        if (llllllllllllllIllIIIllIlIllIlIIl.getItemUseAction() == EnumAction.DRINK) {
            this.playSound("random.drink", 0.5f, this.worldObj.rand.nextFloat() * 0.1f + 0.9f);
        }
        if (llllllllllllllIllIIIllIlIllIlIIl.getItemUseAction() == EnumAction.EAT) {
            for (int llllllllllllllIllIIIllIlIllIIlll = 0; llllllllllllllIllIIIllIlIllIIlll < llllllllllllllIllIIIllIlIllIIIIl; ++llllllllllllllIllIIIllIlIllIIlll) {
                Vec3 llllllllllllllIllIIIllIlIllIIllI = new Vec3((this.rand.nextFloat() - 0.5) * 0.1, Math.random() * 0.1 + 0.1, 0.0);
                llllllllllllllIllIIIllIlIllIIllI = llllllllllllllIllIIIllIlIllIIllI.rotatePitch(-this.rotationPitch * 3.1415927f / 180.0f);
                llllllllllllllIllIIIllIlIllIIllI = llllllllllllllIllIIIllIlIllIIllI.rotateYaw(-this.rotationYaw * 3.1415927f / 180.0f);
                final double llllllllllllllIllIIIllIlIllIIlIl = -this.rand.nextFloat() * 0.6 - 0.3;
                Vec3 llllllllllllllIllIIIllIlIllIIlII = new Vec3((this.rand.nextFloat() - 0.5) * 0.3, llllllllllllllIllIIIllIlIllIIlIl, 0.6);
                llllllllllllllIllIIIllIlIllIIlII = llllllllllllllIllIIIllIlIllIIlII.rotatePitch(-this.rotationPitch * 3.1415927f / 180.0f);
                llllllllllllllIllIIIllIlIllIIlII = llllllllllllllIllIIIllIlIllIIlII.rotateYaw(-this.rotationYaw * 3.1415927f / 180.0f);
                llllllllllllllIllIIIllIlIllIIlII = llllllllllllllIllIIIllIlIllIIlII.addVector(this.posX, this.posY + this.getEyeHeight(), this.posZ);
                if (llllllllllllllIllIIIllIlIllIlIIl.getHasSubtypes()) {
                    this.worldObj.spawnParticle(EnumParticleTypes.ITEM_CRACK, llllllllllllllIllIIIllIlIllIIlII.xCoord, llllllllllllllIllIIIllIlIllIIlII.yCoord, llllllllllllllIllIIIllIlIllIIlII.zCoord, llllllllllllllIllIIIllIlIllIIllI.xCoord, llllllllllllllIllIIIllIlIllIIllI.yCoord + 0.05, llllllllllllllIllIIIllIlIllIIllI.zCoord, Item.getIdFromItem(llllllllllllllIllIIIllIlIllIlIIl.getItem()), llllllllllllllIllIIIllIlIllIlIIl.getMetadata());
                }
                else {
                    this.worldObj.spawnParticle(EnumParticleTypes.ITEM_CRACK, llllllllllllllIllIIIllIlIllIIlII.xCoord, llllllllllllllIllIIIllIlIllIIlII.yCoord, llllllllllllllIllIIIllIlIllIIlII.zCoord, llllllllllllllIllIIIllIlIllIIllI.xCoord, llllllllllllllIllIIIllIlIllIIllI.yCoord + 0.05, llllllllllllllIllIIIllIlIllIIllI.zCoord, Item.getIdFromItem(llllllllllllllIllIIIllIlIllIlIIl.getItem()));
                }
            }
            this.playSound("random.eat", 0.5f + 0.5f * this.rand.nextInt(2), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
        }
    }
    
    @Override
    public void addToPlayerScore(final Entity llllllllllllllIllIIIllIIlllIllll, final int llllllllllllllIllIIIllIIlllIIlll) {
        this.addScore(llllllllllllllIllIIIllIIlllIIlll);
        final Collection llllllllllllllIllIIIllIIlllIllIl = this.getWorldScoreboard().func_96520_a(IScoreObjectiveCriteria.totalKillCount);
        if (llllllllllllllIllIIIllIIlllIllll instanceof EntityPlayer) {
            this.triggerAchievement(StatList.playerKillsStat);
            llllllllllllllIllIIIllIIlllIllIl.addAll(this.getWorldScoreboard().func_96520_a(IScoreObjectiveCriteria.playerKillCount));
            llllllllllllllIllIIIllIIlllIllIl.addAll(this.func_175137_e(llllllllllllllIllIIIllIIlllIllll));
        }
        else {
            this.triggerAchievement(StatList.mobKillsStat);
        }
        for (final ScoreObjective llllllllllllllIllIIIllIIlllIlIll : llllllllllllllIllIIIllIIlllIllIl) {
            final Score llllllllllllllIllIIIllIIlllIlIlI = this.getWorldScoreboard().getValueFromObjective(this.getName(), llllllllllllllIllIIIllIIlllIlIll);
            llllllllllllllIllIIIllIIlllIlIlI.func_96648_a();
        }
    }
    
    @Override
    public ItemStack[] getInventory() {
        return this.inventory.armorInventory;
    }
    
    @Override
    public void onLivingUpdate() {
        if (this.flyToggleTimer > 0) {
            --this.flyToggleTimer;
        }
        if (this.worldObj.getDifficulty() == EnumDifficulty.PEACEFUL && this.worldObj.getGameRules().getGameRuleBooleanValue("naturalRegeneration")) {
            if (this.getHealth() < this.getMaxHealth() && this.ticksExisted % 20 == 0) {
                this.heal(1.0f);
            }
            if (this.foodStats.needFood() && this.ticksExisted % 10 == 0) {
                this.foodStats.setFoodLevel(this.foodStats.getFoodLevel() + 1);
            }
        }
        this.inventory.decrementAnimations();
        this.prevCameraYaw = this.cameraYaw;
        super.onLivingUpdate();
        final IAttributeInstance llllllllllllllIllIIIllIlIIlIIllI = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
        if (!this.worldObj.isRemote) {
            llllllllllllllIllIIIllIlIIlIIllI.setBaseValue(this.capabilities.getWalkSpeed());
        }
        this.jumpMovementFactor = this.speedInAir;
        if (this.isSprinting()) {
            this.jumpMovementFactor += (float)(this.speedInAir * 0.3);
        }
        this.setAIMoveSpeed((float)llllllllllllllIllIIIllIlIIlIIllI.getAttributeValue());
        float llllllllllllllIllIIIllIlIIlIIlIl = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
        float llllllllllllllIllIIIllIlIIlIIlII = (float)(Math.atan(-this.motionY * 0.20000000298023224) * 15.0);
        if (llllllllllllllIllIIIllIlIIlIIlIl > 0.1f) {
            llllllllllllllIllIIIllIlIIlIIlIl = 0.1f;
        }
        if (!this.onGround || this.getHealth() <= 0.0f) {
            llllllllllllllIllIIIllIlIIlIIlIl = 0.0f;
        }
        if (this.onGround || this.getHealth() <= 0.0f) {
            llllllllllllllIllIIIllIlIIlIIlII = 0.0f;
        }
        this.cameraYaw += (llllllllllllllIllIIIllIlIIlIIlIl - this.cameraYaw) * 0.4f;
        this.cameraPitch += (llllllllllllllIllIIIllIlIIlIIlII - this.cameraPitch) * 0.8f;
        if (this.getHealth() > 0.0f && !this.func_175149_v()) {
            AxisAlignedBB llllllllllllllIllIIIllIlIIlIIIll = null;
            if (this.ridingEntity != null && !this.ridingEntity.isDead) {
                llllllllllllllIllIIIllIlIIlIIIll = this.getEntityBoundingBox().union(this.ridingEntity.getEntityBoundingBox()).expand(1.0, 0.0, 1.0);
            }
            else {
                llllllllllllllIllIIIllIlIIlIIIll = this.getEntityBoundingBox().expand(1.0, 0.5, 1.0);
            }
            final List llllllllllllllIllIIIllIlIIlIIIlI = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, llllllllllllllIllIIIllIlIIlIIIll);
            for (int llllllllllllllIllIIIllIlIIlIIIIl = 0; llllllllllllllIllIIIllIlIIlIIIIl < llllllllllllllIllIIIllIlIIlIIIlI.size(); ++llllllllllllllIllIIIllIlIIlIIIIl) {
                final Entity llllllllllllllIllIIIllIlIIlIIIII = llllllllllllllIllIIIllIlIIlIIIlI.get(llllllllllllllIllIIIllIlIIlIIIIl);
                if (!llllllllllllllIllIIIllIlIIlIIIII.isDead) {
                    this.collideWithPlayer(llllllllllllllIllIIIllIlIIlIIIII);
                }
            }
        }
    }
    
    @Override
    public void setAbsorptionAmount(float llllllllllllllIllIIIlIlIIlIlllII) {
        if (llllllllllllllIllIIIlIlIIlIlllII < 0.0f) {
            llllllllllllllIllIIIlIlIIlIlllII = 0.0f;
        }
        this.getDataWatcher().updateObject(17, llllllllllllllIllIIIlIlIIlIlllII);
    }
    
    @Override
    public boolean func_174820_d(final int llllllllllllllIllIIIlIlIIIllIIll, final ItemStack llllllllllllllIllIIIlIlIIIlllIII) {
        if (llllllllllllllIllIIIlIlIIIllIIll >= 0 && llllllllllllllIllIIIlIlIIIllIIll < this.inventory.mainInventory.length) {
            this.inventory.setInventorySlotContents(llllllllllllllIllIIIlIlIIIllIIll, llllllllllllllIllIIIlIlIIIlllIII);
            return true;
        }
        final int llllllllllllllIllIIIlIlIIIllIlll = llllllllllllllIllIIIlIlIIIllIIll - 100;
        if (llllllllllllllIllIIIlIlIIIllIlll >= 0 && llllllllllllllIllIIIlIlIIIllIlll < this.inventory.armorInventory.length) {
            final int llllllllllllllIllIIIlIlIIIllIllI = llllllllllllllIllIIIlIlIIIllIlll + 1;
            if (llllllllllllllIllIIIlIlIIIlllIII != null && llllllllllllllIllIIIlIlIIIlllIII.getItem() != null) {
                if (llllllllllllllIllIIIlIlIIIlllIII.getItem() instanceof ItemArmor) {
                    if (EntityLiving.getArmorPosition(llllllllllllllIllIIIlIlIIIlllIII) != llllllllllllllIllIIIlIlIIIllIllI) {
                        return false;
                    }
                }
                else if (llllllllllllllIllIIIlIlIIIllIllI != 4 || (llllllllllllllIllIIIlIlIIIlllIII.getItem() != Items.skull && !(llllllllllllllIllIIIlIlIIIlllIII.getItem() instanceof ItemBlock))) {
                    return false;
                }
            }
            this.inventory.setInventorySlotContents(llllllllllllllIllIIIlIlIIIllIlll + this.inventory.mainInventory.length, llllllllllllllIllIIIlIlIIIlllIII);
            return true;
        }
        final int llllllllllllllIllIIIlIlIIIllIlIl = llllllllllllllIllIIIlIlIIIllIIll - 200;
        if (llllllllllllllIllIIIlIlIIIllIlIl >= 0 && llllllllllllllIllIIIlIlIIIllIlIl < this.theInventoryEnderChest.getSizeInventory()) {
            this.theInventoryEnderChest.setInventorySlotContents(llllllllllllllIllIIIlIlIIIllIlIl, llllllllllllllIllIIIlIlIIIlllIII);
            return true;
        }
        return false;
    }
    
    @Override
    public void onKillEntity(final EntityLivingBase llllllllllllllIllIIIlIllIIIIlllI) {
        if (llllllllllllllIllIIIlIllIIIIlllI instanceof IMob) {
            this.triggerAchievement(AchievementList.killEnemy);
        }
        final EntityList.EntityEggInfo llllllllllllllIllIIIlIllIIIIllIl = EntityList.entityEggs.get(EntityList.getEntityID(llllllllllllllIllIIIlIllIIIIlllI));
        if (llllllllllllllIllIIIlIllIIIIllIl != null) {
            this.triggerAchievement(llllllllllllllIllIIIlIllIIIIllIl.field_151512_d);
        }
    }
    
    public void displayGUIHorse(final EntityHorse llllllllllllllIllIIIllIIIIlIlIII, final IInventory llllllllllllllIllIIIllIIIIlIIlll) {
    }
    
    private void func_175139_a(final EnumFacing llllllllllllllIllIIIlIlllIllIlll) {
        this.field_71079_bU = 0.0f;
        this.field_71089_bV = 0.0f;
        switch (SwitchEnumFacing.field_179420_a[llllllllllllllIllIIIlIlllIllIlll.ordinal()]) {
            case 1: {
                this.field_71089_bV = -1.8f;
                break;
            }
            case 2: {
                this.field_71089_bV = 1.8f;
                break;
            }
            case 3: {
                this.field_71079_bU = 1.8f;
                break;
            }
            case 4: {
                this.field_71079_bU = -1.8f;
                break;
            }
        }
    }
    
    public void triggerAchievement(final StatBase llllllllllllllIllIIIlIllIllIlIIl) {
        this.addStat(llllllllllllllIllIIIlIllIllIlIIl, 1);
    }
    
    @Override
    public double getYOffset() {
        return -0.35;
    }
    
    @Override
    protected void updateEntityActionState() {
        super.updateEntityActionState();
        this.updateArmSwingProgress();
        this.rotationYawHead = this.rotationYaw;
    }
    
    @Override
    public ItemStack getEquipmentInSlot(final int llllllllllllllIllIIIlIlIlIIlIIIl) {
        return (llllllllllllllIllIIIlIlIlIIlIIIl == 0) ? this.inventory.getCurrentItem() : this.inventory.armorInventory[llllllllllllllIllIIIlIlIlIIlIIIl - 1];
    }
    
    public boolean func_175151_a(final BlockPos llllllllllllllIllIIIlIlIlIllIlll, final EnumFacing llllllllllllllIllIIIlIlIlIllIllI, final ItemStack llllllllllllllIllIIIlIlIlIllIlIl) {
        if (this.capabilities.allowEdit) {
            return true;
        }
        if (llllllllllllllIllIIIlIlIlIllIlIl == null) {
            return false;
        }
        final BlockPos llllllllllllllIllIIIlIlIlIlllIlI = llllllllllllllIllIIIlIlIlIllIlll.offset(llllllllllllllIllIIIlIlIlIllIllI.getOpposite());
        final Block llllllllllllllIllIIIlIlIlIlllIIl = this.worldObj.getBlockState(llllllllllllllIllIIIlIlIlIlllIlI).getBlock();
        return llllllllllllllIllIIIlIlIlIllIlIl.canPlaceOn(llllllllllllllIllIIIlIlIlIlllIIl) || llllllllllllllIllIIIlIlIlIllIlIl.canEditBlocks();
    }
    
    public EntityItem dropOneItem(final boolean llllllllllllllIllIIIllIIllIIlIII) {
        return this.func_146097_a(this.inventory.decrStackSize(this.inventory.currentItem, (llllllllllllllIllIIIllIIllIIlIII && this.inventory.getCurrentItem() != null) ? this.inventory.getCurrentItem().stackSize : 1), false, true);
    }
    
    public void wakeUpPlayer(final boolean llllllllllllllIllIIIlIlllIlIlIIl, final boolean llllllllllllllIllIIIlIlllIlIlllI, final boolean llllllllllllllIllIIIlIlllIlIllIl) {
        this.setSize(0.6f, 1.8f);
        final IBlockState llllllllllllllIllIIIlIlllIlIllII = this.worldObj.getBlockState(this.playerLocation);
        if (this.playerLocation != null && llllllllllllllIllIIIlIlllIlIllII.getBlock() == Blocks.bed) {
            this.worldObj.setBlockState(this.playerLocation, llllllllllllllIllIIIlIlllIlIllII.withProperty(BlockBed.OCCUPIED_PROP, false), 4);
            BlockPos llllllllllllllIllIIIlIlllIlIlIll = BlockBed.getSafeExitLocation(this.worldObj, this.playerLocation, 0);
            if (llllllllllllllIllIIIlIlllIlIlIll == null) {
                llllllllllllllIllIIIlIlllIlIlIll = this.playerLocation.offsetUp();
            }
            this.setPosition(llllllllllllllIllIIIlIlllIlIlIll.getX() + 0.5f, llllllllllllllIllIIIlIlllIlIlIll.getY() + 0.1f, llllllllllllllIllIIIlIlllIlIlIll.getZ() + 0.5f);
        }
        this.sleeping = false;
        if (!this.worldObj.isRemote && llllllllllllllIllIIIlIlllIlIlllI) {
            this.worldObj.updateAllPlayersSleepingFlag();
        }
        this.sleepTimer = (llllllllllllllIllIIIlIlllIlIlIIl ? 0 : 100);
        if (llllllllllllllIllIIIlIlllIlIllIl) {
            this.func_180473_a(this.playerLocation, false);
        }
    }
    
    public void func_175141_a(final TileEntitySign llllllllllllllIllIIIllIIIIllIIII) {
    }
    
    @Override
    protected boolean isPlayer() {
        return true;
    }
    
    public void func_175150_k(final boolean llllllllllllllIllIIIlIlIIIlIlIIl) {
        this.field_175153_bG = llllllllllllllIllIIIlIlIIIlIlIIl;
    }
    
    public EntityItem func_146097_a(final ItemStack llllllllllllllIllIIIllIIlIllIlIl, final boolean llllllllllllllIllIIIllIIlIlIlIlI, final boolean llllllllllllllIllIIIllIIlIllIIll) {
        if (llllllllllllllIllIIIllIIlIllIlIl == null) {
            return null;
        }
        if (llllllllllllllIllIIIllIIlIllIlIl.stackSize == 0) {
            return null;
        }
        final double llllllllllllllIllIIIllIIlIllIIlI = this.posY - 0.30000001192092896 + this.getEyeHeight();
        final EntityItem llllllllllllllIllIIIllIIlIllIIIl = new EntityItem(this.worldObj, this.posX, llllllllllllllIllIIIllIIlIllIIlI, this.posZ, llllllllllllllIllIIIllIIlIllIlIl);
        llllllllllllllIllIIIllIIlIllIIIl.setPickupDelay(40);
        if (llllllllllllllIllIIIllIIlIllIIll) {
            llllllllllllllIllIIIllIIlIllIIIl.setThrower(this.getName());
        }
        if (llllllllllllllIllIIIllIIlIlIlIlI) {
            final float llllllllllllllIllIIIllIIlIllIIII = this.rand.nextFloat() * 0.5f;
            final float llllllllllllllIllIIIllIIlIlIlllI = this.rand.nextFloat() * 3.1415927f * 2.0f;
            llllllllllllllIllIIIllIIlIllIIIl.motionX = -MathHelper.sin(llllllllllllllIllIIIllIIlIlIlllI) * llllllllllllllIllIIIllIIlIllIIII;
            llllllllllllllIllIIIllIIlIllIIIl.motionZ = MathHelper.cos(llllllllllllllIllIIIllIIlIlIlllI) * llllllllllllllIllIIIllIIlIllIIII;
            llllllllllllllIllIIIllIIlIllIIIl.motionY = 0.20000000298023224;
        }
        else {
            float llllllllllllllIllIIIllIIlIlIllll = 0.3f;
            llllllllllllllIllIIIllIIlIllIIIl.motionX = -MathHelper.sin(this.rotationYaw / 180.0f * 3.1415927f) * MathHelper.cos(this.rotationPitch / 180.0f * 3.1415927f) * llllllllllllllIllIIIllIIlIlIllll;
            llllllllllllllIllIIIllIIlIllIIIl.motionZ = MathHelper.cos(this.rotationYaw / 180.0f * 3.1415927f) * MathHelper.cos(this.rotationPitch / 180.0f * 3.1415927f) * llllllllllllllIllIIIllIIlIlIllll;
            llllllllllllllIllIIIllIIlIllIIIl.motionY = -MathHelper.sin(this.rotationPitch / 180.0f * 3.1415927f) * llllllllllllllIllIIIllIIlIlIllll + 0.1f;
            final float llllllllllllllIllIIIllIIlIlIllIl = this.rand.nextFloat() * 3.1415927f * 2.0f;
            llllllllllllllIllIIIllIIlIlIllll = 0.02f * this.rand.nextFloat();
            final EntityItem entityItem = llllllllllllllIllIIIllIIlIllIIIl;
            entityItem.motionX += Math.cos(llllllllllllllIllIIIllIIlIlIllIl) * llllllllllllllIllIIIllIIlIlIllll;
            final EntityItem entityItem2 = llllllllllllllIllIIIllIIlIllIIIl;
            entityItem2.motionY += (this.rand.nextFloat() - this.rand.nextFloat()) * 0.1f;
            final EntityItem entityItem3 = llllllllllllllIllIIIllIIlIllIIIl;
            entityItem3.motionZ += Math.sin(llllllllllllllIllIIIllIIlIlIllIl) * llllllllllllllIllIIIllIIlIlIllll;
        }
        this.joinEntityItemWithWorld(llllllllllllllIllIIIllIIlIllIIIl);
        if (llllllllllllllIllIIIllIIlIllIIll) {
            this.triggerAchievement(StatList.dropStat);
        }
        return llllllllllllllIllIIIllIIlIllIIIl;
    }
    
    public void sendPlayerAbilities() {
    }
    
    public void addStat(final StatBase llllllllllllllIllIIIlIllIllIIlIl, final int llllllllllllllIllIIIlIllIllIIlII) {
    }
    
    public void addExperienceLevel(final int llllllllllllllIllIIIlIlIlllIlIlI) {
        this.experienceLevel += llllllllllllllIllIIIlIlIlllIlIlI;
        if (this.experienceLevel < 0) {
            this.experienceLevel = 0;
            this.experience = 0.0f;
            this.experienceTotal = 0;
        }
        if (llllllllllllllIllIIIlIlIlllIlIlI > 0 && this.experienceLevel % 5 == 0 && this.field_82249_h < this.ticksExisted - 100.0f) {
            final float llllllllllllllIllIIIlIlIlllIlIIl = (this.experienceLevel > 30) ? 1.0f : (this.experienceLevel / 30.0f);
            this.worldObj.playSoundAtEntity(this, "random.levelup", llllllllllllllIllIIIlIlIlllIlIIl * 0.75f, 1.0f);
            this.field_82249_h = this.ticksExisted;
        }
    }
    
    public void addExhaustion(final float llllllllllllllIllIIIlIlIllIlllll) {
        if (!this.capabilities.disableDamage && !this.worldObj.isRemote) {
            this.foodStats.addExhaustion(llllllllllllllIllIIIlIlIllIlllll);
        }
    }
    
    @Override
    public float getAbsorptionAmount() {
        return this.getDataWatcher().getWatchableObjectFloat(17);
    }
    
    private boolean func_175143_p() {
        return this.worldObj.getBlockState(this.playerLocation).getBlock() == Blocks.bed;
    }
    
    public EntityPlayer(final World llllllllllllllIllIIIllIllIlllIlI, final GameProfile llllllllllllllIllIIIllIllIllllIl) {
        super(llllllllllllllIllIIIllIllIlllIlI);
        this.inventory = new InventoryPlayer(this);
        this.theInventoryEnderChest = new InventoryEnderChest();
        this.foodStats = new FoodStats();
        this.capabilities = new PlayerCapabilities();
        this.speedOnGround = 0.1f;
        this.speedInAir = 0.02f;
        this.field_175153_bG = false;
        this.entityUniqueID = getUUID(llllllllllllllIllIIIllIllIllllIl);
        this.gameProfile = llllllllllllllIllIIIllIllIllllIl;
        this.inventoryContainer = new ContainerPlayer(this.inventory, !llllllllllllllIllIIIllIllIlllIlI.isRemote, this);
        this.openContainer = this.inventoryContainer;
        final BlockPos llllllllllllllIllIIIllIllIllllII = llllllllllllllIllIIIllIllIlllIlI.getSpawnPoint();
        this.setLocationAndAngles(llllllllllllllIllIIIllIllIllllII.getX() + 0.5, llllllllllllllIllIIIllIllIllllII.getY() + 1, llllllllllllllIllIIIllIllIllllII.getZ() + 0.5, 0.0f, 0.0f);
        this.field_70741_aB = 180.0f;
        this.fireResistance = 20;
    }
    
    public BlockPos func_180470_cg() {
        return this.spawnChunk;
    }
    
    @Override
    public void onDeath(final DamageSource llllllllllllllIllIIIllIIllllllII) {
        super.onDeath(llllllllllllllIllIIIllIIllllllII);
        this.setSize(0.2f, 0.2f);
        this.setPosition(this.posX, this.posY, this.posZ);
        this.motionY = 0.10000000149011612;
        if (this.getName().equals("Notch")) {
            this.func_146097_a(new ItemStack(Items.apple, 1), true, false);
        }
        if (!this.worldObj.getGameRules().getGameRuleBooleanValue("keepInventory")) {
            this.inventory.dropAllItems();
        }
        if (llllllllllllllIllIIIllIIllllllII != null) {
            this.motionX = -MathHelper.cos((this.attackedAtYaw + this.rotationYaw) * 3.1415927f / 180.0f) * 0.1f;
            this.motionZ = -MathHelper.sin((this.attackedAtYaw + this.rotationYaw) * 3.1415927f / 180.0f) * 0.1f;
        }
        else {
            final double n = 0.0;
            this.motionZ = n;
            this.motionX = n;
        }
        this.triggerAchievement(StatList.deathsStat);
        this.func_175145_a(StatList.timeSinceDeathStat);
    }
    
    private void addMountedMovementStat(final double llllllllllllllIllIIIlIllIIlIIllI, final double llllllllllllllIllIIIlIllIIlIIlIl, final double llllllllllllllIllIIIlIllIIlIIlII) {
        if (this.ridingEntity != null) {
            final int llllllllllllllIllIIIlIllIIlIlIII = Math.round(MathHelper.sqrt_double(llllllllllllllIllIIIlIllIIlIIllI * llllllllllllllIllIIIlIllIIlIIllI + llllllllllllllIllIIIlIllIIlIIlIl * llllllllllllllIllIIIlIllIIlIIlIl + llllllllllllllIllIIIlIllIIlIIlII * llllllllllllllIllIIIlIllIIlIIlII) * 100.0f);
            if (llllllllllllllIllIIIlIllIIlIlIII > 0) {
                if (this.ridingEntity instanceof EntityMinecart) {
                    this.addStat(StatList.distanceByMinecartStat, llllllllllllllIllIIIlIllIIlIlIII);
                    if (this.startMinecartRidingCoordinate == null) {
                        this.startMinecartRidingCoordinate = new BlockPos(this);
                    }
                    else if (this.startMinecartRidingCoordinate.distanceSq(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)) >= 1000000.0) {
                        this.triggerAchievement(AchievementList.onARail);
                    }
                }
                else if (this.ridingEntity instanceof EntityBoat) {
                    this.addStat(StatList.distanceByBoatStat, llllllllllllllIllIIIlIllIIlIlIII);
                }
                else if (this.ridingEntity instanceof EntityPig) {
                    this.addStat(StatList.distanceByPigStat, llllllllllllllIllIIIlIllIIlIlIII);
                }
                else if (this.ridingEntity instanceof EntityHorse) {
                    this.addStat(StatList.distanceByHorseStat, llllllllllllllIllIIIlIllIIlIlIII);
                }
            }
        }
    }
    
    @Override
    public String getName() {
        return this.gameProfile.getName();
    }
    
    @Override
    protected String getHurtSound() {
        return "game.player.hurt";
    }
    
    private Collection func_175137_e(final Entity llllllllllllllIllIIIllIIllIllIlI) {
        final ScorePlayerTeam llllllllllllllIllIIIllIIllIllIIl = this.getWorldScoreboard().getPlayersTeam(this.getName());
        if (llllllllllllllIllIIIllIIllIllIIl != null) {
            final int llllllllllllllIllIIIllIIllIllIII = llllllllllllllIllIIIllIIllIllIIl.func_178775_l().func_175746_b();
            if (llllllllllllllIllIIIllIIllIllIII >= 0 && llllllllllllllIllIIIllIIllIllIII < IScoreObjectiveCriteria.field_178793_i.length) {
                for (final ScoreObjective llllllllllllllIllIIIllIIllIlIllI : this.getWorldScoreboard().func_96520_a(IScoreObjectiveCriteria.field_178793_i[llllllllllllllIllIIIllIIllIllIII])) {
                    final Score llllllllllllllIllIIIllIIllIlIlIl = this.getWorldScoreboard().getValueFromObjective(llllllllllllllIllIIIllIIllIllIlI.getName(), llllllllllllllIllIIIllIIllIlIllI);
                    llllllllllllllIllIIIllIIllIlIlIl.func_96648_a();
                }
            }
        }
        final ScorePlayerTeam llllllllllllllIllIIIllIIllIlIlII = this.getWorldScoreboard().getPlayersTeam(llllllllllllllIllIIIllIIllIllIlI.getName());
        if (llllllllllllllIllIIIllIIllIlIlII != null) {
            final int llllllllllllllIllIIIllIIllIlIIll = llllllllllllllIllIIIllIIllIlIlII.func_178775_l().func_175746_b();
            if (llllllllllllllIllIIIllIIllIlIIll >= 0 && llllllllllllllIllIIIllIIllIlIIll < IScoreObjectiveCriteria.field_178792_h.length) {
                return this.getWorldScoreboard().func_96520_a(IScoreObjectiveCriteria.field_178792_h[llllllllllllllIllIIIllIIllIlIIll]);
            }
        }
        return Lists.newArrayList();
    }
    
    public boolean interactWith(final Entity llllllllllllllIllIIIllIIIIIllIIl) {
        if (this.func_175149_v()) {
            if (llllllllllllllIllIIIllIIIIIllIIl instanceof IInventory) {
                this.displayGUIChest((IInventory)llllllllllllllIllIIIllIIIIIllIIl);
            }
            return false;
        }
        ItemStack llllllllllllllIllIIIllIIIIIlllII = this.getCurrentEquippedItem();
        final ItemStack llllllllllllllIllIIIllIIIIIllIll = (llllllllllllllIllIIIllIIIIIlllII != null) ? llllllllllllllIllIIIllIIIIIlllII.copy() : null;
        if (!llllllllllllllIllIIIllIIIIIllIIl.interactFirst(this)) {
            if (llllllllllllllIllIIIllIIIIIlllII != null && llllllllllllllIllIIIllIIIIIllIIl instanceof EntityLivingBase) {
                if (this.capabilities.isCreativeMode) {
                    llllllllllllllIllIIIllIIIIIlllII = llllllllllllllIllIIIllIIIIIllIll;
                }
                if (llllllllllllllIllIIIllIIIIIlllII.interactWithEntity(this, (EntityLivingBase)llllllllllllllIllIIIllIIIIIllIIl)) {
                    if (llllllllllllllIllIIIllIIIIIlllII.stackSize <= 0 && !this.capabilities.isCreativeMode) {
                        this.destroyCurrentEquippedItem();
                    }
                    return true;
                }
            }
            return false;
        }
        if (llllllllllllllIllIIIllIIIIIlllII != null && llllllllllllllIllIIIllIIIIIlllII == this.getCurrentEquippedItem()) {
            if (llllllllllllllIllIIIllIIIIIlllII.stackSize <= 0 && !this.capabilities.isCreativeMode) {
                this.destroyCurrentEquippedItem();
            }
            else if (llllllllllllllIllIIIllIIIIIlllII.stackSize < llllllllllllllIllIIIllIIIIIllIll.stackSize && this.capabilities.isCreativeMode) {
                llllllllllllllIllIIIllIIIIIlllII.stackSize = llllllllllllllIllIIIllIIIIIllIll.stackSize;
            }
        }
        return true;
    }
    
    public boolean func_175148_a(final EnumPlayerModelParts llllllllllllllIllIIIlIlIIlIIIIIl) {
        return (this.getDataWatcher().getWatchableObjectByte(10) & llllllllllllllIllIIIlIlIIlIIIIIl.func_179327_a()) == llllllllllllllIllIIIlIlIIlIIIIIl.func_179327_a();
    }
    
    public void displayGUIBook(final ItemStack llllllllllllllIllIIIllIIIIlIIIll) {
    }
    
    public float func_180471_a(final Block llllllllllllllIllIIIllIIlIIlIIlI) {
        float llllllllllllllIllIIIllIIlIIlIlll = this.inventory.getStrVsBlock(llllllllllllllIllIIIllIIlIIlIIlI);
        if (llllllllllllllIllIIIllIIlIIlIlll > 1.0f) {
            final int llllllllllllllIllIIIllIIlIIlIllI = EnchantmentHelper.getEfficiencyModifier(this);
            final ItemStack llllllllllllllIllIIIllIIlIIlIlIl = this.inventory.getCurrentItem();
            if (llllllllllllllIllIIIllIIlIIlIllI > 0 && llllllllllllllIllIIIllIIlIIlIlIl != null) {
                llllllllllllllIllIIIllIIlIIlIlll += llllllllllllllIllIIIllIIlIIlIllI * llllllllllllllIllIIIllIIlIIlIllI + 1;
            }
        }
        if (this.isPotionActive(Potion.digSpeed)) {
            llllllllllllllIllIIIllIIlIIlIlll *= 1.0f + (this.getActivePotionEffect(Potion.digSpeed).getAmplifier() + 1) * 0.2f;
        }
        if (this.isPotionActive(Potion.digSlowdown)) {
            float llllllllllllllIllIIIllIIlIIlIlII = 1.0f;
            switch (this.getActivePotionEffect(Potion.digSlowdown).getAmplifier()) {
                case 0: {
                    llllllllllllllIllIIIllIIlIIlIlII = 0.3f;
                    break;
                }
                case 1: {
                    llllllllllllllIllIIIllIIlIIlIlII = 0.09f;
                    break;
                }
                case 2: {
                    llllllllllllllIllIIIllIIlIIlIlII = 0.0027f;
                    break;
                }
                default: {
                    llllllllllllllIllIIIllIIlIIlIlII = 8.1E-4f;
                    break;
                }
            }
            llllllllllllllIllIIIllIIlIIlIlll *= llllllllllllllIllIIIllIIlIIlIlII;
        }
        if (this.isInsideOfMaterial(Material.water) && !EnchantmentHelper.getAquaAffinityModifier(this)) {
            llllllllllllllIllIIIllIIlIIlIlll /= 5.0f;
        }
        if (!this.onGround) {
            llllllllllllllIllIIIllIIlIIlIlll /= 5.0f;
        }
        return llllllllllllllIllIIIllIIlIIlIlll;
    }
    
    @Override
    public int getPortalCooldown() {
        return 10;
    }
    
    public void func_180473_a(final BlockPos llllllllllllllIllIIIlIllIlllIIIl, final boolean llllllllllllllIllIIIlIllIllIllIl) {
        if (llllllllllllllIllIIIlIllIlllIIIl != null) {
            this.spawnChunk = llllllllllllllIllIIIlIllIlllIIIl;
            this.spawnForced = llllllllllllllIllIIIlIllIllIllIl;
        }
        else {
            this.spawnChunk = null;
            this.spawnForced = false;
        }
    }
    
    public Scoreboard getWorldScoreboard() {
        return this.worldObj.getScoreboard();
    }
    
    public boolean func_175144_cb() {
        return false;
    }
    
    @Override
    public int getMaxInPortalTime() {
        return this.capabilities.disableDamage ? 0 : 80;
    }
    
    @Override
    public void handleHealthUpdate(final byte llllllllllllllIllIIIllIlIlIIlllI) {
        if (llllllllllllllIllIIIllIlIlIIlllI == 9) {
            this.onItemUseFinish();
        }
        else if (llllllllllllllIllIIIllIlIlIIlllI == 23) {
            this.field_175153_bG = false;
        }
        else if (llllllllllllllIllIIIllIlIlIIlllI == 22) {
            this.field_175153_bG = true;
        }
        else {
            super.handleHealthUpdate(llllllllllllllIllIIIllIlIlIIlllI);
        }
    }
    
    @Override
    protected void damageArmor(final float llllllllllllllIllIIIllIIIlIlIllI) {
        this.inventory.damageArmor(llllllllllllllIllIIIllIIIlIlIllI);
    }
    
    @Override
    public void setDead() {
        super.setDead();
        this.inventoryContainer.onContainerClosed(this);
        if (this.openContainer != null) {
            this.openContainer.onContainerClosed(this);
        }
    }
    
    @Override
    protected String getSplashSound() {
        return "game.player.swim.splash";
    }
    
    public FoodStats getFoodStats() {
        return this.foodStats;
    }
    
    @Override
    protected int getExperiencePoints(final EntityPlayer llllllllllllllIllIIIlIlIlIlIllll) {
        if (this.worldObj.getGameRules().getGameRuleBooleanValue("keepInventory")) {
            return 0;
        }
        final int llllllllllllllIllIIIlIlIlIlIlllI = this.experienceLevel * 7;
        return (llllllllllllllIllIIIlIlIlIlIlllI > 100) ? 100 : llllllllllllllIllIIIlIlIlIlIlllI;
    }
    
    @Override
    public void setInWeb() {
        if (!this.capabilities.isFlying) {
            super.setInWeb();
        }
    }
    
    public void attackTargetEntityWithCurrentItem(final Entity llllllllllllllIllIIIlIlllllIlllI) {
        if (llllllllllllllIllIIIlIlllllIlllI.canAttackWithItem() && !llllllllllllllIllIIIlIlllllIlllI.hitByEntity(this)) {
            float llllllllllllllIllIIIlIllllllllIl = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
            final byte llllllllllllllIllIIIlIllllllllII = 0;
            float llllllllllllllIllIIIlIlllllllIll = 0.0f;
            if (llllllllllllllIllIIIlIlllllIlllI instanceof EntityLivingBase) {
                llllllllllllllIllIIIlIlllllllIll = EnchantmentHelper.func_152377_a(this.getHeldItem(), ((EntityLivingBase)llllllllllllllIllIIIlIlllllIlllI).getCreatureAttribute());
            }
            else {
                llllllllllllllIllIIIlIlllllllIll = EnchantmentHelper.func_152377_a(this.getHeldItem(), EnumCreatureAttribute.UNDEFINED);
            }
            int llllllllllllllIllIIIlIlllllllIlI = llllllllllllllIllIIIlIllllllllII + EnchantmentHelper.getRespiration(this);
            if (this.isSprinting()) {
                ++llllllllllllllIllIIIlIlllllllIlI;
            }
            if (llllllllllllllIllIIIlIllllllllIl > 0.0f || llllllllllllllIllIIIlIlllllllIll > 0.0f) {
                final boolean llllllllllllllIllIIIlIlllllllIIl = this.fallDistance > 0.0f && !this.onGround && !this.isOnLadder() && !this.isInWater() && !this.isPotionActive(Potion.blindness) && this.ridingEntity == null && llllllllllllllIllIIIlIlllllIlllI instanceof EntityLivingBase;
                if (llllllllllllllIllIIIlIlllllllIIl && llllllllllllllIllIIIlIllllllllIl > 0.0f) {
                    llllllllllllllIllIIIlIllllllllIl *= 1.5f;
                }
                llllllllllllllIllIIIlIllllllllIl += llllllllllllllIllIIIlIlllllllIll;
                boolean llllllllllllllIllIIIlIlllllllIII = false;
                final int llllllllllllllIllIIIlIllllllIlll = EnchantmentHelper.getFireAspectModifier(this);
                if (llllllllllllllIllIIIlIlllllIlllI instanceof EntityLivingBase && llllllllllllllIllIIIlIllllllIlll > 0 && !llllllllllllllIllIIIlIlllllIlllI.isBurning()) {
                    llllllllllllllIllIIIlIlllllllIII = true;
                    llllllllllllllIllIIIlIlllllIlllI.setFire(1);
                }
                final double llllllllllllllIllIIIlIllllllIllI = llllllllllllllIllIIIlIlllllIlllI.motionX;
                final double llllllllllllllIllIIIlIllllllIlIl = llllllllllllllIllIIIlIlllllIlllI.motionY;
                final double llllllllllllllIllIIIlIllllllIlII = llllllllllllllIllIIIlIlllllIlllI.motionZ;
                final boolean llllllllllllllIllIIIlIllllllIIll = llllllllllllllIllIIIlIlllllIlllI.attackEntityFrom(DamageSource.causePlayerDamage(this), llllllllllllllIllIIIlIllllllllIl);
                if (llllllllllllllIllIIIlIllllllIIll) {
                    if (llllllllllllllIllIIIlIlllllllIlI > 0) {
                        llllllllllllllIllIIIlIlllllIlllI.addVelocity(-MathHelper.sin(this.rotationYaw * 3.1415927f / 180.0f) * llllllllllllllIllIIIlIlllllllIlI * 0.5f, 0.1, MathHelper.cos(this.rotationYaw * 3.1415927f / 180.0f) * llllllllllllllIllIIIlIlllllllIlI * 0.5f);
                        this.motionX *= 0.6;
                        this.motionZ *= 0.6;
                        this.setSprinting(false);
                    }
                    if (llllllllllllllIllIIIlIlllllIlllI instanceof EntityPlayerMP && llllllllllllllIllIIIlIlllllIlllI.velocityChanged) {
                        ((EntityPlayerMP)llllllllllllllIllIIIlIlllllIlllI).playerNetServerHandler.sendPacket(new S12PacketEntityVelocity(llllllllllllllIllIIIlIlllllIlllI));
                        llllllllllllllIllIIIlIlllllIlllI.velocityChanged = false;
                        llllllllllllllIllIIIlIlllllIlllI.motionX = llllllllllllllIllIIIlIllllllIllI;
                        llllllllllllllIllIIIlIlllllIlllI.motionY = llllllllllllllIllIIIlIllllllIlIl;
                        llllllllllllllIllIIIlIlllllIlllI.motionZ = llllllllllllllIllIIIlIllllllIlII;
                    }
                    if (llllllllllllllIllIIIlIlllllllIIl) {
                        this.onCriticalHit(llllllllllllllIllIIIlIlllllIlllI);
                    }
                    if (llllllllllllllIllIIIlIlllllllIll > 0.0f) {
                        this.onEnchantmentCritical(llllllllllllllIllIIIlIlllllIlllI);
                    }
                    if (llllllllllllllIllIIIlIllllllllIl >= 18.0f) {
                        this.triggerAchievement(AchievementList.overkill);
                    }
                    this.setLastAttacker(llllllllllllllIllIIIlIlllllIlllI);
                    if (llllllllllllllIllIIIlIlllllIlllI instanceof EntityLivingBase) {
                        EnchantmentHelper.func_151384_a((EntityLivingBase)llllllllllllllIllIIIlIlllllIlllI, this);
                    }
                    EnchantmentHelper.func_151385_b(this, llllllllllllllIllIIIlIlllllIlllI);
                    final ItemStack llllllllllllllIllIIIlIllllllIIlI = this.getCurrentEquippedItem();
                    Object llllllllllllllIllIIIlIllllllIIIl = llllllllllllllIllIIIlIlllllIlllI;
                    if (llllllllllllllIllIIIlIlllllIlllI instanceof EntityDragonPart) {
                        final IEntityMultiPart llllllllllllllIllIIIlIllllllIIII = ((EntityDragonPart)llllllllllllllIllIIIlIlllllIlllI).entityDragonObj;
                        if (llllllllllllllIllIIIlIllllllIIII instanceof EntityLivingBase) {
                            llllllllllllllIllIIIlIllllllIIIl = llllllllllllllIllIIIlIllllllIIII;
                        }
                    }
                    if (llllllllllllllIllIIIlIllllllIIlI != null && llllllllllllllIllIIIlIllllllIIIl instanceof EntityLivingBase) {
                        llllllllllllllIllIIIlIllllllIIlI.hitEntity((EntityLivingBase)llllllllllllllIllIIIlIllllllIIIl, this);
                        if (llllllllllllllIllIIIlIllllllIIlI.stackSize <= 0) {
                            this.destroyCurrentEquippedItem();
                        }
                    }
                    if (llllllllllllllIllIIIlIlllllIlllI instanceof EntityLivingBase) {
                        this.addStat(StatList.damageDealtStat, Math.round(llllllllllllllIllIIIlIllllllllIl * 10.0f));
                        if (llllllllllllllIllIIIlIllllllIlll > 0) {
                            llllllllllllllIllIIIlIlllllIlllI.setFire(llllllllllllllIllIIIlIllllllIlll * 4);
                        }
                    }
                    this.addExhaustion(0.3f);
                }
                else if (llllllllllllllIllIIIlIlllllllIII) {
                    llllllllllllllIllIIIlIlllllIlllI.extinguish();
                }
            }
        }
    }
    
    @Override
    public boolean sendCommandFeedback() {
        return MinecraftServer.getServer().worldServers[0].getGameRules().getGameRuleBooleanValue("sendCommandFeedback");
    }
    
    public ItemStack getCurrentEquippedItem() {
        return this.inventory.getCurrentItem();
    }
    
    public boolean func_175142_cm() {
        return this.capabilities.allowEdit;
    }
    
    public GameProfile getGameProfile() {
        return this.gameProfile;
    }
    
    public boolean isSpawnForced() {
        return this.spawnForced;
    }
    
    @Override
    public void playSound(final String llllllllllllllIllIIIllIlIlllIlII, final float llllllllllllllIllIIIllIlIlllIIll, final float llllllllllllllIllIIIllIlIlllIIlI) {
        this.worldObj.playSoundToNearExcept(this, llllllllllllllIllIIIllIlIlllIlII, llllllllllllllIllIIIllIlIlllIIll, llllllllllllllIllIIIllIlIlllIIlI);
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource llllllllllllllIllIIIllIIIllIlIlI, float llllllllllllllIllIIIllIIIllIlIIl) {
        if (this.func_180431_b(llllllllllllllIllIIIllIIIllIlIlI)) {
            return false;
        }
        if (this.capabilities.disableDamage && !llllllllllllllIllIIIllIIIllIlIlI.canHarmInCreative()) {
            return false;
        }
        this.entityAge = 0;
        if (this.getHealth() <= 0.0f) {
            return false;
        }
        if (this.isPlayerSleeping() && !this.worldObj.isRemote) {
            this.wakeUpPlayer(true, true, false);
        }
        if (llllllllllllllIllIIIllIIIllIlIlI.isDifficultyScaled()) {
            if (this.worldObj.getDifficulty() == EnumDifficulty.PEACEFUL) {
                llllllllllllllIllIIIllIIIllIlIIl = 0.0f;
            }
            if (this.worldObj.getDifficulty() == EnumDifficulty.EASY) {
                llllllllllllllIllIIIllIIIllIlIIl = llllllllllllllIllIIIllIIIllIlIIl / 2.0f + 1.0f;
            }
            if (this.worldObj.getDifficulty() == EnumDifficulty.HARD) {
                llllllllllllllIllIIIllIIIllIlIIl = llllllllllllllIllIIIllIIIllIlIIl * 3.0f / 2.0f;
            }
        }
        if (llllllllllllllIllIIIllIIIllIlIIl == 0.0f) {
            return false;
        }
        Entity llllllllllllllIllIIIllIIIllIllII = llllllllllllllIllIIIllIIIllIlIlI.getEntity();
        if (llllllllllllllIllIIIllIIIllIllII instanceof EntityArrow && ((EntityArrow)llllllllllllllIllIIIllIIIllIllII).shootingEntity != null) {
            llllllllllllllIllIIIllIIIllIllII = ((EntityArrow)llllllllllllllIllIIIllIIIllIllII).shootingEntity;
        }
        return super.attackEntityFrom(llllllllllllllIllIIIllIIIllIlIlI, (float)llllllllllllllIllIIIllIIIllIlIIl);
    }
    
    public float getBedOrientationInDegrees() {
        if (this.playerLocation != null) {
            final EnumFacing llllllllllllllIllIIIlIlllIIIlIIl = (EnumFacing)this.worldObj.getBlockState(this.playerLocation).getValue(BlockDirectional.AGE);
            switch (SwitchEnumFacing.field_179420_a[llllllllllllllIllIIIlIlllIIIlIIl.ordinal()]) {
                case 1: {
                    return 90.0f;
                }
                case 2: {
                    return 270.0f;
                }
                case 3: {
                    return 0.0f;
                }
                case 4: {
                    return 180.0f;
                }
            }
        }
        return 0.0f;
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, 0);
        this.dataWatcher.addObject(17, 0.0f);
        this.dataWatcher.addObject(18, 0);
        this.dataWatcher.addObject(10, 0);
    }
    
    public boolean canAttackPlayer(final EntityPlayer llllllllllllllIllIIIllIIIlIllllI) {
        final Team llllllllllllllIllIIIllIIIllIIIIl = this.getTeam();
        final Team llllllllllllllIllIIIllIIIllIIIII = llllllllllllllIllIIIllIIIlIllllI.getTeam();
        return llllllllllllllIllIIIllIIIllIIIIl == null || !llllllllllllllIllIIIllIIIllIIIIl.isSameTeam(llllllllllllllIllIIIllIIIllIIIII) || llllllllllllllIllIIIllIIIllIIIIl.getAllowFriendlyFire();
    }
    
    public void onEnchantmentCritical(final Entity llllllllllllllIllIIIlIllllIlllII) {
    }
    
    @Override
    public boolean isEntityInsideOpaqueBlock() {
        return !this.sleeping && super.isEntityInsideOpaqueBlock();
    }
    
    @Override
    protected void resetHeight() {
        if (!this.func_175149_v()) {
            super.resetHeight();
        }
    }
    
    @Override
    public void onUpdate() {
        this.noClip = this.func_175149_v();
        if (this.func_175149_v()) {
            this.onGround = false;
        }
        if (this.itemInUse != null) {
            final ItemStack llllllllllllllIllIIIllIllIIlIIll = this.inventory.getCurrentItem();
            if (llllllllllllllIllIIIllIllIIlIIll == this.itemInUse) {
                if (this.itemInUseCount <= 25 && this.itemInUseCount % 4 == 0) {
                    this.updateItemUse(llllllllllllllIllIIIllIllIIlIIll, 5);
                }
                if (--this.itemInUseCount == 0 && !this.worldObj.isRemote) {
                    this.onItemUseFinish();
                }
            }
            else {
                this.clearItemInUse();
            }
        }
        if (this.xpCooldown > 0) {
            --this.xpCooldown;
        }
        if (this.isPlayerSleeping()) {
            ++this.sleepTimer;
            if (this.sleepTimer > 100) {
                this.sleepTimer = 100;
            }
            if (!this.worldObj.isRemote) {
                if (!this.func_175143_p()) {
                    this.wakeUpPlayer(true, true, false);
                }
                else if (this.worldObj.isDaytime()) {
                    this.wakeUpPlayer(false, true, true);
                }
            }
        }
        else if (this.sleepTimer > 0) {
            ++this.sleepTimer;
            if (this.sleepTimer >= 110) {
                this.sleepTimer = 0;
            }
        }
        super.onUpdate();
        if (!this.worldObj.isRemote && this.openContainer != null && !this.openContainer.canInteractWith(this)) {
            this.closeScreen();
            this.openContainer = this.inventoryContainer;
        }
        if (this.isBurning() && this.capabilities.disableDamage) {
            this.extinguish();
        }
        this.field_71091_bM = this.field_71094_bP;
        this.field_71096_bN = this.field_71095_bQ;
        this.field_71097_bO = this.field_71085_bR;
        final double llllllllllllllIllIIIllIllIIlIIlI = this.posX - this.field_71094_bP;
        final double llllllllllllllIllIIIllIllIIlIIIl = this.posY - this.field_71095_bQ;
        final double llllllllllllllIllIIIllIllIIlIIII = this.posZ - this.field_71085_bR;
        final double llllllllllllllIllIIIllIllIIIllll = 10.0;
        if (llllllllllllllIllIIIllIllIIlIIlI > llllllllllllllIllIIIllIllIIIllll) {
            final double posX = this.posX;
            this.field_71094_bP = posX;
            this.field_71091_bM = posX;
        }
        if (llllllllllllllIllIIIllIllIIlIIII > llllllllllllllIllIIIllIllIIIllll) {
            final double posZ = this.posZ;
            this.field_71085_bR = posZ;
            this.field_71097_bO = posZ;
        }
        if (llllllllllllllIllIIIllIllIIlIIIl > llllllllllllllIllIIIllIllIIIllll) {
            final double posY = this.posY;
            this.field_71095_bQ = posY;
            this.field_71096_bN = posY;
        }
        if (llllllllllllllIllIIIllIllIIlIIlI < -llllllllllllllIllIIIllIllIIIllll) {
            final double posX2 = this.posX;
            this.field_71094_bP = posX2;
            this.field_71091_bM = posX2;
        }
        if (llllllllllllllIllIIIllIllIIlIIII < -llllllllllllllIllIIIllIllIIIllll) {
            final double posZ2 = this.posZ;
            this.field_71085_bR = posZ2;
            this.field_71097_bO = posZ2;
        }
        if (llllllllllllllIllIIIllIllIIlIIIl < -llllllllllllllIllIIIllIllIIIllll) {
            final double posY2 = this.posY;
            this.field_71095_bQ = posY2;
            this.field_71096_bN = posY2;
        }
        this.field_71094_bP += llllllllllllllIllIIIllIllIIlIIlI * 0.25;
        this.field_71085_bR += llllllllllllllIllIIIllIllIIlIIII * 0.25;
        this.field_71095_bQ += llllllllllllllIllIIIllIllIIlIIIl * 0.25;
        if (this.ridingEntity == null) {
            this.startMinecartRidingCoordinate = null;
        }
        if (!this.worldObj.isRemote) {
            this.foodStats.onUpdate(this);
            this.triggerAchievement(StatList.minutesPlayedStat);
            if (this.isEntityAlive()) {
                this.triggerAchievement(StatList.timeSinceDeathStat);
            }
        }
        final int llllllllllllllIllIIIllIllIIIlllI = 29999999;
        final double llllllllllllllIllIIIllIllIIIllIl = MathHelper.clamp_double(this.posX, -2.9999999E7, 2.9999999E7);
        final double llllllllllllllIllIIIllIllIIIllII = MathHelper.clamp_double(this.posZ, -2.9999999E7, 2.9999999E7);
        if (llllllllllllllIllIIIllIllIIIllIl != this.posX || llllllllllllllIllIIIllIllIIIllII != this.posZ) {
            this.setPosition(llllllllllllllIllIIIllIllIIIllIl, this.posY, llllllllllllllIllIIIllIllIIIllII);
        }
    }
    
    @Override
    protected boolean canTriggerWalking() {
        return !this.capabilities.isFlying;
    }
    
    public InventoryEnderChest getInventoryEnderChest() {
        return this.theInventoryEnderChest;
    }
    
    public int getItemInUseCount() {
        return this.itemInUseCount;
    }
    
    public void addExperience(int llllllllllllllIllIIIlIlIlllllIIl) {
        this.addScore(llllllllllllllIllIIIlIlIlllllIIl);
        final int llllllllllllllIllIIIlIlIlllllIll = Integer.MAX_VALUE - this.experienceTotal;
        if (llllllllllllllIllIIIlIlIlllllIIl > llllllllllllllIllIIIlIlIlllllIll) {
            llllllllllllllIllIIIlIlIlllllIIl = llllllllllllllIllIIIlIlIlllllIll;
        }
        this.experience += llllllllllllllIllIIIlIlIlllllIIl / (float)this.xpBarCap();
        this.experienceTotal += llllllllllllllIllIIIlIlIlllllIIl;
        while (this.experience >= 1.0f) {
            this.experience = (this.experience - 1.0f) * this.xpBarCap();
            this.addExperienceLevel(1);
            this.experience /= this.xpBarCap();
        }
    }
    
    @Override
    public void updateRidden() {
        if (!this.worldObj.isRemote && this.isSneaking()) {
            this.mountEntity(null);
            this.setSneaking(false);
        }
        else {
            final double llllllllllllllIllIIIllIlIlIIIIII = this.posX;
            final double llllllllllllllIllIIIllIlIIllllll = this.posY;
            final double llllllllllllllIllIIIllIlIIlllllI = this.posZ;
            final float llllllllllllllIllIIIllIlIIllllIl = this.rotationYaw;
            final float llllllllllllllIllIIIllIlIIllllII = this.rotationPitch;
            super.updateRidden();
            this.prevCameraYaw = this.cameraYaw;
            this.cameraYaw = 0.0f;
            this.addMountedMovementStat(this.posX - llllllllllllllIllIIIllIlIlIIIIII, this.posY - llllllllllllllIllIIIllIlIIllllll, this.posZ - llllllllllllllIllIIIllIlIIlllllI);
            if (this.ridingEntity instanceof EntityPig) {
                this.rotationPitch = llllllllllllllIllIIIllIlIIllllII;
                this.rotationYaw = llllllllllllllIllIIIllIlIIllllIl;
                this.renderYawOffset = ((EntityPig)this.ridingEntity).renderYawOffset;
            }
        }
    }
    
    public void preparePlayerToSpawn() {
        this.setSize(0.6f, 1.8f);
        super.preparePlayerToSpawn();
        this.setHealth(this.getMaxHealth());
        this.deathTime = 0;
    }
    
    public void stopUsingItem() {
        if (this.itemInUse != null) {
            this.itemInUse.onPlayerStoppedUsing(this.worldObj, this, this.itemInUseCount);
        }
        this.clearItemInUse();
    }
    
    public void func_146095_a(final CommandBlockLogic llllllllllllllIllIIIllIIIIlIlllI) {
    }
    
    @Override
    public void fall(final float llllllllllllllIllIIIlIllIIIllllI, final float llllllllllllllIllIIIlIllIIIllIlI) {
        if (!this.capabilities.allowFlying) {
            if (llllllllllllllIllIIIlIllIIIllllI >= 2.0f) {
                this.addStat(StatList.distanceFallenStat, (int)Math.round(llllllllllllllIllIIIlIllIIIllllI * 100.0));
            }
            super.fall(llllllllllllllIllIIIlIllIIIllllI, llllllllllllllIllIIIlIllIIIllIlI);
        }
    }
    
    public void addMovementStat(final double llllllllllllllIllIIIlIllIIllllIl, final double llllllllllllllIllIIIlIllIIllllII, final double llllllllllllllIllIIIlIllIIlllIll) {
        if (this.ridingEntity == null) {
            if (this.isInsideOfMaterial(Material.water)) {
                final int llllllllllllllIllIIIlIllIIlllIlI = Math.round(MathHelper.sqrt_double(llllllllllllllIllIIIlIllIIllllIl * llllllllllllllIllIIIlIllIIllllIl + llllllllllllllIllIIIlIllIIllllII * llllllllllllllIllIIIlIllIIllllII + llllllllllllllIllIIIlIllIIlllIll * llllllllllllllIllIIIlIllIIlllIll) * 100.0f);
                if (llllllllllllllIllIIIlIllIIlllIlI > 0) {
                    this.addStat(StatList.distanceDoveStat, llllllllllllllIllIIIlIllIIlllIlI);
                    this.addExhaustion(0.015f * llllllllllllllIllIIIlIllIIlllIlI * 0.01f);
                }
            }
            else if (this.isInWater()) {
                final int llllllllllllllIllIIIlIllIIlllIIl = Math.round(MathHelper.sqrt_double(llllllllllllllIllIIIlIllIIllllIl * llllllllllllllIllIIIlIllIIllllIl + llllllllllllllIllIIIlIllIIlllIll * llllllllllllllIllIIIlIllIIlllIll) * 100.0f);
                if (llllllllllllllIllIIIlIllIIlllIIl > 0) {
                    this.addStat(StatList.distanceSwumStat, llllllllllllllIllIIIlIllIIlllIIl);
                    this.addExhaustion(0.015f * llllllllllllllIllIIIlIllIIlllIIl * 0.01f);
                }
            }
            else if (this.isOnLadder()) {
                if (llllllllllllllIllIIIlIllIIllllII > 0.0) {
                    this.addStat(StatList.distanceClimbedStat, (int)Math.round(llllllllllllllIllIIIlIllIIllllII * 100.0));
                }
            }
            else if (this.onGround) {
                final int llllllllllllllIllIIIlIllIIlllIII = Math.round(MathHelper.sqrt_double(llllllllllllllIllIIIlIllIIllllIl * llllllllllllllIllIIIlIllIIllllIl + llllllllllllllIllIIIlIllIIlllIll * llllllllllllllIllIIIlIllIIlllIll) * 100.0f);
                if (llllllllllllllIllIIIlIllIIlllIII > 0) {
                    this.addStat(StatList.distanceWalkedStat, llllllllllllllIllIIIlIllIIlllIII);
                    if (this.isSprinting()) {
                        this.addStat(StatList.distanceSprintedStat, llllllllllllllIllIIIlIllIIlllIII);
                        this.addExhaustion(0.099999994f * llllllllllllllIllIIIlIllIIlllIII * 0.01f);
                    }
                    else {
                        if (this.isSneaking()) {
                            this.addStat(StatList.distanceCrouchedStat, llllllllllllllIllIIIlIllIIlllIII);
                        }
                        this.addExhaustion(0.01f * llllllllllllllIllIIIlIllIIlllIII * 0.01f);
                    }
                }
            }
            else {
                final int llllllllllllllIllIIIlIllIIllIlll = Math.round(MathHelper.sqrt_double(llllllllllllllIllIIIlIllIIllllIl * llllllllllllllIllIIIlIllIIllllIl + llllllllllllllIllIIIlIllIIlllIll * llllllllllllllIllIIIlIllIIlllIll) * 100.0f);
                if (llllllllllllllIllIIIlIllIIllIlll > 25) {
                    this.addStat(StatList.distanceFlownStat, llllllllllllllIllIIIlIllIIllIlll);
                }
            }
        }
    }
    
    public void displayVillagerTradeGui(final IMerchant llllllllllllllIllIIIllIIIIlIllII) {
    }
    
    public EntityItem dropPlayerItemWithRandomChoice(final ItemStack llllllllllllllIllIIIllIIlIllllll, final boolean llllllllllllllIllIIIllIIllIIIIIl) {
        return this.func_146097_a(llllllllllllllIllIIIllIIlIllllll, false, false);
    }
    
    public void respawnPlayer() {
    }
    
    @Override
    protected String getSwimSound() {
        return "game.player.swim";
    }
    
    @Override
    protected boolean isMovementBlocked() {
        return this.getHealth() <= 0.0f || this.isPlayerSleeping();
    }
    
    @Override
    public boolean isInvisibleToPlayer(final EntityPlayer llllllllllllllIllIIIlIlIIllllllI) {
        if (!this.isInvisible()) {
            return false;
        }
        if (llllllllllllllIllIIIlIlIIllllllI.func_175149_v()) {
            return false;
        }
        final Team llllllllllllllIllIIIlIlIIlllllIl = this.getTeam();
        return llllllllllllllIllIIIlIlIIlllllIl == null || llllllllllllllIllIIIlIlIIllllllI == null || llllllllllllllIllIIIlIlIIllllllI.getTeam() != llllllllllllllIllIIIlIlIIlllllIl || !llllllllllllllIllIIIlIlIIlllllIl.func_98297_h();
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound llllllllllllllIllIIIllIIIllllIII) {
        super.writeEntityToNBT(llllllllllllllIllIIIllIIIllllIII);
        llllllllllllllIllIIIllIIIllllIII.setTag("Inventory", this.inventory.writeToNBT(new NBTTagList()));
        llllllllllllllIllIIIllIIIllllIII.setInteger("SelectedItemSlot", this.inventory.currentItem);
        llllllllllllllIllIIIllIIIllllIII.setBoolean("Sleeping", this.sleeping);
        llllllllllllllIllIIIllIIIllllIII.setShort("SleepTimer", (short)this.sleepTimer);
        llllllllllllllIllIIIllIIIllllIII.setFloat("XpP", this.experience);
        llllllllllllllIllIIIllIIIllllIII.setInteger("XpLevel", this.experienceLevel);
        llllllllllllllIllIIIllIIIllllIII.setInteger("XpTotal", this.experienceTotal);
        llllllllllllllIllIIIllIIIllllIII.setInteger("XpSeed", this.field_175152_f);
        llllllllllllllIllIIIllIIIllllIII.setInteger("Score", this.getScore());
        if (this.spawnChunk != null) {
            llllllllllllllIllIIIllIIIllllIII.setInteger("SpawnX", this.spawnChunk.getX());
            llllllllllllllIllIIIllIIIllllIII.setInteger("SpawnY", this.spawnChunk.getY());
            llllllllllllllIllIIIllIIIllllIII.setInteger("SpawnZ", this.spawnChunk.getZ());
            llllllllllllllIllIIIllIIIllllIII.setBoolean("SpawnForced", this.spawnForced);
        }
        this.foodStats.writeNBT(llllllllllllllIllIIIllIIIllllIII);
        this.capabilities.writeCapabilitiesToNBT(llllllllllllllIllIIIllIIIllllIII);
        llllllllllllllIllIIIllIIIllllIII.setTag("EnderItems", this.theInventoryEnderChest.saveInventoryToNBT());
        final ItemStack llllllllllllllIllIIIllIIIlllIlll = this.inventory.getCurrentItem();
        if (llllllllllllllIllIIIllIIIlllIlll != null && llllllllllllllIllIIIllIIIlllIlll.getItem() != null) {
            llllllllllllllIllIIIllIIIllllIII.setTag("SelectedItem", llllllllllllllIllIIIllIIIlllIlll.writeToNBT(new NBTTagCompound()));
        }
    }
    
    public enum EnumStatus
    {
        OK("OK", 0, "OK", 0), 
        NOT_POSSIBLE_HERE("NOT_POSSIBLE_HERE", 1, "NOT_POSSIBLE_HERE", 1), 
        OTHER_PROBLEM("OTHER_PROBLEM", 4, "OTHER_PROBLEM", 4), 
        NOT_SAFE("NOT_SAFE", 5, "NOT_SAFE", 5), 
        TOO_FAR_AWAY("TOO_FAR_AWAY", 3, "TOO_FAR_AWAY", 3), 
        NOT_POSSIBLE_NOW("NOT_POSSIBLE_NOW", 2, "NOT_POSSIBLE_NOW", 2);
        
        static {
            __OBFID = "CL_00001712";
        }
        
        private EnumStatus(final String llllllllllllllllllIlIlIIllIllllI, final int llllllllllllllllllIlIlIIllIlllIl, final String llllllllllllllllllIlIlIIlllIIIIl, final int llllllllllllllllllIlIlIIlllIIIII) {
        }
    }
    
    public enum EnumChatVisibility
    {
        SYSTEM("SYSTEM", 1, "SYSTEM", 1, 1, "options.chat.visibility.system");
        
        private static final /* synthetic */ EnumChatVisibility[] field_151432_d;
        
        FULL("FULL", 0, "FULL", 0, 0, "options.chat.visibility.full");
        
        private final /* synthetic */ int chatVisibility;
        
        HIDDEN("HIDDEN", 2, "HIDDEN", 2, 2, "options.chat.visibility.hidden");
        
        private final /* synthetic */ String resourceKey;
        
        public static EnumChatVisibility getEnumChatVisibility(final int lllllllllllllllIlllIIIIllllllllI) {
            return EnumChatVisibility.field_151432_d[lllllllllllllllIlllIIIIllllllllI % EnumChatVisibility.field_151432_d.length];
        }
        
        public int getChatVisibility() {
            return this.chatVisibility;
        }
        
        static {
            __OBFID = "CL_00001714";
            field_151432_d = new EnumChatVisibility[values().length];
            for (final EnumChatVisibility lllllllllllllllIlllIIIlIIIIlIllI : values()) {
                EnumChatVisibility.field_151432_d[lllllllllllllllIlllIIIlIIIIlIllI.chatVisibility] = lllllllllllllllIlllIIIlIIIIlIllI;
            }
        }
        
        private EnumChatVisibility(final String lllllllllllllllIlllIIIlIIIIIIllI, final int lllllllllllllllIlllIIIlIIIIIIlIl, final String lllllllllllllllIlllIIIlIIIIIlIll, final int lllllllllllllllIlllIIIlIIIIIlIlI, final int lllllllllllllllIlllIIIlIIIIIIlII, final String lllllllllllllllIlllIIIlIIIIIIIll) {
            this.chatVisibility = lllllllllllllllIlllIIIlIIIIIIlII;
            this.resourceKey = lllllllllllllllIlllIIIlIIIIIIIll;
        }
        
        public String getResourceKey() {
            return this.resourceKey;
        }
    }
    
    static final class SwitchEnumFacing
    {
        static final /* synthetic */ int[] field_179420_a;
        
        static {
            __OBFID = "CL_00002188";
            field_179420_a = new int[EnumFacing.values().length];
            try {
                SwitchEnumFacing.field_179420_a[EnumFacing.SOUTH.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumFacing.field_179420_a[EnumFacing.NORTH.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumFacing.field_179420_a[EnumFacing.WEST.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchEnumFacing.field_179420_a[EnumFacing.EAST.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
        }
    }
}
