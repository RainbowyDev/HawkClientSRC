package alts;

public final class Alt
{
    private final /* synthetic */ String username;
    private /* synthetic */ String mask;
    private /* synthetic */ String password;
    
    public void setPassword(final String lllllIIlIlIll) {
        this.password = lllllIIlIlIll;
    }
    
    public String getMask() {
        return this.mask;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public Alt(final String lllllIlIIlllI, final String lllllIlIIlIlI) {
        this(lllllIlIIlllI, lllllIlIIlIlI, "");
    }
    
    public void setMask(final String lllllIIllIIIl) {
        this.mask = lllllIIllIIIl;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public Alt(final String lllllIlIIIlII, final String lllllIIllllll, final String lllllIIlllllI) {
        this.mask = "";
        this.username = lllllIlIIIlII;
        this.password = lllllIIllllll;
        this.mask = lllllIIlllllI;
    }
}
