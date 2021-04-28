package net.minecraft.util;

import java.util.*;

public class EnchantmentNameParts
{
    private /* synthetic */ String[] namePartsArray;
    private /* synthetic */ Random rand;
    private static final /* synthetic */ EnchantmentNameParts instance;
    
    public String generateNewRandomName() {
        final int lllllllllllllllllIIIIlIIIIIIIlII = this.rand.nextInt(2) + 3;
        String lllllllllllllllllIIIIlIIIIIIIIll = "";
        for (int lllllllllllllllllIIIIlIIIIIIIIlI = 0; lllllllllllllllllIIIIlIIIIIIIIlI < lllllllllllllllllIIIIlIIIIIIIlII; ++lllllllllllllllllIIIIlIIIIIIIIlI) {
            if (lllllllllllllllllIIIIlIIIIIIIIlI > 0) {
                lllllllllllllllllIIIIlIIIIIIIIll = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllllIIIIlIIIIIIIIll)).append(" "));
            }
            lllllllllllllllllIIIIlIIIIIIIIll = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllllIIIIlIIIIIIIIll)).append(this.namePartsArray[this.rand.nextInt(this.namePartsArray.length)]));
        }
        return lllllllllllllllllIIIIlIIIIIIIIll;
    }
    
    public static EnchantmentNameParts func_178176_a() {
        return EnchantmentNameParts.instance;
    }
    
    static {
        __OBFID = "CL_00000756";
        instance = new EnchantmentNameParts();
    }
    
    public void reseedRandomGenerator(final long lllllllllllllllllIIIIIlllllllIII) {
        this.rand.setSeed(lllllllllllllllllIIIIIlllllllIII);
    }
    
    public EnchantmentNameParts() {
        this.rand = new Random();
        this.namePartsArray = "the elder scrolls klaatu berata niktu xyzzy bless curse light darkness fire air earth water hot dry cold wet ignite snuff embiggen twist shorten stretch fiddle destroy imbue galvanize enchant free limited range of towards inside sphere cube self other ball mental physical grow shrink demon elemental spirit animal creature beast humanoid undead fresh stale ".split(" ");
    }
}
