package hawk.util;

import java.awt.*;
import net.minecraft.client.renderer.*;

public class JColor extends Color
{
    public JColor(final int llllllllllllllIllIIlIIlIIllIllIl, final int llllllllllllllIllIIlIIlIIllIlIII, final int llllllllllllllIllIIlIIlIIllIlIll) {
        super(llllllllllllllIllIIlIIlIIllIllIl, llllllllllllllIllIIlIIlIIllIlIII, llllllllllllllIllIIlIIlIIllIlIll);
    }
    
    public JColor(final JColor llllllllllllllIllIIlIIlIIlIIllIl, final int llllllllllllllIllIIlIIlIIlIIllII) {
        super(llllllllllllllIllIIlIIlIIlIIllIl.getRed(), llllllllllllllIllIIlIIlIIlIIllIl.getGreen(), llllllllllllllIllIIlIIlIIlIIllIl.getBlue(), llllllllllllllIllIIlIIlIIlIIllII);
    }
    
    public float getBrightness() {
        return Color.RGBtoHSB(this.getRed(), this.getGreen(), this.getBlue(), null)[2];
    }
    
    public float getHue() {
        return Color.RGBtoHSB(this.getRed(), this.getGreen(), this.getBlue(), null)[0];
    }
    
    public void glColor() {
        GlStateManager.color(this.getRed() / 255.0f, this.getGreen() / 255.0f, this.getBlue() / 255.0f, this.getAlpha() / 255.0f);
    }
    
    public static JColor fromHSB(final float llllllllllllllIllIIlIIlIIlIIIIlI, final float llllllllllllllIllIIlIIlIIlIIIlII, final float llllllllllllllIllIIlIIlIIlIIIIll) {
        return new JColor(Color.getHSBColor(llllllllllllllIllIIlIIlIIlIIIIlI, llllllllllllllIllIIlIIlIIlIIIlII, llllllllllllllIllIIlIIlIIlIIIIll));
    }
    
    public JColor(final int llllllllllllllIllIIlIIlIIlllllII) {
        super(llllllllllllllIllIIlIIlIIlllllII);
    }
    
    public float getSaturation() {
        return Color.RGBtoHSB(this.getRed(), this.getGreen(), this.getBlue(), null)[1];
    }
    
    public JColor(final int llllllllllllllIllIIlIIlIIllIIIII, final int llllllllllllllIllIIlIIlIIlIlllll, final int llllllllllllllIllIIlIIlIIlIllIIl, final int llllllllllllllIllIIlIIlIIlIllIII) {
        super(llllllllllllllIllIIlIIlIIllIIIII, llllllllllllllIllIIlIIlIIlIlllll, llllllllllllllIllIIlIIlIIlIllIIl, llllllllllllllIllIIlIIlIIlIllIII);
    }
    
    public JColor(final int llllllllllllllIllIIlIIlIIlllIlII, final boolean llllllllllllllIllIIlIIlIIlllIllI) {
        super(llllllllllllllIllIIlIIlIIlllIlII, llllllllllllllIllIIlIIlIIlllIllI);
    }
    
    public JColor(final Color llllllllllllllIllIIlIIlIIlIlIlII) {
        super(llllllllllllllIllIIlIIlIIlIlIlII.getRed(), llllllllllllllIllIIlIIlIIlIlIlII.getGreen(), llllllllllllllIllIIlIIlIIlIlIlII.getBlue(), llllllllllllllIllIIlIIlIIlIlIlII.getAlpha());
    }
}
