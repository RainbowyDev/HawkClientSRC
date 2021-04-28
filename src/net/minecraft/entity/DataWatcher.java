package net.minecraft.entity;

import java.util.concurrent.locks.*;
import org.apache.commons.lang3.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import com.google.common.collect.*;
import java.util.*;
import net.minecraft.network.*;
import java.io.*;

public class DataWatcher
{
    private /* synthetic */ ReadWriteLock lock;
    private /* synthetic */ boolean objectChanged;
    private final /* synthetic */ Entity owner;
    private final /* synthetic */ Map watchedObjects;
    private /* synthetic */ boolean isBlank;
    private static final /* synthetic */ Map dataTypes;
    
    public DataWatcher(final Entity llllllllllllllIllllIllIIIlIlIIll) {
        this.isBlank = true;
        this.watchedObjects = Maps.newHashMap();
        this.lock = new ReentrantReadWriteLock();
        this.owner = llllllllllllllIllllIllIIIlIlIIll;
    }
    
    public void updateObject(final int llllllllllllllIllllIlIllllllIIll, final Object llllllllllllllIllllIlIllllllIIlI) {
        final WatchableObject llllllllllllllIllllIlIllllllIIIl = this.getWatchedObject(llllllllllllllIllllIlIllllllIIll);
        if (ObjectUtils.notEqual(llllllllllllllIllllIlIllllllIIlI, llllllllllllllIllllIlIllllllIIIl.getObject())) {
            llllllllllllllIllllIlIllllllIIIl.setObject(llllllllllllllIllllIlIllllllIIlI);
            this.owner.func_145781_i(llllllllllllllIllllIlIllllllIIll);
            llllllllllllllIllllIlIllllllIIIl.setWatched(true);
            this.objectChanged = true;
        }
    }
    
    static {
        __OBFID = "CL_00001559";
        (dataTypes = Maps.newHashMap()).put(Byte.class, 0);
        DataWatcher.dataTypes.put(Short.class, 1);
        DataWatcher.dataTypes.put(Integer.class, 2);
        DataWatcher.dataTypes.put(Float.class, 3);
        DataWatcher.dataTypes.put(String.class, 4);
        DataWatcher.dataTypes.put(ItemStack.class, 5);
        DataWatcher.dataTypes.put(BlockPos.class, 6);
        DataWatcher.dataTypes.put(Rotations.class, 7);
    }
    
    public void addObject(final int llllllllllllllIllllIllIIIlIIlIlI, final Object llllllllllllllIllllIllIIIlIIlIIl) {
        final Integer llllllllllllllIllllIllIIIlIIlIII = DataWatcher.dataTypes.get(llllllllllllllIllllIllIIIlIIlIIl.getClass());
        if (llllllllllllllIllllIllIIIlIIlIII == null) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Unknown data type: ").append(llllllllllllllIllllIllIIIlIIlIIl.getClass())));
        }
        if (llllllllllllllIllllIllIIIlIIlIlI > 31) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Data value id is too big with ").append(llllllllllllllIllllIllIIIlIIlIlI).append("! (Max is ").append(31).append(")")));
        }
        if (this.watchedObjects.containsKey(llllllllllllllIllllIllIIIlIIlIlI)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Duplicate id value for ").append(llllllllllllllIllllIllIIIlIIlIlI).append("!")));
        }
        final WatchableObject llllllllllllllIllllIllIIIlIIIlll = new WatchableObject(llllllllllllllIllllIllIIIlIIlIII, llllllllllllllIllllIllIIIlIIlIlI, llllllllllllllIllllIllIIIlIIlIIl);
        this.lock.writeLock().lock();
        this.watchedObjects.put(llllllllllllllIllllIllIIIlIIlIlI, llllllllllllllIllllIllIIIlIIIlll);
        this.lock.writeLock().unlock();
        this.isBlank = false;
    }
    
    public boolean getIsBlank() {
        return this.isBlank;
    }
    
    private WatchableObject getWatchedObject(final int llllllllllllllIllllIllIIIIIIlIlI) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        net/minecraft/entity/DataWatcher.lock:Ljava/util/concurrent/locks/ReadWriteLock;
        //     4: invokeinterface java/util/concurrent/locks/ReadWriteLock.readLock:()Ljava/util/concurrent/locks/Lock;
        //     9: invokeinterface java/util/concurrent/locks/Lock.lock:()V
        //    14: aload_0         /* llllllllllllllIllllIllIIIIIIlIll */
        //    15: getfield        net/minecraft/entity/DataWatcher.watchedObjects:Ljava/util/Map;
        //    18: iload_1         /* llllllllllllllIllllIllIIIIIIIIll */
        //    19: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    22: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    27: checkcast       Lnet/minecraft/entity/DataWatcher$WatchableObject;
        //    30: astore_2        /* llllllllllllllIllllIllIIIIIIIIlI */
        //    31: goto            73
        //    34: astore_3        /* llllllllllllllIllllIllIIIIIIIlll */
        //    35: aload_3         /* llllllllllllllIllllIllIIIIIIIlll */
        //    36: ldc             "Getting synched entity data"
        //    38: invokestatic    net/minecraft/crash/CrashReport.makeCrashReport:(Ljava/lang/Throwable;Ljava/lang/String;)Lnet/minecraft/crash/CrashReport;
        //    41: astore          llllllllllllllIllllIllIIIIIIIllI
        //    43: aload           llllllllllllllIllllIllIIIIIIIllI
        //    45: ldc             "Synched entity data"
        //    47: invokevirtual   net/minecraft/crash/CrashReport.makeCategory:(Ljava/lang/String;)Lnet/minecraft/crash/CrashReportCategory;
        //    50: astore          llllllllllllllIllllIllIIIIIIIlIl
        //    52: aload           llllllllllllllIllllIllIIIIIIIlIl
        //    54: ldc             "Data ID"
        //    56: iload_1         /* llllllllllllllIllllIllIIIIIIIIll */
        //    57: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    60: invokevirtual   net/minecraft/crash/CrashReportCategory.addCrashSection:(Ljava/lang/String;Ljava/lang/Object;)V
        //    63: new             Lnet/minecraft/util/ReportedException;
        //    66: dup            
        //    67: aload           llllllllllllllIllllIllIIIIIIIllI
        //    69: invokespecial   net/minecraft/util/ReportedException.<init>:(Lnet/minecraft/crash/CrashReport;)V
        //    72: athrow         
        //    73: aload_0         /* llllllllllllllIllllIllIIIIIIlIll */
        //    74: getfield        net/minecraft/entity/DataWatcher.lock:Ljava/util/concurrent/locks/ReadWriteLock;
        //    77: invokeinterface java/util/concurrent/locks/ReadWriteLock.readLock:()Ljava/util/concurrent/locks/Lock;
        //    82: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //    87: aload_2         /* llllllllllllllIllllIllIIIIIIlIII */
        //    88: areturn        
        //    StackMapTable: 00 02 62 07 00 D3 FC 00 26 07 00 06
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  14     31     34     73     Ljava/lang/Throwable;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public void addObjectByDataType(final int llllllllllllllIllllIllIIIIlllIII, final int llllllllllllllIllllIllIIIIlllIll) {
        final WatchableObject llllllllllllllIllllIllIIIIlllIlI = new WatchableObject(llllllllllllllIllllIllIIIIlllIll, llllllllllllllIllllIllIIIIlllIII, null);
        this.lock.writeLock().lock();
        this.watchedObjects.put(llllllllllllllIllllIllIIIIlllIII, llllllllllllllIllllIllIIIIlllIlI);
        this.lock.writeLock().unlock();
        this.isBlank = false;
    }
    
    public float getWatchableObjectFloat(final int llllllllllllllIllllIllIIIIIllllI) {
        return (float)this.getWatchedObject(llllllllllllllIllllIllIIIIIllllI).getObject();
    }
    
    public List getAllWatched() {
        ArrayList llllllllllllllIllllIlIlllIlllIlI = null;
        this.lock.readLock().lock();
        for (final WatchableObject llllllllllllllIllllIlIlllIlllIIl : this.watchedObjects.values()) {
            if (llllllllllllllIllllIlIlllIlllIlI == null) {
                llllllllllllllIllllIlIlllIlllIlI = Lists.newArrayList();
            }
            llllllllllllllIllllIlIlllIlllIlI.add(llllllllllllllIllllIlIlllIlllIIl);
        }
        this.lock.readLock().unlock();
        return llllllllllllllIllllIlIlllIlllIlI;
    }
    
    public static List readWatchedListFromPacketBuffer(final PacketBuffer llllllllllllllIllllIlIlllIIlIlIl) throws IOException {
        ArrayList llllllllllllllIllllIlIlllIIlIlII = null;
        for (byte llllllllllllllIllllIlIlllIIlIIll = llllllllllllllIllllIlIlllIIlIlIl.readByte(); llllllllllllllIllllIlIlllIIlIIll != 127; llllllllllllllIllllIlIlllIIlIIll = llllllllllllllIllllIlIlllIIlIlIl.readByte()) {
            if (llllllllllllllIllllIlIlllIIlIlII == null) {
                llllllllllllllIllllIlIlllIIlIlII = Lists.newArrayList();
            }
            final int llllllllllllllIllllIlIlllIIlIIlI = (llllllllllllllIllllIlIlllIIlIIll & 0xE0) >> 5;
            final int llllllllllllllIllllIlIlllIIlIIIl = llllllllllllllIllllIlIlllIIlIIll & 0x1F;
            WatchableObject llllllllllllllIllllIlIlllIIlIIII = null;
            switch (llllllllllllllIllllIlIlllIIlIIlI) {
                case 0: {
                    llllllllllllllIllllIlIlllIIlIIII = new WatchableObject(llllllllllllllIllllIlIlllIIlIIlI, llllllllllllllIllllIlIlllIIlIIIl, llllllllllllllIllllIlIlllIIlIlIl.readByte());
                    break;
                }
                case 1: {
                    llllllllllllllIllllIlIlllIIlIIII = new WatchableObject(llllllllllllllIllllIlIlllIIlIIlI, llllllllllllllIllllIlIlllIIlIIIl, llllllllllllllIllllIlIlllIIlIlIl.readShort());
                    break;
                }
                case 2: {
                    llllllllllllllIllllIlIlllIIlIIII = new WatchableObject(llllllllllllllIllllIlIlllIIlIIlI, llllllllllllllIllllIlIlllIIlIIIl, llllllllllllllIllllIlIlllIIlIlIl.readInt());
                    break;
                }
                case 3: {
                    llllllllllllllIllllIlIlllIIlIIII = new WatchableObject(llllllllllllllIllllIlIlllIIlIIlI, llllllllllllllIllllIlIlllIIlIIIl, llllllllllllllIllllIlIlllIIlIlIl.readFloat());
                    break;
                }
                case 4: {
                    llllllllllllllIllllIlIlllIIlIIII = new WatchableObject(llllllllllllllIllllIlIlllIIlIIlI, llllllllllllllIllllIlIlllIIlIIIl, llllllllllllllIllllIlIlllIIlIlIl.readStringFromBuffer(32767));
                    break;
                }
                case 5: {
                    llllllllllllllIllllIlIlllIIlIIII = new WatchableObject(llllllllllllllIllllIlIlllIIlIIlI, llllllllllllllIllllIlIlllIIlIIIl, llllllllllllllIllllIlIlllIIlIlIl.readItemStackFromBuffer());
                    break;
                }
                case 6: {
                    final int llllllllllllllIllllIlIlllIIIllll = llllllllllllllIllllIlIlllIIlIlIl.readInt();
                    final int llllllllllllllIllllIlIlllIIIlllI = llllllllllllllIllllIlIlllIIlIlIl.readInt();
                    final int llllllllllllllIllllIlIlllIIIllIl = llllllllllllllIllllIlIlllIIlIlIl.readInt();
                    llllllllllllllIllllIlIlllIIlIIII = new WatchableObject(llllllllllllllIllllIlIlllIIlIIlI, llllllllllllllIllllIlIlllIIlIIIl, new BlockPos(llllllllllllllIllllIlIlllIIIllll, llllllllllllllIllllIlIlllIIIlllI, llllllllllllllIllllIlIlllIIIllIl));
                    break;
                }
                case 7: {
                    final float llllllllllllllIllllIlIlllIIIllII = llllllllllllllIllllIlIlllIIlIlIl.readFloat();
                    final float llllllllllllllIllllIlIlllIIIlIll = llllllllllllllIllllIlIlllIIlIlIl.readFloat();
                    final float llllllllllllllIllllIlIlllIIIlIlI = llllllllllllllIllllIlIlllIIlIlIl.readFloat();
                    llllllllllllllIllllIlIlllIIlIIII = new WatchableObject(llllllllllllllIllllIlIlllIIlIIlI, llllllllllllllIllllIlIlllIIlIIIl, new Rotations(llllllllllllllIllllIlIlllIIIllII, llllllllllllllIllllIlIlllIIIlIll, llllllllllllllIllllIlIlllIIIlIlI));
                    break;
                }
            }
            llllllllllllllIllllIlIlllIIlIlII.add(llllllllllllllIllllIlIlllIIlIIII);
        }
        return llllllllllllllIllllIlIlllIIlIlII;
    }
    
    public byte getWatchableObjectByte(final int llllllllllllllIllllIllIIIIllIIlI) {
        return (byte)this.getWatchedObject(llllllllllllllIllllIllIIIIllIIlI).getObject();
    }
    
    public ItemStack getWatchableObjectItemStack(final int llllllllllllllIllllIllIIIIIlIIlI) {
        return (ItemStack)this.getWatchedObject(llllllllllllllIllllIllIIIIIlIIlI).getObject();
    }
    
    public boolean hasObjectChanged() {
        return this.objectChanged;
    }
    
    public int getWatchableObjectInt(final int llllllllllllllIllllIllIIIIlIIlII) {
        return (int)this.getWatchedObject(llllllllllllllIllllIllIIIIlIIlII).getObject();
    }
    
    public Rotations getWatchableObjectRotations(final int llllllllllllllIllllIlIlllllllIll) {
        return (Rotations)this.getWatchedObject(llllllllllllllIllllIlIlllllllIll).getObject();
    }
    
    public void updateWatchedObjectsFromList(final List llllllllllllllIllllIlIllIlllIIlI) {
        this.lock.writeLock().lock();
        for (final WatchableObject llllllllllllllIllllIlIllIlllIlIl : llllllllllllllIllllIlIllIlllIIlI) {
            final WatchableObject llllllllllllllIllllIlIllIlllIlII = this.watchedObjects.get(llllllllllllllIllllIlIllIlllIlIl.getDataValueId());
            if (llllllllllllllIllllIlIllIlllIlII != null) {
                llllllllllllllIllllIlIllIlllIlII.setObject(llllllllllllllIllllIlIllIlllIlIl.getObject());
                this.owner.func_145781_i(llllllllllllllIllllIlIllIlllIlIl.getDataValueId());
            }
        }
        this.lock.writeLock().unlock();
        this.objectChanged = true;
    }
    
    public static void writeWatchedListToPacketBuffer(final List llllllllllllllIllllIlIllllIllIll, final PacketBuffer llllllllllllllIllllIlIllllIllIlI) throws IOException {
        if (llllllllllllllIllllIlIllllIllIll != null) {
            for (final WatchableObject llllllllllllllIllllIlIllllIlllII : llllllllllllllIllllIlIllllIllIll) {
                writeWatchableObjectToPacketBuffer(llllllllllllllIllllIlIllllIllIlI, llllllllllllllIllllIlIllllIlllII);
            }
        }
        llllllllllllllIllllIlIllllIllIlI.writeByte(127);
    }
    
    public void writeTo(final PacketBuffer llllllllllllllIllllIlIllllIIIllI) throws IOException {
        this.lock.readLock().lock();
        for (final WatchableObject llllllllllllllIllllIlIllllIIIlII : this.watchedObjects.values()) {
            writeWatchableObjectToPacketBuffer(llllllllllllllIllllIlIllllIIIllI, llllllllllllllIllllIlIllllIIIlII);
        }
        this.lock.readLock().unlock();
        llllllllllllllIllllIlIllllIIIllI.writeByte(127);
    }
    
    public short getWatchableObjectShort(final int llllllllllllllIllllIllIIIIlIlIlI) {
        return (short)this.getWatchedObject(llllllllllllllIllllIllIIIIlIlIlI).getObject();
    }
    
    public List getChanged() {
        ArrayList llllllllllllllIllllIlIllllIlIIlI = null;
        if (this.objectChanged) {
            this.lock.readLock().lock();
            for (final WatchableObject llllllllllllllIllllIlIllllIlIIII : this.watchedObjects.values()) {
                if (llllllllllllllIllllIlIllllIlIIII.isWatched()) {
                    llllllllllllllIllllIlIllllIlIIII.setWatched(false);
                    if (llllllllllllllIllllIlIllllIlIIlI == null) {
                        llllllllllllllIllllIlIllllIlIIlI = Lists.newArrayList();
                    }
                    llllllllllllllIllllIlIllllIlIIlI.add(llllllllllllllIllllIlIllllIlIIII);
                }
            }
            this.lock.readLock().unlock();
        }
        this.objectChanged = false;
        return llllllllllllllIllllIlIllllIlIIlI;
    }
    
    public String getWatchableObjectString(final int llllllllllllllIllllIllIIIIIllIII) {
        return (String)this.getWatchedObject(llllllllllllllIllllIllIIIIIllIII).getObject();
    }
    
    public void setObjectWatched(final int llllllllllllllIllllIlIlllllIlIIl) {
        WatchableObject.access$0(this.getWatchedObject(llllllllllllllIllllIlIlllllIlIIl), true);
        this.objectChanged = true;
    }
    
    public void func_111144_e() {
        this.objectChanged = false;
    }
    
    private static void writeWatchableObjectToPacketBuffer(final PacketBuffer llllllllllllllIllllIlIlllIlIIlll, final WatchableObject llllllllllllllIllllIlIlllIlIllII) throws IOException {
        final int llllllllllllllIllllIlIlllIlIlIll = (llllllllllllllIllllIlIlllIlIllII.getObjectType() << 5 | (llllllllllllllIllllIlIlllIlIllII.getDataValueId() & 0x1F)) & 0xFF;
        llllllllllllllIllllIlIlllIlIIlll.writeByte(llllllllllllllIllllIlIlllIlIlIll);
        switch (llllllllllllllIllllIlIlllIlIllII.getObjectType()) {
            case 0: {
                llllllllllllllIllllIlIlllIlIIlll.writeByte((byte)llllllllllllllIllllIlIlllIlIllII.getObject());
                break;
            }
            case 1: {
                llllllllllllllIllllIlIlllIlIIlll.writeShort((short)llllllllllllllIllllIlIlllIlIllII.getObject());
                break;
            }
            case 2: {
                llllllllllllllIllllIlIlllIlIIlll.writeInt((int)llllllllllllllIllllIlIlllIlIllII.getObject());
                break;
            }
            case 3: {
                llllllllllllllIllllIlIlllIlIIlll.writeFloat((float)llllllllllllllIllllIlIlllIlIllII.getObject());
                break;
            }
            case 4: {
                llllllllllllllIllllIlIlllIlIIlll.writeString((String)llllllllllllllIllllIlIlllIlIllII.getObject());
                break;
            }
            case 5: {
                final ItemStack llllllllllllllIllllIlIlllIlIlIlI = (ItemStack)llllllllllllllIllllIlIlllIlIllII.getObject();
                llllllllllllllIllllIlIlllIlIIlll.writeItemStackToBuffer(llllllllllllllIllllIlIlllIlIlIlI);
                break;
            }
            case 6: {
                final BlockPos llllllllllllllIllllIlIlllIlIlIIl = (BlockPos)llllllllllllllIllllIlIlllIlIllII.getObject();
                llllllllllllllIllllIlIlllIlIIlll.writeInt(llllllllllllllIllllIlIlllIlIlIIl.getX());
                llllllllllllllIllllIlIlllIlIIlll.writeInt(llllllllllllllIllllIlIlllIlIlIIl.getY());
                llllllllllllllIllllIlIlllIlIIlll.writeInt(llllllllllllllIllllIlIlllIlIlIIl.getZ());
                break;
            }
            case 7: {
                final Rotations llllllllllllllIllllIlIlllIlIlIII = (Rotations)llllllllllllllIllllIlIlllIlIllII.getObject();
                llllllllllllllIllllIlIlllIlIIlll.writeFloat(llllllllllllllIllllIlIlllIlIlIII.func_179415_b());
                llllllllllllllIllllIlIlllIlIIlll.writeFloat(llllllllllllllIllllIlIlllIlIlIII.func_179416_c());
                llllllllllllllIllllIlIlllIlIIlll.writeFloat(llllllllllllllIllllIlIlllIlIlIII.func_179413_d());
                break;
            }
        }
    }
    
    public static class WatchableObject
    {
        private final /* synthetic */ int objectType;
        private /* synthetic */ boolean watched;
        private /* synthetic */ Object watchedObject;
        private final /* synthetic */ int dataValueId;
        
        public int getDataValueId() {
            return this.dataValueId;
        }
        
        public boolean isWatched() {
            return this.watched;
        }
        
        static {
            __OBFID = "CL_00001560";
        }
        
        public Object getObject() {
            return this.watchedObject;
        }
        
        public int getObjectType() {
            return this.objectType;
        }
        
        public void setObject(final Object llllllllllllllIllllIllllIlIlIIII) {
            this.watchedObject = llllllllllllllIllllIllllIlIlIIII;
        }
        
        public void setWatched(final boolean llllllllllllllIllllIllllIlIIIIll) {
            this.watched = llllllllllllllIllllIllllIlIIIIll;
        }
        
        public WatchableObject(final int llllllllllllllIllllIllllIlIlllll, final int llllllllllllllIllllIllllIlIllllI, final Object llllllllllllllIllllIllllIlIlllIl) {
            this.dataValueId = llllllllllllllIllllIllllIlIllllI;
            this.watchedObject = llllllllllllllIllllIllllIlIlllIl;
            this.objectType = llllllllllllllIllllIllllIlIlllll;
            this.watched = true;
        }
        
        static /* synthetic */ void access$0(final WatchableObject llllllllllllllIllllIllllIIlllllI, final boolean llllllllllllllIllllIllllIIllllIl) {
            llllllllllllllIllllIllllIIlllllI.watched = llllllllllllllIllllIllllIIllllIl;
        }
    }
}
