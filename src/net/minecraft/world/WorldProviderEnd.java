package net.minecraft.world;

import net.minecraft.world.biome.*;
import net.minecraft.util.*;
import net.minecraft.world.chunk.*;
import net.minecraft.world.gen.*;

public class WorldProviderEnd extends WorldProvider
{
    static {
        __OBFID = "CL_00000389";
    }
    
    @Override
    public boolean canRespawnHere() {
        return false;
    }
    
    @Override
    public float calculateCelestialAngle(final long llllllllllllllIllIIllIlIllllIlIl, final float llllllllllllllIllIIllIlIllllIlII) {
        return 0.0f;
    }
    
    @Override
    public Vec3 getFogColor(final float llllllllllllllIllIIllIlIlllIlIIl, final float llllllllllllllIllIIllIlIlllIlIII) {
        final int llllllllllllllIllIIllIlIlllIIlll = 10518688;
        float llllllllllllllIllIIllIlIlllIIllI = MathHelper.cos(llllllllllllllIllIIllIlIlllIlIIl * 3.1415927f * 2.0f) * 2.0f + 0.5f;
        llllllllllllllIllIIllIlIlllIIllI = MathHelper.clamp_float(llllllllllllllIllIIllIlIlllIIllI, 0.0f, 1.0f);
        float llllllllllllllIllIIllIlIlllIIlIl = (llllllllllllllIllIIllIlIlllIIlll >> 16 & 0xFF) / 255.0f;
        float llllllllllllllIllIIllIlIlllIIlII = (llllllllllllllIllIIllIlIlllIIlll >> 8 & 0xFF) / 255.0f;
        float llllllllllllllIllIIllIlIlllIIIll = (llllllllllllllIllIIllIlIlllIIlll & 0xFF) / 255.0f;
        llllllllllllllIllIIllIlIlllIIlIl *= llllllllllllllIllIIllIlIlllIIllI * 0.0f + 0.15f;
        llllllllllllllIllIIllIlIlllIIlII *= llllllllllllllIllIIllIlIlllIIllI * 0.0f + 0.15f;
        llllllllllllllIllIIllIlIlllIIIll *= llllllllllllllIllIIllIlIlllIIllI * 0.0f + 0.15f;
        return new Vec3(llllllllllllllIllIIllIlIlllIIlIl, llllllllllllllIllIIllIlIlllIIlII, llllllllllllllIllIIllIlIlllIIIll);
    }
    
    public void registerWorldChunkManager() {
        this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.sky, 0.0f);
        this.dimensionId = 1;
        this.hasNoSky = true;
    }
    
    @Override
    public int getAverageGroundLevel() {
        return 50;
    }
    
    @Override
    public boolean isSkyColored() {
        return false;
    }
    
    @Override
    public String getDimensionName() {
        return "The End";
    }
    
    @Override
    public BlockPos func_177496_h() {
        return new BlockPos(100, 50, 0);
    }
    
    @Override
    public boolean isSurfaceWorld() {
        return false;
    }
    
    @Override
    public boolean doesXZShowFog(final int llllllllllllllIllIIllIlIllIIllII, final int llllllllllllllIllIIllIlIllIIlIll) {
        return true;
    }
    
    @Override
    public float[] calcSunriseSunsetColors(final float llllllllllllllIllIIllIlIllllIIlI, final float llllllllllllllIllIIllIlIllllIIIl) {
        return null;
    }
    
    @Override
    public IChunkProvider createChunkGenerator() {
        return new ChunkProviderEnd(this.worldObj, this.worldObj.getSeed());
    }
    
    @Override
    public String getInternalNameSuffix() {
        return "_end";
    }
    
    @Override
    public float getCloudHeight() {
        return 8.0f;
    }
    
    @Override
    public boolean canCoordinateBeSpawn(final int llllllllllllllIllIIllIlIllIlIlII, final int llllllllllllllIllIIllIlIllIlIIII) {
        return this.worldObj.getGroundAboveSeaLevel(new BlockPos(llllllllllllllIllIIllIlIllIlIlII, 0, llllllllllllllIllIIllIlIllIlIIII)).getMaterial().blocksMovement();
    }
}
