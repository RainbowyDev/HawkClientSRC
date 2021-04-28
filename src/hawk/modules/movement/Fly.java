package hawk.modules.movement;

import hawk.modules.*;
import hawk.util.*;
import hawk.settings.*;
import hawk.modules.player.*;
import hawk.events.*;
import net.minecraft.network.play.server.*;
import net.minecraft.network.play.client.*;
import hawk.events.listeners.*;
import net.minecraft.client.entity.*;

public class Fly extends Module
{
    public /* synthetic */ NumberSetting VanillaSpeed;
    /* synthetic */ Timer timer;
    public /* synthetic */ NumberSetting GlideMotionY;
    public /* synthetic */ BooleanSetting DisableOnDeath;
    public /* synthetic */ ModeSetting mode;
    
    public Fly() {
        super("Fly", 25, Category.MOVEMENT);
        this.timer = new Timer();
        this.mode = new ModeSetting("Mode", this, "Vanilla", new String[] { "Creative", "Redesky", "OldVerus", "RedeSkyFast", "Vanilla", "Airwalk", "Glide", "Bhopland", "Minebox" });
        this.DisableOnDeath = new BooleanSetting("Disable on death", true, this);
        this.VanillaSpeed = new NumberSetting("Speed (Vanilla)", 1.0, 0.1, 10.0, 0.1, this);
        this.GlideMotionY = new NumberSetting("Motion Y (Glide)", 0.05, 0.01, 1.0, 0.01, this);
        this.addSettings(this.mode, this.VanillaSpeed, this.DisableOnDeath);
    }
    
    public void AutoSetting() {
        if (AutoSetting.isHypixel && !this.mode.is("Vanilla fast")) {
            this.mode.cycle();
        }
        if (AutoSetting.isMineplex && !this.mode.is("Vanilla fast")) {
            this.mode.cycle();
        }
        if (AutoSetting.isOldVerus && !this.mode.is("OldVerus")) {
            this.mode.cycle();
        }
        if (AutoSetting.isRedesky && !this.mode.is("Redesky")) {
            this.mode.cycle();
        }
    }
    
    @Override
    public void onEvent(final Event llllllllllllllIIlIlIIIIlIlIIlllI) {
        if (llllllllllllllIIlIlIIIIlIlIIlllI instanceof EventSendPacket) {
            final EventSendPacket llllllllllllllIIlIlIIIIlIlIIllIl = (EventSendPacket)llllllllllllllIIlIlIIIIlIlIIlllI;
            if (llllllllllllllIIlIlIIIIlIlIIllIl.getPacket() instanceof C03PacketPlayer && this.mode.is("Minebox")) {
                final C03PacketPlayer llllllllllllllIIlIlIIIIlIlIIllII = (C03PacketPlayer)llllllllllllllIIlIlIIIIlIlIIllIl.getPacket();
                llllllllllllllIIlIlIIIIlIlIIllII.onground = true;
            }
        }
        if (llllllllllllllIIlIlIIIIlIlIIlllI instanceof EventReceivePacket && this.mode.is("Minebox")) {
            final EventReceivePacket llllllllllllllIIlIlIIIIlIlIIlIll = (EventReceivePacket)llllllllllllllIIlIlIIIIlIlIIlllI;
            if (((EventReceivePacket)llllllllllllllIIlIlIIIIlIlIIlllI).getPacket() instanceof S00PacketKeepAlive) {
                llllllllllllllIIlIlIIIIlIlIIlllI.setCancelled(true);
            }
            if (((EventReceivePacket)llllllllllllllIIlIlIIIIlIlIIlllI).getPacket() instanceof C0FPacketConfirmTransaction) {
                llllllllllllllIIlIlIIIIlIlIIlllI.setCancelled(true);
            }
        }
        if (AutoSetting.enabled) {
            if (AutoSetting.isHypixel && !this.mode.is("Vanilla fast")) {
                this.mode.cycle();
            }
            if (AutoSetting.isMineplex && !this.mode.is("Vanilla fast")) {
                this.mode.cycle();
            }
            if (AutoSetting.isOldVerus && !this.mode.is("OldVerus")) {
                this.mode.cycle();
            }
            if (AutoSetting.isRedesky && !this.mode.is("Redesky")) {
                this.mode.cycle();
            }
        }
        if (llllllllllllllIIlIlIIIIlIlIIlllI instanceof EventMotion) {
            this.mc.thePlayer.cameraYaw = 0.1f;
            this.setDisplayname(String.valueOf(new StringBuilder("Fly §7").append(this.mode.getMode())));
            if (this.DisableOnDeath.isEnabled() && (this.mc.thePlayer.getHealth() <= 0.0f || this.mc.thePlayer.isDead)) {
                this.toggled = false;
            }
            if (this.mode.is("Creative")) {
                this.mc.thePlayer.capabilities.isFlying = true;
                this.mc.timer.timerSpeed = 1.0f;
                this.mc.thePlayer.capabilities.setFlySpeed(0.07f);
            }
            if (this.mode.is("Redesky")) {
                if (this.mc.thePlayer.onGround) {
                    this.mc.thePlayer.setSprinting(true);
                    this.mc.thePlayer.jump();
                }
                if (this.mc.thePlayer.motionY < 0.0) {
                    this.mc.timer.timerSpeed = 0.3f;
                    this.mc.thePlayer.speedInAir = 0.1f;
                    this.mc.thePlayer.motionY = 0.0;
                    if (this.mc.thePlayer.ticksExisted % 8 == 0) {
                        this.mc.timer.timerSpeed = 25.0f;
                    }
                }
            }
            else if (this.mode.is("RedeSkyFast")) {
                this.mc.thePlayer.capabilities.isFlying = true;
                this.mc.thePlayer.setSprinting(false);
                this.mc.timer.timerSpeed = 2.0f;
            }
            if (this.mode.is("OldVerus")) {
                if (this.timer.hasTimeElapsed(500L, true)) {
                    final EntityPlayerSP thePlayer = this.mc.thePlayer;
                    thePlayer.posY -= 0.20000000298023224;
                    this.mc.thePlayer.onGround = false;
                    final EntityPlayerSP thePlayer2 = this.mc.thePlayer;
                    thePlayer2.motionX *= 0.10000000149011612;
                    final EntityPlayerSP thePlayer3 = this.mc.thePlayer;
                    thePlayer3.motionZ *= 0.10000000149011612;
                    ((EventMotion)llllllllllllllIIlIlIIIIlIlIIlllI).setOnGround(true);
                }
                else {
                    this.mc.thePlayer.motionY = 0.0;
                    this.mc.thePlayer.onGround = true;
                    ((EventMotion)llllllllllllllIIlIlIIIIlIlIIlllI).setOnGround(true);
                }
            }
            if (this.mode.is("Vanilla")) {
                SpeedModifier.setSpeed((float)this.VanillaSpeed.getValue());
                if (!this.mc.gameSettings.keyBindJump.isPressed() && !this.mc.gameSettings.keyBindSneak.isPressed()) {
                    this.mc.thePlayer.motionY = 0.0;
                    this.mc.thePlayer.onGround = true;
                }
                if (this.mc.gameSettings.keyBindJump.getIsKeyPressed()) {
                    this.mc.thePlayer.motionY = this.VanillaSpeed.getValue();
                    this.mc.thePlayer.setJumping(false);
                }
                if (this.mc.gameSettings.keyBindSneak.getIsKeyPressed()) {
                    this.mc.thePlayer.motionY = this.VanillaSpeed.getValue() * -1.0;
                }
            }
            if (this.mode.is("Glide")) {
                this.mc.thePlayer.onGround = true;
                this.mc.thePlayer.motionY = this.GlideMotionY.getValue() * -1.0;
            }
            if (this.mode.is("Airwalk")) {
                this.mc.thePlayer.motionY = 0.0;
                this.mc.thePlayer.onGround = true;
                if (this.timer.hasTimeElapsed(100L, true)) {
                    final EntityPlayerSP thePlayer4 = this.mc.thePlayer;
                    thePlayer4.motionX *= 100.0;
                    final EntityPlayerSP thePlayer5 = this.mc.thePlayer;
                    thePlayer5.motionZ *= 100.0;
                }
                final EntityPlayerSP thePlayer6 = this.mc.thePlayer;
                thePlayer6.motionX *= 0.009999999776482582;
                final EntityPlayerSP thePlayer7 = this.mc.thePlayer;
                thePlayer7.motionZ *= 0.009999999776482582;
            }
            if (this.mode.is("Bhopland")) {
                this.mc.thePlayer.motionY = 0.0;
                this.mc.thePlayer.onGround = true;
                if ((this.mc.timer.timerSpeed == 1.0f || this.mc.timer.timerSpeed > 1.0f) && this.timer.hasTimeElapsed(50L, true)) {
                    final net.minecraft.util.Timer timer = this.mc.timer;
                    timer.timerSpeed -= 0.01f;
                    final EntityPlayerSP thePlayer8 = this.mc.thePlayer;
                    thePlayer8.motionX *= 1.0499999523162842;
                    final EntityPlayerSP thePlayer9 = this.mc.thePlayer;
                    thePlayer9.motionZ *= 1.0499999523162842;
                }
            }
            if (this.mode.is("Minebox")) {
                this.mc.thePlayer.speedInAir = 0.1f;
                this.mc.thePlayer.capabilities.isFlying = true;
                this.mc.thePlayer.motionY = -0.07999999821186066;
                this.mc.timer.timerSpeed = 0.5f;
            }
        }
    }
    
    @Override
    public void onEnable() {
        if (this.mode.is("RedeSkyFast") || this.mode.is("Bhopland")) {
            this.mc.thePlayer.jump();
        }
        if (this.mode.is("Bhopland")) {
            this.mc.timer.timerSpeed = 1.25f;
        }
        if (!this.mode.is("RedeSkyFast")) {
            this.mode.is("RedeSky");
        }
        if (AutoSetting.enabled) {
            if (AutoSetting.isHypixel && !this.mode.is("Vanilla fast")) {
                this.mode.cycle();
            }
            if (AutoSetting.isMineplex && !this.mode.is("Vanilla fast")) {
                this.mode.cycle();
            }
            if (AutoSetting.isOldVerus && !this.mode.is("OldVerus")) {
                this.mode.cycle();
            }
            if (AutoSetting.isRedesky && !this.mode.is("Redesky")) {
                this.mode.cycle();
            }
        }
    }
    
    @Override
    public void onDisable() {
        this.mc.thePlayer.capabilities.isFlying = false;
        this.mc.timer.timerSpeed = 1.0f;
        this.mc.thePlayer.capabilities.setFlySpeed(0.045f);
        this.mc.thePlayer.speedInAir = 0.02f;
        if (this.mode.is("OldVerus")) {
            final EntityPlayerSP thePlayer = this.mc.thePlayer;
            thePlayer.motionX *= 0.009999999776482582;
            final EntityPlayerSP thePlayer2 = this.mc.thePlayer;
            thePlayer2.motionZ *= 0.009999999776482582;
        }
        this.mc.thePlayer.capabilities.isFlying = false;
        this.mc.timer.timerSpeed = 1.0f;
    }
}
