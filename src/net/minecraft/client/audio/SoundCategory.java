package net.minecraft.client.audio;

import java.util.*;
import com.google.common.collect.*;

public enum SoundCategory
{
    WEATHER("WEATHER", 3, "WEATHER", 3, "weather", 3);
    
    private final /* synthetic */ int categoryId;
    
    RECORDS("RECORDS", 2, "RECORDS", 2, "record", 2);
    
    private static final /* synthetic */ Map field_147169_k;
    
    AMBIENT("AMBIENT", 8, "AMBIENT", 8, "ambient", 8), 
    ANIMALS("ANIMALS", 6, "ANIMALS", 6, "neutral", 6), 
    MOBS("MOBS", 5, "MOBS", 5, "hostile", 5), 
    BLOCKS("BLOCKS", 4, "BLOCKS", 4, "block", 4), 
    MASTER("MASTER", 0, "MASTER", 0, "master", 0), 
    PLAYERS("PLAYERS", 7, "PLAYERS", 7, "player", 7);
    
    private static final /* synthetic */ Map field_147168_j;
    
    MUSIC("MUSIC", 1, "MUSIC", 1, "music", 1);
    
    private final /* synthetic */ String categoryName;
    
    public static SoundCategory func_147154_a(final String lllllllllllllllIIllIllIlIlIlIIII) {
        return SoundCategory.field_147168_j.get(lllllllllllllllIIllIllIlIlIlIIII);
    }
    
    private SoundCategory(final String lllllllllllllllIIllIllIlIlIlllII, final int lllllllllllllllIIllIllIlIlIllIll, final String lllllllllllllllIIllIllIlIllIIIIl, final int lllllllllllllllIIllIllIlIllIIIII, final String lllllllllllllllIIllIllIlIlIlllll, final int lllllllllllllllIIllIllIlIlIllllI) {
        this.categoryName = lllllllllllllllIIllIllIlIlIlllll;
        this.categoryId = lllllllllllllllIIllIllIlIlIllllI;
    }
    
    static {
        __OBFID = "CL_00001686";
        field_147168_j = Maps.newHashMap();
        field_147169_k = Maps.newHashMap();
        for (final SoundCategory lllllllllllllllIIllIllIlIlllIIlI : values()) {
            if (SoundCategory.field_147168_j.containsKey(lllllllllllllllIIllIllIlIlllIIlI.getCategoryName()) || SoundCategory.field_147169_k.containsKey(lllllllllllllllIIllIllIlIlllIIlI.getCategoryId())) {
                throw new Error(String.valueOf(new StringBuilder("Clash in Sound Category ID & Name pools! Cannot insert ").append(lllllllllllllllIIllIllIlIlllIIlI)));
            }
            SoundCategory.field_147168_j.put(lllllllllllllllIIllIllIlIlllIIlI.getCategoryName(), lllllllllllllllIIllIllIlIlllIIlI);
            SoundCategory.field_147169_k.put(lllllllllllllllIIllIllIlIlllIIlI.getCategoryId(), lllllllllllllllIIllIllIlIlllIIlI);
        }
    }
    
    public int getCategoryId() {
        return this.categoryId;
    }
    
    public String getCategoryName() {
        return this.categoryName;
    }
}
