package net.minecraft.util;

import java.util.*;

public class ChatComponentSelector extends ChatComponentStyle
{
    private final /* synthetic */ String field_179993_b;
    
    @Override
    public boolean equals(final Object llllllllllllllIlIIIIlIlIlIIlIIlI) {
        if (this == llllllllllllllIlIIIIlIlIlIIlIIlI) {
            return true;
        }
        if (!(llllllllllllllIlIIIIlIlIlIIlIIlI instanceof ChatComponentSelector)) {
            return false;
        }
        final ChatComponentSelector llllllllllllllIlIIIIlIlIlIIlIlII = (ChatComponentSelector)llllllllllllllIlIIIIlIlIlIIlIIlI;
        return this.field_179993_b.equals(llllllllllllllIlIIIIlIlIlIIlIlII.field_179993_b) && super.equals(llllllllllllllIlIIIIlIlIlIIlIIlI);
    }
    
    public ChatComponentSelector(final String llllllllllllllIlIIIIlIlIlIlIllII) {
        this.field_179993_b = llllllllllllllIlIIIIlIlIlIlIllII;
    }
    
    public ChatComponentSelector func_179991_h() {
        final ChatComponentSelector llllllllllllllIlIIIIlIlIlIlIIIII = new ChatComponentSelector(this.field_179993_b);
        llllllllllllllIlIIIIlIlIlIlIIIII.setChatStyle(this.getChatStyle().createShallowCopy());
        for (final IChatComponent llllllllllllllIlIIIIlIlIlIIllllI : this.getSiblings()) {
            llllllllllllllIlIIIIlIlIlIlIIIII.appendSibling(llllllllllllllIlIIIIlIlIlIIllllI.createCopy());
        }
        return llllllllllllllIlIIIIlIlIlIlIIIII;
    }
    
    @Override
    public String getUnformattedTextForChat() {
        return this.field_179993_b;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("SelectorComponent{pattern='").append(this.field_179993_b).append('\'').append(", siblings=").append(this.siblings).append(", style=").append(this.getChatStyle()).append('}'));
    }
    
    @Override
    public IChatComponent createCopy() {
        return this.func_179991_h();
    }
    
    static {
        __OBFID = "CL_00002308";
    }
    
    public String func_179992_g() {
        return this.field_179993_b;
    }
}
