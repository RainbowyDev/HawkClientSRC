package net.minecraft.scoreboard;

import java.util.*;
import com.google.common.collect.*;

public abstract class Team
{
    public abstract boolean getAllowFriendlyFire();
    
    public abstract String getRegisteredName();
    
    public abstract EnumVisible func_178771_j();
    
    public abstract boolean func_98297_h();
    
    public boolean isSameTeam(final Team llIIlIIIllllIII) {
        return llIIlIIIllllIII != null && this == llIIlIIIllllIII;
    }
    
    public abstract String formatString(final String p0);
    
    static {
        __OBFID = "CL_00000621";
    }
    
    public abstract Collection getMembershipCollection();
    
    public abstract EnumVisible func_178770_i();
    
    public enum EnumVisible
    {
        HIDE_FOR_OTHER_TEAMS("HIDE_FOR_OTHER_TEAMS", 2, "HIDE_FOR_OTHER_TEAMS", 2, "hideForOtherTeams", 2), 
        ALWAYS("ALWAYS", 0, "ALWAYS", 0, "always", 0), 
        NEVER("NEVER", 1, "NEVER", 1, "never", 1);
        
        private static /* synthetic */ Map field_178828_g;
        public final /* synthetic */ int field_178827_f;
        public final /* synthetic */ String field_178830_e;
        
        HIDE_FOR_OWN_TEAM("HIDE_FOR_OWN_TEAM", 3, "HIDE_FOR_OWN_TEAM", 3, "hideForOwnTeam", 3);
        
        static {
            __OBFID = "CL_00001962";
            EnumVisible.field_178828_g = Maps.newHashMap();
            for (final EnumVisible lllllllllllllllllIIIIIIlllIlllll : values()) {
                EnumVisible.field_178828_g.put(lllllllllllllllllIIIIIIlllIlllll.field_178830_e, lllllllllllllllllIIIIIIlllIlllll);
            }
        }
        
        private EnumVisible(final String lllllllllllllllllIIIIIIlllIIllII, final int lllllllllllllllllIIIIIIlllIIlIll, final String lllllllllllllllllIIIIIIlllIlIIIl, final int lllllllllllllllllIIIIIIlllIlIIII, final String lllllllllllllllllIIIIIIlllIIlIlI, final int lllllllllllllllllIIIIIIlllIIlIIl) {
            this.field_178830_e = lllllllllllllllllIIIIIIlllIIlIlI;
            this.field_178827_f = lllllllllllllllllIIIIIIlllIIlIIl;
        }
        
        public static EnumVisible func_178824_a(final String lllllllllllllllllIIIIIIlllIllIII) {
            return EnumVisible.field_178828_g.get(lllllllllllllllllIIIIIIlllIllIII);
        }
        
        public static String[] func_178825_a() {
            return (String[])EnumVisible.field_178828_g.keySet().toArray(new String[EnumVisible.field_178828_g.size()]);
        }
    }
}
