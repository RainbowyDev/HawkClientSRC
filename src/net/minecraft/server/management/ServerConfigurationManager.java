package net.minecraft.server.management;

import java.text.*;
import java.io.*;
import net.minecraft.server.*;
import net.minecraft.entity.player.*;
import com.mojang.authlib.*;
import net.minecraft.world.demo.*;
import net.minecraft.world.*;
import io.netty.buffer.*;
import net.minecraft.network.*;
import net.minecraft.potion.*;
import net.minecraft.nbt.*;
import net.minecraft.world.storage.*;
import net.minecraft.entity.*;
import net.minecraft.world.border.*;
import org.apache.logging.log4j.*;
import net.minecraft.stats.*;
import java.util.*;
import net.minecraft.scoreboard.*;
import com.google.common.collect.*;
import net.minecraft.network.play.server.*;
import java.net.*;
import net.minecraft.util.*;

public abstract class ServerConfigurationManager
{
    private /* synthetic */ int viewDistance;
    private static final /* synthetic */ SimpleDateFormat dateFormat;
    private /* synthetic */ WorldSettings.GameType gameType;
    public static final /* synthetic */ File FILE_WHITELIST;
    private final /* synthetic */ BanList bannedIPs;
    public static final /* synthetic */ File FILE_IPBANS;
    private final /* synthetic */ Map playerStatFiles;
    public static final /* synthetic */ File FILE_PLAYERBANS;
    private final /* synthetic */ MinecraftServer mcServer;
    private /* synthetic */ IPlayerFileData playerNBTManagerObj;
    public final /* synthetic */ Map field_177454_f;
    private /* synthetic */ int playerPingIndex;
    private final /* synthetic */ UserListBans bannedPlayers;
    private /* synthetic */ boolean whiteListEnforced;
    private static final /* synthetic */ Logger logger;
    public static final /* synthetic */ File FILE_OPS;
    private /* synthetic */ boolean commandsAllowedForAll;
    protected /* synthetic */ int maxPlayers;
    private final /* synthetic */ UserListOps ops;
    private final /* synthetic */ UserListWhitelist whiteListedPlayers;
    public final /* synthetic */ List playerEntityList;
    
    public MinecraftServer getServerInstance() {
        return this.mcServer;
    }
    
    public void setViewDistance(final int lllllllllllllIlllllllllIllllIlll) {
        this.viewDistance = lllllllllllllIlllllllllIllllIlll;
        if (this.mcServer.worldServers != null) {
            for (final WorldServer lllllllllllllIlllllllllIlllllIIl : this.mcServer.worldServers) {
                if (lllllllllllllIlllllllllIlllllIIl != null) {
                    lllllllllllllIlllllllllIlllllIIl.getPlayerManager().func_152622_a(lllllllllllllIlllllllllIllllIlll);
                }
            }
        }
    }
    
    public void func_177453_a(final EntityPlayer llllllllllllllIIIIIIIIIIIlIlIlIl, final IChatComponent llllllllllllllIIIIIIIIIIIlIIllII) {
        final Team llllllllllllllIIIIIIIIIIIlIlIIll = llllllllllllllIIIIIIIIIIIlIlIlIl.getTeam();
        if (llllllllllllllIIIIIIIIIIIlIlIIll != null) {
            final Collection llllllllllllllIIIIIIIIIIIlIlIIlI = llllllllllllllIIIIIIIIIIIlIlIIll.getMembershipCollection();
            for (final String llllllllllllllIIIIIIIIIIIlIlIIII : llllllllllllllIIIIIIIIIIIlIlIIlI) {
                final EntityPlayerMP llllllllllllllIIIIIIIIIIIlIIllll = this.getPlayerByUsername(llllllllllllllIIIIIIIIIIIlIlIIII);
                if (llllllllllllllIIIIIIIIIIIlIIllll != null && llllllllllllllIIIIIIIIIIIlIIllll != llllllllllllllIIIIIIIIIIIlIlIlIl) {
                    llllllllllllllIIIIIIIIIIIlIIllll.addChatMessage(llllllllllllllIIIIIIIIIIIlIIllII);
                }
            }
        }
    }
    
    public void sendChatMsg(final IChatComponent lllllllllllllIllllllllllIIIllIlI) {
        this.sendChatMsgImpl(lllllllllllllIllllllllllIIIllIlI, true);
    }
    
    public List getPlayersMatchingAddress(final String lllllllllllllIllllllllllIlIllIIl) {
        final ArrayList lllllllllllllIllllllllllIlIllIII = Lists.newArrayList();
        for (final EntityPlayerMP lllllllllllllIllllllllllIlIlIllI : this.playerEntityList) {
            if (lllllllllllllIllllllllllIlIlIllI.getPlayerIP().equals(lllllllllllllIllllllllllIlIllIIl)) {
                lllllllllllllIllllllllllIlIllIII.add(lllllllllllllIllllllllllIlIlIllI);
            }
        }
        return lllllllllllllIllllllllllIlIllIII;
    }
    
    public void addWhitelistedPlayer(final GameProfile lllllllllllllIlllllllllllIIlIIlI) {
        this.whiteListedPlayers.addEntry(new UserListWhitelistEntry(lllllllllllllIlllllllllllIIlIIlI));
    }
    
    public void sendChatMsgImpl(final IChatComponent lllllllllllllIllllllllllIIlIIllI, final boolean lllllllllllllIllllllllllIIlIIIIl) {
        this.mcServer.addChatMessage(lllllllllllllIllllllllllIIlIIllI);
        final int lllllllllllllIllllllllllIIlIIlII = lllllllllllllIllllllllllIIlIIIIl ? 1 : 0;
        this.sendPacketToAllPlayers(new S02PacketChat(lllllllllllllIllllllllllIIlIIllI, (byte)lllllllllllllIllllllllllIIlIIlII));
    }
    
    public void sendToAllNearExcept(final EntityPlayer lllllllllllllIlllllllllllIlIlIIl, final double lllllllllllllIlllllllllllIlIlIII, final double lllllllllllllIlllllllllllIlIIlll, final double lllllllllllllIlllllllllllIllIIll, final double lllllllllllllIlllllllllllIllIIlI, final int lllllllllllllIlllllllllllIllIIIl, final Packet lllllllllllllIlllllllllllIllIIII) {
        for (int lllllllllllllIlllllllllllIlIllll = 0; lllllllllllllIlllllllllllIlIllll < this.playerEntityList.size(); ++lllllllllllllIlllllllllllIlIllll) {
            final EntityPlayerMP lllllllllllllIlllllllllllIlIlllI = this.playerEntityList.get(lllllllllllllIlllllllllllIlIllll);
            if (lllllllllllllIlllllllllllIlIlllI != lllllllllllllIlllllllllllIlIlIIl && lllllllllllllIlllllllllllIlIlllI.dimension == lllllllllllllIlllllllllllIllIIIl) {
                final double lllllllllllllIlllllllllllIlIllIl = lllllllllllllIlllllllllllIlIlIII - lllllllllllllIlllllllllllIlIlllI.posX;
                final double lllllllllllllIlllllllllllIlIllII = lllllllllllllIlllllllllllIlIIlll - lllllllllllllIlllllllllllIlIlllI.posY;
                final double lllllllllllllIlllllllllllIlIlIll = lllllllllllllIlllllllllllIllIIll - lllllllllllllIlllllllllllIlIlllI.posZ;
                if (lllllllllllllIlllllllllllIlIllIl * lllllllllllllIlllllllllllIlIllIl + lllllllllllllIlllllllllllIlIllII * lllllllllllllIlllllllllllIlIllII + lllllllllllllIlllllllllllIlIlIll * lllllllllllllIlllllllllllIlIlIll < lllllllllllllIlllllllllllIllIIlI * lllllllllllllIlllllllllllIllIIlI) {
                    lllllllllllllIlllllllllllIlIlllI.playerNetServerHandler.sendPacket(lllllllllllllIlllllllllllIllIIII);
                }
            }
        }
    }
    
    public String[] getOppedPlayerNames() {
        return this.ops.getKeys();
    }
    
    public void onTick() {
        if (++this.playerPingIndex > 600) {
            this.sendPacketToAllPlayers(new S38PacketPlayerListItem(S38PacketPlayerListItem.Action.UPDATE_LATENCY, this.playerEntityList));
            this.playerPingIndex = 0;
        }
    }
    
    public void loadWhiteList() {
    }
    
    public BanList getBannedIPs() {
        return this.bannedIPs;
    }
    
    public String[] getAllUsernames() {
        final String[] llllllllllllllIIIIIIIIIIIIlIIlll = new String[this.playerEntityList.size()];
        for (int llllllllllllllIIIIIIIIIIIIlIIllI = 0; llllllllllllllIIIIIIIIIIIIlIIllI < this.playerEntityList.size(); ++llllllllllllllIIIIIIIIIIIIlIIllI) {
            llllllllllllllIIIIIIIIIIIIlIIlll[llllllllllllllIIIIIIIIIIIIlIIllI] = this.playerEntityList.get(llllllllllllllIIIIIIIIIIIIlIIllI).getName();
        }
        return llllllllllllllIIIIIIIIIIIIlIIlll;
    }
    
    public void updateTimeAndWeatherForPlayer(final EntityPlayerMP lllllllllllllIllllllllllIlllIlIl, final WorldServer lllllllllllllIllllllllllIllllIII) {
        final WorldBorder lllllllllllllIllllllllllIlllIlll = this.mcServer.worldServers[0].getWorldBorder();
        lllllllllllllIllllllllllIlllIlIl.playerNetServerHandler.sendPacket(new S44PacketWorldBorder(lllllllllllllIllllllllllIlllIlll, S44PacketWorldBorder.Action.INITIALIZE));
        lllllllllllllIllllllllllIlllIlIl.playerNetServerHandler.sendPacket(new S03PacketTimeUpdate(lllllllllllllIllllllllllIllllIII.getTotalWorldTime(), lllllllllllllIllllllllllIllllIII.getWorldTime(), lllllllllllllIllllllllllIllllIII.getGameRules().getGameRuleBooleanValue("doDaylightCycle")));
        if (lllllllllllllIllllllllllIllllIII.isRaining()) {
            lllllllllllllIllllllllllIlllIlIl.playerNetServerHandler.sendPacket(new S2BPacketChangeGameState(1, 0.0f));
            lllllllllllllIllllllllllIlllIlIl.playerNetServerHandler.sendPacket(new S2BPacketChangeGameState(7, lllllllllllllIllllllllllIllllIII.getRainStrength(1.0f)));
            lllllllllllllIllllllllllIlllIlIl.playerNetServerHandler.sendPacket(new S2BPacketChangeGameState(8, lllllllllllllIllllllllllIllllIII.getWeightedThunderStrength(1.0f)));
        }
    }
    
    public EntityPlayerMP createPlayerForUser(final GameProfile llllllllllllllIIIIIIIIIIllIllllI) {
        final UUID llllllllllllllIIIIIIIIIIllIlllIl = EntityPlayer.getUUID(llllllllllllllIIIIIIIIIIllIllllI);
        final ArrayList llllllllllllllIIIIIIIIIIllIlllII = Lists.newArrayList();
        for (int llllllllllllllIIIIIIIIIIllIllIIl = 0; llllllllllllllIIIIIIIIIIllIllIIl < this.playerEntityList.size(); ++llllllllllllllIIIIIIIIIIllIllIIl) {
            final EntityPlayerMP llllllllllllllIIIIIIIIIIllIllIll = this.playerEntityList.get(llllllllllllllIIIIIIIIIIllIllIIl);
            if (llllllllllllllIIIIIIIIIIllIllIll.getUniqueID().equals(llllllllllllllIIIIIIIIIIllIlllIl)) {
                llllllllllllllIIIIIIIIIIllIlllII.add(llllllllllllllIIIIIIIIIIllIllIll);
            }
        }
        for (final EntityPlayerMP llllllllllllllIIIIIIIIIIllIllIlI : llllllllllllllIIIIIIIIIIllIlllII) {
            llllllllllllllIIIIIIIIIIllIllIlI.playerNetServerHandler.kickPlayerFromServer("You logged in from another location");
        }
        Object llllllllllllllIIIIIIIIIIllIlIllI = null;
        if (this.mcServer.isDemo()) {
            final Object llllllllllllllIIIIIIIIIIllIlIlll = new DemoWorldManager(this.mcServer.worldServerForDimension(0));
        }
        else {
            llllllllllllllIIIIIIIIIIllIlIllI = new ItemInWorldManager(this.mcServer.worldServerForDimension(0));
        }
        return new EntityPlayerMP(this.mcServer, this.mcServer.worldServerForDimension(0), llllllllllllllIIIIIIIIIIllIllllI, (ItemInWorldManager)llllllllllllllIIIIIIIIIIllIlIllI);
    }
    
    public int getEntityViewDistance() {
        return PlayerManager.getFurthestViewableBlock(this.getViewDistance());
    }
    
    public GameProfile[] getAllProfiles() {
        final GameProfile[] llllllllllllllIIIIIIIIIIIIIllllI = new GameProfile[this.playerEntityList.size()];
        for (int llllllllllllllIIIIIIIIIIIIIlllIl = 0; llllllllllllllIIIIIIIIIIIIIlllIl < this.playerEntityList.size(); ++llllllllllllllIIIIIIIIIIIIIlllIl) {
            llllllllllllllIIIIIIIIIIIIIllllI[llllllllllllllIIIIIIIIIIIIIlllIl] = this.playerEntityList.get(llllllllllllllIIIIIIIIIIIIIlllIl).getGameProfile();
        }
        return llllllllllllllIIIIIIIIIIIIIllllI;
    }
    
    public UserListBans getBannedPlayers() {
        return this.bannedPlayers;
    }
    
    public void initializeConnectionToPlayer(final NetworkManager llllllllllllllIIIIIIIIIlIllllIlI, final EntityPlayerMP llllllllllllllIIIIIIIIIlIllllIIl) {
        final GameProfile llllllllllllllIIIIIIIIIlIllllIII = llllllllllllllIIIIIIIIIlIllllIIl.getGameProfile();
        final PlayerProfileCache llllllllllllllIIIIIIIIIlIlllIlll = this.mcServer.getPlayerProfileCache();
        final GameProfile llllllllllllllIIIIIIIIIlIlllIllI = llllllllllllllIIIIIIIIIlIlllIlll.func_152652_a(llllllllllllllIIIIIIIIIlIllllIII.getId());
        final String llllllllllllllIIIIIIIIIlIlllIlIl = (llllllllllllllIIIIIIIIIlIlllIllI == null) ? llllllllllllllIIIIIIIIIlIllllIII.getName() : llllllllllllllIIIIIIIIIlIlllIllI.getName();
        llllllllllllllIIIIIIIIIlIlllIlll.func_152649_a(llllllllllllllIIIIIIIIIlIllllIII);
        final NBTTagCompound llllllllllllllIIIIIIIIIlIlllIlII = this.readPlayerDataFromFile(llllllllllllllIIIIIIIIIlIllllIIl);
        llllllllllllllIIIIIIIIIlIllllIIl.setWorld(this.mcServer.worldServerForDimension(llllllllllllllIIIIIIIIIlIllllIIl.dimension));
        llllllllllllllIIIIIIIIIlIllllIIl.theItemInWorldManager.setWorld((WorldServer)llllllllllllllIIIIIIIIIlIllllIIl.worldObj);
        String llllllllllllllIIIIIIIIIlIlllIIll = "local";
        if (llllllllllllllIIIIIIIIIlIllllIlI.getRemoteAddress() != null) {
            llllllllllllllIIIIIIIIIlIlllIIll = llllllllllllllIIIIIIIIIlIllllIlI.getRemoteAddress().toString();
        }
        ServerConfigurationManager.logger.info(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIIIIIIIlIllllIIl.getName())).append("[").append(llllllllllllllIIIIIIIIIlIlllIIll).append("] logged in with entity id ").append(llllllllllllllIIIIIIIIIlIllllIIl.getEntityId()).append(" at (").append(llllllllllllllIIIIIIIIIlIllllIIl.posX).append(", ").append(llllllllllllllIIIIIIIIIlIllllIIl.posY).append(", ").append(llllllllllllllIIIIIIIIIlIllllIIl.posZ).append(")")));
        final WorldServer llllllllllllllIIIIIIIIIlIlllIIlI = this.mcServer.worldServerForDimension(llllllllllllllIIIIIIIIIlIllllIIl.dimension);
        final WorldInfo llllllllllllllIIIIIIIIIlIlllIIIl = llllllllllllllIIIIIIIIIlIlllIIlI.getWorldInfo();
        final BlockPos llllllllllllllIIIIIIIIIlIlllIIII = llllllllllllllIIIIIIIIIlIlllIIlI.getSpawnPoint();
        this.func_72381_a(llllllllllllllIIIIIIIIIlIllllIIl, null, llllllllllllllIIIIIIIIIlIlllIIlI);
        final NetHandlerPlayServer llllllllllllllIIIIIIIIIlIllIllll = new NetHandlerPlayServer(this.mcServer, llllllllllllllIIIIIIIIIlIllllIlI, llllllllllllllIIIIIIIIIlIllllIIl);
        llllllllllllllIIIIIIIIIlIllIllll.sendPacket(new S01PacketJoinGame(llllllllllllllIIIIIIIIIlIllllIIl.getEntityId(), llllllllllllllIIIIIIIIIlIllllIIl.theItemInWorldManager.getGameType(), llllllllllllllIIIIIIIIIlIlllIIIl.isHardcoreModeEnabled(), llllllllllllllIIIIIIIIIlIlllIIlI.provider.getDimensionId(), llllllllllllllIIIIIIIIIlIlllIIlI.getDifficulty(), this.getMaxPlayers(), llllllllllllllIIIIIIIIIlIlllIIIl.getTerrainType(), llllllllllllllIIIIIIIIIlIlllIIlI.getGameRules().getGameRuleBooleanValue("reducedDebugInfo")));
        llllllllllllllIIIIIIIIIlIllIllll.sendPacket(new S3FPacketCustomPayload("MC|Brand", new PacketBuffer(Unpooled.buffer()).writeString(this.getServerInstance().getServerModName())));
        llllllllllllllIIIIIIIIIlIllIllll.sendPacket(new S41PacketServerDifficulty(llllllllllllllIIIIIIIIIlIlllIIIl.getDifficulty(), llllllllllllllIIIIIIIIIlIlllIIIl.isDifficultyLocked()));
        llllllllllllllIIIIIIIIIlIllIllll.sendPacket(new S05PacketSpawnPosition(llllllllllllllIIIIIIIIIlIlllIIII));
        llllllllllllllIIIIIIIIIlIllIllll.sendPacket(new S39PacketPlayerAbilities(llllllllllllllIIIIIIIIIlIllllIIl.capabilities));
        llllllllllllllIIIIIIIIIlIllIllll.sendPacket(new S09PacketHeldItemChange(llllllllllllllIIIIIIIIIlIllllIIl.inventory.currentItem));
        llllllllllllllIIIIIIIIIlIllllIIl.getStatFile().func_150877_d();
        llllllllllllllIIIIIIIIIlIllllIIl.getStatFile().func_150884_b(llllllllllllllIIIIIIIIIlIllllIIl);
        this.func_96456_a((ServerScoreboard)llllllllllllllIIIIIIIIIlIlllIIlI.getScoreboard(), llllllllllllllIIIIIIIIIlIllllIIl);
        this.mcServer.refreshStatusNextTick();
        ChatComponentTranslation llllllllllllllIIIIIIIIIlIllIllIl = null;
        if (!llllllllllllllIIIIIIIIIlIllllIIl.getName().equalsIgnoreCase(llllllllllllllIIIIIIIIIlIlllIlIl)) {
            final ChatComponentTranslation llllllllllllllIIIIIIIIIlIllIlllI = new ChatComponentTranslation("multiplayer.player.joined.renamed", new Object[] { llllllllllllllIIIIIIIIIlIllllIIl.getDisplayName(), llllllllllllllIIIIIIIIIlIlllIlIl });
        }
        else {
            llllllllllllllIIIIIIIIIlIllIllIl = new ChatComponentTranslation("multiplayer.player.joined", new Object[] { llllllllllllllIIIIIIIIIlIllllIIl.getDisplayName() });
        }
        llllllllllllllIIIIIIIIIlIllIllIl.getChatStyle().setColor(EnumChatFormatting.YELLOW);
        this.sendChatMsg(llllllllllllllIIIIIIIIIlIllIllIl);
        this.playerLoggedIn(llllllllllllllIIIIIIIIIlIllllIIl);
        llllllllllllllIIIIIIIIIlIllIllll.setPlayerLocation(llllllllllllllIIIIIIIIIlIllllIIl.posX, llllllllllllllIIIIIIIIIlIllllIIl.posY, llllllllllllllIIIIIIIIIlIllllIIl.posZ, llllllllllllllIIIIIIIIIlIllllIIl.rotationYaw, llllllllllllllIIIIIIIIIlIllllIIl.rotationPitch);
        this.updateTimeAndWeatherForPlayer(llllllllllllllIIIIIIIIIlIllllIIl, llllllllllllllIIIIIIIIIlIlllIIlI);
        if (this.mcServer.getResourcePackUrl().length() > 0) {
            llllllllllllllIIIIIIIIIlIllllIIl.func_175397_a(this.mcServer.getResourcePackUrl(), this.mcServer.getResourcePackHash());
        }
        for (final PotionEffect llllllllllllllIIIIIIIIIlIllIlIll : llllllllllllllIIIIIIIIIlIllllIIl.getActivePotionEffects()) {
            llllllllllllllIIIIIIIIIlIllIllll.sendPacket(new S1DPacketEntityEffect(llllllllllllllIIIIIIIIIlIllllIIl.getEntityId(), llllllllllllllIIIIIIIIIlIllIlIll));
        }
        llllllllllllllIIIIIIIIIlIllllIIl.addSelfToInternalCraftingInventory();
        if (llllllllllllllIIIIIIIIIlIlllIlII != null && llllllllllllllIIIIIIIIIlIlllIlII.hasKey("Riding", 10)) {
            final Entity llllllllllllllIIIIIIIIIlIllIlIlI = EntityList.createEntityFromNBT(llllllllllllllIIIIIIIIIlIlllIlII.getCompoundTag("Riding"), llllllllllllllIIIIIIIIIlIlllIIlI);
            if (llllllllllllllIIIIIIIIIlIllIlIlI != null) {
                llllllllllllllIIIIIIIIIlIllIlIlI.forceSpawn = true;
                llllllllllllllIIIIIIIIIlIlllIIlI.spawnEntityInWorld(llllllllllllllIIIIIIIIIlIllIlIlI);
                llllllllllllllIIIIIIIIIlIllllIIl.mountEntity(llllllllllllllIIIIIIIIIlIllIlIlI);
                llllllllllllllIIIIIIIIIlIllIlIlI.forceSpawn = false;
            }
        }
    }
    
    public boolean canSendCommands(final GameProfile lllllllllllllIllllllllllllllllII) {
        return this.ops.hasEntry(lllllllllllllIllllllllllllllllII) || (this.mcServer.isSinglePlayer() && this.mcServer.worldServers[0].getWorldInfo().areCommandsAllowed() && this.mcServer.getServerOwner().equalsIgnoreCase(lllllllllllllIllllllllllllllllII.getName())) || this.commandsAllowedForAll;
    }
    
    public int getCurrentPlayerCount() {
        return this.playerEntityList.size();
    }
    
    public void setCommandsAllowedForAll(final boolean lllllllllllllIllllllllllIIllIlII) {
        this.commandsAllowedForAll = lllllllllllllIllllllllllIIllIlII;
    }
    
    public void playerLoggedIn(final EntityPlayerMP llllllllllllllIIIIIIIIIlIIIIllIl) {
        this.playerEntityList.add(llllllllllllllIIIIIIIIIlIIIIllIl);
        this.field_177454_f.put(llllllllllllllIIIIIIIIIlIIIIllIl.getUniqueID(), llllllllllllllIIIIIIIIIlIIIIllIl);
        this.sendPacketToAllPlayers(new S38PacketPlayerListItem(S38PacketPlayerListItem.Action.ADD_PLAYER, new EntityPlayerMP[] { llllllllllllllIIIIIIIIIlIIIIllIl }));
        final WorldServer llllllllllllllIIIIIIIIIlIIIIllII = this.mcServer.worldServerForDimension(llllllllllllllIIIIIIIIIlIIIIllIl.dimension);
        llllllllllllllIIIIIIIIIlIIIIllII.spawnEntityInWorld(llllllllllllllIIIIIIIIIlIIIIllIl);
        this.func_72375_a(llllllllllllllIIIIIIIIIlIIIIllIl, null);
        for (int llllllllllllllIIIIIIIIIlIIIIlIll = 0; llllllllllllllIIIIIIIIIlIIIIlIll < this.playerEntityList.size(); ++llllllllllllllIIIIIIIIIlIIIIlIll) {
            final EntityPlayerMP llllllllllllllIIIIIIIIIlIIIIlIlI = this.playerEntityList.get(llllllllllllllIIIIIIIIIlIIIIlIll);
            llllllllllllllIIIIIIIIIlIIIIllIl.playerNetServerHandler.sendPacket(new S38PacketPlayerListItem(S38PacketPlayerListItem.Action.ADD_PLAYER, new EntityPlayerMP[] { llllllllllllllIIIIIIIIIlIIIIlIlI }));
        }
    }
    
    public void removePlayerFromWhitelist(final GameProfile lllllllllllllIlllllllllllIIIllII) {
        this.whiteListedPlayers.removeEntry(lllllllllllllIlllllllllllIIIllII);
    }
    
    public UserListOps getOppedPlayers() {
        return this.ops;
    }
    
    public void func_177452_b(final EntityPlayer llllllllllllllIIIIIIIIIIIIlllIIl, final IChatComponent llllllllllllllIIIIIIIIIIIIlllllI) {
        final Team llllllllllllllIIIIIIIIIIIIllllIl = llllllllllllllIIIIIIIIIIIIlllIIl.getTeam();
        if (llllllllllllllIIIIIIIIIIIIllllIl == null) {
            this.sendChatMsg(llllllllllllllIIIIIIIIIIIIlllllI);
        }
        else {
            for (int llllllllllllllIIIIIIIIIIIIllllII = 0; llllllllllllllIIIIIIIIIIIIllllII < this.playerEntityList.size(); ++llllllllllllllIIIIIIIIIIIIllllII) {
                final EntityPlayerMP llllllllllllllIIIIIIIIIIIIlllIll = this.playerEntityList.get(llllllllllllllIIIIIIIIIIIIllllII);
                if (llllllllllllllIIIIIIIIIIIIlllIll.getTeam() != llllllllllllllIIIIIIIIIIIIllllIl) {
                    llllllllllllllIIIIIIIIIIIIlllIll.addChatMessage(llllllllllllllIIIIIIIIIIIIlllllI);
                }
            }
        }
    }
    
    public String[] getWhitelistedPlayerNames() {
        return this.whiteListedPlayers.getKeys();
    }
    
    public String[] getAvailablePlayerDat() {
        return this.mcServer.worldServers[0].getSaveHandler().getPlayerNBTManager().getAvailablePlayerDat();
    }
    
    public void func_152604_a(final WorldSettings.GameType lllllllllllllIllllllllllIlIIIllI) {
        this.gameType = lllllllllllllIllllllllllIlIIIllI;
    }
    
    public void setPlayerManager(final WorldServer[] llllllllllllllIIIIIIIIIlIIlllIIl) {
        this.playerNBTManagerObj = llllllllllllllIIIIIIIIIlIIlllIIl[0].getSaveHandler().getPlayerNBTManager();
        llllllllllllllIIIIIIIIIlIIlllIIl[0].getWorldBorder().addListener(new IBorderListener() {
            @Override
            public void onWarningDistanceChanged(final WorldBorder llllllllllllllllIlIlIIIlllIIlIll, final int llllllllllllllllIlIlIIIlllIIlIlI) {
                ServerConfigurationManager.this.sendPacketToAllPlayers(new S44PacketWorldBorder(llllllllllllllllIlIlIIIlllIIlIll, S44PacketWorldBorder.Action.SET_WARNING_BLOCKS));
            }
            
            static {
                __OBFID = "CL_00002267";
            }
            
            @Override
            public void func_177692_a(final WorldBorder llllllllllllllllIlIlIIIlllIllllI, final double llllllllllllllllIlIlIIIllllIIIlI, final double llllllllllllllllIlIlIIIllllIIIIl, final long llllllllllllllllIlIlIIIllllIIIII) {
                ServerConfigurationManager.this.sendPacketToAllPlayers(new S44PacketWorldBorder(llllllllllllllllIlIlIIIlllIllllI, S44PacketWorldBorder.Action.LERP_SIZE));
            }
            
            @Override
            public void func_177695_c(final WorldBorder llllllllllllllllIlIlIIIlllIIIIll, final double llllllllllllllllIlIlIIIlllIIIIlI) {
            }
            
            @Override
            public void onSizeChanged(final WorldBorder llllllllllllllllIlIlIIIllllIlIlI, final double llllllllllllllllIlIlIIIllllIlIIl) {
                ServerConfigurationManager.this.sendPacketToAllPlayers(new S44PacketWorldBorder(llllllllllllllllIlIlIIIllllIlIlI, S44PacketWorldBorder.Action.SET_SIZE));
            }
            
            @Override
            public void onWarningTimeChanged(final WorldBorder llllllllllllllllIlIlIIIlllIIllll, final int llllllllllllllllIlIlIIIlllIlIIIl) {
                ServerConfigurationManager.this.sendPacketToAllPlayers(new S44PacketWorldBorder(llllllllllllllllIlIlIIIlllIIllll, S44PacketWorldBorder.Action.SET_WARNING_TIME));
            }
            
            @Override
            public void onCenterChanged(final WorldBorder llllllllllllllllIlIlIIIlllIlIllI, final double llllllllllllllllIlIlIIIlllIllIIl, final double llllllllllllllllIlIlIIIlllIllIII) {
                ServerConfigurationManager.this.sendPacketToAllPlayers(new S44PacketWorldBorder(llllllllllllllllIlIlIIIlllIlIllI, S44PacketWorldBorder.Action.SET_CENTER));
            }
            
            @Override
            public void func_177696_b(final WorldBorder llllllllllllllllIlIlIIIlllIIIllI, final double llllllllllllllllIlIlIIIlllIIIlIl) {
            }
        });
    }
    
    public int getMaxPlayers() {
        return this.maxPlayers;
    }
    
    public UserListWhitelist getWhitelistedPlayers() {
        return this.whiteListedPlayers;
    }
    
    public void transferPlayerToDimension(final EntityPlayerMP llllllllllllllIIIIIIIIIIlIlIIlIl, final int llllllllllllllIIIIIIIIIIlIlIIlII) {
        final int llllllllllllllIIIIIIIIIIlIlIIIll = llllllllllllllIIIIIIIIIIlIlIIlIl.dimension;
        final WorldServer llllllllllllllIIIIIIIIIIlIlIIIlI = this.mcServer.worldServerForDimension(llllllllllllllIIIIIIIIIIlIlIIlIl.dimension);
        llllllllllllllIIIIIIIIIIlIlIIlIl.dimension = llllllllllllllIIIIIIIIIIlIlIIlII;
        final WorldServer llllllllllllllIIIIIIIIIIlIlIIIIl = this.mcServer.worldServerForDimension(llllllllllllllIIIIIIIIIIlIlIIlIl.dimension);
        llllllllllllllIIIIIIIIIIlIlIIlIl.playerNetServerHandler.sendPacket(new S07PacketRespawn(llllllllllllllIIIIIIIIIIlIlIIlIl.dimension, llllllllllllllIIIIIIIIIIlIlIIlIl.worldObj.getDifficulty(), llllllllllllllIIIIIIIIIIlIlIIlIl.worldObj.getWorldInfo().getTerrainType(), llllllllllllllIIIIIIIIIIlIlIIlIl.theItemInWorldManager.getGameType()));
        llllllllllllllIIIIIIIIIIlIlIIIlI.removePlayerEntityDangerously(llllllllllllllIIIIIIIIIIlIlIIlIl);
        llllllllllllllIIIIIIIIIIlIlIIlIl.isDead = false;
        this.transferEntityToWorld(llllllllllllllIIIIIIIIIIlIlIIlIl, llllllllllllllIIIIIIIIIIlIlIIIll, llllllllllllllIIIIIIIIIIlIlIIIlI, llllllllllllllIIIIIIIIIIlIlIIIIl);
        this.func_72375_a(llllllllllllllIIIIIIIIIIlIlIIlIl, llllllllllllllIIIIIIIIIIlIlIIIlI);
        llllllllllllllIIIIIIIIIIlIlIIlIl.playerNetServerHandler.setPlayerLocation(llllllllllllllIIIIIIIIIIlIlIIlIl.posX, llllllllllllllIIIIIIIIIIlIlIIlIl.posY, llllllllllllllIIIIIIIIIIlIlIIlIl.posZ, llllllllllllllIIIIIIIIIIlIlIIlIl.rotationYaw, llllllllllllllIIIIIIIIIIlIlIIlIl.rotationPitch);
        llllllllllllllIIIIIIIIIIlIlIIlIl.theItemInWorldManager.setWorld(llllllllllllllIIIIIIIIIIlIlIIIIl);
        this.updateTimeAndWeatherForPlayer(llllllllllllllIIIIIIIIIIlIlIIlIl, llllllllllllllIIIIIIIIIIlIlIIIIl);
        this.syncPlayerInventory(llllllllllllllIIIIIIIIIIlIlIIlIl);
        for (final PotionEffect llllllllllllllIIIIIIIIIIlIIlllll : llllllllllllllIIIIIIIIIIlIlIIlIl.getActivePotionEffects()) {
            llllllllllllllIIIIIIIIIIlIlIIlIl.playerNetServerHandler.sendPacket(new S1DPacketEntityEffect(llllllllllllllIIIIIIIIIIlIlIIlIl.getEntityId(), llllllllllllllIIIIIIIIIIlIIlllll));
        }
    }
    
    public void sendPacketToAllPlayers(final Packet llllllllllllllIIIIIIIIIIIlllIIlI) {
        for (int llllllllllllllIIIIIIIIIIIlllIIIl = 0; llllllllllllllIIIIIIIIIIIlllIIIl < this.playerEntityList.size(); ++llllllllllllllIIIIIIIIIIIlllIIIl) {
            this.playerEntityList.get(llllllllllllllIIIIIIIIIIIlllIIIl).playerNetServerHandler.sendPacket(llllllllllllllIIIIIIIIIIIlllIIlI);
        }
    }
    
    public void setWhiteListEnabled(final boolean lllllllllllllIllllllllllIllIIIII) {
        this.whiteListEnforced = lllllllllllllIllllllllllIllIIIII;
    }
    
    static {
        __OBFID = "CL_00001423";
        FILE_PLAYERBANS = new File("banned-players.json");
        FILE_IPBANS = new File("banned-ips.json");
        FILE_OPS = new File("ops.json");
        FILE_WHITELIST = new File("whitelist.json");
        logger = LogManager.getLogger();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    }
    
    public NBTTagCompound getHostPlayerData() {
        return null;
    }
    
    protected void writePlayerData(final EntityPlayerMP llllllllllllllIIIIIIIIIlIIIlIlIl) {
        this.playerNBTManagerObj.writePlayerData(llllllllllllllIIIIIIIIIlIIIlIlIl);
        final StatisticsFile llllllllllllllIIIIIIIIIlIIIlIlll = this.playerStatFiles.get(llllllllllllllIIIIIIIIIlIIIlIlIl.getUniqueID());
        if (llllllllllllllIIIIIIIIIlIIIlIlll != null) {
            llllllllllllllIIIIIIIIIlIIIlIlll.func_150883_b();
        }
    }
    
    public void syncPlayerInventory(final EntityPlayerMP lllllllllllllIllllllllllIlllIIII) {
        lllllllllllllIllllllllllIlllIIII.sendContainerToPlayer(lllllllllllllIllllllllllIlllIIII.inventoryContainer);
        lllllllllllllIllllllllllIlllIIII.setPlayerHealthUpdated();
        lllllllllllllIllllllllllIlllIIII.playerNetServerHandler.sendPacket(new S09PacketHeldItemChange(lllllllllllllIllllllllllIlllIIII.inventory.currentItem));
    }
    
    public void serverUpdateMountedMovingPlayer(final EntityPlayerMP llllllllllllllIIIIIIIIIlIIIIIIlI) {
        llllllllllllllIIIIIIIIIlIIIIIIlI.getServerForPlayer().getPlayerManager().updateMountedMovingPlayer(llllllllllllllIIIIIIIIIlIIIIIIlI);
    }
    
    public EntityPlayerMP func_177451_a(final UUID lllllllllllllIlllllllllIlllIllll) {
        return this.field_177454_f.get(lllllllllllllIlllllllllIlllIllll);
    }
    
    public void playerLoggedOut(final EntityPlayerMP llllllllllllllIIIIIIIIIIllllllII) {
        llllllllllllllIIIIIIIIIIllllllII.triggerAchievement(StatList.leaveGameStat);
        this.writePlayerData(llllllllllllllIIIIIIIIIIllllllII);
        final WorldServer llllllllllllllIIIIIIIIIIlllllIll = llllllllllllllIIIIIIIIIIllllllII.getServerForPlayer();
        if (llllllllllllllIIIIIIIIIIllllllII.ridingEntity != null) {
            llllllllllllllIIIIIIIIIIlllllIll.removePlayerEntityDangerously(llllllllllllllIIIIIIIIIIllllllII.ridingEntity);
            ServerConfigurationManager.logger.debug("removing player mount");
        }
        llllllllllllllIIIIIIIIIIlllllIll.removeEntity(llllllllllllllIIIIIIIIIIllllllII);
        llllllllllllllIIIIIIIIIIlllllIll.getPlayerManager().removePlayer(llllllllllllllIIIIIIIIIIllllllII);
        this.playerEntityList.remove(llllllllllllllIIIIIIIIIIllllllII);
        this.field_177454_f.remove(llllllllllllllIIIIIIIIIIllllllII.getUniqueID());
        this.playerStatFiles.remove(llllllllllllllIIIIIIIIIIllllllII.getUniqueID());
        this.sendPacketToAllPlayers(new S38PacketPlayerListItem(S38PacketPlayerListItem.Action.REMOVE_PLAYER, new EntityPlayerMP[] { llllllllllllllIIIIIIIIIIllllllII }));
    }
    
    public NBTTagCompound readPlayerDataFromFile(final EntityPlayerMP llllllllllllllIIIIIIIIIlIIIlllll) {
        final NBTTagCompound llllllllllllllIIIIIIIIIlIIlIIIll = this.mcServer.worldServers[0].getWorldInfo().getPlayerNBTTagCompound();
        NBTTagCompound llllllllllllllIIIIIIIIIlIIlIIIIl = null;
        if (llllllllllllllIIIIIIIIIlIIIlllll.getName().equals(this.mcServer.getServerOwner()) && llllllllllllllIIIIIIIIIlIIlIIIll != null) {
            llllllllllllllIIIIIIIIIlIIIlllll.readFromNBT(llllllllllllllIIIIIIIIIlIIlIIIll);
            final NBTTagCompound llllllllllllllIIIIIIIIIlIIlIIIlI = llllllllllllllIIIIIIIIIlIIlIIIll;
            ServerConfigurationManager.logger.debug("loading single player");
        }
        else {
            llllllllllllllIIIIIIIIIlIIlIIIIl = this.playerNBTManagerObj.readPlayerData(llllllllllllllIIIIIIIIIlIIIlllll);
        }
        return llllllllllllllIIIIIIIIIlIIlIIIIl;
    }
    
    public StatisticsFile getPlayerStatsFile(final EntityPlayer lllllllllllllIllllllllllIIIlIIIl) {
        final UUID lllllllllllllIllllllllllIIIlIIII = lllllllllllllIllllllllllIIIlIIIl.getUniqueID();
        StatisticsFile lllllllllllllIllllllllllIIIIllll = (lllllllllllllIllllllllllIIIlIIII == null) ? null : this.playerStatFiles.get(lllllllllllllIllllllllllIIIlIIII);
        if (lllllllllllllIllllllllllIIIIllll == null) {
            final File lllllllllllllIllllllllllIIIIlllI = new File(this.mcServer.worldServerForDimension(0).getSaveHandler().getWorldDirectory(), "stats");
            final File lllllllllllllIllllllllllIIIIllIl = new File(lllllllllllllIllllllllllIIIIlllI, String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIllllllllllIIIlIIII.toString())).append(".json")));
            if (!lllllllllllllIllllllllllIIIIllIl.exists()) {
                final File lllllllllllllIllllllllllIIIIllII = new File(lllllllllllllIllllllllllIIIIlllI, String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIllllllllllIIIlIIIl.getName())).append(".json")));
                if (lllllllllllllIllllllllllIIIIllII.exists() && lllllllllllllIllllllllllIIIIllII.isFile()) {
                    lllllllllllllIllllllllllIIIIllII.renameTo(lllllllllllllIllllllllllIIIIllIl);
                }
            }
            lllllllllllllIllllllllllIIIIllll = new StatisticsFile(this.mcServer, lllllllllllllIllllllllllIIIIllIl);
            lllllllllllllIllllllllllIIIIllll.func_150882_a();
            this.playerStatFiles.put(lllllllllllllIllllllllllIIIlIIII, lllllllllllllIllllllllllIIIIllll);
        }
        return lllllllllllllIllllllllllIIIIllll;
    }
    
    public void addOp(final GameProfile llllllllllllllIIIIIIIIIIIIIlIIII) {
        this.ops.addEntry(new UserListOpsEntry(llllllllllllllIIIIIIIIIIIIIlIIII, this.mcServer.getOpPermissionLevel()));
    }
    
    public void removeAllPlayers() {
        for (int lllllllllllllIllllllllllIIlIlllI = 0; lllllllllllllIllllllllllIIlIlllI < this.playerEntityList.size(); ++lllllllllllllIllllllllllIIlIlllI) {
            this.playerEntityList.get(lllllllllllllIllllllllllIIlIlllI).playerNetServerHandler.kickPlayerFromServer("Server closed");
        }
    }
    
    public String func_180602_f() {
        String llllllllllllllIIIIIIIIIIIIllIIII = "";
        for (int llllllllllllllIIIIIIIIIIIIlIllll = 0; llllllllllllllIIIIIIIIIIIIlIllll < this.playerEntityList.size(); ++llllllllllllllIIIIIIIIIIIIlIllll) {
            if (llllllllllllllIIIIIIIIIIIIlIllll > 0) {
                llllllllllllllIIIIIIIIIIIIllIIII = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIIIIIIIIIIllIIII)).append(", "));
            }
            llllllllllllllIIIIIIIIIIIIllIIII = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIIIIIIIIIIllIIII)).append(this.playerEntityList.get(llllllllllllllIIIIIIIIIIIIlIllll).getName()));
        }
        return llllllllllllllIIIIIIIIIIIIllIIII;
    }
    
    protected void func_96456_a(final ServerScoreboard llllllllllllllIIIIIIIIIlIlIIIlIl, final EntityPlayerMP llllllllllllllIIIIIIIIIlIlIIIlII) {
        final HashSet llllllllllllllIIIIIIIIIlIlIIllIl = Sets.newHashSet();
        for (final ScorePlayerTeam llllllllllllllIIIIIIIIIlIlIIlIll : llllllllllllllIIIIIIIIIlIlIIIlIl.getTeams()) {
            llllllllllllllIIIIIIIIIlIlIIIlII.playerNetServerHandler.sendPacket(new S3EPacketTeams(llllllllllllllIIIIIIIIIlIlIIlIll, 0));
        }
        for (int llllllllllllllIIIIIIIIIlIlIIlIlI = 0; llllllllllllllIIIIIIIIIlIlIIlIlI < 19; ++llllllllllllllIIIIIIIIIlIlIIlIlI) {
            final ScoreObjective llllllllllllllIIIIIIIIIlIlIIlIIl = llllllllllllllIIIIIIIIIlIlIIIlIl.getObjectiveInDisplaySlot(llllllllllllllIIIIIIIIIlIlIIlIlI);
            if (llllllllllllllIIIIIIIIIlIlIIlIIl != null && !llllllllllllllIIIIIIIIIlIlIIllIl.contains(llllllllllllllIIIIIIIIIlIlIIlIIl)) {
                final List llllllllllllllIIIIIIIIIlIlIIlIII = llllllllllllllIIIIIIIIIlIlIIIlIl.func_96550_d(llllllllllllllIIIIIIIIIlIlIIlIIl);
                for (final Packet llllllllllllllIIIIIIIIIlIlIIIllI : llllllllllllllIIIIIIIIIlIlIIlIII) {
                    llllllllllllllIIIIIIIIIlIlIIIlII.playerNetServerHandler.sendPacket(llllllllllllllIIIIIIIIIlIlIIIllI);
                }
                llllllllllllllIIIIIIIIIlIlIIllIl.add(llllllllllllllIIIIIIIIIlIlIIlIIl);
            }
        }
    }
    
    public void saveAllPlayerData() {
        for (int lllllllllllllIlllllllllllIIllIlI = 0; lllllllllllllIlllllllllllIIllIlI < this.playerEntityList.size(); ++lllllllllllllIlllllllllllIIllIlI) {
            this.writePlayerData(this.playerEntityList.get(lllllllllllllIlllllllllllIIllIlI));
        }
    }
    
    public ServerConfigurationManager(final MinecraftServer llllllllllllllIIIIIIIIIllIIIllII) {
        this.playerEntityList = Lists.newArrayList();
        this.field_177454_f = Maps.newHashMap();
        this.bannedPlayers = new UserListBans(ServerConfigurationManager.FILE_PLAYERBANS);
        this.bannedIPs = new BanList(ServerConfigurationManager.FILE_IPBANS);
        this.ops = new UserListOps(ServerConfigurationManager.FILE_OPS);
        this.whiteListedPlayers = new UserListWhitelist(ServerConfigurationManager.FILE_WHITELIST);
        this.playerStatFiles = Maps.newHashMap();
        this.mcServer = llllllllllllllIIIIIIIIIllIIIllII;
        this.bannedPlayers.setLanServer(false);
        this.bannedIPs.setLanServer(false);
        this.maxPlayers = 8;
    }
    
    public void func_72375_a(final EntityPlayerMP llllllllllllllIIIIIIIIIlIIlIllll, final WorldServer llllllllllllllIIIIIIIIIlIIllIIIl) {
        final WorldServer llllllllllllllIIIIIIIIIlIIllIIII = llllllllllllllIIIIIIIIIlIIlIllll.getServerForPlayer();
        if (llllllllllllllIIIIIIIIIlIIllIIIl != null) {
            llllllllllllllIIIIIIIIIlIIllIIIl.getPlayerManager().removePlayer(llllllllllllllIIIIIIIIIlIIlIllll);
        }
        llllllllllllllIIIIIIIIIlIIllIIII.getPlayerManager().addPlayer(llllllllllllllIIIIIIIIIlIIlIllll);
        llllllllllllllIIIIIIIIIlIIllIIII.theChunkProviderServer.loadChunk((int)llllllllllllllIIIIIIIIIlIIlIllll.posX >> 4, (int)llllllllllllllIIIIIIIIIlIIlIllll.posZ >> 4);
    }
    
    public EntityPlayerMP recreatePlayerEntity(final EntityPlayerMP llllllllllllllIIIIIIIIIIlIllIlll, final int llllllllllllllIIIIIIIIIIlIllIllI, final boolean llllllllllllllIIIIIIIIIIlIllIlIl) {
        llllllllllllllIIIIIIIIIIlIllIlll.getServerForPlayer().getEntityTracker().removePlayerFromTrackers(llllllllllllllIIIIIIIIIIlIllIlll);
        llllllllllllllIIIIIIIIIIlIllIlll.getServerForPlayer().getEntityTracker().untrackEntity(llllllllllllllIIIIIIIIIIlIllIlll);
        llllllllllllllIIIIIIIIIIlIllIlll.getServerForPlayer().getPlayerManager().removePlayer(llllllllllllllIIIIIIIIIIlIllIlll);
        this.playerEntityList.remove(llllllllllllllIIIIIIIIIIlIllIlll);
        this.mcServer.worldServerForDimension(llllllllllllllIIIIIIIIIIlIllIlll.dimension).removePlayerEntityDangerously(llllllllllllllIIIIIIIIIIlIllIlll);
        final BlockPos llllllllllllllIIIIIIIIIIllIIIIII = llllllllllllllIIIIIIIIIIlIllIlll.func_180470_cg();
        final boolean llllllllllllllIIIIIIIIIIlIllllll = llllllllllllllIIIIIIIIIIlIllIlll.isSpawnForced();
        llllllllllllllIIIIIIIIIIlIllIlll.dimension = llllllllllllllIIIIIIIIIIlIllIllI;
        Object llllllllllllllIIIIIIIIIIlIllllIl = null;
        if (this.mcServer.isDemo()) {
            final Object llllllllllllllIIIIIIIIIIlIlllllI = new DemoWorldManager(this.mcServer.worldServerForDimension(llllllllllllllIIIIIIIIIIlIllIlll.dimension));
        }
        else {
            llllllllllllllIIIIIIIIIIlIllllIl = new ItemInWorldManager(this.mcServer.worldServerForDimension(llllllllllllllIIIIIIIIIIlIllIlll.dimension));
        }
        final EntityPlayerMP llllllllllllllIIIIIIIIIIlIllllII = new EntityPlayerMP(this.mcServer, this.mcServer.worldServerForDimension(llllllllllllllIIIIIIIIIIlIllIlll.dimension), llllllllllllllIIIIIIIIIIlIllIlll.getGameProfile(), (ItemInWorldManager)llllllllllllllIIIIIIIIIIlIllllIl);
        llllllllllllllIIIIIIIIIIlIllllII.playerNetServerHandler = llllllllllllllIIIIIIIIIIlIllIlll.playerNetServerHandler;
        llllllllllllllIIIIIIIIIIlIllllII.clonePlayer(llllllllllllllIIIIIIIIIIlIllIlll, llllllllllllllIIIIIIIIIIlIllIlIl);
        llllllllllllllIIIIIIIIIIlIllllII.setEntityId(llllllllllllllIIIIIIIIIIlIllIlll.getEntityId());
        llllllllllllllIIIIIIIIIIlIllllII.func_174817_o(llllllllllllllIIIIIIIIIIlIllIlll);
        final WorldServer llllllllllllllIIIIIIIIIIlIlllIll = this.mcServer.worldServerForDimension(llllllllllllllIIIIIIIIIIlIllIlll.dimension);
        this.func_72381_a(llllllllllllllIIIIIIIIIIlIllllII, llllllllllllllIIIIIIIIIIlIllIlll, llllllllllllllIIIIIIIIIIlIlllIll);
        if (llllllllllllllIIIIIIIIIIllIIIIII != null) {
            final BlockPos llllllllllllllIIIIIIIIIIlIlllIlI = EntityPlayer.func_180467_a(this.mcServer.worldServerForDimension(llllllllllllllIIIIIIIIIIlIllIlll.dimension), llllllllllllllIIIIIIIIIIllIIIIII, llllllllllllllIIIIIIIIIIlIllllll);
            if (llllllllllllllIIIIIIIIIIlIlllIlI != null) {
                llllllllllllllIIIIIIIIIIlIllllII.setLocationAndAngles(llllllllllllllIIIIIIIIIIlIlllIlI.getX() + 0.5f, llllllllllllllIIIIIIIIIIlIlllIlI.getY() + 0.1f, llllllllllllllIIIIIIIIIIlIlllIlI.getZ() + 0.5f, 0.0f, 0.0f);
                llllllllllllllIIIIIIIIIIlIllllII.func_180473_a(llllllllllllllIIIIIIIIIIllIIIIII, llllllllllllllIIIIIIIIIIlIllllll);
            }
            else {
                llllllllllllllIIIIIIIIIIlIllllII.playerNetServerHandler.sendPacket(new S2BPacketChangeGameState(0, 0.0f));
            }
        }
        llllllllllllllIIIIIIIIIIlIlllIll.theChunkProviderServer.loadChunk((int)llllllllllllllIIIIIIIIIIlIllllII.posX >> 4, (int)llllllllllllllIIIIIIIIIIlIllllII.posZ >> 4);
        while (!llllllllllllllIIIIIIIIIIlIlllIll.getCollidingBoundingBoxes(llllllllllllllIIIIIIIIIIlIllllII, llllllllllllllIIIIIIIIIIlIllllII.getEntityBoundingBox()).isEmpty() && llllllllllllllIIIIIIIIIIlIllllII.posY < 256.0) {
            llllllllllllllIIIIIIIIIIlIllllII.setPosition(llllllllllllllIIIIIIIIIIlIllllII.posX, llllllllllllllIIIIIIIIIIlIllllII.posY + 1.0, llllllllllllllIIIIIIIIIIlIllllII.posZ);
        }
        llllllllllllllIIIIIIIIIIlIllllII.playerNetServerHandler.sendPacket(new S07PacketRespawn(llllllllllllllIIIIIIIIIIlIllllII.dimension, llllllllllllllIIIIIIIIIIlIllllII.worldObj.getDifficulty(), llllllllllllllIIIIIIIIIIlIllllII.worldObj.getWorldInfo().getTerrainType(), llllllllllllllIIIIIIIIIIlIllllII.theItemInWorldManager.getGameType()));
        final BlockPos llllllllllllllIIIIIIIIIIlIlllIIl = llllllllllllllIIIIIIIIIIlIlllIll.getSpawnPoint();
        llllllllllllllIIIIIIIIIIlIllllII.playerNetServerHandler.setPlayerLocation(llllllllllllllIIIIIIIIIIlIllllII.posX, llllllllllllllIIIIIIIIIIlIllllII.posY, llllllllllllllIIIIIIIIIIlIllllII.posZ, llllllllllllllIIIIIIIIIIlIllllII.rotationYaw, llllllllllllllIIIIIIIIIIlIllllII.rotationPitch);
        llllllllllllllIIIIIIIIIIlIllllII.playerNetServerHandler.sendPacket(new S05PacketSpawnPosition(llllllllllllllIIIIIIIIIIlIlllIIl));
        llllllllllllllIIIIIIIIIIlIllllII.playerNetServerHandler.sendPacket(new S1FPacketSetExperience(llllllllllllllIIIIIIIIIIlIllllII.experience, llllllllllllllIIIIIIIIIIlIllllII.experienceTotal, llllllllllllllIIIIIIIIIIlIllllII.experienceLevel));
        this.updateTimeAndWeatherForPlayer(llllllllllllllIIIIIIIIIIlIllllII, llllllllllllllIIIIIIIIIIlIlllIll);
        llllllllllllllIIIIIIIIIIlIlllIll.getPlayerManager().addPlayer(llllllllllllllIIIIIIIIIIlIllllII);
        llllllllllllllIIIIIIIIIIlIlllIll.spawnEntityInWorld(llllllllllllllIIIIIIIIIIlIllllII);
        this.playerEntityList.add(llllllllllllllIIIIIIIIIIlIllllII);
        this.field_177454_f.put(llllllllllllllIIIIIIIIIIlIllllII.getUniqueID(), llllllllllllllIIIIIIIIIIlIllllII);
        llllllllllllllIIIIIIIIIIlIllllII.addSelfToInternalCraftingInventory();
        llllllllllllllIIIIIIIIIIlIllllII.setHealth(llllllllllllllIIIIIIIIIIlIllllII.getHealth());
        return llllllllllllllIIIIIIIIIIlIllllII;
    }
    
    public void sendToAllNear(final double lllllllllllllIllllllllllllIlllll, final double lllllllllllllIlllllllllllllIIllI, final double lllllllllllllIlllllllllllllIIlIl, final double lllllllllllllIlllllllllllllIIlII, final int lllllllllllllIlllllllllllllIIIll, final Packet lllllllllllllIlllllllllllllIIIIl) {
        this.sendToAllNearExcept(null, lllllllllllllIllllllllllllIlllll, lllllllllllllIlllllllllllllIIllI, lllllllllllllIlllllllllllllIIlIl, lllllllllllllIlllllllllllllIIlII, lllllllllllllIlllllllllllllIIIll, lllllllllllllIlllllllllllllIIIIl);
    }
    
    public EntityPlayerMP getPlayerByUsername(final String lllllllllllllIllllllllllllllIllI) {
        for (final EntityPlayerMP lllllllllllllIllllllllllllllIlII : this.playerEntityList) {
            if (lllllllllllllIllllllllllllllIlII.getName().equalsIgnoreCase(lllllllllllllIllllllllllllllIllI)) {
                return lllllllllllllIllllllllllllllIlII;
            }
        }
        return null;
    }
    
    public String allowUserToConnect(final SocketAddress llllllllllllllIIIIIIIIIIlllIlIlI, final GameProfile llllllllllllllIIIIIIIIIIlllIlIIl) {
        if (this.bannedPlayers.isBanned(llllllllllllllIIIIIIIIIIlllIlIIl)) {
            final UserListBansEntry llllllllllllllIIIIIIIIIIlllIllIl = (UserListBansEntry)this.bannedPlayers.getEntry(llllllllllllllIIIIIIIIIIlllIlIIl);
            String llllllllllllllIIIIIIIIIIlllIllll = String.valueOf(new StringBuilder("You are banned from this server!\nReason: ").append(llllllllllllllIIIIIIIIIIlllIllIl.getBanReason()));
            if (llllllllllllllIIIIIIIIIIlllIllIl.getBanEndDate() != null) {
                llllllllllllllIIIIIIIIIIlllIllll = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIIIIIIIIlllIllll)).append("\nYour ban will be removed on ").append(ServerConfigurationManager.dateFormat.format(llllllllllllllIIIIIIIIIIlllIllIl.getBanEndDate())));
            }
            return llllllllllllllIIIIIIIIIIlllIllll;
        }
        if (!this.canJoin(llllllllllllllIIIIIIIIIIlllIlIIl)) {
            return "You are not white-listed on this server!";
        }
        if (this.bannedIPs.isBanned(llllllllllllllIIIIIIIIIIlllIlIlI)) {
            final IPBanEntry llllllllllllllIIIIIIIIIIlllIllII = this.bannedIPs.getBanEntry(llllllllllllllIIIIIIIIIIlllIlIlI);
            String llllllllllllllIIIIIIIIIIlllIlllI = String.valueOf(new StringBuilder("Your IP address is banned from this server!\nReason: ").append(llllllllllllllIIIIIIIIIIlllIllII.getBanReason()));
            if (llllllllllllllIIIIIIIIIIlllIllII.getBanEndDate() != null) {
                llllllllllllllIIIIIIIIIIlllIlllI = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIIIIIIIIlllIlllI)).append("\nYour ban will be removed on ").append(ServerConfigurationManager.dateFormat.format(llllllllllllllIIIIIIIIIIlllIllII.getBanEndDate())));
            }
            return llllllllllllllIIIIIIIIIIlllIlllI;
        }
        return (this.playerEntityList.size() >= this.maxPlayers) ? "The server is full!" : null;
    }
    
    private void func_72381_a(final EntityPlayerMP lllllllllllllIllllllllllIIlllllI, final EntityPlayerMP lllllllllllllIllllllllllIIlllIIl, final World lllllllllllllIllllllllllIIlllIII) {
        if (lllllllllllllIllllllllllIIlllIIl != null) {
            lllllllllllllIllllllllllIIlllllI.theItemInWorldManager.setGameType(lllllllllllllIllllllllllIIlllIIl.theItemInWorldManager.getGameType());
        }
        else if (this.gameType != null) {
            lllllllllllllIllllllllllIIlllllI.theItemInWorldManager.setGameType(this.gameType);
        }
        lllllllllllllIllllllllllIIlllllI.theItemInWorldManager.initializeGameType(lllllllllllllIllllllllllIIlllIII.getWorldInfo().getGameType());
    }
    
    public boolean canJoin(final GameProfile llllllllllllllIIIIIIIIIIIIIIIlII) {
        return !this.whiteListEnforced || this.ops.hasEntry(llllllllllllllIIIIIIIIIIIIIIIlII) || this.whiteListedPlayers.hasEntry(llllllllllllllIIIIIIIIIIIIIIIlII);
    }
    
    public void transferEntityToWorld(final Entity llllllllllllllIIIIIIIIIIlIIIllII, final int llllllllllllllIIIIIIIIIIlIIIlIll, final WorldServer llllllllllllllIIIIIIIIIIlIIIIIII, final WorldServer llllllllllllllIIIIIIIIIIlIIIlIIl) {
        double llllllllllllllIIIIIIIIIIlIIIlIII = llllllllllllllIIIIIIIIIIlIIIllII.posX;
        double llllllllllllllIIIIIIIIIIlIIIIlll = llllllllllllllIIIIIIIIIIlIIIllII.posZ;
        final double llllllllllllllIIIIIIIIIIlIIIIllI = 8.0;
        final float llllllllllllllIIIIIIIIIIlIIIIlIl = llllllllllllllIIIIIIIIIIlIIIllII.rotationYaw;
        llllllllllllllIIIIIIIIIIlIIIIIII.theProfiler.startSection("moving");
        if (llllllllllllllIIIIIIIIIIlIIIllII.dimension == -1) {
            llllllllllllllIIIIIIIIIIlIIIlIII = MathHelper.clamp_double(llllllllllllllIIIIIIIIIIlIIIlIII / llllllllllllllIIIIIIIIIIlIIIIllI, llllllllllllllIIIIIIIIIIlIIIlIIl.getWorldBorder().minX() + 16.0, llllllllllllllIIIIIIIIIIlIIIlIIl.getWorldBorder().maxX() - 16.0);
            llllllllllllllIIIIIIIIIIlIIIIlll = MathHelper.clamp_double(llllllllllllllIIIIIIIIIIlIIIIlll / llllllllllllllIIIIIIIIIIlIIIIllI, llllllllllllllIIIIIIIIIIlIIIlIIl.getWorldBorder().minZ() + 16.0, llllllllllllllIIIIIIIIIIlIIIlIIl.getWorldBorder().maxZ() - 16.0);
            llllllllllllllIIIIIIIIIIlIIIllII.setLocationAndAngles(llllllllllllllIIIIIIIIIIlIIIlIII, llllllllllllllIIIIIIIIIIlIIIllII.posY, llllllllllllllIIIIIIIIIIlIIIIlll, llllllllllllllIIIIIIIIIIlIIIllII.rotationYaw, llllllllllllllIIIIIIIIIIlIIIllII.rotationPitch);
            if (llllllllllllllIIIIIIIIIIlIIIllII.isEntityAlive()) {
                llllllllllllllIIIIIIIIIIlIIIIIII.updateEntityWithOptionalForce(llllllllllllllIIIIIIIIIIlIIIllII, false);
            }
        }
        else if (llllllllllllllIIIIIIIIIIlIIIllII.dimension == 0) {
            llllllllllllllIIIIIIIIIIlIIIlIII = MathHelper.clamp_double(llllllllllllllIIIIIIIIIIlIIIlIII * llllllllllllllIIIIIIIIIIlIIIIllI, llllllllllllllIIIIIIIIIIlIIIlIIl.getWorldBorder().minX() + 16.0, llllllllllllllIIIIIIIIIIlIIIlIIl.getWorldBorder().maxX() - 16.0);
            llllllllllllllIIIIIIIIIIlIIIIlll = MathHelper.clamp_double(llllllllllllllIIIIIIIIIIlIIIIlll * llllllllllllllIIIIIIIIIIlIIIIllI, llllllllllllllIIIIIIIIIIlIIIlIIl.getWorldBorder().minZ() + 16.0, llllllllllllllIIIIIIIIIIlIIIlIIl.getWorldBorder().maxZ() - 16.0);
            llllllllllllllIIIIIIIIIIlIIIllII.setLocationAndAngles(llllllllllllllIIIIIIIIIIlIIIlIII, llllllllllllllIIIIIIIIIIlIIIllII.posY, llllllllllllllIIIIIIIIIIlIIIIlll, llllllllllllllIIIIIIIIIIlIIIllII.rotationYaw, llllllllllllllIIIIIIIIIIlIIIllII.rotationPitch);
            if (llllllllllllllIIIIIIIIIIlIIIllII.isEntityAlive()) {
                llllllllllllllIIIIIIIIIIlIIIIIII.updateEntityWithOptionalForce(llllllllllllllIIIIIIIIIIlIIIllII, false);
            }
        }
        else {
            BlockPos llllllllllllllIIIIIIIIIIlIIIIIll = null;
            if (llllllllllllllIIIIIIIIIIlIIIlIll == 1) {
                final BlockPos llllllllllllllIIIIIIIIIIlIIIIlII = llllllllllllllIIIIIIIIIIlIIIlIIl.getSpawnPoint();
            }
            else {
                llllllllllllllIIIIIIIIIIlIIIIIll = llllllllllllllIIIIIIIIIIlIIIlIIl.func_180504_m();
            }
            llllllllllllllIIIIIIIIIIlIIIlIII = llllllllllllllIIIIIIIIIIlIIIIIll.getX();
            llllllllllllllIIIIIIIIIIlIIIllII.posY = llllllllllllllIIIIIIIIIIlIIIIIll.getY();
            llllllllllllllIIIIIIIIIIlIIIIlll = llllllllllllllIIIIIIIIIIlIIIIIll.getZ();
            llllllllllllllIIIIIIIIIIlIIIllII.setLocationAndAngles(llllllllllllllIIIIIIIIIIlIIIlIII, llllllllllllllIIIIIIIIIIlIIIllII.posY, llllllllllllllIIIIIIIIIIlIIIIlll, 90.0f, 0.0f);
            if (llllllllllllllIIIIIIIIIIlIIIllII.isEntityAlive()) {
                llllllllllllllIIIIIIIIIIlIIIIIII.updateEntityWithOptionalForce(llllllllllllllIIIIIIIIIIlIIIllII, false);
            }
        }
        llllllllllllllIIIIIIIIIIlIIIIIII.theProfiler.endSection();
        if (llllllllllllllIIIIIIIIIIlIIIlIll != 1) {
            llllllllllllllIIIIIIIIIIlIIIIIII.theProfiler.startSection("placing");
            llllllllllllllIIIIIIIIIIlIIIlIII = MathHelper.clamp_int((int)llllllllllllllIIIIIIIIIIlIIIlIII, -29999872, 29999872);
            llllllllllllllIIIIIIIIIIlIIIIlll = MathHelper.clamp_int((int)llllllllllllllIIIIIIIIIIlIIIIlll, -29999872, 29999872);
            if (llllllllllllllIIIIIIIIIIlIIIllII.isEntityAlive()) {
                llllllllllllllIIIIIIIIIIlIIIllII.setLocationAndAngles(llllllllllllllIIIIIIIIIIlIIIlIII, llllllllllllllIIIIIIIIIIlIIIllII.posY, llllllllllllllIIIIIIIIIIlIIIIlll, llllllllllllllIIIIIIIIIIlIIIllII.rotationYaw, llllllllllllllIIIIIIIIIIlIIIllII.rotationPitch);
                llllllllllllllIIIIIIIIIIlIIIlIIl.getDefaultTeleporter().func_180266_a(llllllllllllllIIIIIIIIIIlIIIllII, llllllllllllllIIIIIIIIIIlIIIIlIl);
                llllllllllllllIIIIIIIIIIlIIIlIIl.spawnEntityInWorld(llllllllllllllIIIIIIIIIIlIIIllII);
                llllllllllllllIIIIIIIIIIlIIIlIIl.updateEntityWithOptionalForce(llllllllllllllIIIIIIIIIIlIIIllII, false);
            }
            llllllllllllllIIIIIIIIIIlIIIIIII.theProfiler.endSection();
        }
        llllllllllllllIIIIIIIIIIlIIIllII.setWorld(llllllllllllllIIIIIIIIIIlIIIlIIl);
    }
    
    public int getViewDistance() {
        return this.viewDistance;
    }
    
    public void sendPacketToAllPlayersInDimension(final Packet llllllllllllllIIIIIIIIIIIllIIIlI, final int llllllllllllllIIIIIIIIIIIllIIllI) {
        for (int llllllllllllllIIIIIIIIIIIllIIlIl = 0; llllllllllllllIIIIIIIIIIIllIIlIl < this.playerEntityList.size(); ++llllllllllllllIIIIIIIIIIIllIIlIl) {
            final EntityPlayerMP llllllllllllllIIIIIIIIIIIllIIlII = this.playerEntityList.get(llllllllllllllIIIIIIIIIIIllIIlIl);
            if (llllllllllllllIIIIIIIIIIIllIIlII.dimension == llllllllllllllIIIIIIIIIIIllIIllI) {
                llllllllllllllIIIIIIIIIIIllIIlII.playerNetServerHandler.sendPacket(llllllllllllllIIIIIIIIIIIllIIIlI);
            }
        }
    }
    
    public void removeOp(final GameProfile llllllllllllllIIIIIIIIIIIIIIlIlI) {
        this.ops.removeEntry(llllllllllllllIIIIIIIIIIIIIIlIlI);
    }
}
