package net.minecraft.util;

public class RegistryDefaulted extends RegistrySimple
{
    private final /* synthetic */ Object defaultObject;
    
    static {
        __OBFID = "CL_00001198";
    }
    
    public RegistryDefaulted(final Object llllllllllllllIIIIlIIlIllIIIIIlI) {
        this.defaultObject = llllllllllllllIIIIlIIlIllIIIIIlI;
    }
    
    @Override
    public Object getObject(final Object llllllllllllllIIIIlIIlIlIllllIlI) {
        final Object llllllllllllllIIIIlIIlIlIlllllII = super.getObject(llllllllllllllIIIIlIIlIlIllllIlI);
        return (llllllllllllllIIIIlIIlIlIlllllII == null) ? this.defaultObject : llllllllllllllIIIIlIIlIlIlllllII;
    }
}
