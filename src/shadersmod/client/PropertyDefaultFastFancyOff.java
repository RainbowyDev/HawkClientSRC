package shadersmod.client;

import optifine.*;

public class PropertyDefaultFastFancyOff extends Property
{
    public static final /* synthetic */ String[] USER_VALUES;
    public static final /* synthetic */ String[] PROPERTY_VALUES;
    
    public boolean isDefault() {
        return this.getValue() == 0;
    }
    
    public PropertyDefaultFastFancyOff(final String llllllllllllllIlllllIlIlIIlIIIll, final String llllllllllllllIlllllIlIlIIIllllI, final int llllllllllllllIlllllIlIlIIIlllIl) {
        super(llllllllllllllIlllllIlIlIIlIIIll, PropertyDefaultFastFancyOff.PROPERTY_VALUES, llllllllllllllIlllllIlIlIIIllllI, PropertyDefaultFastFancyOff.USER_VALUES, llllllllllllllIlllllIlIlIIIlllIl);
    }
    
    static {
        PROPERTY_VALUES = new String[] { "default", "fast", "fancy", "off" };
        USER_VALUES = new String[] { "Default", "Fast", "Fancy", "OFF" };
    }
    
    public boolean isFast() {
        return this.getValue() == 1;
    }
    
    public boolean isFancy() {
        return this.getValue() == 2;
    }
    
    public boolean isOff() {
        return this.getValue() == 3;
    }
    
    @Override
    public boolean setPropertyValue(String llllllllllllllIlllllIlIlIIIIlIll) {
        if (Config.equals(llllllllllllllIlllllIlIlIIIIlIll, "none")) {
            llllllllllllllIlllllIlIlIIIIlIll = "off";
        }
        return super.setPropertyValue(llllllllllllllIlllllIlIlIIIIlIll);
    }
}
