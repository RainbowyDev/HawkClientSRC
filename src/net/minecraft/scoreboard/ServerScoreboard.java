package net.minecraft.scoreboard;

import net.minecraft.server.*;
import net.minecraft.network.*;
import com.google.common.collect.*;
import net.minecraft.network.play.server.*;
import java.util.*;
import net.minecraft.entity.player.*;

public class ServerScoreboard extends Scoreboard
{
    private /* synthetic */ ScoreboardSaveData field_96554_c;
    private final /* synthetic */ Set field_96553_b;
    private final /* synthetic */ MinecraftServer scoreboardMCServer;
    
    public ServerScoreboard(final MinecraftServer llllllllllllllIlllIIIlIllIIIlIlI) {
        this.field_96553_b = Sets.newHashSet();
        this.scoreboardMCServer = llllllllllllllIlllIIIlIllIIIlIlI;
    }
    
    protected void func_96551_b() {
        if (this.field_96554_c != null) {
            this.field_96554_c.markDirty();
        }
    }
    
    @Override
    public void setObjectiveInDisplaySlot(final int llllllllllllllIlllIIIlIlIllIllIl, final ScoreObjective llllllllllllllIlllIIIlIlIllIllII) {
        final ScoreObjective llllllllllllllIlllIIIlIlIllIlIll = this.getObjectiveInDisplaySlot(llllllllllllllIlllIIIlIlIllIllIl);
        super.setObjectiveInDisplaySlot(llllllllllllllIlllIIIlIlIllIllIl, llllllllllllllIlllIIIlIlIllIllII);
        if (llllllllllllllIlllIIIlIlIllIlIll != llllllllllllllIlllIIIlIlIllIllII && llllllllllllllIlllIIIlIlIllIlIll != null) {
            if (this.func_96552_h(llllllllllllllIlllIIIlIlIllIlIll) > 0) {
                this.scoreboardMCServer.getConfigurationManager().sendPacketToAllPlayers(new S3DPacketDisplayScoreboard(llllllllllllllIlllIIIlIlIllIllIl, llllllllllllllIlllIIIlIlIllIllII));
            }
            else {
                this.func_96546_g(llllllllllllllIlllIIIlIlIllIlIll);
            }
        }
        if (llllllllllllllIlllIIIlIlIllIllII != null) {
            if (this.field_96553_b.contains(llllllllllllllIlllIIIlIlIllIllII)) {
                this.scoreboardMCServer.getConfigurationManager().sendPacketToAllPlayers(new S3DPacketDisplayScoreboard(llllllllllllllIlllIIIlIlIllIllIl, llllllllllllllIlllIIIlIlIllIllII));
            }
            else {
                this.func_96549_e(llllllllllllllIlllIIIlIlIllIllII);
            }
        }
        this.func_96551_b();
    }
    
    @Override
    public void func_178820_a(final String llllllllllllllIlllIIIlIlIlllIlII, final ScoreObjective llllllllllllllIlllIIIlIlIlllIIll) {
        super.func_178820_a(llllllllllllllIlllIIIlIlIlllIlII, llllllllllllllIlllIIIlIlIlllIIll);
        this.scoreboardMCServer.getConfigurationManager().sendPacketToAllPlayers(new S3CPacketUpdateScore(llllllllllllllIlllIIIlIlIlllIlII, llllllllllllllIlllIIIlIlIlllIIll));
        this.func_96551_b();
    }
    
    public List func_96550_d(final ScoreObjective llllllllllllllIlllIIIlIlIIIllllI) {
        final ArrayList llllllllllllllIlllIIIlIlIIIlllIl = Lists.newArrayList();
        llllllllllllllIlllIIIlIlIIIlllIl.add(new S3BPacketScoreboardObjective(llllllllllllllIlllIIIlIlIIIllllI, 0));
        for (int llllllllllllllIlllIIIlIlIIIlllII = 0; llllllllllllllIlllIIIlIlIIIlllII < 19; ++llllllllllllllIlllIIIlIlIIIlllII) {
            if (this.getObjectiveInDisplaySlot(llllllllllllllIlllIIIlIlIIIlllII) == llllllllllllllIlllIIIlIlIIIllllI) {
                llllllllllllllIlllIIIlIlIIIlllIl.add(new S3DPacketDisplayScoreboard(llllllllllllllIlllIIIlIlIIIlllII, llllllllllllllIlllIIIlIlIIIllllI));
            }
        }
        for (final Score llllllllllllllIlllIIIlIlIIIllIlI : this.getSortedScores(llllllllllllllIlllIIIlIlIIIllllI)) {
            llllllllllllllIlllIIIlIlIIIlllIl.add(new S3CPacketUpdateScore(llllllllllllllIlllIIIlIlIIIllIlI));
        }
        return llllllllllllllIlllIIIlIlIIIlllIl;
    }
    
    @Override
    public void func_96536_a(final Score llllllllllllllIlllIIIlIllIIIIlII) {
        super.func_96536_a(llllllllllllllIlllIIIlIllIIIIlII);
        if (this.field_96553_b.contains(llllllllllllllIlllIIIlIllIIIIlII.getObjective())) {
            this.scoreboardMCServer.getConfigurationManager().sendPacketToAllPlayers(new S3CPacketUpdateScore(llllllllllllllIlllIIIlIllIIIIlII));
        }
        this.func_96551_b();
    }
    
    @Override
    public void func_96522_a(final ScoreObjective llllllllllllllIlllIIIlIlIlIIlllI) {
        super.func_96522_a(llllllllllllllIlllIIIlIlIlIIlllI);
        this.func_96551_b();
    }
    
    @Override
    public void broadcastTeamCreated(final ScorePlayerTeam llllllllllllllIlllIIIlIlIIlllIlI) {
        super.broadcastTeamCreated(llllllllllllllIlllIIIlIlIIlllIlI);
        this.scoreboardMCServer.getConfigurationManager().sendPacketToAllPlayers(new S3EPacketTeams(llllllllllllllIlllIIIlIlIIlllIlI, 0));
        this.func_96551_b();
    }
    
    @Override
    public void broadcastTeamRemoved(final ScorePlayerTeam llllllllllllllIlllIIIlIlIIllIlII) {
        super.broadcastTeamRemoved(llllllllllllllIlllIIIlIlIIllIlII);
        this.scoreboardMCServer.getConfigurationManager().sendPacketToAllPlayers(new S3EPacketTeams(llllllllllllllIlllIIIlIlIIllIlII, 2));
        this.func_96551_b();
    }
    
    @Override
    public void func_96532_b(final ScoreObjective llllllllllllllIlllIIIlIlIlIIIllI) {
        super.func_96532_b(llllllllllllllIlllIIIlIlIlIIIllI);
        if (this.field_96553_b.contains(llllllllllllllIlllIIIlIlIlIIIllI)) {
            this.scoreboardMCServer.getConfigurationManager().sendPacketToAllPlayers(new S3BPacketScoreboardObjective(llllllllllllllIlllIIIlIlIlIIIllI, 2));
        }
        this.func_96551_b();
    }
    
    @Override
    public boolean func_151392_a(final String llllllllllllllIlllIIIlIlIllIIIIl, final String llllllllllllllIlllIIIlIlIllIIIII) {
        if (super.func_151392_a(llllllllllllllIlllIIIlIlIllIIIIl, llllllllllllllIlllIIIlIlIllIIIII)) {
            final ScorePlayerTeam llllllllllllllIlllIIIlIlIlIlllll = this.getTeam(llllllllllllllIlllIIIlIlIllIIIII);
            this.scoreboardMCServer.getConfigurationManager().sendPacketToAllPlayers(new S3EPacketTeams(llllllllllllllIlllIIIlIlIlIlllll, Arrays.asList(llllllllllllllIlllIIIlIlIllIIIIl), 3));
            this.func_96551_b();
            return true;
        }
        return false;
    }
    
    @Override
    public void func_96516_a(final String llllllllllllllIlllIIIlIlIllllllI) {
        super.func_96516_a(llllllllllllllIlllIIIlIlIllllllI);
        this.scoreboardMCServer.getConfigurationManager().sendPacketToAllPlayers(new S3CPacketUpdateScore(llllllllllllllIlllIIIlIlIllllllI));
        this.func_96551_b();
    }
    
    public void func_96549_e(final ScoreObjective llllllllllllllIlllIIIlIlIIIIIlIl) {
        final List llllllllllllllIlllIIIlIlIIIIlIll = this.func_96550_d(llllllllllllllIlllIIIlIlIIIIIlIl);
        for (final EntityPlayerMP llllllllllllllIlllIIIlIlIIIIlIIl : this.scoreboardMCServer.getConfigurationManager().playerEntityList) {
            for (final Packet llllllllllllllIlllIIIlIlIIIIIlll : llllllllllllllIlllIIIlIlIIIIlIll) {
                llllllllllllllIlllIIIlIlIIIIlIIl.playerNetServerHandler.sendPacket(llllllllllllllIlllIIIlIlIIIIIlll);
            }
        }
        this.field_96553_b.add(llllllllllllllIlllIIIlIlIIIIIlIl);
    }
    
    @Override
    public void func_96533_c(final ScoreObjective llllllllllllllIlllIIIlIlIlIIIIlI) {
        super.func_96533_c(llllllllllllllIlllIIIlIlIlIIIIlI);
        if (this.field_96553_b.contains(llllllllllllllIlllIIIlIlIlIIIIlI)) {
            this.func_96546_g(llllllllllllllIlllIIIlIlIlIIIIlI);
        }
        this.func_96551_b();
    }
    
    @Override
    public void func_96513_c(final ScorePlayerTeam llllllllllllllIlllIIIlIlIIlIlllI) {
        super.func_96513_c(llllllllllllllIlllIIIlIlIIlIlllI);
        this.scoreboardMCServer.getConfigurationManager().sendPacketToAllPlayers(new S3EPacketTeams(llllllllllllllIlllIIIlIlIIlIlllI, 1));
        this.func_96551_b();
    }
    
    public List func_96548_f(final ScoreObjective llllllllllllllIlllIIIlIIlllllIlI) {
        final ArrayList llllllllllllllIlllIIIlIIlllllIIl = Lists.newArrayList();
        llllllllllllllIlllIIIlIIlllllIIl.add(new S3BPacketScoreboardObjective(llllllllllllllIlllIIIlIIlllllIlI, 1));
        for (int llllllllllllllIlllIIIlIIlllllIII = 0; llllllllllllllIlllIIIlIIlllllIII < 19; ++llllllllllllllIlllIIIlIIlllllIII) {
            if (this.getObjectiveInDisplaySlot(llllllllllllllIlllIIIlIIlllllIII) == llllllllllllllIlllIIIlIIlllllIlI) {
                llllllllllllllIlllIIIlIIlllllIIl.add(new S3DPacketDisplayScoreboard(llllllllllllllIlllIIIlIIlllllIII, llllllllllllllIlllIIIlIIlllllIlI));
            }
        }
        return llllllllllllllIlllIIIlIIlllllIIl;
    }
    
    static {
        __OBFID = "CL_00001424";
    }
    
    public int func_96552_h(final ScoreObjective llllllllllllllIlllIIIlIIllIllIIl) {
        int llllllllllllllIlllIIIlIIllIllIII = 0;
        for (int llllllllllllllIlllIIIlIIllIlIlll = 0; llllllllllllllIlllIIIlIIllIlIlll < 19; ++llllllllllllllIlllIIIlIIllIlIlll) {
            if (this.getObjectiveInDisplaySlot(llllllllllllllIlllIIIlIIllIlIlll) == llllllllllllllIlllIIIlIIllIllIIl) {
                ++llllllllllllllIlllIIIlIIllIllIII;
            }
        }
        return llllllllllllllIlllIIIlIIllIllIII;
    }
    
    @Override
    public void removePlayerFromTeam(final String llllllllllllllIlllIIIlIlIlIlIllI, final ScorePlayerTeam llllllllllllllIlllIIIlIlIlIlIlIl) {
        super.removePlayerFromTeam(llllllllllllllIlllIIIlIlIlIlIllI, llllllllllllllIlllIIIlIlIlIlIlIl);
        this.scoreboardMCServer.getConfigurationManager().sendPacketToAllPlayers(new S3EPacketTeams(llllllllllllllIlllIIIlIlIlIlIlIl, Arrays.asList(llllllllllllllIlllIIIlIlIlIlIllI), 4));
        this.func_96551_b();
    }
    
    public void func_96547_a(final ScoreboardSaveData llllllllllllllIlllIIIlIlIIlIlIII) {
        this.field_96554_c = llllllllllllllIlllIIIlIlIIlIlIII;
    }
    
    public void func_96546_g(final ScoreObjective llllllllllllllIlllIIIlIIlllIlIll) {
        final List llllllllllllllIlllIIIlIIlllIlIlI = this.func_96548_f(llllllllllllllIlllIIIlIIlllIlIll);
        for (final EntityPlayerMP llllllllllllllIlllIIIlIIlllIlIII : this.scoreboardMCServer.getConfigurationManager().playerEntityList) {
            for (final Packet llllllllllllllIlllIIIlIIlllIIllI : llllllllllllllIlllIIIlIIlllIlIlI) {
                llllllllllllllIlllIIIlIIlllIlIII.playerNetServerHandler.sendPacket(llllllllllllllIlllIIIlIIlllIIllI);
            }
        }
        this.field_96553_b.remove(llllllllllllllIlllIIIlIIlllIlIll);
    }
}
