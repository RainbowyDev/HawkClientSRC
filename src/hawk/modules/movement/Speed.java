package hawk.modules.movement;

import hawk.modules.*;
import hawk.settings.*;
import hawk.events.*;
import hawk.events.listeners.*;
import hawk.modules.player.*;
import net.minecraft.potion.*;
import hawk.util.*;
import net.minecraft.client.entity.*;

public class Speed extends Module
{
    public /* synthetic */ ModeSetting mode;
    public /* synthetic */ NumberSetting SpeedVanilla;
    public /* synthetic */ NumberSetting hypixelpotionmultiplier;
    public /* synthetic */ NumberSetting hypixelspeed;
    /* synthetic */ boolean isWalking;
    /* synthetic */ Timer timer;
    public /* synthetic */ BooleanSetting AutoJump;
    
    public Speed() {
        super("Speed", 19, Category.MOVEMENT);
        this.timer = new Timer();
        this.isWalking = false;
        this.mode = new ModeSetting("Mode", this, "Vanilla", new String[] { "Vanilla", "Mineplex", "Hypixel", "NCP", "Redesky", "Legit bhop", "OldVerus" });
        this.SpeedVanilla = new NumberSetting("Speed for Vanilla", 0.5, 0.1, 5.0, 0.1, this);
        this.AutoJump = new BooleanSetting("Auto jump", false, this);
        this.hypixelspeed = new NumberSetting("WatchdogSpeed", 1.0, 1.0, 1.11, 0.01, this);
        this.hypixelpotionmultiplier = new NumberSetting("WatchdogPotionMultiplier", 0.0, 0.0, 0.1005, 0.005, this);
        this.addSettings(this.mode, this.AutoJump, this.SpeedVanilla, this.hypixelspeed, this.hypixelpotionmultiplier);
    }
    
    @Override
    public void onDisable() {
        this.mc.timer.timerSpeed = 1.0f;
        this.mc.thePlayer.speedInAir = 0.02f;
    }
    
    @Override
    public void onEvent(final Event lllllllllllllllIIlIIIllIlIllIIlI) {
        if (lllllllllllllllIIlIIIllIlIllIIlI instanceof EventUpdate) {
            this.setDisplayname(String.valueOf(new StringBuilder("Speed §7").append(this.mode.getValueName())));
            if (AutoSetting.enabled) {
                if (AutoSetting.isHypixel && !this.mode.is("Hypixel")) {
                    this.mode.cycle();
                }
                if (AutoSetting.isMineplex && !this.mode.is("Mineplex")) {
                    this.mode.cycle();
                }
                if (AutoSetting.isOldVerus && !this.mode.is("OldVerus")) {
                    this.mode.cycle();
                }
                if (AutoSetting.isRedesky && !this.mode.is("Redesky")) {
                    this.mode.cycle();
                }
            }
            if (lllllllllllllllIIlIIIllIlIllIIlI.isPre()) {
                if (this.AutoJump.isEnabled() && this.isWalking && this.mc.thePlayer.onGround && this.timer.hasTimeElapsed(100L, true)) {
                    this.mc.thePlayer.jump();
                }
                if (this.mc.thePlayer.motionX > 0.1 || this.mc.thePlayer.motionX < -0.1 || this.mc.thePlayer.motionZ > 0.1 || this.mc.thePlayer.motionZ < -0.1) {
                    this.isWalking = true;
                }
                else {
                    this.isWalking = false;
                }
                if (this.mode.is("Redesky")) {
                    this.mc.timer.timerSpeed = 1.0f;
                    if (this.mc.thePlayer.onGround) {
                        this.mc.thePlayer.jump();
                        final EntityPlayerSP thePlayer = this.mc.thePlayer;
                        thePlayer.motionX *= 1.270799994468689;
                        final EntityPlayerSP thePlayer2 = this.mc.thePlayer;
                        thePlayer2.motionZ *= 1.270799994468689;
                    }
                    else {
                        final EntityPlayerSP thePlayer3 = this.mc.thePlayer;
                        thePlayer3.motionX *= 0.9900000095367432;
                        final EntityPlayerSP thePlayer4 = this.mc.thePlayer;
                        thePlayer4.motionZ *= 0.9900000095367432;
                        if (this.mc.thePlayer.moveForward == 0.0f) {
                            this.mc.thePlayer.speedInAir = 0.03f;
                        }
                        else {
                            this.mc.thePlayer.speedInAir = 0.0225f;
                        }
                    }
                }
                if (this.mode.is("Vanilla")) {
                    this.mc.timer.timerSpeed = 1.0f;
                    SpeedModifier.setSpeed((float)this.SpeedVanilla.getValue());
                }
                if (this.mode.is("Mineplex")) {
                    if (this.mc.thePlayer.onGround) {
                        SpeedModifier.setSpeed(0.18f);
                    }
                    else {
                        SpeedModifier.setSpeed(0.32f);
                    }
                }
                if (this.mode.is("Legit bhop")) {
                    this.mc.timer.timerSpeed = 1.0f;
                    if (this.mc.thePlayer.onGround) {
                        this.mc.thePlayer.jump();
                    }
                    if (this.mc.thePlayer.isDead || this.mc.thePlayer.getHealth() <= 0.0f) {
                        this.toggled = false;
                        this.mc.timer.timerSpeed = 1.0f;
                    }
                }
                if (this.mode.is("Hypixel")) {
                    this.mc.timer.timerSpeed = 1.0f;
                    if (this.mc.thePlayer.onGround) {
                        this.mc.thePlayer.jump();
                        this.mc.timer.timerSpeed = 1.05f;
                        final EntityPlayerSP thePlayer5 = this.mc.thePlayer;
                        thePlayer5.motionX *= 1.0707999467849731;
                        final EntityPlayerSP thePlayer6 = this.mc.thePlayer;
                        thePlayer6.motionZ *= 1.0707999467849731;
                    }
                    else {
                        this.mc.thePlayer.jumpMovementFactor = 0.0265f;
                        this.mc.timer.timerSpeed = 1.05f;
                        final double lllllllllllllllIIlIIIllIlIllIlII = this.hypixelspeed.getValue() + (this.mc.thePlayer.isPotionActive(Potion.moveSpeed) ? this.hypixelpotionmultiplier.getValue() : 0.0);
                        PlayerUtil.setSpeed(PlayerUtil.getCurrentMotion() * lllllllllllllllIIlIIIllIlIllIlII);
                    }
                }
                if (this.mode.is("NCP")) {
                    if (this.mc.thePlayer.onGround) {
                        if (this.AutoJump.isEnabled()) {
                            final EntityPlayerSP thePlayer7 = this.mc.thePlayer;
                            thePlayer7.motionX *= 0.699999988079071;
                            final EntityPlayerSP thePlayer8 = this.mc.thePlayer;
                            thePlayer8.motionZ *= 0.699999988079071;
                        }
                        this.mc.thePlayer.isSprinting();
                    }
                    else if (this.mc.thePlayer.motionY > 0.0) {
                        SpeedModifier.setSpeed(0.27f);
                        final EntityPlayerSP thePlayer9 = this.mc.thePlayer;
                        thePlayer9.motionX *= 1.0299999713897705;
                        final EntityPlayerSP thePlayer10 = this.mc.thePlayer;
                        thePlayer10.motionZ *= 1.0299999713897705;
                    }
                    else {
                        SpeedModifier.setSpeed(0.27f);
                    }
                }
                if (this.mode.is("OldVerus")) {
                    this.mc.timer.timerSpeed = 1.0f;
                    if (this.isWalking && this.mc.thePlayer.onGround && this.timer.hasTimeElapsed(100L, true)) {
                        this.mc.thePlayer.jump();
                    }
                    if (this.mc.thePlayer.isSprinting()) {
                        if (this.mc.thePlayer.onGround) {
                            if (this.mc.thePlayer.moveForward > 0.0f) {
                                SpeedModifier.setSpeed(0.19f);
                            }
                            else {
                                SpeedModifier.setSpeed(0.14f);
                            }
                        }
                        else if (this.mc.thePlayer.moveForward > 0.0f) {
                            SpeedModifier.setSpeed(0.295f);
                        }
                        else {
                            SpeedModifier.setSpeed(0.29f);
                        }
                    }
                    else if (this.mc.thePlayer.onGround) {
                        if (this.mc.thePlayer.moveForward > 0.0f) {
                            SpeedModifier.setSpeed(0.16f);
                        }
                        else {
                            SpeedModifier.setSpeed(0.14f);
                        }
                    }
                    else if (this.mc.thePlayer.moveForward > 0.0f) {
                        SpeedModifier.setSpeed(0.25f);
                    }
                    else {
                        SpeedModifier.setSpeed(0.2f);
                    }
                }
            }
        }
    }
    
    @Override
    public void onEnable() {
        if (AutoSetting.enabled) {
            if (AutoSetting.isHypixel) {
                this.mode.is("Hypixel");
            }
            if (AutoSetting.isMineplex) {
                this.mode.is("Mineplex");
            }
            if (AutoSetting.isOldVerus) {
                this.mode.is("OldVerus");
            }
            if (AutoSetting.isRedesky) {
                this.mode.is("Redesky");
            }
        }
    }
}
