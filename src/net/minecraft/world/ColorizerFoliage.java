package net.minecraft.world;

public class ColorizerFoliage
{
    private static /* synthetic */ int[] foliageBuffer;
    
    public static int getFoliageColorBasic() {
        return 4764952;
    }
    
    public static int getFoliageColor(final double llllllllllllllIIIIllllllIllIIIlI, double llllllllllllllIIIIllllllIllIIIIl) {
        llllllllllllllIIIIllllllIllIIIIl *= llllllllllllllIIIIllllllIllIIIlI;
        final int llllllllllllllIIIIllllllIllIIlII = (int)((1.0 - llllllllllllllIIIIllllllIllIIIlI) * 255.0);
        final int llllllllllllllIIIIllllllIllIIIll = (int)((1.0 - llllllllllllllIIIIllllllIllIIIIl) * 255.0);
        return ColorizerFoliage.foliageBuffer[llllllllllllllIIIIllllllIllIIIll << 8 | llllllllllllllIIIIllllllIllIIlII];
    }
    
    static {
        __OBFID = "CL_00000135";
        ColorizerFoliage.foliageBuffer = new int[65536];
    }
    
    public static void setFoliageBiomeColorizer(final int[] llllllllllllllIIIIllllllIllIllII) {
        ColorizerFoliage.foliageBuffer = llllllllllllllIIIIllllllIllIllII;
    }
    
    public static int getFoliageColorPine() {
        return 6396257;
    }
    
    public static int getFoliageColorBirch() {
        return 8431445;
    }
}
