package net.minecraft.client.gui;

import net.minecraft.client.settings.*;
import net.minecraft.client.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;

public class GuiOptionSlider extends GuiButton
{
    public /* synthetic */ boolean dragging;
    private final /* synthetic */ float field_146132_r;
    private /* synthetic */ float sliderValue;
    private final /* synthetic */ float field_146131_s;
    private /* synthetic */ GameSettings.Options options;
    
    @Override
    protected void mouseDragged(final Minecraft llllllllllllllIlIlIllIlIlIlIIllI, final int llllllllllllllIlIlIllIlIlIlIIlIl, final int llllllllllllllIlIlIllIlIlIlIlIIl) {
        if (this.visible) {
            if (this.dragging) {
                this.sliderValue = (llllllllllllllIlIlIllIlIlIlIIlIl - (this.xPosition + 4)) / (float)(this.width - 8);
                this.sliderValue = MathHelper.clamp_float(this.sliderValue, 0.0f, 1.0f);
                final float llllllllllllllIlIlIllIlIlIlIlIII = this.options.denormalizeValue(this.sliderValue);
                llllllllllllllIlIlIllIlIlIlIIllI.gameSettings.setOptionFloatValue(this.options, llllllllllllllIlIlIllIlIlIlIlIII);
                this.sliderValue = this.options.normalizeValue(llllllllllllllIlIlIllIlIlIlIlIII);
                this.displayString = llllllllllllllIlIlIllIlIlIlIIllI.gameSettings.getKeyBinding(this.options);
            }
            llllllllllllllIlIlIllIlIlIlIIllI.getTextureManager().bindTexture(GuiOptionSlider.buttonTextures);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.drawTexturedModalRect(this.xPosition + (int)(this.sliderValue * (this.width - 8)), this.yPosition, 0, 66, 4, 20);
            this.drawTexturedModalRect(this.xPosition + (int)(this.sliderValue * (this.width - 8)) + 4, this.yPosition, 196, 66, 4, 20);
        }
    }
    
    public GuiOptionSlider(final int llllllllllllllIlIlIllIlIllIIlllI, final int llllllllllllllIlIlIllIlIllIlIIlI, final int llllllllllllllIlIlIllIlIllIlIIIl, final GameSettings.Options llllllllllllllIlIlIllIlIllIIlIll) {
        this(llllllllllllllIlIlIllIlIllIIlllI, llllllllllllllIlIlIllIlIllIlIIlI, llllllllllllllIlIlIllIlIllIlIIIl, llllllllllllllIlIlIllIlIllIIlIll, 0.0f, 1.0f);
    }
    
    @Override
    public void mouseReleased(final int llllllllllllllIlIlIllIlIlIIlIlIl, final int llllllllllllllIlIlIllIlIlIIlIlII) {
        this.dragging = false;
    }
    
    @Override
    public boolean mousePressed(final Minecraft llllllllllllllIlIlIllIlIlIIllllI, final int llllllllllllllIlIlIllIlIlIIlllIl, final int llllllllllllllIlIlIllIlIlIIllIII) {
        if (super.mousePressed(llllllllllllllIlIlIllIlIlIIllllI, llllllllllllllIlIlIllIlIlIIlllIl, llllllllllllllIlIlIllIlIlIIllIII)) {
            this.sliderValue = (llllllllllllllIlIlIllIlIlIIlllIl - (this.xPosition + 4)) / (float)(this.width - 8);
            this.sliderValue = MathHelper.clamp_float(this.sliderValue, 0.0f, 1.0f);
            llllllllllllllIlIlIllIlIlIIllllI.gameSettings.setOptionFloatValue(this.options, this.options.denormalizeValue(this.sliderValue));
            this.displayString = llllllllllllllIlIlIllIlIlIIllllI.gameSettings.getKeyBinding(this.options);
            this.dragging = true;
            return true;
        }
        return false;
    }
    
    public GuiOptionSlider(final int llllllllllllllIlIlIllIlIlIlllIIl, final int llllllllllllllIlIlIllIlIllIIIIII, final int llllllllllllllIlIlIllIlIlIllIlll, final GameSettings.Options llllllllllllllIlIlIllIlIlIlllllI, final float llllllllllllllIlIlIllIlIlIllIlIl, final float llllllllllllllIlIlIllIlIlIllIlII) {
        super(llllllllllllllIlIlIllIlIlIlllIIl, llllllllllllllIlIlIllIlIllIIIIII, llllllllllllllIlIlIllIlIlIllIlll, 150, 20, "");
        this.sliderValue = 1.0f;
        this.options = llllllllllllllIlIlIllIlIlIlllllI;
        this.field_146132_r = llllllllllllllIlIlIllIlIlIllIlIl;
        this.field_146131_s = llllllllllllllIlIlIllIlIlIllIlII;
        final Minecraft llllllllllllllIlIlIllIlIlIlllIll = Minecraft.getMinecraft();
        this.sliderValue = llllllllllllllIlIlIllIlIlIlllllI.normalizeValue(llllllllllllllIlIlIllIlIlIlllIll.gameSettings.getOptionFloatValue(llllllllllllllIlIlIllIlIlIlllllI));
        this.displayString = llllllllllllllIlIlIllIlIlIlllIll.gameSettings.getKeyBinding(llllllllllllllIlIlIllIlIlIlllllI);
    }
    
    static {
        __OBFID = "CL_00000680";
    }
    
    @Override
    protected int getHoverState(final boolean llllllllllllllIlIlIllIlIlIllIIIl) {
        return 0;
    }
}
