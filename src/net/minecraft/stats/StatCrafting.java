package net.minecraft.stats;

import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.scoreboard.*;

public class StatCrafting extends StatBase
{
    private final /* synthetic */ Item field_150960_a;
    
    public Item func_150959_a() {
        return this.field_150960_a;
    }
    
    public StatCrafting(final String llllllllllllllIIlllIlllllIlllIII, final String llllllllllllllIIlllIlllllIllllIl, final IChatComponent llllllllllllllIIlllIlllllIllllII, final Item llllllllllllllIIlllIlllllIllIlIl) {
        super(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlllIlllllIlllIII)).append(llllllllllllllIIlllIlllllIllllIl)), llllllllllllllIIlllIlllllIllllII);
        this.field_150960_a = llllllllllllllIIlllIlllllIllIlIl;
        final int llllllllllllllIIlllIlllllIlllIlI = Item.getIdFromItem(llllllllllllllIIlllIlllllIllIlIl);
        if (llllllllllllllIIlllIlllllIlllIlI != 0) {
            IScoreObjectiveCriteria.INSTANCES.put(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlllIlllllIlllIII)).append(llllllllllllllIIlllIlllllIlllIlI)), this.func_150952_k());
        }
    }
    
    static {
        __OBFID = "CL_00001470";
    }
}
