package net.minecraft.entity;

import net.minecraft.world.*;
import net.minecraft.network.*;
import net.minecraft.entity.player.*;
import java.util.*;
import com.google.common.collect.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.entity.boss.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.item.*;
import org.apache.logging.log4j.*;
import net.minecraft.world.chunk.*;
import java.util.concurrent.*;
import net.minecraft.util.*;
import net.minecraft.crash.*;

public class EntityTracker
{
    private /* synthetic */ int maxTrackingDistanceThreshold;
    private /* synthetic */ Set trackedEntities;
    private /* synthetic */ IntHashMap trackedEntityHashTable;
    private final /* synthetic */ WorldServer theWorld;
    private static final /* synthetic */ Logger logger;
    
    public void func_151248_b(final Entity llllllllllllllIIIlIIIIIllIIlIlIl, final Packet llllllllllllllIIIlIIIIIllIIlIIII) {
        final EntityTrackerEntry llllllllllllllIIIlIIIIIllIIlIIll = (EntityTrackerEntry)this.trackedEntityHashTable.lookup(llllllllllllllIIIlIIIIIllIIlIlIl.getEntityId());
        if (llllllllllllllIIIlIIIIIllIIlIIll != null) {
            llllllllllllllIIIlIIIIIllIIlIIll.func_151261_b(llllllllllllllIIIlIIIIIllIIlIIII);
        }
    }
    
    public void sendToAllTrackingEntity(final Entity llllllllllllllIIIlIIIIIllIlIIIIl, final Packet llllllllllllllIIIlIIIIIllIIlllII) {
        final EntityTrackerEntry llllllllllllllIIIlIIIIIllIIlllll = (EntityTrackerEntry)this.trackedEntityHashTable.lookup(llllllllllllllIIIlIIIIIllIlIIIIl.getEntityId());
        if (llllllllllllllIIIlIIIIIllIIlllll != null) {
            llllllllllllllIIIlIIIIIllIIlllll.func_151259_a(llllllllllllllIIIlIIIIIllIIlllII);
        }
    }
    
    public void updateTrackedEntities() {
        final ArrayList llllllllllllllIIIlIIIIIlllIIIIII = Lists.newArrayList();
        for (final EntityTrackerEntry llllllllllllllIIIlIIIIIllIlllllI : this.trackedEntities) {
            llllllllllllllIIIlIIIIIllIlllllI.updatePlayerList(this.theWorld.playerEntities);
            if (llllllllllllllIIIlIIIIIllIlllllI.playerEntitiesUpdated && llllllllllllllIIIlIIIIIllIlllllI.trackedEntity instanceof EntityPlayerMP) {
                llllllllllllllIIIlIIIIIlllIIIIII.add(llllllllllllllIIIlIIIIIllIlllllI.trackedEntity);
            }
        }
        for (int llllllllllllllIIIlIIIIIllIllllIl = 0; llllllllllllllIIIlIIIIIllIllllIl < llllllllllllllIIIlIIIIIlllIIIIII.size(); ++llllllllllllllIIIlIIIIIllIllllIl) {
            final EntityPlayerMP llllllllllllllIIIlIIIIIllIllllII = llllllllllllllIIIlIIIIIlllIIIIII.get(llllllllllllllIIIlIIIIIllIllllIl);
            for (final EntityTrackerEntry llllllllllllllIIIlIIIIIllIlllIlI : this.trackedEntities) {
                if (llllllllllllllIIIlIIIIIllIlllIlI.trackedEntity != llllllllllllllIIIlIIIIIllIllllII) {
                    llllllllllllllIIIlIIIIIllIlllIlI.updatePlayerEntity(llllllllllllllIIIlIIIIIllIllllII);
                }
            }
        }
    }
    
    public EntityTracker(final WorldServer llllllllllllllIIIlIIIIlIIIIlIlIl) {
        this.trackedEntities = Sets.newHashSet();
        this.trackedEntityHashTable = new IntHashMap();
        this.theWorld = llllllllllllllIIIlIIIIlIIIIlIlIl;
        this.maxTrackingDistanceThreshold = llllllllllllllIIIlIIIIlIIIIlIlIl.func_73046_m().getConfigurationManager().getEntityViewDistance();
    }
    
    public void trackEntity(final Entity llllllllllllllIIIlIIIIlIIIIIIlll) {
        if (llllllllllllllIIIlIIIIlIIIIIIlll instanceof EntityPlayerMP) {
            this.trackEntity(llllllllllllllIIIlIIIIlIIIIIIlll, 512, 2);
            final EntityPlayerMP llllllllllllllIIIlIIIIlIIIIIlIll = (EntityPlayerMP)llllllllllllllIIIlIIIIlIIIIIIlll;
            for (final EntityTrackerEntry llllllllllllllIIIlIIIIlIIIIIlIIl : this.trackedEntities) {
                if (llllllllllllllIIIlIIIIlIIIIIlIIl.trackedEntity != llllllllllllllIIIlIIIIlIIIIIlIll) {
                    llllllllllllllIIIlIIIIlIIIIIlIIl.updatePlayerEntity(llllllllllllllIIIlIIIIlIIIIIlIll);
                }
            }
        }
        else if (llllllllllllllIIIlIIIIlIIIIIIlll instanceof EntityFishHook) {
            this.addEntityToTracker(llllllllllllllIIIlIIIIlIIIIIIlll, 64, 5, true);
        }
        else if (llllllllllllllIIIlIIIIlIIIIIIlll instanceof EntityArrow) {
            this.addEntityToTracker(llllllllllllllIIIlIIIIlIIIIIIlll, 64, 20, false);
        }
        else if (llllllllllllllIIIlIIIIlIIIIIIlll instanceof EntitySmallFireball) {
            this.addEntityToTracker(llllllllllllllIIIlIIIIlIIIIIIlll, 64, 10, false);
        }
        else if (llllllllllllllIIIlIIIIlIIIIIIlll instanceof EntityFireball) {
            this.addEntityToTracker(llllllllllllllIIIlIIIIlIIIIIIlll, 64, 10, false);
        }
        else if (llllllllllllllIIIlIIIIlIIIIIIlll instanceof EntitySnowball) {
            this.addEntityToTracker(llllllllllllllIIIlIIIIlIIIIIIlll, 64, 10, true);
        }
        else if (llllllllllllllIIIlIIIIlIIIIIIlll instanceof EntityEnderPearl) {
            this.addEntityToTracker(llllllllllllllIIIlIIIIlIIIIIIlll, 64, 10, true);
        }
        else if (llllllllllllllIIIlIIIIlIIIIIIlll instanceof EntityEnderEye) {
            this.addEntityToTracker(llllllllllllllIIIlIIIIlIIIIIIlll, 64, 4, true);
        }
        else if (llllllllllllllIIIlIIIIlIIIIIIlll instanceof EntityEgg) {
            this.addEntityToTracker(llllllllllllllIIIlIIIIlIIIIIIlll, 64, 10, true);
        }
        else if (llllllllllllllIIIlIIIIlIIIIIIlll instanceof EntityPotion) {
            this.addEntityToTracker(llllllllllllllIIIlIIIIlIIIIIIlll, 64, 10, true);
        }
        else if (llllllllllllllIIIlIIIIlIIIIIIlll instanceof EntityExpBottle) {
            this.addEntityToTracker(llllllllllllllIIIlIIIIlIIIIIIlll, 64, 10, true);
        }
        else if (llllllllllllllIIIlIIIIlIIIIIIlll instanceof EntityFireworkRocket) {
            this.addEntityToTracker(llllllllllllllIIIlIIIIlIIIIIIlll, 64, 10, true);
        }
        else if (llllllllllllllIIIlIIIIlIIIIIIlll instanceof EntityItem) {
            this.addEntityToTracker(llllllllllllllIIIlIIIIlIIIIIIlll, 64, 20, true);
        }
        else if (llllllllllllllIIIlIIIIlIIIIIIlll instanceof EntityMinecart) {
            this.addEntityToTracker(llllllllllllllIIIlIIIIlIIIIIIlll, 80, 3, true);
        }
        else if (llllllllllllllIIIlIIIIlIIIIIIlll instanceof EntityBoat) {
            this.addEntityToTracker(llllllllllllllIIIlIIIIlIIIIIIlll, 80, 3, true);
        }
        else if (llllllllllllllIIIlIIIIlIIIIIIlll instanceof EntitySquid) {
            this.addEntityToTracker(llllllllllllllIIIlIIIIlIIIIIIlll, 64, 3, true);
        }
        else if (llllllllllllllIIIlIIIIlIIIIIIlll instanceof EntityWither) {
            this.addEntityToTracker(llllllllllllllIIIlIIIIlIIIIIIlll, 80, 3, false);
        }
        else if (llllllllllllllIIIlIIIIlIIIIIIlll instanceof EntityBat) {
            this.addEntityToTracker(llllllllllllllIIIlIIIIlIIIIIIlll, 80, 3, false);
        }
        else if (llllllllllllllIIIlIIIIlIIIIIIlll instanceof EntityDragon) {
            this.addEntityToTracker(llllllllllllllIIIlIIIIlIIIIIIlll, 160, 3, true);
        }
        else if (llllllllllllllIIIlIIIIlIIIIIIlll instanceof IAnimals) {
            this.addEntityToTracker(llllllllllllllIIIlIIIIlIIIIIIlll, 80, 3, true);
        }
        else if (llllllllllllllIIIlIIIIlIIIIIIlll instanceof EntityTNTPrimed) {
            this.addEntityToTracker(llllllllllllllIIIlIIIIlIIIIIIlll, 160, 10, true);
        }
        else if (llllllllllllllIIIlIIIIlIIIIIIlll instanceof EntityFallingBlock) {
            this.addEntityToTracker(llllllllllllllIIIlIIIIlIIIIIIlll, 160, 20, true);
        }
        else if (llllllllllllllIIIlIIIIlIIIIIIlll instanceof EntityHanging) {
            this.addEntityToTracker(llllllllllllllIIIlIIIIlIIIIIIlll, 160, Integer.MAX_VALUE, false);
        }
        else if (llllllllllllllIIIlIIIIlIIIIIIlll instanceof EntityArmorStand) {
            this.addEntityToTracker(llllllllllllllIIIlIIIIlIIIIIIlll, 160, 3, true);
        }
        else if (llllllllllllllIIIlIIIIlIIIIIIlll instanceof EntityXPOrb) {
            this.addEntityToTracker(llllllllllllllIIIlIIIIlIIIIIIlll, 160, 20, true);
        }
        else if (llllllllllllllIIIlIIIIlIIIIIIlll instanceof EntityEnderCrystal) {
            this.addEntityToTracker(llllllllllllllIIIlIIIIlIIIIIIlll, 256, Integer.MAX_VALUE, false);
        }
    }
    
    static {
        __OBFID = "CL_00001431";
        logger = LogManager.getLogger();
    }
    
    public void func_180245_a(final EntityPlayerMP llllllllllllllIIIlIIIIIllIlIlIIl) {
        for (final EntityTrackerEntry llllllllllllllIIIlIIIIIllIlIlIll : this.trackedEntities) {
            if (llllllllllllllIIIlIIIIIllIlIlIll.trackedEntity == llllllllllllllIIIlIIIIIllIlIlIIl) {
                llllllllllllllIIIlIIIIIllIlIlIll.updatePlayerEntities(this.theWorld.playerEntities);
            }
            else {
                llllllllllllllIIIlIIIIIllIlIlIll.updatePlayerEntity(llllllllllllllIIIlIIIIIllIlIlIIl);
            }
        }
    }
    
    public void func_85172_a(final EntityPlayerMP llllllllllllllIIIlIIIIIlIlllIlll, final Chunk llllllllllllllIIIlIIIIIlIlllIllI) {
        for (final EntityTrackerEntry llllllllllllllIIIlIIIIIlIllllIIl : this.trackedEntities) {
            if (llllllllllllllIIIlIIIIIlIllllIIl.trackedEntity != llllllllllllllIIIlIIIIIlIlllIlll && llllllllllllllIIIlIIIIIlIllllIIl.trackedEntity.chunkCoordX == llllllllllllllIIIlIIIIIlIlllIllI.xPosition && llllllllllllllIIIlIIIIIlIllllIIl.trackedEntity.chunkCoordZ == llllllllllllllIIIlIIIIIlIlllIllI.zPosition) {
                llllllllllllllIIIlIIIIIlIllllIIl.updatePlayerEntity(llllllllllllllIIIlIIIIIlIlllIlll);
            }
        }
    }
    
    public void trackEntity(final Entity llllllllllllllIIIlIIIIIllllllllI, final int llllllllllllllIIIlIIIIIllllllIIl, final int llllllllllllllIIIlIIIIIllllllIII) {
        this.addEntityToTracker(llllllllllllllIIIlIIIIIllllllllI, llllllllllllllIIIlIIIIIllllllIIl, llllllllllllllIIIlIIIIIllllllIII, false);
    }
    
    public void removePlayerFromTrackers(final EntityPlayerMP llllllllllllllIIIlIIIIIllIIIlIIl) {
        for (final EntityTrackerEntry llllllllllllllIIIlIIIIIllIIIIlll : this.trackedEntities) {
            llllllllllllllIIIlIIIIIllIIIIlll.removeTrackedPlayerSymmetric(llllllllllllllIIIlIIIIIllIIIlIIl);
        }
    }
    
    public void untrackEntity(final Entity llllllllllllllIIIlIIIIIlllIlIIlI) {
        if (llllllllllllllIIIlIIIIIlllIlIIlI instanceof EntityPlayerMP) {
            final EntityPlayerMP llllllllllllllIIIlIIIIIlllIlIIIl = (EntityPlayerMP)llllllllllllllIIIlIIIIIlllIlIIlI;
            for (final EntityTrackerEntry llllllllllllllIIIlIIIIIlllIIllll : this.trackedEntities) {
                llllllllllllllIIIlIIIIIlllIIllll.removeFromTrackedPlayers(llllllllllllllIIIlIIIIIlllIlIIIl);
            }
        }
        final EntityTrackerEntry llllllllllllllIIIlIIIIIlllIIlllI = (EntityTrackerEntry)this.trackedEntityHashTable.removeObject(llllllllllllllIIIlIIIIIlllIlIIlI.getEntityId());
        if (llllllllllllllIIIlIIIIIlllIIlllI != null) {
            this.trackedEntities.remove(llllllllllllllIIIlIIIIIlllIIlllI);
            llllllllllllllIIIlIIIIIlllIIlllI.sendDestroyEntityPacketToTrackedPlayers();
        }
    }
    
    public void addEntityToTracker(final Entity llllllllllllllIIIlIIIIIllllIIIIl, int llllllllllllllIIIlIIIIIllllIIIII, final int llllllllllllllIIIlIIIIIllllIlIlI, final boolean llllllllllllllIIIlIIIIIlllIllllI) {
        if (llllllllllllllIIIlIIIIIllllIIIII > this.maxTrackingDistanceThreshold) {
            llllllllllllllIIIlIIIIIllllIIIII = this.maxTrackingDistanceThreshold;
        }
        try {
            if (this.trackedEntityHashTable.containsItem(llllllllllllllIIIlIIIIIllllIIIIl.getEntityId())) {
                throw new IllegalStateException("Entity is already tracked!");
            }
            final EntityTrackerEntry llllllllllllllIIIlIIIIIllllIlIII = new EntityTrackerEntry(llllllllllllllIIIlIIIIIllllIIIIl, (int)llllllllllllllIIIlIIIIIllllIIIII, llllllllllllllIIIlIIIIIllllIlIlI, llllllllllllllIIIlIIIIIlllIllllI);
            this.trackedEntities.add(llllllllllllllIIIlIIIIIllllIlIII);
            this.trackedEntityHashTable.addKey(llllllllllllllIIIlIIIIIllllIIIIl.getEntityId(), llllllllllllllIIIlIIIIIllllIlIII);
            llllllllllllllIIIlIIIIIllllIlIII.updatePlayerEntities(this.theWorld.playerEntities);
        }
        catch (Throwable llllllllllllllIIIlIIIIIllllIIlll) {
            final CrashReport llllllllllllllIIIlIIIIIllllIIllI = CrashReport.makeCrashReport(llllllllllllllIIIlIIIIIllllIIlll, "Adding entity to track");
            final CrashReportCategory llllllllllllllIIIlIIIIIllllIIlIl = llllllllllllllIIIlIIIIIllllIIllI.makeCategory("Entity To Track");
            llllllllllllllIIIlIIIIIllllIIlIl.addCrashSection("Tracking range", String.valueOf(new StringBuilder(String.valueOf((int)llllllllllllllIIIlIIIIIllllIIIII)).append(" blocks")));
            llllllllllllllIIIlIIIIIllllIIlIl.addCrashSectionCallable("Update interval", new Callable() {
                static {
                    __OBFID = "CL_00001432";
                }
                
                @Override
                public String call() {
                    String llllllllllllllIIIllllIIIlIllIIlI = String.valueOf(new StringBuilder("Once per ").append(llllllllllllllIIIlIIIIIllllIlIlI).append(" ticks"));
                    if (llllllllllllllIIIlIIIIIllllIlIlI == Integer.MAX_VALUE) {
                        llllllllllllllIIIllllIIIlIllIIlI = String.valueOf(new StringBuilder("Maximum (").append(llllllllllllllIIIllllIIIlIllIIlI).append(")"));
                    }
                    return llllllllllllllIIIllllIIIlIllIIlI;
                }
            });
            llllllllllllllIIIlIIIIIllllIIIIl.addEntityCrashInfo(llllllllllllllIIIlIIIIIllllIIlIl);
            final CrashReportCategory llllllllllllllIIIlIIIIIllllIIlII = llllllllllllllIIIlIIIIIllllIIllI.makeCategory("Entity That Is Already Tracked");
            ((EntityTrackerEntry)this.trackedEntityHashTable.lookup(llllllllllllllIIIlIIIIIllllIIIIl.getEntityId())).trackedEntity.addEntityCrashInfo(llllllllllllllIIIlIIIIIllllIIlII);
            try {
                throw new ReportedException(llllllllllllllIIIlIIIIIllllIIllI);
            }
            catch (ReportedException llllllllllllllIIIlIIIIIllllIIIll) {
                EntityTracker.logger.error("\"Silently\" catching entity tracking error.", (Throwable)llllllllllllllIIIlIIIIIllllIIIll);
            }
        }
    }
}
