package net.minecraft.scoreboard;

import java.util.*;

public class Score
{
    private /* synthetic */ boolean field_178817_f;
    private /* synthetic */ int scorePoints;
    private final /* synthetic */ ScoreObjective theScoreObjective;
    private /* synthetic */ boolean field_178818_g;
    private final /* synthetic */ Scoreboard theScoreboard;
    private final /* synthetic */ String scorePlayerName;
    
    static {
        __OBFID = "CL_00000617";
        scoreComparator = new Comparator() {
            @Override
            public int compare(final Object lllllllllllllllllllIIlIIIIlIlIII, final Object lllllllllllllllllllIIlIIIIlIIlll) {
                return this.compare((Score)lllllllllllllllllllIIlIIIIlIlIII, (Score)lllllllllllllllllllIIlIIIIlIIlll);
            }
            
            public int compare(final Score lllllllllllllllllllIIlIIIIllIIIl, final Score lllllllllllllllllllIIlIIIIllIIII) {
                return (lllllllllllllllllllIIlIIIIllIIIl.getScorePoints() > lllllllllllllllllllIIlIIIIllIIII.getScorePoints()) ? 1 : ((lllllllllllllllllllIIlIIIIllIIIl.getScorePoints() < lllllllllllllllllllIIlIIIIllIIII.getScorePoints()) ? -1 : lllllllllllllllllllIIlIIIIllIIII.getPlayerName().compareToIgnoreCase(lllllllllllllllllllIIlIIIIllIIIl.getPlayerName()));
            }
            
            static {
                __OBFID = "CL_00000618";
            }
        };
    }
    
    public boolean func_178816_g() {
        return this.field_178817_f;
    }
    
    public void decreaseScore(final int llllllllllllllIlIIlIIlIllIIlllIl) {
        if (this.theScoreObjective.getCriteria().isReadOnly()) {
            throw new IllegalStateException("Cannot modify read-only score");
        }
        this.setScorePoints(this.getScorePoints() - llllllllllllllIlIIlIIlIllIIlllIl);
    }
    
    public void setScorePoints(final int llllllllllllllIlIIlIIlIllIIlIIII) {
        final int llllllllllllllIlIIlIIlIllIIIllll = this.scorePoints;
        this.scorePoints = llllllllllllllIlIIlIIlIllIIlIIII;
        if (llllllllllllllIlIIlIIlIllIIIllll != llllllllllllllIlIIlIIlIllIIlIIII || this.field_178818_g) {
            this.field_178818_g = false;
            this.getScoreScoreboard().func_96536_a(this);
        }
    }
    
    public void func_178815_a(final boolean llllllllllllllIlIIlIIlIlIllllIlI) {
        this.field_178817_f = llllllllllllllIlIIlIIlIlIllllIlI;
    }
    
    public void func_96648_a() {
        if (this.theScoreObjective.getCriteria().isReadOnly()) {
            throw new IllegalStateException("Cannot modify read-only score");
        }
        this.increseScore(1);
    }
    
    public int getScorePoints() {
        return this.scorePoints;
    }
    
    public String getPlayerName() {
        return this.scorePlayerName;
    }
    
    public void func_96651_a(final List llllllllllllllIlIIlIIlIlIlllIlII) {
        this.setScorePoints(this.theScoreObjective.getCriteria().func_96635_a(llllllllllllllIlIIlIIlIlIlllIlII));
    }
    
    public Scoreboard getScoreScoreboard() {
        return this.theScoreboard;
    }
    
    public ScoreObjective getObjective() {
        return this.theScoreObjective;
    }
    
    public void increseScore(final int llllllllllllllIlIIlIIlIllIlIIIll) {
        if (this.theScoreObjective.getCriteria().isReadOnly()) {
            throw new IllegalStateException("Cannot modify read-only score");
        }
        this.setScorePoints(this.getScorePoints() + llllllllllllllIlIIlIIlIllIlIIIll);
    }
    
    public Score(final Scoreboard llllllllllllllIlIIlIIlIllIlIlIIl, final ScoreObjective llllllllllllllIlIIlIIlIllIlIlIII, final String llllllllllllllIlIIlIIlIllIlIlIll) {
        this.theScoreboard = llllllllllllllIlIIlIIlIllIlIlIIl;
        this.theScoreObjective = llllllllllllllIlIIlIIlIllIlIlIII;
        this.scorePlayerName = llllllllllllllIlIIlIIlIllIlIlIll;
        this.field_178818_g = true;
    }
}
