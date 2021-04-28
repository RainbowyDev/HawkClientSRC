package net.minecraft.profiler;

import com.google.common.collect.*;
import java.net.*;
import java.lang.management.*;
import java.util.*;

public class PlayerUsageSnooper
{
    private final /* synthetic */ Map field_152774_b;
    private final /* synthetic */ Map field_152773_a;
    private /* synthetic */ int selfCounter;
    private final /* synthetic */ long minecraftStartTimeMilis;
    private /* synthetic */ boolean isRunning;
    private final /* synthetic */ String uniqueID;
    private final /* synthetic */ Object syncLock;
    private final /* synthetic */ URL serverUrl;
    private final /* synthetic */ IPlayerUsage playerStatsCollector;
    private final /* synthetic */ Timer threadTrigger;
    
    static {
        __OBFID = "CL_00001515";
    }
    
    public void startSnooper() {
        if (!this.isRunning) {
            this.isRunning = true;
            this.func_152766_h();
            this.threadTrigger.schedule(new TimerTask() {
                static {
                    __OBFID = "CL_00001516";
                }
                
                @Override
                public void run() {
                    // 
                    // This method could not be decompiled.
                    // 
                    // Original Bytecode:
                    // 
                    //     1: getfield        net/minecraft/profiler/PlayerUsageSnooper$1.this$0:Lnet/minecraft/profiler/PlayerUsageSnooper;
                    //     4: invokestatic    net/minecraft/profiler/PlayerUsageSnooper.access$0:(Lnet/minecraft/profiler/PlayerUsageSnooper;)Lnet/minecraft/profiler/IPlayerUsage;
                    //     7: invokeinterface net/minecraft/profiler/IPlayerUsage.isSnooperEnabled:()Z
                    //    12: ifeq            109
                    //    15: aload_0         /* lIlllIIlIlIllI */
                    //    16: getfield        net/minecraft/profiler/PlayerUsageSnooper$1.this$0:Lnet/minecraft/profiler/PlayerUsageSnooper;
                    //    19: invokestatic    net/minecraft/profiler/PlayerUsageSnooper.access$1:(Lnet/minecraft/profiler/PlayerUsageSnooper;)Ljava/lang/Object;
                    //    22: dup            
                    //    23: astore_2        /* lIlllIIlIlIlII */
                    //    24: monitorenter   
                    //    25: aload_0         /* lIlllIIlIlIllI */
                    //    26: getfield        net/minecraft/profiler/PlayerUsageSnooper$1.this$0:Lnet/minecraft/profiler/PlayerUsageSnooper;
                    //    29: invokestatic    net/minecraft/profiler/PlayerUsageSnooper.access$2:(Lnet/minecraft/profiler/PlayerUsageSnooper;)Ljava/util/Map;
                    //    32: invokestatic    com/google/common/collect/Maps.newHashMap:(Ljava/util/Map;)Ljava/util/HashMap;
                    //    35: astore_1        /* lIlllIIlIlIlIl */
                    //    36: aload_0         /* lIlllIIlIlIllI */
                    //    37: getfield        net/minecraft/profiler/PlayerUsageSnooper$1.this$0:Lnet/minecraft/profiler/PlayerUsageSnooper;
                    //    40: invokestatic    net/minecraft/profiler/PlayerUsageSnooper.access$3:(Lnet/minecraft/profiler/PlayerUsageSnooper;)I
                    //    43: ifne            57
                    //    46: aload_1         /* lIlllIIlIllIII */
                    //    47: aload_0         /* lIlllIIlIlIllI */
                    //    48: getfield        net/minecraft/profiler/PlayerUsageSnooper$1.this$0:Lnet/minecraft/profiler/PlayerUsageSnooper;
                    //    51: invokestatic    net/minecraft/profiler/PlayerUsageSnooper.access$4:(Lnet/minecraft/profiler/PlayerUsageSnooper;)Ljava/util/Map;
                    //    54: invokevirtual   java/util/HashMap.putAll:(Ljava/util/Map;)V
                    //    57: aload_1         /* lIlllIIlIllIII */
                    //    58: ldc             "snooper_count"
                    //    60: aload_0         /* lIlllIIlIlIllI */
                    //    61: getfield        net/minecraft/profiler/PlayerUsageSnooper$1.this$0:Lnet/minecraft/profiler/PlayerUsageSnooper;
                    //    64: invokestatic    net/minecraft/profiler/PlayerUsageSnooper.access$308:(Lnet/minecraft/profiler/PlayerUsageSnooper;)I
                    //    67: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
                    //    70: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //    73: pop            
                    //    74: aload_1         /* lIlllIIlIllIII */
                    //    75: ldc             "snooper_token"
                    //    77: aload_0         /* lIlllIIlIlIllI */
                    //    78: getfield        net/minecraft/profiler/PlayerUsageSnooper$1.this$0:Lnet/minecraft/profiler/PlayerUsageSnooper;
                    //    81: invokestatic    net/minecraft/profiler/PlayerUsageSnooper.access$5:(Lnet/minecraft/profiler/PlayerUsageSnooper;)Ljava/lang/String;
                    //    84: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //    87: pop            
                    //    88: aload_2         /* lIlllIIlIlIlII */
                    //    89: monitorexit    
                    //    90: goto            96
                    //    93: aload_2         /* lIlllIIlIlIlII */
                    //    94: monitorexit    
                    //    95: athrow         
                    //    96: aload_0         /* lIlllIIlIlIllI */
                    //    97: getfield        net/minecraft/profiler/PlayerUsageSnooper$1.this$0:Lnet/minecraft/profiler/PlayerUsageSnooper;
                    //   100: invokestatic    net/minecraft/profiler/PlayerUsageSnooper.access$6:(Lnet/minecraft/profiler/PlayerUsageSnooper;)Ljava/net/URL;
                    //   103: aload_1         /* lIlllIIlIlIlll */
                    //   104: iconst_1       
                    //   105: invokestatic    net/minecraft/util/HttpUtil.postMap:(Ljava/net/URL;Ljava/util/Map;Z)Ljava/lang/String;
                    //   108: pop            
                    //   109: return         
                    //    StackMapTable: 00 04 FD 00 39 07 00 3F 07 00 6E FF 00 23 00 03 07 00 02 00 07 00 6E 00 01 07 00 70 FF 00 02 00 03 07 00 02 07 00 3F 07 00 6E 00 00 F9 00 0C
                    //    Exceptions:
                    //  Try           Handler
                    //  Start  End    Start  End    Type
                    //  -----  -----  -----  -----  ----
                    //  25     90     93     96     Any
                    //  93     95     93     96     Any
                    // 
                    // The error that occurred was:
                    // 
                    // java.lang.NullPointerException
                    //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2895)
                    //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
                    //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformCall(AstMethodBodyBuilder.java:1164)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:1009)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:554)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:392)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:440)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:294)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
                    //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
                    //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
                    //     at us.deathmarine.luyten.FileSaver.doSaveJarDecompiled(FileSaver.java:192)
                    //     at us.deathmarine.luyten.FileSaver.access$300(FileSaver.java:45)
                    //     at us.deathmarine.luyten.FileSaver$4.run(FileSaver.java:112)
                    //     at java.lang.Thread.run(Unknown Source)
                    // 
                    throw new IllegalStateException("An error occurred while decompiling this method.");
                }
            }, 0L, 900000L);
        }
    }
    
    public long getMinecraftStartTimeMillis() {
        return this.minecraftStartTimeMilis;
    }
    
    public boolean isSnooperRunning() {
        return this.isRunning;
    }
    
    public void addClientStat(final String lllllllllllllllIIIllIIIIIIIIIllI, final Object lllllllllllllllIIIllIIIIIIIIIlIl) {
        final Object lllllllllllllllIIIllIIIIIIIIIlII = this.syncLock;
        synchronized (this.syncLock) {
            this.field_152774_b.put(lllllllllllllllIIIllIIIIIIIIIllI, lllllllllllllllIIIllIIIIIIIIIlIl);
        }
        // monitorexit(this.syncLock)
    }
    
    static int access$308(final PlayerUsageSnooper lllllllllllllllIIIlIllllllIlIIIl) {
        return lllllllllllllllIIIlIllllllIlIIIl.selfCounter++;
    }
    
    public PlayerUsageSnooper(final String lllllllllllllllIIIllIIIIIIllIIII, final IPlayerUsage lllllllllllllllIIIllIIIIIIlIlIlI, final long lllllllllllllllIIIllIIIIIIlIlIIl) {
        this.field_152773_a = Maps.newHashMap();
        this.field_152774_b = Maps.newHashMap();
        this.uniqueID = UUID.randomUUID().toString();
        this.threadTrigger = new Timer("Snooper Timer", true);
        this.syncLock = new Object();
        try {
            this.serverUrl = new URL(String.valueOf(new StringBuilder("http://snoop.minecraft.net/").append(lllllllllllllllIIIllIIIIIIllIIII).append("?version=").append(2)));
        }
        catch (MalformedURLException lllllllllllllllIIIllIIIIIIlIllIl) {
            throw new IllegalArgumentException();
        }
        this.playerStatsCollector = lllllllllllllllIIIllIIIIIIlIlIlI;
        this.minecraftStartTimeMilis = lllllllllllllllIIIllIIIIIIlIlIIl;
    }
    
    public void addStatToSnooper(final String lllllllllllllllIIIlIllllllllIlII, final Object lllllllllllllllIIIlIllllllllIlll) {
        final Object lllllllllllllllIIIlIllllllllIllI = this.syncLock;
        synchronized (this.syncLock) {
            this.field_152773_a.put(lllllllllllllllIIIlIllllllllIlII, lllllllllllllllIIIlIllllllllIlll);
        }
        // monitorexit(this.syncLock)
    }
    
    public void stopSnooper() {
        this.threadTrigger.cancel();
    }
    
    public String getUniqueID() {
        return this.uniqueID;
    }
    
    public Map getCurrentStats() {
        final LinkedHashMap lllllllllllllllIIIlIlllllllIlIIl = Maps.newLinkedHashMap();
        final Object lllllllllllllllIIIlIlllllllIlIII = this.syncLock;
        synchronized (this.syncLock) {
            this.addMemoryStatsToSnooper();
            for (final Map.Entry lllllllllllllllIIIlIlllllllIIllI : this.field_152773_a.entrySet()) {
                lllllllllllllllIIIlIlllllllIlIIl.put(lllllllllllllllIIIlIlllllllIIllI.getKey(), lllllllllllllllIIIlIlllllllIIllI.getValue().toString());
            }
            for (final Map.Entry lllllllllllllllIIIlIlllllllIIlIl : this.field_152774_b.entrySet()) {
                lllllllllllllllIIIlIlllllllIlIIl.put(lllllllllllllllIIIlIlllllllIIlIl.getKey(), lllllllllllllllIIIlIlllllllIIlIl.getValue().toString());
            }
            // monitorexit(this.syncLock)
            return lllllllllllllllIIIlIlllllllIlIIl;
        }
    }
    
    public void addMemoryStatsToSnooper() {
        this.addStatToSnooper("memory_total", Runtime.getRuntime().totalMemory());
        this.addStatToSnooper("memory_max", Runtime.getRuntime().maxMemory());
        this.addStatToSnooper("memory_free", Runtime.getRuntime().freeMemory());
        this.addStatToSnooper("cpu_cores", Runtime.getRuntime().availableProcessors());
        this.playerStatsCollector.addServerStatsToSnooper(this);
    }
    
    private void func_152766_h() {
        this.addJvmArgsToSnooper();
        this.addClientStat("snooper_token", this.uniqueID);
        this.addStatToSnooper("snooper_token", this.uniqueID);
        this.addStatToSnooper("os_name", System.getProperty("os.name"));
        this.addStatToSnooper("os_version", System.getProperty("os.version"));
        this.addStatToSnooper("os_architecture", System.getProperty("os.arch"));
        this.addStatToSnooper("java_version", System.getProperty("java.version"));
        this.addStatToSnooper("version", "1.8");
        this.playerStatsCollector.addServerTypeToSnooper(this);
    }
    
    private void addJvmArgsToSnooper() {
        final RuntimeMXBean lllllllllllllllIIIllIIIIIIIllIlI = ManagementFactory.getRuntimeMXBean();
        final List lllllllllllllllIIIllIIIIIIIllIIl = lllllllllllllllIIIllIIIIIIIllIlI.getInputArguments();
        int lllllllllllllllIIIllIIIIIIIllIII = 0;
        for (final String lllllllllllllllIIIllIIIIIIIlIllI : lllllllllllllllIIIllIIIIIIIllIIl) {
            if (lllllllllllllllIIIllIIIIIIIlIllI.startsWith("-X")) {
                this.addClientStat(String.valueOf(new StringBuilder("jvm_arg[").append(lllllllllllllllIIIllIIIIIIIllIII++).append("]")), lllllllllllllllIIIllIIIIIIIlIllI);
            }
        }
        this.addClientStat("jvm_args", lllllllllllllllIIIllIIIIIIIllIII);
    }
}
