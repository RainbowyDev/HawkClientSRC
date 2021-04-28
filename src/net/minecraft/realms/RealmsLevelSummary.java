package net.minecraft.realms;

import net.minecraft.world.storage.*;

public class RealmsLevelSummary implements Comparable
{
    private /* synthetic */ SaveFormatComparator levelSummary;
    
    public long getSizeOnDisk() {
        return this.levelSummary.func_154336_c();
    }
    
    public int getGameMode() {
        return this.levelSummary.getEnumGameType().getID();
    }
    
    public int compareTo(final RealmsLevelSummary llllllllllllllIIlIIlIIIIIlIIlllI) {
        return (this.levelSummary.getLastTimePlayed() < llllllllllllllIIlIIlIIIIIlIIlllI.getLastPlayed()) ? 1 : ((this.levelSummary.getLastTimePlayed() > llllllllllllllIIlIIlIIIIIlIIlllI.getLastPlayed()) ? -1 : this.levelSummary.getFileName().compareTo(llllllllllllllIIlIIlIIIIIlIIlllI.getLevelId()));
    }
    
    public String getLevelId() {
        return this.levelSummary.getFileName();
    }
    
    static {
        __OBFID = "CL_00001857";
    }
    
    public long getLastPlayed() {
        return this.levelSummary.getLastTimePlayed();
    }
    
    public boolean isRequiresConversion() {
        return this.levelSummary.requiresConversion();
    }
    
    public boolean hasCheats() {
        return this.levelSummary.getCheatsEnabled();
    }
    
    public int compareTo(final SaveFormatComparator llllllllllllllIIlIIlIIIIIlIllIIl) {
        return this.levelSummary.compareTo(llllllllllllllIIlIIlIIIIIlIllIIl);
    }
    
    public RealmsLevelSummary(final SaveFormatComparator llllllllllllllIIlIIlIIIIIlllIlII) {
        this.levelSummary = llllllllllllllIIlIIlIIIIIlllIlII;
    }
    
    public boolean isHardcore() {
        return this.levelSummary.isHardcoreModeEnabled();
    }
    
    @Override
    public int compareTo(final Object llllllllllllllIIlIIlIIIIIlIIlIlI) {
        return this.compareTo((RealmsLevelSummary)llllllllllllllIIlIIlIIIIIlIIlIlI);
    }
    
    public String getLevelName() {
        return this.levelSummary.getDisplayName();
    }
}
