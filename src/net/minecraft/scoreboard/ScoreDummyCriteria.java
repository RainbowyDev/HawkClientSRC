package net.minecraft.scoreboard;

import java.util.*;

public class ScoreDummyCriteria implements IScoreObjectiveCriteria
{
    private final /* synthetic */ String field_96644_g;
    
    @Override
    public boolean isReadOnly() {
        return false;
    }
    
    public ScoreDummyCriteria(final String llllllllllllllllllllIlIIlIlllllI) {
        this.field_96644_g = llllllllllllllllllllIlIIlIlllllI;
        IScoreObjectiveCriteria.INSTANCES.put(llllllllllllllllllllIlIIlIlllllI, this);
    }
    
    @Override
    public EnumRenderType func_178790_c() {
        return EnumRenderType.INTEGER;
    }
    
    @Override
    public String getName() {
        return this.field_96644_g;
    }
    
    static {
        __OBFID = "CL_00000622";
    }
    
    @Override
    public int func_96635_a(final List llllllllllllllllllllIlIIlIllIlll) {
        return 0;
    }
}
