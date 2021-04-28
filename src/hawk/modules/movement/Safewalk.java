package hawk.modules.movement;

import hawk.modules.*;

public class Safewalk extends Module
{
    public static /* synthetic */ boolean isEnabled;
    
    @Override
    public void onEnable() {
        Safewalk.isEnabled = true;
    }
    
    static {
        Safewalk.isEnabled = false;
    }
    
    public Safewalk() {
        super("Safewalk", 0, Category.MOVEMENT);
    }
    
    @Override
    public void onDisable() {
        Safewalk.isEnabled = false;
    }
}
