package net.minecraft.client.renderer.block.statemap;

import net.minecraft.block.*;
import com.google.common.collect.*;
import com.google.common.base.*;
import java.util.*;

public class BlockStateMapper
{
    private /* synthetic */ Map field_178450_a;
    private /* synthetic */ Set field_178449_b;
    
    public void func_178447_a(final Block llllllllllllllIlIllIIlIIlIIlllII, final IStateMapper llllllllllllllIlIllIIlIIlIIllIll) {
        this.field_178450_a.put(llllllllllllllIlIllIIlIIlIIlllII, llllllllllllllIlIllIIlIIlIIllIll);
    }
    
    public BlockStateMapper() {
        this.field_178450_a = Maps.newIdentityHashMap();
        this.field_178449_b = Sets.newIdentityHashSet();
    }
    
    public Map func_178446_a() {
        final IdentityHashMap llllllllllllllIlIllIIlIIlIIIllII = Maps.newIdentityHashMap();
        for (final Block llllllllllllllIlIllIIlIIlIIIlIlI : Block.blockRegistry) {
            if (!this.field_178449_b.contains(llllllllllllllIlIllIIlIIlIIIlIlI)) {
                llllllllllllllIlIllIIlIIlIIIllII.putAll(((IStateMapper)Objects.firstNonNull(this.field_178450_a.get(llllllllllllllIlIllIIlIIlIIIlIlI), (Object)new DefaultStateMapper())).func_178130_a(llllllllllllllIlIllIIlIIlIIIlIlI));
            }
        }
        return llllllllllllllIlIllIIlIIlIIIllII;
    }
    
    static {
        __OBFID = "CL_00002478";
    }
    
    public void registerBuiltInBlocks(final Block... llllllllllllllIlIllIIlIIlIIlIlII) {
        Collections.addAll(this.field_178449_b, llllllllllllllIlIllIIlIIlIIlIlII);
    }
}
