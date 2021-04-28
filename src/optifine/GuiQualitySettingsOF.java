package optifine;

import net.minecraft.client.settings.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.gui.*;

public class GuiQualitySettingsOF extends GuiScreen
{
    private static /* synthetic */ GameSettings.Options[] enumOptions;
    protected /* synthetic */ String title;
    private /* synthetic */ TooltipManager tooltipManager;
    private /* synthetic */ GameSettings settings;
    private /* synthetic */ GuiScreen prevScreen;
    
    @Override
    public void initGui() {
        this.title = I18n.format("of.options.qualityTitle", new Object[0]);
        this.buttonList.clear();
        for (int lllllllllllllllIlIllIllllIIIIIIl = 0; lllllllllllllllIlIllIllllIIIIIIl < GuiQualitySettingsOF.enumOptions.length; ++lllllllllllllllIlIllIllllIIIIIIl) {
            final GameSettings.Options lllllllllllllllIlIllIlllIlllllll = GuiQualitySettingsOF.enumOptions[lllllllllllllllIlIllIllllIIIIIIl];
            final int lllllllllllllllIlIllIlllIlllllIl = this.width / 2 - 155 + lllllllllllllllIlIllIllllIIIIIIl % 2 * 160;
            final int lllllllllllllllIlIllIlllIllllIll = this.height / 6 + 21 * (lllllllllllllllIlIllIllllIIIIIIl / 2) - 12;
            if (!lllllllllllllllIlIllIlllIlllllll.getEnumFloat()) {
                this.buttonList.add(new GuiOptionButtonOF(lllllllllllllllIlIllIlllIlllllll.returnEnumOrdinal(), lllllllllllllllIlIllIlllIlllllIl, lllllllllllllllIlIllIlllIllllIll, lllllllllllllllIlIllIlllIlllllll, this.settings.getKeyBinding(lllllllllllllllIlIllIlllIlllllll)));
            }
            else {
                this.buttonList.add(new GuiOptionSliderOF(lllllllllllllllIlIllIlllIlllllll.returnEnumOrdinal(), lllllllllllllllIlIllIlllIlllllIl, lllllllllllllllIlIllIlllIllllIll, lllllllllllllllIlIllIlllIlllllll));
            }
        }
        this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 168 + 11, I18n.format("gui.done", new Object[0])));
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllllIlIllIlllIllIIIIl) {
        if (lllllllllllllllIlIllIlllIllIIIIl.enabled) {
            if (lllllllllllllllIlIllIlllIllIIIIl.id < 200 && lllllllllllllllIlIllIlllIllIIIIl instanceof GuiOptionButton) {
                this.settings.setOptionValue(((GuiOptionButton)lllllllllllllllIlIllIlllIllIIIIl).returnEnumOptions(), 1);
                lllllllllllllllIlIllIlllIllIIIIl.displayString = this.settings.getKeyBinding(GameSettings.Options.getEnumOptions(lllllllllllllllIlIllIlllIllIIIIl.id));
            }
            if (lllllllllllllllIlIllIlllIllIIIIl.id == 200) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(this.prevScreen);
            }
            if (lllllllllllllllIlIllIlllIllIIIIl.id != GameSettings.Options.AA_LEVEL.ordinal()) {
                final ScaledResolution lllllllllllllllIlIllIlllIllIIlIl = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
                this.setWorldAndResolution(this.mc, lllllllllllllllIlIllIlllIllIIlIl.getScaledWidth(), lllllllllllllllIlIllIlllIllIIlIl.getScaledHeight());
            }
        }
    }
    
    public GuiQualitySettingsOF(final GuiScreen lllllllllllllllIlIllIllllIIllIII, final GameSettings lllllllllllllllIlIllIllllIIlIllI) {
        this.tooltipManager = new TooltipManager(this);
        this.prevScreen = lllllllllllllllIlIllIllllIIllIII;
        this.settings = lllllllllllllllIlIllIllllIIlIllI;
    }
    
    static {
        GuiQualitySettingsOF.enumOptions = new GameSettings.Options[] { GameSettings.Options.MIPMAP_LEVELS, GameSettings.Options.MIPMAP_TYPE, GameSettings.Options.AF_LEVEL, GameSettings.Options.AA_LEVEL, GameSettings.Options.CLEAR_WATER, GameSettings.Options.RANDOM_MOBS, GameSettings.Options.BETTER_GRASS, GameSettings.Options.BETTER_SNOW, GameSettings.Options.CUSTOM_FONTS, GameSettings.Options.CUSTOM_COLORS, GameSettings.Options.SWAMP_COLORS, GameSettings.Options.SMOOTH_BIOMES, GameSettings.Options.CONNECTED_TEXTURES, GameSettings.Options.NATURAL_TEXTURES, GameSettings.Options.CUSTOM_SKY, GameSettings.Options.CUSTOM_ITEMS, GameSettings.Options.DYNAMIC_LIGHTS };
    }
    
    @Override
    public void drawScreen(final int lllllllllllllllIlIllIlllIlIlIIIl, final int lllllllllllllllIlIllIlllIlIIllll, final float lllllllllllllllIlIllIlllIlIIllIl) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, this.title, this.width / 2, 15, 16777215);
        super.drawScreen(lllllllllllllllIlIllIlllIlIlIIIl, lllllllllllllllIlIllIlllIlIIllll, lllllllllllllllIlIllIlllIlIIllIl);
        this.tooltipManager.drawTooltips(lllllllllllllllIlIllIlllIlIlIIIl, lllllllllllllllIlIllIlllIlIIllll, this.buttonList);
    }
}
