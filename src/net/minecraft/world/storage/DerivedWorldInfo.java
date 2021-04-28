package net.minecraft.world.storage;

import net.minecraft.nbt.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class DerivedWorldInfo extends WorldInfo
{
    private final /* synthetic */ WorldInfo theWorldInfo;
    
    @Override
    public void setServerInitialized(final boolean llllllllllllllIlIIIlIlIllllIlIIl) {
    }
    
    @Override
    public boolean areCommandsAllowed() {
        return this.theWorldInfo.areCommandsAllowed();
    }
    
    @Override
    public boolean isDifficultyLocked() {
        return this.theWorldInfo.isDifficultyLocked();
    }
    
    @Override
    public long getLastTimePlayed() {
        return this.theWorldInfo.getLastTimePlayed();
    }
    
    @Override
    public void setRainTime(final int llllllllllllllIlIIIlIlIllllllllI) {
    }
    
    @Override
    public void setSpawnZ(final int llllllllllllllIlIIIlIllIIIIlIIII) {
    }
    
    @Override
    public boolean isThundering() {
        return this.theWorldInfo.isThundering();
    }
    
    @Override
    public boolean isHardcoreModeEnabled() {
        return this.theWorldInfo.isHardcoreModeEnabled();
    }
    
    @Override
    public String getWorldName() {
        return this.theWorldInfo.getWorldName();
    }
    
    @Override
    public long getWorldTotalTime() {
        return this.theWorldInfo.getWorldTotalTime();
    }
    
    @Override
    public long getSizeOnDisk() {
        return this.theWorldInfo.getSizeOnDisk();
    }
    
    @Override
    public NBTTagCompound getNBTTagCompound() {
        return this.theWorldInfo.getNBTTagCompound();
    }
    
    @Override
    public void setSaveVersion(final int llllllllllllllIlIIIlIllIIIIIIllI) {
    }
    
    @Override
    public void setTerrainType(final WorldType llllllllllllllIlIIIlIlIlllllIIll) {
    }
    
    @Override
    public void setDifficulty(final EnumDifficulty llllllllllllllIlIIIlIlIllllIIIIl) {
    }
    
    @Override
    public long getWorldTime() {
        return this.theWorldInfo.getWorldTime();
    }
    
    @Override
    public void setRaining(final boolean llllllllllllllIlIIIlIllIIIIIIIII) {
    }
    
    @Override
    public boolean isMapFeaturesEnabled() {
        return this.theWorldInfo.isMapFeaturesEnabled();
    }
    
    @Override
    public void setAllowCommands(final boolean llllllllllllllIlIIIlIlIllllIlllI) {
    }
    
    @Override
    public void setThunderTime(final int llllllllllllllIlIIIlIllIIIIIIIlI) {
    }
    
    @Override
    public void setSpawn(final BlockPos llllllllllllllIlIIIlIllIIIIIlIlI) {
    }
    
    public DerivedWorldInfo(final WorldInfo llllllllllllllIlIIIlIllIIlIIllll) {
        this.theWorldInfo = llllllllllllllIlIIIlIllIIlIIllll;
    }
    
    @Override
    public void setSpawnY(final int llllllllllllllIlIIIlIllIIIIlIIlI) {
    }
    
    @Override
    public void setThundering(final boolean llllllllllllllIlIIIlIllIIIIIIlII) {
    }
    
    @Override
    public void setSpawnX(final int llllllllllllllIlIIIlIllIIIIlIlII) {
    }
    
    @Override
    public boolean isInitialized() {
        return this.theWorldInfo.isInitialized();
    }
    
    @Override
    public void setWorldTime(final long llllllllllllllIlIIIlIllIIIIIllII) {
    }
    
    @Override
    public int getRainTime() {
        return this.theWorldInfo.getRainTime();
    }
    
    @Override
    public NBTTagCompound getPlayerNBTTagCompound() {
        return this.theWorldInfo.getPlayerNBTTagCompound();
    }
    
    @Override
    public int getSpawnZ() {
        return this.theWorldInfo.getSpawnZ();
    }
    
    @Override
    public NBTTagCompound cloneNBTCompound(final NBTTagCompound llllllllllllllIlIIIlIllIIlIIIllI) {
        return this.theWorldInfo.cloneNBTCompound(llllllllllllllIlIIIlIllIIlIIIllI);
    }
    
    @Override
    public long getSeed() {
        return this.theWorldInfo.getSeed();
    }
    
    @Override
    public void incrementTotalWorldTime(final long llllllllllllllIlIIIlIllIIIIIlllI) {
    }
    
    static {
        __OBFID = "CL_00000584";
    }
    
    @Override
    public int getSpawnY() {
        return this.theWorldInfo.getSpawnY();
    }
    
    @Override
    public boolean isRaining() {
        return this.theWorldInfo.isRaining();
    }
    
    @Override
    public int getSpawnX() {
        return this.theWorldInfo.getSpawnX();
    }
    
    @Override
    public int getThunderTime() {
        return this.theWorldInfo.getThunderTime();
    }
    
    @Override
    public WorldSettings.GameType getGameType() {
        return this.theWorldInfo.getGameType();
    }
    
    @Override
    public void setWorldName(final String llllllllllllllIlIIIlIllIIIIIlIII) {
    }
    
    @Override
    public int getSaveVersion() {
        return this.theWorldInfo.getSaveVersion();
    }
    
    @Override
    public WorldType getTerrainType() {
        return this.theWorldInfo.getTerrainType();
    }
    
    @Override
    public void setDifficultyLocked(final boolean llllllllllllllIlIIIlIlIlllIlllII) {
    }
    
    @Override
    public EnumDifficulty getDifficulty() {
        return this.theWorldInfo.getDifficulty();
    }
    
    @Override
    public GameRules getGameRulesInstance() {
        return this.theWorldInfo.getGameRulesInstance();
    }
}
