package net.minecraft.util;

import java.util.*;
import java.lang.reflect.*;
import com.google.gson.*;

public interface IChatComponent extends Iterable
{
    ChatStyle getChatStyle();
    
    String getFormattedText();
    
    IChatComponent appendText(final String p0);
    
    List getSiblings();
    
    IChatComponent createCopy();
    
    String getUnformattedTextForChat();
    
    IChatComponent setChatStyle(final ChatStyle p0);
    
    IChatComponent appendSibling(final IChatComponent p0);
    
    String getUnformattedText();
    
    public static class Serializer implements JsonSerializer, JsonDeserializer
    {
        private static final /* synthetic */ Gson GSON;
        
        private void serializeChatStyle(final ChatStyle lIllIllIII, final JsonObject lIllIllllI, final JsonSerializationContext lIllIlIllI) {
            final JsonElement lIllIlllII = lIllIlIllI.serialize((Object)lIllIllIII);
            if (lIllIlllII.isJsonObject()) {
                final JsonObject lIllIllIll = (JsonObject)lIllIlllII;
                for (final Map.Entry lIllIllIIl : lIllIllIll.entrySet()) {
                    lIllIllllI.add((String)lIllIllIIl.getKey(), (JsonElement)lIllIllIIl.getValue());
                }
            }
        }
        
        public JsonElement serialize(final Object lIlIlIIIIl, final Type lIlIIlllII, final JsonSerializationContext lIlIIllIll) {
            return this.serialize((IChatComponent)lIlIlIIIIl, lIlIIlllII, lIlIIllIll);
        }
        
        public static String componentToJson(final IChatComponent lIlIlIlIlI) {
            return Serializer.GSON.toJson((Object)lIlIlIlIlI);
        }
        
        public static IChatComponent jsonToComponent(final String lIlIlIlIII) {
            return (IChatComponent)Serializer.GSON.fromJson(lIlIlIlIII, (Class)IChatComponent.class);
        }
        
        public IChatComponent deserialize(final JsonElement llIIIIlIII, final Type lIllllIIII, final JsonDeserializationContext lIlllIllll) {
            if (llIIIIlIII.isJsonPrimitive()) {
                return new ChatComponentText(llIIIIlIII.getAsString());
            }
            if (llIIIIlIII.isJsonObject()) {
                final JsonObject llIIIIIIII = llIIIIlIII.getAsJsonObject();
                Object lIlllllIll = null;
                if (llIIIIIIII.has("text")) {
                    final Object lIllllllll = new ChatComponentText(llIIIIIIII.get("text").getAsString());
                }
                else if (llIIIIIIII.has("translate")) {
                    final String lIlllllIlI = llIIIIIIII.get("translate").getAsString();
                    if (llIIIIIIII.has("with")) {
                        final JsonArray lIlllllIIl = llIIIIIIII.getAsJsonArray("with");
                        final Object[] lIlllllIII = new Object[lIlllllIIl.size()];
                        for (int lIllllIlll = 0; lIllllIlll < lIlllllIII.length; ++lIllllIlll) {
                            lIlllllIII[lIllllIlll] = this.deserialize(lIlllllIIl.get(lIllllIlll), lIllllIIII, lIlllIllll);
                            if (lIlllllIII[lIllllIlll] instanceof ChatComponentText) {
                                final ChatComponentText lIllllIllI = (ChatComponentText)lIlllllIII[lIllllIlll];
                                if (lIllllIllI.getChatStyle().isEmpty() && lIllllIllI.getSiblings().isEmpty()) {
                                    lIlllllIII[lIllllIlll] = lIllllIllI.getChatComponentText_TextValue();
                                }
                            }
                        }
                        final Object lIlllllllI = new ChatComponentTranslation(lIlllllIlI, lIlllllIII);
                    }
                    else {
                        final Object lIllllllIl = new ChatComponentTranslation(lIlllllIlI, new Object[0]);
                    }
                }
                else if (llIIIIIIII.has("score")) {
                    final JsonObject lIllllIlIl = llIIIIIIII.getAsJsonObject("score");
                    if (!lIllllIlIl.has("name") || !lIllllIlIl.has("objective")) {
                        throw new JsonParseException("A score component needs a least a name and an objective");
                    }
                    final Object lIllllllII = new ChatComponentScore(JsonUtils.getJsonObjectStringFieldValue(lIllllIlIl, "name"), JsonUtils.getJsonObjectStringFieldValue(lIllllIlIl, "objective"));
                    if (lIllllIlIl.has("value")) {
                        ((ChatComponentScore)lIllllllII).func_179997_b(JsonUtils.getJsonObjectStringFieldValue(lIllllIlIl, "value"));
                    }
                }
                else {
                    if (!llIIIIIIII.has("selector")) {
                        throw new JsonParseException(String.valueOf(new StringBuilder("Don't know how to turn ").append(llIIIIlIII.toString()).append(" into a Component")));
                    }
                    lIlllllIll = new ChatComponentSelector(JsonUtils.getJsonObjectStringFieldValue(llIIIIIIII, "selector"));
                }
                if (llIIIIIIII.has("extra")) {
                    final JsonArray lIllllIlII = llIIIIIIII.getAsJsonArray("extra");
                    if (lIllllIlII.size() <= 0) {
                        throw new JsonParseException("Unexpected empty array of components");
                    }
                    for (int lIllllIIll = 0; lIllllIIll < lIllllIlII.size(); ++lIllllIIll) {
                        ((IChatComponent)lIlllllIll).appendSibling(this.deserialize(lIllllIlII.get(lIllllIIll), lIllllIIII, lIlllIllll));
                    }
                }
                ((IChatComponent)lIlllllIll).setChatStyle((ChatStyle)lIlllIllll.deserialize(llIIIIlIII, (Type)ChatStyle.class));
                return (IChatComponent)lIlllllIll;
            }
            if (llIIIIlIII.isJsonArray()) {
                final JsonArray llIIIIIlIl = llIIIIlIII.getAsJsonArray();
                IChatComponent llIIIIIlII = null;
                for (final JsonElement llIIIIIIlI : llIIIIIlIl) {
                    final IChatComponent llIIIIIIIl = this.deserialize(llIIIIIIlI, llIIIIIIlI.getClass(), lIlllIllll);
                    if (llIIIIIlII == null) {
                        llIIIIIlII = llIIIIIIIl;
                    }
                    else {
                        llIIIIIlII.appendSibling(llIIIIIIIl);
                    }
                }
                return llIIIIIlII;
            }
            throw new JsonParseException(String.valueOf(new StringBuilder("Don't know how to turn ").append(llIIIIlIII.toString()).append(" into a Component")));
        }
        
        public JsonElement serialize(final IChatComponent lIlIllIlIl, final Type lIllIIIlIl, final JsonSerializationContext lIlIllIlII) {
            if (lIlIllIlIl instanceof ChatComponentText && lIlIllIlIl.getChatStyle().isEmpty() && lIlIllIlIl.getSiblings().isEmpty()) {
                return (JsonElement)new JsonPrimitive(((ChatComponentText)lIlIllIlIl).getChatComponentText_TextValue());
            }
            final JsonObject lIllIIIIll = new JsonObject();
            if (!lIlIllIlIl.getChatStyle().isEmpty()) {
                this.serializeChatStyle(lIlIllIlIl.getChatStyle(), lIllIIIIll, lIlIllIlII);
            }
            if (!lIlIllIlIl.getSiblings().isEmpty()) {
                final JsonArray lIllIIIIlI = new JsonArray();
                for (final IChatComponent lIllIIIIII : lIlIllIlIl.getSiblings()) {
                    lIllIIIIlI.add(this.serialize(lIllIIIIII, lIllIIIIII.getClass(), lIlIllIlII));
                }
                lIllIIIIll.add("extra", (JsonElement)lIllIIIIlI);
            }
            if (lIlIllIlIl instanceof ChatComponentText) {
                lIllIIIIll.addProperty("text", ((ChatComponentText)lIlIllIlIl).getChatComponentText_TextValue());
            }
            else if (lIlIllIlIl instanceof ChatComponentTranslation) {
                final ChatComponentTranslation lIlIllllll = (ChatComponentTranslation)lIlIllIlIl;
                lIllIIIIll.addProperty("translate", lIlIllllll.getKey());
                if (lIlIllllll.getFormatArgs() != null && lIlIllllll.getFormatArgs().length > 0) {
                    final JsonArray lIlIlllllI = new JsonArray();
                    for (final Object lIlIlllIlI : lIlIllllll.getFormatArgs()) {
                        if (lIlIlllIlI instanceof IChatComponent) {
                            lIlIlllllI.add(this.serialize((IChatComponent)lIlIlllIlI, lIlIlllIlI.getClass(), lIlIllIlII));
                        }
                        else {
                            lIlIlllllI.add((JsonElement)new JsonPrimitive(String.valueOf(lIlIlllIlI)));
                        }
                    }
                    lIllIIIIll.add("with", (JsonElement)lIlIlllllI);
                }
            }
            else if (lIlIllIlIl instanceof ChatComponentScore) {
                final ChatComponentScore lIlIlllIIl = (ChatComponentScore)lIlIllIlIl;
                final JsonObject lIlIlllIII = new JsonObject();
                lIlIlllIII.addProperty("name", lIlIlllIIl.func_179995_g());
                lIlIlllIII.addProperty("objective", lIlIlllIIl.func_179994_h());
                lIlIlllIII.addProperty("value", lIlIlllIIl.getUnformattedTextForChat());
                lIllIIIIll.add("score", (JsonElement)lIlIlllIII);
            }
            else {
                if (!(lIlIllIlIl instanceof ChatComponentSelector)) {
                    throw new IllegalArgumentException(String.valueOf(new StringBuilder("Don't know how to serialize ").append(lIlIllIlIl).append(" as a Component")));
                }
                final ChatComponentSelector lIlIllIlll = (ChatComponentSelector)lIlIllIlIl;
                lIllIIIIll.addProperty("selector", lIlIllIlll.func_179992_g());
            }
            return (JsonElement)lIllIIIIll;
        }
        
        static {
            __OBFID = "CL_00001263";
            final GsonBuilder llIIIllIIl = new GsonBuilder();
            llIIIllIIl.registerTypeHierarchyAdapter((Class)IChatComponent.class, (Object)new Serializer());
            llIIIllIIl.registerTypeHierarchyAdapter((Class)ChatStyle.class, (Object)new ChatStyle.Serializer());
            llIIIllIIl.registerTypeAdapterFactory((TypeAdapterFactory)new EnumTypeAdapterFactory());
            GSON = llIIIllIIl.create();
        }
    }
}
