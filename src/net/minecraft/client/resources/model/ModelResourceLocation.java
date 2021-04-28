package net.minecraft.client.resources.model;

import net.minecraft.util.*;
import org.apache.commons.lang3.*;

public class ModelResourceLocation extends ResourceLocation
{
    private final /* synthetic */ String field_177519_c;
    
    protected static String[] func_177517_b(final String lllllllllllllllIIlIIlllllIlIIlIl) {
        final String[] lllllllllllllllIIlIIlllllIlIlIII = { null, lllllllllllllllIIlIIlllllIlIIlIl, null };
        final int lllllllllllllllIIlIIlllllIlIIlll = lllllllllllllllIIlIIlllllIlIIlIl.indexOf(35);
        String lllllllllllllllIIlIIlllllIlIIllI = lllllllllllllllIIlIIlllllIlIIlIl;
        if (lllllllllllllllIIlIIlllllIlIIlll >= 0) {
            lllllllllllllllIIlIIlllllIlIlIII[2] = lllllllllllllllIIlIIlllllIlIIlIl.substring(lllllllllllllllIIlIIlllllIlIIlll + 1, lllllllllllllllIIlIIlllllIlIIlIl.length());
            if (lllllllllllllllIIlIIlllllIlIIlll > 1) {
                lllllllllllllllIIlIIlllllIlIIllI = lllllllllllllllIIlIIlllllIlIIlIl.substring(0, lllllllllllllllIIlIIlllllIlIIlll);
            }
        }
        System.arraycopy(ResourceLocation.func_177516_a(lllllllllllllllIIlIIlllllIlIIllI), 0, lllllllllllllllIIlIIlllllIlIlIII, 0, 2);
        return lllllllllllllllIIlIIlllllIlIlIII;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder(String.valueOf(super.toString())).append('#').append(this.field_177519_c));
    }
    
    public String func_177518_c() {
        return this.field_177519_c;
    }
    
    static {
        __OBFID = "CL_00002387";
    }
    
    public ModelResourceLocation(final ResourceLocation lllllllllllllllIIlIIlllllIlllIII, final String lllllllllllllllIIlIIlllllIllIlll) {
        this(lllllllllllllllIIlIIlllllIlllIII.toString(), lllllllllllllllIIlIIlllllIllIlll);
    }
    
    public ModelResourceLocation(final String lllllllllllllllIIlIIllllllIIIIlI) {
        this(0, func_177517_b(lllllllllllllllIIlIIllllllIIIIlI));
    }
    
    protected ModelResourceLocation(final int lllllllllllllllIIlIIllllllIIlIIl, final String... lllllllllllllllIIlIIllllllIIIllI) {
        super(0, new String[] { lllllllllllllllIIlIIllllllIIIllI[0], lllllllllllllllIIlIIllllllIIIllI[1] });
        this.field_177519_c = (StringUtils.isEmpty((CharSequence)lllllllllllllllIIlIIllllllIIIllI[2]) ? "normal" : lllllllllllllllIIlIIllllllIIIllI[2].toLowerCase());
    }
    
    public ModelResourceLocation(final String lllllllllllllllIIlIIlllllIllIIlI, final String lllllllllllllllIIlIIlllllIlIlllI) {
        this(0, func_177517_b(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIlIIlllllIllIIlI)).append('#').append((lllllllllllllllIIlIIlllllIlIlllI == null) ? "normal" : lllllllllllllllIIlIIlllllIlIlllI))));
    }
    
    @Override
    public boolean equals(final Object lllllllllllllllIIlIIlllllIIlIlll) {
        if (this == lllllllllllllllIIlIIlllllIIlIlll) {
            return true;
        }
        if (lllllllllllllllIIlIIlllllIIlIlll instanceof ModelResourceLocation && super.equals(lllllllllllllllIIlIIlllllIIlIlll)) {
            final ModelResourceLocation lllllllllllllllIIlIIlllllIIllIIl = (ModelResourceLocation)lllllllllllllllIIlIIlllllIIlIlll;
            return this.field_177519_c.equals(lllllllllllllllIIlIIlllllIIllIIl.field_177519_c);
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return 31 * super.hashCode() + this.field_177519_c.hashCode();
    }
}
