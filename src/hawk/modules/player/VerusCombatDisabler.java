package hawk.modules.player;

import hawk.modules.*;
import hawk.events.*;
import hawk.events.listeners.*;
import net.minecraft.network.play.client.*;

public class VerusCombatDisabler extends Module
{
    @Override
    public void onEvent(final Event llllllllllllllIIllIlllIlIlIlIlll) {
        if (llllllllllllllIIllIlllIlIlIlIlll instanceof EventPacket && llllllllllllllIIllIlllIlIlIlIlll.isIncoming()) {
            final EventPacket llllllllllllllIIllIlllIlIlIlIllI = (EventPacket)llllllllllllllIIllIlllIlIlIlIlll;
            if (EventPacket.getPacket() instanceof C0FPacketConfirmTransaction) {
                llllllllllllllIIllIlllIlIlIlIllI.setCancelled(true);
            }
        }
    }
    
    public VerusCombatDisabler() {
        super("FakeVerusCombatDisabler", 0, Category.PLAYER);
    }
}
