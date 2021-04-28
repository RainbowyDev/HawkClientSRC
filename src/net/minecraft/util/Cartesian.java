package net.minecraft.util;

import java.lang.reflect.*;
import com.google.common.base.*;
import com.google.common.collect.*;
import java.util.*;

public class Cartesian
{
    private static Object[] createArray(final Class llllllllllllllIllllIllIIllllIIII, final int llllllllllllllIllllIllIIllllIIIl) {
        return (Object[])Array.newInstance(llllllllllllllIllllIllIIllllIIII, llllllllllllllIllllIllIIllllIIIl);
    }
    
    static {
        __OBFID = "CL_00002327";
    }
    
    public static Iterable cartesianProduct(final Class llllllllllllllIllllIllIlIIIIllIl, final Iterable llllllllllllllIllllIllIlIIIIlIlI) {
        return new Product(llllllllllllllIllllIllIlIIIIllIl, (Iterable[])toArray(Iterable.class, llllllllllllllIllllIllIlIIIIlIlI), null);
    }
    
    public static Iterable cartesianProduct(final Iterable llllllllllllllIllllIllIlIIIIlIII) {
        return arraysAsLists(cartesianProduct(Object.class, llllllllllllllIllllIllIlIIIIlIII));
    }
    
    private static Iterable arraysAsLists(final Iterable llllllllllllllIllllIllIlIIIIIlIl) {
        return Iterables.transform(llllllllllllllIllllIllIlIIIIIlIl, (Function)new GetList(null));
    }
    
    private static Object[] toArray(final Class llllllllllllllIllllIllIIlllllIIl, final Iterable llllllllllllllIllllIllIIllllllIl) {
        final ArrayList llllllllllllllIllllIllIIllllllII = Lists.newArrayList();
        for (final Object llllllllllllllIllllIllIIlllllIlI : llllllllllllllIllllIllIIllllllIl) {
            llllllllllllllIllllIllIIllllllII.add(llllllllllllllIllllIllIIlllllIlI);
        }
        return llllllllllllllIllllIllIIllllllII.toArray(createArray(llllllllllllllIllllIllIIlllllIIl, llllllllllllllIllllIllIIllllllII.size()));
    }
    
    static class Product implements Iterable
    {
        private final /* synthetic */ Iterable[] iterables;
        private final /* synthetic */ Class clazz;
        
        private Product(final Class lllllllllllllllIlIIIIIlIllIllIlI, final Iterable[] lllllllllllllllIlIIIIIlIllIlllII) {
            this.clazz = lllllllllllllllIlIIIIIlIllIllIlI;
            this.iterables = lllllllllllllllIlIIIIIlIllIlllII;
        }
        
        static {
            __OBFID = "CL_00002324";
        }
        
        Product(final Class lllllllllllllllIlIIIIIlIllIIllIl, final Iterable[] lllllllllllllllIlIIIIIlIllIlIIII, final Object lllllllllllllllIlIIIIIlIllIIllll) {
            this(lllllllllllllllIlIIIIIlIllIIllIl, lllllllllllllllIlIIIIIlIllIlIIII);
        }
        
        @Override
        public Iterator iterator() {
            return (Iterator)((this.iterables.length <= 0) ? Collections.singletonList(createArray(this.clazz, 0)).iterator() : new ProductIterator(this.clazz, this.iterables, null));
        }
        
        static class ProductIterator extends UnmodifiableIterator
        {
            private final /* synthetic */ Iterable[] iterables;
            private final /* synthetic */ Iterator[] iterators;
            private final /* synthetic */ Object[] results;
            private /* synthetic */ int index;
            
            public boolean hasNext() {
                if (this.index == -2) {
                    this.index = 0;
                    for (final Iterator llllllllllllllllIlllIIlllIIlllll : this.iterators) {
                        if (!llllllllllllllllIlllIIlllIIlllll.hasNext()) {
                            this.endOfData();
                            break;
                        }
                    }
                    return true;
                }
                if (this.index >= this.iterators.length) {
                    this.index = this.iterators.length - 1;
                    while (this.index >= 0) {
                        Iterator llllllllllllllllIlllIIlllIIllllI = this.iterators[this.index];
                        if (llllllllllllllllIlllIIlllIIllllI.hasNext()) {
                            break;
                        }
                        if (this.index == 0) {
                            this.endOfData();
                            break;
                        }
                        llllllllllllllllIlllIIlllIIllllI = this.iterables[this.index].iterator();
                        this.iterators[this.index] = llllllllllllllllIlllIIlllIIllllI;
                        if (!llllllllllllllllIlllIIlllIIllllI.hasNext()) {
                            this.endOfData();
                            break;
                        }
                        --this.index;
                    }
                }
                return this.index >= 0;
            }
            
            ProductIterator(final Class llllllllllllllllIlllIIlllIIIlIlI, final Iterable[] llllllllllllllllIlllIIlllIIIlIIl, final Object llllllllllllllllIlllIIlllIIIllII) {
                this(llllllllllllllllIlllIIlllIIIlIlI, llllllllllllllllIlllIIlllIIIlIIl);
            }
            
            public Object next() {
                return this.next0();
            }
            
            static {
                __OBFID = "CL_00002323";
            }
            
            private void endOfData() {
                this.index = -1;
                Arrays.fill(this.iterators, null);
                Arrays.fill(this.results, null);
            }
            
            private ProductIterator(final Class llllllllllllllllIlllIIlllIlIlllI, final Iterable[] llllllllllllllllIlllIIlllIlIllIl) {
                this.index = -2;
                this.iterables = llllllllllllllllIlllIIlllIlIllIl;
                this.iterators = (Iterator[])createArray(Iterator.class, this.iterables.length);
                for (int llllllllllllllllIlllIIlllIllIIII = 0; llllllllllllllllIlllIIlllIllIIII < this.iterables.length; ++llllllllllllllllIlllIIlllIllIIII) {
                    this.iterators[llllllllllllllllIlllIIlllIllIIII] = llllllllllllllllIlllIIlllIlIllIl[llllllllllllllllIlllIIlllIllIIII].iterator();
                }
                this.results = createArray(llllllllllllllllIlllIIlllIlIlllI, this.iterators.length);
            }
            
            public Object[] next0() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                while (this.index < this.iterators.length) {
                    this.results[this.index] = this.iterators[this.index].next();
                    ++this.index;
                }
                return this.results.clone();
            }
        }
    }
    
    static class GetList implements Function
    {
        GetList(final Object lllllllllllllllIllllIlllIIllllII) {
            this();
        }
        
        private GetList() {
        }
        
        public Object apply(final Object lllllllllllllllIllllIlllIlIIIIIl) {
            return this.apply((Object[])lllllllllllllllIllllIlllIlIIIIIl);
        }
        
        static {
            __OBFID = "CL_00002325";
        }
        
        public List apply(final Object[] lllllllllllllllIllllIlllIlIIIllI) {
            return Arrays.asList(lllllllllllllllIllllIlllIlIIIllI);
        }
    }
}
