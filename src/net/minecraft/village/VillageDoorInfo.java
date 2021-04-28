package net.minecraft.village;

import net.minecraft.util.*;

public class VillageDoorInfo
{
    private final /* synthetic */ BlockPos field_179859_a;
    private /* synthetic */ boolean isDetachedFromVillageFlag;
    private /* synthetic */ int doorOpeningRestrictionCounter;
    private /* synthetic */ int lastActivityTimestamp;
    private final /* synthetic */ BlockPos field_179857_b;
    private final /* synthetic */ EnumFacing field_179858_c;
    
    public void incrementDoorOpeningRestrictionCounter() {
        ++this.doorOpeningRestrictionCounter;
    }
    
    public int getDoorOpeningRestrictionCounter() {
        return this.doorOpeningRestrictionCounter;
    }
    
    public boolean func_179851_i() {
        return this.isDetachedFromVillageFlag;
    }
    
    public int func_179846_b(final BlockPos llllllllllllllIlIIIIlllIllIIllll) {
        return (int)this.field_179857_b.distanceSq(llllllllllllllIlIIIIlllIllIIllll);
    }
    
    static {
        __OBFID = "CL_00001630";
    }
    
    public int func_179855_g() {
        return this.field_179858_c.getFrontOffsetZ() * 2;
    }
    
    private static EnumFacing func_179854_a(final int llllllllllllllIlIIIIlllIllllIIlI, final int llllllllllllllIlIIIIlllIllllIIll) {
        return (llllllllllllllIlIIIIlllIllllIIlI < 0) ? EnumFacing.WEST : ((llllllllllllllIlIIIIlllIllllIIlI > 0) ? EnumFacing.EAST : ((llllllllllllllIlIIIIlllIllllIIll < 0) ? EnumFacing.NORTH : EnumFacing.SOUTH));
    }
    
    public VillageDoorInfo(final BlockPos llllllllllllllIlIIIIlllIllllllll, final int llllllllllllllIlIIIIlllIlllllllI, final int llllllllllllllIlIIIIlllIllllllIl, final int llllllllllllllIlIIIIlllIllllIlll) {
        this(llllllllllllllIlIIIIlllIllllllll, func_179854_a(llllllllllllllIlIIIIlllIlllllllI, llllllllllllllIlIIIIlllIllllllIl), llllllllllllllIlIIIIlllIllllIlll);
    }
    
    public VillageDoorInfo(final BlockPos llllllllllllllIlIIIIlllIlllIIlll, final EnumFacing llllllllllllllIlIIIIlllIlllIlIlI, final int llllllllllllllIlIIIIlllIlllIIlIl) {
        this.field_179859_a = llllllllllllllIlIIIIlllIlllIIlll;
        this.field_179858_c = llllllllllllllIlIIIIlllIlllIlIlI;
        this.field_179857_b = llllllllllllllIlIIIIlllIlllIIlll.offset(llllllllllllllIlIIIIlllIlllIlIlI, 2);
        this.lastActivityTimestamp = llllllllllllllIlIIIIlllIlllIIlIl;
    }
    
    public BlockPos func_179856_e() {
        return this.field_179857_b;
    }
    
    public BlockPos func_179852_d() {
        return this.field_179859_a;
    }
    
    public int func_179847_f() {
        return this.field_179858_c.getFrontOffsetX() * 2;
    }
    
    public int getDistanceSquared(final int llllllllllllllIlIIIIlllIllIlllll, final int llllllllllllllIlIIIIlllIllIllIlI, final int llllllllllllllIlIIIIlllIllIllIIl) {
        return (int)this.field_179859_a.distanceSq(llllllllllllllIlIIIIlllIllIlllll, llllllllllllllIlIIIIlllIllIllIlI, llllllllllllllIlIIIIlllIllIllIIl);
    }
    
    public void func_179853_a(final boolean llllllllllllllIlIIIIlllIlIIllIlI) {
        this.isDetachedFromVillageFlag = llllllllllllllIlIIIIlllIlIIllIlI;
    }
    
    public void resetDoorOpeningRestrictionCounter() {
        this.doorOpeningRestrictionCounter = 0;
    }
    
    public int getInsidePosY() {
        return this.lastActivityTimestamp;
    }
    
    public boolean func_179850_c(final BlockPos llllllllllllllIlIIIIlllIllIIIlll) {
        final int llllllllllllllIlIIIIlllIllIIIllI = llllllllllllllIlIIIIlllIllIIIlll.getX() - this.field_179859_a.getX();
        final int llllllllllllllIlIIIIlllIllIIIlIl = llllllllllllllIlIIIIlllIllIIIlll.getZ() - this.field_179859_a.getY();
        return llllllllllllllIlIIIIlllIllIIIllI * this.field_179858_c.getFrontOffsetX() + llllllllllllllIlIIIIlllIllIIIlIl * this.field_179858_c.getFrontOffsetZ() >= 0;
    }
    
    public int func_179848_a(final BlockPos llllllllllllllIlIIIIlllIllIlIIll) {
        return (int)llllllllllllllIlIIIIlllIllIlIIll.distanceSq(this.func_179852_d());
    }
    
    public void func_179849_a(final int llllllllllllllIlIIIIlllIlIlIIIll) {
        this.lastActivityTimestamp = llllllllllllllIlIIIIlllIlIlIIIll;
    }
}
