package net.minecraft.world;

import net.minecraft.profiler.*;
import net.minecraft.world.border.*;
import net.minecraft.village.*;
import net.minecraft.scoreboard.*;
import net.minecraft.world.storage.*;
import net.minecraft.block.state.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import com.google.common.base.*;
import net.minecraft.world.chunk.*;
import net.minecraft.entity.player.*;
import net.minecraft.nbt.*;
import net.minecraft.tileentity.*;
import net.minecraft.server.gui.*;
import java.util.concurrent.*;
import net.minecraft.crash.*;
import com.google.common.collect.*;
import net.minecraft.command.*;
import net.minecraft.block.properties.*;
import net.minecraft.entity.*;
import net.minecraft.world.gen.structure.*;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.server.*;
import net.minecraft.world.biome.*;
import java.util.*;
import net.minecraft.util.*;

public abstract class World implements IBlockAccess
{
    public final /* synthetic */ Profiler theProfiler;
    public final /* synthetic */ List tickableTileEntities;
    private /* synthetic */ int skylightSubtracted;
    public final /* synthetic */ WorldProvider provider;
    protected final /* synthetic */ ISaveHandler saveHandler;
    protected /* synthetic */ MapStorage mapStorage;
    protected /* synthetic */ float prevThunderingStrength;
    private /* synthetic */ boolean processingLoadedTiles;
    protected /* synthetic */ boolean spawnPeacefulMobs;
    protected final /* synthetic */ List unloadedEntityList;
    private final /* synthetic */ WorldBorder worldBorder;
    public final /* synthetic */ Random rand;
    protected /* synthetic */ VillageCollection villageCollectionObj;
    protected /* synthetic */ boolean scheduledUpdatesAreImmediate;
    protected /* synthetic */ boolean spawnHostileMobs;
    protected /* synthetic */ Scoreboard worldScoreboard;
    protected /* synthetic */ Set activeChunkSet;
    protected /* synthetic */ List worldAccesses;
    protected final /* synthetic */ IntHashMap entitiesById;
    public final /* synthetic */ List loadedTileEntityList;
    private /* synthetic */ long cloudColour;
    public final /* synthetic */ boolean isRemote;
    protected /* synthetic */ IChunkProvider chunkProvider;
    protected /* synthetic */ WorldInfo worldInfo;
    private final /* synthetic */ List addedTileEntityList;
    private /* synthetic */ int lastLightningBolt;
    protected /* synthetic */ float prevRainingStrength;
    public final /* synthetic */ List loadedEntityList;
    protected /* synthetic */ boolean findingSpawnPoint;
    protected /* synthetic */ float rainingStrength;
    private /* synthetic */ int ambientTickCountdown;
    protected /* synthetic */ float thunderingStrength;
    /* synthetic */ int[] lightUpdateBlockList;
    public final /* synthetic */ List weatherEffects;
    protected /* synthetic */ int updateLCG;
    private final /* synthetic */ Calendar theCalendar;
    public final /* synthetic */ List playerEntities;
    private final /* synthetic */ List tileEntitiesToBeRemoved;
    
    @Override
    public int getStrongPower(final BlockPos llllllllllllllIIllIIllllIIIlIllI, final EnumFacing llllllllllllllIIllIIllllIIIllIIl) {
        final IBlockState llllllllllllllIIllIIllllIIIllIII = this.getBlockState(llllllllllllllIIllIIllllIIIlIllI);
        return llllllllllllllIIllIIllllIIIllIII.getBlock().isProvidingStrongPower(this, llllllllllllllIIllIIllllIIIlIllI, llllllllllllllIIllIIllllIIIllIII, llllllllllllllIIllIIllllIIIllIIl);
    }
    
    public Vec3 getFogColor(final float llllllllllllllIIllIlIIlllIllIIll) {
        final float llllllllllllllIIllIlIIlllIllIlIl = this.getCelestialAngle(llllllllllllllIIllIlIIlllIllIIll);
        return this.provider.getFogColor(llllllllllllllIIllIlIIlllIllIlIl, llllllllllllllIIllIlIIlllIllIIll);
    }
    
    public void tick() {
        this.updateWeather();
    }
    
    public void initialize(final WorldSettings llllllllllllllIIllIllIIIIIIlIlll) {
        this.worldInfo.setServerInitialized(true);
    }
    
    public boolean func_175708_f(final BlockPos llllllllllllllIIllIlIIIIlIlIIIll, final boolean llllllllllllllIIllIlIIIIlIIlllII) {
        final BiomeGenBase llllllllllllllIIllIlIIIIlIlIIIIl = this.getBiomeGenForCoords(llllllllllllllIIllIlIIIIlIlIIIll);
        final float llllllllllllllIIllIlIIIIlIlIIIII = llllllllllllllIIllIlIIIIlIlIIIIl.func_180626_a(llllllllllllllIIllIlIIIIlIlIIIll);
        if (llllllllllllllIIllIlIIIIlIlIIIII > 0.15f) {
            return false;
        }
        if (!llllllllllllllIIllIlIIIIlIIlllII) {
            return true;
        }
        if (llllllllllllllIIllIlIIIIlIlIIIll.getY() >= 0 && llllllllllllllIIllIlIIIIlIlIIIll.getY() < 256 && this.getLightFor(EnumSkyBlock.BLOCK, llllllllllllllIIllIlIIIIlIlIIIll) < 10) {
            final Block llllllllllllllIIllIlIIIIlIIlllll = this.getBlockState(llllllllllllllIIllIlIIIIlIlIIIll).getBlock();
            if (llllllllllllllIIllIlIIIIlIIlllll.getMaterial() == Material.air && Blocks.snow_layer.canPlaceBlockAt(this, llllllllllllllIIllIlIIIIlIlIIIll)) {
                return true;
            }
        }
        return false;
    }
    
    public MovingObjectPosition rayTraceBlocks(final Vec3 llllllllllllllIIllIlIllIIIlIIlIl, final Vec3 llllllllllllllIIllIlIllIIIlIIlII) {
        return this.rayTraceBlocks(llllllllllllllIIllIlIllIIIlIIlIl, llllllllllllllIIllIlIllIIIlIIlII, false, false, false);
    }
    
    public List func_175661_b(final Class llllllllllllllIIllIIlllllIlllllI, final Predicate llllllllllllllIIllIIlllllIllllIl) {
        final ArrayList llllllllllllllIIllIIlllllIllllII = Lists.newArrayList();
        for (final Entity llllllllllllllIIllIIlllllIlllIlI : this.playerEntities) {
            if (llllllllllllllIIllIIlllllIlllllI.isAssignableFrom(llllllllllllllIIllIIlllllIlllIlI.getClass()) && llllllllllllllIIllIIlllllIllllIl.apply((Object)llllllllllllllIIllIIlllllIlllIlI)) {
                llllllllllllllIIllIIlllllIllllII.add(llllllllllllllIIllIIlllllIlllIlI);
            }
        }
        return llllllllllllllIIllIIlllllIllllII;
    }
    
    public BlockPos getHorizon(final BlockPos llllllllllllllIIllIlIllIlIIllIlI) {
        int llllllllllllllIIllIlIllIlIIlIlll = 0;
        if (llllllllllllllIIllIlIllIlIIllIlI.getX() >= -30000000 && llllllllllllllIIllIlIllIlIIllIlI.getZ() >= -30000000 && llllllllllllllIIllIlIllIlIIllIlI.getX() < 30000000 && llllllllllllllIIllIlIllIlIIllIlI.getZ() < 30000000) {
            if (this.isChunkLoaded(llllllllllllllIIllIlIllIlIIllIlI.getX() >> 4, llllllllllllllIIllIlIllIlIIllIlI.getZ() >> 4, true)) {
                final int llllllllllllllIIllIlIllIlIIllIIl = this.getChunkFromChunkCoords(llllllllllllllIIllIlIllIlIIllIlI.getX() >> 4, llllllllllllllIIllIlIllIlIIllIlI.getZ() >> 4).getHeight(llllllllllllllIIllIlIllIlIIllIlI.getX() & 0xF, llllllllllllllIIllIlIllIlIIllIlI.getZ() & 0xF);
            }
            else {
                final int llllllllllllllIIllIlIllIlIIllIII = 0;
            }
        }
        else {
            llllllllllllllIIllIlIllIlIIlIlll = 64;
        }
        return new BlockPos(llllllllllllllIIllIlIllIlIIllIlI.getX(), llllllllllllllIIllIlIllIlIIlIlll, llllllllllllllIIllIlIllIlIIllIlI.getZ());
    }
    
    private int func_175638_a(final BlockPos llllllllllllllIIllIlIIIIlIIIIIlI, final EnumSkyBlock llllllllllllllIIllIlIIIIIlllIlIl) {
        if (llllllllllllllIIllIlIIIIIlllIlIl == EnumSkyBlock.SKY && this.isAgainstSky(llllllllllllllIIllIlIIIIlIIIIIlI)) {
            return 15;
        }
        final Block llllllllllllllIIllIlIIIIlIIIIIII = this.getBlockState(llllllllllllllIIllIlIIIIlIIIIIlI).getBlock();
        int llllllllllllllIIllIlIIIIIlllllll = (llllllllllllllIIllIlIIIIIlllIlIl == EnumSkyBlock.SKY) ? 0 : llllllllllllllIIllIlIIIIlIIIIIII.getLightValue();
        int llllllllllllllIIllIlIIIIIllllllI = llllllllllllllIIllIlIIIIlIIIIIII.getLightOpacity();
        if (llllllllllllllIIllIlIIIIIllllllI >= 15 && llllllllllllllIIllIlIIIIlIIIIIII.getLightValue() > 0) {
            llllllllllllllIIllIlIIIIIllllllI = 1;
        }
        if (llllllllllllllIIllIlIIIIIllllllI < 1) {
            llllllllllllllIIllIlIIIIIllllllI = 1;
        }
        if (llllllllllllllIIllIlIIIIIllllllI >= 15) {
            return 0;
        }
        if (llllllllllllllIIllIlIIIIIlllllll >= 14) {
            return llllllllllllllIIllIlIIIIIlllllll;
        }
        for (final EnumFacing llllllllllllllIIllIlIIIIIllllIlI : EnumFacing.values()) {
            final BlockPos llllllllllllllIIllIlIIIIIllllIIl = llllllllllllllIIllIlIIIIlIIIIIlI.offset(llllllllllllllIIllIlIIIIIllllIlI);
            final int llllllllllllllIIllIlIIIIIllllIII = this.getLightFor(llllllllllllllIIllIlIIIIIlllIlIl, llllllllllllllIIllIlIIIIIllllIIl) - llllllllllllllIIllIlIIIIIllllllI;
            if (llllllllllllllIIllIlIIIIIllllIII > llllllllllllllIIllIlIIIIIlllllll) {
                llllllllllllllIIllIlIIIIIlllllll = llllllllllllllIIllIlIIIIIllllIII;
            }
            if (llllllllllllllIIllIlIIIIIlllllll >= 14) {
                return llllllllllllllIIllIlIIIIIlllllll;
            }
        }
        return llllllllllllllIIllIlIIIIIlllllll;
    }
    
    public List func_147461_a(final AxisAlignedBB llllllllllllllIIllIlIlIIIlIlIIll) {
        final ArrayList llllllllllllllIIllIlIlIIIllIIIIl = Lists.newArrayList();
        final int llllllllllllllIIllIlIlIIIllIIIII = MathHelper.floor_double(llllllllllllllIIllIlIlIIIlIlIIll.minX);
        final int llllllllllllllIIllIlIlIIIlIlllll = MathHelper.floor_double(llllllllllllllIIllIlIlIIIlIlIIll.maxX + 1.0);
        final int llllllllllllllIIllIlIlIIIlIllllI = MathHelper.floor_double(llllllllllllllIIllIlIlIIIlIlIIll.minY);
        final int llllllllllllllIIllIlIlIIIlIlllIl = MathHelper.floor_double(llllllllllllllIIllIlIlIIIlIlIIll.maxY + 1.0);
        final int llllllllllllllIIllIlIlIIIlIlllII = MathHelper.floor_double(llllllllllllllIIllIlIlIIIlIlIIll.minZ);
        final int llllllllllllllIIllIlIlIIIlIllIll = MathHelper.floor_double(llllllllllllllIIllIlIlIIIlIlIIll.maxZ + 1.0);
        for (int llllllllllllllIIllIlIlIIIlIllIlI = llllllllllllllIIllIlIlIIIllIIIII; llllllllllllllIIllIlIlIIIlIllIlI < llllllllllllllIIllIlIlIIIlIlllll; ++llllllllllllllIIllIlIlIIIlIllIlI) {
            for (int llllllllllllllIIllIlIlIIIlIllIIl = llllllllllllllIIllIlIlIIIlIlllII; llllllllllllllIIllIlIlIIIlIllIIl < llllllllllllllIIllIlIlIIIlIllIll; ++llllllllllllllIIllIlIlIIIlIllIIl) {
                if (this.isBlockLoaded(new BlockPos(llllllllllllllIIllIlIlIIIlIllIlI, 64, llllllllllllllIIllIlIlIIIlIllIIl))) {
                    for (int llllllllllllllIIllIlIlIIIlIllIII = llllllllllllllIIllIlIlIIIlIllllI - 1; llllllllllllllIIllIlIlIIIlIllIII < llllllllllllllIIllIlIlIIIlIlllIl; ++llllllllllllllIIllIlIlIIIlIllIII) {
                        final BlockPos llllllllllllllIIllIlIlIIIlIlIlll = new BlockPos(llllllllllllllIIllIlIlIIIlIllIlI, llllllllllllllIIllIlIlIIIlIllIII, llllllllllllllIIllIlIlIIIlIllIIl);
                        IBlockState llllllllllllllIIllIlIlIIIlIlIlIl = null;
                        if (llllllllllllllIIllIlIlIIIlIllIlI >= -30000000 && llllllllllllllIIllIlIlIIIlIllIlI < 30000000 && llllllllllllllIIllIlIlIIIlIllIIl >= -30000000 && llllllllllllllIIllIlIlIIIlIllIIl < 30000000) {
                            final IBlockState llllllllllllllIIllIlIlIIIlIlIllI = this.getBlockState(llllllllllllllIIllIlIlIIIlIlIlll);
                        }
                        else {
                            llllllllllllllIIllIlIlIIIlIlIlIl = Blocks.bedrock.getDefaultState();
                        }
                        llllllllllllllIIllIlIlIIIlIlIlIl.getBlock().addCollisionBoxesToList(this, llllllllllllllIIllIlIlIIIlIlIlll, llllllllllllllIIllIlIlIIIlIlIlIl, llllllllllllllIIllIlIlIIIlIlIIll, llllllllllllllIIllIlIlIIIllIIIIl, null);
                    }
                }
            }
        }
        return llllllllllllllIIllIlIlIIIllIIIIl;
    }
    
    public void setAllowedSpawnTypes(final boolean llllllllllllllIIllIlIIIlIIllIlll, final boolean llllllllllllllIIllIlIIIlIIllIIll) {
        this.spawnHostileMobs = llllllllllllllIIllIlIIIlIIllIlll;
        this.spawnPeacefulMobs = llllllllllllllIIllIlIIIlIIllIIll;
    }
    
    public boolean isAnyLiquid(final AxisAlignedBB llllllllllllllIIllIlIIlIllIIllll) {
        final int llllllllllllllIIllIlIIlIllIIlllI = MathHelper.floor_double(llllllllllllllIIllIlIIlIllIIllll.minX);
        final int llllllllllllllIIllIlIIlIllIIllIl = MathHelper.floor_double(llllllllllllllIIllIlIIlIllIIllll.maxX);
        final int llllllllllllllIIllIlIIlIllIIllII = MathHelper.floor_double(llllllllllllllIIllIlIIlIllIIllll.minY);
        final int llllllllllllllIIllIlIIlIllIIlIll = MathHelper.floor_double(llllllllllllllIIllIlIIlIllIIllll.maxY);
        final int llllllllllllllIIllIlIIlIllIIlIlI = MathHelper.floor_double(llllllllllllllIIllIlIIlIllIIllll.minZ);
        final int llllllllllllllIIllIlIIlIllIIlIIl = MathHelper.floor_double(llllllllllllllIIllIlIIlIllIIllll.maxZ);
        for (int llllllllllllllIIllIlIIlIllIIlIII = llllllllllllllIIllIlIIlIllIIlllI; llllllllllllllIIllIlIIlIllIIlIII <= llllllllllllllIIllIlIIlIllIIllIl; ++llllllllllllllIIllIlIIlIllIIlIII) {
            for (int llllllllllllllIIllIlIIlIllIIIlll = llllllllllllllIIllIlIIlIllIIllII; llllllllllllllIIllIlIIlIllIIIlll <= llllllllllllllIIllIlIIlIllIIlIll; ++llllllllllllllIIllIlIIlIllIIIlll) {
                for (int llllllllllllllIIllIlIIlIllIIIllI = llllllllllllllIIllIlIIlIllIIlIlI; llllllllllllllIIllIlIIlIllIIIllI <= llllllllllllllIIllIlIIlIllIIlIIl; ++llllllllllllllIIllIlIIlIllIIIllI) {
                    final Block llllllllllllllIIllIlIIlIllIIIlIl = this.getBlockState(new BlockPos(llllllllllllllIIllIlIIlIllIIlIII, llllllllllllllIIllIlIIlIllIIIlll, llllllllllllllIIllIlIIlIllIIIllI)).getBlock();
                    if (llllllllllllllIIllIlIIlIllIIIlIl.getMaterial().isLiquid()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public WorldSavedData loadItemData(final Class llllllllllllllIIllIIllIlllIllIll, final String llllllllllllllIIllIIllIlllIlIlll) {
        return this.mapStorage.loadData(llllllllllllllIIllIIllIlllIllIll, llllllllllllllIIllIIllIlllIlIlll);
    }
    
    public boolean isFindingSpawnPoint() {
        return this.findingSpawnPoint;
    }
    
    public boolean checkNoEntityCollision(final AxisAlignedBB llllllllllllllIIllIlIIllIIIlIlIl) {
        return this.checkNoEntityCollision(llllllllllllllIIllIlIIllIIIlIlIl, null);
    }
    
    public boolean isAreaLoaded(final BlockPos llllllllllllllIIllIlIlllllIIlIIl, final BlockPos llllllllllllllIIllIlIlllllIIllII, final boolean llllllllllllllIIllIlIlllllIIIlll) {
        return this.isAreaLoaded(llllllllllllllIIllIlIlllllIIlIIl.getX(), llllllllllllllIIllIlIlllllIIlIIl.getY(), llllllllllllllIIllIlIlllllIIlIIl.getZ(), llllllllllllllIIllIlIlllllIIllII.getX(), llllllllllllllIIllIlIlllllIIllII.getY(), llllllllllllllIIllIlIlllllIIllII.getZ(), llllllllllllllIIllIlIlllllIIIlll);
    }
    
    public int getHeight() {
        return 256;
    }
    
    public int getLight(BlockPos llllllllllllllIIllIlIllIlIlllllI) {
        if (llllllllllllllIIllIlIllIlIlllllI.getY() < 0) {
            return 0;
        }
        if (llllllllllllllIIllIlIllIlIlllllI.getY() >= 256) {
            llllllllllllllIIllIlIllIlIlllllI = new BlockPos(llllllllllllllIIllIlIllIlIlllllI.getX(), 255, llllllllllllllIIllIlIllIlIlllllI.getZ());
        }
        return this.getChunkFromBlockCoords(llllllllllllllIIllIlIllIlIlllllI).setLight(llllllllllllllIIllIlIllIlIlllllI, 0);
    }
    
    public long getSeed() {
        return this.worldInfo.getSeed();
    }
    
    protected void func_147467_a(final int llllllllllllllIIllIlIIIIlllllIII, final int llllllllllllllIIllIlIIIIlllIllII, final Chunk llllllllllllllIIllIlIIIIllllIllI) {
        this.theProfiler.endStartSection("moodSound");
        if (this.ambientTickCountdown == 0 && !this.isRemote) {
            this.updateLCG = this.updateLCG * 3 + 1013904223;
            final int llllllllllllllIIllIlIIIIllllIlIl = this.updateLCG >> 2;
            int llllllllllllllIIllIlIIIIllllIlII = llllllllllllllIIllIlIIIIllllIlIl & 0xF;
            int llllllllllllllIIllIlIIIIllllIIll = llllllllllllllIIllIlIIIIllllIlIl >> 8 & 0xF;
            final int llllllllllllllIIllIlIIIIllllIIlI = llllllllllllllIIllIlIIIIllllIlIl >> 16 & 0xFF;
            final BlockPos llllllllllllllIIllIlIIIIllllIIIl = new BlockPos(llllllllllllllIIllIlIIIIllllIlII, llllllllllllllIIllIlIIIIllllIIlI, llllllllllllllIIllIlIIIIllllIIll);
            final Block llllllllllllllIIllIlIIIIllllIIII = llllllllllllllIIllIlIIIIllllIllI.getBlock(llllllllllllllIIllIlIIIIllllIIIl);
            llllllllllllllIIllIlIIIIllllIlII += llllllllllllllIIllIlIIIIlllllIII;
            llllllllllllllIIllIlIIIIllllIIll += llllllllllllllIIllIlIIIIlllIllII;
            if (llllllllllllllIIllIlIIIIllllIIII.getMaterial() == Material.air && this.getLight(llllllllllllllIIllIlIIIIllllIIIl) <= this.rand.nextInt(8) && this.getLightFor(EnumSkyBlock.SKY, llllllllllllllIIllIlIIIIllllIIIl) <= 0) {
                final EntityPlayer llllllllllllllIIllIlIIIIlllIllll = this.getClosestPlayer(llllllllllllllIIllIlIIIIllllIlII + 0.5, llllllllllllllIIllIlIIIIllllIIlI + 0.5, llllllllllllllIIllIlIIIIllllIIll + 0.5, 8.0);
                if (llllllllllllllIIllIlIIIIlllIllll != null && llllllllllllllIIllIlIIIIlllIllll.getDistanceSq(llllllllllllllIIllIlIIIIllllIlII + 0.5, llllllllllllllIIllIlIIIIllllIIlI + 0.5, llllllllllllllIIllIlIIIIllllIIll + 0.5) > 4.0) {
                    this.playSoundEffect(llllllllllllllIIllIlIIIIllllIlII + 0.5, llllllllllllllIIllIlIIIIllllIIlI + 0.5, llllllllllllllIIllIlIIIIllllIIll + 0.5, "ambient.cave.cave", 0.7f, 0.8f + this.rand.nextFloat() * 0.2f);
                    this.ambientTickCountdown = this.rand.nextInt(12000) + 6000;
                }
            }
        }
        this.theProfiler.endStartSection("checkLight");
        llllllllllllllIIllIlIIIIllllIllI.enqueueRelightChecks();
    }
    
    public boolean canBlockSeeSky(final BlockPos llllllllllllllIIllIlIllIllIIIllI) {
        if (llllllllllllllIIllIlIllIllIIIllI.getY() >= 63) {
            return this.isAgainstSky(llllllllllllllIIllIlIllIllIIIllI);
        }
        BlockPos llllllllllllllIIllIlIllIllIIlIIl = new BlockPos(llllllllllllllIIllIlIllIllIIIllI.getX(), 63, llllllllllllllIIllIlIllIllIIIllI.getZ());
        if (!this.isAgainstSky(llllllllllllllIIllIlIllIllIIlIIl)) {
            return false;
        }
        for (llllllllllllllIIllIlIllIllIIlIIl = llllllllllllllIIllIlIllIllIIlIIl.offsetDown(); llllllllllllllIIllIlIllIllIIlIIl.getY() > llllllllllllllIIllIlIllIllIIIllI.getY(); llllllllllllllIIllIlIllIllIIlIIl = llllllllllllllIIllIlIllIllIIlIIl.offsetDown()) {
            final Block llllllllllllllIIllIlIllIllIIlIII = this.getBlockState(llllllllllllllIIllIlIllIllIIlIIl).getBlock();
            if (llllllllllllllIIllIlIllIllIIlIII.getLightOpacity() > 0 && !llllllllllllllIIllIlIllIllIIlIII.getMaterial().isLiquid()) {
                return false;
            }
        }
        return true;
    }
    
    public void makeFireworks(final double llllllllllllllIIllIIllIlIlIllIlI, final double llllllllllllllIIllIIllIlIlIllIIl, final double llllllllllllllIIllIIllIlIlIllIII, final double llllllllllllllIIllIIllIlIlIlIlll, final double llllllllllllllIIllIIllIlIlIlIllI, final double llllllllllllllIIllIIllIlIlIlIlIl, final NBTTagCompound llllllllllllllIIllIIllIlIlIlIlII) {
    }
    
    public int func_175658_ac() {
        return this.lastLightningBolt;
    }
    
    public boolean func_175709_b(final BlockPos llllllllllllllIIllIIlllIllllllIl, final EnumFacing llllllllllllllIIllIIlllIllllllII) {
        return this.getRedstonePower(llllllllllllllIIllIIlllIllllllIl, llllllllllllllIIllIIlllIllllllII) > 0;
    }
    
    @Override
    public boolean extendedLevelsInChunkCache() {
        return false;
    }
    
    public boolean addTileEntity(final TileEntity llllllllllllllIIllIlIIllIlIIIlll) {
        final boolean llllllllllllllIIllIlIIllIlIIlIIl = this.loadedTileEntityList.add(llllllllllllllIIllIlIIllIlIIIlll);
        if (llllllllllllllIIllIlIIllIlIIlIIl && llllllllllllllIIllIlIIllIlIIIlll instanceof IUpdatePlayerListBox) {
            this.tickableTileEntities.add(llllllllllllllIIllIlIIllIlIIIlll);
        }
        return llllllllllllllIIllIlIIllIlIIlIIl;
    }
    
    public void removePlayerEntityDangerously(final Entity llllllllllllllIIllIlIlIIllIIlIll) {
        llllllllllllllIIllIlIlIIllIIlIll.setDead();
        if (llllllllllllllIIllIlIlIIllIIlIll instanceof EntityPlayer) {
            this.playerEntities.remove(llllllllllllllIIllIlIlIIllIIlIll);
            this.updateAllPlayersSleepingFlag();
        }
        final int llllllllllllllIIllIlIlIIllIIlllI = llllllllllllllIIllIlIlIIllIIlIll.chunkCoordX;
        final int llllllllllllllIIllIlIlIIllIIllIl = llllllllllllllIIllIlIlIIllIIlIll.chunkCoordZ;
        if (llllllllllllllIIllIlIlIIllIIlIll.addedToChunk && this.isChunkLoaded(llllllllllllllIIllIlIlIIllIIlllI, llllllllllllllIIllIlIlIIllIIllIl, true)) {
            this.getChunkFromChunkCoords(llllllllllllllIIllIlIlIIllIIlllI, llllllllllllllIIllIlIlIIllIIllIl).removeEntity(llllllllllllllIIllIlIlIIllIIlIll);
        }
        this.loadedEntityList.remove(llllllllllllllIIllIlIlIIllIIlIll);
        this.onEntityRemoved(llllllllllllllIIllIlIlIIllIIlIll);
    }
    
    public ISaveHandler getSaveHandler() {
        return this.saveHandler;
    }
    
    public void notifyBlockOfStateChange(final BlockPos llllllllllllllIIllIlIllIllIllllI, final Block llllllllllllllIIllIlIllIlllIIlII) {
        if (!this.isRemote) {
            final IBlockState llllllllllllllIIllIlIllIlllIIIll = this.getBlockState(llllllllllllllIIllIlIllIllIllllI);
            try {
                llllllllllllllIIllIlIllIlllIIIll.getBlock().onNeighborBlockChange(this, llllllllllllllIIllIlIllIllIllllI, llllllllllllllIIllIlIllIlllIIIll, llllllllllllllIIllIlIllIlllIIlII);
            }
            catch (Throwable llllllllllllllIIllIlIllIlllIIIlI) {
                final CrashReport llllllllllllllIIllIlIllIlllIIIIl = CrashReport.makeCrashReport(llllllllllllllIIllIlIllIlllIIIlI, "Exception while updating neighbours");
                final CrashReportCategory llllllllllllllIIllIlIllIlllIIIII = llllllllllllllIIllIlIllIlllIIIIl.makeCategory("Block being updated");
                llllllllllllllIIllIlIllIlllIIIII.addCrashSectionCallable("Source block type", new Callable() {
                    static {
                        __OBFID = "CL_00000142";
                    }
                    
                    @Override
                    public String call() {
                        try {
                            return String.format("ID #%d (%s // %s)", Block.getIdFromBlock(llllllllllllllIIllIlIllIlllIIlII), llllllllllllllIIllIlIllIlllIIlII.getUnlocalizedName(), llllllllllllllIIllIlIllIlllIIlII.getClass().getCanonicalName());
                        }
                        catch (Throwable llllllllllllllllIIlIlIIIllIlIIII) {
                            return String.valueOf(new StringBuilder("ID #").append(Block.getIdFromBlock(llllllllllllllIIllIlIllIlllIIlII)));
                        }
                    }
                });
                CrashReportCategory.addBlockInfo(llllllllllllllIIllIlIllIlllIIIII, llllllllllllllIIllIlIllIllIllllI, llllllllllllllIIllIlIllIlllIIIll);
                throw new ReportedException(llllllllllllllIIllIlIllIlllIIIIl);
            }
        }
    }
    
    protected World(final ISaveHandler llllllllllllllIIllIllIIIIIllllII, final WorldInfo llllllllllllllIIllIllIIIIIllIlIl, final WorldProvider llllllllllllllIIllIllIIIIIlllIlI, final Profiler llllllllllllllIIllIllIIIIIlllIIl, final boolean llllllllllllllIIllIllIIIIIlllIII) {
        this.loadedEntityList = Lists.newArrayList();
        this.unloadedEntityList = Lists.newArrayList();
        this.loadedTileEntityList = Lists.newArrayList();
        this.tickableTileEntities = Lists.newArrayList();
        this.addedTileEntityList = Lists.newArrayList();
        this.tileEntitiesToBeRemoved = Lists.newArrayList();
        this.playerEntities = Lists.newArrayList();
        this.weatherEffects = Lists.newArrayList();
        this.entitiesById = new IntHashMap();
        this.cloudColour = 16777215L;
        this.updateLCG = new Random().nextInt();
        this.rand = new Random();
        this.worldAccesses = Lists.newArrayList();
        this.theCalendar = Calendar.getInstance();
        this.worldScoreboard = new Scoreboard();
        this.activeChunkSet = Sets.newHashSet();
        this.ambientTickCountdown = this.rand.nextInt(12000);
        this.spawnHostileMobs = true;
        this.spawnPeacefulMobs = true;
        this.lightUpdateBlockList = new int[32768];
        this.saveHandler = llllllllllllllIIllIllIIIIIllllII;
        this.theProfiler = llllllllllllllIIllIllIIIIIlllIIl;
        this.worldInfo = llllllllllllllIIllIllIIIIIllIlIl;
        this.provider = llllllllllllllIIllIllIIIIIlllIlI;
        this.isRemote = llllllllllllllIIllIllIIIIIlllIII;
        this.worldBorder = llllllllllllllIIllIllIIIIIlllIlI.getWorldBorder();
    }
    
    public List getEntitiesWithinAABBExcludingEntity(final Entity llllllllllllllIIllIIllllllllllIl, final AxisAlignedBB llllllllllllllIIllIIlllllllllIIl) {
        return this.func_175674_a(llllllllllllllIIllIIllllllllllIl, llllllllllllllIIllIIlllllllllIIl, IEntitySelector.field_180132_d);
    }
    
    public EntityPlayer getClosestPlayerToEntity(final Entity llllllllllllllIIllIIlllIllIIlIlI, final double llllllllllllllIIllIIlllIllIIIllI) {
        return this.getClosestPlayer(llllllllllllllIIllIIlllIllIIlIlI.posX, llllllllllllllIIllIIlllIllIIlIlI.posY, llllllllllllllIIllIIlllIllIIlIlI.posZ, llllllllllllllIIllIIlllIllIIIllI);
    }
    
    public double getHorizon() {
        return (this.worldInfo.getTerrainType() == WorldType.FLAT) ? 0.0 : 63.0;
    }
    
    public VillageCollection getVillageCollection() {
        return this.villageCollectionObj;
    }
    
    public void spawnParticle(final EnumParticleTypes llllllllllllllIIllIlIlIlIlIlIlII, final double llllllllllllllIIllIlIlIlIlIIlIlI, final double llllllllllllllIIllIlIlIlIlIlIIlI, final double llllllllllllllIIllIlIlIlIlIlIIIl, final double llllllllllllllIIllIlIlIlIlIIIlll, final double llllllllllllllIIllIlIlIlIlIIllll, final double llllllllllllllIIllIlIlIlIlIIlllI, final int... llllllllllllllIIllIlIlIlIlIIllIl) {
        this.spawnParticle(llllllllllllllIIllIlIlIlIlIlIlII.func_179348_c(), llllllllllllllIIllIlIlIlIlIlIlII.func_179344_e(), llllllllllllllIIllIlIlIlIlIIlIlI, llllllllllllllIIllIlIlIlIlIlIIlI, llllllllllllllIIllIlIlIlIlIlIIIl, llllllllllllllIIllIlIlIlIlIIIlll, llllllllllllllIIllIlIlIlIlIIllll, llllllllllllllIIllIlIlIlIlIIlllI, llllllllllllllIIllIlIlIlIlIIllIl);
    }
    
    public int getLight(BlockPos llllllllllllllIIllIlIllIlIlIIlIl, final boolean llllllllllllllIIllIlIllIlIlIIlII) {
        if (((Vec3i)llllllllllllllIIllIlIllIlIlIIlIl).getX() < -30000000 || ((Vec3i)llllllllllllllIIllIlIllIlIlIIlIl).getZ() < -30000000 || ((Vec3i)llllllllllllllIIllIlIllIlIlIIlIl).getX() >= 30000000 || ((Vec3i)llllllllllllllIIllIlIllIlIlIIlIl).getZ() >= 30000000) {
            return 15;
        }
        if (llllllllllllllIIllIlIllIlIlIIlII && this.getBlockState((BlockPos)llllllllllllllIIllIlIllIlIlIIlIl).getBlock().getUseNeighborBrightness()) {
            int llllllllllllllIIllIlIllIlIlIllII = this.getLight(((BlockPos)llllllllllllllIIllIlIllIlIlIIlIl).offsetUp(), false);
            final int llllllllllllllIIllIlIllIlIlIlIll = this.getLight(((BlockPos)llllllllllllllIIllIlIllIlIlIIlIl).offsetEast(), false);
            final int llllllllllllllIIllIlIllIlIlIlIlI = this.getLight(((BlockPos)llllllllllllllIIllIlIllIlIlIIlIl).offsetWest(), false);
            final int llllllllllllllIIllIlIllIlIlIlIIl = this.getLight(((BlockPos)llllllllllllllIIllIlIllIlIlIIlIl).offsetSouth(), false);
            final int llllllllllllllIIllIlIllIlIlIlIII = this.getLight(((BlockPos)llllllllllllllIIllIlIllIlIlIIlIl).offsetNorth(), false);
            if (llllllllllllllIIllIlIllIlIlIlIll > llllllllllllllIIllIlIllIlIlIllII) {
                llllllllllllllIIllIlIllIlIlIllII = llllllllllllllIIllIlIllIlIlIlIll;
            }
            if (llllllllllllllIIllIlIllIlIlIlIlI > llllllllllllllIIllIlIllIlIlIllII) {
                llllllllllllllIIllIlIllIlIlIllII = llllllllllllllIIllIlIllIlIlIlIlI;
            }
            if (llllllllllllllIIllIlIllIlIlIlIIl > llllllllllllllIIllIlIllIlIlIllII) {
                llllllllllllllIIllIlIllIlIlIllII = llllllllllllllIIllIlIllIlIlIlIIl;
            }
            if (llllllllllllllIIllIlIllIlIlIlIII > llllllllllllllIIllIlIllIlIlIllII) {
                llllllllllllllIIllIlIllIlIlIllII = llllllllllllllIIllIlIllIlIlIlIII;
            }
            return llllllllllllllIIllIlIllIlIlIllII;
        }
        if (((Vec3i)llllllllllllllIIllIlIllIlIlIIlIl).getY() < 0) {
            return 0;
        }
        if (((Vec3i)llllllllllllllIIllIlIllIlIlIIlIl).getY() >= 256) {
            llllllllllllllIIllIlIllIlIlIIlIl = (Comparable<Boolean>)new BlockPos(((Vec3i)llllllllllllllIIllIlIllIlIlIIlIl).getX(), 255, ((Vec3i)llllllllllllllIIllIlIllIlIlIIlIl).getZ());
        }
        final Chunk llllllllllllllIIllIlIllIlIlIIlll = this.getChunkFromBlockCoords((BlockPos)llllllllllllllIIllIlIllIlIlIIlIl);
        return llllllllllllllIIllIlIllIlIlIIlll.setLight((BlockPos)llllllllllllllIIllIlIllIlIlIIlIl, this.skylightSubtracted);
    }
    
    public Block getGroundAboveSeaLevel(final BlockPos llllllllllllllIIllIllIIIIIIIlIll) {
        BlockPos llllllllllllllIIllIllIIIIIIIllIl;
        for (llllllllllllllIIllIllIIIIIIIllIl = new BlockPos(llllllllllllllIIllIllIIIIIIIlIll.getX(), 63, llllllllllllllIIllIllIIIIIIIlIll.getZ()); !this.isAirBlock(llllllllllllllIIllIllIIIIIIIllIl.offsetUp()); llllllllllllllIIllIllIIIIIIIllIl = llllllllllllllIIllIllIIIIIIIllIl.offsetUp()) {}
        return this.getBlockState(llllllllllllllIIllIllIIIIIIIllIl).getBlock();
    }
    
    public boolean checkLight(final BlockPos llllllllllllllIIllIlIIIIlIIlIIIl) {
        boolean llllllllllllllIIllIlIIIIlIIlIIll = false;
        if (!this.provider.getHasNoSky()) {
            llllllllllllllIIllIlIIIIlIIlIIll |= this.checkLightFor(EnumSkyBlock.SKY, llllllllllllllIIllIlIIIIlIIlIIIl);
        }
        llllllllllllllIIllIlIIIIlIIlIIll |= this.checkLightFor(EnumSkyBlock.BLOCK, llllllllllllllIIllIlIIIIlIIlIIIl);
        return llllllllllllllIIllIlIIIIlIIlIIll;
    }
    
    public boolean isInsideBorder(final WorldBorder llllllllllllllIIllIlIlIIIlllIlll, final Entity llllllllllllllIIllIlIlIIIlllllII) {
        double llllllllllllllIIllIlIlIIIllllIll = llllllllllllllIIllIlIlIIIlllIlll.minX();
        double llllllllllllllIIllIlIlIIIllllIlI = llllllllllllllIIllIlIlIIIlllIlll.minZ();
        double llllllllllllllIIllIlIlIIIllllIIl = llllllllllllllIIllIlIlIIIlllIlll.maxX();
        double llllllllllllllIIllIlIlIIIllllIII = llllllllllllllIIllIlIlIIIlllIlll.maxZ();
        if (llllllllllllllIIllIlIlIIIlllllII.isOutsideBorder()) {
            ++llllllllllllllIIllIlIlIIIllllIll;
            ++llllllllllllllIIllIlIlIIIllllIlI;
            --llllllllllllllIIllIlIlIIIllllIIl;
            --llllllllllllllIIllIlIlIIIllllIII;
        }
        else {
            --llllllllllllllIIllIlIlIIIllllIll;
            --llllllllllllllIIllIlIlIIIllllIlI;
            ++llllllllllllllIIllIlIlIIIllllIIl;
            ++llllllllllllllIIllIlIlIIIllllIII;
        }
        return llllllllllllllIIllIlIlIIIlllllII.posX > llllllllllllllIIllIlIlIIIllllIll && llllllllllllllIIllIlIlIIIlllllII.posX < llllllllllllllIIllIlIlIIIllllIIl && llllllllllllllIIllIlIlIIIlllllII.posZ > llllllllllllllIIllIlIlIIIllllIlI && llllllllllllllIIllIlIlIIIlllllII.posZ < llllllllllllllIIllIlIlIIIllllIII;
    }
    
    public void playSoundEffect(final double llllllllllllllIIllIlIlIllIIIIIIl, final double llllllllllllllIIllIlIlIllIIIIIII, final double llllllllllllllIIllIlIlIlIlllllll, final String llllllllllllllIIllIlIlIlIllllllI, final float llllllllllllllIIllIlIlIlIlllllIl, final float llllllllllllllIIllIlIlIlIlllIlII) {
        for (int llllllllllllllIIllIlIlIlIllllIll = 0; llllllllllllllIIllIlIlIlIllllIll < this.worldAccesses.size(); ++llllllllllllllIIllIlIlIlIllllIll) {
            this.worldAccesses.get(llllllllllllllIIllIlIlIlIllllIll).playSound(llllllllllllllIIllIlIlIlIllllllI, llllllllllllllIIllIlIlIllIIIIIIl, llllllllllllllIIllIlIlIllIIIIIII, llllllllllllllIIllIlIlIlIlllllll, llllllllllllllIIllIlIlIlIlllllIl, llllllllllllllIIllIlIlIlIlllIlII);
        }
    }
    
    public void joinEntityInSurroundings(final Entity llllllllllllllIIllIIlllIIlIIlIlI) {
        final int llllllllllllllIIllIIlllIIlIIlIIl = MathHelper.floor_double(llllllllllllllIIllIIlllIIlIIlIlI.posX / 16.0);
        final int llllllllllllllIIllIIlllIIlIIlIII = MathHelper.floor_double(llllllllllllllIIllIIlllIIlIIlIlI.posZ / 16.0);
        final byte llllllllllllllIIllIIlllIIlIIIlll = 2;
        for (int llllllllllllllIIllIIlllIIlIIIllI = llllllllllllllIIllIIlllIIlIIlIIl - llllllllllllllIIllIIlllIIlIIIlll; llllllllllllllIIllIIlllIIlIIIllI <= llllllllllllllIIllIIlllIIlIIlIIl + llllllllllllllIIllIIlllIIlIIIlll; ++llllllllllllllIIllIIlllIIlIIIllI) {
            for (int llllllllllllllIIllIIlllIIlIIIlIl = llllllllllllllIIllIIlllIIlIIlIII - llllllllllllllIIllIIlllIIlIIIlll; llllllllllllllIIllIIlllIIlIIIlIl <= llllllllllllllIIllIIlllIIlIIlIII + llllllllllllllIIllIIlllIIlIIIlll; ++llllllllllllllIIllIIlllIIlIIIlIl) {
                this.getChunkFromChunkCoords(llllllllllllllIIllIIlllIIlIIIllI, llllllllllllllIIllIIlllIIlIIIlIl);
            }
        }
        if (!this.loadedEntityList.contains(llllllllllllllIIllIIlllIIlIIlIlI)) {
            this.loadedEntityList.add(llllllllllllllIIllIIlllIIlIIlIlI);
        }
    }
    
    public static boolean doesBlockHaveSolidTopSurface(final IBlockAccess llllllllllllllIIllIlIIIlIlIllIII, final BlockPos llllllllllllllIIllIlIIIlIlIlIlll) {
        final IBlockState llllllllllllllIIllIlIIIlIlIlIllI = llllllllllllllIIllIlIIIlIlIllIII.getBlockState(llllllllllllllIIllIlIIIlIlIlIlll);
        final Block llllllllllllllIIllIlIIIlIlIlIlIl = llllllllllllllIIllIlIIIlIlIlIllI.getBlock();
        return (llllllllllllllIIllIlIIIlIlIlIlIl.getMaterial().isOpaque() && llllllllllllllIIllIlIIIlIlIlIlIl.isFullCube()) || ((llllllllllllllIIllIlIIIlIlIlIlIl instanceof BlockStairs) ? (llllllllllllllIIllIlIIIlIlIlIllI.getValue(BlockStairs.HALF) == BlockStairs.EnumHalf.TOP) : ((llllllllllllllIIllIlIIIlIlIlIlIl instanceof BlockSlab) ? (llllllllllllllIIllIlIIIlIlIlIllI.getValue(BlockSlab.HALF_PROP) == BlockSlab.EnumBlockHalf.TOP) : (llllllllllllllIIllIlIIIlIlIlIlIl instanceof BlockHopper || (llllllllllllllIIllIlIIIlIlIlIlIl instanceof BlockSnow && (int)llllllllllllllIIllIlIIIlIlIlIllI.getValue(BlockSnow.LAYERS_PROP) == 7))));
    }
    
    private void spawnParticle(final int llllllllllllllIIllIlIlIlIIIIllIl, final boolean llllllllllllllIIllIlIlIlIIIllIII, final double llllllllllllllIIllIlIlIlIIIlIlll, final double llllllllllllllIIllIlIlIlIIIIlIlI, final double llllllllllllllIIllIlIlIlIIIlIlIl, final double llllllllllllllIIllIlIlIlIIIlIlII, final double llllllllllllllIIllIlIlIlIIIlIIll, final double llllllllllllllIIllIlIlIlIIIlIIlI, final int... llllllllllllllIIllIlIlIlIIIlIIIl) {
        for (int llllllllllllllIIllIlIlIlIIIlIIII = 0; llllllllllllllIIllIlIlIlIIIlIIII < this.worldAccesses.size(); ++llllllllllllllIIllIlIlIlIIIlIIII) {
            this.worldAccesses.get(llllllllllllllIIllIlIlIlIIIlIIII).func_180442_a(llllllllllllllIIllIlIlIlIIIIllIl, llllllllllllllIIllIlIlIlIIIllIII, llllllllllllllIIllIlIlIlIIIlIlll, llllllllllllllIIllIlIlIlIIIIlIlI, llllllllllllllIIllIlIlIlIIIlIlIl, llllllllllllllIIllIlIlIlIIIlIlII, llllllllllllllIIllIlIlIlIIIlIIll, llllllllllllllIIllIlIlIlIIIlIIlI, llllllllllllllIIllIlIlIlIIIlIIIl);
        }
    }
    
    public void sendBlockBreakProgress(final int llllllllllllllIIllIIllIlIllIIIll, final BlockPos llllllllllllllIIllIIllIlIllIlIII, final int llllllllllllllIIllIIllIlIllIIIIl) {
        for (int llllllllllllllIIllIIllIlIllIIllI = 0; llllllllllllllIIllIIllIlIllIIllI < this.worldAccesses.size(); ++llllllllllllllIIllIIllIlIllIIllI) {
            final IWorldAccess llllllllllllllIIllIIllIlIllIIlIl = this.worldAccesses.get(llllllllllllllIIllIIllIlIllIIllI);
            llllllllllllllIIllIIllIlIllIIlIl.sendBlockBreakProgress(llllllllllllllIIllIIllIlIllIIIll, llllllllllllllIIllIIllIlIllIlIII, llllllllllllllIIllIIllIlIllIIIIl);
        }
    }
    
    public BlockPos func_180499_a(final String llllllllllllllIIllIIllIllIIIIlIl, final BlockPos llllllllllllllIIllIIllIllIIIIlII) {
        return this.getChunkProvider().func_180513_a(this, llllllllllllllIIllIIllIllIIIIlIl, llllllllllllllIIllIIllIllIIIIlII);
    }
    
    public void markTileEntityForRemoval(final TileEntity llllllllllllllIIllIlIIIlIllIlIIl) {
        this.tileEntitiesToBeRemoved.add(llllllllllllllIIllIlIIIlIllIlIIl);
    }
    
    public BlockPos func_175725_q(final BlockPos llllllllllllllIIllIlIIlllIlIlllI) {
        return this.getChunkFromBlockCoords(llllllllllllllIIllIlIIlllIlIlllI).func_177440_h(llllllllllllllIIllIlIIlllIlIlllI);
    }
    
    public WorldBorder getWorldBorder() {
        return this.worldBorder;
    }
    
    public void setSkylightSubtracted(final int llllllllllllllIIllIIllIlIIlIIlII) {
        this.skylightSubtracted = llllllllllllllIIllIIllIlIIlIIlII;
    }
    
    static {
        __OBFID = "CL_00000140";
    }
    
    public void func_175646_b(final BlockPos llllllllllllllIIllIIllllIlIlllII, final TileEntity llllllllllllllIIllIIllllIlIllllI) {
        if (this.isBlockLoaded(llllllllllllllIIllIIllllIlIlllII)) {
            this.getChunkFromBlockCoords(llllllllllllllIIllIIllllIlIlllII).setChunkModified();
        }
    }
    
    @Override
    public boolean isAirBlock(final BlockPos llllllllllllllIIllIllIIIIIIIIIII) {
        return this.getBlockState(llllllllllllllIIllIllIIIIIIIIIII).getBlock().getMaterial() == Material.air;
    }
    
    public void checkSessionLock() throws MinecraftException {
        this.saveHandler.checkSessionLock();
    }
    
    public void updateEntities() {
        this.theProfiler.startSection("entities");
        this.theProfiler.startSection("global");
        for (int llllllllllllllIIllIlIIllIlllIIIl = 0; llllllllllllllIIllIlIIllIlllIIIl < this.weatherEffects.size(); ++llllllllllllllIIllIlIIllIlllIIIl) {
            final Entity llllllllllllllIIllIlIIllIlllIIII = this.weatherEffects.get(llllllllllllllIIllIlIIllIlllIIIl);
            try {
                final Entity entity = llllllllllllllIIllIlIIllIlllIIII;
                ++entity.ticksExisted;
                llllllllllllllIIllIlIIllIlllIIII.onUpdate();
            }
            catch (Throwable llllllllllllllIIllIlIIllIllIlIIl) {
                final CrashReport llllllllllllllIIllIlIIllIllIllIl = CrashReport.makeCrashReport(llllllllllllllIIllIlIIllIllIlIIl, "Ticking entity");
                final CrashReportCategory llllllllllllllIIllIlIIllIllIlIll = llllllllllllllIIllIlIIllIllIllIl.makeCategory("Entity being ticked");
                if (llllllllllllllIIllIlIIllIlllIIII == null) {
                    llllllllllllllIIllIlIIllIllIlIll.addCrashSection("Entity", "~~NULL~~");
                }
                else {
                    llllllllllllllIIllIlIIllIlllIIII.addEntityCrashInfo(llllllllllllllIIllIlIIllIllIlIll);
                }
                throw new ReportedException(llllllllllllllIIllIlIIllIllIllIl);
            }
            if (llllllllllllllIIllIlIIllIlllIIII.isDead) {
                this.weatherEffects.remove(llllllllllllllIIllIlIIllIlllIIIl--);
            }
        }
        this.theProfiler.endStartSection("remove");
        this.loadedEntityList.removeAll(this.unloadedEntityList);
        for (int llllllllllllllIIllIlIIllIlllIIIl = 0; llllllllllllllIIllIlIIllIlllIIIl < this.unloadedEntityList.size(); ++llllllllllllllIIllIlIIllIlllIIIl) {
            final Entity llllllllllllllIIllIlIIllIllIllll = this.unloadedEntityList.get(llllllllllllllIIllIlIIllIlllIIIl);
            final int llllllllllllllIIllIlIIllIllIlIII = llllllllllllllIIllIlIIllIllIllll.chunkCoordX;
            final int llllllllllllllIIllIlIIllIllIIllI = llllllllllllllIIllIlIIllIllIllll.chunkCoordZ;
            if (llllllllllllllIIllIlIIllIllIllll.addedToChunk && this.isChunkLoaded(llllllllllllllIIllIlIIllIllIlIII, llllllllllllllIIllIlIIllIllIIllI, true)) {
                this.getChunkFromChunkCoords(llllllllllllllIIllIlIIllIllIlIII, llllllllllllllIIllIlIIllIllIIllI).removeEntity(llllllllllllllIIllIlIIllIllIllll);
            }
        }
        for (int llllllllllllllIIllIlIIllIlllIIIl = 0; llllllllllllllIIllIlIIllIlllIIIl < this.unloadedEntityList.size(); ++llllllllllllllIIllIlIIllIlllIIIl) {
            this.onEntityRemoved(this.unloadedEntityList.get(llllllllllllllIIllIlIIllIlllIIIl));
        }
        this.unloadedEntityList.clear();
        this.theProfiler.endStartSection("regular");
        for (int llllllllllllllIIllIlIIllIlllIIIl = 0; llllllllllllllIIllIlIIllIlllIIIl < this.loadedEntityList.size(); ++llllllllllllllIIllIlIIllIlllIIIl) {
            final Entity llllllllllllllIIllIlIIllIllIlllI = this.loadedEntityList.get(llllllllllllllIIllIlIIllIlllIIIl);
            if (llllllllllllllIIllIlIIllIllIlllI.ridingEntity != null) {
                if (!llllllllllllllIIllIlIIllIllIlllI.ridingEntity.isDead && llllllllllllllIIllIlIIllIllIlllI.ridingEntity.riddenByEntity == llllllllllllllIIllIlIIllIllIlllI) {
                    continue;
                }
                llllllllllllllIIllIlIIllIllIlllI.ridingEntity.riddenByEntity = null;
                llllllllllllllIIllIlIIllIllIlllI.ridingEntity = null;
            }
            this.theProfiler.startSection("tick");
            if (!llllllllllllllIIllIlIIllIllIlllI.isDead) {
                try {
                    this.updateEntity(llllllllllllllIIllIlIIllIllIlllI);
                }
                catch (Throwable llllllllllllllIIllIlIIllIllIIlII) {
                    final CrashReport llllllllllllllIIllIlIIllIllIllII = CrashReport.makeCrashReport(llllllllllllllIIllIlIIllIllIIlII, "Ticking entity");
                    final CrashReportCategory llllllllllllllIIllIlIIllIllIlIlI = llllllllllllllIIllIlIIllIllIllII.makeCategory("Entity being ticked");
                    llllllllllllllIIllIlIIllIllIlllI.addEntityCrashInfo(llllllllllllllIIllIlIIllIllIlIlI);
                    throw new ReportedException(llllllllllllllIIllIlIIllIllIllII);
                }
            }
            this.theProfiler.endSection();
            this.theProfiler.startSection("remove");
            if (llllllllllllllIIllIlIIllIllIlllI.isDead) {
                final int llllllllllllllIIllIlIIllIllIIlll = llllllllllllllIIllIlIIllIllIlllI.chunkCoordX;
                final int llllllllllllllIIllIlIIllIllIIlIl = llllllllllllllIIllIlIIllIllIlllI.chunkCoordZ;
                if (llllllllllllllIIllIlIIllIllIlllI.addedToChunk && this.isChunkLoaded(llllllllllllllIIllIlIIllIllIIlll, llllllllllllllIIllIlIIllIllIIlIl, true)) {
                    this.getChunkFromChunkCoords(llllllllllllllIIllIlIIllIllIIlll, llllllllllllllIIllIlIIllIllIIlIl).removeEntity(llllllllllllllIIllIlIIllIllIlllI);
                }
                this.loadedEntityList.remove(llllllllllllllIIllIlIIllIlllIIIl--);
                this.onEntityRemoved(llllllllllllllIIllIlIIllIllIlllI);
            }
            this.theProfiler.endSection();
        }
        this.theProfiler.endStartSection("blockEntities");
        this.processingLoadedTiles = true;
        final Iterator llllllllllllllIIllIlIIllIllIIIll = this.tickableTileEntities.iterator();
        while (llllllllllllllIIllIlIIllIllIIIll.hasNext()) {
            final TileEntity llllllllllllllIIllIlIIllIllIIIlI = llllllllllllllIIllIlIIllIllIIIll.next();
            if (!llllllllllllllIIllIlIIllIllIIIlI.isInvalid() && llllllllllllllIIllIlIIllIllIIIlI.hasWorldObj()) {
                final BlockPos llllllllllllllIIllIlIIllIllIIIIl = llllllllllllllIIllIlIIllIllIIIlI.getPos();
                if (this.isBlockLoaded(llllllllllllllIIllIlIIllIllIIIIl) && this.worldBorder.contains(llllllllllllllIIllIlIIllIllIIIIl)) {
                    try {
                        ((IUpdatePlayerListBox)llllllllllllllIIllIlIIllIllIIIlI).update();
                    }
                    catch (Throwable llllllllllllllIIllIlIIllIllIIIII) {
                        final CrashReport llllllllllllllIIllIlIIllIlIlllll = CrashReport.makeCrashReport(llllllllllllllIIllIlIIllIllIIIII, "Ticking block entity");
                        final CrashReportCategory llllllllllllllIIllIlIIllIlIllllI = llllllllllllllIIllIlIIllIlIlllll.makeCategory("Block entity being ticked");
                        llllllllllllllIIllIlIIllIllIIIlI.addInfoToCrashReport(llllllllllllllIIllIlIIllIlIllllI);
                        throw new ReportedException(llllllllllllllIIllIlIIllIlIlllll);
                    }
                }
            }
            if (llllllllllllllIIllIlIIllIllIIIlI.isInvalid()) {
                llllllllllllllIIllIlIIllIllIIIll.remove();
                this.loadedTileEntityList.remove(llllllllllllllIIllIlIIllIllIIIlI);
                if (!this.isBlockLoaded(llllllllllllllIIllIlIIllIllIIIlI.getPos())) {
                    continue;
                }
                this.getChunkFromBlockCoords(llllllllllllllIIllIlIIllIllIIIlI.getPos()).removeTileEntity(llllllllllllllIIllIlIIllIllIIIlI.getPos());
            }
        }
        this.processingLoadedTiles = false;
        if (!this.tileEntitiesToBeRemoved.isEmpty()) {
            this.tickableTileEntities.removeAll(this.tileEntitiesToBeRemoved);
            this.loadedTileEntityList.removeAll(this.tileEntitiesToBeRemoved);
            this.tileEntitiesToBeRemoved.clear();
        }
        this.theProfiler.endStartSection("pendingBlockEntities");
        if (!this.addedTileEntityList.isEmpty()) {
            for (int llllllllllllllIIllIlIIllIlIlllIl = 0; llllllllllllllIIllIlIIllIlIlllIl < this.addedTileEntityList.size(); ++llllllllllllllIIllIlIIllIlIlllIl) {
                final TileEntity llllllllllllllIIllIlIIllIlIlllII = this.addedTileEntityList.get(llllllllllllllIIllIlIIllIlIlllIl);
                if (!llllllllllllllIIllIlIIllIlIlllII.isInvalid()) {
                    if (!this.loadedTileEntityList.contains(llllllllllllllIIllIlIIllIlIlllII)) {
                        this.addTileEntity(llllllllllllllIIllIlIIllIlIlllII);
                    }
                    if (this.isBlockLoaded(llllllllllllllIIllIlIIllIlIlllII.getPos())) {
                        this.getChunkFromBlockCoords(llllllllllllllIIllIlIIllIlIlllII.getPos()).addTileEntity(llllllllllllllIIllIlIIllIlIlllII.getPos(), llllllllllllllIIllIlIIllIlIlllII);
                    }
                    this.markBlockForUpdate(llllllllllllllIIllIlIIllIlIlllII.getPos());
                }
            }
            this.addedTileEntityList.clear();
        }
        this.theProfiler.endSection();
        this.theProfiler.endSection();
    }
    
    public List func_175647_a(final Class llllllllllllllIIllIIlllllIIlIIll, final AxisAlignedBB llllllllllllllIIllIIlllllIIlllIl, final Predicate llllllllllllllIIllIIlllllIIlllII) {
        final int llllllllllllllIIllIIlllllIIllIll = MathHelper.floor_double((llllllllllllllIIllIIlllllIIlllIl.minX - 2.0) / 16.0);
        final int llllllllllllllIIllIIlllllIIllIlI = MathHelper.floor_double((llllllllllllllIIllIIlllllIIlllIl.maxX + 2.0) / 16.0);
        final int llllllllllllllIIllIIlllllIIllIIl = MathHelper.floor_double((llllllllllllllIIllIIlllllIIlllIl.minZ - 2.0) / 16.0);
        final int llllllllllllllIIllIIlllllIIllIII = MathHelper.floor_double((llllllllllllllIIllIIlllllIIlllIl.maxZ + 2.0) / 16.0);
        final ArrayList llllllllllllllIIllIIlllllIIlIlll = Lists.newArrayList();
        for (int llllllllllllllIIllIIlllllIIlIllI = llllllllllllllIIllIIlllllIIllIll; llllllllllllllIIllIIlllllIIlIllI <= llllllllllllllIIllIIlllllIIllIlI; ++llllllllllllllIIllIIlllllIIlIllI) {
            for (int llllllllllllllIIllIIlllllIIlIlIl = llllllllllllllIIllIIlllllIIllIIl; llllllllllllllIIllIIlllllIIlIlIl <= llllllllllllllIIllIIlllllIIllIII; ++llllllllllllllIIllIIlllllIIlIlIl) {
                if (this.isChunkLoaded(llllllllllllllIIllIIlllllIIlIllI, llllllllllllllIIllIIlllllIIlIlIl, true)) {
                    this.getChunkFromChunkCoords(llllllllllllllIIllIIlllllIIlIllI, llllllllllllllIIllIIlllllIIlIlIl).func_177430_a(llllllllllllllIIllIIlllllIIlIIll, llllllllllllllIIllIIlllllIIlllIl, llllllllllllllIIllIIlllllIIlIlll, llllllllllllllIIllIIlllllIIlllII);
                }
            }
        }
        return llllllllllllllIIllIIlllllIIlIlll;
    }
    
    public void markBlockForUpdate(final BlockPos llllllllllllllIIllIlIlllIlIIIlII) {
        for (int llllllllllllllIIllIlIlllIlIIIIll = 0; llllllllllllllIIllIlIlllIlIIIIll < this.worldAccesses.size(); ++llllllllllllllIIllIlIlllIlIIIIll) {
            this.worldAccesses.get(llllllllllllllIIllIlIlllIlIIIIll).markBlockForUpdate(llllllllllllllIIllIlIlllIlIIIlII);
        }
    }
    
    public long getTotalWorldTime() {
        return this.worldInfo.getWorldTotalTime();
    }
    
    public List func_175674_a(final Entity llllllllllllllIIllIIlllllllIllII, final AxisAlignedBB llllllllllllllIIllIIlllllllIlIll, final Predicate llllllllllllllIIllIIlllllllIlIlI) {
        final ArrayList llllllllllllllIIllIIlllllllIlIIl = Lists.newArrayList();
        final int llllllllllllllIIllIIlllllllIlIII = MathHelper.floor_double((llllllllllllllIIllIIlllllllIlIll.minX - 2.0) / 16.0);
        final int llllllllllllllIIllIIlllllllIIlll = MathHelper.floor_double((llllllllllllllIIllIIlllllllIlIll.maxX + 2.0) / 16.0);
        final int llllllllllllllIIllIIlllllllIIllI = MathHelper.floor_double((llllllllllllllIIllIIlllllllIlIll.minZ - 2.0) / 16.0);
        final int llllllllllllllIIllIIlllllllIIlIl = MathHelper.floor_double((llllllllllllllIIllIIlllllllIlIll.maxZ + 2.0) / 16.0);
        for (int llllllllllllllIIllIIlllllllIIlII = llllllllllllllIIllIIlllllllIlIII; llllllllllllllIIllIIlllllllIIlII <= llllllllllllllIIllIIlllllllIIlll; ++llllllllllllllIIllIIlllllllIIlII) {
            for (int llllllllllllllIIllIIlllllllIIIll = llllllllllllllIIllIIlllllllIIllI; llllllllllllllIIllIIlllllllIIIll <= llllllllllllllIIllIIlllllllIIlIl; ++llllllllllllllIIllIIlllllllIIIll) {
                if (this.isChunkLoaded(llllllllllllllIIllIIlllllllIIlII, llllllllllllllIIllIIlllllllIIIll, true)) {
                    this.getChunkFromChunkCoords(llllllllllllllIIllIIlllllllIIlII, llllllllllllllIIllIIlllllllIIIll).func_177414_a(llllllllllllllIIllIIlllllllIllII, llllllllllllllIIllIIlllllllIlIll, llllllllllllllIIllIIlllllllIlIIl, llllllllllllllIIllIIlllllllIlIlI);
                }
            }
        }
        return llllllllllllllIIllIIlllllllIlIIl;
    }
    
    public boolean func_175662_w(final BlockPos llllllllllllllIIllIlIIIIllIIlIIl) {
        return this.func_175670_e(llllllllllllllIIllIlIIIIllIIlIIl, true);
    }
    
    public void addTileEntities(final Collection llllllllllllllIIllIlIIllIIllllII) {
        if (this.processingLoadedTiles) {
            this.addedTileEntityList.addAll(llllllllllllllIIllIlIIllIIllllII);
        }
        else {
            for (final TileEntity llllllllllllllIIllIlIIllIIlllllI : llllllllllllllIIllIlIIllIIllllII) {
                this.loadedTileEntityList.add(llllllllllllllIIllIlIIllIIlllllI);
                if (llllllllllllllIIllIlIIllIIlllllI instanceof IUpdatePlayerListBox) {
                    this.tickableTileEntities.add(llllllllllllllIIllIlIIllIIlllllI);
                }
            }
        }
    }
    
    public Scoreboard getScoreboard() {
        return this.worldScoreboard;
    }
    
    public void removeEntity(final Entity llllllllllllllIIllIlIlIIllIlIlIl) {
        if (llllllllllllllIIllIlIlIIllIlIlIl.riddenByEntity != null) {
            llllllllllllllIIllIlIlIIllIlIlIl.riddenByEntity.mountEntity(null);
        }
        if (llllllllllllllIIllIlIlIIllIlIlIl.ridingEntity != null) {
            llllllllllllllIIllIlIlIIllIlIlIl.mountEntity(null);
        }
        llllllllllllllIIllIlIlIIllIlIlIl.setDead();
        if (llllllllllllllIIllIlIlIIllIlIlIl instanceof EntityPlayer) {
            this.playerEntities.remove(llllllllllllllIIllIlIlIIllIlIlIl);
            this.updateAllPlayersSleepingFlag();
            this.onEntityRemoved(llllllllllllllIIllIlIlIIllIlIlIl);
        }
    }
    
    public void playSoundToNearExcept(final EntityPlayer llllllllllllllIIllIlIlIllIIIllll, final String llllllllllllllIIllIlIlIllIIIlllI, final float llllllllllllllIIllIlIlIllIIlIIll, final float llllllllllllllIIllIlIlIllIIlIIlI) {
        for (int llllllllllllllIIllIlIlIllIIlIIIl = 0; llllllllllllllIIllIlIlIllIIlIIIl < this.worldAccesses.size(); ++llllllllllllllIIllIlIlIllIIlIIIl) {
            this.worldAccesses.get(llllllllllllllIIllIlIlIllIIlIIIl).playSoundToNearExcept(llllllllllllllIIllIlIlIllIIIllll, llllllllllllllIIllIlIlIllIIIlllI, llllllllllllllIIllIlIlIllIIIllll.posX, llllllllllllllIIllIlIlIllIIIllll.posY, llllllllllllllIIllIlIlIllIIIllll.posZ, llllllllllllllIIllIlIlIllIIlIIll, llllllllllllllIIllIlIlIllIIlIIlI);
        }
    }
    
    public int getChunksLowestHorizon(final int llllllllllllllIIllIlIllIlIIIlllI, final int llllllllllllllIIllIlIllIlIIIlIIl) {
        if (llllllllllllllIIllIlIllIlIIIlllI < -30000000 || llllllllllllllIIllIlIllIlIIIlIIl < -30000000 || llllllllllllllIIllIlIllIlIIIlllI >= 30000000 || llllllllllllllIIllIlIllIlIIIlIIl >= 30000000) {
            return 64;
        }
        if (!this.isChunkLoaded(llllllllllllllIIllIlIllIlIIIlllI >> 4, llllllllllllllIIllIlIllIlIIIlIIl >> 4, true)) {
            return 0;
        }
        final Chunk llllllllllllllIIllIlIllIlIIIllII = this.getChunkFromChunkCoords(llllllllllllllIIllIlIllIlIIIlllI >> 4, llllllllllllllIIllIlIllIlIIIlIIl >> 4);
        return llllllllllllllIIllIlIllIlIIIllII.getLowestHeight();
    }
    
    public boolean isAreaLoaded(final BlockPos llllllllllllllIIllIlIlllllIlIlII, final BlockPos llllllllllllllIIllIlIlllllIlIIll) {
        return this.isAreaLoaded(llllllllllllllIIllIlIlllllIlIlII, llllllllllllllIIllIlIlllllIlIIll, true);
    }
    
    public void playSoundAtEntity(final Entity llllllllllllllIIllIlIlIllIlIIIIl, final String llllllllllllllIIllIlIlIllIlIIIII, final float llllllllllllllIIllIlIlIllIlIIlIl, final float llllllllllllllIIllIlIlIllIlIIlII) {
        for (int llllllllllllllIIllIlIlIllIlIIIll = 0; llllllllllllllIIllIlIlIllIlIIIll < this.worldAccesses.size(); ++llllllllllllllIIllIlIlIllIlIIIll) {
            this.worldAccesses.get(llllllllllllllIIllIlIlIllIlIIIll).playSound(llllllllllllllIIllIlIlIllIlIIIII, llllllllllllllIIllIlIlIllIlIIIIl.posX, llllllllllllllIIllIlIlIllIlIIIIl.posY, llllllllllllllIIllIlIlIllIlIIIIl.posZ, llllllllllllllIIllIlIlIllIlIIlIl, llllllllllllllIIllIlIlIllIlIIlII);
        }
    }
    
    public void setLightFor(final EnumSkyBlock llllllllllllllIIllIlIllIIlIlllII, final BlockPos llllllllllllllIIllIlIllIIlIlIllI, final int llllllllllllllIIllIlIllIIlIlIlIl) {
        if (this.isValid(llllllllllllllIIllIlIllIIlIlIllI) && this.isBlockLoaded(llllllllllllllIIllIlIllIIlIlIllI)) {
            final Chunk llllllllllllllIIllIlIllIIlIllIIl = this.getChunkFromBlockCoords(llllllllllllllIIllIlIllIIlIlIllI);
            llllllllllllllIIllIlIllIIlIllIIl.setLightFor(llllllllllllllIIllIlIllIIlIlllII, llllllllllllllIIllIlIllIIlIlIllI, llllllllllllllIIllIlIllIIlIlIlIl);
            this.notifyLightSet(llllllllllllllIIllIlIllIIlIlIllI);
        }
    }
    
    public int countEntities(final Class llllllllllllllIIllIIllllIlIlIIII) {
        int llllllllllllllIIllIIllllIlIlIlII = 0;
        for (final Entity llllllllllllllIIllIIllllIlIlIIlI : this.loadedEntityList) {
            if ((!(llllllllllllllIIllIIllllIlIlIIlI instanceof EntityLiving) || !((EntityLiving)llllllllllllllIIllIIllllIlIlIIlI).isNoDespawnRequired()) && llllllllllllllIIllIIllllIlIlIIII.isAssignableFrom(llllllllllllllIIllIIllllIlIlIIlI.getClass())) {
                ++llllllllllllllIIllIIllllIlIlIlII;
            }
        }
        return llllllllllllllIIllIIllllIlIlIlII;
    }
    
    public void setLastLightningBolt(final int llllllllllllllIIllIIllIlIIIlllIl) {
        this.lastLightningBolt = llllllllllllllIIllIIllIlIIIlllIl;
    }
    
    public int getSkylightSubtracted() {
        return this.skylightSubtracted;
    }
    
    public boolean func_147470_e(final AxisAlignedBB llllllllllllllIIllIlIIlIlIlIlIll) {
        final int llllllllllllllIIllIlIIlIlIlIlIlI = MathHelper.floor_double(llllllllllllllIIllIlIIlIlIlIlIll.minX);
        final int llllllllllllllIIllIlIIlIlIlIlIIl = MathHelper.floor_double(llllllllllllllIIllIlIIlIlIlIlIll.maxX + 1.0);
        final int llllllllllllllIIllIlIIlIlIlIlIII = MathHelper.floor_double(llllllllllllllIIllIlIIlIlIlIlIll.minY);
        final int llllllllllllllIIllIlIIlIlIlIIlll = MathHelper.floor_double(llllllllllllllIIllIlIIlIlIlIlIll.maxY + 1.0);
        final int llllllllllllllIIllIlIIlIlIlIIllI = MathHelper.floor_double(llllllllllllllIIllIlIIlIlIlIlIll.minZ);
        final int llllllllllllllIIllIlIIlIlIlIIlIl = MathHelper.floor_double(llllllllllllllIIllIlIIlIlIlIlIll.maxZ + 1.0);
        if (this.isAreaLoaded(llllllllllllllIIllIlIIlIlIlIlIlI, llllllllllllllIIllIlIIlIlIlIlIII, llllllllllllllIIllIlIIlIlIlIIllI, llllllllllllllIIllIlIIlIlIlIlIIl, llllllllllllllIIllIlIIlIlIlIIlll, llllllllllllllIIllIlIIlIlIlIIlIl, true)) {
            for (int llllllllllllllIIllIlIIlIlIlIIlII = llllllllllllllIIllIlIIlIlIlIlIlI; llllllllllllllIIllIlIIlIlIlIIlII < llllllllllllllIIllIlIIlIlIlIlIIl; ++llllllllllllllIIllIlIIlIlIlIIlII) {
                for (int llllllllllllllIIllIlIIlIlIlIIIll = llllllllllllllIIllIlIIlIlIlIlIII; llllllllllllllIIllIlIIlIlIlIIIll < llllllllllllllIIllIlIIlIlIlIIlll; ++llllllllllllllIIllIlIIlIlIlIIIll) {
                    for (int llllllllllllllIIllIlIIlIlIlIIIlI = llllllllllllllIIllIlIIlIlIlIIllI; llllllllllllllIIllIlIIlIlIlIIIlI < llllllllllllllIIllIlIIlIlIlIIlIl; ++llllllllllllllIIllIlIIlIlIlIIIlI) {
                        final Block llllllllllllllIIllIlIIlIlIlIIIIl = this.getBlockState(new BlockPos(llllllllllllllIIllIlIIlIlIlIIlII, llllllllllllllIIllIlIIlIlIlIIIll, llllllllllllllIIllIlIIlIlIlIIIlI)).getBlock();
                        if (llllllllllllllIIllIlIIlIlIlIIIIl == Blocks.fire || llllllllllllllIIllIlIIlIlIlIIIIl == Blocks.flowing_lava || llllllllllllllIIllIlIIlIlIlIIIIl == Blocks.lava) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public void updateEntityWithOptionalForce(final Entity llllllllllllllIIllIlIIllIIlIIIII, final boolean llllllllllllllIIllIlIIllIIlIlIII) {
        final int llllllllllllllIIllIlIIllIIlIIlll = MathHelper.floor_double(llllllllllllllIIllIlIIllIIlIIIII.posX);
        final int llllllllllllllIIllIlIIllIIlIIllI = MathHelper.floor_double(llllllllllllllIIllIlIIllIIlIIIII.posZ);
        final byte llllllllllllllIIllIlIIllIIlIIlIl = 32;
        if (!llllllllllllllIIllIlIIllIIlIlIII || this.isAreaLoaded(llllllllllllllIIllIlIIllIIlIIlll - llllllllllllllIIllIlIIllIIlIIlIl, 0, llllllllllllllIIllIlIIllIIlIIllI - llllllllllllllIIllIlIIllIIlIIlIl, llllllllllllllIIllIlIIllIIlIIlll + llllllllllllllIIllIlIIllIIlIIlIl, 0, llllllllllllllIIllIlIIllIIlIIllI + llllllllllllllIIllIlIIllIIlIIlIl, true)) {
            llllllllllllllIIllIlIIllIIlIIIII.lastTickPosX = llllllllllllllIIllIlIIllIIlIIIII.posX;
            llllllllllllllIIllIlIIllIIlIIIII.lastTickPosY = llllllllllllllIIllIlIIllIIlIIIII.posY;
            llllllllllllllIIllIlIIllIIlIIIII.lastTickPosZ = llllllllllllllIIllIlIIllIIlIIIII.posZ;
            llllllllllllllIIllIlIIllIIlIIIII.prevRotationYaw = llllllllllllllIIllIlIIllIIlIIIII.rotationYaw;
            llllllllllllllIIllIlIIllIIlIIIII.prevRotationPitch = llllllllllllllIIllIlIIllIIlIIIII.rotationPitch;
            if (llllllllllllllIIllIlIIllIIlIlIII && llllllllllllllIIllIlIIllIIlIIIII.addedToChunk) {
                ++llllllllllllllIIllIlIIllIIlIIIII.ticksExisted;
                if (llllllllllllllIIllIlIIllIIlIIIII.ridingEntity != null) {
                    llllllllllllllIIllIlIIllIIlIIIII.updateRidden();
                }
                else {
                    llllllllllllllIIllIlIIllIIlIIIII.onUpdate();
                }
            }
            this.theProfiler.startSection("chunkCheck");
            if (Double.isNaN(llllllllllllllIIllIlIIllIIlIIIII.posX) || Double.isInfinite(llllllllllllllIIllIlIIllIIlIIIII.posX)) {
                llllllllllllllIIllIlIIllIIlIIIII.posX = llllllllllllllIIllIlIIllIIlIIIII.lastTickPosX;
            }
            if (Double.isNaN(llllllllllllllIIllIlIIllIIlIIIII.posY) || Double.isInfinite(llllllllllllllIIllIlIIllIIlIIIII.posY)) {
                llllllllllllllIIllIlIIllIIlIIIII.posY = llllllllllllllIIllIlIIllIIlIIIII.lastTickPosY;
            }
            if (Double.isNaN(llllllllllllllIIllIlIIllIIlIIIII.posZ) || Double.isInfinite(llllllllllllllIIllIlIIllIIlIIIII.posZ)) {
                llllllllllllllIIllIlIIllIIlIIIII.posZ = llllllllllllllIIllIlIIllIIlIIIII.lastTickPosZ;
            }
            if (Double.isNaN(llllllllllllllIIllIlIIllIIlIIIII.rotationPitch) || Double.isInfinite(llllllllllllllIIllIlIIllIIlIIIII.rotationPitch)) {
                llllllllllllllIIllIlIIllIIlIIIII.rotationPitch = llllllllllllllIIllIlIIllIIlIIIII.prevRotationPitch;
            }
            if (Double.isNaN(llllllllllllllIIllIlIIllIIlIIIII.rotationYaw) || Double.isInfinite(llllllllllllllIIllIlIIllIIlIIIII.rotationYaw)) {
                llllllllllllllIIllIlIIllIIlIIIII.rotationYaw = llllllllllllllIIllIlIIllIIlIIIII.prevRotationYaw;
            }
            final int llllllllllllllIIllIlIIllIIlIIlII = MathHelper.floor_double(llllllllllllllIIllIlIIllIIlIIIII.posX / 16.0);
            final int llllllllllllllIIllIlIIllIIlIIIll = MathHelper.floor_double(llllllllllllllIIllIlIIllIIlIIIII.posY / 16.0);
            final int llllllllllllllIIllIlIIllIIlIIIlI = MathHelper.floor_double(llllllllllllllIIllIlIIllIIlIIIII.posZ / 16.0);
            if (!llllllllllllllIIllIlIIllIIlIIIII.addedToChunk || llllllllllllllIIllIlIIllIIlIIIII.chunkCoordX != llllllllllllllIIllIlIIllIIlIIlII || llllllllllllllIIllIlIIllIIlIIIII.chunkCoordY != llllllllllllllIIllIlIIllIIlIIIll || llllllllllllllIIllIlIIllIIlIIIII.chunkCoordZ != llllllllllllllIIllIlIIllIIlIIIlI) {
                if (llllllllllllllIIllIlIIllIIlIIIII.addedToChunk && this.isChunkLoaded(llllllllllllllIIllIlIIllIIlIIIII.chunkCoordX, llllllllllllllIIllIlIIllIIlIIIII.chunkCoordZ, true)) {
                    this.getChunkFromChunkCoords(llllllllllllllIIllIlIIllIIlIIIII.chunkCoordX, llllllllllllllIIllIlIIllIIlIIIII.chunkCoordZ).removeEntityAtIndex(llllllllllllllIIllIlIIllIIlIIIII, llllllllllllllIIllIlIIllIIlIIIII.chunkCoordY);
                }
                if (this.isChunkLoaded(llllllllllllllIIllIlIIllIIlIIlII, llllllllllllllIIllIlIIllIIlIIIlI, true)) {
                    llllllllllllllIIllIlIIllIIlIIIII.addedToChunk = true;
                    this.getChunkFromChunkCoords(llllllllllllllIIllIlIIllIIlIIlII, llllllllllllllIIllIlIIllIIlIIIlI).addEntity(llllllllllllllIIllIlIIllIIlIIIII);
                }
                else {
                    llllllllllllllIIllIlIIllIIlIIIII.addedToChunk = false;
                }
            }
            this.theProfiler.endSection();
            if (llllllllllllllIIllIlIIllIIlIlIII && llllllllllllllIIllIlIIllIIlIIIII.addedToChunk && llllllllllllllIIllIlIIllIIlIIIII.riddenByEntity != null) {
                if (!llllllllllllllIIllIlIIllIIlIIIII.riddenByEntity.isDead && llllllllllllllIIllIlIIllIIlIIIII.riddenByEntity.ridingEntity == llllllllllllllIIllIlIIllIIlIIIII) {
                    this.updateEntity(llllllllllllllIIllIlIIllIIlIIIII.riddenByEntity);
                }
                else {
                    llllllllllllllIIllIlIIllIIlIIIII.riddenByEntity.ridingEntity = null;
                    llllllllllllllIIllIlIIllIIlIIIII.riddenByEntity = null;
                }
            }
        }
    }
    
    public boolean isAreaLoaded(final StructureBoundingBox llllllllllllllIIllIlIllllIllllII, final boolean llllllllllllllIIllIlIllllIlllIII) {
        return this.isAreaLoaded(llllllllllllllIIllIlIllllIllllII.minX, llllllllllllllIIllIlIllllIllllII.minY, llllllllllllllIIllIlIllllIllllII.minZ, llllllllllllllIIllIlIllllIllllII.maxX, llllllllllllllIIllIlIllllIllllII.maxY, llllllllllllllIIllIlIllllIllllII.maxZ, llllllllllllllIIllIlIllllIlllIII);
    }
    
    public boolean isAABBInMaterial(final AxisAlignedBB llllllllllllllIIllIlIIlIIIlIIlII, final Material llllllllllllllIIllIlIIlIIIIlIIlI) {
        final int llllllllllllllIIllIlIIlIIIlIIIlI = MathHelper.floor_double(llllllllllllllIIllIlIIlIIIlIIlII.minX);
        final int llllllllllllllIIllIlIIlIIIlIIIIl = MathHelper.floor_double(llllllllllllllIIllIlIIlIIIlIIlII.maxX + 1.0);
        final int llllllllllllllIIllIlIIlIIIlIIIII = MathHelper.floor_double(llllllllllllllIIllIlIIlIIIlIIlII.minY);
        final int llllllllllllllIIllIlIIlIIIIlllll = MathHelper.floor_double(llllllllllllllIIllIlIIlIIIlIIlII.maxY + 1.0);
        final int llllllllllllllIIllIlIIlIIIIllllI = MathHelper.floor_double(llllllllllllllIIllIlIIlIIIlIIlII.minZ);
        final int llllllllllllllIIllIlIIlIIIIlllIl = MathHelper.floor_double(llllllllllllllIIllIlIIlIIIlIIlII.maxZ + 1.0);
        for (int llllllllllllllIIllIlIIlIIIIlllII = llllllllllllllIIllIlIIlIIIlIIIlI; llllllllllllllIIllIlIIlIIIIlllII < llllllllllllllIIllIlIIlIIIlIIIIl; ++llllllllllllllIIllIlIIlIIIIlllII) {
            for (int llllllllllllllIIllIlIIlIIIIllIll = llllllllllllllIIllIlIIlIIIlIIIII; llllllllllllllIIllIlIIlIIIIllIll < llllllllllllllIIllIlIIlIIIIlllll; ++llllllllllllllIIllIlIIlIIIIllIll) {
                for (int llllllllllllllIIllIlIIlIIIIllIlI = llllllllllllllIIllIlIIlIIIIllllI; llllllllllllllIIllIlIIlIIIIllIlI < llllllllllllllIIllIlIIlIIIIlllIl; ++llllllllllllllIIllIlIIlIIIIllIlI) {
                    final BlockPos llllllllllllllIIllIlIIlIIIIllIIl = new BlockPos(llllllllllllllIIllIlIIlIIIIlllII, llllllllllllllIIllIlIIlIIIIllIll, llllllllllllllIIllIlIIlIIIIllIlI);
                    final IBlockState llllllllllllllIIllIlIIlIIIIllIII = this.getBlockState(llllllllllllllIIllIlIIlIIIIllIIl);
                    final Block llllllllllllllIIllIlIIlIIIIlIlll = llllllllllllllIIllIlIIlIIIIllIII.getBlock();
                    if (llllllllllllllIIllIlIIlIIIIlIlll.getMaterial() == llllllllllllllIIllIlIIlIIIIlIIlI) {
                        final int llllllllllllllIIllIlIIlIIIIlIllI = (int)llllllllllllllIIllIlIIlIIIIllIII.getValue(BlockLiquid.LEVEL);
                        double llllllllllllllIIllIlIIlIIIIlIlIl = llllllllllllllIIllIlIIlIIIIllIll + 1;
                        if (llllllllllllllIIllIlIIlIIIIlIllI < 8) {
                            llllllllllllllIIllIlIIlIIIIlIlIl = llllllllllllllIIllIlIIlIIIIllIll + 1 - llllllllllllllIIllIlIIlIIIIlIllI / 8.0;
                        }
                        if (llllllllllllllIIllIlIIlIIIIlIlIl >= llllllllllllllIIllIlIIlIIIlIIlII.minY) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    
    @Override
    public TileEntity getTileEntity(final BlockPos llllllllllllllIIllIlIIIllIIlIIIl) {
        if (!this.isValid(llllllllllllllIIllIlIIIllIIlIIIl)) {
            return null;
        }
        TileEntity llllllllllllllIIllIlIIIllIIlIIII = null;
        if (this.processingLoadedTiles) {
            for (int llllllllllllllIIllIlIIIllIIIllll = 0; llllllllllllllIIllIlIIIllIIIllll < this.addedTileEntityList.size(); ++llllllllllllllIIllIlIIIllIIIllll) {
                final TileEntity llllllllllllllIIllIlIIIllIIIllIl = this.addedTileEntityList.get(llllllllllllllIIllIlIIIllIIIllll);
                if (!llllllllllllllIIllIlIIIllIIIllIl.isInvalid() && llllllllllllllIIllIlIIIllIIIllIl.getPos().equals(llllllllllllllIIllIlIIIllIIlIIIl)) {
                    llllllllllllllIIllIlIIIllIIlIIII = llllllllllllllIIllIlIIIllIIIllIl;
                    break;
                }
            }
        }
        if (llllllllllllllIIllIlIIIllIIlIIII == null) {
            llllllllllllllIIllIlIIIllIIlIIII = this.getChunkFromBlockCoords(llllllllllllllIIllIlIIIllIIlIIIl).func_177424_a(llllllllllllllIIllIlIIIllIIlIIIl, Chunk.EnumCreateEntityType.IMMEDIATE);
        }
        if (llllllllllllllIIllIlIIIllIIlIIII == null) {
            for (int llllllllllllllIIllIlIIIllIIIlllI = 0; llllllllllllllIIllIlIIIllIIIlllI < this.addedTileEntityList.size(); ++llllllllllllllIIllIlIIIllIIIlllI) {
                final TileEntity llllllllllllllIIllIlIIIllIIIllII = this.addedTileEntityList.get(llllllllllllllIIllIlIIIllIIIlllI);
                if (!llllllllllllllIIllIlIIIllIIIllII.isInvalid() && llllllllllllllIIllIlIIIllIIIllII.getPos().equals(llllllllllllllIIllIlIIIllIIlIIIl)) {
                    llllllllllllllIIllIlIIIllIIlIIII = llllllllllllllIIllIlIIIllIIIllII;
                    break;
                }
            }
        }
        return llllllllllllllIIllIlIIIllIIlIIII;
    }
    
    public boolean func_175636_b(final double llllllllllllllIIllIIlllIlIIllllI, final double llllllllllllllIIllIIlllIlIIlllIl, final double llllllllllllllIIllIIlllIlIIlllII, final double llllllllllllllIIllIIlllIlIIlIIll) {
        for (int llllllllllllllIIllIIlllIlIIllIlI = 0; llllllllllllllIIllIIlllIlIIllIlI < this.playerEntities.size(); ++llllllllllllllIIllIIlllIlIIllIlI) {
            final EntityPlayer llllllllllllllIIllIIlllIlIIllIIl = this.playerEntities.get(llllllllllllllIIllIIlllIlIIllIlI);
            if (IEntitySelector.field_180132_d.apply((Object)llllllllllllllIIllIIlllIlIIllIIl)) {
                final double llllllllllllllIIllIIlllIlIIllIII = llllllllllllllIIllIIlllIlIIllIIl.getDistanceSq(llllllllllllllIIllIIlllIlIIllllI, llllllllllllllIIllIIlllIlIIlllIl, llllllllllllllIIllIIlllIlIIlllII);
                if (llllllllllllllIIllIIlllIlIIlIIll < 0.0 || llllllllllllllIIllIIlllIlIIllIII < llllllllllllllIIllIIlllIlIIlIIll * llllllllllllllIIllIIlllIlIIlIIll) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public World init() {
        return this;
    }
    
    public boolean spawnEntityInWorld(final Entity llllllllllllllIIllIlIlIIllllIlll) {
        final int llllllllllllllIIllIlIlIIllllIllI = MathHelper.floor_double(llllllllllllllIIllIlIlIIllllIlll.posX / 16.0);
        final int llllllllllllllIIllIlIlIIllllIlIl = MathHelper.floor_double(llllllllllllllIIllIlIlIIllllIlll.posZ / 16.0);
        boolean llllllllllllllIIllIlIlIIllllIlII = llllllllllllllIIllIlIlIIllllIlll.forceSpawn;
        if (llllllllllllllIIllIlIlIIllllIlll instanceof EntityPlayer) {
            llllllllllllllIIllIlIlIIllllIlII = true;
        }
        if (!llllllllllllllIIllIlIlIIllllIlII && !this.isChunkLoaded(llllllllllllllIIllIlIlIIllllIllI, llllllllllllllIIllIlIlIIllllIlIl, true)) {
            return false;
        }
        if (llllllllllllllIIllIlIlIIllllIlll instanceof EntityPlayer) {
            final EntityPlayer llllllllllllllIIllIlIlIIllllIIll = (EntityPlayer)llllllllllllllIIllIlIlIIllllIlll;
            this.playerEntities.add(llllllllllllllIIllIlIlIIllllIIll);
            this.updateAllPlayersSleepingFlag();
        }
        this.getChunkFromChunkCoords(llllllllllllllIIllIlIlIIllllIllI, llllllllllllllIIllIlIlIIllllIlIl).addEntity(llllllllllllllIIllIlIlIIllllIlll);
        this.loadedEntityList.add(llllllllllllllIIllIlIlIIllllIlll);
        this.onEntityAdded(llllllllllllllIIllIlIlIIllllIlll);
        return true;
    }
    
    public List getPendingBlockUpdates(final Chunk llllllllllllllIIllIlIIIIIIIIIllI, final boolean llllllllllllllIIllIlIIIIIIIIIlIl) {
        return null;
    }
    
    public MovingObjectPosition rayTraceBlocks(final Vec3 llllllllllllllIIllIlIllIIIIlIlll, final Vec3 llllllllllllllIIllIlIllIIIIllIlI, final boolean llllllllllllllIIllIlIllIIIIlIlIl) {
        return this.rayTraceBlocks(llllllllllllllIIllIlIllIIIIlIlll, llllllllllllllIIllIlIllIIIIllIlI, llllllllllllllIIllIlIllIIIIlIlIl, false, false);
    }
    
    protected void func_147456_g() {
        this.setActivePlayerChunksAndCheckLight();
    }
    
    public void markBlockRangeForRenderUpdate(final BlockPos llllllllllllllIIllIlIlllIIIlllII, final BlockPos llllllllllllllIIllIlIlllIIIllIll) {
        this.markBlockRangeForRenderUpdate(llllllllllllllIIllIlIlllIIIlllII.getX(), llllllllllllllIIllIlIlllIIIlllII.getY(), llllllllllllllIIllIlIlllIIIlllII.getZ(), llllllllllllllIIllIlIlllIIIllIll.getX(), llllllllllllllIIllIlIlllIIIllIll.getY(), llllllllllllllIIllIlIlllIIIllIll.getZ());
    }
    
    public GameRules getGameRules() {
        return this.worldInfo.getGameRulesInstance();
    }
    
    public String getProviderName() {
        return this.chunkProvider.makeString();
    }
    
    public boolean isDaytime() {
        return this.skylightSubtracted < 4;
    }
    
    public void addWorldAccess(final IWorldAccess llllllllllllllIIllIlIlIIllIIIIll) {
        this.worldAccesses.add(llllllllllllllIIllIlIlIIllIIIIll);
    }
    
    public void scheduleUpdate(final BlockPos llllllllllllllIIllIlIIlllIIIllII, final Block llllllllllllllIIllIlIIlllIIIlIll, final int llllllllllllllIIllIlIIlllIIIlIlI) {
    }
    
    private boolean isValid(final BlockPos llllllllllllllIIllIllIIIIIIIIlll) {
        return llllllllllllllIIllIllIIIIIIIIlll.getX() >= -30000000 && llllllllllllllIIllIllIIIIIIIIlll.getZ() >= -30000000 && llllllllllllllIIllIllIIIIIIIIlll.getX() < 30000000 && llllllllllllllIIllIllIIIIIIIIlll.getZ() < 30000000 && llllllllllllllIIllIllIIIIIIIIlll.getY() >= 0 && llllllllllllllIIllIllIIIIIIIIlll.getY() < 256;
    }
    
    public Explosion newExplosion(final Entity llllllllllllllIIllIlIIIllllIIlII, final double llllllllllllllIIllIlIIIlllIllIlI, final double llllllllllllllIIllIlIIIlllIllIIl, final double llllllllllllllIIllIlIIIlllIllIII, final float llllllllllllllIIllIlIIIlllIlIlll, final boolean llllllllllllllIIllIlIIIlllIlllll, final boolean llllllllllllllIIllIlIIIlllIlIlIl) {
        final Explosion llllllllllllllIIllIlIIIlllIlllIl = new Explosion(this, llllllllllllllIIllIlIIIllllIIlII, llllllllllllllIIllIlIIIlllIllIlI, llllllllllllllIIllIlIIIlllIllIIl, llllllllllllllIIllIlIIIlllIllIII, llllllllllllllIIllIlIIIlllIlIlll, llllllllllllllIIllIlIIIlllIlllll, llllllllllllllIIllIlIIIlllIlIlIl);
        llllllllllllllIIllIlIIIlllIlllIl.doExplosionA();
        llllllllllllllIIllIlIIIlllIlllIl.doExplosionB(true);
        return llllllllllllllIIllIlIIIlllIlllIl;
    }
    
    public void sendQuittingDisconnectingPacket() {
    }
    
    public void playSound(final double llllllllllllllIIllIlIlIlIlllIIIl, final double llllllllllllllIIllIlIlIlIlllIIII, final double llllllllllllllIIllIlIlIlIllIllll, final String llllllllllllllIIllIlIlIlIllIlllI, final float llllllllllllllIIllIlIlIlIllIllIl, final float llllllllllllllIIllIlIlIlIllIllII, final boolean llllllllllllllIIllIlIlIlIllIlIll) {
    }
    
    public float getSunBrightness(final float llllllllllllllIIllIlIlIIIIllIIIl) {
        final float llllllllllllllIIllIlIlIIIIllIlII = this.getCelestialAngle(llllllllllllllIIllIlIlIIIIllIIIl);
        float llllllllllllllIIllIlIlIIIIllIIll = 1.0f - (MathHelper.cos(llllllllllllllIIllIlIlIIIIllIlII * 3.1415927f * 2.0f) * 2.0f + 0.2f);
        llllllllllllllIIllIlIlIIIIllIIll = MathHelper.clamp_float(llllllllllllllIIllIlIlIIIIllIIll, 0.0f, 1.0f);
        llllllllllllllIIllIlIlIIIIllIIll = 1.0f - llllllllllllllIIllIlIlIIIIllIIll;
        llllllllllllllIIllIlIlIIIIllIIll *= (float)(1.0 - this.getRainStrength(llllllllllllllIIllIlIlIIIIllIIIl) * 5.0f / 16.0);
        llllllllllllllIIllIlIlIIIIllIIll *= (float)(1.0 - this.getWeightedThunderStrength(llllllllllllllIIllIlIlIIIIllIIIl) * 5.0f / 16.0);
        return llllllllllllllIIllIlIlIIIIllIIll * 0.8f + 0.2f;
    }
    
    public int func_175687_A(final BlockPos llllllllllllllIIllIIlllIllIlllIl) {
        int llllllllllllllIIllIIlllIllIlllII = 0;
        for (final EnumFacing llllllllllllllIIllIIlllIllIllIII : EnumFacing.values()) {
            final int llllllllllllllIIllIIlllIllIlIlll = this.getRedstonePower(llllllllllllllIIllIIlllIllIlllIl.offset(llllllllllllllIIllIIlllIllIllIII), llllllllllllllIIllIIlllIllIllIII);
            if (llllllllllllllIIllIIlllIllIlIlll >= 15) {
                return 15;
            }
            if (llllllllllllllIIllIIlllIllIlIlll > llllllllllllllIIllIIlllIllIlllII) {
                llllllllllllllIIllIIlllIllIlllII = llllllllllllllIIllIIlllIllIlIlll;
            }
        }
        return llllllllllllllIIllIIlllIllIlllII;
    }
    
    public void setItemData(final String llllllllllllllIIllIIllIllllIIIIl, final WorldSavedData llllllllllllllIIllIIllIllllIIIll) {
        this.mapStorage.setData(llllllllllllllIIllIIllIllllIIIIl, llllllllllllllIIllIIllIllllIIIll);
    }
    
    public Vec3 getSkyColor(final Entity llllllllllllllIIllIlIlIIIIIIIlII, final float llllllllllllllIIllIlIlIIIIIIIIll) {
        final float llllllllllllllIIllIlIlIIIIIllIII = this.getCelestialAngle(llllllllllllllIIllIlIlIIIIIIIIll);
        float llllllllllllllIIllIlIlIIIIIlIlll = MathHelper.cos(llllllllllllllIIllIlIlIIIIIllIII * 3.1415927f * 2.0f) * 2.0f + 0.5f;
        llllllllllllllIIllIlIlIIIIIlIlll = MathHelper.clamp_float(llllllllllllllIIllIlIlIIIIIlIlll, 0.0f, 1.0f);
        final int llllllllllllllIIllIlIlIIIIIlIllI = MathHelper.floor_double(llllllllllllllIIllIlIlIIIIIIIlII.posX);
        final int llllllllllllllIIllIlIlIIIIIlIlIl = MathHelper.floor_double(llllllllllllllIIllIlIlIIIIIIIlII.posY);
        final int llllllllllllllIIllIlIlIIIIIlIlII = MathHelper.floor_double(llllllllllllllIIllIlIlIIIIIIIlII.posZ);
        final BlockPos llllllllllllllIIllIlIlIIIIIlIIll = new BlockPos(llllllllllllllIIllIlIlIIIIIlIllI, llllllllllllllIIllIlIlIIIIIlIlIl, llllllllllllllIIllIlIlIIIIIlIlII);
        final BiomeGenBase llllllllllllllIIllIlIlIIIIIlIIlI = this.getBiomeGenForCoords(llllllllllllllIIllIlIlIIIIIlIIll);
        final float llllllllllllllIIllIlIlIIIIIlIIIl = llllllllllllllIIllIlIlIIIIIlIIlI.func_180626_a(llllllllllllllIIllIlIlIIIIIlIIll);
        final int llllllllllllllIIllIlIlIIIIIlIIII = llllllllllllllIIllIlIlIIIIIlIIlI.getSkyColorByTemp(llllllllllllllIIllIlIlIIIIIlIIIl);
        float llllllllllllllIIllIlIlIIIIIIllll = (llllllllllllllIIllIlIlIIIIIlIIII >> 16 & 0xFF) / 255.0f;
        float llllllllllllllIIllIlIlIIIIIIlllI = (llllllllllllllIIllIlIlIIIIIlIIII >> 8 & 0xFF) / 255.0f;
        float llllllllllllllIIllIlIlIIIIIIllIl = (llllllllllllllIIllIlIlIIIIIlIIII & 0xFF) / 255.0f;
        llllllllllllllIIllIlIlIIIIIIllll *= llllllllllllllIIllIlIlIIIIIlIlll;
        llllllllllllllIIllIlIlIIIIIIlllI *= llllllllllllllIIllIlIlIIIIIlIlll;
        llllllllllllllIIllIlIlIIIIIIllIl *= llllllllllllllIIllIlIlIIIIIlIlll;
        final float llllllllllllllIIllIlIlIIIIIIllII = this.getRainStrength(llllllllllllllIIllIlIlIIIIIIIIll);
        if (llllllllllllllIIllIlIlIIIIIIllII > 0.0f) {
            final float llllllllllllllIIllIlIlIIIIIIlIll = (llllllllllllllIIllIlIlIIIIIIllll * 0.3f + llllllllllllllIIllIlIlIIIIIIlllI * 0.59f + llllllllllllllIIllIlIlIIIIIIllIl * 0.11f) * 0.6f;
            final float llllllllllllllIIllIlIlIIIIIIlIIl = 1.0f - llllllllllllllIIllIlIlIIIIIIllII * 0.75f;
            llllllllllllllIIllIlIlIIIIIIllll = llllllllllllllIIllIlIlIIIIIIllll * llllllllllllllIIllIlIlIIIIIIlIIl + llllllllllllllIIllIlIlIIIIIIlIll * (1.0f - llllllllllllllIIllIlIlIIIIIIlIIl);
            llllllllllllllIIllIlIlIIIIIIlllI = llllllllllllllIIllIlIlIIIIIIlllI * llllllllllllllIIllIlIlIIIIIIlIIl + llllllllllllllIIllIlIlIIIIIIlIll * (1.0f - llllllllllllllIIllIlIlIIIIIIlIIl);
            llllllllllllllIIllIlIlIIIIIIllIl = llllllllllllllIIllIlIlIIIIIIllIl * llllllllllllllIIllIlIlIIIIIIlIIl + llllllllllllllIIllIlIlIIIIIIlIll * (1.0f - llllllllllllllIIllIlIlIIIIIIlIIl);
        }
        final float llllllllllllllIIllIlIlIIIIIIlIlI = this.getWeightedThunderStrength(llllllllllllllIIllIlIlIIIIIIIIll);
        if (llllllllllllllIIllIlIlIIIIIIlIlI > 0.0f) {
            final float llllllllllllllIIllIlIlIIIIIIlIII = (llllllllllllllIIllIlIlIIIIIIllll * 0.3f + llllllllllllllIIllIlIlIIIIIIlllI * 0.59f + llllllllllllllIIllIlIlIIIIIIllIl * 0.11f) * 0.2f;
            final float llllllllllllllIIllIlIlIIIIIIIllI = 1.0f - llllllllllllllIIllIlIlIIIIIIlIlI * 0.75f;
            llllllllllllllIIllIlIlIIIIIIllll = llllllllllllllIIllIlIlIIIIIIllll * llllllllllllllIIllIlIlIIIIIIIllI + llllllllllllllIIllIlIlIIIIIIlIII * (1.0f - llllllllllllllIIllIlIlIIIIIIIllI);
            llllllllllllllIIllIlIlIIIIIIlllI = llllllllllllllIIllIlIlIIIIIIlllI * llllllllllllllIIllIlIlIIIIIIIllI + llllllllllllllIIllIlIlIIIIIIlIII * (1.0f - llllllllllllllIIllIlIlIIIIIIIllI);
            llllllllllllllIIllIlIlIIIIIIllIl = llllllllllllllIIllIlIlIIIIIIllIl * llllllllllllllIIllIlIlIIIIIIIllI + llllllllllllllIIllIlIlIIIIIIlIII * (1.0f - llllllllllllllIIllIlIlIIIIIIIllI);
        }
        if (this.lastLightningBolt > 0) {
            float llllllllllllllIIllIlIlIIIIIIIlll = this.lastLightningBolt - llllllllllllllIIllIlIlIIIIIIIIll;
            if (llllllllllllllIIllIlIlIIIIIIIlll > 1.0f) {
                llllllllllllllIIllIlIlIIIIIIIlll = 1.0f;
            }
            llllllllllllllIIllIlIlIIIIIIIlll *= 0.45f;
            llllllllllllllIIllIlIlIIIIIIllll = llllllllllllllIIllIlIlIIIIIIllll * (1.0f - llllllllllllllIIllIlIlIIIIIIIlll) + 0.8f * llllllllllllllIIllIlIlIIIIIIIlll;
            llllllllllllllIIllIlIlIIIIIIlllI = llllllllllllllIIllIlIlIIIIIIlllI * (1.0f - llllllllllllllIIllIlIlIIIIIIIlll) + 0.8f * llllllllllllllIIllIlIlIIIIIIIlll;
            llllllllllllllIIllIlIlIIIIIIllIl = llllllllllllllIIllIlIlIIIIIIllIl * (1.0f - llllllllllllllIIllIlIlIIIIIIIlll) + 1.0f * llllllllllllllIIllIlIlIIIIIIIlll;
        }
        return new Vec3(llllllllllllllIIllIlIlIIIIIIllll, llllllllllllllIIllIlIlIIIIIIlllI, llllllllllllllIIllIlIlIIIIIIllIl);
    }
    
    public int calculateSkylightSubtracted(final float llllllllllllllIIllIlIlIIIIllllIl) {
        final float llllllllllllllIIllIlIlIIIlIIIIII = this.getCelestialAngle(llllllllllllllIIllIlIlIIIIllllIl);
        float llllllllllllllIIllIlIlIIIIllllll = 1.0f - (MathHelper.cos(llllllllllllllIIllIlIlIIIlIIIIII * 3.1415927f * 2.0f) * 2.0f + 0.5f);
        llllllllllllllIIllIlIlIIIIllllll = MathHelper.clamp_float(llllllllllllllIIllIlIlIIIIllllll, 0.0f, 1.0f);
        llllllllllllllIIllIlIlIIIIllllll = 1.0f - llllllllllllllIIllIlIlIIIIllllll;
        llllllllllllllIIllIlIlIIIIllllll *= (float)(1.0 - this.getRainStrength(llllllllllllllIIllIlIlIIIIllllIl) * 5.0f / 16.0);
        llllllllllllllIIllIlIlIIIIllllll *= (float)(1.0 - this.getWeightedThunderStrength(llllllllllllllIIllIlIlIIIIllllIl) * 5.0f / 16.0);
        llllllllllllllIIllIlIlIIIIllllll = 1.0f - llllllllllllllIIllIlIlIIIIllllll;
        return (int)(llllllllllllllIIllIlIlIIIIllllll * 11.0f);
    }
    
    public boolean isBlockLoaded(final BlockPos llllllllllllllIIllIlIlllllllIIlI, final boolean llllllllllllllIIllIlIlllllllIIIl) {
        return this.isValid(llllllllllllllIIllIlIlllllllIIlI) && this.isChunkLoaded(llllllllllllllIIllIlIlllllllIIlI.getX() >> 4, llllllllllllllIIllIlIlllllllIIlI.getZ() >> 4, llllllllllllllIIllIlIlllllllIIIl);
    }
    
    public boolean setBlockState(final BlockPos llllllllllllllIIllIlIlllIllIllIl, final IBlockState llllllllllllllIIllIlIlllIllIllII, final int llllllllllllllIIllIlIlllIlllIIll) {
        if (!this.isValid(llllllllllllllIIllIlIlllIllIllIl)) {
            return false;
        }
        if (!this.isRemote && this.worldInfo.getTerrainType() == WorldType.DEBUG_WORLD) {
            return false;
        }
        final Chunk llllllllllllllIIllIlIlllIlllIIlI = this.getChunkFromBlockCoords(llllllllllllllIIllIlIlllIllIllIl);
        final Block llllllllllllllIIllIlIlllIlllIIIl = llllllllllllllIIllIlIlllIllIllII.getBlock();
        final IBlockState llllllllllllllIIllIlIlllIlllIIII = llllllllllllllIIllIlIlllIlllIIlI.setBlockState(llllllllllllllIIllIlIlllIllIllIl, llllllllllllllIIllIlIlllIllIllII);
        if (llllllllllllllIIllIlIlllIlllIIII == null) {
            return false;
        }
        final Block llllllllllllllIIllIlIlllIllIllll = llllllllllllllIIllIlIlllIlllIIII.getBlock();
        if (llllllllllllllIIllIlIlllIlllIIIl.getLightOpacity() != llllllllllllllIIllIlIlllIllIllll.getLightOpacity() || llllllllllllllIIllIlIlllIlllIIIl.getLightValue() != llllllllllllllIIllIlIlllIllIllll.getLightValue()) {
            this.theProfiler.startSection("checkLight");
            this.checkLight(llllllllllllllIIllIlIlllIllIllIl);
            this.theProfiler.endSection();
        }
        if ((llllllllllllllIIllIlIlllIlllIIll & 0x2) != 0x0 && (!this.isRemote || (llllllllllllllIIllIlIlllIlllIIll & 0x4) == 0x0) && llllllllllllllIIllIlIlllIlllIIlI.isPopulated()) {
            this.markBlockForUpdate(llllllllllllllIIllIlIlllIllIllIl);
        }
        if (!this.isRemote && (llllllllllllllIIllIlIlllIlllIIll & 0x1) != 0x0) {
            this.func_175722_b(llllllllllllllIIllIlIlllIllIllIl, llllllllllllllIIllIlIlllIlllIIII.getBlock());
            if (llllllllllllllIIllIlIlllIlllIIIl.hasComparatorInputOverride()) {
                this.updateComparatorOutputLevel(llllllllllllllIIllIlIlllIllIllIl, llllllllllllllIIllIlIlllIlllIIIl);
            }
        }
        return true;
    }
    
    public CrashReportCategory addWorldInfoToCrashReport(final CrashReport llllllllllllllIIllIIllIlIlllIlll) {
        final CrashReportCategory llllllllllllllIIllIIllIlIlllIllI = llllllllllllllIIllIIllIlIlllIlll.makeCategoryDepth("Affected level", 1);
        llllllllllllllIIllIIllIlIlllIllI.addCrashSection("Level name", (this.worldInfo == null) ? "????" : this.worldInfo.getWorldName());
        llllllllllllllIIllIIllIlIlllIllI.addCrashSectionCallable("All players", new Callable() {
            static {
                __OBFID = "CL_00000143";
            }
            
            @Override
            public String call() {
                return String.valueOf(new StringBuilder(String.valueOf(World.this.playerEntities.size())).append(" total; ").append(World.this.playerEntities.toString()));
            }
        });
        llllllllllllllIIllIIllIlIlllIllI.addCrashSectionCallable("Chunk stats", new Callable() {
            @Override
            public String call() {
                return World.this.chunkProvider.makeString();
            }
            
            static {
                __OBFID = "CL_00000144";
            }
        });
        try {
            this.worldInfo.addToCrashReport(llllllllllllllIIllIIllIlIlllIllI);
        }
        catch (Throwable llllllllllllllIIllIIllIlIlllIlIl) {
            llllllllllllllIIllIIllIlIlllIllI.addCrashSectionThrowable("Level Data Unobtainable", llllllllllllllIIllIIllIlIlllIlIl);
        }
        return llllllllllllllIIllIIllIlIlllIllI;
    }
    
    public int getRedstonePower(final BlockPos llllllllllllllIIllIIlllIllllIIII, final EnumFacing llllllllllllllIIllIIlllIllllIlII) {
        final IBlockState llllllllllllllIIllIIlllIllllIIll = this.getBlockState(llllllllllllllIIllIIlllIllllIIII);
        final Block llllllllllllllIIllIIlllIllllIIlI = llllllllllllllIIllIIlllIllllIIll.getBlock();
        return llllllllllllllIIllIIlllIllllIIlI.isNormalCube() ? this.getStrongPower(llllllllllllllIIllIIlllIllllIIII) : llllllllllllllIIllIIlllIllllIIlI.isProvidingWeakPower(this, llllllllllllllIIllIIlllIllllIIII, llllllllllllllIIllIIlllIllllIIll, llllllllllllllIIllIIlllIllllIlII);
    }
    
    public long getWorldTime() {
        return this.worldInfo.getWorldTime();
    }
    
    public List getLoadedEntityList() {
        return this.loadedEntityList;
    }
    
    public boolean isThundering() {
        return this.getWeightedThunderStrength(1.0f) > 0.9;
    }
    
    public void setTileEntity(final BlockPos llllllllllllllIIllIlIIIlIllllIll, final TileEntity llllllllllllllIIllIlIIIlIllllIlI) {
        if (llllllllllllllIIllIlIIIlIllllIlI != null && !llllllllllllllIIllIlIIIlIllllIlI.isInvalid()) {
            if (this.processingLoadedTiles) {
                llllllllllllllIIllIlIIIlIllllIlI.setPos(llllllllllllllIIllIlIIIlIllllIll);
                final Iterator llllllllllllllIIllIlIIIlIllllllI = this.addedTileEntityList.iterator();
                while (llllllllllllllIIllIlIIIlIllllllI.hasNext()) {
                    final TileEntity llllllllllllllIIllIlIIIlIlllllIl = llllllllllllllIIllIlIIIlIllllllI.next();
                    if (llllllllllllllIIllIlIIIlIlllllIl.getPos().equals(llllllllllllllIIllIlIIIlIllllIll)) {
                        llllllllllllllIIllIlIIIlIlllllIl.invalidate();
                        llllllllllllllIIllIlIIIlIllllllI.remove();
                    }
                }
                this.addedTileEntityList.add(llllllllllllllIIllIlIIIlIllllIlI);
            }
            else {
                this.addTileEntity(llllllllllllllIIllIlIIIlIllllIlI);
                this.getChunkFromBlockCoords(llllllllllllllIIllIlIIIlIllllIll).addTileEntity(llllllllllllllIIllIlIIIlIllllIll, llllllllllllllIIllIlIIIlIllllIlI);
            }
        }
    }
    
    public List func_175644_a(final Class llllllllllllllIIllIIllllllIlIIII, final Predicate llllllllllllllIIllIIllllllIIllll) {
        final ArrayList llllllllllllllIIllIIllllllIIlllI = Lists.newArrayList();
        for (final Entity llllllllllllllIIllIIllllllIIllII : this.loadedEntityList) {
            if (llllllllllllllIIllIIllllllIlIIII.isAssignableFrom(llllllllllllllIIllIIllllllIIllII.getClass()) && llllllllllllllIIllIIllllllIIllll.apply((Object)llllllllllllllIIllIIllllllIIllII)) {
                llllllllllllllIIllIIllllllIIlllI.add(llllllllllllllIIllIIllllllIIllII);
            }
        }
        return llllllllllllllIIllIIllllllIIlllI;
    }
    
    public boolean checkNoEntityCollision(final AxisAlignedBB llllllllllllllIIllIlIIllIIIIIlIl, final Entity llllllllllllllIIllIlIIllIIIIlIlI) {
        final List llllllllllllllIIllIlIIllIIIIlIIl = this.getEntitiesWithinAABBExcludingEntity(null, llllllllllllllIIllIlIIllIIIIIlIl);
        for (int llllllllllllllIIllIlIIllIIIIlIII = 0; llllllllllllllIIllIlIIllIIIIlIII < llllllllllllllIIllIlIIllIIIIlIIl.size(); ++llllllllllllllIIllIlIIllIIIIlIII) {
            final Entity llllllllllllllIIllIlIIllIIIIIlll = llllllllllllllIIllIlIIllIIIIlIIl.get(llllllllllllllIIllIlIIllIIIIlIII);
            if (!llllllllllllllIIllIlIIllIIIIIlll.isDead && llllllllllllllIIllIlIIllIIIIIlll.preventEntitySpawning && llllllllllllllIIllIlIIllIIIIIlll != llllllllllllllIIllIlIIllIIIIlIlI && (llllllllllllllIIllIlIIllIIIIlIlI == null || (llllllllllllllIIllIlIIllIIIIlIlI.ridingEntity != llllllllllllllIIllIlIIllIIIIIlll && llllllllllllllIIllIlIIllIIIIlIlI.riddenByEntity != llllllllllllllIIllIlIIllIIIIIlll))) {
                return false;
            }
        }
        return true;
    }
    
    public Random setRandomSeed(final int llllllllllllllIIllIIllIllIIlIIlI, final int llllllllllllllIIllIIllIllIIlIIIl, final int llllllllllllllIIllIIllIllIIIlIll) {
        final long llllllllllllllIIllIIllIllIIIllll = llllllllllllllIIllIIllIllIIlIIlI * 341873128712L + llllllllllllllIIllIIllIllIIlIIIl * 132897987541L + this.getWorldInfo().getSeed() + llllllllllllllIIllIIllIllIIIlIll;
        this.rand.setSeed(llllllllllllllIIllIIllIllIIIllll);
        return this.rand;
    }
    
    public void setEntityState(final Entity llllllllllllllIIllIIlllIIIlllIIl, final byte llllllllllllllIIllIIlllIIIlllIII) {
    }
    
    protected void setActivePlayerChunksAndCheckLight() {
        this.activeChunkSet.clear();
        this.theProfiler.startSection("buildList");
        for (int llllllllllllllIIllIlIIIlIIIlIlll = 0; llllllllllllllIIllIlIIIlIIIlIlll < this.playerEntities.size(); ++llllllllllllllIIllIlIIIlIIIlIlll) {
            final EntityPlayer llllllllllllllIIllIlIIIlIIIlIllI = this.playerEntities.get(llllllllllllllIIllIlIIIlIIIlIlll);
            final int llllllllllllllIIllIlIIIlIIIlIlII = MathHelper.floor_double(llllllllllllllIIllIlIIIlIIIlIllI.posX / 16.0);
            final int llllllllllllllIIllIlIIIlIIIlIIlI = MathHelper.floor_double(llllllllllllllIIllIlIIIlIIIlIllI.posZ / 16.0);
            for (int llllllllllllllIIllIlIIIlIIIlIIII = this.getRenderDistanceChunks(), llllllllllllllIIllIlIIIlIIIIlllI = -llllllllllllllIIllIlIIIlIIIlIIII; llllllllllllllIIllIlIIIlIIIIlllI <= llllllllllllllIIllIlIIIlIIIlIIII; ++llllllllllllllIIllIlIIIlIIIIlllI) {
                for (int llllllllllllllIIllIlIIIlIIIIllIl = -llllllllllllllIIllIlIIIlIIIlIIII; llllllllllllllIIllIlIIIlIIIIllIl <= llllllllllllllIIllIlIIIlIIIlIIII; ++llllllllllllllIIllIlIIIlIIIIllIl) {
                    this.activeChunkSet.add(new ChunkCoordIntPair(llllllllllllllIIllIlIIIlIIIIlllI + llllllllllllllIIllIlIIIlIIIlIlII, llllllllllllllIIllIlIIIlIIIIllIl + llllllllllllllIIllIlIIIlIIIlIIlI));
                }
            }
        }
        this.theProfiler.endSection();
        if (this.ambientTickCountdown > 0) {
            --this.ambientTickCountdown;
        }
        this.theProfiler.startSection("playerCheckLight");
        if (!this.playerEntities.isEmpty()) {
            final int llllllllllllllIIllIlIIIlIIIlIlll = this.rand.nextInt(this.playerEntities.size());
            final EntityPlayer llllllllllllllIIllIlIIIlIIIlIlIl = this.playerEntities.get(llllllllllllllIIllIlIIIlIIIlIlll);
            final int llllllllllllllIIllIlIIIlIIIlIIll = MathHelper.floor_double(llllllllllllllIIllIlIIIlIIIlIlIl.posX) + this.rand.nextInt(11) - 5;
            final int llllllllllllllIIllIlIIIlIIIlIIIl = MathHelper.floor_double(llllllllllllllIIllIlIIIlIIIlIlIl.posY) + this.rand.nextInt(11) - 5;
            final int llllllllllllllIIllIlIIIlIIIIllll = MathHelper.floor_double(llllllllllllllIIllIlIIIlIIIlIlIl.posZ) + this.rand.nextInt(11) - 5;
            this.checkLight(new BlockPos(llllllllllllllIIllIlIIIlIIIlIIll, llllllllllllllIIllIlIIIlIIIlIIIl, llllllllllllllIIllIlIIIlIIIIllll));
        }
        this.theProfiler.endSection();
    }
    
    public void playAuxSFX(final int llllllllllllllIIllIIllIllIllllII, final BlockPos llllllllllllllIIllIIllIllIllIlll, final int llllllllllllllIIllIIllIllIlllIlI) {
        this.playAuxSFXAtEntity(null, llllllllllllllIIllIIllIllIllllII, llllllllllllllIIllIIllIllIllIlll, llllllllllllllIIllIIllIllIlllIlI);
    }
    
    public Entity findNearestEntityWithinAABB(final Class llllllllllllllIIllIIllllIllllllI, final AxisAlignedBB llllllllllllllIIllIIllllIlllllIl, final Entity llllllllllllllIIllIIllllIlllllII) {
        final List llllllllllllllIIllIIllllIllllIll = this.getEntitiesWithinAABB(llllllllllllllIIllIIllllIllllllI, llllllllllllllIIllIIllllIlllllIl);
        Entity llllllllllllllIIllIIllllIllllIlI = null;
        double llllllllllllllIIllIIllllIllllIIl = Double.MAX_VALUE;
        for (int llllllllllllllIIllIIllllIllllIII = 0; llllllllllllllIIllIIllllIllllIII < llllllllllllllIIllIIllllIllllIll.size(); ++llllllllllllllIIllIIllllIllllIII) {
            final Entity llllllllllllllIIllIIllllIlllIlll = llllllllllllllIIllIIllllIllllIll.get(llllllllllllllIIllIIllllIllllIII);
            if (llllllllllllllIIllIIllllIlllIlll != llllllllllllllIIllIIllllIlllllII && IEntitySelector.field_180132_d.apply((Object)llllllllllllllIIllIIllllIlllIlll)) {
                final double llllllllllllllIIllIIllllIlllIllI = llllllllllllllIIllIIllllIlllllII.getDistanceSqToEntity(llllllllllllllIIllIIllllIlllIlll);
                if (llllllllllllllIIllIIllllIlllIllI <= llllllllllllllIIllIIllllIllllIIl) {
                    llllllllllllllIIllIIllllIllllIlI = llllllllllllllIIllIIllllIlllIlll;
                    llllllllllllllIIllIIllllIllllIIl = llllllllllllllIIllIIllllIlllIllI;
                }
            }
        }
        return llllllllllllllIIllIIllllIllllIlI;
    }
    
    public boolean isAgainstSky(final BlockPos llllllllllllllIIllIlIllIllIlIIlI) {
        return this.getChunkFromBlockCoords(llllllllllllllIIllIlIllIllIlIIlI).canSeeSky(llllllllllllllIIllIlIllIllIlIIlI);
    }
    
    public void playAuxSFXAtEntity(final EntityPlayer llllllllllllllIIllIIllIllIlIIIll, final int llllllllllllllIIllIIllIllIlIlIll, final BlockPos llllllllllllllIIllIIllIllIlIlIlI, final int llllllllllllllIIllIIllIllIlIlIIl) {
        try {
            for (int llllllllllllllIIllIIllIllIlIlIII = 0; llllllllllllllIIllIIllIllIlIlIII < this.worldAccesses.size(); ++llllllllllllllIIllIIllIllIlIlIII) {
                this.worldAccesses.get(llllllllllllllIIllIIllIllIlIlIII).func_180439_a(llllllllllllllIIllIIllIllIlIIIll, llllllllllllllIIllIIllIllIlIlIll, llllllllllllllIIllIIllIllIlIlIlI, llllllllllllllIIllIIllIllIlIlIIl);
            }
        }
        catch (Throwable llllllllllllllIIllIIllIllIlIIlll) {
            final CrashReport llllllllllllllIIllIIllIllIlIIllI = CrashReport.makeCrashReport(llllllllllllllIIllIIllIllIlIIlll, "Playing level event");
            final CrashReportCategory llllllllllllllIIllIIllIllIlIIlIl = llllllllllllllIIllIIllIllIlIIllI.makeCategory("Level event being played");
            llllllllllllllIIllIIllIllIlIIlIl.addCrashSection("Block coordinates", CrashReportCategory.getCoordinateInfo(llllllllllllllIIllIIllIllIlIlIlI));
            llllllllllllllIIllIIllIllIlIIlIl.addCrashSection("Event source", llllllllllllllIIllIIllIllIlIIIll);
            llllllllllllllIIllIIllIllIlIIlIl.addCrashSection("Event type", llllllllllllllIIllIIllIllIlIlIll);
            llllllllllllllIIllIIllIllIlIIlIl.addCrashSection("Event data", llllllllllllllIIllIIllIllIlIlIIl);
            throw new ReportedException(llllllllllllllIIllIIllIllIlIIllI);
        }
    }
    
    public EntityPlayer getClosestPlayer(final double llllllllllllllIIllIIlllIlIlllIlI, final double llllllllllllllIIllIIlllIlIlIllll, final double llllllllllllllIIllIIlllIlIlIlllI, final double llllllllllllllIIllIIlllIlIlIllIl) {
        double llllllllllllllIIllIIlllIlIllIllI = -1.0;
        EntityPlayer llllllllllllllIIllIIlllIlIllIlIl = null;
        for (int llllllllllllllIIllIIlllIlIllIlII = 0; llllllllllllllIIllIIlllIlIllIlII < this.playerEntities.size(); ++llllllllllllllIIllIIlllIlIllIlII) {
            final EntityPlayer llllllllllllllIIllIIlllIlIllIIll = this.playerEntities.get(llllllllllllllIIllIIlllIlIllIlII);
            if (IEntitySelector.field_180132_d.apply((Object)llllllllllllllIIllIIlllIlIllIIll)) {
                final double llllllllllllllIIllIIlllIlIllIIlI = llllllllllllllIIllIIlllIlIllIIll.getDistanceSq(llllllllllllllIIllIIlllIlIlllIlI, llllllllllllllIIllIIlllIlIlIllll, llllllllllllllIIllIIlllIlIlIlllI);
                if ((llllllllllllllIIllIIlllIlIlIllIl < 0.0 || llllllllllllllIIllIIlllIlIllIIlI < llllllllllllllIIllIIlllIlIlIllIl * llllllllllllllIIllIIlllIlIlIllIl) && (llllllllllllllIIllIIlllIlIllIllI == -1.0 || llllllllllllllIIllIIlllIlIllIIlI < llllllllllllllIIllIIlllIlIllIllI)) {
                    llllllllllllllIIllIIlllIlIllIllI = llllllllllllllIIllIIlllIlIllIIlI;
                    llllllllllllllIIllIIlllIlIllIlIl = llllllllllllllIIllIIlllIlIllIIll;
                }
            }
        }
        return llllllllllllllIIllIIlllIlIllIlIl;
    }
    
    public EntityPlayer getPlayerEntityByName(final String llllllllllllllIIllIIlllIlIIIIllI) {
        for (int llllllllllllllIIllIIlllIlIIIlIIl = 0; llllllllllllllIIllIIlllIlIIIlIIl < this.playerEntities.size(); ++llllllllllllllIIllIIlllIlIIIlIIl) {
            final EntityPlayer llllllllllllllIIllIIlllIlIIIlIII = this.playerEntities.get(llllllllllllllIIllIIlllIlIIIlIIl);
            if (llllllllllllllIIllIIlllIlIIIIllI.equals(llllllllllllllIIllIIlllIlIIIlIII.getName())) {
                return llllllllllllllIIllIIlllIlIIIlIII;
            }
        }
        return null;
    }
    
    public int getLightFromNeighborsFor(final EnumSkyBlock llllllllllllllIIllIlIllIIlllIlIl, BlockPos llllllllllllllIIllIlIllIIlllIlII) {
        if (this.provider.getHasNoSky() && llllllllllllllIIllIlIllIIlllIlIl == EnumSkyBlock.SKY) {
            return 0;
        }
        if (((Vec3i)llllllllllllllIIllIlIllIIlllIlII).getY() < 0) {
            llllllllllllllIIllIlIllIIlllIlII = (Comparable<Boolean>)new BlockPos(((Vec3i)llllllllllllllIIllIlIllIIlllIlII).getX(), 0, ((Vec3i)llllllllllllllIIllIlIllIIlllIlII).getZ());
        }
        if (!this.isValid((BlockPos)llllllllllllllIIllIlIllIIlllIlII)) {
            return llllllllllllllIIllIlIllIIlllIlIl.defaultLightValue;
        }
        if (!this.isBlockLoaded((BlockPos)llllllllllllllIIllIlIllIIlllIlII)) {
            return llllllllllllllIIllIlIllIIlllIlIl.defaultLightValue;
        }
        if (this.getBlockState((BlockPos)llllllllllllllIIllIlIllIIlllIlII).getBlock().getUseNeighborBrightness()) {
            int llllllllllllllIIllIlIllIIlllllII = this.getLightFor(llllllllllllllIIllIlIllIIlllIlIl, ((BlockPos)llllllllllllllIIllIlIllIIlllIlII).offsetUp());
            final int llllllllllllllIIllIlIllIIllllIll = this.getLightFor(llllllllllllllIIllIlIllIIlllIlIl, ((BlockPos)llllllllllllllIIllIlIllIIlllIlII).offsetEast());
            final int llllllllllllllIIllIlIllIIllllIlI = this.getLightFor(llllllllllllllIIllIlIllIIlllIlIl, ((BlockPos)llllllllllllllIIllIlIllIIlllIlII).offsetWest());
            final int llllllllllllllIIllIlIllIIllllIIl = this.getLightFor(llllllllllllllIIllIlIllIIlllIlIl, ((BlockPos)llllllllllllllIIllIlIllIIlllIlII).offsetSouth());
            final int llllllllllllllIIllIlIllIIllllIII = this.getLightFor(llllllllllllllIIllIlIllIIlllIlIl, ((BlockPos)llllllllllllllIIllIlIllIIlllIlII).offsetNorth());
            if (llllllllllllllIIllIlIllIIllllIll > llllllllllllllIIllIlIllIIlllllII) {
                llllllllllllllIIllIlIllIIlllllII = llllllllllllllIIllIlIllIIllllIll;
            }
            if (llllllllllllllIIllIlIllIIllllIlI > llllllllllllllIIllIlIllIIlllllII) {
                llllllllllllllIIllIlIllIIlllllII = llllllllllllllIIllIlIllIIllllIlI;
            }
            if (llllllllllllllIIllIlIllIIllllIIl > llllllllllllllIIllIlIllIIlllllII) {
                llllllllllllllIIllIlIllIIlllllII = llllllllllllllIIllIlIllIIllllIIl;
            }
            if (llllllllllllllIIllIlIllIIllllIII > llllllllllllllIIllIlIllIIlllllII) {
                llllllllllllllIIllIlIllIIlllllII = llllllllllllllIIllIlIllIIllllIII;
            }
            return llllllllllllllIIllIlIllIIlllllII;
        }
        final Chunk llllllllllllllIIllIlIllIIlllIlll = this.getChunkFromBlockCoords((BlockPos)llllllllllllllIIllIlIllIIlllIlII);
        return llllllllllllllIIllIlIllIIlllIlll.getLightFor(llllllllllllllIIllIlIllIIlllIlIl, (BlockPos)llllllllllllllIIllIlIllIIlllIlII);
    }
    
    public void spawnParticle(final EnumParticleTypes llllllllllllllIIllIlIlIlIIlllIII, final boolean llllllllllllllIIllIlIlIlIIlIllIl, final double llllllllllllllIIllIlIlIlIIllIllI, final double llllllllllllllIIllIlIlIlIIlIlIll, final double llllllllllllllIIllIlIlIlIIlIlIlI, final double llllllllllllllIIllIlIlIlIIllIIll, final double llllllllllllllIIllIlIlIlIIllIIlI, final double llllllllllllllIIllIlIlIlIIllIIIl, final int... llllllllllllllIIllIlIlIlIIllIIII) {
        this.spawnParticle(llllllllllllllIIllIlIlIlIIlllIII.func_179348_c(), llllllllllllllIIllIlIlIlIIlllIII.func_179344_e() | llllllllllllllIIllIlIlIlIIlIllIl, llllllllllllllIIllIlIlIlIIllIllI, llllllllllllllIIllIlIlIlIIlIlIll, llllllllllllllIIllIlIlIlIIlIlIlI, llllllllllllllIIllIlIlIlIIllIIll, llllllllllllllIIllIlIlIlIIllIIlI, llllllllllllllIIllIlIlIlIIllIIIl, llllllllllllllIIllIlIlIlIIllIIII);
    }
    
    public float getCurrentMoonPhaseFactor() {
        return WorldProvider.moonPhaseFactors[this.provider.getMoonPhase(this.worldInfo.getWorldTime())];
    }
    
    public List getCollidingBoundingBoxes(final Entity llllllllllllllIIllIlIlIIlIIlIlII, final AxisAlignedBB llllllllllllllIIllIlIlIIlIIlIIll) {
        final ArrayList llllllllllllllIIllIlIlIIlIlIlIII = Lists.newArrayList();
        final int llllllllllllllIIllIlIlIIlIlIIlll = MathHelper.floor_double(llllllllllllllIIllIlIlIIlIIlIIll.minX);
        final int llllllllllllllIIllIlIlIIlIlIIllI = MathHelper.floor_double(llllllllllllllIIllIlIlIIlIIlIIll.maxX + 1.0);
        final int llllllllllllllIIllIlIlIIlIlIIlIl = MathHelper.floor_double(llllllllllllllIIllIlIlIIlIIlIIll.minY);
        final int llllllllllllllIIllIlIlIIlIlIIlII = MathHelper.floor_double(llllllllllllllIIllIlIlIIlIIlIIll.maxY + 1.0);
        final int llllllllllllllIIllIlIlIIlIlIIIll = MathHelper.floor_double(llllllllllllllIIllIlIlIIlIIlIIll.minZ);
        final int llllllllllllllIIllIlIlIIlIlIIIlI = MathHelper.floor_double(llllllllllllllIIllIlIlIIlIIlIIll.maxZ + 1.0);
        for (int llllllllllllllIIllIlIlIIlIlIIIIl = llllllllllllllIIllIlIlIIlIlIIlll; llllllllllllllIIllIlIlIIlIlIIIIl < llllllllllllllIIllIlIlIIlIlIIllI; ++llllllllllllllIIllIlIlIIlIlIIIIl) {
            for (int llllllllllllllIIllIlIlIIlIlIIIII = llllllllllllllIIllIlIlIIlIlIIIll; llllllllllllllIIllIlIlIIlIlIIIII < llllllllllllllIIllIlIlIIlIlIIIlI; ++llllllllllllllIIllIlIlIIlIlIIIII) {
                if (this.isBlockLoaded(new BlockPos(llllllllllllllIIllIlIlIIlIlIIIIl, 64, llllllllllllllIIllIlIlIIlIlIIIII))) {
                    for (int llllllllllllllIIllIlIlIIlIIlllll = llllllllllllllIIllIlIlIIlIlIIlIl - 1; llllllllllllllIIllIlIlIIlIIlllll < llllllllllllllIIllIlIlIIlIlIIlII; ++llllllllllllllIIllIlIlIIlIIlllll) {
                        final BlockPos llllllllllllllIIllIlIlIIlIIllllI = new BlockPos(llllllllllllllIIllIlIlIIlIlIIIIl, llllllllllllllIIllIlIlIIlIIlllll, llllllllllllllIIllIlIlIIlIlIIIII);
                        final boolean llllllllllllllIIllIlIlIIlIIlllIl = llllllllllllllIIllIlIlIIlIIlIlII.isOutsideBorder();
                        final boolean llllllllllllllIIllIlIlIIlIIlllII = this.isInsideBorder(this.getWorldBorder(), llllllllllllllIIllIlIlIIlIIlIlII);
                        if (llllllllllllllIIllIlIlIIlIIlllIl && llllllllllllllIIllIlIlIIlIIlllII) {
                            llllllllllllllIIllIlIlIIlIIlIlII.setOutsideBorder(false);
                        }
                        else if (!llllllllllllllIIllIlIlIIlIIlllIl && !llllllllllllllIIllIlIlIIlIIlllII) {
                            llllllllllllllIIllIlIlIIlIIlIlII.setOutsideBorder(true);
                        }
                        IBlockState llllllllllllllIIllIlIlIIlIIllIlI = null;
                        if (!this.getWorldBorder().contains(llllllllllllllIIllIlIlIIlIIllllI) && llllllllllllllIIllIlIlIIlIIlllII) {
                            final IBlockState llllllllllllllIIllIlIlIIlIIllIll = Blocks.stone.getDefaultState();
                        }
                        else {
                            llllllllllllllIIllIlIlIIlIIllIlI = this.getBlockState(llllllllllllllIIllIlIlIIlIIllllI);
                        }
                        llllllllllllllIIllIlIlIIlIIllIlI.getBlock().addCollisionBoxesToList(this, llllllllllllllIIllIlIlIIlIIllllI, llllllllllllllIIllIlIlIIlIIllIlI, llllllllllllllIIllIlIlIIlIIlIIll, llllllllllllllIIllIlIlIIlIlIlIII, llllllllllllllIIllIlIlIIlIIlIlII);
                    }
                }
            }
        }
        final double llllllllllllllIIllIlIlIIlIIllIIl = 0.25;
        final List llllllllllllllIIllIlIlIIlIIllIII = this.getEntitiesWithinAABBExcludingEntity(llllllllllllllIIllIlIlIIlIIlIlII, llllllllllllllIIllIlIlIIlIIlIIll.expand(llllllllllllllIIllIlIlIIlIIllIIl, llllllllllllllIIllIlIlIIlIIllIIl, llllllllllllllIIllIlIlIIlIIllIIl));
        for (int llllllllllllllIIllIlIlIIlIIlIlll = 0; llllllllllllllIIllIlIlIIlIIlIlll < llllllllllllllIIllIlIlIIlIIllIII.size(); ++llllllllllllllIIllIlIlIIlIIlIlll) {
            if (llllllllllllllIIllIlIlIIlIIlIlII.riddenByEntity != llllllllllllllIIllIlIlIIlIIllIII && llllllllllllllIIllIlIlIIlIIlIlII.ridingEntity != llllllllllllllIIllIlIlIIlIIllIII) {
                AxisAlignedBB llllllllllllllIIllIlIlIIlIIlIllI = llllllllllllllIIllIlIlIIlIIllIII.get(llllllllllllllIIllIlIlIIlIIlIlll).getBoundingBox();
                if (llllllllllllllIIllIlIlIIlIIlIllI != null && llllllllllllllIIllIlIlIIlIIlIllI.intersectsWith(llllllllllllllIIllIlIlIIlIIlIIll)) {
                    llllllllllllllIIllIlIlIIlIlIlIII.add(llllllllllllllIIllIlIlIIlIIlIllI);
                }
                llllllllllllllIIllIlIlIIlIIlIllI = llllllllllllllIIllIlIlIIlIIlIlII.getCollisionBox(llllllllllllllIIllIlIlIIlIIllIII.get(llllllllllllllIIllIlIlIIlIIlIlll));
                if (llllllllllllllIIllIlIlIIlIIlIllI != null && llllllllllllllIIllIlIlIIlIIlIllI.intersectsWith(llllllllllllllIIllIlIlIIlIIlIIll)) {
                    llllllllllllllIIllIlIlIIlIlIlIII.add(llllllllllllllIIllIlIlIIlIIlIllI);
                }
            }
        }
        return llllllllllllllIIllIlIlIIlIlIlIII;
    }
    
    public IChunkProvider getChunkProvider() {
        return this.chunkProvider;
    }
    
    public boolean isAreaLoaded(final BlockPos llllllllllllllIIllIlIlllllIllllI, final int llllllllllllllIIllIlIlllllIlllIl, final boolean llllllllllllllIIllIlIllllllIIIII) {
        return this.isAreaLoaded(llllllllllllllIIllIlIlllllIllllI.getX() - llllllllllllllIIllIlIlllllIlllIl, llllllllllllllIIllIlIlllllIllllI.getY() - llllllllllllllIIllIlIlllllIlllIl, llllllllllllllIIllIlIlllllIllllI.getZ() - llllllllllllllIIllIlIlllllIlllIl, llllllllllllllIIllIlIlllllIllllI.getX() + llllllllllllllIIllIlIlllllIlllIl, llllllllllllllIIllIlIlllllIllllI.getY() + llllllllllllllIIllIlIlllllIlllIl, llllllllllllllIIllIlIlllllIllllI.getZ() + llllllllllllllIIllIlIlllllIlllIl, llllllllllllllIIllIlIllllllIIIII);
    }
    
    public String getDebugLoadedEntities() {
        return String.valueOf(new StringBuilder("All: ").append(this.loadedEntityList.size()));
    }
    
    public void func_180497_b(final BlockPos llllllllllllllIIllIlIIlllIIIIIll, final Block llllllllllllllIIllIlIIlllIIIIIlI, final int llllllllllllllIIllIlIIlllIIIIIIl, final int llllllllllllllIIllIlIIlllIIIIIII) {
    }
    
    public Vec3 getCloudColour(final float llllllllllllllIIllIlIIllllIIIlII) {
        final float llllllllllllllIIllIlIIllllIlIIII = this.getCelestialAngle(llllllllllllllIIllIlIIllllIIIlII);
        float llllllllllllllIIllIlIIllllIIllll = MathHelper.cos(llllllllllllllIIllIlIIllllIlIIII * 3.1415927f * 2.0f) * 2.0f + 0.5f;
        llllllllllllllIIllIlIIllllIIllll = MathHelper.clamp_float(llllllllllllllIIllIlIIllllIIllll, 0.0f, 1.0f);
        float llllllllllllllIIllIlIIllllIIlllI = (this.cloudColour >> 16 & 0xFFL) / 255.0f;
        float llllllllllllllIIllIlIIllllIIllIl = (this.cloudColour >> 8 & 0xFFL) / 255.0f;
        float llllllllllllllIIllIlIIllllIIllII = (this.cloudColour & 0xFFL) / 255.0f;
        final float llllllllllllllIIllIlIIllllIIlIll = this.getRainStrength(llllllllllllllIIllIlIIllllIIIlII);
        if (llllllllllllllIIllIlIIllllIIlIll > 0.0f) {
            final float llllllllllllllIIllIlIIllllIIlIlI = (llllllllllllllIIllIlIIllllIIlllI * 0.3f + llllllllllllllIIllIlIIllllIIllIl * 0.59f + llllllllllllllIIllIlIIllllIIllII * 0.11f) * 0.6f;
            final float llllllllllllllIIllIlIIllllIIlIII = 1.0f - llllllllllllllIIllIlIIllllIIlIll * 0.95f;
            llllllllllllllIIllIlIIllllIIlllI = llllllllllllllIIllIlIIllllIIlllI * llllllllllllllIIllIlIIllllIIlIII + llllllllllllllIIllIlIIllllIIlIlI * (1.0f - llllllllllllllIIllIlIIllllIIlIII);
            llllllllllllllIIllIlIIllllIIllIl = llllllllllllllIIllIlIIllllIIllIl * llllllllllllllIIllIlIIllllIIlIII + llllllllllllllIIllIlIIllllIIlIlI * (1.0f - llllllllllllllIIllIlIIllllIIlIII);
            llllllllllllllIIllIlIIllllIIllII = llllllllllllllIIllIlIIllllIIllII * llllllllllllllIIllIlIIllllIIlIII + llllllllllllllIIllIlIIllllIIlIlI * (1.0f - llllllllllllllIIllIlIIllllIIlIII);
        }
        llllllllllllllIIllIlIIllllIIlllI *= llllllllllllllIIllIlIIllllIIllll * 0.9f + 0.1f;
        llllllllllllllIIllIlIIllllIIllIl *= llllllllllllllIIllIlIIllllIIllll * 0.9f + 0.1f;
        llllllllllllllIIllIlIIllllIIllII *= llllllllllllllIIllIlIIllllIIllll * 0.85f + 0.15f;
        final float llllllllllllllIIllIlIIllllIIlIIl = this.getWeightedThunderStrength(llllllllllllllIIllIlIIllllIIIlII);
        if (llllllllllllllIIllIlIIllllIIlIIl > 0.0f) {
            final float llllllllllllllIIllIlIIllllIIIlll = (llllllllllllllIIllIlIIllllIIlllI * 0.3f + llllllllllllllIIllIlIIllllIIllIl * 0.59f + llllllllllllllIIllIlIIllllIIllII * 0.11f) * 0.2f;
            final float llllllllllllllIIllIlIIllllIIIllI = 1.0f - llllllllllllllIIllIlIIllllIIlIIl * 0.95f;
            llllllllllllllIIllIlIIllllIIlllI = llllllllllllllIIllIlIIllllIIlllI * llllllllllllllIIllIlIIllllIIIllI + llllllllllllllIIllIlIIllllIIIlll * (1.0f - llllllllllllllIIllIlIIllllIIIllI);
            llllllllllllllIIllIlIIllllIIllIl = llllllllllllllIIllIlIIllllIIllIl * llllllllllllllIIllIlIIllllIIIllI + llllllllllllllIIllIlIIllllIIIlll * (1.0f - llllllllllllllIIllIlIIllllIIIllI);
            llllllllllllllIIllIlIIllllIIllII = llllllllllllllIIllIlIIllllIIllII * llllllllllllllIIllIlIIllllIIIllI + llllllllllllllIIllIlIIllllIIIlll * (1.0f - llllllllllllllIIllIlIIllllIIIllI);
        }
        return new Vec3(llllllllllllllIIllIlIIllllIIlllI, llllllllllllllIIllIlIIllllIIllIl, llllllllllllllIIllIlIIllllIIllII);
    }
    
    public boolean setBlockToAir(final BlockPos llllllllllllllIIllIlIlllIllIIIll) {
        return this.setBlockState(llllllllllllllIIllIlIlllIllIIIll, Blocks.air.getDefaultState(), 3);
    }
    
    public int getMoonPhase() {
        return this.provider.getMoonPhase(this.worldInfo.getWorldTime());
    }
    
    public void func_175654_a(final BlockPos llllllllllllllIIllIlIIlllIIIlIII, final Block llllllllllllllIIllIlIIlllIIIIlll, final int llllllllllllllIIllIlIIlllIIIIllI, final int llllllllllllllIIllIlIIlllIIIIlIl) {
    }
    
    public void setSpawnLocation(final BlockPos llllllllllllllIIllIIlllIIlIlIlIl) {
        this.worldInfo.setSpawn(llllllllllllllIIllIIlllIIlIlIlIl);
    }
    
    public BlockPos getSpawnPoint() {
        BlockPos llllllllllllllIIllIIlllIIlIllIll = new BlockPos(this.worldInfo.getSpawnX(), this.worldInfo.getSpawnY(), this.worldInfo.getSpawnZ());
        if (!this.getWorldBorder().contains(llllllllllllllIIllIIlllIIlIllIll)) {
            llllllllllllllIIllIIlllIIlIllIll = this.getHorizon(new BlockPos(this.getWorldBorder().getCenterX(), 0.0, this.getWorldBorder().getCenterZ()));
        }
        return llllllllllllllIIllIIlllIIlIllIll;
    }
    
    public boolean destroyBlock(final BlockPos llllllllllllllIIllIlIlllIlIllIlI, final boolean llllllllllllllIIllIlIlllIlIlIlII) {
        final IBlockState llllllllllllllIIllIlIlllIlIllIII = this.getBlockState(llllllllllllllIIllIlIlllIlIllIlI);
        final Block llllllllllllllIIllIlIlllIlIlIlll = llllllllllllllIIllIlIlllIlIllIII.getBlock();
        if (llllllllllllllIIllIlIlllIlIlIlll.getMaterial() == Material.air) {
            return false;
        }
        this.playAuxSFX(2001, llllllllllllllIIllIlIlllIlIllIlI, Block.getStateId(llllllllllllllIIllIlIlllIlIllIII));
        if (llllllllllllllIIllIlIlllIlIlIlII) {
            llllllllllllllIIllIlIlllIlIlIlll.dropBlockAsItem(this, llllllllllllllIIllIlIlllIlIllIlI, llllllllllllllIIllIlIlllIlIllIII, 0);
        }
        return this.setBlockState(llllllllllllllIIllIlIlllIlIllIlI, Blocks.air.getDefaultState(), 3);
    }
    
    public BlockPos func_175672_r(final BlockPos llllllllllllllIIllIlIIlllIlIIlII) {
        final Chunk llllllllllllllIIllIlIIlllIlIIIll = this.getChunkFromBlockCoords(llllllllllllllIIllIlIIlllIlIIlII);
        BlockPos llllllllllllllIIllIlIIlllIlIIIlI;
        BlockPos llllllllllllllIIllIlIIlllIlIIIIl;
        for (llllllllllllllIIllIlIIlllIlIIIlI = new BlockPos(llllllllllllllIIllIlIIlllIlIIlII.getX(), llllllllllllllIIllIlIIlllIlIIIll.getTopFilledSegment() + 16, llllllllllllllIIllIlIIlllIlIIlII.getZ()); llllllllllllllIIllIlIIlllIlIIIlI.getY() >= 0; llllllllllllllIIllIlIIlllIlIIIlI = llllllllllllllIIllIlIIlllIlIIIIl) {
            llllllllllllllIIllIlIIlllIlIIIIl = llllllllllllllIIllIlIIlllIlIIIlI.offsetDown();
            final Material llllllllllllllIIllIlIIlllIlIIIII = llllllllllllllIIllIlIIlllIlIIIll.getBlock(llllllllllllllIIllIlIIlllIlIIIIl).getMaterial();
            if (llllllllllllllIIllIlIIlllIlIIIII.blocksMovement() && llllllllllllllIIllIlIIlllIlIIIII != Material.leaves) {
                break;
            }
        }
        return llllllllllllllIIllIlIIlllIlIIIlI;
    }
    
    public boolean func_175727_C(final BlockPos llllllllllllllIIllIIllIllllllIIl) {
        if (!this.isRaining()) {
            return false;
        }
        if (!this.isAgainstSky(llllllllllllllIIllIIllIllllllIIl)) {
            return false;
        }
        if (this.func_175725_q(llllllllllllllIIllIIllIllllllIIl).getY() > llllllllllllllIIllIIllIllllllIIl.getY()) {
            return false;
        }
        final BiomeGenBase llllllllllllllIIllIIllIllllllIII = this.getBiomeGenForCoords(llllllllllllllIIllIIllIllllllIIl);
        return !llllllllllllllIIllIIllIllllllIII.getEnableSnow() && !this.func_175708_f(llllllllllllllIIllIIllIllllllIIl, false) && llllllllllllllIIllIIllIllllllIII.canSpawnLightningBolt();
    }
    
    public boolean addWeatherEffect(final Entity llllllllllllllIIllIlIlIlIIIIIIIl) {
        this.weatherEffects.add(llllllllllllllIIllIlIlIlIIIIIIIl);
        return true;
    }
    
    public boolean chunkExists(final int llllllllllllllIIllIIllIlIIIIIIlI, final int llllllllllllllIIllIIllIlIIIIIIIl) {
        final BlockPos llllllllllllllIIllIIllIlIIIIIlll = this.getSpawnPoint();
        final int llllllllllllllIIllIIllIlIIIIIllI = llllllllllllllIIllIIllIlIIIIIIlI * 16 + 8 - llllllllllllllIIllIIllIlIIIIIlll.getX();
        final int llllllllllllllIIllIIllIlIIIIIlIl = llllllllllllllIIllIIllIlIIIIIIIl * 16 + 8 - llllllllllllllIIllIIllIlIIIIIlll.getZ();
        final short llllllllllllllIIllIIllIlIIIIIlII = 128;
        return llllllllllllllIIllIIllIlIIIIIllI >= -llllllllllllllIIllIIllIlIIIIIlII && llllllllllllllIIllIIllIlIIIIIllI <= llllllllllllllIIllIIllIlIIIIIlII && llllllllllllllIIllIIllIlIIIIIlIl >= -llllllllllllllIIllIIllIlIIIIIlII && llllllllllllllIIllIIllIlIIIIIlIl <= llllllllllllllIIllIIllIlIIIIIlII;
    }
    
    public WorldInfo getWorldInfo() {
        return this.worldInfo;
    }
    
    public boolean isMaterialInBB(final AxisAlignedBB llllllllllllllIIllIlIIlIIlIIIIIl, final Material llllllllllllllIIllIlIIlIIlIIIIII) {
        final int llllllllllllllIIllIlIIlIIlIIlIll = MathHelper.floor_double(llllllllllllllIIllIlIIlIIlIIIIIl.minX);
        final int llllllllllllllIIllIlIIlIIlIIlIlI = MathHelper.floor_double(llllllllllllllIIllIlIIlIIlIIIIIl.maxX + 1.0);
        final int llllllllllllllIIllIlIIlIIlIIlIIl = MathHelper.floor_double(llllllllllllllIIllIlIIlIIlIIIIIl.minY);
        final int llllllllllllllIIllIlIIlIIlIIlIII = MathHelper.floor_double(llllllllllllllIIllIlIIlIIlIIIIIl.maxY + 1.0);
        final int llllllllllllllIIllIlIIlIIlIIIlll = MathHelper.floor_double(llllllllllllllIIllIlIIlIIlIIIIIl.minZ);
        final int llllllllllllllIIllIlIIlIIlIIIllI = MathHelper.floor_double(llllllllllllllIIllIlIIlIIlIIIIIl.maxZ + 1.0);
        for (int llllllllllllllIIllIlIIlIIlIIIlIl = llllllllllllllIIllIlIIlIIlIIlIll; llllllllllllllIIllIlIIlIIlIIIlIl < llllllllllllllIIllIlIIlIIlIIlIlI; ++llllllllllllllIIllIlIIlIIlIIIlIl) {
            for (int llllllllllllllIIllIlIIlIIlIIIlII = llllllllllllllIIllIlIIlIIlIIlIIl; llllllllllllllIIllIlIIlIIlIIIlII < llllllllllllllIIllIlIIlIIlIIlIII; ++llllllllllllllIIllIlIIlIIlIIIlII) {
                for (int llllllllllllllIIllIlIIlIIlIIIIll = llllllllllllllIIllIlIIlIIlIIIlll; llllllllllllllIIllIlIIlIIlIIIIll < llllllllllllllIIllIlIIlIIlIIIllI; ++llllllllllllllIIllIlIIlIIlIIIIll) {
                    if (this.getBlockState(new BlockPos(llllllllllllllIIllIlIIlIIlIIIlIl, llllllllllllllIIllIlIIlIIlIIIlII, llllllllllllllIIllIlIIlIIlIIIIll)).getBlock().getMaterial() == llllllllllllllIIllIlIIlIIlIIIIII) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean func_175719_a(final EntityPlayer llllllllllllllIIllIlIIIllIlIIlII, BlockPos llllllllllllllIIllIlIIIllIIlllll, final EnumFacing llllllllllllllIIllIlIIIllIIllllI) {
        llllllllllllllIIllIlIIIllIIlllll = llllllllllllllIIllIlIIIllIIlllll.offset(llllllllllllllIIllIlIIIllIIllllI);
        if (this.getBlockState(llllllllllllllIIllIlIIIllIIlllll).getBlock() == Blocks.fire) {
            this.playAuxSFXAtEntity(llllllllllllllIIllIlIIIllIlIIlII, 1004, llllllllllllllIIllIlIIIllIIlllll, 0);
            this.setBlockToAir(llllllllllllllIIllIlIIIllIIlllll);
            return true;
        }
        return false;
    }
    
    public boolean func_175675_v(final BlockPos llllllllllllllIIllIlIIIIllIlIIIl) {
        return this.func_175670_e(llllllllllllllIIllIlIIIIllIlIIIl, false);
    }
    
    public void notifyLightSet(final BlockPos llllllllllllllIIllIlIllIIlIIllll) {
        for (int llllllllllllllIIllIlIllIIlIIlllI = 0; llllllllllllllIIllIlIllIIlIIlllI < this.worldAccesses.size(); ++llllllllllllllIIllIlIllIIlIIlllI) {
            this.worldAccesses.get(llllllllllllllIIllIlIllIIlIIlllI).notifyLightSet(llllllllllllllIIllIlIllIIlIIllll);
        }
    }
    
    public float getLightBrightness(final BlockPos llllllllllllllIIllIlIllIIIllIllI) {
        return this.provider.getLightBrightnessTable()[this.getLightFromNeighbors(llllllllllllllIIllIlIllIIIllIllI)];
    }
    
    public int getLightFromNeighbors(final BlockPos llllllllllllllIIllIlIllIlIlllIlI) {
        return this.getLight(llllllllllllllIIllIlIllIlIlllIlI, true);
    }
    
    public void func_175722_b(final BlockPos llllllllllllllIIllIlIlllIIlllIII, final Block llllllllllllllIIllIlIlllIIllIlll) {
        if (this.worldInfo.getTerrainType() != WorldType.DEBUG_WORLD) {
            this.notifyNeighborsOfStateChange(llllllllllllllIIllIlIlllIIlllIII, llllllllllllllIIllIlIlllIIllIlll);
        }
    }
    
    public List getEntitiesWithinAABB(final Class llllllllllllllIIllIIlllllIlIllII, final AxisAlignedBB llllllllllllllIIllIIlllllIlIlllI) {
        return this.func_175647_a(llllllllllllllIIllIIlllllIlIllII, llllllllllllllIIllIIlllllIlIlllI, IEntitySelector.field_180132_d);
    }
    
    @Override
    public WorldType getWorldType() {
        return this.worldInfo.getTerrainType();
    }
    
    public boolean isBlockModifiable(final EntityPlayer llllllllllllllIIllIIlllIIIllllII, final BlockPos llllllllllllllIIllIIlllIIIlllIll) {
        return true;
    }
    
    public void updateEntity(final Entity llllllllllllllIIllIlIIllIIllIllI) {
        this.updateEntityWithOptionalForce(llllllllllllllIIllIlIIllIIllIllI, true);
    }
    
    protected abstract int getRenderDistanceChunks();
    
    public boolean func_180502_D(final BlockPos llllllllllllllIIllIIllIlllllIIII) {
        final BiomeGenBase llllllllllllllIIllIIllIllllIllll = this.getBiomeGenForCoords(llllllllllllllIIllIIllIlllllIIII);
        return llllllllllllllIIllIIllIllllIllll.isHighHumidity();
    }
    
    public MovingObjectPosition rayTraceBlocks(Vec3 llllllllllllllIIllIlIlIlllIIlllI, final Vec3 llllllllllllllIIllIlIlIlllllIIIl, final boolean llllllllllllllIIllIlIlIlllllIIII, final boolean llllllllllllllIIllIlIlIllllIllll, final boolean llllllllllllllIIllIlIlIllllIlllI) {
        if (Double.isNaN(llllllllllllllIIllIlIlIlllIIlllI.xCoord) || Double.isNaN(llllllllllllllIIllIlIlIlllIIlllI.yCoord) || Double.isNaN(llllllllllllllIIllIlIlIlllIIlllI.zCoord)) {
            return null;
        }
        if (!Double.isNaN(llllllllllllllIIllIlIlIlllllIIIl.xCoord) && !Double.isNaN(llllllllllllllIIllIlIlIlllllIIIl.yCoord) && !Double.isNaN(llllllllllllllIIllIlIlIlllllIIIl.zCoord)) {
            final int llllllllllllllIIllIlIlIllllIllIl = MathHelper.floor_double(llllllllllllllIIllIlIlIlllllIIIl.xCoord);
            final int llllllllllllllIIllIlIlIllllIllII = MathHelper.floor_double(llllllllllllllIIllIlIlIlllllIIIl.yCoord);
            final int llllllllllllllIIllIlIlIllllIlIll = MathHelper.floor_double(llllllllllllllIIllIlIlIlllllIIIl.zCoord);
            int llllllllllllllIIllIlIlIllllIlIlI = MathHelper.floor_double(llllllllllllllIIllIlIlIlllIIlllI.xCoord);
            int llllllllllllllIIllIlIlIllllIlIIl = MathHelper.floor_double(llllllllllllllIIllIlIlIlllIIlllI.yCoord);
            int llllllllllllllIIllIlIlIllllIlIII = MathHelper.floor_double(llllllllllllllIIllIlIlIlllIIlllI.zCoord);
            BlockPos llllllllllllllIIllIlIlIllllIIlll = new BlockPos(llllllllllllllIIllIlIlIllllIlIlI, llllllllllllllIIllIlIlIllllIlIIl, llllllllllllllIIllIlIlIllllIlIII);
            new BlockPos(llllllllllllllIIllIlIlIllllIllIl, llllllllllllllIIllIlIlIllllIllII, llllllllllllllIIllIlIlIllllIlIll);
            final IBlockState llllllllllllllIIllIlIlIllllIIllI = this.getBlockState(llllllllllllllIIllIlIlIllllIIlll);
            final Block llllllllllllllIIllIlIlIllllIIlIl = llllllllllllllIIllIlIlIllllIIllI.getBlock();
            if ((!llllllllllllllIIllIlIlIllllIllll || llllllllllllllIIllIlIlIllllIIlIl.getCollisionBoundingBox(this, llllllllllllllIIllIlIlIllllIIlll, llllllllllllllIIllIlIlIllllIIllI) != null) && llllllllllllllIIllIlIlIllllIIlIl.canCollideCheck(llllllllllllllIIllIlIlIllllIIllI, llllllllllllllIIllIlIlIlllllIIII)) {
                final MovingObjectPosition llllllllllllllIIllIlIlIllllIIlII = llllllllllllllIIllIlIlIllllIIlIl.collisionRayTrace(this, llllllllllllllIIllIlIlIllllIIlll, llllllllllllllIIllIlIlIlllIIlllI, llllllllllllllIIllIlIlIlllllIIIl);
                if (llllllllllllllIIllIlIlIllllIIlII != null) {
                    return llllllllllllllIIllIlIlIllllIIlII;
                }
            }
            MovingObjectPosition llllllllllllllIIllIlIlIllllIIIll = null;
            int llllllllllllllIIllIlIlIllllIIIlI = 200;
            while (llllllllllllllIIllIlIlIllllIIIlI-- >= 0) {
                if (Double.isNaN(llllllllllllllIIllIlIlIlllIIlllI.xCoord) || Double.isNaN(llllllllllllllIIllIlIlIlllIIlllI.yCoord) || Double.isNaN(llllllllllllllIIllIlIlIlllIIlllI.zCoord)) {
                    return null;
                }
                if (llllllllllllllIIllIlIlIllllIlIlI == llllllllllllllIIllIlIlIllllIllIl && llllllllllllllIIllIlIlIllllIlIIl == llllllllllllllIIllIlIlIllllIllII && llllllllllllllIIllIlIlIllllIlIII == llllllllllllllIIllIlIlIllllIlIll) {
                    return llllllllllllllIIllIlIlIllllIlllI ? llllllllllllllIIllIlIlIllllIIIll : null;
                }
                boolean llllllllllllllIIllIlIlIllllIIIIl = true;
                boolean llllllllllllllIIllIlIlIllllIIIII = true;
                boolean llllllllllllllIIllIlIlIlllIlllll = true;
                double llllllllllllllIIllIlIlIlllIllllI = 999.0;
                double llllllllllllllIIllIlIlIlllIlllIl = 999.0;
                double llllllllllllllIIllIlIlIlllIlllII = 999.0;
                if (llllllllllllllIIllIlIlIllllIllIl > llllllllllllllIIllIlIlIllllIlIlI) {
                    llllllllllllllIIllIlIlIlllIllllI = llllllllllllllIIllIlIlIllllIlIlI + 1.0;
                }
                else if (llllllllllllllIIllIlIlIllllIllIl < llllllllllllllIIllIlIlIllllIlIlI) {
                    llllllllllllllIIllIlIlIlllIllllI = llllllllllllllIIllIlIlIllllIlIlI + 0.0;
                }
                else {
                    llllllllllllllIIllIlIlIllllIIIIl = false;
                }
                if (llllllllllllllIIllIlIlIllllIllII > llllllllllllllIIllIlIlIllllIlIIl) {
                    llllllllllllllIIllIlIlIlllIlllIl = llllllllllllllIIllIlIlIllllIlIIl + 1.0;
                }
                else if (llllllllllllllIIllIlIlIllllIllII < llllllllllllllIIllIlIlIllllIlIIl) {
                    llllllllllllllIIllIlIlIlllIlllIl = llllllllllllllIIllIlIlIllllIlIIl + 0.0;
                }
                else {
                    llllllllllllllIIllIlIlIllllIIIII = false;
                }
                if (llllllllllllllIIllIlIlIllllIlIll > llllllllllllllIIllIlIlIllllIlIII) {
                    llllllllllllllIIllIlIlIlllIlllII = llllllllllllllIIllIlIlIllllIlIII + 1.0;
                }
                else if (llllllllllllllIIllIlIlIllllIlIll < llllllllllllllIIllIlIlIllllIlIII) {
                    llllllllllllllIIllIlIlIlllIlllII = llllllllllllllIIllIlIlIllllIlIII + 0.0;
                }
                else {
                    llllllllllllllIIllIlIlIlllIlllll = false;
                }
                double llllllllllllllIIllIlIlIlllIllIll = 999.0;
                double llllllllllllllIIllIlIlIlllIllIlI = 999.0;
                double llllllllllllllIIllIlIlIlllIllIIl = 999.0;
                final double llllllllllllllIIllIlIlIlllIllIII = llllllllllllllIIllIlIlIlllllIIIl.xCoord - llllllllllllllIIllIlIlIlllIIlllI.xCoord;
                final double llllllllllllllIIllIlIlIlllIlIlll = llllllllllllllIIllIlIlIlllllIIIl.yCoord - llllllllllllllIIllIlIlIlllIIlllI.yCoord;
                final double llllllllllllllIIllIlIlIlllIlIllI = llllllllllllllIIllIlIlIlllllIIIl.zCoord - llllllllllllllIIllIlIlIlllIIlllI.zCoord;
                if (llllllllllllllIIllIlIlIllllIIIIl) {
                    llllllllllllllIIllIlIlIlllIllIll = (llllllllllllllIIllIlIlIlllIllllI - llllllllllllllIIllIlIlIlllIIlllI.xCoord) / llllllllllllllIIllIlIlIlllIllIII;
                }
                if (llllllllllllllIIllIlIlIllllIIIII) {
                    llllllllllllllIIllIlIlIlllIllIlI = (llllllllllllllIIllIlIlIlllIlllIl - llllllllllllllIIllIlIlIlllIIlllI.yCoord) / llllllllllllllIIllIlIlIlllIlIlll;
                }
                if (llllllllllllllIIllIlIlIlllIlllll) {
                    llllllllllllllIIllIlIlIlllIllIIl = (llllllllllllllIIllIlIlIlllIlllII - llllllllllllllIIllIlIlIlllIIlllI.zCoord) / llllllllllllllIIllIlIlIlllIlIllI;
                }
                if (llllllllllllllIIllIlIlIlllIllIll == -0.0) {
                    llllllllllllllIIllIlIlIlllIllIll = -1.0E-4;
                }
                if (llllllllllllllIIllIlIlIlllIllIlI == -0.0) {
                    llllllllllllllIIllIlIlIlllIllIlI = -1.0E-4;
                }
                if (llllllllllllllIIllIlIlIlllIllIIl == -0.0) {
                    llllllllllllllIIllIlIlIlllIllIIl = -1.0E-4;
                }
                EnumFacing llllllllllllllIIllIlIlIlllIlIIll = null;
                if (llllllllllllllIIllIlIlIlllIllIll < llllllllllllllIIllIlIlIlllIllIlI && llllllllllllllIIllIlIlIlllIllIll < llllllllllllllIIllIlIlIlllIllIIl) {
                    final EnumFacing llllllllllllllIIllIlIlIlllIlIlIl = (llllllllllllllIIllIlIlIllllIllIl > llllllllllllllIIllIlIlIllllIlIlI) ? EnumFacing.WEST : EnumFacing.EAST;
                    llllllllllllllIIllIlIlIlllIIlllI = new Vec3(llllllllllllllIIllIlIlIlllIllllI, llllllllllllllIIllIlIlIlllIIlllI.yCoord + llllllllllllllIIllIlIlIlllIlIlll * llllllllllllllIIllIlIlIlllIllIll, llllllllllllllIIllIlIlIlllIIlllI.zCoord + llllllllllllllIIllIlIlIlllIlIllI * llllllllllllllIIllIlIlIlllIllIll);
                }
                else if (llllllllllllllIIllIlIlIlllIllIlI < llllllllllllllIIllIlIlIlllIllIIl) {
                    final EnumFacing llllllllllllllIIllIlIlIlllIlIlII = (llllllllllllllIIllIlIlIllllIllII > llllllllllllllIIllIlIlIllllIlIIl) ? EnumFacing.DOWN : EnumFacing.UP;
                    llllllllllllllIIllIlIlIlllIIlllI = new Vec3(llllllllllllllIIllIlIlIlllIIlllI.xCoord + llllllllllllllIIllIlIlIlllIllIII * llllllllllllllIIllIlIlIlllIllIlI, llllllllllllllIIllIlIlIlllIlllIl, llllllllllllllIIllIlIlIlllIIlllI.zCoord + llllllllllllllIIllIlIlIlllIlIllI * llllllllllllllIIllIlIlIlllIllIlI);
                }
                else {
                    llllllllllllllIIllIlIlIlllIlIIll = ((llllllllllllllIIllIlIlIllllIlIll > llllllllllllllIIllIlIlIllllIlIII) ? EnumFacing.NORTH : EnumFacing.SOUTH);
                    llllllllllllllIIllIlIlIlllIIlllI = new Vec3(llllllllllllllIIllIlIlIlllIIlllI.xCoord + llllllllllllllIIllIlIlIlllIllIII * llllllllllllllIIllIlIlIlllIllIIl, llllllllllllllIIllIlIlIlllIIlllI.yCoord + llllllllllllllIIllIlIlIlllIlIlll * llllllllllllllIIllIlIlIlllIllIIl, llllllllllllllIIllIlIlIlllIlllII);
                }
                llllllllllllllIIllIlIlIllllIlIlI = MathHelper.floor_double(llllllllllllllIIllIlIlIlllIIlllI.xCoord) - ((llllllllllllllIIllIlIlIlllIlIIll == EnumFacing.EAST) ? 1 : 0);
                llllllllllllllIIllIlIlIllllIlIIl = MathHelper.floor_double(llllllllllllllIIllIlIlIlllIIlllI.yCoord) - ((llllllllllllllIIllIlIlIlllIlIIll == EnumFacing.UP) ? 1 : 0);
                llllllllllllllIIllIlIlIllllIlIII = MathHelper.floor_double(llllllllllllllIIllIlIlIlllIIlllI.zCoord) - ((llllllllllllllIIllIlIlIlllIlIIll == EnumFacing.SOUTH) ? 1 : 0);
                llllllllllllllIIllIlIlIllllIIlll = new BlockPos(llllllllllllllIIllIlIlIllllIlIlI, llllllllllllllIIllIlIlIllllIlIIl, llllllllllllllIIllIlIlIllllIlIII);
                final IBlockState llllllllllllllIIllIlIlIlllIlIIlI = this.getBlockState(llllllllllllllIIllIlIlIllllIIlll);
                final Block llllllllllllllIIllIlIlIlllIlIIIl = llllllllllllllIIllIlIlIlllIlIIlI.getBlock();
                if (llllllllllllllIIllIlIlIllllIllll && llllllllllllllIIllIlIlIlllIlIIIl.getCollisionBoundingBox(this, llllllllllllllIIllIlIlIllllIIlll, llllllllllllllIIllIlIlIlllIlIIlI) == null) {
                    continue;
                }
                if (llllllllllllllIIllIlIlIlllIlIIIl.canCollideCheck(llllllllllllllIIllIlIlIlllIlIIlI, llllllllllllllIIllIlIlIlllllIIII)) {
                    final MovingObjectPosition llllllllllllllIIllIlIlIlllIlIIII = llllllllllllllIIllIlIlIlllIlIIIl.collisionRayTrace(this, llllllllllllllIIllIlIlIllllIIlll, llllllllllllllIIllIlIlIlllIIlllI, llllllllllllllIIllIlIlIlllllIIIl);
                    if (llllllllllllllIIllIlIlIlllIlIIII != null) {
                        return llllllllllllllIIllIlIlIlllIlIIII;
                    }
                    continue;
                }
                else {
                    llllllllllllllIIllIlIlIllllIIIll = new MovingObjectPosition(MovingObjectPosition.MovingObjectType.MISS, llllllllllllllIIllIlIlIlllIIlllI, llllllllllllllIIllIlIlIlllIlIIll, llllllllllllllIIllIlIlIllllIIlll);
                }
            }
            return llllllllllllllIIllIlIlIllllIlllI ? llllllllllllllIIllIlIlIllllIIIll : null;
        }
        return null;
    }
    
    public void setInitialSpawnLocation() {
        this.setSpawnLocation(new BlockPos(8, 64, 8));
    }
    
    public boolean setBlockState(final BlockPos llllllllllllllIIllIlIlllIlIIlIlI, final IBlockState llllllllllllllIIllIlIlllIlIIlIIl) {
        return this.setBlockState(llllllllllllllIIllIlIlllIlIIlIlI, llllllllllllllIIllIlIlllIlIIlIIl, 3);
    }
    
    public Chunk getChunkFromChunkCoords(final int llllllllllllllIIllIlIllllIIIIIll, final int llllllllllllllIIllIlIllllIIIIIlI) {
        return this.chunkProvider.provideChunk(llllllllllllllIIllIlIllllIIIIIll, llllllllllllllIIllIlIllllIIIIIlI);
    }
    
    public int getActualHeight() {
        return this.provider.getHasNoSky() ? 128 : 256;
    }
    
    public boolean func_175677_d(final BlockPos llllllllllllllIIllIlIIIlIlIIlIlI, final boolean llllllllllllllIIllIlIIIlIlIIlIIl) {
        if (!this.isValid(llllllllllllllIIllIlIIIlIlIIlIlI)) {
            return llllllllllllllIIllIlIIIlIlIIlIIl;
        }
        final Chunk llllllllllllllIIllIlIIIlIlIIlIII = this.chunkProvider.func_177459_a(llllllllllllllIIllIlIIIlIlIIlIlI);
        if (llllllllllllllIIllIlIIIlIlIIlIII.isEmpty()) {
            return llllllllllllllIIllIlIIIlIlIIlIIl;
        }
        final Block llllllllllllllIIllIlIIIlIlIIIlll = this.getBlockState(llllllllllllllIIllIlIIIlIlIIlIlI).getBlock();
        return llllllllllllllIIllIlIIIlIlIIIlll.getMaterial().isOpaque() && llllllllllllllIIllIlIIIlIlIIIlll.isFullCube();
    }
    
    public EnumDifficulty getDifficulty() {
        return this.getWorldInfo().getDifficulty();
    }
    
    public MapStorage func_175693_T() {
        return this.mapStorage;
    }
    
    public Chunk getChunkFromBlockCoords(final BlockPos llllllllllllllIIllIlIllllIIIlIII) {
        return this.getChunkFromChunkCoords(llllllllllllllIIllIlIllllIIIlIII.getX() >> 4, llllllllllllllIIllIlIllllIIIlIII.getZ() >> 4);
    }
    
    protected void updateWeather() {
        if (!this.provider.getHasNoSky() && !this.isRemote) {
            int llllllllllllllIIllIlIIIlIIlIIlll = this.worldInfo.func_176133_A();
            if (llllllllllllllIIllIlIIIlIIlIIlll > 0) {
                --llllllllllllllIIllIlIIIlIIlIIlll;
                this.worldInfo.func_176142_i(llllllllllllllIIllIlIIIlIIlIIlll);
                this.worldInfo.setThunderTime(this.worldInfo.isThundering() ? 1 : 2);
                this.worldInfo.setRainTime(this.worldInfo.isRaining() ? 1 : 2);
            }
            int llllllllllllllIIllIlIIIlIIlIIllI = this.worldInfo.getThunderTime();
            if (llllllllllllllIIllIlIIIlIIlIIllI <= 0) {
                if (this.worldInfo.isThundering()) {
                    this.worldInfo.setThunderTime(this.rand.nextInt(12000) + 3600);
                }
                else {
                    this.worldInfo.setThunderTime(this.rand.nextInt(168000) + 12000);
                }
            }
            else {
                --llllllllllllllIIllIlIIIlIIlIIllI;
                this.worldInfo.setThunderTime(llllllllllllllIIllIlIIIlIIlIIllI);
                if (llllllllllllllIIllIlIIIlIIlIIllI <= 0) {
                    this.worldInfo.setThundering(!this.worldInfo.isThundering());
                }
            }
            this.prevThunderingStrength = this.thunderingStrength;
            if (this.worldInfo.isThundering()) {
                this.thunderingStrength += (float)0.01;
            }
            else {
                this.thunderingStrength -= (float)0.01;
            }
            this.thunderingStrength = MathHelper.clamp_float(this.thunderingStrength, 0.0f, 1.0f);
            int llllllllllllllIIllIlIIIlIIlIIlIl = this.worldInfo.getRainTime();
            if (llllllllllllllIIllIlIIIlIIlIIlIl <= 0) {
                if (this.worldInfo.isRaining()) {
                    this.worldInfo.setRainTime(this.rand.nextInt(12000) + 12000);
                }
                else {
                    this.worldInfo.setRainTime(this.rand.nextInt(168000) + 12000);
                }
            }
            else {
                --llllllllllllllIIllIlIIIlIIlIIlIl;
                this.worldInfo.setRainTime(llllllllllllllIIllIlIIIlIIlIIlIl);
                if (llllllllllllllIIllIlIIIlIIlIIlIl <= 0) {
                    this.worldInfo.setRaining(!this.worldInfo.isRaining());
                }
            }
            this.prevRainingStrength = this.rainingStrength;
            if (this.worldInfo.isRaining()) {
                this.rainingStrength += (float)0.01;
            }
            else {
                this.rainingStrength -= (float)0.01;
            }
            this.rainingStrength = MathHelper.clamp_float(this.rainingStrength, 0.0f, 1.0f);
        }
    }
    
    public void removeWorldAccess(final IWorldAccess llllllllllllllIIllIlIlIIlIllllIl) {
        this.worldAccesses.remove(llllllllllllllIIllIlIlIIlIllllIl);
    }
    
    public int getLightFor(final EnumSkyBlock llllllllllllllIIllIlIllIIllIlIIl, BlockPos llllllllllllllIIllIlIllIIllIIlII) {
        if (((Vec3i)llllllllllllllIIllIlIllIIllIIlII).getY() < 0) {
            llllllllllllllIIllIlIllIIllIIlII = (Comparable<Float>)new BlockPos(((Vec3i)llllllllllllllIIllIlIllIIllIIlII).getX(), 0, ((Vec3i)llllllllllllllIIllIlIllIIllIIlII).getZ());
        }
        if (!this.isValid((BlockPos)llllllllllllllIIllIlIllIIllIIlII)) {
            return llllllllllllllIIllIlIllIIllIlIIl.defaultLightValue;
        }
        if (!this.isBlockLoaded((BlockPos)llllllllllllllIIllIlIllIIllIIlII)) {
            return llllllllllllllIIllIlIllIIllIlIIl.defaultLightValue;
        }
        final Chunk llllllllllllllIIllIlIllIIllIIlll = this.getChunkFromBlockCoords((BlockPos)llllllllllllllIIllIlIllIIllIIlII);
        return llllllllllllllIIllIlIllIIllIIlll.getLightFor(llllllllllllllIIllIlIllIIllIlIIl, (BlockPos)llllllllllllllIIllIlIllIIllIIlII);
    }
    
    protected void calculateInitialWeather() {
        if (this.worldInfo.isRaining()) {
            this.rainingStrength = 1.0f;
            if (this.worldInfo.isThundering()) {
                this.thunderingStrength = 1.0f;
            }
        }
    }
    
    public int getUniqueDataId(final String llllllllllllllIIllIIllIlllIlIIll) {
        return this.mapStorage.getUniqueDataId(llllllllllllllIIllIIllIlllIlIIll);
    }
    
    public void markBlockRangeForRenderUpdate(final int llllllllllllllIIllIlIlllIIIlIIIl, final int llllllllllllllIIllIlIlllIIIIlIII, final int llllllllllllllIIllIlIlllIIIIllll, final int llllllllllllllIIllIlIlllIIIIlllI, final int llllllllllllllIIllIlIlllIIIIIlIl, final int llllllllllllllIIllIlIlllIIIIIlII) {
        for (int llllllllllllllIIllIlIlllIIIIlIll = 0; llllllllllllllIIllIlIlllIIIIlIll < this.worldAccesses.size(); ++llllllllllllllIIllIlIlllIIIIlIll) {
            this.worldAccesses.get(llllllllllllllIIllIlIlllIIIIlIll).markBlockRangeForRenderUpdate(llllllllllllllIIllIlIlllIIIlIIIl, llllllllllllllIIllIlIlllIIIIlIII, llllllllllllllIIllIlIlllIIIIllll, llllllllllllllIIllIlIlllIIIIlllI, llllllllllllllIIllIlIlllIIIIIlIl, llllllllllllllIIllIlIlllIIIIIlII);
        }
    }
    
    public DifficultyInstance getDifficultyForLocation(final BlockPos llllllllllllllIIllIIllIlIIllIllI) {
        long llllllllllllllIIllIIllIlIIllIlIl = 0L;
        float llllllllllllllIIllIIllIlIIllIlII = 0.0f;
        if (this.isBlockLoaded(llllllllllllllIIllIIllIlIIllIllI)) {
            llllllllllllllIIllIIllIlIIllIlII = this.getCurrentMoonPhaseFactor();
            llllllllllllllIIllIIllIlIIllIlIl = this.getChunkFromBlockCoords(llllllllllllllIIllIIllIlIIllIllI).getInhabitedTime();
        }
        return new DifficultyInstance(this.getDifficulty(), this.getWorldTime(), llllllllllllllIIllIIllIlIIllIlIl, llllllllllllllIIllIIllIlIIllIlII);
    }
    
    public boolean isRaining() {
        return this.getRainStrength(1.0f) > 0.2;
    }
    
    public float getCelestialAngle(final float llllllllllllllIIllIlIIlllllIllll) {
        return this.provider.calculateCelestialAngle(this.worldInfo.getWorldTime(), llllllllllllllIIllIlIIlllllIllll);
    }
    
    public boolean func_175665_u(final BlockPos llllllllllllllIIllIlIIIlIlIlllll) {
        final IBlockState llllllllllllllIIllIlIIIlIllIIIlI = this.getBlockState(llllllllllllllIIllIlIIIlIlIlllll);
        final AxisAlignedBB llllllllllllllIIllIlIIIlIllIIIIl = llllllllllllllIIllIlIIIlIllIIIlI.getBlock().getCollisionBoundingBox(this, llllllllllllllIIllIlIIIlIlIlllll, llllllllllllllIIllIlIIIlIllIIIlI);
        return llllllllllllllIIllIlIIIlIllIIIIl != null && llllllllllllllIIllIlIIIlIllIIIIl.getAverageEdgeLength() >= 1.0;
    }
    
    private boolean isAreaLoaded(int llllllllllllllIIllIlIllllIlIIIlI, final int llllllllllllllIIllIlIllllIlIIIIl, int llllllllllllllIIllIlIllllIlIIIII, int llllllllllllllIIllIlIllllIIlllll, final int llllllllllllllIIllIlIllllIlIlIII, int llllllllllllllIIllIlIllllIIlllIl, final boolean llllllllllllllIIllIlIllllIlIIllI) {
        if (llllllllllllllIIllIlIllllIlIlIII >= 0 && llllllllllllllIIllIlIllllIlIIIIl < 256) {
            llllllllllllllIIllIlIllllIlIIIlI >>= (String)4;
            llllllllllllllIIllIlIllllIlIIIII >>= (4 != 0);
            llllllllllllllIIllIlIllllIIlllll >>= 4;
            llllllllllllllIIllIlIllllIIlllIl >>= 4;
            for (int llllllllllllllIIllIlIllllIlIIlIl = (int)llllllllllllllIIllIlIllllIlIIIlI; llllllllllllllIIllIlIllllIlIIlIl <= llllllllllllllIIllIlIllllIIlllll; ++llllllllllllllIIllIlIllllIlIIlIl) {
                for (int llllllllllllllIIllIlIllllIlIIlII = llllllllllllllIIllIlIllllIlIIIII ? 1 : 0; llllllllllllllIIllIlIllllIlIIlII <= llllllllllllllIIllIlIllllIIlllIl; ++llllllllllllllIIllIlIllllIlIIlII) {
                    if (!this.isChunkLoaded(llllllllllllllIIllIlIllllIlIIlIl, llllllllllllllIIllIlIllllIlIIlII, llllllllllllllIIllIlIllllIlIIllI)) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
    
    public float getWeightedThunderStrength(final float llllllllllllllIIllIIlllIIIIlIllI) {
        return (this.prevThunderingStrength + (this.thunderingStrength - this.prevThunderingStrength) * llllllllllllllIIllIIlllIIIIlIllI) * this.getRainStrength(llllllllllllllIIllIIlllIIIIlIllI);
    }
    
    public boolean checkLightFor(final EnumSkyBlock llllllllllllllIIllIlIIIIIlIIllIl, final BlockPos llllllllllllllIIllIlIIIIIIlIIlII) {
        if (!this.isAreaLoaded(llllllllllllllIIllIlIIIIIIlIIlII, 17, false)) {
            return false;
        }
        int llllllllllllllIIllIlIIIIIlIIlIll = 0;
        int llllllllllllllIIllIlIIIIIlIIlIlI = 0;
        this.theProfiler.startSection("getBrightness");
        final int llllllllllllllIIllIlIIIIIlIIlIIl = this.getLightFor(llllllllllllllIIllIlIIIIIlIIllIl, llllllllllllllIIllIlIIIIIIlIIlII);
        final int llllllllllllllIIllIlIIIIIlIIlIII = this.func_175638_a(llllllllllllllIIllIlIIIIIIlIIlII, llllllllllllllIIllIlIIIIIlIIllIl);
        final int llllllllllllllIIllIlIIIIIlIIIlll = llllllllllllllIIllIlIIIIIIlIIlII.getX();
        final int llllllllllllllIIllIlIIIIIlIIIllI = llllllllllllllIIllIlIIIIIIlIIlII.getY();
        final int llllllllllllllIIllIlIIIIIlIIIlIl = llllllllllllllIIllIlIIIIIIlIIlII.getZ();
        if (llllllllllllllIIllIlIIIIIlIIlIII > llllllllllllllIIllIlIIIIIlIIlIIl) {
            this.lightUpdateBlockList[llllllllllllllIIllIlIIIIIlIIlIlI++] = 133152;
        }
        else if (llllllllllllllIIllIlIIIIIlIIlIII < llllllllllllllIIllIlIIIIIlIIlIIl) {
            this.lightUpdateBlockList[llllllllllllllIIllIlIIIIIlIIlIlI++] = (0x20820 | llllllllllllllIIllIlIIIIIlIIlIIl << 18);
            while (llllllllllllllIIllIlIIIIIlIIlIll < llllllllllllllIIllIlIIIIIlIIlIlI) {
                final int llllllllllllllIIllIlIIIIIlIIIlII = this.lightUpdateBlockList[llllllllllllllIIllIlIIIIIlIIlIll++];
                final int llllllllllllllIIllIlIIIIIlIIIIlI = (llllllllllllllIIllIlIIIIIlIIIlII & 0x3F) - 32 + llllllllllllllIIllIlIIIIIlIIIlll;
                final int llllllllllllllIIllIlIIIIIlIIIIII = (llllllllllllllIIllIlIIIIIlIIIlII >> 6 & 0x3F) - 32 + llllllllllllllIIllIlIIIIIlIIIllI;
                final int llllllllllllllIIllIlIIIIIIlllllI = (llllllllllllllIIllIlIIIIIlIIIlII >> 12 & 0x3F) - 32 + llllllllllllllIIllIlIIIIIlIIIlIl;
                final int llllllllllllllIIllIlIIIIIIllIlII = llllllllllllllIIllIlIIIIIlIIIlII >> 18 & 0xF;
                final BlockPos llllllllllllllIIllIlIIIIIIllIIll = new BlockPos(llllllllllllllIIllIlIIIIIlIIIIlI, llllllllllllllIIllIlIIIIIlIIIIII, llllllllllllllIIllIlIIIIIIlllllI);
                int llllllllllllllIIllIlIIIIIIllllII = this.getLightFor(llllllllllllllIIllIlIIIIIlIIllIl, llllllllllllllIIllIlIIIIIIllIIll);
                if (llllllllllllllIIllIlIIIIIIllllII == llllllllllllllIIllIlIIIIIIllIlII) {
                    this.setLightFor(llllllllllllllIIllIlIIIIIlIIllIl, llllllllllllllIIllIlIIIIIIllIIll, 0);
                    if (llllllllllllllIIllIlIIIIIIllIlII <= 0) {
                        continue;
                    }
                    final int llllllllllllllIIllIlIIIIIIlllIlI = MathHelper.abs_int(llllllllllllllIIllIlIIIIIlIIIIlI - llllllllllllllIIllIlIIIIIlIIIlll);
                    final int llllllllllllllIIllIlIIIIIIlllIII = MathHelper.abs_int(llllllllllllllIIllIlIIIIIlIIIIII - llllllllllllllIIllIlIIIIIlIIIllI);
                    final int llllllllllllllIIllIlIIIIIIllIllI = MathHelper.abs_int(llllllllllllllIIllIlIIIIIIlllllI - llllllllllllllIIllIlIIIIIlIIIlIl);
                    if (llllllllllllllIIllIlIIIIIIlllIlI + llllllllllllllIIllIlIIIIIIlllIII + llllllllllllllIIllIlIIIIIIllIllI >= 17) {
                        continue;
                    }
                    for (final EnumFacing llllllllllllllIIllIlIIIIIIlIllll : EnumFacing.values()) {
                        final int llllllllllllllIIllIlIIIIIIlIlllI = llllllllllllllIIllIlIIIIIlIIIIlI + llllllllllllllIIllIlIIIIIIlIllll.getFrontOffsetX();
                        final int llllllllllllllIIllIlIIIIIIlIllIl = llllllllllllllIIllIlIIIIIlIIIIII + llllllllllllllIIllIlIIIIIIlIllll.getFrontOffsetY();
                        final int llllllllllllllIIllIlIIIIIIlIllII = llllllllllllllIIllIlIIIIIIlllllI + llllllllllllllIIllIlIIIIIIlIllll.getFrontOffsetZ();
                        final BlockPos llllllllllllllIIllIlIIIIIIlIlIll = new BlockPos(llllllllllllllIIllIlIIIIIIlIlllI, llllllllllllllIIllIlIIIIIIlIllIl, llllllllllllllIIllIlIIIIIIlIllII);
                        final int llllllllllllllIIllIlIIIIIIlIlIlI = Math.max(1, this.getBlockState(llllllllllllllIIllIlIIIIIIlIlIll).getBlock().getLightOpacity());
                        llllllllllllllIIllIlIIIIIIllllII = this.getLightFor(llllllllllllllIIllIlIIIIIlIIllIl, llllllllllllllIIllIlIIIIIIlIlIll);
                        if (llllllllllllllIIllIlIIIIIIllllII == llllllllllllllIIllIlIIIIIIllIlII - llllllllllllllIIllIlIIIIIIlIlIlI && llllllllllllllIIllIlIIIIIlIIlIlI < this.lightUpdateBlockList.length) {
                            this.lightUpdateBlockList[llllllllllllllIIllIlIIIIIlIIlIlI++] = (llllllllllllllIIllIlIIIIIIlIlllI - llllllllllllllIIllIlIIIIIlIIIlll + 32 | llllllllllllllIIllIlIIIIIIlIllIl - llllllllllllllIIllIlIIIIIlIIIllI + 32 << 6 | llllllllllllllIIllIlIIIIIIlIllII - llllllllllllllIIllIlIIIIIlIIIlIl + 32 << 12 | llllllllllllllIIllIlIIIIIIllIlII - llllllllllllllIIllIlIIIIIIlIlIlI << 18);
                        }
                    }
                }
            }
            llllllllllllllIIllIlIIIIIlIIlIll = 0;
        }
        this.theProfiler.endSection();
        this.theProfiler.startSection("checkedPosition < toCheckCount");
        while (llllllllllllllIIllIlIIIIIlIIlIll < llllllllllllllIIllIlIIIIIlIIlIlI) {
            final int llllllllllllllIIllIlIIIIIlIIIIll = this.lightUpdateBlockList[llllllllllllllIIllIlIIIIIlIIlIll++];
            final int llllllllllllllIIllIlIIIIIlIIIIIl = (llllllllllllllIIllIlIIIIIlIIIIll & 0x3F) - 32 + llllllllllllllIIllIlIIIIIlIIIlll;
            final int llllllllllllllIIllIlIIIIIIllllll = (llllllllllllllIIllIlIIIIIlIIIIll >> 6 & 0x3F) - 32 + llllllllllllllIIllIlIIIIIlIIIllI;
            final int llllllllllllllIIllIlIIIIIIllllIl = (llllllllllllllIIllIlIIIIIlIIIIll >> 12 & 0x3F) - 32 + llllllllllllllIIllIlIIIIIlIIIlIl;
            final BlockPos llllllllllllllIIllIlIIIIIIlIlIIl = new BlockPos(llllllllllllllIIllIlIIIIIlIIIIIl, llllllllllllllIIllIlIIIIIIllllll, llllllllllllllIIllIlIIIIIIllllIl);
            final int llllllllllllllIIllIlIIIIIIlIlIII = this.getLightFor(llllllllllllllIIllIlIIIIIlIIllIl, llllllllllllllIIllIlIIIIIIlIlIIl);
            final int llllllllllllllIIllIlIIIIIIlllIll = this.func_175638_a(llllllllllllllIIllIlIIIIIIlIlIIl, llllllllllllllIIllIlIIIIIlIIllIl);
            if (llllllllllllllIIllIlIIIIIIlllIll != llllllllllllllIIllIlIIIIIIlIlIII) {
                this.setLightFor(llllllllllllllIIllIlIIIIIlIIllIl, llllllllllllllIIllIlIIIIIIlIlIIl, llllllllllllllIIllIlIIIIIIlllIll);
                if (llllllllllllllIIllIlIIIIIIlllIll <= llllllllllllllIIllIlIIIIIIlIlIII) {
                    continue;
                }
                final int llllllllllllllIIllIlIIIIIIlllIIl = Math.abs(llllllllllllllIIllIlIIIIIlIIIIIl - llllllllllllllIIllIlIIIIIlIIIlll);
                final int llllllllllllllIIllIlIIIIIIllIlll = Math.abs(llllllllllllllIIllIlIIIIIIllllll - llllllllllllllIIllIlIIIIIlIIIllI);
                final int llllllllllllllIIllIlIIIIIIllIlIl = Math.abs(llllllllllllllIIllIlIIIIIIllllIl - llllllllllllllIIllIlIIIIIlIIIlIl);
                final boolean llllllllllllllIIllIlIIIIIIlIIlll = llllllllllllllIIllIlIIIIIlIIlIlI < this.lightUpdateBlockList.length - 6;
                if (llllllllllllllIIllIlIIIIIIlllIIl + llllllllllllllIIllIlIIIIIIllIlll + llllllllllllllIIllIlIIIIIIllIlIl >= 17 || !llllllllllllllIIllIlIIIIIIlIIlll) {
                    continue;
                }
                if (this.getLightFor(llllllllllllllIIllIlIIIIIlIIllIl, llllllllllllllIIllIlIIIIIIlIlIIl.offsetWest()) < llllllllllllllIIllIlIIIIIIlllIll) {
                    this.lightUpdateBlockList[llllllllllllllIIllIlIIIIIlIIlIlI++] = llllllllllllllIIllIlIIIIIlIIIIIl - 1 - llllllllllllllIIllIlIIIIIlIIIlll + 32 + (llllllllllllllIIllIlIIIIIIllllll - llllllllllllllIIllIlIIIIIlIIIllI + 32 << 6) + (llllllllllllllIIllIlIIIIIIllllIl - llllllllllllllIIllIlIIIIIlIIIlIl + 32 << 12);
                }
                if (this.getLightFor(llllllllllllllIIllIlIIIIIlIIllIl, llllllllllllllIIllIlIIIIIIlIlIIl.offsetEast()) < llllllllllllllIIllIlIIIIIIlllIll) {
                    this.lightUpdateBlockList[llllllllllllllIIllIlIIIIIlIIlIlI++] = llllllllllllllIIllIlIIIIIlIIIIIl + 1 - llllllllllllllIIllIlIIIIIlIIIlll + 32 + (llllllllllllllIIllIlIIIIIIllllll - llllllllllllllIIllIlIIIIIlIIIllI + 32 << 6) + (llllllllllllllIIllIlIIIIIIllllIl - llllllllllllllIIllIlIIIIIlIIIlIl + 32 << 12);
                }
                if (this.getLightFor(llllllllllllllIIllIlIIIIIlIIllIl, llllllllllllllIIllIlIIIIIIlIlIIl.offsetDown()) < llllllllllllllIIllIlIIIIIIlllIll) {
                    this.lightUpdateBlockList[llllllllllllllIIllIlIIIIIlIIlIlI++] = llllllllllllllIIllIlIIIIIlIIIIIl - llllllllllllllIIllIlIIIIIlIIIlll + 32 + (llllllllllllllIIllIlIIIIIIllllll - 1 - llllllllllllllIIllIlIIIIIlIIIllI + 32 << 6) + (llllllllllllllIIllIlIIIIIIllllIl - llllllllllllllIIllIlIIIIIlIIIlIl + 32 << 12);
                }
                if (this.getLightFor(llllllllllllllIIllIlIIIIIlIIllIl, llllllllllllllIIllIlIIIIIIlIlIIl.offsetUp()) < llllllllllllllIIllIlIIIIIIlllIll) {
                    this.lightUpdateBlockList[llllllllllllllIIllIlIIIIIlIIlIlI++] = llllllllllllllIIllIlIIIIIlIIIIIl - llllllllllllllIIllIlIIIIIlIIIlll + 32 + (llllllllllllllIIllIlIIIIIIllllll + 1 - llllllllllllllIIllIlIIIIIlIIIllI + 32 << 6) + (llllllllllllllIIllIlIIIIIIllllIl - llllllllllllllIIllIlIIIIIlIIIlIl + 32 << 12);
                }
                if (this.getLightFor(llllllllllllllIIllIlIIIIIlIIllIl, llllllllllllllIIllIlIIIIIIlIlIIl.offsetNorth()) < llllllllllllllIIllIlIIIIIIlllIll) {
                    this.lightUpdateBlockList[llllllllllllllIIllIlIIIIIlIIlIlI++] = llllllllllllllIIllIlIIIIIlIIIIIl - llllllllllllllIIllIlIIIIIlIIIlll + 32 + (llllllllllllllIIllIlIIIIIIllllll - llllllllllllllIIllIlIIIIIlIIIllI + 32 << 6) + (llllllllllllllIIllIlIIIIIIllllIl - 1 - llllllllllllllIIllIlIIIIIlIIIlIl + 32 << 12);
                }
                if (this.getLightFor(llllllllllllllIIllIlIIIIIlIIllIl, llllllllllllllIIllIlIIIIIIlIlIIl.offsetSouth()) >= llllllllllllllIIllIlIIIIIIlllIll) {
                    continue;
                }
                this.lightUpdateBlockList[llllllllllllllIIllIlIIIIIlIIlIlI++] = llllllllllllllIIllIlIIIIIlIIIIIl - llllllllllllllIIllIlIIIIIlIIIlll + 32 + (llllllllllllllIIllIlIIIIIIllllll - llllllllllllllIIllIlIIIIIlIIIllI + 32 << 6) + (llllllllllllllIIllIlIIIIIIllllIl + 1 - llllllllllllllIIllIlIIIIIlIIIlIl + 32 << 12);
            }
        }
        this.theProfiler.endSection();
        return true;
    }
    
    public void unloadEntities(final Collection llllllllllllllIIllIIllllIIlllIll) {
        this.unloadedEntityList.addAll(llllllllllllllIIllIIllllIIlllIll);
    }
    
    protected abstract IChunkProvider createChunkProvider();
    
    @Override
    public BiomeGenBase getBiomeGenForCoords(final BlockPos llllllllllllllIIllIllIIIIIlIIlll) {
        if (this.isBlockLoaded(llllllllllllllIIllIllIIIIIlIIlll)) {
            final Chunk llllllllllllllIIllIllIIIIIlIIllI = this.getChunkFromBlockCoords(llllllllllllllIIllIllIIIIIlIIlll);
            try {
                return llllllllllllllIIllIllIIIIIlIIllI.getBiome(llllllllllllllIIllIllIIIIIlIIlll, this.provider.getWorldChunkManager());
            }
            catch (Throwable llllllllllllllIIllIllIIIIIlIIlIl) {
                final CrashReport llllllllllllllIIllIllIIIIIlIIlII = CrashReport.makeCrashReport(llllllllllllllIIllIllIIIIIlIIlIl, "Getting biome");
                final CrashReportCategory llllllllllllllIIllIllIIIIIlIIIll = llllllllllllllIIllIllIIIIIlIIlII.makeCategory("Coordinates of biome request");
                llllllllllllllIIllIllIIIIIlIIIll.addCrashSectionCallable("Location", new Callable() {
                    static {
                        __OBFID = "CL_00000141";
                    }
                    
                    @Override
                    public String call() {
                        return CrashReportCategory.getCoordinateInfo(llllllllllllllIIllIllIIIIIlIIlll);
                    }
                });
                throw new ReportedException(llllllllllllllIIllIllIIIIIlIIlII);
            }
        }
        return this.provider.getWorldChunkManager().func_180300_a(llllllllllllllIIllIllIIIIIlIIlll, BiomeGenBase.plains);
    }
    
    public void func_82738_a(final long llllllllllllllIIllIIlllIIlllIIII) {
        this.worldInfo.incrementTotalWorldTime(llllllllllllllIIllIIlllIIlllIIII);
    }
    
    public boolean func_175670_e(final BlockPos llllllllllllllIIllIlIIIIlIllllll, final boolean llllllllllllllIIllIlIIIIlIllIllI) {
        final BiomeGenBase llllllllllllllIIllIlIIIIlIllllIl = this.getBiomeGenForCoords(llllllllllllllIIllIlIIIIlIllllll);
        final float llllllllllllllIIllIlIIIIlIllllII = llllllllllllllIIllIlIIIIlIllllIl.func_180626_a(llllllllllllllIIllIlIIIIlIllllll);
        if (llllllllllllllIIllIlIIIIlIllllII > 0.15f) {
            return false;
        }
        if (llllllllllllllIIllIlIIIIlIllllll.getY() >= 0 && llllllllllllllIIllIlIIIIlIllllll.getY() < 256 && this.getLightFor(EnumSkyBlock.BLOCK, llllllllllllllIIllIlIIIIlIllllll) < 10) {
            final IBlockState llllllllllllllIIllIlIIIIlIlllIll = this.getBlockState(llllllllllllllIIllIlIIIIlIllllll);
            final Block llllllllllllllIIllIlIIIIlIlllIlI = llllllllllllllIIllIlIIIIlIlllIll.getBlock();
            if ((llllllllllllllIIllIlIIIIlIlllIlI == Blocks.water || llllllllllllllIIllIlIIIIlIlllIlI == Blocks.flowing_water) && (int)llllllllllllllIIllIlIIIIlIlllIll.getValue(BlockLiquid.LEVEL) == 0) {
                if (!llllllllllllllIIllIlIIIIlIllIllI) {
                    return true;
                }
                final boolean llllllllllllllIIllIlIIIIlIlllIIl = this.func_175696_F(llllllllllllllIIllIlIIIIlIllllll.offsetWest()) && this.func_175696_F(llllllllllllllIIllIlIIIIlIllllll.offsetEast()) && this.func_175696_F(llllllllllllllIIllIlIIIIlIllllll.offsetNorth()) && this.func_175696_F(llllllllllllllIIllIlIIIIlIllllll.offsetSouth());
                if (!llllllllllllllIIllIlIIIIlIlllIIl) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void func_175717_a(final BlockPos llllllllllllllIIllIlIlIlIllIIlIl, final String llllllllllllllIIllIlIlIlIllIIIII) {
        for (int llllllllllllllIIllIlIlIlIllIIIll = 0; llllllllllllllIIllIlIlIlIllIIIll < this.worldAccesses.size(); ++llllllllllllllIIllIlIlIlIllIIIll) {
            this.worldAccesses.get(llllllllllllllIIllIlIlIlIllIIIll).func_174961_a(llllllllllllllIIllIlIlIlIllIIIII, llllllllllllllIIllIlIlIlIllIIlIl);
        }
    }
    
    public void removeTileEntity(final BlockPos llllllllllllllIIllIlIIIlIlllIIII) {
        final TileEntity llllllllllllllIIllIlIIIlIlllIIlI = this.getTileEntity(llllllllllllllIIllIlIIIlIlllIIII);
        if (llllllllllllllIIllIlIIIlIlllIIlI != null && this.processingLoadedTiles) {
            llllllllllllllIIllIlIIIlIlllIIlI.invalidate();
            this.addedTileEntityList.remove(llllllllllllllIIllIlIIIlIlllIIlI);
        }
        else {
            if (llllllllllllllIIllIlIIIlIlllIIlI != null) {
                this.addedTileEntityList.remove(llllllllllllllIIllIlIIIlIlllIIlI);
                this.loadedTileEntityList.remove(llllllllllllllIIllIlIIIlIlllIIlI);
                this.tickableTileEntities.remove(llllllllllllllIIllIlIIIlIlllIIlI);
            }
            this.getChunkFromBlockCoords(llllllllllllllIIllIlIIIlIlllIIII).removeTileEntity(llllllllllllllIIllIlIIIlIlllIIII);
        }
    }
    
    public void func_175637_a(final Block llllllllllllllIIllIlIIIIllIlIlll, final BlockPos llllllllllllllIIllIlIIIIllIlIllI, final Random llllllllllllllIIllIlIIIIllIllIIl) {
        this.scheduledUpdatesAreImmediate = true;
        llllllllllllllIIllIlIIIIllIlIlll.updateTick(this, llllllllllllllIIllIlIIIIllIlIllI, this.getBlockState(llllllllllllllIIllIlIIIIllIlIllI), llllllllllllllIIllIlIIIIllIllIIl);
        this.scheduledUpdatesAreImmediate = false;
    }
    
    public void loadEntities(final Collection llllllllllllllIIllIIllllIlIIIIll) {
        this.loadedEntityList.addAll(llllllllllllllIIllIIllllIlIIIIll);
        for (final Entity llllllllllllllIIllIIllllIlIIIlIl : llllllllllllllIIllIIllllIlIIIIll) {
            this.onEntityAdded(llllllllllllllIIllIIllllIlIIIlIl);
        }
    }
    
    @Override
    public int getCombinedLight(final BlockPos llllllllllllllIIllIlIllIIlIIIlII, final int llllllllllllllIIllIlIllIIIlllllI) {
        final int llllllllllllllIIllIlIllIIlIIIIlI = this.getLightFromNeighborsFor(EnumSkyBlock.SKY, llllllllllllllIIllIlIllIIlIIIlII);
        int llllllllllllllIIllIlIllIIlIIIIIl = this.getLightFromNeighborsFor(EnumSkyBlock.BLOCK, llllllllllllllIIllIlIllIIlIIIlII);
        if (llllllllllllllIIllIlIllIIlIIIIIl < llllllllllllllIIllIlIllIIIlllllI) {
            llllllllllllllIIllIlIllIIlIIIIIl = llllllllllllllIIllIlIllIIIlllllI;
        }
        return llllllllllllllIIllIlIllIIlIIIIlI << 20 | llllllllllllllIIllIlIllIIlIIIIIl << 4;
    }
    
    public void calculateInitialSkylight() {
        final int llllllllllllllIIllIlIIIlIIlllllI = this.calculateSkylightSubtracted(1.0f);
        if (llllllllllllllIIllIlIIIlIIlllllI != this.skylightSubtracted) {
            this.skylightSubtracted = llllllllllllllIIllIlIIIlIIlllllI;
        }
    }
    
    public float getRainStrength(final float llllllllllllllIIllIIlllIIIIIllII) {
        return this.prevRainingStrength + (this.rainingStrength - this.prevRainingStrength) * llllllllllllllIIllIIlllIIIIIllII;
    }
    
    public void notifyNeighborsOfStateExcept(final BlockPos llllllllllllllIIllIlIllIllllIlII, final Block llllllllllllllIIllIlIllIllllIIll, final EnumFacing llllllllllllllIIllIlIllIlllIlllI) {
        if (llllllllllllllIIllIlIllIlllIlllI != EnumFacing.WEST) {
            this.notifyBlockOfStateChange(llllllllllllllIIllIlIllIllllIlII.offsetWest(), llllllllllllllIIllIlIllIllllIIll);
        }
        if (llllllllllllllIIllIlIllIlllIlllI != EnumFacing.EAST) {
            this.notifyBlockOfStateChange(llllllllllllllIIllIlIllIllllIlII.offsetEast(), llllllllllllllIIllIlIllIllllIIll);
        }
        if (llllllllllllllIIllIlIllIlllIlllI != EnumFacing.DOWN) {
            this.notifyBlockOfStateChange(llllllllllllllIIllIlIllIllllIlII.offsetDown(), llllllllllllllIIllIlIllIllllIIll);
        }
        if (llllllllllllllIIllIlIllIlllIlllI != EnumFacing.UP) {
            this.notifyBlockOfStateChange(llllllllllllllIIllIlIllIllllIlII.offsetUp(), llllllllllllllIIllIlIllIllllIIll);
        }
        if (llllllllllllllIIllIlIllIlllIlllI != EnumFacing.NORTH) {
            this.notifyBlockOfStateChange(llllllllllllllIIllIlIllIllllIlII.offsetNorth(), llllllllllllllIIllIlIllIllllIIll);
        }
        if (llllllllllllllIIllIlIllIlllIlllI != EnumFacing.SOUTH) {
            this.notifyBlockOfStateChange(llllllllllllllIIllIlIllIllllIlII.offsetSouth(), llllllllllllllIIllIlIllIllllIIll);
        }
    }
    
    public boolean isAreaLoaded(final StructureBoundingBox llllllllllllllIIllIlIlllllIIIIll) {
        return this.isAreaLoaded(llllllllllllllIIllIlIlllllIIIIll, true);
    }
    
    public List func_175712_a(final StructureBoundingBox llllllllllllllIIllIlIIIIIIIIIIll, final boolean llllllllllllllIIllIlIIIIIIIIIIlI) {
        return null;
    }
    
    public boolean isBlockLoaded(final BlockPos llllllllllllllIIllIlIlllllllllII) {
        return this.isBlockLoaded(llllllllllllllIIllIlIlllllllllII, true);
    }
    
    public boolean canBlockBePlaced(final Block llllllllllllllIIllIIllllIIllIIII, final BlockPos llllllllllllllIIllIIllllIIlIllll, final boolean llllllllllllllIIllIIllllIIlIIlIl, final EnumFacing llllllllllllllIIllIIllllIIlIIlII, final Entity llllllllllllllIIllIIllllIIlIIIll, final ItemStack llllllllllllllIIllIIllllIIlIlIll) {
        final Block llllllllllllllIIllIIllllIIlIlIlI = this.getBlockState(llllllllllllllIIllIIllllIIlIllll).getBlock();
        final AxisAlignedBB llllllllllllllIIllIIllllIIlIlIIl = llllllllllllllIIllIIllllIIlIIlIl ? null : llllllllllllllIIllIIllllIIllIIII.getCollisionBoundingBox(this, llllllllllllllIIllIIllllIIlIllll, llllllllllllllIIllIIllllIIllIIII.getDefaultState());
        return (llllllllllllllIIllIIllllIIlIlIIl == null || this.checkNoEntityCollision(llllllllllllllIIllIIllllIIlIlIIl, llllllllllllllIIllIIllllIIlIIIll)) && ((llllllllllllllIIllIIllllIIlIlIlI.getMaterial() == Material.circuits && llllllllllllllIIllIIllllIIllIIII == Blocks.anvil) || (llllllllllllllIIllIIllllIIlIlIlI.getMaterial().isReplaceable() && llllllllllllllIIllIIllllIIllIIII.canReplace(this, llllllllllllllIIllIIllllIIlIllll, llllllllllllllIIllIIllllIIlIIlII, llllllllllllllIIllIIllllIIlIlIll)));
    }
    
    public void setWorldTime(final long llllllllllllllIIllIIlllIIlIlllll) {
        this.worldInfo.setWorldTime(llllllllllllllIIllIIlllIIlIlllll);
    }
    
    public boolean checkBlockCollision(final AxisAlignedBB llllllllllllllIIllIlIIlIlllIIlll) {
        final int llllllllllllllIIllIlIIlIllllIIlI = MathHelper.floor_double(llllllllllllllIIllIlIIlIlllIIlll.minX);
        final int llllllllllllllIIllIlIIlIllllIIIl = MathHelper.floor_double(llllllllllllllIIllIlIIlIlllIIlll.maxX);
        final int llllllllllllllIIllIlIIlIllllIIII = MathHelper.floor_double(llllllllllllllIIllIlIIlIlllIIlll.minY);
        final int llllllllllllllIIllIlIIlIlllIllll = MathHelper.floor_double(llllllllllllllIIllIlIIlIlllIIlll.maxY);
        final int llllllllllllllIIllIlIIlIlllIlllI = MathHelper.floor_double(llllllllllllllIIllIlIIlIlllIIlll.minZ);
        final int llllllllllllllIIllIlIIlIlllIllIl = MathHelper.floor_double(llllllllllllllIIllIlIIlIlllIIlll.maxZ);
        for (int llllllllllllllIIllIlIIlIlllIllII = llllllllllllllIIllIlIIlIllllIIlI; llllllllllllllIIllIlIIlIlllIllII <= llllllllllllllIIllIlIIlIllllIIIl; ++llllllllllllllIIllIlIIlIlllIllII) {
            for (int llllllllllllllIIllIlIIlIlllIlIll = llllllllllllllIIllIlIIlIllllIIII; llllllllllllllIIllIlIIlIlllIlIll <= llllllllllllllIIllIlIIlIlllIllll; ++llllllllllllllIIllIlIIlIlllIlIll) {
                for (int llllllllllllllIIllIlIIlIlllIlIlI = llllllllllllllIIllIlIIlIlllIlllI; llllllllllllllIIllIlIIlIlllIlIlI <= llllllllllllllIIllIlIIlIlllIllIl; ++llllllllllllllIIllIlIIlIlllIlIlI) {
                    final Block llllllllllllllIIllIlIIlIlllIlIIl = this.getBlockState(new BlockPos(llllllllllllllIIllIlIIlIlllIllII, llllllllllllllIIllIlIIlIlllIlIll, llllllllllllllIIllIlIIlIlllIlIlI)).getBlock();
                    if (llllllllllllllIIllIlIIlIlllIlIIl.getMaterial() != Material.air) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public void addBlockEvent(final BlockPos llllllllllllllIIllIIlllIIIlIlllI, final Block llllllllllllllIIllIIlllIIIlIlIII, final int llllllllllllllIIllIIlllIIIlIIlll, final int llllllllllllllIIllIIlllIIIlIIllI) {
        llllllllllllllIIllIIlllIIIlIlIII.onBlockEventReceived(this, llllllllllllllIIllIIlllIIIlIlllI, this.getBlockState(llllllllllllllIIllIIlllIIIlIlllI), llllllllllllllIIllIIlllIIIlIIlll, llllllllllllllIIllIIlllIIIlIIllI);
    }
    
    public void markBlocksDirtyVertical(final int llllllllllllllIIllIlIlllIIlIlIII, final int llllllllllllllIIllIlIlllIIlIIlll, int llllllllllllllIIllIlIlllIIlIllIl, int llllllllllllllIIllIlIlllIIlIIlIl) {
        if (llllllllllllllIIllIlIlllIIlIllIl > llllllllllllllIIllIlIlllIIlIIlIl) {
            final int llllllllllllllIIllIlIlllIIlIlIll = llllllllllllllIIllIlIlllIIlIIlIl;
            llllllllllllllIIllIlIlllIIlIIlIl = llllllllllllllIIllIlIlllIIlIllIl;
            llllllllllllllIIllIlIlllIIlIllIl = llllllllllllllIIllIlIlllIIlIlIll;
        }
        if (!this.provider.getHasNoSky()) {
            for (int llllllllllllllIIllIlIlllIIlIlIlI = llllllllllllllIIllIlIlllIIlIllIl; llllllllllllllIIllIlIlllIIlIlIlI <= llllllllllllllIIllIlIlllIIlIIlIl; ++llllllllllllllIIllIlIlllIIlIlIlI) {
                this.checkLightFor(EnumSkyBlock.SKY, new BlockPos(llllllllllllllIIllIlIlllIIlIlIII, llllllllllllllIIllIlIlllIIlIlIlI, llllllllllllllIIllIlIlllIIlIIlll));
            }
        }
        this.markBlockRangeForRenderUpdate(llllllllllllllIIllIlIlllIIlIlIII, llllllllllllllIIllIlIlllIIlIllIl, llllllllllllllIIllIlIlllIIlIIlll, llllllllllllllIIllIlIlllIIlIlIII, llllllllllllllIIllIlIlllIIlIIlIl, llllllllllllllIIllIlIlllIIlIIlll);
    }
    
    public void setRainStrength(final float llllllllllllllIIllIIlllIIIIIIlII) {
        this.prevRainingStrength = llllllllllllllIIllIIlllIIIIIIlII;
        this.rainingStrength = llllllllllllllIIllIIlllIIIIIIlII;
    }
    
    public void updateAllPlayersSleepingFlag() {
    }
    
    public float getStarBrightness(final float llllllllllllllIIllIlIIlllIIlIIII) {
        final float llllllllllllllIIllIlIIlllIIlIIll = this.getCelestialAngle(llllllllllllllIIllIlIIlllIIlIIII);
        float llllllllllllllIIllIlIIlllIIlIIlI = 1.0f - (MathHelper.cos(llllllllllllllIIllIlIIlllIIlIIll * 3.1415927f * 2.0f) * 2.0f + 0.25f);
        llllllllllllllIIllIlIIlllIIlIIlI = MathHelper.clamp_float(llllllllllllllIIllIlIIlllIIlIIlI, 0.0f, 1.0f);
        return llllllllllllllIIllIlIIlllIIlIIlI * llllllllllllllIIllIlIIlllIIlIIlI * 0.5f;
    }
    
    public Entity getEntityByID(final int llllllllllllllIIllIIllllIllIlIII) {
        return (Entity)this.entitiesById.lookup(llllllllllllllIIllIIllllIllIlIII);
    }
    
    public int getStrongPower(final BlockPos llllllllllllllIIllIIllllIIIIIlll) {
        final byte llllllllllllllIIllIIllllIIIIlIlI = 0;
        int llllllllllllllIIllIIllllIIIIlIIl = Math.max(llllllllllllllIIllIIllllIIIIlIlI, this.getStrongPower(llllllllllllllIIllIIllllIIIIIlll.offsetDown(), EnumFacing.DOWN));
        if (llllllllllllllIIllIIllllIIIIlIIl >= 15) {
            return llllllllllllllIIllIIllllIIIIlIIl;
        }
        llllllllllllllIIllIIllllIIIIlIIl = Math.max(llllllllllllllIIllIIllllIIIIlIIl, this.getStrongPower(llllllllllllllIIllIIllllIIIIIlll.offsetUp(), EnumFacing.UP));
        if (llllllllllllllIIllIIllllIIIIlIIl >= 15) {
            return llllllllllllllIIllIIllllIIIIlIIl;
        }
        llllllllllllllIIllIIllllIIIIlIIl = Math.max(llllllllllllllIIllIIllllIIIIlIIl, this.getStrongPower(llllllllllllllIIllIIllllIIIIIlll.offsetNorth(), EnumFacing.NORTH));
        if (llllllllllllllIIllIIllllIIIIlIIl >= 15) {
            return llllllllllllllIIllIIllllIIIIlIIl;
        }
        llllllllllllllIIllIIllllIIIIlIIl = Math.max(llllllllllllllIIllIIllllIIIIlIIl, this.getStrongPower(llllllllllllllIIllIIllllIIIIIlll.offsetSouth(), EnumFacing.SOUTH));
        if (llllllllllllllIIllIIllllIIIIlIIl >= 15) {
            return llllllllllllllIIllIIllllIIIIlIIl;
        }
        llllllllllllllIIllIIllllIIIIlIIl = Math.max(llllllllllllllIIllIIllllIIIIlIIl, this.getStrongPower(llllllllllllllIIllIIllllIIIIIlll.offsetWest(), EnumFacing.WEST));
        if (llllllllllllllIIllIIllllIIIIlIIl >= 15) {
            return llllllllllllllIIllIIllllIIIIlIIl;
        }
        llllllllllllllIIllIIllllIIIIlIIl = Math.max(llllllllllllllIIllIIllllIIIIlIIl, this.getStrongPower(llllllllllllllIIllIIllllIIIIIlll.offsetEast(), EnumFacing.EAST));
        return (llllllllllllllIIllIIllllIIIIlIIl >= 15) ? llllllllllllllIIllIIllllIIIIlIIl : llllllllllllllIIllIIllllIIIIlIIl;
    }
    
    public boolean tickUpdates(final boolean llllllllllllllIIllIlIIIIIIIIlIII) {
        return false;
    }
    
    public boolean isBlockPowered(final BlockPos llllllllllllllIIllIIlllIlllIIlll) {
        return this.getRedstonePower(llllllllllllllIIllIIlllIlllIIlll.offsetDown(), EnumFacing.DOWN) > 0 || this.getRedstonePower(llllllllllllllIIllIIlllIlllIIlll.offsetUp(), EnumFacing.UP) > 0 || this.getRedstonePower(llllllllllllllIIllIIlllIlllIIlll.offsetNorth(), EnumFacing.NORTH) > 0 || this.getRedstonePower(llllllllllllllIIllIIlllIlllIIlll.offsetSouth(), EnumFacing.SOUTH) > 0 || this.getRedstonePower(llllllllllllllIIllIIlllIlllIIlll.offsetWest(), EnumFacing.WEST) > 0 || this.getRedstonePower(llllllllllllllIIllIIlllIlllIIlll.offsetEast(), EnumFacing.EAST) > 0;
    }
    
    public boolean isAreaLoaded(final BlockPos llllllllllllllIIllIlIllllllIllII, final int llllllllllllllIIllIlIllllllIlIll) {
        return this.isAreaLoaded(llllllllllllllIIllIlIllllllIllII, llllllllllllllIIllIlIllllllIlIll, true);
    }
    
    private boolean func_175696_F(final BlockPos llllllllllllllIIllIlIIIIlIlIllIl) {
        return this.getBlockState(llllllllllllllIIllIlIIIIlIlIllIl).getBlock().getMaterial() == Material.water;
    }
    
    public Calendar getCurrentDate() {
        if (this.getTotalWorldTime() % 600L == 0L) {
            this.theCalendar.setTimeInMillis(MinecraftServer.getCurrentTimeMillis());
        }
        return this.theCalendar;
    }
    
    protected void onEntityRemoved(final Entity llllllllllllllIIllIlIlIIllIlllII) {
        for (int llllllllllllllIIllIlIlIIllIllllI = 0; llllllllllllllIIllIlIlIIllIllllI < this.worldAccesses.size(); ++llllllllllllllIIllIlIlIIllIllllI) {
            this.worldAccesses.get(llllllllllllllIIllIlIlIIllIllllI).onEntityRemoved(llllllllllllllIIllIlIlIIllIlllII);
        }
    }
    
    public boolean handleMaterialAcceleration(final AxisAlignedBB llllllllllllllIIllIlIIlIlIIIIIII, final Material llllllllllllllIIllIlIIlIIllIlIll, final Entity llllllllllllllIIllIlIIlIIllIlIlI) {
        final int llllllllllllllIIllIlIIlIIlllllIl = MathHelper.floor_double(llllllllllllllIIllIlIIlIlIIIIIII.minX);
        final int llllllllllllllIIllIlIIlIIlllllII = MathHelper.floor_double(llllllllllllllIIllIlIIlIlIIIIIII.maxX + 1.0);
        final int llllllllllllllIIllIlIIlIIllllIll = MathHelper.floor_double(llllllllllllllIIllIlIIlIlIIIIIII.minY);
        final int llllllllllllllIIllIlIIlIIllllIlI = MathHelper.floor_double(llllllllllllllIIllIlIIlIlIIIIIII.maxY + 1.0);
        final int llllllllllllllIIllIlIIlIIllllIIl = MathHelper.floor_double(llllllllllllllIIllIlIIlIlIIIIIII.minZ);
        final int llllllllllllllIIllIlIIlIIllllIII = MathHelper.floor_double(llllllllllllllIIllIlIIlIlIIIIIII.maxZ + 1.0);
        if (!this.isAreaLoaded(llllllllllllllIIllIlIIlIIlllllIl, llllllllllllllIIllIlIIlIIllllIll, llllllllllllllIIllIlIIlIIllllIIl, llllllllllllllIIllIlIIlIIlllllII, llllllllllllllIIllIlIIlIIllllIlI, llllllllllllllIIllIlIIlIIllllIII, true)) {
            return false;
        }
        boolean llllllllllllllIIllIlIIlIIlllIlll = false;
        Vec3 llllllllllllllIIllIlIIlIIlllIllI = new Vec3(0.0, 0.0, 0.0);
        for (int llllllllllllllIIllIlIIlIIlllIlIl = llllllllllllllIIllIlIIlIIlllllIl; llllllllllllllIIllIlIIlIIlllIlIl < llllllllllllllIIllIlIIlIIlllllII; ++llllllllllllllIIllIlIIlIIlllIlIl) {
            for (int llllllllllllllIIllIlIIlIIlllIlII = llllllllllllllIIllIlIIlIIllllIll; llllllllllllllIIllIlIIlIIlllIlII < llllllllllllllIIllIlIIlIIllllIlI; ++llllllllllllllIIllIlIIlIIlllIlII) {
                for (int llllllllllllllIIllIlIIlIIlllIIll = llllllllllllllIIllIlIIlIIllllIIl; llllllllllllllIIllIlIIlIIlllIIll < llllllllllllllIIllIlIIlIIllllIII; ++llllllllllllllIIllIlIIlIIlllIIll) {
                    final BlockPos llllllllllllllIIllIlIIlIIlllIIlI = new BlockPos(llllllllllllllIIllIlIIlIIlllIlIl, llllllllllllllIIllIlIIlIIlllIlII, llllllllllllllIIllIlIIlIIlllIIll);
                    final IBlockState llllllllllllllIIllIlIIlIIlllIIIl = this.getBlockState(llllllllllllllIIllIlIIlIIlllIIlI);
                    final Block llllllllllllllIIllIlIIlIIlllIIII = llllllllllllllIIllIlIIlIIlllIIIl.getBlock();
                    if (llllllllllllllIIllIlIIlIIlllIIII.getMaterial() == llllllllllllllIIllIlIIlIIllIlIll) {
                        final double llllllllllllllIIllIlIIlIIllIllll = llllllllllllllIIllIlIIlIIlllIlII + 1 - BlockLiquid.getLiquidHeightPercent((int)llllllllllllllIIllIlIIlIIlllIIIl.getValue(BlockLiquid.LEVEL));
                        if (llllllllllllllIIllIlIIlIIllllIlI >= llllllllllllllIIllIlIIlIIllIllll) {
                            llllllllllllllIIllIlIIlIIlllIlll = true;
                            llllllllllllllIIllIlIIlIIlllIllI = llllllllllllllIIllIlIIlIIlllIIII.modifyAcceleration(this, llllllllllllllIIllIlIIlIIlllIIlI, llllllllllllllIIllIlIIlIIllIlIlI, llllllllllllllIIllIlIIlIIlllIllI);
                        }
                    }
                }
            }
        }
        if (llllllllllllllIIllIlIIlIIlllIllI.lengthVector() > 0.0 && llllllllllllllIIllIlIIlIIllIlIlI.isPushedByWater()) {
            llllllllllllllIIllIlIIlIIlllIllI = llllllllllllllIIllIlIIlIIlllIllI.normalize();
            final double llllllllllllllIIllIlIIlIIllIlllI = 0.014;
            llllllllllllllIIllIlIIlIIllIlIlI.motionX += llllllllllllllIIllIlIIlIIlllIllI.xCoord * llllllllllllllIIllIlIIlIIllIlllI;
            llllllllllllllIIllIlIIlIIllIlIlI.motionY += llllllllllllllIIllIlIIlIIlllIllI.yCoord * llllllllllllllIIllIlIIlIIllIlllI;
            llllllllllllllIIllIlIIlIIllIlIlI.motionZ += llllllllllllllIIllIlIIlIIlllIllI.zCoord * llllllllllllllIIllIlIIlIIllIlllI;
        }
        return llllllllllllllIIllIlIIlIIlllIlll;
    }
    
    public void updateComparatorOutputLevel(final BlockPos llllllllllllllIIllIIllIlIlIIIIIl, final Block llllllllllllllIIllIIllIlIlIIIlll) {
        for (final EnumFacing llllllllllllllIIllIIllIlIlIIIlIl : EnumFacing.Plane.HORIZONTAL) {
            BlockPos llllllllllllllIIllIIllIlIlIIIlII = llllllllllllllIIllIIllIlIlIIIIIl.offset(llllllllllllllIIllIIllIlIlIIIlIl);
            if (this.isBlockLoaded(llllllllllllllIIllIIllIlIlIIIlII)) {
                IBlockState llllllllllllllIIllIIllIlIlIIIIll = this.getBlockState(llllllllllllllIIllIIllIlIlIIIlII);
                if (Blocks.unpowered_comparator.func_149907_e(llllllllllllllIIllIIllIlIlIIIIll.getBlock())) {
                    llllllllllllllIIllIIllIlIlIIIIll.getBlock().onNeighborBlockChange(this, llllllllllllllIIllIIllIlIlIIIlII, llllllllllllllIIllIIllIlIlIIIIll, llllllllllllllIIllIIllIlIlIIIlll);
                }
                else {
                    if (!llllllllllllllIIllIIllIlIlIIIIll.getBlock().isNormalCube()) {
                        continue;
                    }
                    llllllllllllllIIllIIllIlIlIIIlII = llllllllllllllIIllIIllIlIlIIIlII.offset(llllllllllllllIIllIIllIlIlIIIlIl);
                    llllllllllllllIIllIIllIlIlIIIIll = this.getBlockState(llllllllllllllIIllIIllIlIlIIIlII);
                    if (!Blocks.unpowered_comparator.func_149907_e(llllllllllllllIIllIIllIlIlIIIIll.getBlock())) {
                        continue;
                    }
                    llllllllllllllIIllIIllIlIlIIIIll.getBlock().onNeighborBlockChange(this, llllllllllllllIIllIIllIlIlIIIlII, llllllllllllllIIllIIllIlIlIIIIll, llllllllllllllIIllIIllIlIlIIIlll);
                }
            }
        }
    }
    
    public float getBlockDensity(final Vec3 llllllllllllllIIllIlIIIllIllIllI, final AxisAlignedBB llllllllllllllIIllIlIIIlllIIIIll) {
        final double llllllllllllllIIllIlIIIlllIIIIlI = 1.0 / ((llllllllllllllIIllIlIIIlllIIIIll.maxX - llllllllllllllIIllIlIIIlllIIIIll.minX) * 2.0 + 1.0);
        final double llllllllllllllIIllIlIIIlllIIIIIl = 1.0 / ((llllllllllllllIIllIlIIIlllIIIIll.maxY - llllllllllllllIIllIlIIIlllIIIIll.minY) * 2.0 + 1.0);
        final double llllllllllllllIIllIlIIIlllIIIIII = 1.0 / ((llllllllllllllIIllIlIIIlllIIIIll.maxZ - llllllllllllllIIllIlIIIlllIIIIll.minZ) * 2.0 + 1.0);
        if (llllllllllllllIIllIlIIIlllIIIIlI >= 0.0 && llllllllllllllIIllIlIIIlllIIIIIl >= 0.0 && llllllllllllllIIllIlIIIlllIIIIII >= 0.0) {
            int llllllllllllllIIllIlIIIllIllllll = 0;
            int llllllllllllllIIllIlIIIllIlllllI = 0;
            for (float llllllllllllllIIllIlIIIllIllllIl = 0.0f; llllllllllllllIIllIlIIIllIllllIl <= 1.0f; llllllllllllllIIllIlIIIllIllllIl += (float)llllllllllllllIIllIlIIIlllIIIIlI) {
                for (float llllllllllllllIIllIlIIIllIllllII = 0.0f; llllllllllllllIIllIlIIIllIllllII <= 1.0f; llllllllllllllIIllIlIIIllIllllII += (float)llllllllllllllIIllIlIIIlllIIIIIl) {
                    for (float llllllllllllllIIllIlIIIllIlllIll = 0.0f; llllllllllllllIIllIlIIIllIlllIll <= 1.0f; llllllllllllllIIllIlIIIllIlllIll += (float)llllllllllllllIIllIlIIIlllIIIIII) {
                        final double llllllllllllllIIllIlIIIllIlllIlI = llllllllllllllIIllIlIIIlllIIIIll.minX + (llllllllllllllIIllIlIIIlllIIIIll.maxX - llllllllllllllIIllIlIIIlllIIIIll.minX) * llllllllllllllIIllIlIIIllIllllIl;
                        final double llllllllllllllIIllIlIIIllIlllIIl = llllllllllllllIIllIlIIIlllIIIIll.minY + (llllllllllllllIIllIlIIIlllIIIIll.maxY - llllllllllllllIIllIlIIIlllIIIIll.minY) * llllllllllllllIIllIlIIIllIllllII;
                        final double llllllllllllllIIllIlIIIllIlllIII = llllllllllllllIIllIlIIIlllIIIIll.minZ + (llllllllllllllIIllIlIIIlllIIIIll.maxZ - llllllllllllllIIllIlIIIlllIIIIll.minZ) * llllllllllllllIIllIlIIIllIlllIll;
                        if (this.rayTraceBlocks(new Vec3(llllllllllllllIIllIlIIIllIlllIlI, llllllllllllllIIllIlIIIllIlllIIl, llllllllllllllIIllIlIIIllIlllIII), llllllllllllllIIllIlIIIllIllIllI) == null) {
                            ++llllllllllllllIIllIlIIIllIllllll;
                        }
                        ++llllllllllllllIIllIlIIIllIlllllI;
                    }
                }
            }
            return llllllllllllllIIllIlIIIllIllllll / (float)llllllllllllllIIllIlIIIllIlllllI;
        }
        return 0.0f;
    }
    
    public void func_175669_a(final int llllllllllllllIIllIIllIlllIIIlIl, final BlockPos llllllllllllllIIllIIllIlllIIIlII, final int llllllllllllllIIllIIllIlllIIlIII) {
        for (int llllllllllllllIIllIIllIlllIIIlll = 0; llllllllllllllIIllIIllIlllIIIlll < this.worldAccesses.size(); ++llllllllllllllIIllIIllIlllIIIlll) {
            this.worldAccesses.get(llllllllllllllIIllIIllIlllIIIlll).func_180440_a(llllllllllllllIIllIIllIlllIIIlIl, llllllllllllllIIllIIllIlllIIIlII, llllllllllllllIIllIIllIlllIIlIII);
        }
    }
    
    protected void onEntityAdded(final Entity llllllllllllllIIllIlIlIIlllIlIII) {
        for (int llllllllllllllIIllIlIlIIlllIIlll = 0; llllllllllllllIIllIlIlIIlllIIlll < this.worldAccesses.size(); ++llllllllllllllIIllIlIlIIlllIIlll) {
            this.worldAccesses.get(llllllllllllllIIllIlIlIIlllIIlll).onEntityAdded(llllllllllllllIIllIlIlIIlllIlIII);
        }
    }
    
    protected boolean isChunkLoaded(final int llllllllllllllIIllIlIllllIIlIIII, final int llllllllllllllIIllIlIllllIIIllll, final boolean llllllllllllllIIllIlIllllIIIlllI) {
        return this.chunkProvider.chunkExists(llllllllllllllIIllIlIllllIIlIIII, llllllllllllllIIllIlIllllIIIllll) && (llllllllllllllIIllIlIllllIIIlllI || !this.chunkProvider.provideChunk(llllllllllllllIIllIlIllllIIlIIII, llllllllllllllIIllIlIllllIIIllll).isEmpty());
    }
    
    public float getCelestialAngleRadians(final float llllllllllllllIIllIlIIllllIlllll) {
        final float llllllllllllllIIllIlIIlllllIIIIl = this.getCelestialAngle(llllllllllllllIIllIlIIllllIlllll);
        return llllllllllllllIIllIlIIlllllIIIIl * 3.1415927f * 2.0f;
    }
    
    @Override
    public IBlockState getBlockState(final BlockPos llllllllllllllIIllIlIllIIIllIIIl) {
        if (!this.isValid(llllllllllllllIIllIlIllIIIllIIIl)) {
            return Blocks.air.getDefaultState();
        }
        final Chunk llllllllllllllIIllIlIllIIIllIIII = this.getChunkFromBlockCoords(llllllllllllllIIllIlIllIIIllIIIl);
        return llllllllllllllIIllIlIllIIIllIIII.getBlockState(llllllllllllllIIllIlIllIIIllIIIl);
    }
    
    public void setThunderStrength(final float llllllllllllllIIllIIlllIIIIlIIII) {
        this.prevThunderingStrength = llllllllllllllIIllIIlllIIIIlIIII;
        this.thunderingStrength = llllllllllllllIIllIIlllIIIIlIIII;
    }
    
    public Explosion createExplosion(final Entity llllllllllllllIIllIlIIIlllllIlII, final double llllllllllllllIIllIlIIIlllllIIll, final double llllllllllllllIIllIlIIIlllllIIlI, final double llllllllllllllIIllIlIIIlllllIIIl, final float llllllllllllllIIllIlIIIlllllIlll, final boolean llllllllllllllIIllIlIIIlllllIllI) {
        return this.newExplosion(llllllllllllllIIllIlIIIlllllIlII, llllllllllllllIIllIlIIIlllllIIll, llllllllllllllIIllIlIIIlllllIIlI, llllllllllllllIIllIlIIIlllllIIIl, llllllllllllllIIllIlIIIlllllIlll, false, llllllllllllllIIllIlIIIlllllIllI);
    }
    
    public boolean isBlockTickPending(final BlockPos llllllllllllllIIllIlIllIllIlIlll, final Block llllllllllllllIIllIlIllIllIlIllI) {
        return false;
    }
    
    public WorldChunkManager getWorldChunkManager() {
        return this.provider.getWorldChunkManager();
    }
    
    public EntityPlayer getPlayerEntityByUUID(final UUID llllllllllllllIIllIIlllIIllllIlI) {
        for (int llllllllllllllIIllIIlllIIlllllIl = 0; llllllllllllllIIllIIlllIIlllllIl < this.playerEntities.size(); ++llllllllllllllIIllIIlllIIlllllIl) {
            final EntityPlayer llllllllllllllIIllIIlllIIlllllII = this.playerEntities.get(llllllllllllllIIllIIlllIIlllllIl);
            if (llllllllllllllIIllIIlllIIllllIlI.equals(llllllllllllllIIllIIlllIIlllllII.getUniqueID())) {
                return llllllllllllllIIllIIlllIIlllllII;
            }
        }
        return null;
    }
    
    public void notifyNeighborsOfStateChange(final BlockPos llllllllllllllIIllIlIllIlllllllI, final Block llllllllllllllIIllIlIllIllllllIl) {
        this.notifyBlockOfStateChange(llllllllllllllIIllIlIllIlllllllI.offsetWest(), llllllllllllllIIllIlIllIllllllIl);
        this.notifyBlockOfStateChange(llllllllllllllIIllIlIllIlllllllI.offsetEast(), llllllllllllllIIllIlIllIllllllIl);
        this.notifyBlockOfStateChange(llllllllllllllIIllIlIllIlllllllI.offsetDown(), llllllllllllllIIllIlIllIllllllIl);
        this.notifyBlockOfStateChange(llllllllllllllIIllIlIllIlllllllI.offsetUp(), llllllllllllllIIllIlIllIllllllIl);
        this.notifyBlockOfStateChange(llllllllllllllIIllIlIllIlllllllI.offsetNorth(), llllllllllllllIIllIlIllIllllllIl);
        this.notifyBlockOfStateChange(llllllllllllllIIllIlIllIlllllllI.offsetSouth(), llllllllllllllIIllIlIllIllllllIl);
    }
}
