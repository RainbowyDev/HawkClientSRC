package net.minecraft.util;

import java.util.*;

public class ChatComponentText extends ChatComponentStyle
{
    private final /* synthetic */ String text;
    
    public String getChatComponentText_TextValue() {
        return this.text;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("TextComponent{text='").append(this.text).append('\'').append(", siblings=").append(this.siblings).append(", style=").append(this.getChatStyle()).append('}'));
    }
    
    @Override
    public ChatComponentText createCopy() {
        final ChatComponentText llllllllllllllIIlIlIIIIIIlllIlIl = new ChatComponentText(this.text);
        llllllllllllllIIlIlIIIIIIlllIlIl.setChatStyle(this.getChatStyle().createShallowCopy());
        for (final IChatComponent llllllllllllllIIlIlIIIIIIlllIIlI : this.getSiblings()) {
            llllllllllllllIIlIlIIIIIIlllIlIl.appendSibling(llllllllllllllIIlIlIIIIIIlllIIlI.createCopy());
        }
        return llllllllllllllIIlIlIIIIIIlllIlIl;
    }
    
    @Override
    public boolean equals(final Object llllllllllllllIIlIlIIIIIIllIlIIl) {
        if (this == llllllllllllllIIlIlIIIIIIllIlIIl) {
            return true;
        }
        if (!(llllllllllllllIIlIlIIIIIIllIlIIl instanceof ChatComponentText)) {
            return false;
        }
        final ChatComponentText llllllllllllllIIlIlIIIIIIllIlIII = (ChatComponentText)llllllllllllllIIlIlIIIIIIllIlIIl;
        return this.text.equals(llllllllllllllIIlIlIIIIIIllIlIII.getChatComponentText_TextValue()) && super.equals(llllllllllllllIIlIlIIIIIIllIlIIl);
    }
    
    static {
        __OBFID = "CL_00001269";
    }
    
    public ChatComponentText(final String llllllllllllllIIlIlIIIIIlIIlIlIl) {
        this.text = llllllllllllllIIlIlIIIIIlIIlIlIl;
    }
    
    @Override
    public String getUnformattedTextForChat() {
        return this.text;
    }
}
