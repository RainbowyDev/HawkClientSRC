package optifine;

import net.minecraft.client.settings.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.gui.*;

public class GuiAnimationSettingsOF extends GuiScreen
{
    private /* synthetic */ GuiScreen prevScreen;
    protected /* synthetic */ String title;
    private static /* synthetic */ GameSettings.Options[] enumOptions;
    private /* synthetic */ GameSettings settings;
    
    @Override
    public void initGui() {
        this.title = I18n.format("of.options.animationsTitle", new Object[0]);
        this.buttonList.clear();
        for (int llllllllllllllIlIlllllIlIlIlIllI = 0; llllllllllllllIlIlllllIlIlIlIllI < GuiAnimationSettingsOF.enumOptions.length; ++llllllllllllllIlIlllllIlIlIlIllI) {
            final GameSettings.Options llllllllllllllIlIlllllIlIlIlIlIl = GuiAnimationSettingsOF.enumOptions[llllllllllllllIlIlllllIlIlIlIllI];
            final int llllllllllllllIlIlllllIlIlIlIlII = this.width / 2 - 155 + llllllllllllllIlIlllllIlIlIlIllI % 2 * 160;
            final int llllllllllllllIlIlllllIlIlIlIIll = this.height / 6 + 21 * (llllllllllllllIlIlllllIlIlIlIllI / 2) - 12;
            if (!llllllllllllllIlIlllllIlIlIlIlIl.getEnumFloat()) {
                this.buttonList.add(new GuiOptionButtonOF(llllllllllllllIlIlllllIlIlIlIlIl.returnEnumOrdinal(), llllllllllllllIlIlllllIlIlIlIlII, llllllllllllllIlIlllllIlIlIlIIll, llllllllllllllIlIlllllIlIlIlIlIl, this.settings.getKeyBinding(llllllllllllllIlIlllllIlIlIlIlIl)));
            }
            else {
                this.buttonList.add(new GuiOptionSliderOF(llllllllllllllIlIlllllIlIlIlIlIl.returnEnumOrdinal(), llllllllllllllIlIlllllIlIlIlIlII, llllllllllllllIlIlllllIlIlIlIIll, llllllllllllllIlIlllllIlIlIlIlIl));
            }
        }
        this.buttonList.add(new GuiButton(210, this.width / 2 - 155, this.height / 6 + 168 + 11, 70, 20, Lang.get("of.options.animation.allOn")));
        this.buttonList.add(new GuiButton(211, this.width / 2 - 155 + 80, this.height / 6 + 168 + 11, 70, 20, Lang.get("of.options.animation.allOff")));
        this.buttonList.add(new GuiOptionButton(200, this.width / 2 + 5, this.height / 6 + 168 + 11, I18n.format("gui.done", new Object[0])));
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllIlIlllllIlIlIIlIIl) {
        if (llllllllllllllIlIlllllIlIlIIlIIl.enabled) {
            if (llllllllllllllIlIlllllIlIlIIlIIl.id < 200 && llllllllllllllIlIlllllIlIlIIlIIl instanceof GuiOptionButton) {
                this.settings.setOptionValue(((GuiOptionButton)llllllllllllllIlIlllllIlIlIIlIIl).returnEnumOptions(), 1);
                llllllllllllllIlIlllllIlIlIIlIIl.displayString = this.settings.getKeyBinding(GameSettings.Options.getEnumOptions(llllllllllllllIlIlllllIlIlIIlIIl.id));
            }
            if (llllllllllllllIlIlllllIlIlIIlIIl.id == 200) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(this.prevScreen);
            }
            if (llllllllllllllIlIlllllIlIlIIlIIl.id == 210) {
                this.mc.gameSettings.setAllAnimations(true);
            }
            if (llllllllllllllIlIlllllIlIlIIlIIl.id == 211) {
                this.mc.gameSettings.setAllAnimations(false);
            }
            final ScaledResolution llllllllllllllIlIlllllIlIlIIlIII = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
            this.setWorldAndResolution(this.mc, llllllllllllllIlIlllllIlIlIIlIII.getScaledWidth(), llllllllllllllIlIlllllIlIlIIlIII.getScaledHeight());
        }
    }
    
    @Override
    public void drawScreen(final int llllllllllllllIlIlllllIlIIllllll, final int llllllllllllllIlIlllllIlIIlllllI, final float llllllllllllllIlIlllllIlIIllllIl) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, this.title, this.width / 2, 15, 16777215);
        super.drawScreen(llllllllllllllIlIlllllIlIIllllll, llllllllllllllIlIlllllIlIIlllllI, llllllllllllllIlIlllllIlIIllllIl);
    }
    
    static {
        GuiAnimationSettingsOF.enumOptions = new GameSettings.Options[] { GameSettings.Options.ANIMATED_WATER, GameSettings.Options.ANIMATED_LAVA, GameSettings.Options.ANIMATED_FIRE, GameSettings.Options.ANIMATED_PORTAL, GameSettings.Options.ANIMATED_REDSTONE, GameSettings.Options.ANIMATED_EXPLOSION, GameSettings.Options.ANIMATED_FLAME, GameSettings.Options.ANIMATED_SMOKE, GameSettings.Options.VOID_PARTICLES, GameSettings.Options.WATER_PARTICLES, GameSettings.Options.RAIN_SPLASH, GameSettings.Options.PORTAL_PARTICLES, GameSettings.Options.POTION_PARTICLES, GameSettings.Options.DRIPPING_WATER_LAVA, GameSettings.Options.ANIMATED_TERRAIN, GameSettings.Options.ANIMATED_TEXTURES, GameSettings.Options.FIREWORK_PARTICLES, GameSettings.Options.PARTICLES };
    }
    
    public GuiAnimationSettingsOF(final GuiScreen llllllllllllllIlIlllllIlIlIllllI, final GameSettings llllllllllllllIlIlllllIlIlIlllIl) {
        this.prevScreen = llllllllllllllIlIlllllIlIlIllllI;
        this.settings = llllllllllllllIlIlllllIlIlIlllIl;
    }
}
