package net.minecraft.world.gen.layer;

public class GenLayerFuzzyZoom extends GenLayerZoom
{
    @Override
    protected int selectModeOrRandom(final int llllllllllllllIlIllllIIlllIIIllI, final int llllllllllllllIlIllllIIlllIIIlIl, final int llllllllllllllIlIllllIIlllIIIlII, final int llllllllllllllIlIllllIIllIlllllI) {
        return this.selectRandom(llllllllllllllIlIllllIIlllIIIllI, llllllllllllllIlIllllIIlllIIIlIl, llllllllllllllIlIllllIIlllIIIlII, llllllllllllllIlIllllIIllIlllllI);
    }
    
    public GenLayerFuzzyZoom(final long llllllllllllllIlIllllIIlllIIlllI, final GenLayer llllllllllllllIlIllllIIlllIlIIII) {
        super(llllllllllllllIlIllllIIlllIIlllI, llllllllllllllIlIllllIIlllIlIIII);
    }
    
    static {
        __OBFID = "CL_00000556";
    }
}
