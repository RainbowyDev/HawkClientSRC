package net.minecraft.server.integrated;

import net.minecraft.server.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.command.*;
import com.google.common.collect.*;
import net.minecraft.entity.player.*;
import com.google.common.util.concurrent.*;
import java.util.*;
import net.minecraft.world.demo.*;
import optifine.*;
import net.minecraft.world.*;
import net.minecraft.world.storage.*;
import java.io.*;
import net.minecraft.profiler.*;
import net.minecraft.crash.*;
import java.util.concurrent.*;
import net.minecraft.client.*;
import org.apache.logging.log4j.*;
import net.minecraft.util.*;
import java.net.*;
import net.minecraft.server.management.*;

public class IntegratedServer extends MinecraftServer
{
    private final /* synthetic */ WorldSettings theWorldSettings;
    private final /* synthetic */ Minecraft mc;
    private /* synthetic */ boolean isGamePaused;
    private /* synthetic */ boolean isPublic;
    private /* synthetic */ ThreadLanServerPing lanServerPing;
    private static final /* synthetic */ Logger logger;
    
    @Override
    protected ServerCommandManager createNewCommandManager() {
        return new IntegratedServerCommandManager();
    }
    
    @Override
    public void setDifficultyForAllWorlds(final EnumDifficulty llllllllllllllllIIIIllIlIlIlIIlI) {
        super.setDifficultyForAllWorlds(llllllllllllllllIIIIllIlIlIlIIlI);
        if (this.mc.theWorld != null) {
            this.mc.theWorld.getWorldInfo().setDifficulty(llllllllllllllllIIIIllIlIlIlIIlI);
        }
    }
    
    @Override
    public void setGameType(final WorldSettings.GameType llllllllllllllllIIIIllIlIIlIlIlI) {
        this.getConfigurationManager().func_152604_a(llllllllllllllllIIIIllIlIIlIlIlI);
    }
    
    @Override
    public boolean isDedicatedServer() {
        return false;
    }
    
    @Override
    public void initiateShutdown() {
        Futures.getUnchecked((Future)this.addScheduledTask(new Runnable() {
            @Override
            public void run() {
                final ArrayList llllllllllllllIIIIIIIIlIlIllllll = Lists.newArrayList((Iterable)IntegratedServer.this.getConfigurationManager().playerEntityList);
                for (final EntityPlayerMP llllllllllllllIIIIIIIIlIlIllllIl : llllllllllllllIIIIIIIIlIlIllllll) {
                    IntegratedServer.this.getConfigurationManager().playerLoggedOut(llllllllllllllIIIIIIIIlIlIllllIl);
                }
            }
        }));
        super.initiateShutdown();
        if (this.lanServerPing != null) {
            this.lanServerPing.interrupt();
            this.lanServerPing = null;
        }
    }
    
    @Override
    public boolean canStructuresSpawn() {
        return false;
    }
    
    @Override
    public boolean isSnooperEnabled() {
        return Minecraft.getMinecraft().isSnooperEnabled();
    }
    
    @Override
    public boolean isHardcore() {
        return this.theWorldSettings.getHardcoreEnabled();
    }
    
    @Override
    public File getDataDirectory() {
        return this.mc.mcDataDir;
    }
    
    public boolean getPublic() {
        return this.isPublic;
    }
    
    @Override
    public WorldSettings.GameType getGameType() {
        return this.theWorldSettings.getGameType();
    }
    
    @Override
    public void stopServer() {
        super.stopServer();
        if (this.lanServerPing != null) {
            this.lanServerPing.interrupt();
            this.lanServerPing = null;
        }
    }
    
    @Override
    public void tick() {
        final boolean llllllllllllllllIIIIllIllIIIIIll = this.isGamePaused;
        this.isGamePaused = (Minecraft.getMinecraft().getNetHandler() != null && Minecraft.getMinecraft().isGamePaused());
        if (!llllllllllllllllIIIIllIllIIIIIll && this.isGamePaused) {
            IntegratedServer.logger.info("Saving and pausing game...");
            this.getConfigurationManager().saveAllPlayerData();
            this.saveAllWorlds(false);
        }
        if (this.isGamePaused) {
            final Queue llllllllllllllllIIIIllIllIIIIIlI = this.futureTaskQueue;
            final Queue llllllllllllllllIIIIllIllIIIIIIl = this.futureTaskQueue;
            synchronized (this.futureTaskQueue) {
                while (!this.futureTaskQueue.isEmpty()) {
                    try {
                        if (Reflector.FMLCommonHandler_callFuture.exists()) {
                            Reflector.callVoid(Reflector.FMLCommonHandler_callFuture, this.futureTaskQueue.poll());
                        }
                        else {
                            this.futureTaskQueue.poll().run();
                        }
                    }
                    catch (Throwable llllllllllllllllIIIIllIllIIIIIII) {
                        IntegratedServer.logger.fatal((Object)llllllllllllllllIIIIllIllIIIIIII);
                    }
                }
                // monitorexit(this.futureTaskQueue)
                return;
            }
        }
        super.tick();
        if (this.mc.gameSettings.renderDistanceChunks != this.getConfigurationManager().getViewDistance()) {
            IntegratedServer.logger.info("Changing view distance to {}, from {}", new Object[] { this.mc.gameSettings.renderDistanceChunks, this.getConfigurationManager().getViewDistance() });
            this.getConfigurationManager().setViewDistance(this.mc.gameSettings.renderDistanceChunks);
        }
        if (this.mc.theWorld != null) {
            final WorldInfo llllllllllllllllIIIIllIlIlllllll = this.worldServers[0].getWorldInfo();
            final WorldInfo llllllllllllllllIIIIllIlIllllllI = this.mc.theWorld.getWorldInfo();
            if (!llllllllllllllllIIIIllIlIlllllll.isDifficultyLocked() && llllllllllllllllIIIIllIlIllllllI.getDifficulty() != llllllllllllllllIIIIllIlIlllllll.getDifficulty()) {
                IntegratedServer.logger.info("Changing difficulty to {}, from {}", new Object[] { llllllllllllllllIIIIllIlIllllllI.getDifficulty(), llllllllllllllllIIIIllIlIlllllll.getDifficulty() });
                this.setDifficultyForAllWorlds(llllllllllllllllIIIIllIlIllllllI.getDifficulty());
            }
            else if (llllllllllllllllIIIIllIlIllllllI.isDifficultyLocked() && !llllllllllllllllIIIIllIlIlllllll.isDifficultyLocked()) {
                IntegratedServer.logger.info("Locking difficulty to {}", new Object[] { llllllllllllllllIIIIllIlIllllllI.getDifficulty() });
                for (final WorldServer llllllllllllllllIIIIllIlIllllIlI : this.worldServers) {
                    if (llllllllllllllllIIIIllIlIllllIlI != null) {
                        llllllllllllllllIIIIllIlIllllIlI.getWorldInfo().setDifficultyLocked(true);
                    }
                }
            }
        }
    }
    
    @Override
    public boolean isCommandBlockEnabled() {
        return true;
    }
    
    @Override
    protected void loadAllWorlds(final String llllllllllllllllIIIIllIllIIllllI, final String llllllllllllllllIIIIllIllIIlllIl, final long llllllllllllllllIIIIllIllIllIIII, final WorldType llllllllllllllllIIIIllIllIlIlllI, final String llllllllllllllllIIIIllIllIlIllIl) {
        this.convertMapIfNeeded(llllllllllllllllIIIIllIllIIllllI);
        final ISaveHandler llllllllllllllllIIIIllIllIlIllII = this.getActiveAnvilConverter().getSaveLoader(llllllllllllllllIIIIllIllIIllllI, true);
        this.setResourcePackFromWorld(this.getFolderName(), llllllllllllllllIIIIllIllIlIllII);
        WorldInfo llllllllllllllllIIIIllIllIlIlIll = llllllllllllllllIIIIllIllIlIllII.loadWorldInfo();
        if (Reflector.DimensionManager.exists()) {
            final WorldServer llllllllllllllllIIIIllIllIlIlIlI = (WorldServer)(this.isDemo() ? new DemoWorldServer(this, llllllllllllllllIIIIllIllIlIllII, llllllllllllllllIIIIllIllIlIlIll, 0, this.theProfiler).init() : ((WorldServer)new WorldServerOF(this, llllllllllllllllIIIIllIllIlIllII, llllllllllllllllIIIIllIllIlIlIll, 0, this.theProfiler).init()));
            llllllllllllllllIIIIllIllIlIlIlI.initialize(this.theWorldSettings);
            final Integer[] llllllllllllllllIIIIllIllIlIlIII;
            final Integer[] llllllllllllllllIIIIllIllIlIlIIl = llllllllllllllllIIIIllIllIlIlIII = (Integer[])Reflector.call(Reflector.DimensionManager_getStaticDimensionIDs, new Object[0]);
            for (int llllllllllllllllIIIIllIllIlIIllI = llllllllllllllllIIIIllIllIlIlIIl.length, llllllllllllllllIIIIllIllIlIIlIl = 0; llllllllllllllllIIIIllIllIlIIlIl < llllllllllllllllIIIIllIllIlIIllI; ++llllllllllllllllIIIIllIllIlIIlIl) {
                final int llllllllllllllllIIIIllIllIlIIlII = llllllllllllllllIIIIllIllIlIlIII[llllllllllllllllIIIIllIllIlIIlIl];
                final WorldServer llllllllllllllllIIIIllIllIlIIIlI = (WorldServer)((llllllllllllllllIIIIllIllIlIIlII == 0) ? llllllllllllllllIIIIllIllIlIlIlI : new WorldServerMulti(this, llllllllllllllllIIIIllIllIlIllII, llllllllllllllllIIIIllIllIlIIlII, llllllllllllllllIIIIllIllIlIlIlI, this.theProfiler).init());
                llllllllllllllllIIIIllIllIlIIIlI.addWorldAccess(new WorldManager(this, llllllllllllllllIIIIllIllIlIIIlI));
                if (!this.isSinglePlayer()) {
                    llllllllllllllllIIIIllIllIlIIIlI.getWorldInfo().setGameType(this.getGameType());
                }
                if (Reflector.EventBus.exists()) {
                    Reflector.postForgeBusEvent(Reflector.WorldEvent_Load_Constructor, llllllllllllllllIIIIllIllIlIIIlI);
                }
            }
            this.getConfigurationManager().setPlayerManager(new WorldServer[] { llllllllllllllllIIIIllIllIlIlIlI });
            if (llllllllllllllllIIIIllIllIlIlIlI.getWorldInfo().getDifficulty() == null) {
                this.setDifficultyForAllWorlds(this.mc.gameSettings.difficulty);
            }
        }
        else {
            this.worldServers = new WorldServer[3];
            this.timeOfLastDimensionTick = new long[this.worldServers.length][100];
            this.setResourcePackFromWorld(this.getFolderName(), llllllllllllllllIIIIllIllIlIllII);
            if (llllllllllllllllIIIIllIllIlIlIll == null) {
                llllllllllllllllIIIIllIllIlIlIll = new WorldInfo(this.theWorldSettings, llllllllllllllllIIIIllIllIIlllIl);
            }
            else {
                llllllllllllllllIIIIllIllIlIlIll.setWorldName(llllllllllllllllIIIIllIllIIlllIl);
            }
            for (int llllllllllllllllIIIIllIllIlIIIIl = 0; llllllllllllllllIIIIllIllIlIIIIl < this.worldServers.length; ++llllllllllllllllIIIIllIllIlIIIIl) {
                byte llllllllllllllllIIIIllIllIlIIIII = 0;
                if (llllllllllllllllIIIIllIllIlIIIIl == 1) {
                    llllllllllllllllIIIIllIllIlIIIII = -1;
                }
                if (llllllllllllllllIIIIllIllIlIIIIl == 2) {
                    llllllllllllllllIIIIllIllIlIIIII = 1;
                }
                if (llllllllllllllllIIIIllIllIlIIIIl == 0) {
                    if (this.isDemo()) {
                        this.worldServers[llllllllllllllllIIIIllIllIlIIIIl] = (WorldServer)new DemoWorldServer(this, llllllllllllllllIIIIllIllIlIllII, llllllllllllllllIIIIllIllIlIlIll, llllllllllllllllIIIIllIllIlIIIII, this.theProfiler).init();
                    }
                    else {
                        this.worldServers[llllllllllllllllIIIIllIllIlIIIIl] = (WorldServer)new WorldServerOF(this, llllllllllllllllIIIIllIllIlIllII, llllllllllllllllIIIIllIllIlIlIll, llllllllllllllllIIIIllIllIlIIIII, this.theProfiler).init();
                    }
                    this.worldServers[llllllllllllllllIIIIllIllIlIIIIl].initialize(this.theWorldSettings);
                }
                else {
                    this.worldServers[llllllllllllllllIIIIllIllIlIIIIl] = (WorldServer)new WorldServerMulti(this, llllllllllllllllIIIIllIllIlIllII, llllllllllllllllIIIIllIllIlIIIII, this.worldServers[0], this.theProfiler).init();
                }
                this.worldServers[llllllllllllllllIIIIllIllIlIIIIl].addWorldAccess(new WorldManager(this, this.worldServers[llllllllllllllllIIIIllIllIlIIIIl]));
            }
            this.getConfigurationManager().setPlayerManager(this.worldServers);
            if (this.worldServers[0].getWorldInfo().getDifficulty() == null) {
                this.setDifficultyForAllWorlds(this.mc.gameSettings.difficulty);
            }
        }
        this.initialWorldChunkLoad();
    }
    
    @Override
    public EnumDifficulty getDifficulty() {
        return (this.mc.theWorld == null) ? this.mc.gameSettings.difficulty : this.mc.theWorld.getWorldInfo().getDifficulty();
    }
    
    public void func_175592_a() {
        this.func_175585_v();
    }
    
    public IntegratedServer(final Minecraft llllllllllllllllIIIIlllIIIIlIIlI) {
        super(llllllllllllllllIIIIlllIIIIlIIlI.getProxy(), new File(llllllllllllllllIIIIlllIIIIlIIlI.mcDataDir, IntegratedServer.USER_CACHE_FILE.getName()));
        this.mc = llllllllllllllllIIIIlllIIIIlIIlI;
        this.theWorldSettings = null;
    }
    
    @Override
    protected boolean startServer() throws IOException {
        IntegratedServer.logger.info("Starting integrated minecraft server version 1.8");
        this.setOnlineMode(true);
        this.setCanSpawnAnimals(true);
        this.setCanSpawnNPCs(true);
        this.setAllowPvp(true);
        this.setAllowFlight(true);
        IntegratedServer.logger.info("Generating keypair");
        this.setKeyPair(CryptManager.generateKeyPair());
        if (Reflector.FMLCommonHandler_handleServerAboutToStart.exists()) {
            final Object llllllllllllllllIIIIllIllIIlIIII = Reflector.call(Reflector.FMLCommonHandler_instance, new Object[0]);
            if (!Reflector.callBoolean(llllllllllllllllIIIIllIllIIlIIII, Reflector.FMLCommonHandler_handleServerAboutToStart, this)) {
                return false;
            }
        }
        this.loadAllWorlds(this.getFolderName(), this.getWorldName(), this.theWorldSettings.getSeed(), this.theWorldSettings.getTerrainType(), this.theWorldSettings.getWorldName());
        this.setMOTD(String.valueOf(new StringBuilder(String.valueOf(this.getServerOwner())).append(" - ").append(this.worldServers[0].getWorldInfo().getWorldName())));
        if (Reflector.FMLCommonHandler_handleServerStarting.exists()) {
            final Object llllllllllllllllIIIIllIllIIIllll = Reflector.call(Reflector.FMLCommonHandler_instance, new Object[0]);
            if (Reflector.FMLCommonHandler_handleServerStarting.getReturnType() == Boolean.TYPE) {
                return Reflector.callBoolean(llllllllllllllllIIIIllIllIIIllll, Reflector.FMLCommonHandler_handleServerStarting, this);
            }
            Reflector.callVoid(llllllllllllllllIIIIllIllIIIllll, Reflector.FMLCommonHandler_handleServerStarting, this);
        }
        return true;
    }
    
    @Override
    public void addServerStatsToSnooper(final PlayerUsageSnooper llllllllllllllllIIIIllIlIlIIlllI) {
        super.addServerStatsToSnooper(llllllllllllllllIIIIllIlIlIIlllI);
        llllllllllllllllIIIIllIlIlIIlllI.addClientStat("snooper_partner", this.mc.getPlayerUsageSnooper().getUniqueID());
    }
    
    @Override
    public CrashReport addServerInfoToCrashReport(CrashReport llllllllllllllllIIIIllIlIlIllIII) {
        llllllllllllllllIIIIllIlIlIllIII = super.addServerInfoToCrashReport(llllllllllllllllIIIIllIlIlIllIII);
        llllllllllllllllIIIIllIlIlIllIII.getCategory().addCrashSectionCallable("Type", new Callable() {
            @Override
            public String call() {
                return "Integrated Server (map_client.txt)";
            }
        });
        llllllllllllllllIIIIllIlIlIllIII.getCategory().addCrashSectionCallable("Is Modded", new Callable() {
            @Override
            public String call() {
                String lllllllllllllIllllllllIIIlIIIlII = ClientBrandRetriever.getClientModName();
                if (!lllllllllllllIllllllllIIIlIIIlII.equals("vanilla")) {
                    return String.valueOf(new StringBuilder("Definitely; Client brand changed to '").append(lllllllllllllIllllllllIIIlIIIlII).append("'"));
                }
                lllllllllllllIllllllllIIIlIIIlII = IntegratedServer.this.getServerModName();
                return lllllllllllllIllllllllIIIlIIIlII.equals("vanilla") ? ((Minecraft.class.getSigners() == null) ? "Very likely; Jar signature invalidated" : "Probably not. Jar signature remains and both client + server brands are untouched.") : String.valueOf(new StringBuilder("Definitely; Server brand changed to '").append(lllllllllllllIllllllllIIIlIIIlII).append("'"));
            }
        });
        return llllllllllllllllIIIIllIlIlIllIII;
    }
    
    @Override
    protected void finalTick(final CrashReport llllllllllllllllIIIIllIlIllIIIII) {
        this.mc.crashed(llllllllllllllllIIIIllIlIllIIIII);
    }
    
    static {
        logger = LogManager.getLogger();
    }
    
    @Override
    public int getOpPermissionLevel() {
        return 4;
    }
    
    @Override
    public String shareToLAN(final WorldSettings.GameType llllllllllllllllIIIIllIlIlIIIlII, final boolean llllllllllllllllIIIIllIlIIlllllI) {
        try {
            int llllllllllllllllIIIIllIlIlIIIIlI = -1;
            try {
                llllllllllllllllIIIIllIlIlIIIIlI = HttpUtil.getSuitableLanPort();
            }
            catch (IOException ex) {}
            if (llllllllllllllllIIIIllIlIlIIIIlI <= 0) {
                llllllllllllllllIIIIllIlIlIIIIlI = 25564;
            }
            this.getNetworkSystem().addLanEndpoint(null, llllllllllllllllIIIIllIlIlIIIIlI);
            IntegratedServer.logger.info(String.valueOf(new StringBuilder("Started on ").append(llllllllllllllllIIIIllIlIlIIIIlI)));
            this.isPublic = true;
            this.lanServerPing = new ThreadLanServerPing(this.getMOTD(), String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIIIIllIlIlIIIIlI))));
            this.lanServerPing.start();
            this.getConfigurationManager().func_152604_a(llllllllllllllllIIIIllIlIlIIIlII);
            this.getConfigurationManager().setCommandsAllowedForAll(llllllllllllllllIIIIllIlIIlllllI);
            return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIIIIllIlIlIIIIlI)));
        }
        catch (IOException llllllllllllllllIIIIllIlIlIIIIIl) {
            return null;
        }
    }
    
    public IntegratedServer(final Minecraft llllllllllllllllIIIIllIlllllIlII, final String llllllllllllllllIIIIllIlllllIIll, final String llllllllllllllllIIIIllIlllllIIlI, final WorldSettings llllllllllllllllIIIIllIlllllIllI) {
        super(new File(llllllllllllllllIIIIllIlllllIlII.mcDataDir, "saves"), llllllllllllllllIIIIllIlllllIlII.getProxy(), new File(llllllllllllllllIIIIllIlllllIlII.mcDataDir, IntegratedServer.USER_CACHE_FILE.getName()));
        this.setServerOwner(llllllllllllllllIIIIllIlllllIlII.getSession().getUsername());
        this.setFolderName(llllllllllllllllIIIIllIlllllIIll);
        this.setWorldName(llllllllllllllllIIIIllIlllllIIlI);
        this.setDemo(llllllllllllllllIIIIllIlllllIlII.isDemo());
        this.canCreateBonusChest(llllllllllllllllIIIIllIlllllIllI.isBonusChestEnabled());
        this.setBuildLimit(256);
        this.setConfigManager(new IntegratedPlayerList(this));
        this.mc = llllllllllllllllIIIIllIlllllIlII;
        this.theWorldSettings = (this.isDemo() ? DemoWorldServer.demoWorldSettings : llllllllllllllllIIIIllIlllllIllI);
    }
}
