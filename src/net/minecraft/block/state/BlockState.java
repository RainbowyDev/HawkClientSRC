package net.minecraft.block.state;

import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import com.google.common.base.*;
import net.minecraft.util.*;
import com.google.common.collect.*;
import java.util.*;

public class BlockState
{
    private final /* synthetic */ ImmutableList properties;
    private final /* synthetic */ Block block;
    private final /* synthetic */ ImmutableList validStates;
    private static final /* synthetic */ Function GET_NAME_FUNC;
    
    public Collection getProperties() {
        return (Collection)this.properties;
    }
    
    public ImmutableList getValidStates() {
        return this.validStates;
    }
    
    public IBlockState getBaseState() {
        return (IBlockState)this.validStates.get(0);
    }
    
    static {
        __OBFID = "CL_00002030";
        COMMA_JOINER = Joiner.on(", ");
        GET_NAME_FUNC = (Function)new Function() {
            public String apply(final IProperty llllllllllllllIllIlllIIlIlIIIllI) {
                return (llllllllllllllIllIlllIIlIlIIIllI == null) ? "<NULL>" : llllllllllllllIllIlllIIlIlIIIllI.getName();
            }
            
            static {
                __OBFID = "CL_00002029";
            }
            
            public Object apply(final Object llllllllllllllIllIlllIIlIIllllll) {
                return this.apply((IProperty)llllllllllllllIllIlllIIlIIllllll);
            }
        };
    }
    
    private List getAllowedValues() {
        final ArrayList lllllllllllllllllIIlIIIIlIllIIll = Lists.newArrayList();
        for (int lllllllllllllllllIIlIIIIlIllIIlI = 0; lllllllllllllllllIIlIIIIlIllIIlI < this.properties.size(); ++lllllllllllllllllIIlIIIIlIllIIlI) {
            lllllllllllllllllIIlIIIIlIllIIll.add(((IProperty)this.properties.get(lllllllllllllllllIIlIIIIlIllIIlI)).getAllowedValues());
        }
        return lllllllllllllllllIIlIIIIlIllIIll;
    }
    
    @Override
    public String toString() {
        return Objects.toStringHelper((Object)this).add("block", Block.blockRegistry.getNameForObject(this.block)).add("properties", (Object)Iterables.transform((Iterable)this.properties, BlockState.GET_NAME_FUNC)).toString();
    }
    
    public BlockState(final Block lllllllllllllllllIIlIIIIllIIlllI, final IProperty... lllllllllllllllllIIlIIIIllIIllIl) {
        this.block = lllllllllllllllllIIlIIIIllIIlllI;
        Arrays.sort(lllllllllllllllllIIlIIIIllIIllIl, new Comparator() {
            public int compare(final IProperty lIlllIIIlIlIII, final IProperty lIlllIIIlIIlll) {
                return lIlllIIIlIlIII.getName().compareTo(lIlllIIIlIIlll.getName());
            }
            
            @Override
            public int compare(final Object lIlllIIIIlllIl, final Object lIlllIIIIlllll) {
                return this.compare((IProperty)lIlllIIIIlllIl, (IProperty)lIlllIIIIlllll);
            }
            
            static {
                __OBFID = "CL_00002028";
            }
        });
        this.properties = ImmutableList.copyOf((Object[])lllllllllllllllllIIlIIIIllIIllIl);
        final LinkedHashMap lllllllllllllllllIIlIIIIllIIllII = Maps.newLinkedHashMap();
        final ArrayList lllllllllllllllllIIlIIIIllIIlIll = Lists.newArrayList();
        final Iterable lllllllllllllllllIIlIIIIllIIlIlI = Cartesian.cartesianProduct(this.getAllowedValues());
        for (final List lllllllllllllllllIIlIIIIllIIlIII : lllllllllllllllllIIlIIIIllIIlIlI) {
            final Map lllllllllllllllllIIlIIIIllIIIlll = MapPopulator.createMap((Iterable)this.properties, lllllllllllllllllIIlIIIIllIIlIII);
            final StateImplemenation lllllllllllllllllIIlIIIIllIIIllI = new StateImplemenation(lllllllllllllllllIIlIIIIllIIlllI, ImmutableMap.copyOf(lllllllllllllllllIIlIIIIllIIIlll), null);
            lllllllllllllllllIIlIIIIllIIllII.put(lllllllllllllllllIIlIIIIllIIIlll, lllllllllllllllllIIlIIIIllIIIllI);
            lllllllllllllllllIIlIIIIllIIlIll.add(lllllllllllllllllIIlIIIIllIIIllI);
        }
        for (final StateImplemenation lllllllllllllllllIIlIIIIllIIIlIl : lllllllllllllllllIIlIIIIllIIlIll) {
            lllllllllllllllllIIlIIIIllIIIlIl.buildPropertyValueTable(lllllllllllllllllIIlIIIIllIIllII);
        }
        this.validStates = ImmutableList.copyOf((Collection)lllllllllllllllllIIlIIIIllIIlIll);
    }
    
    public Block getBlock() {
        return this.block;
    }
    
    static class StateImplemenation extends BlockStateBase
    {
        private /* synthetic */ ImmutableTable propertyValueTable;
        private final /* synthetic */ ImmutableMap properties;
        private final /* synthetic */ Block block;
        
        StateImplemenation(final Block lllllllllllllllIlIIIllIIIlIIIIll, final ImmutableMap lllllllllllllllIlIIIllIIIlIIIIlI, final Object lllllllllllllllIlIIIllIIIlIIIlIl) {
            this(lllllllllllllllIlIIIllIIIlIIIIll, lllllllllllllllIlIIIllIIIlIIIIlI);
        }
        
        public void buildPropertyValueTable(final Map lllllllllllllllIlIIIllIIIlIlllIl) {
            if (this.propertyValueTable != null) {
                throw new IllegalStateException();
            }
            final HashBasedTable lllllllllllllllIlIIIllIIIllIIIll = HashBasedTable.create();
            for (final IProperty lllllllllllllllIlIIIllIIIllIIIIl : this.properties.keySet()) {
                for (final Comparable lllllllllllllllIlIIIllIIIlIlllll : lllllllllllllllIlIIIllIIIllIIIIl.getAllowedValues()) {
                    if (lllllllllllllllIlIIIllIIIlIlllll != this.properties.get((Object)lllllllllllllllIlIIIllIIIllIIIIl)) {
                        lllllllllllllllIlIIIllIIIllIIIll.put((Object)lllllllllllllllIlIIIllIIIllIIIIl, (Object)lllllllllllllllIlIIIllIIIlIlllll, lllllllllllllllIlIIIllIIIlIlllIl.get(this.setPropertyValue(lllllllllllllllIlIIIllIIIllIIIIl, lllllllllllllllIlIIIllIIIlIlllll)));
                    }
                }
            }
            this.propertyValueTable = ImmutableTable.copyOf((Table)lllllllllllllllIlIIIllIIIllIIIll);
        }
        
        private StateImplemenation(final Block lllllllllllllllIlIIIllIIlIIIllll, final ImmutableMap lllllllllllllllIlIIIllIIlIIlIIIl) {
            this.block = lllllllllllllllIlIIIllIIlIIIllll;
            this.properties = lllllllllllllllIlIIIllIIlIIlIIIl;
        }
        
        @Override
        public boolean equals(final Object lllllllllllllllIlIIIllIIIlllIIII) {
            return this == lllllllllllllllIlIIIllIIIlllIIII;
        }
        
        static {
            __OBFID = "CL_00002027";
        }
        
        @Override
        public Comparable getValue(final IProperty lllllllllllllllIlIIIllIIlIIIIlIl) {
            if (!this.properties.containsKey((Object)lllllllllllllllIlIIIllIIlIIIIlIl)) {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder("Cannot get property ").append(lllllllllllllllIlIIIllIIlIIIIlIl).append(" as it does not exist in ").append(this.block.getBlockState())));
            }
            return lllllllllllllllIlIIIllIIlIIIIlIl.getValueClass().cast(this.properties.get((Object)lllllllllllllllIlIIIllIIlIIIIlIl));
        }
        
        private Map setPropertyValue(final IProperty lllllllllllllllIlIIIllIIIlIlIIlI, final Comparable lllllllllllllllIlIIIllIIIlIIllIl) {
            final HashMap lllllllllllllllIlIIIllIIIlIlIIII = Maps.newHashMap((Map)this.properties);
            lllllllllllllllIlIIIllIIIlIlIIII.put(lllllllllllllllIlIIIllIIIlIlIIlI, lllllllllllllllIlIIIllIIIlIIllIl);
            return lllllllllllllllIlIIIllIIIlIlIIII;
        }
        
        @Override
        public ImmutableMap getProperties() {
            return this.properties;
        }
        
        @Override
        public IBlockState withProperty(final IProperty lllllllllllllllIlIIIllIIlIIIIIII, final Comparable lllllllllllllllIlIIIllIIIlllllII) {
            if (!this.properties.containsKey((Object)lllllllllllllllIlIIIllIIlIIIIIII)) {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder("Cannot set property ").append(lllllllllllllllIlIIIllIIlIIIIIII).append(" as it does not exist in ").append(this.block.getBlockState())));
            }
            if (!lllllllllllllllIlIIIllIIlIIIIIII.getAllowedValues().contains(lllllllllllllllIlIIIllIIIlllllII)) {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder("Cannot set property ").append(lllllllllllllllIlIIIllIIlIIIIIII).append(" to ").append(lllllllllllllllIlIIIllIIIlllllII).append(" on block ").append(Block.blockRegistry.getNameForObject(this.block)).append(", it is not an allowed value")));
            }
            return (this.properties.get((Object)lllllllllllllllIlIIIllIIlIIIIIII) == lllllllllllllllIlIIIllIIIlllllII) ? this : ((IBlockState)this.propertyValueTable.get((Object)lllllllllllllllIlIIIllIIlIIIIIII, (Object)lllllllllllllllIlIIIllIIIlllllII));
        }
        
        @Override
        public Block getBlock() {
            return this.block;
        }
        
        @Override
        public Collection getPropertyNames() {
            return Collections.unmodifiableCollection((Collection<?>)this.properties.keySet());
        }
        
        @Override
        public int hashCode() {
            return this.properties.hashCode();
        }
    }
}
