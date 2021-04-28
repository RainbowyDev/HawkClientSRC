package net.minecraft.nbt;

import com.google.common.collect.*;
import org.apache.logging.log4j.*;
import java.util.*;
import java.io.*;

public class NBTTagList extends NBTBase
{
    private /* synthetic */ List tagList;
    private static final /* synthetic */ Logger LOGGER;
    private /* synthetic */ byte tagType;
    
    public void appendTag(final NBTBase llllllllllllllllIIIIlIIIIlIIllll) {
        if (this.tagType == 0) {
            this.tagType = llllllllllllllllIIIIlIIIIlIIllll.getId();
        }
        else if (this.tagType != llllllllllllllllIIIIlIIIIlIIllll.getId()) {
            NBTTagList.LOGGER.warn("Adding mismatching tag types to tag list");
            return;
        }
        this.tagList.add(llllllllllllllllIIIIlIIIIlIIllll);
    }
    
    @Override
    public boolean equals(final Object llllllllllllllllIIIIIlllllllIIII) {
        if (super.equals(llllllllllllllllIIIIIlllllllIIII)) {
            final NBTTagList llllllllllllllllIIIIIlllllllIIlI = (NBTTagList)llllllllllllllllIIIIIlllllllIIII;
            if (this.tagType == llllllllllllllllIIIIIlllllllIIlI.tagType) {
                return this.tagList.equals(llllllllllllllllIIIIIlllllllIIlI.tagList);
            }
        }
        return false;
    }
    
    @Override
    void read(final DataInput llllllllllllllllIIIIlIIIIllIlIlI, final int llllllllllllllllIIIIlIIIIlllIIII, final NBTSizeTracker llllllllllllllllIIIIlIIIIllIllll) throws IOException {
        if (llllllllllllllllIIIIlIIIIlllIIII > 512) {
            throw new RuntimeException("Tried to read NBT tag with too high complexity, depth > 512");
        }
        llllllllllllllllIIIIlIIIIllIllll.read(8L);
        this.tagType = llllllllllllllllIIIIlIIIIllIlIlI.readByte();
        final int llllllllllllllllIIIIlIIIIllIlllI = llllllllllllllllIIIIlIIIIllIlIlI.readInt();
        this.tagList = Lists.newArrayList();
        for (int llllllllllllllllIIIIlIIIIllIllIl = 0; llllllllllllllllIIIIlIIIIllIllIl < llllllllllllllllIIIIlIIIIllIlllI; ++llllllllllllllllIIIIlIIIIllIllIl) {
            final NBTBase llllllllllllllllIIIIlIIIIllIllII = NBTBase.createNewByType(this.tagType);
            llllllllllllllllIIIIlIIIIllIllII.read(llllllllllllllllIIIIlIIIIllIlIlI, llllllllllllllllIIIIlIIIIlllIIII + 1, llllllllllllllllIIIIlIIIIllIllll);
            this.tagList.add(llllllllllllllllIIIIlIIIIllIllII);
        }
    }
    
    static {
        __OBFID = "CL_00001224";
        LOGGER = LogManager.getLogger();
    }
    
    public int[] getIntArray(final int llllllllllllllllIIIIlIIIIIlIllll) {
        if (llllllllllllllllIIIIlIIIIIlIllll >= 0 && llllllllllllllllIIIIlIIIIIlIllll < this.tagList.size()) {
            final NBTBase llllllllllllllllIIIIlIIIIIlIlllI = this.tagList.get(llllllllllllllllIIIIlIIIIIlIllll);
            return (llllllllllllllllIIIIlIIIIIlIlllI.getId() == 11) ? ((NBTTagIntArray)llllllllllllllllIIIIlIIIIIlIlllI).getIntArray() : new int[0];
        }
        return new int[0];
    }
    
    public NBTBase get(final int llllllllllllllllIIIIlIIIIIIIllII) {
        return (llllllllllllllllIIIIlIIIIIIIllII >= 0 && llllllllllllllllIIIIlIIIIIIIllII < this.tagList.size()) ? this.tagList.get(llllllllllllllllIIIIlIIIIIIIllII) : new NBTTagEnd();
    }
    
    public double getDouble(final int llllllllllllllllIIIIlIIIIIlIIllI) {
        if (llllllllllllllllIIIIlIIIIIlIIllI >= 0 && llllllllllllllllIIIIlIIIIIlIIllI < this.tagList.size()) {
            final NBTBase llllllllllllllllIIIIlIIIIIlIIlIl = this.tagList.get(llllllllllllllllIIIIlIIIIIlIIllI);
            return (llllllllllllllllIIIIlIIIIIlIIlIl.getId() == 6) ? ((NBTTagDouble)llllllllllllllllIIIIlIIIIIlIIlIl).getDouble() : 0.0;
        }
        return 0.0;
    }
    
    @Override
    public String toString() {
        String llllllllllllllllIIIIlIIIIlIlllIl = "[";
        int llllllllllllllllIIIIlIIIIlIlllII = 0;
        for (final NBTBase llllllllllllllllIIIIlIIIIlIllIlI : this.tagList) {
            llllllllllllllllIIIIlIIIIlIlllIl = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIIIIlIIIIlIlllIl)).append(llllllllllllllllIIIIlIIIIlIlllII).append(':').append(llllllllllllllllIIIIlIIIIlIllIlI).append(','));
            ++llllllllllllllllIIIIlIIIIlIlllII;
        }
        return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIIIIlIIIIlIlllIl)).append("]"));
    }
    
    @Override
    public int hashCode() {
        return super.hashCode() ^ this.tagList.hashCode();
    }
    
    public String getStringTagAt(final int llllllllllllllllIIIIlIIIIIIlIlII) {
        if (llllllllllllllllIIIIlIIIIIIlIlII >= 0 && llllllllllllllllIIIIlIIIIIIlIlII < this.tagList.size()) {
            final NBTBase llllllllllllllllIIIIlIIIIIIlIIll = this.tagList.get(llllllllllllllllIIIIlIIIIIIlIlII);
            return (llllllllllllllllIIIIlIIIIIIlIIll.getId() == 8) ? llllllllllllllllIIIIlIIIIIIlIIll.getString() : llllllllllllllllIIIIlIIIIIIlIIll.toString();
        }
        return "";
    }
    
    public int getTagType() {
        return this.tagType;
    }
    
    @Override
    void write(final DataOutput llllllllllllllllIIIIlIIIIllllIll) throws IOException {
        if (!this.tagList.isEmpty()) {
            this.tagType = this.tagList.get(0).getId();
        }
        else {
            this.tagType = 0;
        }
        llllllllllllllllIIIIlIIIIllllIll.writeByte(this.tagType);
        llllllllllllllllIIIIlIIIIllllIll.writeInt(this.tagList.size());
        for (int llllllllllllllllIIIIlIIIIlllllIl = 0; llllllllllllllllIIIIlIIIIlllllIl < this.tagList.size(); ++llllllllllllllllIIIIlIIIIlllllIl) {
            this.tagList.get(llllllllllllllllIIIIlIIIIlllllIl).write(llllllllllllllllIIIIlIIIIllllIll);
        }
    }
    
    public int tagCount() {
        return this.tagList.size();
    }
    
    @Override
    public byte getId() {
        return 9;
    }
    
    @Override
    public boolean hasNoTags() {
        return this.tagList.isEmpty();
    }
    
    public NBTTagList() {
        this.tagList = Lists.newArrayList();
        this.tagType = 0;
    }
    
    public NBTTagCompound getCompoundTagAt(final int llllllllllllllllIIIIlIIIIIllIlIl) {
        if (llllllllllllllllIIIIlIIIIIllIlIl >= 0 && llllllllllllllllIIIIlIIIIIllIlIl < this.tagList.size()) {
            final NBTBase llllllllllllllllIIIIlIIIIIllIlll = this.tagList.get(llllllllllllllllIIIIlIIIIIllIlIl);
            return (NBTTagCompound)((llllllllllllllllIIIIlIIIIIllIlll.getId() == 10) ? llllllllllllllllIIIIlIIIIIllIlll : new NBTTagCompound());
        }
        return new NBTTagCompound();
    }
    
    public void set(final int llllllllllllllllIIIIlIIIIlIIlIlI, final NBTBase llllllllllllllllIIIIlIIIIlIIlIIl) {
        if (llllllllllllllllIIIIlIIIIlIIlIlI >= 0 && llllllllllllllllIIIIlIIIIlIIlIlI < this.tagList.size()) {
            if (this.tagType == 0) {
                this.tagType = llllllllllllllllIIIIlIIIIlIIlIIl.getId();
            }
            else if (this.tagType != llllllllllllllllIIIIlIIIIlIIlIIl.getId()) {
                NBTTagList.LOGGER.warn("Adding mismatching tag types to tag list");
                return;
            }
            this.tagList.set(llllllllllllllllIIIIlIIIIlIIlIlI, llllllllllllllllIIIIlIIIIlIIlIIl);
        }
        else {
            NBTTagList.LOGGER.warn("index out of bounds to set tag in tag list");
        }
    }
    
    public NBTBase removeTag(final int llllllllllllllllIIIIlIIIIlIIIIII) {
        return this.tagList.remove(llllllllllllllllIIIIlIIIIlIIIIII);
    }
    
    public float getFloat(final int llllllllllllllllIIIIlIIIIIIlllIl) {
        if (llllllllllllllllIIIIlIIIIIIlllIl >= 0 && llllllllllllllllIIIIlIIIIIIlllIl < this.tagList.size()) {
            final NBTBase llllllllllllllllIIIIlIIIIIIlllII = this.tagList.get(llllllllllllllllIIIIlIIIIIIlllIl);
            return (llllllllllllllllIIIIlIIIIIIlllII.getId() == 5) ? ((NBTTagFloat)llllllllllllllllIIIIlIIIIIIlllII).getFloat() : 0.0f;
        }
        return 0.0f;
    }
    
    @Override
    public NBTBase copy() {
        final NBTTagList llllllllllllllllIIIIlIIIIIIIIIII = new NBTTagList();
        llllllllllllllllIIIIlIIIIIIIIIII.tagType = this.tagType;
        for (final NBTBase llllllllllllllllIIIIIllllllllllI : this.tagList) {
            final NBTBase llllllllllllllllIIIIIlllllllllIl = llllllllllllllllIIIIIllllllllllI.copy();
            llllllllllllllllIIIIlIIIIIIIIIII.tagList.add(llllllllllllllllIIIIIlllllllllIl);
        }
        return llllllllllllllllIIIIlIIIIIIIIIII;
    }
}
