package hawk.ui;

import java.awt.*;
import net.minecraft.client.*;
import hawk.*;
import net.minecraft.entity.*;
import net.minecraft.client.gui.inventory.*;
import hawk.modules.*;
import java.util.*;
import hawk.util.*;
import hawk.events.listeners.*;
import hawk.events.*;
import net.minecraft.client.gui.*;

public class HUD
{
    private /* synthetic */ Color healthColor;
    /* synthetic */ Timer timer;
    private /* synthetic */ int healthRect;
    public /* synthetic */ Minecraft mc;
    
    private int getAbsoluteX() {
        return 410;
    }
    
    private int getAbsoluteY() {
        return 300;
    }
    
    private int getWinColor() {
        final EntityLivingBase llllllllllllllIIllIIlIlIIllllIll = Client.killAura.target;
        if (llllllllllllllIIllIIlIlIIllllIll.getHealth() > this.mc.thePlayer.getHealth()) {
            return new Color(255, 0, 0, 255).getRGB();
        }
        if (llllllllllllllIIllIIlIlIIllllIll.getHealth() == this.mc.thePlayer.getHealth() && llllllllllllllIIllIIlIlIIllllIll.getHealth() != 20.0f && this.mc.thePlayer.getHealth() != 20.0f) {
            return new Color(255, 255, 0, 255).getRGB();
        }
        if (llllllllllllllIIllIIlIlIIllllIll.getHealth() < this.mc.thePlayer.getHealth()) {
            return new Color(0, 255, 0, 255).getRGB();
        }
        if (llllllllllllllIIllIIlIlIIllllIll.getHealth() == 0.0f) {
            return new Color(0, 255, 0, 255).getRGB();
        }
        if (this.mc.thePlayer.getHealth() == 0.0f) {
            return new Color(255, 0, 0, 255).getRGB();
        }
        if (llllllllllllllIIllIIlIlIIllllIll.getHealth() == 20.0f && this.mc.thePlayer.getHealth() == 20.0f) {
            return new Color(0, 188, 255, 255).getRGB();
        }
        return new Color(0, 0, 255, 255).getRGB();
    }
    
    public void renderTargetHud() {
        if (Client.killAura.target instanceof EntityLivingBase && !Client.killAura.target.isDead && this.mc.thePlayer.getDistanceToEntity(Client.killAura.target) < Client.killAura.range.getValue() + 2.0 && Client.killAura.isEnabled()) {
            final EntityLivingBase llllllllllllllIIllIIlIlIlIIIlIIl = Client.killAura.target;
            final String llllllllllllllIIllIIlIlIlIIIlIII = llllllllllllllIIllIIlIlIlIIIlIIl.getName();
            Gui.drawRect(this.getAbsoluteX(), this.getAbsoluteY(), this.getAbsoluteX() + this.getWidth(), this.getAbsoluteY() + this.getHeight(), -1879048192);
            this.mc.fontRendererObj.drawString(llllllllllllllIIllIIlIlIlIIIlIII, this.getAbsoluteX() + 31, this.getAbsoluteY() + 8, -1);
            this.mc.fontRendererObj.drawString(String.valueOf(new StringBuilder(String.valueOf((int)llllllllllllllIIllIIlIlIlIIIlIIl.getHealth())).append(" \u2764")), this.getAbsoluteX() + 31, this.getAbsoluteY() + 20, new Color(255, 255, 255, 255).getRGB());
            GuiInventory.drawEntityOnScreen(this.getAbsoluteX() + 12, this.getAbsoluteY() + 45, 25, -35.0f, -5.0f, llllllllllllllIIllIIlIlIlIIIlIIl);
            this.mc.fontRendererObj.drawString(this.getWin(), this.getAbsoluteX() + 59, this.getAbsoluteY() + 20, this.getWinColor());
            this.drawEntityHealth();
        }
    }
    
    public int getHeight() {
        return 52;
    }
    
    private void drawEntityHealth() {
        final EntityLivingBase llllllllllllllIIllIIlIlIIlllIlIl = Client.killAura.target;
        if (llllllllllllllIIllIIlIlIIlllIlIl.getHealth() >= llllllllllllllIIllIIlIlIIlllIlIl.getMaxHealth()) {
            this.healthColor = new Color(0, 255, 0, 255);
            this.healthRect = 154;
        }
        else if (llllllllllllllIIllIIlIlIIlllIlIl.getHealth() >= 18.0f) {
            this.healthColor = new Color(255, 242, 0, 255);
            this.healthRect = 132;
        }
        else if (llllllllllllllIIllIIlIlIIlllIlIl.getHealth() >= 13.0f) {
            this.healthColor = new Color(173, 117, 3, 255);
            this.healthRect = 110;
        }
        else if (llllllllllllllIIllIIlIlIIlllIlIl.getHealth() >= 10.0f) {
            this.healthColor = new Color(173, 80, 3, 255);
            this.healthRect = 88;
        }
        else if (llllllllllllllIIllIIlIlIIlllIlIl.getHealth() >= 7.0f) {
            this.healthColor = new Color(173, 80, 3, 255);
            this.healthRect = 66;
        }
        else if (llllllllllllllIIllIIlIlIIlllIlIl.getHealth() >= 5.0f) {
            this.healthColor = new Color(184, 43, 0, 255);
            this.healthRect = 44;
        }
        else if (llllllllllllllIIllIIlIlIIlllIlIl.getHealth() <= 3.0f) {
            this.healthColor = new Color(255, 0, 0, 255);
            this.healthRect = 22;
        }
        Gui.drawRect(this.getAbsoluteX(), this.getAbsoluteY() + 52, this.getAbsoluteX() + this.healthRect, this.getAbsoluteY() + 50, this.healthColor.getRGB());
    }
    
    public void draw() {
        final ScaledResolution llllllllllllllIIllIIlIlIlIlIlIII = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
        final FontRenderer llllllllllllllIIllIIlIlIlIlIIlll = this.mc.fontRendererObj;
        final float llllllllllllllIIllIIlIlIlIlIIllI = System.currentTimeMillis() % 3500L / 3500.0f;
        int llllllllllllllIIllIIlIlIlIlIIlIl = 0;
        int llllllllllllllIIllIIlIlIlIlIIlII = 1610612736;
        Collections.sort(Client.modules, new ModuleComparator());
        Formatter llllllllllllllIIllIIlIlIlIlIIIll = new Formatter();
        final Calendar llllllllllllllIIllIIlIlIlIlIIIlI = Calendar.getInstance();
        llllllllllllllIIllIIlIlIlIlIIIll = new Formatter();
        llllllllllllllIIllIIlIlIlIlIIIll.format("%tl:%tM", llllllllllllllIIllIIlIlIlIlIIIlI, llllllllllllllIIllIIlIlIlIlIIIlI);
        for (int llllllllllllllIIllIIlIlIlIlIIIIl = 0; llllllllllllllIIllIIlIlIlIlIIIIl < 91; ++llllllllllllllIIllIIlIlIlIlIIIIl) {
            Gui.drawRect(6 + llllllllllllllIIllIIlIlIlIlIIIIl, 4.0, 7 + llllllllllllllIIllIIlIlIlIlIIIIl, 6.0, ColorUtil.getRainbow(4.0f, 0.8f, 1.0f, (long)(50.0 * (llllllllllllllIIllIIlIlIlIlIIIIl * 0.2))));
        }
        Gui.drawRect(6.0, 6.0, 97.0, 18.0, 1879048192);
        llllllllllllllIIllIIlIlIlIlIIlll.drawStringWithShadow("H", 8.0, 8.0, ColorUtil.getRainbow(4.0f, 0.8f, 1.0f, 1L));
        llllllllllllllIIllIIlIlIlIlIIlll.drawStringWithShadow(String.valueOf(new StringBuilder("awk Client (").append(llllllllllllllIIllIIlIlIlIlIIIll).append(")")), 14.0, 8.0, -1);
        int llllllllllllllIIllIIlIlIlIlIIIII = 0;
        llllllllllllllIIllIIlIlIlIlIIlll.drawStringWithShadow(String.valueOf(new StringBuilder("[ FPS : ").append(Minecraft.debugFPS).append(" ]")), 6.0, 102.0, -1);
        final float llllllllllllllIIllIIlIlIlIIlllll = (float)(MathUtils.square(this.mc.thePlayer.motionX) + MathUtils.square(this.mc.thePlayer.motionZ));
        final float llllllllllllllIIllIIlIlIlIIllllI = (float)MathUtils.round(Math.sqrt(llllllllllllllIIllIIlIlIlIIlllll) * 20.0 * this.mc.timer.timerSpeed, 2.0);
        llllllllllllllIIllIIlIlIlIlIIlll.drawStringWithShadow(String.valueOf(new StringBuilder("[ BPS : ").append(llllllllllllllIIllIIlIlIlIIllllI).append(" ]")), 6.0, 102 + (this.mc.fontRendererObj.FONT_HEIGHT + 0), -1);
        GuiInventory.drawEntityOnScreen(30, 225, 50, 0.0f, 0.0f, this.mc.thePlayer);
        Gui.drawRect(5.0, 125.0, 55.0, 235.0, -1879048192);
        for (final Module llllllllllllllIIllIIlIlIlIIlllIl : Client.modules) {
            if (llllllllllllllIIllIIlIlIlIIlllIl.toggled && !llllllllllllllIIllIIlIlIlIIlllIl.name.equals("TabGUI")) {
                if (llllllllllllllIIllIIlIlIlIIlllIl.name.equals("HeadRotations")) {
                    continue;
                }
                final double llllllllllllllIIllIIlIlIlIIlllII = llllllllllllllIIllIIlIlIlIlIIIII * (llllllllllllllIIllIIlIlIlIlIIlll.FONT_HEIGHT + 6);
                if (Client.arraylist.Color.is("Colorful")) {
                    llllllllllllllIIllIIlIlIlIlIIlIl = Color.HSBtoRGB(llllllllllllllIIllIIlIlIlIlIIllI, 1.0f, 1.0f);
                }
                if (Client.arraylist.Color.is("Red")) {
                    llllllllllllllIIllIIlIlIlIlIIlIl = -6746096;
                }
                if (Client.arraylist.Color.is("Blue")) {
                    llllllllllllllIIllIIlIlIlIlIIlIl = -16756481;
                }
                if (Client.arraylist.Color.is("Orange")) {
                    llllllllllllllIIllIIlIlIlIlIIlIl = -1350377;
                }
                if (Client.arraylist.Color.is("Green")) {
                    llllllllllllllIIllIIlIlIlIlIIlIl = -13571305;
                }
                if (Client.arraylist.Color.is("Green")) {
                    llllllllllllllIIllIIlIlIlIlIIlIl = -13571305;
                }
                if (Client.arraylist.Color.is("Black")) {
                    llllllllllllllIIllIIlIlIlIlIIlIl = -1;
                }
                if (Client.arraylist.Color.is("Discord")) {
                    llllllllllllllIIllIIlIlIlIlIIlIl = new Color(114, 137, 218, 255).getRGB();
                    llllllllllllllIIllIIlIlIlIlIIlII = new Color(47, 49, 54, 255).getRGB();
                }
                if (Client.arraylist.Color.is("White")) {
                    llllllllllllllIIllIIlIlIlIlIIlIl = -1;
                }
                Gui.drawRect(llllllllllllllIIllIIlIlIlIlIlIII.getScaledWidth() - 3, llllllllllllllIIllIIlIlIlIIlllII, llllllllllllllIIllIIlIlIlIlIlIII.getScaledWidth() + this.mc.fontRendererObj.getStringWidth(llllllllllllllIIllIIlIlIlIIlllIl.getDisplayname()), 6 + this.mc.fontRendererObj.FONT_HEIGHT + llllllllllllllIIllIIlIlIlIIlllII, ColorUtil.getRainbow(4.0f, 0.8f, 1.0f, llllllllllllllIIllIIlIlIlIlIIIII * 20));
                llllllllllllllIIllIIlIlIlIlIIlll.drawStringWithShadow(llllllllllllllIIllIIlIlIlIIlllIl.getDisplayname(), llllllllllllllIIllIIlIlIlIlIlIII.getScaledWidth() - llllllllllllllIIllIIlIlIlIlIIlll.getStringWidth(llllllllllllllIIllIIlIlIlIIlllIl.getDisplayname()) - 6, 4.0 + llllllllllllllIIllIIlIlIlIIlllII, ColorUtil.getRainbow(4.0f, 0.8f, 1.0f, llllllllllllllIIllIIlIlIlIlIIIII * 40));
                ++llllllllllllllIIllIIlIlIlIlIIIII;
            }
        }
        Client.onEvent(new EventRenderGUI());
    }
    
    public int getWidth() {
        return 154;
    }
    
    public HUD() {
        this.timer = new Timer();
        this.mc = Minecraft.getMinecraft();
    }
    
    private String getWin() {
        final EntityLivingBase llllllllllllllIIllIIlIlIlIIIIIIl = Client.killAura.target;
        if (llllllllllllllIIllIIlIlIlIIIIIIl.getHealth() > this.mc.thePlayer.getHealth()) {
            return "You are Losing";
        }
        if (llllllllllllllIIllIIlIlIlIIIIIIl.getHealth() == this.mc.thePlayer.getHealth() && llllllllllllllIIllIIlIlIlIIIIIIl.getHealth() != 20.0f && this.mc.thePlayer.getHealth() != 20.0f) {
            return "You may win";
        }
        if (llllllllllllllIIllIIlIlIlIIIIIIl.getHealth() < this.mc.thePlayer.getHealth()) {
            return "You are Winning";
        }
        if (llllllllllllllIIllIIlIlIlIIIIIIl.getHealth() == 0.0f) {
            return "You won!";
        }
        if (this.mc.thePlayer.getHealth() == 0.0f) {
            return "You lost!";
        }
        if (llllllllllllllIIllIIlIlIlIIIIIIl.getHealth() == 20.0f && this.mc.thePlayer.getHealth() == 20.0f) {
            return "Not fighting";
        }
        return "You May Win";
    }
    
    public static class ModuleComparator implements Comparator<Module>
    {
        @Override
        public int compare(final Module lllllllllllllllIlIlIIlIlIIllIIll, final Module lllllllllllllllIlIlIIlIlIIllIIlI) {
            if (Minecraft.getMinecraft().fontRendererObj.getStringWidth(lllllllllllllllIlIlIIlIlIIllIIll.getDisplayname()) > Minecraft.getMinecraft().fontRendererObj.getStringWidth(lllllllllllllllIlIlIIlIlIIllIIlI.getDisplayname())) {
                return -1;
            }
            if (Minecraft.getMinecraft().fontRendererObj.getStringWidth(lllllllllllllllIlIlIIlIlIIllIIll.getDisplayname()) < Minecraft.getMinecraft().fontRendererObj.getStringWidth(lllllllllllllllIlIlIIlIlIIllIIlI.getDisplayname())) {
                return 1;
            }
            return 0;
        }
    }
}
