package hawk.ui.clickgui;

import com.lukflug.panelstudio.settings.*;
import hawk.modules.render.*;

public class ColorToggleUtil implements Toggleable
{
    @Override
    public boolean isOn() {
        return ModToggleGUI.INSTANCE.colorModel.is("RGB");
    }
    
    @Override
    public void toggle() {
    }
}
