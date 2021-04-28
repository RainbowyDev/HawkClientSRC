package net.minecraft.nbt;

import net.minecraft.util.*;
import java.io.*;
import net.minecraft.crash.*;
import java.util.*;
import com.google.common.collect.*;
import java.util.concurrent.*;
import org.apache.logging.log4j.*;

public class NBTTagCompound extends NBTBase
{
    private /* synthetic */ Map tagMap;
    
    public short getShort(final String llllllllllllllIIIIIIlllIllIlIlII) {
        try {
            return (short)(this.hasKey(llllllllllllllIIIIIIlllIllIlIlII, 99) ? this.tagMap.get(llllllllllllllIIIIIIlllIllIlIlII).getShort() : 0);
        }
        catch (ClassCastException llllllllllllllIIIIIIlllIllIlIllI) {
            return 0;
        }
    }
    
    public int[] getIntArray(final String llllllllllllllIIIIIIlllIlIIlIlIl) {
        try {
            return this.hasKey(llllllllllllllIIIIIIlllIlIIlIlIl, 11) ? this.tagMap.get(llllllllllllllIIIIIIlllIlIIlIlIl).getIntArray() : new int[0];
        }
        catch (ClassCastException llllllllllllllIIIIIIlllIlIIlIlll) {
            throw new ReportedException(this.createCrashReport(llllllllllllllIIIIIIlllIlIIlIlIl, 11, llllllllllllllIIIIIIlllIlIIlIlll));
        }
    }
    
    public float getFloat(final String llllllllllllllIIIIIIlllIlIlllIIl) {
        try {
            return this.hasKey(llllllllllllllIIIIIIlllIlIlllIIl, 99) ? this.tagMap.get(llllllllllllllIIIIIIlllIlIlllIIl).getFloat() : 0.0f;
        }
        catch (ClassCastException llllllllllllllIIIIIIlllIlIlllIll) {
            return 0.0f;
        }
    }
    
    public NBTTagList getTagList(final String llllllllllllllIIIIIIlllIlIIIIlIl, final int llllllllllllllIIIIIIlllIIlllllll) {
        try {
            if (this.getTagType(llllllllllllllIIIIIIlllIlIIIIlIl) != 9) {
                return new NBTTagList();
            }
            final NBTTagList llllllllllllllIIIIIIlllIlIIIIIll = this.tagMap.get(llllllllllllllIIIIIIlllIlIIIIlIl);
            return (llllllllllllllIIIIIIlllIlIIIIIll.tagCount() > 0 && llllllllllllllIIIIIIlllIlIIIIIll.getTagType() != llllllllllllllIIIIIIlllIIlllllll) ? new NBTTagList() : llllllllllllllIIIIIIlllIlIIIIIll;
        }
        catch (ClassCastException llllllllllllllIIIIIIlllIlIIIIIlI) {
            throw new ReportedException(this.createCrashReport(llllllllllllllIIIIIIlllIlIIIIlIl, 9, llllllllllllllIIIIIIlllIlIIIIIlI));
        }
    }
    
    public boolean hasKey(final String llllllllllllllIIIIIIlllIlllIIlll, final int llllllllllllllIIIIIIlllIlllIlIlI) {
        final byte llllllllllllllIIIIIIlllIlllIlIIl = this.getTagType(llllllllllllllIIIIIIlllIlllIIlll);
        if (llllllllllllllIIIIIIlllIlllIlIIl == llllllllllllllIIIIIIlllIlllIlIlI) {
            return true;
        }
        if (llllllllllllllIIIIIIlllIlllIlIlI != 99) {
            if (llllllllllllllIIIIIIlllIlllIlIIl > 0) {}
            return false;
        }
        return llllllllllllllIIIIIIlllIlllIlIIl == 1 || llllllllllllllIIIIIIlllIlllIlIIl == 2 || llllllllllllllIIIIIIlllIlllIlIIl == 3 || llllllllllllllIIIIIIlllIlllIlIIl == 4 || llllllllllllllIIIIIIlllIlllIlIIl == 5 || llllllllllllllIIIIIIlllIlllIlIIl == 6;
    }
    
    public void merge(final NBTTagCompound llllllllllllllIIIIIIllIlllllllll) {
        for (final String llllllllllllllIIIIIIlllIIIIIIIll : llllllllllllllIIIIIIllIlllllllll.tagMap.keySet()) {
            final NBTBase llllllllllllllIIIIIIlllIIIIIIIlI = llllllllllllllIIIIIIllIlllllllll.tagMap.get(llllllllllllllIIIIIIlllIIIIIIIll);
            if (llllllllllllllIIIIIIlllIIIIIIIlI.getId() == 10) {
                if (this.hasKey(llllllllllllllIIIIIIlllIIIIIIIll, 10)) {
                    final NBTTagCompound llllllllllllllIIIIIIlllIIIIIIIIl = this.getCompoundTag(llllllllllllllIIIIIIlllIIIIIIIll);
                    llllllllllllllIIIIIIlllIIIIIIIIl.merge((NBTTagCompound)llllllllllllllIIIIIIlllIIIIIIIlI);
                }
                else {
                    this.setTag(llllllllllllllIIIIIIlllIIIIIIIll, llllllllllllllIIIIIIlllIIIIIIIlI.copy());
                }
            }
            else {
                this.setTag(llllllllllllllIIIIIIlllIIIIIIIll, llllllllllllllIIIIIIlllIIIIIIIlI.copy());
            }
        }
    }
    
    @Override
    void read(final DataInput llllllllllllllIIIIIIllllllIIlIII, final int llllllllllllllIIIIIIlllllIllllll, final NBTSizeTracker llllllllllllllIIIIIIllllllIIIllI) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     4: if_icmple       17
        //     7: new             Ljava/lang/RuntimeException;
        //    10: dup            
        //    11: ldc             "Tried to read NBT tag with too high complexity, depth > 512"
        //    13: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/String;)V
        //    16: athrow         
        //    17: aload_0         /* llllllllllllllIIIIIIllllllIIlIIl */
        //    18: getfield        net/minecraft/nbt/NBTTagCompound.tagMap:Ljava/util/Map;
        //    21: invokeinterface java/util/Map.clear:()V
        //    26: goto            77
        //    29: aload_1         /* llllllllllllllIIIIIIllllllIIIIII */
        //    30: aload_3         /* llllllllllllllIIIIIIlllllIlllllI */
        //    31: invokestatic    net/minecraft/nbt/NBTTagCompound.readKey:(Ljava/io/DataInput;Lnet/minecraft/nbt/NBTSizeTracker;)Ljava/lang/String;
        //    34: astore          llllllllllllllIIIIIIllllllIIIIll
        //    36: aload_3         /* llllllllllllllIIIIIIlllllIlllllI */
        //    37: bipush          16
        //    39: aload           llllllllllllllIIIIIIllllllIIIIll
        //    41: invokevirtual   java/lang/String.length:()I
        //    44: imul           
        //    45: i2l            
        //    46: invokevirtual   net/minecraft/nbt/NBTSizeTracker.read:(J)V
        //    49: iload           llllllllllllllIIIIIIllllllIIIlIl
        //    51: aload           llllllllllllllIIIIIIllllllIIIIll
        //    53: aload_1         /* llllllllllllllIIIIIIllllllIIIIII */
        //    54: iload_2         /* llllllllllllllIIIIIIllllllIIIlll */
        //    55: iconst_1       
        //    56: iadd           
        //    57: aload_3         /* llllllllllllllIIIIIIlllllIlllllI */
        //    58: invokestatic    net/minecraft/nbt/NBTTagCompound.readNBT:(BLjava/lang/String;Ljava/io/DataInput;ILnet/minecraft/nbt/NBTSizeTracker;)Lnet/minecraft/nbt/NBTBase;
        //    61: astore          llllllllllllllIIIIIIllllllIIIIlI
        //    63: aload_0         /* llllllllllllllIIIIIIllllllIIlIIl */
        //    64: getfield        net/minecraft/nbt/NBTTagCompound.tagMap:Ljava/util/Map;
        //    67: aload           llllllllllllllIIIIIIllllllIIIIll
        //    69: aload           llllllllllllllIIIIIIllllllIIIIlI
        //    71: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    76: pop            
        //    77: aload_1         /* llllllllllllllIIIIIIllllllIIIIII */
        //    78: aload_3         /* llllllllllllllIIIIIIlllllIlllllI */
        //    79: invokestatic    net/minecraft/nbt/NBTTagCompound.readType:(Ljava/io/DataInput;Lnet/minecraft/nbt/NBTSizeTracker;)B
        //    82: dup            
        //    83: istore          llllllllllllllIIIIIIllllllIIIlII
        //    85: ifne            29
        //    88: return         
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 03 11 FC 00 0B 01 FA 00 2F
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    public boolean equals(final Object llllllllllllllIIIIIIlllIIIllllIl) {
        if (super.equals(llllllllllllllIIIIIIlllIIIllllIl)) {
            final NBTTagCompound llllllllllllllIIIIIIlllIIIllllll = (NBTTagCompound)llllllllllllllIIIIIIlllIIIllllIl;
            return this.tagMap.entrySet().equals(llllllllllllllIIIIIIlllIIIllllll.tagMap.entrySet());
        }
        return false;
    }
    
    public void setShort(final String llllllllllllllIIIIIIlllllIIlllII, final short llllllllllllllIIIIIIlllllIIlllll) {
        this.tagMap.put(llllllllllllllIIIIIIlllllIIlllII, new NBTTagShort(llllllllllllllIIIIIIlllllIIlllll));
    }
    
    public void setBoolean(final String llllllllllllllIIIIIIllllIIIIlIlI, final boolean llllllllllllllIIIIIIllllIIIIIllI) {
        this.setByte(llllllllllllllIIIIIIllllIIIIlIlI, (byte)(llllllllllllllIIIIIIllllIIIIIllI ? 1 : 0));
    }
    
    private static void writeEntry(final String llllllllllllllIIIIIIlllIIIllIlIl, final NBTBase llllllllllllllIIIIIIlllIIIllIlII, final DataOutput llllllllllllllIIIIIIlllIIIllIIll) throws IOException {
        llllllllllllllIIIIIIlllIIIllIIll.writeByte(llllllllllllllIIIIIIlllIIIllIlII.getId());
        if (llllllllllllllIIIIIIlllIIIllIlII.getId() != 0) {
            llllllllllllllIIIIIIlllIIIllIIll.writeUTF(llllllllllllllIIIIIIlllIIIllIlIl);
            llllllllllllllIIIIIIlllIIIllIlII.write(llllllllllllllIIIIIIlllIIIllIIll);
        }
    }
    
    public double getDouble(final String llllllllllllllIIIIIIlllIlIllIIII) {
        try {
            return this.hasKey(llllllllllllllIIIIIIlllIlIllIIII, 99) ? this.tagMap.get(llllllllllllllIIIIIIlllIlIllIIII).getDouble() : 0.0;
        }
        catch (ClassCastException llllllllllllllIIIIIIlllIlIllIIlI) {
            return 0.0;
        }
    }
    
    public void setByteArray(final String llllllllllllllIIIIIIllllIIlllIII, final byte[] llllllllllllllIIIIIIllllIIllIIIl) {
        this.tagMap.put(llllllllllllllIIIIIIllllIIlllIII, new NBTTagByteArray(llllllllllllllIIIIIIllllIIllIIIl));
    }
    
    public void removeTag(final String llllllllllllllIIIIIIlllIIlllIlII) {
        this.tagMap.remove(llllllllllllllIIIIIIlllIIlllIlII);
    }
    
    private static byte readType(final DataInput llllllllllllllIIIIIIlllIIIlIlllI, final NBTSizeTracker llllllllllllllIIIIIIlllIIIlIllIl) throws IOException {
        return llllllllllllllIIIIIIlllIIIlIlllI.readByte();
    }
    
    public void setFloat(final String llllllllllllllIIIIIIllllIlllIIlI, final float llllllllllllllIIIIIIllllIllIllII) {
        this.tagMap.put(llllllllllllllIIIIIIllllIlllIIlI, new NBTTagFloat(llllllllllllllIIIIIIllllIllIllII));
    }
    
    public byte[] getByteArray(final String llllllllllllllIIIIIIlllIlIlIIIIl) {
        try {
            return this.hasKey(llllllllllllllIIIIIIlllIlIlIIIIl, 7) ? this.tagMap.get(llllllllllllllIIIIIIlllIlIlIIIIl).getByteArray() : new byte[0];
        }
        catch (ClassCastException llllllllllllllIIIIIIlllIlIlIIIII) {
            throw new ReportedException(this.createCrashReport(llllllllllllllIIIIIIlllIlIlIIIIl, 7, llllllllllllllIIIIIIlllIlIlIIIII));
        }
    }
    
    static NBTBase readNBT(final byte llllllllllllllIIIIIIlllIIIIllllI, final String llllllllllllllIIIIIIlllIIIIlllIl, final DataInput llllllllllllllIIIIIIlllIIIIlllII, final int llllllllllllllIIIIIIlllIIIIllIll, final NBTSizeTracker llllllllllllllIIIIIIlllIIIIllIlI) {
        final NBTBase llllllllllllllIIIIIIlllIIIIllIIl = NBTBase.createNewByType(llllllllllllllIIIIIIlllIIIIllllI);
        try {
            llllllllllllllIIIIIIlllIIIIllIIl.read(llllllllllllllIIIIIIlllIIIIlllII, llllllllllllllIIIIIIlllIIIIllIll, llllllllllllllIIIIIIlllIIIIllIlI);
            return llllllllllllllIIIIIIlllIIIIllIIl;
        }
        catch (IOException llllllllllllllIIIIIIlllIIIIllIII) {
            final CrashReport llllllllllllllIIIIIIlllIIIIlIlll = CrashReport.makeCrashReport(llllllllllllllIIIIIIlllIIIIllIII, "Loading NBT data");
            final CrashReportCategory llllllllllllllIIIIIIlllIIIIlIllI = llllllllllllllIIIIIIlllIIIIlIlll.makeCategory("NBT Tag");
            llllllllllllllIIIIIIlllIIIIlIllI.addCrashSection("Tag name", llllllllllllllIIIIIIlllIIIIlllIl);
            llllllllllllllIIIIIIlllIIIIlIllI.addCrashSection("Tag type", llllllllllllllIIIIIIlllIIIIllllI);
            throw new ReportedException(llllllllllllllIIIIIIlllIIIIlIlll);
        }
    }
    
    @Override
    public String toString() {
        String llllllllllllllIIIIIIlllIIllIllII = "{";
        for (final String llllllllllllllIIIIIIlllIIllIlIll : this.tagMap.keySet()) {
            llllllllllllllIIIIIIlllIIllIllII = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIIIIlllIIllIllII)).append(llllllllllllllIIIIIIlllIIllIlIll).append(':').append(this.tagMap.get(llllllllllllllIIIIIIlllIIllIlIll)).append(','));
        }
        return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIIIIlllIIllIllII)).append("}"));
    }
    
    public int getInteger(final String llllllllllllllIIIIIIlllIllIIlllI) {
        try {
            return this.hasKey(llllllllllllllIIIIIIlllIllIIlllI, 99) ? this.tagMap.get(llllllllllllllIIIIIIlllIllIIlllI).getInt() : 0;
        }
        catch (ClassCastException llllllllllllllIIIIIIlllIllIIllIl) {
            return 0;
        }
    }
    
    public NBTTagCompound getCompoundTag(final String llllllllllllllIIIIIIlllIlIIIllll) {
        try {
            return this.hasKey(llllllllllllllIIIIIIlllIlIIIllll, 10) ? this.tagMap.get(llllllllllllllIIIIIIlllIlIIIllll) : new NBTTagCompound();
        }
        catch (ClassCastException llllllllllllllIIIIIIlllIlIIIlllI) {
            throw new ReportedException(this.createCrashReport(llllllllllllllIIIIIIlllIlIIIllll, 10, llllllllllllllIIIIIIlllIlIIIlllI));
        }
    }
    
    public void setTag(final String llllllllllllllIIIIIIlllllIllIIlI, final NBTBase llllllllllllllIIIIIIlllllIlIlllI) {
        this.tagMap.put(llllllllllllllIIIIIIlllllIllIIlI, llllllllllllllIIIIIIlllllIlIlllI);
    }
    
    public boolean hasKey(final String llllllllllllllIIIIIIlllIllllIIIl) {
        return this.tagMap.containsKey(llllllllllllllIIIIIIlllIllllIIIl);
    }
    
    private static String readKey(final DataInput llllllllllllllIIIIIIlllIIIlIlIlI, final NBTSizeTracker llllllllllllllIIIIIIlllIIIlIlIIl) throws IOException {
        return llllllllllllllIIIIIIlllIIIlIlIlI.readUTF();
    }
    
    public Set getKeySet() {
        return this.tagMap.keySet();
    }
    
    public NBTBase getTag(final String llllllllllllllIIIIIIllllIIIIIIII) {
        return this.tagMap.get(llllllllllllllIIIIIIllllIIIIIIII);
    }
    
    public NBTTagCompound() {
        this.tagMap = Maps.newHashMap();
    }
    
    public void setLong(final String llllllllllllllIIIIIIlllllIIIIIll, final long llllllllllllllIIIIIIllllIllllIll) {
        this.tagMap.put(llllllllllllllIIIIIIlllllIIIIIll, new NBTTagLong(llllllllllllllIIIIIIllllIllllIll));
    }
    
    @Override
    public byte getId() {
        return 10;
    }
    
    public void setByte(final String llllllllllllllIIIIIIlllllIlIlIIl, final byte llllllllllllllIIIIIIlllllIlIIlIl) {
        this.tagMap.put(llllllllllllllIIIIIIlllllIlIlIIl, new NBTTagByte(llllllllllllllIIIIIIlllllIlIIlIl));
    }
    
    public void setInteger(final String llllllllllllllIIIIIIlllllIIIlllI, final int llllllllllllllIIIIIIlllllIIIllII) {
        this.tagMap.put(llllllllllllllIIIIIIlllllIIIlllI, new NBTTagInt(llllllllllllllIIIIIIlllllIIIllII));
    }
    
    public boolean getBoolean(final String llllllllllllllIIIIIIlllIIllllIlI) {
        return this.getByte(llllllllllllllIIIIIIlllIIllllIlI) != 0;
    }
    
    public void setIntArray(final String llllllllllllllIIIIIIllllIIIlllII, final int[] llllllllllllllIIIIIIllllIIlIIIII) {
        this.tagMap.put(llllllllllllllIIIIIIllllIIIlllII, new NBTTagIntArray(llllllllllllllIIIIIIllllIIlIIIII));
    }
    
    public byte getByte(final String llllllllllllllIIIIIIlllIlllIIIII) {
        try {
            return (byte)(this.hasKey(llllllllllllllIIIIIIlllIlllIIIII, 99) ? this.tagMap.get(llllllllllllllIIIIIIlllIlllIIIII).getByte() : 0);
        }
        catch (ClassCastException llllllllllllllIIIIIIlllIllIlllll) {
            return 0;
        }
    }
    
    public long getLong(final String llllllllllllllIIIIIIlllIllIIIlIl) {
        try {
            return this.hasKey(llllllllllllllIIIIIIlllIllIIIlIl, 99) ? this.tagMap.get(llllllllllllllIIIIIIlllIllIIIlIl).getLong() : 0L;
        }
        catch (ClassCastException llllllllllllllIIIIIIlllIllIIIlII) {
            return 0L;
        }
    }
    
    public void setDouble(final String llllllllllllllIIIIIIllllIlIlllIl, final double llllllllllllllIIIIIIllllIllIIIII) {
        this.tagMap.put(llllllllllllllIIIIIIllllIlIlllIl, new NBTTagDouble(llllllllllllllIIIIIIllllIllIIIII));
    }
    
    @Override
    void write(final DataOutput llllllllllllllIIIIIIllllllIllIIl) throws IOException {
        for (final String llllllllllllllIIIIIIllllllIlIlll : this.tagMap.keySet()) {
            final NBTBase llllllllllllllIIIIIIllllllIlIllI = this.tagMap.get(llllllllllllllIIIIIIllllllIlIlll);
            writeEntry(llllllllllllllIIIIIIllllllIlIlll, llllllllllllllIIIIIIllllllIlIllI, llllllllllllllIIIIIIllllllIllIIl);
        }
        llllllllllllllIIIIIIllllllIllIIl.writeByte(0);
    }
    
    private CrashReport createCrashReport(final String llllllllllllllIIIIIIlllIIlIlIlIl, final int llllllllllllllIIIIIIlllIIlIlIlII, final ClassCastException llllllllllllllIIIIIIlllIIlIlIIll) {
        final CrashReport llllllllllllllIIIIIIlllIIlIllIII = CrashReport.makeCrashReport(llllllllllllllIIIIIIlllIIlIlIIll, "Reading NBT data");
        final CrashReportCategory llllllllllllllIIIIIIlllIIlIlIlll = llllllllllllllIIIIIIlllIIlIllIII.makeCategoryDepth("Corrupt NBT tag", 1);
        llllllllllllllIIIIIIlllIIlIlIlll.addCrashSectionCallable("Tag type found", new Callable() {
            @Override
            public String call() {
                return NBTBase.NBT_TYPES[NBTTagCompound.this.tagMap.get(llllllllllllllIIIIIIlllIIlIlIlIl).getId()];
            }
            
            static {
                __OBFID = "CL_00001216";
            }
        });
        llllllllllllllIIIIIIlllIIlIlIlll.addCrashSectionCallable("Tag type expected", new Callable() {
            static {
                __OBFID = "CL_00001217";
            }
            
            @Override
            public String call() {
                return NBTBase.NBT_TYPES[llllllllllllllIIIIIIlllIIlIlIlII];
            }
        });
        llllllllllllllIIIIIIlllIIlIlIlll.addCrashSection("Tag name", llllllllllllllIIIIIIlllIIlIlIlIl);
        return llllllllllllllIIIIIIlllIIlIllIII;
    }
    
    @Override
    public NBTBase copy() {
        final NBTTagCompound llllllllllllllIIIIIIlllIIlIIlIll = new NBTTagCompound();
        for (final String llllllllllllllIIIIIIlllIIlIIlIIl : this.tagMap.keySet()) {
            llllllllllllllIIIIIIlllIIlIIlIll.setTag(llllllllllllllIIIIIIlllIIlIIlIIl, this.tagMap.get(llllllllllllllIIIIIIlllIIlIIlIIl).copy());
        }
        return llllllllllllllIIIIIIlllIIlIIlIll;
    }
    
    public byte getTagType(final String llllllllllllllIIIIIIlllIlllllIll) {
        final NBTBase llllllllllllllIIIIIIlllIlllllIlI = this.tagMap.get(llllllllllllllIIIIIIlllIlllllIll);
        return (byte)((llllllllllllllIIIIIIlllIlllllIlI != null) ? llllllllllllllIIIIIIlllIlllllIlI.getId() : 0);
    }
    
    public void setString(final String llllllllllllllIIIIIIllllIlIIlllI, final String llllllllllllllIIIIIIllllIlIIlIII) {
        this.tagMap.put(llllllllllllllIIIIIIllllIlIIlllI, new NBTTagString(llllllllllllllIIIIIIllllIlIIlIII));
    }
    
    public String getString(final String llllllllllllllIIIIIIlllIlIlIIlll) {
        try {
            return this.hasKey(llllllllllllllIIIIIIlllIlIlIIlll, 8) ? this.tagMap.get(llllllllllllllIIIIIIlllIlIlIIlll).getString() : "";
        }
        catch (ClassCastException llllllllllllllIIIIIIlllIlIlIlIIl) {
            return "";
        }
    }
    
    static {
        __OBFID = "CL_00001215";
        logger = LogManager.getLogger();
    }
    
    @Override
    public int hashCode() {
        return super.hashCode() ^ this.tagMap.hashCode();
    }
    
    @Override
    public boolean hasNoTags() {
        return this.tagMap.isEmpty();
    }
}
