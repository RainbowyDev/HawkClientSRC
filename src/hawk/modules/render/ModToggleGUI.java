package hawk.modules.render;

import hawk.modules.*;
import hawk.util.*;
import hawk.settings.*;
import hawk.ui.clickgui.*;

public class ModToggleGUI extends Module
{
    public /* synthetic */ ColorSetting inactiveColor;
    public /* synthetic */ ColorSetting settingBackgroundColor;
    public /* synthetic */ ColorSetting fontColor;
    public /* synthetic */ ModeSetting colorModel;
    public /* synthetic */ NumberSetting animationSpeed;
    public /* synthetic */ ColorSetting activeColor;
    public static /* synthetic */ ModToggleGUI INSTANCE;
    public /* synthetic */ ColorSetting outlineColor;
    public /* synthetic */ NumberSetting opacity;
    public /* synthetic */ ColorSetting backgroundColor;
    
    public ModToggleGUI() {
        super("ClickGUI", 54, Category.RENDER);
        this.animationSpeed = new NumberSetting("Animation Speed", 200.0, 10.0, 500.0, 10.0, this);
        this.fontColor = new ColorSetting("fontColor", new JColor(214, 215, 220, 255));
        this.outlineColor = new ColorSetting("Outline Color", new JColor(28, 28, 28, 255));
        this.opacity = new NumberSetting("Opacity", 255.0, 0.0, 255.0, 10.0, this);
        this.backgroundColor = new ColorSetting("Background", new JColor(35, 39, 42, 255));
        this.activeColor = new ColorSetting("enabledColor", new JColor(114, 137, 218, 255));
        this.inactiveColor = new ColorSetting("Disabled Color", new JColor(255, 255, 255, 255));
        this.settingBackgroundColor = new ColorSetting("settinBgColor", new JColor(54, 57, 63, 255));
        this.colorModel = new ModeSetting("Color Model", this, "RGB", new String[] { "RGB", "HSB" });
        this.addSettings(this.animationSpeed, this.fontColor, this.outlineColor, this.opacity, this.backgroundColor, this.activeColor, this.inactiveColor, this.settingBackgroundColor);
    }
    
    @Override
    public void onEnable() {
        HawkClickGUI.instance.enterGUI();
        this.toggle();
    }
    
    static {
        ModToggleGUI.INSTANCE = new ModToggleGUI();
    }
}
