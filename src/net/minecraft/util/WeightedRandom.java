package net.minecraft.util;

import java.util.*;

public class WeightedRandom
{
    public static Item getRandomItem(final Random lllllllllllllllIllIIIlllIIIIIllI, final Collection lllllllllllllllIllIIIlllIIIIIlIl, final int lllllllllllllllIllIIIlllIIIIlIII) {
        if (lllllllllllllllIllIIIlllIIIIlIII <= 0) {
            throw new IllegalArgumentException();
        }
        final int lllllllllllllllIllIIIlllIIIIIlll = lllllllllllllllIllIIIlllIIIIIllI.nextInt(lllllllllllllllIllIIIlllIIIIlIII);
        return func_180166_a(lllllllllllllllIllIIIlllIIIIIlIl, lllllllllllllllIllIIIlllIIIIIlll);
    }
    
    public static Item func_180166_a(final Collection lllllllllllllllIllIIIllIlllllIlI, int lllllllllllllllIllIIIllIlllllIIl) {
        for (final Item lllllllllllllllIllIIIllIlllllIll : lllllllllllllllIllIIIllIlllllIlI) {
            lllllllllllllllIllIIIllIlllllIIl -= lllllllllllllllIllIIIllIlllllIll.itemWeight;
            if (lllllllllllllllIllIIIllIlllllIIl < 0) {
                return lllllllllllllllIllIIIllIlllllIll;
            }
        }
        return null;
    }
    
    public static Item getRandomItem(final Random lllllllllllllllIllIIIllIllllIIlI, final Collection lllllllllllllllIllIIIllIllllIIll) {
        return getRandomItem(lllllllllllllllIllIIIllIllllIIlI, lllllllllllllllIllIIIllIllllIIll, getTotalWeight(lllllllllllllllIllIIIllIllllIIll));
    }
    
    public static int getTotalWeight(final Collection lllllllllllllllIllIIIlllIIIlIIlI) {
        int lllllllllllllllIllIIIlllIIIlIlIl = 0;
        for (final Item lllllllllllllllIllIIIlllIIIlIlII : lllllllllllllllIllIIIlllIIIlIIlI) {
            lllllllllllllllIllIIIlllIIIlIlIl += lllllllllllllllIllIIIlllIIIlIlII.itemWeight;
        }
        return lllllllllllllllIllIIIlllIIIlIlIl;
    }
    
    static {
        __OBFID = "CL_00001503";
    }
    
    public static class Item
    {
        protected /* synthetic */ int itemWeight;
        
        static {
            __OBFID = "CL_00001504";
        }
        
        public Item(final int lllllllllllllllIIllllllIIIlIlllI) {
            this.itemWeight = lllllllllllllllIIllllllIIIlIlllI;
        }
    }
}
