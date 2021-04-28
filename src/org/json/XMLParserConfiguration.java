package org.json;

public class XMLParserConfiguration
{
    public final /* synthetic */ boolean keepStrings;
    public final /* synthetic */ boolean convertNilAttributeToNull;
    public final /* synthetic */ String cDataTagName;
    
    static {
        ORIGINAL = new XMLParserConfiguration();
        KEEP_STRINGS = new XMLParserConfiguration(true);
    }
    
    public XMLParserConfiguration(final boolean llllllllllllllIllIIIIIIllIIlIIlI, final String llllllllllllllIllIIIIIIllIIlIIIl) {
        this.keepStrings = llllllllllllllIllIIIIIIllIIlIIlI;
        this.cDataTagName = llllllllllllllIllIIIIIIllIIlIIIl;
        this.convertNilAttributeToNull = false;
    }
    
    public XMLParserConfiguration() {
        this(false, "content", false);
    }
    
    public XMLParserConfiguration(final boolean llllllllllllllIllIIIIIIllIlIIIII) {
        this(llllllllllllllIllIIIIIIllIlIIIII, "content", false);
    }
    
    public XMLParserConfiguration(final boolean llllllllllllllIllIIIIIIllIIIIlll, final String llllllllllllllIllIIIIIIllIIIIllI, final boolean llllllllllllllIllIIIIIIllIIIIlIl) {
        this.keepStrings = llllllllllllllIllIIIIIIllIIIIlll;
        this.cDataTagName = llllllllllllllIllIIIIIIllIIIIllI;
        this.convertNilAttributeToNull = llllllllllllllIllIIIIIIllIIIIlIl;
    }
    
    public XMLParserConfiguration(final String llllllllllllllIllIIIIIIllIIllIlI) {
        this(false, llllllllllllllIllIIIIIIllIIllIlI, false);
    }
}
