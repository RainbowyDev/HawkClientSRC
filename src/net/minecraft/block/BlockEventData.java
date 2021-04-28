package net.minecraft.block;

import net.minecraft.util.*;

public class BlockEventData
{
    private /* synthetic */ int eventParameter;
    private /* synthetic */ int eventID;
    private /* synthetic */ BlockPos field_180329_a;
    private /* synthetic */ Block field_151344_d;
    
    @Override
    public boolean equals(final Object lllllllllllllllIIlllIIIIIllIIlII) {
        if (!(lllllllllllllllIIlllIIIIIllIIlII instanceof BlockEventData)) {
            return false;
        }
        final BlockEventData lllllllllllllllIIlllIIIIIllIIllI = (BlockEventData)lllllllllllllllIIlllIIIIIllIIlII;
        return this.field_180329_a.equals(lllllllllllllllIIlllIIIIIllIIllI.field_180329_a) && this.eventID == lllllllllllllllIIlllIIIIIllIIllI.eventID && this.eventParameter == lllllllllllllllIIlllIIIIIllIIllI.eventParameter && this.field_151344_d == lllllllllllllllIIlllIIIIIllIIllI.field_151344_d;
    }
    
    static {
        __OBFID = "CL_00000131";
    }
    
    public int getEventID() {
        return this.eventID;
    }
    
    public BlockEventData(final BlockPos lllllllllllllllIIlllIIIIlIIIIIII, final Block lllllllllllllllIIlllIIIIIlllllll, final int lllllllllllllllIIlllIIIIIllllIIl, final int lllllllllllllllIIlllIIIIIllllIII) {
        this.field_180329_a = lllllllllllllllIIlllIIIIlIIIIIII;
        this.eventID = lllllllllllllllIIlllIIIIIllllIIl;
        this.eventParameter = lllllllllllllllIIlllIIIIIllllIII;
        this.field_151344_d = lllllllllllllllIIlllIIIIIlllllll;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("TE(").append(this.field_180329_a).append("),").append(this.eventID).append(",").append(this.eventParameter).append(",").append(this.field_151344_d));
    }
    
    public BlockPos func_180328_a() {
        return this.field_180329_a;
    }
    
    public int getEventParameter() {
        return this.eventParameter;
    }
    
    public Block getBlock() {
        return this.field_151344_d;
    }
}
