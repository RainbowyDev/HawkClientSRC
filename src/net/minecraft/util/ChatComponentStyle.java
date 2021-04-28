package net.minecraft.util;

import java.util.*;
import com.google.common.collect.*;
import com.google.common.base.*;

public abstract class ChatComponentStyle implements IChatComponent
{
    private /* synthetic */ ChatStyle style;
    protected /* synthetic */ List siblings;
    
    @Override
    public final String getUnformattedText() {
        final StringBuilder lllllllllllllllllIIlIIIlIIllIlII = new StringBuilder();
        for (final IChatComponent lllllllllllllllllIIlIIIlIIllIIlI : this) {
            lllllllllllllllllIIlIIIlIIllIlII.append(lllllllllllllllllIIlIIIlIIllIIlI.getUnformattedTextForChat());
        }
        return String.valueOf(lllllllllllllllllIIlIIIlIIllIlII);
    }
    
    @Override
    public IChatComponent setChatStyle(final ChatStyle lllllllllllllllllIIlIIIlIlIIlIII) {
        this.style = lllllllllllllllllIIlIIIlIlIIlIII;
        for (final IChatComponent lllllllllllllllllIIlIIIlIlIIlIlI : this.siblings) {
            lllllllllllllllllIIlIIIlIlIIlIlI.getChatStyle().setParentStyle(this.getChatStyle());
        }
        return this;
    }
    
    @Override
    public int hashCode() {
        return 31 * this.style.hashCode() + this.siblings.hashCode();
    }
    
    @Override
    public Iterator iterator() {
        return Iterators.concat((Iterator)Iterators.forArray((Object[])new ChatComponentStyle[] { this }), createDeepCopyIterator(this.siblings));
    }
    
    public ChatComponentStyle() {
        this.siblings = Lists.newArrayList();
    }
    
    @Override
    public final String getFormattedText() {
        final StringBuilder lllllllllllllllllIIlIIIlIIlIlIII = new StringBuilder();
        for (final IChatComponent lllllllllllllllllIIlIIIlIIlIIllI : this) {
            lllllllllllllllllIIlIIIlIIlIlIII.append(lllllllllllllllllIIlIIIlIIlIIllI.getChatStyle().getFormattingCode());
            lllllllllllllllllIIlIIIlIIlIlIII.append(lllllllllllllllllIIlIIIlIIlIIllI.getUnformattedTextForChat());
            lllllllllllllllllIIlIIIlIIlIlIII.append(EnumChatFormatting.RESET);
        }
        return String.valueOf(lllllllllllllllllIIlIIIlIIlIlIII);
    }
    
    @Override
    public ChatStyle getChatStyle() {
        if (this.style == null) {
            this.style = new ChatStyle();
            for (final IChatComponent lllllllllllllllllIIlIIIlIlIIIIII : this.siblings) {
                lllllllllllllllllIIlIIIlIlIIIIII.getChatStyle().setParentStyle(this.style);
            }
        }
        return this.style;
    }
    
    @Override
    public IChatComponent appendSibling(final IChatComponent lllllllllllllllllIIlIIIlIlIllIll) {
        lllllllllllllllllIIlIIIlIlIllIll.getChatStyle().setParentStyle(this.getChatStyle());
        this.siblings.add(lllllllllllllllllIIlIIIlIlIllIll);
        return this;
    }
    
    public static Iterator createDeepCopyIterator(final Iterable lllllllllllllllllIIlIIIlIIIlllll) {
        Iterator lllllllllllllllllIIlIIIlIIIllllI = Iterators.concat(Iterators.transform((Iterator)lllllllllllllllllIIlIIIlIIIlllll.iterator(), (Function)new Function() {
            public Object apply(final Object llllllllllllllIIIIllIlIIlIIlIlII) {
                return this.apply((IChatComponent)llllllllllllllIIIIllIlIIlIIlIlII);
            }
            
            public Iterator apply(final IChatComponent llllllllllllllIIIIllIlIIlIIlllIl) {
                return llllllllllllllIIIIllIlIIlIIlllIl.iterator();
            }
            
            static {
                __OBFID = "CL_00001258";
            }
        }));
        lllllllllllllllllIIlIIIlIIIllllI = Iterators.transform(lllllllllllllllllIIlIIIlIIIllllI, (Function)new Function() {
            static {
                __OBFID = "CL_00001259";
            }
            
            public Object apply(final Object lllllllllllllllIIIIlIlIlIIllllII) {
                return this.apply((IChatComponent)lllllllllllllllIIIIlIlIlIIllllII);
            }
            
            public IChatComponent apply(final IChatComponent lllllllllllllllIIIIlIlIlIlIIIIll) {
                final IChatComponent lllllllllllllllIIIIlIlIlIlIIIIlI = lllllllllllllllIIIIlIlIlIlIIIIll.createCopy();
                lllllllllllllllIIIIlIlIlIlIIIIlI.setChatStyle(lllllllllllllllIIIIlIlIlIlIIIIlI.getChatStyle().createDeepCopy());
                return lllllllllllllllIIIIlIlIlIlIIIIlI;
            }
        });
        return lllllllllllllllllIIlIIIlIIIllllI;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllllllIIlIIIlIIIlIlll) {
        if (this == lllllllllllllllllIIlIIIlIIIlIlll) {
            return true;
        }
        if (!(lllllllllllllllllIIlIIIlIIIlIlll instanceof ChatComponentStyle)) {
            return false;
        }
        final ChatComponentStyle lllllllllllllllllIIlIIIlIIIlIllI = (ChatComponentStyle)lllllllllllllllllIIlIIIlIIIlIlll;
        return this.siblings.equals(lllllllllllllllllIIlIIIlIIIlIllI.siblings) && this.getChatStyle().equals(lllllllllllllllllIIlIIIlIIIlIllI.getChatStyle());
    }
    
    static {
        __OBFID = "CL_00001257";
    }
    
    @Override
    public IChatComponent appendText(final String lllllllllllllllllIIlIIIlIlIlIlII) {
        return this.appendSibling(new ChatComponentText(lllllllllllllllllIIlIIIlIlIlIlII));
    }
    
    @Override
    public List getSiblings() {
        return this.siblings;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("BaseComponent{style=").append(this.style).append(", siblings=").append(this.siblings).append('}'));
    }
}
