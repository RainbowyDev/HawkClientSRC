package net.minecraft.entity;

import com.google.common.collect.*;
import net.minecraft.network.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.block.*;
import net.minecraft.entity.item.*;
import net.minecraft.util.*;
import org.apache.logging.log4j.*;
import net.minecraft.entity.ai.attributes.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.world.storage.*;
import net.minecraft.potion.*;
import net.minecraft.network.play.server.*;
import net.minecraft.nbt.*;

public class EntityTrackerEntry
{
    public /* synthetic */ int updateCounter;
    public /* synthetic */ Set trackingPlayers;
    private /* synthetic */ int ticksSinceLastForcedTeleport;
    public /* synthetic */ Entity trackedEntity;
    private static final /* synthetic */ Logger logger;
    public /* synthetic */ boolean playerEntitiesUpdated;
    private /* synthetic */ boolean field_180234_y;
    public /* synthetic */ double motionZ;
    public /* synthetic */ double lastTrackedEntityMotionX;
    public /* synthetic */ int encodedRotationPitch;
    private /* synthetic */ double lastTrackedEntityPosZ;
    private /* synthetic */ boolean firstUpdateDone;
    public /* synthetic */ int trackingDistanceThreshold;
    public /* synthetic */ int encodedPosY;
    private /* synthetic */ boolean ridingEntity;
    public /* synthetic */ int encodedPosX;
    public /* synthetic */ int lastHeadMotion;
    public /* synthetic */ int encodedRotationYaw;
    private /* synthetic */ double lastTrackedEntityPosY;
    public /* synthetic */ double lastTrackedEntityMotionY;
    public /* synthetic */ int encodedPosZ;
    private /* synthetic */ boolean sendVelocityUpdates;
    private /* synthetic */ double lastTrackedEntityPosX;
    private /* synthetic */ Entity field_85178_v;
    public /* synthetic */ int updateFrequency;
    
    public EntityTrackerEntry(final Entity lIllIlllIlIlll, final int lIllIlllIlIllI, final int lIllIlllIlIlIl, final boolean lIllIlllIlIlII) {
        this.trackingPlayers = Sets.newHashSet();
        this.trackedEntity = lIllIlllIlIlll;
        this.trackingDistanceThreshold = lIllIlllIlIllI;
        this.updateFrequency = lIllIlllIlIlIl;
        this.sendVelocityUpdates = lIllIlllIlIlII;
        this.encodedPosX = MathHelper.floor_double(lIllIlllIlIlll.posX * 32.0);
        this.encodedPosY = MathHelper.floor_double(lIllIlllIlIlll.posY * 32.0);
        this.encodedPosZ = MathHelper.floor_double(lIllIlllIlIlll.posZ * 32.0);
        this.encodedRotationYaw = MathHelper.floor_float(lIllIlllIlIlll.rotationYaw * 256.0f / 360.0f);
        this.encodedRotationPitch = MathHelper.floor_float(lIllIlllIlIlll.rotationPitch * 256.0f / 360.0f);
        this.lastHeadMotion = MathHelper.floor_float(lIllIlllIlIlll.getRotationYawHead() * 256.0f / 360.0f);
        this.field_180234_y = lIllIlllIlIlll.onGround;
    }
    
    public void func_151259_a(final Packet lIllIlIlllIlIl) {
        for (final EntityPlayerMP lIllIlIlllIlll : this.trackingPlayers) {
            lIllIlIlllIlll.playerNetServerHandler.sendPacket(lIllIlIlllIlIl);
        }
    }
    
    private Packet func_151260_c() {
        if (this.trackedEntity.isDead) {
            EntityTrackerEntry.logger.warn("Fetching addPacket for removed entity");
        }
        if (this.trackedEntity instanceof EntityItem) {
            return new S0EPacketSpawnObject(this.trackedEntity, 2, 1);
        }
        if (this.trackedEntity instanceof EntityPlayerMP) {
            return new S0CPacketSpawnPlayer((EntityPlayer)this.trackedEntity);
        }
        if (this.trackedEntity instanceof EntityMinecart) {
            final EntityMinecart lIllIlIIlIIIll = (EntityMinecart)this.trackedEntity;
            return new S0EPacketSpawnObject(this.trackedEntity, 10, lIllIlIIlIIIll.func_180456_s().func_180039_a());
        }
        if (this.trackedEntity instanceof EntityBoat) {
            return new S0EPacketSpawnObject(this.trackedEntity, 1);
        }
        if (this.trackedEntity instanceof IAnimals) {
            this.lastHeadMotion = MathHelper.floor_float(this.trackedEntity.getRotationYawHead() * 256.0f / 360.0f);
            return new S0FPacketSpawnMob((EntityLivingBase)this.trackedEntity);
        }
        if (this.trackedEntity instanceof EntityFishHook) {
            final EntityPlayer lIllIlIIlIIIlI = ((EntityFishHook)this.trackedEntity).angler;
            return new S0EPacketSpawnObject(this.trackedEntity, 90, (lIllIlIIlIIIlI != null) ? lIllIlIIlIIIlI.getEntityId() : this.trackedEntity.getEntityId());
        }
        if (this.trackedEntity instanceof EntityArrow) {
            final Entity lIllIlIIlIIIIl = ((EntityArrow)this.trackedEntity).shootingEntity;
            return new S0EPacketSpawnObject(this.trackedEntity, 60, (lIllIlIIlIIIIl != null) ? lIllIlIIlIIIIl.getEntityId() : this.trackedEntity.getEntityId());
        }
        if (this.trackedEntity instanceof EntitySnowball) {
            return new S0EPacketSpawnObject(this.trackedEntity, 61);
        }
        if (this.trackedEntity instanceof EntityPotion) {
            return new S0EPacketSpawnObject(this.trackedEntity, 73, ((EntityPotion)this.trackedEntity).getPotionDamage());
        }
        if (this.trackedEntity instanceof EntityExpBottle) {
            return new S0EPacketSpawnObject(this.trackedEntity, 75);
        }
        if (this.trackedEntity instanceof EntityEnderPearl) {
            return new S0EPacketSpawnObject(this.trackedEntity, 65);
        }
        if (this.trackedEntity instanceof EntityEnderEye) {
            return new S0EPacketSpawnObject(this.trackedEntity, 72);
        }
        if (this.trackedEntity instanceof EntityFireworkRocket) {
            return new S0EPacketSpawnObject(this.trackedEntity, 76);
        }
        if (this.trackedEntity instanceof EntityFireball) {
            final EntityFireball lIllIlIIIlllIl = (EntityFireball)this.trackedEntity;
            S0EPacketSpawnObject lIllIlIIlIIIII = null;
            byte lIllIlIIIlllII = 63;
            if (this.trackedEntity instanceof EntitySmallFireball) {
                lIllIlIIIlllII = 64;
            }
            else if (this.trackedEntity instanceof EntityWitherSkull) {
                lIllIlIIIlllII = 66;
            }
            if (lIllIlIIIlllIl.shootingEntity != null) {
                lIllIlIIlIIIII = new S0EPacketSpawnObject(this.trackedEntity, lIllIlIIIlllII, ((EntityFireball)this.trackedEntity).shootingEntity.getEntityId());
            }
            else {
                lIllIlIIlIIIII = new S0EPacketSpawnObject(this.trackedEntity, lIllIlIIIlllII, 0);
            }
            lIllIlIIlIIIII.func_149003_d((int)(lIllIlIIIlllIl.accelerationX * 8000.0));
            lIllIlIIlIIIII.func_149000_e((int)(lIllIlIIIlllIl.accelerationY * 8000.0));
            lIllIlIIlIIIII.func_149007_f((int)(lIllIlIIIlllIl.accelerationZ * 8000.0));
            return lIllIlIIlIIIII;
        }
        if (this.trackedEntity instanceof EntityEgg) {
            return new S0EPacketSpawnObject(this.trackedEntity, 62);
        }
        if (this.trackedEntity instanceof EntityTNTPrimed) {
            return new S0EPacketSpawnObject(this.trackedEntity, 50);
        }
        if (this.trackedEntity instanceof EntityEnderCrystal) {
            return new S0EPacketSpawnObject(this.trackedEntity, 51);
        }
        if (this.trackedEntity instanceof EntityFallingBlock) {
            final EntityFallingBlock lIllIlIIIllIll = (EntityFallingBlock)this.trackedEntity;
            return new S0EPacketSpawnObject(this.trackedEntity, 70, Block.getStateId(lIllIlIIIllIll.getBlock()));
        }
        if (this.trackedEntity instanceof EntityArmorStand) {
            return new S0EPacketSpawnObject(this.trackedEntity, 78);
        }
        if (this.trackedEntity instanceof EntityPainting) {
            return new S10PacketSpawnPainting((EntityPainting)this.trackedEntity);
        }
        if (this.trackedEntity instanceof EntityItemFrame) {
            final EntityItemFrame lIllIlIIIllIII = (EntityItemFrame)this.trackedEntity;
            final S0EPacketSpawnObject lIllIlIIIlllll = new S0EPacketSpawnObject(this.trackedEntity, 71, lIllIlIIIllIII.field_174860_b.getHorizontalIndex());
            final BlockPos lIllIlIIIllIlI = lIllIlIIIllIII.func_174857_n();
            lIllIlIIIlllll.func_148996_a(MathHelper.floor_float((float)(lIllIlIIIllIlI.getX() * 32)));
            lIllIlIIIlllll.func_148995_b(MathHelper.floor_float((float)(lIllIlIIIllIlI.getY() * 32)));
            lIllIlIIIlllll.func_149005_c(MathHelper.floor_float((float)(lIllIlIIIllIlI.getZ() * 32)));
            return lIllIlIIIlllll;
        }
        if (this.trackedEntity instanceof EntityLeashKnot) {
            final EntityLeashKnot lIllIlIIIlIlll = (EntityLeashKnot)this.trackedEntity;
            final S0EPacketSpawnObject lIllIlIIIllllI = new S0EPacketSpawnObject(this.trackedEntity, 77);
            final BlockPos lIllIlIIIllIIl = lIllIlIIIlIlll.func_174857_n();
            lIllIlIIIllllI.func_148996_a(MathHelper.floor_float((float)(lIllIlIIIllIIl.getX() * 32)));
            lIllIlIIIllllI.func_148995_b(MathHelper.floor_float((float)(lIllIlIIIllIIl.getY() * 32)));
            lIllIlIIIllllI.func_149005_c(MathHelper.floor_float((float)(lIllIlIIIllIIl.getZ() * 32)));
            return lIllIlIIIllllI;
        }
        if (this.trackedEntity instanceof EntityXPOrb) {
            return new S11PacketSpawnExperienceOrb((EntityXPOrb)this.trackedEntity);
        }
        throw new IllegalArgumentException(String.valueOf(new StringBuilder("Don't know how to add ").append(this.trackedEntity.getClass()).append("!")));
    }
    
    static {
        __OBFID = "CL_00001443";
        logger = LogManager.getLogger();
    }
    
    public void func_151261_b(final Packet lIllIlIllIllll) {
        this.func_151259_a(lIllIlIllIllll);
        if (this.trackedEntity instanceof EntityPlayerMP) {
            ((EntityPlayerMP)this.trackedEntity).playerNetServerHandler.sendPacket(lIllIlIllIllll);
        }
    }
    
    public void removeTrackedPlayerSymmetric(final EntityPlayerMP lIllIlIIIIllIl) {
        if (this.trackingPlayers.contains(lIllIlIIIIllIl)) {
            this.trackingPlayers.remove(lIllIlIIIIllIl);
            lIllIlIIIIllIl.func_152339_d(this.trackedEntity);
        }
    }
    
    public boolean func_180233_c(final EntityPlayerMP lIllIlIIlllIlI) {
        final double lIllIlIIllllIl = lIllIlIIlllIlI.posX - this.encodedPosX / 32;
        final double lIllIlIIllllII = lIllIlIIlllIlI.posZ - this.encodedPosZ / 32;
        return lIllIlIIllllIl >= -this.trackingDistanceThreshold && lIllIlIIllllIl <= this.trackingDistanceThreshold && lIllIlIIllllII >= -this.trackingDistanceThreshold && lIllIlIIllllII <= this.trackingDistanceThreshold && this.trackedEntity.func_174827_a(lIllIlIIlllIlI);
    }
    
    public void sendDestroyEntityPacketToTrackedPlayers() {
        for (final EntityPlayerMP lIllIlIllIIlll : this.trackingPlayers) {
            lIllIlIllIIlll.func_152339_d(this.trackedEntity);
        }
    }
    
    private void sendMetadataToAllAssociatedPlayers() {
        final DataWatcher lIllIllIIIIlIl = this.trackedEntity.getDataWatcher();
        if (lIllIllIIIIlIl.hasObjectChanged()) {
            this.func_151261_b(new S1CPacketEntityMetadata(this.trackedEntity.getEntityId(), lIllIllIIIIlIl, false));
        }
        if (this.trackedEntity instanceof EntityLivingBase) {
            final ServersideAttributeMap lIllIllIIIIlII = (ServersideAttributeMap)((EntityLivingBase)this.trackedEntity).getAttributeMap();
            final Set lIllIllIIIIIll = lIllIllIIIIlII.getAttributeInstanceSet();
            if (!lIllIllIIIIIll.isEmpty()) {
                this.func_151261_b(new S20PacketEntityProperties(this.trackedEntity.getEntityId(), lIllIllIIIIIll));
            }
            lIllIllIIIIIll.clear();
        }
    }
    
    public void updatePlayerList(final List lIllIllIllIlll) {
        this.playerEntitiesUpdated = false;
        if (!this.firstUpdateDone || this.trackedEntity.getDistanceSq(this.lastTrackedEntityPosX, this.lastTrackedEntityPosY, this.lastTrackedEntityPosZ) > 16.0) {
            this.lastTrackedEntityPosX = this.trackedEntity.posX;
            this.lastTrackedEntityPosY = this.trackedEntity.posY;
            this.lastTrackedEntityPosZ = this.trackedEntity.posZ;
            this.firstUpdateDone = true;
            this.playerEntitiesUpdated = true;
            this.updatePlayerEntities(lIllIllIllIlll);
        }
        if (this.field_85178_v != this.trackedEntity.ridingEntity || (this.trackedEntity.ridingEntity != null && this.updateCounter % 60 == 0)) {
            this.field_85178_v = this.trackedEntity.ridingEntity;
            this.func_151259_a(new S1BPacketEntityAttach(0, this.trackedEntity, this.trackedEntity.ridingEntity));
        }
        if (this.trackedEntity instanceof EntityItemFrame && this.updateCounter % 10 == 0) {
            final EntityItemFrame lIllIllIllIllI = (EntityItemFrame)this.trackedEntity;
            final ItemStack lIllIllIllIlIl = lIllIllIllIllI.getDisplayedItem();
            if (lIllIllIllIlIl != null && lIllIllIllIlIl.getItem() instanceof ItemMap) {
                final MapData lIllIllIllIlII = Items.filled_map.getMapData(lIllIllIllIlIl, this.trackedEntity.worldObj);
                for (final EntityPlayer lIllIllIllIIlI : lIllIllIllIlll) {
                    final EntityPlayerMP lIllIllIllIIIl = (EntityPlayerMP)lIllIllIllIIlI;
                    lIllIllIllIlII.updateVisiblePlayers(lIllIllIllIIIl, lIllIllIllIlIl);
                    final Packet lIllIllIllIIII = Items.filled_map.createMapDataPacket(lIllIllIllIlIl, this.trackedEntity.worldObj, lIllIllIllIIIl);
                    if (lIllIllIllIIII != null) {
                        lIllIllIllIIIl.playerNetServerHandler.sendPacket(lIllIllIllIIII);
                    }
                }
            }
            this.sendMetadataToAllAssociatedPlayers();
        }
        if (this.updateCounter % this.updateFrequency == 0 || this.trackedEntity.isAirBorne || this.trackedEntity.getDataWatcher().hasObjectChanged()) {
            if (this.trackedEntity.ridingEntity == null) {
                ++this.ticksSinceLastForcedTeleport;
                final int lIllIllIlIllll = MathHelper.floor_double(this.trackedEntity.posX * 32.0);
                final int lIllIllIlIllIl = MathHelper.floor_double(this.trackedEntity.posY * 32.0);
                final int lIllIllIlIlIll = MathHelper.floor_double(this.trackedEntity.posZ * 32.0);
                final int lIllIllIlIlIlI = MathHelper.floor_float(this.trackedEntity.rotationYaw * 256.0f / 360.0f);
                final int lIllIllIlIlIIl = MathHelper.floor_float(this.trackedEntity.rotationPitch * 256.0f / 360.0f);
                final int lIllIllIlIlIII = lIllIllIlIllll - this.encodedPosX;
                final int lIllIllIlIIlll = lIllIllIlIllIl - this.encodedPosY;
                final int lIllIllIlIIllI = lIllIllIlIlIll - this.encodedPosZ;
                Object lIllIllIlIIlIl = null;
                final boolean lIllIllIlIIlII = Math.abs(lIllIllIlIlIII) >= 4 || Math.abs(lIllIllIlIIlll) >= 4 || Math.abs(lIllIllIlIIllI) >= 4 || this.updateCounter % 60 == 0;
                final boolean lIllIllIlIIIll = Math.abs(lIllIllIlIlIlI - this.encodedRotationYaw) >= 4 || Math.abs(lIllIllIlIlIIl - this.encodedRotationPitch) >= 4;
                if (this.updateCounter > 0 || this.trackedEntity instanceof EntityArrow) {
                    if (lIllIllIlIlIII >= -128 && lIllIllIlIlIII < 128 && lIllIllIlIIlll >= -128 && lIllIllIlIIlll < 128 && lIllIllIlIIllI >= -128 && lIllIllIlIIllI < 128 && this.ticksSinceLastForcedTeleport <= 400 && !this.ridingEntity && this.field_180234_y == this.trackedEntity.onGround) {
                        if (lIllIllIlIIlII && lIllIllIlIIIll) {
                            lIllIllIlIIlIl = new S14PacketEntity.S17PacketEntityLookMove(this.trackedEntity.getEntityId(), (byte)lIllIllIlIlIII, (byte)lIllIllIlIIlll, (byte)lIllIllIlIIllI, (byte)lIllIllIlIlIlI, (byte)lIllIllIlIlIIl, this.trackedEntity.onGround);
                        }
                        else if (lIllIllIlIIlII) {
                            lIllIllIlIIlIl = new S14PacketEntity.S15PacketEntityRelMove(this.trackedEntity.getEntityId(), (byte)lIllIllIlIlIII, (byte)lIllIllIlIIlll, (byte)lIllIllIlIIllI, this.trackedEntity.onGround);
                        }
                        else if (lIllIllIlIIIll) {
                            lIllIllIlIIlIl = new S14PacketEntity.S16PacketEntityLook(this.trackedEntity.getEntityId(), (byte)lIllIllIlIlIlI, (byte)lIllIllIlIlIIl, this.trackedEntity.onGround);
                        }
                    }
                    else {
                        this.field_180234_y = this.trackedEntity.onGround;
                        this.ticksSinceLastForcedTeleport = 0;
                        lIllIllIlIIlIl = new S18PacketEntityTeleport(this.trackedEntity.getEntityId(), lIllIllIlIllll, lIllIllIlIllIl, lIllIllIlIlIll, (byte)lIllIllIlIlIlI, (byte)lIllIllIlIlIIl, this.trackedEntity.onGround);
                    }
                }
                if (this.sendVelocityUpdates) {
                    final double lIllIllIlIIIlI = this.trackedEntity.motionX - this.lastTrackedEntityMotionX;
                    final double lIllIllIlIIIIl = this.trackedEntity.motionY - this.lastTrackedEntityMotionY;
                    final double lIllIllIlIIIII = this.trackedEntity.motionZ - this.motionZ;
                    final double lIllIllIIlllll = 0.02;
                    final double lIllIllIIllllI = lIllIllIlIIIlI * lIllIllIlIIIlI + lIllIllIlIIIIl * lIllIllIlIIIIl + lIllIllIlIIIII * lIllIllIlIIIII;
                    if (lIllIllIIllllI > lIllIllIIlllll * lIllIllIIlllll || (lIllIllIIllllI > 0.0 && this.trackedEntity.motionX == 0.0 && this.trackedEntity.motionY == 0.0 && this.trackedEntity.motionZ == 0.0)) {
                        this.lastTrackedEntityMotionX = this.trackedEntity.motionX;
                        this.lastTrackedEntityMotionY = this.trackedEntity.motionY;
                        this.motionZ = this.trackedEntity.motionZ;
                        this.func_151259_a(new S12PacketEntityVelocity(this.trackedEntity.getEntityId(), this.lastTrackedEntityMotionX, this.lastTrackedEntityMotionY, this.motionZ));
                    }
                }
                if (lIllIllIlIIlIl != null) {
                    this.func_151259_a((Packet)lIllIllIlIIlIl);
                }
                this.sendMetadataToAllAssociatedPlayers();
                if (lIllIllIlIIlII) {
                    this.encodedPosX = lIllIllIlIllll;
                    this.encodedPosY = lIllIllIlIllIl;
                    this.encodedPosZ = lIllIllIlIlIll;
                }
                if (lIllIllIlIIIll) {
                    this.encodedRotationYaw = lIllIllIlIlIlI;
                    this.encodedRotationPitch = lIllIllIlIlIIl;
                }
                this.ridingEntity = false;
            }
            else {
                final int lIllIllIlIlllI = MathHelper.floor_float(this.trackedEntity.rotationYaw * 256.0f / 360.0f);
                final int lIllIllIlIllII = MathHelper.floor_float(this.trackedEntity.rotationPitch * 256.0f / 360.0f);
                final boolean lIllIllIIlllIl = Math.abs(lIllIllIlIlllI - this.encodedRotationYaw) >= 4 || Math.abs(lIllIllIlIllII - this.encodedRotationPitch) >= 4;
                if (lIllIllIIlllIl) {
                    this.func_151259_a(new S14PacketEntity.S16PacketEntityLook(this.trackedEntity.getEntityId(), (byte)lIllIllIlIlllI, (byte)lIllIllIlIllII, this.trackedEntity.onGround));
                    this.encodedRotationYaw = lIllIllIlIlllI;
                    this.encodedRotationPitch = lIllIllIlIllII;
                }
                this.encodedPosX = MathHelper.floor_double(this.trackedEntity.posX * 32.0);
                this.encodedPosY = MathHelper.floor_double(this.trackedEntity.posY * 32.0);
                this.encodedPosZ = MathHelper.floor_double(this.trackedEntity.posZ * 32.0);
                this.sendMetadataToAllAssociatedPlayers();
                this.ridingEntity = true;
            }
            final int lIllIllIlIlllI = MathHelper.floor_float(this.trackedEntity.getRotationYawHead() * 256.0f / 360.0f);
            if (Math.abs(lIllIllIlIlllI - this.lastHeadMotion) >= 4) {
                this.func_151259_a(new S19PacketEntityHeadLook(this.trackedEntity, (byte)lIllIllIlIlllI));
                this.lastHeadMotion = lIllIllIlIlllI;
            }
            this.trackedEntity.isAirBorne = false;
        }
        ++this.updateCounter;
        if (this.trackedEntity.velocityChanged) {
            this.func_151261_b(new S12PacketEntityVelocity(this.trackedEntity));
            this.trackedEntity.velocityChanged = false;
        }
    }
    
    public void removeFromTrackedPlayers(final EntityPlayerMP lIllIlIllIIIII) {
        if (this.trackingPlayers.contains(lIllIlIllIIIII)) {
            lIllIlIllIIIII.func_152339_d(this.trackedEntity);
            this.trackingPlayers.remove(lIllIlIllIIIII);
        }
    }
    
    public void updatePlayerEntity(final EntityPlayerMP lIllIlIlIlIlIl) {
        if (lIllIlIlIlIlIl != this.trackedEntity) {
            if (this.func_180233_c(lIllIlIlIlIlIl)) {
                if (!this.trackingPlayers.contains(lIllIlIlIlIlIl) && (this.isPlayerWatchingThisChunk(lIllIlIlIlIlIl) || this.trackedEntity.forceSpawn)) {
                    this.trackingPlayers.add(lIllIlIlIlIlIl);
                    final Packet lIllIlIlIlIlII = this.func_151260_c();
                    lIllIlIlIlIlIl.playerNetServerHandler.sendPacket(lIllIlIlIlIlII);
                    if (!this.trackedEntity.getDataWatcher().getIsBlank()) {
                        lIllIlIlIlIlIl.playerNetServerHandler.sendPacket(new S1CPacketEntityMetadata(this.trackedEntity.getEntityId(), this.trackedEntity.getDataWatcher(), true));
                    }
                    final NBTTagCompound lIllIlIlIlIIll = this.trackedEntity.func_174819_aU();
                    if (lIllIlIlIlIIll != null) {
                        lIllIlIlIlIlIl.playerNetServerHandler.sendPacket(new S49PacketUpdateEntityNBT(this.trackedEntity.getEntityId(), lIllIlIlIlIIll));
                    }
                    if (this.trackedEntity instanceof EntityLivingBase) {
                        final ServersideAttributeMap lIllIlIlIlIIlI = (ServersideAttributeMap)((EntityLivingBase)this.trackedEntity).getAttributeMap();
                        final Collection lIllIlIlIlIIIl = lIllIlIlIlIIlI.getWatchedAttributes();
                        if (!lIllIlIlIlIIIl.isEmpty()) {
                            lIllIlIlIlIlIl.playerNetServerHandler.sendPacket(new S20PacketEntityProperties(this.trackedEntity.getEntityId(), lIllIlIlIlIIIl));
                        }
                    }
                    this.lastTrackedEntityMotionX = this.trackedEntity.motionX;
                    this.lastTrackedEntityMotionY = this.trackedEntity.motionY;
                    this.motionZ = this.trackedEntity.motionZ;
                    if (this.sendVelocityUpdates && !(lIllIlIlIlIlII instanceof S0FPacketSpawnMob)) {
                        lIllIlIlIlIlIl.playerNetServerHandler.sendPacket(new S12PacketEntityVelocity(this.trackedEntity.getEntityId(), this.trackedEntity.motionX, this.trackedEntity.motionY, this.trackedEntity.motionZ));
                    }
                    if (this.trackedEntity.ridingEntity != null) {
                        lIllIlIlIlIlIl.playerNetServerHandler.sendPacket(new S1BPacketEntityAttach(0, this.trackedEntity, this.trackedEntity.ridingEntity));
                    }
                    if (this.trackedEntity instanceof EntityLiving && ((EntityLiving)this.trackedEntity).getLeashedToEntity() != null) {
                        lIllIlIlIlIlIl.playerNetServerHandler.sendPacket(new S1BPacketEntityAttach(1, this.trackedEntity, ((EntityLiving)this.trackedEntity).getLeashedToEntity()));
                    }
                    if (this.trackedEntity instanceof EntityLivingBase) {
                        for (int lIllIlIlIlIIII = 0; lIllIlIlIlIIII < 5; ++lIllIlIlIlIIII) {
                            final ItemStack lIllIlIlIIllll = ((EntityLivingBase)this.trackedEntity).getEquipmentInSlot(lIllIlIlIlIIII);
                            if (lIllIlIlIIllll != null) {
                                lIllIlIlIlIlIl.playerNetServerHandler.sendPacket(new S04PacketEntityEquipment(this.trackedEntity.getEntityId(), lIllIlIlIlIIII, lIllIlIlIIllll));
                            }
                        }
                    }
                    if (this.trackedEntity instanceof EntityPlayer) {
                        final EntityPlayer lIllIlIlIIlllI = (EntityPlayer)this.trackedEntity;
                        if (lIllIlIlIIlllI.isPlayerSleeping()) {
                            lIllIlIlIlIlIl.playerNetServerHandler.sendPacket(new S0APacketUseBed(lIllIlIlIIlllI, new BlockPos(this.trackedEntity)));
                        }
                    }
                    if (this.trackedEntity instanceof EntityLivingBase) {
                        final EntityLivingBase lIllIlIlIIllIl = (EntityLivingBase)this.trackedEntity;
                        for (final PotionEffect lIllIlIlIIlIll : lIllIlIlIIllIl.getActivePotionEffects()) {
                            lIllIlIlIlIlIl.playerNetServerHandler.sendPacket(new S1DPacketEntityEffect(this.trackedEntity.getEntityId(), lIllIlIlIIlIll));
                        }
                    }
                }
            }
            else if (this.trackingPlayers.contains(lIllIlIlIlIlIl)) {
                this.trackingPlayers.remove(lIllIlIlIlIlIl);
                lIllIlIlIlIlIl.func_152339_d(this.trackedEntity);
            }
        }
    }
    
    @Override
    public boolean equals(final Object lIllIlllIlIIII) {
        return lIllIlllIlIIII instanceof EntityTrackerEntry && ((EntityTrackerEntry)lIllIlllIlIIII).trackedEntity.getEntityId() == this.trackedEntity.getEntityId();
    }
    
    @Override
    public int hashCode() {
        return this.trackedEntity.getEntityId();
    }
    
    private boolean isPlayerWatchingThisChunk(final EntityPlayerMP lIllIlIIllIlII) {
        return lIllIlIIllIlII.getServerForPlayer().getPlayerManager().isPlayerWatchingChunk(lIllIlIIllIlII, this.trackedEntity.chunkCoordX, this.trackedEntity.chunkCoordZ);
    }
    
    public void updatePlayerEntities(final List lIllIlIIlIlIlI) {
        for (int lIllIlIIlIllII = 0; lIllIlIIlIllII < lIllIlIIlIlIlI.size(); ++lIllIlIIlIllII) {
            this.updatePlayerEntity(lIllIlIIlIlIlI.get(lIllIlIIlIllII));
        }
    }
}
