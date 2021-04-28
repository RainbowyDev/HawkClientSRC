package optifine;

import net.minecraft.client.settings.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.gui.*;

public class GuiDetailSettingsOF extends GuiScreen
{
    protected /* synthetic */ String title;
    private /* synthetic */ GameSettings settings;
    private /* synthetic */ TooltipManager tooltipManager;
    private static /* synthetic */ GameSettings.Options[] enumOptions;
    private /* synthetic */ GuiScreen prevScreen;
    
    static {
        GuiDetailSettingsOF.enumOptions = new GameSettings.Options[] { GameSettings.Options.CLOUDS, GameSettings.Options.CLOUD_HEIGHT, GameSettings.Options.TREES, GameSettings.Options.RAIN, GameSettings.Options.SKY, GameSettings.Options.STARS, GameSettings.Options.SUN_MOON, GameSettings.Options.SHOW_CAPES, GameSettings.Options.TRANSLUCENT_BLOCKS, GameSettings.Options.HELD_ITEM_TOOLTIPS, GameSettings.Options.DROPPED_ITEMS, GameSettings.Options.VIGNETTE, GameSettings.Options.DYNAMIC_FOV };
    }
    
    @Override
    public void drawScreen(final int lllllllllllllllIIllIlIIIlllIIIlI, final int lllllllllllllllIIllIlIIIllIlllIl, final float lllllllllllllllIIllIlIIIlllIIIII) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, this.title, this.width / 2, 15, 16777215);
        super.drawScreen(lllllllllllllllIIllIlIIIlllIIIlI, lllllllllllllllIIllIlIIIllIlllIl, lllllllllllllllIIllIlIIIlllIIIII);
        this.tooltipManager.drawTooltips(lllllllllllllllIIllIlIIIlllIIIlI, lllllllllllllllIIllIlIIIllIlllIl, this.buttonList);
    }
    
    public GuiDetailSettingsOF(final GuiScreen lllllllllllllllIIllIlIIlIIIIIIIl, final GameSettings lllllllllllllllIIllIlIIIllllllIl) {
        this.tooltipManager = new TooltipManager(this);
        this.prevScreen = lllllllllllllllIIllIlIIlIIIIIIIl;
        this.settings = lllllllllllllllIIllIlIIIllllllIl;
    }
    
    @Override
    public void initGui() {
        this.title = I18n.format("of.options.detailsTitle", new Object[0]);
        this.buttonList.clear();
        for (int lllllllllllllllIIllIlIIIllllIllI = 0; lllllllllllllllIIllIlIIIllllIllI < GuiDetailSettingsOF.enumOptions.length; ++lllllllllllllllIIllIlIIIllllIllI) {
            final GameSettings.Options lllllllllllllllIIllIlIIIllllIlIl = GuiDetailSettingsOF.enumOptions[lllllllllllllllIIllIlIIIllllIllI];
            final int lllllllllllllllIIllIlIIIllllIlII = this.width / 2 - 155 + lllllllllllllllIIllIlIIIllllIllI % 2 * 160;
            final int lllllllllllllllIIllIlIIIllllIIll = this.height / 6 + 21 * (lllllllllllllllIIllIlIIIllllIllI / 2) - 12;
            if (!lllllllllllllllIIllIlIIIllllIlIl.getEnumFloat()) {
                this.buttonList.add(new GuiOptionButtonOF(lllllllllllllllIIllIlIIIllllIlIl.returnEnumOrdinal(), lllllllllllllllIIllIlIIIllllIlII, lllllllllllllllIIllIlIIIllllIIll, lllllllllllllllIIllIlIIIllllIlIl, this.settings.getKeyBinding(lllllllllllllllIIllIlIIIllllIlIl)));
            }
            else {
                this.buttonList.add(new GuiOptionSliderOF(lllllllllllllllIIllIlIIIllllIlIl.returnEnumOrdinal(), lllllllllllllllIIllIlIIIllllIlII, lllllllllllllllIIllIlIIIllllIIll, lllllllllllllllIIllIlIIIllllIlIl));
            }
        }
        this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 168 + 11, I18n.format("gui.done", new Object[0])));
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllllIIllIlIIIlllIlIlI) {
        if (lllllllllllllllIIllIlIIIlllIlIlI.enabled) {
            if (lllllllllllllllIIllIlIIIlllIlIlI.id < 200 && lllllllllllllllIIllIlIIIlllIlIlI instanceof GuiOptionButton) {
                this.settings.setOptionValue(((GuiOptionButton)lllllllllllllllIIllIlIIIlllIlIlI).returnEnumOptions(), 1);
                lllllllllllllllIIllIlIIIlllIlIlI.displayString = this.settings.getKeyBinding(GameSettings.Options.getEnumOptions(lllllllllllllllIIllIlIIIlllIlIlI.id));
            }
            if (lllllllllllllllIIllIlIIIlllIlIlI.id == 200) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(this.prevScreen);
            }
        }
    }
}
