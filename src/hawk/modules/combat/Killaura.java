package hawk.modules.combat;

import hawk.modules.*;
import hawk.util.*;
import net.minecraft.entity.*;
import hawk.modules.player.*;
import net.minecraft.entity.player.*;
import hawk.settings.*;
import hawk.events.*;
import java.util.function.*;
import java.util.stream.*;
import java.util.*;
import net.minecraft.network.*;
import net.minecraft.network.play.client.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import hawk.events.listeners.*;
import net.minecraft.client.gui.*;

public class Killaura extends Module
{
    public /* synthetic */ BooleanSetting OnlyPlayers;
    public /* synthetic */ NumberSetting HitChance;
    public /* synthetic */ Timer timer;
    public /* synthetic */ BooleanSetting HitInvisible;
    public /* synthetic */ ModeSetting criticals;
    public static /* synthetic */ boolean HasTarget;
    /* synthetic */ double redeskypercent;
    public /* synthetic */ BooleanSetting Autoblock;
    public /* synthetic */ EntityLivingBase target;
    public /* synthetic */ Random random;
    public /* synthetic */ double bb2;
    public /* synthetic */ BooleanSetting noSwing;
    public /* synthetic */ NumberSetting range;
    public /* synthetic */ int aa1;
    public /* synthetic */ int hit;
    public /* synthetic */ ModeSetting Rotation;
    /* synthetic */ int redeskyrotation;
    public /* synthetic */ double aa2;
    public /* synthetic */ NumberSetting aps;
    public /* synthetic */ BooleanSetting DisableOnDeath;
    public /* synthetic */ int bb1;
    
    @Override
    public void onEnable() {
        this.redeskypercent = 0.30000001192092896;
        if (AutoSetting.enabled) {
            if (AutoSetting.isHypixel) {
                this.aps.setValue(10.5);
                this.range.setValue(4.0);
                if (!this.Rotation.is("Basic")) {
                    this.Rotation.cycle();
                }
                this.OnlyPlayers.enabled = true;
                this.HitInvisible.enabled = false;
                this.Autoblock.enabled = true;
            }
            if (AutoSetting.isMineplex) {
                this.aps.setValue(11.5);
                this.range.setValue(3.3);
                if (!this.Rotation.is("Basic")) {
                    this.Rotation.cycle();
                }
                this.OnlyPlayers.enabled = true;
                this.HitInvisible.enabled = false;
                this.Autoblock.enabled = true;
            }
            if (AutoSetting.isRedesky) {
                this.aps.setValue(12.5);
                this.range.setValue(4.8);
                if (!this.Rotation.is("Redesky")) {
                    this.Rotation.cycle();
                }
                this.OnlyPlayers.enabled = true;
                this.HitInvisible.enabled = false;
                this.Autoblock.enabled = true;
            }
            if (AutoSetting.isOldVerus) {
                this.aps.setValue(10.5);
                this.range.setValue(3.2);
                if (!this.Rotation.is("OldVerus")) {
                    this.Rotation.cycle();
                }
                this.OnlyPlayers.enabled = true;
                this.HitInvisible.enabled = false;
                this.Autoblock.enabled = true;
            }
        }
    }
    
    public Killaura() {
        super("Killaura", 45, Category.COMBAT);
        this.random = new Random();
        this.aa1 = 0;
        this.aa2 = 0.0;
        this.bb1 = 0;
        this.bb2 = 0.0;
        this.timer = new Timer();
        this.aps = new NumberSetting("APS", 10.0, 1.0, 20.0, 0.5, this);
        this.HitChance = new NumberSetting("Hit chance", 99.0, 1.0, 100.0, 2.0, this);
        this.range = new NumberSetting("Range", 4.0, 1.0, 6.0, 0.1, this);
        this.noSwing = new BooleanSetting("No Swing", false, this);
        this.DisableOnDeath = new BooleanSetting("Disable on death", true, this);
        this.Rotation = new ModeSetting("Rotation", this, "Basic", new String[] { "None", "Basic", "Basic Legit", "NCP", "Redesky", "No sprint" });
        this.OnlyPlayers = new BooleanSetting("Only Players", false, this);
        this.HitInvisible = new BooleanSetting("Hit invisibles", false, this);
        this.Autoblock = new BooleanSetting("Autoblock", true, this);
        this.criticals = new ModeSetting("Criticals", this, "None", new String[] { "None", "Redesky" });
        this.redeskypercent = 0.30000001192092896;
        this.addSettings(this.aps, this.range, this.noSwing, this.Rotation, this.DisableOnDeath, this.OnlyPlayers, this.HitInvisible, this.Autoblock, this.HitChance);
    }
    
    static {
        Killaura.HasTarget = false;
    }
    
    @Override
    public void onEvent(final Event llllllllllllllllIlIllIIlIlIlIIll) {
        if (AutoSetting.enabled) {
            if (AutoSetting.isHypixel) {
                this.aps.setValue(10.5);
                this.range.setValue(4.0);
                if (!this.Rotation.is("Basic")) {
                    this.Rotation.cycle();
                }
                this.OnlyPlayers.enabled = true;
                this.HitInvisible.enabled = false;
                this.Autoblock.enabled = true;
            }
            if (AutoSetting.isMineplex) {
                this.aps.setValue(11.5);
                this.range.setValue(3.3);
                if (!this.Rotation.is("Basic")) {
                    this.Rotation.cycle();
                }
                this.OnlyPlayers.enabled = true;
                this.HitInvisible.enabled = false;
                this.Autoblock.enabled = true;
            }
            if (AutoSetting.isRedesky) {
                this.aps.setValue(12.5);
                this.range.setValue(4.8);
                if (!this.Rotation.is("Redesky")) {
                    this.Rotation.cycle();
                }
                this.OnlyPlayers.enabled = true;
                this.HitInvisible.enabled = false;
                this.Autoblock.enabled = true;
            }
            if (AutoSetting.isOldVerus) {
                this.aps.setValue(10.5);
                this.range.setValue(3.2);
                if (!this.Rotation.is("OldVerus")) {
                    this.Rotation.cycle();
                }
                this.OnlyPlayers.enabled = true;
                this.HitInvisible.enabled = false;
                this.Autoblock.enabled = true;
            }
        }
        if (llllllllllllllllIlIllIIlIlIlIIll instanceof EventMotion) {
            if (llllllllllllllllIlIllIIlIlIlIIll.isPre()) {
                final EventMotion llllllllllllllllIlIllIIlIlIlllII = (EventMotion)llllllllllllllllIlIllIIlIlIlIIll;
                List<EntityLivingBase> llllllllllllllllIlIllIIlIlIllIll = (List<EntityLivingBase>)this.mc.theWorld.loadedEntityList.stream().filter(EntityLivingBase.class::isInstance).collect(Collectors.toList());
                if (this.HitInvisible.isEnabled()) {
                    if (AutoSetting.isMineplex) {
                        llllllllllllllllIlIllIIlIlIllIll = llllllllllllllllIlIllIIlIlIllIll.stream().filter(llllllllllllllllIlIllIIlIIllIIll -> llllllllllllllllIlIllIIlIIllIIll.getDistanceToEntity(this.mc.thePlayer) < this.range.getValue() && llllllllllllllllIlIllIIlIIllIIll != this.mc.thePlayer && llllllllllllllllIlIllIIlIIllIIll.getHealth() > 0.0f && !llllllllllllllllIlIllIIlIIllIIll.isDead).collect((Collector<? super Object, ?, List<EntityLivingBase>>)Collectors.toList());
                    }
                    else {
                        llllllllllllllllIlIllIIlIlIllIll = llllllllllllllllIlIllIIlIlIllIll.stream().filter(llllllllllllllllIlIllIIlIIlIllIl -> llllllllllllllllIlIllIIlIIlIllIl.getDistanceToEntity(this.mc.thePlayer) < this.range.getValue() && llllllllllllllllIlIllIIlIIlIllIl != this.mc.thePlayer && !llllllllllllllllIlIllIIlIIlIllIl.isDead).collect((Collector<? super Object, ?, List<EntityLivingBase>>)Collectors.toList());
                    }
                }
                else {
                    if (AutoSetting.isMineplex) {
                        llllllllllllllllIlIllIIlIlIllIll = llllllllllllllllIlIllIIlIlIllIll.stream().filter(llllllllllllllllIlIllIIlIIlIIlIl -> llllllllllllllllIlIllIIlIIlIIlIl.getDistanceToEntity(this.mc.thePlayer) < this.range.getValue() && !llllllllllllllllIlIllIIlIIlIIlIl.isInvisible() && !llllllllllllllllIlIllIIlIIlIIlIl.isInvisibleToPlayer(this.mc.thePlayer) && llllllllllllllllIlIllIIlIIlIIlIl != this.mc.thePlayer && llllllllllllllllIlIllIIlIIlIIlIl.getHealth() > 0.0f && !llllllllllllllllIlIllIIlIIlIIlIl.isDead).collect((Collector<? super Object, ?, List<EntityLivingBase>>)Collectors.toList());
                    }
                    llllllllllllllllIlIllIIlIlIllIll = llllllllllllllllIlIllIIlIlIllIll.stream().filter(llllllllllllllllIlIllIIlIIlIIIIl -> llllllllllllllllIlIllIIlIIlIIIIl.getDistanceToEntity(this.mc.thePlayer) < this.range.getValue() && !llllllllllllllllIlIllIIlIIlIIIIl.isInvisible() && !llllllllllllllllIlIllIIlIIlIIIIl.isInvisibleToPlayer(this.mc.thePlayer) && llllllllllllllllIlIllIIlIIlIIIIl != this.mc.thePlayer && !llllllllllllllllIlIllIIlIIlIIIIl.isDead).collect((Collector<? super Object, ?, List<EntityLivingBase>>)Collectors.toList());
                }
                llllllllllllllllIlIllIIlIlIllIll.sort(Comparator.comparingDouble(llllllllllllllllIlIllIIlIIIllIIl -> llllllllllllllllIlIllIIlIIIllIIl.getDistanceToEntity(this.mc.thePlayer)));
                if (this.OnlyPlayers.isEnabled()) {
                    llllllllllllllllIlIllIIlIlIllIll = llllllllllllllllIlIllIIlIlIllIll.stream().filter(EntityPlayer.class::isInstance).collect((Collector<? super Object, ?, List<EntityLivingBase>>)Collectors.toList());
                }
                if (!llllllllllllllllIlIllIIlIlIllIll.isEmpty()) {
                    final ScaledResolution llllllllllllllllIlIllIIlIlIllIlI = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
                    final FontRenderer llllllllllllllllIlIllIIlIlIllIIl = this.mc.fontRendererObj;
                    this.target = llllllllllllllllIlIllIIlIlIllIll.get(0);
                    if (llllllllllllllllIlIllIIlIlIlIIll instanceof EventRenderGUI) {
                        System.out.println("aaaaaaaaaaaaaaaaa");
                        llllllllllllllllIlIllIIlIlIllIIl.drawString(String.valueOf(new StringBuilder(String.valueOf(this.target.getName())).append(this.target.getHealth())), 300.0, 300.0, -1);
                    }
                    Killaura.HasTarget = true;
                    if (this.Rotation.is("Basic Legit")) {
                        this.mc.thePlayer.rotationYaw = this.getRotations(this.target)[0] + this.random.nextInt(20) - 10.0f;
                        this.mc.thePlayer.rotationPitch = this.getRotations(this.target)[1] + this.random.nextInt(20) - 10.0f;
                    }
                    if (this.Rotation.is("Basic")) {
                        llllllllllllllllIlIllIIlIlIlllII.setYaw(this.getRotations(this.target)[0] + this.random.nextInt(20) - 10.0f);
                        llllllllllllllllIlIllIIlIlIlllII.setPitch(this.getRotations(this.target)[1] + this.random.nextInt(20) - 10.0f);
                    }
                    if (this.Rotation.is("NCP")) {
                        llllllllllllllllIlIllIIlIlIlllII.setYaw(this.getRotations(this.target)[0] + this.random.nextInt(12) - 6.0f);
                        llllllllllllllllIlIllIIlIlIlllII.setPitch(this.getRotations(this.target)[1] + this.random.nextInt(12) - 6.0f);
                    }
                    if (this.Rotation.is("No sprint")) {
                        llllllllllllllllIlIllIIlIlIlllII.setYaw(this.getRotations(this.target)[0] + this.random.nextInt(20) - 10.0f);
                        llllllllllllllllIlIllIIlIlIlllII.setPitch(this.getRotations(this.target)[1] + this.random.nextInt(20) - 10.0f);
                        if (!llllllllllllllllIlIllIIlIlIllIll.isEmpty()) {
                            this.mc.thePlayer.setSprinting(false);
                        }
                    }
                    if (this.timer.hasTimeElapsed(500L, true)) {
                        if (this.redeskyrotation == 0) {
                            this.redeskyrotation = 1;
                        }
                        else if (this.redeskyrotation == 1) {
                            this.redeskyrotation = 2;
                        }
                        else if (this.redeskyrotation == 2) {
                            this.redeskyrotation = 0;
                        }
                    }
                    if (this.Rotation.is("Redesky") && !this.mc.thePlayer.isSprinting() && this.timer.hasTimeElapsed(50L, true)) {
                        llllllllllllllllIlIllIIlIlIlllII.setYaw(this.getRotations(this.target)[0] + (this.random.nextInt(8) - 4));
                        llllllllllllllllIlIllIIlIlIlllII.setPitch(this.getRotations(this.target)[1] + (this.random.nextInt(8) - 4));
                    }
                    if (!this.Rotation.is("NCP")) {
                        if (this.DisableOnDeath.isEnabled() && (this.mc.thePlayer.isDead || this.mc.thePlayer.getHealth() <= 0.0f)) {
                            this.toggled = false;
                        }
                        if (this.timer.hasTimeElapsed((long)((long)(1000.0 / this.aps.getValue()) / this.mc.timer.timerSpeed), true)) {
                            if (this.noSwing.isEnabled()) {
                                this.mc.thePlayer.sendQueue.addToSendQueue(new C0APacketAnimation());
                            }
                            else {
                                this.mc.thePlayer.swingItem();
                            }
                            this.mc.thePlayer.clearItemInUse();
                            this.hit = this.random.nextInt(100) - 1;
                            if (this.hit <= this.HitChance.getValue()) {
                                this.mc.thePlayer.sendQueue.addToSendQueue(new C02PacketUseEntity(this.target, C02PacketUseEntity.Action.ATTACK));
                            }
                            if (this.redeskypercent < 1.0) {
                                this.redeskypercent += 1.5 / this.aps.getValue();
                            }
                        }
                    }
                }
                else {
                    Killaura.HasTarget = false;
                    this.redeskypercent = 0.30000001192092896;
                }
            }
            else {
                final EventMotion llllllllllllllllIlIllIIlIlIllIII = (EventMotion)llllllllllllllllIlIllIIlIlIlIIll;
                List<EntityLivingBase> llllllllllllllllIlIllIIlIlIlIlll = (List<EntityLivingBase>)this.mc.theWorld.loadedEntityList.stream().filter(EntityLivingBase.class::isInstance).collect(Collectors.toList());
                if (this.HitInvisible.isEnabled()) {
                    if (AutoSetting.isMineplex) {
                        llllllllllllllllIlIllIIlIlIlIlll = llllllllllllllllIlIllIIlIlIlIlll.stream().filter(llllllllllllllllIlIllIIlIIIlIlIl -> llllllllllllllllIlIllIIlIIIlIlIl.getDistanceToEntity(this.mc.thePlayer) < this.range.getValue() && llllllllllllllllIlIllIIlIIIlIlIl != this.mc.thePlayer && llllllllllllllllIlIllIIlIIIlIlIl.getHealth() > 0.0f && !llllllllllllllllIlIllIIlIIIlIlIl.isDead).collect((Collector<? super Object, ?, List<EntityLivingBase>>)Collectors.toList());
                    }
                    else {
                        llllllllllllllllIlIllIIlIlIlIlll = llllllllllllllllIlIllIIlIlIlIlll.stream().filter(llllllllllllllllIlIllIIlIIIIllIl -> llllllllllllllllIlIllIIlIIIIllIl.getDistanceToEntity(this.mc.thePlayer) < this.range.getValue() && llllllllllllllllIlIllIIlIIIIllIl != this.mc.thePlayer && !llllllllllllllllIlIllIIlIIIIllIl.isDead).collect((Collector<? super Object, ?, List<EntityLivingBase>>)Collectors.toList());
                    }
                }
                else {
                    if (AutoSetting.isMineplex) {
                        llllllllllllllllIlIllIIlIlIlIlll = llllllllllllllllIlIllIIlIlIlIlll.stream().filter(llllllllllllllllIlIllIIlIIIIIlll -> llllllllllllllllIlIllIIlIIIIIlll.getDistanceToEntity(this.mc.thePlayer) < this.range.getValue() && !llllllllllllllllIlIllIIlIIIIIlll.isInvisible() && !llllllllllllllllIlIllIIlIIIIIlll.isInvisibleToPlayer(this.mc.thePlayer) && llllllllllllllllIlIllIIlIIIIIlll != this.mc.thePlayer && llllllllllllllllIlIllIIlIIIIIlll.getHealth() > 0.0f && !llllllllllllllllIlIllIIlIIIIIlll.isDead).collect((Collector<? super Object, ?, List<EntityLivingBase>>)Collectors.toList());
                    }
                    llllllllllllllllIlIllIIlIlIlIlll = llllllllllllllllIlIllIIlIlIlIlll.stream().filter(llllllllllllllllIlIllIIlIIIIIIIl -> llllllllllllllllIlIllIIlIIIIIIIl.getDistanceToEntity(this.mc.thePlayer) < this.range.getValue() && !llllllllllllllllIlIllIIlIIIIIIIl.isInvisible() && !llllllllllllllllIlIllIIlIIIIIIIl.isInvisibleToPlayer(this.mc.thePlayer) && llllllllllllllllIlIllIIlIIIIIIIl != this.mc.thePlayer && !llllllllllllllllIlIllIIlIIIIIIIl.isDead).collect((Collector<? super Object, ?, List<EntityLivingBase>>)Collectors.toList());
                }
                llllllllllllllllIlIllIIlIlIlIlll.sort(Comparator.comparingDouble(llllllllllllllllIlIllIIIlllllIll -> llllllllllllllllIlIllIIIlllllIll.getDistanceToEntity(this.mc.thePlayer)));
                if (this.OnlyPlayers.isEnabled()) {
                    llllllllllllllllIlIllIIlIlIlIlll = llllllllllllllllIlIllIIlIlIlIlll.stream().filter(EntityPlayer.class::isInstance).collect((Collector<? super Object, ?, List<EntityLivingBase>>)Collectors.toList());
                }
                if (!llllllllllllllllIlIllIIlIlIlIlll.isEmpty()) {
                    if (this.Rotation.is("NCP")) {
                        final ScaledResolution llllllllllllllllIlIllIIlIlIlIllI = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
                        final FontRenderer llllllllllllllllIlIllIIlIlIlIlIl = this.mc.fontRendererObj;
                        this.target = llllllllllllllllIlIllIIlIlIlIlll.get(0);
                        if (llllllllllllllllIlIllIIlIlIlIIll instanceof EventRenderGUI) {
                            System.out.println("aaaaaaaaaaaaaaaaa");
                            llllllllllllllllIlIllIIlIlIlIlIl.drawString(String.valueOf(new StringBuilder(String.valueOf(this.target.getName())).append(this.target.getHealth())), 300.0, 300.0, -1);
                        }
                        Killaura.HasTarget = true;
                        if (this.DisableOnDeath.isEnabled() && (this.mc.thePlayer.isDead || this.mc.thePlayer.getHealth() <= 0.0f)) {
                            this.toggled = false;
                        }
                        this.mc.thePlayer.clearItemInUse();
                        if (this.timer.hasTimeElapsed((long)((long)(1000.0 / this.aps.getValue()) / this.mc.timer.timerSpeed), true)) {
                            this.mc.thePlayer.sendQueue.addToSendQueue(new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.ORIGIN, EnumFacing.DOWN));
                            if (this.noSwing.isEnabled()) {
                                this.mc.thePlayer.sendQueue.addToSendQueue(new C0APacketAnimation());
                            }
                            else {
                                this.mc.thePlayer.swingItem();
                            }
                            this.hit = this.random.nextInt(100) - 1;
                            if (this.hit <= this.HitChance.getValue()) {
                                this.mc.thePlayer.sendQueue.addToSendQueue(new C02PacketUseEntity(this.target, C02PacketUseEntity.Action.ATTACK));
                            }
                            if (this.redeskypercent < 1.0) {
                                this.redeskypercent += 1.5 / this.aps.getValue();
                            }
                        }
                    }
                    if (this.Autoblock.isEnabled() && !llllllllllllllllIlIllIIlIlIlIlll.isEmpty() && this.mc.thePlayer.inventory.getCurrentItem() != null && this.mc.thePlayer.inventory.getCurrentItem().getItem() instanceof ItemSword && this.target.getDistanceToEntity(this.mc.thePlayer) < 4.0f) {
                        this.mc.playerController.sendUseItem(this.mc.thePlayer, this.mc.theWorld, this.mc.thePlayer.inventory.getCurrentItem());
                        if (this.mc.thePlayer.isBlocking() && this.timer.hasTimeElapsed(10L, false)) {
                            this.mc.thePlayer.sendQueue.addToSendQueue(new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.ORIGIN, EnumFacing.DOWN));
                        }
                    }
                }
            }
        }
        if (llllllllllllllllIlIllIIlIlIlIIll instanceof EventUpdate) {
            this.setDisplayname(String.valueOf(new StringBuilder("KillAura §7R ").append((int)this.range.getValue()).append(" | APS ").append((int)this.aps.getValue())));
        }
    }
    
    @Override
    public void onDisable() {
    }
    
    public float[] getRotations(final Entity llllllllllllllllIlIllIIlIlIIIlIl) {
        final double llllllllllllllllIlIllIIlIlIIIlII = llllllllllllllllIlIllIIlIlIIIlIl.posX + (llllllllllllllllIlIllIIlIlIIIlIl.posX - llllllllllllllllIlIllIIlIlIIIlIl.lastTickPosX) - this.mc.thePlayer.posX;
        final double llllllllllllllllIlIllIIlIlIIIIll = llllllllllllllllIlIllIIlIlIIIlIl.posY - 3.5 + llllllllllllllllIlIllIIlIlIIIlIl.getEyeHeight() - this.mc.thePlayer.posY + this.mc.thePlayer.getEyeHeight();
        final double llllllllllllllllIlIllIIlIlIIIIlI = llllllllllllllllIlIllIIlIlIIIlIl.posZ + (llllllllllllllllIlIllIIlIlIIIlIl.posZ - llllllllllllllllIlIllIIlIlIIIlIl.lastTickPosZ) - this.mc.thePlayer.posZ;
        final double llllllllllllllllIlIllIIlIlIIIIIl = Math.sqrt(Math.pow(llllllllllllllllIlIllIIlIlIIIlII, 2.0) + Math.pow(llllllllllllllllIlIllIIlIlIIIIlI, 2.0));
        float llllllllllllllllIlIllIIlIlIIIIII = (float)Math.toDegrees(-Math.atan(llllllllllllllllIlIllIIlIlIIIlII / llllllllllllllllIlIllIIlIlIIIIlI));
        final float llllllllllllllllIlIllIIlIIllllll = (float)(-Math.toDegrees(Math.atan(llllllllllllllllIlIllIIlIlIIIIll / llllllllllllllllIlIllIIlIlIIIIIl)));
        if (llllllllllllllllIlIllIIlIlIIIlII < 0.0 && llllllllllllllllIlIllIIlIlIIIIlI < 0.0) {
            llllllllllllllllIlIllIIlIlIIIIII = (float)(90.0 + Math.toDegrees(Math.atan(llllllllllllllllIlIllIIlIlIIIIlI / llllllllllllllllIlIllIIlIlIIIlII)));
        }
        else if (llllllllllllllllIlIllIIlIlIIIlII > 0.0 && llllllllllllllllIlIllIIlIlIIIIlI < 0.0) {
            llllllllllllllllIlIllIIlIlIIIIII = (float)(-90.0 + Math.toDegrees(Math.atan(llllllllllllllllIlIllIIlIlIIIIlI / llllllllllllllllIlIllIIlIlIIIlII)));
        }
        return new float[] { llllllllllllllllIlIllIIlIlIIIIII, llllllllllllllllIlIllIIlIIllllll };
    }
    
    public void OnEvent(final Event llllllllllllllllIlIllIIlIllIIlIl) {
        final boolean b = llllllllllllllllIlIllIIlIllIIlIl instanceof EventRenderGUI;
    }
}
