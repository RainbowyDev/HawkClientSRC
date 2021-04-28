package hawk.ui.clickgui;

import hawk.settings.*;
import com.lukflug.panelstudio.settings.*;
import net.minecraft.util.*;
import hawk.modules.render.*;
import com.lukflug.panelstudio.theme.*;
import com.lukflug.panelstudio.*;
import java.awt.*;

public class SyncableColorComponent extends ColorComponent
{
    public SyncableColorComponent(final Theme lllllllllllllllllIIlIIIlIlllIlII, final ColorSetting lllllllllllllllllIIlIIIlIllIlllI, final Toggleable lllllllllllllllllIIlIIIlIlllIIlI, final Animation lllllllllllllllllIIlIIIlIlllIIIl) {
        super(String.valueOf(new StringBuilder().append(EnumChatFormatting.BOLD).append(lllllllllllllllllIIlIIIlIllIlllI.name)), null, lllllllllllllllllIIlIIIlIlllIlII.getContainerRenderer(), lllllllllllllllllIIlIIIlIlllIIIl, lllllllllllllllllIIlIIIlIlllIlII.getComponentRenderer(), lllllllllllllllllIIlIIIlIllIlllI, true, true, lllllllllllllllllIIlIIIlIlllIIlI);
        if (lllllllllllllllllIIlIIIlIllIlllI != ModToggleGUI.INSTANCE.activeColor) {
            this.addComponent(new SyncButton(lllllllllllllllllIIlIIIlIlllIlII.getComponentRenderer()));
        }
    }
    
    private class SyncButton extends FocusableComponent
    {
        public SyncButton(final Renderer lllllllllllllllIIIIlllIIlIllIIIl) {
            super("Sync Color", null, lllllllllllllllIIIIlllIIlIllIIIl);
        }
        
        @Override
        public void handleButton(final Context lllllllllllllllIIIIlllIIlIlIIIII, final int lllllllllllllllIIIIlllIIlIlIIIlI) {
            super.handleButton(lllllllllllllllIIIIlllIIlIlIIIII, lllllllllllllllIIIIlllIIlIlIIIlI);
            if (lllllllllllllllIIIIlllIIlIlIIIlI == 0 && lllllllllllllllIIIIlllIIlIlIIIII.isClicked()) {
                SyncableColorComponent.this.setting.setValue(ModToggleGUI.INSTANCE.activeColor.getColor());
                SyncableColorComponent.this.setting.setRainbow(ModToggleGUI.INSTANCE.activeColor.getRainbow());
            }
        }
        
        @Override
        public void render(final Context lllllllllllllllIIIIlllIIlIlIlIII) {
            super.render(lllllllllllllllIIIIlllIIlIlIlIII);
            this.renderer.overrideColorScheme(SyncableColorComponent.this.overrideScheme);
            this.renderer.renderTitle(lllllllllllllllIIIIlllIIlIlIlIII, this.title, this.hasFocus(lllllllllllllllIIIIlllIIlIlIlIII), false);
            this.renderer.restoreColorScheme();
        }
    }
}
