package net.minecraft.client.multiplayer;

import java.util.concurrent.atomic.*;
import org.apache.logging.log4j.*;
import java.io.*;
import java.net.*;

public class ThreadLanServerPing extends Thread
{
    private static final /* synthetic */ AtomicInteger field_148658_a;
    private final /* synthetic */ String motd;
    private final /* synthetic */ String address;
    private /* synthetic */ boolean isStopping;
    private final /* synthetic */ DatagramSocket socket;
    private static final /* synthetic */ Logger logger;
    
    public static String getMotdFromPingResponse(final String llllllllllllllIlIlIlIIlllIIlllll) {
        final int llllllllllllllIlIlIlIIlllIlIIIIl = llllllllllllllIlIlIlIIlllIIlllll.indexOf("[MOTD]");
        if (llllllllllllllIlIlIlIIlllIlIIIIl < 0) {
            return "missing no";
        }
        final int llllllllllllllIlIlIlIIlllIlIIIII = llllllllllllllIlIlIlIIlllIIlllll.indexOf("[/MOTD]", llllllllllllllIlIlIlIIlllIlIIIIl + "[MOTD]".length());
        return (llllllllllllllIlIlIlIIlllIlIIIII < llllllllllllllIlIlIlIIlllIlIIIIl) ? "missing no" : llllllllllllllIlIlIlIIlllIIlllll.substring(llllllllllllllIlIlIlIIlllIlIIIIl + "[MOTD]".length(), llllllllllllllIlIlIlIIlllIlIIIII);
    }
    
    static {
        __OBFID = "CL_00001137";
        field_148658_a = new AtomicInteger(0);
        logger = LogManager.getLogger();
    }
    
    @Override
    public void interrupt() {
        super.interrupt();
        this.isStopping = false;
    }
    
    public static String getPingResponse(final String llllllllllllllIlIlIlIIlllIlIIlll, final String llllllllllllllIlIlIlIIlllIlIlIII) {
        return String.valueOf(new StringBuilder("[MOTD]").append(llllllllllllllIlIlIlIIlllIlIIlll).append("[/MOTD][AD]").append(llllllllllllllIlIlIlIIlllIlIlIII).append("[/AD]"));
    }
    
    public static String getAdFromPingResponse(final String llllllllllllllIlIlIlIIlllIIlIlll) {
        final int llllllllllllllIlIlIlIIlllIIlIllI = llllllllllllllIlIlIlIIlllIIlIlll.indexOf("[/MOTD]");
        if (llllllllllllllIlIlIlIIlllIIlIllI < 0) {
            return null;
        }
        final int llllllllllllllIlIlIlIIlllIIlIlIl = llllllllllllllIlIlIlIIlllIIlIlll.indexOf("[/MOTD]", llllllllllllllIlIlIlIIlllIIlIllI + "[/MOTD]".length());
        if (llllllllllllllIlIlIlIIlllIIlIlIl >= 0) {
            return null;
        }
        final int llllllllllllllIlIlIlIIlllIIlIlII = llllllllllllllIlIlIlIIlllIIlIlll.indexOf("[AD]", llllllllllllllIlIlIlIIlllIIlIllI + "[/MOTD]".length());
        if (llllllllllllllIlIlIlIIlllIIlIlII < 0) {
            return null;
        }
        final int llllllllllllllIlIlIlIIlllIIlIIll = llllllllllllllIlIlIlIIlllIIlIlll.indexOf("[/AD]", llllllllllllllIlIlIlIIlllIIlIlII + "[AD]".length());
        return (llllllllllllllIlIlIlIIlllIIlIIll < llllllllllllllIlIlIlIIlllIIlIlII) ? null : llllllllllllllIlIlIlIIlllIIlIlll.substring(llllllllllllllIlIlIlIIlllIIlIlII + "[AD]".length(), llllllllllllllIlIlIlIIlllIIlIIll);
    }
    
    public ThreadLanServerPing(final String llllllllllllllIlIlIlIIllllIIIIII, final String llllllllllllllIlIlIlIIlllIllllll) throws IOException {
        super(String.valueOf(new StringBuilder("LanServerPinger #").append(ThreadLanServerPing.field_148658_a.incrementAndGet())));
        this.isStopping = true;
        this.motd = llllllllllllllIlIlIlIIllllIIIIII;
        this.address = llllllllllllllIlIlIlIIlllIllllll;
        this.setDaemon(true);
        this.socket = new DatagramSocket();
    }
    
    @Override
    public void run() {
        final String llllllllllllllIlIlIlIIlllIlllIII = getPingResponse(this.motd, this.address);
        final byte[] llllllllllllllIlIlIlIIlllIllIlll = llllllllllllllIlIlIlIIlllIlllIII.getBytes();
        while (!this.isInterrupted() && this.isStopping) {
            try {
                final InetAddress llllllllllllllIlIlIlIIlllIllIllI = InetAddress.getByName("224.0.2.60");
                final DatagramPacket llllllllllllllIlIlIlIIlllIllIlIl = new DatagramPacket(llllllllllllllIlIlIlIIlllIllIlll, llllllllllllllIlIlIlIIlllIllIlll.length, llllllllllllllIlIlIlIIlllIllIllI, 4445);
                this.socket.send(llllllllllllllIlIlIlIIlllIllIlIl);
            }
            catch (IOException llllllllllllllIlIlIlIIlllIllIlII) {
                ThreadLanServerPing.logger.warn(String.valueOf(new StringBuilder("LanServerPinger: ").append(llllllllllllllIlIlIlIIlllIllIlII.getMessage())));
                break;
            }
            try {
                Thread.sleep(1500L);
            }
            catch (InterruptedException ex) {}
        }
    }
}
