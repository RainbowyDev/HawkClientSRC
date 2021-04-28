package shadersmod.client;

import optifine.*;
import java.util.*;

public class ShaderOptionProfile extends ShaderOption
{
    private /* synthetic */ ShaderProfile[] profiles;
    private /* synthetic */ ShaderOption[] options;
    
    @Override
    public String getValueText(final String llllllllllllllIllIIlIIIllllIllIl) {
        return llllllllllllllIllIIlIIIllllIllIl.equals("<custom>") ? Lang.get("of.general.custom", "<custom>") : Shaders.translate(String.valueOf(new StringBuilder("profile.").append(llllllllllllllIllIIlIIIllllIllIl)), llllllllllllllIllIIlIIIllllIllIl);
    }
    
    @Override
    public String getValueColor(final String llllllllllllllIllIIlIIIllllIlIIl) {
        return llllllllllllllIllIIlIIIllllIlIIl.equals("<custom>") ? "§c" : "§a";
    }
    
    private static String detectProfileName(final ShaderProfile[] llllllllllllllIllIIlIIIllllIIlII, final ShaderOption[] llllllllllllllIllIIlIIIllllIIIll) {
        return detectProfileName(llllllllllllllIllIIlIIIllllIIlII, llllllllllllllIllIIlIIIllllIIIll, false);
    }
    
    private static String detectProfileName(final ShaderProfile[] llllllllllllllIllIIlIIIlllIllllI, final ShaderOption[] llllllllllllllIllIIlIIIlllIlllIl, final boolean llllllllllllllIllIIlIIIlllIlllII) {
        final ShaderProfile llllllllllllllIllIIlIIIlllIllIll = ShaderUtils.detectProfile(llllllllllllllIllIIlIIIlllIllllI, llllllllllllllIllIIlIIIlllIlllIl, llllllllllllllIllIIlIIIlllIlllII);
        return (llllllllllllllIllIIlIIIlllIllIll == null) ? "<custom>" : llllllllllllllIllIIlIIIlllIllIll.getName();
    }
    
    static {
        VALUE_CUSTOM = "<custom>";
        NAME_PROFILE = "<profile>";
    }
    
    public ShaderOptionProfile(final ShaderProfile[] llllllllllllllIllIIlIIlIIIlIllII, final ShaderOption[] llllllllllllllIllIIlIIlIIIlIlllI) {
        super("<profile>", "", detectProfileName(llllllllllllllIllIIlIIlIIIlIllII, llllllllllllllIllIIlIIlIIIlIlllI), getProfileNames(llllllllllllllIllIIlIIlIIIlIllII), detectProfileName(llllllllllllllIllIIlIIlIIIlIllII, llllllllllllllIllIIlIIlIIIlIlllI, true), null);
        this.profiles = null;
        this.options = null;
        this.profiles = llllllllllllllIllIIlIIlIIIlIllII;
        this.options = llllllllllllllIllIIlIIlIIIlIlllI;
    }
    
    private void applyProfileOptions() {
        final ShaderProfile llllllllllllllIllIIlIIlIIIIlIllI = this.getProfile(this.getValue());
        if (llllllllllllllIllIIlIIlIIIIlIllI != null) {
            final String[] llllllllllllllIllIIlIIlIIIIlIlIl = llllllllllllllIllIIlIIlIIIIlIllI.getOptions();
            for (int llllllllllllllIllIIlIIlIIIIlIlII = 0; llllllllllllllIllIIlIIlIIIIlIlII < llllllllllllllIllIIlIIlIIIIlIlIl.length; ++llllllllllllllIllIIlIIlIIIIlIlII) {
                final String llllllllllllllIllIIlIIlIIIIlIIll = llllllllllllllIllIIlIIlIIIIlIlIl[llllllllllllllIllIIlIIlIIIIlIlII];
                final ShaderOption llllllllllllllIllIIlIIlIIIIlIIlI = this.getOption(llllllllllllllIllIIlIIlIIIIlIIll);
                if (llllllllllllllIllIIlIIlIIIIlIIlI != null) {
                    final String llllllllllllllIllIIlIIlIIIIlIIIl = llllllllllllllIllIIlIIlIIIIlIllI.getValue(llllllllllllllIllIIlIIlIIIIlIIll);
                    llllllllllllllIllIIlIIlIIIIlIIlI.setValue(llllllllllllllIllIIlIIlIIIIlIIIl);
                }
            }
        }
    }
    
    private ShaderProfile getProfile(final String llllllllllllllIllIIlIIIlllllIlII) {
        for (int llllllllllllllIllIIlIIIlllllIlll = 0; llllllllllllllIllIIlIIIlllllIlll < this.profiles.length; ++llllllllllllllIllIIlIIIlllllIlll) {
            final ShaderProfile llllllllllllllIllIIlIIIlllllIllI = this.profiles[llllllllllllllIllIIlIIIlllllIlll];
            if (llllllllllllllIllIIlIIIlllllIllI.getName().equals(llllllllllllllIllIIlIIIlllllIlII)) {
                return llllllllllllllIllIIlIIIlllllIllI;
            }
        }
        return null;
    }
    
    @Override
    public String getNameText() {
        return Lang.get("of.shaders.profile");
    }
    
    private ShaderOption getOption(final String llllllllllllllIllIIlIIlIIIIIIIII) {
        for (int llllllllllllllIllIIlIIlIIIIIIIll = 0; llllllllllllllIllIIlIIlIIIIIIIll < this.options.length; ++llllllllllllllIllIIlIIlIIIIIIIll) {
            final ShaderOption llllllllllllllIllIIlIIlIIIIIIIlI = this.options[llllllllllllllIllIIlIIlIIIIIIIll];
            if (llllllllllllllIllIIlIIlIIIIIIIlI.getName().equals(llllllllllllllIllIIlIIlIIIIIIIII)) {
                return llllllllllllllIllIIlIIlIIIIIIIlI;
            }
        }
        return null;
    }
    
    @Override
    public void nextValue() {
        super.nextValue();
        if (this.getValue().equals("<custom>")) {
            super.nextValue();
        }
        this.applyProfileOptions();
    }
    
    public void updateProfile() {
        final ShaderProfile llllllllllllllIllIIlIIlIIIlIIIll = this.getProfile(this.getValue());
        if (llllllllllllllIllIIlIIlIIIlIIIll == null || !ShaderUtils.matchProfile(llllllllllllllIllIIlIIlIIIlIIIll, this.options, false)) {
            final String llllllllllllllIllIIlIIlIIIlIIIlI = detectProfileName(this.profiles, this.options);
            this.setValue(llllllllllllllIllIIlIIlIIIlIIIlI);
        }
    }
    
    private static String[] getProfileNames(final ShaderProfile[] llllllllllllllIllIIlIIIlllIIllIl) {
        final ArrayList llllllllllllllIllIIlIIIlllIlIIIl = new ArrayList();
        for (int llllllllllllllIllIIlIIIlllIlIIII = 0; llllllllllllllIllIIlIIIlllIlIIII < llllllllllllllIllIIlIIIlllIIllIl.length; ++llllllllllllllIllIIlIIIlllIlIIII) {
            final ShaderProfile llllllllllllllIllIIlIIIlllIIllll = llllllllllllllIllIIlIIIlllIIllIl[llllllllllllllIllIIlIIIlllIlIIII];
            llllllllllllllIllIIlIIIlllIlIIIl.add(llllllllllllllIllIIlIIIlllIIllll.getName());
        }
        llllllllllllllIllIIlIIIlllIlIIIl.add("<custom>");
        final String[] llllllllllllllIllIIlIIIlllIIlllI = llllllllllllllIllIIlIIIlllIlIIIl.toArray(new String[llllllllllllllIllIIlIIIlllIlIIIl.size()]);
        return llllllllllllllIllIIlIIIlllIIlllI;
    }
}
