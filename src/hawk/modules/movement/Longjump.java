package hawk.modules.movement;

import hawk.modules.*;
import hawk.settings.*;
import hawk.events.*;
import hawk.events.listeners.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import net.minecraft.client.entity.*;

public class Longjump extends Module
{
    public /* synthetic */ ModeSetting mode;
    public /* synthetic */ NumberSetting timeroflj;
    
    public Longjump() {
        super("Longjump", 33, Category.MOVEMENT);
        this.mode = new ModeSetting("Mode", this, "Redesky fast", new String[] { "Redesky slow", "Redesky fast", "Redesky vroom" });
        this.timeroflj = new NumberSetting("Timer", 1.0, 0.1, 4.0, 0.1, this);
        this.addSettings(this.mode, this.timeroflj);
    }
    
    @Override
    public void onDisable() {
        this.mc.timer.timerSpeed = 1.0f;
        this.mc.thePlayer.speedInAir = 0.02f;
        this.mc.thePlayer.capabilities.isFlying = false;
    }
    
    @Override
    public void onEnable() {
        this.mode.is("Redesky vroom");
    }
    
    @Override
    public void onEvent(final Event lllllllllllllllIllIIIIlllIIllIII) {
        if (lllllllllllllllIllIIIIlllIIllIII instanceof EventUpdate) {
            this.setDisplayname(String.valueOf(new StringBuilder("LongJump §7").append(this.mode.getValueName())));
            if (this.mode.is("Redesky vroom")) {
                this.mc.thePlayer.sendQueue.addToSendQueue(new C00PacketKeepAlive(50000));
                this.mc.thePlayer.jumpMovementFactor = 0.1f;
                if (this.mc.thePlayer.onGround) {
                    this.mc.thePlayer.jump();
                }
                final EntityPlayerSP thePlayer = this.mc.thePlayer;
                thePlayer.motionX *= 0.949999988079071;
                final EntityPlayerSP thePlayer2 = this.mc.thePlayer;
                thePlayer2.motionY += 0.009999999776482582;
                final EntityPlayerSP thePlayer3 = this.mc.thePlayer;
                thePlayer3.motionZ *= 0.949999988079071;
                this.mc.thePlayer.speedInAir = 0.1f;
            }
            if (this.mode.is("Redesky fast")) {
                this.mc.timer.timerSpeed = (float)this.timeroflj.getValue();
                if (this.mc.thePlayer.fallDistance != 0.0f) {
                    this.mc.thePlayer.motionY += 0.039;
                }
                if (this.mc.thePlayer.onGround) {
                    this.mc.thePlayer.jump();
                }
                if (!this.mc.thePlayer.onGround) {
                    this.mc.thePlayer.motionY += 0.275;
                    final EntityPlayerSP thePlayer4 = this.mc.thePlayer;
                    thePlayer4.motionX *= 1.065000057220459;
                    final EntityPlayerSP thePlayer5 = this.mc.thePlayer;
                    thePlayer5.motionZ *= 1.065000057220459;
                }
            }
            else {
                this.mc.timer.timerSpeed = (float)this.timeroflj.getValue();
                if (this.mc.thePlayer.fallDistance != 0.0f) {
                    this.mc.thePlayer.motionY += 0.025;
                }
                if (this.mc.thePlayer.onGround) {
                    this.mc.thePlayer.jump();
                }
                if (!this.mc.thePlayer.onGround) {
                    this.mc.thePlayer.motionY += 0.055;
                    final EntityPlayerSP thePlayer6 = this.mc.thePlayer;
                    thePlayer6.motionX *= 1.045;
                    final EntityPlayerSP thePlayer7 = this.mc.thePlayer;
                    thePlayer7.motionZ *= 1.045;
                }
            }
        }
    }
}
