package com.lukflug.panelstudio;

public abstract class Animation
{
    protected /* synthetic */ long lastTime;
    protected /* synthetic */ double lastValue;
    protected /* synthetic */ double value;
    
    protected abstract int getSpeed();
    
    public Animation() {
        this.lastTime = System.currentTimeMillis();
    }
    
    public void initValue(final double llllllllllllllIIIlllllIIIlIIllIl) {
        this.value = llllllllllllllIIIlllllIIIlIIllIl;
        this.lastValue = llllllllllllllIIIlllllIIIlIIllIl;
    }
    
    public void setValue(final double llllllllllllllIIIlllllIIIIlllllI) {
        this.lastValue = this.getValue();
        this.value = llllllllllllllIIIlllllIIIIlllllI;
        this.lastTime = System.currentTimeMillis();
    }
    
    public double getTarget() {
        return this.value;
    }
    
    public double getValue() {
        if (this.getSpeed() == 0) {
            return this.value;
        }
        final double llllllllllllllIIIlllllIIIlIIIlll = (System.currentTimeMillis() - this.lastTime) / (double)this.getSpeed();
        if (llllllllllllllIIIlllllIIIlIIIlll >= 1.0) {
            return this.value;
        }
        if (llllllllllllllIIIlllllIIIlIIIlll <= 0.0) {
            return this.lastValue;
        }
        return this.value * llllllllllllllIIIlllllIIIlIIIlll + this.lastValue * (1.0 - llllllllllllllIIIlllllIIIlIIIlll);
    }
}
