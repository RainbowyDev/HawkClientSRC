package net.minecraft.client.gui.achievement;

import net.minecraft.client.resources.*;
import net.minecraft.client.*;
import org.lwjgl.input.*;
import net.minecraft.block.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.stats.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.*;
import java.io.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import net.minecraft.client.gui.*;

public class GuiAchievements extends GuiScreen implements IProgressMeter
{
    protected /* synthetic */ int field_146555_f;
    private static final /* synthetic */ int field_146559_A;
    protected /* synthetic */ double field_146569_s;
    private /* synthetic */ int field_146554_D;
    protected /* synthetic */ int field_146557_g;
    private static final /* synthetic */ int field_146572_y;
    private static final /* synthetic */ ResourceLocation field_146561_C;
    private static final /* synthetic */ int field_146560_B;
    protected /* synthetic */ double field_146567_u;
    protected /* synthetic */ float field_146570_r;
    protected /* synthetic */ GuiScreen parentScreen;
    private /* synthetic */ boolean loadingAchievements;
    protected /* synthetic */ int field_146563_h;
    private static final /* synthetic */ int field_146571_z;
    protected /* synthetic */ double field_146573_x;
    protected /* synthetic */ double field_146566_v;
    protected /* synthetic */ double field_146568_t;
    protected /* synthetic */ int field_146564_i;
    private /* synthetic */ StatFileWriter statFileWriter;
    protected /* synthetic */ double field_146565_w;
    
    @Override
    public void drawScreen(final int lIlIlIlll, final int lIlIIIlll, final float lIlIIIllI) {
        if (this.loadingAchievements) {
            this.drawDefaultBackground();
            this.drawCenteredString(this.fontRendererObj, I18n.format("multiplayer.downloadingStats", new Object[0]), this.width / 2, this.height / 2, 16777215);
            this.drawCenteredString(this.fontRendererObj, GuiAchievements.lanSearchStates[(int)(Minecraft.getSystemTime() / 150L % GuiAchievements.lanSearchStates.length)], this.width / 2, this.height / 2 + this.fontRendererObj.FONT_HEIGHT * 2, 16777215);
        }
        else {
            if (Mouse.isButtonDown(0)) {
                final int lIlIlIlII = (this.width - this.field_146555_f) / 2;
                final int lIlIlIIlI = (this.height - this.field_146557_g) / 2;
                final int lIlIlIIIl = lIlIlIlII + 8;
                final int lIlIlIIII = lIlIlIIlI + 17;
                if ((this.field_146554_D == 0 || this.field_146554_D == 1) && lIlIlIlll >= lIlIlIIIl && lIlIlIlll < lIlIlIIIl + 224 && lIlIIIlll >= lIlIlIIII && lIlIIIlll < lIlIlIIII + 155) {
                    if (this.field_146554_D == 0) {
                        this.field_146554_D = 1;
                    }
                    else {
                        this.field_146567_u -= (lIlIlIlll - this.field_146563_h) * this.field_146570_r;
                        this.field_146566_v -= (lIlIIIlll - this.field_146564_i) * this.field_146570_r;
                        final double field_146567_u = this.field_146567_u;
                        this.field_146569_s = field_146567_u;
                        this.field_146565_w = field_146567_u;
                        final double field_146566_v = this.field_146566_v;
                        this.field_146568_t = field_146566_v;
                        this.field_146573_x = field_146566_v;
                    }
                    this.field_146563_h = lIlIlIlll;
                    this.field_146564_i = lIlIIIlll;
                }
            }
            else {
                this.field_146554_D = 0;
            }
            final int lIlIlIIll = Mouse.getDWheel();
            final float lIlIIllll = this.field_146570_r;
            if (lIlIlIIll < 0) {
                this.field_146570_r += 0.25f;
            }
            else if (lIlIlIIll > 0) {
                this.field_146570_r -= 0.25f;
            }
            this.field_146570_r = MathHelper.clamp_float(this.field_146570_r, 1.0f, 2.0f);
            if (this.field_146570_r != lIlIIllll) {
                final float lIlIIlllI = lIlIIllll - this.field_146570_r;
                final float lIlIIllIl = lIlIIllll * this.field_146555_f;
                final float lIlIIllII = lIlIIllll * this.field_146557_g;
                final float lIlIIlIll = this.field_146570_r * this.field_146555_f;
                final float lIlIIlIlI = this.field_146570_r * this.field_146557_g;
                this.field_146567_u -= (lIlIIlIll - lIlIIllIl) * 0.5f;
                this.field_146566_v -= (lIlIIlIlI - lIlIIllII) * 0.5f;
                final double field_146567_u2 = this.field_146567_u;
                this.field_146569_s = field_146567_u2;
                this.field_146565_w = field_146567_u2;
                final double field_146566_v2 = this.field_146566_v;
                this.field_146568_t = field_146566_v2;
                this.field_146573_x = field_146566_v2;
            }
            if (this.field_146565_w < GuiAchievements.field_146572_y) {
                this.field_146565_w = GuiAchievements.field_146572_y;
            }
            if (this.field_146573_x < GuiAchievements.field_146571_z) {
                this.field_146573_x = GuiAchievements.field_146571_z;
            }
            if (this.field_146565_w >= GuiAchievements.field_146559_A) {
                this.field_146565_w = GuiAchievements.field_146559_A - 1;
            }
            if (this.field_146573_x >= GuiAchievements.field_146560_B) {
                this.field_146573_x = GuiAchievements.field_146560_B - 1;
            }
            this.drawDefaultBackground();
            this.drawAchievementScreen(lIlIlIlll, lIlIIIlll, lIlIIIllI);
            GlStateManager.disableLighting();
            GlStateManager.disableDepth();
            this.drawTitle();
            GlStateManager.enableLighting();
            GlStateManager.enableDepth();
        }
    }
    
    @Override
    public void doneLoading() {
        if (this.loadingAchievements) {
            this.loadingAchievements = false;
        }
    }
    
    private TextureAtlasSprite func_175371_a(final Block lIIllllI) {
        return Minecraft.getMinecraft().getBlockRendererDispatcher().func_175023_a().func_178122_a(lIIllllI.getDefaultState());
    }
    
    protected void drawAchievementScreen(final int llIIIlII, final int lIIIIIIlI, final float llIIIIlI) {
        int lIIIIIIII = MathHelper.floor_double(this.field_146569_s + (this.field_146567_u - this.field_146569_s) * llIIIIlI);
        int llllllll = MathHelper.floor_double(this.field_146568_t + (this.field_146566_v - this.field_146568_t) * llIIIIlI);
        if (lIIIIIIII < GuiAchievements.field_146572_y) {
            lIIIIIIII = GuiAchievements.field_146572_y;
        }
        if (llllllll < GuiAchievements.field_146571_z) {
            llllllll = GuiAchievements.field_146571_z;
        }
        if (lIIIIIIII >= GuiAchievements.field_146559_A) {
            lIIIIIIII = GuiAchievements.field_146559_A - 1;
        }
        if (llllllll >= GuiAchievements.field_146560_B) {
            llllllll = GuiAchievements.field_146560_B - 1;
        }
        final int lllllllI = (this.width - this.field_146555_f) / 2;
        final int llllllIl = (this.height - this.field_146557_g) / 2;
        final int llllllII = lllllllI + 16;
        final int lllllIll = llllllIl + 17;
        this.zLevel = 0.0f;
        GlStateManager.depthFunc(518);
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)llllllII, (float)lllllIll, -200.0f);
        GlStateManager.scale(1.0f / this.field_146570_r, 1.0f / this.field_146570_r, 0.0f);
        GlStateManager.func_179098_w();
        GlStateManager.disableLighting();
        GlStateManager.enableRescaleNormal();
        GlStateManager.enableColorMaterial();
        final int lllllIlI = lIIIIIIII + 288 >> 4;
        final int lllllIIl = llllllll + 288 >> 4;
        final int lllllIII = (lIIIIIIII + 288) % 16;
        final int llllIlll = (llllllll + 288) % 16;
        final boolean llllIllI = true;
        final boolean llllIlIl = true;
        final boolean llllIlII = true;
        final boolean llllIIll = true;
        final boolean llllIIlI = true;
        final Random llllIIIl = new Random();
        final float llllIIII = 16.0f / this.field_146570_r;
        final float lllIllll = 16.0f / this.field_146570_r;
        for (int lllIlllI = 0; lllIlllI * llllIIII - llllIlll < 155.0f; ++lllIlllI) {
            final float lllIllIl = 0.6f - (lllllIIl + lllIlllI) / 25.0f * 0.3f;
            GlStateManager.color(lllIllIl, lllIllIl, lllIllIl, 1.0f);
            for (int lllIlIll = 0; lllIlIll * lllIllll - lllllIII < 224.0f; ++lllIlIll) {
                llllIIIl.setSeed(this.mc.getSession().getPlayerID().hashCode() + lllllIlI + lllIlIll + (lllllIIl + lllIlllI) * 16);
                final int lllIlIIl = llllIIIl.nextInt(1 + lllllIIl + lllIlllI) + (lllllIIl + lllIlllI) / 2;
                TextureAtlasSprite lllIIllI = this.func_175371_a(Blocks.sand);
                if (lllIlIIl <= 37 && lllllIIl + lllIlllI != 35) {
                    if (lllIlIIl == 22) {
                        if (llllIIIl.nextInt(2) == 0) {
                            lllIIllI = this.func_175371_a(Blocks.diamond_ore);
                        }
                        else {
                            lllIIllI = this.func_175371_a(Blocks.redstone_ore);
                        }
                    }
                    else if (lllIlIIl == 10) {
                        lllIIllI = this.func_175371_a(Blocks.iron_ore);
                    }
                    else if (lllIlIIl == 8) {
                        lllIIllI = this.func_175371_a(Blocks.coal_ore);
                    }
                    else if (lllIlIIl > 4) {
                        lllIIllI = this.func_175371_a(Blocks.stone);
                    }
                    else if (lllIlIIl > 0) {
                        lllIIllI = this.func_175371_a(Blocks.dirt);
                    }
                }
                else {
                    final Block lllIIlIl = Blocks.bedrock;
                    lllIIllI = this.func_175371_a(lllIIlIl);
                }
                this.mc.getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
                this.func_175175_a(lllIlIll * 16 - lllllIII, lllIlllI * 16 - llllIlll, lllIIllI, 16, 16);
            }
        }
        GlStateManager.enableDepth();
        GlStateManager.depthFunc(515);
        this.mc.getTextureManager().bindTexture(GuiAchievements.field_146561_C);
        for (int lllIlllI = 0; lllIlllI < AchievementList.achievementList.size(); ++lllIlllI) {
            final Achievement llIllIll = AchievementList.achievementList.get(lllIlllI);
            if (llIllIll.parentAchievement != null) {
                final int lllIlIlI = llIllIll.displayColumn * 24 - lIIIIIIII + 11;
                final int lllIlIII = llIllIll.displayRow * 24 - llllllll + 11;
                final int llIllIlI = llIllIll.parentAchievement.displayColumn * 24 - lIIIIIIII + 11;
                final int llIllllI = llIllIll.parentAchievement.displayRow * 24 - llllllll + 11;
                final boolean llIllIIl = this.statFileWriter.hasAchievementUnlocked(llIllIll);
                final boolean llIllIII = this.statFileWriter.canUnlockAchievement(llIllIll);
                final int lllIIlII = this.statFileWriter.func_150874_c(llIllIll);
                if (lllIIlII <= 4) {
                    int lllIIIII = -16777216;
                    if (llIllIIl) {
                        lllIIIII = -6250336;
                    }
                    else if (llIllIII) {
                        lllIIIII = -16711936;
                    }
                    this.drawHorizontalLine(lllIlIlI, llIllIlI, lllIlIII, lllIIIII);
                    this.drawVerticalLine(llIllIlI, lllIlIII, llIllllI, lllIIIII);
                    if (lllIlIlI > llIllIlI) {
                        this.drawTexturedModalRect(lllIlIlI - 11 - 7, lllIlIII - 5, 114, 234, 7, 11);
                    }
                    else if (lllIlIlI < llIllIlI) {
                        this.drawTexturedModalRect(lllIlIlI + 11, lllIlIII - 5, 107, 234, 7, 11);
                    }
                    else if (lllIlIII > llIllllI) {
                        this.drawTexturedModalRect(lllIlIlI - 5, lllIlIII - 11 - 7, 96, 234, 11, 7);
                    }
                    else if (lllIlIII < llIllllI) {
                        this.drawTexturedModalRect(lllIlIlI - 5, lllIlIII + 11, 96, 241, 11, 7);
                    }
                }
            }
        }
        Achievement llIlIlll = null;
        final float lllIllII = (llIIIlII - llllllII) * this.field_146570_r;
        final float llIlIllI = (lIIIIIIlI - lllllIll) * this.field_146570_r;
        RenderHelper.enableGUIStandardItemLighting();
        GlStateManager.disableLighting();
        GlStateManager.enableRescaleNormal();
        GlStateManager.enableColorMaterial();
        for (int lllIIlll = 0; lllIIlll < AchievementList.achievementList.size(); ++lllIIlll) {
            final Achievement llIlIIIl = AchievementList.achievementList.get(lllIIlll);
            final int llIlllIl = llIlIIIl.displayColumn * 24 - lIIIIIIII;
            final int llIlIlIl = llIlIIIl.displayRow * 24 - llllllll;
            if (llIlllIl >= -24 && llIlIlIl >= -24 && llIlllIl <= 224.0f * this.field_146570_r && llIlIlIl <= 155.0f * this.field_146570_r) {
                final int llIlIIll = this.statFileWriter.func_150874_c(llIlIIIl);
                if (this.statFileWriter.hasAchievementUnlocked(llIlIIIl)) {
                    final float llIlIIII = 0.75f;
                    GlStateManager.color(llIlIIII, llIlIIII, llIlIIII, 1.0f);
                }
                else if (this.statFileWriter.canUnlockAchievement(llIlIIIl)) {
                    final float llIIllll = 1.0f;
                    GlStateManager.color(llIIllll, llIIllll, llIIllll, 1.0f);
                }
                else if (llIlIIll < 3) {
                    final float llIIlllI = 0.3f;
                    GlStateManager.color(llIIlllI, llIIlllI, llIIlllI, 1.0f);
                }
                else if (llIlIIll == 3) {
                    final float llIIllIl = 0.2f;
                    GlStateManager.color(llIIllIl, llIIllIl, llIIllIl, 1.0f);
                }
                else {
                    if (llIlIIll != 4) {
                        continue;
                    }
                    final float llIIllII = 0.1f;
                    GlStateManager.color(llIIllII, llIIllII, llIIllII, 1.0f);
                }
                this.mc.getTextureManager().bindTexture(GuiAchievements.field_146561_C);
                if (llIlIIIl.getSpecial()) {
                    this.drawTexturedModalRect(llIlllIl - 2, llIlIlIl - 2, 26, 202, 26, 26);
                }
                else {
                    this.drawTexturedModalRect(llIlllIl - 2, llIlIlIl - 2, 0, 202, 26, 26);
                }
                if (!this.statFileWriter.canUnlockAchievement(llIlIIIl)) {
                    final float llIIllII = 0.1f;
                    GlStateManager.color(llIIllII, llIIllII, llIIllII, 1.0f);
                    this.itemRender.func_175039_a(false);
                }
                GlStateManager.enableLighting();
                GlStateManager.enableCull();
                this.itemRender.func_180450_b(llIlIIIl.theItemStack, llIlllIl + 3, llIlIlIl + 3);
                GlStateManager.blendFunc(770, 771);
                GlStateManager.disableLighting();
                if (!this.statFileWriter.canUnlockAchievement(llIlIIIl)) {
                    this.itemRender.func_175039_a(true);
                }
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                if (lllIllII >= llIlllIl && lllIllII <= llIlllIl + 22 && llIlIllI >= llIlIlIl && llIlIllI <= llIlIlIl + 22) {
                    llIlIlll = llIlIIIl;
                }
            }
        }
        GlStateManager.disableDepth();
        GlStateManager.enableBlend();
        GlStateManager.popMatrix();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiAchievements.field_146561_C);
        this.drawTexturedModalRect(lllllllI, llllllIl, 0, 0, this.field_146555_f, this.field_146557_g);
        this.zLevel = 0.0f;
        GlStateManager.depthFunc(515);
        GlStateManager.disableDepth();
        GlStateManager.func_179098_w();
        super.drawScreen(llIIIlII, lIIIIIIlI, llIIIIlI);
        if (llIlIlll != null) {
            String llIIlIll = llIlIlll.getStatName().getUnformattedText();
            final String llIIlIlI = llIlIlll.getDescription();
            final int llIlllII = llIIIlII + 12;
            final int llIlIlII = lIIIIIIlI - 4;
            final int llIlIIlI = this.statFileWriter.func_150874_c(llIlIlll);
            if (this.statFileWriter.canUnlockAchievement(llIlIlll)) {
                final int lllIIIll = Math.max(this.fontRendererObj.getStringWidth(llIIlIll), 120);
                int llIlllll = this.fontRendererObj.splitStringWidth(llIIlIlI, lllIIIll);
                if (this.statFileWriter.hasAchievementUnlocked(llIlIlll)) {
                    llIlllll += 12;
                }
                this.drawGradientRect(llIlllII - 3, llIlIlII - 3, llIlllII + lllIIIll + 3, llIlIlII + llIlllll + 3 + 12, -1073741824, -1073741824);
                this.fontRendererObj.drawSplitString(llIIlIlI, llIlllII, llIlIlII + 12, lllIIIll, -6250336);
                if (this.statFileWriter.hasAchievementUnlocked(llIlIlll)) {
                    this.fontRendererObj.drawStringWithShadow(I18n.format("achievement.taken", new Object[0]), (float)llIlllII, (float)(llIlIlII + llIlllll + 4), -7302913);
                }
            }
            else if (llIlIIlI == 3) {
                llIIlIll = I18n.format("achievement.unknown", new Object[0]);
                final int lllIIIlI = Math.max(this.fontRendererObj.getStringWidth(llIIlIll), 120);
                final String llIIIlll = new ChatComponentTranslation("achievement.requires", new Object[] { llIlIlll.parentAchievement.getStatName() }).getUnformattedText();
                final int llIIlIIl = this.fontRendererObj.splitStringWidth(llIIIlll, lllIIIlI);
                this.drawGradientRect(llIlllII - 3, llIlIlII - 3, llIlllII + lllIIIlI + 3, llIlIlII + llIIlIIl + 12 + 3, -1073741824, -1073741824);
                this.fontRendererObj.drawSplitString(llIIIlll, llIlllII, llIlIlII + 12, lllIIIlI, -9416624);
            }
            else if (llIlIIlI < 3) {
                final int lllIIIIl = Math.max(this.fontRendererObj.getStringWidth(llIIlIll), 120);
                final String llIIIllI = new ChatComponentTranslation("achievement.requires", new Object[] { llIlIlll.parentAchievement.getStatName() }).getUnformattedText();
                final int llIIlIII = this.fontRendererObj.splitStringWidth(llIIIllI, lllIIIIl);
                this.drawGradientRect(llIlllII - 3, llIlIlII - 3, llIlllII + lllIIIIl + 3, llIlIlII + llIIlIII + 12 + 3, -1073741824, -1073741824);
                this.fontRendererObj.drawSplitString(llIIIllI, llIlllII, llIlIlII + 12, lllIIIIl, -9416624);
            }
            else {
                llIIlIll = null;
            }
            if (llIIlIll != null) {
                this.fontRendererObj.drawStringWithShadow(llIIlIll, (float)llIlllII, (float)llIlIlII, this.statFileWriter.canUnlockAchievement(llIlIlll) ? (llIlIlll.getSpecial() ? -128 : -1) : (llIlIlll.getSpecial() ? -8355776 : -8355712));
            }
        }
        GlStateManager.enableDepth();
        GlStateManager.enableLighting();
        RenderHelper.disableStandardItemLighting();
    }
    
    @Override
    public boolean doesGuiPauseGame() {
        return !this.loadingAchievements;
    }
    
    static {
        __OBFID = "CL_00000722";
        field_146572_y = AchievementList.minDisplayColumn * 24 - 112;
        field_146571_z = AchievementList.minDisplayRow * 24 - 112;
        field_146559_A = AchievementList.maxDisplayColumn * 24 - 77;
        field_146560_B = AchievementList.maxDisplayRow * 24 - 77;
        field_146561_C = new ResourceLocation("textures/gui/achievement/achievement_background.png");
    }
    
    @Override
    protected void keyTyped(final char lIllIlIII, final int lIllIIlII) throws IOException {
        if (lIllIIlII == this.mc.gameSettings.keyBindInventory.getKeyCode()) {
            this.mc.displayGuiScreen(null);
            this.mc.setIngameFocus();
        }
        else {
            super.keyTyped(lIllIlIII, lIllIIlII);
        }
    }
    
    @Override
    public void updateScreen() {
        if (!this.loadingAchievements) {
            this.field_146569_s = this.field_146567_u;
            this.field_146568_t = this.field_146566_v;
            final double lIIllIlll = this.field_146565_w - this.field_146567_u;
            final double lIIllIllI = this.field_146573_x - this.field_146566_v;
            if (lIIllIlll * lIIllIlll + lIIllIllI * lIIllIllI < 4.0) {
                this.field_146567_u += lIIllIlll;
                this.field_146566_v += lIIllIllI;
            }
            else {
                this.field_146567_u += lIIllIlll * 0.85;
                this.field_146566_v += lIIllIllI * 0.85;
            }
        }
    }
    
    @Override
    public void initGui() {
        this.mc.getNetHandler().addToSendQueue(new C16PacketClientStatus(C16PacketClientStatus.EnumState.REQUEST_STATS));
        this.buttonList.clear();
        this.buttonList.add(new GuiOptionButton(1, this.width / 2 + 24, this.height / 2 + 74, 80, 20, I18n.format("gui.done", new Object[0])));
    }
    
    @Override
    protected void actionPerformed(final GuiButton lIllIllIl) throws IOException {
        if (!this.loadingAchievements && lIllIllIl.id == 1) {
            this.mc.displayGuiScreen(this.parentScreen);
        }
    }
    
    protected void drawTitle() {
        final int lIIlIlllI = (this.width - this.field_146555_f) / 2;
        final int lIIlIllIl = (this.height - this.field_146557_g) / 2;
        this.fontRendererObj.drawString(I18n.format("gui.achievements", new Object[0]), lIIlIlllI + 15, lIIlIllIl + 5, 4210752);
    }
    
    public GuiAchievements(final GuiScreen lIllllllI, final StatFileWriter lIllllIII) {
        this.field_146555_f = 256;
        this.field_146557_g = 202;
        this.field_146570_r = 1.0f;
        this.loadingAchievements = true;
        this.parentScreen = lIllllllI;
        this.statFileWriter = lIllllIII;
        final short lIlllllII = 141;
        final short lIllllIll = 141;
        final double field_146569_s = AchievementList.openInventory.displayColumn * 24 - lIlllllII / 2 - 12;
        this.field_146565_w = field_146569_s;
        this.field_146567_u = field_146569_s;
        this.field_146569_s = field_146569_s;
        final double field_146568_t = AchievementList.openInventory.displayRow * 24 - lIllllIll / 2;
        this.field_146573_x = field_146568_t;
        this.field_146566_v = field_146568_t;
        this.field_146568_t = field_146568_t;
    }
}
