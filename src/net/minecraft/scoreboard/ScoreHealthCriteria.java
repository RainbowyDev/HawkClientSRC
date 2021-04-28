package net.minecraft.scoreboard;

import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import java.util.*;

public class ScoreHealthCriteria extends ScoreDummyCriteria
{
    @Override
    public boolean isReadOnly() {
        return true;
    }
    
    @Override
    public IScoreObjectiveCriteria.EnumRenderType func_178790_c() {
        return IScoreObjectiveCriteria.EnumRenderType.HEARTS;
    }
    
    public ScoreHealthCriteria(final String lllllllllllllllIlIlIlIIIlIIlIIIl) {
        super(lllllllllllllllIlIlIlIIIlIIlIIIl);
    }
    
    @Override
    public int func_96635_a(final List lllllllllllllllIlIlIlIIIlIIIlIll) {
        float lllllllllllllllIlIlIlIIIlIIIlIlI = 0.0f;
        for (final EntityPlayer lllllllllllllllIlIlIlIIIlIIIlIIl : lllllllllllllllIlIlIlIIIlIIIlIll) {
            lllllllllllllllIlIlIlIIIlIIIlIlI += lllllllllllllllIlIlIlIIIlIIIlIIl.getHealth() + lllllllllllllllIlIlIlIIIlIIIlIIl.getAbsorptionAmount();
        }
        if (lllllllllllllllIlIlIlIIIlIIIlIll.size() > 0) {
            lllllllllllllllIlIlIlIIIlIIIlIlI /= lllllllllllllllIlIlIlIIIlIIIlIll.size();
        }
        return MathHelper.ceiling_float_int(lllllllllllllllIlIlIlIIIlIIIlIlI);
    }
    
    static {
        __OBFID = "CL_00000623";
    }
}
