package shadersmod.client;

import java.util.*;

public class ShaderProfile
{
    private /* synthetic */ String name;
    private /* synthetic */ Set<String> disabledPrograms;
    private /* synthetic */ Map<String, String> mapOptionValues;
    
    public Collection<String> getDisabledPrograms() {
        return new HashSet<String>(this.disabledPrograms);
    }
    
    public void addOptionValues(final ShaderProfile lllllllllllllllIIIIIIIIIIlIlIlIl) {
        if (lllllllllllllllIIIIIIIIIIlIlIlIl != null) {
            this.mapOptionValues.putAll(lllllllllllllllIIIIIIIIIIlIlIlIl.mapOptionValues);
        }
    }
    
    public String[] getOptions() {
        final Set lllllllllllllllIIIIIIIIIIIlllllI = this.mapOptionValues.keySet();
        final String[] lllllllllllllllIIIIIIIIIIIllllIl = lllllllllllllllIIIIIIIIIIIlllllI.toArray(new String[lllllllllllllllIIIIIIIIIIIlllllI.size()]);
        return lllllllllllllllIIIIIIIIIIIllllIl;
    }
    
    public void addDisabledPrograms(final Collection<String> lllllllllllllllIIIIIIIIIIIlIIlll) {
        this.disabledPrograms.addAll(lllllllllllllllIIIIIIIIIIIlIIlll);
    }
    
    public void addOptionValue(final String lllllllllllllllIIIIIIIIIIlIlllll, final String lllllllllllllllIIIIIIIIIIlIllIll) {
        this.mapOptionValues.put(lllllllllllllllIIIIIIIIIIlIlllll, lllllllllllllllIIIIIIIIIIlIllIll);
    }
    
    public boolean isProgramDisabled(final String lllllllllllllllIIIIIIIIIIIIlllll) {
        return this.disabledPrograms.contains(lllllllllllllllIIIIIIIIIIIIlllll);
    }
    
    public String getValue(final String lllllllllllllllIIIIIIIIIIIllIllI) {
        return this.mapOptionValues.get(lllllllllllllllIIIIIIIIIIIllIllI);
    }
    
    public String getName() {
        return this.name;
    }
    
    public void applyOptionValues(final ShaderOption[] lllllllllllllllIIIIIIIIIIlIIllIl) {
        for (int lllllllllllllllIIIIIIIIIIlIIllII = 0; lllllllllllllllIIIIIIIIIIlIIllII < lllllllllllllllIIIIIIIIIIlIIllIl.length; ++lllllllllllllllIIIIIIIIIIlIIllII) {
            final ShaderOption lllllllllllllllIIIIIIIIIIlIIlIll = lllllllllllllllIIIIIIIIIIlIIllIl[lllllllllllllllIIIIIIIIIIlIIllII];
            final String lllllllllllllllIIIIIIIIIIlIIlIlI = lllllllllllllllIIIIIIIIIIlIIlIll.getName();
            final String lllllllllllllllIIIIIIIIIIlIIlIIl = this.mapOptionValues.get(lllllllllllllllIIIIIIIIIIlIIlIlI);
            if (lllllllllllllllIIIIIIIIIIlIIlIIl != null) {
                lllllllllllllllIIIIIIIIIIlIIlIll.setValue(lllllllllllllllIIIIIIIIIIlIIlIIl);
            }
        }
    }
    
    public void addDisabledProgram(final String lllllllllllllllIIIIIIIIIIIlIlllI) {
        this.disabledPrograms.add(lllllllllllllllIIIIIIIIIIIlIlllI);
    }
    
    public ShaderProfile(final String lllllllllllllllIIIIIIIIIIllIIlll) {
        this.name = null;
        this.mapOptionValues = new HashMap<String, String>();
        this.disabledPrograms = new HashSet<String>();
        this.name = lllllllllllllllIIIIIIIIIIllIIlll;
    }
}
