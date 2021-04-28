package net.minecraft.client.gui;

import net.minecraft.client.*;
import net.minecraft.client.renderer.*;

public class GuiLockIconButton extends GuiButton
{
    private /* synthetic */ boolean field_175231_o;
    
    public boolean func_175230_c() {
        return this.field_175231_o;
    }
    
    public GuiLockIconButton(final int lllllllllllllllIIllllIlllIllIlIl, final int lllllllllllllllIIllllIlllIllIlII, final int lllllllllllllllIIllllIlllIlIllll) {
        super(lllllllllllllllIIllllIlllIllIlIl, lllllllllllllllIIllllIlllIllIlII, lllllllllllllllIIllllIlllIlIllll, 20, 20, "");
        this.field_175231_o = false;
    }
    
    public void func_175229_b(final boolean lllllllllllllllIIllllIlllIlIlIII) {
        this.field_175231_o = lllllllllllllllIIllllIlllIlIlIII;
    }
    
    static {
        __OBFID = "CL_00001952";
    }
    
    @Override
    public void drawButton(final Minecraft lllllllllllllllIIllllIlllIIllllI, final int lllllllllllllllIIllllIlllIIlIIlI, final int lllllllllllllllIIllllIlllIIlIIIl) {
        if (this.visible) {
            lllllllllllllllIIllllIlllIIllllI.getTextureManager().bindTexture(GuiButton.buttonTextures);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            final boolean lllllllllllllllIIllllIlllIIllIll = lllllllllllllllIIllllIlllIIlIIlI >= this.xPosition && lllllllllllllllIIllllIlllIIlIIIl >= this.yPosition && lllllllllllllllIIllllIlllIIlIIlI < this.xPosition + this.width && lllllllllllllllIIllllIlllIIlIIIl < this.yPosition + this.height;
            Icon lllllllllllllllIIllllIlllIIlIlIl = null;
            if (this.field_175231_o) {
                if (!this.enabled) {
                    final Icon lllllllllllllllIIllllIlllIIllIlI = Icon.LOCKED_DISABLED;
                }
                else if (lllllllllllllllIIllllIlllIIllIll) {
                    final Icon lllllllllllllllIIllllIlllIIllIIl = Icon.LOCKED_HOVER;
                }
                else {
                    final Icon lllllllllllllllIIllllIlllIIllIII = Icon.LOCKED;
                }
            }
            else if (!this.enabled) {
                final Icon lllllllllllllllIIllllIlllIIlIlll = Icon.UNLOCKED_DISABLED;
            }
            else if (lllllllllllllllIIllllIlllIIllIll) {
                final Icon lllllllllllllllIIllllIlllIIlIllI = Icon.UNLOCKED_HOVER;
            }
            else {
                lllllllllllllllIIllllIlllIIlIlIl = Icon.UNLOCKED;
            }
            this.drawTexturedModalRect(this.xPosition, this.yPosition, lllllllllllllllIIllllIlllIIlIlIl.func_178910_a(), lllllllllllllllIIllllIlllIIlIlIl.func_178912_b(), this.width, this.height);
        }
    }
    
    enum Icon
    {
        UNLOCKED_DISABLED("UNLOCKED_DISABLED", 5, "UNLOCKED_DISABLED", 5, 20, 186), 
        LOCKED("LOCKED", 0, "LOCKED", 0, 0, 146), 
        LOCKED_HOVER("LOCKED_HOVER", 1, "LOCKED_HOVER", 1, 0, 166), 
        UNLOCKED("UNLOCKED", 3, "UNLOCKED", 3, 20, 146);
        
        private final /* synthetic */ int field_178920_h;
        
        LOCKED_DISABLED("LOCKED_DISABLED", 2, "LOCKED_DISABLED", 2, 0, 186);
        
        private final /* synthetic */ int field_178914_g;
        
        UNLOCKED_HOVER("UNLOCKED_HOVER", 4, "UNLOCKED_HOVER", 4, 20, 166);
        
        public int func_178912_b() {
            return this.field_178920_h;
        }
        
        static {
            __OBFID = "CL_00001951";
        }
        
        public int func_178910_a() {
            return this.field_178914_g;
        }
        
        private Icon(final String llllllllllllllIIIIIlIllIlIIIllII, final int llllllllllllllIIIIIlIllIlIIIlIll, final String llllllllllllllIIIIIlIllIlIIlIIIl, final int llllllllllllllIIIIIlIllIlIIlIIII, final int llllllllllllllIIIIIlIllIlIIIlIlI, final int llllllllllllllIIIIIlIllIlIIIlIIl) {
            this.field_178914_g = llllllllllllllIIIIIlIllIlIIIlIlI;
            this.field_178920_h = llllllllllllllIIIIIlIllIlIIIlIIl;
        }
    }
}
