package net.minecraft.util;

import org.apache.commons.lang3.*;

public class ResourceLocation
{
    protected final /* synthetic */ String resourceDomain;
    protected final /* synthetic */ String resourcePath;
    
    @Override
    public boolean equals(final Object llllllllllllllIlllIIIIIllIllIllI) {
        if (this == llllllllllllllIlllIIIIIllIllIllI) {
            return true;
        }
        if (!(llllllllllllllIlllIIIIIllIllIllI instanceof ResourceLocation)) {
            return false;
        }
        final ResourceLocation llllllllllllllIlllIIIIIllIlllIII = (ResourceLocation)llllllllllllllIlllIIIIIllIllIllI;
        return this.resourceDomain.equals(llllllllllllllIlllIIIIIllIlllIII.resourceDomain) && this.resourcePath.equals(llllllllllllllIlllIIIIIllIlllIII.resourcePath);
    }
    
    public String getResourceDomain() {
        return this.resourceDomain;
    }
    
    public String getResourcePath() {
        return this.resourcePath;
    }
    
    @Override
    public int hashCode() {
        return 31 * this.resourceDomain.hashCode() + this.resourcePath.hashCode();
    }
    
    public ResourceLocation(final String llllllllllllllIlllIIIIIlllIlIlII, final String llllllllllllllIlllIIIIIlllIlIIll) {
        this(0, new String[] { llllllllllllllIlllIIIIIlllIlIlII, llllllllllllllIlllIIIIIlllIlIIll });
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder(String.valueOf(this.resourceDomain)).append(':').append(this.resourcePath));
    }
    
    public ResourceLocation(final String llllllllllllllIlllIIIIIlllIllIIl) {
        this(0, func_177516_a(llllllllllllllIlllIIIIIlllIllIIl));
    }
    
    protected static String[] func_177516_a(final String llllllllllllllIlllIIIIIlllIIlIIl) {
        final String[] llllllllllllllIlllIIIIIlllIIlIll = { null, llllllllllllllIlllIIIIIlllIIlIIl };
        final int llllllllllllllIlllIIIIIlllIIlIlI = llllllllllllllIlllIIIIIlllIIlIIl.indexOf(58);
        if (llllllllllllllIlllIIIIIlllIIlIlI >= 0) {
            llllllllllllllIlllIIIIIlllIIlIll[1] = llllllllllllllIlllIIIIIlllIIlIIl.substring(llllllllllllllIlllIIIIIlllIIlIlI + 1, llllllllllllllIlllIIIIIlllIIlIIl.length());
            if (llllllllllllllIlllIIIIIlllIIlIlI > 1) {
                llllllllllllllIlllIIIIIlllIIlIll[0] = llllllllllllllIlllIIIIIlllIIlIIl.substring(0, llllllllllllllIlllIIIIIlllIIlIlI);
            }
        }
        return llllllllllllllIlllIIIIIlllIIlIll;
    }
    
    static {
        __OBFID = "CL_00001082";
    }
    
    protected ResourceLocation(final int llllllllllllllIlllIIIIIllllIIIlI, final String... llllllllllllllIlllIIIIIlllIlllll) {
        this.resourceDomain = (StringUtils.isEmpty((CharSequence)llllllllllllllIlllIIIIIlllIlllll[0]) ? "minecraft" : llllllllllllllIlllIIIIIlllIlllll[0].toLowerCase());
        this.resourcePath = llllllllllllllIlllIIIIIlllIlllll[1];
        Validate.notNull((Object)this.resourcePath);
    }
}
