package net.minecraft.util;

public enum EnumWorldBlockLayer
{
    SOLID("SOLID", 0, "SOLID", 0, "Solid"), 
    CUTOUT_MIPPED("CUTOUT_MIPPED", 1, "CUTOUT_MIPPED", 1, "Mipped Cutout"), 
    TRANSLUCENT("TRANSLUCENT", 3, "TRANSLUCENT", 3, "Translucent");
    
    private final /* synthetic */ String field_180338_e;
    
    CUTOUT("CUTOUT", 2, "CUTOUT", 2, "Cutout");
    
    private EnumWorldBlockLayer(final String lllllllllllllllIllIlIIlIIIllllll, final int lllllllllllllllIllIlIIlIIIlllllI, final String lllllllllllllllIllIlIIlIIlIIIIll, final int lllllllllllllllIllIlIIlIIlIIIIlI, final String lllllllllllllllIllIlIIlIIIllllIl) {
        this.field_180338_e = lllllllllllllllIllIlIIlIIIllllIl;
    }
    
    static {
        __OBFID = "CL_00002152";
    }
    
    @Override
    public String toString() {
        return this.field_180338_e;
    }
}
