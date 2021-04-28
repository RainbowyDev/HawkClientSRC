package net.minecraft.scoreboard;

public class ScoreObjective
{
    private final /* synthetic */ IScoreObjectiveCriteria objectiveCriteria;
    private /* synthetic */ IScoreObjectiveCriteria.EnumRenderType field_178768_d;
    private final /* synthetic */ Scoreboard theScoreboard;
    private /* synthetic */ String displayName;
    private final /* synthetic */ String name;
    
    public Scoreboard getScoreboard() {
        return this.theScoreboard;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void func_178767_a(final IScoreObjectiveCriteria.EnumRenderType llllllllllllllIlllllIIlIlIllllIl) {
        this.field_178768_d = llllllllllllllIlllllIIlIlIllllIl;
        this.theScoreboard.func_96532_b(this);
    }
    
    static {
        __OBFID = "CL_00000614";
    }
    
    public IScoreObjectiveCriteria.EnumRenderType func_178766_e() {
        return this.field_178768_d;
    }
    
    public IScoreObjectiveCriteria getCriteria() {
        return this.objectiveCriteria;
    }
    
    public ScoreObjective(final Scoreboard llllllllllllllIlllllIIlIllIllllI, final String llllllllllllllIlllllIIlIllIlllIl, final IScoreObjectiveCriteria llllllllllllllIlllllIIlIllIlllII) {
        this.theScoreboard = llllllllllllllIlllllIIlIllIllllI;
        this.name = llllllllllllllIlllllIIlIllIlllIl;
        this.objectiveCriteria = llllllllllllllIlllllIIlIllIlllII;
        this.displayName = llllllllllllllIlllllIIlIllIlllIl;
        this.field_178768_d = llllllllllllllIlllllIIlIllIlllII.func_178790_c();
    }
    
    public void setDisplayName(final String llllllllllllllIlllllIIlIllIIlIII) {
        this.displayName = llllllllllllllIlllllIIlIllIIlIII;
        this.theScoreboard.func_96532_b(this);
    }
    
    public String getDisplayName() {
        return this.displayName;
    }
}
