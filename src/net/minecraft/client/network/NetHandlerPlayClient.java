package net.minecraft.client.network;

import net.minecraft.network.play.*;
import com.mojang.authlib.*;
import net.minecraft.entity.player.*;
import net.minecraft.potion.*;
import com.google.common.util.concurrent.*;
import net.minecraft.client.resources.*;
import com.google.common.collect.*;
import net.minecraft.client.particle.*;
import net.minecraft.client.entity.*;
import net.minecraft.entity.monster.*;
import net.minecraft.client.audio.*;
import net.minecraft.client.multiplayer.*;
import io.netty.buffer.*;
import net.minecraft.network.*;
import net.minecraft.client.*;
import net.minecraft.network.play.client.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.block.*;
import net.minecraft.entity.item.*;
import net.minecraft.realms.*;
import net.minecraft.client.settings.*;
import net.minecraft.tileentity.*;
import net.minecraft.client.stream.*;
import net.minecraft.stats.*;
import net.minecraft.world.chunk.*;
import net.minecraft.entity.passive.*;
import net.minecraft.inventory.*;
import net.minecraft.world.*;
import net.minecraft.client.player.inventory.*;
import net.minecraft.entity.effect.*;
import net.minecraft.entity.*;
import net.minecraft.village.*;
import java.io.*;
import net.minecraft.init.*;
import net.minecraft.client.gui.*;
import java.util.*;
import net.minecraft.client.gui.inventory.*;
import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import net.minecraft.world.storage.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.network.play.server.*;
import net.minecraft.util.*;
import net.minecraft.scoreboard.*;
import org.apache.logging.log4j.*;

public class NetHandlerPlayClient implements INetHandlerPlayClient
{
    private final /* synthetic */ Map playerInfoMap;
    private final /* synthetic */ NetworkManager netManager;
    private static final /* synthetic */ Logger logger;
    private final /* synthetic */ GameProfile field_175107_d;
    private /* synthetic */ Minecraft gameController;
    public /* synthetic */ int currentServerMaxPlayers;
    private final /* synthetic */ Random avRandomizer;
    private /* synthetic */ boolean field_147308_k;
    private final /* synthetic */ GuiScreen guiScreenServer;
    private /* synthetic */ boolean doneLoadingTerrain;
    private /* synthetic */ WorldClient clientWorldController;
    
    @Override
    public void handleEntityTeleport(final S18PacketEntityTeleport llllllllllllllIlIllIlllllIIIllIl) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIlllllIIIllIl, this, this.gameController);
        final Entity llllllllllllllIlIllIlllllIIIllII = this.clientWorldController.getEntityByID(llllllllllllllIlIllIlllllIIIllIl.func_149451_c());
        if (llllllllllllllIlIllIlllllIIIllII != null) {
            llllllllllllllIlIllIlllllIIIllII.serverPosX = llllllllllllllIlIllIlllllIIIllIl.func_149449_d();
            llllllllllllllIlIllIlllllIIIllII.serverPosY = llllllllllllllIlIllIlllllIIIllIl.func_149448_e();
            llllllllllllllIlIllIlllllIIIllII.serverPosZ = llllllllllllllIlIllIlllllIIIllIl.func_149446_f();
            final double llllllllllllllIlIllIlllllIIIlIll = llllllllllllllIlIllIlllllIIIllII.serverPosX / 32.0;
            final double llllllllllllllIlIllIlllllIIIlIlI = llllllllllllllIlIllIlllllIIIllII.serverPosY / 32.0 + 0.015625;
            final double llllllllllllllIlIllIlllllIIIlIIl = llllllllllllllIlIllIlllllIIIllII.serverPosZ / 32.0;
            final float llllllllllllllIlIllIlllllIIIlIII = llllllllllllllIlIllIlllllIIIllIl.func_149450_g() * 360 / 256.0f;
            final float llllllllllllllIlIllIlllllIIIIlll = llllllllllllllIlIllIlllllIIIllIl.func_149447_h() * 360 / 256.0f;
            if (Math.abs(llllllllllllllIlIllIlllllIIIllII.posX - llllllllllllllIlIllIlllllIIIlIll) < 0.03125 && Math.abs(llllllllllllllIlIllIlllllIIIllII.posY - llllllllllllllIlIllIlllllIIIlIlI) < 0.015625 && Math.abs(llllllllllllllIlIllIlllllIIIllII.posZ - llllllllllllllIlIllIlllllIIIlIIl) < 0.03125) {
                llllllllllllllIlIllIlllllIIIllII.func_180426_a(llllllllllllllIlIllIlllllIIIllII.posX, llllllllllllllIlIllIlllllIIIllII.posY, llllllllllllllIlIllIlllllIIIllII.posZ, llllllllllllllIlIllIlllllIIIlIII, llllllllllllllIlIllIlllllIIIIlll, 3, true);
            }
            else {
                llllllllllllllIlIllIlllllIIIllII.func_180426_a(llllllllllllllIlIllIlllllIIIlIll, llllllllllllllIlIllIlllllIIIlIlI, llllllllllllllIlIllIlllllIIIlIIl, llllllllllllllIlIllIlllllIIIlIII, llllllllllllllIlIllIlllllIIIIlll, 3, true);
            }
            llllllllllllllIlIllIlllllIIIllII.onGround = llllllllllllllIlIllIlllllIIIllIl.func_179697_g();
        }
    }
    
    @Override
    public void handleEntityMovement(final S14PacketEntity llllllllllllllIlIllIllllIllIllll) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIllllIllIllll, this, this.gameController);
        final Entity llllllllllllllIlIllIllllIllIlllI = llllllllllllllIlIllIllllIllIllll.func_149065_a(this.clientWorldController);
        if (llllllllllllllIlIllIllllIllIlllI != null) {
            final Entity entity = llllllllllllllIlIllIllllIllIlllI;
            entity.serverPosX += llllllllllllllIlIllIllllIllIllll.func_149062_c();
            final Entity entity2 = llllllllllllllIlIllIllllIllIlllI;
            entity2.serverPosY += llllllllllllllIlIllIllllIllIllll.func_149061_d();
            final Entity entity3 = llllllllllllllIlIllIllllIllIlllI;
            entity3.serverPosZ += llllllllllllllIlIllIllllIllIllll.func_149064_e();
            final double llllllllllllllIlIllIllllIllIllIl = llllllllllllllIlIllIllllIllIlllI.serverPosX / 32.0;
            final double llllllllllllllIlIllIllllIllIllII = llllllllllllllIlIllIllllIllIlllI.serverPosY / 32.0;
            final double llllllllllllllIlIllIllllIllIlIll = llllllllllllllIlIllIllllIllIlllI.serverPosZ / 32.0;
            final float llllllllllllllIlIllIllllIllIlIlI = llllllllllllllIlIllIllllIllIllll.func_149060_h() ? (llllllllllllllIlIllIllllIllIllll.func_149066_f() * 360 / 256.0f) : llllllllllllllIlIllIllllIllIlllI.rotationYaw;
            final float llllllllllllllIlIllIllllIllIlIIl = llllllllllllllIlIllIllllIllIllll.func_149060_h() ? (llllllllllllllIlIllIllllIllIllll.func_149063_g() * 360 / 256.0f) : llllllllllllllIlIllIllllIllIlllI.rotationPitch;
            llllllllllllllIlIllIllllIllIlllI.func_180426_a(llllllllllllllIlIllIllllIllIllIl, llllllllllllllIlIllIllllIllIllII, llllllllllllllIlIllIllllIllIlIll, llllllllllllllIlIllIllllIllIlIlI, llllllllllllllIlIllIllllIllIlIIl, 3, false);
            llllllllllllllIlIllIllllIllIlllI.onGround = llllllllllllllIlIllIllllIllIllll.func_179742_g();
        }
    }
    
    @Override
    public void func_175101_a(final S41PacketServerDifficulty llllllllllllllIlIllIllIlIlIllIII) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIllIlIlIllIII, this, this.gameController);
        this.gameController.theWorld.getWorldInfo().setDifficulty(llllllllllllllIlIllIllIlIlIllIII.func_179831_b());
        this.gameController.theWorld.getWorldInfo().setDifficultyLocked(llllllllllllllIlIllIllIlIlIllIII.func_179830_a());
    }
    
    @Override
    public void handleWindowItems(final S30PacketWindowItems llllllllllllllIlIllIlllIIIIllIlI) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIlllIIIIllIlI, this, this.gameController);
        final EntityPlayerSP llllllllllllllIlIllIlllIIIIllIIl = this.gameController.thePlayer;
        if (llllllllllllllIlIllIlllIIIIllIlI.func_148911_c() == 0) {
            llllllllllllllIlIllIlllIIIIllIIl.inventoryContainer.putStacksInSlots(llllllllllllllIlIllIlllIIIIllIlI.func_148910_d());
        }
        else if (llllllllllllllIlIllIlllIIIIllIlI.func_148911_c() == llllllllllllllIlIllIlllIIIIllIIl.openContainer.windowId) {
            llllllllllllllIlIllIlllIIIIllIIl.openContainer.putStacksInSlots(llllllllllllllIlIllIlllIIIIllIlI.func_148910_d());
        }
    }
    
    @Override
    public void handleTeams(final S3EPacketTeams llllllllllllllIlIllIllIIlIIIIIIl) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIllIIlIIIIIIl, this, this.gameController);
        final Scoreboard llllllllllllllIlIllIllIIlIIIlIlI = this.clientWorldController.getScoreboard();
        ScorePlayerTeam llllllllllllllIlIllIllIIlIIIlIII = null;
        if (llllllllllllllIlIllIllIIlIIIIIIl.func_149307_h() == 0) {
            final ScorePlayerTeam llllllllllllllIlIllIllIIlIIIlIIl = llllllllllllllIlIllIllIIlIIIlIlI.createTeam(llllllllllllllIlIllIllIIlIIIIIIl.func_149312_c());
        }
        else {
            llllllllllllllIlIllIllIIlIIIlIII = llllllllllllllIlIllIllIIlIIIlIlI.getTeam(llllllllllllllIlIllIllIIlIIIIIIl.func_149312_c());
        }
        if (llllllllllllllIlIllIllIIlIIIIIIl.func_149307_h() == 0 || llllllllllllllIlIllIllIIlIIIIIIl.func_149307_h() == 2) {
            llllllllllllllIlIllIllIIlIIIlIII.setTeamName(llllllllllllllIlIllIllIIlIIIIIIl.func_149306_d());
            llllllllllllllIlIllIllIIlIIIlIII.setNamePrefix(llllllllllllllIlIllIllIIlIIIIIIl.func_149311_e());
            llllllllllllllIlIllIllIIlIIIlIII.setNameSuffix(llllllllllllllIlIllIllIIlIIIIIIl.func_149309_f());
            llllllllllllllIlIllIllIIlIIIlIII.func_178774_a(EnumChatFormatting.func_175744_a(llllllllllllllIlIllIllIIlIIIIIIl.func_179813_h()));
            llllllllllllllIlIllIllIIlIIIlIII.func_98298_a(llllllllllllllIlIllIllIIlIIIIIIl.func_149308_i());
            final Team.EnumVisible llllllllllllllIlIllIllIIlIIIIlll = Team.EnumVisible.func_178824_a(llllllllllllllIlIllIllIIlIIIIIIl.func_179814_i());
            if (llllllllllllllIlIllIllIIlIIIIlll != null) {
                llllllllllllllIlIllIllIIlIIIlIII.func_178772_a(llllllllllllllIlIllIllIIlIIIIlll);
            }
        }
        if (llllllllllllllIlIllIllIIlIIIIIIl.func_149307_h() == 0 || llllllllllllllIlIllIllIIlIIIIIIl.func_149307_h() == 3) {
            for (final String llllllllllllllIlIllIllIIlIIIIllI : llllllllllllllIlIllIllIIlIIIIIIl.func_149310_g()) {
                llllllllllllllIlIllIllIIlIIIlIlI.func_151392_a(llllllllllllllIlIllIllIIlIIIIllI, llllllllllllllIlIllIllIIlIIIIIIl.func_149312_c());
            }
        }
        if (llllllllllllllIlIllIllIIlIIIIIIl.func_149307_h() == 4) {
            for (final String llllllllllllllIlIllIllIIlIIIIlIl : llllllllllllllIlIllIllIIlIIIIIIl.func_149310_g()) {
                llllllllllllllIlIllIllIIlIIIlIlI.removePlayerFromTeam(llllllllllllllIlIllIllIIlIIIIlIl, llllllllllllllIlIllIllIIlIIIlIII);
            }
        }
        if (llllllllllllllIlIllIllIIlIIIIIIl.func_149307_h() == 1) {
            llllllllllllllIlIllIllIIlIIIlIlI.removeTeam(llllllllllllllIlIllIllIIlIIIlIII);
        }
    }
    
    @Override
    public void handleSpawnMob(final S0FPacketSpawnMob llllllllllllllIlIllIlllIllIIllll) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIlllIllIIllll, this, this.gameController);
        final double llllllllllllllIlIllIlllIllIIlllI = llllllllllllllIlIllIlllIllIIllll.func_149023_f() / 32.0;
        final double llllllllllllllIlIllIlllIllIIllIl = llllllllllllllIlIllIlllIllIIllll.func_149034_g() / 32.0;
        final double llllllllllllllIlIllIlllIllIIllII = llllllllllllllIlIllIlllIllIIllll.func_149029_h() / 32.0;
        final float llllllllllllllIlIllIlllIllIIlIll = llllllllllllllIlIllIlllIllIIllll.func_149028_l() * 360 / 256.0f;
        final float llllllllllllllIlIllIlllIllIIlIlI = llllllllllllllIlIllIlllIllIIllll.func_149030_m() * 360 / 256.0f;
        final EntityLivingBase llllllllllllllIlIllIlllIllIIlIIl = (EntityLivingBase)EntityList.createEntityByID(llllllllllllllIlIllIlllIllIIllll.func_149025_e(), this.gameController.theWorld);
        llllllllllllllIlIllIlllIllIIlIIl.serverPosX = llllllllllllllIlIllIlllIllIIllll.func_149023_f();
        llllllllllllllIlIllIlllIllIIlIIl.serverPosY = llllllllllllllIlIllIlllIllIIllll.func_149034_g();
        llllllllllllllIlIllIlllIllIIlIIl.serverPosZ = llllllllllllllIlIllIlllIllIIllll.func_149029_h();
        llllllllllllllIlIllIlllIllIIlIIl.rotationYawHead = llllllllllllllIlIllIlllIllIIllll.func_149032_n() * 360 / 256.0f;
        final Entity[] llllllllllllllIlIllIlllIllIIlIII = llllllllllllllIlIllIlllIllIIlIIl.getParts();
        if (llllllllllllllIlIllIlllIllIIlIII != null) {
            final int llllllllllllllIlIllIlllIllIIIlll = llllllllllllllIlIllIlllIllIIllll.func_149024_d() - llllllllllllllIlIllIlllIllIIlIIl.getEntityId();
            for (int llllllllllllllIlIllIlllIllIIIllI = 0; llllllllllllllIlIllIlllIllIIIllI < llllllllllllllIlIllIlllIllIIlIII.length; ++llllllllllllllIlIllIlllIllIIIllI) {
                llllllllllllllIlIllIlllIllIIlIII[llllllllllllllIlIllIlllIllIIIllI].setEntityId(llllllllllllllIlIllIlllIllIIlIII[llllllllllllllIlIllIlllIllIIIllI].getEntityId() + llllllllllllllIlIllIlllIllIIIlll);
            }
        }
        llllllllllllllIlIllIlllIllIIlIIl.setEntityId(llllllllllllllIlIllIlllIllIIllll.func_149024_d());
        llllllllllllllIlIllIlllIllIIlIIl.setPositionAndRotation(llllllllllllllIlIllIlllIllIIlllI, llllllllllllllIlIllIlllIllIIllIl, llllllllllllllIlIllIlllIllIIllII, llllllllllllllIlIllIlllIllIIlIll, llllllllllllllIlIllIlllIllIIlIlI);
        llllllllllllllIlIllIlllIllIIlIIl.motionX = llllllllllllllIlIllIlllIllIIllll.func_149026_i() / 8000.0f;
        llllllllllllllIlIllIlllIllIIlIIl.motionY = llllllllllllllIlIllIlllIllIIllll.func_149033_j() / 8000.0f;
        llllllllllllllIlIllIlllIllIIlIIl.motionZ = llllllllllllllIlIllIlllIllIIllll.func_149031_k() / 8000.0f;
        this.clientWorldController.addEntityToWorld(llllllllllllllIlIllIlllIllIIllll.func_149024_d(), llllllllllllllIlIllIlllIllIIlIIl);
        final List llllllllllllllIlIllIlllIllIIIlIl = llllllllllllllIlIllIlllIllIIllll.func_149027_c();
        if (llllllllllllllIlIllIlllIllIIIlIl != null) {
            llllllllllllllIlIllIlllIllIIlIIl.getDataWatcher().updateWatchedObjectsFromList(llllllllllllllIlIllIlllIllIIIlIl);
        }
    }
    
    @Override
    public void handleHeldItemChange(final S09PacketHeldItemChange llllllllllllllIlIllIllllIllllIIl) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIllllIllllIIl, this, this.gameController);
        if (llllllllllllllIlIllIllllIllllIIl.func_149385_c() >= 0 && llllllllllllllIlIllIllllIllllIIl.func_149385_c() < InventoryPlayer.getHotbarSize()) {
            this.gameController.thePlayer.inventory.currentItem = llllllllllllllIlIllIllllIllllIIl.func_149385_c();
        }
    }
    
    @Override
    public void handleConfirmTransaction(final S32PacketConfirmTransaction llllllllllllllIlIllIlllIIIlIIIIl) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIlllIIIlIIIIl, this, this.gameController);
        Container llllllllllllllIlIllIlllIIIlIIlII = null;
        final EntityPlayerSP llllllllllllllIlIllIlllIIIlIIIll = this.gameController.thePlayer;
        if (llllllllllllllIlIllIlllIIIlIIIIl.func_148889_c() == 0) {
            llllllllllllllIlIllIlllIIIlIIlII = llllllllllllllIlIllIlllIIIlIIIll.inventoryContainer;
        }
        else if (llllllllllllllIlIllIlllIIIlIIIIl.func_148889_c() == llllllllllllllIlIllIlllIIIlIIIll.openContainer.windowId) {
            llllllllllllllIlIllIlllIIIlIIlII = llllllllllllllIlIllIlllIIIlIIIll.openContainer;
        }
        if (llllllllllllllIlIllIlllIIIlIIlII != null && !llllllllllllllIlIllIlllIIIlIIIIl.func_148888_e()) {
            this.addToSendQueue(new C0FPacketConfirmTransaction(llllllllllllllIlIllIlllIIIlIIIIl.func_148889_c(), llllllllllllllIlIllIlllIIIlIIIIl.func_148890_d(), true));
        }
    }
    
    @Override
    public void handleBlockAction(final S24PacketBlockAction llllllllllllllIlIllIllIlllIlIllI) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIllIlllIlIllI, this, this.gameController);
        this.gameController.theWorld.addBlockEvent(llllllllllllllIlIllIllIlllIlIllI.func_179825_a(), llllllllllllllIlIllIllIlllIlIllI.getBlockType(), llllllllllllllIlIllIllIlllIlIllI.getData1(), llllllllllllllIlIllIllIlllIlIllI.getData2());
    }
    
    @Override
    public void func_175098_a(final S42PacketCombatEvent llllllllllllllIlIllIllIlIllIlIll) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIllIlIllIlIll, this, this.gameController);
        final Entity llllllllllllllIlIllIllIlIllIlIlI = this.clientWorldController.getEntityByID(llllllllllllllIlIllIllIlIllIlIll.field_179775_c);
        final EntityLivingBase llllllllllllllIlIllIllIlIllIlIIl = (llllllllllllllIlIllIllIlIllIlIlI instanceof EntityLivingBase) ? ((EntityLivingBase)llllllllllllllIlIllIllIlIllIlIlI) : null;
        if (llllllllllllllIlIllIllIlIllIlIll.field_179776_a == S42PacketCombatEvent.Event.END_COMBAT) {
            final long llllllllllllllIlIllIllIlIllIlIII = 1000 * llllllllllllllIlIllIllIlIllIlIll.field_179772_d / 20;
            final MetadataCombat llllllllllllllIlIllIllIlIllIIlll = new MetadataCombat(this.gameController.thePlayer, llllllllllllllIlIllIllIlIllIlIIl);
            this.gameController.getTwitchStream().func_176026_a(llllllllllllllIlIllIllIlIllIIlll, 0L - llllllllllllllIlIllIllIlIllIlIII, 0L);
        }
        else if (llllllllllllllIlIllIllIlIllIlIll.field_179776_a == S42PacketCombatEvent.Event.ENTITY_DIED) {
            final Entity llllllllllllllIlIllIllIlIllIIllI = this.clientWorldController.getEntityByID(llllllllllllllIlIllIllIlIllIlIll.field_179774_b);
            if (llllllllllllllIlIllIllIlIllIIllI instanceof EntityPlayer) {
                final MetadataPlayerDeath llllllllllllllIlIllIllIlIllIIlIl = new MetadataPlayerDeath((EntityLivingBase)llllllllllllllIlIllIllIlIllIIllI, llllllllllllllIlIllIllIlIllIlIIl);
                llllllllllllllIlIllIllIlIllIIlIl.func_152807_a(llllllllllllllIlIllIllIlIllIlIll.field_179773_e);
                this.gameController.getTwitchStream().func_152911_a(llllllllllllllIlIllIllIlIllIIlIl, 0L);
            }
        }
    }
    
    @Override
    public void handleEntityEffect(final S1DPacketEntityEffect llllllllllllllIlIllIllIlIlllIllI) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIllIlIlllIllI, this, this.gameController);
        final Entity llllllllllllllIlIllIllIlIllllIIl = this.clientWorldController.getEntityByID(llllllllllllllIlIllIllIlIlllIllI.func_149426_d());
        if (llllllllllllllIlIllIllIlIllllIIl instanceof EntityLivingBase) {
            final PotionEffect llllllllllllllIlIllIllIlIllllIII = new PotionEffect(llllllllllllllIlIllIllIlIlllIllI.func_149427_e(), llllllllllllllIlIllIllIlIlllIllI.func_180755_e(), llllllllllllllIlIllIllIlIlllIllI.func_149428_f(), false, llllllllllllllIlIllIllIlIlllIllI.func_179707_f());
            llllllllllllllIlIllIllIlIllllIII.setPotionDurationMax(llllllllllllllIlIllIllIlIlllIllI.func_149429_c());
            ((EntityLivingBase)llllllllllllllIlIllIllIlIllllIIl).addPotionEffect(llllllllllllllIlIllIllIlIllllIII);
        }
    }
    
    @Override
    public void func_175094_a(final S43PacketCamera llllllllllllllIlIllIllIlIlIlIIII) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIllIlIlIlIIII, this, this.gameController);
        final Entity llllllllllllllIlIllIllIlIlIlIIlI = llllllllllllllIlIllIllIlIlIlIIII.func_179780_a(this.clientWorldController);
        if (llllllllllllllIlIllIllIlIlIlIIlI != null) {
            this.gameController.func_175607_a(llllllllllllllIlIllIllIlIlIlIIlI);
        }
    }
    
    @Override
    public void func_175095_a(final S48PacketResourcePackSend llllllllllllllIlIllIllIIlllIlIIl) {
        final String llllllllllllllIlIllIllIIlllIlIII = llllllllllllllIlIllIllIIlllIlIIl.func_179783_a();
        final String llllllllllllllIlIllIllIIlllIIlll = llllllllllllllIlIllIllIIlllIlIIl.func_179784_b();
        if (llllllllllllllIlIllIllIIlllIlIII.startsWith("level://")) {
            final String llllllllllllllIlIllIllIIlllIIllI = llllllllllllllIlIllIllIIlllIlIII.substring("level://".length());
            final File llllllllllllllIlIllIllIIlllIIlIl = new File(this.gameController.mcDataDir, "saves");
            final File llllllllllllllIlIllIllIIlllIIlII = new File(llllllllllllllIlIllIllIIlllIIlIl, llllllllllllllIlIllIllIIlllIIllI);
            if (llllllllllllllIlIllIllIIlllIIlII.isFile()) {
                this.netManager.sendPacket(new C19PacketResourcePackStatus(llllllllllllllIlIllIllIIlllIIlll, C19PacketResourcePackStatus.Action.ACCEPTED));
                Futures.addCallback(this.gameController.getResourcePackRepository().func_177319_a(llllllllllllllIlIllIllIIlllIIlII), (FutureCallback)new FutureCallback() {
                    static {
                        __OBFID = "CL_00000879";
                    }
                    
                    public void onSuccess(final Object lllllllllllllllllllIIIlllIIIIlII) {
                        NetHandlerPlayClient.this.netManager.sendPacket(new C19PacketResourcePackStatus(llllllllllllllIlIllIllIIlllIIlll, C19PacketResourcePackStatus.Action.SUCCESSFULLY_LOADED));
                    }
                    
                    public void onFailure(final Throwable lllllllllllllllllllIIIlllIIIIIII) {
                        NetHandlerPlayClient.this.netManager.sendPacket(new C19PacketResourcePackStatus(llllllllllllllIlIllIllIIlllIIlll, C19PacketResourcePackStatus.Action.FAILED_DOWNLOAD));
                    }
                });
            }
            else {
                this.netManager.sendPacket(new C19PacketResourcePackStatus(llllllllllllllIlIllIllIIlllIIlll, C19PacketResourcePackStatus.Action.FAILED_DOWNLOAD));
            }
        }
        else if (this.gameController.getCurrentServerData() != null && this.gameController.getCurrentServerData().getResourceMode() == ServerData.ServerResourceMode.ENABLED) {
            this.netManager.sendPacket(new C19PacketResourcePackStatus(llllllllllllllIlIllIllIIlllIIlll, C19PacketResourcePackStatus.Action.ACCEPTED));
            Futures.addCallback(this.gameController.getResourcePackRepository().func_180601_a(llllllllllllllIlIllIllIIlllIlIII, llllllllllllllIlIllIllIIlllIIlll), (FutureCallback)new FutureCallback() {
                static {
                    __OBFID = "CL_00002624";
                }
                
                public void onFailure(final Throwable lllllllllllllllIIIlIIIlIIIllIllI) {
                    NetHandlerPlayClient.this.netManager.sendPacket(new C19PacketResourcePackStatus(llllllllllllllIlIllIllIIlllIIlll, C19PacketResourcePackStatus.Action.FAILED_DOWNLOAD));
                }
                
                public void onSuccess(final Object lllllllllllllllIIIlIIIlIIIlllIlI) {
                    NetHandlerPlayClient.this.netManager.sendPacket(new C19PacketResourcePackStatus(llllllllllllllIlIllIllIIlllIIlll, C19PacketResourcePackStatus.Action.SUCCESSFULLY_LOADED));
                }
            });
        }
        else if (this.gameController.getCurrentServerData() != null && this.gameController.getCurrentServerData().getResourceMode() != ServerData.ServerResourceMode.PROMPT) {
            this.netManager.sendPacket(new C19PacketResourcePackStatus(llllllllllllllIlIllIllIIlllIIlll, C19PacketResourcePackStatus.Action.DECLINED));
        }
        else {
            this.gameController.addScheduledTask(new Runnable() {
                @Override
                public void run() {
                    NetHandlerPlayClient.this.gameController.displayGuiScreen(new GuiYesNo(new GuiYesNoCallback() {
                        @Override
                        public void confirmClicked(final boolean llllllllllllllIllllIIIIIIIlIlIII, final int llllllllllllllIllllIIIIIIIlIlIlI) {
                            NetHandlerPlayClient.access$2(NetHandlerPlayClient.this, Minecraft.getMinecraft());
                            if (llllllllllllllIllllIIIIIIIlIlIII) {
                                if (NetHandlerPlayClient.this.gameController.getCurrentServerData() != null) {
                                    NetHandlerPlayClient.this.gameController.getCurrentServerData().setResourceMode(ServerData.ServerResourceMode.ENABLED);
                                }
                                NetHandlerPlayClient.this.netManager.sendPacket(new C19PacketResourcePackStatus(llllllllllllllIlIllIllIIlllIIlll, C19PacketResourcePackStatus.Action.ACCEPTED));
                                Futures.addCallback(NetHandlerPlayClient.this.gameController.getResourcePackRepository().func_180601_a(llllllllllllllIlIllIllIIlllIlIII, llllllllllllllIlIllIllIIlllIIlll), (FutureCallback)new FutureCallback() {
                                    public void onFailure(final Throwable llllllllllllllIIllIIIIIlIlIIIIll) {
                                        NetHandlerPlayClient.this.netManager.sendPacket(new C19PacketResourcePackStatus(llllllllllllllIlIllIllIIlllIIlll, C19PacketResourcePackStatus.Action.FAILED_DOWNLOAD));
                                    }
                                    
                                    static {
                                        __OBFID = "CL_00002621";
                                    }
                                    
                                    public void onSuccess(final Object llllllllllllllIIllIIIIIlIlIIIlll) {
                                        NetHandlerPlayClient.this.netManager.sendPacket(new C19PacketResourcePackStatus(llllllllllllllIlIllIllIIlllIIlll, C19PacketResourcePackStatus.Action.SUCCESSFULLY_LOADED));
                                    }
                                });
                            }
                            else {
                                if (NetHandlerPlayClient.this.gameController.getCurrentServerData() != null) {
                                    NetHandlerPlayClient.this.gameController.getCurrentServerData().setResourceMode(ServerData.ServerResourceMode.DISABLED);
                                }
                                NetHandlerPlayClient.this.netManager.sendPacket(new C19PacketResourcePackStatus(llllllllllllllIlIllIllIIlllIIlll, C19PacketResourcePackStatus.Action.DECLINED));
                            }
                            ServerList.func_147414_b(NetHandlerPlayClient.this.gameController.getCurrentServerData());
                            NetHandlerPlayClient.this.gameController.displayGuiScreen(null);
                        }
                        
                        static {
                            __OBFID = "CL_00002622";
                        }
                    }, I18n.format("multiplayer.texturePrompt.line1", new Object[0]), I18n.format("multiplayer.texturePrompt.line2", new Object[0]), 0));
                }
                
                static {
                    __OBFID = "CL_00002623";
                }
            });
        }
    }
    
    @Override
    public void handleSpawnPainting(final S10PacketSpawnPainting llllllllllllllIlIllIllllllIIlIll) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIllllllIIlIll, this, this.gameController);
        final EntityPainting llllllllllllllIlIllIllllllIIlIlI = new EntityPainting(this.clientWorldController, llllllllllllllIlIllIllllllIIlIll.func_179837_b(), llllllllllllllIlIllIllllllIIlIll.func_179836_c(), llllllllllllllIlIllIllllllIIlIll.func_148961_h());
        this.clientWorldController.addEntityToWorld(llllllllllllllIlIllIllllllIIlIll.func_148965_c(), llllllllllllllIlIllIllllllIIlIlI);
    }
    
    @Override
    public void handleUpdateHealth(final S06PacketUpdateHealth llllllllllllllIlIllIlllIlIIIIIIl) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIlllIlIIIIIIl, this, this.gameController);
        this.gameController.thePlayer.setPlayerSPHealth(llllllllllllllIlIllIlllIlIIIIIIl.getHealth());
        this.gameController.thePlayer.getFoodStats().setFoodLevel(llllllllllllllIlIllIlllIlIIIIIIl.getFoodLevel());
        this.gameController.thePlayer.getFoodStats().setFoodSaturationLevel(llllllllllllllIlIllIlllIlIIIIIIl.getSaturationLevel());
    }
    
    public void cleanup() {
        this.clientWorldController = null;
    }
    
    public void addToSendQueue(final Packet llllllllllllllIlIllIllllIIIIIIIl) {
        this.netManager.sendPacket(llllllllllllllIlIllIllllIIIIIIIl);
    }
    
    public NetHandlerPlayClient(final Minecraft llllllllllllllIlIlllIIIIIIIlIlII, final GuiScreen llllllllllllllIlIlllIIIIIIIllIII, final NetworkManager llllllllllllllIlIlllIIIIIIIlIlll, final GameProfile llllllllllllllIlIlllIIIIIIIlIllI) {
        this.playerInfoMap = Maps.newHashMap();
        this.currentServerMaxPlayers = 20;
        this.field_147308_k = false;
        this.avRandomizer = new Random();
        this.gameController = llllllllllllllIlIlllIIIIIIIlIlII;
        this.guiScreenServer = llllllllllllllIlIlllIIIIIIIllIII;
        this.netManager = llllllllllllllIlIlllIIIIIIIlIlll;
        this.field_175107_d = llllllllllllllIlIlllIIIIIIIlIllI;
    }
    
    @Override
    public void handleCloseWindow(final S2EPacketCloseWindow llllllllllllllIlIllIllIlllIlllII) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIllIlllIlllII, this, this.gameController);
        this.gameController.thePlayer.func_175159_q();
    }
    
    @Override
    public void handleBlockBreakAnim(final S25PacketBlockBreakAnim llllllllllllllIlIllIllIlllIlIIII) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIllIlllIlIIII, this, this.gameController);
        this.gameController.theWorld.sendBlockBreakProgress(llllllllllllllIlIllIllIlllIlIIII.func_148845_c(), llllllllllllllIlIllIllIlllIlIIII.func_179821_b(), llllllllllllllIlIllIllIlllIlIIII.func_148846_g());
    }
    
    @Override
    public void handleScoreboardObjective(final S3BPacketScoreboardObjective llllllllllllllIlIllIllIIlIllIlIl) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIllIIlIllIlIl, this, this.gameController);
        final Scoreboard llllllllllllllIlIllIllIIlIllIlII = this.clientWorldController.getScoreboard();
        if (llllllllllllllIlIllIllIIlIllIlIl.func_149338_e() == 0) {
            final ScoreObjective llllllllllllllIlIllIllIIlIllIIll = llllllllllllllIlIllIllIIlIllIlII.addScoreObjective(llllllllllllllIlIllIllIIlIllIlIl.func_149339_c(), IScoreObjectiveCriteria.DUMMY);
            llllllllllllllIlIllIllIIlIllIIll.setDisplayName(llllllllllllllIlIllIllIIlIllIlIl.func_149337_d());
            llllllllllllllIlIllIllIIlIllIIll.func_178767_a(llllllllllllllIlIllIllIIlIllIlIl.func_179817_d());
        }
        else {
            final ScoreObjective llllllllllllllIlIllIllIIlIllIIlI = llllllllllllllIlIllIllIIlIllIlII.getObjective(llllllllllllllIlIllIllIIlIllIlIl.func_149339_c());
            if (llllllllllllllIlIllIllIIlIllIlIl.func_149338_e() == 1) {
                llllllllllllllIlIllIllIIlIllIlII.func_96519_k(llllllllllllllIlIllIllIIlIllIIlI);
            }
            else if (llllllllllllllIlIllIllIIlIllIlIl.func_149338_e() == 2) {
                llllllllllllllIlIllIllIIlIllIIlI.setDisplayName(llllllllllllllIlIllIllIIlIllIlIl.func_149337_d());
                llllllllllllllIlIllIllIIlIllIIlI.func_178767_a(llllllllllllllIlIllIllIIlIllIlIl.func_179817_d());
            }
        }
    }
    
    @Override
    public void handlePlayerListItem(final S38PacketPlayerListItem llllllllllllllIlIllIllIlIIIllIll) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIllIlIIIllIll, this, this.gameController);
        for (final S38PacketPlayerListItem.AddPlayerData llllllllllllllIlIllIllIlIIIllIIl : llllllllllllllIlIllIllIlIIIllIll.func_179767_a()) {
            if (llllllllllllllIlIllIllIlIIIllIll.func_179768_b() == S38PacketPlayerListItem.Action.REMOVE_PLAYER) {
                this.playerInfoMap.remove(llllllllllllllIlIllIllIlIIIllIIl.func_179962_a().getId());
            }
            else {
                NetworkPlayerInfo llllllllllllllIlIllIllIlIIIllIII = this.playerInfoMap.get(llllllllllllllIlIllIllIlIIIllIIl.func_179962_a().getId());
                if (llllllllllllllIlIllIllIlIIIllIll.func_179768_b() == S38PacketPlayerListItem.Action.ADD_PLAYER) {
                    llllllllllllllIlIllIllIlIIIllIII = new NetworkPlayerInfo(llllllllllllllIlIllIllIlIIIllIIl);
                    this.playerInfoMap.put(llllllllllllllIlIllIllIlIIIllIII.func_178845_a().getId(), llllllllllllllIlIllIllIlIIIllIII);
                }
                if (llllllllllllllIlIllIllIlIIIllIII == null) {
                    continue;
                }
                switch (SwitchAction.field_178884_b[llllllllllllllIlIllIllIlIIIllIll.func_179768_b().ordinal()]) {
                    default: {
                        continue;
                    }
                    case 1: {
                        llllllllllllllIlIllIllIlIIIllIII.func_178839_a(llllllllllllllIlIllIllIlIIIllIIl.func_179960_c());
                        llllllllllllllIlIllIllIlIIIllIII.func_178838_a(llllllllllllllIlIllIllIlIIIllIIl.func_179963_b());
                        continue;
                    }
                    case 2: {
                        llllllllllllllIlIllIllIlIIIllIII.func_178839_a(llllllllllllllIlIllIllIlIIIllIIl.func_179960_c());
                        continue;
                    }
                    case 3: {
                        llllllllllllllIlIllIllIlIIIllIII.func_178838_a(llllllllllllllIlIllIllIlIIIllIIl.func_179963_b());
                        continue;
                    }
                    case 4: {
                        llllllllllllllIlIllIllIlIIIllIII.func_178859_a(llllllllllllllIlIllIllIlIIIllIIl.func_179961_d());
                        continue;
                    }
                }
            }
        }
    }
    
    @Override
    public void handleCollectItem(final S0DPacketCollectItem llllllllllllllIlIllIlllIllllIlll) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIlllIllllIlll, this, this.gameController);
        final Entity llllllllllllllIlIllIlllIlllllIlI = this.clientWorldController.getEntityByID(llllllllllllllIlIllIlllIllllIlll.func_149354_c());
        Object llllllllllllllIlIllIlllIlllllIIl = this.clientWorldController.getEntityByID(llllllllllllllIlIllIlllIllllIlll.func_149353_d());
        if (llllllllllllllIlIllIlllIlllllIIl == null) {
            llllllllllllllIlIllIlllIlllllIIl = this.gameController.thePlayer;
        }
        if (llllllllllllllIlIllIlllIlllllIlI != null) {
            if (llllllllllllllIlIllIlllIlllllIlI instanceof EntityXPOrb) {
                this.clientWorldController.playSoundAtEntity(llllllllllllllIlIllIlllIlllllIlI, "random.orb", 0.2f, ((this.avRandomizer.nextFloat() - this.avRandomizer.nextFloat()) * 0.7f + 1.0f) * 2.0f);
            }
            else {
                this.clientWorldController.playSoundAtEntity(llllllllllllllIlIllIlllIlllllIlI, "random.pop", 0.2f, ((this.avRandomizer.nextFloat() - this.avRandomizer.nextFloat()) * 0.7f + 1.0f) * 2.0f);
            }
            this.gameController.effectRenderer.addEffect(new EntityPickupFX(this.clientWorldController, llllllllllllllIlIllIlllIlllllIlI, (Entity)llllllllllllllIlIllIlllIlllllIIl, 0.5f));
            this.clientWorldController.removeEntityFromWorld(llllllllllllllIlIllIlllIllllIlll.func_149354_c());
        }
    }
    
    @Override
    public void handleSpawnPlayer(final S0CPacketSpawnPlayer llllllllllllllIlIllIlllllIlIlIIl) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIlllllIlIlIIl, this, this.gameController);
        final double llllllllllllllIlIllIlllllIlIlIII = llllllllllllllIlIllIlllllIlIlIIl.func_148942_f() / 32.0;
        final double llllllllllllllIlIllIlllllIlIIlll = llllllllllllllIlIllIlllllIlIlIIl.func_148949_g() / 32.0;
        final double llllllllllllllIlIllIlllllIlIIllI = llllllllllllllIlIllIlllllIlIlIIl.func_148946_h() / 32.0;
        final float llllllllllllllIlIllIlllllIlIIlIl = llllllllllllllIlIllIlllllIlIlIIl.func_148941_i() * 360 / 256.0f;
        final float llllllllllllllIlIllIlllllIlIIlII = llllllllllllllIlIllIlllllIlIlIIl.func_148945_j() * 360 / 256.0f;
        final EntityOtherPlayerMP entityOtherPlayerMP3;
        final EntityOtherPlayerMP entityOtherPlayerMP2;
        final EntityOtherPlayerMP entityOtherPlayerMP;
        final EntityOtherPlayerMP llllllllllllllIlIllIlllllIlIIIll = entityOtherPlayerMP = (entityOtherPlayerMP2 = (entityOtherPlayerMP3 = new EntityOtherPlayerMP(this.gameController.theWorld, this.func_175102_a(llllllllllllllIlIllIlllllIlIlIIl.func_179819_c()).func_178845_a())));
        final int func_148942_f = llllllllllllllIlIllIlllllIlIlIIl.func_148942_f();
        entityOtherPlayerMP.serverPosX = func_148942_f;
        final double n = func_148942_f;
        entityOtherPlayerMP2.lastTickPosX = n;
        entityOtherPlayerMP3.prevPosX = n;
        final EntityOtherPlayerMP entityOtherPlayerMP4 = llllllllllllllIlIllIlllllIlIIIll;
        final EntityOtherPlayerMP entityOtherPlayerMP5 = llllllllllllllIlIllIlllllIlIIIll;
        final EntityOtherPlayerMP entityOtherPlayerMP6 = llllllllllllllIlIllIlllllIlIIIll;
        final int func_148949_g = llllllllllllllIlIllIlllllIlIlIIl.func_148949_g();
        entityOtherPlayerMP6.serverPosY = func_148949_g;
        final double n2 = func_148949_g;
        entityOtherPlayerMP5.lastTickPosY = n2;
        entityOtherPlayerMP4.prevPosY = n2;
        final EntityOtherPlayerMP entityOtherPlayerMP7 = llllllllllllllIlIllIlllllIlIIIll;
        final EntityOtherPlayerMP entityOtherPlayerMP8 = llllllllllllllIlIllIlllllIlIIIll;
        final EntityOtherPlayerMP entityOtherPlayerMP9 = llllllllllllllIlIllIlllllIlIIIll;
        final int func_148946_h = llllllllllllllIlIllIlllllIlIlIIl.func_148946_h();
        entityOtherPlayerMP9.serverPosZ = func_148946_h;
        final double n3 = func_148946_h;
        entityOtherPlayerMP8.lastTickPosZ = n3;
        entityOtherPlayerMP7.prevPosZ = n3;
        final int llllllllllllllIlIllIlllllIlIIIlI = llllllllllllllIlIllIlllllIlIlIIl.func_148947_k();
        if (llllllllllllllIlIllIlllllIlIIIlI == 0) {
            llllllllllllllIlIllIlllllIlIIIll.inventory.mainInventory[llllllllllllllIlIllIlllllIlIIIll.inventory.currentItem] = null;
        }
        else {
            llllllllllllllIlIllIlllllIlIIIll.inventory.mainInventory[llllllllllllllIlIllIlllllIlIIIll.inventory.currentItem] = new ItemStack(Item.getItemById(llllllllllllllIlIllIlllllIlIIIlI), 1, 0);
        }
        llllllllllllllIlIllIlllllIlIIIll.setPositionAndRotation(llllllllllllllIlIllIlllllIlIlIII, llllllllllllllIlIllIlllllIlIIlll, llllllllllllllIlIllIlllllIlIIllI, llllllllllllllIlIllIlllllIlIIlIl, llllllllllllllIlIllIlllllIlIIlII);
        this.clientWorldController.addEntityToWorld(llllllllllllllIlIllIlllllIlIlIIl.func_148943_d(), llllllllllllllIlIllIlllllIlIIIll);
        final List llllllllllllllIlIllIlllllIlIIIIl = llllllllllllllIlIllIlllllIlIlIIl.func_148944_c();
        if (llllllllllllllIlIllIlllllIlIIIIl != null) {
            llllllllllllllIlIllIlllllIlIIIll.getDataWatcher().updateWatchedObjectsFromList(llllllllllllllIlIllIlllllIlIIIIl);
        }
    }
    
    public NetworkPlayerInfo func_175102_a(final UUID llllllllllllllIlIllIllIIIIlIlllI) {
        return this.playerInfoMap.get(llllllllllllllIlIllIllIIIIlIlllI);
    }
    
    @Override
    public void handleKeepAlive(final S00PacketKeepAlive llllllllllllllIlIllIllIlIIIIllll) {
        this.addToSendQueue(new C00PacketKeepAlive(llllllllllllllIlIllIllIlIIIIllll.func_149134_c()));
    }
    
    @Override
    public void handleDisplayScoreboard(final S3DPacketDisplayScoreboard llllllllllllllIlIllIllIIlIIlIlIl) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIllIIlIIlIlIl, this, this.gameController);
        final Scoreboard llllllllllllllIlIllIllIIlIIllIII = this.clientWorldController.getScoreboard();
        if (llllllllllllllIlIllIllIIlIIlIlIl.func_149370_d().length() == 0) {
            llllllllllllllIlIllIllIIlIIllIII.setObjectiveInDisplaySlot(llllllllllllllIlIllIllIIlIIlIlIl.func_149371_c(), null);
        }
        else {
            final ScoreObjective llllllllllllllIlIllIllIIlIIlIlll = llllllllllllllIlIllIllIIlIIllIII.getObjective(llllllllllllllIlIllIllIIlIIlIlIl.func_149370_d());
            llllllllllllllIlIllIllIIlIIllIII.setObjectiveInDisplaySlot(llllllllllllllIlIllIllIIlIIlIlIl.func_149371_c(), llllllllllllllIlIllIllIIlIIlIlll);
        }
    }
    
    @Override
    public void handleEntityStatus(final S19PacketEntityStatus llllllllllllllIlIllIlllIlIIlIIIl) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIlllIlIIlIIIl, this, this.gameController);
        final Entity llllllllllllllIlIllIlllIlIIlIIII = llllllllllllllIlIllIlllIlIIlIIIl.func_149161_a(this.clientWorldController);
        if (llllllllllllllIlIllIlllIlIIlIIII != null) {
            if (llllllllllllllIlIllIlllIlIIlIIIl.func_149160_c() == 21) {
                this.gameController.getSoundHandler().playSound(new GuardianSound((EntityGuardian)llllllllllllllIlIllIlllIlIIlIIII));
            }
            else {
                llllllllllllllIlIllIlllIlIIlIIII.handleHealthUpdate(llllllllllllllIlIllIlllIlIIlIIIl.func_149160_c());
            }
        }
    }
    
    @Override
    public void handleRemoveEntityEffect(final S1EPacketRemoveEntityEffect llllllllllllllIlIllIllIlIIlIIIll) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIllIlIIlIIIll, this, this.gameController);
        final Entity llllllllllllllIlIllIllIlIIlIIlIl = this.clientWorldController.getEntityByID(llllllllllllllIlIllIllIlIIlIIIll.func_149076_c());
        if (llllllllllllllIlIllIllIlIIlIIlIl instanceof EntityLivingBase) {
            ((EntityLivingBase)llllllllllllllIlIllIllIlIIlIIlIl).removePotionEffectClient(llllllllllllllIlIllIllIlIIlIIIll.func_149075_d());
        }
    }
    
    @Override
    public void handleEntityMetadata(final S1CPacketEntityMetadata llllllllllllllIlIllIlllllIlllIIl) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIlllllIlllIIl, this, this.gameController);
        final Entity llllllllllllllIlIllIlllllIlllIII = this.clientWorldController.getEntityByID(llllllllllllllIlIllIlllllIlllIIl.func_149375_d());
        if (llllllllllllllIlIllIlllllIlllIII != null && llllllllllllllIlIllIlllllIlllIIl.func_149376_c() != null) {
            llllllllllllllIlIllIlllllIlllIII.getDataWatcher().updateWatchedObjectsFromList(llllllllllllllIlIllIlllllIlllIIl.func_149376_c());
        }
    }
    
    public NetworkManager getNetworkManager() {
        return this.netManager;
    }
    
    @Override
    public void handlePlayerPosLook(final S08PacketPlayerPosLook llllllllllllllIlIllIllllIlIIIIlI) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIllllIlIIIIlI, this, this.gameController);
        final EntityPlayerSP llllllllllllllIlIllIllllIlIIIIIl = this.gameController.thePlayer;
        double llllllllllllllIlIllIllllIlIIIIII = llllllllllllllIlIllIllllIlIIIIlI.func_148932_c();
        double llllllllllllllIlIllIllllIIllllll = llllllllllllllIlIllIllllIlIIIIlI.func_148928_d();
        double llllllllllllllIlIllIllllIIlllllI = llllllllllllllIlIllIllllIlIIIIlI.func_148933_e();
        float llllllllllllllIlIllIllllIIllllIl = llllllllllllllIlIllIllllIlIIIIlI.func_148931_f();
        float llllllllllllllIlIllIllllIIllllII = llllllllllllllIlIllIllllIlIIIIlI.func_148930_g();
        if (llllllllllllllIlIllIllllIlIIIIlI.func_179834_f().contains(S08PacketPlayerPosLook.EnumFlags.X)) {
            llllllllllllllIlIllIllllIlIIIIII += llllllllllllllIlIllIllllIlIIIIIl.posX;
        }
        else {
            llllllllllllllIlIllIllllIlIIIIIl.motionX = 0.0;
        }
        if (llllllllllllllIlIllIllllIlIIIIlI.func_179834_f().contains(S08PacketPlayerPosLook.EnumFlags.Y)) {
            llllllllllllllIlIllIllllIIllllll += llllllllllllllIlIllIllllIlIIIIIl.posY;
        }
        else {
            llllllllllllllIlIllIllllIlIIIIIl.motionY = 0.0;
        }
        if (llllllllllllllIlIllIllllIlIIIIlI.func_179834_f().contains(S08PacketPlayerPosLook.EnumFlags.Z)) {
            llllllllllllllIlIllIllllIIlllllI += llllllllllllllIlIllIllllIlIIIIIl.posZ;
        }
        else {
            llllllllllllllIlIllIllllIlIIIIIl.motionZ = 0.0;
        }
        if (llllllllllllllIlIllIllllIlIIIIlI.func_179834_f().contains(S08PacketPlayerPosLook.EnumFlags.X_ROT)) {
            llllllllllllllIlIllIllllIIllllII += llllllllllllllIlIllIllllIlIIIIIl.rotationPitch;
        }
        if (llllllllllllllIlIllIllllIlIIIIlI.func_179834_f().contains(S08PacketPlayerPosLook.EnumFlags.Y_ROT)) {
            llllllllllllllIlIllIllllIIllllIl += llllllllllllllIlIllIllllIlIIIIIl.rotationYaw;
        }
        llllllllllllllIlIllIllllIlIIIIIl.setPositionAndRotation(llllllllllllllIlIllIllllIlIIIIII, llllllllllllllIlIllIllllIIllllll, llllllllllllllIlIllIllllIIlllllI, llllllllllllllIlIllIllllIIllllIl, llllllllllllllIlIllIllllIIllllII);
        this.netManager.sendPacket(new C03PacketPlayer.C06PacketPlayerPosLook(llllllllllllllIlIllIllllIlIIIIIl.posX, llllllllllllllIlIllIllllIlIIIIIl.getEntityBoundingBox().minY, llllllllllllllIlIllIllllIlIIIIIl.posZ, llllllllllllllIlIllIllllIlIIIIIl.rotationYaw, llllllllllllllIlIllIllllIlIIIIIl.rotationPitch, false));
        if (!this.doneLoadingTerrain) {
            this.gameController.thePlayer.prevPosX = this.gameController.thePlayer.posX;
            this.gameController.thePlayer.prevPosY = this.gameController.thePlayer.posY;
            this.gameController.thePlayer.prevPosZ = this.gameController.thePlayer.posZ;
            this.doneLoadingTerrain = true;
            this.gameController.displayGuiScreen(null);
        }
    }
    
    @Override
    public void func_175099_a(final S45PacketTitle llllllllllllllIlIllIllIlIlIIIIIl) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIllIlIlIIIIIl, this, this.gameController);
        final S45PacketTitle.Type llllllllllllllIlIllIllIlIlIIIIII = llllllllllllllIlIllIllIlIlIIIIIl.func_179807_a();
        String llllllllllllllIlIllIllIlIIllllll = null;
        String llllllllllllllIlIllIllIlIIlllllI = null;
        final String llllllllllllllIlIllIllIlIIllllIl = (llllllllllllllIlIllIllIlIlIIIIIl.func_179805_b() != null) ? llllllllllllllIlIllIllIlIlIIIIIl.func_179805_b().getFormattedText() : "";
        switch (SwitchAction.field_178885_a[llllllllllllllIlIllIllIlIlIIIIII.ordinal()]) {
            case 1: {
                llllllllllllllIlIllIllIlIIllllll = llllllllllllllIlIllIllIlIIllllIl;
                break;
            }
            case 2: {
                llllllllllllllIlIllIllIlIIlllllI = llllllllllllllIlIllIllIlIIllllIl;
                break;
            }
            case 3: {
                this.gameController.ingameGUI.func_175178_a("", "", -1, -1, -1);
                this.gameController.ingameGUI.func_175177_a();
                return;
            }
        }
        this.gameController.ingameGUI.func_175178_a(llllllllllllllIlIllIllIlIIllllll, llllllllllllllIlIllIllIlIIlllllI, llllllllllllllIlIllIllIlIlIIIIIl.func_179806_c(), llllllllllllllIlIllIllIlIlIIIIIl.func_179804_d(), llllllllllllllIlIllIllIlIlIIIIIl.func_179803_e());
    }
    
    @Override
    public void handleUseBed(final S0APacketUseBed llllllllllllllIlIllIlllIllIlllII) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIlllIllIlllII, this, this.gameController);
        llllllllllllllIlIllIlllIllIlllII.getPlayer(this.clientWorldController).func_180469_a(llllllllllllllIlIllIlllIllIlllII.func_179798_a());
    }
    
    public GameProfile func_175105_e() {
        return this.field_175107_d;
    }
    
    @Override
    public void handleJoinGame(final S01PacketJoinGame llllllllllllllIlIlllIIIIIIIIlIlI) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIlllIIIIIIIIlIlI, this, this.gameController);
        this.gameController.playerController = new PlayerControllerMP(this.gameController, this);
        this.clientWorldController = new WorldClient(this, new WorldSettings(0L, llllllllllllllIlIlllIIIIIIIIlIlI.func_149198_e(), false, llllllllllllllIlIlllIIIIIIIIlIlI.func_149195_d(), llllllllllllllIlIlllIIIIIIIIlIlI.func_149196_i()), llllllllllllllIlIlllIIIIIIIIlIlI.func_149194_f(), llllllllllllllIlIlllIIIIIIIIlIlI.func_149192_g(), this.gameController.mcProfiler);
        this.gameController.gameSettings.difficulty = llllllllllllllIlIlllIIIIIIIIlIlI.func_149192_g();
        this.gameController.loadWorld(this.clientWorldController);
        this.gameController.thePlayer.dimension = llllllllllllllIlIlllIIIIIIIIlIlI.func_149194_f();
        this.gameController.displayGuiScreen(new GuiDownloadTerrain(this));
        this.gameController.thePlayer.setEntityId(llllllllllllllIlIlllIIIIIIIIlIlI.func_149197_c());
        this.currentServerMaxPlayers = llllllllllllllIlIlllIIIIIIIIlIlI.func_149193_h();
        this.gameController.thePlayer.func_175150_k(llllllllllllllIlIlllIIIIIIIIlIlI.func_179744_h());
        this.gameController.playerController.setGameType(llllllllllllllIlIlllIIIIIIIIlIlI.func_149198_e());
        this.gameController.gameSettings.sendSettingsToServer();
        this.netManager.sendPacket(new C17PacketCustomPayload("MC|Brand", new PacketBuffer(Unpooled.buffer()).writeString(ClientBrandRetriever.getClientModName())));
    }
    
    @Override
    public void handleSpawnPosition(final S05PacketSpawnPosition llllllllllllllIlIllIlllIlIllIIII) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIlllIlIllIIII, this, this.gameController);
        this.gameController.thePlayer.func_180473_a(llllllllllllllIlIllIlllIlIllIIII.func_179800_a(), true);
        this.gameController.theWorld.getWorldInfo().setSpawn(llllllllllllllIlIllIlllIlIllIIII.func_179800_a());
    }
    
    @Override
    public void handleDestroyEntities(final S13PacketDestroyEntities llllllllllllllIlIllIllllIlIIllIl) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIllllIlIIllIl, this, this.gameController);
        for (int llllllllllllllIlIllIllllIlIIllll = 0; llllllllllllllIlIllIllllIlIIllll < llllllllllllllIlIllIllllIlIIllIl.func_149098_c().length; ++llllllllllllllIlIllIllllIlIIllll) {
            this.clientWorldController.removeEntityFromWorld(llllllllllllllIlIllIllllIlIIllIl.func_149098_c()[llllllllllllllIlIllIllllIlIIllll]);
        }
    }
    
    public NetworkPlayerInfo func_175104_a(final String llllllllllllllIlIllIllIIIIlIlIII) {
        for (final NetworkPlayerInfo llllllllllllllIlIllIllIIIIlIIllI : this.playerInfoMap.values()) {
            if (llllllllllllllIlIllIllIIIIlIIllI.func_178845_a().getName().equals(llllllllllllllIlIllIllIIIIlIlIII)) {
                return llllllllllllllIlIllIllIIIIlIIllI;
            }
        }
        return null;
    }
    
    @Override
    public void handleBlockChange(final S23PacketBlockChange llllllllllllllIlIllIllllIIIlIIll) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIllllIIIlIIll, this, this.gameController);
        this.clientWorldController.func_180503_b(llllllllllllllIlIllIllllIIIlIIll.func_179827_b(), llllllllllllllIlIllIllllIIIlIIll.func_180728_a());
    }
    
    @Override
    public void handleExplosion(final S27PacketExplosion llllllllllllllIlIllIlllIIlIIllll) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIlllIIlIIllll, this, this.gameController);
        final Explosion llllllllllllllIlIllIlllIIlIIllIl = new Explosion(this.gameController.theWorld, null, llllllllllllllIlIllIlllIIlIIllll.func_149148_f(), llllllllllllllIlIllIlllIIlIIllll.func_149143_g(), llllllllllllllIlIllIlllIIlIIllll.func_149145_h(), llllllllllllllIlIllIlllIIlIIllll.func_149146_i(), llllllllllllllIlIllIlllIIlIIllll.func_149150_j());
        llllllllllllllIlIllIlllIIlIIllIl.doExplosionB(true);
        final EntityPlayerSP thePlayer = this.gameController.thePlayer;
        thePlayer.motionX += llllllllllllllIlIllIlllIIlIIllll.func_149149_c();
        final EntityPlayerSP thePlayer2 = this.gameController.thePlayer;
        thePlayer2.motionY += llllllllllllllIlIllIlllIIlIIllll.func_149144_d();
        final EntityPlayerSP thePlayer3 = this.gameController.thePlayer;
        thePlayer3.motionZ += llllllllllllllIlIllIlllIIlIIllll.func_149147_e();
    }
    
    @Override
    public void handleTabComplete(final S3APacketTabComplete llllllllllllllIlIllIllIIlllllllI) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIllIIlllllllI, this, this.gameController);
        final String[] llllllllllllllIlIllIllIIllllllIl = llllllllllllllIlIllIllIIlllllllI.func_149630_c();
        if (this.gameController.currentScreen instanceof GuiChat) {
            final GuiChat llllllllllllllIlIllIllIIllllllII = (GuiChat)this.gameController.currentScreen;
            llllllllllllllIlIllIllIIllllllII.onAutocompleteResponse(llllllllllllllIlIllIllIIllllllIl);
        }
    }
    
    @Override
    public void handleSpawnObject(final S0EPacketSpawnObject llllllllllllllIlIllIllllllllIIlI) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIllllllllIIlI, this, this.gameController);
        final double llllllllllllllIlIllIllllllllllII = llllllllllllllIlIllIllllllllIIlI.func_148997_d() / 32.0;
        final double llllllllllllllIlIllIlllllllllIll = llllllllllllllIlIllIllllllllIIlI.func_148998_e() / 32.0;
        final double llllllllllllllIlIllIlllllllllIlI = llllllllllllllIlIllIllllllllIIlI.func_148994_f() / 32.0;
        Object llllllllllllllIlIllIlllllllllIIl = null;
        if (llllllllllllllIlIllIllllllllIIlI.func_148993_l() == 10) {
            llllllllllllllIlIllIlllllllllIIl = EntityMinecart.func_180458_a(this.clientWorldController, llllllllllllllIlIllIllllllllllII, llllllllllllllIlIllIlllllllllIll, llllllllllllllIlIllIlllllllllIlI, EntityMinecart.EnumMinecartType.func_180038_a(llllllllllllllIlIllIllllllllIIlI.func_149009_m()));
        }
        else if (llllllllllllllIlIllIllllllllIIlI.func_148993_l() == 90) {
            final Entity llllllllllllllIlIllIlllllllllIII = this.clientWorldController.getEntityByID(llllllllllllllIlIllIllllllllIIlI.func_149009_m());
            if (llllllllllllllIlIllIlllllllllIII instanceof EntityPlayer) {
                llllllllllllllIlIllIlllllllllIIl = new EntityFishHook(this.clientWorldController, llllllllllllllIlIllIllllllllllII, llllllllllllllIlIllIlllllllllIll, llllllllllllllIlIllIlllllllllIlI, (EntityPlayer)llllllllllllllIlIllIlllllllllIII);
            }
            llllllllllllllIlIllIllllllllIIlI.func_149002_g(0);
        }
        else if (llllllllllllllIlIllIllllllllIIlI.func_148993_l() == 60) {
            llllllllllllllIlIllIlllllllllIIl = new EntityArrow(this.clientWorldController, llllllllllllllIlIllIllllllllllII, llllllllllllllIlIllIlllllllllIll, llllllllllllllIlIllIlllllllllIlI);
        }
        else if (llllllllllllllIlIllIllllllllIIlI.func_148993_l() == 61) {
            llllllllllllllIlIllIlllllllllIIl = new EntitySnowball(this.clientWorldController, llllllllllllllIlIllIllllllllllII, llllllllllllllIlIllIlllllllllIll, llllllllllllllIlIllIlllllllllIlI);
        }
        else if (llllllllllllllIlIllIllllllllIIlI.func_148993_l() == 71) {
            llllllllllllllIlIllIlllllllllIIl = new EntityItemFrame(this.clientWorldController, new BlockPos(MathHelper.floor_double(llllllllllllllIlIllIllllllllllII), MathHelper.floor_double(llllllllllllllIlIllIlllllllllIll), MathHelper.floor_double(llllllllllllllIlIllIlllllllllIlI)), EnumFacing.getHorizontal(llllllllllllllIlIllIllllllllIIlI.func_149009_m()));
            llllllllllllllIlIllIllllllllIIlI.func_149002_g(0);
        }
        else if (llllllllllllllIlIllIllllllllIIlI.func_148993_l() == 77) {
            llllllllllllllIlIllIlllllllllIIl = new EntityLeashKnot(this.clientWorldController, new BlockPos(MathHelper.floor_double(llllllllllllllIlIllIllllllllllII), MathHelper.floor_double(llllllllllllllIlIllIlllllllllIll), MathHelper.floor_double(llllllllllllllIlIllIlllllllllIlI)));
            llllllllllllllIlIllIllllllllIIlI.func_149002_g(0);
        }
        else if (llllllllllllllIlIllIllllllllIIlI.func_148993_l() == 65) {
            llllllllllllllIlIllIlllllllllIIl = new EntityEnderPearl(this.clientWorldController, llllllllllllllIlIllIllllllllllII, llllllllllllllIlIllIlllllllllIll, llllllllllllllIlIllIlllllllllIlI);
        }
        else if (llllllllllllllIlIllIllllllllIIlI.func_148993_l() == 72) {
            llllllllllllllIlIllIlllllllllIIl = new EntityEnderEye(this.clientWorldController, llllllllllllllIlIllIllllllllllII, llllllllllllllIlIllIlllllllllIll, llllllllllllllIlIllIlllllllllIlI);
        }
        else if (llllllllllllllIlIllIllllllllIIlI.func_148993_l() == 76) {
            llllllllllllllIlIllIlllllllllIIl = new EntityFireworkRocket(this.clientWorldController, llllllllllllllIlIllIllllllllllII, llllllllllllllIlIllIlllllllllIll, llllllllllllllIlIllIlllllllllIlI, null);
        }
        else if (llllllllllllllIlIllIllllllllIIlI.func_148993_l() == 63) {
            llllllllllllllIlIllIlllllllllIIl = new EntityLargeFireball(this.clientWorldController, llllllllllllllIlIllIllllllllllII, llllllllllllllIlIllIlllllllllIll, llllllllllllllIlIllIlllllllllIlI, llllllllllllllIlIllIllllllllIIlI.func_149010_g() / 8000.0, llllllllllllllIlIllIllllllllIIlI.func_149004_h() / 8000.0, llllllllllllllIlIllIllllllllIIlI.func_148999_i() / 8000.0);
            llllllllllllllIlIllIllllllllIIlI.func_149002_g(0);
        }
        else if (llllllllllllllIlIllIllllllllIIlI.func_148993_l() == 64) {
            llllllllllllllIlIllIlllllllllIIl = new EntitySmallFireball(this.clientWorldController, llllllllllllllIlIllIllllllllllII, llllllllllllllIlIllIlllllllllIll, llllllllllllllIlIllIlllllllllIlI, llllllllllllllIlIllIllllllllIIlI.func_149010_g() / 8000.0, llllllllllllllIlIllIllllllllIIlI.func_149004_h() / 8000.0, llllllllllllllIlIllIllllllllIIlI.func_148999_i() / 8000.0);
            llllllllllllllIlIllIllllllllIIlI.func_149002_g(0);
        }
        else if (llllllllllllllIlIllIllllllllIIlI.func_148993_l() == 66) {
            llllllllllllllIlIllIlllllllllIIl = new EntityWitherSkull(this.clientWorldController, llllllllllllllIlIllIllllllllllII, llllllllllllllIlIllIlllllllllIll, llllllllllllllIlIllIlllllllllIlI, llllllllllllllIlIllIllllllllIIlI.func_149010_g() / 8000.0, llllllllllllllIlIllIllllllllIIlI.func_149004_h() / 8000.0, llllllllllllllIlIllIllllllllIIlI.func_148999_i() / 8000.0);
            llllllllllllllIlIllIllllllllIIlI.func_149002_g(0);
        }
        else if (llllllllllllllIlIllIllllllllIIlI.func_148993_l() == 62) {
            llllllllllllllIlIllIlllllllllIIl = new EntityEgg(this.clientWorldController, llllllllllllllIlIllIllllllllllII, llllllllllllllIlIllIlllllllllIll, llllllllllllllIlIllIlllllllllIlI);
        }
        else if (llllllllllllllIlIllIllllllllIIlI.func_148993_l() == 73) {
            llllllllllllllIlIllIlllllllllIIl = new EntityPotion(this.clientWorldController, llllllllllllllIlIllIllllllllllII, llllllllllllllIlIllIlllllllllIll, llllllllllllllIlIllIlllllllllIlI, llllllllllllllIlIllIllllllllIIlI.func_149009_m());
            llllllllllllllIlIllIllllllllIIlI.func_149002_g(0);
        }
        else if (llllllllllllllIlIllIllllllllIIlI.func_148993_l() == 75) {
            llllllllllllllIlIllIlllllllllIIl = new EntityExpBottle(this.clientWorldController, llllllllllllllIlIllIllllllllllII, llllllllllllllIlIllIlllllllllIll, llllllllllllllIlIllIlllllllllIlI);
            llllllllllllllIlIllIllllllllIIlI.func_149002_g(0);
        }
        else if (llllllllllllllIlIllIllllllllIIlI.func_148993_l() == 1) {
            llllllllllllllIlIllIlllllllllIIl = new EntityBoat(this.clientWorldController, llllllllllllllIlIllIllllllllllII, llllllllllllllIlIllIlllllllllIll, llllllllllllllIlIllIlllllllllIlI);
        }
        else if (llllllllllllllIlIllIllllllllIIlI.func_148993_l() == 50) {
            llllllllllllllIlIllIlllllllllIIl = new EntityTNTPrimed(this.clientWorldController, llllllllllllllIlIllIllllllllllII, llllllllllllllIlIllIlllllllllIll, llllllllllllllIlIllIlllllllllIlI, null);
        }
        else if (llllllllllllllIlIllIllllllllIIlI.func_148993_l() == 78) {
            llllllllllllllIlIllIlllllllllIIl = new EntityArmorStand(this.clientWorldController, llllllllllllllIlIllIllllllllllII, llllllllllllllIlIllIlllllllllIll, llllllllllllllIlIllIlllllllllIlI);
        }
        else if (llllllllllllllIlIllIllllllllIIlI.func_148993_l() == 51) {
            llllllllllllllIlIllIlllllllllIIl = new EntityEnderCrystal(this.clientWorldController, llllllllllllllIlIllIllllllllllII, llllllllllllllIlIllIlllllllllIll, llllllllllllllIlIllIlllllllllIlI);
        }
        else if (llllllllllllllIlIllIllllllllIIlI.func_148993_l() == 2) {
            llllllllllllllIlIllIlllllllllIIl = new EntityItem(this.clientWorldController, llllllllllllllIlIllIllllllllllII, llllllllllllllIlIllIlllllllllIll, llllllllllllllIlIllIlllllllllIlI);
        }
        else if (llllllllllllllIlIllIllllllllIIlI.func_148993_l() == 70) {
            llllllllllllllIlIllIlllllllllIIl = new EntityFallingBlock(this.clientWorldController, llllllllllllllIlIllIllllllllllII, llllllllllllllIlIllIlllllllllIll, llllllllllllllIlIllIlllllllllIlI, Block.getStateById(llllllllllllllIlIllIllllllllIIlI.func_149009_m() & 0xFFFF));
            llllllllllllllIlIllIllllllllIIlI.func_149002_g(0);
        }
        if (llllllllllllllIlIllIlllllllllIIl != null) {
            ((Entity)llllllllllllllIlIllIlllllllllIIl).serverPosX = llllllllllllllIlIllIllllllllIIlI.func_148997_d();
            ((Entity)llllllllllllllIlIllIlllllllllIIl).serverPosY = llllllllllllllIlIllIllllllllIIlI.func_148998_e();
            ((Entity)llllllllllllllIlIllIlllllllllIIl).serverPosZ = llllllllllllllIlIllIllllllllIIlI.func_148994_f();
            ((Entity)llllllllllllllIlIllIlllllllllIIl).rotationPitch = llllllllllllllIlIllIllllllllIIlI.func_149008_j() * 360 / 256.0f;
            ((Entity)llllllllllllllIlIllIlllllllllIIl).rotationYaw = llllllllllllllIlIllIllllllllIIlI.func_149006_k() * 360 / 256.0f;
            final Entity[] llllllllllllllIlIllIllllllllIlll = ((Entity)llllllllllllllIlIllIlllllllllIIl).getParts();
            if (llllllllllllllIlIllIllllllllIlll != null) {
                final int llllllllllllllIlIllIllllllllIllI = llllllllllllllIlIllIllllllllIIlI.func_149001_c() - ((Entity)llllllllllllllIlIllIlllllllllIIl).getEntityId();
                for (int llllllllllllllIlIllIllllllllIlIl = 0; llllllllllllllIlIllIllllllllIlIl < llllllllllllllIlIllIllllllllIlll.length; ++llllllllllllllIlIllIllllllllIlIl) {
                    llllllllllllllIlIllIllllllllIlll[llllllllllllllIlIllIllllllllIlIl].setEntityId(llllllllllllllIlIllIllllllllIlll[llllllllllllllIlIllIllllllllIlIl].getEntityId() + llllllllllllllIlIllIllllllllIllI);
                }
            }
            ((Entity)llllllllllllllIlIllIlllllllllIIl).setEntityId(llllllllllllllIlIllIllllllllIIlI.func_149001_c());
            this.clientWorldController.addEntityToWorld(llllllllllllllIlIllIllllllllIIlI.func_149001_c(), (Entity)llllllllllllllIlIllIlllllllllIIl);
            if (llllllllllllllIlIllIllllllllIIlI.func_149009_m() > 0) {
                if (llllllllllllllIlIllIllllllllIIlI.func_148993_l() == 60) {
                    final Entity llllllllllllllIlIllIllllllllIlII = this.clientWorldController.getEntityByID(llllllllllllllIlIllIllllllllIIlI.func_149009_m());
                    if (llllllllllllllIlIllIllllllllIlII instanceof EntityLivingBase && llllllllllllllIlIllIlllllllllIIl instanceof EntityArrow) {
                        ((EntityArrow)llllllllllllllIlIllIlllllllllIIl).shootingEntity = llllllllllllllIlIllIllllllllIlII;
                    }
                }
                ((Entity)llllllllllllllIlIllIlllllllllIIl).setVelocity(llllllllllllllIlIllIllllllllIIlI.func_149010_g() / 8000.0, llllllllllllllIlIllIllllllllIIlI.func_149004_h() / 8000.0, llllllllllllllIlIllIllllllllIIlI.func_148999_i() / 8000.0);
            }
        }
    }
    
    @Override
    public void handleUpdateTileEntity(final S35PacketUpdateTileEntity llllllllllllllIlIllIllIllllllIII) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIllIllllllIII, this, this.gameController);
        if (this.gameController.theWorld.isBlockLoaded(llllllllllllllIlIllIllIllllllIII.func_179823_a())) {
            final TileEntity llllllllllllllIlIllIllIlllllIlll = this.gameController.theWorld.getTileEntity(llllllllllllllIlIllIllIllllllIII.func_179823_a());
            final int llllllllllllllIlIllIllIlllllIllI = llllllllllllllIlIllIllIllllllIII.getTileEntityType();
            if ((llllllllllllllIlIllIllIlllllIllI == 1 && llllllllllllllIlIllIllIlllllIlll instanceof TileEntityMobSpawner) || (llllllllllllllIlIllIllIlllllIllI == 2 && llllllllllllllIlIllIllIlllllIlll instanceof TileEntityCommandBlock) || (llllllllllllllIlIllIllIlllllIllI == 3 && llllllllllllllIlIllIllIlllllIlll instanceof TileEntityBeacon) || (llllllllllllllIlIllIllIlllllIllI == 4 && llllllllllllllIlIllIllIlllllIlll instanceof TileEntitySkull) || (llllllllllllllIlIllIllIlllllIllI == 5 && llllllllllllllIlIllIllIlllllIlll instanceof TileEntityFlowerPot) || (llllllllllllllIlIllIllIlllllIllI == 6 && llllllllllllllIlIllIllIlllllIlll instanceof TileEntityBanner)) {
                llllllllllllllIlIllIllIlllllIlll.readFromNBT(llllllllllllllIlIllIllIllllllIII.getNbtCompound());
            }
        }
    }
    
    @Override
    public void onDisconnect(final IChatComponent llllllllllllllIlIllIllllIIIIIlll) {
        this.gameController.loadWorld(null);
        if (this.guiScreenServer != null) {
            if (this.guiScreenServer instanceof GuiScreenRealmsProxy) {
                this.gameController.displayGuiScreen(new DisconnectedRealmsScreen(((GuiScreenRealmsProxy)this.guiScreenServer).func_154321_a(), "disconnect.lost", llllllllllllllIlIllIllllIIIIIlll).getProxy());
            }
            else {
                this.gameController.displayGuiScreen(new GuiDisconnected(this.guiScreenServer, "disconnect.lost", llllllllllllllIlIllIllllIIIIIlll));
            }
        }
        else {
            this.gameController.displayGuiScreen(new GuiDisconnected(new GuiMultiplayer(new GuiMainMenu()), "disconnect.lost", llllllllllllllIlIllIllllIIIIIlll));
        }
    }
    
    @Override
    public void func_175093_a(final S44PacketWorldBorder llllllllllllllIlIllIllIlIlIIlIll) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIllIlIlIIlIll, this, this.gameController);
        llllllllllllllIlIllIllIlIlIIlIll.func_179788_a(this.clientWorldController.getWorldBorder());
    }
    
    @Override
    public void handlePlayerAbilities(final S39PacketPlayerAbilities llllllllllllllIlIllIllIlIIIIlIII) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIllIlIIIIlIII, this, this.gameController);
        final EntityPlayerSP llllllllllllllIlIllIllIlIIIIIlll = this.gameController.thePlayer;
        llllllllllllllIlIllIllIlIIIIIlll.capabilities.isFlying = llllllllllllllIlIllIllIlIIIIlIII.isFlying();
        llllllllllllllIlIllIllIlIIIIIlll.capabilities.isCreativeMode = llllllllllllllIlIllIllIlIIIIlIII.isCreativeMode();
        llllllllllllllIlIllIllIlIIIIIlll.capabilities.disableDamage = llllllllllllllIlIllIllIlIIIIlIII.isInvulnerable();
        llllllllllllllIlIllIllIlIIIIIlll.capabilities.allowFlying = llllllllllllllIlIllIllIlIIIIlIII.isAllowFlying();
        llllllllllllllIlIllIllIlIIIIIlll.capabilities.setFlySpeed(llllllllllllllIlIllIllIlIIIIlIII.getFlySpeed());
        llllllllllllllIlIllIllIlIIIIIlll.capabilities.setPlayerWalkSpeed(llllllllllllllIlIllIllIlIIIIlIII.getWalkSpeed());
    }
    
    @Override
    public void handleChat(final S02PacketChat llllllllllllllIlIllIlllIllllIIIl) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIlllIllllIIIl, this, this.gameController);
        if (llllllllllllllIlIllIlllIllllIIIl.func_179841_c() == 2) {
            this.gameController.ingameGUI.func_175188_a(llllllllllllllIlIllIlllIllllIIIl.func_148915_c(), false);
        }
        else {
            this.gameController.ingameGUI.getChatGUI().printChatMessage(llllllllllllllIlIllIlllIllllIIIl.func_148915_c());
        }
    }
    
    @Override
    public void handleChangeGameState(final S2BPacketChangeGameState llllllllllllllIlIllIllIllIllIIll) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIllIllIllIIll, this, this.gameController);
        final EntityPlayerSP llllllllllllllIlIllIllIllIllIIlI = this.gameController.thePlayer;
        final int llllllllllllllIlIllIllIllIllIIIl = llllllllllllllIlIllIllIllIllIIll.func_149138_c();
        final float llllllllllllllIlIllIllIllIllIIII = llllllllllllllIlIllIllIllIllIIll.func_149137_d();
        final int llllllllllllllIlIllIllIllIlIllll = MathHelper.floor_float(llllllllllllllIlIllIllIllIllIIII + 0.5f);
        if (llllllllllllllIlIllIllIllIllIIIl >= 0 && llllllllllllllIlIllIllIllIllIIIl < S2BPacketChangeGameState.MESSAGE_NAMES.length && S2BPacketChangeGameState.MESSAGE_NAMES[llllllllllllllIlIllIllIllIllIIIl] != null) {
            llllllllllllllIlIllIllIllIllIIlI.addChatComponentMessage(new ChatComponentTranslation(S2BPacketChangeGameState.MESSAGE_NAMES[llllllllllllllIlIllIllIllIllIIIl], new Object[0]));
        }
        if (llllllllllllllIlIllIllIllIllIIIl == 1) {
            this.clientWorldController.getWorldInfo().setRaining(true);
            this.clientWorldController.setRainStrength(0.0f);
        }
        else if (llllllllllllllIlIllIllIllIllIIIl == 2) {
            this.clientWorldController.getWorldInfo().setRaining(false);
            this.clientWorldController.setRainStrength(1.0f);
        }
        else if (llllllllllllllIlIllIllIllIllIIIl == 3) {
            this.gameController.playerController.setGameType(WorldSettings.GameType.getByID(llllllllllllllIlIllIllIllIlIllll));
        }
        else if (llllllllllllllIlIllIllIllIllIIIl == 4) {
            this.gameController.displayGuiScreen(new GuiWinGame());
        }
        else if (llllllllllllllIlIllIllIllIllIIIl == 5) {
            final GameSettings llllllllllllllIlIllIllIllIlIlllI = this.gameController.gameSettings;
            if (llllllllllllllIlIllIllIllIllIIII == 0.0f) {
                this.gameController.displayGuiScreen(new GuiScreenDemo());
            }
            else if (llllllllllllllIlIllIllIllIllIIII == 101.0f) {
                this.gameController.ingameGUI.getChatGUI().printChatMessage(new ChatComponentTranslation("demo.help.movement", new Object[] { GameSettings.getKeyDisplayString(llllllllllllllIlIllIllIllIlIlllI.keyBindForward.getKeyCode()), GameSettings.getKeyDisplayString(llllllllllllllIlIllIllIllIlIlllI.keyBindLeft.getKeyCode()), GameSettings.getKeyDisplayString(llllllllllllllIlIllIllIllIlIlllI.keyBindBack.getKeyCode()), GameSettings.getKeyDisplayString(llllllllllllllIlIllIllIllIlIlllI.keyBindRight.getKeyCode()) }));
            }
            else if (llllllllllllllIlIllIllIllIllIIII == 102.0f) {
                this.gameController.ingameGUI.getChatGUI().printChatMessage(new ChatComponentTranslation("demo.help.jump", new Object[] { GameSettings.getKeyDisplayString(llllllllllllllIlIllIllIllIlIlllI.keyBindJump.getKeyCode()) }));
            }
            else if (llllllllllllllIlIllIllIllIllIIII == 103.0f) {
                this.gameController.ingameGUI.getChatGUI().printChatMessage(new ChatComponentTranslation("demo.help.inventory", new Object[] { GameSettings.getKeyDisplayString(llllllllllllllIlIllIllIllIlIlllI.keyBindInventory.getKeyCode()) }));
            }
        }
        else if (llllllllllllllIlIllIllIllIllIIIl == 6) {
            this.clientWorldController.playSound(llllllllllllllIlIllIllIllIllIIlI.posX, llllllllllllllIlIllIllIllIllIIlI.posY + llllllllllllllIlIllIllIllIllIIlI.getEyeHeight(), llllllllllllllIlIllIllIllIllIIlI.posZ, "random.successful_hit", 0.18f, 0.45f, false);
        }
        else if (llllllllllllllIlIllIllIllIllIIIl == 7) {
            this.clientWorldController.setRainStrength(llllllllllllllIlIllIllIllIllIIII);
        }
        else if (llllllllllllllIlIllIllIllIllIIIl == 8) {
            this.clientWorldController.setThunderStrength(llllllllllllllIlIllIllIllIllIIII);
        }
        else if (llllllllllllllIlIllIllIllIllIIIl == 10) {
            this.clientWorldController.spawnParticle(EnumParticleTypes.MOB_APPEARANCE, llllllllllllllIlIllIllIllIllIIlI.posX, llllllllllllllIlIllIllIllIllIIlI.posY, llllllllllllllIlIllIllIllIllIIlI.posZ, 0.0, 0.0, 0.0, new int[0]);
            this.clientWorldController.playSound(llllllllllllllIlIllIllIllIllIIlI.posX, llllllllllllllIlIllIllIllIllIIlI.posY, llllllllllllllIlIllIllIllIllIIlI.posZ, "mob.guardian.curse", 1.0f, 1.0f, false);
        }
    }
    
    @Override
    public void handleUpdateSign(final S33PacketUpdateSign llllllllllllllIlIllIlllIIIIIIIIl) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIlllIIIIIIIIl, this, this.gameController);
        boolean llllllllllllllIlIllIlllIIIIIIlIl = false;
        if (this.gameController.theWorld.isBlockLoaded(llllllllllllllIlIllIlllIIIIIIIIl.func_179704_a())) {
            final TileEntity llllllllllllllIlIllIlllIIIIIIlII = this.gameController.theWorld.getTileEntity(llllllllllllllIlIllIlllIIIIIIIIl.func_179704_a());
            if (llllllllllllllIlIllIlllIIIIIIlII instanceof TileEntitySign) {
                final TileEntitySign llllllllllllllIlIllIlllIIIIIIIll = (TileEntitySign)llllllllllllllIlIllIlllIIIIIIlII;
                if (llllllllllllllIlIllIlllIIIIIIIll.getIsEditable()) {
                    System.arraycopy(llllllllllllllIlIllIlllIIIIIIIIl.func_180753_b(), 0, llllllllllllllIlIllIlllIIIIIIIll.signText, 0, 4);
                    llllllllllllllIlIllIlllIIIIIIIll.markDirty();
                }
                llllllllllllllIlIllIlllIIIIIIlIl = true;
            }
        }
        if (!llllllllllllllIlIllIlllIIIIIIlIl && this.gameController.thePlayer != null) {
            this.gameController.thePlayer.addChatMessage(new ChatComponentText(String.valueOf(new StringBuilder("Unable to locate sign at ").append(llllllllllllllIlIllIlllIIIIIIIIl.func_179704_a().getX()).append(", ").append(llllllllllllllIlIllIlllIIIIIIIIl.func_179704_a().getY()).append(", ").append(llllllllllllllIlIllIlllIIIIIIIIl.func_179704_a().getZ()))));
        }
    }
    
    @Override
    public void handleRespawn(final S07PacketRespawn llllllllllllllIlIllIlllIIlIlllIl) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIlllIIlIlllIl, this, this.gameController);
        if (llllllllllllllIlIllIlllIIlIlllIl.func_149082_c() != this.gameController.thePlayer.dimension) {
            this.doneLoadingTerrain = false;
            final Scoreboard llllllllllllllIlIllIlllIIllIIIII = this.clientWorldController.getScoreboard();
            this.clientWorldController = new WorldClient(this, new WorldSettings(0L, llllllllllllllIlIllIlllIIlIlllIl.func_149083_e(), false, this.gameController.theWorld.getWorldInfo().isHardcoreModeEnabled(), llllllllllllllIlIllIlllIIlIlllIl.func_149080_f()), llllllllllllllIlIllIlllIIlIlllIl.func_149082_c(), llllllllllllllIlIllIlllIIlIlllIl.func_149081_d(), this.gameController.mcProfiler);
            this.clientWorldController.setWorldScoreboard(llllllllllllllIlIllIlllIIllIIIII);
            this.gameController.loadWorld(this.clientWorldController);
            this.gameController.thePlayer.dimension = llllllllllllllIlIllIlllIIlIlllIl.func_149082_c();
            this.gameController.displayGuiScreen(new GuiDownloadTerrain(this));
        }
        this.gameController.setDimensionAndSpawnPlayer(llllllllllllllIlIllIlllIIlIlllIl.func_149082_c());
        this.gameController.playerController.setGameType(llllllllllllllIlIllIlllIIlIlllIl.func_149083_e());
    }
    
    @Override
    public void handleStatistics(final S37PacketStatistics llllllllllllllIlIllIllIllIIIIllI) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIllIllIIIIllI, this, this.gameController);
        boolean llllllllllllllIlIllIllIllIIIllIl = false;
        for (final Map.Entry llllllllllllllIlIllIllIllIIIlIIl : llllllllllllllIlIllIllIllIIIIllI.func_148974_c().entrySet()) {
            final StatBase llllllllllllllIlIllIllIllIIIllII = llllllllllllllIlIllIllIllIIIlIIl.getKey();
            final int llllllllllllllIlIllIllIllIIIlIll = llllllllllllllIlIllIllIllIIIlIIl.getValue();
            if (llllllllllllllIlIllIllIllIIIllII.isAchievement() && llllllllllllllIlIllIllIllIIIlIll > 0) {
                if (this.field_147308_k && this.gameController.thePlayer.getStatFileWriter().writeStat(llllllllllllllIlIllIllIllIIIllII) == 0) {
                    final Achievement llllllllllllllIlIllIllIllIIIlIII = (Achievement)llllllllllllllIlIllIllIllIIIllII;
                    this.gameController.guiAchievement.displayAchievement(llllllllllllllIlIllIllIllIIIlIII);
                    this.gameController.getTwitchStream().func_152911_a(new MetadataAchievement(llllllllllllllIlIllIllIllIIIlIII), 0L);
                    if (llllllllllllllIlIllIllIllIIIllII == AchievementList.openInventory) {
                        this.gameController.gameSettings.showInventoryAchievementHint = false;
                        this.gameController.gameSettings.saveOptions();
                    }
                }
                llllllllllllllIlIllIllIllIIIllIl = true;
            }
            this.gameController.thePlayer.getStatFileWriter().func_150873_a(this.gameController.thePlayer, llllllllllllllIlIllIllIllIIIllII, llllllllllllllIlIllIllIllIIIlIll);
        }
        if (!this.field_147308_k && !llllllllllllllIlIllIllIllIIIllIl && this.gameController.gameSettings.showInventoryAchievementHint) {
            this.gameController.guiAchievement.displayUnformattedAchievement(AchievementList.openInventory);
        }
        this.field_147308_k = true;
        if (this.gameController.currentScreen instanceof IProgressMeter) {
            ((IProgressMeter)this.gameController.currentScreen).doneLoading();
        }
    }
    
    @Override
    public void func_175100_a(final S46PacketSetCompressionLevel llllllllllllllIlIllIllIlIIllIIll) {
        if (!this.netManager.isLocalChannel()) {
            this.netManager.setCompressionTreshold(llllllllllllllIlIllIllIlIIllIIll.func_179760_a());
        }
    }
    
    @Override
    public void handleChunkData(final S21PacketChunkData llllllllllllllIlIllIllllIIIlllIl) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIllllIIIlllIl, this, this.gameController);
        if (llllllllllllllIlIllIllllIIIlllIl.func_149274_i()) {
            if (llllllllllllllIlIllIllllIIIlllIl.func_149276_g() == 0) {
                this.clientWorldController.doPreChunk(llllllllllllllIlIllIllllIIIlllIl.func_149273_e(), llllllllllllllIlIllIllllIIIlllIl.func_149271_f(), false);
                return;
            }
            this.clientWorldController.doPreChunk(llllllllllllllIlIllIllllIIIlllIl.func_149273_e(), llllllllllllllIlIllIllllIIIlllIl.func_149271_f(), true);
        }
        this.clientWorldController.invalidateBlockReceiveRegion(llllllllllllllIlIllIllllIIIlllIl.func_149273_e() << 4, 0, llllllllllllllIlIllIllllIIIlllIl.func_149271_f() << 4, (llllllllllllllIlIllIllllIIIlllIl.func_149273_e() << 4) + 15, 256, (llllllllllllllIlIllIllllIIIlllIl.func_149271_f() << 4) + 15);
        final Chunk llllllllllllllIlIllIllllIIIlllII = this.clientWorldController.getChunkFromChunkCoords(llllllllllllllIlIllIllllIIIlllIl.func_149273_e(), llllllllllllllIlIllIllllIIIlllIl.func_149271_f());
        llllllllllllllIlIllIllllIIIlllII.func_177439_a(llllllllllllllIlIllIllllIIIlllIl.func_149272_d(), llllllllllllllIlIllIllllIIIlllIl.func_149276_g(), llllllllllllllIlIllIllllIIIlllIl.func_149274_i());
        this.clientWorldController.markBlockRangeForRenderUpdate(llllllllllllllIlIllIllllIIIlllIl.func_149273_e() << 4, 0, llllllllllllllIlIllIllllIIIlllIl.func_149271_f() << 4, (llllllllllllllIlIllIllllIIIlllIl.func_149273_e() << 4) + 15, 256, (llllllllllllllIlIllIllllIIIlllIl.func_149271_f() << 4) + 15);
        if (!llllllllllllllIlIllIllllIIIlllIl.func_149274_i() || !(this.clientWorldController.provider instanceof WorldProviderSurface)) {
            llllllllllllllIlIllIllllIIIlllII.resetRelightChecks();
        }
    }
    
    @Override
    public void handleMultiBlockChange(final S22PacketMultiBlockChange llllllllllllllIlIllIllllIIlIllII) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIllllIIlIllII, this, this.gameController);
        for (final S22PacketMultiBlockChange.BlockUpdateData llllllllllllllIlIllIllllIIlIlIII : llllllllllllllIlIllIllllIIlIllII.func_179844_a()) {
            this.clientWorldController.func_180503_b(llllllllllllllIlIllIllllIIlIlIII.func_180090_a(), llllllllllllllIlIllIllllIIlIlIII.func_180088_c());
        }
    }
    
    @Override
    public void func_175097_a(final S49PacketUpdateEntityNBT llllllllllllllIlIllIllIIllIlIlIl) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIllIIllIlIlIl, this, this.gameController);
        final Entity llllllllllllllIlIllIllIIllIlIlll = llllllllllllllIlIllIllIIllIlIlIl.func_179764_a(this.clientWorldController);
        if (llllllllllllllIlIllIllIIllIlIlll != null) {
            llllllllllllllIlIllIllIIllIlIlll.func_174834_g(llllllllllllllIlIllIllIIllIlIlIl.func_179763_a());
        }
    }
    
    @Override
    public void handleEntityEquipment(final S04PacketEntityEquipment llllllllllllllIlIllIllIllllIIIIl) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIllIllllIIIIl, this, this.gameController);
        final Entity llllllllllllllIlIllIllIllllIIIll = this.clientWorldController.getEntityByID(llllllllllllllIlIllIllIllllIIIIl.func_149389_d());
        if (llllllllllllllIlIllIllIllllIIIll != null) {
            llllllllllllllIlIllIllIllllIIIll.setCurrentItemOrArmor(llllllllllllllIlIllIllIllllIIIIl.func_149388_e(), llllllllllllllIlIllIllIllllIIIIl.func_149390_c());
        }
    }
    
    @Override
    public void handleOpenWindow(final S2DPacketOpenWindow llllllllllllllIlIllIlllIIlIIIIlI) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIlllIIlIIIIlI, this, this.gameController);
        final EntityPlayerSP llllllllllllllIlIllIlllIIlIIIIIl = this.gameController.thePlayer;
        if ("minecraft:container".equals(llllllllllllllIlIllIlllIIlIIIIlI.func_148902_e())) {
            llllllllllllllIlIllIlllIIlIIIIIl.displayGUIChest(new InventoryBasic(llllllllllllllIlIllIlllIIlIIIIlI.func_179840_c(), llllllllllllllIlIllIlllIIlIIIIlI.func_148898_f()));
            llllllllllllllIlIllIlllIIlIIIIIl.openContainer.windowId = llllllllllllllIlIllIlllIIlIIIIlI.func_148901_c();
        }
        else if ("minecraft:villager".equals(llllllllllllllIlIllIlllIIlIIIIlI.func_148902_e())) {
            llllllllllllllIlIllIlllIIlIIIIIl.displayVillagerTradeGui(new NpcMerchant(llllllllllllllIlIllIlllIIlIIIIIl, llllllllllllllIlIllIlllIIlIIIIlI.func_179840_c()));
            llllllllllllllIlIllIlllIIlIIIIIl.openContainer.windowId = llllllllllllllIlIllIlllIIlIIIIlI.func_148901_c();
        }
        else if ("EntityHorse".equals(llllllllllllllIlIllIlllIIlIIIIlI.func_148902_e())) {
            final Entity llllllllllllllIlIllIlllIIlIIIIII = this.clientWorldController.getEntityByID(llllllllllllllIlIllIlllIIlIIIIlI.func_148897_h());
            if (llllllllllllllIlIllIlllIIlIIIIII instanceof EntityHorse) {
                llllllllllllllIlIllIlllIIlIIIIIl.displayGUIHorse((EntityHorse)llllllllllllllIlIllIlllIIlIIIIII, new AnimalChest(llllllllllllllIlIllIlllIIlIIIIlI.func_179840_c(), llllllllllllllIlIllIlllIIlIIIIlI.func_148898_f()));
                llllllllllllllIlIllIlllIIlIIIIIl.openContainer.windowId = llllllllllllllIlIllIlllIIlIIIIlI.func_148901_c();
            }
        }
        else if (!llllllllllllllIlIllIlllIIlIIIIlI.func_148900_g()) {
            llllllllllllllIlIllIlllIIlIIIIIl.displayGui(new LocalBlockIntercommunication(llllllllllllllIlIllIlllIIlIIIIlI.func_148902_e(), llllllllllllllIlIllIlllIIlIIIIlI.func_179840_c()));
            llllllllllllllIlIllIlllIIlIIIIIl.openContainer.windowId = llllllllllllllIlIllIlllIIlIIIIlI.func_148901_c();
        }
        else {
            final ContainerLocalMenu llllllllllllllIlIllIlllIIIllllll = new ContainerLocalMenu(llllllllllllllIlIllIlllIIlIIIIlI.func_148902_e(), llllllllllllllIlIllIlllIIlIIIIlI.func_179840_c(), llllllllllllllIlIllIlllIIlIIIIlI.func_148898_f());
            llllllllllllllIlIllIlllIIlIIIIIl.displayGUIChest(llllllllllllllIlIllIlllIIIllllll);
            llllllllllllllIlIllIlllIIlIIIIIl.openContainer.windowId = llllllllllllllIlIllIlllIIlIIIIlI.func_148901_c();
        }
    }
    
    @Override
    public void handleSetExperience(final S1FPacketSetExperience llllllllllllllIlIllIlllIIlllIlII) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIlllIIlllIlII, this, this.gameController);
        this.gameController.thePlayer.setXPStats(llllllllllllllIlIllIlllIIlllIlII.func_149397_c(), llllllllllllllIlIllIlllIIlllIlII.func_149396_d(), llllllllllllllIlIllIlllIIlllIlII.func_149395_e());
    }
    
    @Override
    public void handleSpawnGlobalEntity(final S2CPacketSpawnGlobalEntity llllllllllllllIlIllIllllllIllIlI) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIllllllIllIlI, this, this.gameController);
        final double llllllllllllllIlIllIllllllIllIIl = llllllllllllllIlIllIllllllIllIlI.func_149051_d() / 32.0;
        final double llllllllllllllIlIllIllllllIllIII = llllllllllllllIlIllIllllllIllIlI.func_149050_e() / 32.0;
        final double llllllllllllllIlIllIllllllIlIlll = llllllllllllllIlIllIllllllIllIlI.func_149049_f() / 32.0;
        EntityLightningBolt llllllllllllllIlIllIllllllIlIllI = null;
        if (llllllllllllllIlIllIllllllIllIlI.func_149053_g() == 1) {
            llllllllllllllIlIllIllllllIlIllI = new EntityLightningBolt(this.clientWorldController, llllllllllllllIlIllIllllllIllIIl, llllllllllllllIlIllIllllllIllIII, llllllllllllllIlIllIllllllIlIlll);
        }
        if (llllllllllllllIlIllIllllllIlIllI != null) {
            llllllllllllllIlIllIllllllIlIllI.serverPosX = llllllllllllllIlIllIllllllIllIlI.func_149051_d();
            llllllllllllllIlIllIllllllIlIllI.serverPosY = llllllllllllllIlIllIllllllIllIlI.func_149050_e();
            llllllllllllllIlIllIllllllIlIllI.serverPosZ = llllllllllllllIlIllIllllllIllIlI.func_149049_f();
            llllllllllllllIlIllIllllllIlIllI.rotationYaw = 0.0f;
            llllllllllllllIlIllIllllllIlIllI.rotationPitch = 0.0f;
            llllllllllllllIlIllIllllllIlIllI.setEntityId(llllllllllllllIlIllIllllllIllIlI.func_149052_c());
            this.clientWorldController.addWeatherEffect(llllllllllllllIlIllIllllllIlIllI);
        }
    }
    
    @Override
    public void handleSoundEffect(final S29PacketSoundEffect llllllllllllllIlIllIllIIllllIlII) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIllIIllllIlII, this, this.gameController);
        this.gameController.theWorld.playSound(llllllllllllllIlIllIllIIllllIlII.func_149207_d(), llllllllllllllIlIllIllIIllllIlII.func_149211_e(), llllllllllllllIlIllIllIIllllIlII.func_149210_f(), llllllllllllllIlIllIllIIllllIlII.func_149212_c(), llllllllllllllIlIllIllIIllllIlII.func_149208_g(), llllllllllllllIlIllIllIIllllIlII.func_149209_h(), false);
    }
    
    @Override
    public void func_175096_a(final S47PacketPlayerListHeaderFooter llllllllllllllIlIllIllIlIIlIllIl) {
        this.gameController.ingameGUI.getTabList().setHeader((llllllllllllllIlIllIllIlIIlIllIl.func_179700_a().getFormattedText().length() == 0) ? null : llllllllllllllIlIllIllIlIIlIllIl.func_179700_a());
        this.gameController.ingameGUI.getTabList().setFooter((llllllllllllllIlIllIllIlIIlIllIl.func_179701_b().getFormattedText().length() == 0) ? null : llllllllllllllIlIllIllIlIIlIllIl.func_179701_b());
    }
    
    @Override
    public void handleSpawnExperienceOrb(final S11PacketSpawnExperienceOrb llllllllllllllIlIllIlllllllIIllI) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIlllllllIIllI, this, this.gameController);
        final EntityXPOrb llllllllllllllIlIllIlllllllIIlIl = new EntityXPOrb(this.clientWorldController, llllllllllllllIlIllIlllllllIIllI.func_148984_d(), llllllllllllllIlIllIlllllllIIllI.func_148983_e(), llllllllllllllIlIllIlllllllIIllI.func_148982_f(), llllllllllllllIlIllIlllllllIIllI.func_148986_g());
        llllllllllllllIlIllIlllllllIIlIl.serverPosX = llllllllllllllIlIllIlllllllIIllI.func_148984_d();
        llllllllllllllIlIllIlllllllIIlIl.serverPosY = llllllllllllllIlIllIlllllllIIllI.func_148983_e();
        llllllllllllllIlIllIlllllllIIlIl.serverPosZ = llllllllllllllIlIllIlllllllIIllI.func_148982_f();
        llllllllllllllIlIllIlllllllIIlIl.rotationYaw = 0.0f;
        llllllllllllllIlIllIlllllllIIlIl.rotationPitch = 0.0f;
        llllllllllllllIlIllIlllllllIIlIl.setEntityId(llllllllllllllIlIllIlllllllIIllI.func_148985_c());
        this.clientWorldController.addEntityToWorld(llllllllllllllIlIllIlllllllIIllI.func_148985_c(), llllllllllllllIlIllIlllllllIIlIl);
    }
    
    @Override
    public void handleEntityAttach(final S1BPacketEntityAttach llllllllllllllIlIllIlllIlIlIIIII) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIlllIlIlIIIII, this, this.gameController);
        Object llllllllllllllIlIllIlllIlIlIIlIl = this.clientWorldController.getEntityByID(llllllllllllllIlIllIlllIlIlIIIII.func_149403_d());
        final Entity llllllllllllllIlIllIlllIlIlIIlII = this.clientWorldController.getEntityByID(llllllllllllllIlIllIlllIlIlIIIII.func_149402_e());
        if (llllllllllllllIlIllIlllIlIlIIIII.func_149404_c() == 0) {
            boolean llllllllllllllIlIllIlllIlIlIIIll = false;
            if (llllllllllllllIlIllIlllIlIlIIIII.func_149403_d() == this.gameController.thePlayer.getEntityId()) {
                llllllllllllllIlIllIlllIlIlIIlIl = this.gameController.thePlayer;
                if (llllllllllllllIlIllIlllIlIlIIlII instanceof EntityBoat) {
                    ((EntityBoat)llllllllllllllIlIllIlllIlIlIIlII).setIsBoatEmpty(false);
                }
                llllllllllllllIlIllIlllIlIlIIIll = (((Entity)llllllllllllllIlIllIlllIlIlIIlIl).ridingEntity == null && llllllllllllllIlIllIlllIlIlIIlII != null);
            }
            else if (llllllllllllllIlIllIlllIlIlIIlII instanceof EntityBoat) {
                ((EntityBoat)llllllllllllllIlIllIlllIlIlIIlII).setIsBoatEmpty(true);
            }
            if (llllllllllllllIlIllIlllIlIlIIlIl == null) {
                return;
            }
            ((Entity)llllllllllllllIlIllIlllIlIlIIlIl).mountEntity(llllllllllllllIlIllIlllIlIlIIlII);
            if (llllllllllllllIlIllIlllIlIlIIIll) {
                final GameSettings llllllllllllllIlIllIlllIlIlIIIlI = this.gameController.gameSettings;
                this.gameController.ingameGUI.setRecordPlaying(I18n.format("mount.onboard", GameSettings.getKeyDisplayString(llllllllllllllIlIllIlllIlIlIIIlI.keyBindSneak.getKeyCode())), false);
            }
        }
        else if (llllllllllllllIlIllIlllIlIlIIIII.func_149404_c() == 1 && llllllllllllllIlIllIlllIlIlIIlIl instanceof EntityLiving) {
            if (llllllllllllllIlIllIlllIlIlIIlII != null) {
                ((EntityLiving)llllllllllllllIlIllIlllIlIlIIlIl).setLeashedToEntity(llllllllllllllIlIllIlllIlIlIIlII, false);
            }
            else {
                ((EntityLiving)llllllllllllllIlIllIlllIlIlIIlIl).clearLeashed(false, false);
            }
        }
    }
    
    @Override
    public void handleParticles(final S2APacketParticles llllllllllllllIlIllIllIIIllIlllI) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIllIIIllIlllI, this, this.gameController);
        if (llllllllllllllIlIllIllIIIllIlllI.func_149222_k() == 0) {
            final double llllllllllllllIlIllIllIIIllIllIl = llllllllllllllIlIllIllIIIllIlllI.func_149227_j() * llllllllllllllIlIllIllIIIllIlllI.func_149221_g();
            final double llllllllllllllIlIllIllIIIllIllII = llllllllllllllIlIllIllIIIllIlllI.func_149227_j() * llllllllllllllIlIllIllIIIllIlllI.func_149224_h();
            final double llllllllllllllIlIllIllIIIllIlIll = llllllllllllllIlIllIllIIIllIlllI.func_149227_j() * llllllllllllllIlIllIllIIIllIlllI.func_149223_i();
            try {
                this.clientWorldController.spawnParticle(llllllllllllllIlIllIllIIIllIlllI.func_179749_a(), llllllllllllllIlIllIllIIIllIlllI.func_179750_b(), llllllllllllllIlIllIllIIIllIlllI.func_149220_d(), llllllllllllllIlIllIllIIIllIlllI.func_149226_e(), llllllllllllllIlIllIllIIIllIlllI.func_149225_f(), llllllllllllllIlIllIllIIIllIllIl, llllllllllllllIlIllIllIIIllIllII, llllllllllllllIlIllIllIIIllIlIll, llllllllllllllIlIllIllIIIllIlllI.func_179748_k());
            }
            catch (Throwable llllllllllllllIlIllIllIIIllIlIlI) {
                NetHandlerPlayClient.logger.warn(String.valueOf(new StringBuilder("Could not spawn particle effect ").append(llllllllllllllIlIllIllIIIllIlllI.func_179749_a())));
            }
        }
        else {
            for (int llllllllllllllIlIllIllIIIllIlIIl = 0; llllllllllllllIlIllIllIIIllIlIIl < llllllllllllllIlIllIllIIIllIlllI.func_149222_k(); ++llllllllllllllIlIllIllIIIllIlIIl) {
                final double llllllllllllllIlIllIllIIIllIlIII = this.avRandomizer.nextGaussian() * llllllllllllllIlIllIllIIIllIlllI.func_149221_g();
                final double llllllllllllllIlIllIllIIIllIIlll = this.avRandomizer.nextGaussian() * llllllllllllllIlIllIllIIIllIlllI.func_149224_h();
                final double llllllllllllllIlIllIllIIIllIIllI = this.avRandomizer.nextGaussian() * llllllllllllllIlIllIllIIIllIlllI.func_149223_i();
                final double llllllllllllllIlIllIllIIIllIIlIl = this.avRandomizer.nextGaussian() * llllllllllllllIlIllIllIIIllIlllI.func_149227_j();
                final double llllllllllllllIlIllIllIIIllIIlII = this.avRandomizer.nextGaussian() * llllllllllllllIlIllIllIIIllIlllI.func_149227_j();
                final double llllllllllllllIlIllIllIIIllIIIll = this.avRandomizer.nextGaussian() * llllllllllllllIlIllIllIIIllIlllI.func_149227_j();
                try {
                    this.clientWorldController.spawnParticle(llllllllllllllIlIllIllIIIllIlllI.func_179749_a(), llllllllllllllIlIllIllIIIllIlllI.func_179750_b(), llllllllllllllIlIllIllIIIllIlllI.func_149220_d() + llllllllllllllIlIllIllIIIllIlIII, llllllllllllllIlIllIllIIIllIlllI.func_149226_e() + llllllllllllllIlIllIllIIIllIIlll, llllllllllllllIlIllIllIIIllIlllI.func_149225_f() + llllllllllllllIlIllIllIIIllIIllI, llllllllllllllIlIllIllIIIllIIlIl, llllllllllllllIlIllIllIIIllIIlII, llllllllllllllIlIllIllIIIllIIIll, llllllllllllllIlIllIllIIIllIlllI.func_179748_k());
                }
                catch (Throwable llllllllllllllIlIllIllIIIllIIIlI) {
                    NetHandlerPlayClient.logger.warn(String.valueOf(new StringBuilder("Could not spawn particle effect ").append(llllllllllllllIlIllIllIIIllIlllI.func_179749_a())));
                    return;
                }
            }
        }
    }
    
    @Override
    public void handleDisconnect(final S40PacketDisconnect llllllllllllllIlIllIllllIIIIllIl) {
        this.netManager.closeChannel(llllllllllllllIlIllIllllIIIIllIl.func_149165_c());
    }
    
    @Override
    public void handleEntityHeadLook(final S19PacketEntityHeadLook llllllllllllllIlIllIllllIlIlIlll) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIllllIlIlIlll, this, this.gameController);
        final Entity llllllllllllllIlIllIllllIlIllIlI = llllllllllllllIlIllIllllIlIlIlll.func_149381_a(this.clientWorldController);
        if (llllllllllllllIlIllIllllIlIllIlI != null) {
            final float llllllllllllllIlIllIllllIlIllIIl = llllllllllllllIlIllIllllIlIlIlll.func_149380_c() * 360 / 256.0f;
            llllllllllllllIlIllIllllIlIllIlI.setRotationYawHead(llllllllllllllIlIllIllllIlIllIIl);
        }
    }
    
    @Override
    public void handleMapChunkBulk(final S26PacketMapChunkBulk llllllllllllllIlIllIllIlllIIIllI) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIllIlllIIIllI, this, this.gameController);
        for (int llllllllllllllIlIllIllIlllIIIlIl = 0; llllllllllllllIlIllIllIlllIIIlIl < llllllllllllllIlIllIllIlllIIIllI.func_149254_d(); ++llllllllllllllIlIllIllIlllIIIlIl) {
            final int llllllllllllllIlIllIllIlllIIIlII = llllllllllllllIlIllIllIlllIIIllI.func_149255_a(llllllllllllllIlIllIllIlllIIIlIl);
            final int llllllllllllllIlIllIllIlllIIIIll = llllllllllllllIlIllIllIlllIIIllI.func_149253_b(llllllllllllllIlIllIllIlllIIIlIl);
            this.clientWorldController.doPreChunk(llllllllllllllIlIllIllIlllIIIlII, llllllllllllllIlIllIllIlllIIIIll, true);
            this.clientWorldController.invalidateBlockReceiveRegion(llllllllllllllIlIllIllIlllIIIlII << 4, 0, llllllllllllllIlIllIllIlllIIIIll << 4, (llllllllllllllIlIllIllIlllIIIlII << 4) + 15, 256, (llllllllllllllIlIllIllIlllIIIIll << 4) + 15);
            final Chunk llllllllllllllIlIllIllIlllIIIIlI = this.clientWorldController.getChunkFromChunkCoords(llllllllllllllIlIllIllIlllIIIlII, llllllllllllllIlIllIllIlllIIIIll);
            llllllllllllllIlIllIllIlllIIIIlI.func_177439_a(llllllllllllllIlIllIllIlllIIIllI.func_149256_c(llllllllllllllIlIllIllIlllIIIlIl), llllllllllllllIlIllIllIlllIIIllI.func_179754_d(llllllllllllllIlIllIllIlllIIIlIl), true);
            this.clientWorldController.markBlockRangeForRenderUpdate(llllllllllllllIlIllIllIlllIIIlII << 4, 0, llllllllllllllIlIllIllIlllIIIIll << 4, (llllllllllllllIlIllIllIlllIIIlII << 4) + 15, 256, (llllllllllllllIlIllIllIlllIIIIll << 4) + 15);
            if (!(this.clientWorldController.provider instanceof WorldProviderSurface)) {
                llllllllllllllIlIllIllIlllIIIIlI.resetRelightChecks();
            }
        }
    }
    
    @Override
    public void handleCustomPayload(final S3FPacketCustomPayload llllllllllllllIlIllIllIIllIIlIlI) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIllIIllIIlIlI, this, this.gameController);
        if ("MC|TrList".equals(llllllllllllllIlIllIllIIllIIlIlI.getChannelName())) {
            final PacketBuffer llllllllllllllIlIllIllIIllIIlIIl = llllllllllllllIlIllIllIIllIIlIlI.getBufferData();
            try {
                final int llllllllllllllIlIllIllIIllIIlIII = llllllllllllllIlIllIllIIllIIlIIl.readInt();
                final GuiScreen llllllllllllllIlIllIllIIllIIIlll = this.gameController.currentScreen;
                if (llllllllllllllIlIllIllIIllIIIlll != null && llllllllllllllIlIllIllIIllIIIlll instanceof GuiMerchant && llllllllllllllIlIllIllIIllIIlIII == this.gameController.thePlayer.openContainer.windowId) {
                    final IMerchant llllllllllllllIlIllIllIIllIIIllI = ((GuiMerchant)llllllllllllllIlIllIllIIllIIIlll).getMerchant();
                    final MerchantRecipeList llllllllllllllIlIllIllIIllIIIlIl = MerchantRecipeList.func_151390_b(llllllllllllllIlIllIllIIllIIlIIl);
                    llllllllllllllIlIllIllIIllIIIllI.setRecipes(llllllllllllllIlIllIllIIllIIIlIl);
                }
            }
            catch (IOException llllllllllllllIlIllIllIIllIIIlII) {
                NetHandlerPlayClient.logger.error("Couldn't load trade info", (Throwable)llllllllllllllIlIllIllIIllIIIlII);
                return;
            }
            finally {
                llllllllllllllIlIllIllIIllIIlIIl.release();
            }
            llllllllllllllIlIllIllIIllIIlIIl.release();
        }
        else if ("MC|Brand".equals(llllllllllllllIlIllIllIIllIIlIlI.getChannelName())) {
            this.gameController.thePlayer.func_175158_f(llllllllllllllIlIllIllIIllIIlIlI.getBufferData().readStringFromBuffer(32767));
        }
        else if ("MC|BOpen".equals(llllllllllllllIlIllIllIIllIIlIlI.getChannelName())) {
            final ItemStack llllllllllllllIlIllIllIIllIIIIll = this.gameController.thePlayer.getCurrentEquippedItem();
            if (llllllllllllllIlIllIllIIllIIIIll != null && llllllllllllllIlIllIllIIllIIIIll.getItem() == Items.written_book) {
                this.gameController.displayGuiScreen(new GuiScreenBook(this.gameController.thePlayer, llllllllllllllIlIllIllIIllIIIIll, false));
            }
        }
    }
    
    public Collection func_175106_d() {
        return this.playerInfoMap.values();
    }
    
    @Override
    public void handleSetSlot(final S2FPacketSetSlot llllllllllllllIlIllIlllIIIllIlII) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIlllIIIllIlII, this, this.gameController);
        final EntityPlayerSP llllllllllllllIlIllIlllIIIllIIll = this.gameController.thePlayer;
        if (llllllllllllllIlIllIlllIIIllIlII.func_149175_c() == -1) {
            llllllllllllllIlIllIlllIIIllIIll.inventory.setItemStack(llllllllllllllIlIllIlllIIIllIlII.func_149174_e());
        }
        else {
            boolean llllllllllllllIlIllIlllIIIllIIlI = false;
            if (this.gameController.currentScreen instanceof GuiContainerCreative) {
                final GuiContainerCreative llllllllllllllIlIllIlllIIIllIIIl = (GuiContainerCreative)this.gameController.currentScreen;
                llllllllllllllIlIllIlllIIIllIIlI = (llllllllllllllIlIllIlllIIIllIIIl.func_147056_g() != CreativeTabs.tabInventory.getTabIndex());
            }
            if (llllllllllllllIlIllIlllIIIllIlII.func_149175_c() == 0 && llllllllllllllIlIllIlllIIIllIlII.func_149173_d() >= 36 && llllllllllllllIlIllIlllIIIllIlII.func_149173_d() < 45) {
                final ItemStack llllllllllllllIlIllIlllIIIllIIII = llllllllllllllIlIllIlllIIIllIIll.inventoryContainer.getSlot(llllllllllllllIlIllIlllIIIllIlII.func_149173_d()).getStack();
                if (llllllllllllllIlIllIlllIIIllIlII.func_149174_e() != null && (llllllllllllllIlIllIlllIIIllIIII == null || llllllllllllllIlIllIlllIIIllIIII.stackSize < llllllllllllllIlIllIlllIIIllIlII.func_149174_e().stackSize)) {
                    llllllllllllllIlIllIlllIIIllIlII.func_149174_e().animationsToGo = 5;
                }
                llllllllllllllIlIllIlllIIIllIIll.inventoryContainer.putStackInSlot(llllllllllllllIlIllIlllIIIllIlII.func_149173_d(), llllllllllllllIlIllIlllIIIllIlII.func_149174_e());
            }
            else if (llllllllllllllIlIllIlllIIIllIlII.func_149175_c() == llllllllllllllIlIllIlllIIIllIIll.openContainer.windowId && (llllllllllllllIlIllIlllIIIllIlII.func_149175_c() != 0 || !llllllllllllllIlIllIlllIIIllIIlI)) {
                llllllllllllllIlIllIlllIIIllIIll.openContainer.putStackInSlot(llllllllllllllIlIllIlllIIIllIlII.func_149173_d(), llllllllllllllIlIllIlllIIIllIlII.func_149174_e());
            }
        }
    }
    
    @Override
    public void handleAnimation(final S0BPacketAnimation llllllllllllllIlIllIlllIlllIIlII) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIlllIlllIIlII, this, this.gameController);
        final Entity llllllllllllllIlIllIlllIlllIlIII = this.clientWorldController.getEntityByID(llllllllllllllIlIllIlllIlllIIlII.func_148978_c());
        if (llllllllllllllIlIllIlllIlllIlIII != null) {
            if (llllllllllllllIlIllIlllIlllIIlII.func_148977_d() == 0) {
                final EntityLivingBase llllllllllllllIlIllIlllIlllIIlll = (EntityLivingBase)llllllllllllllIlIllIlllIlllIlIII;
                llllllllllllllIlIllIlllIlllIIlll.swingItem();
            }
            else if (llllllllllllllIlIllIlllIlllIIlII.func_148977_d() == 1) {
                llllllllllllllIlIllIlllIlllIlIII.performHurtAnimation();
            }
            else if (llllllllllllllIlIllIlllIlllIIlII.func_148977_d() == 2) {
                final EntityPlayer llllllllllllllIlIllIlllIlllIIllI = (EntityPlayer)llllllllllllllIlIllIlllIlllIlIII;
                llllllllllllllIlIllIlllIlllIIllI.wakeUpPlayer(false, false, false);
            }
            else if (llllllllllllllIlIllIlllIlllIIlII.func_148977_d() == 4) {
                this.gameController.effectRenderer.func_178926_a(llllllllllllllIlIllIlllIlllIlIII, EnumParticleTypes.CRIT);
            }
            else if (llllllllllllllIlIllIlllIlllIIlII.func_148977_d() == 5) {
                this.gameController.effectRenderer.func_178926_a(llllllllllllllIlIllIlllIlllIlIII, EnumParticleTypes.CRIT_MAGIC);
            }
        }
    }
    
    @Override
    public void handleMaps(final S34PacketMaps llllllllllllllIlIllIllIllIlIIIlI) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIllIllIlIIIlI, this, this.gameController);
        final MapData llllllllllllllIlIllIllIllIlIIIIl = ItemMap.loadMapData(llllllllllllllIlIllIllIllIlIIIlI.getMapId(), this.gameController.theWorld);
        llllllllllllllIlIllIllIllIlIIIlI.func_179734_a(llllllllllllllIlIllIllIllIlIIIIl);
        this.gameController.entityRenderer.getMapItemRenderer().func_148246_a(llllllllllllllIlIllIllIllIlIIIIl);
    }
    
    @Override
    public void handleEffect(final S28PacketEffect llllllllllllllIlIllIllIllIIllIII) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIllIllIIllIII, this, this.gameController);
        if (llllllllllllllIlIllIllIllIIllIII.isSoundServerwide()) {
            this.gameController.theWorld.func_175669_a(llllllllllllllIlIllIllIllIIllIII.getSoundType(), llllllllllllllIlIllIllIllIIllIII.func_179746_d(), llllllllllllllIlIllIllIllIIllIII.getSoundData());
        }
        else {
            this.gameController.theWorld.playAuxSFX(llllllllllllllIlIllIllIllIIllIII.getSoundType(), llllllllllllllIlIllIllIllIIllIII.func_179746_d(), llllllllllllllIlIllIllIllIIllIII.getSoundData());
        }
    }
    
    @Override
    public void handleEntityVelocity(final S12PacketEntityVelocity llllllllllllllIlIllIlllllIllllll) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIlllllIllllll, this, this.gameController);
        final Entity llllllllllllllIlIllIllllllIIIIIl = this.clientWorldController.getEntityByID(llllllllllllllIlIllIlllllIllllll.func_149412_c());
        if (llllllllllllllIlIllIllllllIIIIIl != null) {
            llllllllllllllIlIllIllllllIIIIIl.setVelocity(llllllllllllllIlIllIlllllIllllll.func_149411_d() / 8000.0, llllllllllllllIlIllIlllllIllllll.func_149410_e() / 8000.0, llllllllllllllIlIllIlllllIllllll.func_149409_f() / 8000.0);
        }
    }
    
    @Override
    public void handleSignEditorOpen(final S36PacketSignEditorOpen llllllllllllllIlIllIlllIIIIIlllI) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIlllIIIIIlllI, this, this.gameController);
        Object llllllllllllllIlIllIlllIIIIlIIII = this.clientWorldController.getTileEntity(llllllllllllllIlIllIlllIIIIIlllI.func_179777_a());
        if (!(llllllllllllllIlIllIlllIIIIlIIII instanceof TileEntitySign)) {
            llllllllllllllIlIllIlllIIIIlIIII = new TileEntitySign();
            ((TileEntity)llllllllllllllIlIllIlllIIIIlIIII).setWorldObj(this.clientWorldController);
            ((TileEntity)llllllllllllllIlIllIlllIIIIlIIII).setPos(llllllllllllllIlIllIlllIIIIIlllI.func_179777_a());
        }
        this.gameController.thePlayer.func_175141_a((TileEntitySign)llllllllllllllIlIllIlllIIIIlIIII);
    }
    
    @Override
    public void handleEntityProperties(final S20PacketEntityProperties llllllllllllllIlIllIllIIIlIIlIlI) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIllIIIlIIlIlI, this, this.gameController);
        final Entity llllllllllllllIlIllIllIIIlIIlIIl = this.clientWorldController.getEntityByID(llllllllllllllIlIllIllIIIlIIlIlI.func_149442_c());
        if (llllllllllllllIlIllIllIIIlIIlIIl != null) {
            if (!(llllllllllllllIlIllIllIIIlIIlIIl instanceof EntityLivingBase)) {
                throw new IllegalStateException(String.valueOf(new StringBuilder("Server tried to update attributes of a non-living entity (actually: ").append(llllllllllllllIlIllIllIIIlIIlIIl).append(")")));
            }
            final BaseAttributeMap llllllllllllllIlIllIllIIIlIIlIII = ((EntityLivingBase)llllllllllllllIlIllIllIIIlIIlIIl).getAttributeMap();
            for (final S20PacketEntityProperties.Snapshot llllllllllllllIlIllIllIIIlIIIllI : llllllllllllllIlIllIllIIIlIIlIlI.func_149441_d()) {
                IAttributeInstance llllllllllllllIlIllIllIIIlIIIlIl = llllllllllllllIlIllIllIIIlIIlIII.getAttributeInstanceByName(llllllllllllllIlIllIllIIIlIIIllI.func_151409_a());
                if (llllllllllllllIlIllIllIIIlIIIlIl == null) {
                    llllllllllllllIlIllIllIIIlIIIlIl = llllllllllllllIlIllIllIIIlIIlIII.registerAttribute(new RangedAttribute(null, llllllllllllllIlIllIllIIIlIIIllI.func_151409_a(), 0.0, Double.MIN_NORMAL, Double.MAX_VALUE));
                }
                llllllllllllllIlIllIllIIIlIIIlIl.setBaseValue(llllllllllllllIlIllIllIIIlIIIllI.func_151410_b());
                llllllllllllllIlIllIllIIIlIIIlIl.removeAllModifiers();
                for (final AttributeModifier llllllllllllllIlIllIllIIIlIIIIll : llllllllllllllIlIllIllIIIlIIIllI.func_151408_c()) {
                    llllllllllllllIlIllIllIIIlIIIlIl.applyModifier(llllllllllllllIlIllIllIIIlIIIIll);
                }
            }
        }
    }
    
    @Override
    public void handleTimeUpdate(final S03PacketTimeUpdate llllllllllllllIlIllIlllIlIllIllI) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIlllIlIllIllI, this, this.gameController);
        this.gameController.theWorld.func_82738_a(llllllllllllllIlIllIlllIlIllIllI.func_149366_c());
        this.gameController.theWorld.setWorldTime(llllllllllllllIlIllIlllIlIllIllI.func_149365_d());
    }
    
    @Override
    public void handleWindowProperty(final S31PacketWindowProperty llllllllllllllIlIllIllIllllIlIlI) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIllIllllIlIlI, this, this.gameController);
        final EntityPlayerSP llllllllllllllIlIllIllIllllIllII = this.gameController.thePlayer;
        if (llllllllllllllIlIllIllIllllIllII.openContainer != null && llllllllllllllIlIllIllIllllIllII.openContainer.windowId == llllllllllllllIlIllIllIllllIlIlI.func_149182_c()) {
            llllllllllllllIlIllIllIllllIllII.openContainer.updateProgressBar(llllllllllllllIlIllIllIllllIlIlI.func_149181_d(), llllllllllllllIlIllIllIllllIlIlI.func_149180_e());
        }
    }
    
    static /* synthetic */ void access$2(final NetHandlerPlayClient llllllllllllllIlIllIllIIIIIllIII, final Minecraft llllllllllllllIlIllIllIIIIIlIlll) {
        llllllllllllllIlIllIllIIIIIllIII.gameController = llllllllllllllIlIllIllIIIIIlIlll;
    }
    
    @Override
    public void handleUpdateScore(final S3CPacketUpdateScore llllllllllllllIlIllIllIIlIlIIIlI) {
        PacketThreadUtil.func_180031_a(llllllllllllllIlIllIllIIlIlIIIlI, this, this.gameController);
        final Scoreboard llllllllllllllIlIllIllIIlIlIIllI = this.clientWorldController.getScoreboard();
        final ScoreObjective llllllllllllllIlIllIllIIlIlIIlIl = llllllllllllllIlIllIllIIlIlIIllI.getObjective(llllllllllllllIlIllIllIIlIlIIIlI.func_149321_d());
        if (llllllllllllllIlIllIllIIlIlIIIlI.func_180751_d() == S3CPacketUpdateScore.Action.CHANGE) {
            final Score llllllllllllllIlIllIllIIlIlIIlII = llllllllllllllIlIllIllIIlIlIIllI.getValueFromObjective(llllllllllllllIlIllIllIIlIlIIIlI.func_149324_c(), llllllllllllllIlIllIllIIlIlIIlIl);
            llllllllllllllIlIllIllIIlIlIIlII.setScorePoints(llllllllllllllIlIllIllIIlIlIIIlI.func_149323_e());
        }
        else if (llllllllllllllIlIllIllIIlIlIIIlI.func_180751_d() == S3CPacketUpdateScore.Action.REMOVE) {
            if (StringUtils.isNullOrEmpty(llllllllllllllIlIllIllIIlIlIIIlI.func_149321_d())) {
                llllllllllllllIlIllIllIIlIlIIllI.func_178822_d(llllllllllllllIlIllIllIIlIlIIIlI.func_149324_c(), null);
            }
            else if (llllllllllllllIlIllIllIIlIlIIlIl != null) {
                llllllllllllllIlIllIllIIlIlIIllI.func_178822_d(llllllllllllllIlIllIllIIlIlIIIlI.func_149324_c(), llllllllllllllIlIllIllIIlIlIIlIl);
            }
        }
    }
    
    static {
        __OBFID = "CL_00000878";
        logger = LogManager.getLogger();
    }
    
    static final class SwitchAction
    {
        static final /* synthetic */ int[] field_178885_a;
        static final /* synthetic */ int[] field_178884_b;
        
        static {
            __OBFID = "CL_00002620";
            field_178884_b = new int[S38PacketPlayerListItem.Action.values().length];
            try {
                SwitchAction.field_178884_b[S38PacketPlayerListItem.Action.ADD_PLAYER.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchAction.field_178884_b[S38PacketPlayerListItem.Action.UPDATE_GAME_MODE.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchAction.field_178884_b[S38PacketPlayerListItem.Action.UPDATE_LATENCY.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchAction.field_178884_b[S38PacketPlayerListItem.Action.UPDATE_DISPLAY_NAME.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            field_178885_a = new int[S45PacketTitle.Type.values().length];
            try {
                SwitchAction.field_178885_a[S45PacketTitle.Type.TITLE.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                SwitchAction.field_178885_a[S45PacketTitle.Type.SUBTITLE.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
            try {
                SwitchAction.field_178885_a[S45PacketTitle.Type.RESET.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError7) {}
        }
    }
}
