package net.minecraft.world.storage;

import net.minecraft.world.*;
import net.minecraft.crash.*;
import java.util.concurrent.*;
import net.minecraft.util.*;
import net.minecraft.server.*;
import net.minecraft.nbt.*;

public class WorldInfo
{
    private /* synthetic */ double borderCenterZ;
    private /* synthetic */ int spawnY;
    private /* synthetic */ boolean initialized;
    private /* synthetic */ int borderWarningTime;
    private /* synthetic */ int spawnZ;
    private /* synthetic */ long randomSeed;
    private /* synthetic */ int borderWarningDistance;
    private /* synthetic */ double borderCenterX;
    private /* synthetic */ boolean thundering;
    private /* synthetic */ long sizeOnDisk;
    private /* synthetic */ int saveVersion;
    private /* synthetic */ double borderSafeZone;
    private /* synthetic */ double borderSizeLerpTarget;
    private /* synthetic */ int spawnX;
    private /* synthetic */ GameRules theGameRules;
    private /* synthetic */ boolean raining;
    private /* synthetic */ double borderSize;
    private /* synthetic */ double borderDamagePerBlock;
    public static final /* synthetic */ EnumDifficulty DEFAULT_DIFFICULTY;
    private /* synthetic */ long worldTime;
    private /* synthetic */ boolean allowCommands;
    private /* synthetic */ String levelName;
    private /* synthetic */ long totalTime;
    private /* synthetic */ boolean difficultyLocked;
    private /* synthetic */ boolean hardcore;
    private /* synthetic */ boolean mapFeaturesEnabled;
    private /* synthetic */ WorldSettings.GameType theGameType;
    private /* synthetic */ NBTTagCompound playerTag;
    private /* synthetic */ long borderSizeLerpTime;
    private /* synthetic */ String generatorOptions;
    private /* synthetic */ EnumDifficulty difficulty;
    private /* synthetic */ int thunderTime;
    private /* synthetic */ int cleanWeatherTime;
    private /* synthetic */ long lastTimePlayed;
    private /* synthetic */ int dimension;
    private /* synthetic */ int rainTime;
    private /* synthetic */ WorldType terrainType;
    
    public int func_176139_K() {
        return this.borderWarningTime;
    }
    
    public long getWorldTotalTime() {
        return this.totalTime;
    }
    
    public int getSaveVersion() {
        return this.saveVersion;
    }
    
    public void setMapFeaturesEnabled(final boolean llllllllllllllIIIlIIllIIllllIlIl) {
        this.mapFeaturesEnabled = llllllllllllllIIIlIIllIIllllIlIl;
    }
    
    public void func_176129_e(final double llllllllllllllIIIlIIllIIlIIIllll) {
        this.borderSafeZone = llllllllllllllIIIlIIllIIlIIIllll;
    }
    
    public boolean isThundering() {
        return this.thundering;
    }
    
    public boolean isRaining() {
        return this.raining;
    }
    
    public WorldType getTerrainType() {
        return this.terrainType;
    }
    
    public boolean areCommandsAllowed() {
        return this.allowCommands;
    }
    
    public void setHardcore(final boolean llllllllllllllIIIlIIllIIlllIIllI) {
        this.hardcore = llllllllllllllIIIlIIllIIlllIIllI;
    }
    
    public void setThundering(final boolean llllllllllllllIIIlIIllIlIIIllIlI) {
        this.thundering = llllllllllllllIIIlIIllIlIIIllIlI;
    }
    
    public void setRaining(final boolean llllllllllllllIIIlIIllIlIIIIlIlI) {
        this.raining = llllllllllllllIIIlIIllIlIIIIlIlI;
    }
    
    public void setThunderTime(final int llllllllllllllIIIlIIllIlIIIlIIll) {
        this.thunderTime = llllllllllllllIIIlIIllIlIIIlIIll;
    }
    
    public double func_176138_H() {
        return this.borderSafeZone;
    }
    
    public double func_176126_D() {
        return this.borderCenterZ;
    }
    
    public void func_176124_d(final double llllllllllllllIIIlIIllIIlIIllIII) {
        this.borderCenterX = llllllllllllllIIIlIIllIIlIIllIII;
    }
    
    public void func_176136_k(final int llllllllllllllIIIlIIllIIIlllIlII) {
        this.borderWarningTime = llllllllllllllIIIlIIllIIIlllIlII;
    }
    
    public int getThunderTime() {
        return this.thunderTime;
    }
    
    public WorldSettings.GameType getGameType() {
        return this.theGameType;
    }
    
    public boolean isMapFeaturesEnabled() {
        return this.mapFeaturesEnabled;
    }
    
    public void func_176125_f(final double llllllllllllllIIIlIIllIIlIIIIllI) {
        this.borderDamagePerBlock = llllllllllllllIIIlIIllIIlIIIIllI;
    }
    
    public double func_176132_G() {
        return this.borderSizeLerpTarget;
    }
    
    public void addToCrashReport(final CrashReportCategory llllllllllllllIIIlIIllIIIlIllIlI) {
        llllllllllllllIIIlIIllIIIlIllIlI.addCrashSectionCallable("Level seed", new Callable() {
            @Override
            public String call() {
                return String.valueOf(WorldInfo.this.getSeed());
            }
            
            static {
                __OBFID = "CL_00000588";
            }
        });
        llllllllllllllIIIlIIllIIIlIllIlI.addCrashSectionCallable("Level generator", new Callable() {
            static {
                __OBFID = "CL_00000589";
            }
            
            @Override
            public String call() {
                return String.format("ID %02d - %s, ver %d. Features enabled: %b", WorldInfo.this.terrainType.getWorldTypeID(), WorldInfo.this.terrainType.getWorldTypeName(), WorldInfo.this.terrainType.getGeneratorVersion(), WorldInfo.this.mapFeaturesEnabled);
            }
        });
        llllllllllllllIIIlIIllIIIlIllIlI.addCrashSectionCallable("Level generator options", new Callable() {
            static {
                __OBFID = "CL_00000590";
            }
            
            @Override
            public String call() {
                return WorldInfo.this.generatorOptions;
            }
        });
        llllllllllllllIIIlIIllIIIlIllIlI.addCrashSectionCallable("Level spawn location", new Callable() {
            static {
                __OBFID = "CL_00000591";
            }
            
            @Override
            public String call() {
                return CrashReportCategory.getCoordinateInfo(WorldInfo.this.spawnX, WorldInfo.this.spawnY, WorldInfo.this.spawnZ);
            }
        });
        llllllllllllllIIIlIIllIIIlIllIlI.addCrashSectionCallable("Level time", new Callable() {
            @Override
            public String call() {
                return String.format("%d game time, %d day time", WorldInfo.this.totalTime, WorldInfo.this.worldTime);
            }
            
            static {
                __OBFID = "CL_00000592";
            }
        });
        llllllllllllllIIIlIIllIIIlIllIlI.addCrashSectionCallable("Level dimension", new Callable() {
            @Override
            public String call() {
                return String.valueOf(WorldInfo.this.dimension);
            }
            
            static {
                __OBFID = "CL_00000593";
            }
        });
        llllllllllllllIIIlIIllIIIlIllIlI.addCrashSectionCallable("Level storage version", new Callable() {
            @Override
            public String call() {
                String llllllllllllllllIllIllIIlllIlllI = "Unknown?";
                try {
                    switch (WorldInfo.this.saveVersion) {
                        case 19132: {
                            llllllllllllllllIllIllIIlllIlllI = "McRegion";
                            break;
                        }
                        case 19133: {
                            llllllllllllllllIllIllIIlllIlllI = "Anvil";
                            break;
                        }
                    }
                }
                catch (Throwable t) {}
                return String.format("0x%05X - %s", WorldInfo.this.saveVersion, llllllllllllllllIllIllIIlllIlllI);
            }
            
            static {
                __OBFID = "CL_00000594";
            }
        });
        llllllllllllllIIIlIIllIIIlIllIlI.addCrashSectionCallable("Level weather", new Callable() {
            @Override
            public String call() {
                return String.format("Rain time: %d (now: %b), thunder time: %d (now: %b)", WorldInfo.this.rainTime, WorldInfo.this.raining, WorldInfo.this.thunderTime, WorldInfo.this.thundering);
            }
            
            static {
                __OBFID = "CL_00000595";
            }
        });
        llllllllllllllIIIlIIllIIIlIllIlI.addCrashSectionCallable("Level game mode", new Callable() {
            static {
                __OBFID = "CL_00000597";
            }
            
            @Override
            public String call() {
                return String.format("Game mode: %s (ID %d). Hardcore: %b. Cheats: %b", WorldInfo.this.theGameType.getName(), WorldInfo.this.theGameType.getID(), WorldInfo.this.hardcore, WorldInfo.this.allowCommands);
            }
        });
    }
    
    public NBTTagCompound cloneNBTCompound(final NBTTagCompound llllllllllllllIIIlIIllIllIIIIlIl) {
        final NBTTagCompound llllllllllllllIIIlIIllIllIIIIlll = new NBTTagCompound();
        this.updateTagCompound(llllllllllllllIIIlIIllIllIIIIlll, llllllllllllllIIIlIIllIllIIIIlIl);
        return llllllllllllllIIIlIIllIllIIIIlll;
    }
    
    public String getWorldName() {
        return this.levelName;
    }
    
    public boolean isHardcoreModeEnabled() {
        return this.hardcore;
    }
    
    public void setSpawn(final BlockPos llllllllllllllIIIlIIllIlIlIIIIll) {
        this.spawnX = llllllllllllllIIIlIIllIlIlIIIIll.getX();
        this.spawnY = llllllllllllllIIIlIIllIlIlIIIIll.getY();
        this.spawnZ = llllllllllllllIIIlIIllIlIlIIIIll.getZ();
    }
    
    public void func_176135_e(final long llllllllllllllIIIlIIllIIlIlIllIl) {
        this.borderSizeLerpTime = llllllllllllllIIIlIIllIIlIlIllIl;
    }
    
    public long getSeed() {
        return this.randomSeed;
    }
    
    public String getGeneratorOptions() {
        return this.generatorOptions;
    }
    
    public void setGameType(final WorldSettings.GameType llllllllllllllIIIlIIllIIlllIllIl) {
        this.theGameType = llllllllllllllIIIlIIllIIlllIllIl;
    }
    
    public void func_176122_j(final int llllllllllllllIIIlIIllIIIllllIII) {
        this.borderWarningDistance = llllllllllllllIIIlIIllIIIllllIII;
    }
    
    public void func_176141_c(final double llllllllllllllIIIlIIllIIlIIllllI) {
        this.borderCenterZ = llllllllllllllIIIlIIllIIlIIllllI;
    }
    
    public int getSpawnZ() {
        return this.spawnZ;
    }
    
    public GameRules getGameRulesInstance() {
        return this.theGameRules;
    }
    
    public void func_176118_b(final double llllllllllllllIIIlIIllIIlIlIIIlI) {
        this.borderSizeLerpTarget = llllllllllllllIIIlIIllIIlIlIIIlI;
    }
    
    public EnumDifficulty getDifficulty() {
        return this.difficulty;
    }
    
    public void setServerInitialized(final boolean llllllllllllllIIIlIIllIIllIIlIII) {
        this.initialized = llllllllllllllIIIlIIllIIllIIlIII;
    }
    
    public double func_176140_I() {
        return this.borderDamagePerBlock;
    }
    
    public void incrementTotalWorldTime(final long llllllllllllllIIIlIIllIlIlIIlIll) {
        this.totalTime = llllllllllllllIIIlIIllIlIlIIlIll;
    }
    
    public void setAllowCommands(final boolean llllllllllllllIIIlIIllIIllIIllll) {
        this.allowCommands = llllllllllllllIIIlIIllIIllIIllll;
    }
    
    public NBTTagCompound getPlayerNBTTagCompound() {
        return this.playerTag;
    }
    
    public double func_176120_C() {
        return this.borderCenterX;
    }
    
    public void setRainTime(final int llllllllllllllIIIlIIllIlIIIIIIIl) {
        this.rainTime = llllllllllllllIIIlIIllIlIIIIIIIl;
    }
    
    public long getWorldTime() {
        return this.worldTime;
    }
    
    public WorldInfo(final WorldInfo llllllllllllllIIIlIIllIllIIlIlIl) {
        this.terrainType = WorldType.DEFAULT;
        this.generatorOptions = "";
        this.borderCenterX = 0.0;
        this.borderCenterZ = 0.0;
        this.borderSize = 6.0E7;
        this.borderSizeLerpTime = 0L;
        this.borderSizeLerpTarget = 0.0;
        this.borderSafeZone = 5.0;
        this.borderDamagePerBlock = 0.2;
        this.borderWarningDistance = 5;
        this.borderWarningTime = 15;
        this.theGameRules = new GameRules();
        this.randomSeed = llllllllllllllIIIlIIllIllIIlIlIl.randomSeed;
        this.terrainType = llllllllllllllIIIlIIllIllIIlIlIl.terrainType;
        this.generatorOptions = llllllllllllllIIIlIIllIllIIlIlIl.generatorOptions;
        this.theGameType = llllllllllllllIIIlIIllIllIIlIlIl.theGameType;
        this.mapFeaturesEnabled = llllllllllllllIIIlIIllIllIIlIlIl.mapFeaturesEnabled;
        this.spawnX = llllllllllllllIIIlIIllIllIIlIlIl.spawnX;
        this.spawnY = llllllllllllllIIIlIIllIllIIlIlIl.spawnY;
        this.spawnZ = llllllllllllllIIIlIIllIllIIlIlIl.spawnZ;
        this.totalTime = llllllllllllllIIIlIIllIllIIlIlIl.totalTime;
        this.worldTime = llllllllllllllIIIlIIllIllIIlIlIl.worldTime;
        this.lastTimePlayed = llllllllllllllIIIlIIllIllIIlIlIl.lastTimePlayed;
        this.sizeOnDisk = llllllllllllllIIIlIIllIllIIlIlIl.sizeOnDisk;
        this.playerTag = llllllllllllllIIIlIIllIllIIlIlIl.playerTag;
        this.dimension = llllllllllllllIIIlIIllIllIIlIlIl.dimension;
        this.levelName = llllllllllllllIIIlIIllIllIIlIlIl.levelName;
        this.saveVersion = llllllllllllllIIIlIIllIllIIlIlIl.saveVersion;
        this.rainTime = llllllllllllllIIIlIIllIllIIlIlIl.rainTime;
        this.raining = llllllllllllllIIIlIIllIllIIlIlIl.raining;
        this.thunderTime = llllllllllllllIIIlIIllIllIIlIlIl.thunderTime;
        this.thundering = llllllllllllllIIIlIIllIllIIlIlIl.thundering;
        this.hardcore = llllllllllllllIIIlIIllIllIIlIlIl.hardcore;
        this.allowCommands = llllllllllllllIIIlIIllIllIIlIlIl.allowCommands;
        this.initialized = llllllllllllllIIIlIIllIllIIlIlIl.initialized;
        this.theGameRules = llllllllllllllIIIlIIllIllIIlIlIl.theGameRules;
        this.difficulty = llllllllllllllIIIlIIllIllIIlIlIl.difficulty;
        this.difficultyLocked = llllllllllllllIIIlIIllIllIIlIlIl.difficultyLocked;
        this.borderCenterX = llllllllllllllIIIlIIllIllIIlIlIl.borderCenterX;
        this.borderCenterZ = llllllllllllllIIIlIIllIllIIlIlIl.borderCenterZ;
        this.borderSize = llllllllllllllIIIlIIllIllIIlIlIl.borderSize;
        this.borderSizeLerpTime = llllllllllllllIIIlIIllIllIIlIlIl.borderSizeLerpTime;
        this.borderSizeLerpTarget = llllllllllllllIIIlIIllIllIIlIlIl.borderSizeLerpTarget;
        this.borderSafeZone = llllllllllllllIIIlIIllIllIIlIlIl.borderSafeZone;
        this.borderDamagePerBlock = llllllllllllllIIIlIIllIllIIlIlIl.borderDamagePerBlock;
        this.borderWarningTime = llllllllllllllIIIlIIllIllIIlIlIl.borderWarningTime;
        this.borderWarningDistance = llllllllllllllIIIlIIllIllIIlIlIl.borderWarningDistance;
    }
    
    public void setWorldName(final String llllllllllllllIIIlIIllIlIIlllIlI) {
        this.levelName = llllllllllllllIIIlIIllIlIIlllIlI;
    }
    
    public void setDifficultyLocked(final boolean llllllllllllllIIIlIIllIIIllIIIII) {
        this.difficultyLocked = llllllllllllllIIIlIIllIIIllIIIII;
    }
    
    public int func_176133_A() {
        return this.cleanWeatherTime;
    }
    
    public void setSpawnZ(final int llllllllllllllIIIlIIllIlIlIlIIll) {
        this.spawnZ = llllllllllllllIIIlIIllIlIlIlIIll;
    }
    
    protected WorldInfo() {
        this.terrainType = WorldType.DEFAULT;
        this.generatorOptions = "";
        this.borderCenterX = 0.0;
        this.borderCenterZ = 0.0;
        this.borderSize = 6.0E7;
        this.borderSizeLerpTime = 0L;
        this.borderSizeLerpTarget = 0.0;
        this.borderSafeZone = 5.0;
        this.borderDamagePerBlock = 0.2;
        this.borderWarningDistance = 5;
        this.borderWarningTime = 15;
        this.theGameRules = new GameRules();
    }
    
    public void setTerrainType(final WorldType llllllllllllllIIIlIIllIIllIllIll) {
        this.terrainType = llllllllllllllIIIlIIllIIllIllIll;
    }
    
    public long func_176134_F() {
        return this.borderSizeLerpTime;
    }
    
    public void func_176142_i(final int llllllllllllllIIIlIIllIlIIlIIIll) {
        this.cleanWeatherTime = llllllllllllllIIIlIIllIlIIlIIIll;
    }
    
    public int func_176131_J() {
        return this.borderWarningDistance;
    }
    
    static {
        __OBFID = "CL_00000587";
        DEFAULT_DIFFICULTY = EnumDifficulty.NORMAL;
    }
    
    public void setWorldTime(final long llllllllllllllIIIlIIllIlIlIIlIII) {
        this.worldTime = 15000L;
    }
    
    public boolean isDifficultyLocked() {
        return this.difficultyLocked;
    }
    
    public int getSpawnY() {
        return this.spawnY;
    }
    
    public void setDifficulty(final EnumDifficulty llllllllllllllIIIlIIllIIIllIlIIl) {
        this.difficulty = llllllllllllllIIIlIIllIIIllIlIIl;
    }
    
    public boolean isInitialized() {
        return this.initialized;
    }
    
    private void updateTagCompound(final NBTTagCompound llllllllllllllIIIlIIllIlIlllllII, final NBTTagCompound llllllllllllllIIIlIIllIlIllllIll) {
        llllllllllllllIIIlIIllIlIlllllII.setLong("RandomSeed", this.randomSeed);
        llllllllllllllIIIlIIllIlIlllllII.setString("generatorName", this.terrainType.getWorldTypeName());
        llllllllllllllIIIlIIllIlIlllllII.setInteger("generatorVersion", this.terrainType.getGeneratorVersion());
        llllllllllllllIIIlIIllIlIlllllII.setString("generatorOptions", this.generatorOptions);
        llllllllllllllIIIlIIllIlIlllllII.setInteger("GameType", this.theGameType.getID());
        llllllllllllllIIIlIIllIlIlllllII.setBoolean("MapFeatures", this.mapFeaturesEnabled);
        llllllllllllllIIIlIIllIlIlllllII.setInteger("SpawnX", this.spawnX);
        llllllllllllllIIIlIIllIlIlllllII.setInteger("SpawnY", this.spawnY);
        llllllllllllllIIIlIIllIlIlllllII.setInteger("SpawnZ", this.spawnZ);
        llllllllllllllIIIlIIllIlIlllllII.setLong("Time", this.totalTime);
        llllllllllllllIIIlIIllIlIlllllII.setLong("DayTime", this.worldTime);
        llllllllllllllIIIlIIllIlIlllllII.setLong("SizeOnDisk", this.sizeOnDisk);
        llllllllllllllIIIlIIllIlIlllllII.setLong("LastPlayed", MinecraftServer.getCurrentTimeMillis());
        llllllllllllllIIIlIIllIlIlllllII.setString("LevelName", this.levelName);
        llllllllllllllIIIlIIllIlIlllllII.setInteger("version", this.saveVersion);
        llllllllllllllIIIlIIllIlIlllllII.setInteger("clearWeatherTime", this.cleanWeatherTime);
        llllllllllllllIIIlIIllIlIlllllII.setInteger("rainTime", this.rainTime);
        llllllllllllllIIIlIIllIlIlllllII.setBoolean("raining", this.raining);
        llllllllllllllIIIlIIllIlIlllllII.setInteger("thunderTime", this.thunderTime);
        llllllllllllllIIIlIIllIlIlllllII.setBoolean("thundering", this.thundering);
        llllllllllllllIIIlIIllIlIlllllII.setBoolean("hardcore", this.hardcore);
        llllllllllllllIIIlIIllIlIlllllII.setBoolean("allowCommands", this.allowCommands);
        llllllllllllllIIIlIIllIlIlllllII.setBoolean("initialized", this.initialized);
        llllllllllllllIIIlIIllIlIlllllII.setDouble("BorderCenterX", this.borderCenterX);
        llllllllllllllIIIlIIllIlIlllllII.setDouble("BorderCenterZ", this.borderCenterZ);
        llllllllllllllIIIlIIllIlIlllllII.setDouble("BorderSize", this.borderSize);
        llllllllllllllIIIlIIllIlIlllllII.setLong("BorderSizeLerpTime", this.borderSizeLerpTime);
        llllllllllllllIIIlIIllIlIlllllII.setDouble("BorderSafeZone", this.borderSafeZone);
        llllllllllllllIIIlIIllIlIlllllII.setDouble("BorderDamagePerBlock", this.borderDamagePerBlock);
        llllllllllllllIIIlIIllIlIlllllII.setDouble("BorderSizeLerpTarget", this.borderSizeLerpTarget);
        llllllllllllllIIIlIIllIlIlllllII.setDouble("BorderWarningBlocks", this.borderWarningDistance);
        llllllllllllllIIIlIIllIlIlllllII.setDouble("BorderWarningTime", this.borderWarningTime);
        if (this.difficulty != null) {
            llllllllllllllIIIlIIllIlIlllllII.setByte("Difficulty", (byte)this.difficulty.getDifficultyId());
        }
        llllllllllllllIIIlIIllIlIlllllII.setBoolean("DifficultyLocked", this.difficultyLocked);
        llllllllllllllIIIlIIllIlIlllllII.setTag("GameRules", this.theGameRules.writeGameRulesToNBT());
        if (llllllllllllllIIIlIIllIlIllllIll != null) {
            llllllllllllllIIIlIIllIlIlllllII.setTag("Player", llllllllllllllIIIlIIllIlIllllIll);
        }
    }
    
    public int getRainTime() {
        return this.rainTime;
    }
    
    public void populateFromWorldSettings(final WorldSettings llllllllllllllIIIlIIllIllIIllIIl) {
        this.randomSeed = llllllllllllllIIIlIIllIllIIllIIl.getSeed();
        this.theGameType = llllllllllllllIIIlIIllIllIIllIIl.getGameType();
        this.mapFeaturesEnabled = llllllllllllllIIIlIIllIllIIllIIl.isMapFeaturesEnabled();
        this.hardcore = llllllllllllllIIIlIIllIllIIllIIl.getHardcoreEnabled();
        this.terrainType = llllllllllllllIIIlIIllIllIIllIIl.getTerrainType();
        this.generatorOptions = llllllllllllllIIIlIIllIllIIllIIl.getWorldName();
        this.allowCommands = llllllllllllllIIIlIIllIllIIllIIl.areCommandsAllowed();
    }
    
    public WorldInfo(final NBTTagCompound llllllllllllllIIIlIIllIllIlIlllI) {
        this.terrainType = WorldType.DEFAULT;
        this.generatorOptions = "";
        this.borderCenterX = 0.0;
        this.borderCenterZ = 0.0;
        this.borderSize = 6.0E7;
        this.borderSizeLerpTime = 0L;
        this.borderSizeLerpTarget = 0.0;
        this.borderSafeZone = 5.0;
        this.borderDamagePerBlock = 0.2;
        this.borderWarningDistance = 5;
        this.borderWarningTime = 15;
        this.theGameRules = new GameRules();
        this.randomSeed = llllllllllllllIIIlIIllIllIlIlllI.getLong("RandomSeed");
        if (llllllllllllllIIIlIIllIllIlIlllI.hasKey("generatorName", 8)) {
            final String llllllllllllllIIIlIIllIllIlIllIl = llllllllllllllIIIlIIllIllIlIlllI.getString("generatorName");
            this.terrainType = WorldType.parseWorldType(llllllllllllllIIIlIIllIllIlIllIl);
            if (this.terrainType == null) {
                this.terrainType = WorldType.DEFAULT;
            }
            else if (this.terrainType.isVersioned()) {
                int llllllllllllllIIIlIIllIllIlIllII = 0;
                if (llllllllllllllIIIlIIllIllIlIlllI.hasKey("generatorVersion", 99)) {
                    llllllllllllllIIIlIIllIllIlIllII = llllllllllllllIIIlIIllIllIlIlllI.getInteger("generatorVersion");
                }
                this.terrainType = this.terrainType.getWorldTypeForGeneratorVersion(llllllllllllllIIIlIIllIllIlIllII);
            }
            if (llllllllllllllIIIlIIllIllIlIlllI.hasKey("generatorOptions", 8)) {
                this.generatorOptions = llllllllllllllIIIlIIllIllIlIlllI.getString("generatorOptions");
            }
        }
        this.theGameType = WorldSettings.GameType.getByID(llllllllllllllIIIlIIllIllIlIlllI.getInteger("GameType"));
        if (llllllllllllllIIIlIIllIllIlIlllI.hasKey("MapFeatures", 99)) {
            this.mapFeaturesEnabled = llllllllllllllIIIlIIllIllIlIlllI.getBoolean("MapFeatures");
        }
        else {
            this.mapFeaturesEnabled = true;
        }
        this.spawnX = llllllllllllllIIIlIIllIllIlIlllI.getInteger("SpawnX");
        this.spawnY = llllllllllllllIIIlIIllIllIlIlllI.getInteger("SpawnY");
        this.spawnZ = llllllllllllllIIIlIIllIllIlIlllI.getInteger("SpawnZ");
        this.totalTime = llllllllllllllIIIlIIllIllIlIlllI.getLong("Time");
        if (llllllllllllllIIIlIIllIllIlIlllI.hasKey("DayTime", 99)) {
            this.worldTime = llllllllllllllIIIlIIllIllIlIlllI.getLong("DayTime");
        }
        else {
            this.worldTime = this.totalTime;
        }
        this.lastTimePlayed = llllllllllllllIIIlIIllIllIlIlllI.getLong("LastPlayed");
        this.sizeOnDisk = llllllllllllllIIIlIIllIllIlIlllI.getLong("SizeOnDisk");
        this.levelName = llllllllllllllIIIlIIllIllIlIlllI.getString("LevelName");
        this.saveVersion = llllllllllllllIIIlIIllIllIlIlllI.getInteger("version");
        this.cleanWeatherTime = llllllllllllllIIIlIIllIllIlIlllI.getInteger("clearWeatherTime");
        this.rainTime = llllllllllllllIIIlIIllIllIlIlllI.getInteger("rainTime");
        this.raining = llllllllllllllIIIlIIllIllIlIlllI.getBoolean("raining");
        this.thunderTime = llllllllllllllIIIlIIllIllIlIlllI.getInteger("thunderTime");
        this.thundering = llllllllllllllIIIlIIllIllIlIlllI.getBoolean("thundering");
        this.hardcore = llllllllllllllIIIlIIllIllIlIlllI.getBoolean("hardcore");
        if (llllllllllllllIIIlIIllIllIlIlllI.hasKey("initialized", 99)) {
            this.initialized = llllllllllllllIIIlIIllIllIlIlllI.getBoolean("initialized");
        }
        else {
            this.initialized = true;
        }
        if (llllllllllllllIIIlIIllIllIlIlllI.hasKey("allowCommands", 99)) {
            this.allowCommands = llllllllllllllIIIlIIllIllIlIlllI.getBoolean("allowCommands");
        }
        else {
            this.allowCommands = (this.theGameType == WorldSettings.GameType.CREATIVE);
        }
        if (llllllllllllllIIIlIIllIllIlIlllI.hasKey("Player", 10)) {
            this.playerTag = llllllllllllllIIIlIIllIllIlIlllI.getCompoundTag("Player");
            this.dimension = this.playerTag.getInteger("Dimension");
        }
        if (llllllllllllllIIIlIIllIllIlIlllI.hasKey("GameRules", 10)) {
            this.theGameRules.readGameRulesFromNBT(llllllllllllllIIIlIIllIllIlIlllI.getCompoundTag("GameRules"));
        }
        if (llllllllllllllIIIlIIllIllIlIlllI.hasKey("Difficulty", 99)) {
            this.difficulty = EnumDifficulty.getDifficultyEnum(llllllllllllllIIIlIIllIllIlIlllI.getByte("Difficulty"));
        }
        if (llllllllllllllIIIlIIllIllIlIlllI.hasKey("DifficultyLocked", 1)) {
            this.difficultyLocked = llllllllllllllIIIlIIllIllIlIlllI.getBoolean("DifficultyLocked");
        }
        if (llllllllllllllIIIlIIllIllIlIlllI.hasKey("BorderCenterX", 99)) {
            this.borderCenterX = llllllllllllllIIIlIIllIllIlIlllI.getDouble("BorderCenterX");
        }
        if (llllllllllllllIIIlIIllIllIlIlllI.hasKey("BorderCenterZ", 99)) {
            this.borderCenterZ = llllllllllllllIIIlIIllIllIlIlllI.getDouble("BorderCenterZ");
        }
        if (llllllllllllllIIIlIIllIllIlIlllI.hasKey("BorderSize", 99)) {
            this.borderSize = llllllllllllllIIIlIIllIllIlIlllI.getDouble("BorderSize");
        }
        if (llllllllllllllIIIlIIllIllIlIlllI.hasKey("BorderSizeLerpTime", 99)) {
            this.borderSizeLerpTime = llllllllllllllIIIlIIllIllIlIlllI.getLong("BorderSizeLerpTime");
        }
        if (llllllllllllllIIIlIIllIllIlIlllI.hasKey("BorderSizeLerpTarget", 99)) {
            this.borderSizeLerpTarget = llllllllllllllIIIlIIllIllIlIlllI.getDouble("BorderSizeLerpTarget");
        }
        if (llllllllllllllIIIlIIllIllIlIlllI.hasKey("BorderSafeZone", 99)) {
            this.borderSafeZone = llllllllllllllIIIlIIllIllIlIlllI.getDouble("BorderSafeZone");
        }
        if (llllllllllllllIIIlIIllIllIlIlllI.hasKey("BorderDamagePerBlock", 99)) {
            this.borderDamagePerBlock = llllllllllllllIIIlIIllIllIlIlllI.getDouble("BorderDamagePerBlock");
        }
        if (llllllllllllllIIIlIIllIllIlIlllI.hasKey("BorderWarningBlocks", 99)) {
            this.borderWarningDistance = llllllllllllllIIIlIIllIllIlIlllI.getInteger("BorderWarningBlocks");
        }
        if (llllllllllllllIIIlIIllIllIlIlllI.hasKey("BorderWarningTime", 99)) {
            this.borderWarningTime = llllllllllllllIIIlIIllIllIlIlllI.getInteger("BorderWarningTime");
        }
    }
    
    public long getSizeOnDisk() {
        return this.sizeOnDisk;
    }
    
    public double func_176137_E() {
        return this.borderSize;
    }
    
    public void func_176145_a(final double llllllllllllllIIIlIIllIIlIllIlII) {
        this.borderSize = llllllllllllllIIIlIIllIIlIllIlII;
    }
    
    public WorldInfo(final WorldSettings llllllllllllllIIIlIIllIllIlIIIII, final String llllllllllllllIIIlIIllIllIIlllll) {
        this.terrainType = WorldType.DEFAULT;
        this.generatorOptions = "";
        this.borderCenterX = 0.0;
        this.borderCenterZ = 0.0;
        this.borderSize = 6.0E7;
        this.borderSizeLerpTime = 0L;
        this.borderSizeLerpTarget = 0.0;
        this.borderSafeZone = 5.0;
        this.borderDamagePerBlock = 0.2;
        this.borderWarningDistance = 5;
        this.borderWarningTime = 15;
        this.theGameRules = new GameRules();
        this.populateFromWorldSettings(llllllllllllllIIIlIIllIllIlIIIII);
        this.levelName = llllllllllllllIIIlIIllIllIIlllll;
        this.difficulty = WorldInfo.DEFAULT_DIFFICULTY;
        this.initialized = false;
    }
    
    public int getSpawnX() {
        return this.spawnX;
    }
    
    public void setSpawnX(final int llllllllllllllIIIlIIllIlIlIlllll) {
        this.spawnX = llllllllllllllIIIlIIllIlIlIlllll;
    }
    
    public long getLastTimePlayed() {
        return this.lastTimePlayed;
    }
    
    public void setSaveVersion(final int llllllllllllllIIIlIIllIlIIlIllll) {
        this.saveVersion = llllllllllllllIIIlIIllIlIIlIllll;
    }
    
    public NBTTagCompound getNBTTagCompound() {
        final NBTTagCompound llllllllllllllIIIlIIllIllIIIllll = new NBTTagCompound();
        this.updateTagCompound(llllllllllllllIIIlIIllIllIIIllll, this.playerTag);
        return llllllllllllllIIIlIIllIllIIIllll;
    }
    
    public void setSpawnY(final int llllllllllllllIIIlIIllIlIlIlIlll) {
        this.spawnY = llllllllllllllIIIlIIllIlIlIlIlll;
    }
}
