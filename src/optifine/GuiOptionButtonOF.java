package optifine;

import net.minecraft.client.gui.*;
import net.minecraft.client.settings.*;

public class GuiOptionButtonOF extends GuiOptionButton implements IOptionControl
{
    private /* synthetic */ GameSettings.Options option;
    
    @Override
    public GameSettings.Options getOption() {
        return this.option;
    }
    
    public GuiOptionButtonOF(final int lllllllllllllllIIlllIIllIIlllIll, final int lllllllllllllllIIlllIIllIIllIlII, final int lllllllllllllllIIlllIIllIIllIIll, final GameSettings.Options lllllllllllllllIIlllIIllIIllIIlI, final String lllllllllllllllIIlllIIllIIllIIIl) {
        super(lllllllllllllllIIlllIIllIIlllIll, lllllllllllllllIIlllIIllIIllIlII, lllllllllllllllIIlllIIllIIllIIll, lllllllllllllllIIlllIIllIIllIIlI, lllllllllllllllIIlllIIllIIllIIIl);
        this.option = null;
        this.option = lllllllllllllllIIlllIIllIIllIIlI;
    }
}
