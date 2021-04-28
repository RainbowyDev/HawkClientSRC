package hawk.ui;

import java.awt.*;

public class ColorUtil
{
    public static int getRainbow(final float lllllllllllllllIlllIIIIIlIIIllIl, final float lllllllllllllllIlllIIIIIlIIIllII, final float lllllllllllllllIlllIIIIIlIIIlIll) {
        final float lllllllllllllllIlllIIIIIlIIIlIlI = System.currentTimeMillis() % (int)(lllllllllllllllIlllIIIIIlIIIllIl * 1000.0f) / (lllllllllllllllIlllIIIIIlIIIllIl * 1000.0f);
        final int lllllllllllllllIlllIIIIIlIIIlIIl = Color.HSBtoRGB(lllllllllllllllIlllIIIIIlIIIlIlI, lllllllllllllllIlllIIIIIlIIIllII, lllllllllllllllIlllIIIIIlIIIlIll);
        return lllllllllllllllIlllIIIIIlIIIlIIl;
    }
    
    public static int getRainbow(final float lllllllllllllllIlllIIIIIIlllIlll, final float lllllllllllllllIlllIIIIIIlllIllI, final float lllllllllllllllIlllIIIIIIlllIlIl, final long lllllllllllllllIlllIIIIIIllllIlI) {
        final float lllllllllllllllIlllIIIIIIllllIIl = (System.currentTimeMillis() + lllllllllllllllIlllIIIIIIllllIlI) % (int)(lllllllllllllllIlllIIIIIIlllIlll * 1000.0f) / (lllllllllllllllIlllIIIIIIlllIlll * 1000.0f);
        final int lllllllllllllllIlllIIIIIIllllIII = Color.HSBtoRGB(lllllllllllllllIlllIIIIIIllllIIl, lllllllllllllllIlllIIIIIIlllIllI, lllllllllllllllIlllIIIIIIlllIlIl);
        return lllllllllllllllIlllIIIIIIllllIII;
    }
}
