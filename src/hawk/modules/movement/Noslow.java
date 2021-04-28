package hawk.modules.movement;

import hawk.modules.*;
import hawk.events.*;
import hawk.events.listeners.*;
import net.minecraft.network.play.client.*;
import net.minecraft.util.*;
import net.minecraft.network.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import hawk.settings.*;

public class Noslow extends Module
{
    public static /* synthetic */ boolean isnoslow;
    public /* synthetic */ ModeSetting mode;
    
    static {
        Noslow.isnoslow = false;
    }
    
    @Override
    public void onDisable() {
        Noslow.isnoslow = false;
    }
    
    @Override
    public void onEnable() {
        Noslow.isnoslow = true;
    }
    
    @Override
    public void onEvent(final Event lllllllllllllllIIIlIIIlIIIIlIIII) {
        if (lllllllllllllllIIIlIIIlIIIIlIIII instanceof EventUpdate && this.mode.is("NCP") && this.mc.thePlayer.isBlocking()) {
            if (lllllllllllllllIIIlIIIlIIIIlIIII.isPre()) {
                this.mc.thePlayer.sendQueue.addToSendQueue(new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.ORIGIN, EnumFacing.UP));
            }
            else {
                this.mc.thePlayer.setItemInUse(this.mc.thePlayer.getCurrentEquippedItem(), 71999999);
                this.mc.playerController.sendUseItem(this.mc.thePlayer, this.mc.theWorld, this.mc.thePlayer.getCurrentEquippedItem());
            }
        }
    }
    
    public Noslow() {
        super("Noslow", 0, Category.MOVEMENT);
        this.mode = new ModeSetting("Mode", this, "NCP", new String[] { "Vanilla", "NCP" });
        this.addSettings(this.mode);
    }
}
