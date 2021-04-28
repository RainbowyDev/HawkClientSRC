package net.minecraft.scoreboard;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;
import org.apache.logging.log4j.*;

public class ScoreboardSaveData extends WorldSavedData
{
    private /* synthetic */ Scoreboard theScoreboard;
    private /* synthetic */ NBTTagCompound field_96506_b;
    private static final /* synthetic */ Logger logger;
    
    protected NBTTagList func_96505_b() {
        final NBTTagList lllllllllllllllIIllIllIlllIllIll = new NBTTagList();
        final Collection lllllllllllllllIIllIllIlllIllIlI = this.theScoreboard.getScoreObjectives();
        for (final ScoreObjective lllllllllllllllIIllIllIlllIllIII : lllllllllllllllIIllIllIlllIllIlI) {
            if (lllllllllllllllIIllIllIlllIllIII.getCriteria() != null) {
                final NBTTagCompound lllllllllllllllIIllIllIlllIlIlll = new NBTTagCompound();
                lllllllllllllllIIllIllIlllIlIlll.setString("Name", lllllllllllllllIIllIllIlllIllIII.getName());
                lllllllllllllllIIllIllIlllIlIlll.setString("CriteriaName", lllllllllllllllIIllIllIlllIllIII.getCriteria().getName());
                lllllllllllllllIIllIllIlllIlIlll.setString("DisplayName", lllllllllllllllIIllIllIlllIllIII.getDisplayName());
                lllllllllllllllIIllIllIlllIlIlll.setString("RenderType", lllllllllllllllIIllIllIlllIllIII.func_178766_e().func_178796_a());
                lllllllllllllllIIllIllIlllIllIll.appendTag(lllllllllllllllIIllIllIlllIlIlll);
            }
        }
        return lllllllllllllllIIllIllIlllIllIll;
    }
    
    protected void func_96497_d(final NBTTagCompound lllllllllllllllIIllIllIllllIllIl) {
        final NBTTagCompound lllllllllllllllIIllIllIllllIllII = new NBTTagCompound();
        boolean lllllllllllllllIIllIllIllllIlIll = false;
        for (int lllllllllllllllIIllIllIllllIlIlI = 0; lllllllllllllllIIllIllIllllIlIlI < 19; ++lllllllllllllllIIllIllIllllIlIlI) {
            final ScoreObjective lllllllllllllllIIllIllIllllIlIIl = this.theScoreboard.getObjectiveInDisplaySlot(lllllllllllllllIIllIllIllllIlIlI);
            if (lllllllllllllllIIllIllIllllIlIIl != null) {
                lllllllllllllllIIllIllIllllIllII.setString(String.valueOf(new StringBuilder("slot_").append(lllllllllllllllIIllIllIllllIlIlI)), lllllllllllllllIIllIllIllllIlIIl.getName());
                lllllllllllllllIIllIllIllllIlIll = true;
            }
        }
        if (lllllllllllllllIIllIllIllllIlIll) {
            lllllllllllllllIIllIllIllllIllIl.setTag("DisplaySlots", lllllllllllllllIIllIllIllllIllII);
        }
    }
    
    protected void func_96504_c(final NBTTagCompound lllllllllllllllIIllIlllIIlIIIIlI) {
        for (int lllllllllllllllIIllIlllIIlIIIIIl = 0; lllllllllllllllIIllIlllIIlIIIIIl < 19; ++lllllllllllllllIIllIlllIIlIIIIIl) {
            if (lllllllllllllllIIllIlllIIlIIIIlI.hasKey(String.valueOf(new StringBuilder("slot_").append(lllllllllllllllIIllIlllIIlIIIIIl)), 8)) {
                final String lllllllllllllllIIllIlllIIlIIIIII = lllllllllllllllIIllIlllIIlIIIIlI.getString(String.valueOf(new StringBuilder("slot_").append(lllllllllllllllIIllIlllIIlIIIIIl)));
                final ScoreObjective lllllllllllllllIIllIlllIIIllllll = this.theScoreboard.getObjective(lllllllllllllllIIllIlllIIlIIIIII);
                this.theScoreboard.setObjectiveInDisplaySlot(lllllllllllllllIIllIlllIIlIIIIIl, lllllllllllllllIIllIlllIIIllllll);
            }
        }
    }
    
    protected void func_96500_c(final NBTTagList lllllllllllllllIIllIlllIIIIllIlI) {
        for (int lllllllllllllllIIllIlllIIIIlllll = 0; lllllllllllllllIIllIlllIIIIlllll < lllllllllllllllIIllIlllIIIIllIlI.tagCount(); ++lllllllllllllllIIllIlllIIIIlllll) {
            final NBTTagCompound lllllllllllllllIIllIlllIIIIllllI = lllllllllllllllIIllIlllIIIIllIlI.getCompoundTagAt(lllllllllllllllIIllIlllIIIIlllll);
            final ScoreObjective lllllllllllllllIIllIlllIIIIlllIl = this.theScoreboard.getObjective(lllllllllllllllIIllIlllIIIIllllI.getString("Objective"));
            final Score lllllllllllllllIIllIlllIIIIlllII = this.theScoreboard.getValueFromObjective(lllllllllllllllIIllIlllIIIIllllI.getString("Name"), lllllllllllllllIIllIlllIIIIlllIl);
            lllllllllllllllIIllIlllIIIIlllII.setScorePoints(lllllllllllllllIIllIlllIIIIllllI.getInteger("Score"));
            if (lllllllllllllllIIllIlllIIIIllllI.hasKey("Locked")) {
                lllllllllllllllIIllIlllIIIIlllII.func_178815_a(lllllllllllllllIIllIlllIIIIllllI.getBoolean("Locked"));
            }
        }
    }
    
    @Override
    public void writeToNBT(final NBTTagCompound lllllllllllllllIIllIlllIIIIlIIlI) {
        if (this.theScoreboard == null) {
            ScoreboardSaveData.logger.warn("Tried to save scoreboard without having a scoreboard...");
        }
        else {
            lllllllllllllllIIllIlllIIIIlIIlI.setTag("Objectives", this.func_96505_b());
            lllllllllllllllIIllIlllIIIIlIIlI.setTag("PlayerScores", this.func_96503_e());
            lllllllllllllllIIllIlllIIIIlIIlI.setTag("Teams", this.func_96496_a());
            this.func_96497_d(lllllllllllllllIIllIlllIIIIlIIlI);
        }
    }
    
    protected void func_96501_b(final NBTTagList lllllllllllllllIIllIlllIIIlIllII) {
        for (int lllllllllllllllIIllIlllIIIllIIIl = 0; lllllllllllllllIIllIlllIIIllIIIl < lllllllllllllllIIllIlllIIIlIllII.tagCount(); ++lllllllllllllllIIllIlllIIIllIIIl) {
            final NBTTagCompound lllllllllllllllIIllIlllIIIllIIII = lllllllllllllllIIllIlllIIIlIllII.getCompoundTagAt(lllllllllllllllIIllIlllIIIllIIIl);
            final IScoreObjectiveCriteria lllllllllllllllIIllIlllIIIlIllll = IScoreObjectiveCriteria.INSTANCES.get(lllllllllllllllIIllIlllIIIllIIII.getString("CriteriaName"));
            if (lllllllllllllllIIllIlllIIIlIllll != null) {
                final ScoreObjective lllllllllllllllIIllIlllIIIlIlllI = this.theScoreboard.addScoreObjective(lllllllllllllllIIllIlllIIIllIIII.getString("Name"), lllllllllllllllIIllIlllIIIlIllll);
                lllllllllllllllIIllIlllIIIlIlllI.setDisplayName(lllllllllllllllIIllIlllIIIllIIII.getString("DisplayName"));
                lllllllllllllllIIllIlllIIIlIlllI.func_178767_a(IScoreObjectiveCriteria.EnumRenderType.func_178795_a(lllllllllllllllIIllIlllIIIllIIII.getString("RenderType")));
            }
        }
    }
    
    protected NBTTagList func_96503_e() {
        final NBTTagList lllllllllllllllIIllIllIlllIIlIIl = new NBTTagList();
        final Collection lllllllllllllllIIllIllIlllIIlIII = this.theScoreboard.func_96528_e();
        for (final Score lllllllllllllllIIllIllIlllIIIllI : lllllllllllllllIIllIllIlllIIlIII) {
            if (lllllllllllllllIIllIllIlllIIIllI.getObjective() != null) {
                final NBTTagCompound lllllllllllllllIIllIllIlllIIIlIl = new NBTTagCompound();
                lllllllllllllllIIllIllIlllIIIlIl.setString("Name", lllllllllllllllIIllIllIlllIIIllI.getPlayerName());
                lllllllllllllllIIllIllIlllIIIlIl.setString("Objective", lllllllllllllllIIllIllIlllIIIllI.getObjective().getName());
                lllllllllllllllIIllIllIlllIIIlIl.setInteger("Score", lllllllllllllllIIllIllIlllIIIllI.getScorePoints());
                lllllllllllllllIIllIllIlllIIIlIl.setBoolean("Locked", lllllllllllllllIIllIllIlllIIIllI.func_178816_g());
                lllllllllllllllIIllIllIlllIIlIIl.appendTag(lllllllllllllllIIllIllIlllIIIlIl);
            }
        }
        return lllllllllllllllIIllIllIlllIIlIIl;
    }
    
    public ScoreboardSaveData(final String lllllllllllllllIIllIlllIIlllIllI) {
        super(lllllllllllllllIIllIlllIIlllIllI);
    }
    
    public void func_96499_a(final Scoreboard lllllllllllllllIIllIlllIIlllIIII) {
        this.theScoreboard = lllllllllllllllIIllIlllIIlllIIII;
        if (this.field_96506_b != null) {
            this.readFromNBT(this.field_96506_b);
        }
    }
    
    public ScoreboardSaveData() {
        this("scoreboard");
    }
    
    protected NBTTagList func_96496_a() {
        final NBTTagList lllllllllllllllIIllIlllIIIIIIlIl = new NBTTagList();
        final Collection lllllllllllllllIIllIlllIIIIIIlII = this.theScoreboard.getTeams();
        for (final ScorePlayerTeam lllllllllllllllIIllIlllIIIIIIIlI : lllllllllllllllIIllIlllIIIIIIlII) {
            final NBTTagCompound lllllllllllllllIIllIlllIIIIIIIIl = new NBTTagCompound();
            lllllllllllllllIIllIlllIIIIIIIIl.setString("Name", lllllllllllllllIIllIlllIIIIIIIlI.getRegisteredName());
            lllllllllllllllIIllIlllIIIIIIIIl.setString("DisplayName", lllllllllllllllIIllIlllIIIIIIIlI.func_96669_c());
            if (lllllllllllllllIIllIlllIIIIIIIlI.func_178775_l().func_175746_b() >= 0) {
                lllllllllllllllIIllIlllIIIIIIIIl.setString("TeamColor", lllllllllllllllIIllIlllIIIIIIIlI.func_178775_l().getFriendlyName());
            }
            lllllllllllllllIIllIlllIIIIIIIIl.setString("Prefix", lllllllllllllllIIllIlllIIIIIIIlI.getColorPrefix());
            lllllllllllllllIIllIlllIIIIIIIIl.setString("Suffix", lllllllllllllllIIllIlllIIIIIIIlI.getColorSuffix());
            lllllllllllllllIIllIlllIIIIIIIIl.setBoolean("AllowFriendlyFire", lllllllllllllllIIllIlllIIIIIIIlI.getAllowFriendlyFire());
            lllllllllllllllIIllIlllIIIIIIIIl.setBoolean("SeeFriendlyInvisibles", lllllllllllllllIIllIlllIIIIIIIlI.func_98297_h());
            lllllllllllllllIIllIlllIIIIIIIIl.setString("NameTagVisibility", lllllllllllllllIIllIlllIIIIIIIlI.func_178770_i().field_178830_e);
            lllllllllllllllIIllIlllIIIIIIIIl.setString("DeathMessageVisibility", lllllllllllllllIIllIlllIIIIIIIlI.func_178771_j().field_178830_e);
            final NBTTagList lllllllllllllllIIllIlllIIIIIIIII = new NBTTagList();
            for (final String lllllllllllllllIIllIllIllllllllI : lllllllllllllllIIllIlllIIIIIIIlI.getMembershipCollection()) {
                lllllllllllllllIIllIlllIIIIIIIII.appendTag(new NBTTagString(lllllllllllllllIIllIllIllllllllI));
            }
            lllllllllllllllIIllIlllIIIIIIIIl.setTag("Players", lllllllllllllllIIllIlllIIIIIIIII);
            lllllllllllllllIIllIlllIIIIIIlIl.appendTag(lllllllllllllllIIllIlllIIIIIIIIl);
        }
        return lllllllllllllllIIllIlllIIIIIIlIl;
    }
    
    protected void func_96498_a(final NBTTagList lllllllllllllllIIllIlllIIlIllIIl) {
        for (int lllllllllllllllIIllIlllIIlIlllll = 0; lllllllllllllllIIllIlllIIlIlllll < lllllllllllllllIIllIlllIIlIllIIl.tagCount(); ++lllllllllllllllIIllIlllIIlIlllll) {
            final NBTTagCompound lllllllllllllllIIllIlllIIlIllllI = lllllllllllllllIIllIlllIIlIllIIl.getCompoundTagAt(lllllllllllllllIIllIlllIIlIlllll);
            final ScorePlayerTeam lllllllllllllllIIllIlllIIlIlllIl = this.theScoreboard.createTeam(lllllllllllllllIIllIlllIIlIllllI.getString("Name"));
            lllllllllllllllIIllIlllIIlIlllIl.setTeamName(lllllllllllllllIIllIlllIIlIllllI.getString("DisplayName"));
            if (lllllllllllllllIIllIlllIIlIllllI.hasKey("TeamColor", 8)) {
                lllllllllllllllIIllIlllIIlIlllIl.func_178774_a(EnumChatFormatting.getValueByName(lllllllllllllllIIllIlllIIlIllllI.getString("TeamColor")));
            }
            lllllllllllllllIIllIlllIIlIlllIl.setNamePrefix(lllllllllllllllIIllIlllIIlIllllI.getString("Prefix"));
            lllllllllllllllIIllIlllIIlIlllIl.setNameSuffix(lllllllllllllllIIllIlllIIlIllllI.getString("Suffix"));
            if (lllllllllllllllIIllIlllIIlIllllI.hasKey("AllowFriendlyFire", 99)) {
                lllllllllllllllIIllIlllIIlIlllIl.setAllowFriendlyFire(lllllllllllllllIIllIlllIIlIllllI.getBoolean("AllowFriendlyFire"));
            }
            if (lllllllllllllllIIllIlllIIlIllllI.hasKey("SeeFriendlyInvisibles", 99)) {
                lllllllllllllllIIllIlllIIlIlllIl.setSeeFriendlyInvisiblesEnabled(lllllllllllllllIIllIlllIIlIllllI.getBoolean("SeeFriendlyInvisibles"));
            }
            if (lllllllllllllllIIllIlllIIlIllllI.hasKey("NameTagVisibility", 8)) {
                final Team.EnumVisible lllllllllllllllIIllIlllIIlIlllII = Team.EnumVisible.func_178824_a(lllllllllllllllIIllIlllIIlIllllI.getString("NameTagVisibility"));
                if (lllllllllllllllIIllIlllIIlIlllII != null) {
                    lllllllllllllllIIllIlllIIlIlllIl.func_178772_a(lllllllllllllllIIllIlllIIlIlllII);
                }
            }
            if (lllllllllllllllIIllIlllIIlIllllI.hasKey("DeathMessageVisibility", 8)) {
                final Team.EnumVisible lllllllllllllllIIllIlllIIlIllIll = Team.EnumVisible.func_178824_a(lllllllllllllllIIllIlllIIlIllllI.getString("DeathMessageVisibility"));
                if (lllllllllllllllIIllIlllIIlIllIll != null) {
                    lllllllllllllllIIllIlllIIlIlllIl.func_178773_b(lllllllllllllllIIllIlllIIlIllIll);
                }
            }
            this.func_96502_a(lllllllllllllllIIllIlllIIlIlllIl, lllllllllllllllIIllIlllIIlIllllI.getTagList("Players", 8));
        }
    }
    
    protected void func_96502_a(final ScorePlayerTeam lllllllllllllllIIllIlllIIlIIlIll, final NBTTagList lllllllllllllllIIllIlllIIlIIlIlI) {
        for (int lllllllllllllllIIllIlllIIlIIllIl = 0; lllllllllllllllIIllIlllIIlIIllIl < lllllllllllllllIIllIlllIIlIIlIlI.tagCount(); ++lllllllllllllllIIllIlllIIlIIllIl) {
            this.theScoreboard.func_151392_a(lllllllllllllllIIllIlllIIlIIlIlI.getStringTagAt(lllllllllllllllIIllIlllIIlIIllIl), lllllllllllllllIIllIlllIIlIIlIll.getRegisteredName());
        }
    }
    
    static {
        __OBFID = "CL_00000620";
        logger = LogManager.getLogger();
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound lllllllllllllllIIllIlllIIllIlIlI) {
        if (this.theScoreboard == null) {
            this.field_96506_b = lllllllllllllllIIllIlllIIllIlIlI;
        }
        else {
            this.func_96501_b(lllllllllllllllIIllIlllIIllIlIlI.getTagList("Objectives", 10));
            this.func_96500_c(lllllllllllllllIIllIlllIIllIlIlI.getTagList("PlayerScores", 10));
            if (lllllllllllllllIIllIlllIIllIlIlI.hasKey("DisplaySlots", 10)) {
                this.func_96504_c(lllllllllllllllIIllIlllIIllIlIlI.getCompoundTag("DisplaySlots"));
            }
            if (lllllllllllllllIIllIlllIIllIlIlI.hasKey("Teams", 9)) {
                this.func_96498_a(lllllllllllllllIIllIlllIIllIlIlI.getTagList("Teams", 10));
            }
        }
    }
}
