package alts;

import java.util.*;

public class AltManager
{
    public static /* synthetic */ Alt lastAlt;
    public static /* synthetic */ ArrayList<Alt> registry;
    
    public void setLastAlt(final Alt lllllllllllllllIIllIllIIlIIIllII) {
        AltManager.lastAlt = lllllllllllllllIIllIllIIlIIIllII;
    }
    
    static {
        AltManager.registry = new ArrayList<Alt>();
    }
    
    public ArrayList<Alt> getRegistry() {
        return AltManager.registry;
    }
}
