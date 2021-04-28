package optifine;

import net.minecraft.client.settings.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.resources.*;

public class GuiPerformanceSettingsOF extends GuiScreen
{
    private /* synthetic */ TooltipManager tooltipManager;
    private static /* synthetic */ GameSettings.Options[] enumOptions;
    private /* synthetic */ GameSettings settings;
    private /* synthetic */ GuiScreen prevScreen;
    protected /* synthetic */ String title;
    
    @Override
    public void drawScreen(final int llllllllllllllIIlIlIlllIlIIIllll, final int llllllllllllllIIlIlIlllIlIIIlllI, final float llllllllllllllIIlIlIlllIlIIlIIIl) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, this.title, this.width / 2, 15, 16777215);
        super.drawScreen(llllllllllllllIIlIlIlllIlIIIllll, llllllllllllllIIlIlIlllIlIIIlllI, llllllllllllllIIlIlIlllIlIIlIIIl);
        this.tooltipManager.drawTooltips(llllllllllllllIIlIlIlllIlIIIllll, llllllllllllllIIlIlIlllIlIIIlllI, this.buttonList);
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllIIlIlIlllIlIIllIIl) {
        if (llllllllllllllIIlIlIlllIlIIllIIl.enabled) {
            if (llllllllllllllIIlIlIlllIlIIllIIl.id < 200 && llllllllllllllIIlIlIlllIlIIllIIl instanceof GuiOptionButton) {
                this.settings.setOptionValue(((GuiOptionButton)llllllllllllllIIlIlIlllIlIIllIIl).returnEnumOptions(), 1);
                llllllllllllllIIlIlIlllIlIIllIIl.displayString = this.settings.getKeyBinding(GameSettings.Options.getEnumOptions(llllllllllllllIIlIlIlllIlIIllIIl.id));
            }
            if (llllllllllllllIIlIlIlllIlIIllIIl.id == 200) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(this.prevScreen);
            }
        }
    }
    
    public GuiPerformanceSettingsOF(final GuiScreen llllllllllllllIIlIlIlllIlIlIllll, final GameSettings llllllllllllllIIlIlIlllIlIllIIIl) {
        this.tooltipManager = new TooltipManager(this);
        this.prevScreen = llllllllllllllIIlIlIlllIlIlIllll;
        this.settings = llllllllllllllIIlIlIlllIlIllIIIl;
    }
    
    static {
        GuiPerformanceSettingsOF.enumOptions = new GameSettings.Options[] { GameSettings.Options.SMOOTH_FPS, GameSettings.Options.SMOOTH_WORLD, GameSettings.Options.FAST_RENDER, GameSettings.Options.FAST_MATH, GameSettings.Options.CHUNK_UPDATES, GameSettings.Options.CHUNK_UPDATES_DYNAMIC, GameSettings.Options.LAZY_CHUNK_LOADING };
    }
    
    @Override
    public void initGui() {
        this.title = I18n.format("of.options.performanceTitle", new Object[0]);
        this.buttonList.clear();
        for (int llllllllllllllIIlIlIlllIlIlIIlll = 0; llllllllllllllIIlIlIlllIlIlIIlll < GuiPerformanceSettingsOF.enumOptions.length; ++llllllllllllllIIlIlIlllIlIlIIlll) {
            final GameSettings.Options llllllllllllllIIlIlIlllIlIlIIllI = GuiPerformanceSettingsOF.enumOptions[llllllllllllllIIlIlIlllIlIlIIlll];
            final int llllllllllllllIIlIlIlllIlIlIIlIl = this.width / 2 - 155 + llllllllllllllIIlIlIlllIlIlIIlll % 2 * 160;
            final int llllllllllllllIIlIlIlllIlIlIIlII = this.height / 6 + 21 * (llllllllllllllIIlIlIlllIlIlIIlll / 2) - 12;
            if (!llllllllllllllIIlIlIlllIlIlIIllI.getEnumFloat()) {
                this.buttonList.add(new GuiOptionButtonOF(llllllllllllllIIlIlIlllIlIlIIllI.returnEnumOrdinal(), llllllllllllllIIlIlIlllIlIlIIlIl, llllllllllllllIIlIlIlllIlIlIIlII, llllllllllllllIIlIlIlllIlIlIIllI, this.settings.getKeyBinding(llllllllllllllIIlIlIlllIlIlIIllI)));
            }
            else {
                this.buttonList.add(new GuiOptionSliderOF(llllllllllllllIIlIlIlllIlIlIIllI.returnEnumOrdinal(), llllllllllllllIIlIlIlllIlIlIIlIl, llllllllllllllIIlIlIlllIlIlIIlII, llllllllllllllIIlIlIlllIlIlIIllI));
            }
        }
        this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 168 + 11, I18n.format("gui.done", new Object[0])));
    }
}
