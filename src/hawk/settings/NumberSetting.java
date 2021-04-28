package hawk.settings;

import hawk.modules.*;

public class NumberSetting extends Setting implements com.lukflug.panelstudio.settings.NumberSetting
{
    public /* synthetic */ double maximum;
    public /* synthetic */ Module parent;
    public /* synthetic */ double value;
    public /* synthetic */ double increment;
    public /* synthetic */ double minimum;
    
    @Override
    public double getMinimumValue() {
        return this.minimum;
    }
    
    public double getMaximum() {
        return this.maximum;
    }
    
    public NumberSetting(final String lIlllllllIIII, final double lIllllllIlIII, final double lIllllllIIlll, final double lIllllllIllIl, final double lIllllllIllII, final Module lIllllllIIlII) {
        this.name = lIlllllllIIII;
        this.value = lIllllllIlIII;
        this.minimum = lIllllllIIlll;
        this.maximum = lIllllllIllIl;
        this.increment = lIllllllIllII;
        this.parent = lIllllllIIlII;
    }
    
    public double getIncrement() {
        return this.increment;
    }
    
    public void increment(final boolean llIIIIIIlIlII) {
        this.setValue(this.getValue() + (llIIIIIIlIlII ? 1 : -1) * this.increment);
    }
    
    public void setIncrement(final double lIllllllllIIl) {
        this.increment = lIllllllllIIl;
    }
    
    public void setValue(final double llIIIIIIllIll) {
        final double llIIIIIIlllIl = 1.0 / this.increment;
        this.value = Math.round(Math.max(this.minimum, Math.min(this.maximum, llIIIIIIllIll)) * llIIIIIIlllIl) / llIIIIIIlllIl;
    }
    
    @Override
    public int getPrecision() {
        return (int)this.increment;
    }
    
    @Override
    public void setNumber(final double lIlllllIllIll) {
        this.value = lIlllllIllIll;
    }
    
    public double getValue() {
        return this.value;
    }
    
    public void setMinimum(final double llIIIIIIIlIll) {
        this.minimum = llIIIIIIIlIll;
    }
    
    @Override
    public double getNumber() {
        return this.value;
    }
    
    public double getMinimum() {
        return this.minimum;
    }
    
    public void setMaximum(final double llIIIIIIIIlII) {
        this.maximum = llIIIIIIIIlII;
    }
    
    @Override
    public double getMaximumValue() {
        return this.maximum;
    }
}
