package net.minecraft.util;

import org.apache.commons.lang3.*;

public class RegistryNamespacedDefaultedByKey extends RegistryNamespaced
{
    private /* synthetic */ Object field_148761_e;
    private final /* synthetic */ Object field_148760_d;
    
    static {
        __OBFID = "CL_00001196";
    }
    
    public void validateKey() {
        Validate.notNull(this.field_148760_d);
    }
    
    @Override
    public Object getObjectById(final int llllllllllllllIlIllllIIIlllIIlll) {
        final Object llllllllllllllIlIllllIIIlllIIllI = super.getObjectById(llllllllllllllIlIllllIIIlllIIlll);
        return (llllllllllllllIlIllllIIIlllIIllI == null) ? this.field_148761_e : llllllllllllllIlIllllIIIlllIIllI;
    }
    
    @Override
    public Object getObject(final Object llllllllllllllIlIllllIIIllllIIII) {
        final Object llllllllllllllIlIllllIIIlllIllll = super.getObject(llllllllllllllIlIllllIIIllllIIII);
        return (llllllllllllllIlIllllIIIlllIllll == null) ? this.field_148761_e : llllllllllllllIlIllllIIIlllIllll;
    }
    
    @Override
    public void register(final int llllllllllllllIlIllllIIIlllllIlI, final Object llllllllllllllIlIllllIIIlllllIIl, final Object llllllllllllllIlIllllIIIlllllIII) {
        if (this.field_148760_d.equals(llllllllllllllIlIllllIIIlllllIIl)) {
            this.field_148761_e = llllllllllllllIlIllllIIIlllllIII;
        }
        super.register(llllllllllllllIlIllllIIIlllllIlI, llllllllllllllIlIllllIIIlllllIIl, llllllllllllllIlIllllIIIlllllIII);
    }
    
    public RegistryNamespacedDefaultedByKey(final Object llllllllllllllIlIllllIIlIIIIIlII) {
        this.field_148760_d = llllllllllllllIlIllllIIlIIIIIlII;
    }
}
