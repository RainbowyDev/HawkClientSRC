package net.minecraft.world.border;

public enum EnumBorderStatus
{
    SHRINKING("SHRINKING", 1, "SHRINKING", 1, 16724016), 
    STATIONARY("STATIONARY", 2, "STATIONARY", 2, 2138367);
    
    private final /* synthetic */ int id;
    
    GROWING("GROWING", 0, "GROWING", 0, 4259712);
    
    static {
        __OBFID = "CL_00002013";
    }
    
    private EnumBorderStatus(final String llllllllllllllllIllIIlllIIIIlIIl, final int llllllllllllllllIllIIlllIIIIlIII, final String llllllllllllllllIllIIlllIIIIllIl, final int llllllllllllllllIllIIlllIIIIllII, final int llllllllllllllllIllIIlllIIIIIlll) {
        this.id = llllllllllllllllIllIIlllIIIIIlll;
    }
    
    public int func_177766_a() {
        return this.id;
    }
}
