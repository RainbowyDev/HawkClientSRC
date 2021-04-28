package net.minecraft.util;

import java.util.regex.*;
import java.util.*;
import com.google.common.collect.*;

public class ChatComponentTranslation extends ChatComponentStyle
{
    /* synthetic */ List children;
    private /* synthetic */ long lastTranslationUpdateTimeInMilliseconds;
    private final /* synthetic */ String key;
    private final /* synthetic */ Object syncLock;
    public static final /* synthetic */ Pattern stringVariablePattern;
    private final /* synthetic */ Object[] formatArgs;
    
    public ChatComponentTranslation(final String lllllllllllllllllIIIIllIIllIllll, final Object... lllllllllllllllllIIIIllIIllIIlll) {
        this.syncLock = new Object();
        this.lastTranslationUpdateTimeInMilliseconds = -1L;
        this.children = Lists.newArrayList();
        this.key = lllllllllllllllllIIIIllIIllIllll;
        this.formatArgs = lllllllllllllllllIIIIllIIllIIlll;
        final Object[] lllllllllllllllllIIIIllIIllIllIl = lllllllllllllllllIIIIllIIllIIlll;
        for (int lllllllllllllllllIIIIllIIllIllII = lllllllllllllllllIIIIllIIllIIlll.length, lllllllllllllllllIIIIllIIllIlIll = 0; lllllllllllllllllIIIIllIIllIlIll < lllllllllllllllllIIIIllIIllIllII; ++lllllllllllllllllIIIIllIIllIlIll) {
            final Object lllllllllllllllllIIIIllIIllIlIlI = lllllllllllllllllIIIIllIIllIllIl[lllllllllllllllllIIIIllIIllIlIll];
            if (lllllllllllllllllIIIIllIIllIlIlI instanceof IChatComponent) {
                ((IChatComponent)lllllllllllllllllIIIIllIIllIlIlI).getChatStyle().setParentStyle(this.getChatStyle());
            }
        }
    }
    
    @Override
    public IChatComponent setChatStyle(final ChatStyle lllllllllllllllllIIIIllIIIIlIIIl) {
        super.setChatStyle(lllllllllllllllllIIIIllIIIIlIIIl);
        for (final Object lllllllllllllllllIIIIllIIIIlIlIl : this.formatArgs) {
            if (lllllllllllllllllIIIIllIIIIlIlIl instanceof IChatComponent) {
                ((IChatComponent)lllllllllllllllllIIIIllIIIIlIlIl).getChatStyle().setParentStyle(this.getChatStyle());
            }
        }
        if (this.lastTranslationUpdateTimeInMilliseconds > -1L) {
            for (final IChatComponent lllllllllllllllllIIIIllIIIIlIIll : this.children) {
                lllllllllllllllllIIIIllIIIIlIIll.getChatStyle().setParentStyle(lllllllllllllllllIIIIllIIIIlIIIl);
            }
        }
        return this;
    }
    
    @Override
    public String getUnformattedTextForChat() {
        this.ensureInitialized();
        final StringBuilder lllllllllllllllllIIIIllIIIIIIlII = new StringBuilder();
        for (final IChatComponent lllllllllllllllllIIIIllIIIIIIIlI : this.children) {
            lllllllllllllllllIIIIllIIIIIIlII.append(lllllllllllllllllIIIIllIIIIIIIlI.getUnformattedTextForChat());
        }
        return String.valueOf(lllllllllllllllllIIIIllIIIIIIlII);
    }
    
    public Object[] getFormatArgs() {
        return this.formatArgs;
    }
    
    @Override
    public ChatComponentTranslation createCopy() {
        final Object[] lllllllllllllllllIIIIlIlllllIlll = new Object[this.formatArgs.length];
        for (int lllllllllllllllllIIIIlIlllllIllI = 0; lllllllllllllllllIIIIlIlllllIllI < this.formatArgs.length; ++lllllllllllllllllIIIIlIlllllIllI) {
            if (this.formatArgs[lllllllllllllllllIIIIlIlllllIllI] instanceof IChatComponent) {
                lllllllllllllllllIIIIlIlllllIlll[lllllllllllllllllIIIIlIlllllIllI] = ((IChatComponent)this.formatArgs[lllllllllllllllllIIIIlIlllllIllI]).createCopy();
            }
            else {
                lllllllllllllllllIIIIlIlllllIlll[lllllllllllllllllIIIIlIlllllIllI] = this.formatArgs[lllllllllllllllllIIIIlIlllllIllI];
            }
        }
        final ChatComponentTranslation lllllllllllllllllIIIIlIlllllIlIl = new ChatComponentTranslation(this.key, lllllllllllllllllIIIIlIlllllIlll);
        lllllllllllllllllIIIIlIlllllIlIl.setChatStyle(this.getChatStyle().createShallowCopy());
        for (final IChatComponent lllllllllllllllllIIIIlIlllllIIll : this.getSiblings()) {
            lllllllllllllllllIIIIlIlllllIlIl.appendSibling(lllllllllllllllllIIIIlIlllllIIll.createCopy());
        }
        return lllllllllllllllllIIIIlIlllllIlIl;
    }
    
    private IChatComponent getFormatArgumentAsComponent(final int lllllllllllllllllIIIIllIIIlIlIII) {
        if (lllllllllllllllllIIIIllIIIlIlIII >= this.formatArgs.length) {
            throw new ChatComponentTranslationFormatException(this, lllllllllllllllllIIIIllIIIlIlIII);
        }
        final Object lllllllllllllllllIIIIllIIIlIIlll = this.formatArgs[lllllllllllllllllIIIIllIIIlIlIII];
        Object lllllllllllllllllIIIIllIIIlIIlIl = null;
        if (lllllllllllllllllIIIIllIIIlIIlll instanceof IChatComponent) {
            final Object lllllllllllllllllIIIIllIIIlIIllI = lllllllllllllllllIIIIllIIIlIIlll;
        }
        else {
            lllllllllllllllllIIIIllIIIlIIlIl = new ChatComponentText((lllllllllllllllllIIIIllIIIlIIlll == null) ? "null" : lllllllllllllllllIIIIllIIIlIIlll.toString());
            ((IChatComponent)lllllllllllllllllIIIIllIIIlIIlIl).getChatStyle().setParentStyle(this.getChatStyle());
        }
        return (IChatComponent)lllllllllllllllllIIIIllIIIlIIlIl;
    }
    
    protected void initializeFromFormat(final String lllllllllllllllllIIIIllIIIlllIII) {
        final boolean lllllllllllllllllIIIIllIIlIIIlll = false;
        final Matcher lllllllllllllllllIIIIllIIlIIIllI = ChatComponentTranslation.stringVariablePattern.matcher(lllllllllllllllllIIIIllIIIlllIII);
        int lllllllllllllllllIIIIllIIlIIIlIl = 0;
        int lllllllllllllllllIIIIllIIlIIIlII = 0;
        try {
            while (lllllllllllllllllIIIIllIIlIIIllI.find(lllllllllllllllllIIIIllIIlIIIlII)) {
                final int lllllllllllllllllIIIIllIIlIIIIlI = lllllllllllllllllIIIIllIIlIIIllI.start();
                final int lllllllllllllllllIIIIllIIlIIIIll = lllllllllllllllllIIIIllIIlIIIllI.end();
                if (lllllllllllllllllIIIIllIIlIIIIlI > lllllllllllllllllIIIIllIIlIIIlII) {
                    final ChatComponentText lllllllllllllllllIIIIllIIlIIIIIl = new ChatComponentText(String.format(lllllllllllllllllIIIIllIIIlllIII.substring(lllllllllllllllllIIIIllIIlIIIlII, lllllllllllllllllIIIIllIIlIIIIlI), new Object[0]));
                    lllllllllllllllllIIIIllIIlIIIIIl.getChatStyle().setParentStyle(this.getChatStyle());
                    this.children.add(lllllllllllllllllIIIIllIIlIIIIIl);
                }
                final String lllllllllllllllllIIIIllIIlIIIIII = lllllllllllllllllIIIIllIIlIIIllI.group(2);
                final String lllllllllllllllllIIIIllIIIllllll = lllllllllllllllllIIIIllIIIlllIII.substring(lllllllllllllllllIIIIllIIlIIIIlI, lllllllllllllllllIIIIllIIlIIIIll);
                if ("%".equals(lllllllllllllllllIIIIllIIlIIIIII) && "%%".equals(lllllllllllllllllIIIIllIIIllllll)) {
                    final ChatComponentText lllllllllllllllllIIIIllIIIlllllI = new ChatComponentText("%");
                    lllllllllllllllllIIIIllIIIlllllI.getChatStyle().setParentStyle(this.getChatStyle());
                    this.children.add(lllllllllllllllllIIIIllIIIlllllI);
                }
                else {
                    if (!"s".equals(lllllllllllllllllIIIIllIIlIIIIII)) {
                        throw new ChatComponentTranslationFormatException(this, String.valueOf(new StringBuilder("Unsupported format: '").append(lllllllllllllllllIIIIllIIIllllll).append("'")));
                    }
                    final String lllllllllllllllllIIIIllIIIllllIl = lllllllllllllllllIIIIllIIlIIIllI.group(1);
                    final int lllllllllllllllllIIIIllIIIllllII = (lllllllllllllllllIIIIllIIIllllIl != null) ? (Integer.parseInt(lllllllllllllllllIIIIllIIIllllIl) - 1) : lllllllllllllllllIIIIllIIlIIIlIl++;
                    if (lllllllllllllllllIIIIllIIIllllII < this.formatArgs.length) {
                        this.children.add(this.getFormatArgumentAsComponent(lllllllllllllllllIIIIllIIIllllII));
                    }
                }
                lllllllllllllllllIIIIllIIlIIIlII = lllllllllllllllllIIIIllIIlIIIIll;
            }
            if (lllllllllllllllllIIIIllIIlIIIlII < lllllllllllllllllIIIIllIIIlllIII.length()) {
                final ChatComponentText lllllllllllllllllIIIIllIIIlllIll = new ChatComponentText(String.format(lllllllllllllllllIIIIllIIIlllIII.substring(lllllllllllllllllIIIIllIIlIIIlII), new Object[0]));
                lllllllllllllllllIIIIllIIIlllIll.getChatStyle().setParentStyle(this.getChatStyle());
                this.children.add(lllllllllllllllllIIIIllIIIlllIll);
            }
        }
        catch (IllegalFormatException lllllllllllllllllIIIIllIIIlllIlI) {
            throw new ChatComponentTranslationFormatException(this, lllllllllllllllllIIIIllIIIlllIlI);
        }
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("TranslatableComponent{key='").append(this.key).append('\'').append(", args=").append(Arrays.toString(this.formatArgs)).append(", siblings=").append(this.siblings).append(", style=").append(this.getChatStyle()).append('}'));
    }
    
    public String getKey() {
        return this.key;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllllllIIIIlIllllIlIIl) {
        if (this == lllllllllllllllllIIIIlIllllIlIIl) {
            return true;
        }
        if (!(lllllllllllllllllIIIIlIllllIlIIl instanceof ChatComponentTranslation)) {
            return false;
        }
        final ChatComponentTranslation lllllllllllllllllIIIIlIllllIlIII = (ChatComponentTranslation)lllllllllllllllllIIIIlIllllIlIIl;
        return Arrays.equals(this.formatArgs, lllllllllllllllllIIIIlIllllIlIII.formatArgs) && this.key.equals(lllllllllllllllllIIIIlIllllIlIII.key) && super.equals(lllllllllllllllllIIIIlIllllIlIIl);
    }
    
    static {
        __OBFID = "CL_00001270";
        stringVariablePattern = Pattern.compile("%(?:(\\d+)\\$)?([A-Za-z%]|$)");
    }
    
    synchronized void ensureInitialized() {
        final Object lllllllllllllllllIIIIllIIlIlllIl = this.syncLock;
        synchronized (this.syncLock) {
            final long lllllllllllllllllIIIIllIIlIlllII = StatCollector.getLastTranslationUpdateTimeInMilliseconds();
            if (lllllllllllllllllIIIIllIIlIlllII == this.lastTranslationUpdateTimeInMilliseconds) {
                // monitorexit(this.syncLock)
                return;
            }
            this.lastTranslationUpdateTimeInMilliseconds = lllllllllllllllllIIIIllIIlIlllII;
            this.children.clear();
        }
        // monitorexit(this.syncLock)
        try {
            this.initializeFromFormat(StatCollector.translateToLocal(this.key));
        }
        catch (ChatComponentTranslationFormatException lllllllllllllllllIIIIllIIlIllIll) {
            this.children.clear();
            try {
                this.initializeFromFormat(StatCollector.translateToFallback(this.key));
            }
            catch (ChatComponentTranslationFormatException lllllllllllllllllIIIIllIIlIllIlI) {
                throw lllllllllllllllllIIIIllIIlIllIll;
            }
        }
    }
    
    @Override
    public int hashCode() {
        int lllllllllllllllllIIIIlIllllIIIIl = super.hashCode();
        lllllllllllllllllIIIIlIllllIIIIl = 31 * lllllllllllllllllIIIIlIllllIIIIl + this.key.hashCode();
        lllllllllllllllllIIIIlIllllIIIIl = 31 * lllllllllllllllllIIIIlIllllIIIIl + Arrays.hashCode(this.formatArgs);
        return lllllllllllllllllIIIIlIllllIIIIl;
    }
    
    @Override
    public Iterator iterator() {
        this.ensureInitialized();
        return Iterators.concat(ChatComponentStyle.createDeepCopyIterator(this.children), ChatComponentStyle.createDeepCopyIterator(this.siblings));
    }
}
