package net.minecraft.util;

import net.minecraft.event.*;
import java.lang.reflect.*;
import com.google.gson.*;

public class ChatStyle
{
    private /* synthetic */ Boolean italic;
    private /* synthetic */ HoverEvent chatHoverEvent;
    private /* synthetic */ Boolean strikethrough;
    private /* synthetic */ Boolean bold;
    private /* synthetic */ ClickEvent chatClickEvent;
    private /* synthetic */ ChatStyle parentStyle;
    private /* synthetic */ Boolean obfuscated;
    private static final /* synthetic */ ChatStyle rootStyle;
    private /* synthetic */ EnumChatFormatting color;
    private /* synthetic */ String insertion;
    private /* synthetic */ Boolean underlined;
    
    static /* synthetic */ void access$7(final ChatStyle lllllllllllllllIIlIIlllIlIIIlllI, final ClickEvent lllllllllllllllIIlIIlllIlIIIllIl) {
        lllllllllllllllIIlIIlllIlIIIlllI.chatClickEvent = lllllllllllllllIIlIIlllIlIIIllIl;
    }
    
    static /* synthetic */ void access$1(final ChatStyle lllllllllllllllIIlIIlllIlIlIIllI, final Boolean lllllllllllllllIIlIIlllIlIlIIlIl) {
        lllllllllllllllIIlIIlllIlIlIIllI.italic = lllllllllllllllIIlIIlllIlIlIIlIl;
    }
    
    public boolean getObfuscated() {
        return (this.obfuscated == null) ? this.getParent().getObfuscated() : this.obfuscated;
    }
    
    public ChatStyle createShallowCopy() {
        final ChatStyle lllllllllllllllIIlIIlllIlIllIlIl = new ChatStyle();
        lllllllllllllllIIlIIlllIlIllIlIl.bold = this.bold;
        lllllllllllllllIIlIIlllIlIllIlIl.italic = this.italic;
        lllllllllllllllIIlIIlllIlIllIlIl.strikethrough = this.strikethrough;
        lllllllllllllllIIlIIlllIlIllIlIl.underlined = this.underlined;
        lllllllllllllllIIlIIlllIlIllIlIl.obfuscated = this.obfuscated;
        lllllllllllllllIIlIIlllIlIllIlIl.color = this.color;
        lllllllllllllllIIlIIlllIlIllIlIl.chatClickEvent = this.chatClickEvent;
        lllllllllllllllIIlIIlllIlIllIlIl.chatHoverEvent = this.chatHoverEvent;
        lllllllllllllllIIlIIlllIlIllIlIl.parentStyle = this.parentStyle;
        lllllllllllllllIIlIIlllIlIllIlIl.insertion = this.insertion;
        return lllllllllllllllIIlIIlllIlIllIlIl;
    }
    
    static {
        __OBFID = "CL_00001266";
        rootStyle = new ChatStyle() {
            @Override
            public String toString() {
                return "Style.ROOT";
            }
            
            @Override
            public boolean getItalic() {
                return false;
            }
            
            @Override
            public HoverEvent getChatHoverEvent() {
                return null;
            }
            
            static {
                __OBFID = "CL_00001267";
            }
            
            @Override
            public boolean getUnderlined() {
                return false;
            }
            
            @Override
            public ChatStyle setParentStyle(final ChatStyle llllllllllllllIlIlIIIlllIlllIllI) {
                throw new UnsupportedOperationException();
            }
            
            @Override
            public String getFormattingCode() {
                return "";
            }
            
            @Override
            public ChatStyle createDeepCopy() {
                return this;
            }
            
            @Override
            public ChatStyle setStrikethrough(final Boolean llllllllllllllIlIlIIIllllIIIIIII) {
                throw new UnsupportedOperationException();
            }
            
            @Override
            public boolean getStrikethrough() {
                return false;
            }
            
            @Override
            public boolean getObfuscated() {
                return false;
            }
            
            @Override
            public ClickEvent getChatClickEvent() {
                return null;
            }
            
            @Override
            public ChatStyle setItalic(final Boolean llllllllllllllIlIlIIIllllIIIIIlI) {
                throw new UnsupportedOperationException();
            }
            
            @Override
            public boolean getBold() {
                return false;
            }
            
            @Override
            public ChatStyle setChatClickEvent(final ClickEvent llllllllllllllIlIlIIIlllIllllIlI) {
                throw new UnsupportedOperationException();
            }
            
            @Override
            public ChatStyle setChatHoverEvent(final HoverEvent llllllllllllllIlIlIIIlllIllllIII) {
                throw new UnsupportedOperationException();
            }
            
            @Override
            public ChatStyle setColor(final EnumChatFormatting llllllllllllllIlIlIIIllllIIIIllI) {
                throw new UnsupportedOperationException();
            }
            
            @Override
            public EnumChatFormatting getColor() {
                return null;
            }
            
            @Override
            public String getInsertion() {
                return null;
            }
            
            @Override
            public ChatStyle setObfuscated(final Boolean llllllllllllllIlIlIIIlllIlllllII) {
                throw new UnsupportedOperationException();
            }
            
            @Override
            public ChatStyle createShallowCopy() {
                return this;
            }
            
            @Override
            public ChatStyle setUnderlined(final Boolean llllllllllllllIlIlIIIlllIllllllI) {
                throw new UnsupportedOperationException();
            }
            
            @Override
            public ChatStyle setBold(final Boolean llllllllllllllIlIlIIIllllIIIIlII) {
                throw new UnsupportedOperationException();
            }
        };
    }
    
    public ChatStyle createDeepCopy() {
        final ChatStyle lllllllllllllllIIlIIlllIlIlIllll = new ChatStyle();
        lllllllllllllllIIlIIlllIlIlIllll.setBold(this.getBold());
        lllllllllllllllIIlIIlllIlIlIllll.setItalic(this.getItalic());
        lllllllllllllllIIlIIlllIlIlIllll.setStrikethrough(this.getStrikethrough());
        lllllllllllllllIIlIIlllIlIlIllll.setUnderlined(this.getUnderlined());
        lllllllllllllllIIlIIlllIlIlIllll.setObfuscated(this.getObfuscated());
        lllllllllllllllIIlIIlllIlIlIllll.setColor(this.getColor());
        lllllllllllllllIIlIIlllIlIlIllll.setChatClickEvent(this.getChatClickEvent());
        lllllllllllllllIIlIIlllIlIlIllll.setChatHoverEvent(this.getChatHoverEvent());
        lllllllllllllllIIlIIlllIlIlIllll.setInsertion(this.getInsertion());
        return lllllllllllllllIIlIIlllIlIlIllll;
    }
    
    public HoverEvent getChatHoverEvent() {
        return (this.chatHoverEvent == null) ? this.getParent().getChatHoverEvent() : this.chatHoverEvent;
    }
    
    public boolean getStrikethrough() {
        return (this.strikethrough == null) ? this.getParent().getStrikethrough() : this.strikethrough;
    }
    
    public EnumChatFormatting getColor() {
        return (this.color == null) ? this.getParent().getColor() : this.color;
    }
    
    public boolean isEmpty() {
        return this.bold == null && this.italic == null && this.strikethrough == null && this.underlined == null && this.obfuscated == null && this.color == null && this.chatClickEvent == null && this.chatHoverEvent == null;
    }
    
    @Override
    public int hashCode() {
        int lllllllllllllllIIlIIlllIlIlllIll = this.color.hashCode();
        lllllllllllllllIIlIIlllIlIlllIll = 31 * lllllllllllllllIIlIIlllIlIlllIll + this.bold.hashCode();
        lllllllllllllllIIlIIlllIlIlllIll = 31 * lllllllllllllllIIlIIlllIlIlllIll + this.italic.hashCode();
        lllllllllllllllIIlIIlllIlIlllIll = 31 * lllllllllllllllIIlIIlllIlIlllIll + this.underlined.hashCode();
        lllllllllllllllIIlIIlllIlIlllIll = 31 * lllllllllllllllIIlIIlllIlIlllIll + this.strikethrough.hashCode();
        lllllllllllllllIIlIIlllIlIlllIll = 31 * lllllllllllllllIIlIIlllIlIlllIll + this.obfuscated.hashCode();
        lllllllllllllllIIlIIlllIlIlllIll = 31 * lllllllllllllllIIlIIlllIlIlllIll + this.chatClickEvent.hashCode();
        lllllllllllllllIIlIIlllIlIlllIll = 31 * lllllllllllllllIIlIIlllIlIlllIll + this.chatHoverEvent.hashCode();
        lllllllllllllllIIlIIlllIlIlllIll = 31 * lllllllllllllllIIlIIlllIlIlllIll + this.insertion.hashCode();
        return lllllllllllllllIIlIIlllIlIlllIll;
    }
    
    public boolean getItalic() {
        return (this.italic == null) ? this.getParent().getItalic() : this.italic;
    }
    
    public ChatStyle setParentStyle(final ChatStyle lllllllllllllllIIlIIlllIllIllIII) {
        this.parentStyle = lllllllllllllllIIlIIlllIllIllIII;
        return this;
    }
    
    public ChatStyle setItalic(final Boolean lllllllllllllllIIlIIllllIIIIIIlI) {
        this.italic = lllllllllllllllIIlIIllllIIIIIIlI;
        return this;
    }
    
    public boolean getUnderlined() {
        return (this.underlined == null) ? this.getParent().getUnderlined() : this.underlined;
    }
    
    static /* synthetic */ void access$4(final ChatStyle lllllllllllllllIIlIIlllIlIIllIlI, final Boolean lllllllllllllllIIlIIlllIlIIllIIl) {
        lllllllllllllllIIlIIlllIlIIllIlI.obfuscated = lllllllllllllllIIlIIlllIlIIllIIl;
    }
    
    public ChatStyle setObfuscated(final Boolean lllllllllllllllIIlIIlllIllllIIII) {
        this.obfuscated = lllllllllllllllIIlIIlllIllllIIII;
        return this;
    }
    
    public String getInsertion() {
        return (this.insertion == null) ? this.getParent().getInsertion() : this.insertion;
    }
    
    static /* synthetic */ void access$3(final ChatStyle lllllllllllllllIIlIIlllIlIIllllI, final Boolean lllllllllllllllIIlIIlllIlIIlllIl) {
        lllllllllllllllIIlIIlllIlIIllllI.strikethrough = lllllllllllllllIIlIIlllIlIIlllIl;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllllIIlIIlllIllIIIllI) {
        if (this == lllllllllllllllIIlIIlllIllIIIllI) {
            return true;
        }
        if (!(lllllllllllllllIIlIIlllIllIIIllI instanceof ChatStyle)) {
            return false;
        }
        final ChatStyle lllllllllllllllIIlIIlllIllIIIlIl = (ChatStyle)lllllllllllllllIIlIIlllIllIIIllI;
        if (this.getBold() == lllllllllllllllIIlIIlllIllIIIlIl.getBold() && this.getColor() == lllllllllllllllIIlIIlllIllIIIlIl.getColor() && this.getItalic() == lllllllllllllllIIlIIlllIllIIIlIl.getItalic() && this.getObfuscated() == lllllllllllllllIIlIIlllIllIIIlIl.getObfuscated() && this.getStrikethrough() == lllllllllllllllIIlIIlllIllIIIlIl.getStrikethrough() && this.getUnderlined() == lllllllllllllllIIlIIlllIllIIIlIl.getUnderlined()) {
            if (this.getChatClickEvent() != null) {
                if (!this.getChatClickEvent().equals(lllllllllllllllIIlIIlllIllIIIlIl.getChatClickEvent())) {
                    return false;
                }
            }
            else if (lllllllllllllllIIlIIlllIllIIIlIl.getChatClickEvent() != null) {
                return false;
            }
            if (this.getChatHoverEvent() != null) {
                if (!this.getChatHoverEvent().equals(lllllllllllllllIIlIIlllIllIIIlIl.getChatHoverEvent())) {
                    return false;
                }
            }
            else if (lllllllllllllllIIlIIlllIllIIIlIl.getChatHoverEvent() != null) {
                return false;
            }
            if (this.getInsertion() != null) {
                if (!this.getInsertion().equals(lllllllllllllllIIlIIlllIllIIIlIl.getInsertion())) {
                    return false;
                }
            }
            else if (lllllllllllllllIIlIIlllIllIIIlIl.getInsertion() != null) {
                return false;
            }
            final boolean lllllllllllllllIIlIIlllIllIIIlII = true;
            return lllllllllllllllIIlIIlllIllIIIlII;
        }
        final boolean lllllllllllllllIIlIIlllIllIIIIll = false;
        return lllllllllllllllIIlIIlllIllIIIIll;
    }
    
    public ChatStyle setBold(final Boolean lllllllllllllllIIlIIllllIIIIlIII) {
        this.bold = lllllllllllllllIIlIIllllIIIIlIII;
        return this;
    }
    
    static /* synthetic */ void access$2(final ChatStyle lllllllllllllllIIlIIlllIlIlIIIlI, final Boolean lllllllllllllllIIlIIlllIlIlIIIIl) {
        lllllllllllllllIIlIIlllIlIlIIIlI.underlined = lllllllllllllllIIlIIlllIlIlIIIIl;
    }
    
    public ChatStyle setChatClickEvent(final ClickEvent lllllllllllllllIIlIIlllIlllIlIlI) {
        this.chatClickEvent = lllllllllllllllIIlIIlllIlllIlIlI;
        return this;
    }
    
    static /* synthetic */ void access$8(final ChatStyle lllllllllllllllIIlIIlllIlIIIlIlI, final HoverEvent lllllllllllllllIIlIIlllIlIIIlIIl) {
        lllllllllllllllIIlIIlllIlIIIlIlI.chatHoverEvent = lllllllllllllllIIlIIlllIlIIIlIIl;
    }
    
    public ChatStyle setInsertion(final String lllllllllllllllIIlIIlllIllIllllI) {
        this.insertion = lllllllllllllllIIlIIlllIllIllllI;
        return this;
    }
    
    public ChatStyle setColor(final EnumChatFormatting lllllllllllllllIIlIIllllIIIlIIII) {
        this.color = lllllllllllllllIIlIIllllIIIlIIII;
        return this;
    }
    
    public ChatStyle setUnderlined(final Boolean lllllllllllllllIIlIIlllIllllIllI) {
        this.underlined = lllllllllllllllIIlIIlllIllllIllI;
        return this;
    }
    
    static /* synthetic */ void access$6(final ChatStyle lllllllllllllllIIlIIlllIlIIlIIlI, final String lllllllllllllllIIlIIlllIlIIlIIIl) {
        lllllllllllllllIIlIIlllIlIIlIIlI.insertion = lllllllllllllllIIlIIlllIlIIlIIIl;
    }
    
    public ClickEvent getChatClickEvent() {
        return (this.chatClickEvent == null) ? this.getParent().getChatClickEvent() : this.chatClickEvent;
    }
    
    static /* synthetic */ void access$5(final ChatStyle lllllllllllllllIIlIIlllIlIIlIllI, final EnumChatFormatting lllllllllllllllIIlIIlllIlIIlIlIl) {
        lllllllllllllllIIlIIlllIlIIlIllI.color = lllllllllllllllIIlIIlllIlIIlIlIl;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("Style{hasParent=").append(this.parentStyle != null).append(", color=").append(this.color).append(", bold=").append(this.bold).append(", italic=").append(this.italic).append(", underlined=").append(this.underlined).append(", obfuscated=").append(this.obfuscated).append(", clickEvent=").append(this.getChatClickEvent()).append(", hoverEvent=").append(this.getChatHoverEvent()).append(", insertion=").append(this.getInsertion()).append('}'));
    }
    
    public ChatStyle setChatHoverEvent(final HoverEvent lllllllllllllllIIlIIlllIlllIIllI) {
        this.chatHoverEvent = lllllllllllllllIIlIIlllIlllIIllI;
        return this;
    }
    
    public String getFormattingCode() {
        if (this.isEmpty()) {
            return (this.parentStyle != null) ? this.parentStyle.getFormattingCode() : "";
        }
        final StringBuilder lllllllllllllllIIlIIlllIllIlIlII = new StringBuilder();
        if (this.getColor() != null) {
            lllllllllllllllIIlIIlllIllIlIlII.append(this.getColor());
        }
        if (this.getBold()) {
            lllllllllllllllIIlIIlllIllIlIlII.append(EnumChatFormatting.BOLD);
        }
        if (this.getItalic()) {
            lllllllllllllllIIlIIlllIllIlIlII.append(EnumChatFormatting.ITALIC);
        }
        if (this.getUnderlined()) {
            lllllllllllllllIIlIIlllIllIlIlII.append(EnumChatFormatting.UNDERLINE);
        }
        if (this.getObfuscated()) {
            lllllllllllllllIIlIIlllIllIlIlII.append(EnumChatFormatting.OBFUSCATED);
        }
        if (this.getStrikethrough()) {
            lllllllllllllllIIlIIlllIllIlIlII.append(EnumChatFormatting.STRIKETHROUGH);
        }
        return String.valueOf(lllllllllllllllIIlIIlllIllIlIlII);
    }
    
    public boolean getBold() {
        return (this.bold == null) ? this.getParent().getBold() : this.bold;
    }
    
    static /* synthetic */ void access$0(final ChatStyle lllllllllllllllIIlIIlllIlIlIlIlI, final Boolean lllllllllllllllIIlIIlllIlIlIlIIl) {
        lllllllllllllllIIlIIlllIlIlIlIlI.bold = lllllllllllllllIIlIIlllIlIlIlIIl;
    }
    
    private ChatStyle getParent() {
        return (this.parentStyle == null) ? ChatStyle.rootStyle : this.parentStyle;
    }
    
    public ChatStyle setStrikethrough(final Boolean lllllllllllllllIIlIIlllIllllllII) {
        this.strikethrough = lllllllllllllllIIlIIlllIllllllII;
        return this;
    }
    
    public static class Serializer implements JsonDeserializer, JsonSerializer
    {
        public ChatStyle deserialize(final JsonElement lllllllllllllllllIIIlIlIlIllllII, final Type lllllllllllllllllIIIlIlIllIIlIIl, final JsonDeserializationContext lllllllllllllllllIIIlIlIlIlllIll) {
            if (!lllllllllllllllllIIIlIlIlIllllII.isJsonObject()) {
                return null;
            }
            final ChatStyle lllllllllllllllllIIIlIlIllIIIlll = new ChatStyle();
            final JsonObject lllllllllllllllllIIIlIlIllIIIllI = lllllllllllllllllIIIlIlIlIllllII.getAsJsonObject();
            if (lllllllllllllllllIIIlIlIllIIIllI == null) {
                return null;
            }
            if (lllllllllllllllllIIIlIlIllIIIllI.has("bold")) {
                ChatStyle.access$0(lllllllllllllllllIIIlIlIllIIIlll, lllllllllllllllllIIIlIlIllIIIllI.get("bold").getAsBoolean());
            }
            if (lllllllllllllllllIIIlIlIllIIIllI.has("italic")) {
                ChatStyle.access$1(lllllllllllllllllIIIlIlIllIIIlll, lllllllllllllllllIIIlIlIllIIIllI.get("italic").getAsBoolean());
            }
            if (lllllllllllllllllIIIlIlIllIIIllI.has("underlined")) {
                ChatStyle.access$2(lllllllllllllllllIIIlIlIllIIIlll, lllllllllllllllllIIIlIlIllIIIllI.get("underlined").getAsBoolean());
            }
            if (lllllllllllllllllIIIlIlIllIIIllI.has("strikethrough")) {
                ChatStyle.access$3(lllllllllllllllllIIIlIlIllIIIlll, lllllllllllllllllIIIlIlIllIIIllI.get("strikethrough").getAsBoolean());
            }
            if (lllllllllllllllllIIIlIlIllIIIllI.has("obfuscated")) {
                ChatStyle.access$4(lllllllllllllllllIIIlIlIllIIIlll, lllllllllllllllllIIIlIlIllIIIllI.get("obfuscated").getAsBoolean());
            }
            if (lllllllllllllllllIIIlIlIllIIIllI.has("color")) {
                ChatStyle.access$5(lllllllllllllllllIIIlIlIllIIIlll, (EnumChatFormatting)lllllllllllllllllIIIlIlIlIlllIll.deserialize(lllllllllllllllllIIIlIlIllIIIllI.get("color"), (Type)EnumChatFormatting.class));
            }
            if (lllllllllllllllllIIIlIlIllIIIllI.has("insertion")) {
                ChatStyle.access$6(lllllllllllllllllIIIlIlIllIIIlll, lllllllllllllllllIIIlIlIllIIIllI.get("insertion").getAsString());
            }
            if (lllllllllllllllllIIIlIlIllIIIllI.has("clickEvent")) {
                final JsonObject lllllllllllllllllIIIlIlIllIIIlIl = lllllllllllllllllIIIlIlIllIIIllI.getAsJsonObject("clickEvent");
                if (lllllllllllllllllIIIlIlIllIIIlIl != null) {
                    final JsonPrimitive lllllllllllllllllIIIlIlIllIIIIll = lllllllllllllllllIIIlIlIllIIIlIl.getAsJsonPrimitive("action");
                    final ClickEvent.Action lllllllllllllllllIIIlIlIllIIIIIl = (lllllllllllllllllIIIlIlIllIIIIll == null) ? null : ClickEvent.Action.getValueByCanonicalName(lllllllllllllllllIIIlIlIllIIIIll.getAsString());
                    final JsonPrimitive lllllllllllllllllIIIlIlIllIIIIII = lllllllllllllllllIIIlIlIllIIIlIl.getAsJsonPrimitive("value");
                    final String lllllllllllllllllIIIlIlIlIllllll = (lllllllllllllllllIIIlIlIllIIIIII == null) ? null : lllllllllllllllllIIIlIlIllIIIIII.getAsString();
                    if (lllllllllllllllllIIIlIlIllIIIIIl != null && lllllllllllllllllIIIlIlIlIllllll != null && lllllllllllllllllIIIlIlIllIIIIIl.shouldAllowInChat()) {
                        ChatStyle.access$7(lllllllllllllllllIIIlIlIllIIIlll, new ClickEvent(lllllllllllllllllIIIlIlIllIIIIIl, lllllllllllllllllIIIlIlIlIllllll));
                    }
                }
            }
            if (lllllllllllllllllIIIlIlIllIIIllI.has("hoverEvent")) {
                final JsonObject lllllllllllllllllIIIlIlIllIIIlII = lllllllllllllllllIIIlIlIllIIIllI.getAsJsonObject("hoverEvent");
                if (lllllllllllllllllIIIlIlIllIIIlII != null) {
                    final JsonPrimitive lllllllllllllllllIIIlIlIllIIIIlI = lllllllllllllllllIIIlIlIllIIIlII.getAsJsonPrimitive("action");
                    final HoverEvent.Action lllllllllllllllllIIIlIlIlIlllllI = (lllllllllllllllllIIIlIlIllIIIIlI == null) ? null : HoverEvent.Action.getValueByCanonicalName(lllllllllllllllllIIIlIlIllIIIIlI.getAsString());
                    final IChatComponent lllllllllllllllllIIIlIlIlIllllIl = (IChatComponent)lllllllllllllllllIIIlIlIlIlllIll.deserialize(lllllllllllllllllIIIlIlIllIIIlII.get("value"), (Type)IChatComponent.class);
                    if (lllllllllllllllllIIIlIlIlIlllllI != null && lllllllllllllllllIIIlIlIlIllllIl != null && lllllllllllllllllIIIlIlIlIlllllI.shouldAllowInChat()) {
                        ChatStyle.access$8(lllllllllllllllllIIIlIlIllIIIlll, new HoverEvent(lllllllllllllllllIIIlIlIlIlllllI, lllllllllllllllllIIIlIlIlIllllIl));
                    }
                }
            }
            return lllllllllllllllllIIIlIlIllIIIlll;
        }
        
        public JsonElement serialize(final ChatStyle lllllllllllllllllIIIlIlIlIlIlllI, final Type lllllllllllllllllIIIlIlIlIlIllIl, final JsonSerializationContext lllllllllllllllllIIIlIlIlIlIllII) {
            if (lllllllllllllllllIIIlIlIlIlIlllI.isEmpty()) {
                return null;
            }
            final JsonObject lllllllllllllllllIIIlIlIlIlIlIll = new JsonObject();
            if (lllllllllllllllllIIIlIlIlIlIlllI.bold != null) {
                lllllllllllllllllIIIlIlIlIlIlIll.addProperty("bold", lllllllllllllllllIIIlIlIlIlIlllI.bold);
            }
            if (lllllllllllllllllIIIlIlIlIlIlllI.italic != null) {
                lllllllllllllllllIIIlIlIlIlIlIll.addProperty("italic", lllllllllllllllllIIIlIlIlIlIlllI.italic);
            }
            if (lllllllllllllllllIIIlIlIlIlIlllI.underlined != null) {
                lllllllllllllllllIIIlIlIlIlIlIll.addProperty("underlined", lllllllllllllllllIIIlIlIlIlIlllI.underlined);
            }
            if (lllllllllllllllllIIIlIlIlIlIlllI.strikethrough != null) {
                lllllllllllllllllIIIlIlIlIlIlIll.addProperty("strikethrough", lllllllllllllllllIIIlIlIlIlIlllI.strikethrough);
            }
            if (lllllllllllllllllIIIlIlIlIlIlllI.obfuscated != null) {
                lllllllllllllllllIIIlIlIlIlIlIll.addProperty("obfuscated", lllllllllllllllllIIIlIlIlIlIlllI.obfuscated);
            }
            if (lllllllllllllllllIIIlIlIlIlIlllI.color != null) {
                lllllllllllllllllIIIlIlIlIlIlIll.add("color", lllllllllllllllllIIIlIlIlIlIllII.serialize((Object)lllllllllllllllllIIIlIlIlIlIlllI.color));
            }
            if (lllllllllllllllllIIIlIlIlIlIlllI.insertion != null) {
                lllllllllllllllllIIIlIlIlIlIlIll.add("insertion", lllllllllllllllllIIIlIlIlIlIllII.serialize((Object)lllllllllllllllllIIIlIlIlIlIlllI.insertion));
            }
            if (lllllllllllllllllIIIlIlIlIlIlllI.chatClickEvent != null) {
                final JsonObject lllllllllllllllllIIIlIlIlIlIlIlI = new JsonObject();
                lllllllllllllllllIIIlIlIlIlIlIlI.addProperty("action", lllllllllllllllllIIIlIlIlIlIlllI.chatClickEvent.getAction().getCanonicalName());
                lllllllllllllllllIIIlIlIlIlIlIlI.addProperty("value", lllllllllllllllllIIIlIlIlIlIlllI.chatClickEvent.getValue());
                lllllllllllllllllIIIlIlIlIlIlIll.add("clickEvent", (JsonElement)lllllllllllllllllIIIlIlIlIlIlIlI);
            }
            if (lllllllllllllllllIIIlIlIlIlIlllI.chatHoverEvent != null) {
                final JsonObject lllllllllllllllllIIIlIlIlIlIlIIl = new JsonObject();
                lllllllllllllllllIIIlIlIlIlIlIIl.addProperty("action", lllllllllllllllllIIIlIlIlIlIlllI.chatHoverEvent.getAction().getCanonicalName());
                lllllllllllllllllIIIlIlIlIlIlIIl.add("value", lllllllllllllllllIIIlIlIlIlIllII.serialize((Object)lllllllllllllllllIIIlIlIlIlIlllI.chatHoverEvent.getValue()));
                lllllllllllllllllIIIlIlIlIlIlIll.add("hoverEvent", (JsonElement)lllllllllllllllllIIIlIlIlIlIlIIl);
            }
            return (JsonElement)lllllllllllllllllIIIlIlIlIlIlIll;
        }
        
        public JsonElement serialize(final Object lllllllllllllllllIIIlIlIlIIllIll, final Type lllllllllllllllllIIIlIlIlIIllllI, final JsonSerializationContext lllllllllllllllllIIIlIlIlIIlllIl) {
            return this.serialize((ChatStyle)lllllllllllllllllIIIlIlIlIIllIll, lllllllllllllllllIIIlIlIlIIllllI, lllllllllllllllllIIIlIlIlIIlllIl);
        }
        
        static {
            __OBFID = "CL_00001268";
        }
    }
}
