package net.minecraft.client.renderer.block.statemap;

import net.minecraft.block.state.*;
import net.minecraft.client.resources.model.*;
import com.google.common.collect.*;
import net.minecraft.block.*;
import java.util.*;
import net.minecraft.block.properties.*;

public abstract class StateMapperBase implements IStateMapper
{
    protected /* synthetic */ Map field_178133_b;
    
    protected abstract ModelResourceLocation func_178132_a(final IBlockState p0);
    
    public StateMapperBase() {
        this.field_178133_b = Maps.newLinkedHashMap();
    }
    
    @Override
    public Map func_178130_a(final Block lllllllllllllllllIlIIlllIllIllII) {
        for (final IBlockState lllllllllllllllllIlIIlllIllIlIII : lllllllllllllllllIlIIlllIllIllII.getBlockState().getValidStates()) {
            this.field_178133_b.put(lllllllllllllllllIlIIlllIllIlIII, this.func_178132_a(lllllllllllllllllIlIIlllIllIlIII));
        }
        return this.field_178133_b;
    }
    
    static {
        __OBFID = "CL_00002479";
    }
    
    public String func_178131_a(final Map lllllllllllllllllIlIIllllIIIIlll) {
        final StringBuilder lllllllllllllllllIlIIllllIIIIllI = new StringBuilder();
        for (final Map.Entry lllllllllllllllllIlIIllllIIIIIll : lllllllllllllllllIlIIllllIIIIlll.entrySet()) {
            if (lllllllllllllllllIlIIllllIIIIllI.length() != 0) {
                lllllllllllllllllIlIIllllIIIIllI.append(",");
            }
            final IProperty lllllllllllllllllIlIIllllIIIIIlI = lllllllllllllllllIlIIllllIIIIIll.getKey();
            final Comparable lllllllllllllllllIlIIllllIIIIIII = lllllllllllllllllIlIIllllIIIIIll.getValue();
            lllllllllllllllllIlIIllllIIIIllI.append(lllllllllllllllllIlIIllllIIIIIlI.getName());
            lllllllllllllllllIlIIllllIIIIllI.append("=");
            lllllllllllllllllIlIIllllIIIIllI.append(lllllllllllllllllIlIIllllIIIIIlI.getName(lllllllllllllllllIlIIllllIIIIIII));
        }
        if (lllllllllllllllllIlIIllllIIIIllI.length() == 0) {
            lllllllllllllllllIlIIllllIIIIllI.append("normal");
        }
        return String.valueOf(lllllllllllllllllIlIIllllIIIIllI);
    }
}
