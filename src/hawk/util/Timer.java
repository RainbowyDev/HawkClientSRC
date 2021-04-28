package hawk.util;

public class Timer
{
    public /* synthetic */ long lastMS;
    
    public Timer() {
        this.lastMS = System.currentTimeMillis();
    }
    
    public void reset() {
        this.lastMS = System.currentTimeMillis();
    }
    
    public boolean hasTimeElapsed(final long llllllllllllllIIIlIllllIIIlIllIl, final boolean llllllllllllllIIIlIllllIIIlIlIIl) {
        if (System.currentTimeMillis() - this.lastMS > llllllllllllllIIIlIllllIIIlIllIl) {
            if (llllllllllllllIIIlIllllIIIlIlIIl) {
                this.reset();
            }
            return true;
        }
        return false;
    }
}
