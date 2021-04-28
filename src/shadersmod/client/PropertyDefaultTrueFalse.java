package shadersmod.client;

public class PropertyDefaultTrueFalse extends Property
{
    public static final /* synthetic */ String[] PROPERTY_VALUES;
    public static final /* synthetic */ String[] USER_VALUES;
    
    public PropertyDefaultTrueFalse(final String llllllllllllllIIlIllIlIlllIlIIll, final String llllllllllllllIIlIllIlIlllIlIIlI, final int llllllllllllllIIlIllIlIlllIIllIl) {
        super(llllllllllllllIIlIllIlIlllIlIIll, PropertyDefaultTrueFalse.PROPERTY_VALUES, llllllllllllllIIlIllIlIlllIlIIlI, PropertyDefaultTrueFalse.USER_VALUES, llllllllllllllIIlIllIlIlllIIllIl);
    }
    
    static {
        PROPERTY_VALUES = new String[] { "default", "true", "false" };
        USER_VALUES = new String[] { "Default", "ON", "OFF" };
    }
    
    public boolean isTrue() {
        return this.getValue() == 1;
    }
    
    public boolean isDefault() {
        return this.getValue() == 0;
    }
    
    public boolean isFalse() {
        return this.getValue() == 2;
    }
}
