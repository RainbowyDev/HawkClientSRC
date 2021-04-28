package net.minecraft.world;

import net.minecraft.init.*;
import net.minecraft.world.biome.*;
import net.minecraft.util.*;
import net.minecraft.world.chunk.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.border.*;

public abstract class WorldProvider
{
    protected /* synthetic */ boolean hasNoSky;
    private /* synthetic */ String generatorSettings;
    protected /* synthetic */ boolean isHellWorld;
    protected /* synthetic */ World worldObj;
    protected final /* synthetic */ float[] lightBrightnessTable;
    protected /* synthetic */ int dimensionId;
    private final /* synthetic */ float[] colorsSunriseSunset;
    protected /* synthetic */ WorldChunkManager worldChunkMgr;
    private /* synthetic */ WorldType terrainType;
    
    public static WorldProvider getProviderForDimension(final int lllllllllllllllIIllIIIIIIlIIlIII) {
        return (lllllllllllllllIIllIIIIIIlIIlIII == -1) ? new WorldProviderHell() : ((lllllllllllllllIIllIIIIIIlIIlIII == 0) ? new WorldProviderSurface() : ((lllllllllllllllIIllIIIIIIlIIlIII == 1) ? new WorldProviderEnd() : null));
    }
    
    public float[] calcSunriseSunsetColors(final float lllllllllllllllIIllIIIIIIllIllII, final float lllllllllllllllIIllIIIIIIlllIIll) {
        final float lllllllllllllllIIllIIIIIIlllIIlI = 0.4f;
        final float lllllllllllllllIIllIIIIIIlllIIIl = MathHelper.cos(lllllllllllllllIIllIIIIIIllIllII * 3.1415927f * 2.0f) - 0.0f;
        final float lllllllllllllllIIllIIIIIIlllIIII = -0.0f;
        if (lllllllllllllllIIllIIIIIIlllIIIl >= lllllllllllllllIIllIIIIIIlllIIII - lllllllllllllllIIllIIIIIIlllIIlI && lllllllllllllllIIllIIIIIIlllIIIl <= lllllllllllllllIIllIIIIIIlllIIII + lllllllllllllllIIllIIIIIIlllIIlI) {
            final float lllllllllllllllIIllIIIIIIllIllll = (lllllllllllllllIIllIIIIIIlllIIIl - lllllllllllllllIIllIIIIIIlllIIII) / lllllllllllllllIIllIIIIIIlllIIlI * 0.5f + 0.5f;
            float lllllllllllllllIIllIIIIIIllIlllI = 1.0f - (1.0f - MathHelper.sin(lllllllllllllllIIllIIIIIIllIllll * 3.1415927f)) * 0.99f;
            lllllllllllllllIIllIIIIIIllIlllI *= lllllllllllllllIIllIIIIIIllIlllI;
            this.colorsSunriseSunset[0] = lllllllllllllllIIllIIIIIIllIllll * 0.3f + 0.7f;
            this.colorsSunriseSunset[1] = lllllllllllllllIIllIIIIIIllIllll * lllllllllllllllIIllIIIIIIllIllll * 0.7f + 0.2f;
            this.colorsSunriseSunset[2] = lllllllllllllllIIllIIIIIIllIllll * lllllllllllllllIIllIIIIIIllIllll * 0.0f + 0.2f;
            this.colorsSunriseSunset[3] = lllllllllllllllIIllIIIIIIllIlllI;
            return this.colorsSunriseSunset;
        }
        return null;
    }
    
    public WorldChunkManager getWorldChunkManager() {
        return this.worldChunkMgr;
    }
    
    static {
        __OBFID = "CL_00000386";
        moonPhaseFactors = new float[] { 1.0f, 0.75f, 0.5f, 0.25f, 0.0f, 0.25f, 0.5f, 0.75f };
    }
    
    public boolean doesXZShowFog(final int lllllllllllllllIIllIIIIIIIllIIII, final int lllllllllllllllIIllIIIIIIIlIllll) {
        return false;
    }
    
    public int getMoonPhase(final long lllllllllllllllIIllIIIIIlIIIlIII) {
        return (int)(lllllllllllllllIIllIIIIIlIIIlIII / 24000L % 8L + 8L) % 8;
    }
    
    public BlockPos func_177496_h() {
        return null;
    }
    
    public boolean getHasNoSky() {
        return this.hasNoSky;
    }
    
    public abstract String getDimensionName();
    
    public int getDimensionId() {
        return this.dimensionId;
    }
    
    public boolean canCoordinateBeSpawn(final int lllllllllllllllIIllIIIIIlIllIlIl, final int lllllllllllllllIIllIIIIIlIllIIll) {
        return this.worldObj.getGroundAboveSeaLevel(new BlockPos(lllllllllllllllIIllIIIIIlIllIlIl, 0, lllllllllllllllIIllIIIIIlIllIIll)) == Blocks.grass;
    }
    
    public float getCloudHeight() {
        return 128.0f;
    }
    
    protected void registerWorldChunkManager() {
        final WorldType lllllllllllllllIIllIIIIIllIlIlIl = this.worldObj.getWorldInfo().getTerrainType();
        if (lllllllllllllllIIllIIIIIllIlIlIl == WorldType.FLAT) {
            final FlatGeneratorInfo lllllllllllllllIIllIIIIIllIlIlII = FlatGeneratorInfo.createFlatGeneratorFromString(this.worldObj.getWorldInfo().getGeneratorOptions());
            this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.getBiomeFromBiomeList(lllllllllllllllIIllIIIIIllIlIlII.getBiome(), BiomeGenBase.field_180279_ad), 0.5f);
        }
        else if (lllllllllllllllIIllIIIIIllIlIlIl == WorldType.DEBUG_WORLD) {
            this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.plains, 0.0f);
        }
        else {
            this.worldChunkMgr = new WorldChunkManager(this.worldObj);
        }
    }
    
    public boolean func_177500_n() {
        return this.isHellWorld;
    }
    
    public boolean canRespawnHere() {
        return true;
    }
    
    public int getAverageGroundLevel() {
        return (this.terrainType == WorldType.FLAT) ? 4 : 64;
    }
    
    public WorldProvider() {
        this.lightBrightnessTable = new float[16];
        this.colorsSunriseSunset = new float[4];
    }
    
    public double getVoidFogYFactor() {
        return (this.terrainType == WorldType.FLAT) ? 1.0 : 0.03125;
    }
    
    public final void registerWorld(final World lllllllllllllllIIllIIIIIlllIlIII) {
        this.worldObj = lllllllllllllllIIllIIIIIlllIlIII;
        this.terrainType = lllllllllllllllIIllIIIIIlllIlIII.getWorldInfo().getTerrainType();
        this.generatorSettings = lllllllllllllllIIllIIIIIlllIlIII.getWorldInfo().getGeneratorOptions();
        this.registerWorldChunkManager();
        this.generateLightBrightnessTable();
    }
    
    public float calculateCelestialAngle(final long lllllllllllllllIIllIIIIIlIIIllll, final float lllllllllllllllIIllIIIIIlIIIlllI) {
        final int lllllllllllllllIIllIIIIIlIIlIIlI = (int)(lllllllllllllllIIllIIIIIlIIIllll % 24000L);
        float lllllllllllllllIIllIIIIIlIIlIIIl = (lllllllllllllllIIllIIIIIlIIlIIlI + lllllllllllllllIIllIIIIIlIIIlllI) / 24000.0f - 0.25f;
        if (lllllllllllllllIIllIIIIIlIIlIIIl < 0.0f) {
            ++lllllllllllllllIIllIIIIIlIIlIIIl;
        }
        if (lllllllllllllllIIllIIIIIlIIlIIIl > 1.0f) {
            --lllllllllllllllIIllIIIIIlIIlIIIl;
        }
        final float lllllllllllllllIIllIIIIIlIIlIIII = lllllllllllllllIIllIIIIIlIIlIIIl;
        lllllllllllllllIIllIIIIIlIIlIIIl = 1.0f - (float)((Math.cos(lllllllllllllllIIllIIIIIlIIlIIIl * 3.141592653589793) + 1.0) / 2.0);
        lllllllllllllllIIllIIIIIlIIlIIIl = lllllllllllllllIIllIIIIIlIIlIIII + (lllllllllllllllIIllIIIIIlIIlIIIl - lllllllllllllllIIllIIIIIlIIlIIII) / 3.0f;
        return lllllllllllllllIIllIIIIIlIIlIIIl;
    }
    
    public boolean isSurfaceWorld() {
        return true;
    }
    
    public abstract String getInternalNameSuffix();
    
    public Vec3 getFogColor(final float lllllllllllllllIIllIIIIIIllIIIII, final float lllllllllllllllIIllIIIIIIlIlllll) {
        float lllllllllllllllIIllIIIIIIlIllllI = MathHelper.cos(lllllllllllllllIIllIIIIIIllIIIII * 3.1415927f * 2.0f) * 2.0f + 0.5f;
        lllllllllllllllIIllIIIIIIlIllllI = MathHelper.clamp_float(lllllllllllllllIIllIIIIIIlIllllI, 0.0f, 1.0f);
        float lllllllllllllllIIllIIIIIIlIlllII = 0.7529412f;
        float lllllllllllllllIIllIIIIIIlIllIll = 0.84705883f;
        float lllllllllllllllIIllIIIIIIlIllIIl = 1.0f;
        lllllllllllllllIIllIIIIIIlIlllII *= lllllllllllllllIIllIIIIIIlIllllI * 0.94f + 0.06f;
        lllllllllllllllIIllIIIIIIlIllIll *= lllllllllllllllIIllIIIIIIlIllllI * 0.94f + 0.06f;
        lllllllllllllllIIllIIIIIIlIllIIl *= lllllllllllllllIIllIIIIIIlIllllI * 0.91f + 0.09f;
        return new Vec3(lllllllllllllllIIllIIIIIIlIlllII, lllllllllllllllIIllIIIIIIlIllIll, lllllllllllllllIIllIIIIIIlIllIIl);
    }
    
    public boolean isSkyColored() {
        return true;
    }
    
    public IChunkProvider createChunkGenerator() {
        return (this.terrainType == WorldType.FLAT) ? new ChunkProviderFlat(this.worldObj, this.worldObj.getSeed(), this.worldObj.getWorldInfo().isMapFeaturesEnabled(), this.generatorSettings) : ((this.terrainType == WorldType.DEBUG_WORLD) ? new ChunkProviderDebug(this.worldObj) : ((this.terrainType == WorldType.CUSTOMIZED) ? new ChunkProviderGenerate(this.worldObj, this.worldObj.getSeed(), this.worldObj.getWorldInfo().isMapFeaturesEnabled(), this.generatorSettings) : new ChunkProviderGenerate(this.worldObj, this.worldObj.getSeed(), this.worldObj.getWorldInfo().isMapFeaturesEnabled(), this.generatorSettings)));
    }
    
    protected void generateLightBrightnessTable() {
        final float lllllllllllllllIIllIIIIIlllIIIII = 0.0f;
        for (int lllllllllllllllIIllIIIIIllIlllll = 0; lllllllllllllllIIllIIIIIllIlllll <= 15; ++lllllllllllllllIIllIIIIIllIlllll) {
            final float lllllllllllllllIIllIIIIIllIllllI = 1.0f - lllllllllllllllIIllIIIIIllIlllll / 15.0f;
            this.lightBrightnessTable[lllllllllllllllIIllIIIIIllIlllll] = (1.0f - lllllllllllllllIIllIIIIIllIllllI) / (lllllllllllllllIIllIIIIIllIllllI * 3.0f + 1.0f) * (1.0f - lllllllllllllllIIllIIIIIlllIIIII) + lllllllllllllllIIllIIIIIlllIIIII;
        }
    }
    
    public float[] getLightBrightnessTable() {
        return this.lightBrightnessTable;
    }
    
    public WorldBorder getWorldBorder() {
        return new WorldBorder();
    }
}
