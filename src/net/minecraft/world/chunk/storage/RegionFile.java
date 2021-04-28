package net.minecraft.world.chunk.storage;

import java.util.*;
import net.minecraft.server.*;
import com.google.common.collect.*;
import java.util.zip.*;
import java.io.*;

public class RegionFile
{
    private /* synthetic */ long lastModified;
    private final /* synthetic */ int[] offsets;
    private final /* synthetic */ int[] chunkTimestamps;
    private static final /* synthetic */ byte[] emptySector;
    private /* synthetic */ RandomAccessFile dataFile;
    private /* synthetic */ int sizeDelta;
    private /* synthetic */ List sectorFree;
    private final /* synthetic */ File fileName;
    
    public void close() throws IOException {
        if (this.dataFile != null) {
            this.dataFile.close();
        }
    }
    
    public boolean isChunkSaved(final int lllIlIIIlllll, final int lllIlIIIllllI) {
        return this.getOffset(lllIlIIIlllll, lllIlIIIllllI) != 0;
    }
    
    public DataOutputStream getChunkDataOutputStream(final int lllIlIllIlIII, final int lllIlIllIlIlI) {
        DataOutputStream dataOutputStream;
        if (this.outOfBounds(lllIlIllIlIII, lllIlIllIlIlI)) {
            dataOutputStream = null;
        }
        else {
            final DeflaterOutputStream deflaterOutputStream;
            dataOutputStream = new DataOutputStream(deflaterOutputStream);
            deflaterOutputStream = new DeflaterOutputStream(new ChunkBuffer(lllIlIllIlIII, lllIlIllIlIlI));
        }
        return dataOutputStream;
    }
    
    private boolean outOfBounds(final int lllIlIIlIlllI, final int lllIlIIlIllll) {
        return lllIlIIlIlllI < 0 || lllIlIIlIlllI >= 32 || lllIlIIlIllll < 0 || lllIlIIlIllll >= 32;
    }
    
    protected synchronized void write(final int lllIlIlIllIIl, final int lllIlIlIIlIIl, final byte[] lllIlIlIlIlll, final int lllIlIlIlIllI) {
        try {
            final int lllIlIlIlIlIl = this.getOffset(lllIlIlIllIIl, lllIlIlIIlIIl);
            int lllIlIlIlIlII = lllIlIlIlIlIl >> 8;
            final int lllIlIlIlIIll = lllIlIlIlIlIl & 0xFF;
            final int lllIlIlIlIIlI = (lllIlIlIlIllI + 5) / 4096 + 1;
            if (lllIlIlIlIIlI >= 256) {
                return;
            }
            if (lllIlIlIlIlII != 0 && lllIlIlIlIIll == lllIlIlIlIIlI) {
                this.write(lllIlIlIlIlII, lllIlIlIlIlll, lllIlIlIlIllI);
            }
            else {
                for (int lllIlIlIlIIIl = 0; lllIlIlIlIIIl < lllIlIlIlIIll; ++lllIlIlIlIIIl) {
                    this.sectorFree.set(lllIlIlIlIlII + lllIlIlIlIIIl, true);
                }
                int lllIlIlIlIIIl = this.sectorFree.indexOf(true);
                int lllIlIlIlIIII = 0;
                if (lllIlIlIlIIIl != -1) {
                    for (int lllIlIlIIllll = lllIlIlIlIIIl; lllIlIlIIllll < this.sectorFree.size(); ++lllIlIlIIllll) {
                        if (lllIlIlIlIIII != 0) {
                            if (this.sectorFree.get(lllIlIlIIllll)) {
                                ++lllIlIlIlIIII;
                            }
                            else {
                                lllIlIlIlIIII = 0;
                            }
                        }
                        else if (this.sectorFree.get(lllIlIlIIllll)) {
                            lllIlIlIlIIIl = lllIlIlIIllll;
                            lllIlIlIlIIII = 1;
                        }
                        if (lllIlIlIlIIII >= lllIlIlIlIIlI) {
                            break;
                        }
                    }
                }
                if (lllIlIlIlIIII >= lllIlIlIlIIlI) {
                    lllIlIlIlIlII = lllIlIlIlIIIl;
                    this.setOffset(lllIlIlIllIIl, lllIlIlIIlIIl, lllIlIlIlIIIl << 8 | lllIlIlIlIIlI);
                    for (int lllIlIlIIlllI = 0; lllIlIlIIlllI < lllIlIlIlIIlI; ++lllIlIlIIlllI) {
                        this.sectorFree.set(lllIlIlIlIlII + lllIlIlIIlllI, false);
                    }
                    this.write(lllIlIlIlIlII, lllIlIlIlIlll, lllIlIlIlIllI);
                }
                else {
                    this.dataFile.seek(this.dataFile.length());
                    lllIlIlIlIlII = this.sectorFree.size();
                    for (int lllIlIlIIllIl = 0; lllIlIlIIllIl < lllIlIlIlIIlI; ++lllIlIlIIllIl) {
                        this.dataFile.write(RegionFile.emptySector);
                        this.sectorFree.add(false);
                    }
                    this.sizeDelta += 4096 * lllIlIlIlIIlI;
                    this.write(lllIlIlIlIlII, lllIlIlIlIlll, lllIlIlIlIllI);
                    this.setOffset(lllIlIlIllIIl, lllIlIlIIlIIl, lllIlIlIlIlII << 8 | lllIlIlIlIIlI);
                }
            }
            this.setChunkTimestamp(lllIlIlIllIIl, lllIlIlIIlIIl, (int)(MinecraftServer.getCurrentTimeMillis() / 1000L));
        }
        catch (IOException lllIlIlIIllII) {
            lllIlIlIIllII.printStackTrace();
        }
    }
    
    public RegionFile(final File lllIllIIllIll) {
        this.offsets = new int[1024];
        this.chunkTimestamps = new int[1024];
        this.fileName = lllIllIIllIll;
        this.sizeDelta = 0;
        try {
            if (lllIllIIllIll.exists()) {
                this.lastModified = lllIllIIllIll.lastModified();
            }
            this.dataFile = new RandomAccessFile(lllIllIIllIll, "rw");
            if (this.dataFile.length() < 4096L) {
                for (int lllIllIIllIlI = 0; lllIllIIllIlI < 1024; ++lllIllIIllIlI) {
                    this.dataFile.writeInt(0);
                }
                for (int lllIllIIllIlI = 0; lllIllIIllIlI < 1024; ++lllIllIIllIlI) {
                    this.dataFile.writeInt(0);
                }
                this.sizeDelta += 8192;
            }
            if ((this.dataFile.length() & 0xFFFL) != 0x0L) {
                for (int lllIllIIllIIl = 0; lllIllIIllIIl < (this.dataFile.length() & 0xFFFL); ++lllIllIIllIIl) {
                    this.dataFile.write(0);
                }
            }
            final int lllIllIIllIII = (int)this.dataFile.length() / 4096;
            this.sectorFree = Lists.newArrayListWithCapacity(lllIllIIllIII);
            for (int lllIllIIlIlll = 0; lllIllIIlIlll < lllIllIIllIII; ++lllIllIIlIlll) {
                this.sectorFree.add(true);
            }
            this.sectorFree.set(0, false);
            this.sectorFree.set(1, false);
            this.dataFile.seek(0L);
            for (int lllIllIIlIlll = 0; lllIllIIlIlll < 1024; ++lllIllIIlIlll) {
                final int lllIllIIlIllI = this.dataFile.readInt();
                this.offsets[lllIllIIlIlll] = lllIllIIlIllI;
                if (lllIllIIlIllI != 0 && (lllIllIIlIllI >> 8) + (lllIllIIlIllI & 0xFF) <= this.sectorFree.size()) {
                    for (int lllIllIIlIlII = 0; lllIllIIlIlII < (lllIllIIlIllI & 0xFF); ++lllIllIIlIlII) {
                        this.sectorFree.set((lllIllIIlIllI >> 8) + lllIllIIlIlII, false);
                    }
                }
            }
            for (int lllIllIIlIlll = 0; lllIllIIlIlll < 1024; ++lllIllIIlIlll) {
                final int lllIllIIlIlIl = this.dataFile.readInt();
                this.chunkTimestamps[lllIllIIlIlll] = lllIllIIlIlIl;
            }
        }
        catch (IOException lllIllIIlIIll) {
            lllIllIIlIIll.printStackTrace();
        }
    }
    
    private void setChunkTimestamp(final int lllIlIIIIlIIl, final int lllIlIIIIIlII, final int lllIlIIIIIIll) throws IOException {
        this.chunkTimestamps[lllIlIIIIlIIl + lllIlIIIIIlII * 32] = lllIlIIIIIIll;
        this.dataFile.seek(4096 + (lllIlIIIIlIIl + lllIlIIIIIlII * 32) * 4);
        this.dataFile.writeInt(lllIlIIIIIIll);
    }
    
    private void setOffset(final int lllIlIIIlIIIl, final int lllIlIIIlIlII, final int lllIlIIIIllll) throws IOException {
        this.offsets[lllIlIIIlIIIl + lllIlIIIlIlII * 32] = lllIlIIIIllll;
        this.dataFile.seek((lllIlIIIlIIIl + lllIlIIIlIlII * 32) * 4);
        this.dataFile.writeInt(lllIlIIIIllll);
    }
    
    static {
        __OBFID = "CL_00000381";
        emptySector = new byte[4096];
    }
    
    private void write(final int lllIlIIllIllI, final byte[] lllIlIIlllIIl, final int lllIlIIllIlII) throws IOException {
        this.dataFile.seek(lllIlIIllIllI * 4096);
        this.dataFile.writeInt(lllIlIIllIlII + 1);
        this.dataFile.writeByte(2);
        this.dataFile.write(lllIlIIlllIIl, 0, lllIlIIllIlII);
    }
    
    private int getOffset(final int lllIlIIlIlIII, final int lllIlIIlIIlII) {
        return this.offsets[lllIlIIlIlIII + lllIlIIlIIlII * 32];
    }
    
    public synchronized DataInputStream getChunkDataInputStream(final int lllIllIIIIIlI, final int lllIlIlllIllI) {
        if (this.outOfBounds(lllIllIIIIIlI, lllIlIlllIllI)) {
            return null;
        }
        try {
            final int lllIllIIIIIII = this.getOffset(lllIllIIIIIlI, lllIlIlllIllI);
            if (lllIllIIIIIII == 0) {
                return null;
            }
            final int lllIlIlllllll = lllIllIIIIIII >> 8;
            final int lllIlIllllllI = lllIllIIIIIII & 0xFF;
            if (lllIlIlllllll + lllIlIllllllI > this.sectorFree.size()) {
                return null;
            }
            this.dataFile.seek(lllIlIlllllll * 4096);
            final int lllIlIlllllIl = this.dataFile.readInt();
            if (lllIlIlllllIl > 4096 * lllIlIllllllI) {
                return null;
            }
            if (lllIlIlllllIl <= 0) {
                return null;
            }
            final byte lllIlIlllllII = this.dataFile.readByte();
            if (lllIlIlllllII == 1) {
                final byte[] lllIlIllllIll = new byte[lllIlIlllllIl - 1];
                this.dataFile.read(lllIlIllllIll);
                return new DataInputStream(new BufferedInputStream(new GZIPInputStream(new ByteArrayInputStream(lllIlIllllIll))));
            }
            if (lllIlIlllllII == 2) {
                final byte[] lllIlIllllIlI = new byte[lllIlIlllllIl - 1];
                this.dataFile.read(lllIlIllllIlI);
                return new DataInputStream(new BufferedInputStream(new InflaterInputStream(new ByteArrayInputStream(lllIlIllllIlI))));
            }
            return null;
        }
        catch (IOException lllIlIllllIIl) {
            return null;
        }
    }
    
    class ChunkBuffer extends ByteArrayOutputStream
    {
        private /* synthetic */ int chunkZ;
        private /* synthetic */ int chunkX;
        
        public ChunkBuffer(final int llllllllllllllllIIllllIlIlllllll, final int llllllllllllllllIIllllIlIllllIlI) {
            super(8096);
            this.chunkX = llllllllllllllllIIllllIlIlllllll;
            this.chunkZ = llllllllllllllllIIllllIlIllllIlI;
        }
        
        @Override
        public void close() throws IOException {
            RegionFile.this.write(this.chunkX, this.chunkZ, this.buf, this.count);
        }
        
        static {
            __OBFID = "CL_00000382";
        }
    }
}
