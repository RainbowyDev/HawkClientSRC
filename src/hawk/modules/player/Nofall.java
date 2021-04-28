package hawk.modules.player;

import hawk.modules.*;
import hawk.events.*;
import net.minecraft.network.play.client.*;
import hawk.modules.combat.*;
import hawk.events.listeners.*;
import net.minecraft.network.*;
import hawk.settings.*;

public class Nofall extends Module
{
    /* synthetic */ int packetsent;
    public /* synthetic */ ModeSetting mode;
    
    @Override
    public void onEvent(final Event llllllllllllllIIIIIlIlllIllIIlII) {
        this.setDisplayname(String.valueOf(new StringBuilder("Nofall §7").append(this.mode.getMode())));
        if (llllllllllllllIIIIIlIlllIllIIlII instanceof EventSendPacket) {
            final EventSendPacket llllllllllllllIIIIIlIlllIllIlIIl = (EventSendPacket)llllllllllllllIIIIIlIlllIllIIlII;
            if (llllllllllllllIIIIIlIlllIllIlIIl.getPacket() instanceof C03PacketPlayer && !Killaura.HasTarget) {
                if (this.mode.is("SpoofGround")) {
                    final C03PacketPlayer llllllllllllllIIIIIlIlllIllIlIII = (C03PacketPlayer)llllllllllllllIIIIIlIlllIllIlIIl.getPacket();
                    llllllllllllllIIIIIlIlllIllIlIII.onground = true;
                }
                if (this.mode.is("NoGround")) {
                    final C03PacketPlayer llllllllllllllIIIIIlIlllIllIIlll = (C03PacketPlayer)llllllllllllllIIIIIlIlllIllIlIIl.getPacket();
                    llllllllllllllIIIIIlIlllIllIIlll.onground = false;
                }
                if (this.mode.is("RedeskyTest")) {
                    final C03PacketPlayer llllllllllllllIIIIIlIlllIllIIllI = (C03PacketPlayer)llllllllllllllIIIIIlIlllIllIlIIl.getPacket();
                    if (this.mc.thePlayer.fallDistance > 3.0f) {
                        llllllllllllllIIIIIlIlllIllIIllI.onground = true;
                    }
                }
            }
        }
        if (llllllllllllllIIIIIlIlllIllIIlII instanceof EventUpdate && llllllllllllllIIIIIlIlllIllIIlII.isPre() && this.mode.is("Vanilla") && this.mc.thePlayer.fallDistance > 3.0f) {
            this.mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer(true));
        }
    }
    
    public Nofall() {
        super("Nofall", 0, Category.PLAYER);
        this.packetsent = 0;
        this.mode = new ModeSetting("Mode", this, "SpoofGround", new String[] { "SpoofGround", "NoGround", "RedeskyTest", "Vanilla" });
        this.addSettings(this.mode);
    }
}
