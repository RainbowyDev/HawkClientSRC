package hawk;

import hawk.modules.combat.*;
import hawk.ui.*;
import hawk.modules.player.*;
import java.util.concurrent.*;
import hawk.modules.*;
import hawk.modules.render.*;
import hawk.events.*;
import hawk.events.listeners.*;
import java.util.*;

public class Client
{
    public static /* synthetic */ String NameInConsole;
    public static /* synthetic */ boolean IsRegistered;
    public static /* synthetic */ String name;
    public static /* synthetic */ String mcversion;
    public static /* synthetic */ HUD hud;
    public static /* synthetic */ String version;
    public static /* synthetic */ CopyOnWriteArrayList<Module> modules;
    
    public static void startup() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: new             Ljava/lang/StringBuilder;
        //     6: dup            
        //     7: getstatic       hawk/Client.NameInConsole:Ljava/lang/String;
        //    10: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    13: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    16: ldc             "Starting Hawk Client - Minecraft 1.8"
        //    18: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    21: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    24: invokevirtual   java/io/PrintStream.println:(Ljava/lang/String;)V
        //    27: new             Ljava/lang/StringBuilder;
        //    30: dup            
        //    31: getstatic       hawk/Client.name:Ljava/lang/String;
        //    34: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    37: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    40: ldc             " "
        //    42: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    45: getstatic       hawk/Client.version:Ljava/lang/String;
        //    48: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    51: ldc             " - "
        //    53: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    56: getstatic       hawk/Client.mcversion:Ljava/lang/String;
        //    59: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    62: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    65: invokestatic    org/lwjgl/opengl/Display.setTitle:(Ljava/lang/String;)V
        //    68: new             Ljava/io/BufferedReader;
        //    71: dup            
        //    72: new             Ljava/io/FileReader;
        //    75: dup            
        //    76: ldc             "gie5hg8u4toihu45.hawkclient"
        //    78: invokespecial   java/io/FileReader.<init>:(Ljava/lang/String;)V
        //    81: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;)V
        //    84: astore_1        /* llllllllllllllIIIlIlllIIllIlIlII */
        //    85: goto            162
        //    88: aload_0         /* llllllllllllllIIIlIlllIIllIlIllI */
        //    89: getstatic       hawk/access/DisplayOnScreen.CorrectKey:Ljava/lang/String;
        //    92: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    95: ifeq            162
        //    98: iconst_1       
        //    99: putstatic       hawk/Client.IsRegistered:Z
        //   102: getstatic       java/lang/System.out:Ljava/io/PrintStream;
        //   105: new             Ljava/lang/StringBuilder;
        //   108: dup            
        //   109: getstatic       hawk/Client.NameInConsole:Ljava/lang/String;
        //   112: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   115: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   118: ldc             "Private version loaded"
        //   120: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   123: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   126: invokevirtual   java/io/PrintStream.println:(Ljava/lang/String;)V
        //   129: getstatic       java/lang/System.out:Ljava/io/PrintStream;
        //   132: new             Ljava/lang/StringBuilder;
        //   135: dup            
        //   136: getstatic       hawk/Client.NameInConsole:Ljava/lang/String;
        //   139: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   142: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   145: ldc             "Key : "
        //   147: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   150: getstatic       hawk/access/DisplayOnScreen.CorrectKey:Ljava/lang/String;
        //   153: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   156: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   159: invokevirtual   java/io/PrintStream.println:(Ljava/lang/String;)V
        //   162: aload_1         /* llllllllllllllIIIlIlllIIllIlIlII */
        //   163: invokevirtual   java/io/BufferedReader.readLine:()Ljava/lang/String;
        //   166: dup            
        //   167: astore_0        /* llllllllllllllIIIlIlllIIllIlIlIl */
        //   168: ifnonnull       88
        //   171: aload_1         /* llllllllllllllIIIlIlllIIllIlIlII */
        //   172: invokevirtual   java/io/BufferedReader.close:()V
        //   175: goto            206
        //   178: astore_1        /* llllllllllllllIIIlIlllIIllIlIIll */
        //   179: getstatic       java/lang/System.out:Ljava/io/PrintStream;
        //   182: new             Ljava/lang/StringBuilder;
        //   185: dup            
        //   186: getstatic       hawk/Client.NameInConsole:Ljava/lang/String;
        //   189: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   192: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   195: ldc             "Normal version loaded"
        //   197: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   200: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   203: invokevirtual   java/io/PrintStream.println:(Ljava/lang/String;)V
        //   206: getstatic       hawk/Client.modules:Ljava/util/concurrent/CopyOnWriteArrayList;
        //   209: new             Lhawk/modules/movement/Sprint;
        //   212: dup            
        //   213: invokespecial   hawk/modules/movement/Sprint.<init>:()V
        //   216: invokevirtual   java/util/concurrent/CopyOnWriteArrayList.add:(Ljava/lang/Object;)Z
        //   219: pop            
        //   220: getstatic       hawk/Client.modules:Ljava/util/concurrent/CopyOnWriteArrayList;
        //   223: new             Lhawk/modules/render/Fullbright;
        //   226: dup            
        //   227: invokespecial   hawk/modules/render/Fullbright.<init>:()V
        //   230: invokevirtual   java/util/concurrent/CopyOnWriteArrayList.add:(Ljava/lang/Object;)Z
        //   233: pop            
        //   234: getstatic       hawk/Client.modules:Ljava/util/concurrent/CopyOnWriteArrayList;
        //   237: new             Lhawk/modules/movement/Fly;
        //   240: dup            
        //   241: invokespecial   hawk/modules/movement/Fly.<init>:()V
        //   244: invokevirtual   java/util/concurrent/CopyOnWriteArrayList.add:(Ljava/lang/Object;)Z
        //   247: pop            
        //   248: getstatic       hawk/Client.modules:Ljava/util/concurrent/CopyOnWriteArrayList;
        //   251: new             Lhawk/modules/player/Nofall;
        //   254: dup            
        //   255: invokespecial   hawk/modules/player/Nofall.<init>:()V
        //   258: invokevirtual   java/util/concurrent/CopyOnWriteArrayList.add:(Ljava/lang/Object;)Z
        //   261: pop            
        //   262: getstatic       hawk/Client.modules:Ljava/util/concurrent/CopyOnWriteArrayList;
        //   265: new             Lhawk/modules/movement/Speed;
        //   268: dup            
        //   269: invokespecial   hawk/modules/movement/Speed.<init>:()V
        //   272: invokevirtual   java/util/concurrent/CopyOnWriteArrayList.add:(Ljava/lang/Object;)Z
        //   275: pop            
        //   276: getstatic       hawk/Client.modules:Ljava/util/concurrent/CopyOnWriteArrayList;
        //   279: new             Lhawk/modules/combat/Killaura;
        //   282: dup            
        //   283: invokespecial   hawk/modules/combat/Killaura.<init>:()V
        //   286: dup            
        //   287: putstatic       hawk/Client.killAura:Lhawk/modules/combat/Killaura;
        //   290: invokevirtual   java/util/concurrent/CopyOnWriteArrayList.add:(Ljava/lang/Object;)Z
        //   293: pop            
        //   294: getstatic       hawk/Client.modules:Ljava/util/concurrent/CopyOnWriteArrayList;
        //   297: new             Lhawk/modules/player/Fastplace;
        //   300: dup            
        //   301: invokespecial   hawk/modules/player/Fastplace.<init>:()V
        //   304: invokevirtual   java/util/concurrent/CopyOnWriteArrayList.add:(Ljava/lang/Object;)Z
        //   307: pop            
        //   308: getstatic       hawk/Client.modules:Ljava/util/concurrent/CopyOnWriteArrayList;
        //   311: new             Lhawk/modules/movement/Airjump;
        //   314: dup            
        //   315: invokespecial   hawk/modules/movement/Airjump.<init>:()V
        //   318: invokevirtual   java/util/concurrent/CopyOnWriteArrayList.add:(Ljava/lang/Object;)Z
        //   321: pop            
        //   322: getstatic       hawk/Client.modules:Ljava/util/concurrent/CopyOnWriteArrayList;
        //   325: new             Lhawk/modules/player/Timer;
        //   328: dup            
        //   329: invokespecial   hawk/modules/player/Timer.<init>:()V
        //   332: invokevirtual   java/util/concurrent/CopyOnWriteArrayList.add:(Ljava/lang/Object;)Z
        //   335: pop            
        //   336: getstatic       hawk/Client.modules:Ljava/util/concurrent/CopyOnWriteArrayList;
        //   339: new             Lhawk/modules/combat/Antikb;
        //   342: dup            
        //   343: invokespecial   hawk/modules/combat/Antikb.<init>:()V
        //   346: invokevirtual   java/util/concurrent/CopyOnWriteArrayList.add:(Ljava/lang/Object;)Z
        //   349: pop            
        //   350: getstatic       hawk/Client.modules:Ljava/util/concurrent/CopyOnWriteArrayList;
        //   353: new             Lhawk/modules/render/TabGUI;
        //   356: dup            
        //   357: invokespecial   hawk/modules/render/TabGUI.<init>:()V
        //   360: invokevirtual   java/util/concurrent/CopyOnWriteArrayList.add:(Ljava/lang/Object;)Z
        //   363: pop            
        //   364: getstatic       hawk/Client.modules:Ljava/util/concurrent/CopyOnWriteArrayList;
        //   367: new             Lhawk/modules/combat/Aimbot;
        //   370: dup            
        //   371: invokespecial   hawk/modules/combat/Aimbot.<init>:()V
        //   374: invokevirtual   java/util/concurrent/CopyOnWriteArrayList.add:(Ljava/lang/Object;)Z
        //   377: pop            
        //   378: getstatic       hawk/Client.modules:Ljava/util/concurrent/CopyOnWriteArrayList;
        //   381: new             Lhawk/modules/player/Cheststealer;
        //   384: dup            
        //   385: invokespecial   hawk/modules/player/Cheststealer.<init>:()V
        //   388: invokevirtual   java/util/concurrent/CopyOnWriteArrayList.add:(Ljava/lang/Object;)Z
        //   391: pop            
        //   392: getstatic       hawk/Client.modules:Ljava/util/concurrent/CopyOnWriteArrayList;
        //   395: new             Lhawk/modules/player/FastEat;
        //   398: dup            
        //   399: invokespecial   hawk/modules/player/FastEat.<init>:()V
        //   402: invokevirtual   java/util/concurrent/CopyOnWriteArrayList.add:(Ljava/lang/Object;)Z
        //   405: pop            
        //   406: getstatic       hawk/Client.modules:Ljava/util/concurrent/CopyOnWriteArrayList;
        //   409: new             Lhawk/modules/movement/Noslow;
        //   412: dup            
        //   413: invokespecial   hawk/modules/movement/Noslow.<init>:()V
        //   416: invokevirtual   java/util/concurrent/CopyOnWriteArrayList.add:(Ljava/lang/Object;)Z
        //   419: pop            
        //   420: getstatic       hawk/Client.modules:Ljava/util/concurrent/CopyOnWriteArrayList;
        //   423: new             Lhawk/modules/render/BlockAnimation;
        //   426: dup            
        //   427: invokespecial   hawk/modules/render/BlockAnimation.<init>:()V
        //   430: dup            
        //   431: putstatic       hawk/Client.animations:Lhawk/modules/render/BlockAnimation;
        //   434: invokevirtual   java/util/concurrent/CopyOnWriteArrayList.add:(Ljava/lang/Object;)Z
        //   437: pop            
        //   438: getstatic       hawk/Client.modules:Ljava/util/concurrent/CopyOnWriteArrayList;
        //   441: new             Lhawk/modules/render/ModulesListOptions;
        //   444: dup            
        //   445: invokespecial   hawk/modules/render/ModulesListOptions.<init>:()V
        //   448: dup            
        //   449: putstatic       hawk/Client.arraylist:Lhawk/modules/render/ModulesListOptions;
        //   452: invokevirtual   java/util/concurrent/CopyOnWriteArrayList.add:(Ljava/lang/Object;)Z
        //   455: pop            
        //   456: getstatic       hawk/Client.modules:Ljava/util/concurrent/CopyOnWriteArrayList;
        //   459: new             Lhawk/modules/player/Autoarmor;
        //   462: dup            
        //   463: invokespecial   hawk/modules/player/Autoarmor.<init>:()V
        //   466: invokevirtual   java/util/concurrent/CopyOnWriteArrayList.add:(Ljava/lang/Object;)Z
        //   469: pop            
        //   470: getstatic       hawk/Client.modules:Ljava/util/concurrent/CopyOnWriteArrayList;
        //   473: new             Lhawk/modules/combat/Antibot;
        //   476: dup            
        //   477: invokespecial   hawk/modules/combat/Antibot.<init>:()V
        //   480: invokevirtual   java/util/concurrent/CopyOnWriteArrayList.add:(Ljava/lang/Object;)Z
        //   483: pop            
        //   484: getstatic       hawk/Client.modules:Ljava/util/concurrent/CopyOnWriteArrayList;
        //   487: new             Lhawk/modules/movement/Invmove;
        //   490: dup            
        //   491: invokespecial   hawk/modules/movement/Invmove.<init>:()V
        //   494: invokevirtual   java/util/concurrent/CopyOnWriteArrayList.add:(Ljava/lang/Object;)Z
        //   497: pop            
        //   498: getstatic       hawk/Client.modules:Ljava/util/concurrent/CopyOnWriteArrayList;
        //   501: new             Lhawk/modules/player/AutoSetting;
        //   504: dup            
        //   505: invokespecial   hawk/modules/player/AutoSetting.<init>:()V
        //   508: invokevirtual   java/util/concurrent/CopyOnWriteArrayList.add:(Ljava/lang/Object;)Z
        //   511: pop            
        //   512: getstatic       hawk/Client.modules:Ljava/util/concurrent/CopyOnWriteArrayList;
        //   515: new             Lhawk/modules/movement/Longjump;
        //   518: dup            
        //   519: invokespecial   hawk/modules/movement/Longjump.<init>:()V
        //   522: invokevirtual   java/util/concurrent/CopyOnWriteArrayList.add:(Ljava/lang/Object;)Z
        //   525: pop            
        //   526: getstatic       hawk/Client.modules:Ljava/util/concurrent/CopyOnWriteArrayList;
        //   529: new             Lhawk/modules/player/Phase;
        //   532: dup            
        //   533: invokespecial   hawk/modules/player/Phase.<init>:()V
        //   536: invokevirtual   java/util/concurrent/CopyOnWriteArrayList.add:(Ljava/lang/Object;)Z
        //   539: pop            
        //   540: getstatic       hawk/Client.modules:Ljava/util/concurrent/CopyOnWriteArrayList;
        //   543: new             Lhawk/modules/render/ESP;
        //   546: dup            
        //   547: invokespecial   hawk/modules/render/ESP.<init>:()V
        //   550: invokevirtual   java/util/concurrent/CopyOnWriteArrayList.add:(Ljava/lang/Object;)Z
        //   553: pop            
        //   554: getstatic       hawk/Client.modules:Ljava/util/concurrent/CopyOnWriteArrayList;
        //   557: new             Lhawk/modules/combat/Criticals;
        //   560: dup            
        //   561: invokespecial   hawk/modules/combat/Criticals.<init>:()V
        //   564: invokevirtual   java/util/concurrent/CopyOnWriteArrayList.add:(Ljava/lang/Object;)Z
        //   567: pop            
        //   568: getstatic       hawk/Client.modules:Ljava/util/concurrent/CopyOnWriteArrayList;
        //   571: new             Lhawk/modules/player/ScaffoldHopeItWorks;
        //   574: dup            
        //   575: invokespecial   hawk/modules/player/ScaffoldHopeItWorks.<init>:()V
        //   578: dup            
        //   579: putstatic       hawk/Client.scaffold:Lhawk/modules/player/ScaffoldHopeItWorks;
        //   582: invokevirtual   java/util/concurrent/CopyOnWriteArrayList.add:(Ljava/lang/Object;)Z
        //   585: pop            
        //   586: getstatic       hawk/Client.modules:Ljava/util/concurrent/CopyOnWriteArrayList;
        //   589: new             Lhawk/modules/movement/Safewalk;
        //   592: dup            
        //   593: invokespecial   hawk/modules/movement/Safewalk.<init>:()V
        //   596: invokevirtual   java/util/concurrent/CopyOnWriteArrayList.add:(Ljava/lang/Object;)Z
        //   599: pop            
        //   600: getstatic       hawk/Client.modules:Ljava/util/concurrent/CopyOnWriteArrayList;
        //   603: new             Lhawk/modules/render/ModToggleGUI;
        //   606: dup            
        //   607: invokespecial   hawk/modules/render/ModToggleGUI.<init>:()V
        //   610: invokevirtual   java/util/concurrent/CopyOnWriteArrayList.add:(Ljava/lang/Object;)Z
        //   613: pop            
        //   614: getstatic       hawk/Client.modules:Ljava/util/concurrent/CopyOnWriteArrayList;
        //   617: new             Lhawk/modules/render/HeadRotations;
        //   620: dup            
        //   621: invokespecial   hawk/modules/render/HeadRotations.<init>:()V
        //   624: invokevirtual   java/util/concurrent/CopyOnWriteArrayList.add:(Ljava/lang/Object;)Z
        //   627: pop            
        //   628: getstatic       hawk/Client.modules:Ljava/util/concurrent/CopyOnWriteArrayList;
        //   631: new             Lhawk/modules/render/Nametags;
        //   634: dup            
        //   635: invokespecial   hawk/modules/render/Nametags.<init>:()V
        //   638: invokevirtual   java/util/concurrent/CopyOnWriteArrayList.add:(Ljava/lang/Object;)Z
        //   641: pop            
        //   642: getstatic       hawk/Client.modules:Ljava/util/concurrent/CopyOnWriteArrayList;
        //   645: new             Lhawk/modules/movement/RedeFly;
        //   648: dup            
        //   649: invokespecial   hawk/modules/movement/RedeFly.<init>:()V
        //   652: invokevirtual   java/util/concurrent/CopyOnWriteArrayList.add:(Ljava/lang/Object;)Z
        //   655: pop            
        //   656: getstatic       hawk/Client.modules:Ljava/util/concurrent/CopyOnWriteArrayList;
        //   659: new             Lhawk/modules/player/Bednuker;
        //   662: dup            
        //   663: invokespecial   hawk/modules/player/Bednuker.<init>:()V
        //   666: invokevirtual   java/util/concurrent/CopyOnWriteArrayList.add:(Ljava/lang/Object;)Z
        //   669: pop            
        //   670: getstatic       hawk/Client.modules:Ljava/util/concurrent/CopyOnWriteArrayList;
        //   673: new             Lhawk/modules/combat/TPAura;
        //   676: dup            
        //   677: invokespecial   hawk/modules/combat/TPAura.<init>:()V
        //   680: invokevirtual   java/util/concurrent/CopyOnWriteArrayList.add:(Ljava/lang/Object;)Z
        //   683: pop            
        //   684: getstatic       hawk/Client.modules:Ljava/util/concurrent/CopyOnWriteArrayList;
        //   687: new             Lhawk/modules/player/Disabler;
        //   690: dup            
        //   691: invokespecial   hawk/modules/player/Disabler.<init>:()V
        //   694: invokevirtual   java/util/concurrent/CopyOnWriteArrayList.add:(Ljava/lang/Object;)Z
        //   697: pop            
        //   698: getstatic       hawk/Client.modules:Ljava/util/concurrent/CopyOnWriteArrayList;
        //   701: new             Lhawk/modules/player/Spammer;
        //   704: dup            
        //   705: invokespecial   hawk/modules/player/Spammer.<init>:()V
        //   708: invokevirtual   java/util/concurrent/CopyOnWriteArrayList.add:(Ljava/lang/Object;)Z
        //   711: pop            
        //   712: new             Ljava/lang/Thread;
        //   715: dup            
        //   716: invokedynamic   BootstrapMethod #0, run:()Ljava/lang/Runnable;
        //   721: invokespecial   java/lang/Thread.<init>:(Ljava/lang/Runnable;)V
        //   724: astore_1        /* llllllllllllllIIIlIlllIIllIlIIlI */
        //   725: aload_1         /* llllllllllllllIIIlIlllIIllIlIIlI */
        //   726: iconst_1       
        //   727: invokevirtual   java/lang/Thread.setDaemon:(Z)V
        //   730: aload_1         /* llllllllllllllIIIlIlllIIllIlIIlI */
        //   731: invokevirtual   java/lang/Thread.start:()V
        //   734: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  68     175    178    206    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static void onEvent(final Event llllllllllllllIIIlIlllIIllIIlIlI) {
        for (final Module llllllllllllllIIIlIlllIIllIIlIll : Client.modules) {
            if (!llllllllllllllIIIlIlllIIllIIlIll.toggled) {
                continue;
            }
            llllllllllllllIIIlIlllIIllIIlIll.onEvent(llllllllllllllIIIlIlllIIllIIlIlI);
        }
    }
    
    public static void shutdown() {
    }
    
    public static Module getModule(final String llllllllllllllIIIlIlllIIlIlllIlI) {
        for (final Module llllllllllllllIIIlIlllIIlIlllIll : Client.modules) {
            if (llllllllllllllIIIlIlllIIlIlllIll.name.equalsIgnoreCase(llllllllllllllIIIlIlllIIlIlllIlI)) {
                return llllllllllllllIIIlIlllIIlIlllIll;
            }
        }
        return null;
    }
    
    public static void keyPress(final int llllllllllllllIIIlIlllIIllIIIIlI) {
        onEvent(new EventKey(llllllllllllllIIIlIlllIIllIIIIlI));
        for (final Module llllllllllllllIIIlIlllIIllIIIIll : Client.modules) {
            if (llllllllllllllIIIlIlllIIllIIIIll.getKey() == llllllllllllllIIIlIlllIIllIIIIlI) {
                llllllllllllllIIIlIlllIIllIIIIll.toggle();
            }
        }
    }
    
    static {
        Client.name = "Hawk";
        Client.version = "beta 1.5";
        Client.mcversion = "Minecraft 1.8";
        Client.NameInConsole = "[Hawk Client] ";
        Client.modules = new CopyOnWriteArrayList<Module>();
        Client.hud = new HUD();
        Client.IsRegistered = false;
    }
    
    public static List<Module> getModulesByCategory(final Module.Category llllllllllllllIIIlIlllIIlIllIIll) {
        final List<Module> llllllllllllllIIIlIlllIIlIllIIlI = new ArrayList<Module>();
        for (final Module llllllllllllllIIIlIlllIIlIllIIIl : Client.modules) {
            if (llllllllllllllIIIlIlllIIlIllIIIl.category == llllllllllllllIIIlIlllIIlIllIIll) {
                llllllllllllllIIIlIlllIIlIllIIlI.add(llllllllllllllIIIlIlllIIlIllIIIl);
            }
        }
        return llllllllllllllIIIlIlllIIlIllIIlI;
    }
}
