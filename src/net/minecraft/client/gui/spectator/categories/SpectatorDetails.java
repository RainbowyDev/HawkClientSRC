package net.minecraft.client.gui.spectator.categories;

import java.util.*;
import net.minecraft.client.gui.spectator.*;
import com.google.common.base.*;

public class SpectatorDetails
{
    private final /* synthetic */ ISpectatorMenuView field_178684_a;
    private final /* synthetic */ List field_178682_b;
    private final /* synthetic */ int field_178683_c;
    
    static {
        __OBFID = "CL_00001923";
    }
    
    public SpectatorDetails(final ISpectatorMenuView lllIlllIIllI, final List lllIlllIIIIl, final int lllIlllIIlII) {
        this.field_178684_a = lllIlllIIllI;
        this.field_178682_b = lllIlllIIIIl;
        this.field_178683_c = lllIlllIIlII;
    }
    
    public int func_178681_b() {
        return this.field_178683_c;
    }
    
    public ISpectatorMenuObject func_178680_a(final int lllIllIlllII) {
        return (ISpectatorMenuObject)((lllIllIlllII >= 0 && lllIllIlllII < this.field_178682_b.size()) ? Objects.firstNonNull(this.field_178682_b.get(lllIllIlllII), (Object)SpectatorMenu.field_178657_a) : SpectatorMenu.field_178657_a);
    }
}
