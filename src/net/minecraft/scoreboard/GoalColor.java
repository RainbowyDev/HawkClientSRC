package net.minecraft.scoreboard;

import java.util.*;
import net.minecraft.util.*;

public class GoalColor implements IScoreObjectiveCriteria
{
    private final /* synthetic */ String field_178794_j;
    
    @Override
    public EnumRenderType func_178790_c() {
        return EnumRenderType.INTEGER;
    }
    
    @Override
    public boolean isReadOnly() {
        return false;
    }
    
    @Override
    public String getName() {
        return this.field_178794_j;
    }
    
    @Override
    public int func_96635_a(final List llllllllllllllIlIIllIlIllIlIllIl) {
        return 0;
    }
    
    public GoalColor(final String llllllllllllllIlIIllIlIllIllIllI, final EnumChatFormatting llllllllllllllIlIIllIlIllIllIIlI) {
        this.field_178794_j = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlIIllIlIllIllIllI)).append(llllllllllllllIlIIllIlIllIllIIlI.getFriendlyName()));
        IScoreObjectiveCriteria.INSTANCES.put(this.field_178794_j, this);
    }
    
    static {
        __OBFID = "CL_00001961";
    }
}
