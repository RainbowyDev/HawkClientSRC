package net.minecraft.server.management;

import net.minecraft.entity.player.*;
import org.apache.logging.log4j.*;
import com.google.common.collect.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.world.chunk.*;
import net.minecraft.network.*;
import net.minecraft.tileentity.*;
import net.minecraft.world.*;
import net.minecraft.network.play.server.*;

public class PlayerManager
{
    private /* synthetic */ long previousTotalWorldTime;
    private final /* synthetic */ LongHashMap playerInstances;
    private final /* synthetic */ List playerInstancesToUpdate;
    private final /* synthetic */ int[][] xzDirectionsConst;
    private final /* synthetic */ WorldServer theWorldServer;
    private /* synthetic */ int playerViewRadius;
    private final /* synthetic */ List playerInstanceList;
    private final /* synthetic */ List players;
    private static final /* synthetic */ Logger field_152627_a;
    
    public void addPlayer(final EntityPlayerMP llllllllllllllIIlIIIIIIlllllllIl) {
        final int llllllllllllllIIlIIIIIlIIIIIIIlI = (int)llllllllllllllIIlIIIIIIlllllllIl.posX >> 4;
        final int llllllllllllllIIlIIIIIlIIIIIIIIl = (int)llllllllllllllIIlIIIIIIlllllllIl.posZ >> 4;
        llllllllllllllIIlIIIIIIlllllllIl.managedPosX = llllllllllllllIIlIIIIIIlllllllIl.posX;
        llllllllllllllIIlIIIIIIlllllllIl.managedPosZ = llllllllllllllIIlIIIIIIlllllllIl.posZ;
        for (int llllllllllllllIIlIIIIIlIIIIIIIII = llllllllllllllIIlIIIIIlIIIIIIIlI - this.playerViewRadius; llllllllllllllIIlIIIIIlIIIIIIIII <= llllllllllllllIIlIIIIIlIIIIIIIlI + this.playerViewRadius; ++llllllllllllllIIlIIIIIlIIIIIIIII) {
            for (int llllllllllllllIIlIIIIIIlllllllll = llllllllllllllIIlIIIIIlIIIIIIIIl - this.playerViewRadius; llllllllllllllIIlIIIIIIlllllllll <= llllllllllllllIIlIIIIIlIIIIIIIIl + this.playerViewRadius; ++llllllllllllllIIlIIIIIIlllllllll) {
                this.getPlayerInstance(llllllllllllllIIlIIIIIlIIIIIIIII, llllllllllllllIIlIIIIIIlllllllll, true).addPlayer(llllllllllllllIIlIIIIIIlllllllIl);
            }
        }
        this.players.add(llllllllllllllIIlIIIIIIlllllllIl);
        this.filterChunkLoadQueue(llllllllllllllIIlIIIIIIlllllllIl);
    }
    
    public void removePlayer(final EntityPlayerMP llllllllllllllIIlIIIIIIlllIIIllI) {
        final int llllllllllllllIIlIIIIIIlllIIIlIl = (int)llllllllllllllIIlIIIIIIlllIIIllI.managedPosX >> 4;
        final int llllllllllllllIIlIIIIIIlllIIIlII = (int)llllllllllllllIIlIIIIIIlllIIIllI.managedPosZ >> 4;
        for (int llllllllllllllIIlIIIIIIlllIIIIll = llllllllllllllIIlIIIIIIlllIIIlIl - this.playerViewRadius; llllllllllllllIIlIIIIIIlllIIIIll <= llllllllllllllIIlIIIIIIlllIIIlIl + this.playerViewRadius; ++llllllllllllllIIlIIIIIIlllIIIIll) {
            for (int llllllllllllllIIlIIIIIIlllIIIIlI = llllllllllllllIIlIIIIIIlllIIIlII - this.playerViewRadius; llllllllllllllIIlIIIIIIlllIIIIlI <= llllllllllllllIIlIIIIIIlllIIIlII + this.playerViewRadius; ++llllllllllllllIIlIIIIIIlllIIIIlI) {
                final PlayerInstance llllllllllllllIIlIIIIIIlllIIIIIl = this.getPlayerInstance(llllllllllllllIIlIIIIIIlllIIIIll, llllllllllllllIIlIIIIIIlllIIIIlI, false);
                if (llllllllllllllIIlIIIIIIlllIIIIIl != null) {
                    llllllllllllllIIlIIIIIIlllIIIIIl.removePlayer(llllllllllllllIIlIIIIIIlllIIIllI);
                }
            }
        }
        this.players.remove(llllllllllllllIIlIIIIIIlllIIIllI);
    }
    
    public WorldServer getMinecraftServer() {
        return this.theWorldServer;
    }
    
    private boolean overlaps(final int llllllllllllllIIlIIIIIIllIlIlIlI, final int llllllllllllllIIlIIIIIIllIlIlIIl, final int llllllllllllllIIlIIIIIIllIlIlIII, final int llllllllllllllIIlIIIIIIllIlIIlll, final int llllllllllllllIIlIIIIIIllIlIllIl) {
        final int llllllllllllllIIlIIIIIIllIlIllII = llllllllllllllIIlIIIIIIllIlIlIlI - llllllllllllllIIlIIIIIIllIlIlIII;
        final int llllllllllllllIIlIIIIIIllIlIlIll = llllllllllllllIIlIIIIIIllIlIlIIl - llllllllllllllIIlIIIIIIllIlIIlll;
        return llllllllllllllIIlIIIIIIllIlIllII >= -llllllllllllllIIlIIIIIIllIlIllIl && llllllllllllllIIlIIIIIIllIlIllII <= llllllllllllllIIlIIIIIIllIlIllIl && (llllllllllllllIIlIIIIIIllIlIlIll >= -llllllllllllllIIlIIIIIIllIlIllIl && llllllllllllllIIlIIIIIIllIlIlIll <= llllllllllllllIIlIIIIIIllIlIllIl);
    }
    
    public boolean func_152621_a(final int llllllllllllllIIlIIIIIlIIIlIlllI, final int llllllllllllllIIlIIIIIlIIIllIIIl) {
        final long llllllllllllllIIlIIIIIlIIIllIIII = llllllllllllllIIlIIIIIlIIIlIlllI + 2147483647L | llllllllllllllIIlIIIIIlIIIllIIIl + 2147483647L << 32;
        return this.playerInstances.getValueByKey(llllllllllllllIIlIIIIIlIIIllIIII) != null;
    }
    
    public void func_180244_a(final BlockPos llllllllllllllIIlIIIIIlIIIIlIIll) {
        final int llllllllllllllIIlIIIIIlIIIIlIIlI = llllllllllllllIIlIIIIIlIIIIlIIll.getX() >> 4;
        final int llllllllllllllIIlIIIIIlIIIIlIIIl = llllllllllllllIIlIIIIIlIIIIlIIll.getZ() >> 4;
        final PlayerInstance llllllllllllllIIlIIIIIlIIIIlIIII = this.getPlayerInstance(llllllllllllllIIlIIIIIlIIIIlIIlI, llllllllllllllIIlIIIIIlIIIIlIIIl, false);
        if (llllllllllllllIIlIIIIIlIIIIlIIII != null) {
            llllllllllllllIIlIIIIIlIIIIlIIII.flagChunkForUpdate(llllllllllllllIIlIIIIIlIIIIlIIll.getX() & 0xF, llllllllllllllIIlIIIIIlIIIIlIIll.getY(), llllllllllllllIIlIIIIIlIIIIlIIll.getZ() & 0xF);
        }
    }
    
    static {
        __OBFID = "CL_00001434";
        field_152627_a = LogManager.getLogger();
    }
    
    public PlayerManager(final WorldServer llllllllllllllIIlIIIIIlIIlIIllII) {
        this.players = Lists.newArrayList();
        this.playerInstances = new LongHashMap();
        this.playerInstancesToUpdate = Lists.newArrayList();
        this.playerInstanceList = Lists.newArrayList();
        this.xzDirectionsConst = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        this.theWorldServer = llllllllllllllIIlIIIIIlIIlIIllII;
        this.func_152622_a(llllllllllllllIIlIIIIIlIIlIIllII.func_73046_m().getConfigurationManager().getViewDistance());
    }
    
    public void func_152622_a(int llllllllllllllIIlIIIIIIlIlIIlllI) {
        llllllllllllllIIlIIIIIIlIlIIlllI = (byte)MathHelper.clamp_int(llllllllllllllIIlIIIIIIlIlIIlllI, 3, 32);
        if (llllllllllllllIIlIIIIIIlIlIIlllI != this.playerViewRadius) {
            final int llllllllllllllIIlIIIIIIlIlIllIlI = llllllllllllllIIlIIIIIIlIlIIlllI - this.playerViewRadius;
            final ArrayList llllllllllllllIIlIIIIIIlIlIllIIl = Lists.newArrayList((Iterable)this.players);
            for (final EntityPlayerMP llllllllllllllIIlIIIIIIlIlIlIlll : llllllllllllllIIlIIIIIIlIlIllIIl) {
                final int llllllllllllllIIlIIIIIIlIlIlIllI = (int)llllllllllllllIIlIIIIIIlIlIlIlll.posX >> 4;
                final int llllllllllllllIIlIIIIIIlIlIlIlIl = (int)llllllllllllllIIlIIIIIIlIlIlIlll.posZ >> 4;
                if (llllllllllllllIIlIIIIIIlIlIllIlI > 0) {
                    for (int llllllllllllllIIlIIIIIIlIlIlIlII = llllllllllllllIIlIIIIIIlIlIlIllI - llllllllllllllIIlIIIIIIlIlIIlllI; llllllllllllllIIlIIIIIIlIlIlIlII <= llllllllllllllIIlIIIIIIlIlIlIllI + llllllllllllllIIlIIIIIIlIlIIlllI; ++llllllllllllllIIlIIIIIIlIlIlIlII) {
                        for (int llllllllllllllIIlIIIIIIlIlIlIIlI = llllllllllllllIIlIIIIIIlIlIlIlIl - llllllllllllllIIlIIIIIIlIlIIlllI; llllllllllllllIIlIIIIIIlIlIlIIlI <= llllllllllllllIIlIIIIIIlIlIlIlIl + llllllllllllllIIlIIIIIIlIlIIlllI; ++llllllllllllllIIlIIIIIIlIlIlIIlI) {
                            final PlayerInstance llllllllllllllIIlIIIIIIlIlIlIIII = this.getPlayerInstance(llllllllllllllIIlIIIIIIlIlIlIlII, llllllllllllllIIlIIIIIIlIlIlIIlI, true);
                            if (!llllllllllllllIIlIIIIIIlIlIlIIII.playersWatchingChunk.contains(llllllllllllllIIlIIIIIIlIlIlIlll)) {
                                llllllllllllllIIlIIIIIIlIlIlIIII.addPlayer(llllllllllllllIIlIIIIIIlIlIlIlll);
                            }
                        }
                    }
                }
                else {
                    for (int llllllllllllllIIlIIIIIIlIlIlIIll = llllllllllllllIIlIIIIIIlIlIlIllI - this.playerViewRadius; llllllllllllllIIlIIIIIIlIlIlIIll <= llllllllllllllIIlIIIIIIlIlIlIllI + this.playerViewRadius; ++llllllllllllllIIlIIIIIIlIlIlIIll) {
                        for (int llllllllllllllIIlIIIIIIlIlIlIIIl = llllllllllllllIIlIIIIIIlIlIlIlIl - this.playerViewRadius; llllllllllllllIIlIIIIIIlIlIlIIIl <= llllllllllllllIIlIIIIIIlIlIlIlIl + this.playerViewRadius; ++llllllllllllllIIlIIIIIIlIlIlIIIl) {
                            if (!this.overlaps(llllllllllllllIIlIIIIIIlIlIlIIll, llllllllllllllIIlIIIIIIlIlIlIIIl, llllllllllllllIIlIIIIIIlIlIlIllI, llllllllllllllIIlIIIIIIlIlIlIlIl, llllllllllllllIIlIIIIIIlIlIIlllI)) {
                                this.getPlayerInstance(llllllllllllllIIlIIIIIIlIlIlIIll, llllllllllllllIIlIIIIIIlIlIlIIIl, true).removePlayer(llllllllllllllIIlIIIIIIlIlIlIlll);
                            }
                        }
                    }
                }
            }
            this.playerViewRadius = llllllllllllllIIlIIIIIIlIlIIlllI;
        }
    }
    
    public boolean isPlayerWatchingChunk(final EntityPlayerMP llllllllllllllIIlIIIIIIlIllIlIll, final int llllllllllllllIIlIIIIIIlIllIlIlI, final int llllllllllllllIIlIIIIIIlIllIlIIl) {
        final PlayerInstance llllllllllllllIIlIIIIIIlIllIllIl = this.getPlayerInstance(llllllllllllllIIlIIIIIIlIllIlIlI, llllllllllllllIIlIIIIIIlIllIlIIl, false);
        return llllllllllllllIIlIIIIIIlIllIllIl != null && llllllllllllllIIlIIIIIIlIllIllIl.playersWatchingChunk.contains(llllllllllllllIIlIIIIIIlIllIlIll) && !llllllllllllllIIlIIIIIIlIllIlIll.loadedChunks.contains(llllllllllllllIIlIIIIIIlIllIllIl.currentChunk);
    }
    
    public void updateMountedMovingPlayer(final EntityPlayerMP llllllllllllllIIlIIIIIIllIIIIlII) {
        final int llllllllllllllIIlIIIIIIllIIlIIlI = (int)llllllllllllllIIlIIIIIIllIIIIlII.posX >> 4;
        final int llllllllllllllIIlIIIIIIllIIlIIIl = (int)llllllllllllllIIlIIIIIIllIIIIlII.posZ >> 4;
        final double llllllllllllllIIlIIIIIIllIIlIIII = llllllllllllllIIlIIIIIIllIIIIlII.managedPosX - llllllllllllllIIlIIIIIIllIIIIlII.posX;
        final double llllllllllllllIIlIIIIIIllIIIllll = llllllllllllllIIlIIIIIIllIIIIlII.managedPosZ - llllllllllllllIIlIIIIIIllIIIIlII.posZ;
        final double llllllllllllllIIlIIIIIIllIIIlllI = llllllllllllllIIlIIIIIIllIIlIIII * llllllllllllllIIlIIIIIIllIIlIIII + llllllllllllllIIlIIIIIIllIIIllll * llllllllllllllIIlIIIIIIllIIIllll;
        if (llllllllllllllIIlIIIIIIllIIIlllI >= 64.0) {
            final int llllllllllllllIIlIIIIIIllIIIllIl = (int)llllllllllllllIIlIIIIIIllIIIIlII.managedPosX >> 4;
            final int llllllllllllllIIlIIIIIIllIIIllII = (int)llllllllllllllIIlIIIIIIllIIIIlII.managedPosZ >> 4;
            final int llllllllllllllIIlIIIIIIllIIIlIll = this.playerViewRadius;
            final int llllllllllllllIIlIIIIIIllIIIlIlI = llllllllllllllIIlIIIIIIllIIlIIlI - llllllllllllllIIlIIIIIIllIIIllIl;
            final int llllllllllllllIIlIIIIIIllIIIlIIl = llllllllllllllIIlIIIIIIllIIlIIIl - llllllllllllllIIlIIIIIIllIIIllII;
            if (llllllllllllllIIlIIIIIIllIIIlIlI != 0 || llllllllllllllIIlIIIIIIllIIIlIIl != 0) {
                for (int llllllllllllllIIlIIIIIIllIIIlIII = llllllllllllllIIlIIIIIIllIIlIIlI - llllllllllllllIIlIIIIIIllIIIlIll; llllllllllllllIIlIIIIIIllIIIlIII <= llllllllllllllIIlIIIIIIllIIlIIlI + llllllllllllllIIlIIIIIIllIIIlIll; ++llllllllllllllIIlIIIIIIllIIIlIII) {
                    for (int llllllllllllllIIlIIIIIIllIIIIlll = llllllllllllllIIlIIIIIIllIIlIIIl - llllllllllllllIIlIIIIIIllIIIlIll; llllllllllllllIIlIIIIIIllIIIIlll <= llllllllllllllIIlIIIIIIllIIlIIIl + llllllllllllllIIlIIIIIIllIIIlIll; ++llllllllllllllIIlIIIIIIllIIIIlll) {
                        if (!this.overlaps(llllllllllllllIIlIIIIIIllIIIlIII, llllllllllllllIIlIIIIIIllIIIIlll, llllllllllllllIIlIIIIIIllIIIllIl, llllllllllllllIIlIIIIIIllIIIllII, llllllllllllllIIlIIIIIIllIIIlIll)) {
                            this.getPlayerInstance(llllllllllllllIIlIIIIIIllIIIlIII, llllllllllllllIIlIIIIIIllIIIIlll, true).addPlayer(llllllllllllllIIlIIIIIIllIIIIlII);
                        }
                        if (!this.overlaps(llllllllllllllIIlIIIIIIllIIIlIII - llllllllllllllIIlIIIIIIllIIIlIlI, llllllllllllllIIlIIIIIIllIIIIlll - llllllllllllllIIlIIIIIIllIIIlIIl, llllllllllllllIIlIIIIIIllIIlIIlI, llllllllllllllIIlIIIIIIllIIlIIIl, llllllllllllllIIlIIIIIIllIIIlIll)) {
                            final PlayerInstance llllllllllllllIIlIIIIIIllIIIIllI = this.getPlayerInstance(llllllllllllllIIlIIIIIIllIIIlIII - llllllllllllllIIlIIIIIIllIIIlIlI, llllllllllllllIIlIIIIIIllIIIIlll - llllllllllllllIIlIIIIIIllIIIlIIl, false);
                            if (llllllllllllllIIlIIIIIIllIIIIllI != null) {
                                llllllllllllllIIlIIIIIIllIIIIllI.removePlayer(llllllllllllllIIlIIIIIIllIIIIlII);
                            }
                        }
                    }
                }
                this.filterChunkLoadQueue(llllllllllllllIIlIIIIIIllIIIIlII);
                llllllllllllllIIlIIIIIIllIIIIlII.managedPosX = llllllllllllllIIlIIIIIIllIIIIlII.posX;
                llllllllllllllIIlIIIIIIllIIIIlII.managedPosZ = llllllllllllllIIlIIIIIIllIIIIlII.posZ;
            }
        }
    }
    
    public static int getFurthestViewableBlock(final int llllllllllllllIIlIIIIIIlIlIIIIll) {
        return llllllllllllllIIlIIIIIIlIlIIIIll * 16 - 16;
    }
    
    private PlayerInstance getPlayerInstance(final int llllllllllllllIIlIIIIIlIIIIllllI, final int llllllllllllllIIlIIIIIlIIIIlllIl, final boolean llllllllllllllIIlIIIIIlIIIIlllII) {
        final long llllllllllllllIIlIIIIIlIIIlIIIIl = llllllllllllllIIlIIIIIlIIIIllllI + 2147483647L | llllllllllllllIIlIIIIIlIIIIlllIl + 2147483647L << 32;
        PlayerInstance llllllllllllllIIlIIIIIlIIIlIIIII = (PlayerInstance)this.playerInstances.getValueByKey(llllllllllllllIIlIIIIIlIIIlIIIIl);
        if (llllllllllllllIIlIIIIIlIIIlIIIII == null && llllllllllllllIIlIIIIIlIIIIlllII) {
            llllllllllllllIIlIIIIIlIIIlIIIII = new PlayerInstance(llllllllllllllIIlIIIIIlIIIIllllI, llllllllllllllIIlIIIIIlIIIIlllIl);
            this.playerInstances.add(llllllllllllllIIlIIIIIlIIIlIIIIl, llllllllllllllIIlIIIIIlIIIlIIIII);
            this.playerInstanceList.add(llllllllllllllIIlIIIIIlIIIlIIIII);
        }
        return llllllllllllllIIlIIIIIlIIIlIIIII;
    }
    
    public void updatePlayerInstances() {
        final long llllllllllllllIIlIIIIIlIIlIIIIlI = this.theWorldServer.getTotalWorldTime();
        if (llllllllllllllIIlIIIIIlIIlIIIIlI - this.previousTotalWorldTime > 8000L) {
            this.previousTotalWorldTime = llllllllllllllIIlIIIIIlIIlIIIIlI;
            for (int llllllllllllllIIlIIIIIlIIlIIIIIl = 0; llllllllllllllIIlIIIIIlIIlIIIIIl < this.playerInstanceList.size(); ++llllllllllllllIIlIIIIIlIIlIIIIIl) {
                final PlayerInstance llllllllllllllIIlIIIIIlIIIllllll = this.playerInstanceList.get(llllllllllllllIIlIIIIIlIIlIIIIIl);
                llllllllllllllIIlIIIIIlIIIllllll.onUpdate();
                llllllllllllllIIlIIIIIlIIIllllll.processChunk();
            }
        }
        else {
            for (int llllllllllllllIIlIIIIIlIIlIIIIII = 0; llllllllllllllIIlIIIIIlIIlIIIIII < this.playerInstancesToUpdate.size(); ++llllllllllllllIIlIIIIIlIIlIIIIII) {
                final PlayerInstance llllllllllllllIIlIIIIIlIIIlllllI = this.playerInstancesToUpdate.get(llllllllllllllIIlIIIIIlIIlIIIIII);
                llllllllllllllIIlIIIIIlIIIlllllI.onUpdate();
            }
        }
        this.playerInstancesToUpdate.clear();
        if (this.players.isEmpty()) {
            final WorldProvider llllllllllllllIIlIIIIIlIIIllllIl = this.theWorldServer.provider;
            if (!llllllllllllllIIlIIIIIlIIIllllIl.canRespawnHere()) {
                this.theWorldServer.theChunkProviderServer.unloadAllChunks();
            }
        }
    }
    
    public void filterChunkLoadQueue(final EntityPlayerMP llllllllllllllIIlIIIIIIllllIlIIl) {
        final ArrayList llllllllllllllIIlIIIIIIllllIlIII = Lists.newArrayList((Iterable)llllllllllllllIIlIIIIIIllllIlIIl.loadedChunks);
        int llllllllllllllIIlIIIIIIllllIIlll = 0;
        final int llllllllllllllIIlIIIIIIllllIIllI = this.playerViewRadius;
        final int llllllllllllllIIlIIIIIIllllIIlIl = (int)llllllllllllllIIlIIIIIIllllIlIIl.posX >> 4;
        final int llllllllllllllIIlIIIIIIllllIIlII = (int)llllllllllllllIIlIIIIIIllllIlIIl.posZ >> 4;
        int llllllllllllllIIlIIIIIIllllIIIll = 0;
        int llllllllllllllIIlIIIIIIllllIIIlI = 0;
        ChunkCoordIntPair llllllllllllllIIlIIIIIIllllIIIIl = this.getPlayerInstance(llllllllllllllIIlIIIIIIllllIIlIl, llllllllllllllIIlIIIIIIllllIIlII, true).currentChunk;
        llllllllllllllIIlIIIIIIllllIlIIl.loadedChunks.clear();
        if (llllllllllllllIIlIIIIIIllllIlIII.contains(llllllllllllllIIlIIIIIIllllIIIIl)) {
            llllllllllllllIIlIIIIIIllllIlIIl.loadedChunks.add(llllllllllllllIIlIIIIIIllllIIIIl);
        }
        for (int llllllllllllllIIlIIIIIIllllIIIII = 1; llllllllllllllIIlIIIIIIllllIIIII <= llllllllllllllIIlIIIIIIllllIIllI * 2; ++llllllllllllllIIlIIIIIIllllIIIII) {
            for (int llllllllllllllIIlIIIIIIlllIlllll = 0; llllllllllllllIIlIIIIIIlllIlllll < 2; ++llllllllllllllIIlIIIIIIlllIlllll) {
                final int[] llllllllllllllIIlIIIIIIlllIllllI = this.xzDirectionsConst[llllllllllllllIIlIIIIIIllllIIlll++ % 4];
                for (int llllllllllllllIIlIIIIIIlllIlllIl = 0; llllllllllllllIIlIIIIIIlllIlllIl < llllllllllllllIIlIIIIIIllllIIIII; ++llllllllllllllIIlIIIIIIlllIlllIl) {
                    llllllllllllllIIlIIIIIIllllIIIll += llllllllllllllIIlIIIIIIlllIllllI[0];
                    llllllllllllllIIlIIIIIIllllIIIlI += llllllllllllllIIlIIIIIIlllIllllI[1];
                    llllllllllllllIIlIIIIIIllllIIIIl = this.getPlayerInstance(llllllllllllllIIlIIIIIIllllIIlIl + llllllllllllllIIlIIIIIIllllIIIll, llllllllllllllIIlIIIIIIllllIIlII + llllllllllllllIIlIIIIIIllllIIIlI, true).currentChunk;
                    if (llllllllllllllIIlIIIIIIllllIlIII.contains(llllllllllllllIIlIIIIIIllllIIIIl)) {
                        llllllllllllllIIlIIIIIIllllIlIIl.loadedChunks.add(llllllllllllllIIlIIIIIIllllIIIIl);
                    }
                }
            }
        }
        llllllllllllllIIlIIIIIIllllIIlll %= 4;
        for (int llllllllllllllIIlIIIIIIllllIIIII = 0; llllllllllllllIIlIIIIIIllllIIIII < llllllllllllllIIlIIIIIIllllIIllI * 2; ++llllllllllllllIIlIIIIIIllllIIIII) {
            llllllllllllllIIlIIIIIIllllIIIll += this.xzDirectionsConst[llllllllllllllIIlIIIIIIllllIIlll][0];
            llllllllllllllIIlIIIIIIllllIIIlI += this.xzDirectionsConst[llllllllllllllIIlIIIIIIllllIIlll][1];
            llllllllllllllIIlIIIIIIllllIIIIl = this.getPlayerInstance(llllllllllllllIIlIIIIIIllllIIlIl + llllllllllllllIIlIIIIIIllllIIIll, llllllllllllllIIlIIIIIIllllIIlII + llllllllllllllIIlIIIIIIllllIIIlI, true).currentChunk;
            if (llllllllllllllIIlIIIIIIllllIlIII.contains(llllllllllllllIIlIIIIIIllllIIIIl)) {
                llllllllllllllIIlIIIIIIllllIlIIl.loadedChunks.add(llllllllllllllIIlIIIIIIllllIIIIl);
            }
        }
    }
    
    class PlayerInstance
    {
        private /* synthetic */ short[] locationOfBlockChange;
        private final /* synthetic */ List playersWatchingChunk;
        private /* synthetic */ int flagsYAreasToUpdate;
        private /* synthetic */ long previousWorldTime;
        private final /* synthetic */ ChunkCoordIntPair currentChunk;
        private /* synthetic */ int numBlocksToUpdate;
        
        private void increaseInhabitedTime(final Chunk llllllllllllllIIlllllIllIllIlIlI) {
            llllllllllllllIIlllllIllIllIlIlI.setInhabitedTime(llllllllllllllIIlllllIllIllIlIlI.getInhabitedTime() + PlayerManager.this.theWorldServer.getTotalWorldTime() - this.previousWorldTime);
            this.previousWorldTime = PlayerManager.this.theWorldServer.getTotalWorldTime();
        }
        
        public void processChunk() {
            this.increaseInhabitedTime(PlayerManager.this.theWorldServer.getChunkFromChunkCoords(this.currentChunk.chunkXPos, this.currentChunk.chunkZPos));
        }
        
        public void flagChunkForUpdate(final int llllllllllllllIIlllllIllIllIIIlI, final int llllllllllllllIIlllllIllIlIllIll, final int llllllllllllllIIlllllIllIlIllIlI) {
            if (this.numBlocksToUpdate == 0) {
                PlayerManager.this.playerInstancesToUpdate.add(this);
            }
            this.flagsYAreasToUpdate |= 1 << (llllllllllllllIIlllllIllIlIllIll >> 4);
            if (this.numBlocksToUpdate < 64) {
                final short llllllllllllllIIlllllIllIlIlllll = (short)(llllllllllllllIIlllllIllIllIIIlI << 12 | llllllllllllllIIlllllIllIlIllIlI << 8 | llllllllllllllIIlllllIllIlIllIll);
                for (int llllllllllllllIIlllllIllIlIllllI = 0; llllllllllllllIIlllllIllIlIllllI < this.numBlocksToUpdate; ++llllllllllllllIIlllllIllIlIllllI) {
                    if (this.locationOfBlockChange[llllllllllllllIIlllllIllIlIllllI] == llllllllllllllIIlllllIllIlIlllll) {
                        return;
                    }
                }
                this.locationOfBlockChange[this.numBlocksToUpdate++] = llllllllllllllIIlllllIllIlIlllll;
            }
        }
        
        public void sendToAllPlayersWatchingChunk(final Packet llllllllllllllIIlllllIllIlIlIIlI) {
            for (int llllllllllllllIIlllllIllIlIlIIIl = 0; llllllllllllllIIlllllIllIlIlIIIl < this.playersWatchingChunk.size(); ++llllllllllllllIIlllllIllIlIlIIIl) {
                final EntityPlayerMP llllllllllllllIIlllllIllIlIlIIII = this.playersWatchingChunk.get(llllllllllllllIIlllllIllIlIlIIIl);
                if (!llllllllllllllIIlllllIllIlIlIIII.loadedChunks.contains(this.currentChunk)) {
                    llllllllllllllIIlllllIllIlIlIIII.playerNetServerHandler.sendPacket(llllllllllllllIIlllllIllIlIlIIlI);
                }
            }
        }
        
        public void addPlayer(final EntityPlayerMP llllllllllllllIIlllllIlllIIIIIIl) {
            if (this.playersWatchingChunk.contains(llllllllllllllIIlllllIlllIIIIIIl)) {
                PlayerManager.field_152627_a.debug("Failed to add player. {} already is in chunk {}, {}", new Object[] { llllllllllllllIIlllllIlllIIIIIIl, this.currentChunk.chunkXPos, this.currentChunk.chunkZPos });
            }
            else {
                if (this.playersWatchingChunk.isEmpty()) {
                    this.previousWorldTime = PlayerManager.this.theWorldServer.getTotalWorldTime();
                }
                this.playersWatchingChunk.add(llllllllllllllIIlllllIlllIIIIIIl);
                llllllllllllllIIlllllIlllIIIIIIl.loadedChunks.add(this.currentChunk);
            }
        }
        
        private void sendTileToAllPlayersWatchingChunk(final TileEntity llllllllllllllIIlllllIllIIlIIllI) {
            if (llllllllllllllIIlllllIllIIlIIllI != null) {
                final Packet llllllllllllllIIlllllIllIIlIlIII = llllllllllllllIIlllllIllIIlIIllI.getDescriptionPacket();
                if (llllllllllllllIIlllllIllIIlIlIII != null) {
                    this.sendToAllPlayersWatchingChunk(llllllllllllllIIlllllIllIIlIlIII);
                }
            }
        }
        
        public void onUpdate() {
            if (this.numBlocksToUpdate != 0) {
                if (this.numBlocksToUpdate == 1) {
                    final int llllllllllllllIIlllllIllIlIIIIll = (this.locationOfBlockChange[0] >> 12 & 0xF) + this.currentChunk.chunkXPos * 16;
                    final int llllllllllllllIIlllllIllIlIIIIII = this.locationOfBlockChange[0] & 0xFF;
                    final int llllllllllllllIIlllllIllIIllllIl = (this.locationOfBlockChange[0] >> 8 & 0xF) + this.currentChunk.chunkZPos * 16;
                    final BlockPos llllllllllllllIIlllllIllIIlllIlI = new BlockPos(llllllllllllllIIlllllIllIlIIIIll, llllllllllllllIIlllllIllIlIIIIII, llllllllllllllIIlllllIllIIllllIl);
                    this.sendToAllPlayersWatchingChunk(new S23PacketBlockChange(PlayerManager.this.theWorldServer, llllllllllllllIIlllllIllIIlllIlI));
                    if (PlayerManager.this.theWorldServer.getBlockState(llllllllllllllIIlllllIllIIlllIlI).getBlock().hasTileEntity()) {
                        this.sendTileToAllPlayersWatchingChunk(PlayerManager.this.theWorldServer.getTileEntity(llllllllllllllIIlllllIllIIlllIlI));
                    }
                }
                else if (this.numBlocksToUpdate == 64) {
                    final int llllllllllllllIIlllllIllIlIIIIlI = this.currentChunk.chunkXPos * 16;
                    final int llllllllllllllIIlllllIllIIllllll = this.currentChunk.chunkZPos * 16;
                    this.sendToAllPlayersWatchingChunk(new S21PacketChunkData(PlayerManager.this.theWorldServer.getChunkFromChunkCoords(this.currentChunk.chunkXPos, this.currentChunk.chunkZPos), false, this.flagsYAreasToUpdate));
                    for (int llllllllllllllIIlllllIllIIllllII = 0; llllllllllllllIIlllllIllIIllllII < 16; ++llllllllllllllIIlllllIllIIllllII) {
                        if ((this.flagsYAreasToUpdate & 1 << llllllllllllllIIlllllIllIIllllII) != 0x0) {
                            final int llllllllllllllIIlllllIllIIlllIIl = llllllllllllllIIlllllIllIIllllII << 4;
                            final List llllllllllllllIIlllllIllIIllIlll = PlayerManager.this.theWorldServer.func_147486_a(llllllllllllllIIlllllIllIlIIIIlI, llllllllllllllIIlllllIllIIlllIIl, llllllllllllllIIlllllIllIIllllll, llllllllllllllIIlllllIllIlIIIIlI + 16, llllllllllllllIIlllllIllIIlllIIl + 16, llllllllllllllIIlllllIllIIllllll + 16);
                            for (int llllllllllllllIIlllllIllIIllIllI = 0; llllllllllllllIIlllllIllIIllIllI < llllllllllllllIIlllllIllIIllIlll.size(); ++llllllllllllllIIlllllIllIIllIllI) {
                                this.sendTileToAllPlayersWatchingChunk(llllllllllllllIIlllllIllIIllIlll.get(llllllllllllllIIlllllIllIIllIllI));
                            }
                        }
                    }
                }
                else {
                    this.sendToAllPlayersWatchingChunk(new S22PacketMultiBlockChange(this.numBlocksToUpdate, this.locationOfBlockChange, PlayerManager.this.theWorldServer.getChunkFromChunkCoords(this.currentChunk.chunkXPos, this.currentChunk.chunkZPos)));
                    for (int llllllllllllllIIlllllIllIlIIIIIl = 0; llllllllllllllIIlllllIllIlIIIIIl < this.numBlocksToUpdate; ++llllllllllllllIIlllllIllIlIIIIIl) {
                        final int llllllllllllllIIlllllIllIIlllllI = (this.locationOfBlockChange[llllllllllllllIIlllllIllIlIIIIIl] >> 12 & 0xF) + this.currentChunk.chunkXPos * 16;
                        final int llllllllllllllIIlllllIllIIlllIll = this.locationOfBlockChange[llllllllllllllIIlllllIllIlIIIIIl] & 0xFF;
                        final int llllllllllllllIIlllllIllIIlllIII = (this.locationOfBlockChange[llllllllllllllIIlllllIllIlIIIIIl] >> 8 & 0xF) + this.currentChunk.chunkZPos * 16;
                        final BlockPos llllllllllllllIIlllllIllIIllIlIl = new BlockPos(llllllllllllllIIlllllIllIIlllllI, llllllllllllllIIlllllIllIIlllIll, llllllllllllllIIlllllIllIIlllIII);
                        if (PlayerManager.this.theWorldServer.getBlockState(llllllllllllllIIlllllIllIIllIlIl).getBlock().hasTileEntity()) {
                            this.sendTileToAllPlayersWatchingChunk(PlayerManager.this.theWorldServer.getTileEntity(llllllllllllllIIlllllIllIIllIlIl));
                        }
                    }
                }
                this.numBlocksToUpdate = 0;
                this.flagsYAreasToUpdate = 0;
            }
        }
        
        public PlayerInstance(final int llllllllllllllIIlllllIlllIIIIllI, final int llllllllllllllIIlllllIlllIIIIlIl) {
            this.playersWatchingChunk = Lists.newArrayList();
            this.locationOfBlockChange = new short[64];
            this.currentChunk = new ChunkCoordIntPair(llllllllllllllIIlllllIlllIIIIllI, llllllllllllllIIlllllIlllIIIIlIl);
            PlayerManager.this.getMinecraftServer().theChunkProviderServer.loadChunk(llllllllllllllIIlllllIlllIIIIllI, llllllllllllllIIlllllIlllIIIIlIl);
        }
        
        public void removePlayer(final EntityPlayerMP llllllllllllllIIlllllIllIllllIIl) {
            if (this.playersWatchingChunk.contains(llllllllllllllIIlllllIllIllllIIl)) {
                final Chunk llllllllllllllIIlllllIllIllllIII = PlayerManager.this.theWorldServer.getChunkFromChunkCoords(this.currentChunk.chunkXPos, this.currentChunk.chunkZPos);
                if (llllllllllllllIIlllllIllIllllIII.isPopulated()) {
                    llllllllllllllIIlllllIllIllllIIl.playerNetServerHandler.sendPacket(new S21PacketChunkData(llllllllllllllIIlllllIllIllllIII, true, 0));
                }
                this.playersWatchingChunk.remove(llllllllllllllIIlllllIllIllllIIl);
                llllllllllllllIIlllllIllIllllIIl.loadedChunks.remove(this.currentChunk);
                if (this.playersWatchingChunk.isEmpty()) {
                    final long llllllllllllllIIlllllIllIlllIlll = this.currentChunk.chunkXPos + 2147483647L | this.currentChunk.chunkZPos + 2147483647L << 32;
                    this.increaseInhabitedTime(llllllllllllllIIlllllIllIllllIII);
                    PlayerManager.this.playerInstances.remove(llllllllllllllIIlllllIllIlllIlll);
                    PlayerManager.this.playerInstanceList.remove(this);
                    if (this.numBlocksToUpdate > 0) {
                        PlayerManager.this.playerInstancesToUpdate.remove(this);
                    }
                    PlayerManager.this.getMinecraftServer().theChunkProviderServer.dropChunk(this.currentChunk.chunkXPos, this.currentChunk.chunkZPos);
                }
            }
        }
        
        static {
            __OBFID = "CL_00001435";
        }
    }
}
