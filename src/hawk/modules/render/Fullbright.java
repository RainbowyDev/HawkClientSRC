package hawk.modules.render;

import hawk.modules.*;

public class Fullbright extends Module
{
    public Fullbright() {
        super("Fullbright", 0, Category.RENDER);
    }
    
    @Override
    public void onEnable() {
        this.mc.gameSettings.gammaSetting = 100.0f;
        this.mc.rightClickDelayTimer = 0;
    }
    
    @Override
    public void onDisable() {
        this.mc.gameSettings.gammaSetting = 1.0f;
    }
}
