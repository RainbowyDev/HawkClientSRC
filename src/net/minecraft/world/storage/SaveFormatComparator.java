package net.minecraft.world.storage;

import net.minecraft.world.*;

public class SaveFormatComparator implements Comparable
{
    private final /* synthetic */ long sizeOnDisk;
    private final /* synthetic */ boolean requiresConversion;
    private final /* synthetic */ long lastTimePlayed;
    private final /* synthetic */ String fileName;
    private final /* synthetic */ String displayName;
    private final /* synthetic */ WorldSettings.GameType theEnumGameType;
    private final /* synthetic */ boolean cheatsEnabled;
    private final /* synthetic */ boolean hardcore;
    
    static {
        __OBFID = "CL_00000601";
    }
    
    public WorldSettings.GameType getEnumGameType() {
        return this.theEnumGameType;
    }
    
    public boolean getCheatsEnabled() {
        return this.cheatsEnabled;
    }
    
    public long func_154336_c() {
        return this.sizeOnDisk;
    }
    
    public boolean requiresConversion() {
        return this.requiresConversion;
    }
    
    public long getLastTimePlayed() {
        return this.lastTimePlayed;
    }
    
    public int compareTo(final SaveFormatComparator lllllllllllllllIlIlIIllIlIIIIlll) {
        return (this.lastTimePlayed < lllllllllllllllIlIlIIllIlIIIIlll.lastTimePlayed) ? 1 : ((this.lastTimePlayed > lllllllllllllllIlIlIIllIlIIIIlll.lastTimePlayed) ? -1 : this.fileName.compareTo(lllllllllllllllIlIlIIllIlIIIIlll.fileName));
    }
    
    @Override
    public int compareTo(final Object lllllllllllllllIlIlIIllIIllllIlI) {
        return this.compareTo((SaveFormatComparator)lllllllllllllllIlIlIIllIIllllIlI);
    }
    
    public SaveFormatComparator(final String lllllllllllllllIlIlIIllIlIlIllII, final String lllllllllllllllIlIlIIllIlIlIIIlI, final long lllllllllllllllIlIlIIllIlIlIlIlI, final long lllllllllllllllIlIlIIllIlIlIIIII, final WorldSettings.GameType lllllllllllllllIlIlIIllIlIlIlIII, final boolean lllllllllllllllIlIlIIllIlIIllllI, final boolean lllllllllllllllIlIlIIllIlIlIIllI, final boolean lllllllllllllllIlIlIIllIlIIlllII) {
        this.fileName = lllllllllllllllIlIlIIllIlIlIllII;
        this.displayName = lllllllllllllllIlIlIIllIlIlIIIlI;
        this.lastTimePlayed = lllllllllllllllIlIlIIllIlIlIlIlI;
        this.sizeOnDisk = lllllllllllllllIlIlIIllIlIlIIIII;
        this.theEnumGameType = lllllllllllllllIlIlIIllIlIlIlIII;
        this.requiresConversion = lllllllllllllllIlIlIIllIlIIllllI;
        this.hardcore = lllllllllllllllIlIlIIllIlIlIIllI;
        this.cheatsEnabled = lllllllllllllllIlIlIIllIlIIlllII;
    }
    
    public String getFileName() {
        return this.fileName;
    }
    
    public String getDisplayName() {
        return this.displayName;
    }
    
    public boolean isHardcoreModeEnabled() {
        return this.hardcore;
    }
}
