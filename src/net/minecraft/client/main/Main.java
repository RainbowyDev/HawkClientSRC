package net.minecraft.client.main;

import java.io.*;
import net.minecraft.client.*;
import java.net.*;
import com.mojang.authlib.properties.*;
import com.google.gson.*;
import java.lang.reflect.*;
import net.minecraft.util.*;
import joptsimple.*;
import java.util.*;

public class Main
{
    private static boolean func_110121_a(final String lllllllllllllllllIlIIIIllIlIIllI) {
        return lllllllllllllllllIlIIIIllIlIIllI != null && !lllllllllllllllllIlIIIIllIlIIllI.isEmpty();
    }
    
    static {
        __OBFID = "CL_00001461";
    }
    
    public static void main(final String[] lllllllllllllllllIlIIIlIIIIIlIII) {
        System.setProperty("java.net.preferIPv4Stack", "true");
        final OptionParser lllllllllllllllllIlIIIlIIIIIIllI = new OptionParser();
        lllllllllllllllllIlIIIlIIIIIIllI.allowsUnrecognizedOptions();
        lllllllllllllllllIlIIIlIIIIIIllI.accepts("demo");
        lllllllllllllllllIlIIIlIIIIIIllI.accepts("fullscreen");
        lllllllllllllllllIlIIIlIIIIIIllI.accepts("checkGlErrors");
        final ArgumentAcceptingOptionSpec lllllllllllllllllIlIIIlIIIIIIlIl = lllllllllllllllllIlIIIlIIIIIIllI.accepts("server").withRequiredArg();
        final ArgumentAcceptingOptionSpec lllllllllllllllllIlIIIlIIIIIIIll = lllllllllllllllllIlIIIlIIIIIIllI.accepts("port").withRequiredArg().ofType((Class)Integer.class).defaultsTo((Object)25565, (Object[])new Integer[0]);
        final ArgumentAcceptingOptionSpec lllllllllllllllllIlIIIlIIIIIIIlI = lllllllllllllllllIlIIIlIIIIIIllI.accepts("gameDir").withRequiredArg().ofType((Class)File.class).defaultsTo((Object)new File("."), (Object[])new File[0]);
        final ArgumentAcceptingOptionSpec lllllllllllllllllIlIIIlIIIIIIIIl = lllllllllllllllllIlIIIlIIIIIIllI.accepts("assetsDir").withRequiredArg().ofType((Class)File.class);
        final ArgumentAcceptingOptionSpec lllllllllllllllllIlIIIIlllllllll = lllllllllllllllllIlIIIlIIIIIIllI.accepts("resourcePackDir").withRequiredArg().ofType((Class)File.class);
        final ArgumentAcceptingOptionSpec lllllllllllllllllIlIIIIlllllllIl = lllllllllllllllllIlIIIlIIIIIIllI.accepts("proxyHost").withRequiredArg();
        final ArgumentAcceptingOptionSpec lllllllllllllllllIlIIIIlllllllII = lllllllllllllllllIlIIIlIIIIIIllI.accepts("proxyPort").withRequiredArg().defaultsTo((Object)"8080", (Object[])new String[0]).ofType((Class)Integer.class);
        final ArgumentAcceptingOptionSpec lllllllllllllllllIlIIIIllllllIll = lllllllllllllllllIlIIIlIIIIIIllI.accepts("proxyUser").withRequiredArg();
        final ArgumentAcceptingOptionSpec lllllllllllllllllIlIIIIllllllIIl = lllllllllllllllllIlIIIlIIIIIIllI.accepts("proxyPass").withRequiredArg();
        final ArgumentAcceptingOptionSpec lllllllllllllllllIlIIIIllllllIII = lllllllllllllllllIlIIIlIIIIIIllI.accepts("username").withRequiredArg().defaultsTo((Object)String.valueOf(new StringBuilder("Player").append(Minecraft.getSystemTime() % 1000L)), (Object[])new String[0]);
        final ArgumentAcceptingOptionSpec lllllllllllllllllIlIIIIlllllIlll = lllllllllllllllllIlIIIlIIIIIIllI.accepts("uuid").withRequiredArg();
        final ArgumentAcceptingOptionSpec lllllllllllllllllIlIIIIlllllIllI = lllllllllllllllllIlIIIlIIIIIIllI.accepts("accessToken").withRequiredArg().required();
        final ArgumentAcceptingOptionSpec lllllllllllllllllIlIIIIlllllIlIl = lllllllllllllllllIlIIIlIIIIIIllI.accepts("version").withRequiredArg().required();
        final ArgumentAcceptingOptionSpec lllllllllllllllllIlIIIIlllllIIll = lllllllllllllllllIlIIIlIIIIIIllI.accepts("width").withRequiredArg().ofType((Class)Integer.class).defaultsTo((Object)854, (Object[])new Integer[0]);
        final ArgumentAcceptingOptionSpec lllllllllllllllllIlIIIIlllllIIlI = lllllllllllllllllIlIIIlIIIIIIllI.accepts("height").withRequiredArg().ofType((Class)Integer.class).defaultsTo((Object)480, (Object[])new Integer[0]);
        final ArgumentAcceptingOptionSpec lllllllllllllllllIlIIIIlllllIIIl = lllllllllllllllllIlIIIlIIIIIIllI.accepts("userProperties").withRequiredArg().required();
        final ArgumentAcceptingOptionSpec lllllllllllllllllIlIIIIllllIllll = lllllllllllllllllIlIIIlIIIIIIllI.accepts("assetIndex").withRequiredArg();
        final ArgumentAcceptingOptionSpec lllllllllllllllllIlIIIIllllIllIl = lllllllllllllllllIlIIIlIIIIIIllI.accepts("userType").withRequiredArg().defaultsTo((Object)"legacy", (Object[])new String[0]);
        final NonOptionArgumentSpec lllllllllllllllllIlIIIIllllIllII = lllllllllllllllllIlIIIlIIIIIIllI.nonOptions();
        final OptionSet lllllllllllllllllIlIIIIllllIlIll = lllllllllllllllllIlIIIlIIIIIIllI.parse(lllllllllllllllllIlIIIlIIIIIlIII);
        final List lllllllllllllllllIlIIIIllllIlIIl = lllllllllllllllllIlIIIIllllIlIll.valuesOf((OptionSpec)lllllllllllllllllIlIIIIllllIllII);
        if (!lllllllllllllllllIlIIIIllllIlIIl.isEmpty()) {
            System.out.println(String.valueOf(new StringBuilder("Completely ignored arguments: ").append(lllllllllllllllllIlIIIIllllIlIIl)));
        }
        final String lllllllllllllllllIlIIIIllllIIlll = (String)lllllllllllllllllIlIIIIllllIlIll.valueOf((OptionSpec)lllllllllllllllllIlIIIIlllllllIl);
        Proxy lllllllllllllllllIlIIIIllllIIllI = Proxy.NO_PROXY;
        if (lllllllllllllllllIlIIIIllllIIlll != null) {
            try {
                lllllllllllllllllIlIIIIllllIIllI = new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(lllllllllllllllllIlIIIIllllIIlll, (int)lllllllllllllllllIlIIIIllllIlIll.valueOf((OptionSpec)lllllllllllllllllIlIIIIlllllllII)));
            }
            catch (Exception ex) {}
        }
        final String lllllllllllllllllIlIIIIllllIIlIl = (String)lllllllllllllllllIlIIIIllllIlIll.valueOf((OptionSpec)lllllllllllllllllIlIIIIllllllIll);
        final String lllllllllllllllllIlIIIIllllIIlII = (String)lllllllllllllllllIlIIIIllllIlIll.valueOf((OptionSpec)lllllllllllllllllIlIIIIllllllIIl);
        if (!lllllllllllllllllIlIIIIllllIIllI.equals(Proxy.NO_PROXY) && func_110121_a(lllllllllllllllllIlIIIIllllIIlIl) && func_110121_a(lllllllllllllllllIlIIIIllllIIlII)) {
            Authenticator.setDefault(new Authenticator() {
                static {
                    __OBFID = "CL_00000828";
                }
                
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(lllllllllllllllllIlIIIIllllIIlIl, lllllllllllllllllIlIIIIllllIIlII.toCharArray());
                }
            });
        }
        final int lllllllllllllllllIlIIIIllllIIIll = (int)lllllllllllllllllIlIIIIllllIlIll.valueOf((OptionSpec)lllllllllllllllllIlIIIIlllllIIll);
        final int lllllllllllllllllIlIIIIllllIIIlI = (int)lllllllllllllllllIlIIIIllllIlIll.valueOf((OptionSpec)lllllllllllllllllIlIIIIlllllIIlI);
        final boolean lllllllllllllllllIlIIIIllllIIIIl = lllllllllllllllllIlIIIIllllIlIll.has("fullscreen");
        final boolean lllllllllllllllllIlIIIIllllIIIII = lllllllllllllllllIlIIIIllllIlIll.has("checkGlErrors");
        final boolean lllllllllllllllllIlIIIIlllIlllll = lllllllllllllllllIlIIIIllllIlIll.has("demo");
        final String lllllllllllllllllIlIIIIlllIllllI = (String)lllllllllllllllllIlIIIIllllIlIll.valueOf((OptionSpec)lllllllllllllllllIlIIIIlllllIlIl);
        final PropertyMap lllllllllllllllllIlIIIIlllIlllIl = (PropertyMap)new GsonBuilder().registerTypeAdapter((Type)PropertyMap.class, (Object)new PropertyMap.Serializer()).create().fromJson((String)lllllllllllllllllIlIIIIllllIlIll.valueOf((OptionSpec)lllllllllllllllllIlIIIIlllllIIIl), (Class)PropertyMap.class);
        final File lllllllllllllllllIlIIIIlllIlllII = (File)lllllllllllllllllIlIIIIllllIlIll.valueOf((OptionSpec)lllllllllllllllllIlIIIlIIIIIIIlI);
        final File lllllllllllllllllIlIIIIlllIllIll = (File)(lllllllllllllllllIlIIIIllllIlIll.has((OptionSpec)lllllllllllllllllIlIIIlIIIIIIIIl) ? lllllllllllllllllIlIIIIllllIlIll.valueOf((OptionSpec)lllllllllllllllllIlIIIlIIIIIIIIl) : new File(lllllllllllllllllIlIIIIlllIlllII, "assets/"));
        final File lllllllllllllllllIlIIIIlllIllIlI = (File)(lllllllllllllllllIlIIIIllllIlIll.has((OptionSpec)lllllllllllllllllIlIIIIlllllllll) ? lllllllllllllllllIlIIIIllllIlIll.valueOf((OptionSpec)lllllllllllllllllIlIIIIlllllllll) : new File(lllllllllllllllllIlIIIIlllIlllII, "resourcepacks/"));
        final String lllllllllllllllllIlIIIIlllIllIIl = (String)(lllllllllllllllllIlIIIIllllIlIll.has((OptionSpec)lllllllllllllllllIlIIIIlllllIlll) ? lllllllllllllllllIlIIIIlllllIlll.value(lllllllllllllllllIlIIIIllllIlIll) : ((String)lllllllllllllllllIlIIIIllllllIII.value(lllllllllllllllllIlIIIIllllIlIll)));
        final String lllllllllllllllllIlIIIIlllIllIII = lllllllllllllllllIlIIIIllllIlIll.has((OptionSpec)lllllllllllllllllIlIIIIllllIllll) ? ((String)lllllllllllllllllIlIIIIllllIllll.value(lllllllllllllllllIlIIIIllllIlIll)) : null;
        final String lllllllllllllllllIlIIIIlllIlIlll = (String)lllllllllllllllllIlIIIIllllIlIll.valueOf((OptionSpec)lllllllllllllllllIlIIIlIIIIIIlIl);
        final Integer lllllllllllllllllIlIIIIlllIlIllI = (Integer)lllllllllllllllllIlIIIIllllIlIll.valueOf((OptionSpec)lllllllllllllllllIlIIIlIIIIIIIll);
        final Session lllllllllllllllllIlIIIIlllIlIlIl = new Session((String)lllllllllllllllllIlIIIIllllllIII.value(lllllllllllllllllIlIIIIllllIlIll), lllllllllllllllllIlIIIIlllIllIIl, (String)lllllllllllllllllIlIIIIlllllIllI.value(lllllllllllllllllIlIIIIllllIlIll), (String)lllllllllllllllllIlIIIIllllIllIl.value(lllllllllllllllllIlIIIIllllIlIll));
        final GameConfiguration lllllllllllllllllIlIIIIlllIlIlII = new GameConfiguration(new GameConfiguration.UserInformation(lllllllllllllllllIlIIIIlllIlIlIl, lllllllllllllllllIlIIIIlllIlllIl, lllllllllllllllllIlIIIIllllIIllI), new GameConfiguration.DisplayInformation(lllllllllllllllllIlIIIIllllIIIll, lllllllllllllllllIlIIIIllllIIIlI, lllllllllllllllllIlIIIIllllIIIIl, lllllllllllllllllIlIIIIllllIIIII), new GameConfiguration.FolderInformation(lllllllllllllllllIlIIIIlllIlllII, lllllllllllllllllIlIIIIlllIllIlI, lllllllllllllllllIlIIIIlllIllIll, lllllllllllllllllIlIIIIlllIllIII), new GameConfiguration.GameInformation(lllllllllllllllllIlIIIIlllIlllll, lllllllllllllllllIlIIIIlllIllllI), new GameConfiguration.ServerInformation(lllllllllllllllllIlIIIIlllIlIlll, lllllllllllllllllIlIIIIlllIlIllI));
        Runtime.getRuntime().addShutdownHook(new Thread("Client Shutdown Thread") {
            static {
                __OBFID = "CL_00000829";
            }
            
            @Override
            public void run() {
                Minecraft.stopIntegratedServer();
            }
        });
        Thread.currentThread().setName("Client thread");
        new Minecraft(lllllllllllllllllIlIIIIlllIlIlII).run();
    }
}
