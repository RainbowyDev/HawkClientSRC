package optifine;

import java.util.*;

public class CustomItemsComparator implements Comparator
{
    @Override
    public int compare(final Object lllllllllllllllIIllllIllIllIIIll, final Object lllllllllllllllIIllllIllIllIIllI) {
        final CustomItemProperties lllllllllllllllIIllllIllIllIIlIl = (CustomItemProperties)lllllllllllllllIIllllIllIllIIIll;
        final CustomItemProperties lllllllllllllllIIllllIllIllIIlII = (CustomItemProperties)lllllllllllllllIIllllIllIllIIllI;
        return (lllllllllllllllIIllllIllIllIIlIl.weight != lllllllllllllllIIllllIllIllIIlII.weight) ? (lllllllllllllllIIllllIllIllIIlII.weight - lllllllllllllllIIllllIllIllIIlIl.weight) : (Config.equals(lllllllllllllllIIllllIllIllIIlIl.basePath, lllllllllllllllIIllllIllIllIIlII.basePath) ? lllllllllllllllIIllllIllIllIIlIl.name.compareTo(lllllllllllllllIIllllIllIllIIlII.name) : lllllllllllllllIIllllIllIllIIlIl.basePath.compareTo(lllllllllllllllIIllllIllIllIIlII.basePath));
    }
}
