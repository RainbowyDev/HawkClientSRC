package net.minecraft.client.gui.achievement;

import net.minecraft.util.*;
import net.minecraft.stats.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.gui.*;

public class GuiAchievement extends Gui
{
    private /* synthetic */ boolean permanentNotification;
    private static final /* synthetic */ ResourceLocation achievementBg;
    private /* synthetic */ String achievementTitle;
    private /* synthetic */ int height;
    private /* synthetic */ int width;
    private /* synthetic */ String achievementDescription;
    private /* synthetic */ long notificationTime;
    private /* synthetic */ Achievement theAchievement;
    private /* synthetic */ RenderItem renderItem;
    private /* synthetic */ Minecraft mc;
    
    public void updateAchievementWindow() {
        if (this.theAchievement != null && this.notificationTime != 0L && Minecraft.getMinecraft().thePlayer != null) {
            double lllllllllllllllllIllllIlllIlIIIl = (Minecraft.getSystemTime() - this.notificationTime) / 3000.0;
            if (!this.permanentNotification) {
                if (lllllllllllllllllIllllIlllIlIIIl < 0.0 || lllllllllllllllllIllllIlllIlIIIl > 1.0) {
                    this.notificationTime = 0L;
                    return;
                }
            }
            else if (lllllllllllllllllIllllIlllIlIIIl > 0.5) {
                lllllllllllllllllIllllIlllIlIIIl = 0.5;
            }
            this.updateAchievementWindowScale();
            GlStateManager.disableDepth();
            GlStateManager.depthMask(false);
            double lllllllllllllllllIllllIlllIlIIII = lllllllllllllllllIllllIlllIlIIIl * 2.0;
            if (lllllllllllllllllIllllIlllIlIIII > 1.0) {
                lllllllllllllllllIllllIlllIlIIII = 2.0 - lllllllllllllllllIllllIlllIlIIII;
            }
            lllllllllllllllllIllllIlllIlIIII *= 4.0;
            lllllllllllllllllIllllIlllIlIIII = 1.0 - lllllllllllllllllIllllIlllIlIIII;
            if (lllllllllllllllllIllllIlllIlIIII < 0.0) {
                lllllllllllllllllIllllIlllIlIIII = 0.0;
            }
            lllllllllllllllllIllllIlllIlIIII *= lllllllllllllllllIllllIlllIlIIII;
            lllllllllllllllllIllllIlllIlIIII *= lllllllllllllllllIllllIlllIlIIII;
            final int lllllllllllllllllIllllIlllIIllll = this.width - 160;
            final int lllllllllllllllllIllllIlllIIlllI = 0 - (int)(lllllllllllllllllIllllIlllIlIIII * 36.0);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.func_179098_w();
            this.mc.getTextureManager().bindTexture(GuiAchievement.achievementBg);
            GlStateManager.disableLighting();
            this.drawTexturedModalRect(lllllllllllllllllIllllIlllIIllll, lllllllllllllllllIllllIlllIIlllI, 96, 202, 160, 32);
            if (this.permanentNotification) {
                this.mc.fontRendererObj.drawSplitString(this.achievementDescription, lllllllllllllllllIllllIlllIIllll + 30, lllllllllllllllllIllllIlllIIlllI + 7, 120, -1);
            }
            else {
                this.mc.fontRendererObj.drawString(this.achievementTitle, lllllllllllllllllIllllIlllIIllll + 30, lllllllllllllllllIllllIlllIIlllI + 7, -256);
                this.mc.fontRendererObj.drawString(this.achievementDescription, lllllllllllllllllIllllIlllIIllll + 30, lllllllllllllllllIllllIlllIIlllI + 18, -1);
            }
            RenderHelper.enableGUIStandardItemLighting();
            GlStateManager.disableLighting();
            GlStateManager.enableRescaleNormal();
            GlStateManager.enableColorMaterial();
            GlStateManager.enableLighting();
            this.renderItem.func_180450_b(this.theAchievement.theItemStack, lllllllllllllllllIllllIlllIIllll + 8, lllllllllllllllllIllllIlllIIlllI + 8);
            GlStateManager.disableLighting();
            GlStateManager.depthMask(true);
            GlStateManager.enableDepth();
        }
    }
    
    public void displayAchievement(final Achievement lllllllllllllllllIllllIllllIIlII) {
        this.achievementTitle = I18n.format("achievement.get", new Object[0]);
        this.achievementDescription = lllllllllllllllllIllllIllllIIlII.getStatName().getUnformattedText();
        this.notificationTime = Minecraft.getSystemTime();
        this.theAchievement = lllllllllllllllllIllllIllllIIlII;
        this.permanentNotification = false;
    }
    
    public GuiAchievement(final Minecraft lllllllllllllllllIllllIllllIllII) {
        this.mc = lllllllllllllllllIllllIllllIllII;
        this.renderItem = lllllllllllllllllIllllIllllIllII.getRenderItem();
    }
    
    static {
        __OBFID = "CL_00000721";
        achievementBg = new ResourceLocation("textures/gui/achievement/achievement_background.png");
    }
    
    private void updateAchievementWindowScale() {
        GlStateManager.viewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
        GlStateManager.matrixMode(5889);
        GlStateManager.loadIdentity();
        GlStateManager.matrixMode(5888);
        GlStateManager.loadIdentity();
        this.width = this.mc.displayWidth;
        this.height = this.mc.displayHeight;
        final ScaledResolution lllllllllllllllllIllllIlllIllIlI = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
        this.width = lllllllllllllllllIllllIlllIllIlI.getScaledWidth();
        this.height = lllllllllllllllllIllllIlllIllIlI.getScaledHeight();
        GlStateManager.clear(256);
        GlStateManager.matrixMode(5889);
        GlStateManager.loadIdentity();
        GlStateManager.ortho(0.0, this.width, this.height, 0.0, 1000.0, 3000.0);
        GlStateManager.matrixMode(5888);
        GlStateManager.loadIdentity();
        GlStateManager.translate(0.0f, 0.0f, -2000.0f);
    }
    
    public void displayUnformattedAchievement(final Achievement lllllllllllllllllIllllIlllIllllI) {
        this.achievementTitle = lllllllllllllllllIllllIlllIllllI.getStatName().getUnformattedText();
        this.achievementDescription = lllllllllllllllllIllllIlllIllllI.getDescription();
        this.notificationTime = Minecraft.getSystemTime() + 2500L;
        this.theAchievement = lllllllllllllllllIllllIlllIllllI;
        this.permanentNotification = true;
    }
    
    public void clearAchievements() {
        this.theAchievement = null;
        this.notificationTime = 0L;
    }
}
