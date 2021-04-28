package hawk.modules.combat;

import hawk.modules.*;
import hawk.events.*;
import hawk.events.listeners.*;
import net.minecraft.network.play.server.*;
import hawk.settings.*;

public class Antikb extends Module
{
    public /* synthetic */ NumberSetting verticalKnockback;
    public /* synthetic */ BooleanSetting hypixel;
    public /* synthetic */ NumberSetting horizontalKnockback;
    
    @Override
    public void onEvent(final Event lllllllllllllllIIIIIIlIIIlIllIIl) {
        if (lllllllllllllllIIIIIIlIIIlIllIIl instanceof EventPacket && lllllllllllllllIIIIIIlIIIlIllIIl.isIncoming()) {
            final EventPacket lllllllllllllllIIIIIIlIIIlIlllII = (EventPacket)lllllllllllllllIIIIIIlIIIlIllIIl;
            if (EventPacket.packet instanceof S12PacketEntityVelocity) {
                final S12PacketEntityVelocity lllllllllllllllIIIIIIlIIIlIllIll = (S12PacketEntityVelocity)EventPacket.packet;
                if (this.hypixel.isEnabled()) {
                    lllllllllllllllIIIIIIlIIIlIllIll.setMotionX((int)(lllllllllllllllIIIIIIlIIIlIllIll.func_149411_d() / 100 * this.horizontalKnockback.getValue()));
                    lllllllllllllllIIIIIIlIIIlIllIll.setMotionY((int)(lllllllllllllllIIIIIIlIIIlIllIll.func_149410_e() / 100 * this.verticalKnockback.getValue()));
                    lllllllllllllllIIIIIIlIIIlIllIll.setMotionZ((int)(lllllllllllllllIIIIIIlIIIlIllIll.func_149409_f() / 100 * this.horizontalKnockback.getValue()));
                }
                else {
                    lllllllllllllllIIIIIIlIIIlIllIIl.setCancelled(true);
                }
            }
            else if (EventPacket.packet instanceof S27PacketExplosion) {
                lllllllllllllllIIIIIIlIIIlIllIIl.setCancelled(true);
            }
        }
    }
    
    @Override
    public void onDisable() {
    }
    
    public Antikb() {
        super("Velocity", 0, Category.COMBAT);
        this.hypixel = new BooleanSetting("Hypixel", false, this);
        this.horizontalKnockback = new NumberSetting("Horizontal Knockback", 0.0, -100.0, 100.0, 1.0, this);
        this.verticalKnockback = new NumberSetting("Vertical Knockback", 0.0, -100.0, 100.0, 1.0, this);
        this.addSettings(this.hypixel);
    }
    
    @Override
    public void onEnable() {
    }
}
