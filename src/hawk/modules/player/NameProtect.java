package hawk.modules.player;

import hawk.modules.*;
import hawk.util.*;

public class NameProtect extends Module
{
    /* synthetic */ Timer timer;
    public static /* synthetic */ String newname;
    public static /* synthetic */ boolean isEnabled;
    
    static {
        NameProtect.newname = "Me";
        NameProtect.isEnabled = false;
    }
    
    @Override
    public void onDisable() {
        NameProtect.isEnabled = false;
    }
    
    @Override
    public void onEnable() {
        NameProtect.isEnabled = true;
    }
    
    public NameProtect() {
        super("NameProtect", 0, Category.PLAYER);
        this.timer = new Timer();
    }
    
    public static String getNewName() {
        return NameProtect.newname;
    }
}
