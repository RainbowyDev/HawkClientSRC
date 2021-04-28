package net.minecraft.scoreboard;

import com.google.common.collect.*;
import net.minecraft.util.*;
import java.util.*;

public interface IScoreObjectiveCriteria
{
    String getName();
    
    EnumRenderType func_178790_c();
    
    boolean isReadOnly();
    
    int func_96635_a(final List p0);
    
    public enum EnumRenderType
    {
        HEARTS("HEARTS", 1, "HEARTS", 1, "hearts");
        
        private final /* synthetic */ String field_178798_d;
        
        INTEGER("INTEGER", 0, "INTEGER", 0, "integer");
        
        private static final /* synthetic */ Map field_178801_c;
        
        public static EnumRenderType func_178795_a(final String llllllllllllllIlllIlllllIIIIIIII) {
            final EnumRenderType llllllllllllllIlllIlllllIIIIIIIl = EnumRenderType.field_178801_c.get(llllllllllllllIlllIlllllIIIIIIII);
            return (llllllllllllllIlllIlllllIIIIIIIl == null) ? EnumRenderType.INTEGER : llllllllllllllIlllIlllllIIIIIIIl;
        }
        
        private EnumRenderType(final String llllllllllllllIlllIlllllIIIIlllI, final int llllllllllllllIlllIlllllIIIIllIl, final String llllllllllllllIlllIlllllIIIlIIlI, final int llllllllllllllIlllIlllllIIIlIIIl, final String llllllllllllllIlllIlllllIIIlIIII) {
            this.field_178798_d = llllllllllllllIlllIlllllIIIlIIII;
        }
        
        static {
            __OBFID = "CL_00001960";
            field_178801_c = Maps.newHashMap();
            for (final EnumRenderType llllllllllllllIlllIlllllIIlIIllI : values()) {
                EnumRenderType.field_178801_c.put(llllllllllllllIlllIlllllIIlIIllI.func_178796_a(), llllllllllllllIlllIlllllIIlIIllI);
            }
        }
        
        public String func_178796_a() {
            return this.field_178798_d;
        }
    }
}
