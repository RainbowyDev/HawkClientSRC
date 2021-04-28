package net.minecraft.client.gui;

import net.minecraft.client.settings.*;
import java.io.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.*;
import net.minecraft.client.audio.*;

public class GuiScreenOptionsSounds extends GuiScreen
{
    private final /* synthetic */ GameSettings game_settings_4;
    protected /* synthetic */ String field_146507_a;
    private /* synthetic */ String field_146508_h;
    private final /* synthetic */ GuiScreen field_146505_f;
    
    protected String getSoundVolume(final SoundCategory lllllllllllllllIIIIIIIIIlllIlIIl) {
        final float lllllllllllllllIIIIIIIIIlllIlIll = this.game_settings_4.getSoundLevel(lllllllllllllllIIIIIIIIIlllIlIIl);
        return (lllllllllllllllIIIIIIIIIlllIlIll == 0.0f) ? this.field_146508_h : String.valueOf(new StringBuilder(String.valueOf((int)(lllllllllllllllIIIIIIIIIlllIlIll * 100.0f))).append("%"));
    }
    
    static {
        __OBFID = "CL_00000716";
    }
    
    @Override
    public void drawScreen(final int lllllllllllllllIIIIIIIIIllllIIll, final int lllllllllllllllIIIIIIIIIllllIIlI, final float lllllllllllllllIIIIIIIIIllllIIIl) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, this.field_146507_a, this.width / 2, 15, 16777215);
        super.drawScreen(lllllllllllllllIIIIIIIIIllllIIll, lllllllllllllllIIIIIIIIIllllIIlI, lllllllllllllllIIIIIIIIIllllIIIl);
    }
    
    public GuiScreenOptionsSounds(final GuiScreen lllllllllllllllIIIIIIIIlIIIllIIl, final GameSettings lllllllllllllllIIIIIIIIlIIIllIII) {
        this.field_146507_a = "Options";
        this.field_146505_f = lllllllllllllllIIIIIIIIlIIIllIIl;
        this.game_settings_4 = lllllllllllllllIIIIIIIIlIIIllIII;
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllllIIIIIIIIIllllllIl) throws IOException {
        if (lllllllllllllllIIIIIIIIIllllllIl.enabled && lllllllllllllllIIIIIIIIIllllllIl.id == 200) {
            this.mc.gameSettings.saveOptions();
            this.mc.displayGuiScreen(this.field_146505_f);
        }
    }
    
    @Override
    public void initGui() {
        final byte lllllllllllllllIIIIIIIIlIIIIllll = 0;
        this.field_146507_a = I18n.format("options.sounds.title", new Object[0]);
        this.field_146508_h = I18n.format("options.off", new Object[0]);
        this.buttonList.add(new Button(SoundCategory.MASTER.getCategoryId(), this.width / 2 - 155 + lllllllllllllllIIIIIIIIlIIIIllll % 2 * 160, this.height / 6 - 12 + 24 * (lllllllllllllllIIIIIIIIlIIIIllll >> 1), SoundCategory.MASTER, true));
        int lllllllllllllllIIIIIIIIlIIIIlllI = lllllllllllllllIIIIIIIIlIIIIllll + 2;
        for (final SoundCategory lllllllllllllllIIIIIIIIlIIIIlIlI : SoundCategory.values()) {
            if (lllllllllllllllIIIIIIIIlIIIIlIlI != SoundCategory.MASTER) {
                this.buttonList.add(new Button(lllllllllllllllIIIIIIIIlIIIIlIlI.getCategoryId(), this.width / 2 - 155 + lllllllllllllllIIIIIIIIlIIIIlllI % 2 * 160, this.height / 6 - 12 + 24 * (lllllllllllllllIIIIIIIIlIIIIlllI >> 1), lllllllllllllllIIIIIIIIlIIIIlIlI, false));
                ++lllllllllllllllIIIIIIIIlIIIIlllI;
            }
        }
        this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 168, I18n.format("gui.done", new Object[0])));
    }
    
    class Button extends GuiButton
    {
        private final /* synthetic */ String field_146152_s;
        public /* synthetic */ boolean field_146155_p;
        public /* synthetic */ float field_146156_o;
        private final /* synthetic */ SoundCategory field_146153_r;
        
        @Override
        public boolean mousePressed(final Minecraft lllllllllllllllIIlIIIIlIllIlIlll, final int lllllllllllllllIIlIIIIlIllIlIlIl, final int lllllllllllllllIIlIIIIlIllIlIIll) {
            if (super.mousePressed(lllllllllllllllIIlIIIIlIllIlIlll, lllllllllllllllIIlIIIIlIllIlIlIl, lllllllllllllllIIlIIIIlIllIlIIll)) {
                this.field_146156_o = (lllllllllllllllIIlIIIIlIllIlIlIl - (this.xPosition + 4)) / (float)(this.width - 8);
                this.field_146156_o = MathHelper.clamp_float(this.field_146156_o, 0.0f, 1.0f);
                lllllllllllllllIIlIIIIlIllIlIlll.gameSettings.setSoundLevel(this.field_146153_r, this.field_146156_o);
                lllllllllllllllIIlIIIIlIllIlIlll.gameSettings.saveOptions();
                this.displayString = String.valueOf(new StringBuilder(String.valueOf(this.field_146152_s)).append(": ").append(GuiScreenOptionsSounds.this.getSoundVolume(this.field_146153_r)));
                this.field_146155_p = true;
                return true;
            }
            return false;
        }
        
        @Override
        protected void mouseDragged(final Minecraft lllllllllllllllIIlIIIIlIlllIIIlI, final int lllllllllllllllIIlIIIIlIlllIIIIl, final int lllllllllllllllIIlIIIIlIlllIIllI) {
            if (this.visible) {
                if (this.field_146155_p) {
                    this.field_146156_o = (lllllllllllllllIIlIIIIlIlllIIIIl - (this.xPosition + 4)) / (float)(this.width - 8);
                    this.field_146156_o = MathHelper.clamp_float(this.field_146156_o, 0.0f, 1.0f);
                    lllllllllllllllIIlIIIIlIlllIIIlI.gameSettings.setSoundLevel(this.field_146153_r, this.field_146156_o);
                    lllllllllllllllIIlIIIIlIlllIIIlI.gameSettings.saveOptions();
                    this.displayString = String.valueOf(new StringBuilder(String.valueOf(this.field_146152_s)).append(": ").append(GuiScreenOptionsSounds.this.getSoundVolume(this.field_146153_r)));
                }
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                this.drawTexturedModalRect(this.xPosition + (int)(this.field_146156_o * (this.width - 8)), this.yPosition, 0, 66, 4, 20);
                this.drawTexturedModalRect(this.xPosition + (int)(this.field_146156_o * (this.width - 8)) + 4, this.yPosition, 196, 66, 4, 20);
            }
        }
        
        @Override
        public void mouseReleased(final int lllllllllllllllIIlIIIIlIlIllIlII, final int lllllllllllllllIIlIIIIlIlIllIIll) {
            if (this.field_146155_p) {
                if (this.field_146153_r == SoundCategory.MASTER) {
                    final short lllllllllllllllIIlIIIIlIlIllIIIl = (short)1.0f;
                }
                else {
                    GuiScreenOptionsSounds.this.game_settings_4.getSoundLevel(this.field_146153_r);
                }
                GuiScreenOptionsSounds.this.mc.getSoundHandler().playSound(PositionedSoundRecord.createPositionedSoundRecord(new ResourceLocation("gui.button.press"), 1.0f));
            }
            this.field_146155_p = false;
        }
        
        public Button(final int lllllllllllllllIIlIIIIllIIlIIIII, final int lllllllllllllllIIlIIIIllIIIllllI, final int lllllllllllllllIIlIIIIllIIIlllIl, final SoundCategory lllllllllllllllIIlIIIIllIIIIllIl, final boolean lllllllllllllllIIlIIIIllIIIllIIl) {
            super(lllllllllllllllIIlIIIIllIIlIIIII, lllllllllllllllIIlIIIIllIIIllllI, lllllllllllllllIIlIIIIllIIIlllIl, lllllllllllllllIIlIIIIllIIIllIIl ? 310 : 150, 20, "");
            this.field_146156_o = 1.0f;
            this.field_146153_r = lllllllllllllllIIlIIIIllIIIIllIl;
            this.field_146152_s = I18n.format(String.valueOf(new StringBuilder("soundCategory.").append(lllllllllllllllIIlIIIIllIIIIllIl.getCategoryName())), new Object[0]);
            this.displayString = String.valueOf(new StringBuilder(String.valueOf(this.field_146152_s)).append(": ").append(GuiScreenOptionsSounds.this.getSoundVolume(lllllllllllllllIIlIIIIllIIIIllIl)));
            this.field_146156_o = GuiScreenOptionsSounds.this.game_settings_4.getSoundLevel(lllllllllllllllIIlIIIIllIIIIllIl);
        }
        
        @Override
        public void playPressSound(final SoundHandler lllllllllllllllIIlIIIIlIllIIIlll) {
        }
        
        @Override
        protected int getHoverState(final boolean lllllllllllllllIIlIIIIllIIIIIlIl) {
            return 0;
        }
        
        static {
            __OBFID = "CL_00000717";
        }
    }
}
