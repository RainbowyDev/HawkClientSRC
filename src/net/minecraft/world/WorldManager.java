package net.minecraft.world;

import net.minecraft.server.*;
import net.minecraft.util.*;
import net.minecraft.network.*;
import net.minecraft.entity.player.*;
import net.minecraft.network.play.server.*;
import java.util.*;
import net.minecraft.entity.*;

public class WorldManager implements IWorldAccess
{
    private /* synthetic */ WorldServer theWorldServer;
    private /* synthetic */ MinecraftServer mcServer;
    
    @Override
    public void markBlockForUpdate(final BlockPos lllllllllllllllIlIIIlllIllIlIlIl) {
        this.theWorldServer.getPlayerManager().func_180244_a(lllllllllllllllIlIIIlllIllIlIlIl);
    }
    
    public WorldManager(final MinecraftServer lllllllllllllllIlIIIllllIIlIIlll, final WorldServer lllllllllllllllIlIIIllllIIlIIIll) {
        this.mcServer = lllllllllllllllIlIIIllllIIlIIlll;
        this.theWorldServer = lllllllllllllllIlIIIllllIIlIIIll;
    }
    
    @Override
    public void notifyLightSet(final BlockPos lllllllllllllllIlIIIlllIllIlIIIl) {
    }
    
    @Override
    public void func_180442_a(final int lllllllllllllllIlIIIllllIIlIIIIl, final boolean lllllllllllllllIlIIIllllIIlIIIII, final double lllllllllllllllIlIIIllllIIIlllll, final double lllllllllllllllIlIIIllllIIIllllI, final double lllllllllllllllIlIIIllllIIIlllIl, final double lllllllllllllllIlIIIllllIIIlllII, final double lllllllllllllllIlIIIllllIIIllIll, final double lllllllllllllllIlIIIllllIIIllIlI, final int... lllllllllllllllIlIIIllllIIIllIIl) {
    }
    
    @Override
    public void playSoundToNearExcept(final EntityPlayer lllllllllllllllIlIIIlllIlllIIllI, final String lllllllllllllllIlIIIlllIlllIIlIl, final double lllllllllllllllIlIIIlllIlllIIlII, final double lllllllllllllllIlIIIlllIlllIlIll, final double lllllllllllllllIlIIIlllIlllIIIlI, final float lllllllllllllllIlIIIlllIlllIlIIl, final float lllllllllllllllIlIIIlllIlllIlIII) {
        this.mcServer.getConfigurationManager().sendToAllNearExcept(lllllllllllllllIlIIIlllIlllIIllI, lllllllllllllllIlIIIlllIlllIIlII, lllllllllllllllIlIIIlllIlllIlIll, lllllllllllllllIlIIIlllIlllIIIlI, (lllllllllllllllIlIIIlllIlllIlIIl > 1.0f) ? ((double)(16.0f * lllllllllllllllIlIIIlllIlllIlIIl)) : 16.0, this.theWorldServer.provider.getDimensionId(), new S29PacketSoundEffect(lllllllllllllllIlIIIlllIlllIIlIl, lllllllllllllllIlIIIlllIlllIIlII, lllllllllllllllIlIIIlllIlllIlIll, lllllllllllllllIlIIIlllIlllIIIlI, lllllllllllllllIlIIIlllIlllIlIIl, lllllllllllllllIlIIIlllIlllIlIII));
    }
    
    @Override
    public void func_180440_a(final int lllllllllllllllIlIIIlllIlIlllIIl, final BlockPos lllllllllllllllIlIIIlllIlIllIlII, final int lllllllllllllllIlIIIlllIlIllIlll) {
        this.mcServer.getConfigurationManager().sendPacketToAllPlayers(new S28PacketEffect(lllllllllllllllIlIIIlllIlIlllIIl, lllllllllllllllIlIIIlllIlIllIlII, lllllllllllllllIlIIIlllIlIllIlll, true));
    }
    
    @Override
    public void func_180439_a(final EntityPlayer lllllllllllllllIlIIIlllIllIIIlll, final int lllllllllllllllIlIIIlllIllIIIIIl, final BlockPos lllllllllllllllIlIIIlllIllIIIlIl, final int lllllllllllllllIlIIIlllIlIllllll) {
        this.mcServer.getConfigurationManager().sendToAllNearExcept(lllllllllllllllIlIIIlllIllIIIlll, lllllllllllllllIlIIIlllIllIIIlIl.getX(), lllllllllllllllIlIIIlllIllIIIlIl.getY(), lllllllllllllllIlIIIlllIllIIIlIl.getZ(), 64.0, this.theWorldServer.provider.getDimensionId(), new S28PacketEffect(lllllllllllllllIlIIIlllIllIIIIIl, lllllllllllllllIlIIIlllIllIIIlIl, lllllllllllllllIlIIIlllIlIllllll, false));
    }
    
    @Override
    public void markBlockRangeForRenderUpdate(final int lllllllllllllllIlIIIlllIllIllllI, final int lllllllllllllllIlIIIlllIllIlllIl, final int lllllllllllllllIlIIIlllIllIlllII, final int lllllllllllllllIlIIIlllIllIllIll, final int lllllllllllllllIlIIIlllIllIllIlI, final int lllllllllllllllIlIIIlllIllIllIIl) {
    }
    
    @Override
    public void func_174961_a(final String lllllllllllllllIlIIIlllIllIIllll, final BlockPos lllllllllllllllIlIIIlllIllIIlllI) {
    }
    
    @Override
    public void playSound(final String lllllllllllllllIlIIIlllIllllllIl, final double lllllllllllllllIlIIIllllIIIIIIll, final double lllllllllllllllIlIIIllllIIIIIIlI, final double lllllllllllllllIlIIIlllIlllllIlI, final float lllllllllllllllIlIIIllllIIIIIIII, final float lllllllllllllllIlIIIlllIlllllIII) {
        this.mcServer.getConfigurationManager().sendToAllNear(lllllllllllllllIlIIIllllIIIIIIll, lllllllllllllllIlIIIllllIIIIIIlI, lllllllllllllllIlIIIlllIlllllIlI, (lllllllllllllllIlIIIllllIIIIIIII > 1.0f) ? ((double)(16.0f * lllllllllllllllIlIIIllllIIIIIIII)) : 16.0, this.theWorldServer.provider.getDimensionId(), new S29PacketSoundEffect(lllllllllllllllIlIIIlllIllllllIl, lllllllllllllllIlIIIllllIIIIIIll, lllllllllllllllIlIIIllllIIIIIIlI, lllllllllllllllIlIIIlllIlllllIlI, lllllllllllllllIlIIIllllIIIIIIII, lllllllllllllllIlIIIlllIlllllIII));
    }
    
    static {
        __OBFID = "CL_00001433";
    }
    
    @Override
    public void sendBlockBreakProgress(final int lllllllllllllllIlIIIlllIlIIlllll, final BlockPos lllllllllllllllIlIIIlllIlIIllllI, final int lllllllllllllllIlIIIlllIlIlIIllI) {
        for (final EntityPlayerMP lllllllllllllllIlIIIlllIlIlIIlII : this.mcServer.getConfigurationManager().playerEntityList) {
            if (lllllllllllllllIlIIIlllIlIlIIlII != null && lllllllllllllllIlIIIlllIlIlIIlII.worldObj == this.theWorldServer && lllllllllllllllIlIIIlllIlIlIIlII.getEntityId() != lllllllllllllllIlIIIlllIlIIlllll) {
                final double lllllllllllllllIlIIIlllIlIlIIIll = lllllllllllllllIlIIIlllIlIIllllI.getX() - lllllllllllllllIlIIIlllIlIlIIlII.posX;
                final double lllllllllllllllIlIIIlllIlIlIIIlI = lllllllllllllllIlIIIlllIlIIllllI.getY() - lllllllllllllllIlIIIlllIlIlIIlII.posY;
                final double lllllllllllllllIlIIIlllIlIlIIIIl = lllllllllllllllIlIIIlllIlIIllllI.getZ() - lllllllllllllllIlIIIlllIlIlIIlII.posZ;
                if (lllllllllllllllIlIIIlllIlIlIIIll * lllllllllllllllIlIIIlllIlIlIIIll + lllllllllllllllIlIIIlllIlIlIIIlI * lllllllllllllllIlIIIlllIlIlIIIlI + lllllllllllllllIlIIIlllIlIlIIIIl * lllllllllllllllIlIIIlllIlIlIIIIl >= 1024.0) {
                    continue;
                }
                lllllllllllllllIlIIIlllIlIlIIlII.playerNetServerHandler.sendPacket(new S25PacketBlockBreakAnim(lllllllllllllllIlIIIlllIlIIlllll, lllllllllllllllIlIIIlllIlIIllllI, lllllllllllllllIlIIIlllIlIlIIllI));
            }
        }
    }
    
    @Override
    public void onEntityRemoved(final Entity lllllllllllllllIlIIIllllIIIIllll) {
        this.theWorldServer.getEntityTracker().untrackEntity(lllllllllllllllIlIIIllllIIIIllll);
    }
    
    @Override
    public void onEntityAdded(final Entity lllllllllllllllIlIIIllllIIIlIlIl) {
        this.theWorldServer.getEntityTracker().trackEntity(lllllllllllllllIlIIIllllIIIlIlIl);
    }
}
