package optifine;

import java.net.*;
import net.minecraft.client.*;
import java.io.*;

public class VersionCheckThread extends Thread
{
    @Override
    public void run() {
        HttpURLConnection llllllllllllllIllllIlIlIlIlIIIII = null;
        try {
            Config.dbg("Checking for new version");
            final URL llllllllllllllIllllIlIlIlIIlllll = new URL("http://optifine.net/version/1.8/HD_U.txt");
            llllllllllllllIllllIlIlIlIlIIIII = (HttpURLConnection)llllllllllllllIllllIlIlIlIIlllll.openConnection();
            if (Config.getGameSettings().snooperEnabled) {
                llllllllllllllIllllIlIlIlIlIIIII.setRequestProperty("OF-MC-Version", "1.8");
                llllllllllllllIllllIlIlIlIlIIIII.setRequestProperty("OF-MC-Brand", String.valueOf(new StringBuilder().append(ClientBrandRetriever.getClientModName())));
                llllllllllllllIllllIlIlIlIlIIIII.setRequestProperty("OF-Edition", "HD_U");
                llllllllllllllIllllIlIlIlIlIIIII.setRequestProperty("OF-Release", "H6");
                llllllllllllllIllllIlIlIlIlIIIII.setRequestProperty("OF-Java-Version", String.valueOf(new StringBuilder().append(System.getProperty("java.version"))));
                llllllllllllllIllllIlIlIlIlIIIII.setRequestProperty("OF-CpuCount", String.valueOf(new StringBuilder().append(Config.getAvailableProcessors())));
                llllllllllllllIllllIlIlIlIlIIIII.setRequestProperty("OF-OpenGL-Version", String.valueOf(new StringBuilder().append(Config.openGlVersion)));
                llllllllllllllIllllIlIlIlIlIIIII.setRequestProperty("OF-OpenGL-Vendor", String.valueOf(new StringBuilder().append(Config.openGlVendor)));
            }
            llllllllllllllIllllIlIlIlIlIIIII.setDoInput(true);
            llllllllllllllIllllIlIlIlIlIIIII.setDoOutput(false);
            llllllllllllllIllllIlIlIlIlIIIII.connect();
            try {
                final InputStream llllllllllllllIllllIlIlIlIIllllI = llllllllllllllIllllIlIlIlIlIIIII.getInputStream();
                final String llllllllllllllIllllIlIlIlIIlllIl = Config.readInputStream(llllllllllllllIllllIlIlIlIIllllI);
                llllllllllllllIllllIlIlIlIIllllI.close();
                final String[] llllllllllllllIllllIlIlIlIIlllII = Config.tokenize(llllllllllllllIllllIlIlIlIIlllIl, "\n\r");
                if (llllllllllllllIllllIlIlIlIIlllII.length < 1) {
                    return;
                }
                final String llllllllllllllIllllIlIlIlIIllIll = llllllllllllllIllllIlIlIlIIlllII[0].trim();
                Config.dbg(String.valueOf(new StringBuilder("Version found: ").append(llllllllllllllIllllIlIlIlIIllIll)));
                if (Config.compareRelease(llllllllllllllIllllIlIlIlIIllIll, "H6") > 0) {
                    Config.setNewRelease(llllllllllllllIllllIlIlIlIIllIll);
                    return;
                }
            }
            finally {
                if (llllllllllllllIllllIlIlIlIlIIIII != null) {
                    llllllllllllllIllllIlIlIlIlIIIII.disconnect();
                }
            }
            if (llllllllllllllIllllIlIlIlIlIIIII != null) {
                llllllllllllllIllllIlIlIlIlIIIII.disconnect();
            }
        }
        catch (Exception llllllllllllllIllllIlIlIlIIllIlI) {
            Config.dbg(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIllllIlIlIlIIllIlI.getClass().getName())).append(": ").append(llllllllllllllIllllIlIlIlIIllIlI.getMessage())));
        }
    }
}
