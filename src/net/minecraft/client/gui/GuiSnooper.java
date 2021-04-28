package net.minecraft.client.gui;

import net.minecraft.client.settings.*;
import net.minecraft.client.resources.*;
import com.google.common.collect.*;
import java.util.*;
import java.io.*;

public class GuiSnooper extends GuiScreen
{
    private /* synthetic */ List field_146606_s;
    private final /* synthetic */ GuiScreen field_146608_a;
    private final /* synthetic */ java.util.List field_146609_h;
    private final /* synthetic */ GameSettings game_settings_2;
    private /* synthetic */ String[] field_146607_r;
    private /* synthetic */ GuiButton field_146605_t;
    private /* synthetic */ String field_146610_i;
    private final /* synthetic */ java.util.List field_146604_g;
    
    @Override
    public void initGui() {
        this.field_146610_i = I18n.format("options.snooper.title", new Object[0]);
        final String lllllllllllllllllIlllllIllllllII = I18n.format("options.snooper.desc", new Object[0]);
        final ArrayList lllllllllllllllllIlllllIlllllIll = Lists.newArrayList();
        for (final String lllllllllllllllllIlllllIlllllIIl : this.fontRendererObj.listFormattedStringToWidth(lllllllllllllllllIlllllIllllllII, this.width - 30)) {
            lllllllllllllllllIlllllIlllllIll.add(lllllllllllllllllIlllllIlllllIIl);
        }
        this.field_146607_r = lllllllllllllllllIlllllIlllllIll.toArray(new String[0]);
        this.field_146604_g.clear();
        this.field_146609_h.clear();
        final java.util.List buttonList = this.buttonList;
        final GuiButton field_146605_t = new GuiButton(1, this.width / 2 - 152, this.height - 30, 150, 20, this.game_settings_2.getKeyBinding(GameSettings.Options.SNOOPER_ENABLED));
        this.field_146605_t = field_146605_t;
        buttonList.add(field_146605_t);
        this.buttonList.add(new GuiButton(2, this.width / 2 + 2, this.height - 30, 150, 20, I18n.format("gui.done", new Object[0])));
        final boolean lllllllllllllllllIlllllIlllllIII = this.mc.getIntegratedServer() != null && this.mc.getIntegratedServer().getPlayerUsageSnooper() != null;
        for (final Map.Entry lllllllllllllllllIlllllIllllIllI : new TreeMap(this.mc.getPlayerUsageSnooper().getCurrentStats()).entrySet()) {
            this.field_146604_g.add(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllllIlllllIlllllIII ? "C " : "")).append(lllllllllllllllllIlllllIllllIllI.getKey())));
            this.field_146609_h.add(this.fontRendererObj.trimStringToWidth(lllllllllllllllllIlllllIllllIllI.getValue(), this.width - 220));
        }
        if (lllllllllllllllllIlllllIlllllIII) {
            for (final Map.Entry lllllllllllllllllIlllllIllllIlIl : new TreeMap(this.mc.getIntegratedServer().getPlayerUsageSnooper().getCurrentStats()).entrySet()) {
                this.field_146604_g.add(String.valueOf(new StringBuilder("S ").append(lllllllllllllllllIlllllIllllIlIl.getKey())));
                this.field_146609_h.add(this.fontRendererObj.trimStringToWidth(lllllllllllllllllIlllllIllllIlIl.getValue(), this.width - 220));
            }
        }
        this.field_146606_s = new List();
    }
    
    @Override
    public void drawScreen(final int lllllllllllllllllIlllllIllIlIIIl, final int lllllllllllllllllIlllllIllIlIIII, final float lllllllllllllllllIlllllIllIllIII) {
        this.drawDefaultBackground();
        this.field_146606_s.drawScreen(lllllllllllllllllIlllllIllIlIIIl, lllllllllllllllllIlllllIllIlIIII, lllllllllllllllllIlllllIllIllIII);
        this.drawCenteredString(this.fontRendererObj, this.field_146610_i, this.width / 2, 8, 16777215);
        int lllllllllllllllllIlllllIllIlIlll = 22;
        for (final String lllllllllllllllllIlllllIllIlIIll : this.field_146607_r) {
            this.drawCenteredString(this.fontRendererObj, lllllllllllllllllIlllllIllIlIIll, this.width / 2, lllllllllllllllllIlllllIllIlIlll, 8421504);
            lllllllllllllllllIlllllIllIlIlll += this.fontRendererObj.FONT_HEIGHT;
        }
        super.drawScreen(lllllllllllllllllIlllllIllIlIIIl, lllllllllllllllllIlllllIllIlIIII, lllllllllllllllllIlllllIllIllIII);
    }
    
    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.field_146606_s.func_178039_p();
    }
    
    static {
        __OBFID = "CL_00000714";
    }
    
    public GuiSnooper(final GuiScreen lllllllllllllllllIllllllIIIIIllI, final GameSettings lllllllllllllllllIllllllIIIIIlIl) {
        this.field_146604_g = Lists.newArrayList();
        this.field_146609_h = Lists.newArrayList();
        this.field_146608_a = lllllllllllllllllIllllllIIIIIllI;
        this.game_settings_2 = lllllllllllllllllIllllllIIIIIlIl;
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllllllIlllllIlllIIlll) throws IOException {
        if (lllllllllllllllllIlllllIlllIIlll.enabled) {
            if (lllllllllllllllllIlllllIlllIIlll.id == 2) {
                this.game_settings_2.saveOptions();
                this.game_settings_2.saveOptions();
                this.mc.displayGuiScreen(this.field_146608_a);
            }
            if (lllllllllllllllllIlllllIlllIIlll.id == 1) {
                this.game_settings_2.setOptionValue(GameSettings.Options.SNOOPER_ENABLED, 1);
                this.field_146605_t.displayString = this.game_settings_2.getKeyBinding(GameSettings.Options.SNOOPER_ENABLED);
            }
        }
    }
    
    class List extends GuiSlot
    {
        @Override
        protected boolean isSelected(final int lllllllllllllllIIlIlIlIlIIIIIIII) {
            return false;
        }
        
        static {
            __OBFID = "CL_00000715";
        }
        
        @Override
        protected void drawBackground() {
        }
        
        @Override
        protected int getSize() {
            return GuiSnooper.this.field_146604_g.size();
        }
        
        public List() {
            super(GuiSnooper.this.mc, GuiSnooper.this.width, GuiSnooper.this.height, 80, GuiSnooper.this.height - 40, GuiSnooper.this.fontRendererObj.FONT_HEIGHT + 1);
        }
        
        @Override
        protected void drawSlot(final int lllllllllllllllIIlIlIlIIllllIIll, final int lllllllllllllllIIlIlIlIIlllllIIl, final int lllllllllllllllIIlIlIlIIllllIIlI, final int lllllllllllllllIIlIlIlIIllllIlll, final int lllllllllllllllIIlIlIlIIllllIllI, final int lllllllllllllllIIlIlIlIIllllIlIl) {
            GuiSnooper.this.fontRendererObj.drawString(GuiSnooper.this.field_146604_g.get(lllllllllllllllIIlIlIlIIllllIIll), 10.0, lllllllllllllllIIlIlIlIIllllIIlI, 16777215);
            GuiSnooper.this.fontRendererObj.drawString(GuiSnooper.this.field_146609_h.get(lllllllllllllllIIlIlIlIIllllIIll), 230.0, lllllllllllllllIIlIlIlIIllllIIlI, 16777215);
        }
        
        @Override
        protected void elementClicked(final int lllllllllllllllIIlIlIlIlIIIIIlIl, final boolean lllllllllllllllIIlIlIlIlIIIIIlII, final int lllllllllllllllIIlIlIlIlIIIIIIll, final int lllllllllllllllIIlIlIlIlIIIIIIlI) {
        }
        
        @Override
        protected int getScrollBarX() {
            return this.width - 10;
        }
    }
}
