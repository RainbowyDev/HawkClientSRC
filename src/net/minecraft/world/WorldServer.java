package net.minecraft.world;

import net.minecraft.server.*;
import net.minecraft.server.management.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.block.material.*;
import net.minecraft.crash.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.passive.*;
import net.minecraft.profiler.*;
import com.google.common.collect.*;
import com.google.common.base.*;
import net.minecraft.entity.player.*;
import net.minecraft.network.*;
import org.apache.logging.log4j.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import com.google.common.util.concurrent.*;
import net.minecraft.entity.*;
import net.minecraft.world.gen.structure.*;
import net.minecraft.world.storage.*;
import net.minecraft.village.*;
import net.minecraft.scoreboard.*;
import net.minecraft.block.*;
import net.minecraft.entity.effect.*;
import net.minecraft.world.chunk.*;
import net.minecraft.world.chunk.storage.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.world.biome.*;
import net.minecraft.tileentity.*;
import net.minecraft.network.play.server.*;

public class WorldServer extends World implements IThreadListener
{
    private final /* synthetic */ Set pendingTickListEntriesHashSet;
    private static final /* synthetic */ Logger logger;
    private /* synthetic */ List pendingTickListEntriesThisTick;
    private /* synthetic */ boolean allPlayersSleeping;
    private final /* synthetic */ Teleporter worldTeleporter;
    private /* synthetic */ int updateEntityTick;
    private final /* synthetic */ EntityTracker theEntityTracker;
    private final /* synthetic */ Map entitiesByUuid;
    private static final /* synthetic */ List bonusChestContent;
    private /* synthetic */ ServerBlockEventList[] field_147490_S;
    private final /* synthetic */ MinecraftServer mcServer;
    private final /* synthetic */ PlayerManager thePlayerManager;
    private final /* synthetic */ SpawnerAnimals field_175742_R;
    protected final /* synthetic */ VillageSiege villageSiege;
    private final /* synthetic */ TreeSet pendingTickListEntriesTreeSet;
    public /* synthetic */ ChunkProviderServer theChunkProviderServer;
    private /* synthetic */ int blockEventCacheIndex;
    
    @Override
    public boolean isCallingFromMinecraftThread() {
        return this.mcServer.isCallingFromMinecraftThread();
    }
    
    public void saveChunkData() {
        if (this.chunkProvider.canSave()) {
            this.chunkProvider.saveExtraData();
        }
    }
    
    private boolean func_175735_ai() {
        return this.mcServer.getCanSpawnAnimals();
    }
    
    protected void createBonusChest() {
        final WorldGeneratorBonusChest llllllllllllllIlIlIlIllIIllIIlIl = new WorldGeneratorBonusChest(WorldServer.bonusChestContent, 10);
        for (int llllllllllllllIlIlIlIllIIllIIlII = 0; llllllllllllllIlIlIlIllIIllIIlII < 10; ++llllllllllllllIlIlIlIllIIllIIlII) {
            final int llllllllllllllIlIlIlIllIIllIIIll = this.worldInfo.getSpawnX() + this.rand.nextInt(6) - this.rand.nextInt(6);
            final int llllllllllllllIlIlIlIllIIllIIIlI = this.worldInfo.getSpawnZ() + this.rand.nextInt(6) - this.rand.nextInt(6);
            final BlockPos llllllllllllllIlIlIlIllIIllIIIIl = this.func_175672_r(new BlockPos(llllllllllllllIlIlIlIllIIllIIIll, 0, llllllllllllllIlIlIlIllIIllIIIlI)).offsetUp();
            if (llllllllllllllIlIlIlIllIIllIIlIl.generate(this, this.rand, llllllllllllllIlIlIlIllIIllIIIIl)) {
                break;
            }
        }
    }
    
    @Override
    public boolean tickUpdates(final boolean llllllllllllllIlIlIlIllllIllllII) {
        if (this.worldInfo.getTerrainType() == WorldType.DEBUG_WORLD) {
            return false;
        }
        int llllllllllllllIlIlIlIlllllIIIlll = this.pendingTickListEntriesTreeSet.size();
        if (llllllllllllllIlIlIlIlllllIIIlll != this.pendingTickListEntriesHashSet.size()) {
            throw new IllegalStateException("TickNextTick list out of synch");
        }
        if (llllllllllllllIlIlIlIlllllIIIlll > 1000) {
            llllllllllllllIlIlIlIlllllIIIlll = 1000;
        }
        this.theProfiler.startSection("cleaning");
        for (int llllllllllllllIlIlIlIlllllIIIlII = 0; llllllllllllllIlIlIlIlllllIIIlII < llllllllllllllIlIlIlIlllllIIIlll; ++llllllllllllllIlIlIlIlllllIIIlII) {
            final NextTickListEntry llllllllllllllIlIlIlIlllllIIIllI = this.pendingTickListEntriesTreeSet.first();
            if (!llllllllllllllIlIlIlIllllIllllII && llllllllllllllIlIlIlIlllllIIIllI.scheduledTime > this.worldInfo.getWorldTotalTime()) {
                break;
            }
            this.pendingTickListEntriesTreeSet.remove(llllllllllllllIlIlIlIlllllIIIllI);
            this.pendingTickListEntriesHashSet.remove(llllllllllllllIlIlIlIlllllIIIllI);
            this.pendingTickListEntriesThisTick.add(llllllllllllllIlIlIlIlllllIIIllI);
        }
        this.theProfiler.endSection();
        this.theProfiler.startSection("ticking");
        final Iterator llllllllllllllIlIlIlIlllllIIIIll = this.pendingTickListEntriesThisTick.iterator();
        while (llllllllllllllIlIlIlIlllllIIIIll.hasNext()) {
            final NextTickListEntry llllllllllllllIlIlIlIlllllIIIlIl = llllllllllllllIlIlIlIlllllIIIIll.next();
            llllllllllllllIlIlIlIlllllIIIIll.remove();
            final byte llllllllllllllIlIlIlIlllllIIIIlI = 0;
            if (this.isAreaLoaded(llllllllllllllIlIlIlIlllllIIIlIl.field_180282_a.add(-llllllllllllllIlIlIlIlllllIIIIlI, -llllllllllllllIlIlIlIlllllIIIIlI, -llllllllllllllIlIlIlIlllllIIIIlI), llllllllllllllIlIlIlIlllllIIIlIl.field_180282_a.add(llllllllllllllIlIlIlIlllllIIIIlI, llllllllllllllIlIlIlIlllllIIIIlI, llllllllllllllIlIlIlIlllllIIIIlI))) {
                final IBlockState llllllllllllllIlIlIlIlllllIIIIIl = this.getBlockState(llllllllllllllIlIlIlIlllllIIIlIl.field_180282_a);
                if (llllllllllllllIlIlIlIlllllIIIIIl.getBlock().getMaterial() == Material.air || !Block.isEqualTo(llllllllllllllIlIlIlIlllllIIIIIl.getBlock(), llllllllllllllIlIlIlIlllllIIIlIl.func_151351_a())) {
                    continue;
                }
                try {
                    llllllllllllllIlIlIlIlllllIIIIIl.getBlock().updateTick(this, llllllllllllllIlIlIlIlllllIIIlIl.field_180282_a, llllllllllllllIlIlIlIlllllIIIIIl, this.rand);
                    continue;
                }
                catch (Throwable llllllllllllllIlIlIlIlllllIIIIII) {
                    final CrashReport llllllllllllllIlIlIlIllllIllllll = CrashReport.makeCrashReport(llllllllllllllIlIlIlIlllllIIIIII, "Exception while ticking a block");
                    final CrashReportCategory llllllllllllllIlIlIlIllllIlllllI = llllllllllllllIlIlIlIllllIllllll.makeCategory("Block being ticked");
                    CrashReportCategory.addBlockInfo(llllllllllllllIlIlIlIllllIlllllI, llllllllllllllIlIlIlIlllllIIIlIl.field_180282_a, llllllllllllllIlIlIlIlllllIIIIIl);
                    throw new ReportedException(llllllllllllllIlIlIlIllllIllllll);
                }
            }
            this.scheduleUpdate(llllllllllllllIlIlIlIlllllIIIlIl.field_180282_a, llllllllllllllIlIlIlIlllllIIIlIl.func_151351_a(), 0);
        }
        this.theProfiler.endSection();
        this.pendingTickListEntriesThisTick.clear();
        return !this.pendingTickListEntriesTreeSet.isEmpty();
    }
    
    private boolean func_175738_ah() {
        return this.mcServer.getCanSpawnNPCs();
    }
    
    @Override
    protected int getRenderDistanceChunks() {
        return this.mcServer.getConfigurationManager().getViewDistance();
    }
    
    @Override
    public void updateEntityWithOptionalForce(final Entity llllllllllllllIlIlIlIlllIlIIIlll, final boolean llllllllllllllIlIlIlIlllIlIIIlIl) {
        if (!this.func_175735_ai() && (llllllllllllllIlIlIlIlllIlIIIlll instanceof EntityAnimal || llllllllllllllIlIlIlIlllIlIIIlll instanceof EntityWaterMob)) {
            llllllllllllllIlIlIlIlllIlIIIlll.setDead();
        }
        if (!this.func_175738_ah() && llllllllllllllIlIlIlIlllIlIIIlll instanceof INpc) {
            llllllllllllllIlIlIlIlllIlIIIlll.setDead();
        }
        super.updateEntityWithOptionalForce(llllllllllllllIlIlIlIlllIlIIIlll, llllllllllllllIlIlIlIlllIlIIIlIl);
    }
    
    public BlockPos func_180504_m() {
        return this.provider.func_177496_h();
    }
    
    @Override
    protected void onEntityAdded(final Entity llllllllllllllIlIlIlIllIIIIlllll) {
        super.onEntityAdded(llllllllllllllIlIlIlIllIIIIlllll);
        this.entitiesById.addKey(llllllllllllllIlIlIlIllIIIIlllll.getEntityId(), llllllllllllllIlIlIlIllIIIIlllll);
        this.entitiesByUuid.put(llllllllllllllIlIlIlIllIIIIlllll.getUniqueID(), llllllllllllllIlIlIlIllIIIIlllll);
        final Entity[] llllllllllllllIlIlIlIllIIIIlllIl = llllllllllllllIlIlIlIllIIIIlllll.getParts();
        if (llllllllllllllIlIlIlIllIIIIlllIl != null) {
            for (int llllllllllllllIlIlIlIllIIIIllIll = 0; llllllllllllllIlIlIlIllIIIIllIll < llllllllllllllIlIlIlIllIIIIlllIl.length; ++llllllllllllllIlIlIlIllIIIIllIll) {
                this.entitiesById.addKey(llllllllllllllIlIlIlIllIIIIlllIl[llllllllllllllIlIlIlIllIIIIllIll].getEntityId(), llllllllllllllIlIlIlIllIIIIlllIl[llllllllllllllIlIlIlIllIIIIllIll]);
            }
        }
    }
    
    public WorldServer(final MinecraftServer llllllllllllllIlIlIllIIIllIlIlIl, final ISaveHandler llllllllllllllIlIlIllIIIllIlIlII, final WorldInfo llllllllllllllIlIlIllIIIllIlIIll, final int llllllllllllllIlIlIllIIIllIlIIlI, final Profiler llllllllllllllIlIlIllIIIllIlIIIl) {
        super(llllllllllllllIlIlIllIIIllIlIlII, llllllllllllllIlIlIllIIIllIlIIll, WorldProvider.getProviderForDimension(llllllllllllllIlIlIllIIIllIlIIlI), llllllllllllllIlIlIllIIIllIlIIIl, false);
        this.pendingTickListEntriesHashSet = Sets.newHashSet();
        this.pendingTickListEntriesTreeSet = new TreeSet();
        this.entitiesByUuid = Maps.newHashMap();
        this.field_175742_R = new SpawnerAnimals();
        this.villageSiege = new VillageSiege(this);
        this.field_147490_S = new ServerBlockEventList[] { new ServerBlockEventList((Object)null), new ServerBlockEventList((Object)null) };
        this.pendingTickListEntriesThisTick = Lists.newArrayList();
        this.mcServer = llllllllllllllIlIlIllIIIllIlIlIl;
        this.theEntityTracker = new EntityTracker(this);
        this.thePlayerManager = new PlayerManager(this);
        this.provider.registerWorld(this);
        this.chunkProvider = this.createChunkProvider();
        this.worldTeleporter = new Teleporter(this);
        this.calculateInitialSkylight();
        this.calculateInitialWeather();
        this.getWorldBorder().setSize(llllllllllllllIlIlIllIIIllIlIlIl.getMaxWorldSize());
    }
    
    protected BlockPos func_175736_a(final BlockPos llllllllllllllIlIlIllIIIIIIlllll) {
        final BlockPos llllllllllllllIlIlIllIIIIIlIIIll = this.func_175725_q(llllllllllllllIlIlIllIIIIIIlllll);
        final AxisAlignedBB llllllllllllllIlIlIllIIIIIlIIIlI = new AxisAlignedBB(llllllllllllllIlIlIllIIIIIlIIIll, new BlockPos(llllllllllllllIlIlIllIIIIIlIIIll.getX(), this.getHeight(), llllllllllllllIlIlIllIIIIIlIIIll.getZ())).expand(3.0, 3.0, 3.0);
        final List llllllllllllllIlIlIllIIIIIlIIIIl = this.func_175647_a(EntityLivingBase.class, llllllllllllllIlIlIllIIIIIlIIIlI, (Predicate)new Predicate() {
            static {
                __OBFID = "CL_00001889";
            }
            
            public boolean apply(final Object llllllllllllllIlllIIllIlIIIlIIIl) {
                return this.func_180242_a((EntityLivingBase)llllllllllllllIlllIIllIlIIIlIIIl);
            }
            
            public boolean func_180242_a(final EntityLivingBase llllllllllllllIlllIIllIlIIIlIlIl) {
                return llllllllllllllIlllIIllIlIIIlIlIl != null && llllllllllllllIlllIIllIlIIIlIlIl.isEntityAlive() && WorldServer.this.isAgainstSky(llllllllllllllIlllIIllIlIIIlIlIl.getPosition());
            }
        });
        return llllllllllllllIlIlIllIIIIIlIIIIl.isEmpty() ? llllllllllllllIlIlIllIIIIIlIIIll : llllllllllllllIlIlIllIIIIIlIIIIl.get(this.rand.nextInt(llllllllllllllIlIlIllIIIIIlIIIIl.size())).getPosition();
    }
    
    @Override
    public Explosion newExplosion(final Entity llllllllllllllIlIlIlIlIllIIlIIlI, final double llllllllllllllIlIlIlIlIllIIlIIIl, final double llllllllllllllIlIlIlIlIllIlIIIII, final double llllllllllllllIlIlIlIlIllIIlllll, final float llllllllllllllIlIlIlIlIllIIlllIl, final boolean llllllllllllllIlIlIlIlIllIIllIll, final boolean llllllllllllllIlIlIlIlIllIIIllII) {
        final Explosion llllllllllllllIlIlIlIlIllIIllIII = new Explosion(this, llllllllllllllIlIlIlIlIllIIlIIlI, llllllllllllllIlIlIlIlIllIIlIIIl, llllllllllllllIlIlIlIlIllIlIIIII, llllllllllllllIlIlIlIlIllIIlllll, llllllllllllllIlIlIlIlIllIIlllIl, llllllllllllllIlIlIlIlIllIIllIll, llllllllllllllIlIlIlIlIllIIIllII);
        llllllllllllllIlIlIlIlIllIIllIII.doExplosionA();
        llllllllllllllIlIlIlIlIllIIllIII.doExplosionB(false);
        if (!llllllllllllllIlIlIlIlIllIIIllII) {
            llllllllllllllIlIlIlIlIllIIllIII.func_180342_d();
        }
        for (final EntityPlayer llllllllllllllIlIlIlIlIllIIlIlIl : this.playerEntities) {
            if (llllllllllllllIlIlIlIlIllIIlIlIl.getDistanceSq(llllllllllllllIlIlIlIlIllIIlIIIl, llllllllllllllIlIlIlIlIllIlIIIII, llllllllllllllIlIlIlIlIllIIlllll) < 4096.0) {
                ((EntityPlayerMP)llllllllllllllIlIlIlIlIllIIlIlIl).playerNetServerHandler.sendPacket(new S27PacketExplosion(llllllllllllllIlIlIlIlIllIIlIIIl, llllllllllllllIlIlIlIlIllIlIIIII, llllllllllllllIlIlIlIlIllIIlllll, llllllllllllllIlIlIlIlIllIIlllIl, llllllllllllllIlIlIlIlIllIIllIII.func_180343_e(), llllllllllllllIlIlIlIlIllIIllIII.func_77277_b().get(llllllllllllllIlIlIlIlIllIIlIlIl)));
            }
        }
        return llllllllllllllIlIlIlIlIllIIllIII;
    }
    
    @Override
    public boolean addWeatherEffect(final Entity llllllllllllllIlIlIlIlIlllllIlIl) {
        if (super.addWeatherEffect(llllllllllllllIlIlIlIlIlllllIlIl)) {
            this.mcServer.getConfigurationManager().sendToAllNear(llllllllllllllIlIlIlIlIlllllIlIl.posX, llllllllllllllIlIlIlIlIlllllIlIl.posY, llllllllllllllIlIlIlIlIlllllIlIl.posZ, 512.0, this.provider.getDimensionId(), new S2CPacketSpawnGlobalEntity(llllllllllllllIlIlIlIlIlllllIlIl));
            return true;
        }
        return false;
    }
    
    @Override
    protected void updateWeather() {
        final boolean llllllllllllllIlIlIlIlIlIIlIIlIl = this.isRaining();
        super.updateWeather();
        if (this.prevRainingStrength != this.rainingStrength) {
            this.mcServer.getConfigurationManager().sendPacketToAllPlayersInDimension(new S2BPacketChangeGameState(7, this.rainingStrength), this.provider.getDimensionId());
        }
        if (this.prevThunderingStrength != this.thunderingStrength) {
            this.mcServer.getConfigurationManager().sendPacketToAllPlayersInDimension(new S2BPacketChangeGameState(8, this.thunderingStrength), this.provider.getDimensionId());
        }
        if (llllllllllllllIlIlIlIlIlIIlIIlIl != this.isRaining()) {
            if (llllllllllllllIlIlIlIlIlIIlIIlIl) {
                this.mcServer.getConfigurationManager().sendPacketToAllPlayers(new S2BPacketChangeGameState(2, 0.0f));
            }
            else {
                this.mcServer.getConfigurationManager().sendPacketToAllPlayers(new S2BPacketChangeGameState(1, 0.0f));
            }
            this.mcServer.getConfigurationManager().sendPacketToAllPlayers(new S2BPacketChangeGameState(7, this.rainingStrength));
            this.mcServer.getConfigurationManager().sendPacketToAllPlayers(new S2BPacketChangeGameState(8, this.thunderingStrength));
        }
    }
    
    public void flush() {
        this.saveHandler.flush();
    }
    
    @Override
    public void initialize(final WorldSettings llllllllllllllIlIlIlIllIllIIIIlI) {
        if (!this.worldInfo.isInitialized()) {
            try {
                this.createSpawnPosition(llllllllllllllIlIlIlIllIllIIIIlI);
                if (this.worldInfo.getTerrainType() == WorldType.DEBUG_WORLD) {
                    this.setDebugWorldSettings();
                }
                super.initialize(llllllllllllllIlIlIlIllIllIIIIlI);
            }
            catch (Throwable llllllllllllllIlIlIlIllIllIIIIIl) {
                final CrashReport llllllllllllllIlIlIlIllIllIIIIII = CrashReport.makeCrashReport(llllllllllllllIlIlIlIllIllIIIIIl, "Exception initializing level");
                try {
                    this.addWorldInfoToCrashReport(llllllllllllllIlIlIlIllIllIIIIII);
                }
                catch (Throwable t) {}
                throw new ReportedException(llllllllllllllIlIlIlIllIllIIIIII);
            }
            this.worldInfo.setServerInitialized(true);
        }
    }
    
    @Override
    protected void onEntityRemoved(final Entity llllllllllllllIlIlIlIlIllllllllI) {
        super.onEntityRemoved(llllllllllllllIlIlIlIlIllllllllI);
        this.entitiesById.removeObject(llllllllllllllIlIlIlIlIllllllllI.getEntityId());
        this.entitiesByUuid.remove(llllllllllllllIlIlIlIlIllllllllI.getUniqueID());
        final Entity[] llllllllllllllIlIlIlIllIIIIIIIlI = llllllllllllllIlIlIlIlIllllllllI.getParts();
        if (llllllllllllllIlIlIlIllIIIIIIIlI != null) {
            for (int llllllllllllllIlIlIlIllIIIIIIIII = 0; llllllllllllllIlIlIlIllIIIIIIIII < llllllllllllllIlIlIlIllIIIIIIIlI.length; ++llllllllllllllIlIlIlIllIIIIIIIII) {
                this.entitiesById.removeObject(llllllllllllllIlIlIlIllIIIIIIIlI[llllllllllllllIlIlIlIllIIIIIIIII].getEntityId());
            }
        }
    }
    
    static {
        __OBFID = "CL_00001437";
        logger = LogManager.getLogger();
        bonusChestContent = Lists.newArrayList((Object[])new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.stick, 0, 1, 3, 10), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.planks), 0, 1, 3, 10), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.log), 0, 1, 3, 10), new WeightedRandomChestContent(Items.stone_axe, 0, 1, 1, 3), new WeightedRandomChestContent(Items.wooden_axe, 0, 1, 1, 5), new WeightedRandomChestContent(Items.stone_pickaxe, 0, 1, 1, 3), new WeightedRandomChestContent(Items.wooden_pickaxe, 0, 1, 1, 5), new WeightedRandomChestContent(Items.apple, 0, 2, 3, 5), new WeightedRandomChestContent(Items.bread, 0, 2, 3, 3), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.log2), 0, 1, 3, 10) });
    }
    
    @Override
    protected IChunkProvider createChunkProvider() {
        final IChunkLoader llllllllllllllIlIlIlIlllIIlIlIIl = this.saveHandler.getChunkLoader(this.provider);
        this.theChunkProviderServer = new ChunkProviderServer(this, llllllllllllllIlIlIlIlllIIlIlIIl, this.provider.createChunkGenerator());
        return this.theChunkProviderServer;
    }
    
    public Entity getEntityFromUuid(final UUID llllllllllllllIlIlIlIlIIlIIIIIIl) {
        return this.entitiesByUuid.get(llllllllllllllIlIlIlIlIIlIIIIIIl);
    }
    
    @Override
    public ListenableFuture addScheduledTask(final Runnable llllllllllllllIlIlIlIlIIIlllllIl) {
        return this.mcServer.addScheduledTask(llllllllllllllIlIlIlIlIIIlllllIl);
    }
    
    public BiomeGenBase.SpawnListEntry func_175734_a(final EnumCreatureType llllllllllllllIlIlIllIIIlIlllIII, final BlockPos llllllllllllllIlIlIllIIIlIllIIll) {
        final List llllllllllllllIlIlIllIIIlIllIllI = this.getChunkProvider().func_177458_a(llllllllllllllIlIlIllIIIlIlllIII, llllllllllllllIlIlIllIIIlIllIIll);
        return (llllllllllllllIlIlIllIIIlIllIllI != null && !llllllllllllllIlIlIllIIIlIllIllI.isEmpty()) ? ((BiomeGenBase.SpawnListEntry)WeightedRandom.getRandomItem(this.rand, llllllllllllllIlIlIllIIIlIllIllI)) : null;
    }
    
    public void func_180505_a(final EnumParticleTypes llllllllllllllIlIlIlIlIIlIlllIIl, final boolean llllllllllllllIlIlIlIlIIlIlIIIIl, final double llllllllllllllIlIlIlIlIIlIlIIIII, final double llllllllllllllIlIlIlIlIIlIllIlIl, final double llllllllllllllIlIlIlIlIIlIIlllII, final int llllllllllllllIlIlIlIlIIlIIllIlI, final double llllllllllllllIlIlIlIlIIlIllIIlI, final double llllllllllllllIlIlIlIlIIlIllIIIl, final double llllllllllllllIlIlIlIlIIlIIlIlII, final double llllllllllllllIlIlIlIlIIlIIlIIlI, final int... llllllllllllllIlIlIlIlIIlIlIlllI) {
        final S2APacketParticles llllllllllllllIlIlIlIlIIlIlIllIl = new S2APacketParticles(llllllllllllllIlIlIlIlIIlIlllIIl, llllllllllllllIlIlIlIlIIlIlIIIIl, (float)llllllllllllllIlIlIlIlIIlIlIIIII, (float)llllllllllllllIlIlIlIlIIlIllIlIl, (float)llllllllllllllIlIlIlIlIIlIIlllII, (float)llllllllllllllIlIlIlIlIIlIllIIlI, (float)llllllllllllllIlIlIlIlIIlIllIIIl, (float)llllllllllllllIlIlIlIlIIlIIlIlII, (float)llllllllllllllIlIlIlIlIIlIIlIIlI, llllllllllllllIlIlIlIlIIlIIllIlI, llllllllllllllIlIlIlIlIIlIlIlllI);
        for (int llllllllllllllIlIlIlIlIIlIlIllII = 0; llllllllllllllIlIlIlIlIIlIlIllII < this.playerEntities.size(); ++llllllllllllllIlIlIlIlIIlIlIllII) {
            final EntityPlayerMP llllllllllllllIlIlIlIlIIlIlIlIlI = this.playerEntities.get(llllllllllllllIlIlIlIlIIlIlIllII);
            final BlockPos llllllllllllllIlIlIlIlIIlIlIlIIl = llllllllllllllIlIlIlIlIIlIlIlIlI.getPosition();
            final double llllllllllllllIlIlIlIlIIlIlIIlll = llllllllllllllIlIlIlIlIIlIlIlIIl.distanceSq(llllllllllllllIlIlIlIlIIlIlIIIII, llllllllllllllIlIlIlIlIIlIllIlIl, llllllllllllllIlIlIlIlIIlIIlllII);
            if (llllllllllllllIlIlIlIlIIlIlIIlll <= 256.0 || (llllllllllllllIlIlIlIlIIlIlIIIIl && llllllllllllllIlIlIlIlIIlIlIIlll <= 65536.0)) {
                llllllllllllllIlIlIlIlIIlIlIlIlI.playerNetServerHandler.sendPacket(llllllllllllllIlIlIlIlIIlIlIllIl);
            }
        }
    }
    
    protected void saveLevel() throws MinecraftException {
        this.checkSessionLock();
        this.worldInfo.func_176145_a(this.getWorldBorder().getDiameter());
        this.worldInfo.func_176124_d(this.getWorldBorder().getCenterX());
        this.worldInfo.func_176141_c(this.getWorldBorder().getCenterZ());
        this.worldInfo.func_176129_e(this.getWorldBorder().getDamageBuffer());
        this.worldInfo.func_176125_f(this.getWorldBorder().func_177727_n());
        this.worldInfo.func_176122_j(this.getWorldBorder().getWarningDistance());
        this.worldInfo.func_176136_k(this.getWorldBorder().getWarningTime());
        this.worldInfo.func_176118_b(this.getWorldBorder().getTargetSize());
        this.worldInfo.func_176135_e(this.getWorldBorder().getTimeUntilTarget());
        this.saveHandler.saveWorldInfoWithPlayer(this.worldInfo, this.mcServer.getConfigurationManager().getHostPlayerData());
        this.mapStorage.saveAllData();
    }
    
    @Override
    public List func_175712_a(final StructureBoundingBox llllllllllllllIlIlIlIlllIlIlllII, final boolean llllllllllllllIlIlIlIlllIllIlIII) {
        ArrayList llllllllllllllIlIlIlIlllIllIIlll = null;
        for (int llllllllllllllIlIlIlIlllIllIIllI = 0; llllllllllllllIlIlIlIlllIllIIllI < 2; ++llllllllllllllIlIlIlIlllIllIIllI) {
            Iterator llllllllllllllIlIlIlIlllIllIIIll = null;
            if (llllllllllllllIlIlIlIlllIllIIllI == 0) {
                final Iterator llllllllllllllIlIlIlIlllIllIIlIl = this.pendingTickListEntriesTreeSet.iterator();
            }
            else {
                llllllllllllllIlIlIlIlllIllIIIll = this.pendingTickListEntriesThisTick.iterator();
                if (!this.pendingTickListEntriesThisTick.isEmpty()) {
                    WorldServer.logger.debug(String.valueOf(new StringBuilder("toBeTicked = ").append(this.pendingTickListEntriesThisTick.size())));
                }
            }
            while (llllllllllllllIlIlIlIlllIllIIIll.hasNext()) {
                final NextTickListEntry llllllllllllllIlIlIlIlllIllIIIIl = llllllllllllllIlIlIlIlllIllIIIll.next();
                final BlockPos llllllllllllllIlIlIlIlllIlIlllll = llllllllllllllIlIlIlIlllIllIIIIl.field_180282_a;
                if (llllllllllllllIlIlIlIlllIlIlllll.getX() >= llllllllllllllIlIlIlIlllIlIlllII.minX && llllllllllllllIlIlIlIlllIlIlllll.getX() < llllllllllllllIlIlIlIlllIlIlllII.maxX && llllllllllllllIlIlIlIlllIlIlllll.getZ() >= llllllllllllllIlIlIlIlllIlIlllII.minZ && llllllllllllllIlIlIlIlllIlIlllll.getZ() < llllllllllllllIlIlIlIlllIlIlllII.maxZ) {
                    if (llllllllllllllIlIlIlIlllIllIlIII) {
                        this.pendingTickListEntriesHashSet.remove(llllllllllllllIlIlIlIlllIllIIIIl);
                        llllllllllllllIlIlIlIlllIllIIIll.remove();
                    }
                    if (llllllllllllllIlIlIlIlllIllIIlll == null) {
                        llllllllllllllIlIlIlIlllIllIIlll = Lists.newArrayList();
                    }
                    llllllllllllllIlIlIlIlllIllIIlll.add(llllllllllllllIlIlIlIlllIllIIIIl);
                }
            }
        }
        return llllllllllllllIlIlIlIlllIllIIlll;
    }
    
    public boolean func_175732_a(final EnumCreatureType llllllllllllllIlIlIllIIIlIlIIllI, final BiomeGenBase.SpawnListEntry llllllllllllllIlIlIllIIIlIlIlIlI, final BlockPos llllllllllllllIlIlIllIIIlIlIIlII) {
        final List llllllllllllllIlIlIllIIIlIlIlIII = this.getChunkProvider().func_177458_a(llllllllllllllIlIlIllIIIlIlIIllI, llllllllllllllIlIlIllIIIlIlIIlII);
        return llllllllllllllIlIlIllIIIlIlIlIII != null && !llllllllllllllIlIlIllIIIlIlIlIII.isEmpty() && llllllllllllllIlIlIllIIIlIlIlIII.contains(llllllllllllllIlIlIllIIIlIlIlIlI);
    }
    
    @Override
    public World init() {
        this.mapStorage = new MapStorage(this.saveHandler);
        final String llllllllllllllIlIlIllIIIllIIlIll = VillageCollection.func_176062_a(this.provider);
        final VillageCollection llllllllllllllIlIlIllIIIllIIlIlI = (VillageCollection)this.mapStorage.loadData(VillageCollection.class, llllllllllllllIlIlIllIIIllIIlIll);
        if (llllllllllllllIlIlIllIIIllIIlIlI == null) {
            this.villageCollectionObj = new VillageCollection(this);
            this.mapStorage.setData(llllllllllllllIlIlIllIIIllIIlIll, this.villageCollectionObj);
        }
        else {
            this.villageCollectionObj = llllllllllllllIlIlIllIIIllIIlIlI;
            this.villageCollectionObj.func_82566_a(this);
        }
        this.worldScoreboard = new ServerScoreboard(this.mcServer);
        ScoreboardSaveData llllllllllllllIlIlIllIIIllIIlIIl = (ScoreboardSaveData)this.mapStorage.loadData(ScoreboardSaveData.class, "scoreboard");
        if (llllllllllllllIlIlIllIIIllIIlIIl == null) {
            llllllllllllllIlIlIllIIIllIIlIIl = new ScoreboardSaveData();
            this.mapStorage.setData("scoreboard", llllllllllllllIlIlIllIIIllIIlIIl);
        }
        llllllllllllllIlIlIllIIIllIIlIIl.func_96499_a(this.worldScoreboard);
        ((ServerScoreboard)this.worldScoreboard).func_96547_a(llllllllllllllIlIlIllIIIllIIlIIl);
        this.getWorldBorder().setCenter(this.worldInfo.func_176120_C(), this.worldInfo.func_176126_D());
        this.getWorldBorder().func_177744_c(this.worldInfo.func_176140_I());
        this.getWorldBorder().setDamageBuffer(this.worldInfo.func_176138_H());
        this.getWorldBorder().setWarningDistance(this.worldInfo.func_176131_J());
        this.getWorldBorder().setWarningTime(this.worldInfo.func_176139_K());
        if (this.worldInfo.func_176134_F() > 0L) {
            this.getWorldBorder().setTransition(this.worldInfo.func_176137_E(), this.worldInfo.func_176132_G(), this.worldInfo.func_176134_F());
        }
        else {
            this.getWorldBorder().setTransition(this.worldInfo.func_176137_E());
        }
        return this;
    }
    
    @Override
    public void setInitialSpawnLocation() {
        if (this.worldInfo.getSpawnY() <= 0) {
            this.worldInfo.setSpawnY(64);
        }
        int llllllllllllllIlIlIllIIIIllllIIl = this.worldInfo.getSpawnX();
        int llllllllllllllIlIlIllIIIIllllIII = this.worldInfo.getSpawnZ();
        int llllllllllllllIlIlIllIIIIlllIlll = 0;
        while (this.getGroundAboveSeaLevel(new BlockPos(llllllllllllllIlIlIllIIIIllllIIl, 0, llllllllllllllIlIlIllIIIIllllIII)).getMaterial() == Material.air) {
            llllllllllllllIlIlIllIIIIllllIIl += this.rand.nextInt(8) - this.rand.nextInt(8);
            llllllllllllllIlIlIllIIIIllllIII += this.rand.nextInt(8) - this.rand.nextInt(8);
            if (++llllllllllllllIlIlIllIIIIlllIlll == 10000) {
                break;
            }
        }
        this.worldInfo.setSpawnX(llllllllllllllIlIlIllIIIIllllIIl);
        this.worldInfo.setSpawnZ(llllllllllllllIlIlIllIIIIllllIII);
    }
    
    public MinecraftServer func_73046_m() {
        return this.mcServer;
    }
    
    @Override
    public boolean isBlockTickPending(final BlockPos llllllllllllllIlIlIllIIIIIIlIIlI, final Block llllllllllllllIlIlIllIIIIIIlIIIl) {
        final NextTickListEntry llllllllllllllIlIlIllIIIIIIlIlII = new NextTickListEntry(llllllllllllllIlIlIllIIIIIIlIIlI, llllllllllllllIlIlIllIIIIIIlIIIl);
        return this.pendingTickListEntriesThisTick.contains(llllllllllllllIlIlIllIIIIIIlIlII);
    }
    
    public EntityTracker getEntityTracker() {
        return this.theEntityTracker;
    }
    
    public boolean areAllPlayersAsleep() {
        if (this.allPlayersSleeping && !this.isRemote) {
            for (final EntityPlayer llllllllllllllIlIlIllIIIlIIIIIlI : this.playerEntities) {
                if (llllllllllllllIlIlIllIIIlIIIIIlI.func_175149_v() || !llllllllllllllIlIlIllIIIlIIIIIlI.isPlayerFullyAsleep()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    @Override
    public boolean isBlockModifiable(final EntityPlayer llllllllllllllIlIlIlIllIllIlllIl, final BlockPos llllllllllllllIlIlIlIllIllIlllll) {
        return !this.mcServer.isBlockProtected(this, llllllllllllllIlIlIlIllIllIlllll, llllllllllllllIlIlIlIllIllIlllIl) && this.getWorldBorder().contains(llllllllllllllIlIlIlIllIllIlllll);
    }
    
    private boolean func_147485_a(final BlockEventData llllllllllllllIlIlIlIlIlIIllIlII) {
        final IBlockState llllllllllllllIlIlIlIlIlIIlllIII = this.getBlockState(llllllllllllllIlIlIlIlIlIIllIlII.func_180328_a());
        return llllllllllllllIlIlIlIlIlIIlllIII.getBlock() == llllllllllllllIlIlIlIlIlIIllIlII.getBlock() && llllllllllllllIlIlIlIlIlIIlllIII.getBlock().onBlockEventReceived(this, llllllllllllllIlIlIlIlIlIIllIlII.func_180328_a(), llllllllllllllIlIlIlIlIlIIlllIII, llllllllllllllIlIlIlIlIlIIllIlII.getEventID(), llllllllllllllIlIlIlIlIlIIllIlII.getEventParameter());
    }
    
    @Override
    protected void func_147456_g() {
        super.func_147456_g();
        if (this.worldInfo.getTerrainType() == WorldType.DEBUG_WORLD) {
            for (final ChunkCoordIntPair llllllllllllllIlIlIllIIIIlIllIlI : this.activeChunkSet) {
                this.getChunkFromChunkCoords(llllllllllllllIlIlIllIIIIlIllIlI.chunkXPos, llllllllllllllIlIlIllIIIIlIllIlI.chunkZPos).func_150804_b(false);
            }
        }
        else {
            int llllllllllllllIlIlIllIIIIlIllIIl = 0;
            int llllllllllllllIlIlIllIIIIlIllIII = 0;
            for (final ChunkCoordIntPair llllllllllllllIlIlIllIIIIlIlIllI : this.activeChunkSet) {
                final int llllllllllllllIlIlIllIIIIlIlIlIl = llllllllllllllIlIlIllIIIIlIlIllI.chunkXPos * 16;
                final int llllllllllllllIlIlIllIIIIlIlIlII = llllllllllllllIlIlIllIIIIlIlIllI.chunkZPos * 16;
                this.theProfiler.startSection("getChunk");
                final Chunk llllllllllllllIlIlIllIIIIlIlIIll = this.getChunkFromChunkCoords(llllllllllllllIlIlIllIIIIlIlIllI.chunkXPos, llllllllllllllIlIlIllIIIIlIlIllI.chunkZPos);
                this.func_147467_a(llllllllllllllIlIlIllIIIIlIlIlIl, llllllllllllllIlIlIllIIIIlIlIlII, llllllllllllllIlIlIllIIIIlIlIIll);
                this.theProfiler.endStartSection("tickChunk");
                llllllllllllllIlIlIllIIIIlIlIIll.func_150804_b(false);
                this.theProfiler.endStartSection("thunder");
                if (this.rand.nextInt(100000) == 0 && this.isRaining() && this.isThundering()) {
                    this.updateLCG = this.updateLCG * 3 + 1013904223;
                    final int llllllllllllllIlIlIllIIIIlIlIIlI = this.updateLCG >> 2;
                    final BlockPos llllllllllllllIlIlIllIIIIlIIllll = this.func_175736_a(new BlockPos(llllllllllllllIlIlIllIIIIlIlIlIl + (llllllllllllllIlIlIllIIIIlIlIIlI & 0xF), 0, llllllllllllllIlIlIllIIIIlIlIlII + (llllllllllllllIlIlIllIIIIlIlIIlI >> 8 & 0xF)));
                    if (this.func_175727_C(llllllllllllllIlIlIllIIIIlIIllll)) {
                        this.addWeatherEffect(new EntityLightningBolt(this, llllllllllllllIlIlIllIIIIlIIllll.getX(), llllllllllllllIlIlIllIIIIlIIllll.getY(), llllllllllllllIlIlIllIIIIlIIllll.getZ()));
                    }
                }
                this.theProfiler.endStartSection("iceandsnow");
                if (this.rand.nextInt(16) == 0) {
                    this.updateLCG = this.updateLCG * 3 + 1013904223;
                    final int llllllllllllllIlIlIllIIIIlIlIIIl = this.updateLCG >> 2;
                    final BlockPos llllllllllllllIlIlIllIIIIlIIlllI = this.func_175725_q(new BlockPos(llllllllllllllIlIlIllIIIIlIlIlIl + (llllllllllllllIlIlIllIIIIlIlIIIl & 0xF), 0, llllllllllllllIlIlIllIIIIlIlIlII + (llllllllllllllIlIlIllIIIIlIlIIIl >> 8 & 0xF)));
                    final BlockPos llllllllllllllIlIlIllIIIIlIIllIl = llllllllllllllIlIlIllIIIIlIIlllI.offsetDown();
                    if (this.func_175662_w(llllllllllllllIlIlIllIIIIlIIllIl)) {
                        this.setBlockState(llllllllllllllIlIlIllIIIIlIIllIl, Blocks.ice.getDefaultState());
                    }
                    if (this.isRaining() && this.func_175708_f(llllllllllllllIlIlIllIIIIlIIlllI, true)) {
                        this.setBlockState(llllllllllllllIlIlIllIIIIlIIlllI, Blocks.snow_layer.getDefaultState());
                    }
                    if (this.isRaining() && this.getBiomeGenForCoords(llllllllllllllIlIlIllIIIIlIIllIl).canSpawnLightningBolt()) {
                        this.getBlockState(llllllllllllllIlIlIllIIIIlIIllIl).getBlock().fillWithRain(this, llllllllllllllIlIlIllIIIIlIIllIl);
                    }
                }
                this.theProfiler.endStartSection("tickBlocks");
                final int llllllllllllllIlIlIllIIIIlIlIIII = this.getGameRules().getInt("randomTickSpeed");
                if (llllllllllllllIlIlIllIIIIlIlIIII > 0) {
                    for (final ExtendedBlockStorage llllllllllllllIlIlIllIIIIlIIlIIl : llllllllllllllIlIlIllIIIIlIlIIll.getBlockStorageArray()) {
                        if (llllllllllllllIlIlIllIIIIlIIlIIl != null && llllllllllllllIlIlIllIIIIlIIlIIl.getNeedsRandomTick()) {
                            for (int llllllllllllllIlIlIllIIIIlIIlIII = 0; llllllllllllllIlIlIllIIIIlIIlIII < llllllllllllllIlIlIllIIIIlIlIIII; ++llllllllllllllIlIlIllIIIIlIIlIII) {
                                this.updateLCG = this.updateLCG * 3 + 1013904223;
                                final int llllllllllllllIlIlIllIIIIlIIIlll = this.updateLCG >> 2;
                                final int llllllllllllllIlIlIllIIIIlIIIllI = llllllllllllllIlIlIllIIIIlIIIlll & 0xF;
                                final int llllllllllllllIlIlIllIIIIlIIIlIl = llllllllllllllIlIlIllIIIIlIIIlll >> 8 & 0xF;
                                final int llllllllllllllIlIlIllIIIIlIIIlII = llllllllllllllIlIlIllIIIIlIIIlll >> 16 & 0xF;
                                ++llllllllllllllIlIlIllIIIIlIllIII;
                                final BlockPos llllllllllllllIlIlIllIIIIlIIIIll = new BlockPos(llllllllllllllIlIlIllIIIIlIIIllI + llllllllllllllIlIlIllIIIIlIlIlIl, llllllllllllllIlIlIllIIIIlIIIlII + llllllllllllllIlIlIllIIIIlIIlIIl.getYLocation(), llllllllllllllIlIlIllIIIIlIIIlIl + llllllllllllllIlIlIllIIIIlIlIlII);
                                final IBlockState llllllllllllllIlIlIllIIIIlIIIIlI = llllllllllllllIlIlIllIIIIlIIlIIl.get(llllllllllllllIlIlIllIIIIlIIIllI, llllllllllllllIlIlIllIIIIlIIIlII, llllllllllllllIlIlIllIIIIlIIIlIl);
                                final Block llllllllllllllIlIlIllIIIIlIIIIIl = llllllllllllllIlIlIllIIIIlIIIIlI.getBlock();
                                if (llllllllllllllIlIlIllIIIIlIIIIIl.getTickRandomly()) {
                                    ++llllllllllllllIlIlIllIIIIlIllIIl;
                                    llllllllllllllIlIlIllIIIIlIIIIIl.randomTick(this, llllllllllllllIlIlIllIIIIlIIIIll, llllllllllllllIlIlIllIIIIlIIIIlI, this.rand);
                                }
                            }
                        }
                    }
                }
                this.theProfiler.endSection();
            }
        }
    }
    
    @Override
    public void updateAllPlayersSleepingFlag() {
        this.allPlayersSleeping = false;
        if (!this.playerEntities.isEmpty()) {
            int llllllllllllllIlIlIllIIIlIIlllII = 0;
            int llllllllllllllIlIlIllIIIlIIllIll = 0;
            for (final EntityPlayer llllllllllllllIlIlIllIIIlIIllIIl : this.playerEntities) {
                if (llllllllllllllIlIlIllIIIlIIllIIl.func_175149_v()) {
                    ++llllllllllllllIlIlIllIIIlIIlllII;
                }
                else {
                    if (!llllllllllllllIlIlIllIIIlIIllIIl.isPlayerSleeping()) {
                        continue;
                    }
                    ++llllllllllllllIlIlIllIIIlIIllIll;
                }
            }
            this.allPlayersSleeping = (llllllllllllllIlIlIllIIIlIIllIll > 0 && llllllllllllllIlIlIllIIIlIIllIll >= this.playerEntities.size() - llllllllllllllIlIlIllIIIlIIlllII);
        }
    }
    
    @Override
    public List getPendingBlockUpdates(final Chunk llllllllllllllIlIlIlIllllIIlIIIl, final boolean llllllllllllllIlIlIlIllllIIlIIII) {
        final ChunkCoordIntPair llllllllllllllIlIlIlIllllIIlIlll = llllllllllllllIlIlIlIllllIIlIIIl.getChunkCoordIntPair();
        final int llllllllllllllIlIlIlIllllIIlIllI = (llllllllllllllIlIlIlIllllIIlIlll.chunkXPos << 4) - 2;
        final int llllllllllllllIlIlIlIllllIIlIlIl = llllllllllllllIlIlIlIllllIIlIllI + 16 + 2;
        final int llllllllllllllIlIlIlIllllIIlIlII = (llllllllllllllIlIlIlIllllIIlIlll.chunkZPos << 4) - 2;
        final int llllllllllllllIlIlIlIllllIIlIIll = llllllllllllllIlIlIlIllllIIlIlII + 16 + 2;
        return this.func_175712_a(new StructureBoundingBox(llllllllllllllIlIlIlIllllIIlIllI, 0, llllllllllllllIlIlIlIllllIIlIlII, llllllllllllllIlIlIlIllllIIlIlIl, 256, llllllllllllllIlIlIlIllllIIlIIll), llllllllllllllIlIlIlIllllIIlIIII);
    }
    
    public void saveAllChunks(final boolean llllllllllllllIlIlIlIllIIIlllllI, final IProgressUpdate llllllllllllllIlIlIlIllIIIllllII) throws MinecraftException {
        if (this.chunkProvider.canSave()) {
            if (llllllllllllllIlIlIlIllIIIllllII != null) {
                llllllllllllllIlIlIlIllIIIllllII.displaySavingString("Saving level");
            }
            this.saveLevel();
            if (llllllllllllllIlIlIlIllIIIllllII != null) {
                llllllllllllllIlIlIlIllIIIllllII.displayLoadingString("Saving chunks");
            }
            this.chunkProvider.saveChunks(llllllllllllllIlIlIlIllIIIlllllI, llllllllllllllIlIlIlIllIIIllllII);
            final List llllllllllllllIlIlIlIllIIlIIIlIl = this.theChunkProviderServer.func_152380_a();
            for (final Chunk llllllllllllllIlIlIlIllIIlIIIIlI : llllllllllllllIlIlIlIllIIlIIIlIl) {
                if (!this.thePlayerManager.func_152621_a(llllllllllllllIlIlIlIllIIlIIIIlI.xPosition, llllllllllllllIlIlIlIllIIlIIIIlI.zPosition)) {
                    this.theChunkProviderServer.dropChunk(llllllllllllllIlIlIlIllIIlIIIIlI.xPosition, llllllllllllllIlIlIlIllIIlIIIIlI.zPosition);
                }
            }
        }
    }
    
    public PlayerManager getPlayerManager() {
        return this.thePlayerManager;
    }
    
    @Override
    public void tick() {
        super.tick();
        if (this.getWorldInfo().isHardcoreModeEnabled() && this.getDifficulty() != EnumDifficulty.HARD) {
            this.getWorldInfo().setDifficulty(EnumDifficulty.HARD);
        }
        this.provider.getWorldChunkManager().cleanupCache();
        if (this.areAllPlayersAsleep()) {
            if (this.getGameRules().getGameRuleBooleanValue("doDaylightCycle")) {
                final long llllllllllllllIlIlIllIIIllIIIIIl = this.worldInfo.getWorldTime() + 24000L;
                this.worldInfo.setWorldTime(llllllllllllllIlIlIllIIIllIIIIIl - llllllllllllllIlIlIllIIIllIIIIIl % 24000L);
            }
            this.wakeAllPlayers();
        }
        this.theProfiler.startSection("mobSpawner");
        if (this.getGameRules().getGameRuleBooleanValue("doMobSpawning") && this.worldInfo.getTerrainType() != WorldType.DEBUG_WORLD) {
            this.field_175742_R.findChunksForSpawning(this, this.spawnHostileMobs, this.spawnPeacefulMobs, this.worldInfo.getWorldTotalTime() % 400L == 0L);
        }
        this.theProfiler.endStartSection("chunkSource");
        this.chunkProvider.unloadQueuedChunks();
        final int llllllllllllllIlIlIllIIIllIIIIII = this.calculateSkylightSubtracted(1.0f);
        if (llllllllllllllIlIlIllIIIllIIIIII != this.getSkylightSubtracted()) {
            this.setSkylightSubtracted(llllllllllllllIlIlIllIIIllIIIIII);
        }
        this.worldInfo.incrementTotalWorldTime(this.worldInfo.getWorldTotalTime() + 1L);
        if (this.getGameRules().getGameRuleBooleanValue("doDaylightCycle")) {
            this.worldInfo.setWorldTime(this.worldInfo.getWorldTime() + 1L);
        }
        this.theProfiler.endStartSection("tickPending");
        this.tickUpdates(false);
        this.theProfiler.endStartSection("tickBlocks");
        this.func_147456_g();
        this.theProfiler.endStartSection("chunkMap");
        this.thePlayerManager.updatePlayerInstances();
        this.theProfiler.endStartSection("village");
        this.villageCollectionObj.tick();
        this.villageSiege.tick();
        this.theProfiler.endStartSection("portalForcer");
        this.worldTeleporter.removeStalePortalLocations(this.getTotalWorldTime());
        this.theProfiler.endSection();
        this.func_147488_Z();
    }
    
    private void resetRainAndThunder() {
        this.worldInfo.setRainTime(0);
        this.worldInfo.setRaining(false);
        this.worldInfo.setThunderTime(0);
        this.worldInfo.setThundering(false);
    }
    
    private void createSpawnPosition(final WorldSettings llllllllllllllIlIlIlIllIIlllllll) {
        if (!this.provider.canRespawnHere()) {
            this.worldInfo.setSpawn(BlockPos.ORIGIN.offsetUp(this.provider.getAverageGroundLevel()));
        }
        else if (this.worldInfo.getTerrainType() == WorldType.DEBUG_WORLD) {
            this.worldInfo.setSpawn(BlockPos.ORIGIN.offsetUp());
        }
        else {
            this.findingSpawnPoint = true;
            final WorldChunkManager llllllllllllllIlIlIlIllIIllllllI = this.provider.getWorldChunkManager();
            final List llllllllllllllIlIlIlIllIIlllllIl = llllllllllllllIlIlIlIllIIllllllI.getBiomesToSpawnIn();
            final Random llllllllllllllIlIlIlIllIIlllllII = new Random(this.getSeed());
            final BlockPos llllllllllllllIlIlIlIllIIllllIll = llllllllllllllIlIlIlIllIIllllllI.findBiomePosition(0, 0, 256, llllllllllllllIlIlIlIllIIlllllIl, llllllllllllllIlIlIlIllIIlllllII);
            int llllllllllllllIlIlIlIllIIllllIlI = 0;
            final int llllllllllllllIlIlIlIllIIllllIIl = this.provider.getAverageGroundLevel();
            int llllllllllllllIlIlIlIllIIllllIII = 0;
            if (llllllllllllllIlIlIlIllIIllllIll != null) {
                llllllllllllllIlIlIlIllIIllllIlI = llllllllllllllIlIlIlIllIIllllIll.getX();
                llllllllllllllIlIlIlIllIIllllIII = llllllllllllllIlIlIlIllIIllllIll.getZ();
            }
            else {
                WorldServer.logger.warn("Unable to find spawn biome");
            }
            int llllllllllllllIlIlIlIllIIlllIlll = 0;
            while (!this.provider.canCoordinateBeSpawn(llllllllllllllIlIlIlIllIIllllIlI, llllllllllllllIlIlIlIllIIllllIII)) {
                llllllllllllllIlIlIlIllIIllllIlI += llllllllllllllIlIlIlIllIIlllllII.nextInt(64) - llllllllllllllIlIlIlIllIIlllllII.nextInt(64);
                llllllllllllllIlIlIlIllIIllllIII += llllllllllllllIlIlIlIllIIlllllII.nextInt(64) - llllllllllllllIlIlIlIllIIlllllII.nextInt(64);
                if (++llllllllllllllIlIlIlIllIIlllIlll == 1000) {
                    break;
                }
            }
            this.worldInfo.setSpawn(new BlockPos(llllllllllllllIlIlIlIllIIllllIlI, llllllllllllllIlIlIlIllIIllllIIl, llllllllllllllIlIlIlIllIIllllIII));
            this.findingSpawnPoint = false;
            if (llllllllllllllIlIlIlIllIIlllllll.isBonusChestEnabled()) {
                this.createBonusChest();
            }
        }
    }
    
    public List func_147486_a(final int llllllllllllllIlIlIlIllIllllIlII, final int llllllllllllllIlIlIlIllIllllIIlI, final int llllllllllllllIlIlIlIllIllllIIII, final int llllllllllllllIlIlIlIllIllllllIl, final int llllllllllllllIlIlIlIllIllllllII, final int llllllllllllllIlIlIlIllIlllllIll) {
        final ArrayList llllllllllllllIlIlIlIllIlllllIlI = Lists.newArrayList();
        for (int llllllllllllllIlIlIlIllIlllllIIl = 0; llllllllllllllIlIlIlIllIlllllIIl < this.loadedTileEntityList.size(); ++llllllllllllllIlIlIlIllIlllllIIl) {
            final TileEntity llllllllllllllIlIlIlIllIlllllIII = this.loadedTileEntityList.get(llllllllllllllIlIlIlIllIlllllIIl);
            final BlockPos llllllllllllllIlIlIlIllIllllIllI = llllllllllllllIlIlIlIllIlllllIII.getPos();
            if (llllllllllllllIlIlIlIllIllllIllI.getX() >= llllllllllllllIlIlIlIllIllllIlII && llllllllllllllIlIlIlIllIllllIllI.getY() >= llllllllllllllIlIlIlIllIllllIIlI && llllllllllllllIlIlIlIllIllllIllI.getZ() >= llllllllllllllIlIlIlIllIllllIIII && llllllllllllllIlIlIlIllIllllIllI.getX() < llllllllllllllIlIlIlIllIllllllIl && llllllllllllllIlIlIlIllIllllIllI.getY() < llllllllllllllIlIlIlIllIllllllII && llllllllllllllIlIlIlIllIllllIllI.getZ() < llllllllllllllIlIlIlIllIlllllIll) {
                llllllllllllllIlIlIlIllIlllllIlI.add(llllllllllllllIlIlIlIllIlllllIII);
            }
        }
        return llllllllllllllIlIlIlIllIlllllIlI;
    }
    
    @Override
    public void func_180497_b(final BlockPos llllllllllllllIlIlIlIlllllIllllI, final Block llllllllllllllIlIlIlIllllllIIIll, final int llllllllllllllIlIlIlIlllllIlllII, final int llllllllllllllIlIlIlIlllllIllIll) {
        final NextTickListEntry llllllllllllllIlIlIlIllllllIIIII = new NextTickListEntry(llllllllllllllIlIlIlIlllllIllllI, llllllllllllllIlIlIlIllllllIIIll);
        llllllllllllllIlIlIlIllllllIIIII.setPriority(llllllllllllllIlIlIlIlllllIllIll);
        if (llllllllllllllIlIlIlIllllllIIIll.getMaterial() != Material.air) {
            llllllllllllllIlIlIlIllllllIIIII.setScheduledTime(llllllllllllllIlIlIlIlllllIlllII + this.worldInfo.getWorldTotalTime());
        }
        if (!this.pendingTickListEntriesHashSet.contains(llllllllllllllIlIlIlIllllllIIIII)) {
            this.pendingTickListEntriesHashSet.add(llllllllllllllIlIlIlIllllllIIIII);
            this.pendingTickListEntriesTreeSet.add(llllllllllllllIlIlIlIllllllIIIII);
        }
    }
    
    @Override
    public void updateEntities() {
        if (this.playerEntities.isEmpty()) {
            if (this.updateEntityTick++ >= 1200) {
                return;
            }
        }
        else {
            this.resetUpdateEntityTick();
        }
        super.updateEntities();
    }
    
    @Override
    public void addBlockEvent(final BlockPos llllllllllllllIlIlIlIlIlIllIIllI, final Block llllllllllllllIlIlIlIlIlIllIllll, final int llllllllllllllIlIlIlIlIlIllIIlII, final int llllllllllllllIlIlIlIlIlIllIlIll) {
        final BlockEventData llllllllllllllIlIlIlIlIlIllIlIlI = new BlockEventData(llllllllllllllIlIlIlIlIlIllIIllI, llllllllllllllIlIlIlIlIlIllIllll, llllllllllllllIlIlIlIlIlIllIIlII, llllllllllllllIlIlIlIlIlIllIlIll);
        for (final BlockEventData llllllllllllllIlIlIlIlIlIllIlIII : this.field_147490_S[this.blockEventCacheIndex]) {
            if (llllllllllllllIlIlIlIlIlIllIlIII.equals(llllllllllllllIlIlIlIlIlIllIlIlI)) {
                return;
            }
        }
        this.field_147490_S[this.blockEventCacheIndex].add(llllllllllllllIlIlIlIlIlIllIlIlI);
    }
    
    @Override
    public void setEntityState(final Entity llllllllllllllIlIlIlIlIllllIlIll, final byte llllllllllllllIlIlIlIlIlllIIIIII) {
        this.getEntityTracker().func_151248_b(llllllllllllllIlIlIlIlIllllIlIll, new S19PacketEntityStatus(llllllllllllllIlIlIlIlIllllIlIll, llllllllllllllIlIlIlIlIlllIIIIII));
    }
    
    public Teleporter getDefaultTeleporter() {
        return this.worldTeleporter;
    }
    
    public void func_175739_a(final EnumParticleTypes llllllllllllllIlIlIlIlIIlllllIIl, final double llllllllllllllIlIlIlIlIIlllIlIlI, final double llllllllllllllIlIlIlIlIIllllIlIl, final double llllllllllllllIlIlIlIlIIllllIlII, final int llllllllllllllIlIlIlIlIIlllIIlll, final double llllllllllllllIlIlIlIlIIlllIIllI, final double llllllllllllllIlIlIlIlIIllllIIIl, final double llllllllllllllIlIlIlIlIIllllIIII, final double llllllllllllllIlIlIlIlIIlllIllll, final int... llllllllllllllIlIlIlIlIIlllIlllI) {
        this.func_180505_a(llllllllllllllIlIlIlIlIIlllllIIl, false, llllllllllllllIlIlIlIlIIlllIlIlI, llllllllllllllIlIlIlIlIIllllIlIl, llllllllllllllIlIlIlIlIIllllIlII, llllllllllllllIlIlIlIlIIlllIIlll, llllllllllllllIlIlIlIlIIlllIIllI, llllllllllllllIlIlIlIlIIllllIIIl, llllllllllllllIlIlIlIlIIllllIIII, llllllllllllllIlIlIlIlIIlllIllll, llllllllllllllIlIlIlIlIIlllIlllI);
    }
    
    public void resetUpdateEntityTick() {
        this.updateEntityTick = 0;
    }
    
    private void func_147488_Z() {
        while (!this.field_147490_S[this.blockEventCacheIndex].isEmpty()) {
            final int llllllllllllllIlIlIlIlIlIlIIllII = this.blockEventCacheIndex;
            this.blockEventCacheIndex ^= 0x1;
            for (final BlockEventData llllllllllllllIlIlIlIlIlIlIIlIlI : this.field_147490_S[llllllllllllllIlIlIlIlIlIlIIllII]) {
                if (this.func_147485_a(llllllllllllllIlIlIlIlIlIlIIlIlI)) {
                    this.mcServer.getConfigurationManager().sendToAllNear(llllllllllllllIlIlIlIlIlIlIIlIlI.func_180328_a().getX(), llllllllllllllIlIlIlIlIlIlIIlIlI.func_180328_a().getY(), llllllllllllllIlIlIlIlIlIlIIlIlI.func_180328_a().getZ(), 64.0, this.provider.getDimensionId(), new S24PacketBlockAction(llllllllllllllIlIlIlIlIlIlIIlIlI.func_180328_a(), llllllllllllllIlIlIlIlIlIlIIlIlI.getBlock(), llllllllllllllIlIlIlIlIlIlIIlIlI.getEventID(), llllllllllllllIlIlIlIlIlIlIIlIlI.getEventParameter()));
                }
            }
            this.field_147490_S[llllllllllllllIlIlIlIlIlIlIIllII].clear();
        }
    }
    
    protected void wakeAllPlayers() {
        this.allPlayersSleeping = false;
        for (final EntityPlayer llllllllllllllIlIlIllIIIlIIIlllI : this.playerEntities) {
            if (llllllllllllllIlIlIllIIIlIIIlllI.isPlayerSleeping()) {
                llllllllllllllIlIlIllIIIlIIIlllI.wakeUpPlayer(false, false, true);
            }
        }
        this.resetRainAndThunder();
    }
    
    private void setDebugWorldSettings() {
        this.worldInfo.setMapFeaturesEnabled(false);
        this.worldInfo.setAllowCommands(true);
        this.worldInfo.setRaining(false);
        this.worldInfo.setThundering(false);
        this.worldInfo.func_176142_i(1000000000);
        this.worldInfo.setWorldTime(6000L);
        this.worldInfo.setGameType(WorldSettings.GameType.SPECTATOR);
        this.worldInfo.setHardcore(false);
        this.worldInfo.setDifficulty(EnumDifficulty.PEACEFUL);
        this.worldInfo.setDifficultyLocked(true);
        this.getGameRules().setOrCreateGameRule("doDaylightCycle", "false");
    }
    
    @Override
    public void scheduleUpdate(final BlockPos llllllllllllllIlIlIllIIIIIIIlIlI, final Block llllllllllllllIlIlIllIIIIIIIlIIl, final int llllllllllllllIlIlIllIIIIIIIlIII) {
        this.func_175654_a(llllllllllllllIlIlIllIIIIIIIlIlI, llllllllllllllIlIlIllIIIIIIIlIIl, llllllllllllllIlIlIllIIIIIIIlIII, 0);
    }
    
    @Override
    public void func_175654_a(final BlockPos llllllllllllllIlIlIlIlllllllIIlI, final Block llllllllllllllIlIlIlIllllllllIIl, int llllllllllllllIlIlIlIlllllllIIII, final int llllllllllllllIlIlIlIlllllllIlll) {
        final NextTickListEntry llllllllllllllIlIlIlIlllllllIllI = new NextTickListEntry(llllllllllllllIlIlIlIlllllllIIlI, llllllllllllllIlIlIlIllllllllIIl);
        byte llllllllllllllIlIlIlIlllllllIlIl = 0;
        if (this.scheduledUpdatesAreImmediate && llllllllllllllIlIlIlIllllllllIIl.getMaterial() != Material.air) {
            if (llllllllllllllIlIlIlIllllllllIIl.requiresUpdates()) {
                llllllllllllllIlIlIlIlllllllIlIl = 8;
                if (this.isAreaLoaded(llllllllllllllIlIlIlIlllllllIllI.field_180282_a.add(-llllllllllllllIlIlIlIlllllllIlIl, -llllllllllllllIlIlIlIlllllllIlIl, -llllllllllllllIlIlIlIlllllllIlIl), llllllllllllllIlIlIlIlllllllIllI.field_180282_a.add(llllllllllllllIlIlIlIlllllllIlIl, llllllllllllllIlIlIlIlllllllIlIl, llllllllllllllIlIlIlIlllllllIlIl))) {
                    final IBlockState llllllllllllllIlIlIlIlllllllIlII = this.getBlockState(llllllllllllllIlIlIlIlllllllIllI.field_180282_a);
                    if (llllllllllllllIlIlIlIlllllllIlII.getBlock().getMaterial() != Material.air && llllllllllllllIlIlIlIlllllllIlII.getBlock() == llllllllllllllIlIlIlIlllllllIllI.func_151351_a()) {
                        llllllllllllllIlIlIlIlllllllIlII.getBlock().updateTick(this, llllllllllllllIlIlIlIlllllllIllI.field_180282_a, llllllllllllllIlIlIlIlllllllIlII, this.rand);
                    }
                }
                return;
            }
            llllllllllllllIlIlIlIlllllllIIII = 1;
        }
        if (this.isAreaLoaded(llllllllllllllIlIlIlIlllllllIIlI.add(-llllllllllllllIlIlIlIlllllllIlIl, -llllllllllllllIlIlIlIlllllllIlIl, -llllllllllllllIlIlIlIlllllllIlIl), llllllllllllllIlIlIlIlllllllIIlI.add(llllllllllllllIlIlIlIlllllllIlIl, llllllllllllllIlIlIlIlllllllIlIl, llllllllllllllIlIlIlIlllllllIlIl))) {
            if (llllllllllllllIlIlIlIllllllllIIl.getMaterial() != Material.air) {
                llllllllllllllIlIlIlIlllllllIllI.setScheduledTime(llllllllllllllIlIlIlIlllllllIIII + this.worldInfo.getWorldTotalTime());
                llllllllllllllIlIlIlIlllllllIllI.setPriority(llllllllllllllIlIlIlIlllllllIlll);
            }
            if (!this.pendingTickListEntriesHashSet.contains(llllllllllllllIlIlIlIlllllllIllI)) {
                this.pendingTickListEntriesHashSet.add(llllllllllllllIlIlIlIlllllllIllI);
                this.pendingTickListEntriesTreeSet.add(llllllllllllllIlIlIlIlllllllIllI);
            }
        }
    }
    
    static class ServerBlockEventList extends ArrayList
    {
        static {
            __OBFID = "CL_00001439";
        }
        
        private ServerBlockEventList() {
        }
        
        ServerBlockEventList(final Object llllllllllllllllllIlIIllIIlIIlII) {
            this();
        }
    }
}
