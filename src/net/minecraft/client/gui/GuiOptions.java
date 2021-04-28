package net.minecraft.client.gui;

import net.minecraft.client.settings.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.audio.*;
import net.minecraft.world.*;
import net.minecraft.client.gui.stream.*;
import net.minecraft.client.stream.*;
import java.io.*;
import net.minecraft.util.*;

public class GuiOptions extends GuiScreen implements GuiYesNoCallback
{
    private final /* synthetic */ GuiScreen field_146441_g;
    private /* synthetic */ GuiLockIconButton field_175356_r;
    private static final /* synthetic */ GameSettings.Options[] field_146440_f;
    private /* synthetic */ GuiButton field_175357_i;
    protected /* synthetic */ String field_146442_a;
    private final /* synthetic */ GameSettings game_settings_1;
    
    @Override
    public void initGui() {
        int lIllllIIllIIl = 0;
        this.field_146442_a = I18n.format("options.title", new Object[0]);
        for (final GameSettings.Options lIllllIIlIlIl : GuiOptions.field_146440_f) {
            if (lIllllIIlIlIl.getEnumFloat()) {
                this.buttonList.add(new GuiOptionSlider(lIllllIIlIlIl.returnEnumOrdinal(), this.width / 2 - 155 + lIllllIIllIIl % 2 * 160, this.height / 6 - 12 + 24 * (lIllllIIllIIl >> 1), lIllllIIlIlIl));
            }
            else {
                final GuiOptionButton lIllllIIlIlII = new GuiOptionButton(lIllllIIlIlIl.returnEnumOrdinal(), this.width / 2 - 155 + lIllllIIllIIl % 2 * 160, this.height / 6 - 12 + 24 * (lIllllIIllIIl >> 1), lIllllIIlIlIl, this.game_settings_1.getKeyBinding(lIllllIIlIlIl));
                this.buttonList.add(lIllllIIlIlII);
            }
            ++lIllllIIllIIl;
        }
        if (this.mc.theWorld != null) {
            final EnumDifficulty lIllllIIlIIll = this.mc.theWorld.getDifficulty();
            this.field_175357_i = new GuiButton(108, this.width / 2 - 155 + lIllllIIllIIl % 2 * 160, this.height / 6 - 12 + 24 * (lIllllIIllIIl >> 1), 150, 20, this.func_175355_a(lIllllIIlIIll));
            this.buttonList.add(this.field_175357_i);
            if (this.mc.isSingleplayer() && !this.mc.theWorld.getWorldInfo().isHardcoreModeEnabled()) {
                this.field_175357_i.func_175211_a(this.field_175357_i.getButtonWidth() - 20);
                this.field_175356_r = new GuiLockIconButton(109, this.field_175357_i.xPosition + this.field_175357_i.getButtonWidth(), this.field_175357_i.yPosition);
                this.buttonList.add(this.field_175356_r);
                this.field_175356_r.func_175229_b(this.mc.theWorld.getWorldInfo().isDifficultyLocked());
                this.field_175356_r.enabled = !this.field_175356_r.func_175230_c();
                this.field_175357_i.enabled = !this.field_175356_r.func_175230_c();
            }
            else {
                this.field_175357_i.enabled = false;
            }
        }
        this.buttonList.add(new GuiButton(110, this.width / 2 - 155, this.height / 6 + 48 - 6, 150, 20, I18n.format("options.skinCustomisation", new Object[0])));
        this.buttonList.add(new GuiButton(8675309, this.width / 2 + 5, this.height / 6 + 48 - 6, 150, 20, "Super Secret Settings...") {
            @Override
            public void playPressSound(final SoundHandler lllllllllllllllllIIIIIIlIlIlIIIl) {
                final SoundEventAccessorComposite lllllllllllllllllIIIIIIlIlIlIIII = lllllllllllllllllIIIIIIlIlIlIIIl.getRandomSoundFromCategories(SoundCategory.ANIMALS, SoundCategory.BLOCKS, SoundCategory.MOBS, SoundCategory.PLAYERS, SoundCategory.WEATHER);
                if (lllllllllllllllllIIIIIIlIlIlIIII != null) {
                    lllllllllllllllllIIIIIIlIlIlIIIl.playSound(PositionedSoundRecord.createPositionedSoundRecord(lllllllllllllllllIIIIIIlIlIlIIII.getSoundEventLocation(), 0.5f));
                }
            }
            
            static {
                __OBFID = "CL_00000701";
            }
        });
        this.buttonList.add(new GuiButton(106, this.width / 2 - 155, this.height / 6 + 72 - 6, 150, 20, I18n.format("options.sounds", new Object[0])));
        this.buttonList.add(new GuiButton(107, this.width / 2 + 5, this.height / 6 + 72 - 6, 150, 20, I18n.format("options.stream", new Object[0])));
        this.buttonList.add(new GuiButton(101, this.width / 2 - 155, this.height / 6 + 96 - 6, 150, 20, I18n.format("options.video", new Object[0])));
        this.buttonList.add(new GuiButton(100, this.width / 2 + 5, this.height / 6 + 96 - 6, 150, 20, I18n.format("options.controls", new Object[0])));
        this.buttonList.add(new GuiButton(102, this.width / 2 - 155, this.height / 6 + 120 - 6, 150, 20, I18n.format("options.language", new Object[0])));
        this.buttonList.add(new GuiButton(103, this.width / 2 + 5, this.height / 6 + 120 - 6, 150, 20, I18n.format("options.multiplayer.title", new Object[0])));
        this.buttonList.add(new GuiButton(105, this.width / 2 - 155, this.height / 6 + 144 - 6, 150, 20, I18n.format("options.resourcepack", new Object[0])));
        this.buttonList.add(new GuiButton(104, this.width / 2 + 5, this.height / 6 + 144 - 6, 150, 20, I18n.format("options.snooper.view", new Object[0])));
        this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 168, I18n.format("gui.done", new Object[0])));
    }
    
    @Override
    protected void actionPerformed(final GuiButton lIlllIlllIlll) throws IOException {
        if (lIlllIlllIlll.enabled) {
            if (lIlllIlllIlll.id < 100 && lIlllIlllIlll instanceof GuiOptionButton) {
                final GameSettings.Options lIlllIlllIllI = ((GuiOptionButton)lIlllIlllIlll).returnEnumOptions();
                this.game_settings_1.setOptionValue(lIlllIlllIllI, 1);
                lIlllIlllIlll.displayString = this.game_settings_1.getKeyBinding(GameSettings.Options.getEnumOptions(lIlllIlllIlll.id));
            }
            if (lIlllIlllIlll.id == 108) {
                this.mc.theWorld.getWorldInfo().setDifficulty(EnumDifficulty.getDifficultyEnum(this.mc.theWorld.getDifficulty().getDifficultyId() + 1));
                this.field_175357_i.displayString = this.func_175355_a(this.mc.theWorld.getDifficulty());
            }
            if (lIlllIlllIlll.id == 109) {
                this.mc.displayGuiScreen(new GuiYesNo(this, new ChatComponentTranslation("difficulty.lock.title", new Object[0]).getFormattedText(), new ChatComponentTranslation("difficulty.lock.question", new Object[] { new ChatComponentTranslation(this.mc.theWorld.getWorldInfo().getDifficulty().getDifficultyResourceKey(), new Object[0]) }).getFormattedText(), 109));
            }
            if (lIlllIlllIlll.id == 110) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(new GuiCustomizeSkin(this));
            }
            if (lIlllIlllIlll.id == 8675309) {
                this.mc.entityRenderer.activateNextShader();
            }
            if (lIlllIlllIlll.id == 101) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(new GuiVideoSettings(this, this.game_settings_1));
            }
            if (lIlllIlllIlll.id == 100) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(new GuiControls(this, this.game_settings_1));
            }
            if (lIlllIlllIlll.id == 102) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(new GuiLanguage(this, this.game_settings_1, this.mc.getLanguageManager()));
            }
            if (lIlllIlllIlll.id == 103) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(new ScreenChatOptions(this, this.game_settings_1));
            }
            if (lIlllIlllIlll.id == 104) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(new GuiSnooper(this, this.game_settings_1));
            }
            if (lIlllIlllIlll.id == 200) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(this.field_146441_g);
            }
            if (lIlllIlllIlll.id == 105) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(new GuiScreenResourcePacks(this));
            }
            if (lIlllIlllIlll.id == 106) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(new GuiScreenOptionsSounds(this, this.game_settings_1));
            }
            if (lIlllIlllIlll.id == 107) {
                this.mc.gameSettings.saveOptions();
                final IStream lIlllIlllIlIl = this.mc.getTwitchStream();
                if (lIlllIlllIlIl.func_152936_l() && lIlllIlllIlIl.func_152928_D()) {
                    this.mc.displayGuiScreen(new GuiStreamOptions(this, this.game_settings_1));
                }
                else {
                    GuiStreamUnavailable.func_152321_a(this);
                }
            }
        }
    }
    
    @Override
    public void drawScreen(final int lIlllIllIlIII, final int lIlllIllIlIll, final float lIlllIllIIllI) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, this.field_146442_a, this.width / 2, 15, 16777215);
        super.drawScreen(lIlllIllIlIII, lIlllIllIlIll, lIlllIllIIllI);
    }
    
    public GuiOptions(final GuiScreen lIllllIlIIllI, final GameSettings lIllllIlIIIlI) {
        this.field_146442_a = "Options";
        this.field_146441_g = lIllllIlIIllI;
        this.game_settings_1 = lIllllIlIIIlI;
    }
    
    public String func_175355_a(final EnumDifficulty lIllllIIIlIII) {
        final ChatComponentText lIllllIIIIlll = new ChatComponentText("");
        lIllllIIIIlll.appendSibling(new ChatComponentTranslation("options.difficulty", new Object[0]));
        lIllllIIIIlll.appendText(": ");
        lIllllIIIIlll.appendSibling(new ChatComponentTranslation(lIllllIIIlIII.getDifficultyResourceKey(), new Object[0]));
        return lIllllIIIIlll.getFormattedText();
    }
    
    static {
        __OBFID = "CL_00000700";
        field_146440_f = new GameSettings.Options[] { GameSettings.Options.FOV };
    }
    
    @Override
    public void confirmClicked(final boolean lIllllIIIIIII, final int lIlllIlllllII) {
        this.mc.displayGuiScreen(this);
        if (lIlllIlllllII == 109 && lIllllIIIIIII && this.mc.theWorld != null) {
            this.mc.theWorld.getWorldInfo().setDifficultyLocked(true);
            this.field_175356_r.func_175229_b(true);
            this.field_175356_r.enabled = false;
            this.field_175357_i.enabled = false;
        }
    }
}
