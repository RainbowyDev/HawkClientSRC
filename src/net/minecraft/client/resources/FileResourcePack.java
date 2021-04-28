package net.minecraft.client.resources;

import com.google.common.base.*;
import java.util.zip.*;
import java.util.*;
import java.io.*;

public class FileResourcePack extends AbstractResourcePack implements Closeable
{
    private /* synthetic */ ZipFile resourcePackZipFile;
    
    @Override
    protected InputStream getInputStreamByName(final String lllllllllllllllIlIllIIlllIIIllll) throws IOException {
        final ZipFile lllllllllllllllIlIllIIlllIIIlllI = this.getResourcePackZipFile();
        final ZipEntry lllllllllllllllIlIllIIlllIIIllIl = lllllllllllllllIlIllIIlllIIIlllI.getEntry(lllllllllllllllIlIllIIlllIIIllll);
        if (lllllllllllllllIlIllIIlllIIIllIl == null) {
            throw new ResourcePackFileNotFoundException(this.resourcePackFile, lllllllllllllllIlIllIIlllIIIllll);
        }
        return lllllllllllllllIlIllIIlllIIIlllI.getInputStream(lllllllllllllllIlIllIIlllIIIllIl);
    }
    
    static {
        __OBFID = "CL_00001075";
        entryNameSplitter = Splitter.on('/').omitEmptyStrings().limit(3);
    }
    
    @Override
    public void close() throws IOException {
        if (this.resourcePackZipFile != null) {
            this.resourcePackZipFile.close();
            this.resourcePackZipFile = null;
        }
    }
    
    @Override
    public Set getResourceDomains() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   net/minecraft/client/resources/FileResourcePack.getResourcePackZipFile:()Ljava/util/zip/ZipFile;
        //     4: astore_1        /* lllllllllllllllIlIllIIllIllIllII */
        //     5: goto            13
        //     8: astore_2        /* lllllllllllllllIlIllIIllIllIlIll */
        //     9: invokestatic    java/util/Collections.emptySet:()Ljava/util/Set;
        //    12: areturn        
        //    13: aload_1         /* lllllllllllllllIlIllIIllIlllIlIl */
        //    14: invokevirtual   java/util/zip/ZipFile.entries:()Ljava/util/Enumeration;
        //    17: astore_2        /* lllllllllllllllIlIllIIllIllIlIll */
        //    18: invokestatic    com/google/common/collect/Sets.newHashSet:()Ljava/util/HashSet;
        //    21: astore_3        /* lllllllllllllllIlIllIIllIlllIIlI */
        //    22: goto            115
        //    25: aload_2         /* lllllllllllllllIlIllIIllIlllIIll */
        //    26: invokeinterface java/util/Enumeration.nextElement:()Ljava/lang/Object;
        //    31: checkcast       Ljava/util/zip/ZipEntry;
        //    34: astore          lllllllllllllllIlIllIIllIlllIIIl
        //    36: aload           lllllllllllllllIlIllIIllIlllIIIl
        //    38: invokevirtual   java/util/zip/ZipEntry.getName:()Ljava/lang/String;
        //    41: astore          lllllllllllllllIlIllIIllIlllIIII
        //    43: aload           lllllllllllllllIlIllIIllIlllIIII
        //    45: ldc             "assets/"
        //    47: invokevirtual   java/lang/String.startsWith:(Ljava/lang/String;)Z
        //    50: ifeq            115
        //    53: getstatic       net/minecraft/client/resources/FileResourcePack.entryNameSplitter:Lcom/google/common/base/Splitter;
        //    56: aload           lllllllllllllllIlIllIIllIlllIIII
        //    58: invokevirtual   com/google/common/base/Splitter.split:(Ljava/lang/CharSequence;)Ljava/lang/Iterable;
        //    61: invokestatic    com/google/common/collect/Lists.newArrayList:(Ljava/lang/Iterable;)Ljava/util/ArrayList;
        //    64: astore          lllllllllllllllIlIllIIllIllIllll
        //    66: aload           lllllllllllllllIlIllIIllIllIllll
        //    68: invokevirtual   java/util/ArrayList.size:()I
        //    71: iconst_1       
        //    72: if_icmple       115
        //    75: aload           lllllllllllllllIlIllIIllIllIllll
        //    77: iconst_1       
        //    78: invokevirtual   java/util/ArrayList.get:(I)Ljava/lang/Object;
        //    81: checkcast       Ljava/lang/String;
        //    84: astore          lllllllllllllllIlIllIIllIllIlllI
        //    86: aload           lllllllllllllllIlIllIIllIllIlllI
        //    88: aload           lllllllllllllllIlIllIIllIllIlllI
        //    90: invokevirtual   java/lang/String.toLowerCase:()Ljava/lang/String;
        //    93: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    96: ifne            108
        //    99: aload_0         /* lllllllllllllllIlIllIIllIllIllIl */
        //   100: aload           lllllllllllllllIlIllIIllIllIlllI
        //   102: invokevirtual   net/minecraft/client/resources/FileResourcePack.logNameNotLowercase:(Ljava/lang/String;)V
        //   105: goto            115
        //   108: aload_3         /* lllllllllllllllIlIllIIllIlllIIlI */
        //   109: aload           lllllllllllllllIlIllIIllIllIlllI
        //   111: invokevirtual   java/util/HashSet.add:(Ljava/lang/Object;)Z
        //   114: pop            
        //   115: aload_2         /* lllllllllllllllIlIllIIllIlllIIll */
        //   116: invokeinterface java/util/Enumeration.hasMoreElements:()Z
        //   121: ifne            25
        //   124: aload_3         /* lllllllllllllllIlIllIIllIlllIIlI */
        //   125: areturn        
        //    StackMapTable: 00 05 48 07 00 10 FC 00 04 07 00 16 FD 00 0B 07 00 66 07 00 97 FF 00 52 00 08 07 00 02 07 00 16 07 00 66 07 00 97 07 00 35 07 00 72 07 00 82 07 00 72 00 00 FF 00 06 00 04 07 00 02 07 00 16 07 00 66 07 00 97 00 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  0      5      8      13     Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private ZipFile getResourcePackZipFile() throws IOException {
        if (this.resourcePackZipFile == null) {
            this.resourcePackZipFile = new ZipFile(this.resourcePackFile);
        }
        return this.resourcePackZipFile;
    }
    
    @Override
    protected void finalize() throws Throwable {
        this.close();
        super.finalize();
    }
    
    public boolean hasResourceName(final String lllllllllllllllIlIllIIlllIIIIIIl) {
        try {
            return this.getResourcePackZipFile().getEntry(lllllllllllllllIlIllIIlllIIIIIIl) != null;
        }
        catch (IOException lllllllllllllllIlIllIIlllIIIIIll) {
            return false;
        }
    }
    
    public FileResourcePack(final File lllllllllllllllIlIllIIlllIIllIII) {
        super(lllllllllllllllIlIllIIlllIIllIII);
    }
}
