package net.minecraft.client.renderer.block.statemap;

import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.client.resources.model.*;
import net.minecraft.util.*;
import net.minecraft.block.*;
import java.util.*;
import com.google.common.collect.*;

public class StateMap extends StateMapperBase
{
    private final /* synthetic */ List field_178140_d;
    private final /* synthetic */ IProperty field_178142_a;
    private final /* synthetic */ String field_178141_c;
    
    StateMap(final IProperty lllllllllllllllIIIIlIllllIIllIll, final String lllllllllllllllIIIIlIllllIIllIlI, final List lllllllllllllllIIIIlIllllIIllIIl, final Object lllllllllllllllIIIIlIllllIIlllIl) {
        this(lllllllllllllllIIIIlIllllIIllIll, lllllllllllllllIIIIlIllllIIllIlI, lllllllllllllllIIIIlIllllIIllIIl);
    }
    
    static {
        __OBFID = "CL_00002476";
    }
    
    private StateMap(final IProperty lllllllllllllllIIIIlIllllIlllIll, final String lllllllllllllllIIIIlIllllIlllIlI, final List lllllllllllllllIIIIlIllllIlllIIl) {
        this.field_178142_a = lllllllllllllllIIIIlIllllIlllIll;
        this.field_178141_c = lllllllllllllllIIIIlIllllIlllIlI;
        this.field_178140_d = lllllllllllllllIIIIlIllllIlllIIl;
    }
    
    @Override
    protected ModelResourceLocation func_178132_a(final IBlockState lllllllllllllllIIIIlIllllIllIIIl) {
        final LinkedHashMap lllllllllllllllIIIIlIllllIllIIII = Maps.newLinkedHashMap((Map)lllllllllllllllIIIIlIllllIllIIIl.getProperties());
        String lllllllllllllllIIIIlIllllIlIlllI = null;
        if (this.field_178142_a == null) {
            final String lllllllllllllllIIIIlIllllIlIllll = ((ResourceLocation)Block.blockRegistry.getNameForObject(lllllllllllllllIIIIlIllllIllIIIl.getBlock())).toString();
        }
        else {
            lllllllllllllllIIIIlIllllIlIlllI = this.field_178142_a.getName((Comparable)lllllllllllllllIIIIlIllllIllIIII.remove(this.field_178142_a));
        }
        if (this.field_178141_c != null) {
            lllllllllllllllIIIIlIllllIlIlllI = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIIIlIllllIlIlllI)).append(this.field_178141_c));
        }
        for (final IProperty lllllllllllllllIIIIlIllllIlIllII : this.field_178140_d) {
            lllllllllllllllIIIIlIllllIllIIII.remove(lllllllllllllllIIIIlIllllIlIllII);
        }
        return new ModelResourceLocation(lllllllllllllllIIIIlIllllIlIlllI, this.func_178131_a(lllllllllllllllIIIIlIllllIllIIII));
    }
    
    public static class Builder
    {
        private final /* synthetic */ List field_178444_c;
        private /* synthetic */ IProperty field_178445_a;
        private /* synthetic */ String field_178443_b;
        
        static {
            __OBFID = "CL_00002474";
        }
        
        public StateMap build() {
            return new StateMap(this.field_178445_a, this.field_178443_b, this.field_178444_c, null);
        }
        
        public Builder func_178439_a(final String lllllllllllllllIlIlIllIlIIlIllll) {
            this.field_178443_b = lllllllllllllllIlIlIllIlIIlIllll;
            return this;
        }
        
        public Builder func_178440_a(final IProperty lllllllllllllllIlIlIllIlIIllIlIl) {
            this.field_178445_a = lllllllllllllllIlIlIllIlIIllIlIl;
            return this;
        }
        
        public Builder func_178442_a(final IProperty... lllllllllllllllIlIlIllIlIIlIlIIl) {
            Collections.addAll(this.field_178444_c, lllllllllllllllIlIlIllIlIIlIlIIl);
            return this;
        }
        
        public Builder() {
            this.field_178444_c = Lists.newArrayList();
        }
    }
}
