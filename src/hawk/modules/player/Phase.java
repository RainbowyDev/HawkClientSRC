package hawk.modules.player;

import hawk.modules.*;
import hawk.util.*;
import hawk.events.*;
import hawk.events.listeners.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;

public class Phase extends Module
{
    /* synthetic */ Timer timer;
    
    @Override
    public void onEvent(final Event llllllllllllllllIIIIIlIllIllllIl) {
        if (llllllllllllllllIIIIIlIllIllllIl instanceof EventMotion) {
            llllllllllllllllIIIIIlIllIllllIl.isPre();
        }
        final boolean b = llllllllllllllllIIIIIlIllIllllIl instanceof EventSendPacket;
    }
    
    public Phase() {
        super("Phase", 36, Category.PLAYER);
        this.timer = new Timer();
    }
    
    @Override
    public void onEnable() {
        this.mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C06PacketPlayerPosLook(this.mc.thePlayer.posX, this.mc.thePlayer.posY - 1.0E-8, this.mc.thePlayer.posZ, this.mc.thePlayer.rotationYaw, this.mc.thePlayer.rotationPitch, false));
        this.mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C06PacketPlayerPosLook(this.mc.thePlayer.posX, this.mc.thePlayer.posY - 1.0, this.mc.thePlayer.posZ, this.mc.thePlayer.rotationYaw, this.mc.thePlayer.rotationPitch, false));
    }
}
