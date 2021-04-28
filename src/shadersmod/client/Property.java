package shadersmod.client;

import java.util.*;
import org.apache.commons.lang3.*;
import optifine.*;

public class Property
{
    private /* synthetic */ int value;
    private /* synthetic */ int defaultValue;
    private /* synthetic */ String[] userValues;
    private /* synthetic */ String propertyName;
    private /* synthetic */ String[] propertyValues;
    private /* synthetic */ int[] values;
    private /* synthetic */ String userName;
    
    public void resetValue() {
        this.value = this.defaultValue;
    }
    
    public void saveTo(final Properties llllllllllllllIllIllllIIIIllllll) {
        if (llllllllllllllIllIllllIIIIllllll != null) {
            llllllllllllllIllIllllIIIIllllll.setProperty(this.getPropertyName(), this.getPropertyValue());
        }
    }
    
    public boolean loadFrom(final Properties llllllllllllllIllIllllIIIlIIlIIl) {
        this.resetValue();
        if (llllllllllllllIllIllllIIIlIIlIIl == null) {
            return false;
        }
        final String llllllllllllllIllIllllIIIlIIlIII = llllllllllllllIllIllllIIIlIIlIIl.getProperty(this.propertyName);
        return llllllllllllllIllIllllIIIlIIlIII != null && this.setPropertyValue(llllllllllllllIllIllllIIIlIIlIII);
    }
    
    public String getPropertyValue() {
        return this.propertyValues[this.value];
    }
    
    public String getUserName() {
        return this.userName;
    }
    
    public void setValue(final int llllllllllllllIllIllllIIIllIIIlI) {
        this.value = llllllllllllllIllIllllIIIllIIIlI;
        if (this.value < 0 || this.value >= this.propertyValues.length) {
            this.value = this.defaultValue;
        }
    }
    
    public String getUserValue() {
        return this.userValues[this.value];
    }
    
    public void nextValue() {
        ++this.value;
        if (this.value < 0 || this.value >= this.propertyValues.length) {
            this.value = 0;
        }
    }
    
    public Property(final String llllllllllllllIllIllllIIIllllIIl, final String[] llllllllllllllIllIllllIIIllllIII, final String llllllllllllllIllIllllIIIlllIIIl, final String[] llllllllllllllIllIllllIIIlllIIII, final int llllllllllllllIllIllllIIIlllIlIl) {
        this.values = null;
        this.defaultValue = 0;
        this.propertyName = null;
        this.propertyValues = null;
        this.userName = null;
        this.userValues = null;
        this.value = 0;
        this.propertyName = llllllllllllllIllIllllIIIllllIIl;
        this.propertyValues = llllllllllllllIllIllllIIIllllIII;
        this.userName = llllllllllllllIllIllllIIIlllIIIl;
        this.userValues = llllllllllllllIllIllllIIIlllIIII;
        this.defaultValue = llllllllllllllIllIllllIIIlllIlIl;
        if (llllllllllllllIllIllllIIIllllIII.length != llllllllllllllIllIllllIIIlllIIII.length) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Property and user values have different lengths: ").append(llllllllllllllIllIllllIIIllllIII.length).append(" != ").append(llllllllllllllIllIllllIIIlllIIII.length)));
        }
        if (llllllllllllllIllIllllIIIlllIlIl >= 0 && llllllllllllllIllIllllIIIlllIlIl < llllllllllllllIllIllllIIIllllIII.length) {
            this.value = llllllllllllllIllIllllIIIlllIlIl;
            return;
        }
        throw new IllegalArgumentException(String.valueOf(new StringBuilder("Invalid default value: ").append(llllllllllllllIllIllllIIIlllIlIl)));
    }
    
    public boolean setPropertyValue(final String llllllllllllllIllIllllIIIllIlIll) {
        if (llllllllllllllIllIllllIIIllIlIll == null) {
            this.value = this.defaultValue;
            return false;
        }
        this.value = ArrayUtils.indexOf((Object[])this.propertyValues, (Object)llllllllllllllIllIllllIIIllIlIll);
        if (this.value >= 0 && this.value < this.propertyValues.length) {
            return true;
        }
        this.value = this.defaultValue;
        return false;
    }
    
    public int getValue() {
        return this.value;
    }
    
    public String getPropertyName() {
        return this.propertyName;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append(this.propertyName).append("=").append(this.getPropertyValue()).append(" [").append(Config.arrayToString(this.propertyValues)).append("], value: ").append(this.value));
    }
}
