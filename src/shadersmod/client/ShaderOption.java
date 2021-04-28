package shadersmod.client;

import java.util.*;
import optifine.*;

public abstract class ShaderOption
{
    private /* synthetic */ String valueDefault;
    private /* synthetic */ String[] values;
    private /* synthetic */ String name;
    private /* synthetic */ String value;
    private /* synthetic */ String[] paths;
    private /* synthetic */ boolean visible;
    private /* synthetic */ boolean enabled;
    private /* synthetic */ String description;
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append(this.name).append(", value: ").append(this.value).append(", valueDefault: ").append(this.valueDefault).append(", paths: ").append(Config.arrayToString(this.paths)));
    }
    
    public String getValue() {
        return this.value;
    }
    
    public String getSourceLine() {
        return null;
    }
    
    public boolean checkUsed() {
        return false;
    }
    
    public boolean matchesLine(final String llllllllllllllIlllllIIIllIllIlIl) {
        return false;
    }
    
    public String getValueColor(final String llllllllllllllIlllllIIIllIlllIII) {
        return "";
    }
    
    public boolean isEnabled() {
        return this.enabled;
    }
    
    public String getName() {
        return this.name;
    }
    
    public boolean setValue(final String llllllllllllllIlllllIIlIIIlIIllI) {
        final int llllllllllllllIlllllIIlIIIlIlIlI = getIndex(llllllllllllllIlllllIIlIIIlIIllI, this.values);
        if (llllllllllllllIlllllIIlIIIlIlIlI < 0) {
            return false;
        }
        this.value = llllllllllllllIlllllIIlIIIlIIllI;
        return true;
    }
    
    public String[] getValues() {
        return this.values.clone();
    }
    
    public ShaderOption(final String llllllllllllllIlllllIIlIIllIlIIl, final String llllllllllllllIlllllIIlIIlllIIII, final String llllllllllllllIlllllIIlIIllIllll, final String[] llllllllllllllIlllllIIlIIllIIIll, final String llllllllllllllIlllllIIlIIllIllII, final String llllllllllllllIlllllIIlIIlIlllll) {
        this.name = null;
        this.description = null;
        this.value = null;
        this.values = null;
        this.valueDefault = null;
        this.paths = null;
        this.enabled = true;
        this.visible = true;
        this.name = llllllllllllllIlllllIIlIIllIlIIl;
        this.description = llllllllllllllIlllllIIlIIlllIIII;
        this.value = llllllllllllllIlllllIIlIIllIllll;
        this.values = llllllllllllllIlllllIIlIIllIIIll;
        this.valueDefault = llllllllllllllIlllllIIlIIllIllII;
        if (llllllllllllllIlllllIIlIIlIlllll != null) {
            this.paths = new String[] { llllllllllllllIlllllIIlIIlIlllll };
        }
    }
    
    public String getValueText(final String llllllllllllllIlllllIIIllIllllII) {
        return llllllllllllllIlllllIIIllIllllII;
    }
    
    public void addPaths(final String[] llllllllllllllIlllllIIIlllllIlll) {
        final List llllllllllllllIlllllIIIlllllllIl = Arrays.asList(this.paths);
        for (int llllllllllllllIlllllIIIlllllllII = 0; llllllllllllllIlllllIIIlllllllII < llllllllllllllIlllllIIIlllllIlll.length; ++llllllllllllllIlllllIIIlllllllII) {
            final String llllllllllllllIlllllIIIllllllIlI = llllllllllllllIlllllIIIlllllIlll[llllllllllllllIlllllIIIlllllllII];
            if (!llllllllllllllIlllllIIIlllllllIl.contains(llllllllllllllIlllllIIIllllllIlI)) {
                this.paths = (String[])Config.addObjectToArray(this.paths, llllllllllllllIlllllIIIllllllIlI);
            }
        }
    }
    
    public void nextValue() {
        int llllllllllllllIlllllIIlIIIIlIlll = getIndex(this.value, this.values);
        if (llllllllllllllIlllllIIlIIIIlIlll >= 0) {
            llllllllllllllIlllllIIlIIIIlIlll = (llllllllllllllIlllllIIlIIIIlIlll + 1) % this.values.length;
            this.value = this.values[llllllllllllllIlllllIIlIIIIlIlll];
        }
    }
    
    public void setEnabled(final boolean llllllllllllllIlllllIIIllllIIlll) {
        this.enabled = llllllllllllllIlllllIIIllllIIlll;
    }
    
    public boolean isVisible() {
        return this.visible;
    }
    
    public String getDescriptionText() {
        String llllllllllllllIlllllIIlIIlIIlIIl = Config.normalize(this.description);
        llllllllllllllIlllllIIlIIlIIlIIl = StrUtils.removePrefix(llllllllllllllIlllllIIlIIlIIlIIl, "//");
        llllllllllllllIlllllIIlIIlIIlIIl = Shaders.translate(String.valueOf(new StringBuilder("option.").append(this.getName()).append(".comment")), llllllllllllllIlllllIIlIIlIIlIIl);
        return llllllllllllllIlllllIIlIIlIIlIIl;
    }
    
    static {
        COLOR_GREEN = "§a";
        COLOR_RED = "§c";
        COLOR_BLUE = "§9";
    }
    
    public void resetValue() {
        this.value = this.valueDefault;
    }
    
    public boolean isChanged() {
        return !Config.equals(this.value, this.valueDefault);
    }
    
    private static int getIndex(final String llllllllllllllIlllllIIlIIIIlIIII, final String[] llllllllllllllIlllllIIlIIIIIllll) {
        for (int llllllllllllllIlllllIIlIIIIIlllI = 0; llllllllllllllIlllllIIlIIIIIlllI < llllllllllllllIlllllIIlIIIIIllll.length; ++llllllllllllllIlllllIIlIIIIIlllI) {
            final String llllllllllllllIlllllIIlIIIIIllIl = llllllllllllllIlllllIIlIIIIIllll[llllllllllllllIlllllIIlIIIIIlllI];
            if (llllllllllllllIlllllIIlIIIIIllIl.equals(llllllllllllllIlllllIIlIIIIlIIII)) {
                return llllllllllllllIlllllIIlIIIIIlllI;
            }
        }
        return -1;
    }
    
    public void setDescription(final String llllllllllllllIlllllIIlIIIlllllI) {
        this.description = llllllllllllllIlllllIIlIIIlllllI;
    }
    
    public void setVisible(final boolean llllllllllllllIlllllIIIlllIlIIlI) {
        this.visible = llllllllllllllIlllllIIIlllIlIIlI;
    }
    
    public boolean isValidValue(final String llllllllllllllIlllllIIIlllIIllII) {
        return getIndex(llllllllllllllIlllllIIIlllIIllII, this.values) >= 0;
    }
    
    public String getValueDefault() {
        return this.valueDefault;
    }
    
    public String[] getPaths() {
        return this.paths;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public boolean isUsedInLine(final String llllllllllllllIlllllIIIllIllIIlI) {
        return false;
    }
    
    public String getNameText() {
        return Shaders.translate(String.valueOf(new StringBuilder("option.").append(this.name)), this.name);
    }
}
