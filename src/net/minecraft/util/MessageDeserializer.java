package net.minecraft.util;

import io.netty.handler.codec.*;
import org.apache.logging.log4j.*;
import io.netty.channel.*;
import io.netty.buffer.*;
import java.util.*;
import java.io.*;
import net.minecraft.network.*;

public class MessageDeserializer extends ByteToMessageDecoder
{
    private final /* synthetic */ EnumPacketDirection direction;
    private static final /* synthetic */ Logger logger;
    private static final /* synthetic */ Marker RECEIVED_PACKET_MARKER;
    
    static {
        __OBFID = "CL_00001252";
        logger = LogManager.getLogger();
        RECEIVED_PACKET_MARKER = MarkerManager.getMarker("PACKET_RECEIVED", NetworkManager.logMarkerPackets);
    }
    
    protected void decode(final ChannelHandlerContext lllllllllllllllIllIlllIIIIIIllIl, final ByteBuf lllllllllllllllIllIlllIIIIIIIlIl, final List lllllllllllllllIllIlllIIIIIIlIll) throws IllegalAccessException, InstantiationException, IOException {
        if (lllllllllllllllIllIlllIIIIIIIlIl.readableBytes() != 0) {
            final PacketBuffer lllllllllllllllIllIlllIIIIIIlIlI = new PacketBuffer(lllllllllllllllIllIlllIIIIIIIlIl);
            final int lllllllllllllllIllIlllIIIIIIlIIl = lllllllllllllllIllIlllIIIIIIlIlI.readVarIntFromBuffer();
            final Packet lllllllllllllllIllIlllIIIIIIlIII = ((EnumConnectionState)lllllllllllllllIllIlllIIIIIIllIl.channel().attr(NetworkManager.attrKeyConnectionState).get()).getPacket(this.direction, lllllllllllllllIllIlllIIIIIIlIIl);
            if (lllllllllllllllIllIlllIIIIIIlIII == null) {
                throw new IOException(String.valueOf(new StringBuilder("Bad packet id ").append(lllllllllllllllIllIlllIIIIIIlIIl)));
            }
            lllllllllllllllIllIlllIIIIIIlIII.readPacketData(lllllllllllllllIllIlllIIIIIIlIlI);
            if (lllllllllllllllIllIlllIIIIIIlIlI.readableBytes() > 0) {
                throw new IOException(String.valueOf(new StringBuilder("Packet ").append(((EnumConnectionState)lllllllllllllllIllIlllIIIIIIllIl.channel().attr(NetworkManager.attrKeyConnectionState).get()).getId()).append("/").append(lllllllllllllllIllIlllIIIIIIlIIl).append(" (").append(lllllllllllllllIllIlllIIIIIIlIII.getClass().getSimpleName()).append(") was larger than I expected, found ").append(lllllllllllllllIllIlllIIIIIIlIlI.readableBytes()).append(" bytes extra whilst reading packet ").append(lllllllllllllllIllIlllIIIIIIlIIl)));
            }
            lllllllllllllllIllIlllIIIIIIlIll.add(lllllllllllllllIllIlllIIIIIIlIII);
            if (MessageDeserializer.logger.isDebugEnabled()) {
                MessageDeserializer.logger.debug(MessageDeserializer.RECEIVED_PACKET_MARKER, " IN: [{}:{}] {}", new Object[] { lllllllllllllllIllIlllIIIIIIllIl.channel().attr(NetworkManager.attrKeyConnectionState).get(), lllllllllllllllIllIlllIIIIIIlIIl, lllllllllllllllIllIlllIIIIIIlIII.getClass().getName() });
            }
        }
    }
    
    public MessageDeserializer(final EnumPacketDirection lllllllllllllllIllIlllIIIIIllIII) {
        this.direction = lllllllllllllllIllIlllIIIIIllIII;
    }
}
