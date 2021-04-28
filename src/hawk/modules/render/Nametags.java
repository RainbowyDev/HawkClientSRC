package hawk.modules.render;

import hawk.modules.*;

public class Nametags extends Module
{
    public Nametags() {
        super("Nametags", 0, Category.RENDER);
    }
    
    @Override
    public void onDisable() {
        this.mc.thePlayer.setAlwaysRenderNameTag(false);
    }
    
    @Override
    public void onEnable() {
        this.mc.thePlayer.setAlwaysRenderNameTag(true);
    }
}
