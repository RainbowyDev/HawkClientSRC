package hawk.modules.render;

import hawk.modules.*;
import hawk.events.*;
import java.awt.*;
import hawk.util.*;
import hawk.*;
import hawk.settings.*;
import org.lwjgl.input.*;
import hawk.events.listeners.*;
import net.minecraft.client.gui.*;
import java.util.*;

public class TabGUI extends Module
{
    public /* synthetic */ int currentTab;
    public /* synthetic */ ModeSetting ColorOption;
    public /* synthetic */ boolean expanded;
    
    public TabGUI() {
        super("TabGUI", 0, Category.RENDER);
        this.ColorOption = new ModeSetting("Color", this, "Colorful", new String[] { "Colorful", "Discord", "Red", "Blue", "Orange", "Green", "White" });
        this.toggled = true;
        this.addSettings(this.ColorOption);
    }
    
    @Override
    public void onEvent(final Event llllllllllllllIIIIIllIIllllIlIIl) {
        if (llllllllllllllIIIIIllIIllllIlIIl instanceof EventRenderGUI) {
            final FontRenderer llllllllllllllIIIIIllIIllllIlIII = this.mc.fontRendererObj;
            int llllllllllllllIIIIIllIIllllIIlll = 0;
            int llllllllllllllIIIIIllIIllllIIllI = -1879048192;
            if (this.ColorOption.is("Colorful")) {
                final float llllllllllllllIIIIIllIIllllIIlIl = System.currentTimeMillis() % 4500L / 4500.0f;
                llllllllllllllIIIIIllIIllllIIlll = Color.HSBtoRGB(llllllllllllllIIIIIllIIllllIIlIl, 1.0f, 1.0f);
            }
            if (this.ColorOption.is("Red")) {
                llllllllllllllIIIIIllIIllllIIlll = Color.HSBtoRGB(1.003112E7f, 1.0f, 1.0f);
            }
            if (this.ColorOption.is("Blue")) {
                llllllllllllllIIIIIllIIllllIIlll = -16756481;
            }
            if (this.ColorOption.is("Orange")) {
                llllllllllllllIIIIIllIIllllIIlll = -1350377;
            }
            if (this.ColorOption.is("Green")) {
                llllllllllllllIIIIIllIIllllIIlll = -13571305;
            }
            if (this.ColorOption.is("White")) {
                llllllllllllllIIIIIllIIllllIIlll = -1;
            }
            if (this.ColorOption.is("Discord")) {
                llllllllllllllIIIIIllIIllllIIlll = new Color(114, 137, 218, 255).getRGB();
                llllllllllllllIIIIIllIIllllIIllI = new Color(47, 49, 54, 255).getRGB();
            }
            final int llllllllllllllIIIIIllIIllllIIlII = llllllllllllllIIIIIllIIllllIIlll;
            final int llllllllllllllIIIIIllIIllllIIIll = -16748374;
            DrawUtil.drawRoundedRect(5.0, 30.5, 70.0, 30 + Category.values().length * 16 + 1.5, 10.0, llllllllllllllIIIIIllIIllllIIllI);
            DrawUtil.drawRoundedRect(7.0, 32.5f + this.currentTab * 16, 68.0, 33 + this.currentTab * 16 + 12 + 0.5f, 10.0, llllllllllllllIIIIIllIIllllIIlII);
            int llllllllllllllIIIIIllIIllllIIIlI = 0;
            boolean llllllllllllllIIIIIllIIllIlllIIl;
            final int length = (llllllllllllllIIIIIllIIllIlllIIl = (boolean)(Object)Category.values()).length;
            for (long llllllllllllllIIIIIllIIllIlllIll = 0; llllllllllllllIIIIIllIIllIlllIll < length; ++llllllllllllllIIIIIllIIllIlllIll) {
                final Category llllllllllllllIIIIIllIIllllIIIIl = llllllllllllllIIIIIllIIllIlllIIl[llllllllllllllIIIIIllIIllIlllIll];
                if (!llllllllllllllIIIIIllIIllllIIIIl.name.equalsIgnoreCase("Hidden")) {
                    if (this.currentTab == llllllllllllllIIIIIllIIllllIIIlI) {
                        llllllllllllllIIIIIllIIllllIlIII.drawStringWithShadow(llllllllllllllIIIIIllIIllllIIIIl.name, 17.0, 35 + llllllllllllllIIIIIllIIllllIIIlI * 16, -1);
                    }
                    else {
                        llllllllllllllIIIIIllIIllllIlIII.drawStringWithShadow(llllllllllllllIIIIIllIIllllIIIIl.name, 11.0, 35 + llllllllllllllIIIIIllIIllllIIIlI * 16, -1);
                    }
                    ++llllllllllllllIIIIIllIIllllIIIlI;
                }
            }
            if (this.expanded) {
                final Category llllllllllllllIIIIIllIIllllIIIII = Category.values()[this.currentTab];
                final List<Module> llllllllllllllIIIIIllIIlllIlllll = Client.getModulesByCategory(llllllllllllllIIIIIllIIllllIIIII);
                if (llllllllllllllIIIIIllIIlllIlllll.size() == 0) {
                    return;
                }
                DrawUtil.drawRoundedRect(70.0, 30.5, 138.0, 30 + llllllllllllllIIIIIllIIlllIlllll.size() * 16 + 1.5, 10.0, llllllllllllllIIIIIllIIllllIIllI);
                DrawUtil.drawRoundedRect(71.5, 32.5f + llllllllllllllIIIIIllIIllllIIIII.moduleIndex * 16, 136.0, 33 + llllllllllllllIIIIIllIIllllIIIII.moduleIndex * 16 + 12 + 0.5f, 10.0, llllllllllllllIIIIIllIIllllIIlII);
                llllllllllllllIIIIIllIIllllIIIlI = 0;
                llllllllllllllIIIIIllIIllIlllIIl = (boolean)llllllllllllllIIIIIllIIlllIlllll.iterator();
                while (((Iterator)llllllllllllllIIIIIllIIllIlllIIl).hasNext()) {
                    final Module llllllllllllllIIIIIllIIlllIllllI = ((Iterator<Module>)llllllllllllllIIIIIllIIllIlllIIl).next();
                    llllllllllllllIIIIIllIIllllIlIII.drawStringWithShadow(llllllllllllllIIIIIllIIlllIllllI.name, 73.0, 35 + llllllllllllllIIIIIllIIllllIIIlI * 16, -1);
                    if (llllllllllllllIIIIIllIIllllIIIlI == llllllllllllllIIIIIllIIllllIIIII.moduleIndex && llllllllllllllIIIIIllIIlllIllllI.expanded) {
                        int llllllllllllllIIIIIllIIlllIlllIl = 0;
                        int llllllllllllllIIIIIllIIlllIlllII = 0;
                        for (final Setting llllllllllllllIIIIIllIIlllIllIll : llllllllllllllIIIIIllIIlllIllllI.settings) {
                            if (llllllllllllllIIIIIllIIlllIllIll instanceof BooleanSetting) {
                                final BooleanSetting llllllllllllllIIIIIllIIlllIllIlI = (BooleanSetting)llllllllllllllIIIIIllIIlllIllIll;
                                if (llllllllllllllIIIIIllIIlllIlllII < llllllllllllllIIIIIllIIllllIlIII.getStringWidth(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIIIllIIlllIllIll.name)).append(" : ").append(llllllllllllllIIIIIllIIlllIllIlI.enabled ? "Enabled" : "Disabled")))) {
                                    llllllllllllllIIIIIllIIlllIlllII = llllllllllllllIIIIIllIIllllIlIII.getStringWidth(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIIIllIIlllIllIll.name)).append(" : ").append(llllllllllllllIIIIIllIIlllIllIlI.enabled ? "Enabled" : "Disabled")));
                                }
                            }
                            if (llllllllllllllIIIIIllIIlllIllIll instanceof NumberSetting) {
                                final NumberSetting llllllllllllllIIIIIllIIlllIllIIl = (NumberSetting)llllllllllllllIIIIIllIIlllIllIll;
                                if (llllllllllllllIIIIIllIIlllIlllII < llllllllllllllIIIIIllIIllllIlIII.getStringWidth(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIIIllIIlllIllIll.name)).append(" : ").append(llllllllllllllIIIIIllIIlllIllIIl.getValue())))) {
                                    llllllllllllllIIIIIllIIlllIlllII = llllllllllllllIIIIIllIIllllIlIII.getStringWidth(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIIIllIIlllIllIll.name)).append(" : ").append(llllllllllllllIIIIIllIIlllIllIIl.getValue())));
                                }
                            }
                            if (llllllllllllllIIIIIllIIlllIllIll instanceof ModeSetting) {
                                final ModeSetting llllllllllllllIIIIIllIIlllIllIII = (ModeSetting)llllllllllllllIIIIIllIIlllIllIll;
                                if (llllllllllllllIIIIIllIIlllIlllII < llllllllllllllIIIIIllIIllllIlIII.getStringWidth(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIIIllIIlllIllIll.name)).append(" : ").append(llllllllllllllIIIIIllIIlllIllIII.getMode())))) {
                                    llllllllllllllIIIIIllIIlllIlllII = llllllllllllllIIIIIllIIllllIlIII.getStringWidth(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIIIllIIlllIllIll.name)).append(" : ").append(llllllllllllllIIIIIllIIlllIllIII.getMode())));
                                }
                            }
                            if (llllllllllllllIIIIIllIIlllIllIll instanceof KeyBindSetting) {
                                final KeyBindSetting llllllllllllllIIIIIllIIlllIlIlll = (KeyBindSetting)llllllllllllllIIIIIllIIlllIllIll;
                                if (llllllllllllllIIIIIllIIlllIlllII < llllllllllllllIIIIIllIIllllIlIII.getStringWidth(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIIIllIIlllIllIll.name)).append(" : ").append(Keyboard.getKeyName(llllllllllllllIIIIIllIIlllIlIlll.code))))) {
                                    llllllllllllllIIIIIllIIlllIlllII = llllllllllllllIIIIIllIIllllIlIII.getStringWidth(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIIIllIIlllIllIll.name)).append(" : ").append(Keyboard.getKeyName(llllllllllllllIIIIIllIIlllIlIlll.code))));
                                }
                            }
                            ++llllllllllllllIIIIIllIIlllIlllIl;
                        }
                        if (!llllllllllllllIIIIIllIIlllIllllI.settings.isEmpty()) {
                            DrawUtil.drawRoundedRect(138.0, 30.5, 70 + llllllllllllllIIIIIllIIlllIlllII + 9 + 68, 30 + llllllllllllllIIIIIllIIlllIllllI.settings.size() * 16 + 1.5, 10.0, llllllllllllllIIIIIllIIllllIIllI);
                            DrawUtil.drawRoundedRect(140.0, 32.5f + llllllllllllllIIIIIllIIlllIllllI.index * 16, 68 + llllllllllllllIIIIIllIIlllIlllII + 9 + 68, 33 + llllllllllllllIIIIIllIIlllIllllI.index * 16 + 12 + 0.5f, 10.0, llllllllllllllIIIIIllIIlllIllllI.settings.get(llllllllllllllIIIIIllIIlllIllllI.index).focused ? llllllllllllllIIIIIllIIllllIIIll : llllllllllllllIIIIIllIIllllIIlII);
                            llllllllllllllIIIIIllIIlllIlllIl = 0;
                            for (final Setting llllllllllllllIIIIIllIIlllIlIllI : llllllllllllllIIIIIllIIlllIllllI.settings) {
                                if (llllllllllllllIIIIIllIIlllIlIllI instanceof BooleanSetting) {
                                    final BooleanSetting llllllllllllllIIIIIllIIlllIlIlIl = (BooleanSetting)llllllllllllllIIIIIllIIlllIlIllI;
                                    llllllllllllllIIIIIllIIllllIlIII.drawStringWithShadow(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIIIllIIlllIlIllI.name)).append(" : ").append(llllllllllllllIIIIIllIIlllIlIlIl.enabled ? "Enabled" : "Disabled")), 143.0, 35 + llllllllllllllIIIIIllIIlllIlllIl * 16, -1);
                                }
                                if (llllllllllllllIIIIIllIIlllIlIllI instanceof NumberSetting) {
                                    final NumberSetting llllllllllllllIIIIIllIIlllIlIlII = (NumberSetting)llllllllllllllIIIIIllIIlllIlIllI;
                                    llllllllllllllIIIIIllIIllllIlIII.drawStringWithShadow(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIIIllIIlllIlIllI.name)).append(" : ").append(llllllllllllllIIIIIllIIlllIlIlII.getValue())), 143.0, 35 + llllllllllllllIIIIIllIIlllIlllIl * 16, -1);
                                }
                                if (llllllllllllllIIIIIllIIlllIlIllI instanceof ModeSetting) {
                                    final ModeSetting llllllllllllllIIIIIllIIlllIlIIll = (ModeSetting)llllllllllllllIIIIIllIIlllIlIllI;
                                    llllllllllllllIIIIIllIIllllIlIII.drawStringWithShadow(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIIIllIIlllIlIllI.name)).append(" : ").append(llllllllllllllIIIIIllIIlllIlIIll.getMode())), 143.0, 35 + llllllllllllllIIIIIllIIlllIlllIl * 16, -1);
                                }
                                if (llllllllllllllIIIIIllIIlllIlIllI instanceof KeyBindSetting) {
                                    final KeyBindSetting llllllllllllllIIIIIllIIlllIlIIlI = (KeyBindSetting)llllllllllllllIIIIIllIIlllIlIllI;
                                    llllllllllllllIIIIIllIIllllIlIII.drawStringWithShadow(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIIIllIIlllIlIllI.name)).append(" : ").append(Keyboard.getKeyName(llllllllllllllIIIIIllIIlllIlIIlI.code))), 143.0, 35 + llllllllllllllIIIIIllIIlllIlllIl * 16, -1);
                                }
                                ++llllllllllllllIIIIIllIIlllIlllIl;
                            }
                        }
                    }
                    ++llllllllllllllIIIIIllIIllllIIIlI;
                }
            }
        }
        if (llllllllllllllIIIIIllIIllllIlIIl instanceof EventKey) {
            final int llllllllllllllIIIIIllIIlllIlIIIl = ((EventKey)llllllllllllllIIIIIllIIllllIlIIl).code;
            final Category llllllllllllllIIIIIllIIlllIlIIII = Category.values()[this.currentTab];
            final List<Module> llllllllllllllIIIIIllIIlllIIllll = Client.getModulesByCategory(llllllllllllllIIIIIllIIlllIlIIII);
            if (this.expanded && !llllllllllllllIIIIIllIIlllIIllll.isEmpty() && llllllllllllllIIIIIllIIlllIIllll.get(llllllllllllllIIIIIllIIlllIlIIII.moduleIndex).expanded) {
                final Module llllllllllllllIIIIIllIIlllIIlllI = llllllllllllllIIIIIllIIlllIIllll.get(llllllllllllllIIIIIllIIlllIlIIII.moduleIndex);
                if (!llllllllllllllIIIIIllIIlllIIlllI.settings.isEmpty() && llllllllllllllIIIIIllIIlllIIlllI.settings.get(llllllllllllllIIIIIllIIlllIIlllI.index).focused && llllllllllllllIIIIIllIIlllIIlllI.settings.get(llllllllllllllIIIIIllIIlllIIlllI.index) instanceof KeyBindSetting && llllllllllllllIIIIIllIIlllIlIIIl != 28 && llllllllllllllIIIIIllIIlllIlIIIl != 200 && llllllllllllllIIIIIllIIlllIlIIIl != 208 && llllllllllllllIIIIIllIIlllIlIIIl != 203 && llllllllllllllIIIIIllIIlllIlIIIl != 205 && llllllllllllllIIIIIllIIlllIlIIIl != 1) {
                    final KeyBindSetting llllllllllllllIIIIIllIIlllIIllIl = llllllllllllllIIIIIllIIlllIIlllI.settings.get(llllllllllllllIIIIIllIIlllIIlllI.index);
                    llllllllllllllIIIIIllIIlllIIllIl.code = llllllllllllllIIIIIllIIlllIlIIIl;
                    llllllllllllllIIIIIllIIlllIIllIl.focused = false;
                    return;
                }
            }
            if (llllllllllllllIIIIIllIIlllIlIIIl == 200) {
                if (this.expanded) {
                    if (this.expanded && !llllllllllllllIIIIIllIIlllIIllll.isEmpty() && llllllllllllllIIIIIllIIlllIIllll.get(llllllllllllllIIIIIllIIlllIlIIII.moduleIndex).expanded) {
                        final Module llllllllllllllIIIIIllIIlllIIllII = llllllllllllllIIIIIllIIlllIIllll.get(llllllllllllllIIIIIllIIlllIlIIII.moduleIndex);
                        if (!llllllllllllllIIIIIllIIlllIIllII.settings.isEmpty()) {
                            if (llllllllllllllIIIIIllIIlllIIllII.settings.get(llllllllllllllIIIIIllIIlllIIllII.index).focused) {
                                final Setting llllllllllllllIIIIIllIIlllIIlIll = llllllllllllllIIIIIllIIlllIIllII.settings.get(llllllllllllllIIIIIllIIlllIIllII.index);
                                if (llllllllllllllIIIIIllIIlllIIlIll instanceof NumberSetting) {
                                    ((NumberSetting)llllllllllllllIIIIIllIIlllIIlIll).increment(true);
                                }
                            }
                            else if (llllllllllllllIIIIIllIIlllIIllII.index <= 0) {
                                llllllllllllllIIIIIllIIlllIIllII.index = llllllllllllllIIIIIllIIlllIIllII.settings.size() - 1;
                            }
                            else {
                                final Module module = llllllllllllllIIIIIllIIlllIIllII;
                                --module.index;
                            }
                        }
                    }
                    else if (llllllllllllllIIIIIllIIlllIlIIII.moduleIndex <= 0) {
                        llllllllllllllIIIIIllIIlllIlIIII.moduleIndex = llllllllllllllIIIIIllIIlllIIllll.size() - 1;
                    }
                    else {
                        final Category category = llllllllllllllIIIIIllIIlllIlIIII;
                        --category.moduleIndex;
                    }
                }
                else if (this.currentTab <= 0) {
                    this.currentTab = Category.values().length - 1;
                }
                else {
                    --this.currentTab;
                }
            }
            if (llllllllllllllIIIIIllIIlllIlIIIl == 208) {
                if (this.expanded) {
                    if (this.expanded && !llllllllllllllIIIIIllIIlllIIllll.isEmpty() && llllllllllllllIIIIIllIIlllIIllll.get(llllllllllllllIIIIIllIIlllIlIIII.moduleIndex).expanded) {
                        final Module llllllllllllllIIIIIllIIlllIIlIlI = llllllllllllllIIIIIllIIlllIIllll.get(llllllllllllllIIIIIllIIlllIlIIII.moduleIndex);
                        if (!llllllllllllllIIIIIllIIlllIIlIlI.settings.isEmpty()) {
                            if (llllllllllllllIIIIIllIIlllIIlIlI.settings.get(llllllllllllllIIIIIllIIlllIIlIlI.index).focused) {
                                final Setting llllllllllllllIIIIIllIIlllIIlIIl = llllllllllllllIIIIIllIIlllIIlIlI.settings.get(llllllllllllllIIIIIllIIlllIIlIlI.index);
                                if (llllllllllllllIIIIIllIIlllIIlIIl instanceof NumberSetting) {
                                    ((NumberSetting)llllllllllllllIIIIIllIIlllIIlIIl).increment(false);
                                }
                            }
                            else if (llllllllllllllIIIIIllIIlllIIlIlI.index >= llllllllllllllIIIIIllIIlllIIlIlI.settings.size() - 1) {
                                llllllllllllllIIIIIllIIlllIIlIlI.index = 0;
                            }
                            else {
                                final Module module2 = llllllllllllllIIIIIllIIlllIIlIlI;
                                ++module2.index;
                            }
                        }
                    }
                    else if (llllllllllllllIIIIIllIIlllIlIIII.moduleIndex >= llllllllllllllIIIIIllIIlllIIllll.size() - 1) {
                        llllllllllllllIIIIIllIIlllIlIIII.moduleIndex = 0;
                    }
                    else {
                        final Category category2 = llllllllllllllIIIIIllIIlllIlIIII;
                        ++category2.moduleIndex;
                    }
                }
                else if (this.currentTab >= Category.values().length - 1) {
                    this.currentTab = 0;
                }
                else {
                    ++this.currentTab;
                }
            }
            if (llllllllllllllIIIIIllIIlllIlIIIl == 28 && this.expanded && llllllllllllllIIIIIllIIlllIIllll.size() != 0) {
                final Module llllllllllllllIIIIIllIIlllIIlIII = llllllllllllllIIIIIllIIlllIIllll.get(llllllllllllllIIIIIllIIlllIlIIII.moduleIndex);
                if (!llllllllllllllIIIIIllIIlllIIlIII.expanded && !llllllllllllllIIIIIllIIlllIIlIII.settings.isEmpty()) {
                    llllllllllllllIIIIIllIIlllIIlIII.expanded = true;
                }
                else if (llllllllllllllIIIIIllIIlllIIlIII.expanded && !llllllllllllllIIIIIllIIlllIIlIII.settings.isEmpty()) {
                    llllllllllllllIIIIIllIIlllIIlIII.settings.get(llllllllllllllIIIIIllIIlllIIlIII.index).focused = !llllllllllllllIIIIIllIIlllIIlIII.settings.get(llllllllllllllIIIIIllIIlllIIlIII.index).focused;
                }
            }
            if (llllllllllllllIIIIIllIIlllIlIIIl == 205) {
                if (this.expanded && llllllllllllllIIIIIllIIlllIIllll.size() != 0) {
                    final Module llllllllllllllIIIIIllIIlllIIIlll = llllllllllllllIIIIIllIIlllIIllll.get(llllllllllllllIIIIIllIIlllIlIIII.moduleIndex);
                    if (this.expanded && !llllllllllllllIIIIIllIIlllIIllll.isEmpty() && llllllllllllllIIIIIllIIlllIIIlll.expanded) {
                        final Setting llllllllllllllIIIIIllIIlllIIIllI = llllllllllllllIIIIIllIIlllIIIlll.settings.get(llllllllllllllIIIIIllIIlllIIIlll.index);
                        if (!llllllllllllllIIIIIllIIlllIIIlll.settings.isEmpty()) {
                            if (llllllllllllllIIIIIllIIlllIIIllI instanceof BooleanSetting) {
                                ((BooleanSetting)llllllllllllllIIIIIllIIlllIIIllI).toggle();
                            }
                            if (llllllllllllllIIIIIllIIlllIIIllI instanceof ModeSetting) {
                                ((ModeSetting)llllllllllllllIIIIIllIIlllIIIllI).cycle();
                            }
                        }
                    }
                    else if (!llllllllllllllIIIIIllIIlllIIIlll.name.equals("TabGUI")) {
                        llllllllllllllIIIIIllIIlllIIIlll.toggle();
                    }
                }
                else {
                    this.expanded = true;
                }
            }
            if (llllllllllllllIIIIIllIIlllIlIIIl == 203) {
                if (this.expanded && !llllllllllllllIIIIIllIIlllIIllll.isEmpty() && llllllllllllllIIIIIllIIlllIIllll.get(llllllllllllllIIIIIllIIlllIlIIII.moduleIndex).expanded) {
                    final Module llllllllllllllIIIIIllIIlllIIIlIl = llllllllllllllIIIIIllIIlllIIllll.get(llllllllllllllIIIIIllIIlllIlIIII.moduleIndex);
                    if (!llllllllllllllIIIIIllIIlllIIIlIl.settings.isEmpty() && !llllllllllllllIIIIIllIIlllIIIlIl.settings.get(llllllllllllllIIIIIllIIlllIIIlIl.index).focused) {
                        llllllllllllllIIIIIllIIlllIIllll.get(llllllllllllllIIIIIllIIlllIlIIII.moduleIndex).expanded = false;
                    }
                }
                else {
                    this.expanded = false;
                }
            }
        }
    }
}
