package net.minecraft.world;

import net.minecraft.block.*;
import net.minecraft.util.*;

public class NextTickListEntry implements Comparable
{
    private /* synthetic */ long tickEntryID;
    public /* synthetic */ int priority;
    private final /* synthetic */ Block field_151352_g;
    public final /* synthetic */ BlockPos field_180282_a;
    private static /* synthetic */ long nextTickEntryID;
    public /* synthetic */ long scheduledTime;
    
    @Override
    public int hashCode() {
        return this.field_180282_a.hashCode();
    }
    
    public int compareTo(final NextTickListEntry lllllllllllllllIIlIlIIllIIIIIllI) {
        return (this.scheduledTime < lllllllllllllllIIlIlIIllIIIIIllI.scheduledTime) ? -1 : ((this.scheduledTime > lllllllllllllllIIlIlIIllIIIIIllI.scheduledTime) ? 1 : ((this.priority != lllllllllllllllIIlIlIIllIIIIIllI.priority) ? (this.priority - lllllllllllllllIIlIlIIllIIIIIllI.priority) : ((this.tickEntryID < lllllllllllllllIIlIlIIllIIIIIllI.tickEntryID) ? -1 : ((this.tickEntryID > lllllllllllllllIIlIlIIllIIIIIllI.tickEntryID) ? 1 : 0))));
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder(String.valueOf(Block.getIdFromBlock(this.field_151352_g))).append(": ").append(this.field_180282_a).append(", ").append(this.scheduledTime).append(", ").append(this.priority).append(", ").append(this.tickEntryID));
    }
    
    public NextTickListEntry setScheduledTime(final long lllllllllllllllIIlIlIIllIIIlIIII) {
        this.scheduledTime = lllllllllllllllIIlIlIIllIIIlIIII;
        return this;
    }
    
    static {
        __OBFID = "CL_00000156";
    }
    
    public NextTickListEntry(final BlockPos lllllllllllllllIIlIlIIllIIlIIllI, final Block lllllllllllllllIIlIlIIllIIlIIIlI) {
        this.tickEntryID = NextTickListEntry.nextTickEntryID++;
        this.field_180282_a = lllllllllllllllIIlIlIIllIIlIIllI;
        this.field_151352_g = lllllllllllllllIIlIlIIllIIlIIIlI;
    }
    
    public void setPriority(final int lllllllllllllllIIlIlIIllIIIIllII) {
        this.priority = lllllllllllllllIIlIlIIllIIIIllII;
    }
    
    @Override
    public int compareTo(final Object lllllllllllllllIIlIlIIlIllllIlll) {
        return this.compareTo((NextTickListEntry)lllllllllllllllIIlIlIIlIllllIlll);
    }
    
    public Block func_151351_a() {
        return this.field_151352_g;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllllIIlIlIIllIIIlllIl) {
        if (!(lllllllllllllllIIlIlIIllIIIlllIl instanceof NextTickListEntry)) {
            return false;
        }
        final NextTickListEntry lllllllllllllllIIlIlIIllIIIlllII = (NextTickListEntry)lllllllllllllllIIlIlIIllIIIlllIl;
        return this.field_180282_a.equals(lllllllllllllllIIlIlIIllIIIlllII.field_180282_a) && Block.isEqualTo(this.field_151352_g, lllllllllllllllIIlIlIIllIIIlllII.field_151352_g);
    }
}
