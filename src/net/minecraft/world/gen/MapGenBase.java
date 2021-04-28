package net.minecraft.world.gen;

import java.util.*;
import net.minecraft.world.*;
import net.minecraft.world.chunk.*;

public class MapGenBase
{
    protected /* synthetic */ int range;
    protected /* synthetic */ Random rand;
    protected /* synthetic */ World worldObj;
    
    public void func_175792_a(final IChunkProvider llllllllllllllIlllIlIIIIIlIIIlII, final World llllllllllllllIlllIlIIIIIlIIIIll, final int llllllllllllllIlllIlIIIIIIllIllI, final int llllllllllllllIlllIlIIIIIlIIIIIl, final ChunkPrimer llllllllllllllIlllIlIIIIIlIIIIII) {
        final int llllllllllllllIlllIlIIIIIIllllll = this.range;
        this.worldObj = llllllllllllllIlllIlIIIIIlIIIIll;
        this.rand.setSeed(llllllllllllllIlllIlIIIIIlIIIIll.getSeed());
        final long llllllllllllllIlllIlIIIIIIlllllI = this.rand.nextLong();
        final long llllllllllllllIlllIlIIIIIIllllIl = this.rand.nextLong();
        for (int llllllllllllllIlllIlIIIIIIllllII = llllllllllllllIlllIlIIIIIIllIllI - llllllllllllllIlllIlIIIIIIllllll; llllllllllllllIlllIlIIIIIIllllII <= llllllllllllllIlllIlIIIIIIllIllI + llllllllllllllIlllIlIIIIIIllllll; ++llllllllllllllIlllIlIIIIIIllllII) {
            for (int llllllllllllllIlllIlIIIIIIlllIll = llllllllllllllIlllIlIIIIIlIIIIIl - llllllllllllllIlllIlIIIIIIllllll; llllllllllllllIlllIlIIIIIIlllIll <= llllllllllllllIlllIlIIIIIlIIIIIl + llllllllllllllIlllIlIIIIIIllllll; ++llllllllllllllIlllIlIIIIIIlllIll) {
                final long llllllllllllllIlllIlIIIIIIlllIlI = llllllllllllllIlllIlIIIIIIllllII * llllllllllllllIlllIlIIIIIIlllllI;
                final long llllllllllllllIlllIlIIIIIIlllIIl = llllllllllllllIlllIlIIIIIIlllIll * llllllllllllllIlllIlIIIIIIllllIl;
                this.rand.setSeed(llllllllllllllIlllIlIIIIIIlllIlI ^ llllllllllllllIlllIlIIIIIIlllIIl ^ llllllllllllllIlllIlIIIIIlIIIIll.getSeed());
                this.func_180701_a(llllllllllllllIlllIlIIIIIlIIIIll, llllllllllllllIlllIlIIIIIIllllII, llllllllllllllIlllIlIIIIIIlllIll, llllllllllllllIlllIlIIIIIIllIllI, llllllllllllllIlllIlIIIIIlIIIIIl, llllllllllllllIlllIlIIIIIlIIIIII);
            }
        }
    }
    
    protected void func_180701_a(final World llllllllllllllIlllIlIIIIIIlIlIll, final int llllllllllllllIlllIlIIIIIIlIlIlI, final int llllllllllllllIlllIlIIIIIIlIlIIl, final int llllllllllllllIlllIlIIIIIIlIlIII, final int llllllllllllllIlllIlIIIIIIlIIlll, final ChunkPrimer llllllllllllllIlllIlIIIIIIlIIllI) {
    }
    
    public MapGenBase() {
        this.range = 8;
        this.rand = new Random();
    }
    
    static {
        __OBFID = "CL_00000394";
    }
}
