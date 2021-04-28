package hawk.util;

import java.math.*;

public class MathUtils
{
    public static double square(double lllllllllllllllIlIIIlIlIllIIIIlI) {
        lllllllllllllllIlIIIlIlIllIIIIlI *= lllllllllllllllIlIIIlIlIllIIIIlI;
        return lllllllllllllllIlIIIlIlIllIIIIlI;
    }
    
    public static double randomNumber(final double lllllllllllllllIlIIIlIlIllIlIIIl, final double lllllllllllllllIlIIIlIlIllIIlIll) {
        return Math.random() * (lllllllllllllllIlIIIlIlIllIlIIIl - lllllllllllllllIlIIIlIlIllIIlIll) + lllllllllllllllIlIIIlIlIllIIlIll;
    }
    
    public static double round(final double lllllllllllllllIlIIIlIlIlIlllIlI, final double lllllllllllllllIlIIIlIlIlIllIllI) {
        if (lllllllllllllllIlIIIlIlIlIllIllI < 0.0) {
            throw new IllegalArgumentException();
        }
        BigDecimal lllllllllllllllIlIIIlIlIlIlllIII = new BigDecimal(lllllllllllllllIlIIIlIlIlIlllIlI);
        lllllllllllllllIlIIIlIlIlIlllIII = lllllllllllllllIlIIIlIlIlIlllIII.setScale((int)lllllllllllllllIlIIIlIlIlIllIllI, RoundingMode.HALF_UP);
        return lllllllllllllllIlIIIlIlIlIlllIII.doubleValue();
    }
}
