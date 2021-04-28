package optifine;

public class MathUtils
{
    public static int getAverage(final int[] llllllllllllllIIlIlIllIIllllIllI) {
        if (llllllllllllllIIlIlIllIIllllIllI.length <= 0) {
            return 0;
        }
        int llllllllllllllIIlIlIllIIlllllIIl = 0;
        for (int llllllllllllllIIlIlIllIIlllllIII = 0; llllllllllllllIIlIlIllIIlllllIII < llllllllllllllIIlIlIllIIllllIllI.length; ++llllllllllllllIIlIlIllIIlllllIII) {
            final int llllllllllllllIIlIlIllIIllllIlll = llllllllllllllIIlIlIllIIllllIllI[llllllllllllllIIlIlIllIIlllllIII];
            llllllllllllllIIlIlIllIIlllllIIl += llllllllllllllIIlIlIllIIllllIlll;
        }
        int llllllllllllllIIlIlIllIIlllllIII = llllllllllllllIIlIlIllIIlllllIIl / llllllllllllllIIlIlIllIIllllIllI.length;
        return llllllllllllllIIlIlIllIIlllllIII;
    }
}
