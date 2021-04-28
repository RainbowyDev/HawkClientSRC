package hawk.modules.player;

import hawk.modules.*;
import hawk.util.*;
import hawk.events.*;
import net.minecraft.network.play.client.*;
import hawk.events.listeners.*;
import hawk.settings.*;

public class Disabler extends Module
{
    public /* synthetic */ ModeSetting mode;
    /* synthetic */ Timer timer;
    
    @Override
    public void onEvent(final Event llllllllllllllIIlIlIlllllIlIlIII) {
        if (llllllllllllllIIlIlIlllllIlIlIII instanceof EventReceivePacket && this.mode.is("Rede less flags")) {
            if (((EventReceivePacket)llllllllllllllIIlIlIlllllIlIlIII).getPacket() instanceof C0FPacketConfirmTransaction) {
                llllllllllllllIIlIlIlllllIlIlIII.setCancelled(true);
            }
            else if (((EventReceivePacket)llllllllllllllIIlIlIlllllIlIlIII).getPacket() instanceof C0BPacketEntityAction) {
                llllllllllllllIIlIlIlllllIlIlIII.setCancelled(true);
            }
            else {
                final boolean b = ((EventReceivePacket)llllllllllllllIIlIlIlllllIlIlIII).getPacket() instanceof C03PacketPlayer.C06PacketPlayerPosLook;
            }
        }
        if (llllllllllllllIIlIlIlllllIlIlIII instanceof EventMotion) {
            this.setDisplayname(String.valueOf(new StringBuilder("Disabler §7").append(this.mode.getMode())));
            this.mode.is("Rede less flags");
        }
    }
    
    public Disabler() {
        super("Disabler", 0, Category.PLAYER);
        this.timer = new Timer();
        this.mode = new ModeSetting("Mode", this, "Rede less flags", new String[] { "Rede less flags" });
        this.addSettings(this.mode);
    }
}
