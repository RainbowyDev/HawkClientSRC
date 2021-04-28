package hawk.modules.combat;

import hawk.modules.*;
import hawk.events.*;
import hawk.events.listeners.*;
import net.minecraft.entity.*;

public class Antibot extends Module
{
    @Override
    public void onEvent(final Event lllllllllllllllllllIIIlIllIlllIl) {
        if (lllllllllllllllllllIIIlIllIlllIl instanceof EventUpdate) {
            for (final Object lllllllllllllllllllIIIlIllIlllll : this.mc.theWorld.loadedEntityList) {
                if (((Entity)lllllllllllllllllllIIIlIllIlllll).isInvisible() && lllllllllllllllllllIIIlIllIlllll != this.mc.thePlayer) {
                    this.mc.theWorld.removeEntity((Entity)lllllllllllllllllllIIIlIllIlllll);
                }
            }
        }
    }
    
    @Override
    public void onEnable() {
    }
    
    public Antibot() {
        super("AntiBot", 0, Category.COMBAT);
    }
    
    @Override
    public void onDisable() {
    }
}
