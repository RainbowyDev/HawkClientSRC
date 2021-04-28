package hawk.events;

public class Event<T>
{
    public /* synthetic */ boolean cancelled;
    public /* synthetic */ EventDirection direction;
    public /* synthetic */ EventType type;
    
    public boolean isPre() {
        return this.type != null && this.type == EventType.PRE;
    }
    
    public EventType getType() {
        return this.type;
    }
    
    public void setCancelled(final boolean llllllllllllllIlIllIlllIlIIIlIlI) {
        this.cancelled = llllllllllllllIlIllIlllIlIIIlIlI;
    }
    
    public boolean isPost() {
        return this.type != null && this.type == EventType.POST;
    }
    
    public boolean isOutgoing() {
        return this.direction != null && this.direction == EventDirection.OUTGOING;
    }
    
    public void setType(final EventType llllllllllllllIlIllIlllIIlllllII) {
        this.type = llllllllllllllIlIllIlllIIlllllII;
    }
    
    public EventDirection getDirection() {
        return this.direction;
    }
    
    public void setDirection(final EventDirection llllllllllllllIlIllIlllIIllIlllI) {
        this.direction = llllllllllllllIlIllIlllIIllIlllI;
    }
    
    public boolean isCancelled() {
        return this.cancelled;
    }
    
    public boolean isIncoming() {
        return this.direction != null && this.direction == EventDirection.INCOMING;
    }
}
