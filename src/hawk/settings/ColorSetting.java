package hawk.settings;

import hawk.util.*;
import hawk.modules.*;
import java.awt.*;

public class ColorSetting extends Setting implements com.lukflug.panelstudio.settings.ColorSetting
{
    private /* synthetic */ JColor value;
    private /* synthetic */ boolean rainbow;
    
    @Override
    public void setValue(final Color lllllllllllllllIlIlIlIlIIlllllII) {
        this.setValue(this.getRainbow(), new JColor(lllllllllllllllIlIlIlIlIIlllllII));
    }
    
    @Override
    public JColor getValue() {
        if (this.rainbow) {
            return JColor.fromHSB(System.currentTimeMillis() % 7200L / 7200.0f, 0.5f, 1.0f);
        }
        return this.value;
    }
    
    @Override
    public void setRainbow(final boolean lllllllllllllllIlIlIlIlIIlllIlII) {
        this.rainbow = lllllllllllllllIlIlIlIlIIlllIlII;
    }
    
    public long toInteger() {
        return this.value.getRGB() & -1;
    }
    
    public static int rainbow(final int lllllllllllllllIlIlIlIlIlIIllIIl) {
        double lllllllllllllllIlIlIlIlIlIIllIlI = Math.ceil((System.currentTimeMillis() + lllllllllllllllIlIlIlIlIlIIllIIl) / 20.0);
        lllllllllllllllIlIlIlIlIlIIllIlI %= 360.0;
        return Color.getHSBColor((float)(lllllllllllllllIlIlIlIlIlIIllIlI / 360.0), 0.5f, 1.0f).getRGB();
    }
    
    @Override
    public boolean getRainbow() {
        return this.rainbow;
    }
    
    public void fromInteger(final long lllllllllllllllIlIlIlIlIlIIIIllI) {
        this.value = new JColor(Math.toIntExact(lllllllllllllllIlIlIlIlIlIIIIllI & -1L), true);
    }
    
    @Override
    public JColor getColor() {
        return this.value;
    }
    
    public void setValue(final boolean lllllllllllllllIlIlIlIlIlIIlIIll, final JColor lllllllllllllllIlIlIlIlIlIIlIIlI) {
        this.rainbow = lllllllllllllllIlIlIlIlIlIIlIIll;
        this.value = lllllllllllllllIlIlIlIlIlIIlIIlI;
    }
    
    public ColorSetting(final String lllllllllllllllIlIlIlIlIlIlIIIlI, final JColor lllllllllllllllIlIlIlIlIlIlIIIIl) {
        this.name = lllllllllllllllIlIlIlIlIlIlIIIlI;
        this.value = lllllllllllllllIlIlIlIlIlIlIIIIl;
    }
}
