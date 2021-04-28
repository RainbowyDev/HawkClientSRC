package hawk.modules.movement;

import hawk.modules.*;
import hawk.events.*;
import hawk.events.listeners.*;

public class Sprint extends Module
{
    public /* synthetic */ boolean isSprintToggled;
    
    @Override
    public void onEnable() {
    }
    
    @Override
    public void onDisable() {
        this.mc.thePlayer.setSprinting(this.mc.gameSettings.keyBindSprint.getIsKeyPressed());
    }
    
    public Sprint() {
        super("Sprint", 0, Category.MOVEMENT);
        this.isSprintToggled = false;
    }
    
    @Override
    public void onEvent(final Event llllllllllllllIlIIlIlIIIIllIIIII) {
        if (llllllllllllllIlIIlIlIIIIllIIIII instanceof EventUpdate && llllllllllllllIlIIlIlIIIIllIIIII.isPre() && this.mc.thePlayer.moveForward > 0.0f && !this.mc.thePlayer.isSneaking() && !this.mc.thePlayer.isCollidedHorizontally && (!this.mc.thePlayer.isUsingItem() || Noslow.isnoslow)) {
            this.mc.thePlayer.setSprinting(true);
            this.isSprintToggled = true;
        }
    }
}
