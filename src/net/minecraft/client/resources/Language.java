package net.minecraft.client.resources;

public class Language implements Comparable
{
    private final /* synthetic */ String region;
    private final /* synthetic */ String languageCode;
    private final /* synthetic */ String name;
    private final /* synthetic */ boolean bidirectional;
    
    @Override
    public boolean equals(final Object llllllllllllllIllIIlIlIIIlllIIll) {
        return this == llllllllllllllIllIIlIlIIIlllIIll || (llllllllllllllIllIIlIlIIIlllIIll instanceof Language && this.languageCode.equals(((Language)llllllllllllllIllIIlIlIIIlllIIll).languageCode));
    }
    
    static {
        __OBFID = "CL_00001095";
    }
    
    public int compareTo(final Language llllllllllllllIllIIlIlIIIllIlIlI) {
        return this.languageCode.compareTo(llllllllllllllIllIIlIlIIIllIlIlI.languageCode);
    }
    
    @Override
    public int hashCode() {
        return this.languageCode.hashCode();
    }
    
    public String getLanguageCode() {
        return this.languageCode;
    }
    
    public boolean isBidirectional() {
        return this.bidirectional;
    }
    
    @Override
    public int compareTo(final Object llllllllllllllIllIIlIlIIIllIIIlI) {
        return this.compareTo((Language)llllllllllllllIllIIlIlIIIllIIIlI);
    }
    
    public Language(final String llllllllllllllIllIIlIlIIlIIIlIII, final String llllllllllllllIllIIlIlIIlIIIIlll, final String llllllllllllllIllIIlIlIIlIIIIIIl, final boolean llllllllllllllIllIIlIlIIlIIIIlIl) {
        this.languageCode = llllllllllllllIllIIlIlIIlIIIlIII;
        this.region = llllllllllllllIllIIlIlIIlIIIIlll;
        this.name = llllllllllllllIllIIlIlIIlIIIIIIl;
        this.bidirectional = llllllllllllllIllIIlIlIIlIIIIlIl;
    }
    
    @Override
    public String toString() {
        return String.format("%s (%s)", this.name, this.region);
    }
}
