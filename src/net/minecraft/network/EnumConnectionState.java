package net.minecraft.network;

import gnu.trove.map.*;
import net.minecraft.network.handshake.client.*;
import net.minecraft.network.play.server.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.status.client.*;
import net.minecraft.network.status.server.*;
import net.minecraft.network.login.server.*;
import net.minecraft.network.login.client.*;
import gnu.trove.map.hash.*;
import java.util.*;
import com.google.common.collect.*;
import org.apache.logging.log4j.*;

public enum EnumConnectionState
{
    private static final /* synthetic */ TIntObjectMap STATES_BY_ID;
    private final /* synthetic */ Map directionMaps;
    
    LOGIN(3, "LOGIN", 3, 2, (Object)null) {
        static {
            __OBFID = "CL_00001249";
        }
        
        {
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S00PacketDisconnect.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S01PacketEncryptionRequest.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S02PacketLoginSuccess.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S03PacketEnableCompression.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, C00PacketLoginStart.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, C01PacketEncryptionResponse.class);
        }
    }, 
    STATUS(2, "STATUS", 2, 1, (Object)null) {
        {
            this.registerPacket(EnumPacketDirection.SERVERBOUND, C00PacketServerQuery.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S00PacketServerInfo.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, C01PacketPing.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S01PacketPong.class);
        }
        
        static {
            __OBFID = "CL_00001247";
        }
    }, 
    HANDSHAKING(0, "HANDSHAKING", 0, -1, (Object)null) {
        static {
            __OBFID = "CL_00001246";
        }
        
        {
            this.registerPacket(EnumPacketDirection.SERVERBOUND, C00Handshake.class);
        }
    };
    
    private final /* synthetic */ int id;
    private static final /* synthetic */ Map STATES_BY_CLASS;
    
    PLAY(1, "PLAY", 1, 0, (Object)null) {
        {
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S00PacketKeepAlive.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S01PacketJoinGame.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S02PacketChat.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S03PacketTimeUpdate.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S04PacketEntityEquipment.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S05PacketSpawnPosition.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S06PacketUpdateHealth.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S07PacketRespawn.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S08PacketPlayerPosLook.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S09PacketHeldItemChange.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S0APacketUseBed.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S0BPacketAnimation.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S0CPacketSpawnPlayer.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S0DPacketCollectItem.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S0EPacketSpawnObject.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S0FPacketSpawnMob.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S10PacketSpawnPainting.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S11PacketSpawnExperienceOrb.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S12PacketEntityVelocity.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S13PacketDestroyEntities.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S14PacketEntity.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S14PacketEntity.S15PacketEntityRelMove.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S14PacketEntity.S16PacketEntityLook.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S14PacketEntity.S17PacketEntityLookMove.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S18PacketEntityTeleport.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S19PacketEntityHeadLook.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S19PacketEntityStatus.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S1BPacketEntityAttach.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S1CPacketEntityMetadata.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S1DPacketEntityEffect.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S1EPacketRemoveEntityEffect.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S1FPacketSetExperience.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S20PacketEntityProperties.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S21PacketChunkData.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S22PacketMultiBlockChange.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S23PacketBlockChange.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S24PacketBlockAction.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S25PacketBlockBreakAnim.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S26PacketMapChunkBulk.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S27PacketExplosion.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S28PacketEffect.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S29PacketSoundEffect.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S2APacketParticles.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S2BPacketChangeGameState.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S2CPacketSpawnGlobalEntity.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S2DPacketOpenWindow.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S2EPacketCloseWindow.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S2FPacketSetSlot.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S30PacketWindowItems.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S31PacketWindowProperty.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S32PacketConfirmTransaction.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S33PacketUpdateSign.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S34PacketMaps.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S35PacketUpdateTileEntity.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S36PacketSignEditorOpen.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S37PacketStatistics.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S38PacketPlayerListItem.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S39PacketPlayerAbilities.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S3APacketTabComplete.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S3BPacketScoreboardObjective.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S3CPacketUpdateScore.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S3DPacketDisplayScoreboard.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S3EPacketTeams.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S3FPacketCustomPayload.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S40PacketDisconnect.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S41PacketServerDifficulty.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S42PacketCombatEvent.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S43PacketCamera.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S44PacketWorldBorder.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S45PacketTitle.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S46PacketSetCompressionLevel.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S47PacketPlayerListHeaderFooter.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S48PacketResourcePackSend.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, S49PacketUpdateEntityNBT.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, C00PacketKeepAlive.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, C01PacketChatMessage.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, C02PacketUseEntity.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, C03PacketPlayer.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, C03PacketPlayer.C04PacketPlayerPosition.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, C03PacketPlayer.C05PacketPlayerLook.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, C03PacketPlayer.C06PacketPlayerPosLook.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, C07PacketPlayerDigging.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, C08PacketPlayerBlockPlacement.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, C09PacketHeldItemChange.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, C0APacketAnimation.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, C0BPacketEntityAction.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, C0CPacketInput.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, C0DPacketCloseWindow.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, C0EPacketClickWindow.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, C0FPacketConfirmTransaction.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, C10PacketCreativeInventoryAction.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, C11PacketEnchantItem.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, C12PacketUpdateSign.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, C13PacketPlayerAbilities.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, C14PacketTabComplete.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, C15PacketClientSettings.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, C16PacketClientStatus.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, C17PacketCustomPayload.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, C18PacketSpectate.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, C19PacketResourcePackStatus.class);
        }
        
        static {
            __OBFID = "CL_00001250";
        }
    };
    
    static {
        __OBFID = "CL_00001245";
        STATES_BY_ID = (TIntObjectMap)new TIntObjectHashMap();
        STATES_BY_CLASS = Maps.newHashMap();
        for (final EnumConnectionState lllllllllllllllIIlllllllIllIlIIl : values()) {
            EnumConnectionState.STATES_BY_ID.put(lllllllllllllllIIlllllllIllIlIIl.getId(), (Object)lllllllllllllllIIlllllllIllIlIIl);
            for (final EnumPacketDirection lllllllllllllllIIlllllllIllIIlll : lllllllllllllllIIlllllllIllIlIIl.directionMaps.keySet()) {
                for (final Class lllllllllllllllIIlllllllIllIIllI : lllllllllllllllIIlllllllIllIlIIl.directionMaps.get(lllllllllllllllIIlllllllIllIIlll).values()) {
                    if (EnumConnectionState.STATES_BY_CLASS.containsKey(lllllllllllllllIIlllllllIllIIllI) && EnumConnectionState.STATES_BY_CLASS.get(lllllllllllllllIIlllllllIllIIllI) != lllllllllllllllIIlllllllIllIlIIl) {
                        throw new Error(String.valueOf(new StringBuilder("Packet ").append(lllllllllllllllIIlllllllIllIIllI).append(" is already assigned to protocol ").append(EnumConnectionState.STATES_BY_CLASS.get(lllllllllllllllIIlllllllIllIIllI)).append(" - can't reassign to ").append(lllllllllllllllIIlllllllIllIlIIl)));
                    }
                    try {
                        lllllllllllllllIIlllllllIllIIllI.newInstance();
                    }
                    catch (Throwable lllllllllllllllIIlllllllIllIIlII) {
                        throw new Error(String.valueOf(new StringBuilder("Packet ").append(lllllllllllllllIIlllllllIllIIllI).append(" fails instantiation checks! ").append(lllllllllllllllIIlllllllIllIIllI)));
                    }
                    EnumConnectionState.STATES_BY_CLASS.put(lllllllllllllllIIlllllllIllIIllI, lllllllllllllllIIlllllllIllIlIIl);
                }
            }
        }
    }
    
    public static EnumConnectionState getFromPacket(final Packet lllllllllllllllIIlllllllIIlIIIlI) {
        return EnumConnectionState.STATES_BY_CLASS.get(lllllllllllllllIIlllllllIIlIIIlI.getClass());
    }
    
    private EnumConnectionState(final String lllllllllllllllIIlllllllIlIlIIIl, final int lllllllllllllllIIlllllllIlIlIIII, final String lllllllllllllllIIlllllllIlIlIlIl, final int lllllllllllllllIIlllllllIlIlIlII, final int lllllllllllllllIIlllllllIlIIllll) {
        this.directionMaps = Maps.newEnumMap((Class)EnumPacketDirection.class);
        this.id = lllllllllllllllIIlllllllIlIIllll;
    }
    
    public int getId() {
        return this.id;
    }
    
    public Packet getPacket(final EnumPacketDirection lllllllllllllllIIlllllllIIlIllIl, final int lllllllllllllllIIlllllllIIlIllII) throws InstantiationException, IllegalAccessException {
        final Class lllllllllllllllIIlllllllIIlIllll = (Class)this.directionMaps.get(lllllllllllllllIIlllllllIIlIllIl).get((Object)lllllllllllllllIIlllllllIIlIllII);
        return (lllllllllllllllIIlllllllIIlIllll == null) ? null : lllllllllllllllIIlllllllIIlIllll.newInstance();
    }
    
    protected EnumConnectionState registerPacket(final EnumPacketDirection lllllllllllllllIIlllllllIlIIIIll, final Class lllllllllllllllIIlllllllIlIIIIlI) {
        Object lllllllllllllllIIlllllllIlIIIllI = this.directionMaps.get(lllllllllllllllIIlllllllIlIIIIll);
        if (lllllllllllllllIIlllllllIlIIIllI == null) {
            lllllllllllllllIIlllllllIlIIIllI = HashBiMap.create();
            this.directionMaps.put(lllllllllllllllIIlllllllIlIIIIll, lllllllllllllllIIlllllllIlIIIllI);
        }
        if (((BiMap)lllllllllllllllIIlllllllIlIIIllI).containsValue((Object)lllllllllllllllIIlllllllIlIIIIlI)) {
            final String lllllllllllllllIIlllllllIlIIIlIl = String.valueOf(new StringBuilder().append(lllllllllllllllIIlllllllIlIIIIll).append(" packet ").append(lllllllllllllllIIlllllllIlIIIIlI).append(" is already known to ID ").append(((BiMap)lllllllllllllllIIlllllllIlIIIllI).inverse().get((Object)lllllllllllllllIIlllllllIlIIIIlI)));
            LogManager.getLogger().fatal(lllllllllllllllIIlllllllIlIIIlIl);
            throw new IllegalArgumentException(lllllllllllllllIIlllllllIlIIIlIl);
        }
        ((BiMap)lllllllllllllllIIlllllllIlIIIllI).put((Object)((BiMap)lllllllllllllllIIlllllllIlIIIllI).size(), (Object)lllllllllllllllIIlllllllIlIIIIlI);
        return this;
    }
    
    public Integer getPacketId(final EnumPacketDirection lllllllllllllllIIlllllllIIlllIII, final Packet lllllllllllllllIIlllllllIIlllIlI) {
        return (Integer)this.directionMaps.get(lllllllllllllllIIlllllllIIlllIII).inverse().get((Object)lllllllllllllllIIlllllllIIlllIlI.getClass());
    }
    
    private EnumConnectionState(final String lllllllllllllllIIlllllllIIIlIlIl, final int lllllllllllllllIIlllllllIIIlIlII, final String lllllllllllllllIIlllllllIIIlIIll, final int lllllllllllllllIIlllllllIIIlIIlI, final int lllllllllllllllIIlllllllIIIlIIIl, final Object lllllllllllllllIIlllllllIIIlIlll) {
        this(lllllllllllllllIIlllllllIIIlIlIl, lllllllllllllllIIlllllllIIIlIlII, lllllllllllllllIIlllllllIIIlIIll, lllllllllllllllIIlllllllIIIlIIlI, lllllllllllllllIIlllllllIIIlIIIl);
    }
    
    public static EnumConnectionState getById(final int lllllllllllllllIIlllllllIIlIIlIl) {
        return (EnumConnectionState)EnumConnectionState.STATES_BY_ID.get(lllllllllllllllIIlllllllIIlIIlIl);
    }
}
