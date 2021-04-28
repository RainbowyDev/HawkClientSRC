package net.minecraft.network.status.server;

import net.minecraft.network.status.*;
import java.lang.reflect.*;
import net.minecraft.util.*;
import com.google.gson.*;
import net.minecraft.network.*;
import java.io.*;

public class S00PacketServerInfo implements Packet
{
    private /* synthetic */ ServerStatusResponse response;
    private static final /* synthetic */ Gson GSON;
    
    @Override
    public void processPacket(final INetHandler llllllllllllllllIlIlllllIlllIIII) {
        this.processPacket((INetHandlerStatusClient)llllllllllllllllIlIlllllIlllIIII);
    }
    
    public S00PacketServerInfo(final ServerStatusResponse llllllllllllllllIlIllllllIIIlIll) {
        this.response = llllllllllllllllIlIllllllIIIlIll;
    }
    
    static {
        __OBFID = "CL_00001384";
        GSON = new GsonBuilder().registerTypeAdapter((Type)ServerStatusResponse.MinecraftProtocolVersionIdentifier.class, (Object)new ServerStatusResponse.MinecraftProtocolVersionIdentifier.Serializer()).registerTypeAdapter((Type)ServerStatusResponse.PlayerCountData.class, (Object)new ServerStatusResponse.PlayerCountData.Serializer()).registerTypeAdapter((Type)ServerStatusResponse.class, (Object)new ServerStatusResponse.Serializer()).registerTypeHierarchyAdapter((Class)IChatComponent.class, (Object)new IChatComponent.Serializer()).registerTypeHierarchyAdapter((Class)ChatStyle.class, (Object)new ChatStyle.Serializer()).registerTypeAdapterFactory((TypeAdapterFactory)new EnumTypeAdapterFactory()).create();
    }
    
    public S00PacketServerInfo() {
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllllIlIlllllIlllllIl) throws IOException {
        llllllllllllllllIlIlllllIlllllIl.writeString(S00PacketServerInfo.GSON.toJson((Object)this.response));
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllllIlIllllllIIIIlIl) throws IOException {
        this.response = (ServerStatusResponse)S00PacketServerInfo.GSON.fromJson(llllllllllllllllIlIllllllIIIIlIl.readStringFromBuffer(32767), (Class)ServerStatusResponse.class);
    }
    
    public ServerStatusResponse func_149294_c() {
        return this.response;
    }
    
    public void processPacket(final INetHandlerStatusClient llllllllllllllllIlIlllllIllllIIl) {
        llllllllllllllllIlIlllllIllllIIl.handleServerInfo(this);
    }
}
