package net.minecraft.client.audio;

import net.minecraft.util.*;
import java.util.*;
import com.google.common.collect.*;

public class SoundRegistry extends RegistrySimple
{
    private /* synthetic */ Map field_148764_a;
    
    public void clearMap() {
        this.field_148764_a.clear();
    }
    
    @Override
    protected Map createUnderlyingMap() {
        this.field_148764_a = Maps.newHashMap();
        return this.field_148764_a;
    }
    
    static {
        __OBFID = "CL_00001151";
    }
    
    public void registerSound(final SoundEventAccessorComposite llllllllllllllIlllIllIIlIllllllI) {
        this.putObject(llllllllllllllIlllIllIIlIllllllI.getSoundEventLocation(), llllllllllllllIlllIllIIlIllllllI);
    }
}
