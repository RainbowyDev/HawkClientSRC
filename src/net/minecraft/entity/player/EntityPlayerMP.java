package net.minecraft.entity.player;

import net.minecraft.server.*;
import org.apache.logging.log4j.*;
import net.minecraft.potion.*;
import net.minecraft.entity.passive.*;
import net.minecraft.crash.*;
import io.netty.buffer.*;
import net.minecraft.network.*;
import net.minecraft.village.*;
import net.minecraft.world.biome.*;
import net.minecraft.stats.*;
import net.minecraft.scoreboard.*;
import net.minecraft.entity.*;
import net.minecraft.nbt.*;
import net.minecraft.block.material.*;
import net.minecraft.block.*;
import net.minecraft.inventory.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.item.*;
import net.minecraft.network.play.client.*;
import com.mojang.authlib.*;
import com.google.common.collect.*;
import net.minecraft.world.*;
import net.minecraft.world.chunk.*;
import net.minecraft.tileentity.*;
import java.util.*;
import net.minecraft.network.play.server.*;
import net.minecraft.server.management.*;

public class EntityPlayerMP extends EntityPlayer implements ICrafting
{
    public /* synthetic */ boolean isChangingQuantityOnly;
    private /* synthetic */ int lastExperience;
    public final /* synthetic */ ItemInWorldManager theItemInWorldManager;
    private /* synthetic */ Entity field_175401_bS;
    public /* synthetic */ boolean playerConqueredTheEnd;
    public final /* synthetic */ List loadedChunks;
    private /* synthetic */ String translator;
    private /* synthetic */ int lastFoodLevel;
    public /* synthetic */ NetHandlerPlayServer playerNetServerHandler;
    private /* synthetic */ int currentWindowId;
    private /* synthetic */ int respawnInvulnerabilityTicks;
    private /* synthetic */ float field_130068_bO;
    private /* synthetic */ boolean chatColours;
    private /* synthetic */ long playerLastActiveTime;
    private /* synthetic */ EnumChatVisibility chatVisibility;
    private /* synthetic */ float lastHealth;
    private final /* synthetic */ List destroyedItemsNetCache;
    public final /* synthetic */ MinecraftServer mcServer;
    private final /* synthetic */ StatisticsFile statsFile;
    private /* synthetic */ boolean wasHungry;
    
    public EnumChatVisibility getChatVisibility() {
        return this.chatVisibility;
    }
    
    static {
        __OBFID = "CL_00001440";
        logger = LogManager.getLogger();
    }
    
    @Override
    public void mountEntity(final Entity llllllllllllllllIIlllIlIIlIIlIlI) {
        final Entity llllllllllllllllIIlllIlIIlIIlIIl = this.ridingEntity;
        super.mountEntity(llllllllllllllllIIlllIlIIlIIlIlI);
        if (llllllllllllllllIIlllIlIIlIIlIlI != llllllllllllllllIIlllIlIIlIIlIIl) {
            this.playerNetServerHandler.sendPacket(new S1BPacketEntityAttach(0, this, this.ridingEntity));
            this.playerNetServerHandler.setPlayerLocation(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
        }
    }
    
    @Override
    public void func_175141_a(final TileEntitySign llllllllllllllllIIlllIlIIIlIIIlI) {
        llllllllllllllllIIlllIlIIIlIIIlI.func_145912_a(this);
        this.playerNetServerHandler.sendPacket(new S36PacketSignEditorOpen(llllllllllllllllIIlllIlIIIlIIIlI.getPos()));
    }
    
    @Override
    protected void onNewPotionEffect(final PotionEffect llllllllllllllllIIlllIIlIlIlllIl) {
        super.onNewPotionEffect(llllllllllllllllIIlllIIlIlIlllIl);
        this.playerNetServerHandler.sendPacket(new S1DPacketEntityEffect(this.getEntityId(), llllllllllllllllIIlllIIlIlIlllIl));
    }
    
    public void updateHeldItem() {
        if (!this.isChangingQuantityOnly) {
            this.playerNetServerHandler.sendPacket(new S2FPacketSetSlot(-1, -1, this.inventory.getItemStack()));
        }
    }
    
    @Override
    public void sendProgressBarUpdate(final Container llllllllllllllllIIlllIIlllIIIlIl, final int llllllllllllllllIIlllIIlllIIIlII, final int llllllllllllllllIIlllIIlllIIIIll) {
        this.playerNetServerHandler.sendPacket(new S31PacketWindowProperty(llllllllllllllllIIlllIIlllIIIlIl.windowId, llllllllllllllllIIlllIIlllIIIlII, llllllllllllllllIIlllIIlllIIIIll));
    }
    
    @Override
    public void clonePlayer(final EntityPlayer llllllllllllllllIIlllIIlIllIIlII, final boolean llllllllllllllllIIlllIIlIllIIIll) {
        super.clonePlayer(llllllllllllllllIIlllIIlIllIIlII, llllllllllllllllIIlllIIlIllIIIll);
        this.lastExperience = -1;
        this.lastHealth = -1.0f;
        this.lastFoodLevel = -1;
        this.destroyedItemsNetCache.addAll(((EntityPlayerMP)llllllllllllllllIIlllIIlIllIIlII).destroyedItemsNetCache);
    }
    
    @Override
    public void displayGUIHorse(final EntityHorse llllllllllllllllIIlllIIlllllIlII, final IInventory llllllllllllllllIIlllIIlllllIllI) {
        if (this.openContainer != this.inventoryContainer) {
            this.closeScreen();
        }
        this.getNextWindowId();
        this.playerNetServerHandler.sendPacket(new S2DPacketOpenWindow(this.currentWindowId, "EntityHorse", llllllllllllllllIIlllIIlllllIllI.getDisplayName(), llllllllllllllllIIlllIIlllllIllI.getSizeInventory(), llllllllllllllllIIlllIIlllllIlII.getEntityId()));
        this.openContainer = new ContainerHorseInventory(this.inventory, llllllllllllllllIIlllIIlllllIllI, llllllllllllllllIIlllIIlllllIlII, this);
        this.openContainer.windowId = this.currentWindowId;
        this.openContainer.onCraftGuiOpened(this);
    }
    
    public void onUpdateEntity() {
        try {
            super.onUpdate();
            for (int llllllllllllllllIIlllIlIllIlllIl = 0; llllllllllllllllIIlllIlIllIlllIl < this.inventory.getSizeInventory(); ++llllllllllllllllIIlllIlIllIlllIl) {
                final ItemStack llllllllllllllllIIlllIlIllIlllII = this.inventory.getStackInSlot(llllllllllllllllIIlllIlIllIlllIl);
                if (llllllllllllllllIIlllIlIllIlllII != null && llllllllllllllllIIlllIlIllIlllII.getItem().isMap()) {
                    final Packet llllllllllllllllIIlllIlIllIllIll = ((ItemMapBase)llllllllllllllllIIlllIlIllIlllII.getItem()).createMapDataPacket(llllllllllllllllIIlllIlIllIlllII, this.worldObj, this);
                    if (llllllllllllllllIIlllIlIllIllIll != null) {
                        this.playerNetServerHandler.sendPacket(llllllllllllllllIIlllIlIllIllIll);
                    }
                }
            }
            if (this.getHealth() != this.lastHealth || this.lastFoodLevel != this.foodStats.getFoodLevel() || this.foodStats.getSaturationLevel() == 0.0f != this.wasHungry) {
                this.playerNetServerHandler.sendPacket(new S06PacketUpdateHealth(this.getHealth(), this.foodStats.getFoodLevel(), this.foodStats.getSaturationLevel()));
                this.lastHealth = this.getHealth();
                this.lastFoodLevel = this.foodStats.getFoodLevel();
                this.wasHungry = (this.foodStats.getSaturationLevel() == 0.0f);
            }
            if (this.getHealth() + this.getAbsorptionAmount() != this.field_130068_bO) {
                this.field_130068_bO = this.getHealth() + this.getAbsorptionAmount();
                final Collection llllllllllllllllIIlllIlIllIllIlI = this.getWorldScoreboard().func_96520_a(IScoreObjectiveCriteria.health);
                for (final ScoreObjective llllllllllllllllIIlllIlIllIllIII : llllllllllllllllIIlllIlIllIllIlI) {
                    this.getWorldScoreboard().getValueFromObjective(this.getName(), llllllllllllllllIIlllIlIllIllIII).func_96651_a(Arrays.asList(this));
                }
            }
            if (this.experienceTotal != this.lastExperience) {
                this.lastExperience = this.experienceTotal;
                this.playerNetServerHandler.sendPacket(new S1FPacketSetExperience(this.experience, this.experienceTotal, this.experienceLevel));
            }
            if (this.ticksExisted % 20 * 5 == 0 && !this.getStatFile().hasAchievementUnlocked(AchievementList.exploreAllBiomes)) {
                this.func_147098_j();
            }
        }
        catch (Throwable llllllllllllllllIIlllIlIllIlIlll) {
            final CrashReport llllllllllllllllIIlllIlIllIlIllI = CrashReport.makeCrashReport(llllllllllllllllIIlllIlIllIlIlll, "Ticking player");
            final CrashReportCategory llllllllllllllllIIlllIlIllIlIlIl = llllllllllllllllIIlllIlIllIlIllI.makeCategory("Player being ticked");
            this.addEntityCrashInfo(llllllllllllllllIIlllIlIllIlIlIl);
            throw new ReportedException(llllllllllllllllIIlllIlIllIlIllI);
        }
    }
    
    @Override
    public void onItemPickup(final Entity llllllllllllllllIIlllIlIIllIlIll, final int llllllllllllllllIIlllIlIIllIlIlI) {
        super.onItemPickup(llllllllllllllllIIlllIlIIllIlIll, llllllllllllllllIIlllIlIIllIlIlI);
        this.openContainer.detectAndSendChanges();
    }
    
    @Override
    public void setPositionAndUpdate(final double llllllllllllllllIIlllIIlIlIIlIII, final double llllllllllllllllIIlllIIlIlIIIlll, final double llllllllllllllllIIlllIIlIlIIIllI) {
        this.playerNetServerHandler.setPlayerLocation(llllllllllllllllIIlllIIlIlIIlIII, llllllllllllllllIIlllIIlIlIIIlll, llllllllllllllllIIlllIIlIlIIIllI, this.rotationYaw, this.rotationPitch);
    }
    
    public void closeScreen() {
        this.playerNetServerHandler.sendPacket(new S2EPacketCloseWindow(this.openContainer.windowId));
        this.closeContainer();
    }
    
    @Override
    protected void onFinishedPotionEffect(final PotionEffect llllllllllllllllIIlllIIlIlIlIIII) {
        super.onFinishedPotionEffect(llllllllllllllllIIlllIIlIlIlIIII);
        this.playerNetServerHandler.sendPacket(new S1EPacketRemoveEntityEffect(this.getEntityId(), llllllllllllllllIIlllIIlIlIlIIII));
    }
    
    public void func_152339_d(final Entity llllllllllllllllIIlllIIIlllIlllI) {
        if (llllllllllllllllIIlllIIIlllIlllI instanceof EntityPlayer) {
            this.playerNetServerHandler.sendPacket(new S13PacketDestroyEntities(new int[] { llllllllllllllllIIlllIIIlllIlllI.getEntityId() }));
        }
        else {
            this.destroyedItemsNetCache.add(llllllllllllllllIIlllIIIlllIlllI.getEntityId());
        }
    }
    
    @Override
    public void displayVillagerTradeGui(final IMerchant llllllllllllllllIIlllIlIIIIIIIII) {
        this.getNextWindowId();
        this.openContainer = new ContainerMerchant(this.inventory, llllllllllllllllIIlllIlIIIIIIIII, this.worldObj);
        this.openContainer.windowId = this.currentWindowId;
        this.openContainer.onCraftGuiOpened(this);
        final InventoryMerchant llllllllllllllllIIlllIlIIIIIIlIl = ((ContainerMerchant)this.openContainer).getMerchantInventory();
        final IChatComponent llllllllllllllllIIlllIlIIIIIIlII = llllllllllllllllIIlllIlIIIIIIIII.getDisplayName();
        this.playerNetServerHandler.sendPacket(new S2DPacketOpenWindow(this.currentWindowId, "minecraft:villager", llllllllllllllllIIlllIlIIIIIIlII, llllllllllllllllIIlllIlIIIIIIlIl.getSizeInventory()));
        final MerchantRecipeList llllllllllllllllIIlllIlIIIIIIIll = llllllllllllllllIIlllIlIIIIIIIII.getRecipes(this);
        if (llllllllllllllllIIlllIlIIIIIIIll != null) {
            final PacketBuffer llllllllllllllllIIlllIlIIIIIIIlI = new PacketBuffer(Unpooled.buffer());
            llllllllllllllllIIlllIlIIIIIIIlI.writeInt(this.currentWindowId);
            llllllllllllllllIIlllIlIIIIIIIll.func_151391_a(llllllllllllllllIIlllIlIIIIIIIlI);
            this.playerNetServerHandler.sendPacket(new S3FPacketCustomPayload("MC|TrList", llllllllllllllllIIlllIlIIIIIIIlI));
        }
    }
    
    @Override
    public void travelToDimension(int llllllllllllllllIIlllIlIlIIIIIII) {
        if (this.dimension == 1 && llllllllllllllllIIlllIlIlIIIIIII == 1) {
            this.triggerAchievement(AchievementList.theEnd2);
            this.worldObj.removeEntity(this);
            this.playerConqueredTheEnd = true;
            this.playerNetServerHandler.sendPacket(new S2BPacketChangeGameState(4, 0.0f));
        }
        else {
            if (this.dimension == 0 && llllllllllllllllIIlllIlIlIIIIIII == 1) {
                this.triggerAchievement(AchievementList.theEnd);
                final BlockPos llllllllllllllllIIlllIlIlIIIIIlI = this.mcServer.worldServerForDimension((int)llllllllllllllllIIlllIlIlIIIIIII).func_180504_m();
                if (llllllllllllllllIIlllIlIlIIIIIlI != null) {
                    this.playerNetServerHandler.setPlayerLocation(llllllllllllllllIIlllIlIlIIIIIlI.getX(), llllllllllllllllIIlllIlIlIIIIIlI.getY(), llllllllllllllllIIlllIlIlIIIIIlI.getZ(), 0.0f, 0.0f);
                }
                llllllllllllllllIIlllIlIlIIIIIII = 1;
            }
            else {
                this.triggerAchievement(AchievementList.portal);
            }
            this.mcServer.getConfigurationManager().transferPlayerToDimension(this, (int)llllllllllllllllIIlllIlIlIIIIIII);
            this.lastExperience = -1;
            this.lastHealth = -1.0f;
            this.lastFoodLevel = -1;
        }
    }
    
    protected void func_147098_j() {
        final BiomeGenBase llllllllllllllllIIlllIlIllIIIllI = this.worldObj.getBiomeGenForCoords(new BlockPos(MathHelper.floor_double(this.posX), 0, MathHelper.floor_double(this.posZ)));
        final String llllllllllllllllIIlllIlIllIIIlIl = llllllllllllllllIIlllIlIllIIIllI.biomeName;
        JsonSerializableSet llllllllllllllllIIlllIlIllIIIlII = (JsonSerializableSet)this.getStatFile().func_150870_b(AchievementList.exploreAllBiomes);
        if (llllllllllllllllIIlllIlIllIIIlII == null) {
            llllllllllllllllIIlllIlIllIIIlII = (JsonSerializableSet)this.getStatFile().func_150872_a(AchievementList.exploreAllBiomes, new JsonSerializableSet());
        }
        llllllllllllllllIIlllIlIllIIIlII.add((Object)llllllllllllllllIIlllIlIllIIIlIl);
        if (this.getStatFile().canUnlockAchievement(AchievementList.exploreAllBiomes) && llllllllllllllllIIlllIlIllIIIlII.size() >= BiomeGenBase.explorationBiomesList.size()) {
            final HashSet llllllllllllllllIIlllIlIllIIIIll = Sets.newHashSet((Iterable)BiomeGenBase.explorationBiomesList);
            for (final String llllllllllllllllIIlllIlIllIIIIIl : llllllllllllllllIIlllIlIllIIIlII) {
                final Iterator llllllllllllllllIIlllIlIllIIIIII = llllllllllllllllIIlllIlIllIIIIll.iterator();
                while (llllllllllllllllIIlllIlIllIIIIII.hasNext()) {
                    final BiomeGenBase llllllllllllllllIIlllIlIlIllllll = llllllllllllllllIIlllIlIllIIIIII.next();
                    if (llllllllllllllllIIlllIlIlIllllll.biomeName.equals(llllllllllllllllIIlllIlIllIIIIIl)) {
                        llllllllllllllllIIlllIlIllIIIIII.remove();
                    }
                }
                if (llllllllllllllllIIlllIlIllIIIIll.isEmpty()) {
                    break;
                }
            }
            if (llllllllllllllllIIlllIlIllIIIIll.isEmpty()) {
                this.triggerAchievement(AchievementList.exploreAllBiomes);
            }
        }
    }
    
    @Override
    public void onDeath(final DamageSource llllllllllllllllIIlllIlIlIlIllll) {
        if (this.worldObj.getGameRules().getGameRuleBooleanValue("showDeathMessages")) {
            final Team llllllllllllllllIIlllIlIlIlIlllI = this.getTeam();
            if (llllllllllllllllIIlllIlIlIlIlllI != null && llllllllllllllllIIlllIlIlIlIlllI.func_178771_j() != Team.EnumVisible.ALWAYS) {
                if (llllllllllllllllIIlllIlIlIlIlllI.func_178771_j() == Team.EnumVisible.HIDE_FOR_OTHER_TEAMS) {
                    this.mcServer.getConfigurationManager().func_177453_a(this, this.getCombatTracker().func_151521_b());
                }
                else if (llllllllllllllllIIlllIlIlIlIlllI.func_178771_j() == Team.EnumVisible.HIDE_FOR_OWN_TEAM) {
                    this.mcServer.getConfigurationManager().func_177452_b(this, this.getCombatTracker().func_151521_b());
                }
            }
            else {
                this.mcServer.getConfigurationManager().sendChatMsg(this.getCombatTracker().func_151521_b());
            }
        }
        if (!this.worldObj.getGameRules().getGameRuleBooleanValue("keepInventory")) {
            this.inventory.dropAllItems();
        }
        final Collection llllllllllllllllIIlllIlIlIlIllIl = this.worldObj.getScoreboard().func_96520_a(IScoreObjectiveCriteria.deathCount);
        for (final ScoreObjective llllllllllllllllIIlllIlIlIlIlIll : llllllllllllllllIIlllIlIlIlIllIl) {
            final Score llllllllllllllllIIlllIlIlIlIlIlI = this.getWorldScoreboard().getValueFromObjective(this.getName(), llllllllllllllllIIlllIlIlIlIlIll);
            llllllllllllllllIIlllIlIlIlIlIlI.func_96648_a();
        }
        final EntityLivingBase llllllllllllllllIIlllIlIlIlIlIIl = this.func_94060_bK();
        if (llllllllllllllllIIlllIlIlIlIlIIl != null) {
            final EntityList.EntityEggInfo llllllllllllllllIIlllIlIlIlIlIII = EntityList.entityEggs.get(EntityList.getEntityID(llllllllllllllllIIlllIlIlIlIlIIl));
            if (llllllllllllllllIIlllIlIlIlIlIII != null) {
                this.triggerAchievement(llllllllllllllllIIlllIlIlIlIlIII.field_151513_e);
            }
            llllllllllllllllIIlllIlIlIlIlIIl.addToPlayerScore(this, this.scoreValue);
        }
        this.triggerAchievement(StatList.deathsStat);
        this.func_175145_a(StatList.timeSinceDeathStat);
        this.getCombatTracker().func_94549_h();
    }
    
    public void sendContainerToPlayer(final Container llllllllllllllllIIlllIIlllIllIII) {
        this.updateCraftingInventory(llllllllllllllllIIlllIIlllIllIII, llllllllllllllllIIlllIIlllIllIII.getInventory());
    }
    
    @Override
    public void addChatComponentMessage(final IChatComponent llllllllllllllllIIlllIIlIllllIII) {
        this.playerNetServerHandler.sendPacket(new S02PacketChat(llllllllllllllllIIlllIIlIllllIII));
    }
    
    @Override
    public EnumStatus func_180469_a(final BlockPos llllllllllllllllIIlllIlIIllIIIIl) {
        final EnumStatus llllllllllllllllIIlllIlIIllIIIII = super.func_180469_a(llllllllllllllllIIlllIlIIllIIIIl);
        if (llllllllllllllllIIlllIlIIllIIIII == EnumStatus.OK) {
            final S0APacketUseBed llllllllllllllllIIlllIlIIlIlllll = new S0APacketUseBed(this, llllllllllllllllIIlllIlIIllIIIIl);
            this.getServerForPlayer().getEntityTracker().sendToAllTrackingEntity(this, llllllllllllllllIIlllIlIIlIlllll);
            this.playerNetServerHandler.setPlayerLocation(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
            this.playerNetServerHandler.sendPacket(llllllllllllllllIIlllIlIIlIlllll);
        }
        return llllllllllllllllIIlllIlIIllIIIII;
    }
    
    @Override
    public boolean func_175149_v() {
        return this.theItemInWorldManager.getGameType() == WorldSettings.GameType.SPECTATOR;
    }
    
    @Override
    public void sendSlotContents(final Container llllllllllllllllIIlllIIllllIIlII, final int llllllllllllllllIIlllIIlllIlllll, final ItemStack llllllllllllllllIIlllIIlllIllllI) {
        if (!(llllllllllllllllIIlllIIllllIIlII.getSlot(llllllllllllllllIIlllIIlllIlllll) instanceof SlotCrafting) && !this.isChangingQuantityOnly) {
            this.playerNetServerHandler.sendPacket(new S2FPacketSetSlot(llllllllllllllllIIlllIIllllIIlII.windowId, llllllllllllllllIIlllIIlllIlllll, llllllllllllllllIIlllIIlllIllllI));
        }
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound llllllllllllllllIIlllIllIIIlllII) {
        super.readEntityFromNBT(llllllllllllllllIIlllIllIIIlllII);
        if (llllllllllllllllIIlllIllIIIlllII.hasKey("playerGameType", 99)) {
            if (MinecraftServer.getServer().getForceGamemode()) {
                this.theItemInWorldManager.setGameType(MinecraftServer.getServer().getGameType());
            }
            else {
                this.theItemInWorldManager.setGameType(WorldSettings.GameType.getByID(llllllllllllllllIIlllIllIIIlllII.getInteger("playerGameType")));
            }
        }
    }
    
    @Override
    public void addExperienceLevel(final int llllllllllllllllIIlllIllIIIlIIII) {
        super.addExperienceLevel(llllllllllllllllIIlllIllIIIlIIII);
        this.lastExperience = -1;
    }
    
    @Override
    public void func_175145_a(final StatBase llllllllllllllllIIlllIIllIIIlIlI) {
        if (llllllllllllllllIIlllIIllIIIlIlI != null) {
            this.statsFile.func_150873_a(this, llllllllllllllllIIlllIIllIIIlIlI, 0);
            for (final ScoreObjective llllllllllllllllIIlllIIllIIIlIII : this.getWorldScoreboard().func_96520_a(llllllllllllllllIIlllIIllIIIlIlI.func_150952_k())) {
                this.getWorldScoreboard().getValueFromObjective(this.getName(), llllllllllllllllIIlllIIllIIIlIII).setScorePoints(0);
            }
            if (this.statsFile.func_150879_e()) {
                this.statsFile.func_150876_a(this);
            }
        }
    }
    
    public void mountEntityAndWakeUp() {
        if (this.riddenByEntity != null) {
            this.riddenByEntity.mountEntity(this);
        }
        if (this.sleeping) {
            this.wakeUpPlayer(true, false, false);
        }
    }
    
    public void handleFalling(final double llllllllllllllllIIlllIlIIIllIllI, final boolean llllllllllllllllIIlllIlIIIlIllII) {
        final int llllllllllllllllIIlllIlIIIllIlII = MathHelper.floor_double(this.posX);
        final int llllllllllllllllIIlllIlIIIllIIll = MathHelper.floor_double(this.posY - 0.20000000298023224);
        final int llllllllllllllllIIlllIlIIIllIIlI = MathHelper.floor_double(this.posZ);
        BlockPos llllllllllllllllIIlllIlIIIllIIIl = new BlockPos(llllllllllllllllIIlllIlIIIllIlII, llllllllllllllllIIlllIlIIIllIIll, llllllllllllllllIIlllIlIIIllIIlI);
        Block llllllllllllllllIIlllIlIIIllIIII = this.worldObj.getBlockState(llllllllllllllllIIlllIlIIIllIIIl).getBlock();
        if (llllllllllllllllIIlllIlIIIllIIII.getMaterial() == Material.air) {
            final Block llllllllllllllllIIlllIlIIIlIllll = this.worldObj.getBlockState(llllllllllllllllIIlllIlIIIllIIIl.offsetDown()).getBlock();
            if (llllllllllllllllIIlllIlIIIlIllll instanceof BlockFence || llllllllllllllllIIlllIlIIIlIllll instanceof BlockWall || llllllllllllllllIIlllIlIIIlIllll instanceof BlockFenceGate) {
                llllllllllllllllIIlllIlIIIllIIIl = llllllllllllllllIIlllIlIIIllIIIl.offsetDown();
                llllllllllllllllIIlllIlIIIllIIII = this.worldObj.getBlockState(llllllllllllllllIIlllIlIIIllIIIl).getBlock();
            }
        }
        super.func_180433_a(llllllllllllllllIIlllIlIIIllIllI, llllllllllllllllIIlllIlIIIlIllII, llllllllllllllllIIlllIlIIIllIIII, llllllllllllllllIIlllIlIIIllIIIl);
    }
    
    private void getNextWindowId() {
        this.currentWindowId = this.currentWindowId % 100 + 1;
    }
    
    public void setPlayerHealthUpdated() {
        this.lastHealth = -1.0E8f;
    }
    
    @Override
    public boolean canAttackPlayer(final EntityPlayer llllllllllllllllIIlllIlIlIIIlIll) {
        return this.func_175400_cq() && super.canAttackPlayer(llllllllllllllllIIlllIlIlIIIlIll);
    }
    
    @Override
    public void displayGUIChest(final IInventory llllllllllllllllIIlllIlIIIIlIIlI) {
        if (this.openContainer != this.inventoryContainer) {
            this.closeScreen();
        }
        if (llllllllllllllllIIlllIlIIIIlIIlI instanceof ILockableContainer) {
            final ILockableContainer llllllllllllllllIIlllIlIIIIlIIIl = (ILockableContainer)llllllllllllllllIIlllIlIIIIlIIlI;
            if (llllllllllllllllIIlllIlIIIIlIIIl.isLocked() && !this.func_175146_a(llllllllllllllllIIlllIlIIIIlIIIl.getLockCode()) && !this.func_175149_v()) {
                this.playerNetServerHandler.sendPacket(new S02PacketChat(new ChatComponentTranslation("container.isLocked", new Object[] { llllllllllllllllIIlllIlIIIIlIIlI.getDisplayName() }), (byte)2));
                this.playerNetServerHandler.sendPacket(new S29PacketSoundEffect("random.door_close", this.posX, this.posY, this.posZ, 1.0f, 1.0f));
                return;
            }
        }
        this.getNextWindowId();
        if (llllllllllllllllIIlllIlIIIIlIIlI instanceof IInteractionObject) {
            this.playerNetServerHandler.sendPacket(new S2DPacketOpenWindow(this.currentWindowId, ((IInteractionObject)llllllllllllllllIIlllIlIIIIlIIlI).getGuiID(), llllllllllllllllIIlllIlIIIIlIIlI.getDisplayName(), llllllllllllllllIIlllIlIIIIlIIlI.getSizeInventory()));
            this.openContainer = ((IInteractionObject)llllllllllllllllIIlllIlIIIIlIIlI).createContainer(this.inventory, this);
        }
        else {
            this.playerNetServerHandler.sendPacket(new S2DPacketOpenWindow(this.currentWindowId, "minecraft:container", llllllllllllllllIIlllIlIIIIlIIlI.getDisplayName(), llllllllllllllllIIlllIlIIIIlIIlI.getSizeInventory()));
            this.openContainer = new ContainerChest(this.inventory, llllllllllllllllIIlllIlIIIIlIIlI, this);
        }
        this.openContainer.windowId = this.currentWindowId;
        this.openContainer.onCraftGuiOpened(this);
    }
    
    @Override
    protected void func_180433_a(final double llllllllllllllllIIlllIlIIlIIIlII, final boolean llllllllllllllllIIlllIlIIlIIIIll, final Block llllllllllllllllIIlllIlIIlIIIIlI, final BlockPos llllllllllllllllIIlllIlIIlIIIIIl) {
    }
    
    public WorldServer getServerForPlayer() {
        return (WorldServer)this.worldObj;
    }
    
    @Override
    public void wakeUpPlayer(final boolean llllllllllllllllIIlllIlIIlIlIIIl, final boolean llllllllllllllllIIlllIlIIlIlIlII, final boolean llllllllllllllllIIlllIlIIlIIllll) {
        if (this.isPlayerSleeping()) {
            this.getServerForPlayer().getEntityTracker().func_151248_b(this, new S0BPacketAnimation(this, 2));
        }
        super.wakeUpPlayer(llllllllllllllllIIlllIlIIlIlIIIl, llllllllllllllllIIlllIlIIlIlIlII, llllllllllllllllIIlllIlIIlIIllll);
        if (this.playerNetServerHandler != null) {
            this.playerNetServerHandler.setPlayerLocation(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
        }
    }
    
    @Override
    public void func_152112_bu() {
        super.func_152112_bu();
        this.playerNetServerHandler.sendPacket(new S42PacketCombatEvent(this.getCombatTracker(), S42PacketCombatEvent.Event.END_COMBAT));
    }
    
    @Override
    public BlockPos getPosition() {
        return new BlockPos(this.posX, this.posY + 0.5, this.posZ);
    }
    
    public void setEntityActionState(final float llllllllllllllllIIlllIIllIlIIIlI, final float llllllllllllllllIIlllIIllIlIIIIl, final boolean llllllllllllllllIIlllIIllIlIIlIl, final boolean llllllllllllllllIIlllIIllIlIIlII) {
        if (this.ridingEntity != null) {
            if (llllllllllllllllIIlllIIllIlIIIlI >= -1.0f && llllllllllllllllIIlllIIllIlIIIlI <= 1.0f) {
                this.moveStrafing = llllllllllllllllIIlllIIllIlIIIlI;
            }
            if (llllllllllllllllIIlllIIllIlIIIIl >= -1.0f && llllllllllllllllIIlllIIllIlIIIIl <= 1.0f) {
                this.moveForward = llllllllllllllllIIlllIIllIlIIIIl;
            }
            this.isJumping = llllllllllllllllIIlllIIllIlIIlIl;
            this.setSneaking(llllllllllllllllIIlllIIllIlIIlII);
        }
    }
    
    public void closeContainer() {
        this.openContainer.onContainerClosed(this);
        this.openContainer = this.inventoryContainer;
    }
    
    @Override
    public void displayGUIBook(final ItemStack llllllllllllllllIIlllIIllllIlIll) {
        final Item llllllllllllllllIIlllIIllllIllIl = llllllllllllllllIIlllIIllllIlIll.getItem();
        if (llllllllllllllllIIlllIIllllIllIl == Items.written_book) {
            this.playerNetServerHandler.sendPacket(new S3FPacketCustomPayload("MC|BOpen", new PacketBuffer(Unpooled.buffer())));
        }
    }
    
    public StatisticsFile getStatFile() {
        return this.statsFile;
    }
    
    @Override
    public void setGameType(final WorldSettings.GameType llllllllllllllllIIlllIIlIIlIlIlI) {
        this.theItemInWorldManager.setGameType(llllllllllllllllIIlllIIlIIlIlIlI);
        this.playerNetServerHandler.sendPacket(new S2BPacketChangeGameState(3, (float)llllllllllllllllIIlllIIlIIlIlIlI.getID()));
        if (llllllllllllllllIIlllIIlIIlIlIlI == WorldSettings.GameType.SPECTATOR) {
            this.mountEntity(null);
        }
        else {
            this.func_175399_e(this);
        }
        this.sendPlayerAbilities();
        this.func_175136_bO();
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource llllllllllllllllIIlllIlIlIIllIll, final float llllllllllllllllIIlllIlIlIIllIlI) {
        if (this.func_180431_b(llllllllllllllllIIlllIlIlIIllIll)) {
            return false;
        }
        final boolean llllllllllllllllIIlllIlIlIIllIIl = this.mcServer.isDedicatedServer() && this.func_175400_cq() && "fall".equals(llllllllllllllllIIlllIlIlIIllIll.damageType);
        if (!llllllllllllllllIIlllIlIlIIllIIl && this.respawnInvulnerabilityTicks > 0 && llllllllllllllllIIlllIlIlIIllIll != DamageSource.outOfWorld) {
            return false;
        }
        if (llllllllllllllllIIlllIlIlIIllIll instanceof EntityDamageSource) {
            final Entity llllllllllllllllIIlllIlIlIIllIII = llllllllllllllllIIlllIlIlIIllIll.getEntity();
            if (llllllllllllllllIIlllIlIlIIllIII instanceof EntityPlayer && !this.canAttackPlayer((EntityPlayer)llllllllllllllllIIlllIlIlIIllIII)) {
                return false;
            }
            if (llllllllllllllllIIlllIlIlIIllIII instanceof EntityArrow) {
                final EntityArrow llllllllllllllllIIlllIlIlIIlIlll = (EntityArrow)llllllllllllllllIIlllIlIlIIllIII;
                if (llllllllllllllllIIlllIlIlIIlIlll.shootingEntity instanceof EntityPlayer && !this.canAttackPlayer((EntityPlayer)llllllllllllllllIIlllIlIlIIlIlll.shootingEntity)) {
                    return false;
                }
            }
        }
        return super.attackEntityFrom(llllllllllllllllIIlllIlIlIIllIll, llllllllllllllllIIlllIlIlIIllIlI);
    }
    
    @Override
    public void updateCraftingInventory(final Container llllllllllllllllIIlllIIlllIlIIll, final List llllllllllllllllIIlllIIlllIIllll) {
        this.playerNetServerHandler.sendPacket(new S30PacketWindowItems(llllllllllllllllIIlllIIlllIlIIll.windowId, llllllllllllllllIIlllIIlllIIllll));
        this.playerNetServerHandler.sendPacket(new S2FPacketSetSlot(-1, -1, this.inventory.getItemStack()));
    }
    
    public void func_175397_a(final String llllllllllllllllIIlllIIIlllllllI, final String llllllllllllllllIIlllIIIllllllIl) {
        this.playerNetServerHandler.sendPacket(new S48PacketResourcePackSend(llllllllllllllllIIlllIIIlllllllI, llllllllllllllllIIlllIIIllllllIl));
    }
    
    @Override
    public void setItemInUse(final ItemStack llllllllllllllllIIlllIIlIllIllIl, final int llllllllllllllllIIlllIIlIllIllII) {
        super.setItemInUse(llllllllllllllllIIlllIIlIllIllIl, llllllllllllllllIIlllIIlIllIllII);
        if (llllllllllllllllIIlllIIlIllIllIl != null && llllllllllllllllIIlllIIlIllIllIl.getItem() != null && llllllllllllllllIIlllIIlIllIllIl.getItem().getItemUseAction(llllllllllllllllIIlllIIlIllIllIl) == EnumAction.EAT) {
            this.getServerForPlayer().getEntityTracker().func_151248_b(this, new S0BPacketAnimation(this, 3));
        }
    }
    
    @Override
    protected void func_175135_B() {
        if (this.func_175149_v()) {
            this.func_175133_bi();
            this.setInvisible(true);
        }
        else {
            super.func_175135_B();
        }
        this.getServerForPlayer().getEntityTracker().func_180245_a(this);
    }
    
    public void addSelfToInternalCraftingInventory() {
        this.openContainer.onCraftGuiOpened(this);
    }
    
    public IChatComponent func_175396_E() {
        return null;
    }
    
    @Override
    protected void onItemUseFinish() {
        this.playerNetServerHandler.sendPacket(new S19PacketEntityStatus(this, (byte)9));
        super.onItemUseFinish();
    }
    
    @Override
    public void func_175173_a(final Container llllllllllllllllIIlllIIllIlllIIl, final IInventory llllllllllllllllIIlllIIllIllllII) {
        for (int llllllllllllllllIIlllIIllIlllIll = 0; llllllllllllllllIIlllIIllIlllIll < llllllllllllllllIIlllIIllIllllII.getFieldCount(); ++llllllllllllllllIIlllIIllIlllIll) {
            this.playerNetServerHandler.sendPacket(new S31PacketWindowProperty(llllllllllllllllIIlllIIllIlllIIl.windowId, llllllllllllllllIIlllIIllIlllIll, llllllllllllllllIIlllIIllIllllII.getField(llllllllllllllllIIlllIIllIlllIll)));
        }
    }
    
    public void func_175399_e(final Entity llllllllllllllllIIlllIIIlllIIIII) {
        final Entity llllllllllllllllIIlllIIIlllIIIlI = this.func_175398_C();
        this.field_175401_bS = ((llllllllllllllllIIlllIIIlllIIIII == null) ? this : llllllllllllllllIIlllIIIlllIIIII);
        if (llllllllllllllllIIlllIIIlllIIIlI != this.field_175401_bS) {
            this.playerNetServerHandler.sendPacket(new S43PacketCamera(this.field_175401_bS));
            this.setPositionAndUpdate(this.field_175401_bS.posX, this.field_175401_bS.posY, this.field_175401_bS.posZ);
        }
    }
    
    public void handleClientSettings(final C15PacketClientSettings llllllllllllllllIIlllIIlIIIIlIIl) {
        this.translator = llllllllllllllllIIlllIIlIIIIlIIl.getLang();
        this.chatVisibility = llllllllllllllllIIlllIIlIIIIlIIl.getChatVisibility();
        this.chatColours = llllllllllllllllIIlllIIlIIIIlIIl.isColorsEnabled();
        this.getDataWatcher().updateObject(10, (byte)llllllllllllllllIIlllIIlIIIIlIIl.getView());
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound llllllllllllllllIIlllIllIIIlIllI) {
        super.writeEntityToNBT(llllllllllllllllIIlllIllIIIlIllI);
        llllllllllllllllIIlllIllIIIlIllI.setInteger("playerGameType", this.theItemInWorldManager.getGameType().getID());
    }
    
    public EntityPlayerMP(final MinecraftServer llllllllllllllllIIlllIllIIlIIllI, final WorldServer llllllllllllllllIIlllIllIIlIllIl, final GameProfile llllllllllllllllIIlllIllIIlIIlII, final ItemInWorldManager llllllllllllllllIIlllIllIIlIlIll) {
        super(llllllllllllllllIIlllIllIIlIllIl, llllllllllllllllIIlllIllIIlIIlII);
        this.translator = "en_US";
        this.loadedChunks = Lists.newLinkedList();
        this.destroyedItemsNetCache = Lists.newLinkedList();
        this.field_130068_bO = Float.MIN_VALUE;
        this.lastHealth = -1.0E8f;
        this.lastFoodLevel = -99999999;
        this.wasHungry = true;
        this.lastExperience = -99999999;
        this.respawnInvulnerabilityTicks = 60;
        this.chatColours = true;
        this.playerLastActiveTime = System.currentTimeMillis();
        this.field_175401_bS = null;
        llllllllllllllllIIlllIllIIlIlIll.thisPlayerMP = this;
        this.theItemInWorldManager = llllllllllllllllIIlllIllIIlIlIll;
        BlockPos llllllllllllllllIIlllIllIIlIlIlI = llllllllllllllllIIlllIllIIlIllIl.getSpawnPoint();
        if (!llllllllllllllllIIlllIllIIlIllIl.provider.getHasNoSky() && llllllllllllllllIIlllIllIIlIllIl.getWorldInfo().getGameType() != WorldSettings.GameType.ADVENTURE) {
            int llllllllllllllllIIlllIllIIlIlIIl = Math.max(5, llllllllllllllllIIlllIllIIlIIllI.getSpawnProtectionSize() - 6);
            final int llllllllllllllllIIlllIllIIlIlIII = MathHelper.floor_double(llllllllllllllllIIlllIllIIlIllIl.getWorldBorder().getClosestDistance(llllllllllllllllIIlllIllIIlIlIlI.getX(), llllllllllllllllIIlllIllIIlIlIlI.getZ()));
            if (llllllllllllllllIIlllIllIIlIlIII < llllllllllllllllIIlllIllIIlIlIIl) {
                llllllllllllllllIIlllIllIIlIlIIl = llllllllllllllllIIlllIllIIlIlIII;
            }
            if (llllllllllllllllIIlllIllIIlIlIII <= 1) {
                llllllllllllllllIIlllIllIIlIlIIl = 1;
            }
            llllllllllllllllIIlllIllIIlIlIlI = llllllllllllllllIIlllIllIIlIllIl.func_175672_r(llllllllllllllllIIlllIllIIlIlIlI.add(this.rand.nextInt(llllllllllllllllIIlllIllIIlIlIIl * 2) - llllllllllllllllIIlllIllIIlIlIIl, 0, this.rand.nextInt(llllllllllllllllIIlllIllIIlIlIIl * 2) - llllllllllllllllIIlllIllIIlIlIIl));
        }
        this.mcServer = llllllllllllllllIIlllIllIIlIIllI;
        this.statsFile = llllllllllllllllIIlllIllIIlIIllI.getConfigurationManager().getPlayerStatsFile(this);
        this.stepHeight = 0.0f;
        this.func_174828_a(llllllllllllllllIIlllIllIIlIlIlI, 0.0f, 0.0f);
        while (!llllllllllllllllIIlllIllIIlIllIl.getCollidingBoundingBoxes(this, this.getEntityBoundingBox()).isEmpty() && this.posY < 255.0) {
            this.setPosition(this.posX, this.posY + 1.0, this.posZ);
        }
    }
    
    @Override
    public void attackTargetEntityWithCurrentItem(final Entity llllllllllllllllIIlllIIIllIllIIl) {
        if (this.theItemInWorldManager.getGameType() == WorldSettings.GameType.SPECTATOR) {
            this.func_175399_e(llllllllllllllllIIlllIIIllIllIIl);
        }
        else {
            super.attackTargetEntityWithCurrentItem(llllllllllllllllIIlllIIIllIllIIl);
        }
    }
    
    @Override
    public void onUpdate() {
        this.theItemInWorldManager.updateBlockRemoving();
        --this.respawnInvulnerabilityTicks;
        if (this.hurtResistantTime > 0) {
            --this.hurtResistantTime;
        }
        this.openContainer.detectAndSendChanges();
        if (!this.worldObj.isRemote && !this.openContainer.canInteractWith(this)) {
            this.closeScreen();
            this.openContainer = this.inventoryContainer;
        }
        while (!this.destroyedItemsNetCache.isEmpty()) {
            final int llllllllllllllllIIlllIlIllllIllI = Math.min(this.destroyedItemsNetCache.size(), Integer.MAX_VALUE);
            final int[] llllllllllllllllIIlllIlIllllIlIl = new int[llllllllllllllllIIlllIlIllllIllI];
            final Iterator llllllllllllllllIIlllIlIllllIlII = this.destroyedItemsNetCache.iterator();
            int llllllllllllllllIIlllIlIllllIIll = 0;
            while (llllllllllllllllIIlllIlIllllIlII.hasNext() && llllllllllllllllIIlllIlIllllIIll < llllllllllllllllIIlllIlIllllIllI) {
                llllllllllllllllIIlllIlIllllIlIl[llllllllllllllllIIlllIlIllllIIll++] = llllllllllllllllIIlllIlIllllIlII.next();
                llllllllllllllllIIlllIlIllllIlII.remove();
            }
            this.playerNetServerHandler.sendPacket(new S13PacketDestroyEntities(llllllllllllllllIIlllIlIllllIlIl));
        }
        if (!this.loadedChunks.isEmpty()) {
            final ArrayList llllllllllllllllIIlllIlIllllIIlI = Lists.newArrayList();
            final Iterator llllllllllllllllIIlllIlIllllIIIl = this.loadedChunks.iterator();
            final ArrayList llllllllllllllllIIlllIlIllllIIII = Lists.newArrayList();
            while (llllllllllllllllIIlllIlIllllIIIl.hasNext() && llllllllllllllllIIlllIlIllllIIlI.size() < 10) {
                final ChunkCoordIntPair llllllllllllllllIIlllIlIlllIllIl = llllllllllllllllIIlllIlIllllIIIl.next();
                if (llllllllllllllllIIlllIlIlllIllIl != null) {
                    if (!this.worldObj.isBlockLoaded(new BlockPos(llllllllllllllllIIlllIlIlllIllIl.chunkXPos << 4, 0, llllllllllllllllIIlllIlIlllIllIl.chunkZPos << 4))) {
                        continue;
                    }
                    final Chunk llllllllllllllllIIlllIlIlllIllll = this.worldObj.getChunkFromChunkCoords(llllllllllllllllIIlllIlIlllIllIl.chunkXPos, llllllllllllllllIIlllIlIlllIllIl.chunkZPos);
                    if (!llllllllllllllllIIlllIlIlllIllll.isPopulated()) {
                        continue;
                    }
                    llllllllllllllllIIlllIlIllllIIlI.add(llllllllllllllllIIlllIlIlllIllll);
                    llllllllllllllllIIlllIlIllllIIII.addAll(((WorldServer)this.worldObj).func_147486_a(llllllllllllllllIIlllIlIlllIllIl.chunkXPos * 16, 0, llllllllllllllllIIlllIlIlllIllIl.chunkZPos * 16, llllllllllllllllIIlllIlIlllIllIl.chunkXPos * 16 + 16, 256, llllllllllllllllIIlllIlIlllIllIl.chunkZPos * 16 + 16));
                    llllllllllllllllIIlllIlIllllIIIl.remove();
                }
                else {
                    llllllllllllllllIIlllIlIllllIIIl.remove();
                }
            }
            if (!llllllllllllllllIIlllIlIllllIIlI.isEmpty()) {
                if (llllllllllllllllIIlllIlIllllIIlI.size() == 1) {
                    this.playerNetServerHandler.sendPacket(new S21PacketChunkData(llllllllllllllllIIlllIlIllllIIlI.get(0), true, 65535));
                }
                else {
                    this.playerNetServerHandler.sendPacket(new S26PacketMapChunkBulk(llllllllllllllllIIlllIlIllllIIlI));
                }
                for (final TileEntity llllllllllllllllIIlllIlIlllIlIll : llllllllllllllllIIlllIlIllllIIII) {
                    this.sendTileEntityUpdate(llllllllllllllllIIlllIlIlllIlIll);
                }
                for (final Chunk llllllllllllllllIIlllIlIlllIlllI : llllllllllllllllIIlllIlIllllIIlI) {
                    this.getServerForPlayer().getEntityTracker().func_85172_a(this, llllllllllllllllIIlllIlIlllIlllI);
                }
            }
        }
        final Entity llllllllllllllllIIlllIlIlllIlIlI = this.func_175398_C();
        if (llllllllllllllllIIlllIlIlllIlIlI != this) {
            if (!llllllllllllllllIIlllIlIlllIlIlI.isEntityAlive()) {
                this.func_175399_e(this);
            }
            else {
                this.setPositionAndRotation(llllllllllllllllIIlllIlIlllIlIlI.posX, llllllllllllllllIIlllIlIlllIlIlI.posY, llllllllllllllllIIlllIlIlllIlIlI.posZ, llllllllllllllllIIlllIlIlllIlIlI.rotationYaw, llllllllllllllllIIlllIlIlllIlIlI.rotationPitch);
                this.mcServer.getConfigurationManager().serverUpdateMountedMovingPlayer(this);
                if (this.isSneaking()) {
                    this.func_175399_e(this);
                }
            }
        }
    }
    
    @Override
    public void addStat(final StatBase llllllllllllllllIIlllIIllIIllIII, final int llllllllllllllllIIlllIIllIIlIIlI) {
        if (llllllllllllllllIIlllIIllIIllIII != null) {
            this.statsFile.func_150871_b(this, llllllllllllllllIIlllIIllIIllIII, llllllllllllllllIIlllIIllIIlIIlI);
            for (final ScoreObjective llllllllllllllllIIlllIIllIIlIlIl : this.getWorldScoreboard().func_96520_a(llllllllllllllllIIlllIIllIIllIII.func_150952_k())) {
                this.getWorldScoreboard().getValueFromObjective(this.getName(), llllllllllllllllIIlllIIllIIlIlIl).increseScore(llllllllllllllllIIlllIIllIIlIIlI);
            }
            if (this.statsFile.func_150879_e()) {
                this.statsFile.func_150876_a(this);
            }
        }
    }
    
    @Override
    public void sendPlayerAbilities() {
        if (this.playerNetServerHandler != null) {
            this.playerNetServerHandler.sendPacket(new S39PacketPlayerAbilities(this.capabilities));
            this.func_175135_B();
        }
    }
    
    @Override
    public void addChatMessage(final IChatComponent llllllllllllllllIIlllIIlIIlIIIIl) {
        this.playerNetServerHandler.sendPacket(new S02PacketChat(llllllllllllllllIIlllIIlIIlIIIIl));
    }
    
    @Override
    public boolean func_174827_a(final EntityPlayerMP llllllllllllllllIIlllIlIIllllIIl) {
        return llllllllllllllllIIlllIlIIllllIIl.func_175149_v() ? (this.func_175398_C() == this) : (!this.func_175149_v() && super.func_174827_a(llllllllllllllllIIlllIlIIllllIIl));
    }
    
    public String getPlayerIP() {
        String llllllllllllllllIIlllIIlIIIlIIIl = this.playerNetServerHandler.netManager.getRemoteAddress().toString();
        llllllllllllllllIIlllIIlIIIlIIIl = llllllllllllllllIIlllIIlIIIlIIIl.substring(llllllllllllllllIIlllIIlIIIlIIIl.indexOf("/") + 1);
        llllllllllllllllIIlllIIlIIIlIIIl = llllllllllllllllIIlllIIlIIIlIIIl.substring(0, llllllllllllllllIIlllIIlIIIlIIIl.indexOf(":"));
        return llllllllllllllllIIlllIIlIIIlIIIl;
    }
    
    private boolean func_175400_cq() {
        return this.mcServer.isPVPEnabled();
    }
    
    private void sendTileEntityUpdate(final TileEntity llllllllllllllllIIlllIlIIlllIlII) {
        if (llllllllllllllllIIlllIlIIlllIlII != null) {
            final Packet llllllllllllllllIIlllIlIIlllIIll = llllllllllllllllIIlllIlIIlllIlII.getDescriptionPacket();
            if (llllllllllllllllIIlllIlIIlllIIll != null) {
                this.playerNetServerHandler.sendPacket(llllllllllllllllIIlllIlIIlllIIll);
            }
        }
    }
    
    @Override
    public void func_152111_bt() {
        super.func_152111_bt();
        this.playerNetServerHandler.sendPacket(new S42PacketCombatEvent(this.getCombatTracker(), S42PacketCombatEvent.Event.ENTER_COMBAT));
    }
    
    @Override
    public void onEnchantmentCritical(final Entity llllllllllllllllIIlllIIlIIlllIII) {
        this.getServerForPlayer().getEntityTracker().func_151248_b(this, new S0BPacketAnimation(llllllllllllllllIIlllIIlIIlllIII, 5));
    }
    
    public void markPlayerActive() {
        this.playerLastActiveTime = MinecraftServer.getCurrentTimeMillis();
    }
    
    @Override
    public void onCriticalHit(final Entity llllllllllllllllIIlllIIlIIlllllI) {
        this.getServerForPlayer().getEntityTracker().func_151248_b(this, new S0BPacketAnimation(llllllllllllllllIIlllIIlIIlllllI, 4));
    }
    
    public Entity func_175398_C() {
        return (this.field_175401_bS == null) ? this : this.field_175401_bS;
    }
    
    public long getLastActiveTime() {
        return this.playerLastActiveTime;
    }
    
    @Override
    public void func_71013_b(final int llllllllllllllllIIlllIllIIIIlIII) {
        super.func_71013_b(llllllllllllllllIIlllIllIIIIlIII);
        this.lastExperience = -1;
    }
    
    @Override
    public void displayGui(final IInteractionObject llllllllllllllllIIlllIlIIIIllIIl) {
        this.getNextWindowId();
        this.playerNetServerHandler.sendPacket(new S2DPacketOpenWindow(this.currentWindowId, llllllllllllllllIIlllIlIIIIllIIl.getGuiID(), llllllllllllllllIIlllIlIIIIllIIl.getDisplayName()));
        this.openContainer = llllllllllllllllIIlllIlIIIIllIIl.createContainer(this.inventory, this);
        this.openContainer.windowId = this.currentWindowId;
        this.openContainer.onCraftGuiOpened(this);
    }
    
    @Override
    protected void onChangedPotionEffect(final PotionEffect llllllllllllllllIIlllIIlIlIllIII, final boolean llllllllllllllllIIlllIIlIlIlIlII) {
        super.onChangedPotionEffect(llllllllllllllllIIlllIIlIlIllIII, llllllllllllllllIIlllIIlIlIlIlII);
        this.playerNetServerHandler.sendPacket(new S1DPacketEntityEffect(this.getEntityId(), llllllllllllllllIIlllIIlIlIllIII));
    }
    
    @Override
    public boolean canCommandSenderUseCommand(final int llllllllllllllllIIlllIIlIIIllIll, final String llllllllllllllllIIlllIIlIIIllIlI) {
        if ("seed".equals(llllllllllllllllIIlllIIlIIIllIlI) && !this.mcServer.isDedicatedServer()) {
            return true;
        }
        if ("tell".equals(llllllllllllllllIIlllIIlIIIllIlI) || "help".equals(llllllllllllllllIIlllIIlIIIllIlI) || "me".equals(llllllllllllllllIIlllIIlIIIllIlI) || "trigger".equals(llllllllllllllllIIlllIIlIIIllIlI)) {
            return true;
        }
        if (this.mcServer.getConfigurationManager().canSendCommands(this.getGameProfile())) {
            final UserListOpsEntry llllllllllllllllIIlllIIlIIIllIIl = (UserListOpsEntry)this.mcServer.getConfigurationManager().getOppedPlayers().getEntry(this.getGameProfile());
            return (llllllllllllllllIIlllIIlIIIllIIl != null) ? (llllllllllllllllIIlllIIlIIIllIIl.func_152644_a() >= llllllllllllllllIIlllIIlIIIllIll) : (this.mcServer.getOpPermissionLevel() >= llllllllllllllllIIlllIIlIIIllIll);
        }
        return false;
    }
}
