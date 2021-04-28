package net.minecraft.world.chunk.storage;

import java.io.*;
import net.minecraft.nbt.*;
import net.minecraft.world.*;
import net.minecraft.world.storage.*;

public class AnvilSaveHandler extends SaveHandler
{
    public AnvilSaveHandler(final File lllllllllllllllIllllIIIIIlIlIIlI, final String lllllllllllllllIllllIIIIIlIlIIIl, final boolean lllllllllllllllIllllIIIIIlIIllII) {
        super(lllllllllllllllIllllIIIIIlIlIIlI, lllllllllllllllIllllIIIIIlIlIIIl, lllllllllllllllIllllIIIIIlIIllII);
    }
    
    @Override
    public void saveWorldInfoWithPlayer(final WorldInfo lllllllllllllllIllllIIIIIIlllIlI, final NBTTagCompound lllllllllllllllIllllIIIIIIlllIIl) {
        lllllllllllllllIllllIIIIIIlllIlI.setSaveVersion(19133);
        super.saveWorldInfoWithPlayer(lllllllllllllllIllllIIIIIIlllIlI, lllllllllllllllIllllIIIIIIlllIIl);
    }
    
    @Override
    public IChunkLoader getChunkLoader(final WorldProvider lllllllllllllllIllllIIIIIlIIIllI) {
        final File lllllllllllllllIllllIIIIIlIIIlIl = this.getWorldDirectory();
        if (lllllllllllllllIllllIIIIIlIIIllI instanceof WorldProviderHell) {
            final File lllllllllllllllIllllIIIIIlIIIlII = new File(lllllllllllllllIllllIIIIIlIIIlIl, "DIM-1");
            lllllllllllllllIllllIIIIIlIIIlII.mkdirs();
            return new AnvilChunkLoader(lllllllllllllllIllllIIIIIlIIIlII);
        }
        if (lllllllllllllllIllllIIIIIlIIIllI instanceof WorldProviderEnd) {
            final File lllllllllllllllIllllIIIIIlIIIIll = new File(lllllllllllllllIllllIIIIIlIIIlIl, "DIM1");
            lllllllllllllllIllllIIIIIlIIIIll.mkdirs();
            return new AnvilChunkLoader(lllllllllllllllIllllIIIIIlIIIIll);
        }
        return new AnvilChunkLoader(lllllllllllllllIllllIIIIIlIIIlIl);
    }
    
    static {
        __OBFID = "CL_00000581";
    }
    
    @Override
    public void flush() {
        try {
            ThreadedFileIOBase.func_178779_a().waitForFinish();
        }
        catch (InterruptedException lllllllllllllllIllllIIIIIIllIIll) {
            lllllllllllllllIllllIIIIIIllIIll.printStackTrace();
        }
        RegionFileCache.clearRegionFileReferences();
    }
}
