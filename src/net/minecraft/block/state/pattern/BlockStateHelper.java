package net.minecraft.block.state.pattern;

import com.google.common.base.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import java.util.*;
import com.google.common.collect.*;

public class BlockStateHelper implements Predicate
{
    private final /* synthetic */ Map field_177640_b;
    private final /* synthetic */ BlockState field_177641_a;
    
    public boolean apply(final Object llllllllllllllIIlIIIllIIllllllIl) {
        return this.func_177639_a((IBlockState)llllllllllllllIIlIIIllIIllllllIl);
    }
    
    public static BlockStateHelper forBlock(final Block llllllllllllllIIlIIIllIlIIIllIIl) {
        return new BlockStateHelper(llllllllllllllIIlIIIllIlIIIllIIl.getBlockState());
    }
    
    static {
        __OBFID = "CL_00002019";
    }
    
    public boolean func_177639_a(final IBlockState llllllllllllllIIlIIIllIlIIIIllIl) {
        if (llllllllllllllIIlIIIllIlIIIIllIl != null && llllllllllllllIIlIIIllIlIIIIllIl.getBlock().equals(this.field_177641_a.getBlock())) {
            for (final Map.Entry llllllllllllllIIlIIIllIlIIIlIIII : this.field_177640_b.entrySet()) {
                final Comparable llllllllllllllIIlIIIllIlIIIIllll = llllllllllllllIIlIIIllIlIIIIllIl.getValue(llllllllllllllIIlIIIllIlIIIlIIII.getKey());
                if (!llllllllllllllIIlIIIllIlIIIlIIII.getValue().apply((Object)llllllllllllllIIlIIIllIlIIIIllll)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    public BlockStateHelper func_177637_a(final IProperty llllllllllllllIIlIIIllIlIIIIIIlI, final Predicate llllllllllllllIIlIIIllIlIIIIIIIl) {
        if (!this.field_177641_a.getProperties().contains(llllllllllllllIIlIIIllIlIIIIIIlI)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(this.field_177641_a).append(" cannot support property ").append(llllllllllllllIIlIIIllIlIIIIIIlI)));
        }
        this.field_177640_b.put(llllllllllllllIIlIIIllIlIIIIIIlI, llllllllllllllIIlIIIllIlIIIIIIIl);
        return this;
    }
    
    private BlockStateHelper(final BlockState llllllllllllllIIlIIIllIlIIIlllII) {
        this.field_177640_b = Maps.newHashMap();
        this.field_177641_a = llllllllllllllIIlIIIllIlIIIlllII;
    }
}
