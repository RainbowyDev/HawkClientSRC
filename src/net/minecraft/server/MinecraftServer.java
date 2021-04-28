package net.minecraft.server;

import net.minecraft.profiler.*;
import com.mojang.authlib.minecraft.*;
import net.minecraft.server.management.*;
import java.net.*;
import com.mojang.authlib.yggdrasil.*;
import java.security.*;
import net.minecraft.network.play.server.*;
import net.minecraft.network.*;
import net.minecraft.crash.*;
import net.minecraft.server.gui.*;
import com.google.common.collect.*;
import net.minecraft.world.chunk.storage.*;
import net.minecraft.entity.*;
import com.mojang.authlib.*;
import net.minecraft.entity.player.*;
import org.apache.logging.log4j.*;
import net.minecraft.world.demo.*;
import net.minecraft.world.storage.*;
import org.apache.commons.lang3.*;
import java.util.concurrent.*;
import javax.imageio.*;
import io.netty.handler.codec.base64.*;
import com.google.common.base.*;
import io.netty.buffer.*;
import java.awt.image.*;
import net.minecraft.world.*;
import java.awt.*;
import com.google.common.util.concurrent.*;
import net.minecraft.util.*;
import net.minecraft.command.*;
import java.io.*;
import java.text.*;
import java.util.*;

public abstract class MinecraftServer implements ICommandSender, Runnable, IThreadListener, IPlayerUsage
{
    private /* synthetic */ String folderName;
    private /* synthetic */ int serverPort;
    private final /* synthetic */ Random random;
    public /* synthetic */ String currentTask;
    private /* synthetic */ int buildLimit;
    private /* synthetic */ boolean canSpawnNPCs;
    private /* synthetic */ boolean serverRunning;
    public final /* synthetic */ Profiler theProfiler;
    private /* synthetic */ String userMessage;
    private final /* synthetic */ PlayerUsageSnooper usageSnooper;
    private /* synthetic */ boolean serverIsRunning;
    private /* synthetic */ boolean allowFlight;
    private final /* synthetic */ List playersOnline;
    private static /* synthetic */ MinecraftServer mcServer;
    public final /* synthetic */ long[] tickTimeArray;
    private /* synthetic */ ServerConfigurationManager serverConfigManager;
    private final /* synthetic */ MinecraftSessionService sessionService;
    private static final /* synthetic */ Logger logger;
    private final /* synthetic */ PlayerProfileCache profileCache;
    private final /* synthetic */ GameProfileRepository profileRepo;
    private final /* synthetic */ ServerStatusResponse statusResponse;
    private final /* synthetic */ ICommandManager commandManager;
    private /* synthetic */ boolean enableBonusChest;
    private /* synthetic */ boolean onlineMode;
    private /* synthetic */ int tickCounter;
    private /* synthetic */ String motd;
    private /* synthetic */ String resourcePackHash;
    protected final /* synthetic */ Proxy serverProxy;
    private /* synthetic */ long timeOfLastWarning;
    private final /* synthetic */ File anvilFile;
    private /* synthetic */ boolean pvpEnabled;
    private /* synthetic */ boolean isDemo;
    private /* synthetic */ int maxPlayerIdleMinutes;
    private /* synthetic */ String serverOwner;
    private /* synthetic */ boolean isGamemodeForced;
    private final /* synthetic */ YggdrasilAuthenticationService authService;
    private /* synthetic */ String worldName;
    private /* synthetic */ Thread serverThread;
    public /* synthetic */ long[][] timeOfLastDimensionTick;
    private /* synthetic */ long nanoTimeSinceStatusRefresh;
    private /* synthetic */ long currentTime;
    public /* synthetic */ int percentDone;
    public /* synthetic */ WorldServer[] worldServers;
    private /* synthetic */ KeyPair serverKeyPair;
    private /* synthetic */ boolean startProfiling;
    private /* synthetic */ boolean serverStopped;
    protected final /* synthetic */ Queue futureTaskQueue;
    private /* synthetic */ boolean canSpawnAnimals;
    private final /* synthetic */ NetworkSystem networkSystem;
    private /* synthetic */ String resourcePackUrl;
    private /* synthetic */ boolean worldIsBeingDeleted;
    private final /* synthetic */ ISaveFormat anvilConverterForAnvilFile;
    
    public abstract int getOpPermissionLevel();
    
    public void setConfigManager(final ServerConfigurationManager llllllllllllllIllIIIIllllIlIIlIl) {
        this.serverConfigManager = llllllllllllllIllIIIIllllIlIIlIl;
    }
    
    public boolean getCanSpawnNPCs() {
        return this.canSpawnNPCs;
    }
    
    public boolean getForceGamemode() {
        return this.isGamemodeForced;
    }
    
    public File getDataDirectory() {
        return new File(".");
    }
    
    public boolean isServerInOnlineMode() {
        return this.onlineMode;
    }
    
    public void updateTimeLightAndEntities() {
        this.theProfiler.startSection("jobs");
        final Queue llllllllllllllIllIIIlIIIllIIllII = this.futureTaskQueue;
        synchronized (this.futureTaskQueue) {
            while (!this.futureTaskQueue.isEmpty()) {
                try {
                    this.futureTaskQueue.poll().run();
                }
                catch (Throwable llllllllllllllIllIIIlIIIllIIlIll) {
                    MinecraftServer.logger.fatal((Object)llllllllllllllIllIIIlIIIllIIlIll);
                }
            }
        }
        // monitorexit(this.futureTaskQueue)
        this.theProfiler.endStartSection("levels");
        for (int llllllllllllllIllIIIlIIIllIIlIlI = 0; llllllllllllllIllIIIlIIIllIIlIlI < this.worldServers.length; ++llllllllllllllIllIIIlIIIllIIlIlI) {
            final long llllllllllllllIllIIIlIIIllIIlIIl = System.nanoTime();
            if (llllllllllllllIllIIIlIIIllIIlIlI == 0 || this.getAllowNether()) {
                final WorldServer llllllllllllllIllIIIlIIIllIIlIII = this.worldServers[llllllllllllllIllIIIlIIIllIIlIlI];
                this.theProfiler.startSection(llllllllllllllIllIIIlIIIllIIlIII.getWorldInfo().getWorldName());
                if (this.tickCounter % 20 == 0) {
                    this.theProfiler.startSection("timeSync");
                    this.serverConfigManager.sendPacketToAllPlayersInDimension(new S03PacketTimeUpdate(llllllllllllllIllIIIlIIIllIIlIII.getTotalWorldTime(), llllllllllllllIllIIIlIIIllIIlIII.getWorldTime(), llllllllllllllIllIIIlIIIllIIlIII.getGameRules().getGameRuleBooleanValue("doDaylightCycle")), llllllllllllllIllIIIlIIIllIIlIII.provider.getDimensionId());
                    this.theProfiler.endSection();
                }
                this.theProfiler.startSection("tick");
                try {
                    llllllllllllllIllIIIlIIIllIIlIII.tick();
                }
                catch (Throwable llllllllllllllIllIIIlIIIllIIIlIl) {
                    final CrashReport llllllllllllllIllIIIlIIIllIIIlll = CrashReport.makeCrashReport(llllllllllllllIllIIIlIIIllIIIlIl, "Exception ticking world");
                    llllllllllllllIllIIIlIIIllIIlIII.addWorldInfoToCrashReport(llllllllllllllIllIIIlIIIllIIIlll);
                    throw new ReportedException(llllllllllllllIllIIIlIIIllIIIlll);
                }
                try {
                    llllllllllllllIllIIIlIIIllIIlIII.updateEntities();
                }
                catch (Throwable llllllllllllllIllIIIlIIIllIIIlII) {
                    final CrashReport llllllllllllllIllIIIlIIIllIIIllI = CrashReport.makeCrashReport(llllllllllllllIllIIIlIIIllIIIlII, "Exception ticking world entities");
                    llllllllllllllIllIIIlIIIllIIlIII.addWorldInfoToCrashReport(llllllllllllllIllIIIlIIIllIIIllI);
                    throw new ReportedException(llllllllllllllIllIIIlIIIllIIIllI);
                }
                this.theProfiler.endSection();
                this.theProfiler.startSection("tracker");
                llllllllllllllIllIIIlIIIllIIlIII.getEntityTracker().updateTrackedEntities();
                this.theProfiler.endSection();
                this.theProfiler.endSection();
            }
            this.timeOfLastDimensionTick[llllllllllllllIllIIIlIIIllIIlIlI][this.tickCounter % 100] = System.nanoTime() - llllllllllllllIllIIIlIIIllIIlIIl;
        }
        this.theProfiler.endStartSection("connection");
        this.getNetworkSystem().networkTick();
        this.theProfiler.endStartSection("players");
        this.serverConfigManager.onTick();
        this.theProfiler.endStartSection("tickables");
        for (int llllllllllllllIllIIIlIIIllIIlIlI = 0; llllllllllllllIllIIIlIIIllIIlIlI < this.playersOnline.size(); ++llllllllllllllIllIIIlIIIllIIlIlI) {
            this.playersOnline.get(llllllllllllllIllIIIlIIIllIIlIlI).update();
        }
        this.theProfiler.endSection();
    }
    
    public abstract WorldSettings.GameType getGameType();
    
    public int getBuildLimit() {
        return this.buildLimit;
    }
    
    public MinecraftServer(final File llllllllllllllIllIIIlIIllIllIIlI, final Proxy llllllllllllllIllIIIlIIllIllIIIl, final File llllllllllllllIllIIIlIIllIllIlII) {
        this.usageSnooper = new PlayerUsageSnooper("server", this, getCurrentTimeMillis());
        this.playersOnline = Lists.newArrayList();
        this.theProfiler = new Profiler();
        this.statusResponse = new ServerStatusResponse();
        this.random = new Random();
        this.serverPort = -1;
        this.serverRunning = true;
        this.maxPlayerIdleMinutes = 0;
        this.tickTimeArray = new long[100];
        this.resourcePackUrl = "";
        this.resourcePackHash = "";
        this.nanoTimeSinceStatusRefresh = 0L;
        this.futureTaskQueue = Queues.newArrayDeque();
        this.currentTime = getCurrentTimeMillis();
        this.serverProxy = llllllllllllllIllIIIlIIllIllIIIl;
        MinecraftServer.mcServer = this;
        this.anvilFile = llllllllllllllIllIIIlIIllIllIIlI;
        this.networkSystem = new NetworkSystem(this);
        this.profileCache = new PlayerProfileCache(this, llllllllllllllIllIIIlIIllIllIlII);
        this.commandManager = this.createNewCommandManager();
        this.anvilConverterForAnvilFile = new AnvilSaveConverter(llllllllllllllIllIIIlIIllIllIIlI);
        this.authService = new YggdrasilAuthenticationService(llllllllllllllIllIIIlIIllIllIIIl, UUID.randomUUID().toString());
        this.sessionService = this.authService.createMinecraftSessionService();
        this.profileRepo = this.authService.createProfileRepository();
    }
    
    public void stopServer() {
        if (!this.worldIsBeingDeleted) {
            MinecraftServer.logger.info("Stopping server");
            if (this.getNetworkSystem() != null) {
                this.getNetworkSystem().terminateEndpoints();
            }
            if (this.serverConfigManager != null) {
                MinecraftServer.logger.info("Saving players");
                this.serverConfigManager.saveAllPlayerData();
                this.serverConfigManager.removeAllPlayers();
            }
            if (this.worldServers != null) {
                MinecraftServer.logger.info("Saving worlds");
                this.saveAllWorlds(false);
                for (int llllllllllllllIllIIIlIIlIIlIIlII = 0; llllllllllllllIllIIIlIIlIIlIIlII < this.worldServers.length; ++llllllllllllllIllIIIlIIlIIlIIlII) {
                    final WorldServer llllllllllllllIllIIIlIIlIIlIIIll = this.worldServers[llllllllllllllIllIIIlIIlIIlIIlII];
                    llllllllllllllIllIIIlIIlIIlIIIll.flush();
                }
            }
            if (this.usageSnooper.isSnooperRunning()) {
                this.usageSnooper.stopSnooper();
            }
        }
    }
    
    public int getCurrentPlayerCount() {
        return this.serverConfigManager.getCurrentPlayerCount();
    }
    
    @Override
    public boolean sendCommandFeedback() {
        return getServer().worldServers[0].getGameRules().getGameRuleBooleanValue("sendCommandFeedback");
    }
    
    public void setAllowFlight(final boolean llllllllllllllIllIIIIllllIlllllI) {
        this.allowFlight = llllllllllllllIllIIIIllllIlllllI;
    }
    
    public int getMaxPlayerIdleMinutes() {
        return this.maxPlayerIdleMinutes;
    }
    
    protected ServerCommandManager createNewCommandManager() {
        return new ServerCommandManager();
    }
    
    public ServerConfigurationManager getConfigurationManager() {
        return this.serverConfigManager;
    }
    
    public abstract EnumDifficulty getDifficulty();
    
    public WorldServer worldServerForDimension(final int llllllllllllllIllIIIlIIIlIlIlIIl) {
        return (llllllllllllllIllIIIlIIIlIlIlIIl == -1) ? this.worldServers[1] : ((llllllllllllllIllIIIlIIIlIlIlIIl == 1) ? this.worldServers[2] : this.worldServers[0]);
    }
    
    public Entity getEntityFromUuid(final UUID llllllllllllllIllIIIIlllIlIlIlII) {
        for (final WorldServer llllllllllllllIllIIIIlllIlIlIIII : this.worldServers) {
            if (llllllllllllllIllIIIIlllIlIlIIII != null) {
                final Entity llllllllllllllIllIIIIlllIlIIllll = llllllllllllllIllIIIIlllIlIlIIII.getEntityFromUuid(llllllllllllllIllIIIIlllIlIlIlII);
                if (llllllllllllllIllIIIIlllIlIIllll != null) {
                    return llllllllllllllIllIIIIlllIlIIllll;
                }
            }
        }
        return null;
    }
    
    @Override
    public String getName() {
        return "Server";
    }
    
    public boolean isDemo() {
        return this.isDemo;
    }
    
    public void tick() {
        final long llllllllllllllIllIIIlIIIllIlllIl = System.nanoTime();
        ++this.tickCounter;
        if (this.startProfiling) {
            this.startProfiling = false;
            this.theProfiler.profilingEnabled = true;
            this.theProfiler.clearProfiling();
        }
        this.theProfiler.startSection("root");
        this.updateTimeLightAndEntities();
        if (llllllllllllllIllIIIlIIIllIlllIl - this.nanoTimeSinceStatusRefresh >= 5000000000L) {
            this.nanoTimeSinceStatusRefresh = llllllllllllllIllIIIlIIIllIlllIl;
            this.statusResponse.setPlayerCountData(new ServerStatusResponse.PlayerCountData(this.getMaxPlayers(), this.getCurrentPlayerCount()));
            final GameProfile[] llllllllllllllIllIIIlIIIllIlllII = new GameProfile[Math.min(this.getCurrentPlayerCount(), 12)];
            final int llllllllllllllIllIIIlIIIllIllIll = MathHelper.getRandomIntegerInRange(this.random, 0, this.getCurrentPlayerCount() - llllllllllllllIllIIIlIIIllIlllII.length);
            for (int llllllllllllllIllIIIlIIIllIllIlI = 0; llllllllllllllIllIIIlIIIllIllIlI < llllllllllllllIllIIIlIIIllIlllII.length; ++llllllllllllllIllIIIlIIIllIllIlI) {
                llllllllllllllIllIIIlIIIllIlllII[llllllllllllllIllIIIlIIIllIllIlI] = this.serverConfigManager.playerEntityList.get(llllllllllllllIllIIIlIIIllIllIll + llllllllllllllIllIIIlIIIllIllIlI).getGameProfile();
            }
            Collections.shuffle(Arrays.asList(llllllllllllllIllIIIlIIIllIlllII));
            this.statusResponse.getPlayerCountData().setPlayers(llllllllllllllIllIIIlIIIllIlllII);
        }
        if (this.tickCounter % 900 == 0) {
            this.theProfiler.startSection("save");
            this.serverConfigManager.saveAllPlayerData();
            this.saveAllWorlds(true);
            this.theProfiler.endSection();
        }
        this.theProfiler.startSection("tallying");
        this.tickTimeArray[this.tickCounter % 100] = System.nanoTime() - llllllllllllllIllIIIlIIIllIlllIl;
        this.theProfiler.endSection();
        this.theProfiler.startSection("snooper");
        if (!this.usageSnooper.isSnooperRunning() && this.tickCounter > 100) {
            this.usageSnooper.startSnooper();
        }
        if (this.tickCounter % 6000 == 0) {
            this.usageSnooper.addMemoryStatsToSnooper();
        }
        this.theProfiler.endSection();
        this.theProfiler.endSection();
    }
    
    public boolean serverIsInRunLoop() {
        return this.serverIsRunning;
    }
    
    public ISaveFormat getActiveAnvilConverter() {
        return this.anvilConverterForAnvilFile;
    }
    
    public int getTickCounter() {
        return this.tickCounter;
    }
    
    public void setDifficultyForAllWorlds(final EnumDifficulty llllllllllllllIllIIIlIIIIIllIIIl) {
        for (int llllllllllllllIllIIIlIIIIIllIlII = 0; llllllllllllllIllIIIlIIIIIllIlII < this.worldServers.length; ++llllllllllllllIllIIIlIIIIIllIlII) {
            final WorldServer llllllllllllllIllIIIlIIIIIllIIll = this.worldServers[llllllllllllllIllIIIlIIIIIllIlII];
            if (llllllllllllllIllIIIlIIIIIllIIll != null) {
                if (llllllllllllllIllIIIlIIIIIllIIll.getWorldInfo().isHardcoreModeEnabled()) {
                    llllllllllllllIllIIIlIIIIIllIIll.getWorldInfo().setDifficulty(EnumDifficulty.HARD);
                    llllllllllllllIllIIIlIIIIIllIIll.setAllowedSpawnTypes(true, true);
                }
                else if (this.isSinglePlayer()) {
                    llllllllllllllIllIIIlIIIIIllIIll.getWorldInfo().setDifficulty(llllllllllllllIllIIIlIIIIIllIIIl);
                    llllllllllllllIllIIIlIIIIIllIIll.setAllowedSpawnTypes(llllllllllllllIllIIIlIIIIIllIIll.getDifficulty() != EnumDifficulty.PEACEFUL, true);
                }
                else {
                    llllllllllllllIllIIIlIIIIIllIIll.getWorldInfo().setDifficulty(llllllllllllllIllIIIlIIIIIllIIIl);
                    llllllllllllllIllIIIlIIIIIllIIll.setAllowedSpawnTypes(this.allowSpawnMonsters(), this.canSpawnAnimals);
                }
            }
        }
    }
    
    public boolean isBlockProtected(final World llllllllllllllIllIIIIllllIIIIIIl, final BlockPos llllllllllllllIllIIIIllllIIIIIII, final EntityPlayer llllllllllllllIllIIIIlllIlllllll) {
        return false;
    }
    
    static {
        __OBFID = "CL_00001462";
        logger = LogManager.getLogger();
        USER_CACHE_FILE = new File("usercache.json");
    }
    
    public String getMOTD() {
        return this.motd;
    }
    
    public void setWorldName(final String llllllllllllllIllIIIlIIIIlIIIllI) {
        this.worldName = llllllllllllllIllIIIlIIIIlIIIllI;
    }
    
    public void startServerThread() {
        this.serverThread = new Thread(this, "Server thread");
        this.serverThread.start();
    }
    
    public void setDemo(final boolean llllllllllllllIllIIIlIIIIIlIIlIl) {
        this.isDemo = llllllllllllllIllIIIlIIIIIlIIlIl;
    }
    
    public String getServerOwner() {
        return this.serverOwner;
    }
    
    public boolean isPVPEnabled() {
        return this.pvpEnabled;
    }
    
    protected void loadAllWorlds(final String llllllllllllllIllIIIlIIllIIlIIll, final String llllllllllllllIllIIIlIIllIIIIlIl, final long llllllllllllllIllIIIlIIllIIlIIIl, final WorldType llllllllllllllIllIIIlIIllIIIIIll, final String llllllllllllllIllIIIlIIllIIIllll) {
        this.convertMapIfNeeded(llllllllllllllIllIIIlIIllIIlIIll);
        this.setUserMessage("menu.loadingLevel");
        this.worldServers = new WorldServer[3];
        this.timeOfLastDimensionTick = new long[this.worldServers.length][100];
        final ISaveHandler llllllllllllllIllIIIlIIllIIIlllI = this.anvilConverterForAnvilFile.getSaveLoader(llllllllllllllIllIIIlIIllIIlIIll, true);
        this.setResourcePackFromWorld(this.getFolderName(), llllllllllllllIllIIIlIIllIIIlllI);
        WorldInfo llllllllllllllIllIIIlIIllIIIllIl = llllllllllllllIllIIIlIIllIIIlllI.loadWorldInfo();
        WorldSettings llllllllllllllIllIIIlIIllIIIlIlI;
        if (llllllllllllllIllIIIlIIllIIIllIl == null) {
            WorldSettings llllllllllllllIllIIIlIIllIIIlIll = null;
            if (this.isDemo()) {
                final WorldSettings llllllllllllllIllIIIlIIllIIIllII = DemoWorldServer.demoWorldSettings;
            }
            else {
                llllllllllllllIllIIIlIIllIIIlIll = new WorldSettings(llllllllllllllIllIIIlIIllIIlIIIl, this.getGameType(), this.canStructuresSpawn(), this.isHardcore(), llllllllllllllIllIIIlIIllIIIIIll);
                llllllllllllllIllIIIlIIllIIIlIll.setWorldName(llllllllllllllIllIIIlIIllIIIllll);
                if (this.enableBonusChest) {
                    llllllllllllllIllIIIlIIllIIIlIll.enableBonusChest();
                }
            }
            llllllllllllllIllIIIlIIllIIIllIl = new WorldInfo(llllllllllllllIllIIIlIIllIIIlIll, llllllllllllllIllIIIlIIllIIIIlIl);
        }
        else {
            llllllllllllllIllIIIlIIllIIIllIl.setWorldName(llllllllllllllIllIIIlIIllIIIIlIl);
            llllllllllllllIllIIIlIIllIIIlIlI = new WorldSettings(llllllllllllllIllIIIlIIllIIIllIl);
        }
        for (int llllllllllllllIllIIIlIIllIIIlIIl = 0; llllllllllllllIllIIIlIIllIIIlIIl < this.worldServers.length; ++llllllllllllllIllIIIlIIllIIIlIIl) {
            byte llllllllllllllIllIIIlIIllIIIlIII = 0;
            if (llllllllllllllIllIIIlIIllIIIlIIl == 1) {
                llllllllllllllIllIIIlIIllIIIlIII = -1;
            }
            if (llllllllllllllIllIIIlIIllIIIlIIl == 2) {
                llllllllllllllIllIIIlIIllIIIlIII = 1;
            }
            if (llllllllllllllIllIIIlIIllIIIlIIl == 0) {
                if (this.isDemo()) {
                    this.worldServers[llllllllllllllIllIIIlIIllIIIlIIl] = (WorldServer)new DemoWorldServer(this, llllllllllllllIllIIIlIIllIIIlllI, llllllllllllllIllIIIlIIllIIIllIl, llllllllllllllIllIIIlIIllIIIlIII, this.theProfiler).init();
                }
                else {
                    this.worldServers[llllllllllllllIllIIIlIIllIIIlIIl] = (WorldServer)new WorldServer(this, llllllllllllllIllIIIlIIllIIIlllI, llllllllllllllIllIIIlIIllIIIllIl, llllllllllllllIllIIIlIIllIIIlIII, this.theProfiler).init();
                }
                this.worldServers[llllllllllllllIllIIIlIIllIIIlIIl].initialize(llllllllllllllIllIIIlIIllIIIlIlI);
            }
            else {
                this.worldServers[llllllllllllllIllIIIlIIllIIIlIIl] = (WorldServer)new WorldServerMulti(this, llllllllllllllIllIIIlIIllIIIlllI, llllllllllllllIllIIIlIIllIIIlIII, this.worldServers[0], this.theProfiler).init();
            }
            this.worldServers[llllllllllllllIllIIIlIIllIIIlIIl].addWorldAccess(new WorldManager(this, this.worldServers[llllllllllllllIllIIIlIIllIIIlIIl]));
            if (!this.isSinglePlayer()) {
                this.worldServers[llllllllllllllIllIIIlIIllIIIlIIl].getWorldInfo().setGameType(this.getGameType());
            }
        }
        this.serverConfigManager.setPlayerManager(this.worldServers);
        this.setDifficultyForAllWorlds(this.getDifficulty());
        this.initialWorldChunkLoad();
    }
    
    @Override
    public boolean canCommandSenderUseCommand(final int llllllllllllllIllIIIlIIIIllIIllI, final String llllllllllllllIllIIIlIIIIllIIlIl) {
        return true;
    }
    
    public void setBuildLimit(final int llllllllllllllIllIIIIllllIlIllII) {
        this.buildLimit = llllllllllllllIllIIIIllllIlIllII;
    }
    
    public GameProfile[] getGameProfiles() {
        return this.serverConfigManager.getAllProfiles();
    }
    
    public abstract String shareToLAN(final WorldSettings.GameType p0, final boolean p1);
    
    public CrashReport addServerInfoToCrashReport(final CrashReport llllllllllllllIllIIIlIIIlIIlIlIl) {
        llllllllllllllIllIIIlIIIlIIlIlIl.getCategory().addCrashSectionCallable("Profiler Position", new Callable() {
            public String func_179879_a() {
                return MinecraftServer.this.theProfiler.profilingEnabled ? MinecraftServer.this.theProfiler.getNameOfLastSection() : "N/A (disabled)";
            }
            
            static {
                __OBFID = "CL_00001418";
            }
            
            @Override
            public Object call() {
                return this.func_179879_a();
            }
        });
        if (this.serverConfigManager != null) {
            llllllllllllllIllIIIlIIIlIIlIlIl.getCategory().addCrashSectionCallable("Player Count", new Callable() {
                @Override
                public String call() {
                    return String.valueOf(new StringBuilder(String.valueOf(MinecraftServer.this.serverConfigManager.getCurrentPlayerCount())).append(" / ").append(MinecraftServer.this.serverConfigManager.getMaxPlayers()).append("; ").append(MinecraftServer.this.serverConfigManager.playerEntityList));
                }
                
                static {
                    __OBFID = "CL_00001419";
                }
            });
        }
        return llllllllllllllIllIIIlIIIlIIlIlIl;
    }
    
    public PlayerUsageSnooper getPlayerUsageSnooper() {
        return this.usageSnooper;
    }
    
    public void logWarning(final String llllllllllllllIllIIIlIIIlIllIIII) {
        MinecraftServer.logger.warn(llllllllllllllIllIIIlIIIlIllIIII);
    }
    
    public MinecraftSessionService getMinecraftSessionService() {
        return this.sessionService;
    }
    
    public void setMOTD(final String llllllllllllllIllIIIIllllIllIlll) {
        this.motd = llllllllllllllIllIIIIllllIllIlll;
    }
    
    @Override
    public Vec3 getPositionVector() {
        return new Vec3(0.0, 0.0, 0.0);
    }
    
    public void setCanSpawnAnimals(final boolean llllllllllllllIllIIIIlllllIllIIl) {
        this.canSpawnAnimals = llllllllllllllIllIIIIlllllIllIIl;
    }
    
    public void initiateShutdown() {
        this.serverRunning = false;
    }
    
    public void setGameType(final WorldSettings.GameType llllllllllllllIllIIIIllllIIllllI) {
        for (int llllllllllllllIllIIIIllllIIlllIl = 0; llllllllllllllIllIIIIllllIIlllIl < this.worldServers.length; ++llllllllllllllIllIIIIllllIIlllIl) {
            getServer().worldServers[llllllllllllllIllIIIIllllIIlllIl].getWorldInfo().setGameType(llllllllllllllIllIIIIllllIIllllI);
        }
    }
    
    protected void func_175585_v() {
        MinecraftServer.mcServer = this;
    }
    
    public NetworkSystem getNetworkSystem() {
        return this.networkSystem;
    }
    
    public GameProfileRepository getGameProfileRepository() {
        return this.profileRepo;
    }
    
    public void setCanSpawnNPCs(final boolean llllllllllllllIllIIIIlllllIlIIII) {
        this.canSpawnNPCs = llllllllllllllIllIIIIlllllIlIIII;
    }
    
    @Override
    public ListenableFuture addScheduledTask(final Runnable llllllllllllllIllIIIIlllIIlIlllI) {
        Validate.notNull((Object)llllllllllllllIllIIIIlllIIlIlllI);
        return this.callFromMainThread(Executors.callable(llllllllllllllIllIIIIlllIIlIlllI));
    }
    
    public MinecraftServer(final Proxy llllllllllllllIllIIIlIIlllIIIIII, final File llllllllllllllIllIIIlIIllIllllII) {
        this.usageSnooper = new PlayerUsageSnooper("server", this, getCurrentTimeMillis());
        this.playersOnline = Lists.newArrayList();
        this.theProfiler = new Profiler();
        this.statusResponse = new ServerStatusResponse();
        this.random = new Random();
        this.serverPort = -1;
        this.serverRunning = true;
        this.maxPlayerIdleMinutes = 0;
        this.tickTimeArray = new long[100];
        this.resourcePackUrl = "";
        this.resourcePackHash = "";
        this.nanoTimeSinceStatusRefresh = 0L;
        this.futureTaskQueue = Queues.newArrayDeque();
        this.currentTime = getCurrentTimeMillis();
        this.serverProxy = llllllllllllllIllIIIlIIlllIIIIII;
        MinecraftServer.mcServer = this;
        this.anvilFile = null;
        this.networkSystem = null;
        this.profileCache = new PlayerProfileCache(this, llllllllllllllIllIIIlIIllIllllII);
        this.commandManager = null;
        this.anvilConverterForAnvilFile = null;
        this.authService = new YggdrasilAuthenticationService(llllllllllllllIllIIIlIIlllIIIIII, UUID.randomUUID().toString());
        this.sessionService = this.authService.createMinecraftSessionService();
        this.profileRepo = this.authService.createProfileRepository();
    }
    
    protected void outputPercentRemaining(final String llllllllllllllIllIIIlIIlIlIIIIlI, final int llllllllllllllIllIIIlIIlIlIIIIIl) {
        this.currentTask = llllllllllllllIllIIIlIIlIlIIIIlI;
        this.percentDone = llllllllllllllIllIIIlIIlIlIIIIIl;
        MinecraftServer.logger.info(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIllIIIlIIlIlIIIIlI)).append(": ").append(llllllllllllllIllIIIlIIlIlIIIIIl).append("%")));
    }
    
    private void addFaviconToStatusResponse(final ServerStatusResponse llllllllllllllIllIIIlIIIlllIllIl) {
        final File llllllllllllllIllIIIlIIIllllIIll = this.getFile("server-icon.png");
        if (llllllllllllllIllIIIlIIIllllIIll.isFile()) {
            final ByteBuf llllllllllllllIllIIIlIIIllllIIlI = Unpooled.buffer();
            try {
                final BufferedImage llllllllllllllIllIIIlIIIllllIIIl = ImageIO.read(llllllllllllllIllIIIlIIIllllIIll);
                Validate.validState(llllllllllllllIllIIIlIIIllllIIIl.getWidth() == 64, "Must be 64 pixels wide", new Object[0]);
                Validate.validState(llllllllllllllIllIIIlIIIllllIIIl.getHeight() == 64, "Must be 64 pixels high", new Object[0]);
                ImageIO.write(llllllllllllllIllIIIlIIIllllIIIl, "PNG", (OutputStream)new ByteBufOutputStream(llllllllllllllIllIIIlIIIllllIIlI));
                final ByteBuf llllllllllllllIllIIIlIIIllllIIII = Base64.encode(llllllllllllllIllIIIlIIIllllIIlI);
                llllllllllllllIllIIIlIIIlllIllIl.setFavicon(String.valueOf(new StringBuilder("data:image/png;base64,").append(llllllllllllllIllIIIlIIIllllIIII.toString(Charsets.UTF_8))));
            }
            catch (Exception llllllllllllllIllIIIlIIIlllIllll) {
                MinecraftServer.logger.error("Couldn't load server icon", (Throwable)llllllllllllllIllIIIlIIIlllIllll);
                return;
            }
            finally {
                llllllllllllllIllIIIlIIIllllIIlI.release();
            }
            llllllllllllllIllIIIlIIIllllIIlI.release();
        }
    }
    
    public String getFolderName() {
        return this.folderName;
    }
    
    public boolean isSinglePlayer() {
        return this.serverOwner != null;
    }
    
    protected void saveAllWorlds(final boolean llllllllllllllIllIIIlIIlIIllIlIl) {
        if (!this.worldIsBeingDeleted) {
            for (final WorldServer llllllllllllllIllIIIlIIlIIllIIIl : this.worldServers) {
                if (llllllllllllllIllIIIlIIlIIllIIIl != null) {
                    if (!llllllllllllllIllIIIlIIlIIllIlIl) {
                        MinecraftServer.logger.info(String.valueOf(new StringBuilder("Saving chunks for level '").append(llllllllllllllIllIIIlIIlIIllIIIl.getWorldInfo().getWorldName()).append("'/").append(llllllllllllllIllIIIlIIlIIllIIIl.provider.getDimensionName())));
                    }
                    try {
                        llllllllllllllIllIIIlIIlIIllIIIl.saveAllChunks(true, null);
                    }
                    catch (MinecraftException llllllllllllllIllIIIlIIlIIllIIII) {
                        MinecraftServer.logger.warn(llllllllllllllIllIIIlIIlIIllIIII.getMessage());
                    }
                }
            }
        }
    }
    
    public File getFile(final String llllllllllllllIllIIIlIIIlIllIIll) {
        return new File(this.getDataDirectory(), llllllllllllllIllIIIlIIIlIllIIll);
    }
    
    public abstract boolean isDedicatedServer();
    
    public boolean getGuiEnabled() {
        return false;
    }
    
    protected synchronized void setUserMessage(final String llllllllllllllIllIIIlIIllIlIIIll) {
        this.userMessage = llllllllllllllIllIIIlIIllIlIIIll;
    }
    
    public String[] getAllUsernames() {
        return this.serverConfigManager.getAllUsernames();
    }
    
    public boolean isAnnouncingPlayerAchievements() {
        return true;
    }
    
    public void setKeyPair(final KeyPair llllllllllllllIllIIIlIIIIIllllIl) {
        this.serverKeyPair = llllllllllllllIllIIIlIIIIIllllIl;
    }
    
    public List func_180506_a(final ICommandSender llllllllllllllIllIIIlIIIlIIIlIII, String llllllllllllllIllIIIlIIIlIIIIlll, final BlockPos llllllllllllllIllIIIlIIIlIIIIllI) {
        final ArrayList llllllllllllllIllIIIlIIIlIIIIlIl = Lists.newArrayList();
        if (llllllllllllllIllIIIlIIIlIIIIlll.startsWith("/")) {
            llllllllllllllIllIIIlIIIlIIIIlll = llllllllllllllIllIIIlIIIlIIIIlll.substring(1);
            final boolean llllllllllllllIllIIIlIIIlIIIIlII = !llllllllllllllIllIIIlIIIlIIIIlll.contains(" ");
            final List llllllllllllllIllIIIlIIIlIIIIIll = this.commandManager.getTabCompletionOptions(llllllllllllllIllIIIlIIIlIIIlIII, llllllllllllllIllIIIlIIIlIIIIlll, llllllllllllllIllIIIlIIIlIIIIllI);
            if (llllllllllllllIllIIIlIIIlIIIIIll != null) {
                for (final String llllllllllllllIllIIIlIIIlIIIIIIl : llllllllllllllIllIIIlIIIlIIIIIll) {
                    if (llllllllllllllIllIIIlIIIlIIIIlII) {
                        llllllllllllllIllIIIlIIIlIIIIlIl.add(String.valueOf(new StringBuilder("/").append(llllllllllllllIllIIIlIIIlIIIIIIl)));
                    }
                    else {
                        llllllllllllllIllIIIlIIIlIIIIlIl.add(llllllllllllllIllIIIlIIIlIIIIIIl);
                    }
                }
            }
            return llllllllllllllIllIIIlIIIlIIIIlIl;
        }
        final String[] llllllllllllllIllIIIlIIIlIIIIIII = llllllllllllllIllIIIlIIIlIIIIlll.split(" ", -1);
        final String llllllllllllllIllIIIlIIIIlllllll = llllllllllllllIllIIIlIIIlIIIIIII[llllllllllllllIllIIIlIIIlIIIIIII.length - 1];
        for (final String llllllllllllllIllIIIlIIIIllllIll : this.serverConfigManager.getAllUsernames()) {
            if (CommandBase.doesStringStartWith(llllllllllllllIllIIIlIIIIlllllll, llllllllllllllIllIIIlIIIIllllIll)) {
                llllllllllllllIllIIIlIIIlIIIIlIl.add(llllllllllllllIllIIIlIIIIllllIll);
            }
        }
        return llllllllllllllIllIIIlIIIlIIIIlIl;
    }
    
    protected void convertMapIfNeeded(final String llllllllllllllIllIIIlIIllIlIlIIl) {
        if (this.getActiveAnvilConverter().isOldMapFormat(llllllllllllllIllIIIlIIllIlIlIIl)) {
            MinecraftServer.logger.info("Converting map!");
            this.setUserMessage("menu.convertingLevel");
            this.getActiveAnvilConverter().convertMapFormat(llllllllllllllIllIIIlIIllIlIlIIl, new IProgressUpdate() {
                private /* synthetic */ long startTime = System.currentTimeMillis();
                
                @Override
                public void setLoadingProgress(final int llllllllllllllIlllIIlIIIlllIlIIl) {
                    if (System.currentTimeMillis() - this.startTime >= 1000L) {
                        this.startTime = System.currentTimeMillis();
                        MinecraftServer.logger.info(String.valueOf(new StringBuilder("Converting... ").append(llllllllllllllIlllIIlIIIlllIlIIl).append("%")));
                    }
                }
                
                @Override
                public void resetProgressAndMessage(final String llllllllllllllIlllIIlIIIlllIllIl) {
                }
                
                @Override
                public void displaySavingString(final String llllllllllllllIlllIIlIIIlllIllll) {
                }
                
                static {
                    __OBFID = "CL_00001417";
                }
                
                @Override
                public void displayLoadingString(final String llllllllllllllIlllIIlIIIlllIIlII) {
                }
                
                @Override
                public void setDoneWorking() {
                }
            });
        }
    }
    
    public void setOnlineMode(final boolean llllllllllllllIllIIIIllllllIIIlI) {
        this.onlineMode = llllllllllllllIllIIIIllllllIIIlI;
    }
    
    public void canCreateBonusChest(final boolean llllllllllllllIllIIIlIIIIIIlllll) {
        this.enableBonusChest = llllllllllllllIllIIIlIIIIIIlllll;
    }
    
    public ServerStatusResponse getServerStatusResponse() {
        return this.statusResponse;
    }
    
    @Override
    public void addChatMessage(final IChatComponent llllllllllllllIllIIIlIIIIllIlIII) {
        MinecraftServer.logger.info(llllllllllllllIllIIIlIIIIllIlIII.getUnformattedText());
    }
    
    @Override
    public void addServerTypeToSnooper(final PlayerUsageSnooper llllllllllllllIllIIIIllllllIlllI) {
        llllllllllllllIllIIIIllllllIlllI.addStatToSnooper("singleplayer", this.isSinglePlayer());
        llllllllllllllIllIIIIllllllIlllI.addStatToSnooper("server_brand", this.getServerModName());
        llllllllllllllIllIIIIllllllIlllI.addStatToSnooper("gui_supported", GraphicsEnvironment.isHeadless() ? "headless" : "supported");
        llllllllllllllIllIIIIllllllIlllI.addStatToSnooper("dedicated", this.isDedicatedServer());
    }
    
    public boolean isFlightAllowed() {
        return this.allowFlight;
    }
    
    public boolean getAllowNether() {
        return true;
    }
    
    public static long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }
    
    public void enableProfiling() {
        this.startProfiling = true;
    }
    
    protected void systemExitNow() {
    }
    
    public ListenableFuture callFromMainThread(final Callable llllllllllllllIllIIIIlllIIllllII) {
        Validate.notNull((Object)llllllllllllllIllIIIIlllIIllllII);
        if (!this.isCallingFromMinecraftThread()) {
            final ListenableFutureTask llllllllllllllIllIIIIlllIIlllIll = ListenableFutureTask.create(llllllllllllllIllIIIIlllIIllllII);
            final Queue llllllllllllllIllIIIIlllIIlllIlI = this.futureTaskQueue;
            synchronized (this.futureTaskQueue) {
                this.futureTaskQueue.add(llllllllllllllIllIIIIlllIIlllIll);
                final ListenableFutureTask listenableFutureTask = llllllllllllllIllIIIIlllIIlllIll;
                // monitorexit(this.futureTaskQueue)
                return (ListenableFuture)listenableFutureTask;
            }
        }
        try {
            return Futures.immediateFuture(llllllllllllllIllIIIIlllIIllllII.call());
        }
        catch (Exception llllllllllllllIllIIIIlllIIlllIIl) {
            return (ListenableFuture)Futures.immediateFailedCheckedFuture(llllllllllllllIllIIIIlllIIlllIIl);
        }
    }
    
    protected void finalTick(final CrashReport llllllllllllllIllIIIlIIIlllIIlIl) {
    }
    
    @Override
    public IChatComponent getDisplayName() {
        return new ChatComponentText(this.getName());
    }
    
    public void setAllowPvp(final boolean llllllllllllllIllIIIIlllllIIlIIl) {
        this.pvpEnabled = llllllllllllllIllIIIIlllllIIlIIl;
    }
    
    @Override
    public BlockPos getPosition() {
        return BlockPos.ORIGIN;
    }
    
    @Override
    public void func_174794_a(final CommandResultStats.Type llllllllllllllIllIIIIlllIlIIIlIl, final int llllllllllllllIllIIIIlllIlIIIlII) {
    }
    
    public abstract boolean canStructuresSpawn();
    
    protected void clearCurrentTask() {
        this.currentTask = null;
        this.percentDone = 0;
    }
    
    public static MinecraftServer getServer() {
        return MinecraftServer.mcServer;
    }
    
    public void setPlayerIdleTimeout(final int llllllllllllllIllIIIIlllIlllIIII) {
        this.maxPlayerIdleMinutes = llllllllllllllIllIIIIlllIlllIIII;
    }
    
    protected abstract boolean startServer() throws IOException;
    
    @Override
    public Entity getCommandSenderEntity() {
        return null;
    }
    
    public String getMinecraftVersion() {
        return "1.8";
    }
    
    public void setFolderName(final String llllllllllllllIllIIIlIIIIlIIlIlI) {
        this.folderName = llllllllllllllIllIIIlIIIIlIIlIlI;
    }
    
    public boolean func_175578_N() {
        return this.anvilFile != null;
    }
    
    public boolean isServerRunning() {
        return this.serverRunning;
    }
    
    @Override
    public void run() {
        try {
            if (this.startServer()) {
                this.currentTime = getCurrentTimeMillis();
                long llllllllllllllIllIIIlIIlIIIIllIl = 0L;
                this.statusResponse.setServerDescription(new ChatComponentText(this.motd));
                this.statusResponse.setProtocolVersionInfo(new ServerStatusResponse.MinecraftProtocolVersionIdentifier("1.8", 47));
                this.addFaviconToStatusResponse(this.statusResponse);
                while (this.serverRunning) {
                    final long llllllllllllllIllIIIlIIlIIIIllII = getCurrentTimeMillis();
                    long llllllllllllllIllIIIlIIlIIIIlIll = llllllllllllllIllIIIlIIlIIIIllII - this.currentTime;
                    if (llllllllllllllIllIIIlIIlIIIIlIll > 2000L && this.currentTime - this.timeOfLastWarning >= 15000L) {
                        MinecraftServer.logger.warn("Can't keep up! Did the system time change, or is the server overloaded? Running {}ms behind, skipping {} tick(s)", new Object[] { llllllllllllllIllIIIlIIlIIIIlIll, llllllllllllllIllIIIlIIlIIIIlIll / 50L });
                        llllllllllllllIllIIIlIIlIIIIlIll = 2000L;
                        this.timeOfLastWarning = this.currentTime;
                    }
                    if (llllllllllllllIllIIIlIIlIIIIlIll < 0L) {
                        MinecraftServer.logger.warn("Time ran backwards! Did the system time change?");
                        llllllllllllllIllIIIlIIlIIIIlIll = 0L;
                    }
                    llllllllllllllIllIIIlIIlIIIIllIl += llllllllllllllIllIIIlIIlIIIIlIll;
                    this.currentTime = llllllllllllllIllIIIlIIlIIIIllII;
                    if (this.worldServers[0].areAllPlayersAsleep()) {
                        this.tick();
                        llllllllllllllIllIIIlIIlIIIIllIl = 0L;
                    }
                    else {
                        while (llllllllllllllIllIIIlIIlIIIIllIl > 50L) {
                            llllllllllllllIllIIIlIIlIIIIllIl -= 50L;
                            this.tick();
                        }
                    }
                    Thread.sleep(Math.max(1L, 50L - llllllllllllllIllIIIlIIlIIIIllIl));
                    this.serverIsRunning = true;
                }
            }
            else {
                this.finalTick(null);
            }
        }
        catch (Throwable llllllllllllllIllIIIlIIlIIIIlIlI) {
            MinecraftServer.logger.error("Encountered an unexpected exception", llllllllllllllIllIIIlIIlIIIIlIlI);
            CrashReport llllllllllllllIllIIIlIIlIIIIlIIl = null;
            if (llllllllllllllIllIIIlIIlIIIIlIlI instanceof ReportedException) {
                llllllllllllllIllIIIlIIlIIIIlIIl = this.addServerInfoToCrashReport(((ReportedException)llllllllllllllIllIIIlIIlIIIIlIlI).getCrashReport());
            }
            else {
                llllllllllllllIllIIIlIIlIIIIlIIl = this.addServerInfoToCrashReport(new CrashReport("Exception in server tick loop", llllllllllllllIllIIIlIIlIIIIlIlI));
            }
            final File llllllllllllllIllIIIlIIlIIIIlIII = new File(new File(this.getDataDirectory(), "crash-reports"), String.valueOf(new StringBuilder("crash-").append(new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss").format(new Date())).append("-server.txt")));
            if (llllllllllllllIllIIIlIIlIIIIlIIl.saveToFile(llllllllllllllIllIIIlIIlIIIIlIII)) {
                MinecraftServer.logger.error(String.valueOf(new StringBuilder("This crash report has been saved to: ").append(llllllllllllllIllIIIlIIlIIIIlIII.getAbsolutePath())));
            }
            else {
                MinecraftServer.logger.error("We were unable to save this crash report to disk.");
            }
            this.finalTick(llllllllllllllIllIIIlIIlIIIIlIIl);
            return;
        }
        finally {
            Label_0525: {
                try {
                    this.stopServer();
                    this.serverStopped = true;
                }
                catch (Throwable llllllllllllllIllIIIlIIlIIIIIllI) {
                    MinecraftServer.logger.error("Exception stopping the server", llllllllllllllIllIIIlIIlIIIIIllI);
                    this.systemExitNow();
                    break Label_0525;
                }
                finally {
                    this.systemExitNow();
                }
                this.systemExitNow();
            }
        }
        try {
            this.stopServer();
            this.serverStopped = true;
        }
        catch (Throwable llllllllllllllIllIIIlIIlIIIIIlIl) {
            MinecraftServer.logger.error("Exception stopping the server", llllllllllllllIllIIIlIIlIIIIIlIl);
            return;
        }
        finally {
            this.systemExitNow();
        }
        this.systemExitNow();
    }
    
    public void deleteWorldAndStopServer() {
        this.worldIsBeingDeleted = true;
        this.getActiveAnvilConverter().flushCache();
        for (int llllllllllllllIllIIIlIIIIIIlIlll = 0; llllllllllllllIllIIIlIIIIIIlIlll < this.worldServers.length; ++llllllllllllllIllIIIlIIIIIIlIlll) {
            final WorldServer llllllllllllllIllIIIlIIIIIIlIllI = this.worldServers[llllllllllllllIllIIIlIIIIIIlIlll];
            if (llllllllllllllIllIIIlIIIIIIlIllI != null) {
                llllllllllllllIllIIIlIIIIIIlIllI.flush();
            }
        }
        this.getActiveAnvilConverter().deleteWorldDirectory(this.worldServers[0].getSaveHandler().getWorldDirectoryName());
        this.initiateShutdown();
    }
    
    public void setResourcePack(final String llllllllllllllIllIIIlIIIIIIIIlIl, final String llllllllllllllIllIIIlIIIIIIIIlll) {
        this.resourcePackUrl = llllllllllllllIllIIIlIIIIIIIIlIl;
        this.resourcePackHash = llllllllllllllIllIIIlIIIIIIIIlll;
    }
    
    public KeyPair getKeyPair() {
        return this.serverKeyPair;
    }
    
    @Override
    public boolean isCallingFromMinecraftThread() {
        return Thread.currentThread() == this.serverThread;
    }
    
    public void setServerOwner(final String llllllllllllllIllIIIlIIIIlIllIII) {
        this.serverOwner = llllllllllllllIllIIIlIIIIlIllIII;
    }
    
    public synchronized String getUserMessage() {
        return this.userMessage;
    }
    
    protected void setResourcePackFromWorld(final String llllllllllllllIllIIIlIIlIlIlIIII, final ISaveHandler llllllllllllllIllIIIlIIlIlIIlIll) {
        final File llllllllllllllIllIIIlIIlIlIIlllI = new File(llllllllllllllIllIIIlIIlIlIIlIll.getWorldDirectory(), "resources.zip");
        if (llllllllllllllIllIIIlIIlIlIIlllI.isFile()) {
            this.setResourcePack(String.valueOf(new StringBuilder("level://").append(llllllllllllllIllIIIlIIlIlIlIIII).append("/").append(llllllllllllllIllIIIlIIlIlIIlllI.getName())), "");
        }
    }
    
    public ICommandManager getCommandManager() {
        return this.commandManager;
    }
    
    public int getMaxWorldSize() {
        return 29999984;
    }
    
    public PlayerProfileCache getPlayerProfileCache() {
        return this.profileCache;
    }
    
    public int getNetworkCompressionTreshold() {
        return 256;
    }
    
    public String getResourcePackHash() {
        return this.resourcePackHash;
    }
    
    public Proxy getServerProxy() {
        return this.serverProxy;
    }
    
    protected boolean allowSpawnMonsters() {
        return true;
    }
    
    public void refreshStatusNextTick() {
        this.nanoTimeSinceStatusRefresh = 0L;
    }
    
    public int getSpawnProtectionSize() {
        return 16;
    }
    
    public boolean getCanSpawnAnimals() {
        return this.canSpawnAnimals;
    }
    
    @Override
    public void addServerStatsToSnooper(final PlayerUsageSnooper llllllllllllllIllIIIIlllllllIllI) {
        llllllllllllllIllIIIIlllllllIllI.addClientStat("whitelist_enabled", false);
        llllllllllllllIllIIIIlllllllIllI.addClientStat("whitelist_count", 0);
        if (this.serverConfigManager != null) {
            llllllllllllllIllIIIIlllllllIllI.addClientStat("players_current", this.getCurrentPlayerCount());
            llllllllllllllIllIIIIlllllllIllI.addClientStat("players_max", this.getMaxPlayers());
            llllllllllllllIllIIIIlllllllIllI.addClientStat("players_seen", this.serverConfigManager.getAvailablePlayerDat().length);
        }
        llllllllllllllIllIIIIlllllllIllI.addClientStat("uses_auth", this.onlineMode);
        llllllllllllllIllIIIIlllllllIllI.addClientStat("gui_state", this.getGuiEnabled() ? "enabled" : "disabled");
        llllllllllllllIllIIIIlllllllIllI.addClientStat("run_time", (getCurrentTimeMillis() - llllllllllllllIllIIIIlllllllIllI.getMinecraftStartTimeMillis()) / 60L * 1000L);
        llllllllllllllIllIIIIlllllllIllI.addClientStat("avg_tick_ms", (int)(MathHelper.average(this.tickTimeArray) * 1.0E-6));
        int llllllllllllllIllIIIIllllllllIll = 0;
        if (this.worldServers != null) {
            for (int llllllllllllllIllIIIIllllllllIlI = 0; llllllllllllllIllIIIIllllllllIlI < this.worldServers.length; ++llllllllllllllIllIIIIllllllllIlI) {
                if (this.worldServers[llllllllllllllIllIIIIllllllllIlI] != null) {
                    final WorldServer llllllllllllllIllIIIIllllllllIIl = this.worldServers[llllllllllllllIllIIIIllllllllIlI];
                    final WorldInfo llllllllllllllIllIIIIllllllllIII = llllllllllllllIllIIIIllllllllIIl.getWorldInfo();
                    llllllllllllllIllIIIIlllllllIllI.addClientStat(String.valueOf(new StringBuilder("world[").append(llllllllllllllIllIIIIllllllllIll).append("][dimension]")), llllllllllllllIllIIIIllllllllIIl.provider.getDimensionId());
                    llllllllllllllIllIIIIlllllllIllI.addClientStat(String.valueOf(new StringBuilder("world[").append(llllllllllllllIllIIIIllllllllIll).append("][mode]")), llllllllllllllIllIIIIllllllllIII.getGameType());
                    llllllllllllllIllIIIIlllllllIllI.addClientStat(String.valueOf(new StringBuilder("world[").append(llllllllllllllIllIIIIllllllllIll).append("][difficulty]")), llllllllllllllIllIIIIllllllllIIl.getDifficulty());
                    llllllllllllllIllIIIIlllllllIllI.addClientStat(String.valueOf(new StringBuilder("world[").append(llllllllllllllIllIIIIllllllllIll).append("][hardcore]")), llllllllllllllIllIIIIllllllllIII.isHardcoreModeEnabled());
                    llllllllllllllIllIIIIlllllllIllI.addClientStat(String.valueOf(new StringBuilder("world[").append(llllllllllllllIllIIIIllllllllIll).append("][generator_name]")), llllllllllllllIllIIIIllllllllIII.getTerrainType().getWorldTypeName());
                    llllllllllllllIllIIIIlllllllIllI.addClientStat(String.valueOf(new StringBuilder("world[").append(llllllllllllllIllIIIIllllllllIll).append("][generator_version]")), llllllllllllllIllIIIIllllllllIII.getTerrainType().getGeneratorVersion());
                    llllllllllllllIllIIIIlllllllIllI.addClientStat(String.valueOf(new StringBuilder("world[").append(llllllllllllllIllIIIIllllllllIll).append("][height]")), this.buildLimit);
                    llllllllllllllIllIIIIlllllllIllI.addClientStat(String.valueOf(new StringBuilder("world[").append(llllllllllllllIllIIIIllllllllIll).append("][chunks_loaded]")), llllllllllllllIllIIIIllllllllIIl.getChunkProvider().getLoadedChunkCount());
                    ++llllllllllllllIllIIIIllllllllIll;
                }
            }
        }
        llllllllllllllIllIIIIlllllllIllI.addClientStat("worlds", llllllllllllllIllIIIIllllllllIll);
    }
    
    public abstract boolean isCommandBlockEnabled();
    
    @Override
    public World getEntityWorld() {
        return this.worldServers[0];
    }
    
    public String getWorldName() {
        return this.worldName;
    }
    
    @Override
    public boolean isSnooperEnabled() {
        return true;
    }
    
    public String getResourcePackUrl() {
        return this.resourcePackUrl;
    }
    
    public int getMaxPlayers() {
        return this.serverConfigManager.getMaxPlayers();
    }
    
    public String getServerModName() {
        return "vanilla";
    }
    
    public abstract boolean isHardcore();
    
    protected void initialWorldChunkLoad() {
        final boolean llllllllllllllIllIIIlIIlIllIlllI = true;
        final boolean llllllllllllllIllIIIlIIlIllIllIl = true;
        final boolean llllllllllllllIllIIIlIIlIllIllII = true;
        final boolean llllllllllllllIllIIIlIIlIllIlIll = true;
        int llllllllllllllIllIIIlIIlIllIlIlI = 0;
        this.setUserMessage("menu.generatingTerrain");
        final byte llllllllllllllIllIIIlIIlIllIlIIl = 0;
        MinecraftServer.logger.info(String.valueOf(new StringBuilder("Preparing start region for level ").append(llllllllllllllIllIIIlIIlIllIlIIl)));
        final WorldServer llllllllllllllIllIIIlIIlIllIlIII = this.worldServers[llllllllllllllIllIIIlIIlIllIlIIl];
        final BlockPos llllllllllllllIllIIIlIIlIllIIlll = llllllllllllllIllIIIlIIlIllIlIII.getSpawnPoint();
        long llllllllllllllIllIIIlIIlIllIIllI = getCurrentTimeMillis();
        for (int llllllllllllllIllIIIlIIlIllIIlIl = -192; llllllllllllllIllIIIlIIlIllIIlIl <= 192 && this.isServerRunning(); llllllllllllllIllIIIlIIlIllIIlIl += 16) {
            for (int llllllllllllllIllIIIlIIlIllIIlII = -192; llllllllllllllIllIIIlIIlIllIIlII <= 192 && this.isServerRunning(); llllllllllllllIllIIIlIIlIllIIlII += 16) {
                final long llllllllllllllIllIIIlIIlIllIIIll = getCurrentTimeMillis();
                if (llllllllllllllIllIIIlIIlIllIIIll - llllllllllllllIllIIIlIIlIllIIllI > 1000L) {
                    this.outputPercentRemaining("Preparing spawn area", llllllllllllllIllIIIlIIlIllIlIlI * 100 / 625);
                    llllllllllllllIllIIIlIIlIllIIllI = llllllllllllllIllIIIlIIlIllIIIll;
                }
                ++llllllllllllllIllIIIlIIlIllIlIlI;
                llllllllllllllIllIIIlIIlIllIlIII.theChunkProviderServer.loadChunk(llllllllllllllIllIIIlIIlIllIIlll.getX() + llllllllllllllIllIIIlIIlIllIIlIl >> 4, llllllllllllllIllIIIlIIlIllIIlll.getZ() + llllllllllllllIllIIIlIIlIllIIlII >> 4);
            }
        }
        this.clearCurrentTask();
    }
}
