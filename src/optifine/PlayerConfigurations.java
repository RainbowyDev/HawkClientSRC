package optifine;

import net.minecraft.client.entity.*;
import java.util.*;
import net.minecraft.client.model.*;

public class PlayerConfigurations
{
    private static /* synthetic */ Map mapConfigurations;
    
    public static synchronized void setPlayerConfiguration(final String lllllllllllllllllllllllllIIIIIlI, final PlayerConfiguration lllllllllllllllllllllllllIIIIIIl) {
        getMapConfigurations().put(lllllllllllllllllllllllllIIIIIlI, lllllllllllllllllllllllllIIIIIIl);
    }
    
    public static synchronized PlayerConfiguration getPlayerConfiguration(final AbstractClientPlayer lllllllllllllllllllllllllIIlIIlI) {
        final String lllllllllllllllllllllllllIIlIIIl = lllllllllllllllllllllllllIIlIIlI.getNameClear();
        if (lllllllllllllllllllllllllIIlIIIl == null) {
            return null;
        }
        PlayerConfiguration lllllllllllllllllllllllllIIlIIII = getMapConfigurations().get(lllllllllllllllllllllllllIIlIIIl);
        if (lllllllllllllllllllllllllIIlIIII == null) {
            lllllllllllllllllllllllllIIlIIII = new PlayerConfiguration();
            getMapConfigurations().put(lllllllllllllllllllllllllIIlIIIl, lllllllllllllllllllllllllIIlIIII);
            final PlayerConfigurationReceiver lllllllllllllllllllllllllIIIllll = new PlayerConfigurationReceiver(lllllllllllllllllllllllllIIlIIIl);
            final String lllllllllllllllllllllllllIIIlllI = String.valueOf(new StringBuilder("http://s.optifine.net/users/").append(lllllllllllllllllllllllllIIlIIIl).append(".cfg"));
            final FileDownloadThread lllllllllllllllllllllllllIIIllIl = new FileDownloadThread(lllllllllllllllllllllllllIIIlllI, lllllllllllllllllllllllllIIIllll);
            lllllllllllllllllllllllllIIIllIl.start();
        }
        return lllllllllllllllllllllllllIIlIIII;
    }
    
    static {
        PlayerConfigurations.mapConfigurations = null;
    }
    
    private static Map getMapConfigurations() {
        if (PlayerConfigurations.mapConfigurations == null) {
            PlayerConfigurations.mapConfigurations = new HashMap();
        }
        return PlayerConfigurations.mapConfigurations;
    }
    
    public static void renderPlayerItems(final ModelBiped lllllllllllllllllllllllllIlIIIlI, final AbstractClientPlayer lllllllllllllllllllllllllIIlllII, final float lllllllllllllllllllllllllIlIIIII, final float lllllllllllllllllllllllllIIllIlI) {
        final PlayerConfiguration lllllllllllllllllllllllllIIllllI = getPlayerConfiguration(lllllllllllllllllllllllllIIlllII);
        if (lllllllllllllllllllllllllIIllllI != null) {
            lllllllllllllllllllllllllIIllllI.renderPlayerItems(lllllllllllllllllllllllllIlIIIlI, lllllllllllllllllllllllllIIlllII, lllllllllllllllllllllllllIlIIIII, lllllllllllllllllllllllllIIllIlI);
        }
    }
}
