package optifine;

import net.minecraft.util.*;

public class CustomColorFader
{
    private /* synthetic */ long timeUpdate;
    private /* synthetic */ Vec3 color;
    
    public Vec3 getColor(final double llllllllllllllIIIlllIIlIIlIlllII, final double llllllllllllllIIIlllIIlIIlIllIll, final double llllllllllllllIIIlllIIlIIlIllIlI) {
        if (this.color == null) {
            this.color = new Vec3(llllllllllllllIIIlllIIlIIlIlllII, llllllllllllllIIIlllIIlIIlIllIll, llllllllllllllIIIlllIIlIIlIllIlI);
            return this.color;
        }
        final long llllllllllllllIIIlllIIlIIllIIllI = System.currentTimeMillis();
        final long llllllllllllllIIIlllIIlIIllIIlIl = llllllllllllllIIIlllIIlIIllIIllI - this.timeUpdate;
        if (llllllllllllllIIIlllIIlIIllIIlIl == 0L) {
            return this.color;
        }
        this.timeUpdate = llllllllllllllIIIlllIIlIIllIIllI;
        if (Math.abs(llllllllllllllIIIlllIIlIIlIlllII - this.color.xCoord) < 0.004 && Math.abs(llllllllllllllIIIlllIIlIIlIllIll - this.color.yCoord) < 0.004 && Math.abs(llllllllllllllIIIlllIIlIIlIllIlI - this.color.zCoord) < 0.004) {
            return this.color;
        }
        double llllllllllllllIIIlllIIlIIllIIlII = llllllllllllllIIIlllIIlIIllIIlIl * 0.001;
        llllllllllllllIIIlllIIlIIllIIlII = Config.limit(llllllllllllllIIIlllIIlIIllIIlII, 0.0, 1.0);
        final double llllllllllllllIIIlllIIlIIllIIIll = llllllllllllllIIIlllIIlIIlIlllII - this.color.xCoord;
        final double llllllllllllllIIIlllIIlIIllIIIlI = llllllllllllllIIIlllIIlIIlIllIll - this.color.yCoord;
        final double llllllllllllllIIIlllIIlIIllIIIIl = llllllllllllllIIIlllIIlIIlIllIlI - this.color.zCoord;
        final double llllllllllllllIIIlllIIlIIllIIIII = this.color.xCoord + llllllllllllllIIIlllIIlIIllIIIll * llllllllllllllIIIlllIIlIIllIIlII;
        final double llllllllllllllIIIlllIIlIIlIlllll = this.color.yCoord + llllllllllllllIIIlllIIlIIllIIIlI * llllllllllllllIIIlllIIlIIllIIlII;
        final double llllllllllllllIIIlllIIlIIlIllllI = this.color.zCoord + llllllllllllllIIIlllIIlIIllIIIIl * llllllllllllllIIIlllIIlIIllIIlII;
        this.color = new Vec3(llllllllllllllIIIlllIIlIIllIIIII, llllllllllllllIIIlllIIlIIlIlllll, llllllllllllllIIIlllIIlIIlIllllI);
        return this.color;
    }
    
    public CustomColorFader() {
        this.color = null;
        this.timeUpdate = System.currentTimeMillis();
    }
}
