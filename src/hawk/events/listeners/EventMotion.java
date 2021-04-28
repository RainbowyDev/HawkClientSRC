package hawk.events.listeners;

import hawk.events.*;

public class EventMotion extends Event<EventMotion>
{
    public /* synthetic */ float pitch;
    public /* synthetic */ boolean onGround;
    public /* synthetic */ double z;
    public /* synthetic */ float yaw;
    public /* synthetic */ double x;
    public /* synthetic */ double y;
    
    public double getZ() {
        return this.z;
    }
    
    public EventMotion(final double llllllllllllllllIIIlllIIIIllIlII, final double llllllllllllllllIIIlllIIIIlllIlI, final double llllllllllllllllIIIlllIIIIlllIIl, final float llllllllllllllllIIIlllIIIIlllIII, final float llllllllllllllllIIIlllIIIIllIlll, final boolean llllllllllllllllIIIlllIIIIlIllll) {
        this.x = llllllllllllllllIIIlllIIIIllIlII;
        this.y = llllllllllllllllIIIlllIIIIlllIlI;
        this.z = llllllllllllllllIIIlllIIIIlllIIl;
        this.yaw = llllllllllllllllIIIlllIIIIlllIII;
        this.pitch = llllllllllllllllIIIlllIIIIllIlll;
        this.onGround = llllllllllllllllIIIlllIIIIlIllll;
    }
    
    public void setY(final double llllllllllllllllIIIlllIIIIIlllll) {
        this.y = llllllllllllllllIIIlllIIIIIlllll;
    }
    
    public double getY() {
        return this.y;
    }
    
    public void setYaw(final float llllllllllllllllIIIlllIIIIIIllIl) {
        this.yaw = llllllllllllllllIIIlllIIIIIIllIl;
    }
    
    public void setOnGround(final boolean llllllllllllllllIIIllIlllllllIll) {
        this.onGround = llllllllllllllllIIIllIlllllllIll;
    }
    
    public float getPitch() {
        return this.pitch;
    }
    
    public boolean isOnGround() {
        return this.onGround;
    }
    
    public void setPitch(final float llllllllllllllllIIIlllIIIIIIIIlI) {
        this.pitch = llllllllllllllllIIIlllIIIIIIIIlI;
    }
    
    public float getYaw() {
        return this.yaw;
    }
    
    public void setZ(final double llllllllllllllllIIIlllIIIIIlIlII) {
        this.z = llllllllllllllllIIIlllIIIIIlIlII;
    }
    
    public void setX(final double llllllllllllllllIIIlllIIIIlIIllI) {
        this.x = llllllllllllllllIIIlllIIIIlIIllI;
    }
    
    public double getX() {
        return this.x;
    }
}
