package net.minecraft.stats;

import java.util.*;
import net.minecraft.entity.player.*;
import com.google.common.collect.*;
import net.minecraft.util.*;

public class StatFileWriter
{
    protected final /* synthetic */ Map field_150875_a;
    
    public boolean hasAchievementUnlocked(final Achievement lllllllllllllllIIIlIIIIlllIIlIll) {
        return this.writeStat(lllllllllllllllIIIlIIIIlllIIlIll) > 0;
    }
    
    public int writeStat(final StatBase lllllllllllllllIIIlIIIIlIllIllIl) {
        final TupleIntJsonSerializable lllllllllllllllIIIlIIIIlIllIllll = this.field_150875_a.get(lllllllllllllllIIIlIIIIlIllIllIl);
        return (lllllllllllllllIIIlIIIIlIllIllll == null) ? 0 : lllllllllllllllIIIlIIIIlIllIllll.getIntegerValue();
    }
    
    public int func_150874_c(final Achievement lllllllllllllllIIIlIIIIllIlIlIII) {
        if (this.hasAchievementUnlocked(lllllllllllllllIIIlIIIIllIlIlIII)) {
            return 0;
        }
        int lllllllllllllllIIIlIIIIllIlIllII = 0;
        for (Achievement lllllllllllllllIIIlIIIIllIlIlIlI = lllllllllllllllIIIlIIIIllIlIlIII.parentAchievement; lllllllllllllllIIIlIIIIllIlIlIlI != null && !this.hasAchievementUnlocked(lllllllllllllllIIIlIIIIllIlIlIlI); lllllllllllllllIIIlIIIIllIlIlIlI = lllllllllllllllIIIlIIIIllIlIlIlI.parentAchievement, ++lllllllllllllllIIIlIIIIllIlIllII) {}
        return lllllllllllllllIIIlIIIIllIlIllII;
    }
    
    static {
        __OBFID = "CL_00001481";
    }
    
    public void func_150871_b(final EntityPlayer lllllllllllllllIIIlIIIIllIIlllIl, final StatBase lllllllllllllllIIIlIIIIllIIlllII, final int lllllllllllllllIIIlIIIIllIIllIll) {
        if (!lllllllllllllllIIIlIIIIllIIlllII.isAchievement() || this.canUnlockAchievement((Achievement)lllllllllllllllIIIlIIIIllIIlllII)) {
            this.func_150873_a(lllllllllllllllIIIlIIIIllIIlllIl, lllllllllllllllIIIlIIIIllIIlllII, this.writeStat(lllllllllllllllIIIlIIIIllIIlllII) + lllllllllllllllIIIlIIIIllIIllIll);
        }
    }
    
    public StatFileWriter() {
        this.field_150875_a = Maps.newConcurrentMap();
    }
    
    public IJsonSerializable func_150870_b(final StatBase lllllllllllllllIIIlIIIIlIllIIlII) {
        final TupleIntJsonSerializable lllllllllllllllIIIlIIIIlIllIIllI = this.field_150875_a.get(lllllllllllllllIIIlIIIIlIllIIlII);
        return (lllllllllllllllIIIlIIIIlIllIIllI != null) ? lllllllllllllllIIIlIIIIlIllIIllI.getJsonSerializableValue() : null;
    }
    
    public IJsonSerializable func_150872_a(final StatBase lllllllllllllllIIIlIIIIlIlIIlllI, final IJsonSerializable lllllllllllllllIIIlIIIIlIlIlIlII) {
        TupleIntJsonSerializable lllllllllllllllIIIlIIIIlIlIlIIlI = this.field_150875_a.get(lllllllllllllllIIIlIIIIlIlIIlllI);
        if (lllllllllllllllIIIlIIIIlIlIlIIlI == null) {
            lllllllllllllllIIIlIIIIlIlIlIIlI = new TupleIntJsonSerializable();
            this.field_150875_a.put(lllllllllllllllIIIlIIIIlIlIIlllI, lllllllllllllllIIIlIIIIlIlIlIIlI);
        }
        lllllllllllllllIIIlIIIIlIlIlIIlI.setJsonSerializableValue(lllllllllllllllIIIlIIIIlIlIlIlII);
        return lllllllllllllllIIIlIIIIlIlIlIlII;
    }
    
    public void func_150873_a(final EntityPlayer lllllllllllllllIIIlIIIIllIIIllII, final StatBase lllllllllllllllIIIlIIIIllIIIlIlI, final int lllllllllllllllIIIlIIIIllIIIIIII) {
        TupleIntJsonSerializable lllllllllllllllIIIlIIIIllIIIIllI = this.field_150875_a.get(lllllllllllllllIIIlIIIIllIIIlIlI);
        if (lllllllllllllllIIIlIIIIllIIIIllI == null) {
            lllllllllllllllIIIlIIIIllIIIIllI = new TupleIntJsonSerializable();
            this.field_150875_a.put(lllllllllllllllIIIlIIIIllIIIlIlI, lllllllllllllllIIIlIIIIllIIIIllI);
        }
        lllllllllllllllIIIlIIIIllIIIIllI.setIntegerValue(lllllllllllllllIIIlIIIIllIIIIIII);
    }
    
    public boolean canUnlockAchievement(final Achievement lllllllllllllllIIIlIIIIlllIIIIll) {
        return lllllllllllllllIIIlIIIIlllIIIIll.parentAchievement == null || this.hasAchievementUnlocked(lllllllllllllllIIIlIIIIlllIIIIll.parentAchievement);
    }
}
