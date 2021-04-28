package net.minecraft.realms;

import net.minecraft.util.*;
import com.google.common.collect.*;
import net.minecraft.world.storage.*;
import java.util.*;
import net.minecraft.client.*;

public class RealmsAnvilLevelStorageSource
{
    private /* synthetic */ ISaveFormat levelStorageSource;
    
    public boolean convertLevel(final String lllllllllllllllIllIlIllIIlIIllII, final IProgressUpdate lllllllllllllllIllIlIllIIlIIlIll) {
        return this.levelStorageSource.convertMapFormat(lllllllllllllllIllIlIllIIlIIllII, lllllllllllllllIllIlIllIIlIIlIll);
    }
    
    public List getLevelList() throws AnvilConverterException {
        final ArrayList lllllllllllllllIllIlIlIlllllllll = Lists.newArrayList();
        for (final SaveFormatComparator lllllllllllllllIllIlIlIllllllIll : this.levelStorageSource.getSaveList()) {
            lllllllllllllllIllIlIlIlllllllll.add(new RealmsLevelSummary(lllllllllllllllIllIlIlIllllllIll));
        }
        return lllllllllllllllIllIlIlIlllllllll;
    }
    
    public void clearAll() {
        this.levelStorageSource.flushCache();
    }
    
    public void renameLevel(final String lllllllllllllllIllIlIllIIIIllIll, final String lllllllllllllllIllIlIllIIIIlIllI) {
        this.levelStorageSource.renameWorld(lllllllllllllllIllIlIllIIIIllIll, lllllllllllllllIllIlIllIIIIlIllI);
    }
    
    public boolean deleteLevel(final String lllllllllllllllIllIlIllIIIlIllll) {
        return this.levelStorageSource.deleteWorldDirectory(lllllllllllllllIllIlIllIIIlIllll);
    }
    
    public boolean levelExists(final String lllllllllllllllIllIlIllIIlIlIlll) {
        return this.levelStorageSource.canLoadWorld(lllllllllllllllIllIlIllIIlIlIlll);
    }
    
    static {
        __OBFID = "CL_00001856";
    }
    
    public boolean isNewLevelIdAcceptable(final String lllllllllllllllIllIlIllIIIlllIIl) {
        return this.levelStorageSource.func_154335_d(lllllllllllllllIllIlIllIIIlllIIl);
    }
    
    public String getName() {
        return this.levelStorageSource.func_154333_a();
    }
    
    public boolean requiresConversion(final String lllllllllllllllIllIlIllIIIllllll) {
        return this.levelStorageSource.isOldMapFormat(lllllllllllllllIllIlIllIIIllllll);
    }
    
    public RealmsAnvilLevelStorageSource(final ISaveFormat lllllllllllllllIllIlIllIIllIIllI) {
        this.levelStorageSource = lllllllllllllllIllIlIllIIllIIllI;
    }
    
    public boolean isConvertible(final String lllllllllllllllIllIlIllIIIlIIIII) {
        return this.levelStorageSource.func_154334_a(lllllllllllllllIllIlIllIIIlIIIII);
    }
}
