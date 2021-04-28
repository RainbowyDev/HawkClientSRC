package net.minecraft.world;

import net.minecraft.world.chunk.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.biome.*;
import net.minecraft.util.*;
import net.minecraft.world.border.*;

public class WorldProviderHell extends WorldProvider
{
    @Override
    public IChunkProvider createChunkGenerator() {
        return new ChunkProviderHell(this.worldObj, this.worldObj.getWorldInfo().isMapFeaturesEnabled(), this.worldObj.getSeed());
    }
    
    @Override
    public boolean doesXZShowFog(final int lllllllllllllllIllIIIllIlIIllllI, final int lllllllllllllllIllIIIllIlIIlllIl) {
        return true;
    }
    
    public void registerWorldChunkManager() {
        this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.hell, 0.0f);
        this.isHellWorld = true;
        this.hasNoSky = true;
        this.dimensionId = -1;
    }
    
    @Override
    public boolean isSurfaceWorld() {
        return false;
    }
    
    @Override
    public boolean canCoordinateBeSpawn(final int lllllllllllllllIllIIIllIlIlIIlIl, final int lllllllllllllllIllIIIllIlIlIIlII) {
        return false;
    }
    
    @Override
    public boolean canRespawnHere() {
        return false;
    }
    
    @Override
    public Vec3 getFogColor(final float lllllllllllllllIllIIIllIlIlllIII, final float lllllllllllllllIllIIIllIlIllIlll) {
        return new Vec3(0.20000000298023224, 0.029999999329447746, 0.029999999329447746);
    }
    
    @Override
    public WorldBorder getWorldBorder() {
        return new WorldBorder() {
            @Override
            public double getCenterZ() {
                return super.getCenterZ() / 8.0;
            }
            
            @Override
            public double getCenterX() {
                return super.getCenterX() / 8.0;
            }
            
            static {
                __OBFID = "CL_00002008";
            }
        };
    }
    
    @Override
    public String getDimensionName() {
        return "Nether";
    }
    
    @Override
    public float calculateCelestialAngle(final long lllllllllllllllIllIIIllIlIlIIIlI, final float lllllllllllllllIllIIIllIlIlIIIIl) {
        return 0.5f;
    }
    
    @Override
    protected void generateLightBrightnessTable() {
        final float lllllllllllllllIllIIIllIlIllIIIl = 0.1f;
        for (int lllllllllllllllIllIIIllIlIllIIII = 0; lllllllllllllllIllIIIllIlIllIIII <= 15; ++lllllllllllllllIllIIIllIlIllIIII) {
            final float lllllllllllllllIllIIIllIlIlIllll = 1.0f - lllllllllllllllIllIIIllIlIllIIII / 15.0f;
            this.lightBrightnessTable[lllllllllllllllIllIIIllIlIllIIII] = (1.0f - lllllllllllllllIllIIIllIlIlIllll) / (lllllllllllllllIllIIIllIlIlIllll * 3.0f + 1.0f) * (1.0f - lllllllllllllllIllIIIllIlIllIIIl) + lllllllllllllllIllIIIllIlIllIIIl;
        }
    }
    
    @Override
    public String getInternalNameSuffix() {
        return "_nether";
    }
    
    static {
        __OBFID = "CL_00000387";
    }
}
