package net.minecraft.scoreboard;

import net.minecraft.util.*;
import com.google.common.collect.*;
import java.util.*;

public class ScorePlayerTeam extends Team
{
    private final /* synthetic */ Scoreboard theScoreboard;
    private /* synthetic */ String namePrefixSPT;
    private final /* synthetic */ Set membershipSet;
    private /* synthetic */ String teamNameSPT;
    private /* synthetic */ EnumVisible field_178778_i;
    private /* synthetic */ String colorSuffix;
    private /* synthetic */ EnumVisible field_178776_j;
    private /* synthetic */ EnumChatFormatting field_178777_k;
    private final /* synthetic */ String field_96675_b;
    private /* synthetic */ boolean canSeeFriendlyInvisibles;
    private /* synthetic */ boolean allowFriendlyFire;
    
    public ScorePlayerTeam(final Scoreboard lllllllllllllllIllIlIIIllIIIIIll, final String lllllllllllllllIllIlIIIlIlllllll) {
        this.membershipSet = Sets.newHashSet();
        this.namePrefixSPT = "";
        this.colorSuffix = "";
        this.allowFriendlyFire = true;
        this.canSeeFriendlyInvisibles = true;
        this.field_178778_i = EnumVisible.ALWAYS;
        this.field_178776_j = EnumVisible.ALWAYS;
        this.field_178777_k = EnumChatFormatting.RESET;
        this.theScoreboard = lllllllllllllllIllIlIIIllIIIIIll;
        this.field_96675_b = lllllllllllllllIllIlIIIlIlllllll;
        this.teamNameSPT = lllllllllllllllIllIlIIIlIlllllll;
    }
    
    public static String formatPlayerName(final Team lllllllllllllllIllIlIIIlIlIlIIll, final String lllllllllllllllIllIlIIIlIlIlIIlI) {
        return (lllllllllllllllIllIlIIIlIlIlIIll == null) ? lllllllllllllllIllIlIIIlIlIlIIlI : lllllllllllllllIllIlIIIlIlIlIIll.formatString(lllllllllllllllIllIlIIIlIlIlIIlI);
    }
    
    public String getColorSuffix() {
        return this.colorSuffix;
    }
    
    public void func_98298_a(final int lllllllllllllllIllIlIIIlIIlIIIlI) {
        this.setAllowFriendlyFire((lllllllllllllllIllIlIIIlIIlIIIlI & 0x1) > 0);
        this.setSeeFriendlyInvisiblesEnabled((lllllllllllllllIllIlIIIlIIlIIIlI & 0x2) > 0);
    }
    
    public void func_178774_a(final EnumChatFormatting lllllllllllllllIllIlIIIlIIIlllII) {
        this.field_178777_k = lllllllllllllllIllIlIIIlIIIlllII;
    }
    
    public EnumChatFormatting func_178775_l() {
        return this.field_178777_k;
    }
    
    public void setSeeFriendlyInvisiblesEnabled(final boolean lllllllllllllllIllIlIIIlIlIIIIlI) {
        this.canSeeFriendlyInvisibles = lllllllllllllllIllIlIIIlIlIIIIlI;
        this.theScoreboard.broadcastTeamRemoved(this);
    }
    
    public int func_98299_i() {
        int lllllllllllllllIllIlIIIlIIlIlIlI = 0;
        if (this.getAllowFriendlyFire()) {
            lllllllllllllllIllIlIIIlIIlIlIlI |= 0x1;
        }
        if (this.func_98297_h()) {
            lllllllllllllllIllIlIIIlIIlIlIlI |= 0x2;
        }
        return lllllllllllllllIllIlIIIlIIlIlIlI;
    }
    
    @Override
    public EnumVisible func_178770_i() {
        return this.field_178778_i;
    }
    
    public String getColorPrefix() {
        return this.namePrefixSPT;
    }
    
    @Override
    public EnumVisible func_178771_j() {
        return this.field_178776_j;
    }
    
    public String func_96669_c() {
        return this.teamNameSPT;
    }
    
    public void setNameSuffix(final String lllllllllllllllIllIlIIIlIlIllllI) {
        this.colorSuffix = lllllllllllllllIllIlIIIlIlIllllI;
        this.theScoreboard.broadcastTeamRemoved(this);
    }
    
    public void setAllowFriendlyFire(final boolean lllllllllllllllIllIlIIIlIlIIlIll) {
        this.allowFriendlyFire = lllllllllllllllIllIlIIIlIlIIlIll;
        this.theScoreboard.broadcastTeamRemoved(this);
    }
    
    @Override
    public String formatString(final String lllllllllllllllIllIlIIIlIlIllIII) {
        return String.valueOf(new StringBuilder(String.valueOf(this.getColorPrefix())).append(lllllllllllllllIllIlIIIlIlIllIII).append(this.getColorSuffix()));
    }
    
    @Override
    public boolean getAllowFriendlyFire() {
        return this.allowFriendlyFire;
    }
    
    static {
        __OBFID = "CL_00000616";
    }
    
    public void func_178773_b(final EnumVisible lllllllllllllllIllIlIIIlIIlIlllI) {
        this.field_178776_j = lllllllllllllllIllIlIIIlIIlIlllI;
        this.theScoreboard.broadcastTeamRemoved(this);
    }
    
    @Override
    public String getRegisteredName() {
        return this.field_96675_b;
    }
    
    public void func_178772_a(final EnumVisible lllllllllllllllIllIlIIIlIIllIlII) {
        this.field_178778_i = lllllllllllllllIllIlIIIlIIllIlII;
        this.theScoreboard.broadcastTeamRemoved(this);
    }
    
    @Override
    public Collection getMembershipCollection() {
        return this.membershipSet;
    }
    
    public void setTeamName(final String lllllllllllllllIllIlIIIlIlllIlIl) {
        if (lllllllllllllllIllIlIIIlIlllIlIl == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        this.teamNameSPT = lllllllllllllllIllIlIIIlIlllIlIl;
        this.theScoreboard.broadcastTeamRemoved(this);
    }
    
    @Override
    public boolean func_98297_h() {
        return this.canSeeFriendlyInvisibles;
    }
    
    public void setNamePrefix(final String lllllllllllllllIllIlIIIlIllIlIIl) {
        if (lllllllllllllllIllIlIIIlIllIlIIl == null) {
            throw new IllegalArgumentException("Prefix cannot be null");
        }
        this.namePrefixSPT = lllllllllllllllIllIlIIIlIllIlIIl;
        this.theScoreboard.broadcastTeamRemoved(this);
    }
}
