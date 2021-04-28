package net.minecraft.client.multiplayer;

import net.minecraft.client.network.*;
import net.minecraft.client.*;
import net.minecraft.crash.*;
import java.util.concurrent.*;
import net.minecraft.profiler.*;
import net.minecraft.world.*;
import com.google.common.collect.*;
import net.minecraft.world.storage.*;
import net.minecraft.scoreboard.*;
import java.util.*;
import net.minecraft.block.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.block.state.*;
import net.minecraft.world.chunk.*;
import net.minecraft.entity.*;
import net.minecraft.entity.item.*;
import net.minecraft.util.*;
import net.minecraft.client.audio.*;
import optifine.*;
import net.minecraft.nbt.*;
import net.minecraft.client.particle.*;

public class WorldClient extends World
{
    private /* synthetic */ NetHandlerPlayClient sendQueue;
    private /* synthetic */ ChunkProviderClient clientChunkProvider;
    private final /* synthetic */ Set previousActiveChunkSet;
    private /* synthetic */ boolean playerUpdate;
    private final /* synthetic */ Set entityList;
    private final /* synthetic */ Minecraft mc;
    private /* synthetic */ BlockPosM randomTickPosM;
    private final /* synthetic */ Set entitySpawnQueue;
    
    @Override
    protected void func_147456_g() {
        super.func_147456_g();
        this.previousActiveChunkSet.retainAll(this.activeChunkSet);
        if (this.previousActiveChunkSet.size() == this.activeChunkSet.size()) {
            this.previousActiveChunkSet.clear();
        }
        int llllllllllllllIlllIIlllllIlIIlll = 0;
        for (final ChunkCoordIntPair llllllllllllllIlllIIlllllIlIIlIl : this.activeChunkSet) {
            if (!this.previousActiveChunkSet.contains(llllllllllllllIlllIIlllllIlIIlIl)) {
                final int llllllllllllllIlllIIlllllIlIIlII = llllllllllllllIlllIIlllllIlIIlIl.chunkXPos * 16;
                final int llllllllllllllIlllIIlllllIlIIIll = llllllllllllllIlllIIlllllIlIIlIl.chunkZPos * 16;
                this.theProfiler.startSection("getChunk");
                final Chunk llllllllllllllIlllIIlllllIlIIIlI = this.getChunkFromChunkCoords(llllllllllllllIlllIIlllllIlIIlIl.chunkXPos, llllllllllllllIlllIIlllllIlIIlIl.chunkZPos);
                this.func_147467_a(llllllllllllllIlllIIlllllIlIIlII, llllllllllllllIlllIIlllllIlIIIll, llllllllllllllIlllIIlllllIlIIIlI);
                this.theProfiler.endSection();
                this.previousActiveChunkSet.add(llllllllllllllIlllIIlllllIlIIlIl);
                if (++llllllllllllllIlllIIlllllIlIIlll >= 10) {
                    return;
                }
                continue;
            }
        }
    }
    
    @Override
    public CrashReportCategory addWorldInfoToCrashReport(final CrashReport llllllllllllllIlllIIlllIllllllII) {
        final CrashReportCategory llllllllllllllIlllIIlllIlllllIll = super.addWorldInfoToCrashReport(llllllllllllllIlllIIlllIllllllII);
        llllllllllllllIlllIIlllIlllllIll.addCrashSectionCallable("Forced entities", new Callable() {
            static {
                __OBFID = "CL_00000883";
            }
            
            @Override
            public String call() {
                return String.valueOf(new StringBuilder(String.valueOf(WorldClient.this.entityList.size())).append(" total; ").append(WorldClient.this.entityList.toString()));
            }
        });
        llllllllllllllIlllIIlllIlllllIll.addCrashSectionCallable("Retry entities", new Callable() {
            @Override
            public String call() {
                return String.valueOf(new StringBuilder(String.valueOf(WorldClient.this.entitySpawnQueue.size())).append(" total; ").append(WorldClient.this.entitySpawnQueue.toString()));
            }
            
            static {
                __OBFID = "CL_00000884";
            }
        });
        llllllllllllllIlllIIlllIlllllIll.addCrashSectionCallable("Server brand", new Callable() {
            @Override
            public String call() {
                return WorldClient.this.mc.thePlayer.getClientBrand();
            }
            
            static {
                __OBFID = "CL_00000885";
            }
        });
        llllllllllllllIlllIIlllIlllllIll.addCrashSectionCallable("Server type", new Callable() {
            @Override
            public String call() {
                return (WorldClient.this.mc.getIntegratedServer() == null) ? "Non-integrated multiplayer server" : "Integrated singleplayer server";
            }
            
            static {
                __OBFID = "CL_00000886";
            }
        });
        return llllllllllllllIlllIIlllIlllllIll;
    }
    
    public WorldClient(final NetHandlerPlayClient llllllllllllllIlllIIllllllIIllIl, final WorldSettings llllllllllllllIlllIIllllllIIIllI, final int llllllllllllllIlllIIllllllIIIlIl, final EnumDifficulty llllllllllllllIlllIIllllllIIlIlI, final Profiler llllllllllllllIlllIIllllllIIlIIl) {
        super(new SaveHandlerMP(), new WorldInfo(llllllllllllllIlllIIllllllIIIllI, "MpServer"), WorldProvider.getProviderForDimension(llllllllllllllIlllIIllllllIIIlIl), llllllllllllllIlllIIllllllIIlIIl, true);
        this.entityList = Sets.newHashSet();
        this.entitySpawnQueue = Sets.newHashSet();
        this.mc = Minecraft.getMinecraft();
        this.previousActiveChunkSet = Sets.newHashSet();
        this.randomTickPosM = new BlockPosM(0, 0, 0, 3);
        this.playerUpdate = false;
        this.sendQueue = llllllllllllllIlllIIllllllIIllIl;
        this.getWorldInfo().setDifficulty(llllllllllllllIlllIIllllllIIlIlI);
        this.provider.registerWorld(this);
        this.setSpawnLocation(new BlockPos(8, 64, 8));
        this.chunkProvider = this.createChunkProvider();
        this.mapStorage = new SaveDataMemoryStorage();
        this.calculateInitialSkylight();
        this.calculateInitialWeather();
        Reflector.postForgeBusEvent(Reflector.WorldEvent_Load_Constructor, this);
        if (this.mc.playerController != null && this.mc.playerController.getClass() == PlayerControllerMP.class) {
            this.mc.playerController = new PlayerControllerOF(this.mc, llllllllllllllIlllIIllllllIIllIl);
        }
    }
    
    public void setWorldScoreboard(final Scoreboard llllllllllllllIlllIIlllIlIlIIlll) {
        this.worldScoreboard = llllllllllllllIlllIIlllIlIlIIlll;
    }
    
    public void doVoidFogParticles(final int llllllllllllllIlllIIllllIIlIllIl, final int llllllllllllllIlllIIllllIIlIllII, final int llllllllllllllIlllIIllllIIlIlIll) {
        final byte llllllllllllllIlllIIllllIIlIlIlI = 16;
        final Random llllllllllllllIlllIIllllIIlIlIIl = new Random();
        final ItemStack llllllllllllllIlllIIllllIIlIlIII = this.mc.thePlayer.getHeldItem();
        final boolean llllllllllllllIlllIIllllIIlIIlll = this.mc.playerController.func_178889_l() == WorldSettings.GameType.CREATIVE && llllllllllllllIlllIIllllIIlIlIII != null && Block.getBlockFromItem(llllllllllllllIlllIIllllIIlIlIII.getItem()) == Blocks.barrier;
        final BlockPosM llllllllllllllIlllIIllllIIlIIllI = this.randomTickPosM;
        for (int llllllllllllllIlllIIllllIIlIIlIl = 0; llllllllllllllIlllIIllllIIlIIlIl < 1000; ++llllllllllllllIlllIIllllIIlIIlIl) {
            final int llllllllllllllIlllIIllllIIlIIlII = llllllllllllllIlllIIllllIIlIllIl + this.rand.nextInt(llllllllllllllIlllIIllllIIlIlIlI) - this.rand.nextInt(llllllllllllllIlllIIllllIIlIlIlI);
            final int llllllllllllllIlllIIllllIIlIIIll = llllllllllllllIlllIIllllIIlIllII + this.rand.nextInt(llllllllllllllIlllIIllllIIlIlIlI) - this.rand.nextInt(llllllllllllllIlllIIllllIIlIlIlI);
            final int llllllllllllllIlllIIllllIIlIIIlI = llllllllllllllIlllIIllllIIlIlIll + this.rand.nextInt(llllllllllllllIlllIIllllIIlIlIlI) - this.rand.nextInt(llllllllllllllIlllIIllllIIlIlIlI);
            llllllllllllllIlllIIllllIIlIIllI.setXyz(llllllllllllllIlllIIllllIIlIIlII, llllllllllllllIlllIIllllIIlIIIll, llllllllllllllIlllIIllllIIlIIIlI);
            final IBlockState llllllllllllllIlllIIllllIIlIIIIl = this.getBlockState(llllllllllllllIlllIIllllIIlIIllI);
            llllllllllllllIlllIIllllIIlIIIIl.getBlock().randomDisplayTick(this, llllllllllllllIlllIIllllIIlIIllI, llllllllllllllIlllIIllllIIlIIIIl, llllllllllllllIlllIIllllIIlIlIIl);
            if (llllllllllllllIlllIIllllIIlIIlll && llllllllllllllIlllIIllllIIlIIIIl.getBlock() == Blocks.barrier) {
                this.spawnParticle(EnumParticleTypes.BARRIER, llllllllllllllIlllIIllllIIlIIlII + 0.5f, llllllllllllllIlllIIllllIIlIIIll + 0.5f, llllllllllllllIlllIIllllIIlIIIlI + 0.5f, 0.0, 0.0, 0.0, new int[0]);
            }
        }
    }
    
    @Override
    protected void updateWeather() {
    }
    
    @Override
    protected IChunkProvider createChunkProvider() {
        this.clientChunkProvider = new ChunkProviderClient(this);
        return this.clientChunkProvider;
    }
    
    public void doPreChunk(final int llllllllllllllIlllIIlllllIIlIlIl, final int llllllllllllllIlllIIlllllIIlIIII, final boolean llllllllllllllIlllIIlllllIIlIIll) {
        if (llllllllllllllIlllIIlllllIIlIIll) {
            this.clientChunkProvider.loadChunk(llllllllllllllIlllIIlllllIIlIlIl, llllllllllllllIlllIIlllllIIlIIII);
        }
        else {
            this.clientChunkProvider.unloadChunk(llllllllllllllIlllIIlllllIIlIlIl, llllllllllllllIlllIIlllllIIlIIII);
        }
        if (!llllllllllllllIlllIIlllllIIlIIll) {
            this.markBlockRangeForRenderUpdate(llllllllllllllIlllIIlllllIIlIlIl * 16, 0, llllllllllllllIlllIIlllllIIlIIII * 16, llllllllllllllIlllIIlllllIIlIlIl * 16 + 15, 256, llllllllllllllIlllIIlllllIIlIIII * 16 + 15);
        }
    }
    
    public Entity removeEntityFromWorld(final int llllllllllllllIlllIIllllIlIlIlll) {
        final Entity llllllllllllllIlllIIllllIlIllIIl = (Entity)this.entitiesById.removeObject(llllllllllllllIlllIIllllIlIlIlll);
        if (llllllllllllllIlllIIllllIlIllIIl != null) {
            this.entityList.remove(llllllllllllllIlllIIllllIlIllIIl);
            this.removeEntity(llllllllllllllIlllIIllllIlIllIIl);
        }
        return llllllllllllllIlllIIllllIlIllIIl;
    }
    
    @Override
    public void sendQuittingDisconnectingPacket() {
        this.sendQueue.getNetworkManager().closeChannel(new ChatComponentText("Quitting"));
    }
    
    public void removeAllEntities() {
        this.loadedEntityList.removeAll(this.unloadedEntityList);
        for (int llllllllllllllIlllIIllllIIIIllII = 0; llllllllllllllIlllIIllllIIIIllII < this.unloadedEntityList.size(); ++llllllllllllllIlllIIllllIIIIllII) {
            final Entity llllllllllllllIlllIIllllIIIIlIll = this.unloadedEntityList.get(llllllllllllllIlllIIllllIIIIllII);
            final int llllllllllllllIlllIIllllIIIIlIIl = llllllllllllllIlllIIllllIIIIlIll.chunkCoordX;
            final int llllllllllllllIlllIIllllIIIIIlll = llllllllllllllIlllIIllllIIIIlIll.chunkCoordZ;
            if (llllllllllllllIlllIIllllIIIIlIll.addedToChunk && this.isChunkLoaded(llllllllllllllIlllIIllllIIIIlIIl, llllllllllllllIlllIIllllIIIIIlll, true)) {
                this.getChunkFromChunkCoords(llllllllllllllIlllIIllllIIIIlIIl, llllllllllllllIlllIIllllIIIIIlll).removeEntity(llllllllllllllIlllIIllllIIIIlIll);
            }
        }
        for (int llllllllllllllIlllIIllllIIIIllII = 0; llllllllllllllIlllIIllllIIIIllII < this.unloadedEntityList.size(); ++llllllllllllllIlllIIllllIIIIllII) {
            this.onEntityRemoved(this.unloadedEntityList.get(llllllllllllllIlllIIllllIIIIllII));
        }
        this.unloadedEntityList.clear();
        for (int llllllllllllllIlllIIllllIIIIllII = 0; llllllllllllllIlllIIllllIIIIllII < this.loadedEntityList.size(); ++llllllllllllllIlllIIllllIIIIllII) {
            final Entity llllllllllllllIlllIIllllIIIIlIlI = this.loadedEntityList.get(llllllllllllllIlllIIllllIIIIllII);
            if (llllllllllllllIlllIIllllIIIIlIlI.ridingEntity != null) {
                if (!llllllllllllllIlllIIllllIIIIlIlI.ridingEntity.isDead && llllllllllllllIlllIIllllIIIIlIlI.ridingEntity.riddenByEntity == llllllllllllllIlllIIllllIIIIlIlI) {
                    continue;
                }
                llllllllllllllIlllIIllllIIIIlIlI.ridingEntity.riddenByEntity = null;
                llllllllllllllIlllIIllllIIIIlIlI.ridingEntity = null;
            }
            if (llllllllllllllIlllIIllllIIIIlIlI.isDead) {
                final int llllllllllllllIlllIIllllIIIIlIII = llllllllllllllIlllIIllllIIIIlIlI.chunkCoordX;
                final int llllllllllllllIlllIIllllIIIIIllI = llllllllllllllIlllIIllllIIIIlIlI.chunkCoordZ;
                if (llllllllllllllIlllIIllllIIIIlIlI.addedToChunk && this.isChunkLoaded(llllllllllllllIlllIIllllIIIIlIII, llllllllllllllIlllIIllllIIIIIllI, true)) {
                    this.getChunkFromChunkCoords(llllllllllllllIlllIIllllIIIIlIII, llllllllllllllIlllIIllllIIIIIllI).removeEntity(llllllllllllllIlllIIllllIIIIlIlI);
                }
                this.loadedEntityList.remove(llllllllllllllIlllIIllllIIIIllII--);
                this.onEntityRemoved(llllllllllllllIlllIIllllIIIIlIlI);
            }
        }
    }
    
    @Override
    public Entity getEntityByID(final int llllllllllllllIlllIIllllIllIIIIl) {
        return (llllllllllllllIlllIIllllIllIIIIl == this.mc.thePlayer.getEntityId()) ? this.mc.thePlayer : super.getEntityByID(llllllllllllllIlllIIllllIllIIIIl);
    }
    
    @Override
    public void setWorldTime(long llllllllllllllIlllIIlllIlIlIIIIl) {
        if (llllllllllllllIlllIIlllIlIlIIIIl < 0L) {
            llllllllllllllIlllIIlllIlIlIIIIl = -llllllllllllllIlllIIlllIlIlIIIIl;
            this.getGameRules().setOrCreateGameRule("doDaylightCycle", "false");
        }
        else {
            this.getGameRules().setOrCreateGameRule("doDaylightCycle", "true");
        }
        super.setWorldTime((long)llllllllllllllIlllIIlllIlIlIIIIl);
    }
    
    @Override
    public boolean spawnEntityInWorld(final Entity llllllllllllllIlllIIlllllIIIIlll) {
        final boolean llllllllllllllIlllIIlllllIIIlIIl = super.spawnEntityInWorld(llllllllllllllIlllIIlllllIIIIlll);
        this.entityList.add(llllllllllllllIlllIIlllllIIIIlll);
        if (!llllllllllllllIlllIIlllllIIIlIIl) {
            this.entitySpawnQueue.add(llllllllllllllIlllIIlllllIIIIlll);
        }
        else if (llllllllllllllIlllIIlllllIIIIlll instanceof EntityMinecart) {
            this.mc.getSoundHandler().playSound(new MovingSoundMinecart((EntityMinecart)llllllllllllllIlllIIlllllIIIIlll));
        }
        return llllllllllllllIlllIIlllllIIIlIIl;
    }
    
    @Override
    public void playSound(final double llllllllllllllIlllIIlllIllIIlllI, final double llllllllllllllIlllIIlllIllIIllIl, final double llllllllllllllIlllIIlllIllIIllII, final String llllllllllllllIlllIIlllIllIIlIll, final float llllllllllllllIlllIIlllIllIlIlIl, final float llllllllllllllIlllIIlllIllIIlIIl, final boolean llllllllllllllIlllIIlllIllIlIIll) {
        final double llllllllllllllIlllIIlllIllIlIIlI = this.mc.func_175606_aa().getDistanceSq(llllllllllllllIlllIIlllIllIIlllI, llllllllllllllIlllIIlllIllIIllIl, llllllllllllllIlllIIlllIllIIllII);
        final PositionedSoundRecord llllllllllllllIlllIIlllIllIlIIIl = new PositionedSoundRecord(new ResourceLocation(llllllllllllllIlllIIlllIllIIlIll), llllllllllllllIlllIIlllIllIlIlIl, llllllllllllllIlllIIlllIllIIlIIl, (float)llllllllllllllIlllIIlllIllIIlllI, (float)llllllllllllllIlllIIlllIllIIllIl, (float)llllllllllllllIlllIIlllIllIIllII);
        if (llllllllllllllIlllIIlllIllIlIIll && llllllllllllllIlllIIlllIllIlIIlI > 100.0) {
            final double llllllllllllllIlllIIlllIllIlIIII = Math.sqrt(llllllllllllllIlllIIlllIllIlIIlI) / 40.0;
            this.mc.getSoundHandler().playDelayedSound(llllllllllllllIlllIIlllIllIlIIIl, (int)(llllllllllllllIlllIIlllIllIlIIII * 20.0));
        }
        else {
            this.mc.getSoundHandler().playSound(llllllllllllllIlllIIlllIllIlIIIl);
        }
    }
    
    @Override
    protected int getRenderDistanceChunks() {
        return this.mc.gameSettings.renderDistanceChunks;
    }
    
    public boolean isPlayerUpdate() {
        return this.playerUpdate;
    }
    
    @Override
    public int getCombinedLight(final BlockPos llllllllllllllIlllIIlllIlIIlIlll, final int llllllllllllllIlllIIlllIlIIllIlI) {
        int llllllllllllllIlllIIlllIlIIllIIl = super.getCombinedLight(llllllllllllllIlllIIlllIlIIlIlll, llllllllllllllIlllIIlllIlIIllIlI);
        if (Config.isDynamicLights()) {
            llllllllllllllIlllIIlllIlIIllIIl = DynamicLights.getCombinedLight(llllllllllllllIlllIIlllIlIIlIlll, llllllllllllllIlllIIlllIlIIllIIl);
        }
        return llllllllllllllIlllIIlllIlIIllIIl;
    }
    
    static {
        __OBFID = "CL_00000882";
    }
    
    public void invalidateBlockReceiveRegion(final int llllllllllllllIlllIIlllllIlllIII, final int llllllllllllllIlllIIlllllIllIlll, final int llllllllllllllIlllIIlllllIllIllI, final int llllllllllllllIlllIIlllllIllIlIl, final int llllllllllllllIlllIIlllllIllIlII, final int llllllllllllllIlllIIlllllIllIIll) {
    }
    
    @Override
    public void makeFireworks(final double llllllllllllllIlllIIlllIlIlllIll, final double llllllllllllllIlllIIlllIlIlllIlI, final double llllllllllllllIlllIIlllIlIllIIIl, final double llllllllllllllIlllIIlllIlIllIIII, final double llllllllllllllIlllIIlllIlIllIlll, final double llllllllllllllIlllIIlllIlIllIllI, final NBTTagCompound llllllllllllllIlllIIlllIlIlIllIl) {
        this.mc.effectRenderer.addEffect(new EntityFireworkStarterFX(this, llllllllllllllIlllIIlllIlIlllIll, llllllllllllllIlllIIlllIlIlllIlI, llllllllllllllIlllIIlllIlIllIIIl, llllllllllllllIlllIIlllIlIllIIII, llllllllllllllIlllIIlllIlIllIlll, llllllllllllllIlllIIlllIlIllIllI, this.mc.effectRenderer, llllllllllllllIlllIIlllIlIlIllIl));
    }
    
    public void addEntityToWorld(final int llllllllllllllIlllIIllllIllIIlll, final Entity llllllllllllllIlllIIllllIllIIllI) {
        final Entity llllllllllllllIlllIIllllIllIlIIl = this.getEntityByID(llllllllllllllIlllIIllllIllIIlll);
        if (llllllllllllllIlllIIllllIllIlIIl != null) {
            this.removeEntity(llllllllllllllIlllIIllllIllIlIIl);
        }
        this.entityList.add(llllllllllllllIlllIIllllIllIIllI);
        llllllllllllllIlllIIllllIllIIllI.setEntityId(llllllllllllllIlllIIllllIllIIlll);
        if (!this.spawnEntityInWorld(llllllllllllllIlllIIllllIllIIllI)) {
            this.entitySpawnQueue.add(llllllllllllllIlllIIllllIllIIllI);
        }
        this.entitiesById.addKey(llllllllllllllIlllIIllllIllIIlll, llllllllllllllIlllIIllllIllIIllI);
    }
    
    @Override
    public void removeEntity(final Entity llllllllllllllIlllIIlllllIIIIIII) {
        super.removeEntity(llllllllllllllIlllIIlllllIIIIIII);
        this.entityList.remove(llllllllllllllIlllIIlllllIIIIIII);
    }
    
    public boolean func_180503_b(final BlockPos llllllllllllllIlllIIllllIlIIlllI, final IBlockState llllllllllllllIlllIIllllIlIIllIl) {
        final int llllllllllllllIlllIIllllIlIIllII = llllllllllllllIlllIIllllIlIIlllI.getX();
        final int llllllllllllllIlllIIllllIlIIlIll = llllllllllllllIlllIIllllIlIIlllI.getY();
        final int llllllllllllllIlllIIllllIlIIlIlI = llllllllllllllIlllIIllllIlIIlllI.getZ();
        this.invalidateBlockReceiveRegion(llllllllllllllIlllIIllllIlIIllII, llllllllllllllIlllIIllllIlIIlIll, llllllllllllllIlllIIllllIlIIlIlI, llllllllllllllIlllIIllllIlIIllII, llllllllllllllIlllIIllllIlIIlIll, llllllllllllllIlllIIllllIlIIlIlI);
        return super.setBlockState(llllllllllllllIlllIIllllIlIIlllI, llllllllllllllIlllIIllllIlIIllIl, 3);
    }
    
    @Override
    public boolean setBlockState(final BlockPos llllllllllllllIlllIIlllIlIIIlllI, final IBlockState llllllllllllllIlllIIlllIlIIIllIl, final int llllllllllllllIlllIIlllIlIIIIlll) {
        this.playerUpdate = this.isPlayerActing();
        final boolean llllllllllllllIlllIIlllIlIIIlIll = super.setBlockState(llllllllllllllIlllIIlllIlIIIlllI, llllllllllllllIlllIIlllIlIIIllIl, llllllllllllllIlllIIlllIlIIIIlll);
        this.playerUpdate = false;
        return llllllllllllllIlllIIlllIlIIIlIll;
    }
    
    private boolean isPlayerActing() {
        if (this.mc.playerController instanceof PlayerControllerOF) {
            final PlayerControllerOF llllllllllllllIlllIIlllIlIIIIIlI = (PlayerControllerOF)this.mc.playerController;
            return llllllllllllllIlllIIlllIlIIIIIlI.isActing();
        }
        return false;
    }
    
    public void func_175731_a(final BlockPos llllllllllllllIlllIIlllIllllIIII, final String llllllllllllllIlllIIlllIlllIlIIl, final float llllllllllllllIlllIIlllIlllIlIII, final float llllllllllllllIlllIIlllIlllIIlll, final boolean llllllllllllllIlllIIlllIlllIIllI) {
        this.playSound(llllllllllllllIlllIIlllIllllIIII.getX() + 0.5, llllllllllllllIlllIIlllIllllIIII.getY() + 0.5, llllllllllllllIlllIIlllIllllIIII.getZ() + 0.5, llllllllllllllIlllIIlllIlllIlIIl, llllllllllllllIlllIIlllIlllIlIII, llllllllllllllIlllIIlllIlllIIlll, llllllllllllllIlllIIlllIlllIIllI);
    }
    
    @Override
    protected void onEntityAdded(final Entity llllllllllllllIlllIIllllIllllIlI) {
        super.onEntityAdded(llllllllllllllIlllIIllllIllllIlI);
        if (this.entitySpawnQueue.contains(llllllllllllllIlllIIllllIllllIlI)) {
            this.entitySpawnQueue.remove(llllllllllllllIlllIIllllIllllIlI);
        }
    }
    
    @Override
    protected void onEntityRemoved(final Entity llllllllllllllIlllIIllllIlllIIlI) {
        super.onEntityRemoved(llllllllllllllIlllIIllllIlllIIlI);
        boolean llllllllllllllIlllIIllllIlllIlII = false;
        if (this.entityList.contains(llllllllllllllIlllIIllllIlllIIlI)) {
            if (llllllllllllllIlllIIllllIlllIIlI.isEntityAlive()) {
                this.entitySpawnQueue.add(llllllllllllllIlllIIllllIlllIIlI);
                llllllllllllllIlllIIllllIlllIlII = true;
            }
            else {
                this.entityList.remove(llllllllllllllIlllIIllllIlllIIlI);
            }
        }
    }
    
    @Override
    public void tick() {
        super.tick();
        this.func_82738_a(this.getTotalWorldTime() + 1L);
        if (this.getGameRules().getGameRuleBooleanValue("doDaylightCycle")) {
            this.setWorldTime(this.getWorldTime() + 1L);
        }
        this.theProfiler.startSection("reEntryProcessing");
        for (int llllllllllllllIlllIIlllllIlllllI = 0; llllllllllllllIlllIIlllllIlllllI < 10 && !this.entitySpawnQueue.isEmpty(); ++llllllllllllllIlllIIlllllIlllllI) {
            final Entity llllllllllllllIlllIIlllllIllllIl = this.entitySpawnQueue.iterator().next();
            this.entitySpawnQueue.remove(llllllllllllllIlllIIlllllIllllIl);
            if (!this.loadedEntityList.contains(llllllllllllllIlllIIlllllIllllIl)) {
                this.spawnEntityInWorld(llllllllllllllIlllIIlllllIllllIl);
            }
        }
        this.theProfiler.endStartSection("chunkCache");
        this.clientChunkProvider.unloadQueuedChunks();
        this.theProfiler.endStartSection("blocks");
        this.func_147456_g();
        this.theProfiler.endSection();
    }
}
