package net.minecraft.scoreboard;

import com.google.common.collect.*;
import net.minecraft.util.*;
import java.util.*;

public class Scoreboard
{
    private static /* synthetic */ String[] field_178823_g;
    private final /* synthetic */ Map teams;
    private final /* synthetic */ Map teamMemberships;
    private final /* synthetic */ Map scoreObjectives;
    private final /* synthetic */ ScoreObjective[] objectiveDisplaySlots;
    private final /* synthetic */ Map field_96544_c;
    private final /* synthetic */ Map scoreObjectiveCriterias;
    
    public Collection func_96520_a(final IScoreObjectiveCriteria lllllllllllllllllIIIIIllIIlIIlIl) {
        final Collection lllllllllllllllllIIIIIllIIlIIlII = this.scoreObjectiveCriterias.get(lllllllllllllllllIIIIIllIIlIIlIl);
        return (lllllllllllllllllIIIIIllIIlIIlII == null) ? Lists.newArrayList() : Lists.newArrayList((Iterable)lllllllllllllllllIIIIIllIIlIIlII);
    }
    
    public void removePlayerFromTeam(final String lllllllllllllllllIIIIIlIIllIllII, final ScorePlayerTeam lllllllllllllllllIIIIIlIIllIlIll) {
        if (this.getPlayersTeam(lllllllllllllllllIIIIIlIIllIllII) != lllllllllllllllllIIIIIlIIllIlIll) {
            throw new IllegalStateException(String.valueOf(new StringBuilder("Player is either on another team or not on any team. Cannot remove from team '").append(lllllllllllllllllIIIIIlIIllIlIll.getRegisteredName()).append("'.")));
        }
        this.teamMemberships.remove(lllllllllllllllllIIIIIlIIllIllII);
        lllllllllllllllllIIIIIlIIllIlIll.getMembershipCollection().remove(lllllllllllllllllIIIIIlIIllIllII);
    }
    
    public Map func_96510_d(final String lllllllllllllllllIIIIIlIllIIIlII) {
        Object lllllllllllllllllIIIIIlIllIIIIll = this.field_96544_c.get(lllllllllllllllllIIIIIlIllIIIlII);
        if (lllllllllllllllllIIIIIlIllIIIIll == null) {
            lllllllllllllllllIIIIIlIllIIIIll = Maps.newHashMap();
        }
        return (Map)lllllllllllllllllIIIIIlIllIIIIll;
    }
    
    public void setObjectiveInDisplaySlot(final int lllllllllllllllllIIIIIlIlIlIlIII, final ScoreObjective lllllllllllllllllIIIIIlIlIlIlIlI) {
        this.objectiveDisplaySlots[lllllllllllllllllIIIIIlIlIlIlIII] = lllllllllllllllllIIIIIlIlIlIlIlI;
    }
    
    public ScorePlayerTeam createTeam(final String lllllllllllllllllIIIIIlIlIIlIIll) {
        ScorePlayerTeam lllllllllllllllllIIIIIlIlIIlIlIl = this.getTeam(lllllllllllllllllIIIIIlIlIIlIIll);
        if (lllllllllllllllllIIIIIlIlIIlIlIl != null) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("A team with the name '").append(lllllllllllllllllIIIIIlIlIIlIIll).append("' already exists!")));
        }
        lllllllllllllllllIIIIIlIlIIlIlIl = new ScorePlayerTeam(this, lllllllllllllllllIIIIIlIlIIlIIll);
        this.teams.put(lllllllllllllllllIIIIIlIlIIlIIll, lllllllllllllllllIIIIIlIlIIlIlIl);
        this.broadcastTeamCreated(lllllllllllllllllIIIIIlIlIIlIlIl);
        return lllllllllllllllllIIIIIlIlIIlIlIl;
    }
    
    public ScoreObjective addScoreObjective(final String lllllllllllllllllIIIIIllIIllIIlI, final IScoreObjectiveCriteria lllllllllllllllllIIIIIllIIllIIIl) {
        ScoreObjective lllllllllllllllllIIIIIllIIllIIII = this.getObjective(lllllllllllllllllIIIIIllIIllIIlI);
        if (lllllllllllllllllIIIIIllIIllIIII != null) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("An objective with the name '").append(lllllllllllllllllIIIIIllIIllIIlI).append("' already exists!")));
        }
        lllllllllllllllllIIIIIllIIllIIII = new ScoreObjective(this, lllllllllllllllllIIIIIllIIllIIlI, lllllllllllllllllIIIIIllIIllIIIl);
        Object lllllllllllllllllIIIIIllIIlIllll = this.scoreObjectiveCriterias.get(lllllllllllllllllIIIIIllIIllIIIl);
        if (lllllllllllllllllIIIIIllIIlIllll == null) {
            lllllllllllllllllIIIIIllIIlIllll = Lists.newArrayList();
            this.scoreObjectiveCriterias.put(lllllllllllllllllIIIIIllIIllIIIl, lllllllllllllllllIIIIIllIIlIllll);
        }
        ((List)lllllllllllllllllIIIIIllIIlIllll).add(lllllllllllllllllIIIIIllIIllIIII);
        this.scoreObjectives.put(lllllllllllllllllIIIIIllIIllIIlI, lllllllllllllllllIIIIIllIIllIIII);
        this.func_96522_a(lllllllllllllllllIIIIIllIIllIIII);
        return lllllllllllllllllIIIIIllIIllIIII;
    }
    
    public static String getObjectiveDisplaySlot(final int lllllllllllllllllIIIIIlIIlIIIlII) {
        switch (lllllllllllllllllIIIIIlIIlIIIlII) {
            case 0: {
                return "list";
            }
            case 1: {
                return "sidebar";
            }
            case 2: {
                return "belowName";
            }
            default: {
                if (lllllllllllllllllIIIIIlIIlIIIlII >= 3 && lllllllllllllllllIIIIIlIIlIIIlII <= 18) {
                    final EnumChatFormatting lllllllllllllllllIIIIIlIIlIIIlIl = EnumChatFormatting.func_175744_a(lllllllllllllllllIIIIIlIIlIIIlII - 3);
                    if (lllllllllllllllllIIIIIlIIlIIIlIl != null && lllllllllllllllllIIIIIlIIlIIIlIl != EnumChatFormatting.RESET) {
                        return String.valueOf(new StringBuilder("sidebar.team.").append(lllllllllllllllllIIIIIlIIlIIIlIl.getFriendlyName()));
                    }
                }
                return null;
            }
        }
    }
    
    public boolean func_151392_a(final String lllllllllllllllllIIIIIlIlIIIIIII, final String lllllllllllllllllIIIIIlIIlllllll) {
        if (!this.teams.containsKey(lllllllllllllllllIIIIIlIIlllllll)) {
            return false;
        }
        final ScorePlayerTeam lllllllllllllllllIIIIIlIIllllllI = this.getTeam(lllllllllllllllllIIIIIlIIlllllll);
        if (this.getPlayersTeam(lllllllllllllllllIIIIIlIlIIIIIII) != null) {
            this.removePlayerFromTeams(lllllllllllllllllIIIIIlIlIIIIIII);
        }
        this.teamMemberships.put(lllllllllllllllllIIIIIlIlIIIIIII, lllllllllllllllllIIIIIlIIllllllI);
        lllllllllllllllllIIIIIlIIllllllI.getMembershipCollection().add(lllllllllllllllllIIIIIlIlIIIIIII);
        return true;
    }
    
    public ScorePlayerTeam getTeam(final String lllllllllllllllllIIIIIlIlIIllIll) {
        return this.teams.get(lllllllllllllllllIIIIIlIlIIllIll);
    }
    
    public void broadcastTeamCreated(final ScorePlayerTeam lllllllllllllllllIIIIIlIIlIIllIl) {
    }
    
    public ScorePlayerTeam getPlayersTeam(final String lllllllllllllllllIIIIIlIIlIlllII) {
        return this.teamMemberships.get(lllllllllllllllllIIIIIlIIlIlllII);
    }
    
    public void removeTeam(final ScorePlayerTeam lllllllllllllllllIIIIIlIlIIIllII) {
        this.teams.remove(lllllllllllllllllIIIIIlIlIIIllII.getRegisteredName());
        for (final String lllllllllllllllllIIIIIlIlIIIlIlI : lllllllllllllllllIIIIIlIlIIIllII.getMembershipCollection()) {
            this.teamMemberships.remove(lllllllllllllllllIIIIIlIlIIIlIlI);
        }
        this.func_96513_c(lllllllllllllllllIIIIIlIlIIIllII);
    }
    
    static {
        __OBFID = "CL_00000619";
        Scoreboard.field_178823_g = null;
    }
    
    public boolean func_178819_b(final String lllllllllllllllllIIIIIllIIIlIlIl, final ScoreObjective lllllllllllllllllIIIIIllIIIllIIl) {
        final Map lllllllllllllllllIIIIIllIIIllIII = this.field_96544_c.get(lllllllllllllllllIIIIIllIIIlIlIl);
        if (lllllllllllllllllIIIIIllIIIllIII == null) {
            return false;
        }
        final Score lllllllllllllllllIIIIIllIIIlIlll = lllllllllllllllllIIIIIllIIIllIII.get(lllllllllllllllllIIIIIllIIIllIIl);
        return lllllllllllllllllIIIIIllIIIlIlll != null;
    }
    
    public Collection func_96528_e() {
        final Collection lllllllllllllllllIIIIIlIllIlIIIl = this.field_96544_c.values();
        final ArrayList lllllllllllllllllIIIIIlIllIlIIII = Lists.newArrayList();
        for (final Map lllllllllllllllllIIIIIlIllIIlllI : lllllllllllllllllIIIIIlIllIlIIIl) {
            lllllllllllllllllIIIIIlIllIlIIII.addAll(lllllllllllllllllIIIIIlIllIIlllI.values());
        }
        return lllllllllllllllllIIIIIlIllIlIIII;
    }
    
    public void func_96522_a(final ScoreObjective lllllllllllllllllIIIIIlIIlIllIlI) {
    }
    
    public boolean removePlayerFromTeams(final String lllllllllllllllllIIIIIlIIlllIlIl) {
        final ScorePlayerTeam lllllllllllllllllIIIIIlIIlllIlII = this.getPlayersTeam(lllllllllllllllllIIIIIlIIlllIlIl);
        if (lllllllllllllllllIIIIIlIIlllIlII != null) {
            this.removePlayerFromTeam(lllllllllllllllllIIIIIlIIlllIlIl, lllllllllllllllllIIIIIlIIlllIlII);
            return true;
        }
        return false;
    }
    
    public static String[] func_178821_h() {
        if (Scoreboard.field_178823_g == null) {
            Scoreboard.field_178823_g = new String[19];
            for (int lllllllllllllllllIIIIIlIIIlllIII = 0; lllllllllllllllllIIIIIlIIIlllIII < 19; ++lllllllllllllllllIIIIIlIIIlllIII) {
                Scoreboard.field_178823_g[lllllllllllllllllIIIIIlIIIlllIII] = getObjectiveDisplaySlot(lllllllllllllllllIIIIIlIIIlllIII);
            }
        }
        return Scoreboard.field_178823_g;
    }
    
    public void func_96516_a(final String lllllllllllllllllIIIIIlIIlIlIIlI) {
    }
    
    public void func_178820_a(final String lllllllllllllllllIIIIIlIIlIlIIII, final ScoreObjective lllllllllllllllllIIIIIlIIlIIllll) {
    }
    
    public Collection getScoreObjectives() {
        return this.scoreObjectives.values();
    }
    
    public Scoreboard() {
        this.scoreObjectives = Maps.newHashMap();
        this.scoreObjectiveCriterias = Maps.newHashMap();
        this.field_96544_c = Maps.newHashMap();
        this.objectiveDisplaySlots = new ScoreObjective[19];
        this.teams = Maps.newHashMap();
        this.teamMemberships = Maps.newHashMap();
    }
    
    public ScoreObjective getObjective(final String lllllllllllllllllIIIIIllIIlllIll) {
        return this.scoreObjectives.get(lllllllllllllllllIIIIIllIIlllIll);
    }
    
    public Collection getTeamNames() {
        return this.teams.keySet();
    }
    
    public Score getValueFromObjective(final String lllllllllllllllllIIIIIllIIIIIllI, final ScoreObjective lllllllllllllllllIIIIIllIIIIlIlI) {
        Object lllllllllllllllllIIIIIllIIIIlIIl = this.field_96544_c.get(lllllllllllllllllIIIIIllIIIIIllI);
        if (lllllllllllllllllIIIIIllIIIIlIIl == null) {
            lllllllllllllllllIIIIIllIIIIlIIl = Maps.newHashMap();
            this.field_96544_c.put(lllllllllllllllllIIIIIllIIIIIllI, lllllllllllllllllIIIIIllIIIIlIIl);
        }
        Score lllllllllllllllllIIIIIllIIIIlIII = ((Map)lllllllllllllllllIIIIIllIIIIlIIl).get(lllllllllllllllllIIIIIllIIIIlIlI);
        if (lllllllllllllllllIIIIIllIIIIlIII == null) {
            lllllllllllllllllIIIIIllIIIIlIII = new Score(this, lllllllllllllllllIIIIIllIIIIlIlI, lllllllllllllllllIIIIIllIIIIIllI);
            ((Map)lllllllllllllllllIIIIIllIIIIlIIl).put(lllllllllllllllllIIIIIllIIIIlIlI, lllllllllllllllllIIIIIllIIIIlIII);
        }
        return lllllllllllllllllIIIIIllIIIIlIII;
    }
    
    public void func_96519_k(final ScoreObjective lllllllllllllllllIIIIIlIlIllIIll) {
        this.scoreObjectives.remove(lllllllllllllllllIIIIIlIlIllIIll.getName());
        for (int lllllllllllllllllIIIIIlIlIlllIII = 0; lllllllllllllllllIIIIIlIlIlllIII < 19; ++lllllllllllllllllIIIIIlIlIlllIII) {
            if (this.getObjectiveInDisplaySlot(lllllllllllllllllIIIIIlIlIlllIII) == lllllllllllllllllIIIIIlIlIllIIll) {
                this.setObjectiveInDisplaySlot(lllllllllllllllllIIIIIlIlIlllIII, null);
            }
        }
        final List lllllllllllllllllIIIIIlIlIllIlll = this.scoreObjectiveCriterias.get(lllllllllllllllllIIIIIlIlIllIIll.getCriteria());
        if (lllllllllllllllllIIIIIlIlIllIlll != null) {
            lllllllllllllllllIIIIIlIlIllIlll.remove(lllllllllllllllllIIIIIlIlIllIIll);
        }
        for (final Map lllllllllllllllllIIIIIlIlIllIlIl : this.field_96544_c.values()) {
            lllllllllllllllllIIIIIlIlIllIlIl.remove(lllllllllllllllllIIIIIlIlIllIIll);
        }
        this.func_96533_c(lllllllllllllllllIIIIIlIlIllIIll);
    }
    
    public ScoreObjective getObjectiveInDisplaySlot(final int lllllllllllllllllIIIIIlIlIlIIIIl) {
        return this.objectiveDisplaySlots[lllllllllllllllllIIIIIlIlIlIIIIl];
    }
    
    public void func_96536_a(final Score lllllllllllllllllIIIIIlIIlIlIlII) {
    }
    
    public Collection getSortedScores(final ScoreObjective lllllllllllllllllIIIIIlIlllllIll) {
        final ArrayList lllllllllllllllllIIIIIlIlllllIlI = Lists.newArrayList();
        for (final Map lllllllllllllllllIIIIIlIlllllIII : this.field_96544_c.values()) {
            final Score lllllllllllllllllIIIIIlIllllIlll = lllllllllllllllllIIIIIlIlllllIII.get(lllllllllllllllllIIIIIlIlllllIll);
            if (lllllllllllllllllIIIIIlIllllIlll != null) {
                lllllllllllllllllIIIIIlIlllllIlI.add(lllllllllllllllllIIIIIlIllllIlll);
            }
        }
        Collections.sort((List<Object>)lllllllllllllllllIIIIIlIlllllIlI, Score.scoreComparator);
        return lllllllllllllllllIIIIIlIlllllIlI;
    }
    
    public void func_96533_c(final ScoreObjective lllllllllllllllllIIIIIlIIlIlIllI) {
    }
    
    public Collection getTeams() {
        return this.teams.values();
    }
    
    public static int getObjectiveDisplaySlotNumber(final String lllllllllllllllllIIIIIlIIIllllII) {
        if (lllllllllllllllllIIIIIlIIIllllII.equalsIgnoreCase("list")) {
            return 0;
        }
        if (lllllllllllllllllIIIIIlIIIllllII.equalsIgnoreCase("sidebar")) {
            return 1;
        }
        if (lllllllllllllllllIIIIIlIIIllllII.equalsIgnoreCase("belowName")) {
            return 2;
        }
        if (lllllllllllllllllIIIIIlIIIllllII.startsWith("sidebar.team.")) {
            final String lllllllllllllllllIIIIIlIIIlllllI = lllllllllllllllllIIIIIlIIIllllII.substring("sidebar.team.".length());
            final EnumChatFormatting lllllllllllllllllIIIIIlIIIllllIl = EnumChatFormatting.getValueByName(lllllllllllllllllIIIIIlIIIlllllI);
            if (lllllllllllllllllIIIIIlIIIllllIl != null && lllllllllllllllllIIIIIlIIIllllIl.func_175746_b() >= 0) {
                return lllllllllllllllllIIIIIlIIIllllIl.func_175746_b() + 3;
            }
        }
        return -1;
    }
    
    public void broadcastTeamRemoved(final ScorePlayerTeam lllllllllllllllllIIIIIlIIlIIlIll) {
    }
    
    public void func_96513_c(final ScorePlayerTeam lllllllllllllllllIIIIIlIIlIIlIIl) {
    }
    
    public void func_96532_b(final ScoreObjective lllllllllllllllllIIIIIlIIlIllIII) {
    }
    
    public Collection getObjectiveNames() {
        return this.field_96544_c.keySet();
    }
    
    public void func_178822_d(final String lllllllllllllllllIIIIIlIllIlllII, final ScoreObjective lllllllllllllllllIIIIIlIlllIIIlI) {
        if (lllllllllllllllllIIIIIlIlllIIIlI == null) {
            final Map lllllllllllllllllIIIIIlIlllIIIIl = this.field_96544_c.remove(lllllllllllllllllIIIIIlIllIlllII);
            if (lllllllllllllllllIIIIIlIlllIIIIl != null) {
                this.func_96516_a(lllllllllllllllllIIIIIlIllIlllII);
            }
        }
        else {
            final Map lllllllllllllllllIIIIIlIlllIIIII = this.field_96544_c.get(lllllllllllllllllIIIIIlIllIlllII);
            if (lllllllllllllllllIIIIIlIlllIIIII != null) {
                final Score lllllllllllllllllIIIIIlIllIlllll = lllllllllllllllllIIIIIlIlllIIIII.remove(lllllllllllllllllIIIIIlIlllIIIlI);
                if (lllllllllllllllllIIIIIlIlllIIIII.size() < 1) {
                    final Map lllllllllllllllllIIIIIlIllIllllI = this.field_96544_c.remove(lllllllllllllllllIIIIIlIllIlllII);
                    if (lllllllllllllllllIIIIIlIllIllllI != null) {
                        this.func_96516_a(lllllllllllllllllIIIIIlIllIlllII);
                    }
                }
                else if (lllllllllllllllllIIIIIlIllIlllll != null) {
                    this.func_178820_a(lllllllllllllllllIIIIIlIllIlllII, lllllllllllllllllIIIIIlIlllIIIlI);
                }
            }
        }
    }
}
