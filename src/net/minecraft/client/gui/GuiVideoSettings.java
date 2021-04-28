package net.minecraft.client.gui;

import net.minecraft.client.settings.*;
import net.minecraft.client.resources.*;
import optifine.*;
import shadersmod.client.*;
import java.io.*;

public class GuiVideoSettings extends GuiScreen
{
    private /* synthetic */ GuiScreen parentGuiScreen;
    protected /* synthetic */ String screenTitle;
    private static /* synthetic */ GameSettings.Options[] videoOptions;
    private /* synthetic */ TooltipManager tooltipManager;
    private /* synthetic */ GameSettings guiGameSettings;
    
    public static int getButtonHeight(final GuiButton lllllllllllllllIIIIIIlllIIIIIlII) {
        return lllllllllllllllIIIIIIlllIIIIIlII.height;
    }
    
    public GuiVideoSettings(final GuiScreen lllllllllllllllIIIIIIlllIlIIlllI, final GameSettings lllllllllllllllIIIIIIlllIlIIlIlI) {
        this.screenTitle = "Video Settings";
        this.tooltipManager = new TooltipManager(this);
        this.parentGuiScreen = lllllllllllllllIIIIIIlllIlIIlllI;
        this.guiGameSettings = lllllllllllllllIIIIIIlllIlIIlIlI;
    }
    
    public static void drawGradientRect(final GuiScreen lllllllllllllllIIIIIIllIllllIlII, final int lllllllllllllllIIIIIIllIllllIIll, final int lllllllllllllllIIIIIIllIlllllIIl, final int lllllllllllllllIIIIIIllIlllllIII, final int lllllllllllllllIIIIIIllIllllIIII, final int lllllllllllllllIIIIIIllIllllIllI, final int lllllllllllllllIIIIIIllIllllIlIl) {
        lllllllllllllllIIIIIIllIllllIlII.drawGradientRect(lllllllllllllllIIIIIIllIllllIIll, lllllllllllllllIIIIIIllIlllllIIl, lllllllllllllllIIIIIIllIlllllIII, lllllllllllllllIIIIIIllIllllIIII, lllllllllllllllIIIIIIllIllllIllI, lllllllllllllllIIIIIIllIllllIlIl);
    }
    
    @Override
    public void drawScreen(final int lllllllllllllllIIIIIIlllIIIIllll, final int lllllllllllllllIIIIIIlllIIIIlllI, final float lllllllllllllllIIIIIIlllIIIIllIl) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, this.screenTitle, this.width / 2, 15, 16777215);
        String lllllllllllllllIIIIIIlllIIIlIlII = Config.getVersion();
        final String lllllllllllllllIIIIIIlllIIIlIIll = "HD_U";
        if (lllllllllllllllIIIIIIlllIIIlIIll.equals("HD")) {
            lllllllllllllllIIIIIIlllIIIlIlII = "OptiFine HD H6";
        }
        if (lllllllllllllllIIIIIIlllIIIlIIll.equals("HD_U")) {
            lllllllllllllllIIIIIIlllIIIlIlII = "OptiFine HD H6 Ultra";
        }
        if (lllllllllllllllIIIIIIlllIIIlIIll.equals("L")) {
            lllllllllllllllIIIIIIlllIIIlIlII = "OptiFine H6 Light";
        }
        this.drawString(this.fontRendererObj, lllllllllllllllIIIIIIlllIIIlIlII, 2, this.height - 10, 8421504);
        final String lllllllllllllllIIIIIIlllIIIlIIlI = "Minecraft 1.8";
        final int lllllllllllllllIIIIIIlllIIIlIIIl = this.fontRendererObj.getStringWidth(lllllllllllllllIIIIIIlllIIIlIIlI);
        this.drawString(this.fontRendererObj, lllllllllllllllIIIIIIlllIIIlIIlI, this.width - lllllllllllllllIIIIIIlllIIIlIIIl - 2, this.height - 10, 8421504);
        super.drawScreen(lllllllllllllllIIIIIIlllIIIIllll, lllllllllllllllIIIIIIlllIIIIlllI, lllllllllllllllIIIIIIlllIIIIllIl);
        this.tooltipManager.drawTooltips(lllllllllllllllIIIIIIlllIIIIllll, lllllllllllllllIIIIIIlllIIIIlllI, this.buttonList);
    }
    
    @Override
    public void initGui() {
        this.screenTitle = I18n.format("options.videoTitle", new Object[0]);
        this.buttonList.clear();
        for (int lllllllllllllllIIIIIIlllIlIIIIll = 0; lllllllllllllllIIIIIIlllIlIIIIll < GuiVideoSettings.videoOptions.length; ++lllllllllllllllIIIIIIlllIlIIIIll) {
            final GameSettings.Options lllllllllllllllIIIIIIlllIlIIIIlI = GuiVideoSettings.videoOptions[lllllllllllllllIIIIIIlllIlIIIIll];
            if (lllllllllllllllIIIIIIlllIlIIIIlI != null) {
                final int lllllllllllllllIIIIIIlllIlIIIIIl = this.width / 2 - 155 + lllllllllllllllIIIIIIlllIlIIIIll % 2 * 160;
                final int lllllllllllllllIIIIIIlllIlIIIIII = this.height / 6 + 21 * (lllllllllllllllIIIIIIlllIlIIIIll / 2) - 12;
                if (lllllllllllllllIIIIIIlllIlIIIIlI.getEnumFloat()) {
                    this.buttonList.add(new GuiOptionSliderOF(lllllllllllllllIIIIIIlllIlIIIIlI.returnEnumOrdinal(), lllllllllllllllIIIIIIlllIlIIIIIl, lllllllllllllllIIIIIIlllIlIIIIII, lllllllllllllllIIIIIIlllIlIIIIlI));
                }
                else {
                    this.buttonList.add(new GuiOptionButtonOF(lllllllllllllllIIIIIIlllIlIIIIlI.returnEnumOrdinal(), lllllllllllllllIIIIIIlllIlIIIIIl, lllllllllllllllIIIIIIlllIlIIIIII, lllllllllllllllIIIIIIlllIlIIIIlI, this.guiGameSettings.getKeyBinding(lllllllllllllllIIIIIIlllIlIIIIlI)));
                }
            }
        }
        int lllllllllllllllIIIIIIlllIlIIIIll = this.height / 6 + 21 * (GuiVideoSettings.videoOptions.length / 2) - 12;
        final boolean lllllllllllllllIIIIIIlllIIllllll = false;
        int lllllllllllllllIIIIIIlllIIlllllI = this.width / 2 - 155 + 0;
        this.buttonList.add(new GuiOptionButton(231, lllllllllllllllIIIIIIlllIIlllllI, lllllllllllllllIIIIIIlllIlIIIIll, Lang.get("of.options.shaders")));
        lllllllllllllllIIIIIIlllIIlllllI = this.width / 2 - 155 + 160;
        this.buttonList.add(new GuiOptionButton(202, lllllllllllllllIIIIIIlllIIlllllI, lllllllllllllllIIIIIIlllIlIIIIll, Lang.get("of.options.quality")));
        lllllllllllllllIIIIIIlllIlIIIIll += 21;
        lllllllllllllllIIIIIIlllIIlllllI = this.width / 2 - 155 + 0;
        this.buttonList.add(new GuiOptionButton(201, lllllllllllllllIIIIIIlllIIlllllI, lllllllllllllllIIIIIIlllIlIIIIll, Lang.get("of.options.details")));
        lllllllllllllllIIIIIIlllIIlllllI = this.width / 2 - 155 + 160;
        this.buttonList.add(new GuiOptionButton(212, lllllllllllllllIIIIIIlllIIlllllI, lllllllllllllllIIIIIIlllIlIIIIll, Lang.get("of.options.performance")));
        lllllllllllllllIIIIIIlllIlIIIIll += 21;
        lllllllllllllllIIIIIIlllIIlllllI = this.width / 2 - 155 + 0;
        this.buttonList.add(new GuiOptionButton(211, lllllllllllllllIIIIIIlllIIlllllI, lllllllllllllllIIIIIIlllIlIIIIll, Lang.get("of.options.animations")));
        lllllllllllllllIIIIIIlllIIlllllI = this.width / 2 - 155 + 160;
        this.buttonList.add(new GuiOptionButton(222, lllllllllllllllIIIIIIlllIIlllllI, lllllllllllllllIIIIIIlllIlIIIIll, Lang.get("of.options.other")));
        lllllllllllllllIIIIIIlllIlIIIIll += 21;
        this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 168 + 11, I18n.format("gui.done", new Object[0])));
    }
    
    static {
        __OBFID = "CL_00000718";
        GuiVideoSettings.videoOptions = new GameSettings.Options[] { GameSettings.Options.GRAPHICS, GameSettings.Options.RENDER_DISTANCE, GameSettings.Options.AMBIENT_OCCLUSION, GameSettings.Options.FRAMERATE_LIMIT, GameSettings.Options.AO_LEVEL, GameSettings.Options.VIEW_BOBBING, GameSettings.Options.GUI_SCALE, GameSettings.Options.USE_VBO, GameSettings.Options.GAMMA, GameSettings.Options.BLOCK_ALTERNATIVES, GameSettings.Options.FOG_FANCY, GameSettings.Options.FOG_START };
    }
    
    public static int getButtonWidth(final GuiButton lllllllllllllllIIIIIIlllIIIIIllI) {
        return lllllllllllllllIIIIIIlllIIIIIllI.width;
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllllIIIIIIlllIIllIIIl) throws IOException {
        if (lllllllllllllllIIIIIIlllIIllIIIl.enabled) {
            final int lllllllllllllllIIIIIIlllIIllIIII = this.guiGameSettings.guiScale;
            if (lllllllllllllllIIIIIIlllIIllIIIl.id < 200 && lllllllllllllllIIIIIIlllIIllIIIl instanceof GuiOptionButton) {
                this.guiGameSettings.setOptionValue(((GuiOptionButton)lllllllllllllllIIIIIIlllIIllIIIl).returnEnumOptions(), 1);
                lllllllllllllllIIIIIIlllIIllIIIl.displayString = this.guiGameSettings.getKeyBinding(GameSettings.Options.getEnumOptions(lllllllllllllllIIIIIIlllIIllIIIl.id));
            }
            if (lllllllllllllllIIIIIIlllIIllIIIl.id == 200) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(this.parentGuiScreen);
            }
            if (this.guiGameSettings.guiScale != lllllllllllllllIIIIIIlllIIllIIII) {
                final ScaledResolution lllllllllllllllIIIIIIlllIIlIllll = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
                final int lllllllllllllllIIIIIIlllIIlIlllI = lllllllllllllllIIIIIIlllIIlIllll.getScaledWidth();
                final int lllllllllllllllIIIIIIlllIIlIllIl = lllllllllllllllIIIIIIlllIIlIllll.getScaledHeight();
                this.setWorldAndResolution(this.mc, lllllllllllllllIIIIIIlllIIlIlllI, lllllllllllllllIIIIIIlllIIlIllIl);
            }
            if (lllllllllllllllIIIIIIlllIIllIIIl.id == 201) {
                this.mc.gameSettings.saveOptions();
                final GuiDetailSettingsOF lllllllllllllllIIIIIIlllIIlIllII = new GuiDetailSettingsOF(this, this.guiGameSettings);
                this.mc.displayGuiScreen(lllllllllllllllIIIIIIlllIIlIllII);
            }
            if (lllllllllllllllIIIIIIlllIIllIIIl.id == 202) {
                this.mc.gameSettings.saveOptions();
                final GuiQualitySettingsOF lllllllllllllllIIIIIIlllIIlIlIll = new GuiQualitySettingsOF(this, this.guiGameSettings);
                this.mc.displayGuiScreen(lllllllllllllllIIIIIIlllIIlIlIll);
            }
            if (lllllllllllllllIIIIIIlllIIllIIIl.id == 211) {
                this.mc.gameSettings.saveOptions();
                final GuiAnimationSettingsOF lllllllllllllllIIIIIIlllIIlIlIlI = new GuiAnimationSettingsOF(this, this.guiGameSettings);
                this.mc.displayGuiScreen(lllllllllllllllIIIIIIlllIIlIlIlI);
            }
            if (lllllllllllllllIIIIIIlllIIllIIIl.id == 212) {
                this.mc.gameSettings.saveOptions();
                final GuiPerformanceSettingsOF lllllllllllllllIIIIIIlllIIlIlIIl = new GuiPerformanceSettingsOF(this, this.guiGameSettings);
                this.mc.displayGuiScreen(lllllllllllllllIIIIIIlllIIlIlIIl);
            }
            if (lllllllllllllllIIIIIIlllIIllIIIl.id == 222) {
                this.mc.gameSettings.saveOptions();
                final GuiOtherSettingsOF lllllllllllllllIIIIIIlllIIlIlIII = new GuiOtherSettingsOF(this, this.guiGameSettings);
                this.mc.displayGuiScreen(lllllllllllllllIIIIIIlllIIlIlIII);
            }
            if (lllllllllllllllIIIIIIlllIIllIIIl.id == 231) {
                if (Config.isAntialiasing() || Config.isAntialiasingConfigured()) {
                    Config.showGuiMessage(Lang.get("of.message.shaders.aa1"), Lang.get("of.message.shaders.aa2"));
                    return;
                }
                if (Config.isAnisotropicFiltering()) {
                    Config.showGuiMessage(Lang.get("of.message.shaders.af1"), Lang.get("of.message.shaders.af2"));
                    return;
                }
                if (Config.isFastRender()) {
                    Config.showGuiMessage(Lang.get("of.message.shaders.fr1"), Lang.get("of.message.shaders.fr2"));
                    return;
                }
                this.mc.gameSettings.saveOptions();
                final GuiShaders lllllllllllllllIIIIIIlllIIlIIlll = new GuiShaders(this, this.guiGameSettings);
                this.mc.displayGuiScreen(lllllllllllllllIIIIIIlllIIlIIlll);
            }
        }
    }
}
