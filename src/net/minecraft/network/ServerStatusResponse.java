package net.minecraft.network;

import java.lang.reflect.*;
import net.minecraft.util.*;
import com.mojang.authlib.*;
import com.google.gson.*;
import java.util.*;

public class ServerStatusResponse
{
    private /* synthetic */ String favicon;
    private /* synthetic */ IChatComponent serverMotd;
    private /* synthetic */ PlayerCountData playerCount;
    private /* synthetic */ MinecraftProtocolVersionIdentifier protocolVersion;
    
    public String getFavicon() {
        return this.favicon;
    }
    
    public PlayerCountData getPlayerCountData() {
        return this.playerCount;
    }
    
    public void setServerDescription(final IChatComponent llllllllllllllIIlIlllllllIIIIlll) {
        this.serverMotd = llllllllllllllIIlIlllllllIIIIlll;
    }
    
    static {
        __OBFID = "CL_00001385";
    }
    
    public IChatComponent getServerDescription() {
        return this.serverMotd;
    }
    
    public void setPlayerCountData(final PlayerCountData llllllllllllllIIlIlllllllIIIIIII) {
        this.playerCount = llllllllllllllIIlIlllllllIIIIIII;
    }
    
    public void setProtocolVersionInfo(final MinecraftProtocolVersionIdentifier llllllllllllllIIlIllllllIlllIlIl) {
        this.protocolVersion = llllllllllllllIIlIllllllIlllIlIl;
    }
    
    public void setFavicon(final String llllllllllllllIIlIllllllIllIllll) {
        this.favicon = llllllllllllllIIlIllllllIllIllll;
    }
    
    public MinecraftProtocolVersionIdentifier getProtocolVersionInfo() {
        return this.protocolVersion;
    }
    
    public static class MinecraftProtocolVersionIdentifier
    {
        private final /* synthetic */ int protocol;
        private final /* synthetic */ String name;
        
        public int getProtocol() {
            return this.protocol;
        }
        
        static {
            __OBFID = "CL_00001389";
        }
        
        public MinecraftProtocolVersionIdentifier(final String llllllllllllllIlIIIlIIIllIllIIIl, final int llllllllllllllIlIIIlIIIllIllIIII) {
            this.name = llllllllllllllIlIIIlIIIllIllIIIl;
            this.protocol = llllllllllllllIlIIIlIIIllIllIIII;
        }
        
        public String getName() {
            return this.name;
        }
        
        public static class Serializer implements JsonSerializer, JsonDeserializer
        {
            public JsonElement serialize(final Object llllllllllllllllIlllllIIIIlIIlll, final Type llllllllllllllllIlllllIIIIlIIllI, final JsonSerializationContext llllllllllllllllIlllllIIIIlIIlIl) {
                return this.serialize((MinecraftProtocolVersionIdentifier)llllllllllllllllIlllllIIIIlIIlll, llllllllllllllllIlllllIIIIlIIllI, llllllllllllllllIlllllIIIIlIIlIl);
            }
            
            public MinecraftProtocolVersionIdentifier deserialize1(final JsonElement llllllllllllllllIlllllIIIIlllIll, final Type llllllllllllllllIlllllIIIIlllllI, final JsonDeserializationContext llllllllllllllllIlllllIIIIllllIl) {
                final JsonObject llllllllllllllllIlllllIIIIllllII = JsonUtils.getElementAsJsonObject(llllllllllllllllIlllllIIIIlllIll, "version");
                return new MinecraftProtocolVersionIdentifier(JsonUtils.getJsonObjectStringFieldValue(llllllllllllllllIlllllIIIIllllII, "name"), JsonUtils.getJsonObjectIntegerFieldValue(llllllllllllllllIlllllIIIIllllII, "protocol"));
            }
            
            public Object deserialize(final JsonElement llllllllllllllllIlllllIIIIIlllll, final Type llllllllllllllllIlllllIIIIIllllI, final JsonDeserializationContext llllllllllllllllIlllllIIIIIlllIl) {
                return this.deserialize1(llllllllllllllllIlllllIIIIIlllll, llllllllllllllllIlllllIIIIIllllI, llllllllllllllllIlllllIIIIIlllIl);
            }
            
            public JsonElement serialize(final MinecraftProtocolVersionIdentifier llllllllllllllllIlllllIIIIllIllI, final Type llllllllllllllllIlllllIIIIllIlIl, final JsonSerializationContext llllllllllllllllIlllllIIIIllIlII) {
                final JsonObject llllllllllllllllIlllllIIIIllIIll = new JsonObject();
                llllllllllllllllIlllllIIIIllIIll.addProperty("name", llllllllllllllllIlllllIIIIllIllI.getName());
                llllllllllllllllIlllllIIIIllIIll.addProperty("protocol", (Number)llllllllllllllllIlllllIIIIllIllI.getProtocol());
                return (JsonElement)llllllllllllllllIlllllIIIIllIIll;
            }
            
            static {
                __OBFID = "CL_00001390";
            }
        }
    }
    
    public static class PlayerCountData
    {
        private final /* synthetic */ int onlinePlayerCount;
        private /* synthetic */ GameProfile[] players;
        private final /* synthetic */ int maxPlayers;
        
        static {
            __OBFID = "CL_00001386";
        }
        
        public void setPlayers(final GameProfile[] llllllllllllllIllIlIIllIIlIIlIII) {
            this.players = llllllllllllllIllIlIIllIIlIIlIII;
        }
        
        public int getMaxPlayers() {
            return this.maxPlayers;
        }
        
        public int getOnlinePlayerCount() {
            return this.onlinePlayerCount;
        }
        
        public PlayerCountData(final int llllllllllllllIllIlIIllIIlIllllI, final int llllllllllllllIllIlIIllIIlIlllIl) {
            this.maxPlayers = llllllllllllllIllIlIIllIIlIllllI;
            this.onlinePlayerCount = llllllllllllllIllIlIIllIIlIlllIl;
        }
        
        public GameProfile[] getPlayers() {
            return this.players;
        }
        
        public static class Serializer implements JsonSerializer, JsonDeserializer
        {
            static {
                __OBFID = "CL_00001387";
            }
            
            public JsonElement serialize(final PlayerCountData lIlIIllIlllIlI, final Type lIlIIllIlllIIl, final JsonSerializationContext lIlIIllIlllIII) {
                final JsonObject lIlIIllIllIlll = new JsonObject();
                lIlIIllIllIlll.addProperty("max", (Number)lIlIIllIlllIlI.getMaxPlayers());
                lIlIIllIllIlll.addProperty("online", (Number)lIlIIllIlllIlI.getOnlinePlayerCount());
                if (lIlIIllIlllIlI.getPlayers() != null && lIlIIllIlllIlI.getPlayers().length > 0) {
                    final JsonArray lIlIIllIllIllI = new JsonArray();
                    for (int lIlIIllIllIlIl = 0; lIlIIllIllIlIl < lIlIIllIlllIlI.getPlayers().length; ++lIlIIllIllIlIl) {
                        final JsonObject lIlIIllIllIlII = new JsonObject();
                        final UUID lIlIIllIllIIll = lIlIIllIlllIlI.getPlayers()[lIlIIllIllIlIl].getId();
                        lIlIIllIllIlII.addProperty("id", (lIlIIllIllIIll == null) ? "" : lIlIIllIllIIll.toString());
                        lIlIIllIllIlII.addProperty("name", lIlIIllIlllIlI.getPlayers()[lIlIIllIllIlIl].getName());
                        lIlIIllIllIllI.add((JsonElement)lIlIIllIllIlII);
                    }
                    lIlIIllIllIlll.add("sample", (JsonElement)lIlIIllIllIllI);
                }
                return (JsonElement)lIlIIllIllIlll;
            }
            
            public JsonElement serialize(final Object lIlIIllIlIIlll, final Type lIlIIllIlIIllI, final JsonSerializationContext lIlIIllIlIIIIl) {
                return this.serialize((PlayerCountData)lIlIIllIlIIlll, lIlIIllIlIIllI, lIlIIllIlIIIIl);
            }
            
            public Object deserialize(final JsonElement lIlIIllIIllIll, final Type lIlIIllIIlIllI, final JsonDeserializationContext lIlIIllIIlIlIl) {
                return this.deserialize1(lIlIIllIIllIll, lIlIIllIIlIllI, lIlIIllIIlIlIl);
            }
            
            public PlayerCountData deserialize1(final JsonElement lIlIIlllIlIIll, final Type lIlIIlllIlIIlI, final JsonDeserializationContext lIlIIlllIlIIIl) {
                final JsonObject lIlIIlllIlIIII = JsonUtils.getElementAsJsonObject(lIlIIlllIlIIll, "players");
                final PlayerCountData lIlIIlllIIllll = new PlayerCountData(JsonUtils.getJsonObjectIntegerFieldValue(lIlIIlllIlIIII, "max"), JsonUtils.getJsonObjectIntegerFieldValue(lIlIIlllIlIIII, "online"));
                if (JsonUtils.jsonObjectFieldTypeIsArray(lIlIIlllIlIIII, "sample")) {
                    final JsonArray lIlIIlllIIlllI = JsonUtils.getJsonObjectJsonArrayField(lIlIIlllIlIIII, "sample");
                    if (lIlIIlllIIlllI.size() > 0) {
                        final GameProfile[] lIlIIlllIIllIl = new GameProfile[lIlIIlllIIlllI.size()];
                        for (int lIlIIlllIIllII = 0; lIlIIlllIIllII < lIlIIlllIIllIl.length; ++lIlIIlllIIllII) {
                            final JsonObject lIlIIlllIIlIll = JsonUtils.getElementAsJsonObject(lIlIIlllIIlllI.get(lIlIIlllIIllII), String.valueOf(new StringBuilder("player[").append(lIlIIlllIIllII).append("]")));
                            final String lIlIIlllIIlIlI = JsonUtils.getJsonObjectStringFieldValue(lIlIIlllIIlIll, "id");
                            lIlIIlllIIllIl[lIlIIlllIIllII] = new GameProfile(UUID.fromString(lIlIIlllIIlIlI), JsonUtils.getJsonObjectStringFieldValue(lIlIIlllIIlIll, "name"));
                        }
                        lIlIIlllIIllll.setPlayers(lIlIIlllIIllIl);
                    }
                }
                return lIlIIlllIIllll;
            }
        }
    }
    
    public static class Serializer implements JsonDeserializer, JsonSerializer
    {
        public JsonElement serialize(final Object llllllllllllllllIlIlIIllIIllllII, final Type llllllllllllllllIlIlIIllIIlllIll, final JsonSerializationContext llllllllllllllllIlIlIIllIIllIllI) {
            return this.serialize((ServerStatusResponse)llllllllllllllllIlIlIIllIIllllII, llllllllllllllllIlIlIIllIIlllIll, llllllllllllllllIlIlIIllIIllIllI);
        }
        
        static {
            __OBFID = "CL_00001388";
        }
        
        public ServerStatusResponse deserialize1(final JsonElement llllllllllllllllIlIlIIllIlIlIlIl, final Type llllllllllllllllIlIlIIllIlIlIlII, final JsonDeserializationContext llllllllllllllllIlIlIIllIlIIllll) {
            final JsonObject llllllllllllllllIlIlIIllIlIlIIlI = JsonUtils.getElementAsJsonObject(llllllllllllllllIlIlIIllIlIlIlIl, "status");
            final ServerStatusResponse llllllllllllllllIlIlIIllIlIlIIIl = new ServerStatusResponse();
            if (llllllllllllllllIlIlIIllIlIlIIlI.has("description")) {
                llllllllllllllllIlIlIIllIlIlIIIl.setServerDescription((IChatComponent)llllllllllllllllIlIlIIllIlIIllll.deserialize(llllllllllllllllIlIlIIllIlIlIIlI.get("description"), (Type)IChatComponent.class));
            }
            if (llllllllllllllllIlIlIIllIlIlIIlI.has("players")) {
                llllllllllllllllIlIlIIllIlIlIIIl.setPlayerCountData((PlayerCountData)llllllllllllllllIlIlIIllIlIIllll.deserialize(llllllllllllllllIlIlIIllIlIlIIlI.get("players"), (Type)PlayerCountData.class));
            }
            if (llllllllllllllllIlIlIIllIlIlIIlI.has("version")) {
                llllllllllllllllIlIlIIllIlIlIIIl.setProtocolVersionInfo((MinecraftProtocolVersionIdentifier)llllllllllllllllIlIlIIllIlIIllll.deserialize(llllllllllllllllIlIlIIllIlIlIIlI.get("version"), (Type)MinecraftProtocolVersionIdentifier.class));
            }
            if (llllllllllllllllIlIlIIllIlIlIIlI.has("favicon")) {
                llllllllllllllllIlIlIIllIlIlIIIl.setFavicon(JsonUtils.getJsonObjectStringFieldValue(llllllllllllllllIlIlIIllIlIlIIlI, "favicon"));
            }
            return llllllllllllllllIlIlIIllIlIlIIIl;
        }
        
        public JsonElement serialize(final ServerStatusResponse llllllllllllllllIlIlIIllIlIIlIII, final Type llllllllllllllllIlIlIIllIlIIIlll, final JsonSerializationContext llllllllllllllllIlIlIIllIlIIIllI) {
            final JsonObject llllllllllllllllIlIlIIllIlIIIlIl = new JsonObject();
            if (llllllllllllllllIlIlIIllIlIIlIII.getServerDescription() != null) {
                llllllllllllllllIlIlIIllIlIIIlIl.add("description", llllllllllllllllIlIlIIllIlIIIllI.serialize((Object)llllllllllllllllIlIlIIllIlIIlIII.getServerDescription()));
            }
            if (llllllllllllllllIlIlIIllIlIIlIII.getPlayerCountData() != null) {
                llllllllllllllllIlIlIIllIlIIIlIl.add("players", llllllllllllllllIlIlIIllIlIIIllI.serialize((Object)llllllllllllllllIlIlIIllIlIIlIII.getPlayerCountData()));
            }
            if (llllllllllllllllIlIlIIllIlIIlIII.getProtocolVersionInfo() != null) {
                llllllllllllllllIlIlIIllIlIIIlIl.add("version", llllllllllllllllIlIlIIllIlIIIllI.serialize((Object)llllllllllllllllIlIlIIllIlIIlIII.getProtocolVersionInfo()));
            }
            if (llllllllllllllllIlIlIIllIlIIlIII.getFavicon() != null) {
                llllllllllllllllIlIlIIllIlIIIlIl.addProperty("favicon", llllllllllllllllIlIlIIllIlIIlIII.getFavicon());
            }
            return (JsonElement)llllllllllllllllIlIlIIllIlIIIlIl;
        }
        
        public Object deserialize(final JsonElement llllllllllllllllIlIlIIllIIlIllII, final Type llllllllllllllllIlIlIIllIIlIllll, final JsonDeserializationContext llllllllllllllllIlIlIIllIIlIlIlI) {
            return this.deserialize1(llllllllllllllllIlIlIIllIIlIllII, llllllllllllllllIlIlIIllIIlIllll, llllllllllllllllIlIlIIllIIlIlIlI);
        }
    }
}
