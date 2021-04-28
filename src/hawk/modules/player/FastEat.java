package hawk.modules.player;

import hawk.modules.*;
import hawk.util.*;
import hawk.events.*;
import hawk.events.listeners.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;

public class FastEat extends Module
{
    /* synthetic */ Timer timer;
    /* synthetic */ boolean PlayerEat;
    
    @Override
    public void onEvent(final Event llllllllllllllIllIIlIIllIIIIIIll) {
        if (llllllllllllllIllIIlIIllIIIIIIll instanceof EventUpdate && llllllllllllllIllIIlIIllIIIIIIll.isPre() && !this.mc.thePlayer.isBlocking() && this.mc.thePlayer.isEating()) {
            for (int llllllllllllllIllIIlIIllIIIIIIlI = 0; llllllllllllllIllIIlIIllIIIIIIlI < 10; ++llllllllllllllIllIIlIIllIIIIIIlI) {
                this.mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer());
            }
        }
    }
    
    public FastEat() {
        super("FastEat", 0, Category.PLAYER);
        this.timer = new Timer();
        this.PlayerEat = false;
    }
}
