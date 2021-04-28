package net.minecraft.block.state;

import com.google.common.base.*;
import net.minecraft.util.*;
import net.minecraft.block.*;
import com.google.common.collect.*;
import net.minecraft.block.properties.*;
import java.util.*;

public abstract class BlockStateBase implements IBlockState
{
    private /* synthetic */ int blockStateId;
    private /* synthetic */ int metadata;
    private static final /* synthetic */ Joiner COMMA_JOINER;
    private static final /* synthetic */ Function field_177233_b;
    private /* synthetic */ ResourceLocation blockLocation;
    private /* synthetic */ int blockId;
    
    public int getBlockId() {
        if (this.blockId < 0) {
            this.blockId = Block.getIdFromBlock(this.getBlock());
        }
        return this.blockId;
    }
    
    protected static Object cyclePropertyValue(final Collection lllllllllllllllIllIIIllllllIIIlI, final Object lllllllllllllllIllIIIllllllIIlII) {
        final Iterator lllllllllllllllIllIIIllllllIIIll = lllllllllllllllIllIIIllllllIIIlI.iterator();
        while (lllllllllllllllIllIIIllllllIIIll.hasNext()) {
            if (lllllllllllllllIllIIIllllllIIIll.next().equals(lllllllllllllllIllIIIllllllIIlII)) {
                if (lllllllllllllllIllIIIllllllIIIll.hasNext()) {
                    return lllllllllllllllIllIIIllllllIIIll.next();
                }
                return lllllllllllllllIllIIIllllllIIIlI.iterator().next();
            }
        }
        return lllllllllllllllIllIIIllllllIIIll.next();
    }
    
    @Override
    public String toString() {
        final StringBuilder lllllllllllllllIllIIIlllllIlllII = new StringBuilder();
        lllllllllllllllIllIIIlllllIlllII.append(Block.blockRegistry.getNameForObject(this.getBlock()));
        if (!this.getProperties().isEmpty()) {
            lllllllllllllllIllIIIlllllIlllII.append("[");
            BlockStateBase.COMMA_JOINER.appendTo(lllllllllllllllIllIIIlllllIlllII, Iterables.transform((Iterable)this.getProperties().entrySet(), BlockStateBase.field_177233_b));
            lllllllllllllllIllIIIlllllIlllII.append("]");
        }
        return String.valueOf(lllllllllllllllIllIIIlllllIlllII);
    }
    
    public BlockStateBase() {
        this.blockId = -1;
        this.blockStateId = -1;
        this.metadata = -1;
        this.blockLocation = null;
    }
    
    public ImmutableTable<IProperty, Comparable, IBlockState> getPropertyValueTable() {
        return null;
    }
    
    @Override
    public IBlockState cycleProperty(final IProperty lllllllllllllllIllIIIllllllIlIll) {
        return this.withProperty(lllllllllllllllIllIIIllllllIlIll, (Comparable)cyclePropertyValue(lllllllllllllllIllIIIllllllIlIll.getAllowedValues(), this.getValue(lllllllllllllllIllIIIllllllIlIll)));
    }
    
    public ResourceLocation getBlockLocation() {
        if (this.blockLocation == null) {
            this.blockLocation = (ResourceLocation)Block.blockRegistry.getNameForObject(this.getBlock());
        }
        return this.blockLocation;
    }
    
    public int getMetadata() {
        if (this.metadata < 0) {
            this.metadata = this.getBlock().getMetaFromState(this);
        }
        return this.metadata;
    }
    
    static {
        __OBFID = "CL_00002032";
        COMMA_JOINER = Joiner.on(',');
        field_177233_b = (Function)new Function() {
            public String func_177225_a(final Map.Entry llIIIllIIlIIIIl) {
                if (llIIIllIIlIIIIl == null) {
                    return "<NULL>";
                }
                final IProperty llIIIllIIlIIIlI = llIIIllIIlIIIIl.getKey();
                return String.valueOf(new StringBuilder(String.valueOf(llIIIllIIlIIIlI.getName())).append("=").append(llIIIllIIlIIIlI.getName((Comparable)llIIIllIIlIIIIl.getValue())));
            }
            
            static {
                __OBFID = "CL_00002031";
            }
            
            public Object apply(final Object llIIIllIIIlllII) {
                return this.func_177225_a((Map.Entry)llIIIllIIIlllII);
            }
        };
    }
    
    public int getBlockStateId() {
        if (this.blockStateId < 0) {
            this.blockStateId = Block.getStateId(this);
        }
        return this.blockStateId;
    }
}
