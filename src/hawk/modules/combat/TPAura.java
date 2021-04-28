package hawk.modules.combat;

import hawk.modules.*;
import hawk.util.*;
import net.minecraft.entity.*;
import hawk.settings.*;
import net.minecraft.entity.player.*;
import hawk.events.*;
import hawk.events.listeners.*;
import java.util.function.*;
import java.util.*;
import net.minecraft.network.*;
import net.minecraft.network.play.client.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import java.util.stream.*;

public class TPAura extends Module
{
    public /* synthetic */ NumberSetting range;
    public /* synthetic */ BooleanSetting Autoblock;
    public /* synthetic */ BooleanSetting DisableOnDeath;
    public /* synthetic */ BooleanSetting noSwing;
    public /* synthetic */ BooleanSetting OnlyPlayers;
    public /* synthetic */ BooleanSetting HitInvisible;
    public static /* synthetic */ boolean HasTarget;
    public /* synthetic */ ModeSetting Rotation;
    public /* synthetic */ Timer timer;
    public /* synthetic */ NumberSetting aps;
    public /* synthetic */ Random random;
    
    static {
        TPAura.HasTarget = false;
    }
    
    @Override
    public void onEnable() {
    }
    
    public TPAura() {
        super("TPAura", 19, Category.COMBAT);
        this.random = new Random();
        this.timer = new Timer();
        this.aps = new NumberSetting("APS", 10.0, 1.0, 20.0, 0.5, this);
        this.range = new NumberSetting("Range", 100.0, 1.0, 500.0, 10.0, this);
        this.noSwing = new BooleanSetting("No Swing", false, this);
        this.DisableOnDeath = new BooleanSetting("Disable on death", true, this);
        this.Rotation = new ModeSetting("Rotation", this, "None", new String[] { "None", "Basic", "Basic Legit", "OldVerus" });
        this.OnlyPlayers = new BooleanSetting("Only Players", true, this);
        this.HitInvisible = new BooleanSetting("Hit invisibles", false, this);
        this.Autoblock = new BooleanSetting("Autoblock", true, this);
        this.addSettings(this.aps, this.range, this.noSwing, this.Rotation, this.DisableOnDeath, this.OnlyPlayers, this.HitInvisible, this.Autoblock);
    }
    
    @Override
    public void onDisable() {
    }
    
    @Override
    public void onEvent(final Event llllllllllllllIlIlIIlIllllIlIIII) {
        if (llllllllllllllIlIlIIlIllllIlIIII instanceof EventMotion && llllllllllllllIlIlIIlIllllIlIIII.isPre()) {
            final EventMotion llllllllllllllIlIlIIlIllllIIllll = (EventMotion)llllllllllllllIlIlIIlIllllIlIIII;
            Stream llllllllllllllIlIlIIlIllllIIlllI = this.mc.theWorld.loadedEntityList.stream();
            EntityLivingBase.class.getClass();
            List<EntityLivingBase> llllllllllllllIlIlIIlIllllIIllIl = llllllllllllllIlIlIIlIllllIIlllI.filter(EntityLivingBase.class::isInstance).collect((Collector<? super Object, ?, List<EntityLivingBase>>)Collectors.toList());
            if (this.HitInvisible.isEnabled()) {
                llllllllllllllIlIlIIlIllllIIllIl = llllllllllllllIlIlIIlIllllIIllIl.stream().filter(llllllllllllllIlIlIIlIlllIlIlIII -> llllllllllllllIlIlIIlIlllIlIlIII.getDistanceToEntity(this.mc.thePlayer) < this.range.getValue() && llllllllllllllIlIlIIlIlllIlIlIII != this.mc.thePlayer && !llllllllllllllIlIlIIlIlllIlIlIII.isDead).collect((Collector<? super Object, ?, List<EntityLivingBase>>)Collectors.toList());
            }
            else {
                llllllllllllllIlIlIIlIllllIIllIl = llllllllllllllIlIlIIlIllllIIllIl.stream().filter(llllllllllllllIlIlIIlIlllIlIIIlI -> llllllllllllllIlIlIIlIlllIlIIIlI.getDistanceToEntity(this.mc.thePlayer) < this.range.getValue() && !llllllllllllllIlIlIIlIlllIlIIIlI.isInvisible() && !llllllllllllllIlIlIIlIlllIlIIIlI.isInvisibleToPlayer(this.mc.thePlayer) && llllllllllllllIlIlIIlIlllIlIIIlI != this.mc.thePlayer && !llllllllllllllIlIlIIlIlllIlIIIlI.isDead).collect((Collector<? super Object, ?, List<EntityLivingBase>>)Collectors.toList());
            }
            llllllllllllllIlIlIIlIllllIIllIl.sort(Comparator.comparingDouble(llllllllllllllIlIlIIlIlllIIlllII -> llllllllllllllIlIlIIlIlllIIlllII.getDistanceToEntity(this.mc.thePlayer)));
            if (this.OnlyPlayers.isEnabled()) {
                llllllllllllllIlIlIIlIllllIIlllI = llllllllllllllIlIlIIlIllllIIllIl.stream();
                EntityPlayer.class.getClass();
                llllllllllllllIlIlIIlIllllIIllIl = llllllllllllllIlIlIIlIllllIIlllI.filter(EntityPlayer.class::isInstance).collect((Collector<? super Object, ?, List<EntityLivingBase>>)Collectors.toList());
            }
            if (!llllllllllllllIlIlIIlIllllIIllIl.isEmpty()) {
                TPAura.HasTarget = true;
                final EntityLivingBase llllllllllllllIlIlIIlIllllIIllII = llllllllllllllIlIlIIlIllllIIllIl.get(0);
                if (this.Rotation.is("Basic Legit")) {
                    this.mc.thePlayer.rotationYaw = this.getRotations(llllllllllllllIlIlIIlIllllIIllII)[0] + this.random.nextInt(10) - 10.0f;
                    this.mc.thePlayer.rotationPitch = this.getRotations(llllllllllllllIlIlIIlIllllIIllII)[1] + this.random.nextInt(10) - 10.0f;
                }
                if (this.Rotation.is("Basic")) {
                    llllllllllllllIlIlIIlIllllIIllll.setYaw(this.getRotations(llllllllllllllIlIlIIlIllllIIllII)[0] + this.random.nextInt(10) - 10.0f);
                    llllllllllllllIlIlIIlIllllIIllll.setPitch(this.getRotations(llllllllllllllIlIlIIlIllllIIllII)[1] + this.random.nextInt(10) - 10.0f);
                }
                if (this.Rotation.is("OldVerus")) {
                    llllllllllllllIlIlIIlIllllIIllll.setYaw(this.getRotations(llllllllllllllIlIlIIlIllllIIllII)[0] + this.random.nextInt(10) - 10.0f);
                    llllllllllllllIlIlIIlIllllIIllll.setPitch(this.getRotations(llllllllllllllIlIlIIlIllllIIllII)[1] + this.random.nextInt(10) - 10.0f);
                    if (!llllllllllllllIlIlIIlIllllIIllIl.isEmpty()) {
                        this.mc.thePlayer.setSprinting(false);
                    }
                }
                if (this.DisableOnDeath.isEnabled() && (this.mc.thePlayer.isDead || this.mc.thePlayer.getHealth() <= 0.0f)) {
                    this.toggled = false;
                }
                if (this.timer.hasTimeElapsed((long)(1000.0 / this.aps.getValue()), true)) {
                    if (this.noSwing.isEnabled()) {
                        this.mc.thePlayer.sendQueue.addToSendQueue(new C0APacketAnimation());
                    }
                    else {
                        this.mc.thePlayer.swingItem();
                    }
                    this.mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(llllllllllllllIlIlIIlIllllIIllII.posX, llllllllllllllIlIlIIlIllllIIllII.posY, llllllllllllllIlIlIIlIllllIIllII.posZ, false));
                    this.mc.thePlayer.sendQueue.addToSendQueue(new C02PacketUseEntity(llllllllllllllIlIlIIlIllllIIllII, C02PacketUseEntity.Action.ATTACK));
                }
                if (this.Autoblock.isEnabled() && this.mc.thePlayer.getHeldItem() != null && this.mc.thePlayer.getHeldItem().getItem() instanceof ItemSword) {
                    this.mc.playerController.sendUseItem(this.mc.thePlayer, this.mc.theWorld, this.mc.thePlayer.getHeldItem());
                }
            }
            else {
                TPAura.HasTarget = true;
            }
        }
    }
    
    public float[] getRotations(final Entity llllllllllllllIlIlIIlIlllIllIlII) {
        final double llllllllllllllIlIlIIlIlllIlllIll = llllllllllllllIlIlIIlIlllIllIlII.posX + (llllllllllllllIlIlIIlIlllIllIlII.posX - llllllllllllllIlIlIIlIlllIllIlII.lastTickPosX) - this.mc.thePlayer.posX;
        final double llllllllllllllIlIlIIlIlllIlllIlI = llllllllllllllIlIlIIlIlllIllIlII.posY - 3.5 + llllllllllllllIlIlIIlIlllIllIlII.getEyeHeight() - this.mc.thePlayer.posY + this.mc.thePlayer.getEyeHeight();
        final double llllllllllllllIlIlIIlIlllIlllIIl = llllllllllllllIlIlIIlIlllIllIlII.posZ + (llllllllllllllIlIlIIlIlllIllIlII.posZ - llllllllllllllIlIlIIlIlllIllIlII.lastTickPosZ) - this.mc.thePlayer.posZ;
        final double llllllllllllllIlIlIIlIlllIlllIII = Math.sqrt(Math.pow(llllllllllllllIlIlIIlIlllIlllIll, 2.0) + Math.pow(llllllllllllllIlIlIIlIlllIlllIIl, 2.0));
        float llllllllllllllIlIlIIlIlllIllIlll = (float)Math.toDegrees(-Math.atan(llllllllllllllIlIlIIlIlllIlllIll / llllllllllllllIlIlIIlIlllIlllIIl));
        final float llllllllllllllIlIlIIlIlllIllIllI = (float)(-Math.toDegrees(Math.atan(llllllllllllllIlIlIIlIlllIlllIlI / llllllllllllllIlIlIIlIlllIlllIII)));
        if (llllllllllllllIlIlIIlIlllIlllIll < 0.0 && llllllllllllllIlIlIIlIlllIlllIIl < 0.0) {
            llllllllllllllIlIlIIlIlllIllIlll = (float)(90.0 + Math.toDegrees(Math.atan(llllllllllllllIlIlIIlIlllIlllIIl / llllllllllllllIlIlIIlIlllIlllIll)));
        }
        else if (llllllllllllllIlIlIIlIlllIlllIll > 0.0 && llllllllllllllIlIlIIlIlllIlllIIl < 0.0) {
            llllllllllllllIlIlIIlIlllIllIlll = (float)(-90.0 + Math.toDegrees(Math.atan(llllllllllllllIlIlIIlIlllIlllIIl / llllllllllllllIlIlIIlIlllIlllIll)));
        }
        return new float[] { llllllllllllllIlIlIIlIlllIllIlll, llllllllllllllIlIlIIlIlllIllIllI };
    }
}
