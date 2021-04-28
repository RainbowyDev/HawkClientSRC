package net.minecraft.util;

import java.util.concurrent.atomic.*;
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import com.google.common.util.concurrent.*;
import org.apache.logging.log4j.*;

public class HttpUtil
{
    public static final /* synthetic */ ListeningExecutorService field_180193_a;
    
    public static String get(final URL lllllllllllllllIlIIIIllIIIlllIIl) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   java/net/URL.openConnection:()Ljava/net/URLConnection;
        //     4: checkcast       Ljava/net/HttpURLConnection;
        //     7: astore_1        /* lllllllllllllllIlIIIIllIIIlllIII */
        //     8: aload_1         /* lllllllllllllllIlIIIIllIIIlllIII */
        //     9: ldc             "GET"
        //    11: invokevirtual   java/net/HttpURLConnection.setRequestMethod:(Ljava/lang/String;)V
        //    14: new             Ljava/io/BufferedReader;
        //    17: dup            
        //    18: new             Ljava/io/InputStreamReader;
        //    21: dup            
        //    22: aload_1         /* lllllllllllllllIlIIIIllIIIlllIII */
        //    23: invokevirtual   java/net/HttpURLConnection.getInputStream:()Ljava/io/InputStream;
        //    26: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;)V
        //    29: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;)V
        //    32: astore_2        /* lllllllllllllllIlIIIIllIIIllIIIl */
        //    33: new             Ljava/lang/StringBuilder;
        //    36: dup            
        //    37: invokespecial   java/lang/StringBuilder.<init>:()V
        //    40: astore_3        /* lllllllllllllllIlIIIIllIIIllIllI */
        //    41: goto            58
        //    44: aload_3         /* lllllllllllllllIlIIIIllIIIllIllI */
        //    45: aload           lllllllllllllllIlIIIIllIIIllIlIl
        //    47: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    50: pop            
        //    51: aload_3         /* lllllllllllllllIlIIIIllIIIllIllI */
        //    52: bipush          13
        //    54: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //    57: pop            
        //    58: aload_2         /* lllllllllllllllIlIIIIllIIIllIlll */
        //    59: invokevirtual   java/io/BufferedReader.readLine:()Ljava/lang/String;
        //    62: dup            
        //    63: astore          lllllllllllllllIlIIIIllIIIllIlII
        //    65: ifnonnull       44
        //    68: aload_2         /* lllllllllllllllIlIIIIllIIIllIlll */
        //    69: invokevirtual   java/io/BufferedReader.close:()V
        //    72: aload_3         /* lllllllllllllllIlIIIIllIIIllIllI */
        //    73: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    76: areturn        
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 02 FF 00 2C 00 05 07 00 19 07 00 1F 07 00 27 07 00 36 07 00 49 00 00 FA 00 0D
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static ListenableFuture func_180192_a(final File lllllllllllllllIlIIIIllIIlIlIIll, final String lllllllllllllllIlIIIIllIIlIllIIl, final Map lllllllllllllllIlIIIIllIIlIllIII, final int lllllllllllllllIlIIIIllIIlIlIIII, final IProgressUpdate lllllllllllllllIlIIIIllIIlIIllll, final Proxy lllllllllllllllIlIIIIllIIlIlIlIl) {
        final ListenableFuture lllllllllllllllIlIIIIllIIlIlIlII = HttpUtil.field_180193_a.submit((Runnable)new Runnable() {
            @Override
            public void run() {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     1: astore_1        /* lllllllllllllllllllIIIllllIllIIl */
                //     2: aconst_null    
                //     3: astore_2        /* lllllllllllllllllllIIIlllllIlIII */
                //     4: aload_0         /* lllllllllllllllllllIIIlllllIlIlI */
                //     5: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_4_:Lnet/minecraft/util/IProgressUpdate;
                //     8: ifnull          33
                //    11: aload_0         /* lllllllllllllllllllIIIlllllIlIlI */
                //    12: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_4_:Lnet/minecraft/util/IProgressUpdate;
                //    15: ldc             "Downloading Resource Pack"
                //    17: invokeinterface net/minecraft/util/IProgressUpdate.resetProgressAndMessage:(Ljava/lang/String;)V
                //    22: aload_0         /* lllllllllllllllllllIIIlllllIlIlI */
                //    23: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_4_:Lnet/minecraft/util/IProgressUpdate;
                //    26: ldc             "Making Request..."
                //    28: invokeinterface net/minecraft/util/IProgressUpdate.displayLoadingString:(Ljava/lang/String;)V
                //    33: sipush          4096
                //    36: newarray        B
                //    38: astore_3        /* lllllllllllllllllllIIIlllllIIlll */
                //    39: new             Ljava/net/URL;
                //    42: dup            
                //    43: aload_0         /* lllllllllllllllllllIIIlllllIlIlI */
                //    44: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_1_:Ljava/lang/String;
                //    47: invokespecial   java/net/URL.<init>:(Ljava/lang/String;)V
                //    50: astore          lllllllllllllllllllIIIlllllIIllI
                //    52: aload           lllllllllllllllllllIIIlllllIIllI
                //    54: aload_0         /* lllllllllllllllllllIIIlllllIlIlI */
                //    55: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_5_:Ljava/net/Proxy;
                //    58: invokevirtual   java/net/URL.openConnection:(Ljava/net/Proxy;)Ljava/net/URLConnection;
                //    61: astore          lllllllllllllllllllIIIlllllIIlIl
                //    63: fconst_0       
                //    64: fstore          lllllllllllllllllllIIIlllllIIlII
                //    66: aload_0         /* lllllllllllllllllllIIIlllllIlIlI */
                //    67: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_2_:Ljava/util/Map;
                //    70: invokeinterface java/util/Map.entrySet:()Ljava/util/Set;
                //    75: invokeinterface java/util/Set.size:()I
                //    80: i2f            
                //    81: fstore          lllllllllllllllllllIIIlllllIIIll
                //    83: aload_0         /* lllllllllllllllllllIIIlllllIlIlI */
                //    84: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_2_:Ljava/util/Map;
                //    87: invokeinterface java/util/Map.entrySet:()Ljava/util/Set;
                //    92: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
                //    97: astore          lllllllllllllllllllIIIlllllIIIlI
                //    99: goto            169
                //   102: aload           lllllllllllllllllllIIIlllllIIIlI
                //   104: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
                //   109: checkcast       Ljava/util/Map$Entry;
                //   112: astore          lllllllllllllllllllIIIlllllIIIIl
                //   114: aload           lllllllllllllllllllIIIlllllIIlIl
                //   116: aload           lllllllllllllllllllIIIlllllIIIIl
                //   118: invokeinterface java/util/Map$Entry.getKey:()Ljava/lang/Object;
                //   123: checkcast       Ljava/lang/String;
                //   126: aload           lllllllllllllllllllIIIlllllIIIIl
                //   128: invokeinterface java/util/Map$Entry.getValue:()Ljava/lang/Object;
                //   133: checkcast       Ljava/lang/String;
                //   136: invokevirtual   java/net/URLConnection.setRequestProperty:(Ljava/lang/String;Ljava/lang/String;)V
                //   139: aload_0         /* lllllllllllllllllllIIIlllllIlIlI */
                //   140: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_4_:Lnet/minecraft/util/IProgressUpdate;
                //   143: ifnull          169
                //   146: aload_0         /* lllllllllllllllllllIIIlllllIlIlI */
                //   147: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_4_:Lnet/minecraft/util/IProgressUpdate;
                //   150: fload           lllllllllllllllllllIIIlllllIIlII
                //   152: fconst_1       
                //   153: fadd           
                //   154: dup            
                //   155: fstore          lllllllllllllllllllIIIlllllIIlII
                //   157: fload           lllllllllllllllllllIIIlllllIIIll
                //   159: fdiv           
                //   160: ldc             100.0
                //   162: fmul           
                //   163: f2i            
                //   164: invokeinterface net/minecraft/util/IProgressUpdate.setLoadingProgress:(I)V
                //   169: aload           lllllllllllllllllllIIIlllllIIIlI
                //   171: invokeinterface java/util/Iterator.hasNext:()Z
                //   176: ifne            102
                //   179: aload           lllllllllllllllllllIIIlllllIIlIl
                //   181: invokevirtual   java/net/URLConnection.getInputStream:()Ljava/io/InputStream;
                //   184: astore_1        /* lllllllllllllllllllIIIlllllIlIIl */
                //   185: aload           lllllllllllllllllllIIIlllllIIlIl
                //   187: invokevirtual   java/net/URLConnection.getContentLength:()I
                //   190: i2f            
                //   191: fstore          lllllllllllllllllllIIIlllllIIIll
                //   193: aload           lllllllllllllllllllIIIlllllIIlIl
                //   195: invokevirtual   java/net/URLConnection.getContentLength:()I
                //   198: istore          lllllllllllllllllllIIIlllllIIIII
                //   200: aload_0         /* lllllllllllllllllllIIIlllllIlIlI */
                //   201: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_4_:Lnet/minecraft/util/IProgressUpdate;
                //   204: ifnull          239
                //   207: aload_0         /* lllllllllllllllllllIIIlllllIlIlI */
                //   208: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_4_:Lnet/minecraft/util/IProgressUpdate;
                //   211: ldc             "Downloading file (%.2f MB)..."
                //   213: iconst_1       
                //   214: anewarray       Ljava/lang/Object;
                //   217: dup            
                //   218: iconst_0       
                //   219: fload           lllllllllllllllllllIIIlllllIIIll
                //   221: ldc             1000.0
                //   223: fdiv           
                //   224: ldc             1000.0
                //   226: fdiv           
                //   227: invokestatic    java/lang/Float.valueOf:(F)Ljava/lang/Float;
                //   230: aastore        
                //   231: invokestatic    java/lang/String.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
                //   234: invokeinterface net/minecraft/util/IProgressUpdate.displayLoadingString:(Ljava/lang/String;)V
                //   239: aload_0         /* lllllllllllllllllllIIIlllllIlIlI */
                //   240: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_0_:Ljava/io/File;
                //   243: invokevirtual   java/io/File.exists:()Z
                //   246: ifeq            355
                //   249: aload_0         /* lllllllllllllllllllIIIlllllIlIlI */
                //   250: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_0_:Ljava/io/File;
                //   253: invokevirtual   java/io/File.length:()J
                //   256: lstore          lllllllllllllllllllIIIllllIlllll
                //   258: lload           lllllllllllllllllllIIIllllIlllll
                //   260: iload           lllllllllllllllllllIIIlllllIIIII
                //   262: i2l            
                //   263: lcmp           
                //   264: ifne            292
                //   267: aload_0         /* lllllllllllllllllllIIIlllllIlIlI */
                //   268: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_4_:Lnet/minecraft/util/IProgressUpdate;
                //   271: ifnull          283
                //   274: aload_0         /* lllllllllllllllllllIIIlllllIlIlI */
                //   275: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_4_:Lnet/minecraft/util/IProgressUpdate;
                //   278: invokeinterface net/minecraft/util/IProgressUpdate.setDoneWorking:()V
                //   283: aload_1         /* lllllllllllllllllllIIIlllllIlIIl */
                //   284: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/InputStream;)V
                //   287: aload_2         /* lllllllllllllllllllIIIlllllIlIII */
                //   288: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/OutputStream;)V
                //   291: return         
                //   292: invokestatic    net/minecraft/util/HttpUtil.access$0:()Lorg/apache/logging/log4j/Logger;
                //   295: new             Ljava/lang/StringBuilder;
                //   298: dup            
                //   299: ldc             "Deleting "
                //   301: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
                //   304: aload_0         /* lllllllllllllllllllIIIlllllIlIlI */
                //   305: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_0_:Ljava/io/File;
                //   308: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
                //   311: ldc             " as it does not match what we currently have ("
                //   313: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
                //   316: iload           lllllllllllllllllllIIIlllllIIIII
                //   318: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
                //   321: ldc             " vs our "
                //   323: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
                //   326: lload           lllllllllllllllllllIIIllllIlllll
                //   328: invokevirtual   java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
                //   331: ldc             ")."
                //   333: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
                //   336: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
                //   339: invokeinterface org/apache/logging/log4j/Logger.warn:(Ljava/lang/String;)V
                //   344: aload_0         /* lllllllllllllllllllIIIlllllIlIlI */
                //   345: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_0_:Ljava/io/File;
                //   348: invokestatic    org/apache/commons/io/FileUtils.deleteQuietly:(Ljava/io/File;)Z
                //   351: pop            
                //   352: goto            376
                //   355: aload_0         /* lllllllllllllllllllIIIlllllIlIlI */
                //   356: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_0_:Ljava/io/File;
                //   359: invokevirtual   java/io/File.getParentFile:()Ljava/io/File;
                //   362: ifnull          376
                //   365: aload_0         /* lllllllllllllllllllIIIlllllIlIlI */
                //   366: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_0_:Ljava/io/File;
                //   369: invokevirtual   java/io/File.getParentFile:()Ljava/io/File;
                //   372: invokevirtual   java/io/File.mkdirs:()Z
                //   375: pop            
                //   376: new             Ljava/io/DataOutputStream;
                //   379: dup            
                //   380: new             Ljava/io/FileOutputStream;
                //   383: dup            
                //   384: aload_0         /* lllllllllllllllllllIIIlllllIlIlI */
                //   385: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_0_:Ljava/io/File;
                //   388: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/File;)V
                //   391: invokespecial   java/io/DataOutputStream.<init>:(Ljava/io/OutputStream;)V
                //   394: astore_2        /* lllllllllllllllllllIIIlllllIlIII */
                //   395: aload_0         /* lllllllllllllllllllIIIlllllIlIlI */
                //   396: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_3_:I
                //   399: ifle            471
                //   402: fload           lllllllllllllllllllIIIlllllIIIll
                //   404: aload_0         /* lllllllllllllllllllIIIlllllIlIlI */
                //   405: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_3_:I
                //   408: i2f            
                //   409: fcmpl          
                //   410: ifle            471
                //   413: aload_0         /* lllllllllllllllllllIIIlllllIlIlI */
                //   414: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_4_:Lnet/minecraft/util/IProgressUpdate;
                //   417: ifnull          429
                //   420: aload_0         /* lllllllllllllllllllIIIlllllIlIlI */
                //   421: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_4_:Lnet/minecraft/util/IProgressUpdate;
                //   424: invokeinterface net/minecraft/util/IProgressUpdate.setDoneWorking:()V
                //   429: new             Ljava/io/IOException;
                //   432: dup            
                //   433: new             Ljava/lang/StringBuilder;
                //   436: dup            
                //   437: ldc             "Filesize is bigger than maximum allowed (file is "
                //   439: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
                //   442: fload           lllllllllllllllllllIIIlllllIIlII
                //   444: invokevirtual   java/lang/StringBuilder.append:(F)Ljava/lang/StringBuilder;
                //   447: ldc             ", limit is "
                //   449: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
                //   452: aload_0         /* lllllllllllllllllllIIIlllllIlIlI */
                //   453: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_3_:I
                //   456: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
                //   459: ldc             ")"
                //   461: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
                //   464: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
                //   467: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
                //   470: athrow         
                //   471: iconst_0       
                //   472: istore          lllllllllllllllllllIIIllllIllllI
                //   474: goto            594
                //   477: fload           lllllllllllllllllllIIIlllllIIlII
                //   479: iload           lllllllllllllllllllIIIllllIlllIl
                //   481: i2f            
                //   482: fadd           
                //   483: fstore          lllllllllllllllllllIIIlllllIIlII
                //   485: aload_0         /* lllllllllllllllllllIIIlllllIlIlI */
                //   486: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_4_:Lnet/minecraft/util/IProgressUpdate;
                //   489: ifnull          510
                //   492: aload_0         /* lllllllllllllllllllIIIlllllIlIlI */
                //   493: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_4_:Lnet/minecraft/util/IProgressUpdate;
                //   496: fload           lllllllllllllllllllIIIlllllIIlII
                //   498: fload           lllllllllllllllllllIIIlllllIIIll
                //   500: fdiv           
                //   501: ldc             100.0
                //   503: fmul           
                //   504: f2i            
                //   505: invokeinterface net/minecraft/util/IProgressUpdate.setLoadingProgress:(I)V
                //   510: aload_0         /* lllllllllllllllllllIIIlllllIlIlI */
                //   511: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_3_:I
                //   514: ifle            586
                //   517: fload           lllllllllllllllllllIIIlllllIIlII
                //   519: aload_0         /* lllllllllllllllllllIIIlllllIlIlI */
                //   520: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_3_:I
                //   523: i2f            
                //   524: fcmpl          
                //   525: ifle            586
                //   528: aload_0         /* lllllllllllllllllllIIIlllllIlIlI */
                //   529: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_4_:Lnet/minecraft/util/IProgressUpdate;
                //   532: ifnull          544
                //   535: aload_0         /* lllllllllllllllllllIIIlllllIlIlI */
                //   536: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_4_:Lnet/minecraft/util/IProgressUpdate;
                //   539: invokeinterface net/minecraft/util/IProgressUpdate.setDoneWorking:()V
                //   544: new             Ljava/io/IOException;
                //   547: dup            
                //   548: new             Ljava/lang/StringBuilder;
                //   551: dup            
                //   552: ldc             "Filesize was bigger than maximum allowed (got >= "
                //   554: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
                //   557: fload           lllllllllllllllllllIIIlllllIIlII
                //   559: invokevirtual   java/lang/StringBuilder.append:(F)Ljava/lang/StringBuilder;
                //   562: ldc             ", limit was "
                //   564: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
                //   567: aload_0         /* lllllllllllllllllllIIIlllllIlIlI */
                //   568: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_3_:I
                //   571: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
                //   574: ldc             ")"
                //   576: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
                //   579: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
                //   582: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
                //   585: athrow         
                //   586: aload_2         /* lllllllllllllllllllIIIlllllIlIII */
                //   587: aload_3         /* lllllllllllllllllllIIIlllllIIlll */
                //   588: iconst_0       
                //   589: iload           lllllllllllllllllllIIIllllIlllIl
                //   591: invokevirtual   java/io/DataOutputStream.write:([BII)V
                //   594: aload_1         /* lllllllllllllllllllIIIlllllIlIIl */
                //   595: aload_3         /* lllllllllllllllllllIIIlllllIIlll */
                //   596: invokevirtual   java/io/InputStream.read:([B)I
                //   599: dup            
                //   600: istore          lllllllllllllllllllIIIllllIlllII
                //   602: ifge            477
                //   605: aload_0         /* lllllllllllllllllllIIIlllllIlIlI */
                //   606: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_4_:Lnet/minecraft/util/IProgressUpdate;
                //   609: ifnull          651
                //   612: aload_0         /* lllllllllllllllllllIIIlllllIlIlI */
                //   613: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_4_:Lnet/minecraft/util/IProgressUpdate;
                //   616: invokeinterface net/minecraft/util/IProgressUpdate.setDoneWorking:()V
                //   621: aload_1         /* lllllllllllllllllllIIIlllllIlIIl */
                //   622: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/InputStream;)V
                //   625: aload_2         /* lllllllllllllllllllIIIlllllIlIII */
                //   626: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/OutputStream;)V
                //   629: return         
                //   630: astore_3        /* lllllllllllllllllllIIIlllllIIlll */
                //   631: aload_3         /* lllllllllllllllllllIIIllllIllIll */
                //   632: invokevirtual   java/lang/Throwable.printStackTrace:()V
                //   635: goto            651
                //   638: astore          lllllllllllllllllllIIIllllIIlllI
                //   640: aload_1         /* lllllllllllllllllllIIIlllllIlIIl */
                //   641: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/InputStream;)V
                //   644: aload_2         /* lllllllllllllllllllIIIlllllIlIII */
                //   645: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/OutputStream;)V
                //   648: aload           lllllllllllllllllllIIIllllIIlllI
                //   650: athrow         
                //   651: aload_1         /* lllllllllllllllllllIIIlllllIlIIl */
                //   652: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/InputStream;)V
                //   655: aload_2         /* lllllllllllllllllllIIIlllllIlIII */
                //   656: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/OutputStream;)V
                //   659: return         
                //    StackMapTable: 00 12 FD 00 21 05 05 FF 00 44 00 09 07 00 02 05 05 07 01 1B 07 00 32 07 00 5D 02 02 07 00 4F 00 00 FB 00 42 FF 00 45 00 0A 07 00 02 07 00 E7 05 07 01 1B 07 00 32 07 00 5D 02 02 07 00 4F 01 00 00 FC 00 2B 04 08 FA 00 3E 14 FF 00 34 00 0A 07 00 02 07 00 E7 07 00 C8 07 01 1B 07 00 32 07 00 5D 02 02 07 00 4F 01 00 00 29 FD 00 05 01 01 20 21 29 FA 00 07 FF 00 23 00 03 07 00 02 07 00 E7 07 00 C8 00 01 07 00 21 47 07 00 21 FC 00 0C 07 00 04
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                 
                //  -----  -----  -----  -----  ---------------------
                //  33     283    630    638    Ljava/lang/Throwable;
                //  292    621    630    638    Ljava/lang/Throwable;
                //  33     283    638    651    Any
                //  292    621    638    651    Any
                //  630    638    638    651    Any
                // 
                // The error that occurred was:
                // 
                // java.lang.NullPointerException
                // 
                throw new IllegalStateException("An error occurred while decompiling this method.");
            }
            
            static {
                __OBFID = "CL_00001486";
            }
        });
        return lllllllllllllllIlIIIIllIIlIlIlII;
    }
    
    public static String buildPostString(final Map lllllllllllllllIlIIIIllIlIIlIIlI) {
        final StringBuilder lllllllllllllllIlIIIIllIlIIlIIIl = new StringBuilder();
        for (final Map.Entry lllllllllllllllIlIIIIllIlIIIllll : lllllllllllllllIlIIIIllIlIIlIIlI.entrySet()) {
            if (lllllllllllllllIlIIIIllIlIIlIIIl.length() > 0) {
                lllllllllllllllIlIIIIllIlIIlIIIl.append('&');
            }
            try {
                lllllllllllllllIlIIIIllIlIIlIIIl.append(URLEncoder.encode(lllllllllllllllIlIIIIllIlIIIllll.getKey(), "UTF-8"));
            }
            catch (UnsupportedEncodingException lllllllllllllllIlIIIIllIlIIIlllI) {
                lllllllllllllllIlIIIIllIlIIIlllI.printStackTrace();
            }
            if (lllllllllllllllIlIIIIllIlIIIllll.getValue() != null) {
                lllllllllllllllIlIIIIllIlIIlIIIl.append('=');
                try {
                    lllllllllllllllIlIIIIllIlIIlIIIl.append(URLEncoder.encode(lllllllllllllllIlIIIIllIlIIIllll.getValue().toString(), "UTF-8"));
                }
                catch (UnsupportedEncodingException lllllllllllllllIlIIIIllIlIIIllIl) {
                    lllllllllllllllIlIIIIllIlIIIllIl.printStackTrace();
                }
            }
        }
        return String.valueOf(lllllllllllllllIlIIIIllIlIIlIIIl);
    }
    
    public static String postMap(final URL lllllllllllllllIlIIIIllIlIIIIIIl, final Map lllllllllllllllIlIIIIllIlIIIIIll, final boolean lllllllllllllllIlIIIIllIIlllllll) {
        return post(lllllllllllllllIlIIIIllIlIIIIIIl, buildPostString(lllllllllllllllIlIIIIllIlIIIIIll), lllllllllllllllIlIIIIllIIlllllll);
    }
    
    private static String post(final URL lllllllllllllllIlIIIIllIIllIlIlI, final String lllllllllllllllIlIIIIllIIlllIlII, final boolean lllllllllllllllIlIIIIllIIlllIIll) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: ifnonnull       10
        //     6: aconst_null    
        //     7: goto            16
        //    10: invokestatic    net/minecraft/server/MinecraftServer.getServer:()Lnet/minecraft/server/MinecraftServer;
        //    13: invokevirtual   net/minecraft/server/MinecraftServer.getServerProxy:()Ljava/net/Proxy;
        //    16: astore_3        /* lllllllllllllllIlIIIIllIIllIIlll */
        //    17: aload_3         /* lllllllllllllllIlIIIIllIIlllIIlI */
        //    18: ifnonnull       25
        //    21: getstatic       java/net/Proxy.NO_PROXY:Ljava/net/Proxy;
        //    24: astore_3        /* lllllllllllllllIlIIIIllIIlllIIlI */
        //    25: aload_0         /* lllllllllllllllIlIIIIllIIlllIlIl */
        //    26: aload_3         /* lllllllllllllllIlIIIIllIIlllIIlI */
        //    27: invokevirtual   java/net/URL.openConnection:(Ljava/net/Proxy;)Ljava/net/URLConnection;
        //    30: checkcast       Ljava/net/HttpURLConnection;
        //    33: astore          lllllllllllllllIlIIIIllIIlllIIIl
        //    35: aload           lllllllllllllllIlIIIIllIIlllIIIl
        //    37: ldc             "POST"
        //    39: invokevirtual   java/net/HttpURLConnection.setRequestMethod:(Ljava/lang/String;)V
        //    42: aload           lllllllllllllllIlIIIIllIIlllIIIl
        //    44: ldc             "Content-Type"
        //    46: ldc             "application/x-www-form-urlencoded"
        //    48: invokevirtual   java/net/HttpURLConnection.setRequestProperty:(Ljava/lang/String;Ljava/lang/String;)V
        //    51: aload           lllllllllllllllIlIIIIllIIlllIIIl
        //    53: ldc             "Content-Length"
        //    55: new             Ljava/lang/StringBuilder;
        //    58: dup            
        //    59: invokespecial   java/lang/StringBuilder.<init>:()V
        //    62: aload_1         /* lllllllllllllllIlIIIIllIIllIlIIl */
        //    63: invokevirtual   java/lang/String.getBytes:()[B
        //    66: arraylength    
        //    67: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //    70: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    73: invokevirtual   java/net/HttpURLConnection.setRequestProperty:(Ljava/lang/String;Ljava/lang/String;)V
        //    76: aload           lllllllllllllllIlIIIIllIIlllIIIl
        //    78: ldc             "Content-Language"
        //    80: ldc             "en-US"
        //    82: invokevirtual   java/net/HttpURLConnection.setRequestProperty:(Ljava/lang/String;Ljava/lang/String;)V
        //    85: aload           lllllllllllllllIlIIIIllIIlllIIIl
        //    87: iconst_0       
        //    88: invokevirtual   java/net/HttpURLConnection.setUseCaches:(Z)V
        //    91: aload           lllllllllllllllIlIIIIllIIlllIIIl
        //    93: iconst_1       
        //    94: invokevirtual   java/net/HttpURLConnection.setDoInput:(Z)V
        //    97: aload           lllllllllllllllIlIIIIllIIlllIIIl
        //    99: iconst_1       
        //   100: invokevirtual   java/net/HttpURLConnection.setDoOutput:(Z)V
        //   103: new             Ljava/io/DataOutputStream;
        //   106: dup            
        //   107: aload           lllllllllllllllIlIIIIllIIlllIIIl
        //   109: invokevirtual   java/net/HttpURLConnection.getOutputStream:()Ljava/io/OutputStream;
        //   112: invokespecial   java/io/DataOutputStream.<init>:(Ljava/io/OutputStream;)V
        //   115: astore          lllllllllllllllIlIIIIllIIlllIIII
        //   117: aload           lllllllllllllllIlIIIIllIIlllIIII
        //   119: aload_1         /* lllllllllllllllIlIIIIllIIllIlIIl */
        //   120: invokevirtual   java/io/DataOutputStream.writeBytes:(Ljava/lang/String;)V
        //   123: aload           lllllllllllllllIlIIIIllIIlllIIII
        //   125: invokevirtual   java/io/DataOutputStream.flush:()V
        //   128: aload           lllllllllllllllIlIIIIllIIlllIIII
        //   130: invokevirtual   java/io/DataOutputStream.close:()V
        //   133: new             Ljava/io/BufferedReader;
        //   136: dup            
        //   137: new             Ljava/io/InputStreamReader;
        //   140: dup            
        //   141: aload           lllllllllllllllIlIIIIllIIlllIIIl
        //   143: invokevirtual   java/net/HttpURLConnection.getInputStream:()Ljava/io/InputStream;
        //   146: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;)V
        //   149: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;)V
        //   152: astore          lllllllllllllllIlIIIIllIIllIllll
        //   154: new             Ljava/lang/StringBuffer;
        //   157: dup            
        //   158: invokespecial   java/lang/StringBuffer.<init>:()V
        //   161: astore          lllllllllllllllIlIIIIllIIllIlllI
        //   163: goto            182
        //   166: aload           lllllllllllllllIlIIIIllIIllIlllI
        //   168: aload           lllllllllllllllIlIIIIllIIllIllIl
        //   170: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   173: pop            
        //   174: aload           lllllllllllllllIlIIIIllIIllIlllI
        //   176: bipush          13
        //   178: invokevirtual   java/lang/StringBuffer.append:(C)Ljava/lang/StringBuffer;
        //   181: pop            
        //   182: aload           lllllllllllllllIlIIIIllIIllIllll
        //   184: invokevirtual   java/io/BufferedReader.readLine:()Ljava/lang/String;
        //   187: dup            
        //   188: astore          lllllllllllllllIlIIIIllIIllIllII
        //   190: ifnonnull       166
        //   193: aload           lllllllllllllllIlIIIIllIIllIllll
        //   195: invokevirtual   java/io/BufferedReader.close:()V
        //   198: aload           lllllllllllllllIlIIIIllIIllIlllI
        //   200: invokevirtual   java/lang/StringBuffer.toString:()Ljava/lang/String;
        //   203: areturn        
        //   204: astore_3        /* lllllllllllllllIlIIIIllIIlllIIlI */
        //   205: iload_2         /* lllllllllllllllIlIIIIllIIllIlIII */
        //   206: ifne            235
        //   209: getstatic       net/minecraft/util/HttpUtil.logger:Lorg/apache/logging/log4j/Logger;
        //   212: new             Ljava/lang/StringBuilder;
        //   215: dup            
        //   216: ldc_w           "Could not post to "
        //   219: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   222: aload_0         /* lllllllllllllllIlIIIIllIIlllIlIl */
        //   223: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   226: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   229: aload_3         /* lllllllllllllllIlIIIIllIIllIlIll */
        //   230: invokeinterface org/apache/logging/log4j/Logger.error:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   235: ldc_w           ""
        //   238: areturn        
        //    StackMapTable: 00 07 0A 45 07 00 DE FC 00 08 07 00 DE FF 00 8C 00 09 07 00 19 07 00 49 01 07 00 DE 07 00 1F 07 01 07 07 00 27 07 01 17 07 00 49 00 00 FA 00 0F FF 00 15 00 03 07 00 19 07 00 49 01 00 01 07 00 D2 FC 00 1E 07 00 D2
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  0      203    204    239    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static int getSuitableLanPort() throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_0        /* lllllllllllllllIlIIIIllIIlIIIlll */
        //     2: iconst_1       
        //     3: istore_1        /* lllllllllllllllIlIIIIllIIlIIIllI */
        //     4: new             Ljava/net/ServerSocket;
        //     7: dup            
        //     8: iconst_0       
        //     9: invokespecial   java/net/ServerSocket.<init>:(I)V
        //    12: astore_0        /* lllllllllllllllIlIIIIllIIlIIIlll */
        //    13: aload_0         /* lllllllllllllllIlIIIIllIIlIIIlll */
        //    14: invokevirtual   java/net/ServerSocket.getLocalPort:()I
        //    17: istore_2        /* lllllllllllllllIlIIIIllIIlIIIlIl */
        //    18: goto            37
        //    21: astore_3        /* lllllllllllllllIlIIIIllIIlIIIIII */
        //    22: aload_0         /* lllllllllllllllIlIIIIllIIlIIIlll */
        //    23: ifnull          35
        //    26: aload_0         /* lllllllllllllllIlIIIIllIIlIIIlll */
        //    27: invokevirtual   java/net/ServerSocket.close:()V
        //    30: goto            35
        //    33: astore          lllllllllllllllIlIIIIllIIIllllll
        //    35: aload_3         /* lllllllllllllllIlIIIIllIIlIIIIII */
        //    36: athrow         
        //    37: aload_0         /* lllllllllllllllIlIIIIllIIlIIIlll */
        //    38: ifnull          50
        //    41: aload_0         /* lllllllllllllllIlIIIIllIIlIIIlll */
        //    42: invokevirtual   java/net/ServerSocket.close:()V
        //    45: goto            50
        //    48: astore          lllllllllllllllIlIIIIllIIIllllll
        //    50: iload_2         /* lllllllllllllllIlIIIIllIIlIIIlII */
        //    51: ireturn        
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 06 FF 00 15 00 02 07 01 4C 01 00 01 07 01 5F FF 00 0B 00 04 07 01 4C 01 00 07 01 5F 00 01 07 00 17 01 FF 00 01 00 03 07 01 4C 01 01 00 00 4A 07 00 17 01
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  4      21     21     37     Any
        //  22     30     33     35     Ljava/io/IOException;
        //  37     45     48     50     Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static {
        __OBFID = "CL_00001485";
        field_180193_a = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool(new ThreadFactoryBuilder().setDaemon(true).setNameFormat("Downloader %d").build()));
        downloadThreadsStarted = new AtomicInteger(0);
        logger = LogManager.getLogger();
    }
}
