package hawk.modules.player;

import hawk.modules.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import hawk.events.listeners.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;

public class REDESKYDISABLEROMIKRONHALLAHFREEDOWNLOADNOVIRUS2013 extends Module
{
    /* synthetic */ boolean started;
    
    public REDESKYDISABLEROMIKRONHALLAHFREEDOWNLOADNOVIRUS2013() {
        super("Redesky disabler 100% no fake", 0, Category.PLAYER);
        this.started = false;
    }
    
    public void onMotion(final EventMotion llllllllllllllllIlIlIIIIIIllIlll) {
        if (llllllllllllllllIlIlIIIIIIllIlll.isPre()) {
            llllllllllllllllIlIlIIIIIIllIlll.setPitch(90.0f);
            this.mc.playerController.attackEntity(this.mc.thePlayer, this.mc.thePlayer);
        }
    }
    
    @Override
    public void onDisable() {
        System.err.println(String.valueOf(new StringBuilder("Player velocity").append(this.mc.thePlayer.velocityChanged)));
    }
    
    public void onSendPacket(final EventSendPacket llllllllllllllllIlIlIIIIIIlllllI) {
        final Packet llllllllllllllllIlIlIIIIIIllllll = llllllllllllllllIlIlIIIIIIlllllI.getPacket();
        if (llllllllllllllllIlIlIIIIIIllllll instanceof C03PacketPlayer.C06PacketPlayerPosLook) {
            llllllllllllllllIlIlIIIIIIlllllI.setCancelled(true);
        }
    }
    
    @Override
    public void onEnable() {
        this.started = false;
        final Thread llllllllllllllllIlIlIIIIIlIIlIIl = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000L);
                }
                catch (InterruptedException llllllllllllllIllllIlIIIlIllIllI) {
                    llllllllllllllIllllIlIIIlIllIllI.printStackTrace();
                }
                REDESKYDISABLEROMIKRONHALLAHFREEDOWNLOADNOVIRUS2013.this.started = true;
            }
        };
        llllllllllllllllIlIlIIIIIlIIlIIl.start();
    }
}
