package net.minecraft.util;

import com.google.common.collect.*;
import java.util.*;

public class MapPopulator
{
    public static Map createMap(final Iterable llllllllllllllIllllIIlIIlIIIIIII, final Iterable llllllllllllllIllllIIlIIIllllllI) {
        return populateMap(llllllllllllllIllllIIlIIlIIIIIII, llllllllllllllIllllIIlIIIllllllI, Maps.newLinkedHashMap());
    }
    
    static {
        __OBFID = "CL_00002318";
    }
    
    public static Map populateMap(final Iterable llllllllllllllIllllIIlIIIlllIlII, final Iterable llllllllllllllIllllIIlIIIlllIIll, final Map llllllllllllllIllllIIlIIIllIllII) {
        final Iterator llllllllllllllIllllIIlIIIlllIIIl = llllllllllllllIllllIIlIIIlllIIll.iterator();
        for (final Object llllllllllllllIllllIIlIIIllIllll : llllllllllllllIllllIIlIIIlllIlII) {
            llllllllllllllIllllIIlIIIllIllII.put(llllllllllllllIllllIIlIIIllIllll, llllllllllllllIllllIIlIIIlllIIIl.next());
        }
        if (llllllllllllllIllllIIlIIIlllIIIl.hasNext()) {
            throw new NoSuchElementException();
        }
        return llllllllllllllIllllIIlIIIllIllII;
    }
}
