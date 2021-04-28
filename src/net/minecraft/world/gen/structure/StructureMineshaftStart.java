package net.minecraft.world.gen.structure;

import net.minecraft.world.*;
import java.util.*;

public class StructureMineshaftStart extends StructureStart
{
    public StructureMineshaftStart(final World llllllllllllllIlllIIIIIlIllIlIll, final Random llllllllllllllIlllIIIIIlIllIlIIl, final int llllllllllllllIlllIIIIIlIllIIlll, final int llllllllllllllIlllIIIIIlIlllIIIl) {
        super(llllllllllllllIlllIIIIIlIllIIlll, llllllllllllllIlllIIIIIlIlllIIIl);
        final StructureMineshaftPieces.Room llllllllllllllIlllIIIIIlIllIllll = new StructureMineshaftPieces.Room(0, llllllllllllllIlllIIIIIlIllIlIIl, (llllllllllllllIlllIIIIIlIllIIlll << 4) + 2, (llllllllllllllIlllIIIIIlIlllIIIl << 4) + 2);
        this.components.add(llllllllllllllIlllIIIIIlIllIllll);
        llllllllllllllIlllIIIIIlIllIllll.buildComponent(llllllllllllllIlllIIIIIlIllIllll, this.components, llllllllllllllIlllIIIIIlIllIlIIl);
        this.updateBoundingBox();
        this.markAvailableHeight(llllllllllllllIlllIIIIIlIllIlIll, llllllllllllllIlllIIIIIlIllIlIIl, 10);
    }
    
    public StructureMineshaftStart() {
    }
    
    static {
        __OBFID = "CL_00000450";
    }
}
