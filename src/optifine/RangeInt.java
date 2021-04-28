package optifine;

public class RangeInt
{
    private /* synthetic */ int min;
    private /* synthetic */ int max;
    
    public int getMax() {
        return this.max;
    }
    
    public boolean isInRange(final int lIIIlIIlIlIIIIl) {
        return lIIIlIIlIlIIIIl >= this.min && lIIIlIIlIlIIIIl <= this.max;
    }
    
    public int getMin() {
        return this.min;
    }
    
    public RangeInt(final int lIIIlIIlIlIIllI, final int lIIIlIIlIlIlIII) {
        this.min = Math.min(lIIIlIIlIlIIllI, lIIIlIIlIlIlIII);
        this.max = Math.max(lIIIlIIlIlIIllI, lIIIlIIlIlIlIII);
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("min: ").append(this.min).append(", max: ").append(this.max));
    }
}
