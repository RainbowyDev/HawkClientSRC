package net.minecraft.client.gui;

import net.minecraft.util.*;
import net.minecraft.client.audio.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;

public class GuiButton extends Gui
{
    public /* synthetic */ String displayString;
    protected /* synthetic */ int width;
    public /* synthetic */ int id;
    protected /* synthetic */ boolean hovered;
    public /* synthetic */ boolean enabled;
    protected static final /* synthetic */ ResourceLocation buttonTextures;
    public /* synthetic */ boolean visible;
    protected /* synthetic */ int height;
    public /* synthetic */ int yPosition;
    public /* synthetic */ int xPosition;
    
    public void playPressSound(final SoundHandler lllllllllllllllIlIlIllIIIIIllIll) {
        lllllllllllllllIlIlIllIIIIIllIll.playSound(PositionedSoundRecord.createPositionedSoundRecord(new ResourceLocation("gui.button.press"), 1.0f));
    }
    
    public void drawButtonForegroundLayer(final int lllllllllllllllIlIlIllIIIIIlllll, final int lllllllllllllllIlIlIllIIIIIllllI) {
    }
    
    protected void mouseDragged(final Minecraft lllllllllllllllIlIlIllIIIIllIIll, final int lllllllllllllllIlIlIllIIIIllIIlI, final int lllllllllllllllIlIlIllIIIIllIIIl) {
    }
    
    public GuiButton(final int lllllllllllllllIlIlIllIIIllIlIll, final int lllllllllllllllIlIlIllIIIllIllll, final int lllllllllllllllIlIlIllIIIllIlIIl, final String lllllllllllllllIlIlIllIIIllIlIII) {
        this(lllllllllllllllIlIlIllIIIllIlIll, lllllllllllllllIlIlIllIIIllIllll, lllllllllllllllIlIlIllIIIllIlIIl, 200, 20, lllllllllllllllIlIlIllIIIllIlIII);
    }
    
    public int getButtonWidth() {
        return this.width;
    }
    
    protected int getHoverState(final boolean lllllllllllllllIlIlIllIIIlIIlIll) {
        byte lllllllllllllllIlIlIllIIIlIIllIl = 1;
        if (!this.enabled) {
            lllllllllllllllIlIlIllIIIlIIllIl = 0;
        }
        else if (lllllllllllllllIlIlIllIIIlIIlIll) {
            lllllllllllllllIlIlIllIIIlIIllIl = 2;
        }
        return lllllllllllllllIlIlIllIIIlIIllIl;
    }
    
    public void mouseReleased(final int lllllllllllllllIlIlIllIIIIlIllll, final int lllllllllllllllIlIlIllIIIIlIlllI) {
    }
    
    public GuiButton(final int lllllllllllllllIlIlIllIIIlIlllll, final int lllllllllllllllIlIlIllIIIlIllllI, final int lllllllllllllllIlIlIllIIIlIlllIl, final int lllllllllllllllIlIlIllIIIlIlIlIl, final int lllllllllllllllIlIlIllIIIlIllIll, final String lllllllllllllllIlIlIllIIIlIllIlI) {
        this.width = 200;
        this.height = 20;
        this.enabled = true;
        this.visible = true;
        this.id = lllllllllllllllIlIlIllIIIlIlllll;
        this.xPosition = lllllllllllllllIlIlIllIIIlIllllI;
        this.yPosition = lllllllllllllllIlIlIllIIIlIlllIl;
        this.width = lllllllllllllllIlIlIllIIIlIlIlIl;
        this.height = lllllllllllllllIlIlIllIIIlIllIll;
        this.displayString = lllllllllllllllIlIlIllIIIlIllIlI;
    }
    
    static {
        __OBFID = "CL_00000668";
        buttonTextures = new ResourceLocation("textures/gui/widgets.png");
    }
    
    public void func_175211_a(final int lllllllllllllllIlIlIllIIIIIlIIll) {
        this.width = lllllllllllllllIlIlIllIIIIIlIIll;
    }
    
    public boolean mousePressed(final Minecraft lllllllllllllllIlIlIllIIIIlIlIIl, final int lllllllllllllllIlIlIllIIIIlIlIII, final int lllllllllllllllIlIlIllIIIIlIIlII) {
        return this.enabled && this.visible && lllllllllllllllIlIlIllIIIIlIlIII >= this.xPosition && lllllllllllllllIlIlIllIIIIlIIlII >= this.yPosition && lllllllllllllllIlIlIllIIIIlIlIII < this.xPosition + this.width && lllllllllllllllIlIlIllIIIIlIIlII < this.yPosition + this.height;
    }
    
    public void drawButton(final Minecraft lllllllllllllllIlIlIllIIIIlllIlI, final int lllllllllllllllIlIlIllIIIlIIIIII, final int lllllllllllllllIlIlIllIIIIllllll) {
        if (this.visible) {
            final FontRenderer lllllllllllllllIlIlIllIIIIlllllI = lllllllllllllllIlIlIllIIIIlllIlI.fontRendererObj;
            lllllllllllllllIlIlIllIIIIlllIlI.getTextureManager().bindTexture(GuiButton.buttonTextures);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.hovered = (lllllllllllllllIlIlIllIIIlIIIIII >= this.xPosition && lllllllllllllllIlIlIllIIIIllllll >= this.yPosition && lllllllllllllllIlIlIllIIIlIIIIII < this.xPosition + this.width && lllllllllllllllIlIlIllIIIIllllll < this.yPosition + this.height);
            final int lllllllllllllllIlIlIllIIIIllllIl = this.getHoverState(this.hovered);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            GlStateManager.blendFunc(770, 771);
            this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 46 + lllllllllllllllIlIlIllIIIIllllIl * 20, this.width / 2, this.height);
            this.drawTexturedModalRect(this.xPosition + this.width / 2, this.yPosition, 200 - this.width / 2, 46 + lllllllllllllllIlIlIllIIIIllllIl * 20, this.width / 2, this.height);
            this.mouseDragged(lllllllllllllllIlIlIllIIIIlllIlI, lllllllllllllllIlIlIllIIIlIIIIII, lllllllllllllllIlIlIllIIIIllllll);
            int lllllllllllllllIlIlIllIIIIllllII = 14737632;
            if (!this.enabled) {
                lllllllllllllllIlIlIllIIIIllllII = 10526880;
            }
            else if (this.hovered) {
                lllllllllllllllIlIlIllIIIIllllII = 16777120;
            }
            this.drawCenteredString(lllllllllllllllIlIlIllIIIIlllllI, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, lllllllllllllllIlIlIllIIIIllllII);
        }
    }
    
    public boolean isMouseOver() {
        return this.hovered;
    }
}
