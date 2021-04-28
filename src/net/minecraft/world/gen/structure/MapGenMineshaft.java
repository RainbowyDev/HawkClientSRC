package net.minecraft.world.gen.structure;

import net.minecraft.util.*;
import java.util.*;

public class MapGenMineshaft extends MapGenStructure
{
    private /* synthetic */ double field_82673_e;
    
    @Override
    protected boolean canSpawnStructureAtCoords(final int llllllllllllllllIlIIlllIIIIIllIl, final int llllllllllllllllIlIIlllIIIIIlIIl) {
        return this.rand.nextDouble() < this.field_82673_e && this.rand.nextInt(80) < Math.max(Math.abs(llllllllllllllllIlIIlllIIIIIllIl), Math.abs(llllllllllllllllIlIIlllIIIIIlIIl));
    }
    
    public MapGenMineshaft(final Map llllllllllllllllIlIIlllIIIIllIII) {
        this.field_82673_e = 0.004;
        for (final Map.Entry llllllllllllllllIlIIlllIIIIlIllI : llllllllllllllllIlIIlllIIIIllIII.entrySet()) {
            if (llllllllllllllllIlIIlllIIIIlIllI.getKey().equals("chance")) {
                this.field_82673_e = MathHelper.parseDoubleWithDefault(llllllllllllllllIlIIlllIIIIlIllI.getValue(), this.field_82673_e);
            }
        }
    }
    
    public MapGenMineshaft() {
        this.field_82673_e = 0.004;
    }
    
    static {
        __OBFID = "CL_00000443";
    }
    
    @Override
    protected StructureStart getStructureStart(final int llllllllllllllllIlIIlllIIIIIIlII, final int llllllllllllllllIlIIlllIIIIIIIII) {
        return new StructureMineshaftStart(this.worldObj, this.rand, llllllllllllllllIlIIlllIIIIIIlII, llllllllllllllllIlIIlllIIIIIIIII);
    }
    
    @Override
    public String getStructureName() {
        return "Mineshaft";
    }
}
