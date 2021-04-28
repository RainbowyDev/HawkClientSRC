package optifine;

public class RangeListInt
{
    private /* synthetic */ RangeInt[] ranges;
    
    public void addRange(final RangeInt llllllllllllllIlIlIIIlllllIllIIl) {
        this.ranges = (RangeInt[])Config.addObjectToArray(this.ranges, llllllllllllllIlIlIIIlllllIllIIl);
    }
    
    public RangeInt getRange(final int llllllllllllllIlIlIIIlllllIIIlII) {
        return this.ranges[llllllllllllllIlIlIIIlllllIIIlII];
    }
    
    public boolean isInRange(final int llllllllllllllIlIlIIIlllllIlIIIl) {
        for (int llllllllllllllIlIlIIIlllllIlIIII = 0; llllllllllllllIlIlIIIlllllIlIIII < this.ranges.length; ++llllllllllllllIlIlIIIlllllIlIIII) {
            final RangeInt llllllllllllllIlIlIIIlllllIIllll = this.ranges[llllllllllllllIlIlIIIlllllIlIIII];
            if (llllllllllllllIlIlIIIlllllIIllll.isInRange(llllllllllllllIlIlIIIlllllIlIIIl)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString() {
        final StringBuffer llllllllllllllIlIlIIIllllIllllII = new StringBuffer();
        llllllllllllllIlIlIIIllllIllllII.append("[");
        for (int llllllllllllllIlIlIIIllllIlllIll = 0; llllllllllllllIlIlIIIllllIlllIll < this.ranges.length; ++llllllllllllllIlIlIIIllllIlllIll) {
            final RangeInt llllllllllllllIlIlIIIllllIlllIlI = this.ranges[llllllllllllllIlIlIIIllllIlllIll];
            if (llllllllllllllIlIlIIIllllIlllIll > 0) {
                llllllllllllllIlIlIIIllllIllllII.append(", ");
            }
            llllllllllllllIlIlIIIllllIllllII.append(llllllllllllllIlIlIIIllllIlllIlI.toString());
        }
        llllllllllllllIlIlIIIllllIllllII.append("]");
        return llllllllllllllIlIlIIIllllIllllII.toString();
    }
    
    public int getCountRanges() {
        return this.ranges.length;
    }
    
    public RangeListInt() {
        this.ranges = new RangeInt[0];
    }
}
