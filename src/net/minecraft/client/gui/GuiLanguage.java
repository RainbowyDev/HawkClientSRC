package net.minecraft.client.gui;

import net.minecraft.client.settings.*;
import java.io.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.*;
import com.google.common.collect.*;
import java.util.*;

public class GuiLanguage extends GuiScreen
{
    private /* synthetic */ GuiOptionButton field_146455_i;
    private final /* synthetic */ LanguageManager field_146454_h;
    private /* synthetic */ GuiOptionButton field_146452_r;
    private /* synthetic */ List field_146450_f;
    private final /* synthetic */ GameSettings game_settings_3;
    protected /* synthetic */ GuiScreen field_146453_a;
    
    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.field_146450_f.func_178039_p();
    }
    
    public GuiLanguage(final GuiScreen llllllllllllllIIlIIIIllIllIIllII, final GameSettings llllllllllllllIIlIIIIllIllIIlIlI, final LanguageManager llllllllllllllIIlIIIIllIllIIlIII) {
        this.field_146453_a = llllllllllllllIIlIIIIllIllIIllII;
        this.game_settings_3 = llllllllllllllIIlIIIIllIllIIlIlI;
        this.field_146454_h = llllllllllllllIIlIIIIllIllIIlIII;
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllIIlIIIIllIlIllIIIl) throws IOException {
        if (llllllllllllllIIlIIIIllIlIllIIIl.enabled) {
            switch (llllllllllllllIIlIIIIllIlIllIIIl.id) {
                case 5: {
                    break;
                }
                case 6: {
                    this.mc.displayGuiScreen(this.field_146453_a);
                    break;
                }
                case 100: {
                    if (llllllllllllllIIlIIIIllIlIllIIIl instanceof GuiOptionButton) {
                        this.game_settings_3.setOptionValue(((GuiOptionButton)llllllllllllllIIlIIIIllIlIllIIIl).returnEnumOptions(), 1);
                        llllllllllllllIIlIIIIllIlIllIIIl.displayString = this.game_settings_3.getKeyBinding(GameSettings.Options.FORCE_UNICODE_FONT);
                        final ScaledResolution llllllllllllllIIlIIIIllIlIllIIII = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
                        final int llllllllllllllIIlIIIIllIlIlIllll = llllllllllllllIIlIIIIllIlIllIIII.getScaledWidth();
                        final int llllllllllllllIIlIIIIllIlIlIlllI = llllllllllllllIIlIIIIllIlIllIIII.getScaledHeight();
                        this.setWorldAndResolution(this.mc, llllllllllllllIIlIIIIllIlIlIllll, llllllllllllllIIlIIIIllIlIlIlllI);
                        break;
                    }
                    break;
                }
                default: {
                    this.field_146450_f.actionPerformed(llllllllllllllIIlIIIIllIlIllIIIl);
                    break;
                }
            }
        }
    }
    
    @Override
    public void initGui() {
        final java.util.List buttonList = this.buttonList;
        final GuiOptionButton field_146455_i = new GuiOptionButton(100, this.width / 2 - 155, this.height - 38, GameSettings.Options.FORCE_UNICODE_FONT, this.game_settings_3.getKeyBinding(GameSettings.Options.FORCE_UNICODE_FONT));
        this.field_146455_i = field_146455_i;
        buttonList.add(field_146455_i);
        final java.util.List buttonList2 = this.buttonList;
        final GuiOptionButton field_146452_r = new GuiOptionButton(6, this.width / 2 - 155 + 160, this.height - 38, I18n.format("gui.done", new Object[0]));
        this.field_146452_r = field_146452_r;
        buttonList2.add(field_146452_r);
        this.field_146450_f = new List(this.mc);
        this.field_146450_f.registerScrollButtons(7, 8);
    }
    
    @Override
    public void drawScreen(final int llllllllllllllIIlIIIIllIlIlIIIll, final int llllllllllllllIIlIIIIllIlIlIIIlI, final float llllllllllllllIIlIIIIllIlIIlllIl) {
        this.field_146450_f.drawScreen(llllllllllllllIIlIIIIllIlIlIIIll, llllllllllllllIIlIIIIllIlIlIIIlI, llllllllllllllIIlIIIIllIlIIlllIl);
        this.drawCenteredString(this.fontRendererObj, I18n.format("options.language", new Object[0]), this.width / 2, 16, 16777215);
        this.drawCenteredString(this.fontRendererObj, String.valueOf(new StringBuilder("(").append(I18n.format("options.languageWarning", new Object[0])).append(")")), this.width / 2, this.height - 56, 8421504);
        super.drawScreen(llllllllllllllIIlIIIIllIlIlIIIll, llllllllllllllIIlIIIIllIlIlIIIlI, llllllllllllllIIlIIIIllIlIIlllIl);
    }
    
    static {
        __OBFID = "CL_00000698";
    }
    
    class List extends GuiSlot
    {
        private final /* synthetic */ Map field_148177_m;
        private final /* synthetic */ java.util.List field_148176_l;
        
        static {
            __OBFID = "CL_00000699";
        }
        
        @Override
        protected void elementClicked(final int llllllllllllllIIIlIllllIllIIIlIl, final boolean llllllllllllllIIIlIllllIllIIIlII, final int llllllllllllllIIIlIllllIllIIIIll, final int llllllllllllllIIIlIllllIllIIIIlI) {
            final Language llllllllllllllIIIlIllllIllIIIIIl = this.field_148177_m.get(this.field_148176_l.get(llllllllllllllIIIlIllllIllIIIlIl));
            GuiLanguage.this.field_146454_h.setCurrentLanguage(llllllllllllllIIIlIllllIllIIIIIl);
            GuiLanguage.this.game_settings_3.language = llllllllllllllIIIlIllllIllIIIIIl.getLanguageCode();
            this.mc.refreshResources();
            GuiLanguage.this.fontRendererObj.setUnicodeFlag(GuiLanguage.this.field_146454_h.isCurrentLocaleUnicode() || GuiLanguage.this.game_settings_3.forceUnicodeFont);
            GuiLanguage.this.fontRendererObj.setBidiFlag(GuiLanguage.this.field_146454_h.isCurrentLanguageBidirectional());
            GuiLanguage.this.field_146452_r.displayString = I18n.format("gui.done", new Object[0]);
            GuiLanguage.this.field_146455_i.displayString = GuiLanguage.this.game_settings_3.getKeyBinding(GameSettings.Options.FORCE_UNICODE_FONT);
            GuiLanguage.this.game_settings_3.saveOptions();
        }
        
        public List(final Minecraft llllllllllllllIIIlIllllIllIlIlII) {
            super(llllllllllllllIIIlIllllIllIlIlII, GuiLanguage.this.width, GuiLanguage.this.height, 32, GuiLanguage.this.height - 65 + 4, 18);
            this.field_148176_l = Lists.newArrayList();
            this.field_148177_m = Maps.newHashMap();
            for (final Language llllllllllllllIIIlIllllIllIlIIlI : GuiLanguage.this.field_146454_h.getLanguages()) {
                this.field_148177_m.put(llllllllllllllIIIlIllllIllIlIIlI.getLanguageCode(), llllllllllllllIIIlIllllIllIlIIlI);
                this.field_148176_l.add(llllllllllllllIIIlIllllIllIlIIlI.getLanguageCode());
            }
        }
        
        @Override
        protected int getSize() {
            return this.field_148176_l.size();
        }
        
        @Override
        protected void drawSlot(final int llllllllllllllIIIlIllllIlIlIllIl, final int llllllllllllllIIIlIllllIlIlIllII, final int llllllllllllllIIIlIllllIlIlIlIll, final int llllllllllllllIIIlIllllIlIlIlIlI, final int llllllllllllllIIIlIllllIlIlIlIIl, final int llllllllllllllIIIlIllllIlIlIlIII) {
            GuiLanguage.this.fontRendererObj.setBidiFlag(true);
            GuiLanguage.this.drawCenteredString(GuiLanguage.this.fontRendererObj, this.field_148177_m.get(this.field_148176_l.get(llllllllllllllIIIlIllllIlIlIllIl)).toString(), this.width / 2, llllllllllllllIIIlIllllIlIlIlIll + 1, 16777215);
            GuiLanguage.this.fontRendererObj.setBidiFlag(GuiLanguage.this.field_146454_h.getCurrentLanguage().isBidirectional());
        }
        
        @Override
        protected void drawBackground() {
            GuiLanguage.this.drawDefaultBackground();
        }
        
        @Override
        protected int getContentHeight() {
            return this.getSize() * 18;
        }
        
        @Override
        protected boolean isSelected(final int llllllllllllllIIIlIllllIlIlllIII) {
            return this.field_148176_l.get(llllllllllllllIIIlIllllIlIlllIII).equals(GuiLanguage.this.field_146454_h.getCurrentLanguage().getLanguageCode());
        }
    }
}
