package net.minecraft.entity.ai.attributes;

public abstract class BaseAttribute implements IAttribute
{
    private final /* synthetic */ IAttribute field_180373_a;
    private final /* synthetic */ String unlocalizedName;
    private /* synthetic */ boolean shouldWatch;
    private final /* synthetic */ double defaultValue;
    
    public BaseAttribute setShouldWatch(final boolean llllllllllllllIIlIIIIIlIlIlIlIIl) {
        this.shouldWatch = llllllllllllllIIlIIIIIlIlIlIlIIl;
        return this;
    }
    
    @Override
    public double getDefaultValue() {
        return this.defaultValue;
    }
    
    @Override
    public IAttribute func_180372_d() {
        return this.field_180373_a;
    }
    
    @Override
    public String getAttributeUnlocalizedName() {
        return this.unlocalizedName;
    }
    
    @Override
    public int hashCode() {
        return this.unlocalizedName.hashCode();
    }
    
    @Override
    public boolean getShouldWatch() {
        return this.shouldWatch;
    }
    
    protected BaseAttribute(final IAttribute llllllllllllllIIlIIIIIlIlIlllIlI, final String llllllllllllllIIlIIIIIlIlIllllIl, final double llllllllllllllIIlIIIIIlIlIllllII) {
        this.field_180373_a = llllllllllllllIIlIIIIIlIlIlllIlI;
        this.unlocalizedName = llllllllllllllIIlIIIIIlIlIllllIl;
        this.defaultValue = llllllllllllllIIlIIIIIlIlIllllII;
        if (llllllllllllllIIlIIIIIlIlIllllIl == null) {
            throw new IllegalArgumentException("Name cannot be null!");
        }
    }
    
    @Override
    public boolean equals(final Object llllllllllllllIIlIIIIIlIlIIlllIl) {
        return llllllllllllllIIlIIIIIlIlIIlllIl instanceof IAttribute && this.unlocalizedName.equals(((IAttribute)llllllllllllllIIlIIIIIlIlIIlllIl).getAttributeUnlocalizedName());
    }
    
    static {
        __OBFID = "CL_00001565";
    }
}
