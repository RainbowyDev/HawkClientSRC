package net.minecraft.network;

import net.minecraft.server.gui.*;
import net.minecraft.network.play.*;
import net.minecraft.server.*;
import net.minecraft.server.management.*;
import net.minecraft.stats.*;
import net.minecraft.world.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.projectile.*;
import org.apache.logging.log4j.*;
import net.minecraft.command.*;
import java.util.concurrent.*;
import net.minecraft.crash.*;
import net.minecraft.entity.player.*;
import io.netty.buffer.*;
import java.io.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;
import net.minecraft.inventory.*;
import net.minecraft.command.server.*;
import net.minecraft.block.material.*;
import com.google.common.collect.*;
import net.minecraft.util.*;
import io.netty.util.concurrent.*;
import com.google.common.util.concurrent.*;
import net.minecraft.nbt.*;
import java.util.*;
import net.minecraft.network.play.server.*;
import net.minecraft.entity.passive.*;
import org.apache.commons.lang3.*;
import net.minecraft.network.play.client.*;
import net.minecraft.tileentity.*;

public class NetHandlerPlayServer implements IUpdatePlayerListBox, INetHandlerPlayServer
{
    private /* synthetic */ long lastSentPingPacket;
    private /* synthetic */ int field_175090_f;
    private /* synthetic */ int chatSpamThresholdCount;
    private /* synthetic */ int itemDropThreshold;
    private /* synthetic */ boolean field_147366_g;
    private /* synthetic */ int floatingTickCount;
    private final /* synthetic */ MinecraftServer serverController;
    private /* synthetic */ long lastPingTime;
    private /* synthetic */ double lastPosX;
    private /* synthetic */ int field_147378_h;
    private /* synthetic */ int networkTickCount;
    private /* synthetic */ double lastPosY;
    private /* synthetic */ IntHashMap field_147372_n;
    private static final /* synthetic */ Logger logger;
    private /* synthetic */ double lastPosZ;
    public final /* synthetic */ NetworkManager netManager;
    private /* synthetic */ boolean hasMoved;
    public /* synthetic */ EntityPlayerMP playerEntity;
    
    @Override
    public void func_175086_a(final C19PacketResourcePackStatus llllllllllllllIllIIIIlIIIlIIlIIl) {
    }
    
    @Override
    public void update() {
        this.field_147366_g = false;
        ++this.networkTickCount;
        this.serverController.theProfiler.startSection("keepAlive");
        if (this.networkTickCount - this.lastSentPingPacket > 40L) {
            this.lastSentPingPacket = this.networkTickCount;
            this.lastPingTime = this.currentTimeMillis();
            this.field_147378_h = (int)this.lastPingTime;
            this.sendPacket(new S00PacketKeepAlive(this.field_147378_h));
        }
        this.serverController.theProfiler.endSection();
        if (this.chatSpamThresholdCount > 0) {
            --this.chatSpamThresholdCount;
        }
        if (this.itemDropThreshold > 0) {
            --this.itemDropThreshold;
        }
        if (this.playerEntity.getLastActiveTime() > 0L && this.serverController.getMaxPlayerIdleMinutes() > 0 && MinecraftServer.getCurrentTimeMillis() - this.playerEntity.getLastActiveTime() > this.serverController.getMaxPlayerIdleMinutes() * 1000 * 60) {
            this.kickPlayerFromServer("You have been idle for too long!");
        }
    }
    
    @Override
    public void processPlayer(final C03PacketPlayer llllllllllllllIllIIIIlIIllIllIll) {
        PacketThreadUtil.func_180031_a(llllllllllllllIllIIIIlIIllIllIll, this, this.playerEntity.getServerForPlayer());
        final WorldServer llllllllllllllIllIIIIlIIllllllIl = this.serverController.worldServerForDimension(this.playerEntity.dimension);
        this.field_147366_g = true;
        if (!this.playerEntity.playerConqueredTheEnd) {
            final double llllllllllllllIllIIIIlIIllllllII = this.playerEntity.posX;
            final double llllllllllllllIllIIIIlIIlllllIll = this.playerEntity.posY;
            final double llllllllllllllIllIIIIlIIlllllIlI = this.playerEntity.posZ;
            double llllllllllllllIllIIIIlIIlllllIIl = 0.0;
            final double llllllllllllllIllIIIIlIIlllllIII = llllllllllllllIllIIIIlIIllIllIll.getPositionX() - this.lastPosX;
            final double llllllllllllllIllIIIIlIIllllIlll = llllllllllllllIllIIIIlIIllIllIll.getPositionY() - this.lastPosY;
            final double llllllllllllllIllIIIIlIIllllIllI = llllllllllllllIllIIIIlIIllIllIll.getPositionZ() - this.lastPosZ;
            if (llllllllllllllIllIIIIlIIllIllIll.func_149466_j()) {
                llllllllllllllIllIIIIlIIlllllIIl = llllllllllllllIllIIIIlIIlllllIII * llllllllllllllIllIIIIlIIlllllIII + llllllllllllllIllIIIIlIIllllIlll * llllllllllllllIllIIIIlIIllllIlll + llllllllllllllIllIIIIlIIllllIllI * llllllllllllllIllIIIIlIIllllIllI;
                if (!this.hasMoved && llllllllllllllIllIIIIlIIlllllIIl < 0.25) {
                    this.hasMoved = true;
                }
            }
            if (this.hasMoved) {
                this.field_175090_f = this.networkTickCount;
                if (this.playerEntity.ridingEntity != null) {
                    float llllllllllllllIllIIIIlIIlllIllll = this.playerEntity.rotationYaw;
                    float llllllllllllllIllIIIIlIIlllIlllI = this.playerEntity.rotationPitch;
                    this.playerEntity.ridingEntity.updateRiderPosition();
                    final double llllllllllllllIllIIIIlIIllllIlIl = this.playerEntity.posX;
                    final double llllllllllllllIllIIIIlIIllllIIll = this.playerEntity.posY;
                    final double llllllllllllllIllIIIIlIIllllIIIl = this.playerEntity.posZ;
                    if (llllllllllllllIllIIIIlIIllIllIll.getRotating()) {
                        llllllllllllllIllIIIIlIIlllIllll = llllllllllllllIllIIIIlIIllIllIll.getYaw();
                        llllllllllllllIllIIIIlIIlllIlllI = llllllllllllllIllIIIIlIIllIllIll.getPitch();
                    }
                    this.playerEntity.onGround = llllllllllllllIllIIIIlIIllIllIll.func_149465_i();
                    this.playerEntity.onUpdateEntity();
                    this.playerEntity.setPositionAndRotation(llllllllllllllIllIIIIlIIllllIlIl, llllllllllllllIllIIIIlIIllllIIll, llllllllllllllIllIIIIlIIllllIIIl, llllllllllllllIllIIIIlIIlllIllll, llllllllllllllIllIIIIlIIlllIlllI);
                    if (this.playerEntity.ridingEntity != null) {
                        this.playerEntity.ridingEntity.updateRiderPosition();
                    }
                    this.serverController.getConfigurationManager().serverUpdateMountedMovingPlayer(this.playerEntity);
                    if (this.playerEntity.ridingEntity != null) {
                        if (llllllllllllllIllIIIIlIIlllllIIl > 4.0) {
                            final Entity llllllllllllllIllIIIIlIIlllIllIl = this.playerEntity.ridingEntity;
                            this.playerEntity.playerNetServerHandler.sendPacket(new S18PacketEntityTeleport(llllllllllllllIllIIIIlIIlllIllIl));
                            this.setPlayerLocation(this.playerEntity.posX, this.playerEntity.posY, this.playerEntity.posZ, this.playerEntity.rotationYaw, this.playerEntity.rotationPitch);
                        }
                        this.playerEntity.ridingEntity.isAirBorne = true;
                    }
                    if (this.hasMoved) {
                        this.lastPosX = this.playerEntity.posX;
                        this.lastPosY = this.playerEntity.posY;
                        this.lastPosZ = this.playerEntity.posZ;
                    }
                    llllllllllllllIllIIIIlIIllllllIl.updateEntity(this.playerEntity);
                    return;
                }
                if (this.playerEntity.isPlayerSleeping()) {
                    this.playerEntity.onUpdateEntity();
                    this.playerEntity.setPositionAndRotation(this.lastPosX, this.lastPosY, this.lastPosZ, this.playerEntity.rotationYaw, this.playerEntity.rotationPitch);
                    llllllllllllllIllIIIIlIIllllllIl.updateEntity(this.playerEntity);
                    return;
                }
                final double llllllllllllllIllIIIIlIIlllIllII = this.playerEntity.posY;
                this.lastPosX = this.playerEntity.posX;
                this.lastPosY = this.playerEntity.posY;
                this.lastPosZ = this.playerEntity.posZ;
                double llllllllllllllIllIIIIlIIllllIlII = this.playerEntity.posX;
                double llllllllllllllIllIIIIlIIllllIIlI = this.playerEntity.posY;
                double llllllllllllllIllIIIIlIIllllIIII = this.playerEntity.posZ;
                float llllllllllllllIllIIIIlIIlllIlIll = this.playerEntity.rotationYaw;
                float llllllllllllllIllIIIIlIIlllIlIlI = this.playerEntity.rotationPitch;
                if (llllllllllllllIllIIIIlIIllIllIll.func_149466_j() && llllllllllllllIllIIIIlIIllIllIll.getPositionY() == -999.0) {
                    llllllllllllllIllIIIIlIIllIllIll.func_149469_a(false);
                }
                if (llllllllllllllIllIIIIlIIllIllIll.func_149466_j()) {
                    llllllllllllllIllIIIIlIIllllIlII = llllllllllllllIllIIIIlIIllIllIll.getPositionX();
                    llllllllllllllIllIIIIlIIllllIIlI = llllllllllllllIllIIIIlIIllIllIll.getPositionY();
                    llllllllllllllIllIIIIlIIllllIIII = llllllllllllllIllIIIIlIIllIllIll.getPositionZ();
                    if (Math.abs(llllllllllllllIllIIIIlIIllIllIll.getPositionX()) > 3.0E7 || Math.abs(llllllllllllllIllIIIIlIIllIllIll.getPositionZ()) > 3.0E7) {
                        this.kickPlayerFromServer("Illegal position");
                        return;
                    }
                }
                if (llllllllllllllIllIIIIlIIllIllIll.getRotating()) {
                    llllllllllllllIllIIIIlIIlllIlIll = llllllllllllllIllIIIIlIIllIllIll.getYaw();
                    llllllllllllllIllIIIIlIIlllIlIlI = llllllllllllllIllIIIIlIIllIllIll.getPitch();
                }
                this.playerEntity.onUpdateEntity();
                this.playerEntity.setPositionAndRotation(this.lastPosX, this.lastPosY, this.lastPosZ, llllllllllllllIllIIIIlIIlllIlIll, llllllllllllllIllIIIIlIIlllIlIlI);
                if (!this.hasMoved) {
                    return;
                }
                double llllllllllllllIllIIIIlIIlllIlIIl = llllllllllllllIllIIIIlIIllllIlII - this.playerEntity.posX;
                double llllllllllllllIllIIIIlIIlllIlIII = llllllllllllllIllIIIIlIIllllIIlI - this.playerEntity.posY;
                double llllllllllllllIllIIIIlIIlllIIlll = llllllllllllllIllIIIIlIIllllIIII - this.playerEntity.posZ;
                final double llllllllllllllIllIIIIlIIlllIIllI = Math.min(Math.abs(llllllllllllllIllIIIIlIIlllIlIIl), Math.abs(this.playerEntity.motionX));
                final double llllllllllllllIllIIIIlIIlllIIlIl = Math.min(Math.abs(llllllllllllllIllIIIIlIIlllIlIII), Math.abs(this.playerEntity.motionY));
                final double llllllllllllllIllIIIIlIIlllIIlII = Math.min(Math.abs(llllllllllllllIllIIIIlIIlllIIlll), Math.abs(this.playerEntity.motionZ));
                double llllllllllllllIllIIIIlIIlllIIIll = llllllllllllllIllIIIIlIIlllIIllI * llllllllllllllIllIIIIlIIlllIIllI + llllllllllllllIllIIIIlIIlllIIlIl * llllllllllllllIllIIIIlIIlllIIlIl + llllllllllllllIllIIIIlIIlllIIlII * llllllllllllllIllIIIIlIIlllIIlII;
                if (llllllllllllllIllIIIIlIIlllIIIll > 100.0 && (!this.serverController.isSinglePlayer() || !this.serverController.getServerOwner().equals(this.playerEntity.getName()))) {
                    NetHandlerPlayServer.logger.warn(String.valueOf(new StringBuilder(String.valueOf(this.playerEntity.getName())).append(" moved too quickly! ").append(llllllllllllllIllIIIIlIIlllIlIIl).append(",").append(llllllllllllllIllIIIIlIIlllIlIII).append(",").append(llllllllllllllIllIIIIlIIlllIIlll).append(" (").append(llllllllllllllIllIIIIlIIlllIIllI).append(", ").append(llllllllllllllIllIIIIlIIlllIIlIl).append(", ").append(llllllllllllllIllIIIIlIIlllIIlII).append(")")));
                    this.setPlayerLocation(this.lastPosX, this.lastPosY, this.lastPosZ, this.playerEntity.rotationYaw, this.playerEntity.rotationPitch);
                    return;
                }
                final float llllllllllllllIllIIIIlIIlllIIIlI = 0.0625f;
                final boolean llllllllllllllIllIIIIlIIlllIIIIl = llllllllllllllIllIIIIlIIllllllIl.getCollidingBoundingBoxes(this.playerEntity, this.playerEntity.getEntityBoundingBox().contract(llllllllllllllIllIIIIlIIlllIIIlI, llllllllllllllIllIIIIlIIlllIIIlI, llllllllllllllIllIIIIlIIlllIIIlI)).isEmpty();
                if (this.playerEntity.onGround && !llllllllllllllIllIIIIlIIllIllIll.func_149465_i() && llllllllllllllIllIIIIlIIlllIlIII > 0.0) {
                    this.playerEntity.jump();
                }
                this.playerEntity.moveEntity(llllllllllllllIllIIIIlIIlllIlIIl, llllllllllllllIllIIIIlIIlllIlIII, llllllllllllllIllIIIIlIIlllIIlll);
                this.playerEntity.onGround = llllllllllllllIllIIIIlIIllIllIll.func_149465_i();
                final double llllllllllllllIllIIIIlIIlllIIIII = llllllllllllllIllIIIIlIIlllIlIII;
                llllllllllllllIllIIIIlIIlllIlIIl = llllllllllllllIllIIIIlIIllllIlII - this.playerEntity.posX;
                llllllllllllllIllIIIIlIIlllIlIII = llllllllllllllIllIIIIlIIllllIIlI - this.playerEntity.posY;
                if (llllllllllllllIllIIIIlIIlllIlIII > -0.5 || llllllllllllllIllIIIIlIIlllIlIII < 0.5) {
                    llllllllllllllIllIIIIlIIlllIlIII = 0.0;
                }
                llllllllllllllIllIIIIlIIlllIIlll = llllllllllllllIllIIIIlIIllllIIII - this.playerEntity.posZ;
                llllllllllllllIllIIIIlIIlllIIIll = llllllllllllllIllIIIIlIIlllIlIIl * llllllllllllllIllIIIIlIIlllIlIIl + llllllllllllllIllIIIIlIIlllIlIII * llllllllllllllIllIIIIlIIlllIlIII + llllllllllllllIllIIIIlIIlllIIlll * llllllllllllllIllIIIIlIIlllIIlll;
                boolean llllllllllllllIllIIIIlIIllIlllll = false;
                if (llllllllllllllIllIIIIlIIlllIIIll > 0.0625 && !this.playerEntity.isPlayerSleeping() && !this.playerEntity.theItemInWorldManager.isCreative()) {
                    llllllllllllllIllIIIIlIIllIlllll = true;
                    NetHandlerPlayServer.logger.warn(String.valueOf(new StringBuilder(String.valueOf(this.playerEntity.getName())).append(" moved wrongly!")));
                }
                this.playerEntity.setPositionAndRotation(llllllllllllllIllIIIIlIIllllIlII, llllllllllllllIllIIIIlIIllllIIlI, llllllllllllllIllIIIIlIIllllIIII, llllllllllllllIllIIIIlIIlllIlIll, llllllllllllllIllIIIIlIIlllIlIlI);
                this.playerEntity.addMovementStat(this.playerEntity.posX - llllllllllllllIllIIIIlIIllllllII, this.playerEntity.posY - llllllllllllllIllIIIIlIIlllllIll, this.playerEntity.posZ - llllllllllllllIllIIIIlIIlllllIlI);
                if (!this.playerEntity.noClip) {
                    final boolean llllllllllllllIllIIIIlIIllIllllI = llllllllllllllIllIIIIlIIllllllIl.getCollidingBoundingBoxes(this.playerEntity, this.playerEntity.getEntityBoundingBox().contract(llllllllllllllIllIIIIlIIlllIIIlI, llllllllllllllIllIIIIlIIlllIIIlI, llllllllllllllIllIIIIlIIlllIIIlI)).isEmpty();
                    if (llllllllllllllIllIIIIlIIlllIIIIl && (llllllllllllllIllIIIIlIIllIlllll || !llllllllllllllIllIIIIlIIllIllllI) && !this.playerEntity.isPlayerSleeping()) {
                        this.setPlayerLocation(this.lastPosX, this.lastPosY, this.lastPosZ, llllllllllllllIllIIIIlIIlllIlIll, llllllllllllllIllIIIIlIIlllIlIlI);
                        return;
                    }
                }
                final AxisAlignedBB llllllllllllllIllIIIIlIIllIlllIl = this.playerEntity.getEntityBoundingBox().expand(llllllllllllllIllIIIIlIIlllIIIlI, llllllllllllllIllIIIIlIIlllIIIlI, llllllllllllllIllIIIIlIIlllIIIlI).addCoord(0.0, -0.55, 0.0);
                if (!this.serverController.isFlightAllowed() && !this.playerEntity.capabilities.allowFlying && !llllllllllllllIllIIIIlIIllllllIl.checkBlockCollision(llllllllllllllIllIIIIlIIllIlllIl)) {
                    if (llllllllllllllIllIIIIlIIlllIIIII >= -0.03125) {
                        ++this.floatingTickCount;
                        if (this.floatingTickCount > 80) {
                            NetHandlerPlayServer.logger.warn(String.valueOf(new StringBuilder(String.valueOf(this.playerEntity.getName())).append(" was kicked for floating too long!")));
                            this.kickPlayerFromServer("Flying is not enabled on this server");
                            return;
                        }
                    }
                }
                else {
                    this.floatingTickCount = 0;
                }
                this.playerEntity.onGround = llllllllllllllIllIIIIlIIllIllIll.func_149465_i();
                this.serverController.getConfigurationManager().serverUpdateMountedMovingPlayer(this.playerEntity);
                this.playerEntity.handleFalling(this.playerEntity.posY - llllllllllllllIllIIIIlIIlllIllII, llllllllllllllIllIIIIlIIllIllIll.func_149465_i());
            }
            else if (this.networkTickCount - this.field_175090_f > 20) {
                this.setPlayerLocation(this.lastPosX, this.lastPosY, this.lastPosZ, this.playerEntity.rotationYaw, this.playerEntity.rotationPitch);
            }
        }
    }
    
    @Override
    public void processClientStatus(final C16PacketClientStatus llllllllllllllIllIIIIIllllllIIIl) {
        PacketThreadUtil.func_180031_a(llllllllllllllIllIIIIIllllllIIIl, this, this.playerEntity.getServerForPlayer());
        this.playerEntity.markPlayerActive();
        final C16PacketClientStatus.EnumState llllllllllllllIllIIIIIllllllIIII = llllllllllllllIllIIIIIllllllIIIl.getStatus();
        switch (SwitchAction.field_180223_c[llllllllllllllIllIIIIIllllllIIII.ordinal()]) {
            case 1: {
                if (this.playerEntity.playerConqueredTheEnd) {
                    this.playerEntity = this.serverController.getConfigurationManager().recreatePlayerEntity(this.playerEntity, 0, true);
                    break;
                }
                if (this.playerEntity.getServerForPlayer().getWorldInfo().isHardcoreModeEnabled()) {
                    if (this.serverController.isSinglePlayer() && this.playerEntity.getName().equals(this.serverController.getServerOwner())) {
                        this.playerEntity.playerNetServerHandler.kickPlayerFromServer("You have died. Game over, man, it's game over!");
                        this.serverController.deleteWorldAndStopServer();
                        break;
                    }
                    final UserListBansEntry llllllllllllllIllIIIIIlllllIllll = new UserListBansEntry(this.playerEntity.getGameProfile(), null, "(You just lost the game)", null, "Death in Hardcore");
                    this.serverController.getConfigurationManager().getBannedPlayers().addEntry(llllllllllllllIllIIIIIlllllIllll);
                    this.playerEntity.playerNetServerHandler.kickPlayerFromServer("You have died. Game over, man, it's game over!");
                    break;
                }
                else {
                    if (this.playerEntity.getHealth() > 0.0f) {
                        return;
                    }
                    this.playerEntity = this.serverController.getConfigurationManager().recreatePlayerEntity(this.playerEntity, 0, false);
                    break;
                }
                break;
            }
            case 2: {
                this.playerEntity.getStatFile().func_150876_a(this.playerEntity);
                break;
            }
            case 3: {
                this.playerEntity.triggerAchievement(AchievementList.openInventory);
                break;
            }
        }
    }
    
    @Override
    public void processClientSettings(final C15PacketClientSettings llllllllllllllIllIIIIIllIlllIIlI) {
        PacketThreadUtil.func_180031_a(llllllllllllllIllIIIIIllIlllIIlI, this, this.playerEntity.getServerForPlayer());
        this.playerEntity.handleClientSettings(llllllllllllllIllIIIIIllIlllIIlI);
    }
    
    @Override
    public void processUseEntity(final C02PacketUseEntity llllllllllllllIllIIIIIlllllllIll) {
        PacketThreadUtil.func_180031_a(llllllllllllllIllIIIIIlllllllIll, this, this.playerEntity.getServerForPlayer());
        final WorldServer llllllllllllllIllIIIIlIIIIIIIIII = this.serverController.worldServerForDimension(this.playerEntity.dimension);
        final Entity llllllllllllllIllIIIIIllllllllll = llllllllllllllIllIIIIIlllllllIll.getEntityFromWorld(llllllllllllllIllIIIIlIIIIIIIIII);
        this.playerEntity.markPlayerActive();
        if (llllllllllllllIllIIIIIllllllllll != null) {
            final boolean llllllllllllllIllIIIIIlllllllllI = this.playerEntity.canEntityBeSeen(llllllllllllllIllIIIIIllllllllll);
            double llllllllllllllIllIIIIIllllllllIl = 36.0;
            if (!llllllllllllllIllIIIIIlllllllllI) {
                llllllllllllllIllIIIIIllllllllIl = 9.0;
            }
            if (this.playerEntity.getDistanceSqToEntity(llllllllllllllIllIIIIIllllllllll) < llllllllllllllIllIIIIIllllllllIl) {
                if (llllllllllllllIllIIIIIlllllllIll.getAction() == C02PacketUseEntity.Action.INTERACT) {
                    this.playerEntity.interactWith(llllllllllllllIllIIIIIllllllllll);
                }
                else if (llllllllllllllIllIIIIIlllllllIll.getAction() == C02PacketUseEntity.Action.INTERACT_AT) {
                    llllllllllllllIllIIIIIllllllllll.func_174825_a(this.playerEntity, llllllllllllllIllIIIIIlllllllIll.func_179712_b());
                }
                else if (llllllllllllllIllIIIIIlllllllIll.getAction() == C02PacketUseEntity.Action.ATTACK) {
                    if (llllllllllllllIllIIIIIllllllllll instanceof EntityItem || llllllllllllllIllIIIIIllllllllll instanceof EntityXPOrb || llllllllllllllIllIIIIIllllllllll instanceof EntityArrow || llllllllllllllIllIIIIIllllllllll == this.playerEntity) {
                        this.kickPlayerFromServer("Attempting to attack an invalid entity");
                        this.serverController.logWarning(String.valueOf(new StringBuilder("Player ").append(this.playerEntity.getName()).append(" tried to attack an invalid entity")));
                        return;
                    }
                    this.playerEntity.attackTargetEntityWithCurrentItem(llllllllllllllIllIIIIIllllllllll);
                }
            }
        }
    }
    
    @Override
    public void processPlayerBlockPlacement(final C08PacketPlayerBlockPlacement llllllllllllllIllIIIIlIIIlllIIIl) {
        PacketThreadUtil.func_180031_a(llllllllllllllIllIIIIlIIIlllIIIl, this, this.playerEntity.getServerForPlayer());
        final WorldServer llllllllllllllIllIIIIlIIIlllIIII = this.serverController.worldServerForDimension(this.playerEntity.dimension);
        ItemStack llllllllllllllIllIIIIlIIIllIllll = this.playerEntity.inventory.getCurrentItem();
        boolean llllllllllllllIllIIIIlIIIllIlllI = false;
        final BlockPos llllllllllllllIllIIIIlIIIllIllIl = llllllllllllllIllIIIIlIIIlllIIIl.func_179724_a();
        final EnumFacing llllllllllllllIllIIIIlIIIllIllII = EnumFacing.getFront(llllllllllllllIllIIIIlIIIlllIIIl.getPlacedBlockDirection());
        this.playerEntity.markPlayerActive();
        if (llllllllllllllIllIIIIlIIIlllIIIl.getPlacedBlockDirection() == 255) {
            if (llllllllllllllIllIIIIlIIIllIllll == null) {
                return;
            }
            this.playerEntity.theItemInWorldManager.tryUseItem(this.playerEntity, llllllllllllllIllIIIIlIIIlllIIII, llllllllllllllIllIIIIlIIIllIllll);
        }
        else if (llllllllllllllIllIIIIlIIIllIllIl.getY() >= this.serverController.getBuildLimit() - 1 && (llllllllllllllIllIIIIlIIIllIllII == EnumFacing.UP || llllllllllllllIllIIIIlIIIllIllIl.getY() >= this.serverController.getBuildLimit())) {
            final ChatComponentTranslation llllllllllllllIllIIIIlIIIllIlIll = new ChatComponentTranslation("build.tooHigh", new Object[] { this.serverController.getBuildLimit() });
            llllllllllllllIllIIIIlIIIllIlIll.getChatStyle().setColor(EnumChatFormatting.RED);
            this.playerEntity.playerNetServerHandler.sendPacket(new S02PacketChat(llllllllllllllIllIIIIlIIIllIlIll));
            llllllllllllllIllIIIIlIIIllIlllI = true;
        }
        else {
            if (this.hasMoved && this.playerEntity.getDistanceSq(llllllllllllllIllIIIIlIIIllIllIl.getX() + 0.5, llllllllllllllIllIIIIlIIIllIllIl.getY() + 0.5, llllllllllllllIllIIIIlIIIllIllIl.getZ() + 0.5) < 64.0 && !this.serverController.isBlockProtected(llllllllllllllIllIIIIlIIIlllIIII, llllllllllllllIllIIIIlIIIllIllIl, this.playerEntity) && llllllllllllllIllIIIIlIIIlllIIII.getWorldBorder().contains(llllllllllllllIllIIIIlIIIllIllIl)) {
                this.playerEntity.theItemInWorldManager.func_180236_a(this.playerEntity, llllllllllllllIllIIIIlIIIlllIIII, llllllllllllllIllIIIIlIIIllIllll, llllllllllllllIllIIIIlIIIllIllIl, llllllllllllllIllIIIIlIIIllIllII, llllllllllllllIllIIIIlIIIlllIIIl.getPlacedBlockOffsetX(), llllllllllllllIllIIIIlIIIlllIIIl.getPlacedBlockOffsetY(), llllllllllllllIllIIIIlIIIlllIIIl.getPlacedBlockOffsetZ());
            }
            llllllllllllllIllIIIIlIIIllIlllI = true;
        }
        if (llllllllllllllIllIIIIlIIIllIlllI) {
            this.playerEntity.playerNetServerHandler.sendPacket(new S23PacketBlockChange(llllllllllllllIllIIIIlIIIlllIIII, llllllllllllllIllIIIIlIIIllIllIl));
            this.playerEntity.playerNetServerHandler.sendPacket(new S23PacketBlockChange(llllllllllllllIllIIIIlIIIlllIIII, llllllllllllllIllIIIIlIIIllIllIl.offset(llllllllllllllIllIIIIlIIIllIllII)));
        }
        llllllllllllllIllIIIIlIIIllIllll = this.playerEntity.inventory.getCurrentItem();
        if (llllllllllllllIllIIIIlIIIllIllll != null && llllllllllllllIllIIIIlIIIllIllll.stackSize == 0) {
            this.playerEntity.inventory.mainInventory[this.playerEntity.inventory.currentItem] = null;
            llllllllllllllIllIIIIlIIIllIllll = null;
        }
        if (llllllllllllllIllIIIIlIIIllIllll == null || llllllllllllllIllIIIIlIIIllIllll.getMaxItemUseDuration() == 0) {
            this.playerEntity.isChangingQuantityOnly = true;
            this.playerEntity.inventory.mainInventory[this.playerEntity.inventory.currentItem] = ItemStack.copyItemStack(this.playerEntity.inventory.mainInventory[this.playerEntity.inventory.currentItem]);
            final Slot llllllllllllllIllIIIIlIIIllIlIlI = this.playerEntity.openContainer.getSlotFromInventory(this.playerEntity.inventory, this.playerEntity.inventory.currentItem);
            this.playerEntity.openContainer.detectAndSendChanges();
            this.playerEntity.isChangingQuantityOnly = false;
            if (!ItemStack.areItemStacksEqual(this.playerEntity.inventory.getCurrentItem(), llllllllllllllIllIIIIlIIIlllIIIl.getStack())) {
                this.sendPacket(new S2FPacketSetSlot(this.playerEntity.openContainer.windowId, llllllllllllllIllIIIIlIIIllIlIlI.slotNumber, this.playerEntity.inventory.getCurrentItem()));
            }
        }
    }
    
    static {
        __OBFID = "CL_00001452";
        logger = LogManager.getLogger();
    }
    
    @Override
    public void processConfirmTransaction(final C0FPacketConfirmTransaction llllllllllllllIllIIIIIlllIlIlIlI) {
        PacketThreadUtil.func_180031_a(llllllllllllllIllIIIIIlllIlIlIlI, this, this.playerEntity.getServerForPlayer());
        final Short llllllllllllllIllIIIIIlllIlIllII = (Short)this.field_147372_n.lookup(this.playerEntity.openContainer.windowId);
        if (llllllllllllllIllIIIIIlllIlIllII != null && llllllllllllllIllIIIIIlllIlIlIlI.getUid() == llllllllllllllIllIIIIIlllIlIllII && this.playerEntity.openContainer.windowId == llllllllllllllIllIIIIIlllIlIlIlI.getId() && !this.playerEntity.openContainer.getCanCraft(this.playerEntity) && !this.playerEntity.func_175149_v()) {
            this.playerEntity.openContainer.setCanCraft(this.playerEntity, true);
        }
    }
    
    @Override
    public void func_175088_a(final C18PacketSpectate llllllllllllllIllIIIIlIIIlIlIIII) {
        PacketThreadUtil.func_180031_a(llllllllllllllIllIIIIlIIIlIlIIII, this, this.playerEntity.getServerForPlayer());
        if (this.playerEntity.func_175149_v()) {
            Entity llllllllllllllIllIIIIlIIIlIllIII = null;
            for (final WorldServer llllllllllllllIllIIIIlIIIlIlIlII : this.serverController.worldServers) {
                if (llllllllllllllIllIIIIlIIIlIlIlII != null) {
                    llllllllllllllIllIIIIlIIIlIllIII = llllllllllllllIllIIIIlIIIlIlIIII.func_179727_a(llllllllllllllIllIIIIlIIIlIlIlII);
                    if (llllllllllllllIllIIIIlIIIlIllIII != null) {
                        break;
                    }
                }
            }
            if (llllllllllllllIllIIIIlIIIlIllIII != null) {
                this.playerEntity.func_175399_e(this.playerEntity);
                this.playerEntity.mountEntity(null);
                if (llllllllllllllIllIIIIlIIIlIllIII.worldObj != this.playerEntity.worldObj) {
                    final WorldServer llllllllllllllIllIIIIlIIIlIlIIll = this.playerEntity.getServerForPlayer();
                    final WorldServer llllllllllllllIllIIIIlIIIlIlIIlI = (WorldServer)llllllllllllllIllIIIIlIIIlIllIII.worldObj;
                    this.playerEntity.dimension = llllllllllllllIllIIIIlIIIlIllIII.dimension;
                    this.sendPacket(new S07PacketRespawn(this.playerEntity.dimension, llllllllllllllIllIIIIlIIIlIlIIll.getDifficulty(), llllllllllllllIllIIIIlIIIlIlIIll.getWorldInfo().getTerrainType(), this.playerEntity.theItemInWorldManager.getGameType()));
                    llllllllllllllIllIIIIlIIIlIlIIll.removePlayerEntityDangerously(this.playerEntity);
                    this.playerEntity.isDead = false;
                    this.playerEntity.setLocationAndAngles(llllllllllllllIllIIIIlIIIlIllIII.posX, llllllllllllllIllIIIIlIIIlIllIII.posY, llllllllllllllIllIIIIlIIIlIllIII.posZ, llllllllllllllIllIIIIlIIIlIllIII.rotationYaw, llllllllllllllIllIIIIlIIIlIllIII.rotationPitch);
                    if (this.playerEntity.isEntityAlive()) {
                        llllllllllllllIllIIIIlIIIlIlIIll.updateEntityWithOptionalForce(this.playerEntity, false);
                        llllllllllllllIllIIIIlIIIlIlIIlI.spawnEntityInWorld(this.playerEntity);
                        llllllllllllllIllIIIIlIIIlIlIIlI.updateEntityWithOptionalForce(this.playerEntity, false);
                    }
                    this.playerEntity.setWorld(llllllllllllllIllIIIIlIIIlIlIIlI);
                    this.serverController.getConfigurationManager().func_72375_a(this.playerEntity, llllllllllllllIllIIIIlIIIlIlIIll);
                    this.playerEntity.setPositionAndUpdate(llllllllllllllIllIIIIlIIIlIllIII.posX, llllllllllllllIllIIIIlIIIlIllIII.posY, llllllllllllllIllIIIIlIIIlIllIII.posZ);
                    this.playerEntity.theItemInWorldManager.setWorld(llllllllllllllIllIIIIlIIIlIlIIlI);
                    this.serverController.getConfigurationManager().updateTimeAndWeatherForPlayer(this.playerEntity, llllllllllllllIllIIIIlIIIlIlIIlI);
                    this.serverController.getConfigurationManager().syncPlayerInventory(this.playerEntity);
                }
                else {
                    this.playerEntity.setPositionAndUpdate(llllllllllllllIllIIIIlIIIlIllIII.posX, llllllllllllllIllIIIIlIIIlIllIII.posY, llllllllllllllIllIIIIlIIIlIllIII.posZ);
                }
            }
        }
    }
    
    @Override
    public void processCloseWindow(final C0DPacketCloseWindow llllllllllllllIllIIIIIlllllIIlIl) {
        PacketThreadUtil.func_180031_a(llllllllllllllIllIIIIIlllllIIlIl, this, this.playerEntity.getServerForPlayer());
        this.playerEntity.closeContainer();
    }
    
    private void handleSlashCommand(final String llllllllllllllIllIIIIlIIIIIlIlIl) {
        this.serverController.getCommandManager().executeCommand(this.playerEntity, llllllllllllllIllIIIIlIIIIIlIlIl);
    }
    
    public void sendPacket(final Packet llllllllllllllIllIIIIlIIIIllIIlI) {
        if (llllllllllllllIllIIIIlIIIIllIIlI instanceof S02PacketChat) {
            final S02PacketChat llllllllllllllIllIIIIlIIIIlllIII = (S02PacketChat)llllllllllllllIllIIIIlIIIIllIIlI;
            final EntityPlayer.EnumChatVisibility llllllllllllllIllIIIIlIIIIllIlll = this.playerEntity.getChatVisibility();
            if (llllllllllllllIllIIIIlIIIIllIlll == EntityPlayer.EnumChatVisibility.HIDDEN) {
                return;
            }
            if (llllllllllllllIllIIIIlIIIIllIlll == EntityPlayer.EnumChatVisibility.SYSTEM && !llllllllllllllIllIIIIlIIIIlllIII.isChat()) {
                return;
            }
        }
        try {
            this.netManager.sendPacket(llllllllllllllIllIIIIlIIIIllIIlI);
        }
        catch (Throwable llllllllllllllIllIIIIlIIIIllIllI) {
            final CrashReport llllllllllllllIllIIIIlIIIIllIlIl = CrashReport.makeCrashReport(llllllllllllllIllIIIIlIIIIllIllI, "Sending packet");
            final CrashReportCategory llllllllllllllIllIIIIlIIIIllIlII = llllllllllllllIllIIIIlIIIIllIlIl.makeCategory("Packet being sent");
            llllllllllllllIllIIIIlIIIIllIlII.addCrashSectionCallable("Packet class", new Callable() {
                public String func_180225_a() {
                    return llllllllllllllIllIIIIlIIIIllIIlI.getClass().getCanonicalName();
                }
                
                @Override
                public Object call() {
                    return this.func_180225_a();
                }
                
                static {
                    __OBFID = "CL_00002270";
                }
            });
            throw new ReportedException(llllllllllllllIllIIIIlIIIIllIlIl);
        }
    }
    
    @Override
    public void func_175087_a(final C0APacketAnimation llllllllllllllIllIIIIlIIIIIIllll) {
        PacketThreadUtil.func_180031_a(llllllllllllllIllIIIIlIIIIIIllll, this, this.playerEntity.getServerForPlayer());
        this.playerEntity.markPlayerActive();
        this.playerEntity.swingItem();
    }
    
    @Override
    public void processHeldItemChange(final C09PacketHeldItemChange llllllllllllllIllIIIIlIIIIlIlIIl) {
        PacketThreadUtil.func_180031_a(llllllllllllllIllIIIIlIIIIlIlIIl, this, this.playerEntity.getServerForPlayer());
        if (llllllllllllllIllIIIIlIIIIlIlIIl.getSlotId() >= 0 && llllllllllllllIllIIIIlIIIIlIlIIl.getSlotId() < InventoryPlayer.getHotbarSize()) {
            this.playerEntity.inventory.currentItem = llllllllllllllIllIIIIlIIIIlIlIIl.getSlotId();
            this.playerEntity.markPlayerActive();
        }
        else {
            NetHandlerPlayServer.logger.warn(String.valueOf(new StringBuilder(String.valueOf(this.playerEntity.getName())).append(" tried to set an invalid carried item")));
        }
    }
    
    public NetworkManager getNetworkManager() {
        return this.netManager;
    }
    
    @Override
    public void processInput(final C0CPacketInput llllllllllllllIllIIIIlIlIIIlllll) {
        PacketThreadUtil.func_180031_a(llllllllllllllIllIIIIlIlIIIlllll, this, this.playerEntity.getServerForPlayer());
        this.playerEntity.setEntityActionState(llllllllllllllIllIIIIlIlIIIlllll.getStrafeSpeed(), llllllllllllllIllIIIIlIlIIIlllll.getForwardSpeed(), llllllllllllllIllIIIIlIlIIIlllll.isJumping(), llllllllllllllIllIIIIlIlIIIlllll.isSneaking());
    }
    
    @Override
    public void processKeepAlive(final C00PacketKeepAlive llllllllllllllIllIIIIIlllIIIllll) {
        if (llllllllllllllIllIIIIIlllIIIllll.getKey() == this.field_147378_h) {
            final int llllllllllllllIllIIIIIlllIIlIIIl = (int)(this.currentTimeMillis() - this.lastPingTime);
            this.playerEntity.ping = (this.playerEntity.ping * 3 + llllllllllllllIllIIIIIlllIIlIIIl) / 4;
        }
    }
    
    public void func_175089_a(final double llllllllllllllIllIIIIlIIlIlIIIll, final double llllllllllllllIllIIIIlIIlIlIIIlI, final double llllllllllllllIllIIIIlIIlIlIIIIl, final float llllllllllllllIllIIIIlIIlIIlIlll, final float llllllllllllllIllIIIIlIIlIIlllll, final Set llllllllllllllIllIIIIlIIlIIlIlIl) {
        this.hasMoved = false;
        this.lastPosX = llllllllllllllIllIIIIlIIlIlIIIll;
        this.lastPosY = llllllllllllllIllIIIIlIIlIlIIIlI;
        this.lastPosZ = llllllllllllllIllIIIIlIIlIlIIIIl;
        if (llllllllllllllIllIIIIlIIlIIlIlIl.contains(S08PacketPlayerPosLook.EnumFlags.X)) {
            this.lastPosX += this.playerEntity.posX;
        }
        if (llllllllllllllIllIIIIlIIlIIlIlIl.contains(S08PacketPlayerPosLook.EnumFlags.Y)) {
            this.lastPosY += this.playerEntity.posY;
        }
        if (llllllllllllllIllIIIIlIIlIIlIlIl.contains(S08PacketPlayerPosLook.EnumFlags.Z)) {
            this.lastPosZ += this.playerEntity.posZ;
        }
        float llllllllllllllIllIIIIlIIlIIlllIl = llllllllllllllIllIIIIlIIlIIlIlll;
        float llllllllllllllIllIIIIlIIlIIlllII = llllllllllllllIllIIIIlIIlIIlllll;
        if (llllllllllllllIllIIIIlIIlIIlIlIl.contains(S08PacketPlayerPosLook.EnumFlags.Y_ROT)) {
            llllllllllllllIllIIIIlIIlIIlllIl = llllllllllllllIllIIIIlIIlIIlIlll + this.playerEntity.rotationYaw;
        }
        if (llllllllllllllIllIIIIlIIlIIlIlIl.contains(S08PacketPlayerPosLook.EnumFlags.X_ROT)) {
            llllllllllllllIllIIIIlIIlIIlllII = llllllllllllllIllIIIIlIIlIIlllll + this.playerEntity.rotationPitch;
        }
        this.playerEntity.setPositionAndRotation(this.lastPosX, this.lastPosY, this.lastPosZ, llllllllllllllIllIIIIlIIlIIlllIl, llllllllllllllIllIIIIlIIlIIlllII);
        this.playerEntity.playerNetServerHandler.sendPacket(new S08PacketPlayerPosLook(llllllllllllllIllIIIIlIIlIlIIIll, llllllllllllllIllIIIIlIIlIlIIIlI, llllllllllllllIllIIIIlIIlIlIIIIl, llllllllllllllIllIIIIlIIlIIlIlll, llllllllllllllIllIIIIlIIlIIlllll, llllllllllllllIllIIIIlIIlIIlIlIl));
    }
    
    @Override
    public void processPlayerAbilities(final C13PacketPlayerAbilities llllllllllllllIllIIIIIlllIIIlIIl) {
        PacketThreadUtil.func_180031_a(llllllllllllllIllIIIIIlllIIIlIIl, this, this.playerEntity.getServerForPlayer());
        this.playerEntity.capabilities.isFlying = (llllllllllllllIllIIIIIlllIIIlIIl.isFlying() && this.playerEntity.capabilities.allowFlying);
    }
    
    @Override
    public void processVanilla250Packet(final C17PacketCustomPayload llllllllllllllIllIIIIIllIllIIllI) {
        PacketThreadUtil.func_180031_a(llllllllllllllIllIIIIIllIllIIllI, this, this.playerEntity.getServerForPlayer());
        if ("MC|BEdit".equals(llllllllllllllIllIIIIIllIllIIllI.getChannelName())) {
            final PacketBuffer llllllllllllllIllIIIIIllIllIIlIl = new PacketBuffer(Unpooled.wrappedBuffer((ByteBuf)llllllllllllllIllIIIIIllIllIIllI.getBufferData()));
            try {
                final ItemStack llllllllllllllIllIIIIIllIllIIIIl = llllllllllllllIllIIIIIllIllIIlIl.readItemStackFromBuffer();
                if (llllllllllllllIllIIIIIllIllIIIIl == null) {
                    return;
                }
                if (!ItemWritableBook.validBookPageTagContents(llllllllllllllIllIIIIIllIllIIIIl.getTagCompound())) {
                    throw new IOException("Invalid book tag!");
                }
                final ItemStack llllllllllllllIllIIIIIllIlIlllIl = this.playerEntity.inventory.getCurrentItem();
                if (llllllllllllllIllIIIIIllIlIlllIl != null) {
                    if (llllllllllllllIllIIIIIllIllIIIIl.getItem() == Items.writable_book && llllllllllllllIllIIIIIllIllIIIIl.getItem() == llllllllllllllIllIIIIIllIlIlllIl.getItem()) {
                        llllllllllllllIllIIIIIllIlIlllIl.setTagInfo("pages", llllllllllllllIllIIIIIllIllIIIIl.getTagCompound().getTagList("pages", 8));
                    }
                    return;
                }
            }
            catch (Exception llllllllllllllIllIIIIIllIlIllIlI) {
                NetHandlerPlayServer.logger.error("Couldn't handle book info", (Throwable)llllllllllllllIllIIIIIllIlIllIlI);
                return;
            }
            finally {
                llllllllllllllIllIIIIIllIllIIlIl.release();
            }
            llllllllllllllIllIIIIIllIllIIlIl.release();
            return;
        }
        if ("MC|BSign".equals(llllllllllllllIllIIIIIllIllIIllI.getChannelName())) {
            final PacketBuffer llllllllllllllIllIIIIIllIllIIlII = new PacketBuffer(Unpooled.wrappedBuffer((ByteBuf)llllllllllllllIllIIIIIllIllIIllI.getBufferData()));
            try {
                final ItemStack llllllllllllllIllIIIIIllIlIlllll = llllllllllllllIllIIIIIllIllIIlII.readItemStackFromBuffer();
                if (llllllllllllllIllIIIIIllIlIlllll != null) {
                    if (!ItemEditableBook.validBookTagContents(llllllllllllllIllIIIIIllIlIlllll.getTagCompound())) {
                        throw new IOException("Invalid book tag!");
                    }
                    final ItemStack llllllllllllllIllIIIIIllIlIllIll = this.playerEntity.inventory.getCurrentItem();
                    if (llllllllllllllIllIIIIIllIlIllIll == null) {
                        return;
                    }
                    if (llllllllllllllIllIIIIIllIlIlllll.getItem() == Items.written_book && llllllllllllllIllIIIIIllIlIllIll.getItem() == Items.writable_book) {
                        llllllllllllllIllIIIIIllIlIllIll.setTagInfo("author", new NBTTagString(this.playerEntity.getName()));
                        llllllllllllllIllIIIIIllIlIllIll.setTagInfo("title", new NBTTagString(llllllllllllllIllIIIIIllIlIlllll.getTagCompound().getString("title")));
                        llllllllllllllIllIIIIIllIlIllIll.setTagInfo("pages", llllllllllllllIllIIIIIllIlIlllll.getTagCompound().getTagList("pages", 8));
                        llllllllllllllIllIIIIIllIlIllIll.setItem(Items.written_book);
                    }
                    return;
                }
            }
            catch (Exception llllllllllllllIllIIIIIllIlIllIIl) {
                NetHandlerPlayServer.logger.error("Couldn't sign book", (Throwable)llllllllllllllIllIIIIIllIlIllIIl);
                return;
            }
            finally {
                llllllllllllllIllIIIIIllIllIIlII.release();
            }
            llllllllllllllIllIIIIIllIllIIlII.release();
            return;
        }
        if ("MC|TrSel".equals(llllllllllllllIllIIIIIllIllIIllI.getChannelName())) {
            try {
                final int llllllllllllllIllIIIIIllIlIllIII = llllllllllllllIllIIIIIllIllIIllI.getBufferData().readInt();
                final Container llllllllllllllIllIIIIIllIlIlIlll = this.playerEntity.openContainer;
                if (llllllllllllllIllIIIIIllIlIlIlll instanceof ContainerMerchant) {
                    ((ContainerMerchant)llllllllllllllIllIIIIIllIlIlIlll).setCurrentRecipeIndex(llllllllllllllIllIIIIIllIlIllIII);
                }
            }
            catch (Exception llllllllllllllIllIIIIIllIlIlIllI) {
                NetHandlerPlayServer.logger.error("Couldn't select trade", (Throwable)llllllllllllllIllIIIIIllIlIlIllI);
            }
        }
        else if ("MC|AdvCdm".equals(llllllllllllllIllIIIIIllIllIIllI.getChannelName())) {
            if (!this.serverController.isCommandBlockEnabled()) {
                this.playerEntity.addChatMessage(new ChatComponentTranslation("advMode.notEnabled", new Object[0]));
            }
            else if (this.playerEntity.canCommandSenderUseCommand(2, "") && this.playerEntity.capabilities.isCreativeMode) {
                final PacketBuffer llllllllllllllIllIIIIIllIllIIIll = llllllllllllllIllIIIIIllIllIIllI.getBufferData();
                try {
                    final byte llllllllllllllIllIIIIIllIlIlIlIl = llllllllllllllIllIIIIIllIllIIIll.readByte();
                    CommandBlockLogic llllllllllllllIllIIIIIllIlIlIlII = null;
                    if (llllllllllllllIllIIIIIllIlIlIlIl == 0) {
                        final TileEntity llllllllllllllIllIIIIIllIlIlIIll = this.playerEntity.worldObj.getTileEntity(new BlockPos(llllllllllllllIllIIIIIllIllIIIll.readInt(), llllllllllllllIllIIIIIllIllIIIll.readInt(), llllllllllllllIllIIIIIllIllIIIll.readInt()));
                        if (llllllllllllllIllIIIIIllIlIlIIll instanceof TileEntityCommandBlock) {
                            llllllllllllllIllIIIIIllIlIlIlII = ((TileEntityCommandBlock)llllllllllllllIllIIIIIllIlIlIIll).getCommandBlockLogic();
                        }
                    }
                    else if (llllllllllllllIllIIIIIllIlIlIlIl == 1) {
                        final Entity llllllllllllllIllIIIIIllIlIlIIlI = this.playerEntity.worldObj.getEntityByID(llllllllllllllIllIIIIIllIllIIIll.readInt());
                        if (llllllllllllllIllIIIIIllIlIlIIlI instanceof EntityMinecartCommandBlock) {
                            llllllllllllllIllIIIIIllIlIlIlII = ((EntityMinecartCommandBlock)llllllllllllllIllIIIIIllIlIlIIlI).func_145822_e();
                        }
                    }
                    final String llllllllllllllIllIIIIIllIlIlIIIl = llllllllllllllIllIIIIIllIllIIIll.readStringFromBuffer(llllllllllllllIllIIIIIllIllIIIll.readableBytes());
                    final boolean llllllllllllllIllIIIIIllIlIlIIII = llllllllllllllIllIIIIIllIllIIIll.readBoolean();
                    if (llllllllllllllIllIIIIIllIlIlIlII != null) {
                        llllllllllllllIllIIIIIllIlIlIlII.setCommand(llllllllllllllIllIIIIIllIlIlIIIl);
                        llllllllllllllIllIIIIIllIlIlIlII.func_175573_a(llllllllllllllIllIIIIIllIlIlIIII);
                        if (!llllllllllllllIllIIIIIllIlIlIIII) {
                            llllllllllllllIllIIIIIllIlIlIlII.func_145750_b(null);
                        }
                        llllllllllllllIllIIIIIllIlIlIlII.func_145756_e();
                        this.playerEntity.addChatMessage(new ChatComponentTranslation("advMode.setCommand.success", new Object[] { llllllllllllllIllIIIIIllIlIlIIIl }));
                    }
                }
                catch (Exception llllllllllllllIllIIIIIllIlIIllll) {
                    NetHandlerPlayServer.logger.error("Couldn't set command block", (Throwable)llllllllllllllIllIIIIIllIlIIllll);
                    return;
                }
                finally {
                    llllllllllllllIllIIIIIllIllIIIll.release();
                }
                llllllllllllllIllIIIIIllIllIIIll.release();
            }
            else {
                this.playerEntity.addChatMessage(new ChatComponentTranslation("advMode.notAllowed", new Object[0]));
            }
        }
        else if ("MC|Beacon".equals(llllllllllllllIllIIIIIllIllIIllI.getChannelName())) {
            if (this.playerEntity.openContainer instanceof ContainerBeacon) {
                try {
                    final PacketBuffer llllllllllllllIllIIIIIllIllIIIlI = llllllllllllllIllIIIIIllIllIIllI.getBufferData();
                    final int llllllllllllllIllIIIIIllIlIIlllI = llllllllllllllIllIIIIIllIllIIIlI.readInt();
                    final int llllllllllllllIllIIIIIllIlIIllIl = llllllllllllllIllIIIIIllIllIIIlI.readInt();
                    final ContainerBeacon llllllllllllllIllIIIIIllIlIIllII = (ContainerBeacon)this.playerEntity.openContainer;
                    final Slot llllllllllllllIllIIIIIllIlIIlIll = llllllllllllllIllIIIIIllIlIIllII.getSlot(0);
                    if (llllllllllllllIllIIIIIllIlIIlIll.getHasStack()) {
                        llllllllllllllIllIIIIIllIlIIlIll.decrStackSize(1);
                        final IInventory llllllllllllllIllIIIIIllIlIIlIlI = llllllllllllllIllIIIIIllIlIIllII.func_180611_e();
                        llllllllllllllIllIIIIIllIlIIlIlI.setField(1, llllllllllllllIllIIIIIllIlIIlllI);
                        llllllllllllllIllIIIIIllIlIIlIlI.setField(2, llllllllllllllIllIIIIIllIlIIllIl);
                        llllllllllllllIllIIIIIllIlIIlIlI.markDirty();
                    }
                }
                catch (Exception llllllllllllllIllIIIIIllIlIIlIIl) {
                    NetHandlerPlayServer.logger.error("Couldn't set beacon", (Throwable)llllllllllllllIllIIIIIllIlIIlIIl);
                }
            }
        }
        else if ("MC|ItemName".equals(llllllllllllllIllIIIIIllIllIIllI.getChannelName()) && this.playerEntity.openContainer instanceof ContainerRepair) {
            final ContainerRepair llllllllllllllIllIIIIIllIlIIlIII = (ContainerRepair)this.playerEntity.openContainer;
            if (llllllllllllllIllIIIIIllIllIIllI.getBufferData() != null && llllllllllllllIllIIIIIllIllIIllI.getBufferData().readableBytes() >= 1) {
                final String llllllllllllllIllIIIIIllIlIIIlll = ChatAllowedCharacters.filterAllowedCharacters(llllllllllllllIllIIIIIllIllIIllI.getBufferData().readStringFromBuffer(32767));
                if (llllllllllllllIllIIIIIllIlIIIlll.length() <= 30) {
                    llllllllllllllIllIIIIIllIlIIlIII.updateItemName(llllllllllllllIllIIIIIllIlIIIlll);
                }
            }
            else {
                llllllllllllllIllIIIIIllIlIIlIII.updateItemName("");
            }
        }
    }
    
    public void setPlayerLocation(final double llllllllllllllIllIIIIlIIlIllIIlI, final double llllllllllllllIllIIIIlIIlIllIlll, final double llllllllllllllIllIIIIlIIlIllIIII, final float llllllllllllllIllIIIIlIIlIllIlIl, final float llllllllllllllIllIIIIlIIlIllIlII) {
        this.func_175089_a(llllllllllllllIllIIIIlIIlIllIIlI, llllllllllllllIllIIIIlIIlIllIlll, llllllllllllllIllIIIIlIIlIllIIII, llllllllllllllIllIIIIlIIlIllIlIl, llllllllllllllIllIIIIlIIlIllIlII, Collections.emptySet());
    }
    
    @Override
    public void processPlayerDigging(final C07PacketPlayerDigging llllllllllllllIllIIIIlIIlIIIIIIl) {
        PacketThreadUtil.func_180031_a(llllllllllllllIllIIIIlIIlIIIIIIl, this, this.playerEntity.getServerForPlayer());
        final WorldServer llllllllllllllIllIIIIlIIlIIIlIII = this.serverController.worldServerForDimension(this.playerEntity.dimension);
        final BlockPos llllllllllllllIllIIIIlIIlIIIIlll = llllllllllllllIllIIIIlIIlIIIIIIl.func_179715_a();
        this.playerEntity.markPlayerActive();
        switch (SwitchAction.field_180224_a[llllllllllllllIllIIIIlIIlIIIIIIl.func_180762_c().ordinal()]) {
            case 1: {
                if (!this.playerEntity.func_175149_v()) {
                    this.playerEntity.dropOneItem(false);
                }
            }
            case 2: {
                if (!this.playerEntity.func_175149_v()) {
                    this.playerEntity.dropOneItem(true);
                }
            }
            case 3: {
                this.playerEntity.stopUsingItem();
            }
            case 4:
            case 5:
            case 6: {
                final double llllllllllllllIllIIIIlIIlIIIIllI = this.playerEntity.posX - (llllllllllllllIllIIIIlIIlIIIIlll.getX() + 0.5);
                final double llllllllllllllIllIIIIlIIlIIIIlIl = this.playerEntity.posY - (llllllllllllllIllIIIIlIIlIIIIlll.getY() + 0.5) + 1.5;
                final double llllllllllllllIllIIIIlIIlIIIIlII = this.playerEntity.posZ - (llllllllllllllIllIIIIlIIlIIIIlll.getZ() + 0.5);
                final double llllllllllllllIllIIIIlIIlIIIIIll = llllllllllllllIllIIIIlIIlIIIIllI * llllllllllllllIllIIIIlIIlIIIIllI + llllllllllllllIllIIIIlIIlIIIIlIl * llllllllllllllIllIIIIlIIlIIIIlIl + llllllllllllllIllIIIIlIIlIIIIlII * llllllllllllllIllIIIIlIIlIIIIlII;
                if (llllllllllllllIllIIIIlIIlIIIIIll > 36.0) {
                    return;
                }
                if (llllllllllllllIllIIIIlIIlIIIIlll.getY() >= this.serverController.getBuildLimit()) {
                    return;
                }
                if (llllllllllllllIllIIIIlIIlIIIIIIl.func_180762_c() == C07PacketPlayerDigging.Action.START_DESTROY_BLOCK) {
                    if (!this.serverController.isBlockProtected(llllllllllllllIllIIIIlIIlIIIlIII, llllllllllllllIllIIIIlIIlIIIIlll, this.playerEntity) && llllllllllllllIllIIIIlIIlIIIlIII.getWorldBorder().contains(llllllllllllllIllIIIIlIIlIIIIlll)) {
                        this.playerEntity.theItemInWorldManager.func_180784_a(llllllllllllllIllIIIIlIIlIIIIlll, llllllllllllllIllIIIIlIIlIIIIIIl.func_179714_b());
                    }
                    else {
                        this.playerEntity.playerNetServerHandler.sendPacket(new S23PacketBlockChange(llllllllllllllIllIIIIlIIlIIIlIII, llllllllllllllIllIIIIlIIlIIIIlll));
                    }
                }
                else {
                    if (llllllllllllllIllIIIIlIIlIIIIIIl.func_180762_c() == C07PacketPlayerDigging.Action.STOP_DESTROY_BLOCK) {
                        this.playerEntity.theItemInWorldManager.func_180785_a(llllllllllllllIllIIIIlIIlIIIIlll);
                    }
                    else if (llllllllllllllIllIIIIlIIlIIIIIIl.func_180762_c() == C07PacketPlayerDigging.Action.ABORT_DESTROY_BLOCK) {
                        this.playerEntity.theItemInWorldManager.func_180238_e();
                    }
                    if (llllllllllllllIllIIIIlIIlIIIlIII.getBlockState(llllllllllllllIllIIIIlIIlIIIIlll).getBlock().getMaterial() != Material.air) {
                        this.playerEntity.playerNetServerHandler.sendPacket(new S23PacketBlockChange(llllllllllllllIllIIIIlIIlIIIlIII, llllllllllllllIllIIIIlIIlIIIIlll));
                    }
                }
            }
            default: {
                throw new IllegalArgumentException("Invalid player action");
            }
        }
    }
    
    @Override
    public void processTabComplete(final C14PacketTabComplete llllllllllllllIllIIIIIlllIIIIIII) {
        PacketThreadUtil.func_180031_a(llllllllllllllIllIIIIIlllIIIIIII, this, this.playerEntity.getServerForPlayer());
        final ArrayList llllllllllllllIllIIIIIllIlllllll = Lists.newArrayList();
        for (final String llllllllllllllIllIIIIIllIlllllIl : this.serverController.func_180506_a(this.playerEntity, llllllllllllllIllIIIIIlllIIIIIII.getMessage(), llllllllllllllIllIIIIIlllIIIIIII.func_179709_b())) {
            llllllllllllllIllIIIIIllIlllllll.add(llllllllllllllIllIIIIIllIlllllIl);
        }
        this.playerEntity.playerNetServerHandler.sendPacket(new S3APacketTabComplete(llllllllllllllIllIIIIIllIlllllll.toArray(new String[llllllllllllllIllIIIIIllIlllllll.size()])));
    }
    
    @Override
    public void onDisconnect(final IChatComponent llllllllllllllIllIIIIlIIIlIIIIIl) {
        NetHandlerPlayServer.logger.info(String.valueOf(new StringBuilder(String.valueOf(this.playerEntity.getName())).append(" lost connection: ").append(llllllllllllllIllIIIIlIIIlIIIIIl)));
        this.serverController.refreshStatusNextTick();
        final ChatComponentTranslation llllllllllllllIllIIIIlIIIlIIIIll = new ChatComponentTranslation("multiplayer.player.left", new Object[] { this.playerEntity.getDisplayName() });
        llllllllllllllIllIIIIlIIIlIIIIll.getChatStyle().setColor(EnumChatFormatting.YELLOW);
        this.serverController.getConfigurationManager().sendChatMsg(llllllllllllllIllIIIIlIIIlIIIIll);
        this.playerEntity.mountEntityAndWakeUp();
        this.serverController.getConfigurationManager().playerLoggedOut(this.playerEntity);
        if (this.serverController.isSinglePlayer() && this.playerEntity.getName().equals(this.serverController.getServerOwner())) {
            NetHandlerPlayServer.logger.info("Stopping singleplayer server as player logged out");
            this.serverController.initiateShutdown();
        }
    }
    
    public void kickPlayerFromServer(final String llllllllllllllIllIIIIlIlIIlIIlII) {
        final ChatComponentText llllllllllllllIllIIIIlIlIIlIIllI = new ChatComponentText(llllllllllllllIllIIIIlIlIIlIIlII);
        this.netManager.sendPacket(new S40PacketDisconnect(llllllllllllllIllIIIIlIlIIlIIllI), (GenericFutureListener)new GenericFutureListener() {
            public void operationComplete(final Future lllllllllllllllIIlIIlIIIIIIIlIIl) {
                NetHandlerPlayServer.this.netManager.closeChannel(llllllllllllllIllIIIIlIlIIlIIllI);
            }
            
            static {
                __OBFID = "CL_00001453";
            }
        }, new GenericFutureListener[0]);
        this.netManager.disableAutoRead();
        Futures.getUnchecked((java.util.concurrent.Future)this.serverController.addScheduledTask(new Runnable() {
            static {
                __OBFID = "CL_00001454";
            }
            
            @Override
            public void run() {
                NetHandlerPlayServer.this.netManager.checkDisconnected();
            }
        }));
    }
    
    @Override
    public void processCreativeInventoryAction(final C10PacketCreativeInventoryAction llllllllllllllIllIIIIIllllIIIlII) {
        PacketThreadUtil.func_180031_a(llllllllllllllIllIIIIIllllIIIlII, this, this.playerEntity.getServerForPlayer());
        if (this.playerEntity.theItemInWorldManager.isCreative()) {
            final boolean llllllllllllllIllIIIIIllllIIIIll = llllllllllllllIllIIIIIllllIIIlII.getSlotId() < 0;
            final ItemStack llllllllllllllIllIIIIIllllIIIIlI = llllllllllllllIllIIIIIllllIIIlII.getStack();
            if (llllllllllllllIllIIIIIllllIIIIlI != null && llllllllllllllIllIIIIIllllIIIIlI.hasTagCompound() && llllllllllllllIllIIIIIllllIIIIlI.getTagCompound().hasKey("BlockEntityTag", 10)) {
                final NBTTagCompound llllllllllllllIllIIIIIllllIIIIIl = llllllllllllllIllIIIIIllllIIIIlI.getTagCompound().getCompoundTag("BlockEntityTag");
                if (llllllllllllllIllIIIIIllllIIIIIl.hasKey("x") && llllllllllllllIllIIIIIllllIIIIIl.hasKey("y") && llllllllllllllIllIIIIIllllIIIIIl.hasKey("z")) {
                    final BlockPos llllllllllllllIllIIIIIllllIIIIII = new BlockPos(llllllllllllllIllIIIIIllllIIIIIl.getInteger("x"), llllllllllllllIllIIIIIllllIIIIIl.getInteger("y"), llllllllllllllIllIIIIIllllIIIIIl.getInteger("z"));
                    final TileEntity llllllllllllllIllIIIIIlllIllllll = this.playerEntity.worldObj.getTileEntity(llllllllllllllIllIIIIIllllIIIIII);
                    if (llllllllllllllIllIIIIIlllIllllll != null) {
                        final NBTTagCompound llllllllllllllIllIIIIIlllIlllllI = new NBTTagCompound();
                        llllllllllllllIllIIIIIlllIllllll.writeToNBT(llllllllllllllIllIIIIIlllIlllllI);
                        llllllllllllllIllIIIIIlllIlllllI.removeTag("x");
                        llllllllllllllIllIIIIIlllIlllllI.removeTag("y");
                        llllllllllllllIllIIIIIlllIlllllI.removeTag("z");
                        llllllllllllllIllIIIIIllllIIIIlI.setTagInfo("BlockEntityTag", llllllllllllllIllIIIIIlllIlllllI);
                    }
                }
            }
            final boolean llllllllllllllIllIIIIIlllIllllIl = llllllllllllllIllIIIIIllllIIIlII.getSlotId() >= 1 && llllllllllllllIllIIIIIllllIIIlII.getSlotId() < 36 + InventoryPlayer.getHotbarSize();
            final boolean llllllllllllllIllIIIIIlllIllllII = llllllllllllllIllIIIIIllllIIIIlI == null || llllllllllllllIllIIIIIllllIIIIlI.getItem() != null;
            final boolean llllllllllllllIllIIIIIlllIlllIll = llllllllllllllIllIIIIIllllIIIIlI == null || (llllllllllllllIllIIIIIllllIIIIlI.getMetadata() >= 0 && llllllllllllllIllIIIIIllllIIIIlI.stackSize <= 64 && llllllllllllllIllIIIIIllllIIIIlI.stackSize > 0);
            if (llllllllllllllIllIIIIIlllIllllIl && llllllllllllllIllIIIIIlllIllllII && llllllllllllllIllIIIIIlllIlllIll) {
                if (llllllllllllllIllIIIIIllllIIIIlI == null) {
                    this.playerEntity.inventoryContainer.putStackInSlot(llllllllllllllIllIIIIIllllIIIlII.getSlotId(), null);
                }
                else {
                    this.playerEntity.inventoryContainer.putStackInSlot(llllllllllllllIllIIIIIllllIIIlII.getSlotId(), llllllllllllllIllIIIIIllllIIIIlI);
                }
                this.playerEntity.inventoryContainer.setCanCraft(this.playerEntity, true);
            }
            else if (llllllllllllllIllIIIIIllllIIIIll && llllllllllllllIllIIIIIlllIllllII && llllllllllllllIllIIIIIlllIlllIll && this.itemDropThreshold < 200) {
                this.itemDropThreshold += 20;
                final EntityItem llllllllllllllIllIIIIIlllIlllIlI = this.playerEntity.dropPlayerItemWithRandomChoice(llllllllllllllIllIIIIIllllIIIIlI, true);
                if (llllllllllllllIllIIIIIlllIlllIlI != null) {
                    llllllllllllllIllIIIIIlllIlllIlI.setAgeToCreativeDespawnTime();
                }
            }
        }
    }
    
    public NetHandlerPlayServer(final MinecraftServer llllllllllllllIllIIIIlIlIIllIlII, final NetworkManager llllllllllllllIllIIIIlIlIIllIIll, final EntityPlayerMP llllllllllllllIllIIIIlIlIIllIIlI) {
        this.field_147372_n = new IntHashMap();
        this.hasMoved = true;
        this.serverController = llllllllllllllIllIIIIlIlIIllIlII;
        this.netManager = llllllllllllllIllIIIIlIlIIllIIll;
        llllllllllllllIllIIIIlIlIIllIIll.setNetHandler(this);
        this.playerEntity = llllllllllllllIllIIIIlIlIIllIIlI;
        llllllllllllllIllIIIIlIlIIllIIlI.playerNetServerHandler = this;
    }
    
    private long currentTimeMillis() {
        return System.nanoTime() / 1000000L;
    }
    
    @Override
    public void processClickWindow(final C0EPacketClickWindow llllllllllllllIllIIIIIllllIlIlll) {
        PacketThreadUtil.func_180031_a(llllllllllllllIllIIIIIllllIlIlll, this, this.playerEntity.getServerForPlayer());
        this.playerEntity.markPlayerActive();
        if (this.playerEntity.openContainer.windowId == llllllllllllllIllIIIIIllllIlIlll.getWindowId() && this.playerEntity.openContainer.getCanCraft(this.playerEntity)) {
            if (this.playerEntity.func_175149_v()) {
                final ArrayList llllllllllllllIllIIIIIllllIlllIl = Lists.newArrayList();
                for (int llllllllllllllIllIIIIIllllIlllII = 0; llllllllllllllIllIIIIIllllIlllII < this.playerEntity.openContainer.inventorySlots.size(); ++llllllllllllllIllIIIIIllllIlllII) {
                    llllllllllllllIllIIIIIllllIlllIl.add(this.playerEntity.openContainer.inventorySlots.get(llllllllllllllIllIIIIIllllIlllII).getStack());
                }
                this.playerEntity.updateCraftingInventory(this.playerEntity.openContainer, llllllllllllllIllIIIIIllllIlllIl);
            }
            else {
                final ItemStack llllllllllllllIllIIIIIllllIllIll = this.playerEntity.openContainer.slotClick(llllllllllllllIllIIIIIllllIlIlll.getSlotId(), llllllllllllllIllIIIIIllllIlIlll.getUsedButton(), llllllllllllllIllIIIIIllllIlIlll.getMode(), this.playerEntity);
                if (ItemStack.areItemStacksEqual(llllllllllllllIllIIIIIllllIlIlll.getClickedItem(), llllllllllllllIllIIIIIllllIllIll)) {
                    this.playerEntity.playerNetServerHandler.sendPacket(new S32PacketConfirmTransaction(llllllllllllllIllIIIIIllllIlIlll.getWindowId(), llllllllllllllIllIIIIIllllIlIlll.getActionNumber(), true));
                    this.playerEntity.isChangingQuantityOnly = true;
                    this.playerEntity.openContainer.detectAndSendChanges();
                    this.playerEntity.updateHeldItem();
                    this.playerEntity.isChangingQuantityOnly = false;
                }
                else {
                    this.field_147372_n.addKey(this.playerEntity.openContainer.windowId, llllllllllllllIllIIIIIllllIlIlll.getActionNumber());
                    this.playerEntity.playerNetServerHandler.sendPacket(new S32PacketConfirmTransaction(llllllllllllllIllIIIIIllllIlIlll.getWindowId(), llllllllllllllIllIIIIIllllIlIlll.getActionNumber(), false));
                    this.playerEntity.openContainer.setCanCraft(this.playerEntity, false);
                    final ArrayList llllllllllllllIllIIIIIllllIllIlI = Lists.newArrayList();
                    for (int llllllllllllllIllIIIIIllllIllIIl = 0; llllllllllllllIllIIIIIllllIllIIl < this.playerEntity.openContainer.inventorySlots.size(); ++llllllllllllllIllIIIIIllllIllIIl) {
                        llllllllllllllIllIIIIIllllIllIlI.add(this.playerEntity.openContainer.inventorySlots.get(llllllllllllllIllIIIIIllllIllIIl).getStack());
                    }
                    this.playerEntity.updateCraftingInventory(this.playerEntity.openContainer, llllllllllllllIllIIIIIllllIllIlI);
                }
            }
        }
    }
    
    @Override
    public void processEntityAction(final C0BPacketEntityAction llllllllllllllIllIIIIlIIIIIIlIIl) {
        PacketThreadUtil.func_180031_a(llllllllllllllIllIIIIlIIIIIIlIIl, this, this.playerEntity.getServerForPlayer());
        this.playerEntity.markPlayerActive();
        switch (SwitchAction.field_180222_b[llllllllllllllIllIIIIlIIIIIIlIIl.func_180764_b().ordinal()]) {
            case 1: {
                this.playerEntity.setSneaking(true);
                break;
            }
            case 2: {
                this.playerEntity.setSneaking(false);
                break;
            }
            case 3: {
                this.playerEntity.setSprinting(true);
                break;
            }
            case 4: {
                this.playerEntity.setSprinting(false);
                break;
            }
            case 5: {
                this.playerEntity.wakeUpPlayer(false, true, true);
                this.hasMoved = false;
                break;
            }
            case 6: {
                if (this.playerEntity.ridingEntity instanceof EntityHorse) {
                    ((EntityHorse)this.playerEntity.ridingEntity).setJumpPower(llllllllllllllIllIIIIlIIIIIIlIIl.func_149512_e());
                    break;
                }
                break;
            }
            case 7: {
                if (this.playerEntity.ridingEntity instanceof EntityHorse) {
                    ((EntityHorse)this.playerEntity.ridingEntity).openGUI(this.playerEntity);
                    break;
                }
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid client command!");
            }
        }
    }
    
    @Override
    public void processChatMessage(final C01PacketChatMessage llllllllllllllIllIIIIlIIIIIlllIl) {
        PacketThreadUtil.func_180031_a(llllllllllllllIllIIIIlIIIIIlllIl, this, this.playerEntity.getServerForPlayer());
        if (this.playerEntity.getChatVisibility() == EntityPlayer.EnumChatVisibility.HIDDEN) {
            final ChatComponentTranslation llllllllllllllIllIIIIlIIIIlIIIlI = new ChatComponentTranslation("chat.cannotSend", new Object[0]);
            llllllllllllllIllIIIIlIIIIlIIIlI.getChatStyle().setColor(EnumChatFormatting.RED);
            this.sendPacket(new S02PacketChat(llllllllllllllIllIIIIlIIIIlIIIlI));
        }
        else {
            this.playerEntity.markPlayerActive();
            String llllllllllllllIllIIIIlIIIIlIIIIl = llllllllllllllIllIIIIlIIIIIlllIl.getMessage();
            llllllllllllllIllIIIIlIIIIlIIIIl = StringUtils.normalizeSpace(llllllllllllllIllIIIIlIIIIlIIIIl);
            for (int llllllllllllllIllIIIIlIIIIlIIIII = 0; llllllllllllllIllIIIIlIIIIlIIIII < llllllllllllllIllIIIIlIIIIlIIIIl.length(); ++llllllllllllllIllIIIIlIIIIlIIIII) {
                if (!ChatAllowedCharacters.isAllowedCharacter(llllllllllllllIllIIIIlIIIIlIIIIl.charAt(llllllllllllllIllIIIIlIIIIlIIIII))) {
                    this.kickPlayerFromServer("Illegal characters in chat");
                    return;
                }
            }
            if (llllllllllllllIllIIIIlIIIIlIIIIl.startsWith("/")) {
                this.handleSlashCommand(llllllllllllllIllIIIIlIIIIlIIIIl);
            }
            else {
                final ChatComponentTranslation llllllllllllllIllIIIIlIIIIIlllll = new ChatComponentTranslation("chat.type.text", new Object[] { this.playerEntity.getDisplayName(), llllllllllllllIllIIIIlIIIIlIIIIl });
                this.serverController.getConfigurationManager().sendChatMsgImpl(llllllllllllllIllIIIIlIIIIIlllll, false);
            }
            this.chatSpamThresholdCount += 20;
            if (this.chatSpamThresholdCount > 200 && !this.serverController.getConfigurationManager().canSendCommands(this.playerEntity.getGameProfile())) {
                this.kickPlayerFromServer("disconnect.spam");
            }
        }
    }
    
    @Override
    public void processEnchantItem(final C11PacketEnchantItem llllllllllllllIllIIIIIllllIIlllI) {
        PacketThreadUtil.func_180031_a(llllllllllllllIllIIIIIllllIIlllI, this, this.playerEntity.getServerForPlayer());
        this.playerEntity.markPlayerActive();
        if (this.playerEntity.openContainer.windowId == llllllllllllllIllIIIIIllllIIlllI.getId() && this.playerEntity.openContainer.getCanCraft(this.playerEntity) && !this.playerEntity.func_175149_v()) {
            this.playerEntity.openContainer.enchantItem(this.playerEntity, llllllllllllllIllIIIIIllllIIlllI.getButton());
            this.playerEntity.openContainer.detectAndSendChanges();
        }
    }
    
    @Override
    public void processUpdateSign(final C12PacketUpdateSign llllllllllllllIllIIIIIlllIIllIll) {
        PacketThreadUtil.func_180031_a(llllllllllllllIllIIIIIlllIIllIll, this, this.playerEntity.getServerForPlayer());
        this.playerEntity.markPlayerActive();
        final WorldServer llllllllllllllIllIIIIIlllIlIIIII = this.serverController.worldServerForDimension(this.playerEntity.dimension);
        final BlockPos llllllllllllllIllIIIIIlllIIlllll = llllllllllllllIllIIIIIlllIIllIll.func_179722_a();
        if (llllllllllllllIllIIIIIlllIlIIIII.isBlockLoaded(llllllllllllllIllIIIIIlllIIlllll)) {
            final TileEntity llllllllllllllIllIIIIIlllIIllllI = llllllllllllllIllIIIIIlllIlIIIII.getTileEntity(llllllllllllllIllIIIIIlllIIlllll);
            if (!(llllllllllllllIllIIIIIlllIIllllI instanceof TileEntitySign)) {
                return;
            }
            final TileEntitySign llllllllllllllIllIIIIIlllIIlllIl = (TileEntitySign)llllllllllllllIllIIIIIlllIIllllI;
            if (!llllllllllllllIllIIIIIlllIIlllIl.getIsEditable() || llllllllllllllIllIIIIIlllIIlllIl.func_145911_b() != this.playerEntity) {
                this.serverController.logWarning(String.valueOf(new StringBuilder("Player ").append(this.playerEntity.getName()).append(" just tried to change non-editable sign")));
                return;
            }
            System.arraycopy(llllllllllllllIllIIIIIlllIIllIll.func_180768_b(), 0, llllllllllllllIllIIIIIlllIIlllIl.signText, 0, 4);
            llllllllllllllIllIIIIIlllIIlllIl.markDirty();
            llllllllllllllIllIIIIIlllIlIIIII.markBlockForUpdate(llllllllllllllIllIIIIIlllIIlllll);
        }
    }
    
    static final class SwitchAction
    {
        static final /* synthetic */ int[] field_180224_a;
        static final /* synthetic */ int[] field_180222_b;
        static final /* synthetic */ int[] field_180223_c;
        
        static {
            __OBFID = "CL_00002269";
            field_180223_c = new int[C16PacketClientStatus.EnumState.values().length];
            try {
                SwitchAction.field_180223_c[C16PacketClientStatus.EnumState.PERFORM_RESPAWN.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchAction.field_180223_c[C16PacketClientStatus.EnumState.REQUEST_STATS.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchAction.field_180223_c[C16PacketClientStatus.EnumState.OPEN_INVENTORY_ACHIEVEMENT.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            field_180222_b = new int[C0BPacketEntityAction.Action.values().length];
            try {
                SwitchAction.field_180222_b[C0BPacketEntityAction.Action.START_SNEAKING.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                SwitchAction.field_180222_b[C0BPacketEntityAction.Action.STOP_SNEAKING.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                SwitchAction.field_180222_b[C0BPacketEntityAction.Action.START_SPRINTING.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
            try {
                SwitchAction.field_180222_b[C0BPacketEntityAction.Action.STOP_SPRINTING.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError7) {}
            try {
                SwitchAction.field_180222_b[C0BPacketEntityAction.Action.STOP_SLEEPING.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError8) {}
            try {
                SwitchAction.field_180222_b[C0BPacketEntityAction.Action.RIDING_JUMP.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError9) {}
            try {
                SwitchAction.field_180222_b[C0BPacketEntityAction.Action.OPEN_INVENTORY.ordinal()] = 7;
            }
            catch (NoSuchFieldError noSuchFieldError10) {}
            field_180224_a = new int[C07PacketPlayerDigging.Action.values().length];
            try {
                SwitchAction.field_180224_a[C07PacketPlayerDigging.Action.DROP_ITEM.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError11) {}
            try {
                SwitchAction.field_180224_a[C07PacketPlayerDigging.Action.DROP_ALL_ITEMS.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError12) {}
            try {
                SwitchAction.field_180224_a[C07PacketPlayerDigging.Action.RELEASE_USE_ITEM.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError13) {}
            try {
                SwitchAction.field_180224_a[C07PacketPlayerDigging.Action.START_DESTROY_BLOCK.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError14) {}
            try {
                SwitchAction.field_180224_a[C07PacketPlayerDigging.Action.ABORT_DESTROY_BLOCK.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError15) {}
            try {
                SwitchAction.field_180224_a[C07PacketPlayerDigging.Action.STOP_DESTROY_BLOCK.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError16) {}
        }
    }
}
