package optifine;

import net.minecraft.client.settings.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.gui.*;

public class GuiOtherSettingsOF extends GuiScreen implements GuiYesNoCallback
{
    private /* synthetic */ GuiScreen prevScreen;
    protected /* synthetic */ String title;
    private /* synthetic */ TooltipManager tooltipManager;
    private static /* synthetic */ GameSettings.Options[] enumOptions;
    private /* synthetic */ GameSettings settings;
    
    static {
        GuiOtherSettingsOF.enumOptions = new GameSettings.Options[] { GameSettings.Options.LAGOMETER, GameSettings.Options.PROFILER, GameSettings.Options.WEATHER, GameSettings.Options.TIME, GameSettings.Options.USE_FULLSCREEN, GameSettings.Options.FULLSCREEN_MODE, GameSettings.Options.SHOW_FPS, GameSettings.Options.AUTOSAVE_TICKS, GameSettings.Options.ANAGLYPH };
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllllllIIllIllllllIII) {
        if (llllllllllllllllllIIllIllllllIII.enabled) {
            if (llllllllllllllllllIIllIllllllIII.id < 200 && llllllllllllllllllIIllIllllllIII instanceof GuiOptionButton) {
                this.settings.setOptionValue(((GuiOptionButton)llllllllllllllllllIIllIllllllIII).returnEnumOptions(), 1);
                llllllllllllllllllIIllIllllllIII.displayString = this.settings.getKeyBinding(GameSettings.Options.getEnumOptions(llllllllllllllllllIIllIllllllIII.id));
            }
            if (llllllllllllllllllIIllIllllllIII.id == 200) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(this.prevScreen);
            }
            if (llllllllllllllllllIIllIllllllIII.id == 210) {
                this.mc.gameSettings.saveOptions();
                final GuiYesNo llllllllllllllllllIIllIllllllIlI = new GuiYesNo(this, I18n.format("of.message.other.reset", new Object[0]), "", 9999);
                this.mc.displayGuiScreen(llllllllllllllllllIIllIllllllIlI);
            }
        }
    }
    
    @Override
    public void confirmClicked(final boolean llllllllllllllllllIIllIlllllIIll, final int llllllllllllllllllIIllIlllllIIlI) {
        if (llllllllllllllllllIIllIlllllIIll) {
            this.mc.gameSettings.resetSettings();
        }
        this.mc.displayGuiScreen(this);
    }
    
    @Override
    public void initGui() {
        this.title = I18n.format("of.options.otherTitle", new Object[0]);
        this.buttonList.clear();
        for (int llllllllllllllllllIIlllIIIIIlIII = 0; llllllllllllllllllIIlllIIIIIlIII < GuiOtherSettingsOF.enumOptions.length; ++llllllllllllllllllIIlllIIIIIlIII) {
            final GameSettings.Options llllllllllllllllllIIlllIIIIIIlll = GuiOtherSettingsOF.enumOptions[llllllllllllllllllIIlllIIIIIlIII];
            final int llllllllllllllllllIIlllIIIIIIllI = this.width / 2 - 155 + llllllllllllllllllIIlllIIIIIlIII % 2 * 160;
            final int llllllllllllllllllIIlllIIIIIIlIl = this.height / 6 + 21 * (llllllllllllllllllIIlllIIIIIlIII / 2) - 12;
            if (!llllllllllllllllllIIlllIIIIIIlll.getEnumFloat()) {
                this.buttonList.add(new GuiOptionButtonOF(llllllllllllllllllIIlllIIIIIIlll.returnEnumOrdinal(), llllllllllllllllllIIlllIIIIIIllI, llllllllllllllllllIIlllIIIIIIlIl, llllllllllllllllllIIlllIIIIIIlll, this.settings.getKeyBinding(llllllllllllllllllIIlllIIIIIIlll)));
            }
            else {
                this.buttonList.add(new GuiOptionSliderOF(llllllllllllllllllIIlllIIIIIIlll.returnEnumOrdinal(), llllllllllllllllllIIlllIIIIIIllI, llllllllllllllllllIIlllIIIIIIlIl, llllllllllllllllllIIlllIIIIIIlll));
            }
        }
        this.buttonList.add(new GuiButton(210, this.width / 2 - 100, this.height / 6 + 168 + 11 - 44, I18n.format("of.options.other.reset", new Object[0])));
        this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 168 + 11, I18n.format("gui.done", new Object[0])));
    }
    
    @Override
    public void drawScreen(final int llllllllllllllllllIIllIllIlIlIIl, final int llllllllllllllllllIIllIllIlIllII, final float llllllllllllllllllIIllIllIlIIlll) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, this.title, this.width / 2, 15, 16777215);
        super.drawScreen(llllllllllllllllllIIllIllIlIlIIl, llllllllllllllllllIIllIllIlIllII, llllllllllllllllllIIllIllIlIIlll);
        this.tooltipManager.drawTooltips(llllllllllllllllllIIllIllIlIlIIl, llllllllllllllllllIIllIllIlIllII, this.buttonList);
    }
    
    public GuiOtherSettingsOF(final GuiScreen llllllllllllllllllIIlllIIIIlIIII, final GameSettings llllllllllllllllllIIlllIIIIlIIlI) {
        this.tooltipManager = new TooltipManager(this);
        this.prevScreen = llllllllllllllllllIIlllIIIIlIIII;
        this.settings = llllllllllllllllllIIlllIIIIlIIlI;
    }
}
