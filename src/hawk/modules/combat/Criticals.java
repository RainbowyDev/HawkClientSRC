package hawk.modules.combat;

import hawk.modules.*;
import hawk.events.*;
import hawk.events.listeners.*;
import net.minecraft.network.play.client.*;

public class Criticals extends Module
{
    @Override
    public void onEnable() {
        this.mc.thePlayer.jump();
    }
    
    public Criticals() {
        super("Criticals", 0, Category.COMBAT);
    }
    
    @Override
    public void onEvent(final Event lllllllllllllllIIIIIIIIIlIIIllll) {
        if (lllllllllllllllIIIIIIIIIlIIIllll instanceof EventSendPacket) {
            final EventSendPacket lllllllllllllllIIIIIIIIIlIIlIIlI = (EventSendPacket)lllllllllllllllIIIIIIIIIlIIIllll;
            if (lllllllllllllllIIIIIIIIIlIIlIIlI.getPacket() instanceof C03PacketPlayer && Killaura.HasTarget && this.mc.thePlayer.fallDistance < 3.0f) {
                final C03PacketPlayer lllllllllllllllIIIIIIIIIlIIlIIIl = (C03PacketPlayer)lllllllllllllllIIIIIIIIIlIIlIIlI.getPacket();
                lllllllllllllllIIIIIIIIIlIIlIIIl.onground = false;
            }
        }
    }
    
    @Override
    public void onDisable() {
    }
}
