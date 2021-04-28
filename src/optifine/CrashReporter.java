package optifine;

import net.minecraft.crash.*;
import shadersmod.client.*;
import java.util.*;
import net.minecraft.client.settings.*;

public class CrashReporter
{
    private static String makeSummary(final CrashReport llllllllllllllllIllIllIIlIIIIIII) {
        final Throwable llllllllllllllllIllIllIIlIIIIlII = llllllllllllllllIllIllIIlIIIIIII.getCrashCause();
        if (llllllllllllllllIllIllIIlIIIIlII == null) {
            return "Unknown";
        }
        final StackTraceElement[] llllllllllllllllIllIllIIlIIIIIll = llllllllllllllllIllIllIIlIIIIlII.getStackTrace();
        String llllllllllllllllIllIllIIlIIIIIlI = "unknown";
        if (llllllllllllllllIllIllIIlIIIIIll.length > 0) {
            llllllllllllllllIllIllIIlIIIIIlI = llllllllllllllllIllIllIIlIIIIIll[0].toString().trim();
        }
        final String llllllllllllllllIllIllIIlIIIIIIl = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIllIllIIlIIIIlII.getClass().getName())).append(": ").append(llllllllllllllllIllIllIIlIIIIlII.getMessage()).append(" (").append(llllllllllllllllIllIllIIlIIIIIII.getDescription()).append(")").append(" [").append(llllllllllllllllIllIllIIlIIIIIlI).append("]"));
        return llllllllllllllllIllIllIIlIIIIIIl;
    }
    
    public static void extendCrashReport(final CrashReportCategory llllllllllllllllIllIllIIIllllIlI) {
        llllllllllllllllIllIllIIIllllIlI.addCrashSection("OptiFine Version", Config.getVersion());
        if (Config.getGameSettings() != null) {
            llllllllllllllllIllIllIIIllllIlI.addCrashSection("Render Distance Chunks", String.valueOf(new StringBuilder().append(Config.getChunkViewDistance())));
            llllllllllllllllIllIllIIIllllIlI.addCrashSection("Mipmaps", String.valueOf(new StringBuilder().append(Config.getMipmapLevels())));
            llllllllllllllllIllIllIIIllllIlI.addCrashSection("Anisotropic Filtering", String.valueOf(new StringBuilder().append(Config.getAnisotropicFilterLevel())));
            llllllllllllllllIllIllIIIllllIlI.addCrashSection("Antialiasing", String.valueOf(new StringBuilder().append(Config.getAntialiasingLevel())));
            llllllllllllllllIllIllIIIllllIlI.addCrashSection("Multitexture", String.valueOf(new StringBuilder().append(Config.isMultiTexture())));
        }
        llllllllllllllllIllIllIIIllllIlI.addCrashSection("Shaders", String.valueOf(new StringBuilder().append(Shaders.getShaderPackName())));
        llllllllllllllllIllIllIIIllllIlI.addCrashSection("OpenGlVersion", String.valueOf(new StringBuilder().append(Config.openGlVersion)));
        llllllllllllllllIllIllIIIllllIlI.addCrashSection("OpenGlRenderer", String.valueOf(new StringBuilder().append(Config.openGlRenderer)));
        llllllllllllllllIllIllIIIllllIlI.addCrashSection("OpenGlVendor", String.valueOf(new StringBuilder().append(Config.openGlVendor)));
        llllllllllllllllIllIllIIIllllIlI.addCrashSection("CpuCount", String.valueOf(new StringBuilder().append(Config.getAvailableProcessors())));
    }
    
    private static String makeReport(final CrashReport llllllllllllllllIllIllIIlIIIllII) {
        final StringBuffer llllllllllllllllIllIllIIlIIIllIl = new StringBuffer();
        llllllllllllllllIllIllIIlIIIllIl.append(String.valueOf(new StringBuilder("OptiFineVersion: ").append(Config.getVersion()).append("\n")));
        llllllllllllllllIllIllIIlIIIllIl.append(String.valueOf(new StringBuilder("Summary: ").append(makeSummary(llllllllllllllllIllIllIIlIIIllII)).append("\n")));
        llllllllllllllllIllIllIIlIIIllIl.append("\n");
        llllllllllllllllIllIllIIlIIIllIl.append(llllllllllllllllIllIllIIlIIIllII.getCompleteReport());
        llllllllllllllllIllIllIIlIIIllIl.append("\n");
        return llllllllllllllllIllIllIIlIIIllIl.toString();
    }
    
    public static void onCrashReport(final CrashReport llllllllllllllllIllIllIIlIIllIlI, final CrashReportCategory llllllllllllllllIllIllIIlIIllIIl) {
        try {
            final GameSettings llllllllllllllllIllIllIIlIlIIIll = Config.getGameSettings();
            if (llllllllllllllllIllIllIIlIlIIIll == null) {
                return;
            }
            if (!llllllllllllllllIllIllIIlIlIIIll.snooperEnabled) {
                return;
            }
            final Throwable llllllllllllllllIllIllIIlIlIIIlI = llllllllllllllllIllIllIIlIIllIlI.getCrashCause();
            if (llllllllllllllllIllIllIIlIlIIIlI == null) {
                return;
            }
            if (llllllllllllllllIllIllIIlIlIIIlI.getClass() == Throwable.class) {
                return;
            }
            if (llllllllllllllllIllIllIIlIlIIIlI.getClass().getName().contains(".fml.client.SplashProgress")) {
                return;
            }
            extendCrashReport(llllllllllllllllIllIllIIlIIllIIl);
            final String llllllllllllllllIllIllIIlIlIIIIl = "http://optifine.net/crashReport";
            final String llllllllllllllllIllIllIIlIlIIIII = makeReport(llllllllllllllllIllIllIIlIIllIlI);
            final byte[] llllllllllllllllIllIllIIlIIlllll = llllllllllllllllIllIllIIlIlIIIII.getBytes("ASCII");
            final IFileUploadListener llllllllllllllllIllIllIIlIIllllI = new IFileUploadListener() {
                @Override
                public void fileUploadFinished(final String lllllllllllllllIllIIIIlIIlIIllII, final byte[] lllllllllllllllIllIIIIlIIlIIlIll, final Throwable lllllllllllllllIllIIIIlIIlIIlIlI) {
                }
            };
            final HashMap llllllllllllllllIllIllIIlIIlllIl = new HashMap();
            llllllllllllllllIllIllIIlIIlllIl.put("OF-Version", Config.getVersion());
            llllllllllllllllIllIllIIlIIlllIl.put("OF-Summary", makeSummary(llllllllllllllllIllIllIIlIIllIlI));
            final FileUploadThread llllllllllllllllIllIllIIlIIlllII = new FileUploadThread(llllllllllllllllIllIllIIlIlIIIIl, llllllllllllllllIllIllIIlIIlllIl, llllllllllllllllIllIllIIlIIlllll, llllllllllllllllIllIllIIlIIllllI);
            llllllllllllllllIllIllIIlIIlllII.setPriority(10);
            llllllllllllllllIllIllIIlIIlllII.start();
            Thread.sleep(1000L);
        }
        catch (Exception llllllllllllllllIllIllIIlIIllIll) {
            Config.dbg(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIllIllIIlIIllIll.getClass().getName())).append(": ").append(llllllllllllllllIllIllIIlIIllIll.getMessage())));
        }
    }
}
