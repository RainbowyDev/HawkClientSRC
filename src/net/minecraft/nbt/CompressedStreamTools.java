package net.minecraft.nbt;

import net.minecraft.util.*;
import net.minecraft.crash.*;
import java.util.zip.*;
import java.io.*;

public class CompressedStreamTools
{
    private static NBTBase func_152455_a(final DataInput llllllllllllllIIllIIlIIIllIIIIIl, final int llllllllllllllIIllIIlIIIllIIIIII, final NBTSizeTracker llllllllllllllIIllIIlIIIlIllllll) throws IOException {
        final byte llllllllllllllIIllIIlIIIlIlllllI = llllllllllllllIIllIIlIIIllIIIIIl.readByte();
        if (llllllllllllllIIllIIlIIIlIlllllI == 0) {
            return new NBTTagEnd();
        }
        llllllllllllllIIllIIlIIIllIIIIIl.readUTF();
        final NBTBase llllllllllllllIIllIIlIIIlIllllIl = NBTBase.createNewByType(llllllllllllllIIllIIlIIIlIlllllI);
        try {
            llllllllllllllIIllIIlIIIlIllllIl.read(llllllllllllllIIllIIlIIIllIIIIIl, llllllllllllllIIllIIlIIIllIIIIII, llllllllllllllIIllIIlIIIlIllllll);
            return llllllllllllllIIllIIlIIIlIllllIl;
        }
        catch (IOException llllllllllllllIIllIIlIIIlIllllII) {
            final CrashReport llllllllllllllIIllIIlIIIlIlllIll = CrashReport.makeCrashReport(llllllllllllllIIllIIlIIIlIllllII, "Loading NBT data");
            final CrashReportCategory llllllllllllllIIllIIlIIIlIlllIlI = llllllllllllllIIllIIlIIIlIlllIll.makeCategory("NBT Tag");
            llllllllllllllIIllIIlIIIlIlllIlI.addCrashSection("Tag name", "[UNNAMED TAG]");
            llllllllllllllIIllIIlIIIlIlllIlI.addCrashSection("Tag type", llllllllllllllIIllIIlIIIlIlllllI);
            throw new ReportedException(llllllllllllllIIllIIlIIIlIlllIll);
        }
    }
    
    private static void writeTag(final NBTBase llllllllllllllIIllIIlIIIllIIlIll, final DataOutput llllllllllllllIIllIIlIIIllIIllII) throws IOException {
        llllllllllllllIIllIIlIIIllIIllII.writeByte(llllllllllllllIIllIIlIIIllIIlIll.getId());
        if (llllllllllllllIIllIIlIIIllIIlIll.getId() != 0) {
            llllllllllllllIIllIIlIIIllIIllII.writeUTF("");
            llllllllllllllIIllIIlIIIllIIlIll.write(llllllllllllllIIllIIlIIIllIIllII);
        }
    }
    
    public static void writeCompressed(final NBTTagCompound llllllllllllllIIllIIlIIlIIIIlIII, final OutputStream llllllllllllllIIllIIlIIlIIIIIlII) throws IOException {
        final DataOutputStream llllllllllllllIIllIIlIIlIIIIIllI = new DataOutputStream(new BufferedOutputStream(new GZIPOutputStream(llllllllllllllIIllIIlIIlIIIIIlII)));
        try {
            write(llllllllllllllIIllIIlIIlIIIIlIII, llllllllllllllIIllIIlIIlIIIIIllI);
        }
        finally {
            llllllllllllllIIllIIlIIlIIIIIllI.close();
        }
        llllllllllllllIIllIIlIIlIIIIIllI.close();
    }
    
    static {
        __OBFID = "CL_00001226";
    }
    
    public static NBTTagCompound read(final File llllllllllllllIIllIIlIIIlllIIlIl) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   java/io/File.exists:()Z
        //     4: ifne            9
        //     7: aconst_null    
        //     8: areturn        
        //     9: new             Ljava/io/DataInputStream;
        //    12: dup            
        //    13: new             Ljava/io/FileInputStream;
        //    16: dup            
        //    17: aload_0         /* llllllllllllllIIllIIlIIIlllIlIIl */
        //    18: invokespecial   java/io/FileInputStream.<init>:(Ljava/io/File;)V
        //    21: invokespecial   java/io/DataInputStream.<init>:(Ljava/io/InputStream;)V
        //    24: astore_1        /* llllllllllllllIIllIIlIIIlllIIlII */
        //    25: aload_1         /* llllllllllllllIIllIIlIIIlllIlIII */
        //    26: getstatic       net/minecraft/nbt/NBTSizeTracker.INFINITE:Lnet/minecraft/nbt/NBTSizeTracker;
        //    29: invokestatic    net/minecraft/nbt/CompressedStreamTools.func_152456_a:(Ljava/io/DataInput;Lnet/minecraft/nbt/NBTSizeTracker;)Lnet/minecraft/nbt/NBTTagCompound;
        //    32: astore_2        /* llllllllllllllIIllIIlIIIlllIIIll */
        //    33: goto            43
        //    36: astore_3        /* llllllllllllllIIllIIlIIIlllIIIlI */
        //    37: aload_1         /* llllllllllllllIIllIIlIIIlllIlIII */
        //    38: invokevirtual   java/io/DataInputStream.close:()V
        //    41: aload_3         /* llllllllllllllIIllIIlIIIlllIIIlI */
        //    42: athrow         
        //    43: aload_1         /* llllllllllllllIIllIIlIIIlllIlIII */
        //    44: invokevirtual   java/io/DataInputStream.close:()V
        //    47: aload_2         /* llllllllllllllIIllIIlIIIlllIIllI */
        //    48: areturn        
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 03 09 FF 00 1A 00 02 07 00 B2 07 00 B8 00 01 07 00 AA FC 00 06 07 00 A6
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  25     36     36     43     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static NBTTagCompound read(final DataInputStream llllllllllllllIIllIIlIIIlllIIIII) throws IOException {
        return func_152456_a(llllllllllllllIIllIIlIIIlllIIIII, NBTSizeTracker.INFINITE);
    }
    
    public static void safeWrite(final NBTTagCompound llllllllllllllIIllIIlIIIlllllIll, final File llllllllllllllIIllIIlIIIllllllIl) throws IOException {
        final File llllllllllllllIIllIIlIIIllllllII = new File(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIllIIlIIIllllllIl.getAbsolutePath())).append("_tmp")));
        if (llllllllllllllIIllIIlIIIllllllII.exists()) {
            llllllllllllllIIllIIlIIIllllllII.delete();
        }
        write(llllllllllllllIIllIIlIIIlllllIll, llllllllllllllIIllIIlIIIllllllII);
        if (llllllllllllllIIllIIlIIIllllllIl.exists()) {
            llllllllllllllIIllIIlIIIllllllIl.delete();
        }
        if (llllllllllllllIIllIIlIIIllllllIl.exists()) {
            throw new IOException(String.valueOf(new StringBuilder("Failed to delete ").append(llllllllllllllIIllIIlIIIllllllIl)));
        }
        llllllllllllllIIllIIlIIIllllllII.renameTo(llllllllllllllIIllIIlIIIllllllIl);
    }
    
    public static void write(final NBTTagCompound llllllllllllllIIllIIlIIIllIlIIIl, final DataOutput llllllllllllllIIllIIlIIIllIlIIlI) throws IOException {
        writeTag(llllllllllllllIIllIIlIIIllIlIIIl, llllllllllllllIIllIIlIIIllIlIIlI);
    }
    
    public static NBTTagCompound func_152456_a(final DataInput llllllllllllllIIllIIlIIIllIllIII, final NBTSizeTracker llllllllllllllIIllIIlIIIllIllIlI) throws IOException {
        final NBTBase llllllllllllllIIllIIlIIIllIllIIl = func_152455_a(llllllllllllllIIllIIlIIIllIllIII, 0, llllllllllllllIIllIIlIIIllIllIlI);
        if (llllllllllllllIIllIIlIIIllIllIIl instanceof NBTTagCompound) {
            return (NBTTagCompound)llllllllllllllIIllIIlIIIllIllIIl;
        }
        throw new IOException("Root tag must be a named compound tag");
    }
    
    public static void write(final NBTTagCompound llllllllllllllIIllIIlIIIllllIlII, final File llllllllllllllIIllIIlIIIllllIIII) throws IOException {
        final DataOutputStream llllllllllllllIIllIIlIIIllllIIlI = new DataOutputStream(new FileOutputStream(llllllllllllllIIllIIlIIIllllIIII));
        try {
            write(llllllllllllllIIllIIlIIIllllIlII, llllllllllllllIIllIIlIIIllllIIlI);
        }
        finally {
            llllllllllllllIIllIIlIIIllllIIlI.close();
        }
        llllllllllllllIIllIIlIIIllllIIlI.close();
    }
    
    public static NBTTagCompound readCompressed(final InputStream llllllllllllllIIllIIlIIlIIIlIlII) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: new             Ljava/io/BufferedInputStream;
        //     7: dup            
        //     8: new             Ljava/util/zip/GZIPInputStream;
        //    11: dup            
        //    12: aload_0         /* llllllllllllllIIllIIlIIlIIIlIIII */
        //    13: invokespecial   java/util/zip/GZIPInputStream.<init>:(Ljava/io/InputStream;)V
        //    16: invokespecial   java/io/BufferedInputStream.<init>:(Ljava/io/InputStream;)V
        //    19: invokespecial   java/io/DataInputStream.<init>:(Ljava/io/InputStream;)V
        //    22: astore_1        /* llllllllllllllIIllIIlIIlIIIlIIll */
        //    23: aload_1         /* llllllllllllllIIllIIlIIlIIIlIIll */
        //    24: getstatic       net/minecraft/nbt/NBTSizeTracker.INFINITE:Lnet/minecraft/nbt/NBTSizeTracker;
        //    27: invokestatic    net/minecraft/nbt/CompressedStreamTools.func_152456_a:(Ljava/io/DataInput;Lnet/minecraft/nbt/NBTSizeTracker;)Lnet/minecraft/nbt/NBTTagCompound;
        //    30: astore_2        /* llllllllllllllIIllIIlIIlIIIlIIlI */
        //    31: goto            41
        //    34: astore_3        /* llllllllllllllIIllIIlIIlIIIIllIl */
        //    35: aload_1         /* llllllllllllllIIllIIlIIlIIIlIIll */
        //    36: invokevirtual   java/io/DataInputStream.close:()V
        //    39: aload_3         /* llllllllllllllIIllIIlIIlIIIIllIl */
        //    40: athrow         
        //    41: aload_1         /* llllllllllllllIIllIIlIIlIIIlIIll */
        //    42: invokevirtual   java/io/DataInputStream.close:()V
        //    45: aload_2         /* llllllllllllllIIllIIlIIlIIIlIIIl */
        //    46: areturn        
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 02 FF 00 22 00 02 07 01 2D 07 00 B8 00 01 07 00 AA FC 00 06 07 00 A6
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  23     34     34     41     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
}
