package optifine;

import com.google.gson.*;

public class PlayerConfigurationReceiver implements IFileDownloadListener
{
    private /* synthetic */ String player;
    
    @Override
    public void fileDownloadFinished(final String lllllllllllllllllIIlIlIIIIlIIlII, final byte[] lllllllllllllllllIIlIlIIIIlIIIll, final Throwable lllllllllllllllllIIlIlIIIIlIIIlI) {
        if (lllllllllllllllllIIlIlIIIIlIIIll != null) {
            try {
                final String lllllllllllllllllIIlIlIIIIlIIIIl = new String(lllllllllllllllllIIlIlIIIIlIIIll, "ASCII");
                final JsonParser lllllllllllllllllIIlIlIIIIlIIIII = new JsonParser();
                final JsonElement lllllllllllllllllIIlIlIIIIIlllll = lllllllllllllllllIIlIlIIIIlIIIII.parse(lllllllllllllllllIIlIlIIIIlIIIIl);
                final PlayerConfigurationParser lllllllllllllllllIIlIlIIIIIllllI = new PlayerConfigurationParser(this.player);
                final PlayerConfiguration lllllllllllllllllIIlIlIIIIIlllIl = lllllllllllllllllIIlIlIIIIIllllI.parsePlayerConfiguration(lllllllllllllllllIIlIlIIIIIlllll);
                if (lllllllllllllllllIIlIlIIIIIlllIl != null) {
                    lllllllllllllllllIIlIlIIIIIlllIl.setInitialized(true);
                    PlayerConfigurations.setPlayerConfiguration(this.player, lllllllllllllllllIIlIlIIIIIlllIl);
                }
            }
            catch (Exception lllllllllllllllllIIlIlIIIIIlllII) {
                Config.dbg(String.valueOf(new StringBuilder("Error parsing configuration: ").append(lllllllllllllllllIIlIlIIIIlIIlII).append(", ").append(lllllllllllllllllIIlIlIIIIIlllII.getClass().getName()).append(": ").append(lllllllllllllllllIIlIlIIIIIlllII.getMessage())));
            }
        }
    }
    
    public PlayerConfigurationReceiver(final String lllllllllllllllllIIlIlIIIIlIlllI) {
        this.player = null;
        this.player = lllllllllllllllllIIlIlIIIIlIlllI;
    }
}
