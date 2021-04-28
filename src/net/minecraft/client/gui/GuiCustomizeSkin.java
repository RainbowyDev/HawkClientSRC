package net.minecraft.client.gui;

import net.minecraft.client.resources.*;
import net.minecraft.entity.player.*;
import java.io.*;

public class GuiCustomizeSkin extends GuiScreen
{
    private final /* synthetic */ GuiScreen field_175361_a;
    private /* synthetic */ String field_175360_f;
    
    public GuiCustomizeSkin(final GuiScreen lllllllllllllllIlIlIIlIIIIIllIll) {
        this.field_175361_a = lllllllllllllllIlIlIIlIIIIIllIll;
    }
    
    @Override
    public void initGui() {
        int lllllllllllllllIlIlIIlIIIIIlIIll = 0;
        this.field_175360_f = I18n.format("options.skinCustomisation.title", new Object[0]);
        for (final EnumPlayerModelParts lllllllllllllllIlIlIIlIIIIIIllll : EnumPlayerModelParts.values()) {
            this.buttonList.add(new ButtonPart(lllllllllllllllIlIlIIlIIIIIIllll.func_179328_b(), this.width / 2 - 155 + lllllllllllllllIlIlIIlIIIIIlIIll % 2 * 160, this.height / 6 + 24 * (lllllllllllllllIlIlIIlIIIIIlIIll >> 1), 150, 20, lllllllllllllllIlIlIIlIIIIIIllll, null));
            ++lllllllllllllllIlIlIIlIIIIIlIIll;
        }
        if (lllllllllllllllIlIlIIlIIIIIlIIll % 2 == 1) {
            ++lllllllllllllllIlIlIIlIIIIIlIIll;
        }
        this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 24 * (lllllllllllllllIlIlIIlIIIIIlIIll >> 1), I18n.format("gui.done", new Object[0])));
    }
    
    @Override
    public void drawScreen(final int lllllllllllllllIlIlIIIlllllllIlI, final int lllllllllllllllIlIlIIIlllllllIIl, final float lllllllllllllllIlIlIIIllllllIlII) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, this.field_175360_f, this.width / 2, 20, 16777215);
        super.drawScreen(lllllllllllllllIlIlIIIlllllllIlI, lllllllllllllllIlIlIIIlllllllIIl, lllllllllllllllIlIlIIIllllllIlII);
    }
    
    private String func_175358_a(final EnumPlayerModelParts lllllllllllllllIlIlIIIlllllIlIll) {
        String lllllllllllllllIlIlIIIlllllIllIl = null;
        if (this.mc.gameSettings.func_178876_d().contains(lllllllllllllllIlIlIIIlllllIlIll)) {
            final String lllllllllllllllIlIlIIIlllllIlllI = I18n.format("options.on", new Object[0]);
        }
        else {
            lllllllllllllllIlIlIIIlllllIllIl = I18n.format("options.off", new Object[0]);
        }
        return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIlIIIlllllIlIll.func_179326_d().getFormattedText())).append(": ").append(lllllllllllllllIlIlIIIlllllIllIl));
    }
    
    static {
        __OBFID = "CL_00001932";
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllllIlIlIIlIIIIIIIIIl) throws IOException {
        if (lllllllllllllllIlIlIIlIIIIIIIIIl.enabled) {
            if (lllllllllllllllIlIlIIlIIIIIIIIIl.id == 200) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(this.field_175361_a);
            }
            else if (lllllllllllllllIlIlIIlIIIIIIIIIl instanceof ButtonPart) {
                final EnumPlayerModelParts lllllllllllllllIlIlIIlIIIIIIIIll = ((ButtonPart)lllllllllllllllIlIlIIlIIIIIIIIIl).field_175234_p;
                this.mc.gameSettings.func_178877_a(lllllllllllllllIlIlIIlIIIIIIIIll);
                lllllllllllllllIlIlIIlIIIIIIIIIl.displayString = this.func_175358_a(lllllllllllllllIlIlIIlIIIIIIIIll);
            }
        }
    }
    
    class ButtonPart extends GuiButton
    {
        private final /* synthetic */ EnumPlayerModelParts field_175234_p;
        
        static {
            __OBFID = "CL_00001930";
        }
        
        ButtonPart(final GuiCustomizeSkin llllllllllllllIIIIIllIlIllIlIIll, final int llllllllllllllIIIIIllIlIllIllIll, final int llllllllllllllIIIIIllIlIllIlIIIl, final int llllllllllllllIIIIIllIlIllIlIIII, final int llllllllllllllIIIIIllIlIllIllIII, final int llllllllllllllIIIIIllIlIllIIlllI, final EnumPlayerModelParts llllllllllllllIIIIIllIlIllIlIllI, final Object llllllllllllllIIIIIllIlIllIlIlIl) {
            this(llllllllllllllIIIIIllIlIllIlIIll, llllllllllllllIIIIIllIlIllIllIll, llllllllllllllIIIIIllIlIllIlIIIl, llllllllllllllIIIIIllIlIllIlIIII, llllllllllllllIIIIIllIlIllIllIII, llllllllllllllIIIIIllIlIllIIlllI, llllllllllllllIIIIIllIlIllIlIllI);
        }
        
        private ButtonPart(final int llllllllllllllIIIIIllIlIlllIlIlI, final int llllllllllllllIIIIIllIlIllllIIIl, final int llllllllllllllIIIIIllIlIlllIlIII, final int llllllllllllllIIIIIllIlIlllIIlll, final int llllllllllllllIIIIIllIlIlllIlllI, final EnumPlayerModelParts llllllllllllllIIIIIllIlIlllIllIl) {
            super(llllllllllllllIIIIIllIlIlllIlIlI, llllllllllllllIIIIIllIlIllllIIIl, llllllllllllllIIIIIllIlIlllIlIII, llllllllllllllIIIIIllIlIlllIIlll, llllllllllllllIIIIIllIlIlllIlllI, GuiCustomizeSkin.this.func_175358_a(llllllllllllllIIIIIllIlIlllIllIl));
            this.field_175234_p = llllllllllllllIIIIIllIlIlllIllIl;
        }
    }
}
