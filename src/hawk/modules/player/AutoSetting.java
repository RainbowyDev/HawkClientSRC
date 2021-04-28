package hawk.modules.player;

import hawk.modules.*;
import hawk.util.*;
import hawk.events.*;
import hawk.events.listeners.*;
import hawk.settings.*;

public class AutoSetting extends Module
{
    public static /* synthetic */ boolean enabled;
    public static /* synthetic */ boolean isOldVerus;
    public static /* synthetic */ boolean isHypixel;
    public /* synthetic */ ModeSetting server;
    public static /* synthetic */ boolean isMineplex;
    /* synthetic */ Timer timer;
    public static /* synthetic */ boolean isRedesky;
    
    @Override
    public void onDisable() {
        AutoSetting.enabled = false;
    }
    
    @Override
    public void onEvent(final Event lllllllllllllllIIIIlIIIIlIIlIIlI) {
        if (lllllllllllllllIIIIlIIIIlIIlIIlI instanceof EventUpdate) {
            if (this.server.is("Hypixel")) {
                AutoSetting.isHypixel = true;
            }
            else {
                AutoSetting.isHypixel = false;
            }
            if (this.server.is("Mineplex")) {
                AutoSetting.isMineplex = true;
            }
            else {
                AutoSetting.isMineplex = false;
            }
            if (this.server.is("Redesky")) {
                AutoSetting.isRedesky = true;
            }
            else {
                AutoSetting.isRedesky = false;
            }
            if (this.server.is("OldVerus")) {
                AutoSetting.isOldVerus = true;
            }
            else {
                AutoSetting.isOldVerus = false;
            }
        }
    }
    
    @Override
    public void onEnable() {
        AutoSetting.enabled = true;
    }
    
    public AutoSetting() {
        super("AutoSetting", 0, Category.PLAYER);
        this.timer = new Timer();
        this.server = new ModeSetting("Server", this, "Hypixel", new String[] { "Hypixel", "Mineplex", "Redesky", "OldVerus" });
        this.addSettings(this.server);
    }
    
    static {
        AutoSetting.enabled = false;
        AutoSetting.isHypixel = false;
        AutoSetting.isMineplex = false;
        AutoSetting.isRedesky = false;
        AutoSetting.isOldVerus = false;
    }
}
