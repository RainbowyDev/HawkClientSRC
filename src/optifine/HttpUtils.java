package optifine;

import java.util.*;
import java.net.*;
import net.minecraft.client.*;
import java.io.*;

public class HttpUtils
{
    public static String post(final String lllllllllllllllllIIIIIIIllllIIll, final Map lllllllllllllllllIIIIIIlIIIIIIll, final byte[] lllllllllllllllllIIIIIIIllllIIIl) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_3        /* lllllllllllllllllIIIIIIIllllIIII */
        //     2: new             Ljava/net/URL;
        //     5: dup            
        //     6: aload_0         /* lllllllllllllllllIIIIIIlIIIIIlII */
        //     7: invokespecial   java/net/URL.<init>:(Ljava/lang/String;)V
        //    10: astore          lllllllllllllllllIIIIIIlIIIIIIII
        //    12: aload           lllllllllllllllllIIIIIIlIIIIIIII
        //    14: invokestatic    net/minecraft/client/Minecraft.getMinecraft:()Lnet/minecraft/client/Minecraft;
        //    17: invokevirtual   net/minecraft/client/Minecraft.getProxy:()Ljava/net/Proxy;
        //    20: invokevirtual   java/net/URL.openConnection:(Ljava/net/Proxy;)Ljava/net/URLConnection;
        //    23: checkcast       Ljava/net/HttpURLConnection;
        //    26: astore_3        /* lllllllllllllllllIIIIIIlIIIIIIIl */
        //    27: aload_3         /* lllllllllllllllllIIIIIIlIIIIIIIl */
        //    28: ldc             "POST"
        //    30: invokevirtual   java/net/HttpURLConnection.setRequestMethod:(Ljava/lang/String;)V
        //    33: aload_1         /* lllllllllllllllllIIIIIIIllllIIlI */
        //    34: ifnull          110
        //    37: aload_1         /* lllllllllllllllllIIIIIIIllllIIlI */
        //    38: invokeinterface java/util/Map.keySet:()Ljava/util/Set;
        //    43: astore          lllllllllllllllllIIIIIIIllllllll
        //    45: aload           lllllllllllllllllIIIIIIIllllllll
        //    47: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
        //    52: astore          lllllllllllllllllIIIIIIIlllllllI
        //    54: goto            100
        //    57: aload           lllllllllllllllllIIIIIIIlllllllI
        //    59: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    64: checkcast       Ljava/lang/String;
        //    67: astore          lllllllllllllllllIIIIIIIllllllIl
        //    69: new             Ljava/lang/StringBuilder;
        //    72: dup            
        //    73: invokespecial   java/lang/StringBuilder.<init>:()V
        //    76: aload_1         /* lllllllllllllllllIIIIIIIllllIIlI */
        //    77: aload           lllllllllllllllllIIIIIIIllllllIl
        //    79: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    84: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //    87: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    90: astore          lllllllllllllllllIIIIIIIllllllII
        //    92: aload_3         /* lllllllllllllllllIIIIIIlIIIIIIIl */
        //    93: aload           lllllllllllllllllIIIIIIIllllllIl
        //    95: aload           lllllllllllllllllIIIIIIIllllllII
        //    97: invokevirtual   java/net/HttpURLConnection.setRequestProperty:(Ljava/lang/String;Ljava/lang/String;)V
        //   100: aload           lllllllllllllllllIIIIIIIlllllllI
        //   102: invokeinterface java/util/Iterator.hasNext:()Z
        //   107: ifne            57
        //   110: aload_3         /* lllllllllllllllllIIIIIIlIIIIIIIl */
        //   111: ldc             "Content-Type"
        //   113: ldc             "text/plain"
        //   115: invokevirtual   java/net/HttpURLConnection.setRequestProperty:(Ljava/lang/String;Ljava/lang/String;)V
        //   118: aload_3         /* lllllllllllllllllIIIIIIlIIIIIIIl */
        //   119: ldc             "Content-Length"
        //   121: new             Ljava/lang/StringBuilder;
        //   124: dup            
        //   125: invokespecial   java/lang/StringBuilder.<init>:()V
        //   128: aload_2         /* lllllllllllllllllIIIIIIlIIIIIIlI */
        //   129: arraylength    
        //   130: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   133: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   136: invokevirtual   java/net/HttpURLConnection.setRequestProperty:(Ljava/lang/String;Ljava/lang/String;)V
        //   139: aload_3         /* lllllllllllllllllIIIIIIlIIIIIIIl */
        //   140: ldc             "Content-Language"
        //   142: ldc             "en-US"
        //   144: invokevirtual   java/net/HttpURLConnection.setRequestProperty:(Ljava/lang/String;Ljava/lang/String;)V
        //   147: aload_3         /* lllllllllllllllllIIIIIIlIIIIIIIl */
        //   148: iconst_0       
        //   149: invokevirtual   java/net/HttpURLConnection.setUseCaches:(Z)V
        //   152: aload_3         /* lllllllllllllllllIIIIIIlIIIIIIIl */
        //   153: iconst_1       
        //   154: invokevirtual   java/net/HttpURLConnection.setDoInput:(Z)V
        //   157: aload_3         /* lllllllllllllllllIIIIIIlIIIIIIIl */
        //   158: iconst_1       
        //   159: invokevirtual   java/net/HttpURLConnection.setDoOutput:(Z)V
        //   162: aload_3         /* lllllllllllllllllIIIIIIlIIIIIIIl */
        //   163: invokevirtual   java/net/HttpURLConnection.getOutputStream:()Ljava/io/OutputStream;
        //   166: astore          lllllllllllllllllIIIIIIIlllllIll
        //   168: aload           lllllllllllllllllIIIIIIIlllllIll
        //   170: aload_2         /* lllllllllllllllllIIIIIIlIIIIIIlI */
        //   171: invokevirtual   java/io/OutputStream.write:([B)V
        //   174: aload           lllllllllllllllllIIIIIIIlllllIll
        //   176: invokevirtual   java/io/OutputStream.flush:()V
        //   179: aload           lllllllllllllllllIIIIIIIlllllIll
        //   181: invokevirtual   java/io/OutputStream.close:()V
        //   184: aload_3         /* lllllllllllllllllIIIIIIlIIIIIIIl */
        //   185: invokevirtual   java/net/HttpURLConnection.getInputStream:()Ljava/io/InputStream;
        //   188: astore          lllllllllllllllllIIIIIIIlllllIlI
        //   190: new             Ljava/io/InputStreamReader;
        //   193: dup            
        //   194: aload           lllllllllllllllllIIIIIIIlllllIlI
        //   196: ldc             "ASCII"
        //   198: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;Ljava/lang/String;)V
        //   201: astore          lllllllllllllllllIIIIIIIlllllIIl
        //   203: new             Ljava/io/BufferedReader;
        //   206: dup            
        //   207: aload           lllllllllllllllllIIIIIIIlllllIIl
        //   209: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;)V
        //   212: astore          lllllllllllllllllIIIIIIIlllllIII
        //   214: new             Ljava/lang/StringBuffer;
        //   217: dup            
        //   218: invokespecial   java/lang/StringBuffer.<init>:()V
        //   221: astore          lllllllllllllllllIIIIIIIllllIlll
        //   223: goto            242
        //   226: aload           lllllllllllllllllIIIIIIIllllIlll
        //   228: aload           lllllllllllllllllIIIIIIIllllIllI
        //   230: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   233: pop            
        //   234: aload           lllllllllllllllllIIIIIIIllllIlll
        //   236: bipush          13
        //   238: invokevirtual   java/lang/StringBuffer.append:(C)Ljava/lang/StringBuffer;
        //   241: pop            
        //   242: aload           lllllllllllllllllIIIIIIIlllllIII
        //   244: invokevirtual   java/io/BufferedReader.readLine:()Ljava/lang/String;
        //   247: dup            
        //   248: astore          lllllllllllllllllIIIIIIIllllIlIl
        //   250: ifnonnull       226
        //   253: aload           lllllllllllllllllIIIIIIIlllllIII
        //   255: invokevirtual   java/io/BufferedReader.close:()V
        //   258: aload           lllllllllllllllllIIIIIIIllllIlll
        //   260: invokevirtual   java/lang/StringBuffer.toString:()Ljava/lang/String;
        //   263: astore          lllllllllllllllllIIIIIIIllllIlII
        //   265: aload           lllllllllllllllllIIIIIIIllllIlII
        //   267: astore          lllllllllllllllllIIIIIIIlllIIllI
        //   269: aload_3         /* lllllllllllllllllIIIIIIlIIIIIIIl */
        //   270: ifnull          277
        //   273: aload_3         /* lllllllllllllllllIIIIIIlIIIIIIIl */
        //   274: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   277: aload           lllllllllllllllllIIIIIIIlllIIllI
        //   279: areturn        
        //   280: astore          lllllllllllllllllIIIIIIIlllIIlll
        //   282: aload_3         /* lllllllllllllllllIIIIIIlIIIIIIIl */
        //   283: ifnull          290
        //   286: aload_3         /* lllllllllllllllllIIIIIIlIIIIIIIl */
        //   287: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   290: aload           lllllllllllllllllIIIIIIIlllIIlll
        //   292: athrow         
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 08 FF 00 39 00 07 07 00 41 07 00 2F 07 00 D4 07 00 28 07 00 15 07 00 35 07 00 3B 00 00 2A F9 00 09 FF 00 73 00 0B 07 00 41 07 00 2F 07 00 D4 07 00 28 07 00 15 07 00 75 07 00 D6 07 00 85 07 00 8C 07 00 91 07 00 41 00 00 FA 00 0F FF 00 22 00 0E 07 00 41 07 00 2F 07 00 D4 07 00 28 07 00 15 07 00 75 07 00 D6 07 00 85 07 00 8C 07 00 91 07 00 41 07 00 41 00 07 00 41 00 00 FF 00 02 00 04 07 00 41 07 00 2F 07 00 D4 07 00 28 00 01 07 00 D8 FF 00 09 00 0D 07 00 41 07 00 2F 07 00 D4 07 00 28 00 00 00 00 00 00 00 00 07 00 D8 00 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  2      269    280    293    Any
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
    
    public static byte[] get(final String lllllllllllllllllIIIIIIlIIlIIIll) throws IOException {
        HttpURLConnection lllllllllllllllllIIIIIIlIIlIIIlI = null;
        try {
            final URL lllllllllllllllllIIIIIIlIIlIIIIl = new URL(lllllllllllllllllIIIIIIlIIlIIIll);
            lllllllllllllllllIIIIIIlIIlIIIlI = (HttpURLConnection)lllllllllllllllllIIIIIIlIIlIIIIl.openConnection(Minecraft.getMinecraft().getProxy());
            lllllllllllllllllIIIIIIlIIlIIIlI.setDoInput(true);
            lllllllllllllllllIIIIIIlIIlIIIlI.setDoOutput(false);
            lllllllllllllllllIIIIIIlIIlIIIlI.connect();
            if (lllllllllllllllllIIIIIIlIIlIIIlI.getResponseCode() / 100 != 2) {
                if (lllllllllllllllllIIIIIIlIIlIIIlI.getErrorStream() != null) {
                    Config.readAll(lllllllllllllllllIIIIIIlIIlIIIlI.getErrorStream());
                }
                throw new IOException(String.valueOf(new StringBuilder("HTTP response: ").append(lllllllllllllllllIIIIIIlIIlIIIlI.getResponseCode())));
            }
            final InputStream lllllllllllllllllIIIIIIlIIlIIIII = lllllllllllllllllIIIIIIlIIlIIIlI.getInputStream();
            final byte[] lllllllllllllllllIIIIIIlIIIlllll = new byte[lllllllllllllllllIIIIIIlIIlIIIlI.getContentLength()];
            int lllllllllllllllllIIIIIIlIIIllllI = 0;
            do {
                final int lllllllllllllllllIIIIIIlIIIlllIl = lllllllllllllllllIIIIIIlIIlIIIII.read(lllllllllllllllllIIIIIIlIIIlllll, lllllllllllllllllIIIIIIlIIIllllI, lllllllllllllllllIIIIIIlIIIlllll.length - lllllllllllllllllIIIIIIlIIIllllI);
                if (lllllllllllllllllIIIIIIlIIIlllIl < 0) {
                    throw new IOException(String.valueOf(new StringBuilder("Input stream closed: ").append(lllllllllllllllllIIIIIIlIIlIIIll)));
                }
                lllllllllllllllllIIIIIIlIIIllllI += lllllllllllllllllIIIIIIlIIIlllIl;
            } while (lllllllllllllllllIIIIIIlIIIllllI < lllllllllllllllllIIIIIIlIIIlllll.length);
            final int lllllllllllllllllIIIIIIlIIIlIIll;
            final byte[] lllllllllllllllllIIIIIIlIIIlllII = (Object)(lllllllllllllllllIIIIIIlIIIlIIll = (int)(Object)lllllllllllllllllIIIIIIlIIIlllll);
            return (byte[])(Object)lllllllllllllllllIIIIIIlIIIlIIll;
        }
        finally {
            if (lllllllllllllllllIIIIIIlIIlIIIlI != null) {
                lllllllllllllllllIIIIIIlIIlIIIlI.disconnect();
            }
        }
    }
    
    static {
        POST_URL = "http://optifine.net";
        SERVER_URL = "http://s.optifine.net";
    }
}
