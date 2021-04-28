package net.minecraft.util;

import io.netty.handler.codec.*;
import io.netty.channel.*;
import io.netty.buffer.*;
import java.io.*;
import net.minecraft.network.*;
import net.minecraft.network.play.server.*;
import org.apache.logging.log4j.*;

public class MessageSerializer extends MessageToByteEncoder
{
    private final /* synthetic */ EnumPacketDirection direction;
    private static final /* synthetic */ Marker RECEIVED_PACKET_MARKER;
    private static final /* synthetic */ Logger logger;
    
    protected void encode(final ChannelHandlerContext lllllllllllllllIllIlllllIIIlIlII, Packet lllllllllllllllIllIlllllIIIIllII, final ByteBuf lllllllllllllllIllIlllllIIIIlIll) throws IOException {
        final Integer lllllllllllllllIllIlllllIIIlIIIl = ((EnumConnectionState)lllllllllllllllIllIlllllIIIlIlII.channel().attr(NetworkManager.attrKeyConnectionState).get()).getPacketId(this.direction, lllllllllllllllIllIlllllIIIIllII);
        if (MessageSerializer.logger.isDebugEnabled()) {
            MessageSerializer.logger.debug(MessageSerializer.RECEIVED_PACKET_MARKER, "OUT: [{}:{}] {}", new Object[] { lllllllllllllllIllIlllllIIIlIlII.channel().attr(NetworkManager.attrKeyConnectionState).get(), lllllllllllllllIllIlllllIIIlIIIl, lllllllllllllllIllIlllllIIIIllII.getClass().getName() });
        }
        if (lllllllllllllllIllIlllllIIIlIIIl == null) {
            throw new IOException("Can't serialize unregistered packet");
        }
        final PacketBuffer lllllllllllllllIllIlllllIIIlIIII = new PacketBuffer(lllllllllllllllIllIlllllIIIIlIll);
        lllllllllllllllIllIlllllIIIlIIII.writeVarIntToBuffer(lllllllllllllllIllIlllllIIIlIIIl);
        try {
            if (lllllllllllllllIllIlllllIIIIllII instanceof S0CPacketSpawnPlayer) {
                lllllllllllllllIllIlllllIIIIllII = lllllllllllllllIllIlllllIIIIllII;
            }
            lllllllllllllllIllIlllllIIIIllII.writePacketData(lllllllllllllllIllIlllllIIIlIIII);
        }
        catch (Throwable lllllllllllllllIllIlllllIIIIllll) {
            MessageSerializer.logger.error((Object)lllllllllllllllIllIlllllIIIIllll);
        }
    }
    
    static {
        __OBFID = "CL_00001253";
        logger = LogManager.getLogger();
        RECEIVED_PACKET_MARKER = MarkerManager.getMarker("PACKET_SENT", NetworkManager.logMarkerPackets);
    }
    
    public MessageSerializer(final EnumPacketDirection lllllllllllllllIllIlllllIIIlllll) {
        this.direction = lllllllllllllllIllIlllllIIIlllll;
    }
    
    protected void encode(final ChannelHandlerContext lllllllllllllllIllIlllllIIIIIIlI, final Object lllllllllllllllIllIllllIllllllIl, final ByteBuf lllllllllllllllIllIllllIllllllII) throws IOException {
        this.encode(lllllllllllllllIllIlllllIIIIIIlI, (Packet)lllllllllllllllIllIllllIllllllIl, lllllllllllllllIllIllllIllllllII);
    }
}
