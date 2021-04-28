package optifine;

import net.minecraft.client.settings.*;
import java.util.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.*;

public class TooltipManager
{
    private /* synthetic */ int lastMouseX;
    private /* synthetic */ GuiScreen guiScreen;
    private /* synthetic */ long mouseStillTime;
    private /* synthetic */ int lastMouseY;
    
    private static String[] getTooltipLines(final String llllllllllllllllIlIIIIllIIllIIlI) {
        final ArrayList llllllllllllllllIlIIIIllIIllIIIl = new ArrayList();
        for (int llllllllllllllllIlIIIIllIIllIIII = 0; llllllllllllllllIlIIIIllIIllIIII < 10; ++llllllllllllllllIlIIIIllIIllIIII) {
            final String llllllllllllllllIlIIIIllIIlIllll = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIlIIIIllIIllIIlI)).append(".tooltip.").append(llllllllllllllllIlIIIIllIIllIIII + 1));
            final String llllllllllllllllIlIIIIllIIlIlllI = Lang.get(llllllllllllllllIlIIIIllIIlIllll, null);
            if (llllllllllllllllIlIIIIllIIlIlllI == null) {
                break;
            }
            llllllllllllllllIlIIIIllIIllIIIl.add(llllllllllllllllIlIIIIllIIlIlllI);
        }
        if (llllllllllllllllIlIIIIllIIllIIIl.size() <= 0) {
            return null;
        }
        final String[] llllllllllllllllIlIIIIllIIlIllIl = llllllllllllllllIlIIIIllIIllIIIl.toArray(new String[llllllllllllllllIlIIIIllIIllIIIl.size()]);
        return llllllllllllllllIlIIIIllIIlIllIl;
    }
    
    private static String[] getTooltipLines(final GameSettings.Options llllllllllllllllIlIIIIllIIlllIIl) {
        return getTooltipLines(llllllllllllllllIlIIIIllIIlllIIl.getEnumString());
    }
    
    public void drawTooltips(final int llllllllllllllllIlIIIIllIllIIIll, final int llllllllllllllllIlIIIIllIlllIIll, final List llllllllllllllllIlIIIIllIllIIIIl) {
        if (Math.abs(llllllllllllllllIlIIIIllIllIIIll - this.lastMouseX) <= 5 && Math.abs(llllllllllllllllIlIIIIllIlllIIll - this.lastMouseY) <= 5) {
            final short llllllllllllllllIlIIIIllIlllIIIl = 700;
            if (System.currentTimeMillis() >= this.mouseStillTime + llllllllllllllllIlIIIIllIlllIIIl) {
                final int llllllllllllllllIlIIIIllIlllIIII = this.guiScreen.width / 2 - 150;
                int llllllllllllllllIlIIIIllIllIllll = this.guiScreen.height / 6 - 7;
                if (llllllllllllllllIlIIIIllIlllIIll <= llllllllllllllllIlIIIIllIllIllll + 98) {
                    llllllllllllllllIlIIIIllIllIllll += 105;
                }
                final int llllllllllllllllIlIIIIllIllIlllI = llllllllllllllllIlIIIIllIlllIIII + 150 + 150;
                final int llllllllllllllllIlIIIIllIllIllIl = llllllllllllllllIlIIIIllIllIllll + 84 + 10;
                final GuiButton llllllllllllllllIlIIIIllIllIllII = this.getSelectedButton(llllllllllllllllIlIIIIllIllIIIll, llllllllllllllllIlIIIIllIlllIIll, llllllllllllllllIlIIIIllIllIIIIl);
                if (llllllllllllllllIlIIIIllIllIllII instanceof IOptionControl) {
                    final IOptionControl llllllllllllllllIlIIIIllIllIlIll = (IOptionControl)llllllllllllllllIlIIIIllIllIllII;
                    final GameSettings.Options llllllllllllllllIlIIIIllIllIlIlI = llllllllllllllllIlIIIIllIllIlIll.getOption();
                    final String[] llllllllllllllllIlIIIIllIllIlIIl = getTooltipLines(llllllllllllllllIlIIIIllIllIlIlI);
                    if (llllllllllllllllIlIIIIllIllIlIIl == null) {
                        return;
                    }
                    GuiVideoSettings.drawGradientRect(this.guiScreen, llllllllllllllllIlIIIIllIlllIIII, llllllllllllllllIlIIIIllIllIllll, llllllllllllllllIlIIIIllIllIlllI, llllllllllllllllIlIIIIllIllIllIl, -536870912, -536870912);
                    for (int llllllllllllllllIlIIIIllIllIlIII = 0; llllllllllllllllIlIIIIllIllIlIII < llllllllllllllllIlIIIIllIllIlIIl.length; ++llllllllllllllllIlIIIIllIllIlIII) {
                        final String llllllllllllllllIlIIIIllIllIIlll = llllllllllllllllIlIIIIllIllIlIIl[llllllllllllllllIlIIIIllIllIlIII];
                        int llllllllllllllllIlIIIIllIllIIllI = 14540253;
                        if (llllllllllllllllIlIIIIllIllIIlll.endsWith("!")) {
                            llllllllllllllllIlIIIIllIllIIllI = 16719904;
                        }
                        final FontRenderer llllllllllllllllIlIIIIllIllIIlIl = Minecraft.getMinecraft().fontRendererObj;
                        llllllllllllllllIlIIIIllIllIIlIl.drawStringWithShadow(llllllllllllllllIlIIIIllIllIIlll, (float)(llllllllllllllllIlIIIIllIlllIIII + 5), (float)(llllllllllllllllIlIIIIllIllIllll + 5 + llllllllllllllllIlIIIIllIllIlIII * 11), llllllllllllllllIlIIIIllIllIIllI);
                    }
                }
            }
        }
        else {
            this.lastMouseX = llllllllllllllllIlIIIIllIllIIIll;
            this.lastMouseY = llllllllllllllllIlIIIIllIlllIIll;
            this.mouseStillTime = System.currentTimeMillis();
        }
    }
    
    private GuiButton getSelectedButton(final int llllllllllllllllIlIIIIllIlIIIIlI, final int llllllllllllllllIlIIIIllIlIIIIIl, final List llllllllllllllllIlIIIIllIlIIIIII) {
        for (int llllllllllllllllIlIIIIllIlIIIlll = 0; llllllllllllllllIlIIIIllIlIIIlll < llllllllllllllllIlIIIIllIlIIIIII.size(); ++llllllllllllllllIlIIIIllIlIIIlll) {
            final GuiButton llllllllllllllllIlIIIIllIlIIIllI = llllllllllllllllIlIIIIllIlIIIIII.get(llllllllllllllllIlIIIIllIlIIIlll);
            final int llllllllllllllllIlIIIIllIlIIIlIl = GuiVideoSettings.getButtonWidth(llllllllllllllllIlIIIIllIlIIIllI);
            final int llllllllllllllllIlIIIIllIlIIIlII = GuiVideoSettings.getButtonHeight(llllllllllllllllIlIIIIllIlIIIllI);
            final boolean llllllllllllllllIlIIIIllIlIIIIll = llllllllllllllllIlIIIIllIlIIIIlI >= llllllllllllllllIlIIIIllIlIIIllI.xPosition && llllllllllllllllIlIIIIllIlIIIIIl >= llllllllllllllllIlIIIIllIlIIIllI.yPosition && llllllllllllllllIlIIIIllIlIIIIlI < llllllllllllllllIlIIIIllIlIIIllI.xPosition + llllllllllllllllIlIIIIllIlIIIlIl && llllllllllllllllIlIIIIllIlIIIIIl < llllllllllllllllIlIIIIllIlIIIllI.yPosition + llllllllllllllllIlIIIIllIlIIIlII;
            if (llllllllllllllllIlIIIIllIlIIIIll) {
                return llllllllllllllllIlIIIIllIlIIIllI;
            }
        }
        return null;
    }
    
    public TooltipManager(final GuiScreen llllllllllllllllIlIIIIlllIIIIlll) {
        this.guiScreen = null;
        this.lastMouseX = 0;
        this.lastMouseY = 0;
        this.mouseStillTime = 0L;
        this.guiScreen = llllllllllllllllIlIIIIlllIIIIlll;
    }
}
