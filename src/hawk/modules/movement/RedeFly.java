package hawk.modules.movement;

import hawk.modules.*;
import hawk.util.*;
import hawk.events.*;
import hawk.events.listeners.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import net.minecraft.client.entity.*;
import hawk.settings.*;

public class RedeFly extends Module
{
    /* synthetic */ Timer timer;
    /* synthetic */ long oldPosZ;
    public /* synthetic */ BooleanSetting SpeedModifierA;
    public /* synthetic */ ModeSetting mode;
    public /* synthetic */ NumberSetting TimerSpeed;
    /* synthetic */ long oldPosX;
    public /* synthetic */ BooleanSetting DisableOnDeath;
    public /* synthetic */ NumberSetting Speed;
    /* synthetic */ long oldPosY;
    /* synthetic */ float multiplier;
    /* synthetic */ int a;
    
    @Override
    public void onEvent(final Event llllllllllllllIIlllIlIlllIIIIIII) {
        if (llllllllllllllIIlllIlIlllIIIIIII instanceof EventMotion) {
            this.mc.thePlayer.cameraYaw = 0.1f;
            this.setDisplayname(String.valueOf(new StringBuilder("Redefly §7").append(this.mode.getValueName())));
            if (this.DisableOnDeath.isEnabled() && (this.mc.thePlayer.getHealth() <= 0.0f || this.mc.thePlayer.isDead)) {
                this.toggled = false;
            }
            if (this.mode.is("Redesky")) {
                this.mc.thePlayer.cameraYaw = -0.2f;
                this.mc.thePlayer.sendQueue.addToSendQueue(new C00PacketKeepAlive(50000));
                this.mc.thePlayer.cameraYaw = -0.2f;
                if (this.timer.hasTimeElapsed(200L, false)) {
                    this.mc.timer.timerSpeed = 0.05f;
                    this.mc.thePlayer.motionY = 0.0;
                    this.mc.thePlayer.capabilities.isFlying = true;
                    this.mc.thePlayer.jumpMovementFactor = 0.06f;
                    this.mc.thePlayer.speedInAir = 0.08f;
                    if (this.timer.hasTimeElapsed(800L, true)) {
                        if (this.multiplier < 2.0f) {
                            this.mc.timer.timerSpeed = 2.0f;
                        }
                        else {
                            this.mc.timer.timerSpeed = 1.0f;
                        }
                        ++this.multiplier;
                    }
                }
            }
            else if (this.mode.is("Redesky 2")) {
                this.mc.thePlayer.capabilities.isFlying = true;
                this.mc.thePlayer.sendQueue.addToSendQueue(new C00PacketKeepAlive(10000));
                ((EventMotion)llllllllllllllIIlllIlIlllIIIIIII).setYaw(0.0f);
                ((EventMotion)llllllllllllllIIlllIlIlllIIIIIII).setPitch(0.0f);
                if (this.multiplier < 16.0f) {
                    this.mc.thePlayer.speedInAir = 0.15f;
                    this.mc.timer.timerSpeed = 0.6f;
                    this.mc.thePlayer.motionY = 0.11999999731779099;
                }
                if (this.multiplier >= 16.0f) {
                    this.mc.timer.timerSpeed = 0.25f;
                    final EntityPlayerSP thePlayer = this.mc.thePlayer;
                    thePlayer.motionY -= 0.014999999664723873;
                    this.mc.thePlayer.speedInAir = 0.04f;
                }
                if (this.timer.hasTimeElapsed(50L, true)) {
                    ++this.multiplier;
                    this.oldPosX = (long)this.mc.thePlayer.posX;
                    this.oldPosY = (long)this.mc.thePlayer.posY;
                    this.oldPosZ = (long)this.mc.thePlayer.posZ;
                }
            }
        }
    }
    
    @Override
    public void onDisable() {
        this.a = 0;
        final EntityPlayerSP thePlayer = this.mc.thePlayer;
        thePlayer.motionX *= this.mc.timer.timerSpeed;
        final EntityPlayerSP thePlayer2 = this.mc.thePlayer;
        thePlayer2.motionZ *= this.mc.timer.timerSpeed;
        this.mc.thePlayer.capabilities.isFlying = false;
        this.mc.timer.timerSpeed = 1.0f;
        this.mc.thePlayer.capabilities.setFlySpeed(0.045f);
        this.mc.thePlayer.speedInAir = 0.02f;
        this.mc.thePlayer.capabilities.isFlying = false;
        this.mc.timer.timerSpeed = 1.0f;
        this.multiplier = 1.0f;
        this.mc.thePlayer.capabilities.allowFlying = false;
    }
    
    @Override
    public void onEnable() {
        this.a = 0;
        this.multiplier = 0.0f;
        this.mode.is("OldRedesky");
        if (!this.mode.is("RedeSkyFast")) {
            this.mode.is("RedeSky");
        }
    }
    
    public RedeFly() {
        super("Redefly", 25, Category.MOVEMENT);
        this.timer = new Timer();
        this.mode = new ModeSetting("Mode", this, "Redesky", new String[] { "Redesky", "Redesky 2" });
        this.DisableOnDeath = new BooleanSetting("Disable on death", true, this);
        this.SpeedModifierA = new BooleanSetting("SpeedModifier", false, this);
        this.Speed = new NumberSetting("Speed", 0.3, 0.05, 4.0, 0.05, this);
        this.TimerSpeed = new NumberSetting("Timer", 0.2, 0.05, 4.0, 0.05, this);
        this.multiplier = 1.0f;
        this.addSettings(this.mode, this.DisableOnDeath, this.SpeedModifierA, this.Speed, this.TimerSpeed);
    }
}
