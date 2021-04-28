package hawk.modules.render;

import hawk.modules.*;
import hawk.util.*;
import hawk.events.*;
import hawk.events.listeners.*;
import hawk.settings.*;

public class ModulesListOptions extends Module
{
    public /* synthetic */ ModeSetting Color;
    /* synthetic */ Timer timer;
    public static /* synthetic */ int ColorOptionInt;
    /* synthetic */ boolean PlayerEat;
    
    @Override
    public void onEvent(final Event llllllllllllllIIIIlIIlIllllIlIIl) {
        if (llllllllllllllIIIIlIIlIllllIlIIl instanceof EventUpdate) {
            if (this.Color.is("Colorful")) {
                ModulesListOptions.ColorOptionInt = 0;
            }
            if (this.Color.is("Red")) {
                ModulesListOptions.ColorOptionInt = 1;
            }
            if (this.Color.is("Blue")) {
                ModulesListOptions.ColorOptionInt = 2;
            }
            if (this.Color.is("Orange")) {
                ModulesListOptions.ColorOptionInt = 3;
            }
            if (this.Color.is("Green")) {
                ModulesListOptions.ColorOptionInt = 4;
            }
            if (this.Color.is("White")) {
                ModulesListOptions.ColorOptionInt = 5;
            }
            if (this.Color.is("Discord")) {
                ModulesListOptions.ColorOptionInt = 11;
            }
        }
    }
    
    public ModulesListOptions() {
        super("HUD Options", 0, Category.RENDER);
        this.Color = new ModeSetting("Color", this, "Colorful", new String[] { "Colorful", "Discord", "Red", "Blue", "Orange", "Green", "White" });
        this.timer = new Timer();
        this.PlayerEat = false;
        this.addSettings(this.Color);
    }
    
    static {
        ModulesListOptions.ColorOptionInt = 0;
    }
}
