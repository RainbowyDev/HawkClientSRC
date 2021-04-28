package hawk.ui.clickgui;

import com.lukflug.panelstudio.mc8forge.*;
import hawk.modules.render.*;
import net.minecraft.client.*;
import java.awt.*;
import com.lukflug.panelstudio.theme.*;
import hawk.modules.*;
import hawk.*;
import com.lukflug.panelstudio.*;
import hawk.settings.*;
import com.lukflug.panelstudio.settings.*;

public class HawkClickGUI extends MinecraftGUI
{
    public static /* synthetic */ HawkClickGUI instance;
    private final /* synthetic */ Theme theme;
    private final /* synthetic */ ClickGUI gui;
    private final /* synthetic */ GUIInterface guiInterface;
    private /* synthetic */ Toggleable colorToggle;
    
    @Override
    protected int getScrollSpeed() {
        return 10;
    }
    
    @Override
    protected GUIInterface getInterface() {
        return this.guiInterface;
    }
    
    public HawkClickGUI() {
        this.colorToggle = new Toggleable() {
            @Override
            public void toggle() {
            }
            
            @Override
            public boolean isOn() {
                return ModToggleGUI.INSTANCE.colorModel.is("RGB");
            }
        };
        this.guiInterface = new GUIInterface(this, true) {
            @Override
            protected String getResourcePrefix() {
                return "monsoon:gui/";
            }
            
            @Override
            public int getFontWidth(final String llllllllllllllIlIlIllIllIlIIlIlI) {
                return Minecraft.getMinecraft().fontRendererObj.getStringWidth(llllllllllllllIlIlIllIllIlIIlIlI);
            }
            
            @Override
            public void drawString(final Point llllllllllllllIlIlIllIllIlIlIIll, final String llllllllllllllIlIlIllIllIlIIllll, final Color llllllllllllllIlIlIllIllIlIIlllI) {
                end();
                Minecraft.getMinecraft().fontRendererObj.drawString(llllllllllllllIlIlIllIllIlIIllll, llllllllllllllIlIlIllIllIlIlIIll.x, llllllllllllllIlIlIllIllIlIlIIll.y, llllllllllllllIlIlIllIllIlIIlllI.getRGB());
                begin();
            }
            
            @Override
            public int getFontHeight() {
                return Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT;
            }
        };
        this.theme = new MonsoonTheme(new SettingsColorScheme(ModToggleGUI.INSTANCE.activeColor, ModToggleGUI.INSTANCE.backgroundColor, ModToggleGUI.INSTANCE.settingBackgroundColor, ModToggleGUI.INSTANCE.outlineColor, ModToggleGUI.INSTANCE.fontColor, ModToggleGUI.INSTANCE.opacity), false, 12, 2);
        this.gui = new ClickGUI(this.guiInterface, null);
        final Exception lllllllllllllllIIlIlllIIIlIIlIII;
        final short lllllllllllllllIIlIlllIIIlIIlIIl = (short)((Module.Category[])(Object)(lllllllllllllllIIlIlllIIIlIIlIII = (Exception)(Object)Module.Category.values())).length;
        for (boolean lllllllllllllllIIlIlllIIIlIIlIlI = false; (lllllllllllllllIIlIlllIIIlIIlIlI ? 1 : 0) < lllllllllllllllIIlIlllIIIlIIlIIl; ++lllllllllllllllIIlIlllIIIlIIlIlI) {
            final Module.Category lllllllllllllllIIlIlllIIIlIlIIIl = lllllllllllllllIIlIlllIIIlIIlIII[lllllllllllllllIIlIlllIIIlIIlIlI];
            if (!lllllllllllllllIIlIlllIIIlIlIIIl.name.equalsIgnoreCase("Hidden")) {
                final DraggableContainer lllllllllllllllIIlIlllIIIlIlIIII = new DraggableContainer(String.valueOf(new StringBuilder(" ").append(lllllllllllllllIIlIlllIIIlIlIIIl.name)), null, this.theme.getPanelRenderer(), new SimpleToggleable(false), new SettingsAnimation(ModToggleGUI.INSTANCE.animationSpeed), null, new Point(lllllllllllllllIIlIlllIIIlIlIIIl.pos, 10), 100);
                this.gui.addComponent(lllllllllllllllIIlIlllIIIlIlIIII);
                for (final Module lllllllllllllllIIlIlllIIIlIIllll : Client.getModulesByCategory(lllllllllllllllIIlIlllIIIlIlIIIl)) {
                    final CollapsibleContainer lllllllllllllllIIlIlllIIIlIIlllI = new CollapsibleContainer(String.valueOf(new StringBuilder(" ").append(lllllllllllllllIIlIlllIIIlIIllll.name)), null, this.theme.getContainerRenderer(), new SimpleToggleable(false), new SettingsAnimation(ModToggleGUI.INSTANCE.animationSpeed), lllllllllllllllIIlIlllIIIlIIllll);
                    lllllllllllllllIIlIlllIIIlIlIIII.addComponent(lllllllllllllllIIlIlllIIIlIIlllI);
                    for (final Setting lllllllllllllllIIlIlllIIIlIIllIl : lllllllllllllllIIlIlllIIIlIIllll.settings) {
                        if (lllllllllllllllIIlIlllIIIlIIllIl instanceof BooleanSetting) {
                            lllllllllllllllIIlIlllIIIlIIlllI.addComponent(new BooleanComponent(String.valueOf(new StringBuilder().append(lllllllllllllllIIlIlllIIIlIIllIl.name)), null, this.theme.getComponentRenderer(), (Toggleable)lllllllllllllllIIlIlllIIIlIIllIl));
                        }
                        else if (lllllllllllllllIIlIlllIIIlIIllIl instanceof hawk.settings.NumberSetting) {
                            lllllllllllllllIIlIlllIIIlIIlllI.addComponent(new NumberComponent(String.valueOf(new StringBuilder().append(lllllllllllllllIIlIlllIIIlIIllIl.name)), null, this.theme.getComponentRenderer(), (NumberSetting)lllllllllllllllIIlIlllIIIlIIllIl, ((hawk.settings.NumberSetting)lllllllllllllllIIlIlllIIIlIIllIl).getMinimum(), ((hawk.settings.NumberSetting)lllllllllllllllIIlIlllIIIlIIllIl).getMaximum()));
                        }
                        else if (lllllllllllllllIIlIlllIIIlIIllIl instanceof ModeSetting) {
                            lllllllllllllllIIlIlllIIIlIIlllI.addComponent(new EnumComponent(String.valueOf(new StringBuilder().append(lllllllllllllllIIlIlllIIIlIIllIl.name)), null, this.theme.getComponentRenderer(), (EnumSetting)lllllllllllllllIIlIlllIIIlIIllIl));
                        }
                        else if (lllllllllllllllIIlIlllIIIlIIllIl instanceof hawk.settings.ColorSetting) {
                            lllllllllllllllIIlIlllIIIlIIlllI.addComponent(new SyncableColorComponent(this.theme, (hawk.settings.ColorSetting)lllllllllllllllIIlIlllIIIlIIllIl, this.colorToggle, new SettingsAnimation(ModToggleGUI.INSTANCE.animationSpeed)));
                        }
                        else {
                            if (!(lllllllllllllllIIlIlllIIIlIIllIl instanceof KeyBindSetting)) {
                                continue;
                            }
                            lllllllllllllllIIlIlllIIIlIIlllI.addComponent(new KeybindComponent(this.theme.getComponentRenderer(), (KeybindSetting)lllllllllllllllIIlIlllIIIlIIllIl));
                        }
                    }
                }
            }
        }
    }
    
    @Override
    protected ClickGUI getGUI() {
        return this.gui;
    }
    
    static {
        HawkClickGUI.instance = new HawkClickGUI();
    }
}
