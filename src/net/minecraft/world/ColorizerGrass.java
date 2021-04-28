package net.minecraft.world;

public class ColorizerGrass
{
    private static /* synthetic */ int[] grassBuffer;
    
    public static void setGrassBiomeColorizer(final int[] llllllllllllllIlIlIIIlIlIIlllIlI) {
        ColorizerGrass.grassBuffer = llllllllllllllIlIlIIIlIlIIlllIlI;
    }
    
    public static int getGrassColor(final double llllllllllllllIlIlIIIlIlIIllIIll, double llllllllllllllIlIlIIIlIlIIlIllIl) {
        llllllllllllllIlIlIIIlIlIIlIllIl *= (float)llllllllllllllIlIlIIIlIlIIllIIll;
        final int llllllllllllllIlIlIIIlIlIIllIIIl = (int)((1.0 - llllllllllllllIlIlIIIlIlIIllIIll) * 255.0);
        final int llllllllllllllIlIlIIIlIlIIllIIII = (int)((1.0 - llllllllllllllIlIlIIIlIlIIlIllIl) * 255.0);
        final int llllllllllllllIlIlIIIlIlIIlIllll = llllllllllllllIlIlIIIlIlIIllIIII << 8 | llllllllllllllIlIlIIIlIlIIllIIIl;
        return (llllllllllllllIlIlIIIlIlIIlIllll > ColorizerGrass.grassBuffer.length) ? -65281 : ColorizerGrass.grassBuffer[llllllllllllllIlIlIIIlIlIIlIllll];
    }
    
    static {
        __OBFID = "CL_00000138";
        ColorizerGrass.grassBuffer = new int[65536];
    }
}
