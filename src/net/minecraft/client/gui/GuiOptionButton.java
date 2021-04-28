package net.minecraft.client.gui;

import net.minecraft.client.settings.*;

public class GuiOptionButton extends GuiButton
{
    private final /* synthetic */ GameSettings.Options enumOptions;
    
    public GuiOptionButton(final int llllllllllllllIIllIIIIIIIIIIllIl, final int llllllllllllllIIllIIIIIIIIIIllII, final int llllllllllllllIIllIIIIIIIIIIIlIl, final GameSettings.Options llllllllllllllIIllIIIIIIIIIIlIlI, final String llllllllllllllIIllIIIIIIIIIIlIIl) {
        super(llllllllllllllIIllIIIIIIIIIIllIl, llllllllllllllIIllIIIIIIIIIIllII, llllllllllllllIIllIIIIIIIIIIIlIl, 150, 20, llllllllllllllIIllIIIIIIIIIIlIIl);
        this.enumOptions = llllllllllllllIIllIIIIIIIIIIlIlI;
    }
    
    public GuiOptionButton(final int llllllllllllllIIllIIIIIIIIIllIlI, final int llllllllllllllIIllIIIIIIIIIllIIl, final int llllllllllllllIIllIIIIIIIIIllIII, final int llllllllllllllIIllIIIIIIIIIllllI, final int llllllllllllllIIllIIIIIIIIIlllIl, final String llllllllllllllIIllIIIIIIIIIlllII) {
        super(llllllllllllllIIllIIIIIIIIIllIlI, llllllllllllllIIllIIIIIIIIIllIIl, llllllllllllllIIllIIIIIIIIIllIII, llllllllllllllIIllIIIIIIIIIllllI, llllllllllllllIIllIIIIIIIIIlllIl, llllllllllllllIIllIIIIIIIIIlllII);
        this.enumOptions = null;
    }
    
    static {
        __OBFID = "CL_00000676";
    }
    
    public GameSettings.Options returnEnumOptions() {
        return this.enumOptions;
    }
    
    public GuiOptionButton(final int llllllllllllllIIllIIIIIIIIllIIlI, final int llllllllllllllIIllIIIIIIIIlIllII, final int llllllllllllllIIllIIIIIIIIllIIII, final String llllllllllllllIIllIIIIIIIIlIlIlI) {
        this(llllllllllllllIIllIIIIIIIIllIIlI, llllllllllllllIIllIIIIIIIIlIllII, llllllllllllllIIllIIIIIIIIllIIII, null, llllllllllllllIIllIIIIIIIIlIlIlI);
    }
}
