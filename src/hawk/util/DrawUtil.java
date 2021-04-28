package hawk.util;

import net.minecraft.client.gui.*;
import org.lwjgl.opengl.*;

public class DrawUtil extends GuiScreen
{
    public static /* synthetic */ DrawUtil instance;
    
    public static void setColor(final int llllllllllllllIIIllIIlllIlIlIllI) {
        final float llllllllllllllIIIllIIlllIlIllIlI = (llllllllllllllIIIllIIlllIlIlIllI >> 24 & 0xFF) / 255.0f;
        final float llllllllllllllIIIllIIlllIlIllIIl = (llllllllllllllIIIllIIlllIlIlIllI >> 16 & 0xFF) / 255.0f;
        final float llllllllllllllIIIllIIlllIlIllIII = (llllllllllllllIIIllIIlllIlIlIllI >> 8 & 0xFF) / 255.0f;
        final float llllllllllllllIIIllIIlllIlIlIlll = (llllllllllllllIIIllIIlllIlIlIllI & 0xFF) / 255.0f;
        GL11.glColor4f(llllllllllllllIIIllIIlllIlIllIIl, llllllllllllllIIIllIIlllIlIllIII, llllllllllllllIIIllIIlllIlIlIlll, llllllllllllllIIIllIIlllIlIllIlI);
    }
    
    static {
        DrawUtil.instance = new DrawUtil();
    }
    
    public static void drawBorderedRoundedRect(final float llllllllllllllIIIllIIlllIlllllll, final float llllllllllllllIIIllIIlllIllllllI, final float llllllllllllllIIIllIIllllIIIIlII, final float llllllllllllllIIIllIIllllIIIIIll, final float llllllllllllllIIIllIIlllIllllIll, final int llllllllllllllIIIllIIllllIIIIIIl, final int llllllllllllllIIIllIIllllIIIIIII) {
        drawRoundedRect(llllllllllllllIIIllIIlllIlllllll, llllllllllllllIIIllIIlllIllllllI, llllllllllllllIIIllIIllllIIIIlII, llllllllllllllIIIllIIllllIIIIIll, llllllllllllllIIIllIIlllIllllIll, llllllllllllllIIIllIIllllIIIIIIl);
        drawRoundedRect(llllllllllllllIIIllIIlllIlllllll + 0.5f, llllllllllllllIIIllIIlllIllllllI + 0.5f, llllllllllllllIIIllIIllllIIIIlII - 0.5f, llllllllllllllIIIllIIllllIIIIIll - 0.5f, llllllllllllllIIIllIIlllIllllIll, llllllllllllllIIIllIIllllIIIIIII);
    }
    
    public static void drawBorderedRoundedRect(final float llllllllllllllIIIllIIlllIlllIIII, final float llllllllllllllIIIllIIlllIllIIlll, final float llllllllllllllIIIllIIlllIllIlllI, final float llllllllllllllIIIllIIlllIllIIlIl, final float llllllllllllllIIIllIIlllIllIllII, final float llllllllllllllIIIllIIlllIllIIIll, final int llllllllllllllIIIllIIlllIllIIIlI, final int llllllllllllllIIIllIIlllIllIlIIl) {
        drawRoundedRect(llllllllllllllIIIllIIlllIlllIIII, llllllllllllllIIIllIIlllIllIIlll, llllllllllllllIIIllIIlllIllIlllI, llllllllllllllIIIllIIlllIllIIlIl, llllllllllllllIIIllIIlllIllIllII, llllllllllllllIIIllIIlllIllIIIlI);
        drawRoundedRect(llllllllllllllIIIllIIlllIlllIIII + llllllllllllllIIIllIIlllIllIIIll, llllllllllllllIIIllIIlllIllIIlll + llllllllllllllIIIllIIlllIllIIIll, llllllllllllllIIIllIIlllIllIlllI - llllllllllllllIIIllIIlllIllIIIll, llllllllllllllIIIllIIlllIllIIlIl - llllllllllllllIIIllIIlllIllIIIll, llllllllllllllIIIllIIlllIllIllII, llllllllllllllIIIllIIlllIllIlIIl);
    }
    
    public static void drawRoundedRect(double llllllllllllllIIIllIIllllIIlIlII, double llllllllllllllIIIllIIllllIIlIIll, double llllllllllllllIIIllIIllllIIlIIlI, double llllllllllllllIIIllIIllllIIlIIIl, final double llllllllllllllIIIllIIllllIIlIlll, final int llllllllllllllIIIllIIllllIIIllll) {
        GL11.glPushAttrib(0);
        GL11.glScaled(0.5, 0.5, 0.5);
        llllllllllllllIIIllIIllllIIlIlII *= 2.0;
        llllllllllllllIIIllIIllllIIlIIll *= 2.0;
        llllllllllllllIIIllIIllllIIlIIlI *= (String)2.0;
        llllllllllllllIIIllIIllllIIlIIIl *= 2.0;
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        setColor(llllllllllllllIIIllIIllllIIIllll);
        GL11.glEnable(2848);
        GL11.glBegin(9);
        for (int llllllllllllllIIIllIIllllIIlIlIl = 0; llllllllllllllIIIllIIllllIIlIlIl <= 90; llllllllllllllIIIllIIllllIIlIlIl += 3) {
            GL11.glVertex2d(llllllllllllllIIIllIIllllIIlIlII + llllllllllllllIIIllIIllllIIlIlll + Math.sin(llllllllllllllIIIllIIllllIIlIlIl * 3.141592653589793 / 180.0) * llllllllllllllIIIllIIllllIIlIlll * -1.0, llllllllllllllIIIllIIllllIIlIIll + llllllllllllllIIIllIIllllIIlIlll + Math.cos(llllllllllllllIIIllIIllllIIlIlIl * 3.141592653589793 / 180.0) * llllllllllllllIIIllIIllllIIlIlll * -1.0);
        }
        for (int llllllllllllllIIIllIIllllIIlIlIl = 90; llllllllllllllIIIllIIllllIIlIlIl <= 180; llllllllllllllIIIllIIllllIIlIlIl += 3) {
            GL11.glVertex2d(llllllllllllllIIIllIIllllIIlIlII + llllllllllllllIIIllIIllllIIlIlll + Math.sin(llllllllllllllIIIllIIllllIIlIlIl * 3.141592653589793 / 180.0) * llllllllllllllIIIllIIllllIIlIlll * -1.0, llllllllllllllIIIllIIllllIIlIIIl - llllllllllllllIIIllIIllllIIlIlll + Math.cos(llllllllllllllIIIllIIllllIIlIlIl * 3.141592653589793 / 180.0) * llllllllllllllIIIllIIllllIIlIlll * -1.0);
        }
        for (int llllllllllllllIIIllIIllllIIlIlIl = 0; llllllllllllllIIIllIIllllIIlIlIl <= 90; llllllllllllllIIIllIIllllIIlIlIl += 3) {
            GL11.glVertex2d((double)(llllllllllllllIIIllIIllllIIlIIlI - llllllllllllllIIIllIIllllIIlIlll + Math.sin(llllllllllllllIIIllIIllllIIlIlIl * 3.141592653589793 / 180.0) * llllllllllllllIIIllIIllllIIlIlll), llllllllllllllIIIllIIllllIIlIIIl - llllllllllllllIIIllIIllllIIlIlll + Math.cos(llllllllllllllIIIllIIllllIIlIlIl * 3.141592653589793 / 180.0) * llllllllllllllIIIllIIllllIIlIlll);
        }
        for (int llllllllllllllIIIllIIllllIIlIlIl = 90; llllllllllllllIIIllIIllllIIlIlIl <= 180; llllllllllllllIIIllIIllllIIlIlIl += 3) {
            GL11.glVertex2d((double)(llllllllllllllIIIllIIllllIIlIIlI - llllllllllllllIIIllIIllllIIlIlll + Math.sin(llllllllllllllIIIllIIllllIIlIlIl * 3.141592653589793 / 180.0) * llllllllllllllIIIllIIllllIIlIlll), llllllllllllllIIIllIIllllIIlIIll + llllllllllllllIIIllIIllllIIlIlll + Math.cos(llllllllllllllIIIllIIllllIIlIlIl * 3.141592653589793 / 180.0) * llllllllllllllIIIllIIllllIIlIlll);
        }
        GL11.glEnd();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glDisable(2848);
        GL11.glDisable(3042);
        GL11.glEnable(3553);
        GL11.glScaled(2.0, 2.0, 2.0);
        GL11.glPopAttrib();
    }
}
