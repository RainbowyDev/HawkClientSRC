package optifine;

import net.minecraft.client.gui.*;
import net.minecraft.client.settings.*;

public class GuiOptionSliderOF extends GuiOptionSlider implements IOptionControl
{
    private /* synthetic */ GameSettings.Options option;
    
    @Override
    public GameSettings.Options getOption() {
        return this.option;
    }
    
    public GuiOptionSliderOF(final int lIlllIIIllllII, final int lIlllIIIllIllI, final int lIlllIIIllIlIl, final GameSettings.Options lIlllIIIlllIIl) {
        super(lIlllIIIllllII, lIlllIIIllIllI, lIlllIIIllIlIl, lIlllIIIlllIIl);
        this.option = null;
        this.option = lIlllIIIlllIIl;
    }
}
