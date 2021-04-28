package optifine;

import net.minecraft.nbt.*;
import java.util.*;
import org.apache.commons.lang3.*;

public class NbtTagValue
{
    private /* synthetic */ int type;
    private /* synthetic */ String[] parents;
    private /* synthetic */ String value;
    private /* synthetic */ String name;
    
    private boolean matches(final NBTBase llllllllllllllIlIlllIllIlIllllII) {
        if (llllllllllllllIlIlllIllIlIllllII == null) {
            return false;
        }
        final String llllllllllllllIlIlllIllIlIlllllI = getValue(llllllllllllllIlIlllIllIlIllllII);
        if (llllllllllllllIlIlllIllIlIlllllI == null) {
            return false;
        }
        switch (this.type) {
            case 0: {
                return llllllllllllllIlIlllIllIlIlllllI.equals(this.value);
            }
            case 1: {
                return this.matchesPattern(llllllllllllllIlIlllIllIlIlllllI, this.value);
            }
            case 2: {
                return this.matchesPattern(llllllllllllllIlIlllIllIlIlllllI.toLowerCase(), this.value);
            }
            case 3: {
                return this.matchesRegex(llllllllllllllIlIlllIllIlIlllllI, this.value);
            }
            case 4: {
                return this.matchesRegex(llllllllllllllIlIlllIllIlIlllllI.toLowerCase(), this.value);
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder("Unknown NbtTagValue type: ").append(this.type)));
            }
        }
    }
    
    public boolean matches(final NBTTagCompound llllllllllllllIlIlllIllIlllIllIl) {
        if (llllllllllllllIlIlllIllIlllIllIl == null) {
            return false;
        }
        Object llllllllllllllIlIlllIllIllllIIlI = llllllllllllllIlIlllIllIlllIllIl;
        for (int llllllllllllllIlIlllIllIllllIIIl = 0; llllllllllllllIlIlllIllIllllIIIl < this.parents.length; ++llllllllllllllIlIlllIllIllllIIIl) {
            final String llllllllllllllIlIlllIllIllllIIII = this.parents[llllllllllllllIlIlllIllIllllIIIl];
            llllllllllllllIlIlllIllIllllIIlI = getChildTag((NBTBase)llllllllllllllIlIlllIllIllllIIlI, llllllllllllllIlIlllIllIllllIIII);
            if (llllllllllllllIlIlllIllIllllIIlI == null) {
                return false;
            }
        }
        if (this.name.equals("*")) {
            return this.matchesAnyChild((NBTBase)llllllllllllllIlIlllIllIllllIIlI);
        }
        final NBTBase llllllllllllllIlIlllIllIlllIllll = getChildTag((NBTBase)llllllllllllllIlIlllIllIllllIIlI, this.name);
        return llllllllllllllIlIlllIllIlllIllll != null && this.matches(llllllllllllllIlIlllIllIlllIllll);
    }
    
    private static String getValue(final NBTBase llllllllllllllIlIlllIllIlIlIIIlI) {
        if (llllllllllllllIlIlllIllIlIlIIIlI == null) {
            return null;
        }
        if (llllllllllllllIlIlllIllIlIlIIIlI instanceof NBTTagString) {
            final NBTTagString llllllllllllllIlIlllIllIlIlIlIIl = (NBTTagString)llllllllllllllIlIlllIllIlIlIIIlI;
            return llllllllllllllIlIlllIllIlIlIlIIl.getString();
        }
        if (llllllllllllllIlIlllIllIlIlIIIlI instanceof NBTTagInt) {
            final NBTTagInt llllllllllllllIlIlllIllIlIlIlIII = (NBTTagInt)llllllllllllllIlIlllIllIlIlIIIlI;
            return Integer.toString(llllllllllllllIlIlllIllIlIlIlIII.getInt());
        }
        if (llllllllllllllIlIlllIllIlIlIIIlI instanceof NBTTagByte) {
            final NBTTagByte llllllllllllllIlIlllIllIlIlIIlll = (NBTTagByte)llllllllllllllIlIlllIllIlIlIIIlI;
            return Byte.toString(llllllllllllllIlIlllIllIlIlIIlll.getByte());
        }
        if (llllllllllllllIlIlllIllIlIlIIIlI instanceof NBTTagShort) {
            final NBTTagShort llllllllllllllIlIlllIllIlIlIIllI = (NBTTagShort)llllllllllllllIlIlllIllIlIlIIIlI;
            return Short.toString(llllllllllllllIlIlllIllIlIlIIllI.getShort());
        }
        if (llllllllllllllIlIlllIllIlIlIIIlI instanceof NBTTagLong) {
            final NBTTagLong llllllllllllllIlIlllIllIlIlIIlIl = (NBTTagLong)llllllllllllllIlIlllIllIlIlIIIlI;
            return Long.toString(llllllllllllllIlIlllIllIlIlIIlIl.getLong());
        }
        if (llllllllllllllIlIlllIllIlIlIIIlI instanceof NBTTagFloat) {
            final NBTTagFloat llllllllllllllIlIlllIllIlIlIIlII = (NBTTagFloat)llllllllllllllIlIlllIllIlIlIIIlI;
            return Float.toString(llllllllllllllIlIlllIllIlIlIIlII.getFloat());
        }
        if (llllllllllllllIlIlllIllIlIlIIIlI instanceof NBTTagDouble) {
            final NBTTagDouble llllllllllllllIlIlllIllIlIlIIIll = (NBTTagDouble)llllllllllllllIlIlllIllIlIlIIIlI;
            return Double.toString(llllllllllllllIlIlllIllIlIlIIIll.getDouble());
        }
        return llllllllllllllIlIlllIllIlIlIIIlI.toString();
    }
    
    static {
        TYPE_IPATTERN = 2;
        PREFIX_PATTERN = "pattern:";
        PREFIX_IPATTERN = "ipattern:";
        PREFIX_IREGEX = "iregex:";
        TYPE_PATTERN = 1;
        TYPE_TEXT = 0;
        TYPE_REGEX = 3;
        PREFIX_REGEX = "regex:";
        TYPE_IREGEX = 4;
    }
    
    @Override
    public String toString() {
        final StringBuffer llllllllllllllIlIlllIllIlIIllIll = new StringBuffer();
        for (int llllllllllllllIlIlllIllIlIIllIlI = 0; llllllllllllllIlIlllIllIlIIllIlI < this.parents.length; ++llllllllllllllIlIlllIllIlIIllIlI) {
            final String llllllllllllllIlIlllIllIlIIllIIl = this.parents[llllllllllllllIlIlllIllIlIIllIlI];
            if (llllllllllllllIlIlllIllIlIIllIlI > 0) {
                llllllllllllllIlIlllIllIlIIllIll.append(".");
            }
            llllllllllllllIlIlllIllIlIIllIll.append(llllllllllllllIlIlllIllIlIIllIIl);
        }
        if (llllllllllllllIlIlllIllIlIIllIll.length() > 0) {
            llllllllllllllIlIlllIllIlIIllIll.append(".");
        }
        llllllllllllllIlIlllIllIlIIllIll.append(this.name);
        llllllllllllllIlIlllIllIlIIllIll.append(" = ");
        llllllllllllllIlIlllIllIlIIllIll.append(this.value);
        return llllllllllllllIlIlllIllIlIIllIll.toString();
    }
    
    private boolean matchesAnyChild(final NBTBase llllllllllllllIlIlllIllIlllIIIIl) {
        if (llllllllllllllIlIlllIllIlllIIIIl instanceof NBTTagCompound) {
            final NBTTagCompound llllllllllllllIlIlllIllIlllIIIII = (NBTTagCompound)llllllllllllllIlIlllIllIlllIIIIl;
            final Set llllllllllllllIlIlllIllIllIlllll = llllllllllllllIlIlllIllIlllIIIII.getKeySet();
            for (final String llllllllllllllIlIlllIllIllIlllIl : llllllllllllllIlIlllIllIllIlllll) {
                final NBTBase llllllllllllllIlIlllIllIllIlllII = llllllllllllllIlIlllIllIlllIIIII.getTag(llllllllllllllIlIlllIllIllIlllIl);
                if (this.matches(llllllllllllllIlIlllIllIllIlllII)) {
                    return true;
                }
            }
        }
        if (llllllllllllllIlIlllIllIlllIIIIl instanceof NBTTagList) {
            final NBTTagList llllllllllllllIlIlllIllIllIllIll = (NBTTagList)llllllllllllllIlIlllIllIlllIIIIl;
            for (int llllllllllllllIlIlllIllIllIllIlI = llllllllllllllIlIlllIllIllIllIll.tagCount(), llllllllllllllIlIlllIllIllIllIIl = 0; llllllllllllllIlIlllIllIllIllIIl < llllllllllllllIlIlllIllIllIllIlI; ++llllllllllllllIlIlllIllIllIllIIl) {
                final NBTBase llllllllllllllIlIlllIllIllIllIII = llllllllllllllIlIlllIllIllIllIll.get(llllllllllllllIlIlllIllIllIllIIl);
                if (this.matches(llllllllllllllIlIlllIllIllIllIII)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private static NBTBase getChildTag(final NBTBase llllllllllllllIlIlllIllIllIIllII, final String llllllllllllllIlIlllIllIllIIIllI) {
        if (llllllllllllllIlIlllIllIllIIllII instanceof NBTTagCompound) {
            final NBTTagCompound llllllllllllllIlIlllIllIllIIlIlI = (NBTTagCompound)llllllllllllllIlIlllIllIllIIllII;
            return llllllllllllllIlIlllIllIllIIlIlI.getTag(llllllllllllllIlIlllIllIllIIIllI);
        }
        if (llllllllllllllIlIlllIllIllIIllII instanceof NBTTagList) {
            final NBTTagList llllllllllllllIlIlllIllIllIIlIIl = (NBTTagList)llllllllllllllIlIlllIllIllIIllII;
            final int llllllllllllllIlIlllIllIllIIlIII = Config.parseInt(llllllllllllllIlIlllIllIllIIIllI, -1);
            return (llllllllllllllIlIlllIllIllIIlIII < 0) ? null : llllllllllllllIlIlllIllIllIIlIIl.get(llllllllllllllIlIlllIllIllIIlIII);
        }
        return null;
    }
    
    private boolean matchesPattern(final String llllllllllllllIlIlllIllIlIllIlll, final String llllllllllllllIlIlllIllIlIllIllI) {
        return StrUtils.equalsMask(llllllllllllllIlIlllIllIlIllIlll, llllllllllllllIlIlllIllIlIllIllI, '*', '?');
    }
    
    public NbtTagValue(final String llllllllllllllIlIlllIllIllllllII, String llllllllllllllIlIlllIllIlllllIll) {
        this.parents = null;
        this.name = null;
        this.type = 0;
        this.value = null;
        final String[] llllllllllllllIlIlllIllIlllllllI = Config.tokenize(llllllllllllllIlIlllIllIllllllII, ".");
        this.parents = Arrays.copyOfRange(llllllllllllllIlIlllIllIlllllllI, 0, llllllllllllllIlIlllIllIlllllllI.length - 1);
        this.name = llllllllllllllIlIlllIllIlllllllI[llllllllllllllIlIlllIllIlllllllI.length - 1];
        if (((String)llllllllllllllIlIlllIllIlllllIll).startsWith("pattern:")) {
            this.type = 1;
            llllllllllllllIlIlllIllIlllllIll = ((String)llllllllllllllIlIlllIllIlllllIll).substring("pattern:".length());
        }
        else if (((String)llllllllllllllIlIlllIllIlllllIll).startsWith("ipattern:")) {
            this.type = 2;
            llllllllllllllIlIlllIllIlllllIll = ((String)llllllllllllllIlIlllIllIlllllIll).substring("ipattern:".length()).toLowerCase();
        }
        else if (((String)llllllllllllllIlIlllIllIlllllIll).startsWith("regex:")) {
            this.type = 3;
            llllllllllllllIlIlllIllIlllllIll = ((String)llllllllllllllIlIlllIllIlllllIll).substring("regex:".length());
        }
        else if (((String)llllllllllllllIlIlllIllIlllllIll).startsWith("iregex:")) {
            this.type = 4;
            llllllllllllllIlIlllIllIlllllIll = ((String)llllllllllllllIlIlllIllIlllllIll).substring("iregex:".length()).toLowerCase();
        }
        else {
            this.type = 0;
        }
        llllllllllllllIlIlllIllIlllllIll = StringEscapeUtils.unescapeJava((String)llllllllllllllIlIlllIllIlllllIll);
        this.value = (String)llllllllllllllIlIlllIllIlllllIll;
    }
    
    private boolean matchesRegex(final String llllllllllllllIlIlllIllIlIllIIII, final String llllllllllllllIlIlllIllIlIlIllIl) {
        return llllllllllllllIlIlllIllIlIllIIII.matches(llllllllllllllIlIlllIllIlIlIllIl);
    }
}
