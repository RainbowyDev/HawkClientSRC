package net.minecraft.client.gui;

import net.minecraft.client.*;
import net.minecraft.client.renderer.*;

public class GuiButtonLanguage extends GuiButton
{
    @Override
    public void drawButton(final Minecraft lllllllllllllllIlIlIIllIIlIIllIl, final int lllllllllllllllIlIlIIllIIlIIllII, final int lllllllllllllllIlIlIIllIIlIlIIIl) {
        if (this.visible) {
            lllllllllllllllIlIlIIllIIlIIllIl.getTextureManager().bindTexture(GuiButton.buttonTextures);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            final boolean lllllllllllllllIlIlIIllIIlIlIIII = lllllllllllllllIlIlIIllIIlIIllII >= this.xPosition && lllllllllllllllIlIlIIllIIlIlIIIl >= this.yPosition && lllllllllllllllIlIlIIllIIlIIllII < this.xPosition + this.width && lllllllllllllllIlIlIIllIIlIlIIIl < this.yPosition + this.height;
            int lllllllllllllllIlIlIIllIIlIIllll = 106;
            if (lllllllllllllllIlIlIIllIIlIlIIII) {
                lllllllllllllllIlIlIIllIIlIIllll += this.height;
            }
            this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, lllllllllllllllIlIlIIllIIlIIllll, this.width, this.height);
        }
    }
    
    static {
        __OBFID = "CL_00000672";
    }
    
    public GuiButtonLanguage(final int lllllllllllllllIlIlIIllIIlIlllIl, final int lllllllllllllllIlIlIIllIIlIlllII, final int lllllllllllllllIlIlIIllIIlIlllll) {
        super(lllllllllllllllIlIlIIllIIlIlllIl, lllllllllllllllIlIlIIllIIlIlllII, lllllllllllllllIlIlIIllIIlIlllll, 20, 20, "");
    }
}
