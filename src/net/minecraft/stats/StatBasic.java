package net.minecraft.stats;

import net.minecraft.util.*;

public class StatBasic extends StatBase
{
    public StatBasic(final String llllllllllllllllIlIIIIlIlllIlIll, final IChatComponent llllllllllllllllIlIIIIlIlllIlIlI) {
        super(llllllllllllllllIlIIIIlIlllIlIll, llllllllllllllllIlIIIIlIlllIlIlI);
    }
    
    public StatBasic(final String llllllllllllllllIlIIIIlIllllIllI, final IChatComponent llllllllllllllllIlIIIIlIllllIIIl, final IStatType llllllllllllllllIlIIIIlIllllIlII) {
        super(llllllllllllllllIlIIIIlIllllIllI, llllllllllllllllIlIIIIlIllllIIIl, llllllllllllllllIlIIIIlIllllIlII);
    }
    
    static {
        __OBFID = "CL_00001469";
    }
    
    @Override
    public StatBase registerStat() {
        super.registerStat();
        StatList.generalStats.add(this);
        return this;
    }
}
